package com.tencent.mobileqq.emoticonview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* loaded from: classes12.dex */
public class BaseEmotionPanelListView extends ListView implements AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseEmotionPanelListView";
    private DelegateOnScrollListener mDelegateOnScrollListener;
    private List<Integer> mHeaderViewIds;
    private AbsListView.OnScrollListener mOnScrollListener;
    private ArrayList<AbsListView.OnScrollListener> mOnScrollListenerList;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class DelegateOnScrollListener implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;
        WeakReference<BaseEmotionPanelListView> mListViewWeakReference;

        public DelegateOnScrollListener(BaseEmotionPanelListView baseEmotionPanelListView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseEmotionPanelListView);
            } else {
                this.mListViewWeakReference = new WeakReference<>(baseEmotionPanelListView);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            BaseEmotionPanelListView baseEmotionPanelListView = this.mListViewWeakReference.get();
            if (baseEmotionPanelListView != null) {
                baseEmotionPanelListView.onScroll(absListView, i3, i16, i17);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
                return;
            }
            BaseEmotionPanelListView baseEmotionPanelListView = this.mListViewWeakReference.get();
            if (baseEmotionPanelListView != null) {
                baseEmotionPanelListView.onScrollStateChanged(absListView, i3);
            }
        }
    }

    public BaseEmotionPanelListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Deprecated
    public void abortFling() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            smoothScrollBy(0, 0);
        }
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, obj, Boolean.valueOf(z16));
            return;
        }
        int id5 = view.getId();
        if (id5 == -1) {
            id5 = View.generateViewId();
            view.setId(id5);
        }
        this.mHeaderViewIds.add(Integer.valueOf(id5));
        super.addHeaderView(view, obj, z16);
    }

    @Deprecated
    public void addOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListenerList.add(onScrollListener);
        }
    }

    @Deprecated
    public int getListViewScrollY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return getScrollY();
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        int headerViewsCount = getHeaderViewsCount();
        if (firstVisiblePosition >= headerViewsCount) {
            Iterator<Integer> it = this.mHeaderViewIds.iterator();
            while (it.hasNext()) {
                View findViewById = findViewById(it.next().intValue());
                if (findViewById != null) {
                    i3 += findViewById.getHeight();
                }
            }
            return i3 + (-childAt.getTop()) + ((firstVisiblePosition - headerViewsCount) * childAt.getHeight());
        }
        int i16 = 0;
        for (int i17 = 0; i17 < firstVisiblePosition; i17++) {
            if (i17 < this.mHeaderViewIds.size()) {
                i16 += findViewById(this.mHeaderViewIds.get(i17).intValue()).getHeight();
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "[getListViewScrollY] error, i=", Integer.valueOf(i17), ", mHeaderViewIds.size=", Integer.valueOf(this.mHeaderViewIds.size()));
            }
        }
        return (-childAt.getTop()) + i16;
    }

    @Deprecated
    public AbsListView.OnScrollListener getOnScrollListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AbsListView.OnScrollListener) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mOnScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
        Iterator<AbsListView.OnScrollListener> it = this.mOnScrollListenerList.iterator();
        while (it.hasNext()) {
            it.next().onScroll(this, i3, i16, i17);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) absListView, i3);
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
        Iterator<AbsListView.OnScrollListener> it = this.mOnScrollListenerList.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChanged(absListView, i3);
        }
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) view)).booleanValue();
        }
        this.mHeaderViewIds.remove(Integer.valueOf(view.getId()));
        return super.removeHeaderView(view);
    }

    @Deprecated
    public void removeOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListenerList.remove(onScrollListener);
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onScrollListener);
            return;
        }
        this.mOnScrollListener = onScrollListener;
        if (onScrollListener == null && this.mOnScrollListenerList.isEmpty()) {
            this.mDelegateOnScrollListener = null;
        } else if (this.mDelegateOnScrollListener == null) {
            this.mDelegateOnScrollListener = new DelegateOnScrollListener(this);
        }
        super.setOnScrollListener(this.mDelegateOnScrollListener);
    }

    public BaseEmotionPanelListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public BaseEmotionPanelListView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public BaseEmotionPanelListView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mOnScrollListenerList = new ArrayList<>();
            this.mHeaderViewIds = new ArrayList();
        }
    }
}
