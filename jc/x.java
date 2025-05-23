package jc;

import android.text.TextUtils;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Ljc/x;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "shareContext", "", "p", DomainData.DOMAIN_NAME, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class x extends com.qzone.reborn.albumx.common.share.a<ic.c> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"jc/x$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ic.c f409761b;

        b(ic.c cVar) {
            this.f409761b = cVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            x.this.p(this.f409761b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"jc/x$c", "Loo/b$b;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlList", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements b.InterfaceC10931b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ic.c f409762a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f409763b;

        c(ic.c cVar, Ref.ObjectRef<String> objectRef) {
            this.f409762a = cVar;
            this.f409763b = objectRef;
        }

        @Override // oo.b.InterfaceC10931b
        public void a(ArrayList<String> urlList) {
            Intrinsics.checkNotNullParameter(urlList, "urlList");
            if (ArrayUtils.isOutOfArrayIndex(0, urlList)) {
                tk.h.i(this.f409762a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), this.f409762a.getExistSaveOrEditPath(), this.f409763b.element, false);
                RFWLog.e("GroupAlbumSaveAction", RFWLog.USR, "savePictureNew byWatermarkManger return invalid result,originUrl:", this.f409763b.element);
                return;
            }
            String str = urlList.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "urlList[0]");
            String str2 = str;
            RFWLog.d("GroupAlbumSaveAction", RFWLog.USR, "savePictureNew byWatermarkManger,originUrl:", this.f409763b.element, ",replaceUrl:", str2);
            tk.h.R(this.f409762a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), str2, false, null);
        }
    }

    private final boolean m(ic.c shareContext) {
        Object extraData = shareContext.getLayerItemInfo().getExtraData();
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = extraData instanceof QZAlbumxLayerExtraInfoBean ? (QZAlbumxLayerExtraInfoBean) extraData : null;
        Intrinsics.areEqual(qZAlbumxLayerExtraInfoBean != null ? qZAlbumxLayerExtraInfoBean.getUploadUid() : null, String.valueOf(com.qzone.album.env.common.a.m().s()));
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r1 == null) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n(ic.c shareContext) {
        T t16;
        List listOf;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        String str = "";
        if (layerPicInfo != null && (downloadPicInfo = layerPicInfo.getDownloadPicInfo()) != null) {
            String url = downloadPicInfo.getUrl();
            t16 = url;
        }
        t16 = "";
        objectRef.element = t16;
        if (TextUtils.isEmpty((CharSequence) t16)) {
            RFWLayerPicInfo layerPicInfo2 = shareContext.getLayerItemInfo().getLayerPicInfo();
            T t17 = str;
            if (layerPicInfo2 != null) {
                RFWLayerPicInfo.RFWPicInfo currentPicInfo = layerPicInfo2.getCurrentPicInfo();
                t17 = str;
                if (currentPicInfo != null) {
                    String url2 = currentPicInfo.getUrl();
                    t17 = str;
                    if (url2 != null) {
                        t17 = url2;
                    }
                }
            }
            objectRef.element = t17;
        }
        if (oo.b.l()) {
            CharSequence charSequence = (CharSequence) objectRef.element;
            if (!(charSequence == null || charSequence.length() == 0)) {
                if (!m(shareContext)) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(objectRef.element);
                    oo.b.f(null, 1, listOf, new c(shareContext, objectRef));
                    return;
                } else {
                    tk.h.i(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), shareContext.getExistSaveOrEditPath(), (String) objectRef.element, false);
                    RFWLog.d("QZoneWatermark", RFWLog.USR, "savePictureNew host close watermark,download origin url");
                    return;
                }
            }
        }
        tk.h.i(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), shareContext.getExistSaveOrEditPath(), (String) objectRef.element, false);
    }

    private final void o(ic.c shareContext) {
        String str;
        String currentVideoUrl;
        RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
        String str2 = "";
        if (layerVideoInfo == null || (str = layerVideoInfo.getVideoOriginUrl()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            RFWLayerVideoInfo layerVideoInfo2 = shareContext.getLayerItemInfo().getLayerVideoInfo();
            if (layerVideoInfo2 != null && (currentVideoUrl = layerVideoInfo2.getCurrentVideoUrl()) != null) {
                str2 = currentVideoUrl;
            }
            str = str2;
        }
        RFWLog.d("GroupAlbumSaveAction", RFWLog.USR, "startDownload videoUrl=" + str);
        tk.h.R(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), str, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(ic.c shareContext) {
        if (shareContext.getLayerItemInfo().isVideo()) {
            o(shareContext);
        } else {
            n(shareContext);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (QZonePermission.requestStoragePermission(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), new b(shareContext), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            p(shareContext);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(39);
        return arrayListOf;
    }
}
