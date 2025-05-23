package com.tencent.mobileqq.qwallet.setting;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetPaySettingReq;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetPaySettingRsp;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetWalletSettingReq;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetWalletSettingRsp;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Head;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedPoint;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$SettingGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$SettingItem;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.api.FingerPayApi;
import com.tenpay.pay.PayChannelUtils;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.helper.SharedHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u000f\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\u0003H\u0007R#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001e\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0.j\b\u0012\u0004\u0012\u00020\u000b`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/QWalletSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "U1", "W1", "X1", "Z1", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$SettingGroup;", "settingGroups", "Lcom/tencent/mobileqq/qwallet/setting/g;", "S1", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$SettingItem;", "settingItem", "Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "enumBgRadius", "T1", "settingDataItems", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Head;", "P1", "onCreate", "onResume", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "settingDataItemList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "R1", "settingTitleText", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isSoterInit", "Lkotlin/Pair;", "D", "Lkotlin/Pair;", "soterData", "", "E", "I", "startType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "G", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletSettingViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isSoterInit;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Pair<Boolean, String> soterData;

    /* renamed from: E, reason: from kotlin metadata */
    private final int startType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<SettingDataItem> settingDataItems;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<SettingDataItem>> settingDataItemList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> settingTitleText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f279164d;

        public b(o oVar) {
            this.f279164d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) QWalletHomePage$GetPaySettingRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f279164d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + QWalletHomePage$GetPaySettingRsp.class + " failed.");
                    o oVar2 = this.f279164d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f279164d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/setting/QWalletSettingViewModel$c", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetPaySettingRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements o<QWalletHomePage$GetPaySettingRsp> {
        c() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletHomePage$GetPaySettingRsp rsp) {
            List filterNotNull;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            List<QWalletHomePage$SettingGroup> itemList = rsp.groups.get();
            QWalletSettingViewModel qWalletSettingViewModel = QWalletSettingViewModel.this;
            Intrinsics.checkNotNullExpressionValue(itemList, "itemList");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(itemList);
            qWalletSettingViewModel.a2(qWalletSettingViewModel.S1(filterNotNull));
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.f172970g64, 0).show();
            QLog.d("QWalletSettingViewModel", 1, "requestPaySettingPage onFail: errMsg " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f279166d;

        public d(o oVar) {
            this.f279166d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) QWalletHomePage$GetWalletSettingRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f279166d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + QWalletHomePage$GetWalletSettingRsp.class + " failed.");
                    o oVar2 = this.f279166d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f279166d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/setting/QWalletSettingViewModel$e", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetWalletSettingRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements o<QWalletHomePage$GetWalletSettingRsp> {
        e() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletHomePage$GetWalletSettingRsp rsp) {
            List filterNotNull;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            List<QWalletHomePage$SettingGroup> itemList = rsp.groups.get();
            QWalletSettingViewModel qWalletSettingViewModel = QWalletSettingViewModel.this;
            Intrinsics.checkNotNullExpressionValue(itemList, "itemList");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(itemList);
            QWalletSettingViewModel.this.a2(qWalletSettingViewModel.S1(filterNotNull));
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.f172970g64, 0).show();
            QLog.d("QWalletSettingViewModel", 1, "requestSettingPage onFail: errMsg " + errMsg);
        }
    }

    public QWalletSettingViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.settingDataItemList = new MutableLiveData<>();
        this.settingTitleText = new MutableLiveData<>();
        Integer num = (Integer) stateHandle.get("qwallet_setting_start_type");
        if (num == null) {
            intValue = 1;
        } else {
            intValue = num.intValue();
        }
        this.startType = intValue;
        this.settingDataItems = new ArrayList<>();
    }

    private final QWalletHomePage$Head P1() {
        QWalletHomePage$Head qWalletHomePage$Head = new QWalletHomePage$Head();
        qWalletHomePage$Head.qyy_switch.set(true);
        qWalletHomePage$Head.is_youth_mode.set(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
        PBStringField pBStringField = qWalletHomePage$Head.phone_model;
        com.tencent.mobileqq.qwallet.utils.c cVar = com.tencent.mobileqq.qwallet.utils.c.f279254a;
        pBStringField.set(cVar.e());
        qWalletHomePage$Head.memory_size.set(cVar.d());
        qWalletHomePage$Head.cpu_type.set(cVar.a());
        qWalletHomePage$Head.cpu_max_freq.set(cVar.c());
        qWalletHomePage$Head.cpu_core_num.set(cVar.b());
        return qWalletHomePage$Head;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SettingDataItem> S1(List<QWalletHomePage$SettingGroup> settingGroups) {
        List filterNotNull;
        PayChannelUtils.BgRadiusEnum bgRadiusEnum;
        Pair<Boolean, String> pair;
        String name;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (QWalletHomePage$SettingGroup qWalletHomePage$SettingGroup : settingGroups) {
            arrayList.add(SettingDataItem.INSTANCE.a());
            List<QWalletHomePage$SettingItem> list = qWalletHomePage$SettingGroup.items.get();
            Intrinsics.checkNotNullExpressionValue(list, "it.items.get()");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
            int size = qWalletHomePage$SettingGroup.items.get().size();
            int i3 = 0;
            for (Object obj : filterNotNull) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                QWalletHomePage$SettingItem qWalletHomePage$SettingItem = (QWalletHomePage$SettingItem) obj;
                if (size == 1) {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.BothRound;
                } else if (i3 == 0) {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.TopRound;
                } else if (i3 == size - 1) {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.BottomRound;
                } else {
                    bgRadiusEnum = PayChannelUtils.BgRadiusEnum.NONE;
                }
                if (com.tencent.mobileqq.qwallet.utils.g.c("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), true) || (qWalletHomePage$SettingItem.setting_type.get() != 8 && qWalletHomePage$SettingItem.setting_type.get() != 9)) {
                    SettingDataItem T1 = T1(qWalletHomePage$SettingItem, bgRadiusEnum);
                    if (T1.getSettingType() == 5) {
                        T1.l(PatternLockUtils.isPatternLockOpened(MobileQQ.sMobileQQ, com.tencent.mobileqq.base.a.c()));
                    } else if (T1.getSettingType() == 13) {
                        T1.l(QWalletUtils.i(MobileQQ.sMobileQQ).getBoolean("account_num_protect_switch" + com.tencent.mobileqq.base.a.c(), false));
                    } else if (T1.getSettingType() == 2 && (pair = this.soterData) != null) {
                        if (pair == null || (name = pair.getSecond()) == null) {
                            name = T1.getName();
                        }
                        T1.k(name);
                        Pair<Boolean, String> pair2 = this.soterData;
                        if (pair2 != null) {
                            z16 = pair2.getFirst().booleanValue();
                        } else {
                            z16 = false;
                        }
                        T1.l(z16);
                    }
                    arrayList.add(T1);
                }
                i3 = i16;
            }
        }
        arrayList.add(SettingDataItem.INSTANCE.a());
        return arrayList;
    }

    private final SettingDataItem T1(QWalletHomePage$SettingItem settingItem, PayChannelUtils.BgRadiusEnum enumBgRadius) {
        int i3 = settingItem.f41698id.get();
        String str = settingItem.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "settingItem.name.get()");
        String str2 = settingItem.sub_name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "settingItem.sub_name.get()");
        String str3 = settingItem.icon.get();
        Intrinsics.checkNotNullExpressionValue(str3, "settingItem.icon.get()");
        String str4 = settingItem.f41699pv.get();
        Intrinsics.checkNotNullExpressionValue(str4, "settingItem.pv.get()");
        String str5 = settingItem.url.get();
        Intrinsics.checkNotNullExpressionValue(str5, "settingItem.url.get()");
        int i16 = settingItem.setting_type.get();
        QWalletHomePage$RedPoint qWalletHomePage$RedPoint = settingItem.red_point;
        Intrinsics.checkNotNullExpressionValue(qWalletHomePage$RedPoint, "settingItem.red_point");
        return new SettingDataItem(i3, str, str2, str3, str4, str5, i16, qWalletHomePage$RedPoint, false, enumBgRadius, 256, null);
    }

    private final void U1() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", com.tencent.mobileqq.base.a.c());
        BaseApplication context = BaseApplication.getContext();
        final Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        FingerPayApi.initFingerASK(context, hashMap, new ResultReceiver(uIHandlerV2) { // from class: com.tencent.mobileqq.qwallet.setting.QWalletSettingViewModel$queryEntryStatus$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);
                QLog.d("QWalletSettingViewModel", 1, "initFingerASK onReceiveResult resultCode = " + resultCode);
                switch (resultCode) {
                    case 99998:
                    case 99999:
                        return;
                    default:
                        if (resultCode == 0) {
                            QWalletSettingViewModel.this.W1();
                            QWalletSettingViewModel.this.isSoterInit = true;
                            return;
                        }
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1() {
        String str;
        boolean z16;
        boolean z17;
        boolean soterOpen = SharedHelper.soterOpen(com.tencent.mobileqq.base.a.c());
        GetSupportSoterNet.SoterSupportRes soterSupportRes = GetSupportSoterNet.sSupportResCache;
        Object obj = null;
        if (soterSupportRes != null) {
            str = soterSupportRes.soter_suggest_title;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Iterator<T> it = this.settingDataItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SettingDataItem) next).getSettingType() == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    obj = next;
                    break;
                }
            }
            SettingDataItem settingDataItem = (SettingDataItem) obj;
            if (settingDataItem != null) {
                settingDataItem.l(soterOpen);
                settingDataItem.k(str);
            }
            this.soterData = new Pair<>(Boolean.valueOf(soterOpen), str);
            this.settingDataItemList.setValue(this.settingDataItems);
        }
    }

    private final void X1() {
        QWalletHomePage$GetPaySettingReq qWalletHomePage$GetPaySettingReq = new QWalletHomePage$GetPaySettingReq();
        qWalletHomePage$GetPaySettingReq.head.set(P1());
        c cVar = new c();
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.homepage2.Homepage2.SsoGetPaySetting callback: " + cVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.homepage2.Homepage2.SsoGetPaySetting");
        newIntent.putExtra("data", fh.b(qWalletHomePage$GetPaySettingReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new b(cVar));
        waitAppRuntime.startServlet(newIntent);
    }

    private final void Z1() {
        QWalletHomePage$GetWalletSettingReq qWalletHomePage$GetWalletSettingReq = new QWalletHomePage$GetWalletSettingReq();
        qWalletHomePage$GetWalletSettingReq.head.set(P1());
        e eVar = new e();
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.homepage2.Homepage2.SsoGetWalletSetting callback: " + eVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.homepage2.Homepage2.SsoGetWalletSetting");
        newIntent.putExtra("data", fh.b(qWalletHomePage$GetWalletSettingReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new d(eVar));
        waitAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List<com.tencent.mobileqq.qwallet.setting.g>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.Collection, java.util.ArrayList] */
    public final void a2(List<SettingDataItem> settingDataItems) {
        Object obj;
        boolean z16;
        boolean z17;
        this.settingDataItems.clear();
        this.settingDataItems.addAll((Collection) settingDataItems);
        Pair<Boolean, String> pair = this.soterData;
        Iterable iterable = (Iterable) settingDataItems;
        Iterator it = iterable.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SettingDataItem) obj).getSettingType() == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QLog.d("QWalletSettingViewModel", 1, "updateSettingItems soterData = " + pair + " fingerPrinter = " + obj);
        if (this.soterData == null) {
            settingDataItems = new ArrayList<>();
            for (Object obj2 : iterable) {
                if (((SettingDataItem) obj2).getSettingType() != 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    settingDataItems.add(obj2);
                }
            }
        }
        this.settingDataItemList.setValue(settingDataItems);
    }

    @NotNull
    public final MutableLiveData<List<SettingDataItem>> Q1() {
        return this.settingDataItemList;
    }

    @NotNull
    public final MutableLiveData<String> R1() {
        return this.settingTitleText;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        if (this.startType == 2) {
            this.settingTitleText.setValue("\u652f\u4ed8\u8bbe\u7f6e");
            X1();
        } else {
            this.settingTitleText.setValue("\u8bbe\u7f6e");
            Z1();
        }
        U1();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.isSoterInit) {
            W1();
        }
    }
}
