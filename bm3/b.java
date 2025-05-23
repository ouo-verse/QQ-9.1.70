package bm3;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.R;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.now.app.music.view.MusicSettingMenuItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends cm3.a {
    public MusicSettingMenuItem C;
    public MusicSettingMenuItem D;
    public MusicSettingMenuItem E;
    public MusicSettingMenuItem F;
    public MusicSettingMenuItem G;
    private View.OnClickListener H = new a();

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f28654e;

    /* renamed from: f, reason: collision with root package name */
    private int f28655f;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.now.app.music.viewmodel.a f28656h;

    /* renamed from: i, reason: collision with root package name */
    MusicItem f28657i;

    /* renamed from: m, reason: collision with root package name */
    public MusicSettingMenuItem f28658m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.f82834hy) {
                b.this.dismiss();
                b.this.f28656h.f338074d.c();
            } else if (view.getId() == R.id.yvu) {
                b.this.f28656h.f338075e.c();
            } else if (view.getId() == R.id.f85664pk) {
                b.this.f28656h.f338078i.d();
            } else if (view.getId() == R.id.f25980ca) {
                b.this.f28656h.f338076f.d();
            } else if (view.getId() == R.id.f1202078x) {
                b.this.dismiss();
                b.this.f28656h.f338077h.e();
            } else if (view.getId() == R.id.uxy) {
                b.this.f28656h.b();
                b.this.dismiss();
                com.tencent.report.a.f364907a.d(view, true, null, "em_qqlive_music_end_click", new HashMap());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b() {
        setStyle(0, R.style.au9);
    }

    private void c(View view) {
        this.f28658m = (MusicSettingMenuItem) view.findViewById(R.id.f82834hy);
        this.C = (MusicSettingMenuItem) view.findViewById(R.id.yvu);
        this.D = (MusicSettingMenuItem) view.findViewById(R.id.f85664pk);
        this.E = (MusicSettingMenuItem) view.findViewById(R.id.f25980ca);
        this.F = (MusicSettingMenuItem) view.findViewById(R.id.f1202078x);
        this.G = (MusicSettingMenuItem) view.findViewById(R.id.uxy);
        this.f28658m.setOnClickListener(this.H);
        this.C.setOnClickListener(this.H);
        this.D.setOnClickListener(this.H);
        this.E.setOnClickListener(this.H);
        this.F.setOnClickListener(this.H);
        this.G.setOnClickListener(this.H);
    }

    private void e(com.tencent.now.app.music.controller.b bVar, int i3, MusicItem musicItem) {
        this.f28654e = bVar;
        this.f28655f = i3;
        this.f28657i = musicItem;
    }

    public static b f() {
        String str;
        LogUtil.i("MusicSettingDialogFragment", "showSettingDialog", new Object[0]);
        com.tencent.now.app.music.controller.b p16 = MusicPlayMgr.o().p();
        if (p16 != null && p16.o() != null) {
            FragmentManager fragmentManager = p16.o().getFragmentManager();
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag("music_setting_fragment");
            if (findFragmentByTag != null) {
                fragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            MusicItem g16 = p16.g();
            if (g16 == null) {
                LogUtil.e("MusicSettingDialogFragment", "currentMusicItem is null", new Object[0]);
                return null;
            }
            b bVar = new b();
            bVar.e(p16, 0, g16);
            bVar.show(fragmentManager, "music_setting_fragment");
            return bVar;
        }
        if (p16 == null) {
            str = "musicControl is null";
        } else {
            str = "musicControl.getMyActivity() is null";
        }
        LogUtil.e("MusicSettingDialogFragment", str, new Object[0]);
        return null;
    }

    public com.tencent.now.app.music.viewmodel.a b() {
        return this.f28656h;
    }

    public void d(com.tencent.now.app.music.controller.b bVar) {
        com.tencent.now.app.music.viewmodel.a aVar = this.f28656h;
        if (aVar != null) {
            aVar.f(bVar);
        }
    }

    public void g(MusicItem musicItem) {
        com.tencent.now.app.music.viewmodel.a aVar = this.f28656h;
        if (aVar != null) {
            aVar.h(musicItem);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f167908e62, viewGroup, false);
        c(inflate);
        com.tencent.now.app.music.viewmodel.a aVar = new com.tencent.now.app.music.viewmodel.a(this);
        this.f28656h = aVar;
        aVar.f(this.f28654e);
        this.f28656h.c(this.f28655f);
        MusicItem musicItem = this.f28657i;
        if (musicItem != null) {
            this.f28656h.h(musicItem);
        }
        com.tencent.report.a.f364907a.a(inflate, true, null, "em_qqlive_music_console_anchor", new HashMap());
        FragmentCollector.onFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        com.tencent.now.app.music.viewmodel.a aVar = this.f28656h;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // cm3.a, android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = AppUtils.UI.dip2px(232.0f);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.f2435312);
    }
}
