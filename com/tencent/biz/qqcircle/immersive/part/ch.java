package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StTagInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0014R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/ch;", "Lcom/tencent/biz/qqcircle/bizparts/QCirclePublishFeedPart;", "", "Ra", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "la", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "e0", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "getInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "initBean", "f0", "Landroid/view/View;", "publishBtn", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;)V", "g0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ch extends QCirclePublishFeedPart {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleLayerBean initBean;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View publishBtn;

    public ch(@Nullable QCircleLayerBean qCircleLayerBean) {
        super(null);
        this.initBean = qCircleLayerBean;
        if (qCircleLayerBean != null) {
            FeedCloudMeta$StTagInfo tagInfo = qCircleLayerBean.getTagInfo();
            if (tagInfo != null) {
                Intrinsics.checkNotNullExpressionValue(tagInfo, "tagInfo");
                Ja(tagInfo);
            }
            Ha(qCircleLayerBean);
            QCircleLayerBean.QFSTagPolymerizationBean qfsTagPolymerizationBean = qCircleLayerBean.getQfsTagPolymerizationBean();
            Ia(qfsTagPolymerizationBean != null ? qfsTagPolymerizationBean.polymerizationScheme : null);
        }
        Ga(8);
    }

    private final void Ra() {
        View view = this.publishBtn;
        if (view != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
            VideoReport.setElementParams(view, new QCircleDTParamBuilder().buildElementParams());
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageBottomTagPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart
    @NotNull
    public String la() {
        String str;
        QCircleLayerBean.QFSTagPolymerizationBean qfsTagPolymerizationBean;
        QCircleLayerBean qCircleLayerBean = this.initBean;
        if (qCircleLayerBean != null && (qfsTagPolymerizationBean = qCircleLayerBean.getQfsTagPolymerizationBean()) != null) {
            str = qfsTagPolymerizationBean.feedTagPageFromType;
        } else {
            str = null;
        }
        if (str == null) {
            String la5 = super.la();
            Intrinsics.checkNotNullExpressionValue(la5, "super.getTagPageFrom()");
            return la5;
        }
        return str;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewStub viewStub;
        View view;
        View view2;
        QCircleLayerBean qCircleLayerBean;
        QCircleLayerBean.QFSTagPolymerizationBean qfsTagPolymerizationBean;
        TextView textView;
        this.L = (com.tencent.biz.qqcircle.viewmodels.h) getViewModel(com.tencent.biz.qqcircle.viewmodels.h.class);
        TextView textView2 = null;
        if (rootView != null) {
            viewStub = (ViewStub) rootView.findViewById(R.id.f45361ro);
        } else {
            viewStub = null;
        }
        if (viewStub != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view != null) {
            view2 = view.findViewById(R.id.ypy);
        } else {
            view2 = null;
        }
        this.publishBtn = view2;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        QCircleInitBean qCircleInitBean = this.K;
        if (qCircleInitBean != null) {
            if (qCircleInitBean.getTagInfo().tagName.has()) {
                if (rootView != null) {
                    textView = (TextView) rootView.findViewById(R.id.jb7);
                } else {
                    textView = null;
                }
                if (textView != null) {
                    textView.setText(qCircleInitBean.getTagInfo().tagName.get());
                }
            }
            if (qCircleInitBean.getPolymerizationType() == 7 && (qCircleLayerBean = this.initBean) != null && (qfsTagPolymerizationBean = qCircleLayerBean.getQfsTagPolymerizationBean()) != null) {
                if (rootView != null) {
                    textView2 = (TextView) rootView.findViewById(R.id.f29420ll);
                }
                if (textView2 != null) {
                    textView2.setText("\u6d4f\u89c8" + qfsTagPolymerizationBean.tagViews);
                }
            }
        }
        Ra();
    }
}
