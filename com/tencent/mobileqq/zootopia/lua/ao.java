package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ao;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleEnterAvatarPortal", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "e", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ao extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328504a;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.Dynamic.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.PortalActivity.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f328504a = iArr;
        }
    }

    public ao(Activity activity, ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.source = zootopiaSource;
    }

    @LuaEvent("L2N_EnterAvatarPortal")
    public final String handleEnterAvatarPortal(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaShareArkPlugin", 2, "handleEnterAvatarPortal, params:" + argument.getParams());
        }
        ZootopiaSource zootopiaSource = this.source;
        Source mainSource = zootopiaSource != null ? zootopiaSource.getMainSource() : null;
        int i3 = mainSource == null ? -1 : b.f328504a[mainSource.ordinal()];
        if (i3 == 1) {
            Intent intent = new Intent("action_enter_avatar_portal");
            intent.putExtra("isRoleTabSelect", true);
            this.activity.sendBroadcast(intent);
            this.activity.finish();
        } else if (i3 != 2) {
            QRouteApi api = QRoute.api(IEntryApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IEntryApi::class.java)");
            IEntryApi.a.d((IEntryApi) api, this.activity, ZootopiaSource.INSTANCE.c(Source.ZootopiaUEActivity, "0", this.source), null, 4, null);
            this.activity.finish();
        } else {
            IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
            Activity activity = this.activity;
            ZootopiaSource c16 = ZootopiaSource.INSTANCE.c(Source.ZootopiaUEActivity, "0", this.source);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRoleTabSelect", true);
            Unit unit = Unit.INSTANCE;
            iEntryApi.startPortalActivity(activity, c16, bundle);
        }
        return argument.ok();
    }
}
