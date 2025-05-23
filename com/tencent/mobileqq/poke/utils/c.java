package com.tencent.mobileqq.poke.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007Jj\u0010\u0015\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0007J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ4\u0010\u001c\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/poke/utils/c;", "", "", "a", "isDownload", "", "e", "Landroid/content/Context;", "ctx", "", "uin", "", "entryType", WadlProxyConsts.RES_URL, WadlProxyConsts.RES_MD5, "surpriseIndexs", "peOders", "aioInput", "aioFeedBack", "limitCount", "viewType", "d", "idx", "b", "", "aioPokeStrengthRule", "aioPokeResUrl", "aioPokeResMd5", "c", "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f259091a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f259091a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a() {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.context).getBoolean(AppConstants.Preferences.POKE_EMO_DOWNLOAD_MARK, false);
    }

    @JvmStatic
    public static final void d(@Nullable Context ctx, @NotNull String uin, int entryType, @Nullable String resUrl, @Nullable String resMd5, @Nullable String surpriseIndexs, @Nullable String peOders, int aioInput, int aioFeedBack, int limitCount, int viewType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).edit();
        edit.putInt(uin + "_aio_poke_entry_type", entryType);
        edit.putInt(uin + "_aio_pe_view_type", viewType);
        edit.putString(uin + "_poke_emo_res_url", resUrl);
        edit.putString(uin + "_poke_emo_res_md5", resMd5);
        edit.putString(uin + "_poke_emo_surprice_indexs", surpriseIndexs);
        edit.putString(uin + "_poke_emo_order", peOders);
        edit.putInt(uin + "_aio_pe_input_switch", aioInput);
        edit.putInt(uin + "_aio_pe_feed_back_switch", aioFeedBack);
        edit.putInt(uin + "_aio_pe_bubble_limit_count", limitCount);
        edit.apply();
    }

    @JvmStatic
    public static final void e(boolean isDownload) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.context).edit();
        edit.putBoolean(AppConstants.Preferences.POKE_EMO_DOWNLOAD_MARK, isDownload);
        edit.apply();
    }

    public final void b(int idx, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, idx, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        PreferenceManager.getDefaultSharedPreferences(BaseApplication.context).edit().putInt(uin + AppConstants.Preferences.STICKER_BUBBLE_LAST_SEND_ID, idx).apply();
    }

    public final void c(@Nullable Context ctx, @NotNull String uin, long aioPokeStrengthRule, @Nullable String aioPokeResUrl, @Nullable String aioPokeResMd5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, ctx, uin, Long.valueOf(aioPokeStrengthRule), aioPokeResUrl, aioPokeResMd5);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putLong(uin + "_aio_poke_strength_rule_interval", aioPokeStrengthRule);
        edit.putString(uin + "_aio_poke_res_url", aioPokeResUrl);
        edit.putString(uin + "_aio_poke_res_md5", aioPokeResMd5);
        edit.apply();
    }
}
