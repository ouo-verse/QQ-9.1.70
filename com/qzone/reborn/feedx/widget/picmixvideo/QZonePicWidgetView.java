package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import mqq.app.MobileQQ;

/* loaded from: classes37.dex */
public class QZonePicWidgetView extends QZoneMixBaseWidgetView {
    private ImageView D;
    private PictureItem E;
    private TextView F;
    private String G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PictureItem f56466d;

        a(PictureItem pictureItem) {
            this.f56466d = pictureItem;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            String str;
            BusinessFeedData businessFeedData;
            if (loadState.isFinishSuccess() && option.getAnimatable() != null) {
                Animatable animatable = option.getAnimatable();
                if (animatable instanceof r01.c) {
                    ((r01.c) animatable).setLoopCount(65535);
                }
                animatable.start();
            }
            if (loadState.isFinishSuccess() && (businessFeedData = QZonePicWidgetView.this.f56454e) != null && businessFeedData.getPictureInfo() != null && QZonePicWidgetView.this.f56454e.getPictureInfo().pics.size() == 1) {
                QZonePicWidgetView.this.y0(loadState, option);
            }
            if (loadState.isFinishError()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadImage  | state = ");
                sb5.append(loadState);
                sb5.append(" | feedskey = ");
                BusinessFeedData businessFeedData2 = QZonePicWidgetView.this.f56454e;
                if (businessFeedData2 != null) {
                    str = businessFeedData2.getFeedCommInfo().feedskey;
                } else {
                    str = "";
                }
                sb5.append(str);
                sb5.append(" | pos = ");
                sb5.append(QZonePicWidgetView.this.f56455f);
                sb5.append(" | url = ");
                sb5.append(this.f56466d.currentUrl.url);
                QLog.e("QZonePicWidgetView", 1, sb5.toString());
            }
        }
    }

    public QZonePicWidgetView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(BitmapDrawable bitmapDrawable) {
        this.E.currentUrl.width = bitmapDrawable.getIntrinsicWidth();
        this.E.currentUrl.height = bitmapDrawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.f56457i.getLayoutParams();
        b.a(getContext(), this.f56454e, layoutParams, this.E.currentUrl, q0());
        this.f56457i.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.D.setLayoutParams(layoutParams2);
        com.qzone.reborn.feedx.widget.picmixvideo.a.a(getContext(), b.g(this.f56454e.getFeedCommInfo().feedskey, this.E.currentUrl), layoutParams.width, layoutParams.height);
        D0();
        QLog.i("QZonePicWidgetView", 1, "adjustSinglePicNoHW  | feedId = " + this.f56454e.getFeedCommInfo().feedskey + " | pos = " + this.f56455f + " | url = " + this.E.currentUrl.url + " | width = " + this.E.currentUrl.width + " | height = " + this.E.currentUrl.height + " | this = " + this + " | mFeedData = " + this.f56454e.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(LoadState loadState, Option option) {
        PictureItem pictureItem;
        BusinessFeedData businessFeedData = this.f56454e;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || (pictureItem = this.E) == null || pictureItem.currentUrl == null || !loadState.isFinishSuccess() || option.getResultBitMap() == null || this.f56454e.getPictureInfo().pics.size() != 1) {
            return;
        }
        PictureUrl pictureUrl = this.E.currentUrl;
        if (pictureUrl.width <= 0 || pictureUrl.height <= 0) {
            Pair<Integer, Integer> c16 = com.qzone.reborn.feedx.widget.picmixvideo.a.c(getContext(), b.g(this.f56454e.getFeedCommInfo().feedskey, this.E.currentUrl));
            if (c16 == null || ((Integer) c16.first).intValue() <= 0 || ((Integer) c16.second).intValue() <= 0) {
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZonePicWidgetView.this.B0(bitmapDrawable);
                    }
                });
            }
        }
    }

    private void D0() {
        PictureItem pictureItem = this.E;
        if (pictureItem == null || pictureItem.currentUrl == null || this.D == null) {
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(this.E.currentUrl.url);
        if (this.D.getLayoutParams() != null) {
            obtain.setRequestWidth(this.D.getLayoutParams().width);
            obtain.setRequestHeight(this.D.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    private void F0(String str) {
        if (this.F == null) {
            TextView z06 = z0();
            this.F = z06;
            addView(z06);
        }
        this.F.setText(str);
        this.F.setVisibility(0);
    }

    private void G0(PictureItem pictureItem) {
        String str;
        if (pictureItem != null && pictureItem.currentUrl != null) {
            Option e16 = com.tencent.mobileqq.qzone.picload.c.e(tk.h.s(pictureItem));
            e16.setTargetView(this.D);
            if (this.D.getLayoutParams() != null) {
                e16.setRequestWidth(this.D.getLayoutParams().width);
                e16.setRequestHeight(this.D.getLayoutParams().height);
            }
            if (tk.h.B(pictureItem) && !tk.h.D(pictureItem)) {
                e16.setGroupKey(tk.h.q(pictureItem));
            }
            com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
            e16.setLoadingDrawable(mVar.b(getContext()));
            e16.setLoadingDrawable(mVar.a(getContext()));
            if (!ImageUtil.isJpgFile(e16.getUrl())) {
                e16.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
            }
            this.E.localFileUrl = com.tencent.mobileqq.qzone.picload.c.a().d(e16);
            if (TextUtils.equals(this.E.localFileUrl, this.G)) {
                PictureUrl pictureUrl = pictureItem.currentUrl;
                if (pictureUrl.width > 0 && pictureUrl.height > 0) {
                    QLog.d("QZonePicWidgetView", 4, "same url, just return: " + this.G);
                    return;
                }
            }
            this.G = this.E.localFileUrl;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Pic bindData   | mFeedPosition = ");
            sb5.append(this.f56455f);
            sb5.append(" | drawable = ");
            sb5.append(this.D.getDrawable());
            sb5.append(" | seq = ");
            sb5.append(e16.getSeq());
            sb5.append(" | nick = ");
            BusinessFeedData businessFeedData = this.f56454e;
            sb5.append(businessFeedData != null ? businessFeedData.getUser().nickName : null);
            sb5.append(" | text = ");
            sb5.append(com.qzone.reborn.feedx.util.n.e(this.f56454e));
            sb5.append(" | feedskey = ");
            BusinessFeedData businessFeedData2 = this.f56454e;
            if (businessFeedData2 != null) {
                str = businessFeedData2.getFeedCommInfo().feedskey;
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append(" | url = ");
            sb5.append(pictureItem.currentUrl.url);
            sb5.append(" | dataWidth = ");
            sb5.append(pictureItem.currentUrl.width);
            sb5.append(" | dataHeight = ");
            sb5.append(pictureItem.currentUrl.height);
            sb5.append(" | picWidth = ");
            sb5.append(this.D.getLayoutParams() == null ? null : Integer.valueOf(this.D.getLayoutParams().width));
            sb5.append(" | picHeight = ");
            sb5.append(this.D.getLayoutParams() != null ? Integer.valueOf(this.D.getLayoutParams().height) : null);
            sb5.append(" | this = ");
            sb5.append(this);
            sb5.append(" | mFeedData = ");
            sb5.append(this.f56454e.hashCode());
            QLog.d("QZonePicWidgetView", 4, sb5.toString());
            com.tencent.mobileqq.qzone.picload.c.a().i(e16, new a(pictureItem));
            return;
        }
        RFWLog.e("QZonePicWidgetView", RFWLog.USR, "picInfo is invalid");
    }

    private void H0() {
        PictureItem pictureItem = this.E;
        if (pictureItem == null) {
            return;
        }
        if (pictureItem.isAutoPlayGif) {
            F0(com.qzone.util.l.a(R.string.rhn));
            return;
        }
        if (E0(pictureItem)) {
            F0(com.qzone.util.l.a(R.string.shw));
            return;
        }
        TextView textView = this.F;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(final LoadState loadState, final Option option) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.i
            @Override // java.lang.Runnable
            public final void run() {
                QZonePicWidgetView.this.C0(loadState, option);
            }
        });
    }

    private TextView z0() {
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
        layoutParams.setMargins(0, 0, ar.d(12.0f), ar.d(10.0f));
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        textView.setGravity(17);
        textView.setTextSize(10.0f);
        textView.setBackgroundResource(R.drawable.f153545);
        textView.setPadding(ar.d(6.0f), ar.d(4.0f), ar.d(6.0f), ar.d(4.0f));
        return textView;
    }

    public void A0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = new RoundCorneredFrameLayout(getContext());
        this.f56457i = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(DisplayUtil.dip2px(MobileQQ.sMobileQQ, 2.0f));
        this.f56457i.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.f56457i);
        ImageView imageView = new ImageView(getContext());
        this.D = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.D.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f56457i.addView(this.D);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView
    public String getLogTag() {
        return "QZonePicWidgetView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(PictureItem pictureItem, int i3) {
        super.bindData(pictureItem, i3);
        this.E = pictureItem;
        G0(pictureItem);
        H0();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView
    public ImageView p0() {
        return this.D;
    }

    public QZonePicWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZonePicWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = "";
        A0();
    }

    private boolean E0(PictureItem pictureItem) {
        return pictureItem != null && pictureItem.fakeLongPic == 1;
    }
}
