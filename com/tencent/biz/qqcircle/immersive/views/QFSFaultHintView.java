package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.immersive.manager.d;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSFaultHintView<T> extends QCircleBaseWidgetView<T> {
    private static RFWMultiDownloadHelper D;
    protected TextView C;

    /* renamed from: d, reason: collision with root package name */
    private RFWDownloader.RFWDownloadListener f90322d;

    /* renamed from: e, reason: collision with root package name */
    protected View f90323e;

    /* renamed from: f, reason: collision with root package name */
    protected View f90324f;

    /* renamed from: h, reason: collision with root package name */
    protected ImageView f90325h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f90326i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f90327m;

    static {
        RFWMultiDownloadHelper rFWMultiDownloadHelper = new RFWMultiDownloadHelper();
        D = rFWMultiDownloadHelper;
        rFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_offline"), vq3.a.a()));
        D.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_nocontent"), vq3.a.a()));
        D.addTask(new RFWMultiDownloadHelper.DownloadTask(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_authority"), vq3.a.a()));
        D.start();
    }

    public QFSFaultHintView(@NonNull Context context) {
        this(context, null);
    }

    private void q0(View view) {
        View findViewById = view.findViewById(R.id.f165226li2);
        this.f90323e = findViewById;
        findViewById.setBackground(ie0.a.f().k(view.getContext(), R.color.qui_common_bg_bottom_light, 0.0f, 1000));
        this.f90324f = view.findViewById(R.id.yok);
        this.f90325h = (ImageView) view.findViewById(R.id.y4a);
        this.f90327m = (TextView) view.findViewById(R.id.f108686ds);
        this.f90326i = (TextView) view.findViewById(R.id.f108696dt);
        this.C = (TextView) view.findViewById(R.id.f164678tg2);
        p0();
    }

    private void r0(int i3) {
        if (this.f90325h == null) {
            return;
        }
        d.b bVar = new d.b();
        bVar.f(i3);
        bVar.j(this.f90325h);
        bVar.i(true);
        com.tencent.biz.qqcircle.immersive.manager.d.c().h(bVar);
    }

    private void v0(boolean z16) {
        if (!z16 && getVisibility() == 0) {
            setVisibility(8);
        }
        if (z16 && getVisibility() == 8) {
            setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g_x;
    }

    protected String k0(String str) {
        return RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(str);
    }

    protected abstract String l0();

    protected abstract String m0();

    protected abstract String n0();

    public void o0() {
        v0(false);
    }

    protected void s0(final ImageView imageView, final String str) {
        if (imageView != null) {
            imageView.setVisibility(0);
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView.2
                @Override // java.lang.Runnable
                public void run() {
                    d.b bVar = new d.b();
                    bVar.h(str);
                    bVar.j(imageView);
                    bVar.i(true);
                    com.tencent.biz.qqcircle.immersive.manager.d.c().h(bVar);
                }
            });
        }
    }

    protected void u0(final ImageView imageView, String str) {
        String k06 = k0(str);
        if (RFWDownloaderFactory.getDownloader(vq3.a.a()).isFileDownLoading(str)) {
            return;
        }
        if (new File(k06).exists()) {
            s0(imageView, k06);
        } else {
            this.f90322d = new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView.1
                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void callEnd(Call call) {
                    com.tencent.biz.richframework.download.v.a(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void callFailed(Call call, IOException iOException) {
                    com.tencent.biz.richframework.download.v.b(this, call, iOException);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void callStart(Call call) {
                    com.tencent.biz.richframework.download.v.c(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
                    com.tencent.biz.richframework.download.v.d(this, call, inetSocketAddress, proxy, protocol2);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
                    com.tencent.biz.richframework.download.v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                    com.tencent.biz.richframework.download.v.f(this, call, inetSocketAddress, proxy);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
                    com.tencent.biz.richframework.download.v.g(this, call, connection);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void connectionReleased(Call call, Connection connection) {
                    com.tencent.biz.richframework.download.v.h(this, call, connection);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsEnd(Call call, String str2, List list) {
                    com.tencent.biz.richframework.download.v.i(this, call, str2, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str2) {
                    com.tencent.biz.richframework.download.v.j(this, call, str2);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, final String str2) {
                    if (z16) {
                        QLog.d("QFSFaultHintView", 1, "filePath =" + str2);
                        QFSFaultHintView.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                QFSFaultHintView.this.s0(imageView, str2);
                            }
                        });
                    }
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestBodyEnd(Call call, long j3) {
                    com.tencent.biz.richframework.download.v.k(this, call, j3);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestBodyStart(Call call) {
                    com.tencent.biz.richframework.download.v.l(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
                    com.tencent.biz.richframework.download.v.m(this, call, request);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void requestHeadersStart(Call call) {
                    com.tencent.biz.richframework.download.v.n(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseBodyEnd(Call call, long j3) {
                    com.tencent.biz.richframework.download.v.o(this, call, j3);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseBodyStart(Call call) {
                    com.tencent.biz.richframework.download.v.p(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
                    com.tencent.biz.richframework.download.v.q(this, call, response);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void responseHeadersStart(Call call) {
                    com.tencent.biz.richframework.download.v.r(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
                    com.tencent.biz.richframework.download.v.s(this, call, handshake);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void secureConnectStart(Call call) {
                    com.tencent.biz.richframework.download.v.t(this, call);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            };
            RFWDownloaderFactory.getDownloader(vq3.a.a()).download(str, this.f90322d);
        }
    }

    public void w0(String str, String str2, String str3, int i3) {
        if (HostNetworkUtils.isNetworkAvailable()) {
            x0(str, str2, str3, i3);
        } else {
            y0(i3);
        }
        v0(true);
    }

    protected void x0(String str, String str2, String str3, int i3) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        com.tencent.biz.qqcircle.immersive.utils.ae.c(this.f90326i, str);
        com.tencent.biz.qqcircle.immersive.utils.ae.c(this.f90327m, str2);
        u0(this.f90325h, str3);
        if (this.f90325h.getDrawable() == null) {
            r0(i3);
        }
    }

    protected void y0(int i3) {
        String k06 = k0(l0());
        if (new File(k06).exists()) {
            s0(this.f90325h, k06);
        } else {
            r0(i3);
        }
        this.f90326i.setText(n0());
        this.f90327m.setText(m0());
    }

    public QFSFaultHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        q0(this);
    }

    protected void p0() {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(T t16, int i3) {
    }
}
