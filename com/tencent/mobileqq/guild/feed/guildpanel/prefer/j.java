package com.tencent.mobileqq.guild.feed.guildpanel.prefer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalPreferUpdatedEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedLikeUserListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedLikeUserListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLikeUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStIconInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedLikeUserListCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R2\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0018j\b\u0012\u0004\u0012\u00020\u0003`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110/8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150/8F\u00a2\u0006\u0006\u001a\u0004\b3\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/j;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProLikeUserInfo;", "O1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "U1", "", "getLogTag", "", "serviceType", "", "isMore", "R1", "Le12/a;", "", "i", "Le12/a;", "_totalPreferCnt", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_preferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "getUserList", "()Ljava/util/ArrayList;", "setUserList", "(Ljava/util/ArrayList;)V", "userList", "D", "Ljava/lang/String;", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "attachInfo", "E", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "hasMore", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "totalPreferCnt", "P1", "preferList", "<init>", "()V", UserInfo.SEX_FEMALE, "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends BaseViewModel {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static ViewModelProvider.Factory G = new a();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.a<Long> _totalPreferCnt = new e12.a<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.a<GuildFeedUserPreferData> _preferList = new e12.a<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<GProLikeUserInfo> userList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String attachInfo = "";

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasMore = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/guildpanel/prefer/j$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new j();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/j$b;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "sViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setSViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.guildpanel.prefer.j$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewModelProvider.Factory a() {
            return j.G;
        }

        Companion() {
        }
    }

    private final List<GProLikeUserInfo> O1() {
        ArrayList arrayList = new ArrayList();
        Iterator<GProLikeUserInfo> it = this.userList.iterator();
        while (it.hasNext()) {
            GProLikeUserInfo next = it.next();
            GProLikeUserInfo gProLikeUserInfo = new GProLikeUserInfo();
            gProLikeUserInfo.idd = next.idd;
            gProLikeUserInfo.avatar = next.avatar;
            gProLikeUserInfo.nick = next.nick;
            gProLikeUserInfo.avatarPendant = next.avatarPendant;
            arrayList.add(gProLikeUserInfo);
        }
        return arrayList;
    }

    public static /* synthetic */ void S1(j jVar, int i3, GProStFeed gProStFeed, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        jVar.R1(i3, gProStFeed, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(j this$0, boolean z16, int i3, String str, GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.e(this$0.getTAG(), 1, "getFeedLikeUserList|result=" + i3 + ", err=" + str);
            return;
        }
        this$0.userList.addAll(gProFeedLikeUserListRsp.userList);
        String str2 = gProFeedLikeUserListRsp.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.attachInfo");
        this$0.attachInfo = str2;
        if (!z16) {
            this$0._totalPreferCnt.setValue(Long.valueOf(gProFeedLikeUserListRsp.totalLikeCnt));
        }
        this$0.hasMore = gProFeedLikeUserListRsp.hasMore;
        this$0._preferList.setValue(new GuildFeedUserPreferData(this$0.O1(), gProFeedLikeUserListRsp.hasMore));
    }

    private final void U1(final GProStFeed stFeed) {
        GProFeedLikeUserListReq gProFeedLikeUserListReq = new GProFeedLikeUserListReq();
        gProFeedLikeUserListReq.feedId = stFeed.idd;
        gProFeedLikeUserListReq.guildId = stFeed.channelInfo.sign.guildId;
        o c16 = l.c();
        if (c16 != null) {
            c16.getFeedLikeUserList(gProFeedLikeUserListReq, 2, new IGProGetFeedLikeUserListCallback() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.i
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedLikeUserListCallback
                public final void onResult(int i3, String str, GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
                    j.W1(j.this, stFeed, i3, str, gProFeedLikeUserListRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(j this$0, GProStFeed stFeed, int i3, String str, GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stFeed, "$stFeed");
        if (i3 != 0) {
            QLog.e(this$0.getTAG(), 1, "handlePreferUpdated getFeedLikeUserList|result=" + i3 + ", err=" + str);
            return;
        }
        ArrayList<GProLikeUserInfo> userList = gProFeedLikeUserListRsp.userList;
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(userList, "userList");
        for (GProLikeUserInfo gProLikeUserInfo : userList) {
            GProStUser gProStUser = new GProStUser();
            gProStUser.nick = gProLikeUserInfo.nick;
            gProStUser.idd = String.valueOf(gProLikeUserInfo.idd);
            gProStUser.avatarPendant = gProLikeUserInfo.avatarPendant;
            GProStIconInfo gProStIconInfo = new GProStIconInfo();
            gProStIconInfo.iconUrl = gProLikeUserInfo.avatar;
            gProStUser.icon = gProStIconInfo;
            arrayList.add(gProStUser);
        }
        String str2 = stFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "stFeed.idd");
        bl.c().b(new GuildFeedExternalPreferUpdatedEvent(str2, arrayList, (int) gProFeedLikeUserListRsp.totalLikeCnt), true);
    }

    @NotNull
    public final LiveData<GuildFeedUserPreferData> P1() {
        return this._preferList;
    }

    @NotNull
    public final LiveData<Long> Q1() {
        return this._totalPreferCnt;
    }

    public final void R1(int serviceType, @NotNull GProStFeed stFeed, final boolean isMore) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        if (!this.hasMore) {
            QLog.i(getTAG(), 1, "getFeedLikeUserList has no data, userList=" + this.userList.size());
            return;
        }
        GProFeedLikeUserListReq gProFeedLikeUserListReq = new GProFeedLikeUserListReq();
        if (!isMore) {
            this.userList.clear();
            this.attachInfo = "";
            ArrayList<GProLikeUserInfo> arrayList = new ArrayList<>();
            ArrayList<GProStUser> arrayList2 = stFeed.externalLikeUserList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "stFeed.externalLikeUserList");
            for (GProStUser gProStUser : arrayList2) {
                GProLikeUserInfo gProLikeUserInfo = new GProLikeUserInfo();
                String str = gProStUser.idd;
                Intrinsics.checkNotNullExpressionValue(str, "it.idd");
                gProLikeUserInfo.idd = MiscKt.l(str);
                gProLikeUserInfo.nick = gProStUser.nick;
                gProLikeUserInfo.avatar = gProStUser.icon.iconUrl;
                gProLikeUserInfo.avatarPendant = gProStUser.avatarPendant;
                arrayList.add(gProLikeUserInfo);
            }
            gProFeedLikeUserListReq.needInsertList = arrayList;
        } else {
            gProFeedLikeUserListReq.attachInfo = this.attachInfo;
        }
        gProFeedLikeUserListReq.feedId = stFeed.idd;
        gProFeedLikeUserListReq.guildId = stFeed.channelInfo.sign.guildId;
        o c16 = l.c();
        if (c16 != null) {
            c16.getFeedLikeUserList(gProFeedLikeUserListReq, serviceType, new IGProGetFeedLikeUserListCallback() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedLikeUserListCallback
                public final void onResult(int i3, String str2, GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
                    j.T1(j.this, isMore, i3, str2, gProFeedLikeUserListRsp);
                }
            });
        }
        U1(stFeed);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedUserPreferListViewModel";
    }
}
