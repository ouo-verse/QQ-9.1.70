package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.c;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import ve0.b;

/* loaded from: classes5.dex */
public class SubScribePersonalSharedCardView extends AbsSubscribeShareCardView {
    private SquareImageView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private RelativeLayout P;
    private ImageView Q;

    public SubScribePersonalSharedCardView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public void e(b bVar, Bitmap bitmap, AbsSubscribeShareCardView.a aVar) {
        PBStringField pBStringField;
        super.e(bVar, bitmap, aVar);
        if (bVar != null && bVar.a() != null && bVar.a().poster != null) {
            CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = bVar.a().poster;
            if (TextUtils.isEmpty(certifiedAccountMeta$StUser.iconInfo.iconUrl.get())) {
                pBStringField = certifiedAccountMeta$StUser.icon;
            } else {
                pBStringField = certifiedAccountMeta$StUser.iconInfo.iconUrl;
            }
            String str = pBStringField.get();
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<ImageView> arrayList2 = new ArrayList<>();
            arrayList.add(str);
            arrayList2.add(this.J);
            f(arrayList, arrayList2, aVar);
            this.K.setText(certifiedAccountMeta$StUser.nick.get());
            String str2 = certifiedAccountMeta$StUser.desc.get();
            if (TextUtils.isEmpty(str2) || str2.equals(HardCodeUtil.qqStr(R.string.w8b)) || TextUtils.isEmpty(str2.trim())) {
                str2 = HardCodeUtil.qqStr(R.string.w8a);
            }
            this.L.setText(str2);
            CertifiedAccountRead$StGetMainPageRsp b16 = c.b();
            if (b16 != null) {
                this.N.setText(SubscribeUtils.b(b16.fansCount.get()));
                this.M.setText(SubscribeUtils.b(b16.feedCount.get()));
                measure(AbsSubscribeShareCardView.G, AbsSubscribeShareCardView.I);
                layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            this.Q.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public int g() {
        return R.layout.aop;
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    protected URLImageView i() {
        return this.J;
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public void j(View view) {
        this.C = view.findViewById(R.id.iog);
        this.J = (SquareImageView) view.findViewById(R.id.imw);
        this.K = (TextView) view.findViewById(R.id.ipb);
        this.L = (TextView) view.findViewById(R.id.in7);
        this.M = (TextView) view.findViewById(R.id.ipd);
        this.N = (TextView) view.findViewById(R.id.iod);
        this.P = (RelativeLayout) view.findViewById(R.id.ika);
        this.Q = (ImageView) view.findViewById(R.id.ikg);
    }

    public SubScribePersonalSharedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubScribePersonalSharedCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
