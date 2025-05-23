package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import fr.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class UpdateAllFullMusicInfoTask extends ParallGroup {
    private ArrayList<FlowMusic> C;
    private ArrayList<FlowMusic> D = new ArrayList<>();
    private List<FlowMusic> E = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private QIMMusicConfigManager f66677m = (QIMMusicConfigManager) f.c(2);

    private void h() {
        if (!this.D.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<FlowMusic> it = this.D.iterator();
            while (it.hasNext()) {
                arrayList.add(new UpdateTransaction(it.next()));
            }
            this.f66677m.K.doMultiDBOperateByTransaction(arrayList);
        }
        ArrayList<FlowMusic> arrayList2 = this.C;
        if (arrayList2 != null) {
            this.f66677m.F(4, true, arrayList2);
        }
    }

    private void i() {
        int i3;
        List<? extends Entity> query = this.f66677m.K.query(FlowMusic.class);
        if (query == null || query.isEmpty()) {
            i3 = 0;
        } else {
            ArrayList<FlowMusic> arrayList = new ArrayList<>(query);
            this.C = arrayList;
            i3 = arrayList.size();
        }
        ArrayList<FlowMusic> arrayList2 = this.C;
        if (arrayList2 != null) {
            Iterator<FlowMusic> it = arrayList2.iterator();
            while (it.hasNext()) {
                FlowMusic next = it.next();
                if (next.albumUrl == null) {
                    this.E.add(next);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpdateAllFullMusicInfoTask", 2, "load db, has load local, size=" + i3);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.ParallGroup, com.tencent.mobileqq.app.automator.c
    public synchronized void a(AsyncStep asyncStep, int i3) {
        FlowMusic flowMusic;
        if ((asyncStep instanceof GetSingleFullMusicInfoTask) && (flowMusic = ((GetSingleFullMusicInfoTask) asyncStep).f66675m) != null && ((GetSingleFullMusicInfoTask) asyncStep).C != null) {
            flowMusic.albumUrl = ((GetSingleFullMusicInfoTask) asyncStep).C.albumUrl;
            flowMusic.url = ((GetSingleFullMusicInfoTask) asyncStep).C.url;
            flowMusic.size = ((GetSingleFullMusicInfoTask) asyncStep).C.size;
            flowMusic.playable = ((GetSingleFullMusicInfoTask) asyncStep).C.playable;
            this.D.add(flowMusic);
        }
        int i16 = this.f195312i - 1;
        this.f195312i = i16;
        if (i16 == 0) {
            h();
            setResult(7);
            this.f195313d = null;
        }
        this.mAutomator.i2(this.f195313d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.ParallGroup, com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        this.f195312i = this.E.size();
        if (!this.E.isEmpty()) {
            for (FlowMusic flowMusic : this.E) {
                if (this.mResult == 8) {
                    return 2;
                }
                AsyncStep getSingleFullMusicInfoTask = new GetSingleFullMusicInfoTask(flowMusic, (ns.a) null);
                getSingleFullMusicInfoTask.mResultListener = this;
                this.mAutomator.a2(getSingleFullMusicInfoTask);
            }
            return 2;
        }
        h();
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.StepGroup, com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        i();
    }
}
