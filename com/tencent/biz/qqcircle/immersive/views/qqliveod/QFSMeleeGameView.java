package com.tencent.biz.qqcircle.immersive.views.qqliveod;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.immersive.feed.live.od.a;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMeleeGameView extends ConstraintLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    private final QFSItemSeatView[] f91034d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f91035e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f91036f;

    public QFSMeleeGameView(@NonNull Context context) {
        super(context);
        this.f91034d = new QFSItemSeatView[9];
        this.f91035e = false;
        this.f91036f = false;
        initView();
    }

    private boolean A0() {
        String str;
        if (this.f91035e) {
            str = "checkStatus is call when MeleeGameView released!";
        } else {
            str = "";
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (!isEmpty) {
            if (!HostAppSettingUtil.isDebugVersion()) {
                QLog.w("MeleeGameView", 1, str);
            } else {
                throw new IllegalStateException(str);
            }
        }
        return isEmpty;
    }

    private void B0(int i3, a.C0883a c0883a) {
        this.f91034d[i3].z0(c0883a.f86334c);
    }

    private void C0(int i3, a.C0883a c0883a) {
        this.f91034d[i3].setName(c0883a.f86335d);
    }

    private void D0(int i3) {
        this.f91034d[i3].A0();
    }

    private void E0() {
        for (int i3 = 0; i3 <= 8; i3++) {
            this.f91034d[i3].C0();
        }
    }

    private void initView() {
        View.inflate(getContext(), R.layout.gep, this);
        QFSItemSeatView qFSItemSeatView = (QFSItemSeatView) findViewById(R.id.snn);
        QFSItemSeatView qFSItemSeatView2 = (QFSItemSeatView) findViewById(R.id.f81344dx);
        QFSItemSeatView qFSItemSeatView3 = (QFSItemSeatView) findViewById(R.id.f81354dy);
        QFSItemSeatView qFSItemSeatView4 = (QFSItemSeatView) findViewById(R.id.f81364dz);
        QFSItemSeatView qFSItemSeatView5 = (QFSItemSeatView) findViewById(R.id.f81374e0);
        QFSItemSeatView qFSItemSeatView6 = (QFSItemSeatView) findViewById(R.id.f81384e1);
        QFSItemSeatView qFSItemSeatView7 = (QFSItemSeatView) findViewById(R.id.f81394e2);
        QFSItemSeatView qFSItemSeatView8 = (QFSItemSeatView) findViewById(R.id.f81404e3);
        QFSItemSeatView qFSItemSeatView9 = (QFSItemSeatView) findViewById(R.id.f81414e4);
        QFSItemSeatView[] qFSItemSeatViewArr = this.f91034d;
        qFSItemSeatViewArr[0] = qFSItemSeatView;
        qFSItemSeatViewArr[1] = qFSItemSeatView2;
        qFSItemSeatViewArr[2] = qFSItemSeatView3;
        qFSItemSeatViewArr[3] = qFSItemSeatView4;
        qFSItemSeatViewArr[4] = qFSItemSeatView5;
        qFSItemSeatViewArr[5] = qFSItemSeatView6;
        qFSItemSeatViewArr[6] = qFSItemSeatView7;
        qFSItemSeatViewArr[7] = qFSItemSeatView8;
        qFSItemSeatViewArr[8] = qFSItemSeatView9;
        for (int i3 = 0; i3 <= 8; i3++) {
            QFSItemSeatView qFSItemSeatView10 = this.f91034d[i3];
            if (i3 == 0) {
                qFSItemSeatView10.setDefaultHeadBg(R.drawable.ncl);
            }
            qFSItemSeatView10.A0();
        }
    }

    private boolean z0(int i3) {
        if (i3 >= 0 && i3 <= 8) {
            return true;
        }
        String str = "argument is error,seat:" + i3 + "!";
        if (!HostAppSettingUtil.isDebugVersion()) {
            QLog.w("MeleeGameView", 1, str);
            return false;
        }
        throw new IllegalArgumentException(str);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public void L(int i3, boolean z16) {
        if (!A0() || !z0(i3) || !this.f91036f) {
            return;
        }
        if (z16) {
            this.f91034d[i3].B0();
        } else {
            this.f91034d[i3].C0();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public void hide() {
        setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public boolean isRelease() {
        return this.f91035e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f91036f = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f91036f = false;
        E0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public void pause() {
        E0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public void release() {
        this.f91035e = true;
        E0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public void setSeatInfo(int i3, @Nullable a.C0883a c0883a) {
        if (!A0() || !z0(i3)) {
            return;
        }
        if (c0883a == null) {
            D0(i3);
        } else {
            B0(i3, c0883a);
            C0(i3, c0883a);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.a
    public void show() {
        setVisibility(0);
    }

    public QFSMeleeGameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91034d = new QFSItemSeatView[9];
        this.f91035e = false;
        this.f91036f = false;
        initView();
    }

    public QFSMeleeGameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91034d = new QFSItemSeatView[9];
        this.f91035e = false;
        this.f91036f = false;
        initView();
    }
}
