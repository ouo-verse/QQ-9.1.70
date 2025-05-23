package com.tencent.filament.zplan.scene.square;

import al0.a;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.record.BaseRecordSceneV2305;
import com.tencent.filament.zplan.scene.record.RecordInfo;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareRecordData;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00014B\u001f\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.\u00a2\u0006\u0004\b1\u00102J2\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J%\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0013\u0010\u001b\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareRecordScene;", "Lcom/tencent/filament/zplan/scene/record/BaseRecordSceneV2305;", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/scene/square/g;", "avatarObject", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "avatarData", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "avatarResource", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/filament/zplan/scene/square/j;", "extraObject", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", WadlProxyConsts.EXTRA_DATA, BdhLogUtil.LogTag.Tag_Req, "Lorg/json/JSONObject;", "data", "statistic", "Lcom/tencent/filament/zplan/scene/record/b;", "M", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "frameTime", "", "J", "", "P", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "N", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "", "Ljava/lang/String;", "indirectLightPath", "Lcom/tencent/filament/zplan/scene/square/g;", "hostObject", "guestObject", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/filament/zplan/scene/square/j;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "T", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareRecordScene extends BaseRecordSceneV2305 {

    /* renamed from: M, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: N, reason: from kotlin metadata */
    private final AtomicBoolean booted;

    /* renamed from: P, reason: from kotlin metadata */
    private String indirectLightPath;

    /* renamed from: Q, reason: from kotlin metadata */
    private SquareAvatarObject hostObject;

    /* renamed from: R, reason: from kotlin metadata */
    private SquareAvatarObject guestObject;

    /* renamed from: S, reason: from kotlin metadata */
    private SquareExtraObject extraObject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareRecordScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        this.booted = new AtomicBoolean(false);
        this.indirectLightPath = "";
    }

    private final SquareAvatarObject Q(FilamentViewerV2305 viewer, SquareAvatarObject avatarObject, SquareAvatarData.AvatarData avatarData, ReloadAvatarResourceModel avatarResource) {
        FilamentAnimation filamentAnimation;
        FilamentAnimation filamentAnimation2;
        List listOfNotNull;
        List mutableListOf;
        Object firstOrNull;
        Object firstOrNull2;
        if (viewer != null) {
            if (avatarObject != null) {
                viewer.cleanAnimationTracks(null, avatarObject.e());
                viewer.deleteRenderObject(null, avatarObject.e());
            }
            if (avatarData != null && avatarResource != null) {
                JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(avatarData.getAvatarInfoStr());
                if (b16 == null) {
                    o(201009, "parse avatar info fail");
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put("HandHeldSlot");
                Unit unit = Unit.INSTANCE;
                jSONObject.put("hideSlotPart", jSONArray);
                JSONObject o16 = ZPlanAvatarResourceHelper.f105660o.o(avatarResource, b16, false, false, false, null);
                o16.put("avatarMask", jSONObject);
                long createAvatarRenderObject = viewer.createAvatarRenderObject(null);
                viewer.updateRenderObjectAvatar(null, createAvatarRenderObject, o16);
                if (avatarData.getAnim() != null) {
                    firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(avatarData.getAnim().getHeadAnimGltf(), null));
                    filamentAnimation = (FilamentAnimation) firstOrNull2;
                } else {
                    filamentAnimation = null;
                }
                if (avatarData.getAnim() != null) {
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(avatarData.getAnim().getBodyAnimGltf(), null));
                    filamentAnimation2 = (FilamentAnimation) firstOrNull;
                } else {
                    filamentAnimation2 = null;
                }
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new FilamentAnimation[]{filamentAnimation, filamentAnimation2});
                Iterator it = listOfNotNull.iterator();
                while (it.hasNext()) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a((FilamentAnimation) it.next()));
                    viewer.bindAnimationTrack(null, createAvatarRenderObject, new Track(false, mutableListOf));
                }
                return new SquareAvatarObject(createAvatarRenderObject, filamentAnimation, filamentAnimation2);
            }
        }
        return null;
    }

    private final SquareExtraObject R(FilamentViewerV2305 viewer, SquareExtraObject extraObject, SquareAvatarData.ExtraActorData extraData) {
        Object firstOrNull;
        List mutableListOf;
        if (viewer != null) {
            if (extraObject != null) {
                viewer.cleanAnimationTracks(null, extraObject.d());
                viewer.deleteRenderObject(null, extraObject.d());
            }
            if (extraData != null) {
                long createGltfRenderObject = viewer.createGltfRenderObject(null);
                viewer.updateRenderObjectGltf(null, createGltfRenderObject, extraData.getMeshGltf());
                if (extraData.getTransform() != null) {
                    viewer.setRenderObjectTransform(createGltfRenderObject, extraData.getTransform());
                }
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(FilamentViewerV2.loadAnimation$default(viewer, extraData.getAnimGltf(), null, 2, null));
                FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
                if (filamentAnimation != null) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a(filamentAnimation));
                    viewer.bindAnimationTrack(null, createGltfRenderObject, new Track(false, mutableListOf));
                }
                return new SquareExtraObject(createGltfRenderObject, filamentAnimation);
            }
        }
        return null;
    }

    @Override // com.tencent.filament.zplan.scene.record.BaseRecordSceneV2305
    public void J(double frameTime) {
        Long l3;
        Long l16;
        List listOfNotNull;
        Long[] lArr = new Long[3];
        SquareAvatarObject squareAvatarObject = this.hostObject;
        Long l17 = null;
        if (squareAvatarObject != null) {
            l3 = Long.valueOf(squareAvatarObject.e());
        } else {
            l3 = null;
        }
        lArr[0] = l3;
        SquareAvatarObject squareAvatarObject2 = this.guestObject;
        if (squareAvatarObject2 != null) {
            l16 = Long.valueOf(squareAvatarObject2.e());
        } else {
            l16 = null;
        }
        lArr[1] = l16;
        SquareExtraObject squareExtraObject = this.extraObject;
        if (squareExtraObject != null) {
            l17 = Long.valueOf(squareExtraObject.d());
        }
        lArr[2] = l17;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) lArr);
        Iterator it = listOfNotNull.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            FilamentViewerV2305 viewer = getViewer();
            if (viewer != null) {
                viewer.applyAnimation(longValue, frameTime);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0073  */
    @Override // com.tencent.filament.zplan.scene.record.BaseRecordSceneV2305
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object M(@NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2, @NotNull Continuation<? super RecordInfo> continuation) {
        SquareRecordScene$setup$1 squareRecordScene$setup$1;
        Object coroutine_suspended;
        int i3;
        al0.a aVar;
        Object P;
        SquareRecordScene squareRecordScene;
        SquareRecordData squareRecordData;
        JSONObject jSONObject3;
        al0.a aVar2;
        String str;
        List listOfNotNull;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        JSONObject jSONObject4;
        SquareAvatarData squareAvatarData;
        al0.a aVar3;
        al0.a aVar4;
        SquareRecordScene squareRecordScene2;
        SquareRecordData squareRecordData2;
        Deferred async$default;
        CameraParams camera2;
        FilamentViewerV2305 viewer;
        IndirectLight indirectLight;
        FilamentViewerV2305 viewer2;
        Object orNull;
        Object orNull2;
        SquareAvatarObject squareAvatarObject;
        FilamentAnimation filamentAnimation;
        SquareAvatarObject squareAvatarObject2;
        FilamentAnimation filamentAnimation2;
        SquareAvatarObject squareAvatarObject3;
        FilamentAnimation filamentAnimation3;
        SquareAvatarObject squareAvatarObject4;
        FilamentAnimation filamentAnimation4;
        SquareExtraObject squareExtraObject;
        FilamentAnimation filamentAnimation5;
        List<FilamentAnimation> listOfNotNull2;
        double d16;
        double d17;
        int i16;
        if (continuation instanceof SquareRecordScene$setup$1) {
            squareRecordScene$setup$1 = (SquareRecordScene$setup$1) continuation;
            int i17 = squareRecordScene$setup$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                squareRecordScene$setup$1.label = i17 - Integer.MIN_VALUE;
                Object obj = squareRecordScene$setup$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = squareRecordScene$setup$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            aVar3 = (al0.a) squareRecordScene$setup$1.L$5;
                            aVar4 = (al0.a) squareRecordScene$setup$1.L$4;
                            squareAvatarData = (SquareAvatarData) squareRecordScene$setup$1.L$3;
                            squareRecordData2 = (SquareRecordData) squareRecordScene$setup$1.L$2;
                            jSONObject4 = (JSONObject) squareRecordScene$setup$1.L$1;
                            squareRecordScene2 = (SquareRecordScene) squareRecordScene$setup$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            List list = (List) obj;
                            a.Companion companion = al0.a.INSTANCE;
                            aVar3.i(companion.b());
                            jSONObject4.put("fetchAvatarResourceTimeCost", String.valueOf(aVar4.f()));
                            camera2 = squareAvatarData.getCamera();
                            if (camera2 == null) {
                                camera2 = i.f106111a.a();
                            }
                            viewer = squareRecordScene2.getViewer();
                            if (viewer != null) {
                                String json = new Gson().toJson(camera2);
                                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(cameraInfo)");
                                viewer.setCamera(json);
                            }
                            b.b(squareAvatarData.getLight(), squareRecordScene2.j());
                            indirectLight = squareAvatarData.getLight().getIndirectLight();
                            if (indirectLight != null) {
                                indirectLight.setPath(squareRecordScene2.indirectLightPath);
                            }
                            viewer2 = squareRecordScene2.getViewer();
                            if (viewer2 != null) {
                                viewer2.setLights(squareAvatarData.getLight());
                            }
                            al0.a aVar5 = new al0.a(0L, 0L, false, 0, null, 31, null);
                            aVar5.l(companion.b());
                            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list, 1);
                            squareRecordScene2.extraObject = squareRecordScene2.R(squareRecordScene2.getViewer(), squareRecordScene2.extraObject, squareAvatarData.getExtra());
                            squareRecordScene2.hostObject = squareRecordScene2.Q(squareRecordScene2.getViewer(), squareRecordScene2.hostObject, squareAvatarData.getHost(), (ReloadAvatarResourceModel) orNull);
                            squareRecordScene2.guestObject = squareRecordScene2.Q(squareRecordScene2.getViewer(), squareRecordScene2.guestObject, squareAvatarData.getGuest(), (ReloadAvatarResourceModel) orNull2);
                            Unit unit = Unit.INSTANCE;
                            aVar5.i(companion.b());
                            jSONObject4.put("reloadAvatarTimeCost", String.valueOf(aVar5.f()));
                            FilamentAnimation[] filamentAnimationArr = new FilamentAnimation[5];
                            squareAvatarObject = squareRecordScene2.hostObject;
                            if (squareAvatarObject == null) {
                                filamentAnimation = squareAvatarObject.getBodyAnim();
                            } else {
                                filamentAnimation = null;
                            }
                            filamentAnimationArr[0] = filamentAnimation;
                            squareAvatarObject2 = squareRecordScene2.hostObject;
                            if (squareAvatarObject2 == null) {
                                filamentAnimation2 = squareAvatarObject2.getHeadAnim();
                            } else {
                                filamentAnimation2 = null;
                            }
                            filamentAnimationArr[1] = filamentAnimation2;
                            squareAvatarObject3 = squareRecordScene2.guestObject;
                            if (squareAvatarObject3 == null) {
                                filamentAnimation3 = squareAvatarObject3.getBodyAnim();
                            } else {
                                filamentAnimation3 = null;
                            }
                            filamentAnimationArr[2] = filamentAnimation3;
                            squareAvatarObject4 = squareRecordScene2.guestObject;
                            if (squareAvatarObject4 == null) {
                                filamentAnimation4 = squareAvatarObject4.getHeadAnim();
                            } else {
                                filamentAnimation4 = null;
                            }
                            filamentAnimationArr[3] = filamentAnimation4;
                            squareExtraObject = squareRecordScene2.extraObject;
                            if (squareExtraObject == null) {
                                filamentAnimation5 = squareExtraObject.getAnim();
                            } else {
                                filamentAnimation5 = null;
                            }
                            filamentAnimationArr[4] = filamentAnimation5;
                            listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) filamentAnimationArr);
                            d16 = 0.0d;
                            loop0: while (true) {
                                d17 = d16;
                                for (FilamentAnimation filamentAnimation6 : listOfNotNull2) {
                                    if (filamentAnimation6.getDuration() > d17) {
                                        break;
                                    }
                                }
                                d16 = filamentAnimation6.getDuration();
                            }
                            if (squareRecordData2.getFrameCount() == null && squareRecordData2.getFrameCount().intValue() > 0) {
                                i16 = squareRecordData2.getFrameCount().intValue();
                            } else {
                                i16 = (int) (24 * d17);
                            }
                            return new RecordInfo(squareRecordData2.getWidth(), squareRecordData2.getHeight(), 24, d17, i16);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (al0.a) squareRecordScene$setup$1.L$4;
                    aVar2 = (al0.a) squareRecordScene$setup$1.L$3;
                    SquareRecordData squareRecordData3 = (SquareRecordData) squareRecordScene$setup$1.L$2;
                    JSONObject jSONObject5 = (JSONObject) squareRecordScene$setup$1.L$1;
                    SquareRecordScene squareRecordScene3 = (SquareRecordScene) squareRecordScene$setup$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    squareRecordData = squareRecordData3;
                    squareRecordScene = squareRecordScene3;
                    P = obj;
                    jSONObject3 = jSONObject5;
                } else {
                    ResultKt.throwOnFailure(obj);
                    SquareRecordData.Companion companion2 = SquareRecordData.INSTANCE;
                    String jSONObject6 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject6, "data.toString()");
                    SquareRecordData a16 = companion2.a(jSONObject6);
                    if (a16 == null) {
                        o(201009, "parse data fail");
                        return null;
                    }
                    aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                    aVar.l(al0.a.INSTANCE.b());
                    squareRecordScene$setup$1.L$0 = this;
                    squareRecordScene$setup$1.L$1 = jSONObject2;
                    squareRecordScene$setup$1.L$2 = a16;
                    squareRecordScene$setup$1.L$3 = aVar;
                    squareRecordScene$setup$1.L$4 = aVar;
                    squareRecordScene$setup$1.label = 1;
                    P = P(squareRecordScene$setup$1);
                    if (P == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    squareRecordScene = this;
                    squareRecordData = a16;
                    jSONObject3 = jSONObject2;
                    aVar2 = aVar;
                }
                if (((Boolean) P).booleanValue()) {
                    squareRecordScene.o(201024, "boot fail");
                    return null;
                }
                Unit unit2 = Unit.INSTANCE;
                a.Companion companion3 = al0.a.INSTANCE;
                aVar.i(companion3.b());
                jSONObject3.put("bootTimeCost", String.valueOf(aVar2.f()));
                SquareAvatarData playData = squareRecordData.getPlayData();
                if (playData == null) {
                    squareRecordScene.o(201009, "parse play data fail");
                    return null;
                }
                al0.a aVar6 = new al0.a(0L, 0L, false, 0, null, 31, null);
                aVar6.l(companion3.b());
                String[] strArr = new String[2];
                strArr[0] = playData.getHost().getAvatarInfoStr();
                SquareAvatarData.AvatarData guest = playData.getGuest();
                if (guest != null) {
                    str = guest.getAvatarInfoStr();
                } else {
                    str = null;
                }
                strArr[1] = str;
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr);
                List list2 = listOfNotNull;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.zplan.common.utils.h.f385294a.b((String) it.next()));
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SquareRecordScene$setup$$inlined$measure$lambda$1((JSONObject) it5.next(), null, squareRecordScene, squareRecordScene$setup$1, playData), 3, null);
                    arrayList2.add(async$default);
                    aVar6 = aVar6;
                }
                al0.a aVar7 = aVar6;
                squareRecordScene$setup$1.L$0 = squareRecordScene;
                squareRecordScene$setup$1.L$1 = jSONObject3;
                squareRecordScene$setup$1.L$2 = squareRecordData;
                squareRecordScene$setup$1.L$3 = playData;
                squareRecordScene$setup$1.L$4 = aVar7;
                squareRecordScene$setup$1.L$5 = aVar7;
                squareRecordScene$setup$1.label = 2;
                Object awaitAll = AwaitKt.awaitAll(arrayList2, squareRecordScene$setup$1);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jSONObject4 = jSONObject3;
                obj = awaitAll;
                squareAvatarData = playData;
                aVar3 = aVar7;
                aVar4 = aVar3;
                squareRecordScene2 = squareRecordScene;
                squareRecordData2 = squareRecordData;
                List list3 = (List) obj;
                a.Companion companion4 = al0.a.INSTANCE;
                aVar3.i(companion4.b());
                jSONObject4.put("fetchAvatarResourceTimeCost", String.valueOf(aVar4.f()));
                camera2 = squareAvatarData.getCamera();
                if (camera2 == null) {
                }
                viewer = squareRecordScene2.getViewer();
                if (viewer != null) {
                }
                b.b(squareAvatarData.getLight(), squareRecordScene2.j());
                indirectLight = squareAvatarData.getLight().getIndirectLight();
                if (indirectLight != null) {
                }
                viewer2 = squareRecordScene2.getViewer();
                if (viewer2 != null) {
                }
                al0.a aVar52 = new al0.a(0L, 0L, false, 0, null, 31, null);
                aVar52.l(companion4.b());
                orNull = CollectionsKt___CollectionsKt.getOrNull(list3, 0);
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(list3, 1);
                squareRecordScene2.extraObject = squareRecordScene2.R(squareRecordScene2.getViewer(), squareRecordScene2.extraObject, squareAvatarData.getExtra());
                squareRecordScene2.hostObject = squareRecordScene2.Q(squareRecordScene2.getViewer(), squareRecordScene2.hostObject, squareAvatarData.getHost(), (ReloadAvatarResourceModel) orNull);
                squareRecordScene2.guestObject = squareRecordScene2.Q(squareRecordScene2.getViewer(), squareRecordScene2.guestObject, squareAvatarData.getGuest(), (ReloadAvatarResourceModel) orNull2);
                Unit unit3 = Unit.INSTANCE;
                aVar52.i(companion4.b());
                jSONObject4.put("reloadAvatarTimeCost", String.valueOf(aVar52.f()));
                FilamentAnimation[] filamentAnimationArr2 = new FilamentAnimation[5];
                squareAvatarObject = squareRecordScene2.hostObject;
                if (squareAvatarObject == null) {
                }
                filamentAnimationArr2[0] = filamentAnimation;
                squareAvatarObject2 = squareRecordScene2.hostObject;
                if (squareAvatarObject2 == null) {
                }
                filamentAnimationArr2[1] = filamentAnimation2;
                squareAvatarObject3 = squareRecordScene2.guestObject;
                if (squareAvatarObject3 == null) {
                }
                filamentAnimationArr2[2] = filamentAnimation3;
                squareAvatarObject4 = squareRecordScene2.guestObject;
                if (squareAvatarObject4 == null) {
                }
                filamentAnimationArr2[3] = filamentAnimation4;
                squareExtraObject = squareRecordScene2.extraObject;
                if (squareExtraObject == null) {
                }
                filamentAnimationArr2[4] = filamentAnimation5;
                listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) filamentAnimationArr2);
                d16 = 0.0d;
                loop0: while (true) {
                    d17 = d16;
                    while (r1.hasNext()) {
                    }
                    d16 = filamentAnimation6.getDuration();
                }
                if (squareRecordData2.getFrameCount() == null) {
                }
                i16 = (int) (24 * d17);
                return new RecordInfo(squareRecordData2.getWidth(), squareRecordData2.getHeight(), 24, d17, i16);
            }
        }
        squareRecordScene$setup$1 = new SquareRecordScene$setup$1(this, continuation);
        Object obj2 = squareRecordScene$setup$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = squareRecordScene$setup$1.label;
        if (i3 == 0) {
        }
        if (((Boolean) P).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object P(Continuation<? super Boolean> continuation) {
        SquareRecordScene$boot$1 squareRecordScene$boot$1;
        Object coroutine_suspended;
        int i3;
        SquareRecordScene squareRecordScene;
        Object obj;
        String indirectLightPath;
        FilamentViewerV2305 viewer;
        boolean z16;
        if (continuation instanceof SquareRecordScene$boot$1) {
            squareRecordScene$boot$1 = (SquareRecordScene$boot$1) continuation;
            int i16 = squareRecordScene$boot$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                squareRecordScene$boot$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = squareRecordScene$boot$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = squareRecordScene$boot$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        squareRecordScene = (SquareRecordScene) squareRecordScene$boot$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    if (this.booted.get()) {
                        return Boxing.boxBoolean(true);
                    }
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                    FilamentUrlTemplate filamentUrlTemplate = this.urlTemplate;
                    squareRecordScene$boot$1.L$0 = this;
                    squareRecordScene$boot$1.label = 1;
                    Object F = zPlanAvatarResourceHelper.F(null, filamentUrlTemplate, squareRecordScene$boot$1);
                    if (F == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    squareRecordScene = this;
                    obj = F;
                }
                BootResourceModel bootResourceModel = (BootResourceModel) obj;
                indirectLightPath = bootResourceModel.getIndirectLightPath();
                if (indirectLightPath == null) {
                    indirectLightPath = "";
                }
                squareRecordScene.indirectLightPath = indirectLightPath;
                viewer = squareRecordScene.getViewer();
                if (viewer != null) {
                    FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                    Boolean boxBoolean = Boxing.boxBoolean(viewer.boot(bootResourceModel, "", false, false, false, filamentFeatureUtil.K(), filamentFeatureUtil.j()));
                    if (boxBoolean != null) {
                        z16 = boxBoolean.booleanValue();
                        if (z16) {
                            squareRecordScene.booted.set(true);
                        }
                        return Boxing.boxBoolean(z16);
                    }
                }
                z16 = false;
                if (z16) {
                }
                return Boxing.boxBoolean(z16);
            }
        }
        squareRecordScene$boot$1 = new SquareRecordScene$boot$1(this, continuation);
        Object obj22 = squareRecordScene$boot$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = squareRecordScene$boot$1.label;
        if (i3 == 0) {
        }
        BootResourceModel bootResourceModel2 = (BootResourceModel) obj;
        indirectLightPath = bootResourceModel2.getIndirectLightPath();
        if (indirectLightPath == null) {
        }
        squareRecordScene.indirectLightPath = indirectLightPath;
        viewer = squareRecordScene.getViewer();
        if (viewer != null) {
        }
        z16 = false;
        if (z16) {
        }
        return Boxing.boxBoolean(z16);
    }
}
