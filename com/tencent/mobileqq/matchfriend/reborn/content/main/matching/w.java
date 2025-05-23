package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/w;", "Landroid/app/Dialog;", "", "d", "", "title", tl.h.F, "message", "g", "Lkotlin/Function0;", "listener", "e", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "messageView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/Button;", "Landroid/widget/Button;", "button", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class w extends Dialog {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView titleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView messageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Button button;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        requestWindowFeature(1);
        setContentView(R.layout.f167362cx0);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View findViewById = findViewById(R.id.orj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.omm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.message)");
        this.messageView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.ok8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image)");
        this.imageView = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.oj5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.button)");
        Button button = (Button) findViewById4;
        this.button = button;
        d();
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.c(w.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(w this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void d() {
        com.tencent.mobileqq.matchfriend.reborn.utils.p.b(this.imageView, "https://downv6.qq.com/extendfriend/qqstranger_voice_need_know_dialog.png", new ColorDrawable(Color.parseColor("#e3f3ff")), false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(w this$0, Function0 listener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        this$0.dismiss();
        listener.invoke();
    }

    public final void e(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.f(w.this, listener, view);
            }
        });
    }

    public final void g(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.messageView.setText(message);
    }

    public final void h(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.titleView.setText(title);
    }
}
