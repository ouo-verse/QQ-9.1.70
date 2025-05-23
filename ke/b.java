package ke;

import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMediaKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMediaLayerRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0004J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0004J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ \u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\"\u0010*\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00106\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010:\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\"\u0010>\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R\"\u0010B\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u0016\"\u0004\bA\u0010\u0018R\"\u0010F\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R$\u0010M\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010]\u001a\u00020V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006`"}, d2 = {"Lke/b;", "Lq9/a;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerListBean;", "Lge/g;", "requestBean", "", "d2", "layerBean", "o2", "", "b2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMediaLayerRsp;", "rsp", "c2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "Q1", "layerListBean", "O1", "", "D", "Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Ljava/lang/String;", "k2", "(Ljava/lang/String;)V", "routeContextHashCode", "", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "E", "Ljava/util/List;", "S1", "()Ljava/util/List;", SemanticAttributes.DbSystemValues.H2, "(Ljava/util/List;)V", "initExtraInfoList", UserInfo.SEX_FEMALE, "T1", "setLeftAttachInfo", "leftAttachInfo", "G", "Z1", "setRightAttachInfo", "rightAttachInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "H", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "P1", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "e2", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "commonFeed", "I", "R1", "g2", "forwardFeed", "J", "getFeedId", "f2", "feedId", "K", "getUfKey", "l2", "ufKey", "L", "getUgcId", "m2", "ugcId", "M", "U1", "i2", "likeKey", "N", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "getUnionId", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", ICustomDataEditor.NUMBER_PARAM_2, "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "P", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "X1", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "j2", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;)V", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "W1", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "setMediaLayerManager", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;)V", "mediaLayerManager", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class b extends q9.a<QzoneFeedProLayerListBean> {

    /* renamed from: E, reason: from kotlin metadata */
    private List<QzoneFeedProLayerExtraInfoBean> initExtraInfoList;

    /* renamed from: H, reason: from kotlin metadata */
    private CommonFeed commonFeed;

    /* renamed from: I, reason: from kotlin metadata */
    private CommonFeed forwardFeed;

    /* renamed from: N, reason: from kotlin metadata */
    private CommonUnionID unionId;

    /* renamed from: P, reason: from kotlin metadata */
    private CommonUser owner;

    /* renamed from: D, reason: from kotlin metadata */
    private String routeContextHashCode = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String leftAttachInfo = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: J, reason: from kotlin metadata */
    private String feedId = "";

    /* renamed from: K, reason: from kotlin metadata */
    private String ufKey = "";

    /* renamed from: L, reason: from kotlin metadata */
    private String ugcId = "";

    /* renamed from: M, reason: from kotlin metadata */
    private String likeKey = "";

    /* renamed from: Q, reason: from kotlin metadata */
    private QzoneMediaLayerManager mediaLayerManager = new QzoneMediaLayerManager();

    protected void O1(GetMediaLayerRsp rsp, QzoneFeedProLayerListBean layerListBean, ge.g requestBean) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
    }

    /* renamed from: P1, reason: from getter */
    public final CommonFeed getCommonFeed() {
        return this.commonFeed;
    }

    public final CommonUnionID Q1() {
        CommonCellCommon cellCommon;
        CommonFeed commonFeed = this.forwardFeed;
        if (commonFeed == null) {
            commonFeed = this.commonFeed;
        }
        if (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) {
            return null;
        }
        return cellCommon.getUnionId();
    }

    /* renamed from: R1, reason: from getter */
    public final CommonFeed getForwardFeed() {
        return this.forwardFeed;
    }

    public final List<QzoneFeedProLayerExtraInfoBean> S1() {
        return this.initExtraInfoList;
    }

    /* renamed from: T1, reason: from getter */
    public final String getLeftAttachInfo() {
        return this.leftAttachInfo;
    }

    /* renamed from: U1, reason: from getter */
    public final String getLikeKey() {
        return this.likeKey;
    }

    /* renamed from: W1, reason: from getter */
    public final QzoneMediaLayerManager getMediaLayerManager() {
        return this.mediaLayerManager;
    }

    /* renamed from: X1, reason: from getter */
    public final CommonUser getOwner() {
        return this.owner;
    }

    /* renamed from: Z1, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    /* renamed from: a2, reason: from getter */
    public final String getRouteContextHashCode() {
        return this.routeContextHashCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b2(ge.g layerBean) {
        Intrinsics.checkNotNullParameter(layerBean, "layerBean");
        if (layerBean.getIsRefresh()) {
            return 0;
        }
        return layerBean.getIsFetchRight() ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c2(GetMediaLayerRsp rsp, ge.g requestBean) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        getLoadInfo().setCurrentState(4);
        QzoneFeedProLayerListBean qzoneFeedProLayerListBean = new QzoneFeedProLayerListBean();
        if (requestBean.getIsFetchRight()) {
            this.rightAttachInfo = rsp.attachInfo;
            qzoneFeedProLayerListBean.h0(!rsp.nextHasMore);
        }
        if (requestBean.getIsFetchLeft()) {
            this.leftAttachInfo = rsp.attachInfo;
            qzoneFeedProLayerListBean.e0(!rsp.prevHasMore);
        }
        qzoneFeedProLayerListBean.g0(requestBean.getIsRefresh());
        qzoneFeedProLayerListBean.b0(requestBean.getIsFetchLeft());
        qzoneFeedProLayerListBean.c0(requestBean.getIsFetchRight());
        QLog.i("QZoneBaseLayerViewModel", 1, "rsp cur index is " + rsp.curIndex);
        int i3 = rsp.curIndex;
        if (i3 > 0) {
            i3--;
        }
        qzoneFeedProLayerListBean.d0(i3);
        List<StMedia> list = rsp.mediaList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonMediaKt.toCommon((StMedia) it.next()));
        }
        qzoneFeedProLayerListBean.o(je.a.q(rsp.mediaList, rsp.album));
        O1(rsp, qzoneFeedProLayerListBean, requestBean);
        if (ArrayUtils.isOutOfArrayIndex(0, qzoneFeedProLayerListBean.g())) {
            M1().postValue(UIStateData.obtainEmpty());
        } else {
            M1().postValue(UIStateData.obtainSuccess(false).setDataList(qzoneFeedProLayerListBean));
        }
    }

    public abstract void d2(ge.g requestBean);

    public final void e2(CommonFeed commonFeed) {
        this.commonFeed = commonFeed;
    }

    public final void f2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void g2(CommonFeed commonFeed) {
        this.forwardFeed = commonFeed;
    }

    public final void h2(List<QzoneFeedProLayerExtraInfoBean> list) {
        this.initExtraInfoList = list;
    }

    public final void i2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.likeKey = str;
    }

    public final void j2(CommonUser commonUser) {
        this.owner = commonUser;
    }

    public final void k2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.routeContextHashCode = str;
    }

    public final void l2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ufKey = str;
    }

    public final void m2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ugcId = str;
    }

    public final void n2(CommonUnionID commonUnionID) {
        this.unionId = commonUnionID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o2(ge.g layerBean) {
        Intrinsics.checkNotNullParameter(layerBean, "layerBean");
        if (layerBean.getIsRefresh()) {
            getLoadInfo().setCurrentState(2);
        } else if (layerBean.getIsFetchRight()) {
            getLoadInfo().setCurrentState(0);
        } else {
            getLoadInfo().setCurrentState(1);
        }
    }
}
