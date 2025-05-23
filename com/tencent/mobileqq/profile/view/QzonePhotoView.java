package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewConfigurationCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterViewPagerAdapter;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.XListView;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class QzonePhotoView extends LinearLayout implements Handler.Callback, XListView.MotionEventInterceptor {
    static IPatchRedirector $redirector_;
    CoverCacheData C;
    private boolean D;
    private Activity E;
    private ProfileCardInfo F;
    private Handler G;
    private String H;
    private int I;
    private List<d> J;
    private int[] K;
    private int[] L;
    private int M;
    private int N;
    private ImageView P;
    private View Q;
    private ITemplateUtils R;
    private View.OnClickListener S;
    public boolean T;
    private float U;
    private float V;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f260400d;

    /* renamed from: e, reason: collision with root package name */
    View f260401e;

    /* renamed from: f, reason: collision with root package name */
    private float f260402f;

    /* renamed from: h, reason: collision with root package name */
    private int f260403h;

    /* renamed from: i, reason: collision with root package name */
    private int f260404i;

    /* renamed from: m, reason: collision with root package name */
    private int f260405m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements AdapterViewPagerAdapter.AdapterViewFactory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzonePhotoView.this);
            }
        }

        @Override // com.tencent.widget.AdapterViewPagerAdapter.AdapterViewFactory
        public AdapterView create(Context context, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AdapterView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            }
            GridView gridView = null;
            try {
                GridView gridView2 = new GridView(context);
                try {
                    gridView2.setNumColumns(4);
                    gridView2.setFadingEdgeLength(0);
                    gridView2.setHorizontalSpacing(QzonePhotoView.this.f260405m);
                    gridView2.setVerticalSpacing(QzonePhotoView.this.f260405m);
                    gridView2.setStretchMode(2);
                    gridView2.setScrollingCacheEnabled(false);
                    gridView2.setSelector(R.color.ajr);
                    ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
                    layoutParams.gravity = 17;
                    ((ViewGroup.LayoutParams) layoutParams).height = -2;
                    ((ViewGroup.LayoutParams) layoutParams).width = -1;
                    gridView2.setLayoutParams(layoutParams);
                    return gridView2;
                } catch (OutOfMemoryError e16) {
                    e = e16;
                    gridView = gridView2;
                    if (QLog.isColorLevel()) {
                        QLog.e("ProfileCard.QzonePhotoView", 2, "new gridview error", e);
                    }
                    return gridView;
                }
            } catch (OutOfMemoryError e17) {
                e = e17;
            }
        }
    }

    /* loaded from: classes16.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f260407d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzonePhotoView.this);
            } else {
                this.f260407d = 0L;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.profile.b bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f260407d) >= 1000) {
                    this.f260407d = currentTimeMillis;
                    if (view != null && (view.getTag() instanceof com.tencent.mobileqq.profile.b) && (bVar = (com.tencent.mobileqq.profile.b) view.getTag()) != null) {
                        int i3 = bVar.f260135a;
                        String str = QzonePhotoView.this.F.allInOne.uin;
                        if (i3 == 25) {
                            ReportController.o(QzonePhotoView.this.f260400d, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "2", "", "", "");
                            if (QLog.isColorLevel()) {
                                QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
                            }
                            QzonePhotoView qzonePhotoView = QzonePhotoView.this;
                            qzonePhotoView.k(qzonePhotoView.D);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<d> f260409d;

        /* renamed from: e, reason: collision with root package name */
        int f260410e;

        /* renamed from: f, reason: collision with root package name */
        int f260411f;

        /* loaded from: classes16.dex */
        public class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            URLImageView f260413a;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzonePhotoView.this);
            }
        }

        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f260410e = i3;
                this.f260411f = i16;
            }
        }

        public void b(List<d> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            this.f260409d = list;
            int size = list.size();
            if (size < 16) {
                if (QzonePhotoView.this.D) {
                    this.f260409d.add(new d(list.size(), 101, null));
                }
            } else {
                int i3 = size - 1;
                d dVar = this.f260409d.get(i3);
                dVar.f260420f = 102;
                this.f260409d.set(i3, dVar);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            List<d> list = this.f260409d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            List<d> list = this.f260409d;
            if (list != null) {
                return list.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = view;
                view = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                d dVar = this.f260409d.get(i3);
                if (view == null) {
                    a aVar = new a();
                    RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(QzonePhotoView.this.getContext()).inflate(R.layout.bet, (ViewGroup) null);
                    int i16 = this.f260410e;
                    relativeLayout.setLayoutParams(new AbsListView.LayoutParams(i16, i16));
                    URLImageView uRLImageView = (URLImageView) relativeLayout.findViewById(R.id.h7_);
                    aVar.f260413a = uRLImageView;
                    uRLImageView.setTag(new com.tencent.mobileqq.profile.b(25, Integer.valueOf(i3)));
                    String e16 = ProfileCardTemplateUtil.e(-1L);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestHeight = this.f260411f;
                    int i17 = this.f260410e;
                    obtain.mRequestWidth = i17;
                    String c16 = dVar.c(i17);
                    int i18 = dVar.f260420f;
                    if (i18 == 100) {
                        if (!TextUtils.isEmpty(c16)) {
                            aVar.f260413a.setImageDrawable(URLDrawable.getDrawable(c16, obtain));
                            aVar.f260413a.setContentDescription(HardCodeUtil.qqStr(R.string.s3h) + (i3 + 1));
                        }
                    } else if (i18 == 101) {
                        QzonePhotoView.this.R.updateViewAttr(aVar.f260413a, "src", QzonePhotoView.this.F.currentTemplate, "photoAddSrc");
                        aVar.f260413a.setContentDescription(HardCodeUtil.qqStr(R.string.s3b));
                    } else if (i18 == 102) {
                        if (!TextUtils.isEmpty(e16)) {
                            aVar.f260413a.setImageDrawable(URLDrawable.getDrawable(new File(e16, "qvip_profile_photo_more.png"), obtain));
                        }
                        if (!TextUtils.isEmpty(c16)) {
                            aVar.f260413a.setBackgroundDrawable(URLDrawable.getDrawable(c16, obtain));
                        }
                        aVar.f260413a.setContentDescription(HardCodeUtil.qqStr(R.string.s3k));
                    }
                    aVar.f260413a.setOnClickListener(QzonePhotoView.this.S);
                    relativeLayout.setTag(aVar);
                    view = relativeLayout;
                }
                view2 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* loaded from: classes16.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f260415a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, String> f260416b;

        /* renamed from: c, reason: collision with root package name */
        public int f260417c;

        /* renamed from: d, reason: collision with root package name */
        public int f260418d;

        /* renamed from: e, reason: collision with root package name */
        public int f260419e;

        /* renamed from: f, reason: collision with root package name */
        public int f260420f;

        public d(int i3, int i16, Map<Integer, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), map);
                return;
            }
            this.f260417c = 0;
            this.f260416b = map;
            this.f260415a = null;
            this.f260420f = i16;
            if (map != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                for (int i17 = 0; i17 <= 4; i17++) {
                    String str = this.f260416b.get(Integer.valueOf(i17));
                    if (str != null) {
                        sb5.append(str);
                    }
                }
                String sb6 = sb5.toString();
                this.f260415a = sb6;
                if (!TextUtils.isEmpty(sb6)) {
                    this.f260415a = MD5.toMD5(this.f260415a);
                }
            }
        }

        private String b(int i3) {
            String str = null;
            for (int i16 = 1; TextUtils.isEmpty(str) && i16 < 5; i16++) {
                str = this.f260416b.get(Integer.valueOf((i3 + i16) % 5));
            }
            return str;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Map<Integer, String> map = this.f260416b;
            if (map != null) {
                String str = map.get(1);
                if (TextUtils.isEmpty(str)) {
                    return b(1);
                }
                return str;
            }
            return null;
        }

        public String c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            Map<Integer, String> map = this.f260416b;
            if (map != null) {
                if (i3 <= 100) {
                    i16 = 3;
                }
                String str = map.get(Integer.valueOf(i16));
                if (TextUtils.isEmpty(str)) {
                    return b(i16);
                }
                return str;
            }
            return null;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof d) {
                return Utils.p(((d) obj).f260415a, this.f260415a);
            }
            return false;
        }
    }

    public QzonePhotoView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = false;
        this.K = new int[2];
        this.L = new int[2];
        this.S = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z16) {
        String str = IProfileCardConst.URL_PHOTO_WALL;
        if (!z16) {
            str = str + "&uin=" + this.H;
        }
        Intent intent = new Intent(this.E, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", str);
        if (!z16) {
            this.E.startActivity(intent);
        } else {
            this.E.startActivityForResult(intent, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> n(String str, List<Map<Integer, String>> list) {
        int i3;
        LinkedList linkedList = new LinkedList();
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.QzonePhotoView", 2, "update|type = " + str + "|vecUrls = " + list);
        }
        if (this.C == null) {
            this.C = new CoverCacheData();
        }
        CoverCacheData coverCacheData = this.C;
        coverCacheData.type = str;
        coverCacheData.photoWall = (ArrayList) list;
        coverCacheData.uin = Long.parseLong(this.H);
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        for (int i16 = 0; i16 < i3 && i16 < 16; i16++) {
            Map<Integer, String> map = list.get(i16);
            if (map != null) {
                d dVar = new d(i16, 100, map);
                dVar.f260419e = linkedList.size();
                linkedList.add(dVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverData photoInfo size=" + linkedList.size());
        }
        return linkedList;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.P.getVisibility() == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 != 200) {
                if (i3 == 201) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.QzonePhotoView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
                    }
                    ((PhotoWallHandler) this.f260400d.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.H, "");
                    this.G.removeMessages(201);
                    return false;
                }
                return false;
            }
            Object obj = message.obj;
            if (obj instanceof LinkedList) {
                o((List) obj);
            }
            this.G.sendEmptyMessage(201);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
        }
        CardHandler cardHandler = (CardHandler) this.f260400d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            cardHandler.h3(this.H, 2);
            this.I++;
        }
        this.G.removeMessages(100);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (r1 != 3) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b  */
    @Override // com.tencent.widget.XListView.MotionEventInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean intercept(View view, MotionEvent motionEvent) {
        boolean z16;
        int action;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        ViewPager viewPager = (ViewPager) this.f260401e.findViewById(R.id.foc);
        view.getLocationInWindow(this.K);
        viewPager.getLocationInWindow(this.L);
        float rawY = motionEvent.getRawY();
        if (viewPager.getVisibility() == 0) {
            if (rawY >= this.L[1] && rawY < r1 + viewPager.getHeight()) {
                z16 = true;
                motionEvent.offsetLocation(0.0f, this.K[1] - this.L[1]);
                action = motionEvent.getAction();
                if (action == 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (z16) {
                                if (this.T && this.N == 0) {
                                    float abs = Math.abs(motionEvent.getX() - this.U);
                                    float abs2 = Math.abs(motionEvent.getY() - this.V);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ProfileCard.QzonePhotoView", 2, "Action move curX = " + motionEvent.getX() + " xDiff = " + abs + " mTouchSlop = " + this.M);
                                    }
                                    int i3 = this.M;
                                    if (abs > i3 && abs * 0.5f > abs2) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ProfileCard.QzonePhotoView", 2, "Action move beginDragged ");
                                        }
                                        this.N = 1;
                                    } else if (abs2 > i3) {
                                        this.T = false;
                                    }
                                } else if (-1 == this.N) {
                                    return false;
                                }
                                z17 = this.T;
                                if (QLog.isColorLevel()) {
                                    QLog.d("ProfileCard.QzonePhotoView", 2, "Action move touchHappened =  " + z17);
                                }
                                if (z17) {
                                    try {
                                        boolean dispatchTouchEvent = viewPager.dispatchTouchEvent(motionEvent);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ProfileCard.QzonePhotoView", 2, "photo pager dispatchTouchvent ret = " + dispatchTouchEvent);
                                        }
                                        if (motionEvent.getAction() != 0 && z17 && dispatchTouchEvent) {
                                            return true;
                                        }
                                        return false;
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                    }
                                }
                                return false;
                            }
                            if (1 == this.N) {
                                this.N = -1;
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                        return false;
                    }
                    z17 = this.T;
                    if (z17) {
                        this.T = false;
                        this.N = 0;
                    }
                    if (z17) {
                    }
                    return false;
                }
                if (z16) {
                    this.T = true;
                    this.N = 0;
                    this.U = motionEvent.getX();
                    this.V = motionEvent.getY();
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.QzonePhotoView", 2, "Action down mInitialMotionX = " + this.U);
                    }
                    z17 = true;
                    if (z17) {
                    }
                    return false;
                }
                z17 = false;
                if (z17) {
                }
                return false;
            }
        }
        z16 = false;
        motionEvent.offsetLocation(0.0f, this.K[1] - this.L[1]);
        action = motionEvent.getAction();
        if (action == 0) {
        }
    }

    public void j(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) profileCardInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
        }
        this.f260400d = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.E = qBaseActivity;
        this.F = profileCardInfo;
        this.G = new Handler(this);
        boolean z16 = false;
        this.I = 0;
        this.H = profileCardInfo.allInOne.uin;
        this.f260401e = LayoutInflater.from(this.f260400d.getApplication()).inflate(R.layout.bes, (ViewGroup) this, true);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f260402f = displayMetrics.density;
        this.f260403h = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159502an1);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f159501an0);
        this.f260405m = dimensionPixelSize2;
        this.f260404i = ((this.f260403h - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 3)) / 4;
        if (profileCardInfo.allInOne.f260789pa == 0) {
            z16 = true;
        }
        this.D = z16;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profile.view.QzonePhotoView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QzonePhotoView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QZonePhotoWall qZonePhotoWall = (QZonePhotoWall) DBMethodProxy.find(QzonePhotoView.this.f260400d.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) QZonePhotoWall.class, QzonePhotoView.this.H);
                if (qZonePhotoWall != null) {
                    ArrayList<PhotoWall> unpackPhotoWallData = qZonePhotoWall.unpackPhotoWallData();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < unpackPhotoWallData.size(); i3++) {
                        arrayList.add(unpackPhotoWallData.get(i3).photoUrls);
                    }
                    new LinkedList();
                    List n3 = QzonePhotoView.this.n("", arrayList);
                    Message obtain = Message.obtain();
                    obtain.what = 200;
                    obtain.obj = n3;
                    QzonePhotoView.this.G.sendMessage(obtain);
                    return;
                }
                QzonePhotoView.this.G.sendEmptyMessage(201);
            }
        }, 8, null, true);
        Message obtain = Message.obtain();
        obtain.what = 100;
        this.G.sendMessage(obtain);
        this.M = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(qBaseActivity));
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.G.removeCallbacksAndMessages(null);
        }
    }

    public void m(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover|isSuc = " + z16 + ",uin=" + str + ",mUin=" + this.H);
        }
        if (!Utils.p(str, this.H)) {
            return;
        }
        if (z16 && mobile_sub_get_photo_wall_rspVar != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < mobile_sub_get_photo_wall_rspVar.vecUrls.size(); i3++) {
                arrayList.add(mobile_sub_get_photo_wall_rspVar.vecUrls.get(i3).photoUrls);
            }
            List<d> n3 = n("", arrayList);
            d dVar = null;
            d dVar2 = null;
            int i16 = 0;
            while (true) {
                if (i16 < 16) {
                    List<d> list = this.J;
                    if (list != null && list.size() > i16) {
                        dVar = this.J.get(i16);
                    } else {
                        dVar = null;
                    }
                    if (n3 != null && n3.size() > i16) {
                        dVar2 = n3.get(i16);
                    } else {
                        dVar2 = null;
                    }
                    if (!Utils.p(dVar, dVar2)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(z17));
            }
            if (z17 || (dVar == null && dVar2 == null)) {
                o(n3);
                return;
            }
            return;
        }
        if (NetworkUtil.isWifiEnabled(BaseApplication.getContext()) && this.I < 3) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            this.G.sendMessage(obtain);
        }
    }

    public void o(List<d> list) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        try {
            if (QLog.isColorLevel() && list != null) {
                QLog.i("ProfileCard.QzonePhotoView", 2, "updatePhotoView photoInfo size=" + list.size());
            }
            this.J = list;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            this.P = (ImageView) this.f260401e.findViewById(R.id.g1c);
            View findViewById = this.f260401e.findViewById(R.id.h77);
            this.Q = findViewById;
            findViewById.setTag(new com.tencent.mobileqq.profile.b(25, null));
            this.Q.setOnClickListener(this.S);
            String e16 = ProfileCardTemplateUtil.e(-1L);
            if (!TextUtils.isEmpty(e16)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int j3 = ProfileCardUtil.j(getContext(), 188);
                obtain.mRequestHeight = j3;
                obtain.mRequestWidth = (int) Math.ceil(((j3 * 1.0d) / 376.0d) * 640.0d);
                obtain.mLoadingDrawable = new ColorDrawable(getResources().getColor(R.color.f156896el));
                URLDrawable drawable = URLDrawable.getDrawable(new File(e16, "qvip_profile_photo_black_addimage_tips.png"), obtain);
                drawable.setBounds(0, 0, obtain.mRequestWidth, obtain.mRequestHeight);
                this.P.setImageDrawable(drawable);
            }
            this.P.setTag(new com.tencent.mobileqq.profile.b(25, null));
            this.P.setOnClickListener(this.S);
            ViewPager viewPager = (ViewPager) this.f260401e.findViewById(R.id.foc);
            CirclePageIndicator circlePageIndicator = (CirclePageIndicator) this.f260401e.findViewById(R.id.fhp);
            if (i3 > 0) {
                c cVar = new c();
                cVar.b(list);
                int i17 = this.f260404i;
                cVar.a(i17, i17);
                AdapterViewPagerAdapter adapterViewPagerAdapter = new AdapterViewPagerAdapter(getContext(), cVar, 8);
                adapterViewPagerAdapter.setAdapterViewFactory(new a());
                ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
                layoutParams.width = this.f260403h;
                if (cVar.getCount() > 4) {
                    i16 = (this.f260404i * 2) + this.f260405m;
                } else {
                    i16 = this.f260405m + this.f260404i;
                }
                layoutParams.height = i16;
                viewPager.setLayoutParams(layoutParams);
                viewPager.setAdapter(adapterViewPagerAdapter);
                int f373114d = adapterViewPagerAdapter.getF373114d();
                circlePageIndicator.setViewPager(viewPager);
                this.P.setVisibility(8);
                this.Q.setVisibility(8);
                viewPager.setVisibility(0);
                if (f373114d > 1) {
                    circlePageIndicator.setVisibility(0);
                } else {
                    circlePageIndicator.setVisibility(8);
                }
                setVisibility(0);
                return;
            }
            if (this.D) {
                this.P.setVisibility(0);
                this.Q.setVisibility(0);
                viewPager.setVisibility(8);
                circlePageIndicator.setVisibility(8);
                setVisibility(0);
                return;
            }
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            setVisibility(8);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void setTemplateUtils(ITemplateUtils iTemplateUtils) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iTemplateUtils);
        } else {
            this.R = iTemplateUtils;
        }
    }

    public QzonePhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = false;
        this.K = new int[2];
        this.L = new int[2];
        this.S = new b();
    }
}
