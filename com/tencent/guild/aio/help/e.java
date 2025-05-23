package com.tencent.guild.aio.help;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/help/e;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "()V", "e", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    private final HashMap<String, Object> a(IGProChannelInfo channelInfo) {
        Bundle bundle;
        Parcelable parcelable;
        Intent intent;
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        } else {
            bundle = null;
        }
        if (bundle != null) {
            parcelable = bundle.getParcelable("GuildAppReportSourceInfo");
        } else {
            parcelable = null;
        }
        if (!(parcelable instanceof GuildAppReportSourceInfo)) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                aVar3 = null;
            }
            parcelable = aVar3.g().l().getParcelable("GuildAppReportSourceInfo");
        }
        if (parcelable instanceof GuildAppReportSourceInfo) {
            hashMap.putAll(((GuildAppReportSourceInfo) parcelable).getReportInfoMap());
        }
        com.tencent.aio.api.runtime.a aVar4 = this.mAioContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar4 = null;
        }
        AIOParam g16 = aVar4.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAioContext.aioParam");
        hashMap.put("sgrp_channel_id", com.tencent.guild.aio.util.a.g(g16));
        com.tencent.aio.api.runtime.a aVar5 = this.mAioContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar5 = null;
        }
        AIOParam g17 = aVar5.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mAioContext.aioParam");
        hashMap.put("sgrp_sub_channel_id", com.tencent.guild.aio.util.a.b(g17));
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        hashMap.put("sgrp_sub_channel_name", channelName);
        com.tencent.aio.api.runtime.a aVar6 = this.mAioContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        } else {
            aVar2 = aVar6;
        }
        AIOParam g18 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g18, "mAioContext.aioParam");
        hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(com.tencent.guild.aio.util.a.g(g18))));
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(channelInfo.getType()));
        hashMap.put("sgrp_sub_channel_limit", String.valueOf(channelInfo.getTalkPermission()));
        hashMap.put("sgrp_login_flag", 1);
        hashMap.put("sgrp_duration_flag", 1);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        return hashMap;
    }

    private final void b() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo iGProChannelInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.aio.api.runtime.a aVar = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                aVar2 = null;
            }
            AIOParam g16 = aVar2.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mAioContext.aioParam");
            iGProChannelInfo = iGPSService.getChannelInfo(com.tencent.guild.aio.util.a.b(g16));
        } else {
            iGProChannelInfo = null;
        }
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 1) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                aVar3 = null;
            }
            View view = aVar3.c().getView();
            com.tencent.aio.api.runtime.a aVar4 = this.mAioContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            } else {
                aVar = aVar4;
            }
            VideoReport.addToDetectionWhitelist(aVar.c().getActivity());
            VideoReport.resetPageParams(view);
            VideoReport.setPageId(view, "pg_sgrp_aio");
            VideoReport.setPageParams(view, new PageParams(a(iGProChannelInfo)));
            VideoReport.setPageContentId(view, String.valueOf(SystemClock.elapsedRealtime()), true);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 21;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildAIODTReportHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3, 8};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAioContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            b();
        }
    }
}
