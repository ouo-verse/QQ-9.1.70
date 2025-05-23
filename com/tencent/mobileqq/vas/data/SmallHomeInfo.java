package com.tencent.mobileqq.vas.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b+\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b\n\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b'\u0010\u001a\"\u0004\b$\u0010\u001cR\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b!\u0010\u001a\"\u0004\b)\u0010\u001c\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getUin", "()J", "setUin", "(J)V", "uin", "b", "Z", "getOpenBasement", "()Z", "i", "(Z)V", "openBasement", "c", "I", "()I", tl.h.F, "(I)V", "likeCnt", "d", "j", "roomCnt", "e", "k", "squareCnt", "f", "g", "furnitureCnt", "getFloorCnt", "floorCnt", "l", "visitors", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.data.d, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SmallHomeInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean openBasement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int likeCnt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int roomCnt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int squareCnt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int furnitureCnt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int floorCnt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int visitors;

    public SmallHomeInfo() {
        this(0L, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getFurnitureCnt() {
        return this.furnitureCnt;
    }

    /* renamed from: b, reason: from getter */
    public final int getLikeCnt() {
        return this.likeCnt;
    }

    /* renamed from: c, reason: from getter */
    public final int getRoomCnt() {
        return this.roomCnt;
    }

    /* renamed from: d, reason: from getter */
    public final int getSquareCnt() {
        return this.squareCnt;
    }

    /* renamed from: e, reason: from getter */
    public final int getVisitors() {
        return this.visitors;
    }

    public final void f(int i3) {
        this.floorCnt = i3;
    }

    public final void g(int i3) {
        this.furnitureCnt = i3;
    }

    public final void h(int i3) {
        this.likeCnt = i3;
    }

    public int hashCode() {
        return com.tencent.mobileqq.vas.banner.c.a(this.uin);
    }

    public final void i(boolean z16) {
        this.openBasement = z16;
    }

    public final void j(int i3) {
        this.roomCnt = i3;
    }

    public final void k(int i3) {
        this.squareCnt = i3;
    }

    public final void l(int i3) {
        this.visitors = i3;
    }

    public String toString() {
        return "SmallHomeInfo(uin=" + this.uin + ")";
    }

    public SmallHomeInfo(long j3) {
        this.uin = j3;
    }

    public /* synthetic */ SmallHomeInfo(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SmallHomeInfo) && this.uin == ((SmallHomeInfo) other).uin;
    }
}
