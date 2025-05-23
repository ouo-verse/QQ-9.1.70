package com.tencent.mobileqq.zplan.utils;

import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/am;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "FILAMENT_PATH", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f335779a = new am();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String FILAMENT_PATH = BaseApplication.getContext().getCacheDir() + "/zplan/filament";

    am() {
    }

    @NotNull
    public final String a() {
        return FILAMENT_PATH;
    }
}
