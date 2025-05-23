package com.tencent.mobileqq.activity.aio.vasbubble;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.vasbubble.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BubbleTextColorManage {

    /* renamed from: c, reason: collision with root package name */
    private static final BubbleTextColorManage f180132c = new BubbleTextColorManage();

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, Integer> f180133d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private a.C7139a f180134a = a.a().b();

    /* renamed from: b, reason: collision with root package name */
    private Handler f180135b;

    BubbleTextColorManage() {
        c();
    }

    private void c() {
        VasMMKVProxy bubbleTextColorInfo = VasMMKV.getBubbleTextColorInfo();
        String decodeString = bubbleTextColorInfo.decodeString("textColorManagerMD5", "");
        String md5 = MD5.toMD5(this.f180134a.toString());
        if (!decodeString.equals(md5)) {
            bubbleTextColorInfo.removeKeyList(bubbleTextColorInfo.allKey());
            bubbleTextColorInfo.encodeString("textColorManagerMD5", md5);
        }
    }

    public static BubbleTextColorManage d() {
        return f180132c;
    }

    private boolean e(int i3, int i16) {
        if ((Math.pow(Color.red(i3) - Color.red(i16), 2.0d) * 2.0d) + (Math.pow(Color.green(i3) - Color.green(i16), 2.0d) * 4.0d) + (Math.pow(Color.blue(i3) - Color.blue(i16), 2.0d) * 3.0d) < this.f180134a.f180140b) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        int[] iArr;
        int i3;
        int i16;
        int i17;
        QLog.d("BubbleTextColorManage", 1, "saveChatBgMainPixel : bgPath " + str);
        if (TextUtils.isEmpty(str) || "null".equals(str) || VasMMKV.getBubbleTextColorInfo().decodeInt(str, -1) != -1) {
            return;
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(str, null);
        } catch (Exception unused) {
            QLog.e("BubbleTextColorManage", 2, "saveChatBgMainPixel path: " + str);
        } catch (OutOfMemoryError unused2) {
            QLog.e("BubbleTextColorManage", 2, "saveChatBgMainPixel oom: " + str);
        }
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i18 = this.f180134a.f180139a;
        if (width != 0 && i18 != 0) {
            try {
                if (width > i18) {
                    int i19 = width / i18;
                    int i26 = height / i19;
                    iArr = new int[i18 * i26];
                    for (int i27 = 0; i27 < i18; i27++) {
                        for (int i28 = 0; i28 < i26; i28++) {
                            iArr[(i27 * i26) + i28] = Integer.valueOf(bitmap.getPixel(i27 * i19, i28 * i19)).intValue();
                        }
                    }
                } else {
                    int[] iArr2 = new int[width * height];
                    bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
                    iArr = iArr2;
                }
                bitmap.recycle();
                if (iArr.length == 0) {
                    VasMMKV.getBubbleTextColorInfo().encodeInt(str, 0);
                    return;
                }
                Arrays.sort(iArr);
                int length = iArr.length / 2;
                int i29 = iArr[length];
                int i36 = length;
                for (int i37 = length + 1; i37 < iArr.length && ((i17 = iArr[i37]) == iArr[i36] || e(i29, i17)); i37++) {
                    i36 = i37;
                }
                while (true) {
                    i3 = length;
                    length--;
                    if (length < 0 || ((i16 = iArr[length]) != iArr[i3] && !e(i29, i16))) {
                        break;
                    }
                }
                float length2 = ((i36 - i3) + 1) / iArr.length;
                QLog.d("BubbleTextColorManage", 1, "saveChatBgMainPixel : midPixel " + i29 + " ColorPercent : " + length2);
                if (length2 >= this.f180134a.f180142d) {
                    VasMMKV.getBubbleTextColorInfo().encodeInt(str, i29);
                    bitmap.recycle();
                } else {
                    VasMMKV.getBubbleTextColorInfo().encodeInt(str, 0);
                }
            } catch (Exception e16) {
                QLog.e("BubbleTextColorManage", 1, "saveChatBgMainPixel : getPixel " + e16);
            }
        }
    }

    public void f(final String str, final String str2) {
        if (this.f180135b == null) {
            this.f180135b = new Handler(ThreadManagerV2.getFileThreadLooper());
        }
        this.f180135b.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.vasbubble.BubbleTextColorManage.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.a().c() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || VasMMKV.getBubbleTextColorInfo().decodeInt(str2, -1) != -1) {
                    return;
                }
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeFile(str, null);
                } catch (Exception unused) {
                    QLog.e("BubbleTextColorManage", 2, "saveBubbleIsTransparent path: " + str);
                } catch (OutOfMemoryError unused2) {
                    QLog.e("BubbleTextColorManage", 2, "saveBubbleIsTransparent oom: " + str);
                }
                if (bitmap == null) {
                    return;
                }
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (width >= 2 && height >= 2) {
                        int alpha = Color.alpha(bitmap.getPixel(width / 2, height / 2));
                        bitmap.recycle();
                        if (alpha < BubbleTextColorManage.this.f180134a.f180141c) {
                            QLog.d("BubbleTextColorManage", 1, "saveBubbleIsTransparent : isTransparent 1");
                            VasMMKV.getBubbleTextColorInfo().encodeInt(str2, 1);
                        } else {
                            QLog.d("BubbleTextColorManage", 1, "saveBubbleIsTransparent : isTransparent 0");
                            VasMMKV.getBubbleTextColorInfo().encodeInt(str2, 0);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("BubbleTextColorManage", 1, "saveBubbleIsTransparent : getPixel " + e16);
                }
            }
        });
    }

    public void h() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.vasbubble.BubbleTextColorManage.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.a().c()) {
                    return;
                }
                String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
                if (!TextUtils.isEmpty(skinRootPath) && !"null".equals(skinRootPath)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(skinRootPath);
                    String str = File.separator;
                    sb5.append(str);
                    sb5.append("drawable-xxhdpi");
                    sb5.append(str);
                    sb5.append("skin_chat_background.png");
                    String sb6 = sb5.toString();
                    QLog.d("BubbleTextColorManage", 1, "saveNativeChatBgMainPixel : currentThemeChatBgPath" + sb6);
                    BubbleTextColorManage.this.g(sb6);
                }
                SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(VasUtil.getApp().getApplicationContext(), VasUtil.getApp().getCurrentAccountUin());
                Map<String, ?> all = mMKVData.getAll();
                if (all != null) {
                    for (String str2 : all.keySet()) {
                        if (Pattern.compile("[0-9]*").matcher(str2).matches()) {
                            BubbleTextColorManage.this.g(mMKVData.getString(str2, "null"));
                        }
                    }
                }
            }
        }, 16, null, true);
    }
}
