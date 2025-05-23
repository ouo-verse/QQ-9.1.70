package fq0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.android.androidbypass.Element;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.android.androidbypass.parser.c;
import com.tencent.android.androidbypass.viewgroup.e;
import com.tencent.bypass.nativeinterface.Attribute;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.CustomReplaceElement;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.guild.aio.msglist.text.util.f;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.guild.api.tab.QQGuildTabManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.markdown.g;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0018J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u0012\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\"J\u0012\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\"J\u0016\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002J*\u00102\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u000100J \u00108\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\b\b\u0002\u00107\u001a\u00020\u000eJ\u001e\u0010:\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002092\u0006\u00107\u001a\u00020\u000eJ\u0006\u0010;\u001a\u00020\u000eR\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010AR\"\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010DR\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010F\u00a8\u0006J"}, d2 = {"Lfq0/a;", "Lnr0/a;", "", "originStr", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "msg", "parsedText", "", "u", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "v", h.F, "i", "", "k", "guildTab", "onTabChanged", "markdownText", "Lcom/tencent/android/androidbypass/parser/a$b;", "option", "", DomainData.DOMAIN_NAME, "p", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "o", "", "limit", "r", "f", "path", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "d", "Lcom/tencent/android/androidbypass/span/a;", TtmlNode.TAG_SPAN, "g", "e", "localPath", "Lcom/tencent/android/androidbypass/enhance/h$b;", "drawable", "t", "guildId", "url", "j", "channelId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "appReportSourceInfo", "l", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/enhance/i;", "styleSheet", "isVasTheme", "a", "", "c", "w", "", "b", "[Ljava/lang/String;", "ISSUE_MODELS", "Lcom/tencent/android/androidbypass/parser/a;", "Lcom/tencent/android/androidbypass/parser/a;", "markdownParser", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "cache", "Ljava/lang/String;", "defaultString", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements nr0.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f400309a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] ISSUE_MODELS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.android.androidbypass.parser.a markdownParser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static LruCache<String, String> cache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String defaultString;

    static {
        a aVar = new a();
        f400309a = aVar;
        QQGuildTabManager.c(new WeakReference(aVar));
        ISSUE_MODELS = new String[]{"CET-AL00", "FIG-AL10", "M2105K81AC"};
        markdownParser = g.f359430a.g().b();
        cache = new LruCache<>(3);
        String string = BaseApplication.context.getString(R.string.f15052158);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_msg_preview_not_support)");
        defaultString = string;
    }

    a() {
    }

    public static /* synthetic */ void b(a aVar, Context context, i iVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        aVar.a(context, iVar, z16);
    }

    private final String h(MarkdownElement msg2) {
        return cache.get(msg2.content);
    }

    private final String i(MsgAbstractElement msg2) {
        return cache.get(msg2.customContent);
    }

    private final boolean k() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, Build.MANUFACTURER, true);
        if (equals && Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ CharSequence q(a aVar, String str, a.b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bVar = new a.b(0L, false, 3, null);
        }
        return aVar.n(str, bVar);
    }

    private final String s(String originStr) {
        int i3 = 0;
        for (int i16 = 0; i16 < originStr.length(); i16++) {
            char charAt = originStr.charAt(i16);
            if (!Character.valueOf(charAt).equals(Character.valueOf(TokenParser.SP)) && !Character.valueOf(charAt).equals('\n')) {
                String substring = originStr.substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
            i3++;
        }
        return originStr;
    }

    private final void u(MarkdownElement msg2, String parsedText) {
        cache.put(msg2.content, parsedText);
    }

    private final void v(MsgAbstractElement msg2, String parsedText) {
        cache.put(msg2.customContent, parsedText);
    }

    public final void a(@NotNull Context context, @NotNull i styleSheet, boolean isVasTheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleSheet, "styleSheet");
        styleSheet.f72204t = false;
        f fVar = f.f111944a;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int b16 = fVar.b(resources, isVasTheme);
        styleSheet.f72205u = b16;
        int E = GuildUIUtils.f235378a.E(b16, 0.5f);
        styleSheet.f72206v = E;
        styleSheet.N = false;
        styleSheet.P = E;
        styleSheet.W = styleSheet.f72205u;
    }

    public final void c(@NotNull Context context, @NotNull Object styleSheet, boolean isVasTheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleSheet, "styleSheet");
        if (styleSheet instanceof i) {
            a(context, (i) styleSheet, isVasTheme);
        }
    }

    @NotNull
    public final MsgRecord d(@NotNull String path, @NotNull MsgRecord msgRecord) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement createPicElementForGuild = ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createPicElementForGuild(path, true, 0);
        long j3 = msgRecord.msgId;
        long j16 = msgRecord.msgRandom;
        long j17 = msgRecord.msgSeq;
        long j18 = msgRecord.cntSeq;
        int i3 = msgRecord.sendType;
        String str = msgRecord.senderUid;
        String str2 = msgRecord.peerUid;
        String str3 = msgRecord.channelId;
        String str4 = msgRecord.guildId;
        long j19 = msgRecord.guildCode;
        long j26 = msgRecord.msgTime;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(createPicElementForGuild);
        return new MsgRecord(j3, j16, j17, j18, 4, 2, 0, i3, str, str2, str3, str4, j19, 0L, 0L, j26, null, 2, "", "", "", "", "", arrayListOf, null, null, 0L, 0, null, "", null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, msgRecord.senderUin, 0L, new HashMap(), null, 0, 0, null, null, 0, null);
    }

    @Nullable
    public final String e(@Nullable com.tencent.android.androidbypass.span.a span) {
        Drawable drawable;
        h.a aVar;
        if (span != null) {
            drawable = span.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable instanceof h.a) {
            aVar = (h.a) drawable;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.v();
    }

    @NotNull
    public final String f() {
        return defaultString;
    }

    @Nullable
    public final String g(@Nullable com.tencent.android.androidbypass.span.a span) {
        Drawable drawable;
        h.b bVar;
        Object obj;
        Map<String, Object> d16;
        if (span != null) {
            drawable = span.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable instanceof h.b) {
            bVar = (h.b) drawable;
        } else {
            bVar = null;
        }
        if (bVar != null && (d16 = bVar.d()) != null) {
            obj = d16.get("proxy_local_path");
        } else {
            obj = null;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public final boolean j(@NotNull String guildId, @NotNull String url) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(url, "url");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
        if (guildInfo != null && iGPSService.isGuest(guildInfo)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://guild/open_guild_profile", false, 2, null);
            if (startsWith$default) {
                return false;
            }
            return guildInfo.isInteractiveForVisitor();
        }
        return true;
    }

    public final void l(@NotNull String guildId, @NotNull String channelId, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @Nullable GuildAppReportSourceInfo appReportSourceInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (joinInfoParam != null) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(BaseApplication.getContext(), new JumpGuildParam(guildId, channelId, joinInfoParam));
        } else {
            QLog.e("GuildMarkdownUtil", 1, "openJoinInvitationDialog failed. guildId=" + guildId);
        }
    }

    @JvmOverloads
    @NotNull
    public final CharSequence m(@NotNull String markdownText) {
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        return q(this, markdownText, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final CharSequence n(@NotNull String markdownText, @NotNull a.b option) {
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Intrinsics.checkNotNullParameter(option, "option");
        return a.C0724a.a(markdownParser, markdownText, null, option, 2, null);
    }

    @NotNull
    public final String o(@NotNull MsgElement msg2) {
        MarkdownElement markdownElement;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isEnableMarkdown() && msg2.elementType == 14 && (markdownElement = msg2.markdownElement) != null) {
            String markdown = markdownElement.content;
            if (c.b(markdown)) {
                MarkdownElement markdownElement2 = msg2.markdownElement;
                Intrinsics.checkNotNullExpressionValue(markdownElement2, "msg.markdownElement");
                String h16 = h(markdownElement2);
                if (!TextUtils.isEmpty(h16)) {
                    Intrinsics.checkNotNull(h16);
                    return h16;
                }
                com.tencent.android.androidbypass.parser.a aVar = markdownParser;
                Intrinsics.checkNotNullExpressionValue(markdown, "markdown");
                String obj = a.C0724a.a(aVar, markdown, null, null, 6, null).toString();
                MarkdownElement markdownElement3 = msg2.markdownElement;
                Intrinsics.checkNotNullExpressionValue(markdownElement3, "msg.markdownElement");
                u(markdownElement3, obj);
                return obj;
            }
            return "";
        }
        return defaultString;
    }

    @Override // nr0.a
    public void onTabChanged(boolean guildTab) {
        cache.evictAll();
    }

    @NotNull
    public final String p(@NotNull MsgAbstractElement msg2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isEnableMarkdown() && msg2.elementType == 14) {
            String str = msg2.customContent;
            Intrinsics.checkNotNullExpressionValue(str, "msg.customContent");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String markdown = msg2.customContent;
                if (c.b(markdown)) {
                    String i3 = i(msg2);
                    if (!TextUtils.isEmpty(i3)) {
                        Intrinsics.checkNotNull(i3);
                        return i3;
                    }
                    com.tencent.android.androidbypass.parser.a aVar = markdownParser;
                    Intrinsics.checkNotNullExpressionValue(markdown, "markdown");
                    String obj = a.C0724a.a(aVar, markdown, null, null, 6, null).toString();
                    v(msg2, obj);
                    return obj;
                }
                return "";
            }
        }
        return defaultString;
    }

    @NotNull
    public final String r(@NotNull String msg2, int limit) {
        String str;
        CustomElement customElement;
        CustomReplaceElement replaceElement;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        e c16 = a.C0724a.c(markdownParser, msg2, null, 2, null);
        StringBuilder sb5 = new StringBuilder();
        for (com.tencent.android.androidbypass.viewgroup.b bVar : c16.a()) {
            if (bVar.b() != 3) {
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    sb5.append(markdownParser.c((Element) it.next()));
                    if (limit > 0 && sb5.length() >= limit) {
                        a aVar = f400309a;
                        String sb6 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
                        return aVar.s(sb6);
                    }
                }
            } else {
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Attribute attribute = ((Element) it5.next()).getAttributes().get(Element.CUSTOM_ELEMENT);
                    if (attribute != null && (customElement = attribute.getCustomElement()) != null && (replaceElement = customElement.getReplaceElement()) != null) {
                        str = replaceElement.getReplaceNodeId();
                    } else {
                        str = null;
                    }
                    for (com.tencent.android.androidbypass.viewgroup.c cVar : c16.b()) {
                        if (Intrinsics.areEqual(cVar.d(), str) && Intrinsics.areEqual(cVar.e(), "multiPic")) {
                            int i3 = 0;
                            for (Object obj : cVar.b()) {
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                if (i3 < 5) {
                                    sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
                                }
                                i3 = i16;
                            }
                        }
                    }
                }
            }
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "builder.toString()");
        return s(sb7);
    }

    public final void t(@NotNull String localPath, @NotNull h.b drawable) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Map<String, Object> d16 = drawable.d();
        Intrinsics.checkNotNullExpressionValue(d16, "drawable.extraData");
        d16.put("proxy_local_path", localPath);
    }

    public final boolean w() {
        boolean z16;
        boolean equals;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28 || i3 > 33) {
            return true;
        }
        String[] strArr = ISSUE_MODELS;
        int length = strArr.length;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                equals = StringsKt__StringsJVMKt.equals(strArr[i16], DeviceInfoMonitor.getModel(), true);
                if (equals) {
                    z16 = true;
                    break;
                }
                i16++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16 || k() || ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).isForceEnableMarkdownBreakSimple()) {
            return true;
        }
        return false;
    }
}
