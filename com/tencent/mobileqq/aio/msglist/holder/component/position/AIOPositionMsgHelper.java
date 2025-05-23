package com.tencent.mobileqq.aio.msglist.holder.component.position;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.widget.mapview.QTextureMapView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOArkApi;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J-\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J-\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001aJ#\u0010#\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J+\u0010)\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*J(\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010,\u001a\u00020+2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J7\u00101\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/2\b\u0010(\u001a\u0004\u0018\u00010'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102J\u0012\u00104\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\u000eH\u0002J\u0018\u00106\u001a\u00020\f2\u0006\u00103\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0018H\u0002J(\u00108\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/position/AIOPositionMsgHelper;", "", "Landroid/content/Context;", "context", "", "needRoundRadius", "Landroid/widget/FrameLayout;", "u", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/aio/msg/template/b;", "msgItem", "", "k", "", "address", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "", QCircleSchemeAttr.Polymerize.LAT, "lon", "darkMode", "Landroid/graphics/Bitmap;", "r", "(DDZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "", "timeout", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "Lcom/tencent/mobileqq/widget/mapview/QTextureMapView;", "mapView", "B", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Lcom/tencent/mobileqq/widget/mapview/QTextureMapView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "j", "saveFilePath", "Landroid/view/ViewGroup;", "viewGroup", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/widget/mapview/QTextureMapView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "path", HippyTKDListViewAdapter.X, MimeHelper.IMAGE_SUBTYPE_BITMAP, "y", "name", "o", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPositionMsgHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOPositionMsgHelper f191690a;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/position/AIOPositionMsgHelper$a", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnCameraChangeListener;", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "cameraPosition", "", "onCameraChange", "onCameraChangeFinished", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements TencentMap.OnCameraChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Unit> f191691d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f191692e;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Unit> continuation, Ref.BooleanRef booleanRef) {
            this.f191691d = continuation;
            this.f191692e = booleanRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation, (Object) booleanRef);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(@Nullable CameraPosition cameraPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cameraPosition);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChangeFinished(@Nullable CameraPosition cameraPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cameraPosition);
                return;
            }
            Continuation<Unit> continuation = this.f191691d;
            Ref.BooleanRef booleanRef = this.f191692e;
            synchronized (continuation) {
                if (booleanRef.element) {
                    QLog.w("AIOPositionMsgHelper", 1, continuation.getContext().get(CoroutineName.INSTANCE) + " [onCameraChangeFinished] already resumed");
                    return;
                }
                booleanRef.element = true;
                Unit unit = Unit.INSTANCE;
                Continuation<Unit> continuation2 = this.f191691d;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62881);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f191690a = new AIOPositionMsgHelper();
        }
    }

    AIOPositionMsgHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Object A(TencentMap tencentMap, final String str, final ViewGroup viewGroup, final QTextureMapView qTextureMapView, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        tencentMap.snapshot(new TencentMap.SnapshotReadyCallback(safeContinuation, qTextureMapView, viewGroup, booleanRef, str) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgHelper$startMapSnapShot$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation<Bitmap> f191693a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ QTextureMapView f191694b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ViewGroup f191695c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f191696d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f191697e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f191693a = safeContinuation;
                this.f191694b = qTextureMapView;
                this.f191695c = viewGroup;
                this.f191696d = booleanRef;
                this.f191697e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, safeContinuation, qTextureMapView, viewGroup, booleanRef, str);
                }
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback
            public final void onSnapshotReady(Bitmap bitmap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
                    return;
                }
                Continuation<Bitmap> continuation2 = this.f191693a;
                Ref.BooleanRef booleanRef2 = this.f191696d;
                synchronized (continuation2) {
                    if (booleanRef2.element) {
                        QLog.w("AIOPositionMsgHelper", 1, continuation2.getContext().get(CoroutineName.INSTANCE) + " [startMapSnapShot] already resumed");
                        return;
                    }
                    booleanRef2.element = true;
                    Unit unit = Unit.INSTANCE;
                    QTextureMapView qTextureMapView2 = this.f191694b;
                    if (qTextureMapView2 != null) {
                        qTextureMapView2.onDestroy();
                        this.f191695c.removeView(this.f191694b);
                    }
                    if (bitmap == null) {
                        QLog.e("AIOPositionMsgHelper", 1, this.f191693a.getContext().get(CoroutineName.INSTANCE) + " [startMapSnapShot] bitmap is null");
                        this.f191693a.resumeWith(Result.m476constructorimpl(null));
                        return;
                    }
                    ThreadManagerV2.excute(new Runnable(this.f191697e, bitmap, this.f191693a) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgHelper$startMapSnapShot$2$1.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f191698d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ Bitmap f191699e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Continuation<Bitmap> f191700f;

                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            this.f191698d = r7;
                            this.f191699e = bitmap;
                            this.f191700f = r9;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, r7, bitmap, r9);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AIOPositionMsgHelper aIOPositionMsgHelper = AIOPositionMsgHelper.f191690a;
                            String str2 = this.f191698d;
                            Bitmap bitmap2 = this.f191699e;
                            Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
                            aIOPositionMsgHelper.y(str2, bitmap2);
                            Continuation<Bitmap> continuation3 = this.f191700f;
                            Bitmap bitmap3 = this.f191699e;
                            Intrinsics.checkNotNullExpressionValue(bitmap3, "bitmap");
                            continuation3.resumeWith(Result.m476constructorimpl(bitmap3));
                        }
                    }, 16, null, true);
                }
            }
        }, Bitmap.Config.ARGB_8888, 3000);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B(TencentMap tencentMap, LatLng latLng, QTextureMapView qTextureMapView, Continuation<? super Unit> continuation) {
        AIOPositionMsgHelper$waitForCameraFinished$1 aIOPositionMsgHelper$waitForCameraFinished$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof AIOPositionMsgHelper$waitForCameraFinished$1) {
            aIOPositionMsgHelper$waitForCameraFinished$1 = (AIOPositionMsgHelper$waitForCameraFinished$1) continuation;
            int i16 = aIOPositionMsgHelper$waitForCameraFinished$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIOPositionMsgHelper$waitForCameraFinished$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aIOPositionMsgHelper$waitForCameraFinished$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIOPositionMsgHelper$waitForCameraFinished$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            QLog.d("AIOPositionMsgHelper", 2, aIOPositionMsgHelper$waitForCameraFinished$1.getContext().get(CoroutineName.INSTANCE) + " [waitForCameraFinished] done");
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    aIOPositionMsgHelper$waitForCameraFinished$1.L$0 = tencentMap;
                    aIOPositionMsgHelper$waitForCameraFinished$1.L$1 = latLng;
                    aIOPositionMsgHelper$waitForCameraFinished$1.L$2 = qTextureMapView;
                    aIOPositionMsgHelper$waitForCameraFinished$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(aIOPositionMsgHelper$waitForCameraFinished$1);
                    SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    tencentMap.setOnCameraChangeListener(new a(safeContinuation, new Ref.BooleanRef()));
                    tencentMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    qTextureMapView.onStart();
                    qTextureMapView.onResume();
                    Object orThrow = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (orThrow == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(aIOPositionMsgHelper$waitForCameraFinished$1);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                aIOPositionMsgHelper$waitForCameraFinished$1.L$0 = null;
                aIOPositionMsgHelper$waitForCameraFinished$1.L$1 = null;
                aIOPositionMsgHelper$waitForCameraFinished$1.L$2 = null;
                aIOPositionMsgHelper$waitForCameraFinished$1.label = 2;
                if (DelayKt.delay(1000L, aIOPositionMsgHelper$waitForCameraFinished$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                QLog.d("AIOPositionMsgHelper", 2, aIOPositionMsgHelper$waitForCameraFinished$1.getContext().get(CoroutineName.INSTANCE) + " [waitForCameraFinished] done");
                return Unit.INSTANCE;
            }
        }
        aIOPositionMsgHelper$waitForCameraFinished$1 = new AIOPositionMsgHelper$waitForCameraFinished$1(this, continuation);
        Object obj2 = aIOPositionMsgHelper$waitForCameraFinished$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIOPositionMsgHelper$waitForCameraFinished$1.label;
        if (i3 == 0) {
        }
        aIOPositionMsgHelper$waitForCameraFinished$1.L$0 = null;
        aIOPositionMsgHelper$waitForCameraFinished$1.L$1 = null;
        aIOPositionMsgHelper$waitForCameraFinished$1.L$2 = null;
        aIOPositionMsgHelper$waitForCameraFinished$1.label = 2;
        if (DelayKt.delay(1000L, aIOPositionMsgHelper$waitForCameraFinished$1) == coroutine_suspended) {
        }
        QLog.d("AIOPositionMsgHelper", 2, aIOPositionMsgHelper$waitForCameraFinished$1.getContext().get(CoroutineName.INSTANCE) + " [waitForCameraFinished] done");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object C(TencentMap tencentMap, long j3, Continuation<? super Unit> continuation) {
        AIOPositionMsgHelper$waitForMapLoadedOrTimeout$1 aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof AIOPositionMsgHelper$waitForMapLoadedOrTimeout$1) {
            aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1 = (AIOPositionMsgHelper$waitForMapLoadedOrTimeout$1) continuation;
            int i16 = aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Channel Channel$default = ChannelKt.Channel$default(1, null, null, 6, null);
                    tencentMap.addOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.position.b
                        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
                        public final void onMapLoaded() {
                            AIOPositionMsgHelper.D(Channel.this);
                        }
                    });
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.position.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIOPositionMsgHelper.E(Channel.this);
                        }
                    }, j3);
                    aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.label = 1;
                    obj = Channel$default.receive(aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                QLog.d("AIOPositionMsgHelper", 2, aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.getContext().get(CoroutineName.INSTANCE) + " [waitForMapLoadedOrTimeout] done, " + ((Unit) obj));
                return Unit.INSTANCE;
            }
        }
        aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1 = new AIOPositionMsgHelper$waitForMapLoadedOrTimeout$1(this, continuation);
        Object obj2 = aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.label;
        if (i3 == 0) {
        }
        QLog.d("AIOPositionMsgHelper", 2, aIOPositionMsgHelper$waitForMapLoadedOrTimeout$1.getContext().get(CoroutineName.INSTANCE) + " [waitForMapLoadedOrTimeout] done, " + ((Unit) obj2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$channel");
        channel.mo2003trySendJP2dKIU(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$channel");
        channel.mo2003trySendJP2dKIU(null);
    }

    private final void j(TencentMap tencentMap, Activity activity, LatLng latLng, boolean darkMode) {
        if (darkMode) {
            tencentMap.setMapType(1008);
        }
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(activity.getDrawable(R.drawable.j7m));
        linearLayout.addView(imageView, ViewUtils.dpToPx(19.0f), ViewUtils.dpToPx(40.0f));
        linearLayout.addView(new Space(activity), ViewUtils.dpToPx(19.0f), ViewUtils.dpToPx(40.0f));
        Marker addMarker = tencentMap.addMarker(new MarkerOptions(latLng).icon(BitmapDescriptorFactory.fromView(linearLayout)).snippet(""));
        Intrinsics.checkNotNullExpressionValue(addMarker, "tencentMap.addMarker(\n  \u2026   .snippet(\"\")\n        )");
        addMarker.showInfoWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(com.tencent.mobileqq.aio.msg.template.b msgItem, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(context, "$context");
        f191690a.w(msgItem, context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(View view) {
        view.findViewById(R.id.eet).setVisibility(8);
        view.findViewById(R.id.f166184yx4).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0173 A[PHI: r6
  0x0173: PHI (r6v10 java.lang.Object) = (r6v9 java.lang.Object), (r6v1 java.lang.Object) binds: [B:17:0x0170, B:10:0x0038] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0172 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(double d16, double d17, boolean z16, Continuation<? super Bitmap> continuation) {
        AIOPositionMsgHelper$doMapSnapShot$1 aIOPositionMsgHelper$doMapSnapShot$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        String str;
        boolean z17;
        double d18;
        double d19;
        TencentMap tencentMap;
        ViewGroup viewGroup;
        QTextureMapView qTextureMapView;
        AIOPositionMsgHelper aIOPositionMsgHelper;
        if (continuation instanceof AIOPositionMsgHelper$doMapSnapShot$1) {
            aIOPositionMsgHelper$doMapSnapShot$1 = (AIOPositionMsgHelper$doMapSnapShot$1) continuation;
            int i16 = aIOPositionMsgHelper$doMapSnapShot$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIOPositionMsgHelper$doMapSnapShot$1.label = i16 - Integer.MIN_VALUE;
                obj = aIOPositionMsgHelper$doMapSnapShot$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIOPositionMsgHelper$doMapSnapShot$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z18 = aIOPositionMsgHelper$doMapSnapShot$1.Z$0;
                    double d26 = aIOPositionMsgHelper$doMapSnapShot$1.D$1;
                    double d27 = aIOPositionMsgHelper$doMapSnapShot$1.D$0;
                    tencentMap = (TencentMap) aIOPositionMsgHelper$doMapSnapShot$1.L$3;
                    viewGroup = (ViewGroup) aIOPositionMsgHelper$doMapSnapShot$1.L$2;
                    qTextureMapView = (QTextureMapView) aIOPositionMsgHelper$doMapSnapShot$1.L$1;
                    aIOPositionMsgHelper = (AIOPositionMsgHelper) aIOPositionMsgHelper$doMapSnapShot$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    z17 = z18;
                    d19 = d26;
                    d18 = d27;
                    str = "AIOPositionMsgHelper";
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext context = aIOPositionMsgHelper$doMapSnapShot$1.getContext();
                    CoroutineName.Companion companion = CoroutineName.INSTANCE;
                    QLog.d("AIOPositionMsgHelper", 2, context.get(companion) + " [doMapSnapShot]");
                    Activity topActivity = Foreground.getTopActivity();
                    if (topActivity != null && !topActivity.isFinishing()) {
                        if (d16 >= -90.0d && d16 <= 90.0d && d17 >= -180.0d && d17 <= 180.0d) {
                            LatLng latLng = new LatLng(d16, d17);
                            try {
                                QTextureMapView qTextureMapView2 = new QTextureMapView(topActivity);
                                View decorView = topActivity.getWindow().getDecorView();
                                Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                                ViewGroup viewGroup2 = (ViewGroup) decorView;
                                str = "AIOPositionMsgHelper";
                                viewGroup2.addView(qTextureMapView2, new ViewGroup.LayoutParams(ViewUtils.dpToPx(245.0f), ViewUtils.dpToPx(93.0f)));
                                qTextureMapView2.setAlpha(0.0f);
                                qTextureMapView2.setOpaque(false);
                                TencentMap tencentMap2 = qTextureMapView2.getMap();
                                Intrinsics.checkNotNullExpressionValue(tencentMap2, "tencentMap");
                                j(tencentMap2, topActivity, latLng, z16);
                                AIOPositionMsgHelper$doMapSnapShot$2 aIOPositionMsgHelper$doMapSnapShot$2 = new AIOPositionMsgHelper$doMapSnapShot$2(tencentMap2, latLng, qTextureMapView2, null);
                                aIOPositionMsgHelper$doMapSnapShot$1.L$0 = this;
                                aIOPositionMsgHelper$doMapSnapShot$1.L$1 = qTextureMapView2;
                                aIOPositionMsgHelper$doMapSnapShot$1.L$2 = viewGroup2;
                                aIOPositionMsgHelper$doMapSnapShot$1.L$3 = tencentMap2;
                                aIOPositionMsgHelper$doMapSnapShot$1.D$0 = d16;
                                aIOPositionMsgHelper$doMapSnapShot$1.D$1 = d17;
                                aIOPositionMsgHelper$doMapSnapShot$1.Z$0 = z16;
                                aIOPositionMsgHelper$doMapSnapShot$1.label = 1;
                                if (CoroutineScopeKt.coroutineScope(aIOPositionMsgHelper$doMapSnapShot$2, aIOPositionMsgHelper$doMapSnapShot$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                z17 = z16;
                                d18 = d16;
                                d19 = d17;
                                tencentMap = tencentMap2;
                                viewGroup = viewGroup2;
                                qTextureMapView = qTextureMapView2;
                                aIOPositionMsgHelper = this;
                            } catch (Exception e16) {
                                QLog.e("AIOPositionMsgHelper", 1, aIOPositionMsgHelper$doMapSnapShot$1.getContext().get(CoroutineName.INSTANCE) + " [doMapSnapShot] error! " + QLog.getStackTraceString(e16));
                                return null;
                            }
                        } else {
                            QLog.e("AIOPositionMsgHelper", 1, aIOPositionMsgHelper$doMapSnapShot$1.getContext().get(companion) + " [doMapSnapShot] lat or lng is invalid!");
                            return null;
                        }
                    } else {
                        QLog.e("AIOPositionMsgHelper", 1, aIOPositionMsgHelper$doMapSnapShot$1.getContext().get(companion) + " [doMapSnapShot] top activity is null");
                        return null;
                    }
                }
                QLog.d(str, 2, aIOPositionMsgHelper$doMapSnapShot$1.getContext().get(CoroutineName.INSTANCE) + " [doMapSnapShot] prepared");
                Intrinsics.checkNotNullExpressionValue(tencentMap, "tencentMap");
                String t16 = aIOPositionMsgHelper.t(d18, d19, z17);
                aIOPositionMsgHelper$doMapSnapShot$1.L$0 = null;
                aIOPositionMsgHelper$doMapSnapShot$1.L$1 = null;
                aIOPositionMsgHelper$doMapSnapShot$1.L$2 = null;
                aIOPositionMsgHelper$doMapSnapShot$1.L$3 = null;
                aIOPositionMsgHelper$doMapSnapShot$1.label = 2;
                obj = aIOPositionMsgHelper.A(tencentMap, t16, viewGroup, qTextureMapView, aIOPositionMsgHelper$doMapSnapShot$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        aIOPositionMsgHelper$doMapSnapShot$1 = new AIOPositionMsgHelper$doMapSnapShot$1(this, continuation);
        obj = aIOPositionMsgHelper$doMapSnapShot$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIOPositionMsgHelper$doMapSnapShot$1.label;
        if (i3 == 0) {
        }
        QLog.d(str, 2, aIOPositionMsgHelper$doMapSnapShot$1.getContext().get(CoroutineName.INSTANCE) + " [doMapSnapShot] prepared");
        Intrinsics.checkNotNullExpressionValue(tencentMap, "tencentMap");
        String t162 = aIOPositionMsgHelper.t(d18, d19, z17);
        aIOPositionMsgHelper$doMapSnapShot$1.L$0 = null;
        aIOPositionMsgHelper$doMapSnapShot$1.L$1 = null;
        aIOPositionMsgHelper$doMapSnapShot$1.L$2 = null;
        aIOPositionMsgHelper$doMapSnapShot$1.L$3 = null;
        aIOPositionMsgHelper$doMapSnapShot$1.label = 2;
        obj = aIOPositionMsgHelper.A(tencentMap, t162, viewGroup, qTextureMapView, aIOPositionMsgHelper$doMapSnapShot$1);
        if (obj != coroutine_suspended) {
        }
    }

    private final String o(String address, String name, String lat, String lon) {
        return "mqqapi://map/openmap?miniMapUrl=" + Uri.parse("https://mapdownload.map.qq.com/qqark?modules/poi/pages/index/index?").buildUpon().appendQueryParameter("strName", name).appendQueryParameter("address", address).appendQueryParameter("latitude", lat).appendQueryParameter("longitude", lon).build();
    }

    private final String p(String address) {
        return String.valueOf(address.hashCode());
    }

    private final String q() {
        return BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/MapSnapshot";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(double d16, double d17, boolean z16, Continuation<? super Bitmap> continuation) {
        AIOPositionMsgHelper$getMapSnapShot$1 aIOPositionMsgHelper$getMapSnapShot$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof AIOPositionMsgHelper$getMapSnapShot$1) {
            aIOPositionMsgHelper$getMapSnapShot$1 = (AIOPositionMsgHelper$getMapSnapShot$1) continuation;
            int i16 = aIOPositionMsgHelper$getMapSnapShot$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIOPositionMsgHelper$getMapSnapShot$1.label = i16 - Integer.MIN_VALUE;
                AIOPositionMsgHelper$getMapSnapShot$1 aIOPositionMsgHelper$getMapSnapShot$12 = aIOPositionMsgHelper$getMapSnapShot$1;
                Object obj = aIOPositionMsgHelper$getMapSnapShot$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIOPositionMsgHelper$getMapSnapShot$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Bitmap x16 = x(t(d16, d17, z16));
                    if (x16 == null) {
                        aIOPositionMsgHelper$getMapSnapShot$12.label = 1;
                        obj = n(d16, d17, z16, aIOPositionMsgHelper$getMapSnapShot$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return x16;
                    }
                }
                return (Bitmap) obj;
            }
        }
        aIOPositionMsgHelper$getMapSnapShot$1 = new AIOPositionMsgHelper$getMapSnapShot$1(this, continuation);
        AIOPositionMsgHelper$getMapSnapShot$1 aIOPositionMsgHelper$getMapSnapShot$122 = aIOPositionMsgHelper$getMapSnapShot$1;
        Object obj2 = aIOPositionMsgHelper$getMapSnapShot$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIOPositionMsgHelper$getMapSnapShot$122.label;
        if (i3 == 0) {
        }
        return (Bitmap) obj2;
    }

    private final String s(double lat, double lon, boolean darkMode) {
        String str;
        if (darkMode) {
            str = "true";
        } else {
            str = "false";
        }
        return "map_" + lat + "_" + lon + "_" + str + ".jpg";
    }

    private final String t(double lat, double lon, boolean darkMode) {
        return q() + "/" + s(lat, lon, darkMode);
    }

    public static /* synthetic */ FrameLayout v(AIOPositionMsgHelper aIOPositionMsgHelper, Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return aIOPositionMsgHelper.u(context, z16);
    }

    private final void w(com.tencent.mobileqq.aio.msg.template.b msgItem, Context context) {
        String e16;
        String b16;
        String c16;
        Activity activity;
        String a16 = msgItem.a();
        if (a16 == null || (e16 = msgItem.e()) == null || (b16 = msgItem.b()) == null || (c16 = msgItem.c()) == null) {
            return;
        }
        String o16 = o(a16, e16, b16, c16);
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            QLog.e("AIOPositionMsgHelper", 1, "context is not activity:" + context);
            return;
        }
        ((IAIOArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOArkApi.class)).jumpUrl(o16, msgItem.d(), activity, new com.tencent.qqnt.aio.adapter.api.b());
    }

    private final Bitmap x(String path) {
        if (!new File(path).exists()) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(path);
        } catch (IOException e16) {
            QLog.e("AIOPositionMsgHelper", 1, "readImage is error, " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String path, Bitmap bitmap) {
        try {
            File parentFile = new File(path).getParentFile();
            boolean z16 = false;
            if (parentFile != null && !parentFile.exists()) {
                z16 = true;
            }
            if (z16) {
                parentFile.mkdir();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e16) {
            QLog.e("AIOPositionMsgHelper", 1, "saveImage is error, " + e16);
        }
    }

    private final void z(View view) {
        view.findViewById(R.id.eet).setVisibility(0);
        view.findViewById(R.id.f166184yx4).setVisibility(4);
    }

    public final void k(@NotNull final Context context, @NotNull View view, @NotNull final com.tencent.mobileqq.aio.msg.template.b msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, view, msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        View findViewById2 = view.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.content)");
        View findViewById3 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.image)");
        ImageView imageView = (ImageView) findViewById3;
        Resources resources = context.getResources();
        z(view);
        ((TextView) findViewById).setText(msgItem.e());
        ((TextView) findViewById2).setText(msgItem.a());
        if (msgItem.d() != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.position.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AIOPositionMsgHelper.l(com.tencent.mobileqq.aio.msg.template.b.this, context, view2);
                }
            });
        }
        GlobalScope globalScope = GlobalScope.INSTANCE;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        String e16 = msgItem.e();
        if (e16 == null) {
            e16 = "";
        }
        BuildersKt__Builders_commonKt.launch$default(globalScope, main.plus(new CoroutineName(p(e16))), null, new AIOPositionMsgHelper$bindView$2(msgItem, view, imageView, resources, null), 2, null);
    }

    @NotNull
    public final FrameLayout u(@NotNull Context context, boolean needRoundRadius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(needRoundRadius));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout frameLayout2 = new FrameLayout(context);
        LayoutInflater from = LayoutInflater.from(context);
        from.inflate(R.layout.dww, frameLayout2);
        from.inflate(R.layout.dz8, frameLayout2);
        if (needRoundRadius) {
            ab.d(frameLayout2, ViewUtils.dpToPx(10.0f));
        }
        ArkAppLoadLayout arkAppLoadLayout = (ArkAppLoadLayout) frameLayout2.findViewById(R.id.eet);
        ViewGroup.LayoutParams layoutParams = arkAppLoadLayout.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        arkAppLoadLayout.setLayoutParams(layoutParams);
        arkAppLoadLayout.c();
        frameLayout.addView(frameLayout2, -1, -2);
        return frameLayout;
    }
}
