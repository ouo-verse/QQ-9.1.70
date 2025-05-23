package com.tencent.mobileqq.guild.window.usecase;

import android.content.DialogInterface;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 &2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010,\u001a\u00020 \u0012\u0006\u00101\u001a\u00020-\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H&J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fH\u0016J0\u0010\u001f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010,\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b*\u0010.\u001a\u0004\b/\u00100R\"\u00107\u001a\n 3*\u0004\u0018\u000102028\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b4\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/window/usecase/g;", "", "", "reason", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "customView", "b", "guildId", "roomId", "i", "", "canTalk", "", "scene", "g", "channelID", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Lkotlin/collections/ArrayList;", "qualityArr", tl.h.F, "userId", "available", "k", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "j", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "l", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "Lcom/tencent/mobileqq/guild/window/a;", "Lcom/tencent/mobileqq/guild/window/a;", "f", "()Lcom/tencent/mobileqq/guild/window/a;", "wrapper", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/qphone/base/util/BaseApplication;", "()Lcom/tencent/qphone/base/util/BaseApplication;", "mContext", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/window/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProGuildInfo mGuildInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo mChannelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.window.a wrapper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final BaseApplication mContext;

    public g(@NotNull IGProGuildInfo mGuildInfo, @NotNull IGProChannelInfo mChannelInfo, @NotNull com.tencent.mobileqq.guild.window.a wrapper) {
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        this.mGuildInfo = mGuildInfo;
        this.mChannelInfo = mChannelInfo;
        this.wrapper = wrapper;
        this.mContext = BaseApplication.context;
    }

    private final void m(String reason) {
        QBaseActivity qBaseActivity;
        if (!StringUtil.isEmpty(reason) && (qBaseActivity = QBaseActivity.sTopActivity) != null) {
            Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, reason, "", cw.h(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.window.usecase.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.n(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026       null\n            )");
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    public abstract void b(@NotNull ViewGroup customView);

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IGProChannelInfo getMChannelInfo() {
        return this.mChannelInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: from getter */
    public final BaseApplication getMContext() {
        return this.mContext;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final IGProGuildInfo getMGuildInfo() {
        return this.mGuildInfo;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final com.tencent.mobileqq.guild.window.a getWrapper() {
        return this.wrapper;
    }

    public abstract void g(boolean canTalk, int scene);

    public abstract void h(@NotNull String channelID, @NotNull ArrayList<TRTCQuality> qualityArr);

    public void i(@NotNull String guildId, @NotNull String roomId, @NotNull String reason) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Logger.f235387a.d().i("AudioFloatWindowUseCase", 1, "onExit guildId=" + guildId + ", roomId=" + roomId + "\uff0c reason=" + reason);
        if (Intrinsics.areEqual(guildId, this.mChannelInfo.getGuildId()) && Intrinsics.areEqual(roomId, this.mChannelInfo.getChannelUin())) {
            m(reason);
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = this.wrapper.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "wrapper.javaClass.name");
            guildFloatWindowManager.g(name);
        }
    }

    public abstract void j(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList);

    public void k(@NotNull String userId, boolean available) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Logger.f235387a.d().i("AudioFloatWindowUseCase", 1, "onUserVideoAvailable | userId: " + userId + " | available: " + available);
        if (available) {
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = this.wrapper.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "wrapper.javaClass.name");
            guildFloatWindowManager.g(name);
            GuildFloatWindowUtils.G(this.mGuildInfo, this.mChannelInfo, this.wrapper.x0());
        }
    }

    public abstract void l(@Nullable IGProChannelInfo channelInfo);
}
