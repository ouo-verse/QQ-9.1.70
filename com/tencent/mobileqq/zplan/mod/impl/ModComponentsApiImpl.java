package com.tencent.mobileqq.zplan.mod.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadData;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zplan.authorize.api.CommonModCheckResult;
import com.tencent.mobileqq.zplan.mod.impl.helper.ModDownloadHelper;
import com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nw4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\"\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/ModComponentsApiImpl;", "Lsi3/b;", "", "mapId", "", "mapVersion", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnw4/d;", "callback", "", "G0", "Lti3/a;", "H0", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "E", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "code", "Lkotlin/Function0;", "onHandleFinish", "A0", "sceneName", "", "forceRefresh", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isAfterPortalLoading", "forceDownload", "silentDownloadModInZPlan", "<init>", "()V", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModComponentsApiImpl implements si3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/ModComponentsApiImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnw4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<nw4.d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f334728d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ti3.a f334729e;

        b(int i3, ti3.a aVar) {
            this.f334728d = i3;
            this.f334729e = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(nw4.d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModApiImpl", 1, "enterSceneWithBaseModCheck :: info list size == " + result.f421467c.length);
            ModDownloadHelper.f334765a.h(this.f334728d, result, true, this.f334729e);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ti3.a aVar = this.f334729e;
            if (aVar != null) {
                aVar.a(error, message);
            }
            QLog.e("ModApiImpl", 1, "getBaseModInfo :: error == " + error + " , message == " + message);
        }
    }

    @Override // si3.b
    public void A0(Activity activity, int code, Function0<Unit> onHandleFinish) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onHandleFinish, "onHandleFinish");
        CommonExKt.j(new ModComponentsApiImpl$handleBaseModError$1(code, activity, onHandleFinish));
    }

    @Override // si3.b
    public void E(ZootopiaEnterParams enterParams, ti3.a callback) {
        List<byte[]> modInfoListByteArrayList;
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        nw4.d dVar = new nw4.d();
        CommonModCheckResult commonModCheckResult = enterParams.getCommonModCheckResult();
        dVar.f421465a = commonModCheckResult != null ? commonModCheckResult.getDownloadText() : null;
        CommonModCheckResult commonModCheckResult2 = enterParams.getCommonModCheckResult();
        dVar.f421466b = commonModCheckResult2 != null ? commonModCheckResult2.getLoadingText() : null;
        ArrayList arrayList = new ArrayList();
        CommonModCheckResult commonModCheckResult3 = enterParams.getCommonModCheckResult();
        if (commonModCheckResult3 != null && (modInfoListByteArrayList = commonModCheckResult3.getModInfoListByteArrayList()) != null) {
            Iterator<T> it = modInfoListByteArrayList.iterator();
            while (it.hasNext()) {
                f modInfoData = f.d((byte[]) it.next());
                Intrinsics.checkNotNullExpressionValue(modInfoData, "modInfoData");
                arrayList.add(modInfoData);
            }
        }
        Object[] array = arrayList.toArray(new f[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        f[] fVarArr = (f[]) array;
        dVar.f421467c = fVarArr;
        QLog.i("ModApiImpl", 1, "checkBaseModInfoWithResult :: info list size == " + fVarArr.length);
        ModDownloadHelper.f334765a.h(enterParams.getMapId(), dVar, false, callback);
    }

    @Override // si3.b
    public void G0(int mapId, String mapVersion, e<nw4.d> callback) {
        Intrinsics.checkNotNullParameter(mapVersion, "mapVersion");
        xi3.a.f448031a.b(mapId, mapVersion, callback);
    }

    @Override // si3.b
    public void H0(int mapId, String mapVersion, ti3.a callback) {
        Intrinsics.checkNotNullParameter(mapVersion, "mapVersion");
        ((si3.b) vb3.a.f441346a.a(si3.b.class)).G0(mapId, mapVersion, new b(mapId, callback));
    }

    @Override // si3.b
    public void Q(String sceneName, boolean forceRefresh) {
        Intrinsics.checkNotNullParameter(sceneName, "sceneName");
        ModSilentDownloadHelper.f334775a.F(sceneName, forceRefresh);
        QLog.i("ModApiImpl", 1, "FileDownloadManager preload ---");
        FileDownloadManager.f328148a.m(new Function1<List<? extends FileDownloadData>, Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.ModComponentsApiImpl$silentDownloadModInQQScene$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends FileDownloadData> list) {
                invoke2((List<FileDownloadData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FileDownloadData> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.i("ModApiImpl", 1, "FileDownloadManager.getAllDownloadData preload finish -- " + it.size());
            }
        });
    }

    @Override // si3.b
    public void silentDownloadModInZPlan(boolean isAfterPortalLoading, boolean forceDownload, int mapId) {
        ModSilentDownloadHelper.H(ModSilentDownloadHelper.f334775a, isAfterPortalLoading, forceDownload, mapId, false, 8, null);
    }
}
