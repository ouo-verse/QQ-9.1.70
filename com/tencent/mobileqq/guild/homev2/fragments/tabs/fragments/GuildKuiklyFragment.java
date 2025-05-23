package com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.util.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.home.views.embeddable.KuiklyFrameLayout;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.ScrollableContainer;
import com.tencent.mobileqq.guild.homev2.views.embeddable.Report;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.argus.node.ArgusTag;
import cooperation.qzone.QzoneIPCModule;
import cp1.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild_Home_Kuikly", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001fR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildKuiklyFragment;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildHomeSubBaseFragment;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer$a;", "", "Eh", "Dh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onGlobalLayout", "Landroid/view/MotionEvent;", "ev", "onTouchEvent", "", "th", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer;", "I", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/ScrollableContainer;", TtmlNode.TAG_LAYOUT, "Lcom/tencent/mobileqq/guild/home/views/embeddable/KuiklyFrameLayout;", "J", "Lcom/tencent/mobileqq/guild/home/views/embeddable/KuiklyFrameLayout;", "kuiklyLayout", "K", "previousWidthDp", "L", "previousHeightDp", "Lmqq/os/MqqHandler;", "M", "Lmqq/os/MqqHandler;", "mMainHandler", "", "N", "lastNotifyTs", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "P", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "reportData", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildKuiklyFragment extends GuildHomeSubBaseFragment implements ViewTreeObserver.OnGlobalLayoutListener, ScrollableContainer.a {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ScrollableContainer layout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private KuiklyFrameLayout kuiklyLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private int previousWidthDp;

    /* renamed from: L, reason: from kotlin metadata */
    private int previousHeightDp;

    /* renamed from: M, reason: from kotlin metadata */
    private MqqHandler mMainHandler;

    /* renamed from: N, reason: from kotlin metadata */
    private long lastNotifyTs;

    /* renamed from: P, reason: from kotlin metadata */
    private Report.ReportData reportData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildKuiklyFragment$b", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends MqqHandler {
        b() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            g mKuiklyRenderView;
            Map<String, ? extends Object> mapOf;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1) {
                int[] iArr = new int[2];
                KuiklyFrameLayout kuiklyFrameLayout = GuildKuiklyFragment.this.kuiklyLayout;
                if (kuiklyFrameLayout != null) {
                    kuiklyFrameLayout.getLocationOnScreen(iArr);
                }
                int screenWidth = ViewUtils.getScreenWidth() - iArr[0];
                int screenHeight = ViewUtils.getScreenHeight() - iArr[1];
                if (ScreenUtil.checkNavigationBarShow(GuildKuiklyFragment.this.getContext())) {
                    screenHeight -= ScreenUtil.getNavigationBarHeight(GuildKuiklyFragment.this.getContext());
                }
                int a16 = c.a(screenWidth);
                int a17 = c.a(screenHeight);
                if (a16 != GuildKuiklyFragment.this.previousWidthDp || a17 != GuildKuiklyFragment.this.previousHeightDp) {
                    GuildKuiklyFragment.this.previousWidthDp = a16;
                    GuildKuiklyFragment.this.previousHeightDp = a17;
                    QLog.d("Guild.NewHome.subFrag.GuildKuiklyFragment", 1, "send visibleSizeChange event: width=" + GuildKuiklyFragment.this.previousWidthDp + ", height=" + GuildKuiklyFragment.this.previousHeightDp);
                    KuiklyFrameLayout kuiklyFrameLayout2 = GuildKuiklyFragment.this.kuiklyLayout;
                    if (kuiklyFrameLayout2 != null && (mKuiklyRenderView = kuiklyFrameLayout2.getMKuiklyRenderView()) != null) {
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("width", Integer.valueOf(GuildKuiklyFragment.this.previousWidthDp)), TuplesKt.to("height", Integer.valueOf(GuildKuiklyFragment.this.previousHeightDp)));
                        mKuiklyRenderView.sentEvent("notifyKuiklyChangeVisibleSize", mapOf);
                    }
                }
            }
        }
    }

    private final void Dh() {
        this.mMainHandler = new b();
    }

    private final void Eh() {
        if (System.currentTimeMillis() - this.lastNotifyTs >= 16 && isResumed()) {
            this.lastNotifyTs = System.currentTimeMillis();
            MqqHandler mqqHandler = this.mMainHandler;
            if (mqqHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler = null;
            }
            mqqHandler.sendEmptyMessage(1);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        KuiklyFrameLayout kuiklyFrameLayout = this.kuiklyLayout;
        if (kuiklyFrameLayout != null) {
            kuiklyFrameLayout.j(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        ScrollableContainer scrollableContainer = new ScrollableContainer(context);
        scrollableContainer.setChildHandleDispatchTouchEvent(true);
        this.layout = scrollableContainer;
        Context context2 = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "inflater.context");
        this.kuiklyLayout = new KuiklyFrameLayout(context2, null, 0, 6, null);
        String g16 = com.tencent.mobileqq.guild.base.extension.c.g(getArguments(), "EXTRA_URL");
        if (g16 == null) {
            g16 = "";
        }
        String g17 = com.tencent.mobileqq.guild.base.extension.c.g(getArguments(), "EXTRA_CATEGORY_NAME");
        if (g17 == null) {
            g17 = "Unknown";
        }
        String g18 = com.tencent.mobileqq.guild.base.extension.c.g(getArguments(), "guildId");
        if (g18 == null) {
            str = "";
        } else {
            str = g18;
        }
        String str2 = g16;
        String str3 = g17;
        Report.ReportData reportData = new Report.ReportData(str2, str3, 1, str, null, String.valueOf(com.tencent.mobileqq.guild.base.extension.c.f(getArguments(), "EXTRA_CATEGORY_ID", 0L, 2, null)), null, 80, null);
        this.reportData = reportData;
        Report.f226086a.b(reportData);
        KuiklyFrameLayout kuiklyFrameLayout = this.kuiklyLayout;
        Intrinsics.checkNotNull(kuiklyFrameLayout);
        kuiklyFrameLayout.g(g16, g17);
        KuiklyFrameLayout kuiklyFrameLayout2 = this.kuiklyLayout;
        if (kuiklyFrameLayout2 != null) {
            kuiklyFrameLayout2.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildKuiklyFragment$onCreateView$2
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
                    Report.ReportData reportData2;
                    Report report = Report.f226086a;
                    reportData2 = GuildKuiklyFragment.this.reportData;
                    if (reportData2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("reportData");
                        reportData2 = null;
                    }
                    report.a(reportData2);
                    GuildKuiklyFragment.this.uh().report();
                    d.f391542a.b(GuildKuiklyFragment.this.uh());
                    qw1.b.n(GuildKuiklyFragment.this.sh());
                }
            });
        }
        ScrollableContainer scrollableContainer2 = this.layout;
        if (scrollableContainer2 != null) {
            scrollableContainer2.setNestedTouchListener(this);
        }
        ScrollableContainer scrollableContainer3 = this.layout;
        if (scrollableContainer3 != null) {
            KuiklyFrameLayout kuiklyFrameLayout3 = this.kuiklyLayout;
            Intrinsics.checkNotNull(kuiklyFrameLayout3);
            ScrollableLayout.setupView$default(scrollableContainer3, kuiklyFrameLayout3, false, 2, null);
        }
        ScrollableContainer scrollableContainer4 = this.layout;
        if (scrollableContainer4 != null) {
            scrollableContainer4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        Dh();
        ScrollableContainer scrollableContainer5 = this.layout;
        Intrinsics.checkNotNull(scrollableContainer5);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, scrollableContainer5);
        return scrollableContainer5;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        KuiklyFrameLayout kuiklyFrameLayout = this.kuiklyLayout;
        if (kuiklyFrameLayout != null) {
            kuiklyFrameLayout.k();
        }
        ScrollableContainer scrollableContainer = this.layout;
        if (scrollableContainer != null) {
            scrollableContainer.setNestedTouchListener(null);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Eh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        super.onPause();
        KuiklyFrameLayout kuiklyFrameLayout = this.kuiklyLayout;
        if (kuiklyFrameLayout != null) {
            kuiklyFrameLayout.m();
        }
        KuiklyFrameLayout kuiklyFrameLayout2 = this.kuiklyLayout;
        if (kuiklyFrameLayout2 != null && (viewTreeObserver = kuiklyFrameLayout2.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewTreeObserver viewTreeObserver;
        super.onResume();
        KuiklyFrameLayout kuiklyFrameLayout = this.kuiklyLayout;
        if (kuiklyFrameLayout != null) {
            kuiklyFrameLayout.n();
        }
        KuiklyFrameLayout kuiklyFrameLayout2 = this.kuiklyLayout;
        if (kuiklyFrameLayout2 != null && (viewTreeObserver = kuiklyFrameLayout2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.ScrollableContainer.a
    public void onTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Eh();
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment
    @NotNull
    public String th() {
        return "Guild.NewHome.subFrag.GuildKuiklyFragment";
    }
}
