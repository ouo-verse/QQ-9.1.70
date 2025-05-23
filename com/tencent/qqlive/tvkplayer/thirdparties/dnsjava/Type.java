package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.InvalidTypeException;
import java.util.HashMap;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Type {
    public static final int A = 1;
    public static final int AAAA = 28;
    public static final int ANY = 255;
    public static final int AXFR = 252;
    public static final int CNAME = 5;
    public static final int DNAME = 39;
    public static final int IXFR = 251;
    public static final int MAILB = 253;
    private static final TypeMnemonic types;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TypeMnemonic extends Mnemonic {
        private final HashMap<Integer, Supplier<Record>> factories;

        public TypeMnemonic() {
            super("Type", 2);
            setPrefix("TYPE");
            setMaximum(65535);
            this.factories = new HashMap<>();
        }

        public void add(int i3, String str, Supplier<Record> supplier) {
            super.add(i3, str);
            this.factories.put(Integer.valueOf(i3), supplier);
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Mnemonic
        public void check(int i3) {
            Type.check(i3);
        }

        public Supplier<Record> getFactory(int i3) {
            check(i3);
            return this.factories.get(Integer.valueOf(i3));
        }

        public void replace(int i3, String str, Supplier<Record> supplier) {
            int value = getValue(str);
            if (value != -1) {
                if (value == i3) {
                    remove(i3);
                    this.factories.remove(Integer.valueOf(i3));
                } else {
                    throw new IllegalArgumentException("mnemnonic \"" + str + "\" already used by type " + value);
                }
            }
            add(i3, str, supplier);
        }
    }

    static {
        TypeMnemonic typeMnemonic = new TypeMnemonic();
        types = typeMnemonic;
        typeMnemonic.add(1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Supplier() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.t
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ARecord();
            }
        });
        typeMnemonic.add(28, "AAAA", new Supplier() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.u
            @Override // java.util.function.Supplier
            public final Object get() {
                return new AAAARecord();
            }
        });
        typeMnemonic.add(5, "CNAME", new Supplier() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.v
            @Override // java.util.function.Supplier
            public final Object get() {
                return new CNAMERecord();
            }
        });
        typeMnemonic.add(39, "DNAME", new Supplier() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.w
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DNAMERecord();
            }
        });
    }

    Type() {
    }

    public static void check(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
        } else {
            throw new InvalidTypeException(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Supplier<Record> getFactory(int i3) {
        return types.getFactory(i3);
    }

    public static boolean isRR(int i3) {
        switch (i3) {
            case 251:
            case 252:
            case 253:
            case 255:
                return false;
            case 254:
            default:
                return true;
        }
    }

    public static void register(int i3, String str, Supplier<Record> supplier) {
        types.replace(i3, str, supplier);
    }

    public static String string(int i3) {
        return types.getText(i3);
    }

    public static int value(String str, boolean z16) {
        TypeMnemonic typeMnemonic = types;
        int value = typeMnemonic.getValue(str);
        if (value != -1 || !z16) {
            return value;
        }
        return typeMnemonic.getValue("TYPE" + str);
    }

    public static int value(String str) {
        return value(str, false);
    }
}
