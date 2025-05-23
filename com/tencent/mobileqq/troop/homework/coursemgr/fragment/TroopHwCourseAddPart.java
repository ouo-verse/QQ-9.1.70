package com.tencent.mobileqq.troop.homework.coursemgr.fragment;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.homework.coursemgr.ui.TroopHwCourseFloatingView;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import h53.QUIInputCountCalculateStrategy;
import h53.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseAddPart;", "Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseBasePart;", "", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/TroopHwCourseFloatingView;", "f", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/TroopHwCourseFloatingView;", "floatingContainer", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "headerAddBtn", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "i", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "addCourseInput", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHwCourseAddPart extends TroopHwCourseBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TroopHwCourseFloatingView floatingContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView headerAddBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineInputView addCourseInput;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseAddPart$a", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements q {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseAddPart.this);
            }
        }

        @Override // h53.q
        public void A4(@Nullable String title) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) title);
            }
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                QUISingleLineInputView qUISingleLineInputView = TroopHwCourseAddPart.this.addCourseInput;
                TextView textView = null;
                if (qUISingleLineInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
                    qUISingleLineInputView = null;
                }
                CharSequence d16 = qUISingleLineInputView.d();
                if (d16 != null && d16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    TextView textView2 = TroopHwCourseAddPart.this.headerAddBtn;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerAddBtn");
                    } else {
                        textView = textView2;
                    }
                    textView.setTextColor(TroopHwCourseAddPart.this.getContext().getColor(R.color.qui_common_text_secondary));
                    return;
                }
                TextView textView3 = TroopHwCourseAddPart.this.headerAddBtn;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerAddBtn");
                } else {
                    textView = textView3;
                }
                textView.setTextColor(TroopHwCourseAddPart.this.getContext().getColor(R.color.qui_common_text_primary));
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) s16);
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // h53.k
        public void f8(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                q.a.a(this, z16);
            }
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    public TroopHwCourseAddPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void L9() {
        LiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> T1 = E9().T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.coursemgr.intent.c, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.coursemgr.intent.c, Unit>() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseAddPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseAddPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.coursemgr.intent.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.coursemgr.intent.c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                if (cVar instanceof com.tencent.mobileqq.troop.homework.coursemgr.intent.a) {
                    com.tencent.mobileqq.troop.homework.coursemgr.intent.a aVar = (com.tencent.mobileqq.troop.homework.coursemgr.intent.a) cVar;
                    if (aVar.b() && aVar.a() == 0) {
                        QQToastUtil.showQQToast(2, TroopHwCourseAddPart.this.getContext().getString(R.string.f23413795));
                        TroopHwCourseAddPart.this.E9().N1();
                    } else {
                        QQToastUtil.showQQToast(1, TroopHwCourseAddPart.this.getContext().getString(R.string.f23412794));
                    }
                }
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopHwCourseAddPart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(TroopHwCourseAddPart this$0, View view) {
        boolean z16;
        CharSequence trim;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.addCourseInput;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
            qUISingleLineInputView = null;
        }
        CharSequence d16 = qUISingleLineInputView.d();
        boolean z17 = false;
        if (d16 != null && d16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QUISingleLineInputView qUISingleLineInputView3 = this$0.addCourseInput;
            if (qUISingleLineInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
            } else {
                qUISingleLineInputView2 = qUISingleLineInputView3;
            }
            trim = StringsKt__StringsKt.trim((CharSequence) String.valueOf(qUISingleLineInputView2.d()));
            String obj = trim.toString();
            if (obj.length() == 0) {
                z17 = true;
            }
            if (z17) {
                QQToastUtil.showQQToast(1, R.string.f2340778z);
            } else {
                this$0.F9();
                this$0.E9().M1(obj);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O9(TroopHwCourseAddPart this$0, TextView textView, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.addCourseInput;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.a();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            A9();
            return;
        }
        View findViewById = rootView.findViewById(R.id.f66743bg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qus_half_screen_view)");
        this.floatingContainer = (TroopHwCourseFloatingView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f102025ws);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026hw_course_header_add_btn)");
        this.headerAddBtn = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f102015wr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026roop_hw_course_add_input)");
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) findViewById3;
        this.addCourseInput = qUISingleLineInputView;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.setCalculateStrategy(new QUIInputCountCalculateStrategy(Double.MAX_VALUE, Double.MAX_VALUE, 1.0d, 1.0d));
        TextView textView = this.headerAddBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerAddBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHwCourseAddPart.N9(TroopHwCourseAddPart.this, view);
            }
        });
        QUISingleLineInputView qUISingleLineInputView3 = this.addCourseInput;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
            qUISingleLineInputView3 = null;
        }
        qUISingleLineInputView3.setInputViewWatcher(new a());
        QUISingleLineInputView qUISingleLineInputView4 = this.addCourseInput;
        if (qUISingleLineInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCourseInput");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView4;
        }
        qUISingleLineInputView2.h().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                boolean O9;
                O9 = TroopHwCourseAddPart.O9(TroopHwCourseAddPart.this, textView2, i3, keyEvent);
                return O9;
            }
        });
        L9();
    }
}
