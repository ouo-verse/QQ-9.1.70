package com.qzone.reborn.layer.part;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;

/* compiled from: P */
/* loaded from: classes37.dex */
public class v extends ap {
    private View G;
    private rk.h H;
    private TextView I;
    private ImageView J;
    private TextView K;
    private ImageView L;
    private TextView M;

    public v() {
        this.H = new rk.h();
    }

    private void N9() {
        R9();
        P9(M9());
    }

    private void P9(int i3) {
        TextView textView = this.I;
        if (textView == null) {
            return;
        }
        if (i3 > 0) {
            String p16 = tk.h.p(i3);
            this.I.setText(p16);
            this.I.setContentDescription(com.qzone.util.l.a(R.string.s3x) + p16);
            return;
        }
        textView.setText(com.qzone.util.l.a(R.string.s3x));
        this.I.setContentDescription(com.qzone.util.l.a(R.string.s3x));
    }

    private void Q9() {
        rk.h hVar = this.H;
        if (hVar == null) {
            return;
        }
        boolean isSupportComment = hVar.getIsSupportComment();
        TextView textView = this.I;
        if (textView == null || this.J == null || this.M == null) {
            return;
        }
        textView.setVisibility(isSupportComment ? 0 : 4);
        this.J.setVisibility(isSupportComment ? 0 : 4);
        this.M.setVisibility(isSupportComment ? 0 : 4);
    }

    private void S9() {
        rk.h hVar = this.H;
        if (hVar == null) {
            return;
        }
        boolean isSupportPraise = hVar.getIsSupportPraise();
        if (this.I == null || this.J == null) {
            return;
        }
        this.K.setVisibility(isSupportPraise ? 0 : 4);
        this.L.setVisibility(isSupportPraise ? 0 : 4);
    }

    protected int M9() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f57988i;
        if (photoParam != null && (photoInfo = this.f57984d) != null) {
            if (photoParam.appid == 4) {
                return photoInfo.commentCount;
            }
            return photoParam.commentNum;
        }
        RFWLog.e(getLogTag(), RFWLog.USR, "photo param is null");
        return 0;
    }

    protected void O9(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.cfj, (ViewGroup) null);
        this.G = inflate;
        this.J = (ImageView) inflate.findViewById(R.id.n0b);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.J, -1);
        this.I = (TextView) this.G.findViewById(R.id.n0d);
        this.K = (TextView) this.G.findViewById(R.id.n0m);
        this.L = (ImageView) this.G.findViewById(R.id.n0l);
        this.M = (TextView) this.G.findViewById(R.id.n0c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.qzone.util.ar.d(200.0f));
        layoutParams.gravity = 80;
        this.G.setClickable(false);
        this.G.setEnabled(false);
        ((ViewGroup) view).addView(this.G, layoutParams);
    }

    protected void R9() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || (photoInfo = this.f57984d) == null) {
            return;
        }
        if (photoParam.appid == 4) {
            photoInfo.commentCount++;
        } else {
            photoParam.commentNum++;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals("FEEDX_LAYER_COMMENT_SUCCESS", str)) {
            N9();
        } else if (TextUtils.equals("FEEDX_LAYER_UPDATE_COMMENT_NUM", str) && (obj instanceof Integer)) {
            P9(((Integer) obj).intValue());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        PhotoInfo photoInfo;
        super.onActivityResult(i3, i16, intent);
        if (i3 != 20230 || intent == null || (stringExtra = intent.getStringExtra("lloc")) == null || (photoInfo = this.f57984d) == null || !stringExtra.equals(photoInfo.lloc)) {
            return;
        }
        int intExtra = intent.getIntExtra(PictureConst.PHOTO_COMMENT_NUM, 0);
        this.f57984d.commentCount = intExtra;
        P9(intExtra);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        O9(view);
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        if (this.f57984d == null) {
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(0);
        P9(M9());
        S9();
        Q9();
    }

    public v(rk.h hVar) {
        this.H = hVar;
    }
}
