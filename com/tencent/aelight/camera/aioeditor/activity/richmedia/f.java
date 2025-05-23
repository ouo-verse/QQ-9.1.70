package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends u {

    /* renamed from: d, reason: collision with root package name */
    private static final SparseArray<d> f66446d;

    static {
        SparseArray<d> sparseArray = new SparseArray<>();
        f66446d = sparseArray;
        sparseArray.put(3000, d.d(98, 1, 0, f.class));
        sparseArray.put(3005, d.d(98, 12, 0, f.class));
        sparseArray.put(3006, d.d(98, 2, 0, f.class));
        sparseArray.put(2, d.d(98, 5, 0, EditVideoDoodle.class));
        sparseArray.put(4, d.d(98, 3, 0, EditVideoDoodle.class));
        sparseArray.put(3, d.d(98, 6, 0, EditVideoDoodle.class));
        sparseArray.put(7, d.d(98, 4, 0, com.tencent.aelight.camera.aioeditor.takevideo.i.class));
        sparseArray.put(9, d.d(98, 9, 0, EditPicSave.class));
        sparseArray.put(3001, d.d(98, 10, 0, e.class));
        sparseArray.put(3002, d.d(98, 8, 1, h.class));
        sparseArray.put(3003, d.d(98, 8, 2, h.class));
        sparseArray.put(3004, d.d(98, 11, 0, e.class));
    }

    private Set<Integer> j0() {
        HashSet hashSet = new HashSet();
        EditVideoDoodle editVideoDoodle = (EditVideoDoodle) k0(EditVideoDoodle.class);
        if (editVideoDoodle != null && !editVideoDoodle.isEmpty()) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = editVideoDoodle.V().r0();
            if (r06 != null && !r06.isEmpty()) {
                hashSet.add(1);
            }
            if (!editVideoDoodle.V().C0().isEmpty()) {
                hashSet.add(3);
            }
            if (!editVideoDoodle.V().l0().isEmpty()) {
                hashSet.add(4);
            }
        }
        com.tencent.aelight.camera.aioeditor.takevideo.i iVar = (com.tencent.aelight.camera.aioeditor.takevideo.i) k0(com.tencent.aelight.camera.aioeditor.takevideo.i.class);
        if (iVar != null && iVar.j0()) {
            hashSet.add(2);
        }
        return hashSet;
    }

    private <T> T k0(Class<T> cls) {
        Iterator<u> it = this.mParent.Z().iterator();
        while (it.hasNext()) {
            T t16 = (T) ((u) it.next());
            if (cls.isInstance(t16)) {
                return t16;
            }
        }
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        super.editVideoStateChanged(i3, obj);
        d dVar = f66446d.get(i3);
        if (dVar != null) {
            if (i3 == 3005) {
                dVar.a(j0());
            }
            dVar.c();
            u uVar = (u) k0(dVar.b());
            if (uVar instanceof EditVideoDoodle) {
                QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
                return;
            }
            if (uVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.i) {
                QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
                return;
            } else if (uVar instanceof EditPicSave) {
                QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged save report");
                return;
            } else {
                QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged unsupported report");
                return;
            }
        }
        QZLog.w("QzoneEditPicturePartRep", 2, "editVideoStateChanged we are not interested at this edit state for reporting");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj instanceof Object[]) {
                QZLog.d("QzoneEditPicturePartRep", 2, "handleEditVideoMessage " + ((Long) ((Object[]) obj)[0]).longValue() + " " + ((View) ((Object[]) message.obj)[1]));
            }
        }
        return super.handleEditVideoMessage(message);
    }
}
