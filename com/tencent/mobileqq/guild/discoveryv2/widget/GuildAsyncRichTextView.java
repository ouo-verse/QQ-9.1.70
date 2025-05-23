package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.style.NoScrollLinkMovementMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001d\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cB%\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildAsyncRichTextView;", "Lcom/tencent/richframework/text/rich/RFWAsyncRichTextView;", "", "getParseType", "", "performClick", "Landroid/text/method/MovementMethod;", "getDefaultMovementMethod", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", h.F, "I", "getGuildParseType", "()I", "setGuildParseType", "(I)V", "guildParseType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAsyncRichTextView extends RFWAsyncRichTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int guildParseType;

    public GuildAsyncRichTextView(@Nullable Context context) {
        super(context, null);
        this.guildParseType = 2;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, android.widget.TextView
    @NotNull
    protected MovementMethod getDefaultMovementMethod() {
        NoScrollLinkMovementMethod noScrollLinkMovementMethod = NoScrollLinkMovementMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(noScrollLinkMovementMethod, "getInstance()");
        return noScrollLinkMovementMethod;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    /* renamed from: getParseType, reason: from getter */
    protected int getGuildParseType() {
        return this.guildParseType;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (info != null) {
            String emoticonToTextForTalkBack = TextUtils.emoticonToTextForTalkBack(getText().toString());
            if (emoticonToTextForTalkBack == null) {
                emoticonToTextForTalkBack = "";
            }
            info.setText(emoticonToTextForTalkBack);
        }
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (isSpanClick()) {
            return true;
        }
        return super.performClick();
    }

    public final void setGuildParseType(int i3) {
        this.guildParseType = i3;
    }

    public GuildAsyncRichTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guildParseType = 2;
    }

    public GuildAsyncRichTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.guildParseType = 2;
    }
}
