package com.tencent.state.square.location;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/location/LocationDialogTips;", "", "()V", "BG_RES_ID", "", "CONTENT_MARGIN_BOTTOM", "LOGO_IMG_BOTTOM_MARGIN", "LOGO_IMG_HEIGHT_DP", "LOGO_IMG_PADDING", "LOGO_IMG_WIDTH_DP", "TAG", "", "WELCOME_IMG_URL", "loadImg", "", "context", "Landroid/content/Context;", "done", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "reportClick", "type", "showDialog", "handler", "Lcom/tencent/state/square/location/IGuide;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LocationDialogTips {
    private static final int CONTENT_MARGIN_BOTTOM = -20;
    private static final int LOGO_IMG_BOTTOM_MARGIN = -80;
    private static final int LOGO_IMG_HEIGHT_DP = 180;
    private static final int LOGO_IMG_PADDING = 65;
    private static final int LOGO_IMG_WIDTH_DP = 180;
    private static final String TAG = "ChatLandDialogTips";
    private static final String WELCOME_IMG_URL = "https://cdn.meta.qq.com/square/dialog/location_dialog_head2.webp";
    public static final LocationDialogTips INSTANCE = new LocationDialogTips();
    private static final int BG_RES_ID = R.drawable.gud;

    LocationDialogTips() {
    }

    private final void loadImg(final Context context, final Function1<? super Drawable, Unit> done) {
        ImageLoader loader = ImageService.INSTANCE.getLoader();
        if (loader != null) {
            loader.loadImage(WELCOME_IMG_URL, new ImageSize(180, 180), new SimpleImageLoadingListener() { // from class: com.tencent.state.square.location.LocationDialogTips$loadImg$1
                @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    Function1.this.invoke(new BitmapDrawable(context.getResources(), loadedImage));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportClick(int type) {
        Map<String, Object> mutableMapOf;
        IReporter reporter = Square.INSTANCE.getConfig().getReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_button_display_type", Integer.valueOf(type)));
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LOCATION_POPUP_WINDOW, mutableMapOf);
    }

    public final void showDialog(final Context context, final IGuide handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (context != null) {
            loadImg(context, new Function1<Drawable, Unit>() { // from class: com.tencent.state.square.location.LocationDialogTips$showDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Drawable logo) {
                    int i3;
                    Map<String, Object> mutableMapOf;
                    Intrinsics.checkNotNullParameter(logo, "logo");
                    Context context2 = context;
                    LocationDialogTips locationDialogTips = LocationDialogTips.INSTANCE;
                    i3 = LocationDialogTips.BG_RES_ID;
                    ResStyle resStyle = new ResStyle(null, null, logo, 0, 0, Integer.valueOf(ViewExtensionsKt.dip(context, 65)), Integer.valueOf(ViewExtensionsKt.dip(context, -80)), null, Integer.valueOf(i3), 154, null);
                    String string = context.getString(R.string.xgo);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026re_location_dialog_title)");
                    String string2 = context.getString(R.string.xcg);
                    String string3 = context.getString(R.string.xgm);
                    String string4 = context.getString(R.string.xgn);
                    Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026ocation_dialog_sub_title)");
                    CommonDialog commonDialog = new CommonDialog(context2, new CommonDialogData(resStyle, string, string2, string3, null, new ContentStyle(string4, 0.0f, 0, false, 80, null, Integer.valueOf(ViewExtensionsKt.dip(context, -20)), 46, null), null, false, null, false, 960, null));
                    commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.location.LocationDialogTips$showDialog$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i16) {
                            if (i16 == 1) {
                                LocationDialogTips.INSTANCE.reportClick(0);
                            } else {
                                if (i16 != 2) {
                                    return;
                                }
                                LocationDialogTips.INSTANCE.reportClick(1);
                                handler.onGuideHide();
                            }
                        }
                    });
                    commonDialog.show();
                    IReporter reporter = Square.INSTANCE.getConfig().getReporter();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
                    reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LOCATION_POPUP_WINDOW, mutableMapOf);
                }
            });
        }
    }
}
