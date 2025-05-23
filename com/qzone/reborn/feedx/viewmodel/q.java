package com.qzone.reborn.feedx.viewmodel;

import NS_MOBILE_FEEDS.cnst.UNREAD_FEED_PUSH_DATA;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.tianshu.QZoneTianShuAdManager;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.util.ah;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q5.QZoneFloatPlusBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0002mnB\u0007\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0016J\u001e\u0010\u0012\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\rJ&\u0010\u001a\u001a\u00020\u00032\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0015j\b\u0012\u0004\u0012\u00020\r`\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0003J\u0010\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u001e\u0010\"\u001a\u00020\u00032\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0015j\b\u0012\u0004\u0012\u00020\r`\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0016J\u000e\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+J\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010/\u001a\u00020\u0018J\u0006\u00100\u001a\u00020\u0018J\u0006\u00101\u001a\u00020\u0003J\u0006\u00102\u001a\u00020\u0018J\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0015j\b\u0012\u0004\u0012\u00020\r`\u0016R\u0016\u00106\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010@\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010G\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010M\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR<\u0010Y\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020R\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020R\u0018\u0001`\u00160Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR(\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00100Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010T\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR(\u0010b\u001a\b\u0012\u0004\u0012\u00020^0Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010T\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR\u0016\u0010d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010HR\u0016\u0010f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010HR&\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0015j\b\u0012\u0004\u0012\u00020\r`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010h\u00a8\u0006o"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/q;", "Ltc/b;", "Lcom/qzone/common/event/IObserver$main;", "", "L2", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "K2", "w2", "", "pushTransChannel", "", "", ICustomDataEditor.STRING_PARAM_2, "getLogTag", "", "loadType", "g2", "refer", "M2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jumpAttachList", "", "isFirstTimeLoadUp", "z2", "u2", "Landroid/content/Intent;", "intent", "T2", "U2", "P1", "f2", "y2", "Lcom/qzone/feed/business/service/QZoneFeedService;", "B2", "Lcom/qzone/common/business/result/QZoneResult;", "result", SemanticAttributes.DbSystemValues.H2, "", "time", "O2", "Lcom/qzone/reborn/feedx/viewmodel/q$b;", "provider", "Q2", NowProxyConstants.AccountInfoKey.A2, "I2", Constants.BASE_IN_PLUGIN_VERSION, "t2", "C2", "E2", UserInfo.SEX_FEMALE, "J", "mRefreshStartTime", "G", "Lcom/qzone/reborn/feedx/viewmodel/q$b;", "mCoverTransProvider", "H", "Ljava/lang/String;", "getMRefer", "()Ljava/lang/String;", "S2", "(Ljava/lang/String;)V", "mRefer", "I", "[B", "getMPushTransChannel", "()[B", "R2", "([B)V", "mPushTransChannel", "Z", "getMNeedRefresh", "()Z", "setMNeedRefresh", "(Z)V", "mNeedRefresh", "K", "Lcom/qzone/feed/business/service/QZoneFeedService;", "mCurService", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qzone/component/banner/BusinessADBannerData;", "L", "Landroidx/lifecycle/MutableLiveData;", "F2", "()Landroidx/lifecycle/MutableLiveData;", "setMBannerLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "mBannerLiveData", "M", "H2", "setMTitleAlphaLiveData", "mTitleAlphaLiveData", "Lq5/b;", "N", Constants.MMCCID, "setMFloatPlusBubbleInfoLiveData", "mFloatPlusBubbleInfoLiveData", "P", "mIsReadDivideLineClicked", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mIsLoadMoreUp", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/ArrayList;", "mJumpAttachList", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends tc.b {

    /* renamed from: S, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static int T;
    public static int U;
    public static long V;

    /* renamed from: F, reason: from kotlin metadata */
    private long mRefreshStartTime;

    /* renamed from: G, reason: from kotlin metadata */
    private b mCoverTransProvider;

    /* renamed from: H, reason: from kotlin metadata */
    private String mRefer = "";

    /* renamed from: I, reason: from kotlin metadata */
    private byte[] mPushTransChannel;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mNeedRefresh;

    /* renamed from: K, reason: from kotlin metadata */
    private QZoneFeedService mCurService;

    /* renamed from: L, reason: from kotlin metadata */
    private MutableLiveData<ArrayList<BusinessADBannerData>> mBannerLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private MutableLiveData<Integer> mTitleAlphaLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    private MutableLiveData<QZoneFloatPlusBubbleInfo> mFloatPlusBubbleInfoLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsReadDivideLineClicked;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean mIsLoadMoreUp;

    /* renamed from: R, reason: from kotlin metadata */
    private ArrayList<String> mJumpAttachList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/q$a;", "", "", "b", "Lcom/tencent/biz/richframework/part/block/BlockContainer;", "blockContainer", "a", "", "FRIEND_FEED_DESTROY_TIME", "Ljava/lang/String;", "FRIEND_FEED_ENTER_TIME", "TAG", "TRANS_DATA_KEY_FRIEND_BIRTHDAY", "TRANS_DATA_KEY_UNREAD_COUNT", "", "sFriendFeedEnterTime", "J", "", "sLastFeedIndex", "I", "sLastFeedOffset", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.viewmodel.q$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        @JvmStatic
        public final void b() {
            q.T = 0;
            q.U = 0;
        }

        @JvmStatic
        public final void a(BlockContainer blockContainer) {
            NestScrollRecyclerView recyclerView;
            int abs;
            if (blockContainer == null || (recyclerView = blockContainer.getRecyclerView()) == null) {
                return;
            }
            Companion companion = q.INSTANCE;
            q.T = ah.a(recyclerView);
            View childAt = recyclerView.getChildAt(0);
            if (childAt != null) {
                abs = childAt.getTop();
            } else {
                abs = Math.abs(CoverEnv.getCoverFriendPaddingTop()) + 0;
            }
            q.U = abs;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/q$b;", "", "", ExifInterface.LATITUDE_SOUTH, "", "T", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        int S();

        boolean T();
    }

    public q() {
        QZoneFeedService U2 = QZoneFeedService.U();
        Intrinsics.checkNotNullExpressionValue(U2, "getActiveFeedService()");
        this.mCurService = U2;
        this.mBannerLiveData = new MutableLiveData<>();
        this.mTitleAlphaLiveData = new MutableLiveData<>();
        this.mFloatPlusBubbleInfoLiveData = new MutableLiveData<>();
        this.mJumpAttachList = new ArrayList<>();
    }

    @JvmStatic
    public static final void J2(BlockContainer blockContainer) {
        INSTANCE.a(blockContainer);
    }

    private final void K2(List<? extends BusinessFeedData> feedsData) {
        long j3 = this.mRefreshStartTime;
        if (j3 > 0) {
            lg.g.f414459a.h(System.currentTimeMillis() - this.mRefreshStartTime, feedsData);
            this.mRefreshStartTime = 0L;
            return;
        }
        RFWLog.e("FriendFeedxViewModel", RFWLog.USR, "reportRefreshFinish error: " + j3);
    }

    private final void L2() {
        this.mRefreshStartTime = System.currentTimeMillis();
        lg.g.f414459a.i();
    }

    @JvmStatic
    public static final void N2() {
        INSTANCE.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2() {
        u5.c.I("friendfeedentertime", V, LoginData.getInstance().getUin());
    }

    private final Map<String, byte[]> s2(byte[] pushTransChannel) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (pushTransChannel != null) {
            linkedHashMap.put(UNREAD_FEED_PUSH_DATA.value, pushTransChannel);
        }
        byte[] w3 = QZoneUnreadServletLogic.w(LoginData.getInstance().getUinString());
        if (w3 != null) {
            if (!(w3.length == 0)) {
                linkedHashMap.put("#CHARBUF#unread_count", w3);
                QZoneUnreadServletLogic.k0(LoginData.getInstance().getUinString(), null);
            }
        }
        byte[] l3 = QZoneUnreadServletLogic.l(LoginData.getInstance().getUinString());
        if (l3 != null) {
            if (!(l3.length == 0)) {
                linkedHashMap.put("#CHARBUF#frd_birth_recom", l3);
                QZoneUnreadServletLogic.e0(LoginData.getInstance().getUinString(), null);
            }
        }
        Map<String, byte[]> s16 = QZoneUnreadServletLogic.s(LoginData.getInstance().getUinString());
        if (s16 != null && (!s16.isEmpty())) {
            for (Map.Entry<String, byte[]> entry : s16.entrySet()) {
                String key = entry.getKey();
                byte[] value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                linkedHashMap.put(key, value);
            }
            QZoneUnreadServletLogic.h0(LoginData.getInstance().getUinString(), null);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w2();
    }

    private final void w2() {
        RFWLog.i("request_feedx", RFWLog.USR, "doCheckRefreshData");
        this.mCurService.Q0();
        Map<String, byte[]> s26 = s2(this.mPushTransChannel);
        String k3 = QZoneUnreadServletLogic.k(LoginData.getInstance().getUinString());
        if (!TextUtils.isEmpty(k3)) {
            this.mCurService.W0(k3);
            QZoneUnreadServletLogic.d0(LoginData.getInstance().getUinString(), "");
        }
        this.mCurService.S0(s26);
        if (getMNeedRefresh()) {
            P1();
        } else {
            RFWLog.i("request_feedx", RFWLog.USR, "do not need do refresh");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.feed.business.service.c.a().d(LoginData.getInstance().getUin(), this$0.U1());
    }

    public final int A2() {
        b bVar = this.mCoverTransProvider;
        Integer valueOf = bVar != null ? Integer.valueOf(bVar.S()) : null;
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 255;
    }

    @Override // tc.b
    /* renamed from: B2, reason: from getter and merged with bridge method [inline-methods] */
    public QZoneFeedService R1() {
        return this.mCurService;
    }

    /* renamed from: C2, reason: from getter */
    public final boolean getMIsLoadMoreUp() {
        return this.mIsLoadMoreUp;
    }

    /* renamed from: D2, reason: from getter */
    public final boolean getMIsReadDivideLineClicked() {
        return this.mIsReadDivideLineClicked;
    }

    public final ArrayList<String> E2() {
        return this.mJumpAttachList;
    }

    public final MutableLiveData<ArrayList<BusinessADBannerData>> F2() {
        return this.mBannerLiveData;
    }

    public final MutableLiveData<QZoneFloatPlusBubbleInfo> G2() {
        return this.mFloatPlusBubbleInfoLiveData;
    }

    public final MutableLiveData<Integer> H2() {
        return this.mTitleAlphaLiveData;
    }

    public final boolean I2() {
        b bVar = this.mCoverTransProvider;
        return bVar != null && bVar.T();
    }

    public final void M2(String refer) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        jo.h.f410717a.h("friend_feedx_refresh").t("START_REQUEST");
        R1().L(U1(), refer);
        L2();
    }

    public final void O2(long time) {
        V = time;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.n
            @Override // java.lang.Runnable
            public final void run() {
                q.P2();
            }
        });
    }

    @Override // tc.b
    public void P1() {
        if (getMIsRefreshing()) {
            RFWLog.i("request_feedx", RFWLog.USR, "isRefreshing, just return");
            return;
        }
        RFWLog.i("request_feedx", RFWLog.USR, "do refresh");
        super.P1();
        M2(this.mRefer);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.o
            @Override // java.lang.Runnable
            public final void run() {
                q.x2(q.this);
            }
        });
        QZoneTianShuAdManager.e().l();
        INSTANCE.b();
    }

    public final void Q2(b provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.mCoverTransProvider = provider;
    }

    public final void R2(byte[] bArr) {
        this.mPushTransChannel = bArr;
    }

    public final void S2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mRefer = str;
    }

    /* renamed from: U2, reason: from getter */
    public final boolean getMNeedRefresh() {
        return this.mNeedRefresh;
    }

    @Override // tc.b
    public void f2() {
        jo.h.f410717a.h("friend_feedx_load_more").t("START_REQUEST");
        R1().J(getMHandler());
    }

    @Override // tc.b
    public void g2(List<? extends BusinessFeedData> feedsData, int loadType) {
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
        super.g2(feedsData, loadType);
        if (loadType == 1) {
            K2(feedsData);
        }
        if (loadType == 2) {
            jo.h.f410717a.h("friend_feedx_load_more").t("ON_FEED_DATA_CHANGE");
        } else {
            jo.h.f410717a.h("friend_feedx_refresh").t("ON_FEED_DATA_CHANGE");
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "FriendFeedxViewModel";
    }

    @Override // tc.b
    public void h2(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getSucceed()) {
            this.mNeedRefresh = false;
            dh.d.f393812a.d();
            RFWLog.i("FriendFeedxViewModel", RFWLog.USR, "clear friend active count info ");
            this.mBannerLiveData.setValue(ParcelableWrapper.getArrayListFromBundle(result.getBundle(), BusinessADBannerData.STORE_KEY));
        }
    }

    public final void u2() {
        RFWLog.i("request_feedx", RFWLog.USR, "checkRefreshData");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.p
            @Override // java.lang.Runnable
            public final void run() {
                q.v2(q.this);
            }
        });
    }

    public final void y2(ArrayList<String> jumpAttachList) {
        Intrinsics.checkNotNullParameter(jumpAttachList, "jumpAttachList");
        this.mIsReadDivideLineClicked = true;
        this.mIsLoadMoreUp = false;
        this.mJumpAttachList = jumpAttachList;
        R1().U0(true);
        R1().V0(jumpAttachList);
        R1().J(getMHandler());
    }

    public final void z2(ArrayList<String> jumpAttachList, boolean isFirstTimeLoadUp) {
        Intrinsics.checkNotNullParameter(jumpAttachList, "jumpAttachList");
        com.qzone.reborn.feedx.util.c.f55739a.a("data", "friendFeedRequestFeeds");
        QZoneFeedService R1 = R1();
        this.mIsLoadMoreUp = true;
        if (isFirstTimeLoadUp) {
            this.mIsReadDivideLineClicked = true;
            this.mJumpAttachList = jumpAttachList;
            R1.P0(U1(), this.mRefer, true, jumpAttachList);
        } else {
            this.mIsReadDivideLineClicked = false;
            R1.T(U1(), false);
        }
    }

    public final void t2() {
        this.mIsReadDivideLineClicked = false;
        this.mIsLoadMoreUp = false;
    }

    public final void T2(Intent intent) {
        boolean z16 = true;
        if (!(intent != null && intent.getBooleanExtra("force_refresh", false))) {
            if (!(intent != null && intent.getBooleanExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, false))) {
                z16 = false;
            }
        }
        this.mNeedRefresh = lg.g.f414459a.p(z16, R1(), this.mPushTransChannel);
    }
}
