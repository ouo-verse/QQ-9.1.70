package com.tencent.mobileqq.icgame.widget.chat.itemview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.tencent.mobileqq.qqlive.widget.chat.span.LinkMovementLongClickMethod;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w42.f;
import wi2.d;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 I2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u0015\u00a2\u0006\u0004\bG\u0010HJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ6\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u0014\u0010#\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010(\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b \u0010%\u001a\u0004\b&\u0010'R\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b!\u0010,\"\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020<8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "", "setSupportFunc", "j", "", "", "spans", "setSpanText", "", "text", "Landroid/text/style/CharacterStyle;", "style", "Landroid/text/SpannableString;", "d", "Landroid/graphics/Bitmap;", "bmp", "", "bmpWidth", "bmpHeight", "leftMargin", "rightMargin", "Landroid/text/SpannableStringBuilder;", "a", "Lw42/f;", "msg", "k", "setSelfPadding", "i", h.F, "Landroid/text/SpannableStringBuilder;", "contentSpannable", "Landroid/text/style/ForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "getNickSpan", "()Landroid/text/style/ForegroundColorSpan;", "nickSpan", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "()J", "setRoomId", "(J)V", "roomId", BdhLogUtil.LogTag.Tag_Conn, "Lz42/a;", "f", "()Lz42/a;", "setDataSupport", "(Lz42/a;)V", "D", "Lz42/c;", "g", "()Lz42/c;", "setPlayFunc", "(Lz42/c;)V", "Landroid/graphics/drawable/GradientDrawable;", "E", "Lkotlin/Lazy;", "e", "()Landroid/graphics/drawable/GradientDrawable;", "bgDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class ChatBaseText extends AppCompatTextView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private z42.a dataSupport;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private c playFunc;

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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatBaseText(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
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
        spannableStringBuilder.setSpan(new y42.a(bmp, leftMargin, rightMargin), 0, 1, 33);
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableString d(@NotNull String text, @Nullable CharacterStyle style) {
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
        return (GradientDrawable) this.bgDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: f, reason: from getter */
    public final z42.a getDataSupport() {
        return this.dataSupport;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: g, reason: from getter */
    public final c getPlayFunc() {
        return this.playFunc;
    }

    /* renamed from: h, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public int i() {
        return wi2.c.b(24);
    }

    public final void j() {
        c cVar = this.playFunc;
        if (cVar != null) {
            cVar.m();
        }
    }

    public final void k(@NotNull f msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        c cVar = this.playFunc;
        if (cVar != null) {
            cVar.z(this, msg2);
        }
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public void setSelfPadding() {
        setPadding(wi2.c.b(12), wi2.c.b(3), wi2.c.b(12), wi2.c.b(3));
    }

    public final void setSpanText(@NotNull List<? extends CharSequence> spans) {
        y42.b bVar;
        Intrinsics.checkNotNullParameter(spans, "spans");
        this.contentSpannable.clear();
        this.contentSpannable.clearSpans();
        for (CharSequence charSequence : spans) {
            if (!(charSequence instanceof SpannableString)) {
                SpannableString spannableString = new SpannableString(charSequence);
                c cVar = this.playFunc;
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

    public final void setSupportFunc(@Nullable z42.a dataSupport, @Nullable c playFunc) {
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatBaseText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChatBaseText(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatBaseText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentSpannable = new SpannableStringBuilder();
        this.nickSpan = new ForegroundColorSpan(c52.a.a(R.color.alc));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText$bgDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable c16 = d.c(new GradientDrawable(), wi2.c.d(20), wi2.c.d(20), wi2.c.d(20), wi2.c.d(20));
                c16.setColor(c52.a.a(R.color.bbd));
                return c16;
            }
        });
        this.bgDrawable = lazy;
        setSelfPadding();
        setBackgroundDrawable(e());
        setTextColor(c52.a.a(R.color.f158017al3));
        wi2.b.d(this, 14.0f);
        setTypeface(Typeface.DEFAULT_BOLD);
        setIncludeFontPadding(false);
        setLineSpacing(0.0f, 1.3f);
        setHighlightColor(0);
        setMovementMethod(LinkMovementLongClickMethod.c());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(wi2.b.b(this), wi2.b.b(this));
        setGravity(16);
        setMinHeight(i());
        setLayoutParams(layoutParams);
    }
}
