package com.tencent.mobileqq.qwallet.hb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B!\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0012J\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0003\u001a\u00020\u0000J\u0006\u0010\u0004\u001a\u00020\u0000J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "j", "Lorg/libpag/PAGView;", "getPagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqpay-ui_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class FestivalHbPagView extends VasPagView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FestivalHbPagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FestivalHbPagView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setAlpha(1.0f);
    }

    @Nullable
    public final PAGView getPagView() {
        View currentView = api().getCurrentView();
        if (currentView instanceof PAGView) {
            return (PAGView) currentView;
        }
        return null;
    }

    @NotNull
    public final FestivalHbPagView i() {
        IVasPagViewApi<PAGView> api = api();
        if (api.isBuild()) {
            api.refresh();
        } else {
            api.build();
        }
        return this;
    }

    public final boolean j() {
        PAGView pagView = getPagView();
        if (pagView == null || !pagView.isPlaying()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final FestivalHbPagView k() {
        PAGView pagView = getPagView();
        if (pagView != null) {
            pagView.setComposition(null);
            pagView.flush();
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.a
            @Override // java.lang.Runnable
            public final void run() {
                FestivalHbPagView.l(FestivalHbPagView.this);
            }
        });
        return this;
    }

    @NotNull
    public final FestivalHbPagView m() {
        PAGView pagView = getPagView();
        if (pagView != null) {
            pagView.stop();
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FestivalHbPagView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FestivalHbPagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView$a;", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "pagView", "", "onAnimationStart", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "<init>", "()V", "qqpay-ui_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static class a implements PAGView.PAGViewListener {
        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView pagView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView pagView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView pagView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView pagView) {
        }
    }
}
