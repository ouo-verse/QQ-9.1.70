package com.tencent.mobileqq.nearbypro.land;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.f;
import com.tencent.mobileqq.nearbypro.utils.ToStringExKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/b;", "Lcom/tencent/mobileqq/nearbypro/land/i;", "Lqp4/b;", "adInfo", "", "H9", "", "adImagePath", "K9", "Lqp4/f;", "coordinate", "", "width", "height", "Landroid/view/ViewGroup$MarginLayoutParams;", "G9", "path", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Leb2/a;", "clickedData", "Landroid/view/MotionEvent;", "clickEvent", "", "A9", "update", "f", "Lqp4/b;", "curAdInfo", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "adView", "<init>", "()V", "i", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends i {

    /* renamed from: m, reason: collision with root package name */
    private static float f253371m = d.INSTANCE.a() * 0.2857143f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qp4.b curAdInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView adView;

    public b() {
        super(R.id.sbl);
    }

    private final ViewGroup.MarginLayoutParams G9(qp4.f coordinate, int width, int height) {
        Object orNull;
        cq4.a aVar = new cq4.a();
        aVar.f391665a = coordinate.f429217a;
        aVar.f391666b = coordinate.f429218b;
        qp4.c[] cVarArr = x9().getAreaInfo().f429199c;
        Intrinsics.checkNotNullExpressionValue(cVarArr, "areaParam.areaInfo.background");
        orNull = ArraysKt___ArraysKt.getOrNull(cVarArr, 0);
        qp4.c cVar = (qp4.c) orNull;
        if (cVar == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("AreaAdComponent", "createLayoutParam tableInfo==null or bigModelAreaBg==null");
            return null;
        }
        Point a16 = com.tencent.mobileqq.nearbypro.utils.a.f253947a.a(cVar, aVar);
        if (a16.x >= 0 && a16.y >= 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(width, height);
            marginLayoutParams.leftMargin = a16.x - (width / 2);
            marginLayoutParams.topMargin = a16.y - (height / 2);
            return marginLayoutParams;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("AreaAdComponent", "posPoint error");
        return null;
    }

    private final void H9(final qp4.b adInfo) {
        this.curAdInfo = adInfo;
        Option option = Option.obtain().setUrl(adInfo.f429203a).setNeedFilterUrl(false);
        com.tencent.mobileqq.nearbypro.base.f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f16.b(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.nearbypro.land.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                b.I9(b.this, adInfo, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(b this$0, qp4.b adInfo, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaAdComponent", "downloadAdImage result=" + loadState.name());
        }
        if (loadState == LoadState.STATE_SUCCESS) {
            String localPath = option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath, "opt.localPath");
            this$0.K9(localPath, adInfo);
            String localPath2 = option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath2, "opt.localPath");
            this$0.J9(localPath2);
        }
    }

    private final void J9(String path) {
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaAdComponent", "loadAdDrawableFromLocal path=" + path);
        }
        Option option = Option.obtain().setLocalPath(path).setTargetView(this.adView).setNeedFilterUrl(false);
        com.tencent.mobileqq.nearbypro.base.f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }

    private final void K9(String adImagePath, qp4.b adInfo) {
        ViewGroup viewGroup;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(adImagePath, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaAdComponent", "handleAdShown oriWidth=" + i3 + " oriHeight=" + i16 + " AD_WIDTH=" + f253371m);
        }
        float f16 = f253371m;
        float f17 = i16 * (f16 / i3);
        ImageView imageView = new ImageView(getContext());
        this.adView = imageView;
        qp4.f fVar = adInfo.f429204b;
        Intrinsics.checkNotNullExpressionValue(fVar, "adInfo.coord");
        imageView.setLayoutParams(G9(fVar, (int) f16, (int) f17));
        View partRootView = getPartRootView();
        if (partRootView != null && (viewGroup = (ViewGroup) partRootView.findViewById(R.id.sbl)) != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.adView);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.land.i
    public boolean A9(@NotNull eb2.a clickedData, @NotNull MotionEvent clickEvent) {
        boolean z16;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        String str3 = null;
        if (c16.isColorLevel()) {
            qp4.b bVar = this.curAdInfo;
            if (bVar != null) {
                str2 = bVar.f429205c;
            } else {
                str2 = null;
            }
            c16.e("AreaAdComponent", "onClickAD jumpUrl=" + str2);
        }
        ImageView imageView = this.adView;
        if (imageView != null && com.tencent.mobileqq.nearbypro.utils.i.b(imageView, clickEvent.getX(), clickEvent.getY())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qp4.b bVar2 = this.curAdInfo;
            if (bVar2 != null) {
                str = bVar2.f429205c;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                qp4.b bVar3 = this.curAdInfo;
                if (bVar3 != null) {
                    str3 = bVar3.f429205c;
                }
                if (str3 == null) {
                    str3 = "";
                }
                iZPlanApi.launchScheme(context, str3);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Object firstOrNull;
        String str;
        super.onInitView(rootView);
        qp4.b[] bVarArr = x9().getAreaInfo().f429200d;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "areaParam.areaInfo.attachment");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
        qp4.b bVar = (qp4.b) firstOrNull;
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            if (bVar != null) {
                str = ToStringExKt.i(bVar);
            } else {
                str = null;
            }
            c16.e("AreaAdComponent", "onInitView adInfo=" + str);
        }
        if (bVar != null) {
            H9(bVar);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.land.i
    public void update() {
        Object firstOrNull;
        super.update();
        qp4.b[] bVarArr = x9().getAreaInfo().f429200d;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "areaParam.areaInfo.attachment");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
        qp4.b bVar = (qp4.b) firstOrNull;
        if (bVar != null) {
            H9(bVar);
        }
    }
}
