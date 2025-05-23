package com.tencent.mobileqq.hotpic;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.NTHotPicPageView;
import com.tencent.mobileqq.hotpic.NTHotPicRecyclerView;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.util.HotPicSearchUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

@TargetApi(14)
/* loaded from: classes9.dex */
public class NTHotPicPageView extends RelativeLayout implements q, NTHotPicRecyclerView.c {
    static IPatchRedirector $redirector_;
    public static boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public static int f236973a0;

    /* renamed from: b0, reason: collision with root package name */
    public static Drawable f236974b0;

    /* renamed from: c0, reason: collision with root package name */
    public static boolean f236975c0;
    NTHotPicRecyclerView C;
    c D;
    HotPicFooter E;
    View F;
    View G;
    int H;
    int I;
    HotPicTagInfo J;
    j K;
    Set<Integer> L;
    Set<Integer> M;
    private int N;
    private int P;
    private int Q;
    private SparseArray<String> R;
    public int S;
    public int T;
    BroadcastReceiver U;
    boolean V;

    /* renamed from: d, reason: collision with root package name */
    NTHotPicMainPanel f236976d;

    /* renamed from: e, reason: collision with root package name */
    Context f236977e;

    /* renamed from: f, reason: collision with root package name */
    BaseQQAppInterface f236978f;

    /* renamed from: h, reason: collision with root package name */
    AIOContact f236979h;

    /* renamed from: i, reason: collision with root package name */
    com.tencent.aio.api.runtime.a f236980i;

    /* renamed from: m, reason: collision with root package name */
    StaggeredGridLayoutManager f236981m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class HotPicFooter implements com.tencent.mobileqq.hotpic.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f236982a;

        /* renamed from: b, reason: collision with root package name */
        c f236983b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f236984c;

