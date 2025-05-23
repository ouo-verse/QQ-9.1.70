package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.vfs.FileSystemManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RC4EncryptedFileSystem extends WrapperFileSystem<FileSystem> {
    public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR = new Parcelable.Creator<RC4EncryptedFileSystem>() { // from class: com.tencent.mm.vfs.RC4EncryptedFileSystem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RC4EncryptedFileSystem createFromParcel(Parcel parcel) {
            return new RC4EncryptedFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RC4EncryptedFileSystem[] newArray(int i3) {
            return new RC4EncryptedFileSystem[i3];
        }
    };
    private static final String TAG = "MicroMsg.RC4EncryptedFileSystem";
    private static final int VERSION = 2;
    private final String mId;
    private volatile Key mKey;
    private final FileSystemManager.KeyGen mKeyGen;
    private final boolean mRegenerateFree;

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public int capabilityFlags() {
        return this.mFS.capabilityFlags() & (-19);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem, com.tencent.mm.vfs.FileSystem
    public void configure(Map<String, String> map) {
        super.configure(map);
        if (!this.mRegenerateFree) {
            this.mKey = this.mKeyGen.generate(this.mId, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem
    public long copyFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        if (fileSystem instanceof RC4EncryptedFileSystem) {
            RC4EncryptedFileSystem rC4EncryptedFileSystem = (RC4EncryptedFileSystem) fileSystem;
            if (rC4EncryptedFileSystem.mKeyGen == this.mKeyGen && rC4EncryptedFileSystem.mId.equals(this.mId) && rC4EncryptedFileSystem.mKey.equals(this.mKey)) {
                T t16 = this.mFS;
                if (t16 instanceof AbstractFileSystem) {
                    return ((AbstractFileSystem) t16).copyFileImpl(str, rC4EncryptedFileSystem.mFS, str2);
                }
            }
        }
        return super.copyFileImpl(str, fileSystem, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.AbstractFileSystem
    public boolean moveFileImpl(String str, FileSystem fileSystem, String str2) throws IOException {
        if (fileSystem instanceof RC4EncryptedFileSystem) {
            RC4EncryptedFileSystem rC4EncryptedFileSystem = (RC4EncryptedFileSystem) fileSystem;
            if (rC4EncryptedFileSystem.mKeyGen == this.mKeyGen && rC4EncryptedFileSystem.mId.equals(this.mId) && rC4EncryptedFileSystem.mKey.equals(this.mKey)) {
                T t16 = this.mFS;
                if (t16 instanceof AbstractFileSystem) {
                    return ((AbstractFileSystem) t16).moveFileImpl(str, rC4EncryptedFileSystem.mFS, str2);
                }
            }
        }
        return super.moveFileImpl(str, fileSystem, str2);
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public InputStream openRead(String str) throws FileNotFoundException {
        Key key = this.mKey;
        if (key != null) {
            try {
                Cipher cipher = Cipher.getInstance("RC4");
                cipher.init(2, key);
                return new CipherInputStream(this.mFS.openRead(str), cipher);
            } catch (GeneralSecurityException e16) {
                throw ((FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e16.getMessage()).initCause(e16));
            }
        }
        throw new FileNotFoundException("Key is not initialized.");
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, com.tencent.mm.vfs.FileSystem
    public OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        Key key = this.mKey;
        if (key != null) {
            if (!z16) {
                try {
                    Cipher cipher = Cipher.getInstance("RC4");
                    cipher.init(1, key);
                    return new CipherOutputStream(this.mFS.openWrite(str, false), cipher);
                } catch (GeneralSecurityException e16) {
                    throw ((FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e16.getMessage()).initCause(e16));
                }
            }
            throw new FileNotFoundException("Appending encrypted files is not supported.");
        }
        throw new FileNotFoundException("Key is not initialized.");
    }

    public String toString() {
        return "RC4 [" + this.mFS.toString() + "]";
    }

    @Override // com.tencent.mm.vfs.WrapperFileSystem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        VFSUtils.writeFileSystemVersion(parcel, RC4EncryptedFileSystem.class, 2);
        parcel.writeString(this.mId);
    }

    public RC4EncryptedFileSystem(FileSystem fileSystem, String str) {
        super(fileSystem);
        FileSystemManager.KeyGen keyGenerator = FileSystemManager.getKeyGenerator();
        this.mKeyGen = keyGenerator;
        this.mId = str;
        if (keyGenerator != null) {
            this.mKey = keyGenerator.generate(str, FileSystemManager.instance().staticEnvironment());
            this.mRegenerateFree = this.mKey != null;
            return;
        }
        throw new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
    }

    public RC4EncryptedFileSystem(String str, String str2) {
        this(new NativeFileSystem(str), str2);
    }

    RC4EncryptedFileSystem(Parcel parcel) {
        super(parcel);
        VFSUtils.checkFileSystemVersion(parcel, RC4EncryptedFileSystem.class, 2);
        FileSystemManager.KeyGen keyGenerator = FileSystemManager.getKeyGenerator();
        this.mKeyGen = keyGenerator;
        String readString = parcel.readString();
        this.mId = readString;
        if (keyGenerator != null) {
            this.mKey = keyGenerator.generate(readString, FileSystemManager.instance().staticEnvironment());
            this.mRegenerateFree = this.mKey != null;
            return;
        }
        throw new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
    }
}
