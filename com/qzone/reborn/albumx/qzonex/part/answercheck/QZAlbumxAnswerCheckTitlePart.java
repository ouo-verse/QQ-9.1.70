package com.qzone.reborn.albumx.qzonex.part.answercheck;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.g;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/answercheck/QZAlbumxAnswerCheckTitlePart;", "Lcom/qzone/reborn/base/k;", "", "I9", "H9", "Lnc/g;", "G9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "cancelTv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleTv", "f", "completeTv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAnswerCheckTitlePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View cancelTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView completeTv;

    private final g G9() {
        return (g) getViewModel(g.class);
    }

    private final void H9() {
        MutableLiveData<Integer> T1;
        g G9 = G9();
        if (G9 == null || (T1 = G9.T1()) == null) {
            return;
        }
        Integer value = T1.getValue();
        T1.postValue(Integer.valueOf(value != null ? 1 + value.intValue() : 1));
    }

    private final void I9() {
        MutableLiveData<String> U1;
        g G9 = G9();
        if (G9 == null || (U1 = G9.U1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.QZAlbumxAnswerCheckTitlePart$onInitData$1
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
                TextView textView;
                if (str == null || str.length() == 0) {
                    return;
                }
                textView = QZAlbumxAnswerCheckTitlePart.this.completeTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("completeTv");
                    textView = null;
                }
                textView.setVisibility(0);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAnswerCheckTitlePart.J9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZAlbumxAnswerCheckTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZAlbumxAnswerCheckTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAnswerCheckTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.ni_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_cancel)");
        this.cancelTv = findViewById;
        TextView textView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelTv");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAnswerCheckTitlePart.K9(QZAlbumxAnswerCheckTitlePart.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.nhy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_answer_check_title)");
        TextView textView2 = (TextView) findViewById2;
        this.titleTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView2 = null;
        }
        textView2.setText(getContext().getString(R.string.f134298f));
        View findViewById3 = rootView.findViewById(R.id.nid);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_complete)");
        TextView textView3 = (TextView) findViewById3;
        this.completeTv = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeTv");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.answercheck.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAnswerCheckTitlePart.L9(QZAlbumxAnswerCheckTitlePart.this, view);
            }
        });
        TextView textView4 = this.completeTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeTv");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
        I9();
    }
}
