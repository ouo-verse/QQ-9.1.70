package md0;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f416558q = {0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f416559r = {1, 16, 20, 16, 16, 15, 16, 15};

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f416560s = {8, 18, 27, 8, 8, 8, 10, 9};

    /* renamed from: t, reason: collision with root package name */
    private static final double[][] f416561t = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};

    /* renamed from: u, reason: collision with root package name */
    private static final double[] f416562u = {0.7d, 0.9d, 0.18d};

    /* renamed from: a, reason: collision with root package name */
    private ByteOrder f416563a = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: b, reason: collision with root package name */
    private c f416564b = new c();

    /* renamed from: c, reason: collision with root package name */
    private double f416565c = 150.0d;

    /* renamed from: d, reason: collision with root package name */
    private double f416566d = 200.0d;

    /* renamed from: e, reason: collision with root package name */
    private int f416567e = 1;

    /* renamed from: f, reason: collision with root package name */
    private double[][] f416568f;

    /* renamed from: g, reason: collision with root package name */
    private int f416569g;

    /* renamed from: h, reason: collision with root package name */
    private int f416570h;

    /* renamed from: i, reason: collision with root package name */
    private int f416571i;

    /* renamed from: j, reason: collision with root package name */
    private int f416572j;

    /* renamed from: k, reason: collision with root package name */
    private double[] f416573k;

    /* renamed from: l, reason: collision with root package name */
    private int f416574l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f416575m;

    /* renamed from: n, reason: collision with root package name */
    private int f416576n;

    /* renamed from: o, reason: collision with root package name */
    private long f416577o;

    /* renamed from: p, reason: collision with root package name */
    private long f416578p;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(InputStream inputStream, OutputStream outputStream, int i3, int i16, int i17, int i18, int i19, int i26, double d16, int i27, boolean z16) throws IOException {
        int i28;
        int i29;
        int i36;
        double[] dArr;
        double d17;
        int i37;
        String str;
        int i38;
        double[] dArr2;
        int i39;
        int i46;
        b bVar;
        int i47;
        double d18;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58 = 0;
        this.f416575m = false;
        double[] dArr3 = {0.0d};
        if (i27 >= 0 && i27 <= 4) {
            this.f416575m = z16;
            if (!z16) {
                System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
            }
            if (i17 != 1 && i17 != 2 && i17 != 3 && i17 != 4) {
                throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
            }
            int i59 = i18;
            if (i59 == -1) {
                i59 = i17 != 1 ? i17 : 2;
                if (i59 == 4) {
                    i28 = i16;
                    i59 = 3;
                    i28 = i28 == -1 ? i3 : i28;
                    i29 = i27 != -1 ? i59 < i17 ? i59 == 1 ? 4 : 3 : 1 : i27;
                    String str2 = "\n";
                    if (this.f416575m) {
                        String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
                        String[] strArr2 = {"rectangular", "triangular", "gaussian"};
                        dArr = dArr3;
                        System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i3), Integer.valueOf(i28));
                        System.err.printf("attenuation : %gdB\n", Double.valueOf(d16));
                        System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i17 * 8), Integer.valueOf(i59 * 8));
                        System.err.printf("nchannels : %d\n", Integer.valueOf(i19));
                        i36 = i59;
                        System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i26), Double.valueOf(((i26 / i17) / i19) / i3));
                        if (i29 == 0) {
                            i58 = 0;
                            System.err.printf("dither type : none\n", new Object[0]);
                        } else {
                            i58 = 0;
                            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i29], strArr2[0], Double.valueOf(0.18d));
                        }
                        str2 = "\n";
                        System.err.printf(str2, new Object[i58]);
                    } else {
                        i36 = i59;
                        dArr = dArr3;
                    }
                    if (i29 == 0) {
                        int i65 = i36;
                        if (i65 == 1) {
                            i49 = -128;
                            i48 = 127;
                        } else {
                            i48 = i58;
                            i49 = i48;
                        }
                        if (i65 == 2) {
                            i49 = -32768;
                            i48 = 32767;
                        }
                        if (i65 == 3) {
                            i49 = -8388608;
                            i48 = 8388607;
                        }
                        if (i65 == 4) {
                            i57 = Integer.MIN_VALUE;
                            i56 = Integer.MAX_VALUE;
                        } else {
                            i56 = i48;
                            i57 = i49;
                        }
                        str = str2;
                        i38 = i65;
                        dArr2 = dArr;
                        d17 = d16;
                        i37 = i28;
                        h(i28, i19, i57, i56, i29, 0, 0.18d);
                    } else {
                        d17 = d16;
                        i37 = i28;
                        str = str2;
                        i38 = i36;
                        dArr2 = dArr;
                    }
                    if (i3 >= i37) {
                        int i66 = i37;
                        i39 = i19;
                        i47 = 0;
                        dArr2[0] = n(inputStream, outputStream, i19, i17, i38, i3, i66, Math.pow(10.0d, (-d17) / 20.0d), (i26 / i17) / i39, false, i29);
                    } else {
                        int i67 = i37;
                        i39 = i19;
                        if (i3 > i67) {
                            i47 = 0;
                            dArr2[0] = d(inputStream, outputStream, i19, i17, i38, i3, i67, Math.pow(10.0d, (-d17) / 20.0d), (i26 / i17) / i39, false, i29);
                        } else {
                            i46 = 0;
                            dArr2[0] = i(inputStream, outputStream, i19, i17, i38, Math.pow(10.0d, (-d17) / 20.0d), (i26 / i17) / i39, false, i29);
                            bVar = this;
                            if (!bVar.f416575m) {
                                System.err.printf(str, new Object[i46]);
                            }
                            if (i29 != 0) {
                                bVar.j(i39);
                            }
                            d18 = dArr2[i46];
                            if (d18 <= 1.0d || bVar.f416575m) {
                                return;
                            }
                            PrintStream printStream = System.err;
                            Object[] objArr = new Object[1];
                            objArr[i46] = Double.valueOf(Math.log10(d18) * 20.0d);
                            printStream.printf("clipping detected : %gdB\n", objArr);
                            return;
                        }
                    }
                    bVar = this;
                    i46 = i47;
                    if (!bVar.f416575m) {
                    }
                    if (i29 != 0) {
                    }
                    d18 = dArr2[i46];
                    if (d18 <= 1.0d) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            i28 = i16;
            if (i28 == -1) {
            }
            if (i27 != -1) {
            }
            String str22 = "\n";
            if (this.f416575m) {
            }
            if (i29 == 0) {
            }
            if (i3 >= i37) {
            }
            bVar = this;
            i46 = i47;
            if (!bVar.f416575m) {
            }
            if (i29 != 0) {
            }
            d18 = dArr2[i46];
            if (d18 <= 1.0d) {
            }
        } else {
            throw new IllegalArgumentException("unrecognized dither type : " + i27);
        }
    }

    private int a(double d16) {
        double d17;
        if (d16 >= 0.0d) {
            d17 = d16 + 0.5d;
        } else {
            d17 = d16 - 0.5d;
        }
        return (int) d17;
    }

    private double b(double d16) {
        if (d16 <= 21.0d) {
            return 0.0d;
        }
        if (d16 <= 50.0d) {
            double d17 = d16 - 21.0d;
            return (Math.pow(d17, 0.4d) * 0.5842d) + (d17 * 0.07886d);
        }
        return (d16 - 8.7d) * 0.1102d;
    }

    private int e(int i3, int i16) {
        while (true) {
            int i17 = i16;
            int i18 = i3;
            i3 = i17;
            if (i3 != 0) {
                i16 = i18 % i3;
            } else {
                return i18;
            }
        }
    }

    private double g(int i3, double d16, double d17) {
        double d18 = 1.0d / d17;
        return d16 * 2.0d * d18 * m(i3 * 6.283185307179586d * d16 * d18);
    }

    private void k() {
        this.f416577o = System.currentTimeMillis();
        this.f416578p = 0L;
        this.f416576n = -1;
    }

    private void l(double d16) {
        int i3;
        if (this.f416575m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f416577o;
        if (d16 == 0.0d) {
            i3 = 0;
        } else {
            i3 = (int) ((currentTimeMillis * (1.0d - d16)) / d16);
        }
        int i16 = (int) (d16 * 100.0d);
        if (i16 != this.f416576n || currentTimeMillis != this.f416578p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i16));
            this.f416576n = i16;
        }
        if (currentTimeMillis != this.f416578p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i3));
            this.f416578p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    private double m(double d16) {
        if (d16 == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d16) / d16;
    }

    private double o(double d16, int i3, double d17, double d18) {
        double d19 = 4.0d * d16 * d16;
        double d26 = i3 - 1.0d;
        return a.a(d17 * Math.sqrt(1.0d - (d19 / (d26 * d26)))) / d18;
    }

    public int c(double d16, double[] dArr, int i3, int i16) {
        int i17;
        double a16;
        if (i3 == 1) {
            double[] dArr2 = this.f416573k;
            int i18 = this.f416574l;
            this.f416574l = i18 + 1;
            double d17 = d16 + dArr2[i18 & 65535];
            int i19 = this.f416571i;
            if (d17 < i19) {
                double d18 = d17 / i19;
                double d19 = dArr[0];
                if (d19 >= d18) {
                    d18 = d19;
                }
                dArr[0] = d18;
                d17 = i19;
            }
            int i26 = this.f416572j;
            if (d17 > i26) {
                double d26 = d17 / i26;
                double d27 = dArr[0];
                if (d27 >= d26) {
                    d26 = d27;
                }
                dArr[0] = d26;
                d17 = i26;
            }
            return a(d17);
        }
        double d28 = 0.0d;
        int i27 = 0;
        while (true) {
            i17 = this.f416570h;
            if (i27 >= i17) {
                break;
            }
            d28 += f416561t[this.f416569g][i27] * this.f416568f[i16][i27];
            i27++;
        }
        double d29 = d16 + d28;
        double[] dArr3 = this.f416573k;
        int i28 = this.f416574l;
        this.f416574l = i28 + 1;
        double d36 = dArr3[65535 & i28] + d29;
        for (int i29 = i17 - 2; i29 >= 0; i29--) {
            double[] dArr4 = this.f416568f[i16];
            dArr4[i29 + 1] = dArr4[i29];
        }
        int i36 = this.f416571i;
        if (d36 < i36) {
            double d37 = d36 / i36;
            double d38 = dArr[0];
            if (d38 >= d37) {
                d37 = d38;
            }
            dArr[0] = d37;
            a16 = i36;
            double[] dArr5 = this.f416568f[i16];
            double d39 = a16 - d29;
            dArr5[0] = d39;
            if (d39 > 1.0d) {
                dArr5[0] = 1.0d;
            }
            if (dArr5[0] < -1.0d) {
                dArr5[0] = -1.0d;
            }
        } else {
            int i37 = this.f416572j;
            if (d36 > i37) {
                double d46 = d36 / i37;
                double d47 = dArr[0];
                if (d47 >= d46) {
                    d46 = d47;
                }
                dArr[0] = d46;
                a16 = i37;
                double[] dArr6 = this.f416568f[i16];
                double d48 = a16 - d29;
                dArr6[0] = d48;
                if (d48 > 1.0d) {
                    dArr6[0] = 1.0d;
                }
                if (dArr6[0] < -1.0d) {
                    dArr6[0] = -1.0d;
                }
            } else {
                a16 = a(d36);
                this.f416568f[i16][0] = a16 - d29;
            }
        }
        return (int) a16;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x087c A[LOOP:14: B:124:0x087a->B:125:0x087c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x089b A[LOOP:15: B:128:0x0899->B:129:0x089b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0803  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double d(InputStream inputStream, OutputStream outputStream, int i3, int i16, int i17, int i18, int i19, double d16, int i26, boolean z16, int i27) throws IOException {
        int i28;
        int i29;
        double d17;
        double[] dArr;
        double d18;
        double d19;
        int i36;
        int i37;
        int i38;
        double d26;
        int i39;
        int i46;
        double[] dArr2;
        int[] iArr;
        int i47;
        int[] iArr2;
        int i48;
        int i49;
        int[] iArr3;
        double[][] dArr3;
        int i56;
        int i57;
        int i58;
        int i59;
        b bVar;
        ByteBuffer byteBuffer;
        boolean z17;
        int i65;
        int[] iArr4;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        ByteBuffer byteBuffer2;
        char c16;
        b bVar2;
        int i77;
        int i78;
        int a16;
        char c17;
        int i79;
        ByteBuffer byteBuffer3;
        int a17;
        char c18;
        char c19;
        int i85;
        int i86;
        int i87;
        int i88;
        int i89;
        int i95;
        int i96;
        int i97;
        int a18;
        char c26;
        int i98;
        int i99;
        boolean z18;
        int i100;
        int i101;
        int i102;
        int i103;
        int i104;
        double[] dArr4;
        int i105;
        int i106;
        int i107 = i18;
        int i108 = i19;
        double[] dArr5 = {0.0d};
        int i109 = this.f416567e;
        double d27 = this.f416565c;
        int e16 = e(i107, i108);
        int i110 = i108 / e16;
        if (i110 == 1) {
            i28 = 1;
        } else if (i110 % 2 == 0) {
            i28 = 2;
        } else {
            if (i110 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i19), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i110)));
            }
            i28 = 3;
        }
        int i111 = i107 * i28;
        double d28 = d27 <= 21.0d ? 0.9222d : (d27 - 7.95d) / 14.36d;
        int i112 = 1;
        while (true) {
            int i113 = i109 * i112;
            if (i113 % 2 == 0) {
                i113--;
            }
            i29 = i113;
            d17 = i111;
            dArr = dArr5;
            double d29 = (d17 * d28) / (i29 - 1);
            d18 = i108;
            d19 = (d18 - d29) / 2.0d;
            i36 = i28;
            if (d29 < this.f416566d) {
                break;
            }
            i112 *= 2;
            i108 = i19;
            dArr5 = dArr;
            i28 = i36;
            i107 = i18;
        }
        double b16 = b(d27);
        double a19 = a.a(b16);
        int i114 = 1;
        while (i114 < i29) {
            i114 *= 2;
        }
        int i115 = i114 * 2;
        double[] dArr6 = new double[i115];
        int i116 = i29 / 2;
        int i117 = -i116;
        while (i117 <= i116) {
            int i118 = i117;
            int i119 = i36;
            int i120 = i115;
            double[] dArr7 = dArr6;
            dArr7[i117 + i116] = ((((o(i117, i29, b16, a19) * g(i118, d19, d17)) * d17) / i107) / i120) * 2.0d;
            i117 = i118 + 1;
            i36 = i119;
            i115 = i120;
            dArr6 = dArr7;
            i29 = i29;
            i116 = i116;
        }
        int i121 = i117;
        double[] dArr8 = dArr6;
        int i122 = i36;
        int i123 = i29;
        int i124 = i115;
        int[] iArr5 = new int[(int) (Math.sqrt(i124) + 2.0d)];
        iArr5[0] = 0;
        int i125 = i124 / 2;
        double[] dArr9 = new double[i125];
        this.f416564b.B(i124, 1, dArr8, iArr5, dArr9);
        if (i122 == 1) {
            int[] iArr6 = {i107 / i108};
            double[][] dArr10 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 1, 1);
            dArr10[0][0] = 1.0d;
            i56 = (i107 / e16) * i108;
            dArr2 = dArr9;
            i47 = i125;
            i37 = i122;
            i38 = i124;
            d26 = d17;
            iArr2 = new int[]{0};
            i57 = 1;
            i39 = 1;
            dArr3 = dArr10;
            iArr3 = iArr6;
            i49 = i121;
            i46 = i111;
            iArr = iArr5;
            i48 = 1;
        } else {
            double d36 = this.f416565c;
            int i126 = (i107 / e16) * i108;
            double[] dArr11 = dArr9;
            int i127 = i107 / 2;
            int[] iArr7 = iArr5;
            int i128 = i125;
            i37 = i122;
            i38 = i124;
            d26 = d17;
            double d37 = i127 + (((i111 / 2) - i127) / 2.0d);
            double d38 = i126;
            long j3 = 4607182418800017408L;
            int i129 = (int) (((d38 / ((r2 * 2) / 2.0d)) * (d36 > 21.0d ? (d36 - 7.95d) / 14.36d : 0.9222d)) + 1.0d);
            if (i129 % 2 == 0) {
                i129++;
            }
            i39 = i129;
            double b17 = b(d36);
            double a26 = a.a(b17);
            int i130 = i126 / i111;
            int i131 = (i39 / i130) + 1;
            int[] iArr8 = new int[i130];
            for (int i132 = 0; i132 < i130; i132++) {
                int i133 = i130 - (((i126 / i108) * i132) % i130);
                iArr8[i132] = i133;
                if (i133 == i130) {
                    iArr8[i132] = 0;
                }
            }
            int[] iArr9 = new int[i130];
            int i134 = 0;
            while (i134 < i130) {
                int i135 = (((i126 / i108) - iArr8[i134]) / i130) + 1;
                iArr9[i134] = i135;
                int i136 = i134 + 1;
                if (iArr8[i136 == i130 ? 0 : i136] == 0) {
                    iArr9[i134] = i135 - 1;
                }
                i134 = i136;
            }
            double[][] dArr12 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i130, i131);
            int i137 = i39 / 2;
            int i138 = -i137;
            while (i138 <= i137) {
                int i139 = i138 + i137;
                int i140 = i138;
                dArr12[i139 % i130][i139 / i130] = ((o(i138, i39, b17, a26) * g(i140, d37, d38)) * d38) / d26;
                i138 = i140 + 1;
                i137 = i137;
                iArr9 = iArr9;
                i126 = i126;
                i130 = i130;
                iArr8 = iArr8;
                dArr11 = dArr11;
                j3 = 4607182418800017408L;
                i128 = i128;
                iArr7 = iArr7;
                i111 = i111;
            }
            i46 = i111;
            dArr2 = dArr11;
            iArr = iArr7;
            i47 = i128;
            int i141 = i130;
            iArr2 = iArr8;
            i48 = i131;
            i49 = i138;
            iArr3 = iArr9;
            dArr3 = dArr12;
            i56 = i126;
            i57 = i141;
        }
        k();
        int[] iArr10 = {r11, i38};
        int i142 = i3;
        double[][] dArr13 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr10);
        int i143 = i48 + 1;
        int i144 = i143 + i47;
        double[][] dArr14 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i142, i144);
        int i145 = ((i47 / i37) + i37 + 1) * i142;
        ByteBuffer allocate = ByteBuffer.allocate(i145 * i16);
        int i146 = i48;
        int i147 = i57;
        double[][] dArr15 = dArr3;
        int[] iArr11 = iArr3;
        double d39 = i107;
        long j16 = 4607182418800017408L;
        double d46 = ((i47 * d18) / d39) + 1.0d;
        int i148 = i17 * i142;
        double d47 = i148;
        int i149 = i143;
        ByteBuffer allocate2 = ByteBuffer.allocate((int) (d46 * d47));
        double[] dArr16 = new double[i145];
        int i150 = i49;
        double[] dArr17 = new double[(int) (i142 * d46)];
        double d48 = d47;
        int i151 = (int) (((i123 / 2.0d) / (d26 / d18)) + ((i39 / 2.0d) / (i56 / d18)));
        ByteBuffer byteBuffer4 = allocate;
        int i152 = 0;
        int i153 = 0;
        int i154 = 0;
        int i155 = 0;
        boolean z19 = true;
        int i156 = 0;
        int i157 = i26;
        int i158 = i150;
        int i159 = 0;
        while (true) {
            int i160 = (((i47 + 0) - 1) / i37) + 1;
            int i161 = i153;
            if (i160 + i152 > i157) {
                i160 = i157 - i152;
            }
            byteBuffer4.position(0);
            double d49 = d48;
            int i162 = i16 * i142;
            int i163 = i157;
            byteBuffer4.limit(i162 * i160);
            byte[] bArr = new byte[byteBuffer4.limit()];
            int i164 = i151;
            int read = inputStream.read(bArr);
            int i165 = i154;
            if (read < 0) {
                i59 = i155;
                i58 = 0;
            } else {
                i58 = read;
                i59 = i155;
            }
            int i166 = i58 < byteBuffer4.limit() ? ((i58 / i16) * i142) + i152 : i163;
            byteBuffer4.limit(i58);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(i58);
            wrap.flip();
            int i167 = i58 / i162;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        bVar = this;
                        z17 = z19;
                        i66 = 0;
                        while (i66 < i167 * i142) {
                            int i168 = i66 * 3;
                            dArr16[(i142 * 0) + i66] = (((wrap.get(i168 + 1) & 255) << 8) | ((wrap.get(i168) & 255) << 0) | ((wrap.get(i168 + 2) & 255) << 16)) * 1.1920930376163766E-7d;
                            i66++;
                            allocate2 = allocate2;
                        }
                    } else if (i16 != 4) {
                        bVar = this;
                        i66 = i158;
                        byteBuffer = allocate2;
                        z17 = z19;
                    } else {
                        int i169 = 0;
                        while (i169 < i167 * i142) {
                            dArr16[(i142 * 0) + i169] = wrap.order(this.f416563a).getInt(i169) * 4.656612875245797E-10d;
                            i169++;
                            z19 = z19;
                        }
                        bVar = this;
                        z17 = z19;
                        i66 = i169;
                    }
                    byteBuffer = allocate2;
                } else {
                    bVar = this;
                    byteBuffer = allocate2;
                    z17 = z19;
                    i66 = 0;
                    while (i66 < i167 * i142) {
                        dArr16[(i142 * 0) + i66] = wrap.order(bVar.f416563a).asShortBuffer().get(i66) * 3.051850947599719E-5d;
                        i66++;
                        i47 = i47;
                        iArr = iArr;
                    }
                }
                i65 = i47;
                iArr4 = iArr;
            } else {
                bVar = this;
                byteBuffer = allocate2;
                z17 = z19;
                i65 = i47;
                iArr4 = iArr;
                i66 = 0;
                while (i66 < i167 * i142) {
                    dArr16[(i142 * 0) + i66] = ((wrap.get(i66) & 255) - 128) * 0.007874015748031496d;
                    i66++;
                }
            }
            while (i66 < i142 * i160) {
                dArr16[i66] = 0.0d;
                i66++;
            }
            int i170 = i152 + i167;
            boolean z26 = inputStream.available() < 0 || i170 >= i166;
            int i171 = i66;
            int i172 = i161;
            int i173 = i165;
            int i174 = 0;
            while (i174 < i142) {
                int i175 = i65;
                int i176 = 0;
                int i177 = 0;
                while (i177 < i175) {
                    dArr13[i174][i177] = dArr16[(i176 * i142) + i174];
                    int i178 = i177 + 1;
                    while (true) {
                        i106 = i177 + i37;
                        if (i178 < i106) {
                            dArr13[i174][i178] = 0.0d;
                            i178++;
                        }
                    }
                    i176++;
                    i177 = i106;
                }
                int i179 = i38;
                for (int i180 = i175; i180 < i179; i180++) {
                    dArr13[i174][i180] = 0.0d;
                }
                bVar.f416564b.B(i179, 1, dArr13[i174], iArr4, dArr2);
                double[] dArr18 = dArr13[i174];
                dArr18[0] = dArr8[0] * dArr18[0];
                dArr18[1] = dArr8[1] * dArr18[1];
                for (int i181 = 1; i181 < i175; i181++) {
                    int i182 = i181 * 2;
                    double d56 = dArr8[i182];
                    double[] dArr19 = dArr13[i174];
                    double d57 = dArr19[i182];
                    int i183 = i182 + 1;
                    double d58 = dArr8[i183];
                    double d59 = dArr19[i183];
                    dArr19[i182] = (d56 * d57) - (d58 * d59);
                    dArr19[i183] = (d58 * d57) + (d56 * d59);
                }
                bVar.f416564b.B(i179, -1, dArr13[i174], iArr4, dArr2);
                int i184 = 0;
                while (i184 < i175) {
                    double[] dArr20 = dArr14[i174];
                    int i185 = i149 + i184;
                    dArr20[i185] = dArr20[i185] + dArr13[i174][i184];
                    i184++;
                }
                int i186 = i56 / i46;
                int i187 = i159 / i186;
                if (i159 % i186 != 0) {
                    i187++;
                }
                int length = (dArr14[0].length * i174) + i187;
                ByteBuffer byteBuffer5 = wrap;
                int i188 = 0;
                int i189 = i161;
                for (char c27 = 0; length - (dArr14[c27].length * i174) < i175 + 1; c27 = 0) {
                    int i190 = iArr2[i189];
                    int i191 = iArr11[i189] + length;
                    int i192 = i189 + 1;
                    double[] dArr21 = dArr16;
                    int i193 = i147;
                    i189 = i192 == i193 ? 0 : i192;
                    i147 = i193;
                    double d65 = 0.0d;
                    int i194 = i146;
                    i184 = 0;
                    while (i184 < i194) {
                        double d66 = dArr15[i190][i184];
                        int i195 = i190;
                        double[] dArr22 = dArr14[0];
                        d65 += d66 * dArr14[length / dArr22.length][length % dArr22.length];
                        length++;
                        i184++;
                        i191 = i191;
                        i190 = i195;
                    }
                    dArr17[(i188 * i142) + 0 + i174] = d65;
                    i188++;
                    i146 = i194;
                    length = i191;
                    dArr16 = dArr21;
                }
                i174++;
                i171 = i184;
                i65 = i175;
                i172 = i189;
                wrap = byteBuffer5;
                dArr16 = dArr16;
                i173 = i188;
                i38 = i179;
            }
            ByteBuffer byteBuffer6 = wrap;
            int i196 = i38;
            int i197 = i65;
            double[] dArr23 = dArr16;
            int i198 = i146;
            int i199 = i159 + ((i56 / i19) * i173);
            byteBuffer.clear();
            if (z16) {
                i171 = 0;
                while (i171 < i173 * i142) {
                    double d67 = dArr17[i171];
                    if (d67 <= 0.0d) {
                        d67 = -d67;
                    }
                    double d68 = dArr[0];
                    if (d68 >= d67) {
                        d67 = d68;
                    }
                    dArr[0] = d67;
                    byteBuffer.asDoubleBuffer().put(i171, dArr17[i171]);
                    i171++;
                }
                i67 = i149;
                i146 = i198;
                i68 = i172;
                i69 = i197;
                i75 = i196;
                i76 = i59;
                byteBuffer2 = byteBuffer;
                c16 = 2;
            } else {
                if (i17 == 1) {
                    i67 = i149;
                    i146 = i198;
                    i68 = i172;
                    i69 = i197;
                    i75 = i196;
                    i76 = i59;
                    byteBuffer2 = byteBuffer;
                    c16 = 2;
                    bVar2 = this;
                    i77 = i166;
                    double d69 = d16 * 127.0d;
                    i78 = 0;
                    int i200 = 0;
                    while (i78 < i173 * i142) {
                        if (i27 != 0) {
                            a16 = c(dArr17[i78] * d69, dArr, i27, i200);
                        } else {
                            a16 = bVar2.a(dArr17[i78] * d69);
                            if (a16 < -128) {
                                double d75 = a16 / (-128.0d);
                                c17 = 0;
                                double d76 = dArr[0];
                                if (d76 >= d75) {
                                    d75 = d76;
                                }
                                dArr[0] = d75;
                                a16 = -128;
                            } else {
                                c17 = 0;
                            }
                            if (127 < a16) {
                                double d77 = a16 / 127.0d;
                                double d78 = dArr[c17];
                                if (d78 >= d77) {
                                    d77 = d78;
                                }
                                dArr[c17] = d77;
                                a16 = 127;
                            }
                        }
                        byteBuffer2.put(i78, (byte) (a16 + 128));
                        int i201 = i200 + 1;
                        i200 = i201 == i142 ? 0 : i201;
                        i78++;
                    }
                } else if (i17 != 2) {
                    char c28 = 3;
                    if (i17 != 3) {
                        i67 = i149;
                        i146 = i198;
                        i68 = i172;
                        i69 = i197;
                        i75 = i196;
                        i76 = i59;
                        byteBuffer2 = byteBuffer;
                        c16 = 2;
                    } else {
                        double d79 = d16 * 8388607.0d;
                        int i202 = 0;
                        int i203 = 0;
                        while (i202 < i173 * i142) {
                            if (i27 != 0) {
                                c19 = c28;
                                i86 = i172;
                                i87 = i197;
                                i96 = i202;
                                i85 = i198;
                                i88 = i196;
                                i89 = i59;
                                i95 = i149;
                                i97 = i166;
                                a18 = c(dArr17[i202] * d79, dArr, i27, i203);
                            } else {
                                c19 = c28;
                                i85 = i198;
                                i86 = i172;
                                i87 = i197;
                                i88 = i196;
                                i89 = i59;
                                i95 = i149;
                                i96 = i202;
                                i97 = i166;
                                a18 = a(dArr17[i96] * d79);
                                if (a18 < -8388608) {
                                    double d85 = a18 / (-8388608.0d);
                                    c26 = 0;
                                    double d86 = dArr[0];
                                    if (d86 >= d85) {
                                        d85 = d86;
                                    }
                                    dArr[0] = d85;
                                    a18 = -8388608;
                                } else {
                                    c26 = 0;
                                }
                                if (8388607 < a18) {
                                    double d87 = a18 / 8388607.0d;
                                    double d88 = dArr[c26];
                                    if (d88 >= d87) {
                                        d87 = d88;
                                    }
                                    dArr[c26] = d87;
                                    a18 = 8388607;
                                }
                            }
                            int i204 = i96 * 3;
                            ByteBuffer byteBuffer7 = byteBuffer;
                            byteBuffer7.put(i204, (byte) (a18 & 255));
                            int i205 = a18 >> 8;
                            byteBuffer7.put(i204 + 1, (byte) (i205 & 255));
                            byteBuffer7.put(i204 + 2, (byte) ((i205 >> 8) & 255));
                            int i206 = i203 + 1;
                            i203 = i206 == i142 ? 0 : i206;
                            i202 = i96 + 1;
                            byteBuffer = byteBuffer7;
                            i149 = i95;
                            i166 = i97;
                            i172 = i86;
                            c28 = c19;
                            i198 = i85;
                            i197 = i87;
                            i59 = i89;
                            i196 = i88;
                        }
                        i146 = i198;
                        i68 = i172;
                        i69 = i197;
                        i75 = i196;
                        i76 = i59;
                        c16 = 2;
                        bVar2 = this;
                        i78 = i202;
                        i77 = i166;
                        i67 = i149;
                        byteBuffer2 = byteBuffer;
                    }
                } else {
                    c16 = 2;
                    i146 = i198;
                    i68 = i172;
                    i69 = i197;
                    i75 = i196;
                    i76 = i59;
                    bVar2 = this;
                    int i207 = i149;
                    i77 = i166;
                    ByteBuffer byteBuffer8 = byteBuffer;
                    double d89 = d16 * 32767.0d;
                    i78 = 0;
                    int i208 = 0;
                    while (i78 < i173 * i142) {
                        if (i27 != 0) {
                            i79 = i207;
                            byteBuffer3 = byteBuffer8;
                            a17 = c(dArr17[i78] * d89, dArr, i27, i208);
                        } else {
                            i79 = i207;
                            byteBuffer3 = byteBuffer8;
                            a17 = bVar2.a(dArr17[i78] * d89);
                            if (a17 < -32768) {
                                double d95 = a17 / (-32768.0d);
                                c18 = 0;
                                double d96 = dArr[0];
                                if (d96 >= d95) {
                                    d95 = d96;
                                }
                                dArr[0] = d95;
                                a17 = -32768;
                            } else {
                                c18 = 0;
                            }
                            if (32767 < a17) {
                                double d97 = a17 / 32767.0d;
                                double d98 = dArr[c18];
                                if (d98 >= d97) {
                                    d97 = d98;
                                }
                                dArr[c18] = d97;
                                a17 = 32767;
                            }
                        }
                        byteBuffer3.order(bVar2.f416563a).asShortBuffer().put(i78, (short) a17);
                        int i209 = i208 + 1;
                        i208 = i209 == i142 ? 0 : i209;
                        i78++;
                        byteBuffer8 = byteBuffer3;
                        i207 = i79;
                    }
                    i67 = i207;
                    byteBuffer2 = byteBuffer8;
                }
                if (z17) {
                    if (z26) {
                        double d99 = (i170 * d18) / d39;
                        i99 = i76 + i173;
                        if (d99 + 2.0d > i99) {
                            byteBuffer2.position(0);
                            byteBuffer2.limit(i148 * i173);
                            bVar2.p(outputStream, byteBuffer2);
                        } else {
                            byteBuffer2.position(0);
                            int floor = (int) (((Math.floor(d99) + 2.0d) - i76) * d49);
                            if (floor > 0) {
                                byteBuffer2.limit(floor);
                                bVar2.p(outputStream, byteBuffer2);
                            }
                        }
                    } else {
                        byteBuffer2.position(0);
                        byteBuffer2.limit(i148 * i173);
                        bVar2.p(outputStream, byteBuffer2);
                        i99 = i76 + i173;
                    }
                    z18 = z17;
                    i98 = i164;
                } else {
                    i98 = i164;
                    if (i173 < i98) {
                        i98 -= i173;
                        z18 = z17;
                        i99 = i76;
                    } else if (z26) {
                        double d100 = (i170 * d18) / d39;
                        if (d100 + 2.0d > (i76 + i173) - i98) {
                            byteBuffer2.position(i148 * i98);
                            int i210 = i173 - i98;
                            byteBuffer2.limit(i148 * i210);
                            bVar2.p(outputStream, byteBuffer2);
                            i99 = i76 + i210;
                            z18 = z17;
                        } else {
                            byteBuffer2.position(i148 * i98);
                            byteBuffer2.limit((int) (d49 * ((((Math.floor(d100) + 2.0d) + i76) + i173) - i98)));
                            bVar2.p(outputStream, byteBuffer2);
                            break;
                        }
                    } else {
                        byteBuffer2.position(i148 * i98);
                        byteBuffer2.limit(i148 * i173);
                        bVar2.p(outputStream, byteBuffer2);
                        i99 = i76 + (i173 - i98);
                        z18 = false;
                    }
                }
                int i211 = i56 / i46;
                i100 = (i199 - 1) / i211;
                i101 = i69;
                if (i100 > i101) {
                    i100 = i101;
                }
                i102 = 0;
                while (i102 < i3) {
                    int i212 = i98;
                    double[] dArr24 = dArr14[i102];
                    System.arraycopy(dArr24, i100, dArr24, 0, i144 - i100);
                    i102++;
                    i98 = i212;
                    z18 = z18;
                }
                int i213 = i98;
                boolean z27 = z18;
                i159 = i199 - (i100 * i211);
                for (i103 = 0; i103 < i3; i103++) {
                    System.arraycopy(dArr13[i103], i101, dArr14[i103], i67, i101);
                }
                int i214 = i67;
                int i215 = i156 + 1;
                if ((i156 & 7) != 7) {
                    i104 = i99;
                    dArr4 = dArr17;
                    i105 = i77;
                    bVar2.l(i170 / i105);
                } else {
                    i104 = i99;
                    dArr4 = dArr17;
                    i105 = i77;
                }
                i152 = i170;
                allocate2 = byteBuffer2;
                dArr17 = dArr4;
                i142 = i3;
                i155 = i104;
                byteBuffer4 = byteBuffer6;
                dArr16 = dArr23;
                i38 = i75;
                d48 = d49;
                j16 = 4607182418800017408L;
                z19 = z27;
                i156 = i215;
                i157 = i105;
                i154 = i173;
                i158 = i78;
                i47 = i101;
                iArr = iArr4;
                i151 = i213;
                i149 = i214;
                i153 = i68;
            }
            bVar2 = this;
            i78 = i171;
            i77 = i166;
            if (z17) {
            }
            int i2112 = i56 / i46;
            i100 = (i199 - 1) / i2112;
            i101 = i69;
            if (i100 > i101) {
            }
            i102 = 0;
            while (i102 < i3) {
            }
            int i2132 = i98;
            boolean z272 = z18;
            i159 = i199 - (i100 * i2112);
            while (i103 < i3) {
            }
            int i2142 = i67;
            int i2152 = i156 + 1;
            if ((i156 & 7) != 7) {
            }
            i152 = i170;
            allocate2 = byteBuffer2;
            dArr17 = dArr4;
            i142 = i3;
            i155 = i104;
            byteBuffer4 = byteBuffer6;
            dArr16 = dArr23;
            i38 = i75;
            d48 = d49;
            j16 = 4607182418800017408L;
            z19 = z272;
            i156 = i2152;
            i157 = i105;
            i154 = i173;
            i158 = i78;
            i47 = i101;
            iArr = iArr4;
            i151 = i2132;
            i149 = i2142;
            i153 = i68;
        }
        bVar2.l(1.0d);
        return dArr[0];
    }

    protected byte[] f(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    public int h(int i3, int i16, int i17, int i18, int i19, int i26, double d16) {
        int i27;
        int[] iArr = new int[97];
        int i28 = 1;
        while (i28 < 6 && i3 != f416558q[i28]) {
            i28++;
        }
        int i29 = 0;
        if ((i19 == 3 || i19 == 4) && i28 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i3));
        }
        if (i19 == 2 || i28 == 6) {
            i28 = 0;
        }
        if (i19 == 4 && (i28 == 1 || i28 == 2)) {
            i28 += 5;
        }
        this.f416569g = i28;
        this.f416568f = new double[i16];
        this.f416570h = f416559r[i28];
        for (int i36 = 0; i36 < i16; i36++) {
            this.f416568f[i36] = new double[this.f416570h];
        }
        this.f416571i = i17;
        this.f416572j = i18;
        this.f416573k = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i37 = 0; i37 < 97; i37++) {
            iArr[i37] = random.nextInt();
        }
        if (i26 != 0) {
            if (i26 != 1) {
                if (i26 == 2) {
                    boolean z16 = false;
                    double d17 = 0.0d;
                    double d18 = 0.0d;
                    for (int i38 = 0; i38 < 65536; i38++) {
                        if (!z16) {
                            double d19 = iArr[r13] / 2.147483647E9d;
                            iArr[random.nextInt() % 97] = random.nextInt();
                            if (d19 == 1.0d) {
                                d19 = 0.0d;
                            }
                            d17 = Math.sqrt(Math.log(1.0d - d19) * (-2.0d));
                            iArr[random.nextInt() % 97] = random.nextInt();
                            d18 = 6.283185307179586d * (iArr[r13] / 2.147483647E9d);
                            this.f416573k[i38] = d16 * d17 * Math.cos(d18);
                            z16 = true;
                        } else {
                            this.f416573k[i38] = d16 * d17 * Math.sin(d18);
                            z16 = false;
                        }
                    }
                }
            } else {
                int i39 = 0;
                while (i39 < 65536) {
                    int nextInt = random.nextInt() % 97;
                    int i46 = iArr[nextInt];
                    iArr[nextInt] = random.nextInt();
                    int nextInt2 = random.nextInt() % 97;
                    int i47 = iArr[nextInt2];
                    iArr[nextInt2] = random.nextInt();
                    this.f416573k[i39] = d16 * ((i46 / 2.147483647E9d) - (i47 / 2.147483647E9d));
                    i39++;
                    i29 = 0;
                }
            }
            i27 = i29;
        } else {
            for (int i48 = 0; i48 < 65536; i48++) {
                int nextInt3 = random.nextInt() % 97;
                int i49 = iArr[nextInt3];
                iArr[nextInt3] = random.nextInt();
                this.f416573k[i48] = ((i49 / 2.147483647E9d) - 0.5d) * d16;
            }
            i27 = 0;
        }
        this.f416574l = i27;
        if (i19 == 0 || i19 == 1) {
            return 1;
        }
        return f416560s[this.f416569g];
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023f A[EDGE_INSN: B:58:0x023f->B:59:0x023f BREAK  A[LOOP:0: B:5:0x002a->B:31:0x0232], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double i(InputStream inputStream, OutputStream outputStream, int i3, int i16, int i17, double d16, int i18, boolean z16, int i19) throws IOException {
        ByteBuffer byteBuffer;
        double[] dArr;
        int i26;
        ByteBuffer wrap;
        double d17;
        double d18;
        double d19;
        double d26;
        ByteBuffer byteBuffer2;
        int i27;
        int i28;
        double d27;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        int a16;
        int a17;
        int i29;
        int a18;
        double d28;
        double d29;
        int i36 = 1;
        double[] dArr2 = {0.0d};
        k();
        if (z16) {
            byteBuffer = ByteBuffer.allocate(8);
        } else {
            byteBuffer = null;
        }
        ByteBuffer byteBuffer5 = byteBuffer;
        int i37 = 4;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        int i38 = 0;
        int i39 = 0;
        while (true) {
            int i46 = i18 * i3;
            if (i38 < i46) {
                if (i16 != i36) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != i37) {
                                byteBuffer2 = allocate;
                                i26 = i38;
                                dArr = dArr2;
                                d26 = 0.0d;
                                if (inputStream.available() == 0) {
                                    break;
                                }
                                double d36 = d26 * d16;
                                if (!z16) {
                                    if (i17 != 1) {
                                        if (i17 != 2) {
                                            if (i17 != 3) {
                                                i27 = i46;
                                                byteBuffer4 = byteBuffer5;
                                                i28 = 4;
                                            } else {
                                                double d37 = d36 * 8388607.0d;
                                                if (i19 != 0) {
                                                    i27 = i46;
                                                    i29 = 3;
                                                    i28 = 4;
                                                    byteBuffer4 = byteBuffer5;
                                                    a18 = c(d37, dArr, i19, i39);
                                                } else {
                                                    i27 = i46;
                                                    i29 = 3;
                                                    byteBuffer4 = byteBuffer5;
                                                    i28 = 4;
                                                    a18 = a(d37);
                                                }
                                                byteBuffer2.position(0);
                                                byteBuffer2.limit(i29);
                                                byteBuffer2.put(0, (byte) (a18 & 255));
                                                int i47 = a18 >> 8;
                                                byteBuffer2.put(1, (byte) (i47 & 255));
                                                byteBuffer2.put(2, (byte) ((i47 >> 8) & 255));
                                                byteBuffer2.flip();
                                                p(outputStream, byteBuffer2);
                                            }
                                        } else {
                                            i27 = i46;
                                            byteBuffer4 = byteBuffer5;
                                            i28 = 4;
                                            double d38 = d36 * 32767.0d;
                                            if (i19 != 0) {
                                                a17 = c(d38, dArr, i19, i39);
                                            } else {
                                                a17 = a(d38);
                                            }
                                            byteBuffer2.position(0);
                                            byteBuffer2.limit(2);
                                            byteBuffer2.asShortBuffer().put(0, (short) a17);
                                            byteBuffer2.flip();
                                            p(outputStream, byteBuffer2);
                                        }
                                    } else {
                                        i27 = i46;
                                        byteBuffer4 = byteBuffer5;
                                        i28 = 4;
                                        double d39 = d36 * 127.0d;
                                        if (i19 != 0) {
                                            a16 = c(d39, dArr, i19, i39);
                                        } else {
                                            a16 = a(d39);
                                        }
                                        byteBuffer2.position(0);
                                        byteBuffer2.limit(1);
                                        byteBuffer2.put(0, (byte) (a16 + 128));
                                        byteBuffer2.flip();
                                        p(outputStream, byteBuffer2);
                                    }
                                    byteBuffer3 = byteBuffer4;
                                } else {
                                    i27 = i46;
                                    ByteBuffer byteBuffer6 = byteBuffer5;
                                    i28 = 4;
                                    if (d36 > 0.0d) {
                                        d27 = d36;
                                    } else {
                                        d27 = -d36;
                                    }
                                    double d46 = dArr[0];
                                    if (d46 >= d27) {
                                        d27 = d46;
                                    }
                                    dArr[0] = d27;
                                    byteBuffer3 = byteBuffer6;
                                    byteBuffer3.position(0);
                                    byteBuffer3.putDouble(d36);
                                    byteBuffer3.flip();
                                    p(outputStream, byteBuffer3);
                                }
                                int i48 = i39 + 1;
                                if (i48 == i3) {
                                    i39 = 0;
                                } else {
                                    i39 = i48;
                                }
                                i38 = i26 + 1;
                                if ((262143 & i38) == 0) {
                                    l(i38 / i27);
                                }
                                byteBuffer5 = byteBuffer3;
                                allocate = byteBuffer2;
                                i37 = i28;
                                dArr2 = dArr;
                                i36 = 1;
                            } else {
                                allocate.position(0);
                                allocate.limit(i37);
                                byte[] bArr = new byte[allocate.limit()];
                                inputStream.read(bArr);
                                wrap = ByteBuffer.wrap(bArr);
                                wrap.position(wrap.limit());
                                wrap.flip();
                                d29 = 4.656612875245797E-10d;
                                dArr = dArr2;
                                d28 = wrap.order(this.f416563a).asIntBuffer().get(0);
                            }
                        } else {
                            dArr = dArr2;
                            allocate.position(0);
                            allocate.limit(3);
                            byte[] bArr2 = new byte[allocate.limit()];
                            inputStream.read(bArr2);
                            wrap = ByteBuffer.wrap(bArr2);
                            wrap.position(wrap.limit());
                            wrap.flip();
                            d28 = ((wrap.get(0) & 255) << 0) | ((wrap.get(1) & 255) << 8) | ((wrap.get(2) & 255) << 16);
                            d29 = 1.1920930376163766E-7d;
                        }
                        d19 = d28 * d29;
                        i26 = i38;
                        d26 = d19;
                        byteBuffer2 = wrap;
                        if (inputStream.available() == 0) {
                        }
                    } else {
                        dArr = dArr2;
                        allocate.position(0);
                        allocate.limit(2);
                        byte[] bArr3 = new byte[allocate.limit()];
                        inputStream.read(bArr3);
                        wrap = ByteBuffer.wrap(bArr3);
                        wrap.position(wrap.limit());
                        wrap.flip();
                        d18 = 3.051850947599719E-5d;
                        i26 = i38;
                        d17 = wrap.order(this.f416563a).asShortBuffer().get(0);
                    }
                } else {
                    i26 = i38;
                    dArr = dArr2;
                    allocate.position(0);
                    allocate.limit(1);
                    byte[] bArr4 = new byte[allocate.limit()];
                    inputStream.read(bArr4);
                    wrap = ByteBuffer.wrap(bArr4);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    d17 = wrap.get(0) - 128;
                    d18 = 0.007874015748031496d;
                }
                d19 = d18 * d17;
                d26 = d19;
                byteBuffer2 = wrap;
                if (inputStream.available() == 0) {
                }
            } else {
                dArr = dArr2;
                break;
            }
        }
        l(1.0d);
        return dArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x085b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double n(InputStream inputStream, OutputStream outputStream, int i3, int i16, int i17, int i18, int i19, double d16, int i26, boolean z16, int i27) throws IOException {
        int i28;
        double d17;
        double d18;
        int i29;
        double d19;
        int i36;
        int i37;
        double[] dArr;
        int i38;
        int i39;
        int i46;
        int i47;
        ByteBuffer byteBuffer;
        int i48;
        int i49;
        char c16;
        double[] dArr2;
        int i56;
        int i57;
        ByteBuffer byteBuffer2;
        int i58;
        int a16;
        char c17;
        int i59;
        int i65;
        int i66;
        ByteBuffer byteBuffer3;
        int a17;
        char c18;
        int i67;
        int i68;
        ByteBuffer byteBuffer4;
        int i69;
        char c19;
        double[] dArr3;
        int i75;
        int a18;
        char c26;
        int i76;
        int i77;
        int i78;
        double[] dArr4;
        int i79;
        int i85;
        int i86;
        int i87;
        int i88;
        int i89;
        int i95;
        int i96 = i19;
        double[] dArr5 = {0.0d};
        int i97 = this.f416567e;
        double d26 = this.f416565c;
        int e16 = i18 / e(i18, i96);
        int i98 = e16 * i96;
        int i99 = i98 / i96;
        if (i99 == 1) {
            i28 = 1;
        } else if (i99 % 2 == 0) {
            i28 = 2;
        } else {
            if (i99 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i18), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i99)));
            }
            i28 = 3;
        }
        int i100 = i96 * i28;
        int i101 = i18 / 2;
        double d27 = (r7 * 2) / 2.0d;
        double d28 = i101;
        double d29 = d28 + (((i100 / 2) - i101) / 2.0d);
        if (d26 <= 21.0d) {
            d18 = d28;
            d17 = 0.9222d;
        } else {
            d17 = (d26 - 7.95d) / 14.36d;
            d18 = d28;
        }
        double d36 = i98;
        int i102 = (int) (((d36 / d27) * d17) + 1.0d);
        if (i102 % 2 == 0) {
            i102++;
        }
        int i103 = i102;
        double b16 = b(d26);
        double a19 = a.a(b16);
        int i104 = i98 / i18;
        int i105 = (i103 / i104) + 1;
        int i106 = i104 * i28;
        int[] iArr = new int[i106];
        for (int i107 = 0; i107 < i106; i107++) {
            int i108 = i104 - (((i98 / i100) * i107) % i104);
            iArr[i107] = i108;
            if (i108 == i104) {
                iArr[i107] = 0;
            }
        }
        int[] iArr2 = new int[i106];
        int i109 = 0;
        while (i109 < i106) {
            int i110 = i106;
            iArr2[i109] = iArr[i109] < i98 / i100 ? i3 : 0;
            if (iArr[i109] == i104) {
                iArr[i109] = 0;
            }
            i109++;
            i106 = i110;
        }
        int i111 = i106;
        boolean z17 = false;
        double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i104, i105);
        int i112 = i103 / 2;
        int i113 = -i112;
        while (i113 <= i112) {
            int i114 = i113 + i112;
            int i115 = i111;
            int i116 = i113;
            dArr6[i114 % i104][i114 / i104] = ((o(i113, i103, b16, a19) * g(i116, d29, d36)) * d36) / i18;
            i113 = i116 + 1;
            i100 = i100;
            i112 = i112;
            dArr5 = dArr5;
            i98 = i98;
            iArr2 = iArr2;
            iArr = iArr;
            i111 = i115;
            i105 = i105;
            z17 = false;
            i103 = i103;
        }
        int[] iArr3 = iArr;
        int i117 = i112;
        int[] iArr4 = iArr2;
        int i118 = i98;
        double[] dArr7 = dArr5;
        int i119 = i105;
        int i120 = i111;
        int i121 = i100;
        double d37 = this.f416565c;
        double d38 = d37 > 21.0d ? (d37 - 7.95d) / 14.36d : 0.9222d;
        int i122 = 1;
        while (true) {
            int i123 = i97 * i122;
            if (i123 % 2 == 0) {
                i123--;
            }
            i29 = i123;
            d19 = i121;
            i36 = i104;
            if ((d19 * d38) / (i29 - 1) < this.f416566d) {
                break;
            }
            i122 *= 2;
            i96 = i19;
            i104 = i36;
            d18 = d18;
            i120 = i120;
        }
        double b17 = b(d37);
        double a26 = a.a(b17);
        int i124 = 1;
        while (i124 < i29) {
            i124 *= 2;
        }
        int i125 = i124 * 2;
        double[] dArr8 = new double[i125];
        int i126 = i29 / 2;
        int i127 = -i126;
        while (i127 <= i126) {
            int i128 = i127;
            int i129 = i125;
            double[] dArr9 = dArr8;
            double d39 = d19;
            dArr9[i127 + i126] = ((o(i127, i29, b17, a26) * g(i128, d18, d39)) / i129) * 2.0d;
            i127 = i128 + 1;
            i125 = i129;
            i126 = i126;
            dArr8 = dArr9;
            d19 = d39;
        }
        int i130 = i127;
        int i131 = i125;
        double[] dArr10 = dArr8;
        double d46 = d19;
        int[] iArr5 = new int[(int) (Math.sqrt(i131) + 2.0d)];
        iArr5[0] = 0;
        int i132 = i131 / 2;
        double[] dArr11 = new double[i132];
        this.f416564b.B(i131, 1, dArr10, iArr5, dArr11);
        k();
        int i133 = (i132 / i28) + 1;
        double[][] dArr12 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i133);
        double[][] dArr13 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i131);
        int i134 = i119;
        int i135 = (i132 + i134 + 2) * i3;
        int i136 = i16;
        ByteBuffer allocate = ByteBuffer.allocate(i135 * i136);
        int i137 = i133 * i3;
        int i138 = i131;
        ByteBuffer allocate2 = ByteBuffer.allocate(i137 * i17);
        double[] dArr14 = new double[i135];
        double[] dArr15 = new double[i137];
        int i139 = (int) ((i29 / 2.0d) / (i121 / i96));
        ByteBuffer byteBuffer5 = allocate2;
        int i140 = (i117 / i36) + 1;
        int i141 = 0;
        int i142 = 0;
        int i143 = 0;
        int i144 = 0;
        boolean z18 = true;
        int i145 = 0;
        int i146 = 0;
        ByteBuffer byteBuffer6 = allocate;
        int i147 = i26;
        int i148 = 0;
        while (true) {
            double[] dArr16 = dArr15;
            int[] iArr6 = iArr5;
            int i149 = i132;
            int i150 = i138;
            double d47 = i18;
            int ceil = (int) (((Math.ceil((i132 * d47) / d46) + 1.0d) + i134) - i140);
            int i151 = ceil + i141 > i147 ? i147 - i141 : ceil;
            byteBuffer6.position(0);
            int i152 = i136 * i3;
            byteBuffer6.limit(i151 * i152);
            byte[] bArr = new byte[byteBuffer6.limit()];
            int read = inputStream.read(bArr);
            int i153 = i147;
            int i154 = read < 0 ? 0 : read;
            int i155 = i154 < byteBuffer6.limit() ? ((i154 / i136) * i3) + i141 : i153;
            byteBuffer6.limit(i154);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(i154);
            wrap.flip();
            int i156 = i154 / i152;
            if (i136 == 1) {
                i37 = i134;
                dArr = dArr11;
                i38 = i155;
                i39 = 0;
                while (i39 < i156 * i3) {
                    dArr14[(i3 * i140) + i39] = (wrap.get(i39) - 128.0d) * 0.007874015748031496d;
                    i39++;
                }
            } else if (i136 != 2) {
                if (i136 == 3) {
                    i37 = i134;
                    i39 = 0;
                    while (i39 < i156 * i3) {
                        int i157 = i39 * 3;
                        dArr14[(i3 * i140) + i39] = ((wrap.get(i157 + 2) << RegisterType.UNINIT_REF) | (wrap.get(i157 + 1) << 8) | (wrap.get(i157) << 0)) * 1.1920930376163766E-7d;
                        i39++;
                        i155 = i155;
                        dArr11 = dArr11;
                    }
                    dArr = dArr11;
                } else if (i136 != 4) {
                    i37 = i134;
                    dArr = dArr11;
                    i38 = i155;
                    i39 = i130;
                } else {
                    int i158 = 0;
                    while (i158 < i156 * i3) {
                        dArr14[(i3 * i140) + i158] = wrap.order(this.f416563a).asIntBuffer().get(i158) * 4.656612875245797E-10d;
                        i158++;
                        i134 = i134;
                    }
                    i37 = i134;
                    dArr = dArr11;
                    i39 = i158;
                }
                i38 = i155;
            } else {
                i37 = i134;
                dArr = dArr11;
                i38 = i155;
                i39 = 0;
                while (i39 < i156 * i3) {
                    dArr14[(i3 * i140) + i39] = wrap.order(this.f416563a).asShortBuffer().get(i39) * 3.051850947599719E-5d;
                    i39++;
                }
            }
            while (i39 < i3 * ceil) {
                dArr14[(i3 * i140) + i39] = 0.0d;
                i39++;
            }
            int i159 = i140 + ceil;
            i141 += i156;
            int i160 = i38;
            boolean z19 = i141 >= i160;
            int i161 = ((((i146 - 1) * i18) + i118) / i118) * i3;
            int i162 = i148;
            int i163 = i39;
            int i164 = i142;
            int i165 = i144;
            int i166 = 0;
            while (i166 < i3) {
                int i167 = i161 + i166;
                int i168 = i37;
                if (i168 == 7) {
                    i87 = i149;
                    i88 = i161;
                    i89 = i120;
                    i95 = i148;
                    for (int i169 = 0; i169 < i87; i169++) {
                        int i170 = iArr3[i95];
                        double[] dArr17 = dArr13[i166];
                        double[] dArr18 = dArr6[i170];
                        dArr17[i169] = (dArr18[0] * dArr14[i167 + (i3 * 0)]) + (dArr18[1] * dArr14[i167 + (i3 * 1)]) + (dArr18[2] * dArr14[i167 + (i3 * 2)]) + (dArr18[3] * dArr14[i167 + (i3 * 3)]) + (dArr18[4] * dArr14[i167 + (i3 * 4)]) + (dArr18[5] * dArr14[i167 + (i3 * 5)]) + (dArr18[6] * dArr14[i167 + (i3 * 6)]);
                        i167 += iArr4[i95];
                        i95++;
                        if (i95 == i89) {
                            i95 = 0;
                        }
                    }
                } else if (i168 != 9) {
                    i95 = i148;
                    i87 = i149;
                    int i171 = 0;
                    while (i171 < i87) {
                        int i172 = iArr3[i95];
                        int i173 = i161;
                        int i174 = i167;
                        double d48 = 0.0d;
                        for (int i175 = 0; i175 < i168; i175++) {
                            d48 += dArr6[i172][i175] * dArr14[i174];
                            i174 += i3;
                        }
                        dArr13[i166][i171] = d48;
                        i167 += iArr4[i95];
                        int i176 = i95 + 1;
                        int i177 = i120;
                        if (i176 == i177) {
                            i176 = 0;
                        }
                        i171++;
                        i120 = i177;
                        i95 = i176;
                        i161 = i173;
                    }
                    i88 = i161;
                    i89 = i120;
                } else {
                    i87 = i149;
                    i88 = i161;
                    i89 = i120;
                    int i178 = i148;
                    for (int i179 = 0; i179 < i87; i179++) {
                        int i180 = iArr3[i178];
                        double[] dArr19 = dArr13[i166];
                        double[] dArr20 = dArr6[i180];
                        dArr19[i179] = (dArr20[0] * dArr14[i167 + (i3 * 0)]) + (dArr20[1] * dArr14[i167 + (i3 * 1)]) + (dArr20[2] * dArr14[i167 + (i3 * 2)]) + (dArr20[3] * dArr14[i167 + (i3 * 3)]) + (dArr20[4] * dArr14[i167 + (i3 * 4)]) + (dArr20[5] * dArr14[i167 + (i3 * 5)]) + (dArr20[6] * dArr14[i167 + (i3 * 6)]) + (dArr20[7] * dArr14[i167 + (i3 * 7)]) + (dArr20[8] * dArr14[i167 + (i3 * 8)]);
                        i167 += iArr4[i178];
                        int i181 = i178 + 1;
                        i178 = i181 == i89 ? 0 : i181;
                    }
                    i95 = i178;
                }
                for (int i182 = i87; i182 < i150; i182++) {
                    dArr13[i166][i182] = 0.0d;
                }
                this.f416564b.B(i150, 1, dArr13[i166], iArr6, dArr);
                double[] dArr21 = dArr13[i166];
                dArr21[0] = dArr10[0] * dArr21[0];
                dArr21[1] = dArr10[1] * dArr21[1];
                for (int i183 = 1; i183 < i87; i183++) {
                    int i184 = i183 * 2;
                    double d49 = dArr10[i184];
                    double[] dArr22 = dArr13[i166];
                    double d56 = dArr22[i184];
                    int i185 = i184 + 1;
                    double d57 = dArr10[i185];
                    double d58 = dArr22[i185];
                    dArr22[i184] = (d49 * d56) - (d57 * d58);
                    dArr22[i185] = (d57 * d56) + (d49 * d58);
                }
                this.f416564b.B(i150, -1, dArr13[i166], iArr6, dArr);
                int i186 = i142;
                int i187 = 0;
                while (i186 < i87) {
                    dArr16[i166 + (i187 * i3)] = dArr12[i166][i187] + dArr13[i166][i186];
                    i186 += i28;
                    i187++;
                }
                int i188 = i186 - i87;
                int i189 = 0;
                while (i186 < i150) {
                    dArr12[i166][i189] = dArr13[i166][i186];
                    i186 += i28;
                    i189++;
                }
                i166++;
                i120 = i89;
                i37 = i168;
                i161 = i88;
                i165 = i187;
                i163 = i186;
                i149 = i87;
                i162 = i95;
                i164 = i188;
            }
            char c27 = 7;
            int i190 = i149;
            int i191 = i120;
            int i192 = i37;
            int i193 = i146 + ((i190 * e16) / i28);
            byteBuffer5.clear();
            if (z16) {
                i163 = 0;
                while (i163 < i165 * i3) {
                    int i194 = i150;
                    double[] dArr23 = dArr14;
                    double d59 = dArr16[i163];
                    if (d59 <= 0.0d) {
                        d59 = -d59;
                    }
                    double d65 = dArr7[0];
                    if (d65 >= d59) {
                        d59 = d65;
                    }
                    dArr7[0] = d59;
                    byteBuffer5.asDoubleBuffer().put(i163, dArr16[i163]);
                    i163++;
                    dArr14 = dArr23;
                    i150 = i194;
                    i191 = i191;
                }
                i49 = i150;
                i46 = i191;
                i47 = i192;
                byteBuffer = wrap;
                i48 = i162;
                c16 = 3;
                dArr2 = dArr14;
            } else {
                int i195 = i150;
                double[] dArr24 = dArr14;
                i46 = i191;
                if (i17 == 1) {
                    i47 = i192;
                    byteBuffer = wrap;
                    i48 = i162;
                    i49 = i195;
                    c16 = 3;
                    dArr2 = dArr24;
                    i56 = i165;
                    ByteBuffer byteBuffer7 = byteBuffer5;
                    i57 = i164;
                    byteBuffer2 = byteBuffer7;
                    double d66 = d16 * 127.0d;
                    i58 = 0;
                    int i196 = 0;
                    while (i58 < i56 * i3) {
                        if (i27 != 0) {
                            a16 = c(dArr16[i58] * d66, dArr7, i27, i196);
                        } else {
                            a16 = a(dArr16[i58] * d66);
                            if (a16 < -128) {
                                double d67 = a16 / (-128.0d);
                                c17 = 0;
                                double d68 = dArr7[0];
                                if (d68 >= d67) {
                                    d67 = d68;
                                }
                                dArr7[0] = d67;
                                a16 = -128;
                            } else {
                                c17 = 0;
                            }
                            if (127 < a16) {
                                double d69 = a16 / 127.0d;
                                double d75 = dArr7[c17];
                                if (d75 >= d69) {
                                    d69 = d75;
                                }
                                dArr7[c17] = d69;
                                a16 = 127;
                            }
                        }
                        byteBuffer2.put(i58, (byte) (a16 + 128));
                        int i197 = i196 + 1;
                        i196 = i197 == i3 ? 0 : i197;
                        i58++;
                    }
                } else if (i17 != 2) {
                    char c28 = 3;
                    if (i17 != 3) {
                        i47 = i192;
                        byteBuffer = wrap;
                        i48 = i162;
                        i49 = i195;
                        c16 = 3;
                        dArr2 = dArr24;
                    } else {
                        double d76 = d16 * 8388607.0d;
                        i163 = 0;
                        int i198 = 0;
                        while (i163 < i165 * i3) {
                            if (i27 != 0) {
                                i69 = i195;
                                c19 = c28;
                                i67 = i163;
                                int i199 = i192;
                                dArr3 = dArr24;
                                byteBuffer4 = wrap;
                                i68 = i199;
                                i75 = i165;
                                a18 = c(dArr16[i163] * d76, dArr7, i27, i198);
                            } else {
                                i67 = i163;
                                i68 = i192;
                                byteBuffer4 = wrap;
                                i69 = i195;
                                c19 = c28;
                                dArr3 = dArr24;
                                i75 = i165;
                                a18 = a(dArr16[i67] * d76);
                                if (a18 < -8388608) {
                                    double d77 = a18 / (-8388608.0d);
                                    c26 = 0;
                                    double d78 = dArr7[0];
                                    if (d78 >= d77) {
                                        d77 = d78;
                                    }
                                    dArr7[0] = d77;
                                    a18 = -8388608;
                                } else {
                                    c26 = 0;
                                }
                                if (8388607 < a18) {
                                    double d79 = a18 / 8388607.0d;
                                    double d85 = dArr7[c26];
                                    if (d85 >= d79) {
                                        d79 = d85;
                                    }
                                    dArr7[c26] = d79;
                                    a18 = 8388607;
                                }
                            }
                            int i200 = i67 * 3;
                            ByteBuffer byteBuffer8 = byteBuffer5;
                            byteBuffer8.put(i200, (byte) (a18 & 255));
                            int i201 = a18 >> 8;
                            byteBuffer8.put(i200 + 1, (byte) (i201 & 255));
                            byteBuffer8.put(i200 + 2, (byte) ((i201 >> 8) & 255));
                            int i202 = i198 + 1;
                            i198 = i202 == i3 ? 0 : i202;
                            i163 = i67 + 1;
                            byteBuffer5 = byteBuffer8;
                            dArr24 = dArr3;
                            i165 = i75;
                            c28 = c19;
                            i195 = i69;
                            wrap = byteBuffer4;
                            i192 = i68;
                            c27 = 7;
                        }
                        i47 = i192;
                        byteBuffer = wrap;
                        i49 = i195;
                        c16 = c28;
                        dArr2 = dArr24;
                        i56 = i165;
                        i48 = i162;
                        ByteBuffer byteBuffer9 = byteBuffer5;
                        i57 = i164;
                        byteBuffer2 = byteBuffer9;
                        if (z18) {
                            i76 = i160;
                            i77 = i159;
                            int i203 = i145;
                            int i204 = i139;
                            if (i56 < i204) {
                                i139 = i204 - i56;
                                i78 = i163;
                                i79 = i203;
                                dArr4 = dArr2;
                            } else if (z19) {
                                dArr4 = dArr2;
                                double d86 = (i141 * i19) / d47;
                                i78 = i163;
                                if (d86 + 2.0d > (i203 + i56) - i204) {
                                    int i205 = i17 * i3;
                                    byteBuffer2.position(i205 * i204);
                                    byteBuffer2.limit(i205 * i56);
                                    p(outputStream, byteBuffer2);
                                    i79 = (i56 - i204) + i203;
                                    i139 = i204;
                                } else {
                                    int i206 = i17 * i3;
                                    byteBuffer2.position(i204 * i206);
                                    byteBuffer2.limit((int) (i206 * ((Math.floor(d86) + 2.0d) - i203)));
                                    p(outputStream, byteBuffer2);
                                    break;
                                }
                            } else {
                                i78 = i163;
                                dArr4 = dArr2;
                                int i207 = i17 * i3;
                                byteBuffer2.position(i207 * i204);
                                byteBuffer2.limit(i207 * i56);
                                p(outputStream, byteBuffer2);
                                i79 = (i56 - i204) + i203;
                                i139 = i204;
                                z18 = false;
                                int i208 = (i193 - 1) / i36;
                                i140 = i77 - i208;
                                double[] dArr25 = dArr4;
                                System.arraycopy(dArr25, i3 * i208, dArr25, 0, i3 * i140);
                                i146 = i193 - (i208 * i36);
                                int i209 = i143 + 1;
                                if ((i143 & 7) == 7) {
                                }
                                i136 = i16;
                                i145 = i85;
                                i147 = i86;
                                dArr14 = dArr25;
                                i143 = i209;
                                i132 = i190;
                                i138 = i49;
                                i148 = i48;
                                dArr15 = dArr16;
                                iArr5 = iArr6;
                                dArr11 = dArr;
                                i134 = i47;
                                i130 = i78;
                                i120 = i46;
                                i142 = i57;
                                i144 = i56;
                                byteBuffer5 = byteBuffer2;
                                byteBuffer6 = byteBuffer;
                            }
                        } else if (z19) {
                            double d87 = (i141 * i19) / d47;
                            int i210 = i145 + i56;
                            i76 = i160;
                            i77 = i159;
                            if (d87 + 2.0d > i210) {
                                byteBuffer2.position(0);
                                byteBuffer2.limit(i17 * i3 * i56);
                                p(outputStream, byteBuffer2);
                                i79 = i210;
                                i78 = i163;
                                dArr4 = dArr2;
                            } else {
                                byteBuffer2.position(0);
                                int floor = (int) (i17 * i3 * ((Math.floor(d87) + 2.0d) - i145));
                                if (floor > 0) {
                                    byteBuffer2.limit(floor);
                                    p(outputStream, byteBuffer2);
                                }
                            }
                        } else {
                            i76 = i160;
                            i77 = i159;
                            byteBuffer2.position(0);
                            byteBuffer2.limit(i17 * i3 * i56);
                            p(outputStream, byteBuffer2);
                            i78 = i163;
                            i79 = i145 + i56;
                            dArr4 = dArr2;
                            int i2082 = (i193 - 1) / i36;
                            i140 = i77 - i2082;
                            double[] dArr252 = dArr4;
                            System.arraycopy(dArr252, i3 * i2082, dArr252, 0, i3 * i140);
                            i146 = i193 - (i2082 * i36);
                            int i2092 = i143 + 1;
                            if ((i143 & 7) == 7) {
                                i85 = i79;
                                i86 = i76;
                                l(i141 / i86);
                            } else {
                                i85 = i79;
                                i86 = i76;
                            }
                            i136 = i16;
                            i145 = i85;
                            i147 = i86;
                            dArr14 = dArr252;
                            i143 = i2092;
                            i132 = i190;
                            i138 = i49;
                            i148 = i48;
                            dArr15 = dArr16;
                            iArr5 = iArr6;
                            dArr11 = dArr;
                            i134 = i47;
                            i130 = i78;
                            i120 = i46;
                            i142 = i57;
                            i144 = i56;
                            byteBuffer5 = byteBuffer2;
                            byteBuffer6 = byteBuffer;
                        }
                        int i20822 = (i193 - 1) / i36;
                        i140 = i77 - i20822;
                        double[] dArr2522 = dArr4;
                        System.arraycopy(dArr2522, i3 * i20822, dArr2522, 0, i3 * i140);
                        i146 = i193 - (i20822 * i36);
                        int i20922 = i143 + 1;
                        if ((i143 & 7) == 7) {
                        }
                        i136 = i16;
                        i145 = i85;
                        i147 = i86;
                        dArr14 = dArr2522;
                        i143 = i20922;
                        i132 = i190;
                        i138 = i49;
                        i148 = i48;
                        dArr15 = dArr16;
                        iArr5 = iArr6;
                        dArr11 = dArr;
                        i134 = i47;
                        i130 = i78;
                        i120 = i46;
                        i142 = i57;
                        i144 = i56;
                        byteBuffer5 = byteBuffer2;
                        byteBuffer6 = byteBuffer;
                    }
                } else {
                    i47 = i192;
                    byteBuffer = wrap;
                    i49 = i195;
                    c16 = 3;
                    dArr2 = dArr24;
                    i56 = i165;
                    ByteBuffer byteBuffer10 = byteBuffer5;
                    double d88 = d16 * 32767.0d;
                    int i211 = 0;
                    int i212 = 0;
                    while (i211 < i56 * i3) {
                        if (i27 != 0) {
                            i59 = i162;
                            i66 = i211;
                            i65 = i164;
                            byteBuffer3 = byteBuffer10;
                            a17 = c(dArr16[i211] * d88, dArr7, i27, i212);
                        } else {
                            i59 = i162;
                            i65 = i164;
                            i66 = i211;
                            byteBuffer3 = byteBuffer10;
                            a17 = a(dArr16[i66] * d88);
                            if (a17 < -32768) {
                                double d89 = a17 / (-32768.0d);
                                c18 = 0;
                                double d95 = dArr7[0];
                                if (d95 >= d89) {
                                    d89 = d95;
                                }
                                dArr7[0] = d89;
                                a17 = -32768;
                            } else {
                                c18 = 0;
                            }
                            if (32767 < a17) {
                                double d96 = a17 / 32767.0d;
                                double d97 = dArr7[c18];
                                if (d97 >= d96) {
                                    d96 = d97;
                                }
                                dArr7[c18] = d96;
                                a17 = 32767;
                            }
                        }
                        byteBuffer3.order(this.f416563a).asShortBuffer().put(i66, (short) a17);
                        int i213 = i212 + 1;
                        i212 = i213 == i3 ? 0 : i213;
                        i211 = i66 + 1;
                        byteBuffer10 = byteBuffer3;
                        i162 = i59;
                        i164 = i65;
                    }
                    i48 = i162;
                    i57 = i164;
                    i58 = i211;
                    byteBuffer2 = byteBuffer10;
                }
                i163 = i58;
                if (z18) {
                }
                int i208222 = (i193 - 1) / i36;
                i140 = i77 - i208222;
                double[] dArr25222 = dArr4;
                System.arraycopy(dArr25222, i3 * i208222, dArr25222, 0, i3 * i140);
                i146 = i193 - (i208222 * i36);
                int i209222 = i143 + 1;
                if ((i143 & 7) == 7) {
                }
                i136 = i16;
                i145 = i85;
                i147 = i86;
                dArr14 = dArr25222;
                i143 = i209222;
                i132 = i190;
                i138 = i49;
                i148 = i48;
                dArr15 = dArr16;
                iArr5 = iArr6;
                dArr11 = dArr;
                i134 = i47;
                i130 = i78;
                i120 = i46;
                i142 = i57;
                i144 = i56;
                byteBuffer5 = byteBuffer2;
                byteBuffer6 = byteBuffer;
            }
            i56 = i165;
            ByteBuffer byteBuffer92 = byteBuffer5;
            i57 = i164;
            byteBuffer2 = byteBuffer92;
            if (z18) {
            }
            int i2082222 = (i193 - 1) / i36;
            i140 = i77 - i2082222;
            double[] dArr252222 = dArr4;
            System.arraycopy(dArr252222, i3 * i2082222, dArr252222, 0, i3 * i140);
            i146 = i193 - (i2082222 * i36);
            int i2092222 = i143 + 1;
            if ((i143 & 7) == 7) {
            }
            i136 = i16;
            i145 = i85;
            i147 = i86;
            dArr14 = dArr252222;
            i143 = i2092222;
            i132 = i190;
            i138 = i49;
            i148 = i48;
            dArr15 = dArr16;
            iArr5 = iArr6;
            dArr11 = dArr;
            i134 = i47;
            i130 = i78;
            i120 = i46;
            i142 = i57;
            i144 = i56;
            byteBuffer5 = byteBuffer2;
            byteBuffer6 = byteBuffer;
        }
        l(1.0d);
        return dArr7[0];
    }

    protected void p(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(f(byteBuffer));
        } catch (IOException unused) {
        }
    }

    private void j(int i3) {
    }
}
