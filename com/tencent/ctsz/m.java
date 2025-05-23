package com.tencent.ctsz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.ims.signature$SignatureReport;
import com.tencent.ims.signature$SignatureResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.mqpsdk.a;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class m implements a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f100533j;

    /* renamed from: a, reason: collision with root package name */
    final String f100534a;

    /* renamed from: b, reason: collision with root package name */
    final String f100535b;

    /* renamed from: c, reason: collision with root package name */
    final String f100536c;

    /* renamed from: d, reason: collision with root package name */
    final String f100537d;

    /* renamed from: e, reason: collision with root package name */
    final String f100538e;

    /* renamed from: f, reason: collision with root package name */
    final String f100539f;

    /* renamed from: g, reason: collision with root package name */
    final String f100540g;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f100541h;

    /* renamed from: i, reason: collision with root package name */
    private MSFNetTransportProvider f100542i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f100533j = false;
        }
    }

    public m(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f100534a = d(new byte[]{126, 92, 81, 90, 95, 86, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP});
        this.f100535b = d(new byte[]{Constants.VIRTUAL_GAMEPAD_SDK_DATA, 86, 80, 97, 86, MaskType.MASK_TYPE_EXTERNAL, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 93, 71, 65, 74});
        this.f100536c = d(new byte[]{Constants.VIRTUAL_GAMEPAD_SDK_DATA, 86, 80, Constants.VIRTUAL_GAMEPAD_SDK_DATA, 71, 82, 94, 67, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 93, 71, 65, 74});
        this.f100537d = d(new byte[]{Constants.VIRTUAL_GAMEPAD_SDK_DATA, 86, 80, 126, 87, 6, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 93, 71, 65, 74});
        this.f100538e = d(new byte[]{Constants.VIRTUAL_GAMEPAD_SDK_DATA, 86, 80, Constants.VIRTUAL_GAMEPAD_SDK_DATA, 90, 84});
        this.f100539f = d(new byte[]{Constants.VIRTUAL_GAMEPAD_SDK_DATA, 86, 80, PublicAccountH5AbilityPluginImpl.OPENCAMERA, 82, 80, Constants.SEND_CHANNEL_LATENCY, 86, 103, 90, 94, 86});
        String d16 = d(new byte[]{MaskType.MASK_TYPE_EXTERNAL, 90, 84, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 80, Constants.SEND_CHANNEL_LATENCY, 86, 80, 88});
        this.f100540g = d16;
        this.f100542i = null;
        this.f100541h = qQAppInterface;
        MSFNetTransportProvider mSFNetTransportProvider = (MSFNetTransportProvider) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER);
        this.f100542i = mSFNetTransportProvider;
        mSFNetTransportProvider.setNetTransportEventListener(d16, this);
    }

    private boolean c(Context context) {
        try {
            Enumeration<JarEntry> entries = new JarFile(new File(context.getApplicationContext().getApplicationInfo().sourceDir)).entries();
            HashSet hashSet = new HashSet();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (hashSet.contains(name)) {
                    return true;
                }
                hashSet.add(name);
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return false;
        }
    }

    private static String d(byte[] bArr) {
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ 51);
        }
        return new String(bArr);
    }

    private String e(Context context) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(context.getApplicationContext().getApplicationInfo().sourceDir, 1);
        if (packageArchiveInfo == null) {
            return "";
        }
        return packageArchiveInfo.versionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        BaseApplication context;
        if (this.f100541h == null || (context = BaseApplication.getContext()) == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f100538e, 0).edit();
        edit.remove(this.f100535b);
        edit.remove(this.f100536c);
        String c16 = com.tencent.usq.a.c(this.f100541h.getApplication().getApplicationInfo().sourceDir);
        if (c16 != null && c16.length() != 0) {
            edit.putString(this.f100537d, c16);
            edit.commit();
            boolean c17 = c(context);
            String d16 = com.tencent.usq.a.d(context);
            String e16 = e(context);
            if (QLog.isColorLevel()) {
                QLog.d("sct", 2, c16);
            }
            String packageName = this.f100541h.getApplication().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = this.f100534a;
            }
            signature$SignatureReport signature_signaturereport = new signature$SignatureReport();
            signature_signaturereport.u64_uin.set(Long.parseLong(this.f100541h.getCurrentAccountUin()));
            signature_signaturereport.u32_client_type.set(0);
            signature_signaturereport.u32_is_repack.set(c17 ? 1 : 0);
            signature_signaturereport.str_packname.set(packageName);
            signature_signaturereport.str_version.set(e16);
            signature_signaturereport.str_md5.set(c16);
            signature_signaturereport.str_signature.set(d16);
            Object byteArray = signature_signaturereport.toByteArray();
            a.InterfaceC9207a codec = this.f100542i.getCodec(this.f100540g);
            if (codec != null) {
                byteArray = codec.encode(byteArray);
            }
            this.f100542i.send(byteArray);
        }
    }

    private void g(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String d16 = d(new byte[]{87, 95, 84, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 70, 65, 95});
            String d17 = d(new byte[]{87, 95, 84, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 65, 81, 70, 71, 71, 92, 93});
            String d18 = d(new byte[]{87, 95, 84, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 95, 81, 70, 71, 71, 92, 93});
            String d19 = d(new byte[]{87, 95, 84, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 80, 92, 93, 71, 86, 93, 71});
            String d26 = d(new byte[]{87, 95, 84, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 71, 90, 71, 95, 86});
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            Intent intent = new Intent();
            intent.putExtra("type", 9);
            Bundle bundle = new Bundle();
            bundle.putString(d26, str);
            bundle.putString(d19, str2);
            bundle.putString(d18, str3);
            bundle.putString(d17, str4);
            bundle.putString(d16, str5);
            intent.putExtras(bundle);
            intent.setFlags(872415232);
            RouteUtils.startActivity(baseActivity, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
        }
    }

    private void i(int i3, int i16) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(this.f100538e, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i17 = sharedPreferences.getInt(this.f100535b, -1);
        if (i17 == -1 || (i17 ^ 18) != i3) {
            edit.putInt(this.f100535b, i3 ^ 18);
            edit.putLong(this.f100536c, System.currentTimeMillis() ^ 18);
            edit.putInt(this.f100539f, i16);
            edit.commit();
        }
    }

    @Override // com.tencent.mqpsdk.a.b
    public void a(Object obj, Object obj2) {
        a.InterfaceC9207a codec;
        byte[] bArr;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj, obj2);
            return;
        }
        MSFNetTransportProvider mSFNetTransportProvider = this.f100542i;
        if (mSFNetTransportProvider == null || (codec = mSFNetTransportProvider.getCodec("sig_check")) == null || (bArr = (byte[]) codec.decode(obj2)) == null) {
            return;
        }
        signature$SignatureResult signature_signatureresult = new signature$SignatureResult();
        try {
            signature_signatureresult.mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (signature_signatureresult.u32_check_result.has()) {
            i3 = signature_signatureresult.u32_check_result.get();
        } else {
            i3 = -1;
        }
        String str5 = "";
        if (!signature_signatureresult.str_title.has()) {
            str = "";
        } else {
            str = signature_signatureresult.str_title.get();
        }
        if (!signature_signatureresult.str_content.has()) {
            str2 = "";
        } else {
            str2 = signature_signatureresult.str_content.get();
        }
        if (!signature_signatureresult.str_left_button.has()) {
            str3 = "";
        } else {
            str3 = signature_signatureresult.str_left_button.get();
        }
        if (!signature_signatureresult.str_right_button.has()) {
            str4 = "";
        } else {
            str4 = signature_signatureresult.str_right_button.get();
        }
        if (signature_signatureresult.str_url.has()) {
            str5 = signature_signatureresult.str_url.get();
        }
        String str6 = str5;
        if (signature_signatureresult.u32_cache_time.has()) {
            i16 = signature_signatureresult.u32_cache_time.get();
        } else {
            i16 = QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME;
        }
        int i17 = 1;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
            } else {
                g(str, str2, str3, str4, str6);
            }
        }
        if (i3 != 0) {
            i17 = 0;
        }
        i(i17, i16);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (f100533j) {
                return;
            }
            f100533j = true;
            new BaseThread() { // from class: com.tencent.ctsz.m.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) m.this);
                    }
                }

                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        m.this.f();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }.start();
            f100533j = false;
        }
    }
}
