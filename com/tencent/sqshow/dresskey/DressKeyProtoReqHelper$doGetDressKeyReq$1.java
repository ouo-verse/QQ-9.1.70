package com.tencent.sqshow.dresskey;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/dresskey/DressKeyProtoReqHelper$doGetDressKeyReq$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressKeyProtoReqHelper$doGetDressKeyReq$1 implements td3.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f369815a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e<dw4.b> f369816b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DressKeyProtoReqHelper$doGetDressKeyReq$1(int i3, e<dw4.b> eVar) {
        this.f369815a = i3;
        this.f369816b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(byte[] bArr, final e callback) {
        final dw4.b bVar;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (bArr == null) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.dresskey.DressKeyProtoReqHelper$doGetDressKeyReq$1$onReceive$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    callback.onResultFailure(-10, "rsp is null");
                }
            });
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        try {
            bVar = dw4.b.d(bArr);
        } catch (Exception e16) {
            String message = e16.getMessage();
            T t16 = message;
            if (message == null) {
                t16 = "RSP_PARSE_FAILED";
            }
            objectRef.element = t16;
            bVar = null;
        }
        if (bVar == null) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.dresskey.DressKeyProtoReqHelper$doGetDressKeyReq$1$onReceive$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    callback.onResultFailure(-13, objectRef.element);
                }
            });
        } else {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.dresskey.DressKeyProtoReqHelper$doGetDressKeyReq$1$onReceive$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    callback.onResultSuccess(bVar);
                }
            });
        }
    }

    @Override // td3.a
    public void a(Integer errCode, String errMsg) {
        String str;
        str = DressKeyProtoReqHelper.TAG;
        QLog.i(str, 1, "doGetDressKeyReq onError errCode:" + errCode + ", errMsg:" + errMsg + ", source:" + this.f369815a);
        this.f369816b.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
    }

    @Override // td3.a
    public void onReceive(final byte[] data) {
        String str;
        str = DressKeyProtoReqHelper.TAG;
        Integer valueOf = data != null ? Integer.valueOf(data.length) : null;
        QLog.i(str, 1, "doGetDressKeyReq onReceive data:" + valueOf + ", source:" + this.f369815a);
        final e<dw4.b> eVar = this.f369816b;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.dresskey.c
            @Override // java.lang.Runnable
            public final void run() {
                DressKeyProtoReqHelper$doGetDressKeyReq$1.c(data, eVar);
            }
        }, 16, null, true);
    }
}
