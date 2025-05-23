package com.tencent.robot.adelie.homepage.create.view;

import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 32\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u0001\u00a2\u0006\u0004\b1\u00102J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J*\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J*\u0010\u0014\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u001b\u0010'\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieWrapperSettingWatcher;", "Lh53/n;", "Landroid/text/Editable;", "editable", "", "startIndex", "endIndex", "", "g", "", "text", "cursorIndex", "Lkotlin/Pair;", "e", ReportConstant.COSTREPORT_PREFIX, "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "afterTextChanged", "", "hasFocus", "f8", "Lcom/tencent/robot/adelie/homepage/create/view/w;", "listener", "i", "enable", tl.h.F, "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "d", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "editText", "Lh53/n;", "watcher", "f", "Lkotlin/Lazy;", "()I", "linkColor", "Lcom/tencent/robot/adelie/homepage/create/view/w;", "settingTextChangeListener", "Z", "enableHighLight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "cursorStart", BdhLogUtil.LogTag.Tag_Conn, "addCharacterCount", "<init>", "(Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;Lh53/n;)V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieWrapperSettingWatcher implements h53.n {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Regex> E;

    /* renamed from: C, reason: from kotlin metadata */
    private int addCharacterCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterceptTouchEditText editText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h53.n watcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy linkColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private w settingTextChangeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean enableHighLight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int cursorStart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieWrapperSettingWatcher$a;", "", "Lkotlin/text/Regex;", "regex$delegate", "Lkotlin/Lazy;", "a", "()Lkotlin/text/Regex;", "regex", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.view.AdelieWrapperSettingWatcher$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex a() {
            return (Regex) AdelieWrapperSettingWatcher.E.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Regex> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Regex>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieWrapperSettingWatcher$Companion$regex$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Regex invoke() {
                return new Regex("(?m)^#.*?$");
            }
        });
        E = lazy;
    }

    public AdelieWrapperSettingWatcher(@NotNull InterceptTouchEditText editText, @NotNull h53.n watcher) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        this.editText = editText;
        this.watcher = watcher;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieWrapperSettingWatcher$linkColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                InterceptTouchEditText interceptTouchEditText;
                interceptTouchEditText = AdelieWrapperSettingWatcher.this.editText;
                return Integer.valueOf(interceptTouchEditText.getContext().getResources().getColor(R.color.qui_common_text_link));
            }
        });
        this.linkColor = lazy;
        this.enableHighLight = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AdelieWrapperSettingWatcher this$0, Editable editable) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = this$0.settingTextChangeListener;
        if (wVar != null) {
            if (editable != null) {
                str = editable.toString();
            } else {
                str = null;
            }
            wVar.a(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        r11 = kotlin.text.StringsKt__StringsKt.indexOf$default(r11, '\n', r12, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default(r11, '\n', r12 - 1, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        r11 = kotlin.text.StringsKt__StringsKt.indexOf$default(r11, '\n', r12 + r3, false, 4, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, Integer> e(CharSequence text, int cursorIndex) {
        int i3;
        int indexOf$default;
        if (cursorIndex <= 0 || i3 == -1) {
            i3 = 0;
        }
        int length = text.length();
        int i16 = this.addCharacterCount;
        if (i16 <= 0 ? indexOf$default != -1 : indexOf$default != -1) {
            length = indexOf$default;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(length));
    }

    private final int f() {
        return ((Number) this.linkColor.getValue()).intValue();
    }

    private final void g(Editable editable, int startIndex, int endIndex) {
        int count;
        long currentTimeMillis = System.currentTimeMillis();
        CharSequence subSequence = editable.subSequence(startIndex, endIndex);
        Sequence<MatchResult> findAll$default = Regex.findAll$default(INSTANCE.a(), subSequence, 0, 2, null);
        Log.d("AdelieWrapperSettingWatcher", "handleHighText findAll cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", subContent.length=" + subSequence.length() + ", ");
        long currentTimeMillis2 = System.currentTimeMillis();
        for (MatchResult matchResult : findAll$default) {
            editable.setSpan(new ForegroundColorSpan(f()), matchResult.getRange().getFirst() + startIndex, matchResult.getRange().getLast() + startIndex + 1, 33);
        }
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
        count = SequencesKt___SequencesKt.count(findAll$default);
        Log.d("AdelieWrapperSettingWatcher", "handleHighText setSpan cost=" + currentTimeMillis3 + ", matches=" + count);
    }

    @Override // h53.k
    public void afterTextChanged(@Nullable final Editable s16) {
        this.watcher.afterTextChanged(s16);
        if (this.enableHighLight) {
            this.editText.setInputViewWatcher(null);
            if (s16 != null) {
                Pair<Integer, Integer> e16 = e(s16, this.cursorStart);
                g(s16, e16.component1().intValue(), e16.component2().intValue());
            }
            this.editText.setInputViewWatcher(this);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.view.t
            @Override // java.lang.Runnable
            public final void run() {
                AdelieWrapperSettingWatcher.d(AdelieWrapperSettingWatcher.this, s16);
            }
        });
    }

    @Override // h53.k
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        this.watcher.beforeTextChanged(s16, start, count, after);
        ForegroundColorSpan[] spans = (ForegroundColorSpan[]) this.editText.getEditableText().getSpans(start, start, ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "spans");
        for (ForegroundColorSpan foregroundColorSpan : spans) {
            this.editText.getEditableText().removeSpan(foregroundColorSpan);
        }
    }

    @Override // h53.k
    public void f8(boolean hasFocus) {
        this.watcher.f8(hasFocus);
    }

    public final void h(boolean enable) {
        this.enableHighLight = enable;
    }

    public final void i(@Nullable w listener) {
        this.settingTextChangeListener = listener;
    }

    @Override // h53.k
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        this.watcher.onTextChanged(s16, start, before, count);
        this.addCharacterCount = count;
        this.cursorStart = start;
    }
}
