package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import by4.ZPlanRecordResourceStatistic;
import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ShareScene;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareItem;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareTemplateConfig;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJQ\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J9\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/ZPlanSharePreRecordUtil;", "", "", "uin", "Lcom/tencent/zplan/meme/Priority;", "priority", "", "id", "width", "height", "Lcom/tencent/zplan/meme/model/a;", "avatarCharacterInfo", "Lji3/e;", "callback", "", "e", "(Ljava/lang/String;Lcom/tencent/zplan/meme/Priority;IIILcom/tencent/zplan/meme/model/a;Lji3/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "c", "f", "(Ljava/lang/String;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/model/a;Lji3/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/meme/EngineType;", "d", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSharePreRecordUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanSharePreRecordUtil f371750a = new ZPlanSharePreRecordUtil();

    ZPlanSharePreRecordUtil() {
    }

    private final List<Integer> b() {
        List<Integer> listOf;
        Object orNull;
        ArrayList arrayList = new ArrayList();
        try {
            ZPlanShareTemplateConfig zPlanShareTemplateConfig = ZPlanQQMC.INSTANCE.getZPlanShareTemplateConfig();
            Map<Integer, List<Integer>> b16 = zPlanShareTemplateConfig.b();
            ShareScene shareScene = ShareScene.CHANGE_DRESS;
            if (!b16.containsKey(Integer.valueOf(shareScene.getValue()))) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
            } else {
                listOf = zPlanShareTemplateConfig.b().get(Integer.valueOf(shareScene.getValue()));
                if (listOf == null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
                }
            }
            List<ZPlanShareItem> a16 = zPlanShareTemplateConfig.a();
            if (a16.isEmpty()) {
                a16 = CollectionsKt__CollectionsJVMKt.listOf(new ZPlanShareItem(0, null, null, null, null, null, null, 127, null));
            }
            List<ZPlanShareItem> list = a16;
            Iterator<Integer> it = listOf.iterator();
            while (it.hasNext()) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, it.next().intValue());
                ZPlanShareItem zPlanShareItem = (ZPlanShareItem) orNull;
                if (zPlanShareItem != null) {
                    int actionID = zPlanShareItem.getActionID();
                    if (!arrayList.contains(Integer.valueOf(actionID))) {
                        arrayList.add(Integer.valueOf(actionID));
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanSharePreRecordUtil", 1, "findRecordIdList error wrong config t:" + th5);
        }
        return arrayList;
    }

    private final BusinessConfig c() {
        EngineType d16 = d();
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, BusinessConfig.FrameType.PNG, 0, null, null, null, null, null, null, null, false, null, 0, null, 131054, null);
        businessConfig.G(d16);
        if (!(d16 instanceof EngineType.Unreal)) {
            businessConfig.A(Boolean.TRUE);
        }
        return businessConfig;
    }

    public final EngineType d() {
        if (!ZPlanFeatureSwitch.f369852a.T1()) {
            QLog.i("ZPlanSharePreRecordUtil", 1, "getTargetEngine UE toggle off");
            return null;
        }
        if (!FilamentApiImpl.f369933a.d()) {
            QLog.i("ZPlanSharePreRecordUtil", 1, "getTargetEngine UE portal use UE");
            return null;
        }
        QLog.i("ZPlanSharePreRecordUtil", 1, "getTargetEngine Filament portal use Filament");
        return new EngineType.Filament(FilamentNativeAppRecorder.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(String str, Priority priority, int i3, int i16, int i17, AvatarCharacterInfo avatarCharacterInfo, ji3.e eVar, Continuation<? super Unit> continuation) {
        ZPlanSharePreRecordUtil$preRecordSharePicById$1 zPlanSharePreRecordUtil$preRecordSharePicById$1;
        Object coroutine_suspended;
        int i18;
        ji3.e eVar2;
        String str2;
        String dressKey;
        String localPath;
        if (continuation instanceof ZPlanSharePreRecordUtil$preRecordSharePicById$1) {
            zPlanSharePreRecordUtil$preRecordSharePicById$1 = (ZPlanSharePreRecordUtil$preRecordSharePicById$1) continuation;
            int i19 = zPlanSharePreRecordUtil$preRecordSharePicById$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                zPlanSharePreRecordUtil$preRecordSharePicById$1.label = i19 - Integer.MIN_VALUE;
                Object obj = zPlanSharePreRecordUtil$preRecordSharePicById$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i18 = zPlanSharePreRecordUtil$preRecordSharePicById$1.label;
                if (i18 != 0) {
                    ResultKt.throwOnFailure(obj);
                    SingleRecordRequestParams singleRecordRequestParams = new SingleRecordRequestParams(i3, str, null, i16, i17, MODE.FRAME, c(), 201, AppTheme.DAY, priority, new UploadConfig(true, UploadConfig.UploadTarget.CDN, true, false, 8, null), null, 0, false, null, null, 63488, null);
                    singleRecordRequestParams.x(avatarCharacterInfo);
                    ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
                    eVar2 = eVar;
                    zPlanSharePreRecordUtil$preRecordSharePicById$1.L$0 = eVar2;
                    zPlanSharePreRecordUtil$preRecordSharePicById$1.label = 1;
                    obj = ZPlanRecordResourceCenter.i(zPlanRecordResourceCenter, singleRecordRequestParams, null, zPlanSharePreRecordUtil$preRecordSharePicById$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i18 == 1) {
                    ji3.e eVar3 = (ji3.e) zPlanSharePreRecordUtil$preRecordSharePicById$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    eVar2 = eVar3;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
                ZPlanRecordResourceStatistic statistic = zPlanRecordResource == null ? zPlanRecordResource.getStatistic() : null;
                QLog.i("ZPlanSharePreRecordUtil", 1, "preRecordSharePic done picStatistic.id:" + (statistic == null ? Boxing.boxInt(statistic.getResId()) : null) + " picStatistic.source " + (statistic == null ? statistic.getSource() : null) + " path:" + (zPlanRecordResource == null ? zPlanRecordResource.getLocalPath() : null) + " url:" + (zPlanRecordResource != null ? zPlanRecordResource.getRemoteUrl() : null));
                boolean z16 = zPlanRecordResource == null && (localPath = zPlanRecordResource.getLocalPath()) != null && localPath.length() > 0;
                if (eVar2 != null) {
                    String str3 = "";
                    if (zPlanRecordResource == null || (str2 = zPlanRecordResource.getLocalPath()) == null) {
                        str2 = "";
                    }
                    int actionId = zPlanRecordResource != null ? zPlanRecordResource.getActionId() : 0;
                    if (zPlanRecordResource != null && (dressKey = zPlanRecordResource.getDressKey()) != null) {
                        str3 = dressKey;
                    }
                    eVar2.b(z16, str2, actionId, str3);
                }
                return Unit.INSTANCE;
            }
        }
        zPlanSharePreRecordUtil$preRecordSharePicById$1 = new ZPlanSharePreRecordUtil$preRecordSharePicById$1(this, continuation);
        Object obj2 = zPlanSharePreRecordUtil$preRecordSharePicById$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i18 = zPlanSharePreRecordUtil$preRecordSharePicById$1.label;
        if (i18 != 0) {
        }
        ZPlanRecordResource zPlanRecordResource2 = (ZPlanRecordResource) obj2;
        if (zPlanRecordResource2 == null) {
        }
        if (statistic == null) {
        }
        if (statistic == null) {
        }
        if (zPlanRecordResource2 == null) {
        }
        if (zPlanRecordResource2 != null) {
        }
        QLog.i("ZPlanSharePreRecordUtil", 1, "preRecordSharePic done picStatistic.id:" + (statistic == null ? Boxing.boxInt(statistic.getResId()) : null) + " picStatistic.source " + (statistic == null ? statistic.getSource() : null) + " path:" + (zPlanRecordResource2 == null ? zPlanRecordResource2.getLocalPath() : null) + " url:" + (zPlanRecordResource2 != null ? zPlanRecordResource2.getRemoteUrl() : null));
        if (zPlanRecordResource2 == null) {
        }
        if (eVar2 != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00ad -> B:10:0x00b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(String str, Priority priority, AvatarCharacterInfo avatarCharacterInfo, ji3.e eVar, Continuation<? super Unit> continuation) {
        ZPlanSharePreRecordUtil$preRecordSharePics$1 zPlanSharePreRecordUtil$preRecordSharePics$1;
        ZPlanSharePreRecordUtil zPlanSharePreRecordUtil;
        Object coroutine_suspended;
        int i3;
        ji3.e eVar2;
        Iterator<Integer> it;
        ZPlanSharePreRecordUtil$preRecordSharePics$1 zPlanSharePreRecordUtil$preRecordSharePics$12;
        ZPlanSharePreRecordUtil zPlanSharePreRecordUtil2;
        Object obj;
        String str2;
        Priority priority2;
        AvatarCharacterInfo avatarCharacterInfo2;
        if (continuation instanceof ZPlanSharePreRecordUtil$preRecordSharePics$1) {
            zPlanSharePreRecordUtil$preRecordSharePics$1 = (ZPlanSharePreRecordUtil$preRecordSharePics$1) continuation;
            int i16 = zPlanSharePreRecordUtil$preRecordSharePics$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanSharePreRecordUtil$preRecordSharePics$1.label = i16 - Integer.MIN_VALUE;
                zPlanSharePreRecordUtil = this;
                Object obj2 = zPlanSharePreRecordUtil$preRecordSharePics$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanSharePreRecordUtil$preRecordSharePics$1.label;
                int i17 = 1;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    List<Integer> b16 = b();
                    if (b16.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    eVar2 = eVar;
                    it = b16.iterator();
                    zPlanSharePreRecordUtil$preRecordSharePics$12 = zPlanSharePreRecordUtil$preRecordSharePics$1;
                    zPlanSharePreRecordUtil2 = zPlanSharePreRecordUtil;
                    obj = coroutine_suspended;
                    str2 = str;
                    priority2 = priority;
                    avatarCharacterInfo2 = avatarCharacterInfo;
                    if (it.hasNext()) {
                    }
                } else if (i3 == 1) {
                    Iterator<Integer> it5 = (Iterator) zPlanSharePreRecordUtil$preRecordSharePics$1.L$5;
                    ji3.e eVar3 = (ji3.e) zPlanSharePreRecordUtil$preRecordSharePics$1.L$4;
                    AvatarCharacterInfo avatarCharacterInfo3 = (AvatarCharacterInfo) zPlanSharePreRecordUtil$preRecordSharePics$1.L$3;
                    Priority priority3 = (Priority) zPlanSharePreRecordUtil$preRecordSharePics$1.L$2;
                    String str3 = (String) zPlanSharePreRecordUtil$preRecordSharePics$1.L$1;
                    ZPlanSharePreRecordUtil zPlanSharePreRecordUtil3 = (ZPlanSharePreRecordUtil) zPlanSharePreRecordUtil$preRecordSharePics$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    zPlanSharePreRecordUtil$preRecordSharePics$12 = zPlanSharePreRecordUtil$preRecordSharePics$1;
                    obj = coroutine_suspended;
                    it = it5;
                    eVar2 = eVar3;
                    avatarCharacterInfo2 = avatarCharacterInfo3;
                    priority2 = priority3;
                    str2 = str3;
                    zPlanSharePreRecordUtil2 = zPlanSharePreRecordUtil3;
                    i17 = 1;
                    if (it.hasNext()) {
                        int intValue = it.next().intValue();
                        zPlanSharePreRecordUtil$preRecordSharePics$12.L$0 = zPlanSharePreRecordUtil2;
                        zPlanSharePreRecordUtil$preRecordSharePics$12.L$1 = str2;
                        zPlanSharePreRecordUtil$preRecordSharePics$12.L$2 = priority2;
                        zPlanSharePreRecordUtil$preRecordSharePics$12.L$3 = avatarCharacterInfo2;
                        zPlanSharePreRecordUtil$preRecordSharePics$12.L$4 = eVar2;
                        zPlanSharePreRecordUtil$preRecordSharePics$12.L$5 = it;
                        zPlanSharePreRecordUtil$preRecordSharePics$12.label = i17;
                        ZPlanSharePreRecordUtil zPlanSharePreRecordUtil4 = zPlanSharePreRecordUtil2;
                        Iterator<Integer> it6 = it;
                        Object obj3 = obj;
                        if (zPlanSharePreRecordUtil2.e(str2, priority2, intValue, 600, DataTableNameType.TABLE_DATA_COLLECTION, avatarCharacterInfo2, eVar2, zPlanSharePreRecordUtil$preRecordSharePics$12) == obj3) {
                            return obj3;
                        }
                        obj = obj3;
                        zPlanSharePreRecordUtil2 = zPlanSharePreRecordUtil4;
                        it = it6;
                        i17 = 1;
                        if (it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        zPlanSharePreRecordUtil = this;
        zPlanSharePreRecordUtil$preRecordSharePics$1 = new ZPlanSharePreRecordUtil$preRecordSharePics$1(zPlanSharePreRecordUtil, continuation);
        Object obj22 = zPlanSharePreRecordUtil$preRecordSharePics$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanSharePreRecordUtil$preRecordSharePics$1.label;
        int i172 = 1;
        if (i3 != 0) {
        }
    }

    public static /* synthetic */ Object g(ZPlanSharePreRecordUtil zPlanSharePreRecordUtil, String str, Priority priority, AvatarCharacterInfo avatarCharacterInfo, ji3.e eVar, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            eVar = null;
        }
        return zPlanSharePreRecordUtil.f(str, priority, avatarCharacterInfo, eVar, continuation);
    }
}
