package ci1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002\u001a\u0014\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002\u001a\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0004\u001a\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0004\u001a\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0004\u001a\u0014\u0010\u001a\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004\u001a&\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a&\u0010 \u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a(\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006#"}, d2 = {"Landroid/content/Context;", "context", "", "text", "", NodeProps.MARGIN_LEFT, "Landroid/widget/TextView;", "d", "Landroid/view/View;", "c", "colorToken", "b", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", HippyControllerProps.ARRAY, "Landroid/text/SpannableStringBuilder;", "i", "input", "Landroid/text/SpannableString;", "g", "f", "type", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", h.F, "imgUrl", "Landroid/widget/LinearLayout;", "a", "imgRes", "e", "view", "j", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"ci1/b$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Drawable currDrawable = urlDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).getImage().setSupportGlobalPasued(false);
            }
        }
    }

    @NotNull
    public static final LinearLayout a(@NotNull Context context, @NotNull String imgUrl, @NotNull String text, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mRequestWidth = e.a(12.0f);
        obtain.mRequestHeight = e.a(12.0f);
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(imgUrl, obtain);
        ImageView imageView = new ImageView(context);
        if (drawable2 != null && drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        drawable2.setURLDrawableListener(new a());
        imageView.setImageDrawable(drawable2);
        return j(imageView, context, text, i3);
    }

    @NotNull
    public static final TextView b(@NotNull Context context, @NotNull String text, @NotNull String colorToken) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(colorToken, "colorToken");
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
        textView.setText(GuildUIUtils.f235378a.f(context, text, colorToken));
        textView.setTextSize(14.0f);
        return textView;
    }

    @NotNull
    public static final View c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(qr0.a.a(3), qr0.a.a(3));
        layoutParams.setMargins(qr0.a.a(5), 0, qr0.a.a(5), 0);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.guild_3dp_shape_circle);
        return view;
    }

    @NotNull
    public static final TextView d(@NotNull Context context, @NotNull String text, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (i3 > 0) {
            text = "\u00b7" + text;
        }
        textView.setText(g(text));
        textView.setTextSize(12.0f);
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
        return textView;
    }

    @NotNull
    public static final LinearLayout e(@NotNull Context context, int i3, @NotNull String text, int i16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        ImageView imageView = new ImageView(context);
        LinearLayout j3 = j(imageView, context, text, i16);
        imageView.setImageResource(i3);
        return j3;
    }

    @NotNull
    public static final TextView f(@NotNull Context context, @NotNull String text, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = new TextView(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, e.a(18.0f));
        marginLayoutParams.setMargins(i3, 0, 0, 0);
        textView.setLayoutParams(marginLayoutParams);
        float f16 = context.getResources().getDisplayMetrics().density * 1.0f;
        int color = context.getResources().getColor(R.color.qui_common_text_primary);
        int argb = Color.argb(204, Color.red(color), Color.green(color), Color.blue(color));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke((int) f16, argb);
        gradientDrawable.setCornerRadius(context.getResources().getDisplayMetrics().density * 4.0f);
        textView.setTextColor(argb);
        textView.setText(text);
        textView.setTextSize(10.0f);
        textView.setGravity(17);
        textView.setBackground(gradientDrawable);
        textView.setPadding(e.a(6.0f), 0, e.a(6.0f), 0);
        return textView;
    }

    @NotNull
    public static final SpannableString g(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        SpannableString spannableString = new SpannableString(input);
        for (MatchResult matchResult : Regex.findAll$default(new Regex("\\d+"), input, 0, 2, null)) {
            spannableString.setSpan(new StyleSpan(1), matchResult.getRange().getFirst(), matchResult.getRange().getLast() + 1, 0);
        }
        return spannableString;
    }

    @NotNull
    public static final String h(int i3) {
        if (i3 == 12) {
            return "http://downv6.qq.com/innovate/guild/discover/guild_voice_apng.png";
        }
        if (i3 != 15) {
            switch (i3) {
                case 29:
                    return "http://downv6.qq.com/innovate/guild/discover/guild_music.png";
                case 30:
                case 31:
                    return "http://downv6.qq.com/innovate/guild/discover/guild_game_apng.png";
                default:
                    return "http://downv6.qq.com/innovate/guild/discover/guild_voice_apng.png";
            }
        }
        return "http://downv6.qq.com/innovate/guild/discover/guild_live_apng.png";
    }

    @NotNull
    public static final SpannableStringBuilder i(@NotNull List<? extends IGProGuildLabel> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int size = array.size();
        for (int i3 = 0; i3 < size; i3++) {
            byte[] labelName = array.get(i3).getLabelName();
            Intrinsics.checkNotNullExpressionValue(labelName, "array[i].labelName");
            spannableStringBuilder.append((CharSequence) g(new String(labelName, Charsets.UTF_8)));
            if (i3 < array.size() - 1) {
                spannableStringBuilder.append((CharSequence) "\u00b7");
            }
        }
        return spannableStringBuilder;
    }

    private static final LinearLayout j(View view, Context context, String str, int i3) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, e.a(18.0f));
        layoutParams.setMargins(i3, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setPadding(e.a(6.0f), 0, e.a(6.0f), 0);
        float f16 = context.getResources().getDisplayMetrics().density * 1.0f;
        int parseColor = Color.parseColor("#0099FF");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke((int) f16, parseColor);
        gradientDrawable.setCornerRadius(context.getResources().getDisplayMetrics().density * 4.0f);
        linearLayout.setBackground(gradientDrawable);
        view.setLayoutParams(new LinearLayout.LayoutParams(e.a(12.0f), e.a(12.0f)));
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = e.a(4.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(Color.parseColor("#0099FF"));
        textView.setText(str);
        textView.setTextSize(10.0f);
        linearLayout.addView(view);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static final boolean k(int i3) {
        if (i3 == 28) {
            return true;
        }
        return false;
    }

    public static final boolean l(@NotNull List<? extends IGProGuildLabel> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int labelType = array.get(0).getLabelType();
        if (array.size() >= 2) {
            int labelType2 = array.get(1).getLabelType();
            if (!n(labelType) || !n(labelType2)) {
                return false;
            }
            return true;
        }
        return n(labelType);
    }

    public static final boolean m(int i3) {
        if (i3 != 12 && i3 != 15) {
            switch (i3) {
                case 29:
                case 30:
                case 31:
                case 32:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static final boolean n(int i3) {
        if (i3 != 2 && i3 != 17 && i3 != 19 && i3 != 27) {
            return false;
        }
        return true;
    }
}
