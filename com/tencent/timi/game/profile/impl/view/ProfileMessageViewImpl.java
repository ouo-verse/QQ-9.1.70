package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.profile.impl.view.record.MessageSmobaRecordView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import fh4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.ao;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u0018\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\fJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/ProfileMessageViewImpl;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "c", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qquserId", "", "a", "Landroid/view/View;", "b", "", "needMonitor", "setUserInfo", "Landroid/view/View$OnClickListener;", "listener", "setAvatarClickListener", "Lnr2/ao;", "d", "Lnr2/ao;", "binding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class ProfileMessageViewImpl extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ao binding;

    public ProfileMessageViewImpl(@Nullable Context context) {
        super(context);
        c(context);
    }

    private final String a(IUserInfo userInfo, CommonOuterClass$QQUserId qquserId) {
        String city = userInfo.h(qquserId);
        if (TextUtils.isEmpty(city)) {
            String j3 = userInfo.j(qquserId);
            Intrinsics.checkNotNullExpressionValue(j3, "userInfo.constellation(qquserId)");
            return j3;
        }
        if (!TextUtils.isEmpty(userInfo.j(qquserId))) {
            return city + APLogFileUtil.SEPARATOR_LOG + userInfo.j(qquserId);
        }
        Intrinsics.checkNotNullExpressionValue(city, "city");
        return city;
    }

    private final void c(Context context) {
        ao f16 = ao.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(1);
    }

    @Nullable
    public final View b() {
        ao aoVar = this.binding;
        if (aoVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar = null;
        }
        return aoVar.f420850e;
    }

    public final void setAvatarClickListener(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ao aoVar = this.binding;
        if (aoVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar = null;
        }
        AvatarRoundImageView avatarRoundImageView = aoVar.f420849d;
        if (avatarRoundImageView != null) {
            avatarRoundImageView.setOnClickListener(listener);
        }
    }

    public final void setUserInfo(@NotNull IUserInfo userInfo, @Nullable CommonOuterClass$QQUserId qquserId, boolean needMonitor) {
        String str;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        ao aoVar = this.binding;
        ao aoVar2 = null;
        if (aoVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar = null;
        }
        AvatarRoundImageView avatarRoundImageView = aoVar.f420849d;
        if (avatarRoundImageView != null) {
            avatarRoundImageView.setUserId(qquserId);
        }
        ao aoVar3 = this.binding;
        if (aoVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar3 = null;
        }
        AvatarRoundImageView avatarRoundImageView2 = aoVar3.f420849d;
        if (avatarRoundImageView2 != null) {
            avatarRoundImageView2.setNeedDrawSex(true);
        }
        ao aoVar4 = this.binding;
        if (aoVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar4 = null;
        }
        MediumBoldTextView mediumBoldTextView = aoVar4.f420851f;
        if (mediumBoldTextView != null) {
            mediumBoldTextView.setText(userInfo.i(qquserId));
        }
        ao aoVar5 = this.binding;
        if (aoVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar5 = null;
        }
        TextView textView = aoVar5.f420852g;
        if (textView != null) {
            GameRoleOuterClass$SmobaGameRoleInfo g16 = userInfo.g();
            if (g16 == null || (pBStringField = g16.role_name) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        String a16 = a(userInfo, qquserId);
        ao aoVar6 = this.binding;
        if (aoVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar6 = null;
        }
        TextView textView2 = aoVar6.f420847b;
        if (textView2 != null) {
            textView2.setText(a16);
        }
        ao aoVar7 = this.binding;
        if (aoVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar7 = null;
        }
        TextView textView3 = aoVar7.f420847b;
        if (textView3 != null) {
            g.o(textView3, !TextUtils.isEmpty(a16));
        }
        ao aoVar8 = this.binding;
        if (aoVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aoVar8 = null;
        }
        MessageSmobaRecordView messageSmobaRecordView = aoVar8.f420848c;
        if (messageSmobaRecordView != null) {
            messageSmobaRecordView.setUserInfo(userInfo);
        }
        if (needMonitor && !userInfo.n()) {
            ao aoVar9 = this.binding;
            if (aoVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aoVar2 = aoVar9;
            }
            MessageSmobaRecordView messageSmobaRecordView2 = aoVar2.f420848c;
            if (messageSmobaRecordView2 != null) {
                messageSmobaRecordView2.setUserId(qquserId);
            }
        }
    }

    public ProfileMessageViewImpl(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public ProfileMessageViewImpl(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(context);
    }
}
