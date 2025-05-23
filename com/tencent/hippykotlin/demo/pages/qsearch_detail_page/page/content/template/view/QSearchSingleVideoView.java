package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoView;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleVideoView extends ComposeView<QSearchSingleVideoAttr, QSearchSingleVideoEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSingleVideoView.class, "playControl", "getPlayControl()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayControl;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSingleVideoView.class, "playDuration", "getPlayDuration()F", 0)};
    public boolean hasFocus;
    public final ReadWriteProperty playControl$delegate = c.a(QVideoPlayControl.NONE);
    public final ReadWriteProperty playDuration$delegate = c.a(Float.valueOf(0.0f));
    public aa<QQCirVideoView> videoRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$dispatchFocusState(QSearchSingleVideoView qSearchSingleVideoView) {
        if (((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getPlayIndex() == ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).index) {
            if (qSearchSingleVideoView.hasFocus) {
                return;
            }
            qSearchSingleVideoView.hasFocus = true;
            qSearchSingleVideoView.setPlayControl(QVideoPlayControl.PLAY);
            return;
        }
        if (qSearchSingleVideoView.hasFocus) {
            qSearchSingleVideoView.hasFocus = false;
            if (((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getPlayIndex() == -2) {
                qSearchSingleVideoView.setPlayControl(QVideoPlayControl.PAUSE);
            } else {
                qSearchSingleVideoView.setPlayControl(QVideoPlayControl.STOP);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchSingleVideoAttr access$getAttr(QSearchSingleVideoView qSearchSingleVideoView) {
        return (QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchSingleVideoEvent access$getEvent(QSearchSingleVideoView qSearchSingleVideoView) {
        return (QSearchSingleVideoEvent) qSearchSingleVideoView.getEvent();
    }

    public static final QVideoPlayControl access$getPlayControl(QSearchSingleVideoView qSearchSingleVideoView) {
        return (QVideoPlayControl) qSearchSingleVideoView.playControl$delegate.getValue(qSearchSingleVideoView, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$newStyleBody(QSearchSingleVideoView qSearchSingleVideoView) {
        e eVar;
        FlexNode flexNode = ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getFlexNode();
        Intrinsics.checkNotNull(flexNode);
        float U = flexNode.U();
        float f16 = U / ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getMediaInfo().ratio;
        QSearchTemplateReportInfo qSearchTemplateReportInfo = ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getMediaInfo().reportInfo;
        if (qSearchTemplateReportInfo != null) {
            eVar = qSearchTemplateReportInfo.getReportParams(((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).reportParams);
            eVar.v("eid", qSearchTemplateReportInfo.eid);
        } else {
            eVar = ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).reportParams;
        }
        return new QSearchSingleVideoView$newStyleBody$1(qSearchSingleVideoView, f16, qSearchTemplateReportInfo, eVar, U);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$oldStyleBody(QSearchSingleVideoView qSearchSingleVideoView) {
        e eVar;
        FlexNode flexNode = ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getFlexNode();
        Intrinsics.checkNotNull(flexNode);
        float U = flexNode.U();
        float f16 = U / ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getMediaInfo().ratio;
        QSearchTemplateReportInfo qSearchTemplateReportInfo = ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).getMediaInfo().reportInfo;
        if (qSearchTemplateReportInfo != null) {
            eVar = qSearchTemplateReportInfo.getReportParams(((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).reportParams);
            eVar.v("eid", qSearchTemplateReportInfo.eid);
        } else {
            eVar = ((QSearchSingleVideoAttr) qSearchSingleVideoView.getAttr()).reportParams;
        }
        return new QSearchSingleVideoView$oldStyleBody$1(qSearchSingleVideoView, f16, qSearchTemplateReportInfo, eVar, U);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                if (!QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).isUseNewBodyStyle) {
                    ((QSearchSingleVideoView$oldStyleBody$1) QSearchSingleVideoView.access$oldStyleBody(QSearchSingleVideoView.this)).invoke(viewContainer2);
                } else {
                    ((QSearchSingleVideoView$newStyleBody$1) QSearchSingleVideoView.access$newStyleBody(QSearchSingleVideoView.this)).invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchSingleVideoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchSingleVideoEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$didInit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getPlayIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchSingleVideoView.access$dispatchFocusState(QSearchSingleVideoView.this);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setPlayControl(QVideoPlayControl qVideoPlayControl) {
        this.playControl$delegate.setValue(this, $$delegatedProperties[0], qVideoPlayControl);
    }
}
