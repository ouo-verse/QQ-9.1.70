package com.tencent.android.androidbypass;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.android.androidbypass.Element;
import com.tencent.android.androidbypass.codeblock.entry.CodeBlockProcessEntry;
import com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpan;
import com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpanElementSoup;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.enhance.j;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.android.androidbypass.span.BypassCompatStyleSpan;
import com.tencent.android.androidbypass.span.BypassForegroundColorSpan;
import com.tencent.android.androidbypass.span.ClickableUrlSpan;
import com.tencent.android.androidbypass.span.d;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.CustomStyleElement;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Bypass {
    static IPatchRedirector $redirector_ = null;
    private static final int HOST_VISITOR_TAG;
    private static final String LINK_VERIFY_EMOJI = "\u1f517";
    private static final String TAG = "Bypass";
    private int mCodeBlockIndent;
    private com.tencent.android.androidbypass.e mImageSpanClickListener;
    private final int mMaxElementsCount;
    private ClickableUrlSpan.a mOnclickListener;
    public final f mOptions;
    private final Map<Element, Integer> mOrderedListNumber;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedStyleSpanElementSoup f71916d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f71917e;

        a(FeedStyleSpanElementSoup feedStyleSpanElementSoup, String str) {
            this.f71916d = feedStyleSpanElementSoup;
            this.f71917e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Bypass.this, feedStyleSpanElementSoup, str);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                tt.a aVar = Bypass.this.mOptions.f71933e;
                String f16 = this.f71916d.f();
                com.tencent.android.androidbypass.config.a.f72049a.i(Bypass.TAG, "onClickFeedStyleSpan|link=" + f16);
                if (aVar != null) {
                    aVar.a(view, this.f71916d.g().toString(), f16, this.f71917e, 1, Bundle.EMPTY);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements Supplier<com.tencent.android.androidbypass.custom.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f71919a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes3.dex */
        public class a implements com.tencent.android.androidbypass.custom.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TextView f71920a;

            a(TextView textView) {
                this.f71920a = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) textView);
                }
            }

            @Override // com.tencent.android.androidbypass.custom.a
            @NonNull
            public Context getContext() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f71920a.getContext();
            }

            @Override // com.tencent.android.androidbypass.custom.a
            public int getMaxWidth() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return this.f71920a.getMaxWidth();
            }

            @Override // com.tencent.android.androidbypass.custom.b
            public void invalidate() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                } else {
                    TextView textView = this.f71920a;
                    textView.setText(textView.getText());
                }
            }
        }

        b(WeakReference weakReference) {
            this.f71919a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            }
        }

        private com.tencent.android.androidbypass.custom.a a(@NonNull TextView textView) {
            return new a(textView);
        }

        @Override // androidx.core.util.Supplier
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.android.androidbypass.custom.a get() {
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.android.androidbypass.custom.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            WeakReference weakReference = this.f71919a;
            if (weakReference != null) {
                textView = (TextView) weakReference.get();
            } else {
                textView = null;
            }
            if (textView == null) {
                return null;
            }
            Object tag = textView.getTag(Bypass.HOST_VISITOR_TAG);
            if (tag instanceof com.tencent.android.androidbypass.custom.a) {
                return (com.tencent.android.androidbypass.custom.a) tag;
            }
            com.tencent.android.androidbypass.custom.a a16 = a(textView);
            textView.setTag(Bypass.HOST_VISITOR_TAG, a16);
            return a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends com.tencent.android.androidbypass.span.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f71922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.android.androidbypass.span.a f71923e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f71924f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f71925h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f71926i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f71927m;

        c(com.tencent.android.androidbypass.span.a aVar, String str, e eVar, long j3, String str2) {
            this.f71923e = aVar;
            this.f71924f = str;
            this.f71925h = eVar;
            this.f71926i = j3;
            this.f71927m = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Bypass.this, aVar, str, eVar, Long.valueOf(j3), str2);
            } else {
                this.f71922d = 0L;
            }
        }

        protected boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f71922d < 800) {
                com.tencent.android.androidbypass.config.a.f72049a.d("Markdown.ClickableImageSpan", "click fast");
                this.f71922d = currentTimeMillis;
                return true;
            }
            this.f71922d = currentTimeMillis;
            return false;
        }

        @Override // com.tencent.android.androidbypass.span.b, android.text.style.ClickableSpan
        public void onClick(View view) {
            e eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            if (Bypass.this.mImageSpanClickListener != null && !a()) {
                Bypass.this.mImageSpanClickListener.a(view, this.f71923e, this.f71924f);
            }
            if (!this.f71923e.c() && (eVar = this.f71925h) != null) {
                this.f71923e.d(eVar.a(this.f71926i, this.f71924f, this.f71927m, (TextView) view));
            }
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f71928a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7443);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Element.Type.values().length];
            f71928a = iArr;
            try {
                iArr[Element.Type.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71928a[Element.Type.LINEBREAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f71928a[Element.Type.LIST_ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f71928a[Element.Type.AUTOLINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f71928a[Element.Type.HRULE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f71928a[Element.Type.IMAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f71928a[Element.Type.CODE_SPAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f71928a[Element.Type.HEADER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f71928a[Element.Type.EMPHASIS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f71928a[Element.Type.DOUBLE_EMPHASIS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f71928a[Element.Type.TRIPLE_EMPHASIS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f71928a[Element.Type.BLOCK_CODE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f71928a[Element.Type.LINK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f71928a[Element.Type.BLOCK_QUOTE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f71928a[Element.Type.STRIKETHROUGH.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f71928a[Element.Type.PARAGRAPH.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f71928a[Element.Type.CUSTOM_SYNTAX.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface e {
        Drawable a(long j3, String str, String str2, TextView textView);

        @NonNull
        h.b b(@Nullable Context context, @NonNull String str, @Nullable h.b.c cVar, @Nullable h.b.InterfaceC0719b interfaceC0719b);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f71929a;

        /* renamed from: b, reason: collision with root package name */
        private float f71930b;

        /* renamed from: c, reason: collision with root package name */
        private com.tencent.android.androidbypass.enhance.d f71931c;

        /* renamed from: d, reason: collision with root package name */
        private st.a f71932d;

        /* renamed from: e, reason: collision with root package name */
        private tt.a f71933e;

        /* renamed from: f, reason: collision with root package name */
        private final com.tencent.android.androidbypass.parser.api.a f71934f;

        /* renamed from: g, reason: collision with root package name */
        public final List<ut.a> f71935g;

        /* renamed from: h, reason: collision with root package name */
        private com.tencent.android.androidbypass.richui.c f71936h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f71937i;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f71934f = new com.tencent.android.androidbypass.enhance.scheme.matcher.e();
            this.f71935g = new ArrayList();
            this.f71936h = new com.tencent.android.androidbypass.richui.a();
            this.f71937i = false;
            this.f71929a = 1;
            this.f71930b = 10.0f;
        }

        public tt.a g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (tt.a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f71933e;
        }

        public f h(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (f) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.f71937i = z16;
            return this;
        }

        public f i(List<ut.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            }
            if (list != null) {
                this.f71935g.addAll(list);
            }
            return this;
        }

        public f j(st.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (f) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            }
            this.f71932d = aVar;
            return this;
        }

        public f k(tt.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (f) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            }
            this.f71933e = aVar;
            return this;
        }

        public f l(com.tencent.android.androidbypass.richui.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
            }
            if (cVar != null) {
                this.f71936h = cVar;
            }
            return this;
        }

        public f m(com.tencent.android.androidbypass.enhance.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
            }
            this.f71931c = dVar;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            HOST_VISITOR_TAG = View.generateViewId() + 33554432;
        }
    }

    public Bypass() {
        this(new f());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @NonNull
    private static Supplier<com.tencent.android.androidbypass.custom.a> createFeedStyleSpanHostVisitorSupplier(@Nullable WeakReference<TextView> weakReference) {
        return new b(weakReference);
    }

    private void initParameters(Context context) {
        this.mCodeBlockIndent = (int) TypedValue.applyDimension(this.mOptions.f71929a, this.mOptions.f71930b, context.getResources().getDisplayMetrics());
    }

    @Nullable
    private Document processMarkdown(String str, boolean z16, int i3) {
        com.tencent.android.androidbypass.d dVar = com.tencent.android.androidbypass.b.f71942a;
        dVar.c();
        com.tencent.bypass.nativeinterface.Document processMarkdownV2 = BypassSoEngine.INSTANCE.processMarkdownV2(str, z16, i3);
        dVar.b(com.tencent.android.androidbypass.b.g(com.tencent.android.androidbypass.b.a("markdown_length", String.valueOf(str.length())), com.tencent.android.androidbypass.b.a("parse_code", String.valueOf(z16)), com.tencent.android.androidbypass.b.a("parse_code_line", String.valueOf(i3))));
        if (processMarkdownV2 == null) {
            com.tencent.android.androidbypass.config.a.f72049a.e(TAG, "processMarkdown fail JNIDocument = null ");
            return null;
        }
        return new Document(processMarkdownV2.getElements());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private SpannableStringBuilder renderCodeSpan(Element element, int i3, int i16, TextView textView, Boolean bool, Context context, SpannableStringBuilder spannableStringBuilder, String str) {
        SpannableStringBuilder spannableStringBuilder2;
        com.tencent.android.androidbypass.codeblock.config.c cVar;
        LifecycleOwner lifecycleOwner;
        boolean z16;
        if (textView != null) {
            try {
                ArrayList<CodeNode> codeAttribute = element.getCodeAttribute("code_node");
                String stringAttribute = element.getStringAttribute(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                String stringAttribute2 = element.getStringAttribute("cost_time");
                if (codeAttribute != null && context != null) {
                    if (this.mOptions.f71932d != null) {
                        cVar = this.mOptions.f71932d.d(context, stringAttribute);
                        lifecycleOwner = this.mOptions.f71932d.b();
                    } else {
                        cVar = null;
                        lifecycleOwner = null;
                    }
                    try {
                        if (cVar != null) {
                            boolean equals = TextUtils.equals(element.getStringAttribute("all_code"), "true");
                            String spannableStringBuilder3 = spannableStringBuilder.toString();
                            if (bool.booleanValue() && i3 == i16 - 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            try {
                                spannableStringBuilder2 = CodeBlockProcessEntry.f71977b.b(textView, lifecycleOwner, new com.tencent.android.androidbypass.codeblock.span.b(codeAttribute, stringAttribute, equals, spannableStringBuilder3, z16), cVar);
                            } catch (Exception e16) {
                                com.tencent.android.androidbypass.config.a.f72049a.e(TAG, Objects.toString(e16.getMessage()));
                            }
                            if (!TextUtils.isEmpty(stringAttribute2)) {
                                try {
                                    com.tencent.android.androidbypass.b.f71943b.a(com.tencent.android.androidbypass.b.g(com.tencent.android.androidbypass.b.a(IjkMediaMeta.IJKM_KEY_LANGUAGE, stringAttribute), com.tencent.android.androidbypass.b.a("code_length", String.valueOf(str.length())), com.tencent.android.androidbypass.b.a("node_size", String.valueOf(codeAttribute.size()))), Long.parseLong(stringAttribute2));
                                } catch (NumberFormatException e17) {
                                    com.tencent.android.androidbypass.config.a.f72049a.e(TAG, Log.getStackTraceString(e17));
                                }
                            }
                            return spannableStringBuilder2;
                        }
                        if (!TextUtils.isEmpty(stringAttribute2)) {
                        }
                        return spannableStringBuilder2;
                    } catch (Exception e18) {
                        e = e18;
                        com.tencent.android.androidbypass.config.a.f72049a.e(TAG, e.toString());
                        return spannableStringBuilder2;
                    }
                    spannableStringBuilder2 = spannableStringBuilder;
                }
            } catch (Exception e19) {
                e = e19;
                spannableStringBuilder2 = spannableStringBuilder;
            }
        }
        return spannableStringBuilder;
    }

    private void renderFeedStyleSpan(@Nullable TextView textView, @NonNull i iVar, @Nullable e eVar, @Nullable WeakReference<TextView> weakReference, @NonNull SpannableStringBuilder spannableStringBuilder, @NonNull FeedStyleSpanElementSoup feedStyleSpanElementSoup, @NonNull String str, long j3) {
        if (textView == null) {
            spannableStringBuilder.clear();
            spannableStringBuilder.append((CharSequence) feedStyleSpanElementSoup.j());
        } else {
            setSpan(spannableStringBuilder, new FeedStyleSpan(iVar, feedStyleSpanElementSoup, createFeedStyleSpanHostVisitorSupplier(weakReference), eVar, j3));
            setSpan(spannableStringBuilder, new a(feedStyleSpanElementSoup, str));
        }
    }

    private static void renderHorizontalLine(@Nullable TextView textView, i iVar, @Nullable DisplayMetrics displayMetrics, @NonNull SpannableStringBuilder spannableStringBuilder, @Nullable WeakReference<TextView> weakReference) {
        if (textView == null) {
            spannableStringBuilder.clear();
            return;
        }
        int safeApplyDimension = safeApplyDimension(displayMetrics, iVar.V, iVar.U);
        setSpan(spannableStringBuilder, new com.tencent.android.androidbypass.span.e(iVar.f(weakReference), safeApplyDimension(displayMetrics, iVar.R, iVar.Q), safeApplyDimension(displayMetrics, iVar.T, iVar.S)));
        setSpanSafely(spannableStringBuilder, 0, 1, new com.tencent.android.androidbypass.span.d(safeApplyDimension, 0));
    }

    private void renderLinkElement(@NonNull i iVar, @Nullable e eVar, @NonNull Element element, @Nullable WeakReference<TextView> weakReference, @Nullable TextView textView, @NonNull SpannableStringBuilder spannableStringBuilder, long j3) {
        if (spannableStringBuilder.length() >= 2 && LINK_VERIFY_EMOJI.contentEquals(spannableStringBuilder.subSequence(0, 2))) {
            spannableStringBuilder.replace(0, 2, "");
        }
        if (this.mOptions.f71931c != null) {
            String stringAttribute = element.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
            String str = element.text;
            Element element2 = element.parent;
            if (((element2 != null && (element2.type != Element.Type.PARAGRAPH || element2.parent != null)) || !renderLinkOnCallReservedVerifier(textView, iVar, eVar, weakReference, spannableStringBuilder, stringAttribute, str, j3)) && textView != null) {
                renderLinkOnCallBusinessVerifier(textView, spannableStringBuilder, stringAttribute, str);
            }
        }
    }

    private void renderLinkOnCallBusinessVerifier(TextView textView, SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        j a16 = this.mOptions.f71931c.a(str, str2, textView);
        if (a16 != null) {
            setSpan(spannableStringBuilder, new ClickableUrlSpan(str, spannableStringBuilder.toString(), this.mOnclickListener, a16));
        }
    }

    private boolean renderLinkOnCallReservedVerifier(@Nullable TextView textView, @NonNull i iVar, @Nullable e eVar, @Nullable WeakReference<TextView> weakReference, @NonNull SpannableStringBuilder spannableStringBuilder, @NonNull String str, @NonNull String str2, long j3) {
        com.tencent.android.androidbypass.parser.api.d a16 = com.tencent.android.androidbypass.parser.api.d.a(str);
        if (a16 == null) {
            com.tencent.android.androidbypass.config.a.f72049a.e(TAG, "parse uri failed| url = " + str);
            return false;
        }
        if (!this.mOptions.f71934f.a(str, a16, str2)) {
            return false;
        }
        for (ut.a aVar : this.mOptions.f71935g) {
            if (aVar.a(a16.e())) {
                aVar.c(textView, this.mOptions, spannableStringBuilder, a16, str2, j3);
                return true;
            }
        }
        FeedStyleSpanElementSoup i3 = FeedStyleSpanElementSoup.i(a16.e());
        if (i3 != null) {
            renderFeedStyleSpan(textView, iVar, eVar, weakReference, spannableStringBuilder, i3, str2, j3);
            return true;
        }
        com.tencent.android.androidbypass.config.a.f72049a.w(TAG, "find feed style hidden link, but it is not illegal, link=" + str);
        return false;
    }

    private static int safeApplyDimension(DisplayMetrics displayMetrics, int i3, float f16) {
        if (displayMetrics != null) {
            return (int) TypedValue.applyDimension(i3, f16, displayMetrics);
        }
        return 0;
    }

    private static void setBlockSpan(SpannableStringBuilder spannableStringBuilder, Object obj) {
        spannableStringBuilder.setSpan(obj, 0, Math.max(0, spannableStringBuilder.length()), 33);
    }

    private void setClickableImageSpan(SpannableStringBuilder spannableStringBuilder, com.tencent.android.androidbypass.span.a aVar, String str, String str2, e eVar, long j3) {
        spannableStringBuilder.setSpan(aVar, 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new c(aVar, str, eVar, j3, str2), 0, spannableStringBuilder.length(), 33);
    }

    public static void setSpan(SpannableStringBuilder spannableStringBuilder, Object obj) {
        spannableStringBuilder.setSpan(obj, 0, spannableStringBuilder.length(), 33);
    }

    public static void setSpanSafely(SpannableStringBuilder spannableStringBuilder, int i3, int i16, Object obj) {
        int max;
        int min;
        if (spannableStringBuilder != null && obj != null && (max = Math.max(0, i3)) < (min = Math.min(i16, spannableStringBuilder.length()))) {
            spannableStringBuilder.setSpan(obj, max, min, 33);
        }
    }

    @Nullable
    private Document tryParseAsDocument(@NonNull String str) {
        boolean z16;
        int i3;
        try {
            if (this.mOptions.f71932d != null) {
                z16 = this.mOptions.f71932d.c();
                i3 = this.mOptions.f71932d.a();
            } else {
                z16 = false;
                i3 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Document processMarkdown = processMarkdown(str, z16, i3);
            com.tencent.android.androidbypass.config.g gVar = com.tencent.android.androidbypass.config.a.f72049a;
            gVar.d(TAG, "markdownToSpannable processMarkdown time:" + (System.currentTimeMillis() - currentTimeMillis));
            if (processMarkdown == null) {
                gVar.e(TAG, "markdownToSpannable: " + str);
                return processMarkdown;
            }
            return processMarkdown;
        } catch (Throwable th5) {
            com.tencent.android.androidbypass.config.a.f72049a.e(TAG, "markdownToSpannableException: " + th5 + " md=" + str);
            return null;
        }
    }

    public CharSequence documentToSpannable(Document document, TextView textView, i iVar, a.b bVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CharSequence) iPatchRedirector.redirect((short) 10, this, document, textView, iVar, bVar);
        }
        if (document == null) {
            com.tencent.android.androidbypass.config.a.f72049a.e(TAG, "documentToSpannable fail document = null ");
            return "";
        }
        if (textView != null) {
            initParameters(textView.getContext().getApplicationContext());
        }
        int min = Math.min(document.getElementCount(), this.mMaxElementsCount);
        CharSequence[] charSequenceArr = new CharSequence[min];
        for (int i3 = 0; i3 < min; i3++) {
            Element element = document.getElement(i3);
            element.setDocument(document);
            if (i3 == min - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            charSequenceArr[i3] = recurseElement(element, i3, min, null, textView, iVar, Boolean.valueOf(z16), bVar);
        }
        return TextUtils.concat(charSequenceArr);
    }

    public Document markdownToDocumentAsync(String str) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Document) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        Document document = null;
        try {
            if (this.mOptions.f71932d != null) {
                z16 = this.mOptions.f71932d.c();
                i3 = this.mOptions.f71932d.a();
            } else {
                z16 = false;
                i3 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            document = processMarkdown(str, z16, i3);
            com.tencent.android.androidbypass.config.a.f72049a.e(TAG, "markdownToDocumentAsync processMarkdown time:" + (System.currentTimeMillis() - currentTimeMillis));
            return document;
        } catch (Throwable th5) {
            th5.printStackTrace();
            com.tencent.android.androidbypass.config.a.f72049a.e(TAG, "markdownToDocumentAsync: " + str);
            return document;
        }
    }

    public CharSequence markdownToSpannable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? markdownToSpannable(str, null, null) : (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
    }

    public CharSequence recurseElement(Element element, int i3, int i16, e eVar, TextView textView, i iVar, Boolean bool, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? recurseElement(element, i3, i16, eVar, textView, iVar, bool, bVar, null) : (CharSequence) iPatchRedirector.redirect((short) 11, this, element, Integer.valueOf(i3), Integer.valueOf(i16), eVar, textView, iVar, bool, bVar);
    }

    public void setImageSpanClickListener(com.tencent.android.androidbypass.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        } else {
            this.mImageSpanClickListener = eVar;
        }
    }

    public void setMaxElementsCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    public void setUrlSpanClickListener(ClickableUrlSpan.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.mOnclickListener = aVar;
        }
    }

    public Bypass(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        this.mOrderedListNumber = new ConcurrentHashMap();
        this.mOptions = fVar;
        this.mMaxElementsCount = 500;
    }

    public CharSequence markdownToSpannable(String str, e eVar, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? markdownToSpannable(str, eVar, textView, new i(), new a.b()) : (CharSequence) iPatchRedirector.redirect((short) 7, this, str, eVar, textView);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0288 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x030f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence recurseElement(Element element, int i3, int i16, e eVar, TextView textView, i iVar, Boolean bool, a.b bVar, com.tencent.android.androidbypass.viewgroup.d dVar) {
        boolean z16;
        int min;
        int i17;
        Element.Type type;
        Element.Type type2;
        String str;
        String str2;
        Element.Type type3;
        CharSequence charSequence;
        String str3;
        String str4;
        Drawable drawable;
        int[] iArr;
        i iVar2;
        String str5;
        int i18;
        Element elementIndexInParent;
        Element.Type type4;
        String str6;
        char c16;
        DisplayMetrics displayMetrics;
        Context context;
        int i19;
        j a16;
        Element element2;
        Element.Type type5;
        Element.Type type6;
        Element.Type type7;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CharSequence) iPatchRedirector.redirect((short) 12, this, element, Integer.valueOf(i3), Integer.valueOf(i16), eVar, textView, iVar, bool, bVar, dVar);
        }
        if (element.getIgnore()) {
            return "";
        }
        Element.Type type8 = element.type;
        if (type8 == Element.Type.LIST) {
            this.mOrderedListNumber.put(element, 1);
        } else if (type8 == Element.Type.LIST_ITEM) {
            String stringAttribute = element.getStringAttribute(WadlProxyConsts.FLAGS);
            if (!TextUtils.isEmpty(stringAttribute)) {
                z16 = Integer.parseInt(stringAttribute) != 0;
                min = Math.min(element.children.size(), this.mMaxElementsCount);
                CharSequence[] charSequenceArr = new CharSequence[min];
                i17 = 0;
                while (i17 < min) {
                    int i26 = i17;
                    CharSequence[] charSequenceArr2 = charSequenceArr;
                    charSequenceArr2[i26] = recurseElement(element.children.get(i17), i17, min, eVar, textView, iVar, Boolean.valueOf((bool.booleanValue() && i17 == min + (-1)) ? z18 : z17), bVar, dVar);
                    i17 = i26 + 1;
                    z18 = z18;
                    type8 = type8;
                    charSequenceArr = charSequenceArr2;
                    min = min;
                    z17 = false;
                }
                CharSequence[] charSequenceArr3 = charSequenceArr;
                type = type8;
                type2 = Element.Type.LIST;
                if (type == type2) {
                    this.mOrderedListNumber.remove(element);
                }
                CharSequence concat = TextUtils.concat(charSequenceArr3);
                g gVar = new g();
                Element elementIndexInParent2 = element.getElementIndexInParent(i3 + 1);
                String str7 = element.text;
                if (element.children.size() == 0 && (element2 = element.parent) != null && (type5 = element2.type) != Element.Type.BLOCK_CODE) {
                    type6 = element.type;
                    type7 = Element.Type.CODE_SPAN;
                    if (type6 != type7 && type5 != Element.Type.HEADER && type5 == Element.Type.LIST_ITEM && TextUtils.equals(str7, "\n") && (elementIndexInParent2 == null || elementIndexInParent2.type != type7)) {
                        str = "";
                        String stringAttribute2 = element.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                        if (type == Element.Type.IMAGE || eVar == null || TextUtils.isEmpty(stringAttribute2) || textView == null) {
                            str2 = QCircleSchemeAttr.Polymerize.ALT;
                            type3 = type2;
                            charSequence = concat;
                            str3 = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
                            str4 = str;
                            drawable = null;
                        } else {
                            String stringAttribute3 = element.getStringAttribute(QCircleSchemeAttr.Polymerize.ALT);
                            long a17 = bVar.a();
                            str2 = QCircleSchemeAttr.Polymerize.ALT;
                            type3 = type2;
                            str3 = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
                            charSequence = concat;
                            str4 = str;
                            drawable = eVar.a(a17, stringAttribute2, stringAttribute3, textView);
                        }
                        WeakReference<TextView> weakReference = textView == null ? new WeakReference<>(textView) : null;
                        iArr = d.f71928a;
                        switch (iArr[type.ordinal()]) {
                            case 1:
                                iVar2 = iVar;
                                str5 = str3;
                                i18 = 1;
                                Element element3 = element.parent;
                                if (element3 != null && element3.type == Element.Type.LIST_ITEM && ((elementIndexInParent = element.getElementIndexInParent(i3 - 1)) == null || (!elementIndexInParent.type.isBlock() && elementIndexInParent.type != Element.Type.LINEBREAK))) {
                                    gVar.append("\n");
                                    break;
                                }
                                break;
                            case 2:
                                iVar2 = iVar;
                                str5 = str3;
                                i18 = 1;
                                gVar.append("\n");
                                break;
                            case 3:
                                if (z16 && this.mOrderedListNumber.containsKey(element.parent)) {
                                    int intValue = this.mOrderedListNumber.get(element.parent).intValue();
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(intValue);
                                    str5 = str3;
                                    sb5.append(".");
                                    gVar.append((CharSequence) sb5.toString());
                                    this.mOrderedListNumber.put(element.parent, Integer.valueOf(intValue + 1));
                                    iVar2 = iVar;
                                    i18 = 1;
                                } else {
                                    str5 = str3;
                                    iVar2 = iVar;
                                    i18 = 1;
                                    gVar.append((CharSequence) iVar2.f72196l);
                                    setSpan(gVar, new BypassCompatStyleSpan(1));
                                }
                                gVar.append((CharSequence) new SpannableStringBuilder(" "));
                                break;
                            case 4:
                                gVar.append((CharSequence) element.getStringAttribute(str3));
                                iVar2 = iVar;
                                str5 = str3;
                                i18 = 1;
                                break;
                            case 5:
                                gVar.append("-");
                                iVar2 = iVar;
                                str5 = str3;
                                i18 = 1;
                                break;
                            case 6:
                                String str8 = bVar.b() ? GuildMsgElementApiImpl.DESC_ELEMENT_PIC : " ";
                                if (drawable != null) {
                                    gVar.append((CharSequence) str8);
                                } else if (textView == null) {
                                    gVar.append((CharSequence) str8);
                                } else {
                                    String stringAttribute4 = element.getStringAttribute(str2);
                                    if (TextUtils.isEmpty(stringAttribute4)) {
                                        stringAttribute4 = element.getStringAttribute("title");
                                    }
                                    if (!TextUtils.isEmpty(stringAttribute4)) {
                                        gVar.append((CharSequence) ("[" + stringAttribute4 + "]"));
                                    }
                                }
                                iVar2 = iVar;
                                str5 = str3;
                                i18 = 1;
                                break;
                            default:
                                iVar2 = iVar;
                                str5 = str3;
                                i18 = 1;
                                break;
                        }
                        gVar.append((CharSequence) str4);
                        gVar.append(charSequence);
                        int i27 = i3 >= i16 + (-1) ? i18 : 0;
                        if (element.parent == null || i27 != 0) {
                            type4 = Element.Type.LIST_ITEM;
                            if (type != type4) {
                                if (i27 != 0 && gVar.length() > 0) {
                                    if (gVar.charAt(gVar.length() - i18) != '\n') {
                                        gVar.append("\n");
                                    }
                                    c16 = '\n';
                                    str6 = str4;
                                    if (textView != null) {
                                        context = textView.getContext();
                                        displayMetrics = textView.getResources().getDisplayMetrics();
                                    } else {
                                        displayMetrics = null;
                                        context = null;
                                    }
                                    i19 = iArr[type.ordinal()];
                                    if (i19 != 1) {
                                        switch (i19) {
                                            case 4:
                                                String stringAttribute5 = element.getStringAttribute(str5);
                                                if (!Patterns.WEB_URL.matcher(stringAttribute5).matches() || textView == null || (a16 = this.mOptions.f71931c.a(stringAttribute5, stringAttribute5, textView)) == null) {
                                                    return gVar;
                                                }
                                                setSpan(gVar, new ClickableUrlSpan(stringAttribute5, stringAttribute5, this.mOnclickListener, a16));
                                                return gVar;
                                            case 5:
                                                renderHorizontalLine(textView, iVar2, displayMetrics, gVar, weakReference);
                                                return gVar;
                                            case 6:
                                                if (drawable == null) {
                                                    return gVar;
                                                }
                                                String stringAttribute6 = element.getStringAttribute(str2);
                                                int i28 = iVar2.f72181c0;
                                                float f16 = iVar2.f72179b0;
                                                d.Companion companion = com.tencent.android.androidbypass.span.d.INSTANCE;
                                                setClickableImageSpan(gVar, new com.tencent.android.androidbypass.span.a(drawable, safeApplyDimension(displayMetrics, i28, f16 + companion.a(stringAttribute6, "topSpace")), safeApplyDimension(displayMetrics, iVar2.f72181c0, companion.a(stringAttribute6, "bottomSpace"))), stringAttribute2, stringAttribute6, eVar, bVar.a());
                                                return gVar;
                                            case 7:
                                                return renderCodeSpan(element, i3, i16, textView, bool, context, gVar, str6);
                                            case 8:
                                                if (textView == null) {
                                                    return gVar;
                                                }
                                                setSpan(gVar, new RelativeSizeSpan(iVar2.f72178b[Integer.parseInt(element.getStringAttribute("level")) - 1]));
                                                setSpan(gVar, new BypassCompatStyleSpan(1));
                                                setSpan(gVar, new BypassForegroundColorSpan(iVar2.e(weakReference)));
                                                if (i3 <= 0) {
                                                    return gVar;
                                                }
                                                setSpanSafely(gVar, 0, 1, new com.tencent.android.androidbypass.span.d(safeApplyDimension(displayMetrics, iVar2.f72186f, iVar2.f72184e), 0));
                                                return gVar;
                                            case 9:
                                                setSpan(gVar, new BypassCompatStyleSpan(2));
                                                return gVar;
                                            case 10:
                                                if (textView == null) {
                                                    return gVar;
                                                }
                                                setSpan(gVar, new BypassCompatStyleSpan(1));
                                                return gVar;
                                            case 11:
                                                setSpan(gVar, new BypassCompatStyleSpan(3));
                                                return gVar;
                                            case 12:
                                                setSpan(gVar, new LeadingMarginSpan.Standard(this.mCodeBlockIndent));
                                                setSpan(gVar, new TypefaceSpan("monospace"));
                                                return gVar;
                                            case 13:
                                                renderLinkElement(iVar, eVar, element, weakReference, textView, gVar, bVar.a());
                                                return gVar;
                                            case 14:
                                                if (textView == null) {
                                                    return gVar;
                                                }
                                                com.tencent.android.androidbypass.enhance.e g16 = iVar2.g(weakReference);
                                                int length = gVar.length();
                                                if (length > 2) {
                                                    int i29 = length - 1;
                                                    if (gVar.charAt(i29) == c16 && gVar.charAt(length - 2) == c16) {
                                                        gVar.delete(i29, length);
                                                    }
                                                }
                                                setBlockSpan(gVar, new LeadingMarginSpan.Standard(safeApplyDimension(displayMetrics, iVar2.E, iVar2.D)));
                                                setBlockSpan(gVar, new com.tencent.android.androidbypass.span.h(g16, safeApplyDimension(displayMetrics, iVar2.A, iVar2.f72210z), safeApplyDimension(displayMetrics, iVar2.C, iVar2.B)));
                                                setSpan(gVar, new RelativeSizeSpan(iVar2.f72209y));
                                                setSpan(gVar, new BypassForegroundColorSpan(g16));
                                                return gVar;
                                            case 15:
                                                setSpan(gVar, new StrikethroughSpan());
                                                return gVar;
                                            case 16:
                                                if (i3 <= 0 || textView == null) {
                                                    return gVar;
                                                }
                                                Element elementIndexInParent3 = element.getElementIndexInParent(i3 - 1);
                                                if (elementIndexInParent3 != null && elementIndexInParent3.type == Element.Type.HRULE) {
                                                    return gVar;
                                                }
                                                setSpanSafely(gVar, 0, 1, new com.tencent.android.androidbypass.span.d(safeApplyDimension(displayMetrics, iVar2.f72177a0, iVar2.Z), 0));
                                                return gVar;
                                            case 17:
                                                CustomElement customElement = element.getCustomElement();
                                                if (customElement == null) {
                                                    return gVar;
                                                }
                                                CustomStyleElement styleElement = customElement.getStyleElement();
                                                String nodeId = styleElement.getNodeId();
                                                String nodeType = styleElement.getNodeType();
                                                String text = styleElement.getText();
                                                HashMap<String, String> attrMap = styleElement.getAttrMap();
                                                if (nodeType.isEmpty() || nodeId.isEmpty() || dVar == null || textView == null) {
                                                    return gVar;
                                                }
                                                dVar.g(textView, gVar, nodeType, nodeId, text, attrMap);
                                                return gVar;
                                            default:
                                                return gVar;
                                        }
                                    }
                                    if (element.parent == null) {
                                        setBlockSpan(gVar, new LeadingMarginSpan.Standard(safeApplyDimension(displayMetrics, iVar2.f72192i, iVar2.f72190h)));
                                        return gVar;
                                    }
                                    setBlockSpan(gVar, new LeadingMarginSpan.Standard(safeApplyDimension(displayMetrics, iVar2.f72195k, iVar2.f72194j)));
                                    return gVar;
                                }
                            } else if (element.type.isBlock()) {
                                if (type == type3) {
                                    Element element4 = element.parent;
                                    if (element4 == null || element4.type != type4) {
                                        gVar.append("\n");
                                    }
                                } else {
                                    Element element5 = element.parent;
                                    str6 = str4;
                                    if (element5 != null && element5.type == type4 && i27 != 0) {
                                        gVar.append("\n");
                                    } else if (element5 == null && gVar.length() > 0) {
                                        c16 = '\n';
                                        if (gVar.charAt(gVar.length() - 1) != '\n') {
                                            gVar.append("\n");
                                        }
                                        if (textView != null) {
                                        }
                                        i19 = iArr[type.ordinal()];
                                        if (i19 != 1) {
                                        }
                                    }
                                }
                            }
                            c16 = '\n';
                            if (textView != null) {
                            }
                            i19 = iArr[type.ordinal()];
                            if (i19 != 1) {
                            }
                        }
                        str6 = str4;
                        c16 = '\n';
                        if (textView != null) {
                        }
                        i19 = iArr[type.ordinal()];
                        if (i19 != 1) {
                        }
                    }
                }
                str = str7;
                String stringAttribute22 = element.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                if (type == Element.Type.IMAGE) {
                }
                str2 = QCircleSchemeAttr.Polymerize.ALT;
                type3 = type2;
                charSequence = concat;
                str3 = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
                str4 = str;
                drawable = null;
                if (textView == null) {
                }
                iArr = d.f71928a;
                switch (iArr[type.ordinal()]) {
                }
                gVar.append((CharSequence) str4);
                gVar.append(charSequence);
                if (i3 >= i16 + (-1)) {
                }
                if (element.parent == null) {
                }
                type4 = Element.Type.LIST_ITEM;
                if (type != type4) {
                }
                c16 = '\n';
                if (textView != null) {
                }
                i19 = iArr[type.ordinal()];
                if (i19 != 1) {
                }
            }
        }
        z16 = false;
        min = Math.min(element.children.size(), this.mMaxElementsCount);
        CharSequence[] charSequenceArr4 = new CharSequence[min];
        i17 = 0;
        while (i17 < min) {
        }
        CharSequence[] charSequenceArr32 = charSequenceArr4;
        type = type8;
        type2 = Element.Type.LIST;
        if (type == type2) {
        }
        CharSequence concat2 = TextUtils.concat(charSequenceArr32);
        g gVar2 = new g();
        Element elementIndexInParent22 = element.getElementIndexInParent(i3 + 1);
        String str72 = element.text;
        if (element.children.size() == 0) {
            type6 = element.type;
            type7 = Element.Type.CODE_SPAN;
            if (type6 != type7) {
                str = "";
                String stringAttribute222 = element.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                if (type == Element.Type.IMAGE) {
                }
                str2 = QCircleSchemeAttr.Polymerize.ALT;
                type3 = type2;
                charSequence = concat2;
                str3 = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
                str4 = str;
                drawable = null;
                if (textView == null) {
                }
                iArr = d.f71928a;
                switch (iArr[type.ordinal()]) {
                }
                gVar2.append((CharSequence) str4);
                gVar2.append(charSequence);
                if (i3 >= i16 + (-1)) {
                }
                if (element.parent == null) {
                }
                type4 = Element.Type.LIST_ITEM;
                if (type != type4) {
                }
                c16 = '\n';
                if (textView != null) {
                }
                i19 = iArr[type.ordinal()];
                if (i19 != 1) {
                }
            }
        }
        str = str72;
        String stringAttribute2222 = element.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        if (type == Element.Type.IMAGE) {
        }
        str2 = QCircleSchemeAttr.Polymerize.ALT;
        type3 = type2;
        charSequence = concat2;
        str3 = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
        str4 = str;
        drawable = null;
        if (textView == null) {
        }
        iArr = d.f71928a;
        switch (iArr[type.ordinal()]) {
        }
        gVar2.append((CharSequence) str4);
        gVar2.append(charSequence);
        if (i3 >= i16 + (-1)) {
        }
        if (element.parent == null) {
        }
        type4 = Element.Type.LIST_ITEM;
        if (type != type4) {
        }
        c16 = '\n';
        if (textView != null) {
        }
        i19 = iArr[type.ordinal()];
        if (i19 != 1) {
        }
    }

    public CharSequence markdownToSpannable(String str, e eVar, TextView textView, i iVar, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, this, str, eVar, textView, iVar, bVar);
        }
        if (textView != null) {
            initParameters(textView.getContext().getApplicationContext());
        }
        Document tryParseAsDocument = tryParseAsDocument(str);
        if (tryParseAsDocument == null) {
            return str;
        }
        if (iVar != null && textView != null) {
            iVar.b(new WeakReference<>(textView));
        }
        int min = Math.min(tryParseAsDocument.getElementCount(), this.mMaxElementsCount);
        CharSequence[] charSequenceArr = new CharSequence[min];
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i3 = 0;
        while (i3 < min) {
            Element element = tryParseAsDocument.getElement(i3);
            element.setDocument(tryParseAsDocument);
            boolean z17 = i3 == min + (-1) ? z16 : false;
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            spannableStringBuilder2.append(recurseElement(element, i3, min, eVar, textView, iVar, Boolean.valueOf(z17), bVar));
            i3++;
            spannableStringBuilder = spannableStringBuilder2;
            z16 = true;
        }
        SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
        if (iVar != null && textView != null) {
            spannableStringBuilder3.setSpan(new com.tencent.android.androidbypass.span.c(safeApplyDimension(textView.getResources().getDisplayMetrics(), iVar.f72182d, iVar.f72180c), textView.getPaint()), 0, spannableStringBuilder3.length(), 33);
        }
        return spannableStringBuilder3;
    }
}
