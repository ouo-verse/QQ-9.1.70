package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.i;
import com.tencent.mobileqq.qqlive.widget.chat.message.o;
import com.tencent.mobileqq.qqlive.widget.util.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.widget.AbsListView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\b\u00a2\u0006\u0004\b!\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatWishHelpItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "b", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "", "a", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/o;", "message", "", "roomId", "anchorId", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "fontSize", CanvasView.ACTION_SET_FONT_SIZE, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "contentTv", "e", "anchorWishContentTv", "Landroid/text/method/LinkMovementMethod;", "f", "Landroid/text/method/LinkMovementMethod;", "linkMovementMethod", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ChatWishHelpItemView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView contentTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView anchorWishContentTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkMovementMethod linkMovementMethod;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatWishHelpItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatWishHelpItemView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/itemview/ChatWishHelpItemView$b", "Landroid/text/method/LinkMovementMethod;", "Landroid/widget/TextView;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends LinkMovementMethod {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(@NotNull TextView widget, @NotNull Spannable buffer, @NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, widget, buffer, event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Intrinsics.checkNotNullParameter(event, "event");
            try {
                return super.onTouchEvent(widget, buffer, event);
            } catch (Exception e16) {
                QLog.e("LiveWishHelpItemView", 1, "onTouchEvent fail:" + e16.getMessage());
                return false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/itemview/ChatWishHelpItemView$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "textPaint", "updateDrawState", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ vi2.c f273826d;

        c(vi2.c cVar) {
            this.f273826d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            vi2.c cVar = this.f273826d;
            if (cVar != null) {
                cVar.L();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                Intrinsics.checkNotNullParameter(textPaint, "textPaint");
                textPaint.setUnderlineText(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30429);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatWishHelpItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.linkMovementMethod = new b();
            b(context);
        }
    }

    private final int a(f msg2) {
        com.tencent.mobileqq.qqlive.widget.chat.data.a a16;
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar;
        pq4.c cVar;
        String str;
        i header = msg2.getHeader();
        if (header != null && (a16 = header.a()) != null && (bVar = a16.f273754a) != null && (cVar = bVar.f273761f) != null && (str = cVar.f427027e) != null) {
            return Color.parseColor(str);
        }
        return e.a(R.color.cld);
    }

    private final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.h9h, (ViewGroup) this, true);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        TextView textView = (TextView) inflate.findViewById(R.id.f635433t);
        this.contentTv = textView;
        if (textView != null) {
            textView.setMovementMethod(this.linkMovementMethod);
        }
        TextView textView2 = this.contentTv;
        if (textView2 != null) {
            textView2.setLongClickable(false);
        }
        this.anchorWishContentTv = (TextView) inflate.findViewById(R.id.f635433t);
    }

    @SuppressLint({"SetTextI18n"})
    public final void c(@NotNull o message, long roomId, long anchorId, @Nullable vi2.a dataSupport, @Nullable vi2.c playFunc) {
        String str;
        int lastIndexOf$default;
        int lastIndexOf$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, message, Long.valueOf(roomId), Long.valueOf(anchorId), dataSupport, playFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.b() == null) {
            return;
        }
        if (message.b().f273763a != 0 && !TextUtils.isEmpty(message.b().f273764b)) {
            ClickableSpan clickableSpan = null;
            if (playFunc != null) {
                str = playFunc.f(roomId, message.b().f273764b, message.b().f273763a, anchorId);
            } else {
                str = null;
            }
            String content = message.b().f273767e;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + content);
            if (playFunc != null) {
                clickableSpan = playFunc.H(message, anchorId);
            }
            Intrinsics.checkNotNull(str);
            spannableStringBuilder.setSpan(clickableSpan, 0, str.length(), 17);
            spannableStringBuilder.setSpan(new StyleSpan(0), 0, str.length(), 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(a(message)), 0, str.length(), 33);
            int length = str.length() + 1;
            Intrinsics.checkNotNullExpressionValue(content, "content");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) content, HippyTKDListViewAdapter.X, 0, false, 6, (Object) null);
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) content, "\u52a9\u529b\u4e3b\u64ad\u5b9e\u73b0\u5fc3\u613f", 0, false, 6, (Object) null);
            if (lastIndexOf$default > 0 && lastIndexOf$default2 > 0) {
                spannableStringBuilder.setSpan(new StyleSpan(0), lastIndexOf$default, lastIndexOf$default2, 33);
            }
            spannableStringBuilder.setSpan(new c(playFunc), length, spannableStringBuilder.length(), 17);
            TextView textView = this.contentTv;
            Intrinsics.checkNotNull(textView);
            textView.setText(spannableStringBuilder);
            return;
        }
        TextView textView2 = this.contentTv;
        Intrinsics.checkNotNull(textView2);
        textView2.setText(message.b().f273766d);
    }

    public final void setFontSize(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fontSize);
            return;
        }
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        float sp5 = fontSize.getSp();
        TextView textView = this.anchorWishContentTv;
        if (textView != null) {
            textView.setTextSize(1, sp5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatWishHelpItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.linkMovementMethod = new b();
            b(context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatWishHelpItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.linkMovementMethod = new b();
            b(context);
        }
    }
}
