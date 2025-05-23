package com.tencent.mobileqq.wink.editor.music;

import android.text.TextUtils;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ax {

    /* renamed from: e, reason: collision with root package name */
    public static ax f320778e = new ax("FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");

    /* renamed from: f, reason: collision with root package name */
    public static ax f320779f = new ax("FAKE_CATEGORY_COLLECTION_ID", "\u6536\u85cf");

    /* renamed from: g, reason: collision with root package name */
    public static ax f320780g = new ax("FAKE_CATEGORY_MOOD_ID", "\u5fc3\u60c5\u65e5\u8bb0");

    /* renamed from: h, reason: collision with root package name */
    public static ax f320781h = new ax("FAKE_CATEGORY_MAGIC_STUDIO_ID", "\u9b54\u6cd5\u753b\u5ba4");

    /* renamed from: i, reason: collision with root package name */
    public static ax f320782i = new ax("FAKE_CATEGORY_DAILY_SIGN_ID", "\u968f\u8bb0");

    /* renamed from: a, reason: collision with root package name */
    public String f320783a;

    /* renamed from: b, reason: collision with root package name */
    public String f320784b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f320785c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f320786d = false;

    public ax(String str, String str2) {
        this.f320783a = str;
        this.f320784b = str2;
    }

    public boolean a() {
        return this.f320786d;
    }

    public boolean b(WinkEditorMusicInfo winkEditorMusicInfo) {
        if (!TextUtils.isEmpty(this.f320783a) && this.f320783a.equals(winkEditorMusicInfo.D)) {
            return true;
        }
        return false;
    }

    public ax c() {
        this.f320786d = false;
        this.f320785c = false;
        return this;
    }

    public void d() {
        this.f320786d = false;
    }

    public void e() {
        this.f320786d = true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ax)) {
            return false;
        }
        ax axVar = (ax) obj;
        if (TextUtils.isEmpty(axVar.f320783a) || !this.f320783a.equals(axVar.f320783a)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "WinkMusicCategoryInfo{mCategoryId='" + this.f320783a + "', mCategoryName='" + this.f320784b + "', isSelected=" + this.f320785c + ", isLoaded=" + this.f320786d + '}';
    }
}
