package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleSelectModeViewNew extends DoodleSelectModeView {

    /* renamed from: h, reason: collision with root package name */
    protected static final int[][] f68084h = {new int[]{R.id.tfv}};

    /* renamed from: i, reason: collision with root package name */
    protected static final int[][] f68085i = {new int[]{R.id.f164653td2}, new int[]{R.id.th5}, new int[]{R.id.td9}, new int[]{R.id.afl}};

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements EditButtonManager.f {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.f
        public void a(View view, int i3) {
            DoodlePanel.PenMode penMode;
            ms.a.f("DoodleSelectModeViewNew", "EditButtonManager--handleFun--index=" + i3);
            if (DoodleSelectModeViewNew.this.f68082d != null) {
                switch (view.getId()) {
                    case R.id.afl /* 2131364460 */:
                        penMode = DoodlePanel.PenMode.ARROW;
                        DoodleSelectModeViewNew.this.d(view, "em_image_edit_draw", 2);
                        break;
                    case R.id.f164653td2 /* 2131364474 */:
                        penMode = DoodlePanel.PenMode.FREE_DRAW;
                        DoodleSelectModeViewNew.this.d(view, "em_image_edit_draw", 1);
                        break;
                    case R.id.td9 /* 2131364491 */:
                        penMode = DoodlePanel.PenMode.OVAL;
                        DoodleSelectModeViewNew.this.d(view, "em_image_edit_draw", 4);
                        break;
                    case R.id.tf6 /* 2131364619 */:
                        penMode = DoodlePanel.PenMode.LINE;
                        break;
                    case R.id.tfv /* 2131364664 */:
                        penMode = DoodlePanel.PenMode.PEN_MODE_SUB_PANEL;
                        break;
                    case R.id.tgk /* 2131364708 */:
                        penMode = DoodlePanel.PenMode.ERASER;
                        break;
                    case R.id.th5 /* 2131364742 */:
                        penMode = DoodlePanel.PenMode.RECT;
                        DoodleSelectModeViewNew.this.d(view, "em_image_edit_draw", 3);
                        break;
                    default:
                        penMode = null;
                        break;
                }
                if (penMode != null) {
                    DoodleSelectModeViewNew.this.f68082d.a(penMode);
                }
            }
        }
    }

    public DoodleSelectModeViewNew(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, String str, int i3) {
        VideoReport.setElementId(view, str);
        Map<String, Object> a16 = kr.a.a();
        a16.put("image_edit_draw_type", Integer.valueOf(i3));
        VideoReport.setElementParams(view, a16);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView
    protected int b() {
        return R.layout.du7;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView
    public void setUseCase(int i3) {
        new com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.a(this, a(i3)).m(new a());
    }

    public DoodleSelectModeViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView
    protected int[][] a(int i3) {
        if (i3 == 1) {
            return f68085i;
        }
        return f68084h;
    }
}
