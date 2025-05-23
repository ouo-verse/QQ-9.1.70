package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedEmptyItemView;", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedBaseWidgetView;", "Le30/b;", "Landroid/content/Context;", "context", "", "viewType", "", "initView", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "", "getLogTag", "getLayoutId", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getLayoutPreLoader", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTips", "<init>", "(Landroid/content/Context;)V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMixFeedEmptyItemView extends QFSMixFeedBaseWidgetView<e30.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTips;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSMixFeedEmptyItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g4n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NotNull
    public RFWLayoutPreLoader getLayoutPreLoader() {
        RFWLayoutLoaderStrategy c16 = l30.a.a().c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance().layoutLoaderStrategy");
        return RFWLayoutPreLoaderFactory.getLayoutLoader(c16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSMixFeedEmptyItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        View findViewById = findViewById(R.id.kbr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_tips)");
        this.tvTips = (TextView) findViewById;
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_VOID_ITEM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@NotNull e30.b objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        Object b16 = objData.b(String.valueOf(objData.g().dittoFeed.dittoId.get()));
        TextView textView = null;
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = b16 instanceof QQCircleDitto$StCircleDittoDataNew ? (QQCircleDitto$StCircleDittoDataNew) b16 : null;
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            QLog.e("QFSMixFeedEmptyItemView", 1, "[onBindData] dittoDataNew is null");
            return;
        }
        TextView textView2 = this.tvTips;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
        } else {
            textView = textView2;
        }
        textView.setText(qQCircleDitto$StCircleDittoDataNew.dividingLine.summary.get());
    }
}
