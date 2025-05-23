package com.tencent.mobileqq.transfile;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/transfile/NTAIOImgThumbHelper;", "", "()V", "aioImageDynamicMax", "", "aioImageDynamicMin", "aioImageMaxSize", "aioImageMaxSizeUnderLimit", "aioImageMinSize", "aioImageMinSizeUnderLimit", "density", "", "picSizeLimit", "sSizeInited", "", "getAioThumbMaxDp", "isDynamicImg", "isEmotion", "picMaxSize", "getAioThumbMaxPx", "getAioThumbMinDp", "getAioThumbMinPx", "getDensity", "initAioThumbSizeInner", "", "resetCache", "pic_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class NTAIOImgThumbHelper {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final NTAIOImgThumbHelper INSTANCE;
    private static final int aioImageDynamicMax = 135;
    private static final int aioImageDynamicMin = 45;
    private static int aioImageMaxSize = 0;
    private static final int aioImageMaxSizeUnderLimit = 135;
    private static int aioImageMinSize = 0;
    private static final int aioImageMinSizeUnderLimit = 45;
    private static float density = 0.0f;
    private static final int picSizeLimit = 200;
    private static boolean sSizeInited;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new NTAIOImgThumbHelper();
        density = -1.0f;
        aioImageMaxSize = 159;
        aioImageMinSize = 52;
        MobileQQ.sMobileQQ.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.tencent.mobileqq.transfile.NTAIOImgThumbHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(@NotNull Configuration newConfig) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) newConfig);
                    return;
                }
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                QLog.d("NTAIOImgThumbHelper", 1, "onConfigurationChanged");
                NTAIOImgThumbHelper.INSTANCE.resetCache();
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }
        });
    }

    NTAIOImgThumbHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final float getDensity() {
        boolean z16;
        if (density == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "getContext().getResources().getDisplayMetrics()");
            float f16 = displayMetrics.density;
            density = f16;
            if (f16 <= 0.0f) {
                density = 1.0f;
            }
        }
        return density;
    }

    public final int getAioThumbMaxDp(boolean isDynamicImg, boolean isEmotion, int picMaxSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isDynamicImg), Boolean.valueOf(isEmotion), Integer.valueOf(picMaxSize))).intValue();
        }
        if (isEmotion) {
            return CommonImgThumbHelper.getImgThumbMaxDp(isDynamicImg);
        }
        initAioThumbSizeInner();
        if (isDynamicImg || picMaxSize <= 200) {
            return 135;
        }
        return aioImageMaxSize;
    }

    public final int getAioThumbMaxPx(boolean isDynamicImg, boolean isEmotion, int picMaxSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isDynamicImg), Boolean.valueOf(isEmotion), Integer.valueOf(picMaxSize))).intValue();
        }
        return (int) (getAioThumbMaxDp(isDynamicImg, isEmotion, picMaxSize) * getDensity());
    }

    public final int getAioThumbMinDp(boolean isDynamicImg, boolean isEmotion, int picMaxSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(isDynamicImg), Boolean.valueOf(isEmotion), Integer.valueOf(picMaxSize))).intValue();
        }
        if (isEmotion) {
            return CommonImgThumbHelper.getImgThumbMinDp(isDynamicImg);
        }
        initAioThumbSizeInner();
        if (isDynamicImg || picMaxSize <= 200) {
            return 45;
        }
        return aioImageMinSize;
    }

    public final int getAioThumbMinPx(boolean isDynamicImg, boolean isEmotion, int picMaxSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isDynamicImg), Boolean.valueOf(isEmotion), Integer.valueOf(picMaxSize))).intValue();
        }
        return (int) (getAioThumbMinDp(isDynamicImg, isEmotion, picMaxSize) * getDensity());
    }

    public final synchronized void initAioThumbSizeInner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (sSizeInited) {
            return;
        }
        AIOPicThumbSizeConfig aIOPicThumbSizeConfig = new AIOPicThumbSizeConfig(0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
        if (aIOPicThumbSizeConfig.getMaxRatio() > 0.0f && aIOPicThumbSizeConfig.getMinRatio() > 0.0f) {
            DisplayMetrics displayMetrics = BaseApplication.context.getResources().getDisplayMetrics();
            e eVar = e.f194142a;
            int min = Math.min(eVar.f(), eVar.e());
            int a16 = a.C7329a.f192417a.a();
            a.c cVar = a.c.f192425a;
            aIOPicThumbSizeConfig.setTextOtherSpace(a16 + ((int) (cVar.a() / displayMetrics.density)) + ((int) (cVar.b() / displayMetrics.density)));
            float textOtherSpace = (int) ((min / displayMetrics.density) - aIOPicThumbSizeConfig.getTextOtherSpace());
            aIOPicThumbSizeConfig.setAioImageMinSize((int) (aIOPicThumbSizeConfig.getMinRatio() * textOtherSpace));
            aIOPicThumbSizeConfig.setAioImageMaxSize((int) (textOtherSpace * aIOPicThumbSizeConfig.getMaxRatio()));
            aioImageMaxSize = aIOPicThumbSizeConfig.getAioImageMaxSize();
            aioImageMinSize = aIOPicThumbSizeConfig.getAioImageMinSize();
        }
        sSizeInited = true;
    }

    public final void resetCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("NTAIOImgThumbHelper", 1, "resetCache");
        sSizeInited = false;
        density = -1.0f;
    }
}
