package com.tencent.tavsticker.core;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.MainThread;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tavsticker.core.TAVStickerContentView;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerContext extends TAVStickerRenderContext {
    private static final int CLICK_DURATION = 200;
    private static final String TAG = "TAVStickerContext";
    private Context context;
    private TAVStickerContentView stickerContainerView = null;
    private ViewGroup stickerContainer = null;
    private boolean touchable = true;
    private List<WeakReference<ITAVStickerContextObserver>> observerRefs = new ArrayList();
    private Map<String, TAVStickerEditView> stickerViewCacheMap = new HashMap();
    private TAVSticker currentSticker = null;
    private ITAVStickerContextDataSource dataSource = null;
    private OnTouchStickerOutsideListener onTouchStickerOutsideListener = null;
    private a dispatchTouchEventListener = new a();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnTouchStickerOutsideListener {
        void onTouchStickerOutside(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements TAVStickerContentView.DispatchTouchEventListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f374474a = false;

        /* renamed from: b, reason: collision with root package name */
        int f374475b = -1;

        /* renamed from: c, reason: collision with root package name */
        b f374476c;

        public a() {
        }

        public void a(b bVar) {
            this.f374476c = bVar;
        }

        public void b() {
            this.f374475b = 1;
        }

        @Override // com.tencent.tavsticker.core.TAVStickerContentView.DispatchTouchEventListener
        public boolean onDispatchTouchEvent(MotionEvent motionEvent) {
            boolean z16;
            if (TAVStickerContext.this.touchable && !this.f374474a) {
                if (motionEvent != null) {
                    int action = motionEvent.getAction();
                    PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                    TAVSticker touchStickerFromUI = TAVStickerContext.this.getTouchStickerFromUI(pointF);
                    if (1 == action && TAVStickerContext.this.checkClickInterval(motionEvent)) {
                        if (touchStickerFromUI != null) {
                            if (touchStickerFromUI != TAVStickerContext.this.currentSticker) {
                                TLog.d(TAVStickerContext.TAG, "onTouch -> \u5f53\u524d\u9009\u4e2d\u8d34\u7eb8, " + touchStickerFromUI);
                                TAVStickerContext.this.activeSticker(touchStickerFromUI);
                                TAVStickerEditView currentStickerEditView = TAVStickerContext.this.getCurrentStickerEditView();
                                if (currentStickerEditView != null) {
                                    currentStickerEditView.stickerEventListener.onStickerClick(touchStickerFromUI, motionEvent);
                                }
                                this.f374475b = 1;
                            } else {
                                TAVStickerEditView currentStickerEditView2 = TAVStickerContext.this.getCurrentStickerEditView();
                                if (currentStickerEditView2 != null) {
                                    currentStickerEditView2.handleTouchEvent(currentStickerEditView2, motionEvent);
                                }
                            }
                        } else {
                            if (TAVStickerContext.this.onTouchStickerOutsideListener != null) {
                                TLog.d(TAVStickerContext.TAG, "onTouch -> onTouchStickerOutside, touchable : false");
                                TAVStickerContext.this.onTouchStickerOutsideListener.onTouchStickerOutside(motionEvent);
                                this.f374475b = -1;
                            }
                            b bVar = this.f374476c;
                            if (bVar != null && bVar.shouldInterceptTouch() && this.f374476c.checkInterceptArea(pointF)) {
                                this.f374475b = 2;
                                this.f374474a = true;
                                this.f374476c.touchInterceptArea(pointF);
                            }
                            return false;
                        }
                    } else {
                        TAVStickerEditView currentStickerEditView3 = TAVStickerContext.this.getCurrentStickerEditView();
                        if (currentStickerEditView3 != null) {
                            z16 = currentStickerEditView3.handleTouchEvent(currentStickerEditView3, motionEvent);
                        } else {
                            z16 = false;
                        }
                        if (action == 0) {
                            if (this.f374475b != 1 && touchStickerFromUI == null) {
                                return false;
                            }
                            return true;
                        }
                        return z16;
                    }
                }
            } else if (TAVStickerContext.this.onTouchStickerOutsideListener != null) {
                TLog.d(TAVStickerContext.TAG, "onTouch -> onTouchStickerOutside, touchable : false");
                TAVStickerContext.this.onTouchStickerOutsideListener.onTouchStickerOutside(motionEvent);
            }
            return false;
        }

        @Override // com.tencent.tavsticker.core.TAVStickerContentView.DispatchTouchEventListener
        public boolean onHackedTouchEvent(MotionEvent motionEvent) {
            boolean z16 = false;
            if (TAVStickerContext.this.touchable) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    float containerWidth = TAVStickerContext.this.getContainerWidth();
                    TAVStickerContext tAVStickerContext = TAVStickerContext.this;
                    if (containerWidth != tAVStickerContext.renderSize.width) {
                        x16 = TAVStickerUtil.covertCoordinate(x16, tAVStickerContext.getContainerWidth(), (int) TAVStickerContext.this.renderSize.width);
                    }
                    float containerHeight = TAVStickerContext.this.getContainerHeight();
                    TAVStickerContext tAVStickerContext2 = TAVStickerContext.this;
                    if (containerHeight != tAVStickerContext2.renderSize.height) {
                        y16 = TAVStickerUtil.covertCoordinate(y16, tAVStickerContext2.getContainerHeight(), (int) TAVStickerContext.this.renderSize.height);
                    }
                    TAVSticker touchedSticker = TAVStickerContext.this.getTouchedSticker(x16, y16);
                    if (touchedSticker != null && touchedSticker != TAVStickerContext.this.currentSticker) {
                        TLog.d(TAVStickerContext.TAG, "onTouch -> \u5f53\u524d\u9009\u4e2d\u8d34\u7eb8, " + touchedSticker);
                        TAVStickerContext.this.activeSticker(touchedSticker);
                        TAVStickerEditView currentStickerEditView = TAVStickerContext.this.getCurrentStickerEditView();
                        if (currentStickerEditView != null) {
                            currentStickerEditView.stickerEventListener.onStickerClick(touchedSticker, motionEvent);
                        }
                        this.f374475b = 1;
                    }
                }
                TAVStickerEditView currentStickerEditView2 = TAVStickerContext.this.getCurrentStickerEditView();
                if (currentStickerEditView2 != null) {
                    z16 = currentStickerEditView2.handleTouchEvent(currentStickerEditView2, motionEvent);
                }
                if (!z16) {
                    TLog.d(TAVStickerContext.TAG, "onTouch -> onTouchStickerOutside, touchable : false");
                    if (TAVStickerContext.this.onTouchStickerOutsideListener != null) {
                        TAVStickerContext.this.onTouchStickerOutsideListener.onTouchStickerOutside(motionEvent);
                    }
                }
                return z16;
            }
            if (TAVStickerContext.this.onTouchStickerOutsideListener != null) {
                TLog.d(TAVStickerContext.TAG, "onTouch -> onTouchStickerOutside, touchable : false");
                TAVStickerContext.this.onTouchStickerOutsideListener.onTouchStickerOutside(motionEvent);
            }
            return false;
        }

        @Override // com.tencent.tavsticker.core.TAVStickerContentView.DispatchTouchEventListener
        public void setInterceptEvent(Boolean bool) {
            this.f374474a = bool.booleanValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        boolean checkInterceptArea(PointF pointF);

        boolean shouldInterceptTouch();

        void touchInterceptArea(PointF pointF);
    }

    public TAVStickerContext(Context context) {
        this.context = null;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkClickInterval(MotionEvent motionEvent) {
        if (motionEvent.getEventTime() - motionEvent.getDownTime() < 200) {
            return true;
        }
        return false;
    }

    private void checkObserverList() {
        if (this.observerRefs == null) {
            this.observerRefs = new ArrayList();
        }
    }

    private void checkStickerViewCacheMap() {
        if (this.stickerViewCacheMap == null) {
            this.stickerViewCacheMap = new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerHeight() {
        int height = getTavStickerContentViewSafely().getHeight();
        if (height <= 0) {
            return ScreenUtil.getScreenHeight();
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerWidth() {
        int width = getTavStickerContentViewSafely().getWidth();
        if (width <= 0) {
            return ScreenUtil.getScreenWidth();
        }
        return width;
    }

    private PointF getCovertCoordinate(PointF pointF) {
        float f16 = pointF.x;
        float f17 = pointF.y;
        if (getContainerWidth() != this.renderSize.width) {
            f16 = TAVStickerUtil.covertCoordinate(pointF.x, getContainerWidth(), (int) this.renderSize.width);
        }
        if (getContainerHeight() != this.renderSize.height) {
            f17 = TAVStickerUtil.covertCoordinate(pointF.y, getContainerHeight(), (int) this.renderSize.height);
        }
        return new PointF(f16, f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TAVSticker getTouchStickerFromUI(PointF pointF) {
        PointF covertCoordinate = getCovertCoordinate(pointF);
        return getTouchedSticker(covertCoordinate.x, covertCoordinate.y);
    }

    private void notifyCurrentStickerStateChanged(boolean z16) {
        checkObserverList();
        for (WeakReference<ITAVStickerContextObserver> weakReference : this.observerRefs) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onCurrentStickerStateChanged(this, z16);
            }
        }
    }

    private void notifyStickerActive(TAVStickerEditView tAVStickerEditView) {
        checkObserverList();
        for (WeakReference<ITAVStickerContextObserver> weakReference : this.observerRefs) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onStickerActive(this, tAVStickerEditView);
            }
        }
    }

    private void notifyStickerAdd(TAVStickerEditView tAVStickerEditView) {
        checkObserverList();
        for (WeakReference<ITAVStickerContextObserver> weakReference : this.observerRefs) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onStickerAdd(this, tAVStickerEditView);
            }
        }
    }

    private void notifyStickerListChanged() {
        checkObserverList();
        for (WeakReference<ITAVStickerContextObserver> weakReference : this.observerRefs) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onStickerListChanged(this);
            }
        }
    }

    private void notifyStickerRemove(TAVStickerEditView tAVStickerEditView) {
        checkObserverList();
        for (WeakReference<ITAVStickerContextObserver> weakReference : this.observerRefs) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onStickerRemove(this, tAVStickerEditView);
            }
        }
    }

    private void notifyStickerResign(TAVStickerEditView tAVStickerEditView) {
        checkObserverList();
        for (WeakReference<ITAVStickerContextObserver> weakReference : this.observerRefs) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onStickerResign(this, tAVStickerEditView);
            }
        }
    }

    private void resignStickerInner(TAVSticker tAVSticker, boolean z16) {
        if (tAVSticker != null) {
            TAVStickerMode tAVStickerMode = TAVStickerMode.INACTIVE;
            tAVSticker.setMode(tAVStickerMode);
            removeAllViews();
            String uniqueId = tAVSticker.getUniqueId();
            checkStickerViewCacheMap();
            TAVStickerEditView tAVStickerEditView = this.stickerViewCacheMap.get(uniqueId);
            if (tAVStickerEditView != null) {
                tAVStickerEditView.setMode(tAVStickerMode);
            }
            this.currentSticker = null;
            notifyStickerResign(tAVStickerEditView);
            if (z16) {
                notifyCurrentStickerStateChanged(false);
            }
            syncAllChildContext();
        }
    }

    private boolean shouldShowSticker(TAVSticker tAVSticker, long j3) {
        if (tAVSticker == null) {
            return false;
        }
        ITAVRenderContextDataSource iTAVRenderContextDataSource = this.renderContextDataSource;
        if (iTAVRenderContextDataSource != null) {
            return iTAVRenderContextDataSource.shouldRenderSticker(tAVSticker, j3);
        }
        if (!TAVStickerUtil.isPresentationTimeInStickerTimeRange(j3, tAVSticker) || TAVStickerMode.ACTIVE != tAVSticker.getMode()) {
            return false;
        }
        return true;
    }

    private void updateAllStickerLayerIndex() {
        checkStickerList();
        this.stickerLayerIndex = 0;
        for (TAVSticker tAVSticker : this.stickers) {
            if (tAVSticker != null && -1 == tAVSticker.getLayerIndex()) {
                int i3 = this.stickerLayerIndex;
                this.stickerLayerIndex = i3 + 1;
                tAVSticker.setLayerIndex(i3);
            }
        }
    }

    @MainThread
    public void activeSticker(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            TAVSticker tAVSticker2 = this.currentSticker;
            if (tAVSticker2 != null && !tAVSticker.equals(tAVSticker2)) {
                resignStickerInner(this.currentSticker, false);
            }
            TAVStickerMode tAVStickerMode = TAVStickerMode.ACTIVE;
            tAVSticker.setMode(tAVStickerMode);
            this.currentSticker = tAVSticker;
            checkStickerViewCacheMap();
            TAVStickerEditView tAVStickerEditView = this.stickerViewCacheMap.get(tAVSticker.getUniqueId());
            if (tAVStickerEditView != null) {
                removeAllViews();
                addView(tAVStickerEditView, true);
                tAVStickerEditView.setMode(tAVStickerMode);
                if (tAVSticker.isAutoPlay()) {
                    tAVStickerEditView.play(0);
                }
                notifyStickerActive(tAVStickerEditView);
            }
            notifyCurrentStickerStateChanged(true);
            syncAllChildContext();
        }
    }

    public void addView(View view, boolean z16) {
        if (z16) {
            getTavStickerContentViewSafely().addView(view);
        }
    }

    public TAVStickerEditView fetchStickerView(TAVSticker tAVSticker) {
        if (tAVSticker == null) {
            return null;
        }
        checkStickerViewCacheMap();
        return this.stickerViewCacheMap.get(tAVSticker.getUniqueId());
    }

    public TAVSticker getCurrentSticker() {
        return this.currentSticker;
    }

    public TAVStickerEditView getCurrentStickerEditView() {
        return fetchStickerView(this.currentSticker);
    }

    public a getDispatchTouchEventListener() {
        return this.dispatchTouchEventListener;
    }

    protected TAVStickerContentView getTavStickerContentViewSafely() {
        if (this.stickerContainerView == null) {
            TAVStickerContentView tAVStickerContentView = new TAVStickerContentView(this.context);
            this.stickerContainerView = tAVStickerContentView;
            tAVStickerContentView.setDispatchTouchEventListener(this.dispatchTouchEventListener);
        }
        return this.stickerContainerView;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    protected TAVSticker getTouchedSticker(float f16, float f17) {
        TAVSticker tAVSticker = this.currentSticker;
        if (tAVSticker != null && TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.presentationTimeMs, tAVSticker) && this.currentSticker.isEditable() && isTouchOnTavSticker(this.currentSticker, f16, f17)) {
            return this.currentSticker;
        }
        return super.getTouchedSticker(f16, f17);
    }

    public boolean isTouchable() {
        return this.touchable;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @MainThread
    public void loadSticker(TAVSticker tAVSticker, boolean z16) {
        if (tAVSticker != null) {
            checkStickerViewCacheMap();
            String uniqueId = tAVSticker.getUniqueId();
            if (this.stickerViewCacheMap.containsKey(tAVSticker.getUniqueId())) {
                return;
            }
            TAVSticker tAVSticker2 = this.currentSticker;
            if (tAVSticker2 != null && !tAVSticker.equals(tAVSticker2)) {
                resignStickerInner(this.currentSticker, false);
            }
            super.loadSticker(tAVSticker, z16);
            tAVSticker.setMode(z16 ? TAVStickerMode.ACTIVE : TAVStickerMode.INACTIVE);
            TAVStickerEditView tAVStickerEditView = null;
            this.currentSticker = z16 ? tAVSticker : null;
            ITAVStickerContextDataSource iTAVStickerContextDataSource = this.dataSource;
            if (iTAVStickerContextDataSource != null) {
                tAVStickerEditView = iTAVStickerContextDataSource.loadSticker(this, tAVSticker);
            } else {
                TLog.w(TAG, "loadSticker -> you did not call the setTavStickerContextDataSource method!");
            }
            if (tAVStickerEditView == null) {
                tAVStickerEditView = new TAVStickerEditView(this.context, tAVSticker);
            }
            this.stickerViewCacheMap.put(uniqueId, tAVStickerEditView);
            tAVStickerEditView.setMode(z16 ? TAVStickerMode.ACTIVE : TAVStickerMode.INACTIVE);
            removeAllViews();
            addView(tAVStickerEditView, z16);
            if (z16) {
                this.dispatchTouchEventListener.b();
            }
            notifyStickerAdd(tAVStickerEditView);
            if (z16) {
                notifyStickerActive(tAVStickerEditView);
            } else {
                notifyStickerResign(tAVStickerEditView);
            }
            notifyCurrentStickerStateChanged(z16);
            notifyStickerListChanged();
        }
    }

    public void registerObserver(ITAVStickerContextObserver iTAVStickerContextObserver) {
        checkObserverList();
        if (iTAVStickerContextObserver != null) {
            this.observerRefs.add(new WeakReference<>(iTAVStickerContextObserver));
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public synchronized void release() {
        super.release();
        try {
            this.stickerContainerView = null;
            this.observerRefs.clear();
            this.stickerViewCacheMap.clear();
            this.currentSticker = null;
            this.dataSource = null;
            this.onTouchStickerOutsideListener = null;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @MainThread
    public void reloadAllStickers() {
        super.reloadAllStickers();
        checkStickerViewCacheMap();
        updateAllStickerLayerIndex();
        sortedAllStickers();
        if (this.stickers != null) {
            getTavStickerContentViewSafely().removeAllViews();
            for (TAVSticker tAVSticker : this.stickers) {
                if (tAVSticker != null) {
                    TAVStickerEditView tAVStickerEditView = this.stickerViewCacheMap.get(tAVSticker.getUniqueId());
                    if (tAVStickerEditView != null) {
                        getTavStickerContentViewSafely().addView(tAVStickerEditView);
                    } else {
                        loadSticker(tAVSticker);
                    }
                }
            }
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @MainThread
    public void reloadStickers(List<TAVSticker> list) {
        super.reloadStickers(list);
        reloadAllStickers();
        notifyStickerListChanged();
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @MainThread
    public void removeAllStickers() {
        super.removeAllStickers();
        checkStickerViewCacheMap();
        if (!CollectionUtil.isEmptyMap(this.stickerViewCacheMap)) {
            Collection<TAVStickerEditView> values = this.stickerViewCacheMap.values();
            if (values != null) {
                Iterator<TAVStickerEditView> it = values.iterator();
                while (it.hasNext()) {
                    notifyStickerRemove(it.next());
                }
            }
            notifyStickerListChanged();
        }
        this.stickerViewCacheMap.clear();
        getTavStickerContentViewSafely().removeAllViews();
        setCurrentSticker(null);
    }

    public void removeAllViews() {
        getTavStickerContentViewSafely().removeAllViews();
    }

    @MainThread
    public boolean removeCurrentSticker() {
        return removeSticker(this.currentSticker);
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @MainThread
    public boolean removeSticker(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            checkStickerViewCacheMap();
            boolean removeSticker = super.removeSticker(tAVSticker);
            TAVStickerEditView remove = this.stickerViewCacheMap.remove(tAVSticker.getUniqueId());
            if (remove != null) {
                getTavStickerContentViewSafely().removeView(remove);
            }
            TAVSticker tAVSticker2 = this.currentSticker;
            if (tAVSticker2 != null && tAVSticker.equals(tAVSticker2)) {
                this.currentSticker = null;
            }
            notifyStickerRemove(remove);
            notifyStickerListChanged();
            return removeSticker;
        }
        return false;
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    public CMSampleBuffer renderSticker(long j3, List<TAVSourceImage> list) {
        renderStickerEditView(j3);
        return super.renderSticker(j3, list);
    }

    protected void renderStickerEditView(long j3) {
        TAVSticker tAVSticker;
        final int i3;
        final TAVStickerEditView currentStickerEditView = getCurrentStickerEditView();
        if (currentStickerEditView != null && (tAVSticker = this.currentSticker) != null) {
            if (shouldShowSticker(tAVSticker, j3)) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            if (i3 != currentStickerEditView.getVisibility()) {
                currentStickerEditView.post(new Runnable() { // from class: com.tencent.tavsticker.core.TAVStickerContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        currentStickerEditView.setVisibility(i3);
                    }
                });
            }
        }
    }

    @MainThread
    public void resignCurrentSticker() {
        resignSticker(this.currentSticker);
    }

    @MainThread
    public void resignSticker(TAVSticker tAVSticker) {
        resignStickerInner(tAVSticker, true);
    }

    public void setCurrentSticker(TAVSticker tAVSticker) {
        this.currentSticker = tAVSticker;
    }

    public void setOnTouchStickerOutsideListener(OnTouchStickerOutsideListener onTouchStickerOutsideListener) {
        this.onTouchStickerOutsideListener = onTouchStickerOutsideListener;
    }

    public void setStickerContainer(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.stickerContainer = viewGroup;
            this.stickerContainer.addView(getTavStickerContentViewSafely(), new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setTavStickerContentView(TAVStickerContentView tAVStickerContentView) {
        if (tAVStickerContentView != null && tAVStickerContentView != this.stickerContainerView) {
            this.stickerContainerView = tAVStickerContentView;
            tAVStickerContentView.setDispatchTouchEventListener(this.dispatchTouchEventListener);
        }
    }

    public void setTavStickerContextDataSource(ITAVStickerContextDataSource iTAVStickerContextDataSource) {
        this.dataSource = iTAVStickerContextDataSource;
    }

    public void setTouchable(boolean z16) {
        this.touchable = z16;
    }

    public void unRegisterObserver(ITAVStickerContextObserver iTAVStickerContextObserver) {
        checkObserverList();
        if (iTAVStickerContextObserver != null) {
            for (WeakReference weakReference : new ArrayList(this.observerRefs)) {
                if (weakReference != null && iTAVStickerContextObserver == weakReference.get()) {
                    this.observerRefs.remove(weakReference);
                }
            }
        }
    }

    @Override // com.tencent.tavsticker.core.TAVStickerRenderContext
    @MainThread
    public void loadSticker(TAVSticker tAVSticker) {
        loadSticker(tAVSticker, true);
    }
}
