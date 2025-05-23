package com.tencent.guild.aio.reserve2.busi.banner;

import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u001d\b\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0082\u0001\u0002\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "", "d", "Z", "a", "()Z", "isContainerVisible", "e", "b", "isLoad", "<init>", "(ZZ)V", "AIOVisibilityChange", "InitBanner", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState$AIOVisibilityChange;", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState$InitBanner;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildOperationBannerUIState implements Reserve1UIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isContainerVisible;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isLoad;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState$AIOVisibilityChange;", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState;", "", "f", "Z", "c", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class AIOVisibilityChange extends GuildOperationBannerUIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AIOVisibilityChange(boolean z16) {
            super(r2, r2, 3, null);
            boolean z17 = false;
            this.visible = z16;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState$InitBanner;", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState;", "", "f", "J", "e", "()J", "guildId", h.F, "c", "channelId", "", "i", "I", "d", "()I", "channelType", "<init>", "(JJI)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class InitBanner extends GuildOperationBannerUIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long guildId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final long channelId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final int channelType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InitBanner(long j3, long j16, int i3) {
            super(r2, r2, 3, null);
            boolean z16 = false;
            this.guildId = j3;
            this.channelId = j16;
            this.channelType = i3;
        }

        /* renamed from: c, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: d, reason: from getter */
        public final int getChannelType() {
            return this.channelType;
        }

        /* renamed from: e, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }
    }

    public /* synthetic */ GuildOperationBannerUIState(boolean z16, boolean z17, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, z17);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsContainerVisible() {
        return this.isContainerVisible;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsLoad() {
        return this.isLoad;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    GuildOperationBannerUIState(boolean z16, boolean z17) {
        this.isContainerVisible = z16;
        this.isLoad = z17;
    }

    public /* synthetic */ GuildOperationBannerUIState(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, null);
    }
}
