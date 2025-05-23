package com.tencent.av.ui.part.invite.multi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.u;
import com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mw.l;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends Part implements l {
    private long C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private View H;

    /* renamed from: d, reason: collision with root package name */
    private TextView f76532d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f76533e;

    /* renamed from: f, reason: collision with root package name */
    private long f76534f;

    /* renamed from: h, reason: collision with root package name */
    private int f76535h;

    /* renamed from: i, reason: collision with root package name */
    private int f76536i;

    /* renamed from: m, reason: collision with root package name */
    private int f76537m;

    public b(boolean z16, long j3, int i3, int i16, int i17, long j16, boolean z17, boolean z18, boolean z19) {
        this.f76532d = null;
        this.f76533e = null;
        this.H = null;
        this.f76534f = j3;
        this.f76535h = i3;
        this.f76536i = i16;
        this.f76537m = i17;
        this.C = j16;
        this.D = z16;
        this.E = z17;
        this.F = z18;
        this.G = z19;
    }

    private CharSequence x9(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        String string = context.getString(R.string.f1781435v);
        String string2 = context.getString(R.string.f1781335u);
        String string3 = context.getString(R.string.f1781535w);
        int length = str.startsWith(string) ? string.length() : -1;
        int indexOf = str.endsWith(string2) ? str.indexOf(string2) : -1;
        if (str.endsWith(string3)) {
            indexOf = str.indexOf(string3);
        }
        if (length == -1 || indexOf == -1) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(0, 202, 252)), length, indexOf, 33);
        return spannableString;
    }

    void B9() {
        int i3;
        TextView textView = this.f76532d;
        if (textView == null) {
            return;
        }
        textView.setSingleLine();
        if (NTGaInviteBaseFragment.xh(this.f76536i)) {
            this.f76532d.setText(z9(this.f76535h, this.f76534f, null, this.E, true));
        } else if (this.F) {
            this.f76532d.setText(R.string.dep);
        } else {
            if (this.E) {
                i3 = (this.G && ax.a.c(nw.b.b())) ? R.string.f17819360 : R.string.f171244df0;
            } else {
                i3 = R.string.f171245df1;
            }
            this.f76532d.setText(i3);
        }
        if (ThemeUtil.isInNightMode(nw.b.b())) {
            int parseColor = Color.parseColor("#A8A8A8");
            this.f76532d.setTextColor(parseColor);
            this.f76533e.setTextColor(parseColor);
        }
    }

    public void C9(View view) {
        this.H = view;
    }

    @Override // mw.l
    public void O6(int i3, long j3, String str) {
        if (this.f76532d != null) {
            this.f76532d.setText(x9(z9(i3, j3, str, true, false)));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (this.D) {
            this.f76532d = (TextView) this.H.findViewById(R.id.gar);
            this.f76533e = (TextView) this.H.findViewById(R.id.gan);
            if (u.d()) {
                this.f76533e.setText(R.string.ddy);
                if (getContext() != null && getContext().getResources() != null) {
                    this.f76533e.setTextColor(getContext().getResources().getColor(R.color.f157517rr));
                }
            } else if (nw.b.b() != null && nw.b.b().a0()) {
                this.f76533e.setText(R.string.zcu);
                if (getContext() != null && getContext().getResources() != null) {
                    this.f76533e.setTextColor(getContext().getResources().getColor(R.color.f157517rr));
                }
            }
            B9();
            return;
        }
        this.f76532d = (TextView) view.findViewById(R.id.g8s);
        RFWIocAbilityProvider.g().registerIoc(view, this, l.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (!this.D) {
            RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), l.class);
        }
        this.f76532d = null;
        this.f76533e = null;
        this.H = null;
    }

    public String z9(int i3, long j3, String str, boolean z16, boolean z17) {
        Resources resources;
        String format;
        String str2;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        SessionInfo i16 = n.e().i(n.b(i3, String.valueOf(j3), new int[0]));
        if (i16 != null && i16.f73042j2 == 4) {
            format = context.getString(R.string.dep);
            com.tencent.av.screenshare.c.i(i16.f73030h, 1, "getGInviteWording");
        } else {
            int i17 = R.string.df5;
            if (z17) {
                float dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.a6v);
                if (TextUtils.isEmpty(str) && nw.b.b() != null) {
                    str = nw.b.b().G(this.f76536i, String.valueOf(this.f76534f), null);
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = ba.getNameMaxMaseaured(context, str, this.f76532d, dimensionPixelSize);
                } else {
                    str2 = "";
                }
                if (!z16) {
                    i17 = R.string.df7;
                }
                format = String.format(resources.getString(i17), str2);
            } else {
                if (TextUtils.isEmpty(str) && nw.b.b() != null) {
                    str = nw.b.b().G(this.f76536i, String.valueOf(this.f76534f), null);
                }
                String nameMaxMaseaured = ba.getNameMaxMaseaured(context, str, this.f76532d, resources.getDimensionPixelSize(R.dimen.f158932sr));
                if (!z16) {
                    i17 = R.string.df7;
                }
                format = String.format(resources.getString(i17), nameMaxMaseaured);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("GaInviteMemberListPart", 2, "getGInviteWording, relationType[" + i3 + "], groupId[" + i3 + "], groupName[" + str + "], isOnlyAudio[" + z16 + "], fromMultiCall[" + z17 + "], inviteHintStr[" + format + "]");
        }
        return format;
    }

    public void A9(boolean z16) {
        Context context;
        if (!z16 || (context = getContext()) == null || nw.b.b() == null) {
            return;
        }
        String valueOf = String.valueOf(this.f76534f);
        int f16 = AVUtil.f(this.f76535h);
        String G = nw.b.b().G(f16, Long.toString(this.C), valueOf);
        if (context.getString(R.string.bhi).equalsIgnoreCase(this.f76532d.getText().toString())) {
            G = z9(this.f76535h, this.f76534f, null, true, false);
            this.f76532d.setText(G);
        }
        if (this.f76537m == 17) {
            G = context.getString(R.string.bhi);
            this.f76532d.setText(G);
        }
        if (QLog.isDebugVersion()) {
            QLog.w("GaInviteMemberListPart", 1, "onWindowFocusChanged, uinTypeInvite[" + f16 + "], inviteFriendName[" + G + "]");
        }
        getPartRootView().findViewById(R.id.g8t).setContentDescription(G);
    }

    public b(long j3, int i3, int i16, int i17, long j16) {
        this(false, j3, i3, i16, i17, j16, false, false, false);
    }
}
