package com.tencent.mobileqq.qqecommerce.base.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.share.api.ECActionItemClickListener;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.base.share.api.ECQQShareData;
import com.tencent.ecommerce.base.share.api.ECQZoneShareData;
import com.tencent.ecommerce.base.share.api.ECWxShareData;
import com.tencent.ecommerce.base.share.api.ECXhsShareData;
import com.tencent.ecommerce.base.share.api.IECShareCallback;
import com.tencent.ecommerce.base.share.api.ShareType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.base.ECommerceDispatchers;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J.\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002JB\u0010$\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u0005H\u0002J(\u0010)\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0005H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010&2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J<\u00100\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010/\u001a\u00020.J\u001e\u00103\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\n2\u0006\u00102\u001a\u000201J\u001e\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\n2\u0006\u00102\u001a\u000204J\u001e\u00107\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u0002062\u0006\u0010\"\u001a\u00020\nJ \u0010;\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00102\u001a\u0002082\u0006\u0010:\u001a\u000209R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/share/ECShareUtil;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "", "i", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "g", "", "", "items", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "j", "action", "k", "actionSheetItem", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ecommerce/base/share/api/b;", "v", "Lorg/json/JSONObject;", "shareJson", "Landroid/content/Intent;", "d", "requestCode", "", "imageUrls", "thirdPartyAppId", "", "l", "title", "imageUrl", "desc", "shareUrl", "scene", "useQCircleShare", "p", "filePath", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "isQCircleShare", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", tl.h.F, "shareActions", "shareOperations", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "listener", "t", "Lcom/tencent/ecommerce/base/share/api/c;", "data", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/base/share/api/d;", "o", "Lcom/tencent/ecommerce/base/share/api/f;", "r", "Lcom/tencent/ecommerce/base/share/api/g;", "Lcom/tencent/ecommerce/base/share/api/IECShareCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "b", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "mXhsShareListener", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECShareUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ECShareUtil f262459a = new ECShareUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static XhsShareHelper.e mXhsShareListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/share/ECShareUtil$a", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements XhsShareHelper.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECShareCallback f262461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECXhsShareData f262462b;

        a(IECShareCallback iECShareCallback, ECXhsShareData eCXhsShareData) {
            this.f262461a = iECShareCallback;
            this.f262462b = eCXhsShareData;
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onError(String sessionId, int errorCode, String errorMessage, Throwable throwable) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ECShareUtil.mXhsShareListener = null;
            QLog.e("ECShareUtil", 1, "XhsShareHelper onError: " + errorCode + "," + errorMessage);
            this.f262461a.onShareCallback(this.f262462b.getShareType().toString(), String.valueOf(errorCode));
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onSuccess(String sessionId) {
            ECShareUtil.mXhsShareListener = null;
            this.f262461a.onShareCallback(this.f262462b.getShareType().toString(), "0");
        }
    }

    ECShareUtil() {
    }

    private final Intent d(JSONObject shareJson) {
        String optString = shareJson.optString("app");
        Intrinsics.checkNotNullExpressionValue(optString, "shareJson.optString(\"app\")");
        String optString2 = shareJson.optString("ver");
        Intrinsics.checkNotNullExpressionValue(optString2, "shareJson.optString(\"ver\")");
        String optString3 = shareJson.optString("view");
        Intrinsics.checkNotNullExpressionValue(optString3, "shareJson.optString(\"view\")");
        String optString4 = shareJson.optString(QQCustomArkDialogUtil.BIZ_SRC);
        Intrinsics.checkNotNullExpressionValue(optString4, "shareJson.optString(\"bizsrc\")");
        String optString5 = shareJson.optString(PublicAccountMessageUtilImpl.META_NAME);
        Intrinsics.checkNotNullExpressionValue(optString5, "shareJson.optString(\"meta\")");
        String optString6 = shareJson.optString("prompt");
        Intrinsics.checkNotNullExpressionValue(optString6, "shareJson.optString(\"prompt\")");
        String optString7 = shareJson.optString(DownloadInfo.spKey_Config);
        Intrinsics.checkNotNullExpressionValue(optString7, "shareJson.optString(\"config\")");
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_ark_app_name", optString);
        intent.putExtra("forward_ark_app_view", optString3);
        intent.putExtra("forward_ark_biz_src", optString4);
        intent.putExtra("forward_ark_app_ver", optString2);
        intent.putExtra("forward_ark_app_prompt", optString6);
        intent.putExtra("forward_ark_app_meta", optString5);
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString7);
        intent.putExtras(QQCustomArkDialog.b.a(optString, optString3, optString4, optString2, optString5, com.tencent.mobileqq.ark.f.c(), null, null));
        if (QLog.isColorLevel()) {
            QLog.d("ECShareUtil", 2, "FORWARD_ARK_APP_VER: " + optString2);
        }
        return intent;
    }

    private final boolean e() {
        int i3;
        if (WXShareHelper.b0().e0()) {
            i3 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
        } else {
            i3 = R.string.f173257ih1;
        }
        if (i3 == -1) {
            return true;
        }
        com.tencent.biz.qrcode.util.h.T(0, i3);
        return false;
    }

    private final Activity f(Activity activity) {
        Activity b16;
        View decorView;
        if (TextUtils.equals(activity.getLocalClassName(), "com.tencent.biz.qqcircle.activity.QCircleFolderActivity") && i()) {
            Window window = activity.getWindow();
            Object parent = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getParent();
            if ((parent instanceof View) && (b16 = bk.b((View) parent)) != null) {
                return b16;
            }
        }
        return activity;
    }

    private final ShareActionSheet g(Activity activity) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intrinsics.checkNotNullExpressionValue(create, "create(param)");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap h(String imageUrl) {
        boolean startsWith$default;
        Bitmap decodeByteArray;
        try {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imageUrl, "file://", false, 2, null);
            if (startsWith$default) {
                String substring = imageUrl.substring(7);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                File file = new File(substring);
                if (file.exists()) {
                    decodeByteArray = BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                decodeByteArray = null;
            } else {
                byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), MsfSdkUtils.insertMtype("GameCenter", imageUrl), "GET", null, null);
                if (openUrlForByte != null) {
                    decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length);
                }
                decodeByteArray = null;
            }
            if (decodeByteArray != null) {
                int width = decodeByteArray.getWidth();
                int height = decodeByteArray.getHeight();
                int i3 = width * height;
                if (i3 > 8000) {
                    double sqrt = Math.sqrt(8000 / i3);
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (width * sqrt), (int) (height * sqrt), true);
                    decodeByteArray.recycle();
                    return createScaledBitmap;
                }
            } else {
                QLog.e("ECShareUtil", 2, "download and compress wechat thumb image failed, imageUrl=" + imageUrl);
            }
        } catch (IOException e16) {
            QLog.e("ECShareUtil", 2, "download and compress wechat thumb image IO exception", e16);
        } catch (IllegalArgumentException e17) {
            QLog.e("ECShareUtil", 2, e17, new Object[0]);
        } catch (OutOfMemoryError e18) {
            QLog.e("ECShareUtil", 2, "download and compress wechat thumb image out of memory", e18);
        }
        return null;
    }

    private final boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_splash_activity_when_folder_share_dialog", true);
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> j(List<Integer> items) {
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!f262459a.k(((Number) obj).intValue())) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number) it.next()).intValue()));
        }
        return arrayList2;
    }

    private final void l(Activity activity, int requestCode, List<String> imageUrls, String thirdPartyAppId) {
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(imageUrls);
        Unit unit = Unit.INSTANCE;
        bundle.putStringArrayList("images", arrayList);
        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, thirdPartyAppId);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        QZoneShareManager.publishToQzone((AppInterface) runtime, activity, bundle, null, requestCode);
    }

    private final boolean m(String filePath, Bitmap bitmap, int scene, boolean isQCircleShare) {
        if (!e()) {
            return false;
        }
        if (isQCircleShare) {
            WXShareHelper.b0().D0(filePath, BaseImageUtil.bitmap2Bytes(bitmap), scene);
            return true;
        }
        WXShareHelper.b0().u0(filePath, bitmap, scene);
        return true;
    }

    private final boolean p(Activity activity, String title, String imageUrl, String desc, String shareUrl, int scene, boolean useQCircleShare) {
        if (!e()) {
            return false;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity);
        qQProgressDialog.setMessage(R.string.c7z);
        qQProgressDialog.show();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ECommerceDispatchers.f262385a.a()), null, null, new ECShareUtil$shareMsgToWeChat$1(imageUrl, qQProgressDialog, useQCircleShare, String.valueOf(System.currentTimeMillis()), title, desc, shareUrl, scene, null), 3, null);
        return true;
    }

    private final boolean s(List<? extends ShareActionSheetBuilder.ActionSheetItem> actionSheetItem) {
        Object obj;
        Iterator<T> it = actionSheetItem.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ShareActionSheetBuilder.ActionSheetItem) obj).action == 2) {
                break;
            }
        }
        return obj != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ECActionItemClickListener listener, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        shareActionSheet.dismiss();
        int i3 = item.action;
        ECShareUtil eCShareUtil = f262459a;
        Intrinsics.checkNotNullExpressionValue(item, "item");
        listener.onItemClick(i3, eCShareUtil.v(item));
    }

    public final void n(Activity activity, int requestCode, ECQQShareData data) {
        Intent intent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject shareJson = data.getShareJson();
        if (shareJson != null) {
            intent = d(shareJson);
        } else {
            if (data.getShareType() == ShareType.ONLY_IMAGE_SHARE_TYPE) {
                if (data.getPicPath().length() > 0) {
                    intent = new Intent();
                    intent.putExtra("forward_type", 1);
                    intent.putExtra(AppConstants.Key.FORWARD_THUMB, data.getPicPath());
                    intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, data.getPicPath());
                    intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, data.getPicPath());
                    intent.putExtra(AppConstants.Key.FORWARD_EXTRA, data.getPicPath());
                    intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                }
            }
            QLog.e("ECShareUtil", 1, "share Data error:" + data);
            return;
        }
        Intent intent2 = intent;
        intent2.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        if (data.getShareToFriendUin().length() == 0) {
            ForwardBaseOption.startForwardActivityForResult(activity, intent2, requestCode, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
            return;
        }
        intent2.putExtra("toUin", data.getShareToFriendUin());
        intent2.putExtra("uinType", data.getShareToFriendUinType());
        intent2.putExtra("uinname", data.getShareToFriendUinName());
        ForwardBaseOption.startForwardActivityForResult(activity, intent2, (Class<?>) DirectForwardActivity.class, requestCode, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "");
    }

    public final void o(Activity activity, int requestCode, ECQZoneShareData data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(data.c());
        if (data.getShareType() == ShareType.ONLY_IMAGE_SHARE_TYPE) {
            l(activity, requestCode, arrayList, data.getThirdPartyAppId());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", data.getTitle());
        bundle.putString("desc", data.getDesc());
        bundle.putString("detail_url", data.getShareUrl());
        bundle.putString("from", "qq");
        bundle.putString(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, data.getComment());
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putLong("req_share_id", 0L);
        bundle.putInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, 1);
        bundle.putLong(AppConstants.Key.SHARE_BEGIN_TIME, SwiftBrowserShareMenuHandler.f314290n0);
        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, data.getThirdPartyAppId());
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QZoneShareManager.jumpToQzoneShare(runtime instanceof AppInterface ? (AppInterface) runtime : null, activity, bundle, (DialogInterface.OnDismissListener) null, requestCode);
    }

    public final void q(Activity activity, ECXhsShareData data, IECShareCallback callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity == null) {
            callback.onShareCallback(data.getShareType().toString(), "-1");
            return;
        }
        XhsShareHelper xhsShareHelper = new XhsShareHelper();
        if (!xhsShareHelper.i("ECShareUtil", activity)) {
            QLog.e("ECShareUtil", 1, "shareMsgToXhs failed, not supported");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = data.b().iterator();
        while (it.hasNext()) {
            arrayList.add(new XhsShareHelper.c(null, null, (String) it.next()));
        }
        XhsShareHelper.b bVar = new XhsShareHelper.b(data.getTitle(), data.getDesc(), arrayList);
        a aVar = new a(callback, data);
        mXhsShareListener = aVar;
        xhsShareHelper.l("ECShareUtil", new WeakReference<>(activity), bVar, new WeakReference<>(aVar));
    }

    public final boolean r(Activity activity, ECWxShareData data, int scene) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getShareType() == ShareType.ONLY_IMAGE_SHARE_TYPE) {
            Bitmap bitmap = data.getBitmap();
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeFile(data.getImageUrl());
            }
            if (bitmap == null) {
                return false;
            }
            return m(data.getImageUrl(), bitmap, scene, data.getUseQCircleShare());
        }
        return p(activity, data.getTitle(), data.getImageUrl(), data.getDesc(), data.getShareUrl(), scene, data.getUseQCircleShare());
    }

    public final void t(Activity activity, String title, List<Integer> shareActions, List<Integer> shareOperations, final ECActionItemClickListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareActions, "shareActions");
        Intrinsics.checkNotNullParameter(shareOperations, "shareOperations");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Activity f16 = f(activity);
        f16.getIntent().putExtra("big_brother_source_key", "biz_src_ecommerce_xsj");
        List<ShareActionSheetBuilder.ActionSheetItem> j3 = j(shareActions);
        List<ShareActionSheetBuilder.ActionSheetItem> j16 = j(shareOperations);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 44);
        ShareActionSheet g16 = g(f16);
        g16.setActionSheetTitle(title);
        g16.setActionSheetItems(j3, j16);
        g16.setIntentForStartForwardRecentActivity(intent);
        g16.setRowVisibility(s(j3) ? 0 : 8, shareActions.isEmpty() ^ true ? 0 : 8, shareOperations.isEmpty() ^ true ? 0 : 8);
        g16.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.qqecommerce.base.share.d
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                ECShareUtil.u(ECActionItemClickListener.this, actionSheetItem, shareActionSheet);
            }
        });
        g16.show();
    }

    private final ECActionItemData v(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        int i3 = actionSheetItem.action;
        if (i3 != 72) {
            if (i3 != 171) {
                return null;
            }
            String guildId = actionSheetItem.guildId;
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            return new ECActionItemData(null, null, 0, guildId, 7, null);
        }
        String uin = actionSheetItem.uin;
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        String label = actionSheetItem.label;
        Intrinsics.checkNotNullExpressionValue(label, "label");
        return new ECActionItemData(uin, label, actionSheetItem.uinType, null, 8, null);
    }

    private final boolean k(int action) {
        return action == 171 && !((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
    }
}
