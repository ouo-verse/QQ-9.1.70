package nm3;

import android.content.Context;
import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Landroid/content/Context;", "context", "Lnm3/k;", "endLinkScreenCallback", "", "c", "qq-live-link-pk-anchorplay-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class n {
    public static final void c(@NotNull Context context, @NotNull final k endLinkScreenCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(endLinkScreenCallback, "endLinkScreenCallback");
        com.tencent.qui.a.a(context, 0, "\u786e\u5b9a\u7ed3\u675f\u8fde\u9ea6\u5417\uff1f", "\u8bf7\u6c42\u786e\u4fdd\u7ed3\u675f\u524d\u548c\u5bf9\u65b9\u63d0\u524d\u6c9f\u901a", "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: nm3.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n.d(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: nm3.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n.e(k.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(k endLinkScreenCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(endLinkScreenCallback, "$endLinkScreenCallback");
        endLinkScreenCallback.a();
        dialogInterface.dismiss();
    }
}
