package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import circlesearch.CircleSearchExhibition$SquareRelevantInfo;
import circlesearch.CircleSearchExhibition$StSquareRsp;
import circlesearch.CircleSearchExhibition$SuggestionWord;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/t;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/ai;", "", "J", "H", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcirclesearch/CircleSearchExhibition$StSquareRsp;", "uiStateData", "I", "rsp", "Lcirclesearch/CircleSearchExhibition$SuggestionWord;", UserInfo.SEX_FEMALE, "Lcirclesearch/CircleSearchExhibition$SquareRelevantInfo;", "relevantInfo", "G", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "", "isElementCanActivate", "onElementActivated", "", "getPriority", "Lp70/b;", "Lp70/b;", "viewModel", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "searchInputBarObserver", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class t extends ai {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private p70.b viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Observer<UIStateData<CircleSearchExhibition$StSquareRsp>> searchInputBarObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        View view = this.f90604h;
        if (view instanceof QCircleBaseWidgetView) {
            this.viewModel = (p70.b) ((QCircleBaseWidgetView) view).getViewModel(p70.b.class);
        }
        this.searchInputBarObserver = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                t.K(t.this, (UIStateData) obj);
            }
        };
    }

    private final CircleSearchExhibition$SuggestionWord F(CircleSearchExhibition$StSquareRsp rsp) {
        CircleSearchExhibition$SquareRelevantInfo relevantInfo = rsp.relevant_info.get();
        Intrinsics.checkNotNullExpressionValue(relevantInfo, "relevantInfo");
        CircleSearchExhibition$SuggestionWord G = G(relevantInfo);
        String v3 = v();
        if (TextUtils.isEmpty(v3)) {
            return G;
        }
        CircleSearchExhibition$SquareRelevantInfo d16 = h60.a.d(v3);
        if (d16 != null) {
            CircleSearchExhibition$SuggestionWord G2 = G(d16);
            if (!TextUtils.isEmpty(G2.text.get())) {
                return G2;
            }
        }
        h60.a.h(v3, relevantInfo);
        return G;
    }

    private final CircleSearchExhibition$SuggestionWord G(CircleSearchExhibition$SquareRelevantInfo relevantInfo) {
        List<CircleSearchExhibition$SuggestionWord> list = relevantInfo.words.get();
        if (list.isEmpty()) {
            return new CircleSearchExhibition$SuggestionWord();
        }
        CircleSearchExhibition$SuggestionWord circleSearchExhibition$SuggestionWord = list.get(0);
        Intrinsics.checkNotNullExpressionValue(circleSearchExhibition$SuggestionWord, "relevantWords[0]");
        return circleSearchExhibition$SuggestionWord;
    }

    private final void H() {
        QLog.d("QFSFeedSearchInputBarView", 1, "[handleErrorRsp]");
    }

    private final void I(UIStateData<CircleSearchExhibition$StSquareRsp> uiStateData) {
        CircleSearchExhibition$StSquareRsp data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        CircleSearchExhibition$SuggestionWord F = F(data);
        String word = F.text.get();
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = F.ext_info.get();
        if (!TextUtils.isEmpty(word)) {
            Intrinsics.checkNotNullExpressionValue(word, "word");
            ai.D(this, word, feedCloudCommon$StCommonExt, false, 4, null);
        }
    }

    private final void J() {
        MutableLiveData<UIStateData<CircleSearchExhibition$StSquareRsp>> L1;
        p70.b bVar = this.viewModel;
        if (bVar != null && (L1 = bVar.L1()) != null) {
            L1.removeObserver(this.searchInputBarObserver);
        }
        p70.b bVar2 = this.viewModel;
        if (bVar2 != null) {
            bVar2.O1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(t this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        QLog.d("QFSFeedSearchInputBarView", 1, "[handleSquareRelevantRsp] state = " + state);
        if (state != 2 && state != 3) {
            if (state == 4) {
                this$0.H();
                return;
            }
            return;
        }
        this$0.I(uIStateData);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 101;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return Intrinsics.areEqual("1", com.tencent.biz.qqcircle.immersive.views.search.util.p.o(this.f90602e).get("search"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.ai, com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    @NotNull
    public String m() {
        return "QFSFeedSearchInputBarView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.ai, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        MutableLiveData<UIStateData<CircleSearchExhibition$StSquareRsp>> L1;
        super.onElementActivated();
        CircleSearchExhibition$SquareRelevantInfo d16 = h60.a.d(v());
        if (d16 != null) {
            CircleSearchExhibition$SuggestionWord G = G(d16);
            String word = G.text.get();
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = G.ext_info.get();
            if (!TextUtils.isEmpty(word)) {
                Intrinsics.checkNotNullExpressionValue(word, "word");
                ai.D(this, word, feedCloudCommon$StCommonExt, false, 4, null);
                return;
            }
        }
        p70.b bVar = this.viewModel;
        if (bVar != null && (L1 = bVar.L1()) != null) {
            L1.observeForever(this.searchInputBarObserver);
        }
        p70.b bVar2 = this.viewModel;
        if (bVar2 != null) {
            bVar2.N1(v());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.ai, com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public void r() {
        super.r();
        J();
    }
}
