package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.discoveryv2.parts.WebContentPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.widget.DiscoveryKuiklyFrameLayout;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/KuiklyContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "G9", "", "url", "F9", "I9", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetConfigTabContentRsp;", "loadState", "K9", "L9", "H9", "refresh", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartDestroy", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryKuiklyFrameLayout;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryKuiklyFrameLayout;", "kuiklyFrameLayout", "e", "Ljava/lang/String;", "currentUrl", "Landroid/view/View;", "f", "Landroid/view/View;", "errorLayout", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class KuiklyContentPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DiscoveryKuiklyFrameLayout kuiklyFrameLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentUrl = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View errorLayout;

    private final void E9() {
        ScrollableLayout scrollableLayout;
        Context context = getPartRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = new DiscoveryKuiklyFrameLayout(context, null, 0, 6, null);
        this.kuiklyFrameLayout = discoveryKuiklyFrameLayout;
        View partRootView = getPartRootView();
        if (partRootView instanceof ScrollableLayout) {
            scrollableLayout = (ScrollableLayout) partRootView;
        } else {
            scrollableLayout = null;
        }
        if (scrollableLayout != null) {
            ScrollableLayout.setupView$default(scrollableLayout, discoveryKuiklyFrameLayout, false, 2, null);
        }
        discoveryKuiklyFrameLayout.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.KuiklyContentPart$createWebView$1
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
                Logger.f235387a.d().d("KuiklyContentPart", 1, "[createWebView] onLoadFailed");
                KuiklyContentPart.this.L9();
            }
        });
        discoveryKuiklyFrameLayout.g(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.KuiklyContentPart$createWebView$2
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
                Logger.f235387a.d().d("KuiklyContentPart", 1, "[createWebView] onLoadSuccess");
                KuiklyContentPart.this.H9();
            }
        });
    }

    private final void F9(String url) {
        boolean isBlank;
        Logger.f235387a.d().d("KuiklyContentPart", 1, "[doLoadUrl] url " + url + ", currentUrl " + this.currentUrl);
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            L9();
            return;
        }
        if (!Intrinsics.areEqual(this.currentUrl, url)) {
            this.currentUrl = url;
            DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = this.kuiklyFrameLayout;
            if (discoveryKuiklyFrameLayout != null) {
                discoveryKuiklyFrameLayout.h(url, "");
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
        d16.d("KuiklyContentPart", 1, "[fetchUrl] currentState " + num);
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
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = this.kuiklyFrameLayout;
        if (!(discoveryKuiklyFrameLayout instanceof ViewGroup)) {
            discoveryKuiklyFrameLayout = null;
        }
        if (discoveryKuiklyFrameLayout != null) {
            discoveryKuiklyFrameLayout.removeView(this.errorLayout);
        }
        this.errorLayout = null;
    }

    private final void I9() {
        MutableLiveData<TabViewModel.LoadState<IGProGetConfigTabContentRsp>> R1;
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        if (tabViewModel != null && (R1 = tabViewModel.R1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<TabViewModel.LoadState<IGProGetConfigTabContentRsp>, Unit> function1 = new Function1<TabViewModel.LoadState<IGProGetConfigTabContentRsp>, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.KuiklyContentPart$observeViewModel$1
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
                    Logger.f235387a.d().d("KuiklyContentPart", 1, "[observeViewModel] configTabLoadState " + it.getStatus());
                    KuiklyContentPart kuiklyContentPart = KuiklyContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    kuiklyContentPart.K9(it);
                }
            };
            R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    KuiklyContentPart.J9(Function1.this, obj);
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
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout;
        boolean z16;
        if (this.errorLayout == null) {
            WebContentPart.Companion companion = WebContentPart.INSTANCE;
            Context context = getPartRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            this.errorLayout = companion.b(context, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.KuiklyContentPart$showErrorPage$1
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
                    KuiklyContentPart.this.refresh();
                }
            });
        }
        View view = this.errorLayout;
        if (view == null) {
            return;
        }
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout2 = this.kuiklyFrameLayout;
        if (discoveryKuiklyFrameLayout2 instanceof ViewGroup) {
            discoveryKuiklyFrameLayout = discoveryKuiklyFrameLayout2;
        } else {
            discoveryKuiklyFrameLayout = null;
        }
        if (discoveryKuiklyFrameLayout == null) {
            return;
        }
        if (discoveryKuiklyFrameLayout2 != null) {
            discoveryKuiklyFrameLayout2.hideLoadingView();
        }
        if (discoveryKuiklyFrameLayout.indexOfChild(view) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            discoveryKuiklyFrameLayout.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        H9();
        TabViewModel tabViewModel = (TabViewModel) PartIOCKt.getIocInterface(this, TabViewModel.class);
        this.currentUrl = "";
        if (tabViewModel != null) {
            tabViewModel.b2();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = this.kuiklyFrameLayout;
        if (discoveryKuiklyFrameLayout != null) {
            discoveryKuiklyFrameLayout.j(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        E9();
        I9();
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = this.kuiklyFrameLayout;
        if (discoveryKuiklyFrameLayout != null) {
            discoveryKuiklyFrameLayout.k();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = this.kuiklyFrameLayout;
        if (discoveryKuiklyFrameLayout != null) {
            discoveryKuiklyFrameLayout.m();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        DiscoveryKuiklyFrameLayout discoveryKuiklyFrameLayout = this.kuiklyFrameLayout;
        if (discoveryKuiklyFrameLayout != null) {
            discoveryKuiklyFrameLayout.n();
        }
    }
}
