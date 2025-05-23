package com.qzone.common.event.ui.model;

import NS_MOBILE_FEEDS.s_event_tag;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EventTag extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<EventTag> DB_CREATOR = new a();
    public static final String EVENT_TAG_DATA = "event_tag_data";
    public static final String TYPE_EVENT_TAG_DATA = "BLOB";

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public JoinList joinList;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public long time = 0;

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    public String f45884id = "";

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String showTxt = "";

    @NeedParcel
    public String showDesc = "";

    @NeedParcel
    public String picUrl = "";

    @NeedParcel
    public int picWidth = 0;

    @NeedParcel
    public int picHeight = 0;

    @NeedParcel
    public String count_desc = "";

    @NeedParcel
    public String joinDesc = "";

    @NeedParcel
    public int joinTruncateNum = 0;

    @NeedParcel
    public String backgd_picurl = "";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<EventTag> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EventTag createFromCursor(Cursor cursor) {
            Parcel parcel;
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(EventTag.EVENT_TAG_DATA));
            Parcel parcel2 = null;
            try {
                parcel = Parcel.obtain();
                try {
                    parcel.unmarshall(blob, 0, blob.length);
                    parcel.setDataPosition(0);
                    EventTag eventTag = (EventTag) ParcelableWrapper.createDataFromParcel(parcel);
                    OaidMonitor.parcelRecycle(parcel);
                    return eventTag;
                } catch (OutOfMemoryError unused) {
                    if (parcel == null) {
                        return null;
                    }
                    OaidMonitor.parcelRecycle(parcel);
                    return null;
                } catch (Error unused2) {
                    if (parcel == null) {
                        return null;
                    }
                    OaidMonitor.parcelRecycle(parcel);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    parcel2 = parcel;
                    if (parcel2 != null) {
                        OaidMonitor.parcelRecycle(parcel2);
                    }
                    throw th;
                }
            } catch (OutOfMemoryError unused3) {
                parcel = null;
            } catch (Error unused4) {
                parcel = null;
            } catch (Throwable th6) {
                th = th6;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(EventTag.EVENT_TAG_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public static EventTag convertToEventTag(s_event_tag s_event_tagVar) {
        if (s_event_tagVar == null) {
            return null;
        }
        EventTag eventTag = new EventTag();
        eventTag.uin = s_event_tagVar.uin;
        eventTag.time = s_event_tagVar.time;
        eventTag.f45884id = s_event_tagVar.f24992id;
        eventTag.title = s_event_tagVar.title;
        eventTag.showTxt = s_event_tagVar.show_txt;
        eventTag.showDesc = s_event_tagVar.show_desc;
        eventTag.picUrl = s_event_tagVar.pic_url;
        eventTag.picWidth = s_event_tagVar.pic_width;
        eventTag.picHeight = s_event_tagVar.pic_height;
        eventTag.count_desc = s_event_tagVar.count_desc;
        JoinList create = JoinList.create(s_event_tagVar.join_list);
        eventTag.joinList = create;
        Object[] b16 = b.b(create);
        if (b16 != null) {
            eventTag.joinDesc = (String) b16[0];
            eventTag.joinTruncateNum = ((Integer) b16[1]).intValue();
        }
        eventTag.extendInfo = s_event_tagVar.extendInfo;
        eventTag.backgd_picurl = s_event_tagVar.backgd_picurl;
        return eventTag;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EventTag)) {
            return false;
        }
        EventTag eventTag = (EventTag) obj;
        String str = this.f45884id;
        return str != null && str.equals(eventTag.f45884id);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(EVENT_TAG_DATA, marshall);
    }

    public static ArrayList<EventTag> convertToEventTag(List<s_event_tag> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList<EventTag> arrayList = new ArrayList<>();
        Iterator<s_event_tag> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(convertToEventTag(it.next()));
        }
        return arrayList;
    }
}
