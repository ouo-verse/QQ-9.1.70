package com.qzone.canvasui.widget;

import NS_MOBILE_COMM.CommInteractive;
import NS_MOBILE_COMM.stOperaData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellUniverse;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.model.m;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.widget.g;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.DittoAreaViewInfo;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoAreaEnv;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.widget.DittoBridgeArea;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneCanvasAreaView extends DittoAreaView implements g {
    private static final String SCHEME_PREFIX = "ditto://";
    private static final String SCHEME_PREFIX_OLD = "feed+canvasUI://";
    public static final int STATE_IDLE = 1;
    public static final int STATE_SCROLLING = 2;
    private static final String TAG = "QzoneCanvasAreaView";
    protected int feedPosition;
    protected List<DittoArea> mAccessibilityChildren;
    protected int mContainerIndex;
    private String mCurrentMd5;
    protected Handler mMainHandler;
    protected int mScrollState;
    protected ExploreByTouchHelper mTouchHelper;
    protected int mTrans;
    public com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    private boolean selfExposureHadReported;

    static {
        Map<String, Class> map = DittoAreaEnv.mAreaLib;
        map.put("com.qzone.canvasui.widget.AsyncCanvasImageArea", AsyncCanvasImageArea.class);
        map.put("com.qzone.canvasui.widget.CanvasAttachArea", CanvasAttachArea.class);
        map.put("com.qzone.canvasui.widget.CanvasCommentTextArea", CanvasCommentTextArea.class);
        map.put("com.qzone.canvasui.widget.CanvasMultiGifArea", CanvasMultiGifArea.class);
        map.put("com.qzone.canvasui.widget.CanvasNicknameArea", CanvasNicknameArea.class);
        map.put("com.qzone.canvasui.widget.FeedDynamicAlbumCanvasArea", FeedDynamicAlbumCanvasArea.class);
        map.put("com.qzone.canvasui.widget.FeedSinglePicCanvasArea", FeedSinglePicCanvasArea.class);
        map.put("com.qzone.canvasui.widget.LineArea", LineArea.class);
        map.put("com.qzone.canvasui.widget.RichCanvasTextArea", RichCanvasTextArea.class);
        map.put("com.qzone.canvasui.widget.TagImageArea", TagImageArea.class);
        map.put("com.qzone.canvasui.widget.TimeCountDownArea", TimeCountDownArea.class);
        DittoAreaView.sAptIdFuncPolyMap = DittoAreaViewInfo.getInstance().idFuncPolyMap;
    }

    public QzoneCanvasAreaView(Context context) {
        super(context);
        this.selfExposureHadReported = false;
        this.mTrans = 255;
        this.mScrollState = 1;
        this.mAccessibilityChildren = new ArrayList();
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    private void convertAreaInfo(StringBuilder sb5, DittoArea dittoArea) {
        if (dittoArea.getVisibility() != 0) {
            return;
        }
        if (dittoArea instanceof DittoAreaGroup) {
            Iterator<DittoArea> it = ((DittoAreaGroup) dittoArea).getChildren().iterator();
            while (it.hasNext()) {
                convertAreaInfo(sb5, it.next());
            }
            return;
        }
        int[] locationToViewHost = DittoAreaView.getLocationToViewHost(dittoArea);
        sb5.append(dittoArea.getId());
        sb5.append("(");
        sb5.append(locationToViewHost[0]);
        sb5.append(",");
        sb5.append(locationToViewHost[1]);
        sb5.append(",");
        sb5.append(locationToViewHost[0] + dittoArea.getWidth());
        sb5.append(",");
        sb5.append(locationToViewHost[1] + dittoArea.getHeight());
        sb5.append(")");
    }

    private boolean handlePrivateScheme(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        String str2 = SCHEME_PREFIX;
        if (!str.startsWith(SCHEME_PREFIX)) {
            str2 = SCHEME_PREFIX_OLD;
            if (!str.startsWith(SCHEME_PREFIX_OLD)) {
                str2 = null;
            }
        }
        if (str2 != null) {
            try {
                String substring = str.substring(str2.length());
                Uri parse = Uri.parse(str);
                if ("dismissFeed".equals(substring)) {
                    com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(this, FeedElement.FEEDBACK, this.feedPosition, "issuedTemplate");
                    }
                    return true;
                }
                if ("showDropDown".equals(substring)) {
                    if (this.onFeedElementClickListener != null) {
                        int[] locationToViewHost = DittoAreaView.getLocationToViewHost(dittoArea);
                        this.onFeedElementClickListener.onClick(this, FeedElement.DROPDOWN_BUTTON, this.feedPosition, new ClickedPoint(locationToViewHost[0], locationToViewHost[1], 0, 0, dittoArea.getWidth(), dittoArea.getHeight()));
                    }
                    return true;
                }
                if (substring.startsWith("openMiniAIO")) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.OPEN_MINI_AIO, this.feedPosition, new m(parse.getQueryParameter("uin"), parse.getQueryParameter("nickname"), parse.getQueryParameter("type"), parse.getQueryParameter("autoSendArkMsg")));
                    return true;
                }
                if ("like".equals(substring)) {
                    com.qzone.proxy.feedcomponent.ui.g gVar2 = this.onFeedElementClickListener;
                    FeedElement feedElement = FeedElement.PRAISE_BUTTON;
                    int i3 = this.feedPosition;
                    gVar2.onClick(this, feedElement, i3, Integer.valueOf(i3));
                } else if ("comment".equals(substring)) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_BUTTON, this.feedPosition, null);
                } else if ("qqProfile".equals(substring)) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.TO_QQ_PROFILE, this.feedPosition, null);
                } else if ("openFeedDetail".equals(substring)) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.OPEN_FEED_DETAIL, this.feedPosition, null);
                } else if ("copy".equals(substring)) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.COPY_TEXT, this.feedPosition, null);
                } else if ("doNothing".equals(substring)) {
                    return true;
                }
            } catch (Exception e16) {
                b.d(TAG, "handlePrivateScheme failed: " + e16.getMessage(), e16);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void recycleRichArea(DittoArea dittoArea) {
        if (dittoArea instanceof DittoAreaGroup) {
            Iterator<DittoArea> it = ((DittoAreaGroup) dittoArea).getChildren().iterator();
            while (it.hasNext()) {
                recycleRichArea(it.next());
            }
        } else if (dittoArea instanceof RichCanvasTextArea) {
            ((RichCanvasTextArea) dittoArea).onRecycled();
        } else if (dittoArea instanceof g) {
            ((g) dittoArea).onRecycled();
        }
    }

    public String convertToViewTree() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getSimpleName());
        sb5.append("[");
        if (getCanvasArea() != null) {
            convertAreaInfo(sb5, getCanvasArea());
        }
        sb5.append("]");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        ExploreByTouchHelper exploreByTouchHelper;
        return (i.H().S0() && (exploreByTouchHelper = this.mTouchHelper) != null && exploreByTouchHelper.dispatchHoverEvent(motionEvent)) || super.dispatchHoverEvent(motionEvent);
    }

    public <T> T findBridgeViewById(String str, Class<T> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            try {
                DittoArea canvasArea = getCanvasArea();
                if (canvasArea instanceof DittoAreaGroup) {
                    DittoArea findChildById = ((DittoAreaGroup) canvasArea).findChildById(str);
                    if (findChildById instanceof DittoBridgeArea) {
                        T t16 = (T) ((DittoBridgeArea) findChildById).getContainedView();
                        if (t16.getClass().equals(cls)) {
                            return t16;
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    public int getContainerIndex() {
        return this.mContainerIndex;
    }

    public int getFeedPosition() {
        return this.feedPosition;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.mMainHandler;
    }

    @Override // com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void handleSilentRequest(String str, String str2, int i3, final DittoArea dittoArea, MotionEvent motionEvent) {
        CellUniverse cellUniverse;
        Map<Integer, byte[]> map;
        byte[] bArr;
        final Object currentViewModel = getCurrentViewModel();
        if (!(currentViewModel instanceof BusinessFeedData) || (cellUniverse = ((BusinessFeedData) currentViewModel).cellUniverse) == null || (map = cellUniverse.requestData) == null || (bArr = map.get(Integer.valueOf(i3))) == null) {
            return;
        }
        i.H().S2(str, str2, bArr, new DittoHost.SilentRequestCallback() { // from class: com.qzone.canvasui.widget.QzoneCanvasAreaView.1
            @Override // com.tencent.ditto.area.DittoHost.SilentRequestCallback
            public void onResponse(Object obj) {
                stOperaData stoperadata;
                QzoneCanvasAreaView qzoneCanvasAreaView;
                com.qzone.proxy.feedcomponent.ui.g gVar;
                if (obj instanceof CommInteractive) {
                    CommInteractive commInteractive = (CommInteractive) obj;
                    if (commInteractive.iRet != 0) {
                        FeedGlobalEnv.g().showToast(1000, QzoneCanvasAreaView.this.getContext(), commInteractive.strErrToast);
                        return;
                    }
                    int i16 = commInteractive.interactiveType;
                    if (i16 == 1) {
                        QzoneCanvasAreaView qzoneCanvasAreaView2 = QzoneCanvasAreaView.this;
                        com.qzone.proxy.feedcomponent.ui.g gVar2 = qzoneCanvasAreaView2.onFeedElementClickListener;
                        if (gVar2 != null) {
                            gVar2.onClick(qzoneCanvasAreaView2, FeedElement.REFRESH_PAGE, qzoneCanvasAreaView2.feedPosition, "");
                            return;
                        }
                        return;
                    }
                    if (i16 == 2) {
                        if (dittoArea.getPostClickKey() != null) {
                            dittoArea.getPostClickKey().setValue(currentViewModel, commInteractive.opData.strData);
                            Object currentViewModel2 = QzoneCanvasAreaView.this.getCurrentViewModel();
                            Object obj2 = currentViewModel;
                            if (currentViewModel2 == obj2) {
                                QzoneCanvasAreaView.this.updateViewModel(obj2);
                                QzoneCanvasAreaView.this.storageViewModel(true);
                                return;
                            } else {
                                if (obj2 instanceof BusinessFeedData) {
                                    EventCenter.getInstance().post("writeOperation", 78, ((BusinessFeedData) currentViewModel).getFeedCommInfo().ugckey, Boolean.TRUE);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    if (i16 == 3) {
                        QzoneCanvasAreaView qzoneCanvasAreaView3 = QzoneCanvasAreaView.this;
                        com.qzone.proxy.feedcomponent.ui.g gVar3 = qzoneCanvasAreaView3.onFeedElementClickListener;
                        if (gVar3 != null) {
                            gVar3.onClick(qzoneCanvasAreaView3, FeedElement.FEEDBACK, qzoneCanvasAreaView3.feedPosition, "issuedTemplate");
                            return;
                        }
                        return;
                    }
                    if (i16 == 4) {
                        if (commInteractive.opData != null) {
                            FeedGlobalEnv.g().showToast(1000, QzoneCanvasAreaView.this.getContext(), commInteractive.opData.strData);
                        }
                    } else {
                        if (i16 != 5 || (stoperadata = commInteractive.opData) == null || (gVar = (qzoneCanvasAreaView = QzoneCanvasAreaView.this).onFeedElementClickListener) == null) {
                            return;
                        }
                        FeedElement feedElement = FeedElement.URL;
                        int i17 = qzoneCanvasAreaView.feedPosition;
                        gVar.onClick(qzoneCanvasAreaView, feedElement, i17, new e(stoperadata.strData, "", i17));
                    }
                }
            }
        });
    }

    @Override // com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void handleSilentUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        i.H().R2(str);
        if (!TextUtils.isEmpty(dittoArea.getSilentUriSentToast())) {
            FeedGlobalEnv.g().showToast(1000, getContext(), dittoArea.getSilentUriSentToast());
        }
        if (dittoArea.getTttReportArea() != -1) {
            reportTTTClick(dittoArea.getTttReportArea());
        }
    }

    @Override // com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void handleUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        com.qzone.proxy.feedcomponent.ui.g gVar;
        if (!TextUtils.isEmpty(str)) {
            if (handlePrivateScheme(str, dittoArea, motionEvent) || (gVar = this.onFeedElementClickListener) == null) {
                return;
            }
            FeedElement feedElement = FeedElement.URL;
            int i3 = this.feedPosition;
            gVar.onClick(this, feedElement, i3, new e(str, "", i3));
            if (dittoArea.getTttReportArea() != -1) {
                reportTTTClick(dittoArea.getTttReportArea());
                return;
            }
            return;
        }
        b.c(TAG, "handleUri = null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.selfExposureHadReported) {
            return;
        }
        this.selfExposureHadReported = true;
        synchronized (this.exposureReportingAreas) {
            if (this.exposureReportingAreas.size() != 0) {
                for (DittoArea dittoArea : this.exposureReportingAreas) {
                    if (dittoArea.getVisibility() == 0) {
                        DittoUIEngine.g().getReporter().compassReport(dittoArea.getCompassExposureKey());
                    }
                }
            }
        }
    }

    @Override // com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void removeAccessibilityArea(List<DittoArea> list) {
        this.mAccessibilityChildren.removeAll(list);
    }

    @Override // com.tencent.ditto.DittoAreaView
    public void reportTTTClick(int i3) {
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            gVar.onClick(this, FeedElement.CANVAS_UI_REPORT_TTT_CLICK, this.feedPosition, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.ditto.DittoAreaView, android.view.View, com.tencent.ditto.area.DittoHost
    public void requestLayout() {
        try {
            super.requestLayout();
        } catch (Exception e16) {
            b.d(TAG, "np in requestLayout", e16);
        }
    }

    public void setAlpha(int i3) {
        this.mTrans = i3;
        com.qzone.reborn.feedx.widget.i.a(this, i3);
    }

    public void setContentAreaForJsonFile(String str) {
        setContentAreaForJsonFile(str, false);
    }

    public void setFeedPosition(int i3) {
        setFeedPosition(i3, -1);
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    @Override // com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void storageViewModel(boolean z16) {
        Object currentViewModel = getCurrentViewModel();
        if (currentViewModel instanceof BusinessFeedData) {
            EventCenter.getInstance().post("writeOperation", 78, ((BusinessFeedData) currentViewModel).getFeedCommInfo().ugckey, Boolean.valueOf(z16));
        } else {
            super.storageViewModel(z16);
        }
    }

    public void updateAccessibility() {
        if (i.H().S0()) {
            ExploreByTouchHelper exploreByTouchHelper = this.mTouchHelper;
            if (exploreByTouchHelper == null) {
                QzoneCanvasUITouchHelper qzoneCanvasUITouchHelper = new QzoneCanvasUITouchHelper(this);
                this.mTouchHelper = qzoneCanvasUITouchHelper;
                ViewCompat.setAccessibilityDelegate(this, qzoneCanvasUITouchHelper);
                ViewCompat.setImportantForAccessibility(this, 1);
                return;
            }
            ViewCompat.setAccessibilityDelegate(this, exploreByTouchHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class QzoneCanvasUITouchHelper extends ExploreByTouchHelper {
        public QzoneCanvasUITouchHelper(View view) {
            super(view);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            DittoArea findAreaByPosition = QzoneCanvasAreaView.this.findAreaByPosition(f16, f17);
            if (findAreaByPosition == null || !QzoneCanvasAreaView.this.mAccessibilityChildren.contains(findAreaByPosition)) {
                return Integer.MIN_VALUE;
            }
            return QzoneCanvasAreaView.this.mAccessibilityChildren.indexOf(findAreaByPosition);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (DittoArea dittoArea : QzoneCanvasAreaView.this.mAccessibilityChildren) {
                if (dittoArea != null && dittoArea.getVisibility() == 0 && dittoArea.getWidth() != 0 && dittoArea.getHeight() != 0) {
                    list.add(Integer.valueOf(QzoneCanvasAreaView.this.mAccessibilityChildren.indexOf(dittoArea)));
                }
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 26 || i16 != 16) {
                return false;
            }
            QzoneCanvasAreaView.this.playSoundEffect(0);
            invalidateVirtualView(i3);
            sendEventForVirtualView(i3, 1);
            return true;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(getDescriptionForIndex(i3));
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Rect rect;
            DittoArea dittoArea;
            accessibilityNodeInfoCompat.setContentDescription(getDescriptionForIndex(i3));
            accessibilityNodeInfoCompat.addAction(16);
            if (i3 < 0 || i3 >= QzoneCanvasAreaView.this.mAccessibilityChildren.size() || (dittoArea = QzoneCanvasAreaView.this.mAccessibilityChildren.get(i3)) == null) {
                rect = null;
            } else {
                int[] locationToViewHost = DittoAreaView.getLocationToViewHost(dittoArea);
                int i16 = locationToViewHost[0];
                rect = new Rect(i16, locationToViewHost[1], dittoArea.getWidth() + i16, locationToViewHost[1] + dittoArea.getHeight());
            }
            if (rect == null) {
                return;
            }
            if (rect.isEmpty()) {
                b.c("FeedTitleView", "virtual id = " + i3 + " is Empty");
            }
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
        }

        public String getDescriptionForIndex(int i3) {
            DittoArea dittoArea = (i3 < 0 || i3 >= QzoneCanvasAreaView.this.mAccessibilityChildren.size()) ? null : QzoneCanvasAreaView.this.mAccessibilityChildren.get(i3);
            if (dittoArea != null) {
                return dittoArea.getContentDescription();
            }
            return "";
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.onFeedElementClickListener = null;
        this.selfExposureHadReported = false;
        updateViewModel(null);
        DittoArea dittoArea = this.mDittoArea;
        if (dittoArea != null) {
            recycleRichArea(dittoArea);
        }
    }

    public void onStateIdle() {
        this.mScrollState = 1;
    }

    public void onStateScrolling() {
        this.mScrollState = 2;
    }

    @Override // com.tencent.ditto.DittoAreaView
    public void setContentAreaForJsonFile(String str, boolean z16) {
        String fileMd5 = !z16 ? DittoUIEngine.g().getFileMd5(str) : null;
        if (z16) {
            super.setContentAreaForJsonFile(str, true);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(fileMd5) || !fileMd5.equals(this.mCurrentMd5)) {
            if (!TextUtils.isEmpty(this.mCurrentMd5)) {
                b.e("CANVASUI", "cached area flushed:" + str + "md5" + fileMd5);
            }
            super.setContentAreaForJsonFile(str, false);
            this.mCurrentMd5 = fileMd5;
        }
    }

    public void setFeedPosition(int i3, int i16) {
        this.feedPosition = i3;
        this.mContainerIndex = i16;
        setTag(j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
    }

    @Override // com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void onContentDescriptionChanged(DittoArea dittoArea) {
        if (dittoArea == null || this.mAccessibilityChildren.contains(dittoArea)) {
            return;
        }
        this.mAccessibilityChildren.add(dittoArea);
    }

    public QzoneCanvasAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.selfExposureHadReported = false;
        this.mTrans = 255;
        this.mScrollState = 1;
        this.mAccessibilityChildren = new ArrayList();
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public void reset() {
    }
}
