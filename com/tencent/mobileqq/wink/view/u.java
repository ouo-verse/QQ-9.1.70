package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ,\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/view/u;", "", "Landroid/content/Context;", "context", "", "url", "titleText", "contentText", "Landroid/view/View$OnClickListener;", "confirmListener", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "e", tl.h.F, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f327143a = new u();

    u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View.OnClickListener onClickListener, QQCustomDialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QQCustomDialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View.OnClickListener onClickListener, QQCustomDialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QQCustomDialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final QQCustomDialog e(@Nullable Context context, @NotNull String url, @Nullable String titleText, @Nullable String contentText, @Nullable final View.OnClickListener confirmListener) {
        Intrinsics.checkNotNullParameter(url, "url");
        final QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.i56);
        ((LinearLayout) qQCustomDialog.findViewById(R.id.bja)).setBackground(null);
        Option picOption = Option.obtain().setTargetView((WinkRoundedCornerImageView) qQCustomDialog.findViewById(R.id.uhh)).setUrl(url);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(picOption, "picOption");
        qQPicLoader.e(picOption, null);
        TextView textView = (TextView) qQCustomDialog.findViewById(R.id.dialogTitle);
        if (titleText != null) {
            textView.setText(titleText);
        }
        TextView textView2 = (TextView) qQCustomDialog.findViewById(R.id.dialogText);
        if (contentText != null) {
            textView2.setText(contentText);
        }
        ((Button) qQCustomDialog.findViewById(R.id.uhm)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.f(confirmListener, qQCustomDialog, view);
            }
        });
        ((ImageView) qQCustomDialog.findViewById(R.id.uhl)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.g(QQCustomDialog.this, view);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(true);
        return qQCustomDialog;
    }

    @NotNull
    public final QQCustomDialog h(@Nullable Context context, @NotNull String url, @Nullable String contentText, @Nullable final View.OnClickListener confirmListener) {
        Intrinsics.checkNotNullParameter(url, "url");
        final QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f169188i55);
        ((LinearLayout) qQCustomDialog.findViewById(R.id.bja)).setBackground(null);
        Option picOption = Option.obtain().setTargetView((WinkRoundedCornerImageView) qQCustomDialog.findViewById(R.id.uhh)).setUrl(url);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(picOption, "picOption");
        qQPicLoader.e(picOption, null);
        TextView textView = (TextView) qQCustomDialog.findViewById(R.id.dialogText);
        if (contentText != null) {
            textView.setText(contentText);
        }
        ((Button) qQCustomDialog.findViewById(R.id.uhm)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.i(confirmListener, qQCustomDialog, view);
            }
        });
        ((ImageView) qQCustomDialog.findViewById(R.id.uhl)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.j(QQCustomDialog.this, view);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(true);
        return qQCustomDialog;
    }
}
