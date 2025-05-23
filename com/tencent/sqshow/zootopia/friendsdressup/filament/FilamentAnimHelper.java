package com.tencent.sqshow.zootopia.friendsdressup.filament;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001b\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ.\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0002J\u001e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\u0006J+\u0010%\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001a06j\b\u0012\u0004\u0012\u00020\u001a`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u0015R\u0018\u0010?\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentAnimHelper;", "", "", "B", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "", "uin", "headMontagePath", "bodyMontagePath", "w", "y", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "errorMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animations", "Lcom/tencent/filament/zplan/animation/b;", "D", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;[Lcom/tencent/filament/zplan/animation/ZPlanAction;)Lcom/tencent/filament/zplan/animation/b;", "Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "executor", "p", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/g;", "l", "o", "Lorg/json/JSONObject;", "avatarPbJson", "v", BdhLogUtil.LogTag.Tag_Conn, "", "now", "", "t", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "u", "()Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "uinAnimMap", "c", "Lcom/tencent/filament/zplan/animation/b;", "maleInitAnim", "d", "femaleInitAnim", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "e", "Ljava/util/HashSet;", "animListener", "f", "animBeginTime", "g", "Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "taskExecutor", "Ljava/util/concurrent/atomic/AtomicBoolean;", tl.h.F, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFemale", "<init>", "(Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;)V", "i", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FilamentAnimHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, com.tencent.filament.zplan.animation.b> uinAnimMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b maleInitAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b femaleInitAnim;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashSet<g> animListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private double animBeginTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private i taskExecutor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isFemale;

    public FilamentAnimHelper(FilamentUrlTemplate urlTemplate) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        this.urlTemplate = urlTemplate;
        this.uinAnimMap = new ConcurrentHashMap<>();
        this.animListener = new HashSet<>();
        this.isFemale = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(FilamentAnimHelper this$0, String errorMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        Iterator<T> it = this$0.animListener.iterator();
        while (it.hasNext()) {
            ((g) it.next()).e(errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String uin) {
        if (this.uinAnimMap.get(uin) != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.b
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentAnimHelper.r(FilamentAnimHelper.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(FilamentAnimHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.animListener.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c();
        }
    }

    private final void w(FilamentViewerV2 viewer, String uin, String headMontagePath, String bodyMontagePath) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FilamentAnimHelper$loadAnimRes$1(this, uin, viewer, headMontagePath, bodyMontagePath, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x(FilamentViewerV2 filamentViewerV2, Continuation<? super Unit> continuation) {
        return CoroutineScopeKt.coroutineScope(new FilamentAnimHelper$loadFemaleInitAnim$2(this, filamentViewerV2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y(FilamentViewerV2 filamentViewerV2, Continuation<? super Unit> continuation) {
        return CoroutineScopeKt.coroutineScope(new FilamentAnimHelper$loadMaleInitAnim$2(this, filamentViewerV2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.c
            @Override // java.lang.Runnable
            public final void run() {
                FilamentAnimHelper.A(FilamentAnimHelper.this, errorMsg);
            }
        });
    }

    public final void C() {
        B();
    }

    public final void o(g l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.animListener.add(l3);
    }

    public final void p(i executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.taskExecutor = executor;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:10)(2:14|15))(2:16|(2:18|19)(5:20|21|(1:23)(1:27)|24|(1:26)))|11|12))|30|6|7|(0)(0)|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002d, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        com.tencent.qphone.base.util.QLog.e("FilamentAnimHelper_", 1, "loadAnimRes failed", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        FilamentAnimHelper$downloadAnimRes$1 filamentAnimHelper$downloadAnimRes$1;
        Object coroutine_suspended;
        int i3;
        EnumUserGender enumUserGender;
        if (continuation instanceof FilamentAnimHelper$downloadAnimRes$1) {
            filamentAnimHelper$downloadAnimRes$1 = (FilamentAnimHelper$downloadAnimRes$1) continuation;
            int i16 = filamentAnimHelper$downloadAnimRes$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                filamentAnimHelper$downloadAnimRes$1.label = i16 - Integer.MIN_VALUE;
                FilamentAnimHelper$downloadAnimRes$1 filamentAnimHelper$downloadAnimRes$12 = filamentAnimHelper$downloadAnimRes$1;
                Object obj = filamentAnimHelper$downloadAnimRes$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = filamentAnimHelper$downloadAnimRes$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.uinAnimMap.get(str) != null) {
                        return Unit.INSTANCE;
                    }
                    com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "downloadAnimRes start");
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                    if (this.isFemale.get()) {
                        enumUserGender = EnumUserGender.GENDER_FEMALE;
                    } else {
                        enumUserGender = EnumUserGender.GENDER_MALE;
                    }
                    FilamentUrlTemplate filamentUrlTemplate = this.urlTemplate;
                    filamentAnimHelper$downloadAnimRes$12.label = 1;
                    if (zPlanAvatarResourceHelper.B(null, enumUserGender, str2, str3, filamentUrlTemplate, filamentAnimHelper$downloadAnimRes$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "downloadAnimRes end");
                return Unit.INSTANCE;
            }
        }
        filamentAnimHelper$downloadAnimRes$1 = new FilamentAnimHelper$downloadAnimRes$1(this, continuation);
        FilamentAnimHelper$downloadAnimRes$1 filamentAnimHelper$downloadAnimRes$122 = filamentAnimHelper$downloadAnimRes$1;
        Object obj2 = filamentAnimHelper$downloadAnimRes$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = filamentAnimHelper$downloadAnimRes$122.label;
        if (i3 != 0) {
        }
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "downloadAnimRes end");
        return Unit.INSTANCE;
    }

    public final boolean t(FilamentViewerV2 viewer, double now, String uin) {
        double d16;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.filament.zplan.animation.b bVar = this.uinAnimMap.get(uin);
        if (bVar == null) {
            if (this.isFemale.get()) {
                bVar = this.femaleInitAnim;
            } else {
                bVar = this.maleInitAnim;
            }
        }
        if (bVar == null) {
            return false;
        }
        double d17 = this.animBeginTime;
        if (d17 == 0.0d) {
            this.animBeginTime = now;
            d16 = 0.0d;
        } else {
            d16 = now - d17;
        }
        double b16 = bVar.b();
        if (d16 > b16 && b16 > 0.0d) {
            QLog.i("FilamentAnimHelper_", 1, "anim End. animDuration:" + b16);
            B();
            return false;
        }
        if (d16 == 0.0d) {
            QLog.i("FilamentAnimHelper_", 1, "anim Start.");
        }
        viewer.playAnimationWithTrackGroup(bVar, d16);
        return true;
    }

    /* renamed from: u, reason: from getter */
    public final FilamentUrlTemplate getUrlTemplate() {
        return this.urlTemplate;
    }

    public final void v(FilamentViewerV2 viewer, JSONObject avatarPbJson, String uin, String headMontagePath, String bodyMontagePath) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(avatarPbJson, "avatarPbJson");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(headMontagePath, "headMontagePath");
        Intrinsics.checkNotNullParameter(bodyMontagePath, "bodyMontagePath");
        this.isFemale.set(avatarPbJson.optInt("gender", 1) == 2);
        w(viewer, uin, headMontagePath, bodyMontagePath);
    }

    private final void B() {
        this.animBeginTime = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.filament.zplan.animation.b D(FilamentViewerV2 viewer, ZPlanAction[] animations) {
        List list;
        Object first;
        Object first2;
        list = ArraysKt___ArraysKt.toList(animations);
        QLog.i("FilamentAnimHelper_", 1, "trackGroupWithAnimations animations:" + list);
        com.tencent.filament.zplan.animation.b bVar = new com.tencent.filament.zplan.animation.b();
        com.tencent.filament.zplan.animation.a aVar = new com.tencent.filament.zplan.animation.a();
        com.tencent.filament.zplan.animation.a aVar2 = new com.tencent.filament.zplan.animation.a();
        for (ZPlanAction zPlanAction : animations) {
            FilamentAnimation[] loadAnimation$default = FilamentViewerV2.loadAnimation$default(viewer, zPlanAction.getFaceAnimationGltfPath(), null, 2, null);
            if (!(loadAnimation$default.length == 0)) {
                first2 = ArraysKt___ArraysKt.first(loadAnimation$default);
                FilamentAnimation filamentAnimation = (FilamentAnimation) first2;
                QLog.i("FilamentAnimHelper_", 1, "trackGroupWithAnimations faceAnimation:" + f.a(filamentAnimation));
                aVar.a(filamentAnimation);
            } else {
                QLog.e("FilamentAnimHelper_", 1, "trackGroupWithAnimations faceAnimation is Empty");
            }
            FilamentAnimation[] loadAnimation$default2 = FilamentViewerV2.loadAnimation$default(viewer, zPlanAction.getBodyAnimationGltfPath(), null, 2, null);
            if (!(loadAnimation$default2.length == 0)) {
                first = ArraysKt___ArraysKt.first(loadAnimation$default2);
                FilamentAnimation filamentAnimation2 = (FilamentAnimation) first;
                QLog.i("FilamentAnimHelper_", 1, "trackGroupWithAnimations bodyAnimation:" + f.a(filamentAnimation2));
                aVar2.a(filamentAnimation2);
            } else {
                QLog.e("FilamentAnimHelper_", 1, "trackGroupWithAnimations bodyAnimation is Empty");
            }
        }
        bVar.a(aVar);
        bVar.a(aVar2);
        return bVar;
    }
}
