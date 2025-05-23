package com.tencent.guild.aio.component.album;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "AlbumNumState", "AlbumPanelState", "AlbumSafetySwitch", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState$AlbumNumState;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState$AlbumPanelState;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState$AlbumSafetySwitch;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildAioAlbumUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState$AlbumNumState;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState;", "", "d", "I", "a", "()I", WidgetCacheConstellationData.NUM, "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class AlbumNumState extends GuildAioAlbumUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int num;

        public AlbumNumState(int i3) {
            super(null);
            this.num = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getNum() {
            return this.num;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState$AlbumPanelState;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState;", "", "d", "Z", "a", "()Z", "isShowing", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class AlbumPanelState extends GuildAioAlbumUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowing;

        public AlbumPanelState(boolean z16) {
            super(null);
            this.isShowing = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShowing() {
            return this.isShowing;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState$AlbumSafetySwitch;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState;", "", "d", "Z", "a", "()Z", "isFunctionOn", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class AlbumSafetySwitch extends GuildAioAlbumUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isFunctionOn;

        public AlbumSafetySwitch(boolean z16) {
            super(null);
            this.isFunctionOn = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsFunctionOn() {
            return this.isFunctionOn;
        }
    }

    public /* synthetic */ GuildAioAlbumUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildAioAlbumUIState() {
    }
}
