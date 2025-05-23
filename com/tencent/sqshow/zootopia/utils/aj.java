package com.tencent.sqshow.zootopia.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/aj;", "", "Landroid/content/Context;", "context", "", "title", "", "iconResId", "", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    public static final aj f373263a = new aj();

    aj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    public final void b(Context context, String title, int iconResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        final Dialog dialog = new Dialog(context, R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.dfe);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.r6b);
        TextView textView = (TextView) dialog.findViewById(R.id.f163652r94);
        View getButton = dialog.findViewById(R.id.r95);
        if (iconResId > 0) {
            imageView.setImageResource(iconResId);
        }
        textView.setText(title);
        Intrinsics.checkNotNullExpressionValue(getButton, "getButton");
        aa.d(getButton, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.utils.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aj.c(dialog, view);
            }
        });
        dialog.show();
    }
}
