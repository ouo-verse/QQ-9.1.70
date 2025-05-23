package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000eH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipInfoUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "friends", "Lcom/tencent/mobileqq/vip/api/f;", "getHighestVipTypeWithoutBig", "getHighestVipType", "Lcom/tencent/mobileqq/data/VipTypeParam;", "vipTypeParam", "", "getHighestVipInfo", "", "", "ids", "", "getVipIconsString", "str", "", "getVipIconsArray", "uin", "id", "", "setQQSettingVipHomeType", "getQQSettingVipHomeType", "Companion", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipInfoUtils extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipInfoUtils$a;", "", "Lcom/tencent/mobileqq/vip/api/IVipInfoUtils;", "a", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.IVipInfoUtils$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f312788a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39920);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f312788a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @JvmStatic
        @NotNull
        public final IVipInfoUtils a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IVipInfoUtils) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRouteApi api = QRoute.api(IVipInfoUtils.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVipInfoUtils::class.java)");
            return (IVipInfoUtils) api;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39923), (Class<?>) IVipInfoUtils.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2);
        } else {
            INSTANCE = Companion.f312788a;
        }
    }

    short getHighestVipInfo(@NotNull VipTypeParam vipTypeParam);

    short getHighestVipInfo(@Nullable NTVasSimpleInfo friends);

    @NotNull
    f getHighestVipType(@NotNull VipTypeParam vipTypeParam);

    @NotNull
    f getHighestVipType(@Nullable NTVasSimpleInfo friends);

    @NotNull
    f getHighestVipTypeWithoutBig(@Nullable NTVasSimpleInfo friends);

    int getQQSettingVipHomeType(@NotNull String uin);

    @NotNull
    int[] getVipIconsArray(@Nullable String str);

    @Nullable
    String getVipIconsString(@Nullable List<Integer> ids);

    void setQQSettingVipHomeType(@NotNull String uin, int id5);
}
