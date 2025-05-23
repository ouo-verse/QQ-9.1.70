package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.zplantracing.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b7\u00108J+\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u0012J?\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00100\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\"\u00106\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/sharedengine/anim/state/AnimState;", "Lcom/tencent/sqshow/sharedengine/anim/state/b;", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animations", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "Lcom/tencent/filament/zplan/animation/b;", DomainData.DOMAIN_NAME, "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)Lcom/tencent/filament/zplan/animation/b;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "i", "Lr74/b;", "stateContext", "", "now", "", "c", "f", "j", "", "facePath", "bodyPath", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "e", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "actionId", "d", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;ILcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lq74/a;", "a", "Lq74/a;", h.F, "()Lq74/a;", "params", "b", "Lcom/tencent/filament/zplan/animation/b;", "getAnimTrackGroupFeMale", "()Lcom/tencent/filament/zplan/animation/b;", "k", "(Lcom/tencent/filament/zplan/animation/b;)V", "animTrackGroupFeMale", "getAnimTrackGroupMale", "l", "animTrackGroupMale", "D", "g", "()D", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(D)V", "animateBeginTime", "<init>", "(Lq74/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class AnimState implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q74.a params;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b animTrackGroupFeMale;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b animTrackGroupMale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private double animateBeginTime;

    public AnimState(q74.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
    }

    public void c(r74.b stateContext, EnumUserGender gender, double now, c zplanSpanContext) {
        com.tencent.filament.zplan.animation.b bVar;
        FilamentViewerV2 viewerV2;
        Intrinsics.checkNotNullParameter(stateContext, "stateContext");
        Intrinsics.checkNotNullParameter(gender, "gender");
        double d16 = this.animateBeginTime;
        double d17 = 0.0d;
        if (d16 == 0.0d) {
            this.animateBeginTime = now;
        } else {
            d17 = now - d16;
        }
        if (gender == EnumUserGender.GENDER_FEMALE) {
            bVar = this.animTrackGroupFeMale;
        } else {
            bVar = this.animTrackGroupMale;
        }
        if (bVar == null || (viewerV2 = this.params.getViewerV2()) == null) {
            return;
        }
        viewerV2.playAnimationWithTrackGroup(bVar, d17);
    }

    public final Object d(c cVar, EnumUserGender enumUserGender, int i3, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super com.tencent.filament.zplan.animation.b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        BuildersKt__Builders_commonKt.launch$default(this.params.getScope(), null, null, new AnimState$fetchAnimByActionId$2$1(this, enumUserGender, i3, cVar, filamentUrlTemplate, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object e(c cVar, EnumUserGender enumUserGender, String str, String str2, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super com.tencent.filament.zplan.animation.b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        BuildersKt__Builders_commonKt.launch$default(this.params.getScope(), null, null, new AnimState$fetchAnimByPath$2$1(str, str2, this, cVar, enumUserGender, filamentUrlTemplate, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final double f(EnumUserGender gender) {
        com.tencent.filament.zplan.animation.b bVar;
        Intrinsics.checkNotNullParameter(gender, "gender");
        if (gender == EnumUserGender.GENDER_FEMALE) {
            bVar = this.animTrackGroupFeMale;
        } else {
            bVar = this.animTrackGroupMale;
        }
        if (bVar != null) {
            return bVar.b();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g, reason: from getter */
    public final double getAnimateBeginTime() {
        return this.animateBeginTime;
    }

    /* renamed from: h, reason: from getter */
    public final q74.a getParams() {
        return this.params;
    }

    public boolean i(EnumUserGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        if (gender == EnumUserGender.GENDER_FEMALE) {
            if (this.animTrackGroupFeMale != null) {
                return true;
            }
        } else if (this.animTrackGroupMale != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(com.tencent.filament.zplan.animation.b bVar) {
        this.animTrackGroupFeMale = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(com.tencent.filament.zplan.animation.b bVar) {
        this.animTrackGroupMale = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(double d16) {
        this.animateBeginTime = d16;
    }

    public final void j() {
        this.animateBeginTime = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.filament.zplan.animation.b n(ZPlanAction[] animations, c zplanSpanContext) {
        List list;
        Object first;
        Object first2;
        FilamentViewerV2 viewerV2 = this.params.getViewerV2();
        if (viewerV2 == null) {
            return null;
        }
        list = ArraysKt___ArraysKt.toList(animations);
        QLog.i("AnimState", 1, "trackGroupWithAnimations animations:" + list);
        com.tencent.filament.zplan.animation.b bVar = new com.tencent.filament.zplan.animation.b();
        com.tencent.filament.zplan.animation.a aVar = new com.tencent.filament.zplan.animation.a();
        com.tencent.filament.zplan.animation.a aVar2 = new com.tencent.filament.zplan.animation.a();
        for (ZPlanAction zPlanAction : animations) {
            FilamentAnimation[] loadAnimation = viewerV2.loadAnimation(zPlanAction.getFaceAnimationGltfPath(), zplanSpanContext);
            if (!(loadAnimation.length == 0)) {
                first2 = ArraysKt___ArraysKt.first(loadAnimation);
                FilamentAnimation filamentAnimation = (FilamentAnimation) first2;
                QLog.i("AnimState", 1, "trackGroupWithAnimations faceAnimation:" + filamentAnimation.toJSON());
                aVar.a(filamentAnimation);
            } else {
                QLog.e("AnimState", 1, "trackGroupWithAnimations faceAnimation is Empty");
            }
            FilamentAnimation[] loadAnimation2 = viewerV2.loadAnimation(zPlanAction.getBodyAnimationGltfPath(), zplanSpanContext);
            if (!(loadAnimation2.length == 0)) {
                first = ArraysKt___ArraysKt.first(loadAnimation2);
                FilamentAnimation filamentAnimation2 = (FilamentAnimation) first;
                QLog.i("AnimState", 1, "trackGroupWithAnimations bodyAnimation:" + filamentAnimation2.toJSON());
                aVar2.a(filamentAnimation2);
            } else {
                QLog.e("AnimState", 1, "trackGroupWithAnimations bodyAnimation is Empty");
            }
        }
        bVar.a(aVar);
        bVar.a(aVar2);
        return bVar;
    }
}
