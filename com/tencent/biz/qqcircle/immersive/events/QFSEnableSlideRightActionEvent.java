package com.tencent.biz.qqcircle.immersive.events;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSEnableSlideRightActionEvent extends SimpleBaseEvent {
    int mContextHashCode;
    boolean mEnable;

    public QFSEnableSlideRightActionEvent(boolean z16, Context context) {
        this.mEnable = z16;
        if (context != null) {
            this.mContextHashCode = context.hashCode();
        }
        QLog.d("QFSEnableSlideRightActionEvent", 1, new Throwable("QFSEnableSlideRightActionEvent debug, enable=" + z16), new Object[0]);
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public boolean isEnable() {
        return this.mEnable;
    }
}
