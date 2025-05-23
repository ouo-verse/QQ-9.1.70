package com.qzone.reborn.message.section;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import bl.CommonNoticeBean;
import bl.CommonStRichMsg;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TailTimeTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.message.data.QZonePassiveMessageFeedPreprocessor;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u0004*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\f\u0010\r\u001a\u00020\f*\u00020\u0002H\u0002J\u001c\u0010\u0012\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H\u0002J\"\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0016J*\u0010(\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020#2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0014R\u0018\u0010+\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010=R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010?\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/message/section/ap;", "Lcom/qzone/reborn/message/section/y;", "Lbl/f;", UinConfigManager.KEY_ADS, "", "K", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "Lcom/qzone/publish/ui/model/QzoneSuperPersonalFontData$SuperFontInfo;", "superFontInfo", "Lcom/qzone/publish/ui/model/QzoneBarrageEffectData$BarrageEffectInfo;", "barrageInfo", "G", "", "N", "", "text", "", "timeStr", BdhLogUtil.LogTag.Tag_Req, "H", "J", "M", "Lbl/a;", "L", "richTextView", "isImp", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "attached", "onAttachedChanged", "data", "", "position", "", "", "payload", "O", "i", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "messageRichText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "settingGuideText", BdhLogUtil.LogTag.Tag_Conn, "textBaseLine", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "timeTextView", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", UserInfo.SEX_FEMALE, "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "onSettingsUrlClick", "Ldl/f;", "Ldl/f;", "pageReportIoc", "Z", "needReportSetting", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ap extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneRichTextView textBaseLine;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView iconImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView timeTextView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextCellLayout.OnCellClickListener onSettingsUrlClick;

    /* renamed from: G, reason: from kotlin metadata */
    private dl.f pageReportIoc;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needReportSetting = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView messageRichText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView settingGuideText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/message/section/ap$b", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "textCell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TextCellLayout.OnCellClickListener {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            boolean endsWith$default;
            if (!(view instanceof QZoneRichTextView)) {
                RFWLog.e("QZonePassiveMessageTextContentSection", RFWLog.USR, "[onSettingsUrlClick] view is not a QZoneRichTextView");
                return;
            }
            if (textCell instanceof UrlCell) {
                String str = ((UrlCell) textCell).text;
                Intrinsics.checkNotNullExpressionValue(str, "textCell.text");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, "\u8bbe\u7f6e", false, 2, null);
                if (endsWith$default) {
                    gl.b.g(gl.b.f402374a, view, "em_qz_set_button", (CommonNoticeBean) ((Section) ap.this).mData, null, 8, null);
                }
            }
            ((QZoneRichTextView) view).k(textCell);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            return false;
        }
    }

    private final void H(bl.f notice) {
        if (notice.getNoticeMessageIcon().getIconResId() != 0) {
            ImageView imageView = this.iconImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            Drawable drawable = ResourcesCompat.getDrawable(p().getResources(), notice.getNoticeMessageIcon().getIconResId(), null);
            if (drawable != null) {
                ImageView imageView2 = this.iconImageView;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(drawable);
                }
                com.tencent.mobileqq.qzone.picload.c.a().m(this.iconImageView, p().getResources().getColor(R.color.qui_common_icon_primary, null));
                return;
            }
            RFWLog.e("QZonePassiveMessageTextContentSection", RFWLog.USR, "[updateLikeIcon] icon drawable is invalid.");
            ImageView imageView3 = this.iconImageView;
            if (imageView3 == null) {
                return;
            }
            imageView3.setVisibility(8);
            return;
        }
        if (notice.getNoticeMessageIcon().getIconToken().length() > 0) {
            ImageView imageView4 = this.iconImageView;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            rn.h.a(this.iconImageView, notice.getNoticeMessageIcon().getIconToken(), R.color.qui_common_icon_primary);
            return;
        }
        ImageView imageView5 = this.iconImageView;
        if (imageView5 == null) {
            return;
        }
        imageView5.setVisibility(8);
    }

    private final void J(bl.f notice) {
        if (N(notice)) {
            TextView textView = this.timeTextView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.timeTextView;
            if (textView2 == null) {
                return;
            }
            textView2.setText(gl.a.c(gl.a.f402373a, notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String(), null, 2, null));
            return;
        }
        TextView textView3 = this.timeTextView;
        if (textView3 == null) {
            return;
        }
        textView3.setVisibility(8);
    }

    private final void L(CommonNoticeBean notice) {
        Object obj = notice.getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (businessFeedData == null) {
            return;
        }
        boolean N = N(notice.getNotice());
        Q(this.messageRichText, com.qzone.reborn.message.data.f.f58260a.f(businessFeedData) && !N, notice);
        Q(this.settingGuideText, N, notice);
    }

    private final void M() {
        this.onSettingsUrlClick = new b();
    }

    private final boolean N(bl.f fVar) {
        com.qzone.reborn.message.data.f fVar2 = com.qzone.reborn.message.data.f.f58260a;
        Object obj = fVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        return fVar2.e((BusinessFeedData) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List P(ap this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.feedx.widget.b.a(list, this$0.p().getResources().getColor(R.color.qui_common_text_primary, null));
        return com.qzone.reborn.feedx.widget.b.d(list, this$0.p().getResources().getColor(R.color.qui_common_text_secondary, null), true);
    }

    private final void R(QZoneRichTextView qZoneRichTextView, CharSequence charSequence, String str) {
        boolean isBlank;
        Object lastOrNull;
        boolean endsWith$default;
        isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
        if (!isBlank) {
            charSequence = ((Object) charSequence) + "  ";
        }
        TailTimeTextCell tailTimeTextCell = new TailTimeTextCell(0, str);
        tailTimeTextCell.setFontSize(qZoneRichTextView.getPaint(), com.qzone.reborn.util.r.f59560a.d(Float.valueOf(12.0f)));
        tailTimeTextCell.setLinkColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_secondary, null));
        ArrayList<TextCell> parsedTextCells = qZoneRichTextView.parseContent(charSequence, true);
        Intrinsics.checkNotNullExpressionValue(parsedTextCells, "parsedTextCells");
        for (TextCell textCell : parsedTextCells) {
            if (textCell instanceof UrlCell) {
                String str2 = textCell.text;
                Intrinsics.checkNotNullExpressionValue(str2, "textCell.text");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, "\u8bbe\u7f6e", false, 2, null);
                if (endsWith$default) {
                    ((UrlCell) textCell).setInnerCanBreak(false);
                }
            }
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) parsedTextCells);
        if (lastOrNull instanceof TailTimeTextCell) {
            CollectionsKt__MutableCollectionsKt.removeLastOrNull(parsedTextCells);
        }
        parsedTextCells.add(tailTimeTextCell);
        qZoneRichTextView.setTextCells(parsedTextCells);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            return;
        }
        this.needReportSetting = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.messageRichText = (QZoneRichTextView) containerView.findViewById(R.id.n7r);
        this.textBaseLine = (QZoneRichTextView) containerView.findViewById(R.id.n75);
        this.iconImageView = (ImageView) containerView.findViewById(R.id.n7t);
        this.timeTextView = (TextView) containerView.findViewById(R.id.nbi);
        this.timeTextView = (TextView) containerView.findViewById(R.id.nbi);
        this.settingGuideText = (QZoneRichTextView) containerView.findViewById(R.id.n7p);
        QZoneRichTextView qZoneRichTextView = this.messageRichText;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(getSpaceClickListener());
        }
        QZoneRichTextView qZoneRichTextView2 = this.messageRichText;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setOnLongClickListener(getLongClickListener());
        }
        ImageView imageView = this.iconImageView;
        if (imageView != null) {
            imageView.setOnClickListener(getSpaceClickListener());
        }
        M();
        int color = ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null);
        QZoneRichTextView qZoneRichTextView3 = this.settingGuideText;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setTextColorLink(color);
        }
        QZoneRichTextView qZoneRichTextView4 = this.messageRichText;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setTextColorLink(color);
        }
        CellTextView.d dVar = new CellTextView.d() { // from class: com.qzone.reborn.message.section.ao
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List P;
                P = ap.P(ap.this, list);
                return P;
            }
        };
        QZoneRichTextView qZoneRichTextView5 = this.messageRichText;
        if (qZoneRichTextView5 != null) {
            qZoneRichTextView5.setPreDecorateListener(dVar);
        }
        QZoneRichTextView qZoneRichTextView6 = this.settingGuideText;
        if (qZoneRichTextView6 != null) {
            qZoneRichTextView6.setPreDecorateListener(dVar);
        }
    }

    private final void G(QZoneRichTextView qZoneRichTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        qZoneRichTextView.setMaxLine(-1);
        QZoneFeedxViewUtils.j(qZoneRichTextView, null);
        qZoneRichTextView.setTextColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_primary, null));
        qZoneRichTextView.setTextColorLink(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null));
        qZoneRichTextView.setBarrageEffect(barrageEffectInfo != null, barrageEffectInfo);
        QZoneFeedxViewUtils.j(qZoneRichTextView, superFontInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n8o};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(bl.f notice) {
        int collectionSizeOrDefault;
        String str;
        CharSequence trimStart;
        String removeSuffix;
        CellSummary cellSummaryV2;
        CellSummary cellSummaryV22;
        CellFeedCommInfo feedCommInfo;
        ll.a aVar = ll.a.f414984a;
        List<CommonStRichMsg> h16 = notice.h();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = h16.iterator();
        while (it.hasNext()) {
            arrayList.add(com.qzone.reborn.message.data.e.B((CommonStRichMsg) it.next()));
        }
        String c16 = aVar.c(arrayList, com.qzone.reborn.message.data.e.A(((CommonNoticeBean) this.mData).getCommonExt()));
        ImageView imageView = this.iconImageView;
        if (imageView != null && imageView.getVisibility() == 8) {
            str = c16;
        } else {
            str = "     " + c16;
        }
        Object obj = notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        int i3 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        String nick = notice.getOpUser().getNick();
        Integer valueOf = (businessFeedData == null || (feedCommInfo = businessFeedData.getFeedCommInfo()) == null) ? null : Integer.valueOf(feedCommInfo.appid);
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        objArr[0] = "nickname: " + nick + ", appid: " + valueOf + ", summary: " + c16 + ", isCommentOrReply: [" + fVar.l(businessFeedData) + ", " + fVar.t(businessFeedData) + "] isLike: " + fVar.C(businessFeedData) + ", highFive: [" + fVar.x(businessFeedData) + ", " + fVar.u(businessFeedData) + "]";
        RFWLog.d("QZonePassiveMessageTextContentSection", i3, objArr);
        QZoneRichTextView qZoneRichTextView = this.messageRichText;
        if (qZoneRichTextView != null) {
            G(qZoneRichTextView, (businessFeedData == null || (cellSummaryV22 = businessFeedData.getCellSummaryV2()) == null) ? null : cellSummaryV22.superFontInfo, (businessFeedData == null || (cellSummaryV2 = businessFeedData.getCellSummaryV2()) == null) ? null : cellSummaryV2.barrageEffectInfo);
        }
        if (N(notice)) {
            QZoneRichTextView qZoneRichTextView2 = this.textBaseLine;
            if (qZoneRichTextView2 != null) {
                qZoneRichTextView2.setLineSpace(com.qzone.reborn.util.r.f59560a.e(2));
            }
            QZoneRichTextView qZoneRichTextView3 = this.messageRichText;
            if (qZoneRichTextView3 != null) {
                qZoneRichTextView3.setLineSpace(com.qzone.reborn.util.r.f59560a.e(2));
            }
            QZoneRichTextView qZoneRichTextView4 = this.settingGuideText;
            if (qZoneRichTextView4 != null) {
                qZoneRichTextView4.setVisibility(0);
            }
            QZonePassiveMessageFeedPreprocessor qZonePassiveMessageFeedPreprocessor = QZonePassiveMessageFeedPreprocessor.f58250a;
            String s16 = qZonePassiveMessageFeedPreprocessor.s(qZonePassiveMessageFeedPreprocessor.c(businessFeedData != null ? businessFeedData.getCellSummaryV2() : null));
            QZoneRichTextView qZoneRichTextView5 = this.messageRichText;
            if (qZoneRichTextView5 != null) {
                removeSuffix = StringsKt__StringsKt.removeSuffix(str, (CharSequence) s16);
                qZoneRichTextView5.setRichText(removeSuffix);
            }
            QZoneRichTextView qZoneRichTextView6 = this.settingGuideText;
            if (qZoneRichTextView6 != null) {
                trimStart = StringsKt__StringsKt.trimStart((CharSequence) s16);
                qZoneRichTextView6.setRichText(trimStart.toString());
                return;
            }
            return;
        }
        QZoneRichTextView qZoneRichTextView7 = this.textBaseLine;
        if (qZoneRichTextView7 != null) {
            qZoneRichTextView7.setLineSpace(com.qzone.reborn.util.r.f59560a.e(5));
        }
        QZoneRichTextView qZoneRichTextView8 = this.messageRichText;
        if (qZoneRichTextView8 != null) {
            qZoneRichTextView8.setLineSpace(com.qzone.reborn.util.r.f59560a.e(5));
        }
        QZoneRichTextView qZoneRichTextView9 = this.settingGuideText;
        if (qZoneRichTextView9 != null) {
            qZoneRichTextView9.setVisibility(8);
        }
        String c17 = gl.a.c(gl.a.f402373a, notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String(), null, 2, null);
        QZoneRichTextView qZoneRichTextView10 = this.messageRichText;
        if (qZoneRichTextView10 != null) {
            R(qZoneRichTextView10, str, c17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            H(data.getNotice());
            K(data.getNotice());
            J(data.getNotice());
            L(data);
        }
    }

    private final void Q(QZoneRichTextView richTextView, boolean isImp, CommonNoticeBean notice) {
        if (!isImp) {
            if (richTextView != null) {
                richTextView.setOnCellClickListener(null);
                return;
            }
            return;
        }
        if (this.needReportSetting) {
            dl.f fVar = this.pageReportIoc;
            if (fVar == null) {
                fVar = (dl.f) q(dl.f.class);
            }
            this.pageReportIoc = fVar;
            gl.b.f402374a.h(richTextView, "em_qz_set_button", notice, (r13 & 8) != 0 ? null : fVar != null ? fVar.O1() : null, (r13 & 16) != 0 ? null : null);
            this.needReportSetting = false;
        }
        if (richTextView != null) {
            richTextView.setOnCellClickListener(this.onSettingsUrlClick);
        }
    }
}
