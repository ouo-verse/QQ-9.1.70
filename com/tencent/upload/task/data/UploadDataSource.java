package com.tencent.upload.task.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class UploadDataSource implements Parcelable {
    static IPatchRedirector $redirector_;

    public UploadDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract String calcSha1();

    public abstract boolean exists();

    public abstract long getDataLength();

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (getDataLength() > 0) {
            return true;
        }
        return false;
    }

    public abstract long readData(long j3, int i3, byte[] bArr, int i16) throws IOException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ByteDataSource extends UploadDataSource {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<ByteDataSource> CREATOR;
        private byte[] mData;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13344);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 10)) {
                redirector.redirect((short) 10);
            } else {
                CREATOR = new Parcelable.Creator<ByteDataSource>() { // from class: com.tencent.upload.task.data.UploadDataSource.ByteDataSource.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public ByteDataSource createFromParcel(Parcel parcel) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ByteDataSource(parcel) : (ByteDataSource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public ByteDataSource[] newArray(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ByteDataSource[i3] : (ByteDataSource[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                };
            }
        }

        public ByteDataSource(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mData = bArr;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
            }
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public String calcSha1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return FileUtils.getFileSha1(this.mData);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public boolean exists() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.mData != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public long getDataLength() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            if (this.mData != null) {
                return r0.length;
            }
            return 0L;
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public long readData(long j3, int i3, byte[] bArr, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3), bArr, Integer.valueOf(i16))).longValue();
            }
            System.arraycopy(this.mData, (int) j3, bArr, i16, i3);
            return i3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "[Byte:,Size:" + getDataLength() + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel, i3);
            } else {
                parcel.writeLong(getDataLength());
                parcel.writeByteArray(this.mData);
            }
        }

        public ByteDataSource(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel);
                return;
            }
            int readLong = (int) parcel.readLong();
            byte[] bArr = new byte[readLong < 0 ? 0 : readLong];
            this.mData = bArr;
            parcel.readByteArray(bArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FileDataSource extends UploadDataSource {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<FileDataSource> CREATOR;
        private File mFile;
        private String mFilePath;
        private FileInputStream sIns;
        private long sfileOffset;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13399);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 11)) {
                redirector.redirect((short) 11);
            } else {
                CREATOR = new Parcelable.Creator<FileDataSource>() { // from class: com.tencent.upload.task.data.UploadDataSource.FileDataSource.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public FileDataSource createFromParcel(Parcel parcel) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new FileDataSource(parcel) : (FileDataSource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public FileDataSource[] newArray(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new FileDataSource[i3] : (FileDataSource[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                };
            }
        }

        public FileDataSource(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.mFilePath = str;
                this.mFile = new File(str);
            }
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public String calcSha1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return FileUtils.getFileSha1(this.mFile);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public boolean exists() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.mFile.exists();
        }

        @Override // com.tencent.upload.task.data.UploadDataSource
        public long getDataLength() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            if (this.mFile.exists()) {
                return this.mFile.length();
            }
            return 0L;
        }

        public String getFileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mFile.getName();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:9|10|11|(2:13|(7:15|16|17|18|19|(1:23)|25))|(2:31|32)|30|16|17|18|19|(2:21|23)|25) */
        @Override // com.tencent.upload.task.data.UploadDataSource
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long readData(long j3, int i3, byte[] bArr, int i16) throws IOException {
            FileInputStream fileInputStream;
            long read;
            FileInputStream fileInputStream2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), bArr, Integer.valueOf(i16))).longValue();
            }
            synchronized (this) {
                try {
                    try {
                        FileInputStream fileInputStream3 = this.sIns;
                        if (fileInputStream3 != null) {
                            long j16 = this.sfileOffset;
                            if (j16 == j3) {
                                this.sfileOffset = j16 + i3;
                                read = fileInputStream3.read(bArr, i16, i3);
                                if (this.sfileOffset >= this.mFile.length() && (fileInputStream2 = this.sIns) != null) {
                                    fileInputStream2.close();
                                    this.sIns = null;
                                    this.sfileOffset = 0L;
                                }
                            }
                        }
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        fileInputStream3 = new FileInputStream(this.mFile);
                        this.sIns = fileInputStream3;
                        fileInputStream3.skip(j3);
                        this.sfileOffset = j3 + i3;
                        read = fileInputStream3.read(bArr, i16, i3);
                        if (this.sfileOffset >= this.mFile.length()) {
                            fileInputStream2.close();
                            this.sIns = null;
                            this.sfileOffset = 0L;
                        }
                    } catch (Throwable th6) {
                        try {
                            if (this.sfileOffset >= this.mFile.length() && (fileInputStream = this.sIns) != null) {
                                fileInputStream.close();
                                this.sIns = null;
                                this.sfileOffset = 0L;
                            }
                        } catch (Exception unused) {
                        }
                        throw th6;
                    }
                } catch (IOException e16) {
                    try {
                        FileInputStream fileInputStream4 = this.sIns;
                        if (fileInputStream4 != null) {
                            fileInputStream4.close();
                            this.sIns = null;
                            this.sfileOffset = 0L;
                        }
                    } catch (Exception unused2) {
                    }
                    throw e16;
                }
            }
            return read;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "[File:" + this.mFilePath + ",Size:" + getDataLength() + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel, i3);
            } else {
                parcel.writeString(this.mFilePath);
            }
        }

        public FileDataSource(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel);
            } else {
                this.mFilePath = parcel.readString();
                this.mFile = new File(this.mFilePath);
            }
        }
    }
}
