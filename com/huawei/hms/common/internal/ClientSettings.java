package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ClientSettings {

    /* renamed from: a, reason: collision with root package name */
    private String f36854a;

    /* renamed from: b, reason: collision with root package name */
    private String f36855b;

    /* renamed from: c, reason: collision with root package name */
    private List<Scope> f36856c;

    /* renamed from: d, reason: collision with root package name */
    private String f36857d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f36858e;

    /* renamed from: f, reason: collision with root package name */
    private String f36859f;

    /* renamed from: g, reason: collision with root package name */
    private SubAppInfo f36860g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f36861h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36862i;

    /* renamed from: j, reason: collision with root package name */
    private String f36863j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36864k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f36854a = str;
        this.f36855b = str2;
        this.f36856c = list;
        this.f36857d = str3;
        this.f36858e = list2;
    }

    public List<String> getApiName() {
        return this.f36858e;
    }

    public String getAppID() {
        return this.f36857d;
    }

    public String getClientClassName() {
        return this.f36855b;
    }

    public String getClientPackageName() {
        return this.f36854a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f36861h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f36859f;
    }

    public String getInnerHmsPkg() {
        return this.f36863j;
    }

    public List<Scope> getScopes() {
        return this.f36856c;
    }

    public SubAppInfo getSubAppID() {
        return this.f36860g;
    }

    public boolean isHasActivity() {
        return this.f36862i;
    }

    public boolean isUseInnerHms() {
        return this.f36864k;
    }

    public void setApiName(List<String> list) {
        this.f36858e = list;
    }

    public void setAppID(String str) {
        this.f36857d = str;
    }

    public void setClientClassName(String str) {
        this.f36855b = str;
    }

    public void setClientPackageName(String str) {
        this.f36854a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f36861h = new WeakReference<>(activity);
        this.f36862i = true;
    }

    public void setCpID(String str) {
        this.f36859f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f36863j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f36856c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f36860g = subAppInfo;
    }

    public void setUseInnerHms(boolean z16) {
        this.f36864k = z16;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f36860g = subAppInfo;
    }
}
