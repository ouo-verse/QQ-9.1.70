package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public interface Resolver {

    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver$-CC, reason: invalid class name */
    /* loaded from: classes23.dex */
    public final /* synthetic */ class CC {
        public static Duration a(Resolver resolver) {
            Duration ofSeconds;
            ofSeconds = Duration.ofSeconds(10L);
            return ofSeconds;
        }

        public static Message b(Resolver resolver, Message message) throws IOException {
            CompletableFuture completableFuture;
            long millis;
            Object obj;
            try {
                completableFuture = resolver.sendAsync(message).toCompletableFuture();
                millis = resolver.getTimeout().toMillis();
                obj = completableFuture.get(millis, TimeUnit.MILLISECONDS);
                return (Message) obj;
            } catch (InterruptedException e16) {
                Thread.currentThread().interrupt();
                throw new IOException(e16);
            } catch (ExecutionException e17) {
                if (e17.getCause() instanceof IOException) {
                    throw ((IOException) e17.getCause());
                }
                throw new IOException(e17.getCause());
            } catch (TimeoutException e18) {
                throw new IOException("Timed out while trying to resolve " + message.getQuestion().getName() + "/" + Type.string(message.getQuestion().type) + ", id=" + message.getHeader().getID(), e18);
            }
        }

        @Deprecated
        public static Object c(Resolver resolver, Message message, final ResolverListener resolverListener) {
            final Object obj = new Object();
            resolver.sendAsync(message).handleAsync(new BiFunction() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.q
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    return Resolver.CC.h(ResolverListener.this, obj, (Message) obj2, (Throwable) obj3);
                }
            });
            return obj;
        }

        public static CompletionStage d(Resolver resolver, Message message) {
            ForkJoinPool commonPool;
            commonPool = ForkJoinPool.commonPool();
            return resolver.sendAsync(message, commonPool);
        }

        public static CompletionStage e(final Resolver resolver, Message message, Executor executor) {
            final CompletableFuture completableFuture = new CompletableFuture();
            resolver.sendAsync(message, new ResolverListener() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver.1
                @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.ResolverListener
                public void handleException(Object obj, Exception exc) {
                    completableFuture.completeExceptionally(exc);
                }

                @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.ResolverListener
                public void receiveMessage(Object obj, Message message2) {
                    completableFuture.complete(message2);
                }
            });
            return completableFuture;
        }

        @Deprecated
        public static void f(Resolver resolver, int i3) {
            Duration ofSeconds;
            ofSeconds = Duration.ofSeconds(i3);
            resolver.setTimeout(ofSeconds);
        }

        @Deprecated
        public static void g(Resolver resolver, int i3, int i16) {
            Duration ofMillis;
            ofMillis = Duration.ofMillis((i3 * 1000) + i16);
            resolver.setTimeout(ofMillis);
        }

        public static /* synthetic */ Object h(ResolverListener resolverListener, Object obj, Message message, Throwable th5) {
            Exception exc;
            if (th5 != null) {
                if (th5 instanceof Exception) {
                    exc = (Exception) th5;
                } else {
                    exc = new Exception(th5);
                }
                resolverListener.handleException(obj, exc);
                return null;
            }
            resolverListener.receiveMessage(obj, message);
            return null;
        }
    }

    Duration getTimeout();

    Message send(Message message) throws IOException;

    @Deprecated
    Object sendAsync(Message message, ResolverListener resolverListener);

    CompletionStage<Message> sendAsync(Message message);

    CompletionStage<Message> sendAsync(Message message, Executor executor);

    void setPort(int i3);

    @Deprecated
    void setTimeout(int i3);

    @Deprecated
    void setTimeout(int i3, int i16);

    void setTimeout(Duration duration);
}
