package com.tencent.mobileqq.hermes.share;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.hermes.share.HermesSaveToAlbumAction;
import com.tencent.mobileqq.hermes.share.HermesShareActionManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.util.PermissionUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesSaveToAlbumAction;", "Lcom/tencent/mobileqq/hermes/share/HermesAbsShareAction;", "Lcom/tencent/mobileqq/hermes/share/k;", "shareContext", "", "g", "", "", "e", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "a", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class HermesSaveToAlbumAction extends HermesAbsShareAction {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesSaveToAlbumAction$a;", "", "Landroid/content/Context;", "context", "", "savePath", "", "f", "g", "", "result", "d", "Landroidx/fragment/app/Fragment;", "fragment", "i", "TAG", "Ljava/lang/String;", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hermes.share.HermesSaveToAlbumAction$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/hermes/share/HermesSaveToAlbumAction$a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.hermes.share.HermesSaveToAlbumAction$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C7917a extends QQPermission.BasePermissionsListener {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f236800a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f236801b;

            C7917a(Context context, String str) {
                this.f236800a = context;
                this.f236801b = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
                }
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    super.onAllGranted();
                    HermesSaveToAlbumAction.INSTANCE.f(this.f236800a, this.f236801b);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void d(final Context context, boolean result) {
            final int i3;
            final int i16;
            Activity activity;
            if (result) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            if (result) {
                i16 = R.string.f158781qj;
            } else {
                i16 = R.string.f158771qi;
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.hermes.share.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        HermesSaveToAlbumAction.Companion.e(context, i3, i16);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Context context, int i3, int i16) {
            Intrinsics.checkNotNullParameter(context, "$context");
            QQToast.makeText(context, i3, i16, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(Context context, String savePath) {
            g(context, savePath);
        }

        private final void g(final Context context, String savePath) {
            RFWSaveUtil.insertMedia(context, savePath, new Consumer() { // from class: com.tencent.mobileqq.hermes.share.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    HermesSaveToAlbumAction.Companion.h(context, (RFWSaveMediaResultBean) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(Context context, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            Intrinsics.checkNotNullParameter(context, "$context");
            HermesSaveToAlbumAction.INSTANCE.d(context, rFWSaveMediaResultBean.isSuccess);
        }

        public final void i(@NotNull Context context, @NotNull Fragment fragment, @NotNull String savePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, fragment, savePath);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(savePath, "savePath");
            QLog.i("NTSaveToAlbumAction", 1, "save:" + savePath);
            if (!TextUtils.isEmpty(savePath)) {
                if (!PermissionUtil.isHasStoragePermission(context) && (context instanceof Activity)) {
                    QQPermissionFactory.getQQPermission((Activity) context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new C7917a(context, savePath));
                } else {
                    f(context, savePath);
                }
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HermesSaveToAlbumAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    public void b(@NotNull k shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) shareContext, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(c(), null, null, new HermesSaveToAlbumAction$doAction$1(this, shareContext, null), 3, null);
        RFWLayerPicInfo layerPicInfo = shareContext.d().getLayerPicInfo();
        if (layerPicInfo != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
            com.tencent.mobileqq.hermes.util.a.f236827a.d(url);
        }
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    @NotNull
    public HermesShareActionManager.ShareLine d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HermesShareActionManager.ShareLine) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return HermesShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    @NotNull
    public List<Integer> e() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(39);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    public boolean g(@NotNull k shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) shareContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }
}
