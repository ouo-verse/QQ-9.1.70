package com.tencent.guild.aio.panel.provider;

import android.content.Context;
import android.view.View;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lq0.d;
import lq0.i;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/panel/provider/a;", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "d", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Llq0/i;", "e", "Llq0/i;", "appInfoFactory", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;Llq0/i;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.part.root.panel.mvx.config.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i appInfoFactory;

    public a(@NotNull c panelParam, @NotNull i appInfoFactory) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        Intrinsics.checkNotNullParameter(appInfoFactory, "appInfoFactory");
        this.panelParam = panelParam;
        this.appInfoFactory = appInfoFactory;
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    @NotNull
    public View a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new d(this.appInfoFactory, this.panelParam).a(context);
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public void onDestroy() {
    }
}
