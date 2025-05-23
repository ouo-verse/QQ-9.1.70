package com.tencent.mobileqq.vas.bubble.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager;
import com.tencent.mobileqq.vas.bubble.impl.BubbleTextColorManagerImpl;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.theme.SkinEngine;
import i03.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010\"R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/impl/BubbleTextColorManagerImpl;", "Lcom/tencent/mobileqq/vas/bubble/IBubbleTextColorManager;", "", "key", "", "getChatBgMainPixel", "chatBgColor", "textColor", "calculateTextColor", "", "hsl", "convHSLToColor", "amount", HippyImageInfo.QUALITY_LOW, "high", "constrain", "bubbleId", "", "isTransparentBitmap", "", "checkMd5AndClearMMkv", "bgPath", "saveChatBgMainPixel", "color", "color1", "isCloseColor", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "calculateTransparentBubbleTextColor", "chatBgPath", "saveNativeAllChatBgMainPixel", "bubbleBgPath", "saveBubbleIsTransparent", "TAG", "Ljava/lang/String;", "TRANSPARENT_BUBBLE_CODE", "I", "NO_TRANSPARENT_BUBBLE_CODE", "NIGHT_CHAT_BG", "LIGHT_CHAT_BG", "KEY_TEXT_COLOR_MANAGER_MD5", "Ljava/util/HashMap;", "CACHE", "Ljava/util/HashMap;", "Li03/a$a;", "managerConfig", "Li03/a$a;", "isEnable", "Z", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "lastAioMsgItem", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BubbleTextColorManagerImpl implements IBubbleTextColorManager {
    private final int NO_TRANSPARENT_BUBBLE_CODE;
    private final boolean isEnable;

    @Nullable
    private WeakReference<AIOMsgItem> lastAioMsgItem;

    @Nullable
    private Handler mHandler;

    @NotNull
    private final a.C10499a managerConfig;

    @NotNull
    private final String TAG = "BubbleTextColorManagerImpl";
    private final int TRANSPARENT_BUBBLE_CODE = 1;

    @NotNull
    private final String NIGHT_CHAT_BG = "night";

    @NotNull
    private final String LIGHT_CHAT_BG = MiniAppConst.MENU_STYLE_LIGHT;

    @NotNull
    private final String KEY_TEXT_COLOR_MANAGER_MD5 = "textColorManagerMD5";

    @NotNull
    private final HashMap<String, Integer> CACHE = new HashMap<>();

    public BubbleTextColorManagerImpl() {
        a.C10499a b16 = a.a().b();
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance().managerConfig");
        this.managerConfig = b16;
        this.isEnable = a.a().c();
        checkMd5AndClearMMkv();
    }

    private final int calculateTextColor(int chatBgColor, int textColor) {
        if (isCloseColor(chatBgColor, textColor)) {
            float[] fArr = new float[3];
            ColorUtils.colorToHSL(chatBgColor, fArr);
            float[] fArr2 = new float[3];
            ColorUtils.colorToHSL(textColor, fArr2);
            if (fArr[2] < 0.5f) {
                fArr2[2] = this.managerConfig.f406994e;
            } else {
                fArr2[2] = this.managerConfig.f406995f;
            }
            return convHSLToColor(fArr2);
        }
        return IBubbleTextColorManager.INSTANCE.a();
    }

    private final void checkMd5AndClearMMkv() {
        VasMMKVProxy bubbleTextColorInfo = VipNtMMKV.INSTANCE.getBubbleTextColorInfo();
        String decodeString = bubbleTextColorInfo.decodeString(this.KEY_TEXT_COLOR_MANAGER_MD5, "");
        String md5 = MD5.toMD5(this.managerConfig.toString());
        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(managerConfig.toString())");
        if (!Intrinsics.areEqual(decodeString, md5)) {
            bubbleTextColorInfo.removeKeyList(bubbleTextColorInfo.allKey());
            bubbleTextColorInfo.encodeString(this.KEY_TEXT_COLOR_MANAGER_MD5, md5);
        }
    }

    private final int constrain(int amount, int low, int high) {
        if (amount < low) {
            return low;
        }
        if (amount > high) {
            return high;
        }
        return amount;
    }

    private final int convHSLToColor(float[] hsl) {
        int round;
        int round2;
        int round3;
        int round4;
        float f16 = hsl[0];
        float f17 = hsl[1];
        float f18 = hsl[2];
        float abs = (1.0f - Math.abs((2 * f18) - 1.0f)) * f17;
        float f19 = f18 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f16 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f16) / 60) {
            case 0:
                float f26 = 255;
                round = Math.round((abs + f19) * f26);
                round2 = Math.round((abs2 + f19) * f26);
                round3 = Math.round(f26 * f19);
                break;
            case 1:
                float f27 = 255;
                round4 = Math.round((abs2 + f19) * f27);
                round2 = Math.round((abs + f19) * f27);
                round3 = Math.round(f27 * f19);
                round = round4;
                break;
            case 2:
                float f28 = 255;
                int round5 = Math.round(f28 * f19);
                int round6 = Math.round((abs + f19) * f28);
                round3 = Math.round(f28 * (abs2 + f19));
                round2 = round6;
                round = round5;
                break;
            case 3:
                float f29 = 255;
                int round7 = Math.round(f29 * f19);
                int round8 = Math.round((abs2 + f19) * f29);
                round3 = Math.round(f29 * (abs + f19));
                round = round7;
                round2 = round8;
                break;
            case 4:
                float f36 = 255;
                round4 = Math.round((abs2 + f19) * f36);
                round2 = Math.round(f36 * f19);
                round3 = Math.round(f36 * (abs + f19));
                round = round4;
                break;
            case 5:
            case 6:
                float f37 = 255;
                round = Math.round((abs + f19) * f37);
                round2 = Math.round(f37 * f19);
                round3 = Math.round(f37 * (abs2 + f19));
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    private final int getChatBgMainPixel(String key) {
        if (Intrinsics.areEqual(this.NIGHT_CHAT_BG, key)) {
            return -16777216;
        }
        if (Intrinsics.areEqual(this.LIGHT_CHAT_BG, key)) {
            return -1;
        }
        return VipNtMMKV.INSTANCE.getBubbleTextColorInfo().decodeInt(key, IBubbleTextColorManager.INSTANCE.a());
    }

    private final boolean isCloseColor(int color, int color1) {
        if ((2 * Math.pow(Color.red(color) - Color.red(color1), 2.0d)) + (4 * Math.pow(Color.green(color) - Color.green(color1), 2.0d)) + (3 * Math.pow(Color.blue(color) - Color.blue(color1), 2.0d)) < this.managerConfig.f406991b) {
            return true;
        }
        return false;
    }

    private final boolean isTransparentBitmap(String bubbleId) {
        if (VipNtMMKV.INSTANCE.getBubbleTextColorInfo().decodeInt(bubbleId, IBubbleTextColorManager.INSTANCE.a()) == this.TRANSPARENT_BUBBLE_CODE) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveBubbleIsTransparent$lambda$2(String bubbleBgPath, String bubbleId, BubbleTextColorManagerImpl this$0) {
        Intrinsics.checkNotNullParameter(bubbleBgPath, "$bubbleBgPath");
        Intrinsics.checkNotNullParameter(bubbleId, "$bubbleId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TextUtils.isEmpty(bubbleBgPath) && !TextUtils.isEmpty(bubbleId)) {
            VasMMKVProxy bubbleTextColorInfo = VipNtMMKV.INSTANCE.getBubbleTextColorInfo();
            IBubbleTextColorManager.Companion companion = IBubbleTextColorManager.INSTANCE;
            if (bubbleTextColorInfo.decodeInt(bubbleId, companion.a()) != companion.a()) {
                return;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeFile(bubbleBgPath, null);
            } catch (Exception unused) {
                QLog.e(this$0.TAG, 2, "saveBubbleIsTransparent path: " + bubbleBgPath);
            } catch (OutOfMemoryError unused2) {
                QLog.e(this$0.TAG, 2, "saveBubbleIsTransparent oom: " + bubbleBgPath);
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
                    if (alpha < this$0.managerConfig.f406992c) {
                        QLog.d(this$0.TAG, 1, "saveBubbleIsTransparent : bubbleId:" + bubbleId + " isTransparent " + this$0.TRANSPARENT_BUBBLE_CODE);
                        VipNtMMKV.INSTANCE.getBubbleTextColorInfo().encodeInt(bubbleId, this$0.TRANSPARENT_BUBBLE_CODE);
                        return;
                    }
                    QLog.d(this$0.TAG, 1, "saveBubbleIsTransparent : bubbleId:" + bubbleId + " isTransparent " + this$0.NO_TRANSPARENT_BUBBLE_CODE);
                    VipNtMMKV.INSTANCE.getBubbleTextColorInfo().encodeInt(bubbleId, this$0.NO_TRANSPARENT_BUBBLE_CODE);
                }
            } catch (Exception e16) {
                QLog.e(this$0.TAG, 1, "saveBubbleIsTransparent : getPixel " + e16);
            }
        }
    }

    private final void saveChatBgMainPixel(String bgPath) {
        int[] iArr;
        boolean z16;
        int i3;
        int i16;
        if (!TextUtils.isEmpty(bgPath) && !Intrinsics.areEqual("null", bgPath)) {
            VasMMKVProxy bubbleTextColorInfo = VipNtMMKV.INSTANCE.getBubbleTextColorInfo();
            IBubbleTextColorManager.Companion companion = IBubbleTextColorManager.INSTANCE;
            if (bubbleTextColorInfo.decodeInt(bgPath, companion.a()) != companion.a()) {
                return;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeFile(bgPath, null);
            } catch (Exception unused) {
                QLog.e(this.TAG, 2, "saveChatBgMainPixel path: " + bgPath);
            } catch (OutOfMemoryError unused2) {
                QLog.e(this.TAG, 2, "saveChatBgMainPixel oom: " + bgPath);
            }
            if (bitmap == null) {
                if (QQTheme.isNowThemeIsNight()) {
                    VipNtMMKV.INSTANCE.getBubbleTextColorInfo().encodeInt(bgPath, -16777216);
                    return;
                } else {
                    VipNtMMKV.INSTANCE.getBubbleTextColorInfo().encodeInt(bgPath, -1);
                    return;
                }
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i17 = this.managerConfig.f406990a;
            if (width != 0 && i17 != 0) {
                try {
                    if (width > i17) {
                        int i18 = width / i17;
                        int i19 = height / i18;
                        iArr = new int[i17 * i19];
                        for (int i26 = 0; i26 < i17; i26++) {
                            for (int i27 = 0; i27 < i19; i27++) {
                                iArr[(i26 * i19) + i27] = bitmap.getPixel(i26 * i18, i27 * i18);
                            }
                        }
                    } else {
                        int[] iArr2 = new int[width * height];
                        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
                        iArr = iArr2;
                    }
                    bitmap.recycle();
                    Arrays.sort(iArr);
                    int length = iArr.length / 2;
                    if (iArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    int i28 = iArr[length];
                    int length2 = iArr.length;
                    int i29 = length;
                    for (int i36 = length + 1; i36 < length2; i36++) {
                        int i37 = iArr[i36];
                        if (i37 != iArr[i29] && !isCloseColor(i28, i37)) {
                            break;
                        }
                        i29 = i36;
                    }
                    while (true) {
                        i3 = length;
                        length--;
                        if (-1 >= length || ((i16 = iArr[length]) != iArr[i3] && !isCloseColor(i28, i16))) {
                            break;
                        }
                    }
                    float length3 = ((i29 - i3) + 1) / iArr.length;
                    QLog.d(this.TAG, 1, "saveChatBgMainPixel : midPixel " + i28 + " ColorPercent : " + length3);
                    if (length3 >= this.managerConfig.f406993d) {
                        VipNtMMKV.INSTANCE.getBubbleTextColorInfo().encodeInt(bgPath, i28);
                        bitmap.recycle();
                    } else {
                        VipNtMMKV.INSTANCE.getBubbleTextColorInfo().encodeInt(bgPath, 0);
                    }
                } catch (Exception e16) {
                    QLog.e(this.TAG, 1, "saveChatBgMainPixel : getPixel " + e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveNativeAllChatBgMainPixel$lambda$1(BubbleTextColorManagerImpl this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
        if (!TextUtils.isEmpty(skinRootPath) && !Intrinsics.areEqual("null", skinRootPath)) {
            String str2 = File.separator;
            String str3 = skinRootPath + str2 + "drawable-xxhdpi" + str2 + "skin_chat_background.png";
            QLog.d(this$0.TAG, 1, "saveNativeChatBgMainPixel : currentThemeChatBgPath" + str3);
            this$0.saveChatBgMainPixel(str3);
        }
        this$0.saveChatBgMainPixel(str);
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager
    public int calculateTransparentBubbleTextColor(@NotNull String bubbleId, int textColor, @NotNull AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (!this.isEnable) {
            return IBubbleTextColorManager.INSTANCE.a();
        }
        this.lastAioMsgItem = new WeakReference<>(aioMsgItem);
        String u16 = aioMsgItem.u();
        if (TextUtils.isEmpty(u16) || Intrinsics.areEqual("null", u16)) {
            if (QQTheme.isNowThemeIsNight()) {
                u16 = this.NIGHT_CHAT_BG;
            } else if (QQTheme.isDefaultTheme()) {
                u16 = this.LIGHT_CHAT_BG;
            } else {
                String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
                String str = File.separator;
                u16 = skinRootPath + str + "drawable-xxhdpi" + str + "skin_chat_background.png";
            }
        }
        if (TextUtils.isEmpty(bubbleId)) {
            return IBubbleTextColorManager.INSTANCE.a();
        }
        String str2 = bubbleId + "_" + u16;
        Integer num = this.CACHE.get(str2);
        if (num != null) {
            return num.intValue();
        }
        if (!isTransparentBitmap(bubbleId)) {
            return IBubbleTextColorManager.INSTANCE.a();
        }
        int chatBgMainPixel = getChatBgMainPixel(u16);
        IBubbleTextColorManager.Companion companion = IBubbleTextColorManager.INSTANCE;
        if (chatBgMainPixel == companion.a()) {
            saveNativeAllChatBgMainPixel(u16);
            return companion.a();
        }
        if (chatBgMainPixel == 0) {
            this.CACHE.put(str2, Integer.valueOf(companion.a()));
            return companion.a();
        }
        int calculateTextColor = calculateTextColor(chatBgMainPixel, textColor);
        this.CACHE.put(str2, Integer.valueOf(calculateTextColor));
        QLog.i(this.TAG, 1, "calculateTransparentBubbleTextColor: k->" + str2 + " color->" + calculateTextColor);
        return calculateTextColor;
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager
    public void saveBubbleIsTransparent(@NotNull final String bubbleBgPath, @NotNull final String bubbleId) {
        Intrinsics.checkNotNullParameter(bubbleBgPath, "bubbleBgPath");
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        if (!this.isEnable) {
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(ThreadManagerV2.getFileThreadLooper());
        }
        Handler handler = this.mHandler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: k03.a
            @Override // java.lang.Runnable
            public final void run() {
                BubbleTextColorManagerImpl.saveBubbleIsTransparent$lambda$2(bubbleBgPath, bubbleId, this);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager
    public void saveNativeAllChatBgMainPixel(@Nullable final String chatBgPath) {
        if (!this.isEnable) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: k03.b
            @Override // java.lang.Runnable
            public final void run() {
                BubbleTextColorManagerImpl.saveNativeAllChatBgMainPixel$lambda$1(BubbleTextColorManagerImpl.this, chatBgPath);
            }
        }, 16, null, true);
    }
}
