package cooperation.qqcircle.proxy;

/* loaded from: classes28.dex */
public class QCircleInvokeParam {
    private static final int ACTION_GET_IMPL = 4;
    private static final int ACTION_INIT = 1;
    private static final int ACTION_JS_BRIDGE = 5;
    private static final int ACTION_LAUNCHER = 3;
    private static final int ACTION_RELEASE = 2;

    /* loaded from: classes28.dex */
    public static class GetImpl {
        public static final int ACTION = 4;
        public static final int METHOD_GET_QCIRCLE_JS_PLUGIN = 1;
        public static final int METHOD_GET_QCIRCLE_TITLE_BAR_VIEW = 2;
    }

    /* loaded from: classes28.dex */
    public static class Init {
        public static final int ACTION = 1;
        public static final int METHOD_INIT_BY_VSNETWORK_HELPER = 1;
    }

    /* loaded from: classes28.dex */
    public static class JsBridge {
        public static final int ACTION = 5;
        public static final int METHOD_HANDLE_JS_REQUEST = 1;
    }

    /* loaded from: classes28.dex */
    public static class Launcher {
        public static final int ACTION = 3;
        public static final int METHOD_LAUNCH_AGGREGATION_PAGE = 5;
        public static final int METHOD_LAUNCH_FEED_DETAIL_PAGE = 4;
        public static final int METHOD_LAUNCH_FOLDER_PAGE = 1;
        public static final int METHOD_LAUNCH_PERSONAL_DETAIL_PAGE = 3;
        public static final int METHOD_LAUNCH_QCIRCLE_BY_SCHEME = 2;
        public static final int METHOD_LAUNCH_QCIRCLE_BY_URL = 6;
    }

    /* loaded from: classes28.dex */
    public static class Release {
        public static final int ACTION = 2;
        public static final int METHOD_RELEASE_IN_QCIRCLEPLUGINENTER = 3;
        public static final int METHOD_RELEASE_IN_QQAPPINTERFACE = 2;
        public static final int METHOD_RELEASE_IN_VSNETWORK_HELPER = 1;
        public static final int METHOD_RELEASE_OPEN_REWARDAD = 4;
    }

    public static int getAction(int i3) {
        return i3 >> 16;
    }

    public static int getMethod(int i3) {
        return i3 & 65535;
    }

    public static int initInvokeKey(int i3, int i16) {
        return (i3 << 16) | i16;
    }
}
