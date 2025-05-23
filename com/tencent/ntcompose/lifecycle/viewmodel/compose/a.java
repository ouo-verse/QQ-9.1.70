package com.tencent.ntcompose.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"com/tencent/ntcompose/lifecycle/viewmodel/compose/ViewModelKt__ViewModelKt"}, k = 4, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class a {
    public static final <VM extends g> VM a(k kVar, KClass<VM> kClass, String str, i.b bVar, b bVar2) {
        return (VM) ViewModelKt__ViewModelKt.a(kVar, kClass, str, bVar, bVar2);
    }

    public static final <viewModel extends com.tencent.ntcompose.lifecycle.common.b> void b(viewModel viewmodel, Lifecycle lifecycle, Composer composer, int i3) {
        ViewModelKt__ViewModelKt.b(viewmodel, lifecycle, composer, i3);
    }

    public static final <VM extends g> VM c(KClass<VM> kClass, k kVar, String str, i.b bVar, b bVar2, Composer composer, int i3, int i16) {
        return (VM) ViewModelKt__ViewModelKt.c(kClass, kVar, str, bVar, bVar2, composer, i3, i16);
    }
}
