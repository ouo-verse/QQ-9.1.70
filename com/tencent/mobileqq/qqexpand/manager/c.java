package com.tencent.mobileqq.qqexpand.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.match.b;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import vg2.f;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c implements Manager, com.tencent.mobileqq.qqexpand.manager.d {
    private static final Object N = new Object();
    static Object P = new Object();
    private WeakReference<e> C;
    private vg2.d D;
    private String H;
    private String I;
    private String J;
    private final EntityManager L;
    private final ExpandObserver M;

    /* renamed from: d, reason: collision with root package name */
    public String f263901d;

    /* renamed from: e, reason: collision with root package name */
    protected SharedPreferences f263902e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.qqexpand.match.b f263903f;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.qqexpand.match.c f263904h;

    /* renamed from: i, reason: collision with root package name */
    private final QQAppInterface f263905i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f263906m = false;
    public b.a E = new a();
    private boolean F = true;
    private boolean G = false;
    private final LruCache<String, ExpandFriendData> K = new LruCache<>(50);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements b.a {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.match.b.a
        public void a(int i3, vg2.d dVar, String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + i3 + " nickName : " + str);
                if (dVar != null) {
                    QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info\uff1a" + dVar.toString());
                }
            }
            if (c.this.C != null && c.this.C.get() != null) {
                if (c.this.t() == 2) {
                    if (i3 == 0 && dVar != null) {
                        c.this.D = dVar.b();
                        c cVar = c.this;
                        cVar.f263901d = str;
                        cVar.u().d(105);
                        if (!c.this.f263906m) {
                            QQNotificationManager.getInstance().createLimitChatNotificationChannel();
                            c.this.f263906m = true;
                        }
                    } else {
                        c.this.u().d(104);
                    }
                    ((e) c.this.C.get()).w8(i3, dVar, str, str2);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends ExpandObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void a(boolean z16) {
            c.this.s().c(z16);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void v(boolean z16, vg2.d dVar) {
            c.this.s().d(z16, dVar);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void w(boolean z16, int i3, vg2.d dVar, String str) {
            c.this.s().e(z16, i3, dVar, str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.manager.c$c, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    class DialogInterfaceOnClickListenerC8319c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f263909d;

        DialogInterfaceOnClickListenerC8319c(Context context) {
            this.f263909d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f263909d != null) {
                try {
                    Intent intent = new Intent(this.f263909d, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", c.this.J);
                    this.f263909d.startActivity(intent);
                    if (QLog.isColorLevel()) {
                        QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog click confirm " + c.this.J);
                    }
                } catch (Exception e16) {
                    QLog.w("ExtendFriendLimitChatManager", 1, "", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface e {
        void w8(int i3, vg2.d dVar, String str, String str2);
    }

    public c(QQAppInterface qQAppInterface) {
        b bVar = new b();
        this.M = bVar;
        this.f263905i = qQAppInterface;
        qQAppInterface.addObserver(bVar);
        this.L = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.f263902e = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0);
    }

    public static void A(BaseQQAppInterface baseQQAppInterface, int i3) {
        QLog.i("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp : " + i3);
        if (baseQQAppInterface == null) {
            QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSexTypeToSp with null app");
            return;
        }
        SharedPreferences.Editor edit = baseQQAppInterface.getApp().getSharedPreferences(baseQQAppInterface.getCurrentAccountUin(), 0).edit();
        if (edit != null) {
            edit.putInt("sp_match_sex_type", i3).apply();
        }
    }

    public static int r(QQAppInterface qQAppInterface) {
        int i3;
        if (qQAppInterface == null) {
            QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp with null app");
            return 0;
        }
        Card t16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).t(qQAppInterface.getCurrentAccountUin());
        if (t16 == null) {
            QLog.i("ExtendFriendLimitChatManager", 2, "\u83b7\u53d6\u81ea\u5df1\u7684\u8d44\u6599\u5361\u6027\u522b\uff0c\u7f13\u5b58\u4e2d\u672a\u83b7\u53d6\u5230\uff0c\u4f7f\u7528\u9ed8\u8ba4\u503c\u968f\u673a");
            i3 = 0;
        } else {
            short s16 = t16.shGender;
            if (s16 == 0) {
                i3 = 2;
            } else {
                i3 = 1;
                if (s16 != 1) {
                    i3 = 0;
                }
            }
            QLog.i("ExtendFriendLimitChatManager", 2, "\u83b7\u53d6\u81ea\u5df1\u7684\u8d44\u6599\u5361\u6027\u522b\uff0cdefaultSex:" + i3);
        }
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt("sp_match_sex_type", i3);
    }

    private void v() {
        QQAppInterface qQAppInterface = this.f263905i;
        if (qQAppInterface == null) {
            return;
        }
        try {
            RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
            List<RecentUser> recentList = m3.getRecentList(false);
            ArrayList arrayList = new ArrayList();
            if (recentList != null && recentList.size() > 0) {
                for (RecentUser recentUser : recentList) {
                    if (recentUser.getType() == 1044 && !recentUser.uin.equals(AppConstants.MATCH_CHAT_UIN)) {
                        arrayList.add(recentUser);
                    }
                }
                QLog.i("ExtendFriendLimitChatManager", 1, "[initLimitChatBox] toBeRemoved.size:" + arrayList.size());
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    m3.delRecentUser((RecentUser) it.next());
                }
            }
            SharedPreferences sharedPreferences = this.f263902e;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("init_matchchat_folder", false).commit();
            }
        } catch (Throwable th5) {
            QLog.e("ExtendFriendLimitChatManager", 1, th5, new Object[0]);
        }
    }

    public boolean E() {
        SharedPreferences sharedPreferences;
        if (this.f263905i == null || (sharedPreferences = this.f263902e) == null) {
            return false;
        }
        return sharedPreferences.getBoolean("init_matchchat_folder", true);
    }

    public void F(ExpandFriendData expandFriendData) {
        if (expandFriendData != null && !TextUtils.isEmpty(expandFriendData.matchUin)) {
            this.K.put(expandFriendData.matchUin, expandFriendData);
            EntityManager entityManager = this.L;
            if (entityManager != null && entityManager.isOpen()) {
                if (expandFriendData.getStatus() == 1000) {
                    this.L.persistOrReplace(expandFriendData);
                } else if (expandFriendData.getStatus() == 1001) {
                    this.L.update(expandFriendData);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendLimitChatManager", 2, "updateExpandFriendData " + expandFriendData);
                return;
            }
            return;
        }
        QLog.w("ExtendFriendLimitChatManager", 1, "updateExpandFriendData but expandFriendData is empty");
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.d
    public void a() {
        this.K.evictAll();
        EntityManager entityManager = this.L;
        if (entityManager == null || !entityManager.isOpen()) {
            return;
        }
        this.L.drop(ExpandFriendData.class);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.d
    public void c(boolean z16, String str, String str2, String str3) {
        this.G = z16;
        this.H = str;
        this.I = str2;
        this.J = str3;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.d
    public boolean d(BaseQQAppInterface baseQQAppInterface) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.d
    public void e() {
        QLog.i("ExtendFriendLimitChatManager", 1, "[initManager], threadId:" + Thread.currentThread().getId());
        if (E()) {
            v();
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.d
    public void f(boolean z16) {
        this.F = z16;
    }

    public void l() {
        u().d(103);
    }

    public void m(int i3) {
        u().e(101, i3);
    }

    public ExpandFriendData o(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("ExtendFriendLimitChatManager", 1, "getExpandFriendDataCache but uin is empty");
            return null;
        }
        ExpandFriendData expandFriendData = this.K.get(str);
        if (expandFriendData == null && z16 && (expandFriendData = p(str)) != null) {
            this.K.put(str, expandFriendData);
        }
        return expandFriendData;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        com.tencent.mobileqq.qqexpand.match.b bVar = this.f263903f;
        if (bVar != null) {
            bVar.a();
            this.f263903f = null;
        }
        this.f263905i.removeObserver(this.M);
        WeakReference<e> weakReference = this.C;
        if (weakReference != null) {
            weakReference.clear();
            this.C = null;
        }
        this.D = null;
    }

    public ExpandFriendData p(String str) {
        EntityManager entityManager;
        if (TextUtils.isEmpty(str) || (entityManager = this.L) == null || !entityManager.isOpen()) {
            return null;
        }
        return (ExpandFriendData) DBMethodProxy.find(this.L, (Class<? extends Entity>) ExpandFriendData.class, str);
    }

    public com.tencent.mobileqq.qqexpand.match.b s() {
        com.tencent.mobileqq.qqexpand.match.b bVar = this.f263903f;
        if (bVar != null) {
            return bVar;
        }
        synchronized (P) {
            com.tencent.mobileqq.qqexpand.match.b bVar2 = this.f263903f;
            if (bVar2 != null) {
                return bVar2;
            }
            com.tencent.mobileqq.qqexpand.match.b bVar3 = new com.tencent.mobileqq.qqexpand.match.b(this.f263905i);
            this.f263903f = bVar3;
            bVar3.g(this.E);
            return this.f263903f;
        }
    }

    public int t() {
        return u().b();
    }

    public com.tencent.mobileqq.qqexpand.match.c u() {
        com.tencent.mobileqq.qqexpand.match.c cVar = this.f263904h;
        if (cVar != null) {
            return cVar;
        }
        synchronized (N) {
            com.tencent.mobileqq.qqexpand.match.c cVar2 = this.f263904h;
            if (cVar2 != null) {
                return cVar2;
            }
            com.tencent.mobileqq.qqexpand.match.c cVar3 = new com.tencent.mobileqq.qqexpand.match.c(this);
            this.f263904h = cVar3;
            return cVar3;
        }
    }

    public void w(boolean z16, vg2.c cVar) {
        QLog.i("ExtendFriendLimitChat", 2, "handleGetSquareStrangerList onGetMatchFeedInfo success = " + z16);
    }

    public void y(String str, String str2, byte[] bArr) {
        this.f263905i.getMsgCache().v(String.valueOf(str), String.valueOf(str2), bArr);
    }

    public void z(e eVar) {
        WeakReference<e> weakReference = this.C;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.C = new WeakReference<>(eVar);
    }

    public static void D(QQAppInterface qQAppInterface, Boolean bool) {
        if (qQAppInterface == null) {
            QLog.e("ExtendFriendLimitChatManager", 2, "setVoiceMatchSwitchFlagToSp with null app");
            return;
        }
        QLog.d("ExtendFriendLimitChatManager", 2, "setVoiceMatch " + bool);
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        if (edit != null) {
            edit.putBoolean("sp_voice_match_switch_flag", bool.booleanValue()).apply();
        }
    }

    public void G(String str, int i3, Object obj) {
        ExpandFriendData o16 = o(str, true);
        if (o16 == null) {
            o16 = new ExpandFriendData(str);
        }
        try {
            o16.setAttribute(i3, obj);
            F(o16);
        } catch (Exception e16) {
            QLog.w("ExtendFriendLimitChatManager", 1, "updateExpandFriendDataSingleAttribute error: " + e16);
        }
    }

    public void n() {
        this.D = null;
    }

    public Object q(String str, int i3) {
        ExpandFriendData o16 = o(str, true);
        if (o16 != null) {
            return o16.getAttribute(i3);
        }
        return null;
    }

    public void x(f fVar) {
        u().e(102, fVar != null ? fVar.f441618a : 1);
    }

    public static void C(QQAppInterface qQAppInterface, ArrayList<f> arrayList) {
        if (qQAppInterface == null) {
            QLog.e("ExtendFriendLimitChatManager", 2, "setTaglistToSp with null app");
            return;
        }
        String a16 = f.a(arrayList);
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        if (a16 == null || edit == null) {
            return;
        }
        edit.putString("sp_tagList", a16).apply();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.d
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog");
        }
        if (this.F || !this.G) {
            return false;
        }
        if (TextUtils.isEmpty(this.H)) {
            this.H = context.getString(R.string.f2036750u);
        }
        if (TextUtils.isEmpty(this.I)) {
            this.I = context.getString(R.string.f2036550s);
        }
        if (TextUtils.isEmpty(this.J)) {
            this.J = "https://ti.qq.com/realname/index.html";
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, this.H, this.I, context.getString(R.string.f2036650t), context.getString(R.string.f2036850v), new DialogInterfaceOnClickListenerC8319c(context), new d());
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    public static void B(QQAppInterface qQAppInterface, Boolean bool) {
    }
}
