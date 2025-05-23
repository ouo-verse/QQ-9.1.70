package com.tencent.guild.aio.reserve2.busi.chosen;

import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mvi.base.route.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "()V", "GuildGetCurMsgUIState", "GuildInitListUIState", "GuildUpdateListUIState", "GuildUpdateNickNameUIState", "GuildUpdatePicIvUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildChosenMsgState implements GuildReserve2UIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildGetCurMsgUIState;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "d", "Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "a", "()Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", "chosenMsg", "<init>", "(Lcom/tencent/guild/aio/reserve2/busi/chosen/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildGetCurMsgUIState extends GuildChosenMsgState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a chosenMsg;

        public GuildGetCurMsgUIState(@NotNull a chosenMsg) {
            Intrinsics.checkNotNullParameter(chosenMsg, "chosenMsg");
            this.chosenMsg = chosenMsg;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getChosenMsg() {
            return this.chosenMsg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildInitListUIState;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "msgSeqList", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInitListUIState extends GuildChosenMsgState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<IGProTopMsg> msgSeqList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildInitListUIState(@NotNull List<? extends IGProTopMsg> msgSeqList, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.msgSeqList = msgSeqList;
            this.channelId = channelId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final List<IGProTopMsg> b() {
            return this.msgSeqList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildUpdateListUIState;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "msgSeqList", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildUpdateListUIState extends GuildChosenMsgState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<IGProTopMsg> msgSeqList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildUpdateListUIState(@NotNull List<? extends IGProTopMsg> msgSeqList, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.msgSeqList = msgSeqList;
            this.channelId = channelId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final List<IGProTopMsg> b() {
            return this.msgSeqList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildUpdateNickNameUIState;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tinyId", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildUpdateNickNameUIState extends GuildChosenMsgState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tinyId;

        public GuildUpdateNickNameUIState(@NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            this.tinyId = tinyId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildUpdatePicIvUIState;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "", "d", "J", "b", "()J", "updatePicSeq", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "filePath", "<init>", "(JLjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildUpdatePicIvUIState extends GuildChosenMsgState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long updatePicSeq;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String filePath;

        public GuildUpdatePicIvUIState(long j3, @Nullable String str) {
            this.updatePicSeq = j3;
            this.filePath = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        /* renamed from: b, reason: from getter */
        public final long getUpdatePicSeq() {
            return this.updatePicSeq;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
