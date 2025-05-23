package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/h;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "j", "", "i", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends a {
    private final void i(NTShareContext shareContext) {
        AIOBrowserBaseData aioLayerData = shareContext.getAioLayerData();
        String i3 = com.tencent.mobileqq.richmediabrowser.h.a().i();
        if (aioLayerData.istroop == 10014) {
            i3 = com.tencent.mobileqq.richmediabrowser.h.a().j();
        }
        if (TextUtils.isEmpty(i3)) {
            i3 = com.tencent.mobileqq.richmediabrowser.h.a().g();
        }
        ReportController.o(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", com.tencent.mobileqq.richmediabrowser.h.a().c(), 0, "", "", "", "");
        IMsgLocationApi iMsgLocationApi = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
        Activity activity = shareContext.getActivity();
        int f16 = com.tencent.mobileqq.richmediabrowser.h.a().f();
        String g16 = com.tencent.mobileqq.richmediabrowser.h.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "getInstance().getmFriendUin()");
        iMsgLocationApi.jumpToTargetNTAIOPosition(activity, f16, g16, i3, aioLayerData.shmsgseq, aioLayerData.msgId);
    }

    private final boolean j(NTShareContext shareContext) {
        MsgRecordParams c16;
        if (!(shareContext.getLayerItemInfo().getExtraData() instanceof AIOMsgItem)) {
            return false;
        }
        Object extraData = shareContext.getLayerItemInfo().getExtraData();
        Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) extraData;
        if (com.tencent.mobileqq.aio.utils.d.b0(aIOMsgItem)) {
            return false;
        }
        MsgRecordParams k06 = aIOMsgItem.k0();
        Long l3 = null;
        Long valueOf = k06 != null ? Long.valueOf(k06.f()) : null;
        MsgRecordParams k07 = aIOMsgItem.k0();
        if (k07 != null && (c16 = k07.c()) != null) {
            l3 = Long.valueOf(c16.f());
        }
        return Intrinsics.areEqual(valueOf, l3);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        i(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        i(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("locate_chat");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return j(shareContext) && com.tencent.mobileqq.richmediabrowser.h.a().r() && !TextUtils.isEmpty(com.tencent.mobileqq.richmediabrowser.h.a().g()) && !com.tencent.mobileqq.richmediabrowser.h.a().q();
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(54);
        return listOf;
    }
}
