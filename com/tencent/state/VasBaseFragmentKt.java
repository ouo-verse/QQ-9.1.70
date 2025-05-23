package com.tencent.state;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001aJ\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\t\u00a8\u0006\r"}, d2 = {"setFragmentResult", "", "Landroidx/fragment/app/Fragment;", "requestKey", "", "result", "Landroid/os/Bundle;", "setFragmentResultListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class VasBaseFragmentKt {
    public static final void setFragmentResult(Fragment setFragmentResult, String requestKey, Bundle result) {
        Intrinsics.checkNotNullParameter(setFragmentResult, "$this$setFragmentResult");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(result, "result");
        setFragmentResult.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(Fragment setFragmentResultListener, String requestKey, final Function2<? super String, ? super Bundle, Unit> listener) {
        Intrinsics.checkNotNullParameter(setFragmentResultListener, "$this$setFragmentResultListener");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        setFragmentResultListener.getParentFragmentManager().setFragmentResultListener(requestKey, setFragmentResultListener, new FragmentResultListener() { // from class: com.tencent.state.VasBaseFragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(String p06, Bundle p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                Intrinsics.checkNotNullExpressionValue(Function2.this.invoke(p06, p16), "invoke(...)");
            }
        });
    }
}
