package com.tencent.mobileqq.qwallet.hb.send.model;

import android.os.Bundle;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import bl2.g;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 _2\u00020\u0001:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J:\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006*\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t*\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0003J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0002J\"\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001bJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fJ\u0012\u0010#\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u000bH\u0007J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0007J\u0006\u0010%\u001a\u00020\tR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020'0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u001f\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0+8\u0006\u00a2\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002060&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010)R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u0002060+8\u0006\u00a2\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u0010/R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010)R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000b0+8\u0006\u00a2\u0006\f\n\u0004\b>\u0010-\u001a\u0004\b?\u0010/R\u0018\u0010C\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR$\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010DR\u0016\u0010W\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010AR\u0016\u0010Y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010AR\u0016\u0010\\\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/model/SendFestivalHbViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Ltk2/a;", "P1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dataList", "Q1", "", "X1", "", "O1", "N1", "", "skinId", "Z1", "b2", "d2", "c2", "reportClose", "e2", "isEnter", "it", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lbl2/g;", "logic", "", "", BaseConstants.ATTR_KET_EXTRA_MAP, "W1", "Landroid/os/Bundle;", "args", "init", "fromUser", "onClose", "T1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_amountLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "getAmountLiveData", "()Landroidx/lifecycle/LiveData;", "amountLiveData", BdhLogUtil.LogTag.Tag_Conn, "_wishLiveData", "D", "getWishLiveData", "wishLiveData", "Ltk2/a$b;", "E", "_animLiveData", UserInfo.SEX_FEMALE, "getAnimLiveData", "animLiveData", "G", "_closeLiveData", "H", "getCloseLiveData", "closeLiveData", "I", "Ltk2/a;", "curHbData", "J", "Ljava/util/ArrayList;", "hbDataList", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "K", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "hbApi", "Lcom/tencent/mobileqq/qwallet/report/IReportApi;", "L", "Lcom/tencent/mobileqq/qwallet/report/IReportApi;", "reportApi", "Lcom/tencent/mobileqq/qwallet/hb/HbInfo$a;", "M", "Lcom/tencent/mobileqq/qwallet/hb/HbInfo$a;", "bundleInfo", "", "N", "startTime", "P", "curSkinId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "curIndex", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "toUin", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SendFestivalHbViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<String> _wishLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> wishLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<FestivalHbData.Anim> _animLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<FestivalHbData.Anim> animLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> _closeLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> closeLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private FestivalHbData curHbData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<FestivalHbData> hbDataList;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final IQWalletFestivalHbApi hbApi;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final IReportApi reportApi;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final HbInfo.a bundleInfo;

    /* renamed from: N, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: P, reason: from kotlin metadata */
    private int curSkinId;

    /* renamed from: Q, reason: from kotlin metadata */
    private int curIndex;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final String toUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Float> _amountLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Float> amountLiveData;

    public SendFestivalHbViewModel() {
        String str;
        MutableLiveData<Float> mutableLiveData = new MutableLiveData<>();
        this._amountLiveData = mutableLiveData;
        this.amountLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._wishLiveData = mutableLiveData2;
        this.wishLiveData = mutableLiveData2;
        MutableLiveData<FestivalHbData.Anim> mutableLiveData3 = new MutableLiveData<>();
        this._animLiveData = mutableLiveData3;
        this.animLiveData = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._closeLiveData = mutableLiveData4;
        this.closeLiveData = mutableLiveData4;
        this.hbDataList = new ArrayList<>();
        QRouteApi api = QRoute.api(IQWalletFestivalHbApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletFestivalHbApi::class.java)");
        this.hbApi = (IQWalletFestivalHbApi) api;
        QRouteApi api2 = QRoute.api(IReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IReportApi::class.java)");
        this.reportApi = (IReportApi) api2;
        HbInfo.a aVar = new HbInfo.a();
        this.bundleInfo = aVar;
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(aVar.recv_type)) {
            str = aVar.guild_id;
        } else {
            str = aVar.recv_uin;
        }
        this.toUin = str;
    }

    private final void N1() {
        if (this.curIndex >= this.hbDataList.size()) {
            int i3 = 0;
            this.curIndex = 0;
            if (this.hbDataList.size() <= 1) {
                return;
            }
            do {
                i3++;
                if (i3 <= 10) {
                    Collections.shuffle(this.hbDataList);
                } else {
                    return;
                }
            } while (this.hbDataList.get(this.curIndex).getSkinId() == this.curSkinId);
        }
    }

    @UiThread
    private final boolean O1() {
        if (this.hbDataList.isEmpty()) {
            onClose(false);
            return false;
        }
        return true;
    }

    private final List<FestivalHbData> P1() {
        JSONArray jSONArray;
        JSONObject f16 = RedPacketManager.f(18);
        if (f16 != null) {
            jSONArray = f16.optJSONArray("skinIDList");
        } else {
            jSONArray = null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                HbSkinRepository hbSkinRepository = HbSkinRepository.f277840a;
                HbSkinData f17 = HbSkinRepository.f(hbSkinRepository, jSONArray.optInt(i3), null, 0, 6, null);
                if (f17 != null) {
                    FestivalHbData convertHbData = this.hbApi.convertHbData(f17);
                    if (convertHbData.getInfo().getAmount() != 0) {
                        arrayList.add(convertHbData);
                    } else {
                        QLog.i("QWallet.Festival.SendFestivalHbView", 1, "skin price is invalid,skinId:" + convertHbData.getSkinId());
                    }
                }
                hbSkinRepository.i(jSONArray.optInt(i3), "", 0, new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.model.SendFestivalHbViewModel$getHbDataList$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                        invoke2(hbSkinData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable HbSkinData hbSkinData) {
                        QLog.i("QWallet.Festival.SendFestivalHbView", 2, "on skinData update:" + (hbSkinData != null ? Integer.valueOf(hbSkinData.getSkinId()) : null));
                    }
                });
            }
        }
        return arrayList;
    }

    private final ArrayList<FestivalHbData> Q1(ArrayList<FestivalHbData> arrayList, List<FestivalHbData> list) {
        arrayList.clear();
        arrayList.addAll(list);
        if (arrayList.size() > 0) {
            Collections.shuffle(arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(final SendFestivalHbViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hbApi.checkIfNeedLoadLightSdk();
        this$0.X1(this$0.Q1(this$0.hbDataList, this$0.P1()));
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.model.e
            @Override // java.lang.Runnable
            public final void run() {
                SendFestivalHbViewModel.S1(SendFestivalHbViewModel.this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(SendFestivalHbViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T1(true);
    }

    public static /* synthetic */ void U1(SendFestivalHbViewModel sendFestivalHbViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        sendFestivalHbViewModel.onClose(z16);
    }

    private final void X1(ArrayList<FestivalHbData> arrayList) {
        ((IQWalletFestivalHbApi) QRoute.api(IQWalletFestivalHbApi.class)).preDownloadSkinRes(arrayList);
    }

    private final void Z1(int skinId) {
        String str;
        String str2;
        IReportApi iReportApi = this.reportApi;
        HbInfo.a aVar = this.bundleInfo;
        String str3 = aVar.recv_type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar.panel_name;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String valueOf = String.valueOf(skinId);
        String str5 = this.toUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        iReportApi.reportHongbaoTo644("festival.change.click", str3, str, valueOf, str2);
    }

    private final void a2(boolean isEnter, FestivalHbData it) {
        int i3;
        int i16;
        int i17 = 0;
        if (isEnter) {
            if (it != null) {
                i16 = it.getSkinId();
            } else {
                i16 = 0;
            }
            b2(i16);
        } else {
            FestivalHbData festivalHbData = this.curHbData;
            if (festivalHbData != null) {
                i3 = festivalHbData.getSkinId();
            } else {
                i3 = 0;
            }
            Z1(i3);
        }
        if (it != null) {
            i17 = it.getSkinId();
        }
        d2(i17);
    }

    private final void b2(int skinId) {
        String str;
        String str2;
        IReportApi iReportApi = this.reportApi;
        HbInfo.a aVar = this.bundleInfo;
        String str3 = aVar.recv_type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar.panel_name;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String valueOf = String.valueOf(skinId);
        String str5 = this.toUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        iReportApi.reportHongbaoTo644("redpack.send.show", str3, str, valueOf, str2);
    }

    private final void c2() {
        String str;
        int i3;
        String str2;
        IReportApi iReportApi = this.reportApi;
        HbInfo.a aVar = this.bundleInfo;
        String str3 = aVar.recv_type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar.panel_name;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        FestivalHbData festivalHbData = this.curHbData;
        if (festivalHbData != null) {
            i3 = festivalHbData.getSkinId();
        } else {
            i3 = 0;
        }
        String valueOf = String.valueOf(i3);
        String str5 = this.toUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        iReportApi.reportHongbaoTo644("redpack.paybtn.click", str3, str, valueOf, str2);
    }

    private final void d2(int skinId) {
        String str;
        String str2;
        IReportApi iReportApi = this.reportApi;
        HbInfo.a aVar = this.bundleInfo;
        String str3 = aVar.recv_type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar.panel_name;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String valueOf = String.valueOf(skinId);
        String str5 = this.toUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        iReportApi.reportHongbaoTo644("festival.skin.show", str3, str, valueOf, str2);
    }

    private final void e2() {
        String str;
        String str2;
        IReportApi iReportApi = this.reportApi;
        HbInfo.a aVar = this.bundleInfo;
        String str3 = aVar.recv_type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar.panel_name;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - this.startTime);
        String str5 = this.toUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        iReportApi.reportHongbaoTo644("redpack.send.showtime", str3, str, valueOf, str2);
    }

    private final void reportClose() {
        String str;
        int i3;
        String str2;
        IReportApi iReportApi = this.reportApi;
        HbInfo.a aVar = this.bundleInfo;
        String str3 = aVar.recv_type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar.panel_name;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        FestivalHbData festivalHbData = this.curHbData;
        if (festivalHbData != null) {
            i3 = festivalHbData.getSkinId();
        } else {
            i3 = 0;
        }
        String valueOf = String.valueOf(i3);
        String str5 = this.toUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        iReportApi.reportHongbaoTo644("festival.send.close", str3, str, valueOf, str2);
    }

    @UiThread
    public final void T1(boolean isEnter) {
        if (!O1()) {
            QLog.i("QWallet.Festival.SendFestivalHbView", 1, "[onChangeAmount] hbDataList is empty");
            return;
        }
        N1();
        ArrayList<FestivalHbData> arrayList = this.hbDataList;
        int i3 = this.curIndex;
        this.curIndex = i3 + 1;
        FestivalHbData festivalHbData = arrayList.get(i3);
        this._wishLiveData.setValue(festivalHbData.getInfo().getWish());
        this._amountLiveData.setValue(Float.valueOf(festivalHbData.getInfo().getAmount() / 100));
        this._animLiveData.setValue(festivalHbData.getAnim());
        a2(isEnter, festivalHbData);
        this.curHbData = festivalHbData;
        this.curSkinId = festivalHbData.getSkinId();
        QLog.d("QWallet.Festival.SendFestivalHbView", 1, "[onChangeAmount] " + this.curHbData + ",hbDataListSize:" + this.hbDataList.size());
    }

    public final void W1(@NotNull g logic, @NotNull Map<String, String> extraMap) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        FestivalHbData festivalHbData = this.curHbData;
        if (festivalHbData != null) {
            extraMap.put("wishing", String.valueOf(festivalHbData.getInfo().getWish()));
            extraMap.put("total_amount", String.valueOf(festivalHbData.getInfo().getAmount()));
            extraMap.put("total_num", "1");
            extraMap.put(WadlProxyConsts.CHANNEL, "1000005");
            extraMap.put("type", "1");
            extraMap.put("skin_id", String.valueOf(festivalHbData.getSkinId()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tail_text", festivalHbData.getInfo().getTailText());
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply { put\u2026fo.tailText) }.toString()");
            extraMap.put("client_extend", jSONObject2);
            c2();
            QLog.i("QWallet.Festival.SendFestivalHbView", 1, "extraMap:" + extraMap);
            logic.b(extraMap);
        }
    }

    @NotNull
    public final LiveData<Float> getAmountLiveData() {
        return this.amountLiveData;
    }

    @NotNull
    public final LiveData<FestivalHbData.Anim> getAnimLiveData() {
        return this.animLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getCloseLiveData() {
        return this.closeLiveData;
    }

    @NotNull
    public final LiveData<String> getWishLiveData() {
        return this.wishLiveData;
    }

    public final void init(@NotNull Bundle args) {
        String str;
        Intrinsics.checkNotNullParameter(args, "args");
        HbInfo.c(args, this.bundleInfo);
        HbInfo.a aVar = this.bundleInfo;
        JSONObject festivalHbPanelConfig = this.hbApi.getFestivalHbPanelConfig();
        if (festivalHbPanelConfig != null) {
            str = festivalHbPanelConfig.optString("name");
        } else {
            str = null;
        }
        aVar.panel_name = str;
        this.startTime = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.model.d
            @Override // java.lang.Runnable
            public final void run() {
                SendFestivalHbViewModel.R1(SendFestivalHbViewModel.this);
            }
        }, 32, null, false);
    }

    @UiThread
    public final void onClose(boolean fromUser) {
        this._closeLiveData.setValue(Boolean.valueOf(fromUser));
        reportClose();
    }

    public final void onDestroy() {
        this.hbApi.releasePagAnim();
        e2();
    }
}
