package com.tencent.mobileqq.wink.lowthresholdltemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0004\u0010\fR%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/util/List;", "getLocalMedias", "()Ljava/util/List;", "localMedias", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "", "c", "Ljava/util/Map;", "getAssetData", "()Ljava/util/Map;", "assetData", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "d", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "e", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "()Lcom/tencent/mobileqq/wink/editor/dr$c;", "winkTavCutParams", "<init>", "(Ljava/util/List;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/Map;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lcom/tencent/mobileqq/wink/editor/dr$c;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<LocalMediaInfo> localMedias;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MetaMaterial material;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<String, String> assetData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditDataWrapper winkEditDataWrapper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dr.WinkTavCutParams winkTavCutParams;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable List<? extends LocalMediaInfo> list, @NotNull MetaMaterial material, @Nullable Map<String, String> map, @NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull dr.WinkTavCutParams winkTavCutParams) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(winkTavCutParams, "winkTavCutParams");
        this.localMedias = list;
        this.material = material;
        this.assetData = map;
        this.winkEditDataWrapper = winkEditDataWrapper;
        this.winkTavCutParams = winkTavCutParams;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final WinkEditDataWrapper getWinkEditDataWrapper() {
        return this.winkEditDataWrapper;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final dr.WinkTavCutParams getWinkTavCutParams() {
        return this.winkTavCutParams;
    }
}
