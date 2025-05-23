package com.qq.e.tg.nativ;

import android.view.View;
import com.qq.e.comm.pi.ProgressCallBack;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class NativeUnifiedCustomViewParams {
    public static final int CUSTOM_VIEW_TYPE_LOADING_BUTTON = 2;
    public static final int CUSTOM_VIEW_TYPE_PLAY_BUTTON = 1;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, View> f40590a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private ProgressCallBack f40591b;

    public ProgressCallBack getCustomLoadingCallBack() {
        return this.f40591b;
    }

    public View getCustomLoadingView() {
        Map<Integer, View> map = this.f40590a;
        if (map != null) {
            return map.get(2);
        }
        return null;
    }

    public View getCustomPlayView() {
        Map<Integer, View> map = this.f40590a;
        if (map != null) {
            return map.get(1);
        }
        return null;
    }

    public void setCustomLoadingView(View view, ProgressCallBack progressCallBack) {
        this.f40590a.put(2, view);
        this.f40591b = progressCallBack;
    }

    public void setCustomPlayView(View view) {
        this.f40590a.put(1, view);
    }
}
