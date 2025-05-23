package com.tencent.hippykotlin.demo.pages.qsearch_detail_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDetailViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailViewModel.class, "currentPage", "getCurrentPage()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/SubPageName;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailViewModel.class, "keyword", "getKeyword()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailViewModel.class, "inputText", "getInputText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailViewModel.class, "muted", "getMuted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailViewModel.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailViewModel.class, "pageWidth", "getPageWidth()D", 0)};
    public int closeType;
    public QSearchContentViewModel contentPageViewModel;
    public QSearchHistoryViewModel historyPageViewModel;
    public g pageData;
    public QSearchTabNetRepo repo;
    public QSearchSugWordsViewModel subWordPageViewModel;
    public int userSource;
    public final ReadWriteProperty currentPage$delegate = c.a(SubPageName.CONTENT);
    public final ReadWriteProperty keyword$delegate = c.a("");
    public final ReadWriteProperty inputText$delegate = c.a("");
    public final ReadWriteProperty muted$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty pageStatus$delegate = c.a(PageStatus.DID_APPEAR);
    public final ReadWriteProperty pageWidth$delegate = c.a(Double.valueOf(0.0d));
    public boolean useOIDBReq = true;
    public int querySource = 2;
    public String sessionId = "";
    public final QSearchPagePerfReporter perfReporter = new QSearchPagePerfReporter();
    public final Lazy isVasTheme$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel$isVasTheme$2
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Integer intOrNull;
            Utils utils = Utils.INSTANCE;
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(utils.currentBridgeModule().syncToNativeMethod("isVasTheme", (e) null, (Function1<? super e, Unit>) null));
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            utils.logToNative("isVasTheme:" + intValue);
            return Boolean.valueOf(intValue > 0);
        }
    });

    public final QSearchContentViewModel getContentPageViewModel() {
        QSearchContentViewModel qSearchContentViewModel = this.contentPageViewModel;
        if (qSearchContentViewModel != null) {
            return qSearchContentViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentPageViewModel");
        return null;
    }

    public final SubPageName getCurrentPage() {
        return (SubPageName) this.currentPage$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final QSearchHistoryViewModel getHistoryPageViewModel() {
        QSearchHistoryViewModel qSearchHistoryViewModel = this.historyPageViewModel;
        if (qSearchHistoryViewModel != null) {
            return qSearchHistoryViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("historyPageViewModel");
        return null;
    }

    public final String getInputText() {
        return (String) this.inputText$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final String getKeyword() {
        return (String) this.keyword$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean getMuted() {
        return ((Boolean) this.muted$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final PageStatus getPageStatus() {
        return (PageStatus) this.pageStatus$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final boolean isVasTheme() {
        return ((Boolean) this.isVasTheme$delegate.getValue()).booleanValue();
    }

    public final void setCurrentPage(SubPageName subPageName) {
        this.currentPage$delegate.setValue(this, $$delegatedProperties[0], subPageName);
    }

    public final void setKeyword(String str) {
        this.keyword$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setMuted(boolean z16) {
        this.muted$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    public final void setPageStatus(PageStatus pageStatus) {
        this.pageStatus$delegate.setValue(this, $$delegatedProperties[4], pageStatus);
    }
}
