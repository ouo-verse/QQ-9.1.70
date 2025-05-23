package com.tencent.mobileqq.sharepanel.config;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/b;", "", "", "channelId", "", "a", "", "b", "Ljava/util/Map;", "defaultOrderConfig", "c", "channel2Order", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f287212a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> defaultOrderConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Integer> channel2Order;

    static {
        Map<String, Integer> mutableMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f287212a = new b();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qqfriend", 1001), TuplesKt.to("qzoneshuoshuo", 1002), TuplesKt.to("transfertoqzone", 1003), TuplesKt.to("qqchannel", 1004), TuplesKt.to("weixin", 1005), TuplesKt.to("weixincircle", 1006), TuplesKt.to(QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, 2002), TuplesKt.to("groupalbum", 2003), TuplesKt.to("intimatezone", 2004), TuplesKt.to("mypc", 2005), TuplesKt.to("weiyun", 2006), TuplesKt.to("redbook", 2007), TuplesKt.to("qqbrowser", 3001), TuplesKt.to("browser", 3003), TuplesKt.to(MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, 3004), TuplesKt.to("otherapp", 3005));
        defaultOrderConfig = mutableMapOf;
        new LinkedHashMap();
        channel2Order = mutableMapOf;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@NotNull String channelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId)).intValue();
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Integer num = channel2Order.get(channelId);
        if (num != null) {
            return num.intValue();
        }
        return 10000;
    }
}
