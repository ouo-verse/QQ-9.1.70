package com.tencent.mobileqq.wink.dailysign;

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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/al;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMedia", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "", "assetData", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "winkTavCutParams", "<init>", "(Ljava/util/List;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/Map;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lcom/tencent/mobileqq/wink/editor/dr$c;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class al extends com.tencent.mobileqq.wink.lowthresholdltemplate.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(@Nullable List<? extends LocalMediaInfo> list, @NotNull MetaMaterial material, @Nullable Map<String, String> map, @NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull dr.WinkTavCutParams winkTavCutParams) {
        super(list, material, map, winkEditDataWrapper, winkTavCutParams);
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(winkTavCutParams, "winkTavCutParams");
    }
}
