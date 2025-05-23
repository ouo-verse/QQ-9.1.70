package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback;
import com.tencent.mobileqq.guild.temp.api.IGuildEmoPreviewDataSourceApi;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends BaseAdapter implements URLDrawableDownListener, EmotionDownGIFCallback.a {
    static IPatchRedirector $redirector_;
    public static final Object S;
    public static final Object T;
    public static final Object U;
    private Handler C;
    private GridView D;
    private Context E;
    private int F;
    private int G;
    private Drawable H;
    private Calendar I;
    private String J;
    private boolean K;
    public boolean L;
    private boolean M;
    private HashMap<MessageForPic, EmotionDownGIFCallback> N;
    private int P;
    private int Q;
    private com.tencent.mobileqq.activity.aio.photo.e R;

    /* renamed from: d, reason: collision with root package name */
    List<Object> f205221d;

    /* renamed from: e, reason: collision with root package name */
    private List<MessageRecord> f205222e;

    /* renamed from: f, reason: collision with root package name */
    int f205223f;

    /* renamed from: h, reason: collision with root package name */
    int f205224h;

    /* renamed from: i, reason: collision with root package name */
    private LayoutInflater f205225i;

    /* renamed from: m, reason: collision with root package name */
    private r f205226m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205227d;

        a(String str) {
            this.f205227d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (i.this.R.e(this.f205227d) != null) {
                com.tencent.mobileqq.activity.aio.photo.e eVar = i.this.R;
                String str2 = this.f205227d;
                i iVar = i.this;
                boolean c16 = eVar.c(str2, iVar.f205223f, iVar.f205221d);
                String str3 = i.this.Q + "";
                if (c16) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 2, 0, str3, str, "", "");
                i.this.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f205229a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f205230b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f205231c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class c extends FrameLayout {
        static IPatchRedirector $redirector_;

        public c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) context);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            int paddingLeft = i.this.D.getPaddingLeft() + getPaddingLeft();
            if (paddingLeft != i3) {
                offsetLeftAndRight(paddingLeft - i3);
            }
            super.onLayout(z16, i3, i16, i17, i18);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec((i.this.D.getMeasuredWidth() - i.this.D.getPaddingLeft()) - i.this.D.getPaddingRight(), View.MeasureSpec.getMode(i3)), i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f205234a;

        /* renamed from: b, reason: collision with root package name */
        CheckBox f205235b;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public StrengthenURLImageView f205237a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f205238b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f205239c;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        S = new Object();
        T = new Object();
        U = new Object();
    }

    public i(Activity activity, r rVar, Handler handler, int i3, GridView gridView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, rVar, handler, Integer.valueOf(i3), gridView);
            return;
        }
        this.f205221d = new ArrayList();
        this.f205223f = 4;
        this.f205224h = -1;
        this.I = null;
        this.J = null;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = new HashMap<>();
        this.P = -1;
        this.Q = -1;
        this.R = new com.tencent.mobileqq.activity.aio.photo.e();
        this.E = activity;
        this.f205226m = rVar;
        this.C = handler;
        this.F = i3;
        this.D = gridView;
        this.f205225i = activity.getLayoutInflater();
        this.G = BaseAIOUtils.f(40.0f, this.E.getResources());
    }

    private IPicTransFile.a i(MessageForPic messageForPic) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            com.tencent.mobileqq.pic.k kVar = new com.tencent.mobileqq.pic.k();
            int i3 = messageForPic.fileSizeFlag;
            kVar.R = i3;
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            IHttpCommunicatorListener findProcessor = ((ITransFileController) ((QQAppInterface) runtime).getRuntimeService(ITransFileController.class)).findProcessor(BaseTransFileController.makeReceiveKey(messageForPic.md5, messageForPic.uuid, ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(ProtocolDownloaderConstants.PROTOCOL_AIO_THUMB, z16)));
            if (findProcessor != null && (findProcessor instanceof IPicTransFile.a)) {
                return (IPicTransFile.a) findProcessor;
            }
            return null;
        }
        return null;
    }

    public static int j(int i3) {
        if (i3 == -1) {
            return -1;
        }
        int intValue = Integer.valueOf(ChatActivityUtils.B(i3)).intValue();
        if (intValue != 0) {
            if (intValue != 3) {
                return -1;
            }
            return 2;
        }
        return 1;
    }

    private Drawable m(s sVar) {
        if (this.P == 10014) {
            return ((y) ((IGuildEmoPreviewDataSourceApi) QRoute.api(IGuildEmoPreviewDataSourceApi.class)).createGuildEmoPreviewData(sVar.f205289a)).c(this.E);
        }
        return r.a(this.E, sVar);
    }

    private void v(int i3, View view, int i16, Object obj) {
        d dVar;
        if (i16 != 0) {
            if (i16 != 2) {
                if (i16 != 5) {
                    return;
                }
            } else {
                if (d.class.isInstance(obj) && (dVar = (d) obj) != null) {
                    String str = (String) getItem(i3);
                    dVar.f205234a.setText(str);
                    if (AppSetting.f99565y) {
                        dVar.f205234a.setContentDescription(HardCodeUtil.qqStr(R.string.kes) + ((i3 / 4) + 1) + HardCodeUtil.qqStr(R.string.kdh) + str);
                    }
                    if (l()) {
                        ViewGroup viewGroup = (ViewGroup) dVar.f205235b.getParent();
                        if (viewGroup != null) {
                            viewGroup.setBackgroundDrawable(this.E.getResources().getDrawable(R.drawable.f160536jh));
                        }
                        dVar.f205235b.setVisibility(0);
                        dVar.f205235b.setChecked(this.R.h(str));
                        dVar.f205235b.setClickable(false);
                        view.setOnClickListener(new a(str));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (view != null) {
            u(i3, view);
        }
    }

    public void d(boolean z16, List<MessageRecord> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), list);
            return;
        }
        int i16 = this.f205223f;
        if (i16 == 0) {
            return;
        }
        if (z16) {
            this.f205221d.clear();
            this.f205224h = -1;
            this.J = null;
        } else {
            this.R.j(this.f205221d, i16);
        }
        if (this.I == null) {
            Calendar calendar = Calendar.getInstance();
            this.I = calendar;
            calendar.setTimeInMillis(com.tencent.mobileqq.service.message.e.K0() * 1000);
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            MessageRecord messageRecord = list.get(size);
            s sVar = new s(messageRecord);
            String k3 = k(this.I, messageRecord.time);
            if (!k3.equals(this.J)) {
                this.J = k3;
                int i17 = this.f205224h;
                if (i17 != -1 && (i3 = i17 % this.f205223f) > 0) {
                    for (int i18 = 0; i18 < this.f205223f - i3; i18++) {
                        this.f205221d.add(U);
                    }
                }
                this.f205224h = 0;
                this.f205221d.add(k3);
                for (int i19 = 0; i19 < this.f205223f - 1; i19++) {
                    this.f205221d.add(T);
                }
            }
            this.f205221d.add(sVar);
            this.f205224h++;
        }
        com.tencent.mobileqq.activity.aio.photo.e eVar = this.R;
        if (z16 || list.isEmpty()) {
            z17 = true;
        }
        eVar.d(z17, this.f205223f, this.f205221d);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.a
    public void d2(boolean z16, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), messageForPic);
        } else {
            this.N.remove(messageForPic);
            notifyDataSetChanged();
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return g() + this.R.g();
    }

    public List<MessageRecord> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f205222e;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f205221d.size();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        int size = this.f205221d.size();
        if (this.K) {
            int i3 = size % 4;
            if (i3 > 0) {
                size += 4 - i3;
            }
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (!this.K) {
            return this.f205221d.get(i3);
        }
        if (i3 < this.f205221d.size()) {
            return this.f205221d.get(i3);
        }
        if (i3 == getCount() - 1) {
            return S;
        }
        return U;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        Object item = getItem(i3);
        if ((item instanceof s) && ((s) item).f205293e) {
            return 5;
        }
        if (!(item instanceof MessageRecord)) {
            if (U.equals(item)) {
                return 1;
            }
            if (item instanceof String) {
                return 2;
            }
            if (T.equals(item)) {
                return 3;
            }
            if (S.equals(item)) {
                return 4;
            }
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        Object obj;
        View view2;
        Object obj2;
        View view3;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            view3 = (View) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), view, viewGroup);
            view4 = view;
        } else {
            int itemViewType = getItemViewType(i3);
            if (view == null) {
                obj = null;
            } else {
                obj = view.getTag();
            }
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        if (itemViewType != 3) {
                            if (itemViewType != 4) {
                                obj2 = obj;
                                view2 = view;
                                if (itemViewType == 5) {
                                    boolean isInstance = e.class.isInstance(obj);
                                    obj2 = obj;
                                    view2 = view;
                                    if (!isInstance) {
                                        if (QLog.isColorLevel() && view != null) {
                                            QLog.d("ChatHistoryEmotionAdapter", 2, "[getView] type 5 while convertView type " + ((AbsListView.LayoutParams) view.getLayoutParams()).viewType);
                                        }
                                        View inflate = this.f205225i.inflate(R.layout.i3c, (ViewGroup) null);
                                        int i16 = this.F;
                                        inflate.setLayoutParams(new AbsListView.LayoutParams(i16, i16));
                                        e eVar = new e();
                                        StrengthenURLImageView strengthenURLImageView = (StrengthenURLImageView) inflate.findViewById(R.id.fq6);
                                        eVar.f205237a = strengthenURLImageView;
                                        strengthenURLImageView.setAdjustViewBounds(false);
                                        eVar.f205238b = (ImageView) inflate.findViewById(R.id.fq_);
                                        eVar.f205239c = (ImageView) inflate.findViewById(R.id.fqa);
                                        inflate.setTag(eVar);
                                        obj2 = obj;
                                        view2 = inflate;
                                    }
                                }
                            } else {
                                Object obj3 = S;
                                boolean equals = obj3.equals(obj);
                                obj2 = obj;
                                view2 = view;
                                if (!equals) {
                                    c cVar = new c(this.E);
                                    View inflate2 = this.f205225i.inflate(R.layout.az7, (ViewGroup) null);
                                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                    layoutParams.gravity = 17;
                                    inflate2.setLayoutParams(layoutParams);
                                    cVar.addView(inflate2);
                                    cVar.setTag(obj3);
                                    obj2 = obj;
                                    view2 = cVar;
                                }
                            }
                        } else {
                            Object obj4 = T;
                            boolean equals2 = obj4.equals(obj);
                            obj2 = obj;
                            view2 = view;
                            if (!equals2) {
                                View view5 = new View(this.E);
                                view5.setMinimumHeight(this.G);
                                view5.setVisibility(4);
                                view5.setTag(obj4);
                                obj2 = obj;
                                view2 = view5;
                            }
                        }
                    } else {
                        boolean isInstance2 = d.class.isInstance(obj);
                        obj2 = obj;
                        view2 = view;
                        if (!isInstance2) {
                            View inflate3 = this.f205225i.inflate(R.layout.az8, (ViewGroup) null);
                            d dVar = new d();
                            dVar.f205234a = (TextView) inflate3.findViewById(R.id.jjc);
                            dVar.f205235b = (CheckBox) inflate3.findViewById(R.id.dv_);
                            c cVar2 = new c(this.E);
                            ViewGroup.LayoutParams layoutParams2 = inflate3.getLayoutParams();
                            if (layoutParams2 != null) {
                                inflate3.setLayoutParams(new FrameLayout.LayoutParams(layoutParams2.width, layoutParams2.height));
                                cVar2.setLayoutParams(new AbsListView.LayoutParams(layoutParams2.width, layoutParams2.height));
                            }
                            cVar2.addView(inflate3);
                            cVar2.setTag(dVar);
                            view2 = cVar2;
                            obj2 = dVar;
                        }
                    }
                } else {
                    Object obj5 = U;
                    boolean equals3 = obj5.equals(obj);
                    obj2 = obj;
                    view2 = view;
                    if (!equals3) {
                        View view6 = new View(this.E);
                        int i17 = this.F;
                        view6.setLayoutParams(new AbsListView.LayoutParams(i17, i17));
                        view6.setTag(obj5);
                        obj2 = obj;
                        view2 = view6;
                    }
                }
            } else {
                boolean isInstance3 = b.class.isInstance(obj);
                obj2 = obj;
                view2 = view;
                if (!isInstance3) {
                    if (QLog.isColorLevel() && view != null) {
                        QLog.d("ChatHistoryEmotionAdapter", 2, "[getView] type 0 while convertView type " + ((AbsListView.LayoutParams) view.getLayoutParams()).viewType);
                    }
                    View inflate4 = this.f205225i.inflate(R.layout.f167928mz, (ViewGroup) null);
                    int i18 = this.F;
                    inflate4.setLayoutParams(new AbsListView.LayoutParams(i18, i18));
                    b bVar = new b();
                    URLImageView uRLImageView = (URLImageView) inflate4.findViewById(R.id.fq6);
                    bVar.f205229a = uRLImageView;
                    uRLImageView.setAdjustViewBounds(false);
                    bVar.f205230b = (ImageView) inflate4.findViewById(R.id.fq_);
                    bVar.f205231c = (ImageView) inflate4.findViewById(R.id.fqa);
                    inflate4.setTag(bVar);
                    obj2 = obj;
                    view2 = inflate4;
                }
            }
            v(i3, view2, itemViewType, obj2);
            view3 = view2;
            view4 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 6;
    }

    public Object h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.f205221d.get(i3);
    }

    String k(Calendar calendar, long j3) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3 * 1000);
        int i3 = calendar.get(1);
        int i16 = calendar2.get(1);
        int i17 = calendar2.get(2);
        if (i3 == i16 && calendar.get(6) - calendar2.get(6) < 7) {
            return "7\u5929\u5185";
        }
        return String.format(Locale.CHINA, "%d\u5e74%d\u6708", Integer.valueOf(i16), Integer.valueOf(i17 + 1));
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.M && this.Q != -1) {
            return true;
        }
        return false;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (!this.N.isEmpty()) {
            for (Map.Entry<MessageForPic, EmotionDownGIFCallback> entry : this.N.entrySet()) {
                IPicTransFile.a i3 = i(entry.getKey());
                if (i3 != null) {
                    i3.removeDownCallBack(entry.getValue());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.a
    public void nf(int i3, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) messageForPic);
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.P = i3;
            this.Q = j(i3);
        }
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) view, (Object) uRLDrawable);
        }
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, view, uRLDrawable, th5);
        }
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, view, uRLDrawable, interruptedException);
        }
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, view, uRLDrawable, Integer.valueOf(i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    @Override // com.tencent.image.URLDrawableDownListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
        int i3;
        File fileInLocal;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view, (Object) uRLDrawable);
            return;
        }
        try {
            fileInLocal = uRLDrawable.getFileInLocal();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (fileInLocal != null) {
            i3 = aw.h(fileInLocal.getAbsolutePath());
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryEmotionAdapter", 2, "onLoadSuccessed,orientation:", Integer.valueOf(i3));
            }
            com.tencent.mobileqq.pic.util.a.a(view, uRLDrawable, i3);
        }
        i3 = 0;
        if (QLog.isColorLevel()) {
        }
        com.tencent.mobileqq.pic.util.a.a(view, uRLDrawable, i3);
    }

    public void p(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) list);
            return;
        }
        this.f205222e = list;
        d(true, list);
        r(false);
        notifyDataSetChanged();
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.M = z16;
        }
    }

    public boolean r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, z16)).booleanValue();
        }
        if (z16 != this.K) {
            this.K = z16;
            return true;
        }
        return false;
    }

    public void s(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) messageForPic);
            return;
        }
        EmotionDownGIFCallback emotionDownGIFCallback = new EmotionDownGIFCallback(messageForPic, this.C, this);
        if (!this.N.containsKey(messageForPic)) {
            this.N.put(messageForPic, emotionDownGIFCallback);
        }
        IPicTransFile.a i3 = i(messageForPic);
        if (i3 != null) {
            i3.addDownCallback(emotionDownGIFCallback);
            return;
        }
        com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(5, 1536, 1);
        createPicReq.d(messageForPic, messageForPic.getPicDownloadInfo());
        createPicReq.g(emotionDownGIFCallback);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
        }
    }

    public void t(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list);
            return;
        }
        this.f205222e.addAll(list);
        d(false, list);
        r(false);
        notifyDataSetChanged();
    }

    public void u(int i3, View view) {
        ImageView imageView;
        ImageView imageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) view);
            return;
        }
        Object item = getItem(i3);
        Object tag = view.getTag();
        if (!s.class.isInstance(item)) {
            QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + i3);
            return;
        }
        if (!(tag instanceof b) && !(tag instanceof e)) {
            QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not ContentHolder & is not VideoEmotionHolder, position:" + i3);
            return;
        }
        s sVar = (s) item;
        this.H = m(sVar);
        if (sVar.f205293e) {
            e eVar = (e) tag;
            StrengthenURLImageView strengthenURLImageView = eVar.f205237a;
            imageView = eVar.f205238b;
            imageView2 = eVar.f205239c;
            if (sVar.f205294f) {
                strengthenURLImageView.setURLDrawableDownListener(this);
                strengthenURLImageView.f(this.H, true);
            } else {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null && (runtime instanceof QQAppInterface)) {
                    strengthenURLImageView.i((QQAppInterface) runtime, sVar);
                }
            }
        } else {
            b bVar = (b) tag;
            URLImageView uRLImageView = bVar.f205229a;
            imageView = bVar.f205230b;
            imageView2 = bVar.f205231c;
            if (sVar.f205291c) {
                if (sVar.f205292d) {
                    uRLImageView.setURLDrawableDownListener(this);
                } else if (AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic) sVar.f205289a, 65537).toString()) == null) {
                    s((MessageForPic) sVar.f205289a);
                }
            }
            Drawable drawable = this.H;
            if ((drawable instanceof com.tencent.mobileqq.magicface.drawable.c) && ((com.tencent.mobileqq.magicface.drawable.c) drawable).b() != null) {
                Bitmap b16 = ((com.tencent.mobileqq.magicface.drawable.c) this.H).b();
                int i16 = this.F;
                uRLImageView.setImageBitmap(EmotionAdapter.n(b16, i16, i16));
            } else {
                uRLImageView.setImageDrawable(this.H);
            }
        }
        if (this.L) {
            if (sVar.f205290b) {
                imageView.setVisibility(0);
                imageView2.setImageResource(R.drawable.qq_pic_img_checkbox_select2);
                imageView2.setVisibility(0);
            } else {
                imageView.setVisibility(4);
                imageView2.setImageResource(R.drawable.qq_pic_img_checkbox_deselect2);
                imageView2.setVisibility(0);
            }
        } else {
            imageView.setVisibility(4);
            imageView2.setVisibility(4);
        }
        view.setContentDescription(HardCodeUtil.qqStr(R.string.kdn) + ((i3 / 4) + 1) + HardCodeUtil.qqStr(R.string.kf_) + ((i3 % 4) + 1) + HardCodeUtil.qqStr(R.string.ker));
    }
}
