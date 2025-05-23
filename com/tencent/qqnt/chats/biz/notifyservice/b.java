package com.tencent.qqnt.chats.biz.notifyservice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder;
import com.tencent.qqnt.chats.core.adapter.h;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemRightLayout;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.menu.creator.c;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chats/biz/notifyservice/b;", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", HippyTKDListViewAdapter.X, "Landroid/view/View$OnClickListener;", "listener", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "e", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends CommonRecentItemBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/notifyservice/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.notifyservice.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42807);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n */
    public RecentContactItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable com.tencent.qqnt.chats.core.itempart.d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable h operatorListener) {
        RecentAvatarViewWrapper recentAvatarViewWrapper;
        RecentContactItemRightLayout recentContactItemRightLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentContactItemHolder) iPatchRedirector.redirect((short) 2, this, parent, Integer.valueOf(viewType), itemPartCollect, dragListener, operatorListener);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecentContactItemHolder a16 = super.a(parent, viewType, itemPartCollect, dragListener, operatorListener);
        a16.D(false);
        nw3.a a17 = a16.y().a();
        SwipeMenuLayout swipeMenuLayout = null;
        if (a17 instanceof RecentAvatarViewWrapper) {
            recentAvatarViewWrapper = (RecentAvatarViewWrapper) a17;
        } else {
            recentAvatarViewWrapper = null;
        }
        if (recentAvatarViewWrapper != null) {
            recentAvatarViewWrapper.setUseAnimCtrl(false);
            recentAvatarViewWrapper.setUnreadView(null);
        }
        RelativeLayout h16 = a16.y().h();
        if (h16 instanceof RecentContactItemRightLayout) {
            recentContactItemRightLayout = (RecentContactItemRightLayout) h16;
        } else {
            recentContactItemRightLayout = null;
        }
        if (recentContactItemRightLayout != null) {
            recentContactItemRightLayout.setUseAnimCtrl(false);
        }
        SwipeMenuLayout d16 = a16.y().d();
        if (d16 instanceof SwipeMenuLayout) {
            swipeMenuLayout = d16;
        }
        if (swipeMenuLayout != null) {
            swipeMenuLayout.setSwipeEnable(false);
        }
        return a16;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: s */
    public void f(@NotNull g item, @NotNull RecentContactItemHolder holder, @NotNull View.OnClickListener listener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, holder, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<com.tencent.qqnt.chats.core.adapter.menu.a> a16 = item.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            com.tencent.qqnt.chats.core.adapter.menu.a aVar = (com.tencent.qqnt.chats.core.adapter.menu.a) obj;
            c.Companion companion = com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE;
            if (!Intrinsics.areEqual(aVar, companion.m()) && !Intrinsics.areEqual(aVar, companion.n())) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        item.O(arrayList);
        super.f(item, holder, listener);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: x */
    public void l(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        RollingTextView o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.l(item, holder);
        RecentContactItemBinding y16 = holder.y();
        if (y16 != null && (o16 = y16.o()) != null) {
            o16.setVisibility(8);
        }
    }
}
