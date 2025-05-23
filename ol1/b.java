package ol1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.e;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002J\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lol1/b;", "", "", "sendStatus", "Landroid/content/Context;", "context", "Landroid/text/style/ImageSpan;", "f", "Landroid/graphics/drawable/Drawable;", "c", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Landroid/text/method/MovementMethod;", "text", "", "a", "e", "d", "bgColor", "b", "", "timeStr", "", "showReply", "", "g", "", UserInfo.SEX_FEMALE, "ROLE_BG_DRAWABLE_CORNER_RADIUS_PX", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f423088a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float ROLE_BG_DRAWABLE_CORNER_RADIUS_PX = ViewUtils.dpToPx(2.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0017\u0010\u001b\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001c8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%\u00a8\u0006+"}, d2 = {"ol1/b$a", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "t", "", ReportConstant.COSTREPORT_PREFIX, "e", "Landroid/graphics/Paint$FontMetricsInt;", "f", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "", "a", "d", "Ljava/lang/String;", "getReplyText", "()Ljava/lang/String;", "replyText", "", "Z", "getReplyBoldStyle", "()Z", "replyBoldStyle", "I", "getTimeStrWidth", "()I", "setTimeStrWidth", "(I)V", "timeStrWidth", h.F, "getReplyTextWidth", "setReplyTextWidth", "replyTextWidth", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends ReplacementSpan {
        final /* synthetic */ int C;
        final /* synthetic */ int D;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String replyText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean replyBoldStyle;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int timeStrWidth;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int replyTextWidth;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f423094i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f423095m;

        a(boolean z16, float f16, String str, int i3, int i16) {
            String str2;
            this.f423094i = f16;
            this.f423095m = str;
            this.C = i3;
            this.D = i16;
            if (z16) {
                str2 = " \u56de\u590d";
            } else {
                str2 = "";
            }
            this.replyText = str2;
            this.replyBoldStyle = true;
        }

        @Override // android.text.style.ReplacementSpan
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getContentDescription() {
            return this.f423095m + this.replyText;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @NotNull CharSequence t16, int s16, int e16, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(paint, "paint");
            float textSize = paint.getTextSize();
            int color = paint.getColor();
            boolean isFakeBoldText = paint.isFakeBoldText();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i3 = ((((fontMetricsInt.descent + y16) + y16) + fontMetricsInt.ascent) / 2) - ((bottom + top) / 2);
            paint.setTextSize(this.f423094i);
            paint.setColor(this.C);
            float f16 = y16 - i3;
            canvas.drawText(this.f423095m, x16, f16, paint);
            paint.setColor(this.D);
            paint.setFakeBoldText(this.replyBoldStyle);
            canvas.drawText(this.replyText, x16 + this.timeStrWidth, f16, paint);
            paint.setTextSize(textSize);
            paint.setColor(color);
            paint.setFakeBoldText(isFakeBoldText);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NotNull Paint paint, @NotNull CharSequence t16, int s16, int e16, @Nullable Paint.FontMetricsInt f16) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(t16, "t");
            float textSize = paint.getTextSize();
            paint.setTextSize(this.f423094i);
            this.timeStrWidth = (int) paint.measureText(this.f423095m);
            this.replyTextWidth = (int) paint.measureText(this.replyText);
            if (f16 != null) {
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                f16.top = fontMetricsInt.top;
                f16.ascent = fontMetricsInt.ascent;
                f16.descent = fontMetricsInt.descent;
                f16.bottom = fontMetricsInt.bottom;
            }
            paint.setTextSize(textSize);
            return this.timeStrWidth + this.replyTextWidth;
        }
    }

    b() {
    }

    private final ImageSpan f(int sendStatus, Context context) {
        Drawable drawable;
        if (sendStatus != 1) {
            if (sendStatus != 2 || (drawable = ContextCompat.getDrawable(context, R.drawable.f160226dl)) == null) {
                return null;
            }
            drawable.setBounds(ViewUtils.dpToPx(5.0f), 0, ViewUtils.dip2px(25.0f), ViewUtils.dip2px(20.0f));
            return new VerticalCenterImageSpan(drawable, 0);
        }
        Drawable d16 = d(context);
        d16.setBounds(ViewUtils.dpToPx(5.0f), 0, ViewUtils.dip2px(25.0f), ViewUtils.dip2px(20.0f));
        return new VerticalCenterImageSpan(d16, 0);
    }

    public final void a(@NotNull Context context, int sendStatus, @NotNull Pair<? extends SpannableStringBuilder, ? extends MovementMethod> text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        ImageSpan f16 = f(sendStatus, context);
        if (f16 != null) {
            text.getFirst().append((CharSequence) " ");
            text.getFirst().setSpan(f16, text.getFirst().length() - 1, text.getFirst().length(), 34);
        }
    }

    @NotNull
    public final Drawable b(int bgColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(bgColor);
        gradientDrawable.setCornerRadius(ROLE_BG_DRAWABLE_CORNER_RADIUS_PX);
        return gradientDrawable;
    }

    @NotNull
    public final Drawable c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getColor(R.color.qui_common_fill_standard_primary));
        gradientDrawable.setCornerRadius(ROLE_BG_DRAWABLE_CORNER_RADIUS_PX);
        return gradientDrawable;
    }

    @NotNull
    public final Drawable d(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (GuildThemeManager.f235286a.b()) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(context, i3);
        Intrinsics.checkNotNullExpressionValue(loadingDrawable, "getLoadingDrawable(context, type)");
        return loadingDrawable;
    }

    @Nullable
    public final Drawable e(int sendStatus, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (sendStatus != 1) {
            if (sendStatus != 2) {
                return null;
            }
            return ContextCompat.getDrawable(context, R.drawable.f160226dl);
        }
        return d(context);
    }

    @NotNull
    public final CharSequence g(@NotNull String timeStr, boolean showReply, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(timeStr, "timeStr");
        Intrinsics.checkNotNullParameter(context, "context");
        float a16 = e.a(context, 13.0f);
        int color = context.getResources().getColor(R.color.qui_common_text_secondary);
        int color2 = context.getResources().getColor(R.color.qui_common_text_secondary);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        spannableStringBuilder.setSpan(new a(showReply, a16, timeStr, color, color2), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
