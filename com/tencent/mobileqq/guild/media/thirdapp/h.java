package com.tencent.mobileqq.guild.media.thirdapp;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.util.bp;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/h;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "Lkotlin/Pair;", "a", "b", "I", "d", "()I", "baseContentWidth", "c", "baseContentHeight", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f229540a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int baseContentWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int baseContentHeight;

    static {
        GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
        baseContentWidth = guildMediaUtils.j() - (x.c(BaseApplication.getContext(), 10.0f) * 2);
        baseContentHeight = guildMediaUtils.i() - bp.a(QBaseActivity.sTopActivity);
    }

    h() {
    }

    @NotNull
    public final Pair<Integer, Integer> a(int screenMode) {
        float f16;
        int i3 = baseContentWidth;
        if (screenMode == 0) {
            f16 = 0.85714287f;
        } else {
            f16 = 1.7777778f;
        }
        int i16 = (int) (i3 / f16);
        float i17 = GuildMediaUtils.f227771a.i() * 0.7f;
        if (i16 > i17) {
            i16 = (int) i17;
            i3 = (int) (i16 * f16);
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @NotNull
    public final Pair<Integer, Integer> b() {
        GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
        return new Pair<>(Integer.valueOf(guildMediaUtils.j()), Integer.valueOf(guildMediaUtils.i()));
    }

    public final int c() {
        return baseContentHeight;
    }

    public final int d() {
        return baseContentWidth;
    }
}
