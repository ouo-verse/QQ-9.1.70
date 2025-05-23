package com.tencent.av.ui.chatroom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoChatRoomListView extends ListView {

    /* renamed from: d, reason: collision with root package name */
    private a f75479d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        boolean b(MotionEvent motionEvent, boolean z16);
    }

    public VideoChatRoomListView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        a aVar = this.f75479d;
        if (aVar != null) {
            aVar.b(motionEvent, dispatchTouchEvent);
        }
        return dispatchTouchEvent;
    }

    public void setOnDispatchTouchEventResponseListener(a aVar) {
        this.f75479d = aVar;
    }

    public VideoChatRoomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoChatRoomListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
