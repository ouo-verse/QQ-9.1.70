package nj3;

import com.tencent.filament.zplanservice.pbjava.MSFChannel$MSFRequest;
import com.tencent.filament.zplanservice.pbjava.MSFChannel$MSFResponse;
import com.tencent.filament.zplanservice.pbjava.ZPlanError;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.zplan.proxy.channel.request.ChannelBusinessObserver;
import com.tencent.mobileqq.zplan.proxy.channel.request.ChannelRequestHandler;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bj\u0002`\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lnj3/d;", "Lel0/b;", "Lcom/tencent/filament/zplanservice/pbjava/MSFChannel$MSFRequest;", "req", "", "rspData", "", "d", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/MSFChannel$MSFResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IMSFChannelRequestResponse;", "listener", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d implements el0.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"nj3/d$b", "Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "", "ssoResultCode", "trpcRspFuncRetCode", "", "trpcRspErrorMsg", "", "rspData", "", "onResponse", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements ChannelBusinessObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MSFChannel$MSFRequest f420248a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<MSFChannel$MSFResponse, Unit> f420249b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f420250c;

        /* JADX WARN: Multi-variable type inference failed */
        b(MSFChannel$MSFRequest mSFChannel$MSFRequest, Function1<? super MSFChannel$MSFResponse, Unit> function1, d dVar) {
            this.f420248a = mSFChannel$MSFRequest;
            this.f420249b = function1;
            this.f420250c = dVar;
        }

        @Override // com.tencent.mobileqq.zplan.proxy.channel.request.ChannelBusinessObserver
        public void onResponse(int ssoResultCode, int trpcRspFuncRetCode, String trpcRspErrorMsg, Object rspData) {
            QLog.i("QQMSFChannelProxy", 1, "after " + this.f420248a.command.get() + " request, ssoResultCode:" + ssoResultCode + ", trpcRspFuncRetCode: " + trpcRspFuncRetCode);
            Function1<MSFChannel$MSFResponse, Unit> function1 = this.f420249b;
            MSFChannel$MSFResponse mSFChannel$MSFResponse = new MSFChannel$MSFResponse();
            PBBytesField pBBytesField = mSFChannel$MSFResponse.data;
            Intrinsics.checkNotNull(rspData, "null cannot be cast to non-null type kotlin.ByteArray");
            pBBytesField.set(ByteStringMicro.copyFrom((byte[]) rspData));
            if (ssoResultCode != 1000 || trpcRspFuncRetCode != 0) {
                ZPlanError zPlanError = mSFChannel$MSFResponse.error;
                ZPlanError zPlanError2 = new ZPlanError();
                zPlanError2.domain.set("msf");
                zPlanError2.code.set(trpcRspFuncRetCode);
                zPlanError2.message.set(trpcRspErrorMsg);
                zPlanError.set(zPlanError2);
            }
            function1.invoke(mSFChannel$MSFResponse);
            this.f420250c.d(this.f420248a, rspData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final MSFChannel$MSFRequest req, final Object rspData) {
        ThreadManagerV2.excute(new Runnable() { // from class: nj3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.e(MSFChannel$MSFRequest.this, rspData);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MSFChannel$MSFRequest req, Object obj) {
        File parentFile;
        Intrinsics.checkNotNullParameter(req, "$req");
        boolean z16 = false;
        boolean a16 = j74.a.f409621a.a(bb.f335811a.e(), "msf_channel_save_file", false);
        QLog.i("QQMSFChannelProxy", 1, "debugSaveFile : " + a16);
        if (!a16) {
            return;
        }
        try {
            String str = BaseApplication.getContext().getCacheDir() + "/test/" + req.command.get() + ".data";
            File file = new File(str);
            if (!file.exists()) {
                File parentFile2 = file.getParentFile();
                if (parentFile2 != null && !parentFile2.exists()) {
                    z16 = true;
                }
                if (z16 && (parentFile = file.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            try {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                fileOutputStream.write((byte[]) obj);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } finally {
            }
        } catch (Throwable th5) {
            QLog.i("QQMSFChannelProxy", 1, "after request save crash, " + th5);
        }
    }

    @Override // el0.b
    public void a(MSFChannel$MSFRequest req, Function1<? super MSFChannel$MSFResponse, Unit> listener) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ChannelRequestHandler a16 = ChannelRequestHandler.INSTANCE.a();
        Intrinsics.checkNotNull(a16);
        String str = req.command.get();
        Intrinsics.checkNotNullExpressionValue(str, "req.command.get()");
        a16.G2(str, req.data.get().toByteArray(), new b(req, listener, this));
    }
}
