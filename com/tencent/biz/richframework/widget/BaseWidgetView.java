package com.tencent.biz.richframework.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.operate.api.IParentViewAttacher;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public abstract class BaseWidgetView<T> extends FrameLayout implements IParentViewAttacher {
    private static final int CLICK_INTERVAL = 800;
    protected static final String TAG = "BaseWidgetView";
    private T data;
    protected int dataPosInList;
    private final SparseArray<Long> lastClickViewArray;
    private Serializable mExtraTypeInfo;
    private WeakReference<Activity> mHostActivity;
    private IInteractor mInteractor;
    private Handler mMainHandler;
    protected ViewGroup mParentView;
    private final HashMap<Integer, ItemPreClickListener> mPreClickCollections;
    protected int mViewType;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes5.dex */
    public interface IInteractor {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ItemPreClickListener {
        void beforeClick();
    }

    public BaseWidgetView(@NonNull Context context) {
        this(context, (Integer) 0);
    }

    private void registerPreClickListener(View view, ItemPreClickListener itemPreClickListener) {
        if (view != null) {
            this.mPreClickCollections.put(Integer.valueOf(view.getId()), itemPreClickListener);
        }
    }

    protected abstract void bindData(T t16, int i3);

    protected boolean doubleClickCheck(View view) {
        if (view == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickViewArray.get(view.getId(), -1L).longValue() > 800) {
            this.lastClickViewArray.put(view.getId(), Long.valueOf(currentTimeMillis));
            return false;
        }
        return true;
    }

    public T getData() {
        return this.data;
    }

    public int getDataPosInList() {
        return this.dataPosInList;
    }

    public Serializable getExtraTypeInfo() {
        return this.mExtraTypeInfo;
    }

    public Activity getHostActivity() {
        WeakReference<Activity> weakReference = this.mHostActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Deprecated
    public IInteractor getInteractor() {
        return this.mInteractor;
    }

    public abstract int getLayoutId();

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return null;
    }

    public Handler getMainHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }

    protected View.OnClickListener getOnClickLister() {
        return null;
    }

    @Override // com.tencent.biz.richframework.ioc.operate.api.IParentViewAttacher
    public ViewGroup getParentView() {
        return this.mParentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public Object getViewTagData() {
        return RFWViewUtils.getClosestViewTagData(TagData.TAG_DATA_ID, this);
    }

    public int getViewType() {
        return this.mViewType;
    }

    protected void hookPreClick(View view) {
        if (view != null && this.mPreClickCollections.get(Integer.valueOf(view.getId())) != null) {
            this.mPreClickCollections.get(Integer.valueOf(view.getId())).beforeClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initLayout(Context context) {
        View view;
        if (getLayoutPreLoader() != null) {
            view = getLayoutPreLoader().getPreloadView(context, getLayoutId(), false);
        } else {
            view = null;
        }
        if (view != null) {
            RFWLog.d("LayoutPreLoader", RFWLog.USR, "get preInflate view success layoutId:" + getClass().getSimpleName() + " hashCode:" + hashCode());
            addView(view, getPreLoadLayoutParams());
            return;
        }
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView(Context context, int i3) {
        this.mViewType = i3;
        if (getLayoutId() != 0) {
            initLayout(context);
        }
        if (targetClickView() != null) {
            targetClickView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.richframework.widget.BaseWidgetView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (BaseWidgetView.this.getOnClickLister() != null && !BaseWidgetView.this.doubleClickCheck(view)) {
                        BaseWidgetView baseWidgetView = BaseWidgetView.this;
                        baseWidgetView.hookPreClick(baseWidgetView.targetClickView());
                        BaseWidgetView.this.getOnClickLister().onClick(view);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMainHandler().removeCallbacksAndMessages(null);
    }

    public void setData(T t16) {
        setData(t16, getDataPosInList());
    }

    public void setDataPosInList(int i3) {
        this.dataPosInList = i3;
    }

    public void setExtraTypeInfo(Serializable serializable) {
        this.mExtraTypeInfo = serializable;
    }

    public void setHostActivity(Activity activity) {
        this.mHostActivity = new WeakReference<>(activity);
    }

    @Deprecated
    public void setInteractor(IInteractor iInteractor) {
        this.mInteractor = iInteractor;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    public void setPreClickListener(ItemPreClickListener itemPreClickListener) {
        registerPreClickListener(targetClickView(), itemPreClickListener);
    }

    public void setViewType(int i3) {
        this.mViewType = i3;
    }

    protected View targetClickView() {
        return null;
    }

    public BaseWidgetView(@NonNull Context context, Integer num) {
        this(context, null, 0, num.intValue());
    }

    public void setData(T t16, int i3) {
        this.data = t16;
        setDataPosInList(i3);
        bindData(t16, i3);
    }

    public void setPreClickListener(View view, ItemPreClickListener itemPreClickListener) {
        registerPreClickListener(view, itemPreClickListener);
    }

    public BaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public BaseWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3);
        this.lastClickViewArray = new SparseArray<>();
        this.mPreClickCollections = new HashMap<>();
        this.dataPosInList = -1;
        handleAttr(context, attributeSet);
        initView(context, i16);
    }

    public BaseWidgetView(@NonNull Context context, boolean z16) {
        super(context);
        this.lastClickViewArray = new SparseArray<>();
        this.mPreClickCollections = new HashMap<>();
        this.dataPosInList = -1;
    }

    public void release() {
    }

    protected void handleAttr(Context context, AttributeSet attributeSet) {
    }
}
