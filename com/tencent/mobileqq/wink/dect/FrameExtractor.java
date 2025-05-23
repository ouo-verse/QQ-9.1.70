package com.tencent.mobileqq.wink.dect;

import android.graphics.Bitmap;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00072\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/FrameExtractor;", "", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "b", "", "atTimeUs", "Landroid/graphics/Bitmap;", "c", "", "e", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "a", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "getClipSource", "()Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSource", "Lkotlin/Lazy;", "d", "()Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "thumbProvider", "<init>", "(Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FrameExtractor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipSource clipSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy thumbProvider;

    public FrameExtractor(@NotNull ClipSource clipSource) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(clipSource, "clipSource");
        this.clipSource = clipSource;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IThumbProvider>() { // from class: com.tencent.mobileqq.wink.dect.FrameExtractor$thumbProvider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IThumbProvider invoke() {
                IThumbProvider b16;
                b16 = FrameExtractor.this.b();
                return b16;
            }
        });
        this.thumbProvider = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IThumbProvider b() {
        return rd4.c.f431135f.i(this.clipSource, new Size(320, 320));
    }

    private final IThumbProvider d() {
        return (IThumbProvider) this.thumbProvider.getValue();
    }

    @NotNull
    public final Bitmap c(long atTimeUs) {
        Bitmap thumbAtTime = d().getThumbAtTime(atTimeUs);
        if (thumbAtTime != null) {
            return thumbAtTime;
        }
        throw new Exception("Error when extracting frame");
    }

    public final void e() {
        d().release();
    }
}
