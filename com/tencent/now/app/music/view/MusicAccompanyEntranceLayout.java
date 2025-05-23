package com.tencent.now.app.music.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.c;
import com.tencent.now.app.music.controller.MusicControlView;
import com.tencent.now.app.music.controller.b;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.report.a;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicAccompanyEntranceLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f338056d;

    /* renamed from: e, reason: collision with root package name */
    private MusicSettingView f338057e;

    public MusicAccompanyEntranceLayout(@NonNull Context context) {
        super(context);
        c();
    }

    private void c() {
        View inflate = View.inflate(getContext(), R.layout.dpu, this);
        this.f338056d = (ImageView) inflate.findViewById(R.id.f59482su);
        MusicSettingView musicSettingView = (MusicSettingView) inflate.findViewById(R.id.zke);
        this.f338057e = musicSettingView;
        musicSettingView.setClickable(false);
        this.f338057e.setFocusable(false);
        this.f338057e.a(0);
    }

    private void d(String str, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_music_result", str);
        a.f364907a.d(view, true, null, "em_qqlive_music_click", hashMap);
    }

    private void e(View view) {
        a.f364907a.a(view, true, null, "em_qqlive_music_anchor", new HashMap());
    }

    public void a(View view) {
        if (MusicPlayMgr.o().n() != null && this.f338057e.f338064e.getVisibility() != 0) {
            this.f338057e.setMusicControl(MusicPlayMgr.o().p());
            this.f338057e.b().c();
            d("2", view);
            return;
        }
        c.b(getContext());
        d("1", view);
        e(view);
    }

    public void b() {
        if (MusicPlayMgr.o().n() != null) {
            this.f338057e.setVisibility(0);
            this.f338056d.setVisibility(8);
        } else {
            this.f338057e.setVisibility(8);
            this.f338056d.setVisibility(0);
        }
        b p16 = MusicPlayMgr.o().p();
        this.f338057e.setMusicControl(p16);
        if (p16 instanceof MusicControlView) {
            ((MusicControlView) p16).setMusicSettingView(this.f338057e);
        }
    }

    public MusicAccompanyEntranceLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public MusicAccompanyEntranceLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
