package com.qzone.reborn.feedx.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.personalize.model.CustomPlayerData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.ProfileTimeLine;
import com.qzone.reborn.feedx.util.y;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.util.aa;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00a9\u00012\u00020\u00012\u00020\u0002:\u0002\u00aa\u0001B\t\u00a2\u0006\u0006\b\u00a7\u0001\u0010\u00a8\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u0016\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u0019\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\u001a\u0010\u001f\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)J\u0006\u0010,\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\rJ\u0006\u0010.\u001a\u00020\rJ\u0006\u0010/\u001a\u00020\u001dJ\u0006\u00100\u001a\u00020'J\u0006\u00101\u001a\u00020\u0005J\b\u00102\u001a\u00020\u0005H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020'J\u0006\u00106\u001a\u00020\u0005J\b\u00107\u001a\u00020\u0005H\u0016J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010:\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u001dJ\u001e\u0010>\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010=\u001a\u00020\u0014H\u0016J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005J\u0006\u0010A\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020\u0005H\u0016J\u0006\u0010F\u001a\u00020\rJ\u0010\u0010G\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010H\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010I\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010J\u001a\u00020\u0014J\u0006\u0010K\u001a\u00020\rJ\b\u0010M\u001a\u0004\u0018\u00010LJ\u000e\u0010O\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\rJ\u000e\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020PJ\u0006\u0010S\u001a\u00020\u0005J\u0006\u0010T\u001a\u00020\rJ\u0010\u0010W\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010UJ\u000e\u0010Y\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\rJ\u000e\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020ZJ\u0010\u0010_\u001a\u00020\u00052\b\u0010^\u001a\u0004\u0018\u00010]J\b\u0010`\u001a\u0004\u0018\u00010]R$\u0010h\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010mR\u0016\u0010w\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010jR\u0016\u0010y\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010jR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010jR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010qR\u0018\u0010\u0083\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010qR\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010mR \u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020P0\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R0\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R1\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0091\u0001\u001a\u0006\b\u0099\u0001\u0010\u0093\u0001\"\u0006\b\u009a\u0001\u0010\u0095\u0001R1\u0010\u00a0\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0091\u0001\u001a\u0006\b\u009e\u0001\u0010\u0093\u0001\"\u0006\b\u009f\u0001\u0010\u0095\u0001R/\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bm\u0010\u0091\u0001\u001a\u0006\b\u00a1\u0001\u0010\u0093\u0001\"\u0006\b\u00a2\u0001\u0010\u0095\u0001R\u001b\u0010\u00a6\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u00a8\u0006\u00ab\u0001"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/w;", "Ltc/b;", "Lcom/qzone/common/event/IObserver$main;", "Lcom/qzone/common/business/result/QZoneResult;", "result", "", "V2", "U2", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataList", "g3", "data", "", "N2", "L2", "feedData", "lastFeedData", "j3", "feedsData", "", "updateCount", "Y2", "feedsDataList", ICustomDataEditor.STRING_ARRAY_PARAM_3, "t2", "P2", "Lx6/a;", "userInfoData", "", "uin", Constants.BASE_IN_PLUGIN_VERSION, "qzoneResult", "H2", "Landroid/os/Message;", "msg", "i2", "Lcom/qzone/feed/business/service/QZoneFeedService;", "w2", "", "getLogTag", "Landroid/content/Intent;", "intent", "b3", "O2", "K2", "M2", "E2", "F2", "d3", "P1", SemanticAttributes.DbSystemValues.H2, "refer", "h3", "T2", "f2", "j2", ICustomDataEditor.NUMBER_PARAM_2, "r2", "timeMillis", "W2", "loadType", "g2", "k3", "l3", "e3", "Lcom/qzone/common/event/Event;", "event", "onEventUIThread", "L1", "J2", "I2", "Q2", "R2", "x2", "y2", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "u2", "status", "i3", "Lcom/qzone/reborn/feedx/viewmodel/s;", "lifecycleCallback", "f3", "c3", "S2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.MMCCID, "isSpecialCare", ICustomDataEditor.NUMBER_PARAM_3, "Landroid/content/Context;", "context", "m3", "Lcom/qzone/proxy/feedcomponent/model/ProfileTimeLine;", "timeLineData", "q2", "v2", "Lcom/qzone/reborn/route/QZoneUserHomeBean;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/route/QZoneUserHomeBean;", "z2", "()Lcom/qzone/reborn/route/QZoneUserHomeBean;", "setInitBean", "(Lcom/qzone/reborn/route/QZoneUserHomeBean;)V", "initBean", "G", "I", "mOldFeedCount", "H", "Z", "mFromUserHome", "Ljava/lang/String;", "mExtInfo", "J", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "mNearbyProfile", "K", "mHasTalk", "L", "mEntryType", "M", "mTimeLineClickYear", "N", "mTimeLineClickMonth", "Ljava/util/Calendar;", "P", "Ljava/util/Calendar;", "mTimeLineClickCalendar", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLastTimeLineTime", BdhLogUtil.LogTag.Tag_Req, "mUin", ExifInterface.LATITUDE_SOUTH, "Lcom/qzone/feed/business/service/QZoneFeedService;", "mCurService", "T", "mTimeLineFeedService", "U", "mIsTimeLineClick", "", "V", "Ljava/util/List;", "mTimeLineLifecycleCallbacks", "Landroidx/lifecycle/MutableLiveData;", "W", "Landroidx/lifecycle/MutableLiveData;", "C2", "()Landroidx/lifecycle/MutableLiveData;", "setMUserInfoData", "(Landroidx/lifecycle/MutableLiveData;)V", "mUserInfoData", "Lcom/qzone/personalize/model/CustomNaviCacheData;", "X", NowProxyConstants.AccountInfoKey.A2, "setMCustomNaviData", "mCustomNaviData", "Lcom/qzone/personalize/model/CustomPlayerData;", "Y", "getMCustomPlayData", "setMCustomPlayData", "mCustomPlayData", "B2", "setMHeaderState", "mHeaderState", "a0", "Lcom/qzone/proxy/feedcomponent/model/ProfileTimeLine;", "timeLineDataCache", "<init>", "()V", "b0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class w extends tc.b {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneUserHomeBean initBean;

    /* renamed from: G, reason: from kotlin metadata */
    private int mOldFeedCount;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mFromUserHome;

    /* renamed from: I, reason: from kotlin metadata */
    private String mExtInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private AllInOne mNearbyProfile;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mHasTalk;

    /* renamed from: L, reason: from kotlin metadata */
    private int mEntryType;

    /* renamed from: M, reason: from kotlin metadata */
    private int mTimeLineClickYear;

    /* renamed from: N, reason: from kotlin metadata */
    private int mTimeLineClickMonth;

    /* renamed from: P, reason: from kotlin metadata */
    private Calendar mTimeLineClickCalendar;

    /* renamed from: Q, reason: from kotlin metadata */
    private long mLastTimeLineTime;

    /* renamed from: R, reason: from kotlin metadata */
    private long mUin;

    /* renamed from: S, reason: from kotlin metadata */
    private QZoneFeedService mCurService;

    /* renamed from: T, reason: from kotlin metadata */
    private QZoneFeedService mTimeLineFeedService;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mIsTimeLineClick;

    /* renamed from: V, reason: from kotlin metadata */
    private List<s> mTimeLineLifecycleCallbacks = new ArrayList();

    /* renamed from: W, reason: from kotlin metadata */
    private MutableLiveData<x6.a> mUserInfoData = new MutableLiveData<>();

    /* renamed from: X, reason: from kotlin metadata */
    private MutableLiveData<CustomNaviCacheData> mCustomNaviData = new MutableLiveData<>();

    /* renamed from: Y, reason: from kotlin metadata */
    private MutableLiveData<CustomPlayerData> mCustomPlayData = new MutableLiveData<>();

    /* renamed from: Z, reason: from kotlin metadata */
    private MutableLiveData<Integer> mHeaderState = new MutableLiveData<>();

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ProfileTimeLine timeLineDataCache;

    public w() {
        EventCenter.getInstance().addUIObserver(this, "Personalize", 16);
        EventCenter.getInstance().addUIObserver(this, "CustomPlayer", 1);
    }

    private final int D2(x6.a userInfoData, long uin) {
        if (K2()) {
            return y6.b.d(userInfoData) ? 2 : 3;
        }
        return 1;
    }

    private final void H2(QZoneResult qzoneResult) {
        x6.a value = this.mUserInfoData.getValue();
        if (value == null) {
            return;
        }
        if (qzoneResult.getSucceed()) {
            if (!value.isFollowed) {
                value.isFollowed = true;
                com.qzone.reborn.util.o.f59556a.c(R.string.f169540sj4, 2);
            } else {
                value.isFollowed = false;
                value.isSpecialFollowed = false;
                value.isSpecialFollowedPush = false;
                com.qzone.reborn.util.o.f59556a.c(R.string.wbs, 2);
            }
            this.mUserInfoData.postValue(value);
            return;
        }
        if (TextUtils.isEmpty(qzoneResult.getMessage())) {
            return;
        }
        com.qzone.reborn.util.o.f59556a.d(qzoneResult.getMessage(), 1);
    }

    private final boolean L2(BusinessFeedData data) {
        return K2() && y.d(data);
    }

    private final boolean N2(BusinessFeedData data) {
        return L2(data);
    }

    private final boolean P2() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return this.mTimeLineClickMonth == calendar.get(2) + 1 && this.mTimeLineClickYear == calendar.get(1);
    }

    private final void U2(QZoneResult result) {
        if (result.getData() == null || !(result.getData() instanceof x6.a)) {
            return;
        }
        MutableLiveData<x6.a> mutableLiveData = this.mUserInfoData;
        Object data = result.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qzone.homepage.business.model.BusinessUserInfoData");
        mutableLiveData.setValue((x6.a) data);
    }

    private final void V2(QZoneResult result) {
        if (result.getSucceed()) {
            QZLog.d("Feeds", 1, "feed loadMoreUpFeed end success");
            if (result.getHasMore()) {
                k3();
                return;
            } else {
                l3();
                c3();
                return;
            }
        }
        QZLog.i("Feeds", 1, "feed loadMoreUpFeed end fail");
    }

    private final void Y2(List<? extends BusinessFeedData> feedsData, int updateCount) {
        Iterator<T> it = this.mTimeLineLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(feedsData, updateCount);
        }
    }

    private final void a3(List<? extends BusinessFeedData> feedsDataList) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(feedsDataList);
        if (P2()) {
            l3();
        } else {
            k3();
        }
        if (!arrayList.isEmpty()) {
            t2(arrayList);
        } else {
            BusinessFeedData businessFeedData = new BusinessFeedData();
            businessFeedData.isBlankSearchNoResultTip = true;
            businessFeedData.needShowSearchNoResultTip = true;
            businessFeedData.setIsTimelineEmptyFeed(true);
            Calendar calendar = this.mTimeLineClickCalendar;
            businessFeedData.searchClickCalendar = calendar;
            businessFeedData.searchRealCalendar = calendar;
            arrayList.add(businessFeedData);
            UIStateData<List<BusinessFeedData>> obtainSuccess = UIStateData.obtainSuccess(false);
            obtainSuccess.setData(c2(), arrayList);
            obtainSuccess.setFinish(true);
            T1().postValue(obtainSuccess);
        }
        Iterator<T> it = this.mTimeLineLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            ((s) it.next()).b(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<BusinessFeedData> g3(List<? extends BusinessFeedData> dataList) {
        ArrayList arrayList = new ArrayList();
        if (dataList.isEmpty()) {
            return dataList;
        }
        arrayList.addAll(dataList);
        int size = arrayList.size() - 1;
        int i3 = -1;
        for (int i16 = 0; i16 < size; i16++) {
            if (N2((BusinessFeedData) arrayList.get(i16))) {
                i3 = i16;
            }
        }
        if (i3 == -1) {
            return arrayList;
        }
        arrayList.remove(i3);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(w this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CustomNaviCacheData o16 = com.qzone.personalize.business.b.n().o(this$0.mUin);
        if (o16 != null) {
            this$0.mCustomNaviData.postValue(o16);
        }
    }

    public final MutableLiveData<CustomNaviCacheData> A2() {
        return this.mCustomNaviData;
    }

    public final MutableLiveData<Integer> B2() {
        return this.mHeaderState;
    }

    public final MutableLiveData<x6.a> C2() {
        return this.mUserInfoData;
    }

    /* renamed from: E2, reason: from getter */
    public final long getMUin() {
        return this.mUin;
    }

    public final String F2() {
        return String.valueOf(this.mUin);
    }

    public final void G2(Activity activity) {
        if (J2() && activity != null) {
            activity.finish();
        } else {
            long mUin = getMUin();
            aa.b(activity, mUin, null, D2(this.mUserInfoData.getValue(), mUin), getMEntryType());
        }
    }

    public final boolean I2(x6.a data) {
        return y6.b.f(getMUin()) && y6.b.d(data);
    }

    public final boolean J2() {
        int i3 = this.mEntryType;
        return i3 == 6 || i3 == 5;
    }

    public final boolean K2() {
        return !M2();
    }

    @Override // tc.b, com.qzone.reborn.base.n
    public void L1() {
        super.L1();
        QZoneFeedService qZoneFeedService = this.mTimeLineFeedService;
        if (qZoneFeedService != null) {
            qZoneFeedService.close();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    public final boolean M2() {
        return this.mUin == LoginData.getInstance().getUin();
    }

    public final boolean O2() {
        return !TextUtils.isEmpty(this.initBean != null ? r0.getBottomBubbleUrl() : null);
    }

    @Override // tc.b
    public void P1() {
        super.P1();
        if (this.mIsTimeLineClick) {
            QZoneFeedService qZoneFeedService = this.mTimeLineFeedService;
            if (qZoneFeedService != null) {
                qZoneFeedService.f47184b0 = this.mLastTimeLineTime;
            }
            if (qZoneFeedService != null) {
                qZoneFeedService.f47185c0 = 1;
            }
        }
        h3("");
        e3();
    }

    public final boolean Q2(x6.a userInfoData) {
        if (K2() || userInfoData == null) {
            return false;
        }
        int i3 = userInfoData.relationShip;
        return i3 == 1 || i3 == 3 || i3 == 4 || (i3 == 0 && K2());
    }

    /* renamed from: S2, reason: from getter */
    public final boolean getMIsTimeLineClick() {
        return this.mIsTimeLineClick;
    }

    public final void T2() {
        if (this.mIsTimeLineClick) {
            UIStateData<List<BusinessFeedData>> value = T1().getValue();
            List<BusinessFeedData> data = value != null ? value.getData() : null;
            if (data != null && (data.isEmpty() ^ true)) {
                BusinessFeedData businessFeedData = data.get(0);
                if (y.d(businessFeedData) && data.size() > 1) {
                    businessFeedData = data.get(1);
                }
                if (businessFeedData.getFeedCommInfoV2() != null) {
                    long time = businessFeedData.getFeedCommInfoV2().getTime() / 1000;
                    QZoneFeedService qZoneFeedService = this.mTimeLineFeedService;
                    if (qZoneFeedService != null) {
                        Intrinsics.checkNotNull(qZoneFeedService);
                        qZoneFeedService.f47184b0 = time;
                    }
                }
            }
            QZoneFeedService qZoneFeedService2 = this.mTimeLineFeedService;
            if (qZoneFeedService2 != null) {
                Intrinsics.checkNotNull(qZoneFeedService2);
                qZoneFeedService2.f47185c0 = 2;
            }
        }
        QZoneFeedService R1 = R1();
        if (R1 != null) {
            R1.I(U1());
        }
    }

    public final void d3() {
        P1();
    }

    public final void e3() {
        z5.a f16 = z5.a.f();
        if (f16 != null) {
            f16.q(this.mUin, U1());
        }
    }

    @Override // tc.b
    public void f2() {
        if (this.mIsTimeLineClick) {
            UIStateData<List<BusinessFeedData>> value = T1().getValue();
            List<BusinessFeedData> data = value != null ? value.getData() : null;
            if (data != null) {
                BusinessFeedData businessFeedData = data.get(data.size() - 1);
                if (businessFeedData.getFeedCommInfoV2() != null) {
                    long time = businessFeedData.getFeedCommInfoV2().getTime() / 1000;
                    QZoneFeedService qZoneFeedService = this.mTimeLineFeedService;
                    if (qZoneFeedService != null) {
                        qZoneFeedService.f47184b0 = time;
                    }
                }
            }
            QZoneFeedService qZoneFeedService2 = this.mTimeLineFeedService;
            if (qZoneFeedService2 != null) {
                qZoneFeedService2.f47185c0 = 1;
            }
        }
        QZoneFeedService R1 = R1();
        if (R1 != null) {
            R1.J(U1());
        }
    }

    public final void f3(s lifecycleCallback) {
        Intrinsics.checkNotNullParameter(lifecycleCallback, "lifecycleCallback");
        this.mTimeLineLifecycleCallbacks.add(lifecycleCallback);
    }

    @Override // tc.b
    public void g2(List<? extends BusinessFeedData> feedsData, int loadType) {
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
        super.g2(feedsData, loadType);
        if (this.mIsTimeLineClick) {
            if (loadType == 1) {
                a3(feedsData);
            } else if (loadType == 3) {
                Y2(feedsData, feedsData.size() - this.mOldFeedCount);
            }
        }
        this.mOldFeedCount = feedsData.size();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeViewModel";
    }

    @Override // tc.b
    public void h2(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        CustomNaviCacheData customNaviCacheData = (CustomNaviCacheData) result.getBundle().getParcelable(CustomNaviCacheData.PARAM_CACHE_DATA);
        if (customNaviCacheData != null) {
            this.mCustomNaviData.setValue(customNaviCacheData);
        }
    }

    public final void h3(String refer) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        com.qzone.reborn.feedx.util.c.f55739a.a("data", "requestFeeds: " + this);
        QZoneFeedService R1 = R1();
        if (R1 != null) {
            R1.L(U1(), refer);
        }
    }

    @Override // tc.b
    public void i2(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QZoneResult result = QZoneResult.unpack(msg2);
        Integer valueOf = result != null ? Integer.valueOf(result.what) : null;
        if (valueOf != null && valueOf.intValue() == 999924) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            U2(result);
        } else if (valueOf != null && valueOf.intValue() == 1000152) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            V2(result);
        } else if (valueOf != null && valueOf.intValue() == 1000001) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            H2(result);
        }
    }

    public final void i3(boolean status) {
        x6.a value = this.mUserInfoData.getValue();
        if (value == null) {
            return;
        }
        value.isSpecialCare = status;
    }

    @Override // tc.b
    public List<BusinessFeedData> j2(List<? extends BusinessFeedData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        BusinessFeedData businessFeedData = null;
        for (BusinessFeedData businessFeedData2 : dataList) {
            businessFeedData2.showDateHeader = j3(businessFeedData2, businessFeedData);
            businessFeedData = businessFeedData2;
        }
        return g3(dataList);
    }

    public final void k3() {
        this.mHeaderState.setValue(2);
    }

    public final void l3() {
        this.mHeaderState.setValue(1);
    }

    public final void m3(Context context) {
        a8.b O;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mUserInfoData.getValue() == null || (O = a8.b.O()) == null) {
            return;
        }
        x6.a value = this.mUserInfoData.getValue();
        boolean z16 = value != null ? value.isFollowed : false;
        O.L(this.mUin, !z16, 1, getMHandler(), null, 0, null, context);
        if (z16) {
            LpReportInfo_pf00064.allReport(308, 9, 13);
        } else {
            LpReportInfo_pf00064.allReport(308, 9, 14);
        }
    }

    @Override // tc.b
    public void n2() {
        UIStateData<List<BusinessFeedData>> value = T1().getValue();
        List<BusinessFeedData> data = value != null ? value.getData() : null;
        if (data == null || data.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(data);
        if (y.e() && !b2()) {
            BusinessFeedData a16 = y.a();
            Intrinsics.checkNotNullExpressionValue(a16, "buildFakeGuestMemorySealFeed()");
            arrayList.add(a16);
        }
        UIStateData<List<BusinessFeedData>> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setUpTurning(true);
        obtainSuccess.setData(c2(), arrayList);
        obtainSuccess.setFinish(!b2());
        T1().postValue(obtainSuccess);
    }

    public final void n3(boolean isSpecialCare) {
        if (this.mUserInfoData.getValue() != null) {
            x6.a value = this.mUserInfoData.getValue();
            if (value != null) {
                value.isSpecialCare = isSpecialCare;
            }
            MutableLiveData<x6.a> mutableLiveData = this.mUserInfoData;
            mutableLiveData.postValue(mutableLiveData.getValue());
        }
    }

    @Override // tc.b, com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventUIThread(event);
        String name = event.source.getName();
        if (Intrinsics.areEqual(name, "Personalize")) {
            if (event.what == 16) {
                Object obj = event.params;
                if (obj instanceof Object[]) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr = (Object[]) obj;
                    if (!(objArr.length == 0)) {
                        Object obj2 = objArr[0];
                        if (obj2 instanceof CustomNaviCacheData) {
                            MutableLiveData<CustomNaviCacheData> mutableLiveData = this.mCustomNaviData;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.qzone.personalize.model.CustomNaviCacheData");
                            mutableLiveData.setValue((CustomNaviCacheData) obj2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(name, "CustomPlayer") && event.what == 1) {
            Object obj3 = event.params;
            if (obj3 instanceof Object[]) {
                Object[] objArr2 = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                if (objArr2 == null) {
                    return;
                }
                if (!(objArr2.length == 0)) {
                    Object obj4 = objArr2[0];
                    if (obj4 instanceof CustomPlayerData) {
                        MutableLiveData<CustomPlayerData> mutableLiveData2 = this.mCustomPlayData;
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.qzone.personalize.model.CustomPlayerData");
                        mutableLiveData2.setValue((CustomPlayerData) obj4);
                    }
                }
            }
        }
    }

    public final void q2(ProfileTimeLine timeLineData) {
        this.timeLineDataCache = timeLineData;
    }

    public final void r2() {
        if (K2()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.v
            @Override // java.lang.Runnable
            public final void run() {
                w.s2(w.this);
            }
        });
    }

    /* renamed from: u2, reason: from getter */
    public final AllInOne getMNearbyProfile() {
        return this.mNearbyProfile;
    }

    /* renamed from: v2, reason: from getter */
    public final ProfileTimeLine getTimeLineDataCache() {
        return this.timeLineDataCache;
    }

    @Override // tc.b
    /* renamed from: w2, reason: merged with bridge method [inline-methods] */
    public QZoneFeedService getMCurService() {
        if (this.mIsTimeLineClick) {
            return this.mTimeLineFeedService;
        }
        return this.mCurService;
    }

    /* renamed from: x2, reason: from getter */
    public final int getMEntryType() {
        return this.mEntryType;
    }

    /* renamed from: y2, reason: from getter */
    public final boolean getMHasTalk() {
        return this.mHasTalk;
    }

    /* renamed from: z2, reason: from getter */
    public final QZoneUserHomeBean getInitBean() {
        return this.initBean;
    }

    private final void t2(List<? extends BusinessFeedData> feedsData) {
        BusinessFeedData businessFeedData = feedsData.get(0);
        CellFollowGuide cellFollowGuide = businessFeedData.cellFollowGuide;
        if (cellFollowGuide != null && cellFollowGuide.feed_type == 1 && feedsData.size() > 1) {
            businessFeedData = feedsData.get(1);
        }
        if (businessFeedData.getFeedCommInfoV2() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(businessFeedData.getFeedCommInfoV2().getTime());
            int i3 = calendar.get(2) + 1;
            if (calendar.get(1) == this.mTimeLineClickYear && i3 == this.mTimeLineClickMonth) {
                return;
            }
            businessFeedData.isBlankSearchNoResultTip = false;
            businessFeedData.needShowSearchNoResultTip = true;
            businessFeedData.searchClickCalendar = this.mTimeLineClickCalendar;
            businessFeedData.searchRealCalendar = calendar;
        }
    }

    public final void W2(long timeMillis) {
        this.mIsTimeLineClick = true;
        this.mLastTimeLineTime = timeMillis / 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        this.mTimeLineClickCalendar = calendar;
        this.mTimeLineClickMonth = calendar.get(2) + 1;
        this.mTimeLineClickYear = calendar.get(1);
        if (this.mTimeLineFeedService != null) {
            d3();
        }
    }

    public final void c3() {
        this.mIsTimeLineClick = false;
    }

    public final boolean R2(x6.a userInfoData) {
        if (userInfoData != null) {
            int i3 = userInfoData.relationShip;
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                return true;
            }
            if (i3 == 0 && K2() && I2(userInfoData)) {
                return true;
            }
        }
        return false;
    }

    public final void b3(Intent intent) {
        if (intent != null) {
            if (intent.getSerializableExtra("qzone_route_bean") != null) {
                this.initBean = (QZoneUserHomeBean) intent.getSerializableExtra("qzone_route_bean");
            }
            long longExtra = intent.getLongExtra("qqid", 0L);
            this.mUin = longExtra;
            if (longExtra == 0) {
                this.mUin = LoginData.getInstance().getUin();
            }
            this.mCurService = QZoneFeedService.c0(this.mUin);
            this.mTimeLineFeedService = QZoneFeedService.e0(this.mUin);
            this.mEntryType = intent.getIntExtra(QZoneHelper.INTENT_ENTRY_TYPE, 0);
            this.mHasTalk = intent.getBooleanExtra(QZoneHelper.KEY_HAS_TALK, true);
            this.mNearbyProfile = (AllInOne) intent.getParcelableExtra(QZoneHelper.KEY_NEARBY_PROFILE);
            String stringExtra = intent.getStringExtra(QZoneHelper.INTENT_EXTINFO);
            this.mExtInfo = stringExtra;
            if (stringExtra == null) {
                this.mExtInfo = "";
            }
            this.mFromUserHome = intent.getBooleanExtra(QZoneHelper.FROM_USER_HOME, false);
        }
    }

    private final boolean j3(BusinessFeedData feedData, BusinessFeedData lastFeedData) {
        boolean z16 = false;
        if (lastFeedData != null && !lastFeedData.isFollowGuideFeed()) {
            boolean z17 = !com.qzone.proxy.feedcomponent.util.d.p(feedData.getFeedCommInfo().getTime(), lastFeedData.getFeedCommInfo().getTime());
            if (lastFeedData.getFeedCommInfoV2() != null && lastFeedData.getFeedCommInfoV2().isTopFeed()) {
                z16 = true;
            }
            if (z16 || lastFeedData.isRecomMyEventTagContainerFeed()) {
                return true;
            }
            return z17;
        }
        if (feedData.getFeedCommInfoV2() != null && feedData.getFeedCommInfoV2().isTopFeed()) {
            z16 = true;
        }
        return true ^ z16;
    }
}
