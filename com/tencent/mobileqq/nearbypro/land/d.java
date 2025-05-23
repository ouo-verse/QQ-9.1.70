package com.tencent.mobileqq.nearbypro.land;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.f;
import com.tencent.mobileqq.nearbypro.utils.ToStringExKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u001c\u0010\u001e\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/d;", "Lcom/tencent/mobileqq/nearbypro/land/i;", "Landroid/view/View;", "targetView", "Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "mode", "Landroid/animation/Animator;", "G9", "", "H9", "", "imagePath", "K9", "Landroid/widget/ImageView;", "url", "J9", "clickedView", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "M9", "Leb2/a;", "clickedData", "Landroid/view/MotionEvent;", "clickEvent", "", "A9", "action", "", "args", "handleBroadcastMessage", "update", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, tl.h.F, "Ljava/lang/String;", "curBgUrl", "i", "Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "curMode", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curBgUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LandMode curMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float C = ScreenUtil.SCREEN_WIDTH * 0.4f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/d$a;", "", "", "AREA_WIDTH_PX", UserInfo.SEX_FEMALE, "a", "()F", "", "ANIM_DURATION_MILLISECOND", "J", "SMALL_MODE_SCALE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.land.d$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return d.C;
        }

        Companion() {
        }
    }

    public d() {
        super(R.id.sv5);
        this.curBgUrl = "";
        this.curMode = LandMode.BIG;
    }

    private final Animator G9(View targetView, LandMode mode) {
        if (mode == LandMode.SMALL) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_X, 0.6f));
            animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_Y, 0.6f));
            animatorSet.setDuration(300L);
            return animatorSet;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_X, 1.0f));
        animatorSet2.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_Y, 1.0f));
        animatorSet2.setDuration(300L);
        return animatorSet2;
    }

    private final void H9() {
        Object firstOrNull;
        String str;
        qp4.c[] cVarArr = x9().getAreaInfo().f429199c;
        Intrinsics.checkNotNullExpressionValue(cVarArr, "areaParam.areaInfo.background");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(cVarArr);
        qp4.c cVar = (qp4.c) firstOrNull;
        String str2 = null;
        if (cVar != null) {
            str = cVar.f429207a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.curBgUrl = str;
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            if (cVar != null) {
                str2 = cVar.f429207a;
            }
            c16.e("AreaBgComponent", "downloadAndProcessBg url=" + str2);
        }
        Option option = Option.obtain().setUrl(this.curBgUrl).setNeedFilterUrl(false);
        com.tencent.mobileqq.nearbypro.base.f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f16.b(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.nearbypro.land.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                d.I9(d.this, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(d this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaBgComponent", "downloadBgImage result=" + loadState.name());
        }
        if (loadState == LoadState.STATE_SUCCESS) {
            String localPath = option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath, "opt.localPath");
            this$0.K9(localPath);
            this$0.curMode = LandMode.BIG;
        }
    }

    private final void J9(ImageView targetView, String url) {
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaBgComponent", "loadDrawable url=" + url);
        }
        Option option = Option.obtain().setUrl(url).setTargetView(targetView).setNeedFilterUrl(false).setFailDrawable(BaseImageUtil.getDefaultFaceDrawable());
        com.tencent.mobileqq.nearbypro.base.f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }

    private final void K9(String imagePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaBgComponent", "handleAreaBg oriWidth=" + i3 + " oriHeight=" + i16 + " AREA_WIDTH_PX=" + C);
        }
        float f16 = C;
        float f17 = f16 / i3;
        float f18 = i16 * f17;
        ga2.a c17 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c17.isColorLevel()) {
            c17.e("AreaBgComponent", "handleAreaBg shownWidth=" + f16 + " shownHeight=" + f18 + " scaleRatio=" + f17);
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams((int) f16, (int) f18));
        J9(imageView, imagePath);
        ViewGroup viewGroup = this.container;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.addView(imageView);
    }

    private final void L9(View clickedView) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setElementId(clickedView, "em_nearby_square_icon");
        hashMap.put("nearby_square_type", NtFaceConstant.SMALL);
        VideoReport.reportEvent("dt_clck", clickedView, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    @Override // com.tencent.mobileqq.nearbypro.land.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean A9(@NotNull eb2.a clickedData, @NotNull MotionEvent clickEvent) {
        Object firstOrNull;
        String str;
        boolean z16;
        ga2.a c16;
        ViewGroup viewGroup;
        boolean z17;
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        int i3 = x9().getAreaInfo().f429197a;
        ViewGroup viewGroup2 = null;
        long roomId = ((za2.c) getViewModel(getPartHost(), null, za2.c.class)).getRoomId();
        qp4.b[] bVarArr = x9().getAreaInfo().f429200d;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "areaParam.areaInfo.attachment");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
        qp4.b bVar = (qp4.b) firstOrNull;
        if (bVar != null) {
            str = bVar.f429205c;
        } else {
            str = null;
        }
        if (str != null) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    str = URLEncoder.encode(str, "utf-8");
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Long.valueOf(roomId);
                if (str == null) {
                    str = "";
                }
                objArr[2] = str;
                String format = String.format("mqqapi://zplan/enterChatLand?appId=%s&roomId=%s&source=6&jump_url=%s", Arrays.copyOf(objArr, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                if (c16.isColorLevel()) {
                    c16.e("AreaBgComponent", "jump_detail scheme=" + format);
                }
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iZPlanApi.launchScheme(context, format);
                viewGroup = this.container;
                if (viewGroup != null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                } else {
                    viewGroup2 = viewGroup;
                }
                L9(viewGroup2);
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(i3);
        objArr2[1] = Long.valueOf(roomId);
        if (str == null) {
        }
        objArr2[2] = str;
        String format2 = String.format("mqqapi://zplan/enterChatLand?appId=%s&roomId=%s&source=6&jump_url=%s", Arrays.copyOf(objArr2, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
        }
        IZPlanApi iZPlanApi2 = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        iZPlanApi2.launchScheme(context2, format2);
        viewGroup = this.container;
        if (viewGroup != null) {
        }
        L9(viewGroup2);
        return true;
    }

    public void M9(@NotNull LandMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.curMode != mode) {
            ViewGroup viewGroup = this.container;
            View view = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                viewGroup = null;
            }
            Object parent = viewGroup.getParent().getParent();
            if (parent instanceof View) {
                view = (View) parent;
            }
            if (view != null) {
                G9(view, mode).start();
                this.curMode = mode;
                x9().d(mode);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "MSG_ON_CAMERA_ZOOM_UPDATE") && (args instanceof CameraPosition)) {
            if (((CameraPosition) args).zoom > ab2.a.f25767a.p()) {
                M9(LandMode.BIG);
            } else {
                M9(LandMode.SMALL);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.sv5);
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        this.container = viewGroup;
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaBgComponent", "onInitView curMode=" + this.curMode + " config=" + ToStringExKt.b(x9()));
        }
        H9();
        M9(x9().getMode());
    }

    @Override // com.tencent.mobileqq.nearbypro.land.i
    public void update() {
        Object orNull;
        String str;
        qp4.c[] cVarArr = x9().getAreaInfo().f429199c;
        Intrinsics.checkNotNullExpressionValue(cVarArr, "areaParam.areaInfo.background");
        orNull = ArraysKt___ArraysKt.getOrNull(cVarArr, 0);
        qp4.c cVar = (qp4.c) orNull;
        String str2 = this.curBgUrl;
        String str3 = null;
        if (cVar != null) {
            str = cVar.f429207a;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str2, str)) {
            if (cVar != null) {
                str3 = cVar.f429207a;
            }
            if (str3 == null) {
                str3 = "";
            }
            this.curBgUrl = str3;
            H9();
            M9(x9().getMode());
        }
    }
}
