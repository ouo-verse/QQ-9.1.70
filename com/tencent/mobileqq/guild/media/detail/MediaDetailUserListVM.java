package com.tencent.mobileqq.guild.media.detail;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.detail.e;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0013\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0017j\b\u0012\u0004\u0012\u00020\u0006`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/media/detail/e;", "event", "", "T1", "", "guildId", "channelId", "", "S1", "initData", FeedManager.LOAD_MORE, "U1", "W1", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "R1", "P1", "com/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM$b", "i", "Lcom/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM$b;", "mediaObserver", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashSet;", "filterFromSet", "Lcom/tencent/mobileqq/guild/media/detail/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/detail/d;", "repo", "Lcom/tencent/mobileqq/guild/util/cn;", "D", "Lcom/tencent/mobileqq/guild/util/cn;", "Q1", "()Lcom/tencent/mobileqq/guild/util/cn;", "notifyUiEvent", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaDetailUserListVM extends ViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d repo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<e> notifyUiEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mediaObserver = new b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> filterFromSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.detail.MediaDetailUserListVM$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MediaDetailUserListVM a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            ViewModel viewModel = new ViewModelProvider(owner).get(MediaDetailUserListVM.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)\u2026ilUserListVM::class.java]");
            return (MediaDetailUserListVM) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0011\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J,\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "from", "guildId", "roomId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfoParam", "", HippyTKDListViewAdapter.X, "operatedUserId", "", "status", "y", "", "userIdList", "isEnter", "r", "channelId", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "w", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", "j", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void j(@Nullable String from, @Nullable IGProChannelUserNum channelNumber) {
            super.j(from, channelNumber);
            if (channelNumber != null) {
                MediaDetailUserListVM.this.T1(new e.d(channelNumber.getUserNum()));
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void r(@NotNull List<String> userIdList, boolean isEnter) {
            Intrinsics.checkNotNullParameter(userIdList, "userIdList");
            if (!isEnter && MediaDetailUserListVM.this.repo.j(userIdList)) {
                MediaDetailUserListVM.this.T1(e.c.f228779a);
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(@NotNull String guildId, @NotNull String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            if (MediaDetailUserListVM.this.S1(guildId, channelId) && userInfoList != null) {
                MediaDetailUserListVM.this.T1(new e.f(userInfoList));
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@NotNull String from, @NotNull String guildId, @NotNull String roomId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfoParam) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            if (MediaDetailUserListVM.this.S1(guildId, roomId) && MediaDetailUserListVM.this.filterFromSet.contains(from)) {
                MediaDetailUserListVM.this.repo.b(com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a, false);
                MediaDetailUserListVM.this.T1(e.C7833e.f228781a);
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void y(@Nullable String from, @Nullable String operatedUserId, boolean status) {
            Object obj;
            if (Intrinsics.areEqual(from, "setUserVoicelessToMe")) {
                Iterator<T> it = MediaDetailUserListVM.this.repo.e().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((p) obj).f228093a, operatedUserId)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                p pVar = (p) obj;
                if (pVar != null) {
                    pVar.f228112t = status;
                }
                MediaDetailUserListVM.this.T1(e.C7833e.f228781a);
            }
        }
    }

    public MediaDetailUserListVM() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("onAudioChannelUserAdd");
        hashSet.add("onUserMuteSeatInGuild");
        hashSet.add("pushOnTRTCAudioAvailable");
        hashSet.add("pushOnTRTCVideoAvailable");
        hashSet.add("onRaiseHandInfoUpdate");
        hashSet.add("onUserRaiseUpHandStateUpdate");
        hashSet.add("setUserVoicelessToMe");
        hashSet.add("setUserVoiceVolumeToMe");
        hashSet.add("onAVUserInfoChangeNotifyForAll");
        hashSet.add("onPushPermissionInGuild");
        this.filterFromSet = hashSet;
        this.repo = new d();
        this.notifyUiEvent = new cn<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S1(String guildId, String channelId) {
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        if (Intrinsics.areEqual(guildId, a16.getGuildID()) && Intrinsics.areEqual(channelId, a16.E())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(e event) {
        this.notifyUiEvent.setValue(event);
    }

    public final void P1() {
        this.repo.e().clear();
    }

    @NotNull
    public final cn<e> Q1() {
        return this.notifyUiEvent;
    }

    @NotNull
    public final List<p> R1() {
        return this.repo.e();
    }

    public final void U1() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mediaObserver);
    }

    public final void W1() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mediaObserver);
    }

    public final void initData() {
        this.repo.g();
        T1(e.a.f228777a);
    }

    public final void loadMore() {
        this.repo.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.detail.MediaDetailUserListVM$loadMore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MediaDetailUserListVM.this.T1(e.b.f228778a);
            }
        });
    }
}
