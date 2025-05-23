package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSMessageQuickThankEvent;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/presenter/QFSMessageQuickThankPresenter;", "Lcom/tencent/biz/qqcircle/fragments/message/presenter/a;", "Landroid/content/Context;", "context", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initCustomView", "Lcom/tencent/biz/qqcircle/beans/QFSMessageItemInfo;", "itemInfo", "", "position", "bindCustomData", "initClickListener", "", "getLogTag", "Landroid/widget/TextView;", "tvQuickThank", "Landroid/widget/TextView;", "tvQuickThankMsg", "viewType", "<init>", "(I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMessageQuickThankPresenter extends a {

    @NotNull
    private static final String TAG = "QFSMessageQuickThankPresenter";
    private TextView tvQuickThank;
    private TextView tvQuickThankMsg;

    public QFSMessageQuickThankPresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCustomData$lambda$0(QFSMessageItemInfo itemInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemInfo, "$itemInfo");
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageQuickThankEvent(itemInfo.getLaunchTo()));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NotNull final QFSMessageItemInfo itemInfo, int position) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        TextView textView = this.tvQuickThank;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuickThank");
            textView = null;
        }
        textView.setText(uq3.o.g0("msgAllThanksNoneTxt"));
        TextView textView3 = this.tvQuickThank;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuickThank");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSMessageQuickThankPresenter.bindCustomData$lambda$0(QFSMessageItemInfo.this, view);
            }
        });
        if (itemInfo.getLaunchTo() == 4) {
            TextView textView4 = this.tvQuickThankMsg;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvQuickThankMsg");
                textView4 = null;
            }
            textView4.setText(RFWApplication.getApplication().getText(R.string.f196174gl));
        } else if (itemInfo.getLaunchTo() == 3) {
            TextView textView5 = this.tvQuickThankMsg;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvQuickThankMsg");
                textView5 = null;
            }
            textView5.setText(RFWApplication.getApplication().getText(R.string.f196194gn));
        } else {
            TextView textView6 = this.tvQuickThankMsg;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvQuickThankMsg");
                textView6 = null;
            }
            textView6.setText(RFWApplication.getApplication().getText(R.string.f196184gm));
        }
        TextView textView7 = this.tvQuickThank;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuickThank");
            textView7 = null;
        }
        VideoReport.setElementId(textView7, QCircleDaTongConstant.ElementId.EM_XSJ_ONE_KEY_THANK_BUTTON);
        TextView textView8 = this.tvQuickThank;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuickThank");
        } else {
            textView2 = textView8;
        }
        VideoReport.setElementReuseIdentifier(textView2, TAG);
        VideoReport.traversePage(this.mContainer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(@NotNull Context context, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f110386id);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_quick_thank)");
        this.tvQuickThank = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f110396ie);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_quick_thank_msg)");
        this.tvQuickThankMsg = (TextView) findViewById2;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
    }
}
