package nk;

import ak.h;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.qzone.reborn.intimate.request.QZoneIntimateGetISpaceListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.ArrayUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$CreateMoreSpaceGuide;
import qzone.QZIntimateProfileReader$GetISpaceListRsp;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002R)\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100!0 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR$\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010?\u001a\u0004\bR\u0010A\"\u0004\bS\u0010CR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010?\u001a\u0004\bV\u0010A\"\u0004\bW\u0010C\u00a8\u0006]"}, d2 = {"Lnk/aw;", "Lcom/qzone/reborn/base/n;", "", "Q1", "", "R1", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateProfileReader$GetISpaceListRsp;", "rsp", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "b2", "", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "spaceListData", "Lij/i;", "O1", "P1", "beanList", "T1", "d2", SemanticAttributes.DbSystemValues.H2, "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e2", "forceManage", "f2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "i", "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "Lqzone/QZoneBaseCommon$StCommonExt;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqzone/QZoneBaseCommon$StCommonExt;", "U1", "()Lqzone/QZoneBaseCommon$StCommonExt;", "setCommonExt", "(Lqzone/QZoneBaseCommon$StCommonExt;)V", "commonExt", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "getLoadInfo", "()Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "setLoadInfo", "(Lcom/tencent/biz/richframework/part/block/base/LoadInfo;)V", "loadInfo", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "D", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "W1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", "setInitBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;)V", "initBean", "E", "Z", "c2", "()Z", "setGuest", "(Z)V", "isGuest", UserInfo.SEX_FEMALE, "X1", "setShowHistorySpace", "showHistorySpace", "Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "G", "Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "getCreateMoreSpaceGuide", "()Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "setCreateMoreSpaceGuide", "(Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;)V", "createMoreSpaceGuide", "H", "Z1", "setShowManual", "showManual", "I", "getHasInitDescText", "setHasInitDescText", "hasInitDescText", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class aw extends com.qzone.reborn.base.n {

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneIntimateManageInitBean initBean;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isGuest;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean showHistorySpace;

    /* renamed from: G, reason: from kotlin metadata */
    private QZIntimateProfileReader$CreateMoreSpaceGuide createMoreSpaceGuide;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showManual;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hasInitDescText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneBaseCommon$StCommonExt commonExt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<List<ij.i>>> spaceListData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    private final List<ij.i> O1(List<QZIntimateProfileReader$IntimateSpaceAbs> spaceListData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<ij.i> arrayList3 = new ArrayList<>();
        if (spaceListData.isEmpty()) {
            return arrayList3;
        }
        for (QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs : spaceListData) {
            ij.i iVar = new ij.i(qZIntimateProfileReader$IntimateSpaceAbs.space_type.get(), qZIntimateProfileReader$IntimateSpaceAbs.space_status.get());
            iVar.j(qZIntimateProfileReader$IntimateSpaceAbs);
            iVar.h(this.isGuest);
            iVar.i(d2());
            if (mk.d.f416875a.v(iVar)) {
                arrayList2.add(iVar);
            } else {
                arrayList.add(iVar);
            }
        }
        if ((!arrayList.isEmpty()) && ((ij.i) arrayList.get(0)).getIsNeedUpdateDesc()) {
            this.hasInitDescText = true;
            jk.c.f410300a.h();
        }
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        if (mk.d.f416875a.G(this.createMoreSpaceGuide)) {
            ij.i iVar2 = new ij.i(10001, 0);
            iVar2.g(this.createMoreSpaceGuide);
            arrayList3.add(iVar2);
        }
        T1(arrayList3);
        return arrayList3;
    }

    private final List<ij.i> P1() {
        ArrayList arrayList = new ArrayList();
        if (mk.d.f416875a.G(this.createMoreSpaceGuide)) {
            ij.i iVar = new ij.i(10001, 0);
            iVar.g(this.createMoreSpaceGuide);
            arrayList.add(iVar);
        }
        return arrayList;
    }

    private final boolean Q1() {
        if (!PreLoader.exists("manage_page_data_preload_id")) {
            return false;
        }
        QLog.d(getTAG(), 1, "canFetchDataFromPreloadTask from preload task");
        R1();
        return true;
    }

    private final void R1() {
        PreLoader.addListener("manage_page_data_preload_id", new OnTaskListener() { // from class: nk.av
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                aw.S1(aw.this, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(aw this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof h.b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.preload.QZoneIntimateManagePreloadTask.RspBean");
            h.b bVar = (h.b) obj;
            this$0.b2(bVar.getIsSuccess(), bVar.getRetCode(), bVar.getErrMsg(), bVar.getRsp(), bVar.getCom.tencent.component.network.downloader.impl.ipc.Const.BUNDLE_KEY_REQUEST java.lang.String());
        }
    }

    private final void b2(boolean isSuccess, long retCode, String errMsg, QZIntimateProfileReader$GetISpaceListRsp rsp, BaseRequest request) {
        this.loadInfo.setCurrentState(4);
        if (isSuccess && rsp != null && retCode == 0) {
            this.commonExt = rsp.ext.get();
            this.showHistorySpace = rsp.hasResumableSpace.get();
            this.createMoreSpaceGuide = rsp.create_more_space_guide.get();
            this.showManual = rsp.show_manual.get();
            QLog.d(getTAG(), 1, "[handleSpaceListResponse]  | request: " + request.get$cmd() + " | rsp.spaces.size: " + rsp.spaces.size() + " | rsp.hasResumableSpace: " + rsp.hasResumableSpace.get() + " | createMoreSpaceGuideText\uff1a " + rsp.create_more_space_guide.guide_text.get() + " | showManual = " + rsp.show_manual.get());
            if (bl.b(rsp.spaces.get())) {
                this.spaceListData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(false, P1()));
                return;
            }
            MutableLiveData<UIStateData<List<ij.i>>> mutableLiveData = this.spaceListData;
            UIStateData obtainSuccess = UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg));
            List<QZIntimateProfileReader$IntimateSpaceAbs> list = rsp.spaces.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.spaces.get()");
            mutableLiveData.postValue(obtainSuccess.setData(false, O1(list)));
            return;
        }
        QLog.e(getTAG(), 1, "handleSpaceListResponse rsp error request = " + request.get$cmd() + " isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
        this.spaceListData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode));
    }

    private final boolean d2() {
        return !this.hasInitDescText || jk.c.f410300a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(aw this$0, BaseRequest request1, boolean z16, long j3, String errMsg, QZIntimateProfileReader$GetISpaceListRsp qZIntimateProfileReader$GetISpaceListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(this$0.getTAG(), 1, "[requestGetManageSpaceList] responseLog onReceive | isSuccess: " + z16 + " | traceId: " + request1.getTraceId() + " | seqId:" + request1.getCurrentSeq() + " | cmdName:" + request1.get$cmd() + " | retCode:" + j3 + " | retMessage:" + errMsg);
        this$0.b2(z16, j3, errMsg, qZIntimateProfileReader$GetISpaceListRsp, request1);
    }

    private final void h2() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    /* renamed from: U1, reason: from getter */
    public final QZoneBaseCommon$StCommonExt getCommonExt() {
        return this.commonExt;
    }

    /* renamed from: W1, reason: from getter */
    public final QZoneIntimateManageInitBean getInitBean() {
        return this.initBean;
    }

    /* renamed from: X1, reason: from getter */
    public final boolean getShowHistorySpace() {
        return this.showHistorySpace;
    }

    /* renamed from: Z1, reason: from getter */
    public final boolean getShowManual() {
        return this.showManual;
    }

    public final MutableLiveData<UIStateData<List<ij.i>>> a2() {
        return this.spaceListData;
    }

    /* renamed from: c2, reason: from getter */
    public final boolean getIsGuest() {
        return this.isGuest;
    }

    public final void f2(boolean forceManage) {
        QLog.d(getTAG(), 1, "requestGetAlbumBatchList ");
        h2();
        if (Q1()) {
            return;
        }
        if (this.loadInfo.getCurrentState() != 4) {
            QLog.w(getTAG(), 1, "requestGetAlbumBatchList  mLoadInfo.currentState = " + this.loadInfo.getCurrentState());
            return;
        }
        this.loadInfo.setCurrentState(2);
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateGetISpaceListRequest(this.initBean), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.au
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                aw.g2(aw.this, baseRequest, z16, j3, str, (QZIntimateProfileReader$GetISpaceListRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateManageViewModel";
    }

    private final void T1(List<ij.i> beanList) {
        if (ArrayUtils.isOutOfArrayIndex(0, beanList)) {
            return;
        }
        Iterator<ij.i> it = beanList.iterator();
        while (it.hasNext()) {
            ij.i next = it.next();
            if (mk.d.f416875a.x(next)) {
                QLog.i("QZoneIntimateManageViewModel", 1, "invalid space data, id is " + next.getType() + ", status is " + next.getStatus() + ", id is " + next.getSpaceAbsData().space_id.get());
                it.remove();
            }
        }
    }

    public final void e2(Activity activity) {
        Intent intent;
        Bundle extras;
        boolean z16;
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean");
        QZoneIntimateManageInitBean qZoneIntimateManageInitBean = (QZoneIntimateManageInitBean) serializable;
        this.initBean = qZoneIntimateManageInitBean;
        if (!Intrinsics.areEqual(qZoneIntimateManageInitBean != null ? qZoneIntimateManageInitBean.getUid() : null, "")) {
            String uid = LoginData.getInstance().getUid();
            QZoneIntimateManageInitBean qZoneIntimateManageInitBean2 = this.initBean;
            if (!Intrinsics.areEqual(uid, qZoneIntimateManageInitBean2 != null ? qZoneIntimateManageInitBean2.getUid() : null)) {
                z16 = true;
                this.isGuest = z16;
                QLog.d(getTAG(), 1, "parseIntent , isGuest = " + this.isGuest);
            }
        }
        z16 = false;
        this.isGuest = z16;
        QLog.d(getTAG(), 1, "parseIntent , isGuest = " + this.isGuest);
    }
}
