package com.tencent.sqshow.zootopia.samestyle.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB/\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J9\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/data/MaterialWrapper;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "url", "type", "firstFrameUrl", "firstFrameType", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "getType", "getFirstFrameUrl", "getFirstFrameType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class MaterialWrapper implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String firstFrameType;
    private final String firstFrameUrl;
    private final String type;
    private final String url;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/data/MaterialWrapper$a;", "", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/sqshow/zootopia/samestyle/data/MaterialWrapper;", "b", "materialWrapper", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.data.MaterialWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(MaterialWrapper materialWrapper) {
            Intrinsics.checkNotNullParameter(materialWrapper, "materialWrapper");
            g gVar = new g();
            gVar.f427434a = materialWrapper.getUrl();
            gVar.f427435b = materialWrapper.getType();
            gVar.f427436c = materialWrapper.getUrl();
            gVar.f427437d = materialWrapper.getType();
            return gVar;
        }

        public final MaterialWrapper b(g material) {
            Intrinsics.checkNotNullParameter(material, "material");
            return new MaterialWrapper(material.f427434a, material.f427435b, material.f427436c, material.f427437d);
        }

        Companion() {
        }
    }

    public MaterialWrapper(String str, String str2, String str3, String str4) {
        this.url = str;
        this.type = str2;
        this.firstFrameUrl = str3;
        this.firstFrameType = str4;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFirstFrameUrl() {
        return this.firstFrameUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFirstFrameType() {
        return this.firstFrameType;
    }

    public final MaterialWrapper copy(String url, String type, String firstFrameUrl, String firstFrameType) {
        return new MaterialWrapper(url, type, firstFrameUrl, firstFrameType);
    }

    public final String getFirstFrameType() {
        return this.firstFrameType;
    }

    public final String getFirstFrameUrl() {
        return this.firstFrameUrl;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.firstFrameUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.firstFrameType;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "MaterialWrapper(url=" + this.url + ", type=" + this.type + ", firstFrameUrl=" + this.firstFrameUrl + ", firstFrameType=" + this.firstFrameType + ")";
    }

    public static /* synthetic */ MaterialWrapper copy$default(MaterialWrapper materialWrapper, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = materialWrapper.url;
        }
        if ((i3 & 2) != 0) {
            str2 = materialWrapper.type;
        }
        if ((i3 & 4) != 0) {
            str3 = materialWrapper.firstFrameUrl;
        }
        if ((i3 & 8) != 0) {
            str4 = materialWrapper.firstFrameType;
        }
        return materialWrapper.copy(str, str2, str3, str4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaterialWrapper)) {
            return false;
        }
        MaterialWrapper materialWrapper = (MaterialWrapper) other;
        return Intrinsics.areEqual(this.url, materialWrapper.url) && Intrinsics.areEqual(this.type, materialWrapper.type) && Intrinsics.areEqual(this.firstFrameUrl, materialWrapper.firstFrameUrl) && Intrinsics.areEqual(this.firstFrameType, materialWrapper.firstFrameType);
    }
}
