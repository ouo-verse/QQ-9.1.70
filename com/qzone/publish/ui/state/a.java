package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.reborn.util.l;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<QZonePublishMoodBaseActivity> f52057a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray<View> f52058b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f52059c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f52060d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f52061e;

    /* renamed from: f, reason: collision with root package name */
    protected long f52062f;

    /* renamed from: g, reason: collision with root package name */
    protected ActionSheet f52063g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f52064h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f52065i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.publish.ui.state.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0444a implements ActionSheet.OnButtonClickListener {
        C0444a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = a.this.f52057a.get();
            if (qZonePublishMoodBaseActivity == null || a.this.f52063g == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[Actvity]");
            sb5.append(a.this.f52057a.getClass().getSimpleName());
            if (view != null) {
                sb5.append(" click  view id:");
                sb5.append(Integer.toHexString(view.getId()));
            }
            sb5.append("which:");
            sb5.append(i3);
            RDMEtraMsgCollector.getInstance().addUserAction(sb5.toString());
            if (i3 == 0) {
                qZonePublishMoodBaseActivity.U2 = false;
                qZonePublishMoodBaseActivity.finish();
            }
            a.this.f52063g.superDismiss();
        }
    }

    public a(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        this.f52057a = new WeakReference<>(qZonePublishMoodBaseActivity);
    }

    public <T extends View> T a(int i3) {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity;
        if (this.f52058b.get(i3) == null && (qZonePublishMoodBaseActivity = this.f52057a.get()) != null) {
            this.f52058b.put(i3, qZonePublishMoodBaseActivity.getActivity().findViewById(i3));
        }
        return (T) this.f52058b.get(i3);
    }

    public void d() {
        u5.b.j(g());
    }

    public void f() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        ActionSheet actionSheet = this.f52063g;
        if (actionSheet == null || !actionSheet.isShowing()) {
            if (!qZonePublishMoodBaseActivity.Wj()) {
                qZonePublishMoodBaseActivity.finish();
                return;
            }
            ActionSheet create = ActionSheet.create(qZonePublishMoodBaseActivity.getActivity());
            this.f52063g = create;
            create.addButton(R.string.f173019gi3, 3);
            this.f52063g.addCancelButton(R.string.cancel);
            this.f52063g.setOnButtonClickListener(new C0444a());
            this.f52063g.show();
        }
    }

    public long g() {
        if (this.f52064h) {
            return this.f52062f * 100;
        }
        return this.f52062f;
    }

    public int h() {
        return 0;
    }

    public void m() {
        int i3;
        long g16 = g();
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        String S = u5.b.S("_shuoshuo", g16);
        qZonePublishMoodBaseActivity.f45104j0.setText(S);
        if (!TextUtils.isEmpty(S)) {
            qZonePublishMoodBaseActivity.N4 = true;
        }
        qZonePublishMoodBaseActivity.f45103i2 = 0;
        List<Friend> C = u5.b.C("_shuoshuo", g16);
        qZonePublishMoodBaseActivity.f45141y0 = C;
        if (C != null) {
            int size = C.size();
            for (int i16 = 0; i16 < size; i16++) {
                Friend friend = qZonePublishMoodBaseActivity.f45141y0.get(i16);
                if (friend != null) {
                    String str = "@" + friend.mName;
                    if (qZonePublishMoodBaseActivity.f45103i2 < str.length()) {
                        i3 = str.length();
                    } else {
                        i3 = qZonePublishMoodBaseActivity.f45103i2;
                    }
                    qZonePublishMoodBaseActivity.f45103i2 = i3;
                }
            }
        }
        qZonePublishMoodBaseActivity.En(u5.b.Z("key_shuoshuo_timer", g16));
        qZonePublishMoodBaseActivity.k3 = u5.b.U("_shuoshuo", g16);
        qZonePublishMoodBaseActivity.l3 = u5.b.V("_shuoshuo", g16);
        qZonePublishMoodBaseActivity.n3 = u5.b.j0("key_shuoshuo_right_tag_shuoshuo", "", g16);
        qZonePublishMoodBaseActivity.m3 = u5.b.j0("key_shuoshuo_right_raw_json_shuoshuo", "", g16);
        qZonePublishMoodBaseActivity.Dn();
    }

    public void q(boolean z16) {
        this.f52061e = z16;
    }

    public void r() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        qZonePublishMoodBaseActivity.getActivity().setResult(0);
        if (!qZonePublishMoodBaseActivity.Wj()) {
            if (this.f52059c) {
                n();
                d();
            }
            qZonePublishMoodBaseActivity.finish();
            return;
        }
        f();
    }

    public void i(Intent intent) {
        this.f52059c = intent == null || intent.getBooleanExtra("key_need_save_draft", true);
        this.f52060d = intent != null && intent.getBooleanExtra("key_isfrom_photobubble", false);
        this.f52062f = LoginData.getInstance().getUin();
        if (intent.getBooleanExtra("key_from_kuolie", false)) {
            this.f52064h = true;
        }
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            this.f52065i = QZoneHelper.QZoneReeditConstants.isReeditPublishFlow(intent);
        } else {
            this.f52065i = l.f59550a.O(qZonePublishMoodBaseActivity.bj(), intent);
        }
    }

    public static a e(int i3, QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        if (i3 == 1) {
            return new d(qZonePublishMoodBaseActivity);
        }
        if (i3 == 2) {
            return new e(qZonePublishMoodBaseActivity);
        }
        if (i3 != 3) {
            return new c(qZonePublishMoodBaseActivity);
        }
        return new b(qZonePublishMoodBaseActivity);
    }

    public void b() {
    }

    public void c() {
    }

    public void j(int i3) {
    }

    public void k() {
    }

    public void l() {
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }
}
