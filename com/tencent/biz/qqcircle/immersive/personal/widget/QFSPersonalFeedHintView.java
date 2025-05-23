package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes4.dex */
public class QFSPersonalFeedHintView extends QFSFaultHintView {

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public QFSPersonalFeedHintView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A0(a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (aVar != null) {
            aVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void B0(String str, String str2) {
        w0(str, str2, QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_nocontent"), R.drawable.qvideo_skin_emptystate_img_offline);
        this.C.setVisibility(8);
    }

    public void C0(String str, String str2) {
        D0(str, str2, "qvideo_skin_emptystate_img_offline");
    }

    public void D0(String str, String str2, String str3) {
        w0(str, str2, QCircleSkinHelper.getInstance().getUrl(str3), R.drawable.qvideo_skin_emptystate_img_offline);
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g_w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalFeedHintView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    protected String l0() {
        return QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_offline");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    protected String m0() {
        return uq3.c.N1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView
    protected String n0() {
        return uq3.c.O1();
    }

    public void setOnPushMoreClickListener(final a aVar) {
        TextView textView = this.C;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener(aVar) { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalFeedHintView.A0(null, view);
            }
        });
    }

    public QFSPersonalFeedHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
