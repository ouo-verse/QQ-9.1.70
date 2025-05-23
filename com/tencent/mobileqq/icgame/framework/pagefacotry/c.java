package com.tencent.mobileqq.icgame.framework.pagefacotry;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/c;", "", "", "a", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/connector/b;", "b", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "rootComponentNode", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;", DownloadInfo.spKey_Config, "c", "Ljava/util/List;", "connectorList", "<init>", "(Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ComponentNode rootComponentNode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Class<? extends com.tencent.mobileqq.icgame.framework.connector.b>> connectorList;

    public c(@NotNull ComponentNode rootComponentNode, @NotNull b config) {
        Intrinsics.checkNotNullParameter(rootComponentNode, "rootComponentNode");
        Intrinsics.checkNotNullParameter(config, "config");
        this.rootComponentNode = rootComponentNode;
        this.config = config;
        this.connectorList = new ArrayList();
    }

    public final void a() {
        o32.b b16 = this.config.b();
        if (b16 != null) {
            this.rootComponentNode.c(b16);
        }
        this.config.c(this.rootComponentNode);
        List<Class<? extends com.tencent.mobileqq.icgame.framework.connector.b>> a16 = this.config.a();
        if (a16 != null) {
            this.connectorList.addAll(a16);
        }
    }

    @NotNull
    public final List<Class<? extends com.tencent.mobileqq.icgame.framework.connector.b>> b() {
        return this.connectorList;
    }
}
