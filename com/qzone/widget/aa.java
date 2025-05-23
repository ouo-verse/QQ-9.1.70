package com.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa {
    private b listener;
    protected final View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(View view) {
        this.rootView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends View> T findViewById(int i3) {
        return (T) this.rootView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.rootView.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Resources getResources() {
        return this.rootView.getResources();
    }

    public int getVisibility() {
        return this.rootView.getVisibility();
    }

    public boolean isThisRootView(View view) {
        return this.rootView == view;
    }

    public void setAlpha(float f16) {
        this.rootView.setAlpha(f16);
    }

    public void setFinishListener(b bVar) {
        this.listener = bVar;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.rootView.setOnClickListener(onClickListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.rootView.setOnLongClickListener(onLongClickListener);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.rootView.setOnTouchListener(onTouchListener);
    }

    public void setVisibility(int i3) {
        this.rootView.setVisibility(i3);
    }
}
