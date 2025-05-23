package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import UserGrowth.sTadLowItem;
import UserGrowth.stAcquisitionInfo;
import UserGrowth.stBusinessIconInfo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J@\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003J\u001c\u0010\u0016\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003J$\u0010\u0018\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003J\b\u0010\u001a\u001a\u00020\u0019H\u0003\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/i;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", "Lh00/d;", "onJumpCallback", "", "c", "", "position", "", "location", "isHighLight", "", "isBigCard", "d", "highLightType", "", "b", "g", tl.h.F, "isFromDownloadBtn", "f", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f81884a = new i();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f81885a;

        static {
            int[] iArr = new int[WSDownloadStatus.values().length];
            try {
                iArr[WSDownloadStatus.Waiting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WSDownloadStatus.Downloading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WSDownloadStatus.Completed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f81885a = iArr;
        }
    }

    i() {
    }

    @JvmStatic
    private static final WSDownloadStatus a() {
        return WSThreeSegmentDownloadHelper.f81856a.f();
    }

    @JvmStatic
    public static final void c(WSVerticalPageFragment fragment, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData, h00.d onJumpCallback) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stBusinessIconInfo stbusinessiconinfo;
        stSchema stschema;
        Intrinsics.checkNotNullParameter(onJumpCallback, "onJumpCallback");
        if (fragment == null) {
            return;
        }
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        if (com.tencent.biz.qqstory.utils.l.c(fragment.getContext())) {
            x.i("WSThreeSegmentClickHelper", "\u5df2\u5b89\u88c5\u62c9\u65b0\uff0c\u5982\u679c\u672a\u8df3\u8f6c\uff0c\u5219\u4e0b\u53d1\u7684\u8df3\u8f6cscheme\u4e3a\u7a7a");
            stSimpleMetaFeed e17 = itemData != null ? itemData.e() : null;
            if (e17 == null) {
                return;
            }
            q.c(fragment, e17);
            onJumpCallback.d();
            return;
        }
        if (com.tencent.biz.pubaccount.weishi.util.a.c(fragment.getContext())) {
            com.tencent.biz.pubaccount.weishi.util.a.b(fragment.getContext());
            if (itemData != null && (e16 = itemData.e()) != null && (stacquisitioninfo = e16.acquisitionInfo) != null && (stbusinessiconinfo = stacquisitioninfo.businessIcon) != null && (stschema = stbusinessiconinfo.schema) != null) {
                str = stschema.schema;
            }
            i00.a.f406985a.a(str);
            onJumpCallback.f();
            return;
        }
        if (g(itemData)) {
            x.i("WSThreeSegmentClickHelper", "\u8df3\u8f6c\u843d\u5730\u9875\uff0c\u5982\u679c\u672a\u8df3\u8f6c\uff0c\u5219\u4e0b\u53d1\u7684\u8df3\u8f6cscheme\u4e3a\u7a7a");
            h(fragment, itemData);
            onJumpCallback.a();
        } else {
            x.i("WSThreeSegmentClickHelper", "\u5f53\u524d\u9875\u9762\u4e0b\u8f7d");
            f(fragment, false, itemData);
            onJumpCallback.b();
        }
    }

    @JvmStatic
    private static final void f(WSVerticalPageFragment fragment, boolean isFromDownloadBtn, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stBusinessIconInfo stbusinessiconinfo;
        stSchema stschema;
        int i3 = a.f81885a[a().ordinal()];
        if (i3 == 1 || i3 == 2) {
            x.i("WSThreeSegmentClickHelper", "\u70b9\u51fb\u4e0b\u8f7d\u6309\u94ae\u533a\u57df\uff0c\u6682\u505c\u4e0b\u8f7d\uff0c\u5176\u4ed6\u533a\u57df\uff0c\u5219\u4e0d\u54cd\u5e94\u6682\u505c\u65f6\u95f4");
            if (isFromDownloadBtn) {
                WSThreeSegmentDownloadHelper.j();
                return;
            }
            return;
        }
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str = null;
        if (i3 != 3) {
            x.i("WSThreeSegmentClickHelper", "\u70b9\u51fb\u5f00\u59cb\u4e0b\u8f7d");
            WSThreeSegmentDownloadHelper.d(fragment != null ? fragment.getActivity() : null, new WSDownloadParams());
            if (itemData != null && (e16 = itemData.e()) != null && (stacquisitioninfo = e16.acquisitionInfo) != null && (stbusinessiconinfo = stacquisitioninfo.businessIcon) != null && (stschema = stbusinessiconinfo.schema) != null) {
                str = stschema.schema;
            }
            i00.a.f406985a.a(str);
            return;
        }
        x.i("WSThreeSegmentClickHelper", "\u70b9\u51fb\u5b89\u88c5\uff0c\u5df2\u7ecf\u4e0b\u8f7d\u5b8c\u6210\u4e86");
        WSThreeSegmentDownloadHelper.i(fragment != null ? fragment.getActivity() : null);
    }

    @JvmStatic
    private static final void h(WSVerticalPageFragment fragment, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stBusinessIconInfo stbusinessiconinfo;
        stSchema stschema;
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.l(fragment, itemData);
        i00.a.f406985a.a((itemData == null || (e16 = itemData.e()) == null || (stacquisitioninfo = e16.acquisitionInfo) == null || (stbusinessiconinfo = stacquisitioninfo.businessIcon) == null || (stschema = stbusinessiconinfo.schema) == null) ? null : stschema.schema);
    }

    private final Map<String, String> b(int highLightType, int location) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("download_btn_status", String.valueOf(highLightType)), TuplesKt.to("btn_status", String.valueOf(a().getType())), TuplesKt.to("clk_loc", String.valueOf(location)));
        return mutableMapOf;
    }

    @JvmStatic
    private static final boolean g(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        ArrayList<sTadLowItem> arrayList = (itemData == null || (e16 = itemData.e()) == null || (stacquisitioninfo = e16.acquisitionInfo) == null) ? null : stacquisitioninfo.items;
        return arrayList == null || arrayList.isEmpty();
    }

    @JvmStatic
    public static final void d(WSVerticalPageFragment fragment, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData, String position, int location, int isHighLight, boolean isBigCard) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stBusinessIconInfo stbusinessiconinfo;
        stSchema stschema;
        Intrinsics.checkNotNullParameter(position, "position");
        boolean z16 = location == 2;
        if (fragment == null) {
            return;
        }
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        if (com.tencent.biz.qqstory.utils.l.c(fragment.getContext())) {
            x.i("WSThreeSegmentClickHelper", "\u5df2\u5b89\u88c5\u62c9\u65b0\uff0c\u5982\u679c\u672a\u8df3\u8f6c\uff0c\u5219\u4e0b\u53d1\u7684\u8df3\u8f6cscheme\u4e3a\u7a7a");
            stSimpleMetaFeed e17 = itemData != null ? itemData.e() : null;
            if (e17 == null) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.U(fragment.getFrom(), fragment.getPlayScene(), position, 1000003, itemData, isBigCard, f81884a.b(isHighLight, location));
            q.c(fragment, e17);
            return;
        }
        if (com.tencent.biz.pubaccount.weishi.util.a.c(fragment.getContext())) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.U(fragment.getFrom(), fragment.getPlayScene(), position, 1000009, itemData, isBigCard, f81884a.b(isHighLight, location));
            com.tencent.biz.pubaccount.weishi.util.a.b(fragment.getContext());
            if (itemData != null && (e16 = itemData.e()) != null && (stacquisitioninfo = e16.acquisitionInfo) != null && (stbusinessiconinfo = stacquisitioninfo.businessIcon) != null && (stschema = stbusinessiconinfo.schema) != null) {
                str = stschema.schema;
            }
            i00.a.f406985a.a(str);
            return;
        }
        if (g(itemData)) {
            x.i("WSThreeSegmentClickHelper", "\u8df3\u8f6c\u843d\u5730\u9875\uff0c\u5982\u679c\u672a\u8df3\u8f6c\uff0c\u5219\u4e0b\u53d1\u7684\u8df3\u8f6cscheme\u4e3a\u7a7a");
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.U(fragment.getFrom(), fragment.getPlayScene(), position, 1000004, itemData, isBigCard, f81884a.b(isHighLight, location));
            h(fragment, itemData);
        } else {
            x.i("WSThreeSegmentClickHelper", "\u5f53\u524d\u9875\u9762\u4e0b\u8f7d");
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.U(fragment.getFrom(), fragment.getPlayScene(), position, 1000002, itemData, isBigCard, f81884a.b(isHighLight, location));
            f(fragment, z16, itemData);
        }
    }
}
