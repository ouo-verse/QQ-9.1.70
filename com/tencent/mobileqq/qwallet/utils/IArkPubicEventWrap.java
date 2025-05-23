package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Observer;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IArkPubicEventWrap extends QRouteApi {

    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f279242a;

        /* renamed from: b, reason: collision with root package name */
        public String f279243b;

        /* renamed from: c, reason: collision with root package name */
        public String f279244c;

        public a(String str, String str2, String str3) {
            this.f279242a = str;
            this.f279243b = str2;
            this.f279244c = str3;
        }
    }

    void addNotify(String str);

    void addObserver(Observer observer);

    void callbackMuteStatus();

    void deleteObserver(Observer observer);

    void registVolumnReceiver(List<String> list);

    void registVolumnReceiver(String... strArr);

    void removeNotify(String str);

    void unRegistVolumnReceiver(List<String> list);

    void unRegistVolumnReceiver(String... strArr);
}
