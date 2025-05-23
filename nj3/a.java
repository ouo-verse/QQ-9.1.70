package nj3;

import com.tencent.common.config.AppSetting;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetClientPlatformResponse;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetClientVersionResponse;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetCurrentUinResponse;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.zplan.utils.bb;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J \u0010\n\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\tH\u0016J \u0010\r\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lnj3/a;", "Lel0/c;", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/QQAppChannel$GetClientPlatformResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQAppGetClientPlatformResponse;", "callback", "b", "Lcom/tencent/filament/zplanservice/pbjava/QQAppChannel$GetClientVersionResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQAppGetClientVersionResponse;", "c", "Lcom/tencent/filament/zplanservice/pbjava/QQAppChannel$GetCurrentUinResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQAppGetCurrentUinResponse;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements el0.c {
    @Override // el0.c
    public void a(Function1<? super QQAppChannel$GetCurrentUinResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQAppChannel$GetCurrentUinResponse qQAppChannel$GetCurrentUinResponse = new QQAppChannel$GetCurrentUinResponse();
        PBUInt64Field pBUInt64Field = qQAppChannel$GetCurrentUinResponse.uin;
        String e16 = bb.f335811a.e();
        pBUInt64Field.set(e16 != null ? Long.parseLong(e16) : 0L);
        callback.invoke(qQAppChannel$GetCurrentUinResponse);
    }

    @Override // el0.c
    public void b(Function1<? super QQAppChannel$GetClientPlatformResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQAppChannel$GetClientPlatformResponse qQAppChannel$GetClientPlatformResponse = new QQAppChannel$GetClientPlatformResponse();
        qQAppChannel$GetClientPlatformResponse.platform.set("and");
        callback.invoke(qQAppChannel$GetClientPlatformResponse);
    }

    @Override // el0.c
    public void c(Function1<? super QQAppChannel$GetClientVersionResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQAppChannel$GetClientVersionResponse qQAppChannel$GetClientVersionResponse = new QQAppChannel$GetClientVersionResponse();
        qQAppChannel$GetClientVersionResponse.version.set(AppSetting.f99551k + "." + AppSetting.f99542b);
        callback.invoke(qQAppChannel$GetClientVersionResponse);
    }
}
