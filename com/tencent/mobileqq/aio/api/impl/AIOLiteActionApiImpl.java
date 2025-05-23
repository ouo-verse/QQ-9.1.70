package com.tencent.mobileqq.aio.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.aio.api.IAIOLiteActionApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.nt.adapter.session.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import common.config.service.QzoneConfig;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/api/impl/AIOLiteActionApiImpl;", "Lcom/tencent/mobileqq/aio/api/IAIOLiteActionApi;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "curType", "", "curUin", "", "startShareLocation", "Landroid/app/Activity;", "uin", "showC2CGiftPanel", "isC2C", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "getSessionInfo", "enterLocationSharePage", "enterRedPacketPage", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "showGiftPanel", "startVideoCall", "mAIOContext", "Lcom/tencent/aio/api/runtime/a;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AIOLiteActionApiImpl implements IAIOLiteActionApi {
    private static final String TAG = "AIOLiteActionApiImpl";
    private a mAIOContext;

    private final SessionInfo getSessionInfo() {
        a aVar = this.mAIOContext;
        if (aVar == null) {
            return null;
        }
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(aVar.g().r().c().j());
        if (uinFromUid == null || uinFromUid.length() == 0) {
            QLog.e(TAG, 1, "getSessionInfo require uin exception");
            return null;
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = uinFromUid;
        sessionInfo.f179559f = uinFromUid;
        sessionInfo.f179555d = c.c(aVar.g().r().c().e());
        sessionInfo.f179563i = aVar.g().r().c().g();
        return sessionInfo;
    }

    private final boolean isC2C() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        a aVar = this.mAIOContext;
        return (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || c16.e() != 1) ? false : true;
    }

    private final boolean startShareLocation(QQAppInterface app, FragmentActivity activity, int curType, String curUin) {
        e.b(app).launchShareUi(activity, curType, curUin, 1);
        return true;
    }

    @Override // com.tencent.mobileqq.aio.api.IAIOLiteActionApi
    public boolean enterLocationSharePage() {
        a aVar = this.mAIOContext;
        if (aVar == null) {
            return false;
        }
        isC2C();
        String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(aVar.g().r().c().j());
        if (uin == null || uin.length() == 0) {
            QLog.e(TAG, 1, "AIOLiteActionApiImpl require uin exception");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        FragmentActivity activity = aVar.c().getActivity();
        if (qQAppInterface == null || activity == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        return startShareLocation(qQAppInterface, activity, 0, uin);
    }

    @Override // com.tencent.mobileqq.aio.api.IAIOLiteActionApi
    public boolean enterRedPacketPage() {
        FragmentActivity activity;
        a aVar = this.mAIOContext;
        if (aVar == null || (activity = aVar.c().getActivity()) == null) {
            return false;
        }
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).goToSendHbActivity(activity, aVar.g().r().c().e(), aVar.g().r().c().j());
        return true;
    }

    @Override // com.tencent.mobileqq.aio.api.IAIOLiteActionApi
    public void onCreate(a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.mAIOContext = aioContext;
    }

    @Override // com.tencent.mobileqq.aio.api.IAIOLiteActionApi
    public boolean showGiftPanel() {
        a aVar;
        if (!isC2C() || (aVar = this.mAIOContext) == null) {
            return false;
        }
        String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(aVar.g().r().c().j());
        FragmentActivity activity = aVar.c().getActivity();
        if ((uin == null || uin.length() == 0) || activity == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        return showC2CGiftPanel(activity, uin);
    }

    @Override // com.tencent.mobileqq.aio.api.IAIOLiteActionApi
    public boolean startVideoCall() {
        Fragment c16;
        if (!isC2C()) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        FragmentActivity fragmentActivity = null;
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        a aVar = this.mAIOContext;
        if (aVar != null && (c16 = aVar.c()) != null) {
            fragmentActivity = c16.getActivity();
        }
        FragmentActivity fragmentActivity2 = fragmentActivity;
        if (qQAppInterface == null || fragmentActivity2 == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("should_believe_only_audio_flag", "true");
        SessionInfo sessionInfo = getSessionInfo();
        if (sessionInfo == null) {
            return false;
        }
        PlusPanelUtils.h(qQAppInterface, fragmentActivity2, sessionInfo, false, null, linkedHashMap);
        return true;
    }

    @Override // com.tencent.mobileqq.aio.api.IAIOLiteActionApi
    public void onDestroy() {
        this.mAIOContext = null;
    }

    private final boolean showC2CGiftPanel(Activity activity, String uin) {
        String url;
        String url2;
        try {
            String url3 = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_C2C_PLUS_GIFT_JUMP_URL, QzoneConfig.DefaultValue.DEFAULT_C2C_PLUS_AIO_GIFT_JUMP_URL);
            int i3 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()) ? 1 : 0;
            Intrinsics.checkNotNullExpressionValue(url3, "url");
            url = StringsKt__StringsJVMKt.replace$default(url3, "{uin}", uin, false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            url2 = StringsKt__StringsJVMKt.replace$default(url, "{themeMode}", sb5.toString(), false, 4, (Object) null);
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
                bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNullExpressionValue(url2, "url");
                iVasHybridRoute.openTranslucentBrowser(activity, url2, null, bundle);
            } else {
                Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
                intent.putExtra("url", url2);
                intent.setData(Uri.parse(url2));
                intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                activity.startActivity(intent);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16, new Object[0]);
            }
            return false;
        }
    }
}
