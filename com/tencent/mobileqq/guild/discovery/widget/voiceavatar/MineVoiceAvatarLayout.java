package com.tencent.mobileqq.guild.discovery.widget.voiceavatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import fh1.AvatarInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import up1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u0002\u00187B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105J$\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J&\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout;", "Landroid/widget/LinearLayout;", "", "Lfh1/a;", "voicingInfos", "", "maxAvatarCount", "inviteIconRes", "", "setData", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout$b;", "userCaseHolder", "", "firstIcon", "guildId", "setGuildId", "size", "spacing", "setAvatarSizeAndHorizontalSpacing", "", "sizeRatio", "setAvatarRatio", "", "enable", "a", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "guildAvatar", "Landroid/view/View;", "e", "Landroid/view/View;", "divider", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout;", "f", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout;", "voiceAvatar", h.F, "inviteIcon", "Lph1/b;", "i", "Lph1/b;", "avatarAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "needGuildAvatar", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MineVoiceAvatarLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float sizeRatio;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView guildAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View divider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildVoicingAvatarLayout voiceAvatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView inviteIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ph1.b avatarAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean needGuildAvatar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout$b;", "", "", "b", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        boolean a();

        int b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MineVoiceAvatarLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void setData$default(MineVoiceAvatarLayout mineVoiceAvatarLayout, List list, b bVar, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        mineVoiceAvatarLayout.setData((List<AvatarInfo>) list, bVar, str);
    }

    public final void a(boolean enable) {
        this.voiceAvatar.setAnimateEnable(enable);
    }

    public final void setAvatarRatio(float sizeRatio) {
        this.avatarAdapter.r(sizeRatio);
        this.voiceAvatar.setAdapter(this.avatarAdapter);
    }

    public final void setAvatarSizeAndHorizontalSpacing(int size, int spacing) {
        ViewGroup.LayoutParams layoutParams = this.guildAvatar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        int i3 = (spacing / 3) * 2;
        layoutParams2.setMarginEnd(i3);
        this.guildAvatar.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.divider.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.setMarginEnd(i3);
        this.divider.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.voiceAvatar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        this.voiceAvatar.setLayoutParams((LinearLayout.LayoutParams) layoutParams5);
        this.voiceAvatar.setAvatarSizeAndHorizontalSpacing(size, spacing);
        ViewGroup.LayoutParams layoutParams6 = this.inviteIcon.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) layoutParams6;
        layoutParams7.width = size;
        layoutParams7.height = size;
        this.inviteIcon.setLayoutParams(layoutParams7);
    }

    public final void setData(@NotNull List<AvatarInfo> voicingInfos, int maxAvatarCount, int inviteIconRes) {
        List<AvatarInfo> emptyList;
        Intrinsics.checkNotNullParameter(voicingInfos, "voicingInfos");
        if (voicingInfos.size() < maxAvatarCount) {
            this.inviteIcon.setVisibility(0);
            this.inviteIcon.setImageResource(inviteIconRes);
        } else {
            this.inviteIcon.setVisibility(8);
        }
        this.guildAvatar.setVisibility(8);
        this.divider.setVisibility(8);
        ph1.b bVar = this.avatarAdapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        bVar.j(voicingInfos, emptyList);
    }

    public final void setGuildId(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.avatarAdapter.q(guildId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MineVoiceAvatarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.needGuildAvatar = true;
        this.sizeRatio = 1.0f;
        View.inflate(context, R.layout.f06, this);
        setClipChildren(false);
        View findViewById = findViewById(R.id.vzu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_avatar)");
        this.guildAvatar = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.bmt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.divider)");
        this.divider = findViewById2;
        View findViewById3 = findViewById(R.id.f1200378g);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.voice_avatar)");
        GuildVoicingAvatarLayout guildVoicingAvatarLayout = (GuildVoicingAvatarLayout) findViewById3;
        this.voiceAvatar = guildVoicingAvatarLayout;
        View findViewById4 = findViewById(R.id.xrp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.invite_icon)");
        this.inviteIcon = (ImageView) findViewById4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f439644r4, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026eVoiceAvatarLayout, 0, 0)");
        this.needGuildAvatar = obtainStyledAttributes.getBoolean(a.f439657s4, this.needGuildAvatar);
        this.sizeRatio = obtainStyledAttributes.getFloat(a.f439670t4, this.sizeRatio);
        obtainStyledAttributes.recycle();
        ph1.b bVar = new ph1.b(this.sizeRatio);
        this.avatarAdapter = bVar;
        guildVoicingAvatarLayout.setAdapter(bVar);
        guildVoicingAvatarLayout.setCurrentScene("MineVoiceAvatarLayout");
    }

    public final void setData(@NotNull List<AvatarInfo> voicingInfos, @NotNull b userCaseHolder, @NotNull String firstIcon) {
        List<AvatarInfo> emptyList;
        Intrinsics.checkNotNullParameter(voicingInfos, "voicingInfos");
        Intrinsics.checkNotNullParameter(userCaseHolder, "userCaseHolder");
        Intrinsics.checkNotNullParameter(firstIcon, "firstIcon");
        if (voicingInfos.size() == 1) {
            this.inviteIcon.setVisibility(0);
            this.inviteIcon.setImageResource(userCaseHolder.b());
        } else {
            this.inviteIcon.setVisibility(8);
        }
        if (!TextUtils.isEmpty(firstIcon)) {
            if (voicingInfos.size() == 6) {
                voicingInfos = CollectionsKt___CollectionsKt.dropLast(voicingInfos, 1);
            }
            this.guildAvatar.setVisibility(0);
            this.divider.setVisibility(0);
            u.q(firstIcon, this.guildAvatar, true);
        } else if (userCaseHolder.a() && this.needGuildAvatar) {
            if (voicingInfos.size() == 6) {
                voicingInfos = CollectionsKt___CollectionsKt.dropLast(voicingInfos, 1);
            }
            this.guildAvatar.setVisibility(0);
            this.divider.setVisibility(0);
            u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", this.guildAvatar, true);
        } else {
            this.guildAvatar.setVisibility(8);
            this.divider.setVisibility(8);
        }
        ph1.b bVar = this.avatarAdapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        bVar.j(voicingInfos, emptyList);
    }

    public /* synthetic */ MineVoiceAvatarLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
