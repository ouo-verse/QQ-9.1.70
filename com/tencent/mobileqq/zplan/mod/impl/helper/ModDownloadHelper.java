package com.tencent.mobileqq.zplan.mod.impl.helper;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.download.DownloadDialogUtils;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.Foreground;
import nw4.d;
import nw4.e;
import nw4.f;
import org.json.JSONArray;
import org.json.JSONObject;
import ti3.a;
import tl.h;
import zg3.ZPlanDownloadParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJJ\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J(\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/helper/ModDownloadHelper;", "", "Lti3/a;", "callback", "Lnw4/d;", "result", "Lnw4/f;", "modData", "Ljava/util/ArrayList;", "Lzg3/b;", "Lkotlin/collections/ArrayList;", "downloadList", "", "startTime", "", "isPreDownload", "", "j", "Lnw4/e;", "dataItem", "f", "", "d", "e", "", "mapId", h.F, "i", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModDownloadHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ModDownloadHelper f334765a = new ModDownloadHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/helper/ModDownloadHelper$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "", "progress", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "f", "c", "", "code", h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ti3.a f334766b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f334767c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f334768d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f334769e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f334770f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f334771g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ti3.a aVar, d dVar, f fVar, b bVar, boolean z16, long j3) {
            super(null, 1, null);
            this.f334766b = aVar;
            this.f334767c = dVar;
            this.f334768d = fVar;
            this.f334769e = bVar;
            this.f334770f = z16;
            this.f334771g = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.c(task);
            QLog.i("ModDownloadHelper", 1, "onComplete :: taskId == " + task.getId());
            ti3.a aVar = this.f334766b;
            if (aVar != null) {
                aVar.b(ModDownloadHelper.f334765a.d(this.f334768d), true);
            }
            AppNetConnInfo.unregisterNetInfoHandler(this.f334769e);
            ModDownloadHelper.f334765a.i(this.f334768d.f421476a, this.f334770f);
            ui3.a.f439038a.a(this.f334768d.f421476a, System.currentTimeMillis() - this.f334771g, this.f334770f, 0);
            ((yg3.b) vb3.a.f441346a.a(yg3.b.class)).G(this);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            int roundToInt;
            Intrinsics.checkNotNullParameter(task, "task");
            super.f(progress, task);
            QLog.i("ModDownloadHelper", 1, "onProgress :: progress == " + progress);
            ti3.a aVar = this.f334766b;
            if (aVar != null) {
                String str = this.f334767c.f421465a;
                Intrinsics.checkNotNullExpressionValue(str, "result.downText");
                roundToInt = MathKt__MathJVMKt.roundToInt(progress * 100);
                aVar.onProgress(str, roundToInt);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.h(code, task);
            QLog.e("ModDownloadHelper", 1, "onFailed :: taskId == " + task.getId());
            ti3.a aVar = this.f334766b;
            if (aVar != null) {
                a.C11291a.b(aVar, code, null, 2, null);
            }
            AppNetConnInfo.unregisterNetInfoHandler(this.f334769e);
            ui3.a.f439038a.a(this.f334768d.f421476a, System.currentTimeMillis() - this.f334771g, this.f334770f, code);
            ((yg3.b) vb3.a.f441346a.a(yg3.b.class)).G(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/helper/ModDownloadHelper$b", "Lcom/tencent/mobileqq/zootopia/download/ui/b;", "", "onNetMobile2None", "onNetWifi2None", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.zootopia.download.ui.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f334772d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ti3.a f334773e;

        b(f fVar, ti3.a aVar) {
            this.f334772d = fVar;
            this.f334773e = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            QLog.e("ModDownloadHelper", 1, "onNetMobile2None :: checkSize failed , mapId == " + this.f334772d.f421476a);
            ti3.a aVar = this.f334773e;
            if (aVar != null) {
                a.C11291a.b(aVar, -1002, null, 2, null);
            }
            ModDownloadHelper.f334765a.e();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            QLog.e("ModDownloadHelper", 1, "onNetWifi2None :: checkSize failed , mapId == " + this.f334772d.f421476a);
            ti3.a aVar = this.f334773e;
            if (aVar != null) {
                a.C11291a.b(aVar, -1002, null, 2, null);
            }
            ModDownloadHelper.f334765a.e();
        }
    }

    ModDownloadHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(f modData) {
        JSONArray jSONArray = new JSONArray();
        e[] eVarArr = modData.f421477b;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "modData.dataList");
        for (e eVar : eVarArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", eVar.f421469a);
            jSONObject.put("sort", eVar.f421470b);
            jSONObject.put("type", eVar.f421471c);
            jSONObject.put("pak_source_path", eVar.f421473e);
            jSONObject.put("umg_source_path", eVar.f421472d);
            jSONObject.put("script_entry_path", eVar.f421474f.f427733f);
            jSONArray.mo162put(jSONObject);
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "configArray.toString()");
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        List<x> a16 = ((yg3.b) vb3.a.f441346a.a(yg3.b.class)).a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a16.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            x xVar = (x) next;
            if (xVar.getDownloadStatus() != 2 && xVar.getDownloadStatus() != 1) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        QLog.i("ModDownloadHelper", 1, "onNoNet downloadingCount is " + arrayList.size());
        if (!arrayList.isEmpty()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ((yg3.b) vb3.a.f441346a.a(yg3.b.class)).cancel(((x) it5.next()).getId());
            }
        }
    }

    private final boolean f(e dataItem) {
        File file = new File(v.f328299a.c() + dataItem.f421473e);
        if (!file.exists()) {
            QLog.i("ModDownloadHelper", 1, "Need download , file is not exist , fileName == " + dataItem.f421473e);
            return true;
        }
        String e16 = o.e(file.getAbsolutePath());
        if (Intrinsics.areEqual(dataItem.f421474f.f427738k, e16)) {
            QLog.i("ModDownloadHelper", 1, "No download required pakSourcePath:" + dataItem.f421473e + ", local md5 = " + e16 + " ");
            return false;
        }
        QLog.i("ModDownloadHelper", 1, "Need download , pakSourcePath:" + dataItem.f421473e + ", local md5 = " + e16 + " , remote md5 = " + dataItem.f421474f.f427738k);
        return true;
    }

    public final void i(int mapId, boolean isPreDownload) {
        if (isPreDownload) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt(mapId + "_download_common_mod_source", 1);
            return;
        }
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt(mapId + "_download_common_mod_source", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(ti3.a callback, d result, f modData, ArrayList<ZPlanDownloadParam> downloadList, long startTime, boolean isPreDownload) {
        b bVar = new b(modData, callback);
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, bVar);
        vb3.a aVar = vb3.a.f441346a;
        ((yg3.b) aVar.a(yg3.b.class)).h0(new a(callback, result, modData, bVar, isPreDownload, startTime));
        ((yg3.b) aVar.a(yg3.b.class)).O0(downloadList);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt(modData.f421476a + "_download_common_mod_source", 0);
        QLog.i("ModDownloadHelper", 1, "handleBatchModInfoSuccess :: startDownload , download count == " + downloadList.size());
    }

    public final int g(int mapId) {
        if (mapId <= 0) {
            return 0;
        }
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt(mapId + "_download_common_mod_source", 0);
    }

    public final void h(int mapId, final d result, final boolean isPreDownload, final ti3.a callback) {
        Intrinsics.checkNotNullParameter(result, "result");
        f[] fVarArr = result.f421467c;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "result.infoList");
        if (fVarArr.length == 0) {
            QLog.i("ModDownloadHelper", 1, "enterSceneWithBaseModCheck :: info list is empty");
            if (callback != null) {
                a.C11291a.a(callback, "", false, 2, null);
                return;
            }
            return;
        }
        final f modData = result.f421467c[0];
        int i3 = modData.f421476a;
        if (mapId != i3) {
            if (callback != null) {
                callback.a(-1001, "mapId not equal,local mapId == " + mapId + ",remote mapId == " + i3);
                return;
            }
            return;
        }
        String str = result.f421465a;
        Intrinsics.checkNotNullExpressionValue(str, "result.downText");
        if (str.length() > 0) {
            String str2 = result.f421466b;
            Intrinsics.checkNotNullExpressionValue(str2, "result.loadingText");
            if ((str2.length() > 0) && callback != null) {
                String str3 = result.f421465a;
                Intrinsics.checkNotNullExpressionValue(str3, "result.downText");
                String str4 = result.f421466b;
                Intrinsics.checkNotNullExpressionValue(str4, "result.loadingText");
                callback.c(str3, str4);
            }
        }
        final ArrayList<ZPlanDownloadParam> arrayList = new ArrayList<>();
        e[] eVarArr = modData.f421477b;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "modData.dataList");
        long j3 = 0;
        for (e dataItem : eVarArr) {
            ModDownloadHelper modDownloadHelper = f334765a;
            Intrinsics.checkNotNullExpressionValue(dataItem, "dataItem");
            if (modDownloadHelper.f(dataItem)) {
                String valueOf = String.valueOf(dataItem.f421469a);
                String str5 = dataItem.f421474f.f427732e;
                Intrinsics.checkNotNullExpressionValue(str5, "dataItem.verControlInfo.cosURL");
                arrayList.add(new ZPlanDownloadParam(valueOf, str5, dataItem.f421474f.f427734g, null, 8, null));
                j3 += dataItem.f421474f.f427734g;
                QLog.i("ModDownloadHelper", 1, "handleBatchModInfoSuccess :: need pak , mapId == " + dataItem.f421469a);
            }
        }
        if (arrayList.isEmpty()) {
            if (callback != null) {
                Intrinsics.checkNotNullExpressionValue(modData, "modData");
                a.C11291a.a(callback, d(modData), false, 2, null);
                return;
            }
            return;
        }
        ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
        if (!zootopiaDownloadManager.m0()) {
            QLog.e("ModDownloadHelper", 1, "handleBatchModInfoSuccess :: checkNet failed , mapId == " + mapId);
            if (callback != null) {
                a.C11291a.b(callback, -1002, null, 2, null);
                return;
            }
            return;
        }
        if (!zootopiaDownloadManager.o0(String.valueOf(mapId), j3)) {
            QLog.e("ModDownloadHelper", 1, "handleBatchModInfoSuccess :: checkSize failed , mapId == " + mapId);
            if (callback != null) {
                a.C11291a.b(callback, -1003, null, 2, null);
                return;
            }
            return;
        }
        ui3.a.f439038a.b(mapId, arrayList.size(), j3 / 1024, isPreDownload);
        final long currentTimeMillis = System.currentTimeMillis();
        int i16 = (int) (j3 / 1048576);
        boolean z16 = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("key_mobile_dialog_need_show", true);
        if (i16 >= 10 && m.f329564a.c() && z16) {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                return;
            }
            String string = topActivity.getString(R.string.xip, i16 + "M");
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026download, \"${showSize}M\")");
            DownloadDialogUtils.f327978a.f(topActivity, string, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.helper.ModDownloadHelper$handleBatchModInfoSuccess$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, boolean z18) {
                    if (z17) {
                        ModDownloadHelper modDownloadHelper2 = ModDownloadHelper.f334765a;
                        a aVar = a.this;
                        d dVar = result;
                        f modData2 = modData;
                        Intrinsics.checkNotNullExpressionValue(modData2, "modData");
                        modDownloadHelper2.j(aVar, dVar, modData2, arrayList, currentTimeMillis, isPreDownload);
                    } else {
                        a aVar2 = a.this;
                        if (aVar2 != null) {
                            a.C11291a.b(aVar2, -1004, null, 2, null);
                        }
                    }
                    if (z18) {
                        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("key_mobile_dialog_need_show", false);
                    }
                }
            });
            return;
        }
        Intrinsics.checkNotNullExpressionValue(modData, "modData");
        j(callback, result, modData, arrayList, currentTimeMillis, isPreDownload);
    }
}
