package com.tencent.facebeauty;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class FaceParam implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<FaceParam> CREATOR;
    private static final String TAG;
    public int height;
    public Rect mEye;
    public Rect mFace;
    public int[][] mFaceOutline;
    public Rect mLeftEye;
    public Point mLeftEyeCenter;
    public Rect mMouth;
    public Rect mRightEye;
    public Point mRightEyeCenter;
    public int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12132);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            TAG = FaceParam.class.getSimpleName();
            CREATOR = new Parcelable.Creator<FaceParam>() { // from class: com.tencent.facebeauty.FaceParam.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FaceParam createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new FaceParam(parcel, null) : (FaceParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FaceParam[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new FaceParam[i3] : (FaceParam[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    /* synthetic */ FaceParam(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel, (Object) anonymousClass1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public NormalizedFaceParam normalizeFace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (NormalizedFaceParam) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        NormalizedFaceParam normalizedFaceParam = new NormalizedFaceParam();
        normalizedFaceParam.setX((this.mFace.left * 1.0d) / this.width);
        normalizedFaceParam.setY((this.mFace.top * 1.0d) / this.height);
        normalizedFaceParam.setW(((this.mFace.right * 1.0d) / this.width) - normalizedFaceParam.getX());
        normalizedFaceParam.setH(((this.mFace.bottom * 1.0d) / this.height) - normalizedFaceParam.getY());
        Log.d("NewEnhance_Batch", "Face normalized(" + normalizedFaceParam.getX() + ", " + normalizedFaceParam.getY() + ", " + normalizedFaceParam.getW() + ", " + normalizedFaceParam.getH() + ")");
        return normalizedFaceParam;
    }

    public void printFaceDes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        String str = ("\n****************FaceFeature******************:\n" + String.format("ImageSize:(%d, %d)\n", Integer.valueOf(this.width), Integer.valueOf(this.height))) + String.format("FaceRect:(%d, %d, %d, %d)\n", Integer.valueOf(this.mFace.left), Integer.valueOf(this.mFace.top), Integer.valueOf(this.mFace.width()), Integer.valueOf(this.mFace.height()));
        if (this.mFaceOutline != null) {
            String str2 = str + "LandMark:";
            int[][] iArr = this.mFaceOutline;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                str2 = str2 + String.format("(%d, %d)", Integer.valueOf(iArr[i3][0]), Integer.valueOf(iArr[i3][1]));
            }
            str = str2 + "\n";
        }
        LogUtils.e(TAG, str + "*********************************************\n");
    }

    public void resetSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i17 = this.height;
        if (i17 != i16 || this.width != i3) {
            resizeData(i3 / this.width, i16 / i17);
            this.height = i16;
            this.width = i3;
        }
    }

    public void resizeData(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.height = (int) (this.height * f17);
        this.width = (int) (this.width * f16);
        Rect rect = this.mFace;
        rect.left = (int) (rect.left * f16);
        rect.top = (int) (rect.top * f17);
        rect.right = (int) (rect.right * f16);
        rect.bottom = (int) (rect.bottom * f17);
        Rect rect2 = this.mLeftEye;
        rect2.left = (int) (rect2.left * f16);
        rect2.top = (int) (rect2.top * f17);
        rect2.right = (int) (rect2.right * f16);
        rect2.bottom = (int) (rect2.bottom * f17);
        Point point = this.mLeftEyeCenter;
        point.x = (int) (point.x * f16);
        point.y = (int) (point.y * f17);
        Rect rect3 = this.mRightEye;
        rect3.left = (int) (rect3.left * f16);
        rect3.top = (int) (rect3.top * f17);
        rect3.right = (int) (rect3.right * f16);
        rect3.bottom = (int) (rect3.bottom * f17);
        Point point2 = this.mRightEyeCenter;
        point2.x = (int) (point2.x * f16);
        point2.y = (int) (point2.y * f17);
        Rect rect4 = this.mEye;
        rect4.left = (int) (rect4.left * f16);
        rect4.top = (int) (rect4.top * f17);
        rect4.right = (int) (rect4.right * f16);
        rect4.bottom = (int) (rect4.bottom * f17);
        Rect rect5 = this.mMouth;
        rect5.left = (int) (rect5.left * f16);
        rect5.top = (int) (rect5.top * f17);
        rect5.right = (int) (rect5.right * f16);
        rect5.bottom = (int) (rect5.bottom * f17);
        int[][] iArr = this.mFaceOutline;
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                iArr2[0] = (int) (iArr2[0] * f16);
                iArr2[1] = (int) (iArr2[1] * f17);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.mLeftEyeCenter.x);
        parcel.writeInt(this.mLeftEyeCenter.y);
        parcel.writeInt(this.mRightEyeCenter.x);
        parcel.writeInt(this.mRightEyeCenter.y);
        parcel.writeParcelable(this.mFace, 1);
        parcel.writeParcelable(this.mLeftEye, 1);
        parcel.writeParcelable(this.mRightEye, 1);
        parcel.writeParcelable(this.mEye, 1);
        parcel.writeParcelable(this.mMouth, 1);
        if (this.mFaceOutline != null) {
            parcel.writeInt(1);
            int[] iArr = new int[this.mFaceOutline.length * 2];
            int i16 = 0;
            while (true) {
                int[][] iArr2 = this.mFaceOutline;
                if (i16 < iArr2.length) {
                    int i17 = i16 * 2;
                    int[] iArr3 = iArr2[i16];
                    iArr[i17] = iArr3[0];
                    iArr[i17 + 1] = iArr3[1];
                    i16++;
                } else {
                    parcel.writeIntArray(iArr);
                    return;
                }
            }
        } else {
            parcel.writeInt(0);
        }
    }

    public FaceParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.width = 0;
        this.height = 0;
        this.mFace = null;
        this.mLeftEye = null;
        this.mRightEye = null;
        this.mLeftEyeCenter = null;
        this.mRightEyeCenter = null;
        this.mEye = null;
        this.mMouth = null;
        this.mFaceOutline = null;
    }

    FaceParam(Parcel parcel) {
        int[] createIntArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.width = 0;
        this.height = 0;
        this.mFace = null;
        this.mLeftEye = null;
        this.mRightEye = null;
        this.mLeftEyeCenter = null;
        this.mRightEyeCenter = null;
        this.mEye = null;
        this.mMouth = null;
        this.mFaceOutline = null;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.mLeftEyeCenter = new Point(parcel.readInt(), parcel.readInt());
        this.mRightEyeCenter = new Point(parcel.readInt(), parcel.readInt());
        ClassLoader classLoader = Rect.class.getClassLoader();
        this.mFace = (Rect) parcel.readParcelable(classLoader);
        this.mLeftEye = (Rect) parcel.readParcelable(classLoader);
        this.mRightEye = (Rect) parcel.readParcelable(classLoader);
        this.mEye = (Rect) parcel.readParcelable(classLoader);
        this.mMouth = (Rect) parcel.readParcelable(classLoader);
        if (parcel.readInt() != 1 || (createIntArray = parcel.createIntArray()) == null || createIntArray.length < 2) {
            return;
        }
        this.mFaceOutline = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, createIntArray.length / 2, 2);
        for (int i3 = 0; i3 < createIntArray.length / 2; i3++) {
            int[] iArr = this.mFaceOutline[i3];
            int i16 = i3 * 2;
            iArr[0] = createIntArray[i16];
            iArr[1] = createIntArray[i16 + 1];
        }
    }
}
