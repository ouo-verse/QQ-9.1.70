package com.qzone.reborn.albumx.qzone.widgetview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.local.f;
import com.qzone.reborn.albumx.qzone.local.g;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ga.a;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002GHB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u00a2\u0006\u0004\bA\u0010EJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0014J\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R\u0014\u0010(\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006I"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lga/a;", "", "url", "", "w0", "x0", "r0", "q0", "v0", "", "getLayoutId", "data", c.G, "s0", "u0", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mCoverFl", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mCoverBgIv", h.F, "mCoverAnimIv", "i", "mTickIv", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "mTitleArea", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mTitleTv", "D", "mDescEntrance", "E", "mDescTv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBtn", "Landroid/graphics/drawable/Drawable;", "G", "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", "H", "mFailedDrawable", "", "I", "Z", "mHasConfirm", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;", "J", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;", "getMOnViewClickListener", "()Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;", "setMOnViewClickListener", "(Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;)V", "mOnViewClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "K", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoScanAuthorizeWidgetView extends QZoneBaseWidgetView<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView mTitleTv;

    /* renamed from: D, reason: from kotlin metadata */
    private final ImageView mDescEntrance;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView mDescTv;

    /* renamed from: F, reason: from kotlin metadata */
    private final QUIButton mBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private Drawable mLoadingDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable mFailedDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mHasConfirm;

    /* renamed from: J, reason: from kotlin metadata */
    private b mOnViewClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RoundCorneredFrameLayout mCoverFl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView mCoverBgIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView mCoverAnimIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView mTickIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mTitleArea;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;", "", "Landroid/view/View;", "view", "", "hasConfirm", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(View view, boolean hasConfirm);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoScanAuthorizeWidgetView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mpa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026_scan_authrized_cover_fl)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById;
        this.mCoverFl = roundCorneredFrameLayout;
        View findViewById2 = findViewById(R.id.mp_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_\u2026an_authrized_cover_bg_iv)");
        this.mCoverBgIv = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.mp9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_\u2026_authrized_cover_anim_iv)");
        this.mCoverAnimIv = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.mpb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026_scan_authrized_tip_tick)");
        ImageView imageView = (ImageView) findViewById4;
        this.mTickIv = imageView;
        View findViewById5 = findViewById(R.id.mp7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_\u2026ed_content_title_area_ll)");
        this.mTitleArea = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.mp8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_\u2026thrized_content_title_tv)");
        TextView textView = (TextView) findViewById6;
        this.mTitleTv = textView;
        View findViewById7 = findViewById(R.id.mp5);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qzone_\u2026content_desc_entrance_iv)");
        ImageView imageView2 = (ImageView) findViewById7;
        this.mDescEntrance = imageView2;
        View findViewById8 = findViewById(R.id.mp6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qzone_\u2026uthrized_content_desc_tv)");
        TextView textView2 = (TextView) findViewById8;
        this.mDescTv = textView2;
        View findViewById9 = findViewById(R.id.f162801mp4);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.qzone_\u2026an_authrized_content_btn)");
        QUIButton qUIButton = (QUIButton) findViewById9;
        this.mBtn = qUIButton;
        roundCorneredFrameLayout.setRadius(ar.d(8.0f));
        g gVar = g.f52662a;
        textView.setText(gVar.f());
        textView2.setText(gVar.e());
        qUIButton.setText(l.a(R.string.jff));
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: ra.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.o0(QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.this, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ra.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.p0(QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.this, view);
            }
        });
        rn.h.a(imageView, "qui_tick_filled", R.color.qui_common_feedback_success);
        this.mLoadingDrawable = ResourcesCompat.getDrawable(textView2.getResources(), R.drawable.at8, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(textView2.getResources(), R.drawable.at_, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(QZoneAlbumxLocalPhotoScanAuthorizeWidgetView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.mOnViewClickListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.a(it, this$0.mHasConfirm);
        }
        this$0.mHasConfirm = true;
        this$0.v0();
        f fVar = f.f52661a;
        a data = this$0.getData();
        fVar.a(data != null ? data.getFrom() : 0);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QZoneAlbumxLocalPhotoScanAuthorizeWidgetView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() == null) {
            QLog.e("QZoneAlbumxLocalPhotoScanAuthorizeWidgetView", 1, "[onClick] desc click, context is null");
        }
        Context context = this$0.getContext();
        if (context != null) {
            i.y().c(context);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q0() {
        int n3 = pl.a.f426446a.n(getContext());
        ViewGroup.LayoutParams layoutParams = this.mCoverFl.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) ((n3 * 184) / 811.0d);
            layoutParams.height = (int) ((n3 * 174) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mCoverFl.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = layoutParams2 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams3 != null) {
            layoutParams3.topMargin = (int) ((n3 * 20.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams4 = this.mCoverAnimIv.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = (int) ((n3 * 119) / 811.0d);
            layoutParams4.height = (int) ((n3 * 158) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams5 = this.mTitleArea.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams6 = layoutParams5 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.topMargin = (int) ((n3 * 24.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams7 = this.mDescTv.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams8 = layoutParams7 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams7 : null;
        if (layoutParams8 != null) {
            layoutParams8.topMargin = (int) ((n3 * 17.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams9 = this.mBtn.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams10 = layoutParams9 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams9 : null;
        if (layoutParams10 != null) {
            layoutParams10.bottomMargin = (int) ((n3 * 30.0d) / 811.0d);
        }
    }

    private final void r0() {
        int n3 = pl.a.f426446a.n(getContext());
        ViewGroup.LayoutParams layoutParams = this.mCoverFl.getLayoutParams();
        if (layoutParams != null) {
            double d16 = n3;
            layoutParams.width = (int) ((335.0d * d16) / 811.0d);
            layoutParams.height = (int) ((d16 * 317.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mCoverFl.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = layoutParams2 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams3 != null) {
            layoutParams3.topMargin = (int) ((n3 * 85.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams4 = this.mCoverAnimIv.getLayoutParams();
        if (layoutParams4 != null) {
            double d17 = n3;
            layoutParams4.width = (int) ((216.0d * d17) / 811.0d);
            layoutParams4.height = (int) ((d17 * 288.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams5 = this.mTitleArea.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams6 = layoutParams5 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.topMargin = (int) ((n3 * 23.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams7 = this.mDescTv.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams8 = layoutParams7 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams7 : null;
        if (layoutParams8 != null) {
            layoutParams8.topMargin = (int) ((n3 * 17.0d) / 811.0d);
        }
        ViewGroup.LayoutParams layoutParams9 = this.mBtn.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams10 = layoutParams9 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams9 : null;
        if (layoutParams10 != null) {
            layoutParams10.bottomMargin = (int) ((n3 * 54.0d) / 811.0d);
        }
    }

    private final void v0() {
        a data = getData();
        if (data != null && data.getFrom() == 2) {
            this.mCoverBgIv.setVisibility(8);
            this.mCoverAnimIv.setVisibility(8);
            this.mTickIv.setVisibility(0);
            TextView textView = this.mTitleTv;
            g gVar = g.f52662a;
            textView.setText(gVar.h());
            this.mDescEntrance.setVisibility(8);
            this.mBtn.setText(l.a(R.string.jfh));
            this.mDescTv.setText(gVar.g());
        }
    }

    private final void w0(String url) {
        QLog.d("QZoneAlbumxLocalPhotoScanAuthorizeWidgetView", 1, "[loadAnimImage] picUrl = " + url);
        if (url.length() == 0) {
            this.mCoverAnimIv.setVisibility(8);
            return;
        }
        this.mCoverAnimIv.setVisibility(0);
        Option url2 = Option.obtain().setUrl(url);
        url2.setTargetView(this.mCoverAnimIv);
        url2.setRequestWidth(this.mCoverAnimIv.getWidth());
        url2.setRequestHeight(this.mCoverAnimIv.getHeight());
        url2.setLoadingDrawable(this.mLoadingDrawable);
        url2.setFailedDrawable(this.mFailedDrawable);
        com.tencent.mobileqq.qzone.picload.c.a().h(url2);
    }

    private final void x0(String url) {
        QLog.d("QZoneAlbumxLocalPhotoScanAuthorizeWidgetView", 1, "[loadBgImage] picUrl = " + url);
        if (url.length() == 0) {
            this.mCoverBgIv.setVisibility(8);
            return;
        }
        this.mCoverBgIv.setVisibility(0);
        Option url2 = Option.obtain().setUrl(url);
        url2.setTargetView(this.mCoverBgIv);
        url2.setRequestWidth(this.mCoverBgIv.getWidth());
        url2.setRequestHeight(this.mCoverBgIv.getHeight());
        url2.setLoadingDrawable(this.mLoadingDrawable);
        url2.setFailedDrawable(this.mFailedDrawable);
        com.tencent.mobileqq.qzone.picload.c.a().h(url2);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1291258;
    }

    public final void setMOnViewClickListener(b bVar) {
        this.mOnViewClickListener = bVar;
    }

    public final void u0() {
        a data = getData();
        if (data != null) {
            f.f52661a.b(data.getFrom());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void bindData(a data, int pos) {
        if (data == null) {
            QLog.e("QZoneAlbumxLocalPhotoScanAuthorizeWidgetView", 1, "[bindData] data is null");
        }
        if (data != null) {
            int from = data.getFrom();
            if (from == 1) {
                r0();
                this.mDescEntrance.setVisibility(8);
            } else if (from == 2) {
                q0();
                this.mDescEntrance.setVisibility(0);
            }
            x0(data.getCoverPicBgUrl());
            w0(data.getCoverPicAnimUrl());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoScanAuthorizeWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mpa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026_scan_authrized_cover_fl)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById;
        this.mCoverFl = roundCorneredFrameLayout;
        View findViewById2 = findViewById(R.id.mp_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_\u2026an_authrized_cover_bg_iv)");
        this.mCoverBgIv = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.mp9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_\u2026_authrized_cover_anim_iv)");
        this.mCoverAnimIv = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.mpb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026_scan_authrized_tip_tick)");
        ImageView imageView = (ImageView) findViewById4;
        this.mTickIv = imageView;
        View findViewById5 = findViewById(R.id.mp7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_\u2026ed_content_title_area_ll)");
        this.mTitleArea = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.mp8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_\u2026thrized_content_title_tv)");
        TextView textView = (TextView) findViewById6;
        this.mTitleTv = textView;
        View findViewById7 = findViewById(R.id.mp5);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qzone_\u2026content_desc_entrance_iv)");
        ImageView imageView2 = (ImageView) findViewById7;
        this.mDescEntrance = imageView2;
        View findViewById8 = findViewById(R.id.mp6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qzone_\u2026uthrized_content_desc_tv)");
        TextView textView2 = (TextView) findViewById8;
        this.mDescTv = textView2;
        View findViewById9 = findViewById(R.id.f162801mp4);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.qzone_\u2026an_authrized_content_btn)");
        QUIButton qUIButton = (QUIButton) findViewById9;
        this.mBtn = qUIButton;
        roundCorneredFrameLayout.setRadius(ar.d(8.0f));
        g gVar = g.f52662a;
        textView.setText(gVar.f());
        textView2.setText(gVar.e());
        qUIButton.setText(l.a(R.string.jff));
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: ra.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.o0(QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.this, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ra.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.p0(QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.this, view);
            }
        });
        rn.h.a(imageView, "qui_tick_filled", R.color.qui_common_feedback_success);
        this.mLoadingDrawable = ResourcesCompat.getDrawable(textView2.getResources(), R.drawable.at8, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(textView2.getResources(), R.drawable.at_, null);
    }
}
