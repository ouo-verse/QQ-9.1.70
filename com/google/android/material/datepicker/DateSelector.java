package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public interface DateSelector<S> extends Parcelable {
    boolean K();

    void L(long j3);

    @NonNull
    Collection<Pair<Long, Long>> P();

    @StyleRes
    int R(Context context);

    @NonNull
    Collection<Long> T();

    @Nullable
    S X();

    @NonNull
    View d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull i<S> iVar);

    @NonNull
    String h(Context context);
}
