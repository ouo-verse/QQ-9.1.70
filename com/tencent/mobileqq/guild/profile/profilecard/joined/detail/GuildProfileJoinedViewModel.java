package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import androidx.lifecycle.ViewModelKt;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchUserJoinedGuildListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary;
import com.tencent.mobileqq.qqguildsdk.data.genc.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bg;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0003HIJB\u0011\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\bE\u0010FJ\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0013\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002J\u0014\u0010\u000e\u001a\u00020\u0012*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0014J\u0006\u0010 \u001a\u00020\u0017J\u0006\u0010!\u001a\u00020\u0017J\u0012\u0010#\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\"H\u0016J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050%0$H\u0016R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\r0,8\u0006\u00a2\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00100,8\u0006\u00a2\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00106R\u0018\u00108\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020A8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel;", "Lcom/tencent/mobileqq/guild/base/b;", "Lwy1/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$JoinGuildResultEvent;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "fetchData", "fetchMoreData", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$b;", "getProfileJoinedGuilds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserJoinedGuildSummary;", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$c;", "parse", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendChannelInfo;", "", "isLeftItem", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "", "state", "isStateValid", "event", "", "updateGuildJoinState", "cnt", "row", "setCardCnt", "", "account", "onAccountChanged", "onCleared", "refresh", FeedManager.LOAD_MORE, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "profileData", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "getProfileData", "()Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "Le12/a;", "dataList", "Le12/a;", "getDataList", "()Le12/a;", "moreData", "getMoreData", UIJsPlugin.EVENT_HIDE_LOADING, "getHideLoading", "fetchDataJob", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "fetchMoreDataJob", "reqCookie", "Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "isEnd", "Z", "mostCardCnt", "I", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getIgpsService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "<init>", "(Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;)V", "Companion", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedViewModel extends com.tencent.mobileqq.guild.base.b<wy1.a> implements com.tencent.mobileqq.guild.base.repository.a, SimpleEventReceiver<JoinGuildLogic.JoinGuildResultEvent> {
    private static final int FRIENDS_NUMBER = 2;
    private static final int GUILD_STATE_KAIHEI = 9;
    private static final int GUILD_STATE_LIVE = 1;
    private static final int GUILD_STATE_VOICE = 4;
    private static final int GUILD_STATE_WORLD = 8;
    private static final int MAX_LABEL_TEXT_LENGTH = 6;
    public static final int MEDAL_OFFICIAL_LEVEL = 2;
    private static final int ONLINE_NUMBER = 3;
    private static final int OPERATE_ARTIFICIAL_WUJI = 9;

    @NotNull
    private static final String TAG = "Guild.profile.GuildProfileJoinedViewModel";

    @NotNull
    private final e12.a<GuildJoinedCardInfo> dataList;

    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchDataJob;

    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchMoreDataJob;

    @NotNull
    private final e12.a<Boolean> hideLoading;
    private boolean isEnd;

    @NotNull
    private final e12.a<GuildJoinedCardInfo> moreData;
    private int mostCardCnt;

    @Nullable
    private final GuildProfileData profileData;

    @Nullable
    private String reqCookie;

    @NotNull
    private ServiceCache$LazyHolder serviceHolder;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkh1/a;", "a", "Lkh1/a;", "b", "()Lkh1/a;", "result", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$c;", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$c;", "()Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$c;", "info", "<init>", "(Lkh1/a;Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedViewModel$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GetJoinedGuildRsp {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final kh1.a result;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GuildJoinedCardInfo info;

        public GetJoinedGuildRsp(@NotNull kh1.a result, @NotNull GuildJoinedCardInfo info) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(info, "info");
            this.result = result;
            this.info = info;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildJoinedCardInfo getInfo() {
            return this.info;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final kh1.a getResult() {
            return this.result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetJoinedGuildRsp)) {
                return false;
            }
            GetJoinedGuildRsp getJoinedGuildRsp = (GetJoinedGuildRsp) other;
            if (Intrinsics.areEqual(this.result, getJoinedGuildRsp.result) && Intrinsics.areEqual(this.info, getJoinedGuildRsp.info)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.info.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetJoinedGuildRsp(result=" + this.result + ", info=" + this.info + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "numStr", "Z", "c", "()Z", "isEnd", "", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "Ljava/util/List;", "()Ljava/util/List;", "dataList", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedViewModel$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildJoinedCardInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String numStr;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isEnd;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<GuildProfileJoinedData> dataList;

        public GuildJoinedCardInfo(@NotNull String numStr, boolean z16, @NotNull List<GuildProfileJoinedData> dataList) {
            Intrinsics.checkNotNullParameter(numStr, "numStr");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.numStr = numStr;
            this.isEnd = z16;
            this.dataList = dataList;
        }

        @NotNull
        public final List<GuildProfileJoinedData> a() {
            return this.dataList;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getNumStr() {
            return this.numStr;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildJoinedCardInfo)) {
                return false;
            }
            GuildJoinedCardInfo guildJoinedCardInfo = (GuildJoinedCardInfo) other;
            if (Intrinsics.areEqual(this.numStr, guildJoinedCardInfo.numStr) && this.isEnd == guildJoinedCardInfo.isEnd && Intrinsics.areEqual(this.dataList, guildJoinedCardInfo.dataList)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.numStr.hashCode() * 31;
            boolean z16 = this.isEnd;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.dataList.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildJoinedCardInfo(numStr=" + this.numStr + ", isEnd=" + this.isEnd + ", dataList=" + this.dataList + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFetchUserJoinedGuildListRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFetchUserJoinedGuildListRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements bg {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<GetJoinedGuildRsp> f231464b;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super GetJoinedGuildRsp> continuation) {
            this.f231464b = continuation;
        }

        @Override // wh2.bg
        public final void a(int i3, String errMsg, IGProFetchUserJoinedGuildListRsp iGProFetchUserJoinedGuildListRsp) {
            GuildProfileJoinedViewModel.this.getHideLoading().setValue(Boolean.TRUE);
            if (i3 == 0 && !iGProFetchUserJoinedGuildListRsp.getJoinedGuildSummary().getGuildList().isEmpty()) {
                Logger.f235387a.d().i(GuildProfileJoinedViewModel.TAG, 1, "getProfileJoinedGuilds success cookie: " + iGProFetchUserJoinedGuildListRsp.getCookie() + " ,isEnd: " + iGProFetchUserJoinedGuildListRsp.getIsEnd() + ", size: " + iGProFetchUserJoinedGuildListRsp.getJoinedGuildSummary().getGuildList().size());
                GuildProfileJoinedViewModel.this.reqCookie = iGProFetchUserJoinedGuildListRsp.getCookie();
                GuildProfileJoinedViewModel.this.isEnd = iGProFetchUserJoinedGuildListRsp.getIsEnd();
                Continuation<GetJoinedGuildRsp> continuation = this.f231464b;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                kh1.a aVar = new kh1.a(i3, errMsg);
                GuildProfileJoinedViewModel guildProfileJoinedViewModel = GuildProfileJoinedViewModel.this;
                IGProUserJoinedGuildSummary joinedGuildSummary = iGProFetchUserJoinedGuildListRsp.getJoinedGuildSummary();
                Intrinsics.checkNotNullExpressionValue(joinedGuildSummary, "rsp.joinedGuildSummary");
                continuation.resumeWith(Result.m476constructorimpl(new GetJoinedGuildRsp(aVar, guildProfileJoinedViewModel.parse(joinedGuildSummary))));
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getProfileJoinedGuilds failed result: " + i3 + " ,errMsg: " + errMsg + " ,cookie: " + iGProFetchUserJoinedGuildListRsp.getCookie() + " ,isEnd: " + iGProFetchUserJoinedGuildListRsp.getIsEnd() + ", size: " + iGProFetchUserJoinedGuildListRsp.getJoinedGuildSummary().getGuildList().size();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(GuildProfileJoinedViewModel.TAG, 1, (String) it.next(), null);
            }
            Continuation<GetJoinedGuildRsp> continuation2 = this.f231464b;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            continuation2.resumeWith(Result.m476constructorimpl(new GetJoinedGuildRsp(new kh1.a(i3, errMsg), new GuildJoinedCardInfo("", true, new ArrayList()))));
        }
    }

    public GuildProfileJoinedViewModel(@Nullable GuildProfileData guildProfileData) {
        super(new wy1.a());
        this.profileData = guildProfileData;
        this.dataList = new e12.a<>();
        this.moreData = new e12.a<>();
        this.hideLoading = new e12.a<>();
        this.serviceHolder = new ServiceCache$LazyHolder(TAG);
        this.mostCardCnt = 8;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchData() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.profile.GuildProfileJoinedViewModel fetchData", null, null, Boolean.TRUE, new GuildProfileJoinedViewModel$fetchData$1(this, null), 6, null);
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchMoreData() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.profile.GuildProfileJoinedViewModel fetchMoreData", null, null, Boolean.TRUE, new GuildProfileJoinedViewModel$fetchMoreData$1(this, null), 6, null);
    }

    private final IGPSService getIgpsService() {
        return this.serviceHolder.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getProfileJoinedGuilds(Continuation<? super GetJoinedGuildRsp> continuation) {
        Continuation intercepted;
        String str;
        Object coroutine_suspended;
        GuildBaseProfileData guildBaseProfileData;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        GuildProfileData guildProfileData = this.profileData;
        String str2 = null;
        if (guildProfileData != null && (guildBaseProfileData = guildProfileData.getGuildBaseProfileData()) != null) {
            str = guildBaseProfileData.b();
        } else {
            str = null;
        }
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "profileData?.guildBasePr\u2026: return@suspendCoroutine");
            GuildBaseProfileData guildBaseProfileData2 = this.profileData.getGuildBaseProfileData();
            if (guildBaseProfileData2 != null) {
                str2 = guildBaseProfileData2.e();
            }
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "profileData.guildBasePro\u2026: return@suspendCoroutine");
                ax axVar = new ax();
                axVar.f(Long.parseLong(str2));
                axVar.h(Long.parseLong(str));
                axVar.e(this.reqCookie);
                axVar.g(this.mostCardCnt);
                getIgpsService().fetchUserJoinedGuildListV2(axVar, new d(safeContinuation));
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final boolean isStateValid(int state) {
        if (state == 1 || state == 4 || state == 8 || state == 9) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildJoinedCardInfo parse(IGProUserJoinedGuildSummary iGProUserJoinedGuildSummary) {
        ArrayList arrayList = new ArrayList();
        ArrayList<IGProRecommendChannelInfo> guildList = iGProUserJoinedGuildSummary.getGuildList();
        Intrinsics.checkNotNullExpressionValue(guildList, "this.guildList");
        boolean z16 = false;
        for (IGProRecommendChannelInfo it : guildList) {
            z16 = !z16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(parse(it, z16));
        }
        String joinedCountStr = iGProUserJoinedGuildSummary.getJoinedCountStr();
        Intrinsics.checkNotNullExpressionValue(joinedCountStr, "this.joinedCountStr");
        return new GuildJoinedCardInfo(joinedCountStr, this.isEnd, arrayList);
    }

    private final void updateGuildJoinState(JoinGuildLogic.JoinGuildResultEvent event) {
        boolean z16;
        GuildJoinedCardInfo value;
        List<GuildProfileJoinedData> a16;
        Object obj;
        String guildId = event.getGuildId();
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(event.getResult(), event.getSecurity())) {
            if (guildId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (value = this.dataList.getValue()) != null && (a16 = value.a()) != null) {
                Iterator<T> it = a16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((GuildProfileJoinedData) obj).getGuildId(), guildId)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                GuildProfileJoinedData guildProfileJoinedData = (GuildProfileJoinedData) obj;
                if (guildProfileJoinedData != null) {
                    guildProfileJoinedData.q(2);
                    e12.a<GuildJoinedCardInfo> aVar = this.dataList;
                    aVar.setValue(aVar.getValue());
                }
            }
        }
    }

    @NotNull
    public final e12.a<GuildJoinedCardInfo> getDataList() {
        return this.dataList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<JoinGuildLogic.JoinGuildResultEvent>> getEventClass() {
        ArrayList<Class<JoinGuildLogic.JoinGuildResultEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(JoinGuildLogic.JoinGuildResultEvent.class);
        return arrayListOf;
    }

    @NotNull
    public final e12.a<Boolean> getHideLoading() {
        return this.hideLoading;
    }

    @NotNull
    public final e12.a<GuildJoinedCardInfo> getMoreData() {
        return this.moreData;
    }

    @Nullable
    public final GuildProfileData getProfileData() {
        return this.profileData;
    }

    public final void loadMore() {
        Job a16;
        if (this.isEnd) {
            Logger.f235387a.d().i(TAG, 1, "loadMore get isEnd true");
            this.moreData.setValue(new GuildJoinedCardInfo("", true, new ArrayList()));
            return;
        }
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchMoreDataJob;
        if (bVar != null && (a16 = bVar.a()) != null) {
            Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d(TAG, 1, "fetchMoreData: begin data:" + getProfileData());
        }
        this.fetchMoreDataJob = fetchMoreData();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.serviceHolder = new ServiceCache$LazyHolder(TAG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof JoinGuildLogic.JoinGuildResultEvent) {
            updateGuildJoinState((JoinGuildLogic.JoinGuildResultEvent) event);
        }
    }

    public final void refresh() {
        Job a16;
        this.reqCookie = null;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchDataJob;
        if (bVar != null && (a16 = bVar.a()) != null) {
            Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d(TAG, 1, "fetchData: begin data:" + getProfileData());
        }
        this.fetchDataJob = fetchData();
    }

    public final void setCardCnt(int cnt, int row) {
        this.mostCardCnt = row * cnt;
    }

    private final GuildProfileJoinedData parse(IGProRecommendChannelInfo iGProRecommendChannelInfo, boolean z16) {
        boolean z17;
        int i3;
        String str;
        boolean z18 = iGProRecommendChannelInfo.getMedalLevel() == 2;
        ArrayList arrayList = new ArrayList();
        ArrayList<IGProRecommendGuildState> stateList = iGProRecommendChannelInfo.getStateList();
        Intrinsics.checkNotNullExpressionValue(stateList, "this.stateList");
        if (true ^ stateList.isEmpty()) {
            int state = iGProRecommendChannelInfo.getStateList().get(0).getState();
            String desc = iGProRecommendChannelInfo.getStateList().get(0).getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "this.stateList[0].desc");
            z17 = isStateValid(state);
            i3 = state;
            str = desc;
        } else {
            z17 = false;
            i3 = 0;
            str = "";
        }
        ArrayList<IGProRecommendLabel> tagList = iGProRecommendChannelInfo.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList, "this.tagList");
        int i16 = 0;
        String str2 = "";
        for (IGProRecommendLabel iGProRecommendLabel : tagList) {
            int labelType = iGProRecommendLabel.getLabelType();
            if (labelType == 2) {
                i16 = iGProRecommendLabel.getLabelValue();
            } else if (labelType != 3) {
                if (labelType == 9 && iGProRecommendLabel.getLabelName().length() <= 6 && (!z17 || arrayList.size() <= 0)) {
                    String labelName = iGProRecommendLabel.getLabelName();
                    if (labelName == null) {
                        labelName = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(labelName, "tagItem.labelName ?: \"\"");
                    }
                    arrayList.add(labelName);
                }
            } else {
                String labelName2 = iGProRecommendLabel.getLabelName();
                Intrinsics.checkNotNullExpressionValue(labelName2, "tagItem.labelName");
                str2 = labelName2;
            }
        }
        String valueOf = String.valueOf(iGProRecommendChannelInfo.getGuildId());
        String joinGuildSig = iGProRecommendChannelInfo.getJoinGuildSig();
        int joinedGuild = iGProRecommendChannelInfo.getJoinedGuild();
        String guildName = iGProRecommendChannelInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "this.guildName");
        String guildProfile = iGProRecommendChannelInfo.getGuildProfile();
        Intrinsics.checkNotNullExpressionValue(guildProfile, "this.guildProfile");
        String guildIcon = iGProRecommendChannelInfo.getGuildIcon();
        Intrinsics.checkNotNullExpressionValue(guildIcon, "this.guildIcon");
        String coverUrl = iGProRecommendChannelInfo.getCoverUrl();
        Intrinsics.checkNotNullExpressionValue(coverUrl, "this.coverUrl");
        List t16 = GuildMedalUtils.t(iGProRecommendChannelInfo.getMedalInfoList(), 0, 2, null);
        ArrayList<IGProRecommendLabel> tagList2 = iGProRecommendChannelInfo.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList2, "this.tagList");
        return new GuildProfileJoinedData(valueOf, joinGuildSig, joinedGuild, guildName, guildProfile, guildIcon, coverUrl, z18, z16, i3, str, i16, str2, null, arrayList, t16, tagList2, 8192, null);
    }
}
