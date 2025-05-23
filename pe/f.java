package pe;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0014\u00a8\u0006\u001b"}, d2 = {"Lpe/f;", "Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction;", "Lre/a;", "G", "Lcom/qzone/reborn/share/e;", "shareContext", "Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$b;", "listener", "", "H", "", "", "g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "B", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/qzone/reborn/feedpro/share/layer/base/QzoneProCommonLayerProShareScanCodeAction$CodeType;", "w", "scanResult", "", UserInfo.SEX_FEMALE, "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends QzoneProCommonLayerProShareScanCodeAction {
    private final re.a G() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.a) {
            return (re.a) viewModel;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r2.containsKey(r1) == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean H(com.qzone.reborn.share.e shareContext, QzoneProCommonLayerProShareScanCodeAction.b listener) {
        boolean z16;
        re.a G = G();
        ge.h c16 = shareContext.c();
        String a16 = ge.j.a(c16 != null ? c16.getDefaultItemBean() : null);
        if (!TextUtils.isEmpty(a16)) {
            if (G != null && (r2 = G.S1()) != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                Boolean bool = G.S1().get(a16);
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            }
        }
        u(shareContext, listener);
        return false;
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected boolean A(com.qzone.reborn.share.e shareContext, QzoneProCommonLayerProShareScanCodeAction.b listener) {
        ge.i defaultItemBean;
        ge.i defaultItemBean2;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (!com.qzone.reborn.configx.g.f53821a.b().P()) {
            return false;
        }
        ge.h c16 = shareContext.c();
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = null;
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean2 = c16.getDefaultItemBean()) == null) ? null : defaultItemBean2.getMediaInfo();
        if (c16 != null && (defaultItemBean = c16.getDefaultItemBean()) != null) {
            qzoneFeedProLayerExtraInfoBean = defaultItemBean.getExtraInfo();
        }
        if (mediaInfo != null && qzoneFeedProLayerExtraInfoBean != null) {
            if (mediaInfo.isVideo()) {
                return false;
            }
            return H(shareContext, listener);
        }
        QLog.i("QzoneFeedProLayerShareCoverAction", 2, "doAction media is null");
        return false;
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected boolean B(com.qzone.reborn.share.e shareContext) {
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.isVideo();
        }
        return false;
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected void F(com.qzone.reborn.share.e shareContext, boolean scanResult) {
        String str;
        re.a G;
        HashMap<String, Boolean> S1;
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        if (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null || (str = ge.j.a(defaultItemBean)) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str) || (G = G()) == null || (S1 = G.S1()) == null) {
            return;
        }
        S1.put(str, Boolean.valueOf(scanResult));
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("recognize_qr_code");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected QzoneProCommonLayerProShareScanCodeAction.CodeType w() {
        return QzoneProCommonLayerProShareScanCodeAction.CodeType.QRCODE;
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected String x(com.qzone.reborn.share.e shareContext) {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        String str = null;
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getMediaInfo();
        if (mediaInfo != null && (layerPicInfo = mediaInfo.getLayerPicInfo()) != null && (bigPicInfo = layerPicInfo.getBigPicInfo()) != null) {
            str = bigPicInfo.getUrl();
        }
        return String.valueOf(str);
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected String y(com.qzone.reborn.share.e shareContext) {
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        QzoneFeedProLayerExtraInfoBean extraInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getExtraInfo();
        return String.valueOf(extraInfo != null ? Long.valueOf(extraInfo.getOwnerUin()) : null);
    }

    @Override // com.qzone.reborn.feedpro.share.layer.base.QzoneProCommonLayerProShareScanCodeAction
    protected String z() {
        return "recognize_qr_code";
    }
}
