package com.tencent.qqnt.emotion.emoreply;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0013\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003BCDB/\u0012\u0006\u0010%\u001a\u00020 \u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\u0006\u0010-\u001a\u00020*\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030.\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u001b\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0019R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0017028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\"\u0010>\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00107\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "m0", "", CommonConstant.KEY_DISPLAY_NAME, "nickName", "l0", "tinyId", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "p0", "o0", "Landroid/view/ViewGroup;", "viewGroup", "", "viewType", "onCreateViewHolder", "viewHolder", "position", "onBindViewHolder", "", "Lcom/tencent/qqnt/emotion/emoreply/j;", "likesList", "", "isNeedClear", "s0", "getItemCount", "getItemViewType", "isShowFoot", "r0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/emoreply/f;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/emoreply/f;", "emojiDetailsData", "", "D", "J", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "Lkotlin/Function0;", "E", "Lkotlin/jvm/functions/Function0;", "dismissCB", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "mLikesList", "G", "Z", "mIsShowFoot", "H", "n0", "()Z", "q0", "(Z)V", "isCanRefresh", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/aio/emoreply/f;JLkotlin/jvm/functions/Function0;)V", "I", "a", "b", "c", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LikesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.aio.emoreply.f emojiDetailsData;

    /* renamed from: D, reason: from kotlin metadata */
    private final long senderUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> dismissCB;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<j> mLikesList;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsShowFoot;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isCanRefresh;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_CONTENT_ITEM", "I", "TYPE_FOOT_ITEM", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.emoreply.LikesListAdapter$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setProgressBar", "(Landroid/widget/ImageView;)V", "progressBar", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter;Landroid/view/View;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private ImageView progressBar;
        final /* synthetic */ LikesListAdapter F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull LikesListAdapter likesListAdapter, View itemView) {
            super(itemView);
            Context context;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = likesListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) likesListAdapter, (Object) itemView);
                return;
            }
            ImageView imageView = (ImageView) itemView.findViewById(R.id.loading);
            this.progressBar = imageView;
            if (imageView != null) {
                if (imageView != null) {
                    context = imageView.getContext();
                } else {
                    context = null;
                }
                imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(context, 2));
            }
        }

        @Nullable
        public final ImageView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.progressBar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/LinearLayout;", TtmlNode.TAG_LAYOUT, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "nickname", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/emotion/emoreply/LikesListAdapter;Landroid/view/View;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout layout;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final QQProAvatarView icon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView nickname;
        final /* synthetic */ LikesListAdapter H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull LikesListAdapter likesListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = likesListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) likesListAdapter, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.b9w);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.content_layout)");
            this.layout = (LinearLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon)");
            this.icon = (QQProAvatarView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.nickname);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.nickname)");
            this.nickname = (TextView) findViewById3;
        }

        @NotNull
        public final QQProAvatarView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQProAvatarView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.icon;
        }

        @NotNull
        public final LinearLayout m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LinearLayout) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.layout;
        }

        @NotNull
        public final TextView o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.nickname;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LikesListAdapter(@NotNull Context context, @Nullable com.tencent.qqnt.aio.emoreply.f fVar, long j3, @NotNull Function0<Unit> dismissCB) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dismissCB, "dismissCB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, fVar, Long.valueOf(j3), dismissCB);
            return;
        }
        this.context = context;
        this.emojiDetailsData = fVar;
        this.senderUin = j3;
        this.dismissCB = dismissCB;
        this.mLikesList = new ArrayList();
        this.mIsShowFoot = true;
        this.isCanRefresh = true;
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l0(String displayName, String nickName) {
        if (displayName != null) {
            if (TextUtils.isEmpty(displayName) && !TextUtils.isEmpty(nickName)) {
                return nickName;
            }
            return displayName;
        }
        return nickName;
    }

    private final void m0() {
        this.mLikesList.add(new j(true, 0L, "", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String tinyId) {
        this.dismissCB.invoke();
        AllInOne allInOne = new AllInOne(tinyId, 111);
        QRouteApi api = QRoute.api(IProfileCardApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IProfileCardApi::class.java)");
        ((IProfileCardApi) api).openProfileCard(this.context, allInOne);
    }

    private final void p0(String tinyId, QQProAvatarView avatarView) {
        if (!TextUtils.isEmpty(tinyId) && avatarView != null) {
            avatarView.x(1, tinyId, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(true).b(true).a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mLikesList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return this.mLikesList.get(position).c() ? 1 : 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, position)).intValue();
    }

    public final boolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isCanRefresh;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof c) {
            j jVar = this.mLikesList.get(position);
            p0(String.valueOf(jVar.b()), ((c) viewHolder).l());
            com.tencent.qqnt.aio.emoreply.f fVar = this.emojiDetailsData;
            if (fVar != null) {
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(fVar.c(), String.valueOf(jVar.b()), "AIOLikesListAdapter", new LikesListAdapter$onBindViewHolder$1$1(viewHolder, this, jVar, fVar));
                return;
            }
            return;
        }
        if (viewHolder instanceof b) {
            ImageView l3 = ((b) viewHolder).l();
            Intrinsics.checkNotNull(l3);
            if (this.mIsShowFoot) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            l3.setVisibility(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, viewType);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (viewType == 0) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.duz, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new c(this, view);
        }
        View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.duy, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new b(this, view2);
    }

    public final void q0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isCanRefresh = z16;
        }
    }

    public final void r0(boolean isShowFoot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isShowFoot);
        } else {
            this.mIsShowFoot = isShowFoot;
        }
    }

    public final void s0(@NotNull List<j> likesList, boolean isNeedClear) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, likesList, Boolean.valueOf(isNeedClear));
            return;
        }
        Intrinsics.checkNotNullParameter(likesList, "likesList");
        if (isNeedClear) {
            this.mLikesList.clear();
            m0();
        }
        this.mLikesList.size();
        if (this.mLikesList.size() == 0) {
            this.mLikesList.addAll(likesList);
        } else {
            List<j> list = this.mLikesList;
            list.addAll(list.size() - 1, likesList);
        }
        notifyDataSetChanged();
    }
}
