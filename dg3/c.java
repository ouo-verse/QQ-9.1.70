package dg3;

import android.graphics.Bitmap;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0012B-\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!\u00a8\u0006("}, d2 = {"Ldg3/c;", "", "", "avatarInfo", "", "g", "faceJson", "", "position", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "callback", "e", "Ljava/lang/Runnable;", "runnable", "d", "j", h.F, "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "a", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "gyfzPlanController", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "b", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "thumbnailGenerateQueue", "", "c", "Z", "isRunning", "()Z", "i", "(Z)V", "Leg3/a;", "Leg3/a;", "performanceReport", "thumbnailWidth", "thumbnailHeight", "templateJsonPath", "<init>", "(IILjava/lang/String;Leg3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanController gyfzPlanController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<Runnable> thumbnailGenerateQueue = new ConcurrentLinkedQueue<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private eg3.a performanceReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"dg3/c$b", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements GYFZPlanController.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f393768a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f393769b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GYScreenShotCallback f393770c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"dg3/c$b$a", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onScreenShot", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements GYScreenShotCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f393771a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f393772b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ GYScreenShotCallback f393773c;

            a(int i3, c cVar, GYScreenShotCallback gYScreenShotCallback) {
                this.f393771a = i3;
                this.f393772b = cVar;
                this.f393773c = gYScreenShotCallback;
            }

            @Override // com.tencent.filament.zplan.listener.GYScreenShotCallback
            public void onScreenShot(Bitmap bitmap) {
                QLog.d("FilamentThumbnailRender", 1, " onScreenShot position:" + this.f393771a);
                if (this.f393772b.gyfzPlanController == null) {
                    this.f393772b.i(false);
                    return;
                }
                GYScreenShotCallback gYScreenShotCallback = this.f393773c;
                if (gYScreenShotCallback != null) {
                    gYScreenShotCallback.onScreenShot(bitmap);
                }
                eg3.a aVar = this.f393772b.performanceReport;
                if (aVar != null) {
                    aVar.b("GENERATE_THUMBNAIL_END", this.f393771a);
                }
                this.f393772b.i(false);
                this.f393772b.j();
            }
        }

        b(int i3, c cVar, GYScreenShotCallback gYScreenShotCallback) {
            this.f393768a = i3;
            this.f393769b = cVar;
            this.f393770c = gYScreenShotCallback;
        }

        @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.c
        public void a(int result, int requestId) {
            QLog.d("FilamentThumbnailRender", 1, " onSetAvatarResult position:" + this.f393768a + "\uff0c" + result + ", " + requestId);
            if (this.f393769b.gyfzPlanController != null) {
                eg3.a aVar = this.f393769b.performanceReport;
                if (aVar != null) {
                    aVar.b("GENERATE_THUMBNAIL_BEFORE_FINISH_LOADING", this.f393768a);
                }
                GYFZPlanController gYFZPlanController = this.f393769b.gyfzPlanController;
                if (gYFZPlanController != null) {
                    gYFZPlanController.u0(new a(this.f393768a, this.f393769b, this.f393770c));
                    return;
                }
                return;
            }
            this.f393769b.i(false);
        }
    }

    public c(int i3, int i16, String str, eg3.a aVar) {
        QLog.d("FilamentThumbnailRender", 1, "constructor templateJsonPath:" + str);
        if (str != null) {
            GYFZPlanController gYFZPlanController = new GYFZPlanController(new RenderSize(i3, i16), true, false, 4, null);
            gYFZPlanController.m0(str);
            this.gyfzPlanController = gYFZPlanController;
        }
        this.performanceReport = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, int i3, String str, String str2, GYScreenShotCallback gYScreenShotCallback) {
        GYFZPlanController gYFZPlanController;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eg3.a aVar = this$0.performanceReport;
        if (aVar != null) {
            aVar.b("GENERATE_THUMBNAIL_BEGIN", i3);
        }
        QLog.d("FilamentThumbnailRender", 1, " runnable generateThumbnail position:" + i3);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (str != null && str2 != null && account != null && (gYFZPlanController = this$0.gyfzPlanController) != null) {
            if (gYFZPlanController != null) {
                GYFZPlanController.i0(gYFZPlanController, str, str2, i3, null, 8, null);
            }
            GYFZPlanController gYFZPlanController2 = this$0.gyfzPlanController;
            if (gYFZPlanController2 != null) {
                gYFZPlanController2.n0(new b(i3, this$0, gYScreenShotCallback));
                return;
            }
            return;
        }
        QLog.e("FilamentThumbnailRender", 1, " generateThumbnail failed, faceJson: " + str2);
        this$0.isRunning = false;
        this$0.j();
    }

    public final void d(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.thumbnailGenerateQueue.add(runnable);
        j();
    }

    public final void e(final String avatarInfo, final String faceJson, final int position, final GYScreenShotCallback callback) {
        d(new Runnable() { // from class: dg3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.this, position, avatarInfo, faceJson, callback);
            }
        });
    }

    public final void h() {
        this.thumbnailGenerateQueue.clear();
        GYFZPlanController gYFZPlanController = this.gyfzPlanController;
        if (gYFZPlanController != null) {
            GYFZPlanController.z(gYFZPlanController, null, 1, null);
        }
        this.gyfzPlanController = null;
    }

    public final void i(boolean z16) {
        this.isRunning = z16;
    }

    public final void j() {
        QLog.d("FilamentThumbnailRender", 1, "triggerGenerateTask isRunning " + this.isRunning + ", thumbnailGenerateQueue size:" + this.thumbnailGenerateQueue.size());
        if (!this.isRunning && this.thumbnailGenerateQueue.size() > 0) {
            this.isRunning = true;
            Runnable poll = this.thumbnailGenerateQueue.poll();
            if (poll != null) {
                poll.run();
                return;
            } else {
                j();
                return;
            }
        }
        if (this.thumbnailGenerateQueue.size() == 0) {
            this.isRunning = false;
        }
    }

    public final void g(String avatarInfo) {
        e(avatarInfo, "{\n  \"Colors\" : [\n    {\n      \"B\" : 252,\n      \"G\" : 255,\n      \"R\" : 255,\n      \"SlotID\" : 101\n    },\n    {\n      \"B\" : 148,\n      \"G\" : 160,\n      \"R\" : 222,\n      \"SlotID\" : 109\n    },\n    {\n      \"B\" : 8,\n      \"G\" : 10,\n      \"R\" : 11,\n      \"SlotID\" : 4\n    },\n    {\n      \"B\" : 86,\n      \"G\" : 91,\n      \"R\" : 119,\n      \"SlotID\" : 103\n    }\n  ],\n  \"ControlPoint\" : {\n    \"EyePoint\" : [\n      {\n        \"GroupID\" : 1,\n        \"Pos\" : 0.013330265879631042\n      },\n      {\n        \"GroupID\" : 2,\n        \"Pos\" : 0.29224526882171631\n      },\n      {\n        \"GroupID\" : 3,\n        \"Pos\" : 0.54087400436401367\n      },\n      {\n        \"GroupID\" : 4,\n        \"Pos\" : -0.60385227203369141\n      },\n      {\n        \"GroupID\" : 5,\n        \"Pos\" : 0.28559347987174988\n      },\n      {\n        \"GroupID\" : 6,\n        \"Pos\" : 0.26505604386329651\n      },\n      {\n        \"GroupID\" : 7,\n        \"Pos\" : -0.55581778287887573\n      },\n      {\n        \"GroupID\" : 8,\n        \"Pos\" : -0.29774650931358337\n      },\n      {\n        \"GroupID\" : 9,\n        \"Pos\" : -0.017534727230668068\n      },\n      {\n        \"GroupID\" : 10,\n        \"Pos\" : -0.60558247566223145\n      },\n      {\n        \"GroupID\" : 11,\n        \"Pos\" : 0.80102849006652832\n      },\n      {\n        \"GroupID\" : 12,\n        \"Pos\" : 0.14222368597984314\n      },\n      {\n        \"GroupID\" : 13,\n        \"Pos\" : 0.18449175357818604\n      },\n      {\n        \"GroupID\" : 14,\n        \"Pos\" : -1.4998657703399658\n      },\n      {\n        \"GroupID\" : 63,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 64,\n        \"Pos\" : -0.1705024391412735\n      },\n      {\n        \"GroupID\" : 65,\n        \"Pos\" : -0.1705024391412735\n      },\n      {\n        \"GroupID\" : 66,\n        \"Pos\" : -0.11976397037506104\n      },\n      {\n        \"GroupID\" : 67,\n        \"Pos\" : 0.16673938930034637\n      },\n      {\n        \"GroupID\" : 68,\n        \"Pos\" : 0.17534524202346802\n      },\n      {\n        \"GroupID\" : 69,\n        \"Pos\" : -0.046601474285125732\n      },\n      {\n        \"GroupID\" : 70,\n        \"Pos\" : -0.21533440053462982\n      },\n      {\n        \"GroupID\" : 71,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 72,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 73,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 74,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 75,\n        \"Pos\" : 0\n      }\n    ],\n    \"EyesBrowPoint\" : [\n      {\n        \"GroupID\" : 15,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 16,\n        \"Pos\" : -0.63542747497558594\n      },\n      {\n        \"GroupID\" : 17,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 18,\n        \"Pos\" : -0.59084403514862061\n      },\n      {\n        \"GroupID\" : 19,\n        \"Pos\" : 0.008008360862731934\n      },\n      {\n        \"GroupID\" : 20,\n        \"Pos\" : -1\n      },\n      {\n        \"GroupID\" : 21,\n        \"Pos\" : 0\n      }\n    ],\n    \"FacePoint\" : [\n      {\n        \"GroupID\" : 31,\n        \"Pos\" : -0.17162075638771057\n      },\n      {\n        \"GroupID\" : 32,\n        \"Pos\" : 0.39431494474411011\n      },\n      {\n        \"GroupID\" : 33,\n        \"Pos\" : -0.031166410073637962\n      },\n      {\n        \"GroupID\" : 34,\n        \"Pos\" : -0.0053319623693823814\n      },\n      {\n        \"GroupID\" : 35,\n        \"Pos\" : -0.39661788940429688\n      },\n      {\n        \"GroupID\" : 36,\n        \"Pos\" : 1.044539213180542\n      },\n      {\n        \"GroupID\" : 37,\n        \"Pos\" : 0.25929516553878784\n      },\n      {\n        \"GroupID\" : 38,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 39,\n        \"Pos\" : 0.052318297326564789\n      },\n      {\n        \"GroupID\" : 40,\n        \"Pos\" : -0.88551759719848633\n      },\n      {\n        \"GroupID\" : 41,\n        \"Pos\" : -0.61033391952514648\n      },\n      {\n        \"GroupID\" : 42,\n        \"Pos\" : 0.16576820611953735\n      },\n      {\n        \"GroupID\" : 43,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 44,\n        \"Pos\" : -0.33215060830116272\n      },\n      {\n        \"GroupID\" : 45,\n        \"Pos\" : -0.80760514736175537\n      },\n      {\n        \"GroupID\" : 46,\n        \"Pos\" : 0.35158181190490723\n      },\n      {\n        \"GroupID\" : 47,\n        \"Pos\" : 0.20444649457931519\n      },\n      {\n        \"GroupID\" : 48,\n        \"Pos\" : -0.10229596495628357\n      },\n      {\n        \"GroupID\" : 61,\n        \"Pos\" : 0.14053192734718323\n      },\n      {\n        \"GroupID\" : 85,\n        \"Pos\" : -0.084473945200443268\n      },\n      {\n        \"GroupID\" : 86,\n        \"Pos\" : 0.020163942128419876\n      },\n      {\n        \"GroupID\" : 87,\n        \"Pos\" : -0.087893471121788025\n      },\n      {\n        \"GroupID\" : 88,\n        \"Pos\" : -0.057291112840175629\n      },\n      {\n        \"GroupID\" : 89,\n        \"Pos\" : -0.29555115103721619\n      },\n      {\n        \"GroupID\" : 90,\n        \"Pos\" : 0.40124499797821045\n      },\n      {\n        \"GroupID\" : 91,\n        \"Pos\" : -0.15837636590003967\n      },\n      {\n        \"GroupID\" : 92,\n        \"Pos\" : 0.23564872145652771\n      },\n      {\n        \"GroupID\" : 93,\n        \"Pos\" : -0.16756673157215118\n      },\n      {\n        \"GroupID\" : 94,\n        \"Pos\" : 0.16245858371257782\n      },\n      {\n        \"GroupID\" : 96,\n        \"Pos\" : 0\n      },\n      {\n        \"GroupID\" : 97,\n        \"Pos\" : 0\n      }\n    ],\n    \"MouthPoint\" : [\n      {\n        \"GroupID\" : 49,\n        \"Pos\" : -1.5\n      },\n      {\n        \"GroupID\" : 50,\n        \"Pos\" : 0.29094648361206055\n      },\n      {\n        \"GroupID\" : 51,\n        \"Pos\" : -0.49997639656066895\n      },\n      {\n        \"GroupID\" : 52,\n        \"Pos\" : 0.1627262681722641\n      },\n      {\n        \"GroupID\" : 53,\n        \"Pos\" : 0.40053072571754456\n      },\n      {\n        \"GroupID\" : 54,\n        \"Pos\" : 0.037455085664987564\n      },\n      {\n        \"GroupID\" : 55,\n        \"Pos\" : 0.63751053810119629\n      },\n      {\n        \"GroupID\" : 56,\n        \"Pos\" : -0.040000386536121368\n      },\n      {\n        \"GroupID\" : 57,\n        \"Pos\" : -0.20435260236263275\n      },\n      {\n        \"GroupID\" : 58,\n        \"Pos\" : -0.56115955114364624\n      },\n      {\n        \"GroupID\" : 59,\n        \"Pos\" : 0.49383366107940674\n      },\n      {\n        \"GroupID\" : 60,\n        \"Pos\" : 0.078861802816390991\n      }\n    ],\n    \"NosePoint\" : [\n      {\n        \"GroupID\" : 22,\n        \"Pos\" : 0.008526632562279701\n      },\n      {\n        \"GroupID\" : 23,\n        \"Pos\" : -0.3071897029876709\n      },\n      {\n        \"GroupID\" : 24,\n        \"Pos\" : -0.75134038925170898\n      },\n      {\n        \"GroupID\" : 25,\n        \"Pos\" : 0.20501013100147247\n      },\n      {\n        \"GroupID\" : 26,\n        \"Pos\" : -0.076479673385620117\n      },\n      {\n        \"GroupID\" : 27,\n        \"Pos\" : 0.07502332329750061\n      },\n      {\n        \"GroupID\" : 28,\n        \"Pos\" : 0.18504677712917328\n      },\n      {\n        \"GroupID\" : 29,\n        \"Pos\" : 0.36001896858215332\n      },\n      {\n        \"GroupID\" : 30,\n        \"Pos\" : -0.22559581696987152\n      }\n    ]\n  },\n  \"EyeBlinkScaleRatio\" : 0.69780343770980835,\n  \"HandleVer\" : \"1.9000\",\n  \"Makeup\" : [\n    {\n      \"ShapeID\" : 501000012,\n      \"SlotID\" : 4\n    },\n    {\n      \"ShapeID\" : 307010004,\n      \"SlotID\" : 3\n    },\n    {\n      \"ShapeID\" : 403000043,\n      \"SlotID\" : 103\n    },\n    {\n      \"ShapeID\" : 407000022,\n      \"SlotID\" : 107\n    },\n    {\n      \"ShapeID\" : 405000006,\n      \"SlotID\" : 105\n    },\n    {\n      \"ShapeID\" : 405000006,\n      \"SlotID\" : 105\n    },\n    {\n      \"ShapeID\" : 409009001,\n      \"SlotID\" : 117\n    }\n  ],\n  \"ModelVer\" : \"1.9000\"\n}", -1, null);
    }
}
