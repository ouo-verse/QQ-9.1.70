package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import androidx.annotation.CallSuper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0017R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/theme/d;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcom/tencent/mobileqq/guild/theme/d;", "_weakThemeCallback", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class av<T> extends ar<T> implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.theme.d _weakThemeCallback;

    public av() {
        final WeakReference weakReference = new WeakReference(this);
        com.tencent.mobileqq.guild.theme.d dVar = new com.tencent.mobileqq.guild.theme.d() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.au
            @Override // com.tencent.mobileqq.guild.theme.d
            public final void onThemeChanged() {
                av.t(weakReference);
            }
        };
        this._weakThemeCallback = dVar;
        GuildThemeManager.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(WeakReference weakThis) {
        Intrinsics.checkNotNullParameter(weakThis, "$weakThis");
        av avVar = (av) weakThis.get();
        if (avVar != null) {
            avVar.onThemeChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        GuildThemeManager.j(this._weakThemeCallback);
    }
}
