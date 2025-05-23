package lc;

import com.qzone.publish.ui.activity.QZonePublishMoodRealActivity;
import com.qzone.reborn.albumx.qzonex.activity.QZonePublishXMoodRealActivity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007\u00a8\u0006\u000b"}, d2 = {"Llc/b;", "", "Ljava/lang/Class;", "b", "", "a", "c", "", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f414335a = new b();

    b() {
    }

    @JvmStatic
    public static final String a() {
        String str;
        if (d()) {
            str = "/qzone/publish_mood_new";
        } else {
            str = "/qzone/publish_mood";
        }
        QLog.d("QZPublishX_QZPublishXConfigManager", 1, "getPublishMoodActivityPath path=" + str);
        return str;
    }

    @JvmStatic
    public static final Class<?> b() {
        Class<?> cls;
        if (d()) {
            cls = QZonePublishXMoodRealActivity.class;
        } else {
            cls = QZonePublishMoodRealActivity.class;
        }
        QLog.d("QZPublishX_QZPublishXConfigManager", 1, "getPublishShuoShuoActivityClass clazz=" + cls);
        return cls;
    }

    @JvmStatic
    public static final String c() {
        return "/qzone/upload_photo";
    }

    @JvmStatic
    public static final boolean d() {
        if (com.qzone.reborn.configx.g.f53821a.e().j()) {
            QLog.d("QZPublishX_QZPublishXConfigManager", 1, "isOpenQZPublishX  is close cangLanSwitch");
            return false;
        }
        return com.qzone.reborn.albumx.qzonex.utils.d.a();
    }
}
