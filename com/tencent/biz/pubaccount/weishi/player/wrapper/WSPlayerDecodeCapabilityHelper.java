package com.tencent.biz.pubaccount.weishi.player.wrapper;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u001b\u0010\f\u001a\u00020\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/wrapper/WSPlayerDecodeCapabilityHelper;", "Lcom/tencent/biz/pubaccount/weishi/player/wrapper/c;", "", "width", "height", "frameRate", "", "b", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/biz/pubaccount/weishi/player/wrapper/c;", "decodeCapability", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSPlayerDecodeCapabilityHelper implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final WSPlayerDecodeCapabilityHelper f81190a = new WSPlayerDecodeCapabilityHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy decodeCapability;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDecodeCapabilityHelper$decodeCapability$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return m.d().a();
            }
        });
        decodeCapability = lazy;
    }

    WSPlayerDecodeCapabilityHelper() {
    }

    private final c c() {
        Object value = decodeCapability.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-decodeCapability>(...)");
        return (c) value;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.c
    public boolean a(int width, int height, int frameRate) {
        return c().a(width, height, frameRate);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.c
    public boolean b(int width, int height, int frameRate) {
        return c().b(width, height, frameRate);
    }
}
