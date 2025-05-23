package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageStyle;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.b;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 A2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002BCB\u000f\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J.\u0010\u0019\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016R$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0!j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R6\u0010/\u001a\u0016\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0006\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R0\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R6\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0006\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010*\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/b;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/b$b;", "", "messages", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "messageType", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "messageTypeStatus", "y", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "u", "holder", "position", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "", "", "payloads", "t", "getCustomItemViewType", "getItemCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "messageList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "messageTypeToStatus", "Lkotlin/Function2;", "Lzf2/a;", "Lzf2/e;", "f", "Lkotlin/jvm/functions/Function2;", "r", "()Lkotlin/jvm/functions/Function2;", HippyTKDListViewAdapter.X, "(Lkotlin/jvm/functions/Function2;)V", "onMsgOperationClickListener", "Lkotlin/Function1;", tl.h.F, "Lkotlin/jvm/functions/Function1;", "getOnMessageCardExposure", "()Lkotlin/jvm/functions/Function1;", "w", "(Lkotlin/jvm/functions/Function1;)V", "onMessageCardExposure", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "onMessageCardClick", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends BaseAdapter<MessageItem, C8311b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<MessageItem> messageList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> messageTypeToStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2<? super zf2.a, ? super zf2.e, Unit> onMsgOperationClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<? super MessageItem, Unit> onMessageCardExposure;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function2<? super MessageItem, ? super Boolean, Unit> onMessageCardClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\f\u0010\f\u001a\u00020\u000b*\u00020\u0002H\u0002J\f\u0010\r\u001a\u00020\u000b*\u00020\u0002H\u0002J\f\u0010\u000e\u001a\u00020\u000b*\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010$\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010&\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010.\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\u0019R\u0014\u00100\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010 R\u0014\u00102\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010 R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010\u0019R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/b$b;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "messageItem", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", DomainData.DOMAIN_NAME, "o", "e", "", "", "payloads", "r", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "cardView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "receiveTimeText", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "cardContainer", "Lcom/tencent/image/URLImageView;", tl.h.F, "Lcom/tencent/image/URLImageView;", "moduleIconView", "i", "moduleNameText", "platformNameText", BdhLogUtil.LogTag.Tag_Conn, "refuseText", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "operationIconView", "E", "titleText", UserInfo.SEX_FEMALE, "contentText", "G", "bigCoverView", "H", "smallCoverView", "Landroid/widget/RelativeLayout;", "I", "Landroid/widget/RelativeLayout;", "detailContainer", "J", "detailText", "Landroid/view/View;", "K", "Landroid/view/View;", "headerAndContentDivider", "L", "contentAndDetailDivider", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/b;Landroid/view/ViewGroup;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public final class C8311b extends BaseViewHolder<MessageItem> {

        /* renamed from: C, reason: from kotlin metadata */
        private final TextView refuseText;

        /* renamed from: D, reason: from kotlin metadata */
        private final ImageView operationIconView;

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView titleText;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView contentText;

        /* renamed from: G, reason: from kotlin metadata */
        private final URLImageView bigCoverView;

        /* renamed from: H, reason: from kotlin metadata */
        private final URLImageView smallCoverView;

        /* renamed from: I, reason: from kotlin metadata */
        private final RelativeLayout detailContainer;

        /* renamed from: J, reason: from kotlin metadata */
        private final TextView detailText;

        /* renamed from: K, reason: from kotlin metadata */
        private final View headerAndContentDivider;

        /* renamed from: L, reason: from kotlin metadata */
        private final View contentAndDetailDivider;
        final /* synthetic */ b M;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ViewGroup cardView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final TextView receiveTimeText;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final LinearLayout cardContainer;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final URLImageView moduleIconView;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final TextView moduleNameText;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final TextView platformNameText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8311b(b bVar, ViewGroup cardView) {
            super(cardView);
            Intrinsics.checkNotNullParameter(cardView, "cardView");
            this.M = bVar;
            this.cardView = cardView;
            View findViewById = cardView.findViewById(R.id.ogt);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.receive_time_text)");
            this.receiveTimeText = (TextView) findViewById;
            View findViewById2 = cardView.findViewById(R.id.f163130og4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.card_item_container)");
            this.cardContainer = (LinearLayout) findViewById2;
            View findViewById3 = cardView.findViewById(R.id.ogi);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.module_icon_view)");
            this.moduleIconView = (URLImageView) findViewById3;
            View findViewById4 = cardView.findViewById(R.id.ogj);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.module_name_text)");
            this.moduleNameText = (TextView) findViewById4;
            View findViewById5 = cardView.findViewById(R.id.ogn);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.platform_name_text)");
            this.platformNameText = (TextView) findViewById5;
            View findViewById6 = cardView.findViewById(R.id.ogw);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.refuse_text)");
            this.refuseText = (TextView) findViewById6;
            View findViewById7 = cardView.findViewById(R.id.ogm);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.operation_icon_view)");
            this.operationIconView = (ImageView) findViewById7;
            View findViewById8 = cardView.findViewById(R.id.ogz);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.title_text_view)");
            this.titleText = (TextView) findViewById8;
            View findViewById9 = cardView.findViewById(R.id.og8);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.content_text_view)");
            this.contentText = (TextView) findViewById9;
            View findViewById10 = cardView.findViewById(R.id.f163128og2);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.big_cover_view)");
            this.bigCoverView = (URLImageView) findViewById10;
            View findViewById11 = cardView.findViewById(R.id.ogx);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.small_cover_view)");
            this.smallCoverView = (URLImageView) findViewById11;
            View findViewById12 = cardView.findViewById(R.id.og_);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.detail_container)");
            this.detailContainer = (RelativeLayout) findViewById12;
            View findViewById13 = cardView.findViewById(R.id.ogb);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.detail_text)");
            this.detailText = (TextView) findViewById13;
            View findViewById14 = cardView.findViewById(R.id.oge);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.header_and_content_divider_view)");
            this.headerAndContentDivider = findViewById14;
            View findViewById15 = cardView.findViewById(R.id.og7);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.content_and_detail_divider_view)");
            this.contentAndDetailDivider = findViewById15;
        }

        private final void f(MessageItem messageItem) {
            boolean isBlank;
            boolean isBlank2;
            isBlank = StringsKt__StringsJVMKt.isBlank(messageItem.getTitle());
            if (!isBlank) {
                this.titleText.setVisibility(0);
                this.titleText.setText(messageItem.getTitle());
            } else {
                this.titleText.setVisibility(8);
            }
            isBlank2 = StringsKt__StringsJVMKt.isBlank(messageItem.getContent());
            if (!isBlank2) {
                this.contentText.setVisibility(0);
                this.contentText.setText(messageItem.getContent());
                this.contentText.setMaxLines(p(messageItem) ? 2 : 3);
            } else {
                this.contentText.setVisibility(8);
            }
            if (n(messageItem)) {
                this.bigCoverView.setVisibility(0);
                this.bigCoverView.setBackgroundURL(messageItem.getImageUrl());
            } else {
                this.bigCoverView.setVisibility(8);
            }
            if (p(messageItem)) {
                this.smallCoverView.setVisibility(0);
                this.smallCoverView.setBackgroundURL(messageItem.getImageUrl());
            } else {
                this.smallCoverView.setVisibility(8);
            }
        }

        private final void g(final MessageItem messageItem) {
            if (o(messageItem)) {
                this.detailContainer.setVisibility(0);
                this.cardContainer.setClickable(true);
                LinearLayout linearLayout = this.cardContainer;
                final b bVar = this.M;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.C8311b.h(b.this, messageItem, view);
                    }
                });
                return;
            }
            this.cardContainer.setClickable(false);
            this.detailContainer.setVisibility(8);
            LinearLayout linearLayout2 = this.cardContainer;
            final b bVar2 = this.M;
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C8311b.i(b.this, messageItem, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(b this$0, MessageItem messageItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(messageItem, "$messageItem");
            Function2<MessageItem, Boolean, Unit> q16 = this$0.q();
            if (q16 != null) {
                q16.invoke(messageItem, Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(b this$0, MessageItem messageItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(messageItem, "$messageItem");
            Function2<MessageItem, Boolean, Unit> q16 = this$0.q();
            if (q16 != null) {
                q16.invoke(messageItem, Boolean.FALSE);
            }
        }

        private final void j(MessageItem messageItem) {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(messageItem.getModuleIconUrl());
            if (!isBlank) {
                this.moduleIconView.setBackgroundURL(messageItem.getModuleIconUrl());
            }
            this.moduleNameText.setText(messageItem.getType().getText());
            this.platformNameText.setText(messageItem.getPlatformName());
        }

        private final void k(final MessageItem messageItem) {
            if (this.M.messageTypeToStatus.get(messageItem.getType()) instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f) {
                this.refuseText.setVisibility(0);
            } else {
                this.refuseText.setVisibility(8);
            }
            ImageView imageView = this.operationIconView;
            final b bVar = this.M;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C8311b.l(b.this, messageItem, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(b this$0, MessageItem messageItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(messageItem, "$messageItem");
            Function2<zf2.a, zf2.e, Unit> r16 = this$0.r();
            if (r16 != null) {
                zf2.a aVar = new zf2.a(messageItem.getId());
                MessageType type = messageItem.getType();
                com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e eVar = (com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e) this$0.messageTypeToStatus.get(messageItem.getType());
                if (eVar == null) {
                    eVar = com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.d.b();
                }
                Intrinsics.checkNotNullExpressionValue(eVar, "messageTypeToStatus[mess\u2026FAULT_MESSAGE_TYPE_STATUS");
                r16.invoke(aVar, new zf2.e(type, eVar));
            }
        }

        private final void m(MessageItem messageItem) {
            if (messageItem.getReceiveTimestamp() <= 0) {
                this.receiveTimeText.setVisibility(8);
                return;
            }
            this.receiveTimeText.setVisibility(0);
            TextView textView = this.receiveTimeText;
            textView.setText(en.t(textView.getContext(), messageItem.getReceiveTimestamp()));
        }

        private final boolean n(MessageItem messageItem) {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(messageItem.getImageUrl());
            return (isBlank ^ true) && messageItem.getStyle() == MessageStyle.TEXT_URL_BIG_PIC;
        }

        private final boolean o(MessageItem messageItem) {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(messageItem.getJumpUrl());
            return (isBlank ^ true) && messageItem.getStyle() != MessageStyle.TEXT;
        }

        private final boolean p(MessageItem messageItem) {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(messageItem.getImageUrl());
            return (isBlank ^ true) && messageItem.getStyle() == MessageStyle.TEXT_URL_SMALL_PIC;
        }

        private final void q() {
            String str;
            String str2;
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(ECRuntimeManager.INSTANCE.b(), false, null);
            int i3 = isNowThemeIsNight ? -1 : -16777216;
            if (isNowThemeIsNight) {
                str = "#33FFFFFF";
            } else {
                str = "#E6E6E6";
            }
            int parseColor = Color.parseColor(str);
            this.cardContainer.setBackground(ContextCompat.getDrawable(getContext(), isNowThemeIsNight ? R.drawable.f159727ew2 : R.drawable.f159726ew1));
            this.titleText.setTextColor(i3);
            this.contentText.setTextColor(i3);
            this.detailText.setTextColor(i3);
            int i16 = isNowThemeIsNight ? R.drawable.f159729ew4 : R.drawable.f159728ew3;
            if (isNowThemeIsNight) {
                str2 = "#8CFFFFFF";
            } else {
                str2 = "#999999";
            }
            int parseColor2 = Color.parseColor(str2);
            this.refuseText.setBackground(ContextCompat.getDrawable(getContext(), i16));
            this.refuseText.setTextColor(parseColor2);
            this.headerAndContentDivider.setBackgroundColor(parseColor);
            this.contentAndDetailDivider.setBackgroundColor(parseColor);
        }

        public final void e(MessageItem messageItem) {
            Intrinsics.checkNotNullParameter(messageItem, "messageItem");
            m(messageItem);
            j(messageItem);
            k(messageItem);
            f(messageItem);
            g(messageItem);
            q();
        }

        public final void r(MessageItem messageItem, List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(messageItem, "messageItem");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            for (Object obj : payloads) {
                if ((obj instanceof String) && Intrinsics.areEqual(obj, "refuse_view")) {
                    k(messageItem);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageList = new ArrayList<>();
        this.messageTypeToStatus = new HashMap<>();
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int position) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.messageList.size();
    }

    public final Function2<MessageItem, Boolean, Unit> q() {
        return this.onMessageCardClick;
    }

    public final Function2<zf2.a, zf2.e, Unit> r() {
        return this.onMsgOperationClickListener;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(C8311b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MessageItem it = this.messageList.get(position);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        holder.e(it);
        Function1<? super MessageItem, Unit> function1 = this.onMessageCardExposure;
        if (function1 != null) {
            function1.invoke(it);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder<MessageItem> holder, int position, List<Object> payloads) {
        List<? extends Object> list;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (payloads != null && !payloads.isEmpty() && (holder instanceof C8311b)) {
            MessageItem messageItem = this.messageList.get(position);
            Intrinsics.checkNotNullExpressionValue(messageItem, "messageList[position]");
            list = CollectionsKt___CollectionsKt.toList(payloads);
            ((C8311b) holder).r(messageItem, list);
            return;
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C8311b onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cvk, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return new C8311b(this, (ViewGroup) inflate);
    }

    public final void v(Function2<? super MessageItem, ? super Boolean, Unit> function2) {
        this.onMessageCardClick = function2;
    }

    public final void w(Function1<? super MessageItem, Unit> function1) {
        this.onMessageCardExposure = function1;
    }

    public final void x(Function2<? super zf2.a, ? super zf2.e, Unit> function2) {
        this.onMsgOperationClickListener = function2;
    }

    public final void y(MessageType messageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e messageTypeStatus) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(messageTypeStatus, "messageTypeStatus");
        if (Intrinsics.areEqual(this.messageTypeToStatus.get(messageType), messageTypeStatus)) {
            return;
        }
        this.messageTypeToStatus.put(messageType, messageTypeStatus);
        int i3 = 0;
        for (Object obj : this.messageList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((MessageItem) obj).getType(), messageType)) {
                notifyItemChanged(i3, "refuse_view");
            }
            i3 = i16;
        }
    }

    public final void z(List<MessageItem> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.messageList.clear();
        this.messageList.addAll(messages);
    }
}
