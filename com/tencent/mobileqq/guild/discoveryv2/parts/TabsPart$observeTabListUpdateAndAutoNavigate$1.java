package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.os.Handler;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "tabs", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class TabsPart$observeTabListUpdateAndAutoNavigate$1 extends Lambda implements Function1<List<? extends IGProNavigationTab>, Unit> {
    final /* synthetic */ TabsPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsPart$observeTabListUpdateAndAutoNavigate$1(TabsPart tabsPart) {
        super(1);
        this.this$0 = tabsPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TabsPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.la("AfterLayout");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends IGProNavigationTab> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends IGProNavigationTab> tabs) {
        String joinToString$default;
        ViewPager2 viewPager2;
        AtomicInteger atomicInteger;
        ViewPager2 viewPager22;
        ViewPager2 viewPager23;
        Logger logger = Logger.f235387a;
        TabsPart tabsPart = this.this$0;
        Logger.a d16 = logger.d();
        Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(tabs, null, null, null, 0, null, new Function1<IGProNavigationTab, CharSequence>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$observeTabListUpdateAndAutoNavigate$1$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull IGProNavigationTab it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getName() + "(" + it.getTabId() + ")";
            }
        }, 31, null);
        viewPager2 = tabsPart.viewPager2;
        ViewPager2 viewPager24 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager2 = null;
        }
        d16.i("TabsPart", 1, "onPartCreate: tabs update, tabs=" + joinToString$default + ", scrollState=" + viewPager2.getScrollState());
        atomicInteger = this.this$0.tabsVersion;
        int incrementAndGet = atomicInteger.incrementAndGet();
        viewPager22 = this.this$0.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager22 = null;
        }
        if (viewPager22.getScrollState() == 0) {
            viewPager23 = this.this$0.viewPager2;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            } else {
                viewPager24 = viewPager23;
            }
            if (!viewPager24.isInLayout()) {
                this.this$0.ha(tabs, "TabListUpdate");
                return;
            }
            logger.d().i("TabsPart", 1, "onPartCreate: tabs update, isInLayout, wait for next loadTabs");
            this.this$0.pendingTabs = TuplesKt.to(Integer.valueOf(incrementAndGet), tabs);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final TabsPart tabsPart2 = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.t
                @Override // java.lang.Runnable
                public final void run() {
                    TabsPart$observeTabListUpdateAndAutoNavigate$1.b(TabsPart.this);
                }
            });
            return;
        }
        logger.d().i("TabsPart", 1, "onPartCreate: tabs update, scrollState not idle, wait for next loadTabs");
        this.this$0.pendingTabs = TuplesKt.to(Integer.valueOf(incrementAndGet), tabs);
    }
}
