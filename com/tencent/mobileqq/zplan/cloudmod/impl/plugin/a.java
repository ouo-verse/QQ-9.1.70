package com.tencent.mobileqq.zplan.cloudmod.impl.plugin;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.cloudmod.impl.cloudgame.data.CloudModEvent;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.plugins.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ux4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/impl/plugin/a;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleGotoLink", "handleSceneActive", "Landroidx/fragment/app/FragmentActivity;", "d", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity activity;

    public a(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    @LuaEvent("L2N_GotoLink")
    public final String handleGotoLink(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (TextUtils.isEmpty(argument.getParams())) {
            QLog.e("CloudModPlugin_", 1, "L2N_GotoLink params empty");
            return argument.fail();
        }
        String link = new JSONObject(argument.getParams()).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        if (TextUtils.isEmpty(link)) {
            QLog.e(h.INSTANCE.a(), 1, "L2N_GotoLink link empty");
            return argument.fail();
        }
        QLog.i(h.INSTANCE.a(), 1, "L2N_GotoLink " + link);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(link, "link");
        iSchemeApi.launchScheme(context, link);
        return argument.ok();
    }

    @LuaEvent("L2N_SceneActive")
    public final String handleSceneActive(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("CloudModPlugin_", 1, "L2N_SceneActive injected");
        if (b.f440566e.f()) {
            SimpleEventBus.getInstance().dispatchEvent(new CloudModEvent(2));
        }
        return argument.ok();
    }
}
