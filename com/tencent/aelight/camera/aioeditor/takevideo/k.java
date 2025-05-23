package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.takevideo.eliminate.EditPicAIEliminatePart;
import com.tencent.aelight.camera.aioeditor.takevideo.mosaic.EditPicMosaicPart;
import com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicConfig;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends EditPicPartManager {

    /* renamed from: u0, reason: collision with root package name */
    protected EditPicMosaicPart f68712u0;

    /* renamed from: v0, reason: collision with root package name */
    protected EditPicAIEliminatePart f68713v0;

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager
    public void B1(fs.b bVar) {
        super.B1(bVar);
        EditVideoParams editVideoParams = this.C;
        if (editVideoParams.f204055d == 2 && editVideoParams.t() && bVar.b()) {
            Map<String, Object> a16 = kr.a.a();
            a16.put("dt_pgid", "pg_image_process");
            a16.put("type_aio_pg", Integer.valueOf(kr.a.c(this.C)));
            VideoReport.reportEvent("dt_pgin", null, a16);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager, com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public int W() {
        return R.layout.doa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager, com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void j0(EditVideoParams editVideoParams) {
        int i3 = editVideoParams.f204057f;
        ArrayList arrayList = new ArrayList();
        if (15 == this.C.f204055d) {
            EditARCakeButton editARCakeButton = new EditARCakeButton(this);
            this.F = editARCakeButton;
            arrayList.add(editARCakeButton);
        } else {
            s sVar = new s(this, i3);
            this.E = sVar;
            arrayList.add(sVar);
            EditProviderPart editProviderPart = new EditProviderPart(this);
            this.H = editProviderPart;
            arrayList.add(editProviderPart);
            t tVar = new t(this, i3);
            this.I = tVar;
            arrayList.add(tVar);
            j jVar = new j(this);
            this.M = jVar;
            arrayList.add(jVar);
        }
        EditPicRawImageNew editPicRawImageNew = new EditPicRawImageNew(this, i3);
        this.L = editPicRawImageNew;
        arrayList.add(editPicRawImageNew);
        if (EditVideoPartManager.v(i3, 512)) {
            n nVar = new n(this);
            this.P = nVar;
            arrayList.add(nVar);
        }
        if (EditVideoPartManager.v(i3, 2048)) {
            EditJumpToPtu editJumpToPtu = new EditJumpToPtu(this);
            this.X = editJumpToPtu;
            arrayList.add(editJumpToPtu);
        }
        if (EditPicMeiHua.l0(i3)) {
            arrayList.add(new EditPicMeiHua(this));
        }
        if (MosaicConfig.a() && EditVideoPartManager.v(i3, 262144)) {
            QLog.d("EditPicPartManagerNew", 1, "onCreate to add EditPicMosaicPart success!");
            EditPicMosaicPart editPicMosaicPart = new EditPicMosaicPart(this);
            this.f68712u0 = editPicMosaicPart;
            arrayList.add(editPicMosaicPart);
        }
        if (EditVideoPartManager.v(i3, 524288)) {
            QLog.d("EditPicPartManagerNew", 1, "onCreate to add mEditPicEliminatePart success!");
            EditPicAIEliminatePart editPicAIEliminatePart = new EditPicAIEliminatePart(this);
            this.f68713v0 = editPicAIEliminatePart;
            arrayList.add(editPicAIEliminatePart);
        }
        if (2 == this.C.f204055d) {
            QQStoryContext.h();
            AppInterface a16 = QQStoryContext.a();
            boolean z16 = a16 != null && ((IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qq_new_aio_pic_editor_enable_doc_enhance", false);
            if (z16) {
                com.tencent.aelight.camera.aioeditor.docenhance.a aVar = new com.tencent.aelight.camera.aioeditor.docenhance.a(this);
                this.S = aVar;
                arrayList.add(aVar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("EditPicPartManagerNew", 2, "isConfigEnableDocEnhance = ", Boolean.valueOf(z16));
            }
        }
        this.D = arrayList;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public boolean t0() {
        EditPicAIEliminatePart editPicAIEliminatePart = this.f68713v0;
        if (editPicAIEliminatePart != null && editPicAIEliminatePart.onBackPressed()) {
            return true;
        }
        EditPicMosaicPart editPicMosaicPart = this.f68712u0;
        if (editPicMosaicPart == null || !editPicMosaicPart.onBackPressed()) {
            return super.t0();
        }
        return true;
    }
}
