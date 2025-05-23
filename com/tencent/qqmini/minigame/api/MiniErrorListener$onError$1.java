package com.tencent.qqmini.minigame.api;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes23.dex */
final class MiniErrorListener$onError$1 implements Runnable {
    final /* synthetic */ MiniErrorListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniErrorListener$onError$1(MiniErrorListener miniErrorListener) {
        this.this$0 = miniErrorListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = this.this$0.context;
        MiniCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, GameWnsUtils.getGameErrorDialogContent(), "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.api.MiniErrorListener$onError$1$dialog$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniErrorListener$onError$1.this.this$0.notifyExit();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.api.MiniErrorListener$onError$1$dialog$2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        });
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
    }
}
