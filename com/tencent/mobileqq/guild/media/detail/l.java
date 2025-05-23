package com.tencent.mobileqq.guild.media.detail;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\bR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010#\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010%\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0014\u0010'\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/l;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "userInfo1", "userInfo2", "", "l", ITVKPlayerEventListener.KEY_USER_INFO, "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "info", DomainData.DOMAIN_NAME, "canPlayVolumeAnim", "bindData", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "resetStatusAndAnim", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "E", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "mAvatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mUserName", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mMicIv", "H", "mMuteIv", "I", "mRobotTv", "J", "mAdminIcon", "K", "mMedalIv", "L", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "getMUserInfo", "()Lcom/tencent/mobileqq/guild/media/core/data/p;", "mUserInfo", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildWavAvatarImageView mAvatar;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView mUserName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView mMicIv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView mMuteIv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView mRobotTv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView mAdminIcon;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ImageView mMedalIv;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final p mUserInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.f165434vz4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.g\u2026dio_heads_view_item_head)");
        this.mAvatar = (GuildWavAvatarImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.xw7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.item_member_name_text_view)");
        this.mUserName = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.vz5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.g\u2026udio_heads_view_item_mic)");
        this.mMicIv = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.vz6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.g\u2026dio_heads_view_item_mute)");
        this.mMuteIv = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.kab);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.tv_robot)");
        this.mRobotTv = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.xvf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.i\u2026dentity_group_image_view)");
        this.mAdminIcon = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.xvi);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.i\u2026uild_user_personal_medal)");
        this.mMedalIv = (ImageView) findViewById7;
        p j3 = p.j();
        Intrinsics.checkNotNullExpressionValue(j3, "create()");
        this.mUserInfo = j3;
    }

    private final boolean canPlayVolumeAnim(p info) {
        if (!info.f228112t && info.f228110r != 0 && !info.f228113u) {
            return info.f228101i;
        }
        return false;
    }

    private final boolean l(p userInfo1, p userInfo2) {
        if (Intrinsics.areEqual(userInfo1.f228093a, userInfo2.f228093a) && userInfo1.f228112t == userInfo2.f228112t && userInfo1.f228110r == userInfo2.f228110r) {
            return true;
        }
        return false;
    }

    private final void m(p userInfo) {
        eu euVar = userInfo.L;
        if (euVar == null) {
            return;
        }
        String url = euVar.getUrl();
        if (!StringUtil.isEmpty(url)) {
            u.q(url, this.mMedalIv, true);
            this.mMedalIv.setVisibility(0);
        } else {
            this.mMedalIv.setVisibility(8);
        }
    }

    private final void n(p info) {
        if (info.f228098f == 1) {
            return;
        }
        if (!info.f228112t && info.f228110r != 0) {
            if (!info.f228113u && !info.f228114v && info.f228101i) {
                this.mMicIv.setVisibility(8);
                this.mMuteIv.setVisibility(8);
                return;
            } else {
                this.mMicIv.setVisibility(0);
                this.mMuteIv.setVisibility(8);
                return;
            }
        }
        this.mMuteIv.setVisibility(0);
        this.mMicIv.setVisibility(8);
    }

    private final void o(p userInfo) {
        String tagName;
        IGProRoleManagementTag iGProRoleManagementTag = userInfo.M;
        if (iGProRoleManagementTag != null && !TextUtils.isEmpty(iGProRoleManagementTag.getTagName())) {
            this.mAdminIcon.setVisibility(0);
            this.mAdminIcon.getBackground().setTint(GuildUIUtils.f235378a.g(iGProRoleManagementTag.getColor()));
            if (userInfo.f228098f == 1) {
                tagName = this.itemView.getContext().getResources().getString(R.string.f155001gb);
            } else {
                tagName = iGProRoleManagementTag.getTagName();
            }
            this.mAdminIcon.setText(tagName);
        } else {
            this.mAdminIcon.setVisibility(8);
        }
        int color = this.mUserName.getContext().getResources().getColor(R.color.guild_skin_content_text);
        if (iGProRoleManagementTag != null && iGProRoleManagementTag.getColor() != 0) {
            color = GuildUIUtils.f235378a.g(iGProRoleManagementTag.getColor());
        }
        this.mUserName.setText(userInfo.f228094b);
        this.mUserName.setTextColor(color);
    }

    private final void p(p userInfo) {
        if (userInfo.f228117y == 2) {
            this.mAvatar.setColor(Color.parseColor("#FF4FA7"));
        } else {
            this.mAvatar.setColor(Color.parseColor("#00B3FF"));
        }
    }

    public final void bindData(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildMediaMemberVH", 1, "bindData, user: " + userInfo);
        }
        n(userInfo);
        m(userInfo);
        o(userInfo);
        if (l(userInfo, this.mUserInfo)) {
            this.itemView.setTag(this.mUserInfo);
            return;
        }
        this.mUserInfo.e(userInfo);
        this.itemView.setTag(this.mUserInfo);
        this.mAvatar.setAvatarTinyId(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), userInfo.f228093a, userInfo.f228096d, userInfo.J);
        if (userInfo.f228098f == 1) {
            this.mRobotTv.setVisibility(0);
        } else {
            this.mRobotTv.setVisibility(8);
        }
        p(userInfo);
    }

    public final void q(@NotNull r userInfoList) {
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        String str = this.mUserInfo.f228093a;
        if (str == null) {
            str = "";
        }
        p g16 = userInfoList.g(str);
        if (g16 != null) {
            if (g16.f228109q > 5 && canPlayVolumeAnim(g16)) {
                this.mAvatar.setVolume(g16.f228109q);
            } else {
                this.mAvatar.z();
            }
        }
    }

    public final void resetStatusAndAnim() {
        this.mAvatar.A();
    }
}
