package com.tencent.mobileqq.guild.feed;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0007B!\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/a;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "", "a", "Landroid/text/TextPaint;", "ds", "updateDrawState", "", "color", "b", "d", "Ljava/lang/Integer;", "textColor", "e", "Z", "isUnderlineText", "Lcom/tencent/mobileqq/guild/feed/a$a;", "f", "Lcom/tencent/mobileqq/guild/feed/a$a;", "callback", "<init>", "(Ljava/lang/Integer;ZLcom/tencent/mobileqq/guild/feed/a$a;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class a extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer textColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isUnderlineText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC7734a callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/a$a;", "", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/style/ClickableSpan;", TtmlNode.TAG_SPAN, "", "a", "", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC7734a {
        void a(@NotNull View widget, @NotNull ClickableSpan span);

        boolean b(@NotNull View widget, @NotNull ClickableSpan span);
    }

    public a(@Nullable Integer num, boolean z16, @NotNull InterfaceC7734a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.textColor = num;
        this.isUnderlineText = z16;
        this.callback = callback;
    }

    public final boolean a(@NotNull View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        return this.callback.b(widget, this);
    }

    public final void b(int color) {
        this.textColor = Integer.valueOf(color);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.callback.a(widget, this);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds5) {
        Intrinsics.checkNotNullParameter(ds5, "ds");
        super.updateDrawState(ds5);
        ds5.setUnderlineText(this.isUnderlineText);
        Integer num = this.textColor;
        if (num != null) {
            ds5.setColor(num.intValue());
        }
    }
}
