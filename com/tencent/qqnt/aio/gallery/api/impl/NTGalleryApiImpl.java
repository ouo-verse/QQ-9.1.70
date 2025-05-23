package com.tencent.qqnt.aio.gallery.api.impl;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.guild.temp.api.impl.GuildGalleryApiImpl;
import com.tencent.qqnt.aio.gallery.NTGuildAIOLayerFragment;
import com.tencent.qqnt.aio.gallery.api.INTGalleryApi;
import com.tencent.qqnt.aio.gallery.g;
import com.tencent.qqnt.aio.gallery.groupemo.NTAIOLayerGroupEmoticonFragment;
import com.tencent.qqnt.aio.gallery.j;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import fv3.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/api/impl/NTGalleryApiImpl;", "Lcom/tencent/qqnt/aio/gallery/api/INTGalleryApi;", "()V", "addDataList", "", "list", "", "", "getNTAIOLayerActivityPreloadTask", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "getNTAIOLayerGroupEmoticonFragment", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "getNTGuildAIOLayerFragment", "getPicPath", "", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NTGalleryApiImpl implements INTGalleryApi {
    @Override // com.tencent.qqnt.aio.gallery.api.INTGalleryApi
    public void addDataList(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof AIORichMediaData) {
                arrayList.add(obj);
            }
        }
        g gVar = new g();
        gVar.addDataList(arrayList);
        RFWLayerDataCenter.INSTANCE.addDataStore(GuildGalleryApiImpl.AIO_RICH_MEDIA_DATA_KEY, gVar);
    }

    @Override // com.tencent.qqnt.aio.gallery.api.INTGalleryApi
    public BaseActivityResPreloadTask getNTAIOLayerActivityPreloadTask() {
        return new a();
    }

    @Override // com.tencent.qqnt.aio.gallery.api.INTGalleryApi
    public Class<? extends RFWLayerFragment> getNTAIOLayerGroupEmoticonFragment() {
        return NTAIOLayerGroupEmoticonFragment.class;
    }

    @Override // com.tencent.qqnt.aio.gallery.api.INTGalleryApi
    public Class<? extends RFWLayerFragment> getNTGuildAIOLayerFragment() {
        return NTGuildAIOLayerFragment.class;
    }

    @Override // com.tencent.qqnt.aio.gallery.api.INTGalleryApi
    public String getPicPath(PicElement picElement) {
        return j.f350008a.d(picElement);
    }
}
