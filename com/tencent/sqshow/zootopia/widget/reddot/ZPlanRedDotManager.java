package com.tencent.sqshow.zootopia.widget.reddot;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.push.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import com.tencent.sqshow.zootopia.data.ZootopiaMainRecommendListData;
import com.tencent.sqshow.zootopia.data.q;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager$repoListener$2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import xv4.y;
import yb4.l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004J\u001b\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001d\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0006\u0010\"\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0002R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010?R\u0016\u0010B\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotManager;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "scene", "Lcom/tencent/sqshow/zootopia/widget/reddot/a;", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/widget/reddot/c;", "statusListener", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "reddotId", "Lgv4/e;", "l", "", "templateTab", h.F, "dataType", "i", "", "Luv4/h;", "ids", "g", "([Luv4/h;)V", "", "isAppend", "y", "(I[Ljava/lang/Integer;Z)V", "t", "([Ljava/lang/Integer;Z)V", "Lcom/tencent/sqshow/zootopia/data/k;", "zootopiaPortalRedDotData", "w", HippyTKDListViewAdapter.X, "v", "rewardType", ReportConstant.COSTREPORT_PREFIX, "p", "Lyb4/l;", "b", "Lyb4/l;", "service", "", "c", "Ljava/util/List;", "reddotStatusListeners", "Lcom/tencent/sqshow/zootopia/widget/reddot/e;", "d", "Lkotlin/Lazy;", "k", "()Lcom/tencent/sqshow/zootopia/widget/reddot/e;", "portalRepo", "Lcom/tencent/sqshow/zootopia/widget/reddot/d;", "e", "j", "()Lcom/tencent/sqshow/zootopia/widget/reddot/d;", "avatarRepo", "Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "f", "o", "()Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "repoListener", "I", "MAX_UPDATE_INTERVAL", "J", WadlProxyConsts.LAST_UPDATE_TIME, "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRedDotManager {

    /* renamed from: a */
    public static final ZPlanRedDotManager f373437a = new ZPlanRedDotManager();

    /* renamed from: b, reason: from kotlin metadata */
    private static final l service = new l(1);

    /* renamed from: c, reason: from kotlin metadata */
    private static List<c> reddotStatusListeners = new ArrayList();

    /* renamed from: d, reason: from kotlin metadata */
    private static final Lazy portalRepo;

    /* renamed from: e, reason: from kotlin metadata */
    private static final Lazy avatarRepo;

    /* renamed from: f, reason: from kotlin metadata */
    private static final Lazy repoListener;

    /* renamed from: g, reason: from kotlin metadata */
    private static final int MAX_UPDATE_INTERVAL;

    /* renamed from: h */
    private static long lastUpdateTime;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotManager$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxv4/y;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<y> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(y result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZplanRedDotManager", 1, "report succ, result:" + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZplanRedDotManager", 1, "report failed, error:" + error + ", message:" + message);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager$portalRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                b o16;
                o16 = ZPlanRedDotManager.f373437a.o();
                return new e(o16);
            }
        });
        portalRepo = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager$avatarRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                b o16;
                o16 = ZPlanRedDotManager.f373437a.o();
                return new d(o16);
            }
        });
        avatarRepo = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanRedDotManager$repoListener$2.a>() { // from class: com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager$repoListener$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotManager$repoListener$2$a", "Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "Lcom/tencent/sqshow/zootopia/data/q;", "result", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements b {
                a() {
                }

                @Override // com.tencent.sqshow.zootopia.widget.reddot.b
                public void a(q result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZPlanRedDotManager.f373437a.q();
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        repoListener = lazy3;
        MAX_UPDATE_INTERVAL = 2000;
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.F2(new a());
        }
    }

    ZPlanRedDotManager() {
    }

    private final d j() {
        return (d) avatarRepo.getValue();
    }

    private final e k() {
        return (e) portalRepo.getValue();
    }

    public final com.tencent.sqshow.zootopia.widget.reddot.b o() {
        return (com.tencent.sqshow.zootopia.widget.reddot.b) repoListener.getValue();
    }

    public final void q() {
        Iterator<T> it = reddotStatusListeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a();
        }
    }

    public final void g(uv4.h[] ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        j().d(ids);
    }

    public final void h(long j3) {
        k().f(j3);
    }

    public final void i(int dataType) {
        k().g(dataType);
    }

    public final gv4.e l(int reddotId, @RedDotScene int scene) {
        com.tencent.sqshow.zootopia.widget.reddot.a n3 = n(scene);
        if (n3 != null) {
            return n3.b(reddotId);
        }
        return null;
    }

    public final void s(int i3) {
        QLog.d("ZplanRedDotManager", 1, "reportBubbleClick, rewardType" + i3);
        service.n(i3, new b());
    }

    public final void t(Integer[] ids, boolean isAppend) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        y(1, ids, isAppend);
    }

    public final void v() {
        j().g();
    }

    public final void w(ZootopiaMainRecommendListData zootopiaPortalRedDotData) {
        k().j(zootopiaPortalRedDotData);
    }

    public final void x() {
        k().k();
    }

    public final void y(int scene, Integer[] ids, boolean isAppend) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        com.tencent.sqshow.zootopia.widget.reddot.a n3 = n(scene);
        if (n3 != null) {
            n3.a(ids, isAppend);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotManager$a", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends i {
        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            mv4.e c16 = mv4.e.c(buf);
            Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(buf)");
            QLog.d("ZplanRedDotManager", 1, "receive push " + c16.f417675a + " ");
            int i3 = c16.f417675a;
            if (i3 == 1 || i3 == 3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ZPlanRedDotManager.lastUpdateTime > ZPlanRedDotManager.MAX_UPDATE_INTERVAL) {
                    ZPlanRedDotManager.lastUpdateTime = currentTimeMillis;
                    ZPlanRedDotManager.f373437a.x();
                }
            }
        }

        a() {
            super(337);
        }
    }

    public final void p() {
        QLog.i("ZplanRedDotManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager$onDestroy$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                list = ZPlanRedDotManager.reddotStatusListeners;
                list.clear();
            }
        });
    }

    public final void A(c cVar) {
        if (cVar == null) {
            return;
        }
        reddotStatusListeners.remove(cVar);
    }

    public final void r(c statusListener) {
        if (statusListener == null || reddotStatusListeners.contains(statusListener)) {
            return;
        }
        reddotStatusListeners.add(statusListener);
    }

    public static /* synthetic */ gv4.e m(ZPlanRedDotManager zPlanRedDotManager, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 1;
        }
        return zPlanRedDotManager.l(i3, i16);
    }

    public static /* synthetic */ void u(ZPlanRedDotManager zPlanRedDotManager, Integer[] numArr, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanRedDotManager.t(numArr, z16);
    }

    public static /* synthetic */ void z(ZPlanRedDotManager zPlanRedDotManager, int i3, Integer[] numArr, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        zPlanRedDotManager.y(i3, numArr, z16);
    }

    private final com.tencent.sqshow.zootopia.widget.reddot.a n(@RedDotScene int i3) {
        if (i3 == 0) {
            return k();
        }
        if (i3 != 1) {
            return null;
        }
        return j();
    }
}
