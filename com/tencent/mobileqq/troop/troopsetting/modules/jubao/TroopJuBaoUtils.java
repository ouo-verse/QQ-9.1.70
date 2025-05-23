package com.tencent.mobileqq.troop.troopsetting.modules.jubao;

import androidx.core.os.BundleKt;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.api.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/jubao/TroopJuBaoUtils;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "enterSource", "", "troopUin", "", "isTroopMember", "", "d", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "c", "f", "source", "g", "str", "e", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJuBaoUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopJuBaoUtils f301175a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301175a = new TroopJuBaoUtils();
        }
    }

    TroopJuBaoUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void c(@NotNull QBaseActivity activity, int enterSource, @Nullable TroopInfoData troopInfoData) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        if (troopInfoData != null) {
            z16 = troopInfoData.isMember;
        } else {
            z16 = false;
        }
        d(activity, enterSource, str, z16);
    }

    @JvmStatic
    public static final void d(@NotNull final QBaseActivity activity, int enterSource, @Nullable final String troopUin, final boolean isTroopMember) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (troopUin == null) {
            QLog.e("TroopJuBaoUtils", 1, "invalid troopInfoData is null.");
        } else {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getReportMsgIfNull("", troopUin, troopUin, f301175a.g(enterSource, isTroopMember), BundleKt.bundleOf(TuplesKt.to("chatuin", troopUin), TuplesKt.to("chattype", 1)), new Function1<String, Unit>(isTroopMember, troopUin) { // from class: com.tencent.mobileqq.troop.troopsetting.modules.jubao.TroopJuBaoUtils$doReportInTroopSetting$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isTroopMember;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$isTroopMember = isTroopMember;
                    this.$troopUin = troopUin;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QBaseActivity.this, Boolean.valueOf(isTroopMember), troopUin);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    String f16;
                    String e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                        return;
                    }
                    b bVar = new b();
                    boolean z16 = this.$isTroopMember;
                    String str2 = this.$troopUin;
                    TroopJuBaoUtils troopJuBaoUtils = TroopJuBaoUtils.f301175a;
                    f16 = troopJuBaoUtils.f(z16);
                    bVar.i(f16);
                    bVar.n(str2);
                    bVar.o(4);
                    bVar.r(str2);
                    bVar.q(str2);
                    bVar.j("0");
                    bVar.s(0);
                    bVar.m("anonymousseq=0");
                    bVar.l(str2);
                    bVar.k("1");
                    e16 = troopJuBaoUtils.e("REPORT_IP=0&EVIL_IP=0");
                    bVar.x(e16);
                    bVar.v(str);
                    ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(QBaseActivity.this, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(str, \"UTF-8\")");
            return encode;
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopJuBaoUtils", 2, "encodeStr [" + str + "]", e16);
            }
            return "";
        } catch (Throwable th5) {
            QLog.i("TroopJuBaoUtils", 1, "encodeStr [" + str + "]", th5);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(boolean isTroopMember) {
        if (isTroopMember) {
            return "10089";
        }
        return "10092";
    }

    private final int g(int source, boolean isTroopMember) {
        if (source == 1002) {
            return 20014;
        }
        if (isTroopMember) {
            return IWeiyunResponseHandler.ERROR_DISK_SERVER_CODE_FLOW_LIMIT_VIP;
        }
        return 22003;
    }
}
