package com.qzone.widget.eventwidget;

import MOBILE_QZMALL_PROTOCOL.DescInfo;
import MOBILE_QZMALL_PROTOCOL.EventWidgetInfo;
import MOBILE_QZMALL_PROTOCOL.VideoInfo;
import MOBILE_QZMALL_PROTOCOL.VideoSpec;
import MOBILE_QZMALL_PROTOCOL.VideoUrl;
import MOBILE_QZMALL_PROTOCOL.WidgetInfo;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.qzoneplayer.video.PictureUrl;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneEventWidgetData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<QZoneEventWidgetData> DB_CREATOR = new a();
    public static final String EVENTWIDGET_DATA = "eventwidget_data";
    public static final String TAG = "QZoneEventWidgetData";
    public static final String TYPE_COMMWIDGET_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 2;

    @NeedParcel
    public boolean bShow;

    @NeedParcel
    public int from;

    @NeedParcel
    public DescInfo stDescInfo;

    @NeedParcel
    public VideoInfo stVideoInfo;

    @NeedParcel
    public String strBubbleDesc;

    @NeedParcel
    public String strJumpUrl;

    @NeedParcel
    public String strMaterialUrl;

    @NeedParcel
    public String strTraceInfo;

    @NeedParcel
    public int type;

    @NeedParcel
    public long uin = 0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements IDBCacheDataWrapper.a<QZoneEventWidgetData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            if (r0 != null) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        
            com.tencent.qmethod.pandoraex.monitor.OaidMonitor.parcelRecycle(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        
            if (r0 == null) goto L12;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public QZoneEventWidgetData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(QZoneEventWidgetData.EVENTWIDGET_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    QZoneEventWidgetData qZoneEventWidgetData = (QZoneEventWidgetData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return qZoneEventWidgetData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    QZLog.w("TAG", "OutOfMemoryError! EventWidgetData createFromCursor Error");
                }
            } catch (Throwable th5) {
                if (obtain != null) {
                    OaidMonitor.parcelRecycle(obtain);
                }
                throw th5;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(QZoneEventWidgetData.EVENTWIDGET_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }
    }

    public VideoPlayInfo toVideoPlayInfo(int i3, int i16) {
        try {
            VideoPlayInfo videoPlayInfo = new VideoPlayInfo();
            PictureUrl pictureUrl = new PictureUrl();
            videoPlayInfo.coverUrl = pictureUrl;
            VideoInfo videoInfo = this.stVideoInfo;
            pictureUrl.url = videoInfo.stVideoUrl.strCoverUrl;
            VideoSpec videoSpec = videoInfo.stVideoSpec;
            pictureUrl.width = (int) videoSpec.uiWidth;
            pictureUrl.height = (int) videoSpec.uiHeight;
            PictureUrl pictureUrl2 = new PictureUrl();
            videoPlayInfo.currentUrl = pictureUrl2;
            VideoInfo videoInfo2 = this.stVideoInfo;
            String str = videoInfo2.stVideoUrl.strContentUrl;
            pictureUrl2.url = str;
            VideoSpec videoSpec2 = videoInfo2.stVideoSpec;
            pictureUrl2.width = (int) videoSpec2.uiWidth;
            pictureUrl2.height = (int) videoSpec2.uiHeight;
            videoPlayInfo.downloadUrl = str;
            videoPlayInfo.width = i3;
            videoPlayInfo.height = i16;
            videoPlayInfo.isAutoPlay = true;
            videoPlayInfo.isCircle = true;
            videoPlayInfo.videoTime = 12000L;
            videoPlayInfo.originVideoSize = videoSpec2.uiSize;
            HashMap<Integer, SegmentVideoInfo.StreamInfo> hashMap = new HashMap<>();
            VideoUrl videoUrl = this.stVideoInfo.stVideoUrl;
            if (videoUrl != null && !TextUtils.isEmpty(videoUrl.strContentUrl)) {
                SegmentVideoInfo.StreamInfo streamInfo = new SegmentVideoInfo.StreamInfo(this.stVideoInfo.stVideoUrl.strContentUrl, (int) videoPlayInfo.videoTime);
                streamInfo.isHLSLive = false;
                hashMap.put(0, streamInfo);
                hashMap.put(1, streamInfo);
                hashMap.put(2, streamInfo);
                hashMap.put(3, streamInfo);
                hashMap.put(4, streamInfo);
            }
            videoPlayInfo.segmentVideoInfo.setStreams(hashMap);
            videoPlayInfo.videoPlayScene = "1";
            videoPlayInfo.videoFeedsType = 0;
            videoPlayInfo.playPositionA = 0;
            videoPlayInfo.playPositionB = 10;
            return videoPlayInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(EVENTWIDGET_DATA, marshall);
    }

    public static QZoneEventWidgetData createFromResponse(long j3, WidgetInfo widgetInfo) {
        if (widgetInfo == null || widgetInfo.stCommWidgetInfo == null) {
            return null;
        }
        QZoneEventWidgetData qZoneEventWidgetData = new QZoneEventWidgetData();
        qZoneEventWidgetData.uin = j3;
        EventWidgetInfo eventWidgetInfo = widgetInfo.stEventWidgetInfo;
        qZoneEventWidgetData.bShow = eventWidgetInfo.bShow;
        qZoneEventWidgetData.type = eventWidgetInfo.type;
        qZoneEventWidgetData.strMaterialUrl = eventWidgetInfo.strMaterialUrl;
        qZoneEventWidgetData.stVideoInfo = eventWidgetInfo.stVideoInfo;
        String str = eventWidgetInfo.strJumpUrl;
        qZoneEventWidgetData.strJumpUrl = str;
        qZoneEventWidgetData.strJumpUrl = MobileReportManager.getStringWithQbossTrace(str, eventWidgetInfo.strTraceInfo);
        EventWidgetInfo eventWidgetInfo2 = widgetInfo.stEventWidgetInfo;
        DescInfo descInfo = eventWidgetInfo2.stDescInfo;
        qZoneEventWidgetData.stDescInfo = descInfo;
        qZoneEventWidgetData.strBubbleDesc = eventWidgetInfo2.strBubbleDesc;
        qZoneEventWidgetData.stDescInfo = descInfo;
        qZoneEventWidgetData.strTraceInfo = eventWidgetInfo2.strTraceInfo;
        qZoneEventWidgetData.from = widgetInfo.src;
        return qZoneEventWidgetData;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QZoneEventWidgetData)) {
            return false;
        }
        QZoneEventWidgetData qZoneEventWidgetData = (QZoneEventWidgetData) obj;
        return this.uin == qZoneEventWidgetData.uin && this.bShow == qZoneEventWidgetData.bShow && this.type == qZoneEventWidgetData.type && this.from == qZoneEventWidgetData.from && TextUtils.equals(this.strMaterialUrl, qZoneEventWidgetData.strMaterialUrl) && b.c(this.stVideoInfo, qZoneEventWidgetData.stVideoInfo) && TextUtils.equals(this.strJumpUrl, qZoneEventWidgetData.strJumpUrl) && TextUtils.equals(this.strBubbleDesc, qZoneEventWidgetData.strBubbleDesc) && TextUtils.equals(this.strTraceInfo, qZoneEventWidgetData.strTraceInfo) && b.a(this.stDescInfo, qZoneEventWidgetData.stDescInfo);
    }
}
