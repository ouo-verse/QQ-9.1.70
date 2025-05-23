package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeViewNew;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class DoodlePanelNew extends DoodlePanel {
    public static final int[] I = {-437679, -15616, -16269216, -15749121, -10196752, -16777216, -1};
    private static final String[] J = {"\u7ea2\u8272", "\u9ec4\u8272", "\u7eff\u8272", "\u84dd\u8272", "\u7d2b\u8272", "\u9ed1\u8272", "\u767d\u8272"};

    public DoodlePanelNew(Context context) {
        super(context);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel
    protected int a() {
        return this.f68588d == 1 ? R.layout.dtm : R.layout.dti;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel
    public void b() {
        super.b();
        AEDoodlePenWidthSeekBar aEDoodlePenWidthSeekBar = this.C;
        if (aEDoodlePenWidthSeekBar != null) {
            aEDoodlePenWidthSeekBar.setVisibility(8);
        }
        FrameLayout frameLayout = this.f68591h;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel
    public void c(DoodlePanel.PenMode penMode, int i3, float f16) {
        ArrayList arrayList = new ArrayList();
        for (int i16 : I) {
            arrayList.add(Integer.valueOf(i16));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : J) {
            arrayList2.add(str);
        }
        this.f68589e.d(arrayList, arrayList2, true, i3);
        this.C.setProgress(f16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel
    public void setUndoEnabled(boolean z16) {
        ImageView imageView = this.f68590f;
        if (imageView != null) {
            imageView.setEnabled(z16);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 != 0) {
            DoodleColorAndModeView doodleColorAndModeView = this.f68589e;
            if (doodleColorAndModeView instanceof DoodleColorAndModeViewNew) {
                ((DoodleColorAndModeViewNew) doodleColorAndModeView).setDoodleSelectModeViewVisibility(8);
            }
        }
    }

    public DoodlePanelNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
