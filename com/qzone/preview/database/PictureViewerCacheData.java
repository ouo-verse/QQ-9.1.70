package com.qzone.preview.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.common.account.LoginData;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import java.util.List;

/* loaded from: classes39.dex */
public class PictureViewerCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<PictureViewerCacheData> DB_CREATOR = new a();

    @NeedParcel
    public int getPicListFlag;

    @NeedParcel
    public boolean hasResponed;

    @NeedParcel
    public List<PhotoInfo> list;

    @NeedParcel
    public int mCurPhotoIndex;

    @NeedParcel
    public boolean mIsBottomBarUp;

    @NeedParcel
    public boolean mIsLeftFinish;

    @NeedParcel
    public boolean mIsRightFinish;

    @NeedParcel
    public int mLeftIndex;

    @NeedParcel
    public int mPhotoCount;

    @NeedParcel
    public int mRightIndex;

    @NeedParcel
    public PhotoParam photoParam;

    @NeedParcel
    public int pressIndex;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<PictureViewerCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureViewerCacheData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("source_data"));
            PictureViewerCacheData pictureViewerCacheData = null;
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                pictureViewerCacheData = PictureViewerCacheData.createCacheData(obtain);
                OaidMonitor.parcelRecycle(obtain);
                return pictureViewerCacheData;
            } catch (Throwable th5) {
                QZLog.w(th5);
                return pictureViewerCacheData;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("source_data", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public PictureViewerCacheData() {
        this.mLeftIndex = 0;
        this.mRightIndex = 0;
        this.mIsLeftFinish = true;
        this.mIsRightFinish = true;
        this.mIsBottomBarUp = true;
    }

    public static PictureViewerCacheData createCacheData(Parcel parcel) {
        return (PictureViewerCacheData) ParcelableWrapper.createDataFromParcel(parcel);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(LoginData.getInstance().getUin()));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("source_data", marshall);
    }

    public PictureViewerCacheData(List<PhotoInfo> list, int i3, int i16, int i17, int i18, int i19, int i26, boolean z16, boolean z17, boolean z18, PhotoParam photoParam, boolean z19) {
        this.list = list;
        this.mCurPhotoIndex = i3;
        this.mPhotoCount = i16;
        this.getPicListFlag = i17;
        this.pressIndex = i18;
        this.mLeftIndex = i19;
        this.mRightIndex = i26;
        this.mIsLeftFinish = z16;
        this.mIsRightFinish = z17;
        this.mIsBottomBarUp = z18;
        this.photoParam = photoParam;
        this.hasResponed = z19;
    }
}
