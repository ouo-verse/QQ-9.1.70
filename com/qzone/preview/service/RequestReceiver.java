package com.qzone.preview.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.remote.RecvMsg;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RequestReceiver implements PictureConst {
    @ServiceCmd(PictureConst.CMD_COMMENT_PHOTO)
    public void OnReceivedCommentPhoto(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 999905;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_DELETE_PHOTO)
    public void OnReceivedDeletePhoto(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 999909;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_FORWARD_PHOTO)
    public void OnReceivedForwardPhoto(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 999908;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_GET_BIG_PHOTO_AD_LIST)
    public void OnReceivedGetBigPhotoAdList(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_GET_OUT_SHARE_URL)
    public void OnReceivedGetOutShareUrl(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 1000083;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_GET_QZONE_PHOTOCOMMENTEX)
    public void OnReceivedGetQzonePhotoCommentEx(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 1000199;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_GET_VIDEO_ID)
    public void OnReceivedGetVideoId(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 1000084;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_PRAISE_PHOTO)
    public void OnReceivedPraisePhoto(RecvMsg recvMsg, Handler handler) {
        Message obtain = Message.obtain();
        obtain.what = 999906;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_DEL_LOCAL_PHOTO)
    public void onReceivedDelLocalPhoto(RecvMsg recvMsg, Handler handler) {
        String string = recvMsg.extraData.getString("data");
        Message obtain = Message.obtain();
        obtain.what = 999976;
        obtain.obj = string;
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_MODIFY_SELECT_FLAG_PHOTO)
    public void onReceivedModifySelectFlagPhoto(RecvMsg recvMsg, Handler handler) {
        Bundle bundle = (Bundle) recvMsg.extraData.get("data");
        Message obtain = Message.obtain();
        obtain.what = 999977;
        obtain.obj = bundle;
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_ADD_FACES)
    public void onReceivedAddFaces(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000045;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_ADD_FAVOR)
    public void onReceivedAddFavor(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000028;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_COMMENT_FEED)
    public void onReceivedCommentFeed(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999905;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedCommentFeed");
    }

    @ServiceCmd(PictureConst.CMD_COMMENT_FRIEND_VIDEO)
    public void onReceivedCommentFriendVideo(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000166;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedCommentFriendVideo");
    }

    @ServiceCmd(PictureConst.CMD_DEL_FACES)
    public void onReceivedDelFaces(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000046;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_DEL_FAVOR)
    public void onReceivedDelFavor(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000029;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_DELETE_COMMENT)
    public void onReceivedDeleteComment(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999978;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedDeleteComment");
    }

    @ServiceCmd(PictureConst.CMD_DELETE_REPLY)
    public void onReceivedDeleteReply(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999978;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedDeleteReply");
    }

    @ServiceCmd(PictureConst.CMD_EDIT_PHOTOINFO)
    public void onReceivedEditPhotoInfo(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000118;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_CLOUD_BATCH_FACE_RECOGNIZE)
    public void onReceivedFaceBatchRecognize(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000191;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_FACE_OPERATION)
    public void onReceivedFaceOperation(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000192;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_FORWARD_FRIEND_VIDEO)
    public void onReceivedForwardFriendVideo(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999908;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedForwardFriendVideo");
    }

    @ServiceCmd(PictureConst.CMD_GET_FACES)
    public void onReceivedGetFaces(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000044;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_GET_FAVOR_STATE)
    public void onReceivedGetFavorState(RecvMsg recvMsg, Handler handler) {
        Bundle bundle;
        if (recvMsg == null || (bundle = recvMsg.extraData) == null) {
            return;
        }
        String str = (String) bundle.get("data");
        Message obtain = Message.obtain();
        obtain.obj = Boolean.valueOf(str != null);
        obtain.what = 1000030;
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_GET_FEED_COMMENT)
    public void onReceivedGetFeedComment(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = (QZoneTask) ((ParcelableWrapper) recvMsg.extraData.get("data")).getData();
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedGetFeedComment");
    }

    @ServiceCmd(PictureConst.CMD_GET_MORE_COMMENT)
    public void onReceivedGetMoreComment(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = (QZoneTask) ((ParcelableWrapper) recvMsg.extraData.get("data")).getData();
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedGetMoreComment");
    }

    @ServiceCmd(PictureConst.CMD_GET_MORE_COMMENT_ESSENCE)
    public void onReceivedGetMoreCommentEssence(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = (QZoneTask) ((ParcelableWrapper) recvMsg.extraData.get("data")).getData();
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedGetMoreCommentEssence");
    }

    @ServiceCmd(PictureConst.CMD_LIKE_COMMENT)
    public void onReceivedLikeComment(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000185;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_PRAISE_FRIEND_VIDEO)
    public void onReceivedPraiseFriendVideo(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1000179;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedPriseFriendVideo");
    }

    @ServiceCmd(PictureConst.CMD_QUERY_ALBUM)
    public void onReceivedQueryAlbum(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999969;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }

    @ServiceCmd(PictureConst.CMD_REPLY_FEED)
    public void onReceivedReplyFeed(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999907;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
        System.out.println("----------------onReceivedReplyFeed");
    }

    @ServiceCmd(PictureConst.CMD_RESHIP)
    public void onReceivedReship(RecvMsg recvMsg, Handler handler) {
        if (recvMsg == null || recvMsg.extraData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 999908;
        obtain.obj = recvMsg.extraData.get("data");
        handler.sendMessage(obtain);
    }
}
