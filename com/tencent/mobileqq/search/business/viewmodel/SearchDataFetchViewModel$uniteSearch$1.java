package com.tencent.mobileqq.search.business.viewmodel;

import android.os.Bundle;
import com.tencent.qqnt.kernel.nativeinterface.UfsRspBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public /* synthetic */ class SearchDataFetchViewModel$uniteSearch$1 extends FunctionReferenceImpl implements Function4<Integer, String, UfsRspBody, Bundle, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchDataFetchViewModel$uniteSearch$1(Object obj) {
        super(4, obj, SearchDataFetchViewModel.class, "processUnifySearchRsp", "processUnifySearchRsp(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/UfsRspBody;Landroid/os/Bundle;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, UfsRspBody ufsRspBody, Bundle bundle) {
        invoke(num.intValue(), str, ufsRspBody, bundle);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, @NotNull String p16, @NotNull UfsRspBody p26, @NotNull Bundle p36) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        Intrinsics.checkNotNullParameter(p36, "p3");
        ((SearchDataFetchViewModel) this.receiver).b2(i3, p16, p26, p36);
    }
}
