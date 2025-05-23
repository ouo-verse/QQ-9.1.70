package com.tencent.paysdk.vipauth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.report.InternalReport;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public abstract class VideoPreAuthInternal implements com.tencent.paysdk.network.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected a<BaseRequestData, VideoPreAuthResponse> f342109a;

    /* renamed from: b, reason: collision with root package name */
    protected final e<BaseRequestData, VideoPreAuthResponse> f342110b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    protected com.tencent.paysdk.api.c f342111c;

    /* renamed from: d, reason: collision with root package name */
    private int f342112d;

    /* renamed from: e, reason: collision with root package name */
    protected String f342113e;

    public VideoPreAuthInternal(@NonNull com.tencent.paysdk.api.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.f342110b = new e<>();
            this.f342111c = cVar;
        }
    }

    @Override // com.tencent.paysdk.network.c
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.tencent.paysdk.util.a.b(new Runnable() { // from class: com.tencent.paysdk.vipauth.VideoPreAuthInternal.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoPreAuthInternal.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        VideoPreAuthInternal videoPreAuthInternal = VideoPreAuthInternal.this;
                        a<BaseRequestData, VideoPreAuthResponse> aVar = videoPreAuthInternal.f342109a;
                        if (aVar != null) {
                            aVar.a(videoPreAuthInternal.f342110b);
                            InternalReport.f(VideoPreAuthInternal.this.d(510001, InternalReport.e(VideoPreAuthInternal.this.f342112d)));
                        }
                    }
                });
                return;
            }
            VideoPreAuthResponse videoPreAuthResponse = (VideoPreAuthResponse) com.tencent.paysdk.util.d.a(str, VideoPreAuthResponse.class);
            this.f342110b.c(videoPreAuthResponse);
            com.tencent.paysdk.util.a.b(new Runnable(videoPreAuthResponse, i3, str) { // from class: com.tencent.paysdk.vipauth.VideoPreAuthInternal.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ VideoPreAuthResponse f342114d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f342115e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f342116f;

                {
                    this.f342114d = videoPreAuthResponse;
                    this.f342115e = i3;
                    this.f342116f = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VideoPreAuthInternal.this, videoPreAuthResponse, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map<String, Object> d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    VideoPreAuthResponse videoPreAuthResponse2 = this.f342114d;
                    if (videoPreAuthResponse2 == null) {
                        VideoPreAuthInternal.this.onFailed(this.f342115e);
                        return;
                    }
                    if (videoPreAuthResponse2.isPayState()) {
                        VideoPreAuthInternal videoPreAuthInternal = VideoPreAuthInternal.this;
                        a<BaseRequestData, VideoPreAuthResponse> aVar = videoPreAuthInternal.f342109a;
                        if (aVar != null) {
                            aVar.c(videoPreAuthInternal.f342110b);
                            Map<String, Object> d17 = VideoPreAuthInternal.this.d(0, InternalReport.e(VideoPreAuthInternal.this.f342112d));
                            d17.put("data", this.f342116f);
                            InternalReport.f(d17);
                            return;
                        }
                        return;
                    }
                    VideoPreAuthInternal videoPreAuthInternal2 = VideoPreAuthInternal.this;
                    a<BaseRequestData, VideoPreAuthResponse> aVar2 = videoPreAuthInternal2.f342109a;
                    if (aVar2 != null) {
                        aVar2.b(videoPreAuthInternal2.f342110b);
                        long e16 = InternalReport.e(VideoPreAuthInternal.this.f342112d);
                        if (this.f342114d.getPlayerPayViewMergeInfoBean() != null && !TextUtils.isEmpty(this.f342114d.getPlayerPayViewMergeInfoBean().getPlayerPayviewUrl())) {
                            d16 = VideoPreAuthInternal.this.d(0, e16);
                        } else {
                            d16 = VideoPreAuthInternal.this.d(510002, e16);
                        }
                        d16.put("data", this.f342116f);
                        InternalReport.f(d16);
                    }
                }
            });
        }
    }

    public void c(a<BaseRequestData, VideoPreAuthResponse> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        int d16 = InternalReport.d();
        this.f342112d = d16;
        InternalReport.g(d16);
        this.f342109a = aVar;
    }

    protected abstract Map<String, Object> d(int i3, long j3);

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f342113e = str;
        }
    }

    @Override // com.tencent.paysdk.network.c
    public void onFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            com.tencent.paysdk.util.a.b(new Runnable() { // from class: com.tencent.paysdk.vipauth.VideoPreAuthInternal.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoPreAuthInternal.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    VideoPreAuthInternal videoPreAuthInternal = VideoPreAuthInternal.this;
                    a<BaseRequestData, VideoPreAuthResponse> aVar = videoPreAuthInternal.f342109a;
                    if (aVar != null) {
                        aVar.a(videoPreAuthInternal.f342110b);
                        InternalReport.f(VideoPreAuthInternal.this.d(510001, InternalReport.e(VideoPreAuthInternal.this.f342112d)));
                    }
                }
            });
        }
    }
}
