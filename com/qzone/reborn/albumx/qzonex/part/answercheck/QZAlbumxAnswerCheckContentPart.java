package com.qzone.reborn.albumx.qzonex.part.answercheck;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.qzone.reborn.base.k;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.g;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/answercheck/QZAlbumxAnswerCheckContentPart;", "Lcom/qzone/reborn/base/k;", "", "M9", "Lnc/g;", "H9", "", "result", "K9", "Q9", "L9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "d", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "I9", "()Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "R9", "(Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;)V", "inputView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "J9", "()Landroid/widget/TextView;", "S9", "(Landroid/widget/TextView;)V", "questionTv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAnswerCheckContentPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public QUISingleLineInputView inputView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView questionTv;

    /* JADX INFO: Access modifiers changed from: private */
    public final g H9() {
        return (g) getViewModel(g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(int result) {
        QZAlbumxAnswerCheckPageInitBean answerPageInitBean;
        QLog.i(getTAG(), 1, "verify: " + result);
        g H9 = H9();
        if (!((H9 == null || (answerPageInitBean = H9.getAnswerPageInitBean()) == null || answerPageInitBean.getFromType() != 1) ? false : true)) {
            Q9(result);
        } else if (result != 0) {
            L9();
        }
    }

    private final void L9() {
        QZAlbumxAnswerCheckPageInitBean answerPageInitBean;
        g H9 = H9();
        Object jumpExtData = (H9 == null || (answerPageInitBean = H9.getAnswerPageInitBean()) == null) ? null : answerPageInitBean.getJumpExtData();
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = jumpExtData instanceof QZAlbumxAlbumDetailInitBean ? (QZAlbumxAlbumDetailInitBean) jumpExtData : null;
        if (qZAlbumxAlbumDetailInitBean != null) {
            vb.b x16 = i.x();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            x16.g(activity, qZAlbumxAlbumDetailInitBean);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void M9() {
        MutableLiveData<Integer> W1;
        MutableLiveData<Integer> T1;
        MutableLiveData<String> U1;
        g H9 = H9();
        if (H9 != null && (U1 = H9.U1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.QZAlbumxAnswerCheckContentPart$onInitData$1
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
                public final void invoke2(String str) {
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    QZAlbumxAnswerCheckContentPart.this.J9().setText(l.a(R.string.f134288e) + str);
                }
            };
            U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAnswerCheckContentPart.N9(Function1.this, obj);
                }
            });
        }
        g H92 = H9();
        if (H92 != null && (T1 = H92.T1()) != null) {
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.QZAlbumxAnswerCheckContentPart$onInitData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    g H93;
                    g H94;
                    String str;
                    MutableLiveData<String> U12;
                    H93 = QZAlbumxAnswerCheckContentPart.this.H9();
                    if (H93 != null) {
                        String obj = QZAlbumxAnswerCheckContentPart.this.I9().h().getText().toString();
                        H94 = QZAlbumxAnswerCheckContentPart.this.H9();
                        if (H94 == null || (U12 = H94.U1()) == null || (str = U12.getValue()) == null) {
                            str = "";
                        }
                        H93.h2(obj, str);
                    }
                }
            };
            T1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAnswerCheckContentPart.O9(Function1.this, obj);
                }
            });
        }
        g H93 = H9();
        if (H93 != null && (W1 = H93.W1()) != null) {
            LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.QZAlbumxAnswerCheckContentPart$onInitData$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    QZAlbumxAnswerCheckContentPart qZAlbumxAnswerCheckContentPart = QZAlbumxAnswerCheckContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qZAlbumxAnswerCheckContentPart.K9(it.intValue());
                }
            };
            W1.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAnswerCheckContentPart.P9(Function1.this, obj);
                }
            });
        }
        g H94 = H9();
        if (H94 != null) {
            H94.e2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9(int result) {
        Intent intent = new Intent();
        intent.putExtra("verify_question_result", result);
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final QUISingleLineInputView I9() {
        QUISingleLineInputView qUISingleLineInputView = this.inputView;
        if (qUISingleLineInputView != null) {
            return qUISingleLineInputView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        return null;
    }

    public final TextView J9() {
        TextView textView = this.questionTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("questionTv");
        return null;
    }

    public final void R9(QUISingleLineInputView qUISingleLineInputView) {
        Intrinsics.checkNotNullParameter(qUISingleLineInputView, "<set-?>");
        this.inputView = qUISingleLineInputView;
    }

    public final void S9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.questionTv = textView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAnswerCheckContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.njq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_question)");
        S9((TextView) findViewById);
        View findViewById2 = rootView.findViewById(R.id.f20558p);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.et_answer)");
        R9((QUISingleLineInputView) findViewById2);
        I9().setTitle(l.a(R.string.f134278d));
        I9().setShowBottomLine(false);
        I9().setShowPromptText(false);
        I9().setShowWordCount(false);
        M9();
    }
}
