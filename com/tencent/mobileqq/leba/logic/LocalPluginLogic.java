package com.tencent.mobileqq.leba.logic;

import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0004J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/leba/logic/LocalPluginLogic;", "", "Lcom/tencent/mobileqq/leba/entity/o;", "pluginData", "", "a", "", "pluginId", "", "style", "b", "resId", "def", "c", "Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "f", "(Lcom/tencent/mobileqq/leba/entity/o;I)Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "", "[Ljava/lang/Long;", "LEGAL_LOCAL_PLUGIN_ID_ARR", "", "Ljava/util/Map;", "LOCAL_PACKAGE_MAP", "Lorg/json/JSONObject;", "d", "Lkotlin/Lazy;", "e", "()Lorg/json/JSONObject;", "remotePluginPackageMap", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LocalPluginLogic {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final LocalPluginLogic f240660a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Long[] LEGAL_LOCAL_PLUGIN_ID_ARR;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final Map<Long, String> LOCAL_PACKAGE_MAP;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static final Lazy remotePluginPackageMap;

    static {
        Map<Long, String> mapOf;
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18614);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f240660a = new LocalPluginLogic();
        LEGAL_LOCAL_PLUGIN_ID_ARR = new Long[]{10000L, 4045L};
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(7657L, "800-\u9644\u8fd1"), TuplesKt.to(7719L, "\u9644\u8fd1"), TuplesKt.to(826L, "com.tx.xingqubuluo.android"), TuplesKt.to(7717L, "800-\u6269\u5217"), TuplesKt.to(7720L, "\u6269\u5217"), TuplesKt.to(489L, "com.tx.gamecenter.android"), TuplesKt.to(8059L, "\u5b89\u5353-\u5c0f\u7a0b\u5e8f"), TuplesKt.to(7966L, "com.weishi.andriod2"), TuplesKt.to(1130L, "com.android.ReadInJoy"), TuplesKt.to(777L, "com.qq.yijianfankui"), TuplesKt.to(3053L, "com.tencent.gouwu.android.new6.5.5+"), TuplesKt.to(2807L, "com.tencent.nowbroadcast"), TuplesKt.to(879L, "com.tencent.zhibojian"), TuplesKt.to(5362L, "com.egame.android"), TuplesKt.to(1113L, "com.android.animation"), TuplesKt.to(769L, "com.read.android"), TuplesKt.to(1047L, "com.android.music"), TuplesKt.to(795L, "m.tx.apphelper.android.new"), TuplesKt.to(5647L, "com.test.umall"), TuplesKt.to(770L, "com.qq.hotact"), TuplesKt.to(858L, "com.tencent.Health"), TuplesKt.to(4559L, "com.tencent.Android.Health"), TuplesKt.to(763L, "com.life.andorid"), TuplesKt.to(883L, "com.tencent.citylife.android"), TuplesKt.to(7102L, "com.android.txnews.new3"), TuplesKt.to(207L, "plugin.tx.tencentcom2"), TuplesKt.to(7099L, "com.ios.ketangnew"), TuplesKt.to(7100L, "com.androidhd.ketang"), TuplesKt.to(3504L, "com.android.qqtutor"), TuplesKt.to(3503L, "com.ios.qqtutor"));
        LOCAL_PACKAGE_MAP = mapOf;
        lazy = LazyKt__LazyJVMKt.lazy(LocalPluginLogic$remotePluginPackageMap$2.INSTANCE);
        remotePluginPackageMap = lazy;
    }

    LocalPluginLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(o pluginData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LebaPluginInfo.EXT_CONF_DA_TONG_ID, pluginData.b());
        } catch (JSONException e16) {
            QLog.e("LocalPluginData", 1, "buildExtConf ", e16);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public static /* synthetic */ String d(LocalPluginLogic localPluginLogic, long j3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = String.valueOf(j3);
        }
        return localPluginLogic.c(j3, str);
    }

    private final JSONObject e() {
        return (JSONObject) remotePluginPackageMap.getValue();
    }

    public final int b(long pluginId, int style) {
        boolean contains;
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Long.valueOf(pluginId), Integer.valueOf(style))).intValue();
        }
        Long[] lArr = LEGAL_LOCAL_PLUGIN_ID_ARR;
        contains = ArraysKt___ArraysKt.contains(lArr, Long.valueOf(pluginId));
        if (!contains) {
            return Integer.MAX_VALUE;
        }
        if (style != 2 || pluginId != 4045) {
            indexOf = ArraysKt___ArraysKt.indexOf(lArr, Long.valueOf(pluginId));
            return f.h(0, indexOf);
        }
        return f.h(1, 1) + 1;
    }

    @NotNull
    public final String c(long resId, @NotNull String def) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Long.valueOf(resId), def);
        }
        Intrinsics.checkNotNullParameter(def, "def");
        JSONObject e16 = e();
        if (e16 != null) {
            str = e16.optString(String.valueOf(resId), "");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            String str2 = LOCAL_PACKAGE_MAP.get(Long.valueOf(resId));
            if (str2 != null) {
                return str2;
            }
            return def;
        }
        return str;
    }

    @NotNull
    public final LebaPluginInfo f(@NotNull o pluginData, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LebaPluginInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) pluginData, style);
        }
        Intrinsics.checkNotNullParameter(pluginData, "pluginData");
        LebaPluginInfo lebaPluginInfo = new LebaPluginInfo();
        lebaPluginInfo.uiResId = pluginData.e();
        lebaPluginInfo.strResName = pluginData.g();
        lebaPluginInfo.strPkgName = String.valueOf(pluginData.e());
        lebaPluginInfo.cIconResId = pluginData.c();
        lebaPluginInfo.strResURL = pluginData.d();
        lebaPluginInfo.cCanChangeState = pluginData.a() ? 1 : 0;
        lebaPluginInfo.sResSubType = pluginData.f();
        lebaPluginInfo.strGotoUrl = pluginData.j();
        lebaPluginInfo.showInSimpleMode = pluginData.h() ? 1 : 0;
        lebaPluginInfo.setAllowChange(Boolean.valueOf(pluginData.a()));
        lebaPluginInfo.setShow(true, 0);
        lebaPluginInfo.strSimpleResUrl = pluginData.i();
        lebaPluginInfo.resConf = a(pluginData);
        lebaPluginInfo.groupId = 0;
        lebaPluginInfo.sPriority = b(pluginData.e(), style);
        return lebaPluginInfo;
    }
}
