package com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.guild.base.extension.c;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayout;
import com.tencent.mobileqq.guild.homev2.views.embeddable.Report;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import cp1.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild_Home_Web", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildWebViewFragment;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildHomeSubBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onResume", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "th", "I", "Ljava/lang/String;", "categoryName", "J", "url", "Lcom/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayout;", "K", "Lcom/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayout;", "webView", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "L", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "reportData", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildWebViewFragment extends GuildHomeSubBaseFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String categoryName = "";

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String url = "";

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private WebViewFrameLayout webView;

    /* renamed from: L, reason: from kotlin metadata */
    private Report.ReportData reportData;

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        ScrollableLayout scrollableLayout = new ScrollableLayout(context, null, 0, 6, null);
        Context context2 = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "inflater.context");
        WebViewFrameLayout webViewFrameLayout = new WebViewFrameLayout(context2, null, 0, 6, null);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        webViewFrameLayout.p(viewLifecycleOwner);
        webViewFrameLayout.o(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildWebViewFragment$onCreateView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Report.ReportData reportData;
                IPerformanceReportTask uh5 = GuildWebViewFragment.this.uh();
                Boolean bool = Boolean.FALSE;
                uh5.setExtra("isMainProcessWebView", bool);
                GuildWebViewFragment.this.uh().report();
                GuildWebViewFragment.this.sh().setExtra("isMainProcessWebView", bool);
                qw1.b.n(GuildWebViewFragment.this.sh());
                d.f391542a.b(GuildWebViewFragment.this.uh());
                Report report = Report.f226086a;
                reportData = GuildWebViewFragment.this.reportData;
                if (reportData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reportData");
                    reportData = null;
                }
                report.a(reportData);
            }
        });
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Bundle bundle = arguments;
        String g16 = c.g(bundle, "EXTRA_CATEGORY_NAME");
        if (g16 == null) {
            g16 = "Unknown";
        }
        this.categoryName = g16;
        String g17 = c.g(bundle, "EXTRA_URL");
        if (g17 == null) {
            g17 = "https://registry.khronos.org/webgl/sdk/tests/webgl-conformance-tests.html";
        }
        this.url = g17;
        String g18 = c.g(bundle, "guildId");
        if (g18 == null) {
            g18 = "";
        }
        String str = g18;
        this.reportData = new Report.ReportData(this.url, this.categoryName, 2, str, null, String.valueOf(c.f(bundle, "EXTRA_CATEGORY_ID", 0L, 2, null)), null, 80, null);
        ScrollableLayout.setupView$default(scrollableLayout, webViewFrameLayout, false, 2, null);
        this.webView = webViewFrameLayout;
        WebViewFrameLayout.r(webViewFrameLayout, this.url, false, 2, null);
        scrollableLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, scrollableLayout);
        return scrollableLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Object obj;
        Object obj2;
        super.onResume();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            String str = this.url;
            WebViewFrameLayout webViewFrameLayout = this.webView;
            if (webViewFrameLayout != null) {
                obj2 = webViewFrameLayout.getTag();
            } else {
                obj2 = null;
            }
            d16.d("Guild.NewHome.subFrag.GuildWebViewFragment", 1, "onResume url:" + str + " webView?.tag:" + obj2 + " id:" + System.identityHashCode(this));
        }
        WebViewFrameLayout webViewFrameLayout2 = this.webView;
        if (webViewFrameLayout2 != null) {
            obj = webViewFrameLayout2.getTag();
        } else {
            obj = null;
        }
        if (Intrinsics.areEqual(obj, this.url)) {
            return;
        }
        WebViewFrameLayout webViewFrameLayout3 = this.webView;
        if (webViewFrameLayout3 != null) {
            webViewFrameLayout3.setTag(this.url);
        }
        WebViewFrameLayout webViewFrameLayout4 = this.webView;
        if (webViewFrameLayout4 != null) {
            WebViewFrameLayout.r(webViewFrameLayout4, this.url, false, 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Report report = Report.f226086a;
        Report.ReportData reportData = this.reportData;
        if (reportData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportData");
            reportData = null;
        }
        report.b(reportData);
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment
    @NotNull
    public String th() {
        return "Guild.NewHome.subFrag.GuildWebViewFragment";
    }
}
