package com.qzone.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    public int f60758f;

    /* renamed from: i, reason: collision with root package name */
    private Context f60760i;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<Integer> f60756d = QQSysFaceUtil.getOrderList();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Integer> f60757e = QQEmojiUtil.getOrderList();

    /* renamed from: h, reason: collision with root package name */
    private int f60759h = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;

    public d(Context context, int i3) {
        this.f60760i = context;
        if (i3 == 0) {
            this.f60758f = 1;
        } else {
            this.f60758f = 2;
        }
    }

    public void a(int i3) {
        this.f60759h = i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f60758f == 1) {
            return this.f60756d.size();
        }
        return this.f60757e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        Drawable emojiDrawable;
        String emojiDescription;
        if (view == null) {
            ImageView imageView = new ImageView(this.f60760i);
            int dpToPx = ViewUtils.dpToPx(30.0f);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(dpToPx, dpToPx));
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            linearLayout = new LinearLayout(this.f60760i);
            int o16 = pl.a.f426446a.o(this.f60760i);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(o16 / this.f60759h, (int) ((o16 * 0.51180553f) / 4.0f)));
            linearLayout.setGravity(17);
            linearLayout.addView(imageView);
            linearLayout.setTag(imageView);
        } else {
            linearLayout = (LinearLayout) view;
        }
        ImageView imageView2 = (ImageView) linearLayout.getTag();
        if (this.f60758f == 1) {
            emojiDrawable = QQSysFaceUtil.getFaceDrawable(this.f60756d.get(i3).intValue());
            emojiDescription = QQSysFaceUtil.getFaceDescription(this.f60756d.get(i3).intValue());
        } else {
            emojiDrawable = QQEmojiUtil.getEmojiDrawable(this.f60757e.get(i3).intValue());
            emojiDescription = QQEmojiUtil.getEmojiDescription(this.f60757e.get(i3).intValue());
        }
        if (emojiDrawable != null) {
            imageView2.setImageDrawable(emojiDrawable);
        }
        if (!TextUtils.isEmpty(emojiDescription)) {
            if (emojiDescription.startsWith("/") && emojiDescription.length() > 1) {
                emojiDescription = emojiDescription.substring(1);
            }
            AccessibilityUtil.p(linearLayout, emojiDescription);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return linearLayout;
    }
}
