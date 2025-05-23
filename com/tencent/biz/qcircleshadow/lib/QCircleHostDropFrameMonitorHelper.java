package com.tencent.biz.qcircleshadow.lib;

import android.widget.FrameLayout;
import com.tencent.qqperf.monitor.dropframe.api.IDropFrameMonitor;
import org.json.JSONObject;
import oy3.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostDropFrameMonitorHelper {
    private static BlockLooperListener mBlockListener;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface BlockLooperListener {
        void onBlockLooper(FrameLayout frameLayout, JSONObject jSONObject);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _Constants {
        public static String QCIRCLE_COMMENT_PAGE() {
            return IDropFrameMonitor.QCIRCLE_COMMENT_PAGE;
        }

        public static String QCIRCLE_FOLLOW_USER_LIST() {
            return IDropFrameMonitor.QCIRCLE_FOLLOW_USER_LIST;
        }

        public static String QCIRCLE_IMMERSIVE_ALL_PUSH_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_ALL_PUSH_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_COMMENT_LIST() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_COMMENT_LIST;
        }

        public static String QCIRCLE_IMMERSIVE_FOLLOW_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_FOLLOW_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_LAYER_LIST() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_FEED_LAYER_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_LOCATION_POLYMERIZATION_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_LOCATION_POLYMERIZATION_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_MESSAGE_BOX_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_MESSAGE_BOX_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_MESSAGE_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_MESSAGE_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_MUSIC_POLYMERIZATION_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_MUSIC_POLYMERIZATION_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_NEARBY_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_NEARBY_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_PERSONAGE_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_PERSONAGE_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_PRIVATE_CHAT_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_PRIVATE_CHAT_PAGE;
        }

        public static String QCIRCLE_IMMERSIVE_TOPIC_POLYMERIZATION_PAGE() {
            return IDropFrameMonitor.QCIRCLE_IMMERSIVE_TOPIC_POLYMERIZATION_PAGE;
        }

        public static String QCIRCLE_MESSAGE_NOTICE() {
            return IDropFrameMonitor.QCIRCLE_MESSAGE_NOTICE;
        }

        public static String QCIRCLE_POLYMERIZATION_PAGE() {
            return IDropFrameMonitor.QCIRCLE_POLYMERIZATION_PAGE;
        }

        public static String QCIRCLE_SPECIAL_FOLLOW_LIST() {
            return IDropFrameMonitor.QCIRCLE_SPECIAL_FOLLOW_LIST;
        }

        public static String QCIRLE_BLACK_LIST_PAGE() {
            return IDropFrameMonitor.QCIRLE_BLACK_LIST_PAGE;
        }

        public static String QCIRLE_LIKE_LIST_PAGE() {
            return IDropFrameMonitor.QCIRLE_LIKE_LIST_PAGE;
        }
    }

    public static void removeLooperListener() {
        mBlockListener = null;
    }

    public static void setLooperListener(BlockLooperListener blockLooperListener) {
        mBlockListener = blockLooperListener;
    }

    public static void startMonitorScene(String str) {
        a.a().b(str);
    }

    public static void stopMonitorScene(String str, boolean z16) {
        a.a().c(str, z16);
    }
}
