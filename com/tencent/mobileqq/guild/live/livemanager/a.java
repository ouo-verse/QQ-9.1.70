package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/a;", "Lcom/tencent/mobileqq/guild/live/livemanager/f;", "", "d", "e", "a", "c", "b", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "getCore", "()Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core;

    public a(@NotNull GLiveChannelCore core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.f
    public boolean a() {
        if (this.core.s().getLiveType() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.f
    public boolean b() {
        LiveChannelRoomInfo liveChannelRoomInfo = this.core.s().getLiveChannelRoomInfo();
        if (liveChannelRoomInfo != null && liveChannelRoomInfo.getPlatform() != 1 && liveChannelRoomInfo.getPlatform() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.f
    public boolean c() {
        if (this.core.s().getAnchorIsSelf() && !e() && !a() && !b()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.f
    public boolean d() {
        if (this.core.s().getLiveType() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.f
    public boolean e() {
        if (this.core.s().getLiveType() == 1) {
            return true;
        }
        return false;
    }
}
