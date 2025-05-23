package ha;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenTitleBarHeaderView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lha/b;", "Landroid/app/Dialog;", "", ExifInterface.LATITUDE_SOUTH, "W", BdhLogUtil.LogTag.Tag_Req, "initWindow", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "show", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mHalfScreenFloatingView", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;", "D", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;", "mContainer", "Lha/b$b;", "E", "Lha/b$b;", "getMOnDismissListener", "()Lha/b$b;", "X", "(Lha/b$b;)V", "mOnDismissListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mHalfScreenFloatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneAlbumxLocalPhotoScanAuthorizeWidgetView mContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private InterfaceC10426b mOnDismissListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lha/b$b;", "", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ha.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10426b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"ha/b$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends e {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ha/b$c$a", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;", "Landroid/view/View;", "view", "", "hasConfirm", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f404604a;

            a(b bVar) {
                this.f404604a = bVar;
            }

            @Override // com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.b
            public void a(View view, boolean hasConfirm) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (!hasConfirm) {
                    this.f404604a.R();
                } else {
                    this.f404604a.dismiss();
                }
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF58528d() {
            b bVar = b.this;
            Context context = b.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bVar.mContainer = new QZoneAlbumxLocalPhotoScanAuthorizeWidgetView(context);
            QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = b.this.mContainer;
            Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoScanAuthorizeWidgetView);
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView.setMOnViewClickListener(new a(b.this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2 = b.this.mContainer;
            Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2);
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2.setLayoutParams(layoutParams);
            ga.a aVar = new ga.a();
            aVar.e("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/weinituijian-first-frame.png");
            aVar.d("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/weinituijian-shouquan-animation.png");
            aVar.f(2);
            QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3 = b.this.mContainer;
            Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3);
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3.setData(aVar);
            QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView4 = b.this.mContainer;
            Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoScanAuthorizeWidgetView4);
            return qZoneAlbumxLocalPhotoScanAuthorizeWidgetView4;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return (int) (pl.a.f426446a.n(b.this.getContext()) * 0.6d);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QZoneAlbumxLocalPhotoScanAuthorizeDialog", 1, "[onDismiss]");
        this$0.dismiss();
    }

    private final void W() {
        QUSHalfScreenTitleBarHeaderView qUSHalfScreenTitleBarHeaderView = new QUSHalfScreenTitleBarHeaderView(getContext());
        qUSHalfScreenTitleBarHeaderView.setTitle("");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenTitleBarHeaderView.setHalfScreenView(qUSHalfScreenFloatingView);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView3;
        }
        qUSHalfScreenFloatingView2.setHeaderView(qUSHalfScreenTitleBarHeaderView);
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZoneAlbumxLocalPhotoScanAuthorizeDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public final void X(InterfaceC10426b interfaceC10426b) {
        this.mOnDismissListener = interfaceC10426b;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(R.layout.f1291359);
        S();
        W();
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = this.mContainer;
        if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView != null) {
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        QLog.d("QZoneAlbumxLocalPhotoScanAuthorizeDialog", 1, "[handleBtnClick]");
        InterfaceC10426b interfaceC10426b = this.mOnDismissListener;
        if (interfaceC10426b != null) {
            interfaceC10426b.a();
        }
    }

    private final void S() {
        View findViewById = findViewById(R.id.miy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.mHalfScreenFloatingView = qUSHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView4;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: ha.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                b.U(b.this);
            }
        });
    }
}
