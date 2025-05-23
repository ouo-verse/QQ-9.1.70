package com.tencent.mobileqq.zplan.easteregg.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.ErrorMsg;
import com.tencent.mobileqq.zplan.easteregg.model.PortraitQueryType;
import com.tencent.mobileqq.zplan.easteregg.t;
import com.tencent.mobileqq.zplan.easteregg.x;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Priority;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/e;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/f;", "Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "params", "Lcom/tencent/mobileqq/zplan/easteregg/manager/g;", "listener", "", "b", "", "a", "I", "getType", "()I", "setType", "(I)V", "type", "Lcom/tencent/mobileqq/zplan/easteregg/x;", "Lcom/tencent/mobileqq/zplan/easteregg/x;", "mEasterEggPortraitResourceManager", "c", "mPortraitResourceWidth", "d", "mPortraitResourceHeight", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type = 3;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private x mEasterEggPortraitResourceManager = new EasterEggPortraitResourceManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mPortraitResourceWidth = 360;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mPortraitResourceHeight = 360;

    @Override // com.tencent.mobileqq.zplan.easteregg.manager.f
    public int getType() {
        return this.type;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/manager/e$b", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "", "idList", "", "pathList", "msg", "", "a", "Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<IEasterEggResourceTaskResult> f332932a;

        b(g<IEasterEggResourceTaskResult> gVar) {
            this.f332932a = gVar;
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.t
        public void b(ErrorMsg errMsg) {
            Integer errorCode;
            QLog.w("GetPortraitHeadTask", 1, "queryEasterEggResource onError, id: " + (errMsg != null ? errMsg.getActionId() : null) + " errorMsg: " + (errMsg != null ? errMsg.getErrorCode() : null));
            this.f332932a.a((errMsg == null || (errorCode = errMsg.getErrorCode()) == null) ? 2 : errorCode.intValue(), null);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.t
        public void a(PortraitSource source, List<Integer> idList, List<String> pathList, String msg2) {
            Intrinsics.checkNotNullParameter(source, "source");
            List<Integer> list = idList;
            if (!(list == null || list.isEmpty())) {
                List<String> list2 = pathList;
                if (!(list2 == null || list2.isEmpty())) {
                    int intValue = idList.get(0).intValue();
                    String str = pathList.get(0);
                    QLog.i("GetPortraitHeadTask", 1, "queryEasterEggResource onResource, id: " + intValue + "\uff0c path: " + str);
                    if (!(str.length() == 0) && intValue >= 0) {
                        this.f332932a.a(0, new IEasterEggResourceTaskResult(null, null, null, null, str, source, 15, null));
                        return;
                    } else {
                        this.f332932a.a(2, null);
                        return;
                    }
                }
            }
            QLog.e("GetPortraitHeadTask", 1, "query portrait resource failed, idList: " + idList + ", pathList: " + pathList);
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.manager.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.tencent.mobileqq.zplan.easteregg.model.c params, g<IEasterEggResourceTaskResult> listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.mobileqq.zplan.easteregg.a aVar = params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        int portraitID = aVar != null ? aVar.getPortraitID() : 0;
        String uin = params.getUin();
        String str = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey;
        if (TextUtils.isEmpty(uin)) {
            QLog.i("GetPortraitHeadTask", 1, "GetPortraitHeadTask uin is empty");
            listener.a(1, null);
            return;
        }
        List<Integer> easterEggAllConfigPortraitId = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getEasterEggAllConfigPortraitId();
        List<Integer> list = TypeIntrinsics.isMutableList(easterEggAllConfigPortraitId) ? easterEggAllConfigPortraitId : null;
        if (list == null) {
            list = new ArrayList();
        }
        com.tencent.mobileqq.zplan.easteregg.model.d dVar = new com.tencent.mobileqq.zplan.easteregg.model.d(Integer.valueOf(portraitID), list, PortraitQueryType.SINGLE_QUERY, str, uin, this.mPortraitResourceWidth, this.mPortraitResourceHeight, params.getMSceneSource(), params.getNeedRecord(), null, null, Priority.HIGH, 1536, null);
        x xVar = this.mEasterEggPortraitResourceManager;
        Intrinsics.checkNotNull(xVar);
        xVar.a(dVar, new b(listener));
    }
}
