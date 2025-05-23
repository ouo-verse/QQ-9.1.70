package pe;

import android.text.TextUtils;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import oo.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lpe/m;", "Lcom/qzone/reborn/share/a;", "Lcom/qzone/reborn/share/e;", "shareContext", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "extraInfo", "", ReportConstant.COSTREPORT_PREFIX, "u", "t", "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class m extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"pe/m$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f425988b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RFWLayerItemMediaInfo f425989c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QzoneFeedProLayerExtraInfoBean f425990d;

        b(com.qzone.reborn.share.e eVar, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean) {
            this.f425988b = eVar;
            this.f425989c = rFWLayerItemMediaInfo;
            this.f425990d = qzoneFeedProLayerExtraInfoBean;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            m.this.s(this.f425988b, this.f425989c, this.f425990d);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"pe/m$c", "Loo/b$b;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlList", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements b.InterfaceC10931b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f425991a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RFWLayerItemMediaInfo f425992b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f425993c;

        c(com.qzone.reborn.share.e eVar, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, Ref.ObjectRef<String> objectRef) {
            this.f425991a = eVar;
            this.f425992b = rFWLayerItemMediaInfo;
            this.f425993c = objectRef;
        }

        @Override // oo.b.InterfaceC10931b
        public void a(ArrayList<String> urlList) {
            Intrinsics.checkNotNullParameter(urlList, "urlList");
            if (ArrayUtils.isOutOfArrayIndex(0, urlList)) {
                tk.h.i(this.f425991a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), this.f425992b.getExistSaveOrEditPath(), this.f425993c.element, false);
                RFWLog.e("QzoneFeedProLayerShareSaveAction", RFWLog.USR, "savePictureNew byWatermarkManger return invalid result,originUrl:", this.f425993c.element);
                return;
            }
            String str = urlList.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "urlList[0]");
            String str2 = str;
            RFWLog.d("QzoneFeedProLayerShareSaveAction", RFWLog.USR, "savePictureNew byWatermarkManger,originUrl:", this.f425993c.element, ",replaceUrl:", str2);
            tk.h.R(this.f425991a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), str2, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(com.qzone.reborn.share.e shareContext, RFWLayerItemMediaInfo mediaInfo, QzoneFeedProLayerExtraInfoBean extraInfo) {
        if (mediaInfo.isVideo()) {
            u(shareContext, mediaInfo);
        } else {
            t(shareContext, mediaInfo, extraInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16, types: [T, java.lang.String] */
    private final void t(com.qzone.reborn.share.e shareContext, RFWLayerItemMediaInfo mediaInfo, QzoneFeedProLayerExtraInfoBean extraInfo) {
        List listOf;
        RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
        if (layerPicInfo == null) {
            QLog.d("QzoneFeedProLayerShareSaveAction", 1, "savePictureNew videoInfo is null");
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo = layerPicInfo.getDownloadPicInfo();
        T url = downloadPicInfo != null ? downloadPicInfo.getUrl() : 0;
        objectRef.element = url;
        if (TextUtils.isEmpty((CharSequence) url)) {
            objectRef.element = layerPicInfo.getCurrentPicInfo().getUrl();
        }
        QLog.i("QzoneFeedProLayerShareSaveAction", 2, "savePicture download url is " + objectRef.element);
        if (oo.b.l()) {
            CharSequence charSequence = (CharSequence) objectRef.element;
            if (!(charSequence == null || charSequence.length() == 0)) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(objectRef.element);
                oo.b.f(null, 1, listOf, new c(shareContext, mediaInfo, objectRef));
                return;
            }
        }
        tk.h.i(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), mediaInfo.getExistSaveOrEditPath(), (String) objectRef.element, false);
    }

    private final void u(com.qzone.reborn.share.e shareContext, RFWLayerItemMediaInfo mediaInfo) {
        RFWLayerVideoInfo layerVideoInfo = mediaInfo.getLayerVideoInfo();
        if (layerVideoInfo == null) {
            QLog.d("QzoneFeedProLayerShareSaveAction", 1, "saveVideo videoInfo is null");
            return;
        }
        String videoOriginUrl = layerVideoInfo.getVideoOriginUrl();
        if (TextUtils.isEmpty(videoOriginUrl)) {
            videoOriginUrl = layerVideoInfo.getCurrentVideoUrl();
        }
        if (TextUtils.isEmpty(videoOriginUrl)) {
            videoOriginUrl = layerVideoInfo.getNormalVideoUrl();
        }
        tk.h.Q(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), videoOriginUrl, true);
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        ge.i defaultItemBean;
        ge.i defaultItemBean2;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        ge.h c16 = shareContext.c();
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = null;
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean2 = c16.getDefaultItemBean()) == null) ? null : defaultItemBean2.getMediaInfo();
        if (c16 != null && (defaultItemBean = c16.getDefaultItemBean()) != null) {
            qzoneFeedProLayerExtraInfoBean = defaultItemBean.getExtraInfo();
        }
        if (mediaInfo != null && qzoneFeedProLayerExtraInfoBean != null) {
            QLog.i("QzoneFeedProLayerShareSaveAction", 2, "doAction share clicked");
            if (!QZonePermission.requestStoragePermission(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), new b(shareContext, mediaInfo, qzoneFeedProLayerExtraInfoBean), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                QLog.e("QzoneFeedProLayerShareSaveAction", 1, "[doAction] don't has store permission");
                return;
            } else {
                s(shareContext, mediaInfo, qzoneFeedProLayerExtraInfoBean);
                return;
            }
        }
        QLog.i("QzoneFeedProLayerShareSaveAction", 2, "doAction media is null");
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
