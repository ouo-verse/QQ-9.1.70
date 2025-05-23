package cooperation.vip.ad.processors;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Argus;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOHideEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.ad.GrowHalfLayerHelper;
import cooperation.vip.ad.GrowHalfLayerInfo;
import cooperation.vip.ad.processors.a;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\b\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J4\u0010#\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030+0*H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J>\u00107\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u0002002\b\u00104\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u000205H\u0016J \u0010;\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010.2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0016H\u0016R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010>R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010@R\u0016\u0010C\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010BR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR#\u0010O\u001a\n L*\u0004\u0018\u00010K0K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010G\u001a\u0004\bM\u0010NR\u001b\u0010R\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010G\u001a\u0004\bQ\u0010IR\u0014\u0010U\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010T\u00a8\u0006\\"}, d2 = {"Lcooperation/vip/ad/processors/QQPushNotifyProcessor;", "Lcooperation/vip/ad/processors/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroidx/fragment/app/Argus$ComponentCallback;", "", "r", "", "time", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/event/AIOHideEvent;", "aioEvent", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "currentAdItem", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcooperation/vip/ad/GrowHalfLayerInfo;", "growHalfLayerInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "", "traceId", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "i", "nowTime", "", "c", "e", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/richframework/argus/page/PageInfo;", "fromPage", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "fromPagePO", "newPage", "newPagePO", "groupPO", "Landroidx/fragment/app/Argus$MergeResult;", "mergeResult", "onPageChange", "currentPageInfo", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "historyPageChanges", "onPredictResult", "J", "conversationTabFirstShowTime", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "Ljava/lang/String;", tl.h.F, "Z", "isAddRunnable", "appOnBack", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "w", "()Ljava/lang/Runnable;", "runnable", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "v", "()Landroid/os/Handler;", "handler", "D", "t", "abandonedRunnable", HippyTKDListViewAdapter.X, "()J", "stopTime", "u", "abandonedTime", "<init>", "()V", "E", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class QQPushNotifyProcessor implements a, SimpleEventReceiver<SimpleBaseEvent>, Argus.ComponentCallback {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy abandonedRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long conversationTabFirstShowTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TianShuAccess.AdItem adItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAddRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean appOnBack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy runnable;

    public QQPushNotifyProcessor() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Argus.INSTANCE.registerComponentCallback(this);
        if (cooperation.vip.ad.i.b() != null) {
            this.conversationTabFirstShowTime = System.currentTimeMillis();
        }
        this.traceId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new QQPushNotifyProcessor$runnable$2(this));
        this.runnable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: cooperation.vip.ad.processors.QQPushNotifyProcessor$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return RFWThreadManager.getInstance().getSerialThreadHandler();
            }
        });
        this.handler = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new QQPushNotifyProcessor$abandonedRunnable$2(this));
        this.abandonedRunnable = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(GrowHalfLayerInfo growHalfLayerInfo) {
        QQAppInterface b16 = cooperation.vip.ad.i.b();
        if (b16 == null) {
            return;
        }
        if (!b16.isConversationTabShow) {
            QLog.d("QQPushNotifyProcessor", 1, "isConversationTabShow, tab not show");
            return;
        }
        QLog.d("QQPushNotifyProcessor", 1, "showHalfScreen, " + growHalfLayerInfo);
        this.adItem = null;
        GrowHalfLayerHelper.r(Foreground.getTopActivity(), growHalfLayerInfo, false);
    }

    private final void B(AIOHideEvent aioEvent, TianShuAccess.AdItem currentAdItem) {
        HashMap hashMap = new HashMap();
        String nick = aioEvent.getNick();
        if (nick == null) {
            nick = "";
        }
        hashMap.put("banner_nick", nick);
        hashMap.put("banner_uin", aioEvent.getUin());
        int uinType = aioEvent.getUinType();
        if (uinType != 1) {
            if (uinType == 2) {
                hashMap.put("current_sence", "msgtab_backfrom_group_aio");
            }
        } else {
            hashMap.put("current_sence", "msgtab_backfrom_c2c_aio");
        }
        A(GrowHalfLayerHelper.f391021a.t(currentAdItem, this.traceId, 1401, hashMap, true));
    }

    private final void C(long time) {
        if (!this.appOnBack && this.conversationTabFirstShowTime == 0) {
            this.conversationTabFirstShowTime = time;
        }
    }

    static /* synthetic */ void D(QQPushNotifyProcessor qQPushNotifyProcessor, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = System.currentTimeMillis();
        }
        qQPushNotifyProcessor.C(j3);
    }

    private final void q() {
        long currentTimeMillis = System.currentTimeMillis() - this.conversationTabFirstShowTime;
        if (currentTimeMillis < x() && !this.isAddRunnable) {
            v().postDelayed(w(), currentTimeMillis);
            this.isAddRunnable = true;
        }
    }

    private final void r() {
        v().post(new Runnable() { // from class: cooperation.vip.ad.processors.c
            @Override // java.lang.Runnable
            public final void run() {
                QQPushNotifyProcessor.s(QQPushNotifyProcessor.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QQPushNotifyProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAppInterface b16 = cooperation.vip.ad.i.b();
        if (b16 == null) {
            return;
        }
        if (b16.isConversationTabShow) {
            D(this$0, 0L, 1, null);
        } else {
            this$0.C(-1L);
        }
    }

    private final Runnable t() {
        return (Runnable) this.abandonedRunnable.getValue();
    }

    private final long u() {
        int i3;
        com.tencent.mobileqq.tianshu.config.b a16;
        com.tencent.mobileqq.tianshu.config.c h16 = com.tencent.mobileqq.app.msgnotify.a.f196345a.h();
        if (h16 != null && (a16 = h16.a()) != null) {
            i3 = a16.a();
        } else {
            i3 = 600;
        }
        return i3 * 1000;
    }

    private final Handler v() {
        return (Handler) this.handler.getValue();
    }

    private final Runnable w() {
        return (Runnable) this.runnable.getValue();
    }

    private final long x() {
        int i3;
        com.tencent.mobileqq.tianshu.config.b a16;
        com.tencent.mobileqq.tianshu.config.c h16 = com.tencent.mobileqq.app.msgnotify.a.f196345a.h();
        if (h16 != null && (a16 = h16.a()) != null) {
            i3 = a16.e();
        } else {
            i3 = 3;
        }
        return i3 * 1000;
    }

    @Override // cooperation.vip.ad.processors.a
    public int a() {
        return a.C10126a.h(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void b(int i3) {
        a.C10126a.a(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean c(int nowTime) {
        boolean z16;
        com.tencent.mobileqq.tianshu.config.b a16;
        com.tencent.mobileqq.app.msgnotify.a aVar = com.tencent.mobileqq.app.msgnotify.a.f196345a;
        com.tencent.mobileqq.tianshu.config.c h16 = aVar.h();
        if (h16 != null && (a16 = h16.a()) != null && a16.b() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && ((!aVar.l() || !aVar.m()) && a.C10126a.e(this, nowTime))) {
            return true;
        }
        return false;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public List<TianShuAdPosItemData> d(int time) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1401;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] e() {
        return new int[]{4, 1};
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] f() {
        return new int[]{1401};
    }

    @Override // cooperation.vip.ad.processors.a
    public void g(long j3) {
        a.C10126a.i(this, j3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(AIOHideEvent.class);
        return arrayList;
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean h(int i3) {
        return a.C10126a.d(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, int currentTime) {
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        Intrinsics.checkNotNullParameter(mapEntries, "mapEntries");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        SimpleEventBus.getInstance().registerReceiver(this);
        TianShuAccess.RspEntry rspEntry = mapEntries.get(1401);
        if (rspEntry == null || rspEntry.value.lst.isEmpty()) {
            return;
        }
        v().removeCallbacks(t());
        this.adItem = rspEntry.value.lst.get(0);
        this.traceId = traceId;
        q();
        TianShuManager.getInstance().markAdShowStatus(1401);
        v().postDelayed(t(), u());
    }

    @Override // cooperation.vip.ad.processors.a
    public long j() {
        return a.C10126a.b(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onAccountChange() {
        a.C10126a.f(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onDestroy() {
        a.C10126a.g(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPageChange(@Nullable PageInfo fromPage, @Nullable PageInfoPO fromPagePO, @NotNull PageInfo newPage, @NotNull PageInfoPO newPagePO, @Nullable PageInfoPO groupPO, @NotNull Argus.MergeResult mergeResult) {
        Intrinsics.checkNotNullParameter(newPage, "newPage");
        Intrinsics.checkNotNullParameter(newPagePO, "newPagePO");
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
        r();
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPredictResult(@Nullable PageInfo currentPageInfo, @NotNull List<? extends HistoryPageChange> historyPageChanges) {
        Intrinsics.checkNotNullParameter(historyPageChanges, "historyPageChanges");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        TianShuAccess.AdItem adItem;
        if (event instanceof AIOHideEvent) {
            AIOHideEvent aIOHideEvent = (AIOHideEvent) event;
            if (!Intrinsics.areEqual(aIOHideEvent.getUin(), "0")) {
                if ((aIOHideEvent.getUinType() == 1 || aIOHideEvent.getUinType() == 2) && (adItem = this.adItem) != null) {
                    B(aIOHideEvent, adItem);
                }
            }
        }
    }

    public final void y() {
        this.appOnBack = true;
        this.conversationTabFirstShowTime = 0L;
    }

    public final void z() {
        this.appOnBack = false;
        r();
    }
}
