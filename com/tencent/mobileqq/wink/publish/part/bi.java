package com.tencent.mobileqq.wink.publish.part;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class bi extends j {
    private com.tencent.mobileqq.wink.publish.viewmodel.p C;
    private PublishPromotionViewModel D;
    private PartsStateViewModel E;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f325846e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f325847f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f325848h;

    /* renamed from: i, reason: collision with root package name */
    private Switch f325849i;

    /* renamed from: m, reason: collision with root package name */
    private PublishViewModel f325850m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f325845d = false;
    private final CompoundButton.OnCheckedChangeListener F = new a();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QLog.d("PublishSchoolPart", 2, "onCheckedChangeListener: " + z16);
            bi.this.f325849i.setChecked(z16);
            bi.this.E.R2(z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    private HashMap<String, String> K9(Intent intent) {
        return (HashMap) intent.getSerializableExtra("key_attrs");
    }

    private void L9() {
        if (this.f325849i == null) {
            QLog.d("PublishSchoolPart", 1, "mSchoolSelected = null");
        } else {
            ViewUtilsKt.e(this.f325846e, 500L, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.bh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bi.this.N9(view);
                }
            });
            this.f325849i.setOnCheckedChangeListener(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(PublishSettingItemState publishSettingItemState) {
        int i3;
        this.f325849i.setChecked(this.E.l2().getValue().getIsSelected());
        boolean selectable = publishSettingItemState.getSelectable();
        QLog.i("PublishSchoolPart", 1, "isSchoolSelectable: " + selectable);
        if (selectable) {
            this.f325848h.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000));
            this.f325849i.setClickable(true);
        } else {
            this.f325848h.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, 1000));
            this.f325849i.setClickable(false);
            this.f325849i.setChecked(false);
        }
        boolean visible = this.E.l2().getValue().getVisible();
        QLog.i("PublishSchoolPart", 1, "isSchoolVisible: " + visible);
        RelativeLayout relativeLayout = this.f325846e;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        this.E.S2(visible);
        if (!visible) {
            this.f325849i.setClickable(false);
            this.f325849i.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(String str) {
        QLog.i("PublishSchoolPart", 1, "schoolName->onChanged: schoolName = xx");
        this.f325847f.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f325846e.setVisibility(8);
            this.E.S2(false);
            return;
        }
        this.f325846e.setVisibility(0);
        this.E.S2(true);
        if (!this.f325845d) {
            J9(this.E.l2().getValue().getSelectable());
            this.f325845d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(List list) {
        ha3.b bVar;
        HashMap<String, String> hashMap;
        if (list != null && !list.isEmpty() && (hashMap = (bVar = (ha3.b) list.get(0)).f404635t) != null && !hashMap.isEmpty()) {
            String str = bVar.f404635t.get("mSchoolName");
            if (Boolean.parseBoolean(bVar.f404635t.get("mSchoolIsSelected")) && this.E.l2().getValue().getSelectable()) {
                this.E.R2(true);
                this.f325849i.setChecked(true);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f325850m.f326007i.postValue(str);
            }
            if (this.f325850m.f326018r0 == 3 && Boolean.parseBoolean(bVar.f404635t.get("isOpenSchool"))) {
                this.E.S2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9(String str) {
        this.f325850m.f326007i.postValue(str);
    }

    private void S9() {
        if (this.f325850m == null) {
            this.f325850m = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        if (this.C == null) {
            this.C = (com.tencent.mobileqq.wink.publish.viewmodel.p) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.p.class);
        }
        if (this.D == null) {
            this.D = (PublishPromotionViewModel) getViewModel(PublishPromotionViewModel.class);
        }
        this.E.l2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bi.this.O9((PublishSettingItemState) obj);
            }
        });
        this.f325850m.f326007i.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.be
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bi.this.P9((String) obj);
            }
        });
        LiveData<List<ha3.b>> liveData = this.f325850m.H;
        if (liveData != null) {
            liveData.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bf
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    bi.this.Q9((List) obj);
                }
            });
        }
        this.C.M1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bi.this.R9((String) obj);
            }
        });
    }

    private void T9() {
        if (!this.E.l2().getValue().getSelectable()) {
            com.tencent.mobileqq.wink.publish.util.f.a(getContext(), this.E.k2());
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return "PublishSchoolPart";
    }

    public void J9(boolean z16) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(this.f325849i, WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_CAMPUS_BUTTON);
        if (!TextUtils.isEmpty(this.f325850m.f326007i.getValue())) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_CAMPUS_OPEN, Integer.valueOf(z16 ? 1 : 0));
        } else {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_CAMPUS_OPEN, null);
        }
        VideoReport.reportEvent("dt_imp", this.f325849i, buildElementParams);
    }

    public void M9() {
        boolean z16;
        if (getHostFragment() != null && getHostFragment().getActivity() != null) {
            HashMap<String, String> K9 = K9(getHostFragment().getActivity().getIntent());
            QLog.d("PublishSchoolPart", 1, "judgeIsOpenSchool keyAttrs = " + K9);
            if (K9 != null && !K9.isEmpty()) {
                if (K9.containsKey(QCircleScheme.AttrQQPublish.SHOULD_OPEN_SCHOOL) && !TextUtils.isEmpty(K9.get(QCircleScheme.AttrQQPublish.SHOULD_OPEN_SCHOOL)) && Integer.parseInt(K9.get(QCircleScheme.AttrQQPublish.SHOULD_OPEN_SCHOOL)) == 1) {
                    this.E.S2(true);
                    this.E.R2(true);
                }
                if (this.f325850m.f326018r0 == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && this.E.l2().getValue().getVisible()) {
                    this.E.S2(true);
                    this.E.R2(true);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("PublishSchoolPart", 1, "[judgeIsOpenSchool] host is null!");
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f325846e = (RelativeLayout) view.findViewById(R.id.f29180ky);
        this.f325847f = (TextView) view.findViewById(R.id.f67703e2);
        this.f325848h = (TextView) view.findViewById(R.id.f164593t60);
        Switch r26 = (Switch) view.findViewById(R.id.f67713e3);
        this.f325849i = r26;
        r26.setText("");
        this.f325846e.setVisibility(8);
        this.f325845d = false;
        this.f325850m = (PublishViewModel) getViewModel(PublishViewModel.class);
        this.C = (com.tencent.mobileqq.wink.publish.viewmodel.p) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.p.class);
        this.D = (PublishPromotionViewModel) getViewModel(PublishPromotionViewModel.class);
        this.E = (PartsStateViewModel) getViewModel(PartsStateViewModel.class);
        this.C.N1();
        L9();
        S9();
        M9();
    }
}
