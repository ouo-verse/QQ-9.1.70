package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.guild.api.emoji.IGuildEmoPreviewApi;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.j;
import com.tencent.mobileqq.emosm.favroaming.k;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emotionintegrate.r;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BatchSaveEmoFavTask implements IChatHistoryEmotionBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f182500a;

    /* renamed from: b, reason: collision with root package name */
    k f182501b;

    /* renamed from: c, reason: collision with root package name */
    private EmoticonObserver f182502c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends EmoticonObserver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.history.BatchSaveEmoFavTask$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C7166a implements QueryCallback<Emoticon> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ EmoticonResp f182508a;

            C7166a(EmoticonResp emoticonResp) {
                this.f182508a = emoticonResp;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) emoticonResp);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void postQuery(Emoticon emoticon) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQAppInterface g16 = BatchSaveEmoFavTask.this.g();
                    IEmoBatchAddedHandlerApi iEmoBatchAddedHandlerApi = (IEmoBatchAddedHandlerApi) QRoute.api(IEmoBatchAddedHandlerApi.class);
                    QQAppInterface g17 = BatchSaveEmoFavTask.this.g();
                    k kVar = BatchSaveEmoFavTask.this.f182501b;
                    MarketFaceItemBuilder.b(g16, emoticon, iEmoBatchAddedHandlerApi.createEmoBatchAddedCallback(g17, kVar, kVar.d(this.f182508a.epId + this.f182508a.emoticonId)));
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticon);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BatchSaveEmoFavTask.this);
            }
        }

        @Override // com.tencent.mobileqq.app.EmoticonObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if (i3 == 6) {
                if (obj == null) {
                    BatchSaveEmoFavTask.this.f182501b.b(3);
                    return;
                }
                EmoticonResp emoticonResp = (EmoticonResp) obj;
                if (QLog.isColorLevel()) {
                    QLog.d("EmoBatchAdded", 2, "EmoticonObserver resp.delEpId \uff1a" + emoticonResp.delEpId);
                }
                if (z16 && emoticonResp.delEpId == 0 && !TextUtils.isEmpty(emoticonResp.emoticonId) && BatchSaveEmoFavTask.this.g() != null) {
                    ((IEmoticonManagerService) BatchSaveEmoFavTask.this.g().getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(emoticonResp.epId), emoticonResp.emoticonId, new C7166a(emoticonResp));
                } else {
                    BatchSaveEmoFavTask.this.f182501b.b(3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b extends EmotionJsonDownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private IPicEmoticonInfo f182510a;

        /* renamed from: b, reason: collision with root package name */
        private QQAppInterface f182511b;

        /* renamed from: c, reason: collision with root package name */
        j f182512c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(QQAppInterface qQAppInterface, IPicEmoticonInfo iPicEmoticonInfo, j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, qQAppInterface, iPicEmoticonInfo, jVar);
                return;
            }
            this.f182511b = qQAppInterface;
            this.f182510a = iPicEmoticonInfo;
            this.f182512c = jVar;
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, emoticonPackage, Integer.valueOf(i3), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EmoBatchAdded", 2, "onJsonComplete:" + emoticonPackage.epId + " ,currEpid:" + this.f182510a.getEmoticon().epId);
            }
            if (i3 == 0) {
                if (Long.parseLong(emoticonPackage.epId) != Long.parseLong(this.f182510a.getEmoticon().epId)) {
                    this.f182512c.m(-1);
                    return;
                } else {
                    this.f182511b.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int) (System.currentTimeMillis() / 1000)).commit();
                    MarketFaceItemBuilder.d(this.f182511b, emoticonPackage, this.f182510a, this.f182512c);
                    return;
                }
            }
            this.f182512c.m(-1);
        }
    }

    public BatchSaveEmoFavTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f182502c = new a();
        }
    }

    private static void d(Context context, List<AIOMsgItem> list, QQAppInterface qQAppInterface, k kVar) {
        ThreadManagerV2.executeOnSubThread(new Runnable(list, kVar, qQAppInterface, context) { // from class: com.tencent.mobileqq.activity.history.BatchSaveEmoFavTask.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f182503d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ k f182504e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f182505f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Context f182506h;

            {
                this.f182503d = list;
                this.f182504e = kVar;
                this.f182505f = qQAppInterface;
                this.f182506h = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, list, kVar, qQAppInterface, context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BatchSaveEmoFavTask", 1, "addEmotions execute");
                }
                List list2 = this.f182503d;
                if (list2 != null && !list2.isEmpty()) {
                    ReportController.o(null, "dc00898", "", "", "0X800B724", "0X800B724", this.f182503d.size(), 0, "", "", "", "");
                    this.f182504e.b(100);
                    this.f182504e.init(this.f182503d.size());
                    if (this.f182504e.a() + this.f182503d.size() > FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                        this.f182504e.b(1);
                        return;
                    }
                    for (int i3 = 0; i3 < this.f182503d.size(); i3++) {
                        AIOMsgItem aIOMsgItem = (AIOMsgItem) this.f182503d.get(i3);
                        IEmoBatchAddedHandlerApi iEmoBatchAddedHandlerApi = (IEmoBatchAddedHandlerApi) QRoute.api(IEmoBatchAddedHandlerApi.class);
                        QQAppInterface qQAppInterface2 = this.f182505f;
                        k kVar2 = this.f182504e;
                        j createEmoBatchAddedCallback = iEmoBatchAddedHandlerApi.createEmoBatchAddedCallback(qQAppInterface2, kVar2, kVar2.c(Integer.valueOf(i3)));
                        if (com.tencent.mobileqq.aio.utils.d.D(aIOMsgItem)) {
                            BatchSaveEmoFavTask.e(this.f182505f, this.f182504e, (MessageRecord) ((IGuildEmoPreviewApi) QRoute.api(IGuildEmoPreviewApi.class)).createMarketFace(aIOMsgItem.getFirstTypeElement(11).getMarketFaceElement(), aIOMsgItem.v().getPeerUid(), aIOMsgItem.v().getGuildId()), i3, createEmoBatchAddedCallback);
                        } else if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
                            BatchSaveEmoFavTask.f(this.f182506h, this.f182505f, this.f182504e, ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(aIOMsgItem.getFirstTypeElement(2)), i3, createEmoBatchAddedCallback);
                        }
                    }
                    return;
                }
                com.tencent.mobileqq.filemanager.util.d.c(R.string.b8i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(QQAppInterface qQAppInterface, k kVar, MessageRecord messageRecord, int i3, j jVar) {
        IPicEmoticonInfo f16 = r.f((MessageForMarketFace) messageRecord);
        if (f16 == null) {
            kVar.b(3);
            return;
        }
        Emoticon emoticon = f16.getEmoticon();
        if (emoticon == null) {
            kVar.b(3);
            return;
        }
        String str = emoticon.epId + emoticon.eId;
        if (kVar.contains(str)) {
            kVar.b(2);
            return;
        }
        kVar.e(str, Integer.valueOf(i3));
        EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId, 0);
        if (syncFindEmoticonPackageById != null && syncFindEmoticonPackageById.name != null && (syncFindEmoticonPackageById.mobileFeetype != 0 || syncFindEmoticonPackageById.downloadCount != 0)) {
            int i16 = qQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis - i16 <= 86400 && currentTimeMillis >= i16) {
                MarketFaceItemBuilder.d(qQAppInterface, syncFindEmoticonPackageById, f16, jVar);
            } else {
                i(f16, emoticon, qQAppInterface, jVar);
            }
        } else {
            i(f16, emoticon, qQAppInterface, jVar);
        }
        EmoticonOperateReport.reportFavAddEmotionEvent(qQAppInterface, 2, null, emoticon.eId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, QQAppInterface qQAppInterface, k kVar, String str, int i3, j jVar) {
        QLog.i("BatchSaveEmoFavTask", 4, "addPicEmotion path=" + str);
        int f16 = com.tencent.mobileqq.activity.aio.photo.c.f(context, str, qQAppInterface, kVar.c(Integer.valueOf(i3)), jVar);
        if (f16 != 0) {
            if (f16 != 1) {
                if (f16 == 2) {
                    kVar.b(2);
                    return;
                }
                return;
            }
            kVar.b(3);
            return;
        }
        kVar.b(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface g() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void h(Context context) {
        this.f182500a = context;
        this.f182501b = ((IEmoBatchAddedHandlerApi) QRoute.api(IEmoBatchAddedHandlerApi.class)).createEmoBatchAddedHandler(this, g());
        g().addObserver(this.f182502c);
    }

    private static void i(IPicEmoticonInfo iPicEmoticonInfo, Emoticon emoticon, QQAppInterface qQAppInterface, j jVar) {
        b bVar = new b();
        if (iPicEmoticonInfo != null && emoticon != null) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoBatchAdded", 1, "startDownloadEmoticonJson");
            }
            bVar.a(qQAppInterface, iPicEmoticonInfo, jVar);
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) qQAppInterface.getRuntimeService(IEmojiManagerService.class);
            iEmojiManagerService.getEmojiListenerManager().addEmotionJsonDownloadListener(bVar);
            iEmojiManagerService.startDownloadEmosmJson(emoticon.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoBatchAdded", 1, "error in json downloading");
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment
    public void changeToUnSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d("BatchSaveEmoFavTask", 1, "addEmotions execute");
            g().removeObserver(this.f182502c);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment
    public Context getBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f182500a;
    }

    public void j(Context context, List<AIOMsgItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) list);
            return;
        }
        h(context);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(context, R.string.cjm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else if (context != null) {
            d(context, list, g(), this.f182501b);
        }
    }
}
