package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GetGameGiftListRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$Gift;
import com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class r extends GameMsgBoxHeaderManager.b {

    /* renamed from: c, reason: collision with root package name */
    private View f213358c;

    /* renamed from: d, reason: collision with root package name */
    private View f213359d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f213360e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f213361f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f213362g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f213363h;

    /* renamed from: i, reason: collision with root package name */
    private List<ImageView> f213364i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f213365j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f213366k;

    /* renamed from: l, reason: collision with root package name */
    private List<GameMsgMgrSvr$Gift> f213367l;

    /* renamed from: m, reason: collision with root package name */
    private GameMsgMgrSvr$Gift f213368m;

    /* renamed from: n, reason: collision with root package name */
    private String f213369n;

    /* renamed from: o, reason: collision with root package name */
    private GameMsgMgrSvr$Gift f213370o;

    /* renamed from: p, reason: collision with root package name */
    private long f213371p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (r.this.f213370o != null) {
                GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, r.this.f213370o.receive_url.get());
                QLog.d("GameMsgBoxHeaderGiftItem", 2, "[initView] goto url:" + r.this.f213370o.receive_url.get());
                r rVar = r.this;
                rVar.j(rVar.f213370o.appid.get());
                GameMsgBoxHeaderManager.c cVar = r.this.f213260b;
                if (cVar != null) {
                    cVar.a();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public r(Context context) {
        super(context);
        this.f213364i = new ArrayList();
        this.f213371p = 0L;
        i();
    }

    private void h() {
        if (QQTheme.isNowThemeIsNight()) {
            this.f213358c.setBackgroundColor(this.f213259a.getColor(R.color.bjy));
            this.f213365j.setTextColor(-1);
        } else {
            this.f213358c.setBackgroundColor(this.f213259a.getColor(R.color.bjx));
            this.f213365j.setTextColor(-16777216);
        }
    }

    private void i() {
        View inflate = View.inflate(this.f213259a, R.layout.eap, null);
        this.f213358c = inflate;
        this.f213359d = inflate.findViewById(R.id.vjj);
        this.f213360e = (ImageView) this.f213358c.findViewById(R.id.dvn);
        this.f213361f = (ImageView) this.f213358c.findViewById(R.id.y4n);
        this.f213362g = (ImageView) this.f213358c.findViewById(R.id.y4o);
        this.f213363h = (ImageView) this.f213358c.findViewById(R.id.y4p);
        this.f213364i.add(this.f213361f);
        this.f213364i.add(this.f213362g);
        this.f213364i.add(this.f213363h);
        this.f213365j = (TextView) this.f213358c.findViewById(R.id.f109436ft);
        this.f213366k = (ImageView) this.f213358c.findViewById(R.id.xzl);
        this.f213358c.setVisibility(8);
        this.f213366k.setOnClickListener(new a());
        this.f213359d.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext21", ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getNetWorkTypeStr());
        hashMap.put("ext4", "20");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92047", "915297", "", hashMap);
    }

    private void k(String str) {
        GameMsgMgrSvr$Gift gameMsgMgrSvr$Gift = this.f213370o;
        if (gameMsgMgrSvr$Gift != null && gameMsgMgrSvr$Gift == this.f213368m) {
            if (Math.abs(System.currentTimeMillis() - this.f213371p) < 500) {
                return;
            } else {
                this.f213371p = System.currentTimeMillis();
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext21", ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getNetWorkTypeStr());
        hashMap.put("ext4", "8");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92047", "915296", "", hashMap);
    }

    private void m() {
        GameMsgMgrSvr$Gift gameMsgMgrSvr$Gift;
        if (TextUtils.isEmpty(this.f213369n)) {
            return;
        }
        if (TextUtils.equals("all", this.f213369n)) {
            gameMsgMgrSvr$Gift = this.f213368m;
        } else {
            gameMsgMgrSvr$Gift = null;
        }
        List<GameMsgMgrSvr$Gift> list = this.f213367l;
        if (list != null) {
            for (GameMsgMgrSvr$Gift gameMsgMgrSvr$Gift2 : list) {
                if (gameMsgMgrSvr$Gift2 != null && TextUtils.equals(gameMsgMgrSvr$Gift2.appid.get(), this.f213369n)) {
                    gameMsgMgrSvr$Gift = gameMsgMgrSvr$Gift2;
                }
            }
        }
        if (this.f213370o != gameMsgMgrSvr$Gift) {
            this.f213370o = gameMsgMgrSvr$Gift;
            if (gameMsgMgrSvr$Gift != null) {
                n(gameMsgMgrSvr$Gift);
            }
        }
    }

    private void n(GameMsgMgrSvr$Gift gameMsgMgrSvr$Gift) {
        String str;
        if (gameMsgMgrSvr$Gift == null) {
            return;
        }
        QLog.i("GameMsgBoxHeaderGiftItem", 2, "[updateView] updateView=====");
        try {
            String str2 = gameMsgMgrSvr$Gift.game_icon.get();
            if ("all".equals(this.f213369n) && !TextUtils.isEmpty(str2)) {
                this.f213360e.setVisibility(0);
                this.f213360e.setImageDrawable(URLDrawable.getDrawable(new URL(str2), URLDrawable.URLDrawableOptions.obtain()));
            } else {
                this.f213360e.setVisibility(8);
            }
            List<String> list = gameMsgMgrSvr$Gift.icons.get();
            if (list != null) {
                for (int i3 = 0; i3 < this.f213364i.size(); i3++) {
                    if (i3 < list.size()) {
                        str = list.get(i3);
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f213364i.get(i3).setVisibility(8);
                    } else {
                        this.f213364i.get(i3).setVisibility(0);
                        this.f213364i.get(i3).setImageDrawable(URLDrawable.getDrawable(new URL(str), URLDrawable.URLDrawableOptions.obtain()));
                    }
                }
            }
            this.f213365j.setText(gameMsgMgrSvr$Gift.title.get());
        } catch (Exception e16) {
            QLog.e("GameMsgBoxHeaderGiftItem", 2, "[updata] " + e16);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public void a(@NonNull FrameLayout frameLayout) {
        View view = this.f213358c;
        if (view == null) {
            return;
        }
        if (view.getParent() != frameLayout) {
            if (this.f213358c.getParent() != null) {
                ((ViewGroup) this.f213358c.getParent()).removeView(this.f213358c);
            }
            frameLayout.addView(this.f213358c);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f213359d.getLayoutParams();
            layoutParams.height = Utils.n(49.0f, BaseApplication.getContext().getResources());
            this.f213359d.setLayoutParams(layoutParams);
        }
        this.f213358c.setVisibility(0);
        k(this.f213370o.appid.get());
        GameMsgBoxHeaderManager.c cVar = this.f213260b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public void b() {
        this.f213358c.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public boolean c() {
        if (this.f213370o != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public void d(String str) {
        QLog.i("GameMsgBoxHeaderGiftItem", 2, "[onTabUpdate] udpate: " + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("GameMsgBoxHeaderGiftItem", 2, "[onTabUpdate] appId is null.");
        } else {
            this.f213369n = str;
            m();
        }
    }

    public void l(GameMsgMgrSvr$GetGameGiftListRsp gameMsgMgrSvr$GetGameGiftListRsp) {
        if (gameMsgMgrSvr$GetGameGiftListRsp != null) {
            GameMsgMgrSvr$Gift gameMsgMgrSvr$Gift = gameMsgMgrSvr$GetGameGiftListRsp.current_play_gift.get();
            if (gameMsgMgrSvr$Gift != null && (TextUtils.isEmpty(gameMsgMgrSvr$Gift.appid.get()) || TextUtils.isEmpty(gameMsgMgrSvr$Gift.receive_url.get()))) {
                this.f213368m = null;
            } else {
                this.f213368m = gameMsgMgrSvr$Gift;
            }
            this.f213367l = gameMsgMgrSvr$GetGameGiftListRsp.gifts.get();
        } else {
            this.f213368m = null;
            this.f213367l = null;
        }
        if (this.f213367l != null) {
            QLog.i("GameMsgBoxHeaderGiftItem", 2, "[setGiftData] gifts size:" + this.f213367l.size());
        }
        m();
    }
}
