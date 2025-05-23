package com.tencent.mobileqq.guild.schedule.create.timepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.google.android.material.bottomsheet.a f233125a;

    /* renamed from: b, reason: collision with root package name */
    private GuildScheduleIphonePickerView f233126b;

    /* renamed from: c, reason: collision with root package name */
    private Context f233127c;

    /* renamed from: d, reason: collision with root package name */
    private int f233128d;

    /* renamed from: e, reason: collision with root package name */
    private int f233129e;

    /* renamed from: f, reason: collision with root package name */
    private int f233130f;

    /* renamed from: g, reason: collision with root package name */
    private GuildScheduleIphonePickerView.h f233131g;

    /* renamed from: h, reason: collision with root package name */
    private c f233132h;

    /* renamed from: i, reason: collision with root package name */
    private d f233133i;

    /* renamed from: j, reason: collision with root package name */
    private e f233134j;

    /* renamed from: k, reason: collision with root package name */
    private e f233135k;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements GuildScheduleIphonePickerView.g {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView.g
        public void onCancelBtClicked() {
            b.this.m();
            if (b.this.f233133i != null) {
                b.this.f233133i.onDismiss();
            }
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView.g
        public void onConfirmBtClicked() {
            if (b.this.f233132h != null) {
                b.this.f233132h.a(b.this.f233128d, b.this.f233129e, b.this.f233130f);
            }
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView.g
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                b.this.f233128d = i16;
            } else if (i3 == 1) {
                b.this.f233129e = i16;
            } else if (i3 == 2) {
                b.this.f233130f = i16;
            }
            if (b.this.f233135k != null) {
                b.this.f233135k.onItemSelected(i3, i16);
            }
            if (b.this.f233126b != null && (i3 == 0 || i3 == 1)) {
                b.this.f233126b.g(2);
                if (b.this.f233130f >= b.this.f233131g.getRowCount(2)) {
                    b bVar = b.this;
                    bVar.f233130f = bVar.f233131g.getRowCount(2) - 1;
                }
            }
            if (b.this.f233134j != null) {
                b.this.f233134j.onItemSelected(i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.schedule.create.timepicker.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class DialogInterfaceOnDismissListenerC7889b implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC7889b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.f233133i != null) {
                b.this.f233133i.onDismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void a(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface e {
        void onItemSelected(int i3, int i16);
    }

    public b(Context context, GuildScheduleIphonePickerView.h hVar) {
        this.f233127c = context;
        this.f233131g = hVar;
    }

    public void m() {
        com.google.android.material.bottomsheet.a aVar = this.f233125a;
        if (aVar != null && aVar.isShowing()) {
            this.f233125a.dismiss();
        }
    }

    public GuildScheduleIphonePickerView.h n() {
        return this.f233131g;
    }

    public long o() {
        return com.tencent.mobileqq.guild.schedule.create.timepicker.a.g(this, this.f233128d, this.f233129e, this.f233130f);
    }

    public void p(c cVar) {
        this.f233132h = cVar;
    }

    public void q(d dVar) {
        this.f233133i = dVar;
    }

    public void r(e eVar) {
        this.f233134j = eVar;
    }

    public void s(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f233130f = i16;
                }
            } else {
                this.f233129e = i16;
            }
        } else {
            this.f233128d = i16;
        }
        GuildScheduleIphonePickerView guildScheduleIphonePickerView = this.f233126b;
        if (guildScheduleIphonePickerView != null) {
            guildScheduleIphonePickerView.setSelection(i3, i16);
        }
        QLog.d("Guild.sch.GuildScheduleTimePicker", 2, "setSelection column:" + i3 + ",row:" + i16);
    }

    public void t() {
        if (this.f233125a == null) {
            View inflate = LayoutInflater.from(this.f233127c).inflate(R.layout.f168176f73, (ViewGroup) null);
            GuildScheduleIphonePickerView guildScheduleIphonePickerView = (GuildScheduleIphonePickerView) inflate.findViewById(R.id.wyo);
            this.f233126b = guildScheduleIphonePickerView;
            guildScheduleIphonePickerView.f(this.f233131g);
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this.f233127c);
            this.f233125a = aVar;
            aVar.setContentView(inflate, null);
            FrameLayout frameLayout = (FrameLayout) this.f233125a.findViewById(R.id.ugk);
            if (frameLayout != null) {
                frameLayout.setBackgroundResource(17170445);
            }
            this.f233125a.getBehavior().setHideable(false);
            this.f233125a.getBehavior().setState(3);
            this.f233126b.setPickListener(new a());
            this.f233125a.setOnDismissListener(new DialogInterfaceOnDismissListenerC7889b());
        }
        if (!this.f233125a.isShowing()) {
            this.f233126b.setSelection(0, this.f233128d);
            this.f233126b.setSelection(1, this.f233129e);
            this.f233126b.setSelection(2, this.f233130f);
            try {
                this.f233125a.show();
            } catch (Exception e16) {
                QLog.e("Guild.sch.GuildScheduleTimePicker", 1, "catch an exception:", e16);
            }
        }
    }
}
