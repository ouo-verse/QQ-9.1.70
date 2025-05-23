package com.tencent.aelight.camera.ae.flashshow.ui.multicamera;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ax;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH&J4\u0010\u0014\u001a\u00020\u00022*\u0010\u0013\u001a&\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u0012H&J\b\u0010\u0015\u001a\u00020\u0002H&R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R*\u0010/\u001a\n (*\u0004\u0018\u00010'0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00105\u001a\u0002008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraBasePart;", "Llq/a;", "", "t", "e", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel$Ratio;", "ratio", "", "cameraHeight", "cameraWith", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS, HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "y", "B", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "getMActivity", "()Landroid/app/Activity;", "mActivity", "Landroid/view/View;", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "mRootView", "Llq/b;", "D", "Llq/b;", "getMPartManger", "()Llq/b;", "mPartManger", "Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "r", "()Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "setMUnit", "(Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;)V", "mUnit", "Lcom/tencent/aelight/camera/ae/flashshow/ax;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/aelight/camera/ae/flashshow/ax;", "lsMultiCameraViewModel", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class AECameraMultiCameraBasePart extends lq.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private final lq.b mPartManger;

    /* renamed from: E, reason: from kotlin metadata */
    private LSMultiCameraUnit mUnit;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy lsMultiCameraViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Activity mActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AECameraMultiCameraBasePart(Activity mActivity, View mRootView, lq.b mPartManger) {
        super(mActivity, mRootView, mPartManger);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(mPartManger, "mPartManger");
        this.mActivity = mActivity;
        this.mRootView = mRootView;
        this.mPartManger = mPartManger;
        this.mUnit = (LSMultiCameraUnit) mPartManger.b(65537, new Object[0]);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ax>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart$lsMultiCameraViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ax invoke() {
                return (ax) com.tencent.aelight.camera.ae.n.a(AECameraMultiCameraBasePart.this.getMUnit()).get(ax.class);
            }
        });
        this.lsMultiCameraViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public abstract void A();

    public abstract void B();

    public abstract void C(AEVideoStoryTopBarViewModel.Ratio ratio, int cameraHeight, int cameraWith);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lq.a
    public void e() {
        A();
        t();
        s();
    }

    public final ax q() {
        return (ax) this.lsMultiCameraViewModel.getValue();
    }

    /* renamed from: r, reason: from getter */
    public final LSMultiCameraUnit getMUnit() {
        return this.mUnit;
    }

    public abstract void s();

    public void t() {
        MutableLiveData<ax.a> P1 = q().P1();
        LSMultiCameraUnit lSMultiCameraUnit = this.mUnit;
        final Function1<ax.a, Unit> function1 = new Function1<ax.a, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ax.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ax.a aVar) {
                int status = aVar.getStatus();
                if (status == 1) {
                    AECameraMultiCameraBasePart.this.z();
                } else if (status == 2) {
                    AECameraMultiCameraBasePart.this.x(aVar.getCom.tencent.aelight.camera.pref.api.IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS java.lang.String());
                } else if (status == 3) {
                    AECameraMultiCameraBasePart.this.y(aVar.a());
                }
                VideoReport.traverseExposure();
            }
        };
        P1.observe(lSMultiCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECameraMultiCameraBasePart.u(Function1.this, obj);
            }
        });
        MutableLiveData<ax.c> Z1 = q().Z1();
        LSMultiCameraUnit lSMultiCameraUnit2 = this.mUnit;
        final Function1<ax.c, Unit> function12 = new Function1<ax.c, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ax.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ax.c cVar) {
                if (cVar.getStatus() == 2) {
                    AECameraMultiCameraBasePart.this.B();
                }
            }
        };
        Z1.observe(lSMultiCameraUnit2, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECameraMultiCameraBasePart.v(Function1.this, obj);
            }
        });
        MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> O1 = q().O1();
        LSMultiCameraUnit lSMultiCameraUnit3 = this.mUnit;
        final Function1<AEVideoStoryTopBarViewModel.Ratio, Unit> function13 = new Function1<AEVideoStoryTopBarViewModel.Ratio, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart$initViewModel$3

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes32.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f64915a;

                static {
                    int[] iArr = new int[AEVideoStoryTopBarViewModel.Ratio.values().length];
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.R_4_3.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.R_1_1.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.R_16_9.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.FULL.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f64915a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AEVideoStoryTopBarViewModel.Ratio ratio) {
                invoke2(ratio);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AEVideoStoryTopBarViewModel.Ratio ratio) {
                View view;
                float f16;
                float f17;
                float f18;
                Resources resources;
                DisplayMetrics displayMetrics;
                if (ratio == null) {
                    return;
                }
                view = ((lq.a) AECameraMultiCameraBasePart.this).f415376e;
                int i3 = (view == null || (resources = view.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1080 : displayMetrics.widthPixels;
                int i16 = a.f64915a[ratio.ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            f16 = i3;
                            f17 = 0.5625f;
                        } else if (i16 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f18 = i3 / 1.0f;
                    AECameraMultiCameraBasePart.this.C(ratio, (int) f18, i3);
                }
                f16 = i3;
                f17 = 0.75f;
                f18 = f16 / f17;
                AECameraMultiCameraBasePart.this.C(ratio, (int) f18, i3);
            }
        };
        O1.observe(lSMultiCameraUnit3, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECameraMultiCameraBasePart.w(Function1.this, obj);
            }
        });
    }

    public abstract void x(int selectCamera);

    public abstract void y(HashMap<String, String> map);

    public abstract void z();
}
