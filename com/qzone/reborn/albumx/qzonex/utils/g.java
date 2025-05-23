package com.qzone.reborn.albumx.qzonex.utils;

import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.tencent.qqnt.kernel.nativeinterface.PhotoInfo;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StTimeLine;
import com.tencent.qqnt.kernel.nativeinterface.StTimeLineEvent;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\n\u0010\b\u001a\u00020\u0007*\u00020\u0005J\n\u0010\u000b\u001a\u00020\n*\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/g;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StTimeLine;", "stTimeLine", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/StTimeLineEvent;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/PhotoInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f53410a = new g();

    g() {
    }

    public final List<CommonStTimeLineEvent> a(StTimeLine stTimeLine) {
        ArrayList<StTimeLineEvent> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (stTimeLine != null && (arrayList = stTimeLine.events) != null) {
            for (StTimeLineEvent it : arrayList) {
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    CommonStTimeLineEvent commonStTimeLineEvent = new CommonStTimeLineEvent();
                    commonStTimeLineEvent.s(it.type);
                    String str = it.title;
                    Intrinsics.checkNotNullExpressionValue(str, "it.title");
                    commonStTimeLineEvent.r(str);
                    String str2 = it.content;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.content");
                    commonStTimeLineEvent.n(str2);
                    String str3 = it.attachInfo;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.attachInfo");
                    commonStTimeLineEvent.k(str3);
                    commonStTimeLineEvent.l(it.beginTime);
                    commonStTimeLineEvent.p(it.endTime);
                    commonStTimeLineEvent.m(it.bindingType);
                    commonStTimeLineEvent.o(it.disable);
                    commonStTimeLineEvent.q(it.itemCount);
                    arrayList2.add(commonStTimeLineEvent);
                }
            }
        }
        return arrayList2;
    }

    public final CommonPhotoInfo b(PhotoInfo photoInfo) {
        Intrinsics.checkNotNullParameter(photoInfo, "<this>");
        CommonPhotoInfo commonPhotoInfo = new CommonPhotoInfo();
        commonPhotoInfo.f(photoInfo.albumId);
        commonPhotoInfo.g(photoInfo.albumName);
        StUser stUser = photoInfo.albumOwner;
        Intrinsics.checkNotNullExpressionValue(stUser, "this.albumOwner");
        commonPhotoInfo.k(xh.i.a(stUser));
        StMedia stMedia = photoInfo.media;
        Intrinsics.checkNotNullExpressionValue(stMedia, "this.media");
        commonPhotoInfo.j(xh.h.b(stMedia));
        return commonPhotoInfo;
    }

    public final StTimeLineEvent c(CommonStTimeLineEvent commonStTimeLineEvent) {
        Intrinsics.checkNotNullParameter(commonStTimeLineEvent, "<this>");
        StTimeLineEvent stTimeLineEvent = new StTimeLineEvent();
        stTimeLineEvent.beginTime = commonStTimeLineEvent.getBeginTime();
        stTimeLineEvent.endTime = commonStTimeLineEvent.getEndTime();
        stTimeLineEvent.content = commonStTimeLineEvent.getContent();
        stTimeLineEvent.type = commonStTimeLineEvent.getType();
        stTimeLineEvent.title = commonStTimeLineEvent.getTitle();
        stTimeLineEvent.attachInfo = commonStTimeLineEvent.getAttachInfo();
        stTimeLineEvent.bindingType = commonStTimeLineEvent.getBindingType();
        stTimeLineEvent.disable = commonStTimeLineEvent.getDisable();
        stTimeLineEvent.itemCount = commonStTimeLineEvent.getItemCount();
        return stTimeLineEvent;
    }
}
