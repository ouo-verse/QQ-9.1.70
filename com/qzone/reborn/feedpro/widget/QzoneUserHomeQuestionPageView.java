package com.qzone.reborn.feedpro.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import cd.n;
import com.qzone.reborn.feedpro.event.QzoneFeedProShowQuestionEvent;
import com.qzone.reborn.feedpro.utils.p;
import com.qzone.reborn.feedpro.viewmodel.q;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.Questions;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightQuestion;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b8\u00109B\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b8\u0010<J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0014J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0012H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/feedpro/widget/QzoneUserHomeQuestionPageView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", "Lde/b;", "", "D0", "questions", "", "y0", "questionContent", "H0", "z0", "A0", "x0", "G0", "I0", "answerContent", "F0", "", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", com.tencent.luggage.wxa.c8.c.G, "w0", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "questionContainer", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "questionList", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "questionContentTv", "Lcom/qzone/widget/ExtendEditText;", "i", "Lcom/qzone/widget/ExtendEditText;", "editText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "submitBtn", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "iconIv", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "userHomeViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/q;", "E", "Lcom/qzone/reborn/feedpro/viewmodel/q;", "forbiddenViewModel", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneUserHomeQuestionPageView extends QZoneBaseWidgetView<Questions> implements de.b {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView iconIv;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m userHomeViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private q forbiddenViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout questionContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout questionList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView questionContentTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ExtendEditText editText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView submitBtn;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedpro/widget/QzoneUserHomeQuestionPageView$a", "Landroid/text/TextWatcher;", "", "charSequence", "", "i", "i1", "i2", "", "beforeTextChanged", "onTextChanged", "Landroid/text/Editable;", "editable", "afterTextChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            ExtendEditText extendEditText = QzoneUserHomeQuestionPageView.this.editText;
            if ((extendEditText != null ? extendEditText.getText() : null) == null) {
                return;
            }
            QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView = QzoneUserHomeQuestionPageView.this;
            ExtendEditText extendEditText2 = qzoneUserHomeQuestionPageView.editText;
            Intrinsics.checkNotNull(extendEditText2);
            String obj = extendEditText2.getText().toString();
            int length = obj.length() - 1;
            int i3 = 0;
            boolean z16 = false;
            while (i3 <= length) {
                boolean z17 = Intrinsics.compare((int) obj.charAt(!z16 ? i3 : length), 32) <= 0;
                if (z16) {
                    if (!z17) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z17) {
                    i3++;
                } else {
                    z16 = true;
                }
            }
            qzoneUserHomeQuestionPageView.F0(obj.subSequence(i3, length + 1).toString());
            QzoneUserHomeQuestionPageView.this.I0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i26) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i26) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/QzoneUserHomeQuestionPageView$b", "Lcom/qzone/reborn/feedpro/viewmodel/q$d;", "", "isSuccess", "", "errMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements q.d {
        b() {
        }

        @Override // com.qzone.reborn.feedpro.viewmodel.q.d
        public void a(boolean isSuccess, String errMsg) {
            MutableLiveData<Boolean> p26;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (isSuccess) {
                LinearLayout linearLayout = QzoneUserHomeQuestionPageView.this.questionContainer;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                com.qzone.reborn.feedpro.viewmodel.m mVar = QzoneUserHomeQuestionPageView.this.userHomeViewModel;
                if (mVar != null && (p26 = mVar.p2()) != null) {
                    p26.postValue(Boolean.FALSE);
                }
                com.qzone.reborn.feedpro.viewmodel.m mVar2 = QzoneUserHomeQuestionPageView.this.userHomeViewModel;
                if (mVar2 != null) {
                    mVar2.C2();
                }
                com.qzone.reborn.feedpro.viewmodel.m mVar3 = QzoneUserHomeQuestionPageView.this.userHomeViewModel;
                if (mVar3 != null) {
                    mVar3.b2();
                    return;
                }
                return;
            }
            QQToastUtil.showQQToastInUiThread(0, "\u9a8c\u8bc1\u5931\u8d25");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneUserHomeQuestionPageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A0() {
        q qVar = this.forbiddenViewModel;
        if (TextUtils.isEmpty(qVar != null ? qVar.getAnswerContent() : null)) {
            QQToastUtil.showQQToastInUiThread(0, "\u7b54\u6848\u4e0d\u80fd\u4e3a\u7a7a");
            return;
        }
        if (getContext() instanceof Activity) {
            n.Companion companion = cd.n.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            companion.b((Activity) context);
        }
        q qVar2 = this.forbiddenViewModel;
        if (qVar2 != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar = this.userHomeViewModel;
            qVar2.c2(String.valueOf(mVar != null ? Long.valueOf(mVar.getHostUin()) : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(QzoneUserHomeQuestionPageView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QzoneUserHomeQuestionPageView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D0() {
        MutableLiveData<String> R1;
        this.userHomeViewModel = (com.qzone.reborn.feedpro.viewmodel.m) p(com.qzone.reborn.feedpro.viewmodel.m.class);
        q qVar = (q) p(q.class);
        this.forbiddenViewModel = qVar;
        if (qVar != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar = this.userHomeViewModel;
            qVar.U1(mVar != null ? mVar.getUserHomeManager() : null);
        }
        q qVar2 = this.forbiddenViewModel;
        if (qVar2 != null) {
            qVar2.b2(new b());
        }
        q qVar3 = this.forbiddenViewModel;
        if (qVar3 == null || (R1 = qVar3.R1()) == null) {
            return;
        }
        BasePartFragment l06 = l0();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.feedpro.widget.QzoneUserHomeQuestionPageView$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView = QzoneUserHomeQuestionPageView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qzoneUserHomeQuestionPageView.H0(it);
            }
        };
        R1.observe(l06, new Observer() { // from class: com.qzone.reborn.feedpro.widget.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneUserHomeQuestionPageView.E0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(String answerContent) {
        q qVar = this.forbiddenViewModel;
        if (qVar == null) {
            return;
        }
        qVar.W1(answerContent);
    }

    private final void G0(Questions questions) {
        if (p.x(questions).size() <= 1) {
            ImageView imageView = this.iconIv;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.iconIv;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(String questionContent) {
        MutableLiveData<String> R1;
        TextView textView = this.questionContentTv;
        if (textView != null) {
            textView.setText(getContext().getResources().getString(R.string.f22011689) + questionContent);
        }
        q qVar = this.forbiddenViewModel;
        if (qVar == null || (R1 = qVar.R1()) == null) {
            return;
        }
        R1.postValue(questionContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        q qVar = this.forbiddenViewModel;
        if (TextUtils.isEmpty(qVar != null ? qVar.getAnswerContent() : null)) {
            TextView textView = this.submitBtn;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_button_text_secondary_disable));
            }
            TextView textView2 = this.submitBtn;
            if (textView2 == null) {
                return;
            }
            textView2.setBackground(getContext().getResources().getDrawable(R.drawable.f14662r));
            return;
        }
        TextView textView3 = this.submitBtn;
        if (textView3 != null) {
            textView3.setTextColor(getContext().getColor(R.color.qui_button_text_secondary_default));
        }
        TextView textView4 = this.submitBtn;
        if (textView4 == null) {
            return;
        }
        textView4.setBackground(getContext().getResources().getDrawable(R.drawable.f14652q));
    }

    private final void x0() {
        ExtendEditText extendEditText = this.editText;
        if (extendEditText == null || extendEditText == null) {
            return;
        }
        extendEditText.addTextChangedListener(new a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        if ((r0.length() > 0) == true) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String y0(Questions questions) {
        boolean z16;
        String str;
        String str2;
        QzoneRightQuestion qzoneRightQuestion = questions.question1;
        boolean z17 = true;
        if (qzoneRightQuestion != null && (str2 = qzoneRightQuestion.question) != null) {
            if (str2.length() > 0) {
                z16 = true;
                if (!z16) {
                    QzoneRightQuestion qzoneRightQuestion2 = questions.question1;
                    Intrinsics.checkNotNull(qzoneRightQuestion2);
                    String str3 = qzoneRightQuestion2.question;
                    Intrinsics.checkNotNull(str3);
                    return str3;
                }
                QzoneRightQuestion qzoneRightQuestion3 = questions.question2;
                if (qzoneRightQuestion3 != null && (r0 = qzoneRightQuestion3.question) != null) {
                }
                z17 = false;
                if (z17) {
                    QzoneRightQuestion qzoneRightQuestion4 = questions.question2;
                    Intrinsics.checkNotNull(qzoneRightQuestion4);
                    String str4 = qzoneRightQuestion4.question;
                    Intrinsics.checkNotNull(str4);
                    return str4;
                }
                QzoneRightQuestion qzoneRightQuestion5 = questions.question3;
                return (qzoneRightQuestion5 == null || (str = qzoneRightQuestion5.question) == null) ? "" : str;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final void z0() {
        Questions questions;
        q qVar = this.forbiddenViewModel;
        if (qVar == null || (questions = qVar.getQuestions()) == null || p.x(questions).size() <= 1) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProShowQuestionEvent());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1302085;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        super.initView(context, viewType);
        registerIoc(this, de.b.class);
        this.questionContainer = (LinearLayout) findViewById(R.id.cao);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.cfb);
        this.questionList = frameLayout;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneUserHomeQuestionPageView.B0(QzoneUserHomeQuestionPageView.this, view);
                }
            });
        }
        this.questionContentTv = (TextView) findViewById(R.id.bqd);
        this.iconIv = (ImageView) findViewById(R.id.cdk);
        this.editText = (ExtendEditText) findViewById(R.id.cbx);
        TextView textView = (TextView) findViewById(R.id.cld);
        this.submitBtn = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneUserHomeQuestionPageView.C0(QzoneUserHomeQuestionPageView.this, view);
                }
            });
        }
        x0();
        D0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneUserHomeQuestionPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void bindData(Questions questions, int pos) {
        if (questions != null) {
            q qVar = this.forbiddenViewModel;
            if (qVar != null) {
                qVar.a2(questions);
            }
            H0(y0(questions));
            G0(questions);
        }
    }
}
