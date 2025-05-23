package com.tencent.mobileqq.zplan.meme.prerecord.birthdaycare;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import wk3.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/prerecord/birthdaycare/ZPlanBirthdayCareRecordHelper;", "", "Lwk3/c;", DownloadInfo.spKey_Config, "", "uin", "Lcom/tencent/zplan/meme/Priority;", "priority", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "a", "", "b", "(Ljava/lang/String;Lcom/tencent/zplan/meme/Priority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanBirthdayCareRecordHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanBirthdayCareRecordHelper f334211a = new ZPlanBirthdayCareRecordHelper();

    ZPlanBirthdayCareRecordHelper() {
    }

    private final SingleRecordRequestParams a(c config, String uin, Priority priority) {
        QLog.i("ZPlanBirthdayCareRecordHelper", 1, "getRecordRequestParams, config: " + config);
        EngineType.Filament filament = config.getUseFilament() ? new EngineType.Filament(FilamentNativeAppRecorder.class) : null;
        int actionId = config.getActionId();
        String str = null;
        int width = config.getWidth();
        int height = config.getHeight();
        MODE mode = MODE.FRAME;
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, BusinessConfig.FrameType.PNG, 0, null, null, null, null, null, null, null, false, null, config.getActionStyle(), Boolean.valueOf(config.getDisableGlassesMetallic()), 32751, null);
        businessConfig.G(filament);
        if (filament instanceof EngineType.Filament) {
            businessConfig.A(Boolean.TRUE);
        }
        Unit unit = Unit.INSTANCE;
        return new SingleRecordRequestParams(actionId, uin, str, width, height, mode, businessConfig, 201, AppTheme.DAY, priority, new UploadConfig(config.getNeedUpload(), UploadConfig.UploadTarget.CDN, true, false, 8, null), null, 0, false, null, null, 63488, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(String str, Priority priority, Continuation<? super Unit> continuation) {
        ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1 zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1) {
            zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1 = (ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1) continuation;
            int i16 = zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    c zPlanBirthdayCareRecordConfig = ZPlanQQMC.INSTANCE.getZPlanBirthdayCareRecordConfig();
                    if (!zPlanBirthdayCareRecordConfig.getEnableZPlanBirthdayCareRecord()) {
                        QLog.w("ZPlanBirthdayCareRecordHelper", 1, "preRecordBirthdayCarePic failed, enable switch off.");
                        return Unit.INSTANCE;
                    }
                    SingleRecordRequestParams a16 = a(zPlanBirthdayCareRecordConfig, str, priority);
                    List<Source> recordSourceWhenUsingFilament = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getRecordSourceWhenUsingFilament(ZPlanRecordScene.BIRTHDAY_CARE);
                    ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
                    zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.label = 1;
                    obj = zPlanRecordResourceCenter.h(a16, recordSourceWhenUsingFilament, zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
                ZPlanRecordResourceStatistic statistic = zPlanRecordResource == null ? zPlanRecordResource.getStatistic() : null;
                QLog.i("ZPlanBirthdayCareRecordHelper", 1, "preRecordBirthdayCarePic done picStatistic.id:" + (statistic == null ? Boxing.boxInt(statistic.getResId()) : null) + " picStatistic.source " + (statistic == null ? statistic.getSource() : null) + " path:" + (zPlanRecordResource == null ? zPlanRecordResource.getLocalPath() : null) + " url:" + (zPlanRecordResource != null ? zPlanRecordResource.getRemoteUrl() : null));
                return Unit.INSTANCE;
            }
        }
        zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1 = new ZPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1(this, continuation);
        Object obj2 = zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanBirthdayCareRecordHelper$preRecordBirthdayCarePic$1.label;
        if (i3 != 0) {
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
        QLog.i("ZPlanBirthdayCareRecordHelper", 1, "preRecordBirthdayCarePic done picStatistic.id:" + (statistic == null ? Boxing.boxInt(statistic.getResId()) : null) + " picStatistic.source " + (statistic == null ? statistic.getSource() : null) + " path:" + (zPlanRecordResource2 == null ? zPlanRecordResource2.getLocalPath() : null) + " url:" + (zPlanRecordResource2 != null ? zPlanRecordResource2.getRemoteUrl() : null));
        return Unit.INSTANCE;
    }
}
