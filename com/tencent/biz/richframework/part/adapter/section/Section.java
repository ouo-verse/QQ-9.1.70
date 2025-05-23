package com.tencent.biz.richframework.part.adapter.section;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.VisibleAware;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class Section<T> implements VisibleAware {
    protected T mData;
    protected int mPosition;
    protected View mRootView;
    protected ISectionHost mSectionHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLogTag() {
        return getClass().getName();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View getStubView(int i3) {
        return this.mSectionHost.getStubView(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int[] getViewStubLayoutId();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSectionEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onBindData(T t16, int i3, List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onInitView(View view);

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
    }

    public void onViewRecycled() {
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean z16) {
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean z16) {
    }
}
