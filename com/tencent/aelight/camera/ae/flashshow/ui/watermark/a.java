package com.tencent.aelight.camera.ae.flashshow.ui.watermark;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.mobileqq.R;
import com.tencent.ttpic.baseutils.string.StringUtils;
import cooperation.qzone.QZoneHelper;
import java.util.List;
import lq.b;
import org.light.bean.WMElement;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends lq.a {
    private static boolean F = false;
    private boolean C;
    private WMElement D;
    private LSWatermarkEditView E;

    /* renamed from: m, reason: collision with root package name */
    private LSMiddleCameraUnit f65094m;

    public a(Activity activity, View view, b bVar) {
        super(activity, view, bVar);
        this.C = false;
        this.f65094m = (LSMiddleCameraUnit) bVar.b(65537, new Object[0]);
    }

    private void m() {
        ViewStub viewStub;
        WMElement wMElement;
        List<WMElement> C1 = this.f65094m.C1();
        if (C1 != null && !C1.isEmpty()) {
            if (C1.size() == 1 && (wMElement = C1.get(0)) != null && WMElement.TYPE_EDITABLE_LOCATION.equals(wMElement.type)) {
                ms.a.a("LSWaterMarkEditorPart", "only jump to poi");
                AESelectLocationFragment.th(this.f415377f, 203);
                this.C = true;
                this.D = wMElement;
                return;
            }
            this.C = false;
            if (this.E == null && (viewStub = (ViewStub) this.f415377f.findViewById(R.id.rqf)) != null) {
                viewStub.inflate();
                LSWatermarkEditView lSWatermarkEditView = (LSWatermarkEditView) this.f415377f.findViewById(R.id.rqe);
                this.E = lSWatermarkEditView;
                lSWatermarkEditView.d(this.f415377f, this.f415375d);
            }
            LSWatermarkEditView lSWatermarkEditView2 = this.E;
            if (lSWatermarkEditView2 != null) {
                lSWatermarkEditView2.e(C1);
                return;
            }
            return;
        }
        ms.a.c("LSWaterMarkEditorPart", "showWaterMarkEdit---getEditableWMElements is null");
    }

    @Override // lq.a
    public void g(int i3, int i16, Intent intent) {
        LSWatermarkEditView lSWatermarkEditView;
        super.g(i3, i16, intent);
        if (i3 == 203 && i16 == -1) {
            String stringExtra = intent.getStringExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
            ms.a.a("LSWaterMarkEditorPart", "onActivityResult" + stringExtra);
            boolean z16 = this.C;
            if (!z16 && (lSWatermarkEditView = this.E) != null) {
                lSWatermarkEditView.setWaterMarkLocation(stringExtra);
            } else {
                if (!z16 || this.D == null) {
                    return;
                }
                this.D.setLocation(StringUtils.removeUTF8Emoji(stringExtra).trim());
            }
        }
    }

    @Override // lq.a
    public Object d(int i3, Object... objArr) {
        if (i3 != 589826) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(F);
    }

    @Override // lq.a
    public void l(int i3, Object... objArr) {
        switch (i3) {
            case 589825:
                m();
                if (this.C) {
                    F = false;
                    return;
                } else {
                    F = true;
                    return;
                }
            case 589826:
                LSWatermarkEditView lSWatermarkEditView = this.E;
                if (lSWatermarkEditView != null && lSWatermarkEditView.getVisibility() == 0) {
                    this.E.setVisibility(8);
                }
                F = false;
                return;
            default:
                return;
        }
    }

    @Override // lq.a
    protected void e() {
    }
}
