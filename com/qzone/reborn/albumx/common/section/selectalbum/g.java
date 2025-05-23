package com.qzone.reborn.albumx.common.section.selectalbum;

import android.view.View;
import com.qzone.reborn.base.l;
import com.qzone.reborn.widget.QZoneSwipeMenuLayout;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/albumx/common/section/selectalbum/g;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/h;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "Lcom/qzone/reborn/widget/QZoneSwipeMenuLayout;", "e", "Lcom/qzone/reborn/widget/QZoneSwipeMenuLayout;", "swipeLayout", "f", "Landroid/view/View;", "editMenu", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends l<com.qzone.reborn.albumx.common.bean.h> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneSwipeMenuLayout swipeLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View editMenu;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(k.class).originView(view).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.e
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                g.z(g.this, (k) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.f
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                g.A(str);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void z(g this$0, k kVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        kVar.G8((com.qzone.reborn.albumx.common.bean.h) mData);
        QZoneSwipeMenuLayout qZoneSwipeMenuLayout = this$0.swipeLayout;
        if (qZoneSwipeMenuLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeLayout");
            qZoneSwipeMenuLayout = null;
        }
        qZoneSwipeMenuLayout.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.albumx.common.bean.h data, int position, List<Object> payload) {
        View view = this.editMenu;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editMenu");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.common.section.selectalbum.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.y(g.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162971nm1};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.ng_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.swipe_layout)");
            this.swipeLayout = (QZoneSwipeMenuLayout) findViewById;
            View findViewById2 = containerView.findViewById(R.id.mgx);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.menu_edit)");
            this.editMenu = findViewById2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String str) {
    }
}
