package com.tencent.mobileqq.qqlive.room.multichat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher;
import com.tencent.mobileqq.qqlive.room.multichat.base.MultiAvChatType;
import com.tencent.mobileqq.qqlive.room.multichat.store.b;
import com.tencent.mobileqq.qqlive.room.multichat.store.c;
import com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatEmptySeatView;
import com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatSeatView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class MultiAvChatBaseDisplayView extends RelativeLayout implements MultiAvChatEmptySeatView.b, MultiAvChatSeatView.a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    protected static final int[] f271693i;

    /* renamed from: d, reason: collision with root package name */
    private final IAegisLogApi f271694d;

    /* renamed from: e, reason: collision with root package name */
    protected int[] f271695e;

    /* renamed from: f, reason: collision with root package name */
    protected MultiAvChatType f271696f;

    /* renamed from: h, reason: collision with root package name */
    protected c f271697h;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            f271693i = new int[]{R.id.zhu, R.id.zhv, R.id.zhw, R.id.zhx, R.id.zhy, R.id.zhz, R.id.f166342zi0, R.id.f166343zi1, R.id.f166344zi2};
        }
    }

    public MultiAvChatBaseDisplayView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f271694d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f271695e = new int[0];
        this.f271696f = MultiAvChatType.LIVE_BOX_NONE;
        c(context);
    }

    private void c(Context context) {
        this.f271697h = new c(context);
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatSeatView.a
    public void a(@NonNull b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bVar, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatEmptySeatView.b
    public void b(MultiAvChatEmptySeatView.EmptySeatType emptySeatType, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, emptySeatType, Integer.valueOf(i3), str);
        }
    }

    protected void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            this.f271694d.i("MultiChatBaseDisplayView", str);
        }
    }

    public void setOnItemClickListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) aVar);
        }
    }

    public void setPlayerLiveType(ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType playerLiveType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) playerLiveType);
            return;
        }
        d("setPlayerLiveType type:" + playerLiveType);
        int i3 = 0;
        while (true) {
            int[] iArr = this.f271695e;
            if (i3 < iArr.length) {
                MultiAvChatSeatView multiAvChatSeatView = (MultiAvChatSeatView) findViewById(iArr[i3]);
                multiAvChatSeatView.h().i(playerLiveType);
                multiAvChatSeatView.h().h(playerLiveType);
                i3++;
            } else {
                return;
            }
        }
    }

    public void setPlayerTypeChangeEnd(ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType playerLiveType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) playerLiveType);
            return;
        }
        d("setPlayerTypeChangeEnd type:" + playerLiveType);
        int i3 = 0;
        while (true) {
            int[] iArr = this.f271695e;
            if (i3 < iArr.length) {
                ((MultiAvChatSeatView) findViewById(iArr[i3])).h().h(playerLiveType);
                i3++;
            } else {
                return;
            }
        }
    }

    public MultiAvChatBaseDisplayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f271694d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f271695e = new int[0];
        this.f271696f = MultiAvChatType.LIVE_BOX_NONE;
        c(context);
    }

    public MultiAvChatBaseDisplayView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f271694d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f271695e = new int[0];
        this.f271696f = MultiAvChatType.LIVE_BOX_NONE;
        c(context);
    }
}
