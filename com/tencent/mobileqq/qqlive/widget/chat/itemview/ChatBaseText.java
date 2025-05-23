package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.i;
import com.tencent.mobileqq.qqlive.widget.chat.span.LinkMovementLongClickMethod;
import com.tencent.mobileqq.qqlive.widget.util.e;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 M2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u0015\u00a2\u0006\u0004\bK\u0010LJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ6\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"R\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010-\u001a\u00020(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b)\u00101\"\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b%\u0010=\"\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020@8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "", "setSupportFunc", "k", "", "", "spans", "setSpanText", "", "text", "Landroid/text/style/CharacterStyle;", "style", "Landroid/text/SpannableString;", "d", "Landroid/graphics/Bitmap;", "bmp", "", "bmpWidth", "bmpHeight", "leftMargin", "rightMargin", "Landroid/text/SpannableStringBuilder;", "a", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "l", "setSelfPadding", "j", "g", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "fontSize", CanvasView.ACTION_SET_FONT_SIZE, h.F, "Landroid/text/SpannableStringBuilder;", "contentSpannable", "Landroid/text/style/ForegroundColorSpan;", "i", "Landroid/text/style/ForegroundColorSpan;", "getNickSpan", "()Landroid/text/style/ForegroundColorSpan;", "nickSpan", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "()J", "setRoomId", "(J)V", "roomId", BdhLogUtil.LogTag.Tag_Conn, "Lvi2/a;", "f", "()Lvi2/a;", "setDataSupport", "(Lvi2/a;)V", "D", "Lvi2/c;", "()Lvi2/c;", "setPlayFunc", "(Lvi2/c;)V", "Landroid/graphics/drawable/GradientDrawable;", "E", "Lkotlin/Lazy;", "e", "()Landroid/graphics/drawable/GradientDrawable;", "bgDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class ChatBaseText extends AppCompatTextView {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private vi2.a dataSupport;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private vi2.c playFunc;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bgDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder contentSpannable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ForegroundColorSpan nickSpan;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText$a;", "", "", "RADIUS_CORNER", "I", "", "SYS_MSG_UID", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatBaseText(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, (Object) this, (Object) context);
    }

    public static /* synthetic */ SpannableStringBuilder b(ChatBaseText chatBaseText, Bitmap bitmap, int i3, int i16, int i17, int i18, int i19, Object obj) {
        int i26;
        int i27;
        if (obj == null) {
            if ((i19 & 2) != 0) {
                i3 = bitmap.getWidth();
            }
            int i28 = i3;
            if ((i19 & 4) != 0) {
                i16 = bitmap.getHeight();
            }
            int i29 = i16;
            if ((i19 & 8) != 0) {
                i26 = 0;
            } else {
                i26 = i17;
            }
            if ((i19 & 16) != 0) {
                i27 = 0;
            } else {
                i27 = i18;
            }
            return chatBaseText.a(bitmap, i28, i29, i26, i27);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genImageSpan");
    }

    @NotNull
    public final SpannableStringBuilder a(@NotNull Bitmap bmp, int bmpWidth, int bmpHeight, int leftMargin, int rightMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 15, this, bmp, Integer.valueOf(bmpWidth), Integer.valueOf(bmpHeight), Integer.valueOf(leftMargin), Integer.valueOf(rightMargin));
        }
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("i");
        if (bmpWidth != bmp.getWidth() || bmpHeight != bmp.getHeight()) {
            Bitmap scaledBitmap = Bitmap.createBitmap(bmpWidth, bmpHeight, Bitmap.Config.ARGB_8888);
            scaledBitmap.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
            float f16 = bmpWidth;
            float width = f16 / bmp.getWidth();
            float f17 = bmpHeight;
            float height = f17 / bmp.getHeight();
            float f18 = f16 / 2.0f;
            float f19 = f17 / 2.0f;
            Matrix matrix = new Matrix();
            matrix.setScale(width, height, f18, f19);
            Canvas canvas = new Canvas(scaledBitmap);
            canvas.setMatrix(matrix);
            canvas.drawBitmap(bmp, f18 - (bmp.getWidth() / 2), f19 - (bmp.getHeight() / 2), new Paint(7));
            Intrinsics.checkNotNullExpressionValue(scaledBitmap, "scaledBitmap");
            bmp = scaledBitmap;
        }
        spannableStringBuilder.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.a(bmp, leftMargin, rightMargin), 0, 1, 33);
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableString d(@NotNull String text, @Nullable CharacterStyle style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SpannableString) iPatchRedirector.redirect((short) 14, (Object) this, (Object) text, (Object) style);
        }
        Intrinsics.checkNotNullParameter(text, "text");
        SpannableString spannableString = new SpannableString(text);
        if (style != null) {
            spannableString.setSpan(style, 0, text.length(), 17);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final GradientDrawable e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (GradientDrawable) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (GradientDrawable) this.bgDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final vi2.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (vi2.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.dataSupport;
    }

    public int g(@Nullable f msg2) {
        String str;
        i header;
        com.tencent.mobileqq.qqlive.widget.chat.data.a a16;
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar;
        pq4.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) msg2)).intValue();
        }
        if (msg2 != null && (header = msg2.getHeader()) != null && (a16 = header.a()) != null && (bVar = a16.f273754a) != null && (cVar = bVar.f273761f) != null) {
            str = cVar.f427027e;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return e.a(R.color.cld);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Chat_Message|ChatBaseText", "nickColor invalid", "nickColor:" + str + ", err:" + e16);
            return e.a(R.color.cld);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final vi2.c h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (vi2.c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.playFunc;
    }

    public final long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return wi2.c.b(24);
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        vi2.c cVar = this.playFunc;
        if (cVar != null) {
            cVar.m();
        }
    }

    public final void l(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        vi2.c cVar = this.playFunc;
        if (cVar != null) {
            cVar.M(this, msg2);
        }
    }

    public final void setFontSize(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) fontSize);
        } else {
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            wi2.b.d(this, fontSize.getSp());
        }
    }

    public final void setRoomId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.roomId = j3;
        }
    }

    public void setSelfPadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            setPadding(wi2.c.b(8), wi2.c.b(4), wi2.c.b(8), wi2.c.b(4));
        }
    }

    public final void setSpanText(@NotNull List<? extends CharSequence> spans) {
        com.tencent.mobileqq.qqlive.widget.chat.span.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) spans);
            return;
        }
        Intrinsics.checkNotNullParameter(spans, "spans");
        this.contentSpannable.clear();
        this.contentSpannable.clearSpans();
        for (CharSequence charSequence : spans) {
            if (!(charSequence instanceof SpannableString)) {
                SpannableString spannableString = new SpannableString(charSequence);
                vi2.c cVar = this.playFunc;
                if (cVar != null) {
                    bVar = cVar.v();
                } else {
                    bVar = null;
                }
                spannableString.setSpan(bVar, 0, charSequence.length(), 17);
                charSequence = spannableString;
            }
            this.contentSpannable.append(charSequence);
        }
        setText(this.contentSpannable);
        setMovementMethod(LinkMovementLongClickMethod.c());
    }

    public final void setSupportFunc(@Nullable vi2.a dataSupport, @Nullable vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) dataSupport, (Object) playFunc);
        } else {
            this.dataSupport = dataSupport;
            this.playFunc = playFunc;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatBaseText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ChatBaseText(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatBaseText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.contentSpannable = new SpannableStringBuilder();
        this.nickSpan = new ForegroundColorSpan(e.a(R.color.alc));
        lazy = LazyKt__LazyJVMKt.lazy(ChatBaseText$bgDrawable$2.INSTANCE);
        this.bgDrawable = lazy;
        setSelfPadding();
        setBackgroundDrawable(e());
        setTextColor(e.a(R.color.cla));
        wi2.b.d(this, 14.0f);
        setTypeface(Typeface.DEFAULT_BOLD);
        setIncludeFontPadding(false);
        setLineSpacing(0.0f, 1.3f);
        setHighlightColor(0);
        setMovementMethod(LinkMovementLongClickMethod.c());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(wi2.b.b(this), wi2.b.b(this));
        setGravity(16);
        setMinHeight(j());
        setLayoutParams(layoutParams);
    }
}
