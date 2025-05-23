package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.multishare.action.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSQQFriendsSelectChangedEvent extends SimpleBaseEvent {
    private int mFinalSelectedSize;
    private final List<c> mFinalSelectedUserList;

    public QFSQQFriendsSelectChangedEvent(ArrayList<c> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.mFinalSelectedUserList = arrayList2;
        this.mFinalSelectedSize = RFSafeListUtils.getSize(arrayList);
        arrayList2.clear();
        arrayList2.addAll(arrayList);
    }

    public int getFinalSelectedSize() {
        return this.mFinalSelectedSize;
    }

    public List<c> getFinalSelectedUserList() {
        return this.mFinalSelectedUserList;
    }
}
