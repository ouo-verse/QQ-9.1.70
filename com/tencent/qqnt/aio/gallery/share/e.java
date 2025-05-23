package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/e;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "i", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends a {
    private final void i(NTShareContext shareContext) {
        if (TextUtils.isEmpty(shareContext.getExistSaveOrEditPath()) || shareContext.getMsgRecord() == null) {
            return;
        }
        View decorView = shareContext.getActivity().getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "shareContext.activity.window.decorView");
        IVideoPlayerProvider videoControlProvider = RFWLayerIOCUtil.getVideoControlProvider(decorView);
        if (videoControlProvider == null || videoControlProvider.getInnerCurrentPlayInfo() == null) {
            return;
        }
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        cv3.b bVar = new cv3.b(application);
        RFWPlayerVideoInfo innerCurrentPlayInfo = videoControlProvider.getInnerCurrentPlayInfo();
        Intrinsics.checkNotNull(innerCurrentPlayInfo);
        bVar.w(innerCurrentPlayInfo);
        Drawable coverDrawable = videoControlProvider.getCoverDrawable();
        RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
        Intrinsics.checkNotNull(layerVideoInfo);
        int videoWidth = layerVideoInfo.getVideoWidth();
        RFWLayerVideoInfo layerVideoInfo2 = shareContext.getLayerItemInfo().getLayerVideoInfo();
        Intrinsics.checkNotNull(layerVideoInfo2);
        bVar.u(coverDrawable, videoWidth, layerVideoInfo2.getVideoHeight());
        Activity activity = shareContext.getActivity();
        int c16 = com.tencent.nt.adapter.session.c.c(shareContext.getMsgRecord().chatType);
        RFWLayerVideoInfo layerVideoInfo3 = shareContext.getLayerItemInfo().getLayerVideoInfo();
        Intrinsics.checkNotNull(layerVideoInfo3);
        int videoWidth2 = layerVideoInfo3.getVideoWidth();
        RFWLayerVideoInfo layerVideoInfo4 = shareContext.getLayerItemInfo().getLayerVideoInfo();
        Intrinsics.checkNotNull(layerVideoInfo4);
        if (bVar.s(activity, c16, videoWidth2, layerVideoInfo4.getVideoHeight())) {
            shareContext.getActivity().finish();
        }
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
        listOf = CollectionsKt__CollectionsJVMKt.listOf("floating_window");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return shareContext.getLayerItemInfo().isVideo() && !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath());
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(179);
        return listOf;
    }
}
