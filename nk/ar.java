package nk;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSpaceInitRequestBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0001W\b\u0016\u0018\u0000 ]2\u00020\u0001:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J6\u0010\u000f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0006R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R4\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0)0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lnk/ar;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "Z1", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "list", "", "retCode", "errMsg", "isFinish", ICustomDataEditor.STRING_ARRAY_PARAM_2, "L1", "getLogTag", "Landroid/content/Intent;", "intent", "P1", "spaceId", "d2", "Q1", "W1", "feedId", "R1", "feedData", "X1", "b2", "i", "Ljava/lang/String;", "U1", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mAllFeeds", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "setMFeedsData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFeedsData", "Lbk/j;", "D", "Lbk/j;", "getMFeedsDataRepo", "()Lbk/j;", "setMFeedsDataRepo", "(Lbk/j;)V", "mFeedsDataRepo", "E", "Z", "isDraft", "()Z", "setDraft", "(Z)V", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "S1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "setInitBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;)V", "initBean", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "G", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "getActivateSpaceBean", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "setActivateSpaceBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;)V", "activateSpaceBean", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "H", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "getVipInfoBean", "()Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "c2", "(Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;)V", "vipInfoBean", "nk/ar$d", "I", "Lnk/ar$d;", "mPublishListener", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class ar extends com.qzone.reborn.base.n {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDraft;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneIntimateMainPageInitBean initBean;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneIntimateActivateSpaceBean activateSpaceBean;

    /* renamed from: H, reason: from kotlin metadata */
    private QZIntimateSpaceVipInfoBean vipInfoBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<BusinessFeedData> mAllFeeds = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<BusinessFeedData>>> mFeedsData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private bk.j mFeedsDataRepo = new bk.j();

    /* renamed from: I, reason: from kotlin metadata */
    private final d mPublishListener = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"nk/ar$b", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<List<? extends BusinessFeedData>> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ar.this.a2(list, false, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ar.this.Z1(errorMsg, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"nk/ar$c", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements n.a<List<? extends BusinessFeedData>> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ar.this.a2(list, true, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ar.this.Z1(errorMsg, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"nk/ar$d", "Lsm/i;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "i7", "", "clientKey", "Lcom/qzone/publish/business/publishqueue/common/g;", "videoStatusInfo", "z5", "v1", "I4", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements sm.i {
        d() {
        }

        @Override // sm.i
        public void I4(BusinessFeedData data) {
            Object obj;
            Intrinsics.checkNotNullParameter(data, "data");
            RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "onPublishSucceed ");
            Iterator it = ar.this.mAllFeeds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((BusinessFeedData) obj).getFeedCommInfo().clientkey, data.getFeedCommInfo().clientkey)) {
                        break;
                    }
                }
            }
            BusinessFeedData businessFeedData = (BusinessFeedData) obj;
            if (businessFeedData != null) {
                ar.this.mAllFeeds.remove(businessFeedData);
                Iterator it5 = ar.this.mAllFeeds.iterator();
                int i3 = -1;
                int i16 = 0;
                while (it5.hasNext()) {
                    int i17 = i16 + 1;
                    if (((BusinessFeedData) it5.next()).isFakeFeed()) {
                        i3 = i16;
                    }
                    i16 = i17;
                }
                RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "onPublishSucceed findItem, mFakeFeedIndex:" + i3);
                ar.this.mAllFeeds.add(i3 + 1, data);
                ar.this.b2();
                return;
            }
            RFWLog.e("QZoneIntimateFeedViewModel", RFWLog.USR, "onPublishSucceed not find onFeedList");
        }

        @Override // sm.i
        public void i7(BusinessFeedData data) {
            Object obj;
            Intrinsics.checkNotNullParameter(data, "data");
            RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "onAddFakeFeed " + data.getFeedCommInfo().clientkey);
            Iterator it = ar.this.mAllFeeds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                BusinessFeedData businessFeedData = (BusinessFeedData) obj;
                if (Intrinsics.areEqual(businessFeedData.getFeedCommInfo().clientkey, data.getFeedCommInfo().clientkey) && businessFeedData.isFakeFeed()) {
                    break;
                }
            }
            if (((BusinessFeedData) obj) != null) {
                RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "onAddFakeFeed fake feed have on list");
            } else {
                ar.this.mAllFeeds.add(0, data);
                ar.this.b2();
            }
        }

        @Override // sm.i
        public void v1(String clientKey) {
            Object obj;
            Intrinsics.checkNotNullParameter(clientKey, "clientKey");
            RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "onDeleteFakeFeed " + clientKey);
            Iterator it = ar.this.mAllFeeds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                BusinessFeedData businessFeedData = (BusinessFeedData) obj;
                if (Intrinsics.areEqual(businessFeedData.getFeedCommInfo().clientkey, clientKey) && businessFeedData.isFakeFeed()) {
                    break;
                }
            }
            BusinessFeedData businessFeedData2 = (BusinessFeedData) obj;
            if (businessFeedData2 != null) {
                ar arVar = ar.this;
                RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "onDeleteFakeFeed " + clientKey + " findItem");
                arVar.X1(businessFeedData2);
            }
        }

        @Override // sm.i
        public void z5(String clientKey, CommonPublishVideoStatusInfo videoStatusInfo) {
            Intrinsics.checkNotNullParameter(clientKey, "clientKey");
            Intrinsics.checkNotNullParameter(videoStatusInfo, "videoStatusInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(String errorMsg, boolean isLoadMore) {
        this.mFeedsData.postValue(UIStateData.obtainError(errorMsg).setRetCode(0L).setLoadMore(isLoadMore));
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        super.L1();
        sm.h.f433971a.x(this.spaceId, this.mPublishListener);
    }

    public final void P1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
            QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = (QZoneIntimateMainPageInitBean) serializable;
            this.initBean = qZoneIntimateMainPageInitBean;
            if (qZoneIntimateMainPageInitBean != null) {
                Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean);
                this.spaceId = qZoneIntimateMainPageInitBean.getSpaceId();
                QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean2 = this.initBean;
                Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean2);
                this.isDraft = qZoneIntimateMainPageInitBean2.getIsDraft();
                QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean3 = this.initBean;
                Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean3);
                this.activateSpaceBean = qZoneIntimateMainPageInitBean3.getActivateSpaceBean();
            }
        }
        RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "[doInit] spaceId:" + this.spaceId);
        sm.h.f433971a.i(this.spaceId, this.mPublishListener);
    }

    public final void Q1() {
        if (this.spaceId.length() > 0) {
            RFWLog.i("QZoneIntimateFeedViewModel", RFWLog.USR, "space id is " + this.spaceId);
            this.isDraft = false;
        }
        this.mFeedsDataRepo.g(this.contextHashCode, new QZoneIntimateSpaceInitRequestBean(this.spaceId, this.isDraft, this.activateSpaceBean), new b());
    }

    /* renamed from: S1, reason: from getter */
    public final QZoneIntimateMainPageInitBean getInitBean() {
        return this.initBean;
    }

    public final MutableLiveData<UIStateData<List<BusinessFeedData>>> T1() {
        return this.mFeedsData;
    }

    /* renamed from: U1, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    public final void W1() {
        if (this.initBean == null) {
            RFWLog.e("QZoneIntimateFeedViewModel", 1, "initBean is null");
        } else {
            this.mFeedsDataRepo.e(this.contextHashCode, new QZoneIntimateSpaceInitRequestBean(this.spaceId, this.isDraft, this.activateSpaceBean), new c());
        }
    }

    public final void X1(BusinessFeedData feedData) {
        Object obj;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Iterator<T> it = this.mAllFeeds.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(feedData.getIdInfo().cellId, ((BusinessFeedData) obj).getIdInfo().cellId)) {
                    break;
                }
            }
        }
        TypeIntrinsics.asMutableCollection(this.mAllFeeds).remove((BusinessFeedData) obj);
        b2();
    }

    public final void b2() {
        RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "refreshAdapter");
        UIStateData<List<BusinessFeedData>> value = this.mFeedsData.getValue();
        if (value != null) {
            if (value.getState() == 0 && this.mAllFeeds.size() > 0) {
                RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "refreshAdapter set to succeed");
                value.setState(2);
            } else if (this.mAllFeeds.isEmpty()) {
                RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "refreshAdapter set to empty");
                value.setState(0);
            }
            value.setDataList(this.mAllFeeds);
        }
        this.mFeedsData.postValue(value);
    }

    public final void c2(QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean) {
        this.vipInfoBean = qZIntimateSpaceVipInfoBean;
    }

    public final void d2(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        sm.h hVar = sm.h.f433971a;
        hVar.x(this.spaceId, this.mPublishListener);
        this.spaceId = spaceId;
        this.isDraft = false;
        hVar.i(spaceId, this.mPublishListener);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateFeedViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(List<? extends BusinessFeedData> list, boolean isLoadMore, long retCode, String errMsg, boolean isFinish) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (!isLoadMore) {
            this.mAllFeeds.clear();
        }
        int size = this.mAllFeeds.size();
        ArrayList arrayList = new ArrayList();
        if (!isLoadMore) {
            sm.h hVar = sm.h.f433971a;
            hVar.k(list);
            CopyOnWriteArrayList<BusinessFeedData> n3 = hVar.n(this.spaceId);
            arrayList.addAll(n3);
            RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "[onRequestSuccess] add fake feed list:" + n3.size());
        }
        arrayList.addAll(list);
        this.mAllFeeds.addAll(arrayList);
        if (bl.b(this.mAllFeeds)) {
            this.mFeedsData.postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore));
            return;
        }
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        this.mFeedsData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.mAllFeeds).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(isFinish));
    }

    public final BusinessFeedData R1(String feedId) {
        Object obj = null;
        if (feedId == null || feedId.length() == 0) {
            RFWLog.d("QZoneIntimateFeedViewModel", RFWLog.USR, "getFeedDataById error, feed id is empty");
            return null;
        }
        Iterator<T> it = this.mAllFeeds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((BusinessFeedData) next).getFeedCommInfo().feedsid, feedId)) {
                obj = next;
                break;
            }
        }
        return (BusinessFeedData) obj;
    }
}
