package com.tencent.mobileqq.nearbypro.utils;

import android.app.Application;
import android.graphics.Point;
import android.util.Size;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentCoverResource;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.ResourceIdentify;
import cooperation.qzone.LbsDataV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\f\u001a\u00020\u000b*\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\r\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\u0010\u00a8\u0006\u0013"}, d2 = {"Lrp4/f;", "Lcom/tencent/state/square/data/DressKeys;", "dressKeys", "Lcom/tencent/state/square/data/Resource;", "e", "Lrp4/a;", "", "needCalPx", "Landroid/util/Size;", "b", "filamentResource", "", "a", "Lrp4/b;", "Lcom/tencent/state/square/data/FilamentCoverResource;", "d", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "Lop4/h;", "g", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(@NotNull Resource resource, @Nullable rp4.f fVar) {
        Unit unit;
        ResourceIdentify resourceIdentify;
        rp4.h userDressKey;
        DressKeys dressKeys;
        rp4.c[] data;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(resource, "<this>");
        ResourceIdentify resourceIdentify2 = new ResourceIdentify(null, null, null, null, 0, 31, null);
        if (fVar != null) {
            rp4.d dVar = fVar.f431873b;
            if (dVar != null && (data = dVar.f431868a) != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(data);
                rp4.c cVar = (rp4.c) firstOrNull;
                if (cVar != null) {
                    String str = cVar.f431866a;
                    Intrinsics.checkNotNullExpressionValue(str, "it.url");
                    String str2 = cVar.f431867b;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.md5");
                    resourceIdentify = new ResourceIdentify(str, str2, null, null, 0, 28, null);
                    userDressKey = fVar.f431876e;
                    if (userDressKey == null) {
                        Intrinsics.checkNotNullExpressionValue(userDressKey, "userDressKey");
                        String str3 = userDressKey.f431888a;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.owner");
                        dressKeys = new DressKeys(str3, "");
                    } else {
                        dressKeys = null;
                    }
                    resource.setFilament(new FilamentResource(resourceIdentify, null, dressKeys, d(fVar.f431877f)));
                    unit = Unit.INSTANCE;
                }
            }
            resourceIdentify = resourceIdentify2;
            userDressKey = fVar.f431876e;
            if (userDressKey == null) {
            }
            resource.setFilament(new FilamentResource(resourceIdentify, null, dressKeys, d(fVar.f431877f)));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            resource.setFilament(new FilamentResource(resourceIdentify2, null, null, null));
        }
    }

    @NotNull
    public static final Size b(@NotNull rp4.a aVar, boolean z16) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Application application = Square.INSTANCE.getApplication();
        int i3 = aVar.f431860a;
        if (z16) {
            i3 = ViewExtensionsKt.calPx(application, i3);
        }
        int i16 = aVar.f431861b;
        if (z16) {
            i16 = ViewExtensionsKt.calPx(application, i16);
        }
        return new Size(i3, i16);
    }

    public static /* synthetic */ Size c(rp4.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return b(aVar, z16);
    }

    @Nullable
    public static final FilamentCoverResource d(@Nullable rp4.b bVar) {
        String str;
        String str2 = null;
        if (bVar == null) {
            return null;
        }
        String str3 = bVar.f431862a;
        String str4 = "";
        if (str3 == null) {
            str3 = "";
        }
        rp4.h hVar = bVar.f431863b;
        if (hVar != null) {
            str = hVar.f431888a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (hVar != null) {
            str2 = hVar.f431889b;
        }
        if (str2 == null) {
            str2 = "";
        }
        DressKeys dressKeys = new DressKeys(str, str2);
        String str5 = bVar.f431864c;
        if (str5 != null) {
            str4 = str5;
        }
        return new FilamentCoverResource(str3, dressKeys, str4);
    }

    @NotNull
    public static final Resource e(@NotNull rp4.f fVar, @Nullable DressKeys dressKeys) {
        Size size;
        Size size2;
        int i3;
        rp4.a aVar;
        rp4.a aVar2;
        String str;
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        if (fVar.f431876e == null) {
            rp4.h hVar = new rp4.h();
            if (dressKeys == null || (str = dressKeys.getOwner()) == null) {
                str = "";
            }
            hVar.f431888a = str;
            fVar.f431876e = hVar;
        }
        int i16 = fVar.f431872a;
        rp4.e eVar = fVar.f431874c;
        int i17 = 0;
        if (eVar == null || (aVar2 = eVar.f431871b) == null || (size = c(aVar2, false, 1, null)) == null) {
            size = new Size(0, 0);
        }
        Size size3 = size;
        rp4.e eVar2 = fVar.f431874c;
        if (eVar2 == null || (aVar = eVar2.f431870a) == null || (size2 = b(aVar, false)) == null) {
            size2 = new Size(0, 0);
        }
        Size size4 = size2;
        SquareBase squareBase = SquareBase.INSTANCE;
        Application app = squareBase.getApp();
        qp4.f fVar2 = fVar.f431875d;
        if (fVar2 != null) {
            i3 = fVar2.f429217a;
        } else {
            i3 = 0;
        }
        int calPx = ViewExtensionsKt.calPx(app, i3);
        Application app2 = squareBase.getApp();
        qp4.f fVar3 = fVar.f431875d;
        if (fVar3 != null) {
            i17 = fVar3.f429218b;
        }
        Resource resource = new Resource(i16, null, null, size3, size4, false, new Point(calPx, ViewExtensionsKt.calPx(app2, i17)), 0, 1, null, 550, null);
        a(resource, fVar);
        return resource;
    }

    public static /* synthetic */ Resource f(rp4.f fVar, DressKeys dressKeys, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dressKeys = null;
        }
        return e(fVar, dressKeys);
    }

    @NotNull
    public static final op4.h g(@NotNull LbsDataV2.PoiInfo poiInfo) {
        Intrinsics.checkNotNullParameter(poiInfo, "<this>");
        op4.h hVar = new op4.h();
        String str = poiInfo.poiId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hVar.f423330a = str;
        String str3 = poiInfo.poiName;
        if (str3 == null) {
            str3 = "";
        }
        hVar.f423331b = str3;
        hVar.f423332c = poiInfo.poiType;
        String str4 = poiInfo.poiTypeName;
        if (str4 == null) {
            str4 = "";
        }
        hVar.f423333d = str4;
        String str5 = poiInfo.address;
        if (str5 == null) {
            str5 = "";
        }
        hVar.f423334e = str5;
        hVar.f423335f = poiInfo.districtCode;
        op4.f fVar = new op4.f();
        LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
        fVar.f423324a = gpsInfo.lat;
        fVar.f423325b = gpsInfo.lon;
        fVar.f423326c = gpsInfo.gpsType;
        fVar.f423327d = gpsInfo.alt;
        hVar.f423336g = fVar;
        hVar.f423337h = poiInfo.distance;
        hVar.f423338i = poiInfo.hotValue;
        String str6 = poiInfo.phoneNumber;
        if (str6 == null) {
            str6 = "";
        }
        hVar.f423339j = str6;
        String str7 = poiInfo.country;
        if (str7 == null) {
            str7 = "";
        }
        hVar.f423340k = str7;
        String str8 = poiInfo.province;
        if (str8 == null) {
            str8 = "";
        }
        hVar.f423341l = str8;
        String str9 = poiInfo.city;
        if (str9 == null) {
            str9 = "";
        }
        hVar.f423342m = str9;
        hVar.f423343n = poiInfo.poiNum;
        hVar.f423344o = poiInfo.poiOrderType;
        String str10 = poiInfo.poiDefaultName;
        if (str10 == null) {
            str10 = "";
        }
        hVar.f423345p = str10;
        String str11 = poiInfo.district;
        if (str11 == null) {
            str11 = "";
        }
        hVar.f423346q = str11;
        String str12 = poiInfo.dianPingId;
        if (str12 == null) {
            str12 = "";
        }
        hVar.f423347r = str12;
        String str13 = poiInfo.poiName;
        if (str13 != null || (str13 = hVar.f423334e) != null) {
            str2 = str13;
        }
        hVar.f423349t = str2;
        return hVar;
    }
}
