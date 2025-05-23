package com.tencent.android.androidbypass.viewgroup;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.android.androidbypass.richui.view.j;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&JD\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0019\u001a\u00020\u0018H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001c\u001a\u00020\u0004H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/d;", "", "Landroid/content/Context;", "context", "", "nodeId", "contentText", "Landroid/view/View;", "b", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "builder", "nodeType", "Ljava/util/HashMap;", "attribute", "", "g", "e", "view", "c", "", "getMaxWidth", "f", "Lcom/tencent/android/androidbypass/richui/c;", "getRichUIFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "a", "d", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface d {
    @Nullable
    j a();

    @Nullable
    View b(@NotNull Context context, @NotNull String nodeId, @NotNull String contentText);

    void c(@NotNull View view);

    @NotNull
    String d();

    void e(@NotNull TextView textView);

    @NotNull
    TextView f(@NotNull Context context);

    void g(@NotNull TextView textView, @NotNull SpannableStringBuilder builder, @NotNull String nodeType, @NotNull String nodeId, @NotNull String contentText, @NotNull HashMap<String, String> attribute);

    int getMaxWidth();

    @NotNull
    com.tencent.android.androidbypass.richui.c getRichUIFactory();
}
