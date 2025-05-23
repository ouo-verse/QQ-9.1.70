package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.comment.CommentListBaseController;
import com.qzone.detail.ui.comment.CommentListLayout;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.event.QZoneFeedxLayerCommentEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class x extends ap implements View.OnClickListener {
    protected ViewGroup G;
    protected View H;
    protected CommentListBaseController I;
    private View J;
    private View K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements CommentListBaseController.o {
        c() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.o
        public void a() {
            x.this.N9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            x.this.I.v();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    protected void M9(View view) {
        if (getPartRootView() == null || view == null) {
            return;
        }
        this.G = new FrameLayout(getContext());
        ((ViewGroup) getPartRootView()).addView(this.G, new FrameLayout.LayoutParams(-1, -1));
        this.G.setOnClickListener(new d());
        this.G.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.qzone.util.ar.k() / 2);
        layoutParams.gravity = 80;
        view.setId(R.id.b4p);
        this.G.addView(view, layoutParams);
    }

    protected void N9() {
        CommentListBaseController commentListBaseController = this.I;
        if (commentListBaseController == null) {
            return;
        }
        broadcastMessage("FEEDX_LAYER_UPDATE_COMMENT_NUM", Integer.valueOf(commentListBaseController.L()));
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null) {
            photoInfo.commentCount = this.I.L();
        }
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || photoParam.appid == 4) {
            return;
        }
        photoParam.commentNum = this.I.L();
    }

    protected PhotoParam O9() {
        return this.f57988i;
    }

    protected void P9() {
        if (this.I == null) {
            CommentListBaseController s16 = CommentListBaseController.s(getActivity(), 2);
            this.I = s16;
            s16.B0(new a());
            CommentListLayout M = this.I.M();
            this.H = M;
            M.setBackgroundColor(Color.parseColor("#262626"));
            M9(this.H);
            this.I.v();
            this.I.D0(new b());
            this.I.E0(new c());
        }
    }

    protected void Q9() {
        if (com.qzone.reborn.feedx.util.l.b("QZoneFeedxLayerCommentPanelPart", 1000L)) {
            return;
        }
        if (getActivity().getResources().getConfiguration().orientation == 2) {
            QLog.i(getTAG(), 1, "--current orientation is landscape,try rotate to portrait");
            getActivity().setRequestedOrientation(1);
        }
        R9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R9() {
        PhotoParam O9 = O9();
        Bundle bundle = new Bundle();
        if (this.f57984d != null && O9 != null) {
            if (B9() != null) {
                B9().C3();
            }
            PhotoInfo photoInfo = this.f57984d;
            Map map = O9.busi_param;
            if (map == null) {
                map = new HashMap();
            }
            if (!TextUtils.isEmpty(photoInfo.lloc)) {
                map.put(2, photoInfo.lloc);
                map.put(1, photoInfo.lloc);
            }
            map.put(7, "1");
            if (O9.appid == 4) {
                bundle.putLong("uin", O9.ownerUin);
            } else {
                bundle.putLong("uin", O9.feedUin);
            }
            bundle.putString(PictureConst.CELL_ID, O9.cell_id);
            bundle.putInt("appid", O9.appid);
            bundle.putString(QZoneResult.UGC_KEY, O9.ugcKey);
            bundle.putParcelable("business_params", new MapParcelable(map));
            this.I.C0(bundle);
            if (this.I.T() != null && this.I.T().g0() != null) {
                this.I.T().g0().setLoadingBackgroundColor(-16777216);
            }
            this.G.setVisibility(0);
            this.I.G0();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 4, R.string.w_2, 0).show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        CommentListBaseController commentListBaseController = this.I;
        if (commentListBaseController != null) {
            commentListBaseController.n0(i3, i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.n0b || view.getId() == R.id.n0d) {
            Q9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.J = view.findViewById(R.id.n0b);
        this.K = view.findViewById(R.id.n0d);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        AccessibilityUtil.n(this.K, false);
        this.J.setContentDescription(com.qzone.util.l.a(R.string.sfo));
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        CommentListBaseController commentListBaseController = this.I;
        if (commentListBaseController != null) {
            commentListBaseController.p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements CommentListBaseController.n {
        a() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void c() {
            if (x.this.f57984d != null) {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxLayerCommentEvent(x.this.f57984d.lloc), true);
            }
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void a() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements CommentListLayout.c {
        b() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListLayout.c
        public void a() {
            x.this.G.setVisibility(8);
        }

        @Override // com.qzone.detail.ui.comment.CommentListLayout.c
        public void b() {
        }
    }
}
