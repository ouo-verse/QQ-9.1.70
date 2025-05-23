package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0002_`B\u0007\u00a2\u0006\u0004\b]\u0010^J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J0\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J(\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015j\u0002`\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J(\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015j\u0002`\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J(\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015j\u0002`\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J.\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J(\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015j\u0002`\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J(\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015j\u0002`\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010 \u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J&\u0010$\u001a\u00020\"*\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\"H\u0002J\u001c\u0010&\u001a\u00020\f*\u00020%2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J4\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\"H\u0002J\u0014\u0010*\u001a\u00020\"*\u00020\u00162\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0014\u0010,\u001a\u00020\u0004*\u00020\t2\u0006\u0010+\u001a\u00020\"H\u0002J&\u0010.\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0004H\u0002J>\u00108\u001a\u0004\u0018\u00010\u00022\b\u00104\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0016J(\u00109\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J(\u0010;\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0016H\u0016J\b\u0010=\u001a\u00020\fH\u0016R$\u0010B\u001a\u00020\"2\u0006\u0010>\u001a\u00020\"8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b=\u0010?\u001a\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010SR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010PR*\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010WR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020Z0Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "", "text", "", "start", "endExclusive", "", "E", "Landroid/text/Spanned;", "count", "after", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lkotlin/Pair;", "", "H", "G", "", "stage", UserInfo.SEX_FEMALE, "Lkotlin/Function1;", "Landroid/text/Editable;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/AfterTextChangeFunc;", BdhLogUtil.LogTag.Tag_Req, "O", "P", "editable", "y", "V", "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "D", "end", "", "shouldHighlightSingleChar", "Y", "Landroid/text/Spannable;", ExifInterface.LATITUDE_SOUTH, "shouldHighlightSingleCharAtLast", "W", "index", "a0", "needToast", BdhLogUtil.LogTag.Tag_Conn, DownloaderConstant.KEY_RANGE, "b0", "searchOrStop", "U", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "textLength", "B", "source", "dest", "dstart", "dend", "filter", "beforeTextChanged", "before", "onTextChanged", "afterTextChanged", "f", "<set-?>", "Z", "d", "()Z", "isActivatable", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin$a;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin$a;", "getCallback", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin$a;", "T", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin$a;)V", "callback", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool;", "i", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool;", "hashtagTool", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "focusStart", "focusEnd", "Ljava/lang/Object;", "span1", "span2", "case", "Lkotlin/jvm/functions/Function1;", "pendingTextChangeAction", "", "Landroid/text/InputFilter;", "[Landroid/text/InputFilter;", "inputFilters", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class HashtagCharTextWatcherPlugin extends SpecialCharDetectTextWatcher.b {

    /* renamed from: C, reason: from kotlin metadata */
    private int focusEnd;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Object span1;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Object span2;

    /* renamed from: F, reason: from kotlin metadata */
    private int case;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Editable, Unit> pendingTextChangeAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isActivatable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int focusStart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TopicHashtagTool hashtagTool = new TopicHashtagTool("HashtagCharTextWatcherPlugin", 12);

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final InputFilter[] inputFilters = {new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.b
        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            CharSequence I;
            I = HashtagCharTextWatcherPlugin.I(charSequence, i3, i16, spanned, i17, i18);
            return I;
        }
    }, new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.c
        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            CharSequence J;
            J = HashtagCharTextWatcherPlugin.J(HashtagCharTextWatcherPlugin.this, charSequence, i3, i16, spanned, i17, i18);
            return J;
        }
    }, new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.d
        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            CharSequence K;
            K = HashtagCharTextWatcherPlugin.K(charSequence, i3, i16, spanned, i17, i18);
            return K;
        }
    }, new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.e
        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            CharSequence L;
            L = HashtagCharTextWatcherPlugin.L(HashtagCharTextWatcherPlugin.this, charSequence, i3, i16, spanned, i17, i18);
            return L;
        }
    }, new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.f
        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            CharSequence M;
            M = HashtagCharTextWatcherPlugin.M(HashtagCharTextWatcherPlugin.this, charSequence, i3, i16, spanned, i17, i18);
            return M;
        }
    }};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin$a;", "", "", "keyword", "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void a();

        void b(@NotNull String keyword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B(int textLength) {
        boolean z16;
        if (this.case == 0) {
            return false;
        }
        int i3 = this.focusEnd;
        int i16 = this.focusStart;
        if (i16 >= 0 && i16 <= i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || i3 > textLength) {
            return false;
        }
        return true;
    }

    private final int C(Spanned spanned, boolean z16) {
        int i3 = 0;
        yn1.b[] bVarArr = (yn1.b[]) spanned.getSpans(0, spanned.length(), yn1.b.class);
        if (bVarArr != null) {
            i3 = bVarArr.length;
        }
        int i16 = 50 - i3;
        if (z16 && i16 <= 0) {
            n.h("HashtagCharTextWatcherPlugin", 1500L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$checkRemainTopicCountCanInsert$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    n.A(0, "\u6700\u591a\u652f\u6301\u6dfb\u52a050\u4e2a\u8bdd\u9898");
                }
            });
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Editable editable, int start, int count) {
        Object obj = this.span1;
        if (obj != null && editable.getSpanEnd(obj) == start) {
            editable.removeSpan(obj);
            TopicHashtagTool.Companion.c(TopicHashtagTool.INSTANCE, editable, -1, false, 4, null);
            b0(editable, X(this, editable, this.focusStart, start + count, false, 4, null));
        } else {
            TopicHashtagTool.Companion.c(TopicHashtagTool.INSTANCE, editable, -1, false, 4, null);
            if (count > 0) {
                b0(editable, X(this, editable, start, start + count, false, 4, null));
            } else {
                U(a0(editable, start - 1));
            }
        }
    }

    private final float E(CharSequence text, int start, int endExclusive) {
        int coerceAtLeast;
        int coerceAtMost;
        if (endExclusive <= start) {
            return 0.0f;
        }
        if (endExclusive - start < text.length()) {
            TopicHashtagTool.Companion companion = TopicHashtagTool.INSTANCE;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(start, 0);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(endExclusive, text.length());
            return companion.e(text, coerceAtLeast, coerceAtMost);
        }
        return TopicHashtagTool.INSTANCE.e(text, 0, text.length());
    }

    private final void F(String stage, int start, int count, int after) {
        QLog.d("HashtagCharTextWatcherPlugin", 1, stage + "| start=" + start + ", count=" + count + ", after=" + after + ", focusStart=" + this.focusStart + ", focusEnd=" + this.focusEnd + ", case=" + this.case + ", span1=" + this.span1 + ", span2=" + this.span2);
    }

    private final void G(Spanned text, int start) {
        yn1.b bVar;
        yn1.b[] bVarArr;
        Object firstOrNull;
        if (start > 0 && start <= text.length() && (bVarArr = (yn1.b[]) text.getSpans(start - 1, start, yn1.b.class)) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
            bVar = (yn1.b) firstOrNull;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            this.focusStart = text.getSpanStart(bVar);
            this.span1 = bVar;
        } else {
            this.focusStart = start;
            this.span1 = null;
        }
    }

    private final Pair<Object, Object> H(Spanned text, int start, int count) {
        yn1.b bVar;
        yn1.b bVar2;
        Object firstOrNull;
        Object firstOrNull2;
        Object firstOrNull3;
        yn1.b bVar3 = null;
        if (count > 0) {
            yn1.b[] bVarArr = (yn1.b[]) text.getSpans(start, start + 1, yn1.b.class);
            if (bVarArr != null) {
                firstOrNull3 = ArraysKt___ArraysKt.firstOrNull(bVarArr);
                bVar2 = (yn1.b) firstOrNull3;
            } else {
                bVar2 = null;
            }
            int i3 = start + count;
            yn1.b[] bVarArr2 = (yn1.b[]) text.getSpans(i3 - 1, i3, yn1.b.class);
            if (bVarArr2 != null) {
                firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(bVarArr2);
                bVar3 = (yn1.b) firstOrNull2;
            }
        } else {
            yn1.b[] bVarArr3 = (yn1.b[]) text.getSpans(start, start + 1, yn1.b.class);
            if (bVarArr3 != null) {
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr3);
                bVar = (yn1.b) firstOrNull;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                boolean z16 = true;
                int spanStart = text.getSpanStart(bVar) + 1;
                if (start >= text.getSpanEnd(bVar) || spanStart > start) {
                    z16 = false;
                }
                if (z16) {
                    bVar3 = bVar;
                }
            }
            bVar2 = bVar3;
        }
        return new Pair<>(bVar2, bVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence I(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        boolean z16;
        if (spanned != null) {
            if (charSequence != null && charSequence.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && i16 - i3 != 0) {
                return charSequence;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence J(HashtagCharTextWatcherPlugin this$0, CharSequence source, int i3, int i16, Spanned dest, int i17, int i18) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 - i3 == 1) {
            TopicHashtagTool.Companion companion = TopicHashtagTool.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(source, "source");
            if (companion.j(source, i3)) {
                Intrinsics.checkNotNullExpressionValue(dest, "dest");
                if (this$0.C(dest, true) <= 0) {
                    str = "";
                } else {
                    str = null;
                }
                return str;
            }
            return source;
        }
        return source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence K(CharSequence source, int i3, int i16, Spanned spanned, int i17, int i18) {
        TopicHashtagTool.Companion companion = TopicHashtagTool.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(source, "source");
        if (!companion.i(source, i3, i16)) {
            return null;
        }
        return source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence L(HashtagCharTextWatcherPlugin this$0, CharSequence charSequence, int i3, int i16, Spanned dest, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 > 0) {
            TopicHashtagTool.Companion companion = TopicHashtagTool.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(dest, "dest");
            if (companion.j(dest, i17 - 1)) {
                if (this$0.C(dest, false) < 0) {
                    n.h("HashtagCharTextWatcherPlugin", 1500L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$inputFilters$4$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            n.A(0, "\u6700\u591a\u652f\u6301\u6dfb\u52a050\u4e2a\u8bdd\u9898");
                        }
                    });
                    return "";
                }
                return null;
            }
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r1 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CharSequence M(HashtagCharTextWatcherPlugin this$0, CharSequence charSequence, int i3, int i16, Spanned dest, int i17, int i18) {
        yn1.b bVar;
        yn1.b[] bVarArr;
        Object firstOrNull;
        boolean z16;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        yn1.b[] bVarArr2 = (yn1.b[]) dest.getSpans(i17, i17 + 1, yn1.b.class);
        if (bVarArr2 != null) {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(bVarArr2);
            bVar = (yn1.b) firstOrNull2;
        }
        if (i17 > 0 && (bVarArr = (yn1.b[]) dest.getSpans(i17 - 1, i17, yn1.b.class)) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
            bVar = (yn1.b) firstOrNull;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        int spanStart = dest.getSpanStart(bVar);
        int spanEnd = dest.getSpanEnd(bVar);
        if (i17 <= spanStart) {
            return null;
        }
        if (i17 == i18 && i17 >= spanEnd) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(dest, "dest");
        if (this$0.E(dest, spanStart, spanEnd) > 12.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return "";
    }

    private final Function1<Editable, Unit> N(final int start, final int count) {
        return new Function1<Editable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$overlapBothTextChangeResponseAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Editable editable) {
                boolean B;
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(editable, "editable");
                B = HashtagCharTextWatcherPlugin.this.B(editable.length());
                if (!B) {
                    HashtagCharTextWatcherPlugin.this.A();
                    return;
                }
                TopicHashtagTool.Companion.c(TopicHashtagTool.INSTANCE, editable, -1, false, 4, null);
                obj = HashtagCharTextWatcherPlugin.this.span1;
                if (obj != null) {
                    editable.removeSpan(obj);
                }
                obj2 = HashtagCharTextWatcherPlugin.this.span2;
                if (obj2 != null) {
                    editable.removeSpan(obj2);
                }
                HashtagCharTextWatcherPlugin.this.y(editable, start, count);
            }
        };
    }

    private final Function1<Editable, Unit> O(final int start, final int count) {
        return new Function1<Editable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$overlapEndTextChangeResponseAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Editable editable) {
                boolean B;
                Object obj;
                Intrinsics.checkNotNullParameter(editable, "editable");
                B = HashtagCharTextWatcherPlugin.this.B(editable.length());
                if (!B) {
                    HashtagCharTextWatcherPlugin.this.A();
                    return;
                }
                obj = HashtagCharTextWatcherPlugin.this.span2;
                if (obj != null) {
                    editable.removeSpan(obj);
                }
                HashtagCharTextWatcherPlugin.this.D(editable, start, count);
            }
        };
    }

    private final Function1<Editable, Unit> P(final int start, final int count) {
        return new Function1<Editable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$overlapIncludeTextChangeResponseAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Editable editable) {
                boolean B;
                Object obj;
                int i3;
                int i16;
                int i17;
                boolean a06;
                int i18;
                Intrinsics.checkNotNullParameter(editable, "editable");
                B = HashtagCharTextWatcherPlugin.this.B(editable.length());
                if (!B) {
                    HashtagCharTextWatcherPlugin.this.A();
                    return;
                }
                TopicHashtagTool.Companion.c(TopicHashtagTool.INSTANCE, editable, -1, false, 4, null);
                obj = HashtagCharTextWatcherPlugin.this.span1;
                if (obj != null) {
                    editable.removeSpan(obj);
                }
                HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin = HashtagCharTextWatcherPlugin.this;
                i3 = hashtagCharTextWatcherPlugin.focusStart;
                i16 = HashtagCharTextWatcherPlugin.this.focusEnd;
                if (HashtagCharTextWatcherPlugin.Z(hashtagCharTextWatcherPlugin, editable, i3, i16, false, 4, null)) {
                    HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin2 = HashtagCharTextWatcherPlugin.this;
                    i18 = hashtagCharTextWatcherPlugin2.focusStart;
                    hashtagCharTextWatcherPlugin2.b0(editable, TuplesKt.to(Integer.valueOf(i18), Integer.valueOf(start + count)));
                    return;
                }
                HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin3 = HashtagCharTextWatcherPlugin.this;
                i17 = hashtagCharTextWatcherPlugin3.focusStart;
                hashtagCharTextWatcherPlugin3.Y(editable, i17, start, false);
                HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin4 = HashtagCharTextWatcherPlugin.this;
                int i19 = start;
                Pair X = HashtagCharTextWatcherPlugin.X(hashtagCharTextWatcherPlugin4, editable, i19, i19 + count, false, 4, null);
                if (X != null) {
                    HashtagCharTextWatcherPlugin.this.b0(editable, X);
                } else {
                    if (count != 0) {
                        HashtagCharTextWatcherPlugin.this.A();
                        return;
                    }
                    HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin5 = HashtagCharTextWatcherPlugin.this;
                    a06 = hashtagCharTextWatcherPlugin5.a0(editable, start - 1);
                    hashtagCharTextWatcherPlugin5.U(a06);
                }
            }
        };
    }

    private final Function1<Editable, Unit> Q(final int start, final int count) {
        return new Function1<Editable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$overlapNothingTextChangeResponseAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Editable editable) {
                boolean B;
                Intrinsics.checkNotNullParameter(editable, "editable");
                B = HashtagCharTextWatcherPlugin.this.B(editable.length());
                if (!B) {
                    HashtagCharTextWatcherPlugin.this.A();
                } else {
                    HashtagCharTextWatcherPlugin.this.D(editable, start, count);
                }
            }
        };
    }

    private final Function1<Editable, Unit> R(final int start, final int count) {
        return new Function1<Editable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin$overlapStartTextChangeResponseAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Editable editable) {
                boolean B;
                Object obj;
                Intrinsics.checkNotNullParameter(editable, "editable");
                B = HashtagCharTextWatcherPlugin.this.B(editable.length());
                if (!B) {
                    HashtagCharTextWatcherPlugin.this.A();
                    return;
                }
                TopicHashtagTool.Companion.c(TopicHashtagTool.INSTANCE, editable, -1, false, 4, null);
                obj = HashtagCharTextWatcherPlugin.this.span1;
                if (obj != null) {
                    editable.removeSpan(obj);
                }
                HashtagCharTextWatcherPlugin.this.y(editable, start, count);
            }
        };
    }

    private final void S(Spannable spannable, int i3, int i16) {
        Object[] spans = spannable.getSpans(i3, i16, Object.class);
        if (spans != null) {
            for (Object obj : spans) {
                if ((obj instanceof UnderlineSpan) || spannable.getSpanFlags(obj) == 256) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(boolean searchOrStop) {
        if (searchOrStop) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.b("");
                return;
            }
            return;
        }
        A();
    }

    private final Pair<Integer, Integer> V(Editable editable, int start, int count) {
        yn1.b[] bVarArr;
        Object firstOrNull;
        Pair<Integer, Integer> pair;
        if (start <= 0 || (bVarArr = (yn1.b[]) editable.getSpans(start - 1, start, yn1.b.class)) == null) {
            return null;
        }
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
        yn1.b bVar = (yn1.b) firstOrNull;
        if (bVar == null) {
            return null;
        }
        int spanStart = editable.getSpanStart(bVar);
        if (count > 0) {
            int i3 = count + start;
            if (this.hashtagTool.j(editable, spanStart, i3, false) == 0) {
                editable.removeSpan(bVar);
                editable.setSpan(bVar, spanStart, i3, 33);
                pair = TuplesKt.to(Integer.valueOf(spanStart), Integer.valueOf(i3));
                return pair;
            }
        }
        pair = TuplesKt.to(Integer.valueOf(spanStart), Integer.valueOf(start));
        return pair;
    }

    private final Pair<Integer, Integer> W(Editable editable, int i3, int i16, boolean z16) {
        int coerceAtMost;
        Object lastOrNull;
        List<Pair<Integer, Integer>> i17 = this.hashtagTool.i(editable, i3, i16, z16);
        if (i17.isEmpty()) {
            i17 = null;
        }
        if (i17 == null) {
            return null;
        }
        boolean z17 = false;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(C(editable, false), i17.size());
        for (int i18 = 0; i18 < coerceAtMost; i18++) {
            Pair<Integer, Integer> pair = i17.get(i18);
            if (pair.getSecond().intValue() - pair.getFirst().intValue() > 1) {
                editable.setSpan(new yn1.b(0L, 0, 2, null), pair.getFirst().intValue(), pair.getSecond().intValue(), 33);
            } else {
                TopicHashtagTool.INSTANCE.b(editable, pair.getFirst().intValue(), true);
            }
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) i17);
        Pair<Integer, Integer> pair2 = (Pair) lastOrNull;
        if (pair2 == null) {
            return null;
        }
        if (coerceAtMost == i17.size()) {
            z17 = true;
        }
        if (!z17) {
            return null;
        }
        return pair2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Pair X(HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin, Editable editable, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            z16 = true;
        }
        return hashtagCharTextWatcherPlugin.W(editable, i3, i16, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y(Editable editable, int i3, int i16, boolean z16) {
        boolean z17;
        if (this.hashtagTool.j(editable, i3, i16, z16) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && C(editable, false) > 0) {
            if (i16 - i3 > 1) {
                S(editable, i3, i16);
                editable.setSpan(new yn1.b(0L, 0, 2, null), i3, i16, 33);
            } else {
                TopicHashtagTool.INSTANCE.b(editable, i3, true);
            }
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean Z(HashtagCharTextWatcherPlugin hashtagCharTextWatcherPlugin, Editable editable, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            z16 = true;
        }
        return hashtagCharTextWatcherPlugin.Y(editable, i3, i16, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(Editable editable, int i3) {
        if (!this.hashtagTool.k(editable, i3) || C(editable, false) <= 0) {
            return false;
        }
        TopicHashtagTool.INSTANCE.b(editable, i3, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(CharSequence text, Pair<Integer, Integer> range) {
        CharSequence charSequence;
        if (range != null && Selection.getSelectionStart(text) == range.getSecond().intValue() && range.getSecond().intValue() > range.getFirst().intValue()) {
            a aVar = this.callback;
            if (aVar != null) {
                String obj = text.subSequence(range.getFirst().intValue(), range.getSecond().intValue()).toString();
                int length = obj.length();
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (!TopicHashtagTool.INSTANCE.h(obj.charAt(i3))) {
                            charSequence = obj.subSequence(i3, obj.length());
                            break;
                        }
                        i3++;
                    } else {
                        charSequence = "";
                        break;
                    }
                }
                aVar.b(charSequence.toString());
                return;
            }
            return;
        }
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Editable editable, int start, int count) {
        int i3 = start + count;
        if (Z(this, editable, this.focusStart, i3, false, 4, null)) {
            b0(editable, TuplesKt.to(Integer.valueOf(this.focusStart), Integer.valueOf(i3)));
            return;
        }
        Y(editable, this.focusStart, start, false);
        Pair<Integer, Integer> X = X(this, editable, start, i3, false, 4, null);
        if (X != null) {
            b0(editable, X);
        } else if (count == 0 && a0(editable, start - 1)) {
            U(true);
        } else {
            b0(editable, V(editable, start, count));
        }
    }

    private final void z(Spanned text, int start, int count, int after) {
        boolean z16;
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.case = 5;
            this.focusStart = 0;
            this.focusEnd = after;
            this.span1 = null;
            this.span2 = null;
            F("beforeTextChanged.isEmpty", start, count, after);
            return;
        }
        Pair<Object, Object> H = H(text, start, count);
        Object component1 = H.component1();
        Object component2 = H.component2();
        if (Intrinsics.areEqual(component2, component1) && component2 == null) {
            this.case = 5;
            G(text, start);
            this.focusEnd = start + after;
        } else if (Intrinsics.areEqual(component2, component1) && component1 != null) {
            this.case = 2;
            this.focusStart = text.getSpanStart(component1);
            this.focusEnd = (text.getSpanEnd(component1) + after) - count;
            this.span1 = component1;
        } else if (!Intrinsics.areEqual(component2, component1) && component1 == null) {
            this.case = 1;
            G(text, start);
            this.focusEnd = start + after;
            this.span2 = component2;
        } else if (!Intrinsics.areEqual(component2, component1) && component2 == null) {
            this.case = 4;
            this.focusStart = text.getSpanStart(component1);
            this.focusEnd = start + after;
            this.span1 = component1;
        } else {
            this.case = 3;
            this.focusStart = text.getSpanStart(component1);
            this.focusEnd = start + after;
            this.span1 = component1;
            this.span2 = component2;
        }
        F("beforeTextChangedDetect", start, count, after);
    }

    public final void T(@Nullable a aVar) {
        this.callback = aVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (B(text.length())) {
            Function1<? super Editable, Unit> function1 = this.pendingTextChangeAction;
            if (function1 != null) {
                function1.invoke(text);
            }
            this.pendingTextChangeAction = null;
        }
        this.span1 = null;
        this.span2 = null;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence text, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (!(text instanceof Spanned)) {
            return;
        }
        z((Spanned) text, start, count, after);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b
    /* renamed from: d, reason: from getter */
    public boolean getIsActivatable() {
        return this.isActivatable;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b
    public void f() {
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.InputFilter
    @Nullable
    public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
        for (InputFilter inputFilter : this.inputFilters) {
            CharSequence filter = inputFilter.filter(source, start, end, dest, dstart, dend);
            if (filter != source) {
                return filter;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence text, int start, int before, int count) {
        Function1<Editable, Unit> O;
        Intrinsics.checkNotNullParameter(text, "text");
        if (!B(text.length())) {
            A();
            return;
        }
        int i3 = this.case;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            O = null;
                        } else {
                            O = Q(start, count);
                        }
                    } else {
                        O = R(start, count);
                    }
                } else {
                    O = N(start, count);
                }
            } else {
                O = P(start, count);
            }
        } else {
            O = O(start, count);
        }
        this.pendingTextChangeAction = O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
    }
}
