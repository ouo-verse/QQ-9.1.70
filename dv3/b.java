package dv3;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.gallery.share.NTShareContext;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Ldv3/b;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.qqnt.aio.gallery.share.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EIPCResult eIPCResult) {
        if (QLog.isColorLevel()) {
            QLog.d("NTGroupEmoReportPart", 2, "NTGroupEmoSaveToAlbumAction " + eIPCResult.code);
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (shareContext.getMsgRecord() == null) {
            QQToast.makeText(shareContext.getActivity(), shareContext.getActivity().getString(R.string.f221696bi), 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        String existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
        if (TextUtils.isEmpty(existSaveOrEditPath)) {
            return;
        }
        bundle.putString("pic_md5", SecUtil.getFileMd5(new File(existSaveOrEditPath).getAbsolutePath()));
        QIPCClientHelper.getInstance().callServer(IEmoticonPanelIpcService.EMOTICON_IPC_NAME, "action_group_emo_big_pic_add_fav", bundle, new EIPCResultCallback() { // from class: dv3.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                b.j(eIPCResult);
            }
        });
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath());
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(48);
        return listOf;
    }
}
