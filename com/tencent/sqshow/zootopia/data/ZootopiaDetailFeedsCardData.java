package com.tencent.sqshow.zootopia.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\tB'\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getOriginalDataIndex", "()I", "originalDataIndex", "Lpu4/n;", "b", "Lpu4/n;", "()Lpu4/n;", "outfitWorksInfo", "c", "setStatus", "(I)V", "status", "<init>", "(ILpu4/n;I)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.g, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaDetailFeedsCardData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int originalDataIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final pu4.n outfitWorksInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/g$a;", "", "", "choiceIndex", "totalSize", "f", "Lpv4/r;", "sceneIndexModule", "originalDataIndex", "Lcom/tencent/sqshow/zootopia/data/g;", "b", "data", "", tl.h.F, "Lpu4/g;", "g", "", "d", "i", "c", "e", "Lcom/tencent/sqshow/zootopia/player/f;", "a", WadlProxyConsts.KEY_MATERIAL, "", "j", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.g$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int f(int choiceIndex, int totalSize) {
            if (choiceIndex >= totalSize || choiceIndex < 0) {
                return 0;
            }
            return choiceIndex;
        }

        public final com.tencent.sqshow.zootopia.player.f a(ZootopiaDetailFeedsCardData data) {
            pu4.l lVar;
            pu4.l lVar2;
            com.tencent.sqshow.zootopia.player.f a16 = com.tencent.sqshow.zootopia.player.f.INSTANCE.a();
            if (data == null) {
                return a16;
            }
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            String str = null;
            com.tencent.sqshow.zootopia.player.f m3 = a16.m((outfitWorksInfo == null || (lVar2 = outfitWorksInfo.f427499b) == null) ? null : lVar2.f427490o);
            pu4.n outfitWorksInfo2 = data.getOutfitWorksInfo();
            if (outfitWorksInfo2 != null && (lVar = outfitWorksInfo2.f427499b) != null) {
                str = lVar.f427490o;
            }
            m3.x(str).p(h(data)).v(g(data)).o(d(data));
            return a16;
        }

        public final ZootopiaDetailFeedsCardData b(pv4.r sceneIndexModule, int originalDataIndex) {
            Intrinsics.checkNotNullParameter(sceneIndexModule, "sceneIndexModule");
            return new ZootopiaDetailFeedsCardData(originalDataIndex, sceneIndexModule.f427672p, 0, 4, null);
        }

        public final pu4.g c(ZootopiaDetailFeedsCardData data) {
            pu4.l lVar;
            pu4.g[] gVarArr;
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            if (outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null || (gVarArr = lVar.f427479d) == null) {
                return null;
            }
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(gVarArr);
            return (pu4.g) firstOrNull;
        }

        public final List<pu4.g> d(ZootopiaDetailFeedsCardData data) {
            pu4.l lVar;
            pu4.g[] gVarArr;
            List<pu4.g> asList;
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            if (outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null || (gVarArr = lVar.f427479d) == null) {
                return null;
            }
            asList = ArraysKt___ArraysJvmKt.asList(gVarArr);
            return asList;
        }

        public final int e(ZootopiaDetailFeedsCardData data) {
            pu4.j jVar;
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            if (outfitWorksInfo == null || (jVar = outfitWorksInfo.f427498a) == null) {
                return -1;
            }
            return jVar.f427466e;
        }

        public final pu4.g g(ZootopiaDetailFeedsCardData data) {
            pu4.l lVar;
            pu4.g[] img;
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            if (outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null || (img = lVar.f427479d) == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(img, "img");
            int f16 = ZootopiaDetailFeedsCardData.INSTANCE.f(lVar.f427487l, img.length);
            if (img.length == 0) {
                return null;
            }
            return img[f16];
        }

        public final String h(ZootopiaDetailFeedsCardData data) {
            pu4.l lVar;
            pu4.g[] img;
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            if (outfitWorksInfo != null && (lVar = outfitWorksInfo.f427499b) != null && (img = lVar.f427479d) != null) {
                Intrinsics.checkNotNullExpressionValue(img, "img");
                Companion companion = ZootopiaDetailFeedsCardData.INSTANCE;
                int f16 = companion.f(lVar.f427487l, img.length);
                if (!(img.length == 0) && companion.j(img[f16])) {
                    return img[f16].f427434a;
                }
                return "";
            }
            return "";
        }

        public final String i(ZootopiaDetailFeedsCardData data) {
            pu4.l lVar;
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.n outfitWorksInfo = data.getOutfitWorksInfo();
            if (outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null) {
                return null;
            }
            return lVar.f427476a;
        }

        Companion() {
        }

        public final boolean j(pu4.g material) {
            if (!Intrinsics.areEqual("mp4", material != null ? material.f427435b : null)) {
                if (!Intrinsics.areEqual(FileUtils.FILE_TYPE_MOV, material != null ? material.f427435b : null)) {
                    return false;
                }
            }
            return true;
        }
    }

    public ZootopiaDetailFeedsCardData() {
        this(0, null, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final pu4.n getOutfitWorksInfo() {
        return this.outfitWorksInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i3 = this.originalDataIndex * 31;
        pu4.n nVar = this.outfitWorksInfo;
        return ((i3 + (nVar == null ? 0 : nVar.hashCode())) * 31) + this.status;
    }

    public String toString() {
        return "ZootopiaDetailFeedsCardData(originalDataIndex=" + this.originalDataIndex + ", outfitWorksInfo=" + this.outfitWorksInfo + ", status=" + this.status + ")";
    }

    public ZootopiaDetailFeedsCardData(int i3, pu4.n nVar, int i16) {
        this.originalDataIndex = i3;
        this.outfitWorksInfo = nVar;
        this.status = i16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaDetailFeedsCardData)) {
            return false;
        }
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = (ZootopiaDetailFeedsCardData) other;
        return this.originalDataIndex == zootopiaDetailFeedsCardData.originalDataIndex && Intrinsics.areEqual(this.outfitWorksInfo, zootopiaDetailFeedsCardData.outfitWorksInfo) && this.status == zootopiaDetailFeedsCardData.status;
    }

    public /* synthetic */ ZootopiaDetailFeedsCardData(int i3, pu4.n nVar, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? null : nVar, (i17 & 4) != 0 ? 0 : i16);
    }
}
