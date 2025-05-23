package com.tencent.mobileqq.emoticonview.report;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eJ*\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007J \u0010\u0016\u001a\u00020\f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007J \u0010\u0017\u001a\u00020\f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007J(\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012J2\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionDaTongReportHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "pageView", "Landroid/widget/FrameLayout;", "viewMap", "", "", "Landroid/view/View;", "initElement", "", "list", "", "initPage", "pageId", "params", "", "reportClick", "key", "reportExpose", "reportPageExit", "reportPageExpose", "reportPagePrivateEvent", "event", "reportPrivateEvent", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmotionDaTongReportHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "EmotionDaTongReportUtil";

    @NotNull
    private final Context mContext;

    @NotNull
    private final FrameLayout pageView;

    @NotNull
    private final Map<String, View> viewMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionDaTongReportHelper$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmotionDaTongReportHelper(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
            return;
        }
        this.mContext = mContext;
        this.pageView = new FrameLayout(mContext);
        this.viewMap = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initPage$default(EmotionDaTongReportHelper emotionDaTongReportHelper, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.initPage(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportClick$default(EmotionDaTongReportHelper emotionDaTongReportHelper, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.reportClick(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportExpose$default(EmotionDaTongReportHelper emotionDaTongReportHelper, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.reportExpose(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPageExit$default(EmotionDaTongReportHelper emotionDaTongReportHelper, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.reportPageExit(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPageExpose$default(EmotionDaTongReportHelper emotionDaTongReportHelper, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.reportPageExpose(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPagePrivateEvent$default(EmotionDaTongReportHelper emotionDaTongReportHelper, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.reportPagePrivateEvent(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPrivateEvent$default(EmotionDaTongReportHelper emotionDaTongReportHelper, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        emotionDaTongReportHelper.reportPrivateEvent(str, str2, map);
    }

    public final void initElement(@Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        for (String str : list) {
            View view = new View(this.mContext);
            this.viewMap.put(str, view);
            this.pageView.addView(view);
            VideoReport.setElementId(view, str);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
    }

    @JvmOverloads
    public final void initPage(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            initPage$default(this, str, null, 2, null);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
    }

    @JvmOverloads
    public final void reportClick(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            reportClick$default(this, key, null, 2, null);
        }
    }

    @JvmOverloads
    public final void reportExpose(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            reportExpose$default(this, key, null, 2, null);
        }
    }

    @JvmOverloads
    public final void reportPageExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            reportPageExit$default(this, null, 1, null);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @JvmOverloads
    public final void reportPageExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            reportPageExpose$default(this, null, 1, null);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public final void reportPagePrivateEvent(@Nullable String event, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event, (Object) params);
        } else {
            VideoReport.reportEvent(event, this.pageView, params);
        }
    }

    @JvmOverloads
    public final void reportPrivateEvent(@NotNull String key, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) key, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            reportPrivateEvent$default(this, key, str, null, 4, null);
        }
    }

    @JvmOverloads
    public final void initPage(@Nullable String pageId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pageId, (Object) params);
        } else {
            VideoReport.setPageId(this.pageView, pageId);
            VideoReport.setPageParams(this.pageView, new PageParams(params));
        }
    }

    @JvmOverloads
    public final void reportClick(@NotNull String key, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        View view = this.viewMap.get(key);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", view, params);
    }

    @JvmOverloads
    public final void reportExpose(@NotNull String key, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        View view = this.viewMap.get(key);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_imp", view, params);
    }

    @JvmOverloads
    public final void reportPageExit(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            VideoReport.reportEvent("dt_pgout", this.pageView, params);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) params);
        }
    }

    @JvmOverloads
    public final void reportPageExpose(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            VideoReport.reportEvent("dt_pgin", this.pageView, params);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
        }
    }

    @JvmOverloads
    public final void reportPrivateEvent(@NotNull String key, @Nullable String event, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, key, event, params);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        View view = this.viewMap.get(key);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent(event, view, params);
    }
}
