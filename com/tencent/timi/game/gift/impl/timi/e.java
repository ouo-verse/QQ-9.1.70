package com.tencent.timi.game.gift.impl.timi;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yh4.ReceiverInfoModel;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lyh4/b;", "receiverInfo", "", "chosen", "", "themeColor", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "v", UserInfo.SEX_FEMALE, "chosenView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "avatarTv", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "H", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "getAvatarIv", "()Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "avatarIv", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "clickView", "<init>", "(Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View v;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View chosenView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView avatarTv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AvatarRoundImageView avatarIv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View clickView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View v3) {
        super(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        this.v = v3;
        View findViewById = v3.findViewById(R.id.twk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.chosenView)");
        this.chosenView = findViewById;
        View findViewById2 = v3.findViewById(R.id.t0u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(R.id.avatarTv)");
        this.avatarTv = (TextView) findViewById2;
        View findViewById3 = v3.findViewById(R.id.t0o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "v.findViewById(R.id.avatarIv)");
        this.avatarIv = (AvatarRoundImageView) findViewById3;
        View findViewById4 = v3.findViewById(R.id.txy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "v.findViewById(R.id.clickView)");
        this.clickView = findViewById4;
    }

    public final void l(@NotNull ReceiverInfoModel receiverInfo, boolean chosen, int themeColor) {
        int i3;
        int i16;
        int i17;
        int parseColor;
        boolean z16;
        int i18;
        Intrinsics.checkNotNullParameter(receiverInfo, "receiverInfo");
        View view = this.chosenView;
        int i19 = 8;
        if (chosen && !receiverInfo.getIsCertain()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.chosenView;
        if (themeColor == 2) {
            i16 = R.drawable.lss;
        } else {
            i16 = R.drawable.lst;
        }
        view2.setBackgroundResource(i16);
        if (chosen) {
            TextView textView = this.avatarTv;
            if (themeColor == 2) {
                i18 = R.drawable.lsu;
            } else {
                i18 = R.drawable.lsv;
            }
            textView.setBackgroundResource(i18);
        } else {
            TextView textView2 = this.avatarTv;
            if (themeColor == 2) {
                i17 = R.drawable.lsw;
            } else {
                i17 = R.drawable.lsx;
            }
            textView2.setBackgroundResource(i17);
        }
        TextView textView3 = this.avatarTv;
        if (chosen) {
            parseColor = yn4.c.a(R.color.aii);
        } else {
            parseColor = Color.parseColor("#FFE99F");
        }
        textView3.setTextColor(parseColor);
        TextView textView4 = this.avatarTv;
        if (receiverInfo.getDesc().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i19 = 0;
        }
        textView4.setVisibility(i19);
        this.avatarTv.setText(receiverInfo.getDesc());
        this.avatarIv.setUserId(receiverInfo.getUid());
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final View getClickView() {
        return this.clickView;
    }
}
