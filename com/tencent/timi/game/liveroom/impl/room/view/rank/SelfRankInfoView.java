package com.tencent.timi.game.liveroom.impl.room.view.rank;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.widget.avatar.QQLiveAvatarImageView;
import com.tencent.mobileqq.qqlive.widget.avatar.QQLivePendantImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SelfRankInfoView extends FrameLayout {
    private ImageView C;
    private QQLivePendantImageView D;
    private b E;
    private c F;
    private long G;

    /* renamed from: d, reason: collision with root package name */
    private TextView f378844d;

    /* renamed from: e, reason: collision with root package name */
    private QQLiveAvatarImageView f378845e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f378846f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f378847h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f378848i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f378849m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.qqlive.sail.c.f272176a.m().F(SelfRankInfoView.this.G, 0)) {
                AegisLogger.w("Audience|SelfRankInfoView", "init", "anchor is not QQAnchor");
                gt3.a.INSTANCE.a().a("\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, SelfRankInfoView.this.getContext());
            } else {
                if (SelfRankInfoView.this.F != null) {
                    SelfRankInfoView.this.F.a();
                }
                if (SelfRankInfoView.this.E != null) {
                    SelfRankInfoView.this.E.P6();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void P6();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        void a();
    }

    public SelfRankInfoView(@NonNull Context context) {
        super(context);
        f();
    }

    private int d(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return -1;
                }
                return R.drawable.o8e;
            }
            return R.drawable.o8d;
        }
        return R.drawable.o8c;
    }

    private int e(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return -1;
                }
                return R.drawable.o6r;
            }
            return R.drawable.o6q;
        }
        return R.drawable.o6p;
    }

    private void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.f169136hy1, this);
        this.f378844d = (TextView) findViewById(R.id.f82954i_);
        this.f378845e = (QQLiveAvatarImageView) findViewById(R.id.f82934i8);
        this.f378846f = (ImageView) findViewById(R.id.f82944i9);
        this.f378847h = (TextView) findViewById(R.id.f82974ib);
        this.f378848i = (TextView) findViewById(R.id.f82994id);
        this.f378849m = (TextView) findViewById(R.id.f82984ic);
        this.C = (ImageView) findViewById(R.id.t1f);
        this.D = (QQLivePendantImageView) findViewById(R.id.f82884i3);
        this.f378849m.setOnClickListener(new a());
        this.f378849m.setText(ht3.a.d("guest_rank_list_send_gift_button_text", "\u53bb\u9001\u793c"));
    }

    private void g(d55.a aVar) {
        d55.f fVar;
        if (aVar != null && (fVar = aVar.f393059k) != null) {
            String str = fVar.f393069a;
            if (TextUtils.isEmpty(str)) {
                this.D.setImageUrl(null);
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("Audience|SelfRankInfoView", 1, "renderAvatarPendant: no pendant url valid.");
                return;
            } else {
                this.D.setImageUrl(str);
                return;
            }
        }
        this.D.setImageUrl(null);
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("Audience|SelfRankInfoView", 1, "renderAvatarPendant: no pendant.");
    }

    public void h(c cVar) {
        this.F = cVar;
    }

    public void i(boolean z16) {
        int i3;
        TextView textView = this.f378849m;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.f378848i;
        if (!z16) {
            i16 = 8;
        }
        textView2.setVisibility(i16);
    }

    public void j(d55.g gVar, boolean z16) {
        String str;
        String str2;
        if (z16) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("Audience|SelfRankInfoView", 1, "updateRankInfo: current user is anchor.");
            setVisibility(4);
            return;
        }
        setVisibility(0);
        if (gVar == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("Audience|SelfRankInfoView", 1, "updateRankInfo: rsp is null.");
            return;
        }
        d55.a aVar = gVar.f393072a;
        if (aVar == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("Audience|SelfRankInfoView", 1, "updateRankInfo: audienceInfo is null.");
            return;
        }
        this.f378847h.setText(aVar.f393053e);
        if (!TextUtils.isEmpty(gVar.f393072a.f393052d)) {
            this.f378845e.setImageUrl(gVar.f393072a.f393052d);
        }
        TextView textView = this.f378848i;
        if (TextUtils.isEmpty(gVar.f393078g)) {
            str = "--";
        } else {
            str = gVar.f393078g;
        }
        textView.setText(str);
        int i3 = gVar.f393073b;
        if (i3 > 0) {
            if (i3 <= 100) {
                str2 = String.valueOf(i3);
            } else {
                str2 = "100+";
            }
            this.f378844d.setText(str2);
            this.f378844d.setTextSize(com.tencent.timi.game.liveroom.impl.room.view.rank.c.d(str2));
            this.f378844d.setTextColor(com.tencent.timi.game.liveroom.impl.room.view.rank.c.a(getContext(), gVar.f393073b));
            int e16 = e(gVar.f393073b);
            int d16 = d(gVar.f393073b);
            if (e16 != -1 && d16 != -1) {
                this.f378846f.setImageResource(d16);
                this.C.setImageResource(e16);
                this.f378846f.setVisibility(0);
                this.C.setVisibility(0);
            } else {
                this.f378846f.setVisibility(4);
                this.C.setVisibility(4);
            }
        } else {
            this.f378844d.setText("--");
            this.f378844d.setTextSize(14.0f);
        }
        d55.a aVar2 = gVar.f393072a;
        if (aVar2.f393059k != null) {
            g(aVar2);
        }
    }

    public void setOpenGiftPanelListener(b bVar) {
        this.E = bVar;
    }

    public void setRoomId(long j3) {
        this.G = j3;
    }

    public SelfRankInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public SelfRankInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f();
    }
}
