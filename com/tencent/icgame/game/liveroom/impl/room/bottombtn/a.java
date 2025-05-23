package com.tencent.icgame.game.liveroom.impl.room.bottombtn;

import android.app.Activity;
import android.content.Context;
import android.widget.PopupWindow;
import com.tencent.icgame.game.liveroom.impl.room.bottombtn.ButtonBean;
import com.tencent.icgame.game.liveroom.impl.room.bottombtn.MoreBtnPanel;
import com.tencent.icgame.game.liveroom.impl.room.util.n;
import com.tencent.icgame.game.liveroom.impl.room.util.o;
import com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import fu0.c;
import java.util.ArrayList;
import java.util.List;
import qw0.k;
import yv0.f;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private PopupWindow f115172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.bottombtn.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C5830a implements PopupWindow.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MoreBtnPanel f115173d;

        C5830a(MoreBtnPanel moreBtnPanel) {
            this.f115173d = moreBtnPanel;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            this.f115173d.e();
            com.tencent.icgame.game.liveroom.impl.room.followguide.a.c(a.this.f115172a.hashCode(), false);
        }
    }

    private long e(h22.a aVar) {
        if (aVar.c() && aVar.getAnchorRoomInfo() != null) {
            return aVar.getAnchorRoomInfo().uid;
        }
        if (aVar.getCurLiveInfo() != null && aVar.getCurLiveInfo().anchorInfo != null) {
            return aVar.getCurLiveInfo().anchorInfo.uid;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Context context, ButtonBean buttonBean) {
        if (!buttonBean.getName().contains(context.getString(R.string.zfv)) && this.f115172a.isShowing()) {
            this.f115172a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(f fVar, MoreBtnPanel moreBtnPanel) {
        moreBtnPanel.setOperateChildView(fVar.c(), fVar.e(), new ArrayList(fVar.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(List list, Context context, MoreBtnPanel moreBtnPanel, f fVar, boolean z16) {
        if (z16) {
            list.add(new ButtonBean(2, R.drawable.nlz, context.getString(R.string.zfs)));
            moreBtnPanel.setOperateChildView(fVar.c(), fVar.e(), list);
        }
    }

    public void f() {
        PopupWindow popupWindow = this.f115172a;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f115172a.dismiss();
        }
    }

    public void j(Activity activity, final Context context, h22.a aVar, final f fVar, AudienceOperationBarView.b bVar) {
        final MoreBtnPanel moreBtnPanel = new MoreBtnPanel(context);
        VideoReport.setPageId(moreBtnPanel, "pg_icgame_audience");
        final ArrayList arrayList = new ArrayList(fVar.d());
        moreBtnPanel.setOperateChildView(fVar.c(), fVar.e(), arrayList);
        moreBtnPanel.setAudienceOperationListener(bVar);
        moreBtnPanel.setOnPanelClickListener(new MoreBtnPanel.c() { // from class: yv0.b
            @Override // com.tencent.icgame.game.liveroom.impl.room.bottombtn.MoreBtnPanel.c
            public final void a(ButtonBean buttonBean) {
                com.tencent.icgame.game.liveroom.impl.room.bottombtn.a.this.g(context, buttonBean);
            }
        });
        moreBtnPanel.setPanelRebuildListener(new MoreBtnPanel.d() { // from class: yv0.c
            @Override // com.tencent.icgame.game.liveroom.impl.room.bottombtn.MoreBtnPanel.d
            public final void a() {
                com.tencent.icgame.game.liveroom.impl.room.bottombtn.a.h(f.this, moreBtnPanel);
            }
        });
        o oVar = new o();
        oVar.y(true);
        oVar.q(R.style.f246468z);
        oVar.v(-1);
        oVar.u(-2);
        oVar.s(-1);
        oVar.r(-2);
        PopupWindow e16 = n.e(activity, moreBtnPanel, oVar);
        this.f115172a = e16;
        com.tencent.icgame.game.liveroom.impl.room.followguide.a.c(e16.hashCode(), true);
        this.f115172a.setOnDismissListener(new C5830a(moreBtnPanel));
        k.q(e(aVar), ((c) qx0.a.b(c.class)).K().longValue(), aVar.getRoomId(), new k.c() { // from class: yv0.d
            @Override // qw0.k.c
            public final void a(boolean z16) {
                com.tencent.icgame.game.liveroom.impl.room.bottombtn.a.i(arrayList, context, moreBtnPanel, fVar, z16);
            }
        });
    }
}
