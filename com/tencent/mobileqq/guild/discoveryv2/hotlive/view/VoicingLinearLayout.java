package com.tencent.mobileqq.guild.discoveryv2.hotlive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.util.cw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0003B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/view/VoicingLinearLayout;", "Landroid/widget/LinearLayout;", "", "a", "", "size", "spacing", "setAvatarSizeAndHorizontalSpacing", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "avatarInfos", "setData", "b", "c", "d", "I", "avatarSize", "e", "horizontalSpace", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView;", "f", "Ljava/util/List;", "avatarLayouts", h.F, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class VoicingLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int horizontalSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuildHomeActiveChannelMicAvatarView> avatarLayouts;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarInfos;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoicingLinearLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        if (this.avatarLayouts.size() > 0) {
            this.avatarLayouts.get(0).setDefaultImageView(R.drawable.guild_audio_user_default);
            int size = this.avatarLayouts.size();
            for (int i3 = 1; i3 < size; i3++) {
                this.avatarLayouts.get(i3).setVisibility(8);
            }
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = new GuildHomeActiveChannelMicAvatarView(context, null, 2, 0 == true ? 1 : 0);
        guildHomeActiveChannelMicAvatarView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        guildHomeActiveChannelMicAvatarView.f(this.avatarSize - ((int) cw.d(2)), this.avatarSize);
        guildHomeActiveChannelMicAvatarView.setDefaultImageView(R.drawable.guild_audio_user_default);
        addView(guildHomeActiveChannelMicAvatarView);
        this.avatarLayouts.add(guildHomeActiveChannelMicAvatarView);
    }

    public final void b() {
        Iterator<T> it = this.avatarLayouts.iterator();
        while (it.hasNext()) {
            ((GuildHomeActiveChannelMicAvatarView) it.next()).e();
        }
    }

    public final void c() {
        Iterator<T> it = this.avatarLayouts.iterator();
        while (it.hasNext()) {
            ((GuildHomeActiveChannelMicAvatarView) it.next()).b();
        }
    }

    public final void setAvatarSizeAndHorizontalSpacing(int size, int spacing) {
        int i3;
        if (this.avatarSize == size && this.horizontalSpace == spacing) {
            return;
        }
        this.avatarSize = size;
        this.horizontalSpace = spacing;
        int i16 = 0;
        for (Object obj : this.avatarLayouts) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = (GuildHomeActiveChannelMicAvatarView) obj;
            ViewGroup.LayoutParams layoutParams = guildHomeActiveChannelMicAvatarView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i16 == 0) {
                i3 = 0;
            } else {
                i3 = spacing;
            }
            marginLayoutParams.leftMargin = i3;
            guildHomeActiveChannelMicAvatarView.f(size - ((int) cw.d(2)), size);
            i16 = i17;
        }
    }

    public final void setData(@NotNull List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarInfos) {
        int coerceAtMost;
        int i3;
        Intrinsics.checkNotNullParameter(avatarInfos, "avatarInfos");
        if (avatarInfos.isEmpty()) {
            a();
            return;
        }
        this.avatarInfos.clear();
        this.avatarInfos.addAll(avatarInfos);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(avatarInfos.size(), this.avatarLayouts.size());
        for (int i16 = 0; i16 < coerceAtMost; i16++) {
            GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = this.avatarLayouts.get(i16);
            guildHomeActiveChannelMicAvatarView.g(avatarInfos.get(i16));
            guildHomeActiveChannelMicAvatarView.setVisibility(0);
        }
        if (this.avatarLayouts.size() < avatarInfos.size()) {
            int size = avatarInfos.size();
            for (int size2 = this.avatarLayouts.size(); size2 < size; size2++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView2 = new GuildHomeActiveChannelMicAvatarView(context, null, 2, 0 == true ? 1 : 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (size2 == 0) {
                    i3 = 0;
                } else {
                    i3 = this.horizontalSpace;
                }
                layoutParams.leftMargin = i3;
                guildHomeActiveChannelMicAvatarView2.setLayoutParams(layoutParams);
                guildHomeActiveChannelMicAvatarView2.f(this.avatarSize - ((int) cw.d(2)), this.avatarSize);
                guildHomeActiveChannelMicAvatarView2.g(avatarInfos.get(size2));
                addView(guildHomeActiveChannelMicAvatarView2);
                this.avatarLayouts.add(guildHomeActiveChannelMicAvatarView2);
            }
            return;
        }
        if (this.avatarLayouts.size() > avatarInfos.size()) {
            int size3 = this.avatarLayouts.size();
            for (int size4 = avatarInfos.size(); size4 < size3; size4++) {
                this.avatarLayouts.get(size4).setVisibility(8);
            }
        }
    }

    public /* synthetic */ VoicingLinearLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoicingLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatarSize = (int) cw.d(38);
        this.horizontalSpace = (int) cw.d(4);
        this.avatarLayouts = new ArrayList();
        this.avatarInfos = new ArrayList();
        setGravity(16);
    }
}
