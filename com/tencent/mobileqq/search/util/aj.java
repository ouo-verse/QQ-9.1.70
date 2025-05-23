package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J9\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022)\u0010\f\u001a%\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000bR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/util/aj;", "", "", "pbToken", "Lcom/tencent/mobileqq/pb/MessageMicro;", "b", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pb", "", "Lcom/tencent/mobileqq/search/util/ParserPBCallback;", "callback", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/search/util/aj$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "token2PbMap", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aj f284996a = new aj();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ParserInfo> token2PbMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR(\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R@\u0010\u001e\u001a+\u0012'\u0012%\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001a0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/util/aj$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "token", "b", "pbClassName", "Lcom/tencent/mobileqq/pb/MessageMicro;", "c", "Lcom/tencent/mobileqq/pb/MessageMicro;", "()Lcom/tencent/mobileqq/pb/MessageMicro;", "setPb", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "pb", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lcom/tencent/mobileqq/search/util/ParserPBCallback;", "d", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "delayCallback", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.util.aj$a, reason: from toString */
    /* loaded from: classes18.dex */
    private static final /* data */ class ParserInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @JvmField
        @NotNull
        public final String token;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @JvmField
        @NotNull
        public final String pbClassName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private volatile MessageMicro<?> pb;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ConcurrentLinkedQueue<Function1<MessageMicro<?>, Unit>> delayCallback;

        @NotNull
        public final ConcurrentLinkedQueue<Function1<MessageMicro<?>, Unit>> a() {
            return this.delayCallback;
        }

        @Nullable
        public final MessageMicro<?> b() {
            return this.pb;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParserInfo)) {
                return false;
            }
            ParserInfo parserInfo = (ParserInfo) other;
            if (Intrinsics.areEqual(this.token, parserInfo.token) && Intrinsics.areEqual(this.pbClassName, parserInfo.pbClassName) && Intrinsics.areEqual(this.pb, parserInfo.pb) && Intrinsics.areEqual(this.delayCallback, parserInfo.delayCallback)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.token.hashCode() * 31) + this.pbClassName.hashCode()) * 31;
            if (this.pb == null) {
                hashCode = 0;
            } else {
                hashCode = this.pb.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.delayCallback.hashCode();
        }

        @NotNull
        public String toString() {
            return "ParserInfo(token=" + this.token + ", pbClassName=" + this.pbClassName + ", pb=" + this.pb + ", delayCallback=" + this.delayCallback + ")";
        }
    }

    aj() {
    }

    public final void a(@NotNull String pbToken, @NotNull Function1<? super MessageMicro<?>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pbToken, "pbToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ParserInfo parserInfo = token2PbMap.get(pbToken);
        if (parserInfo != null) {
            MessageMicro<?> b16 = parserInfo.b();
            if (b16 != null) {
                callback.invoke(b16);
                return;
            }
            QLog.i("SearchPBParser", 1, "keyToPb pbToken=" + pbToken + ", wait bytesToPb");
            parserInfo.a().add(callback);
            return;
        }
        QLog.e("SearchPBParser", 1, "keyToPb failed info null");
    }

    @Nullable
    public final MessageMicro<?> b(@NotNull String pbToken) {
        Intrinsics.checkNotNullParameter(pbToken, "pbToken");
        ParserInfo parserInfo = token2PbMap.get(pbToken);
        if (parserInfo != null) {
            return parserInfo.b();
        }
        return null;
    }
}
