package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import java.util.List;

/* loaded from: classes32.dex */
public class ComboProviderGridAdapter extends BaseAdapter implements Handler.Callback {
    int C;
    public Handler D = new Handler(this);

    /* renamed from: d, reason: collision with root package name */
    private Context f66597d;

    /* renamed from: e, reason: collision with root package name */
    List<QIMFilterCategoryItem> f66598e;

    /* renamed from: f, reason: collision with root package name */
    public GridView f66599f;

    /* renamed from: h, reason: collision with root package name */
    float f66600h;

    /* renamed from: i, reason: collision with root package name */
    float f66601i;

    /* renamed from: m, reason: collision with root package name */
    float f66602m;

    /* loaded from: classes32.dex */
    public static class LockAnimationDrawable extends DetectableAnimationDrawable {

        /* renamed from: e, reason: collision with root package name */
        ImageView f66604e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f66605f;

        /* renamed from: h, reason: collision with root package name */
        PopupWindow f66606h;

        /* renamed from: i, reason: collision with root package name */
        QIMFilterCategoryItem f66607i;

        public LockAnimationDrawable(AnimationDrawable animationDrawable, ImageView imageView, PopupWindow popupWindow, ImageView imageView2, QIMFilterCategoryItem qIMFilterCategoryItem) {
            super(animationDrawable);
            this.f66606h = popupWindow;
            this.f66604e = imageView;
            this.f66605f = imageView2;
            this.f66607i = qIMFilterCategoryItem;
        }

        @Override // com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable
        public void f() {
            this.f66606h.dismiss();
            this.f66604e.setImageDrawable(null);
            this.f66604e = null;
            this.f66606h = null;
            com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
            dVar.z().f(this.f66607i.f66697d);
            ea.H4(BaseApplicationImpl.getApplication(), this.f66607i.f66697d, false);
            m n3 = m.n();
            QIMFilterCategoryItem qIMFilterCategoryItem = this.f66607i;
            n3.Y(3, qIMFilterCategoryItem.f66701i, qIMFilterCategoryItem.f66697d);
            Bundle bundle = new Bundle();
            bundle.putInt("apply_source", 1);
            bundle.putInt("capture_scene", 0);
            dVar.l(this.f66607i, (Activity) this.f66605f.getContext(), bundle);
            this.f66605f.setVisibility(8);
            ComboProviderGridAdapter.e(this.f66605f, dVar.r(this.f66607i), this.f66607i);
        }
    }

    public ComboProviderGridAdapter(Context context, int i3) {
        this.f66597d = context;
        this.C = i3;
    }

