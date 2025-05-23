package com.tencent.mobileqq.qqshop.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.ecshop.api.QQShopModule;
import com.tencent.mobileqq.ecshop.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qqshop.message.db.f;
import com.tencent.mobileqq.qqshop.publicaccount.setting.QQShopSettingDelegate;
import com.tencent.mobileqq.qqshop.report.beacon.b;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/impl/QQShopApiImpl;", "Lcom/tencent/mobileqq/qqshop/api/IQQShopApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isFromQQShopPage", "", "url", "changeDefaultWV", "", "from", "", "afterUnFollowQQShop", "Lcom/tencent/biz/pubaccount/setting/a;", "getQQShopSettingDelegate", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onQQShopActivityResult", "isSubscribedQQShopPA", "<init>", "()V", "Companion", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopApiImpl implements IQQShopApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "EcshopUtilApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/impl/QQShopApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.api.impl.QQShopApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQShopApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopApi
    public void afterUnFollowQQShop(int from) {
        HashMap<String, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, from);
            return;
        }
        QLog.d(TAG, 1, "afterUnFollowQQShop from=" + from);
        b bVar = b.f274709a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ext1", String.valueOf(from)));
        bVar.b("qgg_gzh_lifeselection_cancel_follow_click", hashMapOf);
        if (from == 2) {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent(IQQShopApi.FINISH_QQ_SHOP_AIO));
        }
        f.f274497a.e();
        com.tencent.mobileqq.qqshop.message.a.f274473a.u(null, false);
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopApi
    @Nullable
    public String changeDefaultWV(@Nullable String url) {
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "_wv", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                if (contains$default2) {
                    return url + "&_wv=0";
                }
                return url + "?_wv=0";
            }
            return url;
        }
        return url;
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopApi
    @NotNull
    public com.tencent.biz.pubaccount.setting.a getQQShopSettingDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.biz.pubaccount.setting.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new QQShopSettingDelegate();
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopApi
    public boolean isFromQQShopPage(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        d.f203953a.e("qqshop_change_default_wv");
        return false;
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopApi
    public boolean isSubscribedQQShopPA() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        return ((IPublicAccountDataManager) runtimeService).isFollowedUin(Long.valueOf(Long.parseLong(IPublicAccountUtil.UIN_FOR_SHOP)));
    }

    @Override // com.tencent.mobileqq.qqshop.api.IQQShopApi
    public void onQQShopActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            QQShopModule.f203940a.f(requestCode, resultCode, data);
        }
    }
}
