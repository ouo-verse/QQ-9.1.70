package com.tencent.mobileqq.qqlive.room.multichat.view.seat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatUserInfoView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f271835d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f271836e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271837f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f271838h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class UserType {
        private static final /* synthetic */ UserType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final UserType GOLD_TYPE;
        public static final UserType NORMAL_TYPE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56375);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            UserType userType = new UserType("NORMAL_TYPE", 0);
            NORMAL_TYPE = userType;
            UserType userType2 = new UserType("GOLD_TYPE", 1);
            GOLD_TYPE = userType2;
            $VALUES = new UserType[]{userType, userType2};
        }

        UserType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static UserType valueOf(String str) {
            return (UserType) Enum.valueOf(UserType.class, str);
        }

        public static UserType[] values() {
            return (UserType[]) $VALUES.clone();
        }
    }

    public MultiAvChatUserInfoView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f271838h = false;
            a();
        }
    }

    private void a() {
        View.inflate(getContext(), R.layout.ha7, this);
        ImageView imageView = (ImageView) findViewById(R.id.zkn);
        this.f271835d = imageView;
        imageView.setVisibility(4);
        TextView textView = (TextView) findViewById(R.id.zr7);
        this.f271836e = textView;
        textView.setVisibility(4);
        TextView textView2 = (TextView) findViewById(R.id.f165376vq4);
        this.f271837f = textView2;
        textView2.setVisibility(4);
        setBackgroundResource(17170445);
    }

    public void setGiftScore(String str, UserType userType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) userType);
            return;
        }
        this.f271837f.setText(str);
        if (userType == UserType.GOLD_TYPE) {
            this.f271837f.setBackgroundResource(R.drawable.f160821my1);
            setBackgroundResource(R.drawable.f160820js4);
        } else if (userType == UserType.NORMAL_TYPE) {
            this.f271837f.setBackgroundResource(R.drawable.k4m);
            setBackgroundResource(17170445);
        }
    }

    public void setNickName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f271836e.setText(str);
        }
    }

    public MultiAvChatUserInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f271838h = false;
            a();
        }
    }

    public MultiAvChatUserInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f271838h = false;
            a();
        }
    }
}
