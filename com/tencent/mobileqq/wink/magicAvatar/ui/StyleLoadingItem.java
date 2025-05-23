package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/StyleLoadingItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Landroid/view/View;", "E", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "scanningLightView", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StyleLoadingItem extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy scanningLightView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StyleLoadingItem(@NotNull View view) {
        super(view);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ScanningLightView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleLoadingItem$scanningLightView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScanningLightView invoke() {
                View view2;
                view2 = StyleLoadingItem.this.view;
                return (ScanningLightView) view2.findViewById(R.id.f79704_h);
            }
        });
        this.scanningLightView = lazy;
    }

    private final ScanningLightView m() {
        Object value = this.scanningLightView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-scanningLightView>(...)");
        return (ScanningLightView) value;
    }

    public final void o() {
        m().v(true);
    }
}
