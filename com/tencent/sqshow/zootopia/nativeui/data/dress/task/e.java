package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import com.tencent.tmassistantbase.util.GlobalUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/e;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "Lm94/h;", "callback", "<init>", "(Lm94/h;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(m94.h callback) {
        super(new DressTaskChannel(aa.f371327d, null, 2, null), GlobalUtil.DEF_STRING, new m94.i(callback), false, false, 24, null);
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
    }
}
