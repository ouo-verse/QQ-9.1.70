package nf4;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public boolean f420106a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f420107b;

    /* renamed from: c, reason: collision with root package name */
    public String f420108c;

    @NonNull
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("LiveRoomGameLaunchInfo{");
        stringBuffer.append("  hasLaunchGameSuccess='");
        stringBuffer.append(this.f420106a);
        stringBuffer.append('\'');
        stringBuffer.append(", schemeUrl='");
        stringBuffer.append(this.f420107b);
        stringBuffer.append('\'');
        stringBuffer.append("liveLaunchId='");
        stringBuffer.append(this.f420108c);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }
}
