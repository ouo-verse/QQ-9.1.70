package com.tencent.mobileqq.troop.flame.detail.vm;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.IqunFlameManageSvrPB$GetFlameDetailReq;
import tencent.trpcprotocol.IqunFlameManageSvrPB$GetFlameDetailRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/vm/a;", "Landroidx/lifecycle/ViewModel;", "", "troopUin", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/flame/detail/data/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_flameDetailData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "flameDetailData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static final String D;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.flame.detail.data.a> _flameDetailData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.flame.detail.data.a> flameDetailData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/vm/a$a;", "", "", "GET_FLAME_DETAIL_CMD_0X9150", "Ljava/lang/String;", "", "GET_FLAME_DETAIL_COMMAND", "I", "TAG", "TOP_N_MEMBER_UIN", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.detail.vm.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/flame/detail/vm/a$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QLog.e(a.D, 1, "[requestFlameDetail] [onError] errorCode = " + errorCode + " errorMsg = " + errorMsg);
                return super.onError(errorCode, errorMsg, bundle);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode != 0 || data == null) {
                QLog.e(a.D, 1, "[requestFlameDetail] [onResult] errorCode = " + errorCode);
                return;
            }
            try {
                IqunFlameManageSvrPB$GetFlameDetailRsp iqunFlameManageSvrPB$GetFlameDetailRsp = new IqunFlameManageSvrPB$GetFlameDetailRsp();
                iqunFlameManageSvrPB$GetFlameDetailRsp.mergeFrom(data);
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = iqunFlameManageSvrPB$GetFlameDetailRsp.members.get().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toString());
                }
                String str = iqunFlameManageSvrPB$GetFlameDetailRsp.group_name.get();
                Intrinsics.checkNotNullExpressionValue(str, "rsp.group_name.get()");
                int i3 = iqunFlameManageSvrPB$GetFlameDetailRsp.active_days.get();
                int i16 = iqunFlameManageSvrPB$GetFlameDetailRsp.active_member.get();
                int i17 = iqunFlameManageSvrPB$GetFlameDetailRsp.self_rank.get();
                int i18 = iqunFlameManageSvrPB$GetFlameDetailRsp.global_rank.get();
                String str2 = iqunFlameManageSvrPB$GetFlameDetailRsp.rule.first_flame.get();
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.rule.first_flame.get()");
                String str3 = iqunFlameManageSvrPB$GetFlameDetailRsp.rule.second_flame.get();
                Intrinsics.checkNotNullExpressionValue(str3, "rsp.rule.second_flame.get()");
                String str4 = iqunFlameManageSvrPB$GetFlameDetailRsp.rule.third_flame.get();
                Intrinsics.checkNotNullExpressionValue(str4, "rsp.rule.third_flame.get()");
                String str5 = iqunFlameManageSvrPB$GetFlameDetailRsp.rule.detail.get();
                Intrinsics.checkNotNullExpressionValue(str5, "rsp.rule.detail.get()");
                a.this._flameDetailData.postValue(new com.tencent.mobileqq.troop.flame.detail.data.a(str, i3, i16, i17, i18, new com.tencent.mobileqq.troop.flame.detail.data.b(str2, str3, str4, str5), arrayList, iqunFlameManageSvrPB$GetFlameDetailRsp.member_cnt.get()));
            } catch (Exception e16) {
                QLog.e(a.D, 1, "[requestFlameDetail] [onResult] exception = " + e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36340);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            D = Reflection.getOrCreateKotlinClass(a.class).getSimpleName();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<com.tencent.mobileqq.troop.flame.detail.data.a> mutableLiveData = new MutableLiveData<>();
        this._flameDetailData = mutableLiveData;
        this.flameDetailData = mutableLiveData;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.flame.detail.data.a> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.flameDetailData;
    }

    public final void O1(long troopUin) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, troopUin);
            return;
        }
        IqunFlameManageSvrPB$GetFlameDetailReq iqunFlameManageSvrPB$GetFlameDetailReq = new IqunFlameManageSvrPB$GetFlameDetailReq();
        iqunFlameManageSvrPB$GetFlameDetailReq.group_code.set(troopUin);
        b bVar = new b();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        ProtoUtils.a(appInterface, bVar, iqunFlameManageSvrPB$GetFlameDetailReq.toByteArray(), "OidbSvcTrpcTcp.0x9150_0", 37200, 0);
    }
}
