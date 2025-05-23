package com.tencent.mobileqq.cardcontainer.data.mmkv;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.cardcontainer.data.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u001fR\"\u0010(\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/mmkv/a;", "", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "", "a", "", "nextReqTime", "l", "isSwitch", "b", "i", "dataID", "", "itemId", "isAggregatedCard", "k", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/c;", "Lkotlin/collections/ArrayList;", "e", "c", "isDeleteAll", "j", "d", "f", "show", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/cardcontainer/data/CardContainerSwitchState;", "state", "p", h.F, "Ljava/lang/String;", "getMCurrentUin", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "mCurrentUin", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f201087a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurrentUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/cardcontainer/data/mmkv/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/c;", "Lkotlin/collections/ArrayList;", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.data.mmkv.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7445a extends TypeToken<ArrayList<c>> {
        static IPatchRedirector $redirector_;

        C7445a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            f201087a = new a();
            mCurrentUin = "";
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Intrinsics.checkNotNullExpressionValue(QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD), "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        String str = mCurrentUin;
        if (currentTimeMillis <= r2.getInt(TianShuManager.KEY_VAS_NEXT_REQUEST_TIME + str, 0)) {
            return false;
        }
        return true;
    }

    public final void b(boolean isSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isSwitch);
            return;
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putBoolean("change_req_limit_" + mCurrentUin, isSwitch);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putString("delete_data_" + mCurrentUin, "");
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return withAccount.getBoolean("delete_all_data_" + mCurrentUin, false);
    }

    @NotNull
    public final ArrayList<c> e() {
        ArrayList<c> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        try {
            arrayList = (ArrayList) new Gson().fromJson(withAccount.getString("delete_data_" + mCurrentUin, ""), new C7445a().getType());
        } catch (Exception e16) {
            QLog.e("CardContainer.CardDataMMKVUtil", 1, "getDeleteDataFromMMKV " + e16);
            arrayList = null;
        }
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public final boolean f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean z16 = withAccount.getBoolean("setting_switch_local_data_" + str, false);
        QLog.i("CardContainer.CardDataMMKVUtil", 1, "CardDataMMKVUtil getLocalCardContainerSwitchShowingState show:" + z16);
        return z16;
    }

    @Nullable
    public final TianShuAccess.AdPlacementInfo g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TianShuAccess.AdPlacementInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        byte[] bytes = withAccount.getBytes("container_data_" + mCurrentUin, null);
        if (bytes == null) {
            return null;
        }
        try {
            TianShuAccess.AdPlacementInfo adPlacementInfo = new TianShuAccess.AdPlacementInfo();
            adPlacementInfo.mergeFrom(bytes);
            return adPlacementInfo;
        } catch (Exception e16) {
            QLog.e("CardContainer.CardDataMMKVUtil", 1, "getPBDateFromMMKV " + e16);
            return null;
        }
    }

    @NotNull
    public final CardContainerSwitchState h() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (CardContainerSwitchState) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        CardContainerSwitchState a16 = CardContainerSwitchState.INSTANCE.a(withAccount.getInt("setting_switch_remote_data_" + str, 0));
        QLog.i("CardContainer.CardDataMMKVUtil", 1, "CardDataMMKVUtil getRemoteCardContainerSwitchState state:" + a16);
        return a16;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return withAccount.getBoolean("change_req_limit_" + mCurrentUin, false);
    }

    public final void j(boolean isDeleteAll) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isDeleteAll);
            return;
        }
        QLog.i("CardContainer.CardDataMMKVUtil", 1, "isDeleteAll " + isDeleteAll);
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putBoolean("delete_all_data_" + mCurrentUin, isDeleteAll);
    }

    public final void k(int dataID, @NotNull String itemId, boolean isAggregatedCard) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(dataID), itemId, Boolean.valueOf(isAggregatedCard));
            return;
        }
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        ArrayList<c> e16 = e();
        e16.add(new c(dataID, itemId, isAggregatedCard));
        try {
            str = new Gson().toJson(e16);
            Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(deleteDataList)");
        } catch (Exception e17) {
            QLog.e("CardContainer.CardDataMMKVUtil", 1, "saveDeleteDataToMMKV " + e17);
            str = "";
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putString("delete_data_" + mCurrentUin, str);
    }

    public final void l(int nextReqTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, nextReqTime);
            return;
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putInt(TianShuManager.KEY_VAS_NEXT_REQUEST_TIME + mCurrentUin, nextReqTime);
    }

    public final void m(@Nullable TianShuAccess.AdPlacementInfo data) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
            return;
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        String str = "container_data_" + mCurrentUin;
        if (data != null) {
            bArr = data.toByteArray();
        } else {
            bArr = null;
        }
        withAccount.putBytes(str, bArr);
    }

    public final void n(boolean show) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, show);
            return;
        }
        QLog.i("CardContainer.CardDataMMKVUtil", 1, "CardDataMMKVUtil setLocalCardContainerSwitchShowingState show:" + show);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putBoolean("setting_switch_local_data_" + str, show);
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            mCurrentUin = str;
        }
    }

    public final void p(@NotNull CardContainerSwitchState state) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.i("CardContainer.CardDataMMKVUtil", 1, "CardDataMMKVUtil setRemoteCardContainerSwitchState state:" + state);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putInt("setting_switch_remote_data_" + str, state.getValue());
    }
}
