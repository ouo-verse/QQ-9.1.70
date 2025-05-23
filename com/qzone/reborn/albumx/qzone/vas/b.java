package com.qzone.reborn.albumx.qzone.vas;

import androidx.core.util.Consumer;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$PhotoInfo;
import qzone.QZonePhotoDegrade$QueryPhotoListRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 /2\u00020\u0001:\u0002\u0011\u0013B\u0007\u00a2\u0006\u0004\b2\u00103J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t0 j\b\u0012\u0004\u0012\u00020\t`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010&\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010$\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/b;", "Lcom/qzone/reborn/layer/part/a;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "Lqzone/QZonePhotoDegrade$PhotoInfo;", "mediaList", "", "d", "Lcom/qzone/reborn/albumx/qzone/vas/b$b;", "listener", "e", "j", "f", "Landroidx/core/util/Consumer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "datas", "a", "", "b", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/bean/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "photoList", "", "Ljava/lang/String;", "lastCookie", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "listeners", "I", "maxSize", "Z", "isEnd", "g", "isRequestAlbum", "()Z", h.F, "(Z)V", "getRequestStatus", "()I", "i", "(I)V", "requestStatus", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b implements com.qzone.reborn.layer.part.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<com.qzone.reborn.albumx.common.bean.a> photoList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String lastCookie = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd", Locale.getDefault());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashSet<InterfaceC0449b> listeners = new HashSet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestAlbum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int requestStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/b$b;", "", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/bean/a;", "Lkotlin/collections/ArrayList;", "photoList", "hasLoadMore", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.qzone.vas.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public interface InterfaceC0449b {
        void a(boolean isSuccess, ArrayList<com.qzone.reborn.albumx.common.bean.a> photoList, boolean hasLoadMore);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/qzone/reborn/albumx/qzone/vas/b$c", "Lcom/qzone/reborn/albumx/qzone/vas/b$b;", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/bean/a;", "Lkotlin/collections/ArrayList;", "photoList", "hasLoadMore", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements InterfaceC0449b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Consumer<List<RFWLayerItemMediaInfo>> f52778b;

        c(Consumer<List<RFWLayerItemMediaInfo>> consumer) {
            this.f52778b = consumer;
        }

        @Override // com.qzone.reborn.albumx.qzone.vas.b.InterfaceC0449b
        public void a(boolean isSuccess, ArrayList<com.qzone.reborn.albumx.common.bean.a> photoList, boolean hasLoadMore) {
            Intrinsics.checkNotNullParameter(photoList, "photoList");
            b.this.j(this);
            if (isSuccess) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = photoList.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(com.qzone.reborn.albumx.qzone.vas.c.c((com.qzone.reborn.albumx.common.bean.a) it.next()));
                }
                this.f52778b.accept(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QZonePhotoDegrade$QueryPhotoListRsp qZonePhotoDegrade$QueryPhotoListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z18 = z17 && j3 == 0;
        if (z18) {
            String str2 = qZonePhotoDegrade$QueryPhotoListRsp.cookie.get();
            Intrinsics.checkNotNullExpressionValue(str2, "rsq.cookie.get()");
            this$0.lastCookie = str2;
            this$0.maxSize = qZonePhotoDegrade$QueryPhotoListRsp.total.get();
            this$0.isEnd = qZonePhotoDegrade$QueryPhotoListRsp.is_end.get();
            List<QZonePhotoDegrade$PhotoInfo> list = qZonePhotoDegrade$QueryPhotoListRsp.photos.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsq.photos.get()");
            this$0.d(z16, list);
        } else {
            com.tencent.xaction.log.b.a("QZoneAlbumExpirePicRepo", 1, "requestExpireData fail");
        }
        Object[] array = this$0.listeners.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "array");
        for (Object obj : array) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzone.vas.QZoneAlbumExpirePicRepo.RequestListener");
            ((InterfaceC0449b) obj).a(z18, this$0.photoList, !this$0.isEnd);
        }
    }

    @Override // com.qzone.reborn.layer.part.a
    public void a(Consumer<List<RFWLayerItemMediaInfo>> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        e(new c(datas));
        f(true);
    }

    @Override // com.qzone.reborn.layer.part.a
    /* renamed from: b, reason: from getter */
    public int getMaxSize() {
        return this.maxSize;
    }

    public final void e(InterfaceC0449b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void f(final boolean isLoadMore) {
        String str;
        if (this.isRequestAlbum) {
            return;
        }
        if (isLoadMore && this.isEnd) {
            com.tencent.xaction.log.b.a("QZoneAlbumExpirePicRepo", 1, "requestExpireData is End");
            return;
        }
        this.isRequestAlbum = true;
        int i3 = this.requestStatus;
        if (isLoadMore) {
            str = this.lastCookie;
        } else {
            str = "";
        }
        VSNetworkHelper.getInstance().sendRequest(new QueryPhotoListRequest(i3, 20, str), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.albumx.qzone.vas.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                b.g(b.this, isLoadMore, baseRequest, z16, j3, str2, (QZonePhotoDegrade$QueryPhotoListRsp) obj);
            }
        });
    }

    public final void h(boolean z16) {
        this.isRequestAlbum = z16;
    }

    public final void i(int i3) {
        this.requestStatus = i3;
    }

    public final void j(InterfaceC0449b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    private final void d(boolean isLoadMore, List<QZonePhotoDegrade$PhotoInfo> mediaList) {
        Object obj;
        if (!isLoadMore) {
            this.photoList.clear();
        }
        for (QZonePhotoDegrade$PhotoInfo qZonePhotoDegrade$PhotoInfo : mediaList) {
            String month = this.dateFormat.format(new Date(qZonePhotoDegrade$PhotoInfo.create_time.get() * 1000));
            Iterator<T> it = this.photoList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((com.qzone.reborn.albumx.common.bean.a) obj).getTimeId(), month)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            com.qzone.reborn.albumx.common.bean.a aVar = (com.qzone.reborn.albumx.common.bean.a) obj;
            if (aVar == null) {
                CommonBatchInfo commonBatchInfo = new CommonBatchInfo();
                Intrinsics.checkNotNullExpressionValue(month, "month");
                commonBatchInfo.w(month);
                aVar = new com.qzone.reborn.albumx.common.bean.a(commonBatchInfo);
                aVar.k(month);
                this.photoList.add(aVar);
            }
            List<CommonStMedia> j3 = aVar.getBatchInfo().j();
            CommonStMedia commonStMedia = new CommonStMedia();
            commonStMedia.y(com.qzone.reborn.albumx.qzone.vas.c.a(qZonePhotoDegrade$PhotoInfo));
            j3.add(commonStMedia);
        }
    }
}
