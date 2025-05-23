package com.tencent.mobileqq.troop.troopcard.reborn.ktx;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "Landroidx/lifecycle/MutableLiveData;", "newValue", "", "a", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    public static final <T> void a(@NotNull MutableLiveData<T> mutableLiveData, T t16) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        if (!Intrinsics.areEqual(mutableLiveData.getValue(), t16)) {
            mutableLiveData.setValue(t16);
        }
    }
}
