package com.tencent.mobileqq.qqvideoedit.zplan.parts;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
/* synthetic */ class VideoEditExportGifPart$onVideoExportStart$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoEditExportGifPart$onVideoExportStart$1(Object obj) {
        super(1, obj, VideoEditExportGifPart.class, "showGifProgress", "showGifProgress(Z)Lkotlin/Unit;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }

    @Nullable
    public final Unit invoke(boolean z16) {
        Unit ia5;
        ia5 = ((VideoEditExportGifPart) this.receiver).ia(z16);
        return ia5;
    }
}
