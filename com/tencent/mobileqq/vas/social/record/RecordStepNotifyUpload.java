package com.tencent.mobileqq.vas.social.record;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.social.SocialActionRecordHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.data.FilamentCoverResource;
import com.tencent.state.square.data.FilamentCoverResourceItem;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.ResourceIdentify;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.record.UserIdentifier;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/RecordStepNotifyUpload;", "Lcom/tencent/mobileqq/vas/social/record/b;", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "r", "", "actionId", "Lcom/tencent/state/square/data/RecordSource;", "mp4", "cover", ReportConstant.COSTREPORT_PREFIX, "k", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "currentState", "", "p", "Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", "Lcom/tencent/mobileqq/vas/social/record/c;", "listener", "<init>", "(Lcom/tencent/mobileqq/vas/data/b;Lcom/tencent/mobileqq/vas/social/record/c;)V", UserInfo.SEX_FEMALE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RecordStepNotifyUpload extends com.tencent.mobileqq.vas.social.record.b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310798a;

        static {
            int[] iArr = new int[RecordType.values().length];
            try {
                iArr[RecordType.MP4_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordType.FILAMENT_SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordType.FILAMENT_NEARBY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f310798a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/social/record/RecordStepNotifyUpload$c", "Lcom/tencent/state/service/ResultCallback;", "", "result", "a", "(Lkotlin/Unit;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ResultCallback<Unit> {
        c() {
        }

        @Override // com.tencent.state.service.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(Unit result) {
            Intrinsics.checkNotNullParameter(result, "result");
            RecordStepNotifyUpload.this.n();
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str, String str2) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/social/record/RecordStepNotifyUpload$d", "Lcom/tencent/state/service/ResultCallback;", "", "", "error", "", "message", "", "onResultFailure", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ResultCallback<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecordSource f310801b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecordSource f310802c;

        d(RecordSource recordSource, RecordSource recordSource2) {
            this.f310801b = recordSource;
            this.f310802c = recordSource2;
        }

        public void a(boolean result) {
            RecordStepNotifyUpload.this.n();
            QLog.d("RecordStepNotifyUpload", 1, "[RECORD] 5-3.2 setUserAction success: info:" + RecordStepNotifyUpload.this.getTaskInfo() + ", mp4:" + this.f310801b + ", cover:" + this.f310802c);
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str, String str2) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
        }

        @Override // com.tencent.state.service.ResultCallback
        public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
            a(bool.booleanValue());
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int error, String message) {
            if (error == -23070) {
                QLog.d("RecordStepNotifyUpload", 1, "[RECORD] 5-3.1-1 do refreshDressKey, info:" + RecordStepNotifyUpload.this.getTaskInfo() + ", mp4:" + this.f310801b + ", cover:" + this.f310802c);
            }
            com.tencent.mobileqq.vas.social.record.c listener = RecordStepNotifyUpload.this.getListener();
            if (listener != null) {
                if (message == null) {
                    message = "notifyUpload onResultFailure";
                }
                listener.onError(error, message);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordStepNotifyUpload(com.tencent.mobileqq.vas.data.b taskInfo, com.tencent.mobileqq.vas.social.record.c cVar) {
        super(taskInfo, RecordState.UPLOADED, cVar);
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
    }

    private final void r(RecordStepProduct product) {
        Long longOrNull;
        String path;
        ResourceIdentify resource;
        String md5;
        ResourceIdentify resource2;
        String md52;
        RecordSource serviceCover;
        String path2;
        QLog.d("RecordStepNotifyUpload", 1, "[RECORD] 5-3.0 handle notify upload filament, info:" + getTaskInfo() + ", product:" + product);
        FilamentResource filamentResource = getTaskInfo().getFilamentResource();
        int actionId = getTaskInfo().getActionId();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getSender().getUin());
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            int i3 = b.f310798a[getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getType().ordinal()];
            if (i3 == 2) {
                VasStatusSquareService vasStatusSquareService = VasStatusSquareService.INSTANCE;
                RecordSource serviceCover2 = product.getServiceCover();
                if (serviceCover2 == null || (path = serviceCover2.getPath()) == null || filamentResource == null || (resource = filamentResource.getResource()) == null || (md5 = resource.getMd5()) == null) {
                    return;
                }
                vasStatusSquareService.setFilamentCover(new FilamentCoverResourceItem(longValue, actionId, new FilamentCoverResource(path, getTaskInfo().getDressKeys(), md5)), new c());
                return;
            }
            if (i3 != 3) {
                return;
            }
            IAvatarService iAvatarService = (IAvatarService) QRoute.api(IAvatarService.class);
            if (filamentResource == null || (resource2 = filamentResource.getResource()) == null || (md52 = resource2.getMd5()) == null || (serviceCover = product.getServiceCover()) == null || (path2 = serviceCover.getPath()) == null) {
                return;
            }
            iAvatarService.setMotionCover(longValue, actionId, md52, path2, getTaskInfo().getDressKeys().getOwner(), new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.social.record.RecordStepNotifyUpload$notifyFilamentUpload$2
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
                    RecordStepNotifyUpload.this.n();
                }
            });
        }
    }

    private final void s(int actionId, RecordSource mp42, RecordSource cover) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("RecordStepNotifyUpload", 1, "getAppInterface app: " + appInterface);
            return;
        }
        QLog.d("RecordStepNotifyUpload", 1, "notifyUpload actionId:" + actionId + " mp4:" + mp42 + ", cover:" + cover);
        String dressKey = SquareRecordManager.INSTANCE.getDressKey();
        String owner = getTaskInfo().getDressKeys().getOwner();
        if (Intrinsics.areEqual(dressKey, owner)) {
            QLog.d("RecordStepNotifyUpload", 1, "[RECORD] 5-3.1 handle notify upload req: info:" + getTaskInfo() + ", mp4:" + mp42 + ", cover:" + cover);
            final ArrayList arrayList = new ArrayList();
            if (!getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getReceivers().isEmpty()) {
                arrayList.add(TuplesKt.to(getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getSender().getUin(), owner));
                for (final UserIdentifier userIdentifier : getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getReceivers()) {
                    userIdentifier.getDressKey(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.social.record.RecordStepNotifyUpload$notifyMp4Upload$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            arrayList.add(TuplesKt.to(userIdentifier.getUin(), it));
                        }
                    });
                }
            }
            VasStatusSquareService.INSTANCE.setUserAction(SocialActionRecordHelper.f310651d.l(getTaskInfo().getMode()), actionId, mp42, cover, owner, arrayList, getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getAppId(), new d(mp42, cover));
            return;
        }
        QLog.w("RecordStepNotifyUpload", 1, "[RECORD] 5-3.2 handle notify upload dressKey not same!");
    }

    @Override // com.tencent.mobileqq.vas.social.record.b
    public void k(RecordStepProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        if (!getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getNeedUpload()) {
            QLog.d("RecordStepNotifyUpload", 1, "[RECORD] 5-3.0 handle no need notify upload, info:" + getTaskInfo() + ", product:" + product);
            n();
            return;
        }
        int i3 = b.f310798a[getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                r(product);
                return;
            }
            return;
        }
        RecordSource serviceMp4 = product.getServiceMp4();
        if (serviceMp4 != null) {
            s(getTaskInfo().getActionId(), serviceMp4, product.getServiceCover());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vas.social.record.b
    public boolean p(RecordState currentState) {
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        return false;
    }
}
