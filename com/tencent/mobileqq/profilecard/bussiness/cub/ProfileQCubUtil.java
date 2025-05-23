package com.tencent.mobileqq.profilecard.bussiness.cub;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0012\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubUtil;", "", "()V", "ALL_LOOK_AB_TEST_B", "", "ALL_LOOK_AB_TEST_KEY", "CAN_LAN_KEY", "isOpenExp", "", "()Z", "isOpenExp$delegate", "Lkotlin/Lazy;", "isOpenGuestAllLookTest", "isShowProfileQCubExp", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileQCubUtil {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String ALL_LOOK_AB_TEST_B = "exp_qbox_profile_switch_B";

    @NotNull
    private static final String ALL_LOOK_AB_TEST_KEY = "exp_qbox_profile_switch";

    @NotNull
    private static final String CAN_LAN_KEY = "profilecard_q_cub_switch";

    @NotNull
    public static final ProfileQCubUtil INSTANCE;

    /* renamed from: isOpenExp$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isOpenExp;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new ProfileQCubUtil();
        lazy = LazyKt__LazyJVMKt.lazy(ProfileQCubUtil$isOpenExp$2.INSTANCE);
        isOpenExp = lazy;
    }

    ProfileQCubUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean isOpenExp() {
        return ((Boolean) isOpenExp.getValue()).booleanValue();
    }

    public static /* synthetic */ boolean isShowProfileQCubExp$default(ProfileQCubUtil profileQCubUtil, Card card, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            card = null;
        }
        return profileQCubUtil.isShowProfileQCubExp(card);
    }

    public final boolean isOpenGuestAllLookTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ALL_LOOK_AB_TEST_KEY);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(ALL_LOOK_AB_TEST_KEY)");
        return TextUtils.equals(expEntity.getAssignment(), ALL_LOOK_AB_TEST_B);
    }

    public final boolean isShowProfileQCubExp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? isOpenExp() : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
    }

    public final boolean isShowProfileQCubExp(@Nullable Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (!isShowProfileQCubExp() || card == null || card.qqCubIsBlack) ? false : true : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) card)).booleanValue();
    }
}
