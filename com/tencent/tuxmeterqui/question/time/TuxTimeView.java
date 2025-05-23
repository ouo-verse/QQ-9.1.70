package com.tencent.tuxmeterqui.question.time;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import com.tencent.tuxmeterqui.timepicker.TuxDatePickerDialog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\rJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\u0010J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\nH\u0016J&\u0010.\u001a\u00020\"2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tencent/tuxmeterqui/question/time/TuxTimeView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/tuxmeterqui/question/ITuxQuestionView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "answerTime", "", "fromTime", "onTimeChangeListener", "Lcom/tencent/tuxmeterqui/question/time/TuxTimeView$OnTimeChangeListener;", "question", "Lcom/tencent/tuxmetersdk/model/Question;", "textQuestionChevronDown", "Landroid/widget/ImageView;", "timeQuestionContent", "Landroid/widget/TextView;", "timeQuestionDesc", "timeQuestionRequired", "timeQuestionTitle", "timeStyle", "toTime", "getAnswerTime", "getQuestion", "getUTCOffsetString", "hasAnsweredInRequired", "", "parseRenderStyle", "", "selfConversionTime", "time", "", "setOnTimeChangeListener", "listener", "setViewVisibility", NodeProps.VISIBLE, "showTimeSelector", "updateLayoutOrViews", "updateQuestionNumber", "number", VasPerfReportUtils.WHILE_UPDATE_ITEM, "resource", "Lcom/tencent/tuxmetersdk/model/Resource;", "questionConfig", "Lcom/tencent/tuxmeterqui/config/TuxQuestionConfig;", "Companion", "OnTimeChangeListener", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TuxTimeView extends FrameLayout implements ITuxQuestionView {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TUX_TIME_STYLE = "time_style";

    @NotNull
    public static final String TUX_TIME_STYLE_DATE = "date";

    @NotNull
    public static final String TUX_TIME_STYLE_FROM_TIME = "from_time";

    @NotNull
    public static final String TUX_TIME_STYLE_MINUTES = "minutes";

    @NotNull
    public static final String TUX_TIME_STYLE_TIME = "time";

    @NotNull
    public static final String TUX_TIME_STYLE_TO_TIME = "to_time";

    @NotNull
    private String answerTime;

    @NotNull
    private String fromTime;

    @Nullable
    private OnTimeChangeListener onTimeChangeListener;

    @Nullable
    private Question question;

    @Nullable
    private ImageView textQuestionChevronDown;

    @Nullable
    private TextView timeQuestionContent;

    @Nullable
    private TextView timeQuestionDesc;

    @Nullable
    private TextView timeQuestionRequired;

    @Nullable
    private TextView timeQuestionTitle;

    @NotNull
    private String timeStyle;

    @NotNull
    private String toTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tuxmeterqui/question/time/TuxTimeView$Companion;", "", "()V", "TUX_TIME_STYLE", "", "TUX_TIME_STYLE_DATE", "TUX_TIME_STYLE_FROM_TIME", "TUX_TIME_STYLE_MINUTES", "TUX_TIME_STYLE_TIME", "TUX_TIME_STYLE_TO_TIME", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/tuxmeterqui/question/time/TuxTimeView$OnTimeChangeListener;", "", "onTimeChange", "", "text", "", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface OnTimeChangeListener {
        void onTimeChange(@NotNull String text);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7557);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ TuxTimeView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(TuxTimeView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showTimeSelector();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(TuxTimeView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showTimeSelector();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void parseRenderStyle() {
        String style;
        try {
            Question question = this.question;
            if (question != null && (style = question.getStyle()) != null) {
                JSONObject jSONObject = new JSONObject(style);
                String optString = jSONObject.optString(TUX_TIME_STYLE, "time");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(TUX\u2026YLE, TUX_TIME_STYLE_TIME)");
                this.timeStyle = optString;
                String optString2 = jSONObject.optString(TUX_TIME_STYLE_FROM_TIME);
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(TUX_TIME_STYLE_FROM_TIME)");
                this.fromTime = optString2;
                String optString3 = jSONObject.optString(TUX_TIME_STYLE_TO_TIME);
                Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(TUX_TIME_STYLE_TO_TIME)");
                this.toTime = optString3;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String selfConversionTime(long time) {
        TuxDateStringUtils tuxDateStringUtils = TuxDateStringUtils.INSTANCE;
        return tuxDateStringUtils.conversionTime(time, tuxDateStringUtils.getDateFormat(this.timeStyle));
    }

    private final void showTimeSelector() {
        boolean isBlank;
        boolean isBlank2;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        TuxDatePickerDialog.Builder onChoose = new TuxDatePickerDialog.Builder(context).setOnChoose(new Function1<Long, Unit>() { // from class: com.tencent.tuxmeterqui.question.time.TuxTimeView$showTimeSelector$builder$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxTimeView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                String selfConversionTime;
                TuxTimeView.OnTimeChangeListener onTimeChangeListener;
                TextView textView;
                String str;
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, j3);
                    return;
                }
                TuxTimeView tuxTimeView = TuxTimeView.this;
                selfConversionTime = tuxTimeView.selfConversionTime(j3);
                tuxTimeView.answerTime = selfConversionTime;
                onTimeChangeListener = TuxTimeView.this.onTimeChangeListener;
                if (onTimeChangeListener != null) {
                    str2 = TuxTimeView.this.answerTime;
                    onTimeChangeListener.onTimeChange(str2);
                }
                textView = TuxTimeView.this.timeQuestionContent;
                if (textView == null) {
                    return;
                }
                str = TuxTimeView.this.answerTime;
                textView.setText(str);
            }
        });
        TuxDateStringUtils tuxDateStringUtils = TuxDateStringUtils.INSTANCE;
        onChoose.displayTypes = tuxDateStringUtils.getTimeDisplays(this.timeStyle);
        isBlank = StringsKt__StringsJVMKt.isBlank(this.fromTime);
        if (!isBlank) {
            long conversionTime$default = TuxDateStringUtils.conversionTime$default(tuxDateStringUtils, this.fromTime, (String) null, 2, (Object) null);
            if (conversionTime$default > 0) {
                onChoose.minTime = conversionTime$default;
            }
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(this.toTime);
        if (!isBlank2) {
            long conversionTime$default2 = TuxDateStringUtils.conversionTime$default(tuxDateStringUtils, this.toTime, (String) null, 2, (Object) null);
            if (conversionTime$default2 > 0) {
                onChoose.maxTime = conversionTime$default2;
            }
        }
        onChoose.build().show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isRequired() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateLayoutOrViews() {
        boolean z16;
        String title;
        TextView textView;
        Question question = this.question;
        if (question != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            TextView textView2 = this.timeQuestionRequired;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            TextView textView3 = this.timeQuestionRequired;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        Question question2 = this.question;
        if (question2 != null && (title = question2.getTitle()) != null && (textView = this.timeQuestionTitle) != null) {
            textView.setText(title);
        }
        if (Intrinsics.areEqual("date", this.timeStyle)) {
            TextView textView4 = this.timeQuestionContent;
            if (textView4 != null) {
                textView4.setText(R.string.f236857fh);
                return;
            }
            return;
        }
        TextView textView5 = this.timeQuestionContent;
        if (textView5 != null) {
            textView5.setText(R.string.f237017fx);
        }
    }

    @NotNull
    public final String getAnswerTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return TuxDateStringUtils.INSTANCE.formatDateTimeWith00(this.answerTime);
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    @Nullable
    public Question getQuestion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Question) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.question;
    }

    @NotNull
    public final String getUTCOffsetString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return String.valueOf(TimeZone.getDefault().getRawOffset() / 3600000);
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public boolean hasAnsweredInRequired() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Question question = this.question;
        boolean z16 = false;
        if (question != null && !question.isRequired()) {
            z16 = true;
        }
        if (!z16) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.answerTime);
            return !isBlank;
        }
        return true;
    }

    public final void setOnTimeChangeListener(@Nullable OnTimeChangeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            this.onTimeChangeListener = listener;
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void setViewVisibility(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, visible);
            return;
        }
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateQuestionNumber(int number) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, number);
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateView(@Nullable Question question, @Nullable Resource resource, @Nullable TuxQuestionConfig questionConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, question, resource, questionConfig);
            return;
        }
        this.question = question;
        setTag(question);
        if (question != null) {
            parseRenderStyle();
            updateLayoutOrViews();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TuxTimeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.timeStyle = "";
        this.fromTime = "";
        this.toTime = "";
        this.answerTime = "";
        View inflate = LayoutInflater.from(context).inflate(R.layout.i1x, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026on_time_view, this, true)");
        this.timeQuestionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.timeQuestionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        TextView textView = (TextView) inflate.findViewById(R.id.f10441639);
        this.timeQuestionDesc = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.timeQuestionContent = (TextView) inflate.findViewById(R.id.f1050264w);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f1050164v);
        this.textQuestionChevronDown = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.tuxmeterqui.question.time.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TuxTimeView._init_$lambda$0(TuxTimeView.this, view);
                }
            });
        }
        TextView textView2 = this.timeQuestionContent;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.tuxmeterqui.question.time.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TuxTimeView._init_$lambda$1(TuxTimeView.this, view);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TuxTimeView(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TuxTimeView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }
}
