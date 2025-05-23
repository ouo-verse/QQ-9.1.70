package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B\u000f\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZoneAlbumIntimateTabContentView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "x0", "r0", "q0", "o0", "w0", "v0", "", "getLayoutId", NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "albumSpaceInfo", "setAlbumSpaceInfoBean", "objData", com.tencent.luggage.wxa.c8.c.G, "p0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mItemView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "mAlbumPicView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mAlbumPicErrorView", "i", "mAlbumSmallIconView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAlbumCountView", BdhLogUtil.LogTag.Tag_Conn, "mAlbumNameView", "Lnk/r;", "D", "Lnk/r;", "mAlbumViewModel", "E", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "mAlbumInfoBean", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumIntimateTabContentView extends QZoneBaseWidgetView<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mAlbumNameView;

    /* renamed from: D, reason: from kotlin metadata */
    private nk.r mAlbumViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneAlbumInfoBean mAlbumInfoBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView mAlbumPicView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumPicErrorView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumSmallIconView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumCountView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumIntimateTabContentView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mnf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_album_intimate_content)");
        this.mItemView = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.mni);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_album_intimate_pic)");
        this.mAlbumPicView = (RoundCornerImageView) findViewById2;
        View findViewById3 = findViewById(R.id.mnj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_album_intimate_pic_error)");
        this.mAlbumPicErrorView = (ImageView) findViewById3;
        this.mAlbumPicView.setCorner(ar.d(4.0f));
        View findViewById4 = findViewById(R.id.mnk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_album_intimate_small_icon)");
        this.mAlbumSmallIconView = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.mng);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_album_intimate_count)");
        this.mAlbumCountView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.mnh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_album_intimate_name)");
        this.mAlbumNameView = (TextView) findViewById6;
        this.mItemView.setOnClickListener(this);
        this.mAlbumNameView.setOnClickListener(this);
        rn.h.a(this.mAlbumSmallIconView, "qui_image", R.color.qui_common_icon_white);
        rn.h.a(this.mAlbumPicErrorView, "qui_image", R.color.qui_common_icon_tertiary);
    }

    private final void o0() {
        this.mAlbumCountView.setText(String.valueOf(getData().getAlbumInfo().getUploadNumber()));
    }

    private final void q0() {
        this.mAlbumNameView.setText(getData().getAlbumInfo().getName());
    }

    private final void r0() {
        CommonStPicUrl f16 = k9.a.f(getData().getAlbumInfo());
        if (!k9.a.i(f16)) {
            RFWLog.e("QZoneAlbumIntimateTabContentView", RFWLog.USR, "bindPicView stPicUrl is null");
            this.mAlbumPicView.setImageResource(R.drawable.le8);
            this.mAlbumPicErrorView.setVisibility(0);
            return;
        }
        Intrinsics.checkNotNull(f16);
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(f16.getUrl());
        e16.setTargetView(this.mAlbumPicView);
        if (this.mAlbumPicView.getLayoutParams() != null) {
            e16.setRequestWidth(this.mAlbumPicView.getLayoutParams().width);
            e16.setRequestHeight(this.mAlbumPicView.getLayoutParams().height);
        }
        e16.setLoadingDrawable(getResources().getDrawable(R.drawable.le8));
        e16.setFailDrawable(getResources().getDrawable(R.drawable.le8));
        this.mAlbumPicErrorView.setVisibility(8);
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: com.qzone.reborn.intimate.widget.m
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneAlbumIntimateTabContentView.s0(QZoneAlbumIntimateTabContentView.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(final QZoneAlbumIntimateTabContentView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishError() || option == null) {
            return;
        }
        RFWLog.e("QZoneAlbumIntimateTabContentView", RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.intimate.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAlbumIntimateTabContentView.u0(QZoneAlbumIntimateTabContentView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(QZoneAlbumIntimateTabContentView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAlbumPicErrorView.setVisibility(0);
    }

    private final void v0() {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        qZoneIntimateAlbumDetailInitBean.setSpaceId(getData().getAlbumInfo().getOwner());
        qZoneIntimateAlbumDetailInitBean.setAlbumId(getData().getAlbumInfo().getAlbumId());
        QZoneAlbumInfoBean qZoneAlbumInfoBean = this.mAlbumInfoBean;
        if (qZoneAlbumInfoBean != null) {
            qZoneIntimateAlbumDetailInitBean.setSpaceType(qZoneAlbumInfoBean.getAlbumInfo().space_type.get());
            String d16 = mk.h.f416877a.d(qZoneAlbumInfoBean.getAlbumInfo().users.get(), qZoneAlbumInfoBean.getOwnerUin(), qZoneAlbumInfoBean.getCommonExt());
            if (!TextUtils.isEmpty(d16)) {
                Intrinsics.checkNotNull(d16);
                qZoneIntimateAlbumDetailInitBean.setMemberUid(d16);
            }
        }
        ck.c o16 = ho.i.o();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        o16.j(context, qZoneIntimateAlbumDetailInitBean);
    }

    private final void w0() {
        HashMap hashMap = new HashMap();
        hashMap.put("albumid", getData().getAlbumInfo().getAlbumId());
        fo.c.o(this.mItemView, "em_qz_individual_album_item", new fo.b().l(hashMap).i(getData().getAlbumInfo().getAlbumId()));
    }

    private final void x0() {
        if (this.mAlbumViewModel == null) {
            this.mAlbumViewModel = (nk.r) p(nk.r.class);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128493i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int appScreenWidth = (int) ((ScreenUtils.getAppScreenWidth() - ar.e(46.0f)) / 3.5f);
        ViewGroup.LayoutParams layoutParams = this.mAlbumPicView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = appScreenWidth;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mAlbumPicView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = appScreenWidth;
        }
        ViewGroup.LayoutParams layoutParams3 = this.mItemView.getLayoutParams();
        if (layoutParams3 == null) {
            return;
        }
        layoutParams3.width = appScreenWidth;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 == R.id.mnf || id5 == R.id.mnh) {
            v0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonAlbumListBean objData, int pos) {
        x0();
        if (objData != null) {
            r0();
            o0();
            q0();
            w0();
        }
    }

    public final void setAlbumSpaceInfoBean(QZoneAlbumInfoBean albumSpaceInfo) {
        this.mAlbumInfoBean = albumSpaceInfo;
    }
}
