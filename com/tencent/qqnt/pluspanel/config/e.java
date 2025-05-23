package com.tencent.qqnt.pluspanel.config;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002JD\u0010\u0013\u001a\u00020\u00042\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0010j\b\u0012\u0004\u0012\u00020\r`\u0011H\u0002J$\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u000bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u000eH\u0002J\u0018\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0010j\b\u0012\u0004\u0012\u00020\r`\u0011H\u0002J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0010j\b\u0012\u0004\u0012\u00020\r`\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J&\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0002J\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eJ\u0010\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020\fJ2\u0010$\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010#0\"0\u0010j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010#0\"`\u0011J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0010j\b\u0012\u0004\u0012\u00020\r`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010)R0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u000bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u000bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010'R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u000bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010'RP\u0010.\u001a>\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u00110\u000bj\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0011`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'RP\u0010/\u001a>\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u00110\u000bj\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0011`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010'RP\u00100\u001a>\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u00110\u000bj\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0011`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010'R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00101R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00101R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/e;", "", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "j", "isStudyMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/pluspanel/config/c;", "orderBean", "r", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/pluspanel/config/b;", "Lkotlin/collections/HashMap;", "appConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "appIdConfig", "p", "", "d", "g", "configAppList", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "appInfo", "c", "needforce", "k", h.F, "appId", "f", "Lkotlin/Pair;", "Landroid/os/Bundle;", "e", "i", "b", "Ljava/util/HashMap;", "configMap", "Ljava/util/ArrayList;", "configList", "normalOrder", "simpleOrder", "studyOrder", "normalChild", "conciseChild", "teenagerChild", "Z", "appLoaded", "orderLoaded", "l", "Ljava/lang/Boolean;", "isStudyModeOrder", "Ljava/lang/String;", "lastUid", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f360364a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, b> configMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<b> configList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> normalOrder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> simpleOrder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> studyOrder;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, ArrayList<Integer>> normalChild;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, ArrayList<Integer>> conciseChild;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, ArrayList<Integer>> teenagerChild;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean appLoaded;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean orderLoaded;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean isStudyModeOrder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastUid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/pluspanel/config/e$a", "Lcom/tencent/qqnt/aio/api/a;", "Lcom/tencent/qqnt/pluspanel/config/a;", DownloadInfo.spKey_Config, "", "b", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements com.tencent.qqnt.aio.api.a<com.tencent.qqnt.pluspanel.config.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.api.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable com.tencent.qqnt.pluspanel.config.a config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
            } else if (config != null) {
                e.f360364a.p(config.a(), config.b());
            } else {
                QLog.i("C2CPlusPanelConfigRepo", 1, "[loadConfig]: config is null");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37835);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f360364a = new e();
        configMap = new HashMap<>();
        configList = new ArrayList<>();
        normalOrder = new HashMap<>();
        simpleOrder = new HashMap<>();
        studyOrder = new HashMap<>();
        normalChild = new HashMap<>();
        conciseChild = new HashMap<>();
        teenagerChild = new HashMap<>();
        lastUid = "";
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<Integer> c(b appInfo) {
        boolean z16;
        if (appInfo == null) {
            return null;
        }
        ArrayList<Integer> k3 = appInfo.k();
        boolean z17 = false;
        if (QQTheme.isNowSimpleUI()) {
            ArrayList<Integer> l3 = appInfo.l();
            if (l3 != null && !l3.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                k3 = appInfo.l();
            }
        }
        if (((IStudyModeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStudyModeApi.class)).isStudyMode()) {
            ArrayList<Integer> q16 = appInfo.q();
            if (q16 == null || q16.isEmpty()) {
                z17 = true;
            }
            if (!z17) {
                return appInfo.q();
            }
            return k3;
        }
        return k3;
    }

    private final synchronized HashMap<Integer, Integer> d() {
        HashMap<Integer, Integer> hashMap;
        hashMap = new HashMap<>();
        if (QQTheme.isNowSimpleUI()) {
            hashMap.putAll(simpleOrder);
        } else if (Intrinsics.areEqual(isStudyModeOrder, Boolean.TRUE)) {
            hashMap.putAll(studyOrder);
        } else {
            hashMap.putAll(normalOrder);
        }
        return hashMap;
    }

    private final synchronized ArrayList<b> g() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        arrayList.addAll(configList);
        return arrayList;
    }

    private final void j(boolean force) {
        boolean z16 = appLoaded;
        if (z16 && !force) {
            return;
        }
        QLog.i("C2CPlusPanelConfigRepo", 1, "[loadAppConfig]: loaded is " + z16 + " force is " + force);
        appLoaded = true;
        ((IAIOUniteConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOUniteConfigApi.class)).loadLargeConfigAsync("aio_plus_panel_app_config", new a());
    }

    public static /* synthetic */ void l(e eVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        eVar.k(z16);
    }

    private final void m(boolean isStudyMode, boolean force) {
        if (Intrinsics.areEqual(Boolean.valueOf(isStudyMode), isStudyModeOrder) && orderLoaded && !force) {
            return;
        }
        QLog.i("C2CPlusPanelConfigRepo", 1, "[loadOrderConfig]: isStudyMode " + isStudyMode + ", loaded is " + orderLoaded + ", force is " + force);
        orderLoaded = true;
        isStudyModeOrder = Boolean.valueOf(isStudyMode);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.pluspanel.config.d
            @Override // java.lang.Runnable
            public final void run() {
                e.n();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        Unit unit;
        c cVar = (c) ((IAIOUniteConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOUniteConfigApi.class)).loadConfig("aio_plus_panel_order_config");
        if (cVar != null) {
            QLog.i("C2CPlusPanelConfigRepo", 1, "[loadOrderConfig]: load order start");
            f360364a.r(cVar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("C2CPlusPanelConfigRepo", 1, "[loadOrderConfig]: orderConfig is null");
        }
    }

    private final List<b> o(ArrayList<b> configAppList) {
        Unit unit;
        HashMap<Integer, Integer> d16 = d();
        QLog.d("C2CPlusPanelConfigRepo", 1, "sortAndFilterAioAppInfo orders: " + d16);
        Iterator<b> it = configAppList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "configAppList.iterator()");
        while (it.hasNext()) {
            b next = it.next();
            if (next.m() != 1) {
                it.remove();
            }
            Integer num = d16.get(Integer.valueOf(Integer.parseInt(next.j())));
            if (num != null) {
                if (num.intValue() > 0) {
                    next.v(num.intValue());
                } else {
                    it.remove();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                it.remove();
            }
        }
        Collections.sort(configAppList);
        return configAppList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void p(HashMap<String, b> appConfig, ArrayList<b> appIdConfig) {
        if (!appConfig.isEmpty() && !appIdConfig.isEmpty()) {
            HashMap<String, b> hashMap = configMap;
            hashMap.clear();
            ArrayList<b> arrayList = configList;
            arrayList.clear();
            hashMap.putAll(appConfig);
            arrayList.addAll(appIdConfig);
            q();
            QLog.i("C2CPlusPanelConfigRepo", 1, "[updateAppCache]: configSize is " + hashMap.size() + ", appIdSize is " + arrayList.size());
            return;
        }
        QLog.i("C2CPlusPanelConfigRepo", 1, "[updateAppCache]: config is invalid");
    }

    private final void q() {
        boolean z16;
        Integer intOrNull;
        ArrayList<b> arrayList = configList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ListIterator<b> listIterator = arrayList.listIterator();
        Intrinsics.checkNotNullExpressionValue(listIterator, "configList.listIterator()");
        while (listIterator.hasNext()) {
            b next = listIterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            b bVar = next;
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(bVar.j());
            if (intOrNull != null) {
                int intValue = intOrNull.intValue();
                HashMap<Integer, ArrayList<Integer>> hashMap = normalChild;
                if (hashMap.containsKey(Integer.valueOf(intValue))) {
                    bVar.t(hashMap.get(Integer.valueOf(intValue)));
                }
                HashMap<Integer, ArrayList<Integer>> hashMap2 = conciseChild;
                if (hashMap2.containsKey(Integer.valueOf(intValue))) {
                    bVar.u(hashMap2.get(Integer.valueOf(intValue)));
                }
                HashMap<Integer, ArrayList<Integer>> hashMap3 = teenagerChild;
                if (hashMap3.containsKey(Integer.valueOf(intValue))) {
                    bVar.w(hashMap3.get(Integer.valueOf(intValue)));
                }
                listIterator.set(bVar);
                configMap.put(bVar.j(), bVar);
            }
        }
    }

    private final synchronized void r(c orderBean) {
        HashMap<Integer, Integer> d16 = orderBean.d();
        HashMap<Integer, Integer> e16 = orderBean.e();
        HashMap<Integer, Integer> f16 = orderBean.f();
        HashMap<Integer, ArrayList<Integer>> c16 = orderBean.c();
        HashMap<Integer, ArrayList<Integer>> b16 = orderBean.b();
        HashMap<Integer, ArrayList<Integer>> g16 = orderBean.g();
        if (d16.isEmpty() && e16.isEmpty() && f16.isEmpty()) {
            QLog.i("C2CPlusPanelConfigRepo", 1, "[updateOrderCache]: config is invalid");
            return;
        }
        HashMap<Integer, Integer> hashMap = normalOrder;
        hashMap.clear();
        HashMap<Integer, Integer> hashMap2 = simpleOrder;
        hashMap2.clear();
        HashMap<Integer, Integer> hashMap3 = studyOrder;
        hashMap3.clear();
        HashMap<Integer, ArrayList<Integer>> hashMap4 = normalChild;
        hashMap4.clear();
        HashMap<Integer, ArrayList<Integer>> hashMap5 = conciseChild;
        hashMap5.clear();
        HashMap<Integer, ArrayList<Integer>> hashMap6 = teenagerChild;
        hashMap6.clear();
        hashMap.putAll(d16);
        hashMap2.putAll(e16);
        hashMap3.putAll(f16);
        hashMap4.putAll(c16);
        hashMap5.putAll(b16);
        hashMap6.putAll(g16);
        q();
        QLog.i("C2CPlusPanelConfigRepo", 1, "[updateOrderCache]: normalOrderSize is " + hashMap.size() + ", simpleOrderSize is " + hashMap2.size() + ", studyOrderSize is " + hashMap3.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:10:0x0016, B:12:0x0024, B:14:0x0035, B:15:0x0040, B:17:0x0046, B:19:0x0054, B:24:0x0060, B:26:0x006d, B:31:0x0082), top: B:9:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<Pair<Integer, Bundle>> e() {
        boolean z16;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            List<b> o16 = o(g());
            if (o16.isEmpty()) {
                QLog.i("C2CPlusPanelConfigRepo", 1, "[getConfigAppId]: sortedList is empty");
                f360364a.k(true);
                return new ArrayList<>();
            }
            ArrayList<Pair<Integer, Bundle>> arrayList = new ArrayList<>();
            for (b bVar : o16) {
                ArrayList<Integer> c16 = f360364a.c(bVar);
                if (c16 != null && !c16.isEmpty()) {
                    z16 = false;
                    if (z16) {
                        bundle = new Bundle();
                        bundle.putIntegerArrayList("child_list", c16);
                    } else {
                        bundle = null;
                    }
                    arrayList.add(new Pair<>(Integer.valueOf(Integer.parseInt(bVar.j())), bundle));
                }
                z16 = true;
                if (z16) {
                }
                arrayList.add(new Pair<>(Integer.valueOf(Integer.parseInt(bVar.j())), bundle));
            }
            QLog.i("C2CPlusPanelConfigRepo", 1, "[getConfigAppId]: sortedList size is " + arrayList.size());
            return arrayList;
        } catch (Exception e16) {
            QLog.i("C2CPlusPanelConfigRepo", 1, "[getConfigAppId]: " + e16);
            return new ArrayList<>();
        }
    }

    @Nullable
    public final b f(@NotNull String appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appId);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        return configMap.get(appId);
    }

    @NotNull
    public final synchronized HashMap<String, b> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashMap<String, b> hashMap = new HashMap<>();
        hashMap.putAll(configMap);
        return hashMap;
    }

    @NotNull
    public final List<Integer> i() {
        int redDotID;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e().iterator();
        while (it.hasNext()) {
            PlusPanelAppInfo a16 = new com.tencent.qqnt.pluspanel.data.appinfo.a().a(1, ((Number) ((Pair) it.next()).getFirst()).intValue());
            if (a16 != null && (redDotID = a16.getRedDotID()) > 0) {
                arrayList.add(Integer.valueOf(redDotID));
            }
        }
        return arrayList;
    }

    public final void k(boolean needforce) {
        String str;
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, needforce);
            return;
        }
        if (!needforce) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                str = peekAppRuntime.getCurrentUid();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            boolean z16 = !Intrinsics.areEqual(lastUid, str);
            lastUid = str;
            needforce = z16;
        }
        j(needforce);
        m(((IStudyModeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStudyModeApi.class)).isStudyMode(), needforce);
    }
}
