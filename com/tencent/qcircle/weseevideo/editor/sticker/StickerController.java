package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerStateCallback;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerContentView;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tavsticker.core.ITAVStickerContextDataSource;
import com.tencent.tavsticker.core.ITAVStickerContextObserver;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerController implements VideoRenderChainManager.IStickerContextInterface, ITAVStickerContextObserver, IStickerEventListener {
    private static final String TAG = "StickerController";
    private Context ctx;
    private int dataChangedCount;
    private TAVStickerContext.b interceptTouchDelegate;
    private TAVStickerOperationMode operationMode;
    private Set<TAVStickerOperationMode> operations;
    protected WsStickerContentView stickerContentView;
    protected TAVStickerContext stickerContext;
    private StickerEditViewIconConfig stickerEditViewIconConfig;
    private StickerLyricCallback stickerLyricCallback;
    private StickerOperationCallback stickerOperationCallback;
    private StickerStateCallback stickerStateCallback;

    public StickerController(Context context) {
        this(context, null);
    }

    private Pair<Float, Float> calcStickerCenterPosition(float f16, float f17) {
        Pair<Float, Float> pair = new Pair<>(Float.valueOf(f16), Float.valueOf(f17));
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null && tAVStickerContext.getStickers() != null) {
            for (TAVSticker tAVSticker : this.stickerContext.getStickers()) {
                if (Math.abs(tAVSticker.getCenterX() - ((Float) pair.first).floatValue()) < 0.01f && Math.abs(tAVSticker.getCenterY() - ((Float) pair.second).floatValue()) < 0.01f) {
                    pair = new Pair<>(Float.valueOf(((Float) pair.first).floatValue() + 0.02f), Float.valueOf(((Float) pair.second).floatValue() + 0.02f));
                }
            }
        }
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configure(final TAVStickerContext tAVStickerContext) {
        tAVStickerContext.setTavStickerContentView(this.stickerContentView);
        tAVStickerContext.setTavStickerContextDataSource(new ITAVStickerContextDataSource() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.1
            @Override // com.tencent.tavsticker.core.ITAVStickerContextDataSource
            public TAVStickerEditView loadSticker(final TAVStickerContext tAVStickerContext2, TAVSticker tAVSticker) {
                WsStickerEditView createStickerEditView = StickerViewFactory.createStickerEditView(StickerController.this.ctx, tAVSticker, StickerController.this.stickerEditViewIconConfig);
                final String extraStickerType = TAVStickerExKt.getExtraStickerType(tAVSticker);
                createStickerEditView.setDrawMovieLimitRect(false);
                if (WsStickerConstant.StickerType.STICKER_LYRIC.equals(extraStickerType)) {
                    createStickerEditView.setDrawingOperationMask(21);
                } else {
                    createStickerEditView.setDrawingOperationMask(63);
                }
                createStickerEditView.setOnStickerEditButtonClickListener(new WsStickerEditView.OnStickerEditButtonClickListener() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.1.1
                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener
                    public void onDeleteClick(@NotNull TAVSticker tAVSticker2) {
                        StickerController.this.deleteSticker(tAVStickerContext2, tAVSticker2);
                        if (StickerController.this.stickerOperationCallback != null) {
                            StickerController.this.stickerOperationCallback.onDeleteButtonClick(tAVSticker2.getStickerId());
                        }
                        if (WsStickerConstant.StickerType.STICKER_LYRIC.equals(extraStickerType) && StickerController.this.stickerLyricCallback != null) {
                            StickerController.this.stickerLyricCallback.onDeleteSticker();
                        }
                    }

                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener
                    public void onEditClick(@NotNull TAVSticker tAVSticker2, @Nullable List<TAVStickerLayerItem> list) {
                        if (!WsStickerConstant.StickerType.STICKER_LYRIC.equals(extraStickerType) && StickerController.this.stickerOperationCallback != null && tAVSticker2.getStickerTextItems() != null && !tAVSticker2.getStickerTextItems().isEmpty()) {
                            StickerController.this.stickerOperationCallback.onTextEditButtonClick(StickerUtil.stickerModel2EditorData(tAVSticker2));
                        }
                    }

                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener
                    public void onStickerClick(@NotNull TAVSticker tAVSticker2) {
                        if (!WsStickerConstant.StickerType.STICKER_LYRIC.equals(extraStickerType) && StickerController.this.stickerOperationCallback != null && tAVSticker2.getStickerTextItems() != null) {
                            StickerController.this.stickerOperationCallback.onStickerClick(StickerUtil.stickerModel2EditorData(tAVSticker2));
                        }
                    }

                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener
                    public void onStickerSelected(TAVSticker tAVSticker2) {
                        if (WsStickerConstant.StickerType.STICKER_LYRIC.equals(extraStickerType)) {
                            TextEditorData stickerModel2EditorData = StickerUtil.stickerModel2EditorData(tAVSticker2);
                            stickerModel2EditorData.setStickerType(WsStickerConstant.StickerType.STICKER_LYRIC);
                            StickerController.this.stickerOperationCallback.onStickerSelect(stickerModel2EditorData);
                        } else if (StickerController.this.stickerOperationCallback != null) {
                            StickerController.this.stickerOperationCallback.onStickerSelect(StickerUtil.stickerModel2EditorData(tAVSticker2));
                        }
                    }

                    @Override // com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener
                    public void onAdjustTimeClick(@NotNull TAVSticker tAVSticker2) {
                    }
                });
                return createStickerEditView;
            }
        });
        tAVStickerContext.setOnTouchStickerOutsideListener(new TAVStickerContext.OnTouchStickerOutsideListener() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.2
            @Override // com.tencent.tavsticker.core.TAVStickerContext.OnTouchStickerOutsideListener
            public void onTouchStickerOutside(MotionEvent motionEvent) {
                TAVSticker currentSticker = tAVStickerContext.getCurrentSticker();
                tAVStickerContext.resignCurrentSticker();
                if (currentSticker != null && StickerController.this.stickerStateCallback != null) {
                    StickerController.this.stickerStateCallback.onStickerResign(currentSticker);
                }
                if (StickerController.this.stickerOperationCallback != null) {
                    StickerController.this.stickerOperationCallback.onStickerOutsideClick();
                }
            }
        });
        tAVStickerContext.registerObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteSticker(TAVStickerContext tAVStickerContext, TAVSticker tAVSticker) {
        if (tAVStickerContext == null) {
            return;
        }
        tAVStickerContext.removeSticker(tAVSticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TAVSticker> findStickerByType(int i3) {
        ArrayList arrayList = new ArrayList();
        if (getStickerContext() == null) {
            return arrayList;
        }
        synchronized (getStickerContext().getStickers()) {
            if (getStickerContext().getStickers() == null) {
                return arrayList;
            }
            for (TAVSticker tAVSticker : getStickerContext().getStickers()) {
                if (tAVSticker != null && i3 == VideoEffectType.TYPE_SUBTITLE.value && WsStickerConstant.StickerType.STICKER_LYRIC.equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                    arrayList.add(tAVSticker);
                }
            }
            return arrayList;
        }
    }

    private void init() {
        HashSet hashSet = new HashSet();
        this.operations = hashSet;
        hashSet.add(TAVStickerOperationMode.OP_DRAG);
        this.operations.add(TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE);
        this.operations.add(TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE);
        StickerEventDispatcher.getInstance().addStickerEventListener(this);
    }

    public void addSticker(TAVSticker tAVSticker) {
        addSticker(tAVSticker, true);
    }

    public void checkContainerSize(ViewGroup viewGroup) {
        this.stickerContentView.parentTop = viewGroup.getTop();
        this.stickerContentView.parentLeft = viewGroup.getLeft();
    }

    @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface
    @NotNull
    public TAVStickerContext createStickerContext(boolean z16) {
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null) {
            return tAVStickerContext;
        }
        final TAVStickerContext createStickerContextInner = createStickerContextInner(this.ctx);
        createStickerContextInner.getDispatchTouchEventListener().a(this.interceptTouchDelegate);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            configure(createStickerContextInner);
            this.stickerContext = createStickerContextInner;
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.5
                @Override // java.lang.Runnable
                public void run() {
                    StickerController.this.configure(createStickerContextInner);
                    StickerController.this.stickerContext = createStickerContextInner;
                    countDownLatch.countDown();
                }
            });
            try {
                try {
                    countDownLatch.await();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                countDownLatch.countDown();
            }
        }
        return createStickerContextInner;
    }

    protected TAVStickerContext createStickerContextInner(Context context) {
        return new WsStickerContext(context);
    }

    public void deleteLyricSticker() {
        HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.3
            @Override // java.lang.Runnable
            public void run() {
                List<TAVSticker> findStickerByType = StickerController.this.findStickerByType(VideoEffectType.TYPE_SUBTITLE.value);
                if (findStickerByType != null) {
                    for (TAVSticker tAVSticker : findStickerByType) {
                        StickerController stickerController = StickerController.this;
                        stickerController.deleteSticker(stickerController.getStickerContext(), tAVSticker);
                    }
                }
            }
        });
    }

    public void destroy() {
        releaseStickerContext();
        StickerEventDispatcher.getInstance().removeStickerEventListener(this);
    }

    public Context getCtx() {
        return this.ctx;
    }

    public TAVSticker getCurrentSticker() {
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext == null) {
            return null;
        }
        return tAVStickerContext.getCurrentSticker();
    }

    public TAVStickerContext getStickerContext() {
        return this.stickerContext;
    }

    protected void initContentView(Context context) {
        this.stickerContentView = new WsStickerContentView(context);
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerContextObserver
    public void onCurrentStickerStateChanged(TAVStickerContext tAVStickerContext, boolean z16) {
        TLog.d(TAG, "onCurrentStickerStateChanged -> isActive : $isActive");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.tavsticker.core.ITAVStickerContextObserver
    public void onStickerActive(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView) {
        TLog.d(TAG, "onStickerActive");
        StickerStateCallback stickerStateCallback = this.stickerStateCallback;
        if (stickerStateCallback != null) {
            stickerStateCallback.onStickerActive();
        }
        if (tAVStickerEditView instanceof WSOverLayBlurManager.SourceImageObserver) {
            WSOverLayBlurManager.registerSourceImageObserver(tAVStickerContext, tAVStickerEditView.getSticker().getUniqueId(), (WSOverLayBlurManager.SourceImageObserver) tAVStickerEditView);
        }
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerContextObserver
    public void onStickerAdd(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView) {
        TLog.d(TAG, "onStickerAdd");
        StickerStateCallback stickerStateCallback = this.stickerStateCallback;
        if (stickerStateCallback != null) {
            stickerStateCallback.onStickerAdd(tAVStickerContext, tAVStickerEditView);
        }
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener
    public void onStickerDataChanged(TAVSticker tAVSticker, TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19) {
        TLog.d(TAG, "onStickerDataChanged -> operationMode : $operationMode, centerX : $centerX, cneterY : $centerY, scale : $scale, rotate : $rotate");
        if (this.dataChangedCount == 0 && this.operations.contains(tAVStickerOperationMode)) {
            HandlerUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.6
                @Override // java.lang.Runnable
                public void run() {
                    if (StickerController.this.dataChangedCount != 0 && StickerController.this.stickerStateCallback != null) {
                        StickerController.this.stickerStateCallback.onStatusChanged(true);
                    }
                }
            }, 10L);
            this.dataChangedCount++;
        }
        this.operationMode = tAVStickerOperationMode;
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerContextObserver
    public void onStickerListChanged(TAVStickerContext tAVStickerContext) {
        TLog.d(TAG, "onStickerListChanged");
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerContextObserver
    public void onStickerRemove(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView) {
        TLog.d(TAG, "onStickerRemove");
        if (tAVStickerEditView != null) {
            WSOverLayBlurManager.unregisterSourceImageObserver(tAVStickerContext, tAVStickerEditView.getSticker().getUniqueId());
        }
    }

    @Override // com.tencent.tavsticker.core.ITAVStickerContextObserver
    public void onStickerResign(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView) {
        StickerStateCallback stickerStateCallback;
        TLog.d(TAG, "onStickerResign");
        if ((tAVStickerEditView instanceof BlurStickerEditView) && (stickerStateCallback = this.stickerStateCallback) != null) {
            stickerStateCallback.onStickerResign(tAVStickerEditView.getSticker());
        }
        WSOverLayBlurManager.unregisterSourceImageObserver(tAVStickerContext, tAVStickerEditView.getSticker().getUniqueId());
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener
    public void onStickerStatusChanged(TAVSticker tAVSticker, boolean z16, boolean z17) {
        StickerStateCallback stickerStateCallback;
        TLog.d(TAG, "onStickerStatusChanged");
        if (!z16 && this.dataChangedCount > 0 && this.operations.contains(this.operationMode) && (stickerStateCallback = this.stickerStateCallback) != null) {
            stickerStateCallback.onStatusChanged(false);
        }
        this.dataChangedCount = 0;
    }

    @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface
    public void releaseStickerContext() {
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null) {
            tAVStickerContext.unRegisterObserver(this);
            this.stickerContext.release();
        }
        this.stickerContext = null;
    }

    public void removeAllStickers(final Runnable runnable) {
        final TAVStickerContext tAVStickerContext = this.stickerContext;
        HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.7
            @Override // java.lang.Runnable
            public void run() {
                TAVStickerContext tAVStickerContext2 = tAVStickerContext;
                if (tAVStickerContext2 != null) {
                    tAVStickerContext2.removeAllStickers();
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public void resignCurrentSticker() {
        StickerStateCallback stickerStateCallback;
        TAVSticker currentSticker = this.stickerContext.getCurrentSticker();
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null) {
            tAVStickerContext.resignCurrentSticker();
        }
        if (currentSticker != null && (stickerStateCallback = this.stickerStateCallback) != null) {
            stickerStateCallback.onStickerResign(currentSticker);
        }
    }

    public void restoreSticker(List<StickerModel> list) {
        for (StickerModel stickerModel : list) {
            TAVStickerContext tAVStickerContext = this.stickerContext;
            if (tAVStickerContext != null) {
                tAVStickerContext.loadSticker(StickerUtil.stickerModel2TavSticker(stickerModel), false);
            }
        }
    }

    public SubtitleModel saveLyricSticker() {
        List<TAVSticker> findStickerByType = findStickerByType(VideoEffectType.TYPE_SUBTITLE.value);
        if (findStickerByType != null) {
            Iterator<TAVSticker> it = findStickerByType.iterator();
            if (it.hasNext()) {
                return WSLyricSticker.dumpToSubtitleModel(it.next());
            }
        }
        return null;
    }

    public void setInterceptTouchDelegate(TAVStickerContext.b bVar) {
        this.interceptTouchDelegate = bVar;
    }

    public void setLyricProcess(long j3) {
        WsStickerContentView wsStickerContentView = this.stickerContentView;
        if (wsStickerContentView != null && wsStickerContentView.getStickerEditView() != null) {
            TAVSticker sticker = this.stickerContentView.getStickerEditView().getSticker();
            if (this.stickerContentView.getStickerEditView().getMode() == TAVStickerMode.ACTIVE && this.stickerContentView.getStickerEditView().getVisibility() == 0 && sticker != null) {
                this.stickerContentView.getStickerEditView().setProgress(sticker.computeProgress(j3));
                this.stickerContentView.getStickerEditView().flush();
            }
        }
    }

    public void setLyricStartTime(int i3) {
        WsStickerContentView wsStickerContentView = this.stickerContentView;
        if (wsStickerContentView != null && wsStickerContentView.getStickerEditView() != null) {
            TAVSticker sticker = this.stickerContentView.getStickerEditView().getSticker();
            if (WsStickerConstant.StickerType.STICKER_LYRIC.equals(TAVStickerExKt.getExtraStickerType(sticker)) && this.stickerContentView.getStickerEditView().getVisibility() == 0 && sticker != null && (sticker instanceof WSLyricSticker)) {
                ((WSLyricSticker) sticker).updateMusicStartTime(i3);
            }
        }
    }

    public void setNeedOperate(boolean z16, MotionEvent motionEvent) {
        this.stickerContentView.setNeedOperate(z16, motionEvent);
        if (!z16) {
            resignCurrentSticker();
        }
    }

    public void setStickerContainer(ViewGroup viewGroup) {
        viewGroup.removeView(this.stickerContentView);
        checkContainerSize(viewGroup);
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null) {
            tAVStickerContext.setStickerContainer(viewGroup);
        }
    }

    public void setStickerLyricCallback(StickerLyricCallback stickerLyricCallback) {
        this.stickerLyricCallback = stickerLyricCallback;
    }

    public void setStickerOperationCallback(StickerOperationCallback stickerOperationCallback) {
        this.stickerOperationCallback = stickerOperationCallback;
    }

    public void setStickerStateCallback(StickerStateCallback stickerStateCallback) {
        this.stickerStateCallback = stickerStateCallback;
    }

    public void setStickerTouchEnable(boolean z16) {
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null) {
            tAVStickerContext.setTouchable(z16);
        }
    }

    public TAVSticker updateTextSticker(TextEditorData textEditorData) {
        try {
            for (TAVSticker tAVSticker : this.stickerContext.getStickers()) {
                if (tAVSticker.getStickerId().equals(textEditorData.getUniqueID())) {
                    this.stickerContext.removeSticker(tAVSticker);
                    TAVSticker tAVSticker2 = new TAVSticker();
                    tAVSticker2.setStickerId(textEditorData.getUniqueID());
                    tAVSticker2.setExtras(textEditorData.getItemID());
                    if (!TextUtils.isEmpty(textEditorData.getPagFilePath())) {
                        tAVSticker2.setFilePath(textEditorData.getPagFilePath());
                        tAVSticker2.setAssetFilePath(null);
                    } else {
                        tAVSticker2.setFilePath(tAVSticker.getFilePath());
                        tAVSticker2.setAssetFilePath(tAVSticker.getAssetFilePath());
                    }
                    tAVSticker2.setLayerIndex(tAVSticker.getLayerIndex());
                    tAVSticker2.setScale(tAVSticker.getScale());
                    tAVSticker2.setRotate(tAVSticker.getRotate());
                    tAVSticker2.setCenterX(tAVSticker.getCenterX());
                    tAVSticker2.setCenterY(tAVSticker.getCenterY());
                    tAVSticker2.setEditable(tAVSticker.isEditable());
                    tAVSticker2.setMinScale(tAVSticker.getMinScale());
                    tAVSticker2.setMaxScale(tAVSticker.getMaxScale());
                    tAVSticker2.setTimeRange(tAVSticker.getTimeRange());
                    try {
                        if (textEditorData.getInteractive().isEmpty()) {
                            TAVStickerExKt.setStickerInteractive(tAVSticker2, 0);
                        } else {
                            TAVStickerExKt.setStickerInteractive(tAVSticker2, Integer.parseInt(textEditorData.getInteractive()));
                        }
                    } catch (Exception e16) {
                        Logger.e(e16);
                    }
                    if (textEditorData.getStickerType() != null && textEditorData.getStickerType().equals("blur")) {
                        TAVStickerExKt.setExtraStickerType(tAVSticker2, textEditorData.getStickerType());
                        TAVStickerExKt.setStickerLockRatio(tAVSticker2, false);
                        TAVStickerExKt.setStickerEnableRotate(tAVSticker2, false);
                        TAVStickerExKt.setStickerScaleX(tAVSticker2, tAVSticker.getScale());
                        TAVStickerExKt.setStickerScaleY(tAVSticker2, tAVSticker.getScale());
                        TAVStickerExKt.setStickerTextPngPath(tAVSticker2, textEditorData.getBlurTextPath());
                        TAVStickerExKt.setStickerTexturePngPath(tAVSticker2, textEditorData.getBlurTexturePath());
                        tAVSticker2.setRotate(0.0f);
                    }
                    tAVSticker2.init();
                    ArrayList<TAVStickerSolidItem> stickerSolidItems = tAVSticker2.getStickerSolidItems();
                    if (!CollectionUtil.isEmptyList(stickerSolidItems)) {
                        for (TAVStickerSolidItem tAVStickerSolidItem : stickerSolidItems) {
                            if (textEditorData.getColorList().containsKey(tAVStickerSolidItem.getLayerName())) {
                                tAVStickerSolidItem.setColor(textEditorData.getColorList().get(tAVStickerSolidItem.getLayerName()).intValue());
                            }
                        }
                    }
                    if (!tAVSticker2.getStickerTextItems().isEmpty() && TAVStickerExKt.isStickerCarryTextFromOther(tAVSticker)) {
                        tAVSticker2.getStickerTextItems().get(0).setText(textEditorData.getContent());
                        tAVSticker2.getStickerTextItems().get(0).setTextColor(textEditorData.getTextColor());
                        tAVSticker2.getStickerTextItems().get(0).setFontPath(textEditorData.getFontPath());
                        TAVStickerExKt.setStickerCarryTextFromOther(tAVSticker2, true);
                    }
                    tAVSticker2.updateTextData();
                    tAVSticker2.updateImageData();
                    StickerOperationCallback stickerOperationCallback = this.stickerOperationCallback;
                    if (stickerOperationCallback != null) {
                        stickerOperationCallback.onUpdateTextStickerDone(tAVSticker2.getStickerId());
                    }
                    this.stickerContext.loadSticker(tAVSticker2);
                    return tAVSticker2;
                }
            }
        } catch (StickerInitializationException e17) {
            Logger.e(e17);
        }
        return null;
    }

    public StickerController(Context context, @Nullable StickerEditViewIconConfig stickerEditViewIconConfig) {
        this.dataChangedCount = 0;
        this.operationMode = TAVStickerOperationMode.OP_NONE;
        this.ctx = context;
        this.stickerEditViewIconConfig = stickerEditViewIconConfig;
        initContentView(context);
        init();
    }

    public void addSticker(final TAVSticker tAVSticker, final boolean z16) {
        Pair<Float, Float> calcStickerCenterPosition = calcStickerCenterPosition(tAVSticker.getCenterX(), tAVSticker.getCenterY());
        tAVSticker.setCenterX(((Float) calcStickerCenterPosition.first).floatValue());
        tAVSticker.setCenterY(((Float) calcStickerCenterPosition.second).floatValue());
        HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.editor.sticker.StickerController.4
            @Override // java.lang.Runnable
            public void run() {
                if (StickerController.this.stickerContext == null) {
                    return;
                }
                if (!WsStickerConstant.StickerType.STICKER_LYRIC.equals(TAVStickerExKt.getExtraStickerType(tAVSticker)) && z16) {
                    StickerController.this.stickerContext.loadSticker(tAVSticker);
                } else {
                    StickerController.this.stickerContext.loadSticker(tAVSticker, false);
                }
            }
        });
    }

    public void removeAllStickers() {
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext != null) {
            tAVStickerContext.removeAllStickers();
        }
    }

    @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface
    public void alignStickers(long j3) {
    }
}
