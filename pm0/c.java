package pm0;

import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ams.dsdk.data.TemplateInfo;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.gdtad.config.data.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements TemplateManager.UpdateTemplateListenerV2 {
    private void a(TemplateInfo templateInfo, int i3) {
        if (templateInfo == null) {
            QLog.e("GdtMotiveHippyTemplateUpdateListener", 1, "[reportForAnalysis] error, templateInfo is null");
            return;
        }
        if (!b(templateInfo.getTemplateId())) {
            return;
        }
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[reportForAnalysis] eventId:" + i3 + " " + templateInfo);
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(BaseApplication.getContext(), i3, gdt_analysis_eventVar);
        gdt_analysis_eventVar.carrierCode = templateInfo.getTemplateId();
        gdt_analysis_eventVar.reason = templateInfo.getDownloadType();
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(BaseApplication.getContext()), new AdAnalysisEvent(gdt_analysis_eventVar, 102));
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtMotiveHippyTemplateUpdateListener", 1, "[shouldReportForAnalysis] error, template id is empty");
            return false;
        }
        h i3 = wm0.b.m().i();
        if (i3 == null) {
            QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[shouldReportForAnalysis] return false, config is null");
            return false;
        }
        String[] strArr = i3.templateIdList;
        if (strArr == null) {
            QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[shouldReportForAnalysis] return false, config.templateIdList is null");
            return false;
        }
        if (strArr.length <= 0) {
            QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[shouldReportForAnalysis] return false, config.templateIdList is empty");
            return false;
        }
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onFinish() {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onFinish]");
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemCancelled(TemplateInfo templateInfo) {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onItemCancelled] " + templateInfo);
        a(templateInfo, gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_CANCELED);
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListenerV2
    public void onItemExisted(TemplateInfo templateInfo) {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onItemExisted] " + templateInfo);
        a(templateInfo, 200002);
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemFailed(TemplateInfo templateInfo) {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onItemFailed] " + templateInfo);
        a(templateInfo, gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_FAILED);
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemStart(TemplateInfo templateInfo) {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onItemStart] " + templateInfo);
        a(templateInfo, gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_START);
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onItemSuccess(TemplateInfo templateInfo) {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onItemSuccess] " + templateInfo);
        a(templateInfo, gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_SUCCESS);
    }

    @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
    public void onStart() {
        QLog.i("GdtMotiveHippyTemplateUpdateListener", 1, "[onStart]");
    }
}
