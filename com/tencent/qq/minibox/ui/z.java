package com.tencent.qq.minibox.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IGamePermissionManagerService;
import com.tencent.qq.minibox.permission.PermissionItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.net.URLDecoder;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class z extends ReportDialog implements View.OnClickListener {
    private Activity C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private String K;
    private String L;
    private IGamePermissionManagerService M;
    private bs3.a N;
    private Button P;

    public z(Activity activity) {
        super(activity, R.style.ayg);
        this.C = activity;
        initView();
    }

    private void P(boolean z16) {
        int i3;
        bs3.a aVar = this.N;
        if (aVar != null) {
            aVar.onConfirmResult(z16);
        }
        IGamePermissionManagerService iGamePermissionManagerService = this.M;
        if (iGamePermissionManagerService == null) {
            return;
        }
        if (z16) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        iGamePermissionManagerService.updateGamePermission(this.L, this.K, i3);
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.f168283fi4, (ViewGroup) null);
        super.setContentView(inflate);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
        this.D = (ImageView) inflate.findViewById(R.id.ewf);
        this.E = (TextView) inflate.findViewById(R.id.ewh);
        this.F = (TextView) inflate.findViewById(R.id.a19);
        this.G = (TextView) inflate.findViewById(R.id.f1061567y);
        this.I = (TextView) inflate.findViewById(R.id.f110606iz);
        this.J = (TextView) inflate.findViewById(R.id.f1059767g);
        this.P = (Button) inflate.findViewById(R.id.tgs);
        this.H = (TextView) inflate.findViewById(R.id.f111246kp);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.P.setOnClickListener(this);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (appInterface != null) {
            this.M = (IGamePermissionManagerService) appInterface.getRuntimeService(IGamePermissionManagerService.class, "all");
        }
    }

    public void N(String str, String str2, String str3, Drawable drawable, bs3.a aVar) {
        this.N = aVar;
        this.L = str2;
        this.K = str;
        this.E.setText(str3);
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        }
        IGamePermissionManagerService iGamePermissionManagerService = this.M;
        if (iGamePermissionManagerService == null) {
            aVar.onConfirmResult(true);
            QLog.w("PermissionConfirmDialog", 1, "Fail to show dialog, permissionMgr is null.");
            return;
        }
        PermissionItem permissionItem = iGamePermissionManagerService.getPermissionItem(str);
        if (permissionItem == null) {
            aVar.onConfirmResult(true);
            QLog.w("PermissionConfirmDialog", 1, "Fail to show dialog, permissionItem is null. permission=" + str);
            return;
        }
        this.F.setText(permissionItem.mReqTitle);
        this.G.setText(permissionItem.mReqDetail);
        show();
    }

    public void O(String str, String str2, String str3, String str4, bs3.a aVar) {
        this.N = aVar;
        this.E.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            this.D.setImageDrawable(URLDrawable.getDrawable(URLDecoder.decode(str2), (URLDrawable.URLDrawableOptions) null));
        }
        this.H.setText(getContext().getString(R.string.f1656028z));
        this.F.setText(str3);
        this.G.setText(str4);
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.J) {
            P(true);
        } else if (view == this.I) {
            P(false);
        } else if (view == this.P) {
            this.M.startPermissionSettingFragment(this.C, new Intent());
        }
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }
}
