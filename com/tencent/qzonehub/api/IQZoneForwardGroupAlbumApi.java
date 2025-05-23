package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import cooperation.qzone.model.ForwardMediaInfo;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneForwardGroupAlbumApi extends QRouteApi {
    public static final int AIO_RESHIP_FROM_TYPE_AIO_LONG_CLICK = 1;
    public static final int AIO_RESHIP_FROM_TYPE_CHAT_HISTORY = 4;
    public static final int AIO_RESHIP_FROM_TYPE_LAYER_SHARE = 2;
    public static final int AIO_RESHIP_FROM_TYPE_MULTI_CHOICE_SHARE = 3;
    public static final int AIO_RESHIP_FROM_TYPE_SELECT_CHAT_HISTORY = 5;
    public static final int AIO_RESHIP_FROM_TYPE_SELECT_CHAT_HISTORY_ALBUM_PLUS = 7;
    public static final int AIO_RESHIP_FROM_TYPE_SELECT_CHAT_HISTORY_FEED_DETAIL = 6;
    public static final int AIO_RESHIP_FROM_TYPE_UNKNOWN = 0;

    boolean forwardToGroupAlbum(ForwardGroupAlbumBean forwardGroupAlbumBean, int i3);

    int getMediaType(MsgRecord msgRecord);

    boolean invalidMedia(MsgRecord msgRecord);

    boolean isMediaExpired(MsgRecord msgRecord);

    List<ForwardMediaInfo> msgRecordToMediaInfo(List<MsgRecord> list);
}
