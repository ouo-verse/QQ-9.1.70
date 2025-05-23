package com.tencent.mobileqq.wink.intermediate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import c83.b;
import c83.c;
import c83.d;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.utils.h;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import t53.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TemplateLibIntermediateFragment extends ImmersivePartFragment {
    private String C;
    private String D;

    private void initIntentData() {
        Intent intent = getHostActivity().getIntent();
        this.C = intent.getStringExtra("KEY_JUMP_TARGET");
        intent.removeExtra("public_fragment_class");
        Object obj = intent.getExtras().get("key_attrs");
        if (obj instanceof HashMap) {
            this.D = (String) ((HashMap) obj).get("libtemplate");
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = intent.getStringExtra("libtemplate");
        }
        if (!TextUtils.isEmpty(this.D)) {
            a.f435443a.j("libTemplate", this.D);
        }
        QLog.d("TemplateLibIntermediateFragment", 1, "initIntentData, mJumpTarget: " + this.C + ", mLibTemplate: " + this.D);
    }

    private void qh() {
        if (getActivity() != null) {
            Intent intent = getActivity().getIntent();
            String stringExtra = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            String stringExtra2 = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
                new WinkPublishQualityReportData();
                WinkPublishReportQueue.INSTANCE.report(builder.eventId(QCirclePublishQualityReporter.E_PICKER_ENTER).traceId(stringExtra).ext2("nolongvideomode").retCode("0").getReportData(), stringExtra2);
            }
        }
    }

    private void rh(View view) {
        if (!wh() || th()) {
            return;
        }
        if (sh()) {
            ((ViewStub) view.findViewById(R.id.f124627jv)).inflate();
        } else {
            ((ViewStub) view.findViewById(R.id.f124637jw)).inflate();
        }
    }

    private boolean sh() {
        return "5".equals(this.C);
    }

    private boolean th() {
        if (!sh() && QQWinkConstants.TEMPLATE_ID_MAOMEME.equals(this.D)) {
            return true;
        }
        return false;
    }

    private boolean uh() {
        if (!"5".equals(this.C) && !"6".equals(this.C)) {
            return false;
        }
        return true;
    }

    private boolean wh() {
        if (uh() && !TextUtils.isEmpty(this.D)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        if (!wh()) {
            return null;
        }
        if (th()) {
            return Arrays.asList(new b(this, this.D));
        }
        if (sh()) {
            return Arrays.asList(new c(this, this.D));
        }
        return Arrays.asList(new d(this, this.D));
    }

    public void finish() {
        ph(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i85;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TemplateLibIntermediateFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        finish();
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        initIntentData();
        l.f();
        super.onCreate(bundle);
        qh();
        if (wh()) {
            h.c(getHostActivity().getIntent());
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        rh(view);
    }

    public void ph(boolean z16) {
        if (!getHostActivity().isFinishing()) {
            getHostActivity().finish();
            if (!z16) {
                getHostActivity().overridePendingTransition(0, 0);
            }
        }
    }

    public void vh(Intent intent) {
        if (!getHostActivity().isFinishing()) {
            startActivity(intent);
            getHostActivity().overridePendingTransition(0, 0);
        }
    }
}
