package com.tencent.biz.richframework.part.adapter.section;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.VisibleAware;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SectionManager<T> implements VisibleAware, ISectionHost {
    private final ArrayList<Section<T>> mSectionList = new ArrayList<>();
    private final HashMap<Integer, View> mSectionViewStubMap = new HashMap<>();

    private void initSectionStub(View view, Section section) {
        ViewStub viewStub;
        if (section.getViewStubLayoutId() != null && section.getViewStubLayoutId().length != 0) {
            for (int i3 : section.getViewStubLayoutId()) {
                View view2 = this.mSectionViewStubMap.get(Integer.valueOf(i3));
                if (view2 == null && (viewStub = (ViewStub) view.findViewById(i3)) != null) {
                    view2 = viewStub.inflate();
                }
                if (view2 == null) {
                    RFWLog.fatal(section.getLogTag(), RFWLog.USR, new RuntimeException("can't find find stub view with layoutId:" + i3));
                    return;
                }
                this.mSectionViewStubMap.put(Integer.valueOf(i3), view2);
            }
        }
    }

    public void bindData(T t16, int i3, List<Object> list) {
        Iterator<Section<T>> it = this.mSectionList.iterator();
        while (it.hasNext()) {
            Section<T> next = it.next();
            next.mData = t16;
            next.mPosition = i3;
            next.onBindData(t16, i3, list);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.ISectionHost
    public View getStubView(int i3) {
        return this.mSectionViewStubMap.get(Integer.valueOf(i3));
    }

    public void initView(@NonNull View view) {
        Iterator<Section<T>> it = this.mSectionList.iterator();
        while (it.hasNext()) {
            Section<T> next = it.next();
            next.mRootView = view;
            initSectionStub(view, next);
            next.onInitView(view);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean z16) {
        Iterator<Section<T>> it = this.mSectionList.iterator();
        while (it.hasNext()) {
            it.next().onAttachedChanged(z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        Iterator<Section<T>> it = this.mSectionList.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void onViewRecycled() {
        Iterator<Section<T>> it = this.mSectionList.iterator();
        while (it.hasNext()) {
            it.next().onViewRecycled();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean z16) {
        Iterator<Section<T>> it = this.mSectionList.iterator();
        while (it.hasNext()) {
            it.next().onVisibleChanged(z16);
        }
    }

    public void registerSections(List<Class<? extends Section<T>>> list) {
        if (list == null) {
            RFWLog.e("SectionManager", RFWLog.USR, "registerSections  sectionClasses == null");
            return;
        }
        Iterator<Class<? extends Section<T>>> it = list.iterator();
        while (it.hasNext()) {
            try {
                Section<T> newInstance = it.next().newInstance();
                if (newInstance.isSectionEnabled()) {
                    newInstance.mSectionHost = this;
                    this.mSectionList.add(newInstance);
                }
            } catch (IllegalAccessException | InstantiationException e16) {
                RFWLog.fatal("SectionManager", RFWLog.USR, e16);
            }
        }
    }
}
