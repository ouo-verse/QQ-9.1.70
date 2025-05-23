package com.tencent.biz.pubaccount.imagecollection.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountImageCollectionUtils extends QRouteApi {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f79733a;

        /* renamed from: b, reason: collision with root package name */
        public String f79734b;

        /* renamed from: c, reason: collision with root package name */
        public String f79735c;

        /* renamed from: d, reason: collision with root package name */
        public String f79736d;

        /* renamed from: e, reason: collision with root package name */
        public String f79737e;

        /* renamed from: f, reason: collision with root package name */
        public int f79738f;

        /* renamed from: g, reason: collision with root package name */
        public String f79739g;

        /* renamed from: h, reason: collision with root package name */
        public b f79740h;

        /* renamed from: i, reason: collision with root package name */
        public ArrayList<c> f79741i;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f79742a;

        /* renamed from: b, reason: collision with root package name */
        public String f79743b;

        /* renamed from: c, reason: collision with root package name */
        public String f79744c;

        /* renamed from: d, reason: collision with root package name */
        public String f79745d;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f79746a;

        /* renamed from: b, reason: collision with root package name */
        public String f79747b;

        /* renamed from: c, reason: collision with root package name */
        public String f79748c;

        /* renamed from: d, reason: collision with root package name */
        public int f79749d = 600;

        /* renamed from: e, reason: collision with root package name */
        public int f79750e = 400;

        /* renamed from: f, reason: collision with root package name */
        public boolean f79751f;
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f79752a;

        /* renamed from: b, reason: collision with root package name */
        public String f79753b;

        /* renamed from: c, reason: collision with root package name */
        public String f79754c;

        /* renamed from: d, reason: collision with root package name */
        public String f79755d;
    }

    boolean openPublicAccountImageCollectionMainActivity(Activity activity, Intent intent, String str);
}
