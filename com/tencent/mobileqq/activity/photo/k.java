package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.vivo.push.PushClientConstants;
import java.security.MessageDigest;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f184466d;

        a(Activity activity) {
            this.f184466d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                this.f184466d.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements com.tencent.mobileqq.Doraemon.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f184467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f184468b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f184469c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f184470d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f184471e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f184472f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Intent f184473g;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a extends ProtoUtils.TroopProtocolObserver {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f184474d;

            a(long j3) {
                this.f184474d = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SdkDynamicAvatarSettingHelper", 2, "checkOpenidDiff, onResult, errorCode=", Integer.valueOf(i3));
                }
                if (!b.this.f184469c.isFinishing() && System.currentTimeMillis() - this.f184474d <= 5000 && i3 == 16) {
                    k.f(b.this.f184469c);
                }
            }
        }

        b(QQAppInterface qQAppInterface, String str, Activity activity, String str2, String str3, String str4, Intent intent) {
            this.f184467a = qQAppInterface;
            this.f184468b = str;
            this.f184469c = activity;
            this.f184470d = str2;
            this.f184471e = str3;
            this.f184472f = str4;
            this.f184473g = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, activity, str2, str3, str4, intent);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onComplete");
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            } else if (QLog.isColorLevel()) {
                QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onFailure, code=", Integer.valueOf(i3), ", msg=", str);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onPermission, code=", Integer.valueOf(i3));
            }
            ReportController.o(this.f184467a, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.f184468b, "2", "", "");
            k.g(this.f184469c, HardCodeUtil.qqStr(R.string.t5t), this.f184470d, this.f184471e, this.f184468b);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onSuccess");
            }
            if (k.e(this.f184472f)) {
                String stringExtra = this.f184473g.getStringExtra("open_id");
                if (!TextUtils.isEmpty(this.f184468b) && !TextUtils.isEmpty(stringExtra)) {
                    OpenID b36 = this.f184467a.getMsgHandler().b3(this.f184468b);
                    if (b36 == null) {
                        try {
                            this.f184467a.getMsgHandler().O2(Long.parseLong(this.f184467a.getCurrentAccountUin()), stringExtra, Long.valueOf(this.f184468b).longValue(), new a(System.currentTimeMillis()));
                            return;
                        } catch (Exception e16) {
                            QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenidDiff exception=", e16);
                            return;
                        }
                    }
                    if (!stringExtra.equals(b36.openID)) {
                        k.f(this.f184469c);
                        return;
                    }
                    return;
                }
                QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenid, openId null");
                return;
            }
            ReportController.o(this.f184467a, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.f184468b, "3", "", "");
            k.g(this.f184469c, HardCodeUtil.qqStr(R.string.t5x), this.f184470d, this.f184471e, this.f184468b);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
            } else if (QLog.isColorLevel()) {
                QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onTrigger");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f184476d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f184477e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f184478f;

        c(Activity activity, String str, String str2) {
            this.f184476d = activity;
            this.f184477e = str;
            this.f184478f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                k.h(this.f184476d, false, this.f184477e, this.f184478f, false);
                this.f184476d.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f184479d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f184480e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f184481f;

        d(Activity activity, String str, String str2) {
            this.f184479d = activity;
            this.f184480e = str;
            this.f184481f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                k.h(this.f184479d, false, this.f184480e, this.f184481f, false);
                this.f184479d.finish();
            }
        }
    }

    public static void d(Activity activity, String str) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        String bytes2HexStr;
        if (activity != null && !TextUtils.isEmpty(str)) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            Intent intent = activity.getIntent();
            String stringExtra = intent.getStringExtra(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
            String str2 = qQAppInterface.getApplication().getString(R.string.hih) + intent.getStringExtra("app_name");
            String stringExtra2 = intent.getStringExtra("sdk_version");
            String stringExtra3 = intent.getStringExtra("pkg_name");
            try {
                if (!TextUtils.isEmpty(stringExtra3)) {
                    try {
                        packageInfo = InstalledAppListMonitor.getPackageInfo(activity.getPackageManager(), stringExtra3, 64);
                    } catch (Exception e16) {
                        QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, get signature exception=", e16);
                    }
                    if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                        messageDigest.update(signatureArr[0].toByteArray());
                        bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
                        if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(bytes2HexStr)) {
                            ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
                            Bundle bundle = new Bundle();
                            bundle.putString("sdkVersion", stringExtra2);
                            bundle.putString(PushClientConstants.TAG_PKG_NAME, stringExtra3);
                            bundle.putString("signature", bytes2HexStr);
                            ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(activity, 1, stringExtra, bundle).d("sdk_dynamic_avatar_edit", null, new b(qQAppInterface, stringExtra, activity, str2, stringExtra3, str, intent));
                            return;
                        }
                        QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, invalid param, shareAppId=", stringExtra, ", pkgName=", stringExtra3, ", signature=", bytes2HexStr);
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, stringExtra, "1", "", "");
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
                        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.t5u));
                        createCustomDialog.setNegativeButton(R.string.cancel, new a(activity));
                        createCustomDialog.setCancelable(false);
                        createCustomDialog.show();
                        return;
                    }
                } else {
                    QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, pkgName null");
                }
                QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(activity, 230);
                createCustomDialog2.setMessage(HardCodeUtil.qqStr(R.string.t5u));
                createCustomDialog2.setNegativeButton(R.string.cancel, new a(activity));
                createCustomDialog2.setCancelable(false);
                createCustomDialog2.show();
                return;
            } catch (Exception e17) {
                QLog.e("SdkDynamicAvatarSettingHelper", 1, "show invalid param dialog, exception=", e17);
                return;
            }
            bytes2HexStr = null;
            if (TextUtils.isEmpty(stringExtra)) {
            }
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, invalid param, shareAppId=", stringExtra, ", pkgName=", stringExtra3, ", signature=", bytes2HexStr);
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, stringExtra, "1", "", "");
        } else {
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, param null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(String str) {
        int i3;
        int i16;
        int i17;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
        mediaMetadataRetriever.release();
        if (QLog.isColorLevel()) {
            QLog.d("SdkDynamicAvatarSettingHelper", 1, "[isVideoValid] width=", extractMetadata2, ", height=", extractMetadata3, ", duration=", extractMetadata);
        }
        long j3 = 0;
        try {
            if (!TextUtils.isEmpty(extractMetadata)) {
                j3 = Long.parseLong(extractMetadata);
            }
            if (!TextUtils.isEmpty(extractMetadata2)) {
                i16 = Integer.parseInt(extractMetadata2);
            } else {
                i16 = 0;
            }
            try {
            } catch (Exception e16) {
                i3 = i16;
                e = e16;
                QLog.e("SdkDynamicAvatarSettingHelper", 1, "[isVideoValid] parse exception=", e);
                i16 = i3;
                i17 = 0;
                if (j3 <= 500) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        if (!TextUtils.isEmpty(extractMetadata3)) {
            i17 = Integer.parseInt(extractMetadata3);
            if (j3 <= 500 || j3 > 8000 || i16 != i17 || i16 != 480) {
                return false;
            }
            return true;
        }
        i17 = 0;
        return j3 <= 500 ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            Intent intent = activity.getIntent();
            String stringExtra = intent.getStringExtra("pkg_name");
            String stringExtra2 = intent.getStringExtra(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
            createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.t5w));
            createCustomDialog.setTitle(R.string.b1v);
            d dVar = new d(activity, stringExtra, stringExtra2);
            createCustomDialog.setNegativeButton(R.string.cancel, dVar);
            createCustomDialog.setPositiveButton(R.string.hin, dVar);
            createCustomDialog.setCancelable(false);
            createCustomDialog.show();
        } catch (Exception e16) {
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "showDifferentAccountConfirm exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Activity activity, String str, String str2, String str3, String str4) {
        if (activity != null && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                com.tencent.biz.widgets.e eVar = new com.tencent.biz.widgets.e(activity);
                ((TextView) eVar.findViewById(R.id.f166983jo1)).setText(str);
                View findViewById = eVar.findViewById(R.id.dialogRightBtn);
                View findViewById2 = eVar.findViewById(R.id.agt);
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
                eVar.findViewById(R.id.f166984jo2).setVisibility(8);
                eVar.O(str2, new c(activity, str3, str4));
                eVar.setCancelable(false);
                eVar.show();
            } catch (Exception e16) {
                QLog.e("SdkDynamicAvatarSettingHelper", 1, "[showErrorDialog] exception=", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Activity activity, boolean z16, String str, String str2, boolean z17) {
        if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                if (z17) {
                    intent.putExtra("stay_back_stack", true);
                }
                long parseLong = Long.parseLong(str2);
                if (z16) {
                    intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(parseLong), "sdkSetDynamicAvatar")));
                } else {
                    intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", Long.valueOf(parseLong), "sdkSetDynamicAvatar")));
                }
                intent.setPackage(str);
                activity.startActivity(intent);
                return;
            } catch (Exception e16) {
                QLog.e("SdkDynamicAvatarSettingHelper", 1, "[startSdkCallback] startActivity failed, exception=", e16);
                return;
            }
        }
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "[startSdkCallback] param null");
    }
}
