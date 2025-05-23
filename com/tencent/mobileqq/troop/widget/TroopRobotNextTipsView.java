package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$RobotSubscribeCategory;
import com.tencent.mobileqq.troop.utils.bd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopRobotNextTipsView extends RelativeLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    static int f302464m;

    /* renamed from: d, reason: collision with root package name */
    TextView f302465d;

    /* renamed from: e, reason: collision with root package name */
    QQAppInterface f302466e;

    /* renamed from: f, reason: collision with root package name */
    ChatMessage f302467f;

    /* renamed from: h, reason: collision with root package name */
    Context f302468h;

    /* renamed from: i, reason: collision with root package name */
    oidb_0x496$RobotSubscribeCategory f302469i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f302464m = Color.parseColor("#12B7F5");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view.getId() == R.id.avp) {
            bd bdVar = (bd) this.f302466e.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
            ChatFragment chatFragment = ((BaseActivity) this.f302468h).getChatFragment();
            if (chatFragment != null && chatFragment.qh() != null) {
                a61.c qh5 = chatFragment.qh();
                if (this.f302469i != null) {
                    bdVar.l(getContext(), qh5, this.f302466e, qh5.f25587l, qh5.f25589n, this.f302467f, this.f302469i.next_content.get());
                } else {
                    bdVar.l(getContext(), qh5, this.f302466e, qh5.f25587l, qh5.f25589n, this.f302467f, this.f302465d.getText().toString());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
