package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "", "Lb94/a;", "engineApi", "", "extInfo", "a", "toString", "", "hashCode", "other", "", "equals", "Lb94/a;", "c", "()Lb94/a;", "e", "(Lb94/a;)V", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "<init>", "(Lb94/a;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.dress.task.d, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class DressTaskChannel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private b94.a engineApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String extInfo;

    public DressTaskChannel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final DressTaskChannel a(b94.a engineApi, @DressTaskExtInfo String extInfo) {
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        return new DressTaskChannel(engineApi, extInfo);
    }

    /* renamed from: c, reason: from getter */
    public final b94.a getEngineApi() {
        return this.engineApi;
    }

    /* renamed from: d, reason: from getter */
    public final String getExtInfo() {
        return this.extInfo;
    }

    public final void e(b94.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.engineApi = aVar;
    }

    public int hashCode() {
        return (this.engineApi.hashCode() * 31) + this.extInfo.hashCode();
    }

    public String toString() {
        return "DressTaskChannel(engineApi=" + this.engineApi + ", extInfo=" + this.extInfo + ")";
    }

    public DressTaskChannel(b94.a engineApi, @DressTaskExtInfo String extInfo) {
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        this.engineApi = engineApi;
        this.extInfo = extInfo;
    }

    public /* synthetic */ DressTaskChannel(b94.a aVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? aa.f371327d : aVar, (i3 & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ DressTaskChannel b(DressTaskChannel dressTaskChannel, b94.a aVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = dressTaskChannel.engineApi;
        }
        if ((i3 & 2) != 0) {
            str = dressTaskChannel.extInfo;
        }
        return dressTaskChannel.a(aVar, str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressTaskChannel)) {
            return false;
        }
        DressTaskChannel dressTaskChannel = (DressTaskChannel) other;
        return Intrinsics.areEqual(this.engineApi, dressTaskChannel.engineApi) && Intrinsics.areEqual(this.extInfo, dressTaskChannel.extInfo);
    }
}
