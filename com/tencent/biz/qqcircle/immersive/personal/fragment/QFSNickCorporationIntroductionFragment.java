package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.bf;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNickCorporationIntroductionFragment extends QFSBaseFragment {
    public static final int S = ImmersiveUtils.dpToPx(28.0f);
    public static final int T = ImmersiveUtils.dpToPx(104.0f);
    private EditText E;
    private TextView F;
    private int G;
    private String H;
    private QFSPersonalEditViewModel.FrequencyItem I;
    private int K;
    private TextView L;
    private TextView M;
    private String N;
    private String P;
    private QUISecNavBar Q;
    private int J = 12;
    private TextWatcher R = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                QFSNickCorporationIntroductionFragment.this.onBackEvent();
                return null;
            }
            if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
                QFSNickCorporationIntroductionFragment.this.Bh();
                return null;
            }
            return null;
        }
    }

    private void Ah() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            int intExtra = getActivity().getIntent().getIntExtra("item_from", 0);
            this.G = intExtra;
            if (intExtra == 2) {
                String stringExtra = getActivity().getIntent().getStringExtra("from_item_message");
                this.H = stringExtra;
                if (stringExtra == null) {
                    this.H = "";
                }
                QLog.d("QFSNickCorporationIntroductionFragment", 1, "fromItemMessage :" + this.H);
                this.N = this.H;
            } else {
                this.I = (QFSPersonalEditViewModel.FrequencyItem) getActivity().getIntent().getSerializableExtra("from_item_message");
                QLog.d("QFSNickCorporationIntroductionFragment", 1, "frequencyItem :" + this.I);
                QFSPersonalEditViewModel.FrequencyItem frequencyItem = this.I;
                if (frequencyItem == null) {
                    QLog.d("QFSNickCorporationIntroductionFragment", 1, "frequencyItem :" + ((Object) null));
                    return;
                }
                this.N = frequencyItem.showText;
            }
            registerDaTongReportPageId();
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        EditText editText;
        if (getActivity() == null || (editText = this.E) == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText().toString().replace("\n", "").replace(" ", ""))) {
            QCircleToast.v(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1927648d), 0);
            return;
        }
        String replaceAll = this.E.getText().toString().replaceAll("\\n+", "\n");
        if (replaceAll.equals(this.N)) {
            getActivity().finish();
            return;
        }
        if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.b(getActivity(), 5);
            return;
        }
        int i3 = this.G;
        if (i3 == 1) {
            this.I.showText = replaceAll;
            com.tencent.biz.qqcircle.immersive.personal.utils.g.e().g(10001, this.I, getActivity());
        } else if (i3 == 2) {
            com.tencent.biz.qqcircle.immersive.personal.utils.g.e().g(10016, replaceAll, getActivity());
        } else if (i3 == 3) {
            this.I.showText = replaceAll;
            com.tencent.biz.qqcircle.immersive.personal.utils.g.e().g(10008, this.I, getActivity());
        }
    }

    private void Ch() {
        this.Q.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
        this.F.setVisibility(0);
        this.L.setVisibility(0);
        this.E.setEnabled(true);
        this.E.setFocusable(true);
        this.E.setFocusableInTouchMode(true);
        this.E.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_primary));
    }

    private void Dh() {
        this.Q.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
        this.F.setVisibility(8);
        this.L.setVisibility(8);
        this.E.setEnabled(false);
        this.E.setFocusable(false);
        this.E.setFocusableInTouchMode(false);
        this.E.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_secondary));
    }

    private void init() {
        String string;
        String string2;
        int i3 = 1;
        if (getActivity() == null) {
            QLog.d("QFSNickCorporationIntroductionFragment", 1, "getActivity :" + ((Object) null));
            return;
        }
        initTitleBar();
        this.E = (EditText) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.btb);
        this.F = (TextView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.ucd);
        this.E.addTextChangedListener(this.R);
        this.L = (TextView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f100515sp);
        this.M = (TextView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.jml);
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        int i16 = this.G;
        if (i16 == 1) {
            layoutParams.height = S;
            this.Q.setCenterText(getContext().getString(R.string.f1927948g));
            this.J = 12;
            this.E.setHint(getContext().getString(R.string.f1927848f));
            this.E.setText(this.I.showText);
            EditText editText = this.E;
            editText.setSelection(editText.getText().length());
            this.E.setSingleLine();
            if (this.I.allowNum > 0) {
                string2 = getResources().getString(R.string.f1924547j, Integer.valueOf(this.I.totalNum), Integer.valueOf(this.I.allowNum));
                Ch();
            } else {
                string2 = getResources().getString(R.string.f1924647k, Integer.valueOf(this.I.totalNum), com.tencent.biz.qqcircle.immersive.personal.utils.g.f());
                Dh();
            }
            this.M.setText(string2);
        } else if (i16 == 2) {
            layoutParams.height = S;
            this.Q.setCenterText(getContext().getString(R.string.f1925347r));
            this.J = 30;
            this.E.setText(this.H);
            EditText editText2 = this.E;
            editText2.setSelection(editText2.getText().length());
        } else if (i16 == 3) {
            layoutParams.height = T;
            this.Q.setCenterText(getContext().getString(R.string.f1927448b));
            this.J = 80;
            this.E.setText(this.I.showText);
            EditText editText3 = this.E;
            editText3.setSelection(editText3.getText().length());
            if (this.I.allowNum > 0) {
                string = getResources().getString(R.string.f1924347h, Integer.valueOf(this.I.totalNum), Integer.valueOf(this.I.allowNum));
                Ch();
            } else {
                string = getResources().getString(R.string.f1924447i, Integer.valueOf(this.I.totalNum), com.tencent.biz.qqcircle.immersive.personal.utils.g.f());
                Dh();
            }
            this.M.setText(string);
        }
        this.L.setText("/" + this.J);
        HashMap hashMap = new HashMap();
        if (this.G != 2) {
            if (this.I.allowNum == 0) {
                i3 = 0;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_CANNOT_CHANGE, Integer.valueOf(i3));
            zh(this.Q.g(BaseAction.ACTION_RIGHT_TEXT), "em_xsj_complete_button", hashMap);
        }
    }

    private void initTitleBar() {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f55572i_);
        this.Q = qUISecNavBar;
        qUISecNavBar.setAutoAdaptTransparent(true);
        this.Q.setLeftImageRes(R.drawable.qui_chevron_left);
        this.Q.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        this.Q.setTitleAlpha(0.0f);
        this.Q.setOnBaseTitleBarClickListener(new a());
    }

    private void zh(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null && !map.isEmpty()) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g4r;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNickCorporationIntroductionFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.biz.qqcircle.immersive.personal.utils.g.e().c();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RFWThemeUtil.setStatusBarColor((Activity) getContext(), QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (((QCircleBaseFragment) this).mContentView == null) {
            return;
        }
        Ah();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
        View view = ((QCircleBaseFragment) this).mContentView;
        if (view == null) {
            return;
        }
        int i3 = this.G;
        if (i3 == 1) {
            VideoReport.setPageId(view, QCircleDaTongConstant.PageId.PG_XSJ_NICKNAME_EDIT_PAGE);
        } else if (i3 == 3) {
            VideoReport.setPageId(view, QCircleDaTongConstant.PageId.PG_XSJ_DESCRIPTION_EDIT_PAGE);
        }
        VideoReport.setPageParams(((QCircleBaseFragment) this).mContentView, new QCircleDTParamBuilder().buildPageParams(getTAG()));
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.traverseExposure();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            String str;
            bf bfVar = new bf(charSequence, QFSNickCorporationIntroductionFragment.this.J);
            QLog.d("QFSNickCorporationIntroductionFragment", 1, "emojiReader length: " + bfVar.d());
            QFSNickCorporationIntroductionFragment qFSNickCorporationIntroductionFragment = QFSNickCorporationIntroductionFragment.this;
            qFSNickCorporationIntroductionFragment.K = Math.min(qFSNickCorporationIntroductionFragment.J, bfVar.d());
            QFSNickCorporationIntroductionFragment.this.F.setText(QFSNickCorporationIntroductionFragment.this.K + "");
            if (bfVar.l()) {
                QQToast.makeText(QFSNickCorporationIntroductionFragment.this.getContext(), QFSNickCorporationIntroductionFragment.this.getContext().getResources().getString(R.string.f1928148i), 0).show();
                EditText editText = QFSNickCorporationIntroductionFragment.this.E;
                if (!TextUtils.isEmpty(QFSNickCorporationIntroductionFragment.this.P)) {
                    str = QFSNickCorporationIntroductionFragment.this.P;
                } else {
                    str = bfVar.e().toString();
                }
                editText.setText(str);
                QFSNickCorporationIntroductionFragment.this.E.setSelection(QFSNickCorporationIntroductionFragment.this.E.length());
                return;
            }
            QFSNickCorporationIntroductionFragment.this.P = bfVar.e().toString();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
