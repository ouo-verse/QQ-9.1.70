package com.tencent.mobileqq.zootopia.mapstatus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.mapstatus.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pv4.y;
import qv4.v;
import yb4.m;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\b\u000eB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", "", "", "mapId", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "callback", "", "a", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "downloadData", "c", "Lqv4/v;", "result", "b", "Lyb4/m;", "Lyb4/m;", "verStatusService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaMapStatusService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final m verStatusService = new m();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/v;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e<v> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaDownloadData f328592e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e<MapStatusInfoResult> f328593f;

        c(ZootopiaDownloadData zootopiaDownloadData, e<MapStatusInfoResult> eVar) {
            this.f328592e = zootopiaDownloadData;
            this.f328593f = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(v result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZootopiaMapStatusService.this.b(result, this.f328592e, this.f328593f);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f328593f.onResultFailure(error, message);
        }
    }

    public final void a(final int mapId, final e<MapStatusInfoResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZootopiaDownloadManager.f327992a.Y(String.valueOf(mapId), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService$getNewestMapStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZootopiaMapStatusService.this.c(mapId, zootopiaDownloadData, callback);
            }
        });
    }

    public final void b(v result, ZootopiaDownloadData downloadData, e<MapStatusInfoResult> callback) {
        Object first;
        String str;
        ZootopiaResData resData;
        ZootopiaResData resData2;
        ZootopiaResData resData3;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(callback, "callback");
        y[] yVarArr = result.f430204a;
        Intrinsics.checkNotNullExpressionValue(yVarArr, "result.verControlInfos");
        if (yVarArr.length == 0) {
            callback.onResultFailure(-999, "verControlInfos is empty!");
            return;
        }
        y[] yVarArr2 = result.f430204a;
        Intrinsics.checkNotNullExpressionValue(yVarArr2, "result.verControlInfos");
        first = ArraysKt___ArraysKt.first(yVarArr2);
        y yVar = (y) first;
        if (yVar == null) {
            callback.onResultFailure(-999, "verControlInfo is null!");
            return;
        }
        d dVar = d.f370777a;
        Integer num = null;
        MapStatus e16 = d.e(dVar, (downloadData == null || (resData3 = downloadData.getResData()) == null) ? null : Integer.valueOf(resData3.getDownloadStatus()), null, 2, null);
        int i3 = yVar.f427736i;
        if (downloadData != null && (resData2 = downloadData.getResData()) != null) {
            num = Integer.valueOf(resData2.getDownloadStatus());
        }
        MapStatus b16 = dVar.b(i3, num);
        if (b16 == null && (b16 = dVar.c(yVar.f427729b)) == null) {
            int i16 = yVar.f427730c;
            if (downloadData == null || (resData = downloadData.getResData()) == null || (str = resData.getVersion()) == null) {
                str = "";
            }
            String str2 = yVar.f427731d;
            Intrinsics.checkNotNullExpressionValue(str2, "verControlInfo.nowMapVer");
            MapStatus a16 = dVar.a(i16, str, str2);
            if (a16 != null) {
                e16 = a16;
            }
        } else {
            e16 = b16;
        }
        callback.onResultSuccess(new MapStatusInfoResult(e16, downloadData, result));
    }

    public final void c(int mapId, ZootopiaDownloadData downloadData, e<MapStatusInfoResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof AppInterface)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ZootopiaMapListService.INSTANCE.a(mapId, downloadData != null ? downloadData.getResData() : null));
            m.d(this.verStatusService, (AppInterface) peekAppRuntime, arrayList, 0, new c(downloadData, callback), 4, null);
            return;
        }
        callback.onResultFailure(-999, "app is error!");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "a", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "b", "()Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "()Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "data", "Lqv4/v;", "c", "Lqv4/v;", "()Lqv4/v;", "mapVerStatusRsp", "<init>", "(Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;Lqv4/v;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class MapStatusInfoResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final MapStatus mapStatus;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final ZootopiaDownloadData data;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final v mapVerStatusRsp;

        public MapStatusInfoResult(MapStatus mapStatus, ZootopiaDownloadData zootopiaDownloadData, v mapVerStatusRsp) {
            Intrinsics.checkNotNullParameter(mapStatus, "mapStatus");
            Intrinsics.checkNotNullParameter(mapVerStatusRsp, "mapVerStatusRsp");
            this.mapStatus = mapStatus;
            this.data = zootopiaDownloadData;
            this.mapVerStatusRsp = mapVerStatusRsp;
        }

        /* renamed from: a, reason: from getter */
        public final ZootopiaDownloadData getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final MapStatus getMapStatus() {
            return this.mapStatus;
        }

        /* renamed from: c, reason: from getter */
        public final v getMapVerStatusRsp() {
            return this.mapVerStatusRsp;
        }

        public int hashCode() {
            int hashCode = this.mapStatus.hashCode() * 31;
            ZootopiaDownloadData zootopiaDownloadData = this.data;
            return ((hashCode + (zootopiaDownloadData == null ? 0 : zootopiaDownloadData.hashCode())) * 31) + this.mapVerStatusRsp.hashCode();
        }

        public String toString() {
            return "MapStatusInfoResult(mapStatus=" + this.mapStatus + ", data=" + this.data + ", mapVerStatusRsp=" + this.mapVerStatusRsp + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapStatusInfoResult)) {
                return false;
            }
            MapStatusInfoResult mapStatusInfoResult = (MapStatusInfoResult) other;
            return this.mapStatus == mapStatusInfoResult.mapStatus && Intrinsics.areEqual(this.data, mapStatusInfoResult.data) && Intrinsics.areEqual(this.mapVerStatusRsp, mapStatusInfoResult.mapVerStatusRsp);
        }
    }
}
