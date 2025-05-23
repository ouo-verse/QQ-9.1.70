package com.tencent.mobileqq.guild.avatar;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.performance.report.t;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;
import uh2.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/avatar/b;", "", "", "tinyId", "Landroid/widget/ImageView;", "targetView", "", "f", "avatarPendant", "e", "url", "g", h.F, "d", "Lcom/tencent/libra/request/Option;", "option", "", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f214658a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/avatar/b$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f214659e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f214660f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView, String str) {
            super(true);
            this.f214659e = imageView;
            this.f214660f = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state.isFinishSuccess()) {
                if (!Intrinsics.areEqual(this.f214659e.getTag(R.id.whs), (Object) 1)) {
                    Logger logger = Logger.f235387a;
                    String str = this.f214660f;
                    ImageView imageView = this.f214659e;
                    logger.d().i("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantImage] finished, but view is re-bound, previous pendantUrl:" + str + ", set drawable to null. view:" + imageView.hashCode());
                    this.f214659e.setImageDrawable(null);
                } else {
                    b bVar = b.f214658a;
                    String d16 = bVar.d(this.f214659e);
                    if (d16 != null && !TextUtils.equals(d16, this.f214660f)) {
                        Logger logger2 = Logger.f235387a;
                        String str2 = this.f214660f;
                        ImageView imageView2 = this.f214659e;
                        logger2.d().i("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantImage] finished, but view is re-bound, previous pendantUrl:" + str2 + ", new url: " + d16 + ", view:" + imageView2.hashCode());
                        bVar.h(d16, this.f214659e);
                    }
                }
            }
            t.b(state, option, "7");
        }
    }

    b() {
    }

    private final boolean c(ImageView targetView, Option option) {
        Object tag = targetView.getTag(R.id.wtl);
        Object tag2 = targetView.getTag(R.id.wtj);
        if (tag != null && tag2 != null) {
            option.setRequestWidth(((Integer) tag).intValue()).setRequestHeight(((Integer) tag2).intValue());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(ImageView targetView) {
        Object tag = targetView.getTag(R.id.wtk);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    @JvmStatic
    public static final void e(@NotNull String avatarPendant, @NotNull ImageView targetView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(avatarPendant, "avatarPendant");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        boolean z17 = false;
        if (avatarPendant.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger.f235387a.d().w("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantByAvatarPendant] but avatarPendant is empty.");
            return;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(IGPSServi\u2026va, ProcessConstant.MAIN)");
        String fullUserAvatarPendantUrl = ((g) S0).getFullUserAvatarPendantUrl(avatarPendant);
        if (fullUserAvatarPendantUrl == null || fullUserAvatarPendantUrl.length() == 0) {
            z17 = true;
        }
        if (z17) {
            Logger.f235387a.d().w("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantByAvatarPendant] pendantUrl is empty avatarPendant:" + avatarPendant + ", view:" + targetView.hashCode());
            targetView.setImageDrawable(null);
            return;
        }
        targetView.setTag(R.id.whs, 1);
        targetView.setTag(R.id.wtk, fullUserAvatarPendantUrl);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.user.GuildUserAvatarPendantUtils", 2, "[loadPendantByAvatarPendant] avatarPendant:" + avatarPendant + ", pendantUrl:" + fullUserAvatarPendantUrl + ", view:" + targetView.hashCode());
        }
        f214658a.h(fullUserAvatarPendantUrl, targetView);
    }

    @JvmStatic
    public static final void f(@NotNull String tinyId, @NotNull ImageView targetView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        boolean z17 = false;
        if (tinyId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger.f235387a.d().w("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantByTinyId] but tinyId is empty.");
            return;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(IGPSServi\u2026va, ProcessConstant.MAIN)");
        String guildUserAvatarPendantUrl = ((IGPSService) S0).getGuildUserAvatarPendantUrl(tinyId);
        if (guildUserAvatarPendantUrl == null || guildUserAvatarPendantUrl.length() == 0) {
            z17 = true;
        }
        if (z17) {
            Logger.f235387a.d().w("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantByTinyId] pendantUrl is empty, tinyId:" + tinyId + ", view:" + targetView.hashCode());
            targetView.setImageDrawable(null);
            return;
        }
        targetView.setTag(R.id.whs, 1);
        targetView.setTag(R.id.wtk, guildUserAvatarPendantUrl);
        Logger.f235387a.d().i("Guild.user.GuildUserAvatarPendantUtils", 1, "[loadPendantByTinyId] tinyId:" + tinyId + ", pendantUrl:" + guildUserAvatarPendantUrl + ", view:" + targetView.hashCode());
        f214658a.h(guildUserAvatarPendantUrl, targetView);
    }

    @JvmStatic
    public static final void g(@NotNull String url, @NotNull ImageView targetView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            targetView.setImageDrawable(null);
            return;
        }
        targetView.setTag(R.id.whs, 1);
        targetView.setTag(R.id.wtk, url);
        f214658a.h(url, targetView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String url, ImageView targetView) {
        Option option = Option.obtain().setTargetView(targetView).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setNeedFilterUrl(false).setUrl(url);
        Intrinsics.checkNotNullExpressionValue(option, "option");
        if (!c(targetView, option)) {
            option.setRequestWidth(targetView.getWidth()).setRequestHeight(targetView.getHeight());
        }
        com.tencent.mobileqq.guild.picload.e.a().f(option, new a(targetView, url));
    }
}
