package com.tencent.kuikly.core.pager;

import com.tencent.kuikly.core.module.PerformanceModule;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u00042\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "", "", "e", "i", tl.h.F, "c", "b", "g", "f", "d", "", "a", "", "J", "newPageStartTimeMills", "newPageEndTimeMills", "createStartTimeMills", "buildStartTimeMills", "buildEndTimeMills", "layoutStartTimeMills", "layoutEndTimeMills", "createEndTimeMills", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PageCreateTrace {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long newPageStartTimeMills = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long newPageEndTimeMills = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long createStartTimeMills = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long buildStartTimeMills = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long buildEndTimeMills = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long layoutStartTimeMills = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long layoutEndTimeMills = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long createEndTimeMills = -1;

    public final String a() {
        HashMap hashMap = new HashMap();
        hashMap.put("on_create_start", Long.valueOf(this.createStartTimeMills));
        hashMap.put("on_create_end", Long.valueOf(this.createEndTimeMills));
        hashMap.put("on_build_start", Long.valueOf(this.buildStartTimeMills));
        hashMap.put("on_build_end", Long.valueOf(this.buildEndTimeMills));
        hashMap.put("on_layout_start", Long.valueOf(this.layoutStartTimeMills));
        hashMap.put("on_layout_end", Long.valueOf(this.layoutEndTimeMills));
        hashMap.put("on_new_page_start", Long.valueOf(this.newPageStartTimeMills));
        hashMap.put("on_new_page_end", Long.valueOf(this.newPageEndTimeMills));
        return b01.c.b(hashMap).toString();
    }

    public final void b() {
        this.buildEndTimeMills = zz0.a.f453719a.a();
    }

    public final void c() {
        this.buildStartTimeMills = zz0.a.f453719a.a();
    }

    public final void d() {
        this.createEndTimeMills = zz0.a.f453719a.a();
        com.tencent.kuikly.core.manager.c.f117352a.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.pager.PageCreateTrace$onCreateEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PerformanceModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRPerformanceModule")).b(PageCreateTrace.this);
            }
        });
    }

    public final void e() {
        this.createStartTimeMills = zz0.a.f453719a.a();
    }

    public final void f() {
        this.layoutEndTimeMills = zz0.a.f453719a.a();
    }

    public final void g() {
        this.layoutStartTimeMills = zz0.a.f453719a.a();
    }

    public final void h() {
        this.newPageEndTimeMills = zz0.a.f453719a.a();
    }

    public final void i() {
        this.newPageStartTimeMills = zz0.a.f453719a.a();
    }
}
