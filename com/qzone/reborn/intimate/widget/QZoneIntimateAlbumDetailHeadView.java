package com.qzone.reborn.intimate.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.qzonex.bean.QZAlbumxDescDetailInitBean;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.tmassistantbase.util.GlobalUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001JB\u0011\b\u0016\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\bD\u0010EB\u001b\b\u0016\u0012\u0006\u0010C\u001a\u00020B\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u00a2\u0006\u0004\bD\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\bH\u0014J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010,\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010 R\u0014\u00104\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010 R\u0014\u00106\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010 R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010 R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumDetailHeadView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "", "o0", "w0", "A0", "y0", "", "lineCount", "", "hasEllipsis", "u0", "Landroid/view/View;", "view", "bottomMargin", "topMargin", "p0", "r0", "s0", "x0", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "q0", GlobalUtil.DEF_STRING, "setIsBatchListEmpty", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "commonExt", "setCommonExt", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvName", "f", "tvDesc", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "llDesc", "i", "tvDescMore", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "llUserLine", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarUser", "D", "tvUserName", "E", "tvCreateText", UserInfo.SEX_FEMALE, "tvSeparator", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "ivImageIcon", "H", "tvPicNum", "I", "Z", "isBatchListEmpty", "J", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumDetailHeadView extends QZoneBaseWidgetView<CommonAlbumInfo> {
    private static final int L = ef.d.b(44);
    private static final int M = ef.d.b(12);
    private static final int N = ef.d.b(12);

    /* renamed from: C, reason: from kotlin metadata */
    private final QZoneUserAvatarView avatarUser;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView tvUserName;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView tvCreateText;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView tvSeparator;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView ivImageIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView tvPicNum;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isBatchListEmpty;

    /* renamed from: J, reason: from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView tvName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView tvDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout llDesc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView tvDescMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View llUserLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateAlbumDetailHeadView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.njc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_name)");
        this.tvName = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nin);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_desc)");
        this.tvDesc = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f162755mg3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_desc)");
        this.llDesc = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.nio);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_desc_more)");
        this.tvDescMore = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.mgl);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ll_user_line)");
        this.llUserLine = findViewById5;
        View findViewById6 = findViewById(R.id.f19094r);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.avatar_user)");
        this.avatarUser = (QZoneUserAvatarView) findViewById6;
        View findViewById7 = findViewById(R.id.nkr);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_user_name)");
        this.tvUserName = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.nil);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_create_text)");
        this.tvCreateText = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.f162963nk3);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_separator)");
        this.tvSeparator = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.iv_image_icon)");
        this.ivImageIcon = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.njl);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.tv_pic_num)");
        this.tvPicNum = (TextView) findViewById11;
        o0();
    }

    private final void A0() {
        try {
            QZoneUserAvatarView qZoneUserAvatarView = this.avatarUser;
            mk.h hVar = mk.h.f416877a;
            String uid = getData().getCreator().getUid();
            CommonStCommonExt commonStCommonExt = this.commonExt;
            qZoneUserAvatarView.setUser(hVar.f(uid, commonStCommonExt != null ? mj.a.h(commonStCommonExt) : null));
        } catch (NumberFormatException e16) {
            QLog.e("QZoneIntimateAlbumDetailHeadView", 1, "updateUserData e = " + e16);
        }
        this.tvUserName.setText(getData().getCreator().getNick());
    }

    private final void o0() {
        if (this.isBatchListEmpty) {
            this.tvName.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
            this.tvDesc.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
            this.tvUserName.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            this.tvCreateText.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            this.tvSeparator.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            this.tvPicNum.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            rn.h.a(this.ivImageIcon, "qui_image", R.color.qui_common_icon_secondary);
            return;
        }
        this.tvName.setTextColor(getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.tvDesc.setTextColor(getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.tvUserName.setTextColor(getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.tvCreateText.setTextColor(getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.tvSeparator.setTextColor(getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.tvPicNum.setTextColor(getResources().getColor(R.color.qui_common_text_allwhite_primary));
        rn.h.a(this.ivImageIcon, "qui_image", R.color.qui_common_text_allwhite_primary);
    }

    private final void r0() {
        fo.c.o(this.tvDescMore, WinkDaTongReportConstant.ElementId.EM_QZ_MORE_BTN, new fo.b().j(EndExposurePolicy.REPORT_NONE));
    }

    private final void s0() {
        vb.b x16 = ho.i.x();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        String owner = getData().getOwner();
        String a16 = com.qzone.util.l.a(R.string.f133957i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_album_desc_text)");
        x16.a(hostActivity, new QZAlbumxDescDetailInitBean(owner, a16, this.tvDesc.getText().toString()));
    }

    private final void u0(int lineCount, boolean hasEllipsis) {
        RFWLog.i("QZoneIntimateAlbumDetailHeadView", RFWLog.USR, "[showDescMoreView] lineCount:" + lineCount + ",ellipsis:" + hasEllipsis);
        if (lineCount > 3 || (lineCount == 3 && hasEllipsis)) {
            this.tvDescMore.setVisibility(0);
            this.tvDescMore.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneIntimateAlbumDetailHeadView.v0(QZoneIntimateAlbumDetailHeadView.this, view);
                }
            });
            p0(this.llUserLine, L, M / 2);
            p0(this.llDesc, 0, N / 2);
            return;
        }
        if (lineCount > 0) {
            this.tvDescMore.setVisibility(8);
            p0(this.llUserLine, L, M);
            p0(this.llDesc, 0, N);
        } else {
            this.tvDescMore.setVisibility(8);
            p0(this.llUserLine, L, M);
            p0(this.llDesc, 0, N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(QZoneIntimateAlbumDetailHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w0() {
        this.tvPicNum.setText(String.valueOf(getData().getUploadNumber()));
    }

    private final void x0() {
        if (this.isBatchListEmpty) {
            this.tvName.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.tvDesc.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.tvUserName.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.tvCreateText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.tvSeparator.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.tvPicNum.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            return;
        }
        this.tvName.setShadowLayer(6.0f, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
        this.tvDesc.setShadowLayer(6.0f, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
        this.tvUserName.setShadowLayer(6.0f, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
        this.tvCreateText.setShadowLayer(6.0f, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
        this.tvSeparator.setShadowLayer(6.0f, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
        this.tvPicNum.setShadowLayer(6.0f, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
    }

    private final void y0() {
        this.tvName.setText(getData().getName());
        this.tvDesc.setMaxLines(3);
        if (getData().getDesc().length() > 0) {
            this.tvDesc.setText(getData().getDesc());
            this.tvDesc.setVisibility(0);
        } else {
            this.tvDesc.setVisibility(8);
        }
        int p16 = ar.p(this.tvDesc);
        if (p16 > 0) {
            u0(p16, false);
        }
        this.tvDesc.post(new Runnable() { // from class: com.qzone.reborn.intimate.widget.o
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateAlbumDetailHeadView.z0(QZoneIntimateAlbumDetailHeadView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(QZoneIntimateAlbumDetailHeadView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int lineCount = this$0.tvDesc.getLineCount();
        this$0.u0(lineCount, lineCount > 0 && this$0.tvDesc.getLayout() != null && this$0.tvDesc.getLayout().getEllipsisCount(lineCount + (-1)) > 0);
        this$0.r0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cix;
    }

    public final void setCommonExt(CommonStCommonExt commonExt) {
        this.commonExt = commonExt;
    }

    public final void setIsBatchListEmpty(boolean empty) {
        this.isBatchListEmpty = empty;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonAlbumInfo objData, int pos) {
        if (objData != null) {
            y0();
            A0();
            w0();
            o0();
            x0();
        }
    }

    private final void p0(View view, int bottomMargin, int topMargin) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = bottomMargin;
            marginLayoutParams.topMargin = topMargin;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateAlbumDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.njc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_name)");
        this.tvName = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nin);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_desc)");
        this.tvDesc = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f162755mg3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_desc)");
        this.llDesc = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.nio);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_desc_more)");
        this.tvDescMore = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.mgl);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ll_user_line)");
        this.llUserLine = findViewById5;
        View findViewById6 = findViewById(R.id.f19094r);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.avatar_user)");
        this.avatarUser = (QZoneUserAvatarView) findViewById6;
        View findViewById7 = findViewById(R.id.nkr);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_user_name)");
        this.tvUserName = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.nil);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_create_text)");
        this.tvCreateText = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.f162963nk3);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_separator)");
        this.tvSeparator = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.iv_image_icon)");
        this.ivImageIcon = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.njl);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.tv_pic_num)");
        this.tvPicNum = (TextView) findViewById11;
        o0();
    }
}
