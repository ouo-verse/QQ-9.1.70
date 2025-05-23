package com.tencent.kuikly.core.render.android.core;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import d01.w;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B?\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/core/d;", "Lkotlin/Function0;", "", "b", "a", "Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore;", "d", "Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/kuikly/core/render/android/core/a;", "e", "Lcom/tencent/kuikly/core/render/android/core/a;", "initCallback", "", "f", "Ljava/lang/String;", "contextCode", h.F, "url", "", "", "i", "Ljava/util/Map;", "params", "<init>", "(Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore;Lcom/tencent/kuikly/core/render/android/core/a;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class d implements Function0<Unit> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private KuiklyRenderCore instance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a initCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String contextCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String url;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> params;

    public d(@Nullable KuiklyRenderCore kuiklyRenderCore, @Nullable a aVar, @NotNull String contextCode, @NotNull String url, @NotNull Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        this.instance = kuiklyRenderCore;
        this.initCallback = aVar;
        this.contextCode = contextCode;
        this.url = url;
        this.params = params;
    }

    public final void a() {
        this.instance = null;
        this.initCallback = null;
    }

    public void b() {
        KuiklyRenderCore kuiklyRenderCore = this.instance;
        if (kuiklyRenderCore == null) {
            w.f392617a.c("RenderCoreWeakInitContentHandlerTask", "render core init is null: " + this.url);
            return;
        }
        a aVar = this.initCallback;
        if (aVar == null) {
            w.f392617a.c("RenderCoreWeakInitContentHandlerTask", "init callback is null: " + this.url);
            return;
        }
        kuiklyRenderCore.V(this.contextCode, this.url, this.params, aVar);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        b();
        return Unit.INSTANCE;
    }
}
