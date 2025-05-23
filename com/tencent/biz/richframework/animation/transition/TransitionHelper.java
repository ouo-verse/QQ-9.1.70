package com.tencent.biz.richframework.animation.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionHelper {
    private static volatile TransitionHelper sInstance;
    private SparseArray<WeakReference<View>> mPrePageViews = new SparseArray<>();
    private ConcurrentHashMap<Integer, WeakReference<TransitionBeanCreator>> mTransitionBeanGenerators = new ConcurrentHashMap<>();
    private static final Float NUM_1000F = Float.valueOf(1000.0f);
    private static final Float NUM_100F = Float.valueOf(100.0f);
    private static final Float MAX_RATIO = Float.valueOf(1.0f);
    private static float mPreRation = 0.0f;
    private static float mPreWnsValue = 0.0f;
    private static int mDisPlayWidth = 0;
    private static int mDisPlayHeight = 0;
    private static int mPreFullVideoH = 0;
    private static int mPreFullVideoW = 0;
    private static float mPreFullWidthRatio = 0.0f;
    private static float mPreMaxRatio = 0.0f;
    private static float mPreMinRation = 0.0f;
    private static int mPreYFullVideoH = 0;
    private static int mPreYFullVideoW = 0;
    private static float mPreYFullHeightWidthRatio = 0.0f;
    private static float mPreYFullMaxRatio = 0.0f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface TransitionBeanCreator {
        TransitionBean generateTransitionBean(int i3);
    }

    TransitionHelper() {
    }

    private static boolean enableAdjustScreenParam() {
        if (c.X0("qqcircle", "secondary_key_enable_adjust_screen_param", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static TransitionHelper g() {
        if (sInstance == null) {
            synchronized (TransitionHelper.class) {
                if (sInstance == null) {
                    sInstance = new TransitionHelper();
                }
            }
        }
        return sInstance;
    }

    public static int getRealScreenWidth(Context context) {
        if (isErrorScreenParam(context)) {
            return DisplayUtil.getInstantScreenHeight(context);
        }
        return DisplayUtil.getInstantScreenWidth(context);
    }

    private static boolean isErrorScreenParam(Context context) {
        boolean z16;
        if (DisplayUtil.getInstantScreenWidth(context) > DisplayUtil.getInstantScreenHeight(context)) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("TransitionHelper", 1, "[isErrorScreenParam] " + z16);
        if (!z16 || !enableAdjustScreenParam()) {
            return false;
        }
        return true;
    }

    public static boolean isFolderScreenOpenMode(Context context) {
        if (context == null) {
            return false;
        }
        return isFolderScreenOpenMode(DisplayUtil.getInstantScreenWidth(context), DisplayUtil.getInstantScreenHeight(context));
    }

    private static void setCoverSize(ImageView imageView, int i3, int i16) {
        FrameLayout.LayoutParams layoutParams;
        if (imageView != null && (imageView.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams()) != null) {
            layoutParams.width = i3;
            layoutParams.height = i16;
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
        }
    }

    public static void setSizeWhenYFullScreen(int i3, ImageView imageView, int i16, int i17) {
        if (i3 != 0 && i3 > 0) {
            setCoverSize(imageView, (int) (i3 * (i16 / i17)), i3);
        }
    }

    public static boolean shouldFullScreen(int i3, int i16) {
        if (i3 == 0 || i16 == 0) {
            return false;
        }
        float f16 = i16 / i3;
        float intValue = c.X0("qqcircle", "qqcircle_show_vertical_video_max_ratio", 3000).intValue();
        Float f17 = NUM_1000F;
        float floatValue = intValue / f17.floatValue();
        float intValue2 = c.X0(ASEngineConstants.MAIN_KEY_FLASH_SHOW, "qqcircle_show_vertical_video_min_ratio", 1740).intValue() / f17.floatValue();
        if (mPreFullVideoH != i16 || mPreFullVideoW != i3 || mPreFullWidthRatio != f16 || mPreMaxRatio != floatValue || mPreMinRation != intValue2) {
            QLog.d("TransitionHelper", 1, "setSize origin size shouldFullScreen():" + i16 + "|" + i3 + "|" + f16 + "|" + floatValue + "|" + intValue2);
            mPreFullVideoH = i16;
            mPreFullVideoW = i3;
            mPreFullWidthRatio = f16;
            mPreMaxRatio = floatValue;
            mPreMinRation = intValue2;
        }
        if (f16 <= intValue2 || f16 >= floatValue) {
            return false;
        }
        return true;
    }

    public static boolean shouldVideoYFullScreen(int i3, int i16) {
        if (i3 == 0 || i16 == 0) {
            return false;
        }
        float f16 = i16 / i3;
        float intValue = c.X0("qqcircle", "qqcircle_show_vertical_video_max_ratio", 3000).intValue() / NUM_1000F.floatValue();
        if (mPreYFullVideoH != i16 || mPreYFullVideoW != i3 || mPreYFullHeightWidthRatio != f16 || mPreYFullMaxRatio != intValue) {
            QLog.d("TransitionHelper", 1, "setSize origin size shouldYFullScreen():" + i16 + "|" + i3 + "|" + f16 + "|" + intValue);
            mPreYFullVideoH = i16;
            mPreYFullVideoW = i3;
            mPreYFullHeightWidthRatio = f16;
            mPreYFullMaxRatio = intValue;
        }
        if (f16 < intValue) {
            return false;
        }
        return true;
    }

    public int addPrePageView(@NonNull View view) {
        this.mPrePageViews.put(view.hashCode(), new WeakReference<>(view));
        return view.hashCode();
    }

    public TransitionBeanCreator getTransitionBeanCreator(int i3) {
        WeakReference<TransitionBeanCreator> weakReference = this.mTransitionBeanGenerators.get(Integer.valueOf(i3));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int registerTransitionBeanCreator(@NonNull TransitionBeanCreator transitionBeanCreator) {
        this.mTransitionBeanGenerators.put(Integer.valueOf(transitionBeanCreator.hashCode()), new WeakReference<>(transitionBeanCreator));
        return transitionBeanCreator.hashCode();
    }

    public static boolean isFolderScreenOpenMode(int i3, int i16) {
        if (i3 == 0 || i16 == 0) {
            return false;
        }
        float f16 = i3 / i16;
        float intValue = c.X0("qqcircle", "qqcircle_folder_screen_mim_ratio", 71).intValue() / NUM_100F.floatValue();
        if (mPreRation != f16 || mPreWnsValue != intValue || mDisPlayWidth != i3 || mDisPlayHeight != i16) {
            QLog.d("TransitionHelper", 1, "isFolderScreenOpenMode:" + f16 + "|wnsRatio:" + intValue + "|maxRatio" + (1.0f / intValue) + "__disPlayWidth| disPlayHeight:" + i3 + "|" + i16);
            mPreRation = f16;
            mPreWnsValue = intValue;
            mDisPlayWidth = i3;
            mDisPlayHeight = i16;
        }
        return f16 > intValue && f16 < 1.0f / intValue;
    }
}
