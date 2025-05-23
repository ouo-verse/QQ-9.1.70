package org.apache.commons.lang.text;

import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.SystemUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StrBuilder implements Cloneable {
    static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    private String newLine;
    private String nullText;
    protected int size;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class StrBuilderTokenizer extends StrTokenizer {
        StrBuilderTokenizer() {
        }

        @Override // org.apache.commons.lang.text.StrTokenizer
        public String getContent() {
            String content = super.getContent();
            if (content == null) {
                return StrBuilder.this.toString();
            }
            return content;
        }

        @Override // org.apache.commons.lang.text.StrTokenizer
        protected List tokenize(char[] cArr, int i3, int i16) {
            if (cArr == null) {
                StrBuilder strBuilder = StrBuilder.this;
                return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
            }
            return super.tokenize(cArr, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class StrBuilderWriter extends Writer {
        StrBuilderWriter() {
        }

        @Override // java.io.Writer
        public void write(int i3) {
            StrBuilder.this.append((char) i3);
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i16) {
            StrBuilder.this.append(cArr, i3, i16);
        }

        @Override // java.io.Writer
        public void write(String str) {
            StrBuilder.this.append(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i3, int i16) {
            StrBuilder.this.append(str, i3, i16);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }

    public StrBuilder() {
        this(32);
    }

    private void deleteImpl(int i3, int i16, int i17) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i16, cArr, i3, this.size - i16);
        this.size -= i17;
    }

    private void replaceImpl(int i3, int i16, int i17, String str, int i18) {
        int i19 = (this.size - i17) + i18;
        if (i18 != i17) {
            ensureCapacity(i19);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i16, cArr, i3 + i18, this.size - i16);
            this.size = i19;
        }
        if (i18 > 0) {
            str.getChars(0, i18, this.buffer, i3);
        }
    }

    public StrBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        return append(obj.toString());
    }

    public StrBuilder appendAll(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                append(obj);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i3, char c16) {
        if (i3 > 0) {
            ensureCapacity(this.size + i3);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i3) {
                nullText.getChars(length - i3, length, this.buffer, this.size);
            } else {
                int i16 = i3 - length;
                for (int i17 = 0; i17 < i16; i17++) {
                    this.buffer[this.size + i17] = c16;
                }
                nullText.getChars(0, length, this.buffer, this.size + i16);
            }
            this.size += i3;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i3, char c16) {
        if (i3 > 0) {
            ensureCapacity(this.size + i3);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i3) {
                nullText.getChars(0, i3, this.buffer, this.size);
            } else {
                int i16 = i3 - length;
                nullText.getChars(0, length, this.buffer, this.size);
                for (int i17 = 0; i17 < i16; i17++) {
                    this.buffer[this.size + length + i17] = c16;
                }
            }
            this.size += i3;
        }
        return this;
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str == null) {
            append(SystemUtils.LINE_SEPARATOR);
            return this;
        }
        return append(str);
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        if (str == null) {
            return this;
        }
        return append(str);
    }

    public StrBuilder appendPadding(int i3, char c16) {
        if (i3 >= 0) {
            ensureCapacity(this.size + i3);
            for (int i16 = 0; i16 < i3; i16++) {
                char[] cArr = this.buffer;
                int i17 = this.size;
                this.size = i17 + 1;
                cArr[i17] = c16;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            if (str == null) {
                str = "";
            }
            append(objArr[0]);
            for (int i3 = 1; i3 < objArr.length; i3++) {
                append(str);
                append(objArr[i3]);
            }
        }
        return this;
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    public char charAt(int i3) {
        if (i3 >= 0 && i3 < length()) {
            return this.buffer[i3];
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        StrBuilder strBuilder = (StrBuilder) super.clone();
        char[] cArr = new char[this.buffer.length];
        strBuilder.buffer = cArr;
        char[] cArr2 = this.buffer;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        return strBuilder;
    }

    public boolean contains(char c16) {
        char[] cArr = this.buffer;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (cArr[i3] == c16) {
                return true;
            }
        }
        return false;
    }

    public StrBuilder delete(int i3, int i16) {
        int validateRange = validateRange(i3, i16);
        int i17 = validateRange - i3;
        if (i17 > 0) {
            deleteImpl(i3, validateRange, i17);
        }
        return this;
    }

    public StrBuilder deleteAll(char c16) {
        int i3 = 0;
        while (i3 < this.size) {
            if (this.buffer[i3] == c16) {
                int i16 = i3;
                do {
                    i16++;
                    if (i16 >= this.size) {
                        break;
                    }
                } while (this.buffer[i16] == c16);
                int i17 = i16 - i3;
                deleteImpl(i3, i16, i17);
                i3 = i16 - i17;
            }
            i3++;
        }
        return this;
    }

    public StrBuilder deleteCharAt(int i3) {
        if (i3 >= 0 && i3 < this.size) {
            deleteImpl(i3, i3 + 1, 1);
            return this;
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    public StrBuilder deleteFirst(char c16) {
        int i3 = 0;
        while (true) {
            if (i3 >= this.size) {
                break;
            }
            if (this.buffer[i3] == c16) {
                deleteImpl(i3, i3 + 1, 1);
                break;
            }
            i3++;
        }
        return this;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i3 = this.size;
        if (length > i3) {
            return false;
        }
        int i16 = i3 - length;
        int i17 = 0;
        while (i17 < length) {
            if (this.buffer[i16] != str.charAt(i17)) {
                return false;
            }
            i17++;
            i16++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(int i3) {
        char[] cArr = this.buffer;
        if (i3 > cArr.length) {
            char[] cArr2 = new char[i3 * 2];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public boolean equals(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i3 = this.size;
        if (i3 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (cArr[i16] != cArr2[i16]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i3 = this.size;
        if (i3 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            char c16 = cArr[i16];
            char c17 = cArr2[i16];
            if (c16 != c17 && Character.toUpperCase(c16) != Character.toUpperCase(c17)) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i3 = 0;
        for (int i16 = this.size - 1; i16 >= 0; i16--) {
            i3 = (i3 * 31) + cArr[i16];
        }
        return i3;
    }

    public int indexOf(char c16) {
        return indexOf(c16, 0);
    }

    public StrBuilder insert(int i3, Object obj) {
        if (obj == null) {
            return insert(i3, this.nullText);
        }
        return insert(i3, obj.toString());
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(char c16) {
        return lastIndexOf(c16, this.size - 1);
    }

    public String leftString(int i3) {
        if (i3 <= 0) {
            return "";
        }
        int i16 = this.size;
        if (i3 >= i16) {
            return new String(this.buffer, 0, i16);
        }
        return new String(this.buffer, 0, i3);
    }

    public int length() {
        return this.size;
    }

    public String midString(int i3, int i16) {
        int i17;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > 0 && i3 < (i17 = this.size)) {
            if (i17 <= i3 + i16) {
                return new String(this.buffer, i3, i17 - i3);
            }
            return new String(this.buffer, i3, i16);
        }
        return "";
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            char[] cArr = this.buffer;
            char[] cArr2 = new char[length()];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public StrBuilder replace(int i3, int i16, String str) {
        int validateRange = validateRange(i3, i16);
        replaceImpl(i3, validateRange, validateRange - i3, str, str == null ? 0 : str.length());
        return this;
    }

    public StrBuilder replaceAll(char c16, char c17) {
        if (c16 != c17) {
            for (int i3 = 0; i3 < this.size; i3++) {
                char[] cArr = this.buffer;
                if (cArr[i3] == c16) {
                    cArr[i3] = c17;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c16, char c17) {
        if (c16 != c17) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.size) {
                    break;
                }
                char[] cArr = this.buffer;
                if (cArr[i3] == c16) {
                    cArr[i3] = c17;
                    break;
                }
                i3++;
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i3 = this.size;
        if (i3 == 0) {
            return this;
        }
        int i16 = i3 / 2;
        char[] cArr = this.buffer;
        int i17 = i3 - 1;
        int i18 = 0;
        while (i18 < i16) {
            char c16 = cArr[i18];
            cArr[i18] = cArr[i17];
            cArr[i17] = c16;
            i18++;
            i17--;
        }
        return this;
    }

    public String rightString(int i3) {
        if (i3 <= 0) {
            return "";
        }
        int i16 = this.size;
        if (i3 >= i16) {
            return new String(this.buffer, 0, i16);
        }
        return new String(this.buffer, i16 - i3, i3);
    }

    public StrBuilder setCharAt(int i3, char c16) {
        if (i3 >= 0 && i3 < length()) {
            this.buffer[i3] = c16;
            return this;
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    public StrBuilder setLength(int i3) {
        if (i3 >= 0) {
            int i16 = this.size;
            if (i3 < i16) {
                this.size = i3;
            } else if (i3 > i16) {
                ensureCapacity(i3);
                this.size = i3;
                for (int i17 = this.size; i17 < i3; i17++) {
                    this.buffer[i17] = 0;
                }
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (str != null && str.length() == 0) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (this.buffer[i3] != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public String substring(int i3) {
        return substring(i3, this.size);
    }

    public char[] toCharArray() {
        int i3 = this.size;
        if (i3 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[i3];
        System.arraycopy(this.buffer, 0, cArr, 0, i3);
        return cArr;
    }

    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StrBuilder trim() {
        int i3 = this.size;
        if (i3 == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i16 = 0;
        while (i16 < i3 && cArr[i16] <= ' ') {
            i16++;
        }
        while (i16 < i3 && cArr[i3 - 1] <= ' ') {
            i3--;
        }
        int i17 = this.size;
        if (i3 < i17) {
            delete(i3, i17);
        }
        if (i16 > 0) {
            delete(0, i16);
        }
        return this;
    }

    protected void validateIndex(int i3) {
        if (i3 >= 0 && i3 <= this.size) {
        } else {
            throw new StringIndexOutOfBoundsException(i3);
        }
    }

    protected int validateRange(int i3, int i16) {
        if (i3 >= 0) {
            int i17 = this.size;
            if (i16 > i17) {
                i16 = i17;
            }
            if (i3 <= i16) {
                return i16;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class StrBuilderReader extends Reader {
        private int mark;
        private int pos;

        StrBuilderReader() {
        }

        @Override // java.io.Reader
        public void mark(int i3) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.Reader
        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i3 = this.pos;
            this.pos = i3 + 1;
            return strBuilder.charAt(i3);
        }

        @Override // java.io.Reader
        public boolean ready() {
            if (this.pos < StrBuilder.this.size()) {
                return true;
            }
            return false;
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public long skip(long j3) {
            if (this.pos + j3 > StrBuilder.this.size()) {
                j3 = StrBuilder.this.size() - this.pos;
            }
            if (j3 < 0) {
                return 0L;
            }
            this.pos = (int) (this.pos + j3);
            return j3;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i3, int i16) {
            int i17;
            if (i3 < 0 || i16 < 0 || i3 > cArr.length || (i17 = i3 + i16) > cArr.length || i17 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i16 == 0) {
                return 0;
            }
            if (this.pos >= StrBuilder.this.size()) {
                return -1;
            }
            if (this.pos + i16 > StrBuilder.this.size()) {
                i16 = StrBuilder.this.size() - this.pos;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i18 = this.pos;
            strBuilder.getChars(i18, i18 + i16, cArr, i3);
            this.pos += i16;
            return i16;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public StrBuilder(int i3) {
        this.buffer = new char[i3 <= 0 ? 32 : i3];
    }

    public StrBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public int indexOf(char c16, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (i3 < this.size) {
            if (cArr[i3] == c16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int lastIndexOf(char c16, int i3) {
        int i16 = this.size;
        if (i3 >= i16) {
            i3 = i16 - 1;
        }
        if (i3 < 0) {
            return -1;
        }
        while (i3 >= 0) {
            if (this.buffer[i3] == c16) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public String substring(int i3, int i16) {
        return new String(this.buffer, i3, validateRange(i3, i16) - i3);
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder appendln(String str, int i3, int i16) {
        return append(str, i3, i16).appendNewLine();
    }

    public StrBuilder insert(int i3, String str) {
        validateIndex(i3);
        if (str == null) {
            str = this.nullText;
        }
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int i16 = this.size + length;
            ensureCapacity(i16);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i3, cArr, i3 + length, this.size - i3);
            this.size = i16;
            str.getChars(0, length, this.buffer, i3);
        }
        return this;
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
        } else {
            this.buffer = new char[str.length() + 32];
            append(str);
        }
    }

    public StrBuilder appendAll(Collection collection) {
        if (collection != null && collection.size() > 0) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c16) {
        if (size() > 0) {
            append(c16);
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public StrBuilder deleteFirst(String str) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(indexOf, indexOf + length, length);
        }
        return this;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i3, int i16, int i17) {
        return replaceImpl(strMatcher, str, i3, validateRange(i3, i16), i17);
    }

    public StrBuilder replaceAll(String str, String str2) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int length2 = str2 == null ? 0 : str2.length();
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                replaceImpl(indexOf, indexOf + length, length, str2, length2);
                indexOf = indexOf(str, indexOf + length2);
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            replaceImpl(indexOf, indexOf + length, length, str2, str2 != null ? str2.length() : 0);
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i3, int i16) {
        return append(stringBuffer, i3, i16).appendNewLine();
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StrBuilder) {
            return equals((StrBuilder) obj);
        }
        return false;
    }

    public void getChars(int i3, int i16, char[] cArr, int i17) {
        if (i3 >= 0) {
            if (i16 < 0 || i16 > length()) {
                throw new StringIndexOutOfBoundsException(i16);
            }
            if (i3 <= i16) {
                System.arraycopy(this.buffer, i3, cArr, i17, i16 - i3);
                return;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r9 = r9 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int lastIndexOf(String str, int i3) {
        int i16 = this.size;
        if (i3 >= i16) {
            i3 = i16 - 1;
        }
        if (str != null && i3 >= 0) {
            int length = str.length();
            if (length > 0 && length <= this.size) {
                if (length == 1) {
                    return lastIndexOf(str.charAt(0), i3);
                }
                int i17 = (i3 - length) + 1;
                while (i17 >= 0) {
                    for (int i18 = 0; i18 < length; i18++) {
                        if (str.charAt(i18) != this.buffer[i17 + i18]) {
                            break;
                        }
                    }
                    return i17;
                }
            }
            if (length == 0) {
                return i3;
            }
        }
        return -1;
    }

    public char[] toCharArray(int i3, int i16) {
        int validateRange = validateRange(i3, i16) - i3;
        if (validateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[validateRange];
        System.arraycopy(this.buffer, i3, cArr, 0, validateRange);
        return cArr;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i3, int i16, int i17) {
        if (strMatcher != null && this.size != 0) {
            int length = str == null ? 0 : str.length();
            char[] cArr = this.buffer;
            int i18 = i3;
            while (i18 < i16 && i17 != 0) {
                int isMatch = strMatcher.isMatch(cArr, i18, i3, i16);
                if (isMatch > 0) {
                    replaceImpl(i18, i18 + isMatch, isMatch, str, length);
                    i16 = (i16 - isMatch) + length;
                    i18 = (i18 + length) - 1;
                    if (i17 > 0) {
                        i17--;
                    }
                }
                i18++;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c16, char c17) {
        if (size() > 0) {
            append(c16);
        } else {
            append(c17);
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Collection collection, String str) {
        if (collection != null && collection.size() > 0) {
            if (str == null) {
                str = "";
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(str);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
                indexOf = indexOf(str, indexOf);
            }
        }
        return this;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i3, int i16) {
        return append(strBuilder, i3, i16).appendNewLine();
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int indexOf(String str, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (str != null && i3 < this.size) {
            int length = str.length();
            if (length == 1) {
                return indexOf(str.charAt(0), i3);
            }
            if (length == 0) {
                return i3;
            }
            int i16 = this.size;
            if (length > i16) {
                return -1;
            }
            char[] cArr = this.buffer;
            int i17 = (i16 - length) + 1;
            while (i3 < i17) {
                for (int i18 = 0; i18 < length; i18++) {
                    if (str.charAt(i18) != cArr[i3 + i18]) {
                        break;
                    }
                }
                return i3;
            }
        }
        return -1;
    }

    public StrBuilder appendAll(Iterator it) {
        if (it != null) {
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(int i3, int i16, char c16) {
        return appendFixedWidthPadLeft(String.valueOf(i3), i16, c16);
    }

    public StrBuilder appendFixedWidthPadRight(int i3, int i16, char c16) {
        return appendFixedWidthPadRight(String.valueOf(i3), i16, c16);
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    public StrBuilder append(String str, int i3, int i16) {
        int i17;
        if (str == null) {
            return appendNull();
        }
        if (i3 >= 0 && i3 <= str.length()) {
            if (i16 < 0 || (i17 = i3 + i16) > str.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i16 > 0) {
                int length = length();
                ensureCapacity(length + i16);
                str.getChars(i3, i17, this.buffer, length);
                this.size += i16;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder appendSeparator(String str, int i3) {
        if (str != null && i3 > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(char[] cArr, int i3, int i16) {
        return append(cArr, i3, i16).appendNewLine();
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder appendSeparator(char c16, int i3) {
        if (i3 > 0) {
            append(c16);
        }
        return this;
    }

    public StrBuilder appendln(boolean z16) {
        return append(z16).appendNewLine();
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, -1);
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public StrBuilder appendln(char c16) {
        return append(c16).appendNewLine();
    }

    public StrBuilder insert(int i3, char[] cArr) {
        validateIndex(i3);
        if (cArr == null) {
            return insert(i3, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i3, cArr2, i3 + length, this.size - i3);
            System.arraycopy(cArr, 0, this.buffer, i3, length);
            this.size += length;
        }
        return this;
    }

    public int lastIndexOf(StrMatcher strMatcher, int i3) {
        int i16 = this.size;
        if (i3 >= i16) {
            i3 = i16 - 1;
        }
        if (strMatcher != null && i3 >= 0) {
            char[] cArr = this.buffer;
            int i17 = i3 + 1;
            while (i3 >= 0) {
                if (strMatcher.isMatch(cArr, i3, 0, i17) > 0) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    public StrBuilder appendWithSeparators(Iterator it, String str) {
        if (it != null) {
            if (str == null) {
                str = "";
            }
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(str);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(int i3) {
        return append(i3).appendNewLine();
    }

    public StrBuilder appendln(long j3) {
        return append(j3).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public StrBuilder appendln(float f16) {
        return append(f16).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher, int i3) {
        int i16;
        if (i3 < 0) {
            i3 = 0;
        }
        if (strMatcher != null && i3 < (i16 = this.size)) {
            char[] cArr = this.buffer;
            for (int i17 = i3; i17 < i16; i17++) {
                if (strMatcher.isMatch(cArr, i17, i3, i16) > 0) {
                    return i17;
                }
            }
        }
        return -1;
    }

    public StrBuilder appendln(double d16) {
        return append(d16).appendNewLine();
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i3, char[] cArr, int i16, int i17) {
        validateIndex(i3);
        if (cArr == null) {
            return insert(i3, this.nullText);
        }
        if (i16 >= 0 && i16 <= cArr.length) {
            if (i17 < 0 || i16 + i17 > cArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid length: ");
                stringBuffer.append(i17);
                throw new StringIndexOutOfBoundsException(stringBuffer.toString());
            }
            if (i17 > 0) {
                ensureCapacity(this.size + i17);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i3, cArr2, i3 + i17, this.size - i3);
                System.arraycopy(cArr, i16, this.buffer, i3, i17);
                this.size += i17;
            }
            return this;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Invalid offset: ");
        stringBuffer2.append(i16);
        throw new StringIndexOutOfBoundsException(stringBuffer2.toString());
    }

    public StrBuilder append(StringBuffer stringBuffer, int i3, int i16) {
        int i17;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i3 >= 0 && i3 <= stringBuffer.length()) {
            if (i16 < 0 || (i17 = i3 + i16) > stringBuffer.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i16 > 0) {
                int length = length();
                ensureCapacity(length + i16);
                stringBuffer.getChars(i3, i17, this.buffer, length);
                this.size += i16;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder insert(int i3, boolean z16) {
        validateIndex(i3);
        if (z16) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i3, cArr, i3 + 4, this.size - i3);
            char[] cArr2 = this.buffer;
            int i16 = i3 + 1;
            cArr2[i3] = 't';
            int i17 = i16 + 1;
            cArr2[i16] = 'r';
            cArr2[i17] = 'u';
            cArr2[i17 + 1] = 'e';
            this.size += 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy(cArr3, i3, cArr3, i3 + 5, this.size - i3);
            char[] cArr4 = this.buffer;
            int i18 = i3 + 1;
            cArr4[i3] = 'f';
            int i19 = i18 + 1;
            cArr4[i18] = 'a';
            int i26 = i19 + 1;
            cArr4[i19] = 'l';
            cArr4[i26] = 's';
            cArr4[i26 + 1] = 'e';
            this.size += 5;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i3, int i16) {
        int i17;
        if (strBuilder == null) {
            return appendNull();
        }
        if (i3 >= 0 && i3 <= strBuilder.length()) {
            if (i16 < 0 || (i17 = i3 + i16) > strBuilder.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i16 > 0) {
                int length = length();
                ensureCapacity(length + i16);
                strBuilder.getChars(i3, i17, this.buffer, length);
                this.size += i16;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder insert(int i3, char c16) {
        validateIndex(i3);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i3, cArr, i3 + 1, this.size - i3);
        this.buffer[i3] = c16;
        this.size++;
        return this;
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i3, int i16) {
        return insert(i3, String.valueOf(i16));
    }

    public StrBuilder insert(int i3, long j3) {
        return insert(i3, String.valueOf(j3));
    }

    public StrBuilder insert(int i3, float f16) {
        return insert(i3, String.valueOf(f16));
    }

    public StrBuilder insert(int i3, double d16) {
        return insert(i3, String.valueOf(d16));
    }

    public StrBuilder append(char[] cArr, int i3, int i16) {
        if (cArr == null) {
            return appendNull();
        }
        if (i3 >= 0 && i3 <= cArr.length) {
            if (i16 < 0 || i3 + i16 > cArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid length: ");
                stringBuffer.append(i16);
                throw new StringIndexOutOfBoundsException(stringBuffer.toString());
            }
            if (i16 > 0) {
                int length = length();
                ensureCapacity(length + i16);
                System.arraycopy(cArr, i3, this.buffer, length, i16);
                this.size += i16;
            }
            return this;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Invalid startIndex: ");
        stringBuffer2.append(i16);
        throw new StringIndexOutOfBoundsException(stringBuffer2.toString());
    }

    public StrBuilder append(boolean z16) {
        if (z16) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i3 = this.size;
            int i16 = i3 + 1;
            cArr[i3] = 't';
            int i17 = i16 + 1;
            cArr[i16] = 'r';
            int i18 = i17 + 1;
            cArr[i17] = 'u';
            this.size = i18 + 1;
            cArr[i18] = 'e';
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i19 = this.size;
            int i26 = i19 + 1;
            cArr2[i19] = 'f';
            int i27 = i26 + 1;
            cArr2[i26] = 'a';
            int i28 = i27 + 1;
            cArr2[i27] = 'l';
            int i29 = i28 + 1;
            cArr2[i28] = 's';
            this.size = i29 + 1;
            cArr2[i29] = 'e';
        }
        return this;
    }

    public StrBuilder append(char c16) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i3 = this.size;
        this.size = i3 + 1;
        cArr[i3] = c16;
        return this;
    }

    public StrBuilder append(int i3) {
        return append(String.valueOf(i3));
    }

    public StrBuilder append(long j3) {
        return append(String.valueOf(j3));
    }

    public StrBuilder append(float f16) {
        return append(String.valueOf(f16));
    }

    public StrBuilder append(double d16) {
        return append(String.valueOf(d16));
    }
}
