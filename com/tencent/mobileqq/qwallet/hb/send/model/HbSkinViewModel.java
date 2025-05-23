package com.tencent.mobileqq.qwallet.hb.send.model;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import bl2.HbSkinInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetUserSkinRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SkinInfo;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SsoDelSkinReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SsoDelSkinRsp;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\bA\u0010BJ\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0007H\u0007J\u0006\u0010\u0015\u001a\u00020\u0007R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR,\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001f\u0012\u0004\u0012\u00020\u00030\u001e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010(\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010#R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R2\u00106\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0007008\u0006\u00a2\u0006\f\n\u0004\b*\u00103\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0019\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110;8F\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R)\u0010@\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001f\u0012\u0004\u0012\u00020\u00030\u001e0;8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/model/HbSkinViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "fromCache", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetUserSkinRsp;", "rsp", "", "Z1", "", "mSkinId", "", "mOuterSkinId", "mSkinFrom", "W1", "position", "X1", "Lbl2/c;", "hbSkinInfo", "O1", "onCreate", "U1", "Landroidx/lifecycle/SavedStateHandle;", "i", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_selectHbSkinLiveData", "Lkotlin/Pair;", "", BdhLogUtil.LogTag.Tag_Conn, "_hbSkinListLiveData", "D", "Ljava/lang/String;", WadlProxyConsts.EXTRA_DATA, "E", "R1", "()Ljava/lang/String;", "recvType", UserInfo.SEX_FEMALE, "I", "skinId", "G", "outerSkinId", "H", "skinFrom", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "Q1", "()Lkotlin/jvm/functions/Function1;", "recommendNotifyRefreshCallback", "Lmqq/observer/BusinessObserver;", "J", "Lmqq/observer/BusinessObserver;", "observer", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "selectHbSkinLiveData", "P1", "hbSkinListLiveData", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "K", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<List<HbSkinInfo>, Boolean>> _hbSkinListLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String extraData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String recvType;

    /* renamed from: F, reason: from kotlin metadata */
    private int skinId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String outerSkinId;

    /* renamed from: H, reason: from kotlin metadata */
    private int skinFrom;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> recommendNotifyRefreshCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final BusinessObserver observer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SavedStateHandle stateHandle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<HbSkinInfo> _selectHbSkinLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277765d;

        public b(o oVar) {
            this.f277765d = oVar;
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
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$SsoDelSkinRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277765d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$SsoDelSkinRsp.class + " failed.");
                    o oVar2 = this.f277765d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277765d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/model/HbSkinViewModel$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$SsoDelSkinRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements o<RedPackSkin$SsoDelSkinRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HbSkinInfo f277766a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HbSkinViewModel f277767b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<HbSkinInfo> f277768c;

        c(HbSkinInfo hbSkinInfo, HbSkinViewModel hbSkinViewModel, List<HbSkinInfo> list) {
            this.f277766a = hbSkinInfo;
            this.f277767b = hbSkinViewModel;
            this.f277768c = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$SsoDelSkinRsp rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            boolean z17 = true;
            if (rsp.code.get() == 0) {
                QQToast.makeText(MobileQQ.sMobileQQ, 2, "\u5220\u9664\u5c01\u9762\u6210\u529f", 0).show();
                HbSkinInfo hbSkinInfo = (HbSkinInfo) this.f277767b._selectHbSkinLiveData.getValue();
                if (hbSkinInfo == null || this.f277766a.getSkinId() != hbSkinInfo.getSkinId()) {
                    z17 = false;
                }
                if (z17) {
                    this.f277767b.X1(0);
                }
                this.f277768c.remove(this.f277766a);
                this.f277767b._hbSkinListLiveData.postValue(new Pair(this.f277768c, Boolean.TRUE));
                return;
            }
            String str = rsp.f278708msg.get();
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = "\u5220\u9664\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
            QQToast.makeText(MobileQQ.sMobileQQ, 1, str, 0).show();
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QQToast.makeText(MobileQQ.sMobileQQ, 1, "\u5220\u9664\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/model/HbSkinViewModel$d", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetUserSkinRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements o<RedPackSkin$GetUserSkinRsp> {
        d() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$GetUserSkinRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            HbSkinViewModel.this.Z1(false, rsp);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("HbSkinViewModel", 1, "requestRedPacketSkinListFromServer error:" + errMsg);
        }
    }

    public HbSkinViewModel(@NotNull SavedStateHandle stateHandle) {
        ArrayList arrayListOf;
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.stateHandle = stateHandle;
        this._selectHbSkinLiveData = new MutableLiveData<>();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(bl2.d.a());
        this._hbSkinListLiveData = new MutableLiveData<>(new Pair(arrayListOf, Boolean.FALSE));
        com.tencent.mobileqq.qwallet.utils.impl.c cVar = com.tencent.mobileqq.qwallet.utils.impl.c.f279281a;
        String b16 = cVar.b(stateHandle, "extra_data");
        b16 = b16 == null ? "" : b16;
        this.extraData = b16;
        Integer a16 = cVar.a(stateHandle, "skin_id");
        if (a16 != null) {
            i3 = a16.intValue();
        } else {
            i3 = 0;
        }
        this.skinId = i3;
        String b17 = cVar.b(stateHandle, "outer_skin_id");
        this.outerSkinId = b17 == null ? "" : b17;
        Integer a17 = cVar.a(stateHandle, "skin_from");
        this.skinFrom = a17 != null ? a17.intValue() : 0;
        this.recommendNotifyRefreshCallback = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.model.HbSkinViewModel$recommendNotifyRefreshCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i16) {
                HbSkinViewModel.this.W1(i16, "", 0);
                HbSkinViewModel.this.U1();
                MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.mobileqq.qwallet.hb.skin.refresh"));
            }
        };
        HashMap<String, String> s16 = com.tencent.mobileqq.qwallet.impl.d.s(b16);
        if (s16 != null) {
            str = s16.get("recv_type");
        } else {
            str = null;
        }
        String str2 = str != null ? str : "";
        this.recvType = str2;
        QLog.i("HbSkinViewModel", 1, "init: skinId=" + this.skinId + ", skinFrom=" + this.skinFrom + ", recvType=" + str2);
        this.observer = new BusinessObserver() { // from class: com.tencent.mobileqq.qwallet.hb.send.model.a
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i16, boolean z16, Bundle bundle) {
                HbSkinViewModel.T1(HbSkinViewModel.this, i16, z16, bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(HbSkinViewModel this$0, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("HbSkinViewModel", 2, "mObserver type = " + i3 + " isSuccess = " + z16 + " bundle = " + bundle);
        }
        if (bundle == null || i3 != 29 || !z16) {
            return;
        }
        RedPackSkin$GetUserSkinRsp redPackSkin$GetUserSkinRsp = new RedPackSkin$GetUserSkinRsp();
        try {
            redPackSkin$GetUserSkinRsp.mergeFrom(bundle.getByteArray("rsp"));
        } catch (Exception e16) {
            QLog.e("HbSkinViewModel", 1, e16, new Object[0]);
        }
        this$0.Z1(false, redPackSkin$GetUserSkinRsp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O1(@NotNull HbSkinInfo hbSkinInfo) {
        List mutableList;
        Intrinsics.checkNotNullParameter(hbSkinInfo, "hbSkinInfo");
        Pair<List<HbSkinInfo>, Boolean> value = this._hbSkinListLiveData.getValue();
        if (value != null && (r0 = value.getFirst()) != null && mutableList != null) {
            RedPackSkin$SsoDelSkinReq redPackSkin$SsoDelSkinReq = new RedPackSkin$SsoDelSkinReq();
            redPackSkin$SsoDelSkinReq.skin_id.set(hbSkinInfo.getSkinId());
            redPackSkin$SsoDelSkinReq.skin_from.set(hbSkinInfo.getSkinFrom());
            redPackSkin$SsoDelSkinReq.outer_skin_id.set(hbSkinInfo.getOuterSkinId());
            c cVar = new c(hbSkinInfo, this, mutableList);
            p.Companion companion = p.INSTANCE;
            QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoDelSkin callback: " + cVar + TokenParser.SP);
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
            newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoDelSkin");
            newIntent.putExtra("data", fh.b(redPackSkin$SsoDelSkinReq.toByteArray()));
            newIntent.putExtra("timeout", 30000L);
            newIntent.setObserver(new b(cVar));
            waitAppRuntime.startServlet(newIntent);
        }
    }

    @NotNull
    public final LiveData<Pair<List<HbSkinInfo>, Boolean>> P1() {
        return this._hbSkinListLiveData;
    }

    @NotNull
    public final Function1<Integer, Unit> Q1() {
        return this.recommendNotifyRefreshCallback;
    }

    @NotNull
    /* renamed from: R1, reason: from getter */
    public final String getRecvType() {
        return this.recvType;
    }

    @NotNull
    public final LiveData<HbSkinInfo> S1() {
        return this._selectHbSkinLiveData;
    }

    public final void U1() {
        HbSkinRemoteDataSource.f277873a.j(this.recvType, new d());
    }

    public final void W1(int mSkinId, @NotNull String mOuterSkinId, int mSkinFrom) {
        List<HbSkinInfo> first;
        HbSkinInfo b16;
        Intrinsics.checkNotNullParameter(mOuterSkinId, "mOuterSkinId");
        this.skinId = mSkinId;
        this.outerSkinId = mOuterSkinId;
        this.skinFrom = mSkinFrom;
        Pair<List<HbSkinInfo>, Boolean> value = P1().getValue();
        if (value != null && (first = value.getFirst()) != null && (b16 = bl2.d.b(first, this.skinId, this.outerSkinId, this.skinFrom)) != null && !b16.getIsDisable()) {
            this._selectHbSkinLiveData.postValue(b16);
        }
    }

    public final void X1(int position) {
        List<HbSkinInfo> first;
        Pair<List<HbSkinInfo>, Boolean> value = this._hbSkinListLiveData.getValue();
        if (value != null && (first = value.getFirst()) != null && position < first.size() && position >= 0) {
            HbSkinInfo hbSkinInfo = first.get(position);
            this.skinId = hbSkinInfo.getSkinId();
            this.outerSkinId = hbSkinInfo.getOuterSkinId();
            this.skinFrom = hbSkinInfo.getSkinFrom();
            this._selectHbSkinLiveData.postValue(hbSkinInfo);
            HbSkinRemoteDataSource.f277873a.n(hbSkinInfo.getSkinId(), hbSkinInfo.getOuterSkinId(), hbSkinInfo.getSkinFrom());
        }
    }

    public final void Z1(boolean fromCache, @NotNull RedPackSkin$GetUserSkinRsp rsp) {
        boolean z16;
        HbSkinInfo b16;
        Object obj;
        String str;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean g16 = com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.recvType);
        for (RedPackSkin$SkinInfo redPackSkin$SkinInfo : rsp.skins.get()) {
            int i3 = redPackSkin$SkinInfo.skin_id.get();
            String str2 = redPackSkin$SkinInfo.outer_skin_id.get();
            Intrinsics.checkNotNullExpressionValue(str2, "item.outer_skin_id.get()");
            int i16 = redPackSkin$SkinInfo.skin_from.get();
            String str3 = redPackSkin$SkinInfo.title.get();
            int i17 = redPackSkin$SkinInfo.type.get();
            String str4 = redPackSkin$SkinInfo.default_skin_url.get();
            String str5 = redPackSkin$SkinInfo.pop_res_url.get();
            String str6 = redPackSkin$SkinInfo.pop_open_url.get();
            String str7 = redPackSkin$SkinInfo.aio_res_url.get();
            String str8 = redPackSkin$SkinInfo.make_res_url.get();
            String str9 = redPackSkin$SkinInfo.pop_broken_url.get();
            String str10 = redPackSkin$SkinInfo.expire_date_prompt.get();
            List<String> list = redPackSkin$SkinInfo.labels.get();
            Intrinsics.checkNotNullExpressionValue(list, "item.labels.get()");
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    String it5 = (String) obj;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    if (it5.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            String str11 = (String) obj;
            if (str11 == null) {
                str = "";
            } else {
                str = str11;
            }
            String str12 = redPackSkin$SkinInfo.badge_url.get();
            boolean z19 = redPackSkin$SkinInfo.disabled.get();
            String str13 = redPackSkin$SkinInfo.disabled_tip.get();
            if (str13.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (g16) {
                    str13 = "\u9891\u9053\u6682\u4e0d\u652f\u6301\u4f7f\u7528";
                } else {
                    str13 = "\u6682\u4e0d\u652f\u6301\u4f7f\u7528";
                }
            }
            arrayList2.add(new HbSkinInfo(i3, str2, i16, str3, i17, str4, str5, str6, str7, str8, str9, str10, str, str12, z19, str13, false, 65536, null));
        }
        arrayList.add(bl2.d.a());
        arrayList.addAll(arrayList2);
        int i18 = this.skinId;
        if (i18 != 0) {
            QLog.d("HbSkinViewModel", 2, " skinId = " + i18 + " outerSkinId\uff1a" + this.outerSkinId + " skinFrom:" + this.skinFrom);
            HbSkinInfo b17 = bl2.d.b(arrayList2, this.skinId, this.outerSkinId, this.skinFrom);
            if (b17 != null && !b17.getIsDisable()) {
                this._selectHbSkinLiveData.postValue(b17);
                HbSkinRemoteDataSource.f277873a.n(b17.getSkinId(), b17.getOuterSkinId(), b17.getSkinFrom());
                z16 = true;
                if (!z16 && !fromCache) {
                    int i19 = rsp.selected_skin_id.get();
                    String serverOuterSkinId = rsp.selected_outer_skin_id.get();
                    int i26 = rsp.selected_skin_from.get();
                    QLog.d("HbSkinViewModel", 2, " serverSkinId = " + i19 + " serverOuterSkinId\uff1a" + serverOuterSkinId + " serverSkinFrom:" + i26);
                    Intrinsics.checkNotNullExpressionValue(serverOuterSkinId, "serverOuterSkinId");
                    b16 = bl2.d.b(arrayList2, i19, serverOuterSkinId, i26);
                    if (b16 != null && !b16.getIsDisable()) {
                        this._selectHbSkinLiveData.postValue(b16);
                    }
                }
                this._hbSkinListLiveData.postValue(new Pair<>(arrayList, Boolean.FALSE));
            }
        }
        z16 = false;
        if (!z16) {
            int i192 = rsp.selected_skin_id.get();
            String serverOuterSkinId2 = rsp.selected_outer_skin_id.get();
            int i262 = rsp.selected_skin_from.get();
            QLog.d("HbSkinViewModel", 2, " serverSkinId = " + i192 + " serverOuterSkinId\uff1a" + serverOuterSkinId2 + " serverSkinFrom:" + i262);
            Intrinsics.checkNotNullExpressionValue(serverOuterSkinId2, "serverOuterSkinId");
            b16 = bl2.d.b(arrayList2, i192, serverOuterSkinId2, i262);
            if (b16 != null) {
                this._selectHbSkinLiveData.postValue(b16);
            }
        }
        this._hbSkinListLiveData.postValue(new Pair<>(arrayList, Boolean.FALSE));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        U1();
        ApngImage.playByTag(0);
    }
}
