package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StImage;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;

/* loaded from: classes5.dex */
public class RelativeMultiPicHeadItemView extends BaseWidgetView {
    private AsyncRichTextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private final int J;
    private View K;
    private SubscribeBannerView L;
    private int M;

    /* loaded from: classes5.dex */
    class a extends SubscribeBannerView.b {
        a() {
        }

        private String j(Object obj) {
            if (obj instanceof CertifiedAccountMeta$StImage) {
                return ((CertifiedAccountMeta$StImage) obj).url.get();
            }
            return "";
        }

        @Override // com.tencent.biz.subscribe.widget.SubscribeBannerView.b
        protected View d(View view, Object obj) {
            String j3 = j(obj);
            if ((obj instanceof CertifiedAccountMeta$StImage) && RelativeMultiPicHeadItemView.this.M != 0) {
                CertifiedAccountMeta$StImage certifiedAccountMeta$StImage = (CertifiedAccountMeta$StImage) obj;
                if (certifiedAccountMeta$StImage.width.get() != 0 && certifiedAccountMeta$StImage.height.get() != 0) {
                    float f16 = certifiedAccountMeta$StImage.height.get() / certifiedAccountMeta$StImage.width.get();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    int i3 = (int) (RelativeMultiPicHeadItemView.this.M / f16);
                    if (i3 > RelativeMultiPicHeadItemView.this.J) {
                        i3 = RelativeMultiPicHeadItemView.this.J;
                    }
                    layoutParams.width = i3;
                    layoutParams.height = RelativeMultiPicHeadItemView.this.M;
                }
            }
            if (j3 != null) {
                try {
                    String o16 = af0.b.o(j3);
                    if (!TextUtils.isEmpty(o16)) {
                        File file = new File(o16);
                        if (file.exists()) {
                            ((URLImageView) view).setImageURI(Uri.fromFile(file));
                            return view;
                        }
                    }
                    com.tencent.biz.subscribe.a.e(j3, (URLImageView) view);
                } catch (Error e16) {
                    QLog.d("RelativeMultiPicHeadItemView", 1, "bindItemView set local image path error!error:" + e16.getMessage());
                } catch (Exception e17) {
                    QLog.d("RelativeMultiPicHeadItemView", 1, "bindItemView set local image path error!exception:" + e17);
                }
            }
            return view;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.subscribe.widget.SubscribeBannerView.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public URLImageView e(ViewGroup viewGroup) {
            int i3;
            URLImageView uRLImageView = new URLImageView(viewGroup.getContext());
            if (RelativeMultiPicHeadItemView.this.M != 0) {
                i3 = RelativeMultiPicHeadItemView.this.M;
            } else {
                i3 = -1;
            }
            uRLImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, i3));
            return uRLImageView;
        }
    }

    public RelativeMultiPicHeadItemView(Context context) {
        super(context);
        this.J = ImmersiveUtils.getScreenWidth();
    }

    private void v(CertifiedAccountMeta$StImage certifiedAccountMeta$StImage) {
        if (certifiedAccountMeta$StImage.width.get() != 0 && certifiedAccountMeta$StImage.height.get() != 0) {
            float f16 = certifiedAccountMeta$StImage.height.get() / certifiedAccountMeta$StImage.width.get();
            if (f16 > 1.3333334f) {
                f16 = 1.3333334f;
            }
            int i3 = (int) (this.J * f16);
            this.M = i3;
            this.L.setBannerHeight(i3);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
        int i3;
        int i16;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = (CertifiedAccountMeta$StFeed) obj;
        if (this.L != null && certifiedAccountMeta$StFeed.images.get().size() > 0) {
            v(certifiedAccountMeta$StFeed.images.get(0));
            this.L.setDatas(certifiedAccountMeta$StFeed.images.get());
        }
        this.E.setText(certifiedAccountMeta$StFeed.content.get());
        AsyncRichTextView asyncRichTextView = this.E;
        if (certifiedAccountMeta$StFeed.content.get().trim().isEmpty()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        asyncRichTextView.setVisibility(i3);
        this.F.setText(certifiedAccountMeta$StFeed.title.get());
        TextView textView = this.F;
        if (certifiedAccountMeta$StFeed.title.get().trim().isEmpty()) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        textView.setVisibility(i16);
        this.G.setText(en.t(getContext(), certifiedAccountMeta$StFeed.createTime.get() * 1000));
        int i17 = certifiedAccountMeta$StFeed.visitorInfo.get().view_count.get();
        if (i17 > 0) {
            this.H.setVisibility(0);
            this.H.setText(UIUtils.d(i17) + HardCodeUtil.qqStr(R.string.vso));
        } else {
            this.H.setVisibility(8);
        }
        if (!StringUtil.isEmpty(certifiedAccountMeta$StFeed.poiInfo.get().defaultName.get())) {
            this.K.setVisibility(0);
            this.I.setText(certifiedAccountMeta$StFeed.poiInfo.get().defaultName.get());
        } else {
            this.K.setVisibility(8);
        }
    }

    public void destroy() {
        SubscribeBannerView subscribeBannerView = this.L;
        if (subscribeBannerView != null) {
            subscribeBannerView.destroy();
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public int i() {
        return R.layout.f167697c70;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.F = (TextView) findViewById(R.id.mck);
        this.G = (TextView) findViewById(R.id.mce);
        this.H = (TextView) findViewById(R.id.mcl);
        this.E = (AsyncRichTextView) findViewById(R.id.mcd);
        this.K = findViewById(R.id.lqu);
        this.I = (TextView) findViewById(R.id.mdl);
        SubscribeBannerView subscribeBannerView = (SubscribeBannerView) findViewById(R.id.f164709wl);
        this.L = subscribeBannerView;
        subscribeBannerView.setAdapter(new a());
    }

    public SubscribeBannerView u() {
        return this.L;
    }
}
