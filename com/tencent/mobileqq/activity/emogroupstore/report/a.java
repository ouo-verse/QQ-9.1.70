package com.tencent.mobileqq.activity.emogroupstore.report;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007J\u0016\u0010\u000b\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u0002J \u0010\u0010\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007J \u0010\u0011\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007J(\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/report/a;", "", "", "b", "", "pageId", "", "params", "c", "", "list", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "g", h.F, "k", "i", "key", "e", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "pageView", "", "Landroid/view/View;", "Ljava/util/Map;", "viewMap", "<init>", "(Landroid/content/Context;)V", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f182172e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f182173f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String f182174g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f182175h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout pageView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, View> viewMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/report/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.emogroupstore.report.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        INSTANCE = new Companion(null);
        f182172e = "pg_bas_group_chat_emoji_management";
        f182173f = "em_bas_emoji";
        f182174g = "em_bas_filter";
        f182175h = QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID;
    }

    public a(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
            return;
        }
        this.mContext = mContext;
        this.pageView = new FrameLayout(mContext);
        this.viewMap = new HashMap();
        d(this, f182172e, null, 2, null);
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(a aVar, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        aVar.c(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(a aVar, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        aVar.e(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(a aVar, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = null;
        }
        aVar.i(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(a aVar, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = null;
        }
        aVar.k(map);
    }

    public final void a(@Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
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

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(f182173f);
        arrayList.add(f182174g);
        a(arrayList);
    }

    @JvmOverloads
    public final void c(@Nullable String pageId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pageId, (Object) params);
        } else {
            VideoReport.setPageId(this.pageView, pageId);
            VideoReport.setPageParams(this.pageView, new PageParams(params));
        }
    }

    @JvmOverloads
    public final void e(@NotNull String key, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        View view = this.viewMap.get(key);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", view, params);
    }

    public final void g(@Nullable MsgElement msgElement) {
        MarketFaceElement marketFaceElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgElement);
            return;
        }
        if (msgElement != null) {
            marketFaceElement = msgElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        if (marketFaceElement != null && msgElement != null) {
            MarketFaceElement marketFaceElement2 = msgElement.marketFaceElement;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(f182175h, "0");
        e(f182173f, hashMap);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f(this, f182174g, null, 2, null);
        }
    }

    @JvmOverloads
    public final void i(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) params);
        } else {
            VideoReport.reportEvent("dt_pgout", this.pageView, params);
        }
    }

    @JvmOverloads
    public final void k(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) params);
        } else {
            VideoReport.reportEvent("dt_pgin", this.pageView, params);
        }
    }
}
