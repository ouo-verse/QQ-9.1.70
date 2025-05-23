package com.tencent.mobileqq.sharepanel.forward.v2.part;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/part/b;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "", "K9", "", "scrollY", "J9", "scrollHeight", "contentHeight", "I9", "Landroid/content/Context;", "context", "", "isTopBottom", "Landroid/graphics/drawable/Drawable;", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "f", "Landroid/view/View;", "topMaskView", h.F, "bottomMaskView", "Landroid/widget/ScrollView;", "i", "Landroid/widget/ScrollView;", "scrollView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "scrollContent", BdhLogUtil.LogTag.Tag_Conn, "I", "thresholdHeight", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends ForwardPreviewBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int thresholdHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View topMaskView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomMaskView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScrollView scrollView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View scrollContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/v2/part/b$a", "Landroid/view/View$OnScrollChangeListener;", "Landroid/view/View;", "v", "", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "", "onScrollChange", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements View.OnScrollChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(@Nullable View v3, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.J9(scrollY);
            } else {
                iPatchRedirector.redirect((short) 2, this, v3, Integer.valueOf(scrollX), Integer.valueOf(scrollY), Integer.valueOf(oldScrollX), Integer.valueOf(oldScrollY));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/v2/part/b$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.forward.v2.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class ViewOnLayoutChangeListenerC8584b implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        ViewOnLayoutChangeListenerC8584b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, v3, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
            } else if (top != oldTop || bottom != oldBottom) {
                b.this.K9();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        } else {
            this.thresholdHeight = ViewUtils.dip2px(28.0f);
        }
    }

    private final Drawable H9(Context context, boolean isTopBottom) {
        GradientDrawable.Orientation orientation;
        int color = context.getResources().getColor(R.color.qui_common_bg_middle_standard, null);
        if (isTopBottom) {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        } else {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
        }
        return new GradientDrawable(orientation, new int[]{color, 0});
    }

    private final void I9(int scrollHeight, int contentHeight, int scrollY) {
        float f16;
        Float f17;
        View view;
        View view2;
        int i3 = this.thresholdHeight;
        float f18 = 1.0f;
        if (scrollY >= i3) {
            f16 = 1.0f;
        } else {
            f16 = scrollY / i3;
        }
        View view3 = this.topMaskView;
        Float f19 = null;
        if (view3 != null) {
            f17 = Float.valueOf(view3.getAlpha());
        } else {
            f17 = null;
        }
        if (!Intrinsics.areEqual(f17, f16) && (view2 = this.topMaskView) != null) {
            view2.setAlpha(f16);
        }
        int i16 = (contentHeight - scrollHeight) - scrollY;
        int i17 = this.thresholdHeight;
        if (i16 < i17) {
            f18 = i16 / i17;
        }
        View view4 = this.bottomMaskView;
        if (view4 != null) {
            f19 = Float.valueOf(view4.getAlpha());
        }
        if (!Intrinsics.areEqual(f19, f18) && (view = this.bottomMaskView) != null) {
            view.setAlpha(f18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(int scrollY) {
        int i3;
        ScrollView scrollView = this.scrollView;
        int i16 = 0;
        if (scrollView != null) {
            i3 = scrollView.getHeight();
        } else {
            i3 = 0;
        }
        View view = this.scrollContent;
        if (view != null) {
            i16 = view.getHeight();
        }
        I9(i3, i16, scrollY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        ScrollView scrollView = this.scrollView;
        if (scrollView != null) {
            scrollView.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.L9(b.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(b this$0) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScrollView scrollView = this$0.scrollView;
        if (scrollView != null) {
            i3 = scrollView.getHeight();
        } else {
            i3 = 0;
        }
        View view = this$0.scrollContent;
        if (view != null) {
            i16 = view.getHeight();
        } else {
            i16 = 0;
        }
        ScrollView scrollView2 = this$0.scrollView;
        if (scrollView2 != null) {
            i17 = scrollView2.getScrollY();
        } else {
            i17 = 0;
        }
        if (i3 >= i16) {
            View view2 = this$0.topMaskView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this$0.bottomMaskView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        } else {
            View view4 = this$0.topMaskView;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            View view5 = this$0.bottomMaskView;
            if (view5 != null) {
                view5.setVisibility(0);
            }
        }
        this$0.I9(i3, i16, i17);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        ScrollView scrollView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view3 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.jto);
        } else {
            view = null;
        }
        this.topMaskView = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f164631ad3);
        } else {
            view2 = null;
        }
        this.bottomMaskView = view2;
        if (rootView != null) {
            scrollView = (ScrollView) rootView.findViewById(R.id.iig);
        } else {
            scrollView = null;
        }
        this.scrollView = scrollView;
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f80474bk);
        }
        this.scrollContent = view3;
        View view4 = this.topMaskView;
        if (view4 != null) {
            Context context = view4.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            view4.setBackground(H9(context, true));
        }
        View view5 = this.bottomMaskView;
        if (view5 != null) {
            Context context2 = view5.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "it.context");
            view5.setBackground(H9(context2, false));
        }
        ScrollView scrollView2 = this.scrollView;
        if (scrollView2 != null) {
            scrollView2.setOnScrollChangeListener(new a());
        }
        ScrollView scrollView3 = this.scrollView;
        if (scrollView3 != null) {
            scrollView3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC8584b());
        }
        K9();
    }
}
