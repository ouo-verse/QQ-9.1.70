package com.tencent.ecommerce.base.proto;

import android.util.Base64;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.BaseConstants;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ?\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022-\u0010\u000b\u001a)\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\rJ9\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2)\u0010\u000b\u001a%\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nJM\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2-\u0010\u000b\u001a)\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nJ\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rR \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/base/proto/ECPBParser;", "", "Lcom/tencent/ecommerce/base/proto/ECPBParser$a;", "info", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Lkotlin/ParameterName;", "name", "pb", "", "Lcom/tencent/ecommerce/base/proto/ParserPBCallback;", "callback", "c", "", "pbToken", "f", "e", "pbClassName", BaseConstants.ATTRIBUTE_KEY_PB_DATA, "b", "g", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "token2PbMap", "", "d", "()I", "cacheSize", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECPBParser {

    /* renamed from: b, reason: collision with root package name */
    public static final ECPBParser f100901b = new ECPBParser();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ParserInfo> token2PbMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001BZ\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u00121\b\u0002\u0010\u001d\u001a+\u0012'\u0012%\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00180\u0015j\u0002`\u00190\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR(\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0011\"\u0004\b\u000f\u0010\u0012R@\u0010\u001d\u001a+\u0012'\u0012%\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00180\u0015j\u0002`\u00190\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\t\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/base/proto/ECPBParser$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "token", "b", "pbClassName", "Lcom/tencent/mobileqq/pb/MessageMicro;", "c", "Lcom/tencent/mobileqq/pb/MessageMicro;", "()Lcom/tencent/mobileqq/pb/MessageMicro;", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "pb", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lcom/tencent/ecommerce/base/proto/ParserPBCallback;", "d", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "delayCallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.proto.ECPBParser$a, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class ParserInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String token;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String pbClassName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private volatile MessageMicro<?> pb;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final ConcurrentLinkedQueue<Function1<MessageMicro<?>, Unit>> delayCallback;

        public ParserInfo(String str, String str2, MessageMicro<?> messageMicro, ConcurrentLinkedQueue<Function1<MessageMicro<?>, Unit>> concurrentLinkedQueue) {
            this.token = str;
            this.pbClassName = str2;
            this.pb = messageMicro;
            this.delayCallback = concurrentLinkedQueue;
        }

        public final ConcurrentLinkedQueue<Function1<MessageMicro<?>, Unit>> a() {
            return this.delayCallback;
        }

        public final MessageMicro<?> b() {
            return this.pb;
        }

        public final void c(MessageMicro<?> messageMicro) {
            this.pb = messageMicro;
        }

        public int hashCode() {
            String str = this.token;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.pbClassName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            MessageMicro<?> messageMicro = this.pb;
            int hashCode3 = (hashCode2 + (messageMicro != null ? messageMicro.hashCode() : 0)) * 31;
            ConcurrentLinkedQueue<Function1<MessageMicro<?>, Unit>> concurrentLinkedQueue = this.delayCallback;
            return hashCode3 + (concurrentLinkedQueue != null ? concurrentLinkedQueue.hashCode() : 0);
        }

        public String toString() {
            return "ParserInfo(token=" + this.token + ", pbClassName=" + this.pbClassName + ", pb=" + this.pb + ", delayCallback=" + this.delayCallback + ")";
        }

        public /* synthetic */ ParserInfo(String str, String str2, MessageMicro messageMicro, ConcurrentLinkedQueue concurrentLinkedQueue, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? null : messageMicro, (i3 & 8) != 0 ? new ConcurrentLinkedQueue() : concurrentLinkedQueue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParserInfo)) {
                return false;
            }
            ParserInfo parserInfo = (ParserInfo) other;
            return Intrinsics.areEqual(this.token, parserInfo.token) && Intrinsics.areEqual(this.pbClassName, parserInfo.pbClassName) && Intrinsics.areEqual(this.pb, parserInfo.pb) && Intrinsics.areEqual(this.delayCallback, parserInfo.delayCallback);
        }
    }

    ECPBParser() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(ParserInfo info, Function1<? super MessageMicro<?>, Unit> callback) {
        MessageMicro<?> b16 = info.b();
        if (b16 != null) {
            if (callback != null) {
                callback.invoke(b16);
            }
            Iterator<Function1<MessageMicro<?>, Unit>> it = info.a().iterator();
            while (it.hasNext()) {
                it.next().invoke(b16);
            }
        }
        info.a().clear();
    }

    public final void b(final String pbClassName, final String pbData, final String pbToken, final Function1<? super MessageMicro<?>, Unit> callback) {
        ConcurrentHashMap<String, ParserInfo> concurrentHashMap = token2PbMap;
        if (concurrentHashMap.get(pbToken) == null) {
            concurrentHashMap.put(pbToken, new ParserInfo(pbToken, pbClassName, null, null, 12, null));
        }
        cg0.a.b("ECPBParser", "bytesToPb pbClassName=" + pbClassName + ", pbToken=" + pbToken);
        final ParserInfo parserInfo = concurrentHashMap.get(pbToken);
        if (parserInfo != null && parserInfo.b() == null) {
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.base.proto.ECPBParser$bytesToPb$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        Object newInstance = Class.forName(pbClassName).newInstance();
                        if (!(newInstance instanceof MessageMicro)) {
                            ECPBParser.f100901b.c(parserInfo, callback);
                            cg0.a.a("ECPBParser", "bytesToPb", "bytesToPb failed, pbClassName=" + pbClassName + ", instance=" + newInstance);
                            return;
                        }
                        MessageMicro messageMicro = (MessageMicro) newInstance;
                        String str = pbData;
                        Charset charset = Charsets.UTF_8;
                        if (str != null) {
                            byte[] bytes = str.getBytes(charset);
                            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                            messageMicro.mergeFrom(Base64.decode(bytes, 0));
                            parserInfo.c((MessageMicro) newInstance);
                            cg0.a.b("ECPBParser", "bytesToPb finished pbClassName=" + pbClassName + ", pbToken=" + pbToken);
                            ECPBParser.f100901b.c(parserInfo, callback);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    } catch (ClassNotFoundException e16) {
                        ECPBParser.f100901b.c(parserInfo, callback);
                        cg0.a.a("ECPBParser", "bytesToPb", "bytesToPb failed pbClassName=" + pbClassName + ", " + e16);
                    }
                }
            });
            return;
        }
        cg0.a.b("ECPBParser", "bytesToPb repeat task pbClassName=" + pbClassName + ", pbToken=" + pbToken);
        if (parserInfo != null) {
            f100901b.c(parserInfo, callback);
        }
    }

    public final int d() {
        return token2PbMap.size();
    }

    public final void e(String pbToken, Function1<? super MessageMicro<?>, Unit> callback) {
        ParserInfo parserInfo = token2PbMap.get(pbToken);
        if (parserInfo != null) {
            MessageMicro<?> b16 = parserInfo.b();
            if (b16 != null) {
                callback.invoke(b16);
                return;
            }
            cg0.a.b("ECPBParser", "keyToPb pbToken=" + pbToken + ", wait bytesToPb");
            parserInfo.a().add(callback);
            return;
        }
        cg0.a.a("ECPBParser", "keyToPb", "keyToPb failed info null");
    }

    public final MessageMicro<?> f(String pbToken) {
        ParserInfo parserInfo = token2PbMap.get(pbToken);
        if (parserInfo != null) {
            return parserInfo.b();
        }
        return null;
    }

    public final void g(String pbToken) {
        token2PbMap.remove(pbToken);
    }
}
