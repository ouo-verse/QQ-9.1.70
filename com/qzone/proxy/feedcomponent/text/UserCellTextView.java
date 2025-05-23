package com.qzone.proxy.feedcomponent.text;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserCellTextView extends CellTextView {

    /* renamed from: d, reason: collision with root package name */
    private int f50689d;

    public UserCellTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50689d = 0;
        init(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.proxy.feedcomponent.text.CellTextView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.textLayout.setMeasuredLineLinkColor(this.textColorLink, this.f50689d);
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView
    public void setTextColorLink(int i3) {
        initTextCellLayout();
        this.textColorLink = i3;
        this.textLayout.setMeasuredLineLinkColor(i3);
        invalidate();
    }

    public UserCellTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50689d = 0;
        init(context, attributeSet, 0);
    }

    public UserCellTextView(Context context) {
        super(context);
        this.f50689d = 0;
        init(context, null, 0);
    }
}
