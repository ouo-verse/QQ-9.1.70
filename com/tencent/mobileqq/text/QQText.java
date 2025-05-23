package com.tencent.mobileqq.text;

import android.os.Build;
import android.os.SystemClock;
import android.text.GetChars;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.text.processor.ISpanCallback;
import com.tencent.mobileqq.text.processor.ISpanProcessor;
import com.tencent.mobileqq.text.processor.QQEmoticonSpanProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQText extends AbsQQText implements GetChars, Cloneable, ISpanCallback {
    static IPatchRedirector $redirector_ = null;
    private static final int COLUMNS = 3;
    private static final int END = 1;
    private static final int FLAGS = 2;
    public static final boolean IS_FXXKED_MTK;
    public static Spannable.Factory SPANNABLE_FACTORY = null;
    private static final int START = 0;
    public static final String TAG = "QQText";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQViewLibrary/Inject_QQView_QQTextSpanProcessor.yml", version = 1)
    public static ArrayList<ISpanProcessor> sISpanProcessorClassList;
    private static ArrayList sISpanProcessorClassList_AutoGenClazzList_QAutoInjectTransform;
    private GrabParams mGrabParams;
    public String mSource;
    public int mSpanCount;
    private int[] mSpanData;
    private ISpanRefreshCallback mSpanRefreshCallback;
    public Object[] mSpans;
    protected String mText;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Spannable.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Spannable.Factory
        public Spannable newSpannable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Spannable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof QQText) {
                try {
                    return (QQText) ((QQText) charSequence).clone();
                } catch (CloneNotSupportedException unused) {
                }
            }
            return super.newSpannable(charSequence);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sISpanProcessorClassList_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.text.processor.c.class);
        sISpanProcessorClassList_AutoGenClazzList_QAutoInjectTransform.add(QQEmoticonSpanProcessor.class);
        sISpanProcessorClassList_AutoGenClazzList_QAutoInjectTransform.add(com.tencent.qqnt.aio.nick.b.class);
        sISpanProcessorClassList_AutoGenClazzList_QAutoInjectTransform.add(jq0.a.class);
        sISpanProcessorClassList = new ArrayList<>();
        SPANNABLE_FACTORY = new a();
        boolean z16 = false;
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Class cls3 = Boolean.TYPE;
            StaticLayout.class.getDeclaredMethod("generate2", CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, cls2, cls2, cls3, cls3);
            z16 = true;
        } catch (NoSuchMethodException unused) {
        }
        String str = Build.MANUFACTURER;
        IS_FXXKED_MTK = z16;
        initProcessor();
    }

    public QQText(CharSequence charSequence, int i3) {
        this(charSequence, i3, 32);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) charSequence, i3);
    }

    private void checkRange(String str, int i3, int i16) {
        if (i16 >= i3) {
            int length = length();
            if (i3 <= length && i16 <= length) {
                if (i3 >= 0 && i16 >= 0) {
                    return;
                }
                throw new IndexOutOfBoundsException(str + " " + region(i3, i16) + " starts before 0");
            }
            throw new IndexOutOfBoundsException(str + " " + region(i3, i16) + " ends beyond length " + length);
        }
        throw new IndexOutOfBoundsException(str + " " + region(i3, i16) + " has end before start");
    }

    private static int idealIntArraySize(int i3) {
        int i16 = i3 * 4;
        int i17 = 4;
        while (true) {
            if (i17 >= 32) {
                break;
            }
            int i18 = (1 << i17) - 12;
            if (i16 <= i18) {
                i16 = i18;
                break;
            }
            i17++;
        }
        return i16 / 4;
    }

    @QAutoInitMethod
    private static void initProcessor() {
        com.tencent.mobileqq.qroute.utils.b.c(sISpanProcessorClassList_AutoGenClazzList_QAutoInjectTransform, sISpanProcessorClassList);
        if (sISpanProcessorClassList.size() > 0) {
            if (QLog.isColorLevel()) {
                Iterator<ISpanProcessor> it = sISpanProcessorClassList.iterator();
                while (it.hasNext()) {
                    QLog.i(TAG, 2, "inject name:" + it.next().getClass());
                }
                return;
            }
            return;
        }
        QLog.i(TAG, 2, "sISpanProcessorClassList inject failed !");
    }

    public static final boolean isFxxkingCall() {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
        if (("android.text.StaticLayout".equals(stackTraceElement.getClassName()) && "generate2".equals(stackTraceElement.getMethodName())) || ("android.text.Layout".equals(stackTraceElement.getClassName()) && "expandTab".equals(stackTraceElement.getMethodName()))) {
            return true;
        }
        return false;
    }

    private static String region(int i3, int i16) {
        return "(" + i3 + " ... " + i16 + ")";
    }

    private void sendSpanAdded(Object obj, int i3, int i16) {
        for (SpanWatcher spanWatcher : (SpanWatcher[]) getSpans(i3, i16, SpanWatcher.class)) {
            spanWatcher.onSpanAdded(this, obj, i3, i16);
        }
    }

    private void sendSpanChanged(Object obj, int i3, int i16, int i17, int i18) {
        for (SpanWatcher spanWatcher : (SpanWatcher[]) getSpans(Math.min(i3, i17), Math.max(i16, i18), SpanWatcher.class)) {
            spanWatcher.onSpanChanged(this, obj, i3, i16, i17, i18);
        }
    }

    private void sendSpanRemoved(Object obj, int i3, int i16) {
        for (SpanWatcher spanWatcher : (SpanWatcher[]) getSpans(i3, i16, SpanWatcher.class)) {
            spanWatcher.onSpanRemoved(this, obj, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanCallback
    public <T> T[] acquireSpans(int i3, int i16, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (T[]) ((Object[]) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), cls));
        }
        return (T[]) getSpans(i3, i16, cls);
    }

    public void addSpan(Object obj, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        int i18 = this.mSpanCount;
        if (i18 + 1 >= this.mSpans.length) {
            int idealIntArraySize = idealIntArraySize(i18 + 1);
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr = new int[idealIntArraySize * 3];
            System.arraycopy(this.mSpans, 0, objArr, 0, this.mSpanCount);
            System.arraycopy(this.mSpanData, 0, iArr, 0, this.mSpanCount * 3);
            this.mSpans = objArr;
            this.mSpanData = iArr;
        }
        ISpanRefreshCallback iSpanRefreshCallback = this.mSpanRefreshCallback;
        if (iSpanRefreshCallback != null && (obj instanceof IEmoticonSpanRefreshCallback)) {
            ((IEmoticonSpanRefreshCallback) obj).setSpanRefreshCallback(iSpanRefreshCallback);
        }
        Object[] objArr2 = this.mSpans;
        int i19 = this.mSpanCount;
        objArr2[i19] = obj;
        int[] iArr2 = this.mSpanData;
        iArr2[(i19 * 3) + 0] = i3;
        iArr2[(i19 * 3) + 1] = i16;
        iArr2[(i19 * 3) + 2] = i17;
        this.mSpanCount = i19 + 1;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Character) iPatchRedirector.redirect((short) 15, (Object) this, i3)).charValue();
        }
        if (i3 >= 0 && i3 <= length()) {
            return this.mText.charAt(i3);
        }
        return (char) 0;
    }

    protected Object clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return iPatchRedirector.redirect((short) 30, (Object) this);
        }
        QQText qQText = (QQText) super.clone();
        int[] iArr = new int[this.mSpanData.length];
        qQText.mSpanData = iArr;
        int[] iArr2 = this.mSpanData;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        Object[] objArr = new Object[this.mSpans.length];
        qQText.mSpans = objArr;
        Object[] objArr2 = this.mSpans;
        System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
        return qQText;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof QQText) {
            return this.mSource.equals(((QQText) obj).mSource);
        }
        return false;
    }

    @Override // android.text.GetChars
    public final void getChars(int i3, int i16, char[] cArr, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), cArr, Integer.valueOf(i17));
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int length = length();
        if (i16 > length) {
            i16 = length;
        }
        this.mText.getChars(i3, i16, cArr, i17);
    }

    public int getEmojiSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.mGrabParams.emoSize;
    }

    public int[] getSpanData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (int[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mSpanData;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, obj)).intValue();
        }
        int i3 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (objArr[i16] == obj) {
                return iArr[(i16 * 3) + 1];
            }
        }
        return -1;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, obj)).intValue();
        }
        int i3 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (objArr[i16] == obj) {
                return iArr[(i16 * 3) + 2];
            }
        }
        return 0;
    }

    protected ArrayList<ISpanProcessor> getSpanProcessors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return sISpanProcessorClassList;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, obj)).intValue();
        }
        int i3 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (objArr[i16] == obj) {
                return iArr[(i16 * 3) + 0];
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.Spanned
    public <T> T[] getSpans(int i3, int i16, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (T[]) ((Object[]) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), cls));
        }
        int i18 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        Object[] objArr2 = (T[]) null;
        if (cls == null) {
            return null;
        }
        int i19 = 0;
        int i26 = 0;
        Object obj = null;
        while (i19 < i18) {
            if (cls.isInstance(objArr[i19])) {
                int i27 = i19 * 3;
                int i28 = iArr[i27 + 0];
                int i29 = iArr[i27 + 1];
                if (i28 <= i16 && i29 >= i3 && (i28 == i29 || i3 == i16 || (i28 != i16 && i29 != i3))) {
                    if (i26 == 0) {
                        obj = objArr[i19];
                    } else {
                        if (i26 == i17) {
                            objArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, (i18 - i19) + i17));
                            objArr2[0] = obj;
                        }
                        int i36 = iArr[i27 + 2] & ITVKAsset.VOD_ASSET_MASK_BIT;
                        if (i36 != 0) {
                            int i37 = 0;
                            while (i37 < i26 && i36 <= (getSpanFlags(objArr2[i37]) & ITVKAsset.VOD_ASSET_MASK_BIT)) {
                                i37++;
                            }
                            System.arraycopy(objArr2, i37, objArr2, i37 + 1, i26 - i37);
                            objArr2[i37] = objArr[i19];
                        } else {
                            objArr2[i26] = objArr[i19];
                            i26++;
                        }
                    }
                    i26++;
                }
            }
            i19++;
            i17 = 1;
        }
        if (i26 == 0) {
            return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
        }
        if (i26 == 1) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 1));
            if (tArr == 0) {
                return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
            }
            tArr[0] = obj;
            return tArr;
        }
        if (i26 == objArr2.length) {
            return (T[]) objArr2;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i26));
        System.arraycopy(objArr2, 0, tArr2, 0, i26);
        return tArr2;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        String str = this.mText;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i16, Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16), cls)).intValue();
        }
        int i17 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        if (cls == null) {
            cls = Object.class;
        }
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = i18 * 3;
            int i26 = iArr[i19 + 0];
            int i27 = iArr[i19 + 1];
            if (i26 > i3 && i26 < i16 && cls.isInstance(objArr[i18])) {
                i16 = i26;
            }
            if (i27 > i3 && i27 < i16 && cls.isInstance(objArr[i18])) {
                i16 = i27;
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseLinkSpan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, obj);
            return;
        }
        int i3 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (objArr[i16] == obj) {
                int i17 = i16 * 3;
                int i18 = iArr[i17 + 0];
                int i19 = iArr[i17 + 1];
                int i26 = i16 + 1;
                int i27 = i3 - i26;
                System.arraycopy(objArr, i26, objArr, i16, i27);
                System.arraycopy(iArr, i26 * 3, iArr, i17, i27 * 3);
                this.mSpanCount--;
                sendSpanRemoved(obj, i18, i19);
                return;
            }
        }
    }

    public void setBizSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            if (this.mSpans == null) {
                return;
            }
            Iterator<ISpanProcessor> it = sISpanProcessorClassList.iterator();
            while (it.hasNext()) {
                it.next().setBizSrc(str, this.mSpans);
            }
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i3, int i16, int i17) {
        char charAt;
        char charAt2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        checkRange("setSpan", i3, i16);
        if ((i17 & 51) == 51) {
            if (i3 != 0 && i3 != length() && (charAt2 = charAt(i3 - 1)) != '\n') {
                throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + i3 + " follows " + charAt2 + ")");
            }
            if (i16 != 0 && i16 != length() && (charAt = charAt(i16 - 1)) != '\n') {
                throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + i16 + " follows " + charAt + ")");
            }
        }
        int i18 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        for (int i19 = 0; i19 < i18; i19++) {
            if (objArr[i19] == obj) {
                int i26 = i19 * 3;
                int i27 = i26 + 0;
                int i28 = iArr[i27];
                int i29 = i26 + 1;
                int i36 = iArr[i29];
                iArr[i27] = i3;
                iArr[i29] = i16;
                iArr[i26 + 2] = i17;
                sendSpanChanged(obj, i28, i36, i3, i16);
                return;
            }
        }
        int i37 = this.mSpanCount;
        if (i37 + 1 >= this.mSpans.length) {
            int idealIntArraySize = idealIntArraySize(i37 + 1);
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = new int[idealIntArraySize * 3];
            System.arraycopy(this.mSpans, 0, objArr2, 0, this.mSpanCount);
            System.arraycopy(this.mSpanData, 0, iArr2, 0, this.mSpanCount * 3);
            this.mSpans = objArr2;
            this.mSpanData = iArr2;
        }
        Object[] objArr3 = this.mSpans;
        int i38 = this.mSpanCount;
        objArr3[i38] = obj;
        int[] iArr3 = this.mSpanData;
        iArr3[(i38 * 3) + 0] = i3;
        iArr3[(i38 * 3) + 1] = i16;
        iArr3[(i38 * 3) + 2] = i17;
        this.mSpanCount = i38 + 1;
        sendSpanAdded(obj, i3, i16);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (CharSequence) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 < 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        int length = length();
        if (i16 > length) {
            i18 = length;
        } else {
            i18 = i16;
        }
        if (IS_FXXKED_MTK && isFxxkingCall()) {
            return this.mText.subSequence(i17, i18);
        }
        if (Build.VERSION.SDK_INT >= 26 && i17 == 0 && i18 == length()) {
            return this;
        }
        String str = this.mText;
        GrabParams grabParams = this.mGrabParams;
        return new QQText(str, i17, i18, grabParams.flag, grabParams.emoSize, grabParams.uinType, grabParams.message);
    }

    public String toPlainText(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return toPlainText(z16 ? 2 : 3);
        }
        return (String) iPatchRedirector.redirect((short) 26, (Object) this, z16);
    }

    public String toPurePlainText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer(this.mText);
        int i3 = 0;
        for (int i16 = 0; i16 < this.mSpanCount; i16++) {
            Object obj = this.mSpans[i16];
            Iterator<ISpanProcessor> it = getSpanProcessors().iterator();
            while (true) {
                if (it.hasNext()) {
                    ISpanProcessor next = it.next();
                    if (next.matchPlain(obj)) {
                        int[] iArr = this.mSpanData;
                        int i17 = i16 * 3;
                        i3 += next.doPlain(obj, iArr[i17 + 0] + i3, iArr[i17 + 1] + i3, 1, stringBuffer);
                        break;
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpannableString toSpanableString() {
        SpannableString spannableString = new SpannableString(this.mText);
        android.text.TextUtils.copySpansFrom(this, 0, length(), Object.class, spannableString, 0);
        return spannableString;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (IS_FXXKED_MTK && isFxxkingCall()) {
            return this.mText;
        }
        return this.mSource;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (r5 != r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        return r7.mSource;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String trim() {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        char[] charArray = this.mSource.toCharArray();
        int length = this.mSource.length() - 1;
        int i3 = 0;
        while (i3 <= length && (c16 = charArray[i3]) <= ' ' && c16 != 20) {
            i3++;
        }
        int i16 = length;
        while (i16 >= i3 && charArray[i16] <= ' ' && (i16 == 0 || charArray[i16 - 1] != 20)) {
            i16--;
        }
        return this.mSource.substring(i3, i16 + 1);
    }

    public QQText(CharSequence charSequence, int i3, int i16) {
        this(charSequence, 0, charSequence == null ? 0 : charSequence.length(), i3, i16, -1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.text.AbsQQText
    public QQText append(String str, boolean z16, int... iArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QQText) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16), iArr);
        }
        QQText qQText = new QQText("", 0);
        qQText.mGrabParams = this.mGrabParams;
        qQText.mSpanCount = this.mSpanCount;
        int[] iArr2 = new int[this.mSpanData.length];
        qQText.mSpanData = iArr2;
        int[] iArr3 = this.mSpanData;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        Object[] objArr = new Object[this.mSpans.length];
        qQText.mSpans = objArr;
        Object[] objArr2 = this.mSpans;
        System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
        if (iArr.length >= 3) {
            if (iArr[2] == 1) {
                i3 = this.mGrabParams.flag;
            }
            i3 = 0;
        } else {
            if (iArr.length >= 2) {
                i3 = iArr[0];
            }
            i3 = 0;
        }
        if (z16) {
            qQText.mSource = str + this.mSource;
            qQText.mText = str + this.mText;
            int length = str.length();
            for (int i16 = 0; i16 < qQText.mSpans.length; i16++) {
                int[] iArr4 = qQText.mSpanData;
                int i17 = i16 * 3;
                int i18 = i17 + 0;
                int[] iArr5 = this.mSpanData;
                iArr4[i18] = iArr5[i18] + length;
                int i19 = i17 + 1;
                iArr4[i19] = iArr5[i19] + length;
            }
            if (i3 != 0) {
                GrabParams grabParams = new GrabParams(qQText.mText, i3, 0, str.length());
                this.mGrabParams = grabParams;
                grabParams.setEmoSize(iArr[1]);
                Iterator<ISpanProcessor> it = getSpanProcessors().iterator();
                while (it.hasNext()) {
                    ISpanProcessor next = it.next();
                    if (next.matchGrab(i3)) {
                        next.doGrab(this.mGrabParams, qQText);
                    }
                }
                qQText.mText = this.mGrabParams.text;
            }
        } else {
            qQText.mSource = this.mSource + str;
            String str2 = this.mText + str;
            qQText.mText = str2;
            if (i3 != 0) {
                GrabParams grabParams2 = new GrabParams(str2, i3, this.mText.length(), this.mText.length() + str.length());
                this.mGrabParams = grabParams2;
                grabParams2.setEmoSize(iArr[1]);
                Iterator<ISpanProcessor> it5 = getSpanProcessors().iterator();
                while (it5.hasNext()) {
                    ISpanProcessor next2 = it5.next();
                    if (next2.matchGrab(i3)) {
                        next2.doGrab(this.mGrabParams, qQText);
                    }
                }
                qQText.mText = this.mGrabParams.text;
            }
        }
        return qQText;
    }

    public String toPlainText(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        StringBuffer stringBuffer = new StringBuffer(this.mText);
        int i16 = 0;
        for (int i17 = 0; i17 < this.mSpanCount; i17++) {
            Object obj = this.mSpans[i17];
            Iterator<ISpanProcessor> it = getSpanProcessors().iterator();
            while (true) {
                if (it.hasNext()) {
                    ISpanProcessor next = it.next();
                    if (next.matchPlain(obj)) {
                        int[] iArr = this.mSpanData;
                        int i18 = i17 * 3;
                        i16 += next.doPlain(obj, iArr[i18 + 0] + i16, iArr[i18 + 1] + i16, i3, stringBuffer);
                        break;
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public QQText(CharSequence charSequence, int i3, int i16, int i17) {
        this(charSequence, 0, charSequence == null ? 0 : charSequence.length(), i3, i16, -1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public QQText(CharSequence charSequence, int i3, int i16, Object obj) {
        this(charSequence, 0, charSequence == null ? 0 : charSequence.length(), i3, i16, -1, obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), obj);
    }

    public QQText(CharSequence charSequence, int i3, int i16, Object obj, ISpanRefreshCallback iSpanRefreshCallback) {
        this(charSequence, 0, charSequence == null ? 0 : charSequence.length(), i3, i16, -1, obj, iSpanRefreshCallback, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), obj, iSpanRefreshCallback);
    }

    public QQText(CharSequence charSequence, int i3, int i16, int i17, int i18, boolean z16) {
        this(charSequence, i3, i16, i17, i18, -1, null, null, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16));
    }

    protected QQText(CharSequence charSequence, int i3, int i16, int i17, int i18, int i19, Object obj) {
        this(charSequence, i3, i16, i17, i18, i19, obj, null, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), obj);
    }

    protected QQText(CharSequence charSequence, int i3, int i16, int i17, int i18, int i19, Object obj, ISpanRefreshCallback iSpanRefreshCallback, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), obj, iSpanRefreshCallback, Boolean.valueOf(z16));
            return;
        }
        this.mSpanRefreshCallback = null;
        if (charSequence == null) {
            this.mText = "";
            this.mSource = "";
            return;
        }
        if (z16) {
            this.mSource = charSequence.toString().substring(i3, i16);
        } else {
            this.mSource = charSequence.toString();
        }
        String str = this.mSource;
        this.mText = str;
        this.mSpanRefreshCallback = iSpanRefreshCallback;
        GrabParams grabParams = new GrabParams(str, i17, i3, i16);
        this.mGrabParams = grabParams;
        grabParams.setEmoSize(i18);
        this.mGrabParams.setUinType(i19);
        if (obj != null) {
            this.mGrabParams.setMessage(obj);
        }
        SystemClock.uptimeMillis();
        int idealIntArraySize = idealIntArraySize(3);
        try {
            this.mSpans = new Object[idealIntArraySize];
            this.mSpanData = new int[idealIntArraySize * 3];
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        Iterator<ISpanProcessor> it = getSpanProcessors().iterator();
        while (it.hasNext()) {
            ISpanProcessor next = it.next();
            if (next.matchGrab(i17)) {
                next.doGrab(this.mGrabParams, this);
            }
        }
        String str2 = this.mGrabParams.text;
        this.mText = str2;
        if (!IS_FXXKED_MTK) {
            this.mSource = str2;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Object[] spans = spanned.getSpans(i3, i16, Object.class);
            for (int i26 = 0; i26 < spans.length; i26++) {
                int spanStart = spanned.getSpanStart(spans[i26]);
                int spanEnd = spanned.getSpanEnd(spans[i26]);
                int spanFlags = spanned.getSpanFlags(spans[i26]);
                if (!z16) {
                    setSpan(spans[i26], (spanStart < i3 ? i3 : spanStart) - i3, (spanEnd > i16 ? i16 : spanEnd) - i3, spanFlags);
                } else if (spanStart >= i3 && spanStart < spanEnd && spanEnd <= i16) {
                    setSpan(spans[i26], spanStart - i3, spanEnd - i3, spanFlags);
                }
            }
        }
    }

    public String toPlainText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) ? toPlainText(true) : (String) iPatchRedirector.redirect((short) 28, (Object) this);
    }
}
