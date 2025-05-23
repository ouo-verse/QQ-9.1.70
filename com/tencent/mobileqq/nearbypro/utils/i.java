package com.tencent.mobileqq.nearbypro.utils;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import bb2.SortCluster;
import com.tencent.mobileqq.nearbypro.land.LandMode;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import fu4.v;
import fu4.w;
import fu4.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import za2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\f\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0006\u001a\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\u001a\u0010\u0010\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r\u001a\n\u0010\u0012\u001a\u00020\u0002*\u00020\u0011\u001a\u0014\u0010\u0016\u001a\u00020\u0007*\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u001a\u0014\u0010\u0018\u001a\u00020\u0007*\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u0017\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0019\u001a\n\u0010\u001c\u001a\u00020\u001b*\u00020\u0019\u001a\u0014\u0010\u001d\u001a\u00020\u0007*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u001e"}, d2 = {"", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "", "markerKey", "Lbb2/d;", "c", "Lop4/g;", "", "j", "Lxp4/a;", "other", tl.h.F, "Landroid/view/View;", "", "localX", "localY", "b", "Lfu4/v;", "a", "Lcq4/b;", "Lza2/c$a;", "areaInfo", "f", "Lqp4/a;", "g", "Lcom/tencent/mobileqq/nearbypro/part/a;", "d", "Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "e", "i", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {
    @NotNull
    public static final String a(@NotNull v vVar) {
        String str;
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        fu4.s sVar = vVar.f400818a;
        if (sVar != null) {
            str = sVar.f400804b;
        } else {
            str = null;
        }
        if (str == null) {
            return String.valueOf(Random.INSTANCE.nextInt());
        }
        return str;
    }

    public static final boolean b(@NotNull View view, float f16, float f17) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()).contains((int) f16, (int) f17);
    }

    @Nullable
    public static final bb2.d<?> c(@NotNull List<? extends Marker> list, @NotNull String markerKey) {
        bb2.e eVar;
        SortCluster sortCluster;
        bb2.e eVar2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(markerKey, "markerKey");
        for (Marker marker : list) {
            MarkerOptions options = marker.getOptions();
            if (options instanceof bb2.e) {
                eVar = (bb2.e) options;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                sortCluster = eVar.getSortCluster();
            } else {
                sortCluster = null;
            }
            if (sortCluster != null && Intrinsics.areEqual(db2.a.f393512a.b(sortCluster).b(), markerKey)) {
                MarkerOptions options2 = marker.getOptions();
                if (options2 instanceof bb2.e) {
                    eVar2 = (bb2.e) options2;
                } else {
                    eVar2 = null;
                }
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.b();
            }
        }
        return null;
    }

    public static final float d(@NotNull com.tencent.mobileqq.nearbypro.part.a aVar) {
        CameraPosition cameraPosition;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        TencentMap tencentMap = null;
        Object e65 = aVar.e6("GET_TENCENT_MAP", null);
        if (e65 instanceof TencentMap) {
            tencentMap = (TencentMap) e65;
        }
        if (tencentMap != null && (cameraPosition = tencentMap.getCameraPosition()) != null) {
            return cameraPosition.zoom;
        }
        return 20.0f;
    }

    @NotNull
    public static final LandMode e(@NotNull com.tencent.mobileqq.nearbypro.part.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (d(aVar) > ab2.a.f25767a.p()) {
            return LandMode.BIG;
        }
        return LandMode.SMALL;
    }

    public static final boolean f(@NotNull cq4.b bVar, @Nullable c.AreaInfo areaInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (areaInfo != null && bVar.f391669b == areaInfo.getRoomId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || bVar.f391668a != areaInfo.getAreaId()) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull qp4.a aVar, @Nullable qp4.a aVar2) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar2 == null) {
            return false;
        }
        qp4.e eVar = aVar.f429198b;
        float f16 = eVar.f429215a;
        qp4.e eVar2 = aVar2.f429198b;
        if (f16 == eVar2.f429215a) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (eVar.f429216b == eVar2.f429216b) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && Intrinsics.areEqual(aVar.f429201e.f429210a, aVar2.f429201e.f429210a) && aVar.f429197a == aVar2.f429197a) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean h(@NotNull xp4.a aVar, @Nullable xp4.a aVar2) {
        String str;
        w wVar;
        z[] zVarArr;
        Object firstOrNull;
        z zVar;
        v vVar;
        z[] zVarArr2;
        Object firstOrNull2;
        v vVar2;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar2 == null || !TextUtils.equals(aVar.f448299d, aVar2.f448299d) || aVar.f448302g != aVar2.f448302g || aVar.f448300e.f431878a != aVar2.f448300e.f431878a) {
            return false;
        }
        w wVar2 = aVar.f448301f.f423329a;
        String str2 = null;
        if (wVar2 != null && (zVarArr2 = wVar2.f400825a) != null) {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(zVarArr2);
            z zVar2 = (z) firstOrNull2;
            if (zVar2 != null && (vVar2 = zVar2.f400830a) != null) {
                str = a(vVar2);
                wVar = aVar2.f448301f.f423329a;
                if (wVar != null && (zVarArr = wVar.f400825a) != null) {
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(zVarArr);
                    zVar = (z) firstOrNull;
                    if (zVar != null && (vVar = zVar.f400830a) != null) {
                        str2 = a(vVar);
                    }
                }
                if (Intrinsics.areEqual(str, str2)) {
                    return false;
                }
                return true;
            }
        }
        str = null;
        wVar = aVar2.f448301f.f423329a;
        if (wVar != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(zVarArr);
            zVar = (z) firstOrNull;
            if (zVar != null) {
                str2 = a(vVar);
            }
        }
        if (Intrinsics.areEqual(str, str2)) {
        }
    }

    public static final boolean i(@NotNull xp4.a aVar, @Nullable xp4.a aVar2) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar2 == null) {
            return false;
        }
        w wVar = aVar2.f448301f.f423329a;
        if (wVar == null && aVar.f448301f.f423329a != null) {
            return false;
        }
        if (wVar != null && aVar.f448301f.f423329a == null) {
            return false;
        }
        return true;
    }

    public static final boolean j(@Nullable op4.g gVar) {
        w wVar;
        if (gVar != null) {
            wVar = gVar.f423329a;
        } else {
            wVar = null;
        }
        if (wVar != null) {
            return true;
        }
        return false;
    }
}
