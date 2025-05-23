package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavOtherFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavVideoFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.api.impl.QQFileSelectorImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.msg.api.IRichMediaService;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileTabBarView extends RelativeLayout implements View.OnClickListener, QfileBaseFavFileTabView.d {
    HorizontalScrollView C;
    TabBarView2 D;
    RelativeLayout E;
    QfileBaseTabView F;
    BaseFileAssistantActivity G;
    HeaderScrollView H;
    HashMap<Integer, Class<? extends QfileBaseTabView>> I;
    HashMap<Integer, QfileBaseTabView> J;
    HashMap<Integer, Integer> K;
    boolean L;
    private TabBarView.d M;

    /* renamed from: d, reason: collision with root package name */
    public int f209464d;

    /* renamed from: e, reason: collision with root package name */
    public int f209465e;

    /* renamed from: f, reason: collision with root package name */
    String f209466f;

    /* renamed from: h, reason: collision with root package name */
    boolean f209467h;

    /* renamed from: i, reason: collision with root package name */
    private int f209468i;

    /* renamed from: m, reason: collision with root package name */
    private int f209469m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Function0<List<String>> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> invoke() {
            return ((IRichMediaService) QRoute.api(IRichMediaService.class)).getFileMediaFileDirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Function0<List<String>> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> invoke() {
            return ((IRichMediaService) QRoute.api(IRichMediaService.class)).getPicMediaFileDirs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements Function0<List<String>> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> invoke() {
            return ((IRichMediaService) QRoute.api(IRichMediaService.class)).getPicMediaFileDirs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Function0<List<String>> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> invoke() {
            return ((IRichMediaService) QRoute.api(IRichMediaService.class)).getFileMediaFileDirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements Function0<List<String>> {
        e() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> invoke() {
            return ((IRichMediaService) QRoute.api(IRichMediaService.class)).getFileMediaFileDirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements Function0<List<String>> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> invoke() {
            return ((IRichMediaService) QRoute.api(IRichMediaService.class)).getVideoMediaFileDirs();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements TabBarView.d {
        g() {
        }

        @Override // com.tencent.mobileqq.widget.TabBarView.d
        public void a(int i3, int i16) {
            if (QfileTabBarView.this.s(i16) == null) {
                return;
            }
            QfileTabBarView.this.x(i16);
            QfileTabBarView qfileTabBarView = QfileTabBarView.this;
            if (qfileTabBarView.f209467h) {
                try {
                    SharedPreferences.Editor edit = qfileTabBarView.G.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
                    edit.putInt("last_select_tab_view", QfileTabBarView.this.K.get(Integer.valueOf(i16)).intValue());
                    edit.commit();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private String f209477a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f209478b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f209479c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f209480d;

        public h(String str, boolean z16, boolean z17, boolean z18) {
            this.f209477a = str;
            this.f209478b = z16;
            this.f209479c = z17;
            this.f209480d = z18;
        }

        public String a() {
            return this.f209477a;
        }
    }

    public QfileTabBarView(Context context) {
        this(context, null);
    }

    private void c(@NotNull List<h> list, @NotNull Function0<List<String>> function0) {
        if (!((IGuildUserService) this.G.getApp().getRuntimeService(IGuildUserService.class)).isGuildUser()) {
            return;
        }
        for (String str : function0.invoke()) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(AppConstants.SDCARD_FILE_SAVE_PATH)) {
                list.add(new h(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(str), true, true, true));
            }
        }
    }

    private QfileBaseTabView f(int i3) {
        QfileFavFileRecordProvider qfileFavFileRecordProvider = ((QQFileSelectorImpl) QRoute.api(IQQFileSelector.class)).getQfileFavFileRecordProvider(this.G.getApp());
        switch (i3) {
            case 1200:
                QfileFavVideoFileTabView qfileFavVideoFileTabView = new QfileFavVideoFileTabView(this.G, qfileFavFileRecordProvider, this);
                qfileFavVideoFileTabView.y();
                return qfileFavVideoFileTabView;
            case 1201:
                QfileFavPicFileTabView qfileFavPicFileTabView = new QfileFavPicFileTabView(this.G, qfileFavFileRecordProvider, this);
                qfileFavPicFileTabView.y();
                return qfileFavPicFileTabView;
            case 1202:
                QfileFavDocFileTabView qfileFavDocFileTabView = new QfileFavDocFileTabView(this.G, qfileFavFileRecordProvider, this);
                qfileFavDocFileTabView.y();
                return qfileFavDocFileTabView;
            case 1203:
                QfileFavAppFileTabView qfileFavAppFileTabView = new QfileFavAppFileTabView(this.G, qfileFavFileRecordProvider, this);
                qfileFavAppFileTabView.y();
                return qfileFavAppFileTabView;
            case 1204:
                QfileFavOtherFileTabView qfileFavOtherFileTabView = new QfileFavOtherFileTabView(this.G, qfileFavFileRecordProvider, this);
                qfileFavOtherFileTabView.y();
                return qfileFavOtherFileTabView;
            default:
                return null;
        }
    }

    private QfileBaseTabView g(int i3) {
        boolean z16;
        if (this.G.getTabType() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        String h16 = j.h();
        ArrayList arrayList = new ArrayList();
        String str = AppConstants.SDCARD_FILE_SAVE_PATH;
        arrayList.add(new h(str, false, false, true));
        if (i3 != 110) {
            if (i3 != 111) {
                if (i3 != 114) {
                    if (i3 != 118) {
                        if (i3 != 119) {
                            switch (i3) {
                                case 8:
                                    QfileLocalFileAppTabView qfileLocalFileAppTabView = new QfileLocalFileAppTabView(this.G, arrayList, true);
                                    qfileLocalFileAppTabView.y();
                                    return qfileLocalFileAppTabView;
                                case 9:
                                    QfileLocalFilePicTabView qfileLocalFilePicTabView = new QfileLocalFilePicTabView(this.G, arrayList, true);
                                    qfileLocalFilePicTabView.y();
                                    return qfileLocalFilePicTabView;
                                case 10:
                                    QfileLocalFileDocTabView qfileLocalFileDocTabView = new QfileLocalFileDocTabView(this.G, arrayList, true);
                                    qfileLocalFileDocTabView.y();
                                    return qfileLocalFileDocTabView;
                                case 11:
                                    QfileLocalFileMediaTabView qfileLocalFileMediaTabView = new QfileLocalFileMediaTabView(this.G, 3, arrayList, true);
                                    qfileLocalFileMediaTabView.y();
                                    return qfileLocalFileMediaTabView;
                                case 12:
                                    QfileLocalFileMediaTabView qfileLocalFileMediaTabView2 = new QfileLocalFileMediaTabView(this.G, 1, arrayList, true);
                                    qfileLocalFileMediaTabView2.y();
                                    return qfileLocalFileMediaTabView2;
                                case 13:
                                    QfileLocalFileMediaTabView qfileLocalFileMediaTabView3 = new QfileLocalFileMediaTabView(this.G, 2, arrayList, true);
                                    qfileLocalFileMediaTabView3.y();
                                    return qfileLocalFileMediaTabView3;
                                case 14:
                                    QfileLocalFileOtherTabView qfileLocalFileOtherTabView = new QfileLocalFileOtherTabView(this.G, arrayList, true);
                                    qfileLocalFileOtherTabView.y();
                                    return qfileLocalFileOtherTabView;
                                default:
                                    return null;
                            }
                        }
                        if (z16) {
                            arrayList.add(new h(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(com.tencent.mobileqq.vfs.d.f312454d), true, true, true));
                            arrayList.add(new h(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(com.tencent.mobileqq.vfs.d.f312453c), true, true, true));
                            c(arrayList, new b());
                            c(arrayList, new c());
                        }
                        QfileLocalFileDelPicTabView qfileLocalFileDelPicTabView = new QfileLocalFileDelPicTabView(this.G, arrayList, true);
                        qfileLocalFileDelPicTabView.y();
                        return qfileLocalFileDelPicTabView;
                    }
                    c(arrayList, new a());
                    QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView = new QfileLocalFileDelFileTabView(this.G, arrayList, 5);
                    qfileLocalFileDelFileTabView.y();
                    return qfileLocalFileDelFileTabView;
                }
                arrayList.add(new h(AppConstants.SDCARD_FILE_SAVE_TMP_PATH, true, false, false));
                arrayList.add(new h(str + ".trooptmp", true, false, false));
                c(arrayList, new e());
                QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView2 = new QfileLocalFileDelFileTabView(this.G, arrayList, 11);
                qfileLocalFileDelFileTabView2.y();
                return qfileLocalFileDelFileTabView2;
            }
            if (z16) {
                arrayList.add(new h(h16, false, true, true));
                c(arrayList, new f());
            }
            QfileLocalFileDelMediaTabView qfileLocalFileDelMediaTabView = new QfileLocalFileDelMediaTabView(this.G, arrayList, true);
            qfileLocalFileDelMediaTabView.y();
            return qfileLocalFileDelMediaTabView;
        }
        c(arrayList, new d());
        QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView3 = new QfileLocalFileDelFileTabView(this.G, arrayList, 3);
        qfileLocalFileDelFileTabView3.y();
        return qfileLocalFileDelFileTabView3;
    }

    private QfileBaseTabView h(int i3) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_ROOT;
        sb5.append(str);
        sb5.append("/Tencent/MicroMsg/Download/");
        arrayList.add(new h(sb5.toString(), false, false, true));
        arrayList.add(new h(str + "/Tencent/MicroMsg/WeiXin/", false, false, true));
        if (i3 != 1110) {
            if (i3 != 1111) {
                if (i3 != 1114) {
                    if (i3 != 1118) {
                        if (i3 != 1119) {
                            switch (i3) {
                                case 15:
                                    QfileCloudFileTabView qfileCloudFileTabView = new QfileCloudFileTabView(this.G, "picture", this.f209468i);
                                    qfileCloudFileTabView.y();
                                    return qfileCloudFileTabView;
                                case 16:
                                    QfileCloudFileTabView qfileCloudFileTabView2 = new QfileCloudFileTabView(this.G, "document", this.f209468i);
                                    qfileCloudFileTabView2.y();
                                    return qfileCloudFileTabView2;
                                case 17:
                                    QfileCloudFileTabView qfileCloudFileTabView3 = new QfileCloudFileTabView(this.G, "video", this.f209468i);
                                    qfileCloudFileTabView3.y();
                                    return qfileCloudFileTabView3;
                                case 18:
                                    QfileCloudFileTabView qfileCloudFileTabView4 = new QfileCloudFileTabView(this.G, "music", this.f209468i);
                                    qfileCloudFileTabView4.y();
                                    return qfileCloudFileTabView4;
                                case 19:
                                    QfileCloudFileTabView qfileCloudFileTabView5 = new QfileCloudFileTabView(this.G, "other", this.f209468i);
                                    qfileCloudFileTabView5.y();
                                    return qfileCloudFileTabView5;
                                default:
                                    return null;
                            }
                        }
                        QfileLocalFilePicTabView qfileLocalFilePicTabView = new QfileLocalFilePicTabView(this.G, arrayList, false);
                        qfileLocalFilePicTabView.setFromWeiXin(true);
                        qfileLocalFilePicTabView.y();
                        return qfileLocalFilePicTabView;
                    }
                    QfileLocalFileAppTabView qfileLocalFileAppTabView = new QfileLocalFileAppTabView(this.G, arrayList, false);
                    qfileLocalFileAppTabView.setFromWeiXin(true);
                    qfileLocalFileAppTabView.y();
                    return qfileLocalFileAppTabView;
                }
                QfileLocalFileOtherTabView qfileLocalFileOtherTabView = new QfileLocalFileOtherTabView(this.G, arrayList, false);
                qfileLocalFileOtherTabView.setFromWeiXin(true);
                qfileLocalFileOtherTabView.y();
                return qfileLocalFileOtherTabView;
            }
            QfileLocalFileMediaTabView qfileLocalFileMediaTabView = new QfileLocalFileMediaTabView(this.G, 3, arrayList, false);
            qfileLocalFileMediaTabView.setFromWeiXin(true);
            qfileLocalFileMediaTabView.y();
            return qfileLocalFileMediaTabView;
        }
        QfileLocalFileDocTabView qfileLocalFileDocTabView = new QfileLocalFileDocTabView(this.G, arrayList, false);
        qfileLocalFileDocTabView.setFromWeiXin(true);
        qfileLocalFileDocTabView.y();
        return qfileLocalFileDocTabView;
    }

    private QfileBaseTabView i(int i3) {
        boolean z16;
        QfileRecentAllFileTabView qfileRecentAllFileTabView;
        QfileRecentDocFileTabView qfileRecentDocFileTabView;
        QfileRecentPicFileTabView qfileRecentPicFileTabView;
        QfileRecentMediaFileTabView qfileRecentMediaFileTabView;
        QfileRecentAppFileTabView qfileRecentAppFileTabView;
        QfileRecentTencentDocFileTabView qfileRecentTencentDocFileTabView;
        QfileRecentTDocFileTabView qfileRecentTDocFileTabView;
        String str = this.f209466f;
        if (str != null && str.trim().length() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 != 20) {
                                if (i3 != 21) {
                                    return null;
                                }
                                if (z16) {
                                    qfileRecentTDocFileTabView = new QfileRecentTDocFileTabView(this.G, this.f209466f);
                                } else {
                                    qfileRecentTDocFileTabView = new QfileRecentTDocFileTabView(this.G);
                                }
                                qfileRecentTDocFileTabView.y();
                                return qfileRecentTDocFileTabView;
                            }
                            if (z16) {
                                qfileRecentTencentDocFileTabView = new QfileRecentTencentDocFileTabView(this.G, this.f209466f);
                            } else {
                                qfileRecentTencentDocFileTabView = new QfileRecentTencentDocFileTabView(this.G);
                            }
                            qfileRecentTencentDocFileTabView.y();
                            return qfileRecentTencentDocFileTabView;
                        }
                        if (z16) {
                            qfileRecentAppFileTabView = new QfileRecentAppFileTabView(this.G, this.f209466f);
                        } else {
                            qfileRecentAppFileTabView = new QfileRecentAppFileTabView(this.G);
                        }
                        qfileRecentAppFileTabView.y();
                        return qfileRecentAppFileTabView;
                    }
                    if (z16) {
                        qfileRecentMediaFileTabView = new QfileRecentMediaFileTabView(this.G, this.f209466f);
                    } else {
                        qfileRecentMediaFileTabView = new QfileRecentMediaFileTabView(this.G);
                    }
                    qfileRecentMediaFileTabView.y();
                    return qfileRecentMediaFileTabView;
                }
                if (z16) {
                    qfileRecentPicFileTabView = new QfileRecentPicFileTabView(this.G, this.f209466f);
                } else {
                    qfileRecentPicFileTabView = new QfileRecentPicFileTabView(this.G);
                }
                qfileRecentPicFileTabView.y();
                return qfileRecentPicFileTabView;
            }
            if (z16) {
                qfileRecentDocFileTabView = new QfileRecentDocFileTabView(this.G, this.f209466f);
            } else {
                qfileRecentDocFileTabView = new QfileRecentDocFileTabView(this.G);
            }
            qfileRecentDocFileTabView.y();
            return qfileRecentDocFileTabView;
        }
        if (z16) {
            qfileRecentAllFileTabView = new QfileRecentAllFileTabView(this.G, this.f209466f);
        } else {
            qfileRecentAllFileTabView = new QfileRecentAllFileTabView(this.G);
        }
        qfileRecentAllFileTabView.y();
        return qfileRecentAllFileTabView;
    }

    private void n(int i3) {
        if (!this.K.containsKey(Integer.valueOf(i3))) {
            return;
        }
        int intValue = this.K.get(Integer.valueOf(i3)).intValue();
        if (intValue != 3) {
            if (intValue != 1114) {
                if (intValue != 20) {
                    if (intValue != 21) {
                        if (intValue != 1110) {
                            if (intValue != 1111) {
                                if (intValue != 1118) {
                                    if (intValue == 1119) {
                                        ReportController.o(this.G.D0, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
                                        return;
                                    }
                                    return;
                                }
                                ReportController.o(this.G.D0, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
                                return;
                            }
                            ReportController.o(this.G.D0, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
                            return;
                        }
                        ReportController.o(this.G.D0, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
                        return;
                    }
                    ReportController.o(this.G.D0, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
                    return;
                }
                int i16 = this.f209469m;
                if (i16 == 1) {
                    ReportController.o(this.G.D0, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
                    return;
                } else {
                    if (i16 == 2) {
                        ReportController.o(this.G.D0, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
            }
            ReportController.o(this.G.D0, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
            return;
        }
        int i17 = this.f209469m;
        if (i17 == 1) {
            ReportController.o(this.G.D0, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
        } else if (i17 == 2) {
            ReportController.o(this.G.D0, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
        }
    }

    public void a(ArrayList<FileManagerEntity> arrayList) {
        this.F.i(arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.d
    public boolean b() {
        return this.L;
    }

    public void d(int i3, String str) {
        this.D.c(this.f209464d, str);
        this.K.put(Integer.valueOf(this.f209464d), Integer.valueOf(i3));
        this.f209464d++;
    }

    public void e(int i3, String str) {
        this.D.d(this.f209464d, str, false, false, true);
        this.K.put(Integer.valueOf(this.f209464d), Integer.valueOf(i3));
        this.f209464d++;
    }

    public void j(ArrayList<FileManagerEntity> arrayList) {
        Iterator<Integer> it = this.J.keySet().iterator();
        while (it.hasNext()) {
            this.J.get(Integer.valueOf(it.next().intValue())).l(arrayList);
        }
    }

    public void k(ArrayList<WeiYunFileInfo> arrayList) {
        this.F.m(arrayList);
    }

    public void l(Set<FileInfo> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.J.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            QfileBaseTabView qfileBaseTabView = this.J.get(Integer.valueOf(it.next().intValue()));
            if (qfileBaseTabView != null) {
                if (qfileBaseTabView.x(set)) {
                    i3++;
                }
                arrayList.add(qfileBaseTabView);
            }
        }
        this.G.V2().setRefreshTabCount(i3);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((QfileBaseTabView) it5.next()).n(set);
        }
    }

    public void m() {
        v();
    }

    public int o() {
        if (this.K.containsKey(Integer.valueOf(this.f209465e))) {
            return this.K.get(Integer.valueOf(this.f209465e)).intValue();
        }
        return -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.getId();
        EventCollector.getInstance().onViewClicked(view);
    }

    public ListView p() {
        QfileBaseTabView qfileBaseTabView = this.F;
        if (qfileBaseTabView != null) {
            return qfileBaseTabView.q();
        }
        return null;
    }

    public int q() {
        QfileBaseTabView qfileBaseTabView = this.F;
        if (qfileBaseTabView == null) {
            return -1;
        }
        return qfileBaseTabView.r();
    }

    public int[] r() {
        QfileBaseTabView qfileBaseTabView = this.F;
        if (qfileBaseTabView == null) {
            return null;
        }
        return qfileBaseTabView.s();
    }

    QfileBaseTabView s(int i3) {
        int i16;
        QfileBaseTabView qfileBaseTabView;
        try {
            qfileBaseTabView = this.J.get(Integer.valueOf(i3));
        } catch (Exception unused) {
            QLog.e("QfileTabBarView<FileAssistant>", 1, "tabPos[" + i3 + "]");
            i16 = 3;
        }
        if (qfileBaseTabView != null) {
            return qfileBaseTabView;
        }
        i16 = this.K.get(Integer.valueOf(i3)).intValue();
        QfileBaseTabView i17 = i(i16);
        if (i17 == null) {
            i17 = g(i16);
        }
        if (i17 == null) {
            i17 = h(i16);
        }
        if (i17 == null) {
            i17 = f(i16);
        }
        if (i17 == null) {
            QLog.e("QfileTabBarView<FileAssistant>", 1, "getTabView return null!,tabPos:" + i3);
            return null;
        }
        i17.setFocusable(false);
        if (i17 instanceof QfileBaseRecentFileTabView) {
            ((QfileBaseRecentFileTabView) i17).setAttribution(this.f209469m);
        }
        BaseFileAssistantActivity baseFileAssistantActivity = this.G;
        if (baseFileAssistantActivity instanceof FMActivity) {
            ((FMActivity) baseFileAssistantActivity).V2().setAttribution(i16);
        }
        this.J.put(Integer.valueOf(i3), i17);
        return i17;
    }

    public void setAttribution(int i3) {
        this.f209469m = i3;
    }

    public void setHeaderScrollView(HeaderScrollView headerScrollView) {
        this.H = headerScrollView;
    }

    public void setMemory(boolean z16) {
        this.f209467h = z16;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.d
    public void setRefreshedFavList(boolean z16) {
        if (z16 == this.L) {
            return;
        }
        QLog.i("TabBarView", 1, "FavFileS setRefreshedFavList:" + this.L + "->" + z16);
        this.L = z16;
    }

    public void setSelectedTab(int i3) {
        Iterator<Integer> it = this.K.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (this.K.get(Integer.valueOf(it.next().intValue())).intValue() != i3) {
                i16++;
            } else {
                this.D.k();
                this.D.setSelectedTab(i16, true);
                return;
            }
        }
    }

    public void setSortType(int i3) {
        QfileBaseTabView qfileBaseTabView = this.F;
        if (qfileBaseTabView == null) {
            return;
        }
        qfileBaseTabView.setSortType(i3);
    }

    public void setTabFrameHeight(int i3) {
        if (this.G.r3()) {
            QfileBaseTabView qfileBaseTabView = this.F;
            if (qfileBaseTabView instanceof QfileBaseCloudFileTabView) {
                i3 += qfileBaseTabView.p();
            }
        }
        this.F.setLayoutParams(new RelativeLayout.LayoutParams(-1, i3));
        this.F.D();
    }

    public void setTabTitleList(String[] strArr) {
        this.D.setTabTitleList(strArr);
    }

    public void setUin(String str) {
        this.f209466f = str;
    }

    public void setWYSubAppId(int i3) {
        this.f209468i = i3;
    }

    boolean t() {
        return true;
    }

    public void u() {
        QfileBaseTabView qfileBaseTabView = this.F;
        if (qfileBaseTabView != null) {
            qfileBaseTabView.C();
        }
    }

    public void v() {
        int childCount = this.D.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.D.t(0);
        }
        Iterator<Integer> it = this.J.keySet().iterator();
        while (it.hasNext()) {
            QfileBaseTabView qfileBaseTabView = this.J.get(Integer.valueOf(it.next().intValue()));
            if (qfileBaseTabView != null) {
                qfileBaseTabView.z();
            }
        }
        this.f209464d = 0;
        this.D.setSelected(false);
        this.K.clear();
        this.J.clear();
        this.I.clear();
        this.E.removeView(this.F);
    }

    public void w(int i3) {
        this.D.setVisibility(i3);
    }

    void x(int i3) {
        QfileBaseTabView s16 = s(i3);
        if (s16 == null) {
            return;
        }
        QfileBaseTabView qfileBaseTabView = this.F;
        if (qfileBaseTabView != s16) {
            if (qfileBaseTabView != null) {
                if (t()) {
                    this.F.onPause();
                }
                this.F.B();
                this.E.removeView(this.F);
            }
            this.F = s16;
            HeaderScrollView headerScrollView = this.H;
            if (headerScrollView != null) {
                headerScrollView.setCurrentScrollableContainer(s16);
            }
            this.F.A();
            this.F.setExpandGroup(true);
            if (t()) {
                this.F.onResume();
            }
            this.E.addView(this.F, -1, -1);
            n(i3);
            this.G.F3(s16);
        }
        this.f209465e = i3;
    }

    public QfileTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f209464d = 0;
        this.f209465e = 0;
        this.f209467h = false;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = new HashMap<>();
        this.J = new HashMap<>();
        this.K = new LinkedHashMap();
        this.L = false;
        this.M = new g();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168646am0, this);
        this.G = (BaseFileAssistantActivity) context;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.d7y);
        this.C = horizontalScrollView;
        horizontalScrollView.getParent().requestDisallowInterceptTouchEvent(true);
        TabBarView2 tabBarView2 = (TabBarView2) findViewById(R.id.j9z);
        this.D = tabBarView2;
        tabBarView2.setImportantForAccessibility(2);
        this.E = (RelativeLayout) findViewById(R.id.j_1);
        this.D.setOnTabChangeListener(this.M);
        this.D.setBackgroundDrawable(null);
        if (QQTheme.isNowSimpleUI()) {
            this.D.setPadding(0, 0, 0, 0);
        } else {
            this.D.setPadding(ViewUtils.dpToPx(8.0f), 0, ViewUtils.dpToPx(8.0f), 0);
        }
        this.D.setBackground(getResources().getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
    }
}
