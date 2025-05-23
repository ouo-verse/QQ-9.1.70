package com.tencent.mobileqq.zootopia.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.ZPLAN_DETAIL, scene = QQPermissionConstants.Business.SCENE.ZPLAN_DETAIL_GALLERY)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 92\u00020\u0001:\u0002:;B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rH\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00103\u001a\u0004\b4\u00105\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaGalleryFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Landroid/os/Bundle;", "bundle", "", "Bh", "showActionSheet", "Lkotlin/Function1;", "", "callback", "yh", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "thumbUrl", OcrConfig.CHINESE, "Fh", "Gh", "targetPath", "Eh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lfi3/h;", BdhLogUtil.LogTag.Tag_Conn, "Lfi3/h;", "binding", "Lcom/tencent/mobileqq/troop/widget/g;", "D", "Lcom/tencent/mobileqq/troop/widget/g;", "galleryAdapter", "", "E", "Ljava/util/List;", "seqNumList", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "troopUin", "G", "srcId", "", "H", "I", "index", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "<init>", "()V", "J", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaGalleryFragment extends QBaseFragment {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private fi3.h binding;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.widget.g galleryAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private List<String> seqNumList;

    /* renamed from: F, reason: from kotlin metadata */
    private String troopUin;

    /* renamed from: G, reason: from kotlin metadata */
    private String srcId;

    /* renamed from: H, reason: from kotlin metadata */
    private int index;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy qqPermission;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaGalleryFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "", "ANIM_DURATION", "J", "", "KEY_INDEX", "Ljava/lang/String;", "KEY_SEQ_NUM", "KEY_SRC_ID", "KEY_TROOP_UIN", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.view.ZootopiaGalleryFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putBoolean("key_need_gesture_back", false);
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, ZootopiaGalleryFragment.class, ZootopiaSource.INSTANCE.g(), bundle2, false, 16, null);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B+\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaGalleryFragment$b;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Landroid/os/Bundle;", "", "params", "a", "([Ljava/lang/Void;)Landroid/os/Bundle;", "bundle", "", "b", "", "Ljava/lang/String;", "troopUin", "Lcom/tencent/image/URLDrawable;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "c", "thumbUrl", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "d", "Ljava/lang/ref/WeakReference;", "mActivity", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/image/URLDrawable;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends AsyncTask<Void, Void, Bundle> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String troopUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final URLDrawable urlDrawable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String thumbUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private WeakReference<Activity> mActivity;

        public b(Activity activity, String str, URLDrawable urlDrawable, String thumbUrl) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
            this.troopUin = str;
            this.urlDrawable = urlDrawable;
            this.thumbUrl = thumbUrl;
            this.mActivity = new WeakReference<>(activity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle doInBackground(Void... params) {
            Intrinsics.checkNotNullParameter(params, "params");
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null) {
                if ((weakReference != null ? weakReference.get() : null) != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("forward_type", 1);
                    String str = AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE;
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str2 = str + this.troopUin + Utils.Crc64String(this.urlDrawable.getURL().toString());
                    if (!new File(str2).exists()) {
                        try {
                            str2 = this.urlDrawable.saveTo(str2);
                            Intrinsics.checkNotNullExpressionValue(str2, "{\n                    ur\u2026lePath)\n                }");
                        } catch (IOException e16) {
                            QLog.e("ZootopiaGalleryFragment", 2, "IOException:", e16);
                            return null;
                        }
                    }
                    bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
                    bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, this.thumbUrl);
                    bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str2);
                    bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, this.urlDrawable.getURL().toString());
                    bundle.putString(AppConstants.Key.FORWARD_EXTRA, str2);
                    bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                    return bundle;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bundle bundle) {
            Activity activity;
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference == null || (activity = weakReference.get()) == null || bundle == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 21);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaGalleryFragment$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329664a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f329664a = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("ZootopiaGalleryFragment", 1, "checkPermission onAllGranted");
            this.f329664a.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            QLog.d("ZootopiaGalleryFragment", 1, "checkPermission onDenied");
            this.f329664a.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog dialog, List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            QLog.d("ZootopiaGalleryFragment", 1, "checkPermission onDialogShow");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J'\u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaGalleryFragment$e", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "params", "a", "([Ljava/lang/Void;)Ljava/lang/String;", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLDrawable f329666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f329667b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZootopiaGalleryFragment f329668c;

        e(URLDrawable uRLDrawable, String str, ZootopiaGalleryFragment zootopiaGalleryFragment) {
            this.f329666a = uRLDrawable;
            this.f329667b = str;
            this.f329668c = zootopiaGalleryFragment;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... params) {
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                String saveTo = this.f329666a.saveTo(this.f329667b);
                if (!TextUtils.isEmpty(saveTo)) {
                    try {
                        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(saveTo);
                        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
                        if (mimeTypeFromExtension != null) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mimeTypeFromExtension, ImageContentType.IMAGE_PREFIX, false, 2, null);
                            if (startsWith$default) {
                                BaseImageUtil.savePic2SystemMedia(this.f329668c.getContext(), new File(saveTo));
                            }
                        }
                    } catch (IllegalArgumentException e16) {
                        QLog.e("ZootopiaGalleryFragment", 2, "savePic2SystemMedia illegalArgumentException ex:", e16.getMessage());
                    }
                    BaseImageUtil.savePhotoToSysAlbum(this.f329668c.getContext(), saveTo);
                    String string = this.f329668c.getString(R.string.cwj);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026q.R.string.picture_saved)");
                    return string;
                }
                String string2 = this.f329668c.getString(R.string.cwi);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(com.tencent.mo\u2026ring.picture_save_failed)");
                return string2;
            } catch (IOException unused) {
                String string3 = this.f329668c.getString(R.string.cwi);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(com.tencent.mo\u2026ring.picture_save_failed)");
                return string3;
            } catch (OutOfMemoryError unused2) {
                String string4 = this.f329668c.getString(R.string.cwi);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(com.tencent.mo\u2026ring.picture_save_failed)");
                return string4;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String result) {
            QQToast.makeText(this.f329668c.getContext(), result, 0).show();
        }
    }

    public ZootopiaGalleryFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaGalleryFragment$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(ZootopiaGalleryFragment.this);
            }
        });
        this.qqPermission = lazy;
    }

    private final QQPermission Ah() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    private final void Bh(Bundle bundle) {
        Gallery gallery;
        com.tencent.mobileqq.troop.widget.g gVar = this.galleryAdapter;
        if (gVar != null) {
            gVar.o(this.srcId);
            gVar.n(this.seqNumList);
            gVar.i(false);
            gVar.notifyDataSetChanged();
            gVar.q(true);
            gVar.j(false);
        }
        fi3.h hVar = this.binding;
        if (hVar == null || (gallery = hVar.f399273d) == null) {
            return;
        }
        gallery.setAdapter((SpinnerAdapter) this.galleryAdapter);
        gallery.setSpacing(gallery.getResources().getDimensionPixelSize(R.dimen.f10752x));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.zootopia.view.w
            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                ZootopiaGalleryFragment.Ch(ZootopiaGalleryFragment.this, adapterView, view, i3, j3);
            }
        });
        gallery.setOnItemSelectedListener(new d());
        gallery.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.tencent.mobileqq.zootopia.view.x
            @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i3, long j3) {
                boolean Dh;
                Dh = ZootopiaGalleryFragment.Dh(ZootopiaGalleryFragment.this, adapterView, view, i3, j3);
                return Dh;
            }
        });
        gallery.setSelection(this.index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ZootopiaGalleryFragment this$0, AdapterView adapterView, View view, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Dh(ZootopiaGalleryFragment this$0, AdapterView adapterView, View view, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showActionSheet();
        return true;
    }

    private final void Eh(URLDrawable urlDrawable, String targetPath) {
        new e(urlDrawable, targetPath, this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(URLDrawable urlDrawable) {
        Gh(urlDrawable);
    }

    private final void Gh(URLDrawable urlDrawable) {
        if (urlDrawable.getStatus() != 1) {
            return;
        }
        String str = AppConstants.SDCARD_IMG_SAVE;
        new File(str).mkdirs();
        Eh(urlDrawable, str + this.troopUin + Utils.Crc64String(urlDrawable.getURL().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(final ZootopiaGalleryFragment this$0, ActionSheet actionSheet, final Drawable tempDrawable, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(tempDrawable, "$tempDrawable");
        com.tencent.mobileqq.troop.widget.g gVar = this$0.galleryAdapter;
        final String item = gVar != null ? gVar.getItem(this$0.index) : null;
        if (item == null) {
            item = "0";
        }
        final String content = actionSheet.getContent(i3);
        this$0.yh(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaGalleryFragment$showActionSheet$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    if (Intrinsics.areEqual(ZootopiaGalleryFragment.this.getString(R.string.xbj), content)) {
                        ZootopiaGalleryFragment.this.zh((URLDrawable) tempDrawable, item);
                    } else if (Intrinsics.areEqual(ZootopiaGalleryFragment.this.getString(R.string.xbk), content)) {
                        ZootopiaGalleryFragment.this.Fh((URLDrawable) tempDrawable);
                    }
                }
            }
        });
        try {
            actionSheet.dismiss();
        } catch (Exception e16) {
            QLog.e("ZootopiaGalleryFragment", 1, "showActionSheet dismiss throw e:" + e16.getMessage());
        }
    }

    private final void showActionSheet() {
        Gallery gallery;
        ImageView imageView;
        final Drawable drawable;
        fi3.h hVar = this.binding;
        if (hVar == null || (gallery = hVar.f399273d) == null) {
            return;
        }
        View selectedView = (hVar == null || gallery == null) ? null : gallery.getSelectedView();
        if (selectedView == null || (imageView = (ImageView) selectedView.findViewById(R.id.image)) == null || (drawable = imageView.getDrawable()) == null || !(drawable instanceof URLDrawable) || ((URLDrawable) drawable).getStatus() != 1) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getContext(), null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet == null) {
            return;
        }
        actionSheet.addButton(R.string.xbj, 1);
        actionSheet.addButton(R.string.xbk, 1);
        actionSheet.addCancelButton(R.string.f169739xb4);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.zootopia.view.y
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ZootopiaGalleryFragment.Hh(ZootopiaGalleryFragment.this, actionSheet, drawable, view, i3);
            }
        });
        try {
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e("ZootopiaGalleryFragment", 1, "showActionSheet show throw e:" + e16.getMessage());
        }
    }

    private final void yh(Function1<? super Boolean, Unit> callback) {
        if (Ah().hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            callback.invoke(Boolean.TRUE);
        } else {
            Ah().requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(URLDrawable urlDrawable, String thumbUrl) {
        new b(getActivity(), this.troopUin, urlDrawable, thumbUrl).execute(new Void[0]);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        fi3.h g16 = fi3.h.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Object obj;
        com.tencent.mobileqq.troop.widget.g gVar;
        com.tencent.mobileqq.persistence.l entityManagerFactory;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.binding == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        if (extras == null) {
            return;
        }
        this.srcId = extras.getString("src_id");
        fi3.h hVar = this.binding;
        FrameLayout frameLayout = hVar != null ? hVar.f399275f : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        QQAppInterface qQAppInterface = waitAppRuntime instanceof QQAppInterface ? (QQAppInterface) waitAppRuntime : null;
        this.galleryAdapter = new com.tencent.mobileqq.troop.widget.g(getContext(), qQAppInterface);
        this.seqNumList = extras.getStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM);
        this.index = extras.getInt("index", 0);
        this.troopUin = extras.getString("troop_uin");
        EntityManager createEntityManager = (qQAppInterface == null || (entityManagerFactory = qQAppInterface.getEntityManagerFactory()) == null) ? null : entityManagerFactory.createEntityManager();
        if (createEntityManager != null) {
            obj = DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, "troop_" + this.troopUin);
        } else {
            obj = null;
        }
        if (createEntityManager != null) {
            createEntityManager.close();
        }
        Bh(extras);
        Setting setting = obj instanceof Setting ? (Setting) obj : null;
        if (setting == null || (gVar = this.galleryAdapter) == null) {
            return;
        }
        gVar.p(this.troopUin, setting);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaGalleryFragment$d", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            if (view == null) {
                return;
            }
            ZootopiaGalleryFragment.this.index = position;
            int i3 = ZootopiaGalleryFragment.this.index + 1;
            List list = ZootopiaGalleryFragment.this.seqNumList;
            String str = i3 + "/" + (list != null ? list.size() : 0);
            fi3.h hVar = ZootopiaGalleryFragment.this.binding;
            TextView textView = hVar != null ? hVar.f399276g : null;
            if (textView == null) {
                return;
            }
            textView.setText(str);
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
