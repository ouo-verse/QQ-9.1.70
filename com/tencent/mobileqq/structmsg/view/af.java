package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class af extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    private String X0;
    private List<d> Y0;
    private RelativeLayout Z0;

    /* renamed from: a1, reason: collision with root package name */
    private TextView f290539a1;

    /* renamed from: b1, reason: collision with root package name */
    private String f290540b1;

    /* renamed from: c1, reason: collision with root package name */
    private String f290541c1;

    /* renamed from: d1, reason: collision with root package name */
    private String f290542d1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f290543d;

        a(Context context) {
            this.f290543d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) af.this, (Object) context);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas, (Object) recyclerView);
                return;
            }
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount - 1; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(ViewUtils.dip2px(1.0f));
                paint.setColor(this.f290543d.getResources().getColor(R.color.cme));
                Path path = new Path();
                float f16 = bottom;
                path.moveTo(paddingLeft, f16);
                path.lineTo(width, f16);
                paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 5.0f, 10.0f}, 0.0f));
                canvas.drawPath(path, paint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f290545d;

        b(Context context) {
            this.f290545d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) af.this, (Object) context);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = new Intent();
                intent.putExtra("url", af.this.f290541c1);
                RouteUtils.startActivity(this.f290545d, intent, RouterConstants.UI_ROUTE_BROWSER);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f290547a;

        c(int i3) {
            this.f290547a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) af.this, i3);
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
            } else {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(this.f290547a));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f290549a;

        /* renamed from: b, reason: collision with root package name */
        private String f290550b;

        /* renamed from: c, reason: collision with root package name */
        private String f290551c;

        /* renamed from: d, reason: collision with root package name */
        private int f290552d;

        /* renamed from: e, reason: collision with root package name */
        private int f290553e;

        /* renamed from: f, reason: collision with root package name */
        private String f290554f;

        /* renamed from: g, reason: collision with root package name */
        private String f290555g;

        /* renamed from: h, reason: collision with root package name */
        private String f290556h;

        /* renamed from: i, reason: collision with root package name */
        private String f290557i;

        /* renamed from: j, reason: collision with root package name */
        private String f290558j;

        d(String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, String str8) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), str4, str5, str6, str7, str8);
                return;
            }
            this.f290549a = str;
            this.f290550b = str2;
            this.f290551c = str3;
            this.f290552d = i3;
            this.f290553e = i16;
            this.f290554f = str4;
            this.f290555g = str5;
            this.f290556h = str6;
            this.f290557i = str7;
            this.f290558j = str8;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.f290557i;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.f290558j;
        }

        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.f290555g;
        }

        public String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f290551c;
        }

        public int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.f290553e;
        }

        public String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.f290556h;
        }

        public String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f290554f;
        }

        public int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.f290552d;
        }

        public String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f290550b;
        }

        public String l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f290549a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ImageView f290560d;

        /* renamed from: e, reason: collision with root package name */
        TextView f290561e;

        /* renamed from: f, reason: collision with root package name */
        TextView f290562f;

        /* renamed from: h, reason: collision with root package name */
        TextView f290563h;

        /* renamed from: i, reason: collision with root package name */
        Button f290564i;

        e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f290560d = (ImageView) view.findViewById(R.id.d39);
            this.f290561e = (TextView) view.findViewById(R.id.nickname);
            this.f290562f = (TextView) view.findViewById(R.id.xpc);
            this.f290563h = (TextView) view.findViewById(R.id.f122327dn);
            this.f290564i = (Button) view.findViewById(R.id.f83204iy);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Context f290565d;

        /* renamed from: e, reason: collision with root package name */
        private List<d> f290566e;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f290568d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f290569e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f290570f;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.structmsg.view.af$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes18.dex */
            class DialogInterfaceOnClickListenerC8625a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                DialogInterfaceOnClickListenerC8625a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }

            a(boolean z16, d dVar, String str) {
                this.f290568d = z16;
                this.f290569e = dVar;
                this.f290570f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, f.this, Boolean.valueOf(z16), dVar, str);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (this.f290568d) {
                    Intent intent = new Intent();
                    intent.putExtra("recv_uin", this.f290569e.f290549a);
                    intent.putExtra("recv_name", this.f290569e.f290550b);
                    intent.putExtra("birth_month", this.f290569e.j());
                    intent.putExtra("birth_day", this.f290569e.g());
                    intent.putExtra("pre_arc_color", af.this.P(this.f290570f));
                    ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).startBirthdayHbSuccessFragment(f.this.f290565d, intent);
                } else {
                    if (af.this.S(this.f290569e.j(), this.f290569e.g(), ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt(this.f290570f, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_INVALID_SPACE, 7))) {
                        DialogUtil.createCustomDialog(f.this.f290565d, 230, "", f.this.f290565d.getResources().getString(R.string.f211825lv), (String) null, f.this.f290565d.getString(R.string.f171151ok), new DialogInterfaceOnClickListenerC8625a(), (DialogInterface.OnClickListener) null).show();
                    } else {
                        f fVar = f.this;
                        af.this.Q(fVar.f290565d, this.f290569e.l(), this.f290569e.k(), this.f290569e.f());
                    }
                    ReportController.o(BaseApplicationImpl.sApplication.getRuntime(), "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "public.birthmessage.click", 0, 0, "", NetConnInfoCenter.getServerTime() + "", "", "");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public f(Context context, List<d> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, context, list);
            } else {
                this.f290565d = context;
                this.f290566e = list;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f290566e.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            Drawable M;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
            } else if (viewHolder instanceof e) {
                e eVar = (e) viewHolder;
                d dVar = this.f290566e.get(i3);
                if (dVar != null) {
                    AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                    if (waitAppRuntime instanceof AppInterface) {
                        eVar.f290560d.setImageDrawable(FaceDrawable.getUserFaceDrawable((AppInterface) waitAppRuntime, dVar.l(), (byte) 3));
                    }
                    eVar.f290561e.setText(dVar.k());
                    if (!TextUtils.isEmpty(dVar.i())) {
                        eVar.f290562f.setText(dVar.i());
                        eVar.f290562f.setVisibility(0);
                    }
                    String O = af.this.O(this.f290565d, dVar.j(), dVar.g());
                    if (!TextUtils.isEmpty(O)) {
                        eVar.f290563h.setText(O);
                        eVar.f290563h.setVisibility(0);
                    }
                    Drawable M2 = af.M(dVar.e(), dVar.h(), 10.0f);
                    if (M2 != null) {
                        eVar.f290562f.setBackgroundDrawable(M2);
                    }
                    String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
                    boolean z16 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getBoolean(account, dVar.f290549a, dVar.f(), false);
                    if (z16) {
                        eVar.f290564i.setText(this.f290565d.getResources().getString(R.string.f211855ly));
                        eVar.f290564i.setTextColor(this.f290565d.getResources().getColor(R.color.c_l));
                        M = af.L(20.0f, this.f290565d.getResources().getColor(R.color.f156932fm), 1.0f, this.f290565d.getResources().getColor(R.color.cme));
                    } else {
                        eVar.f290564i.setText(this.f290565d.getResources().getString(R.string.f211925m5));
                        eVar.f290564i.setTextColor(-1);
                        M = af.M(dVar.c(), dVar.d(), 20.0f);
                    }
                    eVar.f290564i.setBackgroundDrawable(M);
                    eVar.f290564i.setOnClickListener(new a(z16, dVar, account));
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            e eVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hgz, viewGroup, false));
            if (af.this.u()) {
                eVar.f290561e.setTextColor(-1);
                eVar.f290563h.setTextColor(-1);
            }
            return eVar;
        }
    }

    private void K(@NonNull RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundResource(R.drawable.j96);
        ((TextView) relativeLayout.findViewById(R.id.f81794f5)).setTextColor(-1);
        this.f290539a1.setTextColor(-1);
    }

    public static Drawable L(float f16, int i3, float f17, int i16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(ViewUtils.dip2px(f16));
        gradientDrawable.setStroke(ViewUtils.dip2px(f17), i16);
        return gradientDrawable;
    }

    public static Drawable M(String str, String str2, float f16) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(str), Color.parseColor(str2)});
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(ViewUtils.dip2px(f16));
            return gradientDrawable;
        } catch (Exception e16) {
            QLog.e("QWalletGdtAdApiStructMsgItemLayoutBirthdayReminder", 1, e16, new Object[0]);
            return null;
        }
    }

    private void N(Context context, RelativeLayout relativeLayout) {
        ((ImageView) relativeLayout.findViewById(R.id.t7z)).setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(this.f290540b1, new ColorDrawable(-1), new ColorDrawable(-1)));
        this.Z0.setOnClickListener(new b(context));
        int i3 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt(BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0);
        if (i3 > 0) {
            this.f290539a1.setText(i3 + context.getString(R.string.f211915m4));
            return;
        }
        this.f290539a1.setText(context.getString(R.string.f211885m1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String O(Context context, int i3, int i16) {
        String string;
        if (i3 < 0 || i16 < 1) {
            return "";
        }
        try {
            Calendar calendar = Calendar.getInstance();
            int i17 = calendar.get(1);
            int i18 = calendar.get(2);
            int i19 = calendar.get(5);
            if (i18 == i3 && i19 == i16) {
                string = context.getResources().getString(R.string.f211865lz);
            } else {
                if (i18 <= i3 && (i18 != i3 || i19 <= i16)) {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.set(i17, i3, i16);
                    string = ((int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000)) + context.getResources().getString(R.string.f211945m7);
                }
                string = context.getResources().getString(R.string.f211835lw);
            }
            return string;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P(String str) {
        try {
            String string = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(str, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_SKIN_LIST, "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 0) {
                return "";
            }
            return jSONArray.optJSONObject(0).optString(IQWalletPreferenceApi.KEY_BIRTHDAY_HB_SKIN_LIST_PRE_ARC_COLOR);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WadlProxyConsts.CHANNEL, 1000004);
            jSONObject.put("bus_type", 1);
            jSONObject.put("recv_type", 1);
            jSONObject.put("recv_uin", str);
            jSONObject.put("recv_name", str2);
            jSONObject.put("birthday", str3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        intent.putExtra("come_from", 2);
        intent.putExtra("extra_data", jSONObject.toString());
        intent.putExtra("isFromPanel", false);
        intent.addFlags(536870912);
        RouteUtils.startActivity(context, intent, "/qwallet/redpacket/sendhb");
    }

    private void R(Context context, RelativeLayout relativeLayout) {
        RecyclerView recyclerView = (RecyclerView) relativeLayout.findViewById(R.id.f164607t80);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new f(context, this.Y0));
        recyclerView.addItemDecoration(new a(context));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.f164609t82);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.f164611t84);
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.f164610t83);
        if (!TextUtils.isEmpty(this.f290542d1)) {
            String[] split = this.f290542d1.split("\\|");
            if (!TextUtils.isEmpty(split[0])) {
                textView.setText(split[0]);
                textView.setVisibility(0);
            }
            if (!TextUtils.isEmpty(split[1])) {
                textView2.setText(split[1]);
                textView2.setVisibility(0);
            }
            if (!TextUtils.isEmpty(split[2])) {
                textView3.setText(split[2]);
                textView3.setVisibility(0);
            }
        }
        this.Z0 = (RelativeLayout) relativeLayout.findViewById(R.id.f164608t81);
        this.f290539a1 = (TextView) relativeLayout.findViewById(R.id.f165659x61);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(int i3, int i16, int i17) {
        if (i3 < 0 || i16 < 1) {
            return true;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            int i18 = calendar.get(1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(i18, i3, i16);
            if ((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 86400000 > i17) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void U(View view, int i3) {
        view.setOutlineProvider(new c(i3));
        view.setClipToOutline(true);
    }

    public void T(RelativeLayout relativeLayout) {
        int i3;
        JSONArray jSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) relativeLayout);
            return;
        }
        try {
            if (TextUtils.isEmpty(this.X0)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.X0);
            this.f290540b1 = jSONObject.optString("bgImg");
            this.f290541c1 = jSONObject.optString("tailJumpURL");
            this.f290542d1 = jSONObject.optString("title");
            JSONArray optJSONArray = jSONObject.optJSONArray("birthList");
            if (optJSONArray != null) {
                int i16 = 0;
                while (i16 < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("uin");
                        String optString2 = optJSONObject.optString("nick");
                        String optString3 = optJSONObject.optString("thisBirthday");
                        String optString4 = optJSONObject.optString("interactiveName");
                        String optString5 = optJSONObject.optString("beginColor");
                        String optString6 = optJSONObject.optString("endColor");
                        String optString7 = optJSONObject.optString("actionBgBeginColor");
                        String optString8 = optJSONObject.optString("actionBgEndColor");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3)) {
                            try {
                                Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).parse(optString3);
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(parse);
                                i3 = i16;
                                jSONArray = optJSONArray;
                                try {
                                    this.Y0.add(new d(optString, optString2, optString3, calendar.get(2), calendar.get(5), optString4, optString5, optString6, optString7, optString8));
                                } catch (Exception e16) {
                                    e = e16;
                                    e.printStackTrace();
                                    i16 = i3 + 1;
                                    optJSONArray = jSONArray;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                i3 = i16;
                                jSONArray = optJSONArray;
                            }
                            i16 = i3 + 1;
                            optJSONArray = jSONArray;
                        }
                    }
                    i3 = i16;
                    jSONArray = optJSONArray;
                    i16 = i3 + 1;
                    optJSONArray = jSONArray;
                }
            }
            if (this.Y0.isEmpty()) {
                relativeLayout.setVisibility(8);
            }
        } catch (Exception e18) {
            QLog.e("QWalletGdtAdApiStructMsgItemLayoutBirthdayReminder", 1, e18, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 102666;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "StructMsgItemLayoutBirthdayReminder";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        if (context == null) {
            return null;
        }
        if (view instanceof RelativeLayout) {
            relativeLayout = (RelativeLayout) view;
        } else {
            relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.f168957hh0, (ViewGroup) null);
        }
        T(relativeLayout);
        R(context, relativeLayout);
        N(context, relativeLayout);
        U(relativeLayout, 8);
        if (u()) {
            K(relativeLayout);
        }
        return relativeLayout;
    }
}
