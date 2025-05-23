package eo;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.util.i;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Leo/c;", "", "", "b", "", "a", "c", "Ljava/lang/String;", "publishId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f396879a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String publishId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Leo/c$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements IDynamicParams {
        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            if (Intrinsics.areEqual(event, "clck")) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, c.f396879a.c());
            }
            return hashMap;
        }
    }

    c() {
    }

    public final void a() {
        publishId = "";
        i.b().r("key_qzone_publish_id", "");
    }

    public final String b() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "android_qzone_publish_id_%d_%d_%d", Arrays.copyOf(new Object[]{Long.valueOf(LoginData.getInstance().getUin()), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100))}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        publishId = format;
        i.b().r("key_qzone_publish_id", publishId);
        return publishId;
    }

    public final String c() {
        String j3 = i.b().j("key_qzone_publish_id", "");
        Intrinsics.checkNotNullExpressionValue(j3, "g().getString(KEY_QZONE_PUBLISH_ID, \"\")");
        return j3;
    }
}
