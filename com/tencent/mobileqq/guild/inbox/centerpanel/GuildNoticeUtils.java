package com.tencent.mobileqq.guild.inbox.centerpanel;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.inbox.centerpanel.assistant.i;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0007Jh\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022F\b\u0002\u0010\u001c\u001a@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\u0019J^\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\t2F\b\u0002\u0010\u001c\u001a@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\u0019J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020 J\u0016\u0010#\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/GuildNoticeUtils;", "", "", "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "", "block", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "guildNotice", "e", "i", "", "sourceType", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/i;", "callback", "c", "handlerNickName", "handlerTinyId", "d", "Landroid/widget/ImageView;", "view", "Lcom/tencent/mobileqq/qqguildsdk/data/co$b;", "guildNoticeCover", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "fetchGuildInfoAnyway", "j", "Landroid/widget/TextView;", "l", "", "isManagePage", "f", h.F, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNoticeUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildNoticeUtils f226106a = new GuildNoticeUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/GuildNoticeUtils$a", "Lvh2/v;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGPSService f226107a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226108b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ co f226109c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f226110d;

        a(IGPSService iGPSService, String str, co coVar, i iVar) {
            this.f226107a = iGPSService;
            this.f226108b = str;
            this.f226109c = coVar;
            this.f226110d = iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
        @Override // vh2.v
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int result, @Nullable String errMsg, @Nullable IGProGuildInfo guildInfo) {
            boolean z16;
            boolean isBlank;
            if (result == 0 && guildInfo != null) {
                String guildName = this.f226107a.getGuildName(this.f226108b);
                if (guildName != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(guildName);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            GuildNoticeUtils.f226106a.h(this.f226109c, this.f226110d);
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            } else {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildNoticeUtils", 2, "onFetchGuildInfo error result:" + result + " errMsg:" + errMsg);
                }
            }
        }
    }

    GuildNoticeUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String guildId, Function1<? super IGProGuildInfo, Unit> block) {
        GuildMainFrameUtils.k(guildId, block);
    }

    private final void c(String guildId, co guildNotice, int sourceType, i callback) {
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        iGPSService.fetchGuildInfoOnly(guildId, sourceType, new a(iGPSService, guildId, guildNotice, callback));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String d(@NotNull String guildId, @Nullable String handlerNickName, @Nullable String handlerTinyId) {
        boolean z16;
        boolean z17;
        IGProGuildInfo guildInfo;
        String str;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (handlerNickName != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(handlerNickName);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (handlerTinyId != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(handlerTinyId);
                        if (!isBlank) {
                            z17 = false;
                            if (z17 || Intrinsics.areEqual(ch.f(), handlerTinyId)) {
                                return "";
                            }
                            guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(guildId);
                            if (guildInfo == null) {
                                str = guildInfo.getCreatorId();
                            } else {
                                str = null;
                            }
                            if (!Intrinsics.areEqual(str, handlerTinyId)) {
                                String s16 = QQGuildUIUtil.s(R.string.f1513617h, handlerNickName);
                                Intrinsics.checkNotNullExpressionValue(s16, "getString(R.string.guild\u2026_prefix, handlerNickName)");
                                return s16;
                            }
                            String s17 = QQGuildUIUtil.s(R.string.f1513217d, handlerNickName);
                            Intrinsics.checkNotNullExpressionValue(s17, "getString(R.string.guild\u2026_prefix, handlerNickName)");
                            return s17;
                        }
                    }
                    z17 = true;
                    if (z17) {
                        guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(guildId);
                        if (guildInfo == null) {
                        }
                        if (!Intrinsics.areEqual(str, handlerTinyId)) {
                        }
                    }
                }
                return "";
            }
        }
        z16 = true;
        if (!z16) {
        }
        return "";
    }

    private final String e(co guildNotice) {
        Object firstOrNull;
        boolean isBlank;
        List<co.h> list = guildNotice.f265892h;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            co.h hVar = (co.h) firstOrNull;
            if (hVar != null) {
                String guildUserDisplayName = hVar.f265926c;
                Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "it");
                isBlank = StringsKt__StringsJVMKt.isBlank(guildUserDisplayName);
                if (!(!isBlank)) {
                    guildUserDisplayName = null;
                }
                if (guildUserDisplayName == null) {
                    guildUserDisplayName = QQGuildUIUtil.r(R.string.f143020ky);
                }
                Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "guildUserDisplayName");
                return guildUserDisplayName;
            }
            return "";
        }
        return "";
    }

    public static /* synthetic */ String g(GuildNoticeUtils guildNoticeUtils, co coVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return guildNoticeUtils.f(coVar, z16);
    }

    @JvmStatic
    @NotNull
    public static final String i(@NotNull co guildNotice) {
        Object firstOrNull;
        String str;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        List<co.h> list = guildNotice.f265892h;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            co.h hVar = (co.h) firstOrNull;
            if (hVar == null) {
                return "";
            }
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            int i3 = hVar.f265924a;
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "";
                    }
                    IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildNotice.f265890f);
                    if (guildInfo != null) {
                        str = guildInfo.getGuildName();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank) {
                            z16 = false;
                        }
                    }
                    if (z16) {
                        str = hVar.f265926c;
                    }
                    if (str == null) {
                        return "";
                    }
                    return str;
                }
                return f226106a.e(guildNotice);
            }
            String str2 = hVar.f265926c;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n                guildN\u2026tle.content\n            }");
            return str2;
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(GuildNoticeUtils guildNoticeUtils, ImageView imageView, co.b bVar, String str, Function2 function2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function2 = new GuildNoticeUtils$loadNoticeCover$1(guildNoticeUtils);
        }
        guildNoticeUtils.j(imageView, bVar, str, function2);
    }

    @NotNull
    public final String f(@NotNull co guildNotice, boolean isManagePage) {
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        if (guildNotice.f265893i == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        for (co.h hVar : guildNotice.f265893i) {
            int i3 = hVar.f265924a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && !isManagePage) {
                        long j3 = hVar.f265925b;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(j3);
                        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(sb6.toString());
                        if (guildInfo != null) {
                            sb5.append(guildInfo.getGuildName());
                        }
                    }
                } else {
                    sb5.append(e(guildNotice));
                }
            } else {
                sb5.append(hVar.f265926c);
            }
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "subTitleStrBuilder.toString()");
        return sb7;
    }

    public final void h(@NotNull co guildNotice, @NotNull i callback) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GuildNoticeSubTitleData guildNoticeSubTitleData = new GuildNoticeSubTitleData(null, null, 0, 0, 15, null);
        if (guildNotice.f265893i == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        for (co.h hVar : guildNotice.f265893i) {
            int i3 = hVar.f265924a;
            boolean z16 = true;
            if (i3 == 1) {
                sb5.append(hVar.f265926c);
            } else if (i3 == 3) {
                String guildName = iGPSService.getGuildName(String.valueOf(hVar.f265925b));
                guildNoticeSubTitleData.h(sb5.length());
                if (guildName != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(guildName);
                    if (!isBlank) {
                        z16 = false;
                    }
                }
                if (!z16) {
                    sb5.append("#" + guildName);
                } else {
                    c(String.valueOf(hVar.f265925b), guildNotice, 100, callback);
                    sb5.append("#" + hVar.f265925b);
                }
                guildNoticeSubTitleData.f(sb5.length());
                guildNoticeSubTitleData.g(String.valueOf(hVar.f265925b));
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "subTitleStrBuilder.toString()");
        guildNoticeSubTitleData.i(sb6);
        callback.a(guildNotice, guildNoticeSubTitleData);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(@NotNull final ImageView view, @Nullable co.b guildNoticeCover, @NotNull final String guildId, @NotNull Function2<? super String, ? super Function1<? super IGProGuildInfo, Unit>, Unit> fetchGuildInfoAnyway) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(fetchGuildInfoAnyway, "fetchGuildInfoAnyway");
        final int i3 = R.drawable.guild_default_guild_profile_icon;
        view.setImageResource(R.drawable.guild_default_guild_profile_icon);
        view.setTag(R.id.wj6, guildId);
        if (guildNoticeCover == null) {
            return;
        }
        int i16 = guildNoticeCover.f265908a;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    fetchGuildInfoAnyway.invoke(guildId, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeUtils$loadNoticeCover$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                            invoke2(iGProGuildInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                            if (Intrinsics.areEqual(view.getTag(R.id.wj6), guildId)) {
                                if (iGProGuildInfo != null) {
                                    String avatarUrl = iGProGuildInfo.getAvatarUrl(100);
                                    Intrinsics.checkNotNullExpressionValue(avatarUrl, "it.getAvatarUrl(IGuiildAvatarUrlType.SIZE_100)");
                                    com.tencent.mobileqq.guild.util.v.k(avatarUrl, view, QQGuildUIUtil.k(true));
                                    return;
                                }
                                view.setImageResource(i3);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            String fullGuildUserUserAvatarUrl = ((IGPSService) ch.R0(IGPSService.class)).getFullGuildUserUserAvatarUrl(guildId, String.valueOf(guildNoticeCover.f265909b), 3);
            if (fullGuildUserUserAvatarUrl != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(fullGuildUserUserAvatarUrl);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        com.tencent.mobileqq.guild.util.v.k(fullGuildUserUserAvatarUrl, view, QQGuildUIUtil.k(true));
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        } else {
            String str = guildNoticeCover.f265910c;
            Intrinsics.checkNotNullExpressionValue(str, "guildNoticeCover.url");
            com.tencent.mobileqq.guild.util.v.k(str, view, QQGuildUIUtil.k(true));
        }
    }

    public final void l(@NotNull final TextView view, @NotNull final co guildNotice, @NotNull Function2<? super String, ? super Function1<? super IGProGuildInfo, Unit>, Unit> fetchGuildInfoAnyway) {
        Object firstOrNull;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        Intrinsics.checkNotNullParameter(fetchGuildInfoAnyway, "fetchGuildInfoAnyway");
        view.setText("");
        view.setTag(R.id.wj6, guildNotice.f265890f);
        List<co.h> list = guildNotice.f265892h;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            co.h hVar = (co.h) firstOrNull;
            if (hVar != null) {
                int i3 = hVar.f265924a;
                boolean z16 = true;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            String str = hVar.f265926c;
                            if (str != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                if (!isBlank) {
                                    z16 = false;
                                }
                            }
                            if (!z16) {
                                view.setText(hVar.f265926c);
                            }
                            String str2 = guildNotice.f265890f;
                            Intrinsics.checkNotNullExpressionValue(str2, "guildNotice.guildId");
                            fetchGuildInfoAnyway.invoke(str2, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeUtils$loadNoticeTitle$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                                    invoke2(iGProGuildInfo);
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
                                /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                                    boolean z17;
                                    boolean isBlank2;
                                    if (!Intrinsics.areEqual(view.getTag(R.id.wj6), guildNotice.f265890f)) {
                                        return;
                                    }
                                    if (iGProGuildInfo != null) {
                                        view.setText(iGProGuildInfo.getGuildName());
                                        return;
                                    }
                                    CharSequence text = view.getText();
                                    if (text != null) {
                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(text);
                                        if (!isBlank2) {
                                            z17 = false;
                                            if (z17) {
                                                return;
                                            }
                                            view.setText(R.string.f1513317e);
                                            return;
                                        }
                                    }
                                    z17 = true;
                                    if (z17) {
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    view.setText(e(guildNotice));
                    return;
                }
                view.setText(hVar.f265926c);
            }
        }
    }
}
