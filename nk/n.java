package nk;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.request.QZIntimateBatchGetVipInfoRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.json.JSONObject;
import qzone.qzoneUnifiedStore$BatchGetMemberShipRsp;
import qzone.qzoneUnifiedStore$MemberShip;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J8\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\u0012\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010H\u0002J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u0019J\u0014\u0010\u001e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u001f\u001a\u00020\tH\u0016R)\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020!0 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R>\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0.j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t`/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lnk/n;", "Lcom/qzone/reborn/base/n;", "", "Lij/i;", "beanList", "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/qzoneUnifiedStore$BatchGetMemberShipRsp;", "rsp", "", "W1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "spaceIdList", "P1", "Lqzone/qzoneUnifiedStore$MemberShip;", "Q1", "normalItem", "vipInfo", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "R1", "", "spaceType", "S1", "intimateType", "X1", "N1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "i", "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "normalListData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "U1", "()Ljava/util/List;", "setVipInfoListData", "(Ljava/util/List;)V", "vipInfoListData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "getResourceMap", "()Ljava/util/HashMap;", "setResourceMap", "(Ljava/util/HashMap;)V", "resourceMap", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class n extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<List<ij.i>>> normalListData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<QZIntimateSpaceVipInfoBean> vipInfoListData = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private HashMap<Integer, String> resourceMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(n this$0, List beanList, BaseRequest baseRequest, boolean z16, long j3, String errMsg, qzoneUnifiedStore$BatchGetMemberShipRsp qzoneunifiedstore_batchgetmembershiprsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(beanList, "$beanList");
        Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.W1(beanList, z16, j3, errMsg, qzoneunifiedstore_batchgetmembershiprsp);
    }

    private final qzoneUnifiedStore$BatchGetMemberShipRsp P1(ArrayList<String> spaceIdList) {
        qzoneUnifiedStore$BatchGetMemberShipRsp qzoneunifiedstore_batchgetmembershiprsp = new qzoneUnifiedStore$BatchGetMemberShipRsp();
        qzoneunifiedstore_batchgetmembershiprsp.member_ships.set(Q1(spaceIdList));
        return qzoneunifiedstore_batchgetmembershiprsp;
    }

    private final List<qzoneUnifiedStore$MemberShip> Q1(ArrayList<String> spaceIdList) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = spaceIdList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            qzoneUnifiedStore$MemberShip qzoneunifiedstore_membership = new qzoneUnifiedStore$MemberShip();
            qzoneunifiedstore_membership.space_id.set(next);
            qzoneunifiedstore_membership.member_status.set(0);
            arrayList.add(qzoneunifiedstore_membership);
        }
        return arrayList;
    }

    private final QZIntimateSpaceVipInfoBean R1(ij.i normalItem, qzoneUnifiedStore$MemberShip vipInfo) {
        QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean = new QZIntimateSpaceVipInfoBean();
        String str = vipInfo.space_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "vipInfo.space_id.get()");
        qZIntimateSpaceVipInfoBean.t(str);
        qZIntimateSpaceVipInfoBean.u(normalItem.getSpaceAbsData().space_type.get());
        qZIntimateSpaceVipInfoBean.p(S1(normalItem.getSpaceAbsData().space_type.get()));
        qZIntimateSpaceVipInfoBean.r(vipInfo.member_status.get());
        String str2 = vipInfo.member_code.get();
        Intrinsics.checkNotNullExpressionValue(str2, "vipInfo.member_code.get()");
        qZIntimateSpaceVipInfoBean.q(str2);
        qZIntimateSpaceVipInfoBean.l(vipInfo.expiration_time.get());
        qZIntimateSpaceVipInfoBean.s(vipInfo.remain_signing.get());
        return qZIntimateSpaceVipInfoBean;
    }

    private final String S1(int spaceType) {
        String X1 = X1(spaceType);
        if (TextUtils.isEmpty(X1)) {
            return "";
        }
        QLog.i("QZIntimateManageVipInfoViewModel", 1, "space type is " + spaceType + ", setting is " + X1);
        Intrinsics.checkNotNull(X1);
        try {
            String string = new JSONObject(X1).getJSONObject("avatar").getString("manage_avatar");
            Intrinsics.checkNotNullExpressionValue(string, "{\n            jsonObject\u2026_MANAGE_AVATAR)\n        }");
            return string;
        } catch (Exception e16) {
            QLog.e("QZIntimateManageVipInfoViewModel", 1, "exception is " + e16);
            return "";
        }
    }

    public final void N1(final List<ij.i> beanList) {
        Intrinsics.checkNotNullParameter(beanList, "beanList");
        if (ArrayUtils.isOutOfArrayIndex(0, beanList)) {
            QLog.e("QZIntimateManageVipInfoViewModel", 1, "bean list is empty");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<T> it = beanList.iterator();
        while (it.hasNext()) {
            arrayList.add(((ij.i) it.next()).getSpaceAbsData().space_id.get());
        }
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            QLog.e("QZIntimateManageVipInfoViewModel", 1, "space id list is empty");
        } else if (gd.a.f401926a.c("KEY_MANAGE_PAGE_VIP", false)) {
            W1(beanList, true, 0L, "", P1(arrayList));
        } else {
            sendRequest(new QZIntimateBatchGetVipInfoRequest(arrayList), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.m
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    n.O1(n.this, beanList, baseRequest, z16, j3, str, (qzoneUnifiedStore$BatchGetMemberShipRsp) obj);
                }
            });
        }
    }

    public final MutableLiveData<UIStateData<List<ij.i>>> T1() {
        return this.normalListData;
    }

    public final List<QZIntimateSpaceVipInfoBean> U1() {
        return this.vipInfoListData;
    }

    public final String X1(int intimateType) {
        String trimIndent;
        int a16 = mk.d.f416875a.a(intimateType);
        if (this.resourceMap.containsKey(Integer.valueOf(a16))) {
            return this.resourceMap.get(Integer.valueOf(a16));
        }
        trimIndent = StringsKt__IndentKt.trimIndent(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_intimate_space_main_page_style_" + a16, ""));
        try {
            String jSONObject = new JSONObject(trimIndent).getJSONObject("vip").toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(styleSetting)\u2026ject(JSON_VIP).toString()");
            this.resourceMap.put(Integer.valueOf(intimateType), jSONObject);
            return jSONObject;
        } catch (Exception e16) {
            QLog.e("QZIntimateManageVipInfoViewModel", 1, "exception is " + e16);
            return "";
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZIntimateManageVipInfoViewModel";
    }

    private final void W1(List<ij.i> beanList, boolean isSuccess, long retCode, String errMsg, qzoneUnifiedStore$BatchGetMemberShipRsp rsp) {
        if (isSuccess && rsp != null && retCode == 0) {
            List<qzoneUnifiedStore$MemberShip> list = rsp.member_ships.get();
            this.vipInfoListData.clear();
            if (ArrayUtils.isOutOfArrayIndex(0, list) || ArrayUtils.isOutOfArrayIndex(0, beanList)) {
                return;
            }
            for (ij.i iVar : beanList) {
                Iterator<qzoneUnifiedStore$MemberShip> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        qzoneUnifiedStore$MemberShip vipInfo = it.next();
                        if (TextUtils.equals(iVar.getSpaceAbsData().space_id.get(), vipInfo.space_id.get()) && vipInfo.member_status.get() == 0) {
                            Intrinsics.checkNotNullExpressionValue(vipInfo, "vipInfo");
                            iVar.k(R1(iVar, vipInfo));
                            List<QZIntimateSpaceVipInfoBean> list2 = this.vipInfoListData;
                            QZIntimateSpaceVipInfoBean vipInfoBean = iVar.getVipInfoBean();
                            Intrinsics.checkNotNull(vipInfoBean);
                            list2.add(vipInfoBean);
                            break;
                        }
                    }
                }
            }
            this.normalListData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(false, beanList));
            return;
        }
        QLog.e("QZIntimateManageVipInfoViewModel", 1, "handleBatchQueryVipRsp rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }
}
