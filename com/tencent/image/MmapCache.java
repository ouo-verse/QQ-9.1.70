package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MmapCache {
    static IPatchRedirector $redirector_ = null;
    public static final int FIND_RESULT_FAILURE = -1;
    public static final int FIND_RESULT_FIND = 1;
    public static final int FIND_RESULT_SAVE = 0;
    public static final int HEAD_BYTE = 14;
    public static final int HEAD_MAX_POSITION = 10;
    public static final int HEAD_START_POSITION = 2;
    public static final int HEAD_VALID_POSITION = 6;
    public static final int MAX_ENTRY = 500;
    public static final int PER_ENTRY_BYTE = 16;
    private static final String TAG = "SafeBitmapFactory";
    private static final byte[] TYPE;
    private static volatile MmapCache instance;
    private MappedByteBuffer mMappedBuffer;
    private String path;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9822);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            TYPE = new byte[]{77, 67};
        }
    }

    MmapCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMappedBuffer = null;
            this.path = "";
        }
    }

    private void createHead() {
        MappedByteBuffer mappedByteBuffer = this.mMappedBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        mappedByteBuffer.position(0);
        MappedByteBuffer mappedByteBuffer2 = this.mMappedBuffer;
        byte[] bArr = TYPE;
        mappedByteBuffer2.put(bArr[0]);
        this.mMappedBuffer.put(bArr[1]);
        this.mMappedBuffer.putInt(0);
        this.mMappedBuffer.putInt(0);
        this.mMappedBuffer.putInt(500);
        this.mMappedBuffer.force();
    }

    public static MmapCache getInstance(String str) {
        try {
            if (instance == null) {
                synchronized (MmapCache.class) {
                    if (instance == null) {
                        instance = new MmapCache();
                        instance.mMappedBuffer = instance.getMappedBuffer(str);
                        instance.path = str;
                    }
                }
            }
            if (!str.equals(instance.path)) {
                synchronized (MmapCache.class) {
                    instance.mMappedBuffer = instance.getMappedBuffer(str);
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return instance;
    }

    private MappedByteBuffer getMappedBuffer(String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
        } catch (FileNotFoundException unused) {
            File file = new File(str);
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file.createNewFile();
            randomAccessFile = new RandomAccessFile(str, "rw");
            this.mMappedBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
            createHead();
        }
        if (this.mMappedBuffer == null) {
            this.mMappedBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
        }
        randomAccessFile.close();
        return this.mMappedBuffer;
    }

    public synchronized void deleteItem(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        byte[] byteArrayToMd5 = MD5Util.byteArrayToMd5(str);
        if (byteArrayToMd5 == null) {
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.mMappedBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        mappedByteBuffer.position(0);
        byte b16 = this.mMappedBuffer.get();
        byte[] bArr = TYPE;
        if (b16 == bArr[0] && this.mMappedBuffer.get() == bArr[1]) {
            this.mMappedBuffer.position(2);
            int i3 = this.mMappedBuffer.getInt();
            int i16 = this.mMappedBuffer.getInt();
            int i17 = this.mMappedBuffer.getInt();
            if (i17 >= 0 && i17 >= i3 && i17 >= i16) {
                byte[] bArr2 = new byte[16];
                int i18 = i16 - 1;
                int i19 = i18;
                while (true) {
                    if (i19 < 0) {
                        break;
                    }
                    int i26 = (i3 + i19) % i17;
                    this.mMappedBuffer.position((i26 * 16) + 14);
                    this.mMappedBuffer.get(bArr2, 0, 16);
                    if (Arrays.equals(bArr2, byteArrayToMd5)) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(TAG, 2, "deleteItem() \u627e\u5230\u4e86,pos:" + i26);
                        }
                        for (int i27 = i19 + 1; i27 < i18; i27++) {
                            int i28 = (i3 + i27) % i17;
                            this.mMappedBuffer.position((i28 * 16) + 14);
                            this.mMappedBuffer.get(bArr2, 0, 16);
                            this.mMappedBuffer.position(((i28 == 0 ? i17 - 1 : i28 - 1) * 16) + 14);
                            this.mMappedBuffer.put(bArr2);
                        }
                        if (i16 > 0) {
                            this.mMappedBuffer.position(6);
                            this.mMappedBuffer.putInt(i18);
                        }
                    } else {
                        i19--;
                    }
                }
                this.mMappedBuffer.force();
                return;
            }
            createHead();
            return;
        }
        createHead();
    }

    public synchronized int findOrAddItem(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        byte[] byteArrayToMd5 = MD5Util.byteArrayToMd5(str);
        if (byteArrayToMd5 == null) {
            return -1;
        }
        MappedByteBuffer mappedByteBuffer = this.mMappedBuffer;
        if (mappedByteBuffer == null) {
            return -1;
        }
        mappedByteBuffer.position(0);
        byte b16 = this.mMappedBuffer.get();
        byte[] bArr = TYPE;
        if (b16 != bArr[0] || this.mMappedBuffer.get() != bArr[1]) {
            createHead();
        }
        this.mMappedBuffer.position(2);
        int i3 = this.mMappedBuffer.getInt();
        int i16 = this.mMappedBuffer.getInt();
        int i17 = this.mMappedBuffer.getInt();
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "findOrAddItem() start:" + i3 + "\uff0cvalid:" + i16 + "\uff0cmax:" + i17);
        }
        if (i17 < 0 || i17 < i3 || i17 < i16) {
            createHead();
        }
        byte[] bArr2 = new byte[16];
        for (int i18 = i16 - 1; i18 >= 0; i18--) {
            this.mMappedBuffer.position((((i3 + i18) % i17) * 16) + 14);
            this.mMappedBuffer.get(bArr2, 0, 16);
            if (Arrays.equals(bArr2, byteArrayToMd5)) {
                return 1;
            }
        }
        this.mMappedBuffer.position((((i3 + i16) % i17) * 16) + 14);
        this.mMappedBuffer.put(byteArrayToMd5);
        if (i16 < i17) {
            int i19 = i16 + 1;
            this.mMappedBuffer.position(6);
            this.mMappedBuffer.putInt(i19);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "findOrAddItem() \u6ca1\u627e\u5230 \uff0c\u603b\u6570\u672a\u6ee1\u8ddf\u65b0 valid:" + i19);
            }
        } else {
            int i26 = (i3 + 1) % i17;
            this.mMappedBuffer.position(2);
            this.mMappedBuffer.putInt(i26);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "findOrAddItem() \u6ca1\u627e\u5230 \uff0c\u603b\u6570\u5df2\u6ee1\u8ddf\u65b0 start:" + i26);
            }
        }
        this.mMappedBuffer.force();
        return 0;
    }
}
