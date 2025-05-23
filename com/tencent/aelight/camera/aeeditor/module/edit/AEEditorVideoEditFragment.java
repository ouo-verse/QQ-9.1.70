package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import dr.d;
import uq3.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorVideoEditFragment extends AEEditorCommonEditFragment {
    private static final int J = c.s2();
    public static boolean K = false;

    public static void vh(Context context, TAVCutVideoSession tAVCutVideoSession, d dVar, MediaModel mediaModel, MoviePlayer moviePlayer, TAVCutVideoView tAVCutVideoView) {
        SessionConfig sessionConfig = new SessionConfig();
        sessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
        sessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
        sessionConfig.setMaxIntermediateRenderSize(dVar.c());
        StickerEditViewIconConfig stickerEditViewIconConfig = new StickerEditViewIconConfig();
        stickerEditViewIconConfig.setDeleteIconResId(R.drawable.ixb);
        stickerEditViewIconConfig.setEditIconResId(R.drawable.ixa);
        stickerEditViewIconConfig.setZoomIconResId(R.drawable.ixc);
        sessionConfig.setStickerEditViewIconConfig(stickerEditViewIconConfig);
        tAVCutVideoSession.setSessionConfig(sessionConfig);
        if (mediaModel == null) {
            mediaModel = new MediaModel();
        }
        tAVCutVideoSession.setMediaModel(mediaModel);
        if (moviePlayer != null) {
            tAVCutVideoSession.addPlayer(moviePlayer);
        }
        if (tAVCutVideoView != null) {
            tAVCutVideoSession.setTAVCutVideoView(tAVCutVideoView);
        }
        tAVCutVideoSession.init(context);
        K = tAVCutVideoSession.correctMediaResource(J);
    }

    @Override // com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment
    public String getModuleId() {
        return "AEEditorVideoEdit";
    }

    @Override // com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment
    public int th() {
        return R.layout.dnn;
    }

    public static Size wh(TAVCutVideoSession tAVCutVideoSession) {
        if (tAVCutVideoSession != null) {
            return tAVCutVideoSession.getExportMaxMediaSize();
        }
        return new Size(720, 1080);
    }
}
