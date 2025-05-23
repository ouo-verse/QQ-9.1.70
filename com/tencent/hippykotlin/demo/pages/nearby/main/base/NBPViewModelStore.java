package com.tencent.hippykotlin.demo.pages.nearby.main.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.notify.NBPNotifyViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.NBPMainMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.report.NBPMainTechReportViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;
import f35.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPViewModelStore implements INBPMainLifeCycle {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPViewModelStore.class, "mainMode", "getMainMode()Lcom/tencent/hippykotlin/demo/pages/nearby/main/base/NBPMainMode;", 0)};
    public boolean loginSuccess;
    public final Map<String, NBPMainBaseViewModel> viewModels = new LinkedHashMap();
    public final ReadWriteProperty mainMode$delegate = c.a(NBPMainMode.Normal);
    public NBPSubMode subMode = NBPSubMode.Normal;

    public NBPViewModelStore() {
        registerViewModel("NBPNotifyViewModel", new NBPNotifyViewModel());
        registerViewModel("NBPMainTitleViewModel", new NBPMainTitleViewModel());
        registerViewModel("NBPPendantViewModel", new NBPPendantViewModel());
        registerViewModel("NBPGuideViewModel", new NBPGuideViewModel());
        registerViewModel("NBPMainMapViewModel", new NBPMainMapViewModel());
        registerViewModel("NBPMainLoginViewModel", new NBPMainLoginViewModel());
        registerViewModel("NBPMainHeatMapViewModel", new NBPMainHeatMapViewModel());
        registerViewModel("NBPMarkersViewModel", new NBPMarkersViewModel());
        registerViewModel("NBPMainControlViewModel", new NBPMainControlViewModel());
        registerViewModel("NBPMainTechReportViewModel", new NBPMainTechReportViewModel());
        registerViewModel("NBPMainMapThemeViewModel", new NBPMainMapThemeViewModel());
        registerViewModel("NBPMainMoodGroupViewModel", new NBPMainMoodGroupViewModel());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void dispatchEvent(String str) {
        Iterator it = this.viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onReceiveEvent(str, null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final <T extends NBPMainBaseViewModel> T getViewModel(String str) {
        Object obj = this.viewModels.get(str);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore.getViewModel");
        return (T) obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        Iterator it = this.viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onLocationFinish(z16, nBPSsoLocation);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void onLocationPermissionDenied() {
        Iterator it = this.viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).getClass();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void onLocationPermissionGranted(boolean z16) {
        Iterator it = this.viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onLocationPermissionGranted(z16);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void onModeChanged(NBPMainMode nBPMainMode, NBPSubMode nBPSubMode) {
        Iterator it = this.viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onModeChanged(nBPMainMode, nBPSubMode);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void onNBPLogin(boolean z16, g gVar) {
        this.loginSuccess = z16;
        Iterator it = this.viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onNBPLogin(z16, gVar);
        }
    }

    public final void registerViewModel(String str, NBPMainBaseViewModel nBPMainBaseViewModel) {
        this.viewModels.put(str, nBPMainBaseViewModel);
    }
}
