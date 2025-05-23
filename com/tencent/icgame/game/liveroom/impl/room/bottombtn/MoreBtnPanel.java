package com.tencent.icgame.game.liveroom.impl.room.bottombtn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.bottombtn.b;
import com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.ManageHistoryFragment;
import com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView;
import com.tencent.icgame.liveroom.impl.room.widget.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import fu0.e;
import java.util.List;

/* loaded from: classes7.dex */
public class MoreBtnPanel extends LinearLayout {
    private d C;
    private IAegisLogApi D;
    private b.InterfaceC5831b E;
    private b.InterfaceC5831b F;

    /* renamed from: d, reason: collision with root package name */
    private AudienceOperationBarView.b f115161d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f115162e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f115163f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.icgame.game.liveroom.impl.room.bottombtn.b f115164h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.icgame.game.liveroom.impl.room.bottombtn.b f115165i;

    /* renamed from: m, reason: collision with root package name */
    private c f115166m;

    /* loaded from: classes7.dex */
    class a implements b.InterfaceC5831b {
        a() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.bottombtn.b.InterfaceC5831b
        public void a(View view, ButtonBean buttonBean) {
            if (MoreBtnPanel.this.f115166m != null) {
                MoreBtnPanel.this.f115166m.a(buttonBean);
            }
            String str = buttonBean.getBottomItem().f396938c;
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", x.h(MoreBtnPanel.this.getContext(), (int) (x.f(MoreBtnPanel.this.getContext()).f185861b * buttonBean.getBottomItem().f396939d)));
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(MoreBtnPanel.this.getContext(), str, bundle);
        }
    }

    /* loaded from: classes7.dex */
    class b implements b.InterfaceC5831b {
        b() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.bottombtn.b.InterfaceC5831b
        public void a(View view, ButtonBean buttonBean) {
            if (MoreBtnPanel.this.f115166m != null) {
                MoreBtnPanel.this.f115166m.a(buttonBean);
            }
            if (MoreBtnPanel.this.f115161d == null) {
                return;
            }
            if (MoreBtnPanel.this.getContext().getString(R.string.zfu).equals(buttonBean.getName())) {
                MoreBtnPanel.this.f115161d.b();
                return;
            }
            if (MoreBtnPanel.this.getContext().getString(R.string.zfp).equals(buttonBean.getName())) {
                MoreBtnPanel.this.f115161d.j();
                return;
            }
            if (MoreBtnPanel.this.getContext().getString(R.string.zfo).equals(buttonBean.getName())) {
                MoreBtnPanel.this.f115161d.a();
                return;
            }
            if (MoreBtnPanel.this.getContext().getString(R.string.zfs).equals(buttonBean.getName())) {
                BaseRoomInfo q16 = ((fu0.c) qx0.a.b(fu0.c.class)).q(0L);
                if (q16 == null) {
                    MoreBtnPanel.this.D.e("ICGameMoreBtnPanel", "roomInfo=null");
                    return;
                }
                e n3 = ((fu0.c) qx0.a.b(fu0.c.class)).n(q16.getRoomId());
                if (n3 == null) {
                    MoreBtnPanel.this.D.e("ICGameMoreBtnPanel", "anchorInfo=null");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("anchorID", n3.f400636a);
                intent.putExtra("roomID", q16.getRoomId());
                intent.putExtra("public_fragment_window_feature", 0);
                QPublicFragmentActivity.b.b(view.getContext(), intent, QPublicFragmentActivityForTool.class, ManageHistoryFragment.class);
                return;
            }
            if (MoreBtnPanel.this.getContext().getString(R.string.zfn).equals(buttonBean.getName())) {
                MoreBtnPanel.this.f115161d.i();
                return;
            }
            if (MoreBtnPanel.this.getContext().getString(R.string.zfr).equals(buttonBean.getName())) {
                m.INSTANCE.b(Long.valueOf(xw0.b.f448881a.h()));
            } else if (buttonBean.getName().contains(MoreBtnPanel.this.getContext().getString(R.string.zfv))) {
                ew0.d.b(!ew0.d.a());
                if (MoreBtnPanel.this.C != null) {
                    MoreBtnPanel.this.C.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(ButtonBean buttonBean);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    public MoreBtnPanel(Context context) {
        super(context);
        this.D = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.E = new a();
        this.F = new b();
        f(context);
    }

    private void f(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fbf, this);
        this.f115162e = (RecyclerView) inflate.findViewById(R.id.zzj);
        this.f115163f = (RecyclerView) inflate.findViewById(R.id.ytd);
        this.f115164h = new com.tencent.icgame.game.liveroom.impl.room.bottombtn.b(getContext());
        this.f115165i = new com.tencent.icgame.game.liveroom.impl.room.bottombtn.b(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 4);
        this.f115162e.setLayoutManager(gridLayoutManager);
        this.f115163f.setLayoutManager(gridLayoutManager2);
        g(inflate);
    }

    private void g(View view) {
        ((ru0.a) qx0.a.b(ru0.a.class)).b(view, "pg_icgame_audience", xw0.b.f448881a.e());
    }

    public void e() {
        this.f115164h.q0();
        this.f115165i.q0();
    }

    public void setAudienceOperationListener(AudienceOperationBarView.b bVar) {
        this.f115161d = bVar;
    }

    public void setOnPanelClickListener(c cVar) {
        this.f115166m = cVar;
    }

    public void setOperateChildView(ep4.d dVar, List<ButtonBean> list, List<ButtonBean> list2) {
        this.f115164h.t0(dVar, list);
        this.f115164h.u0(this.E);
        this.f115162e.setAdapter(this.f115164h);
        this.f115165i.t0(dVar, list2);
        this.f115165i.u0(this.F);
        this.f115163f.setAdapter(this.f115165i);
        this.f115164h.notifyDataSetChanged();
        this.f115165i.notifyDataSetChanged();
    }

    public void setPanelRebuildListener(d dVar) {
        this.C = dVar;
    }
}
