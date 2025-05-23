package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PluginData;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "packageName", PushClientConstants.TAG_CLASS_NAME, "c", "getPluginName", "pluginName", "d", "getPluginApk", "pluginApk", "e", "uin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class PluginData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String packageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String className;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pluginName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pluginApk;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    public PluginData(String packageName, String className, String pluginName, String pluginApk, String uin) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(pluginApk, "pluginApk");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.packageName = packageName;
        this.className = className;
        this.pluginName = pluginName;
        this.pluginApk = pluginApk;
        this.uin = uin;
    }

    /* renamed from: a, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: b, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (((((((this.packageName.hashCode() * 31) + this.className.hashCode()) * 31) + this.pluginName.hashCode()) * 31) + this.pluginApk.hashCode()) * 31) + this.uin.hashCode();
    }

    public String toString() {
        return "PluginData(packageName=" + this.packageName + ", className=" + this.className + ", pluginName=" + this.pluginName + ", pluginApk=" + this.pluginApk + ", uin=" + this.uin + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PluginData)) {
            return false;
        }
        PluginData pluginData = (PluginData) other;
        return Intrinsics.areEqual(this.packageName, pluginData.packageName) && Intrinsics.areEqual(this.className, pluginData.className) && Intrinsics.areEqual(this.pluginName, pluginData.pluginName) && Intrinsics.areEqual(this.pluginApk, pluginData.pluginApk) && Intrinsics.areEqual(this.uin, pluginData.uin);
    }
}
