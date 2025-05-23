package cooperation.qqcircle.report.perf;

/* loaded from: classes28.dex */
public class QFSPerfUtils {
    public static String SCENE_BOTTOM_TAB_CLICK = "bottom_tab_selected";

    public static void enter(String str) {
        QFSCpuTracker.g().enter(str);
        QFSMemoryTracker.g().enter(str);
        QFSAMSMemoryInfoTracker.g().enter(str);
        QFSFileDescriptorTracker.getInstance().enter(str);
    }

    public static void exit() {
        QFSCpuTracker.g().exit();
        QFSMemoryTracker.g().exit();
        QFSAMSMemoryInfoTracker.g().exit();
        QFSFileDescriptorTracker.getInstance().exit();
    }
}
