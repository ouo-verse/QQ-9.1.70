package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a implements Manager, com.tencent.mobileqq.intervideo.yiqikan.a, b {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f238375d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.intervideo.yiqikan.c f238376e = new C7946a();

    public a(QQAppInterface qQAppInterface) {
        QLog.i("XProxy|NowProxy", 1, "DynamicNowManager create app = " + qQAppInterface);
        this.f238375d = qQAppInterface;
    }

    public static int i(String str) {
        return (str.equals("1") || str.equals("2")) ? 1 : 2;
    }

    public static QQAppInterface k() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        throw new InvalidParameterException("can't get AppInterface");
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public com.tencent.mobileqq.intervideo.yiqikan.c a() {
        return this.f238376e;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QLog.i("XProxy|NowProxy", 1, "DynamicNowManager onDestroy mApp = " + this.f238375d);
        this.f238375d = null;
    }

    public static void g() {
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.b
    public void e() {
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.b
    public void f() {
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.b
    public void preload() {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.intervideo.now.dynamic.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class C7946a implements com.tencent.mobileqq.intervideo.yiqikan.c {
        C7946a() {
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.c
        public void a(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.c
        public void b(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.c
        public void c(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        }
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.b
    public void b(Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.b
    public void c(Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public void d(NewTogetherRoomMessageData newTogetherRoomMessageData) {
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public void h(NewTogetherRoomMessageData newTogetherRoomMessageData, Bundle bundle, com.tencent.mobileqq.intervideo.yiqikan.b bVar) {
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public void j(NewTogetherRoomMessageData newTogetherRoomMessageData, Bundle bundle, com.tencent.mobileqq.intervideo.yiqikan.b bVar) {
    }
}
