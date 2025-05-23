package com.tencent.mobileqq.matchfriend.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0012\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J,\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J,\u0010)\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00152\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020\bH\u0016\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/impl/MatchFriendNTChatApiImpl;", "Lcom/tencent/mobileqq/matchfriend/api/IMatchFriendNTChatApi;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgIds", "", "deleteIcebreakerTopicArk", "Lcom/tencent/mobileqq/matchfriend/voicechat/RoomInfo;", "roomInfo", "", "shouldEnterVoiceChatPage", "", "remindTipText", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "showGreetForbiddenDialog", "isPass", "remindText", "", "hitType", "handleGetCanGreet", "checkEnterVoiceChatPage", "params", "tinyId", "msgId", "handleSendIcebreakerTopicMessage", "saveBreakTopicArkMsgRecord", "getBreakTopicArkMsgRecord", "Lcom/tencent/common/app/AppInterface;", "app", "getIceBreakTopicMsgId", "getHaseMatchFriendMiniCardArk", "", "source", WadlProxyConsts.FLAGS, "emosize", "", "message", "getMatchFriendNTQQText", "getAssistedChatCacheExpiredTime", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MatchFriendNTChatApiImpl implements IMatchFriendNTChatApi {
    private static final int ARK_TIPS_PRIORITY = 1;
    private static final int GREET_DIALOG_PRIORITY = 0;
    private static final int GREET_TOAST_PRIORITY = 2;
    private static final String TAG = "MatchFriendNTChatApiImpl";

    private final void deleteIcebreakerTopicArk(Contact peer, ArrayList<Long> msgIds) {
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService()) == null) {
            return;
        }
        msgService.deleteMsg(peer, msgIds, new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.api.impl.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                MatchFriendNTChatApiImpl.deleteIcebreakerTopicArk$lambda$4(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGetCanGreet$lambda$1$lambda$0(String str, Activity it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        if (str == null || str.length() == 0) {
            str = it.getString(R.string.x1z);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (remindText.isNullOrE\u2026        } else remindText");
        com.tencent.biz.qui.toast.b.j(it, str).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGetCanGreet$lambda$3$lambda$2(MatchFriendNTChatApiImpl this$0, String str, Activity it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.showGreetForbiddenDialog(str, it);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public void checkEnterVoiceChatPage(Activity activity, RoomInfo roomInfo) {
        if (shouldEnterVoiceChatPage(roomInfo)) {
            ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).enterVoiceMatchOnlinePage(activity, roomInfo);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public int getAssistedChatCacheExpiredTime() {
        return com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.b().getAssistedChatCacheExpiredTime();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public long getBreakTopicArkMsgRecord() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public boolean getHaseMatchFriendMiniCardArk(long tinyId) {
        return com.tencent.mobileqq.matchfriend.utils.b.d().g(String.valueOf(tinyId));
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public long getIceBreakTopicMsgId(AppInterface app, long tinyId) {
        Intrinsics.checkNotNullParameter(app, "app");
        return com.tencent.mobileqq.matchfriend.utils.b.d().c(String.valueOf(tinyId));
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public CharSequence getMatchFriendNTQQText(CharSequence source, int flags, int emosize, Object message) {
        return new com.tencent.mobileqq.matchfriend.nt.b(source, flags, emosize, message);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public void handleSendIcebreakerTopicMessage(String params, String tinyId, long msgId) {
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("toTinyId");
            String optString2 = jSONObject.optString("topic");
            if (TextUtils.isEmpty(tinyId) || !Intrinsics.areEqual(tinyId, optString)) {
                return;
            }
            com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar.i(fVar.c(1046, tinyId, ""), optString2);
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(msgId));
            deleteIcebreakerTopicArk(new Contact(104, tinyId, ""), arrayList);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "handleSendIcebreakerTopicMessage" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGreetForbiddenDialog$lambda$5(Activity activity, DialogInterface dialogInterface, int i3) {
        activity.setResult(-1);
        activity.finish();
    }

    private final boolean shouldEnterVoiceChatPage(RoomInfo roomInfo) {
        return roomInfo != null && roomInfo.a();
    }

    private final void showGreetForbiddenDialog(String remindTipText, final Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(remindTipText)) {
            remindTipText = HardCodeUtil.qqStr(R.string.f201024tp);
        }
        dh2.a aVar = new dh2.a(activity);
        aVar.setMessage(remindTipText).setNegativeButton(HardCodeUtil.qqStr(R.string.f1380608j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.api.impl.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MatchFriendNTChatApiImpl.showGreetForbiddenDialog$lambda$5(activity, dialogInterface, i3);
            }
        });
        aVar.show();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public void handleGetCanGreet(boolean isPass, final String remindText, int hitType, final Activity activity) {
        if (isPass) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleGetCanGreet isPass");
            }
        } else if (hitType == 0) {
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.api.impl.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        MatchFriendNTChatApiImpl.handleGetCanGreet$lambda$3$lambda$2(MatchFriendNTChatApiImpl.this, remindText, activity);
                    }
                });
            }
        } else if (hitType == 1 && activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    MatchFriendNTChatApiImpl.handleGetCanGreet$lambda$1$lambda$0(remindText, activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteIcebreakerTopicArk$lambda$4(int i3, String str) {
        if (i3 == 0) {
            return;
        }
        QLog.e(TAG, 1, "deleteIcebreakerTopicArk is error! error msg is " + str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public void onDestroy() {
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi
    public void saveBreakTopicArkMsgRecord(long msgId) {
    }
}
