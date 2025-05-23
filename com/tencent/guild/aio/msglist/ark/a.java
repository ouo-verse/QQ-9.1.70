package com.tencent.guild.aio.msglist.ark;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/a;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f111200b = ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).isOptimizeEnable();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/a$a;", "", "", "appName", QQCustomArkDialogUtil.APP_VIEW, "arkDataJson", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.ark.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@NotNull String appName, @NotNull String appView, @NotNull String arkDataJson) {
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(appView, "appView");
            Intrinsics.checkNotNullParameter(arkDataJson, "arkDataJson");
            if (TextUtils.equals(appName, "com.tencent.qun.pro") && TextUtils.equals(appView, "contact")) {
                try {
                    JSONObject optJSONObject = new JSONObject(arkDataJson).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
                    Integer num = null;
                    if (optJSONObject != null) {
                        jSONObject = optJSONObject.optJSONObject("contact");
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        num = Integer.valueOf(jSONObject.optInt("ark_type"));
                    }
                    Intrinsics.checkNotNull(num);
                    return num.intValue();
                } catch (Exception e16) {
                    QLog.e("GuildArkComponent", 1, "getQunProShareArkType e: " + e16.getMessage());
                }
            }
            return 0;
        }

        Companion() {
        }
    }
}
