package com.tencent.mobileqq.wink.editor.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.videocut.model.FilterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/g;", "", "Lcom/tencent/videocut/model/FilterModel;", "a", "Lcom/tencent/videocut/model/FilterModel;", "()Lcom/tencent/videocut/model/FilterModel;", "filterModel", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "", "c", "Z", "()Z", "onlyIntensity", "<init>", "(Lcom/tencent/videocut/model/FilterModel;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FilterModel filterModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MetaMaterial metaMaterial;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean onlyIntensity;

    public g() {
        this(null, null, false, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final FilterModel getFilterModel() {
        return this.filterModel;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final MetaMaterial getMetaMaterial() {
        return this.metaMaterial;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getOnlyIntensity() {
        return this.onlyIntensity;
    }

    public g(@Nullable FilterModel filterModel, @Nullable MetaMaterial metaMaterial, boolean z16) {
        this.filterModel = filterModel;
        this.metaMaterial = metaMaterial;
        this.onlyIntensity = z16;
    }

    public /* synthetic */ g(FilterModel filterModel, MetaMaterial metaMaterial, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : filterModel, (i3 & 2) != 0 ? null : metaMaterial, (i3 & 4) != 0 ? false : z16);
    }
}
