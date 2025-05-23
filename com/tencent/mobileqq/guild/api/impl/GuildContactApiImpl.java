package com.tencent.mobileqq.guild.api.impl;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wh2.eh;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildContactApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildContactApi;", "", PhotoCategorySummaryInfo.AVATAR_URL, "guildName", "Landroid/graphics/drawable/Drawable;", "getGuildAvatarDrawable", "", "jumpGuildTabDiscoverPage", "Landroid/widget/ImageView;", "avatarView", "updateGuildAvatar", "guildId", "jumpGuildOnFullStandalone", "", "isSetTop", "Lcom/tencent/mobileqq/guild/q;", "iChangeTopCallback", "changeGuildTop", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildContactApiImpl implements IGuildContactApi {

    @NotNull
    public static final String TAG = "GuildContactApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeGuildTop$lambda$0(com.tencent.mobileqq.guild.q iChangeTopCallback, String guildId, boolean z16, int i3, String errMsg, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Intrinsics.checkNotNullParameter(iChangeTopCallback, "$iChangeTopCallback");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 == 0) {
            iChangeTopCallback.a(true);
            QLog.i(TAG, 1, "changeGuildTop succ. guildId=" + guildId + ", isSetTop=" + z16);
            return;
        }
        iChangeTopCallback.a(false);
        QLog.w(TAG, 1, "changeGuildTop failed. guildId=" + guildId + " code=" + i3 + " errorMsg=" + errMsg);
        if (i3 == 320003) {
            QQToastUtil.showQQToast(0, errMsg);
        } else {
            com.tencent.mobileqq.guild.util.security.b.c(ch.i(), i3, errMsg, "");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        hashMap.put("result", sb5.toString());
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        hashMap.put("errMsg", errMsg);
        com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().e("GuildContactApiImplsetGuildListTop", hashMap);
    }

    private final Drawable getGuildAvatarDrawable(String avatarUrl, String guildName) {
        Drawable g16;
        if (QzoneConfig.guildUseQCirclePicLoader() && !TextUtils.isEmpty(avatarUrl) && (g16 = h12.c.g(avatarUrl)) != null) {
            return g16;
        }
        Drawable h16 = h12.c.h(avatarUrl, 140, "", null);
        Intrinsics.checkNotNullExpressionValue(h16, "getCacheDrawable(\n      \u2026           null\n        )");
        return h16;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContactApi
    public void changeGuildTop(@NotNull final String guildId, final boolean isSetTop, @NotNull final com.tencent.mobileqq.guild.q iChangeTopCallback) {
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(iChangeTopCallback, "iChangeTopCallback");
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (isSetTop) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        iGPSService.setGuildListTop(guildId, i3, 1, new eh() { // from class: com.tencent.mobileqq.guild.api.impl.c
            @Override // wh2.eh
            public final void a(int i16, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
                GuildContactApiImpl.changeGuildTop$lambda$0(com.tencent.mobileqq.guild.q.this, guildId, isSetTop, i16, str, iGProGuildListSortInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContactApi
    public void jumpGuildOnFullStandalone(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, "", "", "", "");
        boolean j06 = ch.j0(jumpGuildParam.guildId);
        QLog.i(TAG, 1, "jumpGuildOnFullStandalone, guildId:" + guildId + ", isGuest:" + j06);
        if (j06) {
            BaseApplication baseApplication = BaseApplication.context;
            QQToast.makeText(baseApplication, 1, baseApplication.getString(R.string.f237137g9), 0).show();
        } else {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            GuildJumpUtil.n(context, jumpGuildParam);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContactApi
    public void jumpGuildTabDiscoverPage() {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.p(context, null, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContactApi
    public void updateGuildAvatar(@NotNull ImageView avatarView, @NotNull String avatarUrl, @NotNull String guildName) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        if (TextUtils.isEmpty(avatarUrl)) {
            QLog.d(TAG, 1, "updateGuildAvatar:: " + guildName + " avatarUrl is empty, view hashcode: " + avatarView.hashCode());
            avatarView.setImageDrawable(QQGuildUIUtil.k(false));
            return;
        }
        Drawable guildAvatarDrawable = getGuildAvatarDrawable(avatarUrl, guildName);
        if (avatarView.getDrawable() != guildAvatarDrawable) {
            avatarView.setImageDrawable(guildAvatarDrawable);
        }
    }
}
