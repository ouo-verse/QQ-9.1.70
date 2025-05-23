package com.tencent.mobileqq.matchfriend.reborn.register.part;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterBottomPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "D9", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lv82/a;", "d", "Lv82/a;", "viewModel", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "F9", "()Landroid/widget/Button;", "setBtn", "(Landroid/widget/Button;)V", "btn", "", "f", "Z", "isBtnEnable", "()Z", "setBtnEnable", "(Z)V", "<init>", "(Lv82/a;)V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerRegisterBottomPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final v82.a viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Button btn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isBtnEnable;

    public QQStrangerRegisterBottomPart(v82.a viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.isBtnEnable = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(QQStrangerRegisterBottomPart this$0, String elemId, View view) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        this$0.viewModel.N1().postValue(Boolean.valueOf(this$0.isBtnEnable));
        if (Intrinsics.areEqual(elemId, "em_bas_the_next_button")) {
            hashMap = new HashMap();
            hashMap.put("zplan_is_avatar", Integer.valueOf(Intrinsics.areEqual(this$0.viewModel.getIsZplanHead(), Boolean.TRUE) ? 1 : 0));
        } else {
            hashMap = null;
        }
        y82.a.b().e(this$0.btn, elemId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* renamed from: F9, reason: from getter */
    public final Button getBtn() {
        return this.btn;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQStrangerRegisterBottomPart";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        this.isBtnEnable = false;
        Button button = this.btn;
        if (button != null) {
            button.setBackgroundResource(com.tencent.mobileqq.matchfriend.reborn.utils.b.f245467a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        this.isBtnEnable = true;
        Button button = this.btn;
        if (button != null) {
            button.setBackgroundResource(com.tencent.mobileqq.matchfriend.reborn.utils.b.f245467a.b());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        final String str;
        this.btn = rootView != null ? (Button) rootView.findViewById(R.id.oiy) : null;
        if (this.viewModel instanceof v82.b) {
            str = "em_bas_the_next_button";
        } else {
            str = "em_bas_enter_expanded";
        }
        y82.a.b().f(this.btn, str);
        Button button = this.btn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQStrangerRegisterBottomPart.G9(QQStrangerRegisterBottomPart.this, str, view);
                }
            });
        }
        Button button2 = this.btn;
        if (button2 != null) {
            button2.setTextColor(getContext().getResources().getColorStateList(R.color.qui_button_text_primary));
        }
        Button button3 = this.btn;
        if (button3 != null) {
            button3.setBackgroundResource(com.tencent.mobileqq.matchfriend.reborn.utils.b.f245467a.b());
        }
        Activity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            MutableLiveData<String> O1 = this.viewModel.O1();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterBottomPart$onInitView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    Button btn = QQStrangerRegisterBottomPart.this.getBtn();
                    if (btn == null) {
                        return;
                    }
                    btn.setText(str2);
                }
            };
            O1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQStrangerRegisterBottomPart.H9(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> S1 = this.viewModel.S1();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterBottomPart$onInitView$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        QQStrangerRegisterBottomPart.this.D9();
                    } else {
                        QQStrangerRegisterBottomPart.this.E9();
                    }
                }
            };
            S1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQStrangerRegisterBottomPart.I9(Function1.this, obj);
                }
            });
        }
    }
}
