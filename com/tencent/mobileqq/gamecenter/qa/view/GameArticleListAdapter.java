package com.tencent.mobileqq.gamecenter.qa.view;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gp3.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameArticleListAdapter extends BaseAdapter {
    private static final HashMap<String, WeakReference<URLDrawable>> E = new HashMap<>();
    private long C;
    private int D;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QBaseActivity> f212723e;

    /* renamed from: f, reason: collision with root package name */
    private int f212724f;

    /* renamed from: h, reason: collision with root package name */
    private int f212725h;

    /* renamed from: m, reason: collision with root package name */
    private boolean f212727m;

    /* renamed from: d, reason: collision with root package name */
    private final List<GameQALinkCardData> f212722d = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private int f212726i = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f212736a;

        /* renamed from: b, reason: collision with root package name */
        public int f212737b;

        /* renamed from: c, reason: collision with root package name */
        public String f212738c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f212739d;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f212740a;

        /* renamed from: b, reason: collision with root package name */
        View f212741b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f212742c;

        /* renamed from: d, reason: collision with root package name */
        TextView f212743d;

        /* renamed from: e, reason: collision with root package name */
        TextView f212744e;

        /* renamed from: f, reason: collision with root package name */
        TextView f212745f;

        /* renamed from: g, reason: collision with root package name */
        TextView f212746g;

        /* renamed from: h, reason: collision with root package name */
        ViewGroup f212747h;

        /* renamed from: i, reason: collision with root package name */
        ViewGroup f212748i;

        /* renamed from: j, reason: collision with root package name */
        ViewGroup[] f212749j;

        /* renamed from: k, reason: collision with root package name */
        C11728RoundRectUrlImageView[] f212750k;

        /* renamed from: l, reason: collision with root package name */
        ImageView[] f212751l;

        /* renamed from: m, reason: collision with root package name */
        ImageView[] f212752m;

        /* renamed from: n, reason: collision with root package name */
        ViewGroup f212753n;

        /* renamed from: o, reason: collision with root package name */
        C11728RoundRectUrlImageView f212754o;

        /* renamed from: p, reason: collision with root package name */
        ImageView f212755p;

        /* renamed from: q, reason: collision with root package name */
        ImageView f212756q;

        /* renamed from: r, reason: collision with root package name */
        TextView f212757r;

        /* renamed from: s, reason: collision with root package name */
        TextView f212758s;

        /* renamed from: t, reason: collision with root package name */
        View f212759t;

        /* renamed from: u, reason: collision with root package name */
        View f212760u;

        /* renamed from: v, reason: collision with root package name */
        TextView f212761v;

        /* renamed from: w, reason: collision with root package name */
        TextView f212762w;

        d() {
        }
    }

    public GameArticleListAdapter(QBaseActivity qBaseActivity) {
        this.f212723e = new WeakReference<>(qBaseActivity);
    }

    private boolean c(Object obj, int i3) {
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() != i3) {
            return false;
        }
        return true;
    }

    private void e(d dVar, GameQALinkCardData gameQALinkCardData) {
        if (!TextUtils.isEmpty(gameQALinkCardData.getUserInfo().avatar)) {
            Bitmap b16 = gp3.e.a().b(gameQALinkCardData.getUserInfo().avatar);
            if (b16 != null) {
                dVar.f212742c.setImageBitmap(b16);
                return;
            } else {
                final ImageView imageView = dVar.f212742c;
                gp3.e.a().c(gameQALinkCardData.getUserInfo().avatar, new e.b() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameArticleListAdapter.1
                    @Override // gp3.e.b
                    public void onImageLoaded(String str, final Bitmap bitmap, String str2) {
                        imageView.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameArticleListAdapter.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                });
                return;
            }
        }
        dVar.f212742c.setImageResource(R.drawable.f160830com);
    }

    private void h(d dVar, GameQALinkCardData gameQALinkCardData, int i3) {
        int i16;
        URLDrawable uRLDrawable;
        WeakReference<URLDrawable> weakReference;
        if (this.f212723e.get() == null) {
            return;
        }
        dVar.f212753n.setVisibility(8);
        dVar.f212748i.setVisibility(0);
        ArrayList arrayList = new ArrayList(Math.min(3, i3));
        if (gameQALinkCardData.getVideos() != null && !gameQALinkCardData.getVideos().isEmpty()) {
            for (int i17 = 0; i17 < Math.min(gameQALinkCardData.getVideos().size(), 3); i17++) {
                GameStrategyVideo gameStrategyVideo = gameQALinkCardData.getVideos().get(i17);
                c cVar = new c();
                cVar.f212739d = true;
                cVar.f212736a = gameStrategyVideo.mCoverWidth;
                cVar.f212737b = gameStrategyVideo.mCoverHeight;
                cVar.f212738c = gameStrategyVideo.mCoverUrl;
                arrayList.add(cVar);
            }
        }
        int size = 3 - arrayList.size();
        if (size > 0 && gameQALinkCardData.getPics() != null && !gameQALinkCardData.getPics().isEmpty()) {
            for (int i18 = 0; i18 < Math.min(gameQALinkCardData.getPics().size(), size); i18++) {
                GameStrategyPic gameStrategyPic = gameQALinkCardData.getPics().get(i18);
                c cVar2 = new c();
                cVar2.f212739d = false;
                cVar2.f212736a = gameStrategyPic.mWidth;
                cVar2.f212737b = gameStrategyPic.mHeight;
                cVar2.f212738c = gameStrategyPic.mUrl;
                arrayList.add(cVar2);
            }
        }
        int screenWidth = ((ViewUtils.getScreenWidth() - (ViewUtils.dpToPx(16.0f) * 2)) - (ViewUtils.dpToPx(8.0f) * 2)) / 3;
        ViewGroup.LayoutParams layoutParams = dVar.f212748i.getLayoutParams();
        layoutParams.height = screenWidth;
        dVar.f212748i.setLayoutParams(layoutParams);
        for (int i19 = 0; i19 < 3; i19++) {
            ViewGroup.LayoutParams layoutParams2 = dVar.f212749j[i19].getLayoutParams();
            layoutParams2.width = screenWidth;
            layoutParams2.height = screenWidth;
            dVar.f212749j[i19].setLayoutParams(layoutParams2);
            if (i19 < arrayList.size()) {
                dVar.f212749j[i19].setVisibility(0);
                c cVar3 = (c) arrayList.get(i19);
                ImageView imageView = dVar.f212752m[i19];
                if (cVar3.f212739d) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = new ColorDrawable(0);
                dVar.f212751l[i19].setVisibility(8);
                dVar.f212750k[i19].setAllRadius(ViewUtils.dpToPx(8.0f));
                HashMap<String, WeakReference<URLDrawable>> hashMap = E;
                if (hashMap.containsKey(cVar3.f212738c) && (weakReference = hashMap.get(cVar3.f212738c)) != null) {
                    uRLDrawable = weakReference.get();
                } else {
                    uRLDrawable = null;
                }
                if (uRLDrawable == null) {
                    uRLDrawable = URLDrawable.getDrawable(cVar3.f212738c, obtain);
                    hashMap.put(cVar3.f212738c, new WeakReference<>(uRLDrawable));
                }
                dVar.f212750k[i19].setImageDrawable(uRLDrawable);
                ImageView imageView2 = dVar.f212751l[i19];
                imageView2.setVisibility(8);
                dVar.f212750k[i19].setURLDrawableDownListener(new a(imageView2));
            } else {
                dVar.f212749j[i19].setVisibility(4);
            }
        }
    }

    private void k(d dVar, GameQALinkCardData gameQALinkCardData, int i3) {
        int i16;
        int i17;
        String str;
        int i18;
        int i19;
        if (this.f212723e.get() == null) {
            return;
        }
        dVar.f212753n.setVisibility(0);
        dVar.f212748i.setVisibility(8);
        boolean z16 = true;
        if (i3 == 1) {
            List<GameStrategyVideo> videos = gameQALinkCardData.getVideos();
            if (videos != null && videos.size() > 0) {
                GameStrategyVideo gameStrategyVideo = videos.get(0);
                i16 = gameStrategyVideo.mCoverWidth;
                i17 = gameStrategyVideo.mCoverHeight;
                str = gameStrategyVideo.mCoverUrl;
            }
            i16 = 0;
            z16 = false;
            str = null;
            i17 = 0;
        } else {
            List<GameStrategyPic> pics = gameQALinkCardData.getPics();
            if (pics != null && pics.size() > 0) {
                GameStrategyPic gameStrategyPic = pics.get(0);
                i16 = gameStrategyPic.mWidth;
                i17 = gameStrategyPic.mHeight;
                str = gameStrategyPic.mUrl;
                z16 = false;
            }
            i16 = 0;
            z16 = false;
            str = null;
            i17 = 0;
        }
        int screenWidth = ViewUtils.getScreenWidth();
        int dpToPx = ((screenWidth - (ViewUtils.dpToPx(16.0f) * 2)) - (ViewUtils.dpToPx(8.0f) * 2)) / 3;
        int dpToPx2 = screenWidth - (ViewUtils.dpToPx(16.0f) * 2);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        if (i16 >= i17) {
            i18 = (int) (dpToPx2 * 0.5568513f);
            dpToPx = dpToPx2;
        } else {
            i18 = dpToPx;
        }
        ImageView imageView = dVar.f212756q;
        if (z16) {
            i19 = 0;
        } else {
            i19 = 8;
        }
        imageView.setVisibility(i19);
        dVar.f212754o.setAllRadius(ViewUtils.dpToPx(8.0f));
        ViewGroup.LayoutParams layoutParams = dVar.f212753n.getLayoutParams();
        layoutParams.width = dpToPx;
        layoutParams.height = i18;
        dVar.f212753n.setLayoutParams(layoutParams);
        dVar.f212754o.setScaleType(scaleType);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        dVar.f212755p.setVisibility(8);
        dVar.f212754o.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        dVar.f212754o.setURLDrawableDownListener(new b(dVar));
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameQALinkCardData getItem(int i3) {
        return this.f212722d.get(i3);
    }

    public GameQALinkCardData b() {
        int size = this.f212722d.size();
        int i3 = this.f212726i;
        if (size > i3 && i3 >= 0) {
            return this.f212722d.get(i3);
        }
        return null;
    }

    public void d(int i3, int i16) {
        this.f212724f = i3;
        this.f212725h = i16;
    }

    public void f(boolean z16) {
        this.f212727m = z16;
    }

    public void g(List<GameQALinkCardData> list) {
        this.f212722d.clear();
        if (list != null) {
            this.f212722d.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f212722d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        int size;
        int size2;
        if (QLog.isColorLevel()) {
            QLog.d("GameArticleListAdapter", 2, "this:" + this + " position:" + i3 + " convertView:" + view + " count:" + getCount());
        }
        String str = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eax, (ViewGroup) null);
            dVar = new d();
            dVar.f212741b = view.findViewById(R.id.u7m);
            dVar.f212742c = (ImageView) view.findViewById(R.id.xjr);
            dVar.f212743d = (TextView) view.findViewById(R.id.f113206q0);
            dVar.f212744e = (TextView) view.findViewById(R.id.f113366qf);
            dVar.f212745f = (TextView) view.findViewById(R.id.f112886p5);
            dVar.f212746g = (TextView) view.findViewById(R.id.f112966pc);
            dVar.f212747h = (ViewGroup) view.findViewById(R.id.f164900u71);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.f164902u73);
            dVar.f212748i = viewGroup2;
            ViewGroup[] viewGroupArr = new ViewGroup[3];
            dVar.f212749j = viewGroupArr;
            viewGroupArr[0] = (ViewGroup) viewGroup2.findViewById(R.id.u6y);
            dVar.f212749j[1] = (ViewGroup) dVar.f212748i.findViewById(R.id.u6z);
            dVar.f212749j[2] = (ViewGroup) dVar.f212748i.findViewById(R.id.f164899u70);
            C11728RoundRectUrlImageView[] c11728RoundRectUrlImageViewArr = new C11728RoundRectUrlImageView[3];
            dVar.f212750k = c11728RoundRectUrlImageViewArr;
            c11728RoundRectUrlImageViewArr[0] = (C11728RoundRectUrlImageView) dVar.f212748i.findViewById(R.id.f96875iv);
            dVar.f212750k[1] = (C11728RoundRectUrlImageView) dVar.f212748i.findViewById(R.id.f96905iy);
            dVar.f212750k[2] = (C11728RoundRectUrlImageView) dVar.f212748i.findViewById(R.id.f96935j1);
            ImageView[] imageViewArr = new ImageView[3];
            dVar.f212751l = imageViewArr;
            imageViewArr[0] = (ImageView) dVar.f212748i.findViewById(R.id.f96885iw);
            dVar.f212751l[1] = (ImageView) dVar.f212748i.findViewById(R.id.f96915iz);
            dVar.f212751l[2] = (ImageView) dVar.f212748i.findViewById(R.id.f96945j2);
            ImageView[] imageViewArr2 = new ImageView[3];
            dVar.f212752m = imageViewArr2;
            imageViewArr2[0] = (ImageView) dVar.f212748i.findViewById(R.id.f96895ix);
            dVar.f212752m[1] = (ImageView) dVar.f212748i.findViewById(R.id.f96925j0);
            dVar.f212752m[2] = (ImageView) dVar.f212748i.findViewById(R.id.f96955j3);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.u7d);
            dVar.f212753n = viewGroup3;
            dVar.f212754o = (C11728RoundRectUrlImageView) viewGroup3.findViewById(R.id.f97025j_);
            dVar.f212755p = (ImageView) dVar.f212753n.findViewById(R.id.f97035ja);
            dVar.f212756q = (ImageView) dVar.f212753n.findViewById(R.id.f97045jb);
            dVar.f212757r = (TextView) view.findViewById(R.id.f112976pd);
            dVar.f212758s = (TextView) view.findViewById(R.id.f113386qh);
            dVar.f212759t = view.findViewById(R.id.f100015rc);
            dVar.f212760u = view.findViewById(R.id.tae);
            dVar.f212740a = (ImageView) view.findViewById(R.id.taf);
            dVar.f212761v = (TextView) view.findViewById(R.id.vjn);
            dVar.f212762w = (TextView) view.findViewById(R.id.sw7);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        GameQALinkCardData item = getItem(i3);
        if (item != null) {
            if (i3 == this.f212726i) {
                dVar.f212759t.setVisibility(0);
                dVar.f212760u.setVisibility(0);
                dVar.f212740a.setVisibility(0);
                view.setBackgroundColor(view.getResources().getColor(R.color.qqgame_strategy_article_item_bg_selected_color));
                dVar.f212761v.setBackgroundResource(R.drawable.jot);
                dVar.f212744e.setTextColor(view.getResources().getColor(R.color.qqgame_strategy_article_item_title_text_selected_color));
                dVar.f212744e.getPaint().setFakeBoldText(true);
            } else {
                dVar.f212760u.setVisibility(8);
                dVar.f212740a.setVisibility(8);
                dVar.f212759t.setVisibility(8);
                view.setBackgroundColor(view.getResources().getColor(R.color.qqgame_strategy_article_item_bg_normal_color));
                dVar.f212761v.setBackgroundResource(R.drawable.jos);
                if (item.getLinkType() == LinkType.REFERENCE_TYPE_QA) {
                    dVar.f212744e.setTextColor(view.getResources().getColor(R.color.cfd));
                } else {
                    dVar.f212744e.setTextColor(view.getResources().getColor(R.color.qqgame_strategy_article_item_title_text_channel_color));
                }
                dVar.f212744e.getPaint().setFakeBoldText(false);
            }
            if (item.getTags() != null && !item.getTags().isEmpty()) {
                str = item.getTags().get(0);
                if (item.getTags().size() > 1 && this.f212724f == 100) {
                    dVar.f212762w.setVisibility(0);
                    dVar.f212762w.setText(item.getTags().get(1));
                } else {
                    dVar.f212762w.setVisibility(8);
                }
            } else {
                dVar.f212762w.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                dVar.f212761v.setVisibility(0);
                dVar.f212761v.setText(str);
            } else {
                dVar.f212761v.setVisibility(8);
            }
            String trim = item.getTitle().trim();
            if (!TextUtils.isEmpty(trim)) {
                dVar.f212744e.setVisibility(0);
                dVar.f212744e.setText(trim);
            } else {
                dVar.f212744e.setVisibility(8);
            }
            String trim2 = item.getContent().trim();
            if (!TextUtils.isEmpty(trim2)) {
                dVar.f212746g.setVisibility(0);
                dVar.f212746g.setText(trim2);
            } else {
                dVar.f212746g.setVisibility(8);
            }
            if (this.f212724f == 100) {
                if (item.isSelf()) {
                    dVar.f212741b.setVisibility(8);
                    ((LinearLayout.LayoutParams) dVar.f212744e.getLayoutParams()).topMargin = ViewUtils.dpToPx(16.0f);
                } else {
                    dVar.f212741b.setVisibility(0);
                    ((LinearLayout.LayoutParams) dVar.f212744e.getLayoutParams()).topMargin = ViewUtils.dpToPx(7.0f);
                    e(dVar, item);
                }
            } else if (this.f212725h == 0) {
                dVar.f212741b.setVisibility(8);
                ((LinearLayout.LayoutParams) dVar.f212744e.getLayoutParams()).topMargin = ViewUtils.dpToPx(16.0f);
            } else {
                dVar.f212741b.setVisibility(0);
                ((LinearLayout.LayoutParams) dVar.f212744e.getLayoutParams()).topMargin = ViewUtils.dpToPx(7.0f);
                e(dVar, item);
            }
            dVar.f212743d.setText(item.getUserInfo().name);
            if (item.getLinkType() == LinkType.REFERENCE_TYPE_QA) {
                dVar.f212745f.setVisibility(0);
            } else {
                dVar.f212745f.setVisibility(8);
            }
            dVar.f212757r.setText(GameQAUtil.e(item.getCreateTs() * 1000));
            if (item.getLikeCount() > 0) {
                dVar.f212758s.setText(String.valueOf(item.getLikeCount()));
            } else {
                dVar.f212758s.setText("0");
            }
            if (item.getVideos() == null) {
                size = 0;
            } else {
                size = item.getVideos().size();
            }
            if (item.getPics() == null) {
                size2 = 0;
            } else {
                size2 = item.getPics().size();
            }
            int i16 = size2 + size;
            if (i16 == 0) {
                dVar.f212747h.setVisibility(8);
            } else {
                dVar.f212747h.setVisibility(0);
                if (i16 == 1) {
                    k(dVar, item, size);
                } else {
                    h(dVar, item, i16);
                }
            }
            Object tag = view.getTag(view.getId());
            if ((tag == null || !c(tag, i3)) && this.f212727m) {
                GameQAUtil.D(this.D, this.C, item);
            }
            view.setTag(view.getId(), Integer.valueOf(i3));
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void i(int i3, long j3) {
        this.D = i3;
        this.C = j3;
    }

    public void j(int i3) {
        if (this.f212726i == i3) {
            this.f212726i = -1;
        } else {
            this.f212726i = i3;
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f212732d;

        a(ImageView imageView) {
            this.f212732d = imageView;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            this.f212732d.setVisibility(0);
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
        final /* synthetic */ d f212734d;

        b(d dVar) {
            this.f212734d = dVar;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            this.f212734d.f212755p.setVisibility(0);
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
