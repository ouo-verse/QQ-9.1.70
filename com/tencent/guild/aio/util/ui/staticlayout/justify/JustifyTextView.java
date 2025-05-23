package com.tencent.guild.aio.util.ui.staticlayout.justify;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.widget.textView.view.AioTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.m;
import xq0.LineInfo;
import xq0.SpanInfo;
import xq0.a;
import xq0.b;
import xq0.e;
import xq0.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 q2\u00020\u0001:\u0001rB'\b\u0007\u0012\u0006\u0010k\u001a\u00020j\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l\u0012\b\b\u0002\u0010n\u001a\u00020\u0006\u00a2\u0006\u0004\bo\u0010pJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001c\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JL\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J4\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010-\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0018\u00100\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.H\u0002J(\u00104\u001a\u00020%2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00103\u001a\u00020%H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00101\u001a\u00020\u0004H\u0002J(\u00107\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u00109\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0002J\u0018\u0010=\u001a\u00020%2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020%H\u0002J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020%2\u0006\u0010;\u001a\u00020:H\u0002J!\u0010A\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\bA\u0010BJ\u001a\u0010E\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020CH\u0016J \u0010I\u001a\u0012\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010G2\u0006\u0010F\u001a\u00020\u0006H\u0016J\u0018\u0010L\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0014J\u0012\u0010M\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0014J\u000e\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0014J\u000e\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020PJ\u000e\u0010U\u001a\u00020\b2\u0006\u0010T\u001a\u00020SJ&\u0010V\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016R\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u00105R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010h\u00a8\u0006s"}, d2 = {"Lcom/tencent/guild/aio/util/ui/staticlayout/justify/JustifyTextView;", "Lcom/tencent/aio/widget/textView/view/AioTextView;", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "text", "", "layoutWidth", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "O", "T", "Ljava/lang/Class;", "classType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lxq0/c;", "lineInfo", BdhLogUtil.LogTag.Tag_Conn, "currentIndex", "nextIndex", "", "currentXPos", "Lxq0/d;", "", "replacementSpanSet", "", "xPosCache", "K", "start", "lineEnd", "", "drawStartIndexCache", "J", "index", HippyTKDListViewAdapter.X, "value", "y", "", "B", "Landroid/graphics/Canvas;", PM.CANVAS, "D", "baseLineY", "top", "bottom", "E", "Landroid/text/TextPaint;", "paint", "P", "lineSequence", "lineWidth", "isLastLine", "N", UserInfo.SEX_FEMALE, "lineNum", "I", "firstNotSpaceCharIndex", "G", "", "c", "notSpaceAtStart", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "charSequence", "H", "M", "L", "(II)Ljava/lang/Integer;", "", "valueKey", IECSearchBar.METHOD_SET_TEXT, "maxLayoutWidth", "Lkotlin/Pair;", "Lcom/tencent/aio/widget/textView/param/b;", "v", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "maxSpace", "setAdjustMaxSpace", "Lwq0/m;", "callback", "setOnMeasureDoneCallback", "Lxq0/a;", "cache", "setDrawInfoCache", DomainData.DOMAIN_NAME, "Lxq0/f;", "g0", "Lxq0/f;", "mSpansManager", "h0", "Landroid/text/TextPaint;", "mWorkPaint", "i0", "mAdjustMaxSpace", "Lxq0/b;", "j0", "Lxq0/b;", "mDrawInfo", "k0", "Lwq0/m;", "mMeasureCallback", "l0", "Lxq0/a;", "mDrawInfoCache", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "m0", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class JustifyTextView extends AioTextView {

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mSpansManager;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint mWorkPaint;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private float mAdjustMaxSpace;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mDrawInfo;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m mMeasureCallback;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mDrawInfoCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public JustifyTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean A(char c16, boolean notSpaceAtStart) {
        if (!M(c16) && (c16 != ' ' || !notSpaceAtStart)) {
            return false;
        }
        return true;
    }

    private final boolean B(Layout layout) {
        if (layout.getLineCount() <= 1) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i3 = 0; i3 < lineCount; i3++) {
            if (layout.getParagraphDirection(i3) == -1) {
                return false;
            }
        }
        return true;
    }

    private final void C(LineInfo lineInfo, CharSequence text) {
        int lineStart = lineInfo.getLineStart();
        x(lineStart);
        int i3 = lineStart;
        float f16 = 0.0f;
        while (i3 < lineInfo.getLineEnd()) {
            y(i3, f16);
            SpanInfo<? extends Object> b16 = this.mSpansManager.b(ReplacementSpan.class, i3, i3 + 1);
            int J = J(i3, lineInfo.getLineEnd(), b16, null);
            if (b16 != null && (b16.a() instanceof ReplacementSpan)) {
                x(i3);
                x(J);
            } else {
                boolean z16 = true;
                if (J - i3 == 1) {
                    char charAt = text.charAt(i3);
                    if (i3 < lineInfo.getFirstNotSpaceChar() + lineInfo.getLineStart()) {
                        z16 = false;
                    }
                    if (A(charAt, z16)) {
                        x(J);
                    }
                } else {
                    x(J);
                }
            }
            f16 = K(i3, J, f16, text, lineInfo, b16, null);
            i3 = J;
        }
    }

    private final void D(Canvas canvas, Layout layout) {
        LineInfo I;
        CharSequence o16 = o();
        if (o16 != null) {
            int lineCount = layout.getLineCount();
            for (int i3 = 0; i3 < lineCount; i3++) {
                if (this.mDrawInfo.c().size() > i3) {
                    I = this.mDrawInfo.c().get(i3);
                } else {
                    I = I(layout, getMeasuredWidth(), i3, o16);
                }
                LineInfo lineInfo = I;
                Intrinsics.checkNotNullExpressionValue(lineInfo, "if (mDrawInfo.lineInfos.\u2026, text)\n                }");
                float lineBaseline = layout.getLineBaseline(i3);
                if (!lineInfo.getDrawLine()) {
                    E(canvas, o16, lineInfo, lineBaseline, layout.getLineTop(i3), layout.getLineBottom(i3));
                } else if (lineInfo.getLineEnd() > lineInfo.getLineStart()) {
                    canvas.drawText(o16, lineInfo.getLineStart(), lineInfo.getLineEnd(), 0.0f, lineBaseline, q());
                }
            }
        }
    }

    private final void E(Canvas canvas, CharSequence text, LineInfo lineInfo, float baseLineY, int top, int bottom) {
        float f16 = 0.0f;
        int lineStart = lineInfo.getLineStart();
        while (lineStart < lineInfo.getLineEnd()) {
            this.mWorkPaint.set(q());
            SpanInfo<? extends Object> b16 = this.mSpansManager.b(ReplacementSpan.class, lineStart, lineStart + 1);
            int J = J(lineStart, lineInfo.getLineEnd(), b16, this.mDrawInfo.getDrawStartIndexes());
            if (b16 != null && (b16.a() instanceof ReplacementSpan)) {
                ((ReplacementSpan) b16.a()).draw(canvas, text, b16.getSpanStart(), b16.getSpanEnd(), f16, top, (int) baseLineY, bottom, this.mWorkPaint);
            } else {
                P(lineStart, this.mWorkPaint);
                canvas.drawText(text, lineStart, J, f16, baseLineY, this.mWorkPaint);
            }
            f16 = K(lineStart, J, f16, text, lineInfo, b16, this.mDrawInfo.getXPosArray());
            lineStart = J;
        }
    }

    private final boolean F(CharSequence lineSequence) {
        boolean endsWith$default;
        endsWith$default = StringsKt__StringsKt.endsWith$default(lineSequence, (CharSequence) "\n", false, 2, (Object) null);
        return endsWith$default;
    }

    private final float G(CharSequence lineSequence, float lineWidth, int layoutWidth, int firstNotSpaceCharIndex) {
        boolean z16;
        int length = lineSequence.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = lineSequence.charAt(i16);
            if (i16 >= firstNotSpaceCharIndex) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (A(charAt, z16)) {
                i3++;
            }
        }
        if (i3 > 0) {
            return (layoutWidth - lineWidth) / i3;
        }
        return 0.0f;
    }

    private final int H(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i3) != ' ') {
                return i3;
            }
        }
        return charSequence.length();
    }

    private final LineInfo I(Layout layout, int layoutWidth, int lineNum, CharSequence text) {
        boolean z16;
        float f16;
        float f17;
        boolean z17;
        int i3;
        if (lineNum >= layout.getLineCount() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int lineStart = layout.getLineStart(lineNum);
        int lineEnd = layout.getLineEnd(lineNum);
        CharSequence subSequence = text.subSequence(lineStart, lineEnd);
        float lineWidth = layout.getLineWidth(lineNum);
        boolean d16 = this.mSpansManager.d(lineStart, lineEnd);
        int H = H(subSequence);
        boolean N = N(subSequence, lineWidth, layoutWidth, z16);
        if (!d16 && !N) {
            f17 = 0.0f;
            z17 = true;
        } else {
            if (N) {
                f16 = G(subSequence, lineWidth, layoutWidth, H);
            } else {
                f16 = 0.0f;
            }
            float f18 = this.mAdjustMaxSpace;
            if (f16 > f18) {
                f17 = f18;
            } else if (f16 < 0.0f) {
                f17 = 0.0f;
            } else {
                f17 = f16;
            }
            z17 = false;
        }
        if (F(subSequence) && lineEnd - 1 < lineStart) {
            i3 = lineStart;
        } else {
            i3 = lineEnd;
        }
        return new LineInfo(lineStart, i3, lineWidth, z17, f17, H);
    }

    private final int J(int start, int lineEnd, SpanInfo<? extends Object> replacementSpanSet, boolean[] drawStartIndexCache) {
        SpanInfo<? extends Object> b16;
        int i3 = start + 1;
        if (drawStartIndexCache != null && i3 < drawStartIndexCache.length) {
            int length = drawStartIndexCache.length;
            for (int i16 = i3; i16 < length; i16++) {
                if (drawStartIndexCache[i16]) {
                    return i16;
                }
                if (i16 >= lineEnd - 1) {
                    return lineEnd;
                }
            }
        }
        if (replacementSpanSet != null && (replacementSpanSet.a() instanceof ReplacementSpan)) {
            return start + (replacementSpanSet.getSpanEnd() - replacementSpanSet.getSpanStart());
        }
        if (this.mDrawInfo.getMeasuredTextWidths() != null) {
            float[] measuredTextWidths = this.mDrawInfo.getMeasuredTextWidths();
            Intrinsics.checkNotNull(measuredTextWidths);
            if (i3 < measuredTextWidths.length) {
                float[] measuredTextWidths2 = this.mDrawInfo.getMeasuredTextWidths();
                Intrinsics.checkNotNull(measuredTextWidths2);
                int length2 = measuredTextWidths2.length;
                int i17 = i3;
                while (i17 < length2) {
                    float[] measuredTextWidths3 = this.mDrawInfo.getMeasuredTextWidths();
                    Intrinsics.checkNotNull(measuredTextWidths3);
                    if (measuredTextWidths3[i17] > 0.0f) {
                        if (i17 > i3 && (b16 = this.mSpansManager.b(ReplacementSpan.class, i3, i17)) != null && (b16.a() instanceof ReplacementSpan)) {
                            return b16.getSpanStart();
                        }
                        return i17;
                    }
                    i17++;
                }
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float K(int currentIndex, int nextIndex, float currentXPos, CharSequence text, LineInfo lineInfo, SpanInfo<? extends Object> replacementSpanSet, float[] xPosCache) {
        float measureText;
        char charAt;
        boolean z16;
        if (nextIndex <= text.length() && currentIndex <= text.length()) {
            if (xPosCache != null && xPosCache.length > nextIndex) {
                return xPosCache[nextIndex];
            }
            if (replacementSpanSet != null && (replacementSpanSet.a() instanceof ReplacementSpan)) {
                return currentXPos + ((ReplacementSpan) replacementSpanSet.a()).getSize(q(), text, replacementSpanSet.getSpanStart(), replacementSpanSet.getSpanEnd(), q().getFontMetricsInt());
            }
            if (this.mDrawInfo.getMeasuredTextWidths() != null) {
                float[] measuredTextWidths = this.mDrawInfo.getMeasuredTextWidths();
                Intrinsics.checkNotNull(measuredTextWidths);
                if (measuredTextWidths.length > currentIndex) {
                    float[] measuredTextWidths2 = this.mDrawInfo.getMeasuredTextWidths();
                    Intrinsics.checkNotNull(measuredTextWidths2);
                    measureText = measuredTextWidths2[currentIndex];
                    charAt = text.charAt(currentIndex);
                    if (currentIndex < lineInfo.getFirstNotSpaceChar() + lineInfo.getLineStart()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (A(charAt, z16)) {
                        measureText += lineInfo.getExtraSpace();
                    }
                    return currentXPos + measureText;
                }
            }
            measureText = q().measureText(String.valueOf(text.charAt(currentIndex)));
            charAt = text.charAt(currentIndex);
            if (currentIndex < lineInfo.getFirstNotSpaceChar() + lineInfo.getLineStart()) {
            }
            if (A(charAt, z16)) {
            }
            return currentXPos + measureText;
        }
        return 0.0f;
    }

    private final Integer L(int x16, int y16) {
        com.tencent.aio.widget.textView.param.b g16;
        boolean z16;
        float f16;
        try {
            Layout i3 = i();
            if (i3 != null && (g16 = g()) != null) {
                int lineForVertical = i3.getLineForVertical(y16);
                if (this.mDrawInfo.g(g16) && this.mDrawInfo.c().size() > lineForVertical && this.mDrawInfo.getXPosArray() != null) {
                    int lineStart = this.mDrawInfo.c().get(lineForVertical).getLineStart();
                    int lineEnd = this.mDrawInfo.c().get(lineForVertical).getLineEnd();
                    float[] xPosArray = this.mDrawInfo.getXPosArray();
                    Intrinsics.checkNotNull(xPosArray);
                    if (lineStart >= 0 && lineEnd <= xPosArray.length) {
                        while (lineStart < lineEnd) {
                            int i16 = lineStart + 1;
                            int i17 = 0;
                            if (i16 == lineEnd) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            float f17 = xPosArray[lineStart];
                            if (i16 < xPosArray.length && !z16) {
                                f16 = xPosArray[i16];
                            } else {
                                float[] measuredTextWidths = this.mDrawInfo.getMeasuredTextWidths();
                                if (measuredTextWidths != null) {
                                    i17 = (int) measuredTextWidths[lineStart];
                                }
                                f16 = i17 + f17;
                            }
                            float f18 = x16;
                            if (f18 >= f17 && f18 < f16) {
                                return Integer.valueOf(lineStart);
                            }
                            lineStart = i16;
                        }
                    }
                    return -1;
                }
                return null;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("JustifyTextView", 1, "[getTextIndexByPos] x: " + x16 + ", y: " + y16 + ", exception: " + e16.getMessage());
            return null;
        }
    }

    private final boolean M(char c16) {
        if ('\u4e00' > c16 || c16 >= '\u9fbc') {
            return false;
        }
        return true;
    }

    private final boolean N(CharSequence lineSequence, float lineWidth, int layoutWidth, boolean isLastLine) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (lineSequence.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !isLastLine) {
            boolean z19 = !F(lineSequence);
            float f16 = layoutWidth - lineWidth;
            if (f16 >= q().getTextSize() / 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (f16 > lineWidth / 3) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z19 && z17 && !z18) {
                return true;
            }
        }
        return false;
    }

    private final void O() {
        Q(AbsoluteSizeSpan.class);
        Q(RelativeSizeSpan.class);
        Q(ForegroundColorSpan.class);
        Q(ClickableSpan.class);
    }

    private final void P(int index, TextPaint paint) {
        int i3 = index + 1;
        SpanInfo<? extends Object> b16 = this.mSpansManager.b(AbsoluteSizeSpan.class, index, i3);
        if (b16 != null && (b16.a() instanceof AbsoluteSizeSpan)) {
            ((AbsoluteSizeSpan) b16.a()).updateDrawState(paint);
        }
        SpanInfo<? extends Object> b17 = this.mSpansManager.b(RelativeSizeSpan.class, index, i3);
        if (b17 != null && (b17.a() instanceof RelativeSizeSpan)) {
            ((RelativeSizeSpan) b17.a()).updateDrawState(paint);
        }
        SpanInfo<? extends Object> b18 = this.mSpansManager.b(ForegroundColorSpan.class, index, i3);
        if (b18 != null && (b18.a() instanceof ForegroundColorSpan)) {
            ((ForegroundColorSpan) b18.a()).updateDrawState(paint);
        }
        SpanInfo<? extends Object> b19 = this.mSpansManager.b(ClickableSpan.class, index, i3);
        if (b19 != null && (b19.a() instanceof ClickableSpan)) {
            ((ClickableSpan) b19.a()).updateDrawState(paint);
        }
    }

    private final <T> void Q(Class<T> classType) {
        e<? extends Object> c16 = this.mSpansManager.c(classType);
        if (c16 != null) {
            if (c16.getSpanEnds() != null) {
                int[] spanEnds = c16.getSpanEnds();
                Intrinsics.checkNotNull(spanEnds);
                for (int i3 : spanEnds) {
                    boolean[] drawStartIndexes = this.mDrawInfo.getDrawStartIndexes();
                    if (drawStartIndexes != null && i3 < drawStartIndexes.length) {
                        drawStartIndexes[i3] = true;
                    }
                }
            }
            if (c16.getSpanStarts() != null) {
                int[] spanStarts = c16.getSpanStarts();
                Intrinsics.checkNotNull(spanStarts);
                for (int i16 : spanStarts) {
                    boolean[] drawStartIndexes2 = this.mDrawInfo.getDrawStartIndexes();
                    if (drawStartIndexes2 != null && i16 < drawStartIndexes2.length) {
                        drawStartIndexes2[i16] = true;
                    }
                }
            }
        }
    }

    private final void x(int index) {
        boolean[] drawStartIndexes = this.mDrawInfo.getDrawStartIndexes();
        if (drawStartIndexes != null && drawStartIndexes.length > index) {
            drawStartIndexes[index] = true;
        }
    }

    private final void y(int index, float value) {
        float[] xPosArray = this.mDrawInfo.getXPosArray();
        if (xPosArray != null && xPosArray.length > index) {
            xPosArray[index] = value;
        }
    }

    private final void z(Layout layout, CharSequence text, int layoutWidth) {
        b bVar;
        if (!B(layout)) {
            return;
        }
        com.tencent.aio.widget.textView.param.b g16 = g();
        Integer num = null;
        if (g16 != null) {
            a aVar = this.mDrawInfoCache;
            if (aVar != null) {
                bVar = aVar.a(g16);
            } else {
                bVar = null;
            }
            if (bVar != null && bVar.g(g16)) {
                this.mDrawInfo = bVar;
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mDrawInfo.f(text.length());
            q().getTextWidths(text, 0, text.length(), this.mDrawInfo.getMeasuredTextWidths());
            int lineCount = layout.getLineCount();
            for (int i3 = 0; i3 < lineCount; i3++) {
                LineInfo I = I(layout, layoutWidth, i3, text);
                this.mDrawInfo.c().add(I);
                C(I, text);
            }
            O();
            com.tencent.aio.widget.textView.param.b g17 = g();
            if (g17 != null) {
                this.mDrawInfo.i(g17);
                a aVar2 = this.mDrawInfoCache;
                if (aVar2 != null) {
                    aVar2.b(g17, this.mDrawInfo);
                }
            }
        } catch (Exception e16) {
            QLog.e("JustifyTextView", 1, "[calculateDrawXPos] exception: textSize: " + text.length() + ", exception: " + e16.getMessage());
            this.mDrawInfo.h();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            CharSequence o16 = o();
            if (o16 != null) {
                num = Integer.valueOf(o16.length());
            }
            QLog.d("JustifyTextView", 1, "[calculateDrawXPos] textSize: " + num + ", cost: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    @Override // com.tencent.aio.widget.textView.view.AioTextView
    @Nullable
    public Object n(int x16, int y16, @NotNull Class<?> classType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(classType, "classType");
        Integer L = L(x16, y16);
        if (L != null) {
            int intValue = L.intValue();
            if (intValue == -1) {
                return null;
            }
            CharSequence o16 = o();
            if (o16 != null && (o16 instanceof Spannable)) {
                Object[] spans = ((Spannable) o16).getSpans(intValue, intValue, classType);
                boolean z17 = true;
                if (spans != null) {
                    if (spans.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z17 = false;
                    }
                }
                if (z17) {
                    return null;
                }
                return spans[0];
            }
        }
        return super.n(x16, y16, classType);
    }

    @Override // com.tencent.aio.widget.textView.view.AioTextView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        Integer num;
        Layout i3 = i();
        if (i3 != null && canvas != null) {
            canvas.save();
            canvas.translate(getPaddingLeft(), r());
            long currentTimeMillis = System.currentTimeMillis();
            if (B(i3)) {
                D(canvas, i3);
            } else {
                i3.draw(canvas);
            }
            if (QLog.isDevelopLevel()) {
                int hashCode = hashCode();
                int hashCode2 = i3.hashCode();
                CharSequence o16 = o();
                if (o16 != null) {
                    num = Integer.valueOf(o16.length());
                } else {
                    num = null;
                }
                QLog.d("JustifyTextView", 1, "[onDraw] this: " + hashCode + ", layout: " + hashCode2 + ", textSize: " + num + ", drawTime " + (System.currentTimeMillis() - currentTimeMillis));
            }
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aio.widget.textView.view.AioTextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Layout i3;
        boolean z16;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        m mVar = this.mMeasureCallback;
        if (mVar != null) {
            mVar.a(widthMeasureSpec, heightMeasureSpec);
        }
        CharSequence o16 = o();
        if (o16 != null) {
            boolean z17 = true;
            if (g() != null) {
                b bVar = this.mDrawInfo;
                com.tencent.aio.widget.textView.param.b g16 = g();
                Intrinsics.checkNotNull(g16);
                if (bVar.g(g16)) {
                    float[] measuredTextWidths = this.mDrawInfo.getMeasuredTextWidths();
                    if (measuredTextWidths != null && measuredTextWidths.length == o16.length()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = false;
                    }
                }
            }
            if (z17 && (i3 = i()) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("JustifyTextView", 2, "[onMeasure] textSize: " + o16.length() + ", measuredWidth: " + getMeasuredWidth() + ", widthSpec: " + View.MeasureSpec.getSize(widthMeasureSpec) + ", lineCount: " + i3.getLineCount());
                }
                z(i3, o16, getMeasuredWidth());
            }
        }
    }

    public final void setAdjustMaxSpace(float maxSpace) {
        this.mAdjustMaxSpace = maxSpace;
    }

    public final void setDrawInfoCache(@NotNull a cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.mDrawInfoCache = cache;
    }

    public final void setOnMeasureDoneCallback(@NotNull m callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mMeasureCallback = callback;
    }

    @Override // com.tencent.aio.widget.textView.view.AioTextView
    public void setText(@Nullable CharSequence value, @NotNull String valueKey) {
        Intrinsics.checkNotNullParameter(valueKey, "valueKey");
        boolean z16 = !Intrinsics.areEqual(o(), value);
        super.setText(value, valueKey);
        if (z16 && (value instanceof Spanned)) {
            this.mDrawInfo.h();
            Spanned spanned = (Spanned) value;
            this.mSpansManager.e(spanned, 0, spanned.length());
        }
    }

    @Override // com.tencent.aio.widget.textView.view.AioTextView
    @Nullable
    public Pair<com.tencent.aio.widget.textView.param.b, Layout> v(int maxLayoutWidth) {
        Layout second;
        CharSequence o16;
        Pair<com.tencent.aio.widget.textView.param.b, Layout> v3 = super.v(maxLayoutWidth);
        if (v3 != null && (second = v3.getSecond()) != null && (o16 = o()) != null) {
            z(second, o16, maxLayoutWidth);
        }
        return v3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public JustifyTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ JustifyTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public JustifyTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpansManager = new f();
        this.mWorkPaint = new TextPaint();
        this.mAdjustMaxSpace = 15.0f;
        this.mDrawInfo = new b();
    }
}
