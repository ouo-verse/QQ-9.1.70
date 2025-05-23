package jc;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.common.share.ShareApi;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Ljc/j;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/b;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "friends", "k", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "l", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", tl.h.F, "", "e", "Ljava/lang/String;", "shareFriendUin", "f", "Lic/b;", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j extends com.qzone.reborn.albumx.common.share.a<ic.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String shareFriendUin = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ic.b shareContext;

    private final void k(ic.b shareContext, List<CommonStUser> friends) {
        if (!friends.isEmpty() && shareContext != null) {
            ViewModel viewModel = getViewModel();
            nc.u uVar = viewModel instanceof nc.u ? (nc.u) viewModel : null;
            if (uVar != null) {
                uVar.e2(shareContext.getRsp().getAlbumInfo().getAlbumId(), shareContext.getRsp().getAlbumInfo().getCreator(), friends);
                return;
            }
            return;
        }
        QLog.w("QZAlbumxDetailShareRecentQQAction", 1, "[dealPermission] friends or shareContext is empty");
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.NONE;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public void h(int requestCode, int resultCode, Intent data) {
        ArrayList arrayListOf;
        super.h(requestCode, resultCode, data);
        if (requestCode == 1005 && resultCode == -1) {
            String str = this.shareFriendUin;
            if (str == null || str.length() == 0) {
                return;
            }
            ic.b bVar = this.shareContext;
            CommonStUser commonStUser = new CommonStUser();
            commonStUser.g(this.shareFriendUin);
            Unit unit = Unit.INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(commonStUser);
            k(bVar, arrayListOf);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(ic.b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QZAlbumxDetailShareRecentQQAction", 2, "share clicked");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() == null) {
            QLog.e("QZAlbumxDetailShareRecentQQAction", 1, "doAction activity null");
        } else {
            m(shareContext, item);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(72);
        return arrayListOf;
    }

    private final void m(ic.b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        boolean z16 = false;
        if (item != null && item.action == 72) {
            z16 = true;
        }
        if (z16 && item != null) {
            ShareApi shareApi = ShareApi.f52556a;
            Activity activity = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
            ShareApi.ArkShareParams arkShareParams = new ShareApi.ArkShareParams();
            arkShareParams.setToUinType(item.uinType);
            String str = item.uin;
            Intrinsics.checkNotNullExpressionValue(str, "it.uin");
            arkShareParams.setToUin(str);
            arkShareParams.setArkJson(shareContext.getRsp().getShareInfo().getArk().getJsonArk());
            arkShareParams.setArkId(shareContext.getRsp().getShareInfo().getArk().getArkId());
            arkShareParams.setArkAppName(shareContext.getRsp().getShareInfo().getArk().getViewId());
            arkShareParams.setReqType(1);
            arkShareParams.setForwardType(39);
            Unit unit = Unit.INSTANCE;
            shareApi.g(activity, arkShareParams, 1005);
            if (item.uinType == 0) {
                String str2 = item.uin;
                Intrinsics.checkNotNullExpressionValue(str2, "it.uin");
                this.shareFriendUin = str2;
            }
            this.shareContext = shareContext;
        }
    }
}
