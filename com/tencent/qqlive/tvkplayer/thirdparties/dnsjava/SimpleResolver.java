package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.WireParseException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class SimpleResolver implements Resolver {
    public static final int DEFAULT_PORT = 53;
    private static final short DEFAULT_UDPSIZE = 512;
    private InetSocketAddress address;
    private InetSocketAddress localAddress;
    private Duration timeoutValue;

    public SimpleResolver(@NonNull String str) throws UnknownHostException {
        Duration ofSeconds;
        InetAddress byName;
        ofSeconds = Duration.ofSeconds(10L);
        this.timeoutValue = ofSeconds;
        if ("0".equals(str)) {
            byName = InetAddress.getLoopbackAddress();
        } else {
            byName = InetAddress.getByName(str);
        }
        this.address = new InetSocketAddress(byName, 53);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsyncByUdp$0(int i3, Message message, byte[] bArr) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (bArr.length < 12) {
            completableFuture.completeExceptionally(new WireParseException("invalid DNS header - too short"));
            return completableFuture;
        }
        int i16 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
        if (i16 != i3) {
            completableFuture.completeExceptionally(new WireParseException("invalid message id: expected " + i3 + "; got id " + i16));
            return completableFuture;
        }
        try {
            Message parseMessage = parseMessage(bArr);
            if (parseMessage.getQuestion() == null) {
                completableFuture.completeExceptionally(new WireParseException("invalid message: question section missing"));
                return completableFuture;
            }
            if (!message.getQuestion().getName().equals(parseMessage.getQuestion().getName())) {
                completableFuture.completeExceptionally(new WireParseException("invalid name in message: expected " + message.getQuestion().getName() + "; got " + parseMessage.getQuestion().getName()));
                return completableFuture;
            }
            if (message.getQuestion().getDClass() != parseMessage.getQuestion().getDClass()) {
                completableFuture.completeExceptionally(new WireParseException("invalid class in message: expected " + DClass.string(message.getQuestion().getDClass()) + "; got " + DClass.string(parseMessage.getQuestion().getDClass())));
                return completableFuture;
            }
            if (message.getQuestion().getType() != parseMessage.getQuestion().getType()) {
                completableFuture.completeExceptionally(new WireParseException("invalid type in message: expected " + Type.string(message.getQuestion().getType()) + "; got " + Type.string(parseMessage.getQuestion().getType())));
                return completableFuture;
            }
            parseMessage.setResolver(this);
            completableFuture.complete(parseMessage);
            return completableFuture;
        } catch (WireParseException e16) {
            completableFuture.completeExceptionally(e16);
            return completableFuture;
        }
    }

    private Message parseMessage(byte[] bArr) throws WireParseException {
        try {
            return new Message(bArr);
        } catch (IOException e16) {
            if (!(e16 instanceof WireParseException)) {
                throw new WireParseException("Error parsing message", e16);
            }
            throw ((WireParseException) e16);
        }
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.address.getPort();
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public Duration getTimeout() {
        return this.timeoutValue;
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public /* synthetic */ Message send(Message message) {
        return Resolver.CC.b(this, message);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public /* synthetic */ Object sendAsync(Message message, ResolverListener resolverListener) {
        return Resolver.CC.c(this, message, resolverListener);
    }

    CompletableFuture<Message> sendAsyncByUdp(final Message message, Executor executor) {
        CompletableFuture<Message> thenComposeAsync;
        final int id5 = message.getHeader().getID();
        thenComposeAsync = NioUdpClient.sendrecv(this.localAddress, this.address, message, message.toWire(65535), 512, this.timeoutValue).thenComposeAsync((Function<? super byte[], ? extends CompletionStage<U>>) new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                CompletionStage lambda$sendAsyncByUdp$0;
                lambda$sendAsyncByUdp$0 = SimpleResolver.this.lambda$sendAsyncByUdp$0(id5, message, (byte[]) obj);
                return lambda$sendAsyncByUdp$0;
            }
        }, executor);
        return thenComposeAsync;
    }

    public void setAddress(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }

    public void setLocalAddress(InetSocketAddress inetSocketAddress) {
        this.localAddress = inetSocketAddress;
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public void setPort(int i3) {
        this.address = new InetSocketAddress(this.address.getAddress(), i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public /* synthetic */ void setTimeout(int i3) {
        Resolver.CC.f(this, i3);
    }

    public String toString() {
        return "SimpleResolver [" + this.address + "]";
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        ForkJoinPool commonPool;
        commonPool = ForkJoinPool.commonPool();
        return sendAsync(message, commonPool);
    }

    public void setAddress(InetAddress inetAddress) {
        this.address = new InetSocketAddress(inetAddress, this.address.getPort());
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = new InetSocketAddress(inetAddress, 0);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public /* synthetic */ void setTimeout(int i3, int i16) {
        Resolver.CC.g(this, i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        try {
            message = message.m241clone();
        } catch (CloneNotSupportedException unused) {
        }
        return sendAsyncByUdp(message, executor);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver
    public void setTimeout(Duration duration) {
        this.timeoutValue = duration;
    }

    public SimpleResolver(InetSocketAddress inetSocketAddress) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(10L);
        this.timeoutValue = ofSeconds;
        Objects.requireNonNull(inetSocketAddress, "host must not be null");
        this.address = inetSocketAddress;
    }

    public SimpleResolver(InetAddress inetAddress) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(10L);
        this.timeoutValue = ofSeconds;
        Objects.requireNonNull(inetAddress, "host must not be null");
        this.address = new InetSocketAddress(inetAddress, 53);
    }
}
