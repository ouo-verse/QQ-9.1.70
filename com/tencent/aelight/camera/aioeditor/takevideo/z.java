package com.tencent.aelight.camera.aioeditor.takevideo;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class z extends u implements q {

    /* renamed from: d, reason: collision with root package name */
    private int f68975d;

    /* renamed from: e, reason: collision with root package name */
    private TransferData f68976e;

    public z(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f68975d = 0;
        this.f68976e = new TransferData();
    }

    private void j0(long j3) {
        ArrayList<Long> positions = this.f68976e.getPositions();
        if (positions != null && positions.size() != 0) {
            Iterator<Long> it = positions.iterator();
            long j16 = 0;
            while (it.hasNext()) {
                Long next = it.next();
                if (next.longValue() - j16 < 2000) {
                    this.f68975d = 2;
                    return;
                }
                j16 = next.longValue();
            }
            if (j3 - j16 < 2000) {
                this.f68975d = 2;
                return;
            } else {
                this.f68975d = 0;
                return;
            }
        }
        this.f68975d = 1;
    }

    public static int k0(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        return -1;
    }

    public static long l0() {
        return -200L;
    }

    private boolean m0() {
        TransferData transferData = this.f68976e;
        return transferData.mConfigData.mID != -1 && transferData.getPositions().size() > 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        super.editVideoPrePublish(i3, bVar);
        if (n0()) {
            String jSONObject = this.f68976e.toJSONObject();
            if (TextUtils.isEmpty(jSONObject)) {
                return;
            }
            bVar.f400387d.putExtra("transfer_effect_data", jSONObject);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.q
    public void l() {
        int i3 = this.f68975d;
        if (i3 == 1) {
            QQToast.makeText(getContext(), R.string.i4l, 0).show();
        } else if (i3 == 2) {
            QQToast.makeText(getContext(), R.string.i4k, 0).show();
        }
    }

    public boolean n0() {
        return this.f68975d == 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.q
    public void o(int i3) {
        x xVar;
        TransferConfig.ConfigData configData = TransferConfig.getConfigData(i3);
        if (i3 == 1) {
            configData.mCommonFloat1 = null;
            configData.mCommonFloat2 = null;
            configData.mCommonFloat3 = null;
            configData.mCommonFloat4 = null;
        }
        this.f68976e.setConfigData(configData);
        if (!m0() || (xVar = (x) getEditExport(x.class)) == null) {
            return;
        }
        xVar.c0(this.f68976e);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        publishEditExport(q.class, this);
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if (editSource instanceof EditLocalPhotoSource) {
            this.f68975d = 3;
        } else if (editSource instanceof EditLocalVideoSource) {
            this.f68975d = 3;
        } else if (editSource instanceof EditTakeVideoSource) {
            this.f68976e.setPositions(((EditTakeVideoSource) editSource).f204052e.mTransferPosList);
            if (this.mParent.C.l("extra_transiton_src_from", -1) == 1) {
                this.f68975d = 0;
            } else {
                j0(((EditTakeVideoSource) this.mParent.C.f204059i).f204052e.mDuration);
            }
        }
        if (this.f68975d == 0) {
            m.a aVar = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I;
            if (aVar != null) {
                TransitionCategoryItem d16 = aVar.d();
                o(Integer.parseInt(d16.f66697d));
                com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().T(d16);
                o oVar = (o) getEditExport(o.class);
                if (oVar != null && !(this.mParent instanceof QzEditVideoPartManager)) {
                    oVar.f0();
                }
            }
            if (QQAudioHelper.i()) {
                this.f68976e.setReverseShift(l0());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onCreate, state:" + this.f68975d);
        }
        c cVar = (c) getEditExport(c.class);
        if (this.f68975d != 0) {
            cVar.s();
        }
        id0.a.n("video_edit_transition", "exp_transition", k0(this.mParent.C.l("extra_transiton_src_from", -1)), 0, new String[0]);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.q
    public int y() {
        return this.f68975d;
    }
}
