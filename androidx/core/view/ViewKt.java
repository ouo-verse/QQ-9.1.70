package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a5\u0010 \u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u00f8\u0001\u0000\u001a5\u0010'\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u00f8\u0001\u0000\u001a5\u0010(\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u00f8\u0001\u0000\u001a5\u0010)\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u00f8\u0001\u0000\u001a5\u0010*\u001a\u00020+*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u00f8\u0001\u0000\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/\u001a(\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0086\b\u00f8\u0001\u0000\u001a(\u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0087\b\u00f8\u0001\u0000\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0013H\u0086\b\u001a:\u00108\u001a\u00020!\"\n\b\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#\u00a2\u0006\u0002\b<H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b=\u001a)\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#\u00a2\u0006\u0002\b<H\u0086\b\u00f8\u0001\u0000\u001a5\u0010>\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010?\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010A\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\u001a5\u0010C\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010D\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010E\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006F"}, d2 = {"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "value", "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", NodeProps.MARGIN_BOTTOM, "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", NodeProps.MARGIN_LEFT, "getMarginLeft", NodeProps.MARGIN_RIGHT, "getMarginRight", "marginStart", "getMarginStart", NodeProps.MARGIN_TOP, "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(@NotNull final View doOnAttach, @NotNull final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnAttach, "$this$doOnAttach");
        Intrinsics.checkNotNullParameter(action, "action");
        if (ViewCompat.isAttachedToWindow(doOnAttach)) {
            action.invoke(doOnAttach);
        } else {
            doOnAttach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    doOnAttach.removeOnAttachStateChangeListener(this);
                    action.invoke(view);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                }
            });
        }
    }

    public static final void doOnDetach(@NotNull final View doOnDetach, @NotNull final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnDetach, "$this$doOnDetach");
        Intrinsics.checkNotNullParameter(action, "action");
        if (!ViewCompat.isAttachedToWindow(doOnDetach)) {
            action.invoke(doOnDetach);
        } else {
            doOnDetach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    doOnDetach.removeOnAttachStateChangeListener(this);
                    action.invoke(view);
                }
            });
        }
    }

    public static final void doOnLayout(@NotNull View doOnLayout, @NotNull final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnLayout, "$this$doOnLayout");
        Intrinsics.checkNotNullParameter(action, "action");
        if (ViewCompat.isLaidOut(doOnLayout) && !doOnLayout.isLayoutRequested()) {
            action.invoke(doOnLayout);
        } else {
            doOnLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    Function1.this.invoke(view);
                }
            });
        }
    }

    public static final void doOnNextLayout(@NotNull View doOnNextLayout, @NotNull final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnNextLayout, "$this$doOnNextLayout");
        Intrinsics.checkNotNullParameter(action, "action");
        doOnNextLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.removeOnLayoutChangeListener(this);
                Function1.this.invoke(view);
            }
        });
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull final View doOnPreDraw, @NotNull final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnPreDraw, "$this$doOnPreDraw");
        Intrinsics.checkNotNullParameter(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(doOnPreDraw, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke(doOnPreDraw);
            }
        });
        Intrinsics.checkNotNullExpressionValue(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull View drawToBitmap, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(drawToBitmap, "$this$drawToBitmap");
        Intrinsics.checkNotNullParameter(config, "config");
        if (ViewCompat.isLaidOut(drawToBitmap)) {
            Bitmap createBitmap = Bitmap.createBitmap(drawToBitmap.getWidth(), drawToBitmap.getHeight(), config);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-drawToBitmap.getScrollX(), -drawToBitmap.getScrollY());
            drawToBitmap.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    @NotNull
    public static final Sequence<View> getAllViews(@NotNull View allViews) {
        Sequence<View> sequence;
        Intrinsics.checkNotNullParameter(allViews, "$this$allViews");
        sequence = SequencesKt__SequenceBuilderKt.sequence(new ViewKt$allViews$1(allViews, null));
        return sequence;
    }

    @NotNull
    public static final Sequence<ViewParent> getAncestors(@NotNull View ancestors) {
        Sequence<ViewParent> generateSequence;
        Intrinsics.checkNotNullParameter(ancestors, "$this$ancestors");
        generateSequence = SequencesKt__SequencesKt.generateSequence(ancestors.getParent(), (Function1<? super ViewParent, ? extends ViewParent>) ((Function1<? super Object, ? extends Object>) ViewKt$ancestors$1.INSTANCE));
        return generateSequence;
    }

    public static final int getMarginBottom(@NotNull View marginBottom) {
        Intrinsics.checkNotNullParameter(marginBottom, "$this$marginBottom");
        ViewGroup.LayoutParams layoutParams = marginBottom.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@NotNull View marginEnd) {
        Intrinsics.checkNotNullParameter(marginEnd, "$this$marginEnd");
        ViewGroup.LayoutParams layoutParams = marginEnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@NotNull View marginLeft) {
        Intrinsics.checkNotNullParameter(marginLeft, "$this$marginLeft");
        ViewGroup.LayoutParams layoutParams = marginLeft.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@NotNull View marginRight) {
        Intrinsics.checkNotNullParameter(marginRight, "$this$marginRight");
        ViewGroup.LayoutParams layoutParams = marginRight.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@NotNull View marginStart) {
        Intrinsics.checkNotNullParameter(marginStart, "$this$marginStart");
        ViewGroup.LayoutParams layoutParams = marginStart.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@NotNull View marginTop) {
        Intrinsics.checkNotNullParameter(marginTop, "$this$marginTop");
        ViewGroup.LayoutParams layoutParams = marginTop.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@NotNull View isGone) {
        Intrinsics.checkNotNullParameter(isGone, "$this$isGone");
        if (isGone.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(@NotNull View isInvisible) {
        Intrinsics.checkNotNullParameter(isInvisible, "$this$isInvisible");
        if (isInvisible.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(@NotNull View isVisible) {
        Intrinsics.checkNotNullParameter(isVisible, "$this$isVisible");
        if (isVisible.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View postDelayed, long j3, @NotNull final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(postDelayed, "$this$postDelayed");
        Intrinsics.checkNotNullParameter(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        postDelayed.postDelayed(runnable, j3);
        return runnable;
    }

    @RequiresApi(16)
    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull View postOnAnimationDelayed, long j3, @NotNull final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(postOnAnimationDelayed, "$this$postOnAnimationDelayed");
        Intrinsics.checkNotNullParameter(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        postOnAnimationDelayed.postOnAnimationDelayed(runnable, j3);
        return runnable;
    }

    public static final void setGone(@NotNull View isGone, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(isGone, "$this$isGone");
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        isGone.setVisibility(i3);
    }

    public static final void setInvisible(@NotNull View isInvisible, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(isInvisible, "$this$isInvisible");
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        isInvisible.setVisibility(i3);
    }

    public static final void setPadding(@NotNull View setPadding, @Px int i3) {
        Intrinsics.checkNotNullParameter(setPadding, "$this$setPadding");
        setPadding.setPadding(i3, i3, i3, i3);
    }

    public static final void setVisible(@NotNull View isVisible, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(isVisible, "$this$isVisible");
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        isVisible.setVisibility(i3);
    }

    public static final void updateLayoutParams(@NotNull View updateLayoutParams, @NotNull Function1<? super ViewGroup.LayoutParams, Unit> block) {
        Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        if (layoutParams != null) {
            block.invoke(layoutParams);
            updateLayoutParams.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View updateLayoutParams, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        block.invoke(layoutParams);
        updateLayoutParams.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@NotNull View updatePadding, @Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        Intrinsics.checkNotNullParameter(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i3, i16, i17, i18);
    }

    public static /* synthetic */ void updatePadding$default(View updatePadding, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = updatePadding.getPaddingLeft();
        }
        if ((i19 & 2) != 0) {
            i16 = updatePadding.getPaddingTop();
        }
        if ((i19 & 4) != 0) {
            i17 = updatePadding.getPaddingRight();
        }
        if ((i19 & 8) != 0) {
            i18 = updatePadding.getPaddingBottom();
        }
        Intrinsics.checkNotNullParameter(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i3, i16, i17, i18);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@NotNull View updatePaddingRelative, @Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        Intrinsics.checkNotNullParameter(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i3, i16, i17, i18);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View updatePaddingRelative, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = updatePaddingRelative.getPaddingStart();
        }
        if ((i19 & 2) != 0) {
            i16 = updatePaddingRelative.getPaddingTop();
        }
        if ((i19 & 4) != 0) {
            i17 = updatePaddingRelative.getPaddingEnd();
        }
        if ((i19 & 8) != 0) {
            i18 = updatePaddingRelative.getPaddingBottom();
        }
        Intrinsics.checkNotNullParameter(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i3, i16, i17, i18);
    }
}
