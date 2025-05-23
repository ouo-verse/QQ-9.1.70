package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment;
import com.tencent.aelight.camera.ae.part.c;
import com.tencent.mobileqq.R;
import com.tencent.ttpic.baseutils.string.StringUtils;
import cooperation.qzone.QZoneHelper;
import java.util.List;
import org.light.bean.WMElement;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends com.tencent.aelight.camera.ae.part.b {

    /* renamed from: i, reason: collision with root package name */
    private static boolean f63429i = false;

    /* renamed from: d, reason: collision with root package name */
    private AEPituCameraUnit f63430d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f63431e;

    /* renamed from: f, reason: collision with root package name */
    private WMElement f63432f;

    /* renamed from: h, reason: collision with root package name */
    private WatermarkEditView f63433h;

    public a(Activity activity, View view, c cVar) {
        super(activity, view, cVar);
        this.f63431e = false;
        this.f63430d = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    private void n() {
        ViewStub viewStub;
        WMElement wMElement;
        List<WMElement> O1 = this.f63430d.O1();
        if (O1 != null && !O1.isEmpty()) {
            if (O1.size() == 1 && (wMElement = O1.get(0)) != null && WMElement.TYPE_EDITABLE_LOCATION.equals(wMElement.type)) {
                ms.a.a("AEWaterMarkEditorPart", "only jump to poi");
                AESelectLocationFragment.th(this.mActivity, 203);
                this.f63431e = true;
                this.f63432f = wMElement;
                return;
            }
            this.f63431e = false;
            if (this.f63433h == null && (viewStub = (ViewStub) this.mActivity.findViewById(R.id.rqf)) != null) {
                viewStub.inflate();
                WatermarkEditView watermarkEditView = (WatermarkEditView) this.mActivity.findViewById(R.id.rqe);
                this.f63433h = watermarkEditView;
                watermarkEditView.d(this.mActivity, this.mPartManager);
            }
            WatermarkEditView watermarkEditView2 = this.f63433h;
            if (watermarkEditView2 != null) {
                watermarkEditView2.e(O1);
                return;
            }
            return;
        }
        ms.a.c("AEWaterMarkEditorPart", "showWaterMarkEdit---getEditableWMElements is null");
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        WatermarkEditView watermarkEditView;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 203 && i16 == -1) {
            String stringExtra = intent.getStringExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
            ms.a.a("AEWaterMarkEditorPart", "onActivityResult" + stringExtra);
            boolean z16 = this.f63431e;
            if (!z16 && (watermarkEditView = this.f63433h) != null) {
                watermarkEditView.setWaterMarkLocation(stringExtra);
            } else {
                if (!z16 || this.f63432f == null) {
                    return;
                }
                this.f63432f.setLocation(StringUtils.removeUTF8Emoji(stringExtra).trim());
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public Object get(int i3, Object... objArr) {
        if (i3 != 589826) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(f63429i);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 589825:
                n();
                if (this.f63431e) {
                    f63429i = false;
                    return;
                } else {
                    f63429i = true;
                    return;
                }
            case 589826:
                WatermarkEditView watermarkEditView = this.f63433h;
                if (watermarkEditView != null && watermarkEditView.getVisibility() == 0) {
                    this.f63433h.setVisibility(8);
                }
                f63429i = false;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
    }
}
