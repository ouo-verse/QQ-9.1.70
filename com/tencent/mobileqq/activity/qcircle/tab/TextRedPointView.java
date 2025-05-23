package com.tencent.mobileqq.activity.qcircle.tab;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/tab/TextRedPointView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "Landroid/widget/TextView$BufferType;", "type", "", IECSearchBar.METHOD_SET_TEXT, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TextRedPointView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextRedPointView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundResource(R.drawable.kfl);
        setSingleLine();
    }

    @Override // android.widget.TextView
    public void setText(@NotNull CharSequence text, @NotNull TextView.BufferType type) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        super.setText(text, type);
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setGravity(17);
        setTextColor(-1);
        setTextSize(1, 10.0f);
        setPadding(LayoutAttrsKt.getDp(4), LayoutAttrsKt.getDp(2), LayoutAttrsKt.getDp(4), LayoutAttrsKt.getDp(2));
        setIncludeFontPadding(false);
    }
}
