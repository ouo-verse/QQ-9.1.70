package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.model.GameQuestionUserInfo;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import gp3.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQuestionExpertListFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private XListView D;
    private View E;
    private View F;
    private TextView G;
    private View H;
    private Switch I;
    private ImageView J;
    private vd1.b L;
    private boolean M;
    private int N;
    private boolean Q;
    private h R;
    private com.tencent.mobileqq.gamecenter.qa.model.e S;
    private WeakReference<QBaseActivity> T;
    protected BottomSheetBehavior U;
    private boolean V;
    private boolean W;
    private boolean X;
    private fe1.c K = new fe1.c();
    private List<com.tencent.mobileqq.gamecenter.qa.model.d> P = new ArrayList();
    private final AbsListView.OnScrollListener Y = new f();
    private fe1.d Z = new fe1.a() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.7
        @Override // fe1.a, fe1.d
        public void onChangeOnlineStatus(long j3, boolean z16) {
            super.onChangeOnlineStatus(j3, z16);
            QLog.d("GameQuestionExpertListFragment", 1, "onChangeOnlineStatus, errorCode=", Long.valueOf(j3), ", isOnline=", Boolean.valueOf(z16));
            GameQuestionExpertListFragment.this.X = false;
            if (j3 == 0) {
                GameQuestionExpertListFragment.this.V = z16;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.7.5
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQuestionExpertListFragment.this.Nh();
                    }
                });
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.7.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), 0, "\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!", 0).show();
                        GameQuestionExpertListFragment.this.Uh();
                    }
                });
            }
        }

        @Override // fe1.a, fe1.d
        public void onGetAuthWhite(long j3, String str, int i3, boolean z16) {
            super.onGetAuthWhite(j3, str, i3, z16);
            QLog.d("GameQuestionExpertListFragment", 1, "onGetAuthWhite, errorCode=", Long.valueOf(j3), ", isWhite=", Boolean.valueOf(z16));
            GameQuestionExpertListFragment.this.Q = z16;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.7.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    GameQuestionExpertListFragment.this.Th();
                    if (GameQuestionExpertListFragment.this.Q) {
                        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
                        gameStrategyChannelEntry.guildId = GameQuestionExpertListFragment.this.L.f441456a;
                        gameStrategyChannelEntry.channelId = GameQuestionExpertListFragment.this.L.f441457b;
                        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907235", "8", String.valueOf(GameQuestionExpertListFragment.this.L.f441458c), GameQAUtil.i((Activity) GameQuestionExpertListFragment.this.T.get(), gameStrategyChannelEntry));
                        GameQuestionExpertListFragment.this.Kh();
                    }
                    GameQuestionExpertListFragment.this.Uh();
                }
            });
        }

        @Override // fe1.a, fe1.d
        public void onGetExpertList(final long j3, final com.tencent.mobileqq.gamecenter.qa.model.e eVar) {
            super.onGetExpertList(j3, eVar);
            QLog.d("GameQuestionExpertListFragment", 1, "onGetExpertList, errorCode=", Long.valueOf(j3));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.7.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.gamecenter.qa.model.e eVar2;
                    if (j3 == 0 && (eVar2 = eVar) != null) {
                        GameQuestionExpertListFragment.this.Sh(eVar2);
                    }
                }
            });
        }

        @Override // fe1.a, fe1.d
        public void onGetOnlineStatus(long j3, boolean z16) {
            super.onGetOnlineStatus(j3, z16);
            QLog.d("GameQuestionExpertListFragment", 1, "onGetOnlineStatus, errorCode=", Long.valueOf(j3), ", isOnline=", Boolean.valueOf(z16));
            GameQuestionExpertListFragment.this.V = z16;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.7.3
                @Override // java.lang.Runnable
                public void run() {
                    GameQuestionExpertListFragment.this.Uh();
                }
            });
        }
    };

    /* renamed from: a0, reason: collision with root package name */
    private final OverScrollViewListener f212447a0 = new g();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GameQuestionExpertListFragment.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                GameQuestionExpertListFragment.this.D.getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                GameQuestionExpertListFragment.this.D.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Activity activity = (Activity) GameQuestionExpertListFragment.this.T.get();
            if (activity != null && i3 < GameQuestionExpertListFragment.this.R.getCount()) {
                GameQuestionExpertListFragment.this.Mh(activity, GameQuestionExpertListFragment.this.R.getItem(i3));
                GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
                gameStrategyChannelEntry.guildId = GameQuestionExpertListFragment.this.L.f441456a;
                gameStrategyChannelEntry.channelId = GameQuestionExpertListFragment.this.L.f441457b;
                com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907546", "20", String.valueOf(GameQuestionExpertListFragment.this.L.f441458c), GameQAUtil.i(activity, gameStrategyChannelEntry));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!GameQuestionExpertListFragment.this.X) {
                GameQuestionExpertListFragment.this.X = true;
                GameQuestionExpertListFragment.this.Qh(z16);
                GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
                gameStrategyChannelEntry.guildId = GameQuestionExpertListFragment.this.L.f441456a;
                gameStrategyChannelEntry.channelId = GameQuestionExpertListFragment.this.L.f441457b;
                Map<Integer, String> i3 = GameQAUtil.i((Activity) GameQuestionExpertListFragment.this.T.get(), gameStrategyChannelEntry);
                if (z16) {
                    str = "0";
                } else {
                    str = "1";
                }
                i3.put(3, str);
                com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907236", "20", String.valueOf(GameQuestionExpertListFragment.this.L.f441458c), i3);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class h extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<com.tencent.mobileqq.gamecenter.qa.model.d> f212466d;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements e.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ImageView f212467d;

            a(ImageView imageView) {
                this.f212467d = imageView;
            }

            @Override // gp3.e.b
            public void onImageLoaded(String str, final Bitmap bitmap, String str2) {
                final ImageView imageView = this.f212467d;
                imageView.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        static class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f212469a;

            /* renamed from: b, reason: collision with root package name */
            TextView f212470b;

            /* renamed from: c, reason: collision with root package name */
            TextView f212471c;

            /* renamed from: d, reason: collision with root package name */
            ImageView f212472d;

            b() {
            }
        }

        h() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.gamecenter.qa.model.d getItem(int i3) {
            List<com.tencent.mobileqq.gamecenter.qa.model.d> list = this.f212466d;
            if (list != null) {
                return list.get(i3);
            }
            return null;
        }

        public void b(List<com.tencent.mobileqq.gamecenter.qa.model.d> list) {
            this.f212466d = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<com.tencent.mobileqq.gamecenter.qa.model.d> list = this.f212466d;
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
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ebv, (ViewGroup) null);
                bVar = new b();
                bVar.f212469a = (ImageView) view.findViewById(R.id.xjr);
                bVar.f212470b = (TextView) view.findViewById(R.id.ke8);
                bVar.f212471c = (TextView) view.findViewById(R.id.f113046pk);
                bVar.f212472d = (ImageView) view.findViewById(R.id.xed);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mobileqq.gamecenter.qa.model.d item = getItem(i3);
            if (item != null) {
                GameQuestionUserInfo gameQuestionUserInfo = item.f212638c;
                if (gameQuestionUserInfo != null) {
                    Bitmap b16 = gp3.e.a().b(gameQuestionUserInfo.avatar);
                    if (b16 != null) {
                        bVar.f212469a.setImageBitmap(b16);
                    } else {
                        gp3.e.a().c(gameQuestionUserInfo.avatar, new a(bVar.f212469a));
                    }
                    bVar.f212470b.setText(gameQuestionUserInfo.name);
                } else {
                    bVar.f212469a.setImageResource(R.drawable.f160830com);
                    bVar.f212470b.setText("");
                }
                int i16 = 0;
                bVar.f212471c.setText(String.format("\u5171\u56de\u7b54%s\u4e2a\u95ee\u9898\uff0c\u83b7\u5f97%s\u4e2a\u8d5e", Long.valueOf(item.f212636a), Long.valueOf(item.f212637b)));
                ImageView imageView = bVar.f212472d;
                if (!item.f212639d) {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    public GameQuestionExpertListFragment(QBaseActivity qBaseActivity, boolean z16) {
        this.T = new WeakReference<>(qBaseActivity);
        this.W = z16;
    }

    private void Ih() {
        this.K.Z0(this.Z);
        fe1.c cVar = this.K;
        vd1.b bVar = this.L;
        cVar.M(bVar.f441457b, bVar.f441458c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        this.K.Z0(this.Z);
        if (!this.M) {
            fe1.c cVar = this.K;
            vd1.b bVar = this.L;
            cVar.Y(bVar.f441456a, bVar.f441457b, bVar.f441458c, this.N, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        this.K.Z0(this.Z);
        fe1.c cVar = this.K;
        vd1.b bVar = this.L;
        cVar.W(bVar.f441456a, bVar.f441457b, bVar.f441458c);
    }

    private void Lh() {
        final QBaseActivity qBaseActivity = this.T.get();
        if (qBaseActivity != null) {
            IQQGameStrategyService iQQGameStrategyService = (IQQGameStrategyService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameStrategyService.class, "");
            vd1.b bVar = this.L;
            iQQGameStrategyService.openGameStrategyAnswerAction(bVar.f441457b, bVar.f441458c, new ce1.a() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.9
                @Override // ce1.a
                public void a(boolean z16, boolean z17, GameStrategyAuthRequire gameStrategyAuthRequire) {
                    QLog.d("GameQuestionExpertListFragment", 1, "openExpertVerify, onAuthResult, isSuccess=", Boolean.valueOf(z16));
                    if (!z16) {
                        return;
                    }
                    QLog.d("GameQuestionExpertListFragment", 1, "openExpertVerify, onAuthResult, needShowAuth=", Boolean.valueOf(z17));
                    if (z17) {
                        ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyAuthDialog(qBaseActivity, GameQuestionExpertListFragment.this.L.f441458c, gameStrategyAuthRequire);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(qBaseActivity, R.string.f1368805c, 0).show();
                                GameQuestionExpertListFragment.this.E.setVisibility(4);
                            }
                        });
                    }
                }
            });
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar2 = this.L;
            gameStrategyChannelEntry.guildId = bVar2.f441456a;
            gameStrategyChannelEntry.channelId = bVar2.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907093", "20", String.valueOf(bVar2.f441458c), GameQAUtil.i(this.T.get(), gameStrategyChannelEntry));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(Activity activity, com.tencent.mobileqq.gamecenter.qa.model.d dVar) {
        Intent intent = new Intent();
        String format = String.format("https://speed.gamecenter.qq.com/pushgame/v1/game-profile?wv=18950115&_wwv=265&tab=2&from=qaChannel&appId=%s", Integer.valueOf(this.L.f441458c));
        if (!dVar.f212638c.isSelf) {
            try {
                format = format + "&userId=" + URLEncoder.encode(dVar.f212638c.encodedUin, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                QLog.e("GameQuestionExpertListFragment", 1, "encode exception=", e16);
            }
        }
        intent.putExtra("url", format);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        QLog.d("GameQuestionExpertListFragment", 1, "refreshExpertList");
        this.M = false;
        this.N = 0;
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(boolean z16) {
        this.K.Z0(this.Z);
        fe1.c cVar = this.K;
        vd1.b bVar = this.L;
        cVar.I(bVar.f441456a, bVar.f441457b, bVar.f441458c, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(com.tencent.mobileqq.gamecenter.qa.model.e eVar) {
        boolean z16;
        GameQuestionUserInfo gameQuestionUserInfo;
        if (eVar == null) {
            return;
        }
        this.M = eVar.f212641b;
        int i3 = eVar.f212643d;
        this.N = i3;
        if (i3 == 0) {
            this.G.setText(String.format("\u8ba4\u8bc1\u5927\u795e\uff08%s\uff09", Long.valueOf(eVar.f212642c)));
            this.P.clear();
        }
        List<com.tencent.mobileqq.gamecenter.qa.model.d> list = eVar.f212640a;
        if (list != null && list.size() > 0) {
            for (com.tencent.mobileqq.gamecenter.qa.model.d dVar : eVar.f212640a) {
                Iterator<com.tencent.mobileqq.gamecenter.qa.model.d> it = this.P.iterator();
                while (true) {
                    if (it.hasNext()) {
                        com.tencent.mobileqq.gamecenter.qa.model.d next = it.next();
                        GameQuestionUserInfo gameQuestionUserInfo2 = dVar.f212638c;
                        if (gameQuestionUserInfo2 != null) {
                            long j3 = gameQuestionUserInfo2.uin;
                            if (j3 != 0 && (gameQuestionUserInfo = next.f212638c) != null && j3 == gameQuestionUserInfo.uin) {
                                z16 = true;
                                break;
                            }
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.P.add(dVar);
                }
            }
            this.R.b(this.P);
            this.R.notifyDataSetChanged();
        }
        this.N++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        if (this.Q) {
            this.E.setVisibility(4);
        } else {
            this.E.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        QLog.d("GameQuestionExpertListFragment", 1, "updateOnlineSwitch mIsExpert=", Boolean.valueOf(this.Q), ", mIsOnline=", Boolean.valueOf(this.V));
        if (this.Q) {
            this.H.setVisibility(0);
            if (this.V) {
                this.I.setChecked(true);
            } else {
                this.I.setChecked(false);
            }
            this.I.setOnCheckedChangeListener(new e());
            return;
        }
        this.H.setVisibility(8);
    }

    private void init() {
        this.D.setVerticalScrollBarEnabled(false);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167990ec0, (ViewGroup) this.D, false);
        this.F = inflate;
        this.D.setOverScrollFooter(inflate);
        this.D.setOverScrollListener(this.f212447a0);
        this.D.setOnScrollListener(this.Y);
        this.D.setOnTouchListener(new b());
        h hVar = new h();
        this.R = hVar;
        this.D.setAdapter((ListAdapter) hVar);
        this.D.setOnItemClickListener(new c());
        Sh(this.S);
        Th();
    }

    public void Oh(com.tencent.mobileqq.gamecenter.qa.model.e eVar) {
        this.S = eVar;
    }

    public void Ph(boolean z16) {
        this.Q = z16;
    }

    public void Rh(vd1.b bVar) {
        this.L = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.u6o) {
            Lh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.avl;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i3;
        View inflate = layoutInflater.inflate(R.layout.ebu, viewGroup);
        this.C = inflate;
        this.D = (XListView) inflate.findViewById(R.id.yjh);
        View findViewById = this.C.findViewById(R.id.u6o);
        this.E = findViewById;
        findViewById.setOnClickListener(this);
        this.G = (TextView) this.C.findViewById(R.id.f113036pj);
        this.H = this.C.findViewById(R.id.u76);
        this.I = (Switch) this.C.findViewById(R.id.f913054t);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.uyf);
        this.J = imageView;
        if (this.W) {
            i3 = R.drawable.mwe;
        } else {
            i3 = R.drawable.mwd;
        }
        imageView.setBackgroundResource(i3);
        this.C.findViewById(R.id.vkd).setOnClickListener(new a());
        init();
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.L;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907092", "8", String.valueOf(bVar.f441458c), GameQAUtil.i(this.T.get(), gameStrategyChannelEntry));
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.K.N0();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Nh();
        Ih();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
        BottomSheetBehavior<FrameLayout> behavior = ((com.google.android.material.bottomsheet.a) getDialog()).getBehavior();
        this.U = behavior;
        behavior.setState(3);
        this.U.setPeekHeight(0);
        this.U.addBottomSheetCallback(new d());
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d extends BottomSheetBehavior.e {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 4) {
                GameQuestionExpertListFragment.this.dismiss();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements OverScrollViewListener {
        g() {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            GameQuestionExpertListFragment.this.D.hideOverScrollerFooterView();
            return true;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements AbsListView.OnScrollListener {
        f() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (GameQuestionExpertListFragment.this.D.getOverScrollFooterView() != null && GameQuestionExpertListFragment.this.D.getCount() - GameQuestionExpertListFragment.this.D.getLastVisiblePosition() < 5) {
                if (!GameQuestionExpertListFragment.this.M) {
                    GameQuestionExpertListFragment.this.Jh();
                } else {
                    GameQuestionExpertListFragment.this.D.setOverScrollFooter(null);
                }
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
