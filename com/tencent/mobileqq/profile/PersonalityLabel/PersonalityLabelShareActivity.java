package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.h;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class PersonalityLabelShareActivity extends IphoneTitleBarActivity implements View.OnClickListener, TagCloudView.b, ShareHelper.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    TagCloudView f259898a0;

    /* renamed from: b0, reason: collision with root package name */
    ImageView f259899b0;

    /* renamed from: c0, reason: collision with root package name */
    TextView f259900c0;

    /* renamed from: d0, reason: collision with root package name */
    View f259901d0;

    /* renamed from: e0, reason: collision with root package name */
    View f259902e0;

    /* renamed from: f0, reason: collision with root package name */
    View f259903f0;

    /* renamed from: g0, reason: collision with root package name */
    View f259904g0;

    /* renamed from: h0, reason: collision with root package name */
    Button f259905h0;

    /* renamed from: i0, reason: collision with root package name */
    Button f259906i0;

    /* renamed from: j0, reason: collision with root package name */
    Bitmap f259907j0;

    /* renamed from: k0, reason: collision with root package name */
    Bitmap f259908k0;

    /* renamed from: l0, reason: collision with root package name */
    Bitmap f259909l0;

    /* renamed from: m0, reason: collision with root package name */
    int f259910m0;

    /* renamed from: n0, reason: collision with root package name */
    float f259911n0;

    /* renamed from: o0, reason: collision with root package name */
    boolean f259912o0;

    /* renamed from: p0, reason: collision with root package name */
    ShareHelper f259913p0;

    /* renamed from: q0, reason: collision with root package name */
    ProfilePersonalityLabelInfo f259914q0;

    /* renamed from: r0, reason: collision with root package name */
    Drawable f259915r0;

    /* renamed from: s0, reason: collision with root package name */
    Drawable f259916s0;

    /* renamed from: t0, reason: collision with root package name */
    TextPaint f259917t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f259918u0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelShareActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                PersonalityLabelShareActivity.this.L2();
            }
        }
    }

    public PersonalityLabelShareActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f259910m0 = 0;
        this.f259912o0 = true;
        this.f259917t0 = new TextPaint(7);
        this.f259918u0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2() {
        this.f259912o0 = false;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelShareActivity.this);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0098, code lost:
            
                if (r8 != null) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
            
                r8.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x008a, code lost:
            
                com.tencent.qphone.base.util.QLog.e("PersonalityLabelDeleteActivity", 1, "saveQRCodeReal finally, error = $e");
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
            
                if (r8 != null) goto L43;
             */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                ContentResolver contentResolver;
                Uri insert;
                boolean z16;
                OutputStream outputStream;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Bitmap bitmap = PersonalityLabelShareActivity.this.f259909l0;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    contentResolver = PersonalityLabelShareActivity.this.getContentResolver();
                    String str = "personLabel_" + String.valueOf(System.currentTimeMillis());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", str);
                    contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
                    contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
                    insert = contentResolver.insert(uri, contentValues);
                    OutputStream outputStream2 = null;
                    z16 = false;
                    if (insert != null) {
                        try {
                            outputStream = contentResolver.openOutputStream(insert);
                        } catch (FileNotFoundException | IllegalStateException | OutOfMemoryError unused) {
                            outputStream = null;
                            QLog.e("PersonalityLabelDeleteActivity", 1, "saveQRCodeReal, error = $e");
                        } catch (Throwable th5) {
                            th = th5;
                            if (outputStream2 != null) {
                            }
                            throw th;
                        }
                    } else {
                        outputStream = null;
                    }
                    if (outputStream != null) {
                        try {
                            try {
                                z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);
                            } catch (Throwable th6) {
                                th = th6;
                                outputStream2 = outputStream;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException unused2) {
                                        QLog.e("PersonalityLabelDeleteActivity", 1, "saveQRCodeReal finally, error = $e");
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException | IllegalStateException | OutOfMemoryError unused3) {
                            QLog.e("PersonalityLabelDeleteActivity", 1, "saveQRCodeReal, error = $e");
                        }
                    }
                } else {
                    return;
                }
                if (!z16 && insert != null) {
                    py3.b.e(contentResolver, insert, null, null);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16, insert) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ boolean f259919d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Uri f259920e;

                    {
                        this.f259919d = z16;
                        this.f259920e = insert;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, Boolean.valueOf(z16), insert);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.f259919d && PersonalityLabelShareActivity.this != null) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(this.f259920e);
                            PersonalityLabelShareActivity.this.sendBroadcast(intent);
                            h.T(2, R.string.cwj);
                            PersonalityLabelShareActivity.this.f259918u0 = true;
                        } else {
                            h.T(1, R.string.f216945zo);
                        }
                        PersonalityLabelShareActivity.this.f259912o0 = true;
                    }
                });
            }
        }, 64, null, true);
    }

    private void M2() {
        QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LABEL_SHARE_STORAGE, QQPermissionConstants.Business.SCENE.SAVE_QR_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
    }

    private void N2() {
        ArrayList arrayList = new ArrayList(this.f259914q0.getSize());
        if (this.f259915r0 == null) {
            this.f259915r0 = getResources().getDrawable(R.color.f156899eo);
        }
        String latestThumbLocalUrl = this.f259914q0.getLatestThumbLocalUrl();
        URLDrawable uRLDrawable = null;
        if (!TextUtils.isEmpty(latestThumbLocalUrl)) {
            try {
                URL url = new URL("file:///" + new File(latestThumbLocalUrl).getAbsolutePath());
                Drawable drawable = this.f259915r0;
                uRLDrawable = URLDrawable.getDrawable(url, drawable, drawable);
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelDeleteActivity", 2, e16.getMessage(), e16);
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelDeleteActivity", 2, e17.getMessage(), e17);
                }
            }
        } else {
            String latestThumbUrl = this.f259914q0.getLatestThumbUrl();
            if (!TextUtils.isEmpty(latestThumbUrl) && (latestThumbUrl.startsWith("http") || latestThumbUrl.startsWith("https"))) {
                Drawable drawable2 = this.f259915r0;
                uRLDrawable = URLDrawable.getDrawable(latestThumbUrl, drawable2, drawable2);
            } else if (!TextUtils.isEmpty(latestThumbUrl)) {
                try {
                    URL url2 = new URL("file:///" + new File(latestThumbUrl).getAbsolutePath());
                    Drawable drawable3 = this.f259915r0;
                    uRLDrawable = URLDrawable.getDrawable(url2, drawable3, drawable3);
                } catch (MalformedURLException e18) {
                    e18.printStackTrace();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.i("PersonalityLabelDeleteActivity", 2, e19.getMessage(), e19);
                    }
                }
            }
        }
        com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.b.c(arrayList, this.f259914q0, this.f259911n0);
        this.f259898a0.setTags(arrayList);
        this.f259898a0.setTagIcon(uRLDrawable);
    }

    Bitmap H2() {
        Bitmap createBitmap;
        Bitmap bitmap = null;
        try {
            createBitmap = Bitmap.createBitmap(this.f259901d0.getWidth(), this.f259901d0.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (Exception e16) {
            e = e16;
        } catch (OutOfMemoryError e17) {
            e = e17;
        }
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            Point I2 = I2(this.f259898a0);
            canvas.save();
            canvas.translate(I2.x, I2.y);
            Bitmap bitmap2 = this.f259908k0;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.f259917t0);
            }
            canvas.restore();
            Point I22 = I2(this.f259903f0);
            Point I23 = I2(this.f259902e0);
            Point I24 = I2(this.f259904g0);
            canvas.save();
            int f16 = BaseAIOUtils.f(40.0f, getResources());
            int f17 = BaseAIOUtils.f(18.0f, getResources());
            canvas.translate(I24.x + I22.x + I23.x, I24.y + I22.y + I23.y);
            this.f259916s0.setBounds(0, 0, f16, f17);
            this.f259916s0.draw(canvas);
            canvas.restore();
            Point I25 = I2(this.f259900c0);
            canvas.save();
            Layout layout = this.f259900c0.getLayout();
            canvas.translate(I25.x + I22.x + I23.x, I25.y + I22.y + I23.y);
            layout.draw(canvas);
            canvas.restore();
            canvas.save();
            Point I26 = I2(this.f259899b0);
            canvas.translate(I23.x + I26.x, I23.y + I26.y);
            Bitmap bitmap3 = this.f259907j0;
            int i3 = this.f259910m0;
            canvas.drawBitmap(bitmap3, (Rect) null, new Rect(0, 0, i3, i3), (Paint) null);
            canvas.restore();
            return createBitmap;
        } catch (Exception e18) {
            e = e18;
            bitmap = createBitmap;
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelDeleteActivity", 2, e.getMessage());
            }
            return bitmap;
        } catch (OutOfMemoryError e19) {
            e = e19;
            bitmap = createBitmap;
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelDeleteActivity", 2, e.getMessage());
            }
            return bitmap;
        }
    }

    public Point I2(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Point) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view.getParent()).offsetDescendantRectToMyCoords(view, rect);
        return new Point(rect.left, rect.top);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Bitmap J2() {
        Bitmap bitmap;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap start");
        }
        Bitmap bitmap2 = null;
        try {
            BitMatrix o16 = h.o(String.format(ShareHelper.f259923g, this.app.getCurrentAccountUin()), 29);
            int width = o16.getWidth();
            int[] iArr = new int[width * width];
            for (int i16 = 0; i16 < width; i16++) {
                int i17 = i16 * width;
                for (int i18 = 0; i18 < width; i18++) {
                    int i19 = i17 + i18;
                    if (o16.get(i18, i16)) {
                        i3 = -16777216;
                    } else {
                        i3 = -1;
                    }
                    iArr[i19] = i3;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, width);
            int i26 = this.f259910m0;
            bitmap = Bitmap.createBitmap(i26, i26, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                int i27 = this.f259910m0;
                canvas.drawBitmap(createBitmap, (Rect) null, new Rect(0, 0, i27, i27), (Paint) null);
                createBitmap.recycle();
            } catch (Exception e16) {
                e = e16;
                bitmap2 = bitmap;
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelDeleteActivity", 2, e.getMessage());
                }
                bitmap = bitmap2;
                if (QLog.isColorLevel()) {
                }
                return bitmap;
            } catch (OutOfMemoryError e17) {
                e = e17;
                bitmap2 = bitmap;
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelDeleteActivity", 2, e.getMessage());
                }
                bitmap = bitmap2;
                if (QLog.isColorLevel()) {
                }
                return bitmap;
            }
        } catch (Exception e18) {
            e = e18;
        } catch (OutOfMemoryError e19) {
            e = e19;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap end");
        }
        return bitmap;
    }

    void K2() {
        setLeftViewName(R.string.f170549u3);
        this.rightViewText.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.b
    public void W1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f259912o0 = !z16;
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1) {
            if (i3 == 1) {
                h.T(2, R.string.f172952g24);
            } else if (i3 == 21) {
                if (intent != null && intent.getExtras() != null && !intent.getExtras().isEmpty() && intent.getExtras().getInt("uintype", 0) != 10027) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                    m3.putExtras(new Bundle(intent.getExtras()));
                    startActivity(m3);
                } else {
                    QLog.i("PersonalityLabelDeleteActivity", 2, "do not go AIO");
                }
                finish();
            }
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f168831az2);
        this.f259914q0 = (ProfilePersonalityLabelInfo) getIntent().getParcelableExtra("data");
        initViews();
        this.f259916s0 = getResources().getDrawable(R.drawable.f1w);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
            K2();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void initViews() {
        Bitmap J2;
        this.f259911n0 = getResources().getDisplayMetrics().density;
        BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adr);
        bounceScrollView.setVerticalScrollBarEnabled(false);
        bounceScrollView.mScrollFlag = 1;
        TagCloudView tagCloudView = (TagCloudView) findViewById(R.id.jba);
        this.f259898a0 = tagCloudView;
        tagCloudView.setOnUpdateDrawingListener(this);
        this.f259898a0.setMinHeight((int) (this.f259911n0 * 150.0f));
        this.f259898a0.setThreshold((int) (this.f259911n0 * 7.5f));
        this.f259901d0 = findViewById(R.id.fhu);
        this.f259902e0 = findViewById(R.id.dlm);
        this.f259903f0 = findViewById(R.id.ji7);
        this.f259904g0 = findViewById(R.id.f166149eh4);
        this.f259901d0.setOnClickListener(this);
        this.f259899b0 = (ImageView) findViewById(R.id.h0d);
        this.f259900c0 = (TextView) findViewById(R.id.jfb);
        this.f259910m0 = getResources().getDimensionPixelSize(R.dimen.aia);
        QQAppInterface qQAppInterface = this.app;
        String F = ac.F(qQAppInterface, qQAppInterface.getCurrentAccountUin());
        String qqStr = HardCodeUtil.qqStr(R.string.p1_);
        String qqStr2 = HardCodeUtil.qqStr(R.string.p1v);
        int f16 = (((getResources().getDisplayMetrics().widthPixels - (BaseAIOUtils.f(20.0f, getResources()) * 5)) - BaseAIOUtils.f(1.0f, getResources())) - this.f259910m0) - BaseAIOUtils.f(10.0f, getResources());
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f259900c0.getTextSize());
        String str = qqStr + F + qqStr2;
        float f17 = f16;
        String str2 = (String) TextUtils.ellipsize(str, textPaint, f17, TextUtils.TruncateAt.END);
        if (TextUtils.equals(str, str2)) {
            this.f259900c0.setText(str2);
            this.f259905h0 = (Button) findViewById(R.id.ajq);
            this.f259906i0 = (Button) findViewById(R.id.ak9);
            this.f259905h0.setOnClickListener(this);
            this.f259906i0.setOnClickListener(this);
            J2 = J2();
            this.f259907j0 = J2;
            if (J2 == null) {
                QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.p19), 0).show();
                finish();
            }
            this.f259899b0.setImageBitmap(this.f259907j0);
            N2();
        }
        while (!TextUtils.isEmpty(F) && F.length() > 1) {
            F = (String) F.subSequence(0, F.length() - 1);
            String str3 = qqStr + F + MiniBoxNoticeInfo.APPNAME_SUFFIX + qqStr2;
            String str4 = (String) TextUtils.ellipsize(str3, textPaint, f17, TextUtils.TruncateAt.END);
            if (TextUtils.equals(str3, str4)) {
                this.f259900c0.setText(str4);
                break;
            }
        }
        this.f259900c0.setText(qqStr + MiniBoxNoticeInfo.APPNAME_SUFFIX + qqStr2);
        this.f259905h0 = (Button) findViewById(R.id.ajq);
        this.f259906i0 = (Button) findViewById(R.id.ak9);
        this.f259905h0.setOnClickListener(this);
        this.f259906i0.setOnClickListener(this);
        J2 = J2();
        this.f259907j0 = J2;
        if (J2 == null) {
        }
        this.f259899b0.setImageBitmap(this.f259907j0);
        N2();
    }

    @Override // com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.b
    public void n0(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
            return;
        }
        this.f259908k0 = bitmap;
        Bitmap bitmap2 = this.f259909l0;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f259909l0 = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ak9) {
            if (!this.f259912o0) {
                QQToast.makeText(this, R.string.fpa, 0).show();
            } else {
                if (this.f259909l0 == null) {
                    this.f259909l0 = H2();
                }
                if (this.f259909l0 == null) {
                    QQToast.makeText(this, 1, R.string.fpb, 0).show();
                } else {
                    if (this.f259913p0 == null) {
                        this.f259913p0 = new ShareHelper(this, this.app, this, this);
                    }
                    this.f259913p0.d(this.f259909l0);
                    this.f259913p0.e(null);
                }
            }
        } else if (view.getId() == R.id.ajq) {
            if (this.f259912o0) {
                if (this.f259909l0 == null) {
                    this.f259909l0 = H2();
                }
                if (this.f259909l0 == null) {
                    QQToast.makeText(this, 1, R.string.fpb, 0).show();
                } else if (!this.f259918u0) {
                    M2();
                } else {
                    QQToast.makeText(this, 0, HardCodeUtil.qqStr(R.string.p1f), 0).show();
                }
            }
        } else if (view.getId() == R.id.fhu) {
            this.f259918u0 = false;
            Bitmap bitmap = this.f259909l0;
            if (bitmap != null) {
                bitmap.recycle();
                this.f259909l0 = null;
            }
            N2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
