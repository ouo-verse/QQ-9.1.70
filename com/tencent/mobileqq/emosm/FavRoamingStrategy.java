package com.tencent.mobileqq.emosm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FavRoamingStrategy extends BaseEmosmStrategy {

    /* renamed from: h, reason: collision with root package name */
    private IFavroamingDBManagerService f204100h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f204101i;

    /* renamed from: j, reason: collision with root package name */
    private List<String> f204102j;

    /* renamed from: k, reason: collision with root package name */
    FavEmoRoamingObserver f204103k;

    /* renamed from: l, reason: collision with root package name */
    com.tencent.mobileqq.emosm.favroaming.n<CustomEmotionData> f204104l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements CustomEmotionRoamingDBManagerBase.a {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.a
        public void callbackInMainThread(List<EmoticonInfo> list) {
            List<EmoticonInfo> list2;
            if (list == null) {
                list2 = new ArrayList<>();
            } else {
                list2 = list;
            }
            QLog.d("FavEmoRoamingHandler", 1, "fav emoticon size:", Integer.valueOf(list2.size()));
            if (list2.size() >= FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                ReportController.o(FavRoamingStrategy.this.f204070a, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
            }
            if (list2.size() >= FavEmoConstant.FAV_ROAMING_MAX_COUNT) {
                ReportController.o(FavRoamingStrategy.this.f204070a, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
            }
            k kVar = FavRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.C(list2);
            } else {
                QLog.e("FavRoamingStrategy", 1, "[loadFavEmoticon] error, emosmView is null!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements CustomEmotionRoamingDBManagerBase.a {
        b() {
        }

        @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.a
        public void callbackInMainThread(List<EmoticonInfo> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            k kVar = FavRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.L(list);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c extends FavEmoRoamingObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        public void onDelEmoResponse(boolean z16) {
            FavRoamingStrategy.this.f204102j.clear();
        }

        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        protected void onModifyFavData(boolean z16, Object obj) {
            k kVar;
            if (z16 && (kVar = FavRoamingStrategy.this.f204071b) != null) {
                kVar.K();
            }
        }

        @Override // com.tencent.mobileqq.app.FavEmoRoamingObserver
        protected void onUpdateFavData(boolean z16, Object obj) {
            if (obj != null && (obj instanceof Integer) && FavRoamingStrategy.this.f204101i != null) {
                FavRoamingStrategy.this.f204101i.obtainMessage(208, obj).sendToTarget();
            }
            k kVar = FavRoamingStrategy.this.f204071b;
            if (kVar != null && z16) {
                kVar.K();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d extends com.tencent.mobileqq.emosm.favroaming.n<CustomEmotionData> {
        d() {
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onDownloadFinish(int i3) {
            k kVar = FavRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.K();
            }
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onUploadFinish() {
            k kVar = FavRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.K();
            }
        }

        @Override // com.tencent.mobileqq.emosm.favroaming.n
        public void onFileDone(CustomEmotionData customEmotionData, int i3, int i16) {
            k kVar;
            if ((i3 <= 28 || i16 % 28 == 0) && (kVar = FavRoamingStrategy.this.f204071b) != null) {
                kVar.K();
            }
        }
    }

    public FavRoamingStrategy(BaseQQAppInterface baseQQAppInterface, k kVar) {
        super(baseQQAppInterface, kVar);
        this.f204102j = new ArrayList();
        this.f204103k = new c();
        this.f204104l = new d();
    }

    private void A() {
        if (this.f204074e && !this.f204073d.isEmpty()) {
            List<EmoticonInfo> list = this.f204071b.P;
            int size = list.size();
            final ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                Parcelable parcelable = (EmoticonInfo) list.get(i16);
                if ((parcelable instanceof IFavoriteEmoticonInfo) && ((IFavoriteEmoticonInfo) parcelable).isChecked()) {
                    i3++;
                    arrayList.add(parcelable);
                }
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.FavRoamingStrategy.3
                @Override // java.lang.Runnable
                public void run() {
                    IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) FavRoamingStrategy.this.f204070a.getRuntimeService(IFavroamingDBManagerService.class);
                    if (QLog.isColorLevel()) {
                        QLog.i("FavRoamingStrategy", 2, "Call getEmoticonDataList-1 from doDelete.");
                    }
                    List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
                    int i17 = 1;
                    if (emoticonDataList != null) {
                        for (int i18 = 0; i18 < emoticonDataList.size(); i18++) {
                            int i19 = emoticonDataList.get(i18).emoId;
                            if (i17 < i19) {
                                i17 = i19;
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (FavoriteEmoticonInfo favoriteEmoticonInfo : FavRoamingStrategy.this.f204073d) {
                        if (!arrayList.contains(favoriteEmoticonInfo)) {
                            CustomEmotionData customEmotionData = new CustomEmotionData();
                            customEmotionData.uin = FavRoamingStrategy.this.f204070a.getCurrentAccountUin();
                            customEmotionData.url = favoriteEmoticonInfo.path;
                            customEmotionData.eId = favoriteEmoticonInfo.eId;
                            customEmotionData.md5 = favoriteEmoticonInfo.action;
                            i17++;
                            customEmotionData.emoId = i17;
                            customEmotionData.emoPath = AppConstants.SDCARD_IMG_FAVORITE + FunnyPicHelperConstant.getFunnyPicName(favoriteEmoticonInfo.path);
                            iFavroamingDBManagerService.insertCustomEmotion(customEmotionData);
                            arrayList2.add(customEmotionData);
                        }
                    }
                    IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) FavRoamingStrategy.this.f204070a.getRuntimeService(IFavroamingManagerService.class);
                    if (iFavroamingManagerService != null && !arrayList2.isEmpty()) {
                        iFavroamingManagerService.syncUpload(arrayList2);
                    }
                }
            }, 5, null, true);
            ReportController.o(this.f204070a, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i3), "", "", "");
            this.f204074e = false;
            MqqHandler chatActivityHander = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(this.f204070a);
            if (chatActivityHander != null) {
                chatActivityHander.obtainMessage(10).sendToTarget();
            }
            QQToast.makeText(this.f204070a.getApp(), "\u8da3\u56fe\u5df2\u6dfb\u52a0\u81f3\u6536\u85cf\u9762\u677f", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final GridView gridView, final int i3, final IFavoriteEmoticonInfo iFavoriteEmoticonInfo) {
        final List<CustomEmotionData> emoticonDataList = ((IFavroamingDBManagerService) this.f204070a.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
        this.f204101i.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.m
            @Override // java.lang.Runnable
            public final void run() {
                FavRoamingStrategy.this.B(gridView, i3, iFavoriteEmoticonInfo, emoticonDataList);
            }
        });
    }

    private void D() {
        c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void B(GridView gridView, int i3, IFavoriteEmoticonInfo iFavoriteEmoticonInfo, List<CustomEmotionData> list) {
        int i16;
        if (list == null) {
            if (iFavoriteEmoticonInfo != 0) {
                i16 = iFavoriteEmoticonInfo.getEmoId();
            } else {
                i16 = -1;
            }
            QLog.e("FavRoamingStrategy", 1, "[resendEmotionData] error, emoticonDataList is null. emoId:", Integer.valueOf(i16));
            return;
        }
        int emoId = iFavoriteEmoticonInfo.getEmoId();
        for (CustomEmotionData customEmotionData : list) {
            int i17 = customEmotionData.emoId;
            if (i17 == emoId) {
                QLog.d("FavRoamingStrategy", 1, "[resendEmotionData], emoId:", Integer.valueOf(i17));
                String str = customEmotionData.emoOriginalPath;
                if (str != null && !com.tencent.mobileqq.emosm.favroaming.f.a(str)) {
                    ((FavEmoRoamingHandler) this.f204070a.getBusinessHandler(FavEmoRoamingHandler.f194632e)).notifyUI(2, true, 1);
                } else {
                    customEmotionData.RomaingType = "needUpload";
                    F((EmoticonInfo) iFavoriteEmoticonInfo, "needUpload");
                    k kVar = this.f204071b;
                    if (kVar != null) {
                        kVar.M(iFavoriteEmoticonInfo.getPath(), "needUpload");
                        this.f204071b.Y(gridView, i3);
                    }
                    CameraEmoAllSend.S = false;
                    ThreadManagerV2.excute(new FavEmoSingleSend(customEmotionData, true), 64, null, false);
                }
            }
        }
    }

    private void F(EmoticonInfo emoticonInfo, String str) {
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            ((FavoriteEmoticonInfo) emoticonInfo).roamingType = str;
        } else if (emoticonInfo instanceof PicEmoticonInfo) {
            ((PicEmoticonInfo) emoticonInfo).roamingType = str;
        }
    }

    private void z(final IVipComicMqqManagerService iVipComicMqqManagerService, final int i3, final Object obj) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.FavRoamingStrategy.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                ArrayList<CustomEmotionData> arrayList = new ArrayList();
                if (QLog.isColorLevel()) {
                    QLog.i("FavRoamingStrategy", 2, "Call getEmoticonDataList-2 from doDelete.");
                }
                List<CustomEmotionData> emoticonDataList = FavRoamingStrategy.this.a().getEmoticonDataList();
                if (emoticonDataList != null && emoticonDataList.size() > 0) {
                    for (CustomEmotionData customEmotionData : emoticonDataList) {
                        if (customEmotionData != null) {
                            Object obj2 = obj;
                            if (obj2 instanceof PicEmoticonInfo) {
                                Emoticon emoticon = ((PicEmoticonInfo) obj2).emoticon;
                                if (!TextUtils.isEmpty(customEmotionData.eId) && emoticon != null && customEmotionData.eId.equals(emoticon.eId)) {
                                    arrayList.add(customEmotionData);
                                }
                            } else if (obj2 instanceof FavoriteEmoticonInfo) {
                                if (FavRoamingStrategy.this.f204073d.contains(obj2)) {
                                    str = AppConstants.SDCARD_IMG_FAVORITE + FunnyPicHelperConstant.getFunnyPicName(((FavoriteEmoticonInfo) obj).path);
                                } else {
                                    str = ((FavoriteEmoticonInfo) obj).path;
                                }
                                if (!TextUtils.isEmpty(customEmotionData.emoPath) && customEmotionData.emoPath.equals(str)) {
                                    arrayList.add(customEmotionData);
                                }
                                if (TextUtils.isEmpty(customEmotionData.emoPath) && "init".equals(customEmotionData.RomaingType)) {
                                    QLog.e("FavRoamingStrategy", 2, "delete failed, path is null, state is init. data: " + customEmotionData);
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (CustomEmotionData customEmotionData2 : arrayList) {
                        if (!TextUtils.isEmpty(customEmotionData2.resid)) {
                            customEmotionData2.RomaingType = "needDel";
                            FavRoamingStrategy.this.a().updateCustomEmotion(customEmotionData2);
                            FavRoamingStrategy.this.f204102j.add(customEmotionData2.resid);
                            if (!TextUtils.isEmpty(customEmotionData2.md5)) {
                                arrayList2.add(customEmotionData2.md5);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("FavRoamingStrategy", 2, "delete from local, Roma Type: " + customEmotionData2.RomaingType);
                            }
                            FavRoamingStrategy.this.a().deleteCustomEmotion(customEmotionData2);
                            if (!TextUtils.isEmpty(customEmotionData2.md5)) {
                                arrayList2.add(customEmotionData2.md5);
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        iVipComicMqqManagerService.delComicEmoticonList(arrayList2);
                    }
                } else {
                    QLog.e("FavRoamingStrategy", 1, "delete failed, not find original emotion data");
                }
                if (FavRoamingStrategy.this.f204101i != null) {
                    FavRoamingStrategy.this.f204101i.obtainMessage(207, Integer.valueOf(i3)).sendToTarget();
                }
            }
        }, 5, null, false);
    }

    @Override // com.tencent.mobileqq.emosm.n
    public CustomEmotionRoamingDBManagerBase<CustomEmotionData> a() {
        if (this.f204100h == null) {
            this.f204100h = (IFavroamingDBManagerService) this.f204070a.getRuntimeService(IFavroamingDBManagerService.class);
        }
        return (CustomEmotionRoamingDBManagerBase) this.f204100h;
    }

    @Override // com.tencent.mobileqq.emosm.n
    public void b() {
        List<EmoticonInfo> list;
        int i3;
        boolean z16;
        FavEmoRoamingHandler favEmoRoamingHandler;
        k kVar = this.f204071b;
        if (kVar != null && (list = kVar.P) != null) {
            Iterator<EmoticonInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    Parcelable parcelable = (EmoticonInfo) it.next();
                    if ((parcelable instanceof IFavoriteEmoticonInfo) && ((IFavoriteEmoticonInfo) parcelable).isChecked()) {
                        z16 = false;
                        break;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16 && (favEmoRoamingHandler = (FavEmoRoamingHandler) this.f204070a.getBusinessHandler(FavEmoRoamingHandler.f194632e)) != null) {
                favEmoRoamingHandler.delUserEmoRoamingReq(this.f204102j, false);
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.f204102j.toString());
                }
                ReportController.o(this.f204070a, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.f204102j.size() + "", "", "", "");
                ReportController.o(this.f204070a, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.f204102j.size()), "", "", "");
            }
            if (this.f204072c.get()) {
                MqqHandler chatActivityHander = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(this.f204070a);
                if (chatActivityHander != null) {
                    chatActivityHander.obtainMessage(10).sendToTarget();
                    return;
                }
                return;
            }
            A();
            IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) this.f204070a.getRuntimeService(IVipComicMqqManagerService.class);
            for (i3 = 0; i3 < this.f204071b.P.size(); i3++) {
                Object item = this.f204071b.getItem(i3);
                if (item != null && (item instanceof IFavoriteEmoticonInfo) && ((IFavoriteEmoticonInfo) item).isChecked()) {
                    z(iVipComicMqqManagerService, i3, item);
                    return;
                }
            }
            MqqHandler chatActivityHander2 = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(this.f204070a);
            if (chatActivityHander2 != null) {
                chatActivityHander2.obtainMessage(10).sendToTarget();
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void d() {
        if (QLog.isColorLevel()) {
            QLog.d("FavRoamingStrategy", 2, "fav doSyncEmotion");
        }
        if (this.f204070a == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.FavRoamingStrategy.7
            @Override // java.lang.Runnable
            public void run() {
                BaseQQAppInterface baseQQAppInterface = FavRoamingStrategy.this.f204070a;
                if (baseQQAppInterface != null && NetworkUtil.isNetSupport(baseQQAppInterface.getApp())) {
                    ((IFavroamingManagerService) FavRoamingStrategy.this.f204070a.getRuntimeService(IFavroamingManagerService.class)).syncRoaming();
                }
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public String f(EmoticonInfo emoticonInfo) {
        if (emoticonInfo == null) {
            return null;
        }
        return ((IFavroamingManagerService) this.f204070a.getRuntimeService(IFavroamingManagerService.class)).getAccessibilityDescription(Integer.valueOf(emoticonInfo.emoId));
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public boolean i(Activity activity) {
        boolean booleanExtra = activity.getIntent().getBooleanExtra("extra_key_from_web", false);
        this.f204074e = booleanExtra;
        this.f204075f = booleanExtra;
        if (booleanExtra) {
            ArrayList<String> stringArrayListExtra = activity.getIntent().getStringArrayListExtra("extra_key_pkgids");
            ArrayList<String> stringArrayListExtra2 = activity.getIntent().getStringArrayListExtra("extra_key_paths");
            ArrayList<String> stringArrayListExtra3 = activity.getIntent().getStringArrayListExtra("extra_key_md5s");
            int intExtra = activity.getIntent().getIntExtra("extra_key_faile_count", 0);
            if (stringArrayListExtra != null && stringArrayListExtra2 != null && stringArrayListExtra3 != null) {
                int min = Math.min(stringArrayListExtra3.size(), Math.min(stringArrayListExtra.size(), stringArrayListExtra2.size()));
                for (int i3 = 0; i3 < min; i3++) {
                    FavoriteEmoticonInfo favoriteEmoticonInfo = new FavoriteEmoticonInfo();
                    favoriteEmoticonInfo.eId = stringArrayListExtra.get(i3);
                    favoriteEmoticonInfo.path = stringArrayListExtra2.get(i3);
                    favoriteEmoticonInfo.action = stringArrayListExtra3.get(i3);
                    this.f204073d.add(favoriteEmoticonInfo);
                }
            }
            if (intExtra > 0) {
                QQToast.makeText(activity, intExtra + "\u4e2a\u4e0b\u8f7d\u5931\u8d25", 0).show();
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public boolean j() {
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public boolean k() {
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void n() {
        super.n();
        this.f204101i = this.f204071b.r();
        this.f204071b.Q(R.string.awr);
        this.f204070a.addObserver(this.f204103k);
        D();
        if (this.f204100h == null) {
            this.f204100h = (IFavroamingDBManagerService) this.f204070a.getRuntimeService(IFavroamingDBManagerService.class);
        }
        ((IFavroamingManagerService) this.f204070a.getRuntimeService(IFavroamingManagerService.class)).addSyncListener(this.f204104l);
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void o() {
        super.o();
        this.f204101i = null;
        this.f204102j.clear();
        if (this.f204075f) {
            this.f204070a.getApplication().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
        }
        ((IFavroamingManagerService) this.f204070a.getRuntimeService(IFavroamingManagerService.class)).removeSyncListener(this.f204104l);
        FavEmoRoamingObserver favEmoRoamingObserver = this.f204103k;
        if (favEmoRoamingObserver != null) {
            this.f204070a.removeObserver(favEmoRoamingObserver);
        }
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void p(Context context, Intent intent) {
        super.p(context, intent);
        if ("com.tencent.mobileqq.action.update.emotiom".equals(intent.getAction())) {
            c(new b());
        }
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void s() {
        ReportController.o(this.f204070a, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void t() {
        ReportController.o(this.f204070a, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void u(final GridView gridView, final int i3, final IFavoriteEmoticonInfo iFavoriteEmoticonInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.l
            @Override // java.lang.Runnable
            public final void run() {
                FavRoamingStrategy.this.C(gridView, i3, iFavoriteEmoticonInfo);
            }
        }, 32, null, false);
    }
}
