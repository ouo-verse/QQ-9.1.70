package com.tencent.comic.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.e;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.comic.ui.ComicHorizontalCenterScrollView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.util.x;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends Dialog implements View.OnClickListener {
    private LinearLayout C;
    private TextView D;
    private WeakReference<Activity> E;
    private ComicHorizontalCenterScrollView.a F;

    /* renamed from: d, reason: collision with root package name */
    public boolean f99465d;

    /* renamed from: e, reason: collision with root package name */
    public int f99466e;

    /* renamed from: f, reason: collision with root package name */
    private ComicHorizontalCenterScrollView f99467f;

    /* renamed from: h, reason: collision with root package name */
    private ComicCancelRedPointPopItemView[] f99468h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView[] f99469i;

    /* renamed from: m, reason: collision with root package name */
    private Rect[] f99470m;

    /* compiled from: P */
    /* renamed from: com.tencent.comic.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C1012a implements ComicHorizontalCenterScrollView.a {
        C1012a() {
        }

        @Override // com.tencent.comic.ui.ComicHorizontalCenterScrollView.a
        public void a(int i3) {
            if (a.this.C != null && a.this.C.getVisibility() == 8) {
                a.this.C.setVisibility(0);
            }
            a aVar = a.this;
            aVar.h(aVar.d(i3));
        }
    }

    public a(Context context, Activity activity, int i3) {
        super(context, i3);
        this.f99465d = false;
        this.f99466e = 0;
        this.f99467f = null;
        this.f99468h = new ComicCancelRedPointPopItemView[5];
        this.f99469i = new ImageView[5];
        this.f99470m = new Rect[5];
        this.C = null;
        this.D = null;
        this.F = new C1012a();
        this.E = new WeakReference<>(activity);
        setContentView(R.layout.dhy);
        e(context);
        setCanceledOnTouchOutside(false);
    }

    private void e(Context context) {
        i f16 = x.f(context);
        ComicHorizontalCenterScrollView comicHorizontalCenterScrollView = (ComicHorizontalCenterScrollView) findViewById(R.id.r_9);
        this.f99467f = comicHorizontalCenterScrollView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) comicHorizontalCenterScrollView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(f16.f185860a, x.c(context, 346.5f));
            layoutParams.topMargin = x.c(context, 15.0f);
        } else {
            layoutParams.width = f16.f185860a;
        }
        this.f99467f.setLayoutParams(layoutParams);
        int c16 = x.c(context, 260.0f);
        int c17 = x.c(context, 8.0f);
        this.f99467f.setBaseInfo(c16, c17, this.F);
        this.D = (TextView) findViewById(R.id.r_a);
        int i3 = 0;
        this.f99468h[0] = (ComicCancelRedPointPopItemView) findViewById(R.id.r_b);
        this.f99468h[1] = (ComicCancelRedPointPopItemView) findViewById(R.id.r_c);
        this.f99468h[2] = (ComicCancelRedPointPopItemView) findViewById(R.id.r_d);
        this.f99468h[3] = (ComicCancelRedPointPopItemView) findViewById(R.id.r_e);
        this.f99468h[4] = (ComicCancelRedPointPopItemView) findViewById(R.id.r_f);
        this.f99469i[0] = (ImageView) findViewById(R.id.r_1);
        this.f99469i[1] = (ImageView) findViewById(R.id.r_2);
        this.f99469i[2] = (ImageView) findViewById(R.id.r_3);
        this.f99469i[3] = (ImageView) findViewById(R.id.r_4);
        this.f99469i[4] = (ImageView) findViewById(R.id.r_5);
        this.C = (LinearLayout) findViewById(R.id.r_6);
        this.D.setOnClickListener(this);
        int i16 = c16 + c17;
        while (true) {
            ComicCancelRedPointPopItemView[] comicCancelRedPointPopItemViewArr = this.f99468h;
            if (i3 >= comicCancelRedPointPopItemViewArr.length) {
                return;
            }
            ComicCancelRedPointPopItemView comicCancelRedPointPopItemView = comicCancelRedPointPopItemViewArr[i3];
            comicCancelRedPointPopItemView.D = i3;
            comicCancelRedPointPopItemView.setOnClickListener(this);
            Rect rect = new Rect();
            int i17 = i3 * i16;
            rect.left = i17;
            rect.right = i17 + i16;
            this.f99470m[i3] = rect;
            i3++;
        }
    }

    private void f(ComicCancelRedPointPopItemData comicCancelRedPointPopItemData) {
        Activity activity = this.E.get();
        if (activity == null || comicCancelRedPointPopItemData == null) {
            return;
        }
        this.f99465d = true;
        e y16 = new e().x(TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID).w("2").v("20249").u("4").y(comicCancelRedPointPopItemData.comicId);
        ComicHippyBackEventInterceptorProxy comicHippyBackEventInterceptorProxy = ComicHippyBackEventInterceptorProxy.INSTANCE;
        comicHippyBackEventInterceptorProxy.reportData(y16);
        try {
            comicHippyBackEventInterceptorProxy.openReader(activity, comicCancelRedPointPopItemData.comicId);
        } catch (Throwable unused) {
        }
        dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ComicCancelRedPointPopItemData comicCancelRedPointPopItemData;
        switch (view.getId()) {
            case R.id.r_a /* 2030305290 */:
                dismiss();
                return;
            case R.id.r_b /* 2030305291 */:
                comicCancelRedPointPopItemData = this.f99468h[0].C;
                break;
            case R.id.r_c /* 2030305292 */:
                comicCancelRedPointPopItemData = this.f99468h[1].C;
                break;
            case R.id.r_d /* 2030305293 */:
                comicCancelRedPointPopItemData = this.f99468h[2].C;
                break;
            case R.id.r_e /* 2030305294 */:
                comicCancelRedPointPopItemData = this.f99468h[3].C;
                break;
            case R.id.r_f /* 2030305295 */:
                comicCancelRedPointPopItemData = this.f99468h[4].C;
                break;
            default:
                return;
        }
        f(comicCancelRedPointPopItemData);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(new e().x(TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID).w("3").v("39973"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3) {
        int i16 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f99469i;
            if (i16 >= imageViewArr.length) {
                return;
            }
            imageViewArr[i16].setImageResource(i16 == i3 ? R.drawable.f159942in3 : R.drawable.f159941in2);
            i16++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i3) {
        int i16 = 0;
        while (true) {
            Rect[] rectArr = this.f99470m;
            if (i16 >= rectArr.length) {
                return 0;
            }
            Rect rect = rectArr[i16];
            if (rect.left <= i3 && i3 <= rect.right) {
                return i16;
            }
            i16++;
        }
    }

    public void g(List<ComicCancelRedPointPopItemData> list) {
        if (list == null) {
            return;
        }
        this.f99466e = 0;
        for (int i3 = 0; i3 < this.f99468h.length; i3++) {
            if (i3 >= list.size()) {
                this.f99468h[i3].setVisibility(8);
                this.f99469i[i3].setVisibility(8);
                this.f99468h[i3].setData(null);
            } else {
                this.f99466e++;
                this.f99468h[i3].setVisibility(0);
                this.f99469i[i3].setVisibility(0);
                this.f99468h[i3].setData(list.get(i3));
            }
        }
        this.f99467f.scrollTo(0, 0);
        h(0);
    }
}
