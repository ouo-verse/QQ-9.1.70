package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FollowTextView extends TextView implements View.OnClickListener, SimpleEventReceiver {
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f96570d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f96571e;

    /* renamed from: f, reason: collision with root package name */
    private CertifiedAccountMeta$StFeed f96572f;

    /* renamed from: h, reason: collision with root package name */
    private ExtraTypeInfo f96573h;

    /* renamed from: i, reason: collision with root package name */
    private BaseWidgetView.c f96574i;

    /* renamed from: m, reason: collision with root package name */
    private e f96575m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends IPublicAccountObserver.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean z16, String str) {
            super.onFollowPublicAccount(z16, str);
            FollowTextView.this.f96571e = true;
            if (z16) {
                if (!FollowTextView.this.C) {
                    FollowTextView followTextView = FollowTextView.this;
                    followTextView.k(true, followTextView.f96572f);
                }
                FollowTextView.this.o(1);
                if (FollowTextView.this.f96572f != null) {
                    if (FollowTextView.this.f96575m != null) {
                        FollowTextView.this.f96575m.a(true, FollowTextView.this.f96572f);
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, FollowTextView.this.f96572f.poster.f24929id.get()));
                    return;
                }
                return;
            }
            QQToast.makeText(FollowTextView.this.getContext(), R.string.f170705zf, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends IPublicAccountObserver.c {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(boolean z16, String str) {
            super.onUnfollowPublicAccount(z16, str);
            FollowTextView.this.f96571e = true;
            if (z16) {
                if (!FollowTextView.this.C) {
                    FollowTextView followTextView = FollowTextView.this;
                    followTextView.k(false, followTextView.f96572f);
                }
                FollowTextView.this.o(0);
                if (FollowTextView.this.f96572f != null) {
                    if (FollowTextView.this.f96575m != null) {
                        FollowTextView.this.f96575m.a(false, FollowTextView.this.f96572f);
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, FollowTextView.this.f96572f.poster.f24929id.get()));
                    return;
                }
                return;
            }
            QQToast.makeText(FollowTextView.this.getContext(), R.string.f170709zj, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            FollowTextView.this.f96571e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96579d;

        d(ActionSheet actionSheet) {
            this.f96579d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (FollowTextView.this.f96571e) {
                FollowTextView.this.f96571e = false;
                if (i3 == 0) {
                    FollowTextView.this.h(false);
                }
                this.f96579d.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a(boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed);
    }

    public FollowTextView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        PBStringField pBStringField;
        String str;
        if (certifiedAccountMeta$StFeed != null) {
            if (!StringUtil.isEmpty(certifiedAccountMeta$StFeed.f24925id.get())) {
                pBStringField = certifiedAccountMeta$StFeed.f24925id;
            } else {
                pBStringField = certifiedAccountMeta$StFeed.poster.nick;
            }
            String str2 = pBStringField.get();
            String str3 = certifiedAccountMeta$StFeed.poster.f24929id.get();
            String str4 = "auth_" + SubscribeShareHelper.s(i());
            if (z16) {
                str = "follow";
            } else {
                str = "un_follow";
            }
            VSReporter.n(str3, str4, str, 0, 0, "", "", str2);
        }
    }

    private void n() {
        ActionSheet create = ActionSheet.create(getContext());
        create.setMainTitle(String.format(getContext().getResources().getString(R.string.d7m), this.f96572f.poster.nick.get()));
        create.addButton(R.string.dz7, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new c());
        create.setOnButtonClickListener(new d(create));
        if (!create.isShowing()) {
            this.f96571e = true;
            create.show();
        }
    }

    protected boolean g() {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f96572f;
        if (certifiedAccountMeta$StFeed != null && !StringUtil.isEmpty(certifiedAccountMeta$StFeed.poster.nick.get())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(FollowUpdateEvent.class);
        return arrayList;
    }

    protected void h(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("FollowTextView", 2, "follow");
        }
        if (this.f96572f == null) {
            QLog.e("FollowTextView", 2, "follow user failed! user is null");
            return;
        }
        this.f96571e = false;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            if (z16) {
                IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                iPublicAccountObserver.setOnCallback(new a());
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(qQAppInterface, getContext(), this.f96572f.poster.f24929id.get(), iPublicAccountObserver, false, 0, true);
            } else {
                IPublicAccountObserver iPublicAccountObserver2 = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                iPublicAccountObserver2.setOnCallback(new b());
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(qQAppInterface, getContext(), this.f96572f.poster.f24929id.get(), false, iPublicAccountObserver2, true);
            }
        }
    }

    public ExtraTypeInfo i() {
        return this.f96573h;
    }

    protected void j() {
        setGravity(17);
        setTextColor(-1);
        setOnClickListener(this);
    }

    protected void l() {
        int i3;
        int parseColor;
        if (this.f96570d) {
            i3 = R.drawable.f160408gt;
        } else {
            i3 = R.drawable.f160407gs;
        }
        setBackgroundResource(i3);
        if (this.f96570d) {
            parseColor = -9211021;
        } else {
            parseColor = Color.parseColor("#bdbfc9");
        }
        setTextColor(parseColor);
        setText(R.string.f170707zh);
    }

    protected void m() {
        int i3;
        int i16;
        if (this.f96570d) {
            i3 = R.drawable.f160428h2;
        } else {
            i3 = R.drawable.f160426h1;
        }
        setBackgroundResource(i3);
        if (this.f96570d) {
            i16 = -1493172225;
        } else {
            i16 = -1;
        }
        setTextColor(i16);
        setText(R.string.f170708zi);
    }

    public void o(int i3) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f96572f;
        if (certifiedAccountMeta$StFeed != null) {
            certifiedAccountMeta$StFeed.poster.followState.set(i3);
        }
        if (i3 == 1) {
            l();
        } else {
            m();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!g()) {
            if (!this.f96571e) {
                QQToast.makeText(getContext(), "\u8bf7\u52ff\u91cd\u590d\u64cd\u4f5c", 0).show();
            } else {
                BaseWidgetView.c cVar = this.f96574i;
                if (cVar != null) {
                    cVar.beforeClick();
                }
                if (this.f96572f.poster.followState.get() == 0) {
                    h(true);
                } else if (!this.D) {
                    n();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f96572f;
        if (certifiedAccountMeta$StFeed != null && (simpleBaseEvent instanceof FollowUpdateEvent)) {
            FollowUpdateEvent followUpdateEvent = (FollowUpdateEvent) simpleBaseEvent;
            if (certifiedAccountMeta$StFeed.poster.f24929id.get().equals(followUpdateEvent.useId)) {
                o(followUpdateEvent.followStatus);
                ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).broadcastFollowIfNeed(getContext(), followUpdateEvent.useId, followUpdateEvent.followStatus);
                SubscribeHybirdFragment.wh(getContext(), followUpdateEvent);
            }
        }
    }

    public void setExtraTypeInfo(ExtraTypeInfo extraTypeInfo) {
        this.f96573h = extraTypeInfo;
    }

    public void setFeedData(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed != null) {
            this.f96572f = certifiedAccountMeta$StFeed;
            o(certifiedAccountMeta$StFeed.poster.followState.get());
        }
    }

    public void setFollowStateChangeListener(e eVar) {
        this.f96575m = eVar;
    }

    public void setIsInNightMode(boolean z16) {
        this.f96570d = z16;
    }

    public void setItemPreClickListener(BaseWidgetView.c cVar) {
        this.f96574i = cVar;
    }

    public void setNoneReportType(boolean z16) {
        this.C = z16;
    }

    public void setOnlyFollowMode(boolean z16) {
        this.D = z16;
    }

    public void setUserData(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
        setUserData(certifiedAccountMeta$StUser, -1);
    }

    public FollowTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUserData(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, int i3) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
        certifiedAccountMeta$StFeed.poster.set(certifiedAccountMeta$StUser);
        certifiedAccountMeta$StFeed.type.set(i3);
        this.f96572f = certifiedAccountMeta$StFeed;
        this.C = i3 == -1;
        o(certifiedAccountMeta$StFeed.poster.followState.get());
    }

    public FollowTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96570d = false;
        this.f96571e = true;
        j();
    }
}
