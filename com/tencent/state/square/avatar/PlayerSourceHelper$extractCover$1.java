package com.tencent.state.square.avatar;

import android.widget.ImageView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.extractor.ExtractorExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PlayerSourceHelper$extractCover$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ MapPlayableSource $source;
    final /* synthetic */ String $uniqueId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerSourceHelper$extractCover$1(MapPlayableSource mapPlayableSource, String str, ImageView imageView) {
        super(0);
        this.$source = mapPlayableSource;
        this.$uniqueId = str;
        this.$imageView = imageView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean extractCover = ExtractorExtensionsKt.extractCover(this.$source.getMediaSource(), new PlayerSourceHelper$extractCover$1$result$1(this));
        SquareBaseKt.getSquareLog().i("PlayerSourceHelper", "extract cover done " + extractCover + ", " + this.$uniqueId);
    }
}
