package com.tencent.zplan.luabridge.plugins;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/FriendPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleOpenFriendChosen", "handleGetFriendAvatar", "handleGetDefaultFriends", "handleRecordRoleIcon", "handleOpenForwardRecentPage", "handleAddFriendByUin", "handleAddFriendByOpenId", "getAddFriendSettingByUin", "getAddFriendSettingByOpenId", "getIsFriendByUin", "getIsFriendByOpenId", "getIsFriendsWithOpenIdList", "handleAddSmallHomeBackground", "<init>", "()V", "d", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class FriendPlugin extends LuaBasePlugin {
    @LuaEvent("L2N_CanAddFriendByOpenId")
    @Nullable
    public final String getAddFriendSettingByOpenId(@NotNull final LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("openId");
        String optString2 = jSONObject.optString("appId");
        boolean z17 = false;
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (optString2 == null || optString2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
                if (eVar != null) {
                    eVar.b(null, optString, optString2, new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$getAddFriendSettingByOpenId$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z18) {
                            ZLog.f386189b.k("FriendPlugin", "getAddFriendSettingByOpenId result: " + z18);
                            LuaArgument luaArgument = LuaArgument.this;
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("canAddFriend", z18);
                            Unit unit = Unit.INSTANCE;
                            luaArgument.callback(luaArgument.ok(jSONObject2));
                        }
                    });
                }
                return null;
            }
        }
        return argument.fail("invalid params: openId or appId is empty");
    }

    @LuaEvent("L2N_CanAddFriendByUin")
    @Nullable
    public final String getAddFriendSettingByUin(@NotNull final LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        String optString = new JSONObject(argument.getF440574c()).optString("uin");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return argument.fail("invalid params: uin is empty");
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            eVar.b(optString, null, null, new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$getAddFriendSettingByUin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    ZLog.f386189b.k("FriendPlugin", "getAddFriendSettingByUin result: " + z17);
                    LuaArgument luaArgument = LuaArgument.this;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("canAddFriend", z17);
                    Unit unit = Unit.INSTANCE;
                    luaArgument.callback(luaArgument.ok(jSONObject));
                }
            });
        }
        return null;
    }

    @LuaEvent("L2N_IsFriendByOpenId")
    @Nullable
    public final String getIsFriendByOpenId(@NotNull final LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("openId");
        String optString2 = jSONObject.optString("appId");
        boolean z17 = false;
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (optString2 == null || optString2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
                if (eVar != null) {
                    eVar.d(null, optString, optString2, new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$getIsFriendByOpenId$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z18) {
                            ZLog.f386189b.k("FriendPlugin", "getIsFriendByOpenId result: " + z18);
                            LuaArgument luaArgument = LuaArgument.this;
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(IProfileProtocolConst.PARAM_IS_FRIEND, z18);
                            Unit unit = Unit.INSTANCE;
                            luaArgument.callback(luaArgument.ok(jSONObject2));
                        }
                    });
                }
                return null;
            }
        }
        return argument.fail("invalid params: openId or appId is empty");
    }

    @LuaEvent("L2N_IsFriendByUin")
    @Nullable
    public final String getIsFriendByUin(@NotNull final LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        String optString = new JSONObject(argument.getF440574c()).optString("uin");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return argument.fail("invalid params: uin is empty");
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            eVar.d(optString, null, null, new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$getIsFriendByUin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    ZLog.f386189b.k("FriendPlugin", "getIsFriendByUin result: " + z17);
                    LuaArgument luaArgument = LuaArgument.this;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IProfileProtocolConst.PARAM_IS_FRIEND, z17);
                    Unit unit = Unit.INSTANCE;
                    luaArgument.callback(luaArgument.ok(jSONObject));
                }
            });
        }
        return null;
    }

    @LuaEvent("L2N_IsFriendsWithOpenIdList")
    @Nullable
    public final String getIsFriendsWithOpenIdList(@NotNull final LuaArgument argument) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("appId");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("openIdList");
        if (optJSONArray != null) {
            if (optString != null && optString.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                int length = optJSONArray.length();
                int i3 = 0;
                while (true) {
                    String str = null;
                    if (i3 >= length) {
                        break;
                    }
                    String optString2 = optJSONArray.optString(i3);
                    if (optString2 != null && optString2.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        str = optString2;
                    }
                    if (str != null) {
                        arrayList.add(str);
                    }
                    i3++;
                }
                if (arrayList.size() < 1) {
                    return argument.fail("invalid params: openIdList or its value is empty");
                }
                zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
                if (eVar != null) {
                    eVar.f(arrayList, optString, new Function1<Map<String, ? extends Boolean>, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$getIsFriendsWithOpenIdList$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Boolean> map) {
                            invoke2((Map<String, Boolean>) map);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable Map<String, Boolean> map) {
                            ZLog.f386189b.k("FriendPlugin", "getIsFriendByOpenIdList result: " + map);
                            if (map == null || map.isEmpty()) {
                                LuaArgument luaArgument = LuaArgument.this;
                                luaArgument.callback(luaArgument.fail("getIsFriendsWithOpenIdList failed"));
                            } else {
                                LuaArgument luaArgument2 = LuaArgument.this;
                                luaArgument2.callback(luaArgument2.ok(new JSONObject(map)));
                            }
                        }
                    });
                }
                return null;
            }
        }
        return argument.fail("invalid params: openIdList or appId is empty");
    }

    @LuaEvent("L2N_AddFriendByOpenId")
    @Nullable
    public final String handleAddFriendByOpenId(@NotNull LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("openId");
        String optString2 = jSONObject.optString("appId");
        int optInt = jSONObject.optInt("sourceId");
        int optInt2 = jSONObject.optInt("subSourceId");
        boolean z17 = false;
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (optString2 == null || optString2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
                if (eVar != null) {
                    eVar.c(null, optString, optString2, optInt, optInt2);
                }
                return argument.ok();
            }
        }
        return argument.fail("invalid params: openId or appId is empty");
    }

    @LuaEvent("L2N_AddFriendByUin")
    @Nullable
    public final String handleAddFriendByUin(@NotNull LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("uin");
        int optInt = jSONObject.optInt("sourceId");
        int optInt2 = jSONObject.optInt("subSourceId");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return argument.fail("invalid params: uin is empty");
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            eVar.c(optString, null, null, optInt, optInt2);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_AddSmallHomeBackground")
    @Nullable
    public final String handleAddSmallHomeBackground(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        boolean z16 = false;
        int optInt = jSONObject.optInt("scene", 0);
        String optString = jSONObject.optString("imagePath", "");
        if (optString == null || optString.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return argument.fail("invalid params: imagePath is empty");
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            eVar.e(optInt, optString);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_SameStyle_RequestDefaultUins")
    @Nullable
    public final String handleGetDefaultFriends(@NotNull final LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        ZLog.f386189b.f("FriendPlugin", "handleGetDefaultFriends with params: " + jSONObject);
        final int optInt = jSONObject.optInt("uinNum");
        if (jSONObject.has("uinSex")) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("uinSex");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Integer valueOf = Integer.valueOf(optJSONArray.optInt(i3));
                    int intValue = valueOf.intValue();
                    if (intValue >= 0 && 2 >= intValue) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        arrayList.add(Integer.valueOf(valueOf.intValue()));
                    }
                }
            }
            if (optInt > 0 && optInt == arrayList.size()) {
                zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
                if (eVar != null) {
                    eVar.g(arrayList, new Function1<List<? extends Pair<? extends String, ? extends String>>, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$handleGetDefaultFriends$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Pair<? extends String, ? extends String>> list) {
                            invoke2((List<Pair<String, String>>) list);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull List<Pair<String, String>> friendList) {
                            int coerceAtMost;
                            Intrinsics.checkNotNullParameter(friendList, "friendList");
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            coerceAtMost = RangesKt___RangesKt.coerceAtMost(friendList.size(), optInt);
                            for (int i16 = 0; i16 < coerceAtMost; i16++) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("uin", friendList.get(i16).getFirst());
                                jSONObject3.put("nick", friendList.get(i16).getSecond());
                                jSONArray.mo162put(jSONObject3);
                            }
                            jSONObject2.put("friends", jSONArray);
                            ZLog.f386189b.f("FriendPlugin", "call back handleGetDefaultFriends with result: " + jSONObject2);
                            LuaArgument luaArgument = argument;
                            luaArgument.callback(luaArgument.ok(jSONObject2));
                        }
                    });
                }
            } else {
                String str = "invalid params: count is " + optInt + " and uinSex size " + arrayList.size();
                ZLog.f386189b.f("FriendPlugin", "call back handleGetDefaultFriends with err: " + str);
                argument.callback(argument.fail(str));
            }
        } else if (optInt > 0) {
            zx4.e eVar2 = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
            if (eVar2 != null) {
                eVar2.j(new Function1<List<? extends String>, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$handleGetDefaultFriends$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                        invoke2((List<String>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull List<String> uinList) {
                        Intrinsics.checkNotNullParameter(uinList, "uinList");
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        int min = Math.min(optInt, uinList.size());
                        for (int i16 = 0; i16 < min; i16++) {
                            jSONArray.mo162put(uinList.get(i16));
                        }
                        jSONObject2.put("uins", jSONArray);
                        LuaArgument luaArgument = argument;
                        luaArgument.callback(luaArgument.ok(jSONObject2));
                    }
                });
            }
        } else {
            argument.callback(argument.fail("invalid params: count is zero"));
        }
        return null;
    }

    @LuaEvent("L2N_RequestQQIcon")
    @Nullable
    public final String handleGetFriendAvatar(@NotNull final LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        String optString = new JSONObject(argument.getF440574c()).optString("uin");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            argument.callback(argument.fail("invalid params: uin is empty"));
            return null;
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            eVar.h(optString, new Function1<String, Unit>() { // from class: com.tencent.zplan.luabridge.plugins.FriendPlugin$handleGetFriendAvatar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    if (str == null) {
                        LuaArgument luaArgument = LuaArgument.this;
                        luaArgument.callback(luaArgument.fail("avatar not found"));
                        return;
                    }
                    LuaArgument luaArgument2 = LuaArgument.this;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("iconPath", str);
                    Unit unit = Unit.INSTANCE;
                    luaArgument2.callback(luaArgument2.ok(jSONObject));
                }
            });
            return null;
        }
        return null;
    }

    @LuaEvent("L2N_ShareToFriend")
    @Nullable
    public final String handleOpenForwardRecentPage(@NotNull LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("appID");
        boolean optBoolean = jSONObject.optBoolean("isSupportMultiSelect");
        String arkShareContent = jSONObject.optString("arkShareContent");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return argument.fail("invalid params: appId is empty");
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            Intrinsics.checkNotNullExpressionValue(arkShareContent, "arkShareContent");
            eVar.a(optString, optBoolean, arkShareContent);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_SameStyle_OpenFriendChoosen")
    @Nullable
    public final String handleOpenFriendChosen(@NotNull LuaArgument argument) {
        String joinToString$default;
        String joinToString$default2;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        ZLog zLog = ZLog.f386189b;
        zLog.f("FriendPlugin", "handleOpenFriendChosen with params: " + jSONObject);
        int optInt = jSONObject.optInt("totalFriendNumber");
        if (optInt <= 0) {
            zLog.f("FriendPlugin", "max select num  = " + optInt + ", is not valid");
            return argument.fail("invalid params");
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("currentFriendUin");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (optString != null && optString.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!(!z17)) {
                    optString = null;
                }
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("currentFriendSex");
        if (optJSONArray2 != null && optJSONArray != null && optJSONArray2.length() == optJSONArray.length()) {
            int length2 = optJSONArray.length();
            for (int i16 = 0; i16 < length2; i16++) {
                Integer valueOf = Integer.valueOf(optJSONArray2.optInt(i16));
                int intValue = valueOf.intValue();
                if (intValue >= 0 && 2 >= intValue) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    arrayList2.add(Integer.valueOf(valueOf.intValue()));
                }
            }
            String optString2 = jSONObject.optString("currentTemplateID");
            ZLog zLog2 = ZLog.f386189b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("maxSelectNum = ");
            sb5.append(optInt);
            sb5.append(", templateID = ");
            sb5.append(optString2);
            sb5.append(',');
            sb5.append(" preselection = [");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
            sb5.append(joinToString$default);
            sb5.append("],");
            sb5.append("preselectionSex = [");
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
            sb5.append(joinToString$default2);
            sb5.append(']');
            zLog2.f("FriendPlugin", sb5.toString());
            zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
            if (eVar != null) {
                eVar.k(optInt, optString2, arrayList, arrayList2);
            }
            return argument.ok();
        }
        ZLog.f386189b.f("FriendPlugin", "preselectionSex  = " + optJSONArray2 + ", preselection  = " + optJSONArray + ", size is not equal");
        return argument.fail("invalid params");
    }

    @LuaEvent("L2N_RecordRoleIcon")
    @Nullable
    public final String handleRecordRoleIcon(@NotNull LuaArgument argument) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "argument");
        String optString = new JSONObject(argument.getF440574c()).optString("path");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return argument.fail("invalid params: path is empty");
        }
        zx4.e eVar = (zx4.e) mx4.a.f417748a.a(zx4.e.class);
        if (eVar != null) {
            eVar.i(optString);
        }
        return argument.ok();
    }
}
