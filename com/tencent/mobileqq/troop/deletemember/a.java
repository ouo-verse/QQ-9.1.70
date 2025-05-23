package com.tencent.mobileqq.troop.deletemember;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.selecttroopmember.ISelectTroopMemberStarter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopInfoRepo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/a;", "Landroidx/lifecycle/ViewModel;", "Landroid/os/Bundle;", "arguments", "", "O1", "", "", "", "L1", "<set-?>", "i", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "troopUin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "M1", "()I", "from", BdhLogUtil.LogTag.Tag_Conn, "Z", "getOnlyLoadLocalData", "()Z", "onlyLoadLocalData", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean onlyLoadLocalData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.deletemember.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28441);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopUin = "-1";
            this.from = -1;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:8|(1:10)(1:26)|(7:12|(1:14)(2:22|(1:24))|15|16|17|18|19)|25|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r2.put("group_id", 0L);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> L1() {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this.troopUin);
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentUin();
        } else {
            str = null;
        }
        if (troopInfoFromCache != null) {
            if (troopInfoFromCache.isTroopOwner(str)) {
                i3 = 1;
            } else if (troopInfoFromCache.isTroopAdmin(str)) {
                i3 = 2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("group_id", Long.valueOf(Long.parseLong(this.troopUin)));
            hashMap.put("group_uin_type", Integer.valueOf(i3));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.from));
            return hashMap;
        }
        i3 = 0;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("group_id", Long.valueOf(Long.parseLong(this.troopUin)));
        hashMap2.put("group_uin_type", Integer.valueOf(i3));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(this.from));
        return hashMap2;
    }

    public final int M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.from;
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final boolean O1(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) arguments)).booleanValue();
        }
        if (arguments == null) {
            return false;
        }
        String string = arguments.getString("troopUin", "");
        Intrinsics.checkNotNullExpressionValue(string, "args.getString(ISelectTr\u2026NTENT_PARAM_TROOPUIN, \"\")");
        this.troopUin = string;
        QLog.i("TroopDeleteMemberVM", 1, "[parseArguments] troopUin:" + string);
        if (TextUtils.isEmpty(this.troopUin)) {
            return false;
        }
        this.onlyLoadLocalData = arguments.getBoolean(ISelectTroopMemberStarter.INTENT_PARAM_ONLYLOADLOCALDATA, false);
        this.from = arguments.getInt("from", -1);
        return true;
    }
}
