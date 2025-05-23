package com.tencent.timi.game.liveroom.impl.room.pendant.webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.ui.TouchWebView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class PendantWebView extends TouchWebView {
    private Map<String, String> C;
    private Map<String, Integer> D;
    private final b E;

    public PendantWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = b.f378224a;
        t();
    }

    private void t() {
        this.E.a(true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean q(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String r16 = r(str);
        if (!TextUtils.isEmpty(r16)) {
            loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + r16 + "('" + str + "'," + str2 + ")");
        }
        return false;
    }

    public String r(String str) {
        Map<String, String> map;
        if (!TextUtils.isEmpty(str) && (map = this.C) != null) {
            return map.get(str);
        }
        return "";
    }

    public int s(String str, int i3) {
        Map<String, Integer> map;
        if (!TextUtils.isEmpty(str) && (map = this.D) != null && map.containsKey(str)) {
            return this.D.get(str).intValue();
        }
        return i3;
    }

    public void setCallback(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.C == null) {
                this.C = new HashMap();
            }
            this.C.put(str, str2);
        }
    }

    public void setParams(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.D == null) {
            this.D = new HashMap();
        }
        this.D.put(str, Integer.valueOf(i3));
    }

    public PendantWebView(Context context) {
        this(context, null);
    }
}
