package com.tencent.mobileqq.account.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.adapter.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB%\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/account/adapter/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/account/adapter/c$b;", "holder", "", "position", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "m0", "getItemCount", "", "Lcom/tencent/mobileqq/login/account/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "accountList", "Lcom/tencent/mobileqq/account/adapter/c$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/account/adapter/c$a;", "clickListener", "", "D", "Z", "isV9", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/account/adapter/c$a;Z)V", "a", "b", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a clickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isV9;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.login.account.a> accountList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/account/adapter/c$a;", "", "", "uin", "", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public interface a {
        void a(@NotNull String uin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/account/adapter/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "E", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "proAvatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "tvNick", "G", "o", "tvAccount", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "ivSelect", "Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QQProAvatarView proAvatar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView tvNick;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView tvAccount;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView ivSelect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) item);
                return;
            }
            View findViewById = item.findViewById(R.id.s7y);
            Intrinsics.checkNotNullExpressionValue(findViewById, "item.findViewById(R.id.account_avatar)");
            this.proAvatar = (QQProAvatarView) findViewById;
            View findViewById2 = item.findViewById(R.id.f163889bb);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "item.findViewById(R.id.account_nick_tv)");
            this.tvNick = (TextView) findViewById2;
            View findViewById3 = item.findViewById(R.id.f163902bs);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "item.findViewById(R.id.account_uin_tv)");
            this.tvAccount = (TextView) findViewById3;
            View findViewById4 = item.findViewById(R.id.f82264ge);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "item.findViewById(R.id.select_iv)");
            this.ivSelect = (ImageView) findViewById4;
        }

        @NotNull
        public final ImageView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ImageView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.ivSelect;
        }

        @NotNull
        public final QQProAvatarView m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQProAvatarView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.proAvatar;
        }

        @NotNull
        public final TextView o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.tvAccount;
        }

        @NotNull
        public final TextView p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.tvNick;
        }
    }

    public c(@NotNull List<com.tencent.mobileqq.login.account.a> accountList, @NotNull a clickListener, boolean z16) {
        Intrinsics.checkNotNullParameter(accountList, "accountList");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, accountList, clickListener, Boolean.valueOf(z16));
            return;
        }
        this.accountList = accountList;
        this.clickListener = clickListener;
        this.isV9 = z16;
    }

    private final void k0(final b holder, int position) {
        String str;
        VideoReport.setElementId(holder.itemView, "em_bas_switching_account_list");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.isV9) {
            str = "1";
        } else {
            str = "2";
        }
        linkedHashMap.put("new_or_old_page", str);
        linkedHashMap.put("accounts_number", String.valueOf(getNUM_BACKGOURND_ICON()));
        linkedHashMap.put("serial_number", String.valueOf(position));
        VideoReport.setElementParams(holder.itemView, linkedHashMap);
        VideoReport.setElementClickPolicy(holder.itemView, ClickPolicy.REPORT_ALL);
        holder.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.account.adapter.b
            @Override // java.lang.Runnable
            public final void run() {
                c.l0(c.b.this, linkedHashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(b holder, Map map) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(map, "$map");
        VideoReport.reportEvent("imp", holder.itemView, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(c this$0, com.tencent.mobileqq.login.account.a account, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        this$0.clickListener.a(account.f());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.accountList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        final com.tencent.mobileqq.login.account.a aVar = this.accountList.get(position);
        holder.p().setText(aVar.d());
        String c16 = aVar.c();
        if (c16 != null && c16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            c16 = aVar.f();
        }
        holder.o().setText(c16);
        holder.m().w(1, aVar.f());
        if (TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), aVar.f())) {
            holder.l().setVisibility(0);
        } else {
            holder.l().setVisibility(8);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.account.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.n0(c.this, aVar, view);
            }
        });
        k0(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168869h41, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026ount_item, parent, false)");
        VideoReport.setElementId(inflate, "em_bas_switching_account_list");
        return new b(inflate);
    }
}
