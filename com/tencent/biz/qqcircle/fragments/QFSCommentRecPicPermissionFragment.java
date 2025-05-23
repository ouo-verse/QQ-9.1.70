package com.tencent.biz.qqcircle.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QFSPrivateSettingBean;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.z;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.widget.RoundCorneredLinearLayout;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import uq3.k;

/* loaded from: classes4.dex */
public class QFSCommentRecPicPermissionFragment extends ReportAndroidXDialogFragment {
    private boolean C = false;
    private String D;
    private String E;
    private String F;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        rh(view, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
        aa.f83750a.J();
        k.a().j(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC, true);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.D;
        if (str == null) {
            str = "";
        }
        simpleEventBus.dispatchEvent(new QFSRecPicStateEvent(1, str));
        this.C = true;
        dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void rh(View view, String str) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_AUTH_POP);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, this.E);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
        buildElementParams.put("xsj_custom_pgid", this.F);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
    }

    private void sh(View view) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_AUTH_POP);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, this.E);
        buildElementParams.put("xsj_custom_pgid", this.F);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        rh(view, "cancel");
        dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.f246388r);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.g_6, (ViewGroup) null);
        ((RoundCorneredLinearLayout) inflate.findViewById(R.id.ifh)).setRadius(DisplayUtil.dip2px(inflate.getContext(), 8.0f));
        sh(inflate);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getDefaultModeUrl("qvideo_icon_comment_zhinengtuping_banner")).setTargetView((ImageView) inflate.findViewById(R.id.t2q)));
        TextView textView = (TextView) inflate.findViewById(R.id.fdi);
        TextView textView2 = (TextView) inflate.findViewById(R.id.kbs);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f167042k73);
        z zVar = z.f83900a;
        textView2.setText(zVar.w().getAuthTitle());
        textView3.setText(zVar.w().getAuthDesc());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentRecPicPermissionFragment.this.lambda$onCreateView$0(view);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.az_);
        imageView.setImageDrawable(QFSQUIUtilsKt.f(getContext(), R.drawable.qui_close_circle, R.color.qui_common_icon_white));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentRecPicPermissionFragment.this.th(view);
            }
        });
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.C) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = this.D;
            if (str == null) {
                str = "";
            }
            simpleEventBus.dispatchEvent(new QFSRecPicStateEvent(4, str));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setLayout(DisplayUtil.dip2px(RFWApplication.getApplication(), 278.0f), -2);
        window.setFlags(131072, 131072);
        getDialog().setCancelable(false);
        window.setGravity(17);
    }

    public void uh(String str) {
        this.D = str;
    }

    public void vh(String str) {
        this.E = str;
    }

    public void wh(String str) {
        this.F = str;
    }
}
