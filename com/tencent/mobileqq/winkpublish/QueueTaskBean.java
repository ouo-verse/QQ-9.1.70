package com.tencent.mobileqq.winkpublish;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QueueTaskBean implements Parcelable {
    public static final Parcelable.Creator<QueueTaskBean> CREATOR = new a();
    String clientKey;
    PublishQueueTaskInfo info;
    boolean isTrueUpload;
    boolean isUseHDUpload;
    boolean isVideoTask;
    String missionId;
    String photoSource;
    List<String> photoSources;
    boolean showCloseBtn;
    int state;
    long taskId;
    String traceId;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class Builder {
        String clientKey;
        PublishQueueTaskInfo info;
        boolean isTrueUpload;
        boolean isUseHDUpload;
        boolean isVideoTask;
        String missionId;
        String photoSource;
        List<String> photoSources;
        boolean showCloseBtn;
        int state;
        long taskId;
        String traceId;

        Builder() {
        }

        public static Builder aQueueTaskBean() {
            return new Builder();
        }

        public QueueTaskBean build() {
            QueueTaskBean queueTaskBean = new QueueTaskBean();
            queueTaskBean.taskId = this.taskId;
            queueTaskBean.missionId = this.missionId;
            queueTaskBean.state = this.state;
            queueTaskBean.info = this.info;
            queueTaskBean.showCloseBtn = this.showCloseBtn;
            queueTaskBean.isVideoTask = this.isVideoTask;
            queueTaskBean.photoSources = this.photoSources;
            queueTaskBean.photoSource = this.photoSource;
            queueTaskBean.clientKey = this.clientKey;
            queueTaskBean.isUseHDUpload = this.isUseHDUpload;
            queueTaskBean.isTrueUpload = this.isTrueUpload;
            queueTaskBean.traceId = this.traceId;
            return queueTaskBean;
        }

        public Builder withClientKey(String str) {
            this.clientKey = str;
            return this;
        }

        public Builder withInfo(PublishQueueTaskInfo publishQueueTaskInfo) {
            this.info = publishQueueTaskInfo;
            return this;
        }

        public Builder withIsUseHDUpload(boolean z16) {
            this.isUseHDUpload = z16;
            return this;
        }

        public Builder withIsVideoTask(boolean z16) {
            this.isVideoTask = z16;
            return this;
        }

        public Builder withMissionId(String str) {
            this.missionId = str;
            return this;
        }

        public Builder withPhotoSource(String str) {
            this.photoSource = str;
            return this;
        }

        public Builder withPhotoSources(List<String> list) {
            this.photoSources = list;
            return this;
        }

        public Builder withShowCloseBtn(boolean z16) {
            this.showCloseBtn = z16;
            return this;
        }

        public Builder withState(int i3) {
            this.state = i3;
            return this;
        }

        public Builder withTaskId(long j3) {
            this.taskId = j3;
            return this;
        }

        public Builder withTraceId(String str) {
            this.traceId = str;
            return this;
        }

        public Builder withTrueUpload(boolean z16) {
            this.isTrueUpload = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<QueueTaskBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueueTaskBean createFromParcel(Parcel parcel) {
            return new QueueTaskBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QueueTaskBean[] newArray(int i3) {
            return new QueueTaskBean[i3];
        }
    }

    public QueueTaskBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public PublishQueueTaskInfo getInfo() {
        return this.info;
    }

    public String getMissionId() {
        return this.missionId;
    }

    public String getPhotoSource() {
        return this.photoSource;
    }

    public List<String> getPhotoSources() {
        return this.photoSources;
    }

    public int getState() {
        return this.state;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isTrueUpload() {
        return this.isTrueUpload;
    }

    public boolean isUploading() {
        int i3 = this.state;
        if (i3 == 0 || i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public boolean isUseHDUpload() {
        return this.isUseHDUpload;
    }

    public boolean isVideoTask() {
        return this.isVideoTask;
    }

    public boolean needShowCloseBt() {
        return this.showCloseBtn;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17;
        boolean z18;
        this.taskId = parcel.readLong();
        this.state = parcel.readInt();
        this.info = (PublishQueueTaskInfo) parcel.readParcelable(PublishQueueTaskInfo.class.getClassLoader());
        boolean z19 = true;
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isVideoTask = z16;
        this.photoSource = parcel.readString();
        this.photoSources = parcel.createStringArrayList();
        this.missionId = parcel.readString();
        if (parcel.readByte() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.showCloseBtn = z17;
        this.clientKey = parcel.readString();
        if (parcel.readByte() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.isUseHDUpload = z18;
        if (parcel.readByte() == 0) {
            z19 = false;
        }
        this.isTrueUpload = z19;
        this.traceId = parcel.readString();
    }

    public String toString() {
        return "QueueTaskBean{taskId=" + this.taskId + ", state=" + this.state + ", info=" + this.info + ", isVideoTask=" + this.isVideoTask + ", photoSource='" + this.photoSource + "', photoSources=" + this.photoSources + ", missionId='" + this.missionId + "', showCloseBtn=" + this.showCloseBtn + ", clientKey='" + this.clientKey + "', isTrueUpload='" + this.isTrueUpload + "', traceId='" + this.traceId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.state);
        parcel.writeParcelable(this.info, i3);
        parcel.writeByte(this.isVideoTask ? (byte) 1 : (byte) 0);
        parcel.writeString(this.photoSource);
        parcel.writeStringList(this.photoSources);
        parcel.writeString(this.missionId);
        parcel.writeByte(this.showCloseBtn ? (byte) 1 : (byte) 0);
        parcel.writeString(this.clientKey);
        parcel.writeByte(this.isUseHDUpload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTrueUpload ? (byte) 1 : (byte) 0);
        parcel.writeString(this.traceId);
    }

    protected QueueTaskBean(Parcel parcel) {
        this.taskId = parcel.readLong();
        this.state = parcel.readInt();
        this.info = (PublishQueueTaskInfo) parcel.readParcelable(PublishQueueTaskInfo.class.getClassLoader());
        this.isVideoTask = parcel.readByte() != 0;
        this.photoSource = parcel.readString();
        this.photoSources = parcel.createStringArrayList();
        this.missionId = parcel.readString();
        this.showCloseBtn = parcel.readByte() != 0;
        this.clientKey = parcel.readString();
        this.isUseHDUpload = parcel.readByte() != 0;
        this.isTrueUpload = parcel.readByte() != 0;
        this.traceId = parcel.readString();
    }
}
