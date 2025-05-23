package nj3;

import android.text.TextUtils;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCRawDataRequest;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCRawDataResponse;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCSwitchRequest;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCSwitchResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lnj3/b;", "Lel0/d;", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCRawDataRequest;", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCRawDataResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQMCRawDataResponse;", "callback", "b", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCSwitchRequest;", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCSwitchResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQMCSwitchResponse;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements el0.d {
    @Override // el0.d
    public void a(QQMCChannel$QQMCSwitchRequest req, Function1<? super QQMCChannel$QQMCSwitchResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        String str = req.key.get();
        Intrinsics.checkNotNullExpressionValue(str, "req.key.get()");
        boolean isSwitchOn = iUnitedConfigManager.isSwitchOn(str, req.default_value.get());
        QQMCChannel$QQMCSwitchResponse qQMCChannel$QQMCSwitchResponse = new QQMCChannel$QQMCSwitchResponse();
        qQMCChannel$QQMCSwitchResponse.is_on.set(isSwitchOn);
        callback.invoke(qQMCChannel$QQMCSwitchResponse);
    }

    @Override // el0.d
    public void b(QQMCChannel$QQMCRawDataRequest req, Function1<? super QQMCChannel$QQMCRawDataResponse, Unit> callback) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String key = req.key.get();
        if (TextUtils.isEmpty("")) {
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            byte[] bytes2 = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            bytes = iUnitedConfigManager.loadRawConfig(key, bytes2);
        } else {
            bytes = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bytes, UTF_8);
        QQMCChannel$QQMCRawDataResponse qQMCChannel$QQMCRawDataResponse = new QQMCChannel$QQMCRawDataResponse();
        qQMCChannel$QQMCRawDataResponse.data.set(ByteStringMicro.copyFromUtf8(str));
        callback.invoke(qQMCChannel$QQMCRawDataResponse);
    }
}
