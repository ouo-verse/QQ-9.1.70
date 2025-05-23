package com.tencent.mobileqq.guild.live.livemanager.player;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0003\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\r\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/i;", "", "", "a", "J", "getMinBufferDuration", "()J", "setMinBufferDuration", "(J)V", "minBufferDuration", "b", "setMaxBufferDuration", "maxBufferDuration", "c", "getMinBufferingTime", "setMinBufferingTime", "minBufferingTime", "d", "getMaxBufferingTime", "setMaxBufferingTime", "maxBufferingTime", "e", "getBufferingTimeOut", "setBufferingTimeOut", "bufferingTimeOut", "", "f", "I", "()I", "setLatencyStrategy", "(I)V", "latencyStrategy", "", "g", UserInfo.SEX_FEMALE, "()F", "setSpeedUpRate", "(F)V", "speedUpRate", "<init>", "()V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long minBufferDuration = 6000;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long maxBufferDuration = 60000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long minBufferingTime = 1000;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long maxBufferingTime = 10000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long bufferingTimeOut = 15000;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int latencyStrategy = 1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float speedUpRate = 2.0f;

    /* renamed from: a, reason: from getter */
    public final int getLatencyStrategy() {
        return this.latencyStrategy;
    }

    /* renamed from: b, reason: from getter */
    public final long getMaxBufferDuration() {
        return this.maxBufferDuration;
    }

    /* renamed from: c, reason: from getter */
    public final float getSpeedUpRate() {
        return this.speedUpRate;
    }
}
