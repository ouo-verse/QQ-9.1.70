package com.tencent.mobileqq.vas.adv.maskad;

import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002RE\u0010\u0003\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderHelper;", "", "()V", "mMaskAdSizeMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "getMMaskAdSizeMap", "()Ljava/util/HashMap;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MaskAdRenderHelper {

    @NotNull
    public static final MaskAdRenderHelper INSTANCE = new MaskAdRenderHelper();

    @NotNull
    private static final HashMap<MaskAdvName, Pair<Integer, Integer>> mMaskAdSizeMap = new HashMap<>();

    MaskAdRenderHelper() {
    }

    @NotNull
    public final HashMap<MaskAdvName, Pair<Integer, Integer>> getMMaskAdSizeMap() {
        return mMaskAdSizeMap;
    }
}
