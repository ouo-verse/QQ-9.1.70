package j12;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.widget.f;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends RecyclerView.Adapter implements View.OnClickListener {
    public static int C;

    /* renamed from: m, reason: collision with root package name */
    private static WeakReference<View> f409098m;

    /* renamed from: d, reason: collision with root package name */
    private List<giftList$GroupGiftItem> f409099d;

    /* renamed from: e, reason: collision with root package name */
    private int f409100e;

    /* renamed from: f, reason: collision with root package name */
    private int f409101f;

    /* renamed from: h, reason: collision with root package name */
    private c f409102h;

    /* renamed from: i, reason: collision with root package name */
    private int f409103i = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: j12.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10562b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f409110d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f409111e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f409112f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f409113h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ImageView f409114i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ TextView f409115m;

        C10562b(RelativeLayout relativeLayout, ImageView imageView, TextView textView, RelativeLayout relativeLayout2, ImageView imageView2, TextView textView2) {
            this.f409110d = relativeLayout;
            this.f409111e = imageView;
            this.f409112f = textView;
            this.f409113h = relativeLayout2;
            this.f409114i = imageView2;
            this.f409115m = textView2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f409110d.setAlpha(valueAnimator.getAnimatedFraction());
            this.f409110d.setScaleX((valueAnimator.getAnimatedFraction() * 0.19999999f) + 0.8f);
            this.f409110d.setScaleY((valueAnimator.getAnimatedFraction() * 0.19999999f) + 0.8f);
            this.f409111e.setScaleX((valueAnimator.getAnimatedFraction() * 0.111111164f) + 1.0f);
            this.f409111e.setScaleY((valueAnimator.getAnimatedFraction() * 0.111111164f) + 1.0f);
            this.f409112f.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
            this.f409111e.setTranslationY((r0.getHeight() * (1.0f - this.f409111e.getScaleY())) / 2.0f);
            RelativeLayout relativeLayout = this.f409113h;
            if (relativeLayout != null) {
                relativeLayout.setScaleX(1.0f - (valueAnimator.getAnimatedFraction() * 0.19999999f));
                this.f409113h.setScaleY(1.0f - (valueAnimator.getAnimatedFraction() * 0.19999999f));
                this.f409113h.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
            }
            ImageView imageView = this.f409114i;
            if (imageView != null) {
                imageView.setScaleX(1.1111112f - (valueAnimator.getAnimatedFraction() * 0.111111164f));
                this.f409114i.setScaleY(1.1111112f - (valueAnimator.getAnimatedFraction() * 0.111111164f));
                this.f409114i.setTranslationY((r0.getHeight() * (1.0f - this.f409114i.getScaleY())) / 2.0f);
            }
            TextView textView = this.f409115m;
            if (textView != null) {
                textView.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    interface c {
        void a(View view, int i3, int i16);

        void onItemClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class d extends RecyclerView.ViewHolder {
        private ImageView C;
        private giftList$GroupGiftItem D;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f409116d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f409117e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f409118f;

        /* renamed from: h, reason: collision with root package name */
        private Button f409119h;

        /* renamed from: i, reason: collision with root package name */
        private RelativeLayout f409120i;

        /* renamed from: m, reason: collision with root package name */
        private TextView f409121m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes38.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f409122d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ giftList$GroupGiftItem f409123e;

            a(int i3, giftList$GroupGiftItem giftlist_groupgiftitem) {
                this.f409122d = i3;
                this.f409123e = giftlist_groupgiftitem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.C != this.f409122d) {
                    b.this.f409102h.onItemClick(view, this.f409122d);
                    b.this.u(view);
                    b.C = this.f409122d;
                    b.f409098m = new WeakReference(d.this.itemView);
                    d.this.D = this.f409123e;
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: j12.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public class ViewOnClickListenerC10563b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ giftList$GroupGiftItem f409125d;

            ViewOnClickListenerC10563b(giftList$GroupGiftItem giftlist_groupgiftitem) {
                this.f409125d = giftlist_groupgiftitem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.f409102h.a(view, this.f409125d.giftId.get(), this.f409125d.giftType.get());
                d.this.D = this.f409125d;
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes38.dex */
        public class c implements IElementDynamicParams {
            c() {
            }

            @Override // com.tencent.qqlive.module.videoreport.data.IElementDynamicParams
            public Map<String, Object> getElementDynamicParams() {
                if (d.this.D != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("yes_gift_id", Integer.valueOf(d.this.D.giftId.get()));
                    hashMap.put("yes_gift_name", d.this.D.giftName.get());
                    hashMap.put("yes_gift_price", Integer.valueOf(d.this.D.price.get()));
                    return hashMap;
                }
                return new HashMap();
            }
        }

        public d(View view) {
            super(view);
            if (view instanceof ViewGroup) {
                this.f409118f = (TextView) view.findViewById(R.id.f94595cp);
                this.f409116d = (ImageView) view.findViewById(R.id.xjn);
                this.f409117e = (TextView) view.findViewById(R.id.f95385eu);
                this.f409119h = (Button) view.findViewById(R.id.tje);
                this.f409120i = (RelativeLayout) view.findViewById(R.id.yeg);
                this.f409121m = (TextView) view.findViewById(R.id.f95715fq);
                this.C = (ImageView) view.findViewById(R.id.xjo);
            }
            e();
        }

        private void e() {
            try {
                c cVar = new c();
                VideoReport.setElementId(this.itemView, "em_sgrp_gift_list");
                VideoReport.setElementDynamicParams(this.itemView, cVar);
                VideoReport.setElementId(this.f409119h, "em_yes_gift_pannel_send");
                VideoReport.setElementDynamicParams(this.f409119h, cVar);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        public void d(int i3) {
            giftList$GroupGiftItem giftlist_groupgiftitem = (giftList$GroupGiftItem) b.this.f409099d.get(i3);
            this.f409118f.setText(giftlist_groupgiftitem.giftName.get());
            if (giftlist_groupgiftitem.thumbnail.has()) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = this.f409116d.getResources().getDrawable(R.drawable.o2t);
                this.f409116d.setImageDrawable(URLDrawable.getDrawable(giftlist_groupgiftitem.thumbnail.get(), obtain));
            }
            this.f409117e.setText(giftlist_groupgiftitem.price.get() + "\u91d1\u5e01");
            this.f409121m.setText(giftlist_groupgiftitem.price.get() + "");
            if (giftlist_groupgiftitem.backgroundImage.has()) {
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mLoadingDrawable = new ColorDrawable(0);
                this.C.setImageDrawable(URLDrawable.getDrawable(giftlist_groupgiftitem.backgroundImage.get(), obtain2));
            }
            if (i3 == b.C) {
                this.f409120i.setVisibility(0);
                this.f409116d.setScaleX(1.1111112f);
                this.f409116d.setScaleY(1.1111112f);
                this.f409116d.setTranslationY((BaseAIOUtils.f(66.0f, r1.getResources()) * (1.0f - this.f409116d.getScaleY())) / 2.0f);
                b.f409098m = new WeakReference(this.itemView);
                this.f409118f.setAlpha(0.0f);
            } else {
                this.f409120i.setVisibility(8);
                this.f409116d.setScaleX(1.0f);
                this.f409116d.setScaleY(1.0f);
                this.f409118f.setAlpha(1.0f);
            }
            this.itemView.setOnClickListener(new a(i3, giftlist_groupgiftitem));
            this.f409119h.setOnClickListener(new ViewOnClickListenerC10563b(giftlist_groupgiftitem));
        }
    }

    public b(List<giftList$GroupGiftItem> list, int i3) {
        this.f409100e = i3;
        this.f409099d = list;
        this.f409101f = 8 * i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f409099d.size();
        int i3 = this.f409103i;
        return size / i3 > this.f409100e ? i3 : this.f409099d.size() % this.f409103i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        ((d) viewHolder).d(this.f409101f + i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hgl, viewGroup, false));
    }

    public void t(c cVar) {
        this.f409102h = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view) {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;
        WeakReference<View> weakReference = f409098m;
        if (weakReference == null || weakReference.get() == null) {
            relativeLayout = null;
            imageView = null;
            textView = null;
        } else {
            relativeLayout = (RelativeLayout) f409098m.get().findViewById(R.id.yeg);
            imageView = (ImageView) f409098m.get().findViewById(R.id.xjn);
            textView = (TextView) f409098m.get().findViewById(R.id.f94595cp);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.yeg);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.xjn);
        TextView textView2 = (TextView) view.findViewById(R.id.f94595cp);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        RelativeLayout relativeLayout3 = relativeLayout;
        ImageView imageView3 = imageView;
        TextView textView3 = textView;
        ofFloat.addListener(new a(relativeLayout2, imageView2, textView2, relativeLayout3, imageView3, textView3));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new C10562b(relativeLayout2, imageView2, textView2, relativeLayout3, imageView3, textView3));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f409104d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f409105e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f409106f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f409107h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ImageView f409108i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ TextView f409109m;

        a(RelativeLayout relativeLayout, ImageView imageView, TextView textView, RelativeLayout relativeLayout2, ImageView imageView2, TextView textView2) {
            this.f409104d = relativeLayout;
            this.f409105e = imageView;
            this.f409106f = textView;
            this.f409107h = relativeLayout2;
            this.f409108i = imageView2;
            this.f409109m = textView2;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f409104d.setScaleX(1.0f);
            this.f409104d.setScaleY(1.0f);
            this.f409104d.setAlpha(1.0f);
            this.f409104d.setVisibility(0);
            this.f409105e.setScaleX(1.1111112f);
            this.f409105e.setScaleY(1.1111112f);
            this.f409106f.setAlpha(0.0f);
            this.f409105e.setTranslationY((r5.getHeight() * (1.0f - this.f409105e.getScaleY())) / 2.0f);
            RelativeLayout relativeLayout = this.f409107h;
            if (relativeLayout != null) {
                relativeLayout.setScaleX(0.8f);
                this.f409107h.setScaleY(0.8f);
                this.f409107h.setVisibility(8);
                this.f409107h.setAlpha(0.0f);
            }
            ImageView imageView = this.f409108i;
            if (imageView != null) {
                imageView.setScaleX(1.0f);
                this.f409108i.setScaleY(1.0f);
                this.f409108i.setTranslationY((r5.getHeight() * (1.0f - this.f409108i.getScaleY())) / 2.0f);
            }
            TextView textView = this.f409109m;
            if (textView != null) {
                textView.setAlpha(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f409104d.setScaleX(0.8f);
            this.f409104d.setScaleY(0.8f);
            this.f409104d.setVisibility(0);
            this.f409104d.setAlpha(0.0f);
            this.f409105e.setScaleX(1.0f);
            this.f409105e.setScaleY(1.0f);
            this.f409106f.setAlpha(1.0f);
            this.f409105e.setTranslationY((r6.getHeight() * (1.0f - this.f409105e.getScaleY())) / 2.0f);
            RelativeLayout relativeLayout = this.f409107h;
            if (relativeLayout != null) {
                relativeLayout.setScaleX(1.0f);
                this.f409107h.setScaleY(1.0f);
                this.f409107h.setVisibility(0);
                this.f409107h.setAlpha(1.0f);
            }
            ImageView imageView = this.f409108i;
            if (imageView != null) {
                imageView.setScaleX(1.1111112f);
                this.f409108i.setScaleY(1.1111112f);
                this.f409108i.setTranslationY((r6.getHeight() * (1.0f - this.f409108i.getScaleY())) / 2.0f);
            }
            TextView textView = this.f409109m;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
