package com.tencent.qcircle.weseevideo.model;

import com.tencent.qcircle.tavcut.constants.Constants;
import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J*\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J*\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002JC\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0014\"\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/WSTemplateManager;", "", "()V", "AE_FRAME_TEMPLATE_JSON", "", "clearMediaTemplateModel", "", "mediaModel", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "updateAutoTemplate", "templateDir", "templateJsonName", "isSwitchToTemplateByUser", "", "updateLightTemplate", "updateMovieTemplate", "updateTemplate", "type", "", "args", "", "(Lcom/tencent/qcircle/weseevideo/model/MediaModel;ILjava/lang/String;Z[Ljava/lang/String;)V", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class WSTemplateManager {
    private static final String AE_FRAME_TEMPLATE_JSON = "template.json";
    public static final WSTemplateManager INSTANCE = new WSTemplateManager();

    WSTemplateManager() {
    }

    @JvmStatic
    public static final void clearMediaTemplateModel(@NotNull MediaModel mediaModel) {
        Intrinsics.checkParameterIsNotNull(mediaModel, "mediaModel");
        MediaTemplateModel mediaTemplateModel = mediaModel.getMediaTemplateModel();
        mediaTemplateModel.setLightMediaTemplateModel(new LightMediaTemplateModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 32767, null));
        mediaTemplateModel.setAutomaticMediaTemplateModel(new AutomaticMediaTemplateModel());
        mediaTemplateModel.setMovieMediaTemplateModel(new MovieMediaTemplateModel());
    }

    private final void updateAutoTemplate(MediaModel mediaModel, String templateDir, String templateJsonName, boolean isSwitchToTemplateByUser) {
        if (mediaModel == null) {
            return;
        }
        clearMediaTemplateModel(mediaModel);
        MediaTemplateModel mediaTemplateModel = mediaModel.getMediaTemplateModel();
        File file = new File(templateDir, templateJsonName);
        File file2 = new File(templateDir, "template.json");
        if (FileUtils.exists(templateDir) && FileUtils.exists(file.getAbsolutePath())) {
            AutomaticMediaTemplateModel automaticMediaTemplateModel = new AutomaticMediaTemplateModel();
            if (ModelExtKt.isImageMode(mediaModel) && FileUtils.exists(templateDir) && file2.exists()) {
                byte[] readFile = org.light.utils.FileUtils.readFile(file2.getAbsolutePath());
                Intrinsics.checkExpressionValueIsNotNull(readFile, "org.light.utils.FileUtil\u2026emplateJson.absolutePath)");
                AEFrameModel aEFrameModel = (AEFrameModel) GsonUtils.json2Obj(new String(readFile, Charsets.UTF_8), AEFrameModel.class);
                if (aEFrameModel != null) {
                    aEFrameModel.setFrameColor(mediaModel.getMediaEffectModel().getIntParam(Constants.FRAME_PARAMS_KEY_COLOR));
                }
                automaticMediaTemplateModel.setAEFrameModel(aEFrameModel);
            }
            automaticMediaTemplateModel.setTemplateDir(templateDir);
            automaticMediaTemplateModel.setTemplateFileName(templateJsonName);
            if (!Intrinsics.areEqual("1", mediaModel.getMediaEffectModel().getParam(Constants.FRAME_PARAMS_KEY_IS_ON))) {
                automaticMediaTemplateModel.setImagePagAssetDir("pag");
            }
            automaticMediaTemplateModel.setSwitchToTemplateByUser(isSwitchToTemplateByUser);
            mediaTemplateModel.setAutomaticMediaTemplateModel(automaticMediaTemplateModel);
        }
    }

    private final void updateLightTemplate(MediaModel mediaModel, String templateDir, String templateJsonName, boolean isSwitchToTemplateByUser) {
        if (mediaModel == null) {
            return;
        }
        clearMediaTemplateModel(mediaModel);
        MediaTemplateModel mediaTemplateModel = mediaModel.getMediaTemplateModel();
        File file = new File(templateDir, templateJsonName);
        if (FileUtils.exists(templateDir) && FileUtils.exists(file.getAbsolutePath())) {
            LightMediaTemplateModel lightMediaTemplateModel = new LightMediaTemplateModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 32767, null);
            mediaTemplateModel.setLightMediaTemplateModel(lightMediaTemplateModel);
            lightMediaTemplateModel.setFilePath(file.getAbsolutePath());
            lightMediaTemplateModel.setSwitchByUser(isSwitchToTemplateByUser);
        }
    }

    private final void updateMovieTemplate(MediaModel mediaModel, String templateDir, boolean isSwitchToTemplateByUser) {
        if (mediaModel == null) {
            return;
        }
        clearMediaTemplateModel(mediaModel);
        MediaTemplateModel mediaTemplateModel = mediaModel.getMediaTemplateModel();
        String filePathBySuffix = FileUtils.getFilePathBySuffix(templateDir, ".pag");
        if (FileUtils.exists(filePathBySuffix)) {
            MovieMediaTemplateModel movieMediaTemplateModel = new MovieMediaTemplateModel();
            mediaTemplateModel.setMovieMediaTemplateModel(movieMediaTemplateModel);
            movieMediaTemplateModel.setFilePath(filePathBySuffix);
        }
    }

    @JvmStatic
    public static final void updateTemplate(@Nullable MediaModel mediaModel, int type, @NotNull String templateDir, boolean isSwitchToTemplateByUser, @NotNull String... args) {
        boolean z16;
        boolean z17;
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (type != 1) {
            if (type != 2) {
                if (type == 4) {
                    if (args.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        INSTANCE.updateLightTemplate(mediaModel, templateDir, args[0], isSwitchToTemplateByUser);
                        return;
                    }
                    return;
                }
                return;
            }
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                INSTANCE.updateAutoTemplate(mediaModel, templateDir, args[0], isSwitchToTemplateByUser);
                return;
            }
            return;
        }
        INSTANCE.updateMovieTemplate(mediaModel, templateDir, isSwitchToTemplateByUser);
    }
}
