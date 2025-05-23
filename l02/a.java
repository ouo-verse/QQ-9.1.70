package l02;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f413574a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f413575b;

    /* renamed from: c, reason: collision with root package name */
    private final IShareActionHelper f413576c = (IShareActionHelper) QRoute.api(IShareActionHelper.class);

    public a(@NonNull Activity activity, @NonNull String str) {
        this.f413574a = str;
        this.f413575b = activity;
    }

    public void a() {
        this.f413576c.doShareTextBySelect("guildShare", this.f413575b, this.f413574a);
    }

    public void b(String str, int i3) {
        this.f413576c.doShareTextDirectly("guildShare", this.f413575b, this.f413574a, i3, str);
    }

    public void c() {
        this.f413576c.doSharTextToWeChat("guildShare", 9, this.f413575b, String.valueOf(System.currentTimeMillis()), this.f413574a);
    }
}
