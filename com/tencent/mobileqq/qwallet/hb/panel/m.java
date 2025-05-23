package com.tencent.mobileqq.qwallet.hb.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qwallet.hb.aio.impl.c;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tenpay.view.WalletProgressDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J=\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ8\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007J\u0016\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016J;\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0012\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001R\u0017\u0010)\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/m;", "", "Lcom/tencent/mobileqq/qwallet/hb/aio/impl/c$d;", "sessionInfo", "Landroid/content/Context;", "context", "", "hbType", "skinId", "", "singleTop", "", "d", "(Lcom/tencent/mobileqq/qwallet/hb/aio/impl/c$d;Landroid/content/Context;ILjava/lang/Integer;Z)V", "", "actionName", "r2", "r3", "r4", "r5", "g", "Lcom/tencent/mobileqq/activity/aio/p;", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$a;", "ls", "b", "f", "(Lcom/tencent/mobileqq/activity/aio/p;Landroid/content/Context;ILjava/lang/Integer;Z)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "sendHbSessionParam", "Landroid/os/Bundle;", "args", "e", "Landroid/app/Dialog;", "i", "isGuild", "chatPieProxy", "Lcom/tencent/mobileqq/qwallet/a;", "c", "I", "a", "()I", "defaultTheme", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class m {

    /* renamed from: a */
    @NotNull
    public static final m f277567a = new m();

    /* renamed from: b, reason: from kotlin metadata */
    private static final int defaultTheme = R.style.a7e;

    m() {
    }

    private final void d(c.d sessionInfo, Context context, int hbType, Integer skinId, boolean singleTop) {
        if (context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (skinId != null) {
            bundle.putInt("skin_id", skinId.intValue());
        }
        bundle.putBoolean(com.tencent.mobileqq.qwallet.hb.aio.impl.c.f277244b, singleTop);
        e(context, sessionInfo, hbType, bundle);
    }

    @JvmStatic
    public static final void g(@NotNull String actionName, @NotNull Object r26, @NotNull Object r36, @NotNull Object r46, @NotNull Object r56) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        com.tencent.mobileqq.qwallet.c.e(actionName, r26.toString(), r36.toString(), r46.toString(), r56.toString());
    }

    public static /* synthetic */ void h(String str, Object obj, Object obj2, Object obj3, Object obj4, int i3, Object obj5) {
        if ((i3 & 2) != 0) {
            obj = "";
        }
        if ((i3 & 4) != 0) {
            obj2 = "";
        }
        if ((i3 & 8) != 0) {
            obj3 = "";
        }
        if ((i3 & 16) != 0) {
            obj4 = "";
        }
        g(str, obj, obj2, obj3, obj4);
    }

    public final int a() {
        return defaultTheme;
    }

    public final void b(@NotNull p sessionInfo, @NotNull RedPacketManager.a ls5) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(ls5, "ls");
        RedPacketManager.f277534a.m(sessionInfo, ls5);
    }

    @NotNull
    public final com.tencent.mobileqq.qwallet.a c(boolean isGuild, @Nullable Object chatPieProxy) {
        return e.INSTANCE.a(isGuild, chatPieProxy);
    }

    public final void e(@Nullable Context r102, @Nullable c.d sendHbSessionParam, int hbType, @Nullable Bundle args) {
        PanelEntryData panelEntryData;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && r102 != null && sendHbSessionParam != null) {
            ArrayList<PanelEntryData> h16 = RedPacketManager.h(Integer.valueOf(sendHbSessionParam.f277252a));
            if (h16.isEmpty()) {
                return;
            }
            int size = h16.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    PanelEntryData panelEntryData2 = h16.get(i3);
                    Intrinsics.checkNotNullExpressionValue(panelEntryData2, "panelList[i]");
                    PanelEntryData panelEntryData3 = panelEntryData2;
                    if (panelEntryData3.getType() == hbType) {
                        panelEntryData = panelEntryData3;
                        break;
                    }
                    i3++;
                } else {
                    panelEntryData = null;
                    break;
                }
            }
            if (panelEntryData == null) {
                return;
            }
            com.tencent.mobileqq.qwallet.hb.aio.impl.c.f().n(peekAppRuntime, r102, sendHbSessionParam, panelEntryData, h16, -1, args);
        }
    }

    public final void f(@Nullable p sessionInfo, @Nullable Context context, int hbType, @Nullable Integer skinId, boolean singleTop) {
        c.d dVar;
        if (sessionInfo != null) {
            dVar = com.tencent.mobileqq.qwallet.hb.aio.impl.c.i(sessionInfo.f179555d, sessionInfo.f179557e, sessionInfo.f179559f);
        } else {
            dVar = null;
        }
        d(dVar, context, hbType, skinId, singleTop);
    }

    @Nullable
    public final Dialog i(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        WalletProgressDialog walletProgressDialog = new WalletProgressDialog(context);
        walletProgressDialog.setHeight(0);
        walletProgressDialog.setCancelable(false);
        walletProgressDialog.show();
        return walletProgressDialog;
    }
}
