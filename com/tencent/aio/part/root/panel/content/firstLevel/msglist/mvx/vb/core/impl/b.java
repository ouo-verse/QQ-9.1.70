package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J+\u0010\u0011\u001a\u00020\u00042!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\u000bH&J+\u0010\u0013\u001a\u00020\u00042!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000bH&J\b\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0006H&J\b\u0010\u0017\u001a\u00020\u0006H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/c;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl;", "refresher", "", "setRefresher", "", "enable", "c", "enableLoadMore", "k", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "headHeight", "complete", "j", "footerHeight", h.F, "b", "d", "f", "g", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface b extends c {
    int b();

    void c(boolean enable);

    int d();

    boolean f();

    boolean g();

    void h(@NotNull Function1<? super Integer, Unit> complete);

    void j(@NotNull Function1<? super Integer, Unit> complete);

    void k(boolean enableLoadMore);

    void setRefresher(@NotNull AIORefreshImpl refresher);
}
