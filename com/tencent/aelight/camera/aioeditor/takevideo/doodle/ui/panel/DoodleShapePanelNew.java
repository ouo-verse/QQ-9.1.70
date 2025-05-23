package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class DoodleShapePanelNew extends DoodleShapePanel {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f68603i = {-437679, -15616, -16269216, -15749121, -10196752, -16777216, -1};

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f68604m = {"\u7ea2\u8272", "\u9ec4\u8272", "\u7eff\u8272", "\u84dd\u8272", "\u7d2b\u8272", "\u9ed1\u8272", "\u767d\u8272"};

    public DoodleShapePanelNew(Context context) {
        super(context);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel
    protected int b() {
        return R.layout.dtk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel
    public void c() {
        super.c();
        AEDoodlePenWidthSeekBar aEDoodlePenWidthSeekBar = this.f68597e;
        if (aEDoodlePenWidthSeekBar != null) {
            aEDoodlePenWidthSeekBar.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel
    public void setSelectedColorAndWidth(int i3, float f16) {
        ArrayList arrayList = new ArrayList();
        for (int i16 : f68603i) {
            arrayList.add(Integer.valueOf(i16));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : f68604m) {
            arrayList2.add(str);
        }
        this.f68596d.d(arrayList, arrayList2, true, i3);
        this.f68597e.setProgress(f16);
    }

    public DoodleShapePanelNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
