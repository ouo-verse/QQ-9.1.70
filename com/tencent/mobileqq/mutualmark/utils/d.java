package com.tencent.mobileqq.mutualmark.utils;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private View f252294b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, Object> f252295c = null;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Object> f252296d = null;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f252297e = null;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Object> f252298f = null;

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f252293a = new LinearLayout(BaseApplication.getContext());

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f252299a = new d();
    }

    d() {
        View view = new View(BaseApplication.getContext());
        this.f252294b = view;
        this.f252293a.addView(view);
    }

    public static d a() {
        return a.f252299a;
    }

    public HashMap<String, Object> b() {
        HashMap<String, Object> hashMap = this.f252296d;
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("lighten_tag_acount", 0);
        hashMap2.put("interact_tag_pagecount", 0);
        return hashMap2;
    }

    public HashMap<String, Object> c() {
        HashMap<String, Object> hashMap = this.f252295c;
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("is_close_relation", "0");
        hashMap2.put("aio_swipleft_version", "2");
        hashMap2.put("interaction_lab_id", "3");
        return hashMap2;
    }

    public HashMap<String, Object> d() {
        HashMap<String, Object> hashMap = this.f252297e;
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("interact_tag_open_source", "0");
        return hashMap2;
    }

    public HashMap<String, Object> e() {
        HashMap<String, Object> hashMap = this.f252298f;
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("interact_tag_id", 0);
        hashMap2.put("interact_tag_status", "0");
        hashMap2.put("interact_tag_is_new_effect", "0");
        hashMap2.put("is_auto_trigger", "0");
        return hashMap2;
    }

    public void f(String str, String str2, String str3, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        VideoReport.setPageId(this.f252293a, str2);
        VideoReport.setPageParams(this.f252293a, PageParams.builder().setBasicParams(hashMap).build());
        VideoReport.setElementId(this.f252294b, str3);
        VideoReport.reportEvent(str, this.f252294b, hashMap2);
    }

    public void g(String str, String str2, HashMap<String, Object> hashMap) {
        VideoReport.setPageId(this.f252293a, str2);
        VideoReport.setPageParams(this.f252293a, PageParams.builder().setBasicParams(hashMap).build());
        VideoReport.reportEvent(str, this.f252293a, hashMap);
    }

    public void h(HashMap<String, Object> hashMap) {
        this.f252296d = hashMap;
    }

    public void i(HashMap<String, Object> hashMap) {
        this.f252295c = hashMap;
    }

    public void j(HashMap<String, Object> hashMap) {
        this.f252297e = hashMap;
    }

    public void k(HashMap<String, Object> hashMap) {
        this.f252298f = hashMap;
    }
}
