package com.tencent.zplan.record.provider.helper;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import lx4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/a;", "", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "Lcom/tencent/zplan/meme/model/MemeResult;", "memeResult", "", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.provider.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10070a {
        @NotNull
        public static String a(@NotNull a aVar, @NotNull String removeUrlHost) {
            String replace$default;
            Intrinsics.checkNotNullParameter(removeUrlHost, "$this$removeUrlHost");
            URL url = new URL(removeUrlHost);
            String host = url.getHost();
            replace$default = StringsKt__StringsJVMKt.replace$default(removeUrlHost, url.getProtocol() + QzoneWebViewOfflinePlugin.STR_DEVIDER + host, "", false, 4, (Object) null);
            return replace$default;
        }

        public static void b(@NotNull a aVar, @NotNull String senderUin, long j3, int i3, @NotNull String target, boolean z16, @Nullable String str, boolean z17, @Nullable String str2, @Nullable Map<String, String> map) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(senderUin, "senderUin");
            Intrinsics.checkNotNullParameter(target, "target");
            Pair[] pairArr = new Pair[9];
            b.Companion companion = lx4.b.INSTANCE;
            pairArr[0] = TuplesKt.to("success", companion.a(z16));
            pairArr[1] = TuplesKt.to(AppConstants.Key.COLUMN_MSG_SENDER_UIN, senderUin);
            pairArr[2] = TuplesKt.to("resId", String.valueOf(j3));
            pairArr[3] = TuplesKt.to("scene", String.valueOf(i3));
            pairArr[4] = TuplesKt.to("target", target);
            if (str == null) {
                str = "";
            }
            pairArr[5] = TuplesKt.to("uploadUrl", str);
            pairArr[6] = TuplesKt.to("isSuperQQShowBackend", companion.a(z17));
            pairArr[7] = TuplesKt.to("timeMs", String.valueOf(System.currentTimeMillis()));
            pairArr[8] = TuplesKt.to("dressKey", String.valueOf(str2));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            if (map != null) {
                mutableMapOf.putAll(map);
            }
            lx4.b bVar = (lx4.b) mx4.a.f417748a.a(lx4.b.class);
            if (bVar != null) {
                b.C10752b.a(bVar, null, "zplan_local_upload", mutableMapOf, 1, null);
            }
        }
    }

    void a(@NotNull ZPlanRecordResource resource, @NotNull MemeResult memeResult);
}
