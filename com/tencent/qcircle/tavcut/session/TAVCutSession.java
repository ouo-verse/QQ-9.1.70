package com.tencent.qcircle.tavcut.session;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerStateCallback;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class TAVCutSession implements Session, StickerOperationCallback, StickerStateCallback, StickerLyricCallback {
    private static final String TAG = TAVCutImageSession.class.getSimpleName();
    protected Context context;
    protected List<MediaModel> mediaModels;
    protected SessionConfig sessionConfig;
    protected IStickerEventListener stickerEventListener;
    protected StickerLyricCallback stickerLyricCallback;
    protected StickerOperationCallback stickerOperationCallback;
    protected List<String> mediaModelsMD5 = new ArrayList();
    protected final SparseArray<VideoRenderChainManager> renderChainManagers = new SparseArray<>();
    protected final SparseArray<TAVComposition> tavCompositions = new SparseArray<>();
    protected final SparseArray<StickerController> stickerControllers = new SparseArray<>();
    protected final SparseArray<ArrayList<TAVSticker>> bulkStickers = new SparseArray<>();
    protected final SparseArray<MediaBuilderOutput> mediaBuilderOutputs = new SparseArray<>();
    protected int currentIndex = 0;
    protected boolean runAsync = false;
    protected String initMediaModelsMD5 = "";

    /* JADX INFO: Access modifiers changed from: private */
    public void addOrUpdateStickerData(TAVSticker tAVSticker) {
        addOrUpdateStickerData(tAVSticker, this.currentIndex);
    }

    private void updateStickerModel(final TAVSticker tAVSticker) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.8
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                for (MediaModel mediaModel : TAVCutSession.this.mediaModels) {
                    List<StickerModel> stickerModelList = mediaModel.getMediaEffectModel().getStickerModelList();
                    Iterator<StickerModel> it = stickerModelList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            StickerModel next = it.next();
                            if (next.getUniqueId().equals(tAVSticker.getStickerId())) {
                                i3 = stickerModelList.indexOf(next);
                                break;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 >= 0) {
                        mediaModel.getMediaEffectModel().getStickerModelList().remove(i3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSticker(@NonNull StickerController stickerController, @NonNull StickerModel stickerModel) {
        addSticker(stickerController, stickerModel, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyCurrentSticker(StickerController stickerController) {
        TAVSticker currentSticker;
        if (stickerController != null && (currentSticker = stickerController.getCurrentSticker()) != null) {
            stickerController.resignCurrentSticker();
            onStickerResign(currentSticker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearAEKitModel(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager) {
        mediaModel.getMediaEffectModel().setAeKitModel(null);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CGSize constrainRenderSize(int i3, int i16) {
        int i17;
        int i18;
        CGSize cGSize = new CGSize(i3, i16);
        SessionConfig sessionConfig = this.sessionConfig;
        if (sessionConfig != null) {
            i17 = sessionConfig.getMaxIntermediateRenderSize();
        } else {
            i17 = -1;
        }
        if (i17 != -1) {
            Size constrainMaxSize = Util.constrainMaxSize(new Size(i3, i16), i17);
            cGSize.width = constrainMaxSize.getWidth();
            cGSize.height = constrainMaxSize.getHeight();
        }
        SessionConfig sessionConfig2 = this.sessionConfig;
        if (sessionConfig2 != null) {
            i18 = sessionConfig2.getMinIntermediateRenderSize();
        } else {
            i18 = -1;
        }
        if (i18 != -1) {
            Size constrainMinSize = Util.constrainMinSize(new Size((int) cGSize.width, (int) cGSize.height), i18);
            cGSize.width = constrainMinSize.getWidth();
            cGSize.height = constrainMinSize.getHeight();
        }
        Logger.i(TAG, String.format("targetRenderSize = %d * %d", Integer.valueOf((int) cGSize.width), Integer.valueOf((int) cGSize.height)));
        return cGSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StickerController createStickerController() {
        StickerEditViewIconConfig stickerEditViewIconConfig;
        Context context = this.context;
        SessionConfig sessionConfig = this.sessionConfig;
        if (sessionConfig != null) {
            stickerEditViewIconConfig = sessionConfig.getStickerEditViewIconConfig();
        } else {
            stickerEditViewIconConfig = null;
        }
        StickerController stickerController = new StickerController(context, stickerEditViewIconConfig);
        stickerController.setStickerOperationCallback(this);
        stickerController.setStickerStateCallback(this);
        stickerController.setStickerLyricCallback(this);
        return stickerController;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    protected String getMediaModelsMD5() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<MediaModel> it = this.mediaModels.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
        }
        return Util.md5(sb5.toString());
    }

    public List<String> getMediaModelsMd5() {
        return this.mediaModelsMD5;
    }

    public SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    public int getStickerSizeByIndex(int i3) {
        MediaModel mediaModel;
        List<MediaModel> list = this.mediaModels;
        if (list == null || (mediaModel = list.get(i3)) == null) {
            return 0;
        }
        MediaEffectModel mediaEffectModel = mediaModel.getMediaEffectModel();
        if (mediaEffectModel.getStickerModelList().size() <= 0) {
            return 0;
        }
        return mediaEffectModel.getStickerModelList().size();
    }

    public int getStickerTotalSize() {
        if (this.mediaModels == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.mediaModels.size(); i16++) {
            MediaModel mediaModel = this.mediaModels.get(i16);
            if (mediaModel != null) {
                MediaEffectModel mediaEffectModel = mediaModel.getMediaEffectModel();
                if (mediaEffectModel.getStickerModelList().size() > 0) {
                    i3 += mediaEffectModel.getStickerModelList().size();
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.qcircle.tavcut.session.Session
    public int init(final Context context) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.2
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession tAVCutSession = TAVCutSession.this;
                tAVCutSession.context = context;
                tAVCutSession.stickerEventListener = new IStickerEventListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.2.1
                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener
                    public void onStickerDataChanged(@NotNull TAVSticker tAVSticker, @NotNull TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19) {
                        StickerOperationCallback stickerOperationCallback;
                        if (tAVStickerOperationMode == TAVStickerOperationMode.OP_DRAG && (stickerOperationCallback = TAVCutSession.this.stickerOperationCallback) != null) {
                            stickerOperationCallback.onStickerMoving(tAVSticker.getStickerId());
                        }
                    }

                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener
                    public void onStickerStatusChanged(@NotNull TAVSticker tAVSticker, boolean z16, boolean z17) {
                        if (!z16) {
                            TAVCutSession.this.addOrUpdateStickerData(tAVSticker);
                        }
                        StickerOperationCallback stickerOperationCallback = TAVCutSession.this.stickerOperationCallback;
                        if (stickerOperationCallback != null) {
                            if (z16) {
                                stickerOperationCallback.onStickerTouchStart(StickerUtil.stickerModel2EditorData(tAVSticker));
                            } else {
                                stickerOperationCallback.onStickerTouchEnd(StickerUtil.stickerModel2EditorData(tAVSticker));
                            }
                        }
                    }
                };
                StickerEventDispatcher.getInstance().addStickerEventListener(TAVCutSession.this.stickerEventListener);
            }
        });
        return 0;
    }

    public boolean isTavStickerSelected() {
        for (int i3 = 0; i3 < this.stickerControllers.size(); i3++) {
            int keyAt = this.stickerControllers.keyAt(i3);
            if (this.stickerControllers.get(keyAt) != null && this.stickerControllers.get(keyAt).getCurrentSticker() != null) {
                return true;
            }
        }
        return false;
    }

    public boolean mediaChanged() {
        return !this.initMediaModelsMD5.equals(getMediaModelsMD5());
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onAddStickerDone(String str) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onAddStickerDone(str);
        }
    }

    public void onDeleteButtonClick(final String str) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.10
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                for (MediaModel mediaModel : TAVCutSession.this.mediaModels) {
                    List<StickerModel> stickerModelList = mediaModel.getMediaEffectModel().getStickerModelList();
                    Iterator<StickerModel> it = stickerModelList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            StickerModel next = it.next();
                            if (next.getUniqueId().equals(str)) {
                                i3 = stickerModelList.indexOf(next);
                                break;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 >= 0) {
                        mediaModel.getMediaEffectModel().getStickerModelList().remove(i3);
                    }
                }
            }
        });
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onDeleteButtonClick(str);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback
    public void onDeleteSticker() {
        StickerLyricCallback stickerLyricCallback = this.stickerLyricCallback;
        if (stickerLyricCallback != null) {
            stickerLyricCallback.onDeleteSticker();
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.Session
    public void onPause() {
        StickerEventDispatcher.getInstance().removeStickerEventListener(this.stickerEventListener);
        SparseArray<StickerController> sparseArray = this.stickerControllers;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i3 = 0; i3 < this.stickerControllers.size(); i3++) {
                StickerEventDispatcher.getInstance().removeStickerEventListener(this.stickerControllers.get(i3));
            }
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.Session
    public void onResume() {
        StickerEventDispatcher.getInstance().addStickerEventListener(this.stickerEventListener);
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStickerAdd(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView) {
        int i3;
        if (tAVStickerEditView != null && tAVStickerEditView.getSticker() != null) {
            int i16 = 0;
            while (true) {
                if (i16 < this.stickerControllers.size()) {
                    SparseArray<StickerController> sparseArray = this.stickerControllers;
                    if (sparseArray.get(sparseArray.keyAt(i16)).getStickerContext() == tAVStickerContext) {
                        i3 = this.stickerControllers.keyAt(i16);
                        break;
                    }
                    i16++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                addOrUpdateStickerData(tAVStickerEditView.getSticker(), i3);
            }
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onStickerClick(TextEditorData textEditorData) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onStickerClick(textEditorData);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onStickerMoving(String str) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onStickerMoving(str);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onStickerOutsideClick() {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onStickerOutsideClick();
        }
    }

    public void onStickerResign(TAVSticker tAVSticker) {
        if ((tAVSticker instanceof WSLyricSticker) && this.mediaModels.get(this.currentIndex).getMediaEffectModel().getSubtitleModel() == null) {
            this.mediaModels.get(this.currentIndex).getMediaEffectModel().setSubtitleModel(WSLyricSticker.dumpToSubtitleModel(tAVSticker));
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onStickerSelect(TextEditorData textEditorData) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onStickerSelect(textEditorData);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onStickerTouchEnd(TextEditorData textEditorData) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onStickerTouchEnd(textEditorData);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onStickerTouchStart(TextEditorData textEditorData) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onStickerTouchStart(textEditorData);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onTextEditButtonClick(TextEditorData textEditorData) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onTextEditButtonClick(textEditorData);
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onUpdateTextStickerDone(String str) {
        StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
        if (stickerOperationCallback != null) {
            stickerOperationCallback.onUpdateTextStickerDone(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recordInitMediaModelsMD5() {
        this.initMediaModelsMD5 = getMediaModelsMD5();
        Iterator<MediaModel> it = this.mediaModels.iterator();
        while (it.hasNext()) {
            this.mediaModelsMD5.add(Util.md5(it.next().toString()));
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.Session
    @CallSuper
    public void release() {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.13
            @Override // java.lang.Runnable
            public void run() {
                StickerEventDispatcher.getInstance().removeStickerEventListener(TAVCutSession.this.stickerEventListener);
                TAVCutSession.this.stickerOperationCallback = null;
                for (int i3 = 0; i3 < TAVCutSession.this.renderChainManagers.size(); i3++) {
                    TAVCutSession.this.renderChainManagers.get(TAVCutSession.this.renderChainManagers.keyAt(i3)).release();
                }
                TAVCutSession.this.renderChainManagers.clear();
                for (int i16 = 0; i16 < TAVCutSession.this.stickerControllers.size(); i16++) {
                    TAVCutSession.this.stickerControllers.get(TAVCutSession.this.stickerControllers.keyAt(i16)).destroy();
                }
                TAVCutSession.this.stickerControllers.clear();
                WSOverLayBlurManager.release();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetAEKitModel(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager, float f16, String str, float f17, Map<String, String> map, String str2) {
        AEKitModel aEKitModel = new AEKitModel(this instanceof TAVCutVideoSession ? 2 : 1);
        aEKitModel.setEffectStrength(f16);
        aEKitModel.setLutPath(str);
        aEKitModel.setGlowAlpha(f17);
        aEKitModel.setAdjustParams(map);
        aEKitModel.setMaterial(str2);
        mediaModel.getMediaEffectModel().setAeKitModel(aEKitModel);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetAEKitModelForAI(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager, @Nullable String str, float f16, HashMap<String, String> hashMap, int i3, float f17, long j3) {
        int i16;
        if (this instanceof TAVCutVideoSession) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        AEKitModel aEKitModel = new AEKitModel(i16);
        aEKitModel.setAdjustParams(hashMap);
        aEKitModel.setLutPath(str);
        aEKitModel.setStartTime(0L);
        aEKitModel.setSmoothLevel(i3);
        aEKitModel.setLutAlpha(f16);
        aEKitModel.setGlowAlpha(f17);
        aEKitModel.setDuration(j3);
        mediaModel.getMediaEffectModel().setAeKitModel(aEKitModel);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnMainThread(Runnable runnable) {
        runOnMainThread(runnable, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runTask(Runnable runnable) {
        if (this.runAsync) {
            AsyncTask.SERIAL_EXECUTOR.execute(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCrop(@NonNull final MediaModel mediaModel, @NonNull final VideoRenderChainManager videoRenderChainManager, final CropConfig cropConfig) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.3
            @Override // java.lang.Runnable
            public void run() {
                CropModel cropModel = new CropModel();
                cropModel.setCropConfig(cropConfig);
                mediaModel.getMediaEffectModel().setCropModel(cropModel);
                TAVCutSession.this.updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel(), false);
            }
        });
    }

    public void setCurrentIndex(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.6
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession tAVCutSession = TAVCutSession.this;
                tAVCutSession.currentIndex = i3;
                if (tAVCutSession instanceof TAVCutImageSession) {
                    TAVCutImageSession tAVCutImageSession = (TAVCutImageSession) tAVCutSession;
                    if (tAVCutImageSession.getImageRenderers().size() > 0) {
                        for (int i16 = 0; i16 < tAVCutImageSession.getImageRenderers().size(); i16++) {
                            tAVCutImageSession.getImageRenderers().get(i16);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEffectStrength(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager, float f16) {
        AEKitModel aeKitModel = mediaModel.getMediaEffectModel().getAeKitModel();
        if (aeKitModel == null) {
            return;
        }
        aeKitModel.setEffectStrength(f16);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public void setMaterial(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager, String str) {
        int i3;
        AEKitModel aeKitModel = mediaModel.getMediaEffectModel().getAeKitModel();
        if (aeKitModel == null) {
            if (this instanceof TAVCutVideoSession) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            aeKitModel = new AEKitModel(i3);
        }
        aeKitModel.setMaterial(str);
        mediaModel.getMediaEffectModel().setAeKitModel(aeKitModel);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel());
    }

    public void setSessionConfig(final SessionConfig sessionConfig) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.1
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession.this.sessionConfig = sessionConfig;
            }
        });
    }

    public void setStickerLyricCallback(final StickerLyricCallback stickerLyricCallback) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.14
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession.this.stickerLyricCallback = stickerLyricCallback;
            }
        });
    }

    public void setStickerOperationCallback(final StickerOperationCallback stickerOperationCallback) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.9
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession.this.stickerOperationCallback = stickerOperationCallback;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void toggleAEKit(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager, boolean z16) {
        AEKitModel aeKitModel = mediaModel.getMediaEffectModel().getAeKitModel();
        if (aeKitModel == null) {
            return;
        }
        aeKitModel.setDisable(!z16);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel());
    }

    protected void updateRenderChain(VideoRenderChainManager videoRenderChainManager, MediaEffectModel mediaEffectModel) {
        if (videoRenderChainManager != null) {
            videoRenderChainManager.updateRenderChain(mediaEffectModel, true);
        }
    }

    public void updateTextSticker(final TextEditorData textEditorData) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.7
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < TAVCutSession.this.stickerControllers.size(); i3++) {
                    final int keyAt = TAVCutSession.this.stickerControllers.keyAt(i3);
                    TAVCutSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TAVCutSession.this.stickerControllers.get(keyAt).updateTextSticker(textEditorData);
                        }
                    }, true);
                }
            }
        });
    }

    protected void waitAllTaskComplete() {
        if (!this.runAsync) {
            return;
        }
        final Semaphore semaphore = new Semaphore(0);
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.12
            @Override // java.lang.Runnable
            public void run() {
                semaphore.release();
            }
        });
        try {
            semaphore.acquire();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    private void addOrUpdateStickerData(TAVSticker tAVSticker, int i3) {
        List<StickerModel> stickerModelList = this.mediaModels.get(i3).getMediaEffectModel().getStickerModelList();
        int i16 = 0;
        while (true) {
            if (i16 >= stickerModelList.size()) {
                break;
            }
            if (stickerModelList.get(i16).getUniqueId().equals(tAVSticker.getStickerId())) {
                stickerModelList.remove(i16);
                break;
            }
            i16++;
        }
        if (tAVSticker instanceof WSLyricSticker) {
            this.mediaModels.get(i3).getMediaEffectModel().setSubtitleModel(WSLyricSticker.dumpToSubtitleModel(tAVSticker));
        } else {
            StickerModel tavSticker2StickerModel = StickerUtil.tavSticker2StickerModel(tAVSticker);
            tavSticker2StickerModel.setDuration(((float) tavSticker2StickerModel.getEndTime()) - tavSticker2StickerModel.getStartTime());
            stickerModelList.add(tavSticker2StickerModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSticker(@NonNull final StickerController stickerController, @NonNull final StickerModel stickerModel, final boolean z16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.4
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TAVSticker stickerModel2TavSticker;
                        TAVSticker currentSticker = stickerController.getCurrentSticker();
                        if (currentSticker != null) {
                            TAVCutSession.this.addOrUpdateStickerData(currentSticker);
                        }
                        stickerController.resignCurrentSticker();
                        StickerModel stickerModel2 = stickerModel;
                        if (stickerModel2 instanceof SubtitleModel) {
                            stickerModel2TavSticker = StickerConverter.subtitleModel2TavSticker((SubtitleModel) stickerModel2);
                        } else {
                            stickerModel2TavSticker = StickerUtil.stickerModel2TavSticker(stickerModel2);
                        }
                        if (stickerModel2TavSticker != null) {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            stickerController.addSticker(stickerModel2TavSticker, z16);
                        }
                        StickerOperationCallback stickerOperationCallback = TAVCutSession.this.stickerOperationCallback;
                        if (stickerOperationCallback != null) {
                            stickerOperationCallback.onAddStickerDone(stickerModel2TavSticker.getStickerId());
                        }
                    }
                }, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnMainThread(final Runnable runnable, boolean z16) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final Semaphore semaphore = new Semaphore(0);
            HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.11
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                    semaphore.release();
                }
            });
            if (z16) {
                try {
                    semaphore.acquire();
                    return;
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRenderChain(VideoRenderChainManager videoRenderChainManager, MediaEffectModel mediaEffectModel, boolean z16) {
        if (videoRenderChainManager != null) {
            videoRenderChainManager.updateRenderChain(mediaEffectModel, z16);
        }
    }

    public void addSticker(final int i3, @NonNull final List<StickerModel> list, final boolean z16) {
        StickerController stickerController = this.stickerControllers.get(i3);
        if (stickerController == null) {
            stickerController = createStickerController();
            this.stickerControllers.put(i3, stickerController);
        }
        final StickerController stickerController2 = stickerController;
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.5
            @Override // java.lang.Runnable
            public void run() {
                TAVCutSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutSession.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TAVSticker stickerModel2TavSticker;
                        TAVSticker currentSticker = stickerController2.getCurrentSticker();
                        if (currentSticker != null) {
                            TAVCutSession.this.addOrUpdateStickerData(currentSticker);
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        if (TAVCutSession.this.bulkStickers.get(i3) == null) {
                            AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                            TAVCutSession.this.bulkStickers.put(i3, new ArrayList<>());
                        }
                        stickerController2.resignCurrentSticker();
                        for (StickerModel stickerModel : list) {
                            if (stickerModel instanceof SubtitleModel) {
                                stickerModel2TavSticker = StickerConverter.subtitleModel2TavSticker((SubtitleModel) stickerModel);
                            } else {
                                stickerModel2TavSticker = StickerUtil.stickerModel2TavSticker(stickerModel);
                            }
                            if (stickerModel2TavSticker != null) {
                                AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                                stickerController2.addSticker(stickerModel2TavSticker, z16);
                                AnonymousClass5 anonymousClass54 = AnonymousClass5.this;
                                if (TAVCutSession.this.bulkStickers.get(i3) != null) {
                                    AnonymousClass5 anonymousClass55 = AnonymousClass5.this;
                                    TAVCutSession.this.bulkStickers.get(i3).add(stickerModel2TavSticker);
                                }
                            }
                        }
                    }
                }, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetAEKitModel(@NonNull MediaModel mediaModel, @NonNull VideoRenderChainManager videoRenderChainManager, @Nullable String str, float f16) {
        AEKitModel aEKitModel = new AEKitModel(this instanceof TAVCutVideoSession ? 2 : 1);
        aEKitModel.setLutPath(str);
        aEKitModel.setLutAlpha(f16);
        mediaModel.getMediaEffectModel().setAeKitModel(aEKitModel);
        updateRenderChain(videoRenderChainManager, mediaModel.getMediaEffectModel(), false);
    }

    public void onStickerActive() {
    }

    @Override // com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStatusChanged(boolean z16) {
    }
}
