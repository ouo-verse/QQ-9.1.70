package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleEditViewNew extends DoodleEditView {
    public DoodleEditViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView
    protected com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f J() {
        return new sr.a(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView, com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f.a
    public void d(c.a aVar, int i3, int i16, float f16, float f17) {
        DynamicTextItem dynamicTextItem;
        if (!(aVar instanceof g.c) || (dynamicTextItem = ((g.c) aVar).f68001z) == null) {
            return;
        }
        if (i16 != 0) {
            if (i16 == 2) {
                if (i3 == -1) {
                    i3 = 0;
                }
                this.K.H1(dynamicTextItem, i3, 1);
                return;
            } else if (i16 != 3) {
                return;
            }
        }
        if (i3 == -1) {
            i3 = 0;
        }
        this.K.H1(dynamicTextItem, i3, 2);
    }
}
