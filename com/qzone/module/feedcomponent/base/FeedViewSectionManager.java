package com.qzone.module.feedcomponent.base;

import com.qzone.module.feedcomponent.ui.FeedCommonSection;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.IFeedViewElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public enum FeedViewSectionManager {
    INSTANCE;

    protected final HashMap<Integer, Class<? extends IFeedViewElement>> mViewSectionMap = new HashMap<>();
    protected final HashMap<Integer, ArrayList<Integer>> mOrderHashMap = new HashMap<>();

    FeedViewSectionManager() {
    }

    private FeedViewSection createElementSections(FeedView feedView, Class<? extends IFeedViewElement> cls) {
        FeedCommonSection feedCommonSection = new FeedCommonSection(cls, feedView);
        feedCommonSection.setFeedPosition(feedView.getMFeedPosition());
        feedCommonSection.setOnFeedElementClickListener(feedView.getOnFeedElementClickListener());
        return feedCommonSection;
    }

    public void addCombineSection(FeedView feedView, int i3) {
        ArrayList<Integer> arrayList = this.mOrderHashMap.get(Integer.valueOf(i3));
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            feedView.addSection(next.intValue(), createElementSections(feedView, this.mViewSectionMap.get(next)));
        }
    }

    public void registerViewSectionMap(int i3, Class<? extends IFeedViewElement> cls, int i16) {
        ArrayList<Integer> arrayList;
        if (cls == null) {
            return;
        }
        this.mViewSectionMap.put(Integer.valueOf(i3), cls);
        if (!this.mOrderHashMap.containsKey(Integer.valueOf(i16))) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = this.mOrderHashMap.get(Integer.valueOf(i16));
        }
        if (arrayList != null) {
            arrayList.add(Integer.valueOf(i3));
        }
        this.mOrderHashMap.put(Integer.valueOf(i16), arrayList);
    }
}
