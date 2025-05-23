package com.tencent.mobileqq.guild.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00062\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/config/l;", "", "", "<set-?>", "a", "Z", "c", "()Z", "enableDiscoverWeb", "b", "d", "enableMainFrameWeb", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean enableDiscoverWeb;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean enableMainFrameWeb;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/config/l$a;", "", "Lcom/tencent/mobileqq/guild/config/l;", "bean", "Lorg/json/JSONObject;", "jsonObj", "", "b", "", "a", "", "ENABLE_DISCOVER_WEB", "Ljava/lang/String;", "ENABLE_MAINFRAME_WEB", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.l$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (jsonObj.has("enable_discover_web") && jsonObj.has("enable_mainframe_web")) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void b(@NotNull l bean, @NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            bean.enableDiscoverWeb = jsonObj.optBoolean("enable_discover_web", false);
            bean.enableMainFrameWeb = jsonObj.optBoolean("enable_mainframe_web", false);
            QLog.i("GuildMainWebConfBean", 1, "parseFromJson complete. shareContent = " + jsonObj + ",enableDiscoverWeb " + bean.getEnableDiscoverWeb() + " ,enableMainFrameWeb " + bean.getEnableMainFrameWeb());
        }

        Companion() {
        }
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableDiscoverWeb() {
        return this.enableDiscoverWeb;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnableMainFrameWeb() {
        return this.enableMainFrameWeb;
    }
}
