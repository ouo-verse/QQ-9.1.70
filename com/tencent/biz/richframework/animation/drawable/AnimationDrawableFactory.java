package com.tencent.biz.richframework.animation.drawable;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnimationDrawableFactory {
    private static volatile AnimationDrawableFactory sInstance;
    private final ConcurrentHashMap<String, RFWDownloader.RFWDownloadListener> mGetFileListener = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface CreateResultListener {
        void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable);
    }

    AnimationDrawableFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] getAdjustAnimationListFilePath(String str, int i3) {
        String[] listFilePath = getListFilePath(str);
        if (listFilePath != null && listFilePath.length > 0 && i3 > 1) {
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            while (i16 < listFilePath.length) {
                arrayList.add(listFilePath[i16]);
                i16 += i3;
            }
            if (listFilePath.length % i3 != 0) {
                arrayList.add(listFilePath[listFilePath.length - 1]);
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return listFilePath;
    }

    private static List<File> getAllChildFiles(File file) {
        File[] listFiles;
        LinkedList linkedList = new LinkedList();
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (!file2.getName().startsWith(".") && !file2.getName().equalsIgnoreCase("__MACOSX")) {
                    return true;
                }
                return false;
            }
        })) != null) {
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        linkedList.addAll(getAllChildFiles(file2));
                    } else {
                        linkedList.add(file2);
                    }
                }
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCutTimes(RFWAnimationStrategy rFWAnimationStrategy) {
        if (rFWAnimationStrategy.needCut()) {
            return rFWAnimationStrategy.getCutTimes();
        }
        return 1;
    }

    public static AnimationDrawableFactory getInstance() {
        if (sInstance == null) {
            synchronized (AnimationDrawableFactory.class) {
                if (sInstance == null) {
                    sInstance = new AnimationDrawableFactory();
                }
            }
        }
        return sInstance;
    }

    public static String[] getListFilePath(String str) {
        File[] fileArr;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            RFWLog.i("AnimationDrawableFactory", RFWLog.CLR, "exist Animation Pic!");
            List<File> allChildFiles = getAllChildFiles(file);
            if (allChildFiles != null && allChildFiles.size() > 0 && (fileArr = (File[]) allChildFiles.toArray(new File[allChildFiles.size()])) != null && fileArr.length > 0) {
                Arrays.sort(fileArr, new Comparator<File>() { // from class: com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.3
                    @Override // java.util.Comparator
                    public int compare(File file2, File file3) {
                        return file2.getName().compareToIgnoreCase(file3.getName());
                    }
                });
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArr) {
                    arrayList.add(file2.getPath());
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return null;
        }
        return null;
    }

    public void createFromUrl(int i3, final AnimationDrawableCreateOption animationDrawableCreateOption, final CreateResultListener createResultListener) {
        final String str = i3 + "@" + animationDrawableCreateOption.getUrl();
        RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "createFromUrl" + str);
        final RFWAnimationStrategy animationStrategy = animationDrawableCreateOption.getAnimationStrategy();
        if (this.mGetFileListener.containsKey(str)) {
            RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "drawable is creating" + str);
            createResultListener.onCreateResult(false, null);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        RFWDownloader.RFWDownloadListener rFWDownloadListener = new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1
            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callEnd(Call call) {
                v.a(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callFailed(Call call, IOException iOException) {
                v.b(this, call, iOException);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callStart(Call call) {
                v.c(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
                v.d(this, call, inetSocketAddress, proxy, protocol2);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
                v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                v.f(this, call, inetSocketAddress, proxy);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
                v.g(this, call, connection);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectionReleased(Call call, Connection connection) {
                v.h(this, call, connection);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void dnsEnd(Call call, String str2, List list) {
                v.i(this, call, str2, list);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void dnsStart(Call call, String str2) {
                v.j(this, call, str2);
            }

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onRspCallback(boolean z16, String str2) {
                RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "cost time" + (System.currentTimeMillis() - currentTimeMillis));
                if (z16 && System.currentTimeMillis() - currentTimeMillis < animationDrawableCreateOption.getCreateTimeOut()) {
                    RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "get drawable file list success:" + str);
                    final int cutTimes = AnimationDrawableFactory.getCutTimes(animationStrategy);
                    final String[] adjustAnimationListFilePath = AnimationDrawableFactory.getAdjustAnimationListFilePath(str2, cutTimes);
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CreateResultListener createResultListener2;
                            String[] strArr = adjustAnimationListFilePath;
                            if ((strArr == null || strArr.length == 0) && (createResultListener2 = createResultListener) != null) {
                                createResultListener2.onCreateResult(false, null);
                                return;
                            }
                            QQAnimationDrawable qQAnimationDrawable = new QQAnimationDrawable();
                            qQAnimationDrawable.setPngPaths(adjustAnimationListFilePath);
                            qQAnimationDrawable.setRequestWidth(animationDrawableCreateOption.getRequestWidth());
                            qQAnimationDrawable.setRequestHeight(animationDrawableCreateOption.getRequestHeight());
                            if (animationDrawableCreateOption.getAllDuration() != 0) {
                                qQAnimationDrawable.setDuration(animationDrawableCreateOption.getAllDuration() * cutTimes);
                            } else if (animationDrawableCreateOption.getFrameDuration() != 0) {
                                qQAnimationDrawable.setDuration(adjustAnimationListFilePath.length * animationDrawableCreateOption.getFrameDuration() * cutTimes);
                            }
                            RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "create animationDrawable success");
                            CreateResultListener createResultListener3 = createResultListener;
                            if (createResultListener3 != null) {
                                createResultListener3.onCreateResult(true, qQAnimationDrawable);
                            }
                        }
                    });
                } else {
                    RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "create animationDrawable failed");
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            CreateResultListener createResultListener2 = createResultListener;
                            if (createResultListener2 != null) {
                                createResultListener2.onCreateResult(false, null);
                            }
                        }
                    });
                }
                RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "removeKey" + str);
                AnimationDrawableFactory.this.mGetFileListener.remove(str);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestBodyEnd(Call call, long j3) {
                v.k(this, call, j3);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestBodyStart(Call call) {
                v.l(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
                v.m(this, call, request);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestHeadersStart(Call call) {
                v.n(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseBodyEnd(Call call, long j3) {
                v.o(this, call, j3);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseBodyStart(Call call) {
                v.p(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
                v.q(this, call, response);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseHeadersStart(Call call) {
                v.r(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
                v.s(this, call, handshake);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void secureConnectStart(Call call) {
                v.t(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
            }
        };
        RFWLog.d("AnimationDrawableFactory", RFWLog.USR, "addKey" + str);
        this.mGetFileListener.put(str, rFWDownloadListener);
        RFWDownloaderFactory.getDownloader(animationStrategy.getDownLoadStrategy()).downloadOrUpdateFile(animationDrawableCreateOption.getUrl(), rFWDownloadListener);
    }
}
