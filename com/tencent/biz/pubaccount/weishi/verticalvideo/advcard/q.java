package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import UserGrowth.stAcquisitionInfo;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/q;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", "", "a", "LUserGrowth/stSimpleMetaFeed;", "b", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "itemInfo", "", "c", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f81909a = new q();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/q$a", "Lh00/d;", "", "d", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81910a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81911b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f81912c;

        a(String str, String str2, stSimpleMetaFeed stsimplemetafeed) {
            this.f81910a = str;
            this.f81911b = str2;
            this.f81912c = stsimplemetafeed;
        }

        @Override // h00.d, h00.b
        public void d() {
            super.d();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.L(this.f81910a, this.f81911b, 1000003, this.f81912c);
        }
    }

    q() {
    }

    @JvmStatic
    public static final boolean a(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        stAcquisitionInfo stacquisitioninfo;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        stSimpleMetaFeed e16 = itemData.e();
        return (e16 == null || (stacquisitioninfo = e16.acquisitionInfo) == null || stacquisitioninfo.isLoop != 1) ? false : true;
    }

    @JvmStatic
    public static final boolean b(stSimpleMetaFeed itemData) {
        stAcquisitionInfo stacquisitioninfo;
        return (itemData == null || (stacquisitioninfo = itemData.acquisitionInfo) == null || stacquisitioninfo.adStyle != 1) ? false : true;
    }

    @JvmStatic
    public static final void c(WSVerticalPageFragment fragment, stSimpleMetaFeed itemInfo) {
        if (fragment == null || itemInfo == null) {
            return;
        }
        String from = fragment.getFrom();
        String playScene = fragment.getPlayScene();
        new h00.j(fragment.getActivity()).o(itemInfo.acquisitionInfo.businessIcon.schema).m(new a(from, playScene, itemInfo)).h();
    }
}
