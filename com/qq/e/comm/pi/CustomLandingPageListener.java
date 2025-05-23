package com.qq.e.comm.pi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public interface CustomLandingPageListener {

    /* loaded from: classes3.dex */
    public static class Params {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Context> f38319a;

        /* renamed from: b, reason: collision with root package name */
        private String f38320b;

        /* renamed from: c, reason: collision with root package name */
        private String f38321c;

        /* renamed from: d, reason: collision with root package name */
        private Bundle f38322d;

        /* renamed from: e, reason: collision with root package name */
        private int f38323e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f38324f;

        public int getActCode() {
            return this.f38323e;
        }

        public String getAdData() {
            return this.f38321c;
        }

        public Bundle getBundle() {
            return this.f38322d;
        }

        public String getLandingPageUrl() {
            return this.f38320b;
        }

        public WeakReference<Context> getWeakContext() {
            return this.f38319a;
        }

        public boolean isValid() {
            WeakReference<Context> weakReference;
            if (!TextUtils.isEmpty(this.f38321c) && !TextUtils.isEmpty(this.f38320b) && (weakReference = this.f38319a) != null && weakReference.get() != null) {
                return true;
            }
            return false;
        }

        public boolean needNewTask() {
            return this.f38324f;
        }

        public void setActCode(int i3) {
            this.f38323e = i3;
        }

        public void setAdData(String str) {
            this.f38321c = str;
        }

        public void setBundle(Bundle bundle) {
            this.f38322d = bundle;
        }

        public void setLandingPageUrl(String str) {
            this.f38320b = str;
        }

        public void setNeedNewTask(boolean z16) {
            this.f38324f = z16;
        }

        public void setWeakContext(WeakReference<Context> weakReference) {
            this.f38319a = weakReference;
        }
    }

    boolean jumpToActivityAndRegisterCallback(Context context, Intent intent);

    boolean jumpToCustomLandingPage(Params params);
}
