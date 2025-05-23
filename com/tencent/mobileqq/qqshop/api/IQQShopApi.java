package com.tencent.mobileqq.qqshop.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\rH&J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0014\u001a\u00020\u0004H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/IQQShopApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isFromQQShopPage", "", "url", "changeDefaultWV", "", "from", "", "afterUnFollowQQShop", "Lcom/tencent/biz/pubaccount/setting/a;", "getQQShopSettingDelegate", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onQQShopActivityResult", "isSubscribedQQShopPA", "Companion", "a", "qqshop-feature-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQShopApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String FINISH_QQ_SHOP_AIO = "finish_qq_shop_aio";
    public static final int UN_FOLLOW_FROM_AIO = 1;
    public static final int UN_FOLLOW_FROM_DETAIL = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/IQQShopApi$a;", "", "<init>", "()V", "qqshop-feature-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.api.IQQShopApi$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f274442a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40094);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f274442a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40098), (Class<?>) IQQShopApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f274442a;
        }
    }

    void afterUnFollowQQShop(int from);

    @Nullable
    String changeDefaultWV(@Nullable String url);

    @NotNull
    com.tencent.biz.pubaccount.setting.a getQQShopSettingDelegate();

    boolean isFromQQShopPage(@Nullable Activity activity);

    boolean isSubscribedQQShopPA();

    void onQQShopActivityResult(int requestCode, int resultCode, @Nullable Intent data);
}
