package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "", "sceneType", "Lf62/a;", "createPlayer", "", "token", "", "autoAttachVideoView", "enableMonet", "<init>", "()V", "Companion", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoyPlayerFactory implements IReadInJoyPlayerFactory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ReadInJoyPlayerFactory> factory$delegate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory$a;", "", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "a", "Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory;", "factory$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory;", "factory", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ReadInJoyPlayerFactory b() {
            return (ReadInJoyPlayerFactory) ReadInJoyPlayerFactory.factory$delegate.getValue();
        }

        @JvmStatic
        public final IReadInJoyPlayerFactory a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<ReadInJoyPlayerFactory> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ReadInJoyPlayerFactory>() { // from class: com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory$Companion$factory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReadInJoyPlayerFactory invoke() {
                return new ReadInJoyPlayerFactory();
            }
        });
        factory$delegate = lazy;
    }

    @JvmStatic
    public static final IReadInJoyPlayerFactory get() {
        return INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory
    public f62.a createPlayer(int sceneType) {
        return new ReadInJoyPlayer(sceneType);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory
    public f62.a createPlayer(int sceneType, String token, boolean autoAttachVideoView, boolean enableMonet) {
        return new ReadInJoyPlayer(sceneType, token, autoAttachVideoView, enableMonet);
    }
}
