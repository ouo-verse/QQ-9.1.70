package com.tencent.luggage.wxa.f8;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/luggage/wxa/f8/t;", "Lcom/tencent/luggage/wxa/f8/g;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a$d;", "type", "", "path", "", "a", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "c", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "weEffectManager", "<init>", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class t implements g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a weEffectManager;

    public t(@NotNull com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a weEffectManager) {
        Intrinsics.checkNotNullParameter(weEffectManager, "weEffectManager");
        this.weEffectManager = weEffectManager;
    }

    @Override // com.tencent.luggage.wxa.f8.g
    public void a(@NotNull a.d type, @NotNull String path) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.IWeEffectWorkaroundManager", "applyMakeup, type: " + type + ", path: " + path);
        this.weEffectManager.a(type, path);
    }
}
