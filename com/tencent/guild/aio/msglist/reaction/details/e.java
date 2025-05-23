package com.tencent.guild.aio.msglist.reaction.details;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003EFGB3\u0012\b\u0010?\u001a\u0004\u0018\u00010&\u0012\b\u0010@\u001a\u0004\u0018\u000102\u0012\b\u0010A\u001a\u0004\u0018\u00010.\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030 \u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u001b\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0019R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\"\u0010>\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00107\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006H"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "k0", "", CommonConstant.KEY_DISPLAY_NAME, "nickName", "j0", "tinyId", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "o0", "m0", "Landroid/view/ViewGroup;", "viewGroup", "", "viewType", "onCreateViewHolder", "viewHolder", "position", "onBindViewHolder", "", "Lcom/tencent/mobileqq/guild/emoj/a;", "likesList", "", "isNeedClear", "r0", "getItemCount", "getItemViewType", "isShowFoot", "q0", "Lkotlin/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function0;", "getDismissCB", "()Lkotlin/jvm/functions/Function0;", "dismissCB", "Lcom/tencent/common/app/AppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/common/app/AppInterface;", "mApp", "", "D", "Ljava/util/List;", "mLikesList", "Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData;", "E", "Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData;", "mEmojiDetailsData", "Landroid/app/Activity;", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "mActivity", "G", "Z", "mIsShowFoot", "H", "l0", "()Z", "p0", "(Z)V", "isCanRefresh", "app", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "emojiDetailsData", "<init>", "(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData;Lkotlin/jvm/functions/Function0;)V", "I", "a", "b", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AppInterface mApp;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.emoj.a> mLikesList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildEmojiDetailsData mEmojiDetailsData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsShowFoot;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isCanRefresh;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> dismissCB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/e$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setProgressBar", "(Landroid/widget/ImageView;)V", "progressBar", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/guild/aio/msglist/reaction/details/e;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private ImageView progressBar;
        final /* synthetic */ e F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull e eVar, View itemView) {
            super(itemView);
            Context context;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = eVar;
            ImageView imageView = (ImageView) itemView.findViewById(R.id.loading);
            this.progressBar = imageView;
            if (imageView != null) {
                if (imageView != null) {
                    context = imageView.getContext();
                } else {
                    context = null;
                }
                imageView.setImageDrawable(com.tencent.mobileqq.guild.util.qqui.d.d(context, 2));
            }
        }

        @Nullable
        /* renamed from: l, reason: from getter */
        public final ImageView getProgressBar() {
            return this.progressBar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/e$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/LinearLayout;", TtmlNode.TAG_LAYOUT, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "l", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "nickname", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/guild/aio/msglist/reaction/details/e;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout layout;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final GuildUserAvatarView icon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView nickname;
        final /* synthetic */ e H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull e eVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = eVar;
            View findViewById = itemView.findViewById(R.id.b9w);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.content_layout)");
            this.layout = (LinearLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon)");
            this.icon = (GuildUserAvatarView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.nickname);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.nickname)");
            this.nickname = (TextView) findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final GuildUserAvatarView getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final LinearLayout getLayout() {
            return this.layout;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getNickname() {
            return this.nickname;
        }
    }

    public e(@Nullable AppInterface appInterface, @Nullable Activity activity, @Nullable GuildEmojiDetailsData guildEmojiDetailsData, @NotNull Function0<Unit> dismissCB) {
        Intrinsics.checkNotNullParameter(dismissCB, "dismissCB");
        this.dismissCB = dismissCB;
        this.mLikesList = new ArrayList();
        this.mIsShowFoot = true;
        this.isCanRefresh = true;
        this.mApp = appInterface;
        this.mActivity = activity;
        this.mEmojiDetailsData = guildEmojiDetailsData;
        k0();
    }

    private final String j0(String displayName, String nickName) {
        if (displayName != null) {
            if ((TextUtils.isEmpty(displayName) || Intrinsics.areEqual(displayName, l.b(l.f112411a, R.string.f143020ky, null, 2, null).toString())) && !TextUtils.isEmpty(nickName)) {
                return nickName;
            }
            return displayName;
        }
        return nickName;
    }

    private final void k0() {
        com.tencent.mobileqq.guild.emoj.a aVar = new com.tencent.mobileqq.guild.emoj.a();
        aVar.f217863a = true;
        this.mLikesList.add(aVar);
    }

    private final void m0(String tinyId) {
        this.dismissCB.invoke();
        GuildEmojiDetailsData guildEmojiDetailsData = this.mEmojiDetailsData;
        if (guildEmojiDetailsData != null) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(this.mActivity, GuildProfileData.ofTextTypeData(guildEmojiDetailsData.c(), guildEmojiDetailsData.a(), tinyId, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(e this$0, com.tencent.mobileqq.guild.emoj.a likesData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(likesData, "$likesData");
        this$0.m0(String.valueOf(likesData.f217864b));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0(String tinyId, GuildUserAvatarView avatarView) {
        if (!TextUtils.isEmpty(tinyId) && avatarView != null) {
            GuildEmojiDetailsData guildEmojiDetailsData = this.mEmojiDetailsData;
            Intrinsics.checkNotNull(guildEmojiDetailsData);
            avatarView.setAvatarTinyId(guildEmojiDetailsData.c(), tinyId);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mLikesList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mLikesList.get(position).f217863a ? 1 : 0;
    }

    /* renamed from: l0, reason: from getter */
    public final boolean getIsCanRefresh() {
        return this.isCanRefresh;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        int i3;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof c) {
            final com.tencent.mobileqq.guild.emoj.a aVar = this.mLikesList.get(position);
            c cVar = (c) viewHolder;
            o0(String.valueOf(aVar.f217864b), cVar.getIcon());
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                GuildEmojiDetailsData guildEmojiDetailsData = this.mEmojiDetailsData;
                Intrinsics.checkNotNull(guildEmojiDetailsData);
                str = iGPSService.getGuildUserDisplayName(guildEmojiDetailsData.c(), String.valueOf(aVar.f217864b));
            }
            TextView nickname = cVar.getNickname();
            String str2 = aVar.f217865c;
            Intrinsics.checkNotNullExpressionValue(str2, "likesData.nickname");
            nickname.setText(j0(str, str2));
            cVar.getLayout().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.reaction.details.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.n0(e.this, aVar, view);
                }
            });
            return;
        }
        if (viewHolder instanceof b) {
            ImageView progressBar = ((b) viewHolder).getProgressBar();
            Intrinsics.checkNotNull(progressBar);
            if (this.mIsShowFoot) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            progressBar.setVisibility(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (viewType == 0) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emd, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new c(this, view);
        }
        View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emc, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new b(this, view2);
    }

    public final void p0(boolean z16) {
        this.isCanRefresh = z16;
    }

    public final void q0(boolean isShowFoot) {
        this.mIsShowFoot = isShowFoot;
    }

    public final void r0(@NotNull List<? extends com.tencent.mobileqq.guild.emoj.a> likesList, boolean isNeedClear) {
        Intrinsics.checkNotNullParameter(likesList, "likesList");
        if (isNeedClear) {
            this.mLikesList.clear();
            k0();
        }
        if (this.mLikesList.size() == 0) {
            this.mLikesList.addAll(likesList);
        } else {
            this.mLikesList.addAll(r3.size() - 1, likesList);
        }
        notifyDataSetChanged();
    }
}
