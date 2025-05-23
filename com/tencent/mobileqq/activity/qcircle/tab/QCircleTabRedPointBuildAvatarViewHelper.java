package com.tencent.mobileqq.activity.qcircle.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.tab.QCircleTabRedPointBuildAvatarViewHelper;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleDrawableUtil;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/tab/QCircleTabRedPointBuildAvatarViewHelper;", "", "Landroid/view/View;", "qCircleTab", "", "i", "Landroid/widget/RelativeLayout;", "", PhotoCategorySummaryInfo.AVATAR_URL, "uin", "Landroid/widget/FrameLayout;", "b", "(Landroid/widget/RelativeLayout;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cornerUrl", "c", "(Landroid/widget/RelativeLayout;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wording", "e", "Landroid/content/Context;", "context", "d", "g", "f", "", "I", "getAVATAR_SIZE", "()I", "AVATAR_SIZE", "getAVATAR_CORNER_SIZE", "AVATAR_CORNER_SIZE", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", h.F, "()Landroid/view/View$OnLayoutChangeListener;", "qCircleTabIconLayoutChangeListener", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleTabRedPointBuildAvatarViewHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCircleTabRedPointBuildAvatarViewHelper f184586a = new QCircleTabRedPointBuildAvatarViewHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int AVATAR_SIZE = LayoutAttrsKt.getDp(26);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int AVATAR_CORNER_SIZE = LayoutAttrsKt.getDp(16);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final View.OnLayoutChangeListener qCircleTabIconLayoutChangeListener = new a();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/activity/qcircle/tab/QCircleTabRedPointBuildAvatarViewHelper$a", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements View.OnLayoutChangeListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view, a this$0) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            view.addOnLayoutChangeListener(this$0);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull final View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            View a16;
            Intrinsics.checkNotNullParameter(view, "view");
            QCircleTabRedPointBuildAvatarViewHelper qCircleTabRedPointBuildAvatarViewHelper = QCircleTabRedPointBuildAvatarViewHelper.f184586a;
            RelativeLayout g16 = qCircleTabRedPointBuildAvatarViewHelper.g();
            if (g16 != null && (a16 = com.tencent.mobileqq.activity.qcircle.utils.a.a(g16)) != null && a16.getId() == R.id.f32300td) {
                view.removeOnLayoutChangeListener(this);
                qCircleTabRedPointBuildAvatarViewHelper.i(a16, g16);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.tab.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleTabRedPointBuildAvatarViewHelper.a.b(view, this);
                    }
                });
            }
        }
    }

    QCircleTabRedPointBuildAvatarViewHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View view, View view2) {
        int measuredWidth;
        view.measure(0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = LayoutAttrsKt.getDp(3);
        if (view.getMeasuredWidth() + LayoutAttrsKt.getDp(3) < view2.getMeasuredWidth() / 2) {
            measuredWidth = (view2.getMeasuredWidth() / 2) + LayoutAttrsKt.getDp(3);
        } else {
            measuredWidth = view2.getMeasuredWidth() - view.getMeasuredWidth();
        }
        layoutParams.leftMargin = measuredWidth;
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(@NotNull RelativeLayout relativeLayout, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super FrameLayout> continuation) {
        QCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1 qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1;
        Object coroutine_suspended;
        int i3;
        Drawable drawable;
        if (continuation instanceof QCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1) {
            qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1 = (QCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1) continuation;
            int i16 = qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        relativeLayout = (RelativeLayout) qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QCircleDrawableUtil qCircleDrawableUtil = QCircleDrawableUtil.f184596a;
                    WeakReference<View> weakReference = new WeakReference<>(relativeLayout);
                    qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.L$0 = relativeLayout;
                    qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.label = 1;
                    obj = qCircleDrawableUtil.a(weakReference, str, str2, qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                drawable = (Drawable) obj;
                if (drawable != null) {
                    QLog.i("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "buildAvatarView, avatarDrawable == null");
                    return null;
                }
                FrameLayout frameLayout = new FrameLayout(relativeLayout.getContext());
                frameLayout.setId(R.id.f32260t_);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams.addRule(14);
                layoutParams.addRule(2, R.id.kbi);
                frameLayout.setLayoutParams(layoutParams);
                RoundImageView roundImageView = new RoundImageView(relativeLayout.getContext());
                int i17 = AVATAR_SIZE;
                roundImageView.setmRadius(i17 / 2, false);
                roundImageView.setImageDrawable(drawable);
                roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i17, i17);
                layoutParams2.topMargin = LayoutAttrsKt.getDp(3);
                layoutParams2.gravity = 16;
                roundImageView.setLayoutParams(layoutParams2);
                frameLayout.addView(roundImageView);
                return frameLayout;
            }
        }
        qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1 = new QCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1(this, continuation);
        Object obj2 = qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabRedPointBuildAvatarViewHelper$buildAvatarView$1.label;
        if (i3 == 0) {
        }
        drawable = (Drawable) obj2;
        if (drawable != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(@NotNull RelativeLayout relativeLayout, @NotNull String str, @NotNull Continuation<? super View> continuation) {
        QCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1 qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1;
        Object coroutine_suspended;
        int i3;
        Drawable drawable;
        if (continuation instanceof QCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1) {
            qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1 = (QCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1) continuation;
            int i16 = qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        relativeLayout = (RelativeLayout) qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QCircleDrawableUtil qCircleDrawableUtil = QCircleDrawableUtil.f184596a;
                    WeakReference<View> weakReference = new WeakReference<>(relativeLayout);
                    qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.L$0 = relativeLayout;
                    qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.label = 1;
                    obj = qCircleDrawableUtil.c(weakReference, str, qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                drawable = (Drawable) obj;
                if (drawable != null) {
                    QLog.i("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "buildCornerView, cornerDrawable == null");
                    return null;
                }
                ImageView imageView = new ImageView(relativeLayout.getContext());
                imageView.setId(R.id.f32280tb);
                imageView.setImageDrawable(drawable);
                int i17 = AVATAR_CORNER_SIZE;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i17, i17);
                layoutParams.topMargin = LayoutAttrsKt.getDp(3);
                layoutParams.addRule(14, -1);
                imageView.setLayoutParams(layoutParams);
                imageView.setTranslationX((i17 / 2) + LayoutAttrsKt.getDp(3));
                return imageView;
            }
        }
        qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1 = new QCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1(this, continuation);
        Object obj2 = qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabRedPointBuildAvatarViewHelper$buildIconCornerView$1.label;
        if (i3 == 0) {
        }
        drawable = (Drawable) obj2;
        if (drawable != null) {
        }
    }

    @NotNull
    public final View d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.f32290tc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        layoutParams.topMargin = (int) LayoutAttrsKt.getDp(Float.valueOf(3.5f));
        imageView.setImageResource(R.drawable.skin_tips_dot);
        imageView.setLayoutParams(layoutParams);
        imageView.setTranslationX(LayoutAttrsKt.getDp(Float.valueOf(15.0f)));
        return imageView;
    }

    @NotNull
    public final View e(@NotNull RelativeLayout qCircleTab, @NotNull String wording) {
        Intrinsics.checkNotNullParameter(qCircleTab, "qCircleTab");
        Intrinsics.checkNotNullParameter(wording, "wording");
        Context context = qCircleTab.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "qCircleTab.context");
        TextRedPointView textRedPointView = new TextRedPointView(context);
        textRedPointView.setId(R.id.f32300td);
        textRedPointView.setText(wording);
        f184586a.i(textRedPointView, qCircleTab);
        return textRedPointView;
    }

    @Nullable
    public final View f() {
        SplashActivity splashActivity;
        FrameFragment frameFragment;
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        if (weakReference != null) {
            splashActivity = weakReference.get();
        } else {
            splashActivity = null;
        }
        if (splashActivity == null) {
            QLog.e("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "getQCircleIconView, splashActivity is null");
            return null;
        }
        Fragment findFragmentByTag = splashActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag instanceof FrameFragment) {
            frameFragment = (FrameFragment) findFragmentByTag;
        } else {
            frameFragment = null;
        }
        if (frameFragment == null) {
            QLog.e("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "getQCircleIconView, frameFragment is null");
            return null;
        }
        View view = frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD);
        if (view == null) {
            return null;
        }
        return view.findViewById(R.id.j_k);
    }

    @Nullable
    public final RelativeLayout g() {
        SplashActivity splashActivity;
        FrameFragment frameFragment;
        View view;
        RedTouchTab redTouchTab;
        View view2;
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        if (weakReference != null) {
            splashActivity = weakReference.get();
        } else {
            splashActivity = null;
        }
        if (splashActivity == null) {
            QLog.e("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "getQCircleTab, splashActivity is null");
            return null;
        }
        Fragment findFragmentByTag = splashActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag instanceof FrameFragment) {
            frameFragment = (FrameFragment) findFragmentByTag;
        } else {
            frameFragment = null;
        }
        if (frameFragment == null) {
            QLog.e("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "getQCircleTab, frameFragment is null");
            return null;
        }
        TabViewMap tabViewMap = frameFragment.mTabViewMap;
        if (tabViewMap != null) {
            view = tabViewMap.get(TabDataHelper.TAB_NEW_WORLD);
        } else {
            view = null;
        }
        if (view instanceof RedTouchTab) {
            redTouchTab = (RedTouchTab) view;
        } else {
            redTouchTab = null;
        }
        if (redTouchTab != null) {
            view2 = redTouchTab.getTarget();
        } else {
            view2 = null;
        }
        if (view2 == null) {
            QLog.e("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "getQCircleTab, qCircleTab is null");
            return null;
        }
        if (!(view2 instanceof RelativeLayout)) {
            QLog.e("QCircleTabRedPoint-BuildAvatarViewHelper", 1, "getQCircleTab, qCircleTab is not RelativeLayout");
            return null;
        }
        return (RelativeLayout) view2;
    }

    @NotNull
    public final View.OnLayoutChangeListener h() {
        return qCircleTabIconLayoutChangeListener;
    }
}
