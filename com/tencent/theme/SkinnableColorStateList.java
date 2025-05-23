package com.tencent.theme;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SkinnableColorStateList extends ColorStateList {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<ColorStateList> CREATOR;
    static Constructor C_FACTORY = null;
    private static final int DEFAULT_COLOR = -1;
    private static final int[][] EMPTY;
    public static final int ERROR_COLOR;
    public static final String FOCUS_COLOR_NAME = "qui_common_bubble_host_top";
    static Field F_FACTORY = null;
    private static final String TAG = "SkinnableColorStateList";
    private static final int[][] TMP;
    private int mColorLengthToReport;
    private int[] mColors;
    private int mDefaultColor;
    private long mLastCallTs;
    private boolean mOutOfIndexFlag;
    private boolean mReturnFromStateSetFlag;
    private int mSetLengthToReport;
    private int[][] mStateSpecs;
    Object mmFactory;
    public SkinData skinData;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class a implements Parcelable.Creator<ColorStateList> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorStateList createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ColorStateList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            int readInt = parcel.readInt();
            int[][] iArr = new int[readInt];
            for (int i3 = 0; i3 < readInt; i3++) {
                iArr[i3] = parcel.createIntArray();
            }
            return new ColorStateList(iArr, parcel.createIntArray());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ColorStateList[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ColorStateList[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new ColorStateList[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10632);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        ERROR_COLOR = Color.parseColor("#F74C30");
        EMPTY = new int[][]{new int[0]};
        TMP = new int[0];
        CREATOR = new a();
        if (SkinEngine.IS_MNC_PREVIEW) {
            try {
                Constructor<?> constructor = Class.forName("android.content.res.ColorStateList$ColorStateListFactory").getConstructor(ColorStateList.class);
                C_FACTORY = constructor;
                constructor.setAccessible(true);
                Field declaredField = ColorStateList.class.getDeclaredField("mFactory");
                F_FACTORY = declaredField;
                declaredField.setAccessible(true);
            } catch (Exception unused) {
                C_FACTORY = null;
                F_FACTORY = null;
            }
        }
    }

    public SkinnableColorStateList(int[][] iArr, int[] iArr2) {
        super(TMP, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iArr, (Object) iArr2);
            return;
        }
        this.mDefaultColor = -1;
        this.mStateSpecs = iArr;
        this.mColors = iArr2;
        if (iArr != null && iArr.length > 0) {
            this.mDefaultColor = iArr2[0];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (iArr[i3].length == 0) {
                    this.mDefaultColor = iArr2[i3];
                }
            }
        }
        locateIssue(this.mDefaultColor, null, QCircleDaTongConstant.ElementParamValue.NEW);
        if (SkinEngine.IS_MNC_PREVIEW) {
            workroundForMNC();
        }
    }

    public static SkinnableColorStateList createFromXml(SkinEngine skinEngine, Resources resources, XmlPullParser xmlPullParser, boolean z16) throws XmlPullParserException, IOException {
        int next;
        try {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(skinEngine, resources, xmlPullParser, asAttributeSet, z16);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Exception e16) {
            m.a(TAG, 1, "createFromXml error : " + e16.getMessage());
            return new SkinnableColorStateList(EMPTY, new int[]{-65281});
        }
    }

    private static SkinnableColorStateList createFromXmlInner(SkinEngine skinEngine, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, boolean z16) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            SkinnableColorStateList skinnableColorStateList = new SkinnableColorStateList(null, null);
            skinnableColorStateList.inflate(skinEngine, resources, xmlPullParser, attributeSet, z16);
            return skinnableColorStateList;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
    }

    public static int idealByteArraySize(int i3) {
        for (int i16 = 4; i16 < 32; i16++) {
            int i17 = (1 << i16) - 12;
            if (i3 <= i17) {
                return i17;
            }
        }
        return i3;
    }

    private int idealIntArraySize(int i3) {
        return idealByteArraySize(i3 * 4) / 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0230, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0220, code lost:
    
        r1 = new int[r8];
        r18.mColors = r1;
        r18.mStateSpecs = new int[r8];
        java.lang.System.arraycopy(r5, 0, r1, 0, r8);
        java.lang.System.arraycopy(r6, 0, r18.mStateSpecs, 0, r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void inflate(SkinEngine skinEngine, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, boolean z16) throws XmlPullParserException, IOException {
        int depth;
        int i3;
        int i16;
        int i17 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int i18 = 20;
        int[] iArr = new int[20];
        int[][] iArr2 = new int[20];
        int i19 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i17 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i26 = -1;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                boolean z17 = false;
                while (i27 < attributeCount) {
                    if (z16) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i27);
                        if (attributeNameResource == 0) {
                            break;
                        }
                        i3 = depth2;
                        if (attributeNameResource == 16843173) {
                            i29 = attributeSet.getAttributeResourceValue(i27, 0);
                            if (i29 == 0) {
                                i26 = attributeSet.getAttributeIntValue(i27, i26);
                                z17 = true;
                            }
                        } else {
                            i16 = i28 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i27, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr3[i28] = attributeNameResource;
                            i28 = i16;
                        }
                    } else {
                        i3 = depth2;
                        String attributeName = attributeSet.getAttributeName(i27);
                        if ("color".equals(attributeName)) {
                            i26 = Color.parseColor(attributeSet.getAttributeValue(i27));
                            z17 = true;
                        } else {
                            if ("state_window_focused".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_window_focused : -16842909;
                            } else if ("state_selected".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_selected : -16842913;
                            } else if ("state_focused".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_focused : -16842908;
                            } else if ("state_enabled".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_enabled : -16842910;
                            } else if ("state_pressed".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_pressed : -16842919;
                            } else if ("state_checked".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_checked : -16842912;
                            } else if ("state_activated".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_activated : -16843518;
                            } else if ("state_accelerated".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_accelerated : -16843547;
                            } else if ("state_hovered".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_hovered : -16843623;
                            } else if ("state_drag_can_accept".equals(attributeName)) {
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_drag_can_accept : -16843624;
                            } else {
                                if (!"state_drag_hovered".equals(attributeName)) {
                                    break;
                                }
                                i16 = i28 + 1;
                                iArr3[i28] = attributeSet.getAttributeBooleanValue(i27, false) ? R.attr.state_drag_hovered : -16843625;
                            }
                            i28 = i16;
                        }
                    }
                    i27++;
                    depth2 = i3;
                }
                i3 = depth2;
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i28);
                if (i29 != 0) {
                    i26 = skinEngine.getColor(i29);
                } else if (!z17) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'android:color' attribute.");
                }
                if (i19 == 0 || trimStateSet.length == 0) {
                    this.mDefaultColor = i26;
                    locateIssue(i26, null, "inflate");
                }
                int i36 = i19 + 1;
                if (i36 >= i18) {
                    i18 = idealIntArraySize(i36);
                    int[] iArr4 = new int[i18];
                    System.arraycopy(iArr, 0, iArr4, 0, i19);
                    int[][] iArr5 = new int[i18];
                    System.arraycopy(iArr2, 0, iArr5, 0, i19);
                    iArr2 = iArr5;
                    iArr = iArr4;
                }
                iArr[i19] = i26;
                iArr2[i19] = trimStateSet;
                i19 = i36;
            } else {
                i3 = depth2;
            }
            depth2 = i3;
            i17 = 1;
        }
    }

    private void locateIssue(int i3, SkinnableColorStateList skinnableColorStateList, String str) {
        if (SkinEngine.BUG_LOCATE) {
            try {
                String str2 = "*";
                boolean z16 = false;
                if (this.skinData != null) {
                    str2 = "[old:" + this.skinData.mResourcesID + "," + this.skinData.mFileName + "]";
                    if (skinnableColorStateList != null && skinnableColorStateList.skinData != null) {
                        str2 = str2 + "[new:" + skinnableColorStateList.skinData.mResourcesID + "," + skinnableColorStateList.skinData.mFileName + "]";
                    }
                    if (!TextUtils.isEmpty(this.skinData.mFileName) && this.skinData.mFileName.contains(FOCUS_COLOR_NAME)) {
                        z16 = true;
                    }
                }
                int i16 = ERROR_COLOR;
                if (i3 == i16 || z16) {
                    if (z16 && i3 == i16) {
                        m.d(TAG, 1, str + " error color: #F74C30" + str2, new Throwable("SkinnableColorStateList " + str + " #F74C30"));
                        SkinEngine.getInstances();
                        if (SkinEngine.mThemeService != null) {
                            SkinEngine.getInstances();
                            SkinEngine.mThemeService.reportError(new Throwable("SkinnableColorStateList " + str + " #F74C30"), str + " error color: #F74C30" + str2);
                        }
                        if (SkinEngine.DEBUG) {
                            new BaseThread(new Runnable(str, str2) { // from class: com.tencent.theme.SkinnableColorStateList.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ String val$finalMsg;
                                final /* synthetic */ String val$from;

                                {
                                    this.val$from = str;
                                    this.val$finalMsg = str2;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, SkinnableColorStateList.this, str, str2);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    throw new RuntimeException("SkinnableColorStateList " + this.val$from + " #F74C30" + this.val$finalMsg);
                                }
                            }).start();
                            return;
                        }
                        return;
                    }
                    m.a(TAG, 1, str + str2 + Integer.toHexString(i3));
                }
            } catch (Exception e16) {
                m.d(TAG, 1, "locateIssue", e16);
            }
        }
    }

    private void workroundForMNC() {
        try {
            Object newInstance = C_FACTORY.newInstance(this);
            F_FACTORY.set(this, newInstance);
            this.mmFactory = newInstance;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.content.res.ColorStateList, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        return r8;
     */
    @Override // android.content.res.ColorStateList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getColorForState(int[] iArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) iArr, i3)).intValue();
        }
        int[][] iArr2 = (int[][]) this.mStateSpecs.clone();
        int length = iArr2.length;
        int length2 = this.mColors.length;
        this.mSetLengthToReport = length;
        this.mColorLengthToReport = length2;
        int i16 = 0;
        this.mOutOfIndexFlag = false;
        this.mReturnFromStateSetFlag = false;
        this.mLastCallTs = SystemClock.uptimeMillis();
        while (true) {
            if (i16 >= length) {
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i16], iArr) && length2 > i16) {
                this.mReturnFromStateSetFlag = true;
                int[] iArr3 = this.mColors;
                if (i16 < iArr3.length) {
                    return iArr3[i16];
                }
                return i3;
            }
            if (length2 <= i16) {
                this.mOutOfIndexFlag = true;
                break;
            }
            i16++;
        }
    }

    public int[] getColors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mColors;
    }

    @Override // android.content.res.ColorStateList
    public int getDefaultColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mDefaultColor;
    }

    public int[][] getStateSpecs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[][]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mStateSpecs;
    }

    @Override // android.content.res.ColorStateList
    public boolean isStateful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mSetLengthToReport = 0;
        this.mColorLengthToReport = 0;
        this.mOutOfIndexFlag = false;
        this.mReturnFromStateSetFlag = false;
        this.mLastCallTs = 0L;
    }

    public void setDefaultColor(int[] iArr, int[][] iArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iArr, (Object) iArr2);
            return;
        }
        if (iArr2 != null && iArr2.length > 0) {
            this.mDefaultColor = iArr[0];
            for (int i3 = 0; i3 < iArr2.length; i3++) {
                if (iArr2[i3].length == 0) {
                    this.mDefaultColor = iArr[i3];
                }
            }
            locateIssue(this.mDefaultColor, null, "setDefaultColor");
        }
    }

    @Override // android.content.res.ColorStateList
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "ColorStateList{mStateSpecs=" + Arrays.deepToString(this.mStateSpecs) + "mColors=" + Arrays.toString(this.mColors) + "mDefaultColor=" + this.mDefaultColor + "mSetLength=" + this.mSetLengthToReport + "mColorLength=" + this.mColorLengthToReport + "mOutOfIndexFlag=" + this.mOutOfIndexFlag + "mReturnFromStateSetFlag=" + this.mReturnFromStateSetFlag + "mLastCallTs=" + this.mLastCallTs + '}';
    }

    public void update(SkinnableColorStateList skinnableColorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) skinnableColorStateList);
            return;
        }
        this.mStateSpecs = skinnableColorStateList.mStateSpecs;
        this.mColors = skinnableColorStateList.mColors;
        this.mDefaultColor = skinnableColorStateList.mDefaultColor;
        locateIssue(skinnableColorStateList.mDefaultColor, skinnableColorStateList, "update");
    }

    @Override // android.content.res.ColorStateList
    public ColorStateList withAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        int length = this.mColors.length;
        int[] iArr = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            iArr[i16] = (this.mColors[i16] & 16777215) | (i3 << 24);
        }
        return new ColorStateList(this.mStateSpecs, iArr);
    }

    @Override // android.content.res.ColorStateList, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel, i3);
            return;
        }
        int length = this.mStateSpecs.length;
        parcel.writeInt(length);
        for (int i16 = 0; i16 < length; i16++) {
            parcel.writeIntArray(this.mStateSpecs[i16]);
        }
        parcel.writeIntArray(this.mColors);
    }
}
