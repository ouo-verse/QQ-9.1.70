package com.tencent.qqnt.aio.gallery.share;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/v;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "i", "k", "j", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class v extends a {
    private final void i(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        int mediaType = shareContext.getMediaType();
        if (mediaType == 1 || mediaType == 2) {
            k(shareContext, item);
        } else if (mediaType == 3 || mediaType == 4) {
            j(shareContext);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0034, code lost:
    
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(NTShareContext shareContext) {
        Intent intent;
        Pair<Long, Integer> f16 = shareContext.f();
        Intrinsics.checkNotNull(f16);
        int intValue = f16.getSecond().intValue();
        com.tencent.qqnt.aio.adapter.richmedia.provider.h provider = shareContext.getProvider();
        if (provider != null) {
            MsgRecord msgRecord = shareContext.getMsgRecord();
            Intrinsics.checkNotNull(msgRecord);
            intent = provider.h(msgRecord, intValue, shareContext.getMsgRecord().elements.get(intValue), shareContext.getMsgRecord().chatType);
        }
        intent = new Intent();
        if (TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) {
            return;
        }
        Bundle extras = shareContext.getActivity().getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (shareContext.getLayerItemInfo().getLayerVideoInfo() != null) {
            extras.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            extras.putInt("forward_type", 21);
            intent.putExtras(extras);
            intent.putExtra("call_by_forward", true);
            intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, shareContext.getExistSaveOrEditPath());
            intent.putExtra("only_single_selection", true);
            com.tencent.mobileqq.richmediabrowser.utils.e.c(shareContext.getActivity(), intent);
        }
    }

    private final void k(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        String localPath;
        String existSaveOrEditPath = shareContext.getExistSaveOrEditPath();
        if (existSaveOrEditPath == null || TextUtils.isEmpty(existSaveOrEditPath)) {
            return;
        }
        Bundle bundle = new Bundle(shareContext.getActivity().getIntent().getExtras());
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        if (layerPicInfo != null) {
            bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = layerPicInfo.getSmallPicInfo();
            if (smallPicInfo != null && (localPath = smallPicInfo.getLocalPath()) != null && !TextUtils.isEmpty(localPath)) {
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, new File(localPath).toURI().toURL().toString());
            }
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, new File(existSaveOrEditPath).toURI().toURL().toString());
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(new File(existSaveOrEditPath), shareContext.getLayerItemInfo().isShowOriginPic(), shareContext.getAioLayerData(), bundle, shareContext.getActivity(), item != null ? item.action : 171, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        i(shareContext, null);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        i(shareContext, item);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("qqchannel");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab() && !shareContext.getLayerItemInfo().getInvalid() && (shareContext.getMediaType() == 1 || shareContext.getMediaType() == 3 || shareContext.getMediaType() == 2 || shareContext.getMediaType() == 4) && !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath());
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(171);
        return arrayListOf;
    }
}
