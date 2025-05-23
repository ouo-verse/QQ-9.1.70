package com.tencent.mobileqq.tvideo.authpay;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayReloadEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoRewardAdClickEvent;
import com.tencent.paysdk.api.IAuthTask;
import com.tencent.paysdk.api.g;
import com.tencent.paysdk.api.i;
import com.tencent.paysdk.api.l;
import com.tencent.paysdk.data.VideoInfo;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import zt2.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private jx2.f f304336a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f304337b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f304338c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f304339d;

    /* renamed from: e, reason: collision with root package name */
    private VideoInfo f304340e;

    /* renamed from: f, reason: collision with root package name */
    private IAuthTask f304341f;

    /* renamed from: g, reason: collision with root package name */
    private String f304342g;

    /* renamed from: h, reason: collision with root package name */
    private f f304343h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f304344i;

    /* renamed from: j, reason: collision with root package name */
    com.tencent.paysdk.api.f f304345j = new b();

    /* renamed from: k, reason: collision with root package name */
    g f304346k = new c();

    /* renamed from: l, reason: collision with root package name */
    i f304347l = new d();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.authpay.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8860a implements com.tencent.paysdk.api.c {
        C8860a() {
        }

        @Override // com.tencent.paysdk.api.c
        @NonNull
        public com.tencent.paysdk.api.f a(@NonNull Context context) {
            return a.this.f304345j;
        }

        @Override // com.tencent.paysdk.api.c
        public void b(@Nullable Map<String, ?> map) {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " doH5Report ");
        }

        @Override // com.tencent.paysdk.api.c
        @NonNull
        public i c() {
            return a.this.f304347l;
        }

        @Override // com.tencent.paysdk.api.c
        @NonNull
        public g d() {
            return a.this.f304346k;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements com.tencent.paysdk.api.f {
        b() {
        }

        @Override // com.tencent.paysdk.api.f
        public boolean a(@NonNull Map<String, ?> map) {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, "openWebView map  : " + map);
            QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent = new QFSTVideoPageWebViewShowEvent();
            qFSTVideoPageWebViewShowEvent.setFromAuthPay(true);
            qFSTVideoPageWebViewShowEvent.setParamsMap(map);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPageWebViewShowEvent);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements g {
        c() {
        }

        @Override // com.tencent.paysdk.api.g
        @NonNull
        public ViewGroup a() {
            return a.this.f304337b;
        }

        @Override // com.tencent.paysdk.api.g
        @NonNull
        public l b() {
            return new com.tencent.mobileqq.tvideo.authpay.b(a.this.f304338c, a.this.f304343h);
        }

        @Override // com.tencent.paysdk.api.g
        @NonNull
        public l c() {
            return new com.tencent.mobileqq.tvideo.authpay.b(a.this.f304339d, null);
        }

        @Override // com.tencent.paysdk.api.g
        @NonNull
        public ViewGroup d() {
            return a.this.f304339d;
        }

        @Override // com.tencent.paysdk.api.g
        @NonNull
        public ViewGroup e() {
            return a.this.f304338c;
        }

        @Override // com.tencent.paysdk.api.g
        @NonNull
        public l f() {
            return new com.tencent.mobileqq.tvideo.authpay.b(a.this.f304337b, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements i {
        d() {
        }

        @Override // com.tencent.paysdk.api.i
        public void a() {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " unlockVideo");
            a.this.s();
        }

        @Override // com.tencent.paysdk.api.i
        public void b(boolean z16) {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " replayVideo isContinue = " + z16);
            a.this.p();
        }

        @Override // com.tencent.paysdk.api.i
        @NonNull
        public VideoInfo c() {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " getVideoInfo");
            return a.this.f304340e;
        }

        @Override // com.tencent.paysdk.api.i
        @Nullable
        public com.tencent.paysdk.api.e d() {
            return null;
        }

        @Override // com.tencent.paysdk.api.i
        public void f() {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " startPreview ");
            a.this.p();
        }

        @Override // com.tencent.paysdk.api.i
        public void pause() {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, "pause");
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements IAuthTask.a {
        e() {
        }

        @Override // com.tencent.paysdk.api.IAuthTask.a
        public void a(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> eVar) {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " temporaryauthpay " + a.this.l() + " startVideoAuth  onShouldPay ");
            a.this.m(eVar);
        }

        @Override // com.tencent.paysdk.api.IAuthTask.a
        public void b(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> eVar) {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " authpay " + a.this.l() + " startVideoAuth  onFailed ");
        }

        @Override // com.tencent.paysdk.api.IAuthTask.a
        public void c(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> eVar) {
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " authpay " + a.this.l() + " startVideoAuth  onSuccess ");
            a.this.m(eVar);
            if (a.this.f304343h != null) {
                a.this.f304343h.onAuthSuccess();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface f {
        void a(boolean z16);

        void onAuthSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        VideoInfo videoInfo = this.f304340e;
        if (videoInfo == null) {
            return "";
        }
        return videoInfo.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> eVar) {
        if (eVar != null && eVar.a() != null && eVar.a().getPlayerPayViewMergeInfoBean() != null) {
            VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean = eVar.a().getPlayerPayViewMergeInfoBean();
            QLog.d("TVideoAuthPayItemAuthHelper", 1, " temporaryauthpay isNotNewBot = " + playerPayViewMergeInfoBean.getIsNotNewBot());
            this.f304344i = playerPayViewMergeInfoBean.getIsNotNewBot();
            qx2.a.c().f430271c = playerPayViewMergeInfoBean.getOpenVipUrl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f304336a == null) {
            return;
        }
        QFSTVideoAuthPayReloadEvent qFSTVideoAuthPayReloadEvent = new QFSTVideoAuthPayReloadEvent();
        qFSTVideoAuthPayReloadEvent.setPos(this.f304336a.d());
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayReloadEvent);
    }

    private void r() {
        k.b();
        QFSTVideoAuthPayReloadEvent qFSTVideoAuthPayReloadEvent = new QFSTVideoAuthPayReloadEvent();
        qFSTVideoAuthPayReloadEvent.setIgnorePos(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayReloadEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        VideoInfo videoInfo = this.f304340e;
        if (videoInfo != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoRewardAdClickEvent(videoInfo.b(), this.f304340e.n(), this.f304342g));
        }
    }

    private void w() {
        HashMap hashMap = new HashMap();
        hashMap.put("source2", "34000");
        this.f304341f.f(hashMap);
    }

    public void j() {
        IAuthTask iAuthTask = this.f304341f;
        if (iAuthTask != null) {
            iAuthTask.clear();
            this.f304341f = null;
        }
    }

    public void k() {
        if (k.d(this.f304340e.n())) {
            r();
            return;
        }
        IAuthTask iAuthTask = this.f304341f;
        if (iAuthTask != null) {
            iAuthTask.g();
        }
    }

    public boolean n() {
        QLog.d("TVideoAuthPayItemAuthHelper", 1, " isNeedTemporaryAuth isNotNewBotVideo = " + this.f304344i);
        return this.f304344i;
    }

    public IAuthTask o(jx2.f fVar, f fVar2) {
        if (fVar == null) {
            return null;
        }
        this.f304336a = fVar;
        this.f304337b = fVar.c();
        this.f304338c = fVar.a();
        this.f304339d = fVar.b();
        this.f304343h = fVar2;
        IAuthTask iAuthTask = this.f304341f;
        if (iAuthTask != null) {
            return iAuthTask;
        }
        QLog.d("TVideoAuthPayItemAuthHelper", 1, " newVideoAuth" + l() + " pos = " + this.f304336a.d());
        this.f304341f = com.tencent.paysdk.a.s(new C8860a());
        w();
        return this.f304341f;
    }

    public void q() {
        QLog.d("TVideoAuthPayItemAuthHelper", 1, " isNeedTemporaryAuth resetNewBotVideo " + this.f304344i);
        this.f304344i = false;
    }

    public void t(int i3) {
        jx2.f fVar = this.f304336a;
        if (fVar != null) {
            fVar.h(i3);
        }
    }

    public void u(String str) {
        this.f304342g = str;
    }

    public void v(Long l3) {
        VideoInfo videoInfo = this.f304340e;
        if (videoInfo != null) {
            videoInfo.s(l3.longValue());
        }
    }

    public void x(VideoInfo videoInfo) {
        this.f304340e = videoInfo;
    }

    public void y() {
        IAuthTask iAuthTask = this.f304341f;
        if (iAuthTask != null) {
            iAuthTask.a();
        }
    }

    public void z() {
        IAuthTask iAuthTask = this.f304341f;
        if (iAuthTask == null) {
            return;
        }
        iAuthTask.d(new e());
    }
}
