package lh0;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Llh0/c;", "Llh0/a;", "", "a", "I", "()I", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "b", "duration", "<init>", "(II)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class c extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int currentTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int duration;

    public c(int i3, int i16) {
        this.currentTime = i3;
        this.duration = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCurrentTime() {
        return this.currentTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }
}
