package com.tencent.guild.aio.panel.provider;

import android.content.Context;
import android.view.View;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/panel/provider/PhotoPanelProvider;", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "hidePanel", "showPanel", "", "e", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "d", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVB;", "Lkotlin/Lazy;", "g", "()Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVB;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "f", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class PhotoPanelProvider extends com.tencent.aio.part.root.panel.mvx.config.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy panel;

    public PhotoPanelProvider(@NotNull c panelParam) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.panelParam = panelParam;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildPhotoPanelVB>() { // from class: com.tencent.guild.aio.panel.provider.PhotoPanelProvider$panel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildPhotoPanelVB invoke() {
                c cVar;
                cVar = PhotoPanelProvider.this.panelParam;
                return new GuildPhotoPanelVB(cVar);
            }
        });
        this.panel = lazy;
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    @NotNull
    public View a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g().c(context);
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public void e(@Nullable Integer hidePanel, @Nullable Integer showPanel) {
        if (showPanel != null && showPanel.intValue() == 1003) {
            QLog.i("PhotoPanelProvider", 4, "refreshList");
            g().i();
        }
    }

    @NotNull
    public final GuildPhotoPanelVB g() {
        return (GuildPhotoPanelVB) this.panel.getValue();
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public void onDestroy() {
        g().h();
    }
}
