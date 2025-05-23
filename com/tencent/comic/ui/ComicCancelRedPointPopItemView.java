package com.tencent.comic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.util.Random;

/* loaded from: classes32.dex */
public class ComicCancelRedPointPopItemView extends FrameLayout {
    private static int[] E = {R.drawable.f159943in4, R.drawable.in5, R.drawable.in6, R.drawable.in7, R.drawable.in8, R.drawable.in9};
    public ComicCancelRedPointPopItemData C;
    public int D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f99399d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView[] f99400e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f99401f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f99402h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f99403i;

    /* renamed from: m, reason: collision with root package name */
    private TextView[] f99404m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements DownloadParams.DecodeHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f99405a;

        a(Context context) {
            this.f99405a = context;
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            return BaseImageUtil.getRoundedCornerBitmap2(bitmap, x.c(this.f99405a, 8.0f), x.c(this.f99405a, 260.0f), x.c(this.f99405a, 346.5f));
        }
    }

    public ComicCancelRedPointPopItemView(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.dhz, (ViewGroup) this, true);
        this.f99399d = (ImageView) findViewById(R.id.r_l);
        this.f99401f = (LinearLayout) findViewById(R.id.r_m);
        this.f99402h = (TextView) findViewById(R.id.r_k);
        this.f99403i = (TextView) findViewById(R.id.r_s);
        this.f99400e[0] = (ImageView) findViewById(R.id.r_g);
        this.f99400e[1] = (ImageView) findViewById(R.id.r_h);
        this.f99400e[2] = (ImageView) findViewById(R.id.r_i);
        this.f99404m[0] = (TextView) findViewById(R.id.r_p);
        this.f99404m[1] = (TextView) findViewById(R.id.r_q);
        this.f99404m[2] = (TextView) findViewById(R.id.r_r);
        Random random = new Random();
        int nextInt = random.nextInt(E.length);
        this.f99400e[0].setImageResource(E[nextInt]);
        int nextInt2 = random.nextInt(2) + 1 + nextInt;
        int[] iArr = E;
        this.f99400e[1].setImageResource(iArr[nextInt2 % iArr.length]);
        int nextInt3 = nextInt - (random.nextInt(2) + 1);
        int[] iArr2 = E;
        this.f99400e[2].setImageResource(iArr2[(nextInt3 + iArr2.length) % iArr2.length]);
    }

    private void c(Context context, String str) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.imu);
        if (TextUtils.isEmpty(str)) {
            this.f99399d.setBackgroundDrawable(drawable);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        drawable2.setDecodeHandler(new a(context));
        drawable2.startDownload();
        this.f99399d.setBackgroundDrawable(drawable2);
    }

    public void setData(ComicCancelRedPointPopItemData comicCancelRedPointPopItemData) {
        String str;
        this.C = comicCancelRedPointPopItemData;
        if (comicCancelRedPointPopItemData == null) {
            return;
        }
        c(getContext(), comicCancelRedPointPopItemData.coverImg);
        this.f99403i.setText(comicCancelRedPointPopItemData.title);
        if (comicCancelRedPointPopItemData.friendNum <= 0) {
            this.f99401f.setVisibility(8);
        } else {
            this.f99401f.setVisibility(0);
            int i3 = 0;
            while (true) {
                ImageView[] imageViewArr = this.f99400e;
                if (i3 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i3].setVisibility(((long) i3) < comicCancelRedPointPopItemData.friendNum ? 0 : 8);
                i3++;
            }
            if (TextUtils.isEmpty(comicCancelRedPointPopItemData.text)) {
                TextView textView = this.f99402h;
                StringBuilder sb5 = new StringBuilder();
                if (comicCancelRedPointPopItemData.friendNum > 1) {
                    str = comicCancelRedPointPopItemData.friendNum + "\u4f4d\u597d\u53cb";
                } else {
                    str = "\u597d\u53cb\u521a\u521a";
                }
                sb5.append(str);
                sb5.append(a(comicCancelRedPointPopItemData.behavior, comicCancelRedPointPopItemData.friendNum));
                textView.setText(sb5.toString());
            } else {
                this.f99402h.setText(comicCancelRedPointPopItemData.text);
            }
        }
        for (int i16 = 0; i16 < this.f99404m.length; i16++) {
            if (i16 >= comicCancelRedPointPopItemData.tags.size()) {
                this.f99404m[i16].setVisibility(8);
            } else {
                this.f99404m[i16].setVisibility(0);
                this.f99404m[i16].setText(comicCancelRedPointPopItemData.tags.get(i16));
            }
        }
    }

    public ComicCancelRedPointPopItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComicCancelRedPointPopItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f99399d = null;
        this.f99400e = new ImageView[3];
        this.f99401f = null;
        this.f99402h = null;
        this.f99403i = null;
        this.f99404m = new TextView[3];
        this.C = null;
        this.D = 0;
        b(context);
    }

    private String a(int i3, long j3) {
        if (i3 == 2) {
            return "\u6536\u85cf";
        }
        if (i3 == 3) {
            return "\u70b9\u8d5e";
        }
        if (j3 > 1) {
            return "\u5728\u770b";
        }
        return "\u770b\u8fc7";
    }
}
