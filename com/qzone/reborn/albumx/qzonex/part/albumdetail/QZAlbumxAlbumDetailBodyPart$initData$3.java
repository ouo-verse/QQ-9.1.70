package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.widget.FrameLayout;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001 \u0003*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/richframework/data/base/UIStateData;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailBodyPart$initData$3 extends Lambda implements Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit> {
    final /* synthetic */ QZAlbumxAlbumDetailBodyPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxAlbumDetailBodyPart$initData$3(QZAlbumxAlbumDetailBodyPart qZAlbumxAlbumDetailBodyPart) {
        super(1);
        this.this$0 = qZAlbumxAlbumDetailBodyPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZAlbumxAlbumDetailBodyPart this$0) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        frameLayout = this$0.loadingViewContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uIStateData) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        frameLayout = this.this$0.loadingViewContainer;
        boolean z16 = false;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            nc.y yVar = this.this$0.viewModel;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                yVar = null;
            }
            if (yVar.getIsFromCache()) {
                frameLayout3 = this.this$0.loadingViewContainer;
                if (frameLayout3 == null) {
                    return;
                }
                frameLayout3.setVisibility(8);
                return;
            }
            frameLayout2 = this.this$0.loadingViewContainer;
            if (frameLayout2 != null) {
                final QZAlbumxAlbumDetailBodyPart qZAlbumxAlbumDetailBodyPart = this.this$0;
                frameLayout2.postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailBodyPart$initData$3.b(QZAlbumxAlbumDetailBodyPart.this);
                    }
                }, 100L);
            }
        }
    }
}
