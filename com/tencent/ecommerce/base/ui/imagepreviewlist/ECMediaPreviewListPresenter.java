package com.tencent.ecommerce.base.ui.imagepreviewlist;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.pageopener.api.IECMediaSelector;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCameraConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCaptureAbility;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaSelectorConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECTabType;
import com.tencent.ecommerce.base.photobrowser.api.IECPhotoBrowser;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010\u001f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "", "", "g", "", "index", h.F, "i", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "newSelectedMediaList", "k", "j", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECCommentMediaAdapter;", "a", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECCommentMediaAdapter;", "adapter", "", "b", "Ljava/util/List;", "_mediaInfoList", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "d", "I", "maxMediaShowNum", "Lkotlin/Function1;", "e", "Lkotlin/jvm/functions/Function1;", "mediaChangeListener", "f", "()Ljava/util/List;", "mediaInfoList", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "defaultAddBtnText", "<init>", "(Landroid/content/Context;ILandroidx/recyclerview/widget/RecyclerView;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECMediaPreviewListPresenter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ECCommentMediaAdapter adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<ECMediaInfo> _mediaInfoList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int maxMediaShowNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<List<ECMediaInfo>, Unit> mediaChangeListener;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter$a", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "medias", "", "onCameraCaptureResultCallback", "onAlbumSelectedResultCallback", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a implements IECMediaSelector.ECMediaSelectorResultCallback {
        a() {
        }

        @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector.ECMediaSelectorResultCallback
        public void onAlbumSelectedResultCallback(List<ECMediaInfo> medias) {
            ECMediaPreviewListPresenter.this.k(medias);
        }

        @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector.ECMediaSelectorResultCallback
        public void onCameraCaptureResultCallback(List<ECMediaInfo> medias) {
            ECMediaPreviewListPresenter.this.j(medias);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECMediaPreviewListPresenter(Context context, int i3, RecyclerView recyclerView, String str, Function1<? super List<ECMediaInfo>, Unit> function1) {
        int collectionSizeOrDefault;
        this.context = context;
        this.maxMediaShowNum = i3;
        this.mediaChangeListener = function1;
        ECCommentMediaAdapter eCCommentMediaAdapter = new ECCommentMediaAdapter(i3, new ECMediaPreviewListPresenter$adapter$1(this), new ECMediaPreviewListPresenter$adapter$2(this), new ECMediaPreviewListPresenter$adapter$3(this), str);
        this.adapter = eCCommentMediaAdapter;
        this._mediaInfoList = new ArrayList();
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMediaSelector().preLoad(context);
        recyclerView.setAdapter(eCCommentMediaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        List<ECMediaInfo> list = this._mediaInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ECMediaInfo) it.next()).getMediaPath());
        }
        eCCommentMediaAdapter.setData(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        int size = f().size();
        int i3 = this.maxMediaShowNum;
        if (size >= i3) {
            i.f101155b.d(this.context.getString(R.string.wqe, Integer.valueOf(i3)), ECToastIcon.ICON_NONE, 0);
        } else {
            dg0.a.f393682b.openCameraAndMediaSelector(this.context, new ECCameraConfig(ECCaptureAbility.ONLY_PHOTO), new ECMediaSelectorConfig(ECTabType.ONLY_IMAGE, this.maxMediaShowNum - f().size(), null, null, 12, null), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int index) {
        int collectionSizeOrDefault;
        this._mediaInfoList.remove(index);
        ECCommentMediaAdapter eCCommentMediaAdapter = this.adapter;
        List<ECMediaInfo> list = this._mediaInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ECMediaInfo) it.next()).getMediaPath());
        }
        eCCommentMediaAdapter.setData(arrayList);
        Function1<List<ECMediaInfo>, Unit> function1 = this.mediaChangeListener;
        if (function1 != null) {
            function1.invoke(f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int index) {
        int collectionSizeOrDefault;
        IECPhotoBrowser photoBrowser = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPhotoBrowser();
        if (photoBrowser != null) {
            List<ECMediaInfo> list = this._mediaInfoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ECMediaInfo) it.next()).getMediaPath());
            }
            IECPhotoBrowser.a.a(photoBrowser, arrayList, index, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(List<ECMediaInfo> newSelectedMediaList) {
        int collectionSizeOrDefault;
        this._mediaInfoList.addAll(newSelectedMediaList);
        ECCommentMediaAdapter eCCommentMediaAdapter = this.adapter;
        List<ECMediaInfo> list = this._mediaInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ECMediaInfo) it.next()).getMediaPath());
        }
        eCCommentMediaAdapter.setData(arrayList);
        Function1<List<ECMediaInfo>, Unit> function1 = this.mediaChangeListener;
        if (function1 != null) {
            function1.invoke(f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(List<ECMediaInfo> newSelectedMediaList) {
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        for (ECMediaInfo eCMediaInfo : this._mediaInfoList) {
            if (!newSelectedMediaList.contains(eCMediaInfo)) {
                arrayList.add(eCMediaInfo);
            }
        }
        arrayList.addAll(newSelectedMediaList);
        this._mediaInfoList = arrayList;
        ECCommentMediaAdapter eCCommentMediaAdapter = this.adapter;
        ArrayList arrayList2 = arrayList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ECMediaInfo) it.next()).getMediaPath());
        }
        eCCommentMediaAdapter.setData(arrayList3);
        Function1<List<ECMediaInfo>, Unit> function1 = this.mediaChangeListener;
        if (function1 != null) {
            function1.invoke(f());
        }
    }

    public final List<ECMediaInfo> f() {
        List<ECMediaInfo> list;
        list = CollectionsKt___CollectionsKt.toList(this._mediaInfoList);
        return list;
    }
}
