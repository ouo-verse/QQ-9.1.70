package com.tencent.mobileqq.search.searchdetail.util;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u0000 H2\u00020\u0001:\u0001IB!\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0002J$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R6\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00103\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b+\u00102R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R%\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010;0:8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R%\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010;0:8\u0006\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?R\u0016\u0010E\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u001e\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/SearchShadingWordPlay;", "Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", ReportConstant.COSTREPORT_PREFIX, "o", "c", "f", "e", "b", "", tl.h.F, "p", "", "position", "hintText", "reportData", "onHintChange", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "k", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "quiSearchBar", "I", "getRequestWordSource", "()I", "requestWordSource", "Z", DomainData.DOMAIN_NAME, "()Z", "isReportQQEventId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getHintWords", "()Ljava/util/ArrayList;", "r", "(Ljava/util/ArrayList;)V", "hintWords", "Lcom/tencent/mobileqq/search/view/AutoHintLayout;", "i", "Lcom/tencent/mobileqq/search/view/AutoHintLayout;", "g", "()Lcom/tencent/mobileqq/search/view/AutoHintLayout;", "autoHintLayout", "Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;", "Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;", "()Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;", "editText", "Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "getHintListener", "()Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "hintListener", "", "", "D", "Ljava/util/Map;", "j", "()Ljava/util/Map;", "editTextReportParams", "E", "l", "quiSearchBarReportParams", UserInfo.SEX_FEMALE, "isAllowOpenShadingHintWords", "<init>", "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;IZ)V", "G", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchShadingWordPlay implements AutoHintLayout.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.view.a hintListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Object> editTextReportParams;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Object> quiSearchBarReportParams;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isAllowOpenShadingHintWords;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISearchBar quiSearchBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int requestWordSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isReportQQEventId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<String> hintWords;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AutoHintLayout autoHintLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickPinyinEditText editText;

    public SearchShadingWordPlay(@NotNull QUISearchBar quiSearchBar, int i3, boolean z16) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Intrinsics.checkNotNullParameter(quiSearchBar, "quiSearchBar");
        this.quiSearchBar = quiSearchBar;
        this.requestWordSource = i3;
        this.isReportQQEventId = z16;
        AutoHintLayout autoHintLayout = quiSearchBar.getAutoHintLayout();
        Intrinsics.checkNotNullExpressionValue(autoHintLayout, "quiSearchBar.autoHintLayout");
        this.autoHintLayout = autoHintLayout;
        QuickPinyinEditText inputWidget = quiSearchBar.getInputWidget();
        Intrinsics.checkNotNullExpressionValue(inputWidget, "quiSearchBar.inputWidget");
        this.editText = inputWidget;
        this.hintListener = new com.tencent.mobileqq.search.searchdetail.content.view.a(quiSearchBar, this);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("is_shading", 0));
        this.editTextReportParams = mutableMapOf;
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("is_shading", 0));
        this.quiSearchBarReportParams = mutableMapOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SearchShadingWordPlay this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        this$0.autoHintLayout.setHintHelperGravity(17);
        this$0.autoHintLayout.m(this$0.hintListener);
    }

    private final void m() {
        SearchBoxWordsUtil.c(this.requestWordSource, new Function1<ArrayList<String>, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.util.SearchShadingWordPlay$initHintWords$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ArrayList<String> boxWords) {
                Intrinsics.checkNotNullParameter(boxWords, "boxWords");
                int i3 = !boxWords.isEmpty() ? 1 : 0;
                if (i3 != 0) {
                    SearchShadingWordPlay.this.r(boxWords);
                    SearchShadingWordPlay.this.getEditText().setCursorVisible(false);
                    SearchShadingWordPlay.this.getQuiSearchBar().setClipChildren(false);
                    SearchShadingWordPlay.this.getQuiSearchBar().getFlSearchExt().setVisibility(8);
                    SearchShadingWordPlay.this.getAutoHintLayout().setEnableFrondIconRunInAnim(true, SearchShadingWordPlay.this.getQuiSearchBar());
                    SearchShadingWordPlay.this.getAutoHintLayout().setInterval(5000L);
                    SearchShadingWordPlay.this.getAutoHintLayout().setAnimDuration(400);
                    SearchShadingWordPlay.this.getAutoHintLayout().setHintList(boxWords);
                    SearchShadingWordPlay.this.getAutoHintLayout().setReportDataList(boxWords);
                }
                SearchShadingWordPlay.this.l().put("is_shading", Integer.valueOf(i3));
                SearchShadingWordPlay.this.j().put("is_shading", Integer.valueOf(i3));
                VideoReport.reportEvent(SearchShadingWordPlay.this.getIsReportQQEventId() ? "qq_imp" : "dt_imp", SearchShadingWordPlay.this.getQuiSearchBar(), SearchShadingWordPlay.this.l());
            }
        });
    }

    private final void o() {
        this.editText.getLayoutParams().width = -2;
        this.editText.requestLayout();
    }

    private final void q() {
        VideoReport.setElementId(this.quiSearchBar, "em_bas_search_box");
        QUISearchBar qUISearchBar = this.quiSearchBar;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(qUISearchBar, clickPolicy);
        QUISearchBar qUISearchBar2 = this.quiSearchBar;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(qUISearchBar2, exposurePolicy);
        VideoReport.setElementId(this.editText, "em_search_grey_word");
        VideoReport.setElementClickPolicy(this.editText, clickPolicy);
        VideoReport.setElementExposePolicy(this.editText, exposurePolicy);
    }

    private final boolean s() {
        boolean z16;
        boolean z17 = this.isAllowOpenShadingHintWords;
        if (SearchBoxWordsUtil.f284723a.e() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isAllowOpenShadingHintWords = z16;
        QLog.i("SearchShadingWordPlay", 4, "showHintWordsStateIsUpdate   currentState:" + z17 + "    isAllowOpenShadingHintWords:" + z16);
        if (z17 != this.isAllowOpenShadingHintWords) {
            return true;
        }
        return false;
    }

    public final void b() {
        this.autoHintLayout.u(this.hintListener);
    }

    public final void c() {
        this.quiSearchBar.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.util.l
            @Override // java.lang.Runnable
            public final void run() {
                SearchShadingWordPlay.d(SearchShadingWordPlay.this);
            }
        });
    }

    public final void e() {
        this.autoHintLayout.s();
    }

    public final void f() {
        String str;
        boolean z16 = true;
        if (s()) {
            if (this.isAllowOpenShadingHintWords) {
                m();
            } else {
                this.hintWords = null;
                this.autoHintLayout.n();
                this.quiSearchBar.getFlSearchExt().setVisibility(0);
                o();
                this.quiSearchBarReportParams.put("is_shading", 0);
                this.editTextReportParams.put("is_shading", 0);
                this.editTextReportParams.remove("literal_text");
                z16 = false;
            }
        } else {
            if (this.isAllowOpenShadingHintWords) {
                if (SearchBoxWordsUtil.f284723a.f(this.requestWordSource)) {
                    m();
                } else {
                    this.autoHintLayout.q();
                }
            }
            z16 = false;
        }
        if (!z16) {
            if (this.isReportQQEventId) {
                str = "qq_imp";
            } else {
                str = "dt_imp";
            }
            VideoReport.reportEvent(str, this.quiSearchBar, this.quiSearchBarReportParams);
        }
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final AutoHintLayout getAutoHintLayout() {
        return this.autoHintLayout;
    }

    @NotNull
    public final String h() {
        if (!this.isAllowOpenShadingHintWords) {
            return "";
        }
        String i3 = this.autoHintLayout.i();
        Intrinsics.checkNotNullExpressionValue(i3, "autoHintLayout.hintText");
        return i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final QuickPinyinEditText getEditText() {
        return this.editText;
    }

    @NotNull
    public final Map<String, Object> j() {
        return this.editTextReportParams;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final QUISearchBar getQuiSearchBar() {
        return this.quiSearchBar;
    }

    @NotNull
    public final Map<String, Object> l() {
        return this.quiSearchBarReportParams;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsReportQQEventId() {
        return this.isReportQQEventId;
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int position, @Nullable String hintText, @Nullable String reportData) {
        String str;
        this.editTextReportParams.put("literal_text", hintText);
        VideoReport.setElementId(this.editText, "em_search_grey_word");
        if (this.isReportQQEventId) {
            str = "qq_imp";
        } else {
            str = "dt_imp";
        }
        VideoReport.reportEvent(str, this.editText, this.editTextReportParams);
    }

    public final void p() {
        String str;
        String str2 = "qq_clck";
        if (Intrinsics.areEqual(this.quiSearchBarReportParams.get("is_shading"), (Object) 1)) {
            if (this.isReportQQEventId) {
                str = "qq_clck";
            } else {
                str = "dt_clck";
            }
            VideoReport.reportEvent(str, this.editText, this.editTextReportParams);
        }
        if (!this.isReportQQEventId) {
            str2 = "dt_clck";
        }
        VideoReport.reportEvent(str2, this.quiSearchBar, this.quiSearchBarReportParams);
    }

    public final void r(@Nullable ArrayList<String> arrayList) {
        this.hintWords = arrayList;
    }
}
