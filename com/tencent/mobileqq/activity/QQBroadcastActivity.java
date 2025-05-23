package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQBroadcastActivity extends BaseSystemActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name */
    b f176723h0;

    /* renamed from: i0, reason: collision with root package name */
    Handler f176724i0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQBroadcastActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QQBroadcastActivity qQBroadcastActivity;
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1010 && (bVar = (qQBroadcastActivity = QQBroadcastActivity.this).f176723h0) != null) {
                bVar.changeCursor(qQBroadcastActivity.H2());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class b extends CursorAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        c f176726d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements View.OnLongClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f176728d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.QQBroadcastActivity$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            class DialogInterfaceOnClickListenerC7110a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                DialogInterfaceOnClickListenerC7110a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    if (i3 != 0) {
                        if (i3 == 1 && QQBroadcastActivity.this.f176723h0.getCount() > 0) {
                            QQBroadcastActivity.this.app.getMessageFacade().q(QQBroadcastActivity.this.K2(), 0);
                            b bVar = b.this;
                            QQBroadcastActivity.this.f176723h0.changeCursor(bVar.getCursor());
                            return;
                        }
                        return;
                    }
                    QQBroadcastActivity.this.app.getMessageFacade().T1(QQBroadcastActivity.this.K2(), 0, a.this.f176728d);
                    QQBroadcastActivity.this.refresh();
                }
            }

            a(long j3) {
                this.f176728d = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3));
                }
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewLongClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
                } else {
                    DialogUtil.createCustomDialog(QQBroadcastActivity.this, 230).setTitle(QQBroadcastActivity.this.getString(R.string.hub)).setItems(R.array.f155182a9, new DialogInterfaceOnClickListenerC7110a()).show();
                    z16 = true;
                }
                EventCollector.getInstance().onViewLongClicked(view);
                return z16;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.QQBroadcastActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class ViewOnClickListenerC7111b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SharedPreferences f176731d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f176732e;

            ViewOnClickListenerC7111b(SharedPreferences sharedPreferences, String str) {
                this.f176731d = sharedPreferences;
                this.f176732e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, sharedPreferences, str);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    this.f176731d.edit().putBoolean(this.f176732e, true).commit();
                    QQBroadcastActivity.this.f176724i0.sendEmptyMessageDelayed(1010, 1000L);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class c implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.config.struct.a f176734d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ SharedPreferences f176735e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f176736f;

            c(com.tencent.mobileqq.config.struct.a aVar, SharedPreferences sharedPreferences, String str) {
                this.f176734d = aVar;
                this.f176735e = sharedPreferences;
                this.f176736f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, aVar, sharedPreferences, str);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AllInOne allInOne;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    com.tencent.mobileqq.config.struct.a aVar = this.f176734d;
                    String str = aVar.f202967e;
                    String str2 = aVar.f202968f;
                    if (!str.equals("TMTWAPI") && !str.equals("WAPI")) {
                        if (!str.equals("TMTWAP") && !str.equals("WAP")) {
                            if (str.equals("LOCAL")) {
                                if ("CARD".equalsIgnoreCase(str2)) {
                                    String str3 = this.f176734d.f202969g.split(",")[0];
                                    if (!"".equals(str3) && !QQBroadcastActivity.this.app.getCurrentAccountUin().equals(str3)) {
                                        allInOne = new AllInOne(str3, 19);
                                    } else {
                                        allInOne = new AllInOne(QQBroadcastActivity.this.app.getCurrentAccountUin(), 0);
                                    }
                                    ProfileUtils.openProfileCard(QQBroadcastActivity.this, allInOne);
                                } else if ("CHAT".equalsIgnoreCase(str2)) {
                                    String str4 = this.f176734d.f202969g.split(",")[0];
                                    if (!"".equals(str4)) {
                                        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str4), "IphoneTitleBarActivity")) {
                                            b bVar = b.this;
                                            bVar.a(str4, 0, com.tencent.mobileqq.utils.ac.G(QQBroadcastActivity.this.app, str4));
                                        } else {
                                            b bVar2 = b.this;
                                            bVar2.a(str4, 1001, com.tencent.mobileqq.utils.ac.G(QQBroadcastActivity.this.app, str4));
                                        }
                                    }
                                }
                            }
                        } else {
                            Intent intent = new Intent(QQBroadcastActivity.this, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("uin", QQBroadcastActivity.this.app.getCurrentAccountUin());
                            QQBroadcastActivity.this.startActivity(intent.putExtra("url", str2));
                        }
                    } else {
                        String b16 = com.tencent.mobileqq.config.e.b(str2, 0, null);
                        Intent intent2 = new Intent(QQBroadcastActivity.this, (Class<?>) QQBrowserActivity.class);
                        intent2.putExtra("uin", QQBroadcastActivity.this.app.getCurrentAccountUin());
                        QQBroadcastActivity.this.startActivity(intent2.putExtra("url", b16));
                    }
                    this.f176735e.edit().putBoolean(this.f176736f, true).commit();
                    QQBroadcastActivity.this.f176724i0.sendEmptyMessageDelayed(1010, 1000L);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(Context context, Cursor cursor) {
            super(context, cursor);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQBroadcastActivity.this, context, cursor);
            } else {
                QQBroadcastActivity.this.N2(cursor);
            }
        }

        protected void a(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                return;
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(QQBroadcastActivity.this), null);
            m3.putExtra("uin", str);
            m3.putExtra("uintype", i3);
            if (str2 != null && str2.trim().length() != 0) {
                str = str2;
            }
            m3.putExtra("uinname", str);
            QQBroadcastActivity.this.startActivity(m3);
        }

        @Override // android.widget.CursorAdapter
        @SuppressLint({"Range"})
        public void bindView(View view, Context context, Cursor cursor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, context, cursor);
                return;
            }
            int i3 = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_TYPE));
            String string = cursor.getString(cursor.getColumnIndex("msg"));
            long j3 = cursor.getLong(cursor.getColumnIndex("time"));
            long j16 = cursor.getLong(cursor.getColumnIndex("uniseq"));
            c cVar = (c) view.getTag();
            this.f176726d = cVar;
            if (cVar == null) {
                c cVar2 = new c();
                this.f176726d = cVar2;
                cVar2.f176738a = (TextView) view.findViewById(R.id.k4v);
                this.f176726d.f176739b = (RelativeLayout) view.findViewById(R.id.j9w);
                this.f176726d.f176740c = (TextView) view.findViewById(R.id.k4d);
                this.f176726d.f176741d = (TextView) view.findViewById(R.id.k4y);
                this.f176726d.f176742e = (TextView) view.findViewById(R.id.k4u);
                this.f176726d.f176743f = (ImageView) view.findViewById(R.id.f7s);
                this.f176726d.f176744g = view.findViewById(R.id.ae5);
                this.f176726d.f176745h = (RelativeLayout) view.findViewById(R.id.abx);
                view.setTag(this.f176726d);
            }
            if (QQBroadcastActivity.this.L2(j16) != -1) {
                this.f176726d.f176742e.setVisibility(0);
                this.f176726d.f176742e.setText(BaseSystemActivity.J2(1000 * j3, false));
            } else {
                this.f176726d.f176742e.setVisibility(8);
            }
            this.f176726d.f176739b.setOnLongClickListener(new a(j16));
            SharedPreferences sharedPreferences = QQBroadcastActivity.this.getSharedPreferences(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN), 0);
            String str = "QQBROADCAST_MSG_UIN" + j16 + j3;
            if (sharedPreferences.contains(str)) {
                this.f176726d.f176743f.setVisibility(8);
            } else {
                this.f176726d.f176743f.setVisibility(0);
            }
            if (i3 != -2004) {
                if (i3 != -2003 && i3 != 9) {
                    if (i3 != 513) {
                        this.f176726d.f176739b.setClickable(false);
                        this.f176726d.f176739b.setOnClickListener(null);
                        this.f176726d.f176739b.setVisibility(8);
                        return;
                    }
                } else {
                    this.f176726d.f176741d.setVisibility(8);
                    this.f176726d.f176744g.setVisibility(8);
                    this.f176726d.f176745h.setVisibility(8);
                    this.f176726d.f176738a.setText(context.getResources().getString(R.string.hub));
                    this.f176726d.f176740c.setVisibility(0);
                    this.f176726d.f176740c.setText(string);
                    this.f176726d.f176740c.setPadding(0, 0, 0, 12);
                    this.f176726d.f176739b.setClickable(true);
                    this.f176726d.f176739b.setOnClickListener(new ViewOnClickListenerC7111b(sharedPreferences, str));
                    return;
                }
            }
            com.tencent.mobileqq.config.struct.a d16 = com.tencent.mobileqq.config.a.d(string);
            if (d16 == null) {
                this.f176726d.f176739b.setClickable(false);
                this.f176726d.f176739b.setOnClickListener(null);
                this.f176726d.f176741d.setVisibility(8);
                this.f176726d.f176744g.setVisibility(8);
                this.f176726d.f176745h.setVisibility(8);
            }
            if (d16 != null && d16.f202964b.length() > 0) {
                this.f176726d.f176738a.setText(d16.f202964b);
            } else {
                this.f176726d.f176738a.setText(context.getResources().getString(R.string.hub));
            }
            if (d16 != null && d16.f202963a.length() > 0) {
                this.f176726d.f176740c.setVisibility(0);
                this.f176726d.f176740c.setText(d16.f202963a);
            } else {
                this.f176726d.f176740c.setVisibility(8);
            }
            if (d16 != null && d16.f202968f.length() > 0) {
                this.f176726d.f176741d.setVisibility(0);
                this.f176726d.f176744g.setVisibility(0);
                this.f176726d.f176745h.setVisibility(0);
                if (d16.f202966d.length() > 0) {
                    this.f176726d.f176741d.setText(d16.f202966d);
                } else {
                    this.f176726d.f176741d.setText(context.getResources().getString(R.string.huk));
                }
                this.f176726d.f176739b.setClickable(true);
                this.f176726d.f176739b.setOnClickListener(new c(d16, sharedPreferences, str));
                return;
            }
            this.f176726d.f176739b.setClickable(false);
            this.f176726d.f176739b.setOnClickListener(null);
            this.f176726d.f176741d.setVisibility(8);
            this.f176726d.f176744g.setVisibility(8);
            this.f176726d.f176745h.setVisibility(8);
        }

        @Override // android.widget.CursorAdapter
        public void changeCursor(Cursor cursor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) cursor);
            } else {
                super.changeCursor(cursor);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, this, context, cursor, viewGroup);
            }
            return QQBroadcastActivity.this.getLayoutInflater().inflate(R.layout.f167770go, viewGroup, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f176738a;

        /* renamed from: b, reason: collision with root package name */
        RelativeLayout f176739b;

        /* renamed from: c, reason: collision with root package name */
        TextView f176740c;

        /* renamed from: d, reason: collision with root package name */
        TextView f176741d;

        /* renamed from: e, reason: collision with root package name */
        TextView f176742e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f176743f;

        /* renamed from: g, reason: collision with root package name */
        View f176744g;

        /* renamed from: h, reason: collision with root package name */
        RelativeLayout f176745h;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public QQBroadcastActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176724i0 = new a();
        }
    }

    private void updateUnreadNumOnTitleBar() {
        QQMessageFacade messageFacade = this.app.getMessageFacade();
        if (messageFacade != null) {
            int H1 = messageFacade.H1();
            if (H1 > 0) {
                if (H1 > 999) {
                    H1 = 999;
                }
                setLeftViewName(getIntent().putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, getString(R.string.hvn) + "(" + H1 + ")"));
                return;
            }
            setLeftViewName(getIntent().putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, getString(R.string.hvn)));
        }
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity
    protected CursorAdapter G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CursorAdapter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f176723h0 == null) {
            this.f176723h0 = new b(this, this.app.getMessageProxy(0).O(K2(), 0));
        }
        return this.f176723h0;
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity
    protected Cursor H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Cursor) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.app.getMessageProxy(0).O(K2(), 0);
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity
    protected String K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity
    protected CharSequence M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getString(R.string.hub);
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity
    protected void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            updateUnreadNumOnTitleBar();
        }
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.app.getMessageFacade().O0(K2(), 0);
        updateUnreadNumOnTitleBar();
        this.rightViewText.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        b bVar = this.f176723h0;
        if (bVar != null) {
            bVar.changeCursor(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.BaseSystemActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
        }
    }
}
