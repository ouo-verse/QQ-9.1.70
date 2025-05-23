package com.tencent.sqshow.zootopia.friendsdressup;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\t\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/t;", "Lcom/tencent/mobileqq/zootopia/scene/data/b;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "masterUin", "b", "getMasterNickName", "c", "masterNickName", "", "Ljava/lang/Integer;", "getMasterSex", "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "masterSex", "getGuestUin", "guestUin", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t extends com.tencent.mobileqq.zootopia.scene.data.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String masterUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String masterNickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Integer masterSex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String guestUin;

    /* renamed from: a, reason: from getter */
    public final String getMasterUin() {
        return this.masterUin;
    }

    public final void b(String str) {
        this.guestUin = str;
    }

    public final void c(String str) {
        this.masterNickName = str;
    }

    public final void d(Integer num) {
        this.masterSex = num;
    }

    public final void e(String str) {
        this.masterUin = str;
    }
}
