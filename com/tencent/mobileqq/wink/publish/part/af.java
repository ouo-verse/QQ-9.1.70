package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.publish.event.PublishAssociateTagEvent;
import com.tencent.mobileqq.wink.publish.event.PublishChangeTagPanelStateEvent;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.util.WinkPublishConfigUtil;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes21.dex */
public class af extends j implements View.OnClickListener, SimpleEventReceiver {
    public static final String L = UploadConstants.TAG + "PublishLabelPart";
    private TextView C;
    private ExtendEditText D;
    private String E;
    private String F;
    private String G;
    private int H;
    private String I;
    InputFilter J = new InputFilter() { // from class: com.tencent.mobileqq.wink.publish.part.ac
        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            CharSequence Z9;
            Z9 = af.Z9(charSequence, i3, i16, spanned, i17, i18);
            return Z9;
        }
    };
    TextWatcher K = new a();

    /* renamed from: d, reason: collision with root package name */
    private PublishViewModel f325796d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.viewmodel.i f325797e;

    /* renamed from: f, reason: collision with root package name */
    private PartsStateViewModel f325798f;

    /* renamed from: h, reason: collision with root package name */
    private PublishTagViewModel f325799h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f325800i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f325801m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            if (QLog.isColorLevel()) {
                String str2 = af.L;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("afterTextChanged s:");
                if (editable != null) {
                    str = editable.toString();
                } else {
                    str = "null";
                }
                sb5.append(str);
                QLog.e(str2, 1, sb5.toString());
            }
            if (editable == null) {
                return;
            }
            try {
                if (editable.toString().equals(af.this.F)) {
                    return;
                }
                af.this.F = editable.toString();
                af.this.da();
            } catch (Exception e16) {
                QLog.e(af.L, 1, e16, new Object[0]);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (QLog.isColorLevel()) {
                QLog.e(af.L, 1, "beforeTextChanged: s:" + charSequence.toString() + " start:" + i3 + " count:" + i16 + " after:" + i17);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            boolean z16;
            int i18;
            if (charSequence == null) {
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.e(af.L, 1, "onTextChanged s:" + ((Object) charSequence) + " start:" + i3 + " count:" + i17 + " before:" + i16);
                }
                if (!charSequence.toString().equals(af.this.E)) {
                    af.this.E = charSequence.toString();
                    if (i17 == 1 && charSequence.subSequence(i3, i3 + 1).toString().equals("#")) {
                        af.this.H = i3;
                        if (PublishViewModel.I3()) {
                            af.this.f325799h.Z1();
                        }
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i17 == 0 && i3 - 1 >= 0 && charSequence.charAt(i18) == '#') {
                        af.this.H = i18;
                        if (PublishViewModel.I3()) {
                            af.this.f325799h.Z1();
                        }
                        z16 = true;
                    }
                    int R9 = af.this.R9(charSequence, i3, i16, i17);
                    if (R9 == -1) {
                        af.this.G = null;
                    } else {
                        af afVar = af.this;
                        if (!afVar.X9(charSequence.subSequence(R9, afVar.D.getSelectionStart()).toString())) {
                            af.this.G = null;
                        } else {
                            af afVar2 = af.this;
                            afVar2.G = charSequence.subSequence(R9 + 1, afVar2.D.getSelectionStart()).toString();
                            af.this.H = R9;
                        }
                    }
                    if (af.this.G == null && !z16) {
                        SimpleEventBus.getInstance().dispatchEvent(new PublishChangeTagPanelStateEvent(1));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e(af.L, 1, "mInputTag:" + af.this.G + " mTagStartPos:" + af.this.H + " isInsertJing:" + z16);
                    }
                }
            } catch (Exception e16) {
                QLog.e(af.L, 1, e16, new Object[0]);
            }
        }
    }

    public static void P9(View view, String str, int i3) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TOPIC_RECOMMEND_ITEM);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(view, str);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_topic_name", str);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TOPIC_RECOMMEND_REASON, Integer.valueOf(i3));
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void S9() {
        this.f325800i.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        this.C.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        if (W9()) {
            this.f325801m.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        } else {
            this.f325801m.setImageResource(R.drawable.kns);
        }
    }

    private void T9(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f31980si);
        this.f325800i = linearLayout;
        linearLayout.setOnClickListener(this);
        VideoReport.setElementId(this.f325800i, WinkDaTongReportConstant.ElementId.EM_XSJ_TOPIC_ICON);
        this.f325801m = (ImageView) view.findViewById(R.id.f31950sf);
        this.C = (TextView) view.findViewById(R.id.f31960sg);
        S9();
        ea();
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_qqvideo_topicguid_1505");
    }

    private void U9() {
        try {
            this.H = this.D.getSelectionStart();
            this.D.getText().insert(this.H, "#");
            this.D.setSelection(this.H + 1);
            if (PublishViewModel.I3()) {
                this.f325799h.Z1();
            }
            SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(true));
        } catch (Exception e16) {
            QLog.e(L, 1, e16, new Object[0]);
        }
    }

    private void V9() {
        try {
            String obj = this.D.getText().toString();
            String str = "#\u5fc3\u60c5\u65e5\u8bb0 #" + this.I + " ";
            if (TextUtils.isEmpty(obj)) {
                this.H = 0;
                this.D.setText(str);
                this.D.setSelection(str.length());
            } else {
                int selectionStart = this.D.getSelectionStart();
                int selectionEnd = this.D.getSelectionEnd();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append((CharSequence) obj, 0, selectionStart);
                stringBuffer.append(str);
                stringBuffer.append(obj.substring(selectionEnd));
                this.H = selectionStart;
                this.D.setText(stringBuffer);
                this.D.setSelection(selectionStart + str.length());
            }
            SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(true));
        } catch (Exception e16) {
            QLog.e(L, 1, e16, new Object[0]);
        }
    }

    private boolean W9() {
        boolean isExperiment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_qqvideo_topicguid_1505");
        if (!this.f325796d.A2() && isExperiment) {
            return true;
        }
        return false;
    }

    private boolean Y9() {
        String str;
        MetaMaterial metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (metaMaterial != null && (str = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) != null) {
            this.I = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MOOD_LABEL_CN_KEY);
            return str.equals(QQWinkConstants.BUSINESS_ZSHOW_NAME);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CharSequence Z9(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        if (charSequence.length() > 0 && charSequence.charAt(0) == '#') {
            WinkPublishConfigUtil winkPublishConfigUtil = WinkPublishConfigUtil.f325969a;
            int size = winkPublishConfigUtil.f(spanned.toString()).size();
            if (size >= winkPublishConfigUtil.e()) {
                QLog.d(L, 1, "[insertRecommendTag] exceed max tag count, " + size);
                QCircleToast.k(QCircleToast.f91644d, winkPublishConfigUtil.d(), 0, true);
                return "";
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(PublishTagViewModel.TagData tagData) {
        ImageView imageView = this.f325801m;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.kns);
        }
    }

    private void ba() {
        if (this.f325796d == null) {
            this.f325796d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        this.f325799h.R1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                af.this.aa((PublishTagViewModel.TagData) obj);
            }
        });
    }

    private void ca(String str) {
        try {
            int selectionStart = this.D.getSelectionStart();
            Editable text = this.D.getText();
            int i3 = this.H;
            text.replace(i3, selectionStart + i3, str + " ");
            this.D.setSelection(this.H + str.length() + 2);
        } catch (Exception e16) {
            QLog.e(L, 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        if (!TextUtils.isEmpty(this.G)) {
            if (QLog.isColorLevel()) {
                QLog.e(L, 1, "requestAssociateLable, mInputTag:" + this.G);
            }
            this.f325799h.a2(this.G, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(L, 1, "requestAssociateLable, mInputTag is null");
        }
        this.f325799h.g2("");
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return L;
    }

    public void Q9() {
        this.f325796d.W1();
        this.f325799h.N1();
    }

    public int R9(CharSequence charSequence, int i3, int i16, int i17) {
        try {
            int selectionStart = this.D.getSelectionStart();
            if (selectionStart != 0 && charSequence != null && charSequence.length() != 0 && charSequence.toString().substring(0, selectionStart).contains("#")) {
                return charSequence.toString().substring(0, selectionStart).lastIndexOf("#", selectionStart);
            }
            return -1;
        } catch (Exception e16) {
            QLog.e(L, 1, e16, new Object[0]);
            return -1;
        }
    }

    public boolean X9(String str) {
        return str.matches("^#[\uff0ca-z0-9A-Z\u4e00-\u9fa5]+$");
    }

    public void ea() {
        boolean W9 = W9();
        QLog.d(L, 1, "[showHashTagTipIfNeed] isExp=" + W9);
        if (W9) {
            final WinkPublishConfigUtil winkPublishConfigUtil = WinkPublishConfigUtil.f325969a;
            if (!winkPublishConfigUtil.g()) {
                QUIDefaultBubbleTip.r(this.f325800i.getContext()).S(this.f325800i).o0("\u6dfb\u52a0\u8bdd\u9898\u83b7\u66f4\u591a\u63a8\u8350\u54e6").k0(0).R(1).m0(3).h0("hashTagTip").s0();
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                Objects.requireNonNull(winkPublishConfigUtil);
                uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkPublishConfigUtil.this.j();
                    }
                }, 2000L);
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE);
                hashMap.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_TOPIC_GUIDE_POP);
                VideoReport.reportEvent("ev_xsj_abnormal_imp", hashMap);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(PublishAssociateTagEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f31980si) {
            U9();
        }
        if (id5 == R.id.f31920sc) {
            String str = L;
            if (!FastClickUtils.isFastDoubleClick(str)) {
                w53.b.f(str, "onAtClick");
                SimpleEventBus.getInstance().dispatchEvent(new PublishChangeTagPanelStateEvent(1));
                SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
                com.tencent.mobileqq.wink.publish.util.c.e(getActivity(), true, 1, uq3.c.Z2(), this.f325797e.N1(), 1001);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QLog.d(L, 1, "onInitView...");
        if (this.f325799h == null) {
            this.f325799h = (PublishTagViewModel) getViewModel(PublishTagViewModel.class);
        }
        if (this.f325798f == null) {
            this.f325798f = (PartsStateViewModel) getViewModel(PartsStateViewModel.class);
        }
        if (this.f325796d == null) {
            this.f325796d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        this.f325797e = (com.tencent.mobileqq.wink.publish.viewmodel.i) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.i.class);
        this.D = (ExtendEditText) view.findViewById(R.id.bys);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f31920sc);
        linearLayout.setOnClickListener(this);
        VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_AT_ICON);
        VideoReport.setElementParams(linearLayout, WinkDTParamBuilder.buildElementParams());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", linearLayout, null);
        if (PublishViewModel.I3()) {
            this.D.addTextChangedListener(this.K);
        }
        if (W9()) {
            this.D.setFilters(new InputFilter[]{this.J});
        }
        T9(view);
        ba();
        if (Y9()) {
            V9();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof PublishAssociateTagEvent) {
            ca(((PublishAssociateTagEvent) simpleBaseEvent).tag);
            SimpleEventBus.getInstance().dispatchEvent(new PublishChangeTagPanelStateEvent(1));
            SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(true));
        }
    }
}
