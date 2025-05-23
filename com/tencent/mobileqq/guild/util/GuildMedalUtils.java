package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bY\u0010ZJ(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\f\u0010\f\u001a\u00020\n*\u00020\u0003H\u0002J\f\u0010\u000e\u001a\u00020\r*\u00020\u0003H\u0002J\u0087\u0001\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00052%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019H\u0002JV\u0010\"\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002JG\u0010+\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019H\u0007J \u0010,\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0007J \u0010-\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0007J \u0010.\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0007J \u0010/\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0007JO\u00101\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\u0006\u00100\u001a\u00020\u00052%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019H\u0002J(\u00106\u001a\u00020(2\u0006\u0010'\u001a\u00020&2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0002J&\u0010;\u001a\u00020\n2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002Jo\u0010<\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u00052%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019J0\u0010@\u001a\u00020?2\u0006\u0010=\u001a\u00020\r2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0005R\u0017\u0010E\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010G\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b1\u0010B\u001a\u0004\bF\u0010DR\u0017\u0010J\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\bH\u0010B\u001a\u0004\bI\u0010DR\u0017\u0010L\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b,\u0010B\u001a\u0004\bK\u0010DR\u0017\u0010N\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b-\u0010B\u001a\u0004\bM\u0010DR\u0014\u0010O\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010BR\u0014\u0010Q\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010BR\u0014\u0010R\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010BR\u0017\u0010T\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b.\u0010B\u001a\u0004\bS\u0010DR\u0017\u0010V\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010B\u001a\u0004\bU\u0010DR\u0017\u0010X\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010B\u001a\u0004\bW\u0010D\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildMedalUtils;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalList", "", "maxCount", ReportConstant.COSTREPORT_PREFIX, "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "k", "l", "", "p", "guildName", "Landroid/widget/TextView;", "guildNameTextView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "highlightWords", "highLightColorRes", "Lwt1/f;", "officialIconSpan", "officialIconWidth", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ellipsizeGuildName", "", "onEllipsizeGuildNameUpdate", HippyTKDListViewAdapter.X, "officialMedalSpan", "Landroid/text/SpannableStringBuilder;", DomainData.DOMAIN_NAME, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "medalInfo", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "imageView", com.tencent.luggage.wxa.ye.d.NAME, "g", "e", "f", "j", "i", "officialIconHeight", "c", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "iconWidth", "iconHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "word", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "list1", "list2", "u", "v", "originString", "keyWords", "Landroid/text/SpannableString;", "o", "b", "I", "r", "()I", "NORMAL_MEDAL_SIZE", "getOFFICIAL_MEDAL_WIDTH", "OFFICIAL_MEDAL_WIDTH", "d", "getMEDAL_PADDING_WIDTH", "MEDAL_PADDING_WIDTH", "getFLOAT_TITLE_OFFICIAL_MEDAL_WIDTH", "FLOAT_TITLE_OFFICIAL_MEDAL_WIDTH", "getFLOAT_TITLE_OFFICIAL_MEDAL_HEIGHT", "FLOAT_TITLE_OFFICIAL_MEDAL_HEIGHT", "GUILD_HOME_V2_MEDAL_PADDING_WIDTH", tl.h.F, "GUILD_HOME_V2_OFFICIAL_MEDAL_WIDTH", "GUILD_HOME_V2_OFFICIAL_MEDAL_HEIGHT", "getGUILD_VISITOR_V2_MEDAL_PADDING_WIDTH", "GUILD_VISITOR_V2_MEDAL_PADDING_WIDTH", "getGUILD_VISITOR_V2_OFFICIAL_MEDAL_WIDTH", "GUILD_VISITOR_V2_OFFICIAL_MEDAL_WIDTH", "getGUILD_VISITOR_V2_OFFICIAL_MEDAL_HEIGHT", "GUILD_VISITOR_V2_OFFICIAL_MEDAL_HEIGHT", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMedalUtils {

    /* renamed from: a */
    @NotNull
    public static final GuildMedalUtils f235347a = new GuildMedalUtils();

    /* renamed from: b, reason: from kotlin metadata */
    private static final int NORMAL_MEDAL_SIZE = QQGuildUIUtil.f(18.0f);

    /* renamed from: c, reason: from kotlin metadata */
    private static final int OFFICIAL_MEDAL_WIDTH = an.INSTANCE.c();

    /* renamed from: d, reason: from kotlin metadata */
    private static final int MEDAL_PADDING_WIDTH = QQGuildUIUtil.f(5.0f);

    /* renamed from: e, reason: from kotlin metadata */
    private static final int FLOAT_TITLE_OFFICIAL_MEDAL_WIDTH = QQGuildUIUtil.f(32.0f);

    /* renamed from: f, reason: from kotlin metadata */
    private static final int FLOAT_TITLE_OFFICIAL_MEDAL_HEIGHT = QQGuildUIUtil.f(14.0f);

    /* renamed from: g, reason: from kotlin metadata */
    private static final int GUILD_HOME_V2_MEDAL_PADDING_WIDTH = QQGuildUIUtil.f(4.0f);

    /* renamed from: h */
    private static final int GUILD_HOME_V2_OFFICIAL_MEDAL_WIDTH = QQGuildUIUtil.f(36.0f);

    /* renamed from: i, reason: from kotlin metadata */
    private static final int GUILD_HOME_V2_OFFICIAL_MEDAL_HEIGHT = QQGuildUIUtil.f(16.0f);

    /* renamed from: j, reason: from kotlin metadata */
    private static final int GUILD_VISITOR_V2_MEDAL_PADDING_WIDTH = QQGuildUIUtil.f(6.0f);

    /* renamed from: k, reason: from kotlin metadata */
    private static final int GUILD_VISITOR_V2_OFFICIAL_MEDAL_WIDTH = QQGuildUIUtil.f(45.0f);

    /* renamed from: l, reason: from kotlin metadata */
    private static final int GUILD_VISITOR_V2_OFFICIAL_MEDAL_HEIGHT = QQGuildUIUtil.f(20.0f);

    GuildMedalUtils() {
    }

    private final void c(final ViewGroup r75, IGProMedalInfo medalInfo, final Context context, final int officialIconHeight, final Function1<? super ImageView, Unit> r112) {
        if (!medalInfo.getOfficialMedalInfoExt().getIsOffical()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildMedalUtils", 2, "addMedalImageView not official medal");
                return;
            }
            return;
        }
        an.Companion companion = an.INSTANCE;
        String d16 = companion.d();
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildMedalUtils", 2, "addMedalImageView url: " + d16);
        }
        companion.e(new WeakReference<>(r75), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.GuildMedalUtils$addMedalImageView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                invoke(uRLDrawable, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull URLDrawable urlDrawble, int i3) {
                ImageView q16;
                Intrinsics.checkNotNullParameter(urlDrawble, "urlDrawble");
                q16 = GuildMedalUtils.f235347a.q(context, urlDrawble, i3, officialIconHeight);
                Function1<ImageView, Unit> function1 = r112;
                if (function1 != null) {
                    function1.invoke(q16);
                }
                Logger logger3 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger3.d().d("GuildMedalUtils", 2, "addMedalImageView finish");
                }
                r75.addView(q16);
            }
        }, officialIconHeight);
    }

    static /* synthetic */ void d(GuildMedalUtils guildMedalUtils, ViewGroup viewGroup, IGProMedalInfo iGProMedalInfo, Context context, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            function1 = null;
        }
        guildMedalUtils.c(viewGroup, iGProMedalInfo, context, i3, function1);
    }

    @JvmStatic
    public static final void e(@NotNull ViewGroup r95, @NotNull IGProMedalInfo medalInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(r95, "container");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        d(f235347a, r95, medalInfo, context, NORMAL_MEDAL_SIZE, null, 16, null);
    }

    @JvmStatic
    public static final void f(@NotNull ViewGroup r95, @NotNull IGProMedalInfo medalInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(r95, "container");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        d(f235347a, r95, medalInfo, context, FLOAT_TITLE_OFFICIAL_MEDAL_HEIGHT, null, 16, null);
    }

    @JvmStatic
    public static final void g(@NotNull ViewGroup r75, @NotNull IGProMedalInfo medalInfo, @NotNull Context context, @Nullable Function1<? super ImageView, Unit> r102) {
        Intrinsics.checkNotNullParameter(r75, "container");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        f235347a.c(r75, medalInfo, context, NORMAL_MEDAL_SIZE, r102);
    }

    public static /* synthetic */ void h(ViewGroup viewGroup, IGProMedalInfo iGProMedalInfo, Context context, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        g(viewGroup, iGProMedalInfo, context, function1);
    }

    @JvmStatic
    public static final void i(@NotNull ViewGroup r95, @NotNull IGProMedalInfo medalInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(r95, "container");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        d(f235347a, r95, medalInfo, context, GUILD_VISITOR_V2_OFFICIAL_MEDAL_HEIGHT, null, 16, null);
    }

    @JvmStatic
    public static final void j(@NotNull ViewGroup r95, @NotNull IGProMedalInfo medalInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(r95, "container");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        d(f235347a, r95, medalInfo, context, GUILD_HOME_V2_OFFICIAL_MEDAL_HEIGHT, null, 16, null);
    }

    private final boolean k(IGProMedalInfo iGProMedalInfo, long j3) {
        if (iGProMedalInfo.getExpireTime() > 0 && iGProMedalInfo.getExpireTime() < j3) {
            return false;
        }
        return true;
    }

    private final boolean l(IGProMedalInfo iGProMedalInfo) {
        return URLUtil.isValidUrl(p(iGProMedalInfo));
    }

    private final String m(String str) {
        return new Regex("[\\Q!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\\E]").replace(str, "\\\\$0");
    }

    private final SpannableStringBuilder n(String str, List<? extends IGProMedalInfo> list, TextView textView, ArrayList<String> arrayList, @ColorRes int i3, wt1.f fVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (arrayList.size() > 0) {
            spannableStringBuilder = new SpannableStringBuilder(o(str, arrayList, i3));
        }
        Iterator<? extends IGProMedalInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IGProMedalInfo next = it.next();
            spannableStringBuilder.append((CharSequence) ":");
            if (next.getOfficialMedalInfoExt().getIsOffical()) {
                if (fVar != null) {
                    fVar.c(textView);
                }
                spannableStringBuilder.setSpan(fVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            }
        }
        spannableStringBuilder.append(TokenParser.SP);
        return spannableStringBuilder;
    }

    private final String p(IGProMedalInfo iGProMedalInfo) {
        if (iGProMedalInfo.getOfficialMedalInfoExt().getIsOffical()) {
            return an.INSTANCE.d();
        }
        String iconUrl = iGProMedalInfo.getIconUrl();
        Intrinsics.checkNotNullExpressionValue(iconUrl, "{\n            this.iconUrl\n        }");
        return iconUrl;
    }

    public final ImageView q(Context context, URLDrawable uRLDrawable, int i3, int i16) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i16);
        layoutParams.setMarginStart(an.INSTANCE.b());
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(uRLDrawable);
        return imageView;
    }

    @JvmStatic
    @NotNull
    public static final List<IGProMedalInfo> s(@Nullable List<? extends IGProMedalInfo> list, int i3) {
        boolean z16;
        List<IGProMedalInfo> take;
        boolean z17;
        List<? extends IGProMedalInfo> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new ArrayList();
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
            GuildMedalUtils guildMedalUtils = f235347a;
            if (guildMedalUtils.k(iGProMedalInfo, serverTime) && guildMedalUtils.l(iGProMedalInfo)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList, i3);
        return take;
    }

    public static /* synthetic */ List t(List list, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 3;
        }
        return s(list, i3);
    }

    public static /* synthetic */ void w(GuildMedalUtils guildMedalUtils, String str, List list, TextView textView, ArrayList arrayList, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        if ((i16 & 16) != 0) {
            i3 = R.color.qui_button_bg_primary_default;
        }
        int i17 = i3;
        if ((i16 & 32) != 0) {
            function1 = null;
        }
        guildMedalUtils.v(str, list, textView, arrayList2, i17, function1);
    }

    public final String x(String str, List<? extends IGProMedalInfo> list, TextView textView, ArrayList<String> arrayList, @ColorRes int i3, wt1.f fVar, int i16, Function1<? super String, Unit> function1) {
        Object obj;
        int i17;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProMedalInfo) obj).getOfficialMedalInfoExt().getIsOffical()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            i17 = i16 + MEDAL_PADDING_WIDTH;
        } else {
            i17 = 0;
        }
        String ellipsizeGuildName = QQGuildUIUtil.g(textView, str, i17);
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(ellipsizeGuildName, "ellipsizeGuildName");
            function1.invoke(ellipsizeGuildName);
        }
        textView.setText(ellipsizeGuildName);
        Intrinsics.checkNotNullExpressionValue(ellipsizeGuildName, "ellipsizeGuildName");
        textView.setText(n(ellipsizeGuildName, list, textView, arrayList, i3, fVar));
        return ellipsizeGuildName;
    }

    @NotNull
    public final SpannableString o(@NotNull String originString, @NotNull ArrayList<String> keyWords, @ColorRes int highLightColorRes) {
        Intrinsics.checkNotNullParameter(originString, "originString");
        Intrinsics.checkNotNullParameter(keyWords, "keyWords");
        SpannableString spannableString = new SpannableString(originString);
        if (!keyWords.isEmpty()) {
            Iterator<String> it = keyWords.iterator();
            while (it.hasNext()) {
                String word = it.next();
                Intrinsics.checkNotNullExpressionValue(word, "word");
                Matcher matcher = Pattern.compile(m(word), 2).matcher(spannableString);
                while (matcher.find()) {
                    spannableString.setSpan(new ForegroundColorSpan(UIUtil.f112434a.x().getColor(highLightColorRes)), matcher.start(), matcher.end(), 33);
                }
            }
        }
        return spannableString;
    }

    public final int r() {
        return NORMAL_MEDAL_SIZE;
    }

    public final boolean u(@Nullable List<? extends IGProMedalInfo> list1, @Nullable List<? extends IGProMedalInfo> list2) {
        List emptyList;
        List emptyList2;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        if (list1 == list2) {
            Logger.f235387a.d().e("GuildMedalUtils", 1, "judgeMedalsTheSame theSameRef!!!");
            return true;
        }
        if (list1 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<? extends IGProMedalInfo> list = list1;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault2);
            for (IGProMedalInfo iGProMedalInfo : list) {
                emptyList.add(iGProMedalInfo.getName() + "_" + f235347a.p(iGProMedalInfo));
            }
        }
        if (list2 == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<? extends IGProMedalInfo> list3 = list2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            emptyList2 = new ArrayList(collectionSizeOrDefault);
            for (IGProMedalInfo iGProMedalInfo2 : list3) {
                emptyList2.add(iGProMedalInfo2.getName() + "_" + f235347a.p(iGProMedalInfo2));
            }
        }
        if (emptyList.size() != emptyList2.size()) {
            Logger.f235387a.d().c("GuildMedalUtils", 1, "judgeMedalsTheSame no List1:" + emptyList + " List2:" + emptyList2);
            return false;
        }
        Iterator it = emptyList.iterator();
        while (it.hasNext()) {
            if (!emptyList2.contains((String) it.next())) {
                Logger.f235387a.d().c("GuildMedalUtils", 1, "judgeMedalsTheSame no List1:" + emptyList + " List2:" + emptyList2);
                return false;
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildMedalUtils", 1, "judgeMedalsTheSame yes List1:" + emptyList + " List2:" + emptyList2);
        }
        return true;
    }

    public final void v(@NotNull final String guildName, @NotNull final List<? extends IGProMedalInfo> medalList, @NotNull final TextView guildNameTextView, @NotNull final ArrayList<String> highlightWords, @ColorRes final int highLightColorRes, @Nullable final Function1<? super String, Unit> onEllipsizeGuildNameUpdate) {
        Object obj;
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(medalList, "medalList");
        Intrinsics.checkNotNullParameter(guildNameTextView, "guildNameTextView");
        Intrinsics.checkNotNullParameter(highlightWords, "highlightWords");
        Iterator<T> it = medalList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                IGProOfficialMedalInfoExt officialMedalInfoExt = ((IGProMedalInfo) obj).getOfficialMedalInfoExt();
                boolean z16 = false;
                if (officialMedalInfoExt != null && officialMedalInfoExt.getIsOffical()) {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((IGProMedalInfo) obj) != null) {
            an.INSTANCE.e(new WeakReference<>(guildNameTextView), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.GuildMedalUtils$updateEllipsizeGuildNameWithMedal$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                    invoke(uRLDrawable, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull URLDrawable uRLDrawable, int i3) {
                    Intrinsics.checkNotNullParameter(uRLDrawable, "<anonymous parameter 0>");
                    Context context = guildNameTextView.getContext();
                    an.Companion companion = an.INSTANCE;
                    String d16 = companion.d();
                    GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
                    guildMedalUtils.x(guildName, medalList, guildNameTextView, highlightWords, highLightColorRes, new wt1.f(context, d16, i3, guildMedalUtils.r(), companion.b(), 0), i3, onEllipsizeGuildNameUpdate);
                }
            }, NORMAL_MEDAL_SIZE);
        }
    }
}
