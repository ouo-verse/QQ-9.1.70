package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.ui.n;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;
import mqq.app.BaseFragmentActivity;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MultiMembersAudioUI extends LinearLayout implements n {
    long C;
    int D;
    com.tencent.av.utils.y E;
    ArrayList<n.b> F;
    int G;
    boolean H;
    boolean I;
    View.OnClickListener J;

    /* renamed from: d, reason: collision with root package name */
    final int[] f74892d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<Context> f74893e;

    /* renamed from: f, reason: collision with root package name */
    VideoAppInterface f74894f;

    /* renamed from: h, reason: collision with root package name */
    WrapContentViewPager f74895h;

    /* renamed from: i, reason: collision with root package name */
    MemberPagerAdapter f74896i;

    /* renamed from: m, reason: collision with root package name */
    MultiMembersAudioIndicator f74897m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class MemberPagerAdapter extends PagerAdapter {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                if (QLog.isColorLevel()) {
                    QLog.e("MemberPagerAdapter", 2, String.format("view : left[%s], top[%s], right[%s], bottom[%s], oldLeft[%s], oldTop[%s], oldRight[%s], oldBottom[%s]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28)));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class b implements View.OnLayoutChangeListener {
            b() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                if (QLog.isColorLevel()) {
                    QLog.e("MemberPagerAdapter", 2, String.format("container : left[%s], top[%s], right[%s], bottom[%s], oldLeft[%s], oldTop[%s], oldRight[%s], oldBottom[%s]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28)));
                }
            }
        }

        MemberPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            MultiMembersAudioUI multiMembersAudioUI = MultiMembersAudioUI.this;
            int i3 = 0;
            if (multiMembersAudioUI.F == null) {
                return 0;
            }
            int i16 = multiMembersAudioUI.G;
            int i17 = i16 / 8;
            if (i16 % 8 != 0) {
                i3 = 1;
            }
            return i17 + i3;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @TargetApi(11)
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            int d16;
            View findViewById;
            final n.a aVar;
            View view;
            n.b bVar;
            int i16;
            View view2;
            String str;
            com.tencent.av.e T;
            boolean z16;
            MultiMembersAudioUI multiMembersAudioUI;
            Drawable drawable;
            ImageView imageView;
            Drawable drawable2;
            QLog.isColorLevel();
            MultiMembersAudioUI multiMembersAudioUI2 = MultiMembersAudioUI.this;
            if (multiMembersAudioUI2.F != null && multiMembersAudioUI2.G != 0) {
                View inflate = View.inflate(viewGroup.getContext(), R.layout.f168505yg, null);
                boolean z17 = false;
                if (QQAudioHelper.c(0) == 1) {
                    inflate.setBackgroundColor(2130706687);
                    inflate.addOnLayoutChangeListener(new a());
                    if (viewGroup.getTag(R.id.dea) == null) {
                        viewGroup.setBackgroundColor(-553615360);
                        b bVar2 = new b();
                        viewGroup.addOnLayoutChangeListener(bVar2);
                        viewGroup.setTag(R.id.dea, bVar2);
                    }
                }
                int i17 = i3 == getF373114d() - 1 ? MultiMembersAudioUI.this.G - (i3 * 8) : 8;
                MultiMembersAudioUI.this.k(inflate, i17);
                int i18 = 0;
                while (i18 < i17) {
                    final int i19 = (i3 * 8) + i18;
                    MultiMembersAudioUI multiMembersAudioUI3 = MultiMembersAudioUI.this;
                    if (i19 > multiMembersAudioUI3.G - 1) {
                        break;
                    }
                    final n.b bVar3 = multiMembersAudioUI3.F.get(i19);
                    if (bVar3 == null || (d16 = MultiMembersAudioUI.this.d(i17, i18)) == -1 || (findViewById = inflate.findViewById(d16)) == null) {
                        view2 = inflate;
                        z16 = z17;
                    } else {
                        MultiMembersAudioUI.this.q(bVar3, findViewById);
                        n.a h16 = MultiMembersAudioUI.this.h(findViewById);
                        h16.f76110q = bVar3.f76125o;
                        findViewById.setTag(h16);
                        View.OnClickListener onClickListener = MultiMembersAudioUI.this.J;
                        if (onClickListener != null) {
                            findViewById.setOnClickListener(onClickListener);
                        }
                        if (bVar3.f76117g != null && bVar3.f76119i != null && bVar3.f76116f) {
                            aVar = h16;
                            view = findViewById;
                            bVar = bVar3;
                            i16 = i19;
                            view2 = inflate;
                        } else if (bVar3.f76120j == 0) {
                            view2 = inflate;
                            final String valueOf = String.valueOf(bVar3.f76111a);
                            if (MultiMembersAudioUI.this.D == 7 && (T = com.tencent.av.r.h0().T(valueOf)) != null) {
                                MultiMembersAudioUI multiMembersAudioUI4 = MultiMembersAudioUI.this;
                                if (multiMembersAudioUI4.H) {
                                    bVar3.f76117g = T.f73710j;
                                } else {
                                    bVar3.f76117g = T.f73709i;
                                }
                                if (valueOf.equals(multiMembersAudioUI4.f74894f.getCurrentAccountUin()) && bVar3.f76117g != null) {
                                    bVar3.f76117g += MultiMembersAudioUI.this.getResources().getString(R.string.dgr);
                                }
                            }
                            if (bVar3.f76117g == null) {
                                bVar3.f76117g = valueOf;
                            }
                            if (bVar3.f76117g.compareTo(valueOf) != 0) {
                                bVar3.f76116f = true;
                            } else {
                                bVar3.f76116f = z17;
                            }
                            if (MultiMembersAudioUI.this.D == 7) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                Bitmap decodeResource = BitmapFactory.decodeResource(MultiMembersAudioUI.this.getResources(), R.drawable.ddb, options);
                                options.inJustDecodeBounds = z17;
                                try {
                                    decodeResource = BitmapFactory.decodeResource(MultiMembersAudioUI.this.getResources(), R.drawable.ddb, options);
                                } catch (OutOfMemoryError unused) {
                                }
                                bVar3.f76116f = z17;
                                if (decodeResource != null) {
                                    bVar3.f76119i = decodeResource;
                                } else {
                                    bVar3.f76119i = null;
                                    bVar3.f76116f = z17;
                                }
                                aVar = h16;
                                view = findViewById;
                                bVar = bVar3;
                                i16 = i19;
                            } else {
                                view = findViewById;
                                aVar = h16;
                                bVar = bVar3;
                                i16 = i19;
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.MultiMembersAudioUI.MemberPagerAdapter.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (com.tencent.av.r.h0() == null) {
                                            return;
                                        }
                                        bVar3.f76117g = com.tencent.av.r.h0().U(valueOf, String.valueOf(MultiMembersAudioUI.this.C), MultiMembersAudioUI.this.D);
                                        n.b bVar4 = bVar3;
                                        if (bVar4.f76117g == null) {
                                            bVar4.f76117g = valueOf;
                                        }
                                        if (bVar4.f76117g.compareTo(valueOf) != 0) {
                                            bVar3.f76116f = true;
                                        } else {
                                            bVar3.f76116f = false;
                                        }
                                        final Bitmap S = com.tencent.av.r.h0().S(valueOf, String.valueOf(MultiMembersAudioUI.this.C), MultiMembersAudioUI.this.D, false, true);
                                        if (S != null) {
                                            bVar3.f76119i = S;
                                        } else {
                                            n.b bVar5 = bVar3;
                                            bVar5.f76119i = null;
                                            bVar5.f76116f = false;
                                        }
                                        MultiMembersAudioUI multiMembersAudioUI5 = MultiMembersAudioUI.this;
                                        int i26 = multiMembersAudioUI5.D;
                                        if ((i26 == 1 || i26 == 2 || i26 == 7) && i19 == 7 && multiMembersAudioUI5.F.size() > 8) {
                                            return;
                                        }
                                        MultiMembersAudioUI.this.post(new Runnable() { // from class: com.tencent.av.ui.MultiMembersAudioUI.MemberPagerAdapter.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                n.a aVar2 = aVar;
                                                if (aVar2 != null) {
                                                    TextView textView = aVar2.f76101h;
                                                    if (textView != null) {
                                                        textView.setText(bVar3.f76117g);
                                                    }
                                                    TextView textView2 = aVar.f76102i;
                                                    if (textView2 != null) {
                                                        textView2.setVisibility(8);
                                                    }
                                                    ImageView imageView2 = aVar.f76100g;
                                                    if (imageView2 != null) {
                                                        if (S != null) {
                                                            if ((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || MultiMembersAudioUI.this.D == 2) {
                                                                n.a aVar3 = aVar;
                                                                if (!aVar3.f76110q) {
                                                                    aVar3.f76100g.setImageBitmap(BaseImageUtil.drawBitmapCoverLayer(S, true));
                                                                    return;
                                                                }
                                                            }
                                                            aVar.f76100g.setImageBitmap(S);
                                                            return;
                                                        }
                                                        imageView2.setImageResource(R.drawable.f160830com);
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }, 16, null, true);
                            }
                        } else {
                            aVar = h16;
                            view = findViewById;
                            bVar = bVar3;
                            i16 = i19;
                            view2 = inflate;
                            long j3 = bVar.f76111a;
                            AVPhoneUserInfo aVPhoneUserInfo = bVar.f76122l;
                            if (aVPhoneUserInfo == null) {
                                aVPhoneUserInfo = com.tencent.av.r.h0().C(j3, com.tencent.av.n.e().f().f73061o1);
                            }
                            if (aVPhoneUserInfo != null && (str = aVPhoneUserInfo.telInfo.mobile) != null) {
                                bVar.f76117g = str;
                                String P = VideoAppInterface.N().P(aVPhoneUserInfo.telInfo.mobile);
                                if (P != null) {
                                    bVar.f76118h = com.tencent.mobileqq.utils.ac.L(P);
                                    bVar.f76117g = P;
                                } else {
                                    bVar.f76118h = null;
                                    bVar.f76117g = com.tencent.av.utils.ae.g(aVPhoneUserInfo.telInfo.mobile, 4);
                                }
                            } else {
                                if (aVPhoneUserInfo != null && QLog.isColorLevel()) {
                                    QLog.d("MemberPagerAdapter", 2, "getView --> can not get Open Id. PhoneInfo = " + aVPhoneUserInfo.toString());
                                }
                                bVar.f76118h = null;
                                bVar.f76117g = MultiMembersAudioUI.this.getResources().getString(R.string.box);
                            }
                            bVar.f76119i = ((BitmapDrawable) MultiMembersAudioUI.this.getResources().getDrawable(R.drawable.dbo)).getBitmap();
                            bVar.f76116f = true;
                        }
                        MultiMembersAudioUI multiMembersAudioUI5 = MultiMembersAudioUI.this;
                        int i26 = multiMembersAudioUI5.D;
                        if ((i26 == 1 || i26 == 2 || i26 == 7) && i16 == 7 && multiMembersAudioUI5.F.size() > 8) {
                            n.a aVar2 = aVar;
                            aVar2.f76105l = false;
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setShape(1);
                            gradientDrawable.setColor(Color.parseColor("#4C000000"));
                            aVar2.f76100g.setImageDrawable(gradientDrawable);
                            View view3 = view;
                            aVar2.f76102i = (TextView) view3.findViewById(R.id.g8m);
                            aVar2.f76102i.setText("" + ((MultiMembersAudioUI.this.F.size() - 8) + 1) + Marker.ANY_NON_NULL_MARKER);
                            aVar2.f76102i.setTextColor(-1);
                            aVar2.f76102i.setVisibility(0);
                            aVar2.f76101h.setText("");
                            aVar2.f76107n = true;
                            view3.setContentDescription(MultiMembersAudioUI.this.getResources().getString(R.string.bow));
                            z16 = false;
                        } else {
                            n.a aVar3 = aVar;
                            if (MultiMembersAudioUI.this.D == 7) {
                                int i27 = bVar.f76124n;
                                aVar3.f76108o = i27;
                                if (i27 == 1) {
                                    aVar3.f76098e.setImageResource(R.drawable.d9m);
                                } else if (i27 == 2) {
                                    aVar3.f76098e.setImageResource(R.drawable.d9i);
                                } else if (i27 == 4) {
                                    aVar3.f76098e.setImageResource(R.drawable.d9k);
                                }
                                if (aVar3.f76108o != 0) {
                                    aVar3.f76098e.setVisibility(0);
                                }
                                if (String.valueOf(bVar.f76111a).endsWith(MultiMembersAudioUI.this.f74894f.getCurrentAccountUin())) {
                                    aVar3.f76101h.setTextColor(MultiMembersAudioUI.this.getResources().getColor(R.color.f156883ed));
                                } else {
                                    aVar3.f76101h.setTextColor(MultiMembersAudioUI.this.getResources().getColor(R.color.f158017al3));
                                }
                            }
                            aVar3.f76105l = true;
                            long j16 = bVar.f76111a;
                            aVar3.f76094a = j16;
                            String valueOf2 = String.valueOf(j16);
                            String str2 = bVar.f76117g;
                            if (str2 != null) {
                                aVar3.f76101h.setText(str2);
                                if (com.tencent.av.n.e().f().S0 == 7 && !aVar3.f76101h.isShown() && !bVar.f76117g.equals(valueOf2)) {
                                    aVar3.f76101h.setVisibility(0);
                                }
                            } else {
                                if (com.tencent.av.n.e().f().S0 == 7 && aVar3.f76101h.isShown()) {
                                    aVar3.f76101h.setVisibility(4);
                                }
                                aVar3.f76101h.setText(String.valueOf(bVar.f76111a));
                            }
                            if (bVar.f76119i != null) {
                                if (bVar.f76120j != 0 && bVar.f76118h != null) {
                                    aVar3.f76102i.setVisibility(0);
                                    aVar3.f76102i.setText(bVar.f76118h);
                                    aVar3.f76100g.setImageBitmap(((BitmapDrawable) MultiMembersAudioUI.this.getResources().getDrawable(R.drawable.day)).getBitmap());
                                } else {
                                    aVar3.f76102i.setVisibility(8);
                                    aVar3.f76100g.setImageBitmap(bVar.f76119i);
                                }
                            } else {
                                aVar3.f76102i.setVisibility(8);
                                aVar3.f76100g.setImageResource(R.drawable.f160830com);
                            }
                            if ((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || com.tencent.av.n.e().f().S0 == 2 || com.tencent.av.n.e().f().S0 == 7) {
                                if (bVar.f76123m) {
                                    if (aVar3.f76106m.getVisibility() != 0) {
                                        aVar3.f76106m.setVisibility(0);
                                    }
                                    if (aVar3.f76096c.getVisibility() == 0) {
                                        aVar3.f76096c.setVisibility(8);
                                        MultiMembersAudioUI.this.r(aVar3.f76097d, 8);
                                    }
                                    bVar.f76112b = false;
                                } else if (aVar3.f76106m.getVisibility() == 0) {
                                    aVar3.f76106m.setVisibility(8);
                                }
                            }
                            boolean z18 = bVar.f76112b;
                            aVar3.f76104k = z18;
                            if (z18) {
                                aVar3.f76096c.setVisibility(0);
                                MultiMembersAudioUI.this.r(aVar3.f76097d, 0);
                            } else {
                                aVar3.f76096c.setVisibility(8);
                                MultiMembersAudioUI.this.r(aVar3.f76097d, 8);
                            }
                            int i28 = bVar.f76114d;
                            if (i28 == 2) {
                                aVar3.f76095b = 5;
                            } else if (bVar.f76115e) {
                                aVar3.f76095b = 3;
                            } else if (i28 == 1) {
                                aVar3.f76095b = 2;
                            } else if (bVar.f76113c) {
                                aVar3.f76095b = 1;
                            } else {
                                z16 = false;
                                aVar3.f76095b = 0;
                                multiMembersAudioUI = MultiMembersAudioUI.this;
                                if (multiMembersAudioUI.I && ThemeUtil.isInNightMode(multiMembersAudioUI.f74894f) && (imageView = aVar3.f76100g) != null && (drawable2 = imageView.getDrawable()) != null && (drawable2 instanceof BitmapDrawable)) {
                                    aVar3.f76100g.setImageBitmap(ba.drawBitmapCoverLayer(((BitmapDrawable) drawable2).getBitmap(), "#4C000000", true));
                                }
                                if (aVar3.f76100g != null && (((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || MultiMembersAudioUI.this.D == 2) && !aVar3.f76110q && (drawable = aVar3.f76100g.getDrawable()) != null && (drawable instanceof BitmapDrawable))) {
                                    aVar3.f76100g.setImageBitmap(BaseImageUtil.drawBitmapCoverLayer(((BitmapDrawable) drawable).getBitmap(), true));
                                }
                                i18++;
                                z17 = z16;
                                inflate = view2;
                            }
                            z16 = false;
                            multiMembersAudioUI = MultiMembersAudioUI.this;
                            if (multiMembersAudioUI.I) {
                                aVar3.f76100g.setImageBitmap(ba.drawBitmapCoverLayer(((BitmapDrawable) drawable2).getBitmap(), "#4C000000", true));
                            }
                            if (aVar3.f76100g != null) {
                                aVar3.f76100g.setImageBitmap(BaseImageUtil.drawBitmapCoverLayer(((BitmapDrawable) drawable).getBitmap(), true));
                            }
                            i18++;
                            z17 = z16;
                            inflate = view2;
                        }
                    }
                    i18++;
                    z17 = z16;
                    inflate = view2;
                }
                View view4 = inflate;
                view4.setTag("MemberPagerAdapter_" + i3);
                viewGroup.addView(view4);
                return view4;
            }
            QLog.isColorLevel();
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            MultiMembersAudioUI.this.f74894f.k0(new Object[]{110, Long.valueOf(com.tencent.av.utils.e.d())});
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int f16;
            MultiMembersAudioUI multiMembersAudioUI;
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MultiMembersAudioUI.this.E != null) {
                n.a aVar = (n.a) view.getTag();
                if (aVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiMembersAudioUI", 2, "onItemClick-->holder is null");
                    }
                } else {
                    if (aVar.f76107n) {
                        f16 = 7;
                    } else {
                        f16 = MultiMembersAudioUI.this.f(aVar.f76094a);
                    }
                    int i16 = f16;
                    if (MultiMembersAudioUI.this.F.size() > 8 && ((i3 = (multiMembersAudioUI = MultiMembersAudioUI.this).D) == 1 || i3 == 2)) {
                        multiMembersAudioUI.E.b(aVar.f76094a, aVar.f76095b, i16, true);
                    } else {
                        MultiMembersAudioUI.this.E.b(aVar.f76094a, aVar.f76095b, i16, false);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @TargetApi(9)
    public MultiMembersAudioUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Activity activity;
        this.f74892d = new int[]{R.id.eoc, R.id.eod, R.id.eoe, R.id.eof, R.id.eog, R.id.eoh, R.id.eoi, R.id.eoj};
        this.f74894f = null;
        this.C = 0L;
        this.D = 0;
        this.E = null;
        this.F = new ArrayList<>();
        this.G = 0;
        this.H = false;
        this.I = false;
        this.J = new b();
        super.setOrientation(1);
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f74893e = weakReference;
        if (weakReference.get() instanceof BaseActivity) {
            activity = (BaseActivity) this.f74893e.get();
            this.f74894f = (VideoAppInterface) ((BaseActivity) this.f74893e.get()).getAppRuntime();
        } else if (this.f74893e.get() instanceof BaseFragmentActivity) {
            activity = (BaseFragmentActivity) this.f74893e.get();
            this.f74894f = (VideoAppInterface) ((BaseFragmentActivity) this.f74893e.get()).getAppRuntime();
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get activity");
                return;
            }
            return;
        }
        if (this.f74894f == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get AppRuntime");
            }
            activity.finish();
            return;
        }
        if (com.tencent.av.r.h0() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get videoControl");
            }
            activity.finish();
            return;
        }
        this.f74895h = new WrapContentViewPager(super.getContext());
        this.f74895h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f74895h.setFocusable(false);
        this.f74895h.setFocusableInTouchMode(false);
        this.f74895h.setOnTouchListener(new a());
        MemberPagerAdapter memberPagerAdapter = new MemberPagerAdapter();
        this.f74896i = memberPagerAdapter;
        this.f74895h.setAdapter(memberPagerAdapter);
        super.addView(this.f74895h);
        this.f74897m = new MultiMembersAudioIndicator(super.getContext());
        this.f74897m.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f74897m.setViewPager(this.f74895h);
        super.addView(this.f74897m);
    }

    private void c(RelativeLayout.LayoutParams layoutParams) {
        if (this.I) {
            layoutParams.addRule(15);
        } else {
            layoutParams.removeRule(15);
        }
    }

    private void e(final n.b bVar, final View view) {
        if (bVar != null && com.tencent.av.r.h0() != null && this.f74894f != null && view != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.MultiMembersAudioUI.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str;
                    if (bVar != null && com.tencent.av.r.h0() != null && MultiMembersAudioUI.this.f74894f != null && view != null) {
                        String str2 = com.tencent.av.r.h0().U(String.valueOf(bVar.f76111a), String.valueOf(MultiMembersAudioUI.this.C), MultiMembersAudioUI.this.D) + HardCodeUtil.qqStr(R.string.f172212od0);
                        if (bVar.f76123m) {
                            str = str2 + HardCodeUtil.qqStr(R.string.z6r);
                        } else {
                            str = str2 + HardCodeUtil.qqStr(R.string.f170485z74);
                        }
                        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.av.ui.MultiMembersAudioUI.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                View view2 = view;
                                if (view2 != null) {
                                    view2.setContentDescription(str);
                                }
                            }
                        });
                    }
                }
            }, 16, null, false);
        }
    }

    private boolean j(int i3) {
        if (i3 < 8 && (this.F.size() != 8 || i3 != 7)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MultiMembersAudioUI", 2, "[random room owner] member is null index=" + i3 + ",uin=");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(n.b bVar, View view) {
        VideoAppInterface videoAppInterface;
        String str;
        String str2;
        if (bVar != null && com.tencent.av.r.h0() != null && (videoAppInterface = this.f74894f) != null) {
            if (bVar.f76111a == videoAppInterface.getLongAccountUin()) {
                str = "" + HardCodeUtil.qqStr(R.string.cfm);
            } else if (!TextUtils.isEmpty(bVar.f76117g)) {
                str = "" + bVar.f76117g;
            } else {
                e(bVar, view);
                return;
            }
            String str3 = str + HardCodeUtil.qqStr(R.string.f172212od0);
            if (bVar.f76123m) {
                str2 = str3 + HardCodeUtil.qqStr(R.string.z6r);
            } else {
                str2 = str3 + HardCodeUtil.qqStr(R.string.f170485z74);
            }
            if (view != null) {
                view.setContentDescription(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ImageView imageView, int i3) {
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    int d(int i3, int i16) {
        if (i16 > i3 - 1) {
            return -1;
        }
        switch (i3) {
            case 1:
                return this.f74892d[0];
            case 2:
                return this.f74892d[i16];
            case 3:
                return this.f74892d[i16];
            case 4:
                if (i16 < 2) {
                    return this.f74892d[i16];
                }
                return this.f74892d[i16 + 2];
            case 5:
                if (i16 < 3) {
                    return this.f74892d[i16];
                }
                return this.f74892d[i16 + 1];
            case 6:
                if (i16 < 3) {
                    return this.f74892d[i16];
                }
                return this.f74892d[i16 + 1];
            case 7:
            case 8:
                return this.f74892d[i16];
            default:
                return -1;
        }
    }

    int f(long j3) {
        if (this.F == null) {
            return -1;
        }
        for (int i3 = 0; i3 < this.G; i3++) {
            if (this.F.get(i3).f76111a == j3) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    View g(int i3) {
        MemberPagerAdapter memberPagerAdapter;
        int i16;
        int i17;
        String str = "MultiMembersAudioUI";
        View view = null;
        if (this.F == null || j(i3) || i3 < 0 || i3 >= this.G || this.f74895h == null || (memberPagerAdapter = this.f74896i) == null) {
            return null;
        }
        int i18 = i3 + 1;
        int i19 = i18 / 8;
        if (i18 % 8 == 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        int i26 = (i19 + i16) - 1;
        if (i26 == memberPagerAdapter.getF373114d() - 1) {
            i17 = this.G - (i26 * 8);
        } else {
            i17 = 8;
        }
        int i27 = (i18 - (i26 * 8)) - 1;
        try {
            View findViewWithTag = this.f74895h.findViewWithTag("MemberPagerAdapter_" + i26);
            if (findViewWithTag != null) {
                View findViewById = findViewWithTag.findViewById(d(i17, i27));
                try {
                    n.a aVar = (n.a) findViewById.getTag();
                    if (aVar != null) {
                        boolean z16 = aVar.f76107n;
                        if (z16 == 0) {
                            view = findViewById;
                            str = z16;
                        }
                    }
                    return null;
                } catch (Exception e16) {
                    e = e16;
                    view = findViewById;
                    if (QLog.isColorLevel()) {
                        QLog.e(str, 2, "[random room owner] " + e.getMessage());
                    }
                    return view;
                }
            }
            str = str;
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersAudioUI", 2, "[random room owner] page is null");
                str = str;
            }
        } catch (Exception e17) {
            e = e17;
        }
        return view;
    }

    n.a h(View view) {
        n.a aVar = new n.a();
        aVar.f76100g = (ImageView) view.findViewById(R.id.g8k);
        aVar.f76101h = (TextView) view.findViewById(R.id.f166570g90);
        if (com.tencent.av.n.e().f().S0 == 7) {
            aVar.f76101h.setVisibility(4);
        }
        if (this.I) {
            boolean isInNightMode = ThemeUtil.isInNightMode(this.f74894f);
            if (isInNightMode) {
                aVar.f76101h.setTextColor(Color.parseColor("#A8A8A8"));
            } else {
                aVar.f76101h.setTextColor(Color.parseColor("#FFFFFF"));
            }
            if (isInNightMode) {
                aVar.f76097d = (ImageView) view.findViewById(R.id.m0z);
                int f16 = BaseAIOUtils.f(15.0f, getResources());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(Color.parseColor("#4C000000"));
                gradientDrawable.setSize(f16, f16);
                aVar.f76097d.setBackgroundDrawable(gradientDrawable);
            }
        }
        aVar.f76096c = (ImageView) view.findViewById(R.id.f166572g92);
        aVar.f76098e = (ImageView) view.findViewById(R.id.g8q);
        aVar.f76102i = (TextView) view.findViewById(R.id.g8m);
        aVar.f76106m = (ImageView) view.findViewById(R.id.g8z);
        aVar.f76103j = (RelativeLayout) view.findViewById(R.id.gba);
        aVar.f76109p = (ImageView) view.findViewById(R.id.g8l);
        return aVar;
    }

    public void i(long j3, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("MultiMembersAudioUI", 2, "initMVMLayout relationUin: " + j3 + ", relationType: " + i3 + ", bEnterPage: " + z16);
        }
        this.C = j3;
        this.D = i3;
    }

    void k(View view, int i3) {
        if (view == null) {
            return;
        }
        int dimensionPixelSize = this.f74893e.get().getResources().getDimensionPixelSize(R.dimen.f159358a74) + ((int) (ba.getScreenWidth(this.f74893e.get()) * 0.045f));
        View findViewById = view.findViewById(R.id.b2g);
        View findViewById2 = view.findViewById(R.id.b2h);
        View findViewById3 = view.findViewById(R.id.eoc);
        View findViewById4 = view.findViewById(R.id.eod);
        View findViewById5 = view.findViewById(R.id.eoe);
        View findViewById6 = view.findViewById(R.id.eof);
        View findViewById7 = view.findViewById(R.id.eog);
        View findViewById8 = view.findViewById(R.id.eoh);
        View findViewById9 = view.findViewById(R.id.eoi);
        View findViewById10 = view.findViewById(R.id.eoj);
        if (findViewById != null && findViewById2 != null && findViewById3 != null && findViewById4 != null && findViewById5 != null && findViewById6 != null && findViewById7 != null && findViewById8 != null && findViewById9 != null && findViewById10 != null) {
            findViewById3.getLayoutParams().width = dimensionPixelSize;
            findViewById3.requestLayout();
            findViewById4.getLayoutParams().width = dimensionPixelSize;
            findViewById4.requestLayout();
            findViewById5.getLayoutParams().width = dimensionPixelSize;
            findViewById5.requestLayout();
            findViewById6.getLayoutParams().width = dimensionPixelSize;
            findViewById6.requestLayout();
            findViewById7.getLayoutParams().width = dimensionPixelSize;
            findViewById7.requestLayout();
            findViewById8.getLayoutParams().width = dimensionPixelSize;
            findViewById8.requestLayout();
            findViewById9.getLayoutParams().width = dimensionPixelSize;
            findViewById9.requestLayout();
            findViewById10.getLayoutParams().width = dimensionPixelSize;
            findViewById10.requestLayout();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            switch (i3) {
                case 1:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(8);
                    findViewById5.setVisibility(8);
                    findViewById6.setVisibility(8);
                    c(layoutParams);
                    layoutParams.addRule(10, 0);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(8);
                    return;
                case 2:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(8);
                    findViewById6.setVisibility(8);
                    c(layoutParams);
                    layoutParams.addRule(10, 0);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(8);
                    return;
                case 3:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(0);
                    findViewById6.setVisibility(8);
                    c(layoutParams);
                    layoutParams.addRule(10, 0);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(8);
                    return;
                case 4:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(8);
                    findViewById6.setVisibility(8);
                    c(layoutParams);
                    layoutParams.addRule(10);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(0);
                    findViewById7.setVisibility(0);
                    findViewById8.setVisibility(0);
                    findViewById9.setVisibility(8);
                    findViewById10.setVisibility(8);
                    return;
                case 5:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(0);
                    findViewById6.setVisibility(8);
                    c(layoutParams);
                    layoutParams.addRule(10);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(0);
                    findViewById7.setVisibility(0);
                    findViewById8.setVisibility(0);
                    findViewById9.setVisibility(8);
                    findViewById10.setVisibility(8);
                    return;
                case 6:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(0);
                    findViewById6.setVisibility(8);
                    c(layoutParams);
                    layoutParams.addRule(10);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(0);
                    findViewById7.setVisibility(0);
                    findViewById8.setVisibility(0);
                    findViewById9.setVisibility(0);
                    findViewById10.setVisibility(8);
                    return;
                case 7:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(0);
                    findViewById6.setVisibility(0);
                    c(layoutParams);
                    layoutParams.addRule(10);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(0);
                    findViewById7.setVisibility(0);
                    findViewById8.setVisibility(0);
                    findViewById9.setVisibility(0);
                    findViewById10.setVisibility(8);
                    return;
                case 8:
                    findViewById.setVisibility(0);
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById5.setVisibility(0);
                    findViewById6.setVisibility(0);
                    c(layoutParams);
                    layoutParams.addRule(10);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById2.setVisibility(0);
                    findViewById7.setVisibility(0);
                    findViewById8.setVisibility(0);
                    findViewById9.setVisibility(0);
                    findViewById10.setVisibility(0);
                    return;
                default:
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(8);
                    return;
            }
        }
    }

    public void l(long j3, boolean z16) {
        int f16 = f(j3);
        if (f16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.iAsync("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + j3 + ",bSpeak=" + z16);
                return;
            }
            return;
        }
        n.b bVar = this.F.get(f16);
        if (bVar.f76112b == z16) {
            return;
        }
        bVar.f76112b = z16;
        View g16 = g(f16);
        if (g16 == null) {
            return;
        }
        if (g16.getTag() == null) {
            if (QLog.isColorLevel()) {
                QLog.iAsync("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + f16 + ",uin=" + j3 + ",isSpeak=" + z16);
                return;
            }
            return;
        }
        n.a aVar = (n.a) g16.getTag();
        if (aVar == null) {
            return;
        }
        if ((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || com.tencent.av.n.e().f().S0 == 2) {
            if (bVar.f76123m) {
                if (aVar.f76106m.getVisibility() != 0) {
                    aVar.f76106m.setVisibility(0);
                }
                if (aVar.f76096c.getVisibility() == 0) {
                    aVar.f76096c.setVisibility(8);
                    r(aVar.f76097d, 8);
                }
                bVar.f76112b = false;
                z16 = false;
            } else if (aVar.f76106m.getVisibility() == 0) {
                aVar.f76106m.setVisibility(8);
            }
        }
        if (z16 && aVar.f76105l) {
            if (aVar.f76096c.getVisibility() != 0) {
                aVar.f76096c.setVisibility(0);
                r(aVar.f76097d, 0);
            }
        } else if (aVar.f76096c.getVisibility() == 0) {
            aVar.f76096c.setVisibility(8);
            r(aVar.f76097d, 8);
        }
        if (this.D == 7) {
            int i3 = bVar.f76124n;
            aVar.f76108o = i3;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        aVar.f76098e.setImageResource(R.drawable.d9k);
                    }
                } else {
                    aVar.f76098e.setImageResource(R.drawable.d9i);
                }
            } else {
                aVar.f76098e.setImageResource(R.drawable.d9m);
            }
            if (aVar.f76108o != 0) {
                aVar.f76098e.setVisibility(0);
            }
        }
    }

    public void m(ArrayList<com.tencent.av.e> arrayList) {
        n(arrayList);
        this.f74897m.b();
        this.f74896i.notifyDataSetChanged();
    }

    void n(ArrayList<com.tencent.av.e> arrayList) {
        int i3;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshDataSource, friends[");
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            sb5.append("], mInfoList[");
            sb5.append(this.F.size());
            sb5.append("]");
            QLog.iAsync("MultiMembersAudioUI", 1, sb5.toString());
        }
        this.F.clear();
        if (arrayList != null) {
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                com.tencent.av.e eVar = arrayList.get(i16);
                n.b bVar = new n.b();
                bVar.f76111a = eVar.f73701a;
                bVar.f76114d = eVar.f73706f;
                bVar.f76113c = eVar.f73705e;
                bVar.f76112b = eVar.f73703c;
                bVar.f76115e = eVar.f73707g;
                bVar.f76120j = eVar.f73715o;
                bVar.f76122l = eVar.f73716p;
                bVar.f76123m = eVar.f73717q;
                bVar.f76124n = eVar.f73723w;
                bVar.f76125o = eVar.f73724x;
                this.F.add(bVar);
            }
        }
        this.G = this.F.size();
        int i17 = this.D;
        if ((i17 == 1 || i17 == 2) && this.F.size() > 8) {
            this.G = 8;
        }
    }

    public void o() {
        if (this.F == null) {
            return;
        }
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= this.G) {
                break;
            }
            if (!this.F.get(i3).f76116f) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (z16) {
            this.f74896i.notifyDataSetChanged();
        }
    }

    public void p(long j3, int i3, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.iAsync("MultiMembersAudioUI", 2, "refreshMemMicState. uin = " + j3 + ", accType = " + i3 + ", pstnStatus = " + i16 + ", isMicOff = " + z16);
        }
        int f16 = f(j3);
        if (f16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.iAsync("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + j3 + ",isMicOff=" + z16);
                return;
            }
            return;
        }
        n.b bVar = this.F.get(f16);
        if (bVar.f76123m == z16) {
            return;
        }
        bVar.f76123m = z16;
        View g16 = g(f16);
        if (g16 == null) {
            return;
        }
        if (g16.getTag() == null) {
            if (QLog.isColorLevel()) {
                QLog.iAsync("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + f16 + ",uin=" + j3 + ",isMicOff=" + z16);
                return;
            }
            return;
        }
        n.a aVar = (n.a) g16.getTag();
        if (aVar == null) {
            return;
        }
        if (z16) {
            if (aVar.f76096c.getVisibility() == 0) {
                aVar.f76096c.setVisibility(8);
                r(aVar.f76097d, 8);
            }
            if (aVar.f76106m.getVisibility() != 0) {
                aVar.f76106m.setVisibility(0);
            }
        } else {
            if (aVar.f76106m.getVisibility() == 0) {
                aVar.f76106m.setVisibility(8);
            }
            if (bVar.f76112b) {
                aVar.f76096c.setVisibility(0);
                r(aVar.f76097d, 0);
            } else {
                aVar.f76096c.setVisibility(8);
                r(aVar.f76097d, 8);
            }
        }
        q(bVar, g16);
    }

    public void setIsEnterpage(boolean z16) {
        this.I = z16;
    }

    public void setOnItemClickListener(com.tencent.av.utils.y yVar) {
        this.E = yVar;
    }
}
