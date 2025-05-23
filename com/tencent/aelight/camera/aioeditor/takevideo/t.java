package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayoutNew;

/* compiled from: P */
/* loaded from: classes32.dex */
public class t extends EditVideoDoodle {
    public t(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager, i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, int i16, Object obj) {
        this.I = false;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    if (i3 == 6 || i3 == i16) {
                        return;
                    }
                    s0();
                    v0(0);
                    return;
                }
                if (i16 == 3) {
                    if (i3 != 6) {
                        s0();
                        this.f67755e.k1();
                        v0(0);
                    }
                    this.f67755e.x1(true);
                    return;
                }
                if (i16 == 4) {
                    if (i3 != 5) {
                        s0();
                        DoodleLayout doodleLayout = this.f67755e;
                        if (doodleLayout instanceof DoodleLayoutNew) {
                            ((DoodleLayoutNew) doodleLayout).Z1();
                        } else {
                            doodleLayout.m1();
                        }
                        v0(0);
                        return;
                    }
                    return;
                }
                if (i16 == 7) {
                    v0(8);
                    return;
                }
                if (i16 == 8) {
                    return;
                }
                if (i16 != 17 && i16 != 18 && i16 != 21) {
                    if (i16 == 25) {
                        if (i3 != 5) {
                            s0();
                            this.f67755e.p1();
                            v0(0);
                            return;
                        }
                        return;
                    }
                    switch (i16) {
                        case 12:
                        case 13:
                        case 14:
                            break;
                        default:
                            v0(0);
                            return;
                    }
                }
            }
            v0(0);
            this.f67755e.z1();
            this.f67755e.x1(true);
            return;
        }
        v0(0);
        this.f67755e.z1();
        this.f67755e.r1(false);
    }
}
