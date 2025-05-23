package com.tencent.mobileqq.leba.business;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.gamecenter.metadream.leba.LebaPluginMetadream;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginGame;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginGameMall;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginHealth;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginLive;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginMakeFriend;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginMiniApp;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginNearbyPro;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginNowLive;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginQCircle;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginQzone;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginShopping;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.entity.o;
import com.tencent.mobileqq.leba.logic.LocalPluginLogic;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J(\u0010\"\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\rJ`\u00100\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010*\u001a\u0004\u0018\u00010)2\u0018\u0010-\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0013J`\u00102\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'2\b\u0010\u001f\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010)2\u0018\u0010-\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'J\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007J\u000e\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206J\u0006\u00109\u001a\u00020\u0002J\u0016\u0010;\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010=\u001a\u0004\u0018\u00010)2\u0006\u0010\b\u001a\u00020\u0007R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020>0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "", "", "u", "t", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "style", "", "Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "k", "mode", "", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tabChange", "r", "p", DomainData.DOMAIN_NAME, "b", ReportConstant.COSTREPORT_PREFIX, "l", "o", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "y", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "resID", "", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "isTableModel", "i", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", tl.h.F, "j", "pluginId", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "Lcom/tencent/mobileqq/leba/widget/a;", "controller", "e", HippyTKDListViewAdapter.X, "view", "d", "w", "g", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "a", "Ljava/util/Map;", "lebaPluginItemMap", "Lcom/tencent/mobileqq/leba/business/CommonLebaPluginItem;", "Lcom/tencent/mobileqq/leba/business/CommonLebaPluginItem;", "commonLebaPluginItem", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLebaImpl/Inject_LebaBusiness.yml", version = 1)
    @JvmField
    @NotNull
    public static final HashMap<String, Class<? extends BaseLebaPluginItem>> f240096d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<Map<Long, BaseLebaPluginItem>> f240097e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, BaseLebaPluginItem> lebaPluginItemMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommonLebaPluginItem commonLebaPluginItem;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\rJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0007R-\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028BX\u0083\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011RD\u0010\u0015\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u00130\u0012j\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0013`\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/leba/business/LebaPluginProxy$a;", "", "", "", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "c", "pluginId", "d", "pluginItemMap$delegate", "Lkotlin/Lazy;", "e", "()Ljava/util/Map;", "getPluginItemMap$annotations", "()V", "pluginItemMap", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "lebaPluginClasses", "Ljava/util/HashMap;", "<init>", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.LebaPluginProxy$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Long, BaseLebaPluginItem> c() {
            Map<Long, BaseLebaPluginItem> map;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Class<? extends BaseLebaPluginItem>> entry : LebaPluginProxy.f240096d.entrySet()) {
                try {
                    long parseLong = Long.parseLong(entry.getKey());
                    if (linkedHashMap.containsKey(Long.valueOf(parseLong))) {
                        QLog.e("LebaFrame.LebaPluginProxy", 1, "initLebaPluginInstanceList plugin[" + parseLong + "] already exist");
                    } else {
                        Class<? extends BaseLebaPluginItem> value = entry.getValue();
                        BaseLebaPluginItem newInstance = value.newInstance();
                        if (newInstance == null) {
                            QLog.e("LebaFrame.LebaPluginProxy", 1, "initLebaPluginInstanceList createInstance return null [" + parseLong + "] clazz: " + value);
                        } else if (newInstance.v() != parseLong) {
                            QLog.e("LebaFrame.LebaPluginProxy", 1, "initLebaPluginInstanceList plugin resId not match [" + parseLong + "/" + newInstance.v() + "] clazz: " + value);
                        } else {
                            linkedHashMap.put(Long.valueOf(parseLong), newInstance);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("LebaFrame.LebaPluginProxy", 1, "initLebaPluginInstanceList exception: ", e16);
                }
            }
            map = MapsKt__MapsKt.toMap(linkedHashMap);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Long, BaseLebaPluginItem> e() {
            return (Map) LebaPluginProxy.f240097e.getValue();
        }

        @JvmStatic
        @Nullable
        public final BaseLebaPluginItem d(long pluginId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BaseLebaPluginItem) iPatchRedirector.redirect((short) 2, (Object) this, pluginId);
            }
            return e().get(Long.valueOf(pluginId));
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Map<Long, BaseLebaPluginItem>> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        INSTANCE = new Companion(null);
        HashMap<String, Class<? extends BaseLebaPluginItem>> hashMap = new HashMap<>();
        f240096d = hashMap;
        hashMap.put(IMiniGameLebaController.MINI_GAME_RES_ID, LebaPluginMetadream.class);
        hashMap.put("769", l23.b.class);
        hashMap.put("4049", l23.a.class);
        hashMap.put("8059", LebaPluginMiniApp.class);
        hashMap.put("4559", LebaPluginHealth.class);
        hashMap.put("4050", LebaPluginNearbyPro.class);
        hashMap.put("4046", LebaPluginGameMall.class);
        hashMap.put("4038", LebaPluginMakeFriend.class);
        hashMap.put("3053", LebaPluginShopping.class);
        hashMap.put("3050", LebaPluginNowLive.class);
        hashMap.put("1113", com.tencent.mobileqq.leba.business.plugins.d.class);
        hashMap.put("879", LebaPluginLive.class);
        hashMap.put("785", com.tencent.mobileqq.leba.business.plugins.c.class);
        hashMap.put("777", com.tencent.mobileqq.leba.business.plugins.e.class);
        hashMap.put(IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID, LebaPluginGame.class);
        hashMap.put("4045", LebaPluginQCircle.class);
        hashMap.put(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN, LebaPluginQzone.class);
        lazy = LazyKt__LazyJVMKt.lazy(LebaPluginProxy$Companion$pluginItemMap$2.INSTANCE);
        f240097e = lazy;
    }

    public LebaPluginProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lebaPluginItemMap = INSTANCE.c();
            this.commonLebaPluginItem = new CommonLebaPluginItem();
        }
    }

    private final void t() {
        if (!TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        Iterator<T> it = this.lebaPluginItemMap.keySet().iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            try {
                TianshuRedTouch.INSTANCE.l(String.valueOf(longValue));
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "setLocalAndNetSwitch plugin[" + longValue + "]: ", e16);
            }
        }
    }

    private final void u() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.lebaPluginItemMap.keySet().iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            try {
                String valueOf = String.valueOf(longValue);
                if (valueOf != null) {
                    arrayList.add(valueOf);
                    arrayList.add(valueOf + ".0");
                }
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "setLocalAndNetSwitch plugin[" + longValue + "]: ", e16);
            }
        }
        ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).resetExposuresDeduplicate(arrayList);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.commonLebaPluginItem.e();
        Iterator<Map.Entry<Long, BaseLebaPluginItem>> it = this.lebaPluginItemMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().e();
        }
    }

    public final void c(@NotNull View v3, @Nullable n item) {
        LebaPluginInfo lebaPluginInfo;
        BaseLebaPluginItem baseLebaPluginItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (item != null) {
            lebaPluginInfo = item.f240505b;
        } else {
            lebaPluginInfo = null;
        }
        if (lebaPluginInfo != null && (baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240505b.uiResId))) != null) {
            baseLebaPluginItem.h(v3, item);
        }
    }

    public final void d(@NotNull n item, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240504a));
            if (baseLebaPluginItem != null) {
                baseLebaPluginItem.i(item, view);
            }
        } catch (Exception e16) {
            QLog.e("LebaFrame.LebaPluginProxy", 1, "bind ", e16);
        }
    }

    public final void e(@NotNull com.tencent.mobileqq.leba.widget.a controller) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) controller);
            return;
        }
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.commonLebaPluginItem.j(controller);
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            it.next().j(controller);
        }
    }

    public final boolean f(@NotNull n item, int mode, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, item, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (CommonLebaPluginItem.INSTANCE.a(item, mode, style)) {
            return true;
        }
        BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240504a));
        if (baseLebaPluginItem != null && (z16 = baseLebaPluginItem.l(mode, style))) {
            QLog.i("LebaFrame.LebaPluginProxy", 1, "filterPlugin " + item.f240504a);
        }
        return z16;
    }

    @Nullable
    public final String g(@NotNull n item) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240504a));
            if (baseLebaPluginItem != null) {
                str = baseLebaPluginItem.u();
            } else {
                str = null;
            }
            QLog.d("LebaFrame.LebaPluginProxy", 4, "getRedPointType[" + item.f240504a + "]: " + str + " ");
            return str;
        } catch (Exception e16) {
            QLog.e("LebaFrame.LebaPluginProxy", 1, "getRedPointType ", e16);
            return null;
        }
    }

    public final boolean h(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable TianshuRedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        try {
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(resID));
            if (baseLebaPluginItem != null && baseLebaPluginItem.x(app, context, resID, redTouch, resPkgName, redTouchHistory, index, isTableModel)) {
                QLog.i("LebaFrame.LebaPluginProxy", 1, "handleSpecificRedBadge [" + resID + "]");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean i(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        try {
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(resID));
            if (baseLebaPluginItem != null && baseLebaPluginItem.y(app, context, resID, redTouch, resPkgName, redTouchHistory, index, isTableModel)) {
                QLog.i("LebaFrame.LebaPluginProxy", 1, "handleSpecificRedTouch [" + resID + "]");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean j(long resID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, resID)).booleanValue();
        }
        BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(resID));
        if (baseLebaPluginItem != null) {
            return baseLebaPluginItem.z();
        }
        return false;
    }

    @NotNull
    public final List<LebaPluginInfo> k(int style) {
        o oVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, style);
        }
        Long[] lArr = {10000L, 4045L};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            long longValue = lArr[i3].longValue();
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(longValue));
            if (baseLebaPluginItem != null) {
                oVar = baseLebaPluginItem.m();
            } else {
                oVar = null;
            }
            if (oVar == null) {
                QLog.e("LebaFrame.LebaPluginProxy", 4, "loadLocalPluginList pluginData is null [" + longValue + "] ");
            } else {
                arrayList.add(LocalPluginLogic.f240660a.f(oVar, style));
            }
        }
        return arrayList;
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().D();
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onAccountChanged ", e16);
            }
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().E();
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onCreate ", e16);
            }
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        for (BaseLebaPluginItem baseLebaPluginItem : this.lebaPluginItemMap.values()) {
            try {
                baseLebaPluginItem.onDestroy();
                baseLebaPluginItem.P();
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onDestroy ", e16);
            }
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().F();
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onLebaTabChange ", e16);
            }
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().G();
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onPause ", e16);
            }
        }
        u();
    }

    public final void q(@NotNull View v3, @NotNull n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        com.tencent.mobileqq.leba.report.f.c(reportInfo);
        BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240505b.uiResId));
        if (baseLebaPluginItem != null) {
            LebaPluginInfo lebaPluginInfo = item.f240505b;
            QLog.d("LebaFrame.LebaPluginProxy", 4, "onPluginClick " + lebaPluginInfo.uiResId + " " + lebaPluginInfo.strResName + MsgSummary.STR_COLON + baseLebaPluginItem);
            try {
                baseLebaPluginItem.H(v3, item, reportInfo);
                return;
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onPluginClick exception", e16);
                return;
            }
        }
        LebaPluginInfo lebaPluginInfo2 = item.f240505b;
        QLog.d("LebaFrame.LebaPluginProxy", 4, "onPluginClick " + lebaPluginInfo2.uiResId + " " + lebaPluginInfo2.strResName + ": default");
        this.commonLebaPluginItem.H(v3, item, reportInfo);
    }

    public final void r(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().I(tabChange, style);
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "onResume ", e16);
            }
        }
        t();
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.commonLebaPluginItem.M();
        Iterator<Map.Entry<Long, BaseLebaPluginItem>> it = this.lebaPluginItemMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().M();
        }
    }

    public final void v(long pluginId, boolean isOpen, @NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(pluginId), Boolean.valueOf(isOpen), item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            BaseLebaPluginItem baseLebaPluginItem = (BaseLebaPluginItem) INSTANCE.e().get(Long.valueOf(pluginId));
            if (baseLebaPluginItem != null) {
                baseLebaPluginItem.N(isOpen, item);
            }
        } catch (Exception e16) {
            QLog.e("LebaFrame.LebaPluginProxy", 1, "setLocalAndNetSwitch plugin[" + pluginId + "]: ", e16);
        }
    }

    public final void w(@NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240504a));
            if (baseLebaPluginItem != null) {
                baseLebaPluginItem.P();
            }
        } catch (Exception e16) {
            QLog.e("LebaFrame.LebaPluginProxy", 1, "unbind ", e16);
        }
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.commonLebaPluginItem.O();
        Iterator<BaseLebaPluginItem> it = this.lebaPluginItemMap.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().O();
            } catch (Exception e16) {
                QLog.e("LebaFrame.LebaPluginProxy", 1, "unbindPluginView ", e16);
            }
        }
    }

    public final boolean y(@NotNull n item, @NotNull RedTouch redTouch, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, item, redTouch, appInfo, Integer.valueOf(style))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        try {
            BaseLebaPluginItem baseLebaPluginItem = this.lebaPluginItemMap.get(Long.valueOf(item.f240504a));
            if (baseLebaPluginItem == null) {
                return false;
            }
            return baseLebaPluginItem.Q(redTouch, appInfo, style);
        } catch (Exception unused) {
            return false;
        }
    }
}
