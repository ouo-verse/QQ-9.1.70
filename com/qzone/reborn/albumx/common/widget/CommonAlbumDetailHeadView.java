package com.qzone.reborn.albumx.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailHeadView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import ef.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002ghB\u0011\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\ba\u0010bB\u001b\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\ba\u0010eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\nH\u0014J\u0006\u0010\u001a\u001a\u00020\u0019J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0003J)\u0010$\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\"\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u0019\u00a2\u0006\u0004\b$\u0010%J\"\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010'\u001a\u0004\u0018\u00010&J\u0017\u0010)\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00100R\u0014\u0010<\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u00100R\u0014\u0010D\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0014\u0010F\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u00100R\u0014\u0010H\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010?R\u0014\u0010J\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u00100R\u0014\u0010L\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u00100R\u0018\u0010O\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010SR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006i"}, d2 = {"Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Landroid/view/View$OnClickListener;", "", "n0", "w0", "x0", "y0", "u0", "", "lineCount", "", "hasEllipsis", "s0", "Landroid/view/View;", "view", "bottomMargin", "topMargin", "o0", "q0", "getLayoutId", "objData", c.G, "p0", "", "r0", "v", NodeProps.ON_CLICK, "show", "seenOnClickListener", "setSeenInfo", "listener", "setDescMoreClickListener", "text", "lockTokenString", "setNormalUpload", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "setNameLabelIcon", "setNormalUploadFlag", "(Ljava/lang/Boolean;)V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "commonExt", "setCommonExt", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvName", "f", "tvDesc", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "llDesc", "i", "tvDescMore", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "llUserLine", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "ivImageIcon", "D", "tvPicNum", "E", "ivUploadTipsIcon", UserInfo.SEX_FEMALE, "normalUploadTips", "G", "ivSeenIcon", "H", "tvSeenNum", "I", "tvNameLabel", "J", "Ljava/lang/Boolean;", "isNormalUploadFlag", "K", "isShowSeen", "L", "Landroid/view/View$OnClickListener;", "M", "descMoreOnClickListener", "N", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView$b;", "P", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView$b;", "headClickListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "lockToken", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumDetailHeadView extends QZoneBaseWidgetView<CommonAlbumInfo> implements View.OnClickListener {
    private static final int S = d.b(44);
    private static final int T = d.b(12);
    private static final int U = d.b(12);

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView ivImageIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView tvPicNum;

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView ivUploadTipsIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView normalUploadTips;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView ivSeenIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView tvSeenNum;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView tvNameLabel;

    /* renamed from: J, reason: from kotlin metadata */
    private Boolean isNormalUploadFlag;

    /* renamed from: K, reason: from kotlin metadata */
    private Boolean isShowSeen;

    /* renamed from: L, reason: from kotlin metadata */
    private View.OnClickListener seenOnClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    private View.OnClickListener descMoreOnClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: P, reason: from kotlin metadata */
    private b headClickListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private String lockToken;

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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView$b;", "", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void onClick(View v3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAlbumDetailHeadView(Context context) {
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
        View findViewById6 = findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_image_icon)");
        this.ivImageIcon = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.njl);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_pic_num)");
        this.tvPicNum = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.lvu);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.iv_upload_tips_icon)");
        this.ivUploadTipsIcon = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.mhk);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.normal_upload_tips)");
        this.normalUploadTips = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.lr_);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.iv_seen_icon)");
        this.ivSeenIcon = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.njy);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.tv_seen_num)");
        this.tvSeenNum = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.njd);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.tv_name_label)");
        this.tvNameLabel = (TextView) findViewById12;
        Boolean bool = Boolean.FALSE;
        this.isNormalUploadFlag = bool;
        this.isShowSeen = bool;
        this.lockToken = "qui_lock";
        n0();
    }

    private final void n0() {
        this.tvName.setTextColor(getResources().getColor(R.color.qui_common_text_white));
        this.tvDesc.setTextColor(getResources().getColor(R.color.qui_common_text_white));
        this.tvPicNum.setTextColor(getResources().getColor(R.color.qui_common_text_white));
        this.tvSeenNum.setTextColor(getResources().getColor(R.color.qui_common_text_white));
        this.normalUploadTips.setTextColor(getResources().getColor(R.color.qui_common_text_white));
        this.tvDesc.setMaxLines(3);
        rn.h.a(this.ivImageIcon, "qui_copy", R.color.qui_common_text_white);
        rn.h.a(this.ivUploadTipsIcon, this.lockToken, R.color.qui_common_text_white);
        rn.h.a(this.ivSeenIcon, "qui_eye_on", R.color.qui_common_text_white);
    }

    private final void q0() {
        fo.c.o(this.tvDescMore, WinkDaTongReportConstant.ElementId.EM_QZ_MORE_BTN, new fo.b().j(EndExposurePolicy.REPORT_NONE));
    }

    private final void s0(int lineCount, boolean hasEllipsis) {
        RFWLog.i("CommonAlbumDetailHeadView", RFWLog.USR, "[showDescMoreView] lineCount:" + lineCount + ",ellipsis:" + hasEllipsis);
        if (lineCount > 3 || (lineCount == 3 && hasEllipsis)) {
            this.tvDescMore.setVisibility(0);
            this.tvDescMore.setOnClickListener(this.descMoreOnClickListener);
            o0(this.llUserLine, S, T / 2);
            o0(this.llDesc, 0, U / 2);
            return;
        }
        if (lineCount > 0) {
            this.tvDescMore.setVisibility(8);
            o0(this.llUserLine, S, T);
            o0(this.llDesc, 0, U);
        } else {
            this.tvDescMore.setVisibility(8);
            o0(this.llUserLine, S, T);
            o0(this.llDesc, 0, U);
        }
    }

    private final void u0() {
        if ((getData().getDesc().length() > 0) && !Intrinsics.areEqual(getData().getDesc(), " ")) {
            this.tvDesc.setText(getData().getDesc());
            this.tvDesc.setVisibility(0);
        } else {
            if (getData().getDefaultDesc().length() > 0) {
                this.tvDesc.setText(getData().getDefaultDesc());
                this.tvDesc.setVisibility(0);
            } else {
                this.tvDesc.setText("");
                this.tvDesc.setVisibility(8);
            }
        }
        int p16 = ar.p(this.tvDesc);
        if (p16 > 0) {
            s0(p16, false);
        }
        this.tvDesc.post(new Runnable() { // from class: ba.e
            @Override // java.lang.Runnable
            public final void run() {
                CommonAlbumDetailHeadView.v0(CommonAlbumDetailHeadView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(CommonAlbumDetailHeadView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int lineCount = this$0.tvDesc.getLineCount();
        this$0.s0(lineCount, lineCount > 0 && this$0.tvDesc.getLayout() != null && this$0.tvDesc.getLayout().getEllipsisCount(lineCount + (-1)) > 0);
        this$0.q0();
    }

    private final void w0() {
        if (getData() == null) {
            this.ivImageIcon.setVisibility(8);
            this.tvPicNum.setVisibility(8);
        } else {
            this.ivImageIcon.setVisibility(0);
            this.tvPicNum.setVisibility(0);
        }
        this.tvPicNum.setText(String.valueOf(getData().getUploadNumber()));
    }

    private final void x0() {
        if (!Intrinsics.areEqual(this.isShowSeen, Boolean.FALSE) && getData() != null) {
            this.ivSeenIcon.setVisibility(0);
            this.tvSeenNum.setVisibility(0);
            this.tvSeenNum.setText(String.valueOf(getData().getVisitorInfo().getViewNum()));
            this.ivSeenIcon.setOnClickListener(this.seenOnClickListener);
            this.tvSeenNum.setOnClickListener(this.seenOnClickListener);
            return;
        }
        this.ivSeenIcon.setVisibility(8);
        this.tvSeenNum.setVisibility(8);
    }

    private final void y0() {
        this.tvName.setText(getData().getName());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f127380i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        b bVar = this.headClickListener;
        if (bVar != null) {
            bVar.onClick(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final String r0() {
        return this.tvDesc.getText().toString();
    }

    public final void setCommonExt(CommonStCommonExt commonExt) {
        this.commonExt = commonExt;
    }

    public final void setDescMoreClickListener(View.OnClickListener listener) {
        this.descMoreOnClickListener = listener;
    }

    public final void setNormalUpload(Boolean show, String text, String lockTokenString) {
        Intrinsics.checkNotNullParameter(lockTokenString, "lockTokenString");
        setNormalUploadFlag(show);
        if (!(text == null || text.length() == 0)) {
            this.normalUploadTips.setText(text);
        }
        if (lockTokenString.length() == 0) {
            lockTokenString = "qui_lock";
        }
        this.lockToken = lockTokenString;
        n0();
    }

    public final void setNormalUploadFlag(Boolean show) {
        this.isNormalUploadFlag = show;
        if (Intrinsics.areEqual(show, Boolean.FALSE)) {
            this.normalUploadTips.setVisibility(0);
            this.ivUploadTipsIcon.setVisibility(0);
        } else {
            this.normalUploadTips.setVisibility(8);
            this.ivUploadTipsIcon.setVisibility(8);
        }
    }

    public final void setSeenInfo(boolean show, View.OnClickListener seenOnClickListener) {
        this.isShowSeen = Boolean.valueOf(show);
        this.seenOnClickListener = seenOnClickListener;
        x0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonAlbumInfo objData, int pos) {
        if (objData != null) {
            y0();
            u0();
            w0();
            x0();
            n0();
        }
    }

    public final void setNameLabelIcon(boolean show, String text, Drawable bgDrawable) {
        if (show) {
            this.tvNameLabel.setVisibility(0);
            this.tvNameLabel.setText(text);
            this.tvNameLabel.setBackground(bgDrawable);
            return;
        }
        this.tvNameLabel.setVisibility(8);
    }

    private final void o0(View view, int bottomMargin, int topMargin) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = bottomMargin;
            marginLayoutParams.topMargin = topMargin;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAlbumDetailHeadView(Context context, AttributeSet attributeSet) {
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
        View findViewById6 = findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_image_icon)");
        this.ivImageIcon = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.njl);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_pic_num)");
        this.tvPicNum = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.lvu);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.iv_upload_tips_icon)");
        this.ivUploadTipsIcon = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.mhk);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.normal_upload_tips)");
        this.normalUploadTips = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.lr_);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.iv_seen_icon)");
        this.ivSeenIcon = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.njy);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.tv_seen_num)");
        this.tvSeenNum = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.njd);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.tv_name_label)");
        this.tvNameLabel = (TextView) findViewById12;
        Boolean bool = Boolean.FALSE;
        this.isNormalUploadFlag = bool;
        this.isShowSeen = bool;
        this.lockToken = "qui_lock";
        n0();
    }
}
