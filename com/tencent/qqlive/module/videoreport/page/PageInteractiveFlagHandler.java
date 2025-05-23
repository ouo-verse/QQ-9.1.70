package com.tencent.qqlive.module.videoreport.page;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReflectUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class PageInteractiveFlagHandler extends DefaultEventListener {
    private final PageManager mPageManager;
    private final Rect mRect = new Rect();
    private final Map<View, Set<View>> mPagePathViewsMap = new WeakHashMap();
    private final Set<Long> interactedSets = new HashSet();
    private boolean mIsBeforeNeedMark = false;

    PageInteractiveFlagHandler(PageManager pageManager) {
        this.mPageManager = pageManager;
    }

    @NonNull
    private Set<View> buildPagePathViews(@NonNull View view) {
        Set<View> newWeakHashSet = BaseUtils.newWeakHashSet();
        Object obj = view;
        while (obj instanceof View) {
            View view2 = (View) obj;
            newWeakHashSet.add(view2);
            obj = view2.getParent();
        }
        return newWeakHashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PageInteractiveFlagHandler create(PageManager pageManager) {
        PageInteractiveFlagHandler pageInteractiveFlagHandler = new PageInteractiveFlagHandler(pageManager);
        EventCollector.getInstance().registerEventListener(pageInteractiveFlagHandler);
        return pageInteractiveFlagHandler;
    }

    @NonNull
    private Set<View> getPagePathViews(@NonNull View view) {
        Set<View> set = this.mPagePathViewsMap.get(view);
        if (set == null) {
            Set<View> buildPagePathViews = buildPagePathViews(view);
            this.mPagePathViewsMap.put(view, buildPagePathViews);
            return buildPagePathViews;
        }
        return set;
    }

    private Object getTouchTarget(View view) {
        if (!(view instanceof ViewGroup)) {
            return Boolean.FALSE;
        }
        return ReflectUtils.getField(ViewGroup.class, "mFirstTouchTarget", view);
    }

    private boolean isTouchedInCurPage(Window window, View view, MotionEvent motionEvent) {
        View decorView = window == null ? null : window.getDecorView();
        View rootView = view.getRootView();
        if (decorView == null || decorView != rootView) {
            return false;
        }
        return isTouchedInCurPage(motionEvent, decorView, view);
    }

    private void markInteractiveFlagToPage(PageInfo pageInfo) {
        DataRWProxy.setInnerParam(pageInfo.getPage(), InnerKey.PAGE_INTERACTIVE_FLAG, Boolean.TRUE);
    }

    private boolean needMarkInteractiveFlag(Window window, MotionEvent motionEvent, boolean z16, PageInfo pageInfo) {
        if (motionEvent.getAction() != 0 && !z16 && pageInfo != null) {
            Object page = pageInfo.getPage();
            View pageView = pageInfo.getPageView();
            if (page != null && pageView != null) {
                Object innerParam = DataRWProxy.getInnerParam(page, InnerKey.PAGE_INTERACTIVE_FLAG);
                if ((innerParam instanceof Boolean) && ((Boolean) innerParam).booleanValue()) {
                    return false;
                }
                return isTouchedInCurPage(window, pageView, motionEvent);
            }
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDispatchTouchEvent(Object obj, Window window, MotionEvent motionEvent, boolean z16, boolean z17) {
        PageInfo currentPageInfo;
        if (obj != null && window != null && motionEvent != null) {
            if (this.interactedSets.contains(Long.valueOf(obj.hashCode() + window.hashCode())) && (currentPageInfo = this.mPageManager.getCurrentPageInfo()) != null) {
                Object innerParam = DataRWProxy.getInnerParam(currentPageInfo.getPage(), InnerKey.PAGE_INTERACTIVE_FLAG);
                if ((innerParam instanceof Boolean) && ((Boolean) innerParam).booleanValue()) {
                    return;
                }
            }
            this.interactedSets.clear();
            if (z17) {
                this.mIsBeforeNeedMark = needMarkInteractiveFlag(window, motionEvent, this.mPageManager.isLastPageIsDisappear(), this.mPageManager.getCurrentPageInfo());
                return;
            }
            if (z16 && this.mIsBeforeNeedMark) {
                this.interactedSets.add(Long.valueOf(obj.hashCode() + window.hashCode()));
                PageInfo currentPageInfo2 = this.mPageManager.getCurrentPageInfo();
                if (currentPageInfo2 != null) {
                    markInteractiveFlagToPage(currentPageInfo2);
                }
            }
        }
    }

    private boolean isTouchedInCurPage(MotionEvent motionEvent, View view, View view2) {
        if (!view2.getGlobalVisibleRect(this.mRect) || !this.mRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        Set<View> pagePathViews = getPagePathViews(view2);
        if (pagePathViews.isEmpty()) {
            return false;
        }
        return isTouchedInCurPage(view, view2, pagePathViews);
    }

    private boolean isTouchedInCurPage(View view, View view2, Set<View> set) {
        Object touchTarget;
        if (view == view2) {
            return true;
        }
        if (!set.contains(view) || (touchTarget = getTouchTarget(view)) == null) {
            return false;
        }
        for (touchTarget = getTouchTarget(view); touchTarget != null; touchTarget = ReflectUtils.getField("next", touchTarget)) {
            Object field = ReflectUtils.getField("child", touchTarget);
            if ((field instanceof View) && isTouchedInCurPage((View) field, view2, set)) {
                return true;
            }
        }
        return false;
    }
}
