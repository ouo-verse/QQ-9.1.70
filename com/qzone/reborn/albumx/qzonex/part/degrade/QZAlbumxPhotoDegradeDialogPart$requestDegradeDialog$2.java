package com.qzone.reborn.albumx.qzonex.part.degrade;

import android.os.Handler;
import com.tencent.mobileqq.vas.troop.e;
import com.tencent.richframework.thread.RFWThreadManager;
import fo.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/e$c;", "dialogData", "", "invoke", "(Lcom/tencent/mobileqq/vas/troop/e$c;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxPhotoDegradeDialogPart$requestDegradeDialog$2 extends Lambda implements Function1<e.DialogData, Unit> {
    final /* synthetic */ QZAlbumxPhotoDegradeDialogPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxPhotoDegradeDialogPart$requestDegradeDialog$2(QZAlbumxPhotoDegradeDialogPart qZAlbumxPhotoDegradeDialogPart) {
        super(1);
        this.this$0 = qZAlbumxPhotoDegradeDialogPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZAlbumxPhotoDegradeDialogPart this$0, e.DialogData dialogData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9(dialogData);
        HashMap hashMap = new HashMap();
        hashMap.put("belong_app", 1);
        hashMap.put("action_type", "imp");
        c.c("ev_qz_yellowdiamond_demotion_pop", hashMap);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e.DialogData dialogData) {
        invoke2(dialogData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final e.DialogData dialogData) {
        if (dialogData != null) {
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final QZAlbumxPhotoDegradeDialogPart qZAlbumxPhotoDegradeDialogPart = this.this$0;
            uIHandler.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.degrade.a
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxPhotoDegradeDialogPart$requestDegradeDialog$2.b(QZAlbumxPhotoDegradeDialogPart.this, dialogData);
                }
            });
        }
    }
}
