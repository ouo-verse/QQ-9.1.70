package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.k;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x935.FriendRecommendPushExtData$LockScreenPushExtData;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.pushsvr.pushsvrExt$ExtData;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27$ClientReport;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27$PushPlatform;

/* loaded from: classes15.dex */
public class PushNoticeManager implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    private long C;
    private short D;
    private long E;
    private WeakReferenceHandler F;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f243657d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f243658e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f243659f;

    /* renamed from: h, reason: collision with root package name */
    final SparseArray<Integer> f243660h;

    /* renamed from: i, reason: collision with root package name */
    private RecentItemNoticeData f243661i;

    /* renamed from: m, reason: collision with root package name */
    private MessageForText f243662m;

    public PushNoticeManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243657d = new AtomicBoolean(false);
        this.f243658e = new AtomicInteger(0);
        this.F = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f243659f = qQAppInterface;
        this.f243660h = new SparseArray<>();
    }

    private byte[] b(SubMsgType0x27$PushPlatform subMsgType0x27$PushPlatform) {
        byte[] bArr = null;
        try {
            if (subMsgType0x27$PushPlatform.bytes_ext_data.has()) {
                bArr = subMsgType0x27$PushPlatform.bytes_ext_data.get().toByteArray();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("PushNoticeManager", 2, e16.getMessage(), e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("PushNoticeManager", 2, String.format("getExtBytes extBytes=%s", Arrays.toString(bArr)));
        }
        return bArr;
    }

    private boolean e(SubMsgType0x27$PushPlatform subMsgType0x27$PushPlatform, Bundle bundle, int i3) {
        long j3;
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        List<oidb_0xc26$MayKnowPerson> list;
        int i16;
        if (i3 != 1041) {
            if (i3 != 1042) {
                return true;
            }
            CTEntryMng cTEntryMng = (CTEntryMng) this.f243659f.getManager(QQManagerFactory.CTENTRY_MNG);
            if (cTEntryMng != null) {
                z18 = cTEntryMng.A();
                if (z18 && QLog.isColorLevel()) {
                    QLog.i("PushNoticeManager", 2, "getSPSwitchState user closed");
                }
            } else {
                z18 = false;
            }
            if (!z18) {
                byte[] b16 = b(subMsgType0x27$PushPlatform);
                FriendRecommendPushExtData$LockScreenPushExtData friendRecommendPushExtData$LockScreenPushExtData = new FriendRecommendPushExtData$LockScreenPushExtData();
                if (b16 != null && b16.length > 0) {
                    try {
                        friendRecommendPushExtData$LockScreenPushExtData.mergeFrom(b16);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (friendRecommendPushExtData$LockScreenPushExtData.rpt_msg_persons.has()) {
                        list = friendRecommendPushExtData$LockScreenPushExtData.rpt_msg_persons.get();
                    } else {
                        list = null;
                    }
                    if (friendRecommendPushExtData$LockScreenPushExtData.uint32_push_timestamp.has()) {
                        i16 = friendRecommendPushExtData$LockScreenPushExtData.uint32_push_timestamp.get();
                    } else {
                        i16 = 0;
                    }
                    ArrayList<MayKnowRecommend> covServerDataToLocal = MayKnowRecommend.covServerDataToLocal(list, i16);
                    if (covServerDataToLocal.size() > 0) {
                        bundle.putSerializable("may_know_recmmds", covServerDataToLocal);
                        bundle.putInt("param_push_uinType", i3);
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder("handleExtData pushfrds:");
                        Iterator<MayKnowRecommend> it = covServerDataToLocal.iterator();
                        while (it.hasNext()) {
                            MayKnowRecommend next = it.next();
                            sb5.append(" ");
                            sb5.append(next.uin);
                        }
                        QLog.i("PushNoticeManager", 2, sb5.toString());
                    }
                }
            }
            z17 = false;
        } else {
            byte[] b17 = b(subMsgType0x27$PushPlatform);
            pushsvrExt$ExtData pushsvrext_extdata = new pushsvrExt$ExtData();
            if (b17 != null && b17.length > 0) {
                try {
                    pushsvrext_extdata.mergeFrom(b17);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                if (pushsvrext_extdata.uint64_to_uin.has()) {
                    j3 = pushsvrext_extdata.uint64_to_uin.get();
                } else {
                    j3 = 0;
                }
                if (j3 > 0 && pushsvrext_extdata.str_remark.has()) {
                    bundle.putString("uinname", pushsvrext_extdata.str_remark.get().toStringUtf8());
                    bundle.putString(QQNotificationManager.PARAM_FROMUIN, String.valueOf(j3));
                    bundle.putString("param_push_fromuin", String.valueOf(j3));
                    bundle.putInt("param_push_uinType", i3);
                    bundle.putString("param_push_fromuin", String.valueOf(j3));
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Long.valueOf(j3);
                    if (pushsvrext_extdata.str_remark.has()) {
                        str = pushsvrext_extdata.str_remark.get().toStringUtf8();
                    } else {
                        str = "";
                    }
                    objArr[1] = str;
                    QLog.i("PushNoticeManager", 2, String.format("handleExtData uin=%d nick=%s", objArr));
                }
                z17 = z16;
            }
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PushNoticeManager", 2, String.format("handleExtData uinType=%d valid=%b", Integer.valueOf(i3), Boolean.valueOf(z17)));
        }
        return z17;
    }

    public static void h(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5) {
        k.a aVar = new k.a();
        aVar.f290023e = str4;
        aVar.f290022d = str5;
        aVar.f290024f = str;
        aVar.f290027i = str2;
        com.tencent.mobileqq.statistics.k.b(str3, aVar);
        com.tencent.mobileqq.statistics.k.d(qQAppInterface, aVar);
    }

    private void k(Context context, Intent intent) {
        if (intent.getBooleanExtra("push_notice_unlock", false)) {
            context.startActivity(new Intent(context, (Class<?>) QQLSUnlockActivity.class));
        }
    }

    public void a(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) intent);
            return;
        }
        int intExtra = intent.getIntExtra("forward", -1);
        int intExtra2 = intent.getIntExtra("param_push_uinType", -1);
        int intExtra3 = intent.getIntExtra("param_push_notifyid", -1);
        String stringExtra = intent.getStringExtra("param_push_fromuin");
        i(null, intExtra2);
        if (intExtra != 3) {
            if (intExtra == 4) {
                if (intExtra2 == 1041) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), null);
                    m3.putExtra("uin", stringExtra);
                    m3.putExtra("uintype", 0);
                    m3.putExtra("uinname", intent.getStringExtra("uinname"));
                    m3.putExtra(QQNotificationManager.PARAM_NOTIFYID, intExtra3);
                    m3.putExtra("enterchatwin", true);
                    context.startActivity(m3);
                } else if (intExtra2 == 1042) {
                    Intent intent2 = new Intent(context, (Class<?>) RecommendFriendActivity.class);
                    intent2.putExtra("EntranceId", 9);
                    intent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, intExtra3);
                    intent2.putExtra("may_know_recmmds", intent.getSerializableExtra("may_know_recmmds"));
                    context.startActivity(intent2);
                }
                k(context, intent);
                intent.removeExtra("forward");
                if (QLog.isColorLevel()) {
                    QLog.i("PushNoticeManager", 2, String.format("forward [uinType,notifyId,uin]=[%d,%d,%s]", Integer.valueOf(intExtra2), Integer.valueOf(intExtra3), stringExtra));
                }
            }
        } else {
            String stringExtra2 = intent.getStringExtra("url");
            Intent intent3 = new Intent(context, (Class<?>) QQBrowserActivity.class);
            int intExtra4 = intent.getIntExtra("uintype", -1);
            intent3.putExtra("uintype", intExtra4);
            String stringExtra3 = intent.getStringExtra("push_notice_service_id");
            String stringExtra4 = intent.getStringExtra("push_notice_content_id");
            h(this.f243659f, stringExtra3, stringExtra4, stringExtra2, "0X8009241", "\u70b9\u51fb\u4e1a\u52a1Push");
            intent3.putExtra("push_notice_service_id", stringExtra3);
            intent3.putExtra("push_notice_content_id", stringExtra4);
            if (QLog.isColorLevel()) {
                QLog.d("PushNoticeManager", 2, "remove push notice");
            }
            intent3.putExtra("url", stringExtra2);
            context.startActivity(intent3);
            k(context, intent);
            intent.removeExtra("forward");
            intExtra2 = intExtra4;
        }
        ThreadManagerV2.post(new Runnable(intExtra2) { // from class: com.tencent.mobileqq.managers.PushNoticeManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f243663d;

            {
                this.f243663d = intExtra2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PushNoticeManager.this, intExtra2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.pushnotice.c.e(this.f243663d, 2);
                }
            }
        }, 5, null, true);
    }

    public MessageForText c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MessageForText) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RecentItemNoticeData recentItemNoticeData = this.f243661i;
        if (recentItemNoticeData == null) {
            return null;
        }
        if (this.f243662m == null) {
            MessageForText messageForText = (MessageForText) q.d(-1000);
            this.f243662m = messageForText;
            messageForText.msgtype = -1000;
            messageForText.istroop = this.f243661i.type;
            messageForText.isread = false;
            messageForText.selfuin = this.f243659f.getCurrentAccountUin();
            this.f243662m.senderuin = this.C + "";
            this.f243662m.frienduin = this.C + "";
            MessageForText messageForText2 = this.f243662m;
            messageForText2.f203106msg = recentItemNoticeData.wording;
            messageForText2.time = recentItemNoticeData.time;
        }
        if (recentItemNoticeData.type == 1035) {
            str = recentItemNoticeData.mTitleName;
        } else {
            str = recentItemNoticeData.wording;
        }
        String str2 = this.f243662m.f203106msg;
        if (str2 == null || !str2.equals(str)) {
            this.f243662m.f203106msg = str;
        }
        MessageForText messageForText3 = this.f243662m;
        long j3 = messageForText3.time;
        long j16 = recentItemNoticeData.time;
        if (j3 != j16) {
            messageForText3.time = j16;
        }
        return messageForText3;
    }

    public RecentBaseData d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecentBaseData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f243661i;
    }

    public void f(long j3, String str, String str2, String str3, int i3, int i16, String str4, String str5, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), str4, str5, bundle);
            return;
        }
        if (!QQNotificationManager.getInstance().areNotificationsEnabled(this.f243659f.getApp())) {
            QLog.i("PushNoticeManager", 1, "notifications are disabled");
            return;
        }
        if (!SettingCloneUtil.readValue((Context) this.f243659f.getApp(), this.f243659f.getCurrentUin(), (String) null, AppConstants.QQSETTING_SHOW_PUSH_MESSAGE, true)) {
            if (QLog.isColorLevel()) {
                QLog.i("PushNoticeManager", 2, "show push notice switch off");
                return;
            }
            return;
        }
        if (FriendsStatusUtil.c(this.f243659f.getApp())) {
            QLog.i("PushNoticeManager", 1, "do not disturb");
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.f243659f.getApp());
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 4);
        aliasIntent.setFlags(603979776);
        aliasIntent.putExtra("forward", i3);
        int intValue = (Integer.valueOf(str4).intValue() - 1000) % 30;
        if (intValue < 0) {
            intValue = 0;
        }
        int i17 = intValue + 482;
        aliasIntent.putExtra("url", str2);
        aliasIntent.putExtra("from", "push_notice");
        aliasIntent.putExtra("uintype", i16);
        aliasIntent.putExtra(QQNotificationManager.PARAM_FROMUIN, String.valueOf(j3));
        aliasIntent.putExtra(QQNotificationManager.PARAM_UINTYPE, i16);
        aliasIntent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i17);
        aliasIntent.putExtra("push_notice_tag", "push_notification_tag");
        aliasIntent.putExtra("param_push_notifyid", i17);
        aliasIntent.putExtra("push_notice_service_id", str4);
        aliasIntent.putExtra("push_notice_content_id", str5);
        if (bundle != null) {
            aliasIntent.putExtras(bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushNoticeManager", 2, "onReceiveNotice notifyid" + i17 + "notifyUI url:", str2);
        }
        BaseApplication context = BaseApplication.getContext();
        boolean k3 = QQUtils.k(context);
        QQAppInterface qQAppInterface = this.f243659f;
        if (!qQAppInterface.isBackgroundPause && !qQAppInterface.isBackgroundStop && !k3) {
            if (this.f243658e.incrementAndGet() > 3) {
                if (QLog.isColorLevel()) {
                    QLog.i("PushNoticeManager", 2, "delay push notice reach the max retry");
                    return;
                }
                return;
            } else {
                RecentItemNoticeData recentItemNoticeData = this.f243661i;
                if (recentItemNoticeData != null) {
                    recentItemNoticeData.r(aliasIntent);
                }
                this.f243657d.set(true);
                return;
            }
        }
        this.f243657d.set(false);
        this.f243658e.set(0);
        String[] strArr = {str, str3, str};
        RecentItemNoticeData recentItemNoticeData2 = this.f243661i;
        if (recentItemNoticeData2 != null) {
            recentItemNoticeData2.r(aliasIntent);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f243659f.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        toServiceMsg.extraData.putStringArray("cmds", strArr);
        toServiceMsg.extraData.putParcelable("intent", aliasIntent);
        toServiceMsg.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, null);
        this.f243659f.sendToService(toServiceMsg);
        synchronized (this.f243660h) {
            this.f243660h.put(i17, Integer.valueOf(i16));
        }
        if (k3) {
            i iVar = (i) this.f243659f.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
            if (SettingCloneUtil.readValue((Context) context, this.f243659f.getCurrentAccountUin(), context.getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true)) {
                if (QLog.isColorLevel()) {
                    QLog.d("PushNoticeManager", 2, "push notice start lsActivity from appinterface ");
                }
                iVar.f(this.f243659f, j3 + "", i16, false, i17);
            }
            this.f243659f.getMessageFacade().notifyObservers(d());
        }
        com.tencent.mobileqq.pushnotice.c.e(i16, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(SubMsgType0x27$MsgBody subMsgType0x27$MsgBody, short s16, long j3) {
        SubMsgType0x27$PushPlatform subMsgType0x27$PushPlatform;
        int i3;
        String str;
        String str2;
        boolean z16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, subMsgType0x27$MsgBody, Short.valueOf(s16), Long.valueOf(j3));
            return;
        }
        if (subMsgType0x27$MsgBody != null && (subMsgType0x27$PushPlatform = subMsgType0x27$MsgBody.msg_push_platform) != null) {
            if (s16 == this.D && j3 == this.E) {
                QLog.w("PushNoticeManager", 1, "skip duplicated msg: " + ((int) s16) + ", " + j3);
                return;
            }
            this.D = s16;
            this.E = j3;
            int i17 = subMsgType0x27$PushPlatform.uint32_forward_type.get();
            if (i17 == 0) {
                i3 = 3;
            } else if (i17 == 1) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                QLog.w("PushNoticeManager", 1, "unknown forward type: " + i3);
                return;
            }
            SubMsgType0x27$ClientReport subMsgType0x27$ClientReport = subMsgType0x27$MsgBody.msg_client_report;
            long j16 = subMsgType0x27$PushPlatform.uint64_from_uin.get();
            this.C = j16;
            String str3 = null;
            if (subMsgType0x27$PushPlatform.str_desc.has()) {
                str = subMsgType0x27$PushPlatform.str_desc.get();
            } else {
                str = null;
            }
            if (subMsgType0x27$PushPlatform.str_target_url.has()) {
                String str4 = subMsgType0x27$PushPlatform.str_target_url.get();
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        str2 = new String(com.tencent.mobileqq.musicpendant.a.a(str4), "UTF-8");
                    } catch (Exception e16) {
                        QLog.e("PushNoticeManager", 1, e16, new Object[0]);
                    }
                } else {
                    str2 = str4;
                }
                if (subMsgType0x27$PushPlatform.str_title.has()) {
                    str3 = subMsgType0x27$PushPlatform.str_title.get();
                }
                if (str3 == null) {
                    str3 = "";
                }
                if (QLog.isColorLevel()) {
                    QLog.i("PushNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [uin: %d wording: %s url: %s from: %s oriUrl:%s", Long.valueOf(j16), str, str2, str3, subMsgType0x27$PushPlatform.str_target_url.get()));
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    int i18 = 1035;
                    if (4 == i3) {
                        if (TextUtils.equals(str2, "newfrd_add")) {
                            i18 = 1041;
                        }
                        if (TextUtils.equals(str2, "newfrd_recommand")) {
                            i18 = 1042;
                        }
                    }
                    int i19 = i18;
                    com.tencent.mobileqq.pushnotice.c.e(i19, 0);
                    Bundle bundle = new Bundle();
                    try {
                        z16 = e(subMsgType0x27$PushPlatform, bundle, i19);
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PushNoticeManager", 2, e17.getMessage(), e17);
                        }
                        z16 = false;
                    }
                    if (!z16) {
                        return;
                    }
                    if (i19 == 1041) {
                        j16 = Long.valueOf(bundle.getString(QQNotificationManager.PARAM_FROMUIN)).longValue();
                        this.C = j16;
                    }
                    if (QLog.isColorLevel()) {
                        i16 = 1;
                        QLog.i("PushNoticeManager", 2, String.format("onReceiveNotice [uinType,uin]=[%d,%d]", Integer.valueOf(i19), Long.valueOf(j16)));
                    } else {
                        i16 = 1;
                    }
                    this.F.removeMessages(i16);
                    k.a aVar = new k.a();
                    aVar.f290023e = "0X800923D";
                    aVar.f290022d = "\u6536\u5230Push\u534f\u8bae";
                    aVar.f290024f = subMsgType0x27$ClientReport.uint32_service_id.get() + "";
                    aVar.f290027i = subMsgType0x27$ClientReport.str_content_id.get();
                    com.tencent.mobileqq.statistics.k.b(str2, aVar);
                    com.tencent.mobileqq.statistics.k.d(this.f243659f, aVar);
                    long K0 = com.tencent.mobileqq.service.message.e.K0();
                    RecentUser recentUser = new RecentUser();
                    recentUser.uin = j16 + "";
                    recentUser.msgType = i19;
                    recentUser.setType(i19);
                    RecentItemNoticeData recentItemNoticeData = this.f243661i;
                    if (recentItemNoticeData == null) {
                        RecentItemNoticeData recentItemNoticeData2 = new RecentItemNoticeData(recentUser);
                        this.f243661i = recentItemNoticeData2;
                        String str5 = str2;
                        recentItemNoticeData2.p(i19, j16, str, str5, str3, K0);
                        f(j16, str, str5, str3, i3, i19, aVar.f290024f, aVar.f290027i, bundle);
                        return;
                    }
                    String str6 = str2;
                    if (!recentItemNoticeData.q(i19, j16, str, str6, str3, K0)) {
                        this.f243661i.p(i19, j16, str, str6, str3, K0);
                        f(j16, str, str6, str3, i3, i19, aVar.f290024f, aVar.f290027i, bundle);
                        return;
                    }
                    return;
                }
            }
            str2 = null;
            if (subMsgType0x27$PushPlatform.str_title.has()) {
            }
            if (str3 == null) {
            }
            if (QLog.isColorLevel()) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what != 1) {
            return false;
        }
        RecentItemNoticeData recentItemNoticeData = this.f243661i;
        if (recentItemNoticeData == null) {
            QLog.e("PushNoticeManager", 1, "recent data is null");
            return true;
        }
        f(recentItemNoticeData.uin, recentItemNoticeData.wording, recentItemNoticeData.url, recentItemNoticeData.from, recentItemNoticeData.intent.getIntExtra("forward", -1), 0, this.f243661i.intent.getStringExtra("push_notice_service_id"), this.f243661i.intent.getStringExtra("push_notice_content_id"), null);
        return true;
    }

    public void i(QQNotificationManager qQNotificationManager, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQNotificationManager, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushNoticeManager", 2, "setRead " + i3);
        }
        this.F.removeMessages(1);
        this.f243657d.set(false);
        this.f243661i = null;
        if (qQNotificationManager == null) {
            try {
                qQNotificationManager = QQNotificationManager.getInstance();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PushNoticeManager", 2, "setRead", e16);
                    return;
                }
                return;
            }
        }
        synchronized (this.f243660h) {
            for (int i16 = 0; i16 < this.f243660h.size(); i16++) {
                Integer valueOf = Integer.valueOf(this.f243660h.keyAt(i16));
                Integer valueAt = this.f243660h.valueAt(i16);
                if (valueOf != null && (i3 < 0 || valueAt == null || valueAt.intValue() == i3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PushNoticeManager", 2, String.format(Locale.getDefault(), "cancel push_notice [%d, %s]", Integer.valueOf(valueOf.intValue()), "push_notification_tag"));
                    }
                    qQNotificationManager.cancelUseTag("PushNoticeManager_removeNotification", "push_notification_tag", valueOf.intValue());
                }
            }
            this.f243660h.clear();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.f243657d.get()) {
            if (QLog.isColorLevel()) {
                QLog.i("PushNoticeManager", 2, "nothing to show");
            }
        } else if (this.f243661i == null) {
            QLog.w("PushNoticeManager", 1, "recent data is null");
        } else {
            this.F.sendEmptyMessageDelayed(1, 30000L);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushNoticeManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        i(null, -1);
    }
}
