package com.tencent.mobileqq.selectfriend.part.adapter;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.FetchDiffTroopMemberRunnable;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002OPB\u001f\u0012\u0006\u0010)\u001a\u000202\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010K\u001a\u00020E\u00a2\u0006\u0004\bL\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J,\u0010\f\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000fJ$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\rH\u0016J&\u0010.\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/RecentChatListAdapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/FacePreloadBaseAdapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/RecentChatListAdapter$b;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "input", "", "prepareDisplay", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "map", "prepareDisplayInner", "", "type", "", "needFetchTroopMemberInfo", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "forwardRecentItemView", "Lzp2/a;", "recentChatData", "bindData", "list", "refreshList", "isMultiSelectStatus", "setIsMultiSelectStatus", "uin", "Landroid/graphics/Bitmap;", "avatar", "updateChildViewHead", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "", "getItemId", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/selectfriend/callback/a;", "callback", "sendToNode", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Landroid/app/Activity;", "mContext", "Landroid/app/Activity;", "mRecentChatList", "Ljava/util/List;", "Lcom/tencent/mobileqq/app/n;", "mDiscussManager", "Lcom/tencent/mobileqq/app/n;", "Lcom/tencent/mobileqq/app/TroopManager;", "mTroopManager", "Lcom/tencent/mobileqq/app/TroopManager;", "Lcom/tencent/mobileqq/app/FriendsManager;", "mFriendManager", "Lcom/tencent/mobileqq/app/FriendsManager;", "Lcom/tencent/mobileqq/app/CardHandler;", "mCardHandler", "Lcom/tencent/mobileqq/app/CardHandler;", "mIsMultiSelectStatus", "Z", "Lcom/tencent/mobileqq/adapter/n$c;", "mCallback", "Lcom/tencent/mobileqq/adapter/n$c;", "Landroid/view/View$OnClickListener;", "mItemViewOnClickListener", "Landroid/view/View$OnClickListener;", "forwardRecentListAdapterCallback", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/adapter/n$c;)V", "Companion", "a", "b", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RecentChatListAdapter extends FacePreloadBaseAdapter<b> {
    public static final String TAG = "RecentChatListAdapter";
    private final QQAppInterface app;
    private final n.c mCallback;
    private final CardHandler mCardHandler;
    private final Activity mContext;
    private final com.tencent.mobileqq.app.n mDiscussManager;
    private final FriendsManager mFriendManager;
    private boolean mIsMultiSelectStatus;
    private final View.OnClickListener mItemViewOnClickListener;
    private List<zp2.a> mRecentChatList;
    private final TroopManager mTroopManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/RecentChatListAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "E", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "l", "()Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "setForwardRecentItemView", "(Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;)V", "forwardRecentItemView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private ForwardRecentItemView forwardRecentItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            if (itemView instanceof ForwardRecentItemView) {
                this.forwardRecentItemView = (ForwardRecentItemView) itemView;
            }
        }

        /* renamed from: l, reason: from getter */
        public final ForwardRecentItemView getForwardRecentItemView() {
            return this.forwardRecentItemView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/selectfriend/part/adapter/RecentChatListAdapter$c", "Lcom/tencent/qqnt/troopmemberlist/e;", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.qqnt.troopmemberlist.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<RecentUser> f285457b;

        c(List<RecentUser> list) {
            this.f285457b = list;
        }

        @Override // com.tencent.qqnt.troopmemberlist.e
        public void a(Map<String, ? extends TroopMemberInfo> troopMemberList) {
            Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
            RecentChatListAdapter.this.prepareDisplayInner(this.f285457b, troopMemberList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentChatListAdapter(Activity context, QQAppInterface app, n.c forwardRecentListAdapterCallback) {
        super(app);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(forwardRecentListAdapterCallback, "forwardRecentListAdapterCallback");
        this.mRecentChatList = new ArrayList();
        this.app = app;
        this.mContext = context;
        this.mCallback = forwardRecentListAdapterCallback;
        Manager manager = app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.DiscussionManager");
        this.mDiscussManager = (com.tencent.mobileqq.app.n) manager;
        Manager manager2 = app.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        this.mTroopManager = (TroopManager) manager2;
        Manager manager3 = app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager3, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        this.mFriendManager = (FriendsManager) manager3;
        BusinessHandler businessHandler = app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.CardHandler");
        this.mCardHandler = (CardHandler) businessHandler;
        this.mItemViewOnClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.part.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecentChatListAdapter.mItemViewOnClickListener$lambda$0(RecentChatListAdapter.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mItemViewOnClickListener$lambda$0(RecentChatListAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCallback.b(view);
    }

    private final boolean needFetchTroopMemberInfo(int type) {
        if (type != 1000 && type != 1020) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareDisplayInner$lambda$5(RecentChatListAdapter this$0, ArrayList dds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dds, "$dds");
        this$0.mRecentChatList = dds;
        this$0.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mRecentChatList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.mRecentChatList.get(position).uin != null ? r3.hashCode() : 0;
    }

    public final void refreshList(List<RecentUser> list) {
        prepareDisplay(list);
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public void sendToNode(Context context, Bundle extraData, com.tencent.mobileqq.selectfriend.callback.a callback) {
        if (!(context instanceof AppActivity)) {
            if (callback != null) {
                callback.a(1, "context !is AppActivity");
                return;
            }
            return;
        }
        AppActivity appActivity = (AppActivity) context;
        Intent aliasIntent = SplashActivity.getAliasIntent(appActivity);
        if (extraData != null) {
            extraData.putBoolean("isBack2Root", false);
        }
        Intent m3 = BaseAIOUtils.m(aliasIntent, null);
        if (extraData != null) {
            m3.putExtras(extraData);
        }
        appActivity.setResult(-1, m3);
        if (extraData != null && extraData.getBoolean("is_finish_current_page")) {
            appActivity.finish();
        }
        if (callback != null) {
            callback.a(0, "");
        }
    }

    public final void setIsMultiSelectStatus(boolean isMultiSelectStatus) {
        this.mIsMultiSelectStatus = isMultiSelectStatus;
    }

    @Override // com.tencent.mobileqq.selectfriend.part.adapter.FacePreloadBaseAdapter
    protected void updateChildViewHead(int type, String uin, Bitmap avatar) {
        int size = this.mRecentChatList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zp2.a aVar = this.mRecentChatList.get(i3);
            if (aVar != null && Intrinsics.areEqual(uin, aVar.uin)) {
                notifyItemChanged(i3);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        bindData(holder.getForwardRecentItemView(), this.mRecentChatList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(new ForwardRecentItemView(parent.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01df, code lost:
    
        if (r9 != 1020) goto L110;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x005f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void prepareDisplayInner(List<RecentUser> input, Map<String, ? extends TroopMemberInfo> map) {
        String str;
        Object obj;
        int i3;
        String str2;
        String str3;
        String g16;
        final ArrayList arrayList = new ArrayList(input.size());
        int size = input.size();
        for (int i16 = 0; i16 < size; i16++) {
            RecentUser recentUser = input.get(i16);
            zp2.a aVar = new zp2.a();
            String str4 = recentUser.uin;
            Intrinsics.checkNotNullExpressionValue(str4, "ru.uin");
            int type = recentUser.getType();
            int i17 = 1;
            if (type != 0) {
                if (type == 1) {
                    TroopInfo k3 = this.mTroopManager.k(str4);
                    if (k3 != null) {
                        str2 = k3.getTroopDisplayName();
                    } else {
                        str2 = recentUser.displayName;
                    }
                    if (str2 != null) {
                        int length = str2.length() - 1;
                        int i18 = 0;
                        boolean z16 = false;
                        while (i18 <= length) {
                            boolean z17 = Intrinsics.compare((int) str2.charAt(!z16 ? i18 : length), 32) <= 0;
                            if (z16) {
                                if (z17) {
                                    length--;
                                } else if (!Intrinsics.areEqual(str2.subSequence(i18, length + 1).toString(), "")) {
                                    str = str2;
                                    i17 = 4;
                                }
                            } else if (z17) {
                                i18++;
                            } else {
                                z16 = true;
                            }
                        }
                        if (!Intrinsics.areEqual(str2.subSequence(i18, length + 1).toString(), "")) {
                        }
                    }
                    str = str4;
                    i17 = 4;
                } else if (type != 1000 && type != 1001) {
                    if (type == 1008) {
                        IRuntimeService runtimeService = this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IP\u2026                        )");
                        Object findPublicAccountInfo = ((IPublicAccountDataManager) runtimeService).findPublicAccountInfo(str4);
                        PublicAccountInfo publicAccountInfo = findPublicAccountInfo instanceof PublicAccountInfo ? (PublicAccountInfo) findPublicAccountInfo : null;
                        if (publicAccountInfo != null) {
                            str = publicAccountInfo.name;
                        }
                        str = null;
                    } else if (type == 1046) {
                        str = recentUser.displayName;
                        i17 = 202;
                    } else if (type == 3000) {
                        DiscussionInfo h16 = this.mDiscussManager.h(str4);
                        if (h16 != null && !h16.isHidden()) {
                            if (TextUtils.isEmpty(h16.discussionName)) {
                                str3 = recentUser.displayName;
                            } else {
                                str3 = h16.discussionName;
                            }
                            if (TextUtils.isEmpty(str3)) {
                                str3 = this.mContext.getResources().getString(R.string.as8);
                            }
                            str = str3;
                            i17 = 101;
                        }
                    } else if (type == 6002) {
                        str = recentUser.displayName;
                        i17 = 104;
                    } else if (type != 10002 && type != 10004 && type != 10008 && type != 10010) {
                        if (type != 10014) {
                            switch (type) {
                                case 1003:
                                case 1004:
                                case 1005:
                                    break;
                                case 1006:
                                    String m06 = ac.m0(this.app, str4);
                                    IRuntimeService runtimeService2 = this.app.getRuntimeService(IPhoneContactService.class, "");
                                    Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IP\u2026AIN\n                    )");
                                    PhoneContact queryContactByCodeNumber = ((IPhoneContactService) runtimeService2).queryContactByCodeNumber(str4);
                                    if (queryContactByCodeNumber != null) {
                                        g16 = queryContactByCodeNumber.name;
                                    } else if (m06 == null) {
                                        str = str4;
                                        i17 = 11;
                                        break;
                                    } else {
                                        g16 = ac.g(this.app, m06, true);
                                    }
                                    str = g16;
                                    i17 = 11;
                                default:
                                    switch (type) {
                                        case 1020:
                                        case 1022:
                                        case 1023:
                                        case 1024:
                                        case 1025:
                                            break;
                                        case 1021:
                                            str = ac.g(this.app, str4, true);
                                            break;
                                        default:
                                            str = null;
                                            break;
                                    }
                            }
                        } else {
                            IRuntimeService runtimeService3 = this.app.getRuntimeService(IGPSService.class, "");
                            Intrinsics.checkNotNullExpressionValue(runtimeService3, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
                            IGPSService iGPSService = (IGPSService) runtimeService3;
                            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(recentUser.troopUin);
                            IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str4);
                            if (guildInfo != null && channelInfo != null) {
                                str = guildInfo.getGuildName() + QbAddrData.DATA_SPLITER + channelInfo.getChannelName();
                            }
                            str = null;
                        }
                    }
                }
                if (AppConstants.DATALINE_PC_UIN.equals(str4)) {
                    str = HardCodeUtil.qqStr(R.string.cf5);
                }
                if (TextUtils.isEmpty(str)) {
                    str = str4;
                }
                aVar.name = str;
                aVar.avatarType = i17;
                aVar.uin = str4;
                aVar.ru = recentUser;
                arrayList.add(aVar);
            }
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str4);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, TAG);
            if ((friendsSimpleInfoWithUid != null ? friendsSimpleInfoWithUid.x() : null) != null) {
                if (friendsSimpleInfoWithUid.x().length() > 0) {
                    str = friendsSimpleInfoWithUid.m();
                    if (type != 1000) {
                        if (type == 1004) {
                            str = ac.n(this.app, recentUser.troopUin, str4);
                        }
                        obj = "";
                        if (str != null || Intrinsics.areEqual(obj, str)) {
                            i3 = 1;
                            str = ac.g(this.app, str4, true);
                        } else {
                            i3 = 1;
                        }
                        if (!TextUtils.isEmpty(str) || Intrinsics.areEqual(str, com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.app))) {
                            str = recentUser.displayName;
                        }
                        i17 = i3;
                        if (AppConstants.DATALINE_PC_UIN.equals(str4)) {
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        aVar.name = str;
                        aVar.avatarType = i17;
                        aVar.uin = str4;
                        aVar.ru = recentUser;
                        arrayList.add(aVar);
                    }
                    String str5 = recentUser.troopUin;
                    Intrinsics.checkNotNullExpressionValue(str5, "ru.troopUin");
                    String str6 = recentUser.uin;
                    Intrinsics.checkNotNullExpressionValue(str6, "ru.uin");
                    TroopMemberInfo troopMemberInfo = map.get(com.tencent.qqnt.troopmemberlist.b.a(str5, str6));
                    obj = "";
                    str = ac.i0(this.app, str4, this.mTroopManager.G(recentUser.troopUin), recentUser.troopUin, troopMemberInfo, true, null);
                    if (str != null) {
                    }
                    i3 = 1;
                    str = ac.g(this.app, str4, true);
                    if (!TextUtils.isEmpty(str)) {
                    }
                    str = recentUser.displayName;
                    i17 = i3;
                    if (AppConstants.DATALINE_PC_UIN.equals(str4)) {
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    aVar.name = str;
                    aVar.avatarType = i17;
                    aVar.uin = str4;
                    aVar.ru = recentUser;
                    arrayList.add(aVar);
                }
            }
            str = null;
            if (type != 1000) {
            }
            String str52 = recentUser.troopUin;
            Intrinsics.checkNotNullExpressionValue(str52, "ru.troopUin");
            String str62 = recentUser.uin;
            Intrinsics.checkNotNullExpressionValue(str62, "ru.uin");
            TroopMemberInfo troopMemberInfo2 = map.get(com.tencent.qqnt.troopmemberlist.b.a(str52, str62));
            obj = "";
            str = ac.i0(this.app, str4, this.mTroopManager.G(recentUser.troopUin), recentUser.troopUin, troopMemberInfo2, true, null);
            if (str != null) {
            }
            i3 = 1;
            str = ac.g(this.app, str4, true);
            if (!TextUtils.isEmpty(str)) {
            }
            str = recentUser.displayName;
            i17 = i3;
            if (AppConstants.DATALINE_PC_UIN.equals(str4)) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            aVar.name = str;
            aVar.avatarType = i17;
            aVar.uin = str4;
            aVar.ru = recentUser;
            arrayList.add(aVar);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.part.adapter.g
            @Override // java.lang.Runnable
            public final void run() {
                RecentChatListAdapter.prepareDisplayInner$lambda$5(RecentChatListAdapter.this, arrayList);
            }
        });
    }

    private final void prepareDisplay(List<RecentUser> input) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        if (input == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : input) {
            if (needFetchTroopMemberInfo(((RecentUser) obj).getType())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((RecentUser) it.next()).troopUin);
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList3.add(((RecentUser) it5.next()).uin);
            }
            ComponentCallbacks2 componentCallbacks2 = this.mContext;
            new FetchDiffTroopMemberRunnable(arrayList2, arrayList3, componentCallbacks2 instanceof LifecycleOwner ? (LifecycleOwner) componentCallbacks2 : null, new c(input));
            return;
        }
        prepareDisplayInner(input, new HashMap());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bindData(ForwardRecentItemView forwardRecentItemView, zp2.a recentChatData) {
        Drawable bitmapDrawable;
        Drawable matchFriendFaceDrawable;
        ResultRecord resultRecord;
        RecentUser recentUser;
        RecentUser recentUser2;
        if (recentChatData == null || forwardRecentItemView == null) {
            return;
        }
        forwardRecentItemView.setTag("view_from_recent_chat");
        RecentUser recentUser3 = recentChatData.ru;
        if (recentUser3 != null && recentUser3.getType() == 10014) {
            IQQGuildService iQQGuildService = (IQQGuildService) this.app.getRuntimeService(IQQGuildService.class, "");
            RecentUser recentUser4 = recentChatData.ru;
            Intrinsics.checkNotNull(recentUser4);
            matchFriendFaceDrawable = iQQGuildService.getAvatarDrawable(recentUser4.troopUin, 100, null, true);
        } else {
            RecentUser recentUser5 = recentChatData.ru;
            if (recentUser5 != null && recentUser5.getType() == 1046) {
                IMatchFriendFaceApi iMatchFriendFaceApi = (IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class);
                QQAppInterface qQAppInterface = this.app;
                String str = recentChatData.uin;
                Intrinsics.checkNotNull(str);
                matchFriendFaceDrawable = iMatchFriendFaceApi.getMatchFriendFaceDrawable(qQAppInterface, Long.parseLong(str));
            } else {
                int i3 = recentChatData.avatarType;
                String str2 = recentChatData.uin;
                Intrinsics.checkNotNull(str2);
                bitmapDrawable = new BitmapDrawable(getFaceBitmap(i3, str2));
                RecentUser recentUser6 = recentChatData.ru;
                boolean z16 = recentUser6 == null && this.mCallback.a(recentChatData.uin, recentUser6.getType());
                resultRecord = forwardRecentItemView.J;
                if (resultRecord == null) {
                    resultRecord = new ResultRecord();
                }
                ResultRecord resultRecord2 = resultRecord;
                recentUser = recentChatData.ru;
                if (recentUser != null) {
                    int type = recentUser.getType();
                    String str3 = recentChatData.uin;
                    String str4 = recentChatData.name;
                    RecentUser recentUser7 = recentChatData.ru;
                    resultRecord2.init(str3, str4, type, recentUser7 != null ? recentUser7.troopUin : null, "");
                }
                recentUser2 = recentChatData.ru;
                if (!(recentUser2 == null && recentUser2.getType() == 3000)) {
                    DiscussionInfo h16 = this.mDiscussManager.h(recentChatData.uin);
                    Intrinsics.checkNotNullExpressionValue(h16, "mDiscussManager.findDisc\u2026oByID(recentChatData.uin)");
                    if (!h16.hasRenamed()) {
                        forwardRecentItemView.a(recentChatData.name, String.valueOf(this.mDiscussManager.q(recentChatData.uin)), bitmapDrawable, resultRecord2, this.mIsMultiSelectStatus, z16);
                    } else {
                        forwardRecentItemView.a(recentChatData.name, null, bitmapDrawable, resultRecord2, this.mIsMultiSelectStatus, z16);
                    }
                } else {
                    TroopInfo k3 = this.mTroopManager.k(recentChatData.uin);
                    if (k3 != null && !k3.hasSetTroopName() && k3.getMemberNumClient() > 0) {
                        forwardRecentItemView.a(recentChatData.name, String.valueOf(k3.getMemberNumClient()), bitmapDrawable, resultRecord2, this.mIsMultiSelectStatus, z16);
                    } else {
                        forwardRecentItemView.b(recentChatData.name, "", bitmapDrawable, resultRecord2, this.mIsMultiSelectStatus, z16, k3 == null && k.l(this.app, recentChatData.uin));
                    }
                }
                forwardRecentItemView.setOnClickListener(this.mItemViewOnClickListener);
            }
        }
        bitmapDrawable = matchFriendFaceDrawable;
        RecentUser recentUser62 = recentChatData.ru;
        if (recentUser62 == null) {
        }
        resultRecord = forwardRecentItemView.J;
        if (resultRecord == null) {
        }
        ResultRecord resultRecord22 = resultRecord;
        recentUser = recentChatData.ru;
        if (recentUser != null) {
        }
        recentUser2 = recentChatData.ru;
        if (!(recentUser2 == null && recentUser2.getType() == 3000)) {
        }
        forwardRecentItemView.setOnClickListener(this.mItemViewOnClickListener);
    }
}
