package com.tencent.qqnt.chats.biz.miniaio.horizontal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder;
import com.tencent.qqnt.chats.core.adapter.h;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.DefaultRecentAvatarView;
import com.tencent.qqnt.chats.view.widget.SummaryLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J6\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/miniaio/horizontal/c;", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "Landroid/view/View$OnClickListener;", "listener", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", DomainData.DOMAIN_NAME, "r", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends CommonRecentItemBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final c f354358e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f354358e = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n */
    public RecentContactItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable com.tencent.qqnt.chats.core.itempart.d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable h operatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecentContactItemHolder) iPatchRedirector.redirect((short) 6, this, parent, Integer.valueOf(viewType), itemPartCollect, dragListener, operatorListener);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        g g16 = g.g(xv3.a.a(parent), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
        o(itemPartCollect);
        g16.f427835k.setOnModeChangeListener(dragListener);
        RollingTextView unread = g16.f427835k;
        ImageView imageView = new ImageView(parent.getContext());
        SingleLineTextView title = g16.f427834j;
        SummaryLayout summary = g16.f427833i;
        DefaultRecentAvatarView avatar = g16.f427826b;
        SwipeMenuLayout root = g16.getRoot();
        SwipeMenuLayout chatSwipeLayout = g16.f427829e;
        RelativeLayout chatContent = g16.f427827c;
        ImageView diyMsgBg = g16.f427830f;
        RelativeLayout rightLayout = g16.f427831g;
        LinearLayoutCompat chatMenu = g16.f427828d;
        ImageView imageView2 = g16.f427832h;
        Intrinsics.checkNotNullExpressionValue(unread, "unread");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Intrinsics.checkNotNullExpressionValue(summary, "summary");
        Intrinsics.checkNotNullExpressionValue(avatar, "avatar");
        Intrinsics.checkNotNullExpressionValue(root, "root");
        Intrinsics.checkNotNullExpressionValue(chatSwipeLayout, "chatSwipeLayout");
        Intrinsics.checkNotNullExpressionValue(chatContent, "chatContent");
        Intrinsics.checkNotNullExpressionValue(diyMsgBg, "diyMsgBg");
        Intrinsics.checkNotNullExpressionValue(rightLayout, "rightLayout");
        Intrinsics.checkNotNullExpressionValue(chatMenu, "chatMenu");
        return new RecentContactItemHolder(this, new RecentContactItemBinding(unread, imageView, title, null, summary, avatar, root, chatSwipeLayout, chatContent, diyMsgBg, rightLayout, chatMenu, imageView2, null, 8192, null), operatorListener);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: q */
    public void d(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        RecentContactItemBinding y16 = holder.y();
        RelativeLayout b16 = y16.b();
        com.tencent.qqnt.chats.biz.miniaio.g gVar = com.tencent.qqnt.chats.biz.miniaio.g.f354352e;
        b16.setBackgroundResource(gVar.y(gVar, item.H()));
        int a16 = (int) (com.tencent.qqnt.chats.tmp.a.a() * 8);
        y16.d().setPadding(a16, a16, a16, 0);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: r */
    public void e(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) item, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: s */
    public void f(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder, @NotNull View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, holder, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: x */
    public void l(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.l(item, holder);
        holder.y();
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        RecentContactItemBinding y16 = holder.y();
        if (d.f354359a.a(item)) {
            y16.b().setBackgroundResource(R.drawable.jg_);
            View j3 = y16.j();
            if (j3 != null) {
                j3.setVisibility(0);
                return;
            }
            return;
        }
        y16.b().setBackgroundResource(R.drawable.jg8);
        View j16 = y16.j();
        if (j16 != null) {
            j16.setVisibility(4);
        }
    }
}
