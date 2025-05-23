package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$LoginGuide;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$Reminder;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class z extends ReportDialog implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private ImageView H;
    private ImageView I;
    private LinearLayout J;
    private LinearLayout K;
    private Button L;
    private String M;
    private String N;
    private ImageView P;
    private String Q;
    private int R;
    private int S;

    public z(@NonNull Context context) {
        super(context, R.style.f173533fj);
        this.R = com.tencent.mobileqq.gamecenter.utils.c.d(37.0f, getContext().getResources());
        this.S = com.tencent.mobileqq.gamecenter.utils.c.d(40.0f, getContext().getResources());
        initWindow();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("qq_login_game_pkg_name", str + "@" + currentTimeMillis);
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("qq_login_game_app_id", str2);
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", str, null));
        context.startActivity(intent);
    }

    private void Q(GameDataAuthorizeSvr$Reminder gameDataAuthorizeSvr$Reminder) {
        if (QQTheme.isNowThemeIsNight()) {
            this.D.setTextColor(-1);
        } else {
            this.D.setTextColor(Color.parseColor("#070707"));
        }
        this.D.setText(gameDataAuthorizeSvr$Reminder.title.get());
        this.E.setText(gameDataAuthorizeSvr$Reminder.sub_titile.get());
        this.H.setImageDrawable(O(gameDataAuthorizeSvr$Reminder.icon.get(), this.R, this.S));
    }

    private void R(GameDataAuthorizeSvr$Reminder gameDataAuthorizeSvr$Reminder) {
        if (QQTheme.isNowThemeIsNight()) {
            this.F.setTextColor(-1);
        } else {
            this.F.setTextColor(Color.parseColor("#070707"));
        }
        this.F.setText(gameDataAuthorizeSvr$Reminder.title.get());
        this.G.setText(gameDataAuthorizeSvr$Reminder.sub_titile.get());
        this.I.setImageDrawable(O(gameDataAuthorizeSvr$Reminder.icon.get(), this.R, this.S));
    }

    public static void S(final Context context, final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                z.P(context, str, str2);
            }
        }, 32, null, true);
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eaa, (ViewGroup) null);
        setContentView(inflate);
        this.C = (TextView) inflate.findViewById(R.id.f108786e2);
        this.H = (ImageView) inflate.findViewById(R.id.y4r);
        this.I = (ImageView) inflate.findViewById(R.id.y4t);
        this.D = (TextView) inflate.findViewById(R.id.f108176ce);
        this.E = (TextView) inflate.findViewById(R.id.f108326ct);
        this.F = (TextView) inflate.findViewById(R.id.f1057866y);
        this.G = (TextView) inflate.findViewById(R.id.f110756jd);
        this.J = (LinearLayout) inflate.findViewById(R.id.vii);
        this.K = (LinearLayout) inflate.findViewById(R.id.vij);
        this.L = (Button) inflate.findViewById(R.id.teu);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dum);
        this.P = imageView;
        imageView.setOnClickListener(this);
        this.L.setOnClickListener(this);
        FontSettingManager.resetViewSize2Normal(getContext(), inflate);
    }

    public URLDrawable O(String str, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (i3 > 0 && i16 > 0) {
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
        }
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseAutoScaleParams = false;
        return URLDrawable.getDrawable(str, obtain);
    }

    public void W(String str) {
        this.M = str;
    }

    public void X(String str) {
        this.Q = str;
    }

    public void Y(GameDataAuthorizeSvr$LoginGuide gameDataAuthorizeSvr$LoginGuide) {
        this.C.setText(gameDataAuthorizeSvr$LoginGuide.title.get());
        List<GameDataAuthorizeSvr$Reminder> list = gameDataAuthorizeSvr$LoginGuide.reminders.get();
        if (list.size() == 0) {
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            return;
        }
        if (list.size() == 1) {
            this.J.setVisibility(0);
            Q(list.get(0));
        }
        if (list.size() >= 2) {
            this.J.setVisibility(0);
            this.K.setVisibility(0);
            Q(list.get(0));
            R(list.get(1));
        }
    }

    public void Z(String str) {
        this.N = str;
    }

    public void initWindow() {
        super.setContentView(LayoutInflater.from(getContext()).inflate(R.layout.eaa, (ViewGroup) null));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.L) {
            S(getContext(), this.N, this.M);
            str = "3";
        } else if (view == this.P) {
            dismiss();
            str = "2";
        } else {
            str = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", "2");
        hashMap.put("ext3", str);
        hashMap.put("ext4", "20");
        hashMap.put("ext15", String.valueOf(ah.K()));
        hashMap.put("ext10", ah.F());
        if (TextUtils.isEmpty(this.Q)) {
            str2 = "-1";
        } else {
            str2 = this.Q;
        }
        hashMap.put("ext29", str2);
        hashMap.put("adtag", "hulian_login");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.M, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9388", "938801", "914136", "", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        String str;
        super.show();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", "2");
        hashMap.put("ext4", "8");
        hashMap.put("ext10", ah.F());
        hashMap.put("ext15", String.valueOf(ah.K()));
        if (TextUtils.isEmpty(this.Q)) {
            str = "-1";
        } else {
            str = this.Q;
        }
        hashMap.put("ext29", str);
        hashMap.put("adtag", "hulian_login");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.M, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9388", "938801", "914135", "", hashMap);
    }
}
