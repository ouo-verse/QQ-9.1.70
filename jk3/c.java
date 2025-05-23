package jk3;

import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.room.impl.constant.ZPlanJoinRoomType;
import com.tencent.mobileqq.zplan.room.impl.constant.ZPlanRoomInitData;
import com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler;
import com.tencent.mobileqq.zplan.room.impl.trtc.ZPlanTRTCRoomParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.w;
import gk3.b;
import hk3.a;
import iv4.d;
import iv4.f;
import iv4.k;
import iv4.l;
import iv4.m;
import java.util.ArrayList;
import java.util.List;
import jv4.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import lv4.j;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u00108\u001a\u00020\u0012\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0006\u0010!\u001a\u00020\u0007J\u001e\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0019J\u0010\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(J\b\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0012H\u0016J\u0006\u0010.\u001a\u00020\u0004J\u0016\u00102\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00122\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u00020\u0004J\u001a\u00106\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000404R\u0016\u00108\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010<R\u0018\u0010$\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010&\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010M\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010LR\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010LR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010LR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010Q\u00a8\u0006U"}, d2 = {"Ljk3/c;", "Lhk3/a;", "Lcom/tencent/mobileqq/zplan/room/impl/constant/a;", "roomInitData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "enable", "D", "immediately", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Llv4/j;", "result", "o", BdhLogUtil.LogTag.Tag_Conn, "", "msg", "w", "", "exception", "u", "b", "Liv4/f;", "c", "Lkv4/a;", "getSelfUserInfo", "Lhk3/b;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/room/impl/core/handler/ZPlanRoomListenerHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/mobileqq/zplan/room/impl/constant/ZPlanJoinRoomType;", "joinRoomType", "selfUserInfo", "r", "roomDetail", "E", "Liv4/l;", "speakerInfoList", UserInfo.SEX_FEMALE, "a", "openId", ReportConstant.COSTREPORT_PREFIX, "y", "netRequestSource", "", "errCode", "j", "k", "Lkotlin/Function1;", "callback", "l", "Ljava/lang/String;", "roomId", "Lcom/tencent/mobileqq/zplan/room/impl/core/handler/ZPlanRoomListenerHandler;", "listenerHandler", "Lcom/tencent/mobileqq/zplan/room/impl/core/handler/b;", "Lcom/tencent/mobileqq/zplan/room/impl/core/handler/b;", "operationHandler", "d", "Lkv4/a;", "e", "Liv4/f;", "f", "Liv4/l;", "", "g", "J", "curMaxActionId", h.F, "curMsgId", "i", "requestRoomDataGap", "Z", "enableGetRoomDataLoop", "isRequestingRoomData", "needRequestAfterFinish", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "requestRoomDataRunnable", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements hk3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ZPlanRoomListenerHandler listenerHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.room.impl.core.handler.b operationHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private kv4.a selfUserInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f roomDetail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private l speakerInfoList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long curMaxActionId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long curMsgId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long requestRoomDataGap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean enableGetRoomDataLoop;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestingRoomData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean needRequestAfterFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Runnable requestRoomDataRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"jk3/c$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/j;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<j> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f410351e;

        b(String str) {
            this.f410351e = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(j result) {
            Intrinsics.checkNotNullParameter(result, "result");
            c.this.isRequestingRoomData = false;
            if (c.this.t()) {
                c.this.o(result);
                c cVar = c.this;
                cVar.x(cVar.needRequestAfterFinish || result.f415656a || result.f415658c);
                c.this.needRequestAfterFinish = false;
                return;
            }
            c.v(c.this, "doGetRoomDataReq#success, but room invalid! curRequestRoomId= " + this.f410351e, null, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            c.this.isRequestingRoomData = false;
            c.v(c.this, "doGetRoomDataReq#onResultFailure, error= " + error + ", message= " + message, null, 2, null);
            if (!c.this.j("GetRoomData", error)) {
                c cVar = c.this;
                cVar.x(cVar.needRequestAfterFinish);
            }
            c.this.needRequestAfterFinish = false;
        }
    }

    public c(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.roomId = roomId;
        this.requestRoomDataGap = 10000L;
        this.requestRoomDataRunnable = new Runnable() { // from class: jk3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.B(c.this);
            }
        };
        this.operationHandler = new com.tencent.mobileqq.zplan.room.impl.core.handler.b(this, this.roomId, this);
        ZPlanRoomListenerHandler zPlanRoomListenerHandler = new ZPlanRoomListenerHandler(this.roomId);
        this.listenerHandler = zPlanRoomListenerHandler;
        w("init### roomId= " + this.roomId + ", operationHandler= " + this.operationHandler + ", listenerHandler= " + zPlanRoomListenerHandler);
    }

    private final void A() {
        try {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.requestRoomDataRunnable);
        } catch (Exception e16) {
            u("removeLoopRunnable error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z();
    }

    private final void C() {
        w("resetParams - " + this.roomId + " - " + this);
        this.roomId = "";
        this.requestRoomDataGap = 10000L;
        D(false);
        this.isRequestingRoomData = false;
        this.needRequestAfterFinish = false;
        this.operationHandler = null;
        ZPlanRoomListenerHandler zPlanRoomListenerHandler = this.listenerHandler;
        if (zPlanRoomListenerHandler != null) {
            zPlanRoomListenerHandler.d();
        }
        this.listenerHandler = null;
        this.selfUserInfo = null;
    }

    private final void D(boolean enable) {
        if (this.enableGetRoomDataLoop != enable) {
            w("setLoopEnable - " + enable);
            this.enableGetRoomDataLoop = enable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(j result) {
        Long l3;
        jv4.j jVar;
        Long l16;
        jv4.f fVar;
        jv4.f fVar2;
        jv4.e[] eVarArr;
        jv4.e[] eVarArr2;
        i[] iVarArr;
        Object lastOrNull;
        i iVar;
        jv4.e[] eVarArr3;
        Object lastOrNull2;
        jv4.f fVar3 = result.f415657b;
        Integer num = null;
        if (fVar3 != null && (eVarArr3 = fVar3.f411028a) != null) {
            lastOrNull2 = ArraysKt___ArraysKt.lastOrNull(eVarArr3);
            jv4.e eVar = (jv4.e) lastOrNull2;
            if (eVar != null) {
                l3 = Long.valueOf(eVar.f411019a);
                jVar = result.f415659d;
                if (jVar != null && (iVarArr = jVar.f411038a) != null) {
                    lastOrNull = ArraysKt___ArraysKt.lastOrNull(iVarArr);
                    iVar = (i) lastOrNull;
                    if (iVar != null) {
                        l16 = Long.valueOf(iVar.f411035a);
                        boolean z16 = result.f415656a;
                        boolean z17 = result.f415658c;
                        fVar = result.f415657b;
                        if (fVar != null && (eVarArr2 = fVar.f411028a) != null) {
                            num = Integer.valueOf(eVarArr2.length);
                        }
                        w("doGetRoomDataReq#success, lastActionId= " + l3 + ", lastMsgId= " + l16 + ", hasMoreAction= " + z16 + ", hasMoreMsg= " + z17 + ", actionListSize= " + num);
                        if (l3 != null) {
                            this.curMaxActionId = l3.longValue();
                        }
                        if (l16 != null) {
                            this.curMsgId = l16.longValue();
                        }
                        fVar2 = result.f415657b;
                        if (fVar2 == null || (eVarArr = fVar2.f411028a) == null) {
                            return;
                        }
                        for (jv4.e it : eVarArr) {
                            com.tencent.mobileqq.zplan.room.impl.core.handler.a aVar = com.tencent.mobileqq.zplan.room.impl.core.handler.a.f335173a;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            aVar.a(it, this);
                        }
                        return;
                    }
                }
                l16 = null;
                boolean z162 = result.f415656a;
                boolean z172 = result.f415658c;
                fVar = result.f415657b;
                if (fVar != null) {
                    num = Integer.valueOf(eVarArr2.length);
                }
                w("doGetRoomDataReq#success, lastActionId= " + l3 + ", lastMsgId= " + l16 + ", hasMoreAction= " + z162 + ", hasMoreMsg= " + z172 + ", actionListSize= " + num);
                if (l3 != null) {
                }
                if (l16 != null) {
                }
                fVar2 = result.f415657b;
                if (fVar2 == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        l3 = null;
        jVar = result.f415659d;
        if (jVar != null) {
            lastOrNull = ArraysKt___ArraysKt.lastOrNull(iVarArr);
            iVar = (i) lastOrNull;
            if (iVar != null) {
            }
        }
        l16 = null;
        boolean z1622 = result.f415656a;
        boolean z1722 = result.f415658c;
        fVar = result.f415657b;
        if (fVar != null) {
        }
        w("doGetRoomDataReq#success, lastActionId= " + l3 + ", lastMsgId= " + l16 + ", hasMoreAction= " + z1622 + ", hasMoreMsg= " + z1722 + ", actionListSize= " + num);
        if (l3 != null) {
        }
        if (l16 != null) {
        }
        fVar2 = result.f415657b;
        if (fVar2 == null) {
        }
    }

    private final void p() {
        w("initCheckTRTC");
        b.C10383b.a((gk3.b) vb3.a.f441346a.a(gk3.b.class), ZPlanTRTCRoomParam.INSTANCE.a(this), null, 2, null);
    }

    private final void q(ZPlanRoomInitData roomInitData) {
        this.curMaxActionId = roomInitData.getMaxActionId();
        E(roomInitData.getRoomDetail());
        F(roomInitData.getSpeakerInfoList());
        D(true);
        x(true);
    }

    private final void u(String msg2, Throwable exception) {
        QLog.e("ZPlanRoom_Manager", 1, msg2, exception);
    }

    private final void w(String msg2) {
        QLog.i("ZPlanRoom_Manager", 1, msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(boolean immediately) {
        A();
        if (this.enableGetRoomDataLoop) {
            long j3 = this.requestRoomDataGap;
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.requestRoomDataRunnable;
            if (immediately) {
                j3 = 0;
            }
            uIHandlerV2.postDelayed(runnable, j3);
        }
    }

    private final void z() {
        Long longOrNull;
        iv4.b bVar;
        String str = null;
        if (!t()) {
            v(this, "realGetRoomData but roomId is empty", null, 2, null);
            return;
        }
        if (this.isRequestingRoomData) {
            this.needRequestAfterFinish = true;
            w("realGetRoomData but isRequestingRoomData, wait next");
            return;
        }
        String str2 = this.roomId;
        lv4.i iVar = new lv4.i();
        f fVar = this.roomDetail;
        iVar.f415652a = fVar != null ? fVar.f408821a : null;
        iVar.f415655d = this.curMsgId;
        iVar.f415654c = this.curMaxActionId;
        kv4.a aVar = new kv4.a();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(w.f373306a.b());
        aVar.f413322a = longOrNull != null ? longOrNull.longValue() : 0L;
        iVar.f415653b = aVar;
        this.isRequestingRoomData = true;
        iv4.e eVar = iVar.f415652a;
        if (eVar != null && (bVar = eVar.f408820a) != null) {
            str = bVar.f408810a;
        }
        w("doGetRoomDataReq#BEGIN, roomId= " + str + ", curActionId= " + iVar.f415654c + ", curMsgId= " + iVar.f415655d);
        lk3.a.j(lk3.a.f414963a, iVar, new b(str2), 0, 4, null);
    }

    public final void E(f roomDetail) {
        iv4.a aVar;
        int i3;
        Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
        this.roomDetail = roomDetail;
        d dVar = roomDetail.f408823c;
        if (dVar == null || (aVar = dVar.f408819a) == null || (i3 = aVar.f408805a) <= 0) {
            return;
        }
        long j3 = i3 * 1000;
        if (j3 != this.requestRoomDataGap) {
            w("updateRoomInfo, requestRoomDataGap = " + i3);
            this.requestRoomDataGap = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r5 = kotlin.collections.ArraysKt___ArraysKt.toList(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(l speakerInfoList) {
        gk3.c proxyCommonListener;
        List<k> arrayList;
        l lVar = this.speakerInfoList;
        w("updateSpeakerInfoList - curVersion= " + (lVar != null ? Integer.valueOf(lVar.f408835b) : null) + ", newVersion= " + (speakerInfoList != null ? Integer.valueOf(speakerInfoList.f408835b) : null));
        this.speakerInfoList = speakerInfoList;
        ZPlanRoomListenerHandler zPlanRoomListenerHandler = this.listenerHandler;
        if (zPlanRoomListenerHandler == null || (proxyCommonListener = zPlanRoomListenerHandler.getProxyCommonListener()) == null) {
            return;
        }
        if (speakerInfoList == null || (r5 = speakerInfoList.f408834a) == null || arrayList == null) {
            arrayList = new ArrayList<>();
        }
        proxyCommonListener.a(arrayList);
    }

    @Override // hk3.a
    public boolean a() {
        String str = getSelfUserInfo().f413323b;
        Intrinsics.checkNotNullExpressionValue(str, "getSelfUserInfo().openId");
        return s(str);
    }

    @Override // hk3.a
    /* renamed from: b, reason: from getter */
    public String getRoomId() {
        return this.roomId;
    }

    @Override // hk3.a
    /* renamed from: c, reason: from getter */
    public f getRoomDetail() {
        return this.roomDetail;
    }

    @Override // hk3.a
    public kv4.a getSelfUserInfo() {
        kv4.a aVar = this.selfUserInfo;
        return aVar == null ? a.C10446a.c(this) : aVar;
    }

    public final boolean j(String netRequestSource, int errCode) {
        Intrinsics.checkNotNullParameter(netRequestSource, "netRequestSource");
        switch (errCode) {
            case 9000001:
            case 9000002:
                v(this, netRequestSource + ", checkHandleNotInRoomErrCode: " + errCode, null, 2, null);
                a.f410333a.g(getRoomId());
                return true;
            default:
                return false;
        }
    }

    public final void k() {
        gk3.c proxyCommonListener;
        w("destroy - " + this.roomId + " - " + this);
        ZPlanRoomListenerHandler zPlanRoomListenerHandler = this.listenerHandler;
        if (zPlanRoomListenerHandler != null && (proxyCommonListener = zPlanRoomListenerHandler.getProxyCommonListener()) != null) {
            proxyCommonListener.c(this.roomId);
        }
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).exitRoom();
        C();
        A();
    }

    public final void l(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        w("exitRoomCheck");
        D(false);
        A();
        callback.invoke(Boolean.TRUE);
    }

    /* renamed from: m, reason: from getter */
    public final ZPlanRoomListenerHandler getListenerHandler() {
        return this.listenerHandler;
    }

    public final hk3.b n() {
        return this.operationHandler;
    }

    public final void r(ZPlanJoinRoomType joinRoomType, kv4.a selfUserInfo, ZPlanRoomInitData roomInitData) {
        Intrinsics.checkNotNullParameter(joinRoomType, "joinRoomType");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        Intrinsics.checkNotNullParameter(roomInitData, "roomInitData");
        String str = this.roomId;
        long maxActionId = roomInitData.getMaxActionId();
        l speakerInfoList = roomInitData.getSpeakerInfoList();
        w("initWhenJoinOrResume - " + str + ", joinRoomType= " + joinRoomType + ", maxActionId= " + maxActionId + ", speakListVersion= " + (speakerInfoList != null ? Integer.valueOf(speakerInfoList.f408835b) : null) + ", selfUserInfo= " + selfUserInfo + ", - " + this);
        this.selfUserInfo = selfUserInfo;
        q(roomInitData);
        p();
    }

    public boolean s(String openId) {
        k[] kVarArr;
        k kVar;
        m mVar;
        iv4.i iVar;
        Intrinsics.checkNotNullParameter(openId, "openId");
        l lVar = this.speakerInfoList;
        if (lVar == null || (kVarArr = lVar.f408834a) == null) {
            return false;
        }
        int length = kVarArr.length;
        int i3 = 0;
        while (true) {
            kVar = null;
            if (i3 >= length) {
                break;
            }
            k kVar2 = kVarArr[i3];
            kv4.a aVar = kVar2.f408831a;
            if (Intrinsics.areEqual(aVar != null ? aVar.f413323b : null, openId)) {
                kVar = kVar2;
                break;
            }
            i3++;
        }
        return (kVar == null || (mVar = kVar.f408833c) == null || (iVar = mVar.f408836a) == null || iVar.f408827a != 0) ? false : true;
    }

    public final boolean t() {
        return !TextUtils.isEmpty(this.roomId);
    }

    public final void y() {
        w("loopGetRoomDataAfterDoCmd");
        x(true);
    }

    static /* synthetic */ void v(c cVar, String str, Throwable th5, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            th5 = null;
        }
        cVar.u(str, th5);
    }
}
