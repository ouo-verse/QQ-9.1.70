package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.taf.jce.HexUtil;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ISmallEmoticonInfoService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmojiStickerManager {
    static IPatchRedirector $redirector_;
    public static boolean A;
    public static boolean B;
    public static int C;
    public static boolean D;
    public static String E;
    public static int F;
    public static long G;
    private static final EmojiStickerManager H;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f204577n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f204578o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f204579p;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f204580q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f204581r;

    /* renamed from: s, reason: collision with root package name */
    public static View f204582s;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f204583t;

    /* renamed from: u, reason: collision with root package name */
    public static int f204584u;

    /* renamed from: v, reason: collision with root package name */
    public static int f204585v;

    /* renamed from: w, reason: collision with root package name */
    public static int f204586w;

    /* renamed from: x, reason: collision with root package name */
    public static int f204587x;

    /* renamed from: y, reason: collision with root package name */
    public static int f204588y;

    /* renamed from: z, reason: collision with root package name */
    public static float f204589z;

    /* renamed from: a, reason: collision with root package name */
    public String f204590a;

    /* renamed from: b, reason: collision with root package name */
    public int f204591b;

    /* renamed from: c, reason: collision with root package name */
    public int f204592c;

    /* renamed from: d, reason: collision with root package name */
    public long f204593d;

    /* renamed from: e, reason: collision with root package name */
    public long f204594e;

    /* renamed from: f, reason: collision with root package name */
    public long f204595f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<Bundle> f204596g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap<Pair<Long, Long>, ArrayList<Long>> f204597h;

    /* renamed from: i, reason: collision with root package name */
    public LRULinkedHashMap<Pair<Long, Long>, ArrayList<Long>> f204598i;

    /* renamed from: j, reason: collision with root package name */
    public LRULinkedHashMap<Pair<Long, Long>, Boolean> f204599j;

    /* renamed from: k, reason: collision with root package name */
    public List<MessageRecord> f204600k;

    /* renamed from: l, reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f204601l;

    /* renamed from: m, reason: collision with root package name */
    private ColorDrawable f204602m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emoticon.EmojiStickerManager$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f204603d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f204604e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f204605f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f204606h;
        final /* synthetic */ EmojiStickerManager this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.emoticon.EmojiStickerManager$1$a */
        /* loaded from: classes12.dex */
        class a implements IDownLoadListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                }
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
            public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                    return;
                }
                QLog.i("EmojiStickerManager", 1, "onLoadFail: " + updateListenerParams);
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
            public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                    return;
                }
                QLog.i("EmojiStickerManager", 1, "onLoadSuccess: " + updateListenerParams);
                EmojiStickerManager.h();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                Iterator it = ((List) ((ArrayList) this.this$0.f204600k).clone()).iterator();
                while (true) {
                    z16 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    MessageRecord messageRecord = (MessageRecord) it.next();
                    StickerInfo m3 = EmojiStickerManager.m(messageRecord);
                    if (m3 != null && !m3.isDisplayed) {
                        m3.isDisplayed = true;
                        EmojiStickerManager.x(qQAppInterface, messageRecord, m3);
                    }
                }
                List<ChatMessage> list = this.f204603d;
                if (list == null) {
                    list = qQAppInterface.getMessageFacade().p1(this.f204604e, this.f204605f, this.f204606h);
                }
                for (ChatMessage chatMessage : list) {
                    StickerInfo m16 = EmojiStickerManager.m(chatMessage);
                    if (m16 != null && m16.isShown) {
                        EmojiStickerManager.x(qQAppInterface, chatMessage, m16);
                    }
                }
                Iterator<Bundle> it5 = this.this$0.f204596g.iterator();
                while (it5.hasNext()) {
                    Bundle next = it5.next();
                    int i3 = next.getInt(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                    if (i3 == 1) {
                        str = "2";
                    } else if (i3 == 3000) {
                        str = "3";
                    } else {
                        str = "1";
                    }
                    VasWebviewUtil.reportCommercialDrainage("", "Stick", next.getString("key"), str, 1, 0, 0, null, next.getString("ext1"), next.getString("ext2"));
                }
                this.this$0.f204596g.clear();
                File file = new File(EmojiStickerManager.i());
                if (file.exists()) {
                    String[] list2 = file.list();
                    if (list2 == null || list2.length <= 1) {
                        z16 = false;
                    }
                    EmojiStickerManager.B = z16;
                    return;
                }
                QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
                if (newBusiness != null) {
                    newBusiness.addDownLoadListener(VasUpdateConstants.SCID_STICKER_MATERIAL, new a());
                    newBusiness.startDownload(VasUpdateConstants.SCID_STICKER_MATERIAL);
                } else {
                    VasUpdateUtil.getFileFromLocal(qQAppInterface, 1004L, VasUpdateConstants.SCID_STICKER_MATERIAL, EmojiStickerManager.i() + "emojiStickerGuideZip_v2.zip", true, null);
                }
                EmojiStickerManager.B = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends AsyncTask<Void, Void, Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f204608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MessengerService f204609b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ URLDrawable f204610c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f204611d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PicMessageExtraData f204612e;

        a(Bundle bundle, MessengerService messengerService, URLDrawable uRLDrawable, QQAppInterface qQAppInterface, PicMessageExtraData picMessageExtraData) {
            this.f204608a = bundle;
            this.f204609b = messengerService;
            this.f204610c = uRLDrawable;
            this.f204611d = qQAppInterface;
            this.f204612e = picMessageExtraData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bundle, messengerService, uRLDrawable, qQAppInterface, picMessageExtraData);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            String str;
            boolean z16;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) voidArr);
            }
            if (this.f204610c.getStatus() != 1) {
                this.f204610c.downloadImediatly(false);
            }
            URLDrawable.removeMemoryCacheByUrl(this.f204610c.getURL().toString());
            CustomEmotionData j3 = EmojiStickerManager.j(this.f204611d, ((MessageForPic) this.f204610c.getTag()).path);
            if (j3 != null) {
                com.tencent.mobileqq.activity.aio.photo.c.k(this.f204611d, null, j3);
                return 2;
            }
            String url = this.f204610c.getURL().toString();
            if (!AbsDownloader.hasFile(url)) {
                return 1;
            }
            File file = AbsDownloader.getFile(url);
            if (file != null) {
                str = SecUtil.getFileMd5(file.getAbsolutePath());
            } else {
                str = null;
            }
            if (str != null) {
                String str3 = "";
                if (!"".equals(str)) {
                    StringBuilder sb5 = new StringBuilder();
                    String str4 = AppConstants.SDCARD_IMG_FAVORITE;
                    sb5.append(str4);
                    sb5.append(".nomedia");
                    FileUtils.createFileIfNotExits(sb5.toString());
                    String currentAccountUin = this.f204611d.getCurrentAccountUin();
                    PicMessageExtraData picMessageExtraData = this.f204612e;
                    if (picMessageExtraData != null && picMessageExtraData.isDiyDouTu()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("_diydoutu@");
                        if (TextUtils.isEmpty(this.f204612e.emojiId)) {
                            str2 = "0";
                        } else {
                            str2 = this.f204612e.emojiId;
                        }
                        sb6.append(str2);
                        str3 = sb6.toString();
                    }
                    String str5 = str4 + DiySecureFileHelper.secureUin(currentAccountUin) + str + str3 + ".jpg";
                    try {
                        this.f204610c.saveTo(str5);
                        return Integer.valueOf(EmojiStickerManager.c(this.f204611d, str5, null, this.f204612e));
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        QLog.d("EmojiStickerManager", 1, e16, new Object[0]);
                        return 1;
                    }
                }
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                return;
            }
            if (num.intValue() == 0) {
                i3 = 0;
            } else if (num.intValue() != 2 && num.intValue() == 1) {
                i3 = -2;
            } else {
                i3 = -1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("result", i3);
            this.f204608a.putBundle("response", bundle);
            this.f204609b.J(this.f204608a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Drawable f204613a;

        /* renamed from: b, reason: collision with root package name */
        public int f204614b;

        /* renamed from: c, reason: collision with root package name */
        public int f204615c;

        /* renamed from: d, reason: collision with root package name */
        public int f204616d;

        /* renamed from: e, reason: collision with root package name */
        public int f204617e;

        /* renamed from: f, reason: collision with root package name */
        public double f204618f;

        /* renamed from: g, reason: collision with root package name */
        public int f204619g;

        /* renamed from: h, reason: collision with root package name */
        public int f204620h;

        /* renamed from: i, reason: collision with root package name */
        public String f204621i;

        /* renamed from: j, reason: collision with root package name */
        public int f204622j;

        /* renamed from: k, reason: collision with root package name */
        public int f204623k;

        /* renamed from: l, reason: collision with root package name */
        public float f204624l;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f204619g = 0;
            this.f204620h = 0;
            this.f204622j = 0;
            this.f204623k = 0;
            this.f204624l = 1.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void onResult(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71632);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f204577n = false;
        f204578o = false;
        f204579p = false;
        f204580q = false;
        f204581r = false;
        f204582s = null;
        f204583t = false;
        f204584u = 1;
        f204585v = 0;
        f204586w = 1;
        f204587x = 20;
        f204588y = 10;
        f204589z = 0.01f;
        A = false;
        B = false;
        C = 0;
        D = false;
        E = "";
        F = -1;
        G = 0L;
        H = new EmojiStickerManager();
    }

    EmojiStickerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f204590a = "";
        this.f204591b = 0;
        this.f204592c = Integer.MIN_VALUE;
        this.f204593d = Long.MIN_VALUE;
        this.f204594e = Long.MIN_VALUE;
        this.f204595f = Long.MIN_VALUE;
        this.f204596g = new ArrayList<>();
        this.f204597h = new ConcurrentHashMap<>();
        this.f204598i = new LRULinkedHashMap<>(64);
        this.f204599j = new LRULinkedHashMap<>(64);
        this.f204600k = new ArrayList();
        this.f204601l = new ConcurrentHashMap<>();
        this.f204602m = new ColorDrawable();
    }

    public static void b(Context context, QQAppInterface qQAppInterface, URLDrawable uRLDrawable, String str, PicMessageExtraData picMessageExtraData, MessengerService messengerService, Bundle bundle) {
        new a(bundle, messengerService, uRLDrawable, qQAppInterface, picMessageExtraData).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(QQAppInterface qQAppInterface, String str, StructMsgForImageShare structMsgForImageShare, PicMessageExtraData picMessageExtraData) {
        int i3;
        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            int i16 = 0;
            i3 = 1;
            for (int i17 = 0; i17 < emoticonDataList.size(); i17++) {
                if (TextUtils.isEmpty(emoticonDataList.get(i17).RomaingType) || !"needDel".equals(emoticonDataList.get(i17).RomaingType)) {
                    i16++;
                }
                int i18 = emoticonDataList.get(i17).emoId;
                if (str != null && str.equals(emoticonDataList.get(i17).emoPath)) {
                    r(qQAppInterface, structMsgForImageShare, emoticonDataList.get(i17));
                    return 2;
                }
                if (bytes2HexStr != null && emoticonDataList.get(i17).md5 != null && bytes2HexStr.equals(emoticonDataList.get(i17).md5)) {
                    r(qQAppInterface, structMsgForImageShare, emoticonDataList.get(i17));
                    if (!"needDel".equals(emoticonDataList.get(i17).RomaingType)) {
                        return 2;
                    }
                    iFavroamingDBManagerService.updateDeletedEmoticon(emoticonDataList.get(i17), i17);
                    MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
                    if (handler != null) {
                        handler.obtainMessage(10).sendToTarget();
                    }
                    return 0;
                }
                if (i3 < i18) {
                    i3 = i18;
                }
            }
            if (i16 >= FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                return 3;
            }
        } else {
            i3 = 1;
        }
        CustomEmotionData customEmotionData = new CustomEmotionData();
        customEmotionData.uin = qQAppInterface.getCurrentAccountUin();
        customEmotionData.emoId = i3 + 1;
        customEmotionData.emoPath = str;
        customEmotionData.md5 = bytes2HexStr;
        if (picMessageExtraData != null && picMessageExtraData.isDiyDouTu()) {
            customEmotionData.eId = picMessageExtraData.emojiPkgId;
        }
        iFavroamingDBManagerService.insertCustomEmotion(customEmotionData);
        if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY)) {
            ReportController.o(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
        }
        q(qQAppInterface, structMsgForImageShare, customEmotionData);
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) qQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        if (iFavroamingManagerService != null) {
            iFavroamingManagerService.syncUpload(customEmotionData);
        }
        return 0;
    }

    public static void e(MessageRecord messageRecord, AppInterface appInterface) {
        MessageRecord messageRecord2;
        List<MessageRecord> p16;
        if (messageRecord.istroop != 0) {
            StickerInfo m3 = m(messageRecord);
            if (m3 != null) {
                Pair<Long, Long> pair = new Pair<>(Long.valueOf(m3.hostMsgSeq), 0L);
                boolean containsKey = k().f204599j.containsKey(pair);
                if (!containsKey && (p16 = ((QQAppInterface) appInterface).getMessageProxy(messageRecord.istroop).p(messageRecord.frienduin, messageRecord.istroop)) != null && p16.size() > 0) {
                    for (int size = p16.size() - 1; size >= 0; size--) {
                        messageRecord2 = p16.get(size);
                        if (messageRecord2.shmsgseq == ((Long) pair.first).longValue() && u(messageRecord2)) {
                            break;
                        }
                    }
                }
                messageRecord2 = null;
                if ((containsKey || (messageRecord2 != null && messageRecord2.msgtype == -2006)) && messageRecord2 != null) {
                    k().f204599j.put(pair, Boolean.TRUE);
                }
            }
        } else {
            StickerInfo m16 = m(messageRecord);
            if (m16 != null) {
                m16.hostMsgSeq = (short) m16.hostMsgSeq;
                if (messageRecord instanceof MessageForMarketFace) {
                    MessageForMarketFace messageForMarketFace = (MessageForMarketFace) messageRecord;
                    MarkFaceMessage markFaceMessage = messageForMarketFace.mMarkFaceMessage;
                    if (markFaceMessage != null) {
                        markFaceMessage.stickerInfo = m16;
                    }
                    try {
                        messageForMarketFace.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } else if (messageRecord instanceof MessageForText) {
                    MessageForText messageForText = (MessageForText) messageRecord;
                    messageForText.stickerInfo = m16;
                    messageForText.saveExtInfoToExtStr("sticker_info", m16.toJsonString());
                } else if (messageRecord instanceof MessageForPic) {
                    MessageForPic messageForPic = (MessageForPic) messageRecord;
                    messageForPic.stickerInfo = m16;
                    messageForPic.saveExtInfoToExtStr("sticker_info", m16.toJsonString());
                }
            }
        }
        k().d(messageRecord);
    }

    public static boolean g() {
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("is_sticker_enable_" + currentAccountUin, 0);
        QLog.i("EmojiStickerManager", 1, "enableEmojiSticker=" + decodeInt);
        if (decodeInt == 0) {
            return false;
        }
        return true;
    }

    public static void h() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.EmojiStickerManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
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
                    QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, start");
                }
                String i3 = EmojiStickerManager.i();
                if (QLog.isColorLevel()) {
                    QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, rootPath = " + i3);
                }
                File file = new File(i3);
                if (file.exists()) {
                    String[] list = file.list();
                    if (list != null && list.length > 1) {
                        if (QLog.isColorLevel()) {
                            QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, list.length =  " + list.length);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, need to extract  ");
                    }
                    try {
                        FileUtils.uncompressZip(i3 + VasUpdateConstants.SCID_STICKER_MATERIAL + ".zip", i3, false);
                    } catch (IOException e16) {
                        QLog.e("EmojiStickerManager", 1, "extractStickerMaterial uncompressZip error = " + e16);
                    } catch (OutOfMemoryError e17) {
                        QLog.e("EmojiStickerManager", 1, "extractStickerMaterial uncompressZip error = " + e17);
                    }
                }
            }
        }, 5, null, false);
    }

    public static String i() {
        QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
        if (newBusiness != null) {
            return newBusiness.getSavePath(VasUpdateConstants.SCID_STICKER_MATERIAL);
        }
        try {
            return BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile() + File.separator;
        } catch (Exception unused) {
            return BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile() + File.separator;
        }
    }

    public static CustomEmotionData j(QQAppInterface qQAppInterface, String str) {
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) qQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                if (str != null && str.equals(emoticonDataList.get(i3).emoPath)) {
                    CustomEmotionData customEmotionData = emoticonDataList.get(i3);
                    iFavroamingDBManagerService.updateDeletedEmoticon(customEmotionData, i3);
                    return customEmotionData;
                }
            }
        }
        return null;
    }

    public static EmojiStickerManager k() {
        return H;
    }

    public static Pair<Long, Long> l(MessageRecord messageRecord) {
        com.tencent.mobileqq.graytip.g gVar;
        if (messageRecord == null) {
            return null;
        }
        int i3 = messageRecord.msgtype;
        if (i3 == -2058) {
            StickerInfo m3 = m(messageRecord);
            if (m3 == null) {
                return null;
            }
            if (messageRecord.istroop == 0) {
                return new Pair<>(Long.valueOf(m3.hostMsgSeq), Long.valueOf(m3.hostMsgUid));
            }
            return new Pair<>(Long.valueOf(m3.hostMsgSeq), 0L);
        }
        if (i3 == -2006) {
            if (messageRecord.istroop == 0) {
                return new Pair<>(Long.valueOf(messageRecord.shmsgseq), Long.valueOf(messageRecord.msgUid));
            }
            return new Pair<>(Long.valueOf(messageRecord.shmsgseq), 0L);
        }
        if (u(messageRecord)) {
            if (messageRecord.istroop == 0) {
                return new Pair<>(Long.valueOf(messageRecord.shmsgseq), Long.valueOf(messageRecord.msgUid));
            }
            return new Pair<>(Long.valueOf(messageRecord.shmsgseq), 0L);
        }
        if (!(messageRecord instanceof MessageForUniteGrayTip) || (gVar = ((MessageForUniteGrayTip) messageRecord).tipParam) == null || gVar.f213685h != 1) {
            return null;
        }
        if (messageRecord.istroop == 0) {
            return new Pair<>(Long.valueOf(messageRecord.shmsgseq), Long.valueOf(messageRecord.msgUid));
        }
        return new Pair<>(Long.valueOf(messageRecord.shmsgseq), 0L);
    }

    public static StickerInfo m(MessageRecord messageRecord) {
        if (messageRecord != null && messageRecord.msgtype == -2058) {
            if (messageRecord instanceof MessageForMarketFace) {
                MarkFaceMessage markFaceMessage = ((MessageForMarketFace) messageRecord).mMarkFaceMessage;
                if (markFaceMessage != null) {
                    return markFaceMessage.stickerInfo;
                }
                return null;
            }
            if ((messageRecord instanceof MessageForText) || (messageRecord instanceof MessageForPic)) {
                StickerInfo stickerInfo = (StickerInfo) messageRecord.stickerInfo;
                if (stickerInfo != null) {
                    return stickerInfo;
                }
                String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sticker_info");
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    StickerInfo transformFromJson = StickerInfo.transformFromJson(extInfoFromExtStr);
                    messageRecord.stickerInfo = transformFromJson;
                    return transformFromJson;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static QQText o(QQAppInterface qQAppInterface, Message message, MsgSummary msgSummary) {
        String str;
        StickerInfo transformFromJson;
        if (qQAppInterface != null && message != null) {
            HardCodeUtil.qqStr(R.string.m67);
            String extInfoFromExtStr = message.getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr) && (transformFromJson = StickerInfo.transformFromJson(extInfoFromExtStr)) != null) {
                str = transformFromJson.f204678msg;
                if (f204583t) {
                    if (message.senderuin.equals(qQAppInterface.getCurrentAccountUin())) {
                        str = HardCodeUtil.qqStr(R.string.m68) + str;
                        msgSummary.mEmojiFlag = 1;
                    } else {
                        str = HardCodeUtil.qqStr(R.string.m6a) + str;
                        msgSummary.mEmojiFlag = 0;
                    }
                }
            } else {
                str = "";
            }
            return new QQText(str, 3, 16);
        }
        return null;
    }

    public static QQText p(Message message) {
        StickerInfo transformFromJson;
        if (message == null) {
            return null;
        }
        String extInfoFromExtStr = message.getExtInfoFromExtStr("sticker_info");
        if (TextUtils.isEmpty(extInfoFromExtStr) || (transformFromJson = StickerInfo.transformFromJson(extInfoFromExtStr)) == null) {
            return null;
        }
        return new QQText(transformFromJson.f204678msg, 3, 16);
    }

    private static void q(QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, CustomEmotionData customEmotionData) {
        String actionDataFromStructMsg = ((IPictureBusinessApi) QRoute.api(IPictureBusinessApi.class)).getActionDataFromStructMsg(structMsgForImageShare);
        if (qQAppInterface != null && !TextUtils.isEmpty(actionDataFromStructMsg) && actionDataFromStructMsg.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) && customEmotionData != null && !TextUtils.isEmpty(customEmotionData.md5)) {
            IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) qQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
            VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
            vipComicFavorEmoStructMsgInfo.picMd5 = customEmotionData.md5;
            vipComicFavorEmoStructMsgInfo.actionData = actionDataFromStructMsg;
            ArrayList arrayList = new ArrayList();
            arrayList.add(vipComicFavorEmoStructMsgInfo);
            iVipComicMqqManagerService.setMyComicEmoticon(arrayList, true);
            if (QLog.isColorLevel()) {
                QLog.d("EmojiStickerManager", 2, "handleComicStructMsg , emoStructMsgInfo = " + vipComicFavorEmoStructMsgInfo);
            }
        }
    }

    private static void r(QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, CustomEmotionData customEmotionData) {
        String actionDataFromStructMsg = ((IPictureBusinessApi) QRoute.api(IPictureBusinessApi.class)).getActionDataFromStructMsg(structMsgForImageShare);
        if (qQAppInterface != null && !TextUtils.isEmpty(actionDataFromStructMsg) && actionDataFromStructMsg.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) && customEmotionData != null && !TextUtils.isEmpty(customEmotionData.md5)) {
            IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) qQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
            VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
            String str = customEmotionData.md5;
            vipComicFavorEmoStructMsgInfo.picMd5 = str;
            vipComicFavorEmoStructMsgInfo.actionData = actionDataFromStructMsg;
            if (!vipComicFavorEmoStructMsgInfo.equals(iVipComicMqqManagerService.getComicStructInfo(str))) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(vipComicFavorEmoStructMsgInfo);
                iVipComicMqqManagerService.setMyComicEmoticon(arrayList, true);
                if (QLog.isColorLevel()) {
                    QLog.d("EmojiStickerManager", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + vipComicFavorEmoStructMsgInfo);
                }
            }
        }
    }

    public static boolean t(MessageRecord messageRecord) {
        if (!(messageRecord instanceof MessageForMarketFace) && ((!(messageRecord instanceof MessageForText) || messageRecord.msgtype != -1000) && !(messageRecord instanceof MessageForPic))) {
            return false;
        }
        return true;
    }

    public static boolean u(MessageRecord messageRecord) {
        int i3 = messageRecord.msgtype;
        boolean isRedPacketMsg = ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(messageRecord);
        if (i3 != -1000 && i3 != -2011 && i3 != -2039 && ((i3 != -2025 || !isRedPacketMsg) && i3 != -2007 && i3 != -2000 && i3 != -2002 && i3 != -2022 && i3 != -1035 && i3 != -1049)) {
            return false;
        }
        return true;
    }

    public static void x(QQAppInterface qQAppInterface, MessageRecord messageRecord, StickerInfo stickerInfo) {
        if (qQAppInterface != null && stickerInfo != null) {
            try {
                if (messageRecord instanceof MessageForMarketFace) {
                    MessageForMarketFace messageForMarketFace = (MessageForMarketFace) messageRecord;
                    MarkFaceMessage markFaceMessage = messageForMarketFace.mMarkFaceMessage;
                    if (markFaceMessage != null) {
                        markFaceMessage.stickerInfo = stickerInfo;
                    }
                    messageForMarketFace.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
                    qQAppInterface.getMessageFacade().Y0(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, messageRecord.msgData);
                    return;
                }
                if ((messageRecord instanceof MessageForText) || (messageRecord instanceof MessageForPic)) {
                    messageRecord.stickerInfo = stickerInfo;
                    messageRecord.saveExtInfoToExtStr("sticker_info", stickerInfo.toJsonString());
                    qQAppInterface.getMessageFacade().a1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                }
            } catch (Exception e16) {
                QLog.e("EmojiStickerManager", 1, "save sticker shown status error e = " + e16);
            }
        }
    }

    private void y(Messenger messenger, boolean z16) {
        int i3;
        int i16;
        if (messenger != null) {
            try {
                android.os.Message obtain = android.os.Message.obtain((Handler) null, 4);
                Bundle bundle = new Bundle();
                bundle.putString("cmd", "emojiStickerRecall");
                bundle.putString("callbackid", E);
                bundle.putInt("respkey", F);
                Bundle bundle2 = new Bundle();
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = -2;
                }
                bundle2.putInt("result", i3);
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    bundle2.putString("QQ", ((QQAppInterface) runtime).getCurrentUin());
                }
                int i17 = this.f204591b;
                if (i17 == 0) {
                    i16 = 1;
                } else if (i17 == 1) {
                    i16 = 2;
                } else if (i17 == 3000) {
                    i16 = 3;
                } else {
                    i16 = -1;
                }
                bundle2.putInt("chatType", i16);
                bundle.putBundle("response", bundle2);
                obtain.setData(bundle);
                messenger.send(obtain);
            } catch (RemoteException e16) {
                QLog.e("EmojiStickerManager", 1, "sendEmojiStickerRecallResponse e =" + e16);
            }
        }
        D = false;
    }

    public static void z(MessageRecord messageRecord, StickerInfo stickerInfo) {
        StickerInfo transformFromJson;
        String qqStr;
        if (messageRecord != null && t(messageRecord)) {
            try {
                int i3 = messageRecord.msgtype;
                if (stickerInfo != null) {
                    stickerInfo.originMsgType = i3;
                }
                if (i3 != -2007) {
                    if (i3 == -2000 || i3 == -1000) {
                        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sticker_info");
                        if (!TextUtils.isEmpty(extInfoFromExtStr) && (transformFromJson = StickerInfo.transformFromJson(extInfoFromExtStr)) != null) {
                            transformFromJson.originMsgType = i3;
                            if (i3 == -1000) {
                                qqStr = messageRecord.f203106msg;
                            } else {
                                qqStr = HardCodeUtil.qqStr(R.string.m6b);
                            }
                            transformFromJson.f204678msg = qqStr;
                            messageRecord.stickerInfo = transformFromJson;
                            messageRecord.saveExtInfoToExtStr("sticker_info", transformFromJson.toJsonString());
                        }
                    }
                } else {
                    MessageForMarketFace messageForMarketFace = (MessageForMarketFace) messageRecord;
                    MarkFaceMessage markFaceMessage = messageForMarketFace.mMarkFaceMessage;
                    if (markFaceMessage != null) {
                        markFaceMessage.stickerInfo = stickerInfo;
                    }
                    messageForMarketFace.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
                }
                messageRecord.extLong |= 4;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(QQBrowserActivity.KEY_MSG_TYPE, i3);
                messageRecord.saveExtInfoToExtStr("Emoji_Sticker_Info", jSONObject.toString());
                if (f204583t) {
                    messageRecord.msgtype = MessageRecord.MSG_TYPE_STICKER_MSG;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EmojiStickerManager", 2, "", e16);
                }
            }
        }
    }

    public void d(MessageRecord messageRecord) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord != null && messageRecord.msgtype == -2058 && f204583t && m(messageRecord) != null) {
            if (messageRecord.frienduin.equalsIgnoreCase(this.f204590a) && this.f204591b == messageRecord.istroop) {
                this.f204592c = 0;
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    this.f204593d = ((QQAppInterface) runtime).getConversationFacade().C(this.f204590a, this.f204591b);
                }
            }
            Pair<Long, Long> l3 = l(messageRecord);
            if (l3 != null) {
                ArrayList<Long> arrayList = this.f204598i.get(l3);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.contains(Long.valueOf(messageRecord.uniseq)) && arrayList.size() < QVipStickerProcessor.sStickerMaxShowNum) {
                    arrayList.add(Long.valueOf(messageRecord.uniseq));
                }
                int i3 = messageRecord.istroop;
                if (i3 == 1) {
                    str = "2";
                } else if (i3 == 3000) {
                    str = "3";
                } else {
                    str = "1";
                }
                VasWebviewUtil.reportCommercialDrainage("", "Stick", "Receive", str, 1, 0, 0, null, "", "");
                this.f204598i.put(l3, arrayList);
            }
        }
    }

    public void f(Messenger messenger, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, messenger, Boolean.valueOf(z16));
        } else if (D) {
            y(messenger, z16);
        }
    }

    public List<Long> n(MessageRecord messageRecord) {
        int i3;
        Pair<Long, Long> l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord);
        }
        if (!f204583t || messageRecord == null || messageRecord.shmsgseq == 0 || (i3 = messageRecord.extraflag) == 32772 || i3 == 32768 || messageRecord.isMultiMsg || messageRecord.isReMultiMsg || (l3 = l(messageRecord)) == null) {
            return null;
        }
        return this.f204597h.get(l3);
    }

    public void s(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord != null && messageRecord.msgtype == -2058 && f204583t) {
            StickerInfo m3 = m(messageRecord);
            Pair<Long, Long> l3 = l(messageRecord);
            if (m3 != null && l3 != null) {
                ArrayList<Long> arrayList = this.f204597h.get(l3);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.contains(Long.valueOf(messageRecord.uniseq))) {
                    arrayList.add(Long.valueOf(messageRecord.uniseq));
                }
                this.f204597h.put(l3, arrayList);
            }
        }
    }

    public EmoticonInfo v(String str) {
        int codePointAt;
        int i3;
        int doubleEmoji;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (EmoticonInfo) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            int length2 = str.length();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            for (int i16 = 0; i16 < length; i16++) {
                int codePointAt2 = sb5.codePointAt(i16);
                if (codePointAt2 == 20 && i16 < length2 - 1) {
                    return w(i16, length2, sb5);
                }
                int singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt2);
                if (codePointAt2 > 65535) {
                    int i17 = i16 + 2;
                    if (length2 > i17) {
                        codePointAt = sb5.codePointAt(i17);
                    }
                    codePointAt = -1;
                } else {
                    int i18 = i16 + 1;
                    if (length2 > i18) {
                        codePointAt = sb5.codePointAt(i18);
                        if (codePointAt == 65039 && length2 > (i3 = i16 + 2)) {
                            codePointAt = sb5.codePointAt(i3);
                        }
                    }
                    codePointAt = -1;
                }
                boolean isSkinEmoji = EmotcationConstants.isSkinEmoji(codePointAt);
                if ((singleEmoji == -1 || isSkinEmoji) && (doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt)) != -1) {
                    singleEmoji = doubleEmoji;
                }
                int i19 = singleEmoji;
                if (i19 != -1) {
                    return new SystemAndEmojiEmoticonInfo(7, 2, i19, "", false);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected EmoticonInfo w(int i3, int i16, StringBuilder sb5) {
        int i17;
        boolean z16;
        int i18;
        IEmoticonManagerService d16;
        EmoticonPackage syncFindEmoticonPackageById;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (EmoticonInfo) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), sb5);
        }
        int i26 = i3 + 1;
        char charAt = sb5.charAt(i26);
        if (charAt >= '\u00ff' && (i17 = i3 + 4) < i16) {
            char[] cArr = new char[4];
            cArr[0] = sb5.charAt(i17);
            cArr[1] = sb5.charAt(i3 + 3);
            cArr[2] = sb5.charAt(i3 + 2);
            cArr[3] = sb5.charAt(i26);
            for (int i27 = 0; i27 < 3; i27++) {
                char c16 = cArr[i27];
                if (c16 == '\u00fa') {
                    cArr[i27] = '\n';
                } else if (c16 == '\u00fe') {
                    cArr[i27] = '\r';
                }
            }
            if (charAt == '\u01ff') {
                z16 = true;
            } else {
                z16 = false;
            }
            ISmallEmoticonInfo createSmallEmoticonInfo = ((ISmallEmoticonInfoService) QRoute.api(ISmallEmoticonInfoService.class)).createSmallEmoticonInfo(BaseApplicationImpl.getApplication().getRuntime().getAccount());
            Emoticon emoticon = new Emoticon();
            int[] r16 = com.tencent.mobileqq.emosm.e.r(cArr);
            if (r16 != null && r16.length == 2) {
                int i28 = r16[0];
                i19 = r16[1];
                i18 = i28;
            } else {
                i18 = 0;
            }
            emoticon.eId = String.valueOf(i19);
            emoticon.epId = String.valueOf(i18);
            emoticon.jobType = 3;
            createSmallEmoticonInfo.setEmoticon(emoticon);
            if (z16 || (d16 = com.tencent.mobileqq.core.util.a.d()) == null || (syncFindEmoticonPackageById = d16.syncFindEmoticonPackageById(String.valueOf(i18))) == null || syncFindEmoticonPackageById.isAPNG != 2) {
                z17 = z16;
            }
            createSmallEmoticonInfo.setIsAPNG(z17);
            return (EmoticonInfo) createSmallEmoticonInfo;
        }
        if (charAt == '\u00fa') {
            return new SystemAndEmojiEmoticonInfo(7, 1, 10, "", false);
        }
        return new SystemAndEmojiEmoticonInfo(7, 1, charAt, "", false);
    }
}
