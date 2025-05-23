package org.apache.commons.lang.math;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.math.BigInteger;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Fraction extends Number implements Comparable {
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private final int numerator;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    private transient int hashCode = 0;
    private transient String toString = null;
    private transient String toProperString = null;

    Fraction(int i3, int i16) {
        this.numerator = i3;
        this.denominator = i16;
    }

    private static int addAndCheck(int i3, int i16) {
        long j3 = i3 + i16;
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction fraction, boolean z16) {
        BigInteger subtract;
        int greatestCommonDivisor;
        int subAndCheck;
        if (fraction != null) {
            if (this.numerator == 0) {
                if (!z16) {
                    return fraction.negate();
                }
                return fraction;
            }
            if (fraction.numerator == 0) {
                return this;
            }
            int greatestCommonDivisor2 = greatestCommonDivisor(this.denominator, fraction.denominator);
            if (greatestCommonDivisor2 == 1) {
                int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                if (z16) {
                    subAndCheck = addAndCheck(mulAndCheck, mulAndCheck2);
                } else {
                    subAndCheck = subAndCheck(mulAndCheck, mulAndCheck2);
                }
                return new Fraction(subAndCheck, mulPosAndCheck(this.denominator, fraction.denominator));
            }
            BigInteger multiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / greatestCommonDivisor2));
            BigInteger multiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / greatestCommonDivisor2));
            if (z16) {
                subtract = multiply.add(multiply2);
            } else {
                subtract = multiply.subtract(multiply2);
            }
            int intValue = subtract.mod(BigInteger.valueOf(greatestCommonDivisor2)).intValue();
            if (intValue == 0) {
                greatestCommonDivisor = greatestCommonDivisor2;
            } else {
                greatestCommonDivisor = greatestCommonDivisor(intValue, greatestCommonDivisor2);
            }
            BigInteger divide = subtract.divide(BigInteger.valueOf(greatestCommonDivisor));
            if (divide.bitLength() <= 31) {
                return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
            }
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public static Fraction getFraction(int i3, int i16) {
        if (i16 != 0) {
            if (i16 < 0) {
                if (i3 == Integer.MIN_VALUE || i16 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i3 = -i3;
                i16 = -i16;
            }
            return new Fraction(i3, i16);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i3, int i16) {
        if (i16 != 0) {
            if (i3 == 0) {
                return ZERO;
            }
            if (i16 == Integer.MIN_VALUE && (i3 & 1) == 0) {
                i3 /= 2;
                i16 /= 2;
            }
            if (i16 < 0) {
                if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
                    i3 = -i3;
                    i16 = -i16;
                } else {
                    throw new ArithmeticException("overflow: can't negate");
                }
            }
            int greatestCommonDivisor = greatestCommonDivisor(i3, i16);
            return new Fraction(i3 / greatestCommonDivisor, i16 / greatestCommonDivisor);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if (r2 != 1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if ((r2 & 1) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        if (r2 <= 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        r5 = -r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        r2 = (r6 - r5) / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r2 != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        return (-r5) * (1 << r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x003c, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0035, code lost:
    
        r2 = r2 / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x002e, code lost:
    
        r2 = -(r5 / 2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int greatestCommonDivisor(int i3, int i16) {
        if (Math.abs(i3) <= 1 || Math.abs(i16) <= 1) {
            return 1;
        }
        if (i3 > 0) {
            i3 = -i3;
        }
        if (i16 > 0) {
            i16 = -i16;
        }
        int i17 = 0;
        while (true) {
            int i18 = i3 & 1;
            if (i18 != 0 || (i16 & 1) != 0 || i17 >= 31) {
                break;
            }
            i3 /= 2;
            i16 /= 2;
            i17++;
        }
        throw new ArithmeticException("overflow: gcd is 2^31");
    }

    private static int mulAndCheck(int i3, int i16) {
        long j3 = i3 * i16;
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new ArithmeticException("overflow: mul");
    }

    private static int mulPosAndCheck(int i3, int i16) {
        long j3 = i3 * i16;
        if (j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i3, int i16) {
        long j3 = i3 - i16;
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Fraction fraction = (Fraction) obj;
        if (this == fraction) {
            return 0;
        }
        int i3 = this.numerator;
        int i16 = fraction.numerator;
        if (i3 == i16 && this.denominator == fraction.denominator) {
            return 0;
        }
        long j3 = i3 * fraction.denominator;
        long j16 = i16 * this.denominator;
        if (j3 == j16) {
            return 0;
        }
        if (j3 < j16) {
            return -1;
        }
        return 1;
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction != null) {
            if (fraction.numerator != 0) {
                return multiplyBy(fraction.invert());
            }
            throw new ArithmeticException("The fraction to divide by must not be zero");
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.numerator / this.denominator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.denominator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((getNumerator() + 629) * 37) + getDenominator();
        }
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i3 = this.numerator;
        if (i3 != 0) {
            if (i3 != Integer.MIN_VALUE) {
                if (i3 < 0) {
                    return new Fraction(-this.denominator, -i3);
                }
                return new Fraction(this.denominator, i3);
            }
            throw new ArithmeticException("overflow: can't negate numerator");
        }
        throw new ArithmeticException("Unable to invert zero.");
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator / this.denominator;
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction != null) {
            int i3 = this.numerator;
            if (i3 != 0 && fraction.numerator != 0) {
                int greatestCommonDivisor = greatestCommonDivisor(i3, fraction.denominator);
                int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
                return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
            }
            return ZERO;
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public Fraction negate() {
        int i3 = this.numerator;
        if (i3 != Integer.MIN_VALUE) {
            return new Fraction(-i3, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i3) {
        if (i3 == 1) {
            return this;
        }
        if (i3 == 0) {
            return ONE;
        }
        if (i3 < 0) {
            if (i3 == Integer.MIN_VALUE) {
                return invert().pow(2).pow(-(i3 / 2));
            }
            return invert().pow(-i3);
        }
        Fraction multiplyBy = multiplyBy(this);
        if (i3 % 2 == 0) {
            return multiplyBy.pow(i3 / 2);
        }
        return multiplyBy.pow(i3 / 2).multiplyBy(this);
    }

    public Fraction reduce() {
        int i3 = this.numerator;
        if (i3 == 0) {
            Fraction fraction = ZERO;
            if (equals(fraction)) {
                return this;
            }
            return fraction;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i3), this.denominator);
        if (greatestCommonDivisor == 1) {
            return this;
        }
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i3 = this.numerator;
            if (i3 == 0) {
                this.toProperString = "0";
            } else {
                int i16 = this.denominator;
                if (i3 == i16) {
                    this.toProperString = "1";
                } else if (i3 == i16 * (-1)) {
                    this.toProperString = "-1";
                } else {
                    if (i3 > 0) {
                        i3 = -i3;
                    }
                    if (i3 < (-i16)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            this.toProperString = new StrBuilder(32).append(getProperWhole()).append(TokenParser.SP).append(properNumerator).append('/').append(getDenominator()).toString();
                        }
                    } else {
                        this.toProperString = new StrBuilder(32).append(getNumerator()).append('/').append(getDenominator()).toString();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = new StrBuilder(32).append(getNumerator()).append('/').append(getDenominator()).toString();
        }
        return this.toString;
    }

    public static Fraction getFraction(int i3, int i16, int i17) {
        if (i17 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i17 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        }
        if (i16 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        }
        long j3 = i3 < 0 ? (i3 * i17) - i16 : (i3 * i17) + i16;
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            return new Fraction((int) j3, i17);
        }
        throw new ArithmeticException("Numerator too large to represent as an Integer.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
    
        return getReducedFraction((r8 + (r4 * r10)) * r0, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Fraction getFraction(double d16) {
        int i3 = d16 < 0.0d ? -1 : 1;
        double abs = Math.abs(d16);
        if (abs <= 2.147483647E9d && !Double.isNaN(abs)) {
            int i16 = (int) abs;
            double d17 = abs - i16;
            int i17 = (int) d17;
            double d18 = d17 - i17;
            double d19 = d17;
            double d26 = Double.MAX_VALUE;
            int i18 = 1;
            int i19 = 1;
            double d27 = 1.0d;
            int i26 = 0;
            int i27 = 0;
            int i28 = 1;
            while (true) {
                int i29 = (int) (d27 / d18);
                double d28 = d27 - (i29 * d18);
                int i36 = (i17 * i28) + i26;
                int i37 = (i17 * i27) + i18;
                double d29 = d18;
                double d36 = d19;
                double abs2 = Math.abs(d36 - (i36 / i37));
                int i38 = i19 + 1;
                if (d26 <= abs2 || i37 > 10000 || i37 <= 0 || i38 >= 25) {
                    break;
                }
                d26 = abs2;
                d19 = d36;
                i18 = i27;
                i19 = i38;
                d18 = d28;
                i27 = i37;
                i17 = i29;
                i26 = i28;
                i28 = i36;
                d27 = d29;
            }
            throw new ArithmeticException("Unable to convert double to fraction");
        }
        throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
    }

    public static Fraction getFraction(String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                return getFraction(Double.parseDouble(str));
            }
            int indexOf = str.indexOf(32);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(47);
                if (indexOf2 >= 0) {
                    return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
                }
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
        }
        throw new IllegalArgumentException("The string must not be null");
    }
}
