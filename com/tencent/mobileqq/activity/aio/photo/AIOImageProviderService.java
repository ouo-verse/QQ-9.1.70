package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.aio.photo.h;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ax;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.messageclean.ag;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ab;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.shortvideo.y;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import cooperation.weiyun.WeiyunAIOUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class AIOImageProviderService extends h.a {
    public static final HashMap<String, AIOImageProviderService> X = new HashMap<>();
    boolean C;
    long D;
    protected final List<ChatMessage> E;
    protected final List<AIORichMediaData> F;
    protected volatile boolean G;
    protected volatile boolean H;
    protected long I;
    protected long J;
    protected int K;
    protected long L;
    protected int M;
    int N;
    WeakReferenceHandler P;
    WeakReference<BaseActivity> Q;
    private IncreasinglyLoadMediaTask R;
    FMObserver S;
    private com.tencent.mobileqq.app.c T;
    private HashMap<String, MessageForTroopFile> U;
    e V;
    ArrayList<Long> W;

    /* renamed from: e, reason: collision with root package name */
    protected String f179588e;

    /* renamed from: f, reason: collision with root package name */
    protected String f179589f;

    /* renamed from: h, reason: collision with root package name */
    int f179590h;

    /* renamed from: i, reason: collision with root package name */
    int f179591i;

    /* renamed from: m, reason: collision with root package name */
    boolean f179592m;

    /* loaded from: classes10.dex */
    class IncreasinglyLoadMediaTask implements Runnable {
        IncreasinglyLoadMediaTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:77:0x01e8, code lost:
        
            r23.this$0.H = false;
            r23.this$0.M5();
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01f6, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void run() {
            AIOImageProviderService aIOImageProviderService;
            AIOImageProviderService aIOImageProviderService2;
            long j3;
            List<MessageRecord> changeFileMessageRecordList;
            List<MessageRecord> O;
            char c16 = 2;
            try {
                try {
                    try {
                        AIOImageProviderService.this.H = true;
                        aIOImageProviderService2 = AIOImageProviderService.this;
                    } catch (OutOfMemoryError e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOImageProviderService", 2, "out of memory", e16);
                        }
                        aIOImageProviderService = AIOImageProviderService.this;
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOImageProviderService", 2, "IncreasinglyLoadMediaTask exception = " + e17.getMessage());
                    }
                    aIOImageProviderService = AIOImageProviderService.this;
                }
                if (aIOImageProviderService2.M < 60) {
                    aIOImageProviderService2.H = false;
                    AIOImageProviderService.this.M5();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] start");
                }
                AIOImageProviderService aIOImageProviderService3 = AIOImageProviderService.this;
                if (aIOImageProviderService3.f179747d == null) {
                    aIOImageProviderService3.getClass();
                    AIOImageProviderService.this.H = false;
                    AIOImageProviderService.this.M5();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    AIOImageProviderService aIOImageProviderService4 = AIOImageProviderService.this;
                    if (!aIOImageProviderService4.f179592m) {
                        if (aIOImageProviderService4.f179589f == null) {
                            aIOImageProviderService4.H = false;
                            AIOImageProviderService.this.M5();
                            return;
                        }
                        int[] iArr = new int[9];
                        iArr[0] = -20000;
                        iArr[1] = -2000;
                        iArr[c16] = -1035;
                        iArr[3] = -2011;
                        iArr[4] = -2022;
                        iArr[5] = -2005;
                        iArr[6] = -2017;
                        iArr[7] = -2071;
                        iArr[8] = -3017;
                        if (!aIOImageProviderService4.G) {
                            changeFileMessageRecordList = AIOImageProviderService.this.s5(iArr);
                            j3 = currentTimeMillis;
                        } else {
                            if (!ao.u(AIOImageProviderService.this.f179590h)) {
                                AIOImageProviderService aIOImageProviderService5 = AIOImageProviderService.this;
                                if (aIOImageProviderService5.f179590h != 10014) {
                                    QQMessageFacade messageFacade = aIOImageProviderService5.x5().getMessageFacade();
                                    AIOImageProviderService aIOImageProviderService6 = AIOImageProviderService.this;
                                    j3 = currentTimeMillis;
                                    O = messageFacade.O(aIOImageProviderService6.f179589f, aIOImageProviderService6.f179590h, aIOImageProviderService6.I, aIOImageProviderService6.K, aIOImageProviderService6.L, iArr, 60);
                                    changeFileMessageRecordList = O;
                                    AIOImageProviderService.this.M = changeFileMessageRecordList.size();
                                    AIOImageProviderService.this.N++;
                                }
                            }
                            j3 = currentTimeMillis;
                            AIOImageProviderService aIOImageProviderService7 = AIOImageProviderService.this;
                            aIOImageProviderService7.J--;
                            QQMessageFacade messageFacade2 = aIOImageProviderService7.x5().getMessageFacade();
                            AIOImageProviderService aIOImageProviderService8 = AIOImageProviderService.this;
                            O = messageFacade2.O(aIOImageProviderService8.f179589f, aIOImageProviderService8.f179590h, aIOImageProviderService8.I, aIOImageProviderService8.K, aIOImageProviderService8.J, iArr, 60);
                            changeFileMessageRecordList = O;
                            AIOImageProviderService.this.M = changeFileMessageRecordList.size();
                            AIOImageProviderService.this.N++;
                        }
                    } else {
                        j3 = currentTimeMillis;
                        if (aIOImageProviderService4.x5().getMultiMessageProxy() == null || AIOImageProviderService.this.G) {
                            break;
                        } else {
                            changeFileMessageRecordList = FileManagerUtil.changeFileMessageRecordList(AIOImageProviderService.this.x5().getMultiMessageProxy().z(AIOImageProviderService.this.D));
                        }
                    }
                    if (!AIOImageProviderService.this.G) {
                        arrayList.addAll(changeFileMessageRecordList);
                        arrayList2.addAll(AIOImageProviderService.this.B1(changeFileMessageRecordList));
                        AIOImageProviderService.this.G = true;
                    } else {
                        arrayList.addAll(0, changeFileMessageRecordList);
                        arrayList2.addAll(0, AIOImageProviderService.this.B1(changeFileMessageRecordList));
                    }
                    if (AIOImageProviderService.this.f179592m || arrayList2.size() >= 30 || AIOImageProviderService.this.M < 60) {
                        break;
                    }
                    currentTimeMillis = j3;
                    c16 = 2;
                }
                if (arrayList2.size() > 0) {
                    AIOImageProviderService.this.E3(arrayList2);
                } else {
                    AIOImageProviderService.this.M5();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + AIOImageProviderService.this.f179592m + ", tempList.size: " + arrayList.size() + ", tempDataList.size: " + arrayList2.size() + ", cost:" + (System.currentTimeMillis() - j3));
                }
                aIOImageProviderService = AIOImageProviderService.this;
                aIOImageProviderService.H = false;
            } finally {
                AIOImageProviderService.this.H = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends ac.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f179606d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f179607e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f179608f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f179609h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f179610i;

        a(long j3, int i3, int i16, long j16, String str) {
            this.f179606d = j3;
            this.f179607e = i3;
            this.f179608f = i16;
            this.f179609h = j16;
            this.f179610i = str;
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void b(int i3, boolean z16) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar != null) {
                iVar.notifyImageProgress(this.f179606d, this.f179607e, this.f179608f, i3, this.f179609h, z16);
            }
            AIOImageProviderService.this.getClass();
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void g(int i3, com.tencent.mobileqq.pic.q qVar) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar != null) {
                if (qVar.f258790a == 0) {
                    iVar.notifyImageResult(this.f179606d, this.f179607e, this.f179608f, 1, this.f179610i, qVar.f258794e);
                    AIOImageProviderService.this.N5(this.f179606d, this.f179607e, this.f179608f, this.f179610i);
                } else {
                    iVar.notifyImageResult(this.f179606d, this.f179607e, this.f179608f, 2, "step:" + qVar.f258791b.f258736a + ", desc:" + qVar.f258791b.f258737b, qVar.f258794e);
                    AIOImageProviderService.this.N5(this.f179606d, this.f179607e, this.f179608f, AIOBrowserBaseData.MEDIA_FILE_ERROR);
                }
            }
            AIOImageProviderService.this.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends ab.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f179612a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f179613b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f179614c;

        b(long j3, int i3, int i16) {
            this.f179612a = j3;
            this.f179613b = i3;
            this.f179614c = i16;
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void a(int i3, y yVar) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (yVar.f288328a == 0) {
                c.a aVar = (c.a) yVar.f288331d;
                if (iVar != null) {
                    iVar.notifyImageResult(this.f179612a, this.f179613b, this.f179614c, 1, aVar.f258658e, false);
                }
                AIOImageProviderService.this.N5(this.f179612a, this.f179613b, this.f179614c, aVar.f258658e);
                return;
            }
            if (iVar != null) {
                iVar.notifyImageResult(this.f179612a, this.f179613b, this.f179614c, 2, "step:" + yVar.f288329b.f258736a + ", desc:" + yVar.f288329b.f258737b, false);
            }
            AIOImageProviderService.this.N5(this.f179612a, this.f179613b, this.f179614c, AIOBrowserBaseData.MEDIA_FILE_ERROR);
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void onUpdateProgress(int i3) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar != null) {
                iVar.notifyImageProgress(this.f179612a, this.f179613b, this.f179614c, i3, 0L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements com.tencent.mobileqq.filemanager.core.i {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.data.b f179616d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f179617e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f179618f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f179619h;

        c(com.tencent.mobileqq.filemanager.fileviewer.data.b bVar, long j3, int i3, int i16) {
            this.f179616d = bVar;
            this.f179617e = j3;
            this.f179618f = i3;
            this.f179619h = i16;
        }

        @Override // com.tencent.mobileqq.filemanager.core.i
        public void m(SuperPlayerVideoInfo superPlayerVideoInfo) {
            if (AIOImageProviderService.this.f179747d != null) {
                ArrayList<String> cookie = superPlayerVideoInfo.getCookie();
                Bundle bundle = new Bundle();
                bundle.putString("savepath", superPlayerVideoInfo.getLocalSavePath());
                bundle.putStringArrayList("cookies", cookie);
                bundle.putString("contextid", this.f179616d.a());
                bundle.putString(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, superPlayerVideoInfo.getFileId());
                AIOImageProviderService.this.f179747d.j0(this.f179617e, this.f179618f, this.f179619h, this.f179616d.c(), superPlayerVideoInfo.getPlayUrls(), null, null, -1, bundle);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.core.i
        public void p(int i3, String str) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar != null) {
                iVar.j0(this.f179617e, this.f179618f, this.f179619h, AIOBrowserBaseData.MEDIA_FILE_ERROR, new String[]{String.valueOf(i3), str}, null, null, -1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements com.tencent.mobileqq.filemanager.core.j {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.data.b f179621d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f179622e;

        d(com.tencent.mobileqq.filemanager.fileviewer.data.b bVar, long j3) {
            this.f179621d = bVar;
            this.f179622e = j3;
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void d(int i3, int i16, long j3, long j16) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar == null) {
                QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: callback = null , ctxId[" + this.f179621d.a() + "] ");
                return;
            }
            iVar.notifyImageProgress(this.f179622e, 0, 269484035, (int) ((((float) j3) / ((float) j16)) * 10000.0f), j16, false);
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void onDownloadError(int i3, int i16, String str) {
            int i17;
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar == null) {
                QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: error, ctxId[" + this.f179622e + "] ");
                return;
            }
            if (i16 != -7003 && i16 != -6101) {
                i17 = 0;
            } else {
                i17 = 16;
            }
            iVar.notifyImageResult(this.f179622e, i17, 269484034, 2, str, false);
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void r(String str) {
            i iVar = AIOImageProviderService.this.f179747d;
            if (iVar == null) {
                QLog.i("AIOImageProviderServiceXOXO", 2, "onDownloadFinish callback = null , ctxId[" + this.f179622e + "] ");
                return;
            }
            QLog.i("AIOImageProviderService", 1, "-----------> notify download finish:" + this.f179622e);
            iVar.notifyImageResult(this.f179622e, 1, 269484034, 1, str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e extends com.tencent.mobileqq.app.k {
        e() {
        }

        private void v(long j3, DataLineMsgRecord dataLineMsgRecord, i iVar) {
            int fileType = FileManagerUtil.getFileType(dataLineMsgRecord.filename);
            MessageForDLFile o56 = AIOImageProviderService.this.o5(j3);
            if (o56 == null) {
                return;
            }
            if (fileType == 0) {
                iVar.notifyImageResult(o56.uniseq, 0, 4, 2, "", false);
                AIOImageProviderService.this.N5(o56.uniseq, 0, 4, AIOBrowserBaseData.MEDIA_FILE_ERROR);
            } else if (fileType == 2) {
                iVar.notifyImageResult(o56.uniseq, 0, 269484034, 2, "", false);
            }
        }

        private void w(long j3, DataLineMsgRecord dataLineMsgRecord, i iVar) {
            String str = dataLineMsgRecord.path;
            int fileType = FileManagerUtil.getFileType(dataLineMsgRecord.filename);
            MessageForDLFile o56 = AIOImageProviderService.this.o5(j3);
            if (o56 == null) {
                return;
            }
            if (fileType == 0) {
                iVar.notifyImageResult(o56.uniseq, 0, 4, 1, str, false);
                AIOImageProviderService.this.N5(o56.uniseq, 0, 4, str);
            } else if (fileType == 2) {
                if (AIOImageProviderService.this.W.contains(Long.valueOf(o56.uniseq))) {
                    Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                    if (baseContext != null) {
                        FileManagerUtil.saveToAlbum(baseContext, str);
                    } else {
                        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [dataline file save album].");
                    }
                    AIOImageProviderService.this.W.remove(Long.valueOf(o56.uniseq));
                }
                iVar.notifyImageResult(o56.uniseq, 0, 269484034, 1, str, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void h(long j3, float f16) {
            DataLineMsgRecord u16 = u(j3);
            AIOImageProviderService aIOImageProviderService = AIOImageProviderService.this;
            i iVar = aIOImageProviderService.f179747d;
            if (u16 != null && iVar != null) {
                MessageForDLFile o56 = aIOImageProviderService.o5(j3);
                if (o56 != null && FileManagerUtil.getFileType(u16.filename) == 0) {
                    iVar.notifyImageProgress(o56.uniseq, 0, 4, (int) (f16 * 10000.0f), u16.filesize, false);
                    return;
                }
                return;
            }
            QLog.i("AIOImageProviderService", 2, "onDatalineProgress: error");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void j(boolean z16, long j3, String str) {
            DataLineMsgRecord u16 = u(j3);
            i iVar = AIOImageProviderService.this.f179747d;
            if (u16 != null && iVar != null) {
                FileManagerUtil.getFileType(u16.filename);
                if (z16) {
                    w(j3, u16, iVar);
                    return;
                } else {
                    v(j3, u16, iVar);
                    return;
                }
            }
            QLog.i("AIOImageProviderService", 2, "onDatalineProgress: error");
        }

        @Override // com.tencent.mobileqq.app.k
        protected void r(long j3) {
            DataLineMsgRecord u16 = u(j3);
            AIOImageProviderService aIOImageProviderService = AIOImageProviderService.this;
            i iVar = aIOImageProviderService.f179747d;
            if (u16 != null && iVar != null) {
                MessageForDLFile o56 = aIOImageProviderService.o5(j3);
                if (o56 != null && com.tencent.mobileqq.filemanager.util.q.p(u16.thumbPath)) {
                    iVar.notifyImageResult(o56.uniseq, 0, 1, 1, u16.thumbPath, false);
                    AIOImageProviderService.this.N5(j3, 0, 1, u16.thumbPath);
                    iVar.notifyImageResult(o56.uniseq, 0, 2, 1, u16.thumbPath, false);
                    AIOImageProviderService.this.N5(j3, 0, 2, u16.thumbPath);
                    return;
                }
                return;
            }
            QLog.i("AIOImageProviderService", 2, "onDatalineProgress: error");
        }

        public DataLineMsgRecord u(long j3) {
            QQAppInterface x55 = AIOImageProviderService.this.x5();
            if (x55 == null) {
                return null;
            }
            return x55.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(j3)).d(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f extends FMObserver {

        /* renamed from: e, reason: collision with root package name */
        private boolean f179625e = false;

        public f() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void A0(com.tencent.mobileqq.filemanager.data.n nVar, int i3) {
            QQAppInterface d16 = d1();
            if (d16 == null) {
                return;
            }
            FileManagerEntity D = d16.getFileManagerDataCenter().D(nVar.f207834e);
            i iVar = AIOImageProviderService.this.f179747d;
            if (D != null && iVar != null) {
                iVar.notifyImageProgress(D.uniseq, D.status, 2, i3, D.fileSize, false);
                return;
            }
            QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + D + "] callback[" + iVar + "]");
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void B0(com.tencent.mobileqq.filemanager.data.n nVar) {
            String str;
            QQAppInterface d16 = d1();
            if (d16 == null) {
                return;
            }
            FileManagerEntity D = d16.getFileManagerDataCenter().D(nVar.f207834e);
            i iVar = AIOImageProviderService.this.f179747d;
            int i3 = 2;
            if (D != null && iVar != null) {
                if (nVar.f207835f == 5) {
                    i3 = 1;
                }
                if (com.tencent.mobileqq.filemanager.util.q.p(nVar.f207833d)) {
                    iVar.notifyImageResult(D.uniseq, D.status, i3, 1, nVar.f207833d, false);
                    AIOImageProviderService.this.N5(D.uniseq, D.status, i3, nVar.f207833d);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "thumb_download");
                    jSONObject.put("errorCode", D.thumbInvalidCode);
                    str = jSONObject.toString();
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    str = "";
                }
                iVar.notifyImageResult(D.uniseq, D.status, i3, 2, str, false);
                AIOImageProviderService.this.N5(D.uniseq, D.status, i3, AIOBrowserBaseData.MEDIA_FILE_ERROR);
                return;
            }
            QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + D + "] callback[" + iVar + "]");
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            QQAppInterface d16 = d1();
            if (d16 == null) {
                QLog.e("AIOImageProviderService", 1, "onFileTransferEnd error: mApp == null");
                return;
            }
            FileManagerEntity D = d16.getFileManagerDataCenter().D(j16);
            AIOImageProviderService aIOImageProviderService = AIOImageProviderService.this;
            i iVar = aIOImageProviderService.f179747d;
            if (D != null && iVar != null) {
                if (z16) {
                    int i17 = D.nFileType;
                    if (i17 == 0) {
                        iVar.notifyImageResult(j3, D.status, 4, 1, D.getFilePath(), false);
                        AIOImageProviderService.this.N5(j3, D.status, 4, D.getFilePath());
                        return;
                    } else {
                        if (i17 == 2) {
                            if (aIOImageProviderService.W.contains(Long.valueOf(j3))) {
                                Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                                if (baseContext != null) {
                                    FileManagerUtil.saveToAlbum(baseContext, D.getFilePath());
                                } else {
                                    QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
                                }
                                AIOImageProviderService.this.W.remove(Long.valueOf(j3));
                            }
                            iVar.notifyImageResult(j3, D.status, 269484034, 1, D.getFilePath(), false);
                            return;
                        }
                        return;
                    }
                }
                if (i16 == -7003 || i16 == -6101) {
                    D.status = 16;
                }
                int i18 = D.nFileType;
                if (i18 == 0) {
                    iVar.notifyImageResult(j3, D.status, 4, 2, str2, false);
                    AIOImageProviderService.this.N5(j3, D.status, 4, AIOBrowserBaseData.MEDIA_FILE_ERROR);
                    return;
                } else {
                    if (i18 == 2) {
                        iVar.notifyImageResult(j3, D.status, 269484034, 2, str2, false);
                        return;
                    }
                    return;
                }
            }
            QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + D + "] callback[" + iVar + "]");
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void T(boolean z16, long j3, long j16, String str, int i3) {
            QQAppInterface d16 = d1();
            if (d16 == null) {
                QLog.e("AIOImageProviderService", 1, "onFileTransferProgress error: mApp == null");
                return;
            }
            FileManagerEntity D = d16.getFileManagerDataCenter().D(j16);
            i iVar = AIOImageProviderService.this.f179747d;
            if (D != null && iVar != null) {
                if (D.nFileType == 0) {
                    iVar.notifyImageProgress(j3, 0, 4, (int) (D.fProgress * 10000.0f), D.fileSize, false);
                    return;
                }
                return;
            }
            QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + D + "] callback[" + iVar + "]");
        }

        @Nullable
        protected QQAppInterface d1() {
            if (this.f179625e) {
                return null;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                return null;
            }
            return (QQAppInterface) peekAppRuntime;
        }

        public void e1() {
            this.f179625e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class g extends com.tencent.mobileqq.app.c {
        g() {
        }

        private void q(t tVar, MessageForTroopFile messageForTroopFile) {
            if (AIOImageProviderService.this.J5(messageForTroopFile)) {
                int i3 = tVar.f294972f;
                if (i3 == 8) {
                    long j3 = tVar.f294976j;
                    if (j3 > 0) {
                        AIOImageProviderService.this.f179747d.notifyImageProgress(messageForTroopFile.uniseq, 0, 1, (int) ((((float) tVar.f294977k) / ((float) j3)) * 10000.0f), j3, true);
                        return;
                    }
                }
                if (i3 == 11) {
                    if (AIOImageProviderService.this.W.contains(Long.valueOf(messageForTroopFile.uniseq))) {
                        Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                        if (baseContext != null) {
                            FileManagerUtil.saveToAlbum(baseContext, tVar.f294978l);
                        } else {
                            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
                        }
                        AIOImageProviderService.this.W.remove(Long.valueOf(messageForTroopFile.uniseq));
                    }
                    AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 1, 269484034, 1, tVar.f294978l, false);
                    return;
                }
                if (i3 == 12 || i3 == 10) {
                    AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 269484034, 2, tVar.f294978l, false);
                    return;
                }
                return;
            }
            if (messageForTroopFile.isPause) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + tVar.f294972f);
                    return;
                }
                return;
            }
            int i16 = tVar.f294972f;
            if (i16 == 8) {
                long j16 = tVar.f294976j;
                if (j16 > 0) {
                    AIOImageProviderService.this.f179747d.notifyImageProgress(messageForTroopFile.uniseq, 0, 4, (int) ((tVar.f294977k * 10000) / j16), messageForTroopFile.fileSize, true);
                    return;
                }
            }
            if (i16 == 11) {
                AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 4, 1, tVar.f294978l, false);
            } else if (i16 == 12 || i16 == 10) {
                AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 4, 2, RichMediaBrowserConstants.TROOP_FILE_ERROR, false);
            }
        }

        private void r(t tVar, MessageForTroopFile messageForTroopFile) {
            String str;
            String str2 = "";
            if (FileUtils.fileExistsAndNotEmpty(tVar.f294981o)) {
                AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 1, 1, tVar.f294981o, false);
            } else if (tVar.I != 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "thumb_download");
                    jSONObject.put("errorCode", tVar.I);
                    str = jSONObject.toString();
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    str = "";
                }
                AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 2, 2, str, false);
            }
            if (FileUtils.fileExistsAndNotEmpty(tVar.f294980n)) {
                AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 2, 1, tVar.f294980n, false);
                return;
            }
            if (tVar.I != 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "thumb_download");
                    jSONObject2.put("errorCode", tVar.I);
                    str2 = jSONObject2.toString();
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                AIOImageProviderService.this.f179747d.notifyImageResult(messageForTroopFile.uniseq, 0, 2, 2, str2, false);
            }
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object obj) {
            MessageForTroopFile messageForTroopFile;
            t tVar = (t) obj;
            if (tVar != null) {
                messageForTroopFile = AIOImageProviderService.this.p5(tVar.f294985s);
            } else {
                messageForTroopFile = null;
            }
            if (tVar != null && messageForTroopFile != null) {
                if (!messageForTroopFile.url.equals(tVar.f294985s)) {
                    QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, file info not match message. fileId[" + tVar.f294985s + "]");
                    return;
                }
                if (AIOImageProviderService.this.f179747d == null) {
                    QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
                } else {
                    r(tVar, messageForTroopFile);
                    q(tVar, messageForTroopFile);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AIOImageProviderService() {
        this.f179592m = false;
        this.C = false;
        this.E = Collections.synchronizedList(new LinkedList());
        this.F = Collections.synchronizedList(new LinkedList());
        this.G = false;
        this.H = false;
        this.I = Long.MAX_VALUE;
        this.J = Long.MAX_VALUE;
        this.K = 3;
        this.L = Long.MAX_VALUE;
        this.M = 60;
        this.N = 0;
        this.Q = null;
        this.R = new IncreasinglyLoadMediaTask();
        this.W = new ArrayList<>();
    }

    private void A5(QQAppInterface qQAppInterface, t tVar, String str, long j3, int i3, int i16) {
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.valueOf(str).longValue());
        if (tVar.f294972f == 11 && FileUtils.fileExists(tVar.f294978l)) {
            i iVar = this.f179747d;
            if (iVar != null) {
                iVar.notifyImageResult(j3, i3, i16, 1, tVar.f294978l, false);
                return;
            }
            return;
        }
        int i17 = tVar.f294972f;
        if (i17 != 7 && (i17 != 11 || FileUtils.fileExists(tVar.f294978l))) {
            O.e0(tVar.f294967a);
        } else {
            O.x0(tVar.f294985s, tVar.f294987u, tVar.f294976j, tVar.f294988v, null);
        }
    }

    private void B5(QQAppInterface qQAppInterface, t tVar, String str, MessageForTroopFile messageForTroopFile, long j3, int i3, int i16) {
        if (!FileUtils.fileExistsAndNotEmpty(tVar.f294980n)) {
            if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication())) {
                i iVar = this.f179747d;
                if (iVar != null) {
                    iVar.notifyImageResult(messageForTroopFile.uniseq, 0, 2, 2, tVar.f294980n, false);
                    return;
                }
                return;
            }
            TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.valueOf(str).longValue());
            UUID uuid = tVar.f294967a;
            if (uuid != null) {
                O.D(uuid, 640);
                return;
            } else {
                O.C(tVar.f294985s, tVar.f294987u, tVar.f294988v, 640, null);
                return;
            }
        }
        i iVar2 = this.f179747d;
        if (iVar2 != null) {
            iVar2.notifyImageResult(messageForTroopFile.uniseq, 0, 2, 1, tVar.f294980n, false);
        }
    }

    private void C5(QQAppInterface qQAppInterface, t tVar, String str, MessageForTroopFile messageForTroopFile, long j3, int i3, int i16) {
        i iVar;
        if (!FileUtils.fileExistsAndNotEmpty(tVar.f294981o)) {
            if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication()) && (iVar = this.f179747d) != null) {
                iVar.notifyImageResult(messageForTroopFile.uniseq, 0, 1, 2, tVar.f294980n, false);
            }
            TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.valueOf(str).longValue());
            UUID uuid = tVar.f294967a;
            if (uuid != null) {
                O.D(uuid, 383);
                return;
            } else {
                O.C(tVar.f294985s, tVar.f294987u, tVar.f294988v, 383, null);
                return;
            }
        }
        i iVar2 = this.f179747d;
        if (iVar2 != null) {
            iVar2.notifyImageResult(messageForTroopFile.uniseq, 0, 1, 1, tVar.f294981o, false);
        }
    }

    public static Intent E5(MessageForShortVideo messageForShortVideo) {
        if (TextUtils.isEmpty(messageForShortVideo.md5)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "Forward menu clicked, md5 is empty.");
                return null;
            }
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 21);
        String l3 = com.tencent.mobileqq.shortvideo.j.l(messageForShortVideo.thumbMD5, "jpg");
        bundle.putString(AppConstants.Key.FORWARD_THUMB, l3);
        bundle.putString(ShortVideoConstants.FROM_UIN, com.tencent.mobileqq.shortvideo.j.c(messageForShortVideo));
        bundle.putInt(ShortVideoConstants.FROM_BUSI_TYPE, messageForShortVideo.busiType);
        bundle.putInt(ShortVideoConstants.FILE_SEND_SIZE, messageForShortVideo.videoFileSize);
        bundle.putInt(ShortVideoConstants.FILE_SEND_DURATION, messageForShortVideo.videoFileTime);
        bundle.putString("file_name", messageForShortVideo.videoFileName);
        bundle.putInt(ShortVideoConstants.FILE_FORMAT, messageForShortVideo.videoFileFormat);
        bundle.putBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        String findVideoPathIfExists = ShortVideoUtils.findVideoPathIfExists(messageForShortVideo);
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "Forward menu clicked, videoPath=" + findVideoPathIfExists + ",videoPath = " + findVideoPathIfExists + ", " + messageForShortVideo.toLogString());
        }
        bundle.putString("file_send_path", findVideoPathIfExists);
        bundle.putString(ShortVideoConstants.THUMBFILE_SEND_PATH, l3);
        bundle.putString(ShortVideoConstants.FILE_SHORTVIDEO_MD5, messageForShortVideo.md5);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_WIDTH, messageForShortVideo.thumbWidth);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, messageForShortVideo.thumbHeight);
        bundle.putString(ShortVideoConstants.THUMBFILE_MD5, messageForShortVideo.thumbMD5);
        bundle.putString(ShortVideoConstants.FILE_SOURCE, messageForShortVideo.fileSource);
        bundle.putString(ShortVideoConstants.FILE_UUID, messageForShortVideo.uuid);
        bundle.putInt(ShortVideoConstants.FILE_THUMB_SIZE, messageForShortVideo.thumbFileSize);
        if (FileUtils.fileExistsAndNotEmpty(findVideoPathIfExists)) {
            bundle.putBoolean("k_dataline", true);
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, findVideoPathIfExists);
            bundle.putBoolean("direct_send_if_dataline_forward", true);
        }
        bundle.putInt(ShortVideoConstants.SOURCE_VIDEO_CODEC_FORMAT, messageForShortVideo.sourceVideoCodecFormat);
        return new Intent().putExtras(bundle);
    }

    private Intent F5(MessageForTroopFile messageForTroopFile) {
        try {
            t m3 = TroopFileUtils.m((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e), messageForTroopFile);
            if (m3 == null) {
                QLog.w("AIOImageProviderService", 1, "getFileStatusInfo is null");
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 0);
            FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(m3);
            newEntityByTroopFileInfo.status = 2;
            newEntityByTroopFileInfo.nOpType = 24;
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(newEntityByTroopFileInfo.nSessionId);
            forwardFileInfo.N(10006);
            if (!TextUtils.isEmpty(newEntityByTroopFileInfo.getFilePath())) {
                forwardFileInfo.C(m3.f294978l);
            }
            forwardFileInfo.y(m3.f294987u);
            forwardFileInfo.z(m3.f294976j);
            forwardFileInfo.B(Long.parseLong(messageForTroopFile.frienduin));
            UUID uuid = m3.f294967a;
            if (uuid != null) {
                forwardFileInfo.M(uuid.toString());
            }
            if (!TextUtils.isEmpty(m3.f294980n)) {
                forwardFileInfo.G(m3.f294980n);
            } else if (!TextUtils.isEmpty(m3.f294981o)) {
                forwardFileInfo.G(m3.f294981o);
            }
            forwardFileInfo.w(1);
            forwardFileInfo.A(1);
            bundle.putParcelable("fileinfo", forwardFileInfo);
            bundle.putBoolean("not_forward", true);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, m3.f294987u);
            intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
            intent.putExtra("direct_send_if_dataline_forward", true);
            intent.putExtra("forward _key_nojump", false);
            intent.putExtra("sender_uin", messageForTroopFile.senderuin);
            intent.putExtra("last_time", messageForTroopFile.lastTime);
            return intent;
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J5(MessageRecord messageRecord) {
        FileManagerEntity i3;
        FileManagerEntity D;
        String str = "";
        if (MessageForFile.class.isInstance(messageRecord)) {
            MessageForFile messageForFile = (MessageForFile) messageRecord;
            try {
                QQAppInterface x55 = x5();
                if (x55 != null && (i3 = x55.getFileManagerDataCenter().i(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop)) != null && (D = x55.getFileManagerDataCenter().D(i3.nSessionId)) != null) {
                    String str2 = D.fileName;
                    messageForFile.fileName = str2;
                    str = str2;
                }
            } catch (Exception unused) {
            }
        } else if (MessageForTroopFile.class.isInstance(messageRecord)) {
            str = ((MessageForTroopFile) messageRecord).fileName;
        } else if (MessageForDLFile.class.isInstance(messageRecord)) {
            str = ((MessageForDLFile) messageRecord).fileName;
        }
        if (2 == FileManagerUtil.getFileType(str)) {
            return true;
        }
        return false;
    }

    public static boolean L5(AIORichMediaData aIORichMediaData) {
        if (AIOShortVideoData.class.isInstance(aIORichMediaData)) {
            return false;
        }
        if (AIOFileVideoData.class.isInstance(aIORichMediaData) || !AIOLightVideoData.class.isInstance(aIORichMediaData)) {
            return false;
        }
        return true;
    }

    private void N1(List<AIORichMediaData> list, List<ChatMessage> list2, MessageRecord messageRecord) {
        DataLineMsgRecord d16;
        AIORichMediaData o16;
        QQAppInterface x55 = x5();
        if (x55 == null) {
            return;
        }
        MessageForDLFile messageForDLFile = (MessageForDLFile) messageRecord;
        int i3 = messageForDLFile.deviceType;
        long j3 = messageForDLFile.associatedId;
        DatalineMessageManager t16 = x55.getMessageFacade().t1(i3);
        if (t16 == null || (d16 = t16.d(j3)) == null) {
            return;
        }
        messageForDLFile.parse();
        int fileType = FileManagerUtil.getFileType(d16.filename);
        if (fileType != 2 && fileType != 0) {
            o16 = null;
        } else {
            o16 = com.tencent.mobileqq.activity.aio.photo.c.o(messageForDLFile, x5());
        }
        if (o16 != null) {
            list.add(o16);
            list2.add(messageForDLFile);
        }
    }

    public static void O5(QQAppInterface qQAppInterface, MessageForPic messageForPic) {
        if (qQAppInterface != null && messageForPic != null) {
            ((IPicPreDownload) qQAppInterface.getRuntimeService(IPicPreDownload.class)).payPicFlow(messageForPic);
        }
    }

    private void P5(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str == null) {
            str = "";
        }
        hashMap.put("result", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("fromaction", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.IMG_PROVIDERSERVICE_GET_TOPACTIVITY, false, 0L, 0L, hashMap, null);
    }

    private void Q0(MessageForDLFile messageForDLFile) {
        DataLineMsgRecord d16;
        QQAppInterface x55 = x5();
        if (x55 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
                return;
            }
            return;
        }
        int i3 = messageForDLFile.deviceType;
        long j3 = messageForDLFile.associatedId;
        DatalineMessageManager t16 = x55.getMessageFacade().t1(i3);
        if (t16 != null && (d16 = t16.d(j3)) != null) {
            ((DataLineHandler) x55.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).j3(d16.groupId, d16.sessionid, false);
        }
    }

    private void Q5(QQAppInterface qQAppInterface, ChatMessage chatMessage, long j3, int i3) {
        String str = chatMessage.frienduin;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t m3 = TroopFileUtils.m(qQAppInterface, (MessageForTroopFile) chatMessage);
        if (m3 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("VideoPlayControllerForFile.main", 2, "onFileVideoStatusChange[" + i3 + "], info == null");
                return;
            }
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.valueOf(str).longValue());
        TroopFileTransferManager.Item J = O.J(m3.f294967a);
        if (com.tencent.mobileqq.filemanager.util.q.f(m3.f294978l)) {
            if (QLog.isColorLevel()) {
                QLog.i("troop VideoPlayControllerForFile.main", 1, "Play id:" + j3 + " type: FILE_VIDEO_PEEK_PAUSE file is exsited");
            }
            if (13 == i3) {
                Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                if (baseContext != null) {
                    FileManagerUtil.saveToAlbum(baseContext, m3.f294978l);
                } else {
                    QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
                }
            }
            TroopFileTransferManager.Item J2 = O.J(m3.f294967a);
            if (J2 != null) {
                O.n0(J2, 11);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlayControllerForFile.main", 1, "set mobileqq video Play id:" + j3 + " type:" + i3 + " troopId:" + m3.f294967a);
        }
        if (J != null) {
            O.n0(J, 8);
        }
    }

    private void R5(QQAppInterface qQAppInterface, ChatMessage chatMessage, long j3, int i3) {
        String str = chatMessage.frienduin;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t m3 = TroopFileUtils.m(qQAppInterface, (MessageForTroopFile) chatMessage);
        if (m3 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("VideoPlayControllerForFile.main", 2, "onFileVideoStatusChange[" + i3 + "], info == null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlayControllerForFile.main", 1, "set mobileqq video pause id:" + j3 + " type:" + i3 + " troopId:" + m3.f294967a);
        }
        TroopFileTransferManager.O(qQAppInterface, Long.valueOf(str).longValue()).C0(m3.f294967a);
    }

    private void T5(int i3, String str, AIOFilePicData aIOFilePicData) {
        if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        aIOFilePicData.M = true;
                        return;
                    }
                    return;
                }
                aIOFilePicData.L = true;
                return;
            }
            aIOFilePicData.N = true;
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 4) {
                    aIOFilePicData.J = str;
                    return;
                }
                return;
            }
            aIOFilePicData.I = str;
            return;
        }
        aIOFilePicData.H = str;
    }

    private void U5(int i3, String str, AIOImageData aIOImageData) {
        if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        aIOImageData.L = true;
                        return;
                    }
                    return;
                }
                aIOImageData.K = true;
                return;
            }
            aIOImageData.J = true;
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 8) {
                        aIOImageData.I = str;
                        return;
                    }
                    return;
                }
                aIOImageData.H = str;
                return;
            }
            aIOImageData.G = str;
            if (!aIOImageData.f179570a0) {
                if (new File(aIOImageData.F + "_hd").exists()) {
                    aIOImageData.F += "_hd";
                    return;
                }
                return;
            }
            return;
        }
        aIOImageData.F = str;
    }

    private void V5(MessageRecord messageRecord) {
        long j3 = messageRecord.shmsgseq;
        if (j3 < this.J) {
            this.J = j3;
        }
        int i3 = messageRecord.versionCode;
        if (i3 < this.K) {
            this.K = i3;
        }
        if (messageRecord.getId() > 0 && messageRecord.getId() < this.I) {
            this.I = messageRecord.getId();
        }
        long j16 = messageRecord.time;
        if (j16 < this.L) {
            this.L = j16;
        }
    }

    private void W5(int i3, String str, AIOShortVideoData aIOShortVideoData) {
        if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
            if (i3 != 0) {
                if (i3 == 1) {
                    aIOShortVideoData.K = true;
                    return;
                }
                return;
            }
            aIOShortVideoData.J = true;
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                aIOShortVideoData.G = str;
                return;
            }
            return;
        }
        aIOShortVideoData.F = str;
    }

    private void Z2(List<AIORichMediaData> list, List<ChatMessage> list2, MessageForTroopFile messageForTroopFile) {
        boolean z16;
        AIORichMediaData o16;
        int fileType = FileManagerUtil.getFileType(messageForTroopFile.fileName);
        boolean z17 = true;
        if (fileType == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (fileType != 2) {
            z17 = false;
        }
        t m3 = TroopFileUtils.m(x5(), messageForTroopFile);
        if (m3 == null) {
            return;
        }
        if (z16) {
            AIOFilePicData s16 = com.tencent.mobileqq.activity.aio.photo.c.s(messageForTroopFile, x5());
            if (s16 != null) {
                list.add(s16);
                list2.add(messageForTroopFile);
                return;
            }
            return;
        }
        if (z17) {
            if ((com.tencent.mobileqq.filemanager.util.q.f(m3.f294978l) || QFileUtils.e0(x5())) && (o16 = com.tencent.mobileqq.activity.aio.photo.c.o(messageForTroopFile, x5())) != null) {
                list.add(o16);
                list2.add(messageForTroopFile);
            }
        }
    }

    private void b1(MessageForFile messageForFile, long j3) {
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            qQAppInterface.getFileManagerEngine().i0(FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, messageForFile).nSessionId);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "no appRuntime");
            }
        }
    }

    public static AIOImageProviderService e3(String str, String str2, int i3, ChatMessage chatMessage, boolean z16) {
        AIOImageProviderService aIOImageProviderService;
        String str3 = str + "_" + str2 + "_" + i3;
        if (z16 && (chatMessage == null || !chatMessage.isMultiMsg)) {
            aIOImageProviderService = X.get(str3);
        } else {
            aIOImageProviderService = null;
        }
        if (aIOImageProviderService == null) {
            return new AIOImageProviderService(str, str2, i3, chatMessage);
        }
        return aIOImageProviderService;
    }

    private void g4(MessageForDLFile messageForDLFile, long j3, int i3, int i16) {
        DataLineMsgRecord d16;
        QQAppInterface x55 = x5();
        if (x55 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
                return;
            }
            return;
        }
        int i17 = messageForDLFile.deviceType;
        long j16 = messageForDLFile.associatedId;
        DatalineMessageManager t16 = x55.getMessageFacade().t1(i17);
        if (t16 == null || (d16 = t16.d(j16)) == null) {
            return;
        }
        int fileType = FileManagerUtil.getFileType(d16.filename);
        if (i16 != 4 && fileType != 2) {
            r4(d16, j3, i3, i16);
        } else {
            p4(d16, j3, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMessage n5(long j3, long j16) {
        ChatMessage chatMessage;
        synchronized (this.E) {
            Iterator<ChatMessage> it = this.E.iterator();
            while (true) {
                if (it.hasNext()) {
                    chatMessage = it.next();
                    if (MessageForPic.class.isInstance(chatMessage)) {
                        if (j3 == ((MessageForPic) chatMessage).uniseq && j16 == r3.subMsgId) {
                            break;
                        }
                    } else if (j3 == chatMessage.uniseq) {
                        break;
                    }
                }
                chatMessage = null;
                break;
            }
        }
        return chatMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageForDLFile o5(long j3) {
        MessageForDLFile messageForDLFile;
        synchronized (this.E) {
            Iterator<ChatMessage> it = this.E.iterator();
            while (true) {
                if (it.hasNext()) {
                    ChatMessage next = it.next();
                    if (MessageForDLFile.class.isInstance(next)) {
                        messageForDLFile = (MessageForDLFile) next;
                        if (messageForDLFile.associatedId == j3) {
                            break;
                        }
                    }
                } else {
                    messageForDLFile = null;
                    break;
                }
            }
        }
        return messageForDLFile;
    }

    private void p4(DataLineMsgRecord dataLineMsgRecord, long j3, int i3, int i16) {
        QQAppInterface x55 = x5();
        if (x55 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
                return;
            }
            return;
        }
        int fileType = FileManagerUtil.getFileType(dataLineMsgRecord.filename);
        if (fileType == 2) {
            v5(j3, i3, i16, new com.tencent.mobileqq.filemanager.fileviewer.data.f(x55, dataLineMsgRecord));
        } else if (fileType == 0) {
            DataLineHandler dataLineHandler = (DataLineHandler) x55.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(dataLineMsgRecord.sessionid));
            dataLineHandler.c4(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageForTroopFile p5(String str) {
        MessageForTroopFile messageForTroopFile = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, MessageForTroopFile> hashMap = this.U;
        if (hashMap != null && !hashMap.isEmpty()) {
            messageForTroopFile = this.U.get(str);
        }
        if (messageForTroopFile == null) {
            synchronized (this.E) {
                Iterator<ChatMessage> it = this.E.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ChatMessage next = it.next();
                    if (MessageForTroopFile.class.isInstance(next)) {
                        MessageForTroopFile messageForTroopFile2 = (MessageForTroopFile) next;
                        if (!TextUtils.isEmpty(messageForTroopFile2.url) && messageForTroopFile2.url.equals(str)) {
                            messageForTroopFile = messageForTroopFile2;
                            break;
                        }
                    }
                }
                HashMap<String, MessageForTroopFile> hashMap2 = this.U;
                if (hashMap2 != null && messageForTroopFile != null) {
                    hashMap2.put(str, messageForTroopFile);
                }
            }
        }
        return messageForTroopFile;
    }

    private void q3(MessageForPic messageForPic, long j3, int i3, int i16) {
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (z55 != null) {
            z55.p(messageForPic, j3, i3, i16);
        }
    }

    private void r4(DataLineMsgRecord dataLineMsgRecord, long j3, int i3, int i16) {
        if (x5() == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadDatalineFileImage, app == null");
                return;
            }
            return;
        }
        FileManagerUtil.getFileType(dataLineMsgRecord.filename);
    }

    private QQAppInterface t5() {
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            if (qQAppInterface == null) {
                return null;
            }
            return qQAppInterface;
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
            return null;
        }
    }

    private String u5(QQAppInterface qQAppInterface, long j3) {
        t m3;
        ChatMessage m56 = m5(j3);
        if (m56 == null) {
            return null;
        }
        if (MessageForFile.class.isInstance(m56)) {
            return FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, (MessageForFile) m56).getFilePath();
        }
        if (!MessageForTroopFile.class.isInstance(m56) || (m3 = TroopFileUtils.m(qQAppInterface, (MessageForTroopFile) m56)) == null) {
            return null;
        }
        return m3.f294985s;
    }

    private void v5(long j3, int i3, int i16, com.tencent.mobileqq.filemanager.fileviewer.data.b bVar) {
        com.tencent.mobileqq.filemanager.core.k b16 = com.tencent.mobileqq.filemanager.core.g.b(bVar);
        b16.g(new c(bVar, j3, i3, i16));
        b16.f(new d(bVar, j3));
        b16.d(true);
        b16.startDownload();
    }

    private String w5() {
        String str = this.f179588e + "_" + this.f179589f + "_" + this.f179590h;
        if (this.C) {
            return str + "_f";
        }
        return str;
    }

    private com.tencent.mobileqq.multimsg.save.h z5() {
        QQAppInterface qQAppInterface;
        try {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "getRichMedialSaveManager app == null");
            }
            return null;
        }
        return (com.tencent.mobileqq.multimsg.save.h) qQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void A(long j3, int i3, int i16) {
        ChatMessage n56 = n5(j3, i3);
        if (n56 != null) {
            if (MessageForPic.class.isInstance(n56)) {
                h1((MessageForPic) n56, j3, i3, i16);
                return;
            }
            if (MessageForShortVideo.class.isInstance(n56)) {
                if (i16 == 256) {
                    z1((MessageForShortVideo) n56, j3, i3, i16);
                }
            } else if (MessageForFile.class.isInstance(n56)) {
                b1((MessageForFile) n56, j3);
            } else if (MessageForTroopFile.class.isInstance(n56)) {
                s1((MessageForTroopFile) n56);
            } else if (MessageForDLFile.class.isInstance(n56)) {
                Q0((MessageForDLFile) n56);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void B(long j3) {
        long j16;
        ChatMessage l56 = l5(j3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("revokeMsg msgseq:");
            if (l56 != null) {
                j16 = l56.uniseq;
            } else {
                j16 = 0;
            }
            sb5.append(j16);
            sb5.append(", uniseq:");
            sb5.append(j3);
            QLog.i("AIOImageProviderService", 2, sb5.toString());
        }
    }

    public List<AIORichMediaData> B1(List<MessageRecord> list) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MessageRecord messageRecord = list.get(i3);
            V5(messageRecord);
            if (messageRecord instanceof MessageForPic) {
                W1(arrayList, arrayList2, messageRecord);
            } else if (messageRecord instanceof MessageForMixedMsg) {
                U1(arrayList, arrayList2, (MessageForMixedMsg) messageRecord);
            } else if (messageRecord instanceof MessageForStructing) {
                j2(arrayList, arrayList2, messageRecord);
            } else if (MessageForShortVideo.class.isInstance(messageRecord)) {
                h2(arrayList, arrayList2, messageRecord);
            } else if (messageRecord instanceof MessageForFile) {
                S1(arrayList, arrayList2, messageRecord);
            } else if (messageRecord instanceof MessageForTroopFile) {
                Z2(arrayList, arrayList2, (MessageForTroopFile) messageRecord);
            } else if (messageRecord instanceof MessageForDLFile) {
                N1(arrayList, arrayList2, messageRecord);
            } else if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "messageRecordToData " + messageRecord.getBaseInfoString());
            }
        }
        if (this.G) {
            this.E.addAll(0, arrayList2);
            this.F.addAll(0, arrayList);
        } else {
            this.E.clear();
            this.F.clear();
            this.E.addAll(arrayList2);
            this.F.addAll(arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "messageRecordToData total size " + arrayList2.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void C(long j3, int i3, Bundle bundle) {
        try {
            ChatMessage m56 = m5(j3);
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            if (m56 != null && J5(m56)) {
                switch (i3) {
                    case 10:
                        com.tencent.mobileqq.filemanager.core.g.k(bundle.getString("contextid"), true);
                        return;
                    case 11:
                        String string = bundle.getString("contextid");
                        com.tencent.mobileqq.filemanager.core.g.c(string);
                        com.tencent.mobileqq.filemanager.core.g.k(string, false);
                        if (MessageForTroopFile.class.isInstance(m56)) {
                            Q5(qQAppInterface, m56, j3, i3);
                            return;
                        }
                        return;
                    case 12:
                        com.tencent.mobileqq.filemanager.core.g.a(bundle.getString("contextid"));
                        if (MessageForTroopFile.class.isInstance(m56)) {
                            R5(qQAppInterface, m56, j3, i3);
                            return;
                        }
                        MessageForFile messageForFile = (MessageForFile) m56;
                        FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
                        if (E == null) {
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("VideoPlayControllerForFile.main", 1, "set  video pause id:" + j3 + " type: FILE_VIDEO_PEEK_CANCEL entityId:" + E.nSessionId);
                        }
                        qQAppInterface.getFileManagerEngine().i0(E.nSessionId);
                        return;
                    case 13:
                        if (!this.W.contains(Long.valueOf(j3))) {
                            this.W.add(Long.valueOf(j3));
                        }
                        String string2 = bundle.getString("contextid");
                        com.tencent.mobileqq.filemanager.core.g.c(string2);
                        com.tencent.mobileqq.filemanager.core.g.k(string2, true);
                        if (MessageForTroopFile.class.isInstance(m56)) {
                            Q5(qQAppInterface, m56, j3, i3);
                            return;
                        }
                        return;
                    case 14:
                        com.tencent.mobileqq.filemanager.core.g.g(bundle.getString("contextid"));
                        return;
                    default:
                        return;
                }
            }
            QLog.e("VideoPlayControllerForFile.main", 1, "msg is not video, id:" + j3);
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
        }
    }

    public void C3(MessageForShortVideo messageForShortVideo, long j3, int i3, int i16) {
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (z55 != null) {
            z55.q(messageForShortVideo, j3, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void D(int i3) {
        if (this.f179747d == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "[loadMedias] + loadType: " + i3 + ", dataList.size = " + this.F.size());
        }
        if (i3 != 0) {
            if (i3 == 1 && this.f179747d != null) {
                if (this.F.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    synchronized (this.F) {
                        for (int i16 = 0; i16 < this.F.size(); i16++) {
                            AIORichMediaData aIORichMediaData = this.F.get(i16);
                            if (!L5(aIORichMediaData)) {
                                arrayList.add(aIORichMediaData);
                            }
                        }
                    }
                    this.f179747d.e5((AIORichMediaData[]) arrayList.toArray(new AIORichMediaData[arrayList.size()]), -1);
                    return;
                }
                ThreadManagerV2.excute(this.R, 64, null, false);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(this.R, 64, null, false);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h.a, com.tencent.mobileqq.activity.aio.photo.h
    public void D1(i iVar) {
        super.D1(iVar);
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (z55 != null) {
            z55.A(iVar);
        }
    }

    public Intent D5(MessageForFile messageForFile) {
        try {
            FileManagerEntity E = ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e)).getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
            if (E == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 0);
            bundle.putBoolean("not_forward", true);
            bundle.putParcelable("fileinfo", ForwardFileOption.V(E, messageForFile));
            bundle.putString(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.j_k) + FileManagerUtil.cutLongName(E.fileName) + HardCodeUtil.qqStr(R.string.j_m) + com.tencent.mobileqq.filemanager.util.q.g(E.fileSize) + "\u3002");
            bundle.putBoolean("direct_send_if_dataline_forward", true);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, E.getFilePath());
            bundle.putBoolean("k_favorites", FileManagerUtil.isSupportFavorite(E));
            if (E.getCloudType() == 6 || E.getCloudType() == 7) {
                bundle.putBoolean("isFromShare", true);
                if (E.nFileType == 0) {
                    bundle.putInt("forward_type", 1);
                }
            }
            if (E.getCloudType() == 8 && E.nFileType == 0) {
                bundle.putInt("forward_type", 1);
            }
            intent.putExtras(bundle);
            return intent;
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public Intent E(long j3, int i3) throws RemoteException {
        try {
            ChatMessage n56 = n5(j3, i3);
            if (n56 != null && MessageForPic.class.isInstance(n56)) {
                return QfavBuilder.d0(n56).R((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e), n56).O();
            }
            throw new IllegalArgumentException("message not find..");
        } catch (AccountNotMatchException e16) {
            throw new IllegalArgumentException("no appRuntime", e16);
        }
    }

    protected void E3(List<AIORichMediaData> list) {
        AIORichMediaData[] aIORichMediaDataArr;
        i iVar = this.f179747d;
        if (iVar != null) {
            ArrayList arrayList = new ArrayList();
            int i3 = this.f179590h;
            if (i3 != 1 && i3 != 1026) {
                list = this.F;
            }
            if (i3 != 1 && i3 != 0 && i3 != 3000) {
                synchronized (this.F) {
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        AIORichMediaData aIORichMediaData = list.get(i16);
                        if (!L5(aIORichMediaData)) {
                            arrayList.add(aIORichMediaData);
                        }
                    }
                }
                aIORichMediaDataArr = (AIORichMediaData[]) arrayList.toArray(new AIORichMediaData[arrayList.size()]);
            } else {
                aIORichMediaDataArr = (AIORichMediaData[]) list.toArray(new AIORichMediaData[list.size()]);
            }
            if (aIORichMediaDataArr.length > 0) {
                iVar.e5(aIORichMediaDataArr, -1);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void G(long j3) {
        String u56;
        QQAppInterface t56 = t5();
        if (t56 == null || (u56 = u5(t56, j3)) == null) {
            return;
        }
        DataLineHandler dataLineHandler = (DataLineHandler) t56.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (!dataLineHandler.T.b()) {
            t56.getApplicationContext().startActivity(new Intent(t56.getApplicationContext(), (Class<?>) PrinterDefaultActivity.class));
        } else {
            dataLineHandler.D.d(t56.getApplicationContext(), u56);
        }
    }

    protected void G5(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.i("AIOImageProviderService", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
        }
        if (this.V == null) {
            e eVar = new e();
            this.V = eVar;
            qQAppInterface.addObserver(eVar);
        }
    }

    protected void H5(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.i("AIOImageProviderService", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
        }
        if (this.S == null) {
            this.S = new f();
            qQAppInterface.getFileManagerNotifyCenter().addObserver(this.S);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void I1(long[] jArr) {
        try {
            AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            List<ChatMessage> q56 = q5(jArr);
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "saveToWeiyunMulti, idList.length = " + jArr.length);
            }
            BaseActivity S5 = S5("saveToWeiyunMulti");
            if (S5 != null) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                WeiyunAIOUtils.g(qQAppInterface, S5, S5.getTitleBarHeight(), q56, null);
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009DBA", "0X8009DBA", 0, 0, "", "", "", "");
            }
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
        }
    }

    protected void I5(QQAppInterface qQAppInterface) {
        if (this.U == null) {
            this.U = new HashMap<>();
        }
        if (this.T == null) {
            g gVar = new g();
            this.T = gVar;
            qQAppInterface.addObserver(gVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void J4(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo != null) {
            messageForShortVideo.serial();
            try {
                AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
                if (appRuntime instanceof QQAppInterface) {
                    ((QQAppInterface) appRuntime).getMessageFacade().Y0(messageForShortVideo.frienduin, messageForShortVideo.istroop, messageForShortVideo.uniseq, messageForShortVideo.msgData);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, e16.toString());
                }
            }
        }
    }

    protected boolean K5(MessageForPic messageForPic) {
        int i3 = messageForPic.msgtype;
        if (i3 != -3000 && i3 != -30003) {
            if (ax.a(messageForPic) || ((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(messageForPic)) {
                return true;
            }
            if ((ao.c(this.f179590h) == 1032 && this.f179591i > 0 && messageForPic.getConfessTopicId() != this.f179591i) || ((IPicHelper) QRoute.api(IPicHelper.class)).isEmotion(messageForPic) || ZhituManager.h0(messageForPic)) {
                return true;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOImageProviderService", 2, "LoadMediaTask msgType is " + messageForPic.msgtype);
        }
        return true;
    }

    public void M5() {
        i iVar = this.f179747d;
        if (iVar != null) {
            iVar.e5(null, -1);
        }
    }

    void N5(long j3, int i3, int i16, String str) {
        synchronized (this.F) {
            for (int i17 = 0; i17 < this.F.size(); i17++) {
                AIORichMediaData aIORichMediaData = this.F.get(i17);
                if (AIOImageData.class.isInstance(aIORichMediaData)) {
                    AIOImageData aIOImageData = (AIOImageData) aIORichMediaData;
                    if (aIOImageData.f179628d == j3 && aIOImageData.f179629e == i3) {
                        U5(i16, str, aIOImageData);
                        return;
                    }
                } else if (AIOShortVideoData.class.isInstance(aIORichMediaData)) {
                    AIOShortVideoData aIOShortVideoData = (AIOShortVideoData) aIORichMediaData;
                    if (aIOShortVideoData.f179628d == j3) {
                        W5(i16, str, aIOShortVideoData);
                        return;
                    }
                } else if (AIOFilePicData.class.isInstance(aIORichMediaData)) {
                    AIOFilePicData aIOFilePicData = (AIOFilePicData) aIORichMediaData;
                    if (aIOFilePicData.f179628d == j3) {
                        T5(i16, str, aIOFilePicData);
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    protected void S1(List<AIORichMediaData> list, List<ChatMessage> list2, MessageRecord messageRecord) {
        boolean z16;
        AIORichMediaData aIORichMediaData;
        boolean z17;
        MessageForFile messageForFile = (MessageForFile) messageRecord;
        if (ao.c(this.f179590h) == 1032 && this.f179591i > 0 && messageRecord.getConfessTopicId() != this.f179591i) {
            return;
        }
        FileManagerEntity E = x5().getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
        boolean z18 = false;
        if (E != null && ((FileManagerUtil.hasThumb(E) && E.nFileType != 2) || 16 != E.status)) {
            int i3 = E.nFileType;
            if (i3 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i3 == 2) {
                z18 = true;
            }
            z16 = z18;
            z18 = z17;
        } else {
            z16 = false;
        }
        if (z18) {
            messageForFile.parse();
            aIORichMediaData = com.tencent.mobileqq.activity.aio.photo.c.o(messageForFile, x5());
        } else if (z16) {
            messageForFile.parse();
            aIORichMediaData = com.tencent.mobileqq.activity.aio.photo.c.o(messageForFile, x5());
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "ignore filePic: " + messageForFile);
            }
            aIORichMediaData = null;
        }
        if (aIORichMediaData != null) {
            list.add(aIORichMediaData);
            list2.add(messageForFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public BaseActivity S5(String str) {
        String str2;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            this.Q = new WeakReference<>(baseActivity);
            return baseActivity;
        }
        WeakReference<BaseActivity> weakReference = this.Q;
        if (weakReference != null) {
            baseActivity = weakReference.get();
            str2 = null;
        } else {
            str2 = "WeakReference Null";
        }
        if (baseActivity != null) {
            return baseActivity;
        }
        if (str2 == null) {
            str2 = "WeakReference has freed";
        }
        P5(str2, str);
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void T3() {
        this.f179747d = null;
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (z55 != null) {
            z55.N();
        }
    }

    protected void U1(List<AIORichMediaData> list, List<ChatMessage> list2, MessageForMixedMsg messageForMixedMsg) {
        messageForMixedMsg.parse();
        for (MessageRecord messageRecord : messageForMixedMsg.msgElemList) {
            if (messageRecord instanceof MessageForPic) {
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                if (!K5(messageForPic)) {
                    messageForPic.isInMixedMsg = true;
                    list.add(r5(messageForPic));
                    list2.add(messageForPic);
                }
            }
        }
    }

    protected void W1(List<AIORichMediaData> list, List<ChatMessage> list2, MessageRecord messageRecord) {
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        messageForPic.parse();
        if (K5(messageForPic)) {
            return;
        }
        list.add(r5(messageForPic));
        list2.add(messageForPic);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public MessageForShortVideo Y1(long j3) {
        MessageForShortVideo messageForShortVideo;
        synchronized (this.E) {
            Iterator<ChatMessage> it = this.E.iterator();
            while (true) {
                if (it.hasNext()) {
                    ChatMessage next = it.next();
                    if (j3 == next.uniseq && MessageForShortVideo.class.isInstance(next)) {
                        messageForShortVideo = (MessageForShortVideo) next;
                        break;
                    }
                } else {
                    messageForShortVideo = null;
                    break;
                }
            }
        }
        return messageForShortVideo;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void b(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "reportData,sendReportType:" + str + ",count:" + i3);
        }
        try {
            AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            if (i3 == 55) {
                com.tencent.mobileqq.activity.photo.m.q(str, this.f179590h, (QQAppInterface) appRuntime);
            } else {
                StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(appRuntime, this.f179588e, "Pic", str, 0, 1, null, String.valueOf(i3), null, null, null);
            }
        } catch (AccountNotMatchException e16) {
            throw new IllegalArgumentException("no appRuntime", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public String c2(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "AIOImageProviderService").nickInfo.getShowName();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void d(long j3) {
        ChatMessage m56 = m5(j3);
        try {
            try {
                AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
                if (m56 != null) {
                    if (MessageForFile.class.isInstance(m56)) {
                        MessageForFile messageForFile = (MessageForFile) m56;
                        FileManagerEntity E = ((QQAppInterface) appRuntime).getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
                        if (E == null) {
                            return;
                        }
                        Intent intent = new Intent(BaseApplicationImpl.sApplication.getBaseContext(), (Class<?>) FilePicQFavActivity.class);
                        intent.putExtra("file_pic_favorites", E.nSessionId);
                        BaseApplicationImpl.sApplication.getBaseContext().startActivity(intent);
                        return;
                    }
                    if (MessageForTroopFile.class.isInstance(m56)) {
                        MessageForTroopFile messageForTroopFile = (MessageForTroopFile) m56;
                        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                        t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
                        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(m3);
                        com.tencent.mobileqq.troop.data.n A = TroopFileManager.F(qQAppInterface, m3.f294971e).A(newEntityByTroopFileInfo.strTroopFilePath);
                        if (A != null) {
                            newEntityByTroopFileInfo.lastTime = A.f294923i;
                            newEntityByTroopFileInfo.selfUin = String.valueOf(A.f294920f);
                        }
                        Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                        if (baseContext != null) {
                            new QfavBuilder(3).u(qQAppInterface, baseContext, newEntityByTroopFileInfo, m56, false);
                        } else {
                            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save fav].");
                        }
                        if (messageForTroopFile.isMultiMsg) {
                            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
                        }
                    }
                }
            } catch (AccountNotMatchException e16) {
                e = e16;
                e.printStackTrace();
                QLog.e("AIOImageProviderService", 1, "getAppRuntime Exception!");
            }
        } catch (AccountNotMatchException e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h.a, com.tencent.mobileqq.activity.aio.photo.h
    public void destory() {
        super.destory();
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "[destroy] " + this.f179588e + "_" + this.f179589f + "_" + this.f179590h);
        }
        this.E.clear();
        this.F.clear();
        X.remove(w5());
        this.f179589f = null;
        this.f179590h = 0;
        this.M = 60;
        FMObserver fMObserver = this.S;
        if (fMObserver != null) {
            try {
                if (fMObserver instanceof f) {
                    ((f) fMObserver).e1();
                }
                ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e)).getFileManagerNotifyCenter().deleteObserver(this.S);
                this.S = null;
                QLog.i("AIOImageProviderService<QFile>", 1, "clear fmObserver suc");
            } catch (AccountNotMatchException e16) {
                QLog.i("AIOImageProviderService<QFile>", 1, "clear fmObserver, but AccountNotMatchException");
                e16.printStackTrace();
            }
        }
        if (this.T != null) {
            try {
                ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e)).removeObserver(this.T);
                this.T = null;
                QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver suc");
            } catch (AccountNotMatchException e17) {
                QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver, but AccountNotMatchException");
                e17.printStackTrace();
            }
        }
        if (this.V != null) {
            try {
                x5().removeObserver(this.V);
                this.S = null;
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
        HashMap<String, MessageForTroopFile> hashMap = this.U;
        if (hashMap != null) {
            hashMap.clear();
            this.U = null;
        }
        QLog.e("AIOImageProviderService", 1, "\uff5e\uff5e\uff5e\uff5e\uff5e\uff5e\uff5edestory AIOImageProviderService\uff5e\uff5e\uff5e\uff5e\uff5e\uff5e\uff5e");
        this.f179588e = null;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void f(long j3) {
        String str;
        try {
            AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            ChatMessage m56 = m5(j3);
            if (m56 != null) {
                if (MessageForFile.class.isInstance(m56)) {
                    MessageForFile messageForFile = (MessageForFile) m56;
                    if (messageForFile.uniseq == j3) {
                        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                        FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
                        if (E == null) {
                            return;
                        }
                        int cloudType = E.getCloudType();
                        if (cloudType != 1) {
                            if (cloudType == 3 || cloudType == 5) {
                                qQAppInterface.getFileManagerEngine().F0(E.getFilePath(), null, appRuntime.getAccount(), "", 0, false);
                                return;
                            }
                            return;
                        }
                        if (messageForFile.isSend()) {
                            str = qQAppInterface.getCurrentAccountUin();
                        } else {
                            str = E.peerUin;
                        }
                        qQAppInterface.getFileManagerEngine().v0(E, str);
                        return;
                    }
                    return;
                }
                if (MessageForTroopFile.class.isInstance(m56)) {
                    Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                    if (baseContext != null) {
                        TroopFileUtils.D(baseContext, (QQAppInterface) appRuntime, m56);
                        return;
                    } else {
                        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file to weiyun].");
                        return;
                    }
                }
                if (m56 instanceof MessageForPic) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOImageProviderService", 2, "saveToWeiyun, save single pic, uniseq = " + m56.uniseq);
                    }
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(m56);
                    BaseActivity S5 = S5("saveToWeiyun_MessageForPic");
                    if (S5 != null) {
                        QQAppInterface qQAppInterface2 = (QQAppInterface) appRuntime;
                        WeiyunAIOUtils.s(qQAppInterface2, S5, S5.getTitleBarHeight(), arrayList, null);
                        ReportController.o(qQAppInterface2, "dc00898", "", m56.frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                if (m56 instanceof MessageForShortVideo) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOImageProviderService", 2, "saveToWeiyun, save single video, uniseq = " + m56.uniseq);
                    }
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(m56);
                    BaseActivity S52 = S5("saveToWeiyun_MessageForShortVideo");
                    if (S52 != null) {
                        QQAppInterface qQAppInterface3 = (QQAppInterface) appRuntime;
                        WeiyunAIOUtils.s(qQAppInterface3, S52, S52.getTitleBarHeight(), arrayList2, null);
                        ReportController.o(qQAppInterface3, "dc00898", "", m56.frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
                    }
                }
            }
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void f5(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "cleanMessage type = " + i3);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                ag.a(str, i3, (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e));
            } catch (AccountNotMatchException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, "cleanMessage exception = " + e16.getMessage());
                }
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void g(final int i3, final boolean z16, final String str, final String str2, final String str3, final String str4) {
        final BaseActivity S5 = S5("safetyReport");
        if (S5 != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.6
                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        NewReportPlugin.R(S5.app, str2, str, str3, str4);
                    } else {
                        NewReportPlugin.T(S5, str, str2, str3, NewReportPlugin.u(i3), str3);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void h(final long j3, final int i3) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.4
            @Override // java.lang.Runnable
            public void run() {
                ChatMessage n56;
                List<ChatMessage> list = AIOImageProviderService.this.E;
                if (list != null && list.size() != 0 && (n56 = AIOImageProviderService.this.n5(j3, i3)) != null && MessageForPic.class.isInstance(n56)) {
                    MessageForPic messageForPic = (MessageForPic) n56;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOImageProviderService", 2, "payFlow,id:" + j3 + ",subId:" + i3);
                        }
                        AIOImageProviderService.O5((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(AIOImageProviderService.this.f179588e), messageForPic);
                    } catch (AccountNotMatchException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOImageProviderService", 2, "no appRuntime");
                        }
                    }
                }
            }
        });
    }

    public void h1(MessageForPic messageForPic, long j3, int i3, int i16) {
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (i16 != 24 && z55 != null && z55.x(messageForPic)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "cancelDownloadImage return");
                return;
            }
            return;
        }
        if (i16 == 24 && z55 != null) {
            try {
                z55.h(messageForPic, j3, i3, i16);
            } catch (AccountNotMatchException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, "no appRuntime");
                    return;
                }
                return;
            }
        }
        IHttpCommunicatorListener findProcessor = ((ITransFileController) ((QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e)).getRuntimeService(ITransFileController.class)).findProcessor(BaseTransFileController.makeReceiveKey(messageForPic.md5, messageForPic.uuid, 131075));
        if (findProcessor instanceof BaseDownloadProcessor) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + findProcessor);
            }
            ((BaseDownloadProcessor) findProcessor).cancel();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "destroy cancel fail");
        }
    }

    protected void h2(List<AIORichMediaData> list, List<ChatMessage> list2, MessageRecord messageRecord) {
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
        int i3 = messageForShortVideo.busiType;
        if (i3 != 1 && i3 != 2 && i3 != 1007 && i3 != 1009 && i3 != 0 && i3 != 4601) {
            return;
        }
        list.add(com.tencent.mobileqq.activity.aio.photo.c.u(messageForShortVideo));
        list2.add(messageForShortVideo);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void h4(final long j3) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(AIOImageProviderService.this.f179588e);
                    ChatMessage m56 = AIOImageProviderService.this.m5(j3);
                    if (m56 != null) {
                        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                        if (ax.a(m56)) {
                            ax.c(m56);
                        } else {
                            ((IPicFlash) QRoute.api(IPicFlash.class)).setFlashPicMsgReaded(m56);
                            Iterator<MessageRecord> it = messageFacade.Q(m56.frienduin, m56.msgtype).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                MessageRecord next = it.next();
                                if (next.uniseq == j3) {
                                    ((IPicFlash) QRoute.api(IPicFlash.class)).setFlashPicMsgReaded(next);
                                    break;
                                }
                            }
                        }
                        messageFacade.a1(m56.frienduin, m56.istroop, m56.uniseq, AppConstants.Key.COLUMN_EXT_STR, m56.extStr);
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.HOTCHAT, 2, "makeFlashPicReaded,uin:" + AIOImageProviderService.this.f179589f + ",type:" + m56.istroop + ",extStr" + m56.extStr);
                        }
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005979", "0X8005979", 0, 0, "", "", "", "");
                } catch (AccountNotMatchException unused) {
                    QLog.d(LogTag.HOTCHAT, 2, "setFlashPicReaded\uff0caccount no match exception");
                }
            }
        });
    }

    public void h5(MessageForFile messageForFile, long j3, int i3, int i16) {
        try {
            AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            FileManagerEntity i17 = ((QQAppInterface) appRuntime).getFileManagerDataCenter().i(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
            if (i17 == null) {
                return;
            }
            FileManagerEntity D = ((QQAppInterface) appRuntime).getFileManagerDataCenter().D(i17.nSessionId);
            if (D != null) {
                if (TextUtils.isEmpty(messageForFile.fileName)) {
                    messageForFile.fileName = D.fileName;
                }
                i17 = D;
            }
            if (J5(messageForFile)) {
                if (QLog.isColorLevel()) {
                    QLog.i("AIOImageProviderService", 1, "msg is video, isTroop: " + messageForFile.istroop);
                }
                if (i17.getCloudType() == 12) {
                    v5(j3, i3, i16, (com.tencent.mobileqq.filemanager.fileviewer.data.b) ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).getNewVideoForGuild((QQAppInterface) appRuntime, D));
                    return;
                } else if (messageForFile.istroop == 3000) {
                    v5(j3, i3, i16, new com.tencent.mobileqq.filemanager.fileviewer.data.g((QQAppInterface) appRuntime, D));
                    return;
                } else {
                    v5(j3, i3, i16, new VideoForC2C((QQAppInterface) appRuntime, D));
                    return;
                }
            }
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 4) {
                        return;
                    }
                    ((QQAppInterface) appRuntime).getFileManagerEngine().t0(i17);
                    return;
                } else {
                    i17.mContext = new String("igonFlow");
                    ((QQAppInterface) appRuntime).getFileManagerEngine().m(i17, 7);
                    return;
                }
            }
            i17.mContext = new String("igonFlow");
            ((QQAppInterface) appRuntime).getFileManagerEngine().m(i17, 5);
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(1:(2:4|(2:6|(2:8|9)(1:11))(1:12))(10:42|14|15|16|17|18|19|(1:23)|21|22))(1:43)|13|14|15|16|17|18|19|(0)|21|22|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(7:(1:(2:4|(2:6|(2:8|9)(1:11))(1:12))(10:42|14|15|16|17|18|19|(1:23)|21|22))(1:43)|17|18|19|(0)|21|22)|13|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
    
        com.tencent.qphone.base.util.QLog.d("AIOImageProviderService", 2, "downloadImage, no appRuntime");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0092, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i5(MessageForPic messageForPic, long j3, int i3, int i16) {
        com.tencent.mobileqq.pic.p createPicReq;
        int i17;
        com.tencent.mobileqq.pic.p pVar;
        int i18 = 1;
        try {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 4) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOImageProviderService", 2, "downloadImage fail, businessType not recognize");
                            return;
                        }
                        return;
                    }
                    createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(7, 1);
                    i17 = 131075;
                } else {
                    pVar = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(6, 1536, 1);
                    pVar.d(messageForPic, messageForPic.getPicDownloadInfo());
                    pVar.g(new a(j3, i3, i16, messageForPic.size, AbsDownloader.getFilePath(URLDrawableHelper.getURL(messageForPic, i18, null).toString().toString())));
                    BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
                    ((IPicBus) QRoute.api(IPicBus.class)).launch(pVar);
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d("AIOImageProviderService", 2, "downloadImage end");
                    return;
                }
            } else {
                createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(5, 1);
                i17 = 65537;
            }
            BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            ((IPicBus) QRoute.api(IPicBus.class)).launch(pVar);
            if (!QLog.isColorLevel()) {
            }
            QLog.d("AIOImageProviderService", 2, "downloadImage end");
            return;
        } catch (Throwable th5) {
            th = th5;
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "downloadImage end");
            }
            throw th;
        }
        pVar = createPicReq;
        i18 = i17;
        pVar.d(messageForPic, messageForPic.getPicDownloadInfo());
        pVar.g(new a(j3, i3, i16, messageForPic.size, AbsDownloader.getFilePath(URLDrawableHelper.getURL(messageForPic, i18, null).toString().toString())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageForShortVideo messageForShortVideo, int i17, Bundle bundle) {
        i iVar = this.f179747d;
        if (iVar != null) {
            iVar.j0(j3, i3, i16, str, strArr, str2, messageForShortVideo, i17, bundle);
        }
    }

    protected void j2(List<AIORichMediaData> list, List<ChatMessage> list2, MessageRecord messageRecord) {
        StructMsgForImageShare structMsgForImageShare;
        com.tencent.mobileqq.structmsg.view.e firstImageElement;
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        messageForStructing.parse();
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg != null) {
            int i3 = absStructMsg.mMsgServiceID;
            if ((i3 == 5 || i3 == 137) && (firstImageElement = (structMsgForImageShare = (StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
                MessageForPic messageForPic = firstImageElement.f290638c1;
                if (messageForPic == null) {
                    if (firstImageElement.f290637b1 == null) {
                        firstImageElement.f290637b1 = structMsgForImageShare;
                    }
                    messageForPic = firstImageElement.m();
                }
                AIOImageData r56 = r5(messageForPic);
                r56.f179630f = messageForStructing.time;
                r56.f179632i = messageForStructing.shmsgseq;
                String str = structMsgForImageShare.mMsgActionData;
                if (str != null && str.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
                    r56.Y = 1;
                    r56.Z = structMsgForImageShare.getBytes();
                    r56.f179575f0 = com.tencent.mobileqq.richmediabrowser.j.c(((IPictureBusinessApi) QRoute.api(IPictureBusinessApi.class)).parseQQComicParams(structMsgForImageShare));
                } else {
                    String str2 = structMsgForImageShare.mMsgActionData;
                    if (str2 != null && str2.startsWith("ScreenShotShare")) {
                        r56.Y = 2;
                        r56.Z = structMsgForImageShare.getBytes();
                        if (com.tencent.mobileqq.service.message.remote.a.c(messageRecord.issend) && !TextUtils.isEmpty(messageForPic.path) && new File(messageForPic.path).exists()) {
                            r56.G = messageForPic.path;
                        }
                    } else if (((IGameShareUtil) QRoute.api(IGameShareUtil.class)).isGameShare(structMsgForImageShare)) {
                        r56.Y = 5;
                        ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).convertDataForGallery(r56, structMsgForImageShare);
                    }
                }
                list.add(r56);
                list2.add(messageForPic);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j5(MessageForTroopFile messageForTroopFile, long j3, int i3, int i16) {
        QQAppInterface qQAppInterface;
        QQAppInterface qQAppInterface2;
        try {
        } catch (AccountNotMatchException e16) {
            e = e16;
        }
        try {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
        } catch (AccountNotMatchException e17) {
            e = e17;
            e.printStackTrace();
            qQAppInterface = null;
            qQAppInterface2 = qQAppInterface;
            if (qQAppInterface2 != null) {
            }
        }
        qQAppInterface2 = qQAppInterface;
        if (qQAppInterface2 != null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, app == null");
                return;
            }
            return;
        }
        t m3 = TroopFileUtils.m(qQAppInterface2, messageForTroopFile);
        if (m3 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info == null");
                return;
            }
            return;
        }
        if (J5(messageForTroopFile)) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 1, "troop file is video, getUrl");
            }
            v5(j3, i3, i16, new com.tencent.mobileqq.filemanager.fileviewer.data.i(m3));
            return;
        }
        if (TextUtils.isEmpty(m3.f294985s)) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info.FilePath is empty");
                return;
            }
            return;
        }
        String str = messageForTroopFile.frienduin;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i16 == 4) {
            A5(qQAppInterface2, m3, str, j3, i3, i16);
        } else if (i16 == 2) {
            B5(qQAppInterface2, m3, str, messageForTroopFile, j3, i3, i16);
        } else if (i16 == 1) {
            C5(qQAppInterface2, m3, str, messageForTroopFile, j3, i3, i16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    @Override // com.tencent.mobileqq.activity.aio.photo.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int k(long j3, int i3) {
        int i16;
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (z55 != null) {
            ChatMessage n56 = n5(j3, i3);
            if (n56 == null && QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "getSaveFileProgress chatMessage is null");
            }
            com.tencent.mobileqq.multimsg.save.d u16 = z55.u(z55.s(n56));
            if (u16 != null && !u16.f251678a && u16.f251683f == 1) {
                i16 = u16.f251682e;
                if (QLog.isColorLevel()) {
                    QLog.i("AIOImageProviderService", 2, "getSaveFileProgress progress = " + i16);
                }
                return i16;
            }
        }
        i16 = -1;
        if (QLog.isColorLevel()) {
        }
        return i16;
    }

    public void k5(MessageForShortVideo messageForShortVideo, long j3, int i3, int i16) {
        int i17;
        try {
            AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            int i18 = messageForShortVideo.busiType;
            if ((i18 == 0 || (i18 == 4601 && messageForShortVideo.subBusiType == 4601)) && (appRuntime instanceof QQAppInterface) && i16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, "carverW downloadVideo GetUrlAction");
                }
                new com.tencent.mobileqq.activity.aio.photo.g((QQAppInterface) appRuntime, messageForShortVideo, this.f179747d, j3, i3, i16).a();
                return;
            }
            v b16 = com.tencent.mobileqq.shortvideo.h.b(2, 2);
            com.tencent.mobileqq.shortvideo.n downloadInfo = messageForShortVideo.getDownloadInfo(b16.f288265e);
            if (i16 == 0) {
                downloadInfo.f288194r = com.tencent.mobileqq.shortvideo.j.l(messageForShortVideo.thumbMD5, "jpg");
                downloadInfo.c(messageForShortVideo.istroop, 1);
            } else {
                downloadInfo.f288193q = com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4");
                downloadInfo.c(messageForShortVideo.istroop, 0);
            }
            b16.c(downloadInfo);
            i17 = 2;
            try {
                b16.h(new b(j3, i3, i16));
                com.tencent.mobileqq.shortvideo.l.e(b16, (QQAppInterface) appRuntime);
            } catch (AccountNotMatchException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", i17, "no appRuntime");
                }
            }
        } catch (AccountNotMatchException unused2) {
            i17 = 2;
        }
    }

    public ChatMessage l5(long j3) {
        boolean z16;
        ChatMessage chatMessage;
        boolean z17;
        synchronized (this.E) {
            z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 < this.E.size()) {
                    chatMessage = this.E.get(i3);
                    if (j3 == chatMessage.uniseq) {
                        z17 = true;
                        break;
                    }
                    i3++;
                } else {
                    chatMessage = null;
                    z17 = false;
                    break;
                }
            }
            if (z17) {
                this.E.remove(i3);
            }
        }
        synchronized (this.F) {
            int i16 = 0;
            while (true) {
                if (i16 >= this.F.size()) {
                    break;
                }
                if (this.F.get(i16).f179628d == j3) {
                    z16 = true;
                    break;
                }
                i16++;
            }
            if (z16) {
                this.F.remove(i16);
            }
        }
        return chatMessage;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void m(long j3) {
        try {
            AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
            ChatMessage m56 = m5(j3);
            if (m56 == null) {
                return;
            }
            if (MessageForFile.class.isInstance(m56)) {
                Context baseContext = BaseApplicationImpl.sApplication.getBaseContext();
                if (baseContext != null) {
                    FileManagerUtil.initSaveToPc((QQAppInterface) appRuntime, m56, baseContext);
                    return;
                } else {
                    QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file send pc].");
                    return;
                }
            }
            if (MessageForTroopFile.class.isInstance(m56)) {
                Context baseContext2 = BaseApplicationImpl.sApplication.getBaseContext();
                if (baseContext2 != null) {
                    TroopFileUtils.E(baseContext2, (QQAppInterface) appRuntime, m56);
                } else {
                    QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file send pc].");
                }
            }
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
        }
    }

    public ChatMessage m5(long j3) {
        ChatMessage chatMessage;
        synchronized (this.E) {
            Iterator<ChatMessage> it = this.E.iterator();
            while (true) {
                if (it.hasNext()) {
                    chatMessage = it.next();
                    if (j3 == chatMessage.uniseq) {
                        break;
                    }
                } else {
                    chatMessage = null;
                    break;
                }
            }
        }
        return chatMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyImageProgress(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        i iVar = this.f179747d;
        if (iVar != null) {
            iVar.notifyImageProgress(j3, i3, i16, i17, j16, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyImageResult(long j3, int i3, int i16, int i17, String str, boolean z16) {
        i iVar = this.f179747d;
        if (iVar != null) {
            iVar.notifyImageResult(j3, i3, i16, i17, str, z16);
        }
    }

    public List<ChatMessage> q5(long[] jArr) {
        ArrayList arrayList = new ArrayList();
        for (long j3 : jArr) {
            ChatMessage m56 = m5(j3);
            if (m56 != null) {
                arrayList.add(m56);
            }
        }
        return arrayList;
    }

    protected AIOImageData r5(MessageForPic messageForPic) {
        return com.tencent.mobileqq.activity.aio.photo.c.t(messageForPic);
    }

    public void s1(MessageForTroopFile messageForTroopFile) {
        QQAppInterface qQAppInterface;
        try {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, app == null");
                return;
            }
            return;
        }
        messageForTroopFile.isPause = true;
        t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
        if (m3 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, info == null");
                return;
            }
            return;
        }
        String str = messageForTroopFile.frienduin;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.valueOf(str).longValue());
        if (m3.f294972f == 8) {
            O.C0(m3.f294967a);
            O.p(m3.f294967a);
        }
    }

    protected List<MessageRecord> s5(int[] iArr) {
        List<MessageRecord> m3 = x5().getMessageProxy(this.f179590h).m(this.f179589f, this.f179590h, iArr);
        if (m3.size() < 60) {
            List<MessageRecord> E = x5().getMessageFacade().E(this.f179589f, this.f179590h, iArr, 60);
            this.M = E.size();
            return E;
        }
        return m3;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public Intent u(long j3, int i3, int i16) {
        ChatMessage n56 = n5(j3, i3);
        if (n56 == null) {
            return null;
        }
        if (MessageForPic.class.isInstance(n56)) {
            return null;
        }
        if (MessageForShortVideo.class.isInstance(n56)) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) n56;
            if (messageForShortVideo.uniseq != j3) {
                return null;
            }
            Intent E5 = E5(messageForShortVideo);
            if (E5 != null) {
                E5.putExtra(ShortVideoConstants.FROM_UIN_TYPE, i16);
                return E5;
            }
            return E5;
        }
        if (MessageForFile.class.isInstance(n56)) {
            MessageForFile messageForFile = (MessageForFile) n56;
            if (messageForFile.uniseq != j3) {
                return null;
            }
            return D5(messageForFile);
        }
        if (!MessageForTroopFile.class.isInstance(n56)) {
            return null;
        }
        MessageForTroopFile messageForTroopFile = (MessageForTroopFile) n56;
        if (messageForTroopFile.uniseq != j3) {
            QLog.e("AIOImageProviderService", 1, "msg id : " + messageForTroopFile.uniseq + " request id:" + j3);
            return null;
        }
        return F5(messageForTroopFile);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQAppInterface x5() {
        try {
            return (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(this.f179588e);
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("AIOImageProviderService", 2, "no appRuntime");
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.h
    public void y(final long j3, final int i3, final int i16) {
        ChatMessage n56 = n5(j3, i3);
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "carverW downloadMedia type=" + i16 + " id=" + j3);
        }
        if (n56 != null) {
            if (MessageForPic.class.isInstance(n56)) {
                MessageForPic messageForPic = (MessageForPic) n56;
                if (i16 == 24) {
                    q3(messageForPic, j3, i3, i16);
                    return;
                } else {
                    i5(messageForPic, j3, i3, i16);
                    return;
                }
            }
            if (MessageForShortVideo.class.isInstance(n56)) {
                MessageForShortVideo messageForShortVideo = (MessageForShortVideo) n56;
                if (i16 == 256) {
                    C3(messageForShortVideo, j3, i3, i16);
                    return;
                } else {
                    k5(messageForShortVideo, j3, i3, i16);
                    return;
                }
            }
            if (MessageForFile.class.isInstance(n56)) {
                final MessageForFile messageForFile = (MessageForFile) n56;
                Looper mainLooper = Looper.getMainLooper();
                if (Thread.currentThread() != mainLooper.getThread()) {
                    new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AIOImageProviderService.this.h5(messageForFile, j3, i3, i16);
                        }
                    });
                    return;
                } else {
                    h5(messageForFile, j3, i3, i16);
                    return;
                }
            }
            if (MessageForTroopFile.class.isInstance(n56)) {
                MessageForTroopFile messageForTroopFile = (MessageForTroopFile) n56;
                messageForTroopFile.isPause = false;
                j5(messageForTroopFile, j3, i3, i16);
                return;
            } else if (MessageForDLFile.class.isInstance(n56)) {
                g4((MessageForDLFile) n56, j3, i3, i16);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOImageProviderService", 2, "downloadMedia fail, msg type not recognize");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "downloadMedia fail, not find msg");
        }
    }

    public List<AIORichMediaData> y5() {
        return this.F;
    }

    public void z1(MessageForShortVideo messageForShortVideo, long j3, int i3, int i16) {
        com.tencent.mobileqq.multimsg.save.h z55 = z5();
        if (z55 != null) {
            z55.i(messageForShortVideo, j3, i3, i16);
        }
    }

    public AIOImageProviderService(String str, String str2, int i3, ChatMessage chatMessage) {
        this.f179592m = false;
        this.C = false;
        List<ChatMessage> synchronizedList = Collections.synchronizedList(new LinkedList());
        this.E = synchronizedList;
        this.F = Collections.synchronizedList(new LinkedList());
        this.G = false;
        this.H = false;
        this.I = Long.MAX_VALUE;
        this.J = Long.MAX_VALUE;
        this.K = 3;
        this.L = Long.MAX_VALUE;
        this.M = 60;
        this.N = 0;
        this.Q = null;
        this.R = new IncreasinglyLoadMediaTask();
        this.W = new ArrayList<>();
        this.f179588e = str;
        this.f179589f = str2;
        this.f179590h = i3;
        if (chatMessage != null) {
            this.f179592m = chatMessage.isMultiMsg;
            this.D = chatMessage.msgseq;
            synchronizedList.add(chatMessage);
            if (ao.c(chatMessage.istroop) == 1032) {
                this.f179591i = chatMessage.getConfessTopicId();
            }
        }
        this.P = new WeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), null);
        this.C = ((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(chatMessage);
        if (!this.f179592m) {
            String w55 = w5();
            HashMap<String, AIOImageProviderService> hashMap = X;
            AIOImageProviderService aIOImageProviderService = hashMap.get(w55);
            if (aIOImageProviderService != null) {
                aIOImageProviderService.destory();
            }
            hashMap.put(w55, this);
        }
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(str);
            H5(qQAppInterface);
            I5(qQAppInterface);
            G5(qQAppInterface);
            QLog.e("AIOImageProviderService", 1, "\uff5e\uff5e\uff5e\uff5e\uff5e\uff5e\uff5ecall AIOImageProviderService\uff5e\uff5e\uff5e\uff5e\uff5e\uff5e\uff5e");
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            this.Q = new WeakReference<>(baseActivity);
        } else {
            P5("Static Null", QZoneCoverStoreJsPlugin.INIT_PLUGIN);
        }
    }
}
