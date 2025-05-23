package com.qzone.proxy.feedcomponent.service;

import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f50518c;

    /* renamed from: d, reason: collision with root package name */
    static final Object f50519d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, CustomPraiseData> f50520a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    ZipLoadedListener f50521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.proxy.feedcomponent.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0428a implements ZipLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomPraiseData f50522a;

        C0428a(CustomPraiseData customPraiseData) {
            this.f50522a = customPraiseData;
        }

        @Override // cooperation.qzone.zipanimate.ZipLoadedListener
        public void onZipLoaded(boolean z16) {
            a.this.f50520a.put(Integer.valueOf(this.f50522a.itemId), this.f50522a);
        }
    }

    a() {
    }

    public static a b() {
        if (f50518c == null) {
            synchronized (f50519d) {
                if (f50518c == null) {
                    f50518c = new a();
                }
            }
        }
        return f50518c;
    }

    public void d(CellDecorateInfo.CellCustomPraise cellCustomPraise) {
        int i3;
        if (cellCustomPraise == null || (i3 = cellCustomPraise.iItemId) <= 0 || this.f50520a.containsKey(Integer.valueOf(i3))) {
            return;
        }
        ZipDrawableLoaderInterface zipDrawableLoader = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(FeedGlobalEnv.getContext());
        CustomPraiseData createFrom = CustomPraiseData.createFrom(cellCustomPraise);
        if (createFrom == null) {
            return;
        }
        if (this.f50521b == null) {
            this.f50521b = new C0428a(createFrom);
        }
        zipDrawableLoader.setZipLoadedListener(this.f50521b);
        zipDrawableLoader.setDrawableData(createFrom.praiseZipUrl, -1, false);
        ImageLoader.getInstance().loadImage(createFrom.praiseIconImageUrl, createFrom.praiseIconUrl, (ImageLoader.Options) null);
        ImageLoader.getInstance().loadImage(createFrom.strPraiseListImageUrl, createFrom.strPraiseListPic, (ImageLoader.Options) null);
    }

    public CustomPraiseData c(CellDecorateInfo.CellCustomPraise cellCustomPraise) {
        if (cellCustomPraise == null) {
            return null;
        }
        if (this.f50520a.containsKey(Integer.valueOf(cellCustomPraise.iItemId))) {
            return this.f50520a.get(Integer.valueOf(cellCustomPraise.iItemId));
        }
        if (cellCustomPraise.iItemId <= 0) {
            return null;
        }
        d(cellCustomPraise);
        if (this.f50520a.containsKey(Integer.valueOf(cellCustomPraise.iItemId))) {
            return this.f50520a.get(Integer.valueOf(cellCustomPraise.iItemId));
        }
        return null;
    }
}
