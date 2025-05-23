package com.tencent.mobileqq.wink.editor.music.lyric.sticker;

import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
final class WinkEditorLyricStickerAdapter$setDefaultData$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WinkEditorLyricStickerAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorLyricStickerAdapter$setDefaultData$2(WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter) {
        super(0);
        this.this$0 = winkEditorLyricStickerAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorLyricStickerAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.B().size() > 1) {
            this$0.P(1, this$0.B().get(1));
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = this.this$0;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorLyricStickerAdapter$setDefaultData$2.b(WinkEditorLyricStickerAdapter.this);
            }
        });
    }
}
