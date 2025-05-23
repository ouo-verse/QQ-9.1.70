package com.tencent.tavcut.core.render.audio.extractor;

import android.media.MediaMuxer;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
final /* synthetic */ class AudioExtractor$release$1 extends MutablePropertyReference0 {
    AudioExtractor$release$1(AudioExtractor audioExtractor) {
        super(audioExtractor);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return AudioExtractor.access$getMediaMuxer$p((AudioExtractor) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "mediaMuxer";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AudioExtractor.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getMediaMuxer()Landroid/media/MediaMuxer;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((AudioExtractor) this.receiver).mediaMuxer = (MediaMuxer) obj;
    }
}
