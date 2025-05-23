package dc1;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    ChatMessage f393560a = null;

    /* renamed from: b, reason: collision with root package name */
    SessionInfo f393561b = null;

    /* renamed from: c, reason: collision with root package name */
    boolean f393562c = false;

    /* renamed from: d, reason: collision with root package name */
    boolean f393563d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f393564e = true;

    /* renamed from: f, reason: collision with root package name */
    boolean f393565f = true;

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public ChatMessage c() {
        return null;
    }

    public abstract Intent d();

    public SessionInfo e() {
        return this.f393561b;
    }

    public boolean f() {
        return this.f393565f;
    }

    public boolean g() {
        return this.f393562c;
    }

    public boolean h() {
        return this.f393563d;
    }

    public boolean i() {
        return this.f393564e;
    }

    public boolean j() {
        return false;
    }

    public void l(boolean z16) {
        this.f393564e = z16;
    }

    public void k(Bundle bundle) {
    }
}
