package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "", "Lcom/tencent/zplan/record/a;", "scene", "", "enableFilament", "a", "", "", "enableListUsingFilament", "Ljava/util/List;", "b", "()Ljava/util/List;", "setEnableListUsingFilament", "(Ljava/util/List;)V", "enableListUsingUE", "getEnableListUsingUE", "setEnableListUsingUE", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ag {

    @SerializedName(ZPlanApiImpl.FILAMENT_TAG)
    private List<Integer> enableListUsingFilament = new ArrayList();

    @SerializedName("ue")
    private List<Integer> enableListUsingUE = new ArrayList();

    public final boolean a(com.tencent.zplan.record.a scene, boolean enableFilament) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (enableFilament) {
            return this.enableListUsingFilament.contains(Integer.valueOf(scene.getValue()));
        }
        return this.enableListUsingUE.contains(Integer.valueOf(scene.getValue()));
    }

    public final List<Integer> b() {
        return this.enableListUsingFilament;
    }
}
