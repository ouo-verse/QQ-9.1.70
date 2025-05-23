package com.tencent.biz.qqcircle.debug.mocklbs;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsRsp;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.requests.QCircleGetRainbowKVConfRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.Random;
import qqcircle.QQCircleConfig$GetRainbowKVConfRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    private static final Random f84318i = new Random();

    /* renamed from: d, reason: collision with root package name */
    private ImageView f84319d;

    /* renamed from: e, reason: collision with root package name */
    private RadioGroup f84320e;

    /* renamed from: f, reason: collision with root package name */
    private MockLbsRsp f84321f;

    /* renamed from: h, reason: collision with root package name */
    private MockLbsInfo f84322h = QCirclePluginGlobalInfo.j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.debug.mocklbs.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0864a implements RadioGroup.OnCheckedChangeListener {
        C0864a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            MockLbsInfo B9 = a.this.B9(i3);
            if (B9 != null) {
                QCirclePluginGlobalInfo.R(B9);
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleConfig$GetRainbowKVConfRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleConfig$GetRainbowKVConfRsp qQCircleConfig$GetRainbowKVConfRsp) {
            QLog.i("QCircleMockLbsPart", 1, "GetRainbowKVConfRsp isSuccess\uff1a" + z16 + " errormsg:" + str + " retCode:" + j3);
            a.this.D9(z16, qQCircleConfig$GetRainbowKVConfRsp);
        }
    }

    private void A9() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MockLbsInfo B9(int i3) {
        if (!C9()) {
            return null;
        }
        for (int i16 = 0; i16 < this.f84321f.administrative_district.size(); i16++) {
            if (i3 == this.f84321f.administrative_district.get(i16).resId) {
                return this.f84321f.administrative_district.get(i16);
            }
        }
        return null;
    }

    private boolean C9() {
        ArrayList<MockLbsInfo> arrayList;
        MockLbsRsp mockLbsRsp = this.f84321f;
        if (mockLbsRsp != null && (arrayList = mockLbsRsp.administrative_district) != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(boolean z16, QQCircleConfig$GetRainbowKVConfRsp qQCircleConfig$GetRainbowKVConfRsp) {
        if (z16 && qQCircleConfig$GetRainbowKVConfRsp.data.get() != null) {
            try {
                this.f84321f = (MockLbsRsp) new Gson().fromJson(qQCircleConfig$GetRainbowKVConfRsp.data.get(), MockLbsRsp.class);
                if (C9()) {
                    initRadios(this.f84321f.administrative_district);
                }
            } catch (Exception unused) {
                QLog.i("QCircleMockLbsPart", 1, "GetRainbowKVConfRsp json exception!\uff1a json is:" + qQCircleConfig$GetRainbowKVConfRsp.data.get());
            }
        }
    }

    private RadioButton generateRadioButton(String str, boolean z16) {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setText(str);
        radioButton.setChecked(z16);
        radioButton.setTextColor(QCircleSkinHelper.getInstance().getColor(getContext(), R.color.qvideo_skin_color_text_primary));
        radioButton.setPadding(30, 0, 0, 0);
        return radioButton;
    }

    private void initData() {
        VSNetworkHelper.getInstance().sendRequest(new QCircleGetRainbowKVConfRequest("4aa831c0-51c9-4dc9-9ab2-1e99ec9031f0", "trpc.feedcloud.commgateway.CommGateway.TEST", "district_latitude_longitude.json"), new b());
    }

    private void initRadioGroup() {
        this.f84320e.setOnCheckedChangeListener(new C0864a());
    }

    private void initRadios(ArrayList<MockLbsInfo> arrayList) {
        boolean z16;
        this.f84320e.removeAllViews();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            MockLbsInfo mockLbsInfo = arrayList.get(i3);
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            MockLbsInfo mockLbsInfo2 = this.f84322h;
            if (mockLbsInfo2 != null) {
                z16 = mockLbsInfo2.district.equals(mockLbsInfo.district);
            }
            mockLbsInfo.resId = f84318i.nextInt();
            RadioButton generateRadioButton = generateRadioButton(mockLbsInfo.district, z16);
            generateRadioButton.setId(mockLbsInfo.resId);
            generateRadioButton.setTag(mockLbsInfo);
            this.f84320e.addView(generateRadioButton, new RadioGroup.LayoutParams(-1, -2));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleMockLbsPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            A9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        this.f84319d = imageView;
        imageView.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(this.f84319d);
        }
        this.f84320e = (RadioGroup) view.findViewById(R.id.f74173vj);
        initRadioGroup();
        initData();
    }
}
