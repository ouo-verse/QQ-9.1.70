package com.tencent.mobileqq.zplan.sharedengine.part;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.sharedengine.ZPlanShareEngineScene;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class QQSettingMeZPlanFilamentPart$onInitView$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ QQSettingMeZPlanFilamentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeZPlanFilamentPart$onInitView$3(QQSettingMeZPlanFilamentPart qQSettingMeZPlanFilamentPart) {
        super(1);
        this.this$0 = qQSettingMeZPlanFilamentPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQSettingMeZPlanFilamentPart this$0, boolean z16, Ref.LongRef jumpDelayTime) {
        float f16;
        float f17;
        View view;
        View view2;
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpDelayTime, "$jumpDelayTime");
        ZPlanShareEngineScene zPlanShareEngineScene = this$0.currScene;
        if (zPlanShareEngineScene != null) {
            zPlanShareEngineScene.dynamicJumpType(2);
        }
        Bundle bundle = new Bundle();
        if (z16) {
            wk0.a aVar = this$0.filamentNativeApp;
            bundle.putInt(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID, aVar != null ? aVar.A() : 0);
            f17 = this$0.cameraProgress;
            if (f17 >= 1.0f) {
                view = this$0.filamentTextureView;
                TextureView textureView = view instanceof TextureView ? (TextureView) view : null;
                if (textureView != null && textureView.isAvailable()) {
                    view2 = this$0.filamentTextureView;
                    TextureView textureView2 = view2 instanceof TextureView ? (TextureView) view2 : null;
                    Bitmap bitmap = textureView2 != null ? textureView2.getBitmap() : null;
                    if (bitmap != null) {
                        imageView = this$0.loadingImageView;
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        imageView2 = this$0.loadingImageView;
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                        }
                    }
                    QLog.i("QQSettingMeZPlanFilamentPart", 1, "onInitView show loading imageview before go to portal, bitmap.width=" + (bitmap != null ? Integer.valueOf(bitmap.getWidth()) : null) + ", bitmap.height=" + (bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null));
                }
            }
            QLog.w("QQSettingMeZPlanFilamentPart", 1, "TextureView unavailable");
        }
        IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iZootopiaApi.startPortalActivity(activity, ZootopiaSource.INSTANCE.a(Source.DRAWER_PORTAL), bundle);
        this$0.getActivity().overridePendingTransition(0, 0);
        f16 = this$0.cameraProgress;
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onInitView go to portal, hasFirstFrame=" + z16 + ", cameraProgress=" + f16 + ", jumpDelayTime=" + jumpDelayTime.element);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        AtomicBoolean firstRenderEnd;
        final boolean z16 = false;
        if (num != null && num.intValue() == 2) {
            this.this$0.ma(2);
            ZPlanShareEngineScene zPlanShareEngineScene = this.this$0.currScene;
            if (zPlanShareEngineScene != null && (firstRenderEnd = zPlanShareEngineScene.getFirstRenderEnd()) != null && firstRenderEnd.get()) {
                z16 = true;
            }
            final Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = z16 ? this.this$0.qa() : 0L;
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQSettingMeZPlanFilamentPart qQSettingMeZPlanFilamentPart = this.this$0;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeZPlanFilamentPart$onInitView$3.b(QQSettingMeZPlanFilamentPart.this, z16, longRef);
                }
            }, longRef.element);
            return;
        }
        if (num != null && num.intValue() == 0) {
            this.this$0.ma(0);
        }
    }
}
