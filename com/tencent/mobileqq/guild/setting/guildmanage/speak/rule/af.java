package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.eo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u001a\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u001e\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/af;", "", "", "gId", "cId", "", "type", "", "content", "", "c", "guildId", "b", "Lwh2/f;", "cb", "", "f", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final af f234303a = new af();

    af() {
    }

    @JvmStatic
    public static final boolean b(@Nullable String guildId, @NotNull CharSequence content) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList<String> keywords = ((IGPSService) ch.R0(IGPSService.class)).getGuildSpeakPermission(guildId, 104).b();
        String replace = new Regex("\\s").replace(content.toString(), "");
        Intrinsics.checkNotNullExpressionValue(keywords, "keywords");
        boolean z16 = false;
        for (String it : keywords) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) replace, (CharSequence) it, false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
    
        if (r4.getGuildSpeakPermission(r3, 103).c() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007d, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        if (r4.getGuildSpeakPermission(r3, 102).e() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        if (r4.getGuildSpeakPermission(r3, 101).d() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
    
        if (r4.getGuildSpeakPermission(r3, 100).a() == false) goto L23;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(@Nullable String gId, @Nullable String cId, int type, @NotNull CharSequence content) {
        Intrinsics.checkNotNullParameter(content, "content");
        boolean z16 = false;
        if (com.tencent.mobileqq.guild.setting.mute.c.V(gId, cId)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.GuildSpeakRuleUtils", 1, "[NeedInterceptSpeech] type:[" + type + "] is admin");
            }
            return false;
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        switch (type) {
            case 104:
                z16 = b(gId, content);
                break;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.sr.GuildSpeakRuleUtils", 1, "[NeedInterceptSpeech] type: " + type + " res: " + z16);
        }
        return z16;
    }

    public static /* synthetic */ boolean d(String str, String str2, int i3, CharSequence charSequence, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            charSequence = "";
        }
        return c(str, str2, i3, charSequence);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@Nullable String str) {
        g(str, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void f(@Nullable String guildId, @Nullable wh2.f cb5) {
        boolean z16;
        int i3;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            IGPSService iGPSService = (IGPSService) bz.b(IGPSService.class);
            if (iGPSService.isGuest(guildId)) {
                i3 = 7;
            } else {
                i3 = 105;
            }
            if (cb5 == null) {
                cb5 = new wh2.f() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.ae
                    @Override // wh2.f
                    public final void a(int i16, String str, eo eoVar) {
                        af.h(i16, str, eoVar);
                    }
                };
            }
            iGPSService.beforehandGetGuildSpeakPermission(MiscKt.l(guildId), i3, cb5);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[preloadSpeakRule] exception: " + e16.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.sr.GuildSpeakRuleUtils", 1, (String) it.next(), null);
            }
        }
    }

    public static /* synthetic */ void g(String str, wh2.f fVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fVar = null;
        }
        f(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str, eo eoVar) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sr.GuildSpeakRuleUtils", 1, "[preloadSpeakRule] result:" + i3 + " msg:" + str + " info:" + eoVar);
        }
    }
}
