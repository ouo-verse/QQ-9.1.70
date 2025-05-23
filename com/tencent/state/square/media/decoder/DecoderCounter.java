package com.tencent.state.square.media.decoder;

import android.media.MediaCodec;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/media/decoder/DecoderCounter;", "", "()V", "TAG", "", "activeDecoders", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "releaseCount", "onDecoderCreate", "", "decoder", "Landroid/media/MediaCodec;", "onDecoderRelease", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DecoderCounter {
    private static final String TAG = "Square_DecoderCounter";
    public static final DecoderCounter INSTANCE = new DecoderCounter();
    private static AtomicInteger createCount = new AtomicInteger(0);
    private static AtomicInteger releaseCount = new AtomicInteger(0);
    private static final HashSet<Integer> activeDecoders = new HashSet<>();

    DecoderCounter() {
    }

    public final void onDecoderCreate(MediaCodec decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (SquareBase.INSTANCE.getConfig().isDebug()) {
            createCount.incrementAndGet();
            activeDecoders.add(Integer.valueOf(decoder.hashCode()));
            SquareBaseKt.getSquareLog().i(TAG, '(' + hashCode() + ")(" + decoder.hashCode() + ") create createCount=" + createCount.get() + ", releaseCount=" + releaseCount.get() + ", activeCount=" + (createCount.get() - releaseCount.get()));
        }
    }

    public final void onDecoderRelease(MediaCodec decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (SquareBase.INSTANCE.getConfig().isDebug()) {
            releaseCount.incrementAndGet();
            HashSet<Integer> hashSet = activeDecoders;
            hashSet.remove(Integer.valueOf(decoder.hashCode()));
            SquareBaseKt.getSquareLog().i(TAG, '(' + hashCode() + ")(" + decoder.hashCode() + ") release createCount=" + createCount.get() + ", releaseCount=" + releaseCount.get() + ", activeCount=" + (createCount.get() - releaseCount.get()) + ", " + hashSet.size() + '}');
        }
    }
}
