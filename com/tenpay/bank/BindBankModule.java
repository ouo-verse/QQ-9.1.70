package com.tenpay.bank;

import android.content.Context;
import android.content.Intent;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tenpay.sdk.activity.BindBankActivity;
import com.tenpay.sdk.activity.TenpayUtilActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J0\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0004J&\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/bank/BindBankModule;", "", "()V", "quickBindBankSwitch", "", "scene", "", "startVerify", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "fragment", "Lcom/tenpay/sdk/activity/TenpayUtilActivity;", "startVerifyForResult", "requestCode", "startWithSwitch", "startWithSwitchForResult", "forceMainProcess", "QuickBindCardConfig", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankModule {

    @NotNull
    public static final BindBankModule INSTANCE = new BindBankModule();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/bank/BindBankModule$QuickBindCardConfig;", "", "whiteSceneList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getWhiteSceneList", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class QuickBindCardConfig {

        @SerializedName("white_bind_scene_list")
        @NotNull
        private final ArrayList<Integer> whiteSceneList;

        public QuickBindCardConfig() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ QuickBindCardConfig copy$default(QuickBindCardConfig quickBindCardConfig, ArrayList arrayList, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                arrayList = quickBindCardConfig.whiteSceneList;
            }
            return quickBindCardConfig.copy(arrayList);
        }

        @NotNull
        public final ArrayList<Integer> component1() {
            return this.whiteSceneList;
        }

        @NotNull
        public final QuickBindCardConfig copy(@NotNull ArrayList<Integer> whiteSceneList) {
            Intrinsics.checkNotNullParameter(whiteSceneList, "whiteSceneList");
            return new QuickBindCardConfig(whiteSceneList);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof QuickBindCardConfig) && Intrinsics.areEqual(this.whiteSceneList, ((QuickBindCardConfig) other).whiteSceneList)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ArrayList<Integer> getWhiteSceneList() {
            return this.whiteSceneList;
        }

        public int hashCode() {
            return this.whiteSceneList.hashCode();
        }

        @NotNull
        public String toString() {
            return "QuickBindCardConfig(whiteSceneList=" + this.whiteSceneList + ")";
        }

        public QuickBindCardConfig(@NotNull ArrayList<Integer> whiteSceneList) {
            Intrinsics.checkNotNullParameter(whiteSceneList, "whiteSceneList");
            this.whiteSceneList = whiteSceneList;
        }

        public /* synthetic */ QuickBindCardConfig(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : arrayList);
        }
    }

    BindBankModule() {
    }

    private final boolean quickBindBankSwitch(int scene) {
        if (!((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_QUICK_BIND_CARD_SWITCH, false)) {
            return false;
        }
        return ((QuickBindCardConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_QUICK_BIND_CARD_SWITCH, new QuickBindCardConfig(null, 1, 0 == true ? 1 : 0))).getWhiteSceneList().contains(Integer.valueOf(scene));
    }

    public static /* synthetic */ void startWithSwitchForResult$default(BindBankModule bindBankModule, Context context, Intent intent, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            z16 = false;
        }
        bindBankModule.startWithSwitchForResult(context, intent, i3, i16, z16);
    }

    public final void startVerify(@Nullable Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.mobileqq.base.c.f(context, intent, BindBankActivity.class, false, 8, null);
    }

    public final void startVerifyForResult(@NotNull TenpayUtilActivity fragment, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        fragment.launchFragmentForResult(intent, BindBankActivity.class, requestCode);
    }

    public final void startWithSwitch(@Nullable Context context, @NotNull Intent intent, int scene) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE, scene);
        com.tencent.mobileqq.base.c.f(context, intent, quickBindBankSwitch(scene) ? BindBankEntryFragment.class : BindBankActivity.class, false, 8, null);
    }

    public final void startWithSwitchForResult(@NotNull Context context, @NotNull Intent intent, int requestCode, int scene, boolean forceMainProcess) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE, scene);
        com.tencent.mobileqq.base.c.h(context, intent, quickBindBankSwitch(scene) ? BindBankEntryFragment.class : BindBankActivity.class, requestCode, forceMainProcess);
    }

    public final void startVerify(@NotNull TenpayUtilActivity fragment, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        fragment.launchFragment(intent, BindBankActivity.class);
    }

    public final void startWithSwitch(@NotNull TenpayUtilActivity fragment, @NotNull Intent intent, int scene) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE, scene);
        fragment.launchFragment(intent, quickBindBankSwitch(scene) ? BindBankEntryFragment.class : BindBankActivity.class);
    }

    public final void startWithSwitchForResult(@NotNull TenpayUtilActivity fragment, @NotNull Intent intent, int requestCode, int scene) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE, scene);
        fragment.launchFragmentForResult(intent, quickBindBankSwitch(scene) ? BindBankEntryFragment.class : BindBankActivity.class, requestCode);
    }
}
