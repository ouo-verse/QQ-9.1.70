package com.tencent.luggage.wxa.cp;

import android.os.Parcel;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.cp.l;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f123735a = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f123736b = Pattern.compile("([0-9.]+)\\s*([A-Za-z]*)");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f123737c = Pattern.compile("\\s*,\\s*");

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements a.InterfaceC6145a {

        /* renamed from: a, reason: collision with root package name */
        public final k.a f123738a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f123739b;

        /* renamed from: c, reason: collision with root package name */
        public final i[] f123740c;

        /* renamed from: d, reason: collision with root package name */
        public final List f123741d;

        public b(k.a aVar, boolean z16, a aVar2) {
            this.f123738a = aVar;
            this.f123739b = z16;
            i[] iVarArr = new i[1];
            this.f123740c = iVarArr;
            this.f123741d = Arrays.asList(iVarArr);
        }

        @Override // com.tencent.luggage.wxa.dp.a.InterfaceC6145a
        public Iterable a(i iVar) {
            this.f123740c[0] = iVar;
            if (!iVar.f123770f) {
                return this.f123741d;
            }
            Iterable e16 = this.f123738a.e(iVar.f123765a);
            if (e16 == null) {
                return this.f123741d;
            }
            com.tencent.luggage.wxa.dp.a aVar = new com.tencent.luggage.wxa.dp.a(e16, this);
            Set singleton = Collections.singleton(iVar);
            return this.f123739b ? new com.tencent.luggage.wxa.dp.e(aVar, singleton) : new com.tencent.luggage.wxa.dp.e(singleton, aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends RuntimeException {
        public c(Class cls, int i3, int i16) {
            super("Version mismatch when unmarhelling " + cls.getName() + " (" + i16 + " expected, " + i3 + " got");
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static String a(String str, boolean z16, boolean z17) {
        if (str.isEmpty()) {
            return str;
        }
        ?? startsWith = str.startsWith("/");
        if (str.endsWith("/") && str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        ArrayList arrayList = new ArrayList();
        int i3 = startsWith == true ? 1 : 0;
        boolean z18 = true;
        while (true) {
            int indexOf = str.indexOf(47, i3);
            if (indexOf < 0) {
                break;
            }
            String substring = str.substring(i3, indexOf);
            if (z16 && "..".equals(substring)) {
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else if ((!z16 || !".".equals(substring)) && !substring.isEmpty()) {
                arrayList.add(substring);
                i3 = indexOf + 1;
                z18 = z18;
            }
            z18 = false;
            i3 = indexOf + 1;
            z18 = z18;
        }
        if (z18) {
            if (z17) {
                return str.substring(startsWith == true ? 1 : 0);
            }
            return str;
        }
        if (i3 < str.length()) {
            arrayList.add(str.substring(i3));
        }
        StringBuilder sb5 = new StringBuilder();
        if (!z17 && startsWith > 0) {
            sb5.append('/');
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            sb5.append(it.next());
            while (it.hasNext()) {
                sb5.append('/');
                sb5.append(it.next());
            }
        }
        return sb5.toString();
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf <= 0) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static long c(String str) {
        if (str != null && !str.isEmpty()) {
            return new File(l.d().a(), str + EnginePathProvider.TIMESTAMP).lastModified();
        }
        return 0L;
    }

    public static long d(String str) {
        return System.currentTimeMillis() - c(str);
    }

    public static void e(String str) {
        if (str != null && !str.isEmpty()) {
            File file = new File(l.d().a(), str + EnginePathProvider.TIMESTAMP);
            try {
                file.createNewFile();
                file.setLastModified(System.currentTimeMillis());
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.b("VFS.Utils", e16, "Unable to update timestamp: " + str);
            }
        }
    }

    public static void b(Parcel parcel, Class cls, int i3) {
        parcel.writeInt(cls.getName().hashCode() ^ i3);
    }

    public static String a(String str) {
        File file = new File(str);
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            return file.getAbsolutePath();
        }
    }

    public static String a(b0 b0Var, boolean z16) {
        l.h a16 = l.d().a(b0Var);
        if (a16.a() && (a16.f123799a.a() & 2) != 0) {
            return a16.f123799a.d(a16.f123800b, z16);
        }
        return null;
    }

    public static k.a a(k.a aVar, String str, int i3) {
        while (aVar instanceof f) {
            aVar = ((f) aVar).a(str, i3);
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(String str, long j3) {
        long j16;
        if (str == null) {
            return j3;
        }
        Matcher matcher = f123736b.matcher(str);
        if (!matcher.find()) {
            return j3;
        }
        char c16 = 1;
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            String lowerCase = matcher.group(2).toLowerCase();
            int hashCode = lowerCase.hashCode();
            if (hashCode == 0) {
                if (lowerCase.equals("")) {
                    c16 = 0;
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 100) {
                if (lowerCase.equals("d")) {
                    c16 = '\b';
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 104) {
                if (lowerCase.equals(tl.h.F)) {
                    c16 = 6;
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 109) {
                if (lowerCase.equals(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)) {
                    c16 = 4;
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 115) {
                if (lowerCase.equals(ReportConstant.COSTREPORT_PREFIX)) {
                    c16 = 2;
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 3338) {
                if (lowerCase.equals("hr")) {
                    c16 = 7;
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 3494) {
                if (lowerCase.equals("ms")) {
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 99228) {
                if (lowerCase.equals("day")) {
                    c16 = '\t';
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 108114) {
                if (lowerCase.equals(Element.ELEMENT_NAME_MIN)) {
                    c16 = 5;
                    switch (c16) {
                    }
                    return (long) (parseDouble * j16);
                }
                c16 = '\uffff';
                switch (c16) {
                }
                return (long) (parseDouble * j16);
            }
            if (hashCode == 113745 && lowerCase.equals("sec")) {
                c16 = 3;
                switch (c16) {
                    case 0:
                    case 1:
                        j16 = 1;
                        break;
                    case 2:
                    case 3:
                        j16 = 1000;
                        break;
                    case 4:
                    case 5:
                        j16 = 60000;
                        break;
                    case 6:
                    case 7:
                        j16 = 3600000;
                        break;
                    case '\b':
                    case '\t':
                        j16 = 86400000;
                        break;
                    default:
                        return j3;
                }
                return (long) (parseDouble * j16);
            }
            c16 = '\uffff';
            switch (c16) {
            }
            return (long) (parseDouble * j16);
        } catch (NullPointerException | NumberFormatException unused) {
            return j3;
        }
    }

    public static String a(long j3) {
        return j3 >= 86400000 ? String.format("%.1f days", Double.valueOf((j3 * 1.0d) / 8.64E7d)) : j3 >= 3600000 ? String.format("%.1f hr", Double.valueOf((j3 * 1.0d) / 3600000.0d)) : j3 >= 60000 ? String.format("%.1f min", Double.valueOf((j3 * 1.0d) / 60000.0d)) : j3 >= 1000 ? String.format("%.1f s", Double.valueOf((j3 * 1.0d) / 1000.0d)) : String.format("%d ms", Long.valueOf(j3));
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            com.tencent.luggage.wxa.yp.b.e("VFS.Utils", "Failed to close object: " + e16.toString());
        }
    }

    public static long a(k.a aVar, String str, k.a aVar2, String str2) {
        ReadableByteChannel readableByteChannel;
        WritableByteChannel writableByteChannel = null;
        try {
            readableByteChannel = aVar.g(str);
        } catch (Throwable th5) {
            th = th5;
            readableByteChannel = null;
        }
        try {
            writableByteChannel = aVar2.c(str2, false);
            long a16 = a(readableByteChannel, writableByteChannel, Long.MAX_VALUE, ByteBuffer.allocateDirect(8192));
            a(readableByteChannel);
            a(writableByteChannel);
            return a16;
        } catch (Throwable th6) {
            th = th6;
            a(readableByteChannel);
            a(writableByteChannel);
            throw th;
        }
    }

    public static long a(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel, long j3, ByteBuffer byteBuffer) {
        byteBuffer.clear();
        long j16 = 0;
        while (j16 < j3) {
            long j17 = j3 - j16;
            if (j17 < byteBuffer.capacity()) {
                byteBuffer.limit((int) j17);
            }
            if (readableByteChannel.read(byteBuffer) < 0) {
                break;
            }
            byteBuffer.flip();
            j16 += writableByteChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        return j16;
    }

    public static Iterable a(k.a aVar, String str, boolean z16) {
        return a(aVar, str, z16, (a) null);
    }

    public static Iterable a(k.a aVar, String str, boolean z16, a aVar2) {
        Iterable e16 = aVar.e(str);
        if (e16 == null) {
            return null;
        }
        return new com.tencent.luggage.wxa.dp.a(e16, new b(aVar, z16, aVar2));
    }

    public static void a(Parcel parcel, Class cls, int i3) {
        int hashCode = i3 ^ cls.getName().hashCode();
        int readInt = parcel.readInt();
        if (readInt != hashCode) {
            throw new c(cls, readInt, hashCode);
        }
    }

    public static List a(Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        if (iterable instanceof List) {
            return (List) iterable;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static String a(Map map, String str) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof String[]) {
            return ((String[]) obj)[0];
        }
        return null;
    }

    public static int a(Object... objArr) {
        return Arrays.deepHashCode(objArr);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
