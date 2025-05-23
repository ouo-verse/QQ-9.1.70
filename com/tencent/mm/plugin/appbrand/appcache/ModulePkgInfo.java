package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.j;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.io.FileNotFoundException;
import java.util.Arrays;

/* loaded from: classes9.dex */
public class ModulePkgInfo implements Parcelable, Cloneable, j {
    public static final Parcelable.Creator<ModulePkgInfo> CREATOR = new a();
    public static final String GAME_PLUGIN_SCRIPT = "/plugin.js";
    public static final String MAIN_MODULE_NAME = "__APP__";
    public static final String MODULE_WITHOUT_MULTI_PLUGIN_CODE = "__WITHOUT_MULTI_PLUGINCODE__";
    public static final String MODULE_WITHOUT_PLUGIN_CODE = "__WITHOUT_PLUGINCODE__";
    public static final String PLUGINCODE_ORIGIN_PREFIX = "__plugin__/";
    public static final String PLUGINCODE_PREFIX = "/__plugin__/";
    public static final String PLUGIN_CODE = "__PLUGINCODE__";
    public String[] aliases;
    public boolean independent;
    public String md5;
    public String name;
    public volatile String pkgPath;
    public int pkgVersion;

    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModulePkgInfo createFromParcel(Parcel parcel) {
            return new ModulePkgInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModulePkgInfo[] newArray(int i3) {
            return new ModulePkgInfo[i3];
        }
    }

    public /* synthetic */ ModulePkgInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void assignFrom(ModulePkgInfo modulePkgInfo) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        modulePkgInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
    }

    public String checksumMd5() {
        return this.md5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getPkgSize() throws FileNotFoundException {
        if (x.d(this.pkgPath)) {
            v vVar = new v(this.pkgPath);
            if (vVar.q() && vVar.a()) {
                return vVar.s();
            }
            return 0L;
        }
        throw new FileNotFoundException();
    }

    public boolean isAssignable(ModulePkgInfo modulePkgInfo) {
        return this.name.equals(modulePkgInfo.name);
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public long lastModified() {
        if (x.d(this.pkgPath)) {
            return x.f(this.pkgPath);
        }
        return 0L;
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public String pkgPath() {
        return this.pkgPath;
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public int pkgVersion() {
        return this.pkgVersion;
    }

    @CallSuper
    public void readFromParcel(Parcel parcel) {
        boolean z16;
        this.pkgPath = parcel.readString();
        this.name = parcel.readString();
        this.md5 = parcel.readString();
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.independent = z16;
        this.aliases = parcel.createStringArray();
    }

    public String toString() {
        return "ModulePkgInfo{name='" + this.name + "', md5='" + this.md5 + "', independent=" + this.independent + ", aliases=" + Arrays.toString(this.aliases) + ", pkgVersion=" + this.pkgVersion + ", pkgPath='" + this.pkgPath + "'}";
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.pkgPath);
        parcel.writeString(this.name);
        parcel.writeString(this.md5);
        parcel.writeByte(this.independent ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.aliases);
    }

    public ModulePkgInfo() {
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ModulePkgInfo m163clone() {
        ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
        modulePkgInfo.assignFrom(this);
        return modulePkgInfo;
    }

    ModulePkgInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
