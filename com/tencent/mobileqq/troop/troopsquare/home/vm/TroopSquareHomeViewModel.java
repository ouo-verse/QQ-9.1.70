package com.tencent.mobileqq.troop.troopsquare.home.vm;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetHomeHeadRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareBannerItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareTabItem;
import com.tencent.qqnt.kernel.nativeinterface.IGetHomeHeadCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019RA\u0010#\u001a,\u0012(\u0012&\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d \u001e*\u0012\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010\u001c0\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u001b8\u0006\u00a2\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u0019R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020+0\u001b8\u0006\u00a2\u0006\f\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b8\u0006\u00a2\u0006\f\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\"\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "", "T1", "Landroid/os/Bundle;", "i", "Landroid/os/Bundle;", "M1", "()Landroid/os/Bundle;", "bundle", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "N1", "()Ljava/lang/String;", "ext", "", BdhLogUtil.LogTag.Tag_Conn, "J", "O1", "()J", "groupCode", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetHomeHeadRsp;", "D", "Landroidx/lifecycle/MutableLiveData;", "liveDataHomeHead", "Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareBannerItem;", "kotlin.jvm.PlatformType", "E", "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "liveDataBanners", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareTabItem;", UserInfo.SEX_FEMALE, "_liveDataTabs", "G", "R1", "liveDataTabs", "", "H", "_liveDataIsSucceed", "I", "Q1", "liveDataIsSucceed", "_liveDataselectTab", "K", "S1", "liveDataselectTab", "<init>", "(Landroid/os/Bundle;)V", "L", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareHomeViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final long groupCode;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GetHomeHeadRsp> liveDataHomeHead;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ArrayList<GroupSquareBannerItem>> liveDataBanners;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GroupSquareTabItem>> _liveDataTabs;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<GroupSquareTabItem>> liveDataTabs;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _liveDataIsSucceed;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> liveDataIsSucceed;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _liveDataselectTab;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> liveDataselectTab;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy ext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopSquareHomeViewModel(@NotNull Bundle bundle) {
        Lazy lazy;
        long j3;
        LiveData<ArrayList<GroupSquareBannerItem>> c16;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.bundle = bundle;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel$ext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareHomeViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                String string = TroopSquareHomeViewModel.this.M1().getString("troop_square_ext");
                return string == null ? "" : string;
            }
        });
        this.ext = lazy;
        String string = bundle.getString("troop_uin", null);
        if (string != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.groupCode = j3;
        MutableLiveData<GetHomeHeadRsp> mutableLiveData = new MutableLiveData<>();
        this.liveDataHomeHead = mutableLiveData;
        c16 = c.c(mutableLiveData, TroopSquareHomeViewModel$liveDataBanners$1.INSTANCE);
        this.liveDataBanners = c16;
        MutableLiveData<List<GroupSquareTabItem>> mutableLiveData2 = new MutableLiveData<>();
        this._liveDataTabs = mutableLiveData2;
        this.liveDataTabs = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._liveDataIsSucceed = mutableLiveData3;
        this.liveDataIsSucceed = mutableLiveData3;
        MutableLiveData<Long> mutableLiveData4 = new MutableLiveData<>();
        this._liveDataselectTab = mutableLiveData4;
        this.liveDataselectTab = mutableLiveData4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(TroopSquareHomeViewModel this$0, int i3, String str, GetHomeHeadRsp getHomeHeadRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && getHomeHeadRsp != null) {
            this$0.liveDataHomeHead.postValue(getHomeHeadRsp);
            this$0._liveDataTabs.postValue(getHomeHeadRsp.tabs);
            this$0._liveDataIsSucceed.postValue(Boolean.TRUE);
            this$0._liveDataselectTab.postValue(Long.valueOf(getHomeHeadRsp.getSelectTab()));
            return;
        }
        QLog.e("TroopSquare.Home.TroopSquareHomeViewMode", 1, "getHomeHead failed: errCode=" + i3 + " errMsg=" + str + " result=" + getHomeHeadRsp);
        this$0._liveDataIsSucceed.postValue(Boolean.FALSE);
    }

    @NotNull
    public final Bundle M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bundle;
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (String) this.ext.getValue();
    }

    public final long O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.groupCode;
    }

    @NotNull
    public final LiveData<ArrayList<GroupSquareBannerItem>> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.liveDataBanners;
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.liveDataIsSucceed;
    }

    @NotNull
    public final LiveData<List<GroupSquareTabItem>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.liveDataTabs;
    }

    @NotNull
    public final LiveData<Long> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.liveDataselectTab;
    }

    public final void T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            if (!NetworkUtil.isNetworkAvailable()) {
                QLog.e("TroopSquare.Home.TroopSquareHomeViewMode", 1, "getHomeHead failed: network invalid");
                this._liveDataIsSucceed.postValue(Boolean.FALSE);
                return;
            }
            s i3 = bg.i(null, 1, null);
            if (i3 == null) {
                QLog.e("TroopSquare.Home.TroopSquareHomeViewMode", 1, "getHomeHead failed: service == null");
                return;
            }
            long j3 = this.groupCode;
            String ext = N1();
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            i3.h0(j3, ext, new IGetHomeHeadCallback() { // from class: com.tencent.mobileqq.troop.troopsquare.home.vm.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetHomeHeadCallback
                public final void onResult(int i16, String str, GetHomeHeadRsp getHomeHeadRsp) {
                    TroopSquareHomeViewModel.U1(TroopSquareHomeViewModel.this, i16, str, getHomeHeadRsp);
                }
            });
        } catch (Throwable th5) {
            QLog.e("TroopSquare.Home.TroopSquareHomeViewMode", 1, "getHomeHead exception: e=" + th5);
        }
    }
}
