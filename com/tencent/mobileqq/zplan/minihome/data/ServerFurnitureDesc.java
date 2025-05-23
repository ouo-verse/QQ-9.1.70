package com.tencent.mobileqq.zplan.minihome.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "id", "J", "a", "()J", "subState", "I", "b", "()I", "height", "getHeight", "platform", "getPlatform", "sizeX", "getSizeX", "sizeY", "getSizeY", "sizeZ", "getSizeZ", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.data.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ServerFurnitureDesc {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("height")
    private final int height;

    @SerializedName("id")
    private final long id;

    @SerializedName("platform")
    private final int platform;

    @SerializedName("sizeX")
    private final int sizeX;

    @SerializedName("sizeY")
    private final int sizeY;

    @SerializedName("sizeZ")
    private final int sizeZ;

    @SerializedName("subState")
    private final int subState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/data/c$a;", "", "", "Lcom/tencent/mobileqq/zplan/minihome/data/c;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.data.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final ServerFurnitureDesc a(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                return (ServerFurnitureDesc) GsonUtil.f385283b.a().fromJson(str, ServerFurnitureDesc.class);
            } catch (Throwable th5) {
                FLog.INSTANCE.e("ServerFurnitureDesc", "toServerFurnitureDesc exception", th5);
                return null;
            }
        }
    }

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getSubState() {
        return this.subState;
    }

    public int hashCode() {
        return (((((((((((com.tencent.mobileqq.vas.banner.c.a(this.id) * 31) + this.subState) * 31) + this.height) * 31) + this.platform) * 31) + this.sizeX) * 31) + this.sizeY) * 31) + this.sizeZ;
    }

    public String toString() {
        return "ServerFurnitureDesc(id=" + this.id + ", subState=" + this.subState + ", height=" + this.height + ", platform=" + this.platform + ", sizeX=" + this.sizeX + ", sizeY=" + this.sizeY + ", sizeZ=" + this.sizeZ + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerFurnitureDesc)) {
            return false;
        }
        ServerFurnitureDesc serverFurnitureDesc = (ServerFurnitureDesc) other;
        return this.id == serverFurnitureDesc.id && this.subState == serverFurnitureDesc.subState && this.height == serverFurnitureDesc.height && this.platform == serverFurnitureDesc.platform && this.sizeX == serverFurnitureDesc.sizeX && this.sizeY == serverFurnitureDesc.sizeY && this.sizeZ == serverFurnitureDesc.sizeZ;
    }
}
