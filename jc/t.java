package jc;

import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nc.ah;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0012"}, d2 = {"Ljc/t;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/a;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "shareContext", "k", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class t extends com.qzone.reborn.albumx.common.share.a<ic.a> {
    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.NONE;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.a shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QZAlbumxMemberInviteShareRecentQQAction", 2, "invite share clicked");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() == null) {
            QLog.e("QZAlbumxMemberInviteShareRecentQQAction", 1, "doAction activity null");
            return;
        }
        ViewModel viewModel = getViewModel();
        ah ahVar = viewModel instanceof ah ? (ah) viewModel : null;
        if (ahVar != null) {
            ahVar.Q1(shareContext.getAlbumInfo().getAlbumId(), shareContext.getAlbumInfo().getCreator().getUin());
        }
        l(item);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(72);
        return arrayListOf;
    }

    private final void l(ShareActionSheetBuilder.ActionSheetItem item) {
        boolean z16 = false;
        if (item != null && item.action == 72) {
            z16 = true;
        }
        if (z16 && item != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = item.uinType;
            if (i3 == 0) {
                CommonStUser commonStUser = new CommonStUser();
                String str = item.uin;
                Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                commonStUser.g(str);
                arrayList.add(commonStUser);
            } else if (i3 == 1) {
                String str2 = item.uin;
                Intrinsics.checkNotNullExpressionValue(str2, "it.uin");
                arrayList2.add(str2);
            } else {
                QLog.e("QZAlbumxMemberInviteShareRecentQQAction", 1, "uinType error : " + i3 + " uin: " + item.uin + " ");
                return;
            }
            ViewModel viewModel = getViewModel();
            ah ahVar = viewModel instanceof ah ? (ah) viewModel : null;
            if (ahVar != null) {
                ahVar.S1(arrayList, arrayList2);
            }
        }
    }
}
