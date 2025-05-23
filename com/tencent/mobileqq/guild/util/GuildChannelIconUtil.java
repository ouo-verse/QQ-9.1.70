package com.tencent.mobileqq.guild.util;

import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J,\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007J0\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fH\u0007J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bH\u0007J$\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0014j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002JM\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fR7\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0014j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildChannelIconUtil;", "", "Landroid/widget/ImageView;", "iv", "", "channelId", "", ReportConstant.COSTREPORT_PREFIX, "", "channelType", "channelSubId", "Lcom/tencent/mobileqq/guild/theme/b;", "channelIconStyleProvider", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "atType", "Lkotlin/Function1;", "onRetrieveChannelType", "c", "defaultId", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", DomainData.DOMAIN_NAME, "textChannelSubtypeId", "e", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)I", "k", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/HashMap;", "channelIconType", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelIconUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildChannelIconUtil f235331a = new GuildChannelIconUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelIconType;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Integer, Integer>>() { // from class: com.tencent.mobileqq.guild.util.GuildChannelIconUtil$channelIconType$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Integer, Integer> invoke() {
                HashMap<Integer, Integer> b16;
                b16 = GuildChannelIconUtil.f235331a.b();
                return b16;
            }
        });
        channelIconType = lazy;
    }

    GuildChannelIconUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<Integer, Integer> b() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(2, Integer.valueOf(R.drawable.guild_channel_voice_p));
        hashMap.put(5, Integer.valueOf(R.drawable.guild_channel_video_p));
        hashMap.put(6, Integer.valueOf(R.drawable.guild_channel_app_p));
        hashMap.put(7, Integer.valueOf(R.drawable.guild_channel_feeds_p));
        hashMap.put(1, Integer.valueOf(R.drawable.guild_channel_text_chat_p));
        Integer num = hashMap.get(1);
        Intrinsics.checkNotNull(num);
        hashMap.put(100, num);
        Integer num2 = hashMap.get(1);
        Intrinsics.checkNotNull(num2);
        hashMap.put(101, num2);
        Integer num3 = hashMap.get(1);
        Intrinsics.checkNotNull(num3);
        hashMap.put(102, num3);
        Integer num4 = hashMap.get(1);
        Intrinsics.checkNotNull(num4);
        hashMap.put(103, num4);
        return hashMap;
    }

    @JvmStatic
    @DrawableRes
    public static final int c(@NotNull String channelId, int atType, @Nullable Function1<? super Integer, Unit> onRetrieveChannelType) {
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        GuildChannelIconUtil guildChannelIconUtil = f235331a;
        IGProChannelInfo channelInfo = guildChannelIconUtil.n().getChannelInfo(channelId);
        if (channelInfo != null) {
            num = Integer.valueOf(channelInfo.getType());
        } else {
            num = null;
        }
        if (channelInfo != null) {
            num2 = Integer.valueOf(channelInfo.getTextChannelSubtypeId());
        } else {
            num2 = null;
        }
        return guildChannelIconUtil.e(channelId, atType, num, num2, onRetrieveChannelType);
    }

    public static /* synthetic */ int d(String str, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        return c(str, i3, function1);
    }

    public static /* synthetic */ int f(GuildChannelIconUtil guildChannelIconUtil, String str, int i3, Integer num, Integer num2, Function1 function1, int i16, Object obj) {
        Integer num3;
        Integer num4;
        Function1 function12;
        if ((i16 & 4) != 0) {
            num3 = null;
        } else {
            num3 = num;
        }
        if ((i16 & 8) != 0) {
            num4 = null;
        } else {
            num4 = num2;
        }
        if ((i16 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return guildChannelIconUtil.e(str, i3, num3, num4, function12);
    }

    @JvmStatic
    @DrawableRes
    @JvmOverloads
    public static final int g(int i3) {
        return j(i3, 0, 0, 6, null);
    }

    @JvmStatic
    @DrawableRes
    @JvmOverloads
    public static final int h(int i3, int i16) {
        return j(i3, i16, 0, 4, null);
    }

    @JvmStatic
    @DrawableRes
    @JvmOverloads
    public static final int i(int channelType, int channelSubId, int defaultId) {
        if (channelType == 1) {
            GuildChannelIconUtil guildChannelIconUtil = f235331a;
            Integer num = guildChannelIconUtil.m().get(Integer.valueOf(channelSubId + 100));
            if (num == null) {
                Integer num2 = guildChannelIconUtil.m().get(1);
                Intrinsics.checkNotNull(num2);
                num = num2;
            }
            Intrinsics.checkNotNullExpressionValue(num, "{\n            channelIco\u2026EL_TYPE_TEXT]!!\n        }");
            return num.intValue();
        }
        GuildChannelIconUtil guildChannelIconUtil2 = f235331a;
        if (guildChannelIconUtil2.m().keySet().contains(Integer.valueOf(channelType))) {
            Integer num3 = guildChannelIconUtil2.m().get(Integer.valueOf(channelType));
            Intrinsics.checkNotNull(num3);
            Intrinsics.checkNotNullExpressionValue(num3, "{\n            channelIco\u2026[channelType]!!\n        }");
            return num3.intValue();
        }
        return defaultId;
    }

    public static /* synthetic */ int j(int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i16 = 0;
        }
        if ((i18 & 4) != 0) {
            i17 = R.drawable.guild_default_channel_icon;
        }
        return i(i3, i16, i17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int l(GuildChannelIconUtil guildChannelIconUtil, String str, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        return guildChannelIconUtil.k(str, i3, function1);
    }

    private final HashMap<Integer, Integer> m() {
        return (HashMap) channelIconType.getValue();
    }

    private final IGPSService n() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        return (IGPSService) runtimeService;
    }

    @JvmStatic
    @JvmOverloads
    public static final void o(@NotNull ImageView iv5, int i3) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        r(iv5, i3, 0, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void p(@NotNull ImageView iv5, int i3, int i16) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        r(iv5, i3, i16, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void q(@NotNull ImageView iv5, int channelType, int channelSubId, @NotNull com.tencent.mobileqq.guild.theme.b channelIconStyleProvider) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        Intrinsics.checkNotNullParameter(channelIconStyleProvider, "channelIconStyleProvider");
        channelIconStyleProvider.a(iv5, j(channelType, channelSubId, 0, 4, null));
    }

    public static /* synthetic */ void r(ImageView imageView, int i3, int i16, com.tencent.mobileqq.guild.theme.b bVar, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        if ((i17 & 8) != 0) {
            bVar = com.tencent.mobileqq.guild.theme.f.f235302a;
        }
        q(imageView, i3, i16, bVar);
    }

    @JvmStatic
    public static final void s(@NotNull ImageView iv5, @NotNull String channelId) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(iv5, "iv");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        GuildChannelIconUtil guildChannelIconUtil = f235331a;
        IGProChannelInfo channelInfo = guildChannelIconUtil.n().getChannelInfo(channelId);
        if (channelInfo != null) {
            i3 = channelInfo.getType();
        } else {
            i3 = 1;
        }
        int i18 = i3;
        int i19 = 0;
        if (channelInfo != null) {
            i16 = channelInfo.getTextChannelSubtypeId();
        } else {
            i16 = 0;
        }
        if (i18 == 6 && channelInfo != null) {
            IGProAppChnnPreInfo appChnnPreInfo = guildChannelIconUtil.n().getAppChnnPreInfo(channelInfo.getGuildId(), channelId);
            if (appChnnPreInfo != null) {
                i19 = (int) appChnnPreInfo.getAppid();
            }
            i17 = i19;
        } else {
            i17 = i16;
        }
        r(iv5, i18, i17, null, 8, null);
    }

    public final int e(@NotNull String channelId, int atType, @Nullable Integer channelType, @Nullable Integer textChannelSubtypeId, @Nullable Function1<? super Integer, Unit> onRetrieveChannelType) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (atType == HashTagViewType.VIEW_TYPE_FEED_SQUARE.getValue()) {
            i3 = 7;
        } else if (channelType != null) {
            i3 = channelType.intValue();
        } else {
            i3 = 0;
        }
        if (onRetrieveChannelType != null) {
            onRetrieveChannelType.invoke(Integer.valueOf(i3));
        }
        if (textChannelSubtypeId != null) {
            i16 = textChannelSubtypeId.intValue();
        } else {
            i16 = 0;
        }
        QLog.i("GuildChannelIconUtil", 1, "channelId:" + channelId + " atType:" + atType + " channelType:" + channelType);
        return j(i3, i16, 0, 4, null);
    }

    public final int k(@NotNull String channelId, int atType, @Nullable Function1<? super Integer, Unit> onRetrieveChannelType) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        IGProChannelInfo channelInfo = n().getChannelInfo(channelId);
        if (atType == HashTagViewType.VIEW_TYPE_FEED_SQUARE.getValue() && channelInfo == null) {
            i3 = 7;
        } else if (channelInfo != null) {
            i3 = channelInfo.getType();
        } else {
            i3 = 0;
        }
        if (onRetrieveChannelType != null) {
            onRetrieveChannelType.invoke(Integer.valueOf(i3));
        }
        if (channelInfo != null) {
            i16 = channelInfo.getTextChannelSubtypeId();
        } else {
            i16 = 0;
        }
        return j(i3, i16, 0, 4, null);
    }
}
