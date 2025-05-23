package com.tencent.qqnt.chats.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import androidx.annotation.ColorRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.res.a;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.theme.SkinEngine;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010%R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010%R\"\u00103\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010/\u001a\u0004\b$\u00100\"\u0004\b1\u00102R\u0018\u00107\u001a\u000604j\u0002`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/chats/utils/ChatsColorCache;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "colorInt", "", "f", "Landroid/content/Context;", "context", "resId", "o", "Landroid/content/res/ColorStateList;", "g", tl.h.F, "i", "j", "Landroid/graphics/drawable/Drawable;", "d", "c", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "b", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Ljava/util/Map;", "tokenMap", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "sThemeChangeReceiver", "Landroid/content/res/ColorStateList;", "sSummaryColor", "e", "Ljava/lang/Integer;", "sSummaryUnreadColor", "sTitleColor", "sTitleExtendColor", "sUnreadTextColor", "sNormalBgColor", "sPressBgColor", "sStickPressBgColor", "sStickBgColor", "", "Z", "()Z", "t", "(Z)V", "canPrintAfterOnPostTheme", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "builder", "Ljava/util/Formatter;", "Ljava/util/Formatter;", "formatter", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsColorCache {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatsColorCache f355526a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> tokenMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static BroadcastReceiver sThemeChangeReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile ColorStateList sSummaryColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sSummaryUnreadColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sTitleColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile ColorStateList sTitleExtendColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sUnreadTextColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sNormalBgColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sPressBgColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sStickPressBgColor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Integer sStickBgColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean canPrintAfterOnPostTheme;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final StringBuilder builder;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Formatter formatter;

    static {
        Map<Integer, String> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        f355526a = new ChatsColorCache();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(R.color.qui_common_text_secondary), "text_secondary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_text_primary), "text_primary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_text_allwhite_primary), "text_allwhite_primary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_fill_light_primary_pressed), "fill_light_primary_pressed"), TuplesKt.to(Integer.valueOf(R.color.qui_common_fill_light_primary), "fill_light_primary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_overlay_standard_primary), "overlay_standard_primary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_overlay_light), "overlay_light"), TuplesKt.to(Integer.valueOf(R.color.qui_common_text_tertiary), "text_tertiary"));
        tokenMap = mapOf;
        canPrintAfterOnPostTheme = true;
        StringBuilder sb5 = new StringBuilder();
        builder = sb5;
        formatter = new Formatter(sb5);
    }

    ChatsColorCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        a.Companion companion = com.tencent.mobileqq.quibadge.res.a.INSTANCE;
        companion.b(0);
        companion.c(0);
        companion.d(0);
        companion.a(0);
    }

    @NotNull
    public final Drawable b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Drawable) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorDrawable(k(context));
    }

    @NotNull
    public final Drawable c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Drawable) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.qqnt.util.c.f362979a.b(k(context), l(context));
    }

    @NotNull
    public final Drawable d(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.qqnt.util.c.f362979a.b(m(context), n(context));
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return canPrintAfterOnPostTheme;
    }

    @NotNull
    public final String f(int colorInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, colorInt);
        }
        StringBuilder sb5 = builder;
        sb5.setLength(0);
        formatter.format("#%06X", Integer.valueOf(colorInt & 16777215));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        sb5.setLength(0);
        return sb6;
    }

    @NotNull
    public final ColorStateList g(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateList = sSummaryColor;
        if (colorStateList == null) {
            ColorStateList valueOf = ColorStateList.valueOf(o(context, R.color.qui_common_text_secondary));
            sSummaryColor = valueOf;
            return valueOf;
        }
        return colorStateList;
    }

    public final int h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = sTitleColor;
        if (num == null) {
            num = Integer.valueOf(o(context, R.color.qui_common_text_primary));
            sTitleColor = num;
        }
        return num.intValue();
    }

    @NotNull
    public final ColorStateList i(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateList = sTitleExtendColor;
        if (colorStateList == null) {
            ColorStateList valueOf = ColorStateList.valueOf(o(context, R.color.qui_common_text_tertiary));
            sTitleExtendColor = valueOf;
            return valueOf;
        }
        return colorStateList;
    }

    public final int j(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = sUnreadTextColor;
        if (num == null) {
            num = Integer.valueOf(o(context, R.color.qui_common_text_allwhite_primary));
            sUnreadTextColor = num;
        }
        return num.intValue();
    }

    public final int k(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = sNormalBgColor;
        if (num == null) {
            num = Integer.valueOf(o(context, R.color.qui_common_fill_light_primary));
            sNormalBgColor = num;
        }
        return num.intValue();
    }

    public final int l(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = sPressBgColor;
        if (num == null) {
            num = Integer.valueOf(com.tencent.biz.qui.quicommon.a.a(k(context), o(context, R.color.qui_common_overlay_standard_primary)));
            sPressBgColor = num;
        }
        return num.intValue();
    }

    public final int m(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = sStickBgColor;
        if (num == null) {
            num = Integer.valueOf(com.tencent.biz.qui.quicommon.a.a(k(context), o(context, R.color.qui_common_overlay_light)));
            sStickBgColor = num;
        }
        return num.intValue();
    }

    public final int n(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = sStickPressBgColor;
        if (num == null) {
            num = Integer.valueOf(com.tencent.biz.qui.quicommon.a.a(m(context), o(context, R.color.qui_common_overlay_standard_primary)));
            sStickPressBgColor = num;
        }
        return num.intValue();
    }

    public final int o(@NotNull Context context, @ColorRes int resId) {
        boolean z16;
        HashMap hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, resId)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = null;
        ColorStateList colorStateList = context.getResources().getColorStateList(resId, null);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getColorStateList(resId, null)");
        int defaultColor = colorStateList.getDefaultColor();
        if (!((IChatsUtil) QRoute.api(IChatsUtil.class)).isDefaultTheme() && FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("chats_list_qui_color_switch", true)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            String str = tokenMap.get(Integer.valueOf(resId));
            QLog.d("ChatsColorCache", 2, "[getTokenColor] tokenName=" + ((Object) str) + ", resColor=" + f(defaultColor) + ", isFixSwitch=" + z16);
        }
        if (!z16) {
            return defaultColor;
        }
        String str2 = tokenMap.get(Integer.valueOf(resId));
        if (str2 != null) {
            num = Integer.valueOf(((IAIOTokenUtilsApi) QRoute.api(IAIOTokenUtilsApi.class)).getRealTokenColorNoCache(str2, resId));
        }
        if (num != null && defaultColor != num.intValue()) {
            boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("chats_list_qui_color_report_switch", true);
            if (isSwitchOn) {
                IAIOTokenUtilsApi iAIOTokenUtilsApi = (IAIOTokenUtilsApi) QRoute.api(IAIOTokenUtilsApi.class);
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("tokenName", str2), TuplesKt.to("scene", "msglist"), TuplesKt.to("real", f(num.intValue())), TuplesKt.to("cur", f(defaultColor)), TuplesKt.to("id", String.valueOf(resId)), TuplesKt.to("obj", Integer.toHexString(colorStateList.hashCode())), TuplesKt.to("detail", colorStateList.toString()));
                iAIOTokenUtilsApi.reportToBugly(hashMapOf);
            }
            QLog.d("ChatsColorCache", 1, "[getTokenColor] not equal. tokeName=" + str2 + ", realColor=" + f(num.intValue()) + ", resColor=" + f(defaultColor) + ", isReportSwitch=" + isSwitchOn);
            return num.intValue();
        }
        return defaultColor;
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else if (sThemeChangeReceiver != null) {
            r();
            s();
        } else {
            sThemeChangeReceiver = new BroadcastReceiver() { // from class: com.tencent.qqnt.chats.utils.ChatsColorCache$init$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    Integer num;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent != null) {
                        num = Integer.valueOf(intent.getIntExtra("pid", Process.myPid()));
                    } else {
                        num = null;
                    }
                    int myPid = Process.myPid();
                    if (num == null || num.intValue() != myPid) {
                        return;
                    }
                    ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
                    chatsColorCache.r();
                    chatsColorCache.s();
                }
            };
            BaseApplication.getContext().registerReceiver(sThemeChangeReceiver, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        }
    }

    public final void q(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        r();
        g(context);
        h(context);
        i(context);
        j(context);
        m(context);
        n(context);
        k(context);
        l(context);
        canPrintAfterOnPostTheme = true;
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        sSummaryColor = null;
        sSummaryUnreadColor = null;
        sTitleColor = null;
        sTitleExtendColor = null;
        sUnreadTextColor = null;
        sNormalBgColor = null;
        sPressBgColor = null;
        sStickBgColor = null;
        sStickPressBgColor = null;
        canPrintAfterOnPostTheme = true;
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            canPrintAfterOnPostTheme = z16;
        }
    }
}
