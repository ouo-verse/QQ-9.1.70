package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.ci;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElementType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.util.LogUtil;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.nt_msg_common$Msg;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoMsgTools {

    /* renamed from: a, reason: collision with root package name */
    static Map<String, String> f76889a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class MygetGroupInfoRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f76911d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<QQAppInterface> f76912e;

        /* renamed from: f, reason: collision with root package name */
        String f76913f;

        public MygetGroupInfoRunnable(long j3, QQAppInterface qQAppInterface, String str) {
            this.f76911d = j3;
            this.f76912e = new WeakReference<>(qQAppInterface);
            this.f76913f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QQAppInterface qQAppInterface = this.f76912e.get();
            if (qQAppInterface != null) {
                cp.i("addGroupMember_" + this.f76911d, qQAppInterface, this.f76913f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f76914a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f76915b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f76916c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f76917d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f76918e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f76919f;

        a(long j3, String str, String str2, int i3, String str3, long j16) {
            this.f76914a = j3;
            this.f76915b = str;
            this.f76916c = str2;
            this.f76917d = i3;
            this.f76918e = str3;
            this.f76919f = j16;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            QLog.w("VideoMsgTools", 4, "addLocalAVRecordMsg#onResult, [after add], msgTimeFinal[" + this.f76914a + "], peerUid[" + this.f76915b + "], senderUid[" + this.f76916c + "], noticeType[" + this.f76917d + "], msgStr[" + this.f76918e + "], sendTime[" + this.f76919f + "]");
        }
    }

    static void A(BaseApplicationImpl baseApplicationImpl, boolean z16, long j3, ArrayList<ResultRecord> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "sendAddMemberResultBroadcastToVideo");
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().uin);
        }
        Intent intent = new Intent("tencent.video.q2v.AddDiscussMember");
        intent.setPackage(baseApplicationImpl.getPackageName());
        intent.putExtra("result", z16);
        intent.putExtra("roomId", j3);
        intent.putStringArrayListExtra("newMemberUin", arrayList2);
        baseApplicationImpl.sendBroadcast(intent);
    }

    static void B(QQAppInterface qQAppInterface, String str, int i3) {
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(62).d(qQAppInterface.getApp().getApplicationContext().getString(R.string.dli)).j("https://im.qq.com/mobileqq/touch").i(qQAppInterface.getApp().getApplicationContext().getString(R.string.dlj), null).a();
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
        c16.o("https://url.cn/hw298C", qQAppInterface.getApp().getApplicationContext().getString(R.string.dlo), qQAppInterface.getApp().getApplicationContext().getString(R.string.dlm));
        a16.addItem(c16);
        ShareMsgHelper.g(qQAppInterface, str, 0, a16, null);
    }

    public static void C(QQAppInterface qQAppInterface, String str, String str2, String str3, INetEngineListener iNetEngineListener) {
        String str4;
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "sendHttpReq requestUrl  = " + str + ", actid = " + str2);
        }
        if (qQAppInterface == null) {
            return;
        }
        try {
            String host = new URL(str).getHost();
            if (TextUtils.isEmpty(host) || !host.endsWith(QQWinkConstants.VALID_HOST)) {
                str4 = "";
            } else {
                str4 = qQAppInterface.getAccount();
            }
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = iNetEngineListener;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutStream = new ci(ByteArrayPool.getMaxBufInstance(), 153600);
            if (str3 == null) {
                str3 = "";
            }
            httpNetReq.mReqUrl = str + "g_tk=0&actid=" + str2 + "&mp_ext_params=" + URLUtil.encodeUrl(str3);
            if (QLog.isColorLevel()) {
                QLog.i("VideoMsgTools", 2, "req.mReqUrl=" + httpNetReq.mReqUrl);
            }
            httpNetReq.mUseByteArrayPool = true;
            httpNetReq.mExcuteTimeLimit = 30000L;
            httpNetReq.mReqProperties.put("Connection", "Keep-Alive");
            httpNetReq.mReqProperties.put("Cookie", String.format("uin=o%s; skey=%s;", str4, ""));
            ((IHttpEngineService) qQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("VideoMsgTools", 2, "sendHttpReq : ", th5);
            }
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(long j3, BaseApplicationImpl baseApplicationImpl, int i3, boolean z16, long j16, ArrayList<ResultRecord> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.w("double_2_multi", 2, "sendResultBroadcastToVideoBySwitch, seq[" + j3 + "], roomId[" + j16 + "], seq[" + j3 + "], uinType[" + i3 + "]");
        }
        Intent intent = new Intent("tencent.video.q2v.SwitchToMultiAudo");
        intent.setPackage(baseApplicationImpl.getPackageName());
        intent.putExtra("result", z16);
        intent.putExtra("roomId", j16);
        intent.putExtra("uinType", i3);
        at.f(intent, j3);
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().uin);
        }
        intent.putStringArrayListExtra("memberUin", arrayList2);
        baseApplicationImpl.sendBroadcast(intent);
        if (i3 == 3000 && z16) {
            ((com.tencent.mobileqq.qcall.f) baseApplicationImpl.getRuntime().getManager(QQManagerFactory.RECENT_CALL_FACADE)).c(1, j16, "", "");
        }
    }

    public static void E(QQAppInterface qQAppInterface, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "send_struct_massage_upgrade.peerUin = " + str + ", type = " + i3);
        }
        SharedPreferences X0 = ea.X0(qQAppInterface.getCurrentAccountUin());
        String str2 = null;
        if (i3 != 0) {
            if (i3 == 1) {
                str2 = X0.getString(AppConstants.Preferences.QAV_UPGRADE_INVITE_MULTI, null);
            }
        } else {
            str2 = X0.getString(AppConstants.Preferences.QAV_UPGRADE_INVITE_VIDEO, null);
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoMsgTools", 2, "configXML : " + str2);
        }
        if (str2 != null) {
            B(qQAppInterface, str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoMsgTools", 2, "configXML is null! use default");
        }
        B(qQAppInterface, str, i3);
    }

    public static void F(QQAppInterface qQAppInterface, int i3, String str, String str2, byte[] bArr) {
        com.tencent.mobileqq.service.message.e msgCache = qQAppInterface.getMsgCache();
        if (i3 == 1021) {
            msgCache.l(str, bArr);
        }
    }

    private static void G(final QQAppInterface qQAppInterface, int i3, final int i16, final boolean z16, final String str, final String str2, final String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "showGuideBar uinType: " + i3 + ", msgType: " + i16 + ", isVideoMsg: " + z16 + ", friendUin: " + str + ", selfUin: " + str2 + ", videoTime: " + str3 + ", msgStr: " + str4);
        }
        if (1008 == i3) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoMsgTools", 2, "public account should not show guide bar.");
                return;
            }
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.av.utils.VideoMsgTools.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                int lastFunCallID;
                int i17;
                int i18 = i16;
                if (i18 == 12 || i18 == 25 || i18 == 42 || i18 == 43 || i18 == 56) {
                    VipFunCallUtil.setLastFunCallID(qQAppInterface, 0);
                }
                if (!z16 && (((i17 = i16) == 0 || i17 == 2 || i17 == 24) && str3 != null && com.tencent.mobileqq.activity.aio.tips.c.a())) {
                    SharedPreferences preferences = qQAppInterface.getPreferences();
                    if (!preferences.getBoolean("lightalk_tip_" + str2, false)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("LightalkBlueTipsBar", 2, "addBubbleVideoMsg() : TYPE_ON_SHOW =====>");
                        }
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putBoolean("lightalk_tip_" + str2, true);
                        edit.putString("Lightalk_tips_frdUin", str);
                        edit.commit();
                        z17 = true;
                        lastFunCallID = VipFunCallUtil.getLastFunCallID(qQAppInterface);
                        QQAppInterface qQAppInterface2 = qQAppInterface;
                        int resIdByUin = VipFunCallUtil.getResIdByUin(qQAppInterface2, qQAppInterface2.getAccount(), 6, true, null);
                        if (lastFunCallID == 0 && lastFunCallID != resIdByUin) {
                            QQAppInterface qQAppInterface3 = qQAppInterface;
                            VipFunCallUtil.needToShowTip(qQAppInterface3, str, qQAppInterface3.getAccount());
                            if (!z16 && !z17) {
                                SharedPreferences preferences2 = qQAppInterface.getPreferences();
                                int i19 = preferences2.getInt("funcall_tip_" + str, 0);
                                if (i19 < 3) {
                                    SharedPreferences.Editor edit2 = preferences2.edit();
                                    edit2.putInt("funcall_tip_" + str, i19 + 1);
                                    edit2.commit();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
                z17 = false;
                lastFunCallID = VipFunCallUtil.getLastFunCallID(qQAppInterface);
                QQAppInterface qQAppInterface22 = qQAppInterface;
                int resIdByUin2 = VipFunCallUtil.getResIdByUin(qQAppInterface22, qQAppInterface22.getAccount(), 6, true, null);
                if (lastFunCallID == 0) {
                }
            }
        });
    }

    private static void c(QQAppInterface qQAppInterface, int i3, int i16, boolean z16, String str, String str2, boolean z17, String str3, boolean z18, Object... objArr) {
        long j3;
        long j16;
        boolean z19;
        String str4;
        String str5;
        Object obj;
        Object obj2;
        QLog.d("VideoMsgTools", 1, "addBubbleVideoMsg uinType = " + i3 + ", msgType = " + i16 + ", friendUin = " + str + ", senderUin = " + str2 + ", isSender = " + z17 + ", time = " + str3 + ", isRead = " + z18);
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String t16 = t(qQAppInterface.getApp(), i16, i3, z17, str3);
        String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(t16, (long) i16, 3, z16);
        if (objArr != null && objArr.length > 0 && (obj2 = objArr[0]) != null && (obj2 instanceof msg_comm$Msg)) {
            j3 = ((msg_comm$Msg) obj2).msg_head.get().msg_time.get();
        } else {
            j3 = 0;
        }
        if (objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && (obj instanceof nt_msg_common$Msg)) {
            j16 = ((nt_msg_common$Msg) obj).content_head.msg_time.get();
        } else {
            j16 = j3;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (str2.equals(str)) {
                z19 = false;
            } else {
                z19 = z17;
            }
            boolean z26 = z19;
            G(qQAppInterface, i3, i16, z16, str, currentAccountUin, str3, makeTransFileProtocolData);
            if (QLog.isColorLevel()) {
                QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg end");
            }
            if (j16 == 0) {
                str4 = t16;
                str5 = str;
                j(qQAppInterface, com.tencent.nt.adapter.session.c.l(i3), z26 ? 1 : 0, q(i16, z16, z26), str2, str, j16, str4, z16, z18);
            } else {
                str4 = t16;
                str5 = str;
                k(qQAppInterface, com.tencent.nt.adapter.session.c.l(i3), z26 ? 1 : 0, q(i16, z16, z26), str2, str, j16, str4, z16, z18, j16);
            }
            p(qQAppInterface, str5, i16, str4);
            return;
        }
        QLog.i("VideoMsgTools", 1, "addBubbleVideoMsg, illegal param, [" + str2 + "," + str + "]");
    }

    public static void d(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + str);
        }
        ArrayList<DiscussionMemberInfo> m3 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).m(str);
        ArrayList<String> arrayList = new ArrayList<>();
        if (m3 != null) {
            int size = m3.size();
            for (int i3 = 0; i3 < size; i3++) {
                DiscussionMemberInfo discussionMemberInfo = m3.get(i3);
                if (discussionMemberInfo != null) {
                    arrayList.add(discussionMemberInfo.memberUin);
                }
            }
        }
        ResultReceiver resultReceiver = new ResultReceiver(new Handler()) { // from class: com.tencent.av.utils.VideoMsgTools.3
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                int i17;
                e.m("addDiscussMember", bundle);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addDiscussMember onReceiveResult, resultCode[");
                sb5.append(i16);
                sb5.append("], chooserList[");
                if (parcelableArrayList != null) {
                    i17 = parcelableArrayList.size();
                } else {
                    i17 = -1;
                }
                sb5.append(i17);
                sb5.append("]");
                boolean z16 = true;
                QLog.w("VideoMsgTools", 1, sb5.toString());
                if (i16 != -1) {
                    z16 = false;
                }
                if (z16 && parcelableArrayList != null) {
                    VideoMsgTools.A(BaseApplicationImpl.getApplication(), z16, bundle.getLong("roomId"), parcelableArrayList);
                }
            }
        };
        Intent intent = new Intent();
        intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str);
        intent.putExtra("param_type", 3000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 11);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 100 - arrayList.size());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, qQAppInterface.getApplication().getString(R.string.dfb));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, qQAppInterface.getApplication().getString(R.string.ano));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, qQAppInterface.getApplication().getString(R.string.anp));
        intent.putExtra("PARAM_ActivityResultReceiver", resultReceiver);
        intent.addFlags(268435456);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(qQAppInterface.getApplicationContext(), intent);
    }

    public static void e(QQAppInterface qQAppInterface, Context context, Intent intent) {
        boolean z16;
        if (QLog.isColorLevel()) {
            e.n("VideoMsgTools.addGroupMember", intent.getExtras(), true);
        }
        final String stringExtra = intent.getStringExtra("uin");
        long longExtra = intent.getLongExtra(AudienceReportConst.ROOM_ID, 0L);
        int intExtra = intent.getIntExtra("room_create_time", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("memberlist");
        final long a16 = at.a(intent);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addGroupMember begin, uin[");
        sb5.append(stringExtra);
        sb5.append("], roomID[");
        sb5.append(longExtra);
        sb5.append("], sTopActivity[");
        if (BaseActivity.sTopActivity != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("], seq[");
        sb5.append(a16);
        sb5.append("]");
        String str = "VideoMsgTools";
        QLog.w("VideoMsgTools", 1, sb5.toString());
        Intent intent2 = new Intent();
        intent2.addFlags(268435456);
        ArrayList<String> arrayList = new ArrayList<>(parcelableArrayListExtra.size());
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            Iterator it5 = it;
            ResultRecord resultRecord = (ResultRecord) it.next();
            String str2 = str;
            if (Utils.M(resultRecord.uin)) {
                arrayList.add(resultRecord.uin);
            }
            it = it5;
            str = str2;
        }
        String str3 = str;
        boolean d16 = cp.d(qQAppInterface, stringExtra);
        if (d16) {
            com.tencent.av.share.a.p();
        }
        int min = Math.min(cp.n(), Math.max(cp.m() - parcelableArrayListExtra.size(), 0));
        intent2.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent2.putExtra("room_create_time", intExtra);
        intent2.putExtra(AudienceReportConst.ROOM_ID, longExtra);
        intent2.putExtra("group_uin", stringExtra);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, stringExtra);
        intent2.putExtra("param_type", 1);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 1);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 11);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_MAX, min);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_ShowInviteEntry, d16);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, context.getString(R.string.dfb));
        intent2.putExtra("group_name", context.getString(R.string.dfa));
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, context.getString(R.string.ano));
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, context.getString(R.string.anp));
        e.n("VideoMsgToolsaddGroupMember", intent2.getExtras(), true);
        intent2.putExtra("PARAM_ActivityResultReceiver", new ResultReceiver(new Handler()) { // from class: com.tencent.av.utils.VideoMsgTools.6
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                int i16;
                boolean z17;
                boolean z18;
                e.m("addGroupMember_" + a16, bundle);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("addGroupMember onReceiveResult, resultCode[");
                sb6.append(i3);
                sb6.append("], chooserList[");
                if (parcelableArrayList != null) {
                    i16 = parcelableArrayList.size();
                } else {
                    i16 = -1;
                }
                sb6.append(i16);
                sb6.append("]");
                boolean z19 = true;
                QLog.w("VideoMsgTools", 1, sb6.toString());
                if (i3 == -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && parcelableArrayList != null) {
                    ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET_For_out_Member);
                    if (parcelableArrayList2 == null) {
                        parcelableArrayList2 = new ArrayList();
                    }
                    if (parcelableArrayList.size() > parcelableArrayList2.size()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (parcelableArrayList2.size() <= 0) {
                        z19 = false;
                    }
                    DataReport.B(z18, z19);
                    new Handler(Looper.getMainLooper()).postDelayed(new MygetGroupInfoRunnable(a16, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), stringExtra), 1000L);
                    VideoMsgTools.A(BaseApplicationImpl.getApplication(), z17, bundle.getLong("roomId"), parcelableArrayList);
                }
            }
        });
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            baseActivity.overridePendingTransition(R.anim.f154454a3, 0);
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(qQAppInterface.getApplicationContext(), intent2);
        QLog.w(str3, 1, "addGroupMember end, uin[" + stringExtra + "], seq[" + a16 + "]");
    }

    public static void f(QQAppInterface qQAppInterface, String str, int i3) {
        int i16;
        final long d16 = e.d();
        if (i3 == 1) {
            i16 = 8;
        } else {
            i16 = 48;
        }
        if (QLog.isColorLevel()) {
            QLog.w("double_2_multi", 1, "addMemberFromC2C, seq[" + d16 + "], peerUin[" + str + "], supportUinType[" + i3 + "], max[" + i16 + "]");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        Intent intent = new Intent();
        intent.putExtra("param_type", i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1001);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 36);
        intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i16);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, qQAppInterface.getApplication().getString(R.string.dfb));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, qQAppInterface.getApplication().getString(R.string.ano));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, qQAppInterface.getApplication().getString(R.string.anp));
        intent.putExtra("PARAM_ActivityResultReceiver", new ResultReceiver(new Handler()) { // from class: com.tencent.av.utils.VideoMsgTools.4
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i17, Bundle bundle) {
                boolean z16;
                e.m("addMemberFromC2C", bundle);
                int i18 = -1;
                if (i17 == -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int i19 = bundle.getInt(ISelectMemberActivityConstants.Result_UinType, 3000);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                long j3 = bundle.getLong("roomId");
                if (i19 == 1) {
                    try {
                        j3 = Long.parseLong(bundle.getString(ISelectMemberActivityConstants.Result_Uin));
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        QLog.w("double_2_multi", 1, "addMemberFromC2C", th5);
                    }
                }
                long j16 = j3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addMemberFromC2C onReceiveResult, resultCode[");
                sb5.append(i17);
                sb5.append("], chooserList[");
                if (parcelableArrayList != null) {
                    i18 = parcelableArrayList.size();
                }
                sb5.append(i18);
                sb5.append("], seq[");
                sb5.append(d16);
                sb5.append("], uinType[");
                sb5.append(i19);
                sb5.append("], roomId[");
                sb5.append(j16);
                sb5.append("]");
                QLog.w("double_2_multi", 1, sb5.toString());
                if (z16 && parcelableArrayList != null && j16 != 0) {
                    VideoMsgTools.D(d16, BaseApplicationImpl.getApplication(), i19, z16, j16, parcelableArrayList);
                }
            }
        });
        intent.addFlags(268435456);
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            baseActivity.overridePendingTransition(R.anim.f154454a3, 0);
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(qQAppInterface.getApplicationContext(), intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void g(QQAppInterface qQAppInterface, int i3, String str, String str2, boolean z16, boolean z17, int i16, Object... objArr) {
        int i17;
        long j3;
        int i18;
        long j16;
        long j17;
        int i19;
        long j18;
        String str3;
        String str4;
        String str5;
        long j19;
        String str6;
        String str7;
        int i26;
        String str8;
        String str9;
        int i27;
        String string;
        String string2;
        int i28;
        long j26;
        long j27;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        int i29;
        int i36;
        Object obj;
        Object obj2;
        Object obj3;
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
        long longValue = Long.valueOf(str).longValue();
        int l3 = aVNotifyCenter.l(longValue);
        if (i16 != 0) {
            l3 = i16;
        }
        if (i3 == 3000) {
            i17 = 1;
        } else {
            i17 = l3;
        }
        if (!f76889a.containsKey(str + String.valueOf(i17))) {
            f76889a.put(str + String.valueOf(i17), "add");
        }
        if (!TextUtils.isEmpty(str) && str.length() > 2) {
            if (objArr != null && objArr.length > 0 && (obj3 = objArr[0]) != null && (obj3 instanceof msg_comm$Msg)) {
                j3 = ((msg_comm$Msg) obj3).msg_head.get().msg_time.get();
            } else {
                j3 = 0;
            }
            if (objArr != null && objArr.length > 0 && (obj2 = objArr[0]) != null && (obj2 instanceof nt_msg_common$Msg)) {
                j3 = ((nt_msg_common$Msg) obj2).content_head.msg_time.get();
            }
            if (objArr != null && objArr.length >= 2 && (obj = objArr[0]) != null && (obj instanceof Long)) {
                i18 = 1;
                Object obj4 = objArr[1];
                if (obj4 != null && (obj4 instanceof Long)) {
                    long longValue2 = ((Long) obj).longValue();
                    long longValue3 = ((Long) objArr[1]).longValue();
                    if (longValue2 != 0) {
                        j3 = longValue2;
                    }
                    if (longValue3 != 0) {
                        i19 = 3000;
                        j16 = j3;
                        j17 = longValue3;
                        if (i3 != i19) {
                            String string3 = qQAppInterface.getApp().getString(R.string.dcd);
                            if (j16 == 0) {
                                j18 = j16;
                                str7 = "VideoMsgTools";
                                str3 = "], friendUin[";
                                str4 = "]";
                                str5 = "], senderUin[";
                                i36 = i17;
                                j19 = j17;
                                j(qQAppInterface, 3, z16 ? 1 : 0, LocalAVRecordElementType.KGROUPAUDIO.ordinal(), str2, str, j18, string3, false, true);
                                str6 = currentAccountUin;
                            } else {
                                j18 = j16;
                                str3 = "], friendUin[";
                                str4 = "]";
                                str5 = "], senderUin[";
                                i36 = i17;
                                j19 = j17;
                                str7 = "VideoMsgTools";
                                str6 = currentAccountUin;
                                k(qQAppInterface, 3, z16 ? 1 : 0, LocalAVRecordElementType.KGROUPAUDIO.ordinal(), str2, str, j18, string3, false, true, j18);
                            }
                            str9 = string3;
                            i26 = i36;
                        } else {
                            j18 = j16;
                            str3 = "], friendUin[";
                            str4 = "]";
                            str5 = "], senderUin[";
                            int i37 = i17;
                            j19 = j17;
                            str6 = currentAccountUin;
                            str7 = "VideoMsgTools";
                            if (i3 == i18) {
                                if (i37 == 10) {
                                    str8 = qQAppInterface.getApp().getString(R.string.dcw);
                                    if (j18 == 0) {
                                        j18 = j18;
                                        j(qQAppInterface, 2, z16 ? 1 : 0, LocalAVRecordElementType.KGROUPAUDIO.ordinal(), str2, str, j18, str8, false, z17);
                                        i26 = i37;
                                    } else {
                                        j18 = j18;
                                        i26 = i37;
                                        k(qQAppInterface, 2, z16 ? 1 : 0, LocalAVRecordElementType.KGROUPAUDIO.ordinal(), str2, str, j18, str8, false, z17, j18);
                                    }
                                } else {
                                    i26 = i37;
                                    AVNotifyCenter.i Q = qQAppInterface.getAVNotifyCenter().Q(longValue, i26);
                                    if (Q != null) {
                                        i27 = Q.f73813g;
                                    } else {
                                        i27 = 0;
                                    }
                                    if (Q != null && Q.b()) {
                                        string = qQAppInterface.getApp().getString(R.string.f171232w32);
                                        j(qQAppInterface, 2, 0, LocalAVRecordElementType.KNOTICEGROUPCLASS.ordinal(), str2, str, j18, string, true, true);
                                    } else if (Q != null && Q.a()) {
                                        if (VideoUtil.i()) {
                                            string2 = qQAppInterface.getApp().getString(R.string.f1781035r);
                                        } else {
                                            string2 = qQAppInterface.getApp().getString(R.string.f1780935q);
                                        }
                                        string = string2;
                                        j(qQAppInterface, 2, 0, LocalAVRecordElementType.KNOTICEVIDEOCHAT.ordinal(), str2, str, j18, string, true, true);
                                    } else if (Q != null && Q.c()) {
                                        string = qQAppInterface.getApp().getString(R.string.f1781135s);
                                        j(qQAppInterface, 2, 0, LocalAVRecordElementType.KNOTICEVIDEOCHAT.ordinal(), str2, str, j18, string, true, true);
                                    } else {
                                        string = qQAppInterface.getApp().getString(R.string.dcv);
                                        j(qQAppInterface, 2, 0, LocalAVRecordElementType.KNOTICEVIDEOCHAT.ordinal(), str2, str, j18, string, true, true);
                                    }
                                    i28 = i27;
                                    str9 = string;
                                    String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str9, 13L, 3, true);
                                    MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MULTI_VIDEO);
                                    d16.selfuin = str6;
                                    d16.frienduin = str;
                                    d16.senderuin = str2;
                                    d16.f203106msg = makeTransFileProtocolData + "|" + i26 + "|" + i28;
                                    d16.msgtype = MessageRecord.MSG_TYPE_MULTI_VIDEO;
                                    d16.isread = z17;
                                    if (i3 == 3000) {
                                        d16.isread = true;
                                    }
                                    if (z16) {
                                        d16.issend = 1;
                                    } else {
                                        d16.issend = 0;
                                    }
                                    d16.istroop = i3;
                                    d16.extraflag = 3;
                                    j26 = j19;
                                    if (j26 != 0) {
                                        d16.shmsgseq = j26;
                                    }
                                    d16.extInt = i26;
                                    j27 = j18;
                                    if (j27 > 0) {
                                        d16.time = j27;
                                    } else {
                                        d16.time = com.tencent.mobileqq.service.message.e.K0();
                                    }
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        str10 = str9;
                                        sb5.append("addMultiVideoMsg, [before add], uinType[");
                                        sb5.append(i3);
                                        sb5.append(str3);
                                        sb5.append(str);
                                        sb5.append(str5);
                                        sb5.append(str2);
                                        sb5.append("], time[");
                                        sb5.append(d16.time);
                                        sb5.append("], seq[");
                                        sb5.append(d16.shmsgseq);
                                        sb5.append("], sendTime[");
                                        sb5.append(j27);
                                        sb5.append("], msgSeq[");
                                        sb5.append(j26);
                                        sb5.append("], uniseq[");
                                        sb5.append(d16.uniseq);
                                        str12 = str4;
                                        sb5.append(str12);
                                        String sb6 = sb5.toString();
                                        str11 = str7;
                                        QLog.w(str11, 2, sb6);
                                    } else {
                                        str10 = str9;
                                        str11 = str7;
                                        str12 = str4;
                                    }
                                    qQAppInterface.getMsgHandler().J2(d16, z17);
                                    if (!TextUtils.isEmpty(str10)) {
                                        str13 = str12;
                                        str14 = str11;
                                        i29 = i3;
                                        CUOpenCardGuideMng.a(qQAppInterface, d16.frienduin, i29, true, "qav");
                                    } else {
                                        str13 = str12;
                                        str14 = str11;
                                        i29 = i3;
                                    }
                                    if (QLog.isDevelopLevel()) {
                                        QLog.w(str14, 4, "addMultiVideoMsg, [after add], uinType[" + i29 + str3 + str + str5 + str2 + "], time[" + d16.time + "], seq[" + d16.shmsgseq + "], sendTime[" + j27 + "], msgSeq[" + j26 + "], uniseq[" + d16.uniseq + str13);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                i26 = i37;
                                str8 = null;
                            }
                            str9 = str8;
                        }
                        i28 = 0;
                        String makeTransFileProtocolData2 = TransfileUtile.makeTransFileProtocolData(str9, 13L, 3, true);
                        MessageRecord d162 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MULTI_VIDEO);
                        d162.selfuin = str6;
                        d162.frienduin = str;
                        d162.senderuin = str2;
                        d162.f203106msg = makeTransFileProtocolData2 + "|" + i26 + "|" + i28;
                        d162.msgtype = MessageRecord.MSG_TYPE_MULTI_VIDEO;
                        d162.isread = z17;
                        if (i3 == 3000) {
                        }
                        if (z16) {
                        }
                        d162.istroop = i3;
                        d162.extraflag = 3;
                        j26 = j19;
                        if (j26 != 0) {
                        }
                        d162.extInt = i26;
                        j27 = j18;
                        if (j27 > 0) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        qQAppInterface.getMsgHandler().J2(d162, z17);
                        if (!TextUtils.isEmpty(str10)) {
                        }
                        if (QLog.isDevelopLevel()) {
                        }
                    }
                }
            } else {
                i18 = 1;
            }
            j16 = j3;
            j17 = 0;
            i19 = 3000;
            if (i3 != i19) {
            }
            i28 = 0;
            String makeTransFileProtocolData22 = TransfileUtile.makeTransFileProtocolData(str9, 13L, 3, true);
            MessageRecord d1622 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MULTI_VIDEO);
            d1622.selfuin = str6;
            d1622.frienduin = str;
            d1622.senderuin = str2;
            d1622.f203106msg = makeTransFileProtocolData22 + "|" + i26 + "|" + i28;
            d1622.msgtype = MessageRecord.MSG_TYPE_MULTI_VIDEO;
            d1622.isread = z17;
            if (i3 == 3000) {
            }
            if (z16) {
            }
            d1622.istroop = i3;
            d1622.extraflag = 3;
            j26 = j19;
            if (j26 != 0) {
            }
            d1622.extInt = i26;
            j27 = j18;
            if (j27 > 0) {
            }
            if (QLog.isColorLevel()) {
            }
            qQAppInterface.getMsgHandler().J2(d1622, z17);
            if (!TextUtils.isEmpty(str10)) {
            }
            if (QLog.isDevelopLevel()) {
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("VideoMsgTools", 1, "addMultiVideoMsg, err, uinType[" + i3 + "], friendUin[" + str + "], senderUin[" + str2 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x006d. Please report as an issue. */
    public static void h(QQAppInterface qQAppInterface, int i3, int i16, String str, String str2, String str3, int i17, Object... objArr) {
        long j3;
        int i18;
        String str4;
        AVNotifyCenter.i Q;
        int i19;
        int i26;
        int i27;
        String string;
        Object obj;
        if (str != null) {
            j3 = Long.valueOf(str).longValue();
        } else {
            j3 = 0;
        }
        if (str != null && str.equals(str2)) {
            return;
        }
        int l3 = qQAppInterface.getAVNotifyCenter().l(j3);
        boolean z16 = false;
        if (objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && (obj instanceof Integer)) {
            l3 = ((Integer) obj).intValue();
        }
        if (i17 != 0) {
            l3 = i17;
        }
        if (i3 == 3000) {
            l3 = 1;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (qQAppInterface.getMessageFacade() != null) {
            String str5 = null;
            if (i16 != 20) {
                if (i16 != 22) {
                    if (i16 != 44) {
                        if (i16 != 59) {
                            if (i16 != 60) {
                                switch (i16) {
                                    case 13:
                                        i19 = 1;
                                        if (currentAccountUin.equals(str2)) {
                                            if (i3 == 3000) {
                                                str5 = qQAppInterface.getApp().getString(R.string.dce);
                                            } else if (i3 == 1) {
                                                str5 = qQAppInterface.getApp().getString(R.string.dcx);
                                                break;
                                            }
                                            i18 = i19;
                                            str4 = str5;
                                            break;
                                        } else {
                                            String n3 = com.tencent.mobileqq.utils.ac.n(qQAppInterface, str, str2);
                                            if (i3 == 3000) {
                                                str5 = n3 + qQAppInterface.getApp().getString(R.string.dcd);
                                                break;
                                            } else if (i3 == 1) {
                                                str5 = n3 + qQAppInterface.getApp().getString(R.string.dcv);
                                                break;
                                            }
                                        }
                                        break;
                                    case 14:
                                        qQAppInterface.getAVNotifyCenter().B0(1, j3, 0);
                                        str5 = qQAppInterface.getApp().getString(R.string.dcf);
                                        z16 = true;
                                        i18 = 1;
                                        str4 = str5;
                                        break;
                                    case 15:
                                        qQAppInterface.getAVNotifyCenter().B0(3, j3, 0);
                                        if (i3 == 3000) {
                                            str5 = qQAppInterface.getApp().getString(R.string.dbu);
                                            break;
                                        } else {
                                            i19 = 1;
                                            if (i3 == 1) {
                                                str5 = qQAppInterface.getApp().getString(R.string.dcs);
                                            } else {
                                                str5 = qQAppInterface.getApp().getString(R.string.dd5);
                                            }
                                            i18 = i19;
                                            str4 = str5;
                                            break;
                                        }
                                    case 16:
                                        qQAppInterface.getAVNotifyCenter().B0(4, j3, 0);
                                        if (i3 == 3000) {
                                            str5 = qQAppInterface.getApp().getString(R.string.db_);
                                            break;
                                        } else {
                                            i26 = 1;
                                            if (i3 == 1) {
                                                str5 = qQAppInterface.getApp().getString(R.string.dcr);
                                                break;
                                            }
                                            i18 = i26;
                                            str4 = str5;
                                            break;
                                        }
                                    case 17:
                                        qQAppInterface.getAVNotifyCenter().B0(5, j3, 0);
                                        if (i3 == 3000) {
                                            str5 = qQAppInterface.getApp().getString(R.string.db7);
                                            break;
                                        } else {
                                            i26 = 1;
                                            if (i3 == 1) {
                                                if (str3 != null) {
                                                    i27 = Integer.parseInt(str3);
                                                } else {
                                                    i27 = 0;
                                                }
                                                if (i27 == 19) {
                                                    string = qQAppInterface.getApp().getString(R.string.dcp);
                                                } else {
                                                    string = qQAppInterface.getApp().getString(R.string.dco);
                                                }
                                                str5 = string;
                                                break;
                                            }
                                            i18 = i26;
                                            str4 = str5;
                                            break;
                                        }
                                    case 18:
                                        qQAppInterface.getAVNotifyCenter().B0(6, j3, 0);
                                        if (i3 == 3000) {
                                            str5 = qQAppInterface.getApp().getString(R.string.db8);
                                            break;
                                        } else {
                                            i26 = 1;
                                            if (i3 == 1) {
                                                str5 = qQAppInterface.getApp().getString(R.string.dcq);
                                                break;
                                            }
                                            i18 = i26;
                                            str4 = str5;
                                            break;
                                        }
                                    default:
                                        switch (i16) {
                                            case 68:
                                                qQAppInterface.getAVNotifyCenter().B0(13, j3, 0);
                                                str5 = qQAppInterface.getApp().getString(R.string.f171230w30);
                                                break;
                                            case 69:
                                                qQAppInterface.getAVNotifyCenter().B0(14, j3, 0);
                                                str5 = qQAppInterface.getApp().getString(R.string.f171231w31);
                                                break;
                                            case 70:
                                                qQAppInterface.getAVNotifyCenter().B0(15, j3, 0);
                                                str5 = qQAppInterface.getApp().getString(R.string.f171230w30);
                                                break;
                                            case 71:
                                                qQAppInterface.getAVNotifyCenter().B0(16, j3, 0);
                                                str5 = qQAppInterface.getApp().getString(R.string.f171231w31);
                                                break;
                                            default:
                                                str5 = qQAppInterface.getApp().getString(R.string.dcf);
                                                break;
                                        }
                                }
                            } else {
                                str5 = qQAppInterface.getApp().getString(R.string.dd8);
                            }
                        } else {
                            str5 = qQAppInterface.getApp().getString(R.string.dd9);
                        }
                    } else {
                        str5 = qQAppInterface.getApp().getString(R.string.idb) + str3;
                    }
                } else {
                    qQAppInterface.getAVNotifyCenter().B0(2, j3, 0);
                    str5 = qQAppInterface.getApp().getString(R.string.dbv);
                }
                str4 = str5;
                i18 = 1;
            } else if (i3 == 3000) {
                str5 = qQAppInterface.getApp().getString(R.string.dbm);
                str4 = str5;
                i18 = 1;
            } else {
                i18 = 1;
                if (i3 == 1) {
                    str5 = qQAppInterface.getApp().getString(R.string.dbm);
                }
                str4 = str5;
            }
            if (59 != i16 && i16 != 60 && l3 == 2 && str4 != null) {
                if (i3 == i18 && (Q = qQAppInterface.getAVNotifyCenter().Q(j3, l3)) != null) {
                    int i28 = Q.f73812f;
                }
                AVNotifyCenter.i Q2 = qQAppInterface.getAVNotifyCenter().Q(j3, l3);
                if (Q2 != null && Q2.a()) {
                    if (VideoUtil.i()) {
                        str4 = str4.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f173217i42));
                    } else {
                        str4 = str4.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f23229746));
                    }
                } else if (Q2 != null && Q2.b()) {
                    str4 = str4.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.w8n));
                } else {
                    str4 = str4.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f173217i42));
                }
            }
            if (i3 == 1) {
                n(qQAppInterface, 2, str, str4);
            } else if (i3 == 3000) {
                n(qQAppInterface, 3, str, str4);
            }
            if (QLog.isColorLevel()) {
                QLog.w("VideoMsgTools", 1, "addTipsMultiVideoMsg, msgType[" + i16 + "], discussionUin[" + str + "], memberUin[" + str2 + "], uinType[" + i3 + "], extra[" + str3 + "], avtype[" + l3 + "], msgStr[" + str4 + "], bSaveDB[" + z16 + "]");
            }
        }
    }

    public static void i(QQAppInterface qQAppInterface, int i3, int i16, boolean z16, String str, String str2) {
        String string;
        int i17;
        AVCoreLog.printAllUserLog("VideoMsgTools", "addTipsVideoMsg uinType = " + i3 + ", msgType = " + i16 + ", friendUin = " + str + ", extra=" + str2);
        if (i3 != -1 && qQAppInterface.getMessageFacade() != null) {
            int i18 = 1;
            boolean z17 = false;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                if (i16 != 5) {
                                    if (i16 != 24) {
                                        if (i16 != 25) {
                                            if (i16 != 28) {
                                                if (i16 != 29) {
                                                    if (i16 != 35) {
                                                        if (i16 != 45) {
                                                            if (i16 != 66) {
                                                                if (i16 != 55) {
                                                                    if (i16 != 56) {
                                                                        switch (i16) {
                                                                            case 7:
                                                                                string = qQAppInterface.getApp().getString(R.string.icv);
                                                                                break;
                                                                            case 8:
                                                                                string = qQAppInterface.getApp().getString(R.string.ie8);
                                                                                break;
                                                                            case 9:
                                                                                if (z16) {
                                                                                    string = qQAppInterface.getApp().getString(R.string.icr);
                                                                                    break;
                                                                                } else {
                                                                                    string = qQAppInterface.getApp().getString(R.string.icp);
                                                                                    break;
                                                                                }
                                                                            case 10:
                                                                                string = qQAppInterface.getApp().getString(R.string.idt);
                                                                                break;
                                                                            case 11:
                                                                                string = qQAppInterface.getApp().getString(R.string.icn);
                                                                                break;
                                                                            default:
                                                                                switch (i16) {
                                                                                    case 39:
                                                                                        string = qQAppInterface.getApp().getString(R.string.ied);
                                                                                        break;
                                                                                    case 40:
                                                                                        string = qQAppInterface.getApp().getString(R.string.d8v);
                                                                                        break;
                                                                                    case 41:
                                                                                        string = qQAppInterface.getApp().getString(R.string.idb) + str2;
                                                                                        break;
                                                                                    default:
                                                                                        switch (i16) {
                                                                                            case 50:
                                                                                                string = qQAppInterface.getApp().getString(R.string.ida);
                                                                                                break;
                                                                                            case 51:
                                                                                                string = qQAppInterface.getApp().getString(R.string.idg);
                                                                                                break;
                                                                                            case 52:
                                                                                                string = qQAppInterface.getApp().getString(R.string.ide);
                                                                                                break;
                                                                                            default:
                                                                                                switch (i16) {
                                                                                                    case 61:
                                                                                                        string = qQAppInterface.getApp().getString(R.string.dji);
                                                                                                        break;
                                                                                                    case 62:
                                                                                                        boolean isEmpty = TextUtils.isEmpty(ba.getPhoneNumberByUinInMainThread(qQAppInterface, str));
                                                                                                        BaseApplication app = qQAppInterface.getApp();
                                                                                                        if (isEmpty) {
                                                                                                            i17 = R.string.idc;
                                                                                                        } else {
                                                                                                            i17 = R.string.vyx;
                                                                                                        }
                                                                                                        String string2 = app.getString(i17);
                                                                                                        if (!isEmpty) {
                                                                                                            ReportController.o(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 2, 0, "", "", "", "");
                                                                                                        }
                                                                                                        string = string2;
                                                                                                        break;
                                                                                                    case 63:
                                                                                                        string = qQAppInterface.getApp().getString(R.string.idd);
                                                                                                        break;
                                                                                                    case 64:
                                                                                                        string = qQAppInterface.getApp().getString(R.string.f173250id4);
                                                                                                        break;
                                                                                                    default:
                                                                                                        string = qQAppInterface.getApp().getString(R.string.dag);
                                                                                                        break;
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                    } else {
                                                                        string = qQAppInterface.getApp().getString(R.string.d_g);
                                                                    }
                                                                } else {
                                                                    string = qQAppInterface.getApp().getString(R.string.idf);
                                                                }
                                                            } else {
                                                                String string3 = qQAppInterface.getApp().getString(R.string.vue);
                                                                o(qQAppInterface, 1, str, string3, 8, string3.length(), new jv.d(str));
                                                                ReportController.o(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 1, 0, "", "", "", "");
                                                                z17 = true;
                                                                string = string3;
                                                            }
                                                        } else {
                                                            string = qQAppInterface.getApp().getString(R.string.dag);
                                                        }
                                                    } else {
                                                        string = qQAppInterface.getApp().getString(R.string.icc);
                                                    }
                                                } else {
                                                    string = qQAppInterface.getApp().getString(R.string.ich);
                                                }
                                            } else {
                                                string = qQAppInterface.getApp().getString(R.string.iej);
                                            }
                                        } else {
                                            string = qQAppInterface.getApp().getString(R.string.icu);
                                        }
                                    }
                                } else {
                                    string = qQAppInterface.getApp().getString(R.string.ics);
                                }
                            } else {
                                string = qQAppInterface.getApp().getString(R.string.iei);
                            }
                        } else {
                            string = qQAppInterface.getApp().getString(R.string.idr);
                        }
                    }
                    string = qQAppInterface.getApp().getString(R.string.icd);
                } else {
                    string = qQAppInterface.getApp().getString(R.string.ids);
                }
            } else {
                string = qQAppInterface.getApp().getString(R.string.ice);
            }
            if (!z17) {
                if (i3 == 1) {
                    i18 = 2;
                }
                n(qQAppInterface, i18, str, string);
            }
            if (i16 != 2 && i16 != 24) {
                if (i16 == 0) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "0", "", "", "");
                    return;
                }
                return;
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "0", "", "", "");
        }
    }

    static void j(QQAppInterface qQAppInterface, int i3, int i16, int i17, String str, String str2, long j3, String str3, boolean z16, boolean z17) {
        k(qQAppInterface, i3, i16, i17, str, str2, j3, str3, z16, z17, r());
    }

    static void k(QQAppInterface qQAppInterface, int i3, int i16, int i17, String str, String str2, long j3, String str3, boolean z16, boolean z17, long j16) {
        String str4;
        long j17;
        if (qQAppInterface == null) {
            QLog.e("VideoMsgTools", 1, "addVideoBubbleMsg app null");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 1 && i3 != 102) {
            if (str.equals(qQAppInterface.getCurrentAccountUin())) {
                String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "VideoMsgTools");
                sb5.append(nickWithUid);
                sb5.append(MsgSummary.STR_COLON);
                QLog.d("VideoMsgTools", 1, "addVideoBubbleMsgWithSendTime senderUin=" + str + " nick=" + nickWithUid);
            }
            if (i17 == LocalAVRecordElementType.KNOTICEGROUPCLASS.ordinal()) {
                sb5.append("\u53d1\u8d77\u4e86\u7fa4\u8bfe\u5802");
            } else if (i17 == LocalAVRecordElementType.KNOTICEVIDEOCHAT.ordinal()) {
                if (!TextUtils.isEmpty(str3)) {
                    sb5.append(str3);
                } else {
                    sb5.append("\u53d1\u8d77\u4e86\u89c6\u9891\u804a\u5929");
                }
            } else if (z16) {
                sb5.append("[\u89c6\u9891\u901a\u8bdd]");
            } else {
                sb5.append("[\u8bed\u97f3\u901a\u8bdd]");
            }
            str4 = str2;
        } else {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
            if (z16) {
                sb5.append("[\u89c6\u9891\u901a\u8bdd] ");
            } else {
                sb5.append("[\u8bed\u97f3\u901a\u8bdd] ");
            }
            sb5.append(str3);
            str4 = uidFromUin;
        }
        if (j16 > r()) {
            long r16 = r();
            QLog.e("VideoMsgTools", 2, "invalid case: " + QLog.getStackTraceString(new Throwable()));
            j17 = r16;
        } else {
            j17 = j16;
        }
        String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        QLog.w("VideoMsgTools", 4, "addVideoMsg, [after add], msgTimeFinal[" + j3 + "], peerUid[" + str4 + "], senderUid[" + uidFromUin2 + "], avAbstract[" + ((Object) sb5) + "], isRead[" + z17 + "], sendTime[" + j17 + "]");
        if (!TextUtils.isEmpty(uidFromUin2) && !TextUtils.isEmpty(str4)) {
            Contact contact = new Contact(i3, str4, "");
            long j18 = j17;
            String str5 = str4;
            LocalAVRecordElement localAVRecordElement = new LocalAVRecordElement(i17, j3, uidFromUin2, i16, str3, sb5.toString(), z17, j18, 0);
            try {
                localAVRecordElement.senderUin = Long.parseLong(str);
            } catch (Exception e16) {
                QLog.e("VideoMsgTools", 1, "addVideoMsg exception = " + e16);
            }
            if (com.tencent.qqnt.msg.f.e() != null) {
                com.tencent.qqnt.msg.f.e().addLocalAVRecordMsg(contact, localAVRecordElement, new a(j3, str5, uidFromUin2, i17, str3, j18));
                return;
            } else {
                QLog.e("VideoMsgTools", 1, "addVideoBubbleMsgWithSendTime error, kernel service null");
                return;
            }
        }
        QLog.e("VideoMsgTools", 1, "sendUid or peerUid is empty, do not add");
    }

    public static void l(QQAppInterface qQAppInterface, int i3, int i16, boolean z16, String str, String str2, boolean z17, String str3, boolean z18, Object... objArr) {
        String str4;
        QLog.d("VideoMsgTools", 1, "addVideoMsg uinType = " + i3 + ", msgType = " + i16 + ", isVideoMsg = " + z16 + ", friendUin = " + LogUtil.getSafePrintUin(str) + ", senderUin = " + LogUtil.getSafePrintUin(str2) + ", isSender = " + z17 + ", extra = " + str3 + ", isRead = " + z18);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(qQAppInterface.getCurrentAccountUin())) {
            if (i3 != 1011 && i3 != -1) {
                if (i3 == 10003) {
                    if (QLog.isColorLevel()) {
                        QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
                        return;
                    }
                    return;
                }
                if (i3 == 1000) {
                    TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager != null && !TextUtils.isEmpty(str2)) {
                        TroopInfo k3 = troopManager.k(str2);
                        if (k3 != null) {
                            str4 = k3.troopcode;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e("VideoMsgTools", 2, "can't find troop info!");
                                return;
                            }
                            return;
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("VideoMsgTools", 2, "can't get friend manager!");
                            return;
                        }
                        return;
                    }
                } else {
                    str4 = str2;
                }
                if (u(i16)) {
                    if (v(i16)) {
                        g(qQAppInterface, i3, str, str4, z17, z18, 0, objArr);
                        return;
                    } else {
                        c(qQAppInterface, i3, i16, z16, str, str4, z17, str3, z18, objArr);
                        return;
                    }
                }
                if (v(i16)) {
                    h(qQAppInterface, i3, i16, str, str4, str3, 0, objArr);
                    return;
                } else {
                    i(qQAppInterface, i3, i16, z16, str, str3);
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
        }
    }

    public static void m(final QQAppInterface qQAppInterface, final int i3, final int i16, final boolean z16, final String str, String str2, boolean z17, final String str3, boolean z18, final int i17, final Object... objArr) {
        boolean z19;
        String str4;
        boolean z26;
        Object valueOf;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addVideoMsgWithAvtype uinType = ");
            sb5.append(i3);
            sb5.append(", msgType = ");
            sb5.append(i16);
            sb5.append(", isVideoMsg = ");
            z19 = z16;
            sb5.append(z19);
            sb5.append(", friendUin = ");
            sb5.append(str);
            sb5.append(", senderUin = ");
            sb5.append(str2);
            sb5.append(", isSender = ");
            sb5.append(z17);
            sb5.append(", extra = ");
            sb5.append(str3);
            sb5.append(", isRead = ");
            sb5.append(z18);
            sb5.append(", avtype = ");
            sb5.append(i17);
            sb5.append(", listSize = ");
            if (objArr == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(objArr.length);
            }
            sb5.append(valueOf);
            QLog.d("VideoMsgTools", 2, sb5.toString());
        } else {
            z19 = z16;
        }
        if (i3 == 1) {
            ITroopPushHandler iTroopPushHandler = (ITroopPushHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PUSH_HANDLER);
            if (!TextUtils.isEmpty(str)) {
                if (i16 == 13) {
                    iTroopPushHandler.L1(str, true);
                } else if (i16 == 14) {
                    iTroopPushHandler.L1(str, false);
                }
            }
        }
        if (i3 == 2) {
            l(qQAppInterface, i3, i16, z16, str, str2, z17, str3, z18, objArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(qQAppInterface.getCurrentAccountUin())) {
            if (i3 != 1011 && i3 != -1) {
                if (i3 == 10003) {
                    if (QLog.isColorLevel()) {
                        QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
                        return;
                    }
                    return;
                }
                if (i3 == 1000) {
                    TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager != null && !TextUtils.isEmpty(str2)) {
                        TroopInfo k3 = troopManager.k(str2);
                        if (k3 != null) {
                            str4 = k3.troopcode;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e("VideoMsgTools", 2, "can't find troop info!");
                                return;
                            }
                            return;
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("VideoMsgTools", 2, "can't get friend manager!");
                            return;
                        }
                        return;
                    }
                } else {
                    str4 = str2;
                }
                if ((qQAppInterface.getAVNotifyCenter().L() != 1 && qQAppInterface.getAVNotifyCenter().L() != 2) || ((i16 != 15 && i16 != 9 && i16 != 62 && i16 != 63) || (VideoBroadcastReceiver.z() && VideoBroadcastReceiver.y(i16)))) {
                    if (u(i16)) {
                        if (v(i16)) {
                            g(qQAppInterface, i3, str, str4, z17, z18, i17, objArr);
                            return;
                        } else {
                            c(qQAppInterface, i3, i16, z16, str, str4, z17, str3, z18, objArr);
                            return;
                        }
                    }
                    if (v(i16)) {
                        h(qQAppInterface, i3, i16, str, str4, str3, i17, objArr);
                        return;
                    } else {
                        i(qQAppInterface, i3, i16, z16, str, str3);
                        return;
                    }
                }
                if (qQAppInterface.getAVNotifyCenter().L() == 2 && i16 == 15) {
                    z26 = true;
                } else {
                    z26 = z19;
                }
                c(qQAppInterface, i3, i16, z26, str, str4, z17, str3, z18, objArr);
                final String str5 = str4;
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.av.utils.VideoMsgTools.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i16;
                        if (i18 != 9 && i18 != 62 && i18 != 63) {
                            VideoMsgTools.h(qQAppInterface, i3, i18, str, str5, str3, i17, objArr);
                        } else {
                            VideoMsgTools.i(qQAppInterface, i3, i18, z16, str, str3);
                        }
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
        }
    }

    public static void n(QQAppInterface qQAppInterface, int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("VideoMsgTools", 2, "addVideoTips chatType:" + i3 + " peerUin:" + str + "msg:" + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e("VideoMsgTools", 2, "addVideoTipsWithLink invalid msgStr");
        } else {
            o(qQAppInterface, i3, str, str2, -1, -1, null);
        }
    }

    static void o(QQAppInterface qQAppInterface, int i3, String str, String str2, int i16, int i17, com.tencent.qqnt.graytips.action.f fVar) {
        long j3;
        LocalGrayTip m3;
        String str3 = str;
        if (QLog.isColorLevel()) {
            QLog.i("VideoMsgTools", 2, "addVideoTipsWithLink chatType:" + i3 + " peerUin:" + str3 + "msg:" + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e("VideoMsgTools", 2, "addVideoTipsWithLink invalid msgStr");
            return;
        }
        if (i3 == 1) {
            str3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str3);
            j3 = 2021;
        } else {
            j3 = 2022;
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(str3, i3, j3, 1, true, true, null);
        if (i16 >= 0 && i17 <= str2.length()) {
            String substring = str2.substring(0, i16);
            m3 = localGrayTipBuilder.g(substring, 1).h(str2.substring(i16, i17), fVar, 3).g(str2.substring(i17), 1).m();
        } else {
            localGrayTipBuilder.g(str2, 1);
            m3 = localGrayTipBuilder.m();
        }
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(qQAppInterface, m3, null);
    }

    private static void p(QQAppInterface qQAppInterface, String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "checkNeedAddDontRespondRequestGrayTip msgType: " + i3 + ", bubblemsgStr: " + str2 + ", friendUin: " + com.tencent.mobileqq.qcall.g.b(str));
        }
        if (!TextUtils.isEmpty(str2) && str2.equals(qQAppInterface.getApp().getString(R.string.id5)) && i3 != 1 && i3 != 24 && i3 != 47) {
            String string = qQAppInterface.getApp().getString(R.string.f238177j2);
            if (!SmallScreenUtils.r(qQAppInterface.getApp())) {
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                long d16 = vu.a.c().d(currentAccountUin + "KEY_GRAY_TIP_FLOAT_SCREEN_PERMISSION_SHOW_COUNT");
                long d17 = vu.a.c().d(currentAccountUin + "KEY_GRAY_TIP_FLOAT_SCREEN_PERMISSION_LAST_TIME");
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (d16 < 3 && currentTimeMillis - d17 >= 86400) {
                    QLog.d("VideoMsgTools", 1, "checkNeedAddDontRespondRequestGrayTip add gray tips, show count: " + d16);
                    o(qQAppInterface, 1, str, string, 22, string.length(), new jv.f(str));
                    vu.a.c().m(currentAccountUin + "KEY_GRAY_TIP_FLOAT_SCREEN_PERMISSION_SHOW_COUNT", d16 + 1);
                    vu.a.c().m(currentAccountUin + "KEY_GRAY_TIP_FLOAT_SCREEN_PERMISSION_LAST_TIME", currentTimeMillis);
                }
            }
        }
    }

    public static int q(int i3, boolean z16, boolean z17) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 9) {
                                    if (i3 != 10) {
                                        if (i3 != 12) {
                                            if (i3 != 15) {
                                                if (i3 != 24) {
                                                    if (i3 != 53) {
                                                        if (i3 != 57 && i3 != 42 && i3 != 43 && i3 != 62 && i3 != 63) {
                                                            switch (i3) {
                                                                case 47:
                                                                    break;
                                                                case 48:
                                                                    break;
                                                                case 49:
                                                                    break;
                                                                default:
                                                                    return LocalAVRecordElementType.KUNKNOWN.ordinal();
                                                            }
                                                        }
                                                    }
                                                    if (z16) {
                                                        return LocalAVRecordElementType.KNOTICESWITCHTOOTHERTERMVIDEO.ordinal();
                                                    }
                                                    return LocalAVRecordElementType.KNOTICESWITCHTOOTHERTERMAUDIO.ordinal();
                                                }
                                            }
                                        } else {
                                            if (z17) {
                                                if (z16) {
                                                    return LocalAVRecordElementType.KNOTICEOTHERNOTACCEPTVIDEO.ordinal();
                                                }
                                                return LocalAVRecordElementType.KNOTICEOTHERNOTACCEPTAUDIO.ordinal();
                                            }
                                            if (z16) {
                                                return LocalAVRecordElementType.KNOTICEMISSVIDEO.ordinal();
                                            }
                                            return LocalAVRecordElementType.KNOTICEMISSAUDIO.ordinal();
                                        }
                                    }
                                }
                            } else {
                                if (z16) {
                                    return LocalAVRecordElementType.KNOTICECLOSEVIDEO.ordinal();
                                }
                                return LocalAVRecordElementType.KNOTICECLOSEAUDIO.ordinal();
                            }
                        }
                    } else {
                        if (z16) {
                            return LocalAVRecordElementType.KNOTICEREJECTVIDEO.ordinal();
                        }
                        return LocalAVRecordElementType.KNOTICEREJECTAUDIO.ordinal();
                    }
                }
                if (z17) {
                    if (z16) {
                        return LocalAVRecordElementType.KNOTICECANCELVIDEO.ordinal();
                    }
                    return LocalAVRecordElementType.KNOTICECANCELAUDIO.ordinal();
                }
                if (z16) {
                    return LocalAVRecordElementType.KNOTICEMISSVIDEO.ordinal();
                }
                return LocalAVRecordElementType.KNOTICEMISSAUDIO.ordinal();
            }
            if (z16) {
                return LocalAVRecordElementType.KNOTICEMISSVIDEO.ordinal();
            }
            return LocalAVRecordElementType.KNOTICEMISSAUDIO.ordinal();
        }
        if (z16) {
            return LocalAVRecordElementType.KNOTICECANCELVIDEO.ordinal();
        }
        return LocalAVRecordElementType.KNOTICECANCELAUDIO.ordinal();
    }

    public static long r() {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime == 0) {
            return System.currentTimeMillis() / 1000;
        }
        return serverTime;
    }

    public static byte[] s(QQAppInterface qQAppInterface, int i3, String str) {
        int i16;
        byte[] bArr;
        int i17;
        int i18;
        com.tencent.mobileqq.service.message.e msgCache = qQAppInterface.getMsgCache();
        if (i3 != 1001) {
            if (i3 != 1010) {
                if (i3 != 1021) {
                    if (i3 != 10002) {
                        bArr = null;
                        if (i3 != 1024 && i3 != 1025) {
                            switch (i3) {
                                case 1044:
                                    bArr = msgCache.G0(str, qQAppInterface.getCurrentUin());
                                    break;
                                case 1045:
                                    bArr = msgCache.H0(str, qQAppInterface.getCurrentUin(), false);
                                    break;
                                case 1046:
                                    bArr = msgCache.I0(str, qQAppInterface.getCurrentUin());
                                    break;
                            }
                        } else {
                            byte[] bArr2 = {1, 1, 58};
                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                            QLog.d("VideoMsgTools", 1, "getMsgSig crm uin=" + str + " uid=" + uidFromUin);
                            if (!TextUtils.isEmpty(uidFromUin)) {
                                bArr = qQAppInterface.getMsgCache().k0(uidFromUin);
                            }
                            if (bArr == null || (bArr.length == 1 && bArr[0] == 0)) {
                                QLog.d("VideoMsgTools", 1, "getBusinessCrmKey by uin");
                                bArr = qQAppInterface.getMsgCache().k0(str);
                            }
                            if (bArr != null) {
                                i18 = bArr.length + 3;
                            } else {
                                i18 = 3;
                            }
                            byte[] bArr3 = new byte[i18];
                            System.arraycopy(bArr2, 0, bArr3, 0, 3);
                            if (bArr != null) {
                                System.arraycopy(bArr, 0, bArr3, 3, bArr.length);
                            }
                            bArr = bArr3;
                        }
                    } else {
                        byte[] bArr4 = {1, 1, -107};
                        byte[] c16 = msgCache.c1(str);
                        if (c16 != null) {
                            i17 = c16.length + 3;
                        } else {
                            i17 = 3;
                        }
                        bArr = new byte[i17];
                        System.arraycopy(bArr4, 0, bArr, 0, 3);
                        if (c16 != null) {
                            System.arraycopy(c16, 0, bArr, 3, c16.length);
                        }
                    }
                } else {
                    bArr = msgCache.o0(str);
                }
            } else {
                byte[] q06 = msgCache.q0(str);
                if (q06 != null) {
                    bArr = new byte[q06.length + 3];
                    bArr[0] = 1;
                    bArr[1] = 1;
                    bArr[2] = -119;
                    System.arraycopy(q06, 0, bArr, 3, q06.length);
                } else {
                    bArr = new byte[]{1, 1, -119};
                }
            }
        } else {
            byte[] bArr5 = {1, 1, 124};
            byte[] b06 = msgCache.b0(str);
            if (b06 != null) {
                i16 = b06.length + 3;
            } else {
                i16 = 3;
            }
            bArr = new byte[i16];
            System.arraycopy(bArr5, 0, bArr, 0, 3);
            if (b06 != null) {
                System.arraycopy(b06, 0, bArr, 3, b06.length);
            }
        }
        if (bArr != null && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                sb5.append(b16 & 255);
                sb5.append(",");
            }
            QLog.d("VideoMsgTools", 2, "sig " + sb5.toString());
        }
        return bArr;
    }

    public static String t(Context context, int i3, int i16, boolean z16, String str) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 9) {
                                    if (i3 != 10) {
                                        if (i3 != 12) {
                                            if (i3 != 15) {
                                                if (i3 != 24) {
                                                    if (i3 != 53) {
                                                        if (i3 != 57) {
                                                            if (i3 != 42 && i3 != 43) {
                                                                if (i3 != 62 && i3 != 63) {
                                                                    switch (i3) {
                                                                        case 47:
                                                                            break;
                                                                        case 48:
                                                                            break;
                                                                        case 49:
                                                                            return context.getString(R.string.id_);
                                                                        default:
                                                                            return "";
                                                                    }
                                                                }
                                                            } else {
                                                                if (i16 == 9500) {
                                                                    return context.getString(R.string.f173248id2);
                                                                }
                                                                return context.getString(R.string.f173247id1);
                                                            }
                                                        }
                                                    } else {
                                                        return context.getString(R.string.f173249id3);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (z16) {
                                                if (i16 == 9500) {
                                                    return context.getString(R.string.idj);
                                                }
                                                return context.getString(R.string.idi);
                                            }
                                            if (i16 == 9500) {
                                                return context.getString(R.string.id6);
                                            }
                                            return context.getString(R.string.id5);
                                        }
                                    } else {
                                        if (i16 == 9500) {
                                            return context.getString(R.string.id6);
                                        }
                                        return context.getString(R.string.id5);
                                    }
                                }
                            } else {
                                return context.getString(R.string.id9);
                            }
                        } else {
                            if (i16 == 9500) {
                                return context.getString(R.string.id6);
                            }
                            return context.getString(R.string.id5);
                        }
                    } else {
                        return context.getString(R.string.id8);
                    }
                }
                if (str != null) {
                    return context.getString(R.string.idh) + " " + str;
                }
                if (z16) {
                    if (i16 == 9500) {
                        return context.getString(R.string.f173248id2);
                    }
                    return context.getString(R.string.f173247id1);
                }
                if (i16 == 9500) {
                    return context.getString(R.string.id6);
                }
                return context.getString(R.string.id5);
            }
            if (i16 == 9500) {
                return context.getString(R.string.id6);
            }
            return context.getString(R.string.id5);
        }
        if (str != null) {
            return context.getString(R.string.idh) + " " + str;
        }
        if (i16 == 9500) {
            return context.getString(R.string.f173248id2);
        }
        return context.getString(R.string.f173247id1);
    }

    public static boolean u(int i3) {
        boolean z16;
        if (VideoBroadcastReceiver.z() && VideoBroadcastReceiver.y(i3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && i3 != 47 && i3 != 48) {
            return false;
        }
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 24 || i3 == 3 || i3 == 7 || i3 == 10 || i3 == 12 || i3 == 42 || i3 == 43 || i3 == 13 || i3 == 47 || i3 == 48 || i3 == 49 || i3 == 53 || i3 == 6 || i3 == 9) {
            return true;
        }
        return false;
    }

    public static boolean v(int i3) {
        if (i3 != 13 && i3 != 14 && i3 != 15 && i3 != 16 && i3 != 17 && i3 != 18 && i3 != 20 && i3 != 19 && i3 != 44 && i3 != 59 && i3 != 60 && i3 != 22 && i3 != 69 && i3 != 68 && i3 != 71 && i3 != 70) {
            return false;
        }
        return true;
    }

    public static void w(QQAppInterface qQAppInterface, String str) {
        QLog.w("VideoMsgTools", 1, "openMeetingMember, discussUin[" + str + "]");
        Intent intent = new Intent(qQAppInterface.getApplication(), (Class<?>) GAudioMembersCtrlActivity.class);
        intent.putExtra("discussUin", str);
        intent.addFlags(268435456);
        qQAppInterface.getApplication().startActivity(intent);
    }

    public static void x(Activity activity, String str, boolean z16, boolean z17) {
        y(activity, str, z16, z17, 0);
    }

    public static void y(Activity activity, String str, boolean z16, boolean z17, int i3) {
        QLog.w("VideoMsgTools", 1, "openMeetingMember, discussUin[" + str + "]");
        Intent intent = new Intent(activity, (Class<?>) GAudioMembersCtrlActivity.class);
        intent.putExtra("discussUin", str);
        intent.putExtra("Owner", z16);
        intent.putExtra("isInRoom", z17);
        intent.putExtra("isFromMeeting", false);
        intent.putExtra("relationType", i3);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    public static void z(QQAppInterface qQAppInterface, Context context, final int i3, final String str, String str2, final boolean z16, final String str3) {
        int f16 = cp.f();
        int n3 = cp.n();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(qQAppInterface.getCurrentAccountUin());
        int i16 = n3 - 1;
        int min = Math.min(f16 - 1, i16);
        boolean d16 = cp.d(qQAppInterface, str);
        QLog.w("VideoMsgTools", 1, "selectMemberToStartGAudioChat, uinType[" + i3 + "], groupUin[" + str + "], gruopName[" + str2 + "], bVideo[" + z16 + "], leftAutoSelectNum[" + min + "], leftMaxSelect[" + i16 + "], canShowInviteEntry[" + d16 + "], fromWhere[" + str3 + "]");
        Resources resources = qQAppInterface.getApplication().getResources();
        String string = resources.getString(R.string.f171223db2);
        String string2 = resources.getString(R.string.f171224db4);
        if ("AIOShareScreen".equals(str3)) {
            string = resources.getString(R.string.f17822363);
            string2 = resources.getString(R.string.f1780635n);
            d16 = false;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ALL_SELECT_MAX_NUM, min);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i16);
        intent.putExtra("group_uin", str);
        intent.putExtra("group_name", str2);
        intent.putExtra("param_type", i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 5);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 35);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, resources.getString(R.string.dca));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, string);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, string2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ShowInviteEntry, d16);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_MYSELF, false);
        if (i3 == 1) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
        } else {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, true);
        }
        final WeakReference weakReference = new WeakReference(context);
        intent.putExtra("PARAM_ActivityResultReceiver", new ResultReceiver(new Handler()) { // from class: com.tencent.av.utils.VideoMsgTools.5
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i17, Bundle bundle) {
                int i18;
                int i19;
                e.m("selectMemberToStartGAudioChat", bundle);
                final ArrayList parcelableArrayList = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("selectMemberToStartGAudioChat onReceiveResult, bVideo[");
                sb5.append(z16);
                sb5.append("], resultCode[");
                sb5.append(i17);
                sb5.append("], chooserList[");
                if (parcelableArrayList != null) {
                    i18 = parcelableArrayList.size();
                } else {
                    i18 = -1;
                }
                sb5.append(i18);
                sb5.append("]");
                QLog.w("VideoMsgTools", 1, sb5.toString());
                if (parcelableArrayList != null) {
                    i19 = parcelableArrayList.size();
                } else {
                    i19 = 0;
                }
                cp.c.i(i19, z16);
                if (parcelableArrayList != null && i17 == -1) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.av.utils.VideoMsgTools.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i26;
                            Context context2 = (Context) weakReference.get();
                            if (context2 == null) {
                                return;
                            }
                            Bundle bundle2 = new Bundle();
                            if (i3 == 3000) {
                                i26 = 1;
                            } else {
                                i26 = 10;
                            }
                            bundle2.putInt("MultiAVType", i26);
                            if (z16) {
                                bundle2.putBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, true);
                            }
                            QQAppInterface qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                            ArrayList<? extends Parcelable> arrayList2 = parcelableArrayList;
                            if (arrayList2 != null) {
                                bundle2.putParcelableArrayList("invitelist", arrayList2);
                            }
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            if (i3 == 1) {
                                bundle2.putBoolean("enableInvite", cp.g("selectMemberToStartGAudioChat", qQAppInterface2, str));
                            }
                            bundle2.putString("Fromwhere", str3);
                            if ("AIOQAVCheckPermission".equals(str3)) {
                                bundle2.putBoolean("should_believe_only_audio_flag", true);
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                ChatActivityUtils.f0(qQAppInterface2, context2, i3, str, true, true, null, bundle2);
                            } else if ("AIOShareScreen".equals(str3)) {
                                bundle2.putBoolean("should_believe_only_audio_flag", true);
                                AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                                ChatActivityUtils.g0(qQAppInterface2, context2, i3, str, true, true, null, bundle2, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV_SHARE_SCREEN);
                            } else {
                                AnonymousClass5 anonymousClass54 = AnonymousClass5.this;
                                ChatActivityUtils.f0(qQAppInterface2, context2, i3, str, true, true, null, bundle2);
                            }
                        }
                    });
                }
            }
        });
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, true);
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            baseActivity.overridePendingTransition(R.anim.f154454a3, 0);
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(qQAppInterface.getApplicationContext(), intent);
    }
}
