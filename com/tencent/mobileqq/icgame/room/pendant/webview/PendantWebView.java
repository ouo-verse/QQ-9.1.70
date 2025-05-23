package com.tencent.mobileqq.icgame.room.pendant.webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes15.dex */
public class PendantWebView extends TouchWebView {
    private Map<String, String> C;
    private PendantLocation D;
    private final a E;

    /* loaded from: classes15.dex */
    enum PendantLocation {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public PendantWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = a.f237675a;
        q();
    }

    private void q() {
        this.E.a(true);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        if (motionEvent.getAction() == 2 || motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent, view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setCallback(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.C == null) {
                this.C = new HashMap();
            }
            this.C.put(str, str2);
        }
    }

    public void setPendantLocation(PendantLocation pendantLocation) {
        this.D = pendantLocation;
    }

    public PendantWebView(Context context) {
        this(context, null);
    }
}
