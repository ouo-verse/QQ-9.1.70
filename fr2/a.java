package fr2;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\"\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\" \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"", "id", "chatType", "", "c", "d", "Lcom/tencent/mobileqq/springhb/api/ISpringHbReportApi;", "a", "()Lcom/tencent/mobileqq/springhb/api/ISpringHbReportApi;", DTConstants.TAG.API, "", "b", "()Ljava/util/Map;", "paramMap", "springhb-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    private static final ISpringHbReportApi a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all");
        }
        return null;
    }

    private static final Map<String, String> b() {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("buss_id", "host"), TuplesKt.to("module_id", "hidden_feature"), TuplesKt.to("submodule_id", "cartoon"));
        return mutableMapOf;
    }

    public static final void c(@NotNull String id5, @NotNull String chatType) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(chatType, "chatType");
        QLog.d("InteractiveTracker", 2, "trackExp");
        ISpringHbReportApi a16 = a();
        if (a16 != null) {
            Map<String, String> b16 = b();
            b16.put("ext2", id5);
            b16.put("ext4", chatType);
            b16.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
            a16.reportForGameCenter(b16);
        }
    }

    public static final void d(@NotNull String id5, @NotNull String chatType) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(chatType, "chatType");
        QLog.d("InteractiveTracker", 2, "trackJumpClick");
        ISpringHbReportApi a16 = a();
        if (a16 != null) {
            Map<String, String> b16 = b();
            b16.put("ext2", id5);
            b16.put("ext4", chatType);
            b16.put(WadlReportBuilder.TableElem.OPER_ID, "clk");
            a16.reportForGameCenter(b16);
        }
    }
}
