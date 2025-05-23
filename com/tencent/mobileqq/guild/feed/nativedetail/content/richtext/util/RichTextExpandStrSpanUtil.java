package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.g;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003I<?B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJB\u0010\u0010\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J8\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0012*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bH\u0002J0\u0010#\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002J \u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0003H\u0002J,\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bH\u0002J(\u0010*\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002JH\u00102\u001a\u0004\u0018\u00010\u001c*\u00020)2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u0013H\u0002J\f\u00103\u001a\u00020\n*\u00020\u0003H\u0002J\n\u00105\u001a\u00020\u0005*\u000204J\u000e\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000206J@\u00109\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001e\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0012*\u00020\u00032\u0006\u0010:\u001a\u00020\u0005R\u0014\u0010>\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u001d\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0006\n\u0004\b#\u0010BR\u001c\u0010F\u001a\n D*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010E\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil;", "", "Lwq0/l;", "Landroid/text/SpannableStringBuilder;", "text", "", "width", "maxLines", "Landroid/text/SpannableString;", "expandStringBuilder", "", "basicKey", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "parseConfig", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "txtView", "Lkotlin/Pair;", "", ReportConstant.COSTREPORT_PREFIX, "defaultWidth", "k", "original", "endPos", "expandSpan", "e", "currentEndPos", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil$b;", "truncateInfo", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil$c;", "measurement", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil$a;", "actionHistory", "contentSpan", "d", "currentPos", DomainData.DOMAIN_NAME, "o", "f", "", "Landroid/text/StaticLayout;", "l", "Landroid/text/TextPaint;", "textPaint", "", "expandStrWidth", "realWidth", "truncateEndPosition", "calcByOffset", "g", "i", "Landroid/view/View;", h.F, "Landroid/content/Context;", "context", "j", "p", "endPosition", "r", "b", "I", "KEY_ASYNC_PROCESS_TEXT_JOB", "c", "KEY_CONTENT", "Lkotlin/time/Duration;", "J", "JANK_GET_OFFSET_THRESHOLD", "kotlin.jvm.PlatformType", "Ljava/lang/Boolean;", "truncateAndAppendExpandTextDoubleCheck", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RichTextExpandStrSpanUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RichTextExpandStrSpanUtil f221634a = new RichTextExpandStrSpanUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int KEY_ASYNC_PROCESS_TEXT_JOB = 189816574;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int KEY_CONTENT = -223815079;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final long JANK_GET_OFFSET_THRESHOLD;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Boolean truncateAndAppendExpandTextDoubleCheck;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil$a;", "", "", "isIncrease", "", "b", "currentAction", "a", "Ljava/lang/Boolean;", "lastAction", "previousAction", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean lastAction;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean previousAction;

        public final boolean a(boolean currentAction) {
            if (this.lastAction != null && !Intrinsics.areEqual(Boolean.valueOf(currentAction), this.lastAction) && Intrinsics.areEqual(Boolean.valueOf(currentAction), this.previousAction)) {
                return true;
            }
            return false;
        }

        public final void b(boolean isIncrease) {
            this.previousAction = this.lastAction;
            this.lastAction = Boolean.valueOf(isIncrease);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "getLastLineText", "()Ljava/lang/CharSequence;", "lastLineText", "", "b", UserInfo.SEX_FEMALE, "()F", "lastLineBlankWidth", "c", "I", "()I", "newEndPosition", "<init>", "(Ljava/lang/CharSequence;FI)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class TruncateLayoutInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence lastLineText;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float lastLineBlankWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int newEndPosition;

        public TruncateLayoutInfo() {
            this(null, 0.0f, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final float getLastLineBlankWidth() {
            return this.lastLineBlankWidth;
        }

        /* renamed from: b, reason: from getter */
        public final int getNewEndPosition() {
            return this.newEndPosition;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TruncateLayoutInfo)) {
                return false;
            }
            TruncateLayoutInfo truncateLayoutInfo = (TruncateLayoutInfo) other;
            if (Intrinsics.areEqual(this.lastLineText, truncateLayoutInfo.lastLineText) && Float.compare(this.lastLineBlankWidth, truncateLayoutInfo.lastLineBlankWidth) == 0 && this.newEndPosition == truncateLayoutInfo.newEndPosition) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.lastLineText.hashCode() * 31) + Float.floatToIntBits(this.lastLineBlankWidth)) * 31) + this.newEndPosition;
        }

        @NotNull
        public String toString() {
            CharSequence charSequence = this.lastLineText;
            return "TruncateLayoutInfo(lastLineText=" + ((Object) charSequence) + ", lastLineBlankWidth=" + this.lastLineBlankWidth + ", newEndPosition=" + this.newEndPosition + ")";
        }

        public TruncateLayoutInfo(@NotNull CharSequence lastLineText, float f16, int i3) {
            Intrinsics.checkNotNullParameter(lastLineText, "lastLineText");
            this.lastLineText = lastLineText;
            this.lastLineBlankWidth = f16;
            this.newEndPosition = i3;
        }

        public /* synthetic */ TruncateLayoutInfo(String str, float f16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0.0f : f16, (i16 & 4) != 0 ? 0 : i3);
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        JANK_GET_OFFSET_THRESHOLD = DurationKt.toDuration(3, DurationUnit.MILLISECONDS);
        truncateAndAppendExpandTextDoubleCheck = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("truncateAndAppendExpandText_doubleCheck", Boolean.TRUE);
    }

    RichTextExpandStrSpanUtil() {
    }

    private final int d(int currentEndPos, TruncateLayoutInfo truncateInfo, TruncateMeasurement measurement, a actionHistory, SpannableStringBuilder contentSpan) {
        if (truncateInfo.getLastLineBlankWidth() < measurement.getNegativeThreshold()) {
            return n(currentEndPos, actionHistory);
        }
        if (truncateInfo.getLastLineBlankWidth() >= measurement.a().getValue().floatValue()) {
            return o(currentEndPos, actionHistory, contentSpan);
        }
        return currentEndPos;
    }

    private final Pair<SpannableStringBuilder, Integer> e(SpannableStringBuilder original, int endPos, SpannableString expandSpan) {
        Pair<SpannableStringBuilder, Integer> r16 = r(original, endPos);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) r16.getFirst());
        spannableStringBuilder.append((CharSequence) expandSpan);
        return TuplesKt.to(spannableStringBuilder, r16.getSecond());
    }

    private final Pair<Boolean, SpannableStringBuilder> f(SpannableStringBuilder original, int endPos, SpannableString expandSpan) {
        boolean z16;
        if (original.length() > endPos) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return TuplesKt.to(Boolean.FALSE, original);
        }
        Boolean bool = Boolean.TRUE;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) f221634a.r(original, endPos).getFirst());
        spannableStringBuilder.append((CharSequence) expandSpan);
        return TuplesKt.to(bool, spannableStringBuilder);
    }

    private final TruncateLayoutInfo g(StaticLayout staticLayout, int i3, SpannableStringBuilder spannableStringBuilder, TextPaint textPaint, float f16, int i16, int i17, boolean z16) {
        CharSequence trimEnd;
        int i18 = i3 - 1;
        int lineStart = staticLayout.getLineStart(i18);
        int min = Math.min(i17, spannableStringBuilder.length());
        if (min < lineStart) {
            Logger.f235387a.d().w("RichTextExpandStrSpanUtil", 1, "Break because truncateEndPosition(" + i17 + ") < lastLineStart(" + lineStart + "), text: " + f221634a.i(spannableStringBuilder));
            return null;
        }
        CharSequence subSequence = spannableStringBuilder.subSequence(lineStart, min);
        Intrinsics.checkNotNullExpressionValue(subSequence, "contentSpan.subSequence(lastLineStart, end)");
        trimEnd = StringsKt__StringsKt.trimEnd(subSequence);
        float desiredWidth = Layout.getDesiredWidth(trimEnd, textPaint);
        int length = lineStart + trimEnd.length();
        float f17 = i16 - f16;
        if (z16 && desiredWidth > f17) {
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            int offsetForHorizontal = staticLayout.getOffsetForHorizontal(i18, f17);
            long m1966elapsedNowUwyO8pc = TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto);
            if (Duration.m1825compareToLRDsOJo(m1966elapsedNowUwyO8pc, JANK_GET_OFFSET_THRESHOLD) > 0) {
                Logger.f235387a.d().w("RichTextExpandStrSpanUtil", 1, "calcTruncateLayoutInfo: get offset cost too much, time=" + Duration.m1875toStringimpl(m1966elapsedNowUwyO8pc) + ", text: " + f221634a.i(spannableStringBuilder));
            }
            length = offsetForHorizontal;
        }
        return new TruncateLayoutInfo(trimEnd, f17 - desiredWidth, length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(SpannableStringBuilder spannableStringBuilder) {
        CharSequence subSequence = spannableStringBuilder.subSequence(0, Math.min(spannableStringBuilder.length(), 2));
        return ((Object) subSequence) + "...(length: " + spannableStringBuilder.length() + ")";
    }

    private final int k(l txtView, int defaultWidth) {
        boolean z16;
        Layout layout = txtView.getLayout();
        if (layout != null) {
            Integer valueOf = Integer.valueOf(layout.getWidth());
            if (valueOf.intValue() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                return valueOf.intValue();
            }
            return defaultWidth;
        }
        return defaultWidth;
    }

    private final StaticLayout l(CharSequence text, l txtView, int width, int maxLines) {
        StaticLayout build = StaticLayout.Builder.obtain(text, 0, text.length(), txtView.j(), width).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(txtView.h(), txtView.e()).setIncludePad(true).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(width).setMaxLines(maxLines).setBreakStrategy(1).setHyphenationFrequency(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(text, 0, text.len\u2026\n                .build()");
        return build;
    }

    private final void m(l lVar, SpannableStringBuilder spannableStringBuilder, int i3, int i16, SpannableString spannableString, String str, IParseRichTextConfig<GProStRichTextContent> iParseRichTextConfig) {
        Job launch$default;
        View view = lVar.getView();
        int i17 = KEY_ASYNC_PROCESS_TEXT_JOB;
        Object tag = view.getTag(i17);
        if (!(tag instanceof Job)) {
            tag = null;
        }
        Job job = (Job) tag;
        if (job != null && job.isActive()) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            Logger.f235387a.d().c("RichTextExpandStrSpanUtil", 1, "cancel current job: " + job + " for " + f221634a.i(spannableStringBuilder));
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ae.a().c()), null, null, new RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1(spannableStringBuilder, iParseRichTextConfig, lVar, i3, i16, spannableString, str, null), 3, null);
        lVar.getView().setTag(i17, launch$default);
    }

    private final int n(int currentPos, a actionHistory) {
        if (actionHistory.a(false)) {
            Logger.f235387a.d().w("RichTextExpandStrSpanUtil", 1, "Break adjustment loop: alternating dec/inc detected");
            return currentPos;
        }
        actionHistory.b(false);
        return currentPos - 1;
    }

    private final int o(int currentPos, a actionHistory, SpannableStringBuilder contentSpan) {
        Character orNull;
        if (actionHistory.a(true)) {
            Logger.f235387a.d().w("RichTextExpandStrSpanUtil", 1, "Break adjustment loop: alternating inc/dec detected");
            return currentPos;
        }
        if (currentPos < contentSpan.length()) {
            orNull = StringsKt___StringsKt.getOrNull(contentSpan, currentPos);
            if (orNull == null || orNull.charValue() != '\n') {
                actionHistory.b(true);
                return currentPos + 1;
            }
            return currentPos;
        }
        return currentPos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Boolean, SpannableStringBuilder> s(SpannableStringBuilder spannableStringBuilder, final l lVar, int i3, int i16, SpannableString spannableString) {
        Lazy lazy;
        int i17;
        int i18;
        boolean z16 = true;
        if (i3 <= 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "width is invalid: " + i3 + ", return. Text: " + f221634a.i(spannableStringBuilder);
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("RichTextExpandStrSpanUtil", 1, (String) it.next(), null);
            }
            return new Pair<>(Boolean.FALSE, spannableStringBuilder);
        }
        int k3 = k(lVar, i3);
        StaticLayout l3 = l(spannableStringBuilder, lVar, k3, i16);
        if (l3.getLineCount() < i16) {
            return TuplesKt.to(Boolean.FALSE, spannableStringBuilder);
        }
        TextPaint j3 = lVar.j();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil$truncateAndAppendExpandText$measurement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(l.this.j().measureText("\u8baf"));
            }
        });
        TruncateMeasurement truncateMeasurement = new TruncateMeasurement(j3, lazy, k3, 10, lVar.j().measureText(spannableString.toString()), 0.0f, 32, null);
        int lineEnd = l3.getLineEnd(i16 - 1);
        TruncateLayoutInfo truncateLayoutInfo = new TruncateLayoutInfo(null, 0.0f, 0, 7, null);
        a aVar = new a();
        int i19 = lineEnd;
        int i26 = 0;
        while (i26 < truncateMeasurement.getMaxCheckCount()) {
            Pair<SpannableStringBuilder, Integer> e16 = e(spannableStringBuilder, i19, spannableString);
            SpannableStringBuilder component1 = e16.component1();
            int intValue = e16.component2().intValue();
            StaticLayout l16 = l(component1, lVar, truncateMeasurement.getRealWidth(), i16);
            TextPaint j16 = lVar.j();
            float expandSpanWidth = truncateMeasurement.getExpandSpanWidth();
            int realWidth = truncateMeasurement.getRealWidth();
            boolean z17 = i26 == 0 ? z16 : false;
            int i27 = i26;
            TruncateLayoutInfo truncateLayoutInfo2 = truncateLayoutInfo;
            i18 = i19;
            truncateLayoutInfo = g(l16, i16, spannableStringBuilder, j16, expandSpanWidth, realWidth, intValue, z17);
            if (truncateLayoutInfo != null) {
                if (Intrinsics.areEqual(truncateLayoutInfo, truncateLayoutInfo2)) {
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger2.d().d("RichTextExpandStrSpanUtil", 1, "Break because equal, truncateInfo=" + truncateLayoutInfo2);
                    }
                } else {
                    i19 = d(truncateLayoutInfo.getNewEndPosition(), truncateLayoutInfo, truncateMeasurement, aVar, spannableStringBuilder);
                    if (i19 == truncateLayoutInfo.getNewEndPosition()) {
                        i17 = i27;
                        break;
                    }
                    i26 = i27 + 1;
                    z16 = true;
                }
            }
            i17 = i27;
        }
        i17 = i26;
        i18 = i19;
        i19 = i18;
        if (i17 > 3) {
            Logger.f235387a.d().w("RichTextExpandStrSpanUtil", 1, "Try " + i17 + " times for truncation, text: " + f221634a.i(spannableStringBuilder));
        }
        return f(spannableStringBuilder, i19, spannableString);
    }

    public final int h(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (int) g.b(view).c();
    }

    @NotNull
    public final SpannableString j(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableString spannableString = new SpannableString("... \u5168\u90e8");
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.qui_common_text_link)), 3, spannableString.length(), 33);
        return spannableString;
    }

    public final void p(@NotNull l lVar, @NotNull SpannableStringBuilder text, int i3, int i16, @NotNull SpannableString expandStringBuilder, @NotNull String basicKey, @NotNull IParseRichTextConfig<GProStRichTextContent> parseConfig) {
        SpannableStringBuilder spannableStringBuilder;
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(expandStringBuilder, "expandStringBuilder");
        Intrinsics.checkNotNullParameter(basicKey, "basicKey");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        String str = basicKey + "_" + text.length();
        View view = lVar.getView();
        int i17 = KEY_CONTENT;
        if (Intrinsics.areEqual(str, view.getTag(i17))) {
            Logger.f235387a.d().c("RichTextExpandStrSpanUtil", 1, "setTextAndProcessAsync: same key, return, key: " + str + ", text: " + f221634a.i(text));
            return;
        }
        lVar.getView().setTag(i17, str);
        if (parseConfig.i()) {
            spannableStringBuilder = s(text, lVar, i3, i16, expandStringBuilder).getSecond();
        } else {
            spannableStringBuilder = text;
        }
        lVar.f(spannableStringBuilder, str);
        lVar.getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean q16;
                q16 = RichTextExpandStrSpanUtil.q(view2, motionEvent);
                return q16;
            }
        });
        m(lVar, text, i3, i16, expandStringBuilder, str, parseConfig);
    }

    @NotNull
    public final Pair<SpannableStringBuilder, Integer> r(@NotNull SpannableStringBuilder spannableStringBuilder, int i3) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        if (i3 >= spannableStringBuilder.length()) {
            return TuplesKt.to(new SpannableStringBuilder(spannableStringBuilder), Integer.valueOf(spannableStringBuilder.length()));
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(spannableStringBuilder.toString());
        if (!characterInstance.isBoundary(i3)) {
            i3 = characterInstance.preceding(i3);
        }
        return TuplesKt.to(new SpannableStringBuilder(spannableStringBuilder.subSequence(0, i3)), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u0011\u0010\u001dR\u0017\u0010 \u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001a\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/RichTextExpandStrSpanUtil$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/text/TextPaint;", "a", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint", "Lkotlin/Lazy;", "", "b", "Lkotlin/Lazy;", "()Lkotlin/Lazy;", "chineseCharWidth", "c", "I", "e", "()I", "realWidth", "d", "maxCheckCount", UserInfo.SEX_FEMALE, "()F", "expandSpanWidth", "f", "negativeThreshold", "<init>", "(Landroid/text/TextPaint;Lkotlin/Lazy;IIFF)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class TruncateMeasurement {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final TextPaint textPaint;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Lazy<Float> chineseCharWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int realWidth;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int maxCheckCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final float expandSpanWidth;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final float negativeThreshold;

        public TruncateMeasurement(@NotNull TextPaint textPaint, @NotNull Lazy<Float> chineseCharWidth, int i3, int i16, float f16, float f17) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            Intrinsics.checkNotNullParameter(chineseCharWidth, "chineseCharWidth");
            this.textPaint = textPaint;
            this.chineseCharWidth = chineseCharWidth;
            this.realWidth = i3;
            this.maxCheckCount = i16;
            this.expandSpanWidth = f16;
            this.negativeThreshold = f17;
        }

        @NotNull
        public final Lazy<Float> a() {
            return this.chineseCharWidth;
        }

        /* renamed from: b, reason: from getter */
        public final float getExpandSpanWidth() {
            return this.expandSpanWidth;
        }

        /* renamed from: c, reason: from getter */
        public final int getMaxCheckCount() {
            return this.maxCheckCount;
        }

        /* renamed from: d, reason: from getter */
        public final float getNegativeThreshold() {
            return this.negativeThreshold;
        }

        /* renamed from: e, reason: from getter */
        public final int getRealWidth() {
            return this.realWidth;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TruncateMeasurement)) {
                return false;
            }
            TruncateMeasurement truncateMeasurement = (TruncateMeasurement) other;
            if (Intrinsics.areEqual(this.textPaint, truncateMeasurement.textPaint) && Intrinsics.areEqual(this.chineseCharWidth, truncateMeasurement.chineseCharWidth) && this.realWidth == truncateMeasurement.realWidth && this.maxCheckCount == truncateMeasurement.maxCheckCount && Float.compare(this.expandSpanWidth, truncateMeasurement.expandSpanWidth) == 0 && Float.compare(this.negativeThreshold, truncateMeasurement.negativeThreshold) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.textPaint.hashCode() * 31) + this.chineseCharWidth.hashCode()) * 31) + this.realWidth) * 31) + this.maxCheckCount) * 31) + Float.floatToIntBits(this.expandSpanWidth)) * 31) + Float.floatToIntBits(this.negativeThreshold);
        }

        @NotNull
        public String toString() {
            return "TruncateMeasurement(textPaint=" + this.textPaint + ", chineseCharWidth=" + this.chineseCharWidth + ", realWidth=" + this.realWidth + ", maxCheckCount=" + this.maxCheckCount + ", expandSpanWidth=" + this.expandSpanWidth + ", negativeThreshold=" + this.negativeThreshold + ")";
        }

        public /* synthetic */ TruncateMeasurement(TextPaint textPaint, Lazy lazy, int i3, int i16, float f16, float f17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(textPaint, lazy, i3, i16, f16, (i17 & 32) != 0 ? ViewUtils.dpToPx(20.0f) : f17);
        }
    }
}
