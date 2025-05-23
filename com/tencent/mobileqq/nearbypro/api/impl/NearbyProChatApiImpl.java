package com.tencent.mobileqq.nearbypro.api.impl;

import android.content.Context;
import android.content.Intent;
import ca2.ChatsListInteractiveEntryModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.nearbypro.aio.processor.NearByProTempProcessor;
import com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper;
import com.tencent.mobileqq.nearbypro.api.INearbyProChatApi;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.chats.event.NBPInteractivePushEvent;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JJ\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000228\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u0016H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/NearbyProChatApiImpl;", "Lcom/tencent/mobileqq/nearbypro/api/INearbyProChatApi;", "", "getNotificationTitle", "getNotificationContent", "", "tid", "", "reportJubao", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "openNearbyProAndAIO", "", "checkTidIsSelf", "Lca2/a;", "model", "", "unreadNum", "handleInteractiveMsg", "peerUid", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", PreloadTRTCPlayerParams.KEY_SIG, "cb", "getAioSign", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProChatApiImpl implements INearbyProChatApi {

    @NotNull
    public static final String NEARBY_INTERACTIVE_MSG_COUNT_CHANGED = "NEARBY_INTERACTIVE_MSG_COUNT_CHANGED";

    @NotNull
    private static final String TAG = "NearbyProChatApiImpl";

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    public boolean checkTidIsSelf(long tid) {
        if (s.a() == tid) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    public void getAioSign(@NotNull String peerUid, @NotNull Function2<? super byte[], ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        NearByProTempProcessor.f253128d.c(peerUid, cb5);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    @NotNull
    public String getNotificationContent() {
        Context context;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            context = peekAppRuntime.getApplicationContext();
        } else {
            context = null;
        }
        if (context == null) {
            return "";
        }
        String string = context.getString(R.string.f170422l0);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026pro_notification_content)");
        return string;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    @NotNull
    public String getNotificationTitle() {
        Context context;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            context = peekAppRuntime.getApplicationContext();
        } else {
            context = null;
        }
        if (context == null) {
            return "";
        }
        String string = context.getString(R.string.f170432l1);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026bypro_notification_title)");
        return string;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    public void handleInteractiveMsg(@Nullable ChatsListInteractiveEntryModel model, int unreadNum) {
        if (model != null) {
            SimpleEventBus.getInstance().dispatchEvent(new NBPInteractivePushEvent(model, unreadNum));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WidgetCacheConstellationData.NUM, unreadNum);
            BaseApplication context = BaseApplication.context;
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                l.e(context, NEARBY_INTERACTIVE_MSG_COUNT_CHANGED, jSONObject);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    public void openNearbyProAndAIO(@NotNull Context context, @NotNull Intent intent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("key_peerId");
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            j.c().d(TAG, "openNearbyProAIO peerUid is empty");
            return;
        }
        if (!intent.getBooleanExtra("key_nearby_pro_need_open_aio", false)) {
            return;
        }
        intent.putExtra("key_nearby_pro_need_open_aio", false);
        int intExtra = intent.getIntExtra("key_from", 21);
        Intent intent2 = new Intent();
        intent2.putExtra("key_peerId", stringExtra);
        intent2.putExtra("key_chat_type", 119);
        intent.putExtra("key_from", intExtra);
        intent2.putExtra("key_scheme", "nearby_pro_open_chat_aio");
        ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyMainFragment(context, intent2);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProChatApi
    public void reportJubao(long tid) {
        AIONetworkHelper.f253140a.n(tid);
    }
}
