package com.qzone.reborn.albumx.qzonex.share.action;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.common.share.ShareApi;
import com.qzone.reborn.albumx.common.share.a;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import ic.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nc.u;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/share/action/QZAlbumxDetailShareMoreAction;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/b;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "friends", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxDetailShareMoreAction extends a<b> {
    /* JADX INFO: Access modifiers changed from: private */
    public final void l(b shareContext, List<CommonStUser> friends) {
        if (friends.isEmpty()) {
            QLog.w("QZAlbumxDetailShareMoreAction", 1, "[dealPermission] friends is empty");
            return;
        }
        ViewModel viewModel = getViewModel();
        u uVar = viewModel instanceof u ? (u) viewModel : null;
        if (uVar != null) {
            uVar.e2(shareContext.getRsp().getAlbumInfo().getAlbumId(), shareContext.getRsp().getAlbumInfo().getCreator(), friends);
        }
    }

    private final void n(final b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        ShareApi shareApi = ShareApi.f52556a;
        Activity activity = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        ShareApi.ArkShareParams arkShareParams = new ShareApi.ArkShareParams();
        arkShareParams.setArkJson(shareContext.getRsp().getShareInfo().getArk().getJsonArk());
        arkShareParams.setArkId(shareContext.getRsp().getShareInfo().getArk().getArkId());
        arkShareParams.setArkAppName(shareContext.getRsp().getShareInfo().getArk().getViewId());
        arkShareParams.setReqType(1);
        arkShareParams.setForwardType(27);
        Unit unit = Unit.INSTANCE;
        final Handler handler = new Handler(Looper.getMainLooper());
        shareApi.e(activity, arkShareParams, 1001, new ResultReceiver(handler) { // from class: com.qzone.reborn.albumx.qzonex.share.action.QZAlbumxDetailShareMoreAction$shareToQQ$2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                QLog.w("QZAlbumxDetailShareMoreAction", 1, "[registerForwardResultReceiver] onReceiveResult");
                ArrayList<ResultRecord> parcelableArrayList = resultData.getParcelableArrayList("selected_target_list");
                ArrayList arrayList = new ArrayList();
                if (parcelableArrayList != null) {
                    for (ResultRecord resultRecord : parcelableArrayList) {
                        if (resultRecord.uinType == 0) {
                            CommonStUser commonStUser = new CommonStUser();
                            String str = resultRecord.uin;
                            Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                            commonStUser.g(str);
                            arrayList.add(commonStUser);
                        }
                    }
                }
                QZAlbumxDetailShareMoreAction.this.l(shareContext, arrayList);
            }
        }, (r16 & 16) != 0 ? false : true, (r16 & 32) != 0 ? false : false);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.NONE;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void a(b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QZAlbumxDetailShareMoreAction", 2, "share clicked");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() == null) {
            QLog.e("QZAlbumxDetailShareMoreAction", 1, "doAction activity null");
        } else {
            n(shareContext, item);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(73);
        return arrayListOf;
    }
}
