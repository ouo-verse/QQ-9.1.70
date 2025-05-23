package com.tencent.biz.qqcircle.push;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.part.push.a;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSPushTaskReceiveAwardRequest;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import qqcircle.QQCircleClient$ReceiveAwardRsp;
import qqcircle.QQCircleClient$TaskInfo;

/* loaded from: classes5.dex */
public class QFSPushMissionItemView extends QCircleBaseWidgetView<QQCircleClient$TaskInfo> implements View.OnClickListener {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private APNGDrawable K;
    private a.e L;

    /* renamed from: d, reason: collision with root package name */
    private TextView f91800d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f91801e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f91802f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f91803h;

    /* renamed from: i, reason: collision with root package name */
    private RoundFrameLayout f91804i;

    /* renamed from: m, reason: collision with root package name */
    private int f91805m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleClient$ReceiveAwardRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f91807a;

        a(int i3) {
            this.f91807a = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleClient$ReceiveAwardRsp qQCircleClient$ReceiveAwardRsp) {
            if (qQCircleClient$ReceiveAwardRsp != null && z16 && j3 == 0) {
                int i3 = QFSPushMissionItemView.this.E * QFSPushMissionItemView.this.F;
                QCircleToast.o(i3 + com.tencent.biz.qqcircle.utils.h.a(R.string.f194114b1), 0);
                com.tencent.biz.qqcircle.f.v().R(com.tencent.biz.qqcircle.f.v().t() + i3);
            }
            QLog.d("QFSPushMissionItemView", 1, "ReceiveAward is Success: " + z16 + ", taskId: " + this.f91807a);
        }
    }

    public QFSPushMissionItemView(Context context) {
        super(context);
        initView();
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    private void initView() {
        this.f91800d = (TextView) findViewById(R.id.f5108275);
        this.f91801e = (TextView) findViewById(R.id.f5107274);
        this.f91802f = (ImageView) findViewById(R.id.f5105272);
        this.f91803h = (TextView) findViewById(R.id.f5106273);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) findViewById(R.id.f5104271);
        this.f91804i = roundFrameLayout;
        roundFrameLayout.setOnClickListener(this);
    }

    private void n0() {
        a.e eVar = this.L;
        if (eVar != null) {
            eVar.a();
        }
    }

    private void o0() {
        int i3 = this.C;
        if (i3 != 0) {
            if (i3 == 1) {
                p0();
            }
        } else {
            q0();
        }
        if (this.C != 2) {
            n0();
        }
    }

    private void p0() {
        s0(this.f91805m);
        int i3 = this.G + 1;
        this.G = i3;
        if (i3 >= this.H) {
            this.C = 2;
        } else {
            this.C = 0;
        }
        x0();
    }

    private void q0() {
        if (TextUtils.isEmpty(this.I)) {
            QLog.d("QFSPushMissionItemView", 1, "jumpUrl is empty.");
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.I);
        }
    }

    private void r0() {
        CharSequence text;
        VideoReport.setElementId(this.f91804i, QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("taskid", Integer.valueOf(this.f91805m));
        TextView textView = this.f91803h;
        if (textView == null) {
            text = "";
        } else {
            text = textView.getText();
        }
        buildElementParams.put("xsj_item_name", text);
        VideoReport.setElementParams(this.f91804i, buildElementParams);
        VideoReport.setElementExposePolicy(this.f91804i, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f91804i, ClickPolicy.REPORT_ALL);
    }

    private void s0(int i3) {
        VSNetworkHelper.getInstance().sendRequest(new QFSPushTaskReceiveAwardRequest(i3), new a(i3));
    }

    private void u0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String valueOf = String.valueOf(this.E);
        int indexOf = str.indexOf(valueOf);
        if (indexOf < 0) {
            this.f91801e.setText(str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(cx.a(12.0f)) { // from class: com.tencent.biz.qqcircle.push.QFSPushMissionItemView.1
            @Override // android.text.style.AbsoluteSizeSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(QFSPushMissionItemView.this.getContext().getResources().getColor(R.color.qvideo_skin_color_text_brand, null));
                textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            }
        }, indexOf - 1, indexOf + valueOf.length(), 34);
        this.f91801e.setText(spannableString);
    }

    private void v0(QQCircleClient$TaskInfo qQCircleClient$TaskInfo) {
        this.f91800d.setText(qQCircleClient$TaskInfo.title.get() + " (" + this.G + "/" + this.H + ")");
    }

    private void w0() {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestWidth(ImmersiveUtils.dpToPx(62.0f));
        apngOptions.setRequestHeight(ImmersiveUtils.dpToPx(30.0f));
        APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable(QFSPushMissionItemView.class.getName(), "https://qq-video.cdn-go.cn/android/latest/defaultmode/8918/rocket/qvideo_button_receive_attract.png", apngOptions);
        this.K = apngDrawable;
        this.f91802f.setImageDrawable(apngDrawable);
    }

    private void x0() {
        int i3 = this.C;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f91802f.setBackgroundColor(getContext().getResources().getColor(R.color.qvideo_skin_color_btn_primary_pressed, null));
                    this.f91802f.setImageDrawable(null);
                    this.f91803h.setTextColor(getContext().getResources().getColor(R.color.cmc, null));
                    this.f91803h.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194094az));
                    return;
                }
                return;
            }
            w0();
            this.f91802f.setBackgroundColor(getContext().getResources().getColor(R.color.ckj, null));
            this.f91803h.setTextColor(getContext().getResources().getColor(R.color.cla, null));
            this.f91803h.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194104b0));
            return;
        }
        this.f91802f.setBackgroundColor(getContext().getResources().getColor(R.color.qvideo_skin_color_btn_primary_normal, null));
        this.f91802f.setImageDrawable(null);
        this.f91803h.setTextColor(getContext().getResources().getColor(R.color.cla, null));
        this.f91803h.setText(this.J);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gpj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPushMissionItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleClient$TaskInfo qQCircleClient$TaskInfo, int i3) {
        if (qQCircleClient$TaskInfo == null) {
            return;
        }
        this.D = i3;
        this.f91805m = qQCircleClient$TaskInfo.f429295id.get();
        this.C = qQCircleClient$TaskInfo.status.get();
        this.I = qQCircleClient$TaskInfo.jump_url.get();
        this.E = qQCircleClient$TaskInfo.reward_count.get();
        this.F = qQCircleClient$TaskInfo.available_reward.get();
        this.G = qQCircleClient$TaskInfo.done_step.get();
        this.H = qQCircleClient$TaskInfo.upper_count.get();
        this.J = qQCircleClient$TaskInfo.botton_text.get();
        v0(qQCircleClient$TaskInfo);
        u0(qQCircleClient$TaskInfo.desc.get());
        x0();
        r0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f5104271) {
            o0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        APNGDrawable aPNGDrawable = this.K;
        if (aPNGDrawable != null) {
            aPNGDrawable.pauseApng();
        }
    }

    public void setDismissClickListener(a.e eVar) {
        this.L = eVar;
    }
}
