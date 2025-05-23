package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.em;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements DecodeTaskCompletionListener {
    boolean C;

    /* renamed from: d, reason: collision with root package name */
    Activity f80105d;

    /* renamed from: e, reason: collision with root package name */
    public IFaceDecoder f80106e;

    /* renamed from: f, reason: collision with root package name */
    protected List<d> f80107f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f80108h;

    /* renamed from: i, reason: collision with root package name */
    private c f80109i;

    /* renamed from: m, reason: collision with root package name */
    boolean f80110m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public View f80111a;

        /* renamed from: b, reason: collision with root package name */
        public View f80112b;

        /* renamed from: c, reason: collision with root package name */
        public View f80113c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f80114d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f80115e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f80116f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f80117g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f80118h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f80119i;

        /* renamed from: j, reason: collision with root package name */
        public Button f80120j;

        /* renamed from: k, reason: collision with root package name */
        public ImageView f80121k;

        /* renamed from: l, reason: collision with root package name */
        public com.tencent.biz.pubaccount.subscript.d f80122l;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.pubaccount.subscript.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class ViewOnClickListenerC0818a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f80124d;

            ViewOnClickListenerC0818a(e eVar) {
                this.f80124d = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activity;
                Activity activity2;
                EventCollector.getInstance().onViewClickedBefore(view);
                ReportController.o(e.this.f80108h, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
                a aVar = a.this;
                com.tencent.biz.pubaccount.subscript.d dVar = aVar.f80122l;
                if (dVar != null) {
                    ReportController.o(e.this.f80108h, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(dVar.f80098a), "", "", "");
                }
                com.tencent.biz.pubaccount.subscript.d dVar2 = a.this.f80122l;
                if (dVar2 != null) {
                    String valueOf = String.valueOf(dVar2.f80098a);
                    if (!TextUtils.isEmpty(valueOf)) {
                        a aVar2 = a.this;
                        if (aVar2.f80122l.f80103f != 0 || (activity = e.this.f80105d) == null) {
                            aVar2.b();
                        } else if (!NetworkUtil.isNetSupport(activity.getApplicationContext())) {
                            QQToast.makeText(e.this.f80105d, R.string.f171139ci4, 0).show(((BaseActivity) e.this.f80105d).getTitleBarHeight());
                        } else {
                            a.this.d(2);
                            a aVar3 = a.this;
                            aVar3.f80122l.f80103f = 2;
                            MqqHandler handler = e.this.f80108h.getHandler(SubscriptFeedsActivity.class);
                            if (handler != null && (activity2 = e.this.f80105d) != null && (activity2 instanceof SubscriptFeedsActivity)) {
                                handler.sendEmptyMessage(1007);
                            }
                            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                            a aVar4 = a.this;
                            iPublicAccountObserver.setOnCallback(new b(aVar4));
                            IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                            e eVar = e.this;
                            iPublicAccountUtil.followUin(eVar.f80108h, eVar.f80105d, valueOf, iPublicAccountObserver);
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f80126d;

            b(e eVar) {
                this.f80126d = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ReportController.o(e.this.f80108h, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
                a aVar = a.this;
                com.tencent.biz.pubaccount.subscript.d dVar = aVar.f80122l;
                if (dVar != null) {
                    ReportController.o(e.this.f80108h, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(dVar.f80098a), "", "", "");
                }
                com.tencent.biz.pubaccount.subscript.d dVar2 = a.this.f80122l;
                if (dVar2 != null && !TextUtils.isEmpty(String.valueOf(dVar2.f80098a))) {
                    a.this.b();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class c implements View.OnTouchListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f80128d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f80129e;

            c(e eVar, boolean z16) {
                this.f80128d = eVar;
                this.f80129e = z16;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 && action != 3 && action != 4) {
                        return false;
                    }
                    a aVar = a.this;
                    aVar.f80114d.setTextColor(e.this.f80105d.getResources().getColor(R.color.f157573tj));
                    a.this.f80113c.setBackgroundResource(R.drawable.a2w);
                    return false;
                }
                a aVar2 = a.this;
                aVar2.f80114d.setTextColor(e.this.f80105d.getResources().getColor(R.color.f157574tk));
                if (!this.f80129e) {
                    a.this.f80113c.setBackgroundResource(R.drawable.a2r);
                } else {
                    a.this.f80113c.setBackgroundResource(R.drawable.a2s);
                }
                return false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class d implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f80131d;

            d(e eVar) {
                this.f80131d = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(e.this.f80108h, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B6F", "0X8005B6F", 0, 0, "", "", "", "", false);
                ReportController.o(e.this.f80108h, "CliOper", "", "", "0X800642D", "0X800642D", 0, 0, "", "", "", "");
                Activity activity = e.this.f80105d;
                IPublicAccountConfigUtil iPublicAccountConfigUtil = (IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class);
                e eVar = e.this;
                em.d(activity, iPublicAccountConfigUtil.getSubscriptName(eVar.f80108h, eVar.f80105d), null, null);
                SubscriptRecommendController.H(e.this.f80108h, false);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(View view, boolean z16) {
            this.f80111a = view;
            this.f80112b = view.findViewById(R.id.f166828ii2);
            this.f80113c = this.f80111a.findViewById(R.id.f166829ii3);
            this.f80114d = (TextView) this.f80111a.findViewById(R.id.ii5);
            this.f80115e = (ImageView) this.f80111a.findViewById(R.id.f166830ii4);
            this.f80116f = (ImageView) this.f80111a.findViewById(R.id.f164496zr);
            this.f80117g = (TextView) this.f80111a.findViewById(R.id.f164499zu);
            this.f80118h = (ImageView) this.f80111a.findViewById(R.id.j7w);
            this.f80119i = (TextView) this.f80111a.findViewById(R.id.j7x);
            this.f80120j = (Button) this.f80111a.findViewById(R.id.cgp);
            this.f80121k = (ImageView) this.f80111a.findViewById(R.id.cgq);
            if (!z16) {
                this.f80117g.setTextColor(e.this.f80105d.getResources().getColor(R.color.f157560t6));
                this.f80120j.setBackgroundResource(R.drawable.a2u);
            } else {
                this.f80117g.setTextColor(e.this.f80105d.getResources().getColor(R.color.f157561t7));
                this.f80120j.setBackgroundResource(R.drawable.a2t);
            }
            this.f80120j.setOnClickListener(new ViewOnClickListenerC0818a(e.this));
            this.f80111a.setOnClickListener(new b(e.this));
            this.f80113c.setOnTouchListener(new c(e.this, z16));
            this.f80113c.setOnClickListener(new d(e.this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (!TextUtils.isEmpty(this.f80122l.f80104g)) {
                Intent intent = new Intent(e.this.f80105d, (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
                intent.putExtra("key_isReadModeEnabled", true);
                intent.putExtra("url", this.f80122l.f80104g);
                intent.putExtra("hide_operation_bar", true);
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(intent, this.f80122l.f80104g);
                e.this.f80105d.startActivity(intent);
            }
        }

        public void c(com.tencent.biz.pubaccount.subscript.d dVar, int i3) {
            if (dVar == null) {
                return;
            }
            this.f80122l = dVar;
            if (dVar.f80098a == -1) {
                this.f80112b.setVisibility(8);
                this.f80113c.setVisibility(0);
                this.f80115e.setVisibility(0);
                return;
            }
            this.f80112b.setVisibility(0);
            this.f80113c.setVisibility(8);
            this.f80115e.setVisibility(8);
            if (dVar.f80102e != null) {
                ViewGroup.LayoutParams layoutParams = this.f80116f.getLayoutParams();
                e.this.f80109i.c(((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(dVar.f80102e.mFirstPagePicUrl, 1, Long.valueOf(dVar.f80098a)), this.f80116f, layoutParams.width, layoutParams.height, null, 5);
            }
            ReadInJoyArticle readInJoyArticle = dVar.f80102e;
            String str = "";
            if (readInJoyArticle != null) {
                str = readInJoyArticle.mTitle.replaceFirst("^\\s+", "");
            }
            if (e.this.C) {
                str = str + "\n";
            }
            this.f80117g.setText(str);
            String valueOf = String.valueOf(dVar.f80098a);
            this.f80119i.setText(dVar.f80099b);
            if (AppSetting.f99565y) {
                this.f80111a.setContentDescription(dVar.f80099b);
            }
            Bitmap bitmapFromCache = e.this.f80106e.getBitmapFromCache(1, valueOf);
            if (bitmapFromCache == null) {
                e.this.f80106e.requestDecodeFace(valueOf, 1, true);
                this.f80118h.setImageResource(R.drawable.f160830com);
            } else {
                this.f80118h.setImageBitmap(bitmapFromCache);
            }
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) e.this.f80108h.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                if (((PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(valueOf)) != null) {
                    d(1);
                    dVar.f80103f = 1;
                } else if (dVar.f80103f == 2) {
                    d(2);
                } else {
                    d(0);
                    dVar.f80103f = 0;
                }
            }
        }

        public void d(int i3) {
            if (this.f80121k.isShown() && (this.f80121k.getDrawable() instanceof Animatable)) {
                ((Animatable) this.f80121k.getDrawable()).stop();
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.f80120j.setVisibility(8);
                        this.f80121k.setVisibility(0);
                        if (this.f80121k.getDrawable() instanceof Animatable) {
                            ((Animatable) this.f80121k.getDrawable()).start();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!e.this.f80110m) {
                    this.f80120j.setBackgroundResource(R.drawable.a2r);
                } else {
                    this.f80120j.setBackgroundResource(R.drawable.a2s);
                }
                this.f80120j.setTextColor(e.this.f80105d.getResources().getColor(R.color.f157574tk));
                this.f80120j.setText(HardCodeUtil.qqStr(R.string.txy));
                this.f80120j.setVisibility(0);
                this.f80121k.setVisibility(8);
                return;
            }
            if (!e.this.f80110m) {
                this.f80120j.setBackgroundResource(R.drawable.a2u);
            } else {
                this.f80120j.setBackgroundResource(R.drawable.a2t);
            }
            this.f80120j.setTextColor(e.this.f80105d.getResources().getColor(R.color.f157573tj));
            this.f80120j.setText(HardCodeUtil.qqStr(R.string.f171699ka2));
            this.f80120j.setVisibility(0);
            this.f80121k.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    protected class b extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        a f80133a;

        public b(a aVar) {
            this.f80133a = aVar;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean z16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + z16 + " | uin: " + str + " | mRecommendItem: " + this.f80133a);
            }
            a aVar = this.f80133a;
            if (aVar != null) {
                aVar.d(z16 ? 1 : 0);
            }
        }
    }

    public e(Activity activity, QQAppInterface qQAppInterface, c cVar) {
        this.f80107f = null;
        this.f80108h = null;
        this.f80110m = false;
        this.C = false;
        this.f80105d = activity;
        this.f80107f = new ArrayList(11);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.f80106e = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.f80108h = qQAppInterface;
        this.f80109i = cVar;
        this.f80110m = ThemeUtil.isInNightMode(qQAppInterface);
        if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
            this.C = true;
        }
    }

    public void b(d dVar) {
        if (dVar != null) {
            this.f80107f.add(dVar);
        }
    }

    public void c(List<d> list) {
        if (list != null) {
            int i3 = 10;
            if (list.size() < 10) {
                i3 = list.size();
            }
            for (int i16 = 0; i16 < i3; i16++) {
                b(list.get(i16));
            }
            d dVar = new d();
            dVar.f80098a = -1L;
            b(dVar);
        }
    }

    public void d() {
        this.f80107f.clear();
    }

    public void e() {
        this.f80106e.setDecodeTaskCompletionListener(null);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f80107f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (this.f80107f != null && i3 <= getCount() && i3 >= 0) {
            return this.f80107f.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f80105d.getLayoutInflater().inflate(R.layout.ac7, (ViewGroup) null);
            aVar = new a(view, this.f80110m);
            view.setVisibility(0);
            view.setFocusable(false);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.c(this.f80107f.get(i3), i3);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        notifyDataSetChanged();
    }
}
