package com.tencent.timi.game.liveroom.impl.room.view.subscript;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.d;
import il4.b;
import trpc.yes.common.PendantOuterClass$PendantMsg;
import trpc.yes.common.PendantOuterClass$PendantMsgSubscript;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorSubscriptView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f378902d;

    /* renamed from: e, reason: collision with root package name */
    private AnchorSubscriptViewFlipper f378903e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f378904f;

    /* renamed from: h, reason: collision with root package name */
    private PendantOuterClass$PendantMsg f378905h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (AnchorSubscriptView.this.f378905h != null) {
                b.f407937a.f(AnchorSubscriptView.this.f378905h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AnchorSubscriptView(@NonNull Context context) {
        super(context);
        B0(context);
    }

    private void B0(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dxa, this);
        this.f378902d = inflate;
        inflate.setVisibility(8);
        this.f378903e = (AnchorSubscriptViewFlipper) this.f378902d.findViewById(R.id.spc);
        this.f378904f = (ImageView) this.f378902d.findViewById(R.id.j7n);
        this.f378902d.setOnClickListener(new a());
        A0(this.f378902d);
    }

    public void C0(PendantOuterClass$PendantMsg pendantOuterClass$PendantMsg) {
        if (pendantOuterClass$PendantMsg != null) {
            this.f378905h = pendantOuterClass$PendantMsg;
            this.f378902d.setVisibility(0);
            this.f378903e.setVisibility(0);
            PendantOuterClass$PendantMsgSubscript pendantOuterClass$PendantMsgSubscript = pendantOuterClass$PendantMsg.content.sub_script.get();
            this.f378903e.setData(pendantOuterClass$PendantMsgSubscript);
            if (pendantOuterClass$PendantMsgSubscript != null && !TextUtils.isEmpty(pendantOuterClass$PendantMsgSubscript.icon.url.get())) {
                d dVar = d.f380295a;
                dVar.d(pendantOuterClass$PendantMsgSubscript.icon.url.get(), this.f378904f, dVar.c(ViewUtils.dpToPx(16.0f), this.f378904f, 0));
            } else {
                this.f378904f.setVisibility(8);
            }
            this.f378903e.g();
            return;
        }
        this.f378903e.i();
        this.f378903e.setVisibility(8);
    }

    public AnchorSubscriptView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B0(context);
    }

    public AnchorSubscriptView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        B0(context);
    }

    private void A0(View view) {
    }
}
