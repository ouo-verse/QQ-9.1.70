package ld3;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.scene.component.base.FromLifeCycle;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.UploadQualityReportBuilder;
import dy4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 32\u00020\u0001:\u00014B\u0011\u0012\b\b\u0002\u00100\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\"\u0010\u001e\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u001a\u0010 \u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\u0006H\u0014J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0014J\n\u0010&\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u0004\u0018\u00010#R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lld3/c;", "Lmd3/a;", "", "X", "Z", "W", "Landroid/view/View;", "p4", "Lod3/a;", "scene", "gh", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, UserInfo.SEX_FEMALE, "", "success", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "Landroid/view/Surface;", "surface", "", "width", "height", "b", "textureView", "U", "resInt", "a0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b0", "v4", "G", "c0", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "bgView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "zplanTextureView", "needInitDress", "<init>", "(Z)V", BdhLogUtil.LogTag.Tag_Req, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class c extends md3.a {

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView bgView;

    /* renamed from: Q, reason: from kotlin metadata */
    private View zplanTextureView;

    public c(boolean z16) {
        super(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W();
    }

    private final void W() {
        QLog.i("ZPlanPortalComponentAvatar", 1, "onEngineInitSuccess in. zplanTextureView:" + this.zplanTextureView);
        FragmentActivity attachedActivity = getAttachedActivity();
        if (attachedActivity != null && this.zplanTextureView == null) {
            dy4.a J = J();
            View a16 = a.C10207a.a(J, attachedActivity, attachedActivity, true, false, false, 16, null);
            J.setRenderListener(this);
            U(getContainerView(), a16);
            this.zplanTextureView = a16;
            Q(FromLifeCycle.ENGINE_INIT);
        }
    }

    private final void X() {
        FragmentActivity attachedActivity = getAttachedActivity();
        if (attachedActivity != null) {
            attachedActivity.runOnUiThread(new Runnable() { // from class: ld3.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.Y(c.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
    }

    private final void Z() {
        QLog.i("ZPlanPortalComponentAvatar", 1, "removeTextureView in");
        ViewGroup containerView = getContainerView();
        if (containerView != null) {
            containerView.removeView(this.zplanTextureView);
        }
        this.zplanTextureView = null;
        dy4.a zplanRender = getZplanRender();
        if (zplanRender != null) {
            zplanRender.destroy();
        }
        R(null);
        QLog.i("ZPlanPortalComponentAvatar", 1, "removeTextureView end");
    }

    @Override // wb4.a
    public void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        if (LayoutInflater.from(activity).inflate(R.layout.d8q, container, true) == null) {
            return;
        }
        ImageView imageView = (ImageView) container.findViewById(R.id.f163605r12);
        this.bgView = imageView;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).registerZPlanEngineStatusUpdateListener(this);
    }

    @Override // md3.a, wb4.a
    public void G() {
        super.G();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).unRegisterZPlanEngineStatusUpdateListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(ViewGroup container, View textureView) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (container != null) {
            container.removeView(textureView);
            container.addView(textureView, layoutParams);
        }
    }

    public void a0(int resInt) {
        ImageView imageView = this.bgView;
        if (imageView != null) {
            imageView.setImageResource(resInt);
        }
    }

    @Override // md3.a, com.tencent.zplan.world.view.d
    public void b(Surface surface, int width, int height) {
        super.b(surface, width, height);
        View view = this.zplanTextureView;
        QLog.i("ZPlanPortalComponentAvatar", 1, "onSurfaceCreate view:" + view + ", height:" + (view != null ? Integer.valueOf(view.getHeight()) : null) + ",  width:" + (view != null ? Integer.valueOf(view.getWidth()) : null));
    }

    protected void b0(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageView imageView = this.bgView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public final Bitmap c0() {
        QLog.i("ZPlanPortalComponentAvatar", 1, "updateBg in");
        Bitmap v46 = v4();
        if (v46 != null) {
            b0(v46);
            QLog.i("ZPlanPortalComponentAvatar", 1, "updateBg end. bitmap(" + v46.getWidth() + ", " + v46.getHeight() + ")");
        }
        return v46;
    }

    @Override // md3.a, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        super.engineInitFinish(success);
        if (success) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ld3.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.V(c.this);
                }
            });
        }
    }

    public void gh(od3.a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
    }

    @Override // a84.a
    /* renamed from: p4, reason: from getter */
    public View getZplanTextureView() {
        return this.zplanTextureView;
    }

    @Override // md3.a, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        super.serviceConnected(connect);
        QLog.i("ZPlanPortalComponentAvatar", 1, "serviceConnected connect:" + connect);
        if (connect) {
            return;
        }
        X();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap v4() {
        Bitmap bitmap;
        TextureView textureView;
        try {
            View zplanTextureView = getZplanTextureView();
            textureView = zplanTextureView instanceof TextureView ? (TextureView) zplanTextureView : null;
        } catch (OutOfMemoryError unused) {
            QLog.e("ZPlanPortalComponentAvatar", 1, "captureFrame OutOfMemory!");
        }
        if (textureView != null) {
            bitmap = textureView.getBitmap();
            QLog.i("ZPlanPortalComponentAvatar", 1, "captureFrame bitmap.width=" + (bitmap == null ? Integer.valueOf(bitmap.getWidth()) : null) + ", bitmap.height=" + (bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null));
            return bitmap;
        }
        bitmap = null;
        if (bitmap == null) {
        }
        if (bitmap != null) {
        }
        QLog.i("ZPlanPortalComponentAvatar", 1, "captureFrame bitmap.width=" + (bitmap == null ? Integer.valueOf(bitmap.getWidth()) : null) + ", bitmap.height=" + (bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null));
        return bitmap;
    }

    public /* synthetic */ c(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
