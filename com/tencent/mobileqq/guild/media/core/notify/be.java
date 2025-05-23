package com.tencent.mobileqq.guild.media.core.notify;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/be;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "I", "b", "()I", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "e", "Z", "a", "()Z", "sealMic", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class be implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int volume;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean sealMic;

    /* renamed from: a, reason: from getter */
    public final boolean getSealMic() {
        return this.sealMic;
    }

    /* renamed from: b, reason: from getter */
    public final int getVolume() {
        return this.volume;
    }
}
