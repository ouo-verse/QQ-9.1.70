package com.tencent.mobileqq.zplan.model;

import androidx.annotation.Keep;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0006\u0010\u001b\u001a\u00020\u0017J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "", "appid", "", "appidExist", "", "phonePass", "uinPass", "allPass", "switchPass", "entranceType", "settingPass", "(JIIIIIII)V", "getAllPass", "()I", "getAppid", "()J", "getAppidExist", "getEntranceType", "getPhonePass", "getSwitchPass", "getUinPass", "isAbiSupported", "", "isAccessible", "isDevicePass", "isDeviceTypeEnable", "isPassWithoutSetting", "toString", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class AccessibleDetail {
    private final int allPass;
    private final long appid;
    private final int appidExist;
    private final int entranceType;
    private final int phonePass;

    @JvmField
    public int settingPass;
    private final int switchPass;
    private final int uinPass;

    public AccessibleDetail(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.appid = j3;
        this.appidExist = i3;
        this.phonePass = i16;
        this.uinPass = i17;
        this.allPass = i18;
        this.switchPass = i19;
        this.entranceType = i26;
        this.settingPass = i27;
    }

    private final boolean isAbiSupported() {
        return com.tencent.mobileqq.soload.util.e.d();
    }

    private final boolean isDeviceTypeEnable() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableZPlanFold();
        }
        return true;
    }

    public final int getAllPass() {
        return this.allPass;
    }

    public final long getAppid() {
        return this.appid;
    }

    public final int getAppidExist() {
        return this.appidExist;
    }

    public final int getEntranceType() {
        return this.entranceType;
    }

    public final int getPhonePass() {
        return this.phonePass;
    }

    public final int getSwitchPass() {
        return this.switchPass;
    }

    public final int getUinPass() {
        return this.uinPass;
    }

    public final boolean isAccessible() {
        if (isPassWithoutSetting() && this.settingPass == 1) {
            return true;
        }
        return false;
    }

    public final boolean isDevicePass() {
        if (this.phonePass == 1 && isAbiSupported() && isDeviceTypeEnable()) {
            return true;
        }
        return false;
    }

    public final boolean isPassWithoutSetting() {
        if (this.uinPass == 1 && this.switchPass == 1 && isDevicePass()) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "AccessibleDetail {appid=" + this.appid + ", appidExist=" + this.appidExist + ", phonePass=" + this.phonePass + ", uinPass=" + this.uinPass + ", allPass=" + this.allPass + ", switchPass=" + this.switchPass + ", settingPass=" + this.settingPass + ", isAbiSupported=" + isAbiSupported() + ", entranceType=" + this.entranceType + ", isDeviceTypeEnable=" + isDeviceTypeEnable() + '}';
    }

    public /* synthetic */ AccessibleDetail(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, i16, i17, i18, i19, i26, (i28 & 128) != 0 ? 0 : i27);
    }
}
