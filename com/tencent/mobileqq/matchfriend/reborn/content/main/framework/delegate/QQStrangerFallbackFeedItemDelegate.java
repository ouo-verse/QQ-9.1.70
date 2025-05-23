package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import t72.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00052\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J4\u0010\u0013\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/delegate/QQStrangerFallbackFeedItemDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegate;", "", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "", "d", "items", "", "position", "", "isForViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "", "", "payload", "onBindViewHolder", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerFallbackFeedItemDelegate extends AdapterDelegate<List<? extends FeedPB$Feed>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<Boolean> f244206e;

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<Boolean> f244207f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/delegate/QQStrangerFallbackFeedItemDelegate$a;", "", "", "disableFallback$delegate", "Lkotlin/Lazy;", "c", "()Z", "disableFallback", "disableReport$delegate", "d", "disableReport", "", "REPORT_EVENT_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate.QQStrangerFallbackFeedItemDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c() {
            return ((Boolean) QQStrangerFallbackFeedItemDelegate.f244206e.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) QQStrangerFallbackFeedItemDelegate.f244207f.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<Boolean> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate.QQStrangerFallbackFeedItemDelegate$Companion$disableFallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqstranger_square_feed_fallback_delegate_disable", false));
            }
        });
        f244206e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate.QQStrangerFallbackFeedItemDelegate$Companion$disableReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqstranger_square_feed_fallback_report_disable", false));
            }
        });
        f244207f = lazy2;
    }

    private final void d() {
        if (INSTANCE.d()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        QQBeaconReport.report(currentAccountUin, "qqstranger_square_feed_delegate_fallback");
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public /* bridge */ /* synthetic */ boolean isForViewType(List<? extends FeedPB$Feed> list, int i3) {
        return isForViewType2((List<FeedPB$Feed>) list, i3);
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    protected void onBindViewHolder2(List<FeedPB$Feed> items, int position, RecyclerView.ViewHolder holder, List<Object> payload) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payload, "payload");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return h.a(frameLayout);
    }

    /* renamed from: isForViewType, reason: avoid collision after fix types in other method */
    protected boolean isForViewType2(List<FeedPB$Feed> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        QLog.e("QQStrangerFallbackFeedItemDelegate", 1, "isForViewType not find valid delegate! itemCount=" + items.size() + " position=" + position);
        d();
        if (INSTANCE.c()) {
            QLog.e("QQStrangerFallbackFeedItemDelegate", 1, "disable fallback");
        }
        return !r3.c();
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public /* bridge */ /* synthetic */ void onBindViewHolder(List<? extends FeedPB$Feed> list, int i3, RecyclerView.ViewHolder viewHolder, List list2) {
        onBindViewHolder2((List<FeedPB$Feed>) list, i3, viewHolder, (List<Object>) list2);
    }
}
