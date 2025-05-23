package com.tencent.robot.adelie.homepage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.robot.adelie.homepage.create.PageDataInfo;
import com.tencent.robot.qqmc.RobotQQMC;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/n;", "", "Landroid/content/Context;", "context", "", "url", "", "f", ISchemeApi.KEY_REFERER, "extInfo", "d", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MyBotInfo;", "myBotInfo", "c", "pageName", "uid", "a", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f366680a = new n();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/n$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "adelie", "Ljava/lang/String;", "getAdelie", "()Ljava/lang/String;", "adelieCompose", "a", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.utils.n$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class KuiklySchemeConfig {

        @SerializedName("adelie")
        @NotNull
        private final String adelie;

        @SerializedName("adelie_compose")
        @NotNull
        private final String adelieCompose;

        public KuiklySchemeConfig() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAdelieCompose() {
            return this.adelieCompose;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KuiklySchemeConfig)) {
                return false;
            }
            KuiklySchemeConfig kuiklySchemeConfig = (KuiklySchemeConfig) other;
            if (Intrinsics.areEqual(this.adelie, kuiklySchemeConfig.adelie) && Intrinsics.areEqual(this.adelieCompose, kuiklySchemeConfig.adelieCompose)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.adelie.hashCode() * 31) + this.adelieCompose.hashCode();
        }

        @NotNull
        public String toString() {
            return "KuiklySchemeConfig(adelie=" + this.adelie + ", adelieCompose=" + this.adelieCompose + ")";
        }

        public KuiklySchemeConfig(@NotNull String adelie, @NotNull String adelieCompose) {
            Intrinsics.checkNotNullParameter(adelie, "adelie");
            Intrinsics.checkNotNullParameter(adelieCompose, "adelieCompose");
            this.adelie = adelie;
            this.adelieCompose = adelieCompose;
        }

        public /* synthetic */ KuiklySchemeConfig(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "mqqapi://kuikly/open?local_bundle_name=adelie&version=1&src_type=web" : str, (i3 & 2) != 0 ? "mqqapi://kuikly/open?local_bundle_name=nearbypro&version=1&src_type=web&use_host_display_metrics=1" : str2);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366681a;

        static {
            int[] iArr = new int[BotGender.values().length];
            try {
                iArr[BotGender.KDEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BotGender.KMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BotGender.KFEMALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BotGender.KOTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f366681a = iArr;
        }
    }

    n() {
    }

    @NotNull
    public final String a(@NotNull String pageName, @NotNull String uid) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(uid, "uid");
        return RobotQQMC.INSTANCE.getAdelieKuiklyScheme().getAdelieCompose() + "&page_name=" + pageName + "&uid=" + uid;
    }

    @NotNull
    public final String b(@NotNull String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return RobotQQMC.INSTANCE.getAdelieKuiklyScheme().getAdelieCompose() + "&page_name=" + pageName;
    }

    @NotNull
    public final String c(@NotNull MyBotInfo myBotInfo) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(myBotInfo, "myBotInfo");
        BotGender botGender = myBotInfo.botGender;
        if (botGender == null) {
            i3 = -1;
        } else {
            i3 = b.f366681a[botGender.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        str = "3";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = "2";
                }
            } else {
                str = "1";
            }
        } else {
            str = "0";
        }
        return RobotQQMC.INSTANCE.getAdelieKuiklyScheme().getAdelieCompose() + "&page_name=adelie_tts_setting_page&tts_id=" + myBotInfo.ttsId + "&bot_name=" + myBotInfo.botName + "&bot_prompt=" + myBotInfo.botPrompt + "&bot_welcome=" + myBotInfo.botWelcomeMsg + "&bot_desc=" + myBotInfo.botDesc + "&gender=" + str;
    }

    @NotNull
    public final String d(@NotNull String referer, @NotNull String extInfo) {
        String str;
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        try {
            str = URLEncoder.encode(new Gson().toJson(new PageDataInfo(extInfo, null, null, 6, null)));
            Intrinsics.checkNotNullExpressionValue(str, "encode(json)");
        } catch (Exception e16) {
            QLog.e("SchemeUtil", 1, "getCreateScheme exception = " + e16);
            str = "";
        }
        return "mqqapi://adelie/creation?version=1&src_type=app&referer=" + referer + "&pageData=" + str;
    }

    @NotNull
    public final String e() {
        return "mqqapi://adelie/botcenter";
    }

    public final void f(@NotNull Context context, @NotNull String url) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (URLUtil.isNetworkUrl(url)) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("url", url);
            context.startActivity(intent);
            return;
        }
        ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context, url);
        if (c16 != null) {
            c16.b();
        }
    }
}
