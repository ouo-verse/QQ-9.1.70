package com.tencent.sqshow.zootopia.friendsdressup.filament;

import android.graphics.PointF;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.BusinessSceneConfig;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.ClearOptions;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.RendererParams;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import com.tencent.sqshow.zootopia.avatar.filament.k;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001JB'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J+\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u001b\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J'\u0010(\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001a2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016\u00a2\u0006\u0004\b(\u0010)J\b\u0010+\u001a\u00020*H\u0016J\u001c\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010-\u001a\u00020,2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u00100\u001a\u00020*H\u0016J$\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u001e\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00072\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000505H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00108R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00108R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0017\u0010=\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010AR\u0016\u00100\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010BR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006K"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "Lcom/tencent/filament/zplan/avatar/BusinessSceneConfig;", "buildCfg", "", "resetRotate", "", "uin", "headMontagePath", "bodyMontagePath", "downloadAnimRes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/h;", "avatarInfoReadyListener", "setAvatarInfoReadyListener", "Lorg/json/JSONObject;", "avatarCharacter", "updateAvatarCharacter", "updateAnimationPath", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightConfigAfterThemeChange", "getSceneConfig", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "", "needApplyShoesHeight", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "canRender", "event", "eventData", "processDispatchEvent", "funName", "Lkotlin/Function0;", "task", "runOnViewerThread", "Ljava/lang/String;", "", "width", "I", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentAnimHelper;", "animHelper", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentAnimHelper;", "getAnimHelper", "()Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentAnimHelper;", "Lorg/json/JSONObject;", "Z", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/h;", "Landroid/graphics/PointF;", "mLastPanPoint", "Landroid/graphics/PointF;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendsDressUpBusinessScene extends AbsBusinessScene implements i {
    private static final int BODY_SIZE_SLOT_ID = 116;
    public static final int BODY_TYPE_FEMALE_D = 415000003;
    public static final int BODY_TYPE_MALE_D = 415000002;
    public static final int BODY_TYPE_OLD = 415000001;
    private static final String KEY_AVATAR_INFO = "makeup_info";
    private static final String KEY_ITEM_ID = "item_id";
    private static final String KEY_SLOT_ARR = "slot_arr";
    private static final String KEY_SLOT_ID = "slot_id";
    private static final String TAG = "FriendDressUpBusinessScene";
    private final FilamentAnimHelper animHelper;
    private JSONObject avatarCharacter;
    private h avatarInfoReadyListener;
    private String bodyMontagePath;
    private boolean canRender;
    private String headMontagePath;
    private PointF mLastPanPoint;
    private String uin;
    private final int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene$a", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/g;", "", "c", "", "errMsg", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements g {
        a() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.filament.g
        public void c() {
            com.tencent.sqshow.zootopia.friendsdressup.a.a(FriendsDressUpBusinessScene.TAG, "onInitAnimReady");
            FriendsDressUpBusinessScene.this.getAnimHelper().C();
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.filament.g
        public void e(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e(FriendsDressUpBusinessScene.TAG, 1, "onInitAnimLoadFailed, " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f370575a;

        static {
            int[] iArr = new int[TouchEventState.values().length];
            try {
                iArr[TouchEventState.Began.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f370575a = iArr;
        }
    }

    public FriendsDressUpBusinessScene(String uin, String headMontagePath, String bodyMontagePath, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(headMontagePath, "headMontagePath");
        Intrinsics.checkNotNullParameter(bodyMontagePath, "bodyMontagePath");
        this.uin = uin;
        this.headMontagePath = headMontagePath;
        this.bodyMontagePath = bodyMontagePath;
        this.width = i3;
        FilamentAnimHelper filamentAnimHelper = new FilamentAnimHelper(getUrlTemplate());
        this.animHelper = filamentAnimHelper;
        filamentAnimHelper.p(this);
        filamentAnimHelper.o(new a());
    }

    private final BusinessSceneConfig buildCfg() {
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        cameraParams.setExposure(new Exposure(0, 0.0d, 0.0d, 7, null));
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.0f, 8.8f});
        lookAt.setTarget(new float[]{0.0f, 0.56f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        cameraParams.setLensProjection(new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null));
        RendererParams rendererParams = new RendererParams(null, 1, null);
        ClearOptions clearOptions = rendererParams.getClearOptions();
        clearOptions.setClearColor(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        clearOptions.setClear(true);
        clearOptions.setDiscard(true);
        return new BusinessSceneConfig(cameraParams, rendererParams, k.f370019a.a(false));
    }

    private final void resetRotate() {
        doTask("resetRotation", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpBusinessScene$resetRotate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentViewerV2 viewerV2 = FriendsDressUpBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.resetRotation();
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public com.tencent.filament.zplan.business.api.a animate(double now, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 == null) {
            return null;
        }
        boolean t16 = this.animHelper.t(viewerV2, now, this.uin);
        this.canRender = t16;
        if (t16) {
            return null;
        }
        com.tencent.sqshow.zootopia.friendsdressup.a.a(TAG, "canRender == false");
        return null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: canRender, reason: from getter */
    public boolean getCanRender() {
        return this.canRender;
    }

    public final Object downloadAnimRes(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object s16 = this.animHelper.s(str, str2, str3, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return s16 == coroutine_suspended ? s16 : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(13:5|6|(1:(1:9)(2:32|33))(2:34|(9:(1:37)|38|14|15|16|(1:(2:18|(1:20)(1:21))(1:29))|23|(1:25)|26)(2:39|(1:41)(1:42)))|10|(1:12)|13|14|15|16|(2:(0)(0)|20)|23|(0)|26))|43|6|(0)(0)|10|(0)|13|14|15|16|(2:(0)(0)|20)|23|(0)|26) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0098, code lost:
    
        r0 = r6.optInt("item_id", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpBusinessScene.TAG, 1, "fetchAvatarInfo, parse bodyTypeId error, ", r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086 A[Catch: JSONException -> 0x00a0, TryCatch #0 {JSONException -> 0x00a0, blocks: (B:16:0x0071, B:18:0x0086, B:20:0x0095, B:22:0x0098), top: B:15:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[EDGE_INSN: B:29:0x00a7->B:23:0x00a7 BREAK  A[LOOP:0: B:17:0x0084->B:20:0x0095], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        FriendsDressUpBusinessScene$fetchAvatarInfo$1 friendsDressUpBusinessScene$fetchAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        FriendsDressUpBusinessScene friendsDressUpBusinessScene;
        h hVar;
        int length;
        int i16;
        if (continuation instanceof FriendsDressUpBusinessScene$fetchAvatarInfo$1) {
            friendsDressUpBusinessScene$fetchAvatarInfo$1 = (FriendsDressUpBusinessScene$fetchAvatarInfo$1) continuation;
            int i17 = friendsDressUpBusinessScene$fetchAvatarInfo$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                friendsDressUpBusinessScene$fetchAvatarInfo$1.label = i17 - Integer.MIN_VALUE;
                Object obj = friendsDressUpBusinessScene$fetchAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = friendsDressUpBusinessScene$fetchAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    jSONObject = this.avatarCharacter;
                    if (jSONObject == null) {
                        IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                        String str = this.uin;
                        friendsDressUpBusinessScene$fetchAvatarInfo$1.L$0 = this;
                        friendsDressUpBusinessScene$fetchAvatarInfo$1.label = 1;
                        obj = iZPlanAvatarInfoHelper.fetchOtherAvatarInfoWithUin(str, friendsDressUpBusinessScene$fetchAvatarInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        friendsDressUpBusinessScene = this;
                    } else {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        friendsDressUpBusinessScene = this;
                        int i18 = 0;
                        JSONArray jSONArray = jSONObject.getJSONObject(KEY_AVATAR_INFO).getJSONArray(KEY_SLOT_ARR);
                        length = jSONArray.length();
                        i16 = 0;
                        while (true) {
                            if (i16 >= length) {
                                break;
                            }
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                            if (jSONObject2.optInt("slot_id", 0) == 116) {
                                break;
                            }
                            i16++;
                        }
                        hVar = friendsDressUpBusinessScene.avatarInfoReadyListener;
                        if (hVar != null) {
                            hVar.a(i18);
                        }
                        return jSONObject;
                    }
                } else if (i3 == 1) {
                    friendsDressUpBusinessScene = (FriendsDressUpBusinessScene) friendsDressUpBusinessScene$fetchAvatarInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    QLog.e(TAG, 1, "fetchAvatarInfo fail.");
                    jSONObject = new JSONObject();
                }
                friendsDressUpBusinessScene.avatarCharacter = jSONObject;
                int i182 = 0;
                JSONArray jSONArray2 = jSONObject.getJSONObject(KEY_AVATAR_INFO).getJSONArray(KEY_SLOT_ARR);
                length = jSONArray2.length();
                i16 = 0;
                while (true) {
                    if (i16 >= length) {
                    }
                    i16++;
                }
                hVar = friendsDressUpBusinessScene.avatarInfoReadyListener;
                if (hVar != null) {
                }
                return jSONObject;
            }
        }
        friendsDressUpBusinessScene$fetchAvatarInfo$1 = new FriendsDressUpBusinessScene$fetchAvatarInfo$1(this, continuation);
        Object obj2 = friendsDressUpBusinessScene$fetchAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = friendsDressUpBusinessScene$fetchAvatarInfo$1.label;
        if (i3 != 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject == null) {
        }
        friendsDressUpBusinessScene.avatarCharacter = jSONObject;
        int i1822 = 0;
        JSONArray jSONArray22 = jSONObject.getJSONObject(KEY_AVATAR_INFO).getJSONArray(KEY_SLOT_ARR);
        length = jSONArray22.length();
        i16 = 0;
        while (true) {
            if (i16 >= length) {
            }
            i16++;
        }
        hVar = friendsDressUpBusinessScene.avatarInfoReadyListener;
        if (hVar != null) {
        }
        return jSONObject;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public FetchActionData[] getActionDataArray(EnumUserGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        com.tencent.sqshow.zootopia.friendsdressup.a.a(TAG, "headPath=" + this.headMontagePath + ", bodyPath=" + this.bodyMontagePath);
        return null;
    }

    public final FilamentAnimHelper getAnimHelper() {
        return this.animHelper;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public CameraParams getBodyTypeCamera(String bodyTypeName) {
        return null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public LightsParams getLightConfigAfterThemeChange() {
        return null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public String getSceneConfig() {
        String cfg = new Gson().toJson(buildCfg());
        QLog.i(TAG, 1, "getSceneConfig cfg=" + cfg);
        Intrinsics.checkNotNullExpressionValue(cfg, "cfg");
        return cfg;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            FilamentAnimHelper filamentAnimHelper = this.animHelper;
            JSONObject jSONObject = this.avatarCharacter;
            Intrinsics.checkNotNull(jSONObject);
            filamentAnimHelper.v(viewerV2, jSONObject, this.uin, this.headMontagePath, this.bodyMontagePath);
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean needApplyShoesHeight() {
        return true;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void processDispatchEvent(String event, String eventData, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        TouchEvent touchEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.sqshow.zootopia.friendsdressup.a.a(TAG, "onEvent. event: " + event + ", eventData: " + eventData);
        super.processDispatchEvent(event, eventData, zplanSpanContext);
        if (Intrinsics.areEqual(event, "onTouchEvent")) {
            try {
                touchEvent = (TouchEvent) new Gson().fromJson(eventData, TouchEvent.class);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onEvent TOUCH_EVENT", e16);
                touchEvent = null;
            }
            if (touchEvent == null) {
                return;
            }
            if (c.f370575a[touchEvent.getState().ordinal()] == 1) {
                this.mLastPanPoint = touchEvent.getLocation();
                return;
            }
            PointF pointF = this.mLastPanPoint;
            if (pointF == null) {
                return;
            }
            float f16 = touchEvent.getLocation().x - pointF.x;
            this.mLastPanPoint = touchEvent.getLocation();
            final float f17 = (float) ((f16 / this.width) * 3.141592653589793d);
            doTask("rotateAvatar", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpBusinessScene$processDispatchEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilamentViewerV2 viewerV2 = FriendsDressUpBusinessScene.this.getViewerV2();
                    if (viewerV2 != null) {
                        viewerV2.rotateAvatar(new RotateParam(0.0f, 1.0f, 0.0f, f17));
                    }
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.i
    public void runOnViewerThread(String funName, Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(funName, "funName");
        Intrinsics.checkNotNullParameter(task, "task");
        doTask(funName, task);
    }

    public final void setAvatarInfoReadyListener(h avatarInfoReadyListener) {
        Intrinsics.checkNotNullParameter(avatarInfoReadyListener, "avatarInfoReadyListener");
        this.avatarInfoReadyListener = avatarInfoReadyListener;
    }

    public final void updateAnimationPath(String uin, String headMontagePath, String bodyMontagePath) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(headMontagePath, "headMontagePath");
        Intrinsics.checkNotNullParameter(bodyMontagePath, "bodyMontagePath");
        this.uin = uin;
        this.headMontagePath = headMontagePath;
        this.bodyMontagePath = bodyMontagePath;
        resetRotate();
    }

    public final void updateAvatarCharacter(JSONObject avatarCharacter) {
        this.avatarCharacter = avatarCharacter;
    }
}
