package com.qzone.reborn.albumx.qzone.vas.widget;

import aa.e;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneAlbumExpirePicItemView;
import com.qzone.reborn.util.m;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.a;
import tl.h;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0014J\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneAlbumExpirePicItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "y0", "", "q0", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "getLayoutId", "objData", c.G, "r0", "Landroid/widget/ImageView;", "x0", "e", "I", "picSize", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundLayout", h.F, "Landroid/widget/ImageView;", "imageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumExpirePicItemView extends QZoneBaseWidgetView<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int picSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final RoundCorneredFrameLayout roundLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumExpirePicItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.picSize = y0();
        View findViewById = findViewById(R.id.n6k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_layout_round_view)");
        this.roundLayout = (RoundCorneredFrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.n3d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_image_view)");
        this.imageView = (ImageView) findViewById2;
    }

    private final void q0() {
        ViewGroup.LayoutParams layoutParams = this.roundLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.picSize;
        }
        ViewGroup.LayoutParams layoutParams2 = this.roundLayout.getLayoutParams();
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.height = this.picSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LoadState loadState, Option option) {
        if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
            return;
        }
        option.getAnimatable().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(final QZoneAlbumExpirePicItemView this$0, final int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(a.class).originView(this$0.imageView).done(new OnPromiseResolved() { // from class: pa.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneAlbumExpirePicItemView.v0(QZoneAlbumExpirePicItemView.this, i3, (l9.a) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: pa.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                QZoneAlbumExpirePicItemView.w0(str);
            }
        }).run();
        fo.c.q(this$0.imageView, "em_qz_picture", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(QZoneAlbumExpirePicItemView this$0, int i3, a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aVar.A8(this$0.getData().getBatchBean(), this$0.getData().getBatchPos(), this$0.getData().f(), i3, this$0.imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(String str) {
        QLog.e("QZoneAlbumExpirePicItemView", 1, "ICommonAlbumDetailClickIoc getIoc error = " + str);
    }

    private final int y0() {
        return (pl.a.f426446a.o(getContext()) - (ImmersiveUtils.dpToPx(15.0f) * 2)) / 3;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chn;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.picSize = y0();
        q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonGridItemData objData, final int pos) {
        q0();
        CommonStPicUrl c16 = e.c(getData().f());
        if (c16 == null) {
            return;
        }
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(c16.getUrl());
        e16.setTargetView(this.imageView);
        m mVar = m.f59551a;
        e16.setLoadingDrawable(mVar.b(this.imageView.getContext()));
        e16.setFailedDrawable(mVar.a(this.imageView.getContext()));
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: pa.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneAlbumExpirePicItemView.s0(loadState, option);
            }
        });
        this.imageView.setOnClickListener(new View.OnClickListener() { // from class: pa.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumExpirePicItemView.u0(QZoneAlbumExpirePicItemView.this, pos, view);
            }
        });
    }

    /* renamed from: x0, reason: from getter */
    public final ImageView getImageView() {
        return this.imageView;
    }
}
