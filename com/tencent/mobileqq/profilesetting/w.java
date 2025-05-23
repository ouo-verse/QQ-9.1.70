package com.tencent.mobileqq.profilesetting;

import QQService.EVIPSPEC;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmConstants;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.profilecard.bussiness.cub.ProfileQCubUtil;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import cooperation.qzone.api.QZoneApiProxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/w;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J:\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J0\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J \u0010\u0011\u001a\u00020\u00102\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002JJ\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002JJ\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002JJ\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u001c\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002J8\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u001e\u0010\u001b\u001a\u00020\u001a2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u001e\u0010\u001c\u001a\u00020\u001a2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0010JG\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00102\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 2\b\u0010\"\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004J \u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010)\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u00102\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/w$a;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/data/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/profilecard/base/config/ProfileConfig;", "configHelper", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilesetting/u;", "Lkotlin/collections/ArrayList;", "outItems", "", "d", "items", "a", "", "b", "e", "f", "g", "displayItem", "p", "k", "i", "settingItems", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "fieldId", "o", "type", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "cache", tl.h.F, "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/profilecard/base/config/ProfileConfig;Lcom/tencent/mobileqq/data/Card;I[Ljava/lang/Object;Lcom/tencent/mobileqq/profilesetting/u;)Lcom/tencent/mobileqq/profilesetting/u;", DomainData.DOMAIN_NAME, "fieldID", "j", "toState", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.profilesetting.w$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) defaultConstructorMarker);
        }

        private final ArrayList<u> a(ArrayList<u> items) {
            int size = items.size();
            if (size == 1) {
                items.get(0).n(0);
            } else if (size > 1) {
                int b16 = b(items);
                int i3 = size - 1;
                if (b16 == i3) {
                    items.get(b16).n(0);
                } else {
                    items.get(b16).n(1);
                    items.get(i3).n(3);
                    for (int i16 = b16 + 1; i16 < i3; i16++) {
                        items.get(i16).n(2);
                    }
                }
            }
            return items;
        }

        private final int b(ArrayList<u> items) {
            int size = items.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (items.get(i3).l()) {
                    return i3;
                }
            }
            return 0;
        }

        private final void d(QQAppInterface app, Card card, ProfileConfig configHelper, ArrayList<u> outItems) {
            ArrayList arrayList = new ArrayList();
            ArrayList<u> arrayList2 = new ArrayList<>();
            arrayList.add(new u(5, R.string.f175542yu));
            arrayList2.addAll(e(app, card, configHelper, outItems));
            arrayList2.addAll(f(app, card, configHelper, outItems));
            arrayList.addAll(a(arrayList2));
            arrayList.add(new u(5, R.string.f175612z1));
            arrayList.addAll(a(g(app, card, configHelper, outItems)));
            outItems.clear();
            outItems.addAll(arrayList);
            arrayList.clear();
            arrayList2.clear();
        }

        private final ArrayList<u> e(QQAppInterface app, Card card, ProfileConfig configHelper, ArrayList<u> outItems) {
            ArrayList<u> arrayList = new ArrayList<>();
            for (Integer[] numArr : v.INSTANCE.a()) {
                u h16 = h(app, configHelper, card, 1, numArr, c(numArr[0].intValue(), outItems));
                if (h16 != null) {
                    int c16 = h16.c();
                    if (c16 != 41611) {
                        if (c16 != 41618) {
                            if (c16 != 41623) {
                                h16.n(2);
                            } else {
                                h16.n(3);
                            }
                        } else {
                            h16.p(((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(card.iProfession));
                        }
                    } else {
                        h16.n(1);
                    }
                    arrayList.add(h16);
                }
            }
            return arrayList;
        }

        private final ArrayList<u> f(QQAppInterface app, Card card, ProfileConfig configHelper, ArrayList<u> outItems) {
            ArrayList<u> arrayList = new ArrayList<>();
            for (Integer[] numArr : v.INSTANCE.c()) {
                u c16 = c(numArr[0].intValue(), outItems);
                if (47187 == numArr[0].intValue()) {
                    c16 = h(app, configHelper, card, 6, numArr, c16);
                }
                if (c16 == null) {
                    c16 = new u(6, numArr[0].intValue(), 2, numArr[1].intValue());
                    c16.n(2);
                }
                if (numArr[0].intValue() == 47196) {
                    c16.p(((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.PROFILE_GAMEINFO_CARD_SETTING_SWITCH, true));
                }
                arrayList.add(c16);
            }
            return arrayList;
        }

        private final ArrayList<u> g(QQAppInterface app, Card card, ProfileConfig configHelper, ArrayList<u> outItems) {
            ArrayList<u> arrayList = new ArrayList<>();
            for (Integer[] numArr : v.INSTANCE.d()) {
                u h16 = h(app, configHelper, card, 2, numArr, c(numArr[0].intValue(), outItems));
                if (h16 != null) {
                    int c16 = h16.c();
                    if (c16 != 42128) {
                        if (c16 != 42377) {
                            h16.n(2);
                        } else {
                            h16.n(3);
                        }
                    } else {
                        h16.n(1);
                    }
                    if (numArr[0].intValue() == 42172) {
                        arrayList.add(new u(4));
                        h16.n(3);
                    }
                    w.INSTANCE.p(h16, card);
                    arrayList.add(h16);
                }
            }
            return arrayList;
        }

        private final void k(u displayItem) {
            Integer num;
            JSONObject jSONObject;
            int i3;
            boolean z16;
            if (displayItem != null) {
                num = Integer.valueOf(displayItem.c());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 47180) {
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("vas_profile_qqcard", false)) {
                    displayItem.p(false);
                    return;
                }
                try {
                    byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("vas_profile_qqcard", new byte[0]);
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    String str = new String(loadRawConfig, UTF_8);
                    int length = str.length() - 1;
                    int i16 = 0;
                    boolean z17 = false;
                    while (i16 <= length) {
                        if (!z17) {
                            i3 = i16;
                        } else {
                            i3 = length;
                        }
                        if (Intrinsics.compare((int) str.charAt(i3), 32) <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z17) {
                            if (!z16) {
                                z17 = true;
                            } else {
                                i16++;
                            }
                        } else if (!z16) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    jSONObject = new JSONObject(str.subSequence(i16, length + 1).toString());
                } catch (JSONException unused) {
                    jSONObject = new JSONObject();
                }
                String replaceTitle = jSONObject.optString("self_main_title", HardCodeUtil.qqStr(R.string.f1761030c));
                if (!TextUtils.isEmpty(replaceTitle)) {
                    Intrinsics.checkNotNullExpressionValue(replaceTitle, "replaceTitle");
                    displayItem.q(replaceTitle);
                }
            }
        }

        private final void p(u displayItem, Card card) {
            ProfilePersonalityLabelInfo profilePersonalityLabelInfo;
            Integer num;
            String str;
            Integer num2;
            boolean z16;
            Integer num3 = null;
            if (card != null) {
                profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) card.getBusinessInfo(ProfilePersonalityLabelInfo.class);
            } else {
                profilePersonalityLabelInfo = null;
            }
            ProfileCardFeatureSwitch profileCardFeatureSwitch = ProfileCardFeatureSwitch.INSTANCE;
            boolean z17 = false;
            if (profileCardFeatureSwitch.isOwnerProfileCardEmptyItemFoldEnable() && profilePersonalityLabelInfo != null) {
                if (displayItem != null) {
                    num2 = Integer.valueOf(displayItem.c());
                } else {
                    num2 = null;
                }
                if (num2 != null && num2.intValue() == 42128) {
                    if (profilePersonalityLabelInfo.getSize() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    displayItem.p(z16);
                }
            }
            if (profileCardFeatureSwitch.isMusicBoxEmptyItemFoldEnable()) {
                if (displayItem != null) {
                    num = Integer.valueOf(displayItem.c());
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == 42340) {
                    if (card != null) {
                        str = card.songId;
                    } else {
                        str = null;
                    }
                    displayItem.p(!TextUtils.isEmpty(str));
                }
            }
            k(displayItem);
            if (card != null) {
                if (displayItem != null) {
                    num3 = Integer.valueOf(displayItem.c());
                }
                if (num3 != null && num3.intValue() == 42356) {
                    if (card.offlineStickyNote != 1) {
                        z17 = true;
                    }
                    displayItem.p(z17);
                }
            }
        }

        @Nullable
        public final u c(int fieldId, @NotNull ArrayList<u> settingItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (u) iPatchRedirector.redirect((short) 10, (Object) this, fieldId, (Object) settingItems);
            }
            Intrinsics.checkNotNullParameter(settingItems, "settingItems");
            Iterator<u> it = settingItems.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.c() == fieldId) {
                    return next;
                }
            }
            return null;
        }

        @Nullable
        public final u h(@NotNull QQAppInterface app, @Nullable ProfileConfig configHelper, @NotNull Card card, int type, @NotNull Object[] item, @Nullable u cache) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (u) iPatchRedirector.redirect((short) 6, this, app, configHelper, card, Integer.valueOf(type), item, cache);
            }
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.length <= 1 || configHelper == null) {
                return null;
            }
            Object obj = item[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = item[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) obj2).intValue();
            Integer config = v.INSTANCE.b().get(intValue, -1);
            if (config == null || config.intValue() != -1) {
                Intrinsics.checkNotNullExpressionValue(config, "config");
                if (!configHelper.isSwitchEnable(config.intValue())) {
                    return null;
                }
            }
            if (intValue == 42356 && !QZoneApiProxy.isRightAndroidVersionForStickyNote()) {
                return null;
            }
            if (intValue == 42361 && !uq3.c.A6(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())) {
                return null;
            }
            if (intValue == 42172 && (card.extendFriendEntryAddFriend != 1 || !((IExpandManagerProxy) QRoute.api(IExpandManagerProxy.class)).isResourceReady(app))) {
                return null;
            }
            if (intValue == 47184 && !ProfileQCubUtil.INSTANCE.isShowProfileQCubExp(card)) {
                return null;
            }
            if (intValue == 42075 && ea.x0(app.getApplication(), app.getCurrentAccountUin()) != 1) {
                return null;
            }
            if (intValue == 42488 && !com.tencent.mobileqq.troop.utils.b.b()) {
                return null;
            }
            if (StudyModeManager.t() && intValue == 47196) {
                return null;
            }
            if (intValue == 45161 && !n(card)) {
                return null;
            }
            if (intValue == 45160 && !ProfileCardFeatureSwitch.INSTANCE.isElegantProfileCardEnable()) {
                return null;
            }
            if (intValue == 47201 && (StudyModeManager.t() || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MetaFarmConstants.SWITCH_CONFIG_ID, false) || !((IMetaFarmProfileApi) QRoute.api(IMetaFarmProfileApi.class)).isMetaFarmUser())) {
                return null;
            }
            if (cache != null) {
                z16 = true;
            }
            if (z16) {
                cache.o(j(intValue, card, app));
                return cache;
            }
            if (!z16) {
                return new u(type, intValue, j(intValue, card, app), intValue2);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final void i(@NotNull QQAppInterface app, @NotNull Card card, @Nullable ProfileConfig configHelper, @NotNull ArrayList<u> outItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, app, card, configHelper, outItems);
                return;
            }
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(outItems, "outItems");
            d(app, card, configHelper, outItems);
        }

        public final int j(int fieldID, @NotNull Card card, @Nullable QQAppInterface app) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(fieldID), card, app)).intValue();
            }
            Intrinsics.checkNotNullParameter(card, "card");
            switch (fieldID) {
                case ProfileContants.FIELD_MUSIC_SWITCH /* 40314 */:
                    return card.recentlyListenSwitch;
                case ProfileContants.FIELD_MEDAL_WALL /* 42075 */:
                    if (card.medalSwitchDisable) {
                        return 1;
                    }
                    break;
                case ProfileContants.FIELD_EXTEND_FRIEND_SWITCH /* 42172 */:
                    if (!card.isShowCard) {
                        return 1;
                    }
                    break;
                case ProfileContants.FIELD_MUSICBOX_SWITCH /* 42340 */:
                    return card.switchMusicBox;
                case ProfileContants.FIELD_STICKY_NOTE_SWITCH /* 42356 */:
                    return card.switchStickyNote;
                case ProfileContants.FIELD_QQCIRCLE_SWITCH /* 42361 */:
                    return card.switchQQCircle;
                case ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH /* 42367 */:
                    return card.switchLifeAchievement;
                case ProfileContants.FIELD_WEISHI_SWITCH /* 42377 */:
                    return card.switchWeiShi;
                case ProfileContants.FIELD_STICKY_NOTE_OFFLINE /* 45168 */:
                    return card.offlineStickyNote;
                case ProfileContants.FIELD_Q_CUB_SWITCH /* 47184 */:
                    if (card.qqCubIsOn) {
                        return 1;
                    }
                    break;
                case ProfileContants.FIELD_MUSIC_DATA_SWITCH /* 47187 */:
                    return card.musicDataStatus;
                case ProfileContants.FIELD_META_FARM_SWITCH /* 47201 */:
                    return card.switchMetaFarm;
                default:
                    Integer num = card.profileDisplaySettingStates.get(fieldID, -1);
                    Intrinsics.checkNotNullExpressionValue(num, "{\n                    ca\u2026_STATE)\n                }");
                    return num.intValue();
            }
            return 0;
        }

        public final boolean l(@NotNull ArrayList<u> settingItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) settingItems)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(settingItems, "settingItems");
            Iterator<u> it = settingItems.iterator();
            while (it.hasNext()) {
                if (it.next().b()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean m(@NotNull ArrayList<u> settingItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) settingItems)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(settingItems, "settingItems");
            return true;
        }

        public final boolean n(@NotNull Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) card)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(card, "card");
            boolean isVipOpen = card.isVipOpen(EVIPSPEC.E_SP_QQVIP);
            boolean isVipOpen2 = card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
            if (ProfileCardFeatureSwitch.INSTANCE.isElegantProfileCardEnable() && (isVipOpen2 || isVipOpen || card.iQQLevel >= 0)) {
                return true;
            }
            return false;
        }

        public final boolean o(int fieldId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, fieldId)).booleanValue();
            }
            for (Integer num : v.INSTANCE.e()) {
                if (num.intValue() == fieldId) {
                    return true;
                }
            }
            return false;
        }

        public final void q(int fieldID, int toState, @NotNull Card card, @NotNull QQAppInterface app) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Integer.valueOf(fieldID), Integer.valueOf(toState), card, app);
                return;
            }
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(app, "app");
            card.profileDisplaySettingStates.put(fieldID, Integer.valueOf(toState));
            switch (fieldID) {
                case ProfileContants.FIELD_MUSIC_SWITCH /* 40314 */:
                    card.recentlyListenSwitch = (short) toState;
                    return;
                case ProfileContants.FIELD_MEDAL_WALL /* 42075 */:
                    boolean checkMedalRedPointConfig = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(app);
                    if (toState == 1) {
                        z16 = true;
                    }
                    card.medalSwitchDisable = z16;
                    SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + card.uin, 4).edit();
                    edit.putBoolean("medal_switch_disable", card.medalSwitchDisable);
                    edit.commit();
                    boolean checkMedalRedPointConfig2 = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(app);
                    if (checkMedalRedPointConfig != checkMedalRedPointConfig2) {
                        ((IUtil) QRoute.api(IUtil.class)).onMedalConfigChanged(app, checkMedalRedPointConfig2);
                        return;
                    }
                    return;
                case ProfileContants.FIELD_EXTEND_FRIEND_SWITCH /* 42172 */:
                    if (toState == 0) {
                        z16 = true;
                    }
                    card.isShowCard = z16;
                    return;
                case ProfileContants.FIELD_MUSICBOX_SWITCH /* 42340 */:
                    card.switchMusicBox = (short) toState;
                    return;
                case ProfileContants.FIELD_STICKY_NOTE_SWITCH /* 42356 */:
                    card.switchStickyNote = (short) toState;
                    return;
                case ProfileContants.FIELD_QQCIRCLE_SWITCH /* 42361 */:
                    card.switchQQCircle = (short) toState;
                    return;
                case ProfileContants.FIELD_LIFE_ACHIEVEMENT_SWITCH /* 42367 */:
                    card.switchLifeAchievement = (short) toState;
                    return;
                case ProfileContants.FIELD_WEISHI_SWITCH /* 42377 */:
                    card.switchWeiShi = (short) toState;
                    return;
                case 45160:
                    card.switchPrivilege = (short) toState;
                    return;
                case 45161:
                    card.switchMembershipAndRank = (short) toState;
                    return;
                case ProfileContants.FIELD_DRESSUP_SWITCH /* 47177 */:
                    if (((short) toState) > 0) {
                        z16 = true;
                    }
                    card.dressUpIsOn = z16;
                    return;
                case ProfileContants.FIELD_QQCARD_SWITCH /* 47180 */:
                    if (((short) toState) > 0) {
                        z16 = true;
                    }
                    card.qqCardIsOn = z16;
                    return;
                case ProfileContants.FIELD_Q_CUB_SWITCH /* 47184 */:
                    if (((short) toState) > 1) {
                        z16 = true;
                    }
                    card.qqCubIsOn = z16;
                    return;
                case ProfileContants.FIELD_MUSIC_DATA_SWITCH /* 47187 */:
                    card.musicDataStatus = (short) toState;
                    return;
                case ProfileContants.FIELD_META_FARM_SWITCH /* 47201 */:
                    card.switchMetaFarm = (short) toState;
                    return;
                case ProfileContants.FIELD_HAOMA_NAMEPLATE /* 47218 */:
                    card.liangNameplateId = toState;
                    IVasLiangNum iVasLiangNum = (IVasLiangNum) QRoute.api(IVasLiangNum.class);
                    String str = card.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "card.uin");
                    iVasLiangNum.saveLiangNumId(str, toState);
                    return;
                default:
                    return;
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
