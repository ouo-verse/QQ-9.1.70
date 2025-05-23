package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.app.Activity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qwallet.hb.aio.IWalletHbItemV2Api;
import com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.QWalletPreGrabControllerV2;
import com.tencent.mobileqq.qwallet.utils.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.view.WalletProgressDialog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vk2.QWalletHbModel;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J*\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\"\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u0004\u0018\u00010+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aio/impl/WalletHbItemV2ApiImpl;", "Lcom/tencent/mobileqq/qwallet/hb/aio/IWalletHbItemV2Api;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "authKey", "groupId", "Lvk2/d;", "qqWalletMsg", "Lvk2/e;", "sessionInfo", "", "doWalletAction", "Lvk2/c;", "hbModel", "Lvk2/b;", "elem", "", "doReport", "subAction", "actionName", "r2", "r3", "report", "getGroupId", "nativeAndroid", "getRedId", "urlParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parseUrlParams", "showQQPayLoading", "dismissQQPayLoading", "msgModel", "handleOnClick", "Lcom/tenpay/view/WalletProgressDialog;", "mQQPayLoading", "Lcom/tenpay/view/WalletProgressDialog;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c2cCurTypes", "Ljava/util/ArrayList;", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "appRuntime", "<init>", "()V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class WalletHbItemV2ApiImpl implements IWalletHbItemV2Api {

    @NotNull
    private static final String AIO_TYPE_DEFAULT = "1";

    @NotNull
    private static final String AIO_TYPE_GUILD = "2";

    @NotNull
    private static final String TAG = "QQWalletHbItemApi";

    @NotNull
    private final ArrayList<Integer> c2cCurTypes;

    @Nullable
    private WalletProgressDialog mQQPayLoading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/hb/aio/impl/WalletHbItemV2ApiImpl$b", "Lcom/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/a;", "", "b", "", "retCode", "", "retMsg", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f277236b;

        b(Activity activity) {
            this.f277236b = activity;
        }

        @Override // com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.a
        public void a(int retCode, @Nullable String retMsg) {
            boolean z16;
            WalletHbItemV2ApiImpl.this.dismissQQPayLoading(this.f277236b);
            if (retCode != 0) {
                if (retMsg != null && retMsg.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    retMsg = this.f277236b.getResources().getString(R.string.f17938398, Integer.valueOf(retCode));
                }
                Intrinsics.checkNotNullExpressionValue(retMsg, "if (retMsg.isNullOrEmpty\u2026ail, retCode) else retMsg");
                ToastUtil.a().f(retMsg, 1);
            }
        }

        @Override // com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.a
        public void b() {
            WalletHbItemV2ApiImpl.this.showQQPayLoading(this.f277236b);
        }
    }

    public WalletHbItemV2ApiImpl() {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 1000, 1004, 1001, 10002, 10004, 1008);
        this.c2cCurTypes = arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissQQPayLoading(Activity activity) {
        WalletProgressDialog walletProgressDialog = this.mQQPayLoading;
        if (walletProgressDialog != null && walletProgressDialog.isShowing() && !activity.isFinishing()) {
            walletProgressDialog.dismiss();
            this.mQQPayLoading = null;
        }
    }

    private final void doReport(QWalletHbModel hbModel, QWalletSessionInfo sessionInfo, vk2.b elem) {
        String str;
        report$default(this, "transferaccountmsg", "show", String.valueOf(hbModel.getTemplateId()), null, 8, null);
        if (elem.f441784v > 0) {
            if (sessionInfo.getCurType() == 10014) {
                str = "2";
            } else {
                str = "1";
            }
            report(QCircleDaTongConstant.ElementParamValue.WALLET, "wrap.aio.click", String.valueOf(elem.f441784v), str);
        }
    }

    private final boolean doWalletAction(Activity activity, String authKey, String groupId, QWalletMsgModel qqWalletMsg, QWalletSessionInfo sessionInfo) {
        vk2.b elem = qqWalletMsg.getHbModel().getElem();
        String redId = getRedId(elem.f441775m);
        if (redId == null) {
            return false;
        }
        QWalletPreGrabControllerV2 qWalletPreGrabControllerV2 = new QWalletPreGrabControllerV2(new b(activity));
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            return false;
        }
        qWalletPreGrabControllerV2.n(appRuntime, activity, sessionInfo, qqWalletMsg, redId, authKey, groupId, elem.C);
        return true;
    }

    private final AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final String getGroupId(QWalletMsgModel qqWalletMsg, QWalletSessionInfo sessionInfo) {
        String str;
        boolean contains = this.c2cCurTypes.contains(Integer.valueOf(sessionInfo.getCurType()));
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null) {
            str = appRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (!contains || Intrinsics.areEqual(qqWalletMsg.getSenderUin(), str)) {
            return sessionInfo.getCurFriendUin();
        }
        return str;
    }

    private final String getRedId(String nativeAndroid) {
        boolean z16;
        List split$default;
        HashMap<String, String> hashMap;
        if (nativeAndroid != null && nativeAndroid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) nativeAndroid, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
            if (split$default.size() >= 2) {
                hashMap = parseUrlParams((String) split$default.get(1));
            } else {
                hashMap = new HashMap<>();
            }
            return hashMap.get("id");
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HashMap<String, String> parseUrlParams(String urlParams) {
        boolean z16;
        List split$default;
        List split$default2;
        HashMap<String, String> hashMap = new HashMap<>();
        if (urlParams != null && urlParams.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) urlParams, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    try {
                        Object obj = split$default2.get(0);
                        String decode = URLDecoder.decode((String) split$default2.get(1), "UTF-8");
                        Intrinsics.checkNotNullExpressionValue(decode, "decode(tmpArray[1], \"UTF-8\")");
                        hashMap.put(obj, decode);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.QQWALLET_MSG, 2, "failed to URLDecoder,tmpArray[0] is:" + split$default2.get(0) + ",tmpArray[1] is:" + split$default2.get(1), e16);
                        }
                    }
                }
            }
            return hashMap;
        }
        return hashMap;
    }

    private final void report(String subAction, String actionName, String r26, String r36) {
        com.tencent.mobileqq.qwallet.c.d("", actionName, subAction, 0, 0, r26, r36, "", "");
    }

    static /* synthetic */ void report$default(WalletHbItemV2ApiImpl walletHbItemV2ApiImpl, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str4 = "";
        }
        walletHbItemV2ApiImpl.report(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showQQPayLoading(Activity activity) {
        if (this.mQQPayLoading == null) {
            this.mQQPayLoading = new WalletProgressDialog(activity);
        }
        WalletProgressDialog walletProgressDialog = this.mQQPayLoading;
        if (walletProgressDialog != null && !walletProgressDialog.isShowing() && !activity.isFinishing()) {
            walletProgressDialog.setHeight(0);
            walletProgressDialog.setCancelable(false);
            walletProgressDialog.show();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.IWalletHbItemV2Api
    public void handleOnClick(@NotNull Activity activity, @NotNull QWalletMsgModel msgModel, @NotNull QWalletSessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(msgModel, "msgModel");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (e.f279259a.a(msgModel)) {
            QLog.w(TAG, 1, "FastClick!!");
            return;
        }
        MobileQQ.sMobileQQ.peekAppRuntime();
        QWalletHbModel hbModel = msgModel.getHbModel();
        vk2.b elem = hbModel.getElem();
        String groupId = getGroupId(msgModel, sessionInfo);
        QLog.d(TAG, 2, "elem.actionsPriority: " + elem.f441773k);
        if (doWalletAction(activity, hbModel.getAuthkey(), groupId, msgModel, sessionInfo)) {
            QLog.i(TAG, 1, "do wallet action...");
        }
        doReport(hbModel, sessionInfo, elem);
    }
}
