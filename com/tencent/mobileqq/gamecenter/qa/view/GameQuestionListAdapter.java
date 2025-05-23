package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gp3.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQuestionListAdapter extends BaseAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.mobileqq.gamecenter.qa.model.b> f212827d;

    /* renamed from: e, reason: collision with root package name */
    private vd1.b f212828e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<GameQAUI> f212829f;

    /* renamed from: h, reason: collision with root package name */
    private fe1.c f212830h = new fe1.c();

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<QBaseActivity> f212831i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f212840a;

        /* renamed from: b, reason: collision with root package name */
        public int f212841b;

        /* renamed from: c, reason: collision with root package name */
        public String f212842c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f212843d;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f212844a;

        /* renamed from: b, reason: collision with root package name */
        TextView f212845b;

        /* renamed from: c, reason: collision with root package name */
        TextView f212846c;

        /* renamed from: d, reason: collision with root package name */
        TextView f212847d;

        /* renamed from: e, reason: collision with root package name */
        TextView f212848e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f212849f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f212850g;

        /* renamed from: h, reason: collision with root package name */
        ViewGroup[] f212851h;

        /* renamed from: i, reason: collision with root package name */
        C11728RoundRectUrlImageView[] f212852i;

        /* renamed from: j, reason: collision with root package name */
        ImageView[] f212853j;

        /* renamed from: k, reason: collision with root package name */
        ImageView[] f212854k;

        /* renamed from: l, reason: collision with root package name */
        ViewGroup f212855l;

        /* renamed from: m, reason: collision with root package name */
        C11728RoundRectUrlImageView f212856m;

        /* renamed from: n, reason: collision with root package name */
        ImageView f212857n;

        /* renamed from: o, reason: collision with root package name */
        ImageView f212858o;

        /* renamed from: p, reason: collision with root package name */
        TextView f212859p;

        /* renamed from: q, reason: collision with root package name */
        TextView f212860q;

        /* renamed from: r, reason: collision with root package name */
        ImageView f212861r;

        /* renamed from: s, reason: collision with root package name */
        TextView f212862s;

        /* renamed from: t, reason: collision with root package name */
        ImageView f212863t;

        d() {
        }
    }

    public GameQuestionListAdapter(QBaseActivity qBaseActivity) {
        this.f212831i = new WeakReference<>(qBaseActivity);
    }

    private void c(com.tencent.mobileqq.gamecenter.qa.model.b bVar) {
        GameQAUI gameQAUI = this.f212829f.get();
        if (gameQAUI != null) {
            gameQAUI.q0(bVar);
        }
    }

    private void f(d dVar, com.tencent.mobileqq.gamecenter.qa.model.b bVar, int i3) {
        int i16;
        QBaseActivity qBaseActivity = this.f212831i.get();
        if (qBaseActivity == null) {
            return;
        }
        dVar.f212855l.setVisibility(8);
        dVar.f212850g.setVisibility(0);
        ArrayList arrayList = new ArrayList(Math.min(3, i3));
        if (bVar.f212616b.f212613p.size() > 0) {
            for (int i17 = 0; i17 < Math.min(bVar.f212616b.f212613p.size(), 3); i17++) {
                GameStrategyVideo gameStrategyVideo = bVar.f212616b.f212613p.get(i17);
                c cVar = new c();
                cVar.f212843d = true;
                cVar.f212840a = gameStrategyVideo.mCoverWidth;
                cVar.f212841b = gameStrategyVideo.mCoverHeight;
                cVar.f212842c = gameStrategyVideo.mCoverUrl;
                arrayList.add(cVar);
            }
        }
        int size = 3 - arrayList.size();
        if (size > 0 && bVar.f212616b.f212604g.size() > 0) {
            for (int i18 = 0; i18 < Math.min(bVar.f212616b.f212604g.size(), size); i18++) {
                GameStrategyPic gameStrategyPic = bVar.f212616b.f212604g.get(i18);
                c cVar2 = new c();
                cVar2.f212843d = false;
                cVar2.f212840a = gameStrategyPic.mWidth;
                cVar2.f212841b = gameStrategyPic.mHeight;
                cVar2.f212842c = gameStrategyPic.mUrl;
                arrayList.add(cVar2);
            }
        }
        Resources resources = qBaseActivity.getResources();
        int screenWidth = ((ViewUtils.getScreenWidth() - (resources.getDimensionPixelSize(R.dimen.cbf) * 2)) - (resources.getDimensionPixelSize(R.dimen.cbg) * 2)) / 3;
        ViewGroup.LayoutParams layoutParams = dVar.f212850g.getLayoutParams();
        layoutParams.height = screenWidth;
        dVar.f212850g.setLayoutParams(layoutParams);
        for (int i19 = 0; i19 < 3; i19++) {
            ViewGroup.LayoutParams layoutParams2 = dVar.f212851h[i19].getLayoutParams();
            layoutParams2.width = screenWidth;
            layoutParams2.height = screenWidth;
            dVar.f212851h[i19].setLayoutParams(layoutParams2);
            if (i19 < arrayList.size()) {
                dVar.f212851h[i19].setVisibility(0);
                c cVar3 = (c) arrayList.get(i19);
                ImageView imageView = dVar.f212854k[i19];
                if (cVar3.f212843d) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = new ColorDrawable(0);
                dVar.f212853j[i19].setVisibility(8);
                dVar.f212852i[i19].setAllRadius(ViewUtils.dpToPx(4.0f));
                dVar.f212852i[i19].setImageDrawable(URLDrawable.getDrawable(cVar3.f212842c, obtain));
                ImageView imageView2 = dVar.f212853j[i19];
                imageView2.setVisibility(8);
                dVar.f212852i[i19].setURLDrawableDownListener(new a(imageView2));
            } else {
                dVar.f212851h[i19].setVisibility(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(d dVar, com.tencent.mobileqq.gamecenter.qa.model.b bVar, int i3) {
        int i16;
        int i17;
        String str;
        int i18;
        QBaseActivity qBaseActivity = this.f212831i.get();
        if (qBaseActivity == null) {
            return;
        }
        dVar.f212855l.setVisibility(0);
        dVar.f212850g.setVisibility(8);
        boolean z16 = true;
        if (i3 == 1) {
            if (bVar.f212616b.f212613p.size() > 0) {
                GameStrategyVideo gameStrategyVideo = bVar.f212616b.f212613p.get(0);
                i16 = gameStrategyVideo.mCoverWidth;
                i17 = gameStrategyVideo.mCoverHeight;
                str = gameStrategyVideo.mCoverUrl;
            }
            str = null;
            i16 = 0;
            z16 = false;
            i17 = 0;
        } else {
            if (bVar.f212616b.f212604g.size() > 0) {
                GameStrategyPic gameStrategyPic = bVar.f212616b.f212604g.get(0);
                i16 = gameStrategyPic.mWidth;
                i17 = gameStrategyPic.mHeight;
                str = gameStrategyPic.mUrl;
                z16 = false;
            }
            str = null;
            i16 = 0;
            z16 = false;
            i17 = 0;
        }
        Resources resources = qBaseActivity.getResources();
        int screenWidth = ViewUtils.getScreenWidth();
        int dimensionPixelSize = ((screenWidth - (resources.getDimensionPixelSize(R.dimen.cbf) * 2)) - (resources.getDimensionPixelSize(R.dimen.cbg) * 2)) / 3;
        int dimensionPixelSize2 = screenWidth - (resources.getDimensionPixelSize(R.dimen.cbf) * 2);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.cbh);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (i16 >= i17) {
            if (i16 <= dimensionPixelSize) {
                scaleType = ImageView.ScaleType.CENTER_CROP;
                dimensionPixelSize3 = dimensionPixelSize;
                ImageView imageView = dVar.f212858o;
                if (!z16) {
                    i18 = 0;
                } else {
                    i18 = 8;
                }
                imageView.setVisibility(i18);
                dVar.f212856m.setAllRadius(ViewUtils.dpToPx(4.0f));
                ViewGroup.LayoutParams layoutParams = dVar.f212855l.getLayoutParams();
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize3;
                dVar.f212855l.setLayoutParams(layoutParams);
                dVar.f212856m.setScaleType(scaleType);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = new ColorDrawable(0);
                dVar.f212857n.setVisibility(8);
                dVar.f212856m.setImageDrawable(URLDrawable.getDrawable(str, obtain));
                dVar.f212856m.setURLDrawableDownListener(new b(dVar));
            }
            dimensionPixelSize3 = (int) (dimensionPixelSize2 * ((i17 * 1.0f) / i16));
            dimensionPixelSize = dimensionPixelSize2;
            ImageView imageView2 = dVar.f212858o;
            if (!z16) {
            }
            imageView2.setVisibility(i18);
            dVar.f212856m.setAllRadius(ViewUtils.dpToPx(4.0f));
            ViewGroup.LayoutParams layoutParams2 = dVar.f212855l.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize3;
            dVar.f212855l.setLayoutParams(layoutParams2);
            dVar.f212856m.setScaleType(scaleType);
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            obtain2.mLoadingDrawable = new ColorDrawable(0);
            obtain2.mFailedDrawable = new ColorDrawable(0);
            dVar.f212857n.setVisibility(8);
            dVar.f212856m.setImageDrawable(URLDrawable.getDrawable(str, obtain2));
            dVar.f212856m.setURLDrawableDownListener(new b(dVar));
        }
        if (i17 < dimensionPixelSize3 / 2) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
            dimensionPixelSize3 = dimensionPixelSize;
            ImageView imageView22 = dVar.f212858o;
            if (!z16) {
            }
            imageView22.setVisibility(i18);
            dVar.f212856m.setAllRadius(ViewUtils.dpToPx(4.0f));
            ViewGroup.LayoutParams layoutParams22 = dVar.f212855l.getLayoutParams();
            layoutParams22.width = dimensionPixelSize;
            layoutParams22.height = dimensionPixelSize3;
            dVar.f212855l.setLayoutParams(layoutParams22);
            dVar.f212856m.setScaleType(scaleType);
            URLDrawable.URLDrawableOptions obtain22 = URLDrawable.URLDrawableOptions.obtain();
            obtain22.mLoadingDrawable = new ColorDrawable(0);
            obtain22.mFailedDrawable = new ColorDrawable(0);
            dVar.f212857n.setVisibility(8);
            dVar.f212856m.setImageDrawable(URLDrawable.getDrawable(str, obtain22));
            dVar.f212856m.setURLDrawableDownListener(new b(dVar));
        }
        dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.cbi);
        scaleType = ImageView.ScaleType.CENTER_CROP;
        ImageView imageView222 = dVar.f212858o;
        if (!z16) {
        }
        imageView222.setVisibility(i18);
        dVar.f212856m.setAllRadius(ViewUtils.dpToPx(4.0f));
        ViewGroup.LayoutParams layoutParams222 = dVar.f212855l.getLayoutParams();
        layoutParams222.width = dimensionPixelSize;
        layoutParams222.height = dimensionPixelSize3;
        dVar.f212855l.setLayoutParams(layoutParams222);
        dVar.f212856m.setScaleType(scaleType);
        URLDrawable.URLDrawableOptions obtain222 = URLDrawable.URLDrawableOptions.obtain();
        obtain222.mLoadingDrawable = new ColorDrawable(0);
        obtain222.mFailedDrawable = new ColorDrawable(0);
        dVar.f212857n.setVisibility(8);
        dVar.f212856m.setImageDrawable(URLDrawable.getDrawable(str, obtain222));
        dVar.f212856m.setURLDrawableDownListener(new b(dVar));
    }

    public List<com.tencent.mobileqq.gamecenter.qa.model.b> a() {
        return this.f212827d;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.gamecenter.qa.model.b getItem(int i3) {
        List<com.tencent.mobileqq.gamecenter.qa.model.b> list = this.f212827d;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    public void d(GameQAUI gameQAUI) {
        this.f212829f = new WeakReference<>(gameQAUI);
    }

    public void e(List<com.tencent.mobileqq.gamecenter.qa.model.b> list) {
        this.f212827d = list;
    }

    public void g(vd1.b bVar) {
        this.f212828e = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<com.tencent.mobileqq.gamecenter.qa.model.b> list = this.f212827d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        View view2;
        String str = null;
        if (view == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167991ec1, (ViewGroup) null);
            dVar = new d();
            dVar.f212844a = (ImageView) view2.findViewById(R.id.xjr);
            dVar.f212845b = (TextView) view2.findViewById(R.id.f113206q0);
            dVar.f212846c = (TextView) view2.findViewById(R.id.f113266q6);
            dVar.f212847d = (TextView) view2.findViewById(R.id.f113066pm);
            dVar.f212848e = (TextView) view2.findViewById(R.id.f112876p4);
            dVar.f212849f = (ViewGroup) view2.findViewById(R.id.f164900u71);
            ViewGroup viewGroup2 = (ViewGroup) view2.findViewById(R.id.f164902u73);
            dVar.f212850g = viewGroup2;
            ViewGroup[] viewGroupArr = new ViewGroup[3];
            dVar.f212851h = viewGroupArr;
            viewGroupArr[0] = (ViewGroup) viewGroup2.findViewById(R.id.u6y);
            dVar.f212851h[1] = (ViewGroup) dVar.f212850g.findViewById(R.id.u6z);
            dVar.f212851h[2] = (ViewGroup) dVar.f212850g.findViewById(R.id.f164899u70);
            C11728RoundRectUrlImageView[] c11728RoundRectUrlImageViewArr = new C11728RoundRectUrlImageView[3];
            dVar.f212852i = c11728RoundRectUrlImageViewArr;
            c11728RoundRectUrlImageViewArr[0] = (C11728RoundRectUrlImageView) dVar.f212850g.findViewById(R.id.f96875iv);
            dVar.f212852i[1] = (C11728RoundRectUrlImageView) dVar.f212850g.findViewById(R.id.f96905iy);
            dVar.f212852i[2] = (C11728RoundRectUrlImageView) dVar.f212850g.findViewById(R.id.f96935j1);
            ImageView[] imageViewArr = new ImageView[3];
            dVar.f212853j = imageViewArr;
            imageViewArr[0] = (ImageView) dVar.f212850g.findViewById(R.id.f96885iw);
            dVar.f212853j[1] = (ImageView) dVar.f212850g.findViewById(R.id.f96915iz);
            dVar.f212853j[2] = (ImageView) dVar.f212850g.findViewById(R.id.f96945j2);
            ImageView[] imageViewArr2 = new ImageView[3];
            dVar.f212854k = imageViewArr2;
            imageViewArr2[0] = (ImageView) dVar.f212850g.findViewById(R.id.f96895ix);
            dVar.f212854k[1] = (ImageView) dVar.f212850g.findViewById(R.id.f96925j0);
            dVar.f212854k[2] = (ImageView) dVar.f212850g.findViewById(R.id.f96955j3);
            ViewGroup viewGroup3 = (ViewGroup) view2.findViewById(R.id.u7d);
            dVar.f212855l = viewGroup3;
            dVar.f212856m = (C11728RoundRectUrlImageView) viewGroup3.findViewById(R.id.f97025j_);
            dVar.f212857n = (ImageView) dVar.f212855l.findViewById(R.id.f97035ja);
            dVar.f212858o = (ImageView) dVar.f212855l.findViewById(R.id.f97045jb);
            dVar.f212859p = (TextView) view2.findViewById(R.id.f112976pd);
            dVar.f212860q = (TextView) view2.findViewById(R.id.f113296q9);
            dVar.f212862s = (TextView) view2.findViewById(R.id.f113386qh);
            dVar.f212861r = (ImageView) view2.findViewById(R.id.xeq);
            dVar.f212863t = (ImageView) view2.findViewById(R.id.xdt);
            view2.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
            view2 = view;
        }
        com.tencent.mobileqq.gamecenter.qa.model.b item = getItem(i3);
        if (item != null) {
            dVar.f212846c.setText(GameQAUtil.k(item.f212615a.f212622f));
            if (!TextUtils.isEmpty(item.f212616b.f212614q.avatar)) {
                Bitmap b16 = gp3.e.a().b(item.f212616b.f212614q.avatar);
                if (b16 != null) {
                    dVar.f212844a.setImageBitmap(b16);
                } else {
                    final ImageView imageView = dVar.f212844a;
                    gp3.e.a().c(item.f212616b.f212614q.avatar, new e.b() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQuestionListAdapter.1
                        @Override // gp3.e.b
                        public void onImageLoaded(String str2, final Bitmap bitmap, String str3) {
                            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQuestionListAdapter.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                        }
                    });
                }
            } else {
                dVar.f212844a.setImageResource(R.drawable.f160830com);
            }
            dVar.f212845b.setText(item.f212616b.f212614q.name);
            dVar.f212847d.setText(item.f212616b.f212614q.title);
            if (!TextUtils.isEmpty(item.f212616b.f212614q.title)) {
                dVar.f212863t.setVisibility(0);
            } else {
                dVar.f212863t.setVisibility(8);
            }
            dVar.f212859p.setText(GameQAUtil.e(item.f212616b.f212605h * 1000));
            if (item.f212616b.f212606i > 0) {
                dVar.f212862s.setText("\u6709\u7528" + item.f212616b.f212606i);
            } else {
                dVar.f212862s.setText("\u6709\u7528");
            }
            Resources resources = viewGroup.getResources();
            if (item.f212616b.f212609l) {
                dVar.f212861r.setImageResource(R.drawable.mwm);
                dVar.f212862s.setTextColor(resources.getColor(R.color.f157086bk0));
            } else {
                dVar.f212861r.setImageResource(R.drawable.mwl);
                dVar.f212862s.setTextColor(resources.getColor(R.color.f157087bk1));
            }
            dVar.f212861r.setOnClickListener(this);
            dVar.f212862s.setOnClickListener(this);
            dVar.f212861r.setTag(item);
            dVar.f212862s.setTag(item);
            long j3 = item.f212616b.f212608k;
            if (j3 > 0) {
                dVar.f212860q.setText(String.valueOf(j3));
            } else {
                dVar.f212860q.setText("\u8bc4\u8bba");
            }
            if (!TextUtils.isEmpty(item.f212616b.f212603f)) {
                str = GameQAUtil.k(item.f212616b.f212603f.trim());
            }
            if (!TextUtils.isEmpty(str)) {
                dVar.f212848e.setVisibility(0);
                dVar.f212848e.setText(str);
            } else {
                dVar.f212848e.setVisibility(8);
            }
            int size = item.f212616b.f212613p.size();
            int size2 = item.f212616b.f212604g.size() + size;
            if (size2 == 0) {
                dVar.f212849f.setVisibility(8);
            } else {
                dVar.f212849f.setVisibility(0);
                if (size2 == 1) {
                    h(dVar, item, size);
                } else {
                    f(dVar, item, size2);
                }
            }
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar = this.f212828e;
            gameStrategyChannelEntry.guildId = bVar.f441456a;
            gameStrategyChannelEntry.channelId = bVar.f441457b;
            Map<Integer, String> j16 = GameQAUtil.j(this.f212831i.get(), gameStrategyChannelEntry, item.f212615a.f212617a);
            j16.put(4, String.valueOf(item.f212616b.f212598a));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907102", "8", String.valueOf(this.f212828e.f441458c), j16);
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.xeq || id5 == R.id.f113386qh) {
            com.tencent.mobileqq.gamecenter.qa.model.b bVar = (com.tencent.mobileqq.gamecenter.qa.model.b) view.getTag();
            c(bVar);
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar2 = this.f212828e;
            gameStrategyChannelEntry.guildId = bVar2.f441456a;
            gameStrategyChannelEntry.channelId = bVar2.f441457b;
            Map<Integer, String> j3 = GameQAUtil.j(this.f212831i.get(), gameStrategyChannelEntry, bVar.f212615a.f212617a);
            j3.put(4, String.valueOf(bVar.f212616b.f212598a));
            if (bVar.f212616b.f212609l) {
                str = "1";
            } else {
                str = "0";
            }
            j3.put(5, str);
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907434", "20", String.valueOf(this.f212828e.f441458c), j3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f212836d;

        a(ImageView imageView) {
            this.f212836d = imageView;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            this.f212836d.setVisibility(0);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f212838d;

        b(d dVar) {
            this.f212838d = dVar;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            this.f212838d.f212857n.setVisibility(0);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }
}
