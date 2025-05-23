package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import QQService.InteRemarkInfo;
import QQService.RespGetDiscussInfo;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JoinDiscussionActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    String f176285a0;

    /* renamed from: b0, reason: collision with root package name */
    String f176286b0;

    /* renamed from: c0, reason: collision with root package name */
    ImageView f176287c0;

    /* renamed from: d0, reason: collision with root package name */
    TextView f176288d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f176289e0;

    /* renamed from: f0, reason: collision with root package name */
    private Button f176290f0;

    /* renamed from: g0, reason: collision with root package name */
    int f176291g0;

    /* renamed from: h0, reason: collision with root package name */
    DiscussionHandler f176292h0;

    /* renamed from: i0, reason: collision with root package name */
    private MyDiscussionObserver f176293i0;

    /* renamed from: j0, reason: collision with root package name */
    private FaceObserver f176294j0;

    /* renamed from: k0, reason: collision with root package name */
    String f176295k0;

    /* renamed from: l0, reason: collision with root package name */
    String f176296l0;

    /* renamed from: m0, reason: collision with root package name */
    List<DiscussMemberInfo> f176297m0;

    /* renamed from: n0, reason: collision with root package name */
    long f176298n0;

    /* renamed from: o0, reason: collision with root package name */
    String f176299o0;

    /* renamed from: p0, reason: collision with root package name */
    long f176300p0;

    /* renamed from: q0, reason: collision with root package name */
    int f176301q0;

    /* renamed from: r0, reason: collision with root package name */
    String f176302r0;

    /* renamed from: s0, reason: collision with root package name */
    ArrayList<String> f176303s0;

    /* renamed from: t0, reason: collision with root package name */
    private RelativeLayout f176304t0;

    /* renamed from: u0, reason: collision with root package name */
    private RelativeLayout f176305u0;

    /* renamed from: v0, reason: collision with root package name */
    private com.tencent.mobileqq.app.ar f176306v0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class FaceObserver extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        FaceObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinDiscussionActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (z16) {
                JoinDiscussionActivity joinDiscussionActivity = JoinDiscussionActivity.this;
                if (joinDiscussionActivity.f176297m0 == null || joinDiscussionActivity.app.getCurrentAccountUin().equals(str)) {
                    return;
                }
                Iterator<DiscussMemberInfo> it = JoinDiscussionActivity.this.f176297m0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (String.valueOf(it.next().Uin).equals(str)) {
                        z17 = true;
                        break;
                    }
                }
                if (z17 && !JoinDiscussionActivity.this.f176303s0.contains(str)) {
                    JoinDiscussionActivity.this.f176303s0.add(str);
                    StringBuilder sb5 = new StringBuilder();
                    JoinDiscussionActivity joinDiscussionActivity2 = JoinDiscussionActivity.this;
                    sb5.append(joinDiscussionActivity2.f176302r0);
                    sb5.append(str);
                    sb5.append(";");
                    joinDiscussionActivity2.f176302r0 = sb5.toString();
                    if (JoinDiscussionActivity.this.f176303s0.size() == JoinDiscussionActivity.this.f176301q0) {
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.JoinDiscussionActivity.FaceObserver.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceObserver.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                JoinDiscussionActivity joinDiscussionActivity3 = JoinDiscussionActivity.this;
                                JoinDiscussionActivity.this.runOnUiThread(new Runnable(joinDiscussionActivity3.f176292h0.N2(joinDiscussionActivity3.f176302r0)) { // from class: com.tencent.mobileqq.activity.JoinDiscussionActivity.FaceObserver.1.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Bitmap f176309d;

                                    {
                                        this.f176309d = r5;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            JoinDiscussionActivity.this.f176287c0.setImageBitmap(this.f176309d);
                                        }
                                    }
                                });
                            }
                        }, 8, null, true);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class MyDiscussionObserver extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        MyDiscussionObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinDiscussionActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void j(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            } else {
                if (z16) {
                    JoinDiscussionActivity joinDiscussionActivity = JoinDiscussionActivity.this;
                    joinDiscussionActivity.f176285a0 = str;
                    joinDiscussionActivity.f176292h0.X2(str);
                    return;
                }
                JoinDiscussionActivity.this.K2(0, -161);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void m(boolean z16, int i3, RespGetDiscussInfo respGetDiscussInfo) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), respGetDiscussInfo);
                return;
            }
            if (z16) {
                JoinDiscussionActivity.this.stopTitleProgress();
                JoinDiscussionActivity.this.f176296l0 = String.valueOf(respGetDiscussInfo.DiscussUin);
                JoinDiscussionActivity joinDiscussionActivity = JoinDiscussionActivity.this;
                joinDiscussionActivity.f176295k0 = respGetDiscussInfo.Name;
                joinDiscussionActivity.f176297m0 = respGetDiscussInfo.Members;
                joinDiscussionActivity.f176298n0 = respGetDiscussInfo.OwnerUin;
                joinDiscussionActivity.f176300p0 = respGetDiscussInfo.CreateTime * 1000;
                HashMap hashMap = new HashMap();
                List<DiscussMemberInfo> list = JoinDiscussionActivity.this.f176297m0;
                if (list != null) {
                    for (DiscussMemberInfo discussMemberInfo : list) {
                        long j3 = discussMemberInfo.Uin;
                        JoinDiscussionActivity joinDiscussionActivity2 = JoinDiscussionActivity.this;
                        if (j3 == joinDiscussionActivity2.f176298n0) {
                            joinDiscussionActivity2.f176299o0 = discussMemberInfo.StInteRemark.StrValue;
                        }
                        String valueOf = String.valueOf(j3);
                        DiscussionMemberInfo discussionMemberInfo = new DiscussionMemberInfo();
                        discussionMemberInfo.discussionUin = JoinDiscussionActivity.this.f176296l0;
                        discussionMemberInfo.memberUin = valueOf;
                        discussionMemberInfo.flag = discussMemberInfo.Flag;
                        InteRemarkInfo inteRemarkInfo = discussMemberInfo.StInteRemark;
                        if (inteRemarkInfo != null && !TextUtils.isEmpty(inteRemarkInfo.StrValue)) {
                            InteRemarkInfo inteRemarkInfo2 = discussMemberInfo.StInteRemark;
                            discussionMemberInfo.inteRemark = inteRemarkInfo2.StrValue;
                            discussionMemberInfo.inteRemarkSource = inteRemarkInfo2.Source;
                        } else if (TextUtils.isEmpty(discussionMemberInfo.inteRemark)) {
                            Friends u16 = ((FriendsManager) JoinDiscussionActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(discussionMemberInfo.memberUin);
                            if (u16 != null && u16.isFriend()) {
                                discussionMemberInfo.memberName = u16.name;
                                if (TextUtils.isEmpty(u16.remark)) {
                                    str = u16.name;
                                } else {
                                    str = u16.remark;
                                }
                                discussionMemberInfo.inteRemark = str;
                                discussionMemberInfo.inteRemarkSource = 129L;
                            } else {
                                discussionMemberInfo.inteRemarkSource = 0L;
                            }
                        }
                        hashMap.put(discussionMemberInfo.memberUin, discussionMemberInfo);
                    }
                    ArrayList arrayList = new ArrayList();
                    JoinDiscussionActivity joinDiscussionActivity3 = JoinDiscussionActivity.this;
                    if (joinDiscussionActivity3.f176297m0 != null) {
                        long parseLong = Long.parseLong(joinDiscussionActivity3.app.getCurrentAccountUin());
                        for (int i16 = 0; i16 < JoinDiscussionActivity.this.f176297m0.size(); i16++) {
                            if (JoinDiscussionActivity.this.f176297m0.get(i16).Uin != parseLong) {
                                arrayList.add(Long.valueOf(JoinDiscussionActivity.this.f176297m0.get(i16).Uin));
                            }
                        }
                    }
                    JoinDiscussionActivity.this.f176301q0 = Math.min(arrayList.size(), 9);
                    JoinDiscussionActivity.this.f176303s0.clear();
                    JoinDiscussionActivity.this.f176302r0 = "";
                    for (int i17 = 0; i17 < JoinDiscussionActivity.this.f176301q0; i17++) {
                        String valueOf2 = String.valueOf(arrayList.get(i17));
                        if (FaceDrawable.getFaceDrawable(JoinDiscussionActivity.this.app, 1, valueOf2) != null) {
                            JoinDiscussionActivity.this.f176303s0.add(valueOf2);
                            StringBuilder sb5 = new StringBuilder();
                            JoinDiscussionActivity joinDiscussionActivity4 = JoinDiscussionActivity.this;
                            sb5.append(joinDiscussionActivity4.f176302r0);
                            sb5.append(String.valueOf(arrayList.get(i17)));
                            sb5.append(";");
                            joinDiscussionActivity4.f176302r0 = sb5.toString();
                        }
                    }
                }
                long j16 = respGetDiscussInfo.DiscussFlag | 536870912;
                JoinDiscussionActivity joinDiscussionActivity5 = JoinDiscussionActivity.this;
                joinDiscussionActivity5.f176295k0 = com.tencent.mobileqq.utils.ac.A0(joinDiscussionActivity5.app, joinDiscussionActivity5.f176296l0, String.valueOf(joinDiscussionActivity5.f176298n0), j16, respGetDiscussInfo.Name, hashMap);
                if (JoinDiscussionActivity.this.f176303s0.size() == JoinDiscussionActivity.this.f176301q0) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyDiscussionObserver.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            JoinDiscussionActivity joinDiscussionActivity6 = JoinDiscussionActivity.this;
                            JoinDiscussionActivity.this.runOnUiThread(new Runnable(joinDiscussionActivity6.f176292h0.N2(joinDiscussionActivity6.f176302r0)) { // from class: com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Bitmap f176313d;

                                {
                                    this.f176313d = r5;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        JoinDiscussionActivity.this.f176287c0.setImageBitmap(this.f176313d);
                                    }
                                }
                            });
                        }
                    }, 8, null, true);
                }
                JoinDiscussionActivity.this.L2();
                if (TextUtils.isEmpty(JoinDiscussionActivity.this.f176299o0)) {
                    ((FriendListHandler) JoinDiscussionActivity.this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(JoinDiscussionActivity.this.f176298n0 + "", false);
                    return;
                }
                return;
            }
            JoinDiscussionActivity.this.K2(0, i3);
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void p(boolean z16, long j3, int i3) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (z16) {
                QQAppInterface qQAppInterface = JoinDiscussionActivity.this.app;
                ReportController.o(qQAppInterface, "CliOper", "", qQAppInterface.getCurrentAccountUin(), "discuss", "discuss_QR_join", 0, 0, "", "", "", "");
                JoinDiscussionActivity.this.stopTitleProgress();
                String valueOf = String.valueOf(j3);
                if (valueOf != null && valueOf.length() > 0) {
                    JoinDiscussionActivity joinDiscussionActivity = JoinDiscussionActivity.this;
                    if (joinDiscussionActivity.f176297m0 != null) {
                        long parseLong = Long.parseLong(joinDiscussionActivity.app.getCurrentAccountUin());
                        for (int i16 = 0; i16 < JoinDiscussionActivity.this.f176297m0.size(); i16++) {
                            if (JoinDiscussionActivity.this.f176297m0.get(i16).Uin == parseLong) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                        QQToast.makeText(JoinDiscussionActivity.this, HardCodeUtil.qqStr(R.string.ni7), 0).show(JoinDiscussionActivity.this.getTitleBarHeight());
                    }
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(JoinDiscussionActivity.this), null);
                    m3.putExtra("uin", valueOf);
                    m3.putExtra("uintype", 3000);
                    m3.putExtra("uinname", JoinDiscussionActivity.this.f176295k0);
                    m3.putExtra("isBack2Root", true);
                    m3.putExtra("isFromDiscussionFlyTicket", true);
                    JoinDiscussionActivity.this.startActivity(m3);
                    JoinDiscussionActivity.this.finish();
                    return;
                }
                return;
            }
            JoinDiscussionActivity.this.K2(1, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinDiscussionActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                JoinDiscussionActivity.this.I2();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinDiscussionActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(JoinDiscussionActivity.this.f176298n0 + ""), "IphoneTitleBarActivity");
                if (friendsSimpleInfoWithUid != null) {
                    JoinDiscussionActivity.this.f176299o0 = friendsSimpleInfoWithUid.p();
                    JoinDiscussionActivity.this.L2();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "get owner name failed");
            }
        }
    }

    public JoinDiscussionActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176291g0 = 0;
        this.f176295k0 = "";
        this.f176299o0 = "";
        this.f176301q0 = 0;
        this.f176302r0 = "";
        this.f176303s0 = new ArrayList<>();
        this.f176306v0 = new b();
    }

    private void H2() {
        if (NetworkUtil.isNetSupport(this)) {
            startTitleProgress();
            String str = this.f176285a0;
            if (str != null && str.length() > 0) {
                this.f176292h0.X2(this.f176285a0);
                return;
            }
            String str2 = this.f176286b0;
            if (str2 != null && str2.length() > 0) {
                this.f176292h0.O2(this.f176286b0);
                return;
            }
            return;
        }
        K2(0, -160);
    }

    private void J2() {
        setTitle(HardCodeUtil.qqStr(R.string.ni_));
        setRightButton(R.string.cancel, this);
        this.leftView.setVisibility(4);
        this.f176290f0.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.JoinDiscussionActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinDiscussionActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String substring = StringUtil.substring(JoinDiscussionActivity.this.f176295k0, 0, 32);
                String substring2 = StringUtil.substring(JoinDiscussionActivity.this.f176299o0, 0, 32);
                JoinDiscussionActivity joinDiscussionActivity = JoinDiscussionActivity.this;
                if (joinDiscussionActivity.f176297m0 != null) {
                    joinDiscussionActivity.f176288d0.setText(substring + String.format("(%d\u4eba)", Integer.valueOf(JoinDiscussionActivity.this.f176297m0.size())));
                } else {
                    joinDiscussionActivity.f176288d0.setText(substring);
                }
                JoinDiscussionActivity.this.f176289e0.setText(substring2 + HardCodeUtil.qqStr(R.string.ni9) + ((Object) DateFormat.format("yy-M-d", JoinDiscussionActivity.this.f176300p0)));
            }
        });
    }

    private void findViews() {
        this.f176304t0 = (RelativeLayout) findViewById(R.id.blv);
        this.f176287c0 = (ImageView) findViewById(R.id.bm6);
        this.f176288d0 = (TextView) findViewById(R.id.bmb);
        this.f176289e0 = (TextView) findViewById(R.id.bbs);
        this.f176290f0 = (Button) findViewById(R.id.dzc);
        this.f176305u0 = (RelativeLayout) findViewById(R.id.bzp);
    }

    void I2() {
        if (NetworkUtil.isNetSupport(this)) {
            startTitleProgress();
            this.f176292h0.d4(this.f176285a0, this.f176291g0);
        } else {
            K2(1, -160);
        }
    }

    void K2(int i3, int i16) {
        String qqStr;
        stopTitleProgress();
        if (i16 != -160) {
            if (i16 != 1) {
                if (i16 != 4) {
                    if (i16 != 7) {
                        if (i16 != 8) {
                            if (i3 == 1) {
                                qqStr = HardCodeUtil.qqStr(R.string.ni8);
                            } else if (i3 == 0) {
                                qqStr = HardCodeUtil.qqStr(R.string.f172122ni3);
                            } else {
                                qqStr = "";
                            }
                        } else {
                            this.f176304t0.setVisibility(8);
                            this.f176305u0.setVisibility(0);
                            return;
                        }
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.f172123ni4);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.ni6);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f172121ni2);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.ni5);
        }
        QQToast.makeText(this, qqStr, 0).show(getTitleBarHeight());
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168223po);
        Bundle extras = getIntent().getExtras();
        this.f176293i0 = new MyDiscussionObserver();
        this.f176294j0 = new FaceObserver();
        addObserver(this.f176293i0);
        addObserver(this.f176294j0);
        addObserver(this.f176306v0);
        this.f176291g0 = extras.getInt("addDisSource");
        this.f176285a0 = extras.getString(PreloadTRTCPlayerParams.KEY_SIG);
        String string = extras.getString("innerSig");
        this.f176286b0 = string;
        if (string != null) {
            String upperCase = string.toUpperCase();
            if (this.f176286b0.contains("?_wv=5")) {
                this.f176286b0 = this.f176286b0.replace("?_wv=5", "");
            }
            if (this.f176286b0 != null && !upperCase.startsWith("HTTP://") && !upperCase.startsWith("HTTPS://")) {
                this.f176285a0 = this.f176286b0;
            }
        }
        String str = this.f176285a0;
        if (str != null && str.endsWith("#flyticket")) {
            this.f176285a0 = this.f176285a0.substring(0, r4.length() - 10);
        }
        findViews();
        J2();
        this.f176292h0 = (DiscussionHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        H2();
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
        removeObserver(this.f176293i0);
        removeObserver(this.f176294j0);
        removeObserver(this.f176306v0);
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
