package com.tencent.qqnt.chats.biz.troophelper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemRightLayout;
import com.tencent.qqnt.chats.core.adapter.menu.creator.c;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chats/biz/troophelper/h;", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "Landroid/view/View$OnClickListener;", "listener", "", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h extends CommonRecentItemBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final h f354430e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f354430e = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n */
    public RecentContactItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable com.tencent.qqnt.chats.core.itempart.d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable com.tencent.qqnt.chats.core.adapter.h operatorListener) {
        RecentAvatarViewWrapper recentAvatarViewWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentContactItemHolder) iPatchRedirector.redirect((short) 2, this, parent, Integer.valueOf(viewType), itemPartCollect, dragListener, operatorListener);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecentContactItemHolder a16 = super.a(parent, viewType, itemPartCollect, dragListener, operatorListener);
        a16.D(false);
        nw3.a a17 = a16.y().a();
        RecentContactItemRightLayout recentContactItemRightLayout = null;
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
        }
        if (recentContactItemRightLayout != null) {
            recentContactItemRightLayout.setUseAnimCtrl(false);
        }
        return a16;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: s */
    public void f(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder, @NotNull View.OnClickListener listener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, item, holder, listener);
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
}
