package com.tencent.aio.widget.textView.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0002\u0010\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H&J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J2\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/g;", "", "Lcom/tencent/aio/widget/textView/creator/g$b;", "observer", "", "b", "Lcom/tencent/aio/widget/textView/param/b;", "aioStaticParam", "Lcom/tencent/aio/widget/textView/cache/a;", "f", "param", "Landroid/content/Context;", "context", "Landroid/text/TextPaint;", "paint", "complete", "a", "Landroid/text/StaticLayout;", "d", "", "text", "Landroid/graphics/drawable/Drawable$Callback;", "drawableCallback", "Lcom/tencent/aio/widget/textView/creator/g$a;", "Lcom/tencent/aio/widget/textView/view/a;", TtmlNode.TAG_SPAN, "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "c", "g", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/g$a;", "", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "drawables", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "b", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface a {
        void b(@NotNull ArrayList<Drawable> drawables, int taskId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/g$b;", "", "Lcom/tencent/aio/widget/textView/param/b;", "param", "Landroid/text/StaticLayout;", "staticLayout", "", "a", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void a(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull StaticLayout staticLayout);
    }

    void a(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull Context context, @NotNull TextPaint paint, @NotNull b complete);

    void b(@NotNull b observer);

    void c(@NotNull CharSequence text, @NotNull Drawable.Callback drawableCallback, @NotNull a complete, @Nullable com.tencent.aio.widget.textView.view.a span, int taskId);

    @NotNull
    StaticLayout d(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull Context context, @NotNull TextPaint paint);

    @Nullable
    com.tencent.aio.widget.textView.cache.a f(@NotNull com.tencent.aio.widget.textView.param.b aioStaticParam);

    void g(int taskId);
}
