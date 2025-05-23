package com.tencent.av.ui.fragment.invite.mav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class NTGaInviteBaseFragment extends GaInviteBaseFragment {
    public static String L;
    public int C = 0;
    public long D = 0;
    public long E = 0;
    public int F = 0;
    public VideoAppInterface G = null;
    public String H = null;
    long[] I = null;
    Timer J = null;
    a K = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class ToolBarTask extends TimerTask {
        ToolBarTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = NTGaInviteBaseFragment.this.K;
            if (aVar != null) {
                aVar.sendEmptyMessage(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                NTGaInviteBaseFragment.this.yh();
            }
        }
    }

    public NTGaInviteBaseFragment() {
        L = getClass().getSimpleName() + "_" + e.d();
    }

    public static String uh(Intent intent) {
        return intent.getStringExtra(ThemeConstants.THEME_DIY_BG_FROM_SUFFIX);
    }

    public static boolean xh(int i3) {
        if (i3 == 1 || i3 == 3000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public long getGroupId() {
        return this.D;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.w(L, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        rh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onCreate(bundle);
        this.G = (VideoAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        vh();
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public int qh() {
        return this.C;
    }

    protected void rh() {
        Timer timer = this.J;
        if (timer != null) {
            timer.cancel();
            this.J = null;
        }
        a aVar = this.K;
        if (aVar != null) {
            aVar.removeMessages(0);
            this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTimer(int i3) {
        Timer timer = this.J;
        if (timer != null) {
            timer.cancel();
        }
        this.J = new BaseTimer(true);
        this.J.schedule(new ToolBarTask(), i3);
    }

    boolean vh() {
        if (QLog.isColorLevel()) {
            QLog.d(L, 2, "initEnvParam");
        }
        if (this.G == null || r.h0() == null) {
            return false;
        }
        if (n.e().f().w() || n.e().f().x()) {
            if (QLog.isColorLevel()) {
                QLog.d(L, 2, "initEnvParam closeSession");
            }
            r.h0().q(n.e().f().f73091w, 2);
        }
        return true;
    }

    public boolean wh() {
        return xh(this.C);
    }

    protected abstract void yh();

    public static String sh(VideoAppInterface videoAppInterface, TextView textView, int i3, int i16, String str, long[] jArr) {
        return th(videoAppInterface, textView, videoAppInterface.G(i3, str, null), i16, str, jArr);
    }

    public static String th(VideoAppInterface videoAppInterface, TextView textView, String str, int i3, String str2, long[] jArr) {
        if (videoAppInterface == null || videoAppInterface.getApp() == null) {
            return null;
        }
        if (textView != null) {
            str = ba.getNameMaxMaseaured(videoAppInterface.getApp(), str, textView, videoAppInterface.getApp().getResources().getDimensionPixelSize(R.dimen.f159193wz));
        }
        String string = videoAppInterface.getApp().getString(R.string.dbc);
        int K = videoAppInterface.K(i3, str2);
        if (K == 0) {
            K = jArr != null ? jArr.length + 1 : 1;
        }
        return str + String.format(string, Integer.valueOf(K));
    }

    public void zh(Intent intent) {
        if (intent == null) {
            return;
        }
        e.m(L, intent.getExtras());
        this.C = intent.getIntExtra("uinType", 0);
        this.D = intent.getLongExtra("discussId", 0L);
        this.E = intent.getLongExtra("friendUin", 0L);
        this.F = intent.getIntExtra("relationType", this.F);
        this.I = intent.getLongArrayExtra("memberList");
        int avRelationType2UinType = ba.avRelationType2UinType(this.F);
        if (avRelationType2UinType != this.C) {
            QLog.w(L, 1, "processIntent, mUinType\u4e0emRelationType\u4e0d\u5339\u914d\uff0cmRelationType[" + this.F + "], uinTpye[" + avRelationType2UinType + "], mUinType[" + this.C + "]");
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public void ph(View view) {
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public void onBackPressed() {
    }
}
