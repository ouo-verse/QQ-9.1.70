package com.tencent.mobileqq.profilesetting;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.profilesetting.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\b,\u0010-J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J&\u0010\u001d\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001eH\u0014J\u001e\u0010$\u001a\u00020\b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000b0!j\b\u0012\u0004\u0012\u00020\u000b`\"J\u001e\u0010'\u001a\u00020\b2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020%0!j\b\u0012\u0004\u0012\u00020%`\"R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/CardSettingHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", "data", "", Constants.BASE_IN_PLUGIN_VERSION, "E2", "", "fieldID", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "body", "J2", "state", "Ltencent/im/oidb/cmd0x587/oidb_0x587$ReqBody;", "K2", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udcData", "Lcom/tencent/mobileqq/data/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "F2", Constants.MMCCID, "", "", "getCommandList", "res", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fieldIds", "H2", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "items", "I2", "Lcom/tencent/mobileqq/app/QQAppInterface;", "d", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CardSettingHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQAppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/CardSettingHandler$a;", "", "", "CMD_GET_CARD_DISPLAY_SETTING", "Ljava/lang/String;", "CMD_SET_CARD_DISPLAY_SETTING", "REQ_GET_CARD_DISPLAY_SETTING_TAG", "REQ_SET_CARD_DISPLAY_SETTING_TAG", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.profilesetting.CardSettingHandler$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardSettingHandler(@NotNull QQAppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
        }
    }

    private final void D2(ToServiceMsg req, FromServiceMsg resp, Object data) {
        boolean z16;
        Intrinsics.checkNotNull(req);
        if (!Intrinsics.areEqual(req.getAttribute("req_get_card_display_setting_tag"), Boolean.TRUE)) {
            return;
        }
        Intrinsics.checkNotNull(resp);
        if (resp.isSuccess() && data != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object attribute = req.getAttribute("uin");
        Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
        String str = (String) attribute;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(this.app.getCurrentAccountUin(), str)) {
            int resultCode = resp.getResultCode();
            Manager manager = this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
            FriendsManager friendsManager = (FriendsManager) manager;
            Card card = friendsManager.q(str);
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(data as ByteArray)");
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = mergeFrom;
                    resultCode = oidb_sso_oidbssopkg2.uint32_result.get();
                    if (oidb_sso_oidbssopkg2.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && oidb_sso_oidbssopkg2.bytes_bodybuffer.has() && oidb_sso_oidbssopkg2.bytes_bodybuffer.get() != null) {
                        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                        oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg2.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.get().size() > 0) {
                            oidb_0x5eb$UdcUinData udcData = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0);
                            Intrinsics.checkNotNullExpressionValue(udcData, "udcData");
                            Intrinsics.checkNotNullExpressionValue(card, "card");
                            F2(udcData, card);
                            Intrinsics.checkNotNullExpressionValue(udcData, "udcData");
                            G2(udcData, card);
                            friendsManager.p0(card);
                            if (QLog.isColorLevel()) {
                                QLog.d("CardSettingHandler", 2, "handleGetCardDisplaySetting size=" + card.profileDisplaySettingStates.size() + " settingStates=" + card.profileDisplaySettingStates);
                            }
                        }
                    }
                } catch (Exception e16) {
                    QLog.d("CardSettingHandler", 1, "handleGetCardDisplaySetting ex", e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("CardSettingHandler", 2, "handleGetCardDisplaySetting success=" + z16 + ", uin=" + str + ", resultCode=" + resultCode);
            }
            notifyUI(1, z16, new Object[]{str, card});
        }
    }

    private final void E2(ToServiceMsg req, FromServiceMsg resp, Object data) {
        boolean z16;
        Intrinsics.checkNotNull(req);
        if (!Intrinsics.areEqual(req.getAttribute("req_set_card_display_setting_tag"), Boolean.TRUE)) {
            return;
        }
        Intrinsics.checkNotNull(resp);
        if (resp.isSuccess() && data != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object attribute = req.getAttribute("uin");
        Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
        String str = (String) attribute;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(this.app.getCurrentAccountUin(), str)) {
            int resultCode = resp.getResultCode();
            Manager manager = this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
            FriendsManager friendsManager = (FriendsManager) manager;
            Card card = friendsManager.q(str);
            Object attribute2 = req.getAttribute("req_items");
            Intrinsics.checkNotNull(attribute2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.profilesetting.ReqSetSettingItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.profilesetting.ReqSetSettingItem> }");
            ArrayList arrayList = (ArrayList) attribute2;
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(data as ByteArray)");
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = mergeFrom;
                    resultCode = oidb_sso_oidbssopkg2.uint32_result.get();
                    if (oidb_sso_oidbssopkg2.uint32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ReqSetSettingItem reqSetSettingItem = (ReqSetSettingItem) it.next();
                            w.Companion companion = w.INSTANCE;
                            int a16 = reqSetSettingItem.a();
                            int c16 = reqSetSettingItem.c();
                            Intrinsics.checkNotNullExpressionValue(card, "card");
                            companion.q(a16, c16, card, this.app);
                        }
                        friendsManager.p0(card);
                    }
                } catch (Exception e16) {
                    QLog.d("CardSettingHandler", 1, "handleSetCardDisplaySetting ex", e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("CardSettingHandler", 2, "handleSetCardDisplaySetting success=" + z16 + ", uin=" + str + ", resultCode=" + resultCode + " reqItems=" + arrayList + " settingStates=" + card.profileDisplaySettingStates);
            }
            notifyUI(2, z16, new Object[]{str, card, arrayList});
        }
    }

    private final void F2(oidb_0x5eb$UdcUinData udcData, Card card) {
        if (udcData.uint32_profile_sex_visible.has()) {
            w.INSTANCE.q(41611, udcData.uint32_profile_sex_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_age_visible.has()) {
            w.INSTANCE.q(41610, udcData.uint32_profile_age_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_birthday_visible.has()) {
            w.INSTANCE.q(41607, udcData.uint32_profile_birthday_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_constellation_visible.has()) {
            w.INSTANCE.q(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION, udcData.uint32_profile_constellation_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_profession_visible.has()) {
            w.INSTANCE.q(41618, udcData.uint32_profile_profession_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_college_visible.has()) {
            w.INSTANCE.q(41619, udcData.uint32_profile_college_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_location_visible.has()) {
            w.INSTANCE.q(41614, udcData.uint32_profile_location_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_hometown_visible.has()) {
            w.INSTANCE.q(41613, udcData.uint32_profile_hometown_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_email_visible.has()) {
            w.INSTANCE.q(41622, udcData.uint32_profile_email_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_personal_note_visible.has()) {
            w.INSTANCE.q(41623, udcData.uint32_profile_personal_note_visible.get(), card, this.app);
        }
        if (udcData.uint32_profile_company_visible.has()) {
            w.INSTANCE.q(40272, udcData.uint32_profile_company_visible.get(), card, this.app);
        }
    }

    private final void G2(oidb_0x5eb$UdcUinData udcData, Card card) {
        if (udcData.uint32_req_medalwall_flag.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MEDAL_WALL, udcData.uint32_req_medalwall_flag.get(), card, this.app);
        }
        if (udcData.uint32_profile_personality_label_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH, udcData.uint32_profile_personality_label_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_life_achievement_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH, udcData.uint32_profile_life_achievement_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_interest_switch.has()) {
            w.INSTANCE.q(40313, udcData.uint32_profile_interest_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_music_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MUSIC_SWITCH, udcData.uint32_profile_music_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_present_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_PRESENT_SWITCH, udcData.uint32_profile_present_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_miniapp_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MINIAPP_SWITCH, udcData.uint32_profile_miniapp_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_musicbox_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MUSICBOX_SWITCH, udcData.uint32_profile_musicbox_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_sticky_note_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_STICKY_NOTE_SWITCH, udcData.uint32_profile_sticky_note_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_sticky_note_offline.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_STICKY_NOTE_OFFLINE, udcData.uint32_profile_sticky_note_offline.get(), card, this.app);
        }
        if (udcData.uint32_profile_qqcircle_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_QQCIRCLE_SWITCH, udcData.uint32_profile_qqcircle_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_weishi_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_WEISHI_SWITCH, udcData.uint32_profile_weishi_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_privilege.has()) {
            w.INSTANCE.q(45160, udcData.uint32_profile_privilege.get(), card, this.app);
        }
        if (udcData.uint32_profile_membership_and_rank.has()) {
            w.INSTANCE.q(45161, udcData.uint32_profile_membership_and_rank.get(), card, this.app);
        }
        if (udcData.uint32_profile_anonymous_answer_switch.has()) {
            w.INSTANCE.q(42425, udcData.uint32_profile_anonymous_answer_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_show_idol_switch.has()) {
            w.INSTANCE.q(42488, udcData.uint32_profile_show_idol_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_dressup_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_DRESSUP_SWITCH, udcData.uint32_profile_dressup_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_qqcard_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_QQCARD_SWITCH, udcData.uint32_profile_qqcard_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_q_cub_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_Q_CUB_SWITCH, udcData.uint32_profile_q_cub_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_music_data_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_MUSIC_DATA_SWITCH, udcData.uint32_profile_music_data_switch.get(), card, this.app);
        }
        if (udcData.uint32_profile_meta_farm_switch.has()) {
            w.INSTANCE.q(ProfileContants.FIELD_META_FARM_SWITCH, udcData.uint32_profile_meta_farm_switch.get(), card, this.app);
        }
    }

    private final void J2(int fieldID, oidb_0x5eb$ReqBody body) {
        switch (fieldID) {
            case 40272:
                body.uint32_profile_company_visible.set(1);
                return;
            case 40313:
                body.uint32_profile_interest_switch.set(1);
                return;
            case ProfileContants.FIELD_MUSIC_SWITCH /* 40314 */:
                body.uint32_profile_music_switch.set(1);
                return;
            case 41607:
                body.uint32_profile_birthday_visible.set(1);
                return;
            case IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION /* 41609 */:
                body.uint32_profile_constellation_visible.set(1);
                return;
            case 41610:
                body.uint32_profile_age_visible.set(1);
                return;
            case 41611:
                body.uint32_profile_sex_visible.set(1);
                return;
            case 41613:
                body.uint32_profile_hometown_visible.set(1);
                return;
            case 41614:
                body.uint32_profile_location_visible.set(1);
                return;
            case 41618:
                body.uint32_profile_profession_visible.set(1);
                return;
            case 41619:
                body.uint32_profile_college_visible.set(1);
                return;
            case 41622:
                body.uint32_profile_email_visible.set(1);
                return;
            case 41623:
                body.uint32_profile_personal_note_visible.set(1);
                return;
            case ProfileContants.FIELD_MEDAL_WALL /* 42075 */:
                body.uint32_req_medalwall_flag.set(1);
                return;
            case ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH /* 42128 */:
                body.uint32_profile_personality_label_switch.set(1);
                return;
            case ProfileContants.FIELD_EXTEND_FRIEND_SWITCH /* 42172 */:
                body.uint32_extend_friend_card_shown.set(1);
                return;
            case ProfileContants.FIELD_PRESENT_SWITCH /* 42289 */:
                body.uint32_profile_present_switch.set(1);
                return;
            case ProfileContants.FIELD_MINIAPP_SWITCH /* 42323 */:
                body.uint32_profile_miniapp_switch.set(1);
                return;
            case ProfileContants.FIELD_MUSICBOX_SWITCH /* 42340 */:
                body.uint32_profile_musicbox_switch.set(1);
                return;
            case ProfileContants.FIELD_STICKY_NOTE_SWITCH /* 42356 */:
                body.uint32_profile_sticky_note_switch.set(1);
                return;
            case ProfileContants.FIELD_QQCIRCLE_SWITCH /* 42361 */:
                body.uint32_profile_qqcircle_switch.set(1);
                return;
            case ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH /* 42367 */:
                body.uint32_flag_profile_life_achievement_switch.set(1);
                return;
            case ProfileContants.FIELD_WEISHI_SWITCH /* 42377 */:
                body.uint32_flag_profile_weishi_switch.set(1);
                return;
            case 42425:
                body.uint32_profile_anonymous_answer_switch.set(1);
                return;
            case 42488:
                body.uint32_profile_show_idol_switch.set(1);
                return;
            case 45160:
                body.uint32_profile_privilege.set(1);
                return;
            case 45161:
                body.uint32_profile_membership_and_rank.set(1);
                return;
            case ProfileContants.FIELD_STICKY_NOTE_OFFLINE /* 45168 */:
                body.uint32_profile_sticky_note_offline.set(1);
                return;
            case ProfileContants.FIELD_DRESSUP_SWITCH /* 47177 */:
                body.uint32_profile_dressup_switch.set(1);
                return;
            case ProfileContants.FIELD_QQCARD_SWITCH /* 47180 */:
                body.uint32_profile_qqcard_switch.set(1);
                return;
            case ProfileContants.FIELD_Q_CUB_SWITCH /* 47184 */:
                body.uint32_profile_q_cub_switch.set(1);
                return;
            case ProfileContants.FIELD_MUSIC_DATA_SWITCH /* 47187 */:
                body.uint32_profile_music_data_switch.set(1);
                return;
            case ProfileContants.FIELD_META_FARM_SWITCH /* 47201 */:
                body.uint32_profile_meta_farm_switch.set(1);
                return;
            case ProfileContants.FIELD_HAOMA_NAMEPLATE /* 47218 */:
                body.uint32_haoma_nameplate.set(1);
                return;
            default:
                return;
        }
    }

    private final void K2(int fieldID, int state, oidb_0x587$ReqBody body) {
        switch (fieldID) {
            case 40272:
                body.uint32_profile_company_visible.set(state);
                return;
            case 40313:
                body.uint32_profile_interest_switch.set(state);
                return;
            case ProfileContants.FIELD_MUSIC_SWITCH /* 40314 */:
                body.uint32_profile_music_switch.set(state);
                return;
            case 41607:
                body.uint32_profile_birthday_visible.set(state);
                return;
            case IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION /* 41609 */:
                body.uint32_profile_constellation_visible.set(state);
                return;
            case 41610:
                body.uint32_profile_age_visible.set(state);
                return;
            case 41611:
                body.uint32_profile_sex_visible.set(state);
                return;
            case 41613:
                body.uint32_profile_hometown_visible.set(state);
                return;
            case 41614:
                body.uint32_profile_location_visible.set(state);
                return;
            case 41618:
                body.uint32_profile_profession_visible.set(state);
                return;
            case 41619:
                body.uint32_profile_college_visible.set(state);
                return;
            case 41622:
                body.uint32_profile_email_visible.set(state);
                return;
            case 41623:
                body.uint32_profile_personal_note_visible.set(state);
                return;
            case ProfileContants.FIELD_MEDAL_WALL /* 42075 */:
                body.uint32_req_medalwall_flag.set(state);
                return;
            case ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH /* 42128 */:
                body.uint32_profile_personality_label_switch.set(state);
                return;
            case ProfileContants.FIELD_EXTEND_FRIEND_SWITCH /* 42172 */:
                body.uint32_extend_friend_card_shown.set(state);
                return;
            case ProfileContants.FIELD_PRESENT_SWITCH /* 42289 */:
                body.uint32_profile_present_switch.set(state);
                return;
            case ProfileContants.FIELD_MINIAPP_SWITCH /* 42323 */:
                body.uint32_profile_miniapp_switch.set(state);
                return;
            case ProfileContants.FIELD_MUSICBOX_SWITCH /* 42340 */:
                body.uint32_profile_musicbox_switch.set(state);
                return;
            case ProfileContants.FIELD_STICKY_NOTE_SWITCH /* 42356 */:
                body.uint32_profile_sticky_note_switch.set(state);
                return;
            case ProfileContants.FIELD_QQCIRCLE_SWITCH /* 42361 */:
                body.uint32_profile_qqcircle_switch.set(state);
                return;
            case ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH /* 42367 */:
                body.uint32_flag_profile_life_achievement_switch.set(state);
                return;
            case ProfileContants.FIELD_WEISHI_SWITCH /* 42377 */:
                body.uint32_flag_profile_weishi_switch.set(state);
                return;
            case 42425:
                body.uint32_profile_anonymous_answer_switch.set(state);
                return;
            case 42488:
                body.uint32_profile_show_idol_switch.set(state);
                return;
            case 45160:
                body.uint32_profile_privilege.set(state);
                return;
            case 45161:
                body.uint32_profile_membership_and_rank.set(state);
                return;
            case ProfileContants.FIELD_DRESSUP_SWITCH /* 47177 */:
                body.uint32_profile_dressup_switch.set(state);
                return;
            case ProfileContants.FIELD_QQCARD_SWITCH /* 47180 */:
                body.uint32_profile_qqcard_switch.set(state);
                return;
            case ProfileContants.FIELD_Q_CUB_SWITCH /* 47184 */:
                body.uint32_profile_q_cub_switch.set(state + 1);
                return;
            case ProfileContants.FIELD_MUSIC_DATA_SWITCH /* 47187 */:
                body.uint32_profile_music_data_switch.set(state);
                return;
            case ProfileContants.FIELD_META_FARM_SWITCH /* 47201 */:
                body.uint32_profile_meta_farm_switch.set(state);
                return;
            default:
                return;
        }
    }

    public final void H2(@NotNull ArrayList<Integer> fieldIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fieldIds);
            return;
        }
        Intrinsics.checkNotNullParameter(fieldIds, "fieldIds");
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.i("CardSettingHandler", 2, "reqGetCardDisplaySetting uin=" + currentAccountUin + ", size=" + fieldIds.size() + ", fieldIds=" + fieldIds);
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(currentAccountUin)));
            Iterator<Integer> it = fieldIds.iterator();
            while (it.hasNext()) {
                Integer fieldId = it.next();
                Intrinsics.checkNotNullExpressionValue(fieldId, "fieldId");
                J2(fieldId.intValue(), oidb_0x5eb_reqbody);
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("uin", currentAccountUin);
            makeOIDBPkg.addAttribute("req_get_card_display_setting_tag", Boolean.TRUE);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("CardSettingHandler", 1, "reqGetCardDisplaySetting error:", e16);
        }
    }

    public final void I2(@NotNull ArrayList<ReqSetSettingItem> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.i("CardSettingHandler", 2, "reqSetCardDisplaySetting uin=" + currentAccountUin + ", size=" + items.size() + ", fieldIds=" + items);
        }
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        try {
            oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(currentAccountUin)));
            Iterator<ReqSetSettingItem> it = items.iterator();
            while (it.hasNext()) {
                ReqSetSettingItem next = it.next();
                K2(next.a(), next.c(), oidb_0x587_reqbody);
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x587_74", 1415, 74, oidb_0x587_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("uin", currentAccountUin);
            makeOIDBPkg.addAttribute("req_set_card_display_setting_tag", Boolean.TRUE);
            makeOIDBPkg.addAttribute("req_items", items);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("CardSettingHandler", 1, "reqSetCardDisplaySetting error:", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x5eb_22");
            this.allowCmdSet.add("OidbSvc.0x587_74");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, req, res, data);
            return;
        }
        if (res != null) {
            str = res.getServiceCmd();
        } else {
            str = null;
        }
        if (msgCmdFilter(str)) {
            return;
        }
        if (Intrinsics.areEqual(str, "OidbSvc.0x5eb_22")) {
            D2(req, res, data);
        } else if (Intrinsics.areEqual(str, "OidbSvc.0x587_74")) {
            E2(req, res, data);
        }
    }
}
