package gj4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.IQQGiftComboView;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.timi.game.liveroom.impl.room.effectcombo.EffectGiftSendEvent;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pk4.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0003J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e`\u001fH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010;\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010,R\u0018\u0010?\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010A\u00a8\u0006F"}, d2 = {"Lgj4/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/liveroom/impl/room/effectcombo/EffectGiftSendEvent;", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "Landroid/view/View;", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftData", "", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "B", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "roomId", "w", HippyTKDListViewAdapter.X, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftComboView;", "d", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftComboView;", "qqIQQGiftComboView", "e", "Landroid/view/View;", "comboSendView", "f", "Landroid/widget/FrameLayout;", "comboSendViewContainer", h.F, "J", "curBalance", "i", "curMarketingBalance", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curComboSeq", BdhLogUtil.LogTag.Tag_Conn, "giftId", "D", "I", "lastComboNum", "E", "lastAllNum", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqgift/data/service/d;", "quickGiftData", "G", "H", "Landroid/app/Activity;", "hostActivity", "Lrh2/a;", "Lrh2/a;", "qqGiftBalanceCallback", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes26.dex */
public final class c implements SimpleEventReceiver<EffectGiftSendEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private long giftId;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastComboNum;

    /* renamed from: E, reason: from kotlin metadata */
    private int lastAllNum;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private d quickGiftData;

    /* renamed from: G, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Activity hostActivity;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final rh2.a qqGiftBalanceCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQGiftComboView qqIQQGiftComboView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View comboSendView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout comboSendViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long curBalance;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long curMarketingBalance;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long curComboSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"gj4/c$c", "Lrh2/a;", "", "balance", "marketingBalance", "seq", "", "firstSave", "", h.F, "errCode", "", "errMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gj4.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10380c implements rh2.a {
        C10380c() {
        }

        @Override // rh2.a
        public void h(long balance, long marketingBalance, long seq, int firstSave) {
            AegisLogger.INSTANCE.i("Send_Gift_Monitor|EffectComboPresenter", "IQQGiftBalanceCallback.onReceive", "requestBalance success, balance=" + balance + ", seq=" + seq);
            c.this.curBalance = balance;
            c.this.curMarketingBalance = marketingBalance;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            AegisLogger.INSTANCE.i("Send_Gift_Monitor|EffectComboPresenter", "IQQGiftBalanceCallback.onFailed", "requestBalance fail, errCode=" + errCode + ", errMsg=" + errMsg);
        }
    }

    public c() {
        QRouteApi api = QRoute.api(IQQGiftComboView.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQGiftComboView::class.java)");
        this.qqIQQGiftComboView = (IQQGiftComboView) api;
        this.qqGiftBalanceCallback = new C10380c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        View view = this.comboSendView;
        if (view != null) {
            if (view != null) {
                view.setVisibility(8);
            }
            FrameLayout frameLayout = this.comboSendViewContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            this.qqIQQGiftComboView.hideAnimation(this.comboSendView);
        }
    }

    private final void q() {
        Activity activity = this.hostActivity;
        if (activity != null) {
            Context baseContext = activity.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "it.baseContext");
            View u16 = u(baseContext);
            FrameLayout frameLayout = this.comboSendViewContainer;
            if (frameLayout != null) {
                frameLayout.addView(u16);
            }
            FrameLayout frameLayout2 = this.comboSendViewContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
    }

    private final void r() {
        if (this.comboSendViewContainer == null) {
            AegisLogger.INSTANCE.e("Send_Gift_Monitor|EffectComboPresenter", "checkAndBuildComboView", "fail, container is null");
            return;
        }
        if (this.comboSendView != null) {
            return;
        }
        if (this.qqIQQGiftComboView.isPagSoReady(BaseApplication.context)) {
            AegisLogger.INSTANCE.i("Send_Gift_Monitor|EffectComboPresenter", "checkAndBuildComboView", "success, pag so is ready!");
            q();
        } else {
            AegisLogger.INSTANCE.w("Send_Gift_Monitor|EffectComboPresenter", "checkAndBuildComboView", "pending, try load pag so...");
            this.qqIQQGiftComboView.loadPag(BaseApplication.context, new IQQGiftComboView.a() { // from class: gj4.a
                @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView.a
                public final void onComplete() {
                    c.s(c.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|EffectComboPresenter", "checkAndBuildComboView", "success, pad so load complete!");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: gj4.b
            @Override // java.lang.Runnable
            public final void run() {
                c.t(c.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    private final View u(Context context) {
        View view = this.comboSendView;
        if (view != null) {
            return view;
        }
        View createView = this.qqIQQGiftComboView.createView(context, pk4.b.v(), new b());
        this.comboSendView = createView;
        return createView;
    }

    private final int v(d giftData) {
        Object value;
        int i3;
        Map<String, String> map = giftData.M;
        if (map != null && !map.isEmpty()) {
            if (map.containsKey("batchSendCnt")) {
                value = MapsKt__MapsKt.getValue(map, "batchSendCnt");
                String str = (String) value;
                if (str != null) {
                    i3 = Integer.parseInt(str);
                } else {
                    i3 = 1;
                }
                int max = giftData.f264878f * Math.max(i3, 1);
                AegisLogger.INSTANCE.i("Send_Gift_Monitor|EffectComboPresenter", "getSingleClickPrice", "batchCnt: " + i3 + ", singleClickPrice: " + max);
                return max;
            }
            return giftData.f264878f;
        }
        return giftData.f264878f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        d dVar = this.quickGiftData;
        if (dVar != null) {
            int v3 = v(dVar);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.w("Send_Gift_Monitor|EffectComboPresenter", "preDealBalance", "do preDealBalance while giftData is:giftId: " + dVar.f264874d + ", giftName: " + dVar.f264876e + ", giftPrice: " + dVar.f264878f + ", singleClickPrice: " + v3 + "curMarketingBalance:" + this.curMarketingBalance + "curBalance:" + this.curBalance);
            long j3 = this.curMarketingBalance;
            if (j3 >= 0) {
                this.curMarketingBalance = j3 - v3;
            }
            if (this.curMarketingBalance < 0) {
                this.curMarketingBalance = 0L;
                long j16 = this.curBalance - v3;
                this.curBalance = j16;
                if (j16 <= 0) {
                    this.curBalance = 0L;
                    companion.w("Send_Gift_Monitor|EffectComboPresenter", "preDealBalance", "blance not enough, close comboView");
                    A();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        pk4.b.t(new rk4.a(this.qqGiftBalanceCallback));
    }

    public final void B(@NotNull FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.comboSendViewContainer = container;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<EffectGiftSendEvent>> getEventClass() {
        ArrayList<Class<EffectGiftSendEvent>> arrayList = new ArrayList<>();
        arrayList.add(EffectGiftSendEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof EffectGiftSendEvent) {
            EffectGiftSendEvent effectGiftSendEvent = (EffectGiftSendEvent) event;
            d giftServiceData = effectGiftSendEvent.getGiftServiceData();
            this.quickGiftData = giftServiceData;
            AegisLogger.INSTANCE.i("Send_Gift_Monitor|EffectComboPresenter", "onReceiveEvent.EffectGiftSendEvent", "receive gift info: " + giftServiceData);
            this.giftId = (long) effectGiftSendEvent.getGiftServiceData().f264874d;
            this.curComboSeq = effectGiftSendEvent.getGiftServiceData().H;
            this.lastComboNum = effectGiftSendEvent.getComboCnt();
            this.lastAllNum = effectGiftSendEvent.getAllComboCnt();
            z();
            r();
            this.qqIQQGiftComboView.showAnimation(this.comboSendView);
            FrameLayout frameLayout = this.comboSendViewContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }
    }

    public final void w(@NotNull Activity activity, long roomId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hostActivity = activity;
        this.roomId = roomId;
        SimpleEventBus.getInstance().registerReceiver(this);
        z();
    }

    public final void x() {
        FrameLayout frameLayout = this.comboSendViewContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        View view = this.comboSendView;
        if (view != null) {
            view.setVisibility(8);
        }
        this.qqIQQGiftComboView.removePagloadCallbacks();
        this.qqIQQGiftComboView.hideAnimation(this.comboSendView);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.comboSendView = null;
        this.hostActivity = null;
        this.roomId = 0L;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"gj4/c$b", "Lph2/b;", "", "curNum", "", ReportConstant.COSTREPORT_PREFIX, "comboNum", "allNum", "", "needDelay", "c", "e", "allComBoNum", "b", "i", "j", "Lpk4/b$k;", "d", "Lpk4/b$k;", "sendGiftCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements ph2.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b.k sendGiftCallback;

        b() {
            this.sendGiftCallback = new a(c.this);
        }

        @Override // ph2.b
        public void c(int comboNum, int allNum, boolean needDelay) {
            Long l3;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            long j3 = c.this.curComboSeq;
            d dVar = c.this.quickGiftData;
            if (dVar != null) {
                l3 = Long.valueOf(dVar.H);
            } else {
                l3 = null;
            }
            companion.i("Send_Gift_Monitor|EffectComboPresenter", "onSend", "do send gift comboNum=" + comboNum + ", allNum=" + allNum + ", comboSeq=" + j3 + ", data.hitSeq=" + l3);
            c.this.lastComboNum = comboNum;
            c.this.lastAllNum = allNum;
            pk4.b.J(c.this.hostActivity, c.this.curBalance, c.this.curMarketingBalance, this.sendGiftCallback, comboNum, allNum, c.this.curComboSeq, c.this.quickGiftData);
            c.this.y();
        }

        @Override // ph2.b
        public void i() {
            Long l3;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            int i3 = c.this.lastComboNum;
            int i16 = c.this.lastAllNum;
            long j3 = c.this.curComboSeq;
            d dVar = c.this.quickGiftData;
            if (dVar != null) {
                l3 = Long.valueOf(dVar.H);
            } else {
                l3 = null;
            }
            companion.i("Send_Gift_Monitor|EffectComboPresenter", "animalViewHideNotify", "combo over lastComboNum=" + i3 + ", lastAllNum=" + i16 + ", comboSeq=" + j3 + ", data.hitSeq=" + l3);
            pk4.b.K(c.this.quickGiftData, c.this.curComboSeq, c.this.lastComboNum, c.this.lastAllNum, c.this.curBalance);
            c.this.A();
            c.this.z();
        }

        @Override // ph2.b
        public void j() {
            String str;
            IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
            QQLiveQualityReportData.Builder eventId = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).eventId(QQLiveReportConstants.Event.E_AUDIENCE_GIFTCOMBO_RESOURCE_INVALID);
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 != null) {
                str = c16.n();
            } else {
                str = null;
            }
            iQQLiveReportApi.qualityReport(eventId.traceId(str).ext6(QQLiveReportConstants.Scene.SCENE_EFFECT_GIFT_COMBO));
        }

        @Override // ph2.b
        public void e() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"gj4/c$b$a", "Lpk4/b$k;", "", "errCode", "", "errMsg", "", "a", "f", "e", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "c", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a implements b.k {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f402342a;

            a(c cVar) {
                this.f402342a = cVar;
            }

            @Override // pk4.b.k
            public void a(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                this.f402342a.A();
            }

            @Override // pk4.b.k
            public void b(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                this.f402342a.A();
            }

            @Override // pk4.b.k
            public void e(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                this.f402342a.A();
                this.f402342a.z();
            }

            @Override // pk4.b.k
            public void f(@NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                this.f402342a.A();
            }

            @Override // pk4.b.k
            public void c(@Nullable d giftServiceData) {
            }

            @Override // pk4.b.k
            public void d(@Nullable d giftServiceData) {
            }
        }

        @Override // ph2.b
        public void b(int allComBoNum) {
        }

        @Override // ph2.b
        public void s(int curNum) {
        }
    }
}
