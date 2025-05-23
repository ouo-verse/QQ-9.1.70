package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.widget.DiscoveryWebViewFrameLayout;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/WebContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "G9", "", "url", "F9", "I9", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetConfigTabContentRsp;", "loadState", "K9", "L9", "H9", "refresh", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryWebViewFrameLayout;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryWebViewFrameLayout;", "webViewLayout", "e", "Ljava/lang/String;", "currentUrl", "Landroid/view/View;", "f", "Landroid/view/View;", "errorLayout", "", tl.h.F, "Z", "hasError", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class WebContentPart extends Part {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DiscoveryWebViewFrameLayout webViewLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentUrl = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View errorLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasError;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/WebContentPart$a;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "refresh", "Landroid/view/View;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 function0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (function0 != null) {
                function0.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @NotNull
        public final View b(@NotNull Context context, @Nullable final Function0<Unit> refresh) {
            Intrinsics.checkNotNullParameter(context, "context");
            QUIEmptyState.Builder builder = new QUIEmptyState.Builder(context);
            builder.setThemeType(0);
            builder.setHalfScreenState(false);
            builder.setAutoCenter(true);
            String string = context.getString(R.string.f152871ak);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_reload)");
            builder.setButton(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebContentPart.Companion.c(Function0.this, view);
                }
            });
            builder.setImageType(5);
            builder.setTitle("\u7f51\u7edc\u5f02\u5e38");
            String string2 = context.getString(R.string.f2070459y);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026qq_video_play_error_hint)");
            builder.setDesc(string2);
            QUIEmptyState build = builder.build();
            ImageView imageView = (ImageView) build.findViewById(R.id.uuj);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.guild_net_error);
            }
            return build;
        }

        Companion() {
        }
    }

    private final void E9() {
        ScrollableLayout scrollableLayout;
        Context context = getPartRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout = new DiscoveryWebViewFrameLayout(context, null, 0, 6, null);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        discoveryWebViewFrameLayout.q(lifecycleOwner);
        this.webViewLayout = discoveryWebViewFrameLayout;
        View partRootView = getPartRootView();
        if (partRootView instanceof ScrollableLayout) {
            scrollableLayout = (ScrollableLayout) partRootView;
        } else {
            scrollableLayout = null;
        }
        if (scrollableLayout != null) {
            ScrollableLayout.setupView$default(scrollableLayout, discoveryWebViewFrameLayout, false, 2, null);
        }
        discoveryWebViewFrameLayout.o(new Function3<String, Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart$createWebView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
                invoke(str, num.intValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String url, int i3, @NotNull String errorMsg) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Logger logger = Logger.f235387a;
                WebContentPart webContentPart = WebContentPart.this;
                logger.d().d("WebContentPart", 1, "[onLoadFailed](" + i3 + ", " + errorMsg + ") loadUrl " + url + ", currentUrl: " + webContentPart.currentUrl);
                WebContentPart.this.L9();
            }
        });
        discoveryWebViewFrameLayout.p(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart$createWebView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                Logger logger = Logger.f235387a;
                WebContentPart webContentPart = WebContentPart.this;
                logger.d().d("WebContentPart", 1, "[onLoadSuccess] loadUrl " + url + ", currentUrl: " + webContentPart.currentUrl);
                WebContentPart.this.H9();
            }
        });
    }

    private final void F9(String url) {
        boolean isBlank;
        Logger.f235387a.d().d("WebContentPart", 1, "[doLoadUrl] url " + url + ", currentUrl " + this.currentUrl);
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            L9();
            return;
        }
        if (!Intrinsics.areEqual(this.currentUrl, url)) {
            this.currentUrl = url;
            DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout = this.webViewLayout;
            if (discoveryWebViewFrameLayout != null) {
                DiscoveryWebViewFrameLayout.t(discoveryWebViewFrameLayout, url, false, 2, null);
            }
        }
    }

    private final void G9() {
        TabViewModel.LoadState<IGProGetConfigTabContentRsp> loadState;
        MutableLiveData<TabViewModel.LoadState<IGProGetConfigTabContentRsp>> R1;
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        Integer num = null;
        if (tabViewModel != null && (R1 = tabViewModel.R1()) != null) {
            loadState = R1.getValue();
        } else {
            loadState = null;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (loadState != null) {
            num = Integer.valueOf(loadState.getStatus());
        }
        d16.d("WebContentPart", 1, "[fetchUrl] currentState " + num);
        if (loadState == null) {
            if (tabViewModel != null) {
                tabViewModel.b2();
            }
        } else if (loadState.getStatus() == 1) {
            K9(loadState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout = this.webViewLayout;
        if (!(discoveryWebViewFrameLayout instanceof ViewGroup)) {
            discoveryWebViewFrameLayout = null;
        }
        if (discoveryWebViewFrameLayout != null) {
            discoveryWebViewFrameLayout.removeView(this.errorLayout);
        }
        this.errorLayout = null;
    }

    private final void I9() {
        MutableLiveData<TabViewModel.LoadState<IGProGetConfigTabContentRsp>> R1;
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        if (tabViewModel != null && (R1 = tabViewModel.R1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<TabViewModel.LoadState<IGProGetConfigTabContentRsp>, Unit> function1 = new Function1<TabViewModel.LoadState<IGProGetConfigTabContentRsp>, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart$observeViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TabViewModel.LoadState<IGProGetConfigTabContentRsp> loadState) {
                    invoke2(loadState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TabViewModel.LoadState<IGProGetConfigTabContentRsp> it) {
                    Logger.f235387a.d().d("WebContentPart", 1, "[observeViewModel] configTabLoadState " + it.getStatus());
                    WebContentPart webContentPart = WebContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    webContentPart.K9(it);
                }
            };
            R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WebContentPart.J9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r3 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K9(TabViewModel.LoadState<IGProGetConfigTabContentRsp> loadState) {
        String str;
        ArrayList<IGProRecommendContentItem> h5kuiklyConfigList;
        Object firstOrNull;
        IGProContentRecommendH5Kuikly h5kuikly;
        String jumpUrl;
        CharSequence trim;
        int status = loadState.getStatus();
        if (status != 1) {
            if (status == 2) {
                L9();
                return;
            }
            return;
        }
        IGProGetConfigTabContentRsp a16 = loadState.a();
        if (a16 != null && (h5kuiklyConfigList = a16.getH5kuiklyConfigList()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) h5kuiklyConfigList);
            IGProRecommendContentItem iGProRecommendContentItem = (IGProRecommendContentItem) firstOrNull;
            if (iGProRecommendContentItem != null && (h5kuikly = iGProRecommendContentItem.getH5kuikly()) != null && (jumpUrl = h5kuikly.getJumpUrl()) != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) jumpUrl);
                str = trim.toString();
            }
        }
        str = "";
        F9(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        if (this.errorLayout == null) {
            Companion companion = INSTANCE;
            Context context = getPartRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            this.errorLayout = companion.b(context, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart$showErrorPage$1
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
                    WebContentPart.this.refresh();
                }
            });
        }
        View view = this.errorLayout;
        if (view == null) {
            return;
        }
        boolean z16 = true;
        this.hasError = true;
        DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout = this.webViewLayout;
        if (discoveryWebViewFrameLayout != null) {
            discoveryWebViewFrameLayout.r();
        }
        DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout2 = this.webViewLayout;
        if (!(discoveryWebViewFrameLayout2 instanceof ViewGroup)) {
            discoveryWebViewFrameLayout2 = null;
        }
        if (discoveryWebViewFrameLayout2 == null) {
            return;
        }
        if (discoveryWebViewFrameLayout2.indexOfChild(view) == -1) {
            z16 = false;
        }
        if (!z16) {
            discoveryWebViewFrameLayout2.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        H9();
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        this.currentUrl = "";
        this.hasError = false;
        DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout = this.webViewLayout;
        if (discoveryWebViewFrameLayout != null) {
            discoveryWebViewFrameLayout.v();
        }
        if (tabViewModel != null) {
            tabViewModel.b2();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        E9();
        I9();
        G9();
    }
}
