package com.tencent.mobileqq.wink.request.material;

import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/request/material/a;", "", "", "b", "c", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f326269a = new a();

    a() {
    }

    @NotNull
    public final String a() {
        if (c()) {
            return "32";
        }
        return "2";
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return AECameraPrefsUtil.c().b("SP_TEST_ENVIRONMENT", false, 0);
    }
}
