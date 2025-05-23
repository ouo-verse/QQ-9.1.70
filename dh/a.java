package dh;

import android.text.TextUtils;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.event.QZoneClearQcircleDynamicRedDotEvent;
import com.qzone.reborn.util.i;
import com.qzone.reborn.util.k;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u001d\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tJ\u0010\u0010\u001f\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a8\u0006\""}, d2 = {"Ldh/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/tianshu/event/TianshuRedDataChangeEvent;", "event", "", "f", "d", "a", "", "isVisible", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "e", "b", "o", "p", "c", "k", "j", "l", "Landroid/view/View;", "view", "isLebaMode", DomainData.DOMAIN_NAME, h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final a f393805d = new a();

    a() {
    }

    private final void a() {
        if (i.b().d("qzone_album_entrance_red_dot_label", false) && QZoneFeedAlertService.getInstance().getSingleUnreadCount(19) == 1) {
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(19);
            QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "clearAlbumEntranceUnreadCountCacheData");
        }
    }

    private final void d() {
        boolean e16 = e();
        k(e16);
        if (e16) {
            boolean o16 = o();
            boolean p16 = p();
            if (!o16 && !p16) {
                QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "fetchQzoneDynamicEntranceRedDotInfo, save new red dot");
                j(true);
                l(true);
                i(true);
                m(true);
                return;
            }
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "fetchQzoneDynamicEntranceRedDotInfo, inner has red dot | showAlbumEntranceRedDot=" + o16 + " | showQcircleEntranceRedDot=" + p16);
        }
    }

    private final void i(boolean isVisible) {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveAlbumEntranceGuideBubble, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveAlbumEntranceGuideBubble, isVisible=" + isVisible);
        i.b().l("qzone_album_entrance_guide_bubble_label", isVisible);
    }

    private final void m(boolean isVisible) {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveQcircleEntranceGuideBubble, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveQcircleEntranceGuideBubble, isVisible=" + isVisible);
        i.b().l("qzone_qcircle_album_entrance_guide_bubble_label", isVisible);
    }

    public final void b() {
        if (!km.a.f412646a.a()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "clearQzoneDynamicEntranceRedDot, is not main process, dispatchEvent");
            SimpleEventBus.getInstance().dispatchEvent(new QZoneClearQcircleDynamicRedDotEvent(), true);
        } else {
            if (!e()) {
                QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "clearQzoneDynamicEntranceRedDot, is not hasDynamicRedDot");
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            ((IRedTouchManager) runtimeService).reportLevelOneRedInfo(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN, 31);
            QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "clearQzoneDynamicEntranceRedDot, 10000");
        }
    }

    public final boolean c() {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "dynamicEntranceRedDotIsVisible, disableQZoneAlbumQcircleRedDot");
            return false;
        }
        if (km.a.f412646a.a()) {
            return e();
        }
        return i.b().d("qzone_dynamic_entrance_red_dot_label", false);
    }

    public final boolean e() {
        AppRuntime peekAppRuntime;
        boolean z16 = false;
        if (!km.a.f412646a.a() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) runtimeService).getAppInfoByPath(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
        if (appInfoByPath == null) {
            return false;
        }
        if (appInfoByPath.iNewFlag.get() == 0) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "findIsHasDynamicRedDot, appInfo.iNewFlag.get() == 0");
            return false;
        }
        if (TextUtils.isEmpty(appInfoByPath.extend.get())) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "findIsHasDynamicRedDot, appInfo.extend == null");
            return false;
        }
        try {
            z16 = Intrinsics.areEqual(new JSONObject(appInfoByPath.extend.get()).optString("busi_id"), "tinyworld_guide");
        } catch (Exception e16) {
            QLog.e("QZ_QFS_QZoneQcircleRedDotManager", 1, "findIsHasDynamicRedDot, e=" + e16);
        }
        QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "findIsHasDynamicRedDot | appInfo.extend=" + appInfoByPath.extend.get() + " | hasDynamicRedDot=" + z16);
        return z16;
    }

    public final void g() {
        SimpleEventBus.getInstance().registerReceiver(this);
        QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "init, registerReceiver");
        d();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TianshuRedDataChangeEvent.class);
        arrayList.add(QZoneClearQcircleDynamicRedDotEvent.class);
        return arrayList;
    }

    public final boolean h() {
        return i.b().d("qzone_qcircle_album_entrance_guide_bubble_label", false);
    }

    public final void j(boolean isVisible) {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveAlbumEntranceRedDotVisible, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveAlbumEntranceRedDotVisible, isVisible=" + isVisible);
        if (!isVisible) {
            a();
            k(false);
            b();
        }
        i.b().l("qzone_album_entrance_red_dot_label", isVisible);
    }

    public final void k(boolean isVisible) {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveDynamicEntranceRedDotVisible, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveDynamicEntranceRedDotVisible, isVisible=" + isVisible);
        i.b().l("qzone_dynamic_entrance_red_dot_label", isVisible);
    }

    public final void l(boolean isVisible) {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveQcircleAlbumEntranceRedDotVisible, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "saveQcircleAlbumEntranceRedDotVisible, isVisible=" + isVisible);
        i.b().l("qzone_qcircle_album_entrance_red_dot_label", isVisible);
        if (isVisible) {
            return;
        }
        j(false);
    }

    public final void n(View view, boolean isLebaMode) {
        g gVar = g.f53821a;
        if (gVar.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, view=" + view + ", isLebaMode=$");
        if (view == null) {
            QLog.e("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, view == null");
            return;
        }
        if (!o()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, not showAlbumEntranceRedDot");
            return;
        }
        if (k.f59549a.g()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, isTeenageMode");
        } else {
            if (!i.b().d("qzone_album_entrance_guide_bubble_label", false)) {
                QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, has already show");
                return;
            }
            QUIDefaultBubbleTip.r(view.getContext()).S(view).m0(1).o0(gVar.e().n()).R(1).k0(isLebaMode ? 1 : 0).i0(8.0f, isLebaMode ? -5.0f : 0.0f).f0(false).g0(false).b0(-1L).s0();
            i(false);
            QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceGuideBubble, show guide bubble");
        }
    }

    public final boolean o() {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceRedDot, disableQZoneAlbumQcircleRedDot");
            return false;
        }
        if (k.f59549a.g()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showAlbumEntranceRedDot, isTeenageMode");
            a();
            return false;
        }
        return i.b().d("qzone_album_entrance_red_dot_label", false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof TianshuRedDataChangeEvent) {
            f((TianshuRedDataChangeEvent) event);
        } else if ((event instanceof QZoneClearQcircleDynamicRedDotEvent) && km.a.f412646a.a()) {
            b();
        }
    }

    public final boolean p() {
        if (g.f53821a.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleAlbumEntranceRedDot, disableQZoneAlbumQcircleRedDot");
            return false;
        }
        if (k.f59549a.g()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleAlbumEntranceRedDot, isTeenageMode");
            return false;
        }
        return i.b().d("qzone_qcircle_album_entrance_red_dot_label", false);
    }

    public final void q(View view) {
        g gVar = g.f53821a;
        if (gVar.e().k()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, disableQZoneAlbumQcircleRedDot");
            return;
        }
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, view=" + view);
        if (view == null) {
            QLog.e("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, view == null");
            return;
        }
        if (!p()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, not showQcircleEntranceRedDot");
            return;
        }
        if (k.f59549a.g()) {
            QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, isTeenageMode");
        } else {
            if (!h()) {
                QLog.w("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, has already show");
                return;
            }
            QUIDefaultBubbleTip.r(view.getContext()).S(view).m0(1).o0(gVar.e().o()).R(0).k0(0).f0(false).g0(false).b0(-1L).s0();
            m(false);
            QLog.i("QZ_QFS_QZoneQcircleRedDotManager", 1, "showQcircleEntranceGuideBubble, show guide bubble");
        }
    }

    private final void f(TianshuRedDataChangeEvent event) {
        QLog.d("QZ_QFS_QZoneQcircleRedDotManager", 1, "handleTianshuRedDataChangeEvent, receive event");
        if (bl.b(event.getList())) {
            return;
        }
        d();
    }
}
