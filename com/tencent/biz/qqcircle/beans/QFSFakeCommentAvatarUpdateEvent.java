package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFakeCommentAvatarUpdateEvent extends SimpleBaseEvent {
    private String mFakeId;
    private int[] mLocation;

    public QFSFakeCommentAvatarUpdateEvent(String str, int[] iArr) {
        this.mFakeId = str;
        this.mLocation = iArr;
    }

    public String getFakeId() {
        return this.mFakeId;
    }

    public int[] getLocation() {
        return this.mLocation;
    }

    public void setFakeId(String str) {
        this.mFakeId = str;
    }

    public void setLocation(int[] iArr) {
        this.mLocation = iArr;
    }

    public String toString() {
        return "QFSFakeCommentAvatarUpdateEvent{mFakeId='" + this.mFakeId + "', mLocation=" + Arrays.toString(this.mLocation) + '}';
    }
}
