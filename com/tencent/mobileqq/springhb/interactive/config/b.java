package com.tencent.mobileqq.springhb.interactive.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u000fH&J\b\u0010\u0016\u001a\u00020\u0002H&J\b\u0010\u0017\u001a\u00020\bH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/config/b;", "", "", "i", "Lorg/libpag/PAGFile;", "a", "", "b", "", "e", "getId", "", "getType", "c", "f", "", h.F, "getSessionId", "getChatType", "k", "getSource", "g", "j", "d", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    @Nullable
    PAGFile a();

    boolean b();

    @NotNull
    String c();

    @NotNull
    String d();

    @NotNull
    String e();

    @NotNull
    String f();

    double g();

    int getChatType();

    @NotNull
    String getId();

    @NotNull
    String getSessionId();

    int getSource();

    int getType();

    double h();

    long i();

    long j();

    @NotNull
    String k();
}
