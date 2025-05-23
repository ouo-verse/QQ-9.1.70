package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WaterMarkDataManager;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a*\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u001a@\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u001a>\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u001a.\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/dr;", "delegate", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "fragment", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", "", "f", "Landroid/content/Context;", "context", "winkEditorFragment", "winkTavCut", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "dataSourceList", "g", "", "", "watermarkModel", tl.h.F, "Landroid/app/Activity;", "originModelList", "Landroid/util/Pair;", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "k", "", "j", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkApplyStickerMaterialTaskKt {
    public static final /* synthetic */ void c(Context context, MetaMaterial metaMaterial, WinkEditorFragment winkEditorFragment, dr drVar, List list, WinkEditPerformanceViewModel winkEditPerformanceViewModel) {
        g(context, metaMaterial, winkEditorFragment, drVar, list, winkEditPerformanceViewModel);
    }

    public static final void f(dr drVar, WinkEditorFragment winkEditorFragment, MetaMaterial metaMaterial, WinkEditPerformanceViewModel winkEditPerformanceViewModel) {
        long durationUs = drVar.getDurationUs();
        if (Intrinsics.areEqual(m.J(metaMaterial), "qq_emoticon_sticker")) {
            if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(metaMaterial), "qq_favorite_sticker")) {
                l.h(metaMaterial, drVar, winkEditorFragment);
                return;
            } else {
                l.g(metaMaterial, drVar, winkEditorFragment);
                return;
            }
        }
        l.j(metaMaterial, drVar, winkEditorFragment, 0L, durationUs);
    }

    public static final void g(final Context context, final MetaMaterial metaMaterial, final WinkEditorFragment winkEditorFragment, final dr drVar, final List<WatermarkDataSourceModel> list, final WinkEditPerformanceViewModel winkEditPerformanceViewModel) {
        l73.a.f413927a.d(metaMaterial);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        final Pair<QCircleCommonLoadingDialog, String> k3 = k((Activity) context, list);
        final com.tencent.mobileqq.wink.editor.subtitle.source.a l3 = WaterMarkDataManager.f321551a.l(new PropertyReference0Impl(winkEditorFragment) { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.WinkApplyStickerMaterialTaskKt$applyWatermark$cancelable$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((WinkEditorFragment) this.receiver).Dk();
            }
        }, winkEditorFragment, drVar, list, new Function2<Map<String, ? extends WatermarkDataSourceModel>, Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.WinkApplyStickerMaterialTaskKt$applyWatermark$cancelable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends WatermarkDataSourceModel> map, Throwable th5) {
                invoke2((Map<String, WatermarkDataSourceModel>) map, th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Map<String, WatermarkDataSourceModel> map, @Nullable Throwable th5) {
                int j3;
                Object obj;
                Pair<QCircleCommonLoadingDialog, String> pair = k3;
                if (pair != null && (obj = pair.first) != null) {
                    Intrinsics.checkNotNull(obj);
                    if (((QCircleCommonLoadingDialog) obj).isShowing()) {
                        Object obj2 = k3.first;
                        Intrinsics.checkNotNull(obj2);
                        ((QCircleCommonLoadingDialog) obj2).dismiss();
                    }
                }
                if (th5 == null && map != null && !map.isEmpty()) {
                    WinkApplyStickerMaterialTaskKt.h(drVar, winkEditorFragment, metaMaterial, map, winkEditPerformanceViewModel);
                    return;
                }
                w53.b.d("wink_sticker_TextMetaMaterial", "onApplyMaterialLocal: watermark fail", th5);
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                j3 = WinkApplyStickerMaterialTaskKt.j((Activity) context2, list);
                if (j3 != -1) {
                    if (j3 == R.string.f239897np) {
                        com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_GET_FAIL_TOAST, WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_LOADING_WINDOWS_TYPE, "location");
                    } else if (j3 == R.string.f239907nq) {
                        com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_GET_FAIL_TOAST, WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_LOADING_WINDOWS_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_PASTE_LOADING_WINDOWS_TYPE_PERSONAL_INFO);
                    }
                    QQToast.makeText(context, j3, 1).show();
                }
            }
        });
        if (k3 != null && k3.first != null) {
            if (Intrinsics.areEqual(k3.second, LightConstants.DataSourceKey.LOCATION)) {
                com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_LOADING_WINDOWS, WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_LOADING_WINDOWS_TYPE, "location");
            } else if (Intrinsics.areEqual(k3.second, LightConstants.DataSourceKey.USER_INFO)) {
                com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_LOADING_WINDOWS, WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_LOADING_WINDOWS_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_PASTE_LOADING_WINDOWS_TYPE_PERSONAL_INFO);
            }
            Object obj = k3.first;
            Intrinsics.checkNotNull(obj);
            ((QCircleCommonLoadingDialog) obj).s0(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.e
                @Override // java.lang.Runnable
                public final void run() {
                    WinkApplyStickerMaterialTaskKt.i(com.tencent.mobileqq.wink.editor.subtitle.source.a.this);
                }
            });
        }
    }

    public static final void h(dr drVar, WinkEditorFragment winkEditorFragment, MetaMaterial metaMaterial, final Map<String, WatermarkDataSourceModel> map, WinkEditPerformanceViewModel winkEditPerformanceViewModel) {
        l.k(metaMaterial, drVar, winkEditorFragment, 0L, drVar.getDurationUs(), new Function1<WinkStickerModel, WinkStickerModel>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.WinkApplyStickerMaterialTaskKt$applyWatermark$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final WinkStickerModel invoke(@NotNull WinkStickerModel stickerModel) {
                Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
                return stickerModel.copyAndUpdateWatermark(map);
            }
        });
    }

    public static final void i(com.tencent.mobileqq.wink.editor.subtitle.source.a cancelable) {
        Intrinsics.checkNotNullParameter(cancelable, "$cancelable");
        cancelable.cancel();
    }

    public static final int j(Activity activity, List<WatermarkDataSourceModel> list) {
        Iterator<WatermarkDataSourceModel> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String str = it.next().dataKey;
            if (Intrinsics.areEqual(str, LightConstants.DataSourceKey.LOCATION)) {
                i3 = R.string.f239897np;
            } else if (Intrinsics.areEqual(str, LightConstants.DataSourceKey.USER_INFO)) {
                i3 = R.string.f239907nq;
            }
            if (i3 != 0) {
                return i3;
            }
        }
        return -1;
    }

    private static final Pair<QCircleCommonLoadingDialog, String> k(Activity activity, List<WatermarkDataSourceModel> list) {
        Iterator<WatermarkDataSourceModel> it = list.iterator();
        int i3 = 0;
        String str = null;
        while (it.hasNext()) {
            str = it.next().dataKey;
            if (Intrinsics.areEqual(str, LightConstants.DataSourceKey.LOCATION)) {
                i3 = R.string.f239917nr;
            } else if (Intrinsics.areEqual(str, LightConstants.DataSourceKey.USER_INFO)) {
                i3 = R.string.f239927ns;
            }
            if (i3 != 0) {
                break;
            }
        }
        if (i3 == 0) {
            return null;
        }
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(activity).p(activity.getString(i3)).a();
        try {
            a16.show();
        } catch (Exception e16) {
            w53.b.d("wink_sticker_TextMetaMaterial", "showCommonWatermarkApplyLoading", e16);
        }
        return Pair.create(a16, str);
    }
}
