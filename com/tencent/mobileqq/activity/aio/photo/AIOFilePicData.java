package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;

/* loaded from: classes10.dex */
public class AIOFilePicData extends AIORichMediaData {
    public String F;
    public int G;
    public FileManagerEntity P;
    public String U;
    public int V;
    public String W;
    public String X;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f179567a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f179568b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f179569c0;
    public String H = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String I = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String J = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String K = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public boolean L = false;
    public boolean M = false;
    public boolean N = false;
    public boolean Q = false;
    public long R = 0;
    public long S = 0;
    public boolean T = false;
    public boolean Y = false;

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public File a(int i3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    str = null;
                } else {
                    str = this.J;
                }
            } else {
                str = this.I;
            }
        } else {
            str = this.H;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public String b(int i3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    str = null;
                } else {
                    str = this.J;
                }
            } else {
                str = this.I;
            }
        } else {
            str = this.H;
        }
        if (str == null || str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            return null;
        }
        if (!str.startsWith("/")) {
            return "file:/" + str;
        }
        if (str.startsWith("//")) {
            return HippyBridge.URI_SCHEME_FILE + str;
        }
        return HippyBridge.URI_SCHEME_FILE + str;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public void e(Parcel parcel) {
        super.e(parcel);
        this.F = parcel.readString();
        this.G = parcel.readInt();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readInt();
        this.W = parcel.readString();
        this.Q = Boolean.valueOf(parcel.readString()).booleanValue();
        this.R = Long.valueOf(parcel.readString()).longValue();
        this.S = Long.valueOf(parcel.readString()).longValue();
        this.T = Boolean.valueOf(parcel.readString()).booleanValue();
        this.X = parcel.readString();
        boolean z16 = true;
        if (parcel.readInt() != 1) {
            z16 = false;
        }
        this.Y = z16;
        this.Z = parcel.readString();
        this.f179567a0 = parcel.readInt();
        this.f179568b0 = parcel.readInt();
        this.f179569c0 = parcel.readInt();
    }

    public void f(DataLineMsgRecord dataLineMsgRecord) {
        String str;
        if (dataLineMsgRecord == null) {
            return;
        }
        String str2 = dataLineMsgRecord.thumbPath;
        String str3 = AIOBrowserBaseData.MEDIA_FILE_NONE;
        if (str2 != null) {
            str = str2;
        } else {
            str = AIOBrowserBaseData.MEDIA_FILE_NONE;
        }
        this.H = str;
        if (str2 == null) {
            str2 = AIOBrowserBaseData.MEDIA_FILE_NONE;
        }
        this.I = str2;
        String str4 = dataLineMsgRecord.path;
        if (str4 != null) {
            str3 = str4;
        }
        this.J = str3;
        this.W = dataLineMsgRecord.filename;
        long j3 = dataLineMsgRecord.filesize;
        this.R = j3;
        this.f179631h = j3;
        this.T = false;
    }

    public void g(t tVar) {
        boolean z16;
        if (tVar == null) {
            return;
        }
        String str = tVar.f294981o;
        String str2 = AIOBrowserBaseData.MEDIA_FILE_NONE;
        if (str == null) {
            str = AIOBrowserBaseData.MEDIA_FILE_NONE;
        }
        this.H = str;
        String str3 = tVar.f294980n;
        if (str3 == null) {
            str3 = AIOBrowserBaseData.MEDIA_FILE_NONE;
        }
        this.I = str3;
        String str4 = tVar.f294978l;
        if (str4 != null) {
            str2 = str4;
        }
        this.J = str2;
        this.W = tVar.f294987u;
        if (tVar.f294972f == 12) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.Q = z16;
        long j3 = tVar.f294976j;
        this.R = j3;
        this.f179631h = j3;
        this.T = false;
    }

    public void j(QQAppInterface qQAppInterface) {
        boolean z16;
        if (this.P == null) {
            this.P = qQAppInterface.getFileManagerDataCenter().E(this.f179628d, this.F, this.G);
        }
        FileManagerEntity fileManagerEntity = this.P;
        if (fileManagerEntity != null) {
            String str = fileManagerEntity.strMiddleThumPath;
            String str2 = AIOBrowserBaseData.MEDIA_FILE_NONE;
            if (str == null) {
                str = AIOBrowserBaseData.MEDIA_FILE_NONE;
            }
            this.H = str;
            String str3 = fileManagerEntity.strLargeThumPath;
            if (str3 == null) {
                str3 = AIOBrowserBaseData.MEDIA_FILE_NONE;
            }
            this.I = str3;
            if (fileManagerEntity.getFilePath() != null) {
                str2 = this.P.getFilePath();
            }
            this.J = str2;
            FileManagerEntity fileManagerEntity2 = this.P;
            this.W = fileManagerEntity2.fileName;
            if (fileManagerEntity2.status == 16) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.Q = z16;
            long j3 = fileManagerEntity2.fileSize;
            this.R = j3;
            this.f179631h = j3;
            this.S = fileManagerEntity2.lastSuccessTime;
            this.T = fileManagerEntity2.sendCloudUnsuccessful();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.F);
        parcel.writeInt(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.U);
        parcel.writeInt(this.V);
        parcel.writeString(this.W);
        parcel.writeString(String.valueOf(this.Q));
        parcel.writeString(String.valueOf(this.R));
        parcel.writeString(String.valueOf(this.S));
        parcel.writeString(String.valueOf(this.T));
        parcel.writeString(this.X);
        parcel.writeInt(this.Y ? 1 : 0);
        parcel.writeString(this.Z);
        parcel.writeInt(this.f179567a0);
        parcel.writeInt(this.f179568b0);
        parcel.writeInt(this.f179569c0);
    }
}
