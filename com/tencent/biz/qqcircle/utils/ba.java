package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/ba;", "", "Landroid/content/Context;", "context", "", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ba f92679a = new ba();

    ba() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, h.a(R.string.f188013vj), h.a(R.string.f188033vl), (String) null, h.a(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.utils.az
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ba.c(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026           null\n        )");
        createCustomDialog.show();
    }
}
