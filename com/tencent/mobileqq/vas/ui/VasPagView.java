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
import org.libpag.PAGView;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "Lorg/libpag/PAGView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "apiImpl", "Lcom/tencent/mobileqq/vas/ui/VasPagView$MyVasPagViewApiImpl;", DTConstants.TAG.API, "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "buildView", "MyVasPagViewApiImpl", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public class VasPagView extends PagViewProxy<PAGView> {

    @NotNull
    private final MyVasPagViewApiImpl apiImpl;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fH\u0017J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/VasPagView$MyVasPagViewApiImpl;", "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "Lorg/libpag/PAGView;", "vasPagView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "(Lcom/tencent/mobileqq/vas/ui/VasPagView;)V", "getVasPagView", "()Lcom/tencent/mobileqq/vas/ui/VasPagView;", "build", "getCurrentView", "Landroid/view/View;", "isBuild", "", "postAction", "block", "Lkotlin/Function1;", "", "refresh", "setStateChangeListener", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class MyVasPagViewApiImpl implements IVasPagViewApi<PAGView> {

        @NotNull
        private final VasPagView vasPagView;

        public MyVasPagViewApiImpl(@NotNull VasPagView vasPagView) {
            Intrinsics.checkNotNullParameter(vasPagView, "vasPagView");
            this.vasPagView = vasPagView;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @NotNull
        public IVasPagViewApi<PAGView> build() {
            this.vasPagView.build();
            return this;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @Nullable
        public View getCurrentView() {
            return this.vasPagView.getCurrentView();
        }

        @NotNull
        public final VasPagView getVasPagView() {
            return this.vasPagView;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        public boolean isBuild() {
            return this.vasPagView.getIsBuild();
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @UiThread
        @NotNull
        public IVasPagViewApi<PAGView> postAction(@NotNull Function1<? super PAGView, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.vasPagView.postAction(block);
            return this;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @NotNull
        public IVasPagViewApi<PAGView> refresh() {
            this.vasPagView.refresh();
            return this;
        }

        @Override // com.tencent.mobileqq.vas.ui.IVasPagViewApi
        @NotNull
        public IVasPagViewApi<PAGView> setStateChangeListener(@NotNull Function1<? super View, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.vasPagView.setStateChangeListener(block);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasPagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.apiImpl = new MyVasPagViewApiImpl(this);
    }

    @NotNull
    public final IVasPagViewApi<PAGView> api() {
        return this.apiImpl;
    }

    @Override // com.tencent.mobileqq.vas.ui.PagViewProxy
    @NotNull
    public PAGView buildView() {
        PAGView pAGView = new PAGView(getContext());
        pAGView.addPAGFlushListener(new PAGView.PAGFlushListener() { // from class: com.tencent.mobileqq.vas.ui.i
            @Override // org.libpag.PAGView.PAGFlushListener
            public final void onFlush() {
                VasPagView.buildView$lambda$1$lambda$0();
            }
        });
        return pAGView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VasPagView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VasPagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildView$lambda$1$lambda$0() {
    }
}
