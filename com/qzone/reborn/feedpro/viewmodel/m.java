package com.qzone.reborn.feedpro.viewmodel;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ProfileTimeLine;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.QzoneMainPageInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SealOffMemory;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SpecialInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.UserProfile;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.RemoveSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\t*\u0001h\u0018\u0000 n2\u00020\u0001:\u0001oB\u0007\u00a2\u0006\u0004\bl\u0010mJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u001e\u0010 \u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\u0002J\b\u0010&\u001a\u00020\u0002H\u0016J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0004J\u0014\u00100\u001a\u00020\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-J\u0014\u00102\u001a\u00020\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u0002010-J\u0006\u00103\u001a\u00020\u0004J\b\u00104\u001a\u00020\u0002H\u0014R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00106R\u0016\u0010F\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER0\u0010N\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010\u001e0\u001e0G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020O0G8\u0006\u00a2\u0006\f\n\u0004\bP\u0010I\u001a\u0004\bQ\u0010KR\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020S0G8\u0006\u00a2\u0006\f\n\u0004\bT\u0010I\u001a\u0004\bU\u0010KR(\u0010[\u001a\b\u0012\u0004\u0012\u00020W0G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010I\u001a\u0004\bY\u0010K\"\u0004\bZ\u0010MR(\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001e0G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010I\u001a\u0004\b]\u0010K\"\u0004\b^\u0010MR(\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010I\u001a\u0004\ba\u0010K\"\u0004\bb\u0010MR(\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00040G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010I\u001a\u0004\be\u0010K\"\u0004\bf\u0010MR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010j\u00a8\u0006p"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/m;", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "", "c2", "", "hasMore", "v2", "", "z2", NowProxyConstants.AccountInfoKey.A2, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "data", "", "action", "l2", "x2", ICustomDataEditor.NUMBER_PARAM_2, "getLogTag", "Landroid/content/Intent;", "intent", "y2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMainPageFeedManager;", "k2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "b2", "C2", ICustomDataEditor.STRING_PARAM_2, "t2", "feedList", "", "loadType", "u2", "timeMillis", "w2", "F2", Constants.MMCCID, "B2", "R1", "j2", "f2", "m2", "r2", "isSpecialCare", "H2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/SetSpecialRsp;", "callback", "E2", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/RemoveSpecialRsp;", Constants.BASE_IN_PLUGIN_VERSION, "q2", "onCleared", "D", "J", "clickTimeLineTime", "E", "Z", "isTimeLineClick", "Lcom/qzone/reborn/route/QZoneUserHomeBean;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/route/QZoneUserHomeBean;", "initBean", "G", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMainPageFeedManager;", "userHomeManager", "H", "hostUin", "I", "Ljava/lang/String;", "hostNickname", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", "e2", "()Landroidx/lifecycle/MutableLiveData;", "setHeaderState", "(Landroidx/lifecycle/MutableLiveData;)V", "headerState", "Lcom/qzone/proxy/feedcomponent/model/ProfileTimeLine;", "K", SemanticAttributes.DbSystemValues.H2, "timeLineData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "L", "g2", "sealOffMemory", "Lwd/h;", "M", "d2", "setHeadInfo", "headInfo", "N", "i2", "setTotalNumber", "totalNumber", "P", "p2", "setShowForbidden", "isShowForbidden", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "o2", "setShowError", "isShowError", "com/qzone/reborn/feedpro/viewmodel/m$d", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/feedpro/viewmodel/m$d;", "feedUpdateCallback", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends com.qzone.reborn.feedpro.viewmodel.c {

    /* renamed from: D, reason: from kotlin metadata */
    private long clickTimeLineTime;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isTimeLineClick;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneUserHomeBean initBean;

    /* renamed from: G, reason: from kotlin metadata */
    private QzoneMainPageFeedManager userHomeManager;

    /* renamed from: H, reason: from kotlin metadata */
    private long hostUin;

    /* renamed from: I, reason: from kotlin metadata */
    private String hostNickname = "";

    /* renamed from: J, reason: from kotlin metadata */
    private MutableLiveData<Integer> headerState = new MutableLiveData<>(1);

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<ProfileTimeLine> timeLineData = new MutableLiveData<>();

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<SealOffMemory> sealOffMemory = new MutableLiveData<>();

    /* renamed from: M, reason: from kotlin metadata */
    private MutableLiveData<wd.h> headInfo = new MutableLiveData<>();

    /* renamed from: N, reason: from kotlin metadata */
    private MutableLiveData<Integer> totalNumber = new MutableLiveData<>();

    /* renamed from: P, reason: from kotlin metadata */
    private MutableLiveData<Boolean> isShowForbidden = new MutableLiveData<>();

    /* renamed from: Q, reason: from kotlin metadata */
    private MutableLiveData<Boolean> isShowError = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: R, reason: from kotlin metadata */
    private d feedUpdateCallback = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/m$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMainPageInfo;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements DataCallback<QzoneMainPageInfo> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QzoneMainPageInfo rsp, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            m.this.o2().postValue(Boolean.FALSE);
            m.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            m.this.i2().postValue(Integer.valueOf(rsp.getTotalFeedsNum()));
            m.this.h2().postValue(ProfileTimeLine.createFromPb(rsp.getProfileTimeLine()));
            m.this.g2().postValue(rsp.getSealOffMemory());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            m.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            m.this.N1().postValue(UIStateData.obtainError(errorMsg));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/m$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements DataCallback<Integer> {
        c() {
        }

        public void a(int rsp, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            m.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.f());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            m.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.f());
            m.this.N1().postValue(UIStateData.obtainError(errorMsg));
            m.this.x2();
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public /* bridge */ /* synthetic */ void onSuccess(Integer num, long j3, String str, boolean z16) {
            a(num.intValue(), j3, str, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/m$d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "action", "", "index", "", "onDataUpdate", "", "list", "onListUpdate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements IQzoneFeedUpdateCallback {
        d() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onDataUpdate(CommonFeed commonFeed, String action, int index) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(action, "action");
            m.this.P1(commonFeed, action, index);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onListUpdate(List<CommonFeed> list, String action, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(action, "action");
            m.this.l2(list, action);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/m$e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "size", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements DataCallback<Integer> {
        e() {
        }

        public void a(int size, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            com.qzone.reborn.feedpro.viewmodel.b b16 = com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.b();
            b16.h(size);
            m.this.S1(b16);
            m.this.v2(!isFinish);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            m.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.b());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public /* bridge */ /* synthetic */ void onSuccess(Integer num, long j3, String str, boolean z16) {
            a(num.intValue(), j3, str, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/m$f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements DataCallback<GetMainPageHeadRsp> {
        f() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetMainPageHeadRsp rsp, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            m mVar = m.this;
            UserProfile userProfile = rsp.userProfile;
            if (userProfile == null || (str = userProfile.nick) == null) {
                str = "";
            }
            mVar.hostNickname = str;
            MutableLiveData<wd.h> d26 = m.this.d2();
            wd.h hVar = new wd.h();
            hVar.d(rsp);
            d26.postValue(hVar);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            wd.h value = m.this.d2().getValue();
            MutableLiveData<wd.h> d26 = m.this.d2();
            wd.h hVar = new wd.h();
            hVar.d(value != null ? value.getHeadRsp() : null);
            hVar.b(errorCode);
            if (errorMsg == null) {
                errorMsg = "";
            }
            hVar.c(errorMsg);
            d26.postValue(hVar);
        }
    }

    private final long A2() {
        CommonCellCommon cellCommon;
        List<CommonFeed> data;
        UIStateData<List<CommonFeed>> value = N1().getValue();
        CommonFeed commonFeed = null;
        if (value != null && (data = value.getData()) != null) {
            ListIterator<CommonFeed> listIterator = data.listIterator(data.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                CommonFeed previous = listIterator.previous();
                if (!CommonFeedExtKt.isMemorySealFeed(previous)) {
                    commonFeed = previous;
                    break;
                }
            }
            commonFeed = commonFeed;
        }
        return ef.d.n(Long.valueOf((commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? 0L : cellCommon.getTime()));
    }

    private final void c2() {
        QLog.d(getLogTag(), 1, "doTimeLineRefresh");
        S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.e());
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.refreshByTime(this.clickTimeLineTime, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(List<CommonFeed> data, String action) {
        switch (action.hashCode()) {
            case -1785516855:
                if (!action.equals(QzoneDataUpdateAction.UPDATE)) {
                    return;
                }
                u2(data, 1);
                return;
            case -89436402:
                if (!action.equals(QzoneDataUpdateAction.LOAD_MORE)) {
                    return;
                }
                break;
            case -44153180:
                if (!action.equals(QzoneDataUpdateAction.MEMORY_CACHE)) {
                    return;
                }
                u2(data, 1);
                return;
            case 1334775202:
                if (action.equals(QzoneDataUpdateAction.TIME_LINE_REFRESH)) {
                    x2();
                    u2(data, 1);
                    return;
                }
                return;
            case 1646497388:
                if (!action.equals(QzoneDataUpdateAction.TIME_LINE_LOAD_MORE_DOWN)) {
                    return;
                }
                break;
            case 1803427515:
                if (!action.equals("REFRESH")) {
                    return;
                }
                u2(data, 1);
                return;
            case 1995007717:
                if (action.equals(QzoneDataUpdateAction.TIME_LINE_LOAD_MORE_UP)) {
                    u2(data, 3);
                    return;
                }
                return;
            case 2012838315:
                if (!action.equals("DELETE")) {
                    return;
                }
                u2(data, 1);
                return;
            case 2078940443:
                if (action.equals(QzoneDataUpdateAction.INSERT_FAKE)) {
                    u2(data, 1);
                    return;
                }
                return;
            default:
                return;
        }
        u2(data, 2);
    }

    private final boolean n2() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(ef.d.m(Long.valueOf(this.clickTimeLineTime)));
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2() {
        if (n2()) {
            G2();
        } else {
            F2();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long z2() {
        CommonCellCommon cellCommon;
        List<CommonFeed> data;
        UIStateData<List<CommonFeed>> value = N1().getValue();
        CommonFeed commonFeed = null;
        if (value != null && (data = value.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!CommonFeedExtKt.isMemorySealFeed((CommonFeed) next)) {
                    commonFeed = next;
                    break;
                }
            }
            commonFeed = commonFeed;
        }
        return ef.d.n(Long.valueOf((commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? 0L : cellCommon.getTime()));
    }

    public final void C2() {
        QLog.d(getLogTag(), 1, "refreshMainPageHead");
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.fetchMainPageHead(new f());
        }
    }

    public final void D2(DataCallback<RemoveSpecialRsp> callback) {
        List<CommonUser> listOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(String.valueOf(this.hostUin));
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(commonUser);
            qzoneMainPageFeedManager.removeSpecialCare(listOf, callback);
        }
    }

    public final void E2(DataCallback<SetSpecialRsp> callback) {
        List<CommonUser> listOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(String.valueOf(this.hostUin));
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(commonUser);
            qzoneMainPageFeedManager.setSpecialCare(listOf, callback);
        }
    }

    public final void F2() {
        Integer value = this.headerState.getValue();
        if (value != null && value.intValue() == 2) {
            return;
        }
        this.headerState.postValue(2);
    }

    public final void G2() {
        Integer value = this.headerState.getValue();
        if (value != null && value.intValue() == 1) {
            return;
        }
        this.headerState.postValue(1);
    }

    public final void H2(boolean isSpecialCare) {
        wd.h value = this.headInfo.getValue();
        if (value != null) {
            GetMainPageHeadRsp headRsp = value.getHeadRsp();
            SpecialInfo specialInfo = headRsp != null ? headRsp.specialInfo : null;
            if (specialInfo != null) {
                specialInfo.isSpecial = isSpecialCare;
            }
            this.headInfo.postValue(value);
        }
    }

    @Override // com.qzone.reborn.feedpro.viewmodel.c
    public void R1() {
        QzoneMainPageFeedManager qzoneMainPageFeedManager;
        d dVar = this.feedUpdateCallback;
        if (dVar == null || (qzoneMainPageFeedManager = this.userHomeManager) == null) {
            return;
        }
        qzoneMainPageFeedManager.unregisterFeedUpdateCallback(dVar);
    }

    public final void a2() {
        QLog.d(getLogTag(), 1, "checkRefreshData");
        if (this.isTimeLineClick) {
            c2();
        } else {
            C2();
            b2();
        }
    }

    public final void b2() {
        QLog.d(getLogTag(), 1, "doRefresh");
        S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.c());
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.refresh(new b());
        }
    }

    public final MutableLiveData<wd.h> d2() {
        return this.headInfo;
    }

    public final MutableLiveData<Integer> e2() {
        return this.headerState;
    }

    /* renamed from: f2, reason: from getter */
    public final String getHostNickname() {
        return this.hostNickname;
    }

    public final MutableLiveData<SealOffMemory> g2() {
        return this.sealOffMemory;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QzoneFeedProUserHomeViewModel";
    }

    public final MutableLiveData<ProfileTimeLine> h2() {
        return this.timeLineData;
    }

    public final MutableLiveData<Integer> i2() {
        return this.totalNumber;
    }

    /* renamed from: j2, reason: from getter */
    public final long getHostUin() {
        return this.hostUin;
    }

    /* renamed from: k2, reason: from getter */
    public final QzoneMainPageFeedManager getUserHomeManager() {
        return this.userHomeManager;
    }

    public final boolean m2() {
        return this.hostUin == LoginData.getInstance().getUin();
    }

    public final MutableLiveData<Boolean> o2() {
        return this.isShowError;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.clear();
        }
        QzoneMainPageFeedManager qzoneMainPageFeedManager2 = this.userHomeManager;
        if (qzoneMainPageFeedManager2 != null) {
            qzoneMainPageFeedManager2.unregisterFeedUpdateCallback(this.feedUpdateCallback);
        }
    }

    public final MutableLiveData<Boolean> p2() {
        return this.isShowForbidden;
    }

    public final boolean q2() {
        Boolean value = this.isShowForbidden.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    /* renamed from: r2, reason: from getter */
    public final boolean getIsTimeLineClick() {
        return this.isTimeLineClick;
    }

    public final void s2() {
        if (this.isTimeLineClick) {
            long A2 = A2();
            QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
            if (qzoneMainPageFeedManager != null) {
                QzoneMainPageFeedManager.loadMoreByTime$default(qzoneMainPageFeedManager, A2, null, 2, null);
                return;
            }
            return;
        }
        QzoneMainPageFeedManager qzoneMainPageFeedManager2 = this.userHomeManager;
        if (qzoneMainPageFeedManager2 != null) {
            QzoneMainPageFeedManager.loadMore$default(qzoneMainPageFeedManager2, null, 1, null);
        }
    }

    public final void t2() {
        long z26 = z2();
        S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.a());
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.loadMoreUpByTime(z26, new e());
        }
    }

    public void u2(List<CommonFeed> feedList, int loadType) {
        int i3;
        int i16;
        List<CommonFeed> data;
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        QLog.d(getLogTag(), 1, "onFeedDataChange, feedList: " + feedList.size());
        boolean z16 = loadType == 2;
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        boolean z17 = qzoneMainPageFeedManager != null && qzoneMainPageFeedManager.getIsListFinish();
        int size = feedList.size();
        if (z16) {
            UIStateData<List<CommonFeed>> value = N1().getValue();
            i16 = (value == null || (data = value.getData()) == null) ? 0 : data.size();
            i3 = RangesKt___RangesKt.coerceAtLeast(feedList.size() - i16, 0);
        } else {
            i3 = size;
            i16 = 0;
        }
        QLog.d(getLogTag(), 1, "lastModifyRecord, startPosition: " + i16 + ", pageCount: " + i3);
        UIStateData.ModifyListRecord obtainNotifyItemRangeInsert = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(i16, i3);
        UIStateData<List<CommonFeed>> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setData(z16, feedList);
        obtainSuccess.setFinish(z17);
        obtainSuccess.setLatestModifyRecord(obtainNotifyItemRangeInsert);
        N1().postValue(obtainSuccess);
    }

    public final void B2() {
        this.isTimeLineClick = false;
    }

    public final void w2(long timeMillis) {
        this.isTimeLineClick = true;
        this.clickTimeLineTime = ef.d.n(Long.valueOf(timeMillis));
        a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2(boolean hasMore) {
        if (hasMore) {
            F2();
        } else {
            G2();
            B2();
        }
    }

    public final void y2(Intent intent) {
        QzoneMainPageFeedManager qzoneMainPageFeedManager;
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("qzone_route_bean");
            if (serializableExtra instanceof QZoneUserHomeBean) {
                QZoneUserHomeBean qZoneUserHomeBean = (QZoneUserHomeBean) serializableExtra;
                this.initBean = qZoneUserHomeBean;
                this.hostUin = qZoneUserHomeBean.getUin();
                this.userHomeManager = new QzoneMainPageFeedManager(String.valueOf(this.hostUin));
                if (this.hostUin == LoginData.getInstance().getUin() && (qzoneMainPageFeedManager = this.userHomeManager) != null) {
                    qzoneMainPageFeedManager.loadCache();
                }
                QzoneMainPageFeedManager qzoneMainPageFeedManager2 = this.userHomeManager;
                if (qzoneMainPageFeedManager2 != null) {
                    qzoneMainPageFeedManager2.registerFeedUpdateCallback(this.feedUpdateCallback, false);
                }
            }
        }
    }
}
