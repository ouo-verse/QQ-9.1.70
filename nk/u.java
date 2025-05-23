package nk;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.intimate.bean.QZoneIntimateActivateResultBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateUserBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.request.QZIntimateGetRelationshipInfoRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateActivateSpaceRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$ClientCreateISpacesRsp;
import qzone.QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp;
import qzone.QZIntimateSpaceReader$RelatationInfo;
import qzone.QZIntimateSpaceReader$RelatedUser;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J*\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rR(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lnk/u;", "Lcom/qzone/reborn/base/n;", "", "Lqzone/QZoneBaseMeta$StUser;", "S1", "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateProfileReader$ClientCreateISpacesRsp;", "rsp", "", "T1", "Lqzone/QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp;", "U1", "getLogTag", "W1", "Q1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateActivateResultBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "setActivateResultBean", "(Landroidx/lifecycle/MutableLiveData;)V", "activateResultBean", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "getActivateSpaceBean", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "Z1", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;)V", "activateSpaceBean", BdhLogUtil.LogTag.Tag_Conn, "J", "P1", "()J", "setAnniversary", "(J)V", "anniversary", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class u extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private long anniversary;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<QZoneIntimateActivateResultBean> activateResultBean = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateActivateSpaceBean activateSpaceBean;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(u this$0, BaseRequest baseRequest, boolean z16, long j3, String errMsg, QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp qZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.U1(z16, j3, errMsg, qZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp);
    }

    private final List<QZoneBaseMeta$StUser> S1() {
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = this.activateSpaceBean;
        if (qZoneIntimateActivateSpaceBean != null) {
            if (!ArrayUtils.isOutOfArrayIndex(0, qZoneIntimateActivateSpaceBean != null ? qZoneIntimateActivateSpaceBean.getUsers() : null)) {
                ArrayList arrayList = new ArrayList();
                QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean2 = this.activateSpaceBean;
                Intrinsics.checkNotNull(qZoneIntimateActivateSpaceBean2);
                Iterator<QZoneIntimateUserBean> it = qZoneIntimateActivateSpaceBean2.getUsers().iterator();
                while (it.hasNext()) {
                    arrayList.add(oj.a.f423008a.i(it.next()));
                }
                return arrayList;
            }
        }
        RFWLog.e("QZoneIntimateActivateViewModel", RFWLog.USR, "activate bean is null or users is empty");
        return null;
    }

    private final void T1(boolean isSuccess, long retCode, String errMsg, QZIntimateProfileReader$ClientCreateISpacesRsp rsp) {
        QZoneIntimateActivateResultBean qZoneIntimateActivateResultBean = new QZoneIntimateActivateResultBean();
        if (isSuccess && rsp != null && retCode == 0) {
            qZoneIntimateActivateResultBean.setActivateStatus(true);
            String str = rsp.space_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.space_id.get()");
            qZoneIntimateActivateResultBean.setSpaceId(str);
            RFWLog.i(getTAG(), RFWLog.USR, "activate space id is " + rsp.space_id.get());
        } else {
            RFWLog.e(getTAG(), RFWLog.USR, "handleActivateSpaceResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
            qZoneIntimateActivateResultBean.setActivateStatus(false);
        }
        this.activateResultBean.postValue(qZoneIntimateActivateResultBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(u this$0, BaseRequest baseRequest, boolean z16, long j3, String errMsg, QZIntimateProfileReader$ClientCreateISpacesRsp qZIntimateProfileReader$ClientCreateISpacesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.T1(z16, j3, errMsg, qZIntimateProfileReader$ClientCreateISpacesRsp);
    }

    public final MutableLiveData<QZoneIntimateActivateResultBean> O1() {
        return this.activateResultBean;
    }

    /* renamed from: P1, reason: from getter */
    public final long getAnniversary() {
        return this.anniversary;
    }

    public final void Q1() {
        sendRequest(new QZIntimateGetRelationshipInfoRequest(), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.t
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                u.R1(u.this, baseRequest, z16, j3, str, (QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp) obj);
            }
        });
    }

    public final void W1() {
        if (ArrayUtils.isOutOfArrayIndex(0, S1())) {
            RFWLog.e("QZoneIntimateActivateViewModel", RFWLog.USR, "users is empty");
            return;
        }
        List<QZoneBaseMeta$StUser> S1 = S1();
        Intrinsics.checkNotNull(S1);
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = this.activateSpaceBean;
        QZoneIntimateActivateSpaceRequest qZoneIntimateActivateSpaceRequest = new QZoneIntimateActivateSpaceRequest(S1, qZoneIntimateActivateSpaceBean != null ? qZoneIntimateActivateSpaceBean.getSpaceType() : 0, this.anniversary);
        RFWLog.i("QZoneIntimateActivateViewModel", RFWLog.USR, "activate anniversary is " + this.anniversary);
        sendRequest(qZoneIntimateActivateSpaceRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.s
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                u.X1(u.this, baseRequest, z16, j3, str, (QZIntimateProfileReader$ClientCreateISpacesRsp) obj);
            }
        });
    }

    public final void Z1(QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean) {
        this.activateSpaceBean = qZoneIntimateActivateSpaceBean;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateActivateViewModel";
    }

    private final void U1(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp rsp) {
        if (isSuccess && rsp != null && retCode == 0) {
            if (ArrayUtils.isOutOfArrayIndex(0, rsp.infos.get())) {
                return;
            }
            for (QZIntimateSpaceReader$RelatationInfo qZIntimateSpaceReader$RelatationInfo : rsp.infos.get()) {
                com.tencent.qqcamerakit.common.e.e("QZoneIntimateActivateViewModel", 1, "info type is " + qZIntimateSpaceReader$RelatationInfo.type.get());
                if (mk.d.f416875a.y(Integer.valueOf(qZIntimateSpaceReader$RelatationInfo.type.get()))) {
                    List<QZIntimateSpaceReader$RelatedUser> list = qZIntimateSpaceReader$RelatationInfo.users.get();
                    if (!ArrayUtils.isOutOfArrayIndex(0, list)) {
                        long j3 = list.get(0).relation_start_time.get();
                        this.anniversary = j3;
                        RFWLog.i("QZoneIntimateActivateViewModel", RFWLog.USR, "anniversary time is " + j3);
                    }
                }
            }
            return;
        }
        RFWLog.e(getTAG(), RFWLog.USR, "handleActivateSpaceResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }
}
