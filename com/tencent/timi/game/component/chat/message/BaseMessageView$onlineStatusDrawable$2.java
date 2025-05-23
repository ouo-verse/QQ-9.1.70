package com.tencent.timi.game.component.chat.message;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/GradientDrawable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
final class BaseMessageView$onlineStatusDrawable$2 extends Lambda implements Function0<GradientDrawable> {
    public static final BaseMessageView$onlineStatusDrawable$2 INSTANCE = new BaseMessageView$onlineStatusDrawable$2();

    BaseMessageView$onlineStatusDrawable$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GradientDrawable invoke() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(fh4.b.d(45));
        gradientDrawable.setStroke(fh4.b.b(1), Color.parseColor("#00CC8F"));
        return gradientDrawable;
    }
}
