package com.tencent.qqnt.troop.filter;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/troop/filter/a;", "", "", IProfileProtocolConst.PARAM_TROOP_CODE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "e", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "originTroopInfo", "b", "c", "a", "info", "", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/troop/filter/a$a;", "", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troop.filter.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f362706a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63160);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f362706a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class b {
        public static void a(@NotNull a aVar, @NotNull TroopInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static int b(@NotNull a aVar) {
            AppInterface e16 = bg.e();
            if (e16 != null) {
                return e16.getAppid();
            }
            return AppSetting.f();
        }

        @NotNull
        public static TroopInfo c(@NotNull a aVar, long j3, @NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo troopInfo) {
            Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
            if (bg.f302144a.b(j3, detailInfo)) {
                if (troopInfo == null) {
                    return new TroopInfo(j3);
                }
                return troopInfo;
            }
            return aVar.a(detailInfo, troopInfo);
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
        
            r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static TroopInfo d(@NotNull a aVar, @Nullable String str, @NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo troopInfo) {
            long j3;
            Long longOrNull;
            Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
            if (str != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            return aVar.c(j3, detailInfo, troopInfo);
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(63162), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f362706a;
        }
    }

    @NotNull
    TroopInfo a(@NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo);

    @NotNull
    TroopInfo b(@Nullable String troopUin, @NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo);

    @NotNull
    TroopInfo c(long troopUin, @NotNull GroupDetailInfo detailInfo, @Nullable TroopInfo originTroopInfo);

    void d(@NotNull TroopInfo info);

    @NotNull
    GroupDetailInfoReq e(long troopCode);
}
