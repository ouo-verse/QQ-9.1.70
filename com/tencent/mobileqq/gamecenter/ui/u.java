package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$RedDotMsg;
import com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes12.dex */
public class u extends GameMsgBoxHeaderManager.b {

    /* renamed from: c, reason: collision with root package name */
    private GameMsgMgrSvr$RedDotMsg f213376c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f213377d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f213378e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f213379f;

    /* renamed from: g, reason: collision with root package name */
    private View f213380g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f213381h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f213382i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f213383j;

    public u(@NonNull Context context) {
        super(context);
        this.f213377d = false;
        this.f213378e = false;
        this.f213379f = false;
        j();
    }

    private static Drawable g(Context context, int i3, float f16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getColor(i3));
        gradientDrawable.setCornerRadius(Utils.n(f16, context.getResources()));
        return gradientDrawable;
    }

    private void h() {
        if (QQTheme.isNowThemeIsNight()) {
            this.f213380g.setBackgroundColor(this.f213259a.getColor(R.color.bjy));
            this.f213382i.setTextColor(-1);
            this.f213383j.setBackground(g(this.f213259a, R.color.bf_, 2.0f));
        } else {
            this.f213380g.setBackgroundColor(this.f213259a.getColor(R.color.bjx));
            this.f213382i.setTextColor(-16777216);
            this.f213383j.setBackground(g(this.f213259a, R.color.bf9, 2.0f));
        }
    }

    private void j() {
        View inflate = View.inflate(this.f213259a, R.layout.eaq, null);
        this.f213380g = inflate;
        this.f213381h = (ImageView) inflate.findViewById(R.id.dvu);
        this.f213382i = (TextView) this.f213380g.findViewById(R.id.f109436ft);
        this.f213383j = (TextView) this.f213380g.findViewById(R.id.k56);
        this.f213380g.setVisibility(8);
        h();
        this.f213383j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.ui.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.this.k(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f213377d = true;
        GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg = this.f213376c;
        if (gameMsgMgrSvr$RedDotMsg != null) {
            GameCenterUtil.jumpUrlOrSchema(this.f213259a, gameMsgMgrSvr$RedDotMsg.jump_url.get());
        }
        GameMsgBoxHeaderManager.c cVar = this.f213260b;
        if (cVar != null) {
            cVar.a();
        }
        l();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void l() {
        String str;
        GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg = this.f213376c;
        if (gameMsgMgrSvr$RedDotMsg != null) {
            str = gameMsgMgrSvr$RedDotMsg.item_id.get();
        } else {
            str = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext4", "20");
        hashMap.put("ext2", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92048", "915398", "", hashMap);
    }

    private void m() {
        String str;
        GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg = this.f213376c;
        if (gameMsgMgrSvr$RedDotMsg != null) {
            str = gameMsgMgrSvr$RedDotMsg.item_id.get();
        } else {
            str = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext4", "8");
        hashMap.put("ext2", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92048", "915379", "", hashMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public void a(@NonNull FrameLayout frameLayout) {
        View view = this.f213380g;
        if (view == null) {
            return;
        }
        if (view.getParent() != frameLayout) {
            if (this.f213380g.getParent() != null) {
                ((ViewGroup) this.f213380g.getParent()).removeView(this.f213380g);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = Utils.n(49.0f, this.f213259a.getResources());
            frameLayout.addView(this.f213380g, layoutParams);
        }
        if (!this.f213379f) {
            this.f213379f = true;
            this.f213380g.setVisibility(0);
            GameMsgBoxHeaderManager.c cVar = this.f213260b;
            if (cVar != null) {
                cVar.b();
            }
            m();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public void b() {
        this.f213379f = false;
        this.f213380g.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public boolean c() {
        if (this.f213376c != null && this.f213378e && !this.f213377d) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager.b
    public void d(String str) {
        this.f213378e = TextUtils.equals("all", str);
    }

    public GameMsgMgrSvr$RedDotMsg i() {
        return this.f213376c;
    }

    public void n(@Nullable GameMsgMgrSvr$RedDotMsg gameMsgMgrSvr$RedDotMsg) {
        this.f213376c = gameMsgMgrSvr$RedDotMsg;
        if (gameMsgMgrSvr$RedDotMsg == null) {
            return;
        }
        this.f213382i.setText(gameMsgMgrSvr$RedDotMsg.title.get());
        if (!TextUtils.isEmpty(gameMsgMgrSvr$RedDotMsg.icon.get())) {
            this.f213381h.setImageDrawable(URLDrawable.getDrawable(gameMsgMgrSvr$RedDotMsg.icon.get(), URLDrawable.URLDrawableOptions.obtain()));
        }
        if (!TextUtils.isEmpty(gameMsgMgrSvr$RedDotMsg.btn_text.get())) {
            this.f213383j.setText(gameMsgMgrSvr$RedDotMsg.btn_text.get());
        } else {
            TextView textView = this.f213383j;
            textView.setText(textView.getResources().getText(R.string.f1374406v));
        }
    }
}
