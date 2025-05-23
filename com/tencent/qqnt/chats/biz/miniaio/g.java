package com.tencent.qqnt.chats.biz.miniaio;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J6\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001b\u0010\u001a\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chats/biz/miniaio/g;", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnClickListener;", "listener", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", DomainData.DOMAIN_NAME, "", "isTop", "y", "(Lcom/tencent/qqnt/chats/biz/miniaio/g;Z)I", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g extends CommonRecentItemBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final g f354352e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f354352e = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n */
    public RecentContactItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable com.tencent.qqnt.chats.core.itempart.d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable com.tencent.qqnt.chats.core.adapter.h operatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecentContactItemHolder) iPatchRedirector.redirect((short) 6, this, parent, Integer.valueOf(viewType), itemPartCollect, dragListener, operatorListener);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        pw3.i g16 = pw3.i.g(xv3.a.a(parent), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
        o(itemPartCollect);
        g16.f427854l.setOnModeChangeListener(dragListener);
        RollingTextView unread = g16.f427854l;
        ImageView imageView = new ImageView(parent.getContext());
        SingleLineTextView title = g16.f427851i;
        SummaryLayout summary = g16.f427850h;
        DefaultRecentAvatarView avatar = g16.f427844b;
        SwipeMenuLayout root = g16.getRoot();
        SwipeMenuLayout chatSwipeLayout = g16.f427847e;
        RelativeLayout chatContent = g16.f427845c;
        ImageView diyMsgBg = g16.f427848f;
        RelativeLayout rightLayout = g16.f427849g;
        ImageView imageView2 = g16.f427853k;
        LinearLayoutCompat chatMenu = g16.f427846d;
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
        return new RecentContactItemHolder(this, new RecentContactItemBinding(unread, imageView, title, imageView2, summary, avatar, root, chatSwipeLayout, chatContent, diyMsgBg, rightLayout, chatMenu, null, null, 12288, null), operatorListener);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: q */
    public void d(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        RecentContactItemBinding y16 = holder.y();
        y16.b().setBackgroundResource(y(this, item.H()));
        int a16 = (int) (com.tencent.qqnt.chats.tmp.a.a() * 8);
        y16.d().setPadding(a16, a16, a16, 0);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: r */
    public void e(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) holder);
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

    public final int y(@NotNull g gVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, gVar, Boolean.valueOf(z16))).intValue();
        }
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (z16) {
            return R.drawable.jg_;
        }
        return R.drawable.jg8;
    }
}
