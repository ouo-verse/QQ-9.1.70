package com.qzone.reborn.groupalbum.layer.part;

import android.view.View;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/b;", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "getMLayerVideoControlProvider", "()Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "mLayerVideoControlProvider", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class b extends com.qzone.reborn.albumx.common.layer.part.i<GroupAlbumLayerExtraInfoBean> {
    public final IVideoPlayerProvider getMLayerVideoControlProvider() {
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return RFWLayerIOCUtil.getVideoControlProvider(rootView);
    }
}
