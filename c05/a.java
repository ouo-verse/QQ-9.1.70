package c05;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f30208a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f30209b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final String f30210c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final String f30211d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final String f30212e;

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        this.f30210c = str;
        this.f30208a = str2;
        this.f30212e = str3;
        this.f30211d = str4;
        this.f30209b = str5;
    }

    @WorkerThread
    public final void a(@NonNull HashMap hashMap) {
        String md5 = XhsShareSdkTools.md5(this.f30208a + this.f30210c + this.f30209b);
        hashMap.put("app_package", this.f30208a);
        hashMap.put("timestamp", this.f30209b);
        hashMap.put("token", md5);
        hashMap.put("sdk_version", this.f30211d);
        hashMap.put("app_version", this.f30212e);
    }
}
