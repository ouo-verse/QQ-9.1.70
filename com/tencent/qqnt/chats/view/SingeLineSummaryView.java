package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.view.a;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u0012\u00a2\u0006\u0004\b\u001b\u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/view/SingeLineSummaryView;", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "Lcom/tencent/qqnt/chats/view/a;", "", "content", "", "setSummaryContent", "allContent", "setSummaryAllContent", "Landroid/graphics/drawable/Drawable;", "drawable", "setSummaryStatus", "", "prefix", "setSummaryPrefix", "Landroid/content/res/ColorStateList;", "color", "setSummaryPrefixColor", "", "setSummaryTextColor", "Landroid/graphics/Shader;", "shader", "setSummaryContentShader", "Landroid/graphics/Paint;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SingeLineSummaryView extends SingleLineTextView implements a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingeLineSummaryView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.qqnt.chats.view.a
    @NotNull
    public Paint a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Paint) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        Paint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        return paint;
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            a.C9601a.a(this, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryAllContent(@NotNull CharSequence allContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) allContent);
        } else {
            Intrinsics.checkNotNullParameter(allContent, "allContent");
            setText(allContent);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryContent(@NotNull CharSequence content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) content);
        } else {
            Intrinsics.checkNotNullParameter(content, "content");
            setText(content);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryContentShader(@Nullable Shader shader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) shader);
        } else {
            getPaint().setShader(shader);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryNick(@NotNull CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) charSequence);
        } else {
            a.C9601a.c(this, charSequence);
        }
    }

    public void setSummaryPrefix(@NotNull String prefix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) prefix);
        } else {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            setExtendText(prefix, 1);
        }
    }

    public void setSummaryPrefixColor(@NotNull ColorStateList color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) color);
        } else {
            Intrinsics.checkNotNullParameter(color, "color");
            setExtendTextColor(color, 1);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummarySendStatus(@Nullable Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) num);
        } else {
            a.C9601a.d(this, num);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryStatus(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
            return;
        }
        setCompoundDrawables(drawable, null);
        if (drawable != null) {
            setCompoundDrawablePadding(com.tencent.aio.view_dsl.dsl.c.b(2));
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryTextColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, color);
        } else {
            setTextColor(color);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingeLineSummaryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryPrefix(@NotNull CharSequence prefix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) prefix);
        } else {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            setExtendText(prefix.toString(), 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingeLineSummaryView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
