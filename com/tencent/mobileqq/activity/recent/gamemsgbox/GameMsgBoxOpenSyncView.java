package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxOpenSyncView extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private int G;
    private String H;
    private float I;
    private long J;

    /* renamed from: d, reason: collision with root package name */
    private Button f185429d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f185430e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f185431f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f185432h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f185433i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f185434m;

    public GameMsgBoxOpenSyncView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e() {
        float f16 = getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
        if (f16 != 1.0d) {
            float f17 = this.I;
            if (f17 == 0.0f || f17 != f16) {
                this.I = f16;
                aw.r(this.f185431f);
                aw.r(this.f185433i);
                aw.r(this.f185434m);
                aw.r(this.C);
                aw.r(this.D);
                aw.r(this.E);
                aw.r(this.f185429d);
                aw.r(this.F);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgBoxOpenSyncView", 2, "fontsize doenst change");
        }
    }

    private void f(ImageView imageView, Context context, String str) {
        Drawable drawable;
        if (imageView == null) {
            return;
        }
        URLDrawable uRLDrawable = null;
        try {
            drawable = context.getResources().getDrawable(R.drawable.f160830com);
        } catch (OutOfMemoryError e16) {
            QLog.e("GameMsgBoxOpenSyncView", 1, "-->create color drawable oom.", e16);
            drawable = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            QLog.e("GameMsgBoxOpenSyncView", 1, "setImageUrl exception url=", str, ",excption=", e17);
        }
        if (uRLDrawable != null) {
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
            if (uRLDrawable.getStatus() != 2) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                QLog.e("GameMsgBoxOpenSyncView", 1, "getImageError: ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(AppInterface appInterface, GameSwitchConfig gameSwitchConfig) {
        GameBasicInfo findGameConfig;
        String str;
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (gameSwitchConfig == null) {
            findGameConfig = null;
        } else {
            findGameConfig = iGameMsgManagerService.findGameConfig(gameSwitchConfig.mAppId);
        }
        if (findGameConfig == null) {
            str = "";
        } else {
            str = findGameConfig.mName;
        }
        ((IGameMsgBoxManager) appInterface.getRuntimeService(IGameMsgBoxManager.class, "")).setConfigToNTKernel(appInterface, gameSwitchConfig, str, true);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        VideoReport.setElementId(this.f185429d, "em_gb_authority");
        VideoReport.setElementClickPolicy(this.f185429d, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.f185429d, ExposurePolicy.REPORT_ALL);
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgBoxOpenSyncView", 2, "initDtReport.");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view.getId() == R.id.vi_) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.J < 1000) {
                if (QLog.isColorLevel()) {
                    QLog.d("GameMsgBoxOpenSyncView", 2, "click too often, please try again.");
                }
            } else if (TextUtils.isEmpty(this.H)) {
                QLog.e("GameMsgBoxOpenSyncView", 2, "appId is null.");
            } else {
                this.J = currentTimeMillis;
                if (QLog.isColorLevel()) {
                    QLog.d("GameMsgBoxOpenSyncView", 2, "open sync.");
                }
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxOpenSyncView.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameMsgBoxOpenSyncView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
                        ((IGameMsgBoxRuntimeService) appInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).setShouldShowNewUnAuthorizedSummary(false, GameMsgBoxOpenSyncView.this.getContext());
                        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
                        GameSwitchConfig findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(GameMsgBoxOpenSyncView.this.H);
                        if (findGameSwitchConfig != null) {
                            findGameSwitchConfig.mBlockSwitch = 0;
                            findGameSwitchConfig.mSyncSwitch = 1;
                        }
                        GameMsgBoxOpenSyncView.g(appInterface, findGameSwitchConfig);
                        ArrayList<GameSwitchConfig> arrayList = new ArrayList<>();
                        arrayList.add(findGameSwitchConfig);
                        iGameMsgManagerService.saveOrUpdateGameSwitchConfigs(arrayList);
                        ((IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class)).setGameSwitch(GameMsgBoxOpenSyncView.this.G, GameMsgBoxOpenSyncView.this.H, 1, 0, null);
                    }
                });
                com.tencent.mobileqq.activity.recent.gamemsgbox.data.a a16 = com.tencent.mobileqq.activity.recent.gamemsgbox.data.a.a();
                if (a16 != null) {
                    a16.c();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onFinishInflate();
        this.f185429d = (Button) findViewById(R.id.vi_);
        this.f185430e = (RoundCornerImageView) findViewById(R.id.f164566t35);
        this.f185434m = (ImageView) findViewById(R.id.vj8);
        this.D = (ImageView) findViewById(R.id.ttr);
        this.C = (ImageView) findViewById(R.id.f122237de);
        this.E = (TextView) findViewById(R.id.xri);
        this.F = (TextView) findViewById(R.id.vi8);
        this.f185431f = (LinearLayout) findViewById(R.id.f9138551);
        this.f185432h = (LinearLayout) findViewById(R.id.f9139552);
        this.f185433i = (RelativeLayout) findViewById(R.id.f9140553);
        this.f185429d.setOnClickListener(this);
        d();
    }

    public void setGameOpenSyncMsg(String str, int i3, gd1.a aVar, int i16, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), aVar, Integer.valueOf(i16), drawable);
            return;
        }
        if (aVar == null) {
            return;
        }
        String str2 = aVar.f401948l;
        this.G = i3;
        this.H = str;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            this.f185429d.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.jr_));
            this.f185430e.setImageDrawable(getResources().getDrawable(R.drawable.n5h));
            this.C.setImageDrawable(getResources().getDrawable(R.drawable.n5k));
            this.D.setImageDrawable(getResources().getDrawable(R.drawable.n5j));
            this.E.setTextColor(-1);
            this.f185429d.setTextColor(-1);
            this.F.setTextColor(getResources().getColor(R.color.ann));
            ((LinearLayout.LayoutParams) this.F.getLayoutParams()).topMargin = ViewUtils.dpToPx(12.0f);
            this.f185432h.setBackgroundResource(R.drawable.jrb);
        } else {
            ((LinearLayout.LayoutParams) this.F.getLayoutParams()).topMargin = ViewUtils.dpToPx(-6.0f);
            this.f185430e.setImageDrawable(getResources().getDrawable(R.drawable.n5g));
            this.C.setImageDrawable(getResources().getDrawable(R.drawable.n5l));
            this.D.setImageDrawable(getResources().getDrawable(R.drawable.n5i));
            this.f185431f.setBackgroundResource(R.drawable.jrc);
        }
        this.f185430e.setCorner(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(8.0f), 0, 0);
        if (TextUtils.isEmpty(str2)) {
            this.f185434m.setImageDrawable(getResources().getDrawable(R.drawable.f160830com));
        } else {
            f(this.f185434m, getContext(), str2);
            e();
        }
    }

    public GameMsgBoxOpenSyncView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GameMsgBoxOpenSyncView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.I = 0.0f;
            this.J = 0L;
        }
    }
}
