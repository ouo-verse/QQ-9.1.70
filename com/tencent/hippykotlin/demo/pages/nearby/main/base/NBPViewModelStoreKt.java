package com.tencent.hippykotlin.demo.pages.nearby.main.base;

import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.notify.NBPNotifyViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;

/* loaded from: classes31.dex */
public final class NBPViewModelStoreKt {
    public static final NBPMainControlViewModel getControlViewModel(NBPViewModelStore nBPViewModelStore) {
        return (NBPMainControlViewModel) nBPViewModelStore.getViewModel("NBPMainControlViewModel");
    }

    public static final NBPGuideViewModel getGuideViewModel(NBPViewModelStore nBPViewModelStore) {
        return (NBPGuideViewModel) nBPViewModelStore.getViewModel("NBPGuideViewModel");
    }

    public static final NBPMainHeatMapViewModel getHeatMapVM(NBPViewModelStore nBPViewModelStore) {
        return (NBPMainHeatMapViewModel) nBPViewModelStore.getViewModel("NBPMainHeatMapViewModel");
    }

    public static final NBPMainMapThemeViewModel getMapThemeVM(NBPViewModelStore nBPViewModelStore) {
        return (NBPMainMapThemeViewModel) nBPViewModelStore.getViewModel("NBPMainMapThemeViewModel");
    }

    public static final NBPMainMapViewModel getMapViewModel(NBPViewModelStore nBPViewModelStore) {
        return (NBPMainMapViewModel) nBPViewModelStore.getViewModel("NBPMainMapViewModel");
    }

    public static final NBPMarkersViewModel getMarkersViewModel(NBPViewModelStore nBPViewModelStore) {
        return (NBPMarkersViewModel) nBPViewModelStore.getViewModel("NBPMarkersViewModel");
    }

    public static final NBPNotifyViewModel getMsgNotifyViewModel(NBPViewModelStore nBPViewModelStore) {
        return (NBPNotifyViewModel) nBPViewModelStore.getViewModel("NBPNotifyViewModel");
    }

    public static final NBPMainTitleViewModel getTitleViewModel(NBPViewModelStore nBPViewModelStore) {
        return (NBPMainTitleViewModel) nBPViewModelStore.getViewModel("NBPMainTitleViewModel");
    }
}
