package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.UpSideDownDrawable;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.LeakUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LikeRankingListActivity extends BaseActivity implements Animation.AnimationListener, AbsListView.OnScrollListener, Handler.Callback, AdapterView.OnItemClickListener, DecodeTaskCompletionListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    int A0;
    long B0;
    int C0;
    int D0;
    String E0;
    int F0;
    int G0;
    Card H0;
    CallBacker I0;
    AlphaAnimation J0;
    AlphaAnimation K0;
    CardObserver L0;
    ProfileCardObserver M0;
    WeakReferenceHandler N0;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.app.bk f176380a0;

    /* renamed from: b0, reason: collision with root package name */
    FriendsManager f176381b0;

    /* renamed from: c0, reason: collision with root package name */
    IFaceDecoder f176382c0;

    /* renamed from: d0, reason: collision with root package name */
    CardHandler f176383d0;

    /* renamed from: e0, reason: collision with root package name */
    int f176384e0;

    /* renamed from: f0, reason: collision with root package name */
    String f176385f0;

    /* renamed from: g0, reason: collision with root package name */
    String f176386g0;

    /* renamed from: h0, reason: collision with root package name */
    LikeRankingInfo f176387h0;

    /* renamed from: i0, reason: collision with root package name */
    ImmersiveTitleBar2 f176388i0;

    /* renamed from: j0, reason: collision with root package name */
    View f176389j0;

    /* renamed from: k0, reason: collision with root package name */
    TextView f176390k0;

    /* renamed from: l0, reason: collision with root package name */
    TextView f176391l0;

    /* renamed from: m0, reason: collision with root package name */
    PullToZoomListView f176392m0;

    /* renamed from: n0, reason: collision with root package name */
    c f176393n0;

    /* renamed from: o0, reason: collision with root package name */
    View f176394o0;

    /* renamed from: p0, reason: collision with root package name */
    ImageView f176395p0;

    /* renamed from: q0, reason: collision with root package name */
    ImageView f176396q0;

    /* renamed from: r0, reason: collision with root package name */
    CircleProgress f176397r0;

    /* renamed from: s0, reason: collision with root package name */
    TextView f176398s0;

    /* renamed from: t0, reason: collision with root package name */
    View f176399t0;

    /* renamed from: u0, reason: collision with root package name */
    View f176400u0;

    /* renamed from: v0, reason: collision with root package name */
    View f176401v0;

    /* renamed from: w0, reason: collision with root package name */
    private View f176402w0;

    /* renamed from: x0, reason: collision with root package name */
    ColorStateList f176403x0;

    /* renamed from: y0, reason: collision with root package name */
    ColorStateList f176404y0;

    /* renamed from: z0, reason: collision with root package name */
    int f176405z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends CallBacker {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            LikeRankingListActivity likeRankingListActivity;
            Card card;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (j3 == 15 && str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX) && i3 == 0 && (card = (likeRankingListActivity = LikeRankingListActivity.this).H0) != null) {
                likeRankingListActivity.G2(card);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends CardObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onReqLikeRankingListResult(boolean z16, String str, List<LikeRankingInfo> list, int i3, boolean z17) {
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, list, Integer.valueOf(i3), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = "onReqLikeRankingListResult success:" + z16;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(", uin:");
                sb5.append(str);
                sb5.append(", size:");
                if (list == null) {
                    size = 0;
                } else {
                    size = list.size();
                }
                sb5.append(size);
                sb5.append(", nextIndex: ");
                sb5.append(i3);
                sb5.append(", isComplete:");
                sb5.append(z17);
                objArr[1] = sb5.toString();
                QLog.d("LikeRankingListActivity", 2, objArr);
            }
            if (z16) {
                if (list != null && (list.size() > 0 || z17)) {
                    LikeRankingListActivity.this.f176380a0.j(list, i3, z17);
                    if (z17 && list.size() == 0) {
                        LikeRankingListActivity.this.f176401v0.setVisibility(0);
                    } else {
                        LikeRankingListActivity.this.f176401v0.setVisibility(8);
                    }
                    LikeRankingListActivity.this.f176393n0.b(list, true);
                    if (LikeRankingListActivity.this.f176384e0 == 0) {
                        if (list.size() > 0) {
                            LikeRankingListActivity.this.J2(String.valueOf(list.get(0).uin));
                            LikeRankingListActivity.this.I2(false);
                        } else {
                            LikeRankingListActivity.this.J2(null);
                        }
                    }
                } else {
                    LikeRankingListActivity.this.J2(null);
                    c cVar = LikeRankingListActivity.this.f176393n0;
                    cVar.f176415e = false;
                    cVar.notifyDataSetChanged();
                    if (LikeRankingListActivity.this.f176393n0.getCount() <= 1) {
                        LikeRankingListActivity.this.f176401v0.setVisibility(0);
                    }
                }
                LikeRankingListActivity likeRankingListActivity = LikeRankingListActivity.this;
                if (z17) {
                    i3 = -1;
                }
                likeRankingListActivity.f176384e0 = i3;
                return;
            }
            c cVar2 = LikeRankingListActivity.this.f176393n0;
            cVar2.f176415e = false;
            cVar2.notifyDataSetChanged();
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.nob), 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends BaseAdapter {
        static IPatchRedirector $redirector_;
        int[] C;

        /* renamed from: d, reason: collision with root package name */
        List<LikeRankingInfo> f176414d;

        /* renamed from: e, reason: collision with root package name */
        boolean f176415e;

        /* renamed from: f, reason: collision with root package name */
        String f176416f;

        /* renamed from: h, reason: collision with root package name */
        String f176417h;

        /* renamed from: i, reason: collision with root package name */
        RelativeSizeSpan f176418i;

        /* renamed from: m, reason: collision with root package name */
        int[] f176419m;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            TextView f176420a;

            /* renamed from: b, reason: collision with root package name */
            ProgressBar f176421b;

            /* renamed from: c, reason: collision with root package name */
            ImageView f176422c;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            TextView f176424a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f176425b;

            /* renamed from: c, reason: collision with root package name */
            ImageView f176426c;

            /* renamed from: d, reason: collision with root package name */
            ImageView f176427d;

            /* renamed from: e, reason: collision with root package name */
            TextView f176428e;

            /* renamed from: f, reason: collision with root package name */
            TextView f176429f;

            /* renamed from: g, reason: collision with root package name */
            TextView f176430g;

            /* renamed from: h, reason: collision with root package name */
            View f176431h;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
                return;
            }
            this.f176415e = false;
            this.f176418i = new RelativeSizeSpan(0.62f);
            this.f176419m = new int[]{R.drawable.ewq, R.drawable.ewr, R.drawable.ews};
            this.C = new int[]{R.drawable.ewn, R.drawable.ewo, R.drawable.ewp};
            this.f176414d = new ArrayList();
            this.f176417h = LikeRankingListActivity.this.getString(R.string.i3q);
            this.f176416f = LikeRankingListActivity.this.getString(R.string.c2t);
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LikeRankingInfo getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LikeRankingInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < this.f176414d.size()) {
                return this.f176414d.get(i3);
            }
            return null;
        }

        public void b(List<LikeRankingInfo> list, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16));
                return;
            }
            this.f176414d.clear();
            LikeRankingInfo likeRankingInfo = LikeRankingListActivity.this.f176387h0;
            int size = list.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                LikeRankingInfo likeRankingInfo2 = list.get(size);
                long j3 = likeRankingInfo2.uin;
                LikeRankingListActivity likeRankingListActivity = LikeRankingListActivity.this;
                if (j3 == likeRankingListActivity.f176387h0.uin) {
                    likeRankingListActivity.f176387h0 = likeRankingInfo2;
                    break;
                }
                size--;
            }
            if (this.f176414d.size() == 0) {
                LikeRankingInfo likeRankingInfo3 = LikeRankingListActivity.this.f176387h0;
                if (likeRankingInfo3.rankingNum > 3 && likeRankingInfo3.likeCountOfToday > 0) {
                    this.f176414d.add(likeRankingInfo3);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", Boolean.valueOf(z16), likeRankingInfo, LikeRankingListActivity.this.f176387h0, Integer.valueOf(list.size())));
            }
            this.f176414d.addAll(list);
            this.f176415e = false;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f176414d.size() + 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            if (i3 == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int i16;
            View view2;
            View view3;
            int i17;
            int i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i19 = 4;
            int i26 = 8;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                view2 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int itemViewType = getItemViewType(i3);
                if (view == null) {
                    if (itemViewType != 0) {
                        if (itemViewType == 1) {
                            view = LayoutInflater.from(LikeRankingListActivity.this).inflate(R.layout.f168308si, (ViewGroup) null);
                            a aVar = new a();
                            aVar.f176420a = (TextView) view.findViewById(R.id.f0v);
                            aVar.f176421b = (ProgressBar) view.findViewById(R.id.i5n);
                            aVar.f176422c = (ImageView) view.findViewById(R.id.eex);
                            view.setTag(aVar);
                        }
                    } else {
                        view = LayoutInflater.from(LikeRankingListActivity.this).inflate(R.layout.f168817aw4, (ViewGroup) null);
                        b bVar = new b();
                        bVar.f176424a = (TextView) view.findViewById(R.id.k_q);
                        bVar.f176425b = (ImageView) view.findViewById(R.id.dxi);
                        bVar.f176426c = (ImageView) view.findViewById(R.id.f165910du4);
                        bVar.f176427d = (ImageView) view.findViewById(R.id.f165909du3);
                        bVar.f176428e = (TextView) view.findViewById(R.id.k9t);
                        bVar.f176429f = (TextView) view.findViewById(R.id.kbz);
                        bVar.f176430g = (TextView) view.findViewById(R.id.k98);
                        bVar.f176431h = view.findViewById(R.id.bmt);
                        view.setTag(bVar);
                    }
                }
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        a aVar2 = (a) view.getTag();
                        TextView textView = aVar2.f176420a;
                        if (this.f176415e) {
                            i17 = R.string.c5s;
                        } else {
                            i17 = R.string.cat;
                        }
                        textView.setText(i17);
                        ProgressBar progressBar = aVar2.f176421b;
                        if (this.f176415e) {
                            i18 = 0;
                        } else {
                            i18 = 8;
                        }
                        progressBar.setVisibility(i18);
                        ImageView imageView = aVar2.f176422c;
                        if (!this.f176415e) {
                            i26 = 0;
                        }
                        imageView.setVisibility(i26);
                        if (this.f176415e) {
                            i19 = 0;
                        }
                        view.setVisibility(i19);
                    }
                } else {
                    LikeRankingInfo item = getItem(i3);
                    if (item != null) {
                        b bVar2 = (b) view.getTag();
                        bVar2.f176424a.setText(String.valueOf(i3));
                        if (i3 == 0 && item.uin == LikeRankingListActivity.this.f176387h0.uin && ((i16 = item.rankingNum) > 3 || i16 < 1)) {
                            bVar2.f176431h.setVisibility(0);
                        } else {
                            bVar2.f176431h.setVisibility(8);
                        }
                        String valueOf = String.valueOf(item.uin);
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
                        com.tencent.relation.common.bean.nameservice.a aVar3 = new com.tencent.relation.common.bean.nameservice.a();
                        aVar3.c(0);
                        aVar3.d(uidFromUin);
                        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar3);
                        if (nameWithConfig != null) {
                            bVar2.f176428e.setText(nameWithConfig);
                            Bitmap bitmapFromCache = LikeRankingListActivity.this.f176382c0.getBitmapFromCache(1, valueOf);
                            if (bitmapFromCache == null) {
                                if (!LikeRankingListActivity.this.f176382c0.isPausing()) {
                                    LikeRankingListActivity.this.f176382c0.requestDecodeFace(valueOf, 1, true);
                                }
                                bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
                            }
                            bVar2.f176427d.setImageBitmap(bitmapFromCache);
                        } else {
                            bVar2.f176428e.setText(valueOf);
                            bVar2.f176427d.setImageBitmap(BaseImageUtil.getDefaultFaceBitmap());
                        }
                        int i27 = item.rankingNum;
                        if (i27 != 1 && i27 != 2 && i27 != 3) {
                            if (i27 < 1) {
                                bVar2.f176424a.setText("-");
                            } else {
                                bVar2.f176424a.setText(String.valueOf(i27));
                            }
                            bVar2.f176425b.setVisibility(8);
                            bVar2.f176426c.setVisibility(8);
                        } else {
                            bVar2.f176424a.setText(String.valueOf(i27));
                            bVar2.f176425b.setVisibility(8);
                            bVar2.f176426c.setImageResource(this.C[item.rankingNum - 1]);
                            bVar2.f176426c.setVisibility(0);
                        }
                        SpannableString spannableString = new SpannableString(String.format(Locale.CHINA, this.f176416f, Integer.valueOf(item.likeCountOfToday)));
                        spannableString.setSpan(this.f176418i, 0, 1, 33);
                        bVar2.f176430g.setText(spannableString);
                        bVar2.f176429f.setText(String.format(Locale.CHINA, this.f176417h, Integer.valueOf(item.totalLikeCount)));
                    }
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return 2;
        }
    }

    public LikeRankingListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176384e0 = 0;
        this.f176405z0 = 0;
        this.B0 = 0L;
        this.F0 = 0;
        this.G0 = 1;
        this.I0 = new a();
        this.L0 = new b();
        this.M0 = new ProfileCardObserver() { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onGetProfileCard(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LikeRankingListActivity", 2, "onCardDownload isSuccess=" + z16);
                }
                if (z16 && (obj instanceof Card)) {
                    Card card = (Card) obj;
                    if (card.uin.equals(LikeRankingListActivity.this.f176386g0)) {
                        LikeRankingListActivity.this.app.execute(new Runnable(card) { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.3.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Card f176407d;

                            {
                                this.f176407d = card;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) card);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    LikeRankingListActivity.this.K2(this.f176407d);
                                }
                            }
                        });
                    }
                }
            }
        };
        this.N0 = new WeakReferenceHandler(this);
    }

    public static void H2(QQAppInterface qQAppInterface, String str) {
        ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m3(qQAppInterface.getCurrentAccountUin(), str, 1, 0L, (byte) 1, 0L, 0L, null, "", 8225L, 3022, null, (byte) com.tencent.mobileqq.utils.ea.x0(BaseApplicationImpl.getApplication(), qQAppInterface.getCurrentAccountUin()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(boolean z16) {
        if (z16) {
            this.f176388i0.setVisibility(0);
            this.f176389j0.setVisibility(0);
            this.f176390k0.setBackgroundResource(R.drawable.top_back_left_selector);
            this.f176390k0.setTextColor(this.f176404y0);
            this.f176391l0.setTextColor(this.f176404y0);
            return;
        }
        this.f176388i0.setVisibility(4);
        this.f176389j0.setVisibility(8);
        this.f176390k0.setBackgroundResource(R.drawable.f160368gd);
        this.f176390k0.setTextColor(this.f176403x0);
        this.f176391l0.setTextColor(this.f176403x0);
    }

    public void G2(Card card) {
        String u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) card);
            return;
        }
        String str = this.E0;
        if (str != null && str.equals(card.backgroundUrl)) {
            return;
        }
        this.F0 = 0;
        this.E0 = card.backgroundUrl;
        long j3 = card.lCurrentBgId;
        if (j3 != 160 && j3 != 1600) {
            u16 = ProfileCardManager.r(this.app.getApp(), card.lCurrentStyleId, card.lCurrentBgId);
        } else {
            u16 = ProfileCardUtil.u(card.strDrawerCardUrl);
        }
        if (QLog.isColorLevel()) {
            QLog.d("LikeRankingListActivity", 2, "updateCoverCard type personal card, path" + u16);
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(u16 + "#rank");
        if (f16 == null) {
            try {
                f16 = BaseImageUtil.decodeFileWithBufferedStream(u16, null);
                imageCacheHelper.i(u16 + "#rank", f16, Business.AIO);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, e16, new Object[0]);
                }
            }
        }
        if (f16 != null) {
            this.N0.postDelayed(new Runnable(f16) { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f176411d;

                {
                    this.f176411d = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this, (Object) f16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    LikeRankingListActivity likeRankingListActivity = LikeRankingListActivity.this;
                    UpSideDownDrawable upSideDownDrawable = new UpSideDownDrawable(likeRankingListActivity, this.f176411d, likeRankingListActivity.f176396q0.getWidth(), LikeRankingListActivity.this.f176396q0.getHeight());
                    LikeRankingListActivity.this.f176396q0.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    LikeRankingListActivity.this.f176396q0.setImageDrawable(upSideDownDrawable);
                    upSideDownDrawable.start();
                    LikeRankingListActivity.this.f176392m0.c0(false);
                }
            }, 100L);
        } else if (QLog.isColorLevel()) {
            QLog.e("LikeRankingListActivity", 2, "updateCoverCard type personal card bitmap = null, path" + u16);
        }
    }

    void J2(String str) {
        String str2 = this.f176386g0;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f176386g0 = str;
        this.F0 = 0;
        this.E0 = null;
        if (str == null) {
            this.f176392m0.c0(false);
            this.f176396q0.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f176395p0.setVisibility(4);
            this.f176398s0.setVisibility(4);
            this.f176399t0.setVisibility(4);
            this.f176397r0.setVisibility(4);
            this.f176400u0.setVisibility(4);
            this.E0 = null;
            this.F0 = 0;
            I2(true);
            return;
        }
        this.f176392m0.c0(true);
        Bitmap bitmapFromCache = this.f176382c0.getBitmapFromCache(1, str);
        if (bitmapFromCache == null) {
            if (!this.f176382c0.isPausing()) {
                this.f176382c0.requestDecodeFace(str, 1, true);
            }
            bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
        }
        this.f176395p0.setImageBitmap(bitmapFromCache);
        this.f176395p0.setVisibility(0);
        this.G0 = 1;
        this.app.execute(new Runnable(str) { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f176409d;

            {
                this.f176409d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Card r16 = LikeRankingListActivity.this.f176381b0.r(this.f176409d);
                if (r16 != null) {
                    LikeRankingListActivity.this.K2(r16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LikeRankingListActivity", 2, "update cover card = null");
                }
                LikeRankingListActivity.H2(LikeRankingListActivity.this.app, this.f176409d);
            }
        });
    }

    void K2(Card card) {
        this.N0.post(new Runnable(card) { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Card f176410d;

            {
                this.f176410d = card;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this, (Object) card);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                LikeRankingListActivity.this.f176398s0.setText(this.f176410d.strNick);
                LikeRankingListActivity.this.f176398s0.setVisibility(0);
                LikeRankingListActivity.this.f176399t0.setVisibility(0);
                LikeRankingListActivity.this.f176397r0.setVisibility(0);
                LikeRankingListActivity.this.f176400u0.setVisibility(0);
            }
        });
        if (com.tencent.util.e.h(card)) {
            if (!com.tencent.util.e.f(card)) {
                long j3 = card.lCurrentBgId;
                if (j3 != 1600 && j3 != 160 && !ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
                    this.H0 = card;
                    ((com.tencent.mobileqq.vas.ao) this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.j(this.app, VasUpdateConstants.SCID_CARD_PREFIX + card.lCurrentBgId);
                    return;
                }
                com.tencent.util.e.k(card);
                G2(card);
                return;
            }
            G2(card);
            return;
        }
        Object[] coverData = card.getCoverData(this.F0);
        String str = (String) coverData[0];
        Integer num = (Integer) coverData[1];
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("LikeRankingListActivity", 2, "[updateCover] url is null");
            }
            if (this.E0 == null && this.F0 == 0) {
                this.E0 = str;
                this.F0 = num.intValue();
                this.N0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.7
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            LikeRankingListActivity.this.f176396q0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            LikeRankingListActivity.this.f176396q0.setImageResource(R.drawable.f2v);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (str.equals(this.E0)) {
            return;
        }
        if (num.intValue() == 0 && !TextUtils.isEmpty(this.E0) && this.F0 == 0 && QLog.isColorLevel()) {
            QLog.d("LikeRankingListActivity", 2, "[updateCover] default");
        }
        this.E0 = str;
        this.F0 = num.intValue();
        this.N0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (LikeRankingListActivity.this.E0 == null) {
                    return;
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                LikeRankingListActivity likeRankingListActivity = LikeRankingListActivity.this;
                obtain.mRequestHeight = likeRankingListActivity.D0;
                obtain.mRequestWidth = likeRankingListActivity.C0;
                likeRankingListActivity.f176396q0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                LikeRankingListActivity likeRankingListActivity2 = LikeRankingListActivity.this;
                likeRankingListActivity2.f176396q0.setImageDrawable(URLDrawable.getDrawable(likeRankingListActivity2.E0, obtain));
                LikeRankingListActivity.this.f176392m0.c0(true);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        setContentView(R.layout.f168815aw2);
        if (getIntent().getIntExtra(ISelectMemberActivityConstants.PARAM_FROM, 0) == 1) {
            ReportController.o(this.app, "dc00898", "", "", "0X8007619", "0X8007619", 0, 0, "", "", "", "");
        }
        com.tencent.mobileqq.app.bk bkVar = (com.tencent.mobileqq.app.bk) this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER);
        this.f176380a0 = bkVar;
        this.f176387h0 = bkVar.a();
        this.f176381b0 = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        this.f176382c0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.f176383d0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        addObserver(this.L0);
        addObserver(this.M0);
        this.f176385f0 = this.app.getCurrentAccountUin();
        ImmersiveTitleBar2 immersiveTitleBar2 = (ImmersiveTitleBar2) findViewById(R.id.jq6);
        this.f176388i0 = immersiveTitleBar2;
        immersiveTitleBar2.setVisibility(4);
        this.f176389j0 = findViewById(R.id.joh);
        this.f176390k0 = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f176391l0 = (TextView) findViewById(R.id.ivTitleName);
        Resources resources = getResources();
        this.f176403x0 = resources.getColorStateList(R.color.bless_btn_text);
        this.f176404y0 = resources.getColorStateList(R.color.skin_bar_text);
        findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        this.C0 = ProfileCardUtil.s(this);
        this.D0 = ProfileCardUtil.q(this);
        PullToZoomListView pullToZoomListView = (PullToZoomListView) findViewById(R.id.f166156ei1);
        this.f176392m0 = pullToZoomListView;
        pullToZoomListView.setNeedCheckSpringback(true);
        this.f176392m0.setOverScrollDistance(0);
        View inflate = LayoutInflater.from(this).inflate(R.layout.f168816aw3, (ViewGroup) null);
        this.f176394o0 = inflate;
        this.f176395p0 = (ImageView) inflate.findViewById(R.id.dux);
        CircleProgress circleProgress = (CircleProgress) this.f176394o0.findViewById(R.id.duy);
        this.f176397r0 = circleProgress;
        circleProgress.setStrokeWidth(2.0f);
        this.f176397r0.setBgAndProgressColor(0, R.color.ajr, 100, 16763714);
        this.f176397r0.setProgress(100.0f);
        this.f176395p0.setOnClickListener(this);
        this.f176402w0 = this.f176394o0.findViewById(R.id.f164919bb0);
        this.f176396q0 = (ImageView) this.f176394o0.findViewById(R.id.duw);
        this.f176398s0 = (TextView) this.f176394o0.findViewById(R.id.k6x);
        this.f176399t0 = this.f176394o0.findViewById(R.id.dud);
        this.f176400u0 = this.f176394o0.findViewById(R.id.k66);
        this.f176392m0.addHeaderView(this.f176394o0);
        this.f176392m0.setHeaderImage(this.f176402w0);
        c cVar = new c();
        this.f176393n0 = cVar;
        this.f176392m0.setAdapter((ListAdapter) cVar);
        this.f176392m0.setOnScrollListener(this);
        this.f176392m0.setOnItemClickListener(this);
        this.f176401v0 = findViewById(R.id.bwv);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.A0 = (resources.getDimensionPixelSize(R.dimen.a0m) - resources.getDimensionPixelSize(R.dimen.title_bar_height)) - ((int) (displayMetrics.density * 66.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.J0 = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.J0.setInterpolator(this, android.R.anim.accelerate_interpolator);
        this.J0.setAnimationListener(this);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.K0 = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.K0.setInterpolator(this, android.R.anim.accelerate_interpolator);
        this.K0.setAnimationListener(this);
        LikeRankingInfo likeRankingInfo = this.f176387h0;
        if (likeRankingInfo.rankingNum == 1 && likeRankingInfo.likeCountOfToday > 0) {
            J2(this.f176385f0);
        }
        List<LikeRankingInfo> d16 = this.f176380a0.d();
        if (d16 != null && d16.size() > 0) {
            J2(String.valueOf(d16.get(0).uin));
            this.f176393n0.b(d16, false);
        } else {
            J2(null);
        }
        c cVar2 = this.f176393n0;
        cVar2.f176415e = true;
        cVar2.notifyDataSetChanged();
        this.f176383d0.R4(this.f176385f0, this.f176384e0, 500);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.LikeRankingListActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LikeRankingListActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) LikeRankingListActivity.this.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                RedTouchItem j3 = localRedTouchManager.j(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
                if (localRedTouchManager.d(j3, false)) {
                    RedTouchItem j16 = localRedTouchManager.j(-7);
                    if (localRedTouchManager.d(j16, true) && j16.receiveTime == j3.receiveTime) {
                        j16.unReadFlag = false;
                    }
                    localRedTouchManager.u(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
                }
            }
        }, 5, null, false);
        ((IVasQuickUpdateService) this.app.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.I0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver(this.L0);
        removeObserver(this.M0);
        IFaceDecoder iFaceDecoder = this.f176382c0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        ((IVasQuickUpdateService) this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.I0);
        LeakUtil.removeLeakOn_SpenGestureManager(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what != 1) {
            return false;
        }
        this.B0 = SystemClock.uptimeMillis();
        this.f176393n0.notifyDataSetChanged();
        return true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animation);
            return;
        }
        if (animation == this.K0) {
            I2(false);
        }
        this.f176388i0.clearAnimation();
        this.f176389j0.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
        } else if (animation == this.J0) {
            I2(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                finish();
            } else if (id5 == R.id.dux) {
                if (this.f176387h0 != null && this.f176385f0.equals(this.f176386g0)) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(this.app, "dc00898", "", "", "0X8007615", "0X8007615", 0, 0, str, "", "", "");
                ProfileUtils.openProfileCard(this, new AllInOne(this.f176386g0, 1));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LikeRankingListActivity", 2, "onDecodeTaskCompleted, remainingTasks= " + i3 + " ,type= " + i16 + ", uin= " + str + ", avatar= " + bitmap);
        }
        if (str.equals(this.f176386g0)) {
            this.f176395p0.setImageBitmap(bitmap);
        }
        if (bitmap == null && i3 > 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.B0;
        this.N0.removeMessages(1);
        if (uptimeMillis >= 800) {
            this.B0 = SystemClock.uptimeMillis();
            this.f176393n0.notifyDataSetChanged();
        } else {
            this.N0.sendEmptyMessageDelayed(1, 800 - uptimeMillis);
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        String valueOf;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (i3 == 0) {
            return;
        }
        int i16 = i3 - 1;
        if (this.f176384e0 == -1 || i16 != this.f176393n0.getCount() - 1) {
            if (i16 == -1) {
                valueOf = this.f176386g0;
            } else {
                LikeRankingInfo item = this.f176393n0.getItem(i16);
                if (item == null) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(item.uin);
                }
            }
            if (!TextUtils.isEmpty(valueOf)) {
                if (this.f176387h0 != null && this.f176385f0.equals(valueOf)) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(this.app, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, str, "", "", "");
                ProfileUtils.openProfileCard(this, new AllInOne(valueOf, 1));
            }
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        AlphaAnimation alphaAnimation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        View childAt = this.f176392m0.getChildAt(0);
        if (childAt != null && i3 == 0) {
            int abs = Math.abs(childAt.getTop());
            if (abs > this.f176405z0 && abs >= this.A0 && this.f176389j0.getVisibility() == 8) {
                alphaAnimation = this.J0;
            } else if (abs < this.f176405z0 && abs <= this.A0 && this.f176389j0.getVisibility() == 0) {
                alphaAnimation = this.K0;
            } else {
                alphaAnimation = null;
            }
            if (alphaAnimation != null && alphaAnimation != this.f176389j0.getAnimation()) {
                alphaAnimation.reset();
                this.f176389j0.startAnimation(alphaAnimation);
                this.f176388i0.startAnimation(alphaAnimation);
            }
            this.f176405z0 = abs;
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) absListView, i3);
        }
    }
}
