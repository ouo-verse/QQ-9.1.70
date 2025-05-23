package com.tencent.mobileqq.webviewplugin;

import android.view.View;
import com.tencent.mobileqq.webview.swift.y;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface q extends y {
    void Ad(boolean z16);

    void Hf(int i3);

    void Kb(int i3, int i16);

    void Pg(boolean z16);

    void Sc(boolean z16, int i3, int i16);

    View a3();

    int getTitleBarHeight();

    View getTitleBarView();

    void jg(String str, String str2, String str3, boolean z16, int i3, int i16, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar);

    void sc(JSONObject jSONObject);

    void setRightButton(boolean z16);

    void u5(boolean z16);

    void u6(boolean z16);
}
