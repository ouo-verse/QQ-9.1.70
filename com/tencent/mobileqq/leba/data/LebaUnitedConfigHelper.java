package com.tencent.mobileqq.leba.data;

import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.leba.entity.LebaPluginConfig;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.j;
import com.tencent.mobileqq.leba.logic.LocalPluginLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010\u001bJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001c\u001a\u00020\u00178FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001f\u001a\u00020\u00178FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/leba/data/LebaUnitedConfigHelper;", "", "Lcom/tencent/mobileqq/leba/entity/LebaPluginConfig;", "lebaPluginConfig", "", "mode", "style", "Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "j", "", "i", "", "configStr", "b", "g", tl.h.F, "", "f", "Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "unitedConfigApi", "", "c", "()Z", "getGetAllPluginListSwitch$annotations", "()V", "getAllPluginListSwitch", "d", "getPluginDataSourceSwitch$annotations", "pluginDataSourceSwitch", "<init>", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaUnitedConfigHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LebaUnitedConfigHelper f240392a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy unitedConfigApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy getAllPluginListSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy pluginDataSourceSwitch;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17662);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f240392a = new LebaUnitedConfigHelper();
        lazy = LazyKt__LazyJVMKt.lazy(LebaUnitedConfigHelper$unitedConfigApi$2.INSTANCE);
        unitedConfigApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LebaUnitedConfigHelper$getAllPluginListSwitch$2.INSTANCE);
        getAllPluginListSwitch = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(LebaUnitedConfigHelper$pluginDataSourceSwitch$2.INSTANCE);
        pluginDataSourceSwitch = lazy3;
    }

    LebaUnitedConfigHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<LebaPluginConfig> b(String configStr) {
        boolean z16;
        int i3;
        Iterator<c> it;
        int i16;
        int i17 = 1;
        if (configStr != null && configStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<f> it5 = e.f240411a.a(configStr).iterator();
        int i18 = 0;
        while (it5.hasNext()) {
            int i19 = i18 + 1;
            Iterator<c> it6 = it5.next().a().iterator();
            int i26 = 0;
            while (it6.hasNext()) {
                int i27 = i26 + 1;
                c next = it6.next();
                String b16 = next.b();
                if (b16 != null) {
                    String str = "";
                    String loadAsString = e().loadAsString(b16, "");
                    if (loadAsString.length() == 0) {
                        i3 = i17;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        QLog.e("LebaUnitedConfigHelper", i17, "doLoadConfigData pluginInfo error. [" + next.c() + ", " + b16 + "] empty raw");
                    } else {
                        h b17 = g.f240413a.b(loadAsString);
                        if (b17 == null) {
                            it = it6;
                            i17 = 1;
                            QLog.e("LebaUnitedConfigHelper", 1, "doLoadConfigData pluginInfo error. [" + next.c() + ", " + b16 + "] raw: " + loadAsString);
                            i16 = i17;
                            i17 = i16;
                            i26 = i27;
                            it6 = it;
                        } else {
                            it = it6;
                            if (QLog.isDevelopLevel()) {
                                QLog.d("LebaUnitedConfigHelper", 4, "doLoadConfigData[" + i18 + "-" + i26 + "] " + b17);
                            }
                            LebaPluginConfig lebaPluginConfig = new LebaPluginConfig();
                            lebaPluginConfig.uiResId = next.c();
                            lebaPluginConfig.groupId = i19;
                            lebaPluginConfig.priority = com.tencent.mobileqq.leba.core.f.h(i19, i26);
                            String a16 = next.a();
                            if (a16 == null) {
                                a16 = "";
                            }
                            lebaPluginConfig.allowChange = a16;
                            String f16 = next.f();
                            if (f16 != null) {
                                str = f16;
                            }
                            lebaPluginConfig.style = str;
                            i16 = 1;
                            lebaPluginConfig.show = !next.d() ? (short) 1 : (short) 0;
                            lebaPluginConfig.showVer = next.e();
                            lebaPluginConfig.strResName = b17.e();
                            lebaPluginConfig.strResURL = b17.c();
                            lebaPluginConfig.strGotoUrl = b17.d();
                            lebaPluginConfig.sResSubType = (short) b17.f();
                            lebaPluginConfig.resConf = b17.a();
                            lebaPluginConfig.strGridIconUrl = b17.b();
                            if (QLog.isDevelopLevel()) {
                                QLog.d("LebaUnitedConfigHelper", 4, "parsePluginConfig: " + lebaPluginConfig.printLog());
                            }
                            arrayList.add(lebaPluginConfig);
                            i17 = i16;
                            i26 = i27;
                            it6 = it;
                        }
                    }
                }
                it = it6;
                i16 = i17;
                i17 = i16;
                i26 = i27;
                it6 = it;
            }
            i18 = i19;
        }
        QLog.d("LebaUnitedConfigHelper", 4, "doLoadConfigData size: " + arrayList.size() + " ");
        Iterator it7 = arrayList.iterator();
        int i28 = 0;
        while (it7.hasNext()) {
            QLog.d("LebaUnitedConfigHelper", 2, "doLoadConfigData[" + i28 + "]: " + ((LebaPluginConfig) it7.next()).printLog());
            i28++;
        }
        QLog.d("LebaUnitedConfigHelper", 4, "doLoadConfigData end ");
        return arrayList;
    }

    public static final boolean c() {
        return ((Boolean) getAllPluginListSwitch.getValue()).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) pluginDataSourceSwitch.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IUnitedConfigManager e() {
        return (IUnitedConfigManager) unitedConfigApi.getValue();
    }

    private final List<LebaPluginConfig> i() {
        String loadAsString = e().loadAsString("quanjupeizhi_4042", "");
        QLog.d("LebaUnitedConfigHelper", 4, "doLoadConfigPlugins loadAsString: " + loadAsString);
        return b(loadAsString);
    }

    private final LebaPluginInfo j(LebaPluginConfig lebaPluginConfig, int mode, int style) {
        boolean z16;
        LebaPluginInfo lebaPluginInfo = new LebaPluginInfo();
        lebaPluginInfo.uiResId = lebaPluginConfig.uiResId;
        lebaPluginInfo.strResName = lebaPluginConfig.strResName;
        lebaPluginInfo.sResSubType = lebaPluginConfig.sResSubType;
        lebaPluginInfo.strGotoUrl = lebaPluginConfig.strGotoUrl;
        lebaPluginInfo.strResURL = lebaPluginConfig.strResURL;
        lebaPluginInfo.strGridIconUrl = lebaPluginConfig.strGridIconUrl;
        lebaPluginInfo.strSimpleResUrl = lebaPluginConfig.strSimpleResUrl;
        lebaPluginInfo.resConf = lebaPluginConfig.resConf;
        lebaPluginInfo.groupId = lebaPluginConfig.groupId;
        lebaPluginInfo.sPriority = lebaPluginConfig.priority;
        lebaPluginInfo.setAllowChange(Boolean.valueOf(lebaPluginConfig.checkAllowChange(mode, style)));
        if (lebaPluginConfig.show == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        lebaPluginInfo.setShow(z16, lebaPluginConfig.showVer);
        lebaPluginInfo.showInSimpleMode = !lebaPluginConfig.showInSimpleMode() ? 1 : 0;
        lebaPluginInfo.strPkgName = LocalPluginLogic.d(LocalPluginLogic.f240660a, lebaPluginConfig.uiResId, null, 2, null);
        return lebaPluginInfo;
    }

    @WorkerThread
    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            j.f240495a.b(i());
        }
    }

    @WorkerThread
    @NotNull
    public final List<LebaPluginInfo> g(int mode, int style) {
        List<LebaPluginInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(mode), Integer.valueOf(style));
        }
        ArrayList arrayList = new ArrayList();
        List<LebaPluginConfig> a16 = j.f240495a.a();
        QLog.d("LebaUnitedConfigHelper", 4, "loadLebaConfigData [" + mode + " " + style + "]: " + a16.size());
        for (LebaPluginConfig lebaPluginConfig : a16) {
            boolean checkAvailable = lebaPluginConfig.checkAvailable(mode, style);
            if (QLog.isDevelopLevel()) {
                long j3 = lebaPluginConfig.uiResId;
                short s16 = lebaPluginConfig.show;
                QLog.d("LebaUnitedConfigHelper", 4, "loadLebaConfigData plugin[" + j3 + "]: " + checkAvailable + ", show:[" + ((int) s16) + "," + lebaPluginConfig.showVer + "] info: " + lebaPluginConfig.resConf);
            }
            if (checkAvailable) {
                arrayList.add(j(lebaPluginConfig, mode, style));
            }
        }
        QLog.d("LebaUnitedConfigHelper", 4, "loadLebaConfigData size: " + arrayList.size() + "  ");
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    @WorkerThread
    @NotNull
    public final List<LebaPluginInfo> h() {
        List<LebaPluginInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String loadAsString = e().loadAsString("teenager_4026", "");
        QLog.d("LebaUnitedConfigHelper", 4, "loadLebaConfigDataForTeenager loadAsString: " + loadAsString + " ");
        ArrayList arrayList = new ArrayList();
        Iterator<LebaPluginConfig> it = b(loadAsString).iterator();
        while (it.hasNext()) {
            arrayList.add(j(it.next(), 1, 2));
        }
        QLog.d("LebaUnitedConfigHelper", 4, "loadLebaConfigDataForTeenager size: " + arrayList.size() + "  ");
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }
}
