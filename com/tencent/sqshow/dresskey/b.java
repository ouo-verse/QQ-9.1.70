package com.tencent.sqshow.dresskey;

import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.data.ZootopiaGameParams;
import com.tencent.mobileqq.zootopia.utils.g;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.push.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import com.tencent.sqshow.zootopia.usercenter.account.ZplanEventLogout;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.json.JSONObject;
import pu4.x;
import t74.l;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0006*\u000226\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J(\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R&\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/sqshow/dresskey/b;", "", "", "scene", "", "needRegister", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "callback", "", "v", HippyTKDListViewAdapter.X, "j", "result", h.F, "Ldw4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", ReportConstant.COSTREPORT_PREFIX, "r", "i", "t", "u", "Landroidx/lifecycle/LiveData;", "l", "k", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "mDressInfoLiveData", "c", "Ldw4/b;", "mMemCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRefreshing", "e", "refreshingSceneNeedRegister", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "queuingCallbacks", "com/tencent/sqshow/dresskey/b$c", "g", "Lcom/tencent/sqshow/dresskey/b$c;", "mOidbPushObserver", "com/tencent/sqshow/dresskey/b$b", "Lcom/tencent/sqshow/dresskey/b$b;", "mEventReceiver", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f369818a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<dw4.b> mDressInfoLiveData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static dw4.b mMemCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isRefreshing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean refreshingSceneNeedRegister;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<WeakReference<e<dw4.b>>> queuingCallbacks;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final c mOidbPushObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final C9801b mEventReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/dresskey/b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e<dw4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f369826d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e<dw4.b> f369827e;

        a(String str, e<dw4.b> eVar) {
            this.f369826d = str;
            this.f369827e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(dw4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b.isRefreshing.compareAndSet(true, false);
            b.refreshingSceneNeedRegister.set(false);
            if (result.f395114a) {
                boolean h16 = b.f369818a.h(result, this.f369827e, this.f369826d);
                QLog.i("DressInfoService", 1, "refreshDressInfo scene=" + this.f369826d + " hasChange=" + h16 + " gender=" + result.f395116c + " onResultSuccess dressKey=" + result.f395115b + " maleDefaultDressKey=" + result.f395121h + " femaleDefaultDressKey=" + result.f395122i);
                return;
            }
            QLog.i("DressInfoService", 1, "is not registerUser, scene:" + this.f369826d);
            e<dw4.b> eVar = this.f369827e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b.isRefreshing.compareAndSet(true, false);
            b.refreshingSceneNeedRegister.set(false);
            QLog.i("DressInfoService", 1, "refreshDressInfo scene=" + this.f369826d + " onResultFailure error=" + error + ", message=" + message);
            e<dw4.b> eVar = this.f369827e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            while (!b.queuingCallbacks.isEmpty()) {
                e eVar2 = (e) ((WeakReference) b.queuingCallbacks.remove(0)).get();
                if (eVar2 != null) {
                    eVar2.onResultFailure(error, message);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/dresskey/b$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/usercenter/account/ZplanEventLogout;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.dresskey.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9801b implements SimpleEventReceiver<ZplanEventLogout> {
        C9801b() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<ZplanEventLogout>> getEventClass() {
            ArrayList<Class<ZplanEventLogout>> arrayList = new ArrayList<>();
            arrayList.add(ZplanEventLogout.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent event) {
            if (event instanceof ZplanEventLogout) {
                QLog.i("DressInfoService", 1, "logout, clear Cache");
                b bVar = b.f369818a;
                bVar.i();
                bVar.x();
            }
        }
    }

    static {
        b bVar = new b();
        f369818a = bVar;
        mDressInfoLiveData = new MutableLiveData<>();
        isRefreshing = new AtomicBoolean(false);
        refreshingSceneNeedRegister = new AtomicBoolean(false);
        queuingCallbacks = new CopyOnWriteArrayList<>();
        c cVar = new c();
        mOidbPushObserver = cVar;
        C9801b c9801b = new C9801b();
        mEventReceiver = c9801b;
        QLog.i("DressInfoService", 1, "init");
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.F2(cVar);
        }
        dw4.b r16 = bVar.r();
        if (r16 != null) {
            bVar.z(r16);
        }
        SimpleEventBus.getInstance().registerReceiver(c9801b);
    }

    b() {
    }

    private final boolean A(String scene, boolean needRegister) {
        return Intrinsics.areEqual(scene, "oidb_push") || Intrinsics.areEqual(scene, "avatar_save") || Intrinsics.areEqual(scene, "mod_save") || Intrinsics.areEqual(scene, "jsb") || Intrinsics.areEqual(scene, ZootopiaGameParams.SCRIPT_TYPE_LUA) || Intrinsics.areEqual(scene, "new_body_update") || Intrinsics.areEqual(scene, "create_role") || Intrinsics.areEqual(scene, "login") || (!refreshingSceneNeedRegister.get() && needRegister);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(dw4.b result, e<dw4.b> callback, String scene) {
        boolean z16;
        dw4.b s16 = s();
        boolean z17 = true;
        if (s16 != null) {
            QLog.i("DressInfoService", 1, "cacheRegisterResult dressKey " + result.f395115b);
            qu4.h hVar = result.f395115b;
            Intrinsics.checkNotNullExpressionValue(hVar, "result.dressKey");
            if (g.d(hVar, s16.f395115b)) {
                z16 = false;
            } else {
                QLog.i("DressInfoService", 1, "refresh dressKey " + result.f395115b);
                s16.f395115b = result.f395115b;
                s16.f395118e = result.f395118e;
                s16.f395117d = result.f395117d;
                z16 = true;
            }
            if (s16.f395118e == null) {
                QLog.i("DressInfoService", 1, "refresh femaleAvatarCharacter");
                s16.f395118e = result.f395118e;
                z16 = true;
            }
            if (s16.f395117d == null) {
                QLog.i("DressInfoService", 1, "refresh maleAvatarCharacter");
                s16.f395117d = result.f395117d;
                z16 = true;
            }
            qu4.h hVar2 = result.f395121h;
            Intrinsics.checkNotNullExpressionValue(hVar2, "result.maleDefaultDressKey");
            if (!g.d(hVar2, s16.f395121h)) {
                QLog.i("DressInfoService", 1, "refresh maleDefaultDressKey " + result.f395121h);
                s16.f395121h = result.f395121h;
                s16.f395119f = result.f395119f;
                z16 = true;
            }
            if (s16.f395119f == null) {
                QLog.i("DressInfoService", 1, "refresh maleDefaultAvatarCharacter");
                s16.f395119f = result.f395119f;
                z16 = true;
            }
            qu4.h hVar3 = result.f395122i;
            Intrinsics.checkNotNullExpressionValue(hVar3, "result.femaleDefaultDressKey");
            if (!g.d(hVar3, s16.f395122i)) {
                QLog.i("DressInfoService", 1, "refresh femaleDefaultDressKey " + result.f395122i);
                s16.f395122i = result.f395122i;
                s16.f395120g = result.f395120g;
                z16 = true;
            }
            if (s16.f395120g == null) {
                QLog.i("DressInfoService", 1, "refresh femaleDefaultAvatarCharacter");
                s16.f395120g = result.f395120g;
            } else {
                z17 = z16;
            }
            s16.f395116c = result.f395116c;
            s16.f395124k = result.f395124k;
            s16.f395114a = result.f395114a;
            s16.f395123j = result.f395123j;
        } else {
            s16 = result;
        }
        z(s16);
        y(s16);
        if (callback != null) {
            callback.onResultSuccess(s16);
        }
        while (true) {
            CopyOnWriteArrayList<WeakReference<e<dw4.b>>> copyOnWriteArrayList = queuingCallbacks;
            if (copyOnWriteArrayList.isEmpty()) {
                break;
            }
            e<dw4.b> eVar = copyOnWriteArrayList.remove(0).get();
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }
        if (z17) {
            n(s16, scene);
        }
        return z17;
    }

    private final void j(String scene, boolean needRegister, e<dw4.b> callback) {
        DressKeyProtoReqHelper.c(DressKeyProtoReqHelper.f369812a, m(needRegister), new a(scene, callback), 0, 4, null);
    }

    private final dw4.a m(boolean needRegister) {
        dw4.a aVar = new dw4.a();
        dw4.b s16 = s();
        if (s16 != null) {
            qu4.h hVar = s16.f395115b;
            if (hVar != null && s16.f395117d != null && s16.f395118e != null) {
                QLog.i("DressInfoService", 1, "bring back dressKey " + hVar);
                aVar.f395109c = s16.f395115b;
            }
            qu4.h hVar2 = s16.f395121h;
            if (hVar2 != null && s16.f395119f != null) {
                QLog.i("DressInfoService", 1, "bring back maleDefaultDressKey " + hVar2);
                aVar.f395110d = s16.f395121h;
            }
            qu4.h hVar3 = s16.f395122i;
            if (hVar3 != null && s16.f395120g != null) {
                QLog.i("DressInfoService", 1, "bring back femaleDefaultDressKey " + hVar3);
                aVar.f395111e = s16.f395122i;
            }
        }
        aVar.f395107a = needRegister ? 100 : 1;
        aVar.f395112f = new x();
        Rect d16 = e84.a.f395879a.d();
        aVar.f395112f.f427556a = d16.width();
        aVar.f395112f.f427557b = d16.height();
        return aVar;
    }

    private final void n(final dw4.b result, String scene) {
        QLog.i("DressInfoService", 1, "notifyAppearanceKeyChangeIfNeed");
        if (!Intrinsics.areEqual(scene, "login") && !Intrinsics.areEqual(scene, "inner")) {
            QLog.i("DressInfoService", 1, "notifyAppearanceKeyChangeIfNeed do notify");
            p(result);
            l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.dresskey.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.o(dw4.b.this);
                }
            });
            return;
        }
        QLog.i("DressInfoService", 1, "notifyAppearanceKeyChangeIfNeed do not notify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(dw4.b result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        f369818a.q(result);
    }

    private final void p(dw4.b result) {
        if (result.f395115b == null) {
            QLog.e("DressInfoService", 1, "notifyMemoRecord result.dressKey is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appearanceKey", result.f395115b.f429599c);
        jSONObject.put("appearanceKeyNew", result.f395115b.f429598b);
        jSONObject.put("gender", result.f395116c);
        jSONObject.put("timestamp", result.f395123j);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonParam.toString()");
        iZPlanApi.notifyAppearanceKeyChange(jSONObject2);
    }

    private final void q(dw4.b result) {
        qu4.a aVar;
        if (result.f395116c == 2) {
            aVar = result.f395118e;
        } else {
            aVar = result.f395117d;
        }
        if (aVar == null) {
            QLog.e("DressInfoService", 1, "notifyRecordRoleIcon avatarInfo is null");
            return;
        }
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("avatarInfo", r94.c.h(aVar));
        jSONObject.put("height", 360);
        jSONObject.put("width", 360);
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, System.currentTimeMillis());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "recordRoleIconParams.toString()");
        a.C10063a.b(S, "N2L_RecordRoleIcon", jSONObject2, null, 4, null);
    }

    private final dw4.b r() {
        try {
            return dw4.b.d(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes("zplan_dresskey", new byte[0]));
        } catch (Exception unused) {
            return null;
        }
    }

    private final dw4.b s() {
        return mMemCache;
    }

    private final void v(String scene, boolean needRegister, e<dw4.b> callback) {
        if (Intrinsics.areEqual(scene, "login")) {
            x();
        }
        if (!isRefreshing.get() || A(scene, needRegister)) {
            j(scene, needRegister, callback);
            isRefreshing.compareAndSet(false, true);
            refreshingSceneNeedRegister.set(needRegister);
        } else if (callback != null) {
            queuingCallbacks.add(new WeakReference<>(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        isRefreshing.compareAndSet(true, false);
        refreshingSceneNeedRegister.compareAndSet(true, false);
    }

    private final void z(dw4.b rsp) {
        QLog.i("DressInfoService", 1, "saveInMemory, gender:" + rsp.f395116c + " appearanceKey:" + rsp.f395115b);
        mMemCache = rsp;
        mDressInfoLiveData.postValue(rsp);
    }

    public dw4.b k(String scene, boolean needRegister, e<dw4.b> callback) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        dw4.b s16 = s();
        if (s16 != null && s16.f395114a && g.i(s16)) {
            if (callback != null) {
                callback.onResultSuccess(s16);
            }
            return s16;
        }
        dw4.b r16 = r();
        if (r16 != null && r16.f395114a && g.i(r16)) {
            z(r16);
            if (callback != null) {
                callback.onResultSuccess(r16);
            }
            QLog.i("DressInfoService", 1, "getDressInfo from db isRegister=" + r16.f395114a);
            return r16;
        }
        v(scene, needRegister, callback);
        return null;
    }

    public LiveData<dw4.b> l(String scene, boolean needRegister) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        QLog.i("DressInfoService", 1, "getDressInfoLiveData scene = " + scene + " needRegister:" + needRegister);
        dw4.b s16 = s();
        if (s16 != null && s16.f395114a && g.i(s16)) {
            QLog.i("DressInfoService", 1, "getDressInfoLiveData from mem");
            return mDressInfoLiveData;
        }
        dw4.b r16 = r();
        if (r16 != null && r16.f395114a && g.i(r16)) {
            z(r16);
            QLog.i("DressInfoService", 1, "getDressInfoLiveData from db");
            return mDressInfoLiveData;
        }
        t(scene, needRegister);
        return mDressInfoLiveData;
    }

    public void t(String scene, boolean needRegister) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        QLog.i("DressInfoService", 1, "refreshDressInfo, needRegister:" + needRegister);
        w(this, scene, needRegister, null, 4, null);
    }

    public void u(String scene, boolean needRegister, e<dw4.b> callback) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("DressInfoService", 1, "refreshDressInfo with callback needRegister:" + needRegister);
        v(scene, needRegister, callback);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/dresskey/b$c", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends i {
        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            try {
                mv4.e c16 = mv4.e.c(buf);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(buf)");
                if (c16.f417675a == 12) {
                    QLog.i("DressInfoService", 1, "oidb push refresh");
                    b.f369818a.t("oidb_push", true);
                }
            } catch (Exception e16) {
                QLog.e("DressInfoService", 1, "oidb push refresh error " + e16.getMessage());
            }
        }

        c() {
            super(337);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        mMemCache = null;
        mDressInfoLiveData.postValue(null);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove("zplan_dresskey");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).clearMMKVCacheWhenLogout();
    }

    private final void y(dw4.b rsp) {
        QLog.i("DressInfoService", 1, "saveInDb");
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        byte[] byteArray = MessageNano.toByteArray(rsp);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(rsp)");
        iZPlanMMKVApi.setBytes("zplan_dresskey", byteArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void w(b bVar, String str, boolean z16, e eVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        bVar.v(str, z16, eVar);
    }
}
