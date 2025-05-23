package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/widget/SelectAccountView;", "Landroid/widget/RelativeLayout;", "", "bgType", "", "setBgType", "", "url", "b", "uin", "a", "nickName", "c", "d", "I", "mBgType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class SelectAccountView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mBgType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectAccountView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        View findViewById = findViewById(R.id.s7y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.account_avatar)");
        com.tencent.mobileqq.login.account.d.i(com.tencent.mobileqq.login.account.d.f241848a, (QQProAvatarView) findViewById, uin, 0, null, 12, null);
    }

    public final void b(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        View findViewById = findViewById(R.id.s7y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.account_avatar)");
        com.tencent.mobileqq.login.account.d.f241848a.k((QQProAvatarView) findViewById, url);
    }

    public final void c(@NotNull String nickName) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        View findViewById = findViewById(R.id.f163889bb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.account_nick_tv)");
        TextView textView = (TextView) findViewById;
        if (!TextUtils.isEmpty(nickName)) {
            textView.setVisibility(0);
            textView.setText(nickName);
            textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
            return;
        }
        textView.setVisibility(8);
    }

    public final void d(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        View findViewById = findViewById(R.id.f163902bs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.account_uin_tv)");
        TextView textView = (TextView) findViewById;
        textView.setText(uin);
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
    }

    public final void setBgType(int bgType) {
        int dpToPx;
        int dpToPx2;
        this.mBgType = bgType;
        if (bgType != 0) {
            if (bgType != 1) {
                if (bgType != 2) {
                    if (bgType != 3) {
                        dpToPx = 0;
                        dpToPx2 = 0;
                    } else {
                        dpToPx = ViewUtils.dpToPx(10.0f);
                        dpToPx2 = ViewUtils.dpToPx(16.0f);
                    }
                } else {
                    dpToPx = ViewUtils.dpToPx(10.0f);
                    dpToPx2 = ViewUtils.dpToPx(10.0f);
                }
            } else {
                dpToPx = ViewUtils.dpToPx(16.0f);
                dpToPx2 = ViewUtils.dpToPx(10.0f);
            }
        } else {
            dpToPx = ViewUtils.dpToPx(16.0f);
            dpToPx2 = ViewUtils.dpToPx(16.0f);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.kw8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dpToPx;
        layoutParams.bottomMargin = dpToPx2;
        linearLayout.setLayoutParams(layoutParams);
    }
}
