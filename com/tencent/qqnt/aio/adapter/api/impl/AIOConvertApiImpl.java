package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOConvertApi;
import com.tencent.qqnt.aio.adapter.api.UnsupportedChatTypeException;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.robot.api.IRobotPersonalInfoService;
import com.tencent.util.NumberUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOConvertApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOConvertApi;", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "fillStoryBaseInfo", "", "getStartActivityTime", "", "handleAIOIntent", "<init>", "()V", "Companion", "a", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOConvertApiImpl implements IAIOConvertApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "AIOConvertApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOConvertApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOConvertApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOConvertApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bundle fillStoryBaseInfo(Intent intent) {
        int intExtra = intent.getIntExtra("key_chat_type", 0);
        if (intExtra != 1) {
            return new Bundle();
        }
        String stringExtra = intent.getStringExtra("key_peerId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        long longExtra = intent.getLongExtra("key_peerUin", 0L);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new Bundle();
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        return ((IRobotPersonalInfoService) runtimeService).fillStoryBaseInfo(stringExtra, String.valueOf(longExtra), intExtra);
    }

    private final long getStartActivityTime(Intent intent) {
        return intent.getLongExtra(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME, 0L);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConvertApi
    public void handleAIOIntent(@NotNull Intent intent) throws UnsupportedChatTypeException {
        String wrapLogUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("uin");
        if (!TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("uinname");
            int intExtra = intent.getIntExtra("uintype", 0);
            int l3 = com.tencent.nt.adapter.session.c.l(intExtra);
            long longExtra = intent.getLongExtra("key_groupUin", 0L);
            String stringExtra3 = intent.getStringExtra(AppConstants.Key.TROOP_CODE);
            if (QLog.isColorLevel()) {
                wrapLogUin = stringExtra;
            } else {
                wrapLogUin = LogUtil.wrapLogUin(stringExtra);
            }
            QLog.d(TAG, 1, "handleAIOIntent uin:" + com.tencent.qqnt.aio.utils.b.c(wrapLogUin) + " uType:" + intExtra + " cType:" + l3 + " grpUin:" + com.tencent.qqnt.aio.utils.b.b(Long.valueOf(longExtra)) + " trpUin:" + com.tencent.qqnt.aio.utils.b.c(stringExtra3));
            if (l3 != 0) {
                if (com.tencent.nt.adapter.session.h.f339139a.a(intExtra)) {
                    try {
                        Long valueOf = Long.valueOf(stringExtra);
                        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(uin)");
                        intent.putExtra("key_peerUin", valueOf.longValue());
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "handleIntent " + e16);
                    }
                } else if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_uintype_convert_switch_9080", true)) {
                    if (TextUtils.isEmpty(intent.getStringExtra("key_peerId"))) {
                        intent.putExtra("key_peerId", stringExtra);
                    }
                } else {
                    intent.putExtra("key_peerId", stringExtra);
                }
                if (l3 == 100 && longExtra == 0) {
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        intent.putExtra("key_groupUin", NumberUtil.stringToLong(stringExtra3, 0L));
                    } else {
                        QLog.w(TAG, 1, "troop uin is empty for group temp c2c chat, nick=" + stringExtra2);
                    }
                }
                if (8 == l3) {
                    if (AppConstants.DATALINE_PC_UIN.equals(stringExtra)) {
                        intent.putExtra("key_peerUin", 0);
                        intent.putExtra("key_peerId", PeerUid.DATALINE_PC_UID);
                    } else if (AppConstants.DATALINE_IPAD_UIN.equals(stringExtra)) {
                        intent.putExtra("key_peerUin", 0);
                        intent.putExtra("key_peerId", PeerUid.DATALINE_PAD_UID);
                    } else if (AppConstants.DATALINE_PHONE_UIN.equals(stringExtra)) {
                        intent.putExtra("key_peerUin", 0);
                        intent.putExtra("key_peerId", PeerUid.DATALINE_PHONE_UID);
                    } else {
                        QLog.d(TAG, 1, "normal into myComputer");
                    }
                }
                intent.putExtra("key_chat_type", l3);
                intent.putExtra("key_chat_name", stringExtra2);
                intent.putExtra(AppOpenConstants.Key.THIRD_PUSH_MSG_SEQ, intent.getLongExtra(AppOpenConstants.Key.THIRD_PUSH_MSG_SEQ, 0L));
                intent.putExtra(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME, getStartActivityTime(intent));
            } else {
                throw new UnsupportedChatTypeException("Not supported uinType " + intExtra + ".");
            }
        }
        intent.putExtras(fillStoryBaseInfo(intent));
    }
}
