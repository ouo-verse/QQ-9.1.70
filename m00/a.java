package m00;

import android.view.View;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f415906a;

    /* renamed from: b, reason: collision with root package name */
    private int f415907b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f415908c = true;

    /* renamed from: d, reason: collision with root package name */
    private long f415909d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: m00.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10755a extends b {
        C10755a() {
        }

        @Override // m00.b, com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void hide() {
            super.hide();
            if (a.this.f415906a != null) {
                a.this.f415906a.setVisibility(4);
                a.this.f415907b = 0;
            }
        }

        @Override // m00.b, com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void updateUnreadCount(int i3, boolean z16) {
            super.updateUnreadCount(i3, z16);
            if (i3 == 0) {
                a.this.f415907b = 0;
                return;
            }
            if (i3 <= a.this.f415907b || a.this.f415906a == null) {
                return;
            }
            if (a.this.f415908c) {
                a.this.f415906a.setVisibility(0);
            }
            a.this.f415907b = i3;
            a.this.f415909d = System.currentTimeMillis();
        }
    }

    private IMiniMsgUnreadCallback f() {
        return new C10755a();
    }

    public MiniMsgUserParam g() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 6;
        miniMsgUserParam.accessType = 2;
        miniMsgUserParam.filterMsgType = 0;
        miniMsgUserParam.unreadCallback = f();
        return miniMsgUserParam;
    }

    public long h() {
        return this.f415909d;
    }

    public int i() {
        return this.f415907b;
    }

    public void j(MiniMsgUser miniMsgUser) {
        View view;
        if (this.f415907b <= 0 || miniMsgUser == null || (view = this.f415906a) == null) {
            return;
        }
        this.f415907b = 0;
        view.setVisibility(4);
        miniMsgUser.onClick(this.f415906a);
    }

    public void k(View view) {
        this.f415906a = view;
    }

    public void l(boolean z16) {
        this.f415908c = z16;
    }
}
