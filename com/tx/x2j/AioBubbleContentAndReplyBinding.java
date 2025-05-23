package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyLinearLayout;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioBubbleContentAndReplyBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public AIOReplyLinearLayout f387022a;

    /* renamed from: b, reason: collision with root package name */
    public AioReplyMsgSourceLayoutIncludeBinding f387023b;

    /* renamed from: c, reason: collision with root package name */
    public View f387024c;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        context.getResources().getDisplayMetrics();
        AIOReplyLinearLayout aIOReplyLinearLayout = new AIOReplyLinearLayout(context, null);
        this.f387022a = aIOReplyLinearLayout;
        this.f387024c = aIOReplyLinearLayout;
        aIOReplyLinearLayout.setId(R.id.f86994t6);
        this.f387022a.setOrientation(1);
        new LinearLayout.LayoutParams(-2, -2);
        AioReplyMsgSourceLayoutIncludeBinding aioReplyMsgSourceLayoutIncludeBinding = new AioReplyMsgSourceLayoutIncludeBinding();
        this.f387023b = aioReplyMsgSourceLayoutIncludeBinding;
        View s16 = aioReplyMsgSourceLayoutIncludeBinding.s(context, this.f387022a, false);
        s16.setId(R.id.f73283t5);
        this.f387022a.addView(s16);
        return this.f387022a;
    }

    public View u() {
        return this.f387024c;
    }
}
