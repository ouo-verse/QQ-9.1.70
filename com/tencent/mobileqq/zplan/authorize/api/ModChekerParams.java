package com.tencent.mobileqq.zplan.authorize.api;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u00c6\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\b\u0010 \u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/api/ModChekerParams;", "Ljava/io/Serializable;", "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fromSource", "", "skipRedirect", "", "needReLaunchByScheme", "ueParams", "", "", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/lang/String;ZZLjava/util/Map;)V", "getFromSource", "()Ljava/lang/String;", "getNeedReLaunchByScheme", "()Z", "getSkipRedirect", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getUeParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ModChekerParams implements Serializable {
    private final String fromSource;
    private final boolean needReLaunchByScheme;
    private final boolean skipRedirect;
    private final ZootopiaSource source;
    private final Map<String, Object> ueParams;

    public ModChekerParams(ZootopiaSource source, String fromSource, boolean z16, boolean z17, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        this.source = source;
        this.fromSource = fromSource;
        this.skipRedirect = z16;
        this.needReLaunchByScheme = z17;
        this.ueParams = map;
    }

    /* renamed from: component1, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFromSource() {
        return this.fromSource;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSkipRedirect() {
        return this.skipRedirect;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getNeedReLaunchByScheme() {
        return this.needReLaunchByScheme;
    }

    public final Map<String, Object> component5() {
        return this.ueParams;
    }

    public final ModChekerParams copy(ZootopiaSource source, String fromSource, boolean skipRedirect, boolean needReLaunchByScheme, Map<String, ? extends Object> ueParams) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        return new ModChekerParams(source, fromSource, skipRedirect, needReLaunchByScheme, ueParams);
    }

    public final String getFromSource() {
        return this.fromSource;
    }

    public final boolean getNeedReLaunchByScheme() {
        return this.needReLaunchByScheme;
    }

    public final boolean getSkipRedirect() {
        return this.skipRedirect;
    }

    public final ZootopiaSource getSource() {
        return this.source;
    }

    public final Map<String, Object> getUeParams() {
        return this.ueParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.source.hashCode() * 31) + this.fromSource.hashCode()) * 31;
        boolean z16 = this.skipRedirect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.needReLaunchByScheme;
        int i17 = (i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        Map<String, Object> map = this.ueParams;
        return i17 + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "source=" + this.source.getMainSource() + ", fromSource=" + this.fromSource + ", skipRedirect=" + this.skipRedirect + ",needReLaunchByScheme=" + this.needReLaunchByScheme;
    }

    public static /* synthetic */ ModChekerParams copy$default(ModChekerParams modChekerParams, ZootopiaSource zootopiaSource, String str, boolean z16, boolean z17, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            zootopiaSource = modChekerParams.source;
        }
        if ((i3 & 2) != 0) {
            str = modChekerParams.fromSource;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            z16 = modChekerParams.skipRedirect;
        }
        boolean z18 = z16;
        if ((i3 & 8) != 0) {
            z17 = modChekerParams.needReLaunchByScheme;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            map = modChekerParams.ueParams;
        }
        return modChekerParams.copy(zootopiaSource, str2, z18, z19, map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModChekerParams)) {
            return false;
        }
        ModChekerParams modChekerParams = (ModChekerParams) other;
        return Intrinsics.areEqual(this.source, modChekerParams.source) && Intrinsics.areEqual(this.fromSource, modChekerParams.fromSource) && this.skipRedirect == modChekerParams.skipRedirect && this.needReLaunchByScheme == modChekerParams.needReLaunchByScheme && Intrinsics.areEqual(this.ueParams, modChekerParams.ueParams);
    }

    public /* synthetic */ ModChekerParams(ZootopiaSource zootopiaSource, String str, boolean z16, boolean z17, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(zootopiaSource, str, z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? null : map);
    }
}
