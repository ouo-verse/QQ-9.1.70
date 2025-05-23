package com.tencent.mobileqq.zplan.proxy;

import bk3.a;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.MemeRecordUserInfo;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.ZPlanUserAvatarInfoReq;
import com.tencent.zplan.resource.api.a;
import cy4.UserAvatarCharacter;
import cy4.ZPlanResourceBusinessData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import wx4.PrepareAssetsStatistic;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J.\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J>\u0010\u000f\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002J1\u0010\u0015\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0003*\u00020\u0017H\u0002J&\u0010\u001e\u001a\u00020\u001d*\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J6\u0010 \u001a\u00020\t2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/QQZPlanAssetsProxy;", "Lyx4/b;", "", "Lcom/tencent/zplan/resource/api/b;", "userReqInfo", "", "actionIdList", "Lyx4/a;", "listener", "", "f", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "e", "Ljx4/b;", "stickerConfigList", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "d", "(Ljava/util/List;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/meme/model/d;", tl.h.F, "Lcy4/c;", "anythingFromNet", "avatarOrStickerFromNet", "resourceFileFromNet", "Lwx4/e;", "g", "userList", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQZPlanAssetsProxy implements yx4.b {

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/zplan/proxy/QQZPlanAssetsProxy$a", "Lcom/tencent/zplan/resource/api/a;", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "", "c", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.zplan.resource.api.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ yx4.a f334936b;

        a(yx4.a aVar) {
            this.f334936b = aVar;
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, cy4.c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<UserAvatarCharacter> a16 = businessData.a();
            if (a16 != null) {
                for (UserAvatarCharacter userAvatarCharacter : a16) {
                    linkedHashMap.put(userAvatarCharacter.getUin(), new AvatarCharacterInfo(userAvatarCharacter.getAvatarInfo(), userAvatarCharacter.getDressKey()));
                }
            }
            this.f334936b.onSuccess(linkedHashMap, businessData.d(), QQZPlanAssetsProxy.this.g(statisticData, true, true, true));
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            this.f334936b.onFail(errorCode, errorMessage);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float f16, int i3, int i16) {
            a.C10071a.a(this, f16, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(List<jx4.b> list, EnumUserGender enumUserGender, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Boolean> continuation) {
        return CoroutineScopeKt.coroutineScope(new QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2(list, enumUserGender, filamentUrlTemplate, null), continuation);
    }

    private final void e(List<ZPlanUserAvatarInfoReq> userReqInfo, List<String> actionIdList, final MemeZPlanBaseAction action, final FilamentUrlTemplate urlTemplate, final yx4.a listener) {
        ((bk3.a) vb3.a.f441346a.a(bk3.a.class)).x0(userReqInfo, actionIdList, true, new com.tencent.zplan.resource.api.a() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1
            @Override // com.tencent.zplan.resource.api.a
            public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
                Intrinsics.checkNotNullParameter(errType, "errType");
                listener.onFail(errorCode, errorMessage);
            }

            @Override // com.tencent.zplan.resource.api.a
            public void f(float f16, int i3, int i16) {
                a.C10071a.a(this, f16, i3, i16);
            }

            /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object, com.tencent.zplan.meme.model.a] */
            @Override // com.tencent.zplan.resource.api.a
            public void c(ZPlanResourceBusinessData businessData, cy4.c statisticData) {
                Intrinsics.checkNotNullParameter(businessData, "businessData");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                List<UserAvatarCharacter> a16 = businessData.a();
                if (a16 != null) {
                    MemeZPlanBaseAction memeZPlanBaseAction = action;
                    for (UserAvatarCharacter userAvatarCharacter : a16) {
                        ?? avatarCharacterInfo = new AvatarCharacterInfo(userAvatarCharacter.getAvatarInfo(), userAvatarCharacter.getDressKey());
                        linkedHashMap.put(userAvatarCharacter.getUin(), avatarCharacterInfo);
                        if (Intrinsics.areEqual(userAvatarCharacter.getUin(), memeZPlanBaseAction.getSenderUin())) {
                            objectRef.element = avatarCharacterInfo;
                        }
                    }
                }
                boolean enableFilamentRecordParallelDownload = ZPlanQQMC.INSTANCE.enableFilamentRecordParallelDownload();
                List<jx4.b> d16 = businessData.d();
                if (enableFilamentRecordParallelDownload) {
                    List<jx4.b> list = d16;
                    if (!(list == null || list.isEmpty())) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2(objectRef, action, QQZPlanAssetsProxy.this, d16, urlTemplate, listener, statisticData, linkedHashMap, businessData, null), 3, null);
                        return;
                    }
                }
                listener.onSuccess(linkedHashMap, d16, QQZPlanAssetsProxy.this.g(statisticData, true, true, false));
            }
        });
    }

    private final void f(List<ZPlanUserAvatarInfoReq> userReqInfo, List<String> actionIdList, yx4.a listener) {
        a.C0132a.c((bk3.a) vb3.a.f441346a.a(bk3.a.class), userReqInfo, actionIdList, false, new a(listener), 4, null);
    }

    private final ZPlanUserAvatarInfoReq h(MemeRecordUserInfo memeRecordUserInfo) {
        AvatarCharacterInfo avatarCharacter = memeRecordUserInfo.getAvatarCharacter();
        if (avatarCharacter != null) {
            return new ZPlanUserAvatarInfoReq(memeRecordUserInfo.getUin(), null, avatarCharacter.getCharacter(), avatarCharacter.getDressKey(), 2, null);
        }
        if (memeRecordUserInfo.getUin() != null) {
            return new ZPlanUserAvatarInfoReq(memeRecordUserInfo.getUin(), Integer.valueOf(memeRecordUserInfo.get_gender()), null, null, 12, null);
        }
        return null;
    }

    @Override // yx4.b
    public void a(List<MemeRecordUserInfo> userList, List<String> actionIdList, MemeZPlanBaseAction action, yx4.a listener) {
        Intrinsics.checkNotNullParameter(actionIdList, "actionIdList");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        if (userList != null) {
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                ZPlanUserAvatarInfoReq h16 = h((MemeRecordUserInfo) it.next());
                if (h16 != null) {
                    arrayList.add(h16);
                }
            }
        }
        if (action.getConfig().getTargetEngine() instanceof EngineType.Filament) {
            e(arrayList, actionIdList, action, FilamentFeatureUtil.f106409g.F(), listener);
        } else {
            f(arrayList, actionIdList, listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PrepareAssetsStatistic g(cy4.c cVar, boolean z16, boolean z17, boolean z18) {
        if (cVar != null) {
            return new PrepareAssetsStatistic(cVar.getTotalCostTime(), cVar.getNetReqCostTime(), cVar.getDownloadCostTime(), z16, z17, z18);
        }
        return new PrepareAssetsStatistic(0L, 0L, 0L, z16, z17, z18, 7, null);
    }
}
