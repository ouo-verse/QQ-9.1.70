package com.tenpay.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BankImageUtil extends EnterBase<IApiBankimg> {
    private static final String TAG = "BankImageUtil";
    private static BankImageUtil instance;
    private IApiBankimg logic;

    BankImageUtil(Context context) {
        QwLog.i("constructor...");
        try {
            IApiBankimg logic = getLogic(context);
            this.logic = logic;
            logic.init(context);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static BankImageUtil getInstance(Context context) {
        BankImageUtil bankImageUtil;
        synchronized (BankImageUtil.class) {
            if (instance == null) {
                instance = new BankImageUtil(context);
            }
            bankImageUtil = instance;
        }
        return bankImageUtil;
    }

    public static Bitmap toGrayscale(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            paint.setAlpha(127);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        }
        return null;
    }

    @Override // com.tenpay.api.EnterBase
    protected String enterApi() {
        return IApiBankimg.LOGIC;
    }

    @Deprecated
    public int getBankCardBackgroundId(String str) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return -1;
        }
        return iApiBankimg.getBankCardBackgroundId(str);
    }

    @Deprecated
    public int getBankCardBackgroundIdForQQ(String str) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return -1;
        }
        return iApiBankimg.getBankCardBackgroundIdForQQ(str);
    }

    public void getBankCardLogoForQQ(String str, ResultReceiver resultReceiver) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return;
        }
        iApiBankimg.getBankCardLogoForQQ(str, resultReceiver);
    }

    public void getBankCardWhiteMark(String str, ResultReceiver resultReceiver) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return;
        }
        iApiBankimg.getBankCardWhiteMark(str, resultReceiver);
    }

    @Deprecated
    public void setBankCardDisableLogo(String str, View view) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return;
        }
        iApiBankimg.setBankCardDisableLogo(str, view);
    }

    @Deprecated
    public void setBankCardWhiteLogoForQQ(String str, View view) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return;
        }
        iApiBankimg.setBankCardWhiteLogoForQQ(str, view);
    }

    public void setBankImage(String str, View view) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return;
        }
        iApiBankimg.setBankImage(str, view);
    }

    @Deprecated
    public int getBankCardBackgroundId(String str, int i3) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return -1;
        }
        return iApiBankimg.getBankCardBackgroundId(str, i3);
    }

    @Deprecated
    public int getBankCardBackgroundIdForQQ(String str, int i3) {
        IApiBankimg iApiBankimg = this.logic;
        if (iApiBankimg == null) {
            return -1;
        }
        return iApiBankimg.getBankCardBackgroundIdForQQ(str, i3);
    }
}
