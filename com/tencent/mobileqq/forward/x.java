package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.OpenSdkConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.OpenSdkShareReporterProxy;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.b;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneShareManager;
import java.security.MessageDigest;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ArkJsonBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ClientInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ExtInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$MiniAppMsgBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$RichMsgBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class x implements Handler.Callback, com.tencent.mobileqq.activity.aio.helper.u {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f211080d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f211081d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f211082e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f211083f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ b.a f211084h;

        a(long j3, int i3, Activity activity, b.a aVar) {
            this.f211081d = j3;
            this.f211082e = i3;
            this.f211083f = activity;
            this.f211084h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), activity, aVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->qbShowShareResultDialog--stay");
            }
            x.q(this.f211081d, this.f211082e, this.f211083f);
            OpenSdkShareReporterProxy.d().f(true, this.f211084h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f211085d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f211086e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f211087f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f211088h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ b.a f211089i;

        b(long j3, int i3, Activity activity, com.tencent.aio.api.runtime.a aVar, b.a aVar2) {
            this.f211085d = j3;
            this.f211086e = i3;
            this.f211087f = activity;
            this.f211088h = aVar;
            this.f211089i = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), activity, aVar, aVar2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog back");
            }
            x.f(this.f211085d, this.f211086e, this.f211087f, this.f211088h);
            OpenSdkShareReporterProxy.d().f(false, this.f211089i);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f211080d = HardCodeUtil.qqStr(R.string.vrk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Activity a(x xVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ QQCustomDialog b(x xVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Dialog c(x xVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void d(x xVar, QQCustomDialog qQCustomDialog) {
        throw null;
    }

    public static void e(long j3, int i3, Activity activity, a61.c cVar) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        com.tencent.biz.common.util.k.i(qQAppInterface, "", "choose", j3, i3, "back");
        ReportCenter.f().q(qQAppInterface.getAccount(), "", String.valueOf(j3), "1000", "51", "0", false, true);
        com.tencent.biz.common.util.k.k(activity, 0, "", "");
        if (activity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
            try {
                PendingIntent pendingIntent = (PendingIntent) activity.getIntent().getParcelableExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                if (pendingIntent != null && !activity.getIntent().getBooleanExtra("share_from_aio", false)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->finish--send callback using PendingIntent");
                    }
                    try {
                        pendingIntent.send();
                        activity.getIntent().removeExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                    } catch (PendingIntent.CanceledException e16) {
                        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "failed to send PendingIntent", e16);
                    }
                }
                activity.moveTaskToBack(true);
            } catch (Throwable th5) {
                QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "qbShowShareResultDialog ", th5);
            }
        }
    }

    public static void f(long j3, int i3, Activity activity, com.tencent.aio.api.runtime.a aVar) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        com.tencent.biz.common.util.k.i(qQAppInterface, "", "choose", j3, i3, "back");
        ReportCenter.f().q(qQAppInterface.getAccount(), "", String.valueOf(j3), "1000", "51", "0", false, true);
        com.tencent.biz.common.util.k.k(activity, 0, "", "");
        boolean booleanExtra = activity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true);
        if (aVar != null) {
            Bundle bundle = new Bundle();
            if (booleanExtra) {
                bundle.putBoolean(SplashActivity.SWITCH_ANIM, false);
            }
            aVar.e().h(new ExternalCommIntent("close_aio", bundle));
        }
        if (booleanExtra) {
            try {
                PendingIntent pendingIntent = (PendingIntent) activity.getIntent().getParcelableExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                if (pendingIntent != null && !activity.getIntent().getBooleanExtra("share_from_aio", false)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->finish--send callback using PendingIntent");
                    }
                    try {
                        pendingIntent.send();
                        activity.getIntent().removeExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                    } catch (PendingIntent.CanceledException e16) {
                        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "failed to send PendingIntent", e16);
                    }
                }
                activity.moveTaskToBack(true);
            } catch (Throwable th5) {
                QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "qbShowShareResultDialog ", th5);
            }
        }
    }

    public static void g(OpenSdkShareModel openSdkShareModel, Bundle bundle, oidb_cmd0xb77$ReqBody oidb_cmd0xb77_reqbody) {
        if (openSdkShareModel != null) {
            oidb_cmd0xb77$MiniAppMsgBody oidb_cmd0xb77_miniappmsgbody = new oidb_cmd0xb77$MiniAppMsgBody();
            oidb_cmd0xb77_miniappmsgbody.mini_app_appid.set(Long.parseLong(openSdkShareModel.miniAppAppid));
            oidb_cmd0xb77_miniappmsgbody.mini_app_path.set(openSdkShareModel.miniAppPath);
            oidb_cmd0xb77_miniappmsgbody.web_page_url.set(openSdkShareModel.webPageUrl);
            oidb_cmd0xb77_miniappmsgbody.title.set(openSdkShareModel.title);
            oidb_cmd0xb77_miniappmsgbody.desc.set(openSdkShareModel.desc);
            oidb_cmd0xb77_miniappmsgbody.json_str.set(openSdkShareModel.jsonStr);
            oidb_cmd0xb77_reqbody.mini_app_msg_body.set(oidb_cmd0xb77_miniappmsgbody);
            oidb_cmd0xb77_reqbody.msg_style.set(10);
            return;
        }
        if (ArkFullScreenAppActivity.T2(bundle)) {
            String string = bundle.getString("forward_ark_app_name");
            String string2 = bundle.getString("forward_ark_app_view");
            ArkAppMessage arkAppMessage = new ArkAppMessage(bundle.getString("forward_ark_app_prompt"), string, bundle.getString("forward_ark_biz_src", ""), bundle.getString(AppConstants.Key.FORWARD_ARK_APP_DESC), string2, bundle.getString("forward_ark_app_ver"), bundle.getString("forward_ark_app_meta"), bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG), bundle.getString(AppConstants.Key.FORWARD_ARK_APP_COMPAT));
            oidb_cmd0xb77$ArkJsonBody oidb_cmd0xb77_arkjsonbody = new oidb_cmd0xb77$ArkJsonBody();
            oidb_cmd0xb77_arkjsonbody.json_str.set(arkAppMessage.toAppXml());
            oidb_cmd0xb77_reqbody.ark_json_body.set(oidb_cmd0xb77_arkjsonbody);
            oidb_cmd0xb77_reqbody.msg_style.set(8);
        }
    }

    public static oidb_cmd0xb77$ReqBody h(Bundle bundle, String str, String str2, oidb_cmd0xb77$ImageInfo oidb_cmd0xb77_imageinfo) {
        return i(bundle, str, str2, oidb_cmd0xb77_imageinfo, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static oidb_cmd0xb77$ReqBody i(Bundle bundle, String str, String str2, oidb_cmd0xb77$ImageInfo oidb_cmd0xb77_imageinfo, long j3) {
        int i3;
        String j16;
        oidb_cmd0xb77$RichMsgBody oidb_cmd0xb77_richmsgbody;
        long j17;
        String string;
        String string2;
        int i16 = bundle.getInt("uintype");
        long Z = ForwardUtils.Z(bundle.getString("guild_id"));
        long j18 = bundle.getLong("req_share_id");
        int i17 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        long Z2 = ForwardUtils.Z(bundle.getString("uin"));
        String string3 = bundle.getString("title");
        String string4 = bundle.getString("desc");
        String string5 = bundle.getString("detail_url");
        String string6 = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        String string7 = bundle.getString(AppConstants.Key.SHARE_RES_PKG_NAME);
        String string8 = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        String string9 = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER);
        String string10 = bundle.getString("sdk_version", AEResManagerConfigBean.DEFAULT_VERSION);
        boolean T2 = ArkFullScreenAppActivity.T2(bundle);
        String string11 = bundle.getString(AppConstants.Key.SHARE_REQ_ARK_INFO);
        QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "buildcmd0xb77ReqBody appId=" + j18 + ", reqType = " + i17 + ", uinType = " + i16 + ", sdkVersion =" + string10);
        QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "buildcmd0xb77ReqBody picture_url =" + string6 + ", musicUrl=" + str2 + ", uin =" + Z2 + "\n, title = " + string3 + ", summary = " + string4 + ", url = " + string5 + "\n, mRemoteImgUrl = " + str + ", pkgName =" + string7 + ", commentText = " + string8 + ", commentTextExt =" + string9 + "\n, displayArkJson + " + T2 + ", arkInfo = " + string11 + ", localUniSeq =" + j3 + ", guildId =" + Z);
        oidb_cmd0xb77$ReqBody oidb_cmd0xb77_reqbody = new oidb_cmd0xb77$ReqBody();
        oidb_cmd0xb77_reqbody.appid.set(j18);
        oidb_cmd0xb77_reqbody.app_type.set(1);
        oidb_cmd0xb77_reqbody.recv_uin.set(Z2);
        if (i16 == 0) {
            oidb_cmd0xb77_reqbody.send_type.set(0);
        } else if (i16 == 1) {
            oidb_cmd0xb77_reqbody.send_type.set(1);
        } else {
            if (i16 == 3000) {
                oidb_cmd0xb77_reqbody.send_type.set(2);
            } else if (i16 == 10014) {
                oidb_cmd0xb77_reqbody.send_type.set(3);
                oidb_cmd0xb77_reqbody.recv_guild_id.set(Z);
            }
            i3 = 1;
            if (i17 != i3) {
                if (i17 == 2) {
                    oidb_cmd0xb77_reqbody.msg_style.set(4);
                } else if (i17 == 4) {
                    oidb_cmd0xb77_reqbody.msg_style.set(5);
                } else if (i17 == 5) {
                    oidb_cmd0xb77_reqbody.msg_style.set(6);
                } else {
                    oidb_cmd0xb77_reqbody.msg_style.set(0);
                }
            }
            oidb_cmd0xb77$ClientInfo oidb_cmd0xb77_clientinfo = new oidb_cmd0xb77$ClientInfo();
            if (!TextUtils.isEmpty(string7)) {
                oidb_cmd0xb77_clientinfo.android_package_name.set(string7);
            }
            oidb_cmd0xb77_clientinfo.platform.set(1);
            j16 = j(BaseApplication.getContext(), string7);
            if (!TextUtils.isEmpty(j16)) {
                oidb_cmd0xb77_clientinfo.android_signature.set(j16);
            }
            oidb_cmd0xb77_clientinfo.sdk_version.set(string10);
            oidb_cmd0xb77_reqbody.client_info.set(oidb_cmd0xb77_clientinfo);
            oidb_cmd0xb77_richmsgbody = new oidb_cmd0xb77$RichMsgBody();
            if (oidb_cmd0xb77_imageinfo != null) {
                oidb_cmd0xb77_richmsgbody.image_info.set(oidb_cmd0xb77_imageinfo);
            }
            if (!TextUtils.isEmpty(string3)) {
                oidb_cmd0xb77_richmsgbody.title.set(string3);
            }
            if (!TextUtils.isEmpty(string4)) {
                if (string4.contains(HardCodeUtil.qqStr(R.string.mqe))) {
                    string4 = string4.replace(HardCodeUtil.qqStr(R.string.mr5), "");
                }
                oidb_cmd0xb77_richmsgbody.summary.set(string4);
            }
            if (!TextUtils.isEmpty(string5)) {
                oidb_cmd0xb77_richmsgbody.url.set(string5);
            }
            if (TextUtils.isEmpty(str)) {
                j17 = j3;
                oidb_cmd0xb77_richmsgbody.picture_url.set(str);
            } else {
                j17 = j3;
                if (!TextUtils.isEmpty(string6)) {
                    oidb_cmd0xb77_richmsgbody.picture_url.set(string6);
                } else {
                    QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "richMsgBody picture_url not set");
                }
            }
            if (i17 == 2 && !TextUtils.isEmpty(str2)) {
                oidb_cmd0xb77_richmsgbody.music_url.set(str2);
            }
            oidb_cmd0xb77_reqbody.rich_msg_body.set(oidb_cmd0xb77_richmsgbody);
            oidb_cmd0xb77$ExtInfo oidb_cmd0xb77_extinfo = new oidb_cmd0xb77$ExtInfo();
            if (j17 != 0) {
                oidb_cmd0xb77_extinfo.msg_seq.set(j17);
            }
            string = bundle.getString(AppConstants.Key.SHARE_REQ_GAME_TAG_NAME);
            string2 = bundle.getString(AppConstants.Key.SHARE_REQ_GAME_MESSAGE_EXT);
            if (!TextUtils.isEmpty(string)) {
                oidb_cmd0xb77_extinfo.tag_name.set(ByteStringMicro.copyFrom(string.getBytes()));
            }
            if (!TextUtils.isEmpty(string2)) {
                oidb_cmd0xb77_extinfo.message_ext.set(ByteStringMicro.copyFrom(string2.getBytes()));
            }
            oidb_cmd0xb77_reqbody.ext_info.set(oidb_cmd0xb77_extinfo);
            return oidb_cmd0xb77_reqbody;
        }
        i3 = 1;
        if (i17 != i3) {
        }
        oidb_cmd0xb77$ClientInfo oidb_cmd0xb77_clientinfo2 = new oidb_cmd0xb77$ClientInfo();
        if (!TextUtils.isEmpty(string7)) {
        }
        oidb_cmd0xb77_clientinfo2.platform.set(1);
        j16 = j(BaseApplication.getContext(), string7);
        if (!TextUtils.isEmpty(j16)) {
        }
        oidb_cmd0xb77_clientinfo2.sdk_version.set(string10);
        oidb_cmd0xb77_reqbody.client_info.set(oidb_cmd0xb77_clientinfo2);
        oidb_cmd0xb77_richmsgbody = new oidb_cmd0xb77$RichMsgBody();
        if (oidb_cmd0xb77_imageinfo != null) {
        }
        if (!TextUtils.isEmpty(string3)) {
        }
        if (!TextUtils.isEmpty(string4)) {
        }
        if (!TextUtils.isEmpty(string5)) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        if (i17 == 2) {
            oidb_cmd0xb77_richmsgbody.music_url.set(str2);
        }
        oidb_cmd0xb77_reqbody.rich_msg_body.set(oidb_cmd0xb77_richmsgbody);
        oidb_cmd0xb77$ExtInfo oidb_cmd0xb77_extinfo2 = new oidb_cmd0xb77$ExtInfo();
        if (j17 != 0) {
        }
        string = bundle.getString(AppConstants.Key.SHARE_REQ_GAME_TAG_NAME);
        string2 = bundle.getString(AppConstants.Key.SHARE_REQ_GAME_MESSAGE_EXT);
        if (!TextUtils.isEmpty(string)) {
        }
        if (!TextUtils.isEmpty(string2)) {
        }
        oidb_cmd0xb77_reqbody.ext_info.set(oidb_cmd0xb77_extinfo2);
        return oidb_cmd0xb77_reqbody;
    }

    public static String j(Context context, String str) {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            String bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
            if (bytes2HexStr == null) {
                return "";
            }
            String lowerCase = bytes2HexStr.toLowerCase();
            messageDigest.reset();
            return lowerCase;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static long k() {
        com.tencent.mobileqq.config.business.al b16 = OpenSdkConfProcessor.b();
        if (b16 == null) {
            QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "getVerifyAppinfoTimeoutDuration null == confBean");
            return 5000L;
        }
        long a16 = b16.a();
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "getVerifyAppinfoTimeoutDuration, timeoutDuration = ", Long.valueOf(a16));
        if (a16 == 0) {
            return 5000L;
        }
        return a16;
    }

    public static boolean l() {
        boolean z16;
        com.tencent.mobileqq.config.business.al b16 = OpenSdkConfProcessor.b();
        if (b16 != null) {
            z16 = b16.b();
        } else {
            z16 = false;
        }
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "isOpenedSDKShareImageByServer, shareImageByServer = ", Boolean.valueOf(z16));
        return z16;
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return HardCodeUtil.qqStr(R.string.hih) + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb A[Catch: Exception -> 0x0113, TryCatch #0 {Exception -> 0x0113, blocks: (B:9:0x0041, B:14:0x0068, B:21:0x00b8, B:24:0x00e2, B:26:0x00fb, B:27:0x00fe), top: B:8:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(Bundle bundle, int i3, long j3, boolean z16) {
        int i16;
        String str;
        String str2;
        if (bundle != null && bundle.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
            ReportController.o((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "1", "", "", "");
        }
        if (bundle != null) {
            try {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                int i17 = bundle.getInt("uintype");
                String string = bundle.getString("uin");
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 == 3000) {
                            i16 = 3;
                        }
                    } else {
                        i16 = 2;
                    }
                    com.tencent.open.business.viareport.c.a().b(0, "SHARE_TO_QQ", qQAppInterface.getCurrentAccountUin(), String.valueOf(j3), String.valueOf(i16), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
                    String str3 = "1";
                    if (i3 != 1) {
                        str = "1";
                    } else if (i3 == 2) {
                        str = "3";
                    } else if (i3 == 5) {
                        str = "2";
                    } else {
                        str = "4";
                    }
                    if (i17 != 0) {
                        if (1 == i17) {
                            str2 = "2";
                        } else if (3000 == i17) {
                            str2 = "3";
                        }
                        ReportCenter f16 = ReportCenter.f();
                        String account = qQAppInterface.getAccount();
                        String str4 = j3 + "";
                        if (z16) {
                            str3 = "0";
                        }
                        f16.o(account, "", str4, "10", "12", str3, str, string, str2, false, true);
                        if (z16) {
                            jq3.a.m(bundle, i3, j3);
                        }
                        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:reportType=10,actType=12,result=0,type=", str, ",toType=", str2);
                    }
                    str2 = "1";
                    ReportCenter f162 = ReportCenter.f();
                    String account2 = qQAppInterface.getAccount();
                    String str42 = j3 + "";
                    if (z16) {
                    }
                    f162.o(account2, "", str42, "10", "12", str3, str, string, str2, false, true);
                    if (z16) {
                    }
                    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:reportType=10,actType=12,result=0,type=", str, ",toType=", str2);
                }
                i16 = 1;
                com.tencent.open.business.viareport.c.a().b(0, "SHARE_TO_QQ", qQAppInterface.getCurrentAccountUin(), String.valueOf(j3), String.valueOf(i16), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
                String str32 = "1";
                if (i3 != 1) {
                }
                if (i17 != 0) {
                }
                str2 = "1";
                ReportCenter f1622 = ReportCenter.f();
                String account22 = qQAppInterface.getAccount();
                String str422 = j3 + "";
                if (z16) {
                }
                f1622.o(account22, "", str422, "10", "12", str32, str, string, str2, false, true);
                if (z16) {
                }
                QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:reportType=10,actType=12,result=0,type=", str, ",toType=", str2);
            } catch (Exception e16) {
                QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:", e16);
            }
        }
    }

    public static QQCustomDialog o(Activity activity, QQCustomDialog qQCustomDialog, com.tencent.aio.api.runtime.a aVar, long j3, int i3, String str) {
        QQCustomDialog qQCustomDialog2;
        ForwardStatisticsReporter.c("KEY_STAGE_2_TOTAL");
        if (activity != null && !activity.isFinishing()) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            String string = qQAppInterface.getApplication().getString(R.string.hih);
            if (str != null) {
                string = string + str;
            }
            String str2 = string;
            String string2 = qQAppInterface.getApplication().getString(R.string.hik);
            String string3 = qQAppInterface.getApplication().getString(R.string.hii);
            b.a e16 = OpenSdkShareReporterProxy.e(j3);
            a aVar2 = new a(j3, i3, activity, e16);
            b bVar = new b(j3, i3, activity, aVar, e16);
            if (qQCustomDialog == null) {
                qQCustomDialog2 = DialogUtil.createCustomDialog(activity, 232, (String) null, string2, str2, string3, aVar2, bVar);
            } else {
                qQCustomDialog2 = qQCustomDialog;
            }
            qQCustomDialog2.setNegativeButton(str2, bVar);
            qQCustomDialog2.setPositiveButton(string3, aVar2);
            try {
                qQCustomDialog2.show();
                OpenSdkShareReporterProxy.d().h(qQCustomDialog2.getRootView(), e16);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog: failed. ", th5);
                }
            }
            return qQCustomDialog2;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, " qbShowShareResultDialog error mActivity = null or finished");
            return null;
        }
        return null;
    }

    public static void p(Activity activity, String str, long j3, int i3, String str2) {
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "sdk_share:sdk callback= appid=" + j3 + " action=" + str);
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", Long.valueOf(j3), str, Integer.valueOf(i3), str2)));
        if (activity.getIntent() != null) {
            String stringExtra = activity.getIntent().getStringExtra("pkg_name");
            if (TextUtils.isEmpty(stringExtra)) {
                try {
                    stringExtra = activity.getIntent().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getString("pkg_name");
                } catch (Exception unused) {
                    stringExtra = null;
                }
            }
            intent.setPackage(stringExtra);
        }
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, e16.getMessage());
            }
        }
    }

    public static void q(long j3, int i3, Activity activity) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        com.tencent.biz.common.util.k.i(qQAppInterface, "", "choose", j3, i3, QCircleDaTongConstant.ElementParamValue.STAY);
        ReportCenter.f().q(qQAppInterface.getAccount(), "", String.valueOf(j3), "1000", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "0", false, true);
        Intent intent = activity.getIntent();
        String str = AppConstants.Key.SHARE_SUCCESS_STAY_QQ + intent.getLongExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_APP_ID, 0L);
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_PKG_NAME);
        Intent intent2 = new Intent(str);
        Uri uri = (Uri) intent.getParcelableExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_URI_DATA);
        intent2.setPackage(stringExtra);
        intent2.putExtra("uriData", uri);
        activity.sendBroadcast(intent2);
    }
}
