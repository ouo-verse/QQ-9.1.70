package com.tencent.qqnt.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.clockin.ClockMsgIntent;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.together.ui.TogetherPanel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.TroopBirthGiftHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInStatusRsp;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInWriteRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\tH\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00101R'\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0013038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b5\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ClockHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", tl.h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "k", DomainData.DOMAIN_NAME, "", "sourceType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "", "isClockIn", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "troopUin", "", "i", "clockInTime", "t", "r", "getId", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "o", "p", "source", "u", "getTag", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Ljava/lang/String;", "mTroopUin", "f", "Z", "mIsFirstResume", "Lcom/tencent/mobileqq/together/ui/TogetherPanel;", "Lcom/tencent/mobileqq/together/ui/TogetherPanel;", "mTogetherPanel", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Lazy;", "j", "()Ljava/util/concurrent/ConcurrentHashMap;", "mClockInTimeCache", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mvi/base/route/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/a;", "mAction1", "Lcom/tencent/mobileqq/troop/clockin/api/b;", "D", "Lcom/tencent/mobileqq/troop/clockin/api/b;", "mTroopClockInObserver", "<init>", "()V", "E", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ClockHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.mobileqq.troop.clockin.api.b mTroopClockInObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstResume = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TogetherPanel mTogetherPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mClockInTimeCache;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/ClockHelper$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            ClockHelper.this.k(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/aio/helper/ClockHelper$c", "Lcom/tencent/mobileqq/troop/clockin/api/b;", "", "isSuccess", "", "troopUin", "memberUin", "", "data", "", "sourceType", "", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.troop.clockin.api.b {
        c() {
        }

        @Override // com.tencent.mobileqq.troop.clockin.api.b
        protected void a(boolean isSuccess, String troopUin, String memberUin, Object data, int sourceType) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(data, "data");
            if (isSuccess && (data instanceof oidb_0xeb7$StSignInStatusRsp)) {
                oidb_0xeb7$StSignInStatusRsp oidb_0xeb7_stsigninstatusrsp = (oidb_0xeb7$StSignInStatusRsp) data;
                if (oidb_0xeb7_stsigninstatusrsp.ret.code.get() != 0) {
                    QLog.d("ClockHelper", 1, "onGetClockInStatus error code: " + oidb_0xeb7_stsigninstatusrsp.ret.code.get() + " msg:" + oidb_0xeb7_stsigninstatusrsp.ret.f435998msg.get());
                    return;
                }
                boolean z16 = oidb_0xeb7_stsigninstatusrsp.base.get().status.get() == 1;
                if (QLog.isColorLevel()) {
                    QLog.d("ClockHelper", 2, "onGetClockInStatus hasSignedIn: " + z16);
                }
                if (Intrinsics.areEqual(troopUin, ClockHelper.this.mTroopUin)) {
                    ClockHelper.this.w(z16);
                }
                if (z16) {
                    List<String> list = oidb_0xeb7_stsigninstatusrsp.doneInfo.get().belowPortraitWords.get();
                    Intrinsics.checkNotNullExpressionValue(list, "data.doneInfo.get().belowPortraitWords.get()");
                    try {
                        ClockHelper.this.t(troopUin, Long.parseLong(list.get(1)));
                        return;
                    } catch (Exception e16) {
                        QLog.d("ClockHelper", 1, e16, new Object[0]);
                        return;
                    }
                }
                return;
            }
            QLog.d("ClockHelper", 1, "onGetClockInStatus failed");
        }

        @Override // com.tencent.mobileqq.troop.clockin.api.b
        protected void b(boolean isSuccess, String troopUin, String memberUin, Object data) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(data, "data");
            if (isSuccess && (data instanceof oidb_0xeb7$StSignInWriteRsp)) {
                oidb_0xeb7$StSignInWriteRsp oidb_0xeb7_stsigninwritersp = (oidb_0xeb7$StSignInWriteRsp) data;
                if (oidb_0xeb7_stsigninwritersp.ret.code.get() != 0) {
                    QLog.d("ClockHelper", 1, "onSetClockInStatus error code: " + oidb_0xeb7_stsigninwritersp.ret.code.get() + " msg: " + oidb_0xeb7_stsigninwritersp.ret.f435998msg.get());
                    return;
                }
                boolean has = oidb_0xeb7_stsigninwritersp.doneInfo.has();
                if (QLog.isColorLevel()) {
                    QLog.d("ClockHelper", 2, "onSetClockInStatus isDoneClockIn: " + has);
                }
                if (Intrinsics.areEqual(troopUin, ClockHelper.this.mTroopUin)) {
                    ClockHelper.this.w(has);
                }
                if (has) {
                    List<String> list = oidb_0xeb7_stsigninwritersp.doneInfo.get().belowPortraitWords.get();
                    Intrinsics.checkNotNullExpressionValue(list, "data.doneInfo.get().belowPortraitWords.get()");
                    try {
                        ClockHelper.this.t(troopUin, Long.parseLong(list.get(1)));
                        return;
                    } catch (Exception e16) {
                        QLog.d("ClockHelper", 1, e16, new Object[0]);
                        return;
                    }
                }
                return;
            }
            QLog.d("ClockHelper", 1, "onSetClockInStatus failed");
        }
    }

    public ClockHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, Long>>() { // from class: com.tencent.qqnt.aio.helper.ClockHelper$mClockInTimeCache$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, Long> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.mClockInTimeCache = lazy;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.entity = from;
        this.mAction1 = new b();
        this.mTroopClockInObserver = new c();
    }

    private final void h() {
        Fragment c16;
        FragmentActivity activity;
        Intent intent;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (c16 = aVar.c()) == null || (activity = c16.getActivity()) == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra(AppConstants.Key.KEY_OPEN_TOGETHER_PANEL, false)) {
            return;
        }
        intent.putExtra(AppConstants.Key.KEY_OPEN_TOGETHER_PANEL, false);
        u(3);
    }

    private final long i(String troopUin) {
        if (TextUtils.isEmpty(troopUin)) {
            return 0L;
        }
        if (!j().containsKey(troopUin)) {
            j().put(troopUin, Long.valueOf(this.entity.decodeLong(QMMKVFile.getKeyWithUin("ClockInTime", troopUin), 0L)));
        }
        Long l3 = j().get(troopUin);
        Intrinsics.checkNotNull(l3);
        return l3.longValue();
    }

    private final ConcurrentHashMap<String, Long> j() {
        return (ConcurrentHashMap) this.mClockInTimeCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(MsgIntent intent) {
        if (intent instanceof AIOTitleEvent.Right2IvClickEvent) {
            n();
        } else if (intent instanceof ClockMsgIntent.ShowTroopClockDialogMsgIntent) {
            q(((ClockMsgIntent.ShowTroopClockDialogMsgIntent) intent).getSourceType());
        }
    }

    private final boolean m() {
        if (TextUtils.isEmpty(this.mTroopUin)) {
            return false;
        }
        String str = this.mTroopUin;
        Intrinsics.checkNotNull(str);
        long i3 = i(str);
        if (i3 <= 0) {
            return false;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (i3 > serverTime) {
            return true;
        }
        long j3 = 86400;
        return ((int) ((serverTime / j3) - (i3 / j3))) == 0;
    }

    private final void q(int sourceType) {
        u(sourceType);
        v(sourceType);
    }

    private final void r() {
        if (new Random().nextInt(1000) != 237) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.am
            @Override // java.lang.Runnable
            public final void run() {
                ClockHelper.s(ClockHelper.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ClockHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        HashMap hashMap = new HashMap();
        String str = this$0.mTroopUin;
        if (str == null) {
            str = "";
        }
        hashMap.put("qq_group_num", str);
        if (appInterface != null && !TextUtils.isEmpty(appInterface.getCurrentAccountUin())) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            hashMap.put("A8", currentAccountUin);
        }
        ClockReportUtil.a("play#aio_icon_video", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("gift_type", QCircleDaTongConstant.ElementParamValue.ORDINARY);
        TroopBirthGiftHelper.INSTANCE.p("17", "daka", "", "4", 101, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(String troopUin, long clockInTime) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ClockHelper", 4, "setClockInTime " + clockInTime);
        }
        if (TextUtils.isEmpty(troopUin) || clockInTime == 0) {
            return;
        }
        if (j().containsKey(troopUin)) {
            Long l3 = j().get(troopUin);
            Intrinsics.checkNotNull(l3);
            if (clockInTime == l3.longValue()) {
                return;
            }
        }
        j().put(troopUin, Long.valueOf(clockInTime));
        this.entity.encodeLong(QMMKVFile.getKeyWithUin("ClockInTime", troopUin), clockInTime);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350625d;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.Right2IvClickEvent");
        hashSet.add("com.tencent.mobileqq.together.clockin.ClockMsgIntent.ShowTroopClockDialogMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "ClockHelper";
    }

    public final void o() {
        if (this.mIsFirstResume) {
            this.mIsFirstResume = false;
            w(m());
            r();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Intrinsics.checkNotNull(a16);
        this.mTroopUin = a16.g().r().c().j();
        this.mIsFirstResume = true;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Intrinsics.checkNotNull(aVar);
        aVar.e().f(this, this.mAction1);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            appInterface.addObserver(this.mTroopClockInObserver);
        }
        QLog.d("ClockHelper", 1, "onCreate param:" + param);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction1);
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            appInterface.removeObserver(this.mTroopClockInObserver);
        }
        TogetherPanel togetherPanel = this.mTogetherPanel;
        if (togetherPanel != null) {
            togetherPanel.c();
        }
        this.mTogetherPanel = null;
        this.mAIOContext = null;
        this.mTroopUin = null;
        this.mIsFirstResume = true;
        j().clear();
        QLog.d("ClockHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public final void p() {
        h();
    }

    public final void u(int source) {
        QLog.d("ClockHelper", 1, "showTogetherPanel source:" + source);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Intrinsics.checkNotNull(aVar);
        FragmentActivity requireActivity = aVar.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mAIOContext!!.fragment.requireActivity()");
        if (this.mTogetherPanel == null) {
            this.mTogetherPanel = new TogetherPanel(requireActivity);
        }
        TogetherPanel togetherPanel = this.mTogetherPanel;
        Intrinsics.checkNotNull(togetherPanel);
        togetherPanel.e(this.mTroopUin, source);
    }

    private final void n() {
        u(1);
        final HashMap hashMap = new HashMap();
        TroopBirthGiftHelper.Companion companion = TroopBirthGiftHelper.INSTANCE;
        String str = this.mTroopUin;
        if (str == null) {
            str = "";
        }
        companion.i(str, new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.aio.helper.ClockHelper$onClockClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                hashMap.put("gift_type", z16 ? "birthday" : QCircleDaTongConstant.ElementParamValue.ORDINARY);
                TroopBirthGiftHelper.INSTANCE.p("17", "daka", "", "4", 102, hashMap);
                ReportController.o(null, "dc00898", "", "", "0X800C2CA", "0X800C2CA", 0, 0, "", "2", "", "");
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{4, 3, 6, 12};
    }

    private final void v(int sourceType) {
        String str;
        if (sourceType == 2 || (str = this.mTroopUin) == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_group_num", str);
        hashMap.put("A8", currentAccountUin);
        ClockReportUtil.a("click#aio_graybar", hashMap);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            p();
        } else if (state == 4) {
            o();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(boolean isClockIn) {
    }
}
