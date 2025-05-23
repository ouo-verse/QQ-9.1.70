package com.tencent.mobileqq.guild.feed.detail.banner.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.cache.api.util.Priority;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.component.multitouchimg.p;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryPreloadPart;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.util.LoadingUtil;
import java.util.Iterator;

/* loaded from: classes13.dex */
public class GuildBannerPicItemView extends GuildBaseWidgetView<GuildFeedRichMediaData> {
    private static float D = 3.5f;
    private mj1.b C;

    /* renamed from: d, reason: collision with root package name */
    private MultiTouchImageView f218452d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f218453e;

    /* renamed from: f, reason: collision with root package name */
    private View f218454f;

    /* renamed from: h, reason: collision with root package name */
    private GuildFeedRichMediaData f218455h;

    /* renamed from: i, reason: collision with root package name */
    private GProStFeed f218456i;

    /* renamed from: m, reason: collision with root package name */
    private p f218457m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f218458e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f218459f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z16, boolean z17, String str) {
            super(z16);
            this.f218458e = z17;
            this.f218459f = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            QLog.d("GuildBannerPicItemView", 1, "bindData - onStateChange " + loadState);
            GuildBannerPicItemView.this.s0(loadState, option, this.f218458e, this.f218459f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class b extends ColorDrawable {
        public b(int i3) {
            super(i3);
        }
    }

    public GuildBannerPicItemView(@NonNull Context context) {
        super(context);
        this.C = new mj1.b();
        v0(this);
    }

    private void A0(GuildFeedRichMediaData guildFeedRichMediaData) {
        this.f218452d.setVisibility(0);
        y0(8);
        String d16 = bm.d(guildFeedRichMediaData);
        B0(guildFeedRichMediaData, d16, q0(d16, guildFeedRichMediaData));
    }

    private void B0(GuildFeedRichMediaData guildFeedRichMediaData, String str, Option option) {
        this.f218452d.setTag(str);
        e.a().f(option, new a(true, str.equals(bm.c(guildFeedRichMediaData.getImage())), str));
    }

    private Bitmap p0(GuildFeedRichMediaData guildFeedRichMediaData) {
        Iterator<String> it = bm.a(guildFeedRichMediaData.getImage()).iterator();
        Bitmap bitmap = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Log.d("GuildBannerPicItemView", "getBitmapToCache " + next);
            if (!TextUtils.isEmpty(next)) {
                QLog.d("GuildBannerPicItemView", 1, "find url from list, key: " + next);
                bitmap = GuildFeedGalleryPreloadPart.D9(e.d(next));
            }
            if (bitmap != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildBannerPicItemView", 1, "bitmap match,  from global cache, url:" + next);
                }
            }
        }
        return bitmap;
    }

    private Option q0(String str, GuildFeedRichMediaData guildFeedRichMediaData) {
        String str2;
        Drawable drawable;
        Object tag = this.f218452d.getTag();
        if (tag instanceof String) {
            str2 = (String) tag;
        } else {
            str2 = "";
        }
        if (!str.equals(str2) && !bm.s(guildFeedRichMediaData.getImage(), str2)) {
            drawable = null;
        } else {
            drawable = this.f218452d.getDrawable();
        }
        if (drawable == null) {
            drawable = r0(getContext(), guildFeedRichMediaData);
        }
        BaseApplication context = BaseApplication.getContext();
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(context);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(context);
        int min = Math.min(instantScreenWidth, guildFeedRichMediaData.getImage().width);
        return new Option().setTargetView(this.f218452d).setUrl(str).setLoadingDrawable(drawable).setRequestWidth(min).setRequestHeight(Math.min(instantScreenHeight, guildFeedRichMediaData.getImage().height)).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565).setPredecode(true);
    }

    private Drawable r0(Context context, GuildFeedRichMediaData guildFeedRichMediaData) {
        Bitmap p06 = p0(guildFeedRichMediaData);
        if (p06 == null) {
            z0(0);
            return new b(-16777216);
        }
        return new BitmapDrawable(context.getResources(), p06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(LoadState loadState, Option option, boolean z16, String str) {
        Priority priority;
        IocPromise A;
        if (loadState != LoadState.STATE_PREPARE && loadState != LoadState.STATE_DOWNLOADING && loadState != LoadState.STATE_DECODING && z16 && (A = ax.A(oj1.a.class, this)) != null) {
            A.done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.detail.banner.item.b
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    GuildBannerPicItemView.x0(obj);
                }
            }).run();
        }
        if (loadState.isFinishSuccess()) {
            z0(8);
            y0(8);
            if (option.getAnimatable() != null) {
                option.getAnimatable().start();
            }
        } else if (loadState.isFinishError() && (option.getLoadingDrawable() instanceof b)) {
            z0(8);
            y0(0);
        }
        Bitmap resultBitMap = option.getResultBitMap();
        if (resultBitMap != null) {
            if (z16) {
                priority = Priority.Low;
            } else {
                priority = Priority.Normal;
            }
            GuildFeedGalleryPreloadPart.K9(e.d(str), resultBitMap, priority);
            if (QLog.isColorLevel()) {
                QLog.d("GuildBannerPicItemView", 1, "save bitmap to global image cache, isLoadOriginal: " + z16 + " key: " + str);
            }
        }
    }

    private void u0() {
        if (getContext() instanceof QPublicTransFragmentActivity) {
            Object obj = ((QPublicTransFragmentActivity) getContext()).getIntent().getExtras().get(com.tencent.mobileqq.guild.feed.b.C);
            if (obj instanceof RectF) {
                RectF rectF = (RectF) obj;
                QLog.i("GuildBannerPicItemView", 1, "initPicInitParams displayRect=" + rectF + " height=" + rectF.height() + " width=" + rectF.width());
                com.tencent.mobileqq.guild.component.multitouchimg.c cVar = new com.tencent.mobileqq.guild.component.multitouchimg.c();
                cVar.f216010b = rectF.height();
                cVar.f216009a = rectF.width();
                cVar.f216011c = (int) rectF.left;
                cVar.f216012d = (int) rectF.top;
                this.f218452d.l().U(cVar);
            }
        }
    }

    private void v0(View view) {
        this.f218452d = (MultiTouchImageView) view.findViewById(R.id.wko);
        this.f218453e = (ImageView) view.findViewById(R.id.wkj);
        this.f218454f = view.findViewById(R.id.wtr);
        ImageView imageView = (ImageView) view.findViewById(R.id.wts);
        if (imageView != null) {
            imageView.setImageDrawable(GuildUIUtils.y(imageView.getContext(), R.drawable.qui_image_broken, Color.parseColor("#4D4D4D")));
        }
        this.f218452d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageViewPorterDuffUtils.f235385a.c(this.f218452d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(MotionEvent motionEvent) {
        if (Math.abs(this.f218452d.getScale() - 1.0f) > 0.15d) {
            this.f218452d.setScale(1.0f, true);
        } else {
            MultiTouchImageView multiTouchImageView = this.f218452d;
            multiTouchImageView.setScale(multiTouchImageView.getMaximumScale(), motionEvent.getX(), motionEvent.getY(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x0(Object obj) {
        if (obj instanceof oj1.a) {
            ((oj1.a) obj).G2();
        }
    }

    private void y0(int i3) {
        View view = this.f218454f;
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    private void z0(int i3) {
        ImageView imageView = this.f218453e;
        if (imageView == null) {
            return;
        }
        if (i3 == 0) {
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(imageView.getContext(), 1));
        }
        this.f218453e.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.emo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
        if (guildFeedRichMediaData == null) {
            return;
        }
        this.f218455h = guildFeedRichMediaData;
        u0();
        A0(guildFeedRichMediaData);
        this.f218452d.setOnViewTapListener(this.f218457m);
        this.f218452d.setOnDoubleTabListener(new com.tencent.mobileqq.guild.component.multitouchimg.d() { // from class: com.tencent.mobileqq.guild.feed.detail.banner.item.a
            @Override // com.tencent.mobileqq.guild.component.multitouchimg.d
            public final void onDoubleTap(MotionEvent motionEvent) {
                GuildBannerPicItemView.this.w0(motionEvent);
            }
        });
        this.C.c(this.f218452d);
        float f16 = guildFeedRichMediaData.getImage().height / guildFeedRichMediaData.getImage().width;
        if (f16 > DisplayUtil.getScreenHeight() / DisplayUtil.getScreenWidth()) {
            this.f218452d.setMaximumScale(f16 * D);
        }
    }

    public MultiTouchImageView o0() {
        return this.f218452d;
    }

    public void setFeedInfo(GProStFeed gProStFeed) {
        this.f218456i = gProStFeed;
    }

    public void setOnViewTapListener(p pVar) {
        this.f218457m = pVar;
    }
}
