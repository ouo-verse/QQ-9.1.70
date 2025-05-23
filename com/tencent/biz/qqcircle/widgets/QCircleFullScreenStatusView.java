package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StTagInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleFullScreenStatusView extends QCircleStatusView {
    private int C;
    private String D;
    private String E;
    private String F;
    private FeedCloudMeta$StTagInfo G;

    public QCircleFullScreenStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = -1;
        this.E = "";
    }

    private boolean H0(CharSequence charSequence) {
        if (!uq3.c.m3().equals(charSequence.toString()) && !uq3.c.D3().equals(charSequence.toString())) {
            return false;
        }
        return true;
    }

    private void I0() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_bundle_common_init_bean", new QCircleInitBean());
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = this.G;
        if (feedCloudMeta$StTagInfo != null) {
            bundle.putString("QQWinkDataKeys-tag_id", feedCloudMeta$StTagInfo.tagId.get());
            bundle.putString("QQWinkDataKeys-tag_name", this.G.tagName.get());
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(getContext(), QCircleTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleLoadingFragment.class.getName());
        getContext().startActivity(intent);
    }

    public void J0() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                if (uq3.c.D3().equals(QCircleFullScreenStatusView.this.F)) {
                    VideoReport.setElementId(QCircleFullScreenStatusView.this.f93161f, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleMessageListStatusView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = this.F;
        if (str != null) {
            if (H0(str)) {
                if (!QCircleBindPhoneNumberHelper.a()) {
                    QCircleBindPhoneNumberHelper.b(getContext(), 1);
                } else {
                    I0();
                }
            } else if (uq3.c.F3().equals(str.toString())) {
                com.tencent.biz.qqcircle.launcher.c.g(getContext(), "mqqapi://qcircle/openfolder?tabtype=6");
            } else if (getContext() != null && getContext().getResources() != null && str.equals(getContext().getResources().getString(R.string.f183243in))) {
                com.tencent.biz.qqcircle.launcher.c.o0(getContext(), "https://h5.qzone.qq.com/v2/wezone/recommendTag?_wv=3&_proxy=1", new Intent(), -1);
            } else if (getContext() != null && (str.equals(getContext().getString(R.string.f183003i0)) || str.equals(getContext().getString(R.string.f196504hh)))) {
                r0(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setEmptyImageAndText(int i3, String str, String str2) {
        this.C = i3;
        this.D = str;
        this.F = str2;
    }

    public void setTagInfo(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        this.G = feedCloudMeta$StTagInfo;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleStatusView, com.tencent.biz.richframework.part.IStatusViewProvider
    public void showEmptyView(String str) {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            this.f93163i.setImageType(5);
            this.f93163i.setDesc(uq3.c.N3());
            if (!TextUtils.isEmpty(this.E)) {
                this.f93163i.setTitle("");
            }
        } else {
            if (!TextUtils.isEmpty(this.D)) {
                this.f93163i.setDesc(this.D);
            }
            if (!TextUtils.isEmpty(this.E)) {
                this.f93163i.setTitle(this.E);
            }
            int i3 = this.C;
            if (i3 != -1) {
                this.f93163i.setImageType(i3);
            } else {
                this.f93163i.setImageType(16);
            }
            this.f93163i.setButton(this.F, this);
        }
        s0();
        setVisibility(0);
    }

    public QCircleFullScreenStatusView(Context context) {
        super(context);
        this.C = -1;
        this.E = "";
    }

    public void setEmptyImageAndText(int i3, String str, String str2, String str3) {
        setEmptyImageAndText(i3, str2, str3);
        this.E = str;
    }
}
