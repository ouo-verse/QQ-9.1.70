package com.tencent.hippykotlin.demo.pages.nearby.base.debug;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import d45.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.k;

/* loaded from: classes31.dex */
public final class NBPDebugSettings {
    public static final Companion Companion = new Companion();
    public final boolean enableMockLocation;
    public final k mockLocation;

    public NBPDebugSettings() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z16 = this.enableMockLocation;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        k kVar = this.mockLocation;
        return i3 + (kVar == null ? 0 : kVar.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPDebugSettings(enableMockLocation=");
        m3.append(this.enableMockLocation);
        m3.append(", mockLocation=");
        m3.append(this.mockLocation);
        m3.append(')');
        return m3.toString();
    }

    public NBPDebugSettings(boolean z16, k kVar) {
        this.enableMockLocation = z16;
        this.mockLocation = kVar;
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        /* JADX WARN: Multi-variable type inference failed */
        public final NBPDebugSettings loadIfNotPublic(g gVar) {
            boolean isBlank;
            k kVar;
            boolean z16 = false;
            k kVar2 = null;
            byte b16 = 0;
            byte b17 = 0;
            byte b18 = 0;
            if (((gVar == null || gVar.n().g("isPublic", false)) ? false : true) != true) {
                return null;
            }
            String item = Utils.INSTANCE.cacheModule("").getItem("NBP_DEBUG_SETTINGS_CACHE_KEY");
            KLog.INSTANCE.i("NBPDebugSettings", "load NBPDebugSettings " + item);
            isBlank = StringsKt__StringsJVMKt.isBlank(item);
            int i3 = 3;
            if (!isBlank) {
                try {
                    e eVar = new e(item);
                    byte[] a16 = a.a(eVar.p("mockLocation"));
                    if (a16 != null) {
                        if ((true ^ (a16.length == 0)) != false) {
                            kVar = (k) i.b(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151), a16);
                            return new NBPDebugSettings(eVar.f("enableMockLocation"), kVar);
                        }
                    }
                    kVar = null;
                    return new NBPDebugSettings(eVar.f("enableMockLocation"), kVar);
                } catch (Throwable th5) {
                    KLog.INSTANCE.e("NBPDebugSettings", "parseFromJSONString: " + th5);
                    return new NBPDebugSettings(z16, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
                }
            }
            return new NBPDebugSettings(z16, kVar2, i3, b18 == true ? 1 : 0);
        }
    }

    public /* synthetic */ NBPDebugSettings(boolean z16, k kVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPDebugSettings)) {
            return false;
        }
        NBPDebugSettings nBPDebugSettings = (NBPDebugSettings) obj;
        return this.enableMockLocation == nBPDebugSettings.enableMockLocation && Intrinsics.areEqual(this.mockLocation, nBPDebugSettings.mockLocation);
    }
}
