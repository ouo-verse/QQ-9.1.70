package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014J\u0006\u0010\u001f\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/profilecard/utils/ProfileCardFeatureSwitch;", "", "()V", "Elegant_PROFILE_CARD", "", "PROFILE_BUBBLE_PAST_EDIT_INTERVAL", "PROFILE_BUBBLE_SHOW_INTERVAL", "PROFILE_BUBBLE_TIPS_LABEL_EMPTY", "PROFILE_BUBBLE_TIPS_PHOTO_EMPTY", "PROFILE_CARD_EMPTY_ITEM_FOLD_OWNER", "PROFILE_CARD_STICKY_NOTE_FIX_ADAPTER", "PROFILE_EMPTY_SIGN_VISITOR", "PROFILE_PERFECT_MAIN_TITLE", "PROFILE_PERFECT_SUB_TITLE", "PROFLIE_BUBBLE_TIPS_PHOTO_LABEL_EMPTY", "TAG", "USER_SUMMARY_MUSIC_BOX_OFFLINE", "sFeatureService", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "getOwnerProfileCardEmptyItemFoldParam", "", "getVisitorProfileCardEmptySignParam", "isElegantProfileCardEnable", "", "isEnabledWithDataSet", "name", RemoteHandleConst.PARAM_DEFAULT_VALUE, "isFeatureSwitchEnable", "isMusicBoxEmptyItemFoldEnable", "isOwnerProfileCardEmptyItemFoldEnable", "isStickyNoteFixCoverNullView", "isVisitorProfileCardEmptySignEnable", "profilecard-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileCardFeatureSwitch {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String Elegant_PROFILE_CARD = "qq_new_profile_card";

    @NotNull
    public static final ProfileCardFeatureSwitch INSTANCE;

    @NotNull
    public static final String PROFILE_BUBBLE_PAST_EDIT_INTERVAL = "edit_past_interval";

    @NotNull
    public static final String PROFILE_BUBBLE_SHOW_INTERVAL = "guide_show_interval";

    @NotNull
    public static final String PROFILE_BUBBLE_TIPS_LABEL_EMPTY = "sign_empty";

    @NotNull
    public static final String PROFILE_BUBBLE_TIPS_PHOTO_EMPTY = "photo_empty";

    @NotNull
    public static final String PROFILE_CARD_EMPTY_ITEM_FOLD_OWNER = "profile_empty_item_fold_owner";

    @NotNull
    public static final String PROFILE_CARD_STICKY_NOTE_FIX_ADAPTER = "profile_card_sticky_note_fix_adapter";

    @NotNull
    public static final String PROFILE_EMPTY_SIGN_VISITOR = "profile_empty_sign_visitor";

    @NotNull
    public static final String PROFILE_PERFECT_MAIN_TITLE = "perfect_main_title";

    @NotNull
    public static final String PROFILE_PERFECT_SUB_TITLE = "perfect_sub_title";

    @NotNull
    public static final String PROFLIE_BUBBLE_TIPS_PHOTO_LABEL_EMPTY = "photo_sign_empty";

    @NotNull
    private static final String TAG = "[ProfileCardFeatureSwitch]";

    @NotNull
    public static final String USER_SUMMARY_MUSIC_BOX_OFFLINE = "user_summary_music_box_offline";

    @Nullable
    private static IFeatureRuntimeService sFeatureService;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32912);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new ProfileCardFeatureSwitch();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            sFeatureService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
    }

    ProfileCardFeatureSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> isEnabledWithDataSet(String name, String defaultValue) {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        if (iFeatureRuntimeService != null) {
            Intrinsics.checkNotNull(iFeatureRuntimeService);
            Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService.isEnabledWithDataSet(name, defaultValue);
            if (isEnabledWithDataSet == null) {
                return new LinkedHashMap();
            }
            return isEnabledWithDataSet;
        }
        return new LinkedHashMap();
    }

    private final boolean isFeatureSwitchEnable(String name) {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        return iFeatureRuntimeService != null && iFeatureRuntimeService.isFeatureSwitchEnable(name);
    }

    @NotNull
    public final Map<String, String> getOwnerProfileCardEmptyItemFoldParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return isEnabledWithDataSet(PROFILE_CARD_EMPTY_ITEM_FOLD_OWNER, "");
    }

    @NotNull
    public final Map<String, String> getVisitorProfileCardEmptySignParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return isEnabledWithDataSet(PROFILE_EMPTY_SIGN_VISITOR, "");
    }

    public final boolean isElegantProfileCardEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getVersionCode() == 1) {
            return true;
        }
        return false;
    }

    public final boolean isMusicBoxEmptyItemFoldEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return isFeatureSwitchEnable(USER_SUMMARY_MUSIC_BOX_OFFLINE);
    }

    public final boolean isOwnerProfileCardEmptyItemFoldEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!isFeatureSwitchEnable(PROFILE_CARD_EMPTY_ITEM_FOLD_OWNER) && !isElegantProfileCardEnable()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Map<String, String> isStickyNoteFixCoverNullView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return isEnabledWithDataSet(PROFILE_CARD_STICKY_NOTE_FIX_ADAPTER, "");
    }

    public final boolean isVisitorProfileCardEmptySignEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!isFeatureSwitchEnable(PROFILE_EMPTY_SIGN_VISITOR) && !isElegantProfileCardEnable()) {
            return false;
        }
        return true;
    }

    private final boolean isFeatureSwitchEnable(String name, boolean defaultValue) {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        return iFeatureRuntimeService != null && iFeatureRuntimeService.isFeatureSwitchEnable(name, defaultValue);
    }
}
