package com.tencent.biz.qqstory.takevideo.slideshow;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ThrowablesUtils;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i implements View.OnClickListener {
    private View C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private SlideProgressNotifier H;
    private LinearLayoutManager I;

    /* renamed from: e, reason: collision with root package name */
    private Activity f94404e;

    /* renamed from: f, reason: collision with root package name */
    private e f94405f;

    /* renamed from: h, reason: collision with root package name */
    private View f94406h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f94407i;

    /* renamed from: m, reason: collision with root package name */
    private SlideShowAdapter f94408m;

    /* renamed from: d, reason: collision with root package name */
    private String f94403d = "SlideShowViewController";
    private int J = 20999;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements SlideShowAdapter.d {
        a() {
        }

        @Override // com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.d
        public void a(int i3) {
            int i16;
            String str;
            int i17;
            SlideItemInfo slideItemInfo = SlideShowPhotoListManager.n().o().get(i3);
            if (slideItemInfo == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(i.this.f94403d, 2, "slideItem is null, do not jump");
                    return;
                }
                return;
            }
            int l3 = SlideShowPhotoListManager.n().l();
            Intent intent = new Intent();
            intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) slideItemInfo.f94287d);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, slideItemInfo.C);
            intent.putExtra(ShortVideoConstants.FROM_SLIDESHOW_TO_SHARE, true);
            intent.putExtra("video_index", i3);
            intent.putExtra("start_index", slideItemInfo.K);
            intent.putExtra("end_index", slideItemInfo.L);
            intent.putExtra("scroll_x", slideItemInfo.J);
            if (l3 == 11) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            intent.putExtra("entrance_type", i16);
            String str2 = "0";
            if (i.this.f94404e instanceof NewPhotoListActivity) {
                str = "0";
            } else {
                str = "1";
            }
            intent.putExtra("op_entrance_type", str);
            intent.putExtra("start_time", slideItemInfo.D);
            intent.putExtra("end_time", slideItemInfo.E);
            intent.putExtra("PhotoConst.IS_FROM_EDIT", true);
            intent.setClass(i.this.f94404e, LocalVideoSelectActivity.class);
            i.this.f94404e.startActivityForResult(intent, ISlideShowController.CODE_FROM_SLIDE_SHOW_CLIP);
            if (l3 == 11) {
                i17 = 0;
            } else {
                i17 = 1;
            }
            String[] strArr = new String[2];
            if (!(i.this.f94404e instanceof NewPhotoListActivity)) {
                str2 = "1";
            }
            strArr[0] = str2;
            strArr[1] = slideItemInfo.D + "-" + slideItemInfo.E;
            id0.a.n("pic_choose", "clk_cutVideo", i17, 0, strArr);
        }
    }

    public i(Activity activity, View view, e eVar) {
        this.f94406h = view;
        this.f94404e = activity;
        this.f94405f = eVar;
        e();
        j();
    }

    private void e() {
        int i3;
        if (this.f94406h == null) {
            this.f94406h = this.f94404e.findViewById(R.id.gz5);
        }
        View view = this.f94406h;
        if (view == null) {
            QLog.w(this.f94403d, 1, "initUI, root view is null, class=" + this.f94404e.getClass());
            return;
        }
        view.setVisibility(0);
        boolean z16 = this.f94404e instanceof NewPhotoListActivity;
        if (z16) {
            this.f94406h.setBackgroundColor(-526087);
        } else {
            this.f94406h.setBackgroundColor(1996488704);
        }
        View findViewById = this.f94406h.findViewById(R.id.f166649gz1);
        this.C = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(0);
            View view2 = this.C;
            if (z16) {
                i3 = -3026479;
            } else {
                i3 = -1728053248;
            }
            view2.setBackgroundColor(i3);
        }
        this.f94407i = (RecyclerView) this.f94406h.findViewById(R.id.gz7);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f94404e, 0, false);
        this.I = linearLayoutManager;
        this.f94407i.setLayoutManager(linearLayoutManager);
        SlideShowAdapter slideShowAdapter = new SlideShowAdapter(this.f94406h.getContext(), this, this.f94405f);
        this.f94408m = slideShowAdapter;
        slideShowAdapter.y(SlideShowPhotoListManager.n().o());
        this.f94407i.setAdapter(this.f94408m);
        this.f94407i.getRecycledViewPool().setMaxRecycledViews(this.f94408m.getItemViewType(0), 10);
        this.f94408m.w(new a());
        new ItemTouchHelper(new g(this.f94408m)).attachToRecyclerView(this.f94407i);
        this.E = (TextView) this.f94406h.findViewById(R.id.gz8);
        this.D = (TextView) this.f94406h.findViewById(R.id.gz9);
        TextView textView = (TextView) this.f94406h.findViewById(R.id.f166648gz0);
        this.F = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.f94406h.findViewById(R.id.gyz);
        this.G = textView2;
        textView2.setOnClickListener(this);
        this.H = new SlideProgressNotifier(this.f94404e, R.layout.f168851b15);
        if (f()) {
            this.J = 60000;
            SlideShowPhotoListManager.n().E(this.J);
        }
    }

    private boolean f() {
        Activity activity = this.f94404e;
        if (activity == null || activity.getIntent() == null || this.f94404e.getIntent().getIntExtra("edit_video_type", 10002) != 10023) {
            return false;
        }
        return true;
    }

    private void i(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.5f);
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
        ofFloat.setStartDelay(0L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.5f, 1.0f);
        ofFloat2.setDuration(260L);
        ofFloat2.setInterpolator(new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
        ofFloat2.setStartDelay(237L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.5f);
        ofFloat3.setDuration(270L);
        ofFloat3.setInterpolator(new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
        ofFloat3.setStartDelay(495L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.5f, 1.0f);
        ofFloat4.setDuration(240L);
        ofFloat4.setInterpolator(new ss.b(0.33f, 0.0f, 0.67f, 1.0f));
        ofFloat4.setStartDelay(763L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        animatorSet.start();
    }

    public void c() {
        if (this.H != null) {
            int size = SlideShowPhotoListManager.n().o().size();
            if (size == 0) {
                size = 1;
            }
            this.H.h(size * 1000, 99, (int) (((r0.size() * 1.0d) / (r0.size() + 1)) * 100.0d));
        }
    }

    public void d() {
        SlideProgressNotifier slideProgressNotifier = this.H;
        if (slideProgressNotifier != null) {
            slideProgressNotifier.j();
            this.H.b();
        }
    }

    public void g() {
        List<SlideItemInfo> o16 = SlideShowPhotoListManager.n().o();
        LinearLayoutManager linearLayoutManager = this.I;
        if (linearLayoutManager != null && this.f94407i != null) {
            int findLastVisibleItemPosition = this.I.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                View findViewByPosition = this.I.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition != null) {
                    RecyclerView.ViewHolder childViewHolder = this.f94407i.getChildViewHolder(findViewByPosition);
                    if (childViewHolder instanceof SlideShowAdapter.c) {
                        SlideShowAdapter.c cVar = (SlideShowAdapter.c) childViewHolder;
                        SlideItemInfo slideItemInfo = (SlideItemInfo) cVar.f94306d.getTag();
                        Iterator<SlideItemInfo> it = o16.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                SlideItemInfo next = it.next();
                                if (slideItemInfo.f94291i.equals(next.f94291i) && next.P) {
                                    next.P = false;
                                    i(cVar.f94306d);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void h() {
        SlideProgressNotifier slideProgressNotifier = this.H;
        if (slideProgressNotifier != null) {
            slideProgressNotifier.j();
            this.H.b();
            int i3 = 0;
            for (SlideItemInfo slideItemInfo : SlideShowPhotoListManager.n().o()) {
                if (slideItemInfo != null) {
                    i3 += (int) slideItemInfo.a();
                }
            }
            if (i3 == 0) {
                i3 = 5000;
            }
            this.H.i(0, (int) (i3 * 1.5d), (int) (((r0.size() * 1.0d) / (r0.size() + 1)) * 100.0d), 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        byte b16;
        int i3;
        int i16;
        boolean z16;
        int i17;
        String str;
        boolean z17 = true;
        if (SlideShowPhotoListManager.n().m() == 22) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (SlideShowPhotoListManager.n().l() == 11) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        boolean z18 = this.f94404e instanceof NewPhotoListActivity;
        List<SlideItemInfo> o16 = SlideShowPhotoListManager.n().o();
        if (o16 != null) {
            i16 = o16.size();
        } else {
            i16 = 0;
        }
        long j3 = 0;
        if (i16 > 0) {
            for (SlideItemInfo slideItemInfo : o16) {
                if (slideItemInfo != null) {
                    j3 += slideItemInfo.a();
                }
            }
            if (j3 > this.J && b16 == false) {
                this.E.setTextColor(this.f94404e.getResources().getColor(R.color.ahe));
                this.D.setTextColor(this.f94404e.getResources().getColor(R.color.ahe));
                if (this.G.getVisibility() != 0) {
                    int i18 = 0;
                    int i19 = 0;
                    int i26 = 0;
                    for (SlideItemInfo slideItemInfo2 : SlideShowPhotoListManager.n().o()) {
                        if (slideItemInfo2 != null) {
                            i18++;
                            int i27 = slideItemInfo2.f94290h;
                            if (i27 == 1) {
                                i19++;
                            } else if (i27 == 0) {
                                i26++;
                            }
                        }
                    }
                    int i28 = i3 ^ 1;
                    String[] strArr = new String[4];
                    if (z18) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    strArr[0] = str;
                    strArr[1] = i18 + "";
                    strArr[2] = i26 + "";
                    strArr[3] = i19 + "";
                    i17 = 0;
                    id0.a.n("pic_choose", "exp_autoCut", i28, 0, strArr);
                } else {
                    i17 = 0;
                }
                this.G.setVisibility(i17);
            } else {
                if (z18) {
                    this.E.setTextColor(this.f94404e.getResources().getColor(R.color.abf));
                    this.D.setTextColor(this.f94404e.getResources().getColor(R.color.ahf));
                } else {
                    this.E.setTextColor(this.f94404e.getResources().getColor(R.color.f158017al3));
                    this.D.setTextColor(this.f94404e.getResources().getColor(R.color.f158017al3));
                }
                this.G.setVisibility(8);
            }
            if (b16 == false) {
                z16 = false;
                this.E.setText(this.f94404e.getString(R.string.fv6, Integer.valueOf(this.J / 1000)));
            } else {
                z16 = false;
            }
            this.D.setText(h.c(j3));
            this.D.setVisibility(z16 ? 1 : 0);
            this.f94407i.setVisibility(z16 ? 1 : 0);
        } else {
            z16 = false;
            if (z18) {
                this.E.setTextColor(this.f94404e.getResources().getColor(R.color.abf));
            } else {
                this.E.setTextColor(this.f94404e.getResources().getColor(R.color.f158017al3));
            }
            if (i3 == 0 && b16 == false) {
                this.E.setText(this.f94404e.getString(R.string.fv8));
            } else {
                this.E.setText(this.f94404e.getString(R.string.fv7));
            }
            this.f94407i.setVisibility(8);
            this.D.setVisibility(8);
            this.G.setVisibility(8);
        }
        if (b16 != false) {
            TextView textView = this.F;
            if (i16 < 2 || i16 > 30) {
                z17 = z16;
            }
            textView.setEnabled(z17);
        } else if (i3 == 0) {
            TextView textView2 = this.F;
            if (i16 < 2 || i16 > 10 || j3 > this.J) {
                z17 = z16;
            }
            textView2.setEnabled(z17);
        } else if (z18) {
            TextView textView3 = this.F;
            if (i16 < 1 || i16 > 10 || j3 > this.J) {
                z17 = z16;
            }
            textView3.setEnabled(z17);
        } else if (i16 == 0) {
            this.F.setEnabled(true);
        } else {
            TextView textView4 = this.F;
            if (i16 < 1 || i16 > 10 || j3 > this.J) {
                z17 = z16;
            }
            textView4.setEnabled(z17);
        }
        SlideShowAdapter slideShowAdapter = this.f94408m;
        if (slideShowAdapter != null) {
            slideShowAdapter.y(o16);
        }
    }

    public void k(int i3) {
        SlideShowAdapter slideShowAdapter = this.f94408m;
        if (slideShowAdapter != null) {
            slideShowAdapter.z(i3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        String str;
        boolean z16;
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ixp) {
            SlideItemInfo slideItemInfo = (SlideItemInfo) view.getTag();
            int indexOf = SlideShowPhotoListManager.n().o().indexOf(slideItemInfo);
            e eVar = this.f94405f;
            if (eVar != null && slideItemInfo != null) {
                eVar.o(slideItemInfo.f94291i);
            }
            k(indexOf);
        } else if (id5 == R.id.f166648gz0) {
            boolean z17 = !(this.f94404e instanceof NewPhotoListActivity);
            if (SlideShowPhotoListManager.n().l() == 11) {
                z16 = true;
            } else {
                z16 = false;
            }
            List<SlideItemInfo> o16 = SlideShowPhotoListManager.n().o();
            if (z16 && z17 && o16.size() == 0) {
                e eVar2 = this.f94405f;
                if (eVar2 != null) {
                    eVar2.m();
                }
                List<SlideItemInfo> o17 = SlideShowPhotoListManager.n().o();
                if (o17.size() >= 1 && o17.size() <= 10 && o17.get(0).a() <= 20999) {
                    SlideShowPhotoListManager.n().i(this.f94404e, null, 2);
                }
            } else {
                SlideShowPhotoListManager.n().i(this.f94404e, null, 2);
                Activity activity2 = this.f94404e;
                if (activity2 != null && activity2.getIntent().getBooleanExtra("from_qzone_slideshow", false)) {
                    Activity activity3 = this.f94404e;
                    if (activity3 instanceof NewPhotoListActivity) {
                        SlideShowPhotoListManager.n().A(14);
                    } else if (activity3 instanceof NewPhotoPreviewActivity) {
                        SlideShowPhotoListManager.n().A(19);
                    }
                }
            }
            try {
                if (SlideShowPhotoListManager.n().l() == 13) {
                    Activity activity4 = this.f94404e;
                    if (activity4 != null) {
                        id0.a.j("pic_fictitious", "clk_next", activity4.getIntent(), new String[0]);
                    }
                    if (SlideShowPhotoListManager.n().q() && (activity = this.f94404e) != null) {
                        id0.a.j("video_edit_new", "change_pic", activity.getIntent(), new String[0]);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f94403d, 2, ThrowablesUtils.getStackTraceAsString(e16));
                }
            }
        } else if (id5 == R.id.gyz) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f94403d, 2, "qqstory_slideshow_auto_optimize");
            }
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (SlideItemInfo slideItemInfo2 : SlideShowPhotoListManager.n().o()) {
                if (slideItemInfo2 != null) {
                    i16++;
                    int i19 = slideItemInfo2.f94290h;
                    if (i19 == 1) {
                        i17++;
                    } else if (i19 == 0) {
                        i18++;
                    }
                }
            }
            boolean z18 = this.f94404e instanceof NewPhotoListActivity;
            if (SlideShowPhotoListManager.n().l() == 11) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i26 = i3 ^ 1;
            String[] strArr = new String[4];
            if (z18) {
                str = "0";
            } else {
                str = "1";
            }
            strArr[0] = str;
            strArr[1] = i16 + "";
            strArr[2] = i18 + "";
            strArr[3] = i17 + "";
            id0.a.n("pic_choose", "clk_autoCut", i26, 0, strArr);
            SlideShowPhotoListManager.n().s();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
