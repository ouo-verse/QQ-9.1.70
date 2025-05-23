package com.tencent.sqshow.widget.pag;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.cc.IZPlanCameraHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.RoundFrameLayout;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;
import org.libpag.PAGLayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGView;
import org.light.LightEngine;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0004\u0018i\u001cjB\u0011\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\ba\u0010bB\u001b\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\ba\u0010eB#\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u0012\u0006\u0010f\u001a\u00020\u001d\u00a2\u0006\u0004\ba\u0010gJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0003H\u0014J\b\u0010\u0014\u001a\u00020\u0003H\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u001dH\u0016J\u0010\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\u0003H\u0016J\u0012\u00104\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u000103H\u0016J\b\u00105\u001a\u00020\u0003H\u0016J-\u0010:\u001a\u00020\u00032#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0003\u0018\u000106H\u0016R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010?R#\u0010F\u001a\n B*\u0004\u0018\u00010A0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010GR\u0016\u0010J\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010QR\u0016\u0010S\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0018\u0010V\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR3\u0010\\\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0003\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010N\u00a8\u0006k"}, d2 = {"Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "Lcom/tencent/sqshow/widget/RoundFrameLayout;", "Lcom/tencent/sqshow/widget/pag/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "r", "u", "Lorg/libpag/PAGFile;", "pagFile", "D", "w", "y", "Lcom/tencent/image/URLDrawable;", "urlDrawable", UserInfo.SEX_FEMALE, "", HippyTKDListViewAdapter.X, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, BdhLogUtil.LogTag.Tag_Conn, "Lorg/libpag/PAGView$PAGViewListener;", "listener", "a", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "stop", "c", "", "value", "setRepeatCount", "", "path", "setPath", "Lorg/libpag/PAGComposition;", "newComposition", "setComposition", "mode", "setScaleMode", "Landroid/graphics/Matrix;", "matrix", "setMatrix", "", HippyQQPagView.FunctionName.SET_PROGRESS, "color", "setSolidColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setLoadingDrawable", "resetView", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$c;", ReportConstant.COSTREPORT_PREFIX, "E", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAvailable", "setPagViewReadyListener", "Lorg/libpag/PAGImageView;", "Lorg/libpag/PAGImageView;", "pagImageView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "preImageView", "Lcom/tencent/sqshow/zootopia/utils/PagLoader;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "t", "()Lcom/tencent/sqshow/zootopia/utils/PagLoader;", "pagLoader", "Lpu4/g;", "G", "Z", "isPAGViewAdded", "H", "isLoaded", "", "I", "J", "sourceDuration", "Lorg/libpag/PAGView$PAGViewListener;", "K", "repeatCount", "L", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$c;", "viewLoadedListener", "M", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "N", "Lkotlin/jvm/functions/Function1;", "pagViewAvailableCallback", "P", "solidLayerColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "b", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPAGView extends RoundFrameLayout implements a {

    /* renamed from: Q, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private PAGImageView pagImageView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView preImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy pagLoader;

    /* renamed from: F, reason: from kotlin metadata */
    private pu4.g material;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isPAGViewAdded;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isLoaded;

    /* renamed from: I, reason: from kotlin metadata */
    private long sourceDuration;

    /* renamed from: J, reason: from kotlin metadata */
    private PAGView.PAGViewListener listener;

    /* renamed from: K, reason: from kotlin metadata */
    private int repeatCount;

    /* renamed from: L, reason: from kotlin metadata */
    private c viewLoadedListener;

    /* renamed from: M, reason: from kotlin metadata */
    private Drawable defaultDrawable;

    /* renamed from: N, reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> pagViewAvailableCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private int solidLayerColor;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$a;", "", "", "a", "", "LOCAL_IMAGE", "Ljava/lang/String;", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.widget.pag.ZPlanPAGView$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return com.tencent.sqshow.zootopia.utils.g.e(com.tencent.sqshow.zootopia.utils.g.f373269a, false, 1, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$b;", "Lvk3/a;", "", "url", "path", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "Lmqq/util/WeakReference;", "weakPAGView", "view", "<init>", "(Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements vk3.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanPAGView> weakPAGView;

        public b(ZPlanPAGView zPlanPAGView) {
            this.weakPAGView = new WeakReference<>(zPlanPAGView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final String path, final String url, final ZPlanPAGView target) {
            Intrinsics.checkNotNullParameter(path, "$path");
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(target, "$target");
            final PAGFile Load = PagViewMonitor.Load(path);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.widget.pag.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPAGView.b.e(PAGFile.this, url, path, target);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(PAGFile pAGFile, String url, String path, ZPlanPAGView target) {
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(path, "$path");
            Intrinsics.checkNotNullParameter(target, "$target");
            if (pAGFile != null) {
                QLog.i("ZPlanPAGView", 4, "onPAGDownLoaded :: loaded, url = " + url + ", path = " + path);
                target.D(pAGFile);
            }
        }

        @Override // vk3.a
        public void a(final String url, final String path) {
            pu4.g gVar;
            String str;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(path, "path");
            final ZPlanPAGView zPlanPAGView = this.weakPAGView.get();
            if (zPlanPAGView == null || (gVar = zPlanPAGView.material) == null || (str = gVar.f427434a) == null || !Intrinsics.areEqual(str, url)) {
                return;
            }
            if (path.length() > 0) {
                QLog.i("ZPlanPAGView", 4, "onPAGDownLoaded :: material url == " + url);
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.sqshow.widget.pag.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanPAGView.b.d(path, url, zPlanPAGView);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$c;", "", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c {
        void a();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/widget/pag/ZPlanPAGView$d;", "Lcom/tencent/sqshow/zootopia/utils/PagLoader$b;", "", "e", "", "result", "onComplete", "Lmqq/util/WeakReference;", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "d", "Lmqq/util/WeakReference;", "weakPAGView", "view", "<init>", "(Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements PagLoader.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanPAGView> weakPAGView;

        public d(ZPlanPAGView zPlanPAGView) {
            this.weakPAGView = new WeakReference<>(zPlanPAGView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final d this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.widget.pag.h
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPAGView.d.d(ZPlanPAGView.d.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(d this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.weakPAGView.get() == null) {
                return;
            }
            ZPlanPAGView zPlanPAGView = this$0.weakPAGView.get();
            if (zPlanPAGView != null) {
                zPlanPAGView.isLoaded = true;
            }
            ZPlanPAGView zPlanPAGView2 = this$0.weakPAGView.get();
            if (zPlanPAGView2 != null) {
                zPlanPAGView2.w();
            }
        }

        private final void e() {
            if (ZPlanPAGView.INSTANCE.a()) {
                ((IZPlanCameraHelper) QRoute.api(IZPlanCameraHelper.class)).loadCameraSdkSo();
                LightEngine.init();
            }
        }

        @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
        public void onComplete(boolean result) {
            if (result) {
                QLog.i("ZPlanPAGView", 4, "loadPag success , current Thread == " + Thread.currentThread());
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.sqshow.widget.pag.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanPAGView.d.c(ZPlanPAGView.d.this);
                    }
                });
                return;
            }
            QLog.e("ZPlanPAGView", 4, "loadPag failed");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/widget/pag/ZPlanPAGView$e", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "Lorg/libpag/PAGImageView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements PAGImageView.PAGImageViewListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<ZPlanPAGView> f369883d;

        e(WeakReference<ZPlanPAGView> weakReference) {
            this.f369883d = weakReference;
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationCancel(PAGImageView p06) {
            PAGView.PAGViewListener pAGViewListener;
            ZPlanPAGView zPlanPAGView = this.f369883d.get();
            if (zPlanPAGView == null || (pAGViewListener = zPlanPAGView.listener) == null) {
                return;
            }
            pAGViewListener.onAnimationCancel(null);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationEnd(PAGImageView p06) {
            PAGView.PAGViewListener pAGViewListener;
            ZPlanPAGView zPlanPAGView = this.f369883d.get();
            if (zPlanPAGView == null || (pAGViewListener = zPlanPAGView.listener) == null) {
                return;
            }
            pAGViewListener.onAnimationEnd(null);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationRepeat(PAGImageView p06) {
            PAGView.PAGViewListener pAGViewListener;
            ZPlanPAGView zPlanPAGView = this.f369883d.get();
            if (zPlanPAGView == null || (pAGViewListener = zPlanPAGView.listener) == null) {
                return;
            }
            pAGViewListener.onAnimationRepeat(null);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationStart(PAGImageView p06) {
            PAGView.PAGViewListener pAGViewListener;
            ZPlanPAGView zPlanPAGView = this.f369883d.get();
            if (zPlanPAGView == null || (pAGViewListener = zPlanPAGView.listener) == null) {
                return;
            }
            pAGViewListener.onAnimationStart(null);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationUpdate(PAGImageView p06) {
            PAGView.PAGViewListener pAGViewListener;
            ZPlanPAGView zPlanPAGView = this.f369883d.get();
            if (zPlanPAGView == null || (pAGViewListener = zPlanPAGView.listener) == null) {
                return;
            }
            pAGViewListener.onAnimationUpdate(null);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/widget/pag/ZPlanPAGView$f", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements URLDrawable.URLDrawableListener {
        f() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
            QLog.i("ZPlanPAGView", 1, "addPreImageView :: onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            QLog.i("ZPlanPAGView", 1, "addPreImageView :: onLoadFialed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
            QLog.i("ZPlanPAGView", 1, "addPreImageView :: onLoadProgressed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            QLog.i("ZPlanPAGView", 1, "addPreImageView :: onLoadSuccessed");
            c cVar = ZPlanPAGView.this.viewLoadedListener;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPAGView(Context context) {
        super(context, null, 0, 6, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(ZPlanPAGView$pagLoader$2.INSTANCE);
        this.pagLoader = lazy;
        this.solidLayerColor = -1;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.widget.pag.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPAGView.j(ZPlanPAGView.this);
            }
        }, 16, null, true);
        ((IZPlanPAGLoaderHelper) QRoute.api(IZPlanPAGLoaderHelper.class)).addDownloadListener(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(PAGFile pagFile) {
        c cVar = this.viewLoadedListener;
        if (cVar != null) {
            cVar.a();
        }
        this.sourceDuration = pagFile.duration();
        int width = getWidth();
        QLog.i("ZPlanPAGView", 4, "playPAGFile width=" + width);
        QRouteApi api = QRoute.api(IZPlanPAGLoaderHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanPAGLoaderHelper::class.java)");
        IZPlanPAGLoaderHelper iZPlanPAGLoaderHelper = (IZPlanPAGLoaderHelper) api;
        if (width > 0) {
            iZPlanPAGLoaderHelper.setPAGParam(pagFile, width);
        } else {
            iZPlanPAGLoaderHelper.setPAGParam(pagFile, (int) i.f(pagFile.width()));
        }
        if (this.solidLayerColor != -1) {
            int numChildren = pagFile.numChildren();
            for (int i3 = 0; i3 < numChildren; i3++) {
                PAGLayer layerAt = pagFile.getLayerAt(i3);
                if (layerAt instanceof PAGSolidLayer) {
                    ((PAGSolidLayer) layerAt).setSolidColor(this.solidLayerColor);
                }
            }
        }
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.setComposition(pagFile);
        }
        y();
        PAGImageView pAGImageView2 = this.pagImageView;
        if (pAGImageView2 != null) {
            pAGImageView2.setVisibility(0);
        }
        QLog.i("ZPlanPAGView", 4, "playPAGFile :: preImageView change to gone, isPlaying:" + A() + ", path=" + pagFile.path());
        PAGImageView pAGImageView3 = this.pagImageView;
        if (pAGImageView3 != null) {
            pAGImageView3.setRepeatCount(this.repeatCount);
        }
        B();
    }

    private final void F(URLDrawable urlDrawable) {
        urlDrawable.setURLDrawableListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZPlanPAGView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t().f(this$0.getContext(), new d(this$0));
    }

    private final void q() {
        if (this.isPAGViewAdded || getContext() == null) {
            return;
        }
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).isFinishing()) {
                return;
            }
        }
        this.pagImageView = new PAGImageView(getContext());
        WeakReference weakReference = new WeakReference(this);
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.addListener(new e(weakReference));
        }
        Function1<? super Boolean, Unit> function1 = this.pagViewAvailableCallback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        addView(this.pagImageView, 0, new FrameLayout.LayoutParams(-1, -1));
        this.isPAGViewAdded = true;
    }

    private final void r(pu4.g material) {
        if (TextUtils.isEmpty(material.f427436c)) {
            QLog.e("ZPlanPAGView", 1, "addPreImageView error :: material.firstFrameUrl is empty ");
            return;
        }
        if (this.preImageView == null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Drawable drawable = this.defaultDrawable;
            if (drawable == null) {
                drawable = q.b(R.drawable.gym);
            }
            if (Intrinsics.areEqual("local_image", material.f427436c)) {
                imageView.setImageDrawable(drawable);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                URLDrawable urlDrawable = URLDrawable.getDrawable(material.f427436c, obtain);
                Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
                F(urlDrawable);
                imageView.setImageDrawable(urlDrawable);
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.preImageView = imageView;
            addView(imageView);
        }
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.setVisibility(8);
        }
        PAGImageView pAGImageView2 = this.pagImageView;
        if (pAGImageView2 != null) {
            pAGImageView2.pause();
        }
        ImageView imageView2 = this.preImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        QLog.i("ZPlanPAGView", 4, "playPAGFile :: preImageView show");
    }

    private final PagLoader t() {
        return (PagLoader) this.pagLoader.getValue();
    }

    private final void u(pu4.g material) {
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanPAGView", 1, "handlePAGLoaded error :: material.url is empty ");
            return;
        }
        if (A()) {
            QLog.e("ZPlanPAGView", 1, "handlePAGLoaded error :: pag is running now ");
            return;
        }
        QLog.i("ZPlanPAGView", 4, "handlePAGLoaded success :: width == " + getWidth() + " , height == " + getHeight() + " ");
        IZPlanPAGLoaderHelper iZPlanPAGLoaderHelper = (IZPlanPAGLoaderHelper) QRoute.api(IZPlanPAGLoaderHelper.class);
        String str = material.f427434a;
        Intrinsics.checkNotNullExpressionValue(str, "material.url");
        final PAGFile pAGFileByUrl = iZPlanPAGLoaderHelper.getPAGFileByUrl(str);
        if (pAGFileByUrl == null) {
            QLog.i("ZPlanPAGView", 1, "handlePAGLoaded failed :: file not exist ");
            return;
        }
        QLog.i("ZPlanPAGView", 4, "handlePAGLoaded success :: pagFile duration == " + pAGFileByUrl.duration());
        post(new Runnable() { // from class: com.tencent.sqshow.widget.pag.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPAGView.v(ZPlanPAGView.this, pAGFileByUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ZPlanPAGView this$0, PAGFile pAGFile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D(pAGFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        q();
        pu4.g gVar = this.material;
        if (gVar != null) {
            u(gVar);
        }
    }

    private final void y() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.widget.pag.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPAGView.z(ZPlanPAGView.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZPlanPAGView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.preImageView;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public boolean A() {
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            return pAGImageView.isPlaying();
        }
        return false;
    }

    public void B() {
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.play();
        }
    }

    public void C(pu4.g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        a(material, null);
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void a(pu4.g material, PAGView.PAGViewListener listener) {
        Intrinsics.checkNotNullParameter(material, "material");
        this.listener = listener;
        if (this.material != null) {
            QRouteApi api = QRoute.api(IZPlanPAGLoaderHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanPAGLoaderHelper::class.java)");
            IZPlanPAGLoaderHelper iZPlanPAGLoaderHelper = (IZPlanPAGLoaderHelper) api;
            iZPlanPAGLoaderHelper.removeDownloadListener(new b(this));
            iZPlanPAGLoaderHelper.addDownloadListener(new b(this));
        }
        this.material = material;
        if (this.isLoaded) {
            q();
            u(material);
        } else {
            r(material);
            this.material = material;
        }
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void c(pu4.g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        r(material);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean A = A();
        QLog.i("ZPlanPAGView", 1, "onAttachedToWindow -- isPagAdded=" + this.isPAGViewAdded + ", isPlaying=" + A + " -" + this);
        ImageView imageView = this.preImageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.isPAGViewAdded && A) {
            y();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("ZPlanPAGView", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void resetView() {
        stop();
        this.isPAGViewAdded = false;
        removeAllViews();
        this.pagImageView = null;
        Function1<? super Boolean, Unit> function1 = this.pagViewAvailableCallback;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        this.preImageView = null;
    }

    public void s(c listener) {
        this.viewLoadedListener = listener;
    }

    public void setComposition(PAGComposition newComposition) {
        Intrinsics.checkNotNullParameter(newComposition, "newComposition");
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView == null) {
            return;
        }
        pAGImageView.setComposition(newComposition);
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void setLoadingDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.defaultDrawable = drawable;
    }

    public void setMatrix(Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView == null) {
            return;
        }
        pAGImageView.setMatrix(matrix);
    }

    public void setPagViewReadyListener(Function1<? super Boolean, Unit> listener) {
        this.pagViewAvailableCallback = listener;
        if (this.pagImageView == null || listener == null) {
            return;
        }
        listener.invoke(Boolean.TRUE);
    }

    public void setPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView == null) {
            return;
        }
        pAGImageView.setPath(path);
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void setProgress(double value) {
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView == null) {
            return;
        }
        Intrinsics.checkNotNull(pAGImageView);
        double numFrames = value * pAGImageView.numFrames();
        PAGImageView pAGImageView2 = this.pagImageView;
        Intrinsics.checkNotNull(pAGImageView2);
        pAGImageView2.setCurrentFrame((int) numFrames);
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void setRepeatCount(int value) {
        this.repeatCount = value;
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.setRepeatCount(value);
        }
    }

    public void setScaleMode(int mode) {
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.setScaleMode(mode);
        }
    }

    public void setSolidColor(int color) {
        this.solidLayerColor = color;
    }

    @Override // com.tencent.sqshow.widget.pag.a
    public void stop() {
        PAGImageView pAGImageView = this.pagImageView;
        if (pAGImageView != null) {
            pAGImageView.pause();
        }
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsLoaded() {
        return this.isLoaded;
    }

    public void E() {
        this.viewLoadedListener = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(ZPlanPAGView$pagLoader$2.INSTANCE);
        this.pagLoader = lazy;
        this.solidLayerColor = -1;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.widget.pag.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPAGView.j(ZPlanPAGView.this);
            }
        }, 16, null, true);
        ((IZPlanPAGLoaderHelper) QRoute.api(IZPlanPAGLoaderHelper.class)).addDownloadListener(new b(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPAGView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(ZPlanPAGView$pagLoader$2.INSTANCE);
        this.pagLoader = lazy;
        this.solidLayerColor = -1;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.widget.pag.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanPAGView.j(ZPlanPAGView.this);
            }
        }, 16, null, true);
        ((IZPlanPAGLoaderHelper) QRoute.api(IZPlanPAGLoaderHelper.class)).addDownloadListener(new b(this));
    }
}
