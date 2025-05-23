package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberLoopView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001\u0003B\u001d\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaFullScreenUserListView;", "Landroid/widget/LinearLayout;", "", "a", "Landroid/view/View;", "b", "f", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "roleTag", "e", "d", "", "guildId", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "userList", "", "userTalking", "g", "Landroid/widget/LinearLayout;", "mRootView", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/widget/b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "userAvatarList", "Ljava/lang/String;", "mGuildId", tl.h.F, "Z", "isUserTalking", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaFullScreenUserListView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<AvatarInfo> userAvatarList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isUserTalking;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaFullScreenUserListView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        View b16;
        if (this.isUserTalking) {
            b16 = f();
        } else {
            b16 = b();
        }
        this.mRootView.addView(b16);
    }

    private final View b() {
        int collectionSizeOrDefault;
        List list;
        int i3 = 3;
        if (this.userAvatarList.size() < 3) {
            i3 = this.userAvatarList.size();
        }
        List<AvatarInfo> subList = this.userAvatarList.subList(0, i3);
        Intrinsics.checkNotNullExpressionValue(subList, "userAvatarList.subList(0, size)");
        List<AvatarInfo> list2 = subList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AvatarInfo) it.next()).getAvatarMeta());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildMemberLoopView guildMemberLoopView = new GuildMemberLoopView(context, null, 2, null);
        guildMemberLoopView.setGuildId(this.mGuildId);
        guildMemberLoopView.setAvatarSize(ViewUtils.dpToPx(27.0f));
        guildMemberLoopView.setAnimateEnable(false);
        GuildMemberLoopView.J(guildMemberLoopView, list, false, 2, null);
        return guildMemberLoopView;
    }

    private final void c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        View d16 = d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(d16, layoutParams);
        int i3 = 0;
        if (this.isUserTalking) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            String url = this.userAvatarList.get(0).getMedalInfo().getUrl();
            if (!StringUtil.isEmpty(url)) {
                ImageView imageView = new ImageView(getContext());
                int dpToPx = ViewUtils.dpToPx(13.0f);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dpToPx, dpToPx);
                com.tencent.mobileqq.guild.u.q(url, imageView, true);
                layoutParams2.rightMargin = ViewUtils.dpToPx(3.0f);
                linearLayout2.addView(imageView, layoutParams2);
            }
            IGProRoleManagementTag roleTag = this.userAvatarList.get(0).getRoleTag();
            if (roleTag != null && !TextUtils.isEmpty(roleTag.getTagName())) {
                linearLayout2.addView(e(roleTag));
            }
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 16;
            layoutParams3.topMargin = ViewUtils.dpToPx(3.0f);
            linearLayout.addView(linearLayout2, layoutParams3);
        }
        LinearLayout linearLayout3 = this.mRootView;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        if (!this.isUserTalking) {
            i3 = ViewUtils.dpToPx(4.0f);
        }
        layoutParams4.leftMargin = i3;
        linearLayout3.addView(linearLayout, layoutParams4);
    }

    private final View d() {
        String valueOf;
        if (this.isUserTalking) {
            valueOf = this.userAvatarList.get(0).getName();
        } else {
            int size = this.userAvatarList.size();
            if (size > 500) {
                valueOf = "500+";
            } else {
                valueOf = String.valueOf(size);
            }
        }
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(2, 12.0f);
        textView.setMaxWidth(ViewUtils.dpToPx(46.0f));
        textView.setSingleLine();
        textView.setText(valueOf);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private final View e(IGProRoleManagementTag roleTag) {
        TextView textView = new TextView(getContext());
        textView.setText(roleTag.getTagName());
        textView.setTextSize(9.0f);
        textView.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(2.0f));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.guild_admin_role_icon_bg);
        drawable.setTint(GuildUIUtils.f235378a.g(roleTag.getColor()));
        textView.setBackground(drawable);
        return textView;
    }

    private final View f() {
        AvatarInfo avatarInfo = this.userAvatarList.get(0);
        Intrinsics.checkNotNullExpressionValue(avatarInfo, "userAvatarList[0]");
        AvatarInfo avatarInfo2 = avatarInfo;
        GuildWavAvatarImageView guildWavAvatarImageView = new GuildWavAvatarImageView(getContext());
        guildWavAvatarImageView.setAvatarSize(ViewUtils.dpToPx(27.0f));
        guildWavAvatarImageView.setAvatarTinyId(this.mGuildId, avatarInfo2.getTinyId(), avatarInfo2.getAvatarMeta(), null);
        guildWavAvatarImageView.t("avatar_width", Integer.valueOf((int) TypedValue.applyDimension(1, 27.0f, getContext().getResources().getDisplayMetrics())));
        guildWavAvatarImageView.t("avatar_height", Integer.valueOf((int) TypedValue.applyDimension(1, 27.0f, getContext().getResources().getDisplayMetrics())));
        if (avatarInfo2.getGender() == 2) {
            guildWavAvatarImageView.setColor(Color.parseColor("#FF4FA7"));
        } else {
            guildWavAvatarImageView.setColor(Color.parseColor("#00B3FF"));
        }
        guildWavAvatarImageView.setVolume(avatarInfo2.getVolume());
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(guildWavAvatarImageView, new FrameLayout.LayoutParams(ViewUtils.dpToPx(47.0f), ViewUtils.dpToPx(47.0f), 17));
        return frameLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(GuildMediaFullScreenUserListView guildMediaFullScreenUserListView, String str, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        guildMediaFullScreenUserListView.g(str, list, z16);
    }

    public final void g(@NotNull String guildId, @NotNull List<? extends com.tencent.mobileqq.guild.media.core.data.p> userList, boolean userTalking) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(userList, "userList");
        this.userAvatarList.clear();
        this.mGuildId = guildId;
        this.isUserTalking = userTalking;
        List<com.tencent.mobileqq.guild.media.core.data.p> list = userList;
        if (list.isEmpty()) {
            list = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a;
        }
        for (com.tencent.mobileqq.guild.media.core.data.p pVar : list) {
            String str = pVar.f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "userInfo.id");
            String str2 = pVar.f228094b;
            Intrinsics.checkNotNullExpressionValue(str2, "userInfo.name");
            String str3 = pVar.f228096d;
            Intrinsics.checkNotNullExpressionValue(str3, "userInfo.avatarMeta");
            float f16 = pVar.f228109q;
            int i3 = pVar.f228117y;
            IGProRoleManagementTag iGProRoleManagementTag = pVar.M;
            eu euVar = pVar.L;
            Intrinsics.checkNotNullExpressionValue(euVar, "userInfo.medalInfo");
            this.userAvatarList.add(new AvatarInfo(str, str2, str3, f16, i3, iGProRoleManagementTag, euVar));
        }
        if (this.userAvatarList.isEmpty()) {
            return;
        }
        this.mRootView.removeAllViews();
        a();
        c();
    }

    public /* synthetic */ GuildMediaFullScreenUserListView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaFullScreenUserListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eyh, this);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mRootView = (LinearLayout) inflate;
        this.userAvatarList = new ArrayList<>();
        this.mGuildId = "";
    }
}
