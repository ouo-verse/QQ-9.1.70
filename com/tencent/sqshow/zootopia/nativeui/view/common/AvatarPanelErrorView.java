package com.tencent.sqshow.zootopia.nativeui.view.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n74.t;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "Landroid/widget/RelativeLayout;", "", "title", "", "f", "desc", "b", TuxUIConstants.POP_BTN_TEXT, "setRetryButtonText", "", NodeProps.VISIBLE, "setRetryButtonVisibility", "Landroid/view/View$OnClickListener;", "onClickListener", "setOnRetryButtonOnClickListener", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "setNetErrorVisibility", "setRetryButton", "Landroid/widget/Button;", "c", "Ln74/t;", "d", "Lkotlin/Lazy;", "()Ln74/t;", "viewBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarPanelErrorView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPanelErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<t>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final t invoke() {
                return t.f(LayoutInflater.from(AvatarPanelErrorView.this.getContext()), AvatarPanelErrorView.this);
            }
        });
        this.viewBinding = lazy;
    }

    private final t d() {
        return (t) this.viewBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View.OnClickListener onClickListener, AvatarPanelErrorView this$0, View view) {
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onClickListener.onClick(this$0.d().f419414b);
    }

    public final void b(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        d().f419416d.setText(desc);
    }

    public final Button c() {
        Button button = d().f419414b;
        Intrinsics.checkNotNullExpressionValue(button, "viewBinding.btnErrorProcess");
        return button;
    }

    public final void f(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        d().f419417e.setText(title);
    }

    public final void setNetErrorVisibility(boolean visible, int imageType) {
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(imageType).setBackgroundColorType(0).setThemeType(0).setHalfScreenState(true).build();
        d().f419415c.removeAllViews();
        d().f419415c.addView(build, -1, -1);
        d().f419415c.setVisibility(visible ? 0 : 8);
    }

    public final void setOnRetryButtonOnClickListener(final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        d().f419414b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.common.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarPanelErrorView.e(onClickListener, this, view);
            }
        });
    }

    public final void setRetryButton(String btnText, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        if (TextUtils.isEmpty(btnText)) {
            return;
        }
        setRetryButtonVisibility(true);
        setRetryButtonText(btnText);
        setOnRetryButtonOnClickListener(onClickListener);
    }

    public final void setRetryButtonText(String btnText) {
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        d().f419414b.setText(btnText);
    }

    public final void setRetryButtonVisibility(boolean visible) {
        d().f419414b.setVisibility(visible ? 0 : 8);
    }

    public static /* synthetic */ void setNetErrorVisibility$default(AvatarPanelErrorView avatarPanelErrorView, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        avatarPanelErrorView.setNetErrorVisibility(z16, i3);
    }
}
