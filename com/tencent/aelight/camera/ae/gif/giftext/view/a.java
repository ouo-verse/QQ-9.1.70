package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends GifAnimationDrawable {
    public a(Context context, ArrayList<String> arrayList, long j3) {
        super(context, arrayList, j3);
    }

    @Override // com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable, android.graphics.drawable.Animatable
    public void start() {
        if (!this.f65422i) {
            if (QLog.isColorLevel()) {
                QLog.d("zswp20pro", 2, "start");
            }
            this.f65422i = true;
            this.f65423m = true;
            this.J = false;
            n();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("zswp20pro", 2, "start but isRunning");
        }
    }
}
