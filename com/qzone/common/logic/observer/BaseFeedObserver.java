package com.qzone.common.logic.observer;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import cooperation.qqfav.QfavHelper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFeedObserver implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    BaseFeedPresenter f46080d;

    public BaseFeedObserver(BaseFeedPresenter baseFeedPresenter) {
        this.f46080d = baseFeedPresenter;
    }

    private void b(boolean z16, String str, int i3) {
        if (this.f46080d.n0()) {
            if (3585 == i3) {
                QfavHelper.B(this.f46080d.H(), LoginData.getInstance().getUinString(), z16, str, false);
                return;
            }
            if (3586 == i3) {
                if (z16) {
                    ToastUtil.o(R.string.gfr, 5);
                } else if (TextUtils.isEmpty(str)) {
                    ToastUtil.n(R.string.b3x);
                } else {
                    ToastUtil.r(str);
                }
            }
        }
    }

    public void a() {
        EventCenter.getInstance().addUIObserver(this, "Feed", 2, 10, 7, 5, 24, 16, 22);
        EventCenter.getInstance().addUIObserver(this, "Favor", 1, 2);
        EventCenter.getInstance().addUIObserver(this, "Personalize", 19, 20);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (event.source.equals("Feed")) {
            int i3 = event.what;
            if (i3 == 2 || i3 == 5 || i3 == 7) {
                this.f46080d.L0();
                return;
            }
            if (i3 == 10) {
                this.f46080d.E().postDelayed(new Runnable() { // from class: com.qzone.common.logic.observer.BaseFeedObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseFeedObserver.this.f46080d.J0();
                    }
                }, 200L);
                return;
            } else {
                if (i3 == 16 || i3 == 22) {
                    this.f46080d.I0(0L);
                    this.f46080d.p0();
                    return;
                }
                return;
            }
        }
        if (event.source.equals("Personalize")) {
            int i16 = event.what;
            if (i16 == 19 || i16 == 20) {
                this.f46080d.I0(0L);
                return;
            }
            return;
        }
        if ("Favor".equals(event.source.getName())) {
            Object[] objArr = (Object[]) event.params;
            int i17 = event.what;
            if (i17 == 1) {
                Boolean bool = (Boolean) objArr[1];
                b(bool.booleanValue(), (String) objArr[2], 3585);
            } else {
                if (i17 != 2) {
                    return;
                }
                Boolean bool2 = (Boolean) objArr[1];
                b(bool2.booleanValue(), (String) objArr[2], 3586);
            }
        }
    }
}
