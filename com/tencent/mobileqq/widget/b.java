package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ex;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0013\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/widget/b;", "", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "c", "", "d", "I", "getLayoutId", "()I", "layoutId", "e", "Landroid/view/View;", "()Landroid/view/View;", "rlRoot", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "ivIcon", "Lcom/tencent/mobileqq/widget/RedDotTextView;", tl.h.F, "Lcom/tencent/mobileqq/widget/RedDotTextView;", "()Lcom/tencent/mobileqq/widget/RedDotTextView;", "tvRedDot", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", "tvSetting", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes20.dex */
public class b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int layoutId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rlRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView ivIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RedDotTextView tvRedDot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView tvSetting;

    public b(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutId = i3;
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n            .inflate(layoutId, null)");
        this.rlRoot = inflate;
        View findViewById = inflate.findViewById(R.id.un_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rlRoot.findViewById(R.id.drawer_settings_img)");
        this.ivIcon = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.una);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rlRoot.findViewById(R.id\u2026rawer_settings_reddot_iv)");
        this.tvRedDot = (RedDotTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.unb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rlRoot.findViewById(R.id.drawer_settings_tx)");
        TextView textView = (TextView) findViewById3;
        this.tvSetting = textView;
        textView.setTextColor(ex.b(R.color.qui_common_text_primary));
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.widget.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b16;
                b16 = b.b(b.this, view, motionEvent);
                return b16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(b this$0, View v3, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (event.getAction() == 0) {
            v3.setAlpha(0.5f);
            v3.invalidate();
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            v3.setAlpha(1.0f);
            v3.invalidate();
        }
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        Intrinsics.checkNotNullExpressionValue(event, "event");
        this$0.c(v3, event);
        return false;
    }

    public void c(@NotNull View v3, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ImageView getIvIcon() {
        return this.ivIcon;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final View getRlRoot() {
        return this.rlRoot;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final RedDotTextView getTvRedDot() {
        return this.tvRedDot;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final TextView getTvSetting() {
        return this.tvSetting;
    }
}
