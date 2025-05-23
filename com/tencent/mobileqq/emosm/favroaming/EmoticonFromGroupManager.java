package com.tencent.mobileqq.emosm.favroaming;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoticonFromGroupManager implements l {

    /* renamed from: i, reason: collision with root package name */
    private static Executor f204308i;

    /* renamed from: a, reason: collision with root package name */
    private final List<Integer> f204309a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Integer> f204310b;

    /* renamed from: c, reason: collision with root package name */
    private BaseQQAppInterface f204311c;

    /* renamed from: d, reason: collision with root package name */
    private Context f204312d;

    /* renamed from: e, reason: collision with root package name */
    private IEmoticonFromGroupDBManagerService<EmoticonFromGroupEntity> f204313e;

    /* renamed from: f, reason: collision with root package name */
    protected List<EmoticonFromGroupEntity> f204314f;

    /* renamed from: g, reason: collision with root package name */
    private Handler.Callback f204315g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f204316h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager$5, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f204317d;

        AnonymousClass5(List list) {
            this.f204317d = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(EmoticonFromGroupEntity emoticonFromGroupEntity, IFavroamingDBManagerService iFavroamingDBManagerService, IFavroamingManagerService iFavroamingManagerService, CustomEmotionData customEmotionData, FileTransNotifyInfo fileTransNotifyInfo) {
            QLog.i("EmoticonFromGroup_Manager", 1, String.format("downloadPicsInMsgRecord result:%d path:%s", Long.valueOf(fileTransNotifyInfo.getFileErrCode()), fileTransNotifyInfo.getFilePath()));
            emoticonFromGroupEntity.bigURL = fileTransNotifyInfo.getFilePath();
            URLDrawable uRLDrawable = (URLDrawable) EmoticonFromGroupManager.this.j(emoticonFromGroupEntity, 1, -1, null);
            if (uRLDrawable != null) {
                EmoticonFromGroupManager.this.B(iFavroamingDBManagerService, iFavroamingManagerService, customEmotionData, uRLDrawable);
            } else {
                QLog.e("EmoticonFromGroup_Manager", 1, "get drawable failed: " + emoticonFromGroupEntity);
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            MsgRecord msgRecord;
            final IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) EmoticonFromGroupManager.this.f204311c.getRuntimeService(IFavroamingDBManagerService.class);
            final IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) EmoticonFromGroupManager.this.f204311c.getRuntimeService(IFavroamingManagerService.class);
            int i17 = 2;
            if (QLog.isColorLevel()) {
                QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from onUploadPic.");
            }
            List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
            ArrayList arrayList = new ArrayList(30);
            int i18 = 0;
            int i19 = 1;
            if (emoticonDataList != null) {
                i3 = 1;
                for (int i26 = 0; i26 < emoticonDataList.size(); i26++) {
                    int i27 = emoticonDataList.get(i26).emoId;
                    if (i3 < i27) {
                        i3 = i27;
                    }
                }
            } else {
                i3 = 1;
            }
            int size = this.f204317d.size();
            while (true) {
                i16 = -1;
                size--;
                if (size < 0) {
                    break;
                }
                CustomEmotionData customEmotionData = new CustomEmotionData();
                customEmotionData.uin = EmoticonFromGroupManager.this.f204311c.getCurrentUin();
                i3++;
                customEmotionData.emoId = i3;
                arrayList.add(customEmotionData);
            }
            int size2 = arrayList.size();
            while (i18 < size2) {
                final EmoticonFromGroupEntity emoticonFromGroupEntity = (EmoticonFromGroupEntity) this.f204317d.get(i18);
                final CustomEmotionData customEmotionData2 = (CustomEmotionData) arrayList.get(i18);
                int i28 = i18 + 1;
                if (EmoticonFromGroupManager.this.r(emoticonFromGroupEntity, i19)) {
                    QLog.d("EmoticonFromGroup_Manager", i17, "IMG_BIG_COMPRESS exist: uploadEmo=" + emoticonFromGroupEntity);
                    URLDrawable uRLDrawable = (URLDrawable) EmoticonFromGroupManager.this.j(emoticonFromGroupEntity, i19, i16, null);
                    if (uRLDrawable != null) {
                        EmoticonFromGroupManager.this.s(customEmotionData2, emoticonFromGroupEntity);
                        EmoticonFromGroupManager.this.B(iFavroamingDBManagerService, iFavroamingManagerService, customEmotionData2, uRLDrawable);
                    } else {
                        QLog.e("EmoticonFromGroup_Manager", i19, "get drawable failed: " + emoticonFromGroupEntity);
                    }
                } else {
                    QLog.d("EmoticonFromGroup_Manager", i17, "IMG_BIG_COMPRESS is not exist: uploadEmo=" + emoticonFromGroupEntity);
                    MsgElement msgElement = emoticonFromGroupEntity.msgElement;
                    if (msgElement != null && (msgRecord = emoticonFromGroupEntity.msgRecord) != null) {
                        h.a(PicSize.PIC_DOWNLOAD_ORI, msgRecord, msgElement, new Function1() { // from class: com.tencent.mobileqq.emosm.favroaming.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit b16;
                                b16 = EmoticonFromGroupManager.AnonymousClass5.this.b(emoticonFromGroupEntity, iFavroamingDBManagerService, iFavroamingManagerService, customEmotionData2, (FileTransNotifyInfo) obj);
                                return b16;
                            }
                        });
                    }
                }
                i18 = i28;
                i17 = 2;
                i19 = 1;
                i16 = -1;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    Object obj = message.obj;
                    if (obj != null) {
                        EmoticonFromGroupManager.this.c((EmoticonFromGroupEntity) obj);
                    } else {
                        QQToast.makeText(EmoticonFromGroupManager.this.f204312d, 1, R.string.f170070f0, 0).show(R.dimen.title_bar_height);
                    }
                }
            } else {
                QQToast.makeText(EmoticonFromGroupManager.this.f204312d, R.string.f170978be3, 0).show(R.dimen.title_bar_height);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements Comparator<String> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f204320d;

        c(Activity activity) {
            this.f204320d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            if (i3 == 1) {
                VasH5PayUtil.openClubPay(this.f204320d, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", EmoticonFromGroupManager.this.f204312d.getString(R.string.f173184hu3), "");
            }
        }
    }

    static {
        ThreadPoolParams threadPoolParams = new ThreadPoolParams();
        threadPoolParams.poolThreadName = "groupemostore_pool";
        threadPoolParams.corePoolsize = 2;
        threadPoolParams.maxPooolSize = 2;
        threadPoolParams.priority = 5;
        threadPoolParams.queue = new LinkedBlockingQueue();
        threadPoolParams.keepAliveTime = 10;
        f204308i = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
    }

    public EmoticonFromGroupManager() {
        this.f204309a = Arrays.asList(-2000, Integer.valueOf(MessageRecord.MSG_TYPE_MIX), -2006);
        this.f204310b = Arrays.asList(1, 3000);
        this.f204315g = new a();
        this.f204316h = new Handler(Looper.getMainLooper(), this.f204315g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(IFavroamingDBManagerService iFavroamingDBManagerService, IFavroamingManagerService iFavroamingManagerService, CustomEmotionData customEmotionData, URLDrawable uRLDrawable) {
        String q16 = q(uRLDrawable.getURL().toString());
        if (t(q16)) {
            return;
        }
        String x16 = x(q16);
        if (!"".equals(x16)) {
            customEmotionData.emoPath = x16;
            customEmotionData.md5 = q16;
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("EmoticonFromGroup_Manager", 4, "normal upload emo " + q16);
                }
                uRLDrawable.saveTo(x16);
                iFavroamingManagerService.syncUpload(customEmotionData);
                iFavroamingDBManagerService.insertCustomEmotion(customEmotionData);
            } catch (IOException e16) {
                e16.printStackTrace();
                QLog.d("EmoticonFromGroup_Manager", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(EmoticonFromGroupEntity emoticonFromGroupEntity, int i3) {
        String str;
        if (i3 == 1) {
            str = emoticonFromGroupEntity.bigURL;
        } else {
            str = emoticonFromGroupEntity.thumbURL;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(CustomEmotionData customEmotionData, EmoticonFromGroupEntity emoticonFromGroupEntity) {
        MsgElement msgElement;
        PicElement picElement;
        if (customEmotionData != null && emoticonFromGroupEntity != null && (msgElement = emoticonFromGroupEntity.msgElement) != null && (picElement = msgElement.picElement) != null && picElement.getEmojiMall() != null) {
            customEmotionData.jumpId = emoticonFromGroupEntity.msgElement.picElement.getEmojiMall().packageId;
        }
    }

    private String x(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return AppConstants.SDCARD_IMG_FAVORITE + DiySecureFileHelper.secureUin(this.f204311c.getCurrentAccountUin()) + str + ".jpg";
    }

    public String A(long j3) {
        String y16;
        Time time = new Time();
        time.set(j3);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        if (currentTimeMillis >= j3) {
            long j16 = currentTimeMillis - j3;
            if (0 >= j16) {
                return null;
            }
            if (time.year == time2.year) {
                int ceil = ((int) Math.ceil(j16 / 8.64E7d)) - 1;
                if (ceil == 0) {
                    y16 = HardCodeUtil.qqStr(R.string.m6r);
                } else if (1 == ceil) {
                    y16 = HardCodeUtil.qqStr(R.string.m6i);
                } else if (7 > ceil) {
                    switch (time.weekDay) {
                        case 0:
                            y16 = HardCodeUtil.qqStr(R.string.f171945m73);
                            break;
                        case 1:
                            y16 = HardCodeUtil.qqStr(R.string.m7q);
                            break;
                        case 2:
                            y16 = HardCodeUtil.qqStr(R.string.m6q);
                            break;
                        case 3:
                            y16 = HardCodeUtil.qqStr(R.string.f171946m74);
                            break;
                        case 4:
                            y16 = HardCodeUtil.qqStr(R.string.m6m);
                            break;
                        case 5:
                            y16 = HardCodeUtil.qqStr(R.string.m7_);
                            break;
                        case 6:
                            y16 = HardCodeUtil.qqStr(R.string.m7h);
                            break;
                        default:
                            return null;
                    }
                } else {
                    y16 = y(j3, 1);
                }
                return y16;
            }
            return y(j3, 0);
        }
        return y(j3, 0);
    }

    public boolean C(String str) {
        EmoticonFromGroupEntity emoticonFromGroupEntity;
        Iterator<EmoticonFromGroupEntity> it = u().iterator();
        while (true) {
            if (it.hasNext()) {
                emoticonFromGroupEntity = it.next();
                String fileMd5 = SecUtil.getFileMd5(new File(emoticonFromGroupEntity.bigURL).getAbsolutePath());
                if (str.equalsIgnoreCase(emoticonFromGroupEntity.md5) || str.equalsIgnoreCase(fileMd5)) {
                    if (emoticonFromGroupEntity.status != 0) {
                        break;
                    }
                }
            } else {
                emoticonFromGroupEntity = null;
                break;
            }
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = emoticonFromGroupEntity;
        this.f204316h.sendMessage(obtain);
        boolean z16 = true;
        if (this.f204313e.getCountOfSpare() < 1) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "isSuccess: " + z16);
        }
        return z16;
    }

    public void D(String str) {
        QLog.e("EmoticonFromGroup_Manager", 1, "save2WY From Old way");
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public Drawable a(Drawable drawable, int i3) {
        Bitmap.Config config;
        if (drawable != null && i3 >= 0) {
            int i16 = i3 * 2;
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i16, i16, config);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, i16, i16);
            drawable.draw(canvas);
            return new BitmapDrawable(BaseImageUtil.getCircleFaceBitmap(createBitmap, createBitmap.getWidth(), createBitmap.getHeight()));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public int b() {
        return ((this.f204312d.getResources().getDisplayMetrics().widthPixels - (ScreenUtil.dip2px(11.0f) * 2)) - (ScreenUtil.dip2px(2.0f) * 2)) / 3;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public boolean c(EmoticonFromGroupEntity emoticonFromGroupEntity) {
        int i3;
        c cVar;
        QQCustomDialog createCustomDialog;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.e("EmoticonFromGroup_Manager", 1, "activity is null.");
            return false;
        }
        if (this.f204313e.getCountOfSpare() < 1) {
            QLog.d("EmoticonFromGroup_Manager", 2, "onUploadPicByPreview slimit=1000 nlimit=500 max=" + FavEmoConstant.FAV_LOCAL_MAX_COUNT + " spare=" + this.f204313e.getCountOfSpare());
            int i16 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
            if (1000 == i16) {
                QQToast.makeText(this.f204312d, FavEmoConstant.getAddFavEmoOverLimitTips(), 0).show(R.dimen.title_bar_height);
                return false;
            }
            if (500 != i16 || (createCustomDialog = DialogUtil.createCustomDialog(topActivity, 0, HardCodeUtil.qqStr(R.string.m77), topActivity.getString(R.string.f170071f1), HardCodeUtil.qqStr(R.string.m75), HardCodeUtil.qqStr(R.string.m7s), cVar, (cVar = new c(topActivity)))) == null) {
                return false;
            }
            createCustomDialog.show();
            return false;
        }
        this.f204313e.decreaseCountOfSpare();
        if (emoticonFromGroupEntity.msgRecord != null) {
            EmojiMall emojiMall = emoticonFromGroupEntity.msgElement.getPicElement().getEmojiMall();
            if (emojiMall != null) {
                i3 = emojiMall.packageId;
            } else {
                i3 = 0;
            }
            ((IAIOEmotionAddApi) QRoute.api(IAIOEmotionAddApi.class)).addEmotion(this.f204312d, emoticonFromGroupEntity.bigURL, Integer.valueOf(i3));
            emoticonFromGroupEntity.status = 0;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public void d(List<EmoticonFromGroupEntity> list) {
        this.f204314f.clear();
        this.f204314f.addAll(list);
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public String e(String str, int i3, String str2) {
        return A(w(str, 2)) + str2 + "(" + i3 + ")";
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public Map<String, List<EmoticonFromGroupEntity>> f(List<EmoticonFromGroupEntity> list) {
        if (list != null && !list.isEmpty()) {
            TreeMap treeMap = new TreeMap(new b());
            for (EmoticonFromGroupEntity emoticonFromGroupEntity : list) {
                String z16 = z(emoticonFromGroupEntity.timestamp, 2);
                if (treeMap.containsKey(z16)) {
                    ((List) treeMap.get(z16)).add(emoticonFromGroupEntity);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(emoticonFromGroupEntity);
                    treeMap.put(z16, arrayList);
                }
            }
            return treeMap;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.4
            @Override // java.lang.Runnable
            public void run() {
                EmoticonFromGroupManager.this.f204313e.setCountOfSpare(FavEmoConstant.FAV_LOCAL_MAX_COUNT - EmoticonFromGroupManager.this.v());
            }
        }, 16, null, false);
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonFromGroup_Manager", 2, "init mEmoManager.mCountOfSpare:" + this.f204313e.getCountOfSpare() + " FAV_LOCAL_MAX_COUNT:" + FavEmoConstant.FAV_LOCAL_MAX_COUNT);
        }
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public boolean h(List<CustomEmotionData> list, EmoticonFromGroupEntity emoticonFromGroupEntity) {
        try {
            if (!list.isEmpty()) {
                if (emoticonFromGroupEntity.bigURL != null && emoticonFromGroupEntity.md5 != null) {
                    File file = new File(emoticonFromGroupEntity.bigURL);
                    String str = "";
                    if (file.exists()) {
                        str = SecUtil.getFileMd5(file.getAbsolutePath());
                    }
                    String str2 = emoticonFromGroupEntity.md5;
                    String str3 = AppConstants.SDCARD_IMG_FAVORITE + DiySecureFileHelper.secureUin(this.f204311c.getCurrentAccountUin()) + str + ".jpg";
                    for (CustomEmotionData customEmotionData : list) {
                        if (!str.equalsIgnoreCase(customEmotionData.md5) && !str2.equalsIgnoreCase(customEmotionData.md5) && !str3.equalsIgnoreCase(customEmotionData.emoPath)) {
                        }
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.d("EmoticonFromGroup_Manager", 1, e16, new Object[0]);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public void i(List<EmoticonFromGroupEntity> list) {
        if (!list.isEmpty()) {
            QQToast.makeText(this.f204312d, 2, R.string.aww, 0).show(R.dimen.title_bar_height);
        }
        f204308i.execute(new AnonymousClass5(list));
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.l
    public Drawable j(EmoticonFromGroupEntity emoticonFromGroupEntity, int i3, int i16, Drawable drawable) {
        URL url;
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (65537 == i3) {
                obtain.mRequestWidth = i16;
                obtain.mRequestHeight = i16;
                url = new URL(HippyBridge.URI_SCHEME_FILE + emoticonFromGroupEntity.thumbURL);
            } else if (1 == i3) {
                if (emoticonFromGroupEntity.gifImg) {
                    obtain.mPlayGifImage = true;
                }
                if (drawable != null) {
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                }
                url = new URL(HippyBridge.URI_SCHEME_FILE + emoticonFromGroupEntity.bigURL);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("EmoticonFromGroup_Manager", 2, "URLString get type error!");
                }
                url = null;
            }
            if (url != null) {
                URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
                MsgRecord msgRecord = emoticonFromGroupEntity.msgRecord;
                if (msgRecord != null) {
                    drawable2.setTag(msgRecord);
                }
                drawable2.downloadImediatly(true);
                return drawable2;
            }
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("EmoticonFromGroup_Manager", 2, "group emo new URL error!");
            }
            e16.printStackTrace();
        }
        return null;
    }

    public String q(String str) {
        if (str != null && !str.isEmpty() && AbsDownloader.hasFile(str)) {
            if (str.toLowerCase(Locale.US).startsWith("file")) {
                String str2 = null;
                try {
                    if (str.substring(0, 5).equalsIgnoreCase(HippyBridge.URI_SCHEME_FILE)) {
                        str2 = str.substring(5);
                    }
                } catch (IndexOutOfBoundsException e16) {
                    QLog.e("EmoticonFromGroup_Manager", 2, "caculateMD5 error:" + e16);
                }
                if (str2 != null) {
                    return SecUtil.getFileMd5(new File(str2).getAbsolutePath());
                }
                return "";
            }
            File file = AbsDownloader.getFile(str);
            if (file != null) {
                return SecUtil.getFileMd5(file.getAbsolutePath());
            }
            return "";
        }
        return "";
    }

    public boolean t(String str) {
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.f204311c.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "call getEmoticonDataList from EmoticonFromGroupManager.filterFavoriteEmoticonAfterDownload");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        ArrayList arrayList = new ArrayList();
        if (emoticonDataList != null && !emoticonDataList.isEmpty()) {
            for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                if (TextUtils.isEmpty(emoticonDataList.get(i3).RomaingType) || !"needDel".equals(emoticonDataList.get(i3).RomaingType)) {
                    arrayList.add(emoticonDataList.get(i3));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(((CustomEmotionData) it.next()).md5)) {
                if (QLog.isColorLevel()) {
                    QLog.i("EmoticonFromGroup_Manager", 2, "filterFavoriteEmoticonAfterDownload " + str);
                }
                return true;
            }
        }
        return false;
    }

    public List<EmoticonFromGroupEntity> u() {
        return this.f204314f;
    }

    public int v() {
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.f204311c.getRuntimeService(IFavroamingDBManagerService.class);
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from getFavEmoCount.");
        }
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        int i3 = 0;
        if (emoticonDataList != null && !emoticonDataList.isEmpty()) {
            int i16 = 0;
            while (i3 < emoticonDataList.size()) {
                if (TextUtils.isEmpty(emoticonDataList.get(i3).RomaingType) || !"needDel".equals(emoticonDataList.get(i3).RomaingType)) {
                    i16++;
                }
                i3++;
            }
            i3 = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "emoCount: " + i3);
        }
        return i3;
    }

    public long w(String str, int i3) {
        SimpleDateFormat simpleDateFormat;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    simpleDateFormat = null;
                } else {
                    simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                }
            } else {
                simpleDateFormat = new SimpleDateFormat("MM\u6708dd\u65e5");
            }
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        }
        if (simpleDateFormat == null) {
            return 0L;
        }
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public String y(long j3, int i3) {
        SimpleDateFormat simpleDateFormat;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    simpleDateFormat = null;
                } else {
                    simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                }
            } else {
                simpleDateFormat = new SimpleDateFormat("M\u6708d\u65e5");
            }
        } else {
            simpleDateFormat = new SimpleDateFormat("y\u5e74M\u6708d\u65e5");
        }
        if (simpleDateFormat == null) {
            return null;
        }
        return simpleDateFormat.format(new Date(j3));
    }

    public String z(long j3, int i3) {
        return y(j3 * 1000, i3);
    }

    public EmoticonFromGroupManager(BaseQQAppInterface baseQQAppInterface) {
        this.f204309a = Arrays.asList(-2000, Integer.valueOf(MessageRecord.MSG_TYPE_MIX), -2006);
        this.f204310b = Arrays.asList(1, 3000);
        this.f204315g = new a();
        this.f204316h = new Handler(Looper.getMainLooper(), this.f204315g);
        this.f204311c = baseQQAppInterface;
        this.f204312d = baseQQAppInterface.getApp();
        this.f204313e = (IEmoticonFromGroupDBManagerService) this.f204311c.getRuntimeService(IEmoticonFromGroupDBManagerService.class);
        this.f204314f = new CopyOnWriteArrayList();
    }
}
