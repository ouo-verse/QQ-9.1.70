package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0007\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00020\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0018\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00020\u00040\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/GuildInfoProcess;", "", "", "f", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "block", "c", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "d", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "e", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "guildInfo", "", "Ljava/lang/ref/WeakReference;", "Ljava/util/List;", "waitingBlocks", "", "Z", "hasFetched", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class GuildInfoProcess {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<WeakReference<Function1<IGProGuildInfo, Unit>>> waitingBlocks;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasFetched;

    public GuildInfoProcess(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.waitingBlocks = new ArrayList();
        f();
    }

    public final void c(@NotNull Function1<? super IGProGuildInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.hasFetched) {
            block.invoke(this.guildInfo);
        } else {
            this.waitingBlocks.add(new WeakReference<>(block));
        }
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public final void e(@Nullable IGProGuildInfo iGProGuildInfo) {
        this.guildInfo = iGProGuildInfo;
    }

    public final void f() {
        this.hasFetched = false;
        GuildMainFrameUtils.k(this.guildId, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildInfoProcess$updateGuildInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                List list;
                List list2;
                GuildInfoProcess.this.e(iGProGuildInfo);
                GuildInfoProcess.this.hasFetched = true;
                list = GuildInfoProcess.this.waitingBlocks;
                GuildInfoProcess guildInfoProcess = GuildInfoProcess.this;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Function1 function1 = (Function1) ((WeakReference) it.next()).get();
                    if (function1 != null) {
                        function1.invoke(guildInfoProcess.getGuildInfo());
                    }
                }
                list2 = GuildInfoProcess.this.waitingBlocks;
                list2.clear();
            }
        });
    }
}
