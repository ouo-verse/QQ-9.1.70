package com.tencent.mobileqq.troop.troopselector.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorFragment;", "x9", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class a extends Part {
    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: x9, reason: merged with bridge method [inline-methods] */
    public TroopSelectorFragment getPartHost() {
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment");
        return (TroopSelectorFragment) partHost;
    }
}
