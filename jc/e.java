package jc;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.common.share.ShareApi;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0017"}, d2 = {"Ljc/e;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/a;", "Landroid/content/Intent;", "data", "", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "k", "requestCode", QzoneIPCModule.RESULT_CODE, tl.h.F, "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends com.qzone.reborn.albumx.common.share.a<ic.a> {
    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.NONE;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public void h(int requestCode, int resultCode, Intent data) {
        super.h(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1004) {
            l(data);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.a shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QZAlbumxDetailInviteShareMoreAction", 2, "invite share clicked");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() == null) {
            QLog.e("QZAlbumxDetailInviteShareMoreAction", 1, "doAction activity null");
            return;
        }
        ShareApi.FriendSelectParams friendSelectParams = new ShareApi.FriendSelectParams();
        friendSelectParams.setRequestCode(1004);
        ViewModel viewModel = getViewModel();
        nc.o oVar = viewModel instanceof nc.o ? (nc.o) viewModel : null;
        if (oVar != null) {
            oVar.T1(shareContext.getAlbumInfo());
        }
        ShareApi.f52556a.h(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), friendSelectParams);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(73);
        return arrayListOf;
    }

    private final void l(Intent data) {
        ArrayList<ResultRecord> parcelableArrayListExtra = data != null ? data.getParcelableArrayListExtra("selected_target_list") : null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (parcelableArrayListExtra != null) {
            for (ResultRecord resultRecord : parcelableArrayListExtra) {
                int i3 = resultRecord.uinType;
                if (i3 == 0) {
                    CommonStUser commonStUser = new CommonStUser();
                    String str = resultRecord.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                    commonStUser.g(str);
                    arrayList.add(commonStUser);
                } else if (i3 == 1) {
                    String str2 = resultRecord.uin;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.uin");
                    arrayList2.add(str2);
                }
            }
        }
        ViewModel viewModel = getViewModel();
        nc.o oVar = viewModel instanceof nc.o ? (nc.o) viewModel : null;
        if (oVar != null) {
            oVar.f2(arrayList, arrayList2);
        }
    }
}
