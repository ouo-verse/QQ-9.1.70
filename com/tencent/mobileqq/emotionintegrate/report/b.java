package com.tencent.mobileqq.emotionintegrate.report;

import android.view.View;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emotionintegrate.p;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ.\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000e2\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010J\u001c\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014R6\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/report/b;", "", "", "chatType", "", "d", "Landroid/view/View;", "targetView", "Lcom/tencent/mobileqq/emotionintegrate/p;", "data", "e", "", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "", "params", "b", "c", "I", "sChatType", "Ljava/util/HashMap;", "sPageParams", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f205282a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int sChatType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, Object> sPageParams;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55055);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f205282a = new b();
            sPageParams = new HashMap<>();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final HashMap<String, Object> a(@NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) elementId);
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.putAll(sPageParams);
        hashMap.put("qq_pgid", "pg_bas_expression_view_page");
        hashMap.put("qq_eid", elementId);
        return hashMap;
    }

    public final void b(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.reportEvent("qq_clck", params);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOEmotionViewerDtReport", 4, "reportClick params = " + params);
        }
    }

    public final void c(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.reportEvent("qq_imp", params);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOEmotionViewerDtReport", 4, "reportQQImp params = " + params);
        }
    }

    public final void d(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        } else {
            sChatType = chatType;
        }
    }

    public final void e(@NotNull View targetView, @NotNull p data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) targetView, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(data, "data");
        VideoReport.setPageId(targetView, "pg_bas_expression_view_page");
        VideoReport.setPageReportPolicy(targetView, PageReportPolicy.REPORT_NONE);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aio_type", Integer.valueOf(sChatType));
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, data.e());
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_SFACEID, data.d());
        hashMap.put("PicElementType", Integer.valueOf(data.i()));
        hashMap.put("emoticon_type_import_from", Integer.valueOf(c.f205285a.d(data)));
        sPageParams = hashMap;
        VideoReport.setPageParams(targetView, new PageParams(hashMap));
    }
}
