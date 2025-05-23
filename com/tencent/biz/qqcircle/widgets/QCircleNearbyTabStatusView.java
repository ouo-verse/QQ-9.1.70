package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleNearbyTabStatusView extends QCircleStatusView {
    private View.OnClickListener C;
    private MutableLiveData<Integer> D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QCircleNearbyTabStatusView.this.C != null) {
                QCircleNearbyTabStatusView.this.C.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QCircleNearbyTabStatusView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = null;
        H0();
    }

    private void H0() {
        this.D = new MutableLiveData<>();
    }

    private void I0(int i3, String str, String str2, View.OnClickListener onClickListener, int i16) {
        J0(i3, str, "", str2, onClickListener, i16);
    }

    private void J0(int i3, String str, String str2, String str3, View.OnClickListener onClickListener, int i16) {
        this.f93163i.setImageType(i3);
        this.f93163i.setTitle(str);
        this.f93163i.setDesc(str2);
        this.f93163i.setButton(str3, onClickListener);
        s0();
        setVisibility(0);
        MutableLiveData<Integer> mutableLiveData = this.D;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(Integer.valueOf(i16));
        }
    }

    public void K0() {
        I0(16, uq3.c.M3(), uq3.c.L3(), new a(), 2);
    }

    public void L0(View.OnClickListener onClickListener) {
        String str;
        String[] split = uq3.c.I3().split("\n");
        String str2 = split[0];
        if (split.length > 1) {
            str = split[1];
        } else {
            str = "";
        }
        J0(1, str2, str, uq3.c.H3(), onClickListener, 1);
    }

    public void M0(View.OnClickListener onClickListener) {
        String str;
        String[] split = uq3.c.K3().split("\n");
        String str2 = split[0];
        if (split.length > 1) {
            str = split[1];
        } else {
            str = "";
        }
        J0(1, str2, str, uq3.c.J3(), onClickListener, 1);
        QUIEmptyState qUIEmptyState = this.f93161f;
        if (qUIEmptyState != null) {
            QUIButton button = qUIEmptyState.getButton();
            VideoReport.setElementId(button, QCircleDaTongConstant.ElementId.EM_XSJ_SET_LOCATION_BUTTON);
            VideoReport.traversePage(button);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleNearbyTabStatusView";
    }

    public void setEmptyClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView
    public void w0() {
        K0();
        l0();
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView
    public void x0(String str) {
        super.x0(str);
        F0();
        s0();
        MutableLiveData<Integer> mutableLiveData = this.D;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(3);
        }
    }

    public QCircleNearbyTabStatusView(Context context) {
        super(context);
        this.D = null;
        H0();
    }
}
