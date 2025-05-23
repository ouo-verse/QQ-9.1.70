package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.viewmodel.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderContainerView;", "Lcom/qzone/reborn/feedpro/widget/header/QzoneBaseFeedProHeaderContainerView;", "", "l0", "k0", "", "getLayoutId", "e", "Lcom/qzone/reborn/feedpro/widget/header/p;", "i", "Lcom/qzone/reborn/feedpro/widget/header/p;", "mCoverElement", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderNaviBarElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderNaviBarElement;", "mNaviBarElement", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderInfoElement;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderInfoElement;", "mHeaderInfoElement", "Lcom/qzone/reborn/feedpro/widget/header/ad;", "D", "Lcom/qzone/reborn/feedpro/widget/header/ad;", "mRefreshProgressElement", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "E", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/n;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/n;", "mScrollViewModel", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/qzone/reborn/feedx/viewmodel/c;", "viewModelProvider", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/qzone/reborn/feedx/viewmodel/c;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeHeaderContainerView extends QzoneBaseFeedProHeaderContainerView {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProUserHomeHeaderInfoElement mHeaderInfoElement;

    /* renamed from: D, reason: from kotlin metadata */
    private ad mRefreshProgressElement;

    /* renamed from: E, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.n mScrollViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private p mCoverElement;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProUserHomeHeaderNaviBarElement mNaviBarElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView, com.qzone.reborn.feedpro.widget.header.b
    public int e() {
        return getMeasuredHeight();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130418p;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView
    public void k0() {
        p pVar = new p(this);
        this.mCoverElement = pVar;
        m0(pVar);
        QzoneFeedProUserHomeHeaderNaviBarElement qzoneFeedProUserHomeHeaderNaviBarElement = new QzoneFeedProUserHomeHeaderNaviBarElement(this);
        this.mNaviBarElement = qzoneFeedProUserHomeHeaderNaviBarElement;
        m0(qzoneFeedProUserHomeHeaderNaviBarElement);
        QzoneFeedProUserHomeHeaderInfoElement qzoneFeedProUserHomeHeaderInfoElement = new QzoneFeedProUserHomeHeaderInfoElement(this);
        this.mHeaderInfoElement = qzoneFeedProUserHomeHeaderInfoElement;
        m0(qzoneFeedProUserHomeHeaderInfoElement);
        ad adVar = new ad(this, this.mScrollViewModel);
        this.mRefreshProgressElement = adVar;
        m0(adVar);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView
    public void l0() {
        MutableLiveData<com.qzone.reborn.feedpro.viewmodel.b> O1;
        this.mViewModel = (com.qzone.reborn.feedpro.viewmodel.m) this.f54544e.W(com.qzone.reborn.feedpro.viewmodel.m.class);
        this.mScrollViewModel = (com.qzone.reborn.feedpro.viewmodel.n) this.f54544e.W(com.qzone.reborn.feedpro.viewmodel.n.class);
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mViewModel;
        if (mVar == null || (O1 = mVar.O1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit> function1 = new Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeHeaderContainerView$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
            
                r3 = r2.this$0.mRefreshProgressElement;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                ad adVar;
                ad adVar2;
                b.Companion companion = com.qzone.reborn.feedpro.viewmodel.b.INSTANCE;
                if (Intrinsics.areEqual(bVar, companion.c())) {
                    adVar2 = QzoneFeedProUserHomeHeaderContainerView.this.mRefreshProgressElement;
                    if (adVar2 != null) {
                        adVar2.f();
                        return;
                    }
                    return;
                }
                if (!Intrinsics.areEqual(bVar, companion.d()) || adVar == null) {
                    return;
                }
                adVar.a();
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.widget.header.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeHeaderContainerView.p0(Function1.this, obj);
            }
        });
    }
}
