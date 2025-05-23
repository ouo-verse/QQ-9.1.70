package com.heytap.databaseengine.option;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.SportHealthData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataInsertOption implements Parcelable {
    public static final Parcelable.Creator<DataInsertOption> CREATOR = new Parcelable.Creator<DataInsertOption>() { // from class: com.heytap.databaseengine.option.DataInsertOption.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataInsertOption createFromParcel(Parcel parcel) {
            return new DataInsertOption(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataInsertOption[] newArray(int i3) {
            return new DataInsertOption[i3];
        }
    };
    private int dataTable;
    private List<SportHealthData> datas;

    public DataInsertOption() {
        this.datas = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDataTable() {
        return this.dataTable;
    }

    public List<SportHealthData> getDatas() {
        return this.datas;
    }

    public void setDataTable(int i3) {
        this.dataTable = i3;
    }

    public void setDatas(List<SportHealthData> list) {
        this.datas = list;
    }

    public String toString() {
        return "DataInsertOption{datas=" + this.datas + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.datas);
        parcel.writeInt(this.dataTable);
    }

    protected DataInsertOption(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.datas = arrayList;
        parcel.readList(arrayList, SportHealthData.class.getClassLoader());
        this.dataTable = parcel.readInt();
    }
}
