package jb0;

import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWOptionsProcessCallback;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionH264ReSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsHttpValidProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsLocalPathProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements IRFWOptionsProcessCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f409687a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f409687a = concurrentHashMap;
        concurrentHashMap.put(QFSPlayerOptionsExchangeUrlProcess.f92033a, 1);
        concurrentHashMap.put(com.tencent.biz.qqcircle.richframework.video.player.process.a.f92042a, 3);
        concurrentHashMap.put(RFWPlayerOptionsLocalPathProcess.DEFAULT_PROCESS_LOCAL, 4);
        concurrentHashMap.put(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK, 5);
        concurrentHashMap.put(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED, 6);
        concurrentHashMap.put(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED, 7);
        concurrentHashMap.put(RFWPlayerOptionsHttpValidProcess.DEFAULT_PROCESS_URL_HTTP_VALID, 8);
        concurrentHashMap.put(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP, 9);
        concurrentHashMap.put("INIT_PLAYER_SDK", 10);
        concurrentHashMap.put("OPEN_MEDIA_SOURCE", 11);
        concurrentHashMap.put("SET_PLAYER_ACTIVE", 12);
        concurrentHashMap.put(QFSPlayerOptionsExchangeUrlProcess.f92034b, 2);
    }

    private int a(String str) {
        try {
            return f409687a.get(str).intValue();
        } catch (Throwable th5) {
            RFWLog.d("QFSPlayerOptionsCallback", RFWLog.USR, "[convertRecordType] convert error, ex: ", th5);
            return -1;
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWOptionsProcessCallback
    public void onOptionsFinish(RFWPlayerOptions rFWPlayerOptions, String str) {
        if (rFWPlayerOptions == null) {
            RFWLog.d("QFSPlayerOptionsCallback", RFWLog.USR, "[onOptionsFinish] options == null.");
        } else {
            com.tencent.biz.qqcircle.immersive.report.b.f().r(rFWPlayerOptions.getFileId(), a(str));
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWOptionsProcessCallback
    public void onOptionsStart(RFWPlayerOptions rFWPlayerOptions, String str) {
        if (rFWPlayerOptions == null) {
            RFWLog.d("QFSPlayerOptionsCallback", RFWLog.USR, "[onOptionsStart] options == null.");
        } else {
            com.tencent.biz.qqcircle.immersive.report.b.f().s(rFWPlayerOptions.getFileId(), a(str));
        }
    }
}
