package com.tencent.mobileqq.vas.api.impl;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J!\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u00180\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasAppIconStateManagerImpl;", "Lcom/tencent/mobileqq/vas/api/IVasAppIconStateManager;", "Landroid/content/Context;", "context", "Landroid/content/ComponentName;", "getSplashActivityComponent", "", "getSplashActivityName", "", "b", "", "setUseAppIcon", "isUseAppIcon", "", "id", "setPrepareIconId", "getPrepareIconId", "setNowIconId", "getNowIconId", "setTestMode", "isTestMode", "isSupport", "getAliasActivityName", "", "Lkotlin/Pair;", "getAllAlias", "()[Lkotlin/Pair;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAppIconStateManagerImpl implements IVasAppIconStateManager {

    @NotNull
    private static final Pair<Integer, String>[] sAliasActivityNames = {TuplesKt.to(0, "com.tencent.mobileqq.activity.SplashActivity"), TuplesKt.to(2, "com.tencent.mobileqq.activity.Alias2SplashActivity"), TuplesKt.to(3, "com.tencent.mobileqq.activity.Alias3SplashActivity"), TuplesKt.to(4, "com.tencent.mobileqq.activity.Alias4SplashActivity"), TuplesKt.to(5, "com.tencent.mobileqq.activity.Alias5SplashActivity"), TuplesKt.to(6, "com.tencent.mobileqq.activity.Alias6SplashActivity"), TuplesKt.to(7, "com.tencent.mobileqq.activity.Alias7SplashActivity"), TuplesKt.to(8, "com.tencent.mobileqq.activity.Alias8SplashActivity"), TuplesKt.to(9, "com.tencent.mobileqq.activity.Alias9SplashActivity"), TuplesKt.to(10, "com.tencent.mobileqq.activity.Alias10SplashActivity"), TuplesKt.to(13, "com.tencent.mobileqq.activity.Alias13SplashActivity"), TuplesKt.to(14, "com.tencent.mobileqq.activity.Alias14SplashActivity"), TuplesKt.to(16, "com.tencent.mobileqq.activity.Alias16SplashActivity"), TuplesKt.to(17, "com.tencent.mobileqq.activity.Alias17SplashActivity"), TuplesKt.to(18, "com.tencent.mobileqq.activity.Alias18SplashActivity"), TuplesKt.to(19, "com.tencent.mobileqq.activity.Alias19SplashActivity"), TuplesKt.to(20, "com.tencent.mobileqq.activity.Alias20SplashActivity"), TuplesKt.to(21, "com.tencent.mobileqq.activity.Alias21SplashActivity"), TuplesKt.to(23, "com.tencent.mobileqq.activity.Alias23SplashActivity"), TuplesKt.to(24, "com.tencent.mobileqq.activity.Alias24SplashActivity"), TuplesKt.to(25, "com.tencent.mobileqq.activity.Alias25SplashActivity"), TuplesKt.to(26, "com.tencent.mobileqq.activity.Alias26SplashActivity")};

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    @Nullable
    public String getAliasActivityName(int id5) {
        Pair<Integer, String> pair;
        boolean z16;
        Pair<Integer, String>[] pairArr = sAliasActivityNames;
        int length = pairArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                pair = pairArr[i3];
                if (pair.getFirst().intValue() == id5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                pair = null;
                break;
            }
        }
        if (pair == null) {
            return null;
        }
        return pair.getSecond();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    @NotNull
    public Pair<Integer, String>[] getAllAlias() {
        return sAliasActivityNames;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public int getNowIconId() {
        return VasMMKV.INSTANCE.getAppIcon().decodeInt("now_id", 0);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public int getPrepareIconId() {
        return VasMMKV.INSTANCE.getAppIcon().decodeInt("prepare_id", 0);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    @NotNull
    public ComponentName getSplashActivityComponent(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (isUseAppIcon()) {
            i3 = getNowIconId();
        } else {
            i3 = 0;
        }
        String aliasActivityName = getAliasActivityName(i3);
        if (aliasActivityName == null) {
            aliasActivityName = sAliasActivityNames[0].getSecond();
        }
        return new ComponentName(context, aliasActivityName);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    @NotNull
    public String getSplashActivityName() {
        int i3;
        if (isUseAppIcon()) {
            i3 = getNowIconId();
        } else {
            i3 = 0;
        }
        String aliasActivityName = getAliasActivityName(i3);
        if (aliasActivityName == null) {
            return sAliasActivityNames[0].getSecond();
        }
        return aliasActivityName;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public int isSupport(int id5) {
        List split$default;
        List list;
        List split$default2;
        List list2;
        Object obj;
        Object obj2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28) {
            VasLogReporter.INSTANCE.getAppIcon().reportLow("not supprt api=" + i3);
            return 3;
        }
        if (getAliasActivityName(id5) == null) {
            VasLogReporter.INSTANCE.getAppIcon().reportLow("id[" + id5 + "] not exist");
            return 2;
        }
        String model = DeviceInfoMonitor.getModel();
        String valueOf = String.valueOf(i3);
        ToggleProxy toggleProxy = VasToggle.APP_ICON_BLACK_LIST;
        String stringDataSet = toggleProxy.getStringDataSet("model", "");
        Intrinsics.checkNotNull(stringDataSet);
        split$default = StringsKt__StringsKt.split$default((CharSequence) stringDataSet, new String[]{";"}, false, 0, 6, (Object) null);
        list = CollectionsKt___CollectionsKt.toList(split$default);
        String stringDataSet2 = toggleProxy.getStringDataSet(DTConstants.TAG.API, "");
        Intrinsics.checkNotNull(stringDataSet2);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) stringDataSet2, new String[]{";"}, false, 0, 6, (Object) null);
        list2 = CollectionsKt___CollectionsKt.toList(split$default2);
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (Intrinsics.areEqual((String) obj2, model)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        if (obj2 == null) {
            Iterator it5 = list2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (Intrinsics.areEqual((String) next, valueOf)) {
                    obj = next;
                    break;
                }
            }
            if (obj == null) {
                return 0;
            }
        }
        VasLogReporter.INSTANCE.getAppIcon().reportLow("model[" + model + "] api[" + valueOf + "] is not support");
        return 3;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public boolean isTestMode() {
        return VasMMKV.INSTANCE.getAppIcon().decodeBool("test_mode", false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public boolean isUseAppIcon() {
        return VasMMKV.INSTANCE.getAppIcon().decodeBool(TransFileControllerImpl.VALUE_USE_PRE_CONN, false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public void setNowIconId(int id5) {
        VasLogReporter.INSTANCE.getAppIcon().reportHighest("setNowIconId " + id5);
        VasMMKV.INSTANCE.getAppIcon().encodeInt("now_id", id5);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public void setPrepareIconId(int id5) {
        VasLogReporter.INSTANCE.getAppIcon().reportHighest("setPrepareIconId " + id5);
        VasMMKV.INSTANCE.getAppIcon().encodeInt("prepare_id", id5);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public void setTestMode(boolean b16) {
        VasLogReporter.INSTANCE.getAppIcon().reportHighest("setTestMode " + b16);
        VasMMKV.INSTANCE.getAppIcon().encodeBool("test_mode", b16);
        VasUtil.getService().getAppIconSwitchManager().checkAndSwitchIcon(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconStateManager
    public void setUseAppIcon(boolean b16) {
        VasLogReporter.INSTANCE.getAppIcon().reportHighest("setUseAppIcon");
        VasMMKV.INSTANCE.getAppIcon().encodeBool(TransFileControllerImpl.VALUE_USE_PRE_CONN, b16);
    }
}
