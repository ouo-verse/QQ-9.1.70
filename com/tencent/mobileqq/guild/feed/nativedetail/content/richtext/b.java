package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView;
import com.tencent.mobileqq.guild.feed.preload.detail.data.FeedDetailTextViewPreloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk1.e;
import org.jetbrains.annotations.NotNull;
import wq0.i;
import wq0.j;
import wq0.l;
import wq0.m;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/b;", "", "Landroid/content/Context;", "context", "Lwq0/l;", "b", "", "size", "", "maxLines", "spacingAdd", "color", "c", "Landroid/widget/TextView;", "f", "", "text", "e", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f221402a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/b$a", "Lwq0/m;", "", "widthMeasureSpec", "heightMeasureSpec", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements m {
        a() {
        }

        @Override // wq0.m
        public void a(int widthMeasureSpec, int heightMeasureSpec) {
            FeedDetailTextViewPreloadHelper.f222783a.c(View.MeasureSpec.getSize(widthMeasureSpec));
        }
    }

    b() {
    }

    public static /* synthetic */ l d(b bVar, Context context, float f16, int i3, float f17, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            f16 = 18.0f;
        }
        float f18 = f16;
        if ((i17 & 4) != 0) {
            i3 = 6;
        }
        int i18 = i3;
        if ((i17 & 8) != 0) {
            f17 = 20.0f;
        }
        float f19 = f17;
        if ((i17 & 16) != 0) {
            i16 = R.color.qui_common_text_primary;
        }
        return bVar.c(context, f18, i18, f19, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        e.f416895a.l(50L, context);
        return false;
    }

    @NotNull
    public final l b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        l c16 = j.c(j.f446044a, context, false, false, 4, null);
        c16.getView().setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        c16.getView().setClickable(false);
        c16.getView().setFocusable(false);
        c16.setTextSize(16.0f);
        c16.c(16.0f);
        c16.setLetterSpacing(0.02f);
        ColorStateList colorStateList = context.getResources().getColorStateList(R.color.qui_common_text_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getCol\u2026.qui_common_text_primary)");
        c16.setTextColor(colorStateList);
        c16.b(new i());
        c16.getView().setId(R.id.w8d);
        return c16;
    }

    @NotNull
    public final l c(@NotNull Context context, float size, int maxLines, float spacingAdd, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        l c16 = j.c(j.f446044a, context, false, false, 4, null);
        c16.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        c16.getView().setClickable(false);
        c16.getView().setFocusable(false);
        c16.c(spacingAdd);
        c16.setTextSize(size);
        c16.setMaxLines(maxLines);
        ColorStateList colorStateList = context.getResources().getColorStateList(color);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getColorStateList(color)");
        c16.setTextColor(colorStateList);
        c16.setEllipsize(TextUtils.TruncateAt.END);
        c16.b(new i());
        c16.a(new a());
        c16.getView().setId(R.id.wbn);
        return c16;
    }

    @NotNull
    public final l e(@NotNull Context context, @NotNull String text, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        l c16 = j.c(j.f446044a, context, false, false, 4, null);
        c16.setTextSize(16.0f);
        c16.f(text, "");
        c16.setTextColor(color);
        c16.setEllipsize(TextUtils.TruncateAt.END);
        c16.setMaxLines(1);
        c16.getView().setClickable(false);
        c16.getView().setFocusable(false);
        c16.b(new i());
        return c16;
    }

    @NotNull
    public final TextView f(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GestureTextView gestureTextView = new GestureTextView(context);
        gestureTextView.setId(R.id.f165512we2);
        gestureTextView.setTextIsSelectable(true);
        gestureTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean g16;
                g16 = b.g(context, view);
                return g16;
            }
        });
        gestureTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        gestureTextView.setTextSize(18.0f);
        gestureTextView.setLetterSpacing(0.01875f);
        gestureTextView.setLineSpacing(26.0f, 1.0f);
        gestureTextView.setTextColor(context.getResources().getColorStateList(R.color.qui_common_text_primary));
        return gestureTextView;
    }
}
