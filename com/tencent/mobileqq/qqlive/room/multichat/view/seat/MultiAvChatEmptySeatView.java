package com.tencent.mobileqq.qqlive.room.multichat.view.seat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatEmptySeatView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.qqlive.room.multichat.store.c C;

    /* renamed from: d, reason: collision with root package name */
    private TextView f271822d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f271823e;

    /* renamed from: f, reason: collision with root package name */
    private int f271824f;

    /* renamed from: h, reason: collision with root package name */
    private String f271825h;

    /* renamed from: i, reason: collision with root package name */
    private EmptySeatType f271826i;

    /* renamed from: m, reason: collision with root package name */
    private b f271827m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class EmptySeatType {
        private static final /* synthetic */ EmptySeatType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final EmptySeatType Apply;
        public static final EmptySeatType Invite;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56368);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EmptySeatType emptySeatType = new EmptySeatType("Apply", 0);
            Apply = emptySeatType;
            EmptySeatType emptySeatType2 = new EmptySeatType("Invite", 1);
            Invite = emptySeatType2;
            $VALUES = new EmptySeatType[]{emptySeatType, emptySeatType2};
        }

        EmptySeatType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static EmptySeatType valueOf(String str) {
            return (EmptySeatType) Enum.valueOf(EmptySeatType.class, str);
        }

        public static EmptySeatType[] values() {
            return (EmptySeatType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiAvChatEmptySeatView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getActionMasked() == 0 && MultiAvChatEmptySeatView.this.f271827m != null) {
                MultiAvChatEmptySeatView.this.f271827m.b(MultiAvChatEmptySeatView.this.f271826i, MultiAvChatEmptySeatView.this.f271824f, MultiAvChatEmptySeatView.this.f271825h);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void b(EmptySeatType emptySeatType, int i3, String str);
    }

    public MultiAvChatEmptySeatView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f271825h = "";
        this.f271826i = EmptySeatType.Apply;
        f();
    }

    private void f() {
        View.inflate(getContext(), R.layout.f168916ha4, this);
        this.f271823e = (ImageView) findViewById(R.id.f81534ef);
        this.f271822d = (TextView) findViewById(R.id.jqb);
        setOnTouchListener(new a());
        e(true);
    }

    private void g(EmptySeatType emptySeatType) {
        String str;
        if (emptySeatType == EmptySeatType.Invite) {
            str = "\u9080\u8bf7\u4e0a\u9ea6";
        } else if (emptySeatType == EmptySeatType.Apply) {
            str = "\u70b9\u51fb\u4e0a\u9ea6";
        } else {
            str = "";
        }
        this.f271822d.setText(str);
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (z16) {
            setBackgroundColor(-2130706432);
        } else {
            setBackgroundResource(17170445);
        }
    }

    public void setOnClickedEmptySeatListener(@NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            this.f271827m = bVar;
        }
    }

    public void setSeatName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f271825h = str;
        }
    }

    public void setSeatNo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f271823e.setImageDrawable(this.C.a(i3));
            this.f271824f = i3;
        }
    }

    public void setSeatNoRes(com.tencent.mobileqq.qqlive.room.multichat.store.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
        } else {
            this.C = cVar;
        }
    }

    public void setSeatType(EmptySeatType emptySeatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) emptySeatType);
        } else {
            this.f271826i = emptySeatType;
            g(emptySeatType);
        }
    }

    public MultiAvChatEmptySeatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f271825h = "";
        this.f271826i = EmptySeatType.Apply;
        f();
    }

    public MultiAvChatEmptySeatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f271825h = "";
        this.f271826i = EmptySeatType.Apply;
        f();
    }
}
