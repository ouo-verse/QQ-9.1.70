package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.text.QQTextBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \b2\u00020\u0001:\u0002%\rBE\u0012\u0010\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000605\u0012\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001a\u0012\b\u00100\u001a\u0004\u0018\u00010'\u0012\u0006\u0010?\u001a\u00020\u0011\u0012\u0006\u0010@\u001a\u00020\u0011\u00a2\u0006\u0004\bA\u0010BJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J;\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J$\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\fJ \u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'H\u0016J0\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0016J\u0018\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'H\u0016J(\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010/\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0012\u00101\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00101\u001a\u00020)2\u0006\u00100\u001a\u000202H\u0016J\"\u00101\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010'2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u001e\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00103R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R$\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\n09j\b\u0012\u0004\u0012\u00020\n`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/h;", "Lcom/tencent/mobileqq/text/QQTextBuilder;", "", "obj", "", "i", "Ljava/lang/Class;", "clazz", tl.h.F, "object", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/h$b;", "g", "", "b", "j", "d", "what", "", "start", "end", WadlProxyConsts.FLAGS, "setSpan", "T", "queryStart", "queryEnd", "kind", "", "getSpans", "(IILjava/lang/Class;)[Ljava/lang/Object;", "removeSpan", "tag", "getSpanStart", "getSpanEnd", "getSpanFlags", "limit", "type", "nextSpanTransition", "a", "c", "", "tb", "Landroid/text/SpannableStringBuilder;", SQLiteDatabase.OPERATE_TYPE_REPLACE, "tbstart", "tbend", "where", "insert", "delete", "text", "append", "", "[Ljava/lang/Class;", "blockSpans", "", "e", "Ljava/util/List;", "mWatcherClasses", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "mWatchers", "watcherClasses", "grabFlags", "emoSize", "<init>", "(Ljava/util/List;[Ljava/lang/Class;Ljava/lang/CharSequence;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends QQTextBuilder {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<?>[] blockSpans;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Class<?>> mWatcherClasses;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> mWatchers;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0019\u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0096\u0001J1\u0010\u0011\u001a\u00020\n2\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\f0\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0096\u0001J1\u0010\u0012\u001a\u00020\n2\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\f0\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0096\u0001J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016J8\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nR\u0017\u0010$\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R!\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/h$b;", "Landroid/text/TextWatcher;", "Landroid/text/SpanWatcher;", "", TtmlNode.TAG_SPAN, "", "c", "Landroid/text/Editable;", "kotlin.jvm.PlatformType", "p0", "", "afterTextChanged", "", "", "p1", "p2", "p3", "beforeTextChanged", "onTextChanged", "Landroid/text/Spannable;", "text", "what", "start", "end", "onSpanAdded", "onSpanRemoved", "ostart", "oend", "nstart", "nend", "onSpanChanged", "a", "d", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "mObject", "", "Ljava/lang/Class;", "e", "[Ljava/lang/Class;", "getBlockSpans", "()[Ljava/lang/Class;", "blockSpans", "Ljava/util/concurrent/atomic/AtomicInteger;", "i", "Ljava/util/concurrent/atomic/AtomicInteger;", "mBlockCalls", "<init>", "(Ljava/lang/Object;[Ljava/lang/Class;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements TextWatcher, SpanWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object mObject;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Class<?>[] blockSpans;

        /* renamed from: f, reason: collision with root package name */
        private final /* synthetic */ TextWatcher f221916f;

        /* renamed from: h, reason: collision with root package name */
        private final /* synthetic */ SpanWatcher f221917h;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicInteger mBlockCalls;

        public b(@NotNull Object mObject, @NotNull Class<?>[] blockSpans) {
            Intrinsics.checkNotNullParameter(mObject, "mObject");
            Intrinsics.checkNotNullParameter(blockSpans, "blockSpans");
            this.mObject = mObject;
            this.blockSpans = blockSpans;
            this.f221916f = (TextWatcher) mObject;
            this.f221917h = (SpanWatcher) mObject;
            this.mBlockCalls = new AtomicInteger(0);
        }

        private final boolean c(Object span) {
            for (Class<?> cls : this.blockSpans) {
                if (cls.isInstance(span)) {
                    return true;
                }
            }
            return false;
        }

        public final void a() {
            this.mBlockCalls.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable p06) {
            this.f221916f.afterTextChanged(p06);
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Object getMObject() {
            return this.mObject;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence p06, int p16, int p26, int p36) {
            this.f221916f.beforeTextChanged(p06, p16, p26, p36);
        }

        public final void d() {
            this.mBlockCalls.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(@NotNull Spannable text, @NotNull Object what, int start, int end) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(what, "what");
            if (this.mBlockCalls.get() > 0 && c(what)) {
                return;
            }
            Object obj = this.mObject;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) obj).onSpanAdded(text, what, start, end);
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(@NotNull Spannable text, @NotNull Object what, int ostart, int oend, int nstart, int nend) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(what, "what");
            if (this.mBlockCalls.get() > 0 && c(what)) {
                return;
            }
            Object obj = this.mObject;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) obj).onSpanChanged(text, what, ostart, oend, nstart, nend);
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(@NotNull Spannable text, @NotNull Object what, int start, int end) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(what, "what");
            if (this.mBlockCalls.get() > 0 && c(what)) {
                return;
            }
            Object obj = this.mObject;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) obj).onSpanRemoved(text, what, start, end);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence p06, int p16, int p26, int p36) {
            this.f221916f.onTextChanged(p06, p16, p26, p36);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull List<? extends Class<?>> watcherClasses, @NotNull Class<?>[] blockSpans, @Nullable CharSequence charSequence, int i3, int i16) {
        super(charSequence, i3, i16);
        Intrinsics.checkNotNullParameter(watcherClasses, "watcherClasses");
        Intrinsics.checkNotNullParameter(blockSpans, "blockSpans");
        this.blockSpans = blockSpans;
        this.mWatcherClasses = watcherClasses;
        this.mWatchers = new ArrayList<>();
    }

    private final void b() {
        int size = this.mWatchers.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mWatchers.get(i3).a();
        }
    }

    private final void d() {
        com.tencent.xaction.log.b.a("GuildFeedSpannableBuilder", 4, "[fireWatchers] mWatchers: " + this.mWatchers.size());
        int size = this.mWatchers.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mWatchers.get(i3).onTextChanged(this, 0, super.length(), super.length());
        }
    }

    private final b g(Object object) {
        int size = this.mWatchers.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.mWatchers.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mWatchers[i]");
            b bVar2 = bVar;
            if (bVar2.getMObject() == object) {
                return bVar2;
            }
        }
        return null;
    }

    private final boolean h(Class<?> clazz) {
        return this.mWatcherClasses.contains(clazz);
    }

    private final boolean i(Object obj) {
        if (obj != null && h(obj.getClass())) {
            return true;
        }
        return false;
    }

    private final void j() {
        int size = this.mWatchers.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mWatchers.get(i3).d();
        }
    }

    public final void a() {
        b();
    }

    public final void c() {
        j();
        d();
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ char charAt(int i3) {
        return e(i3);
    }

    public /* bridge */ char e(int i3) {
        return super.charAt(i3);
    }

    public /* bridge */ int f() {
        return super.length();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(@NotNull Object tag) {
        b g16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (i(tag) && (g16 = g(tag)) != null) {
            tag = g16;
        }
        return super.getSpanEnd(tag);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(@NotNull Object tag) {
        b g16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (i(tag) && (g16 = g(tag)) != null) {
            tag = g16;
        }
        return super.getSpanFlags(tag);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(@NotNull Object tag) {
        b g16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (i(tag) && (g16 = g(tag)) != null) {
            tag = g16;
        }
        return super.getSpanStart(tag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @NotNull
    public <T> T[] getSpans(int queryStart, int queryEnd, @Nullable Class<T> kind) {
        if (kind != null && h(kind)) {
            Object[] spans = super.getSpans(queryStart, queryEnd, b.class);
            Intrinsics.checkNotNullExpressionValue(spans, "super.getSpans(\n        \u2026ss.java\n                )");
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (Object obj : spans) {
                if (kind.isInstance((b) obj)) {
                    arrayList.add(obj);
                }
            }
            Object newInstance = Array.newInstance((Class<?>) kind, arrayList.size());
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T of com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedSpannableBuilder.getSpans$lambda$2>");
            T[] tArr = (T[]) ((Object[]) newInstance);
            for (T t16 : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                tArr[i3] = ((b) t16).getMObject();
                i3 = i16;
            }
            return tArr;
        }
        T[] tArr2 = (T[]) super.getSpans(queryStart, queryEnd, kind);
        Intrinsics.checkNotNullExpressionValue(tArr2, "super.getSpans(queryStart, queryEnd, kind)");
        return tArr2;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ int length() {
        return f();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int start, int limit, @NotNull Class<?> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (h(type)) {
            type = b.class;
        }
        return super.nextSpanTransition(start, limit, type);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(@NotNull Object what) {
        b bVar;
        Intrinsics.checkNotNullParameter(what, "what");
        if (i(what)) {
            bVar = g(what);
            if (bVar != null) {
                what = bVar;
            }
        } else {
            bVar = null;
        }
        super.removeSpan(what);
        if (bVar != null) {
            this.mWatchers.remove(bVar);
        }
    }

    @Override // com.tencent.mobileqq.text.QQTextBuilder, android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(@NotNull Object what, int start, int end, int flags) {
        Intrinsics.checkNotNullParameter(what, "what");
        if (i(what)) {
            b bVar = new b(what, this.blockSpans);
            this.mWatchers.add(bVar);
            what = bVar;
        }
        super.setSpan(what, start, end, flags);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @NotNull
    public SpannableStringBuilder delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @NotNull
    public SpannableStringBuilder insert(int where, @NotNull CharSequence tb5) {
        Intrinsics.checkNotNullParameter(tb5, "tb");
        super.insert(where, tb5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @NotNull
    public SpannableStringBuilder replace(int start, int end, @NotNull CharSequence tb5) {
        Intrinsics.checkNotNullParameter(tb5, "tb");
        b();
        super.replace(start, end, tb5);
        j();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @NotNull
    public SpannableStringBuilder insert(int where, @NotNull CharSequence tb5, int start, int end) {
        Intrinsics.checkNotNullParameter(tb5, "tb");
        super.insert(where, tb5, start, end);
        return this;
    }

    @Override // com.tencent.mobileqq.text.QQTextBuilder, android.text.SpannableStringBuilder, android.text.Editable
    @NotNull
    public SpannableStringBuilder replace(int start, int end, @NotNull CharSequence tb5, int tbstart, int tbend) {
        Intrinsics.checkNotNullParameter(tb5, "tb");
        b();
        super.replace(start, end, tb5, tbstart, tbend);
        j();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NotNull
    public SpannableStringBuilder append(@Nullable CharSequence text) {
        super.append(text);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NotNull
    public SpannableStringBuilder append(char text) {
        super.append(text);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NotNull
    public SpannableStringBuilder append(@Nullable CharSequence text, int start, int end) {
        super.append(text, start, end);
        return this;
    }
}
