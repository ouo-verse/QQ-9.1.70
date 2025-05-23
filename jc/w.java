package jc;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.util.ToastUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Ljc/w;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "Landroid/content/Context;", "context", "shareContext", "", "l", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "bean", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "k", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class w extends com.qzone.reborn.albumx.common.share.a<ic.c> {
    private final void l(Context context, ic.c shareContext) {
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean;
        String replace$default;
        String replace$default2;
        String str;
        if (shareContext.getLayerItemInfo().getExtraData() == null || !(shareContext.getLayerItemInfo().getExtraData() instanceof QZAlbumxLayerExtraInfoBean)) {
            qZAlbumxLayerExtraInfoBean = null;
        } else {
            Object extraData = shareContext.getLayerItemInfo().getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean");
            qZAlbumxLayerExtraInfoBean = (QZAlbumxLayerExtraInfoBean) extraData;
        }
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean2 = qZAlbumxLayerExtraInfoBean;
        if (qZAlbumxLayerExtraInfoBean2 == null) {
            QLog.e("GroupAlbumReportAction", 1, "informLayer currentSelectedMedia is null");
            return;
        }
        com.tencent.mobileqq.dt.api.b g16 = com.qzone.feed.utils.f.INSTANCE.g();
        g16.n(qZAlbumxLayerExtraInfoBean2.getUploadUid());
        String uploadUid = qZAlbumxLayerExtraInfoBean2.getUploadUid();
        replace$default = StringsKt__StringsJVMKt.replace$default("pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}", "{own_uin}", uploadUid == null ? "" : uploadUid, false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{qzone_appid}", "4", false, 4, (Object) null);
        try {
            if (!TextUtils.isEmpty(qZAlbumxLayerExtraInfoBean2.getAlbumId())) {
                String albumId = qZAlbumxLayerExtraInfoBean2.getAlbumId();
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{pid}", albumId == null ? "" : albumId, false, 4, (Object) null);
            }
            if (!TextUtils.isEmpty(qZAlbumxLayerExtraInfoBean2.getSLoc())) {
                String sLoc = qZAlbumxLayerExtraInfoBean2.getSLoc();
                str = StringsKt__StringsJVMKt.replace$default(replace$default2, "{cid}", sLoc == null ? "" : sLoc, false, 4, (Object) null);
            } else {
                String lLoc = qZAlbumxLayerExtraInfoBean2.getLLoc();
                str = StringsKt__StringsJVMKt.replace$default(replace$default2, "{cid}", lLoc == null ? "" : lLoc, false, 4, (Object) null);
            }
        } catch (Exception e16) {
            QLog.e("GroupAlbumReportAction", 1, "informLayer wrap srvPara error:", e16);
            str = replace$default2;
        }
        g16.v(str);
        g16.i("100673");
        g16.m(str + m(qZAlbumxLayerExtraInfoBean2));
        g16.r(qZAlbumxLayerExtraInfoBean2.getUin());
        com.qzone.feed.utils.f.INSTANCE.a(context, g16);
    }

    private final String m(QZAlbumxLayerExtraInfoBean bean) {
        String replace$default;
        String str = "|batchid:{batchid}|qunid:{qunid}";
        if (bean.getBatchId() != null) {
            String batchId = bean.getBatchId();
            Intrinsics.checkNotNull(batchId);
            str = StringsKt__StringsJVMKt.replace$default("|batchid:{batchid}|qunid:{qunid}", "{batchid}", batchId, false, 4, (Object) null);
        }
        String str2 = str;
        if (bean.getUin() == null) {
            return str2;
        }
        String uin = bean.getUin();
        Intrinsics.checkNotNull(uin);
        replace$default = StringsKt__StringsJVMKt.replace$default(str2, "{qunid}", uin, false, 4, (Object) null);
        return replace$default;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
        } else {
            l(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), shareContext);
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "28", true);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(11);
        return arrayListOf;
    }
}
