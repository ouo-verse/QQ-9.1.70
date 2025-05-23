package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.utils.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\b\fB3\b\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\f\u0010\u0011\u0082\u0001\u0002\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/w;", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "", "b", "I", "()I", "ssoResultCode", "c", "d", "trpcRspFuncRetCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "trpcRspErrorMsg", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "Lcom/tencent/mobileqq/zplan/utils/av$b;", "Lcom/tencent/mobileqq/zplan/utils/av$c;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class av implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Object data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int ssoResultCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int trpcRspFuncRetCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String trpcRspErrorMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/av$a;", "Lcom/tencent/mobileqq/zplan/utils/av$c;", "", "e", "[B", "getBytes", "()[B", "bytes", "<init>", "([B)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class a extends c {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final byte[] bytes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(byte[] bytes) {
            super(bytes, 0, 0, null, 14, null);
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.bytes = bytes;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/av$c;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/w$a;", "", "data", "", "ssoResultCode", "trpcRspFuncRetCode", "", "trpcRspErrorMsg", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class c extends av implements w.a {
        public /* synthetic */ c(Object obj, int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? null : str);
        }

        public c(Object obj, int i3, int i16, String str) {
            super(obj, i3, i16, str, null);
        }
    }

    public /* synthetic */ av(Object obj, int i3, int i16, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, i3, i16, str);
    }

    /* renamed from: a, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getSsoResultCode() {
        return this.ssoResultCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getTrpcRspErrorMsg() {
        return this.trpcRspErrorMsg;
    }

    /* renamed from: d, reason: from getter */
    public final int getTrpcRspFuncRetCode() {
        return this.trpcRspFuncRetCode;
    }

    av(Object obj, int i3, int i16, String str) {
        this.data = obj;
        this.ssoResultCode = i3;
        this.trpcRspFuncRetCode = i16;
        this.trpcRspErrorMsg = str;
    }

    public /* synthetic */ av(Object obj, int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? null : str, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/av$b;", "Lcom/tencent/mobileqq/zplan/utils/av;", "", "data", "<init>", "(Ljava/lang/Object;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class b extends av {
        public b(Object obj) {
            super(obj, 0, 0, null, 14, null);
        }
    }
}
