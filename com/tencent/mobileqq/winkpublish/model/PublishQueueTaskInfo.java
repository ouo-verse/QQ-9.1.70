package com.tencent.mobileqq.winkpublish.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
/* loaded from: classes21.dex */
public class PublishQueueTaskInfo implements Parcelable {
    public static final Parcelable.Creator<PublishQueueTaskInfo> CREATOR = new a();
    public String detail;
    public int leftCount;
    public int progress;
    public long recvDataSize;
    public boolean showHandleProgress;
    public boolean showPreviewIcon;
    public int state;
    public String tipsMsg;
    public String title;
    public long totalSize;
    public String url;

    /* loaded from: classes21.dex */
    public static final class PublishQueueTaskInfoBuilder {
        public String detail;
        public int leftCount;
        public int progress;
        public long recvDataSize;
        public boolean showHandleProgress;
        public boolean showPreviewIcon;
        public int state;
        public String tipsMsg;
        public String title;
        public long totalSize;
        public String url;

        PublishQueueTaskInfoBuilder() {
        }

        public static PublishQueueTaskInfoBuilder aPublishQueueTaskInfo() {
            return new PublishQueueTaskInfoBuilder();
        }

        public PublishQueueTaskInfo build() {
            PublishQueueTaskInfo publishQueueTaskInfo = new PublishQueueTaskInfo();
            publishQueueTaskInfo.showPreviewIcon = this.showPreviewIcon;
            publishQueueTaskInfo.title = this.title;
            publishQueueTaskInfo.leftCount = this.leftCount;
            publishQueueTaskInfo.tipsMsg = this.tipsMsg;
            publishQueueTaskInfo.detail = this.detail;
            publishQueueTaskInfo.url = this.url;
            publishQueueTaskInfo.totalSize = this.totalSize;
            publishQueueTaskInfo.state = this.state;
            publishQueueTaskInfo.recvDataSize = this.recvDataSize;
            publishQueueTaskInfo.progress = this.progress;
            publishQueueTaskInfo.showHandleProgress = this.showHandleProgress;
            return publishQueueTaskInfo;
        }

        public PublishQueueTaskInfoBuilder withDetail(String str) {
            this.detail = str;
            return this;
        }

        public PublishQueueTaskInfoBuilder withLeftCount(int i3) {
            this.leftCount = i3;
            return this;
        }

        public PublishQueueTaskInfoBuilder withProgress(int i3) {
            this.progress = i3;
            return this;
        }

        public PublishQueueTaskInfoBuilder withRecvDataSize(long j3) {
            this.recvDataSize = j3;
            return this;
        }

        public PublishQueueTaskInfoBuilder withShowHandleProgress(boolean z16) {
            this.showHandleProgress = z16;
            return this;
        }

        public PublishQueueTaskInfoBuilder withShowPreviewIcon(boolean z16) {
            this.showPreviewIcon = z16;
            return this;
        }

        public PublishQueueTaskInfoBuilder withState(int i3) {
            this.state = i3;
            return this;
        }

        public PublishQueueTaskInfoBuilder withTipsMsg(String str) {
            this.tipsMsg = str;
            return this;
        }

        public PublishQueueTaskInfoBuilder withTitle(String str) {
            this.title = str;
            return this;
        }

        public PublishQueueTaskInfoBuilder withTotalSize(long j3) {
            this.totalSize = j3;
            return this;
        }

        public PublishQueueTaskInfoBuilder withUrl(String str) {
            this.url = str;
            return this;
        }
    }

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<PublishQueueTaskInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PublishQueueTaskInfo createFromParcel(Parcel parcel) {
            return new PublishQueueTaskInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PublishQueueTaskInfo[] newArray(int i3) {
            return new PublishQueueTaskInfo[i3];
        }
    }

    public PublishQueueTaskInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        this.title = parcel.readString();
        this.detail = parcel.readString();
        this.state = parcel.readInt();
        this.recvDataSize = parcel.readLong();
        this.totalSize = parcel.readLong();
        this.progress = parcel.readInt();
        boolean z17 = true;
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.showHandleProgress = z16;
        this.url = parcel.readString();
        if (parcel.readByte() == 0) {
            z17 = false;
        }
        this.showPreviewIcon = z17;
        this.leftCount = parcel.readInt();
        this.tipsMsg = parcel.readString();
    }

    public String toString() {
        return "QCircleQueueTaskInfo [title=" + this.title + ", detail=" + this.detail + ", state=" + this.state + ", recvDataSize=" + this.recvDataSize + ", totalSize=" + this.totalSize + ", progress=" + this.progress + ", url=" + this.url + ", showVideoPreview=" + this.showPreviewIcon + ", leftCount=" + this.leftCount + ",tipsMsg=" + this.tipsMsg + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.title);
        parcel.writeString(this.detail);
        parcel.writeInt(this.state);
        parcel.writeLong(this.recvDataSize);
        parcel.writeLong(this.totalSize);
        parcel.writeInt(this.progress);
        parcel.writeByte(this.showHandleProgress ? (byte) 1 : (byte) 0);
        parcel.writeString(this.url);
        parcel.writeByte(this.showPreviewIcon ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.leftCount);
        parcel.writeString(this.tipsMsg);
    }

    protected PublishQueueTaskInfo(Parcel parcel) {
        this.title = parcel.readString();
        this.detail = parcel.readString();
        this.state = parcel.readInt();
        this.recvDataSize = parcel.readLong();
        this.totalSize = parcel.readLong();
        this.progress = parcel.readInt();
        this.showHandleProgress = parcel.readByte() != 0;
        this.url = parcel.readString();
        this.showPreviewIcon = parcel.readByte() != 0;
        this.leftCount = parcel.readInt();
        this.tipsMsg = parcel.readString();
    }
}
