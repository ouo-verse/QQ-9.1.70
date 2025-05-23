package com.tencent.mobileqq.search.voicesearch;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010 R\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 \u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchAdaptiveSizeTextView;", "Landroid/widget/FrameLayout;", "", "l", "k", "", "text", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "d", "", "f", "e", DomainData.DOMAIN_NAME, "g", "", "j", "Lcom/tencent/mobileqq/search/voicesearch/c;", "listener", "setTypewriterEffectListener", tl.h.F, "setPrompt", "from", "setTextWithTypeWriterEffect", "setTextWithoutEffects", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "singleLineTextView", "doubleLineTextView", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "typewriterEffectTimer", "Ljava/lang/String;", "mText", "mPrompt", "ELLIPSIS", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class VoiceSearchAdaptiveSizeTextView extends FrameLayout {

    @NotNull
    private static final String D = "VoiceSearchAdaptiveSizeTextView";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView singleLineTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView doubleLineTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer typewriterEffectTimer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mPrompt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ELLIPSIS;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/voicesearch/VoiceSearchAdaptiveSizeTextView$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f285189a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ VoiceSearchAdaptiveSizeTextView f285190b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, Ref.ObjectRef<String> objectRef, VoiceSearchAdaptiveSizeTextView voiceSearchAdaptiveSizeTextView, long j16) {
            super(j16, j3);
            this.f285189a = objectRef;
            this.f285190b = voiceSearchAdaptiveSizeTextView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            C11734b c11734b = C11734b.f433780a;
            QLog.i("Guild.component." + VoiceSearchAdaptiveSizeTextView.D, 1, "onFinish", null);
            VoiceSearchAdaptiveSizeTextView.b(this.f285190b);
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.String] */
        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            boolean z16;
            String take;
            String take2;
            ?? drop;
            if (this.f285189a.element.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                C11734b c11734b = C11734b.f433780a;
                String str = VoiceSearchAdaptiveSizeTextView.D;
                take = StringsKt___StringsKt.take(this.f285189a.element, 1);
                QLog.i("Guild.component." + str, 1, "onTick: appendText:" + take, null);
                VoiceSearchAdaptiveSizeTextView voiceSearchAdaptiveSizeTextView = this.f285190b;
                take2 = StringsKt___StringsKt.take(this.f285189a.element, 1);
                voiceSearchAdaptiveSizeTextView.d(take2);
                Ref.ObjectRef<String> objectRef = this.f285189a;
                drop = StringsKt___StringsKt.drop(objectRef.element, 1);
                objectRef.element = drop;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceSearchAdaptiveSizeTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ c b(VoiceSearchAdaptiveSizeTextView voiceSearchAdaptiveSizeTextView) {
        voiceSearchAdaptiveSizeTextView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String text) {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "appendText called! text=" + text, null);
        this.mText = this.mText + text;
        if (j()) {
            k();
        } else {
            l();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e(String text) {
        boolean z16;
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        CountDownTimer countDownTimer = this.typewriterEffectTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = text;
        long f16 = f(text);
        b bVar = new b(f16, objectRef, this, f16 * ((String) objectRef.element).length());
        this.typewriterEffectTimer = bVar;
        bVar.start();
    }

    private final long f(String text) {
        return Math.min(300 / text.length(), 80);
    }

    private final String g(String text) {
        boolean endsWith$default;
        String take;
        boolean endsWith$default2;
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) text, '.', false, 2, (Object) null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsKt.endsWith$default((CharSequence) text, '\u3002', false, 2, (Object) null);
            if (!endsWith$default2) {
                return text;
            }
        }
        take = StringsKt___StringsKt.take(text, text.length() - 1);
        return take;
    }

    private final void i(String text) {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "setText called! text=" + text, null);
        this.mText = text;
        if (j()) {
            k();
        } else {
            l();
        }
    }

    private final boolean j() {
        int width = (this.singleLineTextView.getWidth() - this.singleLineTextView.getPaddingLeft()) - this.singleLineTextView.getPaddingRight();
        float measureText = this.singleLineTextView.getPaint().measureText(this.mText);
        if (width <= 0 || measureText < width) {
            return false;
        }
        return true;
    }

    private final void k() {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "showDoubleLineText called!", null);
        this.doubleLineTextView.setText(m(this.mText));
        this.singleLineTextView.setVisibility(4);
        this.doubleLineTextView.setVisibility(0);
    }

    private final void l() {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "showSingleLineText called!", null);
        this.singleLineTextView.setText(this.mText);
        this.singleLineTextView.setVisibility(0);
        this.doubleLineTextView.setVisibility(4);
    }

    private final String m(String text) {
        String drop;
        float width = ((this.doubleLineTextView.getWidth() - this.doubleLineTextView.getPaddingLeft()) - this.doubleLineTextView.getPaddingRight()) * 2;
        if (this.doubleLineTextView.getPaint().measureText(text) < width) {
            return text;
        }
        float measureText = width - this.doubleLineTextView.getPaint().measureText(this.ELLIPSIS);
        int length = text.length();
        for (int i3 = 0; i3 < length; i3++) {
            drop = StringsKt___StringsKt.drop(text, i3);
            if (this.doubleLineTextView.getPaint().measureText(drop) <= measureText) {
                return this.ELLIPSIS + drop;
            }
        }
        return text;
    }

    private final String n(String text) {
        String take;
        String drop;
        take = StringsKt___StringsKt.take(text, this.mText.length());
        i(take);
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "updateShowingText called! textToReplace=" + take, null);
        drop = StringsKt___StringsKt.drop(text, this.mText.length());
        return drop;
    }

    public final void h() {
        CountDownTimer countDownTimer = this.typewriterEffectTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        i("");
    }

    public final void setPrompt(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "setPrompt called! text=" + text, null);
        this.mPrompt = text;
        this.mText = "";
        this.singleLineTextView.setText(text);
        this.singleLineTextView.setVisibility(0);
        this.doubleLineTextView.setText(this.mText);
        this.doubleLineTextView.setVisibility(4);
    }

    public final void setTextWithTypeWriterEffect(@NotNull String text, @NotNull String from) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(from, "from");
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "setTextWithTypeWriterEffect called! currentText=" + this.mText + ", text=" + text + ", from=" + from, null);
        e(n(g(text)));
    }

    public final void setTextWithoutEffects(@NotNull String text, @NotNull String from) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(from, "from");
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component." + D, 1, "setTextWithoutEffects called! currentText=" + this.mText + ", text=" + text + ", from=" + from, null);
        CountDownTimer countDownTimer = this.typewriterEffectTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        i(text);
    }

    public final void setTypewriterEffectListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceSearchAdaptiveSizeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceSearchAdaptiveSizeTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceSearchAdaptiveSizeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mText = "";
        this.mPrompt = "";
        this.ELLIPSIS = MiniBoxNoticeInfo.APPNAME_SUFFIX;
        LayoutInflater.from(context).inflate(R.layout.h3k, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f1201578s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.voice_\u2026rch_single_line_textview)");
        this.singleLineTextView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f1201478r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.voice_\u2026rch_double_line_textview)");
        this.doubleLineTextView = (TextView) findViewById2;
        FontSettingManager.resetViewSize2Normal(context, this.singleLineTextView);
        FontSettingManager.resetViewSize2Normal(context, this.doubleLineTextView);
        l();
    }
}
