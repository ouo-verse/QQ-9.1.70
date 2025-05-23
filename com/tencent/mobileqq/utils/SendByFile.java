package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SendByFile {

    /* renamed from: a, reason: collision with root package name */
    private long f307267a = a();

    /* renamed from: b, reason: collision with root package name */
    private long f307268b = 1048576000;

    /* renamed from: c, reason: collision with root package name */
    private long f307269c = ShortVideoConstants.VIDEO_SIZE_LIMIT;

    /* renamed from: d, reason: collision with root package name */
    private boolean f307270d = true;

    public static void e(QQAppInterface qQAppInterface, List<String> list, String str, int i3, Bundle bundle) {
        if (qQAppInterface != null && list != null) {
            for (String str2 : list) {
                if (i3 == 1) {
                    qQAppInterface.getFileManagerEngine().K0(str2, str, 0L, 0, bundle);
                } else if (i3 == 10014) {
                    qQAppInterface.getFileManagerEngine().L0(str2, str);
                } else {
                    qQAppInterface.getFileManagerEngine().H0(str2, str, str, "", i3, true, 0L, 0, bundle);
                }
            }
        }
    }

    protected int a() {
        return (int) ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
    }

    public Pair<ArrayList<String>, ArrayList<String>> b(List<String> list, boolean z16, Map<String, LocalMediaInfo> map, Map<String, LocalMediaInfo> map2) {
        LocalMediaInfo localMediaInfo;
        Pair<ArrayList<String>, ArrayList<String>> pair = new Pair<>(new ArrayList(), new ArrayList());
        if (list == null) {
            return pair;
        }
        pair.first.clear();
        pair.second.clear();
        for (String str : list) {
            if (ImageManager.isNetworkUrl(str)) {
                pair.first.add(str);
            } else {
                if (map != null) {
                    localMediaInfo = map.get(str);
                } else {
                    localMediaInfo = null;
                }
                if (localMediaInfo == null && map2 != null) {
                    localMediaInfo = map2.get(str);
                }
                if (localMediaInfo == null) {
                    pair.first.add(str);
                } else {
                    int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                    long j3 = localMediaInfo.fileSize;
                    if (j3 <= 0) {
                        File file = new File(str);
                        if (file.exists()) {
                            j3 = file.length();
                        }
                    }
                    if (mediaType == 1) {
                        if (j3 <= this.f307268b && (j3 <= this.f307269c || !z16)) {
                            pair.first.add(str);
                        } else if (this.f307270d) {
                            pair.second.add(str);
                            e.p();
                        }
                    } else if (j3 > this.f307267a && z16) {
                        if (this.f307270d) {
                            pair.second.add(str);
                        }
                    } else {
                        pair.first.add(str);
                    }
                }
            }
        }
        return pair;
    }

    public boolean c(final Context context, String str, boolean z16, Map<String, LocalMediaInfo> map, Map<String, LocalMediaInfo> map2, boolean z17) {
        LocalMediaInfo localMediaInfo;
        double d16;
        boolean z18 = false;
        if (ImageManager.isNetworkUrl(str)) {
            return false;
        }
        if (map != null) {
            localMediaInfo = map.get(str);
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo == null && map2 != null) {
            localMediaInfo = map2.get(str);
        }
        if (localMediaInfo == null) {
            return false;
        }
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        long j3 = localMediaInfo.fileSize;
        if (j3 <= 0) {
            File file = new File(str);
            if (file.exists()) {
                j3 = file.length();
            }
        }
        final String str2 = "";
        if (mediaType == 1) {
            if (j3 > this.f307268b || (j3 > this.f307269c && z16)) {
                if (this.f307270d) {
                    if (z17) {
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        long j16 = this.f307268b;
                        String str3 = "M";
                        if (j3 > j16) {
                            d16 = (((((float) j16) * 1.0f) / 1024.0f) / 1024.0f) + 1.0f;
                            if (d16 > 1000.0d) {
                                d16 /= 1024.0d;
                                str3 = "G";
                            }
                        } else {
                            d16 = ((this.f307269c / 1024) / 1024) + 1;
                        }
                        str2 = String.format(context.getResources().getString(R.string.f170304q42), "" + decimalFormat.format(d16), str3);
                    }
                } else if (z17) {
                    str2 = String.format(context.getResources().getString(R.string.tjy), "" + (((this.f307269c / 1024) / 1024) + 1));
                }
                z18 = true;
            }
        } else if (j3 > this.f307267a && z16) {
            if (this.f307270d) {
                if (z17) {
                    str2 = String.format(context.getResources().getString(R.string.ktb), "" + ((this.f307267a / 1024) / 1024));
                }
            } else if (z17) {
                str2 = String.format(context.getResources().getString(R.string.ktd), "" + ((this.f307267a / 1024) / 1024));
            }
            z18 = true;
        }
        if (z18 && !z17) {
            if (this.f307270d) {
                str2 = context.getResources().getString(R.string.dcb);
            } else {
                str2 = context.getResources().getString(R.string.fyi);
            }
        }
        if (z18) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.utils.SendByFile.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, str2, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
        }
        return z18;
    }

    public boolean d(Context context, List<String> list, boolean z16, Map<String, LocalMediaInfo> map, Map<String, LocalMediaInfo> map2) {
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (c(context, it.next(), z16, map, map2, false)) {
                return true;
            }
        }
        return false;
    }

    public SendByFile f(boolean z16) {
        this.f307270d = z16;
        return this;
    }

    public SendByFile g(long j3) {
        this.f307267a = j3;
        return this;
    }
}
