package com.tencent.timi.game.teamlist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.utils.l;
import qh2.f;
import um4.k;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListGiftImageView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private RCImageView f379860d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f379861e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f379862f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f379863h;

    public TeamListGiftImageView(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hwz, this);
        this.f379860d = (RCImageView) inflate.findViewById(R.id.vp9);
        this.f379861e = (ImageView) inflate.findViewById(R.id.vpc);
        this.f379862f = (TextView) inflate.findViewById(R.id.vpa);
        this.f379863h = (TextView) inflate.findViewById(R.id.vpj);
    }

    public void setGiftDescTextColor(int i3) {
        this.f379862f.setTextColor(i3);
        this.f379863h.setTextColor(i3);
    }

    public void setGiftInfo(int i3, int i16) {
        this.f379863h.setText(HippyTKDListViewAdapter.X + i3);
        k kVar = k.f439239a;
        kVar.c();
        nh2.c d16 = kVar.d();
        if (d16 == null) {
            l.e("TeamListGiftImageView", "giftSDK is null!");
        } else {
            d16.b().e(i16, new f() { // from class: com.tencent.timi.game.teamlist.view.TeamListGiftImageView.1
                @Override // qh2.f
                public void c(int i17, QQGiftPanelResource qQGiftPanelResource) {
                    final URLDrawable a16 = um4.a.f439223a.a(qQGiftPanelResource.f265002b, URLDrawable.URLDrawableOptions.obtain());
                    TeamListGiftImageView.this.post(new Runnable() { // from class: com.tencent.timi.game.teamlist.view.TeamListGiftImageView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TeamListGiftImageView.this.f379861e.setImageDrawable(a16);
                        }
                    });
                }

                @Override // qh2.g
                public void onLoadFail(int i17, int i18, int i19, String str) {
                }
            });
        }
    }

    public TeamListGiftImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public TeamListGiftImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
