package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakPBServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.play.AECoverSelectFragment;
import com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment;
import com.tencent.aelight.camera.aebase.PeakService;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aebase.h;
import com.tencent.aelight.camera.aebase.i;
import com.tencent.aelight.camera.aeeditor.AEEditorActivity;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigProcessor;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.config.QIMDoodleConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMDynamicTextConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMFilterConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMMusicConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMPasterConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMTemplateConfigProcessor;
import com.tencent.aelight.camera.aioeditor.takevideo.artfilter.ArtFilterBridgeActivity;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForPeak;
import com.tencent.mobileqq.wink.preview.WinkPhotoWallHandler;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEClassManagerImpl implements IAEClassManager {
    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getAECoverSelectFragmentClass() {
        return AECoverSelectFragment.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getAEEditorActivityClass() {
        return AEEditorActivity.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getAEEditorDataServiceHandlerClass() {
        return AEEditorDataServiceHandler.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getAEEditorEffectConfigProcessorClass() {
        return AEEditorEffectConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getAEPituCameraUnitClass() {
        return AEPituCameraUnit.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getArtFilterBridgeActivityClass() {
        return ArtFilterBridgeActivity.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getCameraDataServiceClass() {
        return com.tencent.aelight.camera.ae.config.a.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getCameraDataServiceHandlerClass() {
        return CameraDataServiceHandler.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getCameraPeakPBServiceHandlerClass() {
        return CameraPeakPBServiceHandler.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getCameraPeakServiceHandlerClass() {
        return CameraPeakServiceHandler.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getMusicProviderViewClass() {
        return MusicProviderView.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getPeakServiceClass() {
        return PeakService.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getPeakTranslucentActivity() {
        return PublicTransFragmentActivityForPeak.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getPreloadWebServiceClass() {
        return PreloadWebService.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMCameraCaptureActivity() {
        return QIMCameraCaptureActivity.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMDoodleConfigProcessorClass() {
        return QIMDoodleConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMDynamicTextConfigProcessorClass() {
        return QIMDynamicTextConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMFilterConfigProcessorClass() {
        return QIMFilterConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMMusicConfigProcessorClass() {
        return QIMMusicConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMPasterConfigProcessorClass() {
        return QIMPasterConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMTemplateConfigProcessorClass() {
        return QIMTemplateConfigProcessor.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMTribeEffectsCameraCaptureUnitClass() {
        return h.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQIMWebEffectCameraCaptureUnitClass() {
        return i.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getQzoneEditPictureActivityClass() {
        return QzoneEditPictureActivity.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getVideoPreviewFragmentClass() {
        return AEVideoPreviewFragment.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEClassManager
    public Class getWinkPhotoWallHandlerCLass() {
        return WinkPhotoWallHandler.class;
    }
}
