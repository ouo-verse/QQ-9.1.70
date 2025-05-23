package m02;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.nt.qzone.api.IQZoneShareHelperApi;
import com.tencent.mobileqq.guild.nt.share.api.IWxShareApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\nH\u0007J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u001c\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J&\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJ.\u0010\"\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#\u00a8\u0006("}, d2 = {"Lm02/d;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "filePathTmp", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "g", "", "forceOldPanel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "toastMsg", "p", "u", "k", "i", "filePath", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroid/os/Bundle;", tl.h.F, "title", "content", "j", "Lorg/json/JSONObject;", "param", "", "requestCode", "l", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f415923a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"m02/d$a", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements XhsShareHelper.e {
        a() {
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onError(@NotNull String sessionId, int errorCode, @NotNull String errorMessage, @Nullable Throwable throwable) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.e("GuildPictureShareUtils", 1, "shareToXhs onError. sessionId = " + sessionId + " errorCode = " + errorCode + " errorMessage = " + errorMessage);
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onSuccess(@Nullable String sessionId) {
            QLog.i("GuildPictureShareUtils", 1, "shareToXhs success. sessionId = " + sessionId);
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context) {
        QQToast.makeText(context, "\u4f60\u5c1a\u672a\u5b89\u88c5\u5c0f\u7ea2\u4e66\uff0c\u4e0d\u53ef\u4f7f\u7528\u6b64\u529f\u80fd", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context) {
        QQToast.makeText(context, "\u8bf7\u5148\u66f4\u65b0\u5c0f\u7ea2\u4e66\u540e\u8fdb\u884c\u5206\u4eab", 0).show();
    }

    @JvmStatic
    public static final void g(@NotNull Activity activity, @NotNull String filePathTmp, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        Intrinsics.checkNotNullParameter(item, "item");
        File file = new File(filePathTmp);
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, false);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePathTmp);
        AIOPictureData aIOPictureData = new AIOPictureData();
        aIOPictureData.friendUin = item.uin;
        aIOPictureData.largeImageFile = filePathTmp;
        aIOPictureData.originImageFile = filePathTmp;
        aIOPictureData.thumbImageFile = filePathTmp;
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardPicToFriend(file, false, aIOPictureData, bundle, activity, item.action, item.uin, item.uinType, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
    }

    private final Bundle h(String filePathTmp) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePathTmp);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
        return bundle;
    }

    @JvmStatic
    public static final boolean i() {
        QRouteApi api = QRoute.api(IWxShareApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWxShareApi::class.java)");
        IWxShareApi iWxShareApi = (IWxShareApi) api;
        if (iWxShareApi.isWxInstalled() && iWxShareApi.isWxSupportApi()) {
            return true;
        }
        return false;
    }

    private final void j(Activity activity, String filePath, String title, String content) {
        CharSequence trim;
        String replace$default;
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(filePath)) {
            XhsShareHelper xhsShareHelper = new XhsShareHelper();
            XhsShareHelper.c cVar = new XhsShareHelper.c(null, null, filePath);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            trim = StringsKt__StringsKt.trim((CharSequence) title);
            replace$default = StringsKt__StringsJVMKt.replace$default(trim.toString(), "\n", " ", false, 4, (Object) null);
            xhsShareHelper.m("GUILD_FEED_SHARE", new WeakReference<>(activity.getApplication()), new XhsShareHelper.b(replace$default, content, arrayList), new WeakReference<>(new a()));
            return;
        }
        QLog.e("GuildPictureShareUtils", 1, "realShareToXhs args error");
    }

    @JvmStatic
    public static final void k(@NotNull Activity activity, @NotNull String filePathTmp) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        f415923a.s(activity, filePathTmp, "\u5206\u4eab\u4e00\u7bc7\u817e\u8baf\u9891\u9053\u70ed\u8bae\u5e16\u5b50", "");
    }

    @JvmStatic
    public static final void m(@NotNull Activity activity, @NotNull String filePathTmp, boolean forceOldPanel) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        Intent intent = new Intent();
        if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_qrcode") && !forceOldPanel) {
            z16 = true;
        } else {
            z16 = false;
        }
        intent.putExtras(f415923a.h(filePathTmp));
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, z16);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startForwardActivity(activity, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
    }

    public static /* synthetic */ void n(Activity activity, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        m(activity, str, z16);
    }

    @JvmStatic
    public static final void o(@NotNull Activity activity, @NotNull String filePathTmp) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        Intent intent = new Intent();
        intent.putExtras(f415923a.h(filePathTmp));
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 20000);
    }

    @JvmStatic
    public static final void p(@NotNull Activity activity, @NotNull String filePathTmp, @NotNull String toastMsg) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
        Intent intent = new Intent();
        intent.putExtras(f415923a.h(filePathTmp));
        intent.putExtra("is_need_show_toast", false);
        intent.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_SHOW_TOAST, toastMsg);
        Intent intent2 = activity.getIntent();
        if (intent2 != null && intent2.hasExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE)) {
            intent.putExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, intent2.getIntExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.UNKNOWN.ordinal()));
        }
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 20000);
    }

    @JvmStatic
    public static final void q(@NotNull String filePath, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (!i()) {
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f156731l0);
        } else {
            ((IWxShareApi) QRoute.api(IWxShareApi.class)).shareImageToWx(filePath, bitmap, 0);
        }
    }

    @JvmStatic
    public static final void r(@NotNull String filePath, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (!i()) {
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f156731l0);
        } else {
            ((IWxShareApi) QRoute.api(IWxShareApi.class)).shareImageToWx(filePath, bitmap, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Activity activity, String str, String str2, String str3) {
        d dVar = f415923a;
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        dVar.j(activity, str, str2, str3);
    }

    @JvmStatic
    public static final void u(@NotNull Activity activity, @NotNull String filePathTmp) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        String account = ch.l().getAccount();
        String string = activity.getResources().getString(R.string.f152501_k);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026qrcode_share_qzone_title)");
        ((IQZoneShareHelperApi) QRoute.api(IQZoneShareHelperApi.class)).forwardToZone(activity, new hv1.a(account, "", string, filePathTmp, "", 101));
    }

    public final boolean d(@Nullable final Context context) {
        if (context == null) {
            QLog.e("GuildPictureShareUtils", 1, "args is null error!");
            return false;
        }
        int i3 = new XhsShareHelper().h(context).checkResultCode;
        if (i3 == -1) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: m02.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(context);
                }
            });
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: m02.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(context);
            }
        });
        return false;
    }

    public final void l(@NotNull Activity activity, @NotNull JSONObject param, @NotNull String filePathTmp, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        if (!TextUtils.equals(param.optString("shareFrom"), "guild")) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(f415923a.h(filePathTmp));
        intent.putExtra("share_ark_msg_ext_json", param.optString(WadlProxyConsts.EXT_JSON, ""));
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, requestCode);
    }

    public final void s(@Nullable final Activity activity, @Nullable final String filePath, @Nullable final String title, @Nullable final String content) {
        if (activity != null && filePath != null) {
            if (!d(activity)) {
                QLog.i("GuildPictureShareUtils", 1, "isSupportShareToXhs false");
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: m02.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.t(activity, filePath, title, content);
                    }
                });
                return;
            }
        }
        QLog.e("GuildPictureShareUtils", 1, "shareToXhs context is null.");
    }
}
