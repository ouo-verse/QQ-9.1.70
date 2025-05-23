package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class BaseDoodleMsgLayout extends RelativeLayout implements fb1.a {
    public BaseDoodleMsgLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public abstract /* synthetic */ void setOperateListener(View.OnClickListener onClickListener, View.OnTouchListener onTouchListener, View.OnLongClickListener onLongClickListener, c cVar);

    public abstract /* synthetic */ void setTalkBack(String str);
}
