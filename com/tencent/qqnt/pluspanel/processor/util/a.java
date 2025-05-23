package com.tencent.qqnt.pluspanel.processor.util;

import com.tencent.aio.data.AIOSession;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JH\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H\u0007J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/util/a;", "", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "process", "a", "", "source", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f360544a = new a();

    a() {
    }

    @Deprecated(message = "\u4e3a\u52a0\u53f7\u9762\u677f\u6ce8\u5165\u63d0\u4f9buin\u548cQQAppInterface\uff0c\u82e5\u4e0d\u4f9d\u8d56\u5219\u65e0\u9700\u8c03\u7528\u6b64\u51fd\u6570")
    public final void a(com.tencent.aio.api.runtime.a context, Function2<? super Long, ? super QQAppInterface, Unit> process) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(process, "process");
        AIOSession r16 = context.g().r();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("AppProcessUtil", 1, "need QQAppInterface");
            return;
        }
        if (r16.c().e() == 2) {
            QLog.d("AppProcessUtil", 1, "onClick uin:" + LogUtil.wrapLogUin(r16.c().j()));
            process.invoke(Long.valueOf(Long.parseLong(r16.c().j())), peekAppRuntime);
            return;
        }
        String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(r16.c().j());
        if (uin == null || uin.length() == 0) {
            QLog.e("AppProcessUtil", 1, "PlusPanel require uin exception");
            return;
        }
        QLog.d("AppProcessUtil", 1, "onClick uin:" + LogUtil.wrapLogUin(uin.toString()));
        try {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            process.invoke(Long.valueOf(Long.parseLong(uin)), peekAppRuntime);
        } catch (Exception e16) {
            QLog.e("AppProcessUtil", 1, "parseLongError " + e16);
        }
    }

    public final void b(com.tencent.aio.api.runtime.a context, String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        context.e().h(new PanelContainerMsgIntent.HidePanelMsgIntent(source, 1006, false, 4, null));
    }
}
