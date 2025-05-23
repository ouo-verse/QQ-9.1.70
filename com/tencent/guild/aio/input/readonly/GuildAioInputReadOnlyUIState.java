package com.tencent.guild.aio.input.readonly;

import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/input/readonly/GuildAioInputReadOnlyUIState;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "ShowReadOnlyView", "Lcom/tencent/guild/aio/input/readonly/GuildAioInputReadOnlyUIState$ShowReadOnlyView;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildAioInputReadOnlyUIState extends GuildAioDefaultInputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/input/readonly/GuildAioInputReadOnlyUIState$ShowReadOnlyView;", "Lcom/tencent/guild/aio/input/readonly/GuildAioInputReadOnlyUIState;", "", "e", "Z", "b", "()Z", "isShowReadOnlyView", "", "f", "I", "a", "()I", "permissions", "<init>", "(ZI)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ShowReadOnlyView extends GuildAioInputReadOnlyUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowReadOnlyView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int permissions;

        public ShowReadOnlyView(boolean z16, int i3) {
            super(null);
            this.isShowReadOnlyView = z16;
            this.permissions = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsShowReadOnlyView() {
            return this.isShowReadOnlyView;
        }
    }

    public /* synthetic */ GuildAioInputReadOnlyUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    GuildAioInputReadOnlyUIState() {
    }
}
