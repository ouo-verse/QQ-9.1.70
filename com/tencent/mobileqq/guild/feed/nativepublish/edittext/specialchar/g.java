package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import android.text.Spanned;
import androidx.core.util.Supplier;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yn1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J0\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000fH\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/g;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "Landroid/text/Spanned;", "text", "", "start", "count", "Lkotlin/Pair;", "Lyn1/a;", "j", "i", "", "after", "", "beforeTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "<set-?>", "f", "Z", "d", "()Z", "isActivatable", "Landroidx/core/util/Supplier;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/HashtagCharTextWatcherPlugin;", tl.h.F, "Landroidx/core/util/Supplier;", "getTopicPluginProvider", "()Landroidx/core/util/Supplier;", "k", "(Landroidx/core/util/Supplier;)V", "topicPluginProvider", "isUpdating", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "detectionCase", BdhLogUtil.LogTag.Tag_Conn, "lookStart", "D", "lookEnd", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends SpecialCharDetectTextWatcher.b {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern F = Pattern.compile("[\uff03#]\u817e\u8baf\u9891\u9053[\uff1a:]([0-9a-zA-Z]{0,14})");

    /* renamed from: C, reason: from kotlin metadata */
    private int lookStart;

    /* renamed from: D, reason: from kotlin metadata */
    private int lookEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isActivatable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Supplier<HashtagCharTextWatcherPlugin> topicPluginProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isUpdating;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int detectionCase;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/g$a;", "", "", "content", "Lkotlin/ranges/IntRange;", DownloaderConstant.KEY_RANGE, "Ljava/util/ArrayList;", "Lyn1/a$b;", "b", "Landroid/text/Editable;", "editable", "", "a", "", "CASE_INSIDE_SPANS", "I", "CASE_NO_OVERLAP", "CASE_OVERLAP_CROSS_SPANS", "CASE_OVERLAP_END", "CASE_OVERLAP_START", "PATTERN_KEYWORD", "Ljava/lang/String;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PREFIX_PATTERN", "Ljava/util/regex/Pattern;", "REMOVE_TOPIC", "Z", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull Editable editable, @NotNull IntRange range) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            Intrinsics.checkNotNullParameter(range, "range");
            for (a.GuildJumpEntity guildJumpEntity : b(editable.toString(), range)) {
                editable.setSpan(guildJumpEntity.a(), guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex(), 33);
            }
            return !r7.isEmpty();
        }

        @NotNull
        public final ArrayList<a.GuildJumpEntity> b(@NotNull String content, @NotNull IntRange range) {
            boolean contains$default;
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(range, "range");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) "\u817e\u8baf\u9891\u9053", false, 2, (Object) null);
            if (!contains$default) {
                return new ArrayList<>();
            }
            String substring = content.substring(range.getFirst(), range.getLast());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            Matcher matcher = g.F.matcher(substring);
            ArrayList<a.GuildJumpEntity> arrayList = new ArrayList<>();
            long currentTimeMillis = System.currentTimeMillis();
            while (matcher.find()) {
                int first = range.getFirst() + matcher.start();
                int first2 = range.getFirst() + matcher.end();
                String group = matcher.group(1);
                if (group == null) {
                    group = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1) ?: \"\"");
                }
                arrayList.add(new a.GuildJumpEntity(group, first, first2));
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 10) {
                QLog.wAsync("HashtagGuildJumpPlugin", 1, "parseGuildJumpHashtag parseSpans takes too long, cost: " + currentTimeMillis2 + " ms");
            }
            return arrayList;
        }

        Companion() {
        }
    }

    private final yn1.a i(Spanned text, int start) {
        yn1.a[] aVarArr;
        Object firstOrNull;
        boolean z16;
        if (start <= 0 || start > text.length() || (aVarArr = (yn1.a[]) text.getSpans(start - 1, start, yn1.a.class)) == null) {
            return null;
        }
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(aVarArr);
        yn1.a aVar = (yn1.a) firstOrNull;
        if (aVar == null) {
            return null;
        }
        if (text.getSpanEnd(aVar) - text.getSpanStart(aVar) < 20) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return aVar;
    }

    private final Pair<yn1.a, yn1.a> j(Spanned text, int start, int count) {
        yn1.a aVar;
        yn1.a aVar2;
        Object firstOrNull;
        Object firstOrNull2;
        Object firstOrNull3;
        yn1.a aVar3 = null;
        if (count > 0) {
            yn1.a[] aVarArr = (yn1.a[]) text.getSpans(start, start + 1, yn1.a.class);
            if (aVarArr != null) {
                firstOrNull3 = ArraysKt___ArraysKt.firstOrNull(aVarArr);
                aVar2 = (yn1.a) firstOrNull3;
            } else {
                aVar2 = null;
            }
            int i3 = start + count;
            yn1.a[] aVarArr2 = (yn1.a[]) text.getSpans(i3 - 1, i3, yn1.a.class);
            if (aVarArr2 != null) {
                firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(aVarArr2);
                aVar3 = (yn1.a) firstOrNull2;
            }
        } else {
            yn1.a[] aVarArr3 = (yn1.a[]) text.getSpans(start, start + 1, yn1.a.class);
            if (aVarArr3 != null) {
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(aVarArr3);
                aVar = (yn1.a) firstOrNull;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                boolean z16 = true;
                int spanStart = text.getSpanStart(aVar) + 1;
                if (start >= text.getSpanEnd(aVar) || spanStart > start) {
                    z16 = false;
                }
                if (z16) {
                    aVar3 = aVar;
                }
            }
            aVar2 = aVar3;
        }
        return new Pair<>(aVar2, aVar3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:12:0x0023, B:14:0x003c, B:16:0x004c, B:19:0x0051, B:21:0x005d, B:23:0x0060, B:27:0x0063, B:28:0x0085, B:30:0x008b), top: B:11:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(@NotNull Editable text) {
        int collectionSizeOrDefault;
        IntRange intRange;
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.isUpdating) {
            return;
        }
        this.isUpdating = true;
        if (this.lookStart < 0) {
            this.lookStart = 0;
        }
        if (this.lookEnd > text.length()) {
            this.lookEnd = text.length();
        }
        try {
            Object[] spans = text.getSpans(this.lookStart, this.lookEnd, yn1.a.class);
            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(lookStart,\u2026uildJumpSpan::class.java)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : spans) {
                yn1.a aVar = (yn1.a) obj;
                int spanStart = text.getSpanStart(aVar);
                int spanEnd = text.getSpanEnd(aVar);
                if (spanStart >= this.lookStart && spanEnd <= this.lookEnd) {
                    text.removeSpan(aVar);
                    intRange = new IntRange(spanStart, spanEnd);
                    if (intRange == null) {
                        arrayList.add(intRange);
                    }
                }
                intRange = null;
                if (intRange == null) {
                }
            }
            ArrayList<a.GuildJumpEntity> b16 = INSTANCE.b(text.toString(), new IntRange(this.lookStart, this.lookEnd));
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (a.GuildJumpEntity guildJumpEntity : b16) {
                text.setSpan(guildJumpEntity.a(), guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex(), 33);
                arrayList2.add(new IntRange(guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex()));
            }
        } finally {
            this.isUpdating = false;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence text, int start, int count, int after) {
        boolean z16;
        int i3;
        String str;
        int i16;
        Intrinsics.checkNotNullParameter(text, "text");
        if (!(text instanceof Spanned)) {
            return;
        }
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.detectionCase = 5;
            this.lookStart = 0;
            this.lookEnd = after;
            return;
        }
        Spanned spanned = (Spanned) text;
        Pair<yn1.a, yn1.a> j3 = j(spanned, start, count);
        yn1.a component1 = j3.component1();
        yn1.a component2 = j3.component2();
        if (component1 == null && component2 == null) {
            this.detectionCase = 5;
            yn1.a i17 = i(spanned, start);
            if (i17 != null) {
                i16 = spanned.getSpanStart(i17);
            } else {
                i16 = start - 6;
            }
            this.lookStart = i16;
            this.lookEnd = start + after + 20;
        } else if (Intrinsics.areEqual(component2, component1)) {
            this.detectionCase = 2;
            this.lookStart = spanned.getSpanStart(component1);
            this.lookEnd = spanned.getSpanEnd(component1) + after + count;
        } else if (!Intrinsics.areEqual(component2, component1) && component2 == null) {
            this.detectionCase = 4;
            this.lookStart = spanned.getSpanStart(component1);
            this.lookEnd = start + after + 20;
        } else if (!Intrinsics.areEqual(component2, component1) && component1 == null) {
            this.detectionCase = 1;
            yn1.a i18 = i(spanned, start);
            if (i18 != null) {
                i3 = spanned.getSpanStart(i18);
            } else {
                i3 = start - 6;
            }
            this.lookStart = i3;
            this.lookEnd = (spanned.getSpanEnd(component2) + after) - count;
        } else {
            this.detectionCase = 3;
            this.lookStart = spanned.getSpanStart(component1);
            this.lookEnd = spanned.getSpanEnd(component2);
        }
        int i19 = this.detectionCase;
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 != 3) {
                    if (i19 != 4) {
                        if (i19 != 5) {
                            str = HippyReporter.RemoveEngineReason.INVALID;
                        } else {
                            str = "case_no_overlap";
                        }
                    } else {
                        str = "case_overlap_start";
                    }
                } else {
                    str = "case_overlap_cross_spans";
                }
            } else {
                str = "case_inside_spans";
            }
        } else {
            str = "case_overlap_end";
        }
        if (QLog.isColorLevel()) {
            QLog.d("HashtagGuildJumpPlugin", 1, "beforeTextChangedDetect: case: " + str + ", lookStart: " + this.lookStart + ", lookEnd: " + this.lookEnd + ", start: " + start + ", after: " + after + ", count: " + count);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b
    /* renamed from: d, reason: from getter */
    public boolean getIsActivatable() {
        return this.isActivatable;
    }

    public final void k(@Nullable Supplier<HashtagCharTextWatcherPlugin> supplier) {
        this.topicPluginProvider = supplier;
    }
}
