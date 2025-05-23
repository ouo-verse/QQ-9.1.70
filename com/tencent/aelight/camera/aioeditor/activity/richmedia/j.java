package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Bundle;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final SparseArray<d> f66461f;

    /* renamed from: d, reason: collision with root package name */
    private Set<Integer> f66462d;

    /* renamed from: e, reason: collision with root package name */
    d.c f66463e;

    static {
        SparseArray<d> sparseArray = new SparseArray<>();
        f66461f = sparseArray;
        sparseArray.put(3000, d.d(99, 1, 0, j.class));
        sparseArray.put(2, d.d(99, 3, 0, EditVideoDoodle.class));
        sparseArray.put(3, d.d(99, 5, 0, EditVideoDoodle.class));
        sparseArray.put(4, d.d(99, 7, 0, EditVideoDoodle.class));
        sparseArray.put(1, d.d(99, 4, 0, com.tencent.aelight.camera.aioeditor.capture.music.c.class));
        sparseArray.put(14, d.d(99, 6, 0, EditProviderPart.class));
        sparseArray.put(12, d.d(99, 9, 0, EditVideoSpeedFilter.class));
        sparseArray.put(13, d.d(99, 8, 0, EditProviderPart.class));
        sparseArray.put(4001, d.d(99, 16, 0, EditProviderPart.class));
        sparseArray.put(3005, d.d(99, 2, 0, j.class));
        sparseArray.put(3006, d.d(99, 15, 0, j.class));
        sparseArray.put(3002, d.d(99, 10, 1, j.class));
        sparseArray.put(3003, d.d(99, 10, 2, j.class));
        sparseArray.put(3001, d.d(99, 13, 0, j.class));
        sparseArray.put(3007, d.d(99, 12, 1, j.class));
        sparseArray.put(3008, d.d(99, 12, 2, j.class));
        sparseArray.put(3004, d.d(99, 14, 0, j.class));
        sparseArray.put(3009, d.d(99, 11, 0, j.class));
    }

    public j(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f66462d = new HashSet();
        this.f66463e = new a();
    }

    private void j0() {
        for (u uVar : this.mParent.Z()) {
            if (uVar instanceof EditVideoDoodle) {
                EditVideoDoodle editVideoDoodle = (EditVideoDoodle) uVar;
                if (!editVideoDoodle.V().X0()) {
                    com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = editVideoDoodle.V().r0();
                    if (r06 != null && !r06.isEmpty()) {
                        this.f66462d.add(5);
                    }
                    if (!editVideoDoodle.V().C0().isEmpty()) {
                        this.f66462d.add(1);
                    }
                    if (!editVideoDoodle.V().l0().isEmpty()) {
                        this.f66462d.add(3);
                    }
                }
            }
            if (uVar instanceof EditProviderPart) {
                JSONObject jSONObject = new JSONObject();
                ((EditProviderPart) uVar).B0(jSONObject);
                if (jSONObject.has(EditProviderPart.T)) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(EditProviderPart.T);
                        if (jSONObject2.has("comboItem")) {
                            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", " has combo item");
                            this.f66462d.add(4);
                        } else if (jSONObject2.has("musicItem")) {
                            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", " has music item");
                            this.f66462d.add(2);
                        } else if (jSONObject2.has("filterItem")) {
                            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", " has filter item");
                        }
                    } catch (JSONException e16) {
                        QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", e16);
                    }
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        super.editVideoPrePublish(i3, bVar);
        if (bVar.f400387d.saveMode != 0) {
            this.f66462d.add(7);
        }
        j0();
        editVideoStateChanged(3006, null);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        super.editVideoStateChanged(i3, obj);
        d dVar = f66461f.get(i3);
        if (dVar != null) {
            if (i3 == 3006) {
                dVar.a(this.f66462d);
            }
            dVar.c();
        } else {
            QZLog.w("QzoneEditVideoPartRepor", 2, "editVideoStateChanged we are not interested at this edit state " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        int i3;
        if (message.what == 9 && (i3 = message.arg1) == 12) {
            editVideoStateChanged(i3, null);
        }
        return super.handleEditVideoMessage(message);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        editVideoStateChanged(3000, null);
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).k(this.f66463e);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).G(this.f66463e);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements d.c {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
        public void d(com.tencent.aelight.camera.aioeditor.capture.data.j jVar, boolean z16, int i3, Bundle bundle) {
            if (z16) {
                j.this.editVideoStateChanged(4001, null);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
        public void e(m.a aVar) {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
        public void f(com.tencent.aelight.camera.aioeditor.capture.data.h hVar) {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
        public void j(com.tencent.aelight.camera.aioeditor.capture.data.h hVar, boolean z16, int i3, Bundle bundle) {
        }
    }
}
