package com.tencent.mobileqq.guild.discovery.widget.voiceavatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.CircleWaveView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qphone.base.util.QLog;
import fh1.AvatarInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\tB\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoicingAvatarView;", "Landroid/widget/FrameLayout;", "Lfh1/a;", "avatarInfo", "", "guildId", "", "e", "d", "a", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "c", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;", "b", "()Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;", "animationView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MineVoicingAvatarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildUserAvatarView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CircleWaveView animationView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MineVoicingAvatarView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        this.animationView.C();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final CircleWaveView getAnimationView() {
        return this.animationView;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildUserAvatarView getAvatarView() {
        return this.avatarView;
    }

    public final void d() {
        this.animationView.C();
        CircleWaveView.B(this.animationView, 0, null, 3, null);
    }

    public final void e(@NotNull AvatarInfo avatarInfo, @NotNull String guildId) {
        CircleWaveView.WaveColor waveColor;
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.mine.MineVoicingAvatarView", 2, "update | type:" + avatarInfo.getType() + ", url:" + avatarInfo.getAvatarUrl());
        }
        this.avatarView.setLogTag(".Guild.discovery.mine.MineVoicingAvatarView");
        this.avatarView.setAvatarMeta(guildId, "0", avatarInfo.getAvatarUrl());
        CircleWaveView circleWaveView = this.animationView;
        if (avatarInfo.getGender() == 2) {
            waveColor = CircleWaveView.WaveColor.FEMALE;
        } else {
            waveColor = CircleWaveView.WaveColor.MALE;
        }
        circleWaveView.setWaveColor(waveColor);
    }

    public /* synthetic */ MineVoicingAvatarView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MineVoicingAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.f168133f01, this);
        View findViewById = findViewById(R.id.t1g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_icon)");
        this.avatarView = (GuildUserAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.f120707__);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.wav_view)");
        CircleWaveView circleWaveView = (CircleWaveView) findViewById2;
        this.animationView = circleWaveView;
        circleWaveView.setWaveSize(CircleWaveView.WaveSize.SMALL);
        setClipChildren(false);
    }
}
