package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTHandleEventFormatFactory {
    static final Set<String> APP_KEY_SET;
    private static final Set<String> AUDIO_KEY_SET;
    static final Set<String> PAGE_KEY_SET;
    static final Set<String> VIEW_KEY_SET;

    @DTConfigConstants.ElementFormatMode
    static int sElementFormatMode;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class EventHandlerHolder {
        EventHandlerHolder() {
        }

        static DTAppEventMapHandler getAppEventHandler() {
            if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
                return DTAppEventMapHandler.getInstance();
            }
            return DTNewsAppEventMapHandler.getInstance();
        }

        static DTBaseEventMapHandler getAudioEventMapHandler() {
            if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
                return DTBaseEventMapHandler.getInstance();
            }
            return DTNewsAudioEventMapHandler.getInstance();
        }

        static DTBaseEventMapHandler getBizEventHandler() {
            if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
                return DTBaseBizEventMapHandler.getInstance();
            }
            return DTNewBizEventMapHandler.getInstance();
        }

        static DTPageEventMapHandler getPageEventHandler() {
            if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
                return DTPageEventMapHandler.getInstance();
            }
            return DTNewsPageEventMapHandler.getInstance();
        }

        static DTBaseElementEventMapHandler getViewEventHandler() {
            if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
                return DTViewFlattenEventMapHandler.getInstance();
            }
            return DTNewsElementFlattenEventMapHandler.getInstance();
        }
    }

    static {
        HashSet hashSet = new HashSet();
        VIEW_KEY_SET = hashSet;
        HashSet hashSet2 = new HashSet();
        APP_KEY_SET = hashSet2;
        HashSet hashSet3 = new HashSet();
        PAGE_KEY_SET = hashSet3;
        HashSet hashSet4 = new HashSet();
        AUDIO_KEY_SET = hashSet4;
        sElementFormatMode = 1;
        hashSet.add("imp");
        hashSet.add("clck");
        hashSet.add("imp_end");
        hashSet.add(DTEventKey.SUBMIT);
        hashSet2.add(EventKey.APP_OUT);
        hashSet2.add(EventKey.APP_IN);
        hashSet2.add(EventKey.ORIGIN_VST);
        hashSet2.add(EventKey.VST);
        hashSet2.add(EventKey.ACT);
        hashSet2.add(DTEventKey.APP_HEARTBEAT);
        hashSet3.add("pgin");
        hashSet3.add("pgout");
        hashSet4.add(DTEventKey.AUDIO_START);
        hashSet4.add(DTEventKey.AUDIO_END);
        hashSet4.add(DTEventKey.AUDIO_HEARTBEAT);
    }

    @NonNull
    public static IEventMapHandler fetchEventHandler(String str) {
        if (VIEW_KEY_SET.contains(str)) {
            return getViewEventHandler();
        }
        if (APP_KEY_SET.contains(str)) {
            return getAppEventHandler();
        }
        if (PAGE_KEY_SET.contains(str)) {
            return getPageEventHandler();
        }
        if (AUDIO_KEY_SET.contains(str)) {
            return getAudioEventHandler();
        }
        return getBizEventHandler();
    }

    private static IEventMapHandler getAppEventHandler() {
        return EventHandlerHolder.getAppEventHandler();
    }

    private static DTBaseEventMapHandler getAudioEventHandler() {
        return EventHandlerHolder.getAudioEventMapHandler();
    }

    private static DTBaseEventMapHandler getBizEventHandler() {
        return EventHandlerHolder.getBizEventHandler();
    }

    private static IEventMapHandler getPageEventHandler() {
        return EventHandlerHolder.getPageEventHandler();
    }

    private static IEventMapHandler getViewEventHandler() {
        return EventHandlerHolder.getViewEventHandler();
    }

    public static void setElementFormatMode(@DTConfigConstants.ElementFormatMode int i3) {
        sElementFormatMode = i3;
    }
}
