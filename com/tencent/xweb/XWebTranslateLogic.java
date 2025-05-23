package com.tencent.xweb;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.luggage.wxa.ar.x0;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebTranslateLogic {

    /* renamed from: a, reason: collision with root package name */
    public boolean f385094a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f385095b = false;

    /* renamed from: c, reason: collision with root package name */
    public final WebView f385096c;

    /* renamed from: d, reason: collision with root package name */
    public final TranslateLogicCallback f385097d;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface TranslateLogicCallback {
        void onTranslateFinish();

        void onTranslateMiscCallBack(String str, Bundle bundle);

        void onTranslateStart();

        void replaceTranslatedString(Map<String, String> map);
    }

    public XWebTranslateLogic(WebView webView, TranslateLogicCallback translateLogicCallback) {
        this.f385096c = webView;
        this.f385097d = translateLogicCallback;
    }

    public final void a(boolean z16, String str) {
        if (!this.f385094a || this.f385095b) {
            return;
        }
        this.f385095b = true;
        x0.d("XWebTranslateLogic", "getTranslateTipsView");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 144);
        layoutParams.gravity = 51;
        TextView textView = new TextView(this.f385096c.getContext());
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.argb(127, 0, 0, 0));
        textView.setTextSize(0, 42.0f);
        if (z16) {
            textView.setBackgroundColor(-328966);
        } else {
            textView.setBackgroundColor(DownloadCardView.COLOR_APP_NAME_DARK);
        }
        ((ViewGroup) this.f385096c.getParent()).addView(textView, layoutParams);
        ((FrameLayout.LayoutParams) this.f385096c.getLayoutParams()).topMargin = 144;
        this.f385096c.requestLayout();
    }

    public void onGetSampleString(Map<String, String> map) {
        Bundle bundle = new Bundle();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        x0.b("XWebTranslateLogic", "translate: OnGetSampleString orgHashMap size = " + map.size() + " resultHashMap size = " + hashMap.size());
        bundle.putSerializable("sample_hashmap", hashMap);
        this.f385097d.onTranslateMiscCallBack("onGetSampleString", bundle);
    }

    public void onGetTranslateString(Map<String, String> map) {
        Bundle bundle = new Bundle();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        x0.b("XWebTranslateLogic", "translate: onGetTranslateString orgHashMap size = " + map.size() + " resultHashMap size = " + hashMap.size());
        if (hashMap.size() == 0 && this.f385094a) {
            x0.b("XWebTranslateLogic", "translate: onTranslateFinish");
            this.f385097d.onTranslateFinish();
        }
        bundle.putSerializable("translate_hashmap", hashMap);
        this.f385097d.onTranslateMiscCallBack("onGetTranslateString", bundle);
    }

    public void onPageLoadStarted() {
        if (this.f385094a) {
            x0.b("XWebTranslateLogic", "onTranslateStart setTranslateMode true ");
            this.f385097d.onTranslateStart();
        }
    }

    public void replaceTranslatedString(Bundle bundle) {
        x0.d("XWebTranslateLogic", "translate: replaceTranslatedString mIsTranslateMode =" + this.f385094a);
        if (!this.f385094a) {
            return;
        }
        HashMap hashMap = (HashMap) bundle.getSerializable("translate_hashmap");
        Boolean valueOf = Boolean.valueOf(bundle.getBoolean("is_mp_url"));
        String string = bundle.getString("translate_tips");
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
                if (str2.trim().length() != 0 && !str2.trim().equals("\n") && !str2.trim().equals("\r")) {
                    hashMap2.put(str, str2);
                } else {
                    x0.b("XWebTranslateLogic", "translate: string is space  or change line  value = " + str2);
                }
            } else {
                x0.b("XWebTranslateLogic", "translate: string is err !!!  key = " + str + " value = " + str2);
            }
        }
        x0.b("XWebTranslateLogic", "translate: replaceTranslatedString orgHashMap size = " + hashMap.size() + " resultHashMap size = " + hashMap2.size());
        this.f385097d.replaceTranslatedString(hashMap2);
        a(valueOf.booleanValue(), string);
        x0.b("XWebTranslateLogic", "translate: onTranslateFinish");
        this.f385097d.onTranslateFinish();
    }

    public void setIsInTranslateMode(boolean z16) {
        this.f385094a = z16;
    }
}
