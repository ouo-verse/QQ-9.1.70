package bq2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.vm.ListType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000eB!\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0004R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lbq2/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/ListType;", "b", "", "fromNet", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "", "callback", "d", "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "", "uin", "Landroid/graphics/Bitmap;", "e", "Z", h.F, "()Z", "isShowRecentChatList", "g", "isMatchFriendUserList", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "c", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "f", "()Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "forwardOption", "<init>", "(ZZLcom/tencent/mobileqq/forward/ForwardBaseOption;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends com.tencent.mobileqq.selectfriend.relationlist.model.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowRecentChatList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isMatchFriendUserList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ForwardBaseOption forwardOption;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"bq2/a$b", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements RecentContactListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<SharedNode>, Unit> f28979a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f28980b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<SharedNode>, Unit> function1, a aVar) {
            this.f28979a = function1;
            this.f28980b = aVar;
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(List<RecentUser> recentUserList) {
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            this.f28979a.invoke(com.tencent.mobileqq.selectfriend.relationlist.a.c(recentUserList, this.f28980b.getIsShowRecentChatList(), this.f28980b.getIsMatchFriendUserList(), this.f28980b.getForwardOption(), false, 16, null));
        }
    }

    public a(boolean z16, boolean z17, ForwardBaseOption forwardBaseOption) {
        this.isShowRecentChatList = z16;
        this.isMatchFriendUserList = z17;
        this.forwardOption = forwardBaseOption;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public Drawable a(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        BaseApplication context = BaseApplication.getContext();
        Object bizData = sharedNode.getBizData();
        Intrinsics.checkNotNull(bizData, "null cannot be cast to non-null type com.tencent.mobileqq.data.RecentUser");
        RecentUser recentUser = (RecentUser) bizData;
        if (recentUser.getType() == 10014) {
            return ((IQQGuildService) appInterface.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(recentUser.troopUin, 100, null, true);
        }
        if (Intrinsics.areEqual(AppConstants.DATALINE_PC_UIN, sharedNode.getKey())) {
            return context.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
        }
        if (recentUser.getType() == 1046) {
            return ((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(appInterface, sharedNode.getKey());
        }
        Bitmap e16 = e(sharedNode.getKey());
        return e16 != null ? new BitmapDrawable(e16) : null;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public ListType b() {
        return ListType.NORMAL;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public void d(boolean fromNet, Function1<? super List<SharedNode>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("RecentListModel", 1, "getSharedNodeList fail because app is null");
            callback.invoke(null);
        } else {
            ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(peekAppRuntime, new b(callback, this), false);
        }
    }

    protected final Bitmap e(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!Intrinsics.areEqual(AppConstants.SEC_MSG_UIN, uin)) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), R.drawable.f162141ft4);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* renamed from: f, reason: from getter */
    public final ForwardBaseOption getForwardOption() {
        return this.forwardOption;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsMatchFriendUserList() {
        return this.isMatchFriendUserList;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsShowRecentChatList() {
        return this.isShowRecentChatList;
    }
}
