package com.tencent.mobileqq.vas.troop;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0013R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u001fj\b\u0012\u0004\u0012\u00020\u0011` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R'\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u001fj\b\u0012\u0004\u0012\u00020\u0011` 8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010'R#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b.\u0010,R#\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020/0(8\u0006\u00a2\u0006\f\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,R#\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0(8\u0006\u00a2\u0006\f\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/IceBreakHelper;", "", "", "msgId", "", "needPlayEnterEffect", "", "putPlayEnterEffect", "clearPlayEnterEffect", "Landroid/content/Context;", "context", "gotoIceBreakWeb", "", "TAG", "Ljava/lang/String;", "LIST_KEY", "ADD_TROOP_PAGE_KEY", "", "VIP_TYPE", "I", "SVIP_TYPE", "BIG_VIP_TYPE", "AIO_KEY", "OLD_TEMPLATE", "OLD_BIG_VIP_TEMPLATE", "NEW_GAME_TEMPLATE", "AIO_JUMP_CONFIG", "TROOP_ICE_BREAK_VIP_ID", "TROOP_ICE_BREAK_SUPER_VIP_ID", "TROOP_ICE_BREAK_BIG_VIP_ID", "DEFAULT_TEMPLATE", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "defaultList", "Ljava/util/ArrayList;", "enableNewTemplate", "Z", "templateList", "getTemplateList", "()Ljava/util/ArrayList;", "", "templateVipType", "Ljava/util/Map;", "getTemplateVipType", "()Ljava/util/Map;", "aioTemplateType", "getAioTemplateType", "Lcom/tencent/mobileqq/vas/troop/a;", "aioJumpConfig", "getAioJumpConfig", "nameConfig", "getNameConfig", "Ljava/util/concurrent/ConcurrentHashMap;", "sEnterEffectPlay", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class IceBreakHelper {

    @NotNull
    private static final String ADD_TROOP_PAGE_KEY = "join_troop_page";

    @NotNull
    private static final String AIO_JUMP_CONFIG = "aio_jump";

    @NotNull
    private static final String AIO_KEY = "aio_page";
    public static final int BIG_VIP_TYPE = 3;
    public static final int DEFAULT_TEMPLATE = 2000;

    @NotNull
    public static final IceBreakHelper INSTANCE = new IceBreakHelper();

    @NotNull
    private static final String LIST_KEY = "template_list";
    public static final int NEW_GAME_TEMPLATE = 3;
    public static final int OLD_BIG_VIP_TEMPLATE = 2;
    public static final int OLD_TEMPLATE = 1;
    public static final int SVIP_TYPE = 2;

    @NotNull
    private static final String TAG = "IceBreakHelper";
    public static final int TROOP_ICE_BREAK_BIG_VIP_ID = 2003;
    public static final int TROOP_ICE_BREAK_SUPER_VIP_ID = 2002;
    private static final int TROOP_ICE_BREAK_VIP_ID = 2001;
    public static final int VIP_TYPE = 1;

    @NotNull
    private static final Map<Integer, IceBreakConfig> aioJumpConfig;

    @NotNull
    private static final Map<Integer, Integer> aioTemplateType;

    @NotNull
    private static final ArrayList<Integer> defaultList;
    private static boolean enableNewTemplate;

    @NotNull
    private static final Map<Integer, String> nameConfig;

    @NotNull
    private static final ConcurrentHashMap<Long, Boolean> sEnterEffectPlay;

    @NotNull
    private static final ArrayList<Integer> templateList;

    @NotNull
    private static final Map<Integer, Integer> templateVipType;

    static {
        Map<Integer, Integer> mutableMapOf;
        Map<Integer, Integer> mutableMapOf2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2000);
        arrayList.add(2002);
        arrayList.add(2003);
        arrayList.add(2001);
        defaultList = arrayList;
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        templateList = arrayList2;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(2000, 0), TuplesKt.to(2001, 1), TuplesKt.to(2002, 2), TuplesKt.to(2003, 3), TuplesKt.to(2004, 3));
        templateVipType = mutableMapOf;
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(2000, 0), TuplesKt.to(2001, 1), TuplesKt.to(2002, 1), TuplesKt.to(2003, 2), TuplesKt.to(2004, 2));
        aioTemplateType = mutableMapOf2;
        aioJumpConfig = new LinkedHashMap();
        nameConfig = new LinkedHashMap();
        UnitedProxy unitedProxy = VasNtToggle.VAS_NEW_SVIP_ICE_BREAK_CONFIG;
        boolean isEnable = unitedProxy.isEnable(true);
        enableNewTemplate = isEnable;
        if (isEnable) {
            arrayList2.add(2000);
            try {
                JSONObject json = unitedProxy.getJson();
                JSONArray optJSONArray = json.optJSONArray(LIST_KEY);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = optJSONArray.getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "templates.getString(i)");
                        int parseInt = Integer.parseInt(string);
                        ArrayList<Integer> arrayList3 = templateList;
                        if (!arrayList3.contains(Integer.valueOf(parseInt))) {
                            arrayList3.add(Integer.valueOf(parseInt));
                        }
                    }
                }
                JSONObject jSONObject = json.getJSONObject(ADD_TROOP_PAGE_KEY);
                for (int i16 = 1; i16 < 4; i16++) {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(String.valueOf(i16));
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i17 = 0; i17 < length2; i17++) {
                            String string2 = optJSONArray2.getString(i17);
                            Intrinsics.checkNotNullExpressionValue(string2, "tempList.getString(i)");
                            templateVipType.put(Integer.valueOf(Integer.parseInt(string2)), Integer.valueOf(i16));
                        }
                    }
                }
                JSONObject jSONObject2 = json.getJSONObject(AIO_KEY);
                for (int i18 = 1; i18 < 4; i18++) {
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(String.valueOf(i18));
                    if (optJSONArray3 != null) {
                        int length3 = optJSONArray3.length();
                        for (int i19 = 0; i19 < length3; i19++) {
                            String string3 = optJSONArray3.getString(i19);
                            Intrinsics.checkNotNullExpressionValue(string3, "tempList.getString(i)");
                            aioTemplateType.put(Integer.valueOf(Integer.parseInt(string3)), Integer.valueOf(i18));
                        }
                    }
                }
                JSONObject jSONObject3 = json.getJSONObject(AIO_JUMP_CONFIG);
                Iterator keys = jSONObject3.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "aioJumpConfig.keys()");
                while (keys.hasNext()) {
                    String it = (String) keys.next();
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(it);
                    Map<Integer, IceBreakConfig> map = aioJumpConfig;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Integer valueOf = Integer.valueOf(Integer.parseInt(it));
                    String string4 = jSONObject4.getString("desc");
                    Intrinsics.checkNotNullExpressionValue(string4, "otherInfo.getString(\"desc\")");
                    String string5 = jSONObject4.getString("url");
                    Intrinsics.checkNotNullExpressionValue(string5, "otherInfo.getString(\"url\")");
                    map.put(valueOf, new IceBreakConfig(string4, string5));
                }
                JSONObject jSONObject5 = json.getJSONObject("client_card_name");
                Iterator keys2 = jSONObject5.keys();
                Intrinsics.checkNotNullExpressionValue(keys2, "cardNames.keys()");
                while (keys2.hasNext()) {
                    String it5 = (String) keys2.next();
                    Map<Integer, String> map2 = nameConfig;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    Integer valueOf2 = Integer.valueOf(Integer.parseInt(it5));
                    String string6 = jSONObject5.getString(it5);
                    Intrinsics.checkNotNullExpressionValue(string6, "cardNames.getString(it)");
                    map2.put(valueOf2, string6);
                }
            } catch (Exception e16) {
                ArrayList<Integer> arrayList4 = templateList;
                arrayList4.clear();
                arrayList4.addAll(defaultList);
                QLog.e(TAG, 1, "parse error " + e16);
            }
        } else {
            arrayList2.addAll(arrayList);
        }
        sEnterEffectPlay = new ConcurrentHashMap<>();
    }

    IceBreakHelper() {
    }

    public final void clearPlayEnterEffect() {
        sEnterEffectPlay.clear();
    }

    @NotNull
    public final Map<Integer, IceBreakConfig> getAioJumpConfig() {
        return aioJumpConfig;
    }

    @NotNull
    public final Map<Integer, Integer> getAioTemplateType() {
        return aioTemplateType;
    }

    @NotNull
    public final Map<Integer, String> getNameConfig() {
        return nameConfig;
    }

    @NotNull
    public final ArrayList<Integer> getTemplateList() {
        return templateList;
    }

    @NotNull
    public final Map<Integer, Integer> getTemplateVipType() {
        return templateVipType;
    }

    public final void gotoIceBreakWeb(@Nullable Context context) {
        ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).handleIceBreakVipClick(context);
    }

    public final boolean needPlayEnterEffect(long msgId) {
        Boolean bool = sEnterEffectPlay.get(Long.valueOf(msgId));
        if (bool != null && !Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return false;
        }
        return true;
    }

    public final void putPlayEnterEffect(long msgId) {
        sEnterEffectPlay.put(Long.valueOf(msgId), Boolean.FALSE);
    }
}
