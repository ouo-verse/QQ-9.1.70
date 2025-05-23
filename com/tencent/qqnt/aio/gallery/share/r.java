package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.gallery.share.r;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.IVideoOfflineDownload;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.event.SaveToAlbumEvent;
import com.tencent.util.PermissionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/r;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "k", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "isOfflineDownload", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class r extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f350191b;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/r$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "", "savePath", "", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, tl.h.F, "e", "c", "", "isDownload", "i", "f", "TAG", "Ljava/lang/String;", "isOfflineDownload", "Z", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.gallery.share.r$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/gallery/share/r$a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.gallery.share.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9476a extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f350192a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ RFWLayerItemMediaInfo f350193b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f350194c;

            C9476a(Context context, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, String str) {
                this.f350192a = context;
                this.f350193b = rFWLayerItemMediaInfo;
                this.f350194c = str;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                r.INSTANCE.d(this.f350192a, this.f350193b, this.f350194c);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(Context context, String savePath) {
            if (Intrinsics.areEqual(com.tencent.mobileqq.filemanager.util.q.j(savePath), ".suf")) {
                IBrowserDepend iBrowserDepend = (IBrowserDepend) QRoute.api(IBrowserDepend.class);
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                iBrowserDepend.savePic((Activity) context, new File(savePath), Utils.Crc64String(savePath + NetConnInfoCenter.getServerTime()));
                return;
            }
            ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(context, savePath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(Context context, RFWLayerItemMediaInfo itemInfo, String savePath) {
            if (itemInfo.isVideo() && (context instanceof Activity)) {
                h((Activity) context, itemInfo);
            } else {
                e(context, savePath);
            }
        }

        private final void e(Context context, String savePath) {
            Boolean i3 = AIOGalleryUtils.i();
            Intrinsics.checkNotNullExpressionValue(i3, "isNewSaveApiEnable()");
            if (i3.booleanValue()) {
                AIOGalleryUtils.l(context, savePath, null);
            } else {
                QLog.i("NTSaveToAlbumAction", 1, "use old api");
                c(context, savePath);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(RFWLayerItemMediaInfo itemInfo, Context context, IVideoOfflineDownload iVideoOfflineDownload) {
            Intrinsics.checkNotNullParameter(itemInfo, "$itemInfo");
            Intrinsics.checkNotNullParameter(context, "$context");
            if ((iVideoOfflineDownload == null || iVideoOfflineDownload.startVideoOfflineDownload(itemInfo.getMediaId())) ? false : true) {
                QQToast.makeText(context, R.string.f237717ht, 0).show();
            }
        }

        private final void h(Activity activity, RFWLayerItemMediaInfo itemInfo) {
            View decorView = activity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            IMediaProvider mediaProvider = RFWLayerIOCUtil.getMediaProvider(decorView);
            if (mediaProvider != null) {
                mediaProvider.saveToAlbum(itemInfo);
            }
        }

        public final void f(final Context context, final RFWLayerItemMediaInfo itemInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
            String existSaveOrEditPath = itemInfo.getExistSaveOrEditPath();
            if (existSaveOrEditPath == null) {
                existSaveOrEditPath = "";
            }
            QLog.i("NTSaveToAlbumAction", 1, "save:" + existSaveOrEditPath + ", mediaId: " + itemInfo.getMediaId());
            if (TextUtils.isEmpty(existSaveOrEditPath)) {
                if (r.f350191b && (context instanceof Activity)) {
                    RFWIocAbilityProvider.g().getIoc(IVideoOfflineDownload.class).withGlobal(context).done(new OnPromiseResolved() { // from class: com.tencent.qqnt.aio.gallery.share.q
                        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                        public final void onDone(Object obj) {
                            r.Companion.g(RFWLayerItemMediaInfo.this, context, (IVideoOfflineDownload) obj);
                        }
                    }).run();
                    return;
                } else {
                    QQToast.makeText(context, R.string.f237717ht, 0).show();
                    return;
                }
            }
            if (!PermissionUtil.isHasStoragePermission(context) && (context instanceof Activity)) {
                QQPermissionFactory.getQQPermission((Activity) context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new C9476a(context, itemInfo, existSaveOrEditPath));
            } else {
                d(context, itemInfo, existSaveOrEditPath);
            }
        }

        public final void i(boolean isDownload) {
            r.f350191b = isDownload;
        }

        Companion() {
        }
    }

    public r(boolean z16) {
        INSTANCE.i(z16);
    }

    private final void k(NTShareContext shareContext) {
        if (shareContext.getLayerItemInfo().isVideo()) {
            INSTANCE.f(shareContext.getActivity(), shareContext.getLayerItemInfo());
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new SaveToAlbumEvent(shareContext.getLayerItemInfo().getMediaId(), shareContext.getActivity().hashCode()));
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        k(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        k(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("save_to_phone");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        View findViewById = shareContext.getActivity().findViewById(R.id.zvg);
        return findViewById != null && findViewById.getVisibility() == 0;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(39);
        return arrayListOf;
    }
}
