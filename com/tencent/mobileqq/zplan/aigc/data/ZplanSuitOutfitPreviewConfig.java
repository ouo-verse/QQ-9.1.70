package com.tencent.mobileqq.zplan.aigc.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/ZplanSuitOutfitPreviewConfig;", "", "()V", LightConstants.FEMALE, "", "Lcom/tencent/mobileqq/zplan/aigc/data/SuitAnimationItem;", "getFemale", "()Ljava/util/List;", "setFemale", "(Ljava/util/List;)V", LightConstants.MALE, "getMale", "setMale", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZplanSuitOutfitPreviewConfig {

    @SerializedName(LightConstants.MALE)
    private List<SuitAnimationItem> male = new ArrayList();

    @SerializedName(LightConstants.FEMALE)
    private List<SuitAnimationItem> female = new ArrayList();

    public final List<SuitAnimationItem> getFemale() {
        return this.female;
    }

    public final List<SuitAnimationItem> getMale() {
        return this.male;
    }

    public final void setFemale(List<SuitAnimationItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.female = list;
    }

    public final void setMale(List<SuitAnimationItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.male = list;
    }
}
