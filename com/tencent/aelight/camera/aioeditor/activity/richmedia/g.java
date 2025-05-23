package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import android.widget.Button;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends EditPicSave {
    private View H;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZLog.d("QzoneEditPicturePartSav", 2, "onClick save button");
            g.this.mParent.t(9);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public g(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        super.editVideoStateChanged(i3, obj);
        this.H.setVisibility((i3 == 0 || i3 == 4) ? 0 : 8);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.H = findViewSure(R.id.hgh);
        ((Button) findViewSure(R.id.cep)).setOnClickListener(new a());
    }
}
