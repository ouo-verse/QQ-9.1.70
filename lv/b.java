package lv;

import android.util.SparseArray;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static byte[] a(a aVar) {
        if (aVar != null) {
            short b16 = aVar.b();
            short a16 = aVar.a();
            byte[] d16 = aVar.d();
            ByteBuffer allocate = ByteBuffer.allocate(a16 + 4);
            allocate.putShort(b16);
            allocate.putShort(a16);
            allocate.put(d16);
            return allocate.array();
        }
        return null;
    }

    public static SparseArray<a> b(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        SparseArray<a> sparseArray = new SparseArray<>();
        int i3 = 0;
        while (i3 < bArr.length) {
            short d16 = d(wrap, i3);
            int i16 = i3 + 2;
            short c16 = c(wrap, i16);
            int i17 = i16 + 2;
            byte[] e16 = e(bArr, i17, c16);
            i3 = i17 + c16;
            sparseArray.put(d16, new a(d16, c16, e16));
        }
        return sparseArray;
    }

    private static short c(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getShort(i3);
    }

    private static short d(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getShort(i3);
    }

    public static byte[] e(byte[] bArr, int i3, int i16) {
        return ByteUtils.subByte(bArr, i3, i16);
    }
}
