package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import java.util.List;
import lo2.y;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m extends com.tencent.mobileqq.search.business.net.view.c {
    public URLImageView M;
    public TextView N;
    public LinearLayout P;
    public TextView Q;
    public ArrayList<a> R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public SquareImageView f285143a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f285144b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f285145c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f285146d;

        /* renamed from: e, reason: collision with root package name */
        public LinearLayout f285147e;

        /* renamed from: f, reason: collision with root package name */
        public FrameLayout f285148f;

        /* renamed from: g, reason: collision with root package name */
        public SquareImageView f285149g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f285150h;

        /* renamed from: i, reason: collision with root package name */
        public int f285151i;

        /* renamed from: j, reason: collision with root package name */
        public Context f285152j;

        /* renamed from: k, reason: collision with root package name */
        public View f285153k;

        public a(Context context) {
            this.f285152j = context;
            a();
        }

        public void a() {
            View inflate = LayoutInflater.from(this.f285152j).inflate(R.layout.a0b, (ViewGroup) m.this.P, false);
            this.f285153k = inflate;
            this.f285143a = (SquareImageView) inflate.findViewById(R.id.a36);
            this.f285144b = (TextView) this.f285153k.findViewById(R.id.f5e);
            this.f285145c = (TextView) this.f285153k.findViewById(R.id.fxv);
            this.f285146d = (TextView) this.f285153k.findViewById(R.id.bgt);
            this.f285147e = (LinearLayout) this.f285153k.findViewById(R.id.fsi);
            FrameLayout frameLayout = (FrameLayout) this.f285153k.findViewById(R.id.iwn);
            this.f285148f = frameLayout;
            this.f285149g = (SquareImageView) frameLayout.findViewById(R.id.de8);
            this.f285150h = (ImageView) this.f285148f.findViewById(R.id.f166006e23);
            this.f285151i = this.f285147e.getChildCount();
        }
    }

    public m(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        this.R = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        View j3 = j(this.E);
        this.M = (URLImageView) j3.findViewById(R.id.f164500zw);
        this.N = (TextView) j3.findViewById(R.id.d3k);
        this.P = (LinearLayout) j3.findViewById(R.id.f164346sj);
        this.Q = (TextView) j3.findViewById(R.id.f164348sl);
    }

    public void p(y yVar) {
        int i3;
        this.R.clear();
        this.P.removeAllViews();
        List<lo2.a> list = yVar.f415313e0;
        if (list != null && list.size() != 0) {
            Context context = this.P.getContext();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            boolean z16 = false;
            for (int i16 = 0; i16 < yVar.f415313e0.size(); i16++) {
                lo2.a aVar = yVar.f415313e0.get(i16);
                a aVar2 = new a(context);
                if (!TextUtils.isEmpty(aVar.f415092a)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mFailedDrawable = colorDrawable;
                    obtain.mLoadingDrawable = colorDrawable;
                    obtain.mRequestWidth = x.c(context, 18.0f);
                    obtain.mRequestHeight = x.c(context, 18.0f);
                    obtain.mMemoryCacheKeySuffix = "leftIcon";
                    URLDrawable drawable = URLDrawable.getDrawable(aVar.f415092a, obtain);
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                    aVar2.f285143a.setImageDrawable(drawable);
                    if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                        drawable.restartDownload();
                    }
                    aVar2.f285143a.setVisibility(z16 ? 1 : 0);
                } else {
                    aVar2.f285143a.setVisibility(8);
                }
                if (!TextUtils.isEmpty(aVar.f415093b)) {
                    aVar2.f285144b.setText(aVar.f415093b);
                    aVar2.f285144b.setVisibility(z16 ? 1 : 0);
                } else {
                    aVar2.f285144b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(aVar.f415094c)) {
                    aVar2.f285145c.setText(aVar.f415094c);
                    aVar2.f285145c.setVisibility(z16 ? 1 : 0);
                } else {
                    aVar2.f285145c.setVisibility(8);
                }
                if (!TextUtils.isEmpty(aVar.f415095d)) {
                    aVar2.f285146d.setVisibility(z16 ? 1 : 0);
                    List<lo2.f> list2 = aVar.f415097f;
                    if (list2 != null && list2.size() != 0) {
                        aVar2.f285146d.setMaxLines(2);
                    } else {
                        aVar2.f285146d.setMaxLines(3);
                    }
                    aVar2.f285146d.setText(aVar.f415095d);
                } else {
                    aVar2.f285146d.setVisibility(8);
                }
                if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), z16, null)) {
                    aVar2.f285146d.setTextColor(Color.parseColor("#737373"));
                    aVar2.f285144b.setTextColor(Color.parseColor("#4A4A4A"));
                    aVar2.f285145c.setTextColor(Color.parseColor("#4A4A4A"));
                    aVar2.f285153k.setBackgroundResource(R.drawable.f161408wq);
                } else {
                    aVar2.f285146d.setTextColor(Color.parseColor("#262626"));
                    aVar2.f285144b.setTextColor(Color.parseColor("#737373"));
                    aVar2.f285145c.setTextColor(Color.parseColor("#737373"));
                    aVar2.f285153k.setBackgroundResource(R.drawable.f161405wn);
                }
                List<lo2.f> list3 = aVar.f415097f;
                if (list3 != null && list3.size() != 0) {
                    if (aVar.f415097f.size() == 1) {
                        aVar2.f285148f.setVisibility(z16 ? 1 : 0);
                        aVar2.f285147e.setVisibility(8);
                        SquareImageView squareImageView = aVar2.f285149g;
                        Resources resources = context.getResources();
                        int i17 = resources.getDisplayMetrics().widthPixels;
                        float dimension = resources.getDimension(R.dimen.ajj);
                        float dimension2 = resources.getDimension(R.dimen.ajj);
                        int c16 = x.c(context, 2.0f);
                        int childCount = ((int) (((i17 - dimension) - dimension2) - ((r12 - 1) * c16))) / aVar2.f285147e.getChildCount();
                        squareImageView.setLayoutParams(new FrameLayout.LayoutParams(childCount, childCount));
                        lo2.f fVar = aVar.f415097f.get(z16 ? 1 : 0);
                        String str = fVar.f415209a;
                        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                        obtain2.mFailedDrawable = colorDrawable;
                        obtain2.mLoadingDrawable = colorDrawable;
                        obtain2.mRequestWidth = childCount;
                        obtain2.mRequestHeight = childCount;
                        obtain2.mPlayGifImage = true;
                        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain2);
                        squareImageView.setImageDrawable(drawable2);
                        if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                            drawable2.restartDownload();
                        }
                        if (fVar.f415210b == 2) {
                            aVar2.f285150h.setVisibility(z16 ? 1 : 0);
                        } else {
                            aVar2.f285150h.setVisibility(8);
                        }
                    } else {
                        aVar2.f285148f.setVisibility(8);
                        aVar2.f285147e.setVisibility(z16 ? 1 : 0);
                        int childCount2 = aVar2.f285147e.getChildCount();
                        int i18 = z16 ? 1 : 0;
                        while (i18 < aVar.f415097f.size() && i18 < childCount2) {
                            View childAt = aVar2.f285147e.getChildAt(i18);
                            childAt.setVisibility(z16 ? 1 : 0);
                            SquareImageView squareImageView2 = (SquareImageView) childAt.findViewById(R.id.de8);
                            ImageView imageView = (ImageView) childAt.findViewById(R.id.f166006e23);
                            lo2.f fVar2 = aVar.f415097f.get(i18);
                            String str2 = fVar2.f415209a;
                            URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
                            obtain3.mRequestHeight = 200;
                            obtain3.mRequestWidth = 200;
                            obtain3.mFailedDrawable = colorDrawable;
                            obtain3.mLoadingDrawable = colorDrawable;
                            obtain3.mPlayGifImage = true;
                            URLDrawable drawable3 = URLDrawable.getDrawable(str2, obtain3);
                            squareImageView2.setImageDrawable(drawable3);
                            if (drawable3.getStatus() != 1 && drawable3.getStatus() != 0) {
                                drawable3.restartDownload();
                            }
                            z16 = false;
                            squareImageView2.setVisibility(0);
                            if (fVar2.f415210b == 2) {
                                imageView.setVisibility(0);
                                i3 = 8;
                            } else {
                                i3 = 8;
                                imageView.setVisibility(8);
                            }
                            if (i18 == childCount2 - 1 && aVar.f415096e > childCount2) {
                                imageView.setVisibility(i3);
                                squareImageView2.setFilterColor(Color.parseColor("#66000000"));
                                int i19 = aVar.f415096e - childCount2;
                                if (i19 > 99) {
                                    i19 = 99;
                                }
                                squareImageView2.setFilterText(Marker.ANY_NON_NULL_MARKER + i19);
                                squareImageView2.setFilterTextSize(x.c(squareImageView2.getContext(), 20.0f));
                            } else {
                                squareImageView2.setFilterColor(-1);
                                squareImageView2.setFilterText("");
                            }
                            i18++;
                        }
                        while (i18 < childCount2) {
                            aVar2.f285147e.getChildAt(i18).setVisibility(4);
                            i18++;
                        }
                    }
                } else {
                    aVar2.f285148f.setVisibility(8);
                    aVar2.f285147e.setVisibility(8);
                }
                this.P.addView(aVar2.f285153k);
                this.R.add(aVar2);
                if (i16 != yVar.f415313e0.size() - 1) {
                    View view = new View(context);
                    view.setBackgroundResource(R.drawable.f160540jm);
                    view.setLayoutParams(new ViewGroup.LayoutParams(-1, x.c(context, 6.0f)));
                    this.P.addView(view);
                }
            }
        }
    }
}
