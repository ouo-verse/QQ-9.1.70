package com.tencent.mobileqq.zootopia.service.api.impl;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaTextSecurityService;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ4\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/impl/ZootopiaTextSecurityServiceImpl;", "Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaTextSecurityService;", "Lcom/tencent/common/app/AppInterface;", "app", "", "", "textList", "Lkotlin/Function1;", "", "", "callback", "checkTextSecurity", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaTextSecurityServiceImpl implements IZootopiaTextSecurityService {
    private static final String METHOD = "CheckGIF";
    private static final String SERVICE = "trpc.qmeta.style_template_security_svr.StyleTemplateSecurity";
    private static final String TAG = "ZootopiaTextSecurityServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/ZootopiaTextSecurityServiceImpl$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329179a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f329179a = function1;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i(ZootopiaTextSecurityServiceImpl.TAG, 1, "checkTextSecurity request error, errCode: " + errCode + ", errMsg: " + errMsg);
            this.f329179a.invoke(Boolean.FALSE);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            QLog.i(ZootopiaTextSecurityServiceImpl.TAG, 1, "checkTextSecurity request success");
            this.f329179a.invoke(Boolean.TRUE);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaTextSecurityService
    public void checkTextSecurity(AppInterface app, List<String> textList, Function1<? super Boolean, Unit> callback) {
        int collectionSizeOrDefault;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(textList, "textList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object obj = app;
        if (app == null) {
            obj = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        if (!(obj instanceof AppInterface)) {
            QLog.e(TAG, 1, "checkTextSecurity app is not AppInterface");
            return;
        }
        vv4.a aVar = new vv4.a();
        List<String> list = textList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            byte[] bytes = ((String) it.next()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            arrayList.add(bytes);
        }
        Object[] array = arrayList.toArray(new byte[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar.f443590a = (byte[][]) array;
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(this)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, (AppInterface) obj, SERVICE, METHOD, byteArray, emptyMap, new b(callback), 0, 64, null);
    }
}
