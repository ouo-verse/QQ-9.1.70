package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/SearchDetailModule;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "MODULE_UNKNOWN", "SEARCH_DETAIL_MODULE_ALL_TAB_MINI_APP", "SEARCH_DETAIL_MODULE_ALL_TAB_MINI_GAME", "SEARCH_DETAIL_MODULE_ALL_TAB_MINI_AD", "SEARCH_DETAIL_MODULE_MINI_APP_TAB", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public enum SearchDetailModule {
    MODULE_UNKNOWN(""),
    SEARCH_DETAIL_MODULE_ALL_TAB_MINI_APP(QQHealthReportApiImpl.MSG_EXPOSE_KEY),
    SEARCH_DETAIL_MODULE_ALL_TAB_MINI_GAME(QQHealthReportApiImpl.MSG_CLICK_KEY),
    SEARCH_DETAIL_MODULE_ALL_TAB_MINI_AD("003"),
    SEARCH_DETAIL_MODULE_MINI_APP_TAB("004");


    @NotNull
    private final String value;

    SearchDetailModule(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
