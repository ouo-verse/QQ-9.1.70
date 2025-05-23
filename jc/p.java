package jc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0014\u00a8\u0006\u001a"}, d2 = {"Ljc/p;", "Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction;", "Lic/c;", "shareContext", "Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$b;", "listener", "", "B", "", "", "c", BdhLogUtil.LogTag.Tag_Conn, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "Lcom/qzone/reborn/albumx/common/layer/action/CommonLayerShareScanCodeAction$CodeType;", "p", "scanResult", "", "E", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class p extends CommonLayerShareScanCodeAction<ic.c> {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r1 == true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean B(ic.c shareContext, CommonLayerShareScanCodeAction.b listener) {
        boolean z16;
        HashMap<String, Boolean> N1;
        ViewModel viewModel = getViewModel();
        q9.c cVar = viewModel instanceof q9.c ? (q9.c) viewModel : null;
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        if (!TextUtils.isEmpty(extraInfoBean != null ? extraInfoBean.getLLoc() : null)) {
            if (cVar != null && (N1 = cVar.N1()) != null) {
                QZAlbumxLayerExtraInfoBean extraInfoBean2 = shareContext.getExtraInfoBean();
                boolean containsKey = N1.containsKey(extraInfoBean2 != null ? extraInfoBean2.getLLoc() : null);
                z16 = true;
            }
            z16 = false;
            if (z16) {
                HashMap<String, Boolean> N12 = cVar.N1();
                QZAlbumxLayerExtraInfoBean extraInfoBean3 = shareContext.getExtraInfoBean();
                Boolean bool = N12.get(extraInfoBean3 != null ? extraInfoBean3.getLLoc() : null);
                Intrinsics.checkNotNull(bool);
                return bool.booleanValue();
            }
        }
        n(shareContext, listener);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public String r(ic.c shareContext) {
        String uin;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        return (extraInfoBean == null || (uin = extraInfoBean.getUin()) == null) ? "" : uin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public boolean t(ic.c shareContext, CommonLayerShareScanCodeAction.b listener) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (com.qzone.reborn.configx.g.f53821a.b().P() && !shareContext.getLayerItemInfo().isVideo()) {
            return B(shareContext, listener);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public boolean u(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return shareContext.getLayerItemInfo().isVideo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void y(ic.c shareContext, boolean scanResult) {
        q9.c cVar;
        HashMap<String, Boolean> N1;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        if (TextUtils.isEmpty(extraInfoBean != null ? extraInfoBean.getLLoc() : null) || (cVar = (q9.c) getViewModel()) == null || (N1 = cVar.N1()) == null) {
            return;
        }
        QZAlbumxLayerExtraInfoBean extraInfoBean2 = shareContext.getExtraInfoBean();
        String lLoc = extraInfoBean2 != null ? extraInfoBean2.getLLoc() : null;
        Intrinsics.checkNotNull(lLoc);
        N1.put(lLoc, Boolean.valueOf(scanResult));
    }

    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    protected CommonLayerShareScanCodeAction.CodeType p() {
        return CommonLayerShareScanCodeAction.CodeType.QRCODE;
    }

    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    protected int s() {
        return 23;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.action.CommonLayerShareScanCodeAction
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public String q(ic.c shareContext) {
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        String url;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        return (layerPicInfo == null || (bigPicInfo = layerPicInfo.getBigPicInfo()) == null || (url = bigPicInfo.getUrl()) == null) ? "" : url;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(23);
        return arrayListOf;
    }
}
