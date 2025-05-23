package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class KeyBoardEditorActionNotifier implements IEventNotifier {
    private int mActionId;
    private int mFrom;
    private KeyEvent mKeyEvent;
    private TextView mView;

    public void init(TextView textView, int i3, KeyEvent keyEvent, int i16) {
        this.mView = textView;
        this.mActionId = i3;
        this.mKeyEvent = keyEvent;
        this.mFrom = i16;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onEditorAction(this.mView, this.mActionId, this.mKeyEvent, this.mFrom);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mView = null;
        this.mActionId = -1;
        this.mKeyEvent = null;
        this.mFrom = -1;
    }
}
