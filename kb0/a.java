package kb0;

import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerProcessOrder;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionH264ReSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsLocalPathProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements IRFWPlayerProcessOrder {
    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerProcessOrder
    public LinkedList<String> getPlayFormalOrder() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionsLocalPathProcess.DEFAULT_PROCESS_LOCAL);
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        linkedList.add(QFSPlayerOptionsExchangeUrlProcess.f92033a);
        linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        linkedList.add(com.tencent.biz.qqcircle.richframework.video.player.process.a.f92042a);
        return linkedList;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerProcessOrder
    public LinkedList<String> getPreloadVideoOrder(RFWVideoPreloadBean rFWVideoPreloadBean, String str) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(QFSPlayerOptionsExchangeUrlProcess.f92033a);
        if (rFWVideoPreloadBean.isMultiLevel()) {
            linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        }
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        if (!hb0.a.b(str)) {
            linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        }
        linkedList.add(com.tencent.biz.qqcircle.richframework.video.player.process.a.f92042a);
        return linkedList;
    }
}
