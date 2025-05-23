package com.qzone.reborn.albumx.qzonex.part.upload;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isGray", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxUploadQualitySelectBarPart$initVasData$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ QZAlbumxUploadQualitySelectBarPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxUploadQualitySelectBarPart$initVasData$1(QZAlbumxUploadQualitySelectBarPart qZAlbumxUploadQualitySelectBarPart) {
        super(1);
        this.this$0 = qZAlbumxUploadQualitySelectBarPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZAlbumxUploadQualitySelectBarPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9(z16);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final QZAlbumxUploadQualitySelectBarPart qZAlbumxUploadQualitySelectBarPart = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.k
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxUploadQualitySelectBarPart$initVasData$1.b(QZAlbumxUploadQualitySelectBarPart.this, z16);
            }
        });
    }
}
