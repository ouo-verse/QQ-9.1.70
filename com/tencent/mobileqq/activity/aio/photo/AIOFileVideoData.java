package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOFileVideoData extends AIORichMediaData {
    public String F;
    public String G;
    public String H;
    public long I;
    public int J;
    public int K;
    public boolean L = false;
    public boolean M = false;
    public long N = 0;
    public boolean P = false;
    private String Q = null;
    public boolean R = false;
    public boolean S = false;
    private boolean T = false;
    public String U;
    public int V;
    public int W;
    public String X;
    public String Y;

    public AIOFileVideoData() {
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public File a(int i3) {
        if (!com.tencent.mobileqq.filemanager.util.q.f(this.G)) {
            return null;
        }
        return new File(this.G);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public String b(int i3) {
        if (TextUtils.isEmpty(this.G)) {
            return "";
        }
        if (!this.G.startsWith("/")) {
            return "file:/" + this.G;
        }
        if (this.G.startsWith("//")) {
            return HippyBridge.URI_SCHEME_FILE + this.G;
        }
        return HippyBridge.URI_SCHEME_FILE + this.G;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public void e(Parcel parcel) {
        super.e(parcel);
        this.G = parcel.readString();
        this.F = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        boolean z16 = true;
        if (parcel.readInt() != 1) {
            z16 = false;
        }
        this.P = z16;
        this.U = parcel.readString();
        this.V = parcel.readInt();
        this.W = parcel.readInt();
        this.X = parcel.readString();
        this.Y = parcel.readString();
    }

    public void f(DataLineMsgRecord dataLineMsgRecord) {
        this.U = dataLineMsgRecord.frienduin;
        this.V = dataLineMsgRecord.istroop;
        this.W = dataLineMsgRecord.issend;
        this.f179628d = dataLineMsgRecord.uniseq;
        this.f179630f = dataLineMsgRecord.time;
        this.f179632i = dataLineMsgRecord.shmsgseq;
        this.f179631h = dataLineMsgRecord.filesize;
        this.F = dataLineMsgRecord.filename;
        this.f179633m = 0;
        if (FileUtils.fileExistsAndNotEmpty(dataLineMsgRecord.path)) {
            this.H = dataLineMsgRecord.path;
            this.P = true;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.G);
        parcel.writeString(this.F);
        parcel.writeString(this.H);
        parcel.writeLong(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.P ? 1 : 0);
        parcel.writeString(this.U);
        parcel.writeInt(this.V);
        parcel.writeInt(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
    }

    public AIOFileVideoData(String str) {
        this.G = str;
    }
}
