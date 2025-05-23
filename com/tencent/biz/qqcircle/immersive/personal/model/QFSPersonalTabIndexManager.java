package com.tencent.biz.qqcircle.immersive.personal.model;

import com.tencent.biz.qqcircle.utils.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\tR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/model/QFSPersonalTabIndexManager;", "", "", "g", "Lcom/tencent/biz/qqcircle/immersive/personal/model/QFSPersonalTabIndexManager$Tab;", "tab", "", "c", h.F, "", "a", "e", "d", "f", "b", "i", "", "Ljava/util/Map;", "controlGroupTabs", "experimentGroupTabs", "Z", "hasInit", "hitExpResult", "<init>", "()V", "Tab", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalTabIndexManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPersonalTabIndexManager f88726a = new QFSPersonalTabIndexManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Tab, Integer> controlGroupTabs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Tab, Integer> experimentGroupTabs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean hasInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hitExpResult;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/model/QFSPersonalTabIndexManager$Tab;", "", "(Ljava/lang/String;I)V", "PRODUCT", "PRIVATE", "PRAISED", "PUSHED", "COLLECT", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Tab {
        PRODUCT,
        PRIVATE,
        PRAISED,
        PUSHED,
        COLLECT
    }

    static {
        Map<Tab, Integer> mapOf;
        Map<Tab, Integer> mapOf2;
        Tab tab = Tab.PRODUCT;
        Tab tab2 = Tab.PRAISED;
        Tab tab3 = Tab.PUSHED;
        Tab tab4 = Tab.COLLECT;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(tab, 0), TuplesKt.to(tab2, 1), TuplesKt.to(tab3, 2), TuplesKt.to(tab4, 3));
        controlGroupTabs = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(tab, 0), TuplesKt.to(Tab.PRIVATE, 1), TuplesKt.to(tab2, 2), TuplesKt.to(tab3, 3), TuplesKt.to(tab4, 4));
        experimentGroupTabs = mapOf2;
    }

    QFSPersonalTabIndexManager() {
    }

    private final int c(Tab tab) {
        Map<Tab, Integer> map;
        if (h()) {
            map = experimentGroupTabs;
        } else {
            map = controlGroupTabs;
        }
        Integer num = map.get(tab);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private final boolean g() {
        if (AppSetting.isGrayVersion()) {
            QLog.d("QFSPersonalTabIndexManager", 1, "isGrayVersion show feat.");
            return true;
        }
        boolean g16 = k.g("exp_qqvideo_homepage_PrivateTabnewtest", "exp_qqvideo_homepage_PrivateTabnewtest_B");
        QLog.d("QFSPersonalTabIndexManager", 1, "isHitExp:" + g16);
        return g16;
    }

    public final void a() {
        k.j("exp_qqvideo_homepage_PrivateTabnewtest");
        QLog.d("QFSPersonalTabIndexManager", 4, "expExport.");
    }

    public final int b() {
        return c(Tab.COLLECT);
    }

    public final int d() {
        return c(Tab.PRAISED);
    }

    public final int e() {
        if (h()) {
            return c(Tab.PRIVATE);
        }
        return -1;
    }

    public final int f() {
        return c(Tab.PUSHED);
    }

    public final boolean h() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_show_private_prods_tab", true)) {
            return false;
        }
        if (!hasInit) {
            hasInit = true;
            hitExpResult = g();
        }
        return hitExpResult;
    }

    public final void i() {
        hasInit = false;
    }
}
