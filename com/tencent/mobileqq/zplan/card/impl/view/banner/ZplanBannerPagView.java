package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sqshow.zootopia.utils.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import pv4.q;
import pv4.s;
import pv4.u;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 d2\u00020\u0001:\u0002efB\u0011\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^B\u0019\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\b]\u0010aB!\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010b\u001a\u00020\u000f\u00a2\u0006\u0004\b]\u0010cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u001e\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010&\u001a\u00020%J\b\u0010'\u001a\u00020\u0004H\u0014J\b\u0010(\u001a\u00020\u0004H\u0014J \u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010*\u001a\u00020)H\u0016J\u0014\u00101\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040/R*\u00108\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R>\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020:09j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020:`;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010I\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR0\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR%\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100J8\u0006\u00a2\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010NR\u0014\u0010W\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bV\u0010<R\u0014\u0010Z\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010V\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerPagView;", "Lorg/libpag/PAGView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$Direct;", "direct", "", "v", "", "filePath", "t", "Lpv4/s;", "data", HippyTKDListViewAdapter.X, "k", "l", "", "", "Landroid/graphics/Bitmap;", "drawableMap", "o", "index", MimeHelper.IMAGE_SUBTYPE_BITMAP, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lorg/libpag/PAGFile;", "pagFile", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "double", HippyQQPagView.FunctionName.SET_PROGRESS, HippyQQPagView.FunctionName.GET_PROGRESS, "", "float", "setDuration", "left", "right", "u", "", "r", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/graphics/SurfaceTexture;", "surface", "width", "height", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "Lkotlin/Function0;", "runnable", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", DomainData.DOMAIN_NAME, "()Lkotlin/jvm/functions/Function0;", "setPostRunnable", "(Lkotlin/jvm/functions/Function0;)V", "postRunnable", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "getPagDuration", "()Ljava/util/HashMap;", "setPagDuration", "(Ljava/util/HashMap;)V", "pagDuration", "E", "Z", ReportConstant.COSTREPORT_PREFIX, "()Z", "setSurfaceTextureAvailable", "(Z)V", "isSurfaceTextureAvailable", "Ljava/util/concurrent/ConcurrentHashMap;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/ConcurrentHashMap;", "getPagFiles", "()Ljava/util/concurrent/ConcurrentHashMap;", "setPagFiles", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "pagFiles", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bitmapMap", "H", "I", "pagWidth", "rate", "J", "pagHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributes", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defRes", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanBannerPagView extends PAGView {

    /* renamed from: C, reason: from kotlin metadata */
    private Function0<Unit> postRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    private HashMap<ZplanPagFrameView.Direct, Long> pagDuration;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile boolean isSurfaceTextureAvailable;

    /* renamed from: F, reason: from kotlin metadata */
    private ConcurrentHashMap<ZplanPagFrameView.Direct, PAGFile> pagFiles;

    /* renamed from: G, reason: from kotlin metadata */
    private final ConcurrentHashMap<Integer, Bitmap> bitmapMap;

    /* renamed from: H, reason: from kotlin metadata */
    private final int pagWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private final double rate;

    /* renamed from: J, reason: from kotlin metadata */
    private final int pagHeight;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerPagView$a;", "Lcom/tencent/sqshow/zootopia/utils/k$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "Ljava/lang/ref/WeakReference;", "", "Ljava/lang/ref/WeakReference;", "index", "Lpv4/s;", "b", "moduleDetail", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerPagView;", "c", "context", "i", "data", "view", "<init>", "(ILpv4/s;Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerPagView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements k.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<Integer> index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<s> moduleDetail;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZplanBannerPagView> context;

        public a(int i3, s data, ZplanBannerPagView view) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(view, "view");
            this.index = new WeakReference<>(Integer.valueOf(i3));
            this.moduleDetail = new WeakReference<>(data);
            this.context = new WeakReference<>(view);
        }

        @Override // com.tencent.sqshow.zootopia.utils.k.a
        public void a(Bitmap bitmap) {
            ZplanBannerPagView zplanBannerPagView;
            Integer num = this.index.get();
            if (num == null) {
                return;
            }
            int intValue = num.intValue();
            s sVar = this.moduleDetail.get();
            if (sVar == null || (zplanBannerPagView = this.context.get()) == null) {
                return;
            }
            if (bitmap != null) {
                zplanBannerPagView.m().put(Integer.valueOf(intValue), bitmap);
                if (zplanBannerPagView.m().size() == 3) {
                    zplanBannerPagView.o(zplanBannerPagView.m());
                    zplanBannerPagView.q(sVar);
                    zplanBannerPagView.flush();
                    QLog.d("ZBannerPagView", 1, "replace image ... " + zplanBannerPagView.getIsSurfaceTextureAvailable() + " " + (zplanBannerPagView.n() == null));
                    if (zplanBannerPagView.getIsSurfaceTextureAvailable()) {
                        Function0<Unit> n3 = zplanBannerPagView.n();
                        if (n3 != null) {
                            n3.invoke();
                        }
                        zplanBannerPagView.setPostRunnable(null);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("ZBannerPagView", 1, "load image failed " + intValue);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBannerPagView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagDuration = new HashMap<>();
        this.pagFiles = new ConcurrentHashMap<>();
        this.bitmapMap = new ConcurrentHashMap<>();
        int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(32.0f);
        this.pagWidth = screenWidth;
        this.rate = 0.521613832853026d;
        this.pagHeight = (int) (screenWidth * 0.521613832853026d);
    }

    private final void k() {
        for (ZplanPagFrameView.Direct direct : ZplanPagFrameView.Direct.values()) {
            PAGFile pAGFile = this.pagFiles.get(direct);
            QLog.i("ZBannerPagView", 1, "set default view " + direct + " and " + (pAGFile == null) + "  ");
            if (pAGFile != null) {
                com.tencent.sqshow.zootopia.utils.k kVar = com.tencent.sqshow.zootopia.utils.k.f373283a;
                kVar.d(pAGFile, 5, null);
                kVar.d(pAGFile, 1, null);
                q(null);
                QLog.i("ZBannerPagView", 1, "hide view " + direct + " ");
            }
        }
        PAGFile pAGFile2 = this.pagFiles.get(ZplanPagFrameView.Direct.RIGHT);
        if (pAGFile2 != null) {
            QLog.i("ZBannerPagView", 1, "hide view1  " + pAGFile2 + " ");
            com.tencent.sqshow.zootopia.utils.k.f373283a.d(pAGFile2, 1, null);
        }
        PAGFile pAGFile3 = this.pagFiles.get(ZplanPagFrameView.Direct.LEFT);
        if (pAGFile3 != null) {
            QLog.i("ZBannerPagView", 1, "hide view2 " + pAGFile3 + " ");
            com.tencent.sqshow.zootopia.utils.k.f373283a.d(pAGFile3, 1, null);
        }
    }

    private final void l(s data) {
        IntRange indices;
        pu4.g gVar = data.f427681b;
        if (gVar == null) {
            return;
        }
        String[] picList = gVar.f427438e.f427524b;
        Intrinsics.checkNotNullExpressionValue(picList, "picList");
        indices = ArraysKt___ArraysKt.getIndices(picList);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            a aVar = new a(nextInt, data, this);
            com.tencent.sqshow.zootopia.utils.k kVar = com.tencent.sqshow.zootopia.utils.k.f373283a;
            String str = picList[nextInt];
            Intrinsics.checkNotNullExpressionValue(str, "picList[i]");
            kVar.c(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Map<Integer, Bitmap> drawableMap) {
        for (Map.Entry<Integer, Bitmap> entry : drawableMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            Bitmap value = entry.getValue();
            QLog.d("ZBannerPagView", 1, "show image " + intValue + "  false");
            w(intValue, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(s data) {
        for (ZplanPagFrameView.Direct direct : ZplanPagFrameView.Direct.values()) {
            PAGFile pAGFile = this.pagFiles.get(direct);
            if (pAGFile != null) {
                p(pAGFile, data);
            }
        }
    }

    private final void t(String filePath, ZplanPagFrameView.Direct direct) {
        PAGFile Load = PagViewMonitor.Load(filePath);
        if (Load != null) {
            Matrix totalMatrix = Load.getTotalMatrix();
            float width = this.pagWidth / Load.width();
            float height = this.pagHeight / Load.height();
            if (totalMatrix != null) {
                totalMatrix.setScale(width, height);
            }
            Load.setMatrix(totalMatrix);
            Load.setTimeStretchMode(3);
            this.pagFiles.put(direct, Load);
            this.pagDuration.put(direct, Long.valueOf(Load.duration()));
            QLog.i("ZBannerPagView", 1, "load pagFile success " + direct + " " + Load.path());
        }
    }

    private final void v(ZplanPagFrameView.Direct direct) {
        if (getComposition() == null) {
            PAGComposition Make = PAGComposition.Make(this.pagWidth, this.pagHeight);
            if (Make != null) {
                Make.removeAllLayers();
            }
            if (Make != null) {
                Make.addLayer(this.pagFiles.get(direct));
            }
            setComposition(Make);
            return;
        }
        PAGComposition composition = getComposition();
        if (composition != null) {
            composition.removeAllLayers();
        }
        PAGComposition composition2 = getComposition();
        if (composition2 != null) {
            composition2.addLayer(this.pagFiles.get(direct));
        }
    }

    private final void w(int index, Bitmap bitmap) {
        for (ZplanPagFrameView.Direct direct : ZplanPagFrameView.Direct.values()) {
            PAGFile pAGFile = this.pagFiles.get(direct);
            if (pAGFile != null) {
                QLog.d("ZBannerPagView", 1, "replace image with real resource " + index + " ");
                if (index == 0) {
                    com.tencent.sqshow.zootopia.utils.k.f373283a.d(pAGFile, 6, bitmap);
                } else if (index == 1) {
                    com.tencent.sqshow.zootopia.utils.k.f373283a.d(pAGFile, 5, bitmap);
                } else if (index == 2) {
                    com.tencent.sqshow.zootopia.utils.k.f373283a.d(pAGFile, 1, bitmap);
                }
            }
        }
    }

    private final void x(final s data) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.d
            @Override // java.lang.Runnable
            public final void run() {
                ZplanBannerPagView.y(ZplanBannerPagView.this, data);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ZplanBannerPagView this$0, s data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (this$0.bitmapMap.size() == 3) {
            QLog.d("ZBannerPagView", 1, "replacePagRes: " + data.f427681b + " ");
            this$0.q(data);
            this$0.o(this$0.bitmapMap);
        } else {
            this$0.k();
            this$0.l(data);
        }
        QLog.i("ZBannerPagView", 1, "isPagReady and ready to play " + this$0.postRunnable + "  " + this$0.isSurfaceTextureAvailable);
        if (this$0.isSurfaceTextureAvailable) {
            Function0<Unit> function0 = this$0.postRunnable;
            if (function0 != null) {
                function0.invoke();
            }
            this$0.postRunnable = null;
        }
    }

    public final void A(ZplanPagFrameView.Direct direct) {
        Intrinsics.checkNotNullParameter(direct, "direct");
        v(direct);
        QLog.i("ZBannerPagView", 1, "start Play " + direct);
        if (isPlaying()) {
            return;
        }
        play();
    }

    @Override // org.libpag.PAGView
    public double getProgress() {
        return super.getProgress();
    }

    public final ConcurrentHashMap<Integer, Bitmap> m() {
        return this.bitmapMap;
    }

    public final Function0<Unit> n() {
        return this.postRunnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.libpag.PAGView, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("ZBannerPagView", 1, "onAttachedToWindow: reay to play ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.libpag.PAGView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("ZBannerPagView", 1, "onDetachedFromWindow ");
    }

    @Override // org.libpag.PAGView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        super.onSurfaceTextureAvailable(surface, width, height);
        QLog.d("ZBannerPagView", 1, "onSurfaceTextureAvailable: suface " + surface + " [" + (this.postRunnable == null) + "] ");
        this.isSurfaceTextureAvailable = true;
        if (this.postRunnable == null || !r()) {
            return;
        }
        Function0<Unit> function0 = this.postRunnable;
        if (function0 != null) {
            function0.invoke();
        }
        this.postRunnable = null;
    }

    @Override // org.libpag.PAGView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        QLog.d("ZBannerPagView", 1, "onSurfaceTexture Destoryed");
        this.isSurfaceTextureAvailable = false;
        return super.onSurfaceTextureDestroyed(surface);
    }

    public final boolean r() {
        for (ZplanPagFrameView.Direct direct : ZplanPagFrameView.Direct.values()) {
            if (!this.pagFiles.containsKey(direct)) {
                QLog.e("ZBannerPagView", 1, "pag is not ready " + direct);
                return false;
            }
        }
        QLog.i("ZBannerPagView", 1, "pag is ready");
        return true;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsSurfaceTextureAvailable() {
        return this.isSurfaceTextureAvailable;
    }

    public final void setDuration(ZplanPagFrameView.Direct direct, float r56) {
        Intrinsics.checkNotNullParameter(direct, "direct");
        QLog.d("ZBannerPagView", 1, "setDuration: " + direct + " " + this.pagDuration.get(direct) + " ");
        if (this.pagDuration.get(direct) == null) {
            QLog.d("ZBannerPagView", 1, "setDuration: null " + direct);
            return;
        }
        Long l3 = this.pagDuration.get(direct);
        Intrinsics.checkNotNull(l3);
        long floatValue = r56 * l3.floatValue();
        PAGFile pAGFile = this.pagFiles.get(direct);
        if (pAGFile != null) {
            pAGFile.setDuration(floatValue);
        }
    }

    public final void setPagDuration(HashMap<ZplanPagFrameView.Direct, Long> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.pagDuration = hashMap;
    }

    public final void setPagFiles(ConcurrentHashMap<ZplanPagFrameView.Direct, PAGFile> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.pagFiles = concurrentHashMap;
    }

    public final void setPostRunnable(Function0<Unit> function0) {
        this.postRunnable = function0;
    }

    public final void setProgress(ZplanPagFrameView.Direct direct, double r56) {
        Intrinsics.checkNotNullParameter(direct, "direct");
        PAGFile pAGFile = this.pagFiles.get(direct);
        if (pAGFile != null) {
            pAGFile.setProgress(r56);
        }
        QLog.i("ZBannerPagView", 1, "setProgress " + direct + " " + r56);
        v(direct);
        super.setProgress(r56);
    }

    public final void setSurfaceTextureAvailable(boolean z16) {
        this.isSurfaceTextureAvailable = z16;
    }

    public final void u(String left, String right, s data) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("ZBannerPagView", 1, "loadPagFile: called " + left + " " + right + " ");
        t(left, ZplanPagFrameView.Direct.LEFT);
        t(right, ZplanPagFrameView.Direct.RIGHT);
        x(data);
    }

    public final void z(Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (this.isSurfaceTextureAvailable && r()) {
            runnable.invoke();
            QLog.d("ZBannerPagView", 1, "runnable invoked");
        } else {
            this.postRunnable = runnable;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(PAGFile pagFile, s data) {
        boolean z16;
        int i3;
        u uVar;
        q qVar;
        u uVar2;
        q qVar2;
        u uVar3;
        u uVar4;
        String str = (data == null || (uVar4 = data.f427680a) == null) ? null : uVar4.f427702a;
        String str2 = (data == null || (qVar2 = data.f427687h) == null || (uVar3 = qVar2.f427655c) == null) ? null : uVar3.f427702a;
        u[] uVarArr = data != null ? data.f427689j : null;
        int i16 = 1;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
                if (z16 && str.length() > 26) {
                    str = ((Object) str.subSequence(0, 26)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                String str3 = str;
                com.tencent.sqshow.zootopia.utils.k kVar = com.tencent.sqshow.zootopia.utils.k.f373283a;
                com.tencent.sqshow.zootopia.utils.k.f(kVar, pagFile, 0, str2, (data != null || (qVar = data.f427687h) == null || (uVar2 = qVar.f427655c) == null) ? null : uVar2.f427704c, null, 16, null);
                com.tencent.sqshow.zootopia.utils.k.f(kVar, pagFile, 1, str3, (data != null || (uVar = data.f427680a) == null) ? null : uVar.f427704c, null, 16, null);
                if (str2 != null) {
                    if (!(str2.length() == 0)) {
                        kVar.h(pagFile, 0, true);
                        int length = uVarArr != null ? uVarArr.length : 0;
                        int i17 = 2;
                        i3 = 0;
                        while (i3 < 3) {
                            if (i3 < length) {
                                u uVar5 = uVarArr != null ? uVarArr[i3] : null;
                                QLog.d("ZBannerPagView", i16, "replace tag info is " + uVar5 + " " + i3);
                                com.tencent.sqshow.zootopia.utils.k kVar2 = com.tencent.sqshow.zootopia.utils.k.f373283a;
                                u uVar6 = uVar5;
                                com.tencent.sqshow.zootopia.utils.k.f(kVar2, pagFile, i17, uVar5 != null ? uVar5.f427702a : null, uVar5 != null ? uVar5.f427704c : null, null, 16, null);
                                if ((uVar6 != null ? uVar6.f427702a : null) != null) {
                                    String str4 = uVar6.f427702a;
                                    Intrinsics.checkNotNullExpressionValue(str4, "tag.title");
                                    if (!(str4.length() == 0)) {
                                    }
                                }
                                kVar2.h(pagFile, i17, false);
                            } else {
                                com.tencent.sqshow.zootopia.utils.k kVar3 = com.tencent.sqshow.zootopia.utils.k.f373283a;
                                com.tencent.sqshow.zootopia.utils.k.f(kVar3, pagFile, i17, null, null, null, 16, null);
                                kVar3.h(pagFile, i17, false);
                            }
                            i17++;
                            i3++;
                            i16 = 1;
                        }
                    }
                }
                kVar.h(pagFile, 0, false);
                if (uVarArr != null) {
                }
                int i172 = 2;
                i3 = 0;
                while (i3 < 3) {
                }
            }
        }
        z16 = false;
        if (z16) {
            str = ((Object) str.subSequence(0, 26)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        String str32 = str;
        com.tencent.sqshow.zootopia.utils.k kVar4 = com.tencent.sqshow.zootopia.utils.k.f373283a;
        com.tencent.sqshow.zootopia.utils.k.f(kVar4, pagFile, 0, str2, (data != null || (qVar = data.f427687h) == null || (uVar2 = qVar.f427655c) == null) ? null : uVar2.f427704c, null, 16, null);
        com.tencent.sqshow.zootopia.utils.k.f(kVar4, pagFile, 1, str32, (data != null || (uVar = data.f427680a) == null) ? null : uVar.f427704c, null, 16, null);
        if (str2 != null) {
        }
        kVar4.h(pagFile, 0, false);
        if (uVarArr != null) {
        }
        int i1722 = 2;
        i3 = 0;
        while (i3 < 3) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBannerPagView(Context context, AttributeSet attributes) {
        super(context, attributes);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.pagDuration = new HashMap<>();
        this.pagFiles = new ConcurrentHashMap<>();
        this.bitmapMap = new ConcurrentHashMap<>();
        int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(32.0f);
        this.pagWidth = screenWidth;
        this.rate = 0.521613832853026d;
        this.pagHeight = (int) (screenWidth * 0.521613832853026d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBannerPagView(Context context, AttributeSet attributes, int i3) {
        super(context, attributes, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.pagDuration = new HashMap<>();
        this.pagFiles = new ConcurrentHashMap<>();
        this.bitmapMap = new ConcurrentHashMap<>();
        int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(32.0f);
        this.pagWidth = screenWidth;
        this.rate = 0.521613832853026d;
        this.pagHeight = (int) (screenWidth * 0.521613832853026d);
    }
}
