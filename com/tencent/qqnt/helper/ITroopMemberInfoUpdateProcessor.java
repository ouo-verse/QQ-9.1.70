package com.tencent.qqnt.helper;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.state.data.SquareJSConst;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor;", "", "", "groupCode", "", "f", "", "a", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "d", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor$Strategy;", "b", "fromNet", SquareJSConst.Params.PARAMS_UIN_LIST, "e", "c", "uin", "g", "Strategy", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ITroopMemberInfoUpdateProcessor {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor$Strategy;", "", "(Ljava/lang/String;I)V", "NONE", "NET", QZoneAppCtrlUploadFileLogic.DB_PATH, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class Strategy {
        private static final /* synthetic */ Strategy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Strategy DB;
        public static final Strategy NET;
        public static final Strategy NONE;

        private static final /* synthetic */ Strategy[] $values() {
            return new Strategy[]{NONE, NET, DB};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62133);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NONE = new Strategy("NONE", 0);
            NET = new Strategy("NET", 1);
            DB = new Strategy(QZoneAppCtrlUploadFileLogic.DB_PATH, 2);
            $VALUES = $values();
        }

        Strategy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Strategy valueOf(String str) {
            return (Strategy) Enum.valueOf(Strategy.class, str);
        }

        public static Strategy[] values() {
            return (Strategy[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static void a(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        }

        @NotNull
        public static Strategy b(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            return Strategy.NONE;
        }

        public static boolean c(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            return false;
        }

        public static boolean d(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            return false;
        }

        public static void e(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode, boolean z16, boolean z17, @NotNull List<String> uinList) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            Intrinsics.checkNotNullParameter(uinList, "uinList");
        }

        public static void f(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode, boolean z16, @NotNull List<? extends TroopMemberInfo> troopMemberList) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        }

        public static void g(@NotNull ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor, @NotNull String groupCode, boolean z16, @Nullable String str) {
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        }
    }

    boolean a(@NotNull String groupCode);

    @NotNull
    Strategy b(@NotNull String groupCode);

    boolean c(@NotNull String groupCode);

    void d(@NotNull String groupCode, boolean isSuccess, @NotNull List<? extends TroopMemberInfo> troopMemberList);

    void e(@NotNull String groupCode, boolean fromNet, boolean isSuccess, @NotNull List<String> uinList);

    void f(@NotNull String groupCode);

    void g(@NotNull String groupCode, boolean isSuccess, @Nullable String uin);
}
