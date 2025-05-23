package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean;
import com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager;
import com.qzone.reborn.groupalbum.viewmodel.z;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\b*\u0001D\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J6\u0010\u0012\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\u0004J\u001a\u0010!\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\bJ\u001a\u0010\"\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\bR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\r0-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R4\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f02018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/z;", "Lcom/qzone/reborn/base/n;", "", "requestSuccess", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "errorCode", "", "errorMsg", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "g2", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "list", "retCode", "errMsg", "isFinish", SemanticAttributes.DbSystemValues.H2, "L1", "getLogTag", "Landroid/content/Intent;", "intent", "X1", "Z1", "e2", "feedId", "b2", "feedData", "f2", "i2", "groupId", "clientKey", "T1", "W1", "", "i", "I", "mCheckFakeFeedTimes", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "c2", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mAllFeeds", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "D", "Landroidx/lifecycle/MutableLiveData;", "d2", "()Landroidx/lifecycle/MutableLiveData;", "setMFeedsData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFeedsData", "Lki/aa;", "E", "Lki/aa;", "mFeedsDataRepo", UserInfo.SEX_FEMALE, "J", "startPageTimeMs", "G", "Z", "hasReport", "com/qzone/reborn/groupalbum/viewmodel/z$e", "H", "Lcom/qzone/reborn/groupalbum/viewmodel/z$e;", "mPublishListener", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class z extends com.qzone.reborn.base.n {

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasReport;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCheckFakeFeedTimes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: C, reason: from kotlin metadata */
    private List<BusinessFeedData> mAllFeeds = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<BusinessFeedData>>> mFeedsData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private ki.aa mFeedsDataRepo = new ki.aa();

    /* renamed from: F, reason: from kotlin metadata */
    private long startPageTimeMs = -1;

    /* renamed from: H, reason: from kotlin metadata */
    private final e mPublishListener = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/z$c", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<List<? extends BusinessFeedData>> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            z.this.a2(true);
            z.this.h2(list, false, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            z.this.a2(false);
            z.this.g2(errorCode, errorMsg, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/z$d", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements n.a<List<? extends BusinessFeedData>> {
        d() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            z.this.h2(list, true, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            z.this.g2(errorCode, errorMsg, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/z$e", "Lsm/i;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "i7", "", "clientKey", "Lcom/qzone/publish/business/publishqueue/common/g;", "videoStatusInfo", "z5", "v1", "I4", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements sm.i {
        e() {
        }

        @Override // sm.i
        public void I4(BusinessFeedData data) {
            Object obj;
            Intrinsics.checkNotNullParameter(data, "data");
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "onPublishSucceed ");
            Iterator it = z.this.mAllFeeds.iterator();
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
                z.this.mAllFeeds.remove(businessFeedData);
                Iterator it5 = z.this.mAllFeeds.iterator();
                int i3 = -1;
                int i16 = 0;
                while (it5.hasNext()) {
                    int i17 = i16 + 1;
                    if (((BusinessFeedData) it5.next()).isFakeFeed()) {
                        i3 = i16;
                    }
                    i16 = i17;
                }
                RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "onPublishSucceed findItem, mFakeFeedIndex:" + i3);
                z.this.mAllFeeds.add(i3 + 1, data);
                z.this.i2();
                return;
            }
            RFWLog.e("GroupAlbumFeedViewModel", RFWLog.USR, "onPublishSucceed not find onFeedList");
        }

        @Override // sm.i
        public void i7(BusinessFeedData data) {
            Object obj;
            Intrinsics.checkNotNullParameter(data, "data");
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "onAddFakeFeed " + data.getFeedCommInfo().clientkey);
            Iterator it = z.this.mAllFeeds.iterator();
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
                RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "onAddFakeFeed fake feed have on list");
            } else {
                z.this.mAllFeeds.add(0, data);
                z.this.i2();
            }
        }

        @Override // sm.i
        public void v1(String clientKey) {
            Object obj;
            Intrinsics.checkNotNullParameter(clientKey, "clientKey");
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "onDeleteFakeFeed " + clientKey);
            Iterator it = z.this.mAllFeeds.iterator();
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
                z zVar = z.this;
                RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "onDeleteFakeFeed " + clientKey + " findItem");
                zVar.f2(businessFeedData2);
            }
        }

        @Override // sm.i
        public void z5(String clientKey, CommonPublishVideoStatusInfo videoStatusInfo) {
            Intrinsics.checkNotNullParameter(clientKey, "clientKey");
            Intrinsics.checkNotNullParameter(videoStatusInfo, "videoStatusInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(z this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W1(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(boolean requestSuccess) {
        if (this.hasReport) {
            return;
        }
        this.hasReport = true;
        if (requestSuccess) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() - this.startPageTimeMs;
            linkedHashMap.put("view_load_time", Long.valueOf(currentTimeMillis));
            linkedHashMap.put("view_type", 0);
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "[doInit] doReportGroupAlbumFeedFirstFrameEvent:" + currentTimeMillis);
            fo.c.c("ev_qun_album_view_load_time", linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(long errorCode, String errorMsg, boolean isLoadMore) {
        this.mFeedsData.postValue(UIStateData.obtainError(errorMsg).setRetCode(errorCode).setLoadMore(isLoadMore));
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        super.L1();
        fj.n.f399459a.E(this.groupId, this.mPublishListener);
    }

    public final void T1(final String groupId, final String clientKey) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.y
            @Override // java.lang.Runnable
            public final void run() {
                z.U1(z.this, groupId, clientKey);
            }
        }, 2000L);
    }

    public final void W1(String groupId, String clientKey) {
        boolean z16 = true;
        RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "checkFeedPublishSuccess, groupId: " + groupId + ", clientKey: " + clientKey);
        if (groupId == null || groupId.length() == 0) {
            return;
        }
        if (clientKey != null && clientKey.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList = fj.n.f399459a.v().get(groupId);
        Object obj = null;
        if (copyOnWriteArrayList != null) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((BusinessFeedData) next).getFeedCommInfo().clientkey, clientKey)) {
                    obj = next;
                    break;
                }
            }
            obj = (BusinessFeedData) obj;
        }
        if (obj == null) {
            this.mCheckFakeFeedTimes = 0;
        } else {
            this.mFeedsDataRepo.m(this.contextHashCode, this.groupId, new b(clientKey, groupId));
        }
    }

    public final void X1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            if (serializable instanceof GroupAlbumInitBean) {
                this.groupId = ((GroupAlbumInitBean) serializable).getGroupId();
            }
            if (serializable instanceof GroupAlbumMainPageInitBean) {
                this.startPageTimeMs = ((GroupAlbumMainPageInitBean) serializable).getStartTimeMs();
            }
        }
        RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "[doInit] groupId:" + this.groupId);
        fj.n.f399459a.l(this.groupId, this.mPublishListener);
    }

    public final void Z1() {
        this.mFeedsDataRepo.m(this.contextHashCode, this.groupId, new c());
    }

    /* renamed from: c2, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final MutableLiveData<UIStateData<List<BusinessFeedData>>> d2() {
        return this.mFeedsData;
    }

    public final void e2() {
        this.mFeedsDataRepo.k(this.contextHashCode, this.groupId, new d());
    }

    public final void f2(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        this.mAllFeeds.remove(feedData);
        i2();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumFeedViewModel";
    }

    public final void i2() {
        RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "refreshAdapter");
        UIStateData<List<BusinessFeedData>> value = this.mFeedsData.getValue();
        if (value != null) {
            if (value.getState() == 0 && this.mAllFeeds.size() > 0) {
                RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "refreshAdapter set to succeed");
                value.setState(2);
            } else if (this.mAllFeeds.isEmpty()) {
                RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "refreshAdapter set to empty");
                value.setState(0);
            }
            value.setDataList(this.mAllFeeds);
            this.mFeedsData.postValue(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(List<? extends BusinessFeedData> list, boolean isLoadMore, long retCode, String errMsg, boolean isFinish) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (!isLoadMore) {
            this.mAllFeeds.clear();
        }
        int size = this.mAllFeeds.size();
        ArrayList arrayList = new ArrayList();
        if (!isLoadMore) {
            fj.n nVar = fj.n.f399459a;
            nVar.n(list);
            CopyOnWriteArrayList<BusinessFeedData> r16 = nVar.r(this.groupId);
            GroupAlbumReshipSendBoxManager.f56848a.w(this.groupId);
            arrayList.addAll(r16);
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "[onRequestSuccess] add fake feed list:" + r16.size());
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

    public final BusinessFeedData b2(String feedId) {
        Object obj = null;
        if (feedId == null || feedId.length() == 0) {
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "getFeedDataById error, feed id is empty");
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/z$b", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "realFeeds", "", "retCode", "", "msg", "", "isFinish", "", "b", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<List<? extends BusinessFeedData>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f57139b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f57140c;

        b(String str, String str2) {
            this.f57139b = str;
            this.f57140c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(z this$0, String str, String str2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.W1(str, str2);
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> realFeeds, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(realFeeds, "realFeeds");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            String str = this.f57139b;
            String str2 = this.f57140c;
            z zVar = z.this;
            for (BusinessFeedData businessFeedData : realFeeds) {
                if (Intrinsics.areEqual(str, businessFeedData.getFeedCommInfo().clientkey)) {
                    fj.n.f399459a.J(str2, businessFeedData);
                    zVar.mCheckFakeFeedTimes = 0;
                    return;
                }
            }
            if (z.this.mCheckFakeFeedTimes >= 5) {
                z.this.mCheckFakeFeedTimes = 0;
                return;
            }
            z.this.mCheckFakeFeedTimes++;
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final z zVar2 = z.this;
            final String str3 = this.f57140c;
            final String str4 = this.f57139b;
            rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.aa
                @Override // java.lang.Runnable
                public final void run() {
                    z.b.c(z.this, str3, str4);
                }
            }, 2000L);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
        }
    }
}
