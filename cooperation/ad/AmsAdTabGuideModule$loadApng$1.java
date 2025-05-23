package cooperation.ad;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/d;", "it", "", "invoke", "(Lcom/tencent/cachedrawable/dynamicdrawable/d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class AmsAdTabGuideModule$loadApng$1 extends Lambda implements Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit> {
    final /* synthetic */ Function1<Drawable, Unit> $cb;
    final /* synthetic */ FastDynamicDrawable $drawable;
    final /* synthetic */ String $url;
    final /* synthetic */ AmsAdTabGuideModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AmsAdTabGuideModule$loadApng$1(FastDynamicDrawable fastDynamicDrawable, String str, AmsAdTabGuideModule amsAdTabGuideModule, Function1<? super Drawable, Unit> function1) {
        super(1);
        this.$drawable = fastDynamicDrawable;
        this.$url = str;
        this.this$0 = amsAdTabGuideModule;
        this.$cb = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 cb5, FastDynamicDrawable drawable) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        cb5.invoke(drawable);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        invoke2(dVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (this.$drawable.x()) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<Drawable, Unit> function1 = this.$cb;
            final FastDynamicDrawable fastDynamicDrawable = this.$drawable;
            uIHandlerV2.post(new Runnable() { // from class: cooperation.ad.v
                @Override // java.lang.Runnable
                public final void run() {
                    AmsAdTabGuideModule$loadApng$1.b(Function1.this, fastDynamicDrawable);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(this.$url, "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/QQmobile/%E5%B0%8F%E6%89%8B_%E6%8F%90%E7%A4%BA%E5%BC%95%E5%AF%BC.png")) {
            return;
        }
        this.this$0.n("https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/QQmobile/%E5%B0%8F%E6%89%8B_%E6%8F%90%E7%A4%BA%E5%BC%95%E5%AF%BC.png", this.$cb);
    }
}
