package com.tencent.mobileqq.gamecenter.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l extends PopupWindow implements OnlineStatusController.a, View.OnClickListener {
    private Bundle C;
    private View.OnClickListener D;
    private View E;
    private float F;

    /* renamed from: d, reason: collision with root package name */
    private Activity f213312d;

    /* renamed from: e, reason: collision with root package name */
    private OnlineStatusController f213313e;

    /* renamed from: f, reason: collision with root package name */
    private View f213314f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f213315h;

    /* renamed from: i, reason: collision with root package name */
    private Animation f213316i;

    /* renamed from: m, reason: collision with root package name */
    private gd1.a f213317m;

    l(AppInterface appInterface, Activity activity, gd1.a aVar, View view, Bundle bundle, View.OnClickListener onClickListener) {
        super(view, -1, -1);
        this.F = 0.0f;
        this.f213312d = activity;
        this.f213317m = aVar;
        this.C = bundle;
        this.D = onClickListener;
    }

    public static l e(AppInterface appInterface, Activity activity, gd1.a aVar, Bundle bundle, View.OnClickListener onClickListener) {
        l lVar = new l(appInterface, activity, aVar, LayoutInflater.from(activity).inflate(R.layout.ea6, (ViewGroup) null), bundle, onClickListener);
        lVar.i();
        return lVar;
    }

    private void f(View view) {
        Drawable drawable;
        String string = this.C.getString("onlineText");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.xnq);
        textView.setVisibility(0);
        textView.setText(string);
        int i3 = this.f213317m.f401946j;
        if (i3 != 1) {
            if (i3 != 2) {
                drawable = null;
            } else {
                drawable = view.getResources().getDrawable(R.drawable.f160756mu0);
            }
        } else {
            drawable = view.getResources().getDrawable(R.drawable.bzf);
        }
        if (drawable == null) {
            return;
        }
        int f16 = BaseAIOUtils.f(28.0f, view.getResources());
        drawable.setBounds(0, 0, f16, f16);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawablePadding(Utils.n(4.0f, MobileQQ.sMobileQQ.getResources()));
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    private void g(View view) {
        ArrayList<String> stringArrayList = this.C.getStringArrayList("priorityIconList");
        ArrayList<String> stringArrayList2 = this.C.getStringArrayList("priorityDetailList");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() > 0 && stringArrayList.size() == stringArrayList2.size()) {
            View findViewById = view.findViewById(R.id.xna);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.xnd);
            findViewById.setVisibility(0);
            Context context = view.getContext();
            for (int i3 = 0; i3 < stringArrayList.size() && i3 < 4; i3++) {
                View inflate = View.inflate(context, R.layout.ea7, null);
                ((TextView) inflate.findViewById(R.id.xnb)).setText(stringArrayList2.get(i3));
                ((ImageView) inflate.findViewById(R.id.xnc)).setImageDrawable(URLDrawable.getDrawable(stringArrayList.get(i3)));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = BaseAIOUtils.f(13.0f, context.getResources());
                layoutParams.rightMargin = BaseAIOUtils.f(13.0f, context.getResources());
                linearLayout.addView(inflate, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        m(0.5f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        m(1.0f, false);
        this.E.setOnClickListener(null);
    }

    private void l(TextView textView) {
        TextPaint paint = textView.getPaint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(1.0f);
    }

    private void m(float f16, boolean z16) {
        Window window = this.f213312d.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f16;
            if (z16) {
                this.F = attributes.dimAmount;
                attributes.dimAmount = 1.0f;
            } else {
                attributes.dimAmount = this.F;
            }
            window.setAttributes(attributes);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.OnlineStatusController.a
    public void b(int i3) {
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        try {
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("GameAioOnlineStatusPopUpWindow", 1, "dismiss e:" + th5);
        }
    }

    public void h() {
        int i3;
        String str;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        View view = this.f213314f;
        if (isNowThemeIsNight) {
            i3 = R.drawable.jnz;
        } else {
            i3 = R.drawable.jny;
        }
        view.setBackgroundResource(i3);
        TextView textView = this.f213315h;
        if (isNowThemeIsNight) {
            str = "#FFFFFF";
        } else {
            str = "#03081A";
        }
        textView.setTextColor(Color.parseColor(str));
        l(this.f213315h);
    }

    protected void i() {
        View contentView = getContentView();
        this.f213313e = (OnlineStatusController) contentView.findViewById(R.id.content);
        this.E = contentView.findViewById(R.id.xn_);
        this.f213315h = (TextView) contentView.findViewById(R.id.xnq);
        this.f213314f = contentView.findViewById(R.id.zxm);
        ImageView imageView = (ImageView) contentView.findViewById(R.id.xnf);
        TextView textView = (TextView) contentView.findViewById(R.id.xny);
        TextView textView2 = (TextView) contentView.findViewById(R.id.xne);
        ImageView imageView2 = (ImageView) contentView.findViewById(R.id.xn9);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) contentView.findViewById(R.id.xng);
        if (!TextUtils.isEmpty(this.f213317m.f401940d)) {
            imageView.setImageDrawable(URLDrawable.getDrawable(this.f213317m.f401940d));
            int f16 = BaseAIOUtils.f(36.0f, contentView.getResources());
            ViewGroup.LayoutParams layoutParams = roundRelativeLayout.getLayoutParams();
            layoutParams.width = f16;
            layoutParams.height = f16;
            roundRelativeLayout.setLayoutParams(layoutParams);
            roundRelativeLayout.f316195e = f16 / 2;
        }
        if (!TextUtils.isEmpty(this.f213317m.f401941e)) {
            textView.setText(this.f213317m.f401941e);
        }
        if (!TextUtils.isEmpty(this.f213317m.f401948l)) {
            imageView2.setImageDrawable(URLDrawable.getDrawable(this.f213317m.f401948l));
        }
        String string = this.C.getString("startBtnText");
        if (!TextUtils.isEmpty(string)) {
            textView2.setText(string);
            this.E.setOnClickListener(this.D);
        }
        contentView.findViewById(R.id.mb7).setOnClickListener(this);
        contentView.findViewById(R.id.ebu).setOnClickListener(this);
        contentView.setOnClickListener(this);
        this.f213313e.setDisableMinScrollY(true);
        this.f213313e.setAtPanelTouchListener(this);
        f(contentView);
        g(contentView);
        h();
        IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
        gd1.a aVar = this.f213317m;
        iGameMsgHelperApi.reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208986", "", "", "8", String.valueOf(aVar.f401946j));
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.gamecenter.ui.k
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                l.this.k();
            }
        });
    }

    public void n() {
        this.f213313e.scrollTo(0, 0);
        Animation animation = this.f213316i;
        if (animation != null && !animation.hasEnded()) {
            return;
        }
        if (this.f213316i == null) {
            this.f213316i = AnimationUtils.loadAnimation(this.f213312d, R.anim.f154454a3);
        }
        this.f213313e.startAnimation(this.f213316i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mb7 || id5 == R.id.content) {
            dismiss();
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            gd1.a aVar = this.f213317m;
            iGameMsgHelperApi.reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208987", "2", "", "20", String.valueOf(aVar.f401946j));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        super.showAtLocation(view, i3, i16, i17);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                l.this.j();
            }
        }, 400L);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.OnlineStatusController.a
    public void scrollToTop() {
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.OnlineStatusController.a
    public void a(boolean z16) {
    }
}
