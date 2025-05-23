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
import com.tencent.mobileqq.guild.discoveryv2.parts.MainProcessWebContentPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.widget.webview.DiscoverNestedWebView;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u001a\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/MainProcessWebContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "", "url", "D9", "I9", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetConfigTabContentRsp;", "loadState", "K9", "L9", "F9", "refresh", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/webview/DiscoverNestedWebView;", "newWebView", "C9", "", "code", "errorMsg", "G9", "H9", "d", "Ljava/lang/String;", "currentUrl", "Landroid/view/View;", "e", "Landroid/view/View;", "errorLayout", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/webview/DiscoverNestedWebView;", "webview", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MainProcessWebContentPart extends Part {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentUrl = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View errorLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DiscoverNestedWebView webview;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/MainProcessWebContentPart$a;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "refresh", "Landroid/view/View;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.MainProcessWebContentPart$a, reason: from kotlin metadata */
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
            builder.setButton(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainProcessWebContentPart.Companion.c(Function0.this, view);
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

    private final void D9(String url) {
        boolean isBlank;
        DiscoverNestedWebView discoverNestedWebView;
        Logger.f235387a.d().d("MainProcessWebContentPart", 1, "[doLoadUrl] url " + url + ", currentUrl " + this.currentUrl);
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            L9();
            return;
        }
        if (!Intrinsics.areEqual(this.currentUrl, url) && (discoverNestedWebView = this.webview) != null) {
            this.currentUrl = url;
            if (discoverNestedWebView != null) {
                discoverNestedWebView.loadUrl(url);
            }
        }
    }

    private final void E9() {
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
        d16.d("MainProcessWebContentPart", 1, "[fetchUrl] currentState " + num);
        if (loadState == null) {
            if (tabViewModel != null) {
                tabViewModel.b2();
            }
        } else if (loadState.getStatus() == 1) {
            K9(loadState);
        }
    }

    private final void F9() {
        ViewGroup viewGroup;
        View view = this.errorLayout;
        if (view != null) {
            View partRootView = getPartRootView();
            if (partRootView instanceof ViewGroup) {
                viewGroup = (ViewGroup) partRootView;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.errorLayout = null;
    }

    private final void I9() {
        MutableLiveData<TabViewModel.LoadState<IGProGetConfigTabContentRsp>> R1;
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        if (tabViewModel != null && (R1 = tabViewModel.R1()) != null) {
            LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
            final Function1<TabViewModel.LoadState<IGProGetConfigTabContentRsp>, Unit> function1 = new Function1<TabViewModel.LoadState<IGProGetConfigTabContentRsp>, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.MainProcessWebContentPart$observeViewModel$1
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
                    Logger.f235387a.d().d("MainProcessWebContentPart", 1, "[observeViewModel] configTabLoadState " + it.getStatus());
                    MainProcessWebContentPart mainProcessWebContentPart = MainProcessWebContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mainProcessWebContentPart.K9(it);
                }
            };
            R1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MainProcessWebContentPart.J9(Function1.this, obj);
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
        D9(str);
    }

    private final void L9() {
        ViewGroup viewGroup;
        boolean z16;
        if (this.errorLayout == null) {
            Companion companion = INSTANCE;
            Context context = getPartRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            this.errorLayout = companion.b(context, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.MainProcessWebContentPart$showErrorPage$1
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
                    MainProcessWebContentPart.this.refresh();
                }
            });
        }
        View view = this.errorLayout;
        if (view == null) {
            return;
        }
        View partRootView = getPartRootView();
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup.indexOfChild(view) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            viewGroup.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        F9();
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        this.currentUrl = "";
        if (tabViewModel != null) {
            tabViewModel.b2();
        }
    }

    public final void C9(@Nullable DiscoverNestedWebView newWebView) {
        boolean z16;
        ScrollableLayout scrollableLayout;
        Logger.a d16 = Logger.f235387a.d();
        if (newWebView != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("MainProcessWebContentPart", 1, "[attachWebView] " + z16);
        this.webview = newWebView;
        if (newWebView != null) {
            View partRootView = getPartRootView();
            if (partRootView instanceof ScrollableLayout) {
                scrollableLayout = (ScrollableLayout) partRootView;
            } else {
                scrollableLayout = null;
            }
            if (scrollableLayout != null) {
                scrollableLayout.setupView(newWebView, false);
            }
        }
        E9();
    }

    public final void G9(@Nullable String url, int code, @Nullable String errorMsg) {
        Logger.f235387a.d().d("MainProcessWebContentPart", 1, "[onLoadFailed](" + code + ", " + errorMsg + ") loadUrl " + url + ", currentUrl: " + this.currentUrl);
        L9();
    }

    public final void H9(@Nullable String url) {
        Logger.f235387a.d().d("MainProcessWebContentPart", 1, "[onLoadSuccess] loadUrl " + url + ", currentUrl: " + this.currentUrl);
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Logger.f235387a.d().d("MainProcessWebContentPart", 1, "[onPartCreate] ");
        I9();
        E9();
    }
}
