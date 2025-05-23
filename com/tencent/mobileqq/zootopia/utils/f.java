package com.tencent.mobileqq.zootopia.utils;

import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaSimpleVerInfo;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.y;
import qv4.ap;
import qv4.bg;
import qv4.t;
import zb3.ZootopiaMapListData;
import zb3.ZootopiaSameStyleData;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/f;", "", "Lqv4/bg;", "rsp", "", "a", "Lqv4/t;", "Lzb3/i;", "b", "Lqv4/ap;", "info", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "c", "Lpv4/y;", "Lcom/tencent/sqshow/zootopia/data/ZootopiaSimpleVerInfo;", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f329556a = new f();

    f() {
    }

    public final ZootopiaMapListData b(t rsp) {
        ZootopiaSameStyleData zootopiaSameStyleData;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        ap[] apVarArr = rsp.f430199a;
        Intrinsics.checkNotNullExpressionValue(apVarArr, "rsp.mapList");
        ArrayList arrayList = new ArrayList(apVarArr.length);
        for (ap mapInfoSimple : apVarArr) {
            ZootopiaMapStatusManager zootopiaMapStatusManager = ZootopiaMapStatusManager.f370743d;
            String valueOf = String.valueOf(mapInfoSimple.f429974a);
            y yVar = mapInfoSimple.f429983j;
            Intrinsics.checkNotNullExpressionValue(yVar, "mapInfoSimple.verControlInfo");
            zootopiaMapStatusManager.e(valueOf, yVar);
            f fVar = f329556a;
            Intrinsics.checkNotNullExpressionValue(mapInfoSimple, "mapInfoSimple");
            arrayList.add(fVar.c(mapInfoSimple));
        }
        if (!a(rsp.f430202d) || w84.a.f445029a.d()) {
            zootopiaSameStyleData = null;
        } else {
            nv4.m[] mVarArr = rsp.f430202d.f430059c;
            Intrinsics.checkNotNullExpressionValue(mVarArr, "rsp.sameStyleRsp.templateList");
            ArrayList arrayList2 = new ArrayList(mVarArr.length);
            for (nv4.m template : mVarArr) {
                Intrinsics.checkNotNullExpressionValue(template, "template");
                arrayList2.add(rb4.a.a(template));
            }
            String str = rsp.f430202d.f430057a;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.sameStyleRsp.sameStyleTitle");
            zootopiaSameStyleData = new ZootopiaSameStyleData(str, rsp.f430202d.f430058b, arrayList2);
        }
        QLog.i("IZPlanMapListService", 1, "GetMapListRsp - convertMapListData, mapList.size = " + arrayList.size() + ", hasSameStyle = " + (zootopiaSameStyleData != null));
        return new ZootopiaMapListData(arrayList, zootopiaSameStyleData);
    }

    public final ZootopiaMapSimpleInfo c(ap info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ZootopiaMapSimpleInfo zootopiaMapSimpleInfo = new ZootopiaMapSimpleInfo(info.f429974a);
        zootopiaMapSimpleInfo.setType(info.f429975b);
        String str = info.f429976c;
        Intrinsics.checkNotNullExpressionValue(str, "info.typeStr");
        zootopiaMapSimpleInfo.setTypeName(str);
        String str2 = info.f429977d;
        Intrinsics.checkNotNullExpressionValue(str2, "info.name");
        zootopiaMapSimpleInfo.setName(str2);
        String str3 = info.f429978e;
        Intrinsics.checkNotNullExpressionValue(str3, "info.desc");
        zootopiaMapSimpleInfo.setDesc(str3);
        String str4 = info.f429979f;
        Intrinsics.checkNotNullExpressionValue(str4, "info.background");
        zootopiaMapSimpleInfo.setBackground(str4);
        zootopiaMapSimpleInfo.setBackgroundType(info.f429980g);
        String[] strArr = info.f429981h;
        Intrinsics.checkNotNullExpressionValue(strArr, "info.labels");
        for (String str5 : strArr) {
            zootopiaMapSimpleInfo.getLabels().add(str5);
        }
        String str6 = info.f429982i;
        Intrinsics.checkNotNullExpressionValue(str6, "info.button");
        zootopiaMapSimpleInfo.setButton(str6);
        zootopiaMapSimpleInfo.setSimpleVerInfo(d(info.f429983j));
        zootopiaMapSimpleInfo.setShowOrder(info.f429985l);
        zootopiaMapSimpleInfo.setSceneType(info.f429984k);
        String str7 = info.f429986m;
        Intrinsics.checkNotNullExpressionValue(str7, "info.mapProjName");
        zootopiaMapSimpleInfo.setMapProjName(str7);
        String str8 = info.f429987n;
        Intrinsics.checkNotNullExpressionValue(str8, "info.barPic");
        zootopiaMapSimpleInfo.setBarPic(str8);
        String str9 = info.f429988o;
        Intrinsics.checkNotNullExpressionValue(str9, "info.typeIcon");
        zootopiaMapSimpleInfo.setTypeIcon(str9);
        String str10 = info.f429989p;
        Intrinsics.checkNotNullExpressionValue(str10, "info.backColor");
        zootopiaMapSimpleInfo.setBackColor(str10);
        String str11 = info.f429992s;
        Intrinsics.checkNotNullExpressionValue(str11, "info.videoUrl");
        zootopiaMapSimpleInfo.setVideoUrl(str11);
        zootopiaMapSimpleInfo.setShowGameHealthyLoading(info.f429993t);
        zootopiaMapSimpleInfo.setReserveItem(info.f429994u);
        zootopiaMapSimpleInfo.setBeforeOnlineToast(info.f429995v);
        zootopiaMapSimpleInfo.setLoadingParams(ZootopiaMapLoadingParams.INSTANCE.a(info.f429996w));
        return zootopiaMapSimpleInfo;
    }

    private final boolean a(bg rsp) {
        if ((rsp != null ? rsp.f430059c : null) == null) {
            return false;
        }
        nv4.m[] mVarArr = rsp.f430059c;
        Intrinsics.checkNotNullExpressionValue(mVarArr, "rsp.templateList");
        return (mVarArr.length == 0) ^ true;
    }

    public final ZootopiaSimpleVerInfo d(y info) {
        if (info == null) {
            return new ZootopiaSimpleVerInfo(0, 1, null);
        }
        ZootopiaSimpleVerInfo zootopiaSimpleVerInfo = new ZootopiaSimpleVerInfo(info.f427728a);
        zootopiaSimpleVerInfo.setModVersionSimpleData(ZPlanModVersionSimpleData.INSTANCE.b(info));
        zootopiaSimpleVerInfo.setQqVerTip(info.f427729b);
        zootopiaSimpleVerInfo.setMapVerTip(info.f427730c);
        zootopiaSimpleVerInfo.setMapStatus(info.f427736i);
        zootopiaSimpleVerInfo.setCloudGameInfo(ZPlanCloudGameInfo.INSTANCE.b(info.f427741n));
        zootopiaSimpleVerInfo.setDiffPatchInfo(ZPlanMapDiffPatchInfo.INSTANCE.b(info.f427742o));
        return zootopiaSimpleVerInfo;
    }
}
