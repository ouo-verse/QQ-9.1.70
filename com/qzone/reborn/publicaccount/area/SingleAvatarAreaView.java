package com.qzone.reborn.publicaccount.area;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.publicaccount.i;
import com.tencent.mobileqq.R;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/publicaccount/area/SingleAvatarAreaView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "template", "", "b", "", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$UserInfo;", "userInfoList", "a", "d", "Landroid/content/Context;", "mContext", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mAvatarLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mNickView", "<init>", "(Landroid/content/Context;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class SingleAvatarAreaView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mAvatarLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mNickView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleAvatarAreaView(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context, i3);
    }

    private final void b(Context context, int template) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.cnm, this);
        View findViewById = findViewById(R.id.fcd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_avatar)");
        this.mAvatarLayout = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.nje);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_nick)");
        this.mNickView = (TextView) findViewById2;
        i iVar = i.f58780a;
        TextView textView = null;
        if (iVar.c(template)) {
            TextView textView2 = this.mNickView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickView");
            } else {
                textView = textView2;
            }
            textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            return;
        }
        if (iVar.d(template)) {
            TextView textView3 = this.mNickView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickView");
            } else {
                textView = textView3;
            }
            textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    public final void a(List<QZoneOfficialAccountBase$UserInfo> userInfoList) {
        QZoneOfficialAccountBase$UserInfo qZoneOfficialAccountBase$UserInfo;
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        if (userInfoList.isEmpty() || (qZoneOfficialAccountBase$UserInfo = userInfoList.get(0)) == null || !qZoneOfficialAccountBase$UserInfo.has()) {
            return;
        }
        FrameLayout frameLayout = this.mAvatarLayout;
        TextView textView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AvatarElement avatarElement = new AvatarElement(context, false);
        avatarElement.setUin(String.valueOf(qZoneOfficialAccountBase$UserInfo.uin.get()));
        FrameLayout frameLayout2 = this.mAvatarLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
            frameLayout2 = null;
        }
        frameLayout2.addView(avatarElement);
        TextView textView2 = this.mNickView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickView");
        } else {
            textView = textView2;
        }
        textView.setText(qZoneOfficialAccountBase$UserInfo.nick.get());
    }
}
