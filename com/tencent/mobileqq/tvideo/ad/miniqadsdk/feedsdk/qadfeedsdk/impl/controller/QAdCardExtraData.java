package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdCardExtraData {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f304141a = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface AdExtraInnerKey {
        public static final String AD_EXTRA_KEY_IS_VR_REPORT_PARAM = "vrReportParam";
        public static final String AD_EXTRA_KEY_OBJECT_EXPOSURE_ALIAS = "ExposureAlias";
        public static final String AD_EXTRA_KEY_PAGE_PARAMS = "pageParams";
        public static final String AD_EXTRA_KEY_THEME = "theme";
        public static final String AD_EXTRA_KEY_UI_SIZE_TYPE = "UiSizeType";
        public static final String AD_RETURN_BTN_VISIBLE = "adReturnBtnVisible";
        public static final String AD_TITLE_LAYOUT_MARGIN_LEFT = "adTitle_layout_margin_left";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public <T> T a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return obj;
        }
        if (this.f304141a.containsKey(str)) {
            return (T) this.f304141a.get(str);
        }
        return obj;
    }

    public void b(String str, @NonNull Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f304141a.put(str, obj);
        }
    }

    public void c(QAdCardExtraData qAdCardExtraData) {
        if (qAdCardExtraData == null) {
            return;
        }
        d(qAdCardExtraData.f304141a);
    }

    public void d(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }
}
