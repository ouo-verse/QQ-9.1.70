package com.tencent.qqnt.aio.helper;

import android.content.Context;
import com.tencent.qqnt.aio.helper.ZplanEntranceHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
/* synthetic */ class ZplanEntranceHelper$onCreate$1 extends FunctionReferenceImpl implements Function0<Context> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Context invoke() {
        return ((ZplanEntranceHelper.b) this.receiver).getContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZplanEntranceHelper$onCreate$1(Object obj) {
        super(0, obj, ZplanEntranceHelper.b.class, "getContext", "getContext()Landroid/content/Context;", 0);
    }
}
