package com.tencent.mobileqq.mutualmark.nt;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.intimate.IntimateSwitchConfigParser;
import com.tencent.mobileqq.config.business.mutualmark.MutualMarkConfigParser;
import com.tencent.mobileqq.config.business.mutualmark.MutualMarkGrayTipsConfigParser;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.o;
import com.tencent.qqnt.bus.event.r;
import com.tencent.state.data.SquareJSConst;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J:\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002JZ\u0010\u0019\u001a2\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u0017\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0015j\b\u0012\u0004\u0012\u00020\u0018`\u00170\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002JP\u0010\u001a\u001a2\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u0017\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0015j\b\u0012\u0004\u0012\u00020\u0018`\u00170\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010\u001e\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J0\u0010#\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J&\u0010+\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)J(\u0010-\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ$\u00100\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u00020.J\u000e\u00101\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u00102\u001a\u00020\u0005R\u0014\u00105\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00107\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u00106R\u0014\u00108\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b1\u00106R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010:R\u0016\u0010=\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010<R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010>R\u0014\u0010@\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010:R\u0016\u0010A\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00104R\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00106\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/mutualmark/nt/f;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "r", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "friendUin", "", "displayPosition", "Landroid/view/View;", "view", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Lcom/tencent/mobileqq/mutualmark/nt/b;", "f", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mobileqq/mutualmark/info/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "info", tl.h.F, "iconDrawable", DomainData.DOMAIN_NAME, "iconUrl", "defaultDrawable", "k", "c", "g", "e", "p", "memberUin", "troopUin", "honorStr", "", "richFlag", "o", "Lcom/tencent/widget/SingleLineTextView$IconDrawableInfo;", "j", "", "limitHeight", "i", "d", "t", "b", "Ljava/lang/String;", "TAG", "I", "MARK_VERSION_NEW", "MARK_VERSION_OLD", "Ljava/lang/Object;", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Z", "isSwitchInit", "Ljava/util/concurrent/CopyOnWriteArrayList;", "recentUinList", "accountLock", "selfUin", "appSeq", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f252196a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int MARK_VERSION_NEW;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int MARK_VERSION_OLD = 0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isSwitchInit;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> recentUinList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object accountLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String selfUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int appSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/mutualmark/nt/f$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) urlDrawable);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) urlDrawable, (Object) throwable);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) urlDrawable, i3);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlDrawable);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f252196a = new f();
        TAG = "MutualMarkNTDataCenter";
        MARK_VERSION_NEW = 1;
        lock = new Object();
        recentUinList = new CopyOnWriteArrayList<>();
        accountLock = new Object();
        selfUin = "";
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c() {
        boolean z16;
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (peekAppRuntime.hashCode() != appSeq) {
            appSeq = peekAppRuntime.hashCode();
            z16 = true;
        } else {
            z16 = false;
        }
        synchronized (accountLock) {
            if (!Intrinsics.areEqual(selfUin, peekAppRuntime.getCurrentAccountUin()) || z16) {
                MutualMarkConfigParser.INSTANCE.a();
                IntimateSwitchConfigParser.INSTANCE.a();
                MutualMarkGrayTipsConfigParser.INSTANCE.a();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface != null) {
                    ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).reportMatchFriendEntry(appInterface);
                }
                QLog.i(TAG, 1, "account_has_change,old=" + selfUin + ",new=" + peekAppRuntime.getCurrentAccountUin());
            }
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            selfUin = currentAccountUin;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final b f(Context context, QQAppInterface app, String friendUin, int displayPosition, View view, boolean needDownload) {
        Pair<ArrayList<Drawable>, ArrayList<com.tencent.mobileqq.mutualmark.info.c>> l3;
        URLDrawable uRLDrawable;
        c();
        if (displayPosition != 1) {
            if (displayPosition != 5) {
                l3 = new Pair<>(new ArrayList(), new ArrayList());
            } else {
                l3 = m(context, app, friendUin, view);
            }
        } else {
            l3 = l(context, app, friendUin);
        }
        ArrayList<Drawable> first = l3.getFirst();
        ArrayList arrayList = new ArrayList();
        ArrayList<URLDrawable> arrayList2 = new ArrayList<>();
        Iterator<Drawable> it = first.iterator();
        while (it.hasNext()) {
            Drawable next = it.next();
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mutualmark_download_9_0_30", true)) {
                if (next instanceof URLDrawable) {
                    uRLDrawable = (URLDrawable) next;
                } else {
                    if (next instanceof com.tencent.mobileqq.mutualmark.e) {
                        com.tencent.mobileqq.mutualmark.e eVar = (com.tencent.mobileqq.mutualmark.e) next;
                        if (eVar.d() != null) {
                            uRLDrawable = eVar.d();
                        }
                    }
                    uRLDrawable = null;
                }
            } else if (next instanceof URLDrawable) {
                uRLDrawable = (URLDrawable) next;
            }
            if (uRLDrawable != null) {
                if (uRLDrawable.getStatus() == 4) {
                    arrayList.add(next);
                } else if (needDownload) {
                    arrayList2.add(uRLDrawable);
                }
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i(TAG, 1, "getFriendMutualMarksInner, uin = " + friendUin + "drawableListRet.size=" + arrayList.size() + ", drawableListNeedDownload.size=" + arrayList2.size());
        }
        i.f252210a.a(friendUin, arrayList2);
        b bVar = new b(first, l3.getSecond());
        CopyOnWriteArrayList<String> copyOnWriteArrayList = recentUinList;
        if (!copyOnWriteArrayList.contains(friendUin)) {
            copyOnWriteArrayList.add(friendUin);
        }
        return bVar;
    }

    private final Drawable h(Context context, com.tencent.mobileqq.mutualmark.info.c info) {
        if (info != null && info.c()) {
            Drawable colorDrawable = new ColorDrawable(0);
            if (!TextUtils.isEmpty(info.f252106v) && info.f252107w == MARK_VERSION_NEW) {
                String str = info.f252106v;
                Intrinsics.checkNotNullExpressionValue(str, "info.iconUrl");
                colorDrawable = k(str, colorDrawable);
            } else if (info.f252107w == MARK_VERSION_OLD) {
                colorDrawable = n(context, info, colorDrawable);
            }
            colorDrawable.setAlpha((int) (info.a() * 255));
            return colorDrawable;
        }
        return null;
    }

    private final Drawable k(String iconUrl, Drawable defaultDrawable) {
        URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(iconUrl, VasApngUtil.VIP_APNG_TAGS, defaultDrawable, null, new a());
        Intrinsics.checkNotNullExpressionValue(apngURLDrawable, "getApngURLDrawable(iconU\u2026i: Int) {}\n            })");
        return apngURLDrawable;
    }

    private final Pair<ArrayList<Drawable>, ArrayList<com.tencent.mobileqq.mutualmark.info.c>> l(Context context, QQAppInterface app, String friendUin) {
        com.tencent.util.Pair<com.tencent.mobileqq.mutualmark.info.c, com.tencent.mobileqq.mutualmark.info.c> c16 = com.tencent.mobileqq.mutualmark.c.c(app, friendUin);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Drawable h16 = h(context, c16.first);
        if (h16 != null) {
            String str = TAG;
            String b16 = com.tencent.mobileqq.qcall.g.b(friendUin);
            com.tencent.mobileqq.mutualmark.info.c cVar = c16.first;
            QLog.i(str, 1, "getMutualMarkInAIO, friendUin=" + b16 + ", [FIRST] MutualMark_Type=" + cVar.f252085a + ", MutualMark_Level=" + cVar.f252086b);
            arrayList2.add(h16);
            arrayList.add(c16.first);
        }
        Drawable h17 = h(context, c16.second);
        if (h17 != null) {
            String str2 = TAG;
            String b17 = com.tencent.mobileqq.qcall.g.b(friendUin);
            com.tencent.mobileqq.mutualmark.info.c cVar2 = c16.second;
            QLog.i(str2, 1, "getMutualMarkInAIO, friendUin=" + b17 + ", [SECOND] MutualMark_Type=" + cVar2.f252085a + ", MutualMark_Level=" + cVar2.f252086b);
            arrayList2.add(h17);
            arrayList.add(c16.second);
        }
        return new Pair<>(arrayList2, arrayList);
    }

    private final Pair<ArrayList<Drawable>, ArrayList<com.tencent.mobileqq.mutualmark.info.c>> m(Context context, QQAppInterface app, String friendUin, View view) {
        ArrayList<com.tencent.mobileqq.mutualmark.info.c> d16 = com.tencent.mobileqq.mutualmark.c.d(app, friendUin, true, 5);
        if (d16 == null) {
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        ArrayList<SingleLineTextView.IconDrawableInfo> j3 = com.tencent.mobileqq.mutualmark.c.j(app, friendUin, d16);
        String viewSizeSetting = com.tencent.relation.common.config.toggle.c.O.d("message_list", "999");
        if (!TextUtils.isEmpty(viewSizeSetting) && !Intrinsics.areEqual(viewSizeSetting, "999")) {
            Intrinsics.checkNotNullExpressionValue(viewSizeSetting, "viewSizeSetting");
            int parseInt = Integer.parseInt(viewSizeSetting);
            if (j3.size() >= parseInt) {
                j3 = new ArrayList<>(j3.subList(0, parseInt));
            }
        }
        if (j3.isEmpty()) {
            return new Pair<>(new ArrayList(), new ArrayList());
        }
        int size = j3.size();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            SingleLineTextView.IconDrawableInfo iconDrawableInfo = j3.get(i3);
            Drawable j16 = j(context, iconDrawableInfo, view);
            if (j16 != null) {
                j16.setAlpha((int) (iconDrawableInfo.icon_status_alpha * 255));
            }
            arrayList.add(j16);
        }
        return new Pair<>(arrayList, d16);
    }

    private final Drawable n(Context context, com.tencent.mobileqq.mutualmark.info.c info, Drawable iconDrawable) {
        if (!TextUtils.isEmpty(info.f252103s)) {
            if (TextUtils.isEmpty(info.f252102r)) {
                info.f252102r = info.f252103s;
            }
        } else {
            iconDrawable = new com.tencent.mobileqq.mutualmark.e(context, info.f252101q);
        }
        if (!TextUtils.isEmpty(info.f252102r)) {
            String str = info.f252102r;
            Intrinsics.checkNotNullExpressionValue(str, "info.iconApngUrl");
            return k(str, iconDrawable);
        }
        return iconDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String str) {
        QBaseActivity qBaseActivity;
        QQAppInterface qQAppInterface;
        if (str == null || (qBaseActivity = QBaseActivity.sTopActivity) == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        QQAppInterface qQAppInterface2 = qQAppInterface;
        if (qQAppInterface2 == null) {
            return;
        }
        f252196a.g(qBaseActivity, qQAppInterface2, str, 5, null);
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new o(str));
    }

    private final void r(final CopyOnWriteArrayList<String> uinList) {
        if (uinList.isEmpty()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.nt.e
            @Override // java.lang.Runnable
            public final void run() {
                f.s(uinList);
            }
        }, 16, null, true);
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new c(uinList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(CopyOnWriteArrayList uinList) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(uinList, "$uinList");
        Iterator it = uinList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(str, "it ?: return@excute");
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "QBaseActivity.sTopActivity ?: return@excute");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            QQAppInterface qQAppInterface2 = qQAppInterface;
            if (qQAppInterface2 == null) {
                return;
            } else {
                f252196a.g(qBaseActivity, qQAppInterface2, str, 5, null);
            }
        }
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new c(uinList));
    }

    public final boolean d(@NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) friendUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        return recentUinList.contains(friendUin);
    }

    public final void e(@NotNull QQAppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        synchronized (lock) {
            if (isSwitchInit) {
                return;
            }
            isSwitchInit = true;
            Manager manager = app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
            ((FriendsManager) manager).E(true);
            QLog.i(TAG, 1, "getFriendMutualMarkSwitch invoke");
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final b g(@NotNull Context context, @NotNull QQAppInterface app, @NotNull String friendUin, int displayPosition, @Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, context, app, friendUin, Integer.valueOf(displayPosition), view);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        return f(context, app, friendUin, displayPosition, view, true);
    }

    @Nullable
    public final Drawable i(@Nullable Context context, @Nullable SingleLineTextView.IconDrawableInfo info, float limitHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, this, context, info, Float.valueOf(limitHeight));
        }
        com.tencent.mobileqq.mutualmark.e eVar = null;
        if (context == null || info == null) {
            return null;
        }
        if (!TextUtils.isEmpty(info.iconUrl) && info.markVersion == MARK_VERSION_NEW) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, info.iconUrl, limitHeight);
        } else if (!TextUtils.isEmpty(info.iconDynamicUrl) && info.markVersion == MARK_VERSION_OLD) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, info.iconDynamicUrl, limitHeight);
        } else if (!TextUtils.isEmpty(info.icon_static_url) && info.markVersion == MARK_VERSION_OLD) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, info.icon_static_url, limitHeight);
        } else if (info.iconResId != 0 && info.markVersion == MARK_VERSION_OLD) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, info.iconResId, limitHeight);
        }
        if (eVar != null) {
            Drawable mutate = eVar.mutate();
            mutate.setAlpha((int) (info.icon_status_alpha * 255));
            mutate.setBounds(0, 0, mutate.getIntrinsicWidth(), mutate.getIntrinsicHeight());
            return mutate;
        }
        return eVar;
    }

    @Nullable
    public final Drawable j(@Nullable Context context, @Nullable SingleLineTextView.IconDrawableInfo info, @Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, this, context, info, view);
        }
        return i(context, info, 16.0f);
    }

    public final void o(@NotNull String memberUin, @NotNull String troopUin, @NotNull String honorStr, byte richFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, memberUin, troopUin, honorStr, Byte.valueOf(richFlag));
            return;
        }
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(honorStr, "honorStr");
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new r(memberUin, troopUin, honorStr, richFlag));
    }

    public final void p(@Nullable final String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) friendUin);
            return;
        }
        QLog.i(TAG, 1, "notifyUI, friendUin=" + com.tencent.mobileqq.qcall.g.b(friendUin));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.nt.d
            @Override // java.lang.Runnable
            public final void run() {
                f.q(friendUin);
            }
        }, 32, null, true);
        if (friendUin != null) {
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new o(friendUin));
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        String str = TAG;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = recentUinList;
        QLog.i(str, 1, "notifyUIGlobal invoke, recentUserSize=" + copyOnWriteArrayList.size());
        r(copyOnWriteArrayList);
    }
}
