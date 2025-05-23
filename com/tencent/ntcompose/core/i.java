package com.tencent.ntcompose.core;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \t2\u00020\u0001:\u0002\t\u0007J7\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H&\u00a2\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "", BdhLogUtil.LogTag.Tag_Req, "initial", "Lkotlin/Function2;", "Lcom/tencent/ntcompose/core/i$c;", QCircleDaTongConstant.ElementParamValue.OPERATION, "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "a", "other", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f339215b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0096\u0004J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ntcompose/core/i$a;", "Lcom/tencent/ntcompose/core/i;", BdhLogUtil.LogTag.Tag_Req, "initial", "Lkotlin/Function2;", "Lcom/tencent/ntcompose/core/i$c;", QCircleDaTongConstant.ElementParamValue.OPERATION, "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "a", "other", "b", "", "toString", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.core.i$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion implements i {

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ Companion f339215b = new Companion();

        Companion() {
        }

        @Override // com.tencent.ntcompose.core.i
        public <R> R a(R initial, Function2<? super c, ? super R, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return initial;
        }

        @Override // com.tencent.ntcompose.core.i
        public i b(i other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other;
        }

        @Override // com.tencent.ntcompose.core.i
        public <R> R c(R initial, Function2<? super R, ? super c, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return initial;
        }

        public String toString() {
            return "Modifier";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class b {
        public static i a(i iVar, i other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other == i.INSTANCE ? iVar : new CombinedModifier(iVar, other);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/ntcompose/core/i$c;", "Lcom/tencent/ntcompose/core/i;", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c extends i {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public static final class a {
            public static <R> R a(c cVar, R r16, Function2<? super R, ? super c, ? extends R> operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                return operation.invoke(r16, cVar);
            }

            public static <R> R b(c cVar, R r16, Function2<? super c, ? super R, ? extends R> operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                return operation.invoke(cVar, r16);
            }

            public static i c(c cVar, i other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return b.a(cVar, other);
            }
        }
    }

    <R> R a(R initial, Function2<? super c, ? super R, ? extends R> operation);

    i b(i other);

    <R> R c(R initial, Function2<? super R, ? super c, ? extends R> operation);
}
