package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.animation.FilamentAnimationHelper;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.BusinessSceneConfig;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.ClearOptions;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.RendererParams;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.d;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.data.NativeBuffer;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.record.callback.RecordCallback;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper;
import com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.avatar.filament.k;
import com.tencent.sqshow.zootopia.nativeui.data.repo.s;
import com.tencent.sqshow.zootopia.nativeui.ue.p;
import com.tencent.zplan.common.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import qu4.j;
import uv4.ak;
import uv4.al;
import uv4.az;
import uv4.be;
import wc3.LocalUgcPath;

@Metadata(d1 = {"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0005yz{|}BC\u0012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0L\u0012\b\b\u0002\u0010^\u001a\u00020\u0011\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010O\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010t\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J=\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\"\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\u001b\u0010(\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020&H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J'\u0010,\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0*2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b,\u0010-J\u0018\u00100\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\u0014\u00104\u001a\u0004\u0018\u0001032\b\u00102\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u000205H\u0016J\b\u00107\u001a\u00020$H\u0016J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020\tH\u0016J\u0010\u0010;\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010:J6\u0010A\u001a\u00020\u001b2\"\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0<j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`=2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?J\u0015\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010*\u00a2\u0006\u0004\bC\u0010DJ\u0013\u0010E\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bE\u0010FJ\u000e\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020IJ\u0014\u0010P\u001a\u00020O2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0LJ\u000e\u0010Q\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019J2\u0010Q\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010S\u001a\u0004\u0018\u00010IJ\u0018\u0010V\u001a\u00020\u001b2\b\u0010T\u001a\u0004\u0018\u00010M2\u0006\u0010\u001a\u001a\u00020UJ\u000e\u0010X\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020\tJ\u0014\u0010[\u001a\u00020\u001b2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0LR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u0004\u0018\u00010O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u0004\u0018\u0001038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0017\u0010e\u001a\u00020d8\u0006\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010s\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006~"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "Lcom/tencent/sqshow/zootopia/avatar/filament/PortalBusiness;", "Luk0/e;", "Lcom/tencent/filament/zplan/avatar/BusinessSceneConfig;", "buildCfg", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "facePath", "bodyPath", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "fetchPathAction", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "actionId", "fetchIdAction", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;ILcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "", "beginFrameTime", "animType", "Lcom/tencent/filament/zplan/d;", "listener", "", "recordSingleFrame", "Lorg/json/JSONObject;", "avatarCharacter", "checkAndRemoveSurroundSlot", "", "slotId", "itemId", "effectSlotItemsString", "", "checkIsEffectSlot", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "actionArray", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "type", "eventData", "onEvent", "getAvatarMask", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "Lcom/tencent/filament/zplan/business/api/c;", "setReloadAvatarListener", "enablePlanarShadow", "enablePelvisOffset", "getSceneConfig", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$c;", "setLoadAnimationListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ugcResMap", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$e;", "callback", "updateUgc", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getCompleteActionDataArray", "()[Lcom/tencent/filament/zplan/data/FetchActionData;", "loadCompleteAction", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cameraCfgJson", "switchCamera", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$d;", "angle", "rotateAvatar", "", "Luv4/az;", "keyClothesToDressed", "Lqu4/a;", "avatarCharacterDressing", "recordFrame", "frameTime", "angles", "storeItem", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$a;", "requestAvatarSlotRes", "avatarSlotMask", "hidePrimitiveInSlot", "Lwc3/c;", "ugcPaths", "setLocalUgcPaths", "localUgcPaths", "Ljava/util/Collection;", "avatarType", "I", "defaultCharacter", "Lqu4/a;", "cameraParam", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "touchHelper", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "getTouchHelper", "()Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "ueGender", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "isRecordIcon", "Z", "loadAnimationListener", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$c;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadAnimationCompleted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "avatarCharacterJson", "Lorg/json/JSONObject;", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "animHelper", "<init>", "(Ljava/util/Collection;ILqu4/a;Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;Lcom/tencent/filament/zplan/avatar/CameraParams;)V", "Companion", "a", "b", "c", "d", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AigcPreviewBusinessScene extends PortalBusiness implements uk0.e {
    public static final int AIGC_AVATAR_CURRENT = 2;
    public static final int AIGC_AVATAR_DEFAULT = 0;
    public static final int AIGC_AVATAR_SAVED = 1;
    public static final double AIGC_RECORD_FRAME_TIME_FEMALE = 0.9d;
    public static final double AIGC_RECORD_FRAME_TIME_MALE = 2.666d;
    public static final int ANIM_TYPE_DRESS_ANIM = 1;
    public static final int ANIM_TYPE_INIT_ANIM = 0;
    public static final int ANIM_TYPE_RELAX_ANIM = 2;
    public static final int ANIM_TYPE_UGC_THUMBNAIL = 3;
    private static final int femaleFaZhangActionId = 110;
    private static final String maleBodyAnimPath = "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Male/HuanZhang/BodyAnimation/A_CH_M_H_Jacket_01";
    private static final String maleHeadAnimPath = "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Male/HuanZhang/HeadAnimation/A_CH_M_H_Jacket_01_Emote_Anim";
    private JSONObject avatarCharacterJson;
    private final int avatarType;
    private final CameraParams cameraParam;
    private final qu4.a defaultCharacter;
    private boolean isRecordIcon;
    private AtomicBoolean loadAnimationCompleted;
    private c loadAnimationListener;
    private Collection<LocalUgcPath> localUgcPaths;
    private final FilamentTouchHelper touchHelper;
    private UEAvatarGender ueGender;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$a;", "", "", "slotId", "gltfPath", "", "onSuccess", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        void onSuccess(String slotId, String gltfPath);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$c;", "", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void a();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", HippyTKDListViewAdapter.X, "b", "y", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "<init>", "(FFF)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$d, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class RotateAngle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final float x;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float y;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float z;

        public RotateAngle() {
            this(0.0f, 0.0f, 0.0f, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: b, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: c, reason: from getter */
        public final float getZ() {
            return this.z;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
        }

        public String toString() {
            return "RotateAngle(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
        }

        public RotateAngle(float f16, float f17, float f18) {
            this.x = f16;
            this.y = f17;
            this.z = f18;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RotateAngle)) {
                return false;
            }
            RotateAngle rotateAngle = (RotateAngle) other;
            return Float.compare(this.x, rotateAngle.x) == 0 && Float.compare(this.y, rotateAngle.y) == 0 && Float.compare(this.z, rotateAngle.z) == 0;
        }

        public /* synthetic */ RotateAngle(float f16, float f17, float f18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$e;", "", "", "onComplete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface e {
        void onComplete();
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$f", "Lcom/tencent/filament/zplan/record/callback/RecordCallback;", "", "data", "", "onRecordFrame", "", "a", "I", "getTaskId", "()I", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements RecordCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int taskId;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f328696b;

        f(d dVar) {
            this.f328696b = dVar;
        }

        @Override // com.tencent.filament.zplan.record.callback.RecordCallback
        public int getTaskId() {
            return this.taskId;
        }

        @Override // com.tencent.filament.zplan.record.callback.RecordCallback
        public void onRecordFrame(String data) {
            NativeBuffer from;
            Intrinsics.checkNotNullParameter(data, "data");
            JSONObject b16 = h.f385294a.b(data);
            if (b16 == null) {
                return;
            }
            int optInt = b16.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            if (optInt != 0) {
                QLog.w(AbsBusinessScene.TAG, 1, "onRecordFrame checkTask fail, currentTaskId:0, dataTaskId:" + optInt);
                return;
            }
            int optInt2 = b16.optInt("width");
            int optInt3 = b16.optInt("height");
            JSONObject optJSONObject = b16.optJSONObject("buffer");
            if (optJSONObject == null || (from = NativeBuffer.INSTANCE.from(optJSONObject)) == null) {
                return;
            }
            this.f328696b.a(from.getData(), optInt2, optInt3);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$g", "Lcom/tencent/filament/zplan/business/api/c;", "Lal0/a;", "statistic", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.filament.zplan.business.api.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.business.api.c f328697a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AigcPreviewBusinessScene f328698b;

        g(com.tencent.filament.zplan.business.api.c cVar, AigcPreviewBusinessScene aigcPreviewBusinessScene) {
            this.f328697a = cVar;
            this.f328698b = aigcPreviewBusinessScene;
        }

        @Override // com.tencent.filament.zplan.business.api.c
        public void a(al0.a statistic) {
            Intrinsics.checkNotNullParameter(statistic, "statistic");
            this.f328697a.a(statistic);
            c cVar = this.f328698b.loadAnimationListener;
            if (cVar != null) {
                cVar.a();
            }
            this.f328698b.loadAnimationCompleted.set(true);
        }
    }

    public /* synthetic */ AigcPreviewBusinessScene(Collection collection, int i3, qu4.a aVar, PortalAnimHelper portalAnimHelper, CameraParams cameraParams, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : aVar, (i16 & 8) != 0 ? null : portalAnimHelper, (i16 & 16) != 0 ? null : cameraParams);
    }

    private final BusinessSceneConfig buildCfg() {
        LightsParams a16 = k.f370019a.a(false);
        CameraParams b16 = b84.a.f28061a.b(getInitCameraKey(), getBodyTypeName());
        RendererParams rendererParams = new RendererParams(null, 1, null);
        ClearOptions clearOptions = rendererParams.getClearOptions();
        clearOptions.setClearColor(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        clearOptions.setClear(true);
        clearOptions.setDiscard(true);
        return new BusinessSceneConfig(b16, rendererParams, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchIdAction(com.tencent.zplan.zplantracing.c cVar, EnumUserGender enumUserGender, int i3, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super ZPlanAction> continuation) {
        ZPlanAvatarService service = getService();
        if (service == null) {
            return ZPlanAvatarResourceHelper.f105660o.z(cVar, enumUserGender, i3, filamentUrlTemplate, continuation);
        }
        return FilamentAnimationHelper.f105573a.a(service, enumUserGender, i3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchPathAction(com.tencent.zplan.zplantracing.c cVar, EnumUserGender enumUserGender, String str, String str2, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super ZPlanAction> continuation) {
        ZPlanAvatarService service = getService();
        if (service == null) {
            return ZPlanAvatarResourceHelper.f105660o.B(cVar, enumUserGender, str, str2, filamentUrlTemplate, continuation);
        }
        return FilamentAnimationHelper.f105573a.b(service, str, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordSingleFrame(UEAvatarGender gender, double beginFrameTime, int animType, d listener) {
        com.tencent.filament.zplan.animation.b k06;
        FilamentViewerV2 viewerV2;
        if (getCanRender()) {
            if (animType == 0) {
                k06 = getAnimHelper().k0(gender == UEAvatarGender.FEMALE);
            } else if (animType == 1) {
                k06 = getAnimHelper().getMDressAnim();
            } else if (animType == 2) {
                getAnimHelper().j1();
                k06 = getAnimHelper().n0(gender == UEAvatarGender.FEMALE);
            } else if (animType != 3) {
                k06 = null;
            } else {
                PortalAnimHelper animHelper = getAnimHelper();
                Intrinsics.checkNotNull(animHelper, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper");
                k06 = ((AigcAnimHelper) animHelper).getMUgcThumbnailAnim();
            }
            com.tencent.filament.zplan.animation.b bVar = k06;
            if (bVar == null || (viewerV2 = getViewerV2()) == null) {
                return;
            }
            viewerV2.record(0, bVar, beginFrameTime, beginFrameTime + 0.033d, 0.033d, new f(listener));
        }
    }

    public final qu4.a avatarCharacterDressing(Collection<az> keyClothesToDressed) {
        m94.a b16;
        Map<Integer, az> map;
        m94.a aVar;
        al alVar;
        Collection emptyList;
        int[] occupancySlots;
        List emptyList2;
        int[] occupancySlots2;
        List emptyList3;
        UEAvatarGender uEAvatarGender;
        Intrinsics.checkNotNullParameter(keyClothesToDressed, "keyClothesToDressed");
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        this.ueGender = cVar.n();
        qu4.a aVar2 = this.defaultCharacter;
        if (aVar2 != null) {
            if (aVar2.f429576e == 1) {
                uEAvatarGender = UEAvatarGender.MALE;
            } else {
                uEAvatarGender = UEAvatarGender.FEMALE;
            }
            this.ueGender = uEAvatarGender;
            return aVar2;
        }
        int i3 = this.avatarType;
        if (i3 == 1) {
            this.ueGender = cVar.e().b();
            b16 = cVar.d().b();
        } else if (i3 != 2) {
            b16 = cVar.p().b();
        } else {
            b16 = cVar.m().b();
        }
        if (keyClothesToDressed.isEmpty()) {
            return b16.getAvatarCharacter();
        }
        ArrayList<az> arrayList = new ArrayList<>();
        arrayList.addAll(keyClothesToDressed);
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = keyClothesToDressed.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            az azVar = (az) next;
            if (r94.b.G(azVar) || r94.b.F(azVar)) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            az[] containStoreItems = ((az) it5.next()).f440289p;
            if (containStoreItems != null) {
                Intrinsics.checkNotNullExpressionValue(containStoreItems, "containStoreItems");
                emptyList3 = ArraysKt___ArraysJvmKt.asList(containStoreItems);
                if (emptyList3 != null) {
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList3, emptyList3);
                }
            }
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, emptyList3);
        }
        arrayList.addAll(arrayList3);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.x());
        ArrayList arrayList4 = new ArrayList();
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            be beVar = ((az) it6.next()).f440290q;
            if (beVar != null && (occupancySlots2 = beVar.f440325b) != null) {
                Intrinsics.checkNotNullExpressionValue(occupancySlots2, "occupancySlots");
                emptyList2 = ArraysKt___ArraysJvmKt.asList(occupancySlots2);
                if (emptyList2 != null) {
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList4, emptyList2);
                }
            }
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            CollectionsKt__MutableCollectionsKt.addAll(arrayList4, emptyList2);
        }
        hashSet.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        for (az azVar2 : arrayList) {
            be beVar2 = azVar2.f440290q;
            if (beVar2 == null || (occupancySlots = beVar2.f440325b) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(occupancySlots, "occupancySlots");
                emptyList = new ArrayList(occupancySlots.length);
                for (int i16 : occupancySlots) {
                    emptyList.add(TuplesKt.to(Integer.valueOf(i16), azVar2));
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList5, emptyList);
        }
        map = MapsKt__MapsKt.toMap(arrayList5);
        HashSet hashSet2 = new HashSet();
        s sVar = s.f371156a;
        UEAvatarGender uEAvatarGender2 = this.ueGender;
        Intrinsics.checkNotNull(uEAvatarGender2);
        ak a16 = sVar.a(uEAvatarGender2);
        if (a16 == null || (alVar = a16.f440147c) == null) {
            aVar = null;
        } else {
            UEAvatarGender uEAvatarGender3 = this.ueGender;
            Intrinsics.checkNotNull(uEAvatarGender3);
            aVar = r94.b.O(alVar, uEAvatarGender3, hashSet2);
        }
        if (aVar == null) {
            aVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.p().b();
        }
        p pVar = p.f371394a;
        HashMap<Integer, az> g16 = pVar.g(pVar.i(b16.b(), map).component1(), aVar.b(), hashSet, arrayList);
        qu4.a a17 = bj3.a.a(arrayList);
        j jVar = a17.f429573b;
        qu4.c cVar2 = a17.f429575d;
        qu4.a avatarCharacter = b16.getAvatarCharacter();
        UEAvatarGender uEAvatarGender4 = this.ueGender;
        Intrinsics.checkNotNull(uEAvatarGender4);
        return pVar.d(jVar, cVar2, avatarCharacter, g16, uEAvatarGender4);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePelvisOffset() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePlanarShadow() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        if (fetchAvatarInfoFrom == AbsBusinessScene.FetchAvatarInfoFrom.ON_COSTUME_CHANGE) {
            Collection<LocalUgcPath> collection = this.localUgcPaths;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((LocalUgcPath) it.next()).d());
            }
            JSONObject h16 = r94.c.h(avatarCharacterDressing(arrayList));
            this.avatarCharacterJson = h16;
            checkAndRemoveSurroundSlot(h16);
            return this.avatarCharacterJson;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Collection<LocalUgcPath> collection2 = this.localUgcPaths;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = collection2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((LocalUgcPath) it5.next()).d());
        }
        this.avatarCharacterJson = r94.c.h(avatarCharacterDressing(arrayList2));
        for (LocalUgcPath localUgcPath : this.localUgcPaths) {
            if (!Intrinsics.areEqual(localUgcPath.c(), "") && !AigcPreviewBusinessSceneKt.b(this.avatarCharacterJson, localUgcPath)) {
                QLog.e(AbsBusinessScene.TAG, 1, "fetchAvatarInfo error localUgc=" + localUgcPath);
            }
        }
        QLog.i("aigc_performance", 1, "{performance} filamentViewV2 fetchAvatarInfo time(ms): " + (System.currentTimeMillis() - currentTimeMillis));
        getAnimHelper().g1(this.avatarCharacterJson);
        checkAndRemoveSurroundSlot(this.avatarCharacterJson);
        return this.avatarCharacterJson;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public JSONObject getAvatarMask() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put("HandHeldSlot");
        Unit unit = Unit.INSTANCE;
        jSONObject.put("hideSlotPart", jSONArray);
        return jSONObject;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public CameraParams getBodyTypeCamera(String bodyTypeName) {
        return this.cameraParam;
    }

    public final FetchActionData[] getCompleteActionDataArray() {
        UEAvatarGender uEAvatarGender = this.ueGender;
        if (uEAvatarGender != null && uEAvatarGender.getIndex() == EnumUserGender.GENDER_FEMALE.getValue()) {
            return new FetchActionData[]{new FetchActionData(110, null, null, 6, null)};
        }
        return new FetchActionData[]{new FetchActionData(0, maleHeadAnimPath, maleBodyAnimPath, 1, null)};
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public String getSceneConfig() {
        String cfg = new Gson().toJson(buildCfg());
        QLog.i(AbsBusinessScene.TAG, 1, "getSceneConfig cfg=" + cfg);
        Intrinsics.checkNotNullExpressionValue(cfg, "cfg");
        return cfg;
    }

    public final FilamentTouchHelper getTouchHelper() {
        return this.touchHelper;
    }

    public final void hidePrimitiveInSlot(final String avatarSlotMask) {
        Intrinsics.checkNotNullParameter(avatarSlotMask, "avatarSlotMask");
        runOnViewerThread("updateAvatarUgc", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$hidePrimitiveInSlot$1
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
                FilamentViewerV2 viewerV2 = AigcPreviewBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.showSlotPrimitivesByMask(avatarSlotMask);
                }
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        QLog.i(AbsBusinessScene.TAG, 1, "loadAnimation actionArray:" + actionArray + ", viewerV2:" + getViewerV2());
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            getAnimHelper().u0(viewerV2, this.avatarCharacterJson, actionArray, zplanSpanContext);
        }
    }

    public final Object loadCompleteAction(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AigcPreviewBusinessScene$loadCompleteAction$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    @Override // uk0.e
    public void onEvent(String type, String eventData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (Intrinsics.areEqual(type, "onTouchEvent")) {
            try {
                TouchEvent touchEvent = (TouchEvent) new Gson().fromJson(eventData, TouchEvent.class);
                FilamentTouchHelper filamentTouchHelper = this.touchHelper;
                Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                filamentTouchHelper.g(touchEvent);
            } catch (Exception e16) {
                QLog.e(AbsBusinessScene.TAG, 1, "onEvent fromJson error " + eventData, e16);
            }
        }
    }

    public final void recordFrame(final d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.touchHelper.h();
        final double d16 = this.ueGender == UEAvatarGender.MALE ? 2.666d : 0.9d;
        runOnViewerThread("recordFrame", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$recordFrame$1
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
                UEAvatarGender uEAvatarGender;
                AigcPreviewBusinessScene aigcPreviewBusinessScene = AigcPreviewBusinessScene.this;
                uEAvatarGender = aigcPreviewBusinessScene.ueGender;
                Intrinsics.checkNotNull(uEAvatarGender);
                aigcPreviewBusinessScene.recordSingleFrame(uEAvatarGender, d16, 1, listener);
            }
        });
    }

    public final void requestAvatarSlotRes(az storeItem, a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (storeItem == null) {
            listener.onSuccess("", null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AigcPreviewBusinessScene$requestAvatarSlotRes$1(storeItem, String.valueOf(storeItem.f440290q.f440324a), listener, this, null), 3, null);
        }
    }

    public final void rotateAvatar(final RotateAngle angle) {
        Intrinsics.checkNotNullParameter(angle, "angle");
        runOnViewerThread("rotateAvatar", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$rotateAvatar$1
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
                FilamentViewerV2 viewerV2 = AigcPreviewBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.rotateAvatar(new RotateParam(1.0f, 0.0f, 0.0f, angle.getX()));
                }
                FilamentViewerV2 viewerV22 = AigcPreviewBusinessScene.this.getViewerV2();
                if (viewerV22 != null) {
                    viewerV22.rotateAvatar(new RotateParam(0.0f, 1.0f, 0.0f, angle.getY()));
                }
                FilamentViewerV2 viewerV23 = AigcPreviewBusinessScene.this.getViewerV2();
                if (viewerV23 != null) {
                    viewerV23.rotateAvatar(new RotateParam(0.0f, 0.0f, 1.0f, angle.getZ()));
                }
            }
        });
    }

    public final void setLoadAnimationListener(c listener) {
        if (this.loadAnimationCompleted.get() && listener != null) {
            listener.a();
        }
        this.loadAnimationListener = listener;
    }

    public final void setLocalUgcPaths(Collection<LocalUgcPath> ugcPaths) {
        Intrinsics.checkNotNullParameter(ugcPaths, "ugcPaths");
        this.localUgcPaths = ugcPaths;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void setReloadAvatarListener(com.tencent.filament.zplan.business.api.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setReloadAvatarCompleteListener(new g(listener, this));
    }

    public final void switchCamera(final String cameraCfgJson) {
        Intrinsics.checkNotNullParameter(cameraCfgJson, "cameraCfgJson");
        this.touchHelper.i();
        this.touchHelper.h();
        runOnViewerThread("setCamera", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$switchCamera$1
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
                FilamentViewerV2 viewerV2 = AigcPreviewBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.setCamera(cameraCfgJson);
                }
            }
        });
    }

    public final void updateUgc(final HashMap<String, String> ugcResMap, final e callback) {
        Intrinsics.checkNotNullParameter(ugcResMap, "ugcResMap");
        runOnViewerThread("updateAvatarUgc", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$updateUgc$1
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
                FilamentViewerV2 viewerV2 = AigcPreviewBusinessScene.this.getViewerV2();
                if (viewerV2 != null) {
                    viewerV2.updateAvatarUgc(ugcResMap);
                }
                AigcPreviewBusinessScene.e eVar = callback;
                if (eVar != null) {
                    eVar.onComplete();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcPreviewBusinessScene(Collection<LocalUgcPath> localUgcPaths, int i3, qu4.a aVar, PortalAnimHelper portalAnimHelper, CameraParams cameraParams) {
        super(portalAnimHelper == null ? new PortalAnimHelper() : portalAnimHelper, null);
        Intrinsics.checkNotNullParameter(localUgcPaths, "localUgcPaths");
        this.localUgcPaths = localUgcPaths;
        this.avatarType = i3;
        this.defaultCharacter = aVar;
        this.cameraParam = cameraParams;
        this.touchHelper = new FilamentTouchHelper(this);
        this.loadAnimationCompleted = new AtomicBoolean(false);
        this.avatarCharacterJson = new JSONObject();
        addListener("onTouchEvent", this);
    }

    private final void checkAndRemoveSurroundSlot(JSONObject avatarCharacter) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = (avatarCharacter == null || (optJSONObject = avatarCharacter.optJSONObject("avatar_info")) == null) ? null : optJSONObject.optJSONArray("slot_arr");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        JSONObject t16 = FilamentFeatureUtil.f106409g.t();
        FLog.INSTANCE.i(AbsBusinessScene.TAG, "checkAvatarEffectSlot checkAvatarEffectSlot is " + t16);
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
            if (optJSONObject2 != null) {
                long optLong = optJSONObject2.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                long optLong2 = optJSONObject2.optLong("item_id");
                if (checkIsEffectSlot(optLong, optLong2, t16)) {
                    FLog.INSTANCE.i(AbsBusinessScene.TAG, "checkAvatarEffectSlot slotId " + optLong + " itemId " + optLong2 + " is removed");
                    optJSONArray.remove(i3);
                }
            }
        }
    }

    public final void recordFrame(final UEAvatarGender gender, final int animType, final double frameTime, final d listener, RotateAngle angles) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.touchHelper.h();
        if (angles != null) {
            rotateAvatar(angles);
        }
        runOnViewerThread("recordFrame", new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$recordFrame$3
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
                AigcPreviewBusinessScene.this.recordSingleFrame(gender, frameTime, animType, listener);
            }
        });
    }

    public static /* synthetic */ void updateUgc$default(AigcPreviewBusinessScene aigcPreviewBusinessScene, HashMap hashMap, e eVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            eVar = null;
        }
        aigcPreviewBusinessScene.updateUgc(hashMap, eVar);
    }

    private final boolean checkIsEffectSlot(long slotId, long itemId, JSONObject effectSlotItemsString) {
        if (effectSlotItemsString == null || effectSlotItemsString.isNull("slot_items")) {
            return slotId == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EARRINGS.getValue();
        }
        JSONArray optJSONArray = effectSlotItemsString.optJSONArray("slot_items");
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                if (slotId != optLong) {
                    continue;
                } else {
                    if (slotId == optLong && optJSONObject.isNull("items")) {
                        FLog.INSTANCE.i(AbsBusinessScene.TAG, "checkIsEffectSlot slotId " + slotId + " effectSlotId " + optLong);
                        return true;
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        if (itemId == optJSONArray2.optLong(i16)) {
                            FLog.INSTANCE.i(AbsBusinessScene.TAG, "checkIsEffectSlot slotId " + slotId + " effectSlotId " + optLong);
                            return true;
                        }
                    }
                }
            }
        }
        FLog.INSTANCE.i(AbsBusinessScene.TAG, "checkIsEffectSlot slotId " + slotId);
        return false;
    }

    public static /* synthetic */ void recordFrame$default(AigcPreviewBusinessScene aigcPreviewBusinessScene, UEAvatarGender uEAvatarGender, int i3, double d16, d dVar, RotateAngle rotateAngle, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            rotateAngle = null;
        }
        aigcPreviewBusinessScene.recordFrame(uEAvatarGender, i3, d16, dVar, rotateAngle);
    }
}
