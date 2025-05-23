package com.tencent.mobileqq.wink.publish.part;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.peak.PeakConstants;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class bz extends j implements View.OnClickListener {
    private ConstraintLayout C;
    private String D;

    /* renamed from: d, reason: collision with root package name */
    private PublishViewModel f325878d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f325879e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f325880f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f325881h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f325882i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f325883m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Observer<Integer> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num.intValue() == 1 && bz.this.f325880f != null && bz.this.f325882i != null) {
                bz.this.f325880f.setImageResource(R.drawable.qvideo_skin_checkbox_general_selected);
                bz.this.f325882i.setImageResource(R.drawable.qvideo_skin_checkbox_general_normal);
            } else if (num.intValue() == 2 && bz.this.f325880f != null && bz.this.f325882i != null) {
                bz.this.f325880f.setImageResource(R.drawable.qvideo_skin_checkbox_general_normal);
                bz.this.f325882i.setImageResource(R.drawable.qvideo_skin_checkbox_general_selected);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.cancel();
        }
    }

    private void E9(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        VideoReport.setElementParams(view, map);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private boolean F9() {
        if (uq3.c.Q3() == 1) {
            return true;
        }
        return false;
    }

    private void G9() {
        MMKVOptionEntity from = QMMKV.from(getContext(), "QCIRCLE_MMKV_COMMON");
        String str = PublishViewModel.O0;
        if (!from.decodeBool(str, false)) {
            com.tencent.mobileqq.wink.publish.util.f.a(getPartRootView().getContext(), "\u9700\u5982\u5b9e\u586b\u5199\uff0c\u5426\u5219\u53ef\u80fd\u4e0d\u901a\u8fc7\u5ba1\u6838");
        }
        if (this.f325878d == null) {
            this.f325878d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        ImageView imageView = this.f325880f;
        if (imageView != null && this.f325882i != null) {
            imageView.setImageResource(R.drawable.qvideo_skin_checkbox_general_selected);
            this.f325882i.setImageResource(R.drawable.qvideo_skin_checkbox_general_normal);
            this.f325878d.F3(1);
        }
        PublishViewModel.Q0.put(this.D, 1);
        from.encodeBool(str, true);
    }

    private void H9() {
        MMKVOptionEntity from = QMMKV.from(getContext(), "QCIRCLE_MMKV_COMMON");
        String str = PublishViewModel.O0;
        if (!from.decodeBool(str, false)) {
            com.tencent.mobileqq.wink.publish.util.f.a(getPartRootView().getContext(), "\u9700\u5982\u5b9e\u586b\u5199\uff0c\u5426\u5219\u53ef\u80fd\u4e0d\u901a\u8fc7\u5ba1\u6838");
        }
        if (this.f325878d == null) {
            this.f325878d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        ImageView imageView = this.f325880f;
        if (imageView != null && this.f325882i != null) {
            imageView.setImageResource(R.drawable.qvideo_skin_checkbox_general_normal);
            this.f325882i.setImageResource(R.drawable.qvideo_skin_checkbox_general_selected);
            this.f325878d.F3(2);
        }
        PublishViewModel.Q0.put(this.D, 2);
        from.encodeBool(str, true);
    }

    private void I9() {
        DialogUtil.createCustomDialog(getContext(), null, "\u8bf7\u5982\u5b9e\u586b\u5199\u4f5c\u54c1\u7c7b\u578b\uff0c\u4ee5\u514d\u5f71\u54cd\u4f5c\u54c1\u5ba1\u6838\uff0c\u9009\u62e9\u81ea\u5236\u540e\u5c06\u5728\u4f5c\u54c1\u4e2d\u663e\u793a\u201c\u81ea\u5236\u201d\u5b57\u6837", null, "\u6211\u77e5\u9053\u4e86", new b(), null).show();
    }

    private void initViewModel() {
        if (this.f325878d == null) {
            this.f325878d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        this.f325878d.o2().observe(getHostFragment(), new a());
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return "PublishTypePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f31740rv && view.getId() != R.id.f31750rw) {
            if (view.getId() != R.id.f32490tw && view.getId() != R.id.f32500tx) {
                if (view.getId() == R.id.f32480tv) {
                    I9();
                }
            } else {
                H9();
            }
        } else {
            G9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.C = (ConstraintLayout) view.findViewById(R.id.f32990v9);
        if (!F9()) {
            this.C.setVisibility(8);
            return;
        }
        if (this.f325878d == null) {
            this.f325878d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f31740rv);
        this.f325879e = linearLayout;
        linearLayout.setOnClickListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.f31750rw);
        this.f325880f = imageView;
        imageView.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f32490tw);
        this.f325881h = linearLayout2;
        linearLayout2.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f32500tx);
        this.f325882i = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.f32480tv);
        this.f325883m = imageView3;
        imageView3.setOnClickListener(this);
        initViewModel();
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.D = getActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        }
        if (PublishViewModel.Q0.containsKey(this.D) && (PublishViewModel.Q0.get(this.D).intValue() == 1 || PublishViewModel.Q0.get(this.D).intValue() == 2)) {
            this.f325878d.F3(PublishViewModel.Q0.get(this.D).intValue());
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        E9(this.C, WinkDaTongReportConstant.ElementId.EM_XSJ_FEED_LABEL_BAR, buildElementParams);
        E9(this.f325879e, WinkDaTongReportConstant.ElementId.EM_XSJ_ORIGINAL_BUTTON, buildElementParams);
        E9(this.f325881h, WinkDaTongReportConstant.ElementId.EM_XSJ_REPRINT_BUTTON, buildElementParams);
    }
}
