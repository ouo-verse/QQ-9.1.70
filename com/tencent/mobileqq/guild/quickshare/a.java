package com.tencent.mobileqq.guild.quickshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004)*+,B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\"j\b\u0012\u0004\u0012\u00020\u000e`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/quickshare/a$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "recentUserList", "setData", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "I", "getUserNameColor", "()I", "userNameColor", "Lcom/tencent/mobileqq/guild/quickshare/a$b;", "D", "Lcom/tencent/mobileqq/guild/quickshare/a$b;", "getCallback", "()Lcom/tencent/mobileqq/guild/quickshare/a$b;", "callback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "<init>", "(Landroid/content/Context;ILcom/tencent/mobileqq/guild/quickshare/a$b;)V", UserInfo.SEX_FEMALE, "a", "b", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends RecyclerView.Adapter<d> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int userNameColor;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b callback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GuildRecentUser> recentUserList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/a$b;", "", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", QCircleAlphaUserReporter.KEY_USER, "", "a", "", "uin", "headPath", "Landroid/graphics/Bitmap;", "head", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(@NotNull View v3, @NotNull GuildRecentUser user);

        void h(@NotNull String uin, @NotNull String headPath, @NotNull Bitmap head);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spacing", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spacing = ViewUtils.dpToPx(15.7f);

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) > 0) {
                i3 = this.spacing;
            } else {
                i3 = 0;
            }
            outRect.left = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "itemView", "", "p", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "userData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "v", NodeProps.ON_CLICK, "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", UserInfo.SEX_FEMALE, "I", "getUserNameColor", "()I", "userNameColor", "Lcom/tencent/mobileqq/guild/quickshare/a$b;", "G", "Lcom/tencent/mobileqq/guild/quickshare/a$b;", "o", "()Lcom/tencent/mobileqq/guild/quickshare/a$b;", "callback", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "H", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "setAvatarView", "(Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;)V", "avatarView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "nameView", "J", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "<init>", "(Landroid/content/Context;ILandroid/view/View;Lcom/tencent/mobileqq/guild/quickshare/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: F, reason: from kotlin metadata */
        private final int userNameColor;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final b callback;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private GuildUserAvatarView avatarView;

        /* renamed from: I, reason: from kotlin metadata */
        private TextView nameView;

        /* renamed from: J, reason: from kotlin metadata */
        private GuildRecentUser userData;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/quickshare/a$d$a", "Lt02/d;", "", "uin", "headPath", "Landroid/graphics/Bitmap;", "head", "", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.quickshare.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7874a implements t02.d {
            C7874a() {
            }

            @Override // t02.d
            public void h(@NotNull String uin, @NotNull String headPath, @NotNull Bitmap head) {
                Intrinsics.checkNotNullParameter(uin, "uin");
                Intrinsics.checkNotNullParameter(headPath, "headPath");
                Intrinsics.checkNotNullParameter(head, "head");
                d.this.getCallback().h(uin, headPath, head);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Context context, int i3, @NotNull View itemView, @NotNull b callback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.context = context;
            this.userNameColor = i3;
            this.callback = callback;
            p(itemView);
        }

        private final void p(View itemView) {
            this.avatarView = (GuildUserAvatarView) itemView.findViewById(R.id.f115206ve);
            View findViewById = itemView.findViewById(R.id.km_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.user_name)");
            TextView textView = (TextView) findViewById;
            this.nameView = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nameView");
                textView = null;
            }
            textView.setTextColor(this.context.getResources().getColor(this.userNameColor));
            itemView.setOnClickListener(this);
        }

        private final void q(GuildRecentUser userData) {
            String str;
            VideoReport.setElementReuseIdentifier(this.itemView, "em_sgrp_right_invite_user" + userData.hashCode());
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_touin", userData.getUin());
            int type = userData.getType();
            if (type != 1) {
                if (type != 10014) {
                    str = "c2c";
                } else {
                    str = WadlProxyConsts.CHANNEL;
                }
            } else {
                str = "grp";
            }
            hashMap.put("sgrp_totype", str);
            ch.W0(this.itemView, "em_sgrp_right_invite_user", hashMap);
        }

        public final void l(@NotNull GuildRecentUser userData) {
            Intrinsics.checkNotNullParameter(userData, "userData");
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.share.GuildShare.RecentUserAdapter", 1, "bindView userData:" + userData);
            }
            this.userData = userData;
            TextView textView = this.nameView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nameView");
                textView = null;
            }
            textView.setText(userData.getName());
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).loadRecentUserAvatar(this.context, userData, this.avatarView, new C7874a());
            q(userData);
        }

        @Nullable
        /* renamed from: m, reason: from getter */
        public final GuildUserAvatarView getAvatarView() {
            return this.avatarView;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final b getCallback() {
            return this.callback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            b bVar = this.callback;
            GuildRecentUser guildRecentUser = this.userData;
            if (guildRecentUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                guildRecentUser = null;
            }
            bVar.a(v3, guildRecentUser);
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    public a(@NotNull Context context, int i3, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.userNameColor = i3;
        this.callback = callback;
        this.recentUserList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.recentUserList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.share.GuildShare.RecentUserAdapter", 1, "onBindViewHolder pos:" + position);
        }
        GuildRecentUser guildRecentUser = this.recentUserList.get(position);
        Intrinsics.checkNotNullExpressionValue(guildRecentUser, "recentUserList[position]");
        holder.l(guildRecentUser);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.share.GuildShare.RecentUserAdapter", 1, "onCreateViewHolder");
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f3m, (ViewGroup) null);
        Context context = this.context;
        int i3 = this.userNameColor;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new d(context, i3, itemView, this.callback);
    }

    public final void setData(@NotNull List<GuildRecentUser> recentUserList) {
        Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.share.GuildShare.RecentUserAdapter", 1, "setData size:" + recentUserList.size());
        }
        this.recentUserList.clear();
        this.recentUserList.addAll(recentUserList);
        notifyDataSetChanged();
    }
}
