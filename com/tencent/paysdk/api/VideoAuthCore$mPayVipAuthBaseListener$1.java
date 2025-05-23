package com.tencent.paysdk.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.IAuthTask;
import com.tencent.paysdk.api.VideoAuthCore;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0016J\u001e\u0010\b\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0016J\u001e\u0010\t\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/paysdk/api/VideoAuthCore$mPayVipAuthBaseListener$1", "Lcom/tencent/paysdk/vipauth/a;", "Lcom/tencent/paysdk/vipauth/requestdata/BaseRequestData;", "Lcom/tencent/paysdk/vipauth/responsedata/VideoPreAuthResponse;", "Lcom/tencent/paysdk/vipauth/e;", "resultInfo", "", "c", "b", "a", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class VideoAuthCore$mPayVipAuthBaseListener$1 implements com.tencent.paysdk.vipauth.a<BaseRequestData, VideoPreAuthResponse> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoAuthCore f341984a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoAuthCore$mPayVipAuthBaseListener$1(VideoAuthCore videoAuthCore) {
        this.f341984a = videoAuthCore;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoAuthCore);
        }
    }

    @Override // com.tencent.paysdk.vipauth.a
    public void a(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        VideoAuthCore.a aVar;
        IAuthTask.a aVar2;
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            aVar = this.f341984a.flags;
            aVar.n(3);
            String str = null;
            this.f341984a.authInfo = null;
            VideoAuthCore videoAuthCore = this.f341984a;
            if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null) {
                str = playerPayViewMergeInfoBean.getPlayerPayviewJsoninfo();
            }
            videoAuthCore.mAuthJsonInfo = String.valueOf(str);
            aVar2 = this.f341984a.mIVideoAuthCallback;
            if (aVar2 != null) {
                aVar2.b(resultInfo);
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) resultInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (r0.e() == false) goto L23;
     */
    @Override // com.tencent.paysdk.vipauth.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@Nullable final com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        VideoAuthCore.a aVar;
        String str;
        IAuthTask.a aVar2;
        VideoAuthCore.a aVar3;
        VideoAuthCore.a aVar4;
        VideoAuthCore.a aVar5;
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            aVar = this.f341984a.flags;
            aVar.n(2);
            this.f341984a.authInfo = resultInfo;
            VideoAuthCore videoAuthCore = this.f341984a;
            if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null) {
                str = playerPayViewMergeInfoBean.getPlayerPayviewJsoninfo();
            } else {
                str = null;
            }
            videoAuthCore.mAuthJsonInfo = String.valueOf(str);
            aVar2 = this.f341984a.mIVideoAuthCallback;
            if (aVar2 != null) {
                aVar2.a(resultInfo);
            }
            aVar3 = this.f341984a.flags;
            if (!aVar3.h()) {
                aVar5 = this.f341984a.flags;
            }
            com.tencent.paysdk.util.a.a().post(new Runnable(resultInfo) { // from class: com.tencent.paysdk.api.VideoAuthCore$mPayVipAuthBaseListener$1$onCheckPayStateShouldPay$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.paysdk.vipauth.e f341985d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f341985d = resultInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore$mPayVipAuthBaseListener$1.this, (Object) resultInfo);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        VideoAuthCore$mPayVipAuthBaseListener$1.this.f341984a.I(this.f341985d);
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
            com.tencent.paysdk.util.a.a().post(new Runnable(resultInfo) { // from class: com.tencent.paysdk.api.VideoAuthCore$mPayVipAuthBaseListener$1$onCheckPayStateShouldPay$2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.paysdk.vipauth.e f341986d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f341986d = resultInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore$mPayVipAuthBaseListener$1.this, (Object) resultInfo);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        VideoAuthCore$mPayVipAuthBaseListener$1.this.f341984a.J(this.f341986d);
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
            com.tencent.paysdk.util.a.a().post(new Runnable(resultInfo) { // from class: com.tencent.paysdk.api.VideoAuthCore$mPayVipAuthBaseListener$1$onCheckPayStateShouldPay$3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.paysdk.vipauth.e f341987d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f341987d = resultInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore$mPayVipAuthBaseListener$1.this, (Object) resultInfo);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        VideoAuthCore$mPayVipAuthBaseListener$1.this.f341984a.K(this.f341987d);
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
            this.f341984a.R(resultInfo);
            aVar4 = this.f341984a.flags;
            if (aVar4.f()) {
                com.tencent.paysdk.log.c.b("VideoAuthCore", "auth need pay after finishTryPlay, check play audio tips");
                this.f341984a.B();
                return;
            } else {
                com.tencent.paysdk.log.c.b("VideoAuthCore", "auth need pay before finishTryPlay, wait for finishTryPlay");
                return;
            }
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultInfo);
    }

    @Override // com.tencent.paysdk.vipauth.a
    public void c(@Nullable final com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> resultInfo) {
        VideoAuthCore.a aVar;
        String str;
        IAuthTask.a aVar2;
        VideoAuthCore.a aVar3;
        VideoAuthCore.a aVar4;
        VideoPreAuthResponse a16;
        VideoPreAuthResponse.PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            aVar = this.f341984a.flags;
            aVar.n(1);
            this.f341984a.authInfo = resultInfo;
            VideoAuthCore videoAuthCore = this.f341984a;
            if (resultInfo != null && (a16 = resultInfo.a()) != null && (playerPayViewMergeInfoBean = a16.getPlayerPayViewMergeInfoBean()) != null) {
                str = playerPayViewMergeInfoBean.getPlayerPayviewJsoninfo();
            } else {
                str = null;
            }
            videoAuthCore.mAuthJsonInfo = String.valueOf(str);
            this.f341984a.E();
            aVar2 = this.f341984a.mIVideoAuthCallback;
            if (aVar2 != null) {
                aVar2.c(resultInfo);
            }
            aVar3 = this.f341984a.flags;
            if (!aVar3.h()) {
                aVar4 = this.f341984a.flags;
                if (aVar4.e()) {
                    return;
                }
            }
            com.tencent.paysdk.util.a.a().post(new Runnable(resultInfo) { // from class: com.tencent.paysdk.api.VideoAuthCore$mPayVipAuthBaseListener$1$onCheckPayStateSuc$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.paysdk.vipauth.e f341988d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f341988d = resultInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore$mPayVipAuthBaseListener$1.this, (Object) resultInfo);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        VideoAuthCore$mPayVipAuthBaseListener$1.this.f341984a.I(this.f341988d);
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
            com.tencent.paysdk.util.a.a().post(new Runnable(resultInfo) { // from class: com.tencent.paysdk.api.VideoAuthCore$mPayVipAuthBaseListener$1$onCheckPayStateSuc$2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.paysdk.vipauth.e f341989d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f341989d = resultInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VideoAuthCore$mPayVipAuthBaseListener$1.this, (Object) resultInfo);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        VideoAuthCore$mPayVipAuthBaseListener$1.this.f341984a.K(this.f341989d);
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) resultInfo);
    }
}
