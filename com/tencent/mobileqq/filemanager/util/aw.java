package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavVideoFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.api.impl.QQFileSelectorImpl;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class aw {
    public static QfileBaseTabView a(Context context, int i3, QfileBaseFavFileTabView.d dVar) {
        QfileFavFileRecordProvider qfileFavFileRecordProvider = ((QQFileSelectorImpl) QRoute.api(IQQFileSelector.class)).getQfileFavFileRecordProvider(MobileQQ.sMobileQQ.peekAppRuntime());
        switch (i3) {
            case 1200:
                QfileFavVideoFileTabView qfileFavVideoFileTabView = new QfileFavVideoFileTabView(context, qfileFavFileRecordProvider, dVar);
                qfileFavVideoFileTabView.y();
                return qfileFavVideoFileTabView;
            case 1201:
                QfileFavPicFileTabView qfileFavPicFileTabView = new QfileFavPicFileTabView(context, qfileFavFileRecordProvider, dVar);
                qfileFavPicFileTabView.y();
                return qfileFavPicFileTabView;
            case 1202:
                QfileFavDocFileTabView qfileFavDocFileTabView = new QfileFavDocFileTabView(context, qfileFavFileRecordProvider, dVar);
                qfileFavDocFileTabView.y();
                return qfileFavDocFileTabView;
            case 1203:
                QfileFavAppFileTabView qfileFavAppFileTabView = new QfileFavAppFileTabView(context, qfileFavFileRecordProvider, dVar);
                qfileFavAppFileTabView.y();
                return qfileFavAppFileTabView;
            case 1204:
                QfileFavFileTabView qfileFavFileTabView = new QfileFavFileTabView(context, qfileFavFileRecordProvider, dVar);
                qfileFavFileTabView.y();
                return qfileFavFileTabView;
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0026. Please report as an issue. */
    public static QfileBaseTabView b(Context context, int i3) {
        QfileBaseTabView qfileLocalFileDelFileTabView;
        ArrayList arrayList = new ArrayList();
        String str = AppConstants.SDCARD_FILE_SAVE_PATH;
        arrayList.add(new QfileTabBarView.h(str, false, false, true));
        if (i3 != 110) {
            if (i3 != 111) {
                if (i3 != 114) {
                    if (i3 != 118) {
                        if (i3 != 119) {
                            switch (i3) {
                                case 8:
                                    qfileLocalFileDelFileTabView = new QfileLocalFileAppTabView(context, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                case 9:
                                    qfileLocalFileDelFileTabView = new QfileLocalFilePicTabView(context, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                case 10:
                                    qfileLocalFileDelFileTabView = new QfileLocalFileDocTabView(context, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                case 11:
                                    qfileLocalFileDelFileTabView = new QfileLocalFileMediaTabView(context, 3, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                case 12:
                                    qfileLocalFileDelFileTabView = new QfileLocalFileMediaTabView(context, 1, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                case 13:
                                    qfileLocalFileDelFileTabView = new QfileLocalFileMediaTabView(context, 2, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                case 14:
                                    qfileLocalFileDelFileTabView = new QfileLocalFileOtherTabView(context, arrayList, true);
                                    qfileLocalFileDelFileTabView.y();
                                    break;
                                default:
                                    return null;
                            }
                        } else {
                            qfileLocalFileDelFileTabView = new QfileLocalFileDelPicTabView(context, arrayList, true);
                            qfileLocalFileDelFileTabView.y();
                        }
                    } else {
                        qfileLocalFileDelFileTabView = new QfileLocalFileDelFileTabView(context, arrayList, 5);
                        qfileLocalFileDelFileTabView.y();
                    }
                } else {
                    arrayList.add(new QfileTabBarView.h(AppConstants.SDCARD_FILE_SAVE_TMP_PATH, true, false, false));
                    arrayList.add(new QfileTabBarView.h(str + ".trooptmp", true, false, false));
                    qfileLocalFileDelFileTabView = new QfileLocalFileDelFileTabView(context, arrayList, 11);
                    qfileLocalFileDelFileTabView.y();
                }
            } else {
                qfileLocalFileDelFileTabView = new QfileLocalFileDelMediaTabView(context, arrayList, true);
                qfileLocalFileDelFileTabView.y();
            }
        } else {
            qfileLocalFileDelFileTabView = new QfileLocalFileDelFileTabView(context, arrayList, 3);
            qfileLocalFileDelFileTabView.y();
        }
        return qfileLocalFileDelFileTabView;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0051. Please report as an issue. */
    public static QfileBaseTabView c(Context context, int i3) {
        QfileBaseTabView qfileLocalFileDocTabView;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_ROOT;
        sb5.append(str);
        sb5.append("/Tencent/MicroMsg/Download/");
        arrayList.add(new QfileTabBarView.h(sb5.toString(), false, false, true));
        arrayList.add(new QfileTabBarView.h(str + "/Tencent/MicroMsg/WeiXin/", false, false, true));
        if (i3 != 1110) {
            if (i3 != 1111) {
                if (i3 != 1114) {
                    if (i3 != 1118) {
                        if (i3 != 1119) {
                            switch (i3) {
                                case 15:
                                    qfileLocalFileDocTabView = new QfileCloudFileTabView(context, "picture", 0);
                                    qfileLocalFileDocTabView.y();
                                    break;
                                case 16:
                                    qfileLocalFileDocTabView = new QfileCloudFileTabView(context, "document", 0);
                                    qfileLocalFileDocTabView.y();
                                    break;
                                case 17:
                                    qfileLocalFileDocTabView = new QfileCloudFileTabView(context, "video", 0);
                                    qfileLocalFileDocTabView.y();
                                    break;
                                case 18:
                                    qfileLocalFileDocTabView = new QfileCloudFileTabView(context, "music", 0);
                                    qfileLocalFileDocTabView.y();
                                    break;
                                case 19:
                                    qfileLocalFileDocTabView = new QfileCloudFileTabView(context, "other", 0);
                                    qfileLocalFileDocTabView.y();
                                    break;
                                default:
                                    return null;
                            }
                        } else {
                            qfileLocalFileDocTabView = new QfileLocalFilePicTabView(context, arrayList, false);
                            qfileLocalFileDocTabView.setFromWeiXin(true);
                            qfileLocalFileDocTabView.y();
                        }
                    } else {
                        qfileLocalFileDocTabView = new QfileLocalFileAppTabView(context, arrayList, false);
                        qfileLocalFileDocTabView.setFromWeiXin(true);
                        qfileLocalFileDocTabView.y();
                    }
                } else {
                    qfileLocalFileDocTabView = new QfileLocalFileOtherTabView(context, arrayList, false);
                    qfileLocalFileDocTabView.setFromWeiXin(true);
                    qfileLocalFileDocTabView.y();
                }
            } else {
                qfileLocalFileDocTabView = new QfileLocalFileMediaTabView(context, 3, arrayList, false);
                qfileLocalFileDocTabView.setFromWeiXin(true);
                qfileLocalFileDocTabView.y();
            }
        } else {
            qfileLocalFileDocTabView = new QfileLocalFileDocTabView(context, arrayList, false);
            qfileLocalFileDocTabView.setFromWeiXin(true);
            qfileLocalFileDocTabView.y();
        }
        return qfileLocalFileDocTabView;
    }

    public static QfileBaseTabView d(Context context, int i3) {
        QfileBaseTabView qfileRecentAllFileTabView;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 != 20) {
                                if (i3 != 21) {
                                    return null;
                                }
                                qfileRecentAllFileTabView = new QfileRecentTDocFileTabView(context);
                                qfileRecentAllFileTabView.y();
                            } else {
                                qfileRecentAllFileTabView = new QfileRecentTencentDocFileTabView(context);
                                qfileRecentAllFileTabView.y();
                            }
                        } else {
                            qfileRecentAllFileTabView = new QfileRecentAppFileTabView(context);
                            qfileRecentAllFileTabView.y();
                        }
                    } else {
                        qfileRecentAllFileTabView = new QfileRecentMediaFileTabView(context);
                        qfileRecentAllFileTabView.y();
                    }
                } else {
                    qfileRecentAllFileTabView = new QfileRecentPicFileTabView(context);
                    qfileRecentAllFileTabView.y();
                }
            } else {
                qfileRecentAllFileTabView = new QfileRecentDocFileTabView(context);
                qfileRecentAllFileTabView.y();
            }
        } else {
            qfileRecentAllFileTabView = new QfileRecentAllFileTabView(context);
            qfileRecentAllFileTabView.y();
        }
        return qfileRecentAllFileTabView;
    }
}
