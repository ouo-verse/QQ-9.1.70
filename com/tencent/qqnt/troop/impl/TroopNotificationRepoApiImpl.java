package com.tencent.qqnt.troop.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationOperateRepo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.notification.e;
import com.tencent.qqnt.notification.f;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import com.tencent.qqnt.troop.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016Jy\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142O\u0010\u001e\u001aK\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\u0016j\u0002`\u001dH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopNotificationRepoApiImpl;", "Lcom/tencent/qqnt/troop/ITroopNotificationRepoApi;", "", "getNotificationUnreadCount", "getNotificationUnhandledCount", "getNotificationUnreadUnhandledCount", "getNotificationUnreadExitCount", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqnt/troop/g;", "observer", "", "registerNotificationChangedObserver", "unregisterNotificationChangeObserver", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "", "seq", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsgType;", QQBrowserActivity.KEY_MSG_TYPE, "", "groupCode", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errCode", "errMsg", "Lcom/tencent/qqnt/troop/OperateNotificationCallback;", "callback", "operateNotification", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopNotificationRepoApiImpl implements ITroopNotificationRepoApi {
    static IPatchRedirector $redirector_;

    public TroopNotificationRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnhandledCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            return iTroopNotificationInnerService.getNotificationUnhandledCount();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            return iTroopNotificationInnerService.getNotificationUnreadCount();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnreadExitCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            return iTroopNotificationInnerService.getNotificationUnreadExitCount();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public int getNotificationUnreadUnhandledCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            return iTroopNotificationInnerService.getNotificationUnreadUnhandledCount();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public void operateNotification(@NotNull GroupNotifyOperateType operateType, long seq, @NotNull GroupNotifyMsgType msgType, @NotNull String groupCode, @NotNull final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Map emptyMap;
        Map emptyMap2;
        Map emptyMap3;
        Map emptyMap4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, operateType, Long.valueOf(seq), msgType, groupCode, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GroupNotifyMsg groupNotifyMsg = new GroupNotifyMsg();
        groupNotifyMsg.seq = seq;
        groupNotifyMsg.type = msgType;
        groupNotifyMsg.group.groupCode = Util.toLongOrDefault(groupCode, 0L);
        emptyMap = MapsKt__MapsKt.emptyMap();
        emptyMap2 = MapsKt__MapsKt.emptyMap();
        e eVar = new e(0, 0, emptyMap, emptyMap2);
        emptyMap3 = MapsKt__MapsKt.emptyMap();
        emptyMap4 = MapsKt__MapsKt.emptyMap();
        TroopNotificationOperateRepo.f300860a.p(operateType, 4, new f(0, groupNotifyMsg, eVar, new e(0, 0, emptyMap3, emptyMap4), true, null, false, false, null, 480, null), "", new Function4<Boolean, Integer, String, f, Unit>(callback) { // from class: com.tencent.qqnt.troop.impl.TroopNotificationRepoApiImpl$operateNotification$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function3<Boolean, Integer, String, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, f fVar) {
                invoke(bool.booleanValue(), num.intValue(), str, fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull f msg2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, msg2);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(msg2, "msg");
                this.$callback.invoke(Boolean.valueOf(z16), Integer.valueOf(i3), errMsg);
            }
        }, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public void registerNotificationChangedObserver(@Nullable LifecycleOwner lifecycleOwner, @NotNull g observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) lifecycleOwner, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            iTroopNotificationInnerService.registerNotificationChangedObserver(lifecycleOwner, observer);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopNotificationRepoApi
    public void unregisterNotificationChangeObserver(@Nullable g observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) observer);
            return;
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            iTroopNotificationInnerService.unregisterNotificationChangeObserver(observer);
        }
    }
}
