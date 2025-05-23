package pe;

import android.graphics.Bitmap;
import com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lpe/d;", "Lcom/qzone/reborn/share/a;", "Lcom/qzone/reborn/share/e;", "shareContext", "", "Lge/i;", "mediaInfos", "", ReportConstant.COSTREPORT_PREFIX, "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"pe/d$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f425965b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ge.i> f425966c;

        b(com.qzone.reborn.share.e eVar, List<ge.i> list) {
            this.f425965b = eVar;
            this.f425966c = list;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            d.this.s(this.f425965b, this.f425966c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"pe/d$c", "Lcom/qzone/reborn/feedpro/utils/QzoneFeedProLongPicUtils$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements QzoneFeedProLongPicUtils.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f425967a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f425968b;

        c(com.qzone.reborn.share.e eVar, d dVar) {
            this.f425967a = eVar;
            this.f425968b = dVar;
        }

        @Override // com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils.a
        public void a(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            String str = System.currentTimeMillis() + ".jpeg";
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
            if (com.qzone.util.image.c.W(bitmap, sDKPrivatePath, str, Bitmap.CompressFormat.JPEG, 100, true)) {
                tk.h.O(this.f425967a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), sDKPrivatePath + str, "", false);
            } else {
                QQToastUtil.showQQToastInUiThread(4, BaseApplication.getContext().getString(R.string.cwi));
            }
            this.f425968b.a();
        }

        @Override // com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils.a
        public void onFail() {
            QQToastUtil.showQQToastInUiThread(4, BaseApplication.getContext().getString(R.string.cwi));
            this.f425968b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(com.qzone.reborn.share.e shareContext, List<ge.i> mediaInfos) {
        QLog.i("QzoneFeedProLayerShareSaveAction", 1, "savePicture size:" + mediaInfos.size());
        q(shareContext, R.string.jzm);
        QzoneFeedProLongPicUtils.f54255a.q(mediaInfos, new c(shareContext, this));
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        ge.h c16 = shareContext.c();
        List<ge.i> c17 = c16 != null ? c16.c() : null;
        List<ge.i> list = c17;
        if (list == null || list.isEmpty()) {
            QLog.i("QzoneFeedProLayerShareSaveAction", 1, "doAction media is null");
            return;
        }
        QLog.i("QzoneFeedProLayerShareSaveAction", 1, "doAction share clicked");
        if (!QZonePermission.requestStoragePermission(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), new b(shareContext, c17), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            QLog.e("QzoneFeedProLayerShareSaveAction", 1, "[doAction] don't has store permission");
        } else {
            s(shareContext, c17);
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("save_to_phone");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }
}
