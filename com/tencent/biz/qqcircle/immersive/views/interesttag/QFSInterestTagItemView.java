package com.tencent.biz.qqcircle.immersive.views.interesttag;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import d70.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/interesttag/QFSInterestTagItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lqqcircle/QQCircleDitto$StItemInfo;", "Landroid/view/View$OnClickListener;", "", "initView", "n0", "", "isSelected", "p0", "", "selectedText", "k0", "o0", "m0", "", "getLayoutId", "objData", c.G, "l0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mTvName", "Ld70/a;", "e", "Ld70/a;", "mViewModel", "f", "Ljava/lang/String;", "mTextContent", h.F, "Z", "mIsSelected", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSInterestTagItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mTvName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a mViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTextContent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSInterestTagItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextContent = "";
        initView();
        n0();
    }

    private final void initView() {
        View findViewById = findViewById(R.id.tv_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_name)");
        this.mTvName = (TextView) findViewById;
    }

    private final void k0(String selectedText) {
        a aVar = this.mViewModel;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        Set<String> U1 = aVar.U1();
        U1.add(selectedText);
        QLog.d("QFSInterestTagItemView", 1, "addSelectedTag " + selectedText);
        a aVar3 = this.mViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.T1().setValue(U1);
    }

    private final void m0() {
        TextView textView = this.mTvName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView = null;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_COLLECTION_TAG);
        TextView textView3 = this.mTvName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView3 = null;
        }
        VideoReport.setElementReuseIdentifier(textView3, this.mTextContent + System.nanoTime());
        TextView textView4 = this.mTvName;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView4 = null;
        }
        VideoReport.setElementExposePolicy(textView4, ExposurePolicy.REPORT_ALL);
        TextView textView5 = this.mTvName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView5 = null;
        }
        VideoReport.setElementClickPolicy(textView5, ClickPolicy.REPORT_NONE);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAG_NAME, this.mTextContent);
        TextView textView6 = this.mTvName;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
        } else {
            textView2 = textView6;
        }
        VideoReport.setElementParams(textView2, params);
    }

    private final void n0() {
        BaseViewModel viewModel = getViewModel(a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QFSInterestTagViewModel::class.java)");
        this.mViewModel = (a) viewModel;
    }

    private final void o0(String selectedText) {
        a aVar = this.mViewModel;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        Set<String> U1 = aVar.U1();
        Iterator<String> it = U1.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), selectedText)) {
                QLog.d("QFSInterestTagItemView", 1, "removeSelectedTag " + selectedText);
                it.remove();
            }
        }
        a aVar3 = this.mViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.T1().setValue(U1);
    }

    private final void p0(boolean isSelected) {
        this.mIsSelected = isSelected;
        TextView textView = this.mTvName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView = null;
        }
        textView.setSelected(isSelected);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gej;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull QQCircleDitto$StItemInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        String str = objData.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "objData.name.get()");
        this.mTextContent = str;
        TextView textView = this.mTvName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
            textView = null;
        }
        textView.setText(this.mTextContent);
        a aVar = this.mViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        p0(aVar.U1().contains(this.mTextContent));
        TextView textView3 = this.mTvName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvName");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(this);
        m0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3 instanceof TextView) {
            if (TextUtils.equals(this.mTextContent, ((TextView) v3).getText().toString())) {
                a aVar = this.mViewModel;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    aVar = null;
                }
                boolean contains = aVar.U1().contains(this.mTextContent);
                p0(!contains);
                if (contains) {
                    o0(this.mTextContent);
                } else {
                    k0(this.mTextContent);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
