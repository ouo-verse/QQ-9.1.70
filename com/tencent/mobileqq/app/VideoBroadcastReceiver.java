package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.av.business.handler.ScoreBusinessHandler;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoC2CHandler;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.avcore.util.AVConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes11.dex */
public class VideoBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static String f195185e;

    /* renamed from: f, reason: collision with root package name */
    private static String f195186f;

    /* renamed from: g, reason: collision with root package name */
    static VideoBroadcastReceiver f195187g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f195188h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f195189i;

    /* renamed from: j, reason: collision with root package name */
    private static int f195190j;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f195191a;

    /* renamed from: b, reason: collision with root package name */
    boolean f195192b;

    /* renamed from: c, reason: collision with root package name */
    MqqHandler f195193c;

    /* renamed from: d, reason: collision with root package name */
    INetEngineListener f195194d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ boolean C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f195199d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f195200e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f195201f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f195202h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f195203i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f195204m;

        a(QQAppInterface qQAppInterface, int i3, int i16, boolean z16, String str, String str2, boolean z17) {
            this.f195199d = qQAppInterface;
            this.f195200e = i3;
            this.f195201f = i16;
            this.f195202h = z16;
            this.f195203i = str;
            this.f195204m = str2;
            this.C = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VideoBroadcastReceiver.this, qQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            VideoMsgTools.l(this.f195199d, this.f195200e, this.f195201f, !this.f195202h, this.f195203i, this.f195204m, this.C, null, true, new Object[0]);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            DataReport.f(this.f195199d.isBackgroundPause, this.f195202h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f195205d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f195206e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f195207f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f195208h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f195209i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f195210m;

        b(int i3, QQAppInterface qQAppInterface, int i16, String str, String str2, String str3, String str4) {
            this.f195205d = i3;
            this.f195206e = qQAppInterface;
            this.f195207f = i16;
            this.f195208h = str;
            this.f195209i = str2;
            this.f195210m = str3;
            this.C = str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VideoBroadcastReceiver.this, Integer.valueOf(i3), qQAppInterface, Integer.valueOf(i16), str, str2, str3, str4);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DataReport.Y(false, false);
            int i16 = this.f195205d;
            if (i16 == 3000) {
                VideoMsgTools.l(this.f195206e, i16, this.f195207f, false, this.f195208h, this.f195209i, false, null, true, new Object[0]);
                VideoBroadcastReceiver.this.v(3, this.f195205d, this.f195208h, this.f195210m, this.C);
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            DataReport.i(this.f195206e.isBackgroundPause);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoBroadcastReceiver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements INetEngineListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoBroadcastReceiver.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            com.tencent.mobileqq.utils.ci ciVar = null;
            if (netResp == null) {
                IOUtil.closeStream(null);
                return;
            }
            try {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(VideoBroadcastReceiver.f195185e, 2, "resp.mHttpCode:" + netResp.mHttpCode + ",resp.mErrCode:" + netResp.mErrCode + ",resp.mResult:" + netResp.mResult + ",resp.mErrDesc:" + netResp.mErrDesc);
                    }
                    OutputStream outputStream = netResp.mReq.mOutStream;
                    if (outputStream instanceof com.tencent.mobileqq.utils.ci) {
                        com.tencent.mobileqq.utils.ci ciVar2 = (com.tencent.mobileqq.utils.ci) outputStream;
                        if (ciVar2 == null) {
                            IOUtil.closeStream(ciVar2);
                            return;
                        }
                        try {
                            String obj = ciVar2.toString();
                            QLog.d(VideoBroadcastReceiver.f195185e, 2, "outputStream:" + obj);
                            ciVar = ciVar2;
                        } catch (Exception e16) {
                            ciVar = ciVar2;
                            e = e16;
                            e.printStackTrace();
                            IOUtil.closeStream(ciVar);
                        } catch (Throwable th5) {
                            ciVar = ciVar2;
                            th = th5;
                            IOUtil.closeStream(ciVar);
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
            IOUtil.closeStream(ciVar);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class e extends MqqHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<VideoBroadcastReceiver> f195213d;

        public e(Looper looper, VideoBroadcastReceiver videoBroadcastReceiver) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper, (Object) videoBroadcastReceiver);
            } else {
                this.f195213d = new WeakReference<>(videoBroadcastReceiver);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            VideoBroadcastReceiver videoBroadcastReceiver;
            QQAppInterface qQAppInterface;
            int i3;
            DialogInterface.OnClickListener onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
                return;
            }
            WeakReference<VideoBroadcastReceiver> weakReference = this.f195213d;
            if (weakReference == null || (videoBroadcastReceiver = weakReference.get()) == null || videoBroadcastReceiver.f195191a == null || (qQAppInterface = (QQAppInterface) videoBroadcastReceiver.f195191a.get()) == null) {
                return;
            }
            QQCustomDialog qQCustomDialog = null;
            DialogInterface.OnClickListener onClickListener2 = null;
            QQCustomDialog qQCustomDialog2 = null;
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    int intValue = ((Integer) objArr[0]).intValue();
                    String str = (String) objArr[2];
                    String str2 = (String) objArr[3];
                    String str3 = (String) objArr[5];
                    Contact contact = new Contact();
                    contact.setChatType(com.tencent.nt.adapter.session.c.l(intValue));
                    if (intValue == 1006) {
                        contact.setPeerUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
                    } else {
                        contact.setPeerUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2));
                    }
                    ArrayList<MsgElement> arrayList = new ArrayList<>();
                    arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(str3));
                    ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, arrayList, null);
                    return;
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    Object obj = objArr2[0];
                    if (obj instanceof QQCustomDialog) {
                        qQCustomDialog = (QQCustomDialog) obj;
                    }
                    int intValue2 = ((Integer) objArr2[1]).intValue();
                    boolean booleanValue = ((Boolean) objArr2[2]).booleanValue();
                    String str4 = (String) objArr2[3];
                    String str5 = (String) objArr2[4];
                    boolean booleanValue2 = ((Boolean) objArr2[5]).booleanValue();
                    if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                        qQCustomDialog.dismiss();
                        VideoMsgTools.l(qQAppInterface, intValue2, 10, !booleanValue, str4, str5, booleanValue2, null, true, new Object[0]);
                        DataReport.g(qQAppInterface.isBackgroundPause, booleanValue);
                        return;
                    }
                    return;
                case 2:
                    Object[] objArr3 = (Object[]) message.obj;
                    Object obj2 = objArr3[0];
                    if (obj2 instanceof QQCustomDialog) {
                        qQCustomDialog2 = (QQCustomDialog) obj2;
                    }
                    int intValue3 = ((Integer) objArr3[1]).intValue();
                    int intValue4 = ((Integer) objArr3[2]).intValue();
                    String str6 = (String) objArr3[3];
                    String str7 = (String) objArr3[4];
                    String str8 = (String) objArr3[5];
                    String str9 = (String) objArr3[6];
                    if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
                        qQCustomDialog2.dismiss();
                        if (intValue3 == 3000) {
                            VideoMsgTools.l(qQAppInterface, intValue3, intValue4, false, str6, str7, false, null, false, new Object[0]);
                            videoBroadcastReceiver.v(8, intValue3, str6, str8, str9);
                        }
                        DataReport.j(qQAppInterface.isBackgroundPause);
                        return;
                    }
                    return;
                case 3:
                    QQCustomDialog qQCustomDialog3 = (QQCustomDialog) ((Object[]) message.obj)[0];
                    if (qQCustomDialog3.isShowing()) {
                        qQCustomDialog3.dismiss();
                        return;
                    }
                    return;
                case 4:
                    Object[] objArr4 = (Object[]) message.obj;
                    int intValue5 = ((Integer) objArr4[0]).intValue();
                    String str10 = (String) objArr4[1];
                    String str11 = (String) objArr4[2];
                    long longValue = ((Long) objArr4[3]).longValue();
                    Bundle bundle = (Bundle) objArr4[4];
                    if (str10 != null && str11 != null) {
                        ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIO(qQAppInterface.getApp(), com.tencent.nt.adapter.session.c.l(intValue5), str10, str11, longValue, bundle);
                        return;
                    } else {
                        QLog.e(VideoBroadcastReceiver.f195185e, 1, "handleMessage MSG_ON_MSG_LEAVE invalid param.");
                        return;
                    }
                case 5:
                    Object[] objArr5 = (Object[]) message.obj;
                    qQAppInterface.getAVNotifyCenter().o0(((Integer) objArr5[0]).intValue(), ((Integer) objArr5[1]).intValue(), ((Long) objArr5[2]).longValue(), ((Long) objArr5[3]).longValue(), (String) objArr5[4]);
                    return;
                case 6:
                    Object[] objArr6 = (Object[]) message.obj;
                    int intValue6 = ((Integer) objArr6[0]).intValue();
                    final String str12 = (String) objArr6[1];
                    String str13 = (String) objArr6[2];
                    QLog.i(VideoBroadcastReceiver.f195185e, 1, "handleMessage MSG_SECURITY_LIMIT safe code: " + intValue6 + " safe url: " + str12 + " safe str: " + str13);
                    final Activity topActivity = Foreground.getTopActivity();
                    if (topActivity != null && !topActivity.isFinishing()) {
                        QLog.i(VideoBroadcastReceiver.f195185e, 1, "handleMessage MSG_SECURITY_LIMIT safe code: " + intValue6 + " safe url: " + str12 + " safe str: " + str13);
                        if (intValue6 == 1) {
                            i3 = R.string.zvb;
                        } else {
                            i3 = R.string.f1356301z;
                        }
                        int i16 = i3;
                        if (intValue6 != 1) {
                            onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.app.dp
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i17) {
                                    VideoBroadcastReceiver.e.d(dialogInterface, i17);
                                }
                            };
                        }
                        DialogInterface.OnClickListener onClickListener3 = onClickListener2;
                        if (intValue6 == 1) {
                            onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.app.dq
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i17) {
                                    VideoBroadcastReceiver.e.e(dialogInterface, i17);
                                }
                            };
                        } else {
                            onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.app.dr
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i17) {
                                    VideoUtil.k(topActivity, str12, -1);
                                }
                            };
                        }
                        DialogUtil.createCustomDialog(topActivity, 230, topActivity.getString(R.string.dfp), str13, R.string.f1380608j, i16, onClickListener, onClickListener3).show();
                        VideoBroadcastReceiver.f195189i = true;
                        VideoBroadcastReceiver.f195190j = 0;
                        return;
                    }
                    QLog.e(VideoBroadcastReceiver.f195185e, 1, "handleMessage MSG_SECURITY_LIMIT foreground activity is null or isFinishing.");
                    if (!VideoBroadcastReceiver.f195189i) {
                        if (VideoBroadcastReceiver.f195190j < 10) {
                            VideoBroadcastReceiver.f195190j++;
                            Message obtain = Message.obtain();
                            obtain.what = 6;
                            obtain.obj = new Object[]{Integer.valueOf(intValue6), str12, str13};
                            sendMessageDelayed(obtain, 1500L);
                            return;
                        }
                        VideoBroadcastReceiver.f195189i = true;
                        VideoBroadcastReceiver.f195190j = 0;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f195185e = "VideoBroadCastReceiver";
        f195186f = "qav_surpport_local_video_msg";
        f195187g = null;
        f195188h = null;
        f195189i = false;
        f195190j = 0;
    }

    VideoBroadcastReceiver(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195191a = null;
        this.f195192b = false;
        this.f195193c = null;
        this.f195194d = new d();
        this.f195191a = new WeakReference<>(qQAppInterface);
        this.f195193c = new e(Looper.getMainLooper(), this);
    }

    private void A(int i3, String str, QQAppInterface qQAppInterface) {
        if ((i3 == 3000 || i3 == 1) && str != null) {
            qQAppInterface.getAVNotifyCenter().I0(12, com.tencent.av.utils.ba.uinType2AVRelationType(i3), Long.valueOf(str).longValue(), null, 0L);
            qQAppInterface.getAVNotifyCenter().m0(21, com.tencent.av.utils.ba.uinType2AVRelationType(i3), Long.valueOf(str).longValue(), 0L);
        }
    }

    private void L(QQAppInterface qQAppInterface, int i3, boolean z16, String str, String str2, String str3, int i16, String str4) {
        boolean z17;
        if (!z16 && i16 != 1008) {
            if (i16 == 0) {
                if (!TextUtils.isEmpty(str)) {
                    z17 = str.equals(str2);
                } else {
                    z17 = false;
                }
                VideoMsgTools.l(qQAppInterface, i16, 1, true, str4, str2, z17, null, true, new Object[0]);
                return;
            }
            v(i3, i16, str3, str4, str2);
        }
    }

    private void N(Intent intent, QQAppInterface qQAppInterface) {
        int intExtra = intent.getIntExtra("relationType", 3);
        long longExtra = intent.getLongExtra("relationId", 0L);
        long longExtra2 = intent.getLongExtra("friendUin", 0L);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = " + intExtra + " ,relationId = " + longExtra + " ,friendUin = " + longExtra2);
        }
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null) {
            fVar.P("" + longExtra2, 0, 0);
        }
        qQAppInterface.getAVNotifyCenter().G0(String.valueOf(longExtra2), false);
        qQAppInterface.getAVNotifyCenter().d1(false);
    }

    private void O(Intent intent, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN");
        }
        int intExtra = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        long longExtra2 = intent.getLongExtra("friendUin", 0L);
        if (QLog.isColorLevel()) {
            QLog.d(AVConstants.SHARE_TAG, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN, relationType[" + intExtra + "], relationId[" + longExtra + "], friendUin[" + longExtra2 + "]");
        }
        if (longExtra2 == longExtra) {
            qQAppInterface.getAVNotifyCenter().D0(0, Long.valueOf(longExtra), true);
        }
        qQAppInterface.getAVNotifyCenter().G0(String.valueOf(longExtra), true);
        if (longExtra2 == longExtra) {
            qQAppInterface.getAVNotifyCenter().O0(true);
            qQAppInterface.getAVNotifyCenter().d1(true);
        }
    }

    private void P(Intent intent, QQAppInterface qQAppInterface) {
        int intExtra = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        long longExtra2 = intent.getLongExtra("friendUin", 0L);
        if (QLog.isColorLevel()) {
            QLog.d(AVConstants.SHARE_TAG, 2, "TYPE_DOUBLE_MEETING_MEMBER_LEAVE, relationType[" + intExtra + "], relationId[" + longExtra + "], friendUin[" + longExtra2 + "]");
        }
        qQAppInterface.getAVNotifyCenter().G0(String.valueOf(longExtra), false);
        qQAppInterface.getAVNotifyCenter().d1(false);
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null) {
            fVar.P("" + longExtra2, 0, 0);
        }
    }

    private void Q(Intent intent, QQAppInterface qQAppInterface) {
        String stringExtra = intent.getStringExtra("peerUin");
        String stringExtra2 = intent.getStringExtra("msgStr");
        QLog.i(f195185e, 2, "onDoubleScreenShareSecurityExit, peerUin[" + stringExtra + "] msgStr[" + stringExtra2 + "]");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            VideoMsgTools.n(qQAppInterface, 1, stringExtra, stringExtra2);
        }
    }

    private void R(QQAppInterface qQAppInterface, Intent intent, String str, String str2, int i3, String str3, int i16, String str4, long j3, long j16, long j17, long j18, long j19, long j26, int i17) {
        String str5 = (TextUtils.isEmpty(str2) || i3 != 1006 || (str3 != null && str3.contains(Marker.ANY_NON_NULL_MARKER))) ? str3 : str2;
        if (TextUtils.equals(str, qQAppInterface.getCurrentAccountUin())) {
            com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
            if (!qQAppInterface.getAVNotifyCenter().d0(str5) && fVar != null) {
                if (i16 != 2 && i16 != 3 && i3 != 25) {
                    fVar.P(str5, i3, 0);
                    p0(qQAppInterface, str, i3, str5, j3, j16, j17, j18, j19, j26, i17);
                } else {
                    fVar.Q(str5, 8, i3, i16, str4, 0);
                }
                String stringExtra = intent.getStringExtra(GameCenterCommonApiImpl.KEY_ACT_ID);
                String stringExtra2 = intent.getStringExtra("mp_ext_params");
                if (stringExtra != null) {
                    VideoMsgTools.C(qQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", stringExtra, stringExtra2, this.f195194d);
                }
            }
        }
    }

    private void Y(Intent intent, QQAppInterface qQAppInterface) {
        String stringExtra = intent.getStringExtra("relationId");
        int intExtra = intent.getIntExtra("relationType", -1);
        String stringExtra2 = intent.getStringExtra("msgStr");
        QLog.i(f195185e, 2, "onMultiScreenShareSecurityExit, relationId[" + stringExtra + "] relationType[" + intExtra + "] msgStr[" + stringExtra2 + "]");
        if (intExtra == 2) {
            VideoMsgTools.n(qQAppInterface, 3, stringExtra, stringExtra2);
        } else if (intExtra == 1) {
            VideoMsgTools.n(qQAppInterface, 2, stringExtra, stringExtra2);
        } else {
            QLog.i(f195185e, 2, "onMultiScreenShareSecurityExit unhandled case");
        }
    }

    private void d0(QQAppInterface qQAppInterface, int i3, String str, int i16, boolean z16, String str2, boolean z17) {
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null) {
            try {
                fVar.z().l(str, i3).isSystemCall = 0;
            } catch (Exception unused) {
            }
            if (i16 != 2 && i16 != 3 && i3 != 25) {
                if (z16) {
                    fVar.P(str, i3, 6);
                    return;
                } else {
                    if (!z17) {
                        fVar.P(str, i3, 5);
                        return;
                    }
                    return;
                }
            }
            if (z16) {
                fVar.Q(str, 8, i3, i16, str2, 6);
            } else {
                fVar.Q(str, 8, i3, i16, str2, 5);
            }
        }
    }

    private void g(Intent intent, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "addMemberFromC2C");
        }
        VideoMsgTools.f(qQAppInterface, intent.getStringExtra("peerUin"), intent.getIntExtra("supportUinType", 3000));
    }

    private void h(Intent intent, QQAppInterface qQAppInterface) {
        ArrayList arrayList = (ArrayList) intent.getExtras().getSerializable("phoneList");
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.e(f195185e, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
                return;
            }
            return;
        }
        long longExtra = intent.getLongExtra("relationId", -1L);
        String a16 = com.tencent.av.utils.ae.a(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + a16);
        }
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null) {
            fVar.c(0, longExtra, "", a16);
            DiscussionHandler discussionHandler = (DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
            if (discussionHandler != null && discussionHandler.Z2() != null) {
                discussionHandler.Z2().T(String.valueOf(longExtra));
            }
        }
    }

    private void i(Intent intent, int i3, String str, String str2, int i16, String str3, boolean z16, int i17, long j3, QQAppInterface qQAppInterface) {
        if (qQAppInterface != null && intent != null) {
            qQAppInterface.getAVNotifyCenter().C0(false);
            if (i16 != 4 && i16 != 6 && i16 != 1) {
                if (i16 == 0 && (qQAppInterface.getAVNotifyCenter().L() == 3 || qQAppInterface.getAVNotifyCenter().L() == 4)) {
                    qQAppInterface.getAVNotifyCenter().E0(i3, str, str2, false);
                    qQAppInterface.getAVNotifyCenter().U0(8, str, 0);
                } else {
                    if (z16) {
                        if (str3 != null && qQAppInterface.getCurrentAccountUin() != null && str3.equals(qQAppInterface.getCurrentAccountUin())) {
                            qQAppInterface.getAVNotifyCenter().E0(i3, str, str2, false);
                            qQAppInterface.getAVNotifyCenter().U0(8, str, 0);
                            qQAppInterface.getAVNotifyCenter().d1(false);
                        }
                    } else {
                        qQAppInterface.getAVNotifyCenter().D0(i17, Long.valueOf(j3), false);
                        qQAppInterface.getAVNotifyCenter().S0(8, i17, j3, 0);
                        qQAppInterface.getAVNotifyCenter().d1(false);
                    }
                    if (i16 == 7) {
                        String stringExtra = intent.getStringExtra(GameCenterCommonApiImpl.KEY_ACT_ID);
                        String stringExtra2 = intent.getStringExtra("mp_ext_params");
                        if (stringExtra != null) {
                            VideoMsgTools.C(qQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", stringExtra, stringExtra2, this.f195194d);
                        }
                    }
                }
            } else if (z16) {
                qQAppInterface.getAVNotifyCenter().E0(i3, str, str2, false);
                qQAppInterface.getAVNotifyCenter().U0(8, str, 0);
            } else {
                qQAppInterface.getAVNotifyCenter().D0(i17, Long.valueOf(j3), false);
                qQAppInterface.getAVNotifyCenter().S0(8, i17, j3, 0);
            }
            qQAppInterface.getAVNotifyCenter().p0(28, i3, str, str2);
        }
    }

    private void j(Context context, QQAppInterface qQAppInterface) {
        Intent intent = new Intent(context, (Class<?>) BindNumberActivity.class);
        intent.putExtra("kNeedUnbind", true);
        intent.addFlags(268435456);
        qQAppInterface.getApp().startActivity(intent);
    }

    private boolean k(Context context, QQAppInterface qQAppInterface, int i3, int i16, String str, String str2, boolean z16, String str3) {
        if (com.tencent.av.utils.af.E()) {
            if (QLog.isColorLevel()) {
                QLog.d(f195185e, 2, "only SupportLocalDavBubbleMessage ");
            }
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((i3 == 0 || i3 == 1024) && !str.equals(qQAppInterface.getCurrentAccountUin()))) {
            if (z() && y(i16)) {
                return true;
            }
            String t16 = VideoMsgTools.t(qQAppInterface.getApp(), i16, i3, z16, str3);
            if (TextUtils.isEmpty(t16) || !t16.contains(context.getString(R.string.idh))) {
                return true;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "only support double talk");
        }
        return true;
    }

    private void k0(Context context, QQAppInterface qQAppInterface) {
        Intent intent = new Intent(context, (Class<?>) PhoneFrameActivity.class);
        intent.putExtra("key_req_type", 0);
        intent.addFlags(268435456);
        qQAppInterface.getApp().startActivity(intent);
    }

    private void l(Context context, Intent intent, QQAppInterface qQAppInterface) {
        VasLogReporter.getChatBackgroundJsb().report("receive broadcast", VasLogReportProxy.LEVEL.HIGHEST);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        int intExtra = intent.getIntExtra("uinType", 0);
        com.tencent.mobileqq.vas.api.e.a().setCustomChatBackground(intent.getStringExtra("friendUin"), stringExtra, intent.getIntExtra("effectId", 0), intExtra);
    }

    public static void l0(QQAppInterface qQAppInterface) {
        synchronized (VideoBroadcastReceiver.class) {
            if (f195187g == null) {
                f195187g = new VideoBroadcastReceiver(qQAppInterface);
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.video.v2q.AddMsgSig");
        intentFilter.addAction("tencent.video.v2q.MeetingMemberManager");
        intentFilter.addAction("tencent.video.v2q.AddContactsToDiscuss");
        intentFilter.addAction("tencent.video.v2q.AddContactsFromC2C");
        intentFilter.addAction("tencent.video.v2q.AddVideoMsg");
        intentFilter.addAction("tencent.av.v2q.CheckChatAbility");
        intentFilter.addAction("tencent.video.v2q.VideoFlowSize");
        intentFilter.addAction("tencent.av.v2q.security");
        intentFilter.addAction("tencent.av.v2q.MultiVideo");
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction("tencent.av.v2q.StartDoubleVideoMeeting");
        intentFilter.addAction("tencent.av.v2q.StopVideoChat");
        intentFilter.addAction("tencent.av.v2q.AvSwitch");
        intentFilter.addAction("tencent.video.v2q.replyMsg");
        intentFilter.addAction("tencent.video.v2q.leaveMsg");
        intentFilter.addAction("tencent.av.v2q.AnotherTerChating");
        intentFilter.addAction("tencent.video.v2q.AudioEngineReady");
        intentFilter.addAction("tencent.video.v2q.GaudioOpenTroopCard");
        intentFilter.addAction("tencent.video.v2q.CallingDialog");
        intentFilter.addAction("tencent.video.v2q.CallingDialogMulti");
        intentFilter.addAction("tencent.video.v2q.BindContact");
        intentFilter.addAction("tencent.video.v2q.OpenContactList");
        intentFilter.addAction("tencent.video.v2q.AnnimateDownloadStart");
        intentFilter.addAction("tencent.video.v2q.commingRingDownload");
        intentFilter.addAction(AppConstants.CHAT_BACKGROUND_BROADCAST);
        intentFilter.addAction("tencent.video.v2q.updateChatInfo");
        intentFilter.addAction("tencent.video.v2q.insertSystemCall");
        intentFilter.addAction("tencent.video.v2q.upgradeInvite");
        intentFilter.addAction("tencent.video.v2q.SmallScreenState");
        intentFilter.addAction("tencent.video.v2q.downloadGAudioSound");
        intentFilter.addAction("tencent.video.v2q.generalFuncCall");
        intentFilter.addAction("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
        intentFilter.addAction("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END");
        intentFilter.addAction("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        intentFilter.addAction("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
        intentFilter.addAction("tencent.video.v2q.AddMembersToGroup");
        intentFilter.addAction("tencent.video.v2q.checkPtuRes");
        try {
            qQAppInterface.getApp().registerReceiver(f195187g, intentFilter, "com.tencent.qav.permission.broadcast", null);
            VideoBroadcastReceiver videoBroadcastReceiver = f195187g;
            if (videoBroadcastReceiver != null) {
                videoBroadcastReceiver.f195192b = true;
            }
        } catch (Exception e16) {
            VideoBroadcastReceiver videoBroadcastReceiver2 = f195187g;
            if (videoBroadcastReceiver2 != null) {
                videoBroadcastReceiver2.f195192b = false;
            }
            if (QLog.isColorLevel()) {
                QLog.e(f195185e, 2, "registerForVideoBroadcasts e = " + e16);
            }
        }
    }

    private boolean m(String str, Context context, Intent intent) {
        long a16 = com.tencent.av.utils.at.a(intent);
        if (str.equals("tencent.video.v2q.AddVideoMsg")) {
            C(context, intent);
        } else if (str.equals("tencent.video.v2q.VideoFlowSize")) {
            j0(context, intent);
        } else if (str.equals("tencent.av.v2q.security")) {
            a0(context, intent);
        } else if (str.equals("tencent.av.v2q.MultiVideo")) {
            W(a16, context, intent);
        } else if (str.equals("tencent.av.v2q.StartDoubleVideoMeeting")) {
            f0(context, intent);
        } else if (str.equals(ITroopHWApi.ACTION_START_VIDEO_CHAT)) {
            c0(context, intent);
        } else if (str.equals("tencent.av.v2q.StopVideoChat")) {
            h0(context, intent);
        } else if (str.equals("tencent.av.v2q.AvSwitch")) {
            H(context, intent);
        } else if (str.equals("tencent.av.v2q.AnotherTerChating")) {
            F(context, intent);
        } else {
            return false;
        }
        return true;
    }

    public static QQCustomDialog m0(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if (BaseGesturePWDUtil.isAppOnForegroundByTasks(context, 0)) {
            return PopupDialog.o0(context, 230, str, str2, R.string.cancel, R.string.f171151ok, onClickListener, null);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, str, str2, R.string.cancel, R.string.f171151ok, onClickListener, (DialogInterface.OnClickListener) null);
        if (Build.VERSION.SDK_INT >= 26) {
            createCustomDialog.getWindow().setType(2038);
        } else {
            createCustomDialog.getWindow().setType(2003);
        }
        if (Settings.canDrawOverlays(context)) {
            createCustomDialog.show();
        } else {
            QLog.d(f195185e, 1, "can not DrawOverlays showAlertDialog()!!");
        }
        return createCustomDialog;
    }

    private void n0(Intent intent, long j3, QQAppInterface qQAppInterface) {
        int intExtra = intent.getIntExtra("SmallScreenState", 0);
        String stringExtra = intent.getStringExtra("uin");
        if (QQAudioHelper.j()) {
            QLog.w(f195185e, 1, "ACTION_SMALL_SCREEN_STATE, smallScreenState[" + intExtra + "], peerUin[" + stringExtra + "], seq[" + j3 + "]");
        }
        qQAppInterface.getAVNotifyCenter().V0(j3, intExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            qQAppInterface.getAVNotifyCenter().q0(stringExtra);
        }
    }

    public static void o0() {
        synchronized (VideoBroadcastReceiver.class) {
            VideoBroadcastReceiver videoBroadcastReceiver = f195187g;
            if (videoBroadcastReceiver != null && videoBroadcastReceiver.f195192b) {
                QQAppInterface qQAppInterface = videoBroadcastReceiver.f195191a.get();
                if (qQAppInterface != null) {
                    try {
                        qQAppInterface.getApp().unregisterReceiver(f195187g);
                    } catch (Exception e16) {
                        QLog.e(f195185e, 1, "unregisterForVideoBroadcasts e = " + e16);
                    }
                }
                VideoBroadcastReceiver videoBroadcastReceiver2 = f195187g;
                videoBroadcastReceiver2.f195192b = false;
                videoBroadcastReceiver2.f195191a = null;
                f195187g = null;
            }
        }
    }

    private void p0(QQAppInterface qQAppInterface, String str, int i3, String str2, long j3, long j16, long j17, long j18, long j19, long j26, int i16) {
        if (i3 == 1) {
            QLog.d(f195185e, 2, "[updateScoreInfo] ignore troop");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "updateScoreInfo beginTime: " + j16 + ", endTime: " + j17 + ", bussinessType: " + j18 + ",roomId: " + j26 + ", duration: " + j3 + ", sessionType: " + i16 + ", bussinessFlag: " + j19 + ",toUin: " + str2);
        }
        if (!TextUtils.isEmpty(str) && j3 >= com.tencent.av.q.f74194e && qQAppInterface != null && com.tencent.av.utils.ar.j(qQAppInterface.getCurrentAccountUin())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.tencent.av.q.f74195f, str);
                jSONObject.put(com.tencent.av.q.f74196g, j26);
                jSONObject.put(com.tencent.av.q.f74197h, str2);
                String jSONObject2 = jSONObject.toString();
                if (QLog.isColorLevel()) {
                    QLog.d(f195185e, 2, "updateScoreInfo scoreInfos: " + jSONObject2);
                }
                ((ScoreBusinessHandler) qQAppInterface.getBusinessHandler(ScoreBusinessHandler.class.getName())).D2(com.tencent.av.utils.ar.e(i16), jSONObject2, i3, str2);
            } catch (JSONException e16) {
                QLog.d(f195185e, 1, "updateScoreInfo json put error:" + e16);
            }
        }
    }

    private void q(Intent intent, QQAppInterface qQAppInterface) {
        IVipFunCallManager funCallManager;
        int intExtra = intent.getIntExtra("callId", 0);
        if (intExtra > 0 && VipFunCallUtil.isNetworkAllowDowanload() && (funCallManager = VasUtil.getService().getFunCallManager()) != null) {
            funCallManager.startDownload(intExtra, VipFunCallUtil.getResourceType(), false, 0);
        }
    }

    private void r(Intent intent, QQAppInterface qQAppInterface) {
        int intExtra = intent.getIntExtra("comming_ring_down_key", 0);
        if (intExtra > 0 && VipFunCallUtil.isNetworkAllowDowanload()) {
            ((com.tencent.mobileqq.vas.h) qQAppInterface.getManager(QQManagerFactory.COLOR_RING_MANAGER)).g(intExtra, 3, false, 0, "comering");
            ReportController.o(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType(), intExtra + "", "", "");
        }
    }

    private void s(Intent intent, QQAppInterface qQAppInterface) {
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            troopManager.h0(intent.getStringExtra("relationId"), intent.getStringExtra("inviterUin"));
        }
    }

    private void t(Intent intent, QQAppInterface qQAppInterface) {
        HashMap hashMap = new HashMap();
        hashMap.put("MultiAVType", String.valueOf(2));
        hashMap.put("enterType", intent.getIntExtra("enterType", 0) + "");
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            ChatActivityUtils.d0(qQAppInterface, baseActivity, 1, intent.getStringExtra("relationId"), true, true, null, hashMap);
        }
    }

    private void u(Intent intent, QQAppInterface qQAppInterface) {
        AbsStructMsg d16;
        if (!"SEND_STRUCT_MSG".equals(intent.getStringExtra("func")) || (d16 = com.tencent.mobileqq.structmsg.i.d(intent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES))) == null) {
            return;
        }
        ShareMsgHelper.g(qQAppInterface, intent.getStringExtra("uin"), intent.getIntExtra("uintype", -1), d16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3, int i16, String str, String str2, String str3) {
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null) {
            if (i3 != 3 && i3 != 4) {
                fVar.b(i16, str, str2, str3, 2);
            } else {
                fVar.b(i16, str, str2, str3, 8);
            }
        }
        try {
            MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-4008);
            d16.selfuin = qQAppInterface.getCurrentAccountUin();
            d16.frienduin = str;
            d16.senderuin = str3;
            d16.msgtype = -4008;
            d16.isread = true;
            d16.issend = 1;
            d16.istroop = i16;
            d16.time = com.tencent.mobileqq.service.message.e.K0();
            com.tencent.av.utils.an.m(qQAppInterface, 1, true, true, d16);
        } catch (Exception unused) {
        }
    }

    private void w(Intent intent, QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.qcall.f callFacade = qQAppInterface.getCallFacade();
        if (callFacade != null) {
            String stringExtra = intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
            if (stringExtra != null && !stringExtra.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                stringExtra = "+86" + stringExtra;
            }
            callFacade.E(stringExtra);
        }
    }

    private boolean x(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), f195185e);
    }

    public static boolean y(int i3) {
        if (i3 != 63 && i3 != 62 && i3 != 50 && i3 != 29 && i3 != 28 && i3 != 9 && i3 != 5 && i3 != 11 && i3 != 55 && i3 != 48 && i3 != 47 && i3 != 64) {
            return false;
        }
        return true;
    }

    public static boolean z() {
        Boolean bool = f195188h;
        if (bool != null) {
            return bool.booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        f195188h = Boolean.valueOf(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(f195186f, false));
        QLog.d(f195185e, 1, "isToggleEnableLocalVideoMsg " + f195188h);
        return f195188h.booleanValue();
    }

    void B(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("uinType", 0);
        String stringExtra = intent.getStringExtra("peerUin");
        String stringExtra2 = intent.getStringExtra("extraUin");
        byte[] byteArrayExtra = intent.getByteArrayExtra(PreloadTRTCPlayerParams.KEY_SIG);
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        VideoMsgTools.F(qQAppInterface, intExtra, stringExtra, stringExtra2, byteArrayExtra);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void C(Context context, Intent intent) {
        boolean z16;
        boolean z17;
        int i3;
        String str;
        QQAppInterface qQAppInterface;
        int i16;
        String str2;
        boolean z18;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_ADD_VIDEO_MSG");
        }
        int intExtra = intent.getIntExtra("uinType", 0);
        int intExtra2 = intent.getIntExtra(QQBrowserActivity.KEY_MSG_TYPE, 5);
        int intExtra3 = intent.getIntExtra("msgDetail", 0);
        boolean booleanExtra = intent.getBooleanExtra("isVideoMsg", true);
        String stringExtra = intent.getStringExtra("friendUin");
        String stringExtra2 = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        String stringExtra3 = intent.getStringExtra("selfUin");
        boolean booleanExtra2 = intent.getBooleanExtra("isSender", true);
        boolean booleanExtra3 = intent.getBooleanExtra("isRead", false);
        String stringExtra4 = intent.getStringExtra("extra");
        int intExtra4 = intent.getIntExtra("MultiAVType", 0);
        boolean booleanExtra4 = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_ADD_VIDEO_MSG selfUin = " + stringExtra3);
        }
        QQAppInterface qQAppInterface2 = this.f195191a.get();
        if (qQAppInterface2 != null) {
            if (intExtra2 != 0 || TextUtils.equals(stringExtra3, qQAppInterface2.getCurrentAccountUin())) {
                if ((intExtra2 == 2 || intExtra2 == 24) && stringExtra4 == null && QQUtils.k(qQAppInterface2.getApp())) {
                    boolean readValue = SettingCloneUtil.readValue((Context) qQAppInterface2.getApp(), qQAppInterface2.getCurrentAccountUin(), qQAppInterface2.getApp().getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
                    boolean readValue2 = SettingCloneUtil.readValue((Context) qQAppInterface2.getApp(), qQAppInterface2.getCurrentAccountUin(), qQAppInterface2.getApp().getString(R.string.f173079h50), AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true);
                    D(qQAppInterface2, readValue, readValue2);
                    if (readValue && readValue2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z16;
                    i3 = 17;
                } else {
                    if (intExtra2 == 17 || intExtra2 == 15 || intExtra2 == 16) {
                        A(intExtra, stringExtra, qQAppInterface2);
                    }
                    i3 = 17;
                    z17 = false;
                }
                if (intExtra2 == i3) {
                    str = String.valueOf(intExtra3);
                } else {
                    str = stringExtra4;
                }
                if (intExtra4 == 2 && stringExtra != null && !E(qQAppInterface2, stringExtra, intExtra2)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f195185e, 2, "addVideoMsgWithAvtype");
                }
                if (!booleanExtra4) {
                    qQAppInterface = qQAppInterface2;
                    i16 = intExtra4;
                    str2 = stringExtra;
                    if (!k(context, qQAppInterface2, intExtra, intExtra2, stringExtra, stringExtra2, booleanExtra2, str)) {
                        z18 = false;
                        if (!z18) {
                            i17 = intExtra;
                            VideoMsgTools.m(qQAppInterface, intExtra, intExtra2, booleanExtra, str2, stringExtra2, booleanExtra2, str, booleanExtra3, i16, new Object[0]);
                        } else {
                            i17 = intExtra;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f195185e, 2, "addVideoMsgWithAvtype end with enable:=" + z18);
                        }
                        if (!z17) {
                            com.tencent.mobileqq.managers.i iVar = (com.tencent.mobileqq.managers.i) qQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
                            String str3 = str2;
                            QQAppInterface qQAppInterface3 = qQAppInterface;
                            int i18 = i17;
                            iVar.i(qQAppInterface3, str3, i18, true, com.tencent.mobileqq.managers.d.a(str3, i17, intent), true);
                            iVar.f(qQAppInterface3, str3, i18, true, com.tencent.mobileqq.managers.d.a(str3, i17, intent));
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    qQAppInterface = qQAppInterface2;
                    i16 = intExtra4;
                    str2 = stringExtra;
                }
                z18 = true;
                if (!z18) {
                }
                if (QLog.isColorLevel()) {
                }
                if (!z17) {
                }
            }
        }
    }

    void D(QQAppInterface qQAppInterface, boolean z16, boolean z17) {
        MqqHandler handler;
        if (z16 && z17 && (handler = qQAppInterface.getHandler(ChatActivity.class)) != null) {
            handler.sendMessage(handler.obtainMessage(16711696));
        }
    }

    boolean E(QQAppInterface qQAppInterface, String str, int i3) {
        try {
            long parseLong = Long.parseLong(str);
            if (qQAppInterface == null) {
                return false;
            }
            AVNotifyCenter.i Q = qQAppInterface.getAVNotifyCenter().Q(parseLong, 2);
            if (Q != null && Q.f73809c > 0 && i3 == 13) {
                return false;
            }
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                if (troopManager.k(str) == null) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    void F(Context context, Intent intent) {
        RecentUserProxy recentUserProxy;
        com.tencent.mobileqq.qcall.f fVar;
        QQAppInterface qQAppInterface;
        int i3;
        boolean z16;
        int intExtra = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        int intExtra2 = intent.getIntExtra("uinType", 0);
        long longExtra = intent.getLongExtra("roomId", 0L);
        String stringExtra = intent.getStringExtra("peerUin");
        boolean booleanExtra = intent.getBooleanExtra("isReceiver", false);
        QLog.d(f195185e, 1, "onAnotherTerminal ACTION_VIDEO_ANOTHER_CHATING uinType: " + intExtra2 + ", peerUin: " + stringExtra + ", roomId: " + longExtra + ", isReceiver: " + booleanExtra + ",sessionType:" + intExtra);
        QQAppInterface qQAppInterface2 = this.f195191a.get();
        if (qQAppInterface2 == null) {
            QLog.d(f195185e, 1, "onAnotherTerminal app is null");
            return;
        }
        if (!x(stringExtra) && intExtra != 0) {
            QLog.d(f195185e, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "other terminal chating with: " + stringExtra + " , sessionType: " + intExtra + " ,uintype: " + intExtra2);
        }
        com.tencent.mobileqq.qcall.f fVar2 = (com.tencent.mobileqq.qcall.f) qQAppInterface2.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (intExtra == 0) {
            stringExtra = qQAppInterface2.getAVNotifyCenter().E(longExtra);
            QLog.i(f195185e, 1, "onAnotherTerminal roomId reset peerUin=" + stringExtra);
            qQAppInterface2.getAVNotifyCenter().x0(stringExtra);
            if (fVar2 != null && !TextUtils.isEmpty(stringExtra) && intExtra2 != 1 && fVar2.m(stringExtra, intExtra2) == 7) {
                fVar2.P(stringExtra, intExtra2, 0);
            }
            qQAppInterface = qQAppInterface2;
        } else {
            qQAppInterface2.getAVNotifyCenter().e(stringExtra, longExtra, intExtra);
            ProxyManager proxyManager = qQAppInterface2.getProxyManager();
            if (proxyManager != null) {
                recentUserProxy = proxyManager.m();
            } else {
                recentUserProxy = null;
            }
            if (recentUserProxy != null && recentUserProxy.findRecentUser(stringExtra, 0) == null && !booleanExtra && !com.tencent.av.utils.h.a(intExtra2, longExtra)) {
                if (intExtra == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                fVar = fVar2;
                qQAppInterface = qQAppInterface2;
                i3 = 1;
                VideoMsgTools.l(qQAppInterface2, intExtra2, 53, z16, stringExtra, qQAppInterface2.getCurrentUin(), true, null, true, new Object[0]);
            } else {
                fVar = fVar2;
                qQAppInterface = qQAppInterface2;
                i3 = 1;
            }
            if (intExtra2 != i3 && fVar != null && fVar.m(stringExtra, intExtra2) != 6) {
                fVar.P(stringExtra, intExtra2, 7);
            }
        }
        qQAppInterface.getAVNotifyCenter().p0(28, intExtra2, stringExtra, "");
    }

    void G(QQAppInterface qQAppInterface, Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("peerUin");
        long longExtra = intent.getLongExtra("roomId", 0L);
        if (longExtra != 0 && stringExtra != null) {
            if (QLog.isColorLevel()) {
                QLog.d(f195185e, 2, "<qav printer> message send: cmd[0x211, 0xb]");
            }
            ThreadManagerV2.excute(new Runnable(qQAppInterface, stringExtra, longExtra) { // from class: com.tencent.mobileqq.app.VideoBroadcastReceiver.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f195196d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f195197e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f195198f;

                {
                    this.f195196d = qQAppInterface;
                    this.f195197e = stringExtra;
                    this.f195198f = longExtra;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, VideoBroadcastReceiver.this, qQAppInterface, stringExtra, Long.valueOf(longExtra));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    VideoC2CHandler videoC2CHandler = (VideoC2CHandler) this.f195196d.getBusinessHandler(BusinessHandlerFactory.QAV_C2C_HANDLER);
                    if (videoC2CHandler != null) {
                        videoC2CHandler.f76885d = this.f195197e;
                        videoC2CHandler.f76886e = this.f195198f;
                        videoC2CHandler.F2();
                    }
                }
            }, 16, null, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void H(Context context, Intent intent) {
        long q16;
        QQAppInterface qQAppInterface;
        int intExtra = intent.getIntExtra("uinType", -2);
        String stringExtra = intent.getStringExtra("peerUin");
        int intExtra2 = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        int intExtra3 = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        boolean booleanExtra = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        if (booleanExtra) {
            if (intExtra2 == 3) {
                intExtra2 = 1;
            } else if (intExtra2 == 4) {
                intExtra2 = 2;
            }
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = String.valueOf(longExtra);
            }
        }
        if (intExtra3 == 0 && longExtra == 0) {
            q16 = AVUtil.q(stringExtra);
        } else {
            if (intExtra3 == 3 && longExtra == 0) {
                q16 = AVUtil.q(stringExtra);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f195185e, 2, "VideoConstants.ACTION_START_VIDEO_AVSWITCH relationType[" + intExtra3 + "], relationId[" + longExtra + "], sessionType[" + intExtra2 + "], uinType[" + intExtra + "], peerUin[" + stringExtra + "], isDoubleVideoMeeting[" + booleanExtra + "]");
            }
            qQAppInterface = this.f195191a.get();
            if (qQAppInterface != null) {
                return;
            }
            AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
            if (!booleanExtra && intExtra3 != 0) {
                aVNotifyCenter.S0(5, intExtra3, longExtra, intExtra2);
                qQAppInterface.getAVNotifyCenter().p0(28, intExtra, stringExtra, null);
                if (QLog.isDevelopLevel()) {
                    QLog.i(f195185e, 4, "onAvSwitch, SessionType[" + intExtra2 + "]");
                }
            } else {
                aVNotifyCenter.U0(5, stringExtra, intExtra2);
            }
            if (booleanExtra) {
                qQAppInterface.getAVNotifyCenter().G0(stringExtra, true);
                return;
            }
            return;
        }
        longExtra = q16;
        if (QLog.isColorLevel()) {
        }
        qQAppInterface = this.f195191a.get();
        if (qQAppInterface != null) {
        }
    }

    void I(Context context, Intent intent) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "VideoConstants.ACTION_CALLING_DIALOG");
        }
        boolean booleanExtra = intent.getBooleanExtra("isAudio", false);
        String stringExtra = intent.getStringExtra("friendUin");
        int intExtra = intent.getIntExtra("uinType", 0);
        int intExtra2 = intent.getIntExtra("type", 0);
        String stringExtra2 = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        boolean booleanExtra2 = intent.getBooleanExtra("isSender", false);
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        String string = qQAppInterface.getApp().getString(R.string.d_o);
        BaseApplication app = qQAppInterface.getApp();
        if (booleanExtra) {
            i3 = R.string.d_l;
        } else {
            i3 = R.string.d_p;
        }
        QQCustomDialog m06 = m0(context, string, app.getString(i3), new a(qQAppInterface, intExtra, intExtra2, booleanExtra, stringExtra, stringExtra2, booleanExtra2));
        DataReport.n(qQAppInterface.isBackgroundPause, booleanExtra);
        Message message = new Message();
        message.what = 1;
        message.obj = new Object[]{m06, Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra), stringExtra, stringExtra2, Boolean.valueOf(booleanExtra2)};
        this.f195193c.sendMessageDelayed(message, 10000L);
    }

    void J(Context context, Intent intent) {
        String y16;
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "VideoConstants.ACTION_CALLING_DIALOG_MULTI");
        }
        String valueOf = String.valueOf(intent.getLongExtra("friendUin", 0L));
        String valueOf2 = String.valueOf(intent.getLongExtra("relationId", 0L));
        int intExtra = intent.getIntExtra("uinType", 0);
        int intExtra2 = intent.getIntExtra("type", 0);
        String stringExtra = intent.getStringExtra("realSenderUin");
        String stringExtra2 = intent.getStringExtra("peerUin");
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        String string = qQAppInterface.getApp().getString(R.string.d_o);
        if (intExtra == 3000) {
            y16 = com.tencent.mobileqq.utils.ac.n(qQAppInterface, valueOf2, valueOf);
        } else if (intExtra == 1) {
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(valueOf2, valueOf, null, f195185e);
            if (troopMemberInfoSync != null) {
                y16 = troopMemberInfoSync.nickInfo.getShowName();
            } else {
                y16 = valueOf;
            }
        } else {
            y16 = com.tencent.mobileqq.utils.ac.y(qQAppInterface, valueOf);
        }
        String format = String.format(qQAppInterface.getApp().getString(R.string.d_n), y16);
        DataReport.Y(false, true);
        QQCustomDialog m06 = m0(context, string, format, new b(intExtra, qQAppInterface, intExtra2, valueOf2, valueOf, stringExtra2, stringExtra));
        DataReport.l(qQAppInterface.isBackgroundPause);
        Message message = new Message();
        message.what = 2;
        message.obj = new Object[]{m06, Integer.valueOf(intExtra), Integer.valueOf(intExtra2), valueOf2, valueOf, stringExtra2, stringExtra};
        this.f195193c.sendMessageDelayed(message, 10000L);
    }

    void K(Context context, Intent intent) {
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qQAppInterface.getApp().getApplicationContext(), 230, qQAppInterface.getApp().getString(R.string.dfp), qQAppInterface.getApp().getString(R.string.dg9), R.string.cancel, R.string.ddx, new c(), (DialogInterface.OnClickListener) null);
        createCustomDialog.getWindow().setType(2003);
        createCustomDialog.show();
        Message message = new Message();
        message.what = 3;
        message.obj = new Object[]{createCustomDialog};
        this.f195193c.sendMessageDelayed(message, 5000L);
    }

    void M(QQAppInterface qQAppInterface, Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("relationId");
        long longExtra = intent.getLongExtra("friendUin", 0L);
        if (longExtra == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(f195185e, 2, "ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:" + longExtra);
                return;
            }
            return;
        }
        ((GVideoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER)).D2(stringExtra, longExtra, intent.getStringExtra("inviteId"), intent.getIntExtra("dealResult", 1));
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            troopManager.h0(stringExtra, longExtra + "");
        }
    }

    void S(Context context, Intent intent) {
        String str;
        long j3;
        boolean booleanExtra = intent.getBooleanExtra("isPtt", false);
        int intExtra = intent.getIntExtra("uinType", 0);
        String stringExtra = intent.getStringExtra("friendUin");
        String stringExtra2 = intent.getStringExtra("friendName");
        String stringExtra3 = intent.getStringExtra("extraUin");
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_MSG_LEAVE uinType: " + intExtra + ", friendUin: " + stringExtra + ", friendNick: " + stringExtra2 + ", extraUin: " + stringExtra3 + ", isPtt: " + booleanExtra);
        }
        Bundle bundle = new Bundle();
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        if (!TextUtils.isEmpty(stringExtra) && intExtra != 1006) {
            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra);
            j3 = Long.parseLong(stringExtra);
        } else {
            str = "";
            j3 = -1;
        }
        if (intExtra == 1006) {
            if (!TextUtils.isEmpty(stringExtra3)) {
                str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra3);
                j3 = Long.parseLong(stringExtra3);
            }
        } else if (intExtra == 1000) {
            if (!TextUtils.isEmpty(stringExtra3)) {
                TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(stringExtra3);
                if (k3 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e(f195185e, 2, "findTroopInfo fail ,uin : " + stringExtra3);
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(k3.troopcode)) {
                    bundle.putLong("key_groupUin", Long.parseLong(k3.troopcode));
                }
            }
        } else if (intExtra == 1004) {
            if (!TextUtils.isEmpty(stringExtra3)) {
                bundle.putLong("key_groupUin", Long.parseLong(stringExtra3));
            }
        } else if (intExtra == 1044) {
            ReportController.o(null, "dc00898", "", "", "0X800AD97", "0X800AD97", 0, 0, "", "", "", "");
        }
        if (booleanExtra) {
            bundle.putInt("key_open_panel", 1000);
        } else {
            bundle.putBoolean("key_open_keyboard", true);
        }
        Message message = new Message();
        message.what = 4;
        message.obj = new Object[]{Integer.valueOf(intExtra), str, stringExtra2, Long.valueOf(j3), bundle};
        this.f195193c.sendMessageDelayed(message, 300L);
    }

    void T(Context context, Intent intent) {
        String uidFromUin;
        long parseLong;
        long parseLong2;
        String str;
        int intExtra = intent.getIntExtra("uinType", 0);
        String stringExtra = intent.getStringExtra("friendUin");
        String stringExtra2 = intent.getStringExtra("friendName");
        String stringExtra3 = intent.getStringExtra("extraUin");
        String stringExtra4 = intent.getStringExtra("replyMsg");
        boolean booleanExtra = intent.getBooleanExtra("isDiyMsg", false);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_MSG_REPLY uinType: " + intExtra + ", friendUin: " + stringExtra + ", friendNick: " + stringExtra2 + ", extraUin: " + stringExtra3 + ", replyMsg: " + stringExtra4 + ", isDiyMsg: " + booleanExtra);
        }
        if (booleanExtra) {
            Bundle bundle = new Bundle();
            QQAppInterface qQAppInterface = this.f195191a.get();
            if (qQAppInterface == null) {
                return;
            }
            if (intExtra == 1006) {
                uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra3);
                parseLong = Long.parseLong(stringExtra3);
            } else {
                if (intExtra == 1000) {
                    String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra);
                    parseLong2 = Long.parseLong(stringExtra);
                    bundle.putLong("key_groupUin", Long.parseLong(((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(stringExtra3).troopcode));
                    str = uidFromUin2;
                    bundle.putBoolean("key_open_keyboard", true);
                    ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIO(context, com.tencent.nt.adapter.session.c.l(intExtra), str, stringExtra2, parseLong2, bundle);
                    return;
                }
                if (intExtra == 1004) {
                    uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra);
                    parseLong = Long.parseLong(stringExtra);
                    bundle.putLong("key_groupUin", Long.parseLong(stringExtra3));
                } else if (intExtra == 1044) {
                    uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra);
                    parseLong = Long.parseLong(stringExtra);
                } else {
                    uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra);
                    parseLong = Long.parseLong(stringExtra);
                }
            }
            str = uidFromUin;
            parseLong2 = parseLong;
            bundle.putBoolean("key_open_keyboard", true);
            ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIO(context, com.tencent.nt.adapter.session.c.l(intExtra), str, stringExtra2, parseLong2, bundle);
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.obj = new Object[]{Integer.valueOf(intExtra), stringExtra2, stringExtra3, stringExtra, context, stringExtra4};
        this.f195193c.sendMessageDelayed(message, 300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void U(QQAppInterface qQAppInterface, Context context, Intent intent, int i3, boolean z16, int i16) {
        int i17;
        long j3;
        long j16;
        long j17;
        boolean z17;
        com.tencent.mobileqq.qcall.f fVar;
        RecentUser findRecentUserByUin;
        int intExtra = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        long longExtra2 = intent.getLongExtra("friendUin", 0L);
        int intExtra2 = intent.getIntExtra("roomUserNum", 0);
        qQAppInterface.getAVNotifyCenter().S0(9, intExtra, longExtra, 3);
        if (longExtra2 == Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue()) {
            qQAppInterface.getAVNotifyCenter().D0(intExtra, Long.valueOf(longExtra), true);
            qQAppInterface.getAVNotifyCenter().S0(9, intExtra, longExtra, 3);
            qQAppInterface.getAVNotifyCenter().s0(intExtra, longExtra);
            qQAppInterface.getAVNotifyCenter().B0(12, longExtra, i16);
            if (intExtra2 == 1) {
                qQAppInterface.getAVNotifyCenter().b1(intExtra, longExtra, true, false);
            } else {
                qQAppInterface.getAVNotifyCenter().b1(intExtra, longExtra, false, false);
                qQAppInterface.getAVNotifyCenter().d1(true);
            }
            RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
            if (m3 != null) {
                String valueOf = String.valueOf(longExtra);
                int avRelationType2UinType = com.tencent.av.utils.ba.avRelationType2UinType(intExtra);
                if (avRelationType2UinType != -1 && avRelationType2UinType != 1011 && !TextUtils.isEmpty(valueOf)) {
                    if (avRelationType2UinType == 1) {
                        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                        if (troopManager != null && troopManager.k(valueOf) != null && (findRecentUserByUin = m3.findRecentUserByUin(valueOf, avRelationType2UinType)) != null) {
                            findRecentUserByUin.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
                            m3.saveRecentUser(findRecentUserByUin);
                        }
                    } else {
                        RecentUser findRecentUserByUin2 = m3.findRecentUserByUin(valueOf, avRelationType2UinType);
                        if (findRecentUserByUin2 != null) {
                            findRecentUserByUin2.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
                            m3.saveRecentUser(findRecentUserByUin2);
                        }
                    }
                }
            }
            if (intExtra != 1 && intExtra != 7 && intExtra != 9 && intExtra != 10 && (fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)) != null) {
                j3 = longExtra2;
                i17 = intExtra2;
                j16 = longExtra;
                z17 = true;
                fVar.O(longExtra, longExtra2, true, -1L, z16);
            } else {
                i17 = intExtra2;
                j3 = longExtra2;
                j16 = longExtra;
                z17 = true;
            }
            if (qQAppInterface.getAVNotifyCenter().n() == j16 && qQAppInterface.getAVNotifyCenter().J() >= 4 && qQAppInterface.getAVNotifyCenter().k0()) {
                qQAppInterface.getAVNotifyCenter().d1(z17);
                qQAppInterface.getAVNotifyCenter().O0(z17);
            }
        } else {
            i17 = intExtra2;
            j3 = longExtra2;
            j16 = longExtra;
            if (qQAppInterface.getAVNotifyCenter().n() == j16 && qQAppInterface.getAVNotifyCenter().k0()) {
                j17 = j3;
                qQAppInterface.getAVNotifyCenter().b1(intExtra, j16, false, false);
                qQAppInterface.getAVNotifyCenter().d1(true);
                qQAppInterface.getAVNotifyCenter().O0(true);
                qQAppInterface.getAVNotifyCenter().m0(i3, intExtra, j16, j17);
                if (!QLog.isColorLevel()) {
                    QLog.d(f195185e, 2, "member join discussId: " + j16 + ", friendUin: " + j17 + ", roomUserNum:" + i17);
                    return;
                }
                return;
            }
        }
        j17 = j3;
        qQAppInterface.getAVNotifyCenter().m0(i3, intExtra, j16, j17);
        if (!QLog.isColorLevel()) {
        }
    }

    void V(QQAppInterface qQAppInterface, Context context, Intent intent, int i3, boolean z16, int i16) {
        long j3;
        long j16;
        int i17;
        int i18;
        long j17;
        long j18;
        com.tencent.mobileqq.qcall.f fVar;
        int intExtra = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        long longExtra2 = intent.getLongExtra("friendUin", 0L);
        int intExtra2 = intent.getIntExtra("roomUserNum", 0);
        if (longExtra2 == Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue()) {
            long longExtra3 = intent.getLongExtra("time", 0L);
            qQAppInterface.getAVNotifyCenter().S0(9, intExtra, longExtra, 0);
            qQAppInterface.getAVNotifyCenter().D0(intExtra, Long.valueOf(longExtra), false);
            qQAppInterface.getAVNotifyCenter().t0(intExtra, longExtra, i16);
            qQAppInterface.getAVNotifyCenter().S0(9, intExtra, longExtra, 0);
            qQAppInterface.getAVNotifyCenter().d1(false);
            if (intExtra != 1 && (fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)) != null) {
                j3 = longExtra2;
                j16 = longExtra;
                i17 = intExtra2;
                fVar.O(longExtra, longExtra2, false, longExtra3, z16);
            } else {
                j3 = longExtra2;
                j16 = longExtra;
                i17 = intExtra2;
            }
            QAVHrMeeting.q(qQAppInterface, intent, intExtra, j16);
            i18 = 1;
        } else {
            j3 = longExtra2;
            j16 = longExtra;
            i17 = intExtra2;
            i18 = 1;
        }
        if (i17 == i18) {
            j17 = j16;
            j18 = j3;
            qQAppInterface.getAVNotifyCenter().b1(intExtra, j17, true, false);
        } else {
            j17 = j16;
            j18 = j3;
        }
        qQAppInterface.getAVNotifyCenter().m0(i3, intExtra, j17, j18);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "member quit discussId: " + j17 + ", friendUin: " + j18);
        }
    }

    void W(long j3, Context context, Intent intent) {
        int intExtra = intent.getIntExtra("type", 20);
        boolean booleanExtra = intent.getBooleanExtra("isStart", false);
        int intExtra2 = intent.getIntExtra("MultiAVType", 0);
        if (QQAudioHelper.j() || intExtra == 22 || intExtra == 23 || intExtra == 25) {
            QQAudioHelper.l(f195185e + ".onMultiMsgV2Q", intent.getExtras());
        }
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(f195185e, 4, "onMultiMsgV2Q, type[" + intExtra + "]");
        }
        if (intExtra == 22) {
            U(qQAppInterface, context, intent, intExtra, booleanExtra, intExtra2);
            return;
        }
        if (intExtra == 23) {
            V(qQAppInterface, context, intent, intExtra, booleanExtra, intExtra2);
            return;
        }
        if (intExtra == 32) {
            long longExtra = intent.getLongExtra("relationId", -1L);
            int intExtra3 = intent.getIntExtra("uinType", -1);
            if (intExtra3 == 1) {
                qQAppInterface.getAVNotifyCenter().n0(intExtra, intExtra3, longExtra, intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, 1), intExtra2);
                return;
            }
            return;
        }
        if (intExtra == 33) {
            long longExtra2 = intent.getLongExtra("relationId", -1L);
            int intExtra4 = intent.getIntExtra("uinType", -1);
            long longExtra3 = intent.getLongExtra("info", -1L);
            String stringExtra = intent.getStringExtra("strMsg");
            if (intExtra4 == 1 || intExtra4 == 0) {
                Message message = new Message();
                message.what = 5;
                message.obj = new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra4), Long.valueOf(longExtra2), Long.valueOf(longExtra3), stringExtra};
                this.f195193c.sendMessageDelayed(message, 500L);
                return;
            }
            return;
        }
        if (intExtra == 25) {
            X(qQAppInterface, context, intent, intExtra2);
            return;
        }
        if (intExtra == 401) {
            O(intent, qQAppInterface);
            return;
        }
        if (intExtra == 402) {
            P(intent, qQAppInterface);
            return;
        }
        if (intExtra == 403) {
            N(intent, qQAppInterface);
            return;
        }
        if (intExtra == 411) {
            h(intent, qQAppInterface);
        } else if (intExtra == 540) {
            Q(intent, qQAppInterface);
        } else if (intExtra == 539) {
            Y(intent, qQAppInterface);
        }
    }

    void X(QQAppInterface qQAppInterface, Context context, Intent intent, int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        AVNotifyCenter.i Q;
        long longExtra = intent.getLongExtra("relationId", -1L);
        int intExtra = intent.getIntExtra("relationType", -1);
        int intExtra2 = intent.getIntExtra("reason", -1);
        boolean booleanExtra = intent.getBooleanExtra("openClass", false);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "TYPE_GAUDIO_ROOM_DESTROY-->relationid=" + longExtra + " relationType=" + intExtra + " reason=" + intExtra2 + " avtype" + i3);
        }
        if (intExtra2 == 4) {
            i16 = 4;
            qQAppInterface.getAVNotifyCenter().n0(32, 1, longExtra, intExtra2, i3);
        } else {
            i16 = 4;
        }
        if (!booleanExtra && intExtra == 1 && i3 == 2 && (Q = qQAppInterface.getAVNotifyCenter().Q(longExtra, i3)) != null && Q.f73812f == 2 && Q.f73813g == i16) {
            booleanExtra = true;
        }
        AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
        if (booleanExtra) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        if (booleanExtra) {
            i18 = i16;
        } else {
            i18 = 0;
        }
        if (booleanExtra) {
            i19 = 0;
        } else {
            i19 = -1;
        }
        aVNotifyCenter.a1(9, longExtra, i3, i17, i18, i19, 25, 0);
        if (qQAppInterface.getAVNotifyCenter().y(intExtra, longExtra) > 0) {
            qQAppInterface.getAVNotifyCenter().I0(13, intExtra, longExtra, null, 0L);
            VideoMsgTools.m(qQAppInterface, intExtra, 14, false, String.valueOf(longExtra), qQAppInterface.getCurrentAccountUin(), false, null, false, i3, new Object[0]);
            qQAppInterface.getAVNotifyCenter().m0(21, intExtra, longExtra, 0L);
        } else if (QLog.isColorLevel()) {
            QLog.w(f195185e, 2, "MultiRoomMemberNum is 0");
        }
    }

    void Z(QQAppInterface qQAppInterface, Context context, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "VideoConstants.ACTION_GAUDIO_TROOP_CARD");
        }
        String stringExtra = intent.getStringExtra("troopUin");
        String stringExtra2 = intent.getStringExtra("memberUin");
        if (intent.getIntExtra("uinType", -1) == 3000) {
            if (stringExtra2.equals(qQAppInterface.getCurrentAccountUin())) {
                AllInOne allInOne = new AllInOne(stringExtra2, 0);
                allInOne.lastActivity = 5;
                ProfileUtils.openProfileCard(context, allInOne);
                return;
            } else {
                if (x(stringExtra2)) {
                    AllInOne allInOne2 = new AllInOne(stringExtra2, 1);
                    allInOne2.nickname = com.tencent.mobileqq.utils.ac.Q(qQAppInterface, stringExtra2, 0);
                    allInOne2.lastActivity = 5;
                    ProfileUtils.openProfileCard(context, allInOne2);
                    return;
                }
                AllInOne allInOne3 = new AllInOne(stringExtra2, 46);
                allInOne3.nickname = com.tencent.mobileqq.utils.ac.Q(qQAppInterface, stringExtra2, 0);
                allInOne3.preWinUin = stringExtra2;
                allInOne3.preWinType = 3000;
                allInOne3.discussUin = stringExtra;
                allInOne3.lastActivity = 5;
                ProfileUtils.openProfileCard(context, allInOne3);
                return;
            }
        }
        com.tencent.mobileqq.profile.l.d(qQAppInterface, qQAppInterface.getApp(), stringExtra, stringExtra2, 0, -1);
    }

    void a0(Context context, Intent intent) {
        f195189i = false;
        f195190j = 0;
        if (intent.getIntExtra("type", 38) == 38) {
            int intExtra = intent.getIntExtra("safeCode", -1);
            String stringExtra = intent.getStringExtra("safeUrl");
            String stringExtra2 = intent.getStringExtra("safeStr");
            QLog.i(f195185e, 1, "onSecurityLimitV2Q: safe code: " + intExtra + " safe url: " + stringExtra + " safe str: " + stringExtra2);
            if (TextUtils.isEmpty(stringExtra2)) {
                QLog.i(f195185e, 1, "onSecurityLimitV2Q safe info empty");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.obj = new Object[]{Integer.valueOf(intExtra), stringExtra, stringExtra2};
            this.f195193c.sendMessageDelayed(obtain, 1000L);
        }
    }

    void b0(Context context, Intent intent) {
        IEarlyDownloadService iEarlyDownloadService;
        if (QLog.isColorLevel()) {
            QLog.w(f195185e, 2, "EarlyDownload trigger AV so EarlyDownload");
        }
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface != null && (iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")) != null) {
            ThreadManagerV2.excute(new Runnable((com.tencent.mobileqq.earlydownload.handler.k) iEarlyDownloadService.getEarlyHandler("qq.android.qav.muteaudio")) { // from class: com.tencent.mobileqq.app.VideoBroadcastReceiver.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.earlydownload.handler.k f195195d;

                {
                    this.f195195d = r5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoBroadcastReceiver.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.earlydownload.handler.k kVar = this.f195195d;
                    if (kVar != null) {
                        kVar.I(false);
                    }
                }
            }, 128, null, false);
        }
    }

    void c0(Context context, Intent intent) {
        boolean z16;
        String valueOf;
        int intExtra = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        int intExtra2 = intent.getIntExtra("uinType", 0);
        int intExtra3 = intent.getIntExtra("bindType", 0);
        String stringExtra = intent.getStringExtra("bindId");
        String stringExtra2 = intent.getStringExtra("peerUin");
        String stringExtra3 = intent.getStringExtra("extraUin");
        boolean booleanExtra = intent.getBooleanExtra("isReceiver", false);
        boolean booleanExtra2 = intent.getBooleanExtra("isDouble", true);
        boolean booleanExtra3 = intent.getBooleanExtra("updateTime", false);
        boolean booleanExtra4 = intent.getBooleanExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, false);
        int intExtra4 = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        boolean booleanExtra5 = intent.getBooleanExtra("isNearbyVideoChat", false);
        boolean booleanExtra6 = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        if (booleanExtra6) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = String.valueOf(longExtra);
            }
            if (intExtra == 3) {
                intExtra = 1;
            } else if (intExtra == 4) {
                intExtra = 2;
            }
            if (QLog.isColorLevel()) {
                QLog.i(f195185e, 2, "onStartVideoChat, double meeting. peer[" + stringExtra2 + "], sessionType[" + intExtra + "]");
            }
            booleanExtra2 = true;
            intExtra2 = 0;
        }
        if (QQAudioHelper.j()) {
            QQAudioHelper.m("onStartVideoChat[VideoConstants.ACTION_START_VIDEO_CHAT]", intent.getExtras(), true);
        }
        if (intExtra2 == -1) {
            return;
        }
        if (booleanExtra2) {
            if ((stringExtra2 == null || stringExtra2.length() <= 2) && (stringExtra3 == null || stringExtra3.length() <= 2)) {
                return;
            }
        } else if (longExtra < 100) {
            return;
        }
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        if (booleanExtra) {
            qQAppInterface.getAVNotifyCenter().C0(booleanExtra);
        }
        if (booleanExtra3) {
            qQAppInterface.getAVNotifyCenter().O0(true);
            qQAppInterface.getAVNotifyCenter().d1(true);
        } else if (booleanExtra4 && !qQAppInterface.getAVNotifyCenter().h0()) {
            qQAppInterface.getAVNotifyCenter().d1(true);
        }
        if (booleanExtra2) {
            qQAppInterface.getAVNotifyCenter().U0(6, stringExtra2, intExtra);
            qQAppInterface.getAVNotifyCenter().E0(intExtra2, stringExtra2, stringExtra3, booleanExtra);
            qQAppInterface.getAVNotifyCenter().c1(com.tencent.av.utils.ba.uinType2AVRelationType(intExtra2), stringExtra2, !booleanExtra4, booleanExtra);
            if (booleanExtra6) {
                qQAppInterface.getAVNotifyCenter().G0(stringExtra2, true);
            }
            valueOf = stringExtra2;
            z16 = booleanExtra5;
        } else {
            qQAppInterface.getAVNotifyCenter().D0(intExtra4, Long.valueOf(longExtra), true);
            z16 = booleanExtra5;
            qQAppInterface.getAVNotifyCenter().S0(6, intExtra4, longExtra, intExtra);
            qQAppInterface.getAVNotifyCenter().b1(intExtra4, longExtra, !booleanExtra4, booleanExtra);
            valueOf = String.valueOf(longExtra);
        }
        qQAppInterface.getAVNotifyCenter().L0(z16);
        qQAppInterface.getAVNotifyCenter().p0(28, intExtra2, valueOf, stringExtra3);
        if (intExtra2 != 1 && intExtra2 != 9500 && intExtra2 != 1011) {
            e0(qQAppInterface, stringExtra3, intExtra2, valueOf, intExtra3, booleanExtra4, stringExtra, booleanExtra, z16);
        }
    }

    void e0(QQAppInterface qQAppInterface, String str, int i3, String str2, int i16, boolean z16, String str3, boolean z17, boolean z18) {
        String str4;
        RecentUserProxy m3;
        RecentUser findRecentUserByUin;
        if (!TextUtils.isEmpty(str) && i3 == 1006 && (str2 == null || !str2.contains(Marker.ANY_NON_NULL_MARKER))) {
            str4 = str;
        } else {
            str4 = str2;
        }
        d0(qQAppInterface, i3, str4, i16, z16, str3, z17);
        if (i3 != 1008) {
            try {
                if ((com.tencent.imcore.message.ao.z(str4, i3) || !com.tencent.imcore.message.ao.q(i3) || qQAppInterface.getConversationFacade().i0(str4, i3)) && i16 != 2 && i16 != 3 && i3 != 25 && !z18 && (m3 = qQAppInterface.getProxyManager().m()) != null && m3.findRecentUser(str4, i3) == null && !TextUtils.isEmpty(str4) && str4.length() > 2 && (findRecentUserByUin = m3.findRecentUserByUin(str4, i3)) != null) {
                    findRecentUserByUin.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
                    m3.saveRecentUser(findRecentUserByUin);
                }
            } catch (Exception unused) {
            }
        }
    }

    void f0(Context context, Intent intent) {
        long j3;
        RecentUserProxy m3;
        RecentUser findRecentUserByUin;
        intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        int intExtra = intent.getIntExtra("uinType", 0);
        String stringExtra = intent.getStringExtra("peerUin");
        try {
            j3 = Long.parseLong(stringExtra);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j3 = 0;
        }
        if (j3 == 0) {
            QLog.i(f195185e, 2, "onStartVideoDoubleMeeting, uin is 0.");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("isReceiver", false);
        boolean booleanExtra2 = intent.getBooleanExtra("updateTime", false);
        boolean booleanExtra3 = intent.getBooleanExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, false);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_START_DOUBLE_VIDEO_MEETING uinType: " + intExtra + ", peerUin: " + stringExtra + ", updateTime: " + booleanExtra2 + ", showTime: " + booleanExtra3);
        }
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        if (booleanExtra2) {
            qQAppInterface.getAVNotifyCenter().O0(true);
            qQAppInterface.getAVNotifyCenter().d1(true);
        }
        qQAppInterface.getAVNotifyCenter().U0(7, stringExtra, 2);
        qQAppInterface.getAVNotifyCenter().E0(intExtra, stringExtra, null, booleanExtra);
        qQAppInterface.getAVNotifyCenter().G0(stringExtra, true);
        qQAppInterface.getAVNotifyCenter().b1(0, j3, !booleanExtra3, true);
        if (intExtra == 0) {
            com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
            if (booleanExtra3) {
                fVar.P(stringExtra, intExtra, 6);
            } else {
                fVar.P(stringExtra, intExtra, 5);
            }
            try {
                if ((com.tencent.imcore.message.ao.z(stringExtra, intExtra) || !com.tencent.imcore.message.ao.q(intExtra) || qQAppInterface.getConversationFacade().i0(stringExtra, intExtra)) && (m3 = qQAppInterface.getProxyManager().m()) != null && m3.findRecentUser(stringExtra, intExtra) == null && !TextUtils.isEmpty(stringExtra) && (findRecentUserByUin = m3.findRecentUserByUin(stringExtra, intExtra)) != null) {
                    findRecentUserByUin.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
                    m3.saveRecentUser(findRecentUserByUin);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f195185e, 2, "Recent User Proxy Error-->e=" + e16.getMessage());
                }
            }
        }
    }

    void g0(Context context, Intent intent) {
        QQAppInterface qQAppInterface;
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("nickName");
        String stringExtra3 = intent.getStringExtra("headUrl");
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_RANDOM_UPDATE_CHAT_INFO uin:" + stringExtra + ", nickName: " + stringExtra2 + ", headUrl: " + stringExtra3);
        }
        if (TextUtils.isEmpty(stringExtra) || (qQAppInterface = this.f195191a.get()) == null) {
            return;
        }
        qQAppInterface.getAVNotifyCenter().Q0(stringExtra, stringExtra2, stringExtra3);
    }

    void h0(Context context, Intent intent) {
        long j3;
        boolean z16;
        String str;
        int intExtra = intent.getIntExtra("uinType", 0);
        int intExtra2 = intent.getIntExtra("bindType", 0);
        String stringExtra = intent.getStringExtra("bindId");
        String stringExtra2 = intent.getStringExtra("peerUin");
        String stringExtra3 = intent.getStringExtra("extraUin");
        int intExtra3 = intent.getIntExtra("stopReason", 0);
        String stringExtra4 = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        String stringExtra5 = intent.getStringExtra("selfUin");
        boolean booleanExtra = intent.getBooleanExtra("isDouble", true);
        boolean booleanExtra2 = intent.getBooleanExtra("isSystemCalling", false);
        int intExtra4 = intent.getIntExtra("relationType", 0);
        long longExtra = intent.getLongExtra("relationId", 0L);
        long longExtra2 = intent.getLongExtra(com.tencent.av.q.f74198i, 0L);
        long longExtra3 = intent.getLongExtra(com.tencent.av.q.f74199j, 0L);
        long longExtra4 = intent.getLongExtra(com.tencent.av.q.f74196g, 0L);
        long longExtra5 = intent.getLongExtra(com.tencent.av.q.f74201l, 0L);
        long longExtra6 = intent.getLongExtra(com.tencent.av.q.f74202m, 0L);
        long longExtra7 = intent.getLongExtra("score_connect_duration", 0L);
        int intExtra5 = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        if (intent.getBooleanExtra("isDoubleVideoMeeting", false)) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = String.valueOf(longExtra);
            }
            if (longExtra == 0) {
                longExtra = AVUtil.q(stringExtra2);
            }
            j3 = longExtra;
            z16 = true;
        } else {
            j3 = longExtra;
            z16 = booleanExtra;
        }
        if (QQAudioHelper.j()) {
            QQAudioHelper.m("onVideoChatEnd[VideoConstants.ACTION_STOP_VIDEO_CHAT]", intent.getExtras(), true);
        }
        if (intExtra == 26) {
            str = stringExtra3;
        } else {
            str = stringExtra2;
        }
        QQAppInterface qQAppInterface = this.f195191a.get();
        if (qQAppInterface == null) {
            return;
        }
        i(intent, intExtra, str, stringExtra3, intExtra3, stringExtra5, z16, intExtra4, j3, qQAppInterface);
        if (intExtra != 1 && intExtra != 1011 && intExtra != 9500) {
            i0(qQAppInterface, intent, intExtra3, booleanExtra2, stringExtra5, stringExtra4, stringExtra3, intExtra, str, intExtra2, stringExtra, longExtra7, longExtra2, longExtra3, longExtra5, longExtra6, longExtra4, intExtra5);
        }
    }

    void i0(QQAppInterface qQAppInterface, Intent intent, int i3, boolean z16, String str, String str2, String str3, int i16, String str4, int i17, String str5, long j3, long j16, long j17, long j18, long j19, long j26, int i18) {
        if (i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 8) {
            L(qQAppInterface, i3, z16, str, str2, str3, i16, str4);
        } else if (i3 == 0 || i3 == 1 || i3 == 2) {
            R(qQAppInterface, intent, str, str3, i16, str4, i17, str5, j3, j16, j17, j18, j19, j26, i18);
        }
    }

    void j0(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("size", 0L);
        if (QLog.isColorLevel()) {
            QLog.d(f195185e, 2, "ACTION_VIDEO_FLOW_SIZE: " + longExtra);
        }
        this.f195191a.get();
    }

    protected boolean n(QQAppInterface qQAppInterface, String str, Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, context, intent)).booleanValue();
        }
        if (str.equals("tencent.video.v2q.AddMsgSig")) {
            B(context, intent);
        } else if (str.equals("tencent.video.v2q.CallingDialog")) {
            I(context, intent);
        } else if (str.equals("tencent.video.v2q.CallingDialogMulti")) {
            J(context, intent);
        } else if (str.equals("tencent.video.v2q.updateChatInfo")) {
            g0(context, intent);
        } else if (str.equals("tencent.av.v2q.CheckChatAbility")) {
            K(context, intent);
        } else if (str.equals("tencent.video.v2q.downloadGAudioSound")) {
            b0(context, intent);
        } else if (str.equals("tencent.video.v2q.AddContactsToDiscuss")) {
            VideoMsgTools.d(qQAppInterface, intent.getStringExtra("discussUin"));
        } else if (str.equals("tencent.video.v2q.MeetingMemberManager")) {
            VideoMsgTools.w(qQAppInterface, intent.getStringExtra("discussUin"));
        } else {
            if (!str.equals("tencent.video.v2q.AddContactsFromC2C")) {
                return false;
            }
            g(intent, qQAppInterface);
        }
        return true;
    }

    protected boolean o(QQAppInterface qQAppInterface, String str, Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, qQAppInterface, str, context, intent)).booleanValue();
        }
        if (str.equals("tencent.video.v2q.replyMsg")) {
            T(context, intent);
        } else if (str.equals("tencent.video.v2q.leaveMsg")) {
            S(context, intent);
        } else if (str.equals("tencent.video.v2q.AudioEngineReady")) {
            G(qQAppInterface, context, intent);
        } else if (str.equals("tencent.video.v2q.GaudioOpenTroopCard")) {
            Z(qQAppInterface, context, intent);
        } else if (str.equals("tencent.video.v2q.BindContact")) {
            j(context, qQAppInterface);
        } else if (str.equals("tencent.video.v2q.OpenContactList")) {
            k0(context, qQAppInterface);
        } else if (str.equals("tencent.video.v2q.AnnimateDownloadStart")) {
            q(intent, qQAppInterface);
        } else if (str.equals("tencent.video.v2q.commingRingDownload")) {
            r(intent, qQAppInterface);
        } else {
            if (!str.equals(AppConstants.CHAT_BACKGROUND_BROADCAST)) {
                return false;
            }
            l(context, intent, qQAppInterface);
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        WeakReference<QQAppInterface> weakReference = this.f195191a;
        if (weakReference == null) {
            qQAppInterface = null;
        } else {
            qQAppInterface = weakReference.get();
        }
        if (qQAppInterface != null && action != null) {
            String str = intent.getPackage();
            if (!TextUtils.isEmpty(str) && TextUtils.equals(str, qQAppInterface.getApp().getPackageName())) {
                boolean m3 = m(action, context, intent);
                if (!m3) {
                    m3 = n(qQAppInterface, action, context, intent);
                }
                if (!m3) {
                    m3 = o(qQAppInterface, action, context, intent);
                }
                if (!m3) {
                    m3 = p(qQAppInterface, action, context, intent);
                }
                if (!m3 && QLog.isDevelopLevel()) {
                    QLog.i(f195185e, 4, "onReceive, no deal action[" + action + "]");
                    return;
                }
                return;
            }
            QLog.d(f195185e, 1, "onReceive broadcast from wrong package:" + intent.getPackage() + ",action:" + action);
        }
    }

    protected boolean p(QQAppInterface qQAppInterface, String str, Context context, Intent intent) {
        QQAppInterface qQAppInterface2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qQAppInterface, str, context, intent)).booleanValue();
        }
        long a16 = com.tencent.av.utils.at.a(intent);
        if (str.equals("tencent.video.v2q.insertSystemCall")) {
            w(intent, qQAppInterface);
            return true;
        }
        if (str.equals("tencent.video.v2q.upgradeInvite")) {
            VideoMsgTools.E(qQAppInterface, intent.getStringExtra("peerUin"), intent.getIntExtra("type", 0));
            return true;
        }
        if (str.equals("tencent.video.v2q.SmallScreenState")) {
            n0(intent, a16, qQAppInterface);
            return true;
        }
        if (str.equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO")) {
            t(intent, qQAppInterface);
            return true;
        }
        if (str.equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO")) {
            M(qQAppInterface, context, intent);
            return true;
        }
        if (str.equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END")) {
            s(intent, qQAppInterface);
            return true;
        }
        if (str.equals("tencent.video.v2q.generalFuncCall")) {
            u(intent, qQAppInterface);
            return true;
        }
        if (str.equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED")) {
            ((com.tencent.mobileqq.intervideo.now.dynamic.b) qQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).e();
            return true;
        }
        if (str.equals("tencent.video.v2q.AddMembersToGroup")) {
            VideoMsgTools.e(qQAppInterface, context, intent);
            return true;
        }
        if (!"tencent.video.v2q.checkPtuRes".equals(str)) {
            return false;
        }
        WeakReference<QQAppInterface> weakReference = this.f195191a;
        if (weakReference == null) {
            qQAppInterface2 = null;
        } else {
            qQAppInterface2 = weakReference.get();
        }
        uv.b.c(qQAppInterface2, intent);
        return true;
    }
}
