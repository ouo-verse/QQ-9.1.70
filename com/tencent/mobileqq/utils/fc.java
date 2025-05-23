package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class fc {

    /* renamed from: b, reason: collision with root package name */
    public static Handler f307769b;

    /* renamed from: a, reason: collision with root package name */
    public static final String f307768a = AppConstants.SDCARD_PATH + ".VasResourceCheck/temp.json";

    /* renamed from: c, reason: collision with root package name */
    public static Handler.Callback f307770c = new b();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f307771a;

        a(QQAppInterface qQAppInterface) {
            this.f307771a = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            super.onDone(gVar);
            File file = new File(fc.f307768a);
            if (file.exists()) {
                String readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
                if (!TextUtils.isEmpty(readFileToStringEx)) {
                    try {
                        byte[] decode = Base64.decode(readFileToStringEx, 0);
                        SecretKeySpec secretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
                        IvParameterSpec ivParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
                        Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
                        cipher.init(2, secretKeySpec, ivParameterSpec);
                        JSONObject jSONObject = new JSONObject(new String(cipher.doFinal(decode)));
                        if (QLog.isColorLevel()) {
                            QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + jSONObject.toString());
                        }
                        fc.a(this.f307771a);
                        Handler handler = fc.f307769b;
                        handler.sendMessage(handler.obtainMessage(257));
                        return;
                    } catch (Exception e16) {
                        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + e16.getMessage());
                        Handler handler2 = fc.f307769b;
                        handler2.sendMessage(handler2.obtainMessage(259));
                        return;
                    }
                }
                return;
            }
            Handler handler3 = fc.f307769b;
            handler3.sendMessage(handler3.obtainMessage(258));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (BaseApplicationImpl.getApplication().waitAppRuntime(null) instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().waitAppRuntime(null);
                switch (message.what) {
                    case 257:
                        QQToast.makeText(qQAppInterface.getApplication(), HardCodeUtil.qqStr(R.string.uy7), 0).show();
                        return true;
                    case 258:
                        QQToast.makeText(qQAppInterface.getApplication(), HardCodeUtil.qqStr(R.string.uy5), 0).show();
                        return true;
                    case 259:
                        QQToast.makeText(qQAppInterface.getApplication(), HardCodeUtil.qqStr(R.string.uy6), 0).show();
                        return true;
                    case 260:
                        QQToast.makeText(qQAppInterface.getApplication(), HardCodeUtil.qqStr(R.string.uy8), 0).show();
                        return true;
                    default:
                        return true;
                }
            }
            return true;
        }
    }

    public static void a(QQAppInterface qQAppInterface) {
        BubbleManager bubbleManager = (BubbleManager) qQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
        if (bubbleManager != null) {
            FileUtils.delete(bubbleManager.y().getAbsolutePath(), false);
            bubbleManager.y();
        }
        IFontManagerService iFontManagerService = (IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "");
        if (iFontManagerService != null) {
            FileUtils.delete(iFontManagerService.getFontBaseDir().getAbsolutePath(), false);
            iFontManagerService.getFontBaseDir();
        }
        com.tencent.mobileqq.vas.b bVar = (com.tencent.mobileqq.vas.b) qQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        if (bVar != null) {
            FileUtils.delete(bVar.getPendentBaseDir().getAbsolutePath(), false);
            bVar.getPendentBaseDir();
            FileUtils.delete(bVar.getAvatarPendantBaseResouceDir().getAbsolutePath(), false);
            bVar.getAvatarPendantBaseResouceDir();
        }
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".emotionsm"));
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtils.delete(file.getAbsolutePath(), false);
        file.mkdirs();
        File file2 = new File(VasConstant.SIGNATURE_TEMPLATE_DIR);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        FileUtils.delete(file2.getAbsolutePath(), false);
        file2.mkdirs();
        File file3 = new File(AppConstants.PATH_SYSTEM_BACKGROUND + "resource");
        if (!file3.exists()) {
            file3.mkdirs();
        }
        FileUtils.delete(file3.getAbsolutePath(), false);
        file3.mkdirs();
        File file4 = new File(com.tencent.mobileqq.vas.g.f309256a);
        if (!file4.exists()) {
            file4.mkdirs();
        }
        FileUtils.delete(file4.getAbsolutePath(), false);
        file4.mkdirs();
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("https://gxh.vip.qq.com") && str.endsWith("secret.json")) {
            return true;
        }
        return false;
    }

    public static void c(QQAppInterface qQAppInterface, Activity activity, String str) {
        QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.uy9), 0).show();
        activity.finish();
        if (f307769b == null) {
            f307769b = new Handler(f307770c);
        }
        ((DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(new com.tencent.mobileqq.vip.g(str, new File(f307768a)), new a(qQAppInterface), null);
    }
}
