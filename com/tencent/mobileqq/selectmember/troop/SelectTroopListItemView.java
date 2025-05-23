package com.tencent.mobileqq.selectmember.troop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.widget.ForwardHeadView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectTroopListItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    public QUICheckBox C;
    public RelativeLayout D;
    public boolean E;
    public View F;
    public TextView G;
    public String H;
    public int I;
    public int J;
    public ResultRecord K;

    /* renamed from: d, reason: collision with root package name */
    public View f286005d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f286006e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f286007f;

    /* renamed from: h, reason: collision with root package name */
    public TextView f286008h;

    /* renamed from: i, reason: collision with root package name */
    public ForwardHeadView f286009i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f286010m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f286011a;

        /* renamed from: b, reason: collision with root package name */
        public String f286012b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f286013c;

        /* renamed from: d, reason: collision with root package name */
        public ResultRecord f286014d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f286015e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f286016f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f286017g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f286018h;

        /* renamed from: i, reason: collision with root package name */
        public String f286019i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SelectTroopListItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = false;
        c();
        b();
    }

    private void b() {
        this.I = getResources().getDimensionPixelOffset(R.dimen.aet);
        this.J = getResources().getDimensionPixelOffset(R.dimen.f158606ka);
    }

    private void c() {
        View inflate = View.inflate(getContext(), R.layout.f169087hq2, this);
        this.f286005d = inflate;
        this.D = (RelativeLayout) inflate.findViewById(R.id.ibz);
        this.f286006e = (TextView) this.f286005d.findViewById(R.id.f27640gs);
        this.f286007f = (TextView) this.f286005d.findViewById(R.id.text1);
        this.f286008h = (TextView) this.f286005d.findViewById(R.id.text2);
        ForwardHeadView forwardHeadView = (ForwardHeadView) this.f286005d.findViewById(R.id.head);
        this.f286009i = forwardHeadView;
        this.f286010m = forwardHeadView.a();
        this.C = (QUICheckBox) this.f286005d.findViewById(R.id.axa);
        this.F = this.f286005d.findViewById(R.id.kab);
        this.G = (TextView) this.f286005d.findViewById(R.id.f167042k73);
    }

    public void a(@NonNull a aVar) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.H = aVar.f286011a;
        ResultRecord resultRecord = aVar.f286014d;
        this.K = resultRecord;
        if (resultRecord != null && AppConstants.DATALINE_GUILD_UIN.equals(resultRecord.uin) && ((i16 = this.K.uinType) == 10016 || i16 == 10014)) {
            this.f286009i.setShowGuildIcon(true);
        } else {
            this.f286009i.setShowGuildIcon(false);
        }
        this.f286007f.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(aVar.f286011a, 16));
        this.f286010m.setImageDrawable(aVar.f286013c);
        if (TextUtils.isEmpty(aVar.f286012b)) {
            this.f286008h.setVisibility(8);
        } else {
            this.f286008h.setVisibility(0);
            if (aVar.f286012b.startsWith("(")) {
                this.f286008h.setText(aVar.f286012b);
            } else {
                this.f286008h.setText(String.format("(%s)", aVar.f286012b));
            }
        }
        View view = this.F;
        if (view != null) {
            if (aVar.f286017g) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        int i17 = this.I;
        layoutParams.leftMargin = -i17;
        int i18 = this.J;
        if (aVar.f286015e) {
            layoutParams.leftMargin = 0;
            i18 -= i17;
        }
        this.D.setLayoutParams(layoutParams);
        if (aVar.f286018h) {
            this.C.setChecked(aVar.f286016f);
        } else {
            this.C.setChecked(false);
        }
        this.C.setEnabled(aVar.f286018h);
        this.f286007f.setMaxWidth(i18);
        if (!TextUtils.isEmpty(aVar.f286019i)) {
            this.G.setVisibility(0);
            this.G.setText(aVar.f286019i);
        } else {
            this.G.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            setContentDescription(this.H);
        }
    }
}
