package com.tencent.qqlive.module.videoreport.visual.debug.util;

import android.app.Activity;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.qqlive.module.videoreport.visual.debug.data.DataProvider;
import com.tencent.qqlive.module.videoreport.visual.debug.data.PageData;
import com.tencent.qqlive.module.videoreport.visual.debug.data.ViewData;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewTreeScanner {
    private static final String TAG = "Visual.ViewTreeScanner";
    private static final long THROTTLE_DELAY_TIME = 300;
    private static volatile ViewTreeScanner sInstance;
    private ScanViewDetectCallback mScanViewDetectCallback;
    private Handler mScanViewHandler;
    private ScanViewRunnable mScanViewRunnable;
    private Throttle mThrottle;
    private ViewScanCallback mViewScanCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ScanViewDetectCallback implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
        ScanViewDetectCallback() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeScanner.this.performScanViews();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ViewTreeScanner.this.performScanViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ScanViewRunnable implements Runnable {
        private PageData mPageData;
        private List<ViewData> mScanViewList;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public class LayeredView {
            public int layer;
            public View view;

            LayeredView(View view, int i3) {
                this.view = view;
                this.layer = i3;
            }
        }

        ScanViewRunnable() {
        }

        private void traverseViews(List<ViewData> list, View view) {
            if (view == null) {
                return;
            }
            Stack stack = new Stack();
            SparseArray sparseArray = new SparseArray();
            stack.push(new LayeredView(view, 0));
            while (!stack.isEmpty()) {
                LayeredView layeredView = (LayeredView) stack.pop();
                View view2 = layeredView.view;
                int i3 = layeredView.layer;
                ViewData viewInfo = DataProvider.getViewInfo(view2);
                if (viewInfo != null) {
                    int i16 = i3 - 1;
                    while (true) {
                        if (i16 < 0) {
                            break;
                        }
                        ViewData viewData = (ViewData) sparseArray.get(i16);
                        if (viewData != null) {
                            viewInfo.parent = viewData;
                            break;
                        }
                        i16--;
                    }
                    viewInfo.layer = i3;
                    list.add(viewInfo);
                }
                sparseArray.put(i3, viewInfo);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View childAt = viewGroup.getChildAt(childCount);
                        if (childAt != null && childAt.getVisibility() == 0) {
                            stack.push(new LayeredView(childAt, i3 + 1));
                        }
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity topActivity = ActivityUtil.getTopActivity();
            if (topActivity != null && !topActivity.isFinishing()) {
                View decorView = topActivity.getWindow().getDecorView();
                List<PageData> pageInfo = DataProvider.getPageInfo(decorView);
                if (pageInfo != null && !pageInfo.isEmpty()) {
                    this.mPageData = pageInfo.get(0);
                }
                ArrayList arrayList = new ArrayList(20);
                traverseViews(arrayList, decorView);
                this.mScanViewList = arrayList;
                ViewTreeScanner.this.onViewScanned(this.mPageData, arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ViewScanCallback {
        void onViewScanned(PageData pageData, List<ViewData> list);
    }

    ViewTreeScanner() {
        this.mScanViewRunnable = new ScanViewRunnable();
        this.mScanViewDetectCallback = new ScanViewDetectCallback();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ViewScanThread");
        baseHandlerThread.start();
        this.mScanViewHandler = new Handler(baseHandlerThread.getLooper());
    }

    private void addDecorViewTreeListener() {
        Activity topActivity = ActivityUtil.getTopActivity();
        if (topActivity != null && topActivity.getWindow() != null) {
            ViewTreeObserver viewTreeObserver = topActivity.getWindow().getDecorView().getViewTreeObserver();
            removeListenersFormViewTreeObserver(viewTreeObserver);
            viewTreeObserver.addOnGlobalLayoutListener(this.mScanViewDetectCallback);
            viewTreeObserver.addOnScrollChangedListener(this.mScanViewDetectCallback);
        }
    }

    public static ViewTreeScanner getInstance() {
        if (sInstance == null) {
            synchronized (ViewTreeScanner.class) {
                if (sInstance == null) {
                    sInstance = new ViewTreeScanner();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onViewScanned(PageData pageData, List<ViewData> list) {
        ViewScanCallback viewScanCallback = this.mViewScanCallback;
        if (viewScanCallback != null) {
            viewScanCallback.onViewScanned(pageData, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performScanViews() {
        if (this.mThrottle == null) {
            this.mThrottle = Throttle.build(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.visual.debug.util.ViewTreeScanner.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewTreeScanner.this.mScanViewHandler.post(ViewTreeScanner.this.mScanViewRunnable);
                }
            }, 300L);
        }
        this.mThrottle.execute();
    }

    private void removeDecorViewTreeListener() {
        ViewTreeObserver viewTreeObserver;
        Activity lastTopActivity = ActivityUtil.getLastTopActivity();
        if (lastTopActivity != null && lastTopActivity.getWindow() != null && (viewTreeObserver = lastTopActivity.getWindow().getDecorView().getViewTreeObserver()) != null && this.mScanViewDetectCallback != null) {
            removeListenersFormViewTreeObserver(viewTreeObserver);
        }
    }

    private void removeListenersFormViewTreeObserver(ViewTreeObserver viewTreeObserver) {
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.mScanViewDetectCallback);
            viewTreeObserver.removeOnScrollChangedListener(this.mScanViewDetectCallback);
        }
    }

    public void start(ViewScanCallback viewScanCallback) {
        this.mViewScanCallback = viewScanCallback;
        addDecorViewTreeListener();
    }

    public void stop() {
        this.mViewScanCallback = null;
        removeDecorViewTreeListener();
    }
}
