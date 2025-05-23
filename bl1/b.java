package bl1;

import android.text.TextPaint;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.guild.data.y;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J6\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eJ.\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Lbl1/b;", "", "", "count", "", "zeroHints", "Lcom/tencent/mobileqq/guild/data/y;", "exceedConfig", "g", "Landroid/widget/TextView;", "textView", "text", "ellipsisStartLength", "extraWidth", "Landroidx/core/util/Consumer;", "resultConsumer", "", "b", NodeProps.MAX_WIDTH, "fixedText", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f28597a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TextView textView, int i3, String text, Consumer resultConsumer, int i16) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(resultConsumer, "$resultConsumer");
        int measuredWidth = ((textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) - i3;
        TextPaint paint = textView.getPaint();
        if (paint == null) {
            QLog.e("LayoutTools", 1, "ellipsizeText, but no paint");
            return;
        }
        float f16 = measuredWidth;
        if (paint.measureText(text) < f16) {
            resultConsumer.accept(text);
            return;
        }
        float measureText = f16 - paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        int length = text.length();
        while (i16 < length) {
            int i17 = i16 + 1;
            if (paint.measureText(text, 0, i17) > measureText) {
                String substring = text.substring(0, i16);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                resultConsumer.accept(substring + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                return;
            }
            i16 = i17;
        }
    }

    public static /* synthetic */ String h(b bVar, int i3, String str, y yVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        if ((i16 & 4) != 0) {
            yVar = y.b.f216487d;
        }
        return bVar.g(i3, str, yVar);
    }

    public final void b(@NotNull final TextView textView, @NotNull final String text, final int ellipsisStartLength, final int extraWidth, @NotNull final Consumer<String> resultConsumer) {
        boolean z16;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(resultConsumer, "resultConsumer");
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (text.length() <= ellipsisStartLength) {
            resultConsumer.accept(text);
        } else {
            textView.post(new Runnable() { // from class: bl1.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(textView, extraWidth, text, resultConsumer, ellipsisStartLength);
                }
            });
        }
    }

    @NotNull
    public final String d(@NotNull TextView textView, @NotNull String text, int ellipsisStartLength, int maxWidth, @NotNull String fixedText) {
        boolean z16;
        float coerceAtLeast;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fixedText, "fixedText");
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && text.length() >= ellipsisStartLength) {
            TextPaint paint = textView.getPaint();
            if (paint == null) {
                QLog.e("LayoutTools", 1, "ellipsizeTextSync, but there is no paint");
                return text;
            }
            float measureText = maxWidth - paint.measureText(fixedText);
            String str = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(measureText - paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX), 0.0f);
            if (coerceAtLeast <= 0.0f) {
                return "";
            }
            int length = text.length();
            int i3 = -1;
            float f16 = -1.0f;
            int i16 = 1;
            while (i16 <= length) {
                i3 = (length + i16) >>> 1;
                f16 = paint.measureText(text, 0, i3);
                if (f16 < coerceAtLeast) {
                    i16 = i3 + 1;
                } else {
                    if (f16 <= coerceAtLeast) {
                        break;
                    }
                    length = i3 - 1;
                }
            }
            if (f16 > coerceAtLeast) {
                i3 = i16 - 1;
            }
            if (i3 <= 0) {
                return "";
            }
            String substring = text.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (i3 >= text.length()) {
                str = "";
            }
            return substring + str;
        }
        return text;
    }

    @JvmOverloads
    @NotNull
    public final String e(int i3) {
        return h(this, i3, null, null, 6, null);
    }

    @JvmOverloads
    @NotNull
    public final String f(int i3, @NotNull String zeroHints) {
        Intrinsics.checkNotNullParameter(zeroHints, "zeroHints");
        return h(this, i3, zeroHints, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final String g(int count, @NotNull String zeroHints, @NotNull y exceedConfig) {
        Intrinsics.checkNotNullParameter(zeroHints, "zeroHints");
        Intrinsics.checkNotNullParameter(exceedConfig, "exceedConfig");
        if (count >= 1) {
            if (count < 10000) {
                return String.valueOf(count);
            }
            if (count < exceedConfig.getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.NUM java.lang.String()) {
                double d16 = count / 10000;
                double d17 = 10;
                return (Math.rint(d16 * d17) / d17) + "\u4e07";
            }
            return exceedConfig.getText();
        }
        return zeroHints;
    }
}
