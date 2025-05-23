package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B#\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneMoodListProHeaderContainerView;", "Lcom/qzone/reborn/feedpro/widget/header/QzoneBaseFeedProHeaderContainerView;", "", "getLayoutId", "", "k0", "l0", "Lcom/qzone/reborn/feedpro/widget/header/af;", "i", "Lcom/qzone/reborn/feedpro/widget/header/af;", "mHeaderOperationElement", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/qzone/reborn/feedx/viewmodel/c;", "viewModelProvider", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/qzone/reborn/feedx/viewmodel/c;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneMoodListProHeaderContainerView extends QzoneBaseFeedProHeaderContainerView {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private af mHeaderOperationElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneMoodListProHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.clz;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView
    public void k0() {
        af afVar = new af(this);
        this.mHeaderOperationElement = afVar;
        m0(afVar);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView
    public void l0() {
    }
}
