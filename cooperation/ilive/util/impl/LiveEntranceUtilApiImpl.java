package cooperation.ilive.util.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.config.QQLiveEntrance;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.o;
import com.vivo.push.PushClientConstants;
import cooperation.ilive.IlivePluginService;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import cooperation.ilive.util.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import l05.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u001a\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0017J*\u0010\u001b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016\u00a8\u0006\""}, d2 = {"Lcooperation/ilive/util/impl/LiveEntranceUtilApiImpl;", "Lcooperation/ilive/util/ILiveEntranceUtilApi;", "", "url", "", "marginTopDp", "bgColor", "composeOpenWebViewSchema", "Ln05/a;", "params", "", "enterRoom", "getQQLiveSecretKey", "Landroid/content/Context;", "context", "", "isInMainProcess", "Landroid/content/Intent;", "intent", "jumpToQQLivePrepareFragment", "checkIsAnchorRoomNow", "getCurrentRoomId", "isAnchorShowEntrance", "isShowIlveShopEntrance", "liveWatchEntranceJump", PushClientConstants.TAG_CLASS_NAME, "isServiceExisted", "openWebView", "offset", "isClickEnable", "<init>", "()V", "Companion", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class LiveEntranceUtilApiImpl implements ILiveEntranceUtilApi {

    @NotNull
    private static final String SCHEMA_OPEN_WEB_VIEW = "mqqapi://vaslive/vasbottomview?type={typeValue}&url={urlValue}&top_margin={topMarginValue}&bgColor={colorValue}";

    @NotNull
    private static final String TAG = "LiveEntranceUtilApiImpl";

    private final String composeOpenWebViewSchema(String url, int marginTopDp, String bgColor) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        replace$default = StringsKt__StringsJVMKt.replace$default(SCHEMA_OPEN_WEB_VIEW, "{typeValue}", "1", false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{urlValue}", url, false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{topMarginValue}", String.valueOf(marginTopDp), false, 4, (Object) null);
        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "{colorValue}", bgColor, false, 4, (Object) null);
        return replace$default4;
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public boolean checkIsAnchorRoomNow() {
        return a.a();
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public void enterRoom(@Nullable n05.a params) {
        p05.a.c().b(params);
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    @NotNull
    public String getCurrentRoomId() {
        String b16 = a.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getCurrentRoomId()");
        return b16;
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    @NotNull
    public String getQQLiveSecretKey() {
        String c16 = a.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getQQLiveSecretKey()");
        return c16;
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public boolean isAnchorShowEntrance() {
        return c.c();
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public boolean isClickEnable(int offset) {
        return c.d(offset);
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    @Deprecated(message = "\u83ab\u540d\u5176\u5999\u7684\u65b9\u6cd5\uff0c\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "none", imports = {}))
    public boolean isServiceExisted(@Nullable Context context, @Nullable String className) {
        return c.e(context, className);
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public boolean isShowIlveShopEntrance() {
        return c.f();
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public void jumpToQQLivePrepareFragment(@NotNull Context context, boolean isInMainProcess, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInMainProcess) {
            com.tencent.mobileqq.qqlive.config.c.f271178a.d(context, QQLiveEntrance.ANCHOR_PREPARE);
        }
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(context, intent);
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public void liveWatchEntranceJump(@Nullable n05.a params) {
        c.h(params);
    }

    @Override // cooperation.ilive.util.ILiveEntranceUtilApi
    public void openWebView(@Nullable Context context, @NotNull String url, int marginTopDp, @NotNull String bgColor) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        if (o.a()) {
            return;
        }
        String composeOpenWebViewSchema = composeOpenWebViewSchema(url, marginTopDp, bgColor);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) IlivePluginService.class);
        intent.setAction("action_open_web_view");
        intent.putExtra("extra_key_mqq_schema", composeOpenWebViewSchema);
        BaseApplication.getContext().startService(intent);
    }
}
