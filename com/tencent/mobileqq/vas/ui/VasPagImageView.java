package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0012B\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0013J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "Lorg/libpag/PAGImageView;", "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", DTConstants.TAG.API, "f", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView$a;", "d", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView$a;", "apiImpl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class VasPagImageView extends PagViewProxy<PAGImageView> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a apiImpl;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0017J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\tH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/VasPagImageView$a;", "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "Lorg/libpag/PAGImageView;", "build", "refresh", "Lkotlin/Function1;", "", "block", "postAction", "Landroid/view/View;", "setStateChangeListener", "", "isBuild", "getCurrentView", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "a", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "getVasPagView", "()Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "vasPagView", "<init>", "(Lcom/tencent/mobileqq/vas/ui/VasPagImageView;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements IVasPagViewApi<PAGImageView> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final VasPagImageView vasPagView;

        public a(@NotNull VasPagImageView vasPagView) {
            Intrinsics.checkNotNullParameter(vasPagView, "vasPagView");
            this.vasPagView = vasPagView;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @NotNull
        public IVasPagViewApi<PAGImageView> build() {
            this.vasPagView.build();
            return this;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @Nullable
        public View getCurrentView() {
            return this.vasPagView.getCurrentView();
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        public boolean isBuild() {
            return this.vasPagView.getIsBuild();
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @UiThread
        @NotNull
        public IVasPagViewApi<PAGImageView> postAction(@NotNull Function1<? super PAGImageView, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.vasPagView.postAction(block);
            return this;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @NotNull
        public IVasPagViewApi<PAGImageView> refresh() {
            this.vasPagView.refresh();
            return this;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @NotNull
        public IVasPagViewApi<PAGImageView> setStateChangeListener(@NotNull Function1<? super View, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.vasPagView.setStateChangeListener(block);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasPagImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.apiImpl = new a(this);
    }

    @NotNull
    public final IVasPagViewApi<PAGImageView> api() {
        return this.apiImpl;
    }

    @Override // com.tencent.mobileqq.vas.ui.PagViewProxy
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public PAGImageView buildView() {
        return new PAGImageView(getContext());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VasPagImageView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VasPagImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
