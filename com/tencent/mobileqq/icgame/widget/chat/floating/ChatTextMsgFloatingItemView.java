package com.tencent.mobileqq.icgame.widget.chat.floating;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012B#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/floating/ChatTextMsgFloatingItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "", "setNormalBackground", "setAtMsgBackground", "setSysMsgBackground", "setSelfPadding", "", "i", ReportConstant.COSTREPORT_PREFIX, "r", "", "isSelfMsg", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSingLine", "(Landroid/content/Context;Z)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatTextMsgFloatingItemView extends ChatTextMsgItemView {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/floating/ChatTextMsgFloatingItemView$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ContextCompat.getColor(ChatTextMsgFloatingItemView.this.getContext(), R.color.f158017al3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTextMsgFloatingItemView(@NotNull Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText
    public int i() {
        return c.b(14);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView
    @NotNull
    public CharSequence n(boolean isSelfMsg) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u6536\u85cf\u4e86\u4f60");
        spannableStringBuilder.setSpan(new a(), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView
    public int r() {
        return c.b(13);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView
    public int s() {
        return c.b(23);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView
    public void setAtMsgBackground() {
        setBackgroundDrawable(null);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView
    public void setNormalBackground() {
        setBackgroundDrawable(null);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText
    public void setSelfPadding() {
        setPadding(c.b(6), c.b(2), c.b(3), c.b(2));
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView
    public void setSysMsgBackground() {
        setBackgroundDrawable(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTextMsgFloatingItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatTextMsgFloatingItemView(@NotNull Context context, boolean z16) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }
}
