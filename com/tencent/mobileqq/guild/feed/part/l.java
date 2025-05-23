package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.component.imagebanner.ImageBanner;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.detail.event.GalleryPicScaleChangeEvent;
import com.tencent.mobileqq.guild.feed.detail.event.GalleryPicScaleFingerUpEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryFirstPagerEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryPageCloseEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.ShowFeedPicEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.part.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class l extends d {

    /* renamed from: d, reason: collision with root package name */
    private RFWDragLayout f222561d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedGalleryInitBean f222562e;

    /* renamed from: f, reason: collision with root package name */
    private ImageBanner f222563f;

    /* renamed from: h, reason: collision with root package name */
    private View f222564h;

    /* renamed from: i, reason: collision with root package name */
    private View f222565i;

    /* renamed from: m, reason: collision with root package name */
    private final GuildOldGalleryAnimHelper f222566m = new GuildOldGalleryAnimHelper(R.id.wko);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p0(int i3) {
            l.this.Q9(i3);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i3) {
            super.onPageSelected(i3);
            QLog.i("TM-GuildFeedGalleryAnimPart", 1, "onPageSelected position=" + i3);
            if (l.this.f222562e != null && l.this.f222562e.getRichMediaDataList().size() > 1) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryFirstPagerEvent(l.this.f222562e.getFeedId(), i3), false);
                l.this.f222563f.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.a.this.p0(i3);
                    }
                }, 80L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements RFWDragLayout.DragInterceptDelegate {
        c() {
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.DragInterceptDelegate
        public boolean needIntercept(MotionEvent motionEvent, float f16, float f17) {
            if (Math.abs(f16) <= f17) {
                return true;
            }
            return false;
        }
    }

    private void G9() {
        FragmentTransaction beginTransaction = getHostFragment().getActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.remove(getHostFragment());
        beginTransaction.commitNowAllowingStateLoss();
    }

    private boolean H9() {
        if (!(getContext() instanceof QPublicTransFragmentActivity)) {
            return false;
        }
        boolean z16 = ((QPublicTransFragmentActivity) getContext()).getIntent().getExtras().getBoolean(com.tencent.mobileqq.guild.feed.b.E, false);
        QLog.i("TM-GuildFeedGalleryAnimPart", 1, "closeGalleryFragment=" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9() {
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.j
            @Override // java.lang.Runnable
            public final void run() {
                l.this.P9();
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryPageCloseEvent(this.f222562e.getFeedId()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9() {
        this.f222566m.h(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.i
            @Override // java.lang.Runnable
            public final void run() {
                l.this.I9();
            }
        });
    }

    private void K9(GalleryPicScaleFingerUpEvent galleryPicScaleFingerUpEvent) {
        if (this.f222562e.getOpenType() == 1 && galleryPicScaleFingerUpEvent.getScale() < 1.0f) {
            J9();
        }
    }

    private void L9(GalleryPicScaleChangeEvent galleryPicScaleChangeEvent) {
        if (this.f222562e.getOpenType() != 1) {
            return;
        }
        if (galleryPicScaleChangeEvent.getScale() >= 1.0f) {
            this.f222565i.getBackground().setAlpha(255);
        } else if (galleryPicScaleChangeEvent.getScale() > 0.9d) {
            this.f222565i.getBackground().setAlpha((int) ((galleryPicScaleChangeEvent.getScale() * 2000.0f) - 1745.0f));
        } else {
            this.f222565i.getBackground().setAlpha(55);
        }
    }

    private void M9() {
        this.f222563f.i0(new a());
    }

    private boolean N9() {
        if (getActivity() == null) {
            QLog.e("TM-GuildFeedGalleryAnimPart", 1, "getActivity() == null");
            return false;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("TM-GuildFeedGalleryAnimPart", 1, "intent == null");
            return false;
        }
        if (intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (serializableExtra instanceof GuildFeedGalleryInitBean) {
                this.f222562e = (GuildFeedGalleryInitBean) serializableExtra;
                return true;
            }
        }
        QLog.e("TM-GuildFeedGalleryAnimPart", 1, "GalleryInitBean is empty");
        return false;
    }

    private void O9() {
        this.f222561d.setFeatureEnable(true);
        this.f222561d.setEnableDragHorizontal(true);
        this.f222561d.setEnableDragVertical(true);
        this.f222561d.setEnableChangeWindowBg(false);
        this.f222561d.setOnDragListener(new b());
        this.f222561d.setDragInterceptDelegate(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9() {
        boolean H9 = H9();
        QLog.i("TM-GuildFeedGalleryAnimPart", 1, "finishActivityWithoutAnim closeFragment=" + H9);
        SimpleEventBus.getInstance().dispatchEvent(new ShowFeedPicEvent());
        if (H9) {
            G9();
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(int i3) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.f222562e;
        if (guildFeedGalleryInitBean == null) {
            QLog.e("TM-GuildFeedGalleryAnimPart", 1, "updateEnterRect mGalleryInitBean == null");
            return;
        }
        int transitionBeanCreatorKey = guildFeedGalleryInitBean.getTransitionBeanCreatorKey();
        QLog.i("TM-GuildFeedGalleryAnimPart", 2, "updateEnterRect CreatorKey=" + transitionBeanCreatorKey);
        TransitionHelper.TransitionBeanCreator transitionBeanCreator = TransitionHelper.g().getTransitionBeanCreator(transitionBeanCreatorKey);
        if (transitionBeanCreator == null) {
            QLog.e("TM-GuildFeedGalleryAnimPart", 1, "updateEnterRect creator == null");
            return;
        }
        TransitionBean generateTransitionBean = transitionBeanCreator.generateTransitionBean(i3);
        if (generateTransitionBean == null) {
            QLog.e("TM-GuildFeedGalleryAnimPart", 1, "updateEnterRect mTransitionBean == null");
            return;
        }
        if (generateTransitionBean.getEnterViewRect() == null) {
            QLog.e("TM-GuildFeedGalleryAnimPart", 1, "updateEnterRect sourceRect == null");
        } else {
            this.f222566m.k(new AnimationParams(r10.getLeft(), r10.getTop(), r10.getWidth(), r10.getHeight(), r10.getHeight()));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GalleryPicScaleFingerUpEvent.class);
        arrayList.add(GalleryPicScaleChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "message_page_close") && (obj instanceof oj1.c)) {
            J9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        J9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f222565i = view.findViewById(R.id.vhf);
        this.f222564h = view.findViewById(R.id.wtf);
        this.f222561d = (RFWDragLayout) view.findViewById(R.id.ulf);
        this.f222563f = (ImageBanner) view.findViewById(R.id.wio);
        this.f222565i.getBackground().mutate();
        if (N9()) {
            M9();
            O9();
        }
        if (getContext() instanceof Activity) {
            com.tencent.mobileqq.theme.a.e(((Activity) getContext()).getWindow(), -16777216);
        }
        this.f222566m.f(getActivity(), view);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GalleryPicScaleFingerUpEvent) {
            K9((GalleryPicScaleFingerUpEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GalleryPicScaleChangeEvent) {
            L9((GalleryPicScaleChangeEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements RFWDragLayout.OnDragListener {
        b() {
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onDragging(float f16) {
            int i3 = (int) (f16 * 255.0f);
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > 255) {
                i3 = 255;
            }
            l.this.f222565i.getBackground().setAlpha(i3);
            l.this.f222564h.setVisibility(4);
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onEndDrag(boolean z16) {
            QLog.d("TM-GuildFeedGalleryAnimPart", 4, "onEndDrag=========== isDragToClose=" + z16);
            if (z16) {
                l.this.J9();
            } else {
                l.this.f222565i.setBackgroundColor(-16777216);
                l.this.f222564h.setVisibility(0);
            }
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onStartDrag() {
        }
    }
}
