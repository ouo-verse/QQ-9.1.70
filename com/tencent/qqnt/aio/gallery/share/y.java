package com.tencent.qqnt.aio.gallery.share;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/y;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "i", "j", "", "k", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class y extends a {
    private final boolean i(NTShareContext shareContext) {
        return shareContext.getMediaType() == 1 && ((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).isSupportImageFormat(new File(shareContext.getExistSaveOrEditPath()));
    }

    private final boolean j(NTShareContext shareContext) {
        if (shareContext.getMediaType() == 3 && shareContext.getLayerItemInfo().getLayerVideoInfo() != null) {
            IWinkMediaHelper iWinkMediaHelper = (IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class);
            RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
            Intrinsics.checkNotNull(layerVideoInfo);
            int videoWidth = layerVideoInfo.getVideoWidth();
            RFWLayerVideoInfo layerVideoInfo2 = shareContext.getLayerItemInfo().getLayerVideoInfo();
            Intrinsics.checkNotNull(layerVideoInfo2);
            int videoHeight = layerVideoInfo2.getVideoHeight();
            RFWLayerVideoInfo layerVideoInfo3 = shareContext.getLayerItemInfo().getLayerVideoInfo();
            Intrinsics.checkNotNull(layerVideoInfo3);
            if (iWinkMediaHelper.isSupportVideoFormat(videoWidth, videoHeight, layerVideoInfo3.getVideoDurationSec() * 1000)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void k(NTShareContext shareContext) {
        String i3;
        String stringExtra;
        String str;
        String str2;
        String existSaveOrEditPath;
        IGPSService iGPSService;
        IGProGuildInfo guildInfo;
        if (shareContext.getActivity().getIntent() == null) {
            return;
        }
        int i16 = shareContext.getAioLayerData().istroop;
        if (i16 == 1) {
            i3 = com.tencent.mobileqq.richmediabrowser.h.a().i();
            if (TextUtils.isEmpty(i3)) {
                i3 = com.tencent.mobileqq.richmediabrowser.h.a().g();
            }
            stringExtra = shareContext.getActivity().getIntent().getStringExtra(PeakConstants.KEY_TROOP_GROUP_NAME);
        } else {
            if (i16 != 10014) {
                str = "";
                str2 = str;
                existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
                if (existSaveOrEditPath != null) {
                    return;
                }
                ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).innerBizShareToQCircle(shareContext.getActivity(), existSaveOrEditPath, i16, str, str2, Long.valueOf(shareContext.getAioLayerData().shmsgseq));
                return;
            }
            i3 = com.tencent.mobileqq.richmediabrowser.h.a().j();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            stringExtra = (peekAppRuntime == null || (iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")) == null || (guildInfo = iGPSService.getGuildInfo(i3)) == null) ? null : guildInfo.getGuildName();
        }
        str = i3;
        str2 = stringExtra;
        existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
        if (existSaveOrEditPath != null) {
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        k(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return (!TextUtils.isEmpty(shareContext.getExistSaveOrEditPath()) && i(shareContext)) || j(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(184);
        return listOf;
    }
}