        public HotPicFooter(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicPageView.this, (Object) cVar);
                return;
            }
            this.f236982a = 1;
            this.f236984c = false;
            this.f236983b = cVar;
        }

        @Override // com.tencent.mobileqq.hotpic.d
        public void a(RecyclerView.ViewHolder viewHolder, int i3) {
            StaggeredGridLayoutManager.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
                return;
            }
            if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams())) {
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                viewHolder.itemView.setLayoutParams(layoutParams);
            }
            layoutParams.setFullSpan(true);
            int i16 = NTHotPicPageView.this.H;
            if (!this.f236984c && i16 != -20 && this.f236982a == 1) {
                ((IHotPicApi) QRoute.api(IHotPicApi.class)).requestHotPicList(null, i16);
                this.f236984c = true;
            }
            if (this.f236982a == 1) {
                viewHolder.itemView.findViewById(R.id.d97).setVisibility(0);
                viewHolder.itemView.findViewById(R.id.d98).setVisibility(4);
            } else if (NTHotPicPageView.l()) {
                viewHolder.itemView.findViewById(R.id.d98).setVisibility(0);
                viewHolder.itemView.findViewById(R.id.d97).setVisibility(8);
            } else {
                ThreadManager.getUIHandler().post(new Runnable(viewHolder) { // from class: com.tencent.mobileqq.hotpic.NTHotPicPageView.HotPicFooter.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ RecyclerView.ViewHolder f236986d;

                    {
                        this.f236986d = viewHolder;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HotPicFooter.this, (Object) viewHolder);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f236986d.itemView.findViewById(R.id.d98).setVisibility(0);
                            this.f236986d.itemView.findViewById(R.id.d97).setVisibility(8);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.hotpic.d
        public RecyclerView.ViewHolder b(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            NTHotPicPageView nTHotPicPageView = NTHotPicPageView.this;
            return new d(LayoutInflater.from(nTHotPicPageView.f236977e).inflate(R.layout.h8_, viewGroup, false), null);
        }

        public void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.f236984c = z16;
            }
        }

        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f236982a = i3;
            }
        }
    }

    /* loaded from: classes9.dex */
    class a implements StaggeredGridLayoutManager.ExceptionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicPageView.this);
            }
        }

        @Override // android.support.v7.widget.StaggeredGridLayoutManager.ExceptionListener
        public void onGetPositionErr(View view, boolean z16, int i3, Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16), Integer.valueOf(i3), exc);
                return;
            }
            QLog.e("HotPicManagerHotPicPageView", 1, "onGetPositionErr 1  final p:" + i3 + " rescue:" + z16 + " v:" + view + " error: " + exc);
        }
    }

    /* loaded from: classes9.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f236989a;

        /* renamed from: b, reason: collision with root package name */
        private final String f236990b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicPageView.this);
            } else {
                this.f236989a = "reason";
                this.f236990b = GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManagerHotPicPageView", 2, "onReceive ===>" + action);
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                NTHotPicPageView.f236975c0 = true;
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                return;
            }
            if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                NTHotPicPageView.f236975c0 = true;
            } else if (!"tencent.av.v2q.StopVideoChat".equals(action) && action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                NTHotPicPageView.f236975c0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c extends RecyclerView.Adapter<d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<HotPicData> f236992d;

        /* renamed from: e, reason: collision with root package name */
        q f236993e;

        public c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicPageView.this, i3);
            } else {
                this.f236992d = new ArrayList();
            }
        }

        private void q(d dVar, HotPicData hotPicData) {
            HashMap hashMap = new HashMap();
            hashMap.put(HotPicData.HOT_PIC_EXTRA, hotPicData);
            Option targetView = Option.obtain().setLocalPath(((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFilePath(hotPicData.url)).setUrl(hotPicData.url).setLoadingDrawable(NTHotPicPageView.f236974b0).setFailDrawable(NTHotPicPageView.f236974b0).setExtraData(hashMap).setTargetView(dVar.f236996e);
            com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
            aVar.p(targetView, false);
            aVar.r(targetView, false);
            QQEmoticonPicLoader.f356316a.b().loadImage(targetView, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.hotpic.m
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    NTHotPicPageView.c.t(loadState, option);
                }
            });
        }

        private void r(d dVar, int i3, HotPicData hotPicData, int i16) {
            URLDrawable h16 = NTHotPicPageView.h(hotPicData);
            if (h16 != null) {
                NTHotPicPageView nTHotPicPageView = NTHotPicPageView.this;
                if (nTHotPicPageView.H != -20) {
                    nTHotPicPageView.N = Math.max(i3, nTHotPicPageView.N);
                    NTHotPicPageView.this.M.add(Integer.valueOf(i3));
                    if (h16.getStatus() != 1) {
                        NTHotPicPageView.this.K.a(h16, i3);
                    } else {
                        NTHotPicPageView.this.L.add(Integer.valueOf(i3));
                        h16.setAutoDownload(true);
                    }
                    if (i3 % 16 == 1) {
                        NTHotPicPageView.this.n();
                    }
                }
                if (hotPicData.getDataType() != 2) {
                    h16.setTargetDensity(i16);
                } else {
                    h16.setTargetDensity(160);
                }
                dVar.f236996e.setImageDrawable(h16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void t(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess()) {
                if (option.getAnimatable() instanceof r01.c) {
                    ((r01.c) option.getAnimatable()).start();
                }
            } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                QLog.e("HotPicManagerHotPicPageView", 1, "loadImage  state:" + loadState + ", listenerOption:" + option);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.f236992d.size();
        }

        public void s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f236992d.clear();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(d dVar, int i3) {
            ViewPager viewPager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar, i3);
            } else {
                HotPicData hotPicData = this.f236992d.get(i3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) dVar.f236996e.getLayoutParams();
                marginLayoutParams.rightMargin = NTHotPicPageView.this.Q;
                marginLayoutParams.leftMargin = NTHotPicPageView.this.Q;
                if (i3 != 0 && i3 != 1 && i3 != 2) {
                    marginLayoutParams.topMargin = NTHotPicPageView.this.Q * 2;
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                int i16 = hotPicData.width;
                int i17 = hotPicData.height;
                int i18 = NTHotPicPageView.this.P;
                float f16 = i16 / i18;
                marginLayoutParams.width = i18;
                marginLayoutParams.height = (int) ((i17 / f16) + 0.5f);
                int i19 = (int) ((160.0f / f16) + 0.5f);
                if (HotPicSearchUtils.f306386a.b()) {
                    q(dVar, hotPicData);
                } else {
                    r(dVar, i3, hotPicData, i19);
                }
                if (NTHotPicPageView.this.f236976d != null) {
                    String str = NTHotPicPageView.this.J.position + "_" + i3;
                    if (!NTHotPicPageView.this.f236976d.L.contains(str) && (viewPager = NTHotPicPageView.this.f236976d.G) != null) {
                        int currentItem = viewPager.getCurrentItem();
                        NTHotPicPageView nTHotPicPageView = NTHotPicPageView.this;
                        if (currentItem == nTHotPicPageView.J.position) {
                            nTHotPicPageView.q("0X8007EDD", NTHotPicPageView.this.J.position + "", i3 + "", NTHotPicPageView.this.J.tagName + "", hotPicData.url + "");
                            NTHotPicPageView.this.f236976d.L.add(str);
                        } else {
                            nTHotPicPageView.R.put(i3, hotPicData.url);
                        }
                    }
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(dVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            NTHotPicPageView nTHotPicPageView = NTHotPicPageView.this;
            return new d(LayoutInflater.from(nTHotPicPageView.f236977e).inflate(R.layout.f167602bk, viewGroup, false), this.f236993e);
        }

        public void w(List<? extends HotPicData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                this.f236992d.clear();
                this.f236992d.addAll(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        q f236995d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f236996e;

        public d(View view, q qVar) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTHotPicPageView.this, view, qVar);
                return;
            }
            if (qVar != null) {
                this.f236995d = qVar;
                ImageView imageView = (ImageView) view.findViewById(R.id.d95);
                this.f236996e = imageView;
                imageView.setTag("HotPicControlTag");
                this.itemView.setOnClickListener(this);
                this.itemView.setOnLongClickListener(this);
                this.itemView.setOnTouchListener(qVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                q qVar = this.f236995d;
                if (qVar != null) {
                    qVar.onItemClick(view, getPosition());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view)).booleanValue();
            } else {
                q qVar = this.f236995d;
                if (qVar != null) {
                    qVar.onItemLongClick(view, getPosition());
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51453);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        f236974b0 = new ColorDrawable(DownloadCardView.COLOR_APP_NAME_DARK);
        f236975c0 = true;
        f236973a0 = -1;
        W = true;
    }

    public NTHotPicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.L = new HashSet();
        this.M = new HashSet();
        this.N = 0;
        this.R = new SparseArray<>();
        this.S = -1;
        this.T = -1;
        this.V = false;
        j();
    }

    public static int f(HotPicData hotPicData) {
        if (HotPicSearchUtils.f306386a.a()) {
            if (TextUtils.isEmpty(hotPicData.url)) {
                return -1;
            }
            File diskFile = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicData.url);
            if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
                return 0;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(HotPicData.HOT_PIC_EXTRA, hotPicData);
            Option url = Option.obtain().setLocalPath(((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFilePath(hotPicData.url)).setExtraData(hashMap).setUrl(hotPicData.url);
            com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
            aVar.p(url, false);
            aVar.r(url, false);
            QQEmoticonPicLoader.f356316a.a(url, null);
            return 2;
        }
        URL url2 = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getURL(hotPicData.url);
        if (url2 == null) {
            return -1;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = hotPicData;
        URLDrawable drawable = URLDrawable.getDrawable(url2, obtain);
        File diskFile2 = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicData.url);
        if (diskFile2 != null && FileUtils.fileExistsAndNotEmpty(diskFile2.getAbsolutePath())) {
            return 0;
        }
        if (drawable.getStatus() == 1) {
            File diskFile3 = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicData.url);
            if (diskFile3 != null && FileUtils.fileExistsAndNotEmpty(diskFile3.getAbsolutePath())) {
                return -1;
            }
            URLDrawable.removeMemoryCacheByUrl(url2.toString());
            URLDrawable h16 = h(hotPicData);
            if (h16 != null) {
                h16.startDownload();
            }
            return 1;
        }
        drawable.startDownload();
        return 2;
    }

    public static URLDrawable h(HotPicData hotPicData) {
        boolean z16;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = f236974b0;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (hotPicData.getDataType() != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        obtain.mPlayGifImage = z16;
        obtain.mExtraInfo = hotPicData;
        URL url = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getURL(hotPicData.url);
        if (url == null) {
            return null;
        }
        return URLDrawable.getDrawable(url, obtain);
    }

    private void j() {
        int i3;
        Size c16;
        Resources resources = BaseApplication.getContext().getResources();
        this.Q = EmotionUtils.a(1.0f, resources);
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT && (getContext() instanceof FragmentActivity) && (c16 = com.tencent.mobileqq.pad.m.c((FragmentActivity) getContext())) != null) {
            QLog.i("HotPicManagerHotPicPageView", 1, "getRealScreenWidth  size:" + c16);
            i3 = c16.getWidth();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            i3 = resources.getDisplayMetrics().widthPixels;
        }
        this.P = (i3 - (this.Q * 8)) / 3;
    }

    public static boolean l() {
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (!this.V) {
                return;
            }
            this.D.s();
            this.D.notifyDataSetChanged();
            this.V = false;
        }
    }

    public void i(NTHotPicMainPanel nTHotPicMainPanel, HotPicTagInfo hotPicTagInfo) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) nTHotPicMainPanel, (Object) hotPicTagInfo);
            return;
        }
        this.C = (NTHotPicRecyclerView) findViewById(R.id.i4m);
        this.F = findViewById(R.id.loading);
        this.G = findViewById(R.id.d99);
        this.f236976d = nTHotPicMainPanel;
        this.f236977e = nTHotPicMainPanel.f236965h;
        this.f236978f = nTHotPicMainPanel.f236964f;
        this.f236979h = nTHotPicMainPanel.F;
        this.f236980i = nTHotPicMainPanel.E;
        this.J = hotPicTagInfo;
        this.H = hotPicTagInfo.tagId;
        this.I = hotPicTagInfo.position;
        if (hotPicTagInfo.tagType == 2) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(i3, 1);
        this.f236981m = staggeredGridLayoutManager;
        this.C.setLayoutManager(staggeredGridLayoutManager);
        this.f236981m.mExceptionListener = new a();
        c cVar = new c(this.H);
        this.D = cVar;
        cVar.f236993e = this;
        HotPicFooter hotPicFooter = new HotPicFooter(cVar);
        this.E = hotPicFooter;
        this.C.c(hotPicFooter);
        this.C.setAdapter(this.D);
        if (this.H == -20) {
            this.E.d(2);
        }
        this.C.f237001i = nTHotPicMainPanel;
        this.K = new j(this);
        this.U = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction("tencent.av.v2q.StopVideoChat");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.f236977e.registerReceiver(this.U, intentFilter);
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.V) {
                return;
            }
            s();
            this.V = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i3) {
        this.M.add(Integer.valueOf(i3));
        this.L.add(Integer.valueOf(i3));
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            if (HotPicSearchUtils.f306386a.b()) {
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o();
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.hotpic.NTHotPicPageView.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTHotPicPageView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            NTHotPicPageView.this.o();
                        }
                    }
                });
            }
        }
    }

    synchronized void o() {
        int i3;
        Exception e16;
        if (NetworkUtil.isWifiEnabled(this.f236977e) && this.L.size() == this.M.size() && this.N + 1 <= this.L.size()) {
            int size = this.D.f236992d.size();
            int i16 = (((this.N / 16) + 1) * 16) - 1;
            int i17 = i16 + 16;
            int i18 = 0;
            if (this.L.size() <= i16) {
                if (this.M.size() <= i16) {
                    for (int size2 = this.M.size(); size2 <= i16 && size2 < size; size2++) {
                        if (!this.M.contains(Integer.valueOf(size2))) {
                            try {
                                URLDrawable h16 = h(this.D.f236992d.get(size2));
                                if (h16 == null) {
                                    return;
                                }
                                if (h16.getStatus() != 1) {
                                    i3 = i18 + 1;
                                    if (i18 < 2) {
                                        try {
                                            this.K.d(size2, h16);
                                            i18 = i3;
                                        } catch (Exception e17) {
                                            e16 = e17;
                                            e16.printStackTrace();
                                            if (QLog.isColorLevel()) {
                                                QLog.d("HotPicManagerHotPicPageView", 2, "preDownloadOnUi !mStartDownLoadIndex.contains(index) Exception ", e16);
                                            }
                                            i18 = i3;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    this.L.add(Integer.valueOf(size2));
                                }
                                this.M.add(Integer.valueOf(size2));
                                if (QLog.isColorLevel()) {
                                    QLog.d("HotPicManagerHotPicPageView", 2, "preDownload  " + this.H + " " + size2);
                                }
                            } catch (Exception e18) {
                                i3 = i18;
                                e16 = e18;
                            }
                        }
                    }
                }
                if (i18 != 0) {
                    return;
                }
            }
            if (this.L.size() > i16) {
                int i19 = this.H;
                if (this.D.f236992d.size() < i17 && !((IHotPicApi) QRoute.api(IHotPicApi.class)).checkIsNoMoreIndex(null, i19)) {
                    ((IHotPicApi) QRoute.api(IHotPicApi.class)).requestHotPicList(null, i19);
                }
                if (this.M.size() <= i17) {
                    for (int size3 = this.M.size(); size3 <= i17 && size3 < size; size3++) {
                        if (!this.M.contains(Integer.valueOf(size3))) {
                            try {
                                URLDrawable h17 = h(this.D.f236992d.get(size3));
                                if (h17 == null) {
                                    return;
                                }
                                if (h17.getStatus() != 1) {
                                    int i26 = i18 + 1;
                                    if (i18 < 2) {
                                        try {
                                            this.K.d(size3, h17);
                                            i18 = i26;
                                        } catch (Exception e19) {
                                            e = e19;
                                            i18 = i26;
                                            e.printStackTrace();
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    this.L.add(Integer.valueOf(size3));
                                }
                                this.M.add(Integer.valueOf(size3));
                                if (QLog.isColorLevel()) {
                                    QLog.d("HotPicManagerHotPicPageView", 2, "preDownload  " + this.H + " " + size3);
                                }
                            } catch (Exception e26) {
                                e = e26;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        HotPicTagInfo hotPicTagInfo = this.J;
        if (hotPicTagInfo != null && hotPicTagInfo.tagType == 2) {
            f236975c0 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e5  */
    @Override // com.tencent.mobileqq.hotpic.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemClick(View view, int i3) {
        String str;
        String absolutePath;
        int e16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
            return;
        }
        try {
            HotPicData hotPicData = this.D.f236992d.get(i3);
            if (hotPicData.getDataType() == 2) {
                return;
            }
            File diskFile = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicData.originalUrl);
            if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
                absolutePath = diskFile.getAbsolutePath();
                if (QLog.isColorLevel()) {
                    QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, urlHotPicOringinal = " + hotPicData.originalUrl + ", paths = " + absolutePath);
                }
            } else if (f(hotPicData) == 0) {
                absolutePath = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicData.url).getAbsolutePath();
                if (QLog.isColorLevel()) {
                    QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, urlHotPic = " + hotPicData.url + ", paths = " + absolutePath);
                }
            } else {
                str = null;
                q("0X8007EDE", this.J.position + "", i3 + "", this.J.tagName + "", hotPicData.url + "");
                if (str != null && this.f236979h.e() != 103) {
                    QQToast.makeText(this.f236977e, R.string.fkh, 0).show();
                    return;
                }
                if (str != null) {
                    this.f236980i.e().h(new AIOMsgSendEvent.PicEmotionSendEvent(str, 2, null, null));
                }
                ((IHotPicApi) QRoute.api(IHotPicApi.class)).addSendPic(hotPicData);
                ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B17", "0X8007B17", 0, 0, "", "", "", "");
                e16 = this.f236979h.e();
                if (e16 == 1) {
                    if (e16 != 2) {
                        if (e16 == 3) {
                            ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B1A", "0X8007B1A", 0, 0, "", "", "", "");
                        }
                    } else {
                        ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B1B", "0X8007B1B", 0, 0, "", "", "", "");
                        if (this.J.tagName.equals(com.tencent.mobileqq.hotpic.a.f237004a)) {
                            ReportController.o(this.f236978f, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 2, 0, "", "", "", "");
                        }
                    }
                } else {
                    ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B19", "0X8007B19", 0, 0, "", "", "", "");
                    if (this.J.tagName.equals(com.tencent.mobileqq.hotpic.a.f237005b)) {
                        ReportController.o(this.f236978f, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 1, 0, "", "", "", "");
                    }
                }
                if (this.H == -20) {
                    ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B18", "0X8007B18", 0, 0, "", "", "", "");
                }
                i16 = hotPicData.sourceType;
                if (i16 == 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B1F", "0X8007B1F", 0, 0, "", "", "", "");
                            return;
                        }
                        return;
                    }
                    ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B20", "0X8007B20", 0, 0, "", "", "", "");
                    return;
                }
                ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B1E", "0X8007B1E", 0, 0, "", "", "", "");
                return;
            }
            str = absolutePath;
            q("0X8007EDE", this.J.position + "", i3 + "", this.J.tagName + "", hotPicData.url + "");
            if (str != null) {
            }
            if (str != null) {
            }
            ((IHotPicApi) QRoute.api(IHotPicApi.class)).addSendPic(hotPicData);
            ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B17", "0X8007B17", 0, 0, "", "", "", "");
            e16 = this.f236979h.e();
            if (e16 == 1) {
            }
            if (this.H == -20) {
            }
            i16 = hotPicData.sourceType;
            if (i16 == 1) {
            }
        } catch (IndexOutOfBoundsException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, onItemClick IndexOutOfBoundsException " + e17.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.hotpic.q
    public void onItemLongClick(View view, int i3) {
        int f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, i3);
            return;
        }
        if (this.f236976d == null) {
            return;
        }
        HotPicData hotPicData = this.D.f236992d.get(i3);
        if (hotPicData.getDataType() != 2 && (f16 = f(hotPicData)) != 2 && f16 != -1) {
            this.f236976d.r(hotPicData);
            view.getParent().requestDisallowInterceptTouchEvent(true);
            ReportController.o(this.f236978f, "dc00898", "", "", "0X8007B22", "0X8007B22", 0, 0, "", "", "", "");
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.hotpic.NTHotPicRecyclerView.c
    public void onScrollEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        boolean z16 = true;
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {
            z16 = false;
        }
        if (!z16 || f236975c0) {
            return;
        }
        this.C.findViewHolderForPosition(this.T);
    }

    @Override // com.tencent.mobileqq.hotpic.NTHotPicRecyclerView.c
    public void onScrollStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        NTHotPicMainPanel nTHotPicMainPanel = this.f236976d;
        if (nTHotPicMainPanel == null) {
            return false;
        }
        View view2 = nTHotPicMainPanel.C;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (motionEvent.getAction() == 0) {
            View findViewWithTag = relativeLayout.findViewWithTag("HotPicControlTag");
            if (findViewWithTag != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) findViewWithTag.getLayoutParams());
                ImageView imageView = new ImageView(relativeLayout.getContext());
                imageView.setTag("HotPicPopControlTag");
                imageView.setBackgroundColor(Color.parseColor("#7f000000"));
                relativeLayout.addView(imageView, layoutParams);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            View findViewWithTag2 = relativeLayout.findViewWithTag("HotPicPopControlTag");
            if (findViewWithTag2 != null) {
                relativeLayout.removeView(findViewWithTag2);
            }
            if (view2.getVisibility() == 0) {
                this.f236976d.g();
            }
        }
        if (view2.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            if (this.f236976d != null) {
                int keyAt = this.R.keyAt(i3);
                String valueAt = this.R.valueAt(i3);
                String str = this.J.position + "_" + keyAt;
                q("0X8007EDD", this.J.position + "", keyAt + "", this.J.tagName + "", valueAt + "");
                this.f236976d.L.add(str);
            }
        }
        this.R.clear();
    }

    void q(String str, String str2, String str3, String str4, String str5) {
        int i3;
        int i16;
        String str6;
        AIOContact aIOContact;
        NTHotPicMainPanel nTHotPicMainPanel = this.f236976d;
        int i17 = 1;
        if (nTHotPicMainPanel != null && !(nTHotPicMainPanel instanceof NTHotPicMainPanel)) {
            i3 = 5;
        } else {
            i3 = 1;
        }
        if (i3 == 1 && (aIOContact = this.f236979h) != null) {
            String j3 = aIOContact.j();
            int e16 = this.f236979h.e();
            if (e16 != 1) {
                i17 = 2;
                if (e16 != 2) {
                    i17 = 3;
                    if (e16 != 3) {
                        i16 = 0;
                        str6 = j3;
                    }
                }
            }
            i16 = i17;
            str6 = j3;
        } else {
            i16 = 0;
            str6 = "";
        }
        ReportController.o(this.f236978f, "dc00898", "", str6, str, str, i3, i16, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.C.f237001i = null;
        this.K.e();
        this.K = null;
        this.f236976d = null;
        this.L.clear();
        this.M.clear();
        this.N = 0;
        BroadcastReceiver broadcastReceiver = this.U;
        if (broadcastReceiver != null) {
            this.f236977e.unregisterReceiver(broadcastReceiver);
            this.U = null;
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Manager hotPicManager = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicManager();
        int i3 = 2;
        if (this.H == -20) {
            this.F.setVisibility(8);
            this.C.setVisibility(8);
            this.E.d(2);
            LinkedList<HotPicSendData> recentSendPics = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getRecentSendPics();
            QLog.d("mickiezhang", 1, "recentPic: " + recentSendPics.size());
            if (recentSendPics.size() <= 0) {
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
            this.D.w(recentSendPics);
            this.C.setVisibility(0);
            this.C.scrollToPosition(0);
            this.D.notifyDataSetChanged();
            return;
        }
        if (((IHotPicApi) QRoute.api(IHotPicApi.class)).checkData(hotPicManager, this.H)) {
            ArrayList<HotPicData> hotPics = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPics(hotPicManager, this.H);
            this.D.w(hotPics);
            QLog.d("mickiezhang", 1, "page hotPicDatas: " + hotPics.size());
            if (!((IHotPicApi) QRoute.api(IHotPicApi.class)).checkIsNoMoreIndex(hotPicManager, this.H)) {
                i3 = 1;
            }
            this.E.d(i3);
            this.F.setVisibility(8);
            this.C.setVisibility(0);
            this.C.scrollToPosition(0);
            this.D.notifyDataSetChanged();
            return;
        }
        this.F.setVisibility(0);
        this.C.setVisibility(8);
        ((IHotPicApi) QRoute.api(IHotPicApi.class)).requestHotPicList(hotPicManager, this.H);
    }

    public void setOnHotPicItemClickListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) eVar);
        }
    }
}
