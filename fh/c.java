package fh;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.util.aa;
import cooperation.qzone.report.QZonePushReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lfh/c;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f398667a = new c();

    c() {
    }

    @JvmStatic
    public static final void a(BusinessFeedData feedData) {
        User user;
        HashMap hashMap = new HashMap();
        hashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_grab");
        Comment f16 = aa.f(feedData);
        hashMap.put("touin", Long.valueOf((f16 == null || (user = f16.user) == null) ? 0L : user.uin));
        fo.c.c("ev_qz_grab_click", hashMap);
    }

    @JvmStatic
    public static final void b(BusinessFeedData feedData) {
        User user;
        HashMap hashMap = new HashMap();
        hashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_grab");
        Comment f16 = aa.f(feedData);
        hashMap.put("touin", Long.valueOf((f16 == null || (user = f16.user) == null) ? 0L : user.uin));
        fo.c.c("ev_qz_grab_imp", hashMap);
    }
}
