package jc;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonStShare;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0004\u00a8\u0006\u0016"}, d2 = {"Ljc/ad;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "", DomainData.DOMAIN_NAME, "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "shareInfo", "Landroid/content/Intent;", "intent", "l", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class ad extends com.qzone.reborn.albumx.common.share.a<ic.c> {
    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) {
            return;
        }
        if (shareContext.getLayerItemInfo().isVideo()) {
            p(shareContext, item);
        } else {
            o(shareContext, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item, CommonStShare shareInfo, Intent intent) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("forward_type", 39);
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
        intent.putExtra("is_ark_display_share", true);
        try {
            JSONObject jSONObject = new JSONObject(RichTextAtParser.changeAT2PlainText(shareInfo.getArk().getJsonArk()));
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("ver");
            String optString3 = jSONObject.optString("view");
            String metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String optString4 = jSONObject.optString("prompt");
            String optString5 = jSONObject.optString(DownloadInfo.spKey_Config);
            String optString6 = jSONObject.optString("desc");
            String optString7 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            intent.putExtra("forward_ark_app_name", optString);
            intent.putExtra("forward_ark_app_view", optString3);
            intent.putExtra("forward_ark_app_ver", optString2);
            intent.putExtra("forward_ark_app_prompt", optString4);
            intent.putExtra("forward_ark_app_meta", metaList);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString5);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString6);
            if (!TextUtils.isEmpty(metaList)) {
                Intrinsics.checkNotNullExpressionValue(metaList, "metaList");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) metaList, (CharSequence) "\"isAIO\":1", false, 2, (Object) null);
                if (contains$default) {
                    metaList = StringsKt__StringsJVMKt.replace$default(metaList, "\"isAIO\":1", "\"isAIO\":0", false, 4, (Object) null);
                }
            }
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(optString, optString3, optString2, metaList, null));
            intent.putExtra("forward_ark_biz_src", optString7);
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.d("QZAlbumxShareToSocialAction", 1, "getShareArkIntent  exception message: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean m(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Object extraData = shareContext.getLayerItemInfo().getExtraData();
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = extraData instanceof QZAlbumxLayerExtraInfoBean ? (QZAlbumxLayerExtraInfoBean) extraData : null;
        Intrinsics.areEqual(qZAlbumxLayerExtraInfoBean != null ? qZAlbumxLayerExtraInfoBean.getUploadUid() : null, String.valueOf(com.qzone.album.env.common.a.m().s()));
        return false;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean f(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath());
    }

    public abstract void o(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item);

    public abstract void p(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item);
}