    public static void e(ImageView imageView, com.tencent.aelight.camera.aioeditor.capture.data.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        m.n();
        boolean F = m.F(3, qIMFilterCategoryItem.f66701i, qIMFilterCategoryItem.f66697d);
        int i3 = aVar.f66706e;
        boolean c16 = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).z().c(qIMFilterCategoryItem.f66697d);
        if (!c16 && !qIMFilterCategoryItem.L && !F) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        if (c16) {
            imageView.setImageResource(R.drawable.eh5);
            return;
        }
        if (F) {
            imageView.setImageResource(R.drawable.f6r);
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                imageView.setImageResource(R.drawable.f6q);
                return;
            } else if (i3 != 3) {
                return;
            }
        }
        imageView.setVisibility(8);
    }

    public void a() {
        this.D.sendEmptyMessageDelayed(9, 600L);
    }

    public void d(final ImageView imageView, AnimationDrawable animationDrawable, QIMFilterCategoryItem qIMFilterCategoryItem) {
        if (QLog.isColorLevel()) {
            QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation ");
        }
        ImageView imageView2 = new ImageView(imageView.getContext());
        PopupWindow popupWindow = new PopupWindow((View) imageView2, -2, -2, true);
        popupWindow.setTouchable(true);
        popupWindow.setClippingEnabled(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(16777215));
        int[] iArr = new int[2];
        imageView.getLocationOnScreen(iArr);
        if (QLog.isColorLevel()) {
            QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation " + iArr[0] + "," + iArr[1]);
        }
        int dip2px = (ScreenUtil.dip2px(60.0f) - imageView.getWidth()) / 2;
        popupWindow.showAtLocation(imageView, 8388659, iArr[0] - dip2px, iArr[1] - dip2px);
        animationDrawable.setOneShot(true);
        LockAnimationDrawable lockAnimationDrawable = new LockAnimationDrawable(animationDrawable, imageView2, popupWindow, imageView, qIMFilterCategoryItem);
        this.D.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(4);
            }
        }, 200L);
        imageView2.setImageDrawable(lockAnimationDrawable);
        lockAnimationDrawable.start();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f66598e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f66598e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = 0;
        if (message.what == 9) {
            GridView gridView = this.f66599f;
            if (gridView != null && gridView.isShown()) {
                if (QLog.isColorLevel()) {
                    QLog.i("ComboLockManager", 2, "checkAnim");
                }
                int childCount = this.f66599f.getChildCount();
                com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
                QIMFilterCategoryItem qIMFilterCategoryItem = dVar.z().C;
                if (qIMFilterCategoryItem != null) {
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = this.f66599f.getChildAt(i3);
                        Object tag = childAt.getTag();
                        if (QIMFilterCategoryItem.class.isInstance(tag) && ((QIMFilterCategoryItem) tag).f66697d.equals(qIMFilterCategoryItem.f66697d)) {
                            try {
                                ImageView imageView = (ImageView) childAt.findViewById(R.id.bab);
                                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getContext().getResources().getDrawable(R.drawable.a_r);
                                dVar.z().C = null;
                                d(imageView, animationDrawable, qIMFilterCategoryItem);
                                break;
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation err", e16);
                                }
                            }
                        } else {
                            i3++;
                        }
                    }
                }
                return true;
            }
            QLog.i("ComboLockManager", 1, "checkAnim err, ignore");
        }
        return false;
    }

    public void setData(List<QIMFilterCategoryItem> list) {
        this.f66598e = list;
    }

    public void b(int i3) {
        QIMFilterCategoryItem qIMFilterCategoryItem = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).z().C;
        if (qIMFilterCategoryItem == null || qIMFilterCategoryItem.f66701i != i3) {
            return;
        }
        a();
    }

    private View c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f66597d);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f66597d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dpToPx = ViewUtils.dpToPx(5.0f);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        relativeLayout.addView(relativeLayout2, layoutParams);
        URLImageView uRLImageView = new URLImageView(this.f66597d);
        uRLImageView.setId(R.id.icon);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout2.addView(uRLImageView, new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this.f66597d);
        imageView.setId(R.id.f165790dj0);
        imageView.setVisibility(8);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.ec6);
        relativeLayout2.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.f66597d);
        linearLayout.setId(R.id.f3k);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        relativeLayout2.addView(linearLayout, layoutParams2);
        ImageView imageView2 = new ImageView(this.f66597d);
        imageView2.setImageResource(R.drawable.ec7);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(11.0f), ViewUtils.dpToPx(4.5f));
        layoutParams3.gravity = 16;
        linearLayout.addView(imageView2, layoutParams3);
        TextView textView = new TextView(this.f66597d);
        textView.setId(R.id.f3z);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(this.f66597d.getResources().getColor(R.color.f158017al3));
        textView.setMaxLines(1);
        textView.setLines(1);
        textView.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#7F000000"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        int dpToPx2 = ViewUtils.dpToPx(5.0f);
        layoutParams4.leftMargin = dpToPx2;
        layoutParams4.rightMargin = dpToPx2;
        linearLayout.addView(textView, layoutParams4);
        ImageView imageView3 = new ImageView(this.f66597d);
        imageView3.setImageResource(R.drawable.ec7);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(11.0f), ViewUtils.dpToPx(4.5f));
        layoutParams5.gravity = 16;
        linearLayout.addView(imageView3, layoutParams5);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.f66597d);
        relativeLayout3.setBackgroundResource(R.drawable.efm);
        relativeLayout3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(14, -1);
        layoutParams6.topMargin = ViewUtils.dpToPx(16.0f);
        relativeLayout2.addView(relativeLayout3, layoutParams6);
        TextView textView2 = new TextView(this.f66597d);
        textView2.setCompoundDrawables(null, null, this.f66597d.getResources().getDrawable(R.drawable.efn), null);
        textView2.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
        textView2.setText(HardCodeUtil.qqStr(R.string.kso));
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(this.f66597d.getResources().getColor(R.color.f158017al3));
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        relativeLayout3.addView(textView2, layoutParams7);
        TextView textView3 = new TextView(this.f66597d);
        textView3.setId(R.id.cah);
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(this.f66597d.getResources().getColor(R.color.f158017al3));
        textView3.setMaxLines(1);
        textView3.setLines(1);
        textView3.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#7F000000"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.bottomMargin = ViewUtils.dpToPx(5.0f);
        layoutParams8.addRule(14, -1);
        layoutParams8.addRule(12, -1);
        relativeLayout2.addView(textView3, layoutParams8);
        View qIMCommonLoadingView = new QIMCommonLoadingView(this.f66597d);
        qIMCommonLoadingView.setId(R.id.cak);
        qIMCommonLoadingView.setVisibility(8);
        relativeLayout2.addView(qIMCommonLoadingView, new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView4 = new ImageView(this.f66597d);
        imageView4.setId(R.id.bab);
        imageView4.setImageResource(R.drawable.f6q);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(10, -1);
        layoutParams9.addRule(11, -1);
        relativeLayout.addView(imageView4, layoutParams9);
        ImageView imageView5 = new ImageView(this.f66597d);
        imageView5.setId(R.id.l5d);
        imageView5.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(11, -1);
        layoutParams10.addRule(10, -1);
        relativeLayout.addView(imageView5, layoutParams10);
        return relativeLayout;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (this.f66600h <= 0.0f && viewGroup != null) {
            float measuredWidth = viewGroup.getMeasuredWidth();
            this.f66600h = measuredWidth;
            float paddingLeft = ((((measuredWidth - (c.C * 3)) - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight()) / 4.0f) + 0.5f;
            this.f66601i = paddingLeft;
            this.f66602m = (paddingLeft * 12.0f) / 160.0f;
        }
        View c16 = view == null ? c() : view;
        TextView textView = (TextView) c16.findViewById(R.id.cah);
        ImageView imageView = (ImageView) c16.findViewById(R.id.f165790dj0);
        ImageView imageView2 = (ImageView) c16.findViewById(R.id.icon);
        ImageView imageView3 = (ImageView) c16.findViewById(R.id.bab);
        TextView textView2 = (TextView) c16.findViewById(R.id.f3z);
        View findViewById = c16.findViewById(R.id.f3k);
        QIMCommonLoadingView qIMCommonLoadingView = (QIMCommonLoadingView) c16.findViewById(R.id.cak);
        QIMFilterCategoryItem qIMFilterCategoryItem = this.f66598e.get(i3);
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
        h hVar = m.n().f66502i[this.C];
        QIMFilterCategoryItem qIMFilterCategoryItem2 = hVar != null ? (QIMFilterCategoryItem) hVar.f66709i : null;
        boolean equals = qIMFilterCategoryItem2 != null ? TextUtils.equals(qIMFilterCategoryItem2.f66697d, qIMFilterCategoryItem.f66697d) : false;
        if (!equals) {
            equals = (qIMFilterCategoryItem2 == null || qIMFilterCategoryItem2.l()) && qIMFilterCategoryItem.l();
        }
        c16.setTag(qIMFilterCategoryItem);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) c16.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -1);
            c16.setLayoutParams(layoutParams);
        }
        ((ViewGroup.LayoutParams) layoutParams).height = (int) this.f66601i;
        if (qIMFilterCategoryItem.l()) {
            imageView.setVisibility(8);
            if (equals) {
                imageView2.setImageDrawable(this.f66597d.getResources().getDrawable(R.drawable.ec9));
            } else {
                imageView2.setImageDrawable(this.f66597d.getResources().getDrawable(R.drawable.ec_));
            }
            imageView3.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.ksp));
            findViewById.setVisibility(8);
        } else {
            textView.setVisibility(8);
            h r16 = dVar.r(qIMFilterCategoryItem);
            if (!TextUtils.isEmpty(qIMFilterCategoryItem.f66698e)) {
                findViewById.setVisibility(0);
                textView2.setText(qIMFilterCategoryItem.f66698e);
            } else {
                textView2.setText("");
                findViewById.setVisibility(8);
            }
            if (equals) {
                imageView.setImageResource(R.drawable.ec8);
                imageView.setVisibility(0);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, this.f66597d.getResources().getColor(R.color.acv));
            } else {
                imageView.setVisibility(8);
                textView.setShadowLayer(3.0f, 0.0f, 0.0f, this.f66597d.getResources().getColor(R.color.acv));
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = this.f66597d.getResources().getDrawable(R.drawable.ec5);
            obtain.mFailedDrawable = this.f66597d.getResources().getDrawable(R.drawable.ec5);
            obtain.mPlayGifImage = true;
            qIMCommonLoadingView.setMax(10000);
            URLDrawable drawable = URLDrawable.getDrawable(qIMFilterCategoryItem.f66700h, obtain);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            imageView2.setImageDrawable(drawable);
            textView.setText(qIMFilterCategoryItem.f66698e);
            if (qIMFilterCategoryItem.n()) {
                imageView3.setVisibility(8);
                ImageView imageView4 = (ImageView) c16.findViewById(R.id.l5d);
                imageView4.setImageResource(R.drawable.f6x);
                imageView4.setVisibility(0);
                l.f(qIMFilterCategoryItem);
            } else {
                ((ImageView) c16.findViewById(R.id.l5d)).setVisibility(8);
                qIMCommonLoadingView.setVisibility(0);
                qIMCommonLoadingView.setBgCorner(this.f66602m);
                qIMCommonLoadingView.a(com.tencent.aelight.camera.aioeditor.capture.view.c.c(r16));
                e(imageView3, r16, qIMFilterCategoryItem);
            }
        }
        if (dVar.z().C != null) {
            this.D.hasMessages(9);
        }
        EventCollector.getInstance().onListGetView(i3, c16, viewGroup, getItemId(i3));
        return c16;
    }
}
