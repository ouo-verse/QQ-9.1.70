package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.NTEmoticonSenderApi;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NTSouGouEmojiSender implements ISogouEmoji {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    public static String f204626l;

    /* renamed from: m, reason: collision with root package name */
    public static String f204627m;

    /* renamed from: a, reason: collision with root package name */
    int f204628a;

    /* renamed from: b, reason: collision with root package name */
    int f204629b;

    /* renamed from: c, reason: collision with root package name */
    private BaseQQAppInterface f204630c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f204631d;

    /* renamed from: e, reason: collision with root package name */
    private NTEmoticonSenderApi f204632e;

    /* renamed from: f, reason: collision with root package name */
    IEmoticonManagerService f204633f;

    /* renamed from: g, reason: collision with root package name */
    IEmojiManagerService f204634g;

    /* renamed from: h, reason: collision with root package name */
    EmoticonHandler f204635h;

    /* renamed from: i, reason: collision with root package name */
    t f204636i;

    /* renamed from: j, reason: collision with root package name */
    EmotionJsonDownloadListener f204637j;

    /* renamed from: k, reason: collision with root package name */
    EmoticonObserver f204638k;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends EmotionJsonDownloadListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTSouGouEmojiSender.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
            Bundle bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, emoticonPackage, Integer.valueOf(i3), bundle);
                return;
            }
            super.onJsonComplete(emoticonPackage, i3, bundle);
            if (emoticonPackage != null && i3 == 0 && (bundle2 = bundle.getBundle(EmojiManagerServiceConstant.PARAMS_REQ)) != null) {
                int i16 = bundle2.getInt(NTSouGouEmojiSender.f204626l);
                String string = bundle2.getString(NTSouGouEmojiSender.f204627m);
                if (QLog.isColorLevel()) {
                    QLog.d("SouGouEmojiSender", 2, "func onEmojiJsonBack begins, taskId:" + i16 + ",packId:" + emoticonPackage.epId);
                }
                boolean d16 = NTSouGouEmojiSender.this.f204636i.d(i16);
                if (d16) {
                    NTSouGouEmojiSender.this.e(emoticonPackage.epId, string, false);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SouGouEmojiSender", 2, "func onEmojiJsonBack ends, isTaskExist:" + d16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements QueryCallback<Emoticon> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f204644a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f204645b;

        b(int i3, String str) {
            this.f204644a = i3;
            this.f204645b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTSouGouEmojiSender.this, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(Emoticon emoticon) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticon);
                return;
            }
            if (emoticon != null && emoticon.hasEncryptKey()) {
                NTSouGouEmojiSender.this.f(emoticon);
                if (QLog.isColorLevel()) {
                    QLog.d("SouGouEmojiSender", 2, "func trySend ends, everything is ok.");
                    return;
                }
                return;
            }
            NTSouGouEmojiSender.this.e(Integer.toString(this.f204644a), this.f204645b, true);
            if (QLog.isColorLevel()) {
                QLog.d("SouGouEmojiSender", 2, "func trySend ends, emotion has invalid key. Call func pullSingleEmojiKey");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements QueryCallback<EmoticonPackage> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PicEmoticonInfo f204647a;

        c(PicEmoticonInfo picEmoticonInfo) {
            this.f204647a = picEmoticonInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTSouGouEmojiSender.this, (Object) picEmoticonInfo);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(EmoticonPackage emoticonPackage) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                return;
            }
            if (emoticonPackage != null) {
                PicEmoticonInfo picEmoticonInfo = this.f204647a;
                picEmoticonInfo.imageType = emoticonPackage.type;
                if (emoticonPackage.isAPNG == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                picEmoticonInfo.isAPNG = z16;
            } else {
                this.f204647a.imageType = 3;
            }
            NTSouGouEmojiSender.this.f204632e.send(this.f204647a);
            if (QLog.isColorLevel()) {
                QLog.d("SouGouEmojiSender", 2, "func sendEmoji ends, type:" + this.f204647a.imageType);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class d extends EmoticonObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<NTSouGouEmojiSender> f204649d;

        public d(NTSouGouEmojiSender nTSouGouEmojiSender) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTSouGouEmojiSender);
            } else {
                this.f204649d = new WeakReference<>(nTSouGouEmojiSender);
            }
        }

        @Override // com.tencent.mobileqq.app.EmoticonObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SouGouEmojiSender", 2, "func onEmosmBack begins, isSuccess:" + z16 + ",type:" + i3);
            }
            if (z16 && obj != null && i3 == 3) {
                NTSouGouEmojiSender nTSouGouEmojiSender = this.f204649d.get();
                if (nTSouGouEmojiSender == null) {
                    QLog.d("SouGouEmojiSender", 2, "WeakReference error");
                    return;
                }
                List list = ((EmoticonResp) obj).data;
                if (list == null) {
                    return;
                }
                ArrayList arrayList = (ArrayList) list;
                if (arrayList.size() == 0) {
                    return;
                }
                boolean d16 = nTSouGouEmojiSender.f204636i.d(nTSouGouEmojiSender.f204629b);
                if (QLog.isColorLevel()) {
                    QLog.d("SouGouEmojiSender", 2, "func onEmojiKeyBack begins, isTaskExist:" + d16);
                }
                if (!d16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SouGouEmojiSender", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
                    }
                } else {
                    if (arrayList.size() > 0) {
                        nTSouGouEmojiSender.f((Emoticon) arrayList.get(0));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SouGouEmojiSender", 2, "func onEmojiKeyBack ends, Ready to send.");
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ThemeBackground.AVATAR_BG_ID);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f204626l = MiniAppGetGameTaskTicketServlet.KEY_TASKID;
            f204627m = "exprId";
        }
    }

    public NTSouGouEmojiSender(Activity activity, BaseQQAppInterface baseQQAppInterface, NTEmoticonSenderApi nTEmoticonSenderApi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, baseQQAppInterface, nTEmoticonSenderApi);
            return;
        }
        this.f204628a = 0;
        this.f204637j = new a();
        this.f204638k = new d(this);
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func SogouEmoji constructor begins");
        }
        this.f204632e = nTEmoticonSenderApi;
        this.f204630c = baseQQAppInterface;
        this.f204631d = activity;
        this.f204633f = (IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
        this.f204634g = (IEmojiManagerService) this.f204630c.getRuntimeService(IEmojiManagerService.class);
        this.f204635h = (EmoticonHandler) this.f204630c.getBusinessHandler(EmoticonHandler.F);
        this.f204636i = new t(activity);
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func SogouEmoji constructor ends");
        }
        this.f204630c.addObserver(this.f204638k);
    }

    private boolean d(String str) {
        if (this.f204630c == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SouGouEmojiSender", 2, "func" + str + " ends, maybe chatActivity is finished.");
                return false;
            }
            return false;
        }
        return true;
    }

    ArrayList<Emoticon> b(ArrayList<Emoticon> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func getInvalidKeyEmoticon begins");
        }
        ArrayList<Emoticon> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<Emoticon> it = arrayList.iterator();
            while (it.hasNext()) {
                Emoticon next = it.next();
                if (!next.hasEncryptKey()) {
                    arrayList2.add(next);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SouGouEmojiSender", 2, "func getInvalidKeyEmoticon ends, size:" + arrayList2.size());
            }
        }
        return arrayList2;
    }

    void c(String str, ArrayList<Emoticon> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func getPackEmojiKey begins, packId:" + str);
        }
        if (!d("getPackEmojiKey")) {
            return;
        }
        String num = Integer.toString(this.f204628a);
        this.f204628a++;
        if (com.tencent.mobileqq.emosm.e.C(str)) {
            this.f204635h.I2(Integer.parseInt(str), arrayList, num);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func getPackEmojiKey ends");
        }
    }

    public void e(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Boolean.valueOf(z16));
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable(str, str2, z16) { // from class: com.tencent.mobileqq.emoticon.NTSouGouEmojiSender.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f204639d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f204640e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f204641f;

                {
                    this.f204639d = str;
                    this.f204640e = str2;
                    this.f204641f = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NTSouGouEmojiSender.this, str, str2, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SouGouEmojiSender", 2, "func pullSingleEmojiKey begins, packId=" + this.f204639d + ",exprId:" + this.f204640e + ",isNewTask:" + this.f204641f);
                    }
                    if (NTSouGouEmojiSender.this.f204633f.syncFindEmoticonPackageById(this.f204639d) == null) {
                        NTSouGouEmojiSender nTSouGouEmojiSender = NTSouGouEmojiSender.this;
                        nTSouGouEmojiSender.f204629b = nTSouGouEmojiSender.f204636i.a(this.f204639d, this.f204640e);
                        Bundle bundle = new Bundle();
                        bundle.putInt(NTSouGouEmojiSender.f204626l, NTSouGouEmojiSender.this.f204629b);
                        bundle.putString(NTSouGouEmojiSender.f204627m, this.f204640e);
                        com.tencent.mobileqq.emoticon.b.b().addEmotionJsonDownloadListener(NTSouGouEmojiSender.this.f204637j);
                        NTSouGouEmojiSender.this.f204634g.startDownloadEmosmJson(this.f204639d, EmojiManagerServiceConstant.JSON_EMOSM_MALL, bundle, false);
                        if (QLog.isColorLevel()) {
                            QLog.d("SouGouEmojiSender", 2, "func pullSingleEmojiKey ends, fail to search \u3010the pack\u3011 from db, try get json from srv, mCurTaskId:" + NTSouGouEmojiSender.this.f204629b);
                            return;
                        }
                        return;
                    }
                    Emoticon syncFindEmoticonById = NTSouGouEmojiSender.this.f204633f.syncFindEmoticonById(this.f204639d, this.f204640e);
                    if (syncFindEmoticonById == null) {
                        NTSouGouEmojiSender nTSouGouEmojiSender2 = NTSouGouEmojiSender.this;
                        nTSouGouEmojiSender2.f204629b = nTSouGouEmojiSender2.f204636i.a(this.f204639d, this.f204640e);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(NTSouGouEmojiSender.f204626l, NTSouGouEmojiSender.this.f204629b);
                        bundle2.putString(NTSouGouEmojiSender.f204627m, this.f204640e);
                        com.tencent.mobileqq.emoticon.b.b().addEmotionJsonDownloadListener(NTSouGouEmojiSender.this.f204637j);
                        NTSouGouEmojiSender.this.f204634g.startDownloadEmosmJson(this.f204639d, EmojiManagerServiceConstant.JSON_EMOSM_MALL, bundle2, false);
                        if (QLog.isColorLevel()) {
                            QLog.d("SouGouEmojiSender", 2, "func pullSingleEmojiKey ends, fail to search \u3010the emotion\u3011 from db, try get json from srv, mCurTaskId:" + NTSouGouEmojiSender.this.f204629b);
                            return;
                        }
                        return;
                    }
                    ArrayList<Emoticon> arrayList = new ArrayList<>();
                    arrayList.add(syncFindEmoticonById);
                    if (this.f204641f) {
                        NTSouGouEmojiSender nTSouGouEmojiSender3 = NTSouGouEmojiSender.this;
                        nTSouGouEmojiSender3.f204629b = nTSouGouEmojiSender3.f204636i.a(this.f204639d, this.f204640e);
                    }
                    NTSouGouEmojiSender.this.c(this.f204639d, arrayList);
                    if (QLog.isColorLevel()) {
                        QLog.d("SouGouEmojiSender", 2, "func pullSingleEmojiKey ends, everything is ok, try get keys from svr");
                    }
                }
            });
        }
    }

    void f(Emoticon emoticon) {
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func sendEmoji begins, mCurTaskId:" + this.f204629b + ",emoticon:" + emoticon);
        }
        this.f204636i.b();
        this.f204636i.g(this.f204629b);
        this.f204636i.f();
        if (!d("sendEmoji")) {
            return;
        }
        PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(this.f204630c.getCurrentAccountUin());
        picEmoticonInfo.type = 6;
        picEmoticonInfo.emoticon = emoticon;
        this.f204633f.asyncFindEmoticonPackage(emoticon.epId, new c(picEmoticonInfo));
    }

    @Override // com.tencent.mobileqq.emoticon.ISogouEmoji
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func SogouEmoji destructor begins");
        }
        BaseQQAppInterface baseQQAppInterface = this.f204630c;
        if (baseQQAppInterface != null) {
            baseQQAppInterface.removeObserver(this.f204638k);
        }
        t tVar = this.f204636i;
        if (tVar != null) {
            tVar.e();
        }
        com.tencent.mobileqq.emoticon.b.b().removeEmotionJsonDownloadListener(this.f204637j);
        this.f204630c = null;
        this.f204631d = null;
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func SogouEmoji destructor ends");
        }
    }

    @Override // com.tencent.mobileqq.emoticon.ISogouEmoji
    public void pullMultipleEmojiKey(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable(list) { // from class: com.tencent.mobileqq.emoticon.NTSouGouEmojiSender.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f204642d;

                {
                    this.f204642d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTSouGouEmojiSender.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SouGouEmojiSender", 2, "func pullMultipleEmojiKey begins, allPackId:" + this.f204642d);
                    }
                    List list2 = this.f204642d;
                    if (list2 != null && list2.size() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SouGouEmojiSender", 2, "func pullMultipleEmojiKey,size:" + this.f204642d.size());
                        }
                        ArrayList<Emoticon> arrayList = null;
                        for (String str : this.f204642d) {
                            EmoticonPackage syncFindEmoticonPackageById = NTSouGouEmojiSender.this.f204633f.syncFindEmoticonPackageById(str);
                            if (syncFindEmoticonPackageById == null) {
                                NTSouGouEmojiSender.this.f204634g.startDownloadEmosmJson(str, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SouGouEmojiSender", 2, "func pullMultipleEmojiKey, packId=" + str + ",fail to search \u3010the pack\u3011 from db, try get json from svr.");
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SouGouEmojiSender", 2, "func pullMultipleEmojiKey, packId=" + str + ",type:" + syncFindEmoticonPackageById.type + ",json exists in local db.");
                                }
                                List<Emoticon> syncGetSubEmoticonsByPackageId = NTSouGouEmojiSender.this.f204633f.syncGetSubEmoticonsByPackageId(str, true);
                                if (syncGetSubEmoticonsByPackageId instanceof ArrayList) {
                                    arrayList = NTSouGouEmojiSender.this.b((ArrayList) syncGetSubEmoticonsByPackageId);
                                }
                                if (arrayList != null && arrayList.size() != 0) {
                                    NTSouGouEmojiSender.this.c(str, arrayList);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SouGouEmojiSender", 2, "func pullMultipleEmojiKey ends, packId=" + str + ", try get keys from svr.");
                                    }
                                }
                            }
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SouGouEmojiSender", 2, "func pullMultipleEmojiKey ends, param packid is null.");
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emoticon.ISogouEmoji
    public void trySend(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SouGouEmojiSender", 2, "func trySend begins, packId:" + i3 + ",exprId:" + str);
        }
        Activity activity = this.f204631d;
        if (activity != null && !NetworkUtil.isNetSupport(activity.getApplicationContext())) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171137ci2, 0).show();
        } else {
            this.f204633f.asyncFindEmoticon(Integer.toString(i3), str, new b(i3, str));
        }
    }
}
