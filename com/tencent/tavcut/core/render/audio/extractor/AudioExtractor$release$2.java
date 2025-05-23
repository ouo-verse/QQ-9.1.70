package com.tencent.tavcut.core.render.audio.extractor;

import android.media.MediaExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
final /* synthetic */ class AudioExtractor$release$2 extends MutablePropertyReference0 {
    AudioExtractor$release$2(AudioExtractor audioExtractor) {
        super(audioExtractor);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return AudioExtractor.access$getMediaExtractor$p((AudioExtractor) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "mediaExtractor";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AudioExtractor.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getMediaExtractor()Landroid/media/MediaExtractor;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((AudioExtractor) this.receiver).mediaExtractor = (MediaExtractor) obj;
    }
}
