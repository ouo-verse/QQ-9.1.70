package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.AdReportParam;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchNormalReportParam;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.j;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import hp2.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001IB\u0019\u0012\u0006\u0010D\u001a\u00020C\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u00a2\u0006\u0004\bG\u0010HJ\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J:\u0010\u0016\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0014\u0010\u0019\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0014\u0010\u001f\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\bH\u0002J\u001c\u0010'\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002J\u0014\u0010(\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010+\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010,\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\u0016\u00104\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f02H\u0002J(\u00105\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u00108\u001a\u00020\f2\u0006\u00107\u001a\u000206H\u0016J2\u0010@\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u0002092\u0006\u0010:\u001a\u00020\b2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010A\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchMiniAppDetailView;", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchBaseTemplateView;", "Lsp2/c;", "Lhp2/q;", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/b;", "data", "", BdhLogUtil.LogTag.Tag_Conn, "", "N", "", "I", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jumpInfo", "clickId", "searchId", "Landroid/view/MotionEvent;", "event", "Lnp2/b;", "componentInfo", "M", "P", "O", HippyTKDListViewAdapter.X, "index", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "button", "Landroid/widget/TextView;", "K", "B", "textView", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "searchTextData", "defaultColorInt", "G", "Lcom/tencent/mobileqq/search/searchdetail/content/base/g;", "jumpAction", UserInfo.SEX_FEMALE, "E", "J", "L", "w", "H", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "descView", "itemId", "itemInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "buttonList", "y", "D", "Landroid/view/ViewGroup;", "contentFlame", "i", "Lcom/tencent/mobileqq/search/searchdetail/a;", "position", "", "", "payload", "Lcom/tencent/mobileqq/search/searchdetail/d;", "pageIoc", ReportConstant.COSTREPORT_PREFIX, "Lhp2/q;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchMiniAppDetailView extends QSearchBaseTemplateView implements sp2.c {

    /* renamed from: E, reason: from kotlin metadata */
    private q binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchMiniAppDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(com.tencent.mobileqq.search.searchdetail.content.wxminapp.b data) {
        setTag(R.id.f1194776y, data);
        setTag(R.id.f11953774, Integer.valueOf(data.getMiniAppDetail().miniAppType));
        setTag(R.id.f11954775, data.getBackEndReportInfo());
        qp2.a backEndReportInfo = data.getBackEndReportInfo();
        if (backEndReportInfo != null) {
            D(this, backEndReportInfo.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID java.lang.String(), backEndReportInfo.getItemInfo(), 0);
        }
    }

    private final void B(q qVar, com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        q qVar2 = this.binding;
        if (qVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar2 = null;
        }
        ImageView imageView = qVar2.f405725k;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.operationIconLeft");
        String str = bVar.getMiniAppDetail().rankLeftIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str, "data.miniAppDetail.rankLeftIcon.iconLink");
        boolean z28 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        p.b(imageView, z16);
        String str2 = bVar.getMiniAppDetail().rankLeftIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str2, "data.miniAppDetail.rankLeftIcon.iconLink");
        if (str2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Option url = Option.obtain().setUrl(bVar.getMiniAppDetail().rankLeftIcon.iconLink);
            q qVar3 = this.binding;
            if (qVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar3 = null;
            }
            Option option = url.setTargetView(qVar3.f405725k);
            SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            searchPicLoader.e(option, null);
        }
        TextView operationTag = qVar.f405728n;
        Intrinsics.checkNotNullExpressionValue(operationTag, "operationTag");
        SearchText searchText = bVar.getMiniAppDetail().operationInformationHighlight;
        Intrinsics.checkNotNullExpressionValue(searchText, "data.miniAppDetail.operationInformationHighlight");
        G(operationTag, searchText, R.color.qui_common_feedback_warning);
        q qVar4 = this.binding;
        if (qVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar4 = null;
        }
        ImageView imageView2 = qVar4.f405726l;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.operationIconRight");
        String str3 = bVar.getMiniAppDetail().rankRightIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str3, "data.miniAppDetail.rankRightIcon.iconLink");
        if (str3.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        p.b(imageView2, z18);
        String str4 = bVar.getMiniAppDetail().rankRightIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str4, "data.miniAppDetail.rankRightIcon.iconLink");
        if (str4.length() > 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            Option url2 = Option.obtain().setUrl(bVar.getMiniAppDetail().rankRightIcon.iconLink);
            q qVar5 = this.binding;
            if (qVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar5 = null;
            }
            Option option2 = url2.setTargetView(qVar5.f405726l);
            SearchPicLoader searchPicLoader2 = SearchPicLoader.f284726a;
            Intrinsics.checkNotNullExpressionValue(option2, "option");
            searchPicLoader2.e(option2, null);
        }
        TextView operationContent = qVar.f405724j;
        Intrinsics.checkNotNullExpressionValue(operationContent, "operationContent");
        SearchText searchText2 = bVar.getMiniAppDetail().operationInformation;
        Intrinsics.checkNotNullExpressionValue(searchText2, "data.miniAppDetail.operationInformation");
        G(operationContent, searchText2, R.color.qui_common_text_secondary_light);
        LinearLayout operationLayout = qVar.f405727m;
        Intrinsics.checkNotNullExpressionValue(operationLayout, "operationLayout");
        TextView operationTag2 = qVar.f405728n;
        Intrinsics.checkNotNullExpressionValue(operationTag2, "operationTag");
        if (operationTag2.getVisibility() == 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (!z26) {
            TextView operationContent2 = qVar.f405724j;
            Intrinsics.checkNotNullExpressionValue(operationContent2, "operationContent");
            if (operationContent2.getVisibility() == 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (!z27) {
                z28 = false;
            }
        }
        p.b(operationLayout, z28);
    }

    private final void C(q qVar, final com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        boolean z16;
        String str;
        boolean z17;
        String str2;
        SearchReportInfo searchReportInfo;
        String t16;
        SearchReportInfo searchReportInfo2;
        TextView tvDesc = qVar.f405734t;
        Intrinsics.checkNotNullExpressionValue(tvDesc, "tvDesc");
        String str3 = bVar.getMiniAppDetail().introduction.text;
        Intrinsics.checkNotNullExpressionValue(str3, "data.miniAppDetail.introduction.text");
        if (str3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        p.b(tvDesc, z16);
        com.tencent.mobileqq.search.searchdetail.d pageIOC = getPageIOC();
        String str4 = "";
        if (pageIOC == null || (str = pageIOC.getKeyword()) == null) {
            str = "";
        }
        if (str.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            TextView textView = qVar.f405734t;
            com.tencent.mobileqq.search.searchdetail.util.b bVar2 = com.tencent.mobileqq.search.searchdetail.util.b.f284738a;
            String str5 = bVar.getMiniAppDetail().introduction.text;
            Intrinsics.checkNotNullExpressionValue(str5, "data.miniAppDetail.introduction.text");
            textView.setText(bVar2.a(str5, str));
        } else {
            qVar.f405734t.setText(bVar.getMiniAppDetail().introduction.text);
        }
        TextView tvDesc2 = qVar.f405734t;
        Intrinsics.checkNotNullExpressionValue(tvDesc2, "tvDesc");
        j.R(tvDesc2, false, new Function2<View, MotionEvent, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView$bindIntroduction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, MotionEvent motionEvent) {
                invoke2(view, motionEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull MotionEvent event) {
                String searchId;
                String searchId2;
                String h16;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(event, "event");
                if (QSearchDetailUtilKt.i(com.tencent.mobileqq.search.searchdetail.content.wxminapp.b.this.getJumpLink())) {
                    QSearchMiniAppDetailView qSearchMiniAppDetailView = this;
                    SearchJump jumpLink = com.tencent.mobileqq.search.searchdetail.content.wxminapp.b.this.getJumpLink();
                    qp2.a backEndReportInfo = com.tencent.mobileqq.search.searchdetail.content.wxminapp.b.this.getBackEndReportInfo();
                    String str6 = (backEndReportInfo == null || (searchId2 = backEndReportInfo.getSearchId()) == null || (h16 = j.h(searchId2)) == null) ? "" : h16;
                    qp2.a backEndReportInfo2 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.b.this.getBackEndReportInfo();
                    String str7 = (backEndReportInfo2 == null || (searchId = backEndReportInfo2.getSearchId()) == null) ? "" : searchId;
                    SearchReportInfo searchReportInfo3 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.b.this.getMiniAppDetail().introduction.backendReportInfo;
                    Intrinsics.checkNotNullExpressionValue(searchReportInfo3, "data.miniAppDetail.introduction.backendReportInfo");
                    qSearchMiniAppDetailView.M(view, jumpLink, str6, str7, event, j.l(searchReportInfo3));
                    QSearchMiniAppDetailView qSearchMiniAppDetailView2 = this;
                    qSearchMiniAppDetailView2.P(qSearchMiniAppDetailView2);
                }
            }
        }, 1, null);
        TextView tvDesc3 = qVar.f405734t;
        Intrinsics.checkNotNullExpressionValue(tvDesc3, "tvDesc");
        SearchText searchText = bVar.getMiniAppDetail().introduction;
        if (searchText == null || (searchReportInfo2 = searchText.backendReportInfo) == null || (str2 = j.r(searchReportInfo2)) == null) {
            str2 = "";
        }
        SearchText searchText2 = bVar.getMiniAppDetail().introduction;
        if (searchText2 != null && (searchReportInfo = searchText2.backendReportInfo) != null && (t16 = j.t(searchReportInfo)) != null) {
            str4 = t16;
        }
        z(tvDesc3, str2, str4);
    }

    private final void D(View view, String itemId, String itemInfo, int index) {
        boolean z16;
        boolean z17 = true;
        if (itemId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (itemInfo.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                view.setTag(R.id.f11950771, itemId);
                view.setTag(R.id.f11951772, itemInfo);
                view.setTag(R.id.f11952773, index + ":" + j.B(itemInfo));
            }
        }
    }

    private final void E(q qVar, com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        TextView miniAppLabel = qVar.f405722h;
        Intrinsics.checkNotNullExpressionValue(miniAppLabel, "miniAppLabel");
        SearchText searchText = bVar.getMiniAppDetail().userBehaviorLabel;
        Intrinsics.checkNotNullExpressionValue(searchText, "data.miniAppDetail.userBehaviorLabel");
        G(miniAppLabel, searchText, R.color.qui_common_text_secondary);
    }

    private final void F(q qVar, com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar, com.tencent.mobileqq.search.searchdetail.content.base.g gVar) {
        int i3;
        boolean z16;
        boolean z17;
        TextView miniGameLabel = qVar.f405723i;
        Intrinsics.checkNotNullExpressionValue(miniGameLabel, "miniGameLabel");
        SearchText searchText = bVar.getMiniAppDetail().gameUserBehaviorLabel;
        Intrinsics.checkNotNullExpressionValue(searchText, "data.miniAppDetail.gameUserBehaviorLabel");
        G(miniGameLabel, searchText, R.color.qui_common_text_secondary);
        QSearchLabelLayout bindMiniGameLabel$lambda$8 = qVar.f405720f;
        Intrinsics.checkNotNullExpressionValue(bindMiniGameLabel$lambda$8, "bindMiniGameLabel$lambda$8");
        Intrinsics.checkNotNullExpressionValue(bVar.getMiniAppDetail().gameLabelList, "data.miniAppDetail.gameLabelList");
        boolean z18 = true;
        if (!r2.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        bindMiniGameLabel$lambda$8.setVisibility(i3);
        JSONObject q16 = q(getPosition(), bVar);
        Intrinsics.checkNotNullExpressionValue(bVar.getMiniAppDetail().gameLabelList, "data.miniAppDetail.gameLabelList");
        if (!r6.isEmpty()) {
            bindMiniGameLabel$lambda$8.setParentReportInfo(q16);
            bindMiniGameLabel$lambda$8.d(bVar.A(), gVar);
        }
        ConstraintLayout labelsLayout = qVar.f405721g;
        Intrinsics.checkNotNullExpressionValue(labelsLayout, "labelsLayout");
        TextView miniGameLabel2 = qVar.f405723i;
        Intrinsics.checkNotNullExpressionValue(miniGameLabel2, "miniGameLabel");
        if (miniGameLabel2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QSearchLabelLayout labelArea = qVar.f405720f;
            Intrinsics.checkNotNullExpressionValue(labelArea, "labelArea");
            if (labelArea.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z18 = false;
            }
        }
        p.b(labelsLayout, z18);
    }

    private final void G(TextView textView, SearchText searchTextData, int defaultColorInt) {
        boolean z16;
        int color;
        String str = searchTextData.text;
        Intrinsics.checkNotNullExpressionValue(str, "searchTextData.text");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        p.b(textView, z16);
        textView.setText(searchTextData.text);
        Integer a16 = com.tencent.mobileqq.search.searchdetail.content.model.h.f283924a.a(searchTextData);
        if (a16 != null) {
            color = a16.intValue();
        } else {
            color = BaseApplication.getContext().getColor(defaultColorInt);
        }
        textView.setTextColor(color);
    }

    private final void H(q qVar, com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        boolean z16;
        QSearchShowHighlightTextView subTitle = qVar.f405730p;
        Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
        String str = bVar.getMiniAppDetail().subTitle.text;
        Intrinsics.checkNotNullExpressionValue(str, "data.miniAppDetail.subTitle.text");
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        p.b(subTitle, z16);
        qVar.f405730p.h();
        QSearchShowHighlightTextView qSearchShowHighlightTextView = qVar.f405730p;
        String str2 = bVar.getMiniAppDetail().subTitle.text;
        Intrinsics.checkNotNullExpressionValue(str2, "data.miniAppDetail.subTitle.text");
        qSearchShowHighlightTextView.setText(str2);
        String str3 = bVar.getMiniAppDetail().subTitleTag.iconLink;
        Intrinsics.checkNotNullExpressionValue(str3, "data.miniAppDetail.subTitleTag.iconLink");
        if (str3.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            ImageView imageView = new ImageView(qVar.f405730p.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int a16 = ViewUtils.f352270a.a(12.0f);
            qVar.f405730p.a(imageView, new LinearLayout.LayoutParams(a16, a16));
            rn2.j jVar = rn2.j.f431768a;
            String str4 = bVar.getMiniAppDetail().subTitleTag.iconLink;
            Intrinsics.checkNotNullExpressionValue(str4, "data.miniAppDetail.subTitleTag.iconLink");
            jVar.p(imageView, str4);
        }
    }

    private final String I() {
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar;
        qp2.a backEndReportInfo;
        com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel = getDataModel();
        if (dataModel instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
            bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) dataModel;
        } else {
            bVar = null;
        }
        if (bVar == null || (backEndReportInfo = bVar.getBackEndReportInfo()) == null) {
            return null;
        }
        return backEndReportInfo.getItemInfo();
    }

    private final void J(com.tencent.mobileqq.search.searchdetail.content.wxminapp.b data) {
        boolean z16;
        boolean z17;
        q qVar = this.binding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        ImageView imageView = qVar.f405718d;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivAvatar");
        ab.d(imageView, ViewUtils.f352270a.a(26.0f));
        String str = data.getMiniAppDetail().icon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str, "data.miniAppDetail.icon.iconLink");
        boolean z18 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Option url = Option.obtain().setUrl(data.getMiniAppDetail().icon.iconLink);
            q qVar2 = this.binding;
            if (qVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar2 = null;
            }
            Option option = url.setTargetView(qVar2.f405718d);
            SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            searchPicLoader.e(option, null);
        }
        q qVar3 = this.binding;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar3 = null;
        }
        ImageView imageView2 = qVar3.f405719e;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivLittleIcon");
        String str2 = data.getMiniAppDetail().littleIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str2, "data.miniAppDetail.littleIcon.iconLink");
        if (str2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        p.b(imageView2, z17);
        String str3 = data.getMiniAppDetail().littleIcon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str3, "data.miniAppDetail.littleIcon.iconLink");
        if (str3.length() <= 0) {
            z18 = false;
        }
        if (z18) {
            Option url2 = Option.obtain().setUrl(data.getMiniAppDetail().littleIcon.iconLink);
            q qVar4 = this.binding;
            if (qVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar4 = null;
            }
            Option option2 = url2.setTargetView(qVar4.f405719e);
            SearchPicLoader searchPicLoader2 = SearchPicLoader.f284726a;
            Intrinsics.checkNotNullExpressionValue(option2, "option");
            searchPicLoader2.e(option2, null);
        }
    }

    private final TextView K(int index, SearchButton button) {
        TextView textView = new TextView(getContext());
        textView.setPadding(com.tencent.mobileqq.utils.ViewUtils.dip2px(10.0f), com.tencent.mobileqq.utils.ViewUtils.dip2px(8.0f), com.tencent.mobileqq.utils.ViewUtils.dip2px(10.0f), com.tencent.mobileqq.utils.ViewUtils.dip2px(8.0f));
        textView.setText(button.title);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_link));
        float dip2px = com.tencent.mobileqq.utils.ViewUtils.dip2px(8.0f);
        textView.setBackground(rn2.j.f431768a.g(dip2px, dip2px, dip2px, dip2px, getResources().getColor(R.color.qui_common_fill_standard_primary)));
        return textView;
    }

    private final void L(com.tencent.mobileqq.search.searchdetail.content.wxminapp.b data) {
        boolean z16;
        Intrinsics.checkNotNullExpressionValue(data.getMiniAppDetail().tagList, "data.miniAppDetail.tagList");
        q qVar = null;
        if (!r0.isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(data.getMiniAppDetail().tagList, "data.miniAppDetail.tagList");
            if (!r0.isEmpty()) {
                boolean z17 = false;
                SearchIcon searchIcon = data.getMiniAppDetail().tagList.get(0);
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                String str = searchIcon.iconLink;
                Intrinsics.checkNotNullExpressionValue(str, "firstIcon.iconLink");
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    int a16 = ViewUtils.f352270a.a(14.0f);
                    linearLayout.addView(imageView, new LinearLayout.LayoutParams(a16, a16));
                    rn2.j jVar = rn2.j.f431768a;
                    String str2 = searchIcon.iconLink;
                    Intrinsics.checkNotNullExpressionValue(str2, "firstIcon.iconLink");
                    jVar.n(imageView, str2, a16);
                }
                String str3 = searchIcon.title.text;
                Intrinsics.checkNotNullExpressionValue(str3, "firstIcon.title.text");
                if (str3.length() > 0) {
                    z17 = true;
                }
                if (z17) {
                    TextView textView = new TextView(getContext());
                    textView.setTextSize(1, 12.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMarginStart(ViewUtils.f352270a.b(2));
                    linearLayout.addView(textView, layoutParams);
                    SearchText searchText = searchIcon.title;
                    Intrinsics.checkNotNullExpressionValue(searchText, "firstIcon.title");
                    G(textView, searchText, R.color.qui_common_text_secondary_light);
                }
                q qVar2 = this.binding;
                if (qVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    qVar2 = null;
                }
                QSearchShowHighlightTextView qSearchShowHighlightTextView = qVar2.f405732r;
                Intrinsics.checkNotNullExpressionValue(qSearchShowHighlightTextView, "binding.titleArea");
                QSearchShowHighlightTextView.b(qSearchShowHighlightTextView, linearLayout, null, 2, null);
                return;
            }
        }
        q qVar3 = this.binding;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            qVar = qVar3;
        }
        qVar.f405732r.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(View view, SearchJump jumpInfo, String clickId, String searchId, MotionEvent event, np2.b componentInfo) {
        SearchPageType searchPageType;
        long j3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.mobileqq.search.searchdetail.d pageIOC = getPageIOC();
        if (pageIOC == null || (searchPageType = pageIOC.getPageType()) == null) {
            searchPageType = SearchPageType.PAGE_NET_SEARCH_DETAIL;
        }
        if (searchPageType == SearchPageType.PAGE_NET_SEARCH_DETAIL) {
            if (getDataModel() instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
                com.tencent.mobileqq.search.searchdetail.d pageIOC2 = getPageIOC();
                if (pageIOC2 != null) {
                    j3 = pageIOC2.getTabMask();
                } else {
                    j3 = 1;
                }
                com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel = getDataModel();
                Intrinsics.checkNotNull(dataModel, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.wxminapp.NetWXMiniAppDetailItem");
                linkedHashMap.put("host_scene", String.valueOf(com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.f284377a.d(j3, ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) dataModel).getMiniAppDetail().miniAppType)));
            }
        } else {
            linkedHashMap.put("host_scene", String.valueOf(com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.b(searchPageType, null, 2, null)));
        }
        linkedHashMap.put(StartupReportKey.SCENE_NOTE, com.tencent.mobileqq.search.searchdetail.content.wxminapp.e.c(clickId, N()));
        linkedHashMap.put("wx_mini_app_search_id", searchId);
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.QSearchMiniAppDetailView", 1, "jump2WxMiniApp extensionMap=" + linkedHashMap, null);
        d(jumpInfo, linkedHashMap);
        O(view, event, clickId, componentInfo);
    }

    private final int N() {
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar;
        com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel = getDataModel();
        if (dataModel instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
            bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) dataModel;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return 0;
        }
        return bVar.getMiniAppDetail().miniAppType;
    }

    private final void O(View view, MotionEvent event, String clickId, np2.b componentInfo) {
        boolean z16;
        String str;
        AdReportParam i3;
        if (N() == 3 && (i3 = j.i(this)) != null) {
            j.E(this, event, this, i3, clickId, componentInfo);
        }
        String s16 = j.s(view);
        String u16 = j.u(view);
        if (s16 != null && s16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            s16 = I();
            if (s16 != null) {
                str = j.B(s16);
            } else {
                str = null;
            }
            u16 = "0:" + str;
        }
        SearchNormalReportParam w3 = j.w(this, clickId, getWithoutTitlePosition());
        if (w3 != null) {
            w3.e(3002);
            if (s16 == null) {
                s16 = "";
            }
            w3.j(s16);
            if (u16 == null) {
                u16 = "";
            }
            w3.k(u16);
            j.K(w3, "click");
        }
        com.tencent.mobileqq.search.searchdetail.d pageIOC = getPageIOC();
        if (pageIOC != null) {
            pageIOC.onClickMiniApp(clickId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(View view) {
        com.tencent.mobileqq.search.report.a.f(com.tencent.mobileqq.search.report.a.f283716a, "dt_clck", view, null, 4, null);
    }

    private final void w(q qVar, com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        boolean z16;
        TextView adButton = qVar.f405716b;
        Intrinsics.checkNotNullExpressionValue(adButton, "adButton");
        if (bVar.getMiniAppDetail().miniAppType == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        p.b(adButton, z16);
        qVar.f405716b.setText(bVar.getMiniAppDetail().adInfo.text);
    }

    private final void x(q qVar, final com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout = qVar.f405717c;
        if (linearLayout.getChildCount() != 0) {
            linearLayout.removeAllViews();
        }
        ArrayList<SearchButton> dataList = bVar.getMiniAppDetail().buttonList;
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        boolean z16 = false;
        final int i3 = 0;
        for (Object obj : dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final SearchButton button = (SearchButton) obj;
            if (dataList.size() > 1) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.weight = 1.0f;
            } else {
                layoutParams = new LinearLayout.LayoutParams((com.tencent.mobileqq.utils.ViewUtils.getScreenWidth() - l.b(120)) / 2, -2);
            }
            if (i3 > 0) {
                layoutParams.leftMargin = com.tencent.mobileqq.utils.ViewUtils.dip2px(8.0f);
            }
            Intrinsics.checkNotNullExpressionValue(button, "button");
            TextView K = K(i3, button);
            j.R(K, z16, new Function2<View, MotionEvent, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView$bindButtonList$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, MotionEvent motionEvent) {
                    invoke2(view, motionEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull MotionEvent event) {
                    String dtAppKey;
                    String searchId;
                    String searchId2;
                    String h16;
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (QSearchDetailUtilKt.i(SearchButton.this.jumpLink)) {
                        QSearchMiniAppDetailView qSearchMiniAppDetailView = this;
                        SearchJump searchJump = SearchButton.this.jumpLink;
                        qp2.a backEndReportInfo = bVar.getBackEndReportInfo();
                        String str = (backEndReportInfo == null || (searchId2 = backEndReportInfo.getSearchId()) == null || (h16 = j.h(searchId2)) == null) ? "" : h16;
                        qp2.a backEndReportInfo2 = bVar.getBackEndReportInfo();
                        String str2 = (backEndReportInfo2 == null || (searchId = backEndReportInfo2.getSearchId()) == null) ? "" : searchId;
                        SearchReportInfo searchReportInfo = SearchButton.this.backendReportInfo;
                        Intrinsics.checkNotNullExpressionValue(searchReportInfo, "button.backendReportInfo");
                        qSearchMiniAppDetailView.M(view, searchJump, str, str2, event, j.l(searchReportInfo));
                        HashMap hashMap = new HashMap();
                        hashMap.put("click_location", Integer.valueOf(i3));
                        String str3 = SearchButton.this.title;
                        Intrinsics.checkNotNullExpressionValue(str3, "button.title");
                        hashMap.put("entry_name", str3);
                        com.tencent.mobileqq.search.searchdetail.d pageIOC = this.getPageIOC();
                        if (pageIOC != null && (dtAppKey = pageIOC.getDtAppKey()) != null) {
                            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, dtAppKey);
                        }
                        com.tencent.mobileqq.search.report.a.f283716a.d("dt_clck", view, "em_bas_ad_click", hashMap);
                    }
                }
            }, 1, null);
            final SearchReportInfo reportInfo = button.reportInfo;
            if (reportInfo != null) {
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                i.i(K, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView$bindButtonList$1$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        SearchReportInfo searchReportInfo = SearchReportInfo.this;
                        QSearchMiniAppDetailView qSearchMiniAppDetailView = this;
                        return i.f(searchReportInfo, qSearchMiniAppDetailView.q(qSearchMiniAppDetailView.getPosition(), bVar), null, 2, null);
                    }
                }, String.valueOf(reportInfo.hashCode()));
            }
            linearLayout.addView(K, layoutParams);
            arrayList.add(K);
            SearchReportInfo searchReportInfo = button.backendReportInfo;
            Intrinsics.checkNotNullExpressionValue(searchReportInfo, "button.backendReportInfo");
            String r16 = j.r(searchReportInfo);
            SearchReportInfo searchReportInfo2 = button.backendReportInfo;
            Intrinsics.checkNotNullExpressionValue(searchReportInfo2, "button.backendReportInfo");
            D(K, r16, j.t(searchReportInfo2), i3);
            i3 = i16;
            z16 = false;
        }
        LinearLayout buttonContent = qVar.f405717c;
        Intrinsics.checkNotNullExpressionValue(buttonContent, "buttonContent");
        p.b(buttonContent, !arrayList.isEmpty());
        y(arrayList);
    }

    private final void y(List<? extends View> buttonList) {
        if (buttonList.isEmpty()) {
            setTag(R.id.f1194876z, null);
        } else {
            setTag(R.id.f1194876z, buttonList);
        }
    }

    private final void z(View descView, String itemId, String itemInfo) {
        boolean z16;
        if (descView.getVisibility() == 0) {
            boolean z17 = true;
            if (itemId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (itemInfo.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    D(descView, itemId, itemInfo, 0);
                    setTag(R.id.f11949770, descView);
                    return;
                }
            }
        }
        setTag(R.id.f11949770, null);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    @NotNull
    public View i(@NotNull ViewGroup contentFlame) {
        Intrinsics.checkNotNullParameter(contentFlame, "contentFlame");
        q g16 = q.g(LayoutInflater.from(getContext()), contentFlame, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        ConstraintLayout mContainer = g16.getMContainer();
        mContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root.apply {\n   \u2026s.WRAP_CONTENT)\n        }");
        return mContainer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
    
        if (r1 != false) goto L34;
     */
    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(@NotNull final com.tencent.mobileqq.search.searchdetail.a data, int position, @Nullable List<Object> payload, @Nullable com.tencent.mobileqq.search.searchdetail.d pageIoc) {
        String str;
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b)) {
            return;
        }
        setDataModel((com.tencent.mobileqq.search.searchdetail.content.template.model.a) data);
        setPosition(position);
        setPageIOC(pageIoc);
        boolean z19 = false;
        q qVar = null;
        j.R(this, false, new Function2<View, MotionEvent, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView$initLayoutContentModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, MotionEvent motionEvent) {
                invoke2(view, motionEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull MotionEvent event) {
                String searchId;
                String searchId2;
                String h16;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(event, "event");
                if (QSearchDetailUtilKt.i(((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) com.tencent.mobileqq.search.searchdetail.a.this).getJumpLink())) {
                    QSearchMiniAppDetailView qSearchMiniAppDetailView = this;
                    SearchJump jumpLink = ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) com.tencent.mobileqq.search.searchdetail.a.this).getJumpLink();
                    qp2.a backEndReportInfo = ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) com.tencent.mobileqq.search.searchdetail.a.this).getBackEndReportInfo();
                    String str2 = (backEndReportInfo == null || (searchId2 = backEndReportInfo.getSearchId()) == null || (h16 = j.h(searchId2)) == null) ? "" : h16;
                    qp2.a backEndReportInfo2 = ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) com.tencent.mobileqq.search.searchdetail.a.this).getBackEndReportInfo();
                    String str3 = (backEndReportInfo2 == null || (searchId = backEndReportInfo2.getSearchId()) == null) ? "" : searchId;
                    SearchReportInfo searchReportInfo = ((com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) com.tencent.mobileqq.search.searchdetail.a.this).getMiniAppDetail().backendReportInfo;
                    Intrinsics.checkNotNullExpressionValue(searchReportInfo, "data.miniAppDetail.backendReportInfo");
                    qSearchMiniAppDetailView.M(view, jumpLink, str2, str3, event, j.l(searchReportInfo));
                    this.P(view);
                }
            }
        }, 1, null);
        q qVar2 = this.binding;
        if (qVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            qVar = qVar2;
        }
        com.tencent.mobileqq.search.searchdetail.d pageIOC = getPageIOC();
        if (pageIOC == null || (str = pageIOC.getKeyword()) == null) {
            str = "";
        }
        View topDivider = qVar.f405733s;
        Intrinsics.checkNotNullExpressionValue(topDivider, "topDivider");
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) data;
        if (bVar.getLayoutInfo().showDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        topDivider.setVisibility(i3);
        J(bVar);
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qVar.f405732r.setHighlightText(str);
        }
        QSearchShowHighlightTextView qSearchShowHighlightTextView = qVar.f405732r;
        String str2 = bVar.getMiniAppDetail().title.text;
        Intrinsics.checkNotNullExpressionValue(str2, "data.miniAppDetail.title.text");
        qSearchShowHighlightTextView.setText(str2);
        L(bVar);
        w(qVar, bVar);
        H(qVar, bVar);
        E(qVar, bVar);
        ConstraintLayout subTitleLayout = qVar.f405731q;
        Intrinsics.checkNotNullExpressionValue(subTitleLayout, "subTitleLayout");
        QSearchShowHighlightTextView subTitle = qVar.f405730p;
        Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
        if (subTitle.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            TextView miniAppLabel = qVar.f405722h;
            Intrinsics.checkNotNullExpressionValue(miniAppLabel, "miniAppLabel");
            if (miniAppLabel.getVisibility() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
        }
        z19 = true;
        p.b(subTitleLayout, z19);
        C(qVar, bVar);
        F(qVar, bVar, this);
        B(qVar, bVar);
        x(qVar, bVar);
        A(bVar);
    }
}
