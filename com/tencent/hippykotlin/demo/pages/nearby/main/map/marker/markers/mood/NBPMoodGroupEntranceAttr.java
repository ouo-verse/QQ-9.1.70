package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPMoodGroupEntranceAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMoodGroupEntranceAttr.class, "joinedMood", "getJoinedMood()Z", 0)};
    public final ReadWriteProperty joinedMood$delegate = c.a(Boolean.FALSE);
    public NBPMoodGroupEntranceMarkerViewModel viewModel;

    public final NBPMoodGroupEntranceMarkerViewModel getViewModel() {
        NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel = this.viewModel;
        if (nBPMoodGroupEntranceMarkerViewModel != null) {
            return nBPMoodGroupEntranceMarkerViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
