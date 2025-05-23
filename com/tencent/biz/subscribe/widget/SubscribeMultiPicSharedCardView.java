package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import org.json.JSONObject;
import ve0.b;

/* loaded from: classes5.dex */
public class SubscribeMultiPicSharedCardView extends AbsSubscribeShareCardView {
    protected CornerImageView J;
    protected SquareImageView K;
    private TextView L;
    private AsyncRichTextView M;
    private ImageView N;
    protected FrameLayout P;

    public SubscribeMultiPicSharedCardView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public void e(b bVar, Bitmap bitmap, AbsSubscribeShareCardView.a aVar) {
        super.e(bVar, bitmap, aVar);
        CertifiedAccountMeta$StFeed a16 = bVar.a();
        if (a16 != null) {
            this.L.setText(this.f96361e.f());
            String str = this.f96361e.a().title.get();
            if (TextUtils.isEmpty(str)) {
                str = this.f96361e.a().content.get();
            }
            if (TextUtils.isEmpty(str)) {
                String str2 = this.f96361e.a().ext.get();
                try {
                    if (!TextUtils.isEmpty(str2) && JSONUtil.isJson(str2)) {
                        str = new JSONObject(str2).optString("title");
                    }
                } catch (Exception unused) {
                    str = "";
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.w8f);
            }
            this.M.setText(str);
            if (bitmap != null) {
                this.N.setImageBitmap(bitmap);
            }
            if (a16.images.size() > 0) {
                c(this.P, a16.images.get(0).width.get(), a16.images.get(0).height.get());
                this.J.getLayoutParams().width = this.J.getWidth();
                this.J.getLayoutParams().height = this.J.getHeight();
                this.f96364i.add(a16.images.get(0).url.get());
                this.f96365m.add(this.J);
                this.f96364i.add(a16.poster.icon.get());
                this.f96365m.add(this.K);
                f(this.f96364i, this.f96365m, aVar);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public int g() {
        return R.layout.c7f;
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    protected URLImageView i() {
        return this.J;
    }

    @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
    public void j(View view) {
        this.C = view.findViewById(R.id.lcj);
        CornerImageView cornerImageView = (CornerImageView) view.findViewById(R.id.lcn);
        this.J = cornerImageView;
        cornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.J.setBackgroundColor(-1);
        this.J.setRadius(ScreenUtil.dip2px(2.0f));
        this.K = (SquareImageView) view.findViewById(R.id.lcg);
        this.L = (TextView) view.findViewById(R.id.lcl);
        this.M = (AsyncRichTextView) view.findViewById(R.id.lcm);
        ImageView imageView = (ImageView) view.findViewById(R.id.ijz);
        this.N = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.P = (FrameLayout) findViewById(R.id.c2k);
    }

    public SubscribeMultiPicSharedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeMultiPicSharedCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
