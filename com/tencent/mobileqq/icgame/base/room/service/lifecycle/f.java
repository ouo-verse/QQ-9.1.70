package com.tencent.mobileqq.icgame.base.room.service.lifecycle;

import i22.PageLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\b\u001a\u00020\u0006H\u0096\u0001J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/f;", "", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/d;", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/e;", "", "c", "", "a", "b", "e", "i", h.F, "g", "j", "f", "d", "p", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/PageLifecycle;", "l", "Lg32/h;", "Lg32/h;", "trigger", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/PageLifecycle;", "curPageLifecycle", "pageVisible", "<init>", "(Lg32/h;Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/e;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f implements d, e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g32.h trigger;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e f237241b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageLifecycle curPageLifecycle;

    public f(@NotNull g32.h trigger, @NotNull e pageVisible) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(pageVisible, "pageVisible");
        this.trigger = trigger;
        this.f237241b = pageVisible;
        this.curPageLifecycle = PageLifecycle.NONE;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.e
    public void a() {
        this.f237241b.a();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.e
    public void b() {
        this.f237241b.b();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.e
    /* renamed from: c */
    public boolean getIsPageIn() {
        return this.f237241b.getIsPageIn();
    }

    public void d() {
        PageLifecycle pageLifecycle = PageLifecycle.DESTROY;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    public void e() {
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_CREATE;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    public void f() {
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_DESTROY;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    public void g() {
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_PAUSE;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    public void h() {
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_RESUME;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    public void i() {
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_START;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    public void j() {
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_STOP;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.w0(new PageLifecycleEvent(pageLifecycle));
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.d
    @NotNull
    /* renamed from: l, reason: from getter */
    public PageLifecycle getCurPageLifecycle() {
        return this.curPageLifecycle;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.d
    public boolean p() {
        return getIsPageIn();
    }
}
