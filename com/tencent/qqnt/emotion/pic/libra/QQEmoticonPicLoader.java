package com.tencent.qqnt.emotion.pic.libra;

import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/QQEmoticonPicLoader;", "", "Lcom/tencent/libra/request/Option;", "op", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "c", "a", "Lcom/tencent/libra/IPicLoader;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/libra/IPicLoader;", "loader", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class QQEmoticonPicLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQEmoticonPicLoader f356316a = new QQEmoticonPicLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy loader;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/QQEmoticonPicLoader$a;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/qqnt/emotion/pic/libra/f;", "a", "", "Lcom/tencent/qqnt/emotion/pic/libra/e;", "getCustomDecoder", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements ILibraLibraryStrategy {
        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f getCustomCache() {
            return new f();
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            return "QQEmoticon";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<e> getCustomDecoder() {
            List<e> mutableListOf;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new e());
            return mutableListOf;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return g11.a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
            return g11.a.d(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ILoaderResultListener getGlobalResultListener() {
            return g11.a.e(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IpConnectConfig getIpConnectConfig(String str) {
            return g11.a.f(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ w01.a getLibraIpStrategyBean() {
            return g11.a.g(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ITaskExecutor getTaskExecutor() {
            return g11.a.h(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ String getUniKeyFromUrl(String str) {
            return g11.a.i(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return g11.a.j(this);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<IPicLoader>() { // from class: com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader$loader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IPicLoader invoke() {
                return LibraPicLoaderFactory.getPicLoader(new QQEmoticonPicLoader.a());
            }
        });
        loader = lazy;
    }

    QQEmoticonPicLoader() {
    }

    public final void a(@NotNull Option op5, @Nullable IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(op5, "op");
        b().download(op5, listener);
    }

    @NotNull
    public final IPicLoader b() {
        Object value = loader.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loader>(...)");
        return (IPicLoader) value;
    }

    public final void c(@NotNull Option op5, @Nullable IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(op5, "op");
        op5.disableHardwareDecode();
        b().loadImage(op5, listener);
    }
}
