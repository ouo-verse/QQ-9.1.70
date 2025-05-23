package com.qzone.reborn.albumx.qzonex.part.upload;

import android.os.Handler;
import android.widget.RelativeLayout;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.util.Pair;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxUploadQualitySelectBarPart$requestRealVip$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ QZAlbumxUploadQualitySelectBarPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxUploadQualitySelectBarPart$requestRealVip$1(QZAlbumxUploadQualitySelectBarPart qZAlbumxUploadQualitySelectBarPart) {
        super(0);
        this.this$0 = qZAlbumxUploadQualitySelectBarPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZAlbumxUploadQualitySelectBarPart this$0) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        relativeLayout = this$0.openYellowTipsContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        this$0.na();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Pair ca5;
        qc.b V9;
        this.this$0.isRealVip = true;
        ca5 = this.this$0.ca();
        F f16 = ca5.first;
        Intrinsics.checkNotNullExpressionValue(f16, "isImageOrVideoSelected().first");
        if (((Boolean) f16).booleanValue()) {
            V9 = this.this$0.V9();
            V9.k2(3);
            u5.b.L0("photo", 3, LoginData.getInstance().getUin());
            VipNtMMKV.INSTANCE.getCommon(LoginData.getInstance().getUinString()).encodeBool("vas_uplod_photo_key", false);
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final QZAlbumxUploadQualitySelectBarPart qZAlbumxUploadQualitySelectBarPart = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.upload.l
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxUploadQualitySelectBarPart$requestRealVip$1.b(QZAlbumxUploadQualitySelectBarPart.this);
            }
        });
    }
}
