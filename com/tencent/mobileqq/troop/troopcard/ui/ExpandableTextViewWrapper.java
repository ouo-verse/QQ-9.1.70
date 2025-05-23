package com.tencent.mobileqq.troop.troopcard.ui;

import android.animation.ValueAnimator;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u0000 D2\u00020\u0001:\u0003\u0016\u0019SB?\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u0010%\u001a\u00020\"\u0012\b\b\u0002\u0010)\u001a\u00020&\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J(\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R*\u0010\u0003\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00101\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00104R\"\u0010;\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010H\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u001a\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u001a\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\u0016\u0010M\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010LR$\u0010P\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bN\u0010E\"\u0004\bO\u0010G\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper;", "", "Lcom/tencent/mobileqq/text/QQText;", "text", "", ReportConstant.COSTREPORT_PREFIX, "l", tl.h.F, "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qqText", "", "endPosition", "startPosition", "", "endStringWith", "r", "k", "Landroid/text/DynamicLayout;", "j", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "textView", "b", "I", "minLines", "", "c", "Ljava/lang/String;", "expandString", "d", "contractString", "Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$Status;", "e", "Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$Status;", "status", "Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$b;", "f", "Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$b;", "qqTextConfig", "value", "g", "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "t", "(Ljava/lang/CharSequence;)V", "currentShowLines", "i", "textLines", "Lcom/tencent/mobileqq/text/QQText;", "", "Z", "getNeedAnimation", "()Z", "setNeedAnimation", "(Z)V", "needAnimation", "", "J", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "()I", "setExpandStringColor", "(I)V", "expandStringColor", DomainData.DOMAIN_NAME, "setContractStringColor", "contractStringColor", "Landroid/text/DynamicLayout;", "dynamicLayout", "getVisibility", "u", "visibility", "<init>", "(Landroid/widget/TextView;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$Status;Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$b;)V", "Status", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ExpandableTextViewWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final a f299866p;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int minLines;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String expandString;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String contractString;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Status status;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b qqTextConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence text;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentShowLines;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int textLines;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQText qqText;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean needAnimation;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long animationDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int expandStringColor;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int contractStringColor;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DynamicLayout dynamicLayout;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$Status;", "", "(Ljava/lang/String;I)V", "Expand", "Contract", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class Status {
        private static final /* synthetic */ Status[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Status Contract;
        public static final Status Expand;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Expand, Contract};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57402);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Expand = new Status("Expand", 0);
            Contract = new Status("Contract", 1);
            $VALUES = $values();
        }

        Status(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$a;", "", "", "SPACE", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$b;", "", "", "a", "I", "b", "()I", "flag", "emoSize", "<init>", "(II)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int flag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int emoSize;

        public b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.flag = i3;
                this.emoSize = i16;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.emoSize;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.flag;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends ClickableSpan {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpandableTextViewWrapper.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            ExpandableTextViewWrapper.this.status = Status.Expand;
            ExpandableTextViewWrapper.this.l();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ExpandableTextViewWrapper.this.n());
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper$d", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends ClickableSpan {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpandableTextViewWrapper.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            ExpandableTextViewWrapper.this.status = Status.Contract;
            ExpandableTextViewWrapper.this.h();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setColor(ExpandableTextViewWrapper.this.p());
            ds5.setUnderlineText(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f299866p = new a(null);
        }
    }

    public ExpandableTextViewWrapper(@NotNull TextView textView, int i3, @NotNull String expandString, @NotNull String contractString, @NotNull Status status, @NotNull b qqTextConfig) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(expandString, "expandString");
        Intrinsics.checkNotNullParameter(contractString, "contractString");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(qqTextConfig, "qqTextConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, textView, Integer.valueOf(i3), expandString, contractString, status, qqTextConfig);
            return;
        }
        this.textView = textView;
        this.minLines = i3;
        this.expandString = expandString;
        this.contractString = contractString;
        this.status = status;
        this.qqTextConfig = qqTextConfig;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        this.text = "";
        this.currentShowLines = i3;
        this.qqText = k("");
        this.animationDuration = 200L;
        this.expandStringColor = textView.getContext().getColorStateList(R.color.qui_common_text_link).getDefaultColor();
        this.contractStringColor = textView.getContext().getColorStateList(R.color.qui_common_text_link).getDefaultColor();
        this.dynamicLayout = j(k(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ExpandableTextViewWrapper this$0, CharSequence value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(value, "$value");
        this$0.t(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.needAnimation) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(this.animationDuration);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.ui.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ExpandableTextViewWrapper.i(ExpandableTextViewWrapper.this, valueAnimator);
                }
            });
            ofFloat.start();
            return;
        }
        this.currentShowLines = this.minLines;
        s(this.qqText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ExpandableTextViewWrapper this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        int i3 = this$0.minLines + ((int) ((this$0.textLines - r0) * (1 - floatValue)));
        if (this$0.currentShowLines != i3) {
            this$0.currentShowLines = i3;
            this$0.s(this$0.qqText);
        }
    }

    private final DynamicLayout j(QQText text) {
        return new DynamicLayout(text, this.textView.getPaint(), (this.textView.getWidth() - this.textView.getPaddingLeft()) - this.textView.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private final QQText k(CharSequence text) {
        return new QQText(text, this.qqTextConfig.b(), this.qqTextConfig.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        if (this.needAnimation) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(this.animationDuration);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.ui.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ExpandableTextViewWrapper.m(ExpandableTextViewWrapper.this, valueAnimator);
                }
            });
            ofFloat.start();
            return;
        }
        this.currentShowLines = this.textLines;
        s(this.qqText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ExpandableTextViewWrapper this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        int i3 = this$0.minLines + ((int) ((this$0.textLines - r0) * floatValue));
        if (this$0.currentShowLines != i3) {
            this$0.currentShowLines = i3;
            this$0.s(this$0.qqText);
        }
    }

    private final CharSequence o() {
        return "... " + this.expandString;
    }

    private final CharSequence q() {
        if (this.dynamicLayout.getLineWidth(this.textLines - 1) + this.textView.getPaint().measureText(" ") + this.textView.getPaint().measureText(this.contractString) < this.textView.getWidth()) {
            return " " + this.contractString + " ";
        }
        return "\n" + this.contractString + " ";
    }

    private final int r(QQText qqText, int endPosition, int startPosition, float endStringWith) {
        boolean z16;
        boolean z17;
        Object[] spans = qqText.getSpans(startPosition, endPosition, Object.class);
        int i3 = endPosition;
        while (true) {
            if (startPosition <= i3 && i3 <= endPosition) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                break;
            }
            if (spans != null) {
                int length = spans.length - 1;
                while (true) {
                    if (length <= 0) {
                        break;
                    }
                    int spanStart = qqText.getSpanStart(spans[length]);
                    int spanEnd = qqText.getSpanEnd(spans[length]);
                    if (spanStart <= i3 && i3 < spanEnd) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        i3 = spanStart;
                        break;
                    }
                    length--;
                }
            }
            if (i3 <= startPosition || j(k(qqText.mSource.subSequence(startPosition, i3))).getLineWidth(0) + endStringWith < this.textView.getWidth()) {
                break;
            }
            i3--;
        }
        return i3;
    }

    private final void s(QQText text) {
        int i3;
        boolean endsWith$default;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i16 = this.textLines;
        if (i16 <= this.minLines) {
            this.textView.setText(text);
            return;
        }
        if (this.status == Status.Contract && i16 > (i3 = this.currentShowLines)) {
            int i17 = i3 - 1;
            int lineEnd = this.dynamicLayout.getLineEnd(i17);
            int lineStart = this.dynamicLayout.getLineStart(i17);
            CharSequence o16 = o();
            CharSequence subSequence = text.mSource.subSequence(0, r(text, lineEnd, lineStart, this.textView.getPaint().measureText(o16.toString())));
            endsWith$default = StringsKt__StringsKt.endsWith$default(subSequence, (CharSequence) "\n", false, 2, (Object) null);
            if (endsWith$default) {
                subSequence = subSequence.subSequence(0, subSequence.length() - 1).toString();
            }
            spannableStringBuilder.append((CharSequence) k(subSequence)).append(o16);
            spannableStringBuilder.setSpan(new c(), spannableStringBuilder.length() - this.expandString.length(), spannableStringBuilder.length(), 17);
        } else {
            spannableStringBuilder.append((CharSequence) text).append(q());
            spannableStringBuilder.setSpan(new d(), (spannableStringBuilder.length() - this.contractString.length()) - 1, spannableStringBuilder.length() - 1, 17);
        }
        this.textView.setText(spannableStringBuilder);
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.contractStringColor;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.expandStringColor;
    }

    public final void t(@NotNull final CharSequence value) {
        CharSequence trimEnd;
        CharSequence trimEnd2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.textView.getWidth() > 0) {
            trimEnd = StringsKt__StringsKt.trimEnd(value, '\n');
            trimEnd2 = StringsKt__StringsKt.trimEnd(trimEnd);
            this.text = trimEnd2;
            QQText k3 = k(trimEnd2);
            this.qqText = k3;
            DynamicLayout j3 = j(k3);
            this.dynamicLayout = j3;
            this.textLines = j3.getLineCount();
            s(this.qqText);
            return;
        }
        this.textView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                ExpandableTextViewWrapper.d(ExpandableTextViewWrapper.this, value);
            }
        });
    }

    public final void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.textView.setVisibility(i3);
        }
    }

    public /* synthetic */ ExpandableTextViewWrapper(TextView textView, int i3, String str, String str2, Status status, b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(textView, i3, (i16 & 4) != 0 ? "\u5c55\u5f00" : str, (i16 & 8) != 0 ? "\u6536\u8d77" : str2, (i16 & 16) != 0 ? Status.Contract : status, (i16 & 32) != 0 ? new b(11, 16) : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), str, str2, status, bVar, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
