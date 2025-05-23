package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class RichProtoProc {
    static IPatchRedirector $redirector_ = null;
    public static final String ART_FILTER_UP = "art_filter_up";
    public static final String BDH_COMMON_UP = "bdh_common_up";
    public static final String C2C_PIC_DW = "c2c_pic_dw";
    public static final String C2C_PIC_UP = "c2c_pic_up";
    public static final String C2C_PTT_DW = "c2c_ptt_dw";
    public static final String C2C_PTT_UP = "c2c_ptt_up";
    public static final String FRIEND_AVATAR_UP = "friend_avatar_up";
    public static final String GLD_PIC_DW = "gld_pic_dw";
    public static final String GLD_PIC_UP = "gld_pic_up";
    public static final String GRP_PIC_DW = "grp_pic_dw";
    public static final String GRP_PIC_UP = "grp_pic_up";
    public static final String GRP_PTT_DW = "grp_ptt_dw";
    public static final String GRP_PTT_UP = "grp_ptt_up";
    public static final String MULTI_MSG_DW = "multi_msg_dw";
    public static final String MULTI_MSG_UP = "multi_msg_up";
    public static final String NEARBY_PEOPLE_PIC_UP = "nearby_people_pic_up";
    public static final String PA_LONG_MESSAGE = "pa_long_message";
    public static final String SHARE_PIC_TO_WX = "share_pic_to_wx";
    public static final String SHORT_VIDEO_DW = "short_video_dw";
    public static final String SHORT_VIDEO_FW = "short_video_fw";
    public static final String SHORT_VIDEO_UP = "short_video_up";
    public static final String SNAP_PIC_UP = "snap_pic_up";

    @ConfigInject(configPath = "Foundation/Transfile/src/main/resources/Inject_InitProtoHandlerConfig.yml", version = 2)
    public static HashMap<String, Class<? extends RichProtoHandler>> handlerMaps;

    /* loaded from: classes19.dex */
    public interface RichProtoCallback {
        void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp);
    }

    /* loaded from: classes19.dex */
    public interface RichProtoHandler {
        void sendRichProtoReq(RichProto.RichProtoReq richProtoReq);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends RichProtoHandler>> hashMap = new HashMap<>();
        handlerMaps = hashMap;
        hashMap.put(SHARE_PIC_TO_WX, SharePicToWXUpHandler.class);
        handlerMaps.put(PA_LONG_MESSAGE, PALongMessageHandler.class);
        handlerMaps.put(BDH_COMMON_UP, BDHCommonUpHandler.class);
        handlerMaps.put(SHORT_VIDEO_FW, ShortVideoForwardHandler.class);
        handlerMaps.put(FRIEND_AVATAR_UP, NearbyPeoplePicUpHandler.class);
        handlerMaps.put(NEARBY_PEOPLE_PIC_UP, NearbyPeoplePicUpHandler.class);
        handlerMaps.put(MULTI_MSG_UP, MultiMsgUpHandler.class);
        handlerMaps.put(MULTI_MSG_DW, MultiMsgDownHandler.class);
        handlerMaps.put(SHORT_VIDEO_UP, ShortVideoUpHandler.class);
        handlerMaps.put(SHORT_VIDEO_DW, ShortVideoDownHandler.class);
        handlerMaps.put(GRP_PTT_DW, GroupPttDownHandler.class);
        handlerMaps.put(C2C_PTT_DW, C2CPttDownHandler.class);
        handlerMaps.put(C2C_PTT_UP, C2CPttUpHandler.class);
        handlerMaps.put(GLD_PIC_DW, GuildPicDownHandler.class);
        handlerMaps.put(GRP_PIC_DW, GroupPicDownHandler.class);
        handlerMaps.put(C2C_PIC_DW, C2CPicDownHandler.class);
        handlerMaps.put(GRP_PTT_UP, GroupPttUpHandler.class);
        handlerMaps.put(GLD_PIC_UP, GuildPicUpHandler.class);
        handlerMaps.put(GRP_PIC_UP, GroupPicUpHandler.class);
        handlerMaps.put(C2C_PIC_UP, C2CPicUpHandler.class);
    }

    public RichProtoProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cancelRichProtoReq(RichProto.RichProtoReq richProtoReq) {
        IProtoReqManager iProtoReqManager;
        if (richProtoReq != null && (iProtoReqManager = richProtoReq.protoReqMgr) != null) {
            iProtoReqManager.cancelReq(richProtoReq.protoReq);
            richProtoReq.callback = null;
            richProtoReq.protoReq = null;
            richProtoReq.protoReqMgr = null;
        }
    }

    public static RichProtoHandler getHandler(RichProto.RichProtoReq richProtoReq) {
        if (richProtoReq != null && richProtoReq.protoReqMgr != null && richProtoReq.callback != null && richProtoReq.reqs.size() != 0) {
            Class<? extends RichProtoHandler> cls = handlerMaps.get(richProtoReq.protoKey);
            if (cls != null) {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                    return null;
                } catch (InstantiationException e17) {
                    e17.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public static void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        RichProtoCallback richProtoCallback;
        if (richProtoReq != null && (richProtoCallback = richProtoReq.callback) != null) {
            richProtoReq.protoReq = null;
            richProtoCallback.onBusiProtoResp(richProtoReq, richProtoResp);
            richProtoReq.callback = null;
            richProtoReq.protoReqMgr = null;
        }
    }

    public static void procRichProtoReq(RichProto.RichProtoReq richProtoReq) {
        RichProtoHandler handler = getHandler(richProtoReq);
        if (handler != null) {
            handler.sendRichProtoReq(richProtoReq);
        }
    }
}
