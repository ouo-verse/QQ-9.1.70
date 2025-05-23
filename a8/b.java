package a8;

import NS_MOBILE_BITMAP_4TH.bmp4_get_rsp;
import NS_MOBILE_BITMAP_4TH.bmp4_values;
import NS_MOBILE_MAIN_PAGE.mobile_sub_concern_push_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_concern_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_getspaceright_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_setspaceright_req;
import NS_MOBILE_MAIN_PAGE.mobile_sub_setspaceright_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_setuncare_rsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneAutherRequest;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.common.protocol.request.QZoneSpecialFollowPushRequest;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.videorecommend.model.QzoneIsPublicRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.e;
import com.qzone.misc.network.report.f;
import com.qzone.permissionsetting.business.protocol.QZoneSetBlockRequest;
import com.qzone.permissionsetting.business.protocol.QZoneSetExcludeRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.ToastUtil;
import com.qzone.util.al;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.Collection;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends Observable implements IQZoneServiceListener {

    /* renamed from: f, reason: collision with root package name */
    private static final al<b, Void> f25632f = new a();

    /* renamed from: d, reason: collision with root package name */
    private final c f25633d;

    /* renamed from: e, reason: collision with root package name */
    private final c f25634e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<b, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Void r16) {
            return new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: a8.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class DialogInterfaceOnClickListenerC0020b implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean C;
        final /* synthetic */ int D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f25635d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f25636e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f25637f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f25638h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Handler f25639i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f25640m;

        DialogInterfaceOnClickListenerC0020b(long j3, int i3, int i16, Map map, Handler handler, String str, boolean z16, int i17) {
            this.f25635d = j3;
            this.f25636e = i3;
            this.f25637f = i16;
            this.f25638h = map;
            this.f25639i = handler;
            this.f25640m = str;
            this.C = z16;
            this.D = i17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(this.f25635d, this.f25636e, this.f25637f, this.f25638h), this.f25639i, b.this, 11);
            qZoneTask.addParameter("feeds_key", this.f25640m);
            qZoneTask.addParameter("is_follow", Boolean.valueOf(this.C));
            qZoneTask.addParameter("feeds_position", Integer.valueOf(this.D));
            qZoneTask.addParameter("uin", Long.valueOf(this.f25635d));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
            b.O().notify(37, this.f25640m, Boolean.valueOf(this.C), Long.valueOf(this.f25635d), Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        long f25641a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f25642b;

        /* renamed from: c, reason: collision with root package name */
        final String f25643c;

        /* renamed from: d, reason: collision with root package name */
        a.InterfaceC10828a f25644d = new a();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                c cVar = c.this;
                cVar.f25641a = 0L;
                cVar.f25642b = null;
            }
        }

        public c(String str) {
            this.f25643c = str;
        }
    }

    b() {
        super("UGCPermission");
        this.f25633d = new c("exclude");
        this.f25634e = new c("block");
    }

    private void C(long j3, Collection<a8.a> collection) {
        synchronized (this.f25634e) {
            N(this.f25634e, j3, a8.a.class);
            I(this.f25634e.f25642b, collection);
        }
    }

    private void D(long j3, a8.a... aVarArr) {
        synchronized (this.f25634e) {
            N(this.f25634e, j3, a8.a.class);
            J(this.f25634e.f25642b, aVarArr);
        }
    }

    private void F(long j3, Collection<a8.a> collection) {
        synchronized (this.f25633d) {
            N(this.f25633d, j3, a8.a.class);
            I(this.f25633d.f25642b, collection);
        }
    }

    private void G(long j3, a8.a... aVarArr) {
        synchronized (this.f25633d) {
            N(this.f25633d, j3, a8.a.class);
            J(this.f25633d.f25642b, aVarArr);
        }
    }

    public static b O() {
        return f25632f.get(null);
    }

    private void Z(long j3, Collection<a8.a> collection) {
        synchronized (this.f25634e) {
            N(this.f25634e, j3, a8.a.class);
            f0(this.f25634e.f25642b, collection);
        }
    }

    private void a0(long j3, a8.a... aVarArr) {
        synchronized (this.f25634e) {
            N(this.f25634e, j3, a8.a.class);
            g0(this.f25634e.f25642b, aVarArr);
        }
    }

    private void c0(long j3, Collection<a8.a> collection) {
        synchronized (this.f25633d) {
            N(this.f25633d, j3, a8.a.class);
            f0(this.f25633d.f25642b, collection);
        }
    }

    private void d0(long j3, a8.a... aVarArr) {
        synchronized (this.f25633d) {
            N(this.f25633d, j3, a8.a.class);
            g0(this.f25633d.f25642b, aVarArr);
        }
    }

    public void E(long j3, a8.a aVar, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneSetBlockRequest(1, j3, aVar.uin), handler, this, 10);
        qZoneTask.extraData.put("uin", Long.valueOf(j3));
        qZoneTask.extraData.put(QCircleAlphaUserReporter.KEY_USER, aVar);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void H(long j3, a8.a aVar, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneSetExcludeRequest(1, j3, aVar.uin), handler, this, 6);
        qZoneTask.extraData.put("uin", Long.valueOf(j3));
        qZoneTask.extraData.put(QCircleAlphaUserReporter.KEY_USER, aVar);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void P(Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneIsPublicRequest(LoginData.getInstance().getUin()), handler, this, 18));
    }

    public void b0(long j3, a8.a aVar, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneSetBlockRequest(0, j3, aVar.uin), handler, this, 9);
        qZoneTask.extraData.put("uin", Long.valueOf(j3));
        qZoneTask.extraData.put(QCircleAlphaUserReporter.KEY_USER, aVar);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void e0(long j3, a8.a aVar, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneSetExcludeRequest(0, j3, aVar.uin), handler, this, 5);
        qZoneTask.extraData.put("uin", Long.valueOf(j3));
        qZoneTask.extraData.put(QCircleAlphaUserReporter.KEY_USER, aVar);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            V(qZoneTask);
            return;
        }
        if (i3 == 2) {
            Y(qZoneTask);
            return;
        }
        if (i3 == 5) {
            X(qZoneTask);
            return;
        }
        if (i3 == 6) {
            R(qZoneTask);
            return;
        }
        if (i3 == 17) {
            U(qZoneTask);
            return;
        }
        if (i3 != 18) {
            switch (i3) {
                case 9:
                    W(qZoneTask);
                    return;
                case 10:
                    Q(qZoneTask);
                    return;
                case 11:
                    S(qZoneTask);
                    return;
                default:
                    return;
            }
        }
        T(qZoneTask);
    }

    private void N(c cVar, long j3, Class<? extends com.qzone.component.cache.database.a> cls) {
        DbCacheManager dbCacheManager;
        if (cVar == null) {
            return;
        }
        if (j3 != cVar.f25641a || (dbCacheManager = cVar.f25642b) == null || dbCacheManager.isClosed()) {
            cVar.f25641a = j3;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(cls, j3, cVar.f25643c);
            cVar.f25642b = e16;
            e16.U(cVar.f25644d);
        }
    }

    private void Q(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999988);
        if (result.getSucceed()) {
            Object obj = qZoneTask.extraData.get("uin");
            Object obj2 = qZoneTask.extraData.get(QCircleAlphaUserReporter.KEY_USER);
            Object obj3 = qZoneTask.extraData.get("users");
            long longValue = (obj == null || !(obj instanceof Long)) ? 0L : ((Long) obj).longValue();
            Collection<a8.a> collection = null;
            a8.a aVar = (obj2 == null || !(obj2 instanceof a8.a)) ? null : (a8.a) obj2;
            if (obj3 != null && (obj3 instanceof Collection)) {
                collection = (Collection) obj3;
            }
            if (longValue != 0 && aVar != null) {
                D(longValue, aVar);
            }
            if (longValue != 0 && collection != null) {
                C(longValue, collection);
            }
        }
        qZoneTask.sendResultMsg(result);
    }

    private void R(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999984);
        mobile_sub_setuncare_rsp mobile_sub_setuncare_rspVar = (mobile_sub_setuncare_rsp) qZoneTask.mRequest.rsp;
        if (result.getSucceed() && mobile_sub_setuncare_rspVar != null) {
            Object obj = qZoneTask.extraData.get("uin");
            Object obj2 = qZoneTask.extraData.get(QCircleAlphaUserReporter.KEY_USER);
            Object obj3 = qZoneTask.extraData.get("users");
            long longValue = (obj == null || !(obj instanceof Long)) ? 0L : ((Long) obj).longValue();
            Collection<a8.a> collection = null;
            a8.a aVar = (obj2 == null || !(obj2 instanceof a8.a)) ? null : (a8.a) obj2;
            if (obj3 != null && (obj3 instanceof Collection)) {
                collection = (Collection) obj3;
            }
            if (longValue != 0 && aVar != null) {
                G(longValue, aVar);
            }
            if (longValue != 0 && collection != null) {
                F(longValue, collection);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("care_status", mobile_sub_setuncare_rspVar.carestatus);
            bundle.putLong("hide_user_uin", aVar != null ? aVar.uin : 0L);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void S(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000001);
        mobile_sub_concern_rsp mobile_sub_concern_rspVar = (mobile_sub_concern_rsp) qZoneTask.mRequest.rsp;
        if (mobile_sub_concern_rspVar == null || mobile_sub_concern_rspVar.ret != 0) {
            result.setSucceed(false);
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("is_follow")).booleanValue();
        long longValue = ((Long) qZoneTask.getParameter("uin")).longValue();
        BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feedData");
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && booleanValue) {
            int intValue = ((Integer) qZoneTask.getParameter("feeds_position")).intValue();
            int intValue2 = ((Integer) qZoneTask.getParameter("click_scene")).intValue();
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "QZonePermissionService::onDealAuther", "");
            GdtFeedUtilForQZone.A(new AdClickData.Builder().setFeedData(businessFeedData).setFeedIndex(intValue).setAreaId(8).setSceneId(intValue2).create());
            f.g(businessFeedData);
        } else if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && !booleanValue) {
            f.f(businessFeedData);
        }
        if (result.getSucceed()) {
            ToastUtil.j(booleanValue, longValue, false);
        }
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && result.getSucceed()) {
            QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
            Object[] objArr = new Object[4];
            objArr[0] = businessFeedData.getFeedCommInfo() != null ? businessFeedData.getFeedCommInfo().ugckey : null;
            objArr[1] = Boolean.valueOf(booleanValue);
            objArr[2] = (Long) qZoneTask.getParameter("uin");
            objArr[3] = Boolean.FALSE;
            v06.notify(37, objArr);
        }
        if (result.getSucceed()) {
            Intent intent = new Intent();
            intent.setAction(QZoneHelper.FAMOUS_SPACE_CANCEL_FOLLOW_ACTION);
            intent.putExtra(QZoneHelper.KEY_FAMOUS_SPACE_CONCERN, booleanValue ? 1 : 0);
            intent.putExtra("uin", longValue);
            BaseApplication.getContext().sendBroadcast(intent);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void V(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999979);
        mobile_sub_getspaceright_rsp mobile_sub_getspaceright_rspVar = (mobile_sub_getspaceright_rsp) qZoneTask.mRequest.rsp;
        if (mobile_sub_getspaceright_rspVar != null) {
            result.setData(mobile_sub_getspaceright_rspVar);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void W(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999987);
        if (result.getSucceed()) {
            Object obj = qZoneTask.extraData.get("uin");
            Object obj2 = qZoneTask.extraData.get(QCircleAlphaUserReporter.KEY_USER);
            Object obj3 = qZoneTask.extraData.get("users");
            long longValue = (obj == null || !(obj instanceof Long)) ? 0L : ((Long) obj).longValue();
            Collection<a8.a> collection = null;
            a8.a aVar = (obj2 == null || !(obj2 instanceof a8.a)) ? null : (a8.a) obj2;
            if (obj3 != null && (obj3 instanceof Collection)) {
                collection = (Collection) obj3;
            }
            if (longValue != 0 && aVar != null) {
                a0(longValue, aVar);
            }
            if (longValue != 0 && collection != null) {
                Z(longValue, collection);
            }
        }
        qZoneTask.sendResultMsg(result);
    }

    private void X(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999983);
        mobile_sub_setuncare_rsp mobile_sub_setuncare_rspVar = (mobile_sub_setuncare_rsp) qZoneTask.mRequest.rsp;
        if (result.getSucceed() && mobile_sub_setuncare_rspVar != null) {
            Object obj = qZoneTask.extraData.get("uin");
            Object obj2 = qZoneTask.extraData.get(QCircleAlphaUserReporter.KEY_USER);
            Object obj3 = qZoneTask.extraData.get("users");
            long longValue = (obj == null || !(obj instanceof Long)) ? 0L : ((Long) obj).longValue();
            Collection<a8.a> collection = null;
            a8.a aVar = (obj2 == null || !(obj2 instanceof a8.a)) ? null : (a8.a) obj2;
            if (obj3 != null && (obj3 instanceof Collection)) {
                collection = (Collection) obj3;
            }
            if (longValue != 0 && aVar != null) {
                d0(longValue, aVar);
            }
            if (longValue != 0 && collection != null) {
                c0(longValue, collection);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("care_status", mobile_sub_setuncare_rspVar.carestatus);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void Y(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999980);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        int i3 = ((mobile_sub_setspaceright_req) qZoneRequest.req).rightval;
        if (i3 != 2) {
            result.setData(Integer.valueOf(i3));
        } else {
            mobile_sub_setspaceright_rsp mobile_sub_setspaceright_rspVar = (mobile_sub_setspaceright_rsp) qZoneRequest.rsp;
            if (mobile_sub_setspaceright_rspVar != null) {
                result.setData(mobile_sub_setspaceright_rspVar);
            } else {
                result.setSucceed(false);
            }
        }
        qZoneTask.sendResultMsg(result);
    }

    private void f0(DbCacheManager dbCacheManager, Collection<a8.a> collection) {
        if (dbCacheManager == null) {
            return;
        }
        for (a8.a aVar : collection) {
            if (aVar != null) {
                dbCacheManager.b0("uin=?", new String[]{"" + aVar.uin});
            }
        }
    }

    private void g0(DbCacheManager dbCacheManager, a8.a... aVarArr) {
        if (dbCacheManager == null) {
            return;
        }
        for (a8.a aVar : aVarArr) {
            if (aVar != null) {
                dbCacheManager.b0("uin=?", new String[]{"" + aVar.uin});
            }
        }
    }

    private void I(DbCacheManager dbCacheManager, Collection<a8.a> collection) {
        if (dbCacheManager == null) {
            return;
        }
        dbCacheManager.p0(collection, 1);
    }

    private void J(DbCacheManager dbCacheManager, a8.a... aVarArr) {
        if (dbCacheManager == null) {
            return;
        }
        dbCacheManager.q0(aVarArr, 1);
    }

    private void U(QZoneTask qZoneTask) {
        mobile_sub_concern_push_rsp mobile_sub_concern_push_rspVar;
        if (qZoneTask != null) {
            QZoneResult result = qZoneTask.getResult(1000002);
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if (qZoneRequest != null) {
                JceStruct jceStruct = qZoneRequest.rsp;
                if (jceStruct instanceof mobile_sub_concern_rsp) {
                    mobile_sub_concern_rsp mobile_sub_concern_rspVar = (mobile_sub_concern_rsp) jceStruct;
                    if (mobile_sub_concern_rspVar == null || mobile_sub_concern_rspVar.ret != 0) {
                        result.setSucceed(false);
                    }
                } else if ((jceStruct instanceof mobile_sub_concern_push_rsp) && ((mobile_sub_concern_push_rspVar = (mobile_sub_concern_push_rsp) jceStruct) == null || mobile_sub_concern_push_rspVar.ret != 0)) {
                    result.setSucceed(false);
                }
            }
            Bundle bundle = new Bundle();
            if (qZoneTask.getParameter("needToSpecialFollow") != null) {
                bundle.putInt("needToSpecialFollow", ((Integer) qZoneTask.getParameter("needToSpecialFollow")).intValue());
            }
            if (qZoneTask.getParameter("needToPush") != null) {
                bundle.putInt("needToPush", ((Integer) qZoneTask.getParameter("needToPush")).intValue());
            }
            result.setData(bundle);
            qZoneTask.sendResultMsg(result);
        }
    }

    public void L(long j3, boolean z16, int i3, Handler handler, String str, int i16, Map<Integer, String> map, Context context) {
        if (z16) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(j3, z16 ? 1 : 0, i3, map), handler, this, 11);
            qZoneTask.addParameter("feeds_key", str);
            qZoneTask.addParameter("is_follow", Boolean.valueOf(z16));
            qZoneTask.addParameter("feeds_position", Integer.valueOf(i16));
            qZoneTask.addParameter("uin", Long.valueOf(j3));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
            notify(37, str, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.FALSE);
            return;
        }
        new e().j(BaseActivity.getTopActivity() == null ? context : BaseActivity.getTopActivity(), new DialogInterfaceOnClickListenerC0020b(j3, z16 ? 1 : 0, i3, map, handler, str, z16, i16));
    }

    private void T(QZoneTask qZoneTask) {
        Map<Long, bmp4_values> map;
        Map<String, Long> map2;
        Long l3;
        if (qZoneTask == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000406);
        bmp4_get_rsp bmp4_get_rspVar = (bmp4_get_rsp) qZoneTask.mRequest.rsp;
        boolean z16 = false;
        if (bmp4_get_rspVar != null && bmp4_get_rspVar.retCode == 0 && (map = bmp4_get_rspVar.map_rsp) != null) {
            bmp4_values bmp4_valuesVar = map.get(Long.valueOf(LoginData.getInstance().getUin()));
            if (bmp4_valuesVar != null && (map2 = bmp4_valuesVar.map_kv) != null && (l3 = map2.get(QzoneIsPublicRequest.STR_BMP4_IS_QZONE_PUBLIC)) != null && l3.longValue() == 0) {
                z16 = true;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(LocalMultiProcConfig.QZONE_PERMISSION_PUBLIC, z16);
            result.setData(bundle);
            result.setSucceed(true);
            QZLog.e("QZonePermissionService", "isQzonePublic:" + z16);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    public void M(long j3, int i3, int i16, int i17, Handler handler) {
        if (i3 != 0) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(j3, i3 == 1 ? 3 : 2, i17, null), handler, this, 17);
            qZoneTask.addParameter("uin", Long.valueOf(j3));
            qZoneTask.addParameter("needToSpecialFollow", Integer.valueOf(i3));
            qZoneTask.addParameter("needToPush", Integer.valueOf(i16));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        }
        if (i16 != 0) {
            QZoneTask qZoneTask2 = new QZoneTask(new QZoneSpecialFollowPushRequest(j3, i16 != 1 ? 0 : 1, null), handler, this, 17);
            qZoneTask2.addParameter("uin", Long.valueOf(j3));
            qZoneTask2.addParameter("needToPush", Integer.valueOf(i16));
            qZoneTask2.addParameter("needToSpecialFollow", Integer.valueOf(i3));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask2);
        }
    }

    public void K(long j3, boolean z16, int i3, Handler handler, String str, int i16, Map<Integer, String> map) {
        L(j3, z16, i3, handler, str, i16, map, null);
    }
}
