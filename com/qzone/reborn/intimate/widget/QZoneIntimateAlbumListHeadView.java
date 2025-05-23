package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumListHeadView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "p0", "n0", "o0", "", "getLayoutId", "data", com.tencent.luggage.wxa.c8.c.G, "m0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mItemView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mSyncTextView", tl.h.F, "mSyncBtn", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mSyncCloseBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumListHeadView extends QZoneBaseWidgetView<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mSyncTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mSyncBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mSyncCloseBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateAlbumListHeadView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n3l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026ate_album_header_content)");
        this.mItemView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.n47);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_intimate_album_sync_text)");
        this.mSyncTextView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.n3w);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_intimate_album_sync_btn)");
        this.mSyncBtn = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.n3z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_intimate_album_sync_close)");
        this.mSyncCloseBtn = (ImageView) findViewById4;
        this.mItemView.setOnClickListener(this);
        this.mSyncBtn.setOnClickListener(this);
        this.mSyncCloseBtn.setOnClickListener(this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (com.qzone.reborn.util.k.f59549a.f()) {
            this.mItemView.setBackgroundResource(R.drawable.f14297g);
        } else {
            this.mItemView.setBackgroundResource(R.drawable.f14287f);
        }
    }

    private final void n0() {
        qj.g gVar = (qj.g) getIocInterface(qj.g.class);
        if (gVar != null) {
            gVar.E2(false);
        }
        o0();
    }

    private final void o0() {
        qj.b bVar = (qj.b) getIocInterface(qj.b.class);
        if (bVar != null) {
            bVar.W7();
        }
    }

    private final void p0() {
        fo.c.o(this.mItemView, "em_qz_sync_my_spatial_album_popup", null);
        fo.c.o(this.mSyncBtn, "em_qz_sync_album_button", null);
        fo.c.o(this.mSyncCloseBtn, "em_qz_close_popup", null);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ckv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonAlbumListBean data, int pos) {
        p0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 == R.id.n3l || id5 == R.id.n3w) {
            n0();
        } else if (id5 == R.id.n3z) {
            o0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
