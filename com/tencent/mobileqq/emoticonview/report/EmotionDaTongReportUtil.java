package com.tencent.mobileqq.emoticonview.report;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(J2\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00042\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(H\u0007J2\u0010-\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00042\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(H\u0007J(\u0010.\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(J(\u0010/\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(J*\u00100\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(H\u0007J\u0018\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u00010&2\u0006\u00103\u001a\u00020\u0004J\u0018\u00104\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u00010&2\u0006\u00103\u001a\u00020\u0004J\u0010\u00105\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J&\u00105\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00042\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(J\u0016\u00106\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionDaTongReportUtil;", "", "()V", "EM_BAS_AI_EXPRESSION", "", "EM_BAS_BANNER", "EM_BAS_EMOTE_MANAGE", "EM_BAS_EMOTICON_MALL", "EM_BAS_EMOTICON_SEARCH_RESULTS", "EM_BAS_EXPRESSION_SEARCH_BOX", "EM_BAS_MORE_OPTIONS_BTN", "EM_BAS_SEARCH_FOR_RECOMMENDATION_WORDS", "EM_BAS_SEARCH_RESULTS_PLATE", "EM_BAS_WORD_MODULE", "EM_PARAMS_APP_LOCATION", "EM_PARAMS_CONTAINS_SYNTHETIC", "EM_PARAMS_EMOJI_TAB_TYPE", "EM_PARAMS_QUERY", "EM_PARAMS_SEARCH_QUERY_TEXT", "EM_PARAMS_SFACEID", "EM_PARAMS_TAB_TYPE", "EM_TAB_BTN", "PG_BAS_EMOJI_SEARCH_RESULTS", "PG_BAS_HEAT_MAP", "PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH", "PG_PARAMS_TRACEID", "QQ_CLICK", "QQ_EMID", "QQ_PGID", "TAG", "VALUE_CONTAINS_SYNTHETIC_FALSE", "", "VALUE_CONTAINS_SYNTHETIC_TRUE", "VALUE_EMO_TYPE_COMPOSITE", "VALUE_EMO_TYPE_NORMAL", "reportClick", "", "view", "Landroid/view/View;", "params", "", "reportElementClick", "emotionDaTongReportHelper", "Lcom/tencent/mobileqq/emoticonview/report/EmotionDaTongReportHelper;", "elementId", "reportElementExpose", "reportImp", "reportImpEnd", "reportPageExpose", "reportPageIn", "pageView", "pageId", "reportPageOut", "reportQQClick", "setElementId", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmotionDaTongReportUtil {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String EM_BAS_AI_EXPRESSION = "em_bas_ai_expression";

    @NotNull
    public static final String EM_BAS_BANNER = "em_bas_banner";

    @NotNull
    public static final String EM_BAS_EMOTE_MANAGE = "em_bas_emote_manage";

    @NotNull
    public static final String EM_BAS_EMOTICON_MALL = "em_bas_emoticon_mall";

    @NotNull
    public static final String EM_BAS_EMOTICON_SEARCH_RESULTS = "em_bas_emoticon_search_results";

    @NotNull
    public static final String EM_BAS_EXPRESSION_SEARCH_BOX = "em_bas_expression_search_box";

    @NotNull
    public static final String EM_BAS_MORE_OPTIONS_BTN = "em_bas_more_options_btn";

    @NotNull
    public static final String EM_BAS_SEARCH_FOR_RECOMMENDATION_WORDS = "em_bas_search_for_recommendation_words";

    @NotNull
    public static final String EM_BAS_SEARCH_RESULTS_PLATE = "em_bas_search_results_plate";

    @NotNull
    public static final String EM_BAS_WORD_MODULE = "em_bas_hot_word_module";

    @NotNull
    public static final String EM_PARAMS_APP_LOCATION = "app_location";

    @NotNull
    public static final String EM_PARAMS_CONTAINS_SYNTHETIC = "is_contains_synthetic_expressions";

    @NotNull
    public static final String EM_PARAMS_EMOJI_TAB_TYPE = "emoji_tab_type";

    @NotNull
    public static final String EM_PARAMS_QUERY = "query";

    @NotNull
    public static final String EM_PARAMS_SEARCH_QUERY_TEXT = "search_query_text";

    @NotNull
    public static final String EM_PARAMS_SFACEID = "sFaceID";

    @NotNull
    public static final String EM_PARAMS_TAB_TYPE = "tab_type";

    @NotNull
    public static final String EM_TAB_BTN = "em_tab_btn";

    @NotNull
    public static final EmotionDaTongReportUtil INSTANCE;

    @NotNull
    public static final String PG_BAS_EMOJI_SEARCH_RESULTS = "pg_bas_emoji_search_results";

    @NotNull
    public static final String PG_BAS_HEAT_MAP = "pg_bas_heat_map";

    @NotNull
    public static final String PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH = "pg_bas_magnifying_glass_emoji_search";

    @NotNull
    public static final String PG_PARAMS_TRACEID = "traceid";

    @NotNull
    public static final String QQ_CLICK = "qq_clck";

    @NotNull
    public static final String QQ_EMID = "qq_eid";

    @NotNull
    public static final String QQ_PGID = "qq_pgid";

    @NotNull
    public static final String TAG = "EmotionDaTongReportUtil";
    public static final int VALUE_CONTAINS_SYNTHETIC_FALSE = 0;
    public static final int VALUE_CONTAINS_SYNTHETIC_TRUE = 1;
    public static final int VALUE_EMO_TYPE_COMPOSITE = 2;
    public static final int VALUE_EMO_TYPE_NORMAL = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new EmotionDaTongReportUtil();
        }
    }

    EmotionDaTongReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportClick$default(EmotionDaTongReportUtil emotionDaTongReportUtil, View view, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportClick(view, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportElementClick$default(EmotionDaTongReportUtil emotionDaTongReportUtil, EmotionDaTongReportHelper emotionDaTongReportHelper, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportElementClick(emotionDaTongReportHelper, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportElementExpose$default(EmotionDaTongReportUtil emotionDaTongReportUtil, EmotionDaTongReportHelper emotionDaTongReportHelper, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportElementExpose(emotionDaTongReportHelper, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportImp$default(EmotionDaTongReportUtil emotionDaTongReportUtil, View view, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportImp(view, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportImpEnd$default(EmotionDaTongReportUtil emotionDaTongReportUtil, View view, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportImpEnd(view, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPageExpose$default(EmotionDaTongReportUtil emotionDaTongReportUtil, EmotionDaTongReportHelper emotionDaTongReportHelper, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportPageExpose(emotionDaTongReportHelper, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportQQClick$default(EmotionDaTongReportUtil emotionDaTongReportUtil, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportUtil.reportQQClick(str, map);
    }

    public final void reportClick(@Nullable View view, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) params);
        } else if (view != null) {
            VideoReport.reportEvent("dt_clck", view, params);
        }
    }

    @JvmOverloads
    public final void reportElementClick(@Nullable EmotionDaTongReportHelper emotionDaTongReportHelper, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) emotionDaTongReportHelper, (Object) elementId);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            reportElementClick$default(this, emotionDaTongReportHelper, elementId, null, 4, null);
        }
    }

    @JvmOverloads
    public final void reportElementExpose(@Nullable EmotionDaTongReportHelper emotionDaTongReportHelper, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) emotionDaTongReportHelper, (Object) elementId);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            reportElementExpose$default(this, emotionDaTongReportHelper, elementId, null, 4, null);
        }
    }

    public final void reportImp(@Nullable View view, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) params);
        } else if (view != null) {
            VideoReport.reportEvent("dt_imp", view, params);
        }
    }

    public final void reportImpEnd(@Nullable View view, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) params);
        } else if (view != null) {
            VideoReport.reportEvent("dt_imp_end", view, params);
        }
    }

    @JvmOverloads
    public final void reportPageExpose(@Nullable EmotionDaTongReportHelper emotionDaTongReportHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            reportPageExpose$default(this, emotionDaTongReportHelper, null, 2, null);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) emotionDaTongReportHelper);
        }
    }

    public final void reportPageIn(@Nullable View pageView, @NotNull String pageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pageView, (Object) pageId);
            return;
        }
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (pageView == null) {
            return;
        }
        VideoReport.setPageId(pageView, pageId);
        VideoReport.setPageReportPolicy(pageView, PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgIn(pageView);
    }

    public final void reportPageOut(@Nullable View pageView, @NotNull String pageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pageView, (Object) pageId);
            return;
        }
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (pageView == null) {
            return;
        }
        VideoReport.setPageId(pageView, pageId);
        VideoReport.setPageReportPolicy(pageView, PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgOut(pageView);
    }

    public final void reportQQClick(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view != null) {
            VideoReport.reportEvent("qq_clck", view, null);
        }
    }

    public final void setElementId(@NotNull View view, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    @JvmOverloads
    public final void reportElementClick(@Nullable EmotionDaTongReportHelper emotionDaTongReportHelper, @NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, emotionDaTongReportHelper, elementId, params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (emotionDaTongReportHelper == null) {
            QLog.e("EmotionDaTongReportUtil", 1, "reportElementClick " + elementId + " is error! mEmotionDaTongReportUtil is null!");
            return;
        }
        emotionDaTongReportHelper.reportClick(elementId, params);
    }

    @JvmOverloads
    public final void reportElementExpose(@Nullable EmotionDaTongReportHelper emotionDaTongReportHelper, @NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, emotionDaTongReportHelper, elementId, params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (emotionDaTongReportHelper == null) {
            QLog.e("EmotionDaTongReportUtil", 1, "reportElementExpose " + elementId + " is error! mEmotionDaTongReportUtil is null!");
            return;
        }
        emotionDaTongReportHelper.reportExpose(elementId, params);
    }

    @JvmOverloads
    public final void reportPageExpose(@Nullable EmotionDaTongReportHelper emotionDaTongReportHelper, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emotionDaTongReportHelper, (Object) params);
        } else if (emotionDaTongReportHelper == null) {
            QLog.e("EmotionDaTongReportUtil", 1, "reportPageExpose is error! mEmotionDaTongReportUtil is null!");
        } else {
            emotionDaTongReportHelper.reportPageExpose(params);
        }
    }

    public final void reportQQClick(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Map<String, Object> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) elementId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null && (map = pageInfo.pageParams) != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.put("qq_pgid", PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH);
        linkedHashMap.put("qq_eid", elementId);
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        VideoReport.reportEvent("qq_clck", linkedHashMap);
    }
}
