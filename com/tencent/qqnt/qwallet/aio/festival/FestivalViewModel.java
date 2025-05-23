package com.tencent.qqnt.qwallet.aio.festival;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0014J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001f\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/festival/FestivalViewModel;", "Lcom/tencent/qqnt/qwallet/aio/hb/c;", "", "o2", "Ltk2/a$b;", "anim", "e2", "m2", ICustomDataEditor.NUMBER_PARAM_2, "O1", "", "k2", SemanticAttributes.DbSystemValues.H2, "", "D", "I", "i2", "()I", "setSkinId", "(I)V", "skinId", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "j2", "()Landroidx/lifecycle/MutableLiveData;", "tailLiveData", UserInfo.SEX_FEMALE, "f2", "festivalAnimLiveData", "G", "g2", "festivalBgLiveData", "H", "Ljava/lang/String;", "tailText", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "hbApi", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class FestivalViewModel extends com.tencent.qqnt.qwallet.aio.hb.c {

    /* renamed from: D, reason: from kotlin metadata */
    private int skinId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> tailLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<FestivalHbData.Anim> festivalAnimLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<FestivalHbData.Anim> festivalBgLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String tailText = "\u8282\u65e5\u7ea2\u5305";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IQWalletFestivalHbApi hbApi;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/festival/FestivalViewModel$a;", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$c;", "", "resCode", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$PathResult;", "pathRes", "", "onResult", "Ltk2/a$b;", "a", "Ltk2/a$b;", "getAnim", "()Ltk2/a$b;", "anim", "<init>", "(Lcom/tencent/qqnt/qwallet/aio/festival/FestivalViewModel;Ltk2/a$b;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class a implements IPreloadService.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FestivalHbData.Anim anim;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FestivalViewModel f361720b;

        public a(@NotNull FestivalViewModel festivalViewModel, FestivalHbData.Anim anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            this.f361720b = festivalViewModel;
            this.anim = anim;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int resCode, @Nullable IPreloadService.PathResult pathRes) {
            if (resCode == 0 && pathRes != null) {
                if (!com.tencent.qqnt.qwallet.aio.festival.a.f361721a.d(this.f361720b.k2(), this.f361720b.M1().a())) {
                    this.f361720b.f2().postValue(this.anim);
                } else {
                    this.f361720b.f2().postValue(null);
                }
                this.f361720b.g2().postValue(this.anim);
            }
            QLog.i(this.f361720b.getTAG(), 1, "download" + this.f361720b.h2() + "  resCode:" + resCode + ", url:" + this.anim.getAioUrl());
        }
    }

    public FestivalViewModel() {
        QRouteApi api = QRoute.api(IQWalletFestivalHbApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletFestivalHbApi::class.java)");
        this.hbApi = (IQWalletFestivalHbApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(FestivalHbData.Anim anim) {
        boolean z16;
        String aioUrl = anim.getAioUrl();
        if (aioUrl != null && aioUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            IQWalletFestivalHbApi iQWalletFestivalHbApi = this.hbApi;
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.url = anim.getAioUrl();
            iQWalletFestivalHbApi.getResPath(downloadParam, new a(this, anim));
        }
        QLog.e(getTAG(), 1, "[checkIfPlayAnim" + h2() + " ] params:" + anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(FestivalViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2(FestivalHbData.Anim anim) {
        IQWalletFestivalHbApi iQWalletFestivalHbApi = this.hbApi;
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = anim.getBgUrl();
        iQWalletFestivalHbApi.getResPath(downloadParam, (IPreloadService.c) null);
        IQWalletFestivalHbApi iQWalletFestivalHbApi2 = this.hbApi;
        DownloadParam downloadParam2 = new DownloadParam();
        downloadParam2.url = anim.getFgUrl();
        iQWalletFestivalHbApi2.getResPath(downloadParam2, (IPreloadService.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2() {
        this.festivalAnimLiveData.postValue(null);
    }

    @WorkerThread
    private final void o2() {
        if (this.skinId <= 0) {
            QLog.d(getTAG(), 1, "fetchSkinInfo" + h2() + " : invalid skin " + this.skinId);
            n2();
            return;
        }
        ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).getSkinData(this.skinId, "", 0, new Function1<HbSkinData, Unit>() { // from class: com.tencent.qqnt.qwallet.aio.festival.FestivalViewModel$tryFetchSkinData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                IQWalletFestivalHbApi iQWalletFestivalHbApi;
                boolean z16 = false;
                if (hbSkinData != null) {
                    FestivalViewModel festivalViewModel = FestivalViewModel.this;
                    if (hbSkinData.getSkinId() == festivalViewModel.getSkinId() && Intrinsics.areEqual(hbSkinData.getOuterSkinId(), "") && hbSkinData.getSkinFrom() == 0) {
                        iQWalletFestivalHbApi = festivalViewModel.hbApi;
                        FestivalHbData.Anim anim = iQWalletFestivalHbApi.convertHbData(hbSkinData).getAnim();
                        festivalViewModel.m2(anim);
                        festivalViewModel.e2(anim);
                        z16 = true;
                    }
                }
                if (z16) {
                    return;
                }
                QLog.d(FestivalViewModel.this.getTAG(), 1, "getSkinData" + FestivalViewModel.this.h2() + " : !hasSkinUrl " + FestivalViewModel.this.getSkinId());
                FestivalViewModel.this.n2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.c, com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        super.O1();
        String optString = M1().k().optString("tail_text");
        Intrinsics.checkNotNullExpressionValue(optString, "aioModel.clientExtend.op\u2026bConstants.KEY_TAIL_TEXT)");
        this.tailText = optString;
        this.tailLiveData.postValue(optString);
        QLog.d(getTAG(), 1, "onMsgParsed: vm " + h2() + " skinId " + this.skinId + " msgType " + M1().getMsgType());
        this.skinId = M1().l().uint32_skin_id.get();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.festival.e
            @Override // java.lang.Runnable
            public final void run() {
                FestivalViewModel.l2(FestivalViewModel.this);
            }
        }, 160, null, true);
    }

    @NotNull
    public final MutableLiveData<FestivalHbData.Anim> f2() {
        return this.festivalAnimLiveData;
    }

    @NotNull
    public final MutableLiveData<FestivalHbData.Anim> g2() {
        return this.festivalBgLiveData;
    }

    @NotNull
    public final String h2() {
        return M1().m();
    }

    /* renamed from: i2, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    @NotNull
    public final MutableLiveData<String> j2() {
        return this.tailLiveData;
    }

    @NotNull
    public final String k2() {
        return M1().m();
    }
}
