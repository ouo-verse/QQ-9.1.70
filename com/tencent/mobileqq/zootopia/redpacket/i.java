package com.tencent.mobileqq.zootopia.redpacket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/i;", "", "", "e", "", "id", tl.h.F, "g", "f", "d", "usrId", "", "avatarId", "b", "a", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f329070a = new i();

    i() {
    }

    private final String e() {
        return s84.d.f433509a.c().getCoverUrlPrefix();
    }

    public final String a(String usrId, int id5, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return s84.d.f433509a.c().getUploadUrlPrefix() + "/" + j.f329071a.a(usrId, id5, avatarId);
    }

    public final String b(String usrId, int id5, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return s84.d.f433509a.c().getUploadUrlPrefix() + "/" + j.f329071a.b(usrId, id5, avatarId);
    }

    public final String c(String usrId, int id5, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return s84.d.f433509a.c().getUploadUrlPrefix() + "/" + j.f329071a.c(usrId, id5, avatarId);
    }

    public final String d(int id5) {
        return e() + "/bg/" + id5 + ".png";
    }

    public final String f(int id5) {
        return e() + "/aio/" + id5 + ".png";
    }

    public final String g(int id5) {
        return e() + "/preview/" + id5 + ".png";
    }

    public final String h(int id5) {
        return e() + "/bounce/" + id5 + ".png";
    }
}
