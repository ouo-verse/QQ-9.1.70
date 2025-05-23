package com.tencent.biz.qqcircle.helpers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* loaded from: classes4.dex */
public class QFSPublicListTabCommonHelper {
    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("xsj_custom_pgid");
    }

    public static QCircleInitBean b(Intent intent) {
        Serializable serializableExtra;
        if (intent == null) {
            serializableExtra = null;
        } else {
            serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        }
        if (!(serializableExtra instanceof QCircleInitBean)) {
            return null;
        }
        return (QCircleInitBean) serializableExtra;
    }

    public static int c(int i3, List<QQCircleFeedBase$StTabInfo> list) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = (QQCircleFeedBase$StTabInfo) RFSafeListUtils.get(list, i3);
        if (qQCircleFeedBase$StTabInfo == null) {
            return -1;
        }
        return qQCircleFeedBase$StTabInfo.tabType.get();
    }

    public static List<QQCircleFeedBase$StTabInfo> d(Intent intent) {
        Bundle extras;
        if (intent == null) {
            extras = null;
        } else {
            extras = intent.getExtras();
        }
        return e(extras);
    }

    public static List<QQCircleFeedBase$StTabInfo> e(Bundle bundle) {
        if (bundle == null) {
            QLog.e("NFT-QFSPublicListTabCommonHelper", 1, "[getTabInfoList] intent should not be null.");
            return null;
        }
        ArrayList<Parcelable> parcelableArrayList = bundle.getParcelableArrayList("common_public_list_tabs");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : parcelableArrayList) {
            if (!(parcelable instanceof MsgTabEntity)) {
                return null;
            }
            MsgTabEntity msgTabEntity = (MsgTabEntity) parcelable;
            QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = new QQCircleFeedBase$StTabInfo();
            qQCircleFeedBase$StTabInfo.tabName.set(msgTabEntity.a());
            qQCircleFeedBase$StTabInfo.tabType.set(msgTabEntity.b());
            arrayList.add(qQCircleFeedBase$StTabInfo);
        }
        return arrayList;
    }

    public static String f(List<QQCircleFeedBase$StTabInfo> list, int i3) {
        if (list == null) {
            return "";
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = list.get(i16);
            PBUInt32Field pBUInt32Field = qQCircleFeedBase$StTabInfo.tabType;
            if (pBUInt32Field != null && pBUInt32Field.get() == i3) {
                return qQCircleFeedBase$StTabInfo.tabName.get();
            }
        }
        return "";
    }

    public static int g(HashMap<String, String> hashMap, List<QQCircleFeedBase$StTabInfo> list) {
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                return h(list, Integer.parseInt(hashMap.get("to_sub_category").toString()));
            } catch (Exception e16) {
                QLog.w("NFT-QFSPublicListTabCommonHelper", 1, "error: ", e16);
                return 0;
            }
        }
        QLog.w("NFT-QFSPublicListTabCommonHelper", 1, "[getTabTypeToPosition] schemeAttrs == null || schemeAttrs.isEmpty().");
        return 0;
    }

    public static int h(List<QQCircleFeedBase$StTabInfo> list, int i3) {
        if (list == null) {
            return 0;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            PBUInt32Field pBUInt32Field = list.get(i16).tabType;
            if (pBUInt32Field != null && pBUInt32Field.get() == i3) {
                return i16;
            }
        }
        return 0;
    }

    /* loaded from: classes4.dex */
    public static class MsgTabEntity implements Parcelable {
        public static final Parcelable.Creator<MsgTabEntity> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private String f84575d;

        /* renamed from: e, reason: collision with root package name */
        private int f84576e;

        /* loaded from: classes4.dex */
        class a implements Parcelable.Creator<MsgTabEntity> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MsgTabEntity createFromParcel(Parcel parcel) {
                return new MsgTabEntity(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MsgTabEntity[] newArray(int i3) {
                return new MsgTabEntity[i3];
            }
        }

        public MsgTabEntity(String str, int i3) {
            this.f84575d = str;
            this.f84576e = i3;
        }

        public String a() {
            return this.f84575d;
        }

        public int b() {
            return this.f84576e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f84575d);
            parcel.writeInt(this.f84576e);
        }

        protected MsgTabEntity(Parcel parcel) {
            this.f84575d = parcel.readString();
            this.f84576e = parcel.readInt();
        }
    }
}
