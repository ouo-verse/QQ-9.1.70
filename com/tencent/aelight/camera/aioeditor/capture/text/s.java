package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Typeface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes32.dex */
public class s extends w {
    public s(int i3, List<String> list) {
        super(i3, list);
        this.f66889b = BaseAIOUtils.f(36.0f, BaseApplication.getContext().getResources());
        this.f67167s.setTypeface(Typeface.DEFAULT_BOLD);
        N(this.f66889b);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int r() {
        return BaseAIOUtils.f(36.0f, BaseApplication.getContext().getResources());
    }
}
