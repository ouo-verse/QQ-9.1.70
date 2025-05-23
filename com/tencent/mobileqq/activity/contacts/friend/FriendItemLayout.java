package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FriendItemLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static int f181590e;

    /* renamed from: f, reason: collision with root package name */
    private static Map<CharSequence, Integer> f181591f;

    /* renamed from: d, reason: collision with root package name */
    private BuddyListFriends.a f181592d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f181591f = new HashMap(5);
        }
    }

    public FriendItemLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    private void b() {
        int i3;
        int i16;
        int i17 = ((FrameLayout.LayoutParams) this.f181592d.C.getLayoutParams()).leftMargin;
        if (this.f181592d.C.getVisibility() != 8) {
            CharSequence a16 = this.f181592d.C.a();
            if (f181591f.containsKey(a16)) {
                i16 = f181591f.get(a16).intValue();
            } else {
                int measureText = (int) this.f181592d.C.b().measureText(a16, 0, a16.length());
                f181591f.put(a16, Integer.valueOf(measureText));
                i16 = measureText;
            }
            this.f181592d.C.setFixedWidth(i16);
            i17 += i16 + f181590e;
        }
        OnlineStatusView onlineStatusView = this.f181592d.P;
        if (onlineStatusView != null && onlineStatusView.getVisibility() != 8) {
            CharSequence a17 = this.f181592d.P.a();
            if (f181591f.containsKey(a17)) {
                i3 = f181591f.get(a17).intValue();
            } else {
                int b16 = this.f181592d.P.b();
                f181591f.put(a17, Integer.valueOf(b16));
                i3 = b16;
            }
            i17 += i3 + f181590e;
        }
        if (this.f181592d.D.getVisibility() != 8) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f181592d.D.getLayoutParams();
            layoutParams.leftMargin = i17;
            i17 += layoutParams.width + f181590e;
        }
        if (this.f181592d.E.getVisibility() != 8) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f181592d.E.getLayoutParams();
            layoutParams2.leftMargin = i17;
            i17 += layoutParams2.width + f181590e;
        }
        if (this.f181592d.F.getVisibility() != 8) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f181592d.F.getLayoutParams();
            layoutParams3.leftMargin = i17;
            i17 += layoutParams3.width + f181590e;
        }
        ((FrameLayout.LayoutParams) this.f181592d.f181512i.getLayoutParams()).leftMargin = i17;
        getContext().getResources().getDimensionPixelSize(R.dimen.f158599k2);
        BuddyListFriends.a aVar = this.f181592d;
        aVar.K.e(aVar.H, aVar, 0);
    }

    public BuddyListFriends.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BuddyListFriends.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        BuddyListFriends.a aVar = new BuddyListFriends.a();
        this.f181592d = aVar;
        aVar.f187116f = (QQProAvatarView) findViewById(R.id.icon);
        this.f181592d.f181511h = (SingleLineTextView) findViewById(R.id.text1);
        this.f181592d.C = (SimpleTextView) findViewById(R.id.k_1);
        this.f181592d.D = (ImageView) findViewById(R.id.dyc);
        this.f181592d.E = (ImageView) findViewById(R.id.dxc);
        this.f181592d.F = (URLImageView) findViewById(R.id.dxf);
        this.f181592d.f181512i = (SingleLineTextView) findViewById(R.id.text2);
        this.f181592d.G = (ImageView) findViewById(R.id.dyk);
        this.f181592d.K = (MutualMarkIconsView) findViewById(R.id.lwx);
        this.f181592d.I = (URLImageView) findViewById(R.id.f165941dw0);
        this.f181592d.J = findViewById(R.id.j0s);
        this.f181592d.H = (LinearLayout) findViewById(R.id.f99);
        this.f181592d.P = (OnlineStatusView) findViewById(R.id.a86);
        this.f181592d.f181512i.setExtendTextColor(RichStatus.sActionColor, 1);
        this.f181592d.f181512i.setExtendTextSize(14.0f, 1);
        this.f181592d.f181512i.setGravity(19);
        OnlineStatusView onlineStatusView = this.f181592d.P;
        if (onlineStatusView != null) {
            onlineStatusView.setViewStyle(2);
        }
        if (f181590e == 0) {
            f181590e = getContext().getResources().getDimensionPixelSize(R.dimen.k_);
        }
        return this.f181592d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            b();
            super.onMeasure(i3, i16);
        }
    }

    public FriendItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
