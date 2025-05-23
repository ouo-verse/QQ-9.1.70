package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import cooperation.qzone.model.CoverCacheData;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class VipPhotoViewForSimple extends LinearLayout implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    public static float f260495a0;
    private int C;
    public List<QzonePhotoView.d> D;
    private boolean E;
    CoverCacheData F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int P;
    public float Q;
    public GridView R;
    private ImageView S;
    private View T;
    public HorizontalScrollView U;
    private ITemplateUtils V;
    private View.OnClickListener W;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f260496d;

    /* renamed from: e, reason: collision with root package name */
    View f260497e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f260498f;

    /* renamed from: h, reason: collision with root package name */
    private ProfileCardInfo f260499h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f260500i;

    /* renamed from: m, reason: collision with root package name */
    private String f260501m;

    /* loaded from: classes16.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f260502d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipPhotoViewForSimple.this);
            } else {
                this.f260502d = 0L;
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
                if (Math.abs(currentTimeMillis - this.f260502d) >= 1000) {
                    this.f260502d = currentTimeMillis;
                    if (view != null && (view.getTag() instanceof com.tencent.mobileqq.profile.b) && (bVar = (com.tencent.mobileqq.profile.b) view.getTag()) != null) {
                        int i3 = bVar.f260135a;
                        String str = VipPhotoViewForSimple.this.f260499h.allInOne.uin;
                        if (i3 == 25) {
                            if (QLog.isColorLevel()) {
                                QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "View.OnClickListener click type is photo wall view");
                            }
                            ReportController.o(VipPhotoViewForSimple.this.f260496d, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "1", "", "", "");
                            VipPhotoViewForSimple vipPhotoViewForSimple = VipPhotoViewForSimple.this;
                            vipPhotoViewForSimple.j(vipPhotoViewForSimple.E);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes16.dex */
    public class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Context f260504d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f260505e;

        /* renamed from: f, reason: collision with root package name */
        List<QzonePhotoView.d> f260506f;

        /* loaded from: classes16.dex */
        class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            URLImageView f260508a;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }
        }

        public b(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipPhotoViewForSimple.this, (Object) context);
                return;
            }
            this.f260505e = null;
            this.f260504d = context;
            this.f260505e = LayoutInflater.from(context);
        }

        public void a(List<QzonePhotoView.d> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            this.f260506f = list;
            int size = list.size();
            if (size < 16) {
                if (VipPhotoViewForSimple.this.E) {
                    this.f260506f.add(new QzonePhotoView.d(list.size(), 101, null));
                }
            } else {
                int i3 = size - 1;
                QzonePhotoView.d dVar = this.f260506f.get(i3);
                dVar.f260420f = 102;
                this.f260506f.set(i3, dVar);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            List<QzonePhotoView.d> list = this.f260506f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            List<QzonePhotoView.d> list = this.f260506f;
            if (list != null) {
                return list.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        @TargetApi(16)
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            View view3;
            View view4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view3 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view4 = view;
            } else {
                QzonePhotoView.d dVar = this.f260506f.get(i3);
                URL url = null;
                if (view == null) {
                    aVar = new a();
                    view2 = this.f260505e.inflate(R.layout.bet, (ViewGroup) null);
                    VipPhotoViewForSimple vipPhotoViewForSimple = VipPhotoViewForSimple.this;
                    view2.setLayoutParams(new AbsListView.LayoutParams(vipPhotoViewForSimple.I, vipPhotoViewForSimple.J));
                    aVar.f260508a = (URLImageView) view2.findViewById(R.id.h7_);
                    view2.setTag(aVar);
                } else {
                    view2 = view;
                    aVar = (a) view.getTag();
                }
                aVar.f260508a.setTag(new com.tencent.mobileqq.profile.b(25, Integer.valueOf(i3)));
                aVar.f260508a.setOnClickListener(VipPhotoViewForSimple.this.W);
                if (dVar != null) {
                    int i16 = dVar.f260420f;
                    if (i16 != 100 && i16 != 102) {
                        if (i16 == 101) {
                            aVar.f260508a.setScaleType(ImageView.ScaleType.CENTER);
                            VipPhotoViewForSimple.this.V.updateViewAttr(aVar.f260508a, "src", VipPhotoViewForSimple.this.f260499h.currentTemplate, "simpleGridAddSrc");
                            aVar.f260508a.setContentDescription(HardCodeUtil.qqStr(R.string.vgk));
                        }
                    } else {
                        view2.setBackground(null);
                        aVar.f260508a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        try {
                            String a16 = dVar.a();
                            if (a16 != null) {
                                url = new URL(IProfileCardConst.PROTOCOL_QZONE_COVER, "original", a16);
                            }
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(LogTag.QZONE_COVER, 2, e16.toString());
                            }
                        }
                        if (url != null) {
                            URLImageView uRLImageView = aVar.f260508a;
                            VipPhotoViewForSimple vipPhotoViewForSimple2 = VipPhotoViewForSimple.this;
                            uRLImageView.setImageDrawable(URLDrawable.getDrawable(url, vipPhotoViewForSimple2.I, vipPhotoViewForSimple2.J));
                        }
                        aVar.f260508a.setContentDescription(HardCodeUtil.qqStr(R.string.vgj) + (i3 + 1));
                    }
                }
                view3 = view2;
                view4 = view3;
            }
            EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
            return view3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f260495a0 = 1.43f;
        }
    }

    public VipPhotoViewForSimple(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = false;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = -1;
        this.P = -1;
        this.Q = 1.5f;
        this.W = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z16) {
        String str = IProfileCardConst.URL_PHOTO_WALL;
        if (!z16) {
            str = str + "&uin=" + this.f260501m;
        }
        Intent intent = new Intent(this.f260498f, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", str);
        if (!z16) {
            this.f260498f.startActivity(intent);
        } else {
            this.f260498f.startActivityForResult(intent, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<QzonePhotoView.d> l(String str, List<Map<Integer, String>> list) {
        int i3;
        LinkedList linkedList = new LinkedList();
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "update|type = " + str + "|vecUrls = " + list);
        }
        if (this.F == null) {
            this.F = new CoverCacheData();
        }
        CoverCacheData coverCacheData = this.F;
        coverCacheData.type = str;
        coverCacheData.photoWall = (ArrayList) list;
        coverCacheData.uin = Long.parseLong(this.f260501m);
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        for (int i16 = 0; i16 < i3 && i16 < 16; i16++) {
            Map<Integer, String> map = list.get(i16);
            if (map != null) {
                QzonePhotoView.d dVar = new QzonePhotoView.d(i16, 100, map);
                dVar.f260419e = linkedList.size();
                dVar.f260418d = i16;
                linkedList.add(dVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverData photoInfo size=" + linkedList.size());
        }
        return linkedList;
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
                        QLog.d("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
                    }
                    ((PhotoWallHandler) this.f260496d.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.f260501m, "");
                    this.f260500i.removeMessages(201);
                    return false;
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_UPDATE_PHOTO_VIEW");
            }
            Object obj = message.obj;
            if (obj instanceof LinkedList) {
                m((List) obj);
            }
            this.f260500i.sendEmptyMessage(201);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
        }
        CardHandler cardHandler = (CardHandler) this.f260496d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            cardHandler.h3(this.f260501m, 2);
            this.C++;
        }
        this.f260500i.removeMessages(100);
        return false;
    }

    @TargetApi(9)
    public void i(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) profileCardInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
        }
        this.f260496d = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.f260498f = qBaseActivity;
        this.f260499h = profileCardInfo;
        this.f260500i = new Handler(this);
        this.f260501m = profileCardInfo.allInOne.uin;
        View inflate = LayoutInflater.from(this.f260496d.getApplication()).inflate(R.layout.ber, (ViewGroup) this, true);
        this.f260497e = inflate;
        this.R = (GridView) inflate.findViewById(R.id.fqh);
        this.U = (HorizontalScrollView) this.f260497e.findViewById(R.id.fqi);
        this.S = (ImageView) this.f260497e.findViewById(R.id.g1c);
        this.T = this.f260497e.findViewById(R.id.h77);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        this.G = i3;
        this.H = displayMetrics.heightPixels;
        int i16 = (int) (i3 / this.Q);
        this.I = i16;
        this.L = i16;
        this.J = (int) (i16 / f260495a0);
        this.N = getResources().getDimensionPixelSize(R.dimen.f159505an4);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159504an3);
        this.P = dimensionPixelSize;
        this.M = this.J + this.N + dimensionPixelSize;
        this.K = getResources().getDimensionPixelSize(R.dimen.an5);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.E = z16;
        if (VersionUtils.isGingerBread()) {
            this.U.setOverScrollMode(2);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profile.view.VipPhotoViewForSimple.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipPhotoViewForSimple.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QZonePhotoWall qZonePhotoWall = (QZonePhotoWall) DBMethodProxy.find(VipPhotoViewForSimple.this.f260496d.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) QZonePhotoWall.class, VipPhotoViewForSimple.this.f260501m);
                if (qZonePhotoWall != null) {
                    ArrayList<PhotoWall> unpackPhotoWallData = qZonePhotoWall.unpackPhotoWallData();
                    ArrayList arrayList = new ArrayList();
                    for (int i17 = 0; i17 < unpackPhotoWallData.size(); i17++) {
                        arrayList.add(unpackPhotoWallData.get(i17).photoUrls);
                    }
                    List l3 = VipPhotoViewForSimple.this.l("", arrayList);
                    Message obtain = Message.obtain();
                    obtain.what = 200;
                    obtain.obj = l3;
                    VipPhotoViewForSimple.this.f260500i.sendMessage(obtain);
                    return;
                }
                VipPhotoViewForSimple.this.f260500i.sendEmptyMessage(201);
            }
        }, 8, null, true);
        Message obtain = Message.obtain();
        obtain.what = 100;
        this.f260500i.sendMessage(obtain);
    }

    public void k(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover|isSuc = " + z16 + ",uin=" + str + ",mUin=" + this.f260501m);
        }
        if (!Utils.p(str, this.f260501m)) {
            return;
        }
        if (z16 && mobile_sub_get_photo_wall_rspVar != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < mobile_sub_get_photo_wall_rspVar.vecUrls.size(); i3++) {
                arrayList.add(mobile_sub_get_photo_wall_rspVar.vecUrls.get(i3).photoUrls);
            }
            List<QzonePhotoView.d> l3 = l("", arrayList);
            QzonePhotoView.d dVar = null;
            QzonePhotoView.d dVar2 = null;
            int i16 = 0;
            while (true) {
                if (i16 < 16) {
                    List<QzonePhotoView.d> list = this.D;
                    if (list != null && list.size() > i16) {
                        dVar = this.D.get(i16);
                    } else {
                        dVar = null;
                    }
                    if (l3 != null && l3.size() > i16) {
                        dVar2 = l3.get(i16);
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
                QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(z17));
            }
            if (z17 || (dVar == null && dVar2 == null)) {
                m(l3);
                return;
            }
            return;
        }
        if (NetworkUtil.isWifiEnabled(BaseApplication.getContext()) && this.C < 3) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            this.f260500i.sendMessage(obtain);
        }
    }

    public void m(List<QzonePhotoView.d> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel() && list != null) {
            QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updatePhotoView photoInfo size=" + list.size());
        }
        this.D = list;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            this.R.setPadding(0, this.N, 0, this.P);
            this.R.setColumnWidth(this.I);
            this.R.setStretchMode(0);
            this.R.setHorizontalSpacing(this.K);
            b bVar = new b(this.f260498f);
            bVar.a(list);
            int size = list.size();
            this.R.setLayoutParams(new LinearLayout.LayoutParams((this.I + this.K) * size, this.M));
            this.R.setNumColumns(size);
            this.R.setAdapter((ListAdapter) bVar);
            this.S.setVisibility(8);
            this.T.setVisibility(8);
            this.R.setVisibility(0);
            setVisibility(0);
            return;
        }
        if (this.E) {
            this.V.updateViewAttr(this.S, "src", this.f260499h.currentTemplate, "simpleAddSrc");
            this.S.setTag(new com.tencent.mobileqq.profile.b(25, null));
            this.S.setOnClickListener(this.W);
            this.S.setVisibility(0);
            this.T.setVisibility(0);
            this.R.setVisibility(8);
            setVisibility(0);
            return;
        }
        this.S.setVisibility(8);
        this.T.setVisibility(8);
        setVisibility(8);
    }

    public void setTemplateUtils(ITemplateUtils iTemplateUtils) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iTemplateUtils);
        } else {
            this.V = iTemplateUtils;
        }
    }

    public VipPhotoViewForSimple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = false;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = -1;
        this.P = -1;
        this.Q = 1.5f;
        this.W = new a();
    }
}
