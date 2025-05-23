package com.tencent.sqshow.zootopia.friendsdressup.filament;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentNativeAppHelper;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import uk0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001W\u0018\u0000 \f2\u00020\u0001:\u0001!B=\u0012\u0006\u0010#\u001a\u00020\u001d\u0012\u0006\u0010%\u001a\u00020\u001d\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fJ1\u0010\u0014\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\nJ\u001e\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010#\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00100\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\"R\u0016\u00102\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\"R\u0016\u00103\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u00105\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\"R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010B\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010>\u001a\u0004\b4\u0010?\"\u0004\b@\u0010AR$\u0010H\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010D\u001a\u0004\b:\u0010E\"\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010IR\u0016\u0010L\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010;R\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010NR\u001b\u0010S\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010Q\u001a\u0004\b6\u0010RR\u001b\u0010V\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010Q\u001a\u0004\b9\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010X\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\\"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "Landroid/widget/FrameLayout$LayoutParams;", "i", "Landroid/view/View;", "view", "o", "", "ratio", "v", "w", DomainData.DOMAIN_NAME, "", "uin", "headMontagePath", "bodyMontagePath", HippyTKDListViewAdapter.X, "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "loadingCompleted", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "r", "horizontalRatio", "u", "", "newWidth", "newHeight", "y", "a", "I", "rootViewWidth", "b", "screenHeight", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "c", "Ljava/lang/ref/WeakReference;", "rootViewRef", "d", "Ljava/lang/String;", "e", "f", "g", "oldBodyMargin", tl.h.F, "maleMargin", "femaleMargin", "j", "curBodyTypeId", "k", UserInfo.SEX_FEMALE, "NEW_HEIGHT_RATIO", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isResume", "Lwk0/a;", "Lwk0/a;", "()Lwk0/a;", "setFilamentNativeApp", "(Lwk0/a;)V", "filamentNativeApp", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;", "()Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;", "setScene", "(Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;)V", "scene", "Landroid/view/View;", "filamentTextureView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSurfaceCreated", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "avatarContainer", "Landroid/os/Handler;", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "handler", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "loadingView", "com/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper$d", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper$d;", "jsEventListener", "<init>", "(IILjava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FilamentNativeAppHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int rootViewWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int screenHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<ViewGroup> rootViewRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String headMontagePath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String bodyMontagePath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int oldBodyMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int maleMargin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int femaleMargin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int curBodyTypeId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float NEW_HEIGHT_RATIO;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float horizontalRatio;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isResume;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private wk0.a filamentNativeApp;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private FriendsDressUpBusinessScene scene;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private View filamentTextureView;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isSurfaceCreated;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy handler;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadingView;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final d jsEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper$b", "Luk0/c;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements uk0.c {
        b() {
        }

        @Override // uk0.c
        public void a(Surface surface, int i3, int i16) {
            c.a.a(this, surface, i3, i16);
        }

        @Override // uk0.c
        public void b(Surface surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            c.a.b(this, surface, width, height);
            if (FilamentNativeAppHelper.this.isSurfaceCreated) {
                return;
            }
            QLog.i("FilamentNativeAppHelper", 1, "onSurfaceCreate. filamentTextureView.visibility = View.INVISIBLE");
            View view = FilamentNativeAppHelper.this.filamentTextureView;
            if (view != null) {
                view.setVisibility(4);
            }
            FilamentNativeAppHelper.this.isSurfaceCreated = true;
        }

        @Override // uk0.c
        public void onSurfaceDestroyed(Surface surface) {
            c.a.c(this, surface);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper$c", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/h;", "", "bodyTypeId", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements h {
        c() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.filament.h
        public void a(int bodyTypeId) {
            FilamentNativeAppHelper.this.curBodyTypeId = bodyTypeId;
            FilamentNativeAppHelper.this.w();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper$d", "Luk0/e;", "", "type", "eventData", "", "onEvent", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements uk0.e {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FilamentNativeAppHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.z();
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            String str;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "onJsEvent. type: " + type + ", eventData: " + eventData);
            int hashCode = type.hashCode();
            if (hashCode == -1565730423) {
                str = "onFilamentRenderFail";
            } else {
                if (hashCode != 361827844) {
                    if (hashCode == 1621140201 && type.equals("onFirstFrameRenderEnd")) {
                        Handler k3 = FilamentNativeAppHelper.this.k();
                        final FilamentNativeAppHelper filamentNativeAppHelper = FilamentNativeAppHelper.this;
                        k3.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                FilamentNativeAppHelper.d.b(FilamentNativeAppHelper.this);
                            }
                        });
                        return;
                    }
                    return;
                }
                str = "onFirstFrameImageReady";
            }
            type.equals(str);
        }
    }

    public FilamentNativeAppHelper(int i3, int i16, WeakReference<ViewGroup> rootViewRef, String uin, String headMontagePath, String bodyMontagePath) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(rootViewRef, "rootViewRef");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(headMontagePath, "headMontagePath");
        Intrinsics.checkNotNullParameter(bodyMontagePath, "bodyMontagePath");
        this.rootViewWidth = i3;
        this.screenHeight = i16;
        this.rootViewRef = rootViewRef;
        this.uin = uin;
        this.headMontagePath = headMontagePath;
        this.bodyMontagePath = bodyMontagePath;
        this.oldBodyMargin = -((int) (i16 * 0.07d));
        this.maleMargin = -((int) (i16 * 9.0E-4d));
        this.femaleMargin = -((int) (i16 * 0.028f));
        this.NEW_HEIGHT_RATIO = 0.65f;
        this.horizontalRatio = 0.5f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentNativeAppHelper$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.handler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentNativeAppHelper$loadingView$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(BaseApplication.context);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setImageResource(R.drawable.gpd);
                return imageView;
            }
        });
        this.loadingView = lazy2;
        this.jsEventListener = new d();
    }

    private final FrameLayout.LayoutParams i() {
        int coerceAtMost;
        int i3 = (int) (this.screenHeight * this.NEW_HEIGHT_RATIO);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) (i3 * 0.75f), this.rootViewWidth);
        QLog.i("FilamentNativeAppHelper", 1, "createLayoutParamsByRootViewSize use value=" + this.NEW_HEIGHT_RATIO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(coerceAtMost, i3);
        layoutParams.leftMargin = (this.rootViewWidth - coerceAtMost) / 2;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler k() {
        return (Handler) this.handler.getValue();
    }

    private final ImageView l() {
        return (ImageView) this.loadingView.getValue();
    }

    private final void n() {
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "initAvatarContainer ");
        ViewGroup viewGroup = this.rootViewRef.get();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.avatarContainer = new FrameLayout(BaseApplication.context);
        ViewGroup viewGroup2 = this.rootViewRef.get();
        if (viewGroup2 != null) {
            viewGroup2.addView(this.avatarContainer);
        }
    }

    private final void p() {
        int coerceAtMost;
        View view;
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "initJsApp");
        wk0.a b16 = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, 30, null, null, 12, null);
        this.filamentNativeApp = b16;
        if (b16 != null) {
            b16.a(new b());
        }
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.c("onFilamentRenderFail", this.jsEventListener);
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.c("onFirstFrameRenderEnd", this.jsEventListener);
        }
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            aVar3.c("onFirstFrameImageReady", this.jsEventListener);
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) (this.screenHeight * 0.75f * 0.75f), this.rootViewWidth);
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "FriendsDressUpBusinessScene width=" + coerceAtMost);
        FriendsDressUpBusinessScene friendsDressUpBusinessScene = new FriendsDressUpBusinessScene(this.uin, this.headMontagePath, this.bodyMontagePath, coerceAtMost);
        this.scene = friendsDressUpBusinessScene;
        Intrinsics.checkNotNull(friendsDressUpBusinessScene);
        friendsDressUpBusinessScene.setAvatarInfoReadyListener(new c());
        wk0.a aVar4 = this.filamentNativeApp;
        if (aVar4 != null) {
            FriendsDressUpBusinessScene friendsDressUpBusinessScene2 = this.scene;
            Intrinsics.checkNotNull(friendsDressUpBusinessScene2);
            aVar4.y("", friendsDressUpBusinessScene2);
        }
        k().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.d
            @Override // java.lang.Runnable
            public final void run() {
                FilamentNativeAppHelper.q(FilamentNativeAppHelper.this);
            }
        });
        wk0.a aVar5 = this.filamentNativeApp;
        if (aVar5 != null) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            view = aVar5.z(context, Boolean.TRUE);
        } else {
            view = null;
        }
        o(view);
        A(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FilamentNativeAppHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(this$0.horizontalRatio);
        FrameLayout frameLayout = this$0.avatarContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setLayoutParams(this$0.i());
    }

    private final void v(float ratio) {
        if (PadUtil.a(BaseApplication.context) == DeviceType.TABLET) {
            this.NEW_HEIGHT_RATIO = ratio;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        int i3;
        float f16;
        int coerceAtMost;
        int i16 = this.curBodyTypeId;
        View view = this.filamentTextureView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            switch (i16) {
                case FriendsDressUpBusinessScene.BODY_TYPE_OLD /* 415000001 */:
                    i3 = this.oldBodyMargin;
                    break;
                case FriendsDressUpBusinessScene.BODY_TYPE_MALE_D /* 415000002 */:
                    i3 = this.maleMargin;
                    break;
                case FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D /* 415000003 */:
                    i3 = this.femaleMargin;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            layoutParams2.bottomMargin = i3;
            if (i16 == 415000001) {
                f16 = this.screenHeight * 0.75f;
            } else {
                f16 = this.screenHeight * this.NEW_HEIGHT_RATIO;
            }
            int i17 = (int) f16;
            layoutParams2.height = i17;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) (i17 * 0.75f), this.rootViewWidth);
            layoutParams2.width = coerceAtMost;
            com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "onAvatarReady, " + i16 + ", w=" + coerceAtMost + ", h=" + layoutParams2.height + ", margin=" + layoutParams2.bottomMargin);
            view.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "updateZPlanAvatar");
        View view = this.filamentTextureView;
        if (view != null) {
            view.setVisibility(0);
        }
        A(true);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.t("onFilamentRenderFail", this.jsEventListener);
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.t("onFirstFrameRenderEnd", this.jsEventListener);
        }
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            aVar3.t("onFirstFrameImageReady", this.jsEventListener);
        }
    }

    public final void A(boolean loadingCompleted) {
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "updateZPlanLoadingState, loadingCompleted=" + loadingCompleted);
        if (loadingCompleted) {
            View view = this.filamentTextureView;
            if (view != null) {
                view.setVisibility(0);
            }
            l().clearAnimation();
            FrameLayout frameLayout = this.avatarContainer;
            if (frameLayout != null) {
                frameLayout.removeView(l());
                return;
            }
            return;
        }
        if (l().getParent() != null) {
            return;
        }
        View view2 = this.filamentTextureView;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(30.0f), ViewUtils.dpToPx(30.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = ViewUtils.dpToPx(30.0f);
        FrameLayout frameLayout2 = this.avatarContainer;
        if (frameLayout2 != null) {
            frameLayout2.addView(l(), layoutParams);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(-1);
        l().startAnimation(rotateAnimation);
    }

    /* renamed from: j, reason: from getter */
    public final wk0.a getFilamentNativeApp() {
        return this.filamentNativeApp;
    }

    /* renamed from: m, reason: from getter */
    public final FriendsDressUpBusinessScene getScene() {
        return this.scene;
    }

    public final void s() {
        if (this.isResume) {
            return;
        }
        this.isResume = true;
        n();
        if (this.filamentNativeApp == null) {
            p();
        }
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    public final void u(float horizontalRatio) {
        this.horizontalRatio = horizontalRatio;
    }

    public final void x(String uin, String headMontagePath, String bodyMontagePath) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(headMontagePath, "headMontagePath");
        Intrinsics.checkNotNullParameter(bodyMontagePath, "bodyMontagePath");
        this.uin = uin;
        FriendsDressUpBusinessScene friendsDressUpBusinessScene = this.scene;
        if (friendsDressUpBusinessScene != null) {
            friendsDressUpBusinessScene.updateAnimationPath(uin, headMontagePath, bodyMontagePath);
        }
    }

    public final void y(int newWidth, int newHeight, float ratio) {
        QLog.i("FilamentNativeAppHelper", 1, "updateSize ratio value=" + ratio);
        this.rootViewWidth = newWidth;
        this.screenHeight = newHeight;
        v(ratio);
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout != null) {
            frameLayout.setLayoutParams(i());
        }
        w();
    }

    public final void r() {
        this.isResume = false;
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    private final void o(View view) {
        if (view != null && this.filamentTextureView == null) {
            com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentNativeAppHelper", "initFilamentView");
            this.filamentTextureView = view;
            view.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 81;
            FrameLayout frameLayout = this.avatarContainer;
            if (frameLayout != null) {
                frameLayout.addView(view, layoutParams);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r2 != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        boolean z16;
        Object coroutine_suspended;
        boolean isBlank;
        boolean isBlank2;
        if (str != null) {
            boolean z17 = false;
            if (str2 != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank2) {
                    z16 = false;
                    if (!z16) {
                        if (str3 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                        }
                        z17 = true;
                        if (!z17) {
                            FriendsDressUpBusinessScene friendsDressUpBusinessScene = this.scene;
                            if (friendsDressUpBusinessScene != null) {
                                Object downloadAnimRes = friendsDressUpBusinessScene.downloadAnimRes(str, str2, str3, continuation);
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                return downloadAnimRes == coroutine_suspended ? downloadAnimRes : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return Unit.INSTANCE;
    }
}
