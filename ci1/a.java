package ci1;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0006\u0010\u0005\u001a\u00020\u0002\u001a\"\u0010\t\u001a\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b0\u0006\u001a\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0000H\u0003\u001a\u0018\u0010\u0016\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001b"}, d2 = {"", "source", "", "mainSource", "e", "c", "", "kotlin.jvm.PlatformType", "", "d", "b", "f", "Landroid/widget/TextView;", "tv", "itemWidth", "a", "textView", "width", "Landroid/text/StaticLayout;", "g", NodeProps.LINE_HEIGHT, "", "i", "Lwq0/l;", "", "lineHeightSp", h.F, "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final int a(@NotNull TextView tv5, int i3) {
        Intrinsics.checkNotNullParameter(tv5, "tv");
        return g(tv5, (i3 - tv5.getCompoundPaddingLeft()) - tv5.getCompoundPaddingRight()).getLineCount();
    }

    public static final int b(int i3) {
        if (i3 != 2) {
            if (i3 == 3) {
                return 3;
            }
            if (i3 == 4) {
                return 4;
            }
            if (i3 != 5) {
                return 17;
            }
            return 24;
        }
        return 12;
    }

    @NotNull
    public static final String c() {
        String str;
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            str = pageInfo.pageId;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final Map<String, Object> d() {
        Map<String, Object> map;
        Map<String, Object> emptyMap;
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            map = pageInfo.pageParams;
        } else {
            map = null;
        }
        if (map == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return map;
    }

    public static final int e(int i3, @NotNull String mainSource) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return 8;
                    }
                    return 22;
                }
                return 17;
            }
            if (Intrinsics.areEqual(mainSource, "profile_card")) {
                return 18;
            }
            return 16;
        }
        return 10;
    }

    public static final int f(int i3) {
        if (i3 == 1 || i3 == 2) {
            return 10;
        }
        if (i3 != 3 && i3 != 4) {
            return 10;
        }
        return 12;
    }

    @RequiresApi(api = 23)
    private static final StaticLayout g(TextView textView, int i3) {
        int maxLines;
        int justificationMode;
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i3).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (textView.getMaxLines() == -1) {
            maxLines = Integer.MAX_VALUE;
        } else {
            maxLines = textView.getMaxLines();
        }
        StaticLayout.Builder maxLines2 = hyphenationFrequency.setMaxLines(maxLines);
        Intrinsics.checkNotNullExpressionValue(maxLines2, "obtain(\n        textView\u2026E else textView.maxLines)");
        if (Build.VERSION.SDK_INT >= 26) {
            justificationMode = textView.getJustificationMode();
            maxLines2.setJustificationMode(justificationMode);
        }
        if (textView.getEllipsize() != null && textView.getKeyListener() == null) {
            maxLines2.setEllipsize(textView.getEllipsize()).setEllipsizedWidth(i3);
        }
        StaticLayout build = maxLines2.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final void h(@NotNull l lVar, float f16) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        lVar.c(ViewUtils.spToPx(f16) - lVar.j().getFontMetricsInt(null));
    }

    public static final void i(@Nullable TextView textView, int i3) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setLineHeight(i3);
            } else {
                textView.setLineSpacing(i3 - textView.getPaint().getFontMetricsInt(null), 1.0f);
            }
        }
    }
}
