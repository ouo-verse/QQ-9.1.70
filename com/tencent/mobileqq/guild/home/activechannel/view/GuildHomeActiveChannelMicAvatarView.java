package com.tencent.mobileqq.guild.home.activechannel.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.az;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002#\u000fB\u001d\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView;", "Landroid/widget/FrameLayout;", "Landroid/animation/ObjectAnimator;", "c", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "avatarInfo", "", "g", "", "resId", "setDefaultImageView", "avatarSize", "outerSize", "f", "e", "b", "Lvp1/az;", "d", "Lvp1/az;", "binding", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "getAvatarInfo", "()Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "setAvatarInfo", "(Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;)V", "Lkotlin/Lazy;", "()Landroid/animation/ObjectAnimator;", "alphaAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeActiveChannelMicAvatarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final az binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarInfo avatarInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy alphaAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "c", "tinyId", "avatarMeta", "d", "Z", "()Z", "isMicOpening", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class AvatarInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tinyId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String avatarMeta;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isMicOpening;

        public AvatarInfo(@NotNull String guildId, @NotNull String tinyId, @NotNull String avatarMeta, boolean z16) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
            this.guildId = guildId;
            this.tinyId = tinyId;
            this.avatarMeta = avatarMeta;
            this.isMicOpening = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAvatarMeta() {
            return this.avatarMeta;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsMicOpening() {
            return this.isMicOpening;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarInfo)) {
                return false;
            }
            AvatarInfo avatarInfo = (AvatarInfo) other;
            if (Intrinsics.areEqual(this.guildId, avatarInfo.guildId) && Intrinsics.areEqual(this.tinyId, avatarInfo.tinyId) && Intrinsics.areEqual(this.avatarMeta, avatarInfo.avatarMeta) && this.isMicOpening == avatarInfo.isMicOpening) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.guildId.hashCode() * 31) + this.tinyId.hashCode()) * 31) + this.avatarMeta.hashCode()) * 31;
            boolean z16 = this.isMicOpening;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "AvatarInfo(guildId=" + this.guildId + ", tinyId=" + this.tinyId + ", avatarMeta=" + this.avatarMeta + ", isMicOpening=" + this.isMicOpening + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeActiveChannelMicAvatarView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ObjectAnimator c() {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(this.binding.f442363d, c.f123400v, 0.3f, 0.0f, 0.3f);
        alphaAnimator.setDuration(900L);
        alphaAnimator.setRepeatCount(-1);
        Intrinsics.checkNotNullExpressionValue(alphaAnimator, "alphaAnimator");
        return alphaAnimator;
    }

    private final ObjectAnimator d() {
        return (ObjectAnimator) this.alphaAnimator.getValue();
    }

    public final void b() {
        d().end();
    }

    public final void e() {
        d().start();
    }

    public final void f(int avatarSize, int outerSize) {
        GuildUserAvatarView guildUserAvatarView = this.binding.f442361b;
        ViewGroup.LayoutParams layoutParams = guildUserAvatarView.getLayoutParams();
        layoutParams.height = avatarSize;
        layoutParams.width = avatarSize;
        guildUserAvatarView.setLayoutParams(layoutParams);
        View view = this.binding.f442362c;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.height = avatarSize;
        layoutParams2.width = avatarSize;
        view.setLayoutParams(layoutParams2);
        View view2 = this.binding.f442363d;
        ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
        layoutParams3.height = outerSize;
        layoutParams3.width = outerSize;
        view2.setLayoutParams(layoutParams3);
    }

    public final void g(@NotNull AvatarInfo avatarInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        this.avatarInfo = avatarInfo;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.GuildHomeActiveChannelMicAvatarView", 2, "update avatarInfo:" + avatarInfo);
        }
        int i16 = 8;
        this.binding.f442364e.setVisibility(8);
        this.binding.f442361b.setVisibility(0);
        this.binding.f442361b.setAvatarMeta(avatarInfo.getGuildId(), avatarInfo.getTinyId(), avatarInfo.getAvatarMeta());
        View view = this.binding.f442363d;
        Intrinsics.checkNotNullExpressionValue(view, "binding.activeChannelWhiteOuterBg");
        if (avatarInfo.getIsMicOpening()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.binding.f442362c;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.activeChannelWhiteInnerBg");
        if (avatarInfo.getIsMicOpening()) {
            i16 = 0;
        }
        view2.setVisibility(i16);
    }

    public final void setAvatarInfo(@Nullable AvatarInfo avatarInfo) {
        this.avatarInfo = avatarInfo;
    }

    public final void setDefaultImageView(int resId) {
        this.binding.f442361b.setVisibility(8);
        this.binding.f442364e.setVisibility(0);
        this.binding.f442364e.setImageDrawable(getResources().getDrawable(resId, null));
        View view = this.binding.f442363d;
        Intrinsics.checkNotNullExpressionValue(view, "binding.activeChannelWhiteOuterBg");
        view.setVisibility(8);
        View view2 = this.binding.f442362c;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.activeChannelWhiteInnerBg");
        view2.setVisibility(8);
    }

    public /* synthetic */ GuildHomeActiveChannelMicAvatarView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeActiveChannelMicAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.alphaAnimator = LazyKt.lazy(new Function0<ObjectAnimator>() { // from class: com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView$alphaAnimator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator c16;
                c16 = GuildHomeActiveChannelMicAvatarView.this.c();
                return c16;
            }
        });
        az f16 = az.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setClipChildren(false);
        f16.f442361b.setLogTag(".Guild.NewHome.content.active.GuildHomeActiveChannelMicAvatarView");
    }
}
