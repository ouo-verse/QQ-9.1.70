package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import com.tencent.widget.ScrollView;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TranslateSelectableMenu extends a<TextPreviewTranslateActivity> {
    @Override // com.tencent.mobileqq.activity.selectable.a
    protected void g(final PreviewTextContainerView previewTextContainerView) {
        super.g(previewTextContainerView);
        TextPreviewTranslateActivity textPreviewTranslateActivity = (TextPreviewTranslateActivity) this.C.get();
        if (textPreviewTranslateActivity != null) {
            previewTextContainerView.setOutScrollView((ScrollView) textPreviewTranslateActivity.findViewById(R.id.iia));
        }
        previewTextContainerView.setAutoAdjustGravity(false);
        previewTextContainerView.h().post(new Runnable() { // from class: com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1
            @Override // java.lang.Runnable
            public void run() {
                TextView h16 = previewTextContainerView.h();
                h16.setLineSpacing(BaseAIOUtils.f(6.0f, previewTextContainerView.getResources()), 1.0f);
                h16.setTextSize(1, 24.0f);
                h16.setGravity(8388611);
                int f16 = BaseAIOUtils.f(16.0f, previewTextContainerView.getResources());
                int f17 = BaseAIOUtils.f(12.0f, previewTextContainerView.getResources());
                h16.setPadding(f17, f16, f17, f16);
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.selectable.a
    protected void j(PreviewTextContainerView previewTextContainerView, View view) {
        i(ContextCompat.getColorStateList(previewTextContainerView.getContext(), R.color.qui_common_brand_light).getDefaultColor());
        super.j(previewTextContainerView, view);
        ReportController.o(this.f186154m.get(), "dc00898", "", "", "0X800A435", "0X800A435", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.selectable.a, android.view.View.OnClickListener
    public void onClick(View view) {
        AppRuntime appRuntime = this.f186154m.get();
        switch (view.getId()) {
            case R.id.bbi /* 2131366582 */:
                try {
                    BaseMenuUtil.copy(f(), "TextPreview");
                    ReportController.o(this.f186154m.get(), "dc00898", "", "", "0X800A437", "0X800A437", 0, 0, "", "", "", "");
                    break;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TranslateSelectableMenu", 2, e16.toString());
                        return;
                    }
                    return;
                }
            case R.id.c39 /* 2131368247 */:
                if (appRuntime != null) {
                    com.tencent.mobileqq.textpreview.a.b((Activity) view.getContext(), (QQAppInterface) appRuntime, f());
                }
                ReportController.o(this.f186154m.get(), "dc00898", "", "", "0X800A439", "0X800A439", 0, 0, "", "", "", "");
                break;
            case R.id.cjs /* 2131369204 */:
                com.tencent.mobileqq.textpreview.a.c((Activity) view.getContext(), f());
                ReportController.o(this.f186154m.get(), "dc00898", "", "", "0X800A438", "0X800A438", 0, 0, "", "", "", "");
                break;
            case R.id.ilw /* 2131386961 */:
                com.tencent.qqnt.selectable.a.C().n(null);
                ReportController.o(this.f186154m.get(), "dc00898", "", "", "0X800A436", "0X800A436", 0, 0, "", "", "", "");
                break;
        }
        if (view.getId() == R.id.ilw || !com.tencent.qqnt.selectable.a.C().isSelected()) {
            return;
        }
        com.tencent.qqnt.selectable.a.C().z();
    }
}
