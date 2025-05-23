package com.tencent.mobileqq.troop.troopidentity.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconFragment;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtilKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopListTempApi;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityTitleInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J=\u0010 \u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102)\u0010\u001f\u001a%\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f\u0018\u00010\u001bj\u0004\u0018\u0001`\u001eH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/api/impl/TroopIdentityApiImpl;", "Lcom/tencent/mobileqq/troop/troopidentity/api/ITroopIdentityApi;", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "rankItem", "Lorg/json/JSONObject;", "createRankTitleJsonInfo", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "getIdentityDataFromCacheOrFetchAsync", "appIconBindData", "", "sendAppIconBindDataUpdateEvent", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "openTroopIdentityWearPage", "Ljava/lang/Class;", "", "getJumpParser", "", "newSwitchStatus", "onGetGlobalSwitch", "getGlobalSwitch", "getCachedIdentityTitleInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mobileqq/troop/troopidentity/api/TroopMemberRankTitleCallback;", "callback", "getTroopMemberRankTitleForWeb", "isGlobalSwitchOpen", "Ljava/lang/Boolean;", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityApiImpl implements ITroopIdentityApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String IDENTITY_GLOBAL_SWITCH_CACHE_KEY = "troop_identity_global_switch";

    @NotNull
    private static final String TAG = "TroopIdentityApiImpl";

    @Nullable
    private Boolean isGlobalSwitchOpen;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/api/impl/TroopIdentityApiImpl$a;", "", "", "IDENTITY_GLOBAL_SWITCH_CACHE_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.api.impl.TroopIdentityApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57720);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final JSONObject createRankTitleJsonInfo(com.tencent.mobileqq.troop.troopmemberlevel.a rankItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (rankItem == null) {
                jSONObject.put("ret", -1);
            } else {
                JSONArray jSONArray = new JSONArray();
                int[] iArr = rankItem.f300593d;
                if (iArr != null) {
                    for (int i3 : iArr) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%08X", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        jSONArray.mo162put("#" + format);
                    }
                }
                jSONObject.put("ret", 0);
                jSONObject.put("level", rankItem.f300591b);
                jSONObject.put("title", rankItem.f300592c);
                jSONObject.put("color", jSONArray);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(rankItem.f300597h & 16777215)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                jSONObject.put("fontColor", "#" + format2);
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "[createRankTitleJsonInfo] exception = " + e16);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getIdentityDataFromCacheOrFetchAsync$lambda$1(TroopIdentityApiImpl this$0, String str, String str2, TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        if (troopMemberInfo != null) {
            this$0.sendAppIconBindDataUpdateEvent(str, str2, com.tencent.mobileqq.troop.troopidentity.processor.b.f300409a.a(troopInfo, troopMemberInfo.extInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTroopMemberRankTitleForWeb$lambda$7(TroopInfo troopInfo, Bundle bundle, TroopIdentityApiImpl this$0, Function1 function1, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (troopMemberInfo == null) {
            return;
        }
        bundle.putString("rankTitle", this$0.createRankTitleJsonInfo(((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(troopInfo, troopMemberInfo)).toString());
        function1.invoke(bundle);
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    @NotNull
    public JSONObject getCachedIdentityTitleInfo(@NotNull String troopUin, @NotNull String memberUin) {
        Integer intOrNull;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        GetIdentityListRsp d16 = com.tencent.mobileqq.troop.troopidentity.util.b.f300417a.d(troopUin, memberUin);
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        TroopMemberInfo troopMemberFromCache = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCache(troopUin, memberUin, null, TAG);
        com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(troopInfoFromCache, troopMemberFromCache);
        boolean z16 = false;
        if (d16 != null && troopInfoFromCache != null && troopMemberFromCache != null && troopMemberRankItem != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList<GroupIdentityTitleInfo> arrayList = d16.titles;
            if (arrayList != null) {
                for (GroupIdentityTitleInfo groupIdentityTitleInfo : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("titleId", groupIdentityTitleInfo.titleId);
                    jSONObject.put("titleName", groupIdentityTitleInfo.name);
                    ITroopMemberLevelUtilsApi iTroopMemberLevelUtilsApi = (ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class);
                    String str = groupIdentityTitleInfo.titleId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.titleId");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                    if (intOrNull != null) {
                        i3 = intOrNull.intValue();
                    } else {
                        i3 = 0;
                    }
                    JSONObject rankBgColorConfigJson = iTroopMemberLevelUtilsApi.getRankBgColorConfigJson(i3);
                    if (rankBgColorConfigJson == null) {
                        rankBgColorConfigJson = new JSONObject();
                    }
                    Iterator keys = rankBgColorConfigJson.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "bgColorJson.keys()");
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        jSONObject.put(str2, rankBgColorConfigJson.get(str2));
                    }
                    jSONArray.mo162put(jSONObject);
                }
            }
            int e16 = com.tencent.mobileqq.troop.troopidentity.util.b.f300417a.e(troopUin, memberUin);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("role", troopMemberFromCache.role.ordinal());
            jSONObject2.put("level", troopMemberRankItem.f300591b);
            jSONObject2.put("isShowLevel", troopMemberRankItem.f300595f);
            jSONObject2.put("richFlag", e16);
            jSONObject2.put("titleList", jSONArray);
            QLog.i(TAG, 1, "[getCachedIdentityTitleInfo] troopUin = " + troopUin + " memberUin = " + memberUin + " rtnJson = " + TroopIdentityHonorUtilKt.b(jSONObject2));
            return jSONObject2;
        }
        if (d16 == null) {
            z16 = true;
        }
        QLog.i(TAG, 1, "[getIdentityCacheTitleInfo] cachedIdentityRsp = " + z16 + " troopInfo = " + troopInfoFromCache + " troopMemberInfo = " + troopMemberFromCache + " memberRankItem = " + troopMemberRankItem);
        return new JSONObject();
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    public boolean getGlobalSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.isGlobalSwitchOpen == null) {
            this.isGlobalSwitchOpen = Boolean.valueOf(com.tencent.mobileqq.troop.config.a.e(com.tencent.mobileqq.troop.config.a.f294689a, IDENTITY_GLOBAL_SWITCH_CACHE_KEY, true, false, 4, null));
        }
        Boolean bool = this.isGlobalSwitchOpen;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    @Nullable
    public c getIdentityDataFromCacheOrFetchAsync(@Nullable final String troopUin, @Nullable final String memberUin) {
        boolean z16;
        final TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        boolean z17 = false;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (memberUin == null || memberUin.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                if (!getGlobalSwitch()) {
                    return new c(false, false, false, 0, 14, null);
                }
                Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(troopUin);
                if (troopInfoFromCache instanceof TroopInfo) {
                    troopInfo = (TroopInfo) troopInfoFromCache;
                } else {
                    troopInfo = null;
                }
                if (troopInfo == null) {
                    return null;
                }
                com.tencent.mobileqq.troop.troopidentity.processor.b bVar = com.tencent.mobileqq.troop.troopidentity.processor.b.f300409a;
                if (bVar.c(troopInfo)) {
                    return new c(true, false, false, 0, 12, null);
                }
                TroopMemberInfo troopMemberWithExtFromCacheOrFetchAsync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberWithExtFromCacheOrFetchAsync(troopUin, memberUin, null, TAG, new g() { // from class: com.tencent.mobileqq.troop.troopidentity.api.impl.a
                    @Override // com.tencent.qqnt.troopmemberlist.g
                    public final void a(TroopMemberInfo troopMemberInfo) {
                        TroopIdentityApiImpl.getIdentityDataFromCacheOrFetchAsync$lambda$1(TroopIdentityApiImpl.this, troopUin, memberUin, troopInfo, troopMemberInfo);
                    }
                });
                if (troopMemberWithExtFromCacheOrFetchAsync != null) {
                    return bVar.a(troopInfo, troopMemberWithExtFromCacheOrFetchAsync.extInfo);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    @NotNull
    public Class<Object> getJumpParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopidentity.jump.b.class;
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    public void getTroopMemberRankTitleForWeb(@Nullable final Bundle bundle, @Nullable final Function1<? super Bundle, Unit> callback) {
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle, (Object) callback);
            return;
        }
        if (callback == null || bundle == null || (string = bundle.getString("troopUin")) == null || (string2 = bundle.getString("memberUin")) == null) {
            return;
        }
        final TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(string);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(string, string2, false, null, TAG, new g() { // from class: com.tencent.mobileqq.troop.troopidentity.api.impl.b
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopIdentityApiImpl.getTroopMemberRankTitleForWeb$lambda$7(TroopInfo.this, bundle, this, callback, troopMemberInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    public void onGetGlobalSwitch(boolean newSwitchStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, newSwitchStatus);
            return;
        }
        ThreadManagerV2.getSubThread();
        boolean globalSwitch = getGlobalSwitch();
        QLog.i(TAG, 1, "[onGetGlobalSwitch] oldSwitchStatus = " + globalSwitch + " newSwitchStatus = " + newSwitchStatus);
        if (newSwitchStatus == globalSwitch) {
            return;
        }
        this.isGlobalSwitchOpen = Boolean.valueOf(newSwitchStatus);
        com.tencent.mobileqq.troop.config.a.r(com.tencent.mobileqq.troop.config.a.f294689a, IDENTITY_GLOBAL_SWITCH_CACHE_KEY, newSwitchStatus, false, 4, null);
        com.tencent.mobileqq.troop.troopidentity.processor.b.f300409a.h("");
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    public void openTroopIdentityWearPage(@NotNull Context context, @NotNull String troopUin, @NotNull String memberUin, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, troopUin, memberUin, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache == null || troopInfoFromCache.isHomeworkTroop()) {
            z16 = false;
        }
        if (z16) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("member_uin", memberUin);
            QPublicFragmentActivity.start(context, intent, TroopIdentityIconFragment.class);
            return;
        }
        String str = "https://qun.qq.com/interactive/userhonor?gc=" + troopUin + "&uin=" + memberUin + "&_wv=3&&_wwv=128";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026              .toString()");
        Intent putExtra = new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, QQBrowse\u2026iewConstant.KEY_URL, url)");
        putExtra.putExtras(bundle);
        context.startActivity(putExtra);
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi
    public void sendAppIconBindDataUpdateEvent(@NotNull String troopUin, @NotNull String memberUin, @Nullable c appIconBindData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, memberUin, appIconBindData);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        com.tencent.mobileqq.troop.troopidentity.processor.b.f300409a.g(troopUin, memberUin, appIconBindData);
    }
}
