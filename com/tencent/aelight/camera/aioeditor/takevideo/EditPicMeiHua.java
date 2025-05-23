package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class EditPicMeiHua extends u implements ProviderContainerView.b {

    /* renamed from: e, reason: collision with root package name */
    private static List<Integer> f67688e = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private ProviderContainerView f67689d;

    public EditPicMeiHua(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
    }

    public static synchronized void k0(int i3) {
        synchronized (EditPicMeiHua.class) {
            if (f67688e.isEmpty()) {
                if (EditVideoPartManager.v(i3, 8)) {
                    f67688e.add(101);
                }
                if (EditVideoPartManager.v(i3, 64)) {
                    f67688e.add(100);
                }
                if (EditVideoPartManager.v(i3, 2048)) {
                    f67688e.add(102);
                }
            }
        }
    }

    public static boolean l0(int i3) {
        k0(i3);
        return EditVideoPartManager.v(i3, 65536) && !f67688e.isEmpty();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        super.editVideoPrePublish(i3, bVar);
        if (((QIMFilterProviderView) this.f67689d.c(QIMFilterProviderView.class)) != null) {
            boolean z16 = com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().u(j0()) != null;
            bVar.f400391h = z16;
            if (z16 && this.mParent.l0()) {
                bVar.f400395l.f400420f++;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView.b
    public void h() {
        this.mParent.u(10, Boolean.TRUE);
    }

    public int j0() {
        return this.mParent.k0() ? 3 : 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f67689d = (ProviderContainerView) findViewSure(R.id.ryv);
        if (f67688e.isEmpty()) {
            k0(this.mParent.C.f204057f);
        }
        this.f67689d.f(j0(), f67688e);
        this.f67689d.setProviderContainViewListener(this);
        this.f67689d.setEditActivityEntrance(this.mParent.C.k());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        this.f67689d.h();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 == 10) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicMeiHua.1
                @Override // java.lang.Runnable
                public void run() {
                    EditPicMeiHua.this.mParent.u(22, Boolean.TRUE);
                }
            });
            return;
        }
        if (i3 != 21) {
            if (i3 != 22) {
                this.f67689d.setVisibility(4);
                return;
            }
            return;
        }
        this.f67689d.setVisibility(0);
        this.f67689d.i(0);
        if (this.mParent.l0()) {
            com.tencent.mobileqq.shortvideo.c.d("0X800B3CB", this.mParent.C.k());
            com.tencent.mobileqq.shortvideo.c.d("0X800B3CC", this.mParent.C.k());
            this.f67689d.g(101);
        }
    }
}
