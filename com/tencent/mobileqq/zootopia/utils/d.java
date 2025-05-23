package com.tencent.mobileqq.zootopia.utils;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\u0007"}, d2 = {"Landroidx/fragment/app/DialogFragment;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "a", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {
    public static final int a(DialogFragment dialogFragment, FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        return fragmentManager.beginTransaction().add(dialogFragment, str).commitAllowingStateLoss();
    }
}
