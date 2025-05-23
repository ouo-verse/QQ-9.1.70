package com.tencent.aegiskmm.plugin;

import com.tencent.aegiskmm.bean.g;
import com.tencent.kuikly.core.manager.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aegiskmm/plugin/b;", "Lcom/tencent/aegiskmm/bean/g;", "", "a", "b", "Lcom/tencent/aegiskmm/plugin/PagePerformanceObserver;", "Lcom/tencent/aegiskmm/plugin/PagePerformanceObserver;", "observer", "", "c", "Ljava/lang/Long;", "getResLoadCost", "()Ljava/lang/Long;", "resLoadCost", "<init>", "(Ljava/lang/Long;)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class b extends g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final PagePerformanceObserver observer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Long resLoadCost;

    public b(Long l3) {
        this.resLoadCost = l3;
        this.observer = new PagePerformanceObserver(this, l3);
    }

    @Override // com.tencent.aegiskmm.bean.h
    public void a() {
        c.f117352a.g().addPagerEventObserver(this.observer);
    }

    @Override // com.tencent.aegiskmm.bean.h
    public void b() {
    }
}
