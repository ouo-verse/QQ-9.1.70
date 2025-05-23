package com.tencent.mobileqq.guild.rolegroup.model.puller;

import androidx.lifecycle.c;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleToMemberListModel;
import com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.tmdownloader.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uh2.f;
import vh2.ai;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0003\t\u0010-B+\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b\u0015\u0010!R(\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b\u001c\u0010&\"\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller;", "", "", h.F, "", "isTransferGuild", "f", "e", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "b", "setChannelId", "channelId", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$b;", "c", "Lmqq/util/WeakReference;", "()Lmqq/util/WeakReference;", "setListenerRef", "(Lmqq/util/WeakReference;)V", "listenerRef", "Luh2/f;", "d", "Luh2/f;", "roleService", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "memberListModel", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$PullStep;", "Ljava/util/concurrent/atomic/AtomicReference;", "()Ljava/util/concurrent/atomic/AtomicReference;", "setPullState", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "pullState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lmqq/util/WeakReference;)V", "g", "PullStep", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberPuller {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<b> listenerRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f roleService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoleToMemberListModel memberListModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicReference<PullStep> pullState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$PullStep;", "", "(Ljava/lang/String;I)V", a.CONNTECTSTATE_INIT, "HAS_MORE", "PULL_ENDING", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PullStep {
        INIT,
        HAS_MORE,
        PULL_ENDING
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$b;", "", "Lri1/a;", "error", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$PullStep;", "step", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "listModel", "", "totalMemberNum", "", "h1", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void h1(@NotNull ri1.a error, @NotNull PullStep step, @Nullable RoleToMemberListModel listModel, int totalMemberNum);
    }

    @JvmOverloads
    public GuildMemberPuller(@NotNull String guildId, @NotNull String channelId, @Nullable WeakReference<b> weakReference) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.listenerRef = weakReference;
        this.roleService = (f) MiscKt.d(IGPSService.class, "Guild.rg.GuildMemberPuller", null, 4, null);
        this.memberListModel = new RoleToMemberListModel(this.guildId);
        this.pullState = new AtomicReference<>(PullStep.INIT);
    }

    public static /* synthetic */ void g(GuildMemberPuller guildMemberPuller, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMemberPuller.f(z16);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final WeakReference<b> b() {
        return this.listenerRef;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RoleToMemberListModel getMemberListModel() {
        return this.memberListModel;
    }

    @NotNull
    public final AtomicReference<PullStep> d() {
        return this.pullState;
    }

    public final void e() {
        this.roleService = (f) MiscKt.d(IGPSService.class, "Guild.rg.GuildMemberPuller", null, 4, null);
    }

    public final void f(final boolean isTransferGuild) {
        boolean z16;
        if (this.pullState.get() == PullStep.INIT) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.roleService.fetchMemberListWithRole(this.guildId, this.channelId, 50, z16, new ai() { // from class: com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller$pullMembers$1
            @Override // vh2.ai
            public void a(int code, @Nullable String errMsg, boolean hasMore, int totalMemberNum, @Nullable List<IGProRoleMemberListInfo> roleList) {
                boolean z17;
                GuildMemberPuller.b bVar;
                GuildMemberPuller.b bVar2;
                ri1.a result = ri1.a.e(code, errMsg, null);
                if (!result.d()) {
                    WeakReference<GuildMemberPuller.b> b16 = GuildMemberPuller.this.b();
                    if (b16 != null && (bVar2 = b16.get()) != null) {
                        Intrinsics.checkNotNullExpressionValue(result, "result");
                        GuildMemberPuller.PullStep pullStep = GuildMemberPuller.this.d().get();
                        Intrinsics.checkNotNullExpressionValue(pullStep, "pullState.get()");
                        bVar2.h1(result, pullStep, GuildMemberPuller.this.getMemberListModel(), totalMemberNum);
                        return;
                    }
                    return;
                }
                if (isTransferGuild && roleList != null) {
                    CollectionsKt__MutableCollectionsKt.removeAll((List) roleList, (Function1) new Function1<IGProRoleMemberListInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller$pullMembers$1$onFetchMemberListWithRole$1
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull IGProRoleMemberListInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(it.getRoleInfo().getRoleType() == 3 || it.getRoleInfo().getRoleType() == 4);
                        }
                    });
                }
                if (roleList != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    GuildMemberPuller.this.getMemberListModel().d(roleList);
                    GuildMemberPuller.this.getMemberListModel().b();
                    GuildMemberPuller.this.getMemberListModel().a();
                    if (hasMore) {
                        c.a(GuildMemberPuller.this.d(), GuildMemberPuller.PullStep.INIT, GuildMemberPuller.PullStep.HAS_MORE);
                    } else {
                        GuildMemberPuller.this.d().set(GuildMemberPuller.PullStep.PULL_ENDING);
                    }
                    WeakReference<GuildMemberPuller.b> b17 = GuildMemberPuller.this.b();
                    if (b17 != null && (bVar = b17.get()) != null) {
                        Intrinsics.checkNotNullExpressionValue(result, "result");
                        GuildMemberPuller.PullStep pullStep2 = GuildMemberPuller.this.d().get();
                        Intrinsics.checkNotNullExpressionValue(pullStep2, "pullState.get()");
                        bVar.h1(result, pullStep2, GuildMemberPuller.this.getMemberListModel(), totalMemberNum);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        });
    }

    public final void h() {
        this.pullState.set(PullStep.INIT);
        this.memberListModel.l();
    }
}
