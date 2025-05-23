package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f212297c = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private final List<WadlTrpcListener> f212299b = Collections.synchronizedList(new LinkedList());

    /* renamed from: a, reason: collision with root package name */
    private final IQQGameTrpcService f212298a = (IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.gamecenter.protocols.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7644a implements WadlTrpcListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f212300d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f212301e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f212302f;

        C7644a(String str, int i3, b bVar) {
            this.f212300d = str;
            this.f212301e = i3;
            this.f212302f = bVar;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<>(Collections.singletonList(this.f212300d));
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (intent != null && intent.getIntExtra("gc_common_req_sender_seq", 0) == this.f212301e) {
                a.this.f212299b.remove(this);
                a.this.f212298a.removeListener(this);
                if (TextUtils.equals(this.f212300d, str)) {
                    b bVar = this.f212302f;
                    if (bVar != null) {
                        if (trpcInovkeRsp == null) {
                            bVar.a(j3, null, null);
                            return;
                        } else {
                            bVar.a(trpcInovkeRsp.ret.get(), trpcInovkeRsp.f106731msg.get(), trpcInovkeRsp.data.get().toByteArray());
                            return;
                        }
                    }
                    return;
                }
                QLog.e("CommonReqSender", 1, "sendRequest: unexpected trpcCmd=" + str + ", but cmd=" + this.f212300d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(long j3, @Nullable String str, @Nullable byte[] bArr);
    }

    private WadlTrpcListener c(int i3, @NonNull String str, @Nullable b bVar) {
        C7644a c7644a = new C7644a(str, i3, bVar);
        this.f212299b.add(c7644a);
        return c7644a;
    }

    public void d(@NonNull String str, @NonNull MessageMicro<?> messageMicro, @Nullable b bVar) {
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = this.f212298a.createTrpcInvokeReq(str, false, messageMicro.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        int incrementAndGet = f212297c.incrementAndGet();
        this.f212298a.addListener(c(incrementAndGet, str, bVar));
        Bundle bundle = new Bundle();
        bundle.putInt("gc_common_req_sender_seq", incrementAndGet);
        this.f212298a.requestTrpc(trpcListReq, bundle);
    }
}
