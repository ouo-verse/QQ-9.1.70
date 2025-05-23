package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B1\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020!\u0012\b\b\u0002\u0010*\u001a\u00020!\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0014R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010$\u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/PullRefreshIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshState;", "state", "", "C0", "", "show", CanvasView.ACTION_ROTATE, "E0", "onFinishInflate", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "refreshText", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "refreshArrow", "f", "refreshingDot", tl.h.F, "refreshingCircle", "Landroidx/lifecycle/Observer;", "i", "Landroidx/lifecycle/Observer;", "B0", "()Landroidx/lifecycle/Observer;", "refreshStateObserver", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/home/PullRefreshState;", "lastState", "", "A0", "()I", "refreshHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PullRefreshIndicator extends ConstraintLayout implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView refreshText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView refreshArrow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView refreshingDot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView refreshingCircle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<PullRefreshState> refreshStateObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PullRefreshState lastState;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f277950a;

        static {
            int[] iArr = new int[PullRefreshState.values().length];
            try {
                iArr[PullRefreshState.PULLING_NO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PullRefreshState.PULLING_CAN_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f277950a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshIndicator(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C0(PullRefreshState state) {
        QLog.d("PullRefreshIndicator", 1, "onStateChanged: lastState " + this.lastState + ", curState " + state);
        if (this.lastState == state) {
            return;
        }
        this.lastState = state;
        TextView textView = this.refreshText;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshText");
            textView = null;
        }
        textView.setText(state.getText());
        int i3 = b.f277950a[state.ordinal()];
        int i16 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                E0(false, false);
            } else {
                E0(true, true);
            }
        } else {
            E0(true, false);
        }
        if (state != PullRefreshState.REFRESHING) {
            i16 = 8;
        }
        TextView textView2 = this.refreshingDot;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshingDot");
            textView2 = null;
        }
        textView2.setVisibility(i16);
        ImageView imageView2 = this.refreshingCircle;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshingCircle");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(PullRefreshIndicator this$0, PullRefreshState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.C0(it);
    }

    private final void E0(boolean show, boolean rotate) {
        int i3;
        float f16;
        ImageView imageView = this.refreshArrow;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshArrow");
            imageView = null;
        }
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        if (show) {
            ImageView imageView3 = this.refreshArrow;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshArrow");
            } else {
                imageView2 = imageView3;
            }
            ViewPropertyAnimator duration = imageView2.animate().setDuration(300L);
            if (rotate) {
                f16 = 180.0f;
            } else {
                f16 = 0.0f;
            }
            duration.rotation(f16).start();
        }
    }

    public final int A0() {
        TextView textView = this.refreshText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshText");
            textView = null;
        }
        return textView.getHeight();
    }

    @NotNull
    public final Observer<PullRefreshState> B0() {
        return this.refreshStateObserver;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.hje, this);
        View findViewById = findViewById(R.id.i5p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.refresh_text)");
        this.refreshText = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f72233qa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.refresh_arrow)");
        this.refreshArrow = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f72413qs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.refreshing_dot)");
        this.refreshingDot = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f72403qr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.refreshing_circle)");
        this.refreshingCircle = (ImageView) findViewById4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PullRefreshIndicator(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.refreshStateObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PullRefreshIndicator.D0(PullRefreshIndicator.this, (PullRefreshState) obj);
            }
        };
    }
}
