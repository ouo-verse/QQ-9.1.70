package com.tencent.guild.aio.reserve2.busi.chosen.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.reserve2.busi.chosen.d;
import com.tencent.guild.aio.util.y;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/f;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/g;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/d$a;", "Landroid/content/Context;", "ctx", "", HippyTKDListViewAdapter.X, "context", "u", "Landroid/view/View;", "view", "data", "w", "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends g<d.ChosenParams> {
    public f() {
        super(R.string.f16492275);
    }

    private final void u(final Context context) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.closeChannelTopMsg(i().getIoaParams().f(), i().getIoaParams().j(), new cc() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.menu.e
                @Override // vh2.cc
                public final void onResult(int i3, String str) {
                    f.v(context, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Context context, int i3, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.i("HideChosenBarItem", 1, "close top msg, result = " + i3 + " errMsg = " + str);
        if (y.b(i3)) {
            com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.c());
            QQToast.makeText(context, 2, R.string.f157961ob, 0).show();
        } else {
            QQToast.makeText(context, R.string.f157951oa, 0).show();
        }
    }

    private final void x(final Context ctx) {
        String string = ctx.getString(R.string.f157931o9);
        Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(com.tencen\u2026.guild_top_msg_hide_tips)");
        final QQCustomDialog d16 = com.tencent.mobileqq.guild.util.qqui.c.d(ctx, 0, null, string, null, null);
        Intrinsics.checkNotNullExpressionValue(d16, "createCustomDialog(\n    \u2026           null\n        )");
        d16.setNegativeButton(ctx.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.menu.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.y(QQCustomDialog.this, dialogInterface, i3);
            }
        });
        d16.setPositiveButton(ctx.getString(R.string.f157921o8), new DialogInterface.OnClickListener() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.menu.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.z(f.this, ctx, d16, dialogInterface, i3);
            }
        });
        d16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(QQCustomDialog topMsgDlg, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(topMsgDlg, "$topMsgDlg");
        topMsgDlg.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(f this$0, Context ctx, QQCustomDialog topMsgDlg, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        Intrinsics.checkNotNullParameter(topMsgDlg, "$topMsgDlg");
        this$0.u(ctx);
        topMsgDlg.dismiss();
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull View view, @NotNull d.ChosenParams data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        QLog.i("HideChosenBarItem", 1, "onItemClick data=" + data);
        x(j().getHostContext());
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_aio");
        hashMap.put("sgrp_channel_id", data.getIoaParams().f());
        hashMap.put("sgrp_sub_channel_id", data.getIoaParams().j());
        hashMap.put("eid", "em_aio_hide_top_sticky");
        VideoReport.reportEvent("dt_clck", hashMap);
    }
}
