package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/al;", "", "", "a", "Z", "e", "()Z", "j", "(Z)V", "useTouchEvent", "b", "d", "i", "useGyroscopeSensor", "c", tl.h.F, "needRoomLoadEvent", "g", "needAvatarLoadEvent", "", "I", "()I", "f", "(I)V", "firstFrameType", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class al {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean useTouchEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean useGyroscopeSensor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean needRoomLoadEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needAvatarLoadEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int firstFrameType = FirstFrameType.NO_NEED.ordinal();

    /* renamed from: a, reason: from getter */
    public final int getFirstFrameType() {
        return this.firstFrameType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedAvatarLoadEvent() {
        return this.needAvatarLoadEvent;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNeedRoomLoadEvent() {
        return this.needRoomLoadEvent;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getUseGyroscopeSensor() {
        return this.useGyroscopeSensor;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getUseTouchEvent() {
        return this.useTouchEvent;
    }

    public final void f(int i3) {
        this.firstFrameType = i3;
    }

    public final void g(boolean z16) {
        this.needAvatarLoadEvent = z16;
    }

    public final void h(boolean z16) {
        this.needRoomLoadEvent = z16;
    }

    public final void i(boolean z16) {
        this.useGyroscopeSensor = z16;
    }

    public final void j(boolean z16) {
        this.useTouchEvent = z16;
    }
}
