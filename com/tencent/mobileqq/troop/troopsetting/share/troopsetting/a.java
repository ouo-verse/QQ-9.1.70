package com.tencent.mobileqq.troop.troopsetting.share.troopsetting;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/a;", "Lcom/tencent/mobileqq/troop/troopsetting/share/a;", "", "", "d", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", "a", "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class a extends com.tencent.mobileqq.troop.troopsetting.share.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/a$a;", "", "", "COPY_LINK_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QBaseActivity b16 = shareContext.b();
        TroopInfoData h16 = shareContext.h();
        if (com.tencent.mobileqq.troop.trooptodo.a.b("CopyLinkAction", 2000L)) {
            TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
            String string = b16.getString(R.string.zox);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026opy_trooplink_frequently)");
            companion.b(b16, 0, string);
            return;
        }
        String str2 = h16.troopName;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = h16.troopUin;
        } else {
            str = h16.troopName;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = b16.getString(R.string.f171050c02);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.join_my_troop)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{str, f(shareContext)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        Object systemService = b16.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("troop_url", format));
        TroopSettingShareManager.Companion companion2 = TroopSettingShareManager.INSTANCE;
        String string3 = b16.getString(R.string.aew);
        Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str\u2026g.copy_trooplink_success)");
        companion2.b(b16, 2, string3);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Nullable
    public String f(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) shareContext);
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
        if (f16 != null) {
            return f16.f301556d;
        }
        return null;
    }
}
