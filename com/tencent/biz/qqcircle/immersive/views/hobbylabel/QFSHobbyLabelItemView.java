package com.tencent.biz.qqcircle.immersive.views.hobbylabel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c70.b;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSHobbyLabelItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f90778d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90779e;

    /* renamed from: f, reason: collision with root package name */
    b f90780f;

    /* renamed from: h, reason: collision with root package name */
    private String f90781h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f90782i;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSHobbyLabelItemView> f90783a;

        public a(QFSHobbyLabelItemView qFSHobbyLabelItemView) {
            this.f90783a = new WeakReference<>(qFSHobbyLabelItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSHobbyLabelItemView qFSHobbyLabelItemView = this.f90783a.get();
            if (qFSHobbyLabelItemView == null) {
                return buildElementParams;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAG_NAME, qFSHobbyLabelItemView.f90781h);
            buildElementParams.put("xsj_is_tick", Integer.valueOf(qFSHobbyLabelItemView.f90782i ? 1 : 0));
            return buildElementParams;
        }
    }

    public QFSHobbyLabelItemView(@NonNull Context context) {
        super(context);
        initView();
        q0();
        o0();
    }

    private void initView() {
        this.f90778d = (TextView) findViewById(R.id.f43771nd);
        this.f90779e = (ImageView) findViewById(R.id.f43761nc);
    }

    private void m0(String str) {
        Set<String> Z1 = this.f90780f.Z1();
        Z1.add(str);
        QLog.d("QFSHobbyLabelItemView", 1, "addSelectedLabel " + str);
        this.f90780f.X1().setValue(Z1);
    }

    private void o0() {
        TextView textView = this.f90778d;
        if (textView != null) {
            VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_USER_INTEREST_TAG);
            VideoReport.setEventDynamicParams(this.f90778d, new a(this));
        }
    }

    private void p0(String str) {
        if (this.f90778d != null && this.f90780f != null && TextUtils.equals(this.f90781h, str)) {
            boolean contains = this.f90780f.Z1().contains(this.f90781h);
            s0(!contains);
            if (contains) {
                r0(this.f90781h);
            } else {
                m0(this.f90781h);
            }
        }
    }

    private void q0() {
        this.f90780f = (b) getViewModel(b.class);
    }

    private void r0(String str) {
        Set<String> Z1 = this.f90780f.Z1();
        Iterator<String> it = Z1.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), str)) {
                QLog.d("QFSHobbyLabelItemView", 1, "removeSelectedLabel " + str);
                it.remove();
            }
        }
        this.f90780f.X1().setValue(Z1);
    }

    private void s0(boolean z16) {
        int i3;
        TextView textView = this.f90778d;
        if (textView != null && this.f90779e != null) {
            this.f90782i = z16;
            textView.setSelected(z16);
            ImageView imageView = this.f90779e;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gee;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (this.f90778d != null && qQCircleDitto$StItemInfo != null && this.f90780f != null) {
            String str = qQCircleDitto$StItemInfo.name.get();
            this.f90781h = str;
            this.f90778d.setText(str);
            s0(this.f90780f.Z1().contains(this.f90781h));
            this.f90778d.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!fb0.a.b("QFSHobbyLabelItemView" + charSequence, 200L)) {
                p0(charSequence);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
