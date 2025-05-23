package com.tencent.mobileqq.activity.aio;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateInfoShareHelper {

    /* renamed from: o, reason: collision with root package name */
    private static String f178108o;

    /* renamed from: a, reason: collision with root package name */
    private IntimateInfo f178109a;

    /* renamed from: b, reason: collision with root package name */
    private BaseActivity f178110b;

    /* renamed from: c, reason: collision with root package name */
    private QQAppInterface f178111c;

    /* renamed from: d, reason: collision with root package name */
    private QQProgressDialog f178112d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f178113e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f178114f;

    /* renamed from: k, reason: collision with root package name */
    private String f178119k;

    /* renamed from: l, reason: collision with root package name */
    private WXShareHelper.a f178120l;

    /* renamed from: g, reason: collision with root package name */
    private int f178115g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f178116h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f178117i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f178118j = false;

    /* renamed from: m, reason: collision with root package name */
    private ShareActionSheetWithPreview f178121m = null;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.mobileqq.sharepanel.f f178122n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.sharepanel.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f178132a;

        a(Bitmap bitmap) {
            this.f178132a = bitmap;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NonNull String str) {
            IntimateInfoShareHelper.this.O(str);
            IntimateInfoShareHelper.this.F(str, this.f178132a);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NonNull String str) {
            IntimateInfoShareHelper.this.O(str);
            IntimateInfoShareHelper.this.F(str, this.f178132a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ShareActionSheet.OnItemClickListener {
        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            int i16;
            IntimateInfoShareHelper.this.f178121m.dismiss();
            int i17 = actionSheetItem.action;
            if (i17 != 2) {
                i3 = 3;
                if (i17 != 3) {
                    if (i17 != 9) {
                        if (i17 != 10) {
                            if (i17 != 39) {
                                i3 = 0;
                            } else {
                                i3 = 5;
                            }
                        } else {
                            i3 = 4;
                        }
                    }
                } else {
                    i16 = 2;
                    if (i16 != 0) {
                        ReportController.o(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i16, 0, "", "", "", "");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("IntimateInfoShareHelper", 2, "intimate shareAction: " + actionSheetItem.action);
                    }
                    IntimateInfoShareHelper intimateInfoShareHelper = IntimateInfoShareHelper.this;
                    intimateInfoShareHelper.M(actionSheetItem.action, intimateInfoShareHelper.f178113e);
                }
            } else {
                i3 = 1;
            }
            i16 = i3;
            if (i16 != 0) {
            }
            if (QLog.isColorLevel()) {
            }
            IntimateInfoShareHelper intimateInfoShareHelper2 = IntimateInfoShareHelper.this;
            intimateInfoShareHelper2.M(actionSheetItem.action, intimateInfoShareHelper2.f178113e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements WXShareHelper.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            if (baseResp.errCode != 0) {
                IntimateInfoShareHelper.this.b0(1, R.string.f171047bz3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f178136a;

        d(Bitmap bitmap) {
            this.f178136a = bitmap;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            IntimateInfoShareHelper.this.Q(this.f178136a);
        }
    }

    public IntimateInfoShareHelper(BaseActivity baseActivity, QQAppInterface qQAppInterface, IntimateInfo intimateInfo, String str, Bitmap bitmap) {
        this.f178110b = baseActivity;
        this.f178111c = qQAppInterface;
        this.f178109a = intimateInfo;
        this.f178119k = str;
        this.f178114f = bitmap;
        f178108o = this.f178110b.getResources().getString(R.string.bzb) + this.f178110b.getResources().getString(R.string.bzc) + this.f178110b.getResources().getString(R.string.bzd);
    }

    private void A(Canvas canvas) {
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
            qQProAvatarDrawable.r(this.f178110b, 1, currentAccountUin, com.tencent.mobileqq.proavatar.e.a(1, currentAccountUin));
            qQProAvatarDrawable.setBounds(0, 0, 144, 144);
            canvas.save();
            canvas.translate(248.0f, 180.0f);
            qQProAvatarDrawable.draw(canvas);
            canvas.restore();
        }
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(223.0f, 250.0f, 76.0f, paint);
        if (!TextUtils.isEmpty(this.f178119k)) {
            QQProAvatarDrawable qQProAvatarDrawable2 = new QQProAvatarDrawable();
            BaseActivity baseActivity = this.f178110b;
            String str = this.f178119k;
            qQProAvatarDrawable2.r(baseActivity, 1, str, com.tencent.mobileqq.proavatar.e.a(1, str));
            qQProAvatarDrawable2.setBounds(0, 0, 144, 144);
            canvas.save();
            canvas.translate(153.0f, 180.0f);
            qQProAvatarDrawable2.draw(canvas);
            canvas.restore();
        }
    }

    private void B(Canvas canvas, Paint paint, float f16, float f17, String str) {
        canvas.drawText(str, f16, f17 - paint.getFontMetrics().top, paint);
    }

    private Intent C(Bitmap bitmap) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        try {
            String t16 = t(bitmap);
            if (TextUtils.isEmpty(t16)) {
                b0(1, R.string.byy);
            } else {
                intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, t16);
                intent.putExtra(AppConstants.Key.FORWARD_THUMB, t16);
                intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, t16);
                intent.putExtra(AppConstants.Key.FORWARD_EXTRA, t16);
            }
        } catch (Exception unused) {
            b0(1, R.string.f171047bz3);
        }
        return intent;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> E() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final String str, final Bitmap bitmap) {
        if ("weixin".equals(str) || "weixincircle".equals(str)) {
            if (!WXShareHelper.b0().e0()) {
                BaseActivity baseActivity = this.f178110b;
                QQToast.makeText(baseActivity, baseActivity.getString(R.string.bz9), 0).show(this.f178110b.getTitleBarHeight());
                return;
            } else if (!WXShareHelper.b0().f0()) {
                BaseActivity baseActivity2 = this.f178110b;
                QQToast.makeText(baseActivity2, baseActivity2.getString(R.string.bzg), 0).show(this.f178110b.getTitleBarHeight());
                return;
            }
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ae
            @Override // java.lang.Runnable
            public final void run() {
                IntimateInfoShareHelper.this.G(bitmap, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Bitmap bitmap, String str) {
        BaseActivity baseActivity;
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = v(this.f178109a);
        }
        if ("weixin".equals(str) || "weixincircle".equals(str)) {
            bitmap = s(bitmap);
        }
        if (bitmap != null && !bitmap.isRecycled() && (baseActivity = this.f178110b) != null && !baseActivity.isFinishing()) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1052216532:
                    if (str.equals("save_to_phone")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -791575966:
                    if (str.equals("weixin")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -393543490:
                    if (str.equals("qqfriend")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -304161157:
                    if (str.equals("qzoneshuoshuo")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 154627506:
                    if (str.equals("weixincircle")) {
                        c16 = 4;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    P(bitmap);
                    return;
                case 1:
                    W(bitmap, true);
                    return;
                case 2:
                    U(bitmap, true);
                    return;
                case 3:
                    V(bitmap);
                    return;
                case 4:
                    W(bitmap, false);
                    return;
                default:
                    return;
            }
        }
        b0(1, R.string.f171047bz3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(com.tencent.mobileqq.sharepanel.m mVar, Bitmap bitmap) {
        mVar.a(C(bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(final Bitmap bitmap, ArrayList arrayList, final com.tencent.mobileqq.sharepanel.m mVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ad
            @Override // java.lang.Runnable
            public final void run() {
                IntimateInfoShareHelper.this.H(mVar, bitmap);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        N(this.f178113e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.f178113e = v(this.f178109a);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ab
            @Override // java.lang.Runnable
            public final void run() {
                IntimateInfoShareHelper.this.J();
            }
        });
    }

    private void N(final Bitmap bitmap) {
        com.tencent.mobileqq.sharepanel.f t06 = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(this.f178110b, "relationship_close").q0(bitmap).k0(new com.tencent.mobileqq.sharepanel.n() { // from class: com.tencent.mobileqq.activity.aio.ac
            @Override // com.tencent.mobileqq.sharepanel.n
            public final void a(ArrayList arrayList, com.tencent.mobileqq.sharepanel.m mVar) {
                IntimateInfoShareHelper.this.I(bitmap, arrayList, mVar);
            }
        }).t0(new a(bitmap));
        this.f178122n = t06;
        t06.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void O(String str) {
        int i3;
        str.hashCode();
        int i16 = 4;
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1052216532:
                if (str.equals("save_to_phone")) {
                    c16 = 0;
                    break;
                }
                break;
            case -791575966:
                if (str.equals("weixin")) {
                    c16 = 1;
                    break;
                }
                break;
            case -393543490:
                if (str.equals("qqfriend")) {
                    c16 = 2;
                    break;
                }
                break;
            case -304161157:
                if (str.equals("qzoneshuoshuo")) {
                    c16 = 3;
                    break;
                }
                break;
            case 154627506:
                if (str.equals("weixincircle")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                i16 = 5;
                i3 = i16;
                break;
            case 1:
                i3 = 3;
                break;
            case 2:
                i3 = 1;
                break;
            case 3:
                i3 = 2;
                break;
            case 4:
                i3 = i16;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 != 0) {
            ReportController.o(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i3, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bitmap bitmap) {
        QQPermissionFactory.getQQPermission(this.f178110b, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_STORAGE, QQPermissionConstants.Business.SCENE.AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d(bitmap));
    }

    private Bitmap R(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Bitmap bitmap, boolean z16) {
        try {
            String t16 = t(bitmap);
            x();
            if (TextUtils.isEmpty(t16)) {
                b0(1, R.string.byy);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, t16);
            bundle.putString(AppConstants.Key.FORWARD_THUMB, t16);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, t16);
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, t16);
            if (z16) {
                bundle.putBoolean(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
            }
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(this.f178110b, intent, 21);
        } catch (OutOfMemoryError unused) {
            b0(1, R.string.f171047bz3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Bitmap bitmap) {
        String t16 = t(bitmap);
        x();
        if (TextUtils.isEmpty(t16)) {
            b0(1, R.string.byy);
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = this.f178111c.getAccount();
        BaseActivity baseActivity = this.f178110b;
        QZoneHelper.forwardToPublishMood(baseActivity, userInfo, t16, baseActivity.getResources().getString(R.string.bzf), "", 20001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Bitmap bitmap, boolean z16) {
        if (this.f178120l == null) {
            this.f178120l = new c();
            WXShareHelper.b0().A(this.f178120l);
        }
        String t16 = t(bitmap);
        x();
        if (TextUtils.isEmpty(t16)) {
            b0(1, R.string.byy);
        } else if (z16) {
            WXShareHelper.b0().u0(t16, bitmap, 0);
        } else {
            WXShareHelper.b0().u0(t16, bitmap, 1);
        }
    }

    private void Y() {
        Bitmap bitmap;
        if (this.f178121m == null) {
            u();
        }
        if (!this.f178118j && (bitmap = this.f178113e) != null && !bitmap.isRecycled()) {
            this.f178121m.D0(this.f178113e);
            this.f178121m.show();
        } else {
            this.f178118j = false;
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    IntimateInfoShareHelper intimateInfoShareHelper = IntimateInfoShareHelper.this;
                    intimateInfoShareHelper.f178113e = intimateInfoShareHelper.v(intimateInfoShareHelper.f178109a);
                    IntimateInfoShareHelper.this.f178121m.D0(IntimateInfoShareHelper.this.f178113e);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IntimateInfoShareHelper.this.f178121m.show();
                        }
                    });
                }
            });
        }
    }

    private void Z() {
        Bitmap bitmap;
        com.tencent.mobileqq.sharepanel.f fVar = this.f178122n;
        if (fVar != null) {
            fVar.dismiss();
        }
        if (!this.f178118j && (bitmap = this.f178113e) != null && !bitmap.isRecycled()) {
            N(this.f178113e);
        } else {
            this.f178118j = false;
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.aa
                @Override // java.lang.Runnable
                public final void run() {
                    IntimateInfoShareHelper.this.K();
                }
            });
        }
    }

    private void a0() {
        if (this.f178112d == null) {
            BaseActivity baseActivity = this.f178110b;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(baseActivity, baseActivity.getTitleBarHeight());
            this.f178112d = qQProgressDialog;
            qQProgressDialog.setBackAndSearchFilter(true);
        }
        this.f178112d.setMessage(R.string.c7z);
        QQProgressDialog qQProgressDialog2 = this.f178112d;
        if (qQProgressDialog2 != null && !qQProgressDialog2.isShowing() && !this.f178110b.isFinishing()) {
            this.f178112d.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(final int i3, final int i16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.biz.qrcode.util.h.T(i3, i16);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.d("IntimateInfoShareHelper", 1, "showQQToast error: " + e16.getMessage());
                }
            }
        });
    }

    private void u() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = this.f178110b;
        ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
        this.f178121m = shareActionSheetWithPreview;
        shareActionSheetWithPreview.setRowVisibility(8, 0, 0);
        this.f178121m.setActionSheetItems(E(), D());
        this.f178121m.setItemClickListenerV2(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QQProgressDialog qQProgressDialog = this.f178112d;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f178112d.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void y(Canvas canvas, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(i3);
        paint.setTextSize(28.0f);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        int width = (658 - rect.width()) / 2;
        float f16 = 1163 + (40 / 2.0f);
        int i16 = width + 16;
        float f17 = f16 + 1.0f;
        canvas.drawLine(width, f16, i16, f17, paint);
        int i17 = i16 + 10;
        Paint paint2 = new Paint();
        paint2.setColorFilter(new LightingColorFilter(0, i3));
        Bitmap decodeResource = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.oh_);
        int i18 = i17 + 40;
        canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(i17, 1163, i18, 1203), paint2);
        canvas.drawText(str, i18, f16 - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        canvas.drawLine(i18 + rect.width() + 10, f16, r4 + 16, f17, paint);
    }

    private void z(Canvas canvas, String str, TextPaint textPaint) {
        if (com.tencent.mobileqq.activity.aio.intimate.header.n.b()) {
            int e16 = com.tencent.mobileqq.activity.aio.intimate.header.a.e(this.f178109a.friendUin, this.f178115g);
            if (e16 > 1) {
                B(canvas, textPaint, 152.0f, 364.0f, String.valueOf(e16));
                float desiredWidth = Layout.getDesiredWidth(String.valueOf(e16), textPaint);
                textPaint.setTextSize(34.0f);
                B(canvas, textPaint, desiredWidth + 152.0f + 8.0f, 410.0f, this.f178110b.getResources().getString(R.string.by_, ""));
            } else {
                textPaint.setTextSize(34.0f);
                B(canvas, textPaint, 152.0f, 410.0f, this.f178110b.getResources().getString(R.string.bya));
            }
        } else {
            B(canvas, textPaint, 152.0f, 364.0f, String.valueOf(this.f178109a.beFriendDays));
            float desiredWidth2 = Layout.getDesiredWidth(String.valueOf(this.f178109a.beFriendDays), textPaint);
            textPaint.setTextSize(34.0f);
            B(canvas, textPaint, desiredWidth2 + 152.0f + 8.0f, 410.0f, this.f178110b.getResources().getString(R.string.by_, ""));
        }
        B(canvas, textPaint, 152.0f, 468.0f, str);
    }

    protected List<ShareActionSheetBuilder.ActionSheetItem> D() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        return arrayList;
    }

    public void L() {
        if (this.f178120l != null) {
            WXShareHelper.b0().q0(this.f178120l);
            this.f178120l = null;
        }
        ShareActionSheetWithPreview shareActionSheetWithPreview = this.f178121m;
        if (shareActionSheetWithPreview != null) {
            shareActionSheetWithPreview.dismiss();
        }
        com.tencent.mobileqq.sharepanel.f fVar = this.f178122n;
        if (fVar != null) {
            fVar.dismiss();
            this.f178122n = null;
        }
    }

    public void M(final int i3, final Bitmap bitmap) {
        if (i3 == 9 || i3 == 10) {
            if (!WXShareHelper.b0().e0()) {
                BaseActivity baseActivity = this.f178110b;
                QQToast.makeText(baseActivity, baseActivity.getString(R.string.bz9), 0).show(this.f178110b.getTitleBarHeight());
            } else if (!WXShareHelper.b0().f0()) {
                BaseActivity baseActivity2 = this.f178110b;
                QQToast.makeText(baseActivity2, baseActivity2.getString(R.string.bzg), 0).show(this.f178110b.getTitleBarHeight());
            }
        }
        a0();
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.4
            @Override // java.lang.Runnable
            public void run() {
                Bitmap v3;
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    v3 = bitmap;
                } else {
                    IntimateInfoShareHelper intimateInfoShareHelper = IntimateInfoShareHelper.this;
                    v3 = intimateInfoShareHelper.v(intimateInfoShareHelper.f178109a);
                }
                int i16 = i3;
                if (i16 == 9 || i16 == 10) {
                    v3 = IntimateInfoShareHelper.this.s(v3);
                }
                if (v3 == null || v3.isRecycled() || IntimateInfoShareHelper.this.f178110b == null || IntimateInfoShareHelper.this.f178110b.isFinishing()) {
                    IntimateInfoShareHelper.this.b0(1, R.string.f171047bz3);
                    return;
                }
                int i17 = i3;
                if (i17 == 2) {
                    IntimateInfoShareHelper.this.U(v3, false);
                } else if (i17 == 3) {
                    IntimateInfoShareHelper.this.V(v3);
                } else if (i17 == 9) {
                    IntimateInfoShareHelper.this.W(v3, true);
                } else if (i17 == 10) {
                    IntimateInfoShareHelper.this.W(v3, false);
                } else if (i17 == 39) {
                    IntimateInfoShareHelper.this.P(v3);
                }
                IntimateInfoShareHelper.this.x();
            }
        });
    }

    public void Q(final Bitmap bitmap) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7
            /* JADX WARN: Removed duplicated region for block: B:13:0x00e8 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x00f6 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bitmap bitmap2;
                OutputStream outputStream;
                OutputStream openOutputStream;
                StringBuilder sb5;
                final boolean z16 = false;
                final Uri uri = null;
                OutputStream outputStream2 = null;
                uri = null;
                uri = null;
                if (IntimateInfoShareHelper.this.f178110b != null && (bitmap2 = bitmap) != null && !bitmap2.isRecycled()) {
                    Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    ContentResolver contentResolver = IntimateInfoShareHelper.this.f178110b.getContentResolver();
                    String str = "intimate_share_" + Long.toString(System.currentTimeMillis()) + ".jpg";
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", str);
                    contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
                    contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
                    Uri insert = contentResolver.insert(uri2, contentValues);
                    if (insert != null) {
                        try {
                            openOutputStream = contentResolver.openOutputStream(insert);
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            outputStream = null;
                            try {
                                QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal, error = " + e);
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e17) {
                                        e = e17;
                                        sb5 = new StringBuilder();
                                        sb5.append("saveBitmapFileReal finally, error = ");
                                        sb5.append(e);
                                        QLog.e("IntimateInfoShareHelper", 1, sb5.toString());
                                        if (!z16) {
                                            py3.b.e(contentResolver, insert, null, null);
                                        }
                                        uri = insert;
                                        if (IntimateInfoShareHelper.this.f178110b == null) {
                                        }
                                    }
                                }
                                if (!z16) {
                                }
                                uri = insert;
                                if (IntimateInfoShareHelper.this.f178110b == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                outputStream2 = outputStream;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e18) {
                                        QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal finally, error = " + e18);
                                    }
                                }
                                throw th;
                            }
                        } catch (IllegalStateException e19) {
                            e = e19;
                            outputStream = null;
                            QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal, error = " + e);
                            if (outputStream != null) {
                            }
                            if (!z16) {
                            }
                            uri = insert;
                            if (IntimateInfoShareHelper.this.f178110b == null) {
                            }
                        } catch (OutOfMemoryError e26) {
                            e = e26;
                            outputStream = null;
                            QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal, error = " + e);
                            if (outputStream != null) {
                            }
                            if (!z16) {
                            }
                            uri = insert;
                            if (IntimateInfoShareHelper.this.f178110b == null) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (outputStream2 != null) {
                            }
                            throw th;
                        }
                    } else {
                        openOutputStream = null;
                    }
                    if (openOutputStream != null) {
                        try {
                            z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 75, openOutputStream);
                        } catch (FileNotFoundException e27) {
                            e = e27;
                            Object obj = e;
                            outputStream = openOutputStream;
                            e = obj;
                            QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal, error = " + e);
                            if (outputStream != null) {
                            }
                            if (!z16) {
                            }
                            uri = insert;
                            if (IntimateInfoShareHelper.this.f178110b == null) {
                            }
                        } catch (IllegalStateException e28) {
                            e = e28;
                            Object obj2 = e;
                            outputStream = openOutputStream;
                            e = obj2;
                            QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal, error = " + e);
                            if (outputStream != null) {
                            }
                            if (!z16) {
                            }
                            uri = insert;
                            if (IntimateInfoShareHelper.this.f178110b == null) {
                            }
                        } catch (OutOfMemoryError e29) {
                            e = e29;
                            Object obj22 = e;
                            outputStream = openOutputStream;
                            e = obj22;
                            QLog.e("IntimateInfoShareHelper", 1, "saveBitmapFileReal, error = " + e);
                            if (outputStream != null) {
                            }
                            if (!z16) {
                            }
                            uri = insert;
                            if (IntimateInfoShareHelper.this.f178110b == null) {
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            outputStream2 = openOutputStream;
                            if (outputStream2 != null) {
                            }
                            throw th;
                        }
                    }
                    if (openOutputStream != null) {
                        try {
                            openOutputStream.close();
                        } catch (IOException e36) {
                            e = e36;
                            sb5 = new StringBuilder();
                            sb5.append("saveBitmapFileReal finally, error = ");
                            sb5.append(e);
                            QLog.e("IntimateInfoShareHelper", 1, sb5.toString());
                            if (!z16) {
                            }
                            uri = insert;
                            if (IntimateInfoShareHelper.this.f178110b == null) {
                            }
                        }
                    }
                    if (!z16 && insert != null) {
                        py3.b.e(contentResolver, insert, null, null);
                    }
                    uri = insert;
                }
                if (IntimateInfoShareHelper.this.f178110b == null) {
                    return;
                }
                IntimateInfoShareHelper.this.f178110b.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z16) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(uri);
                            IntimateInfoShareHelper.this.f178110b.sendBroadcast(intent);
                            QQToast.makeText(IntimateInfoShareHelper.this.f178110b, 2, IntimateInfoShareHelper.this.f178110b.getString(R.string.cwj), 1).show(IntimateInfoShareHelper.this.f178110b.getTitleBarHeight());
                            return;
                        }
                        QQToast.makeText(IntimateInfoShareHelper.this.f178110b, 1, IntimateInfoShareHelper.this.f178110b.getString(R.string.f174752wp), 1).show(IntimateInfoShareHelper.this.f178110b.getTitleBarHeight());
                    }
                });
            }
        });
    }

    public void S(int i3, int i16, long j3) {
        this.f178115g = i3;
        this.f178116h = i16;
        this.f178117i = j3;
    }

    public void T() {
        this.f178118j = true;
    }

    public void X() {
        if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("relationship_close")) {
            Z();
        } else {
            Y();
        }
    }

    public Bitmap s(Bitmap bitmap) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Bitmap createBitmap = Bitmap.createBitmap(R(this.f178114f, 750, 1272), 0, 1100, 750, 172);
        Canvas canvas = new Canvas(copy);
        canvas.drawBitmap(createBitmap, 0.0f, 1100.0f, (Paint) null);
        Bitmap w3 = w();
        if (w3 != null) {
            canvas.drawBitmap(w3, 40.0f, 1125.0f, (Paint) null);
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(24.0f);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(Color.parseColor("#878B99"));
        StaticLayout staticLayout = new StaticLayout(f178108o.replace("\uff0c", "\uff0c\r\n"), textPaint, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        canvas.save();
        canvas.translate(152.0f, 1125.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        canvas.drawBitmap(R(BitmapFactory.decodeResource(this.f178110b.getResources(), R.drawable.f160886cs1), 194, 40), 512.0f, 1185.0f, (Paint) null);
        return copy;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String t(Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        String str = "temp_intimate_share_" + System.currentTimeMillis() + this.f178111c.getCurrentAccountUin() + ".jpg";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "intimate").getAbsolutePath()));
        file.mkdirs();
        BufferedOutputStream bufferedOutputStream2 = null;
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), str);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                file2.delete();
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IntimateInfoShareHelper", 2, e17.getMessage());
                        }
                    }
                    return absolutePath;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.d("IntimateInfoShareHelper", 2, e18.getMessage());
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.d("IntimateInfoShareHelper", 2, e.getMessage());
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e26) {
                        if (QLog.isColorLevel()) {
                            QLog.d("IntimateInfoShareHelper", 2, e26.getMessage());
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    public Bitmap v(IntimateInfo intimateInfo) {
        int parseColor;
        int parseColor2;
        String str;
        int i3;
        Bitmap createBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(R(this.f178114f, 750, 1272), 0.0f, 0.0f, (Paint) null);
        A(canvas);
        int i16 = this.f178115g;
        if (i16 <= 0) {
            i16 = intimateInfo.maskType;
        }
        String C = IntimateHeaderCardUtil.C(i16);
        String B = IntimateHeaderCardUtil.B(i16);
        try {
            parseColor = Color.parseColor(C);
        } catch (Exception unused) {
            parseColor = Color.parseColor("#03081A");
        }
        try {
            parseColor2 = Color.parseColor(B);
        } catch (Exception unused2) {
            parseColor2 = Color.parseColor("#878B99");
        }
        String string = this.f178110b.getResources().getString(R.string.f161271x_);
        if ((this.f178117i & 64) != 0) {
            str = string + IntimateHeaderCardUtil.o(this.f178115g, this.f178116h) + "\u3002";
        } else {
            str = string + IntimateHeaderCardUtil.o(this.f178115g, 0) + "\u3002";
        }
        String A = IntimateHeaderCardUtil.A(i16);
        if (TextUtils.isEmpty(A)) {
            A = "QQ\u4eb2\u5bc6\u5173\u7cfb";
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(parseColor);
        textPaint.setTextSize(80.0f);
        textPaint.setTextAlign(Paint.Align.LEFT);
        z(canvas, str, textPaint);
        Resources resources = this.f178110b.getResources();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(resources.getString(R.string.byz));
        sb5.append("\r\n");
        sb5.append(resources.getString(R.string.f171044bz0));
        sb5.append("\r\n");
        List<IntimateInfo.CommonTroopInfo> list = intimateInfo.commonTroopInfoList;
        if (list != null && list.size() > 0) {
            sb5.append(resources.getString(R.string.byu));
            sb5.append(this.f178109a.commonTroopInfoList.size());
            sb5.append(resources.getString(R.string.byi));
            sb5.append("\r\n");
            i3 = 2;
        } else {
            i3 = 3;
        }
        List<IntimateInfo.DNAInfo> list2 = intimateInfo.dnaInfoList;
        if (list2 != null && list2.size() > 0 && intimateInfo.dnaInfoList.size() < i3) {
            i3 = intimateInfo.dnaInfoList.size();
        }
        List<IntimateInfo.DNAInfo> list3 = intimateInfo.dnaInfoList;
        if (list3 != null && list3.size() > 0) {
            for (int i17 = 0; i17 < i3; i17++) {
                sb5.append(intimateInfo.dnaInfoList.get(i17).wording.replaceAll("\uff0c", "\uff0c\r\n"));
                sb5.append("\r\n");
            }
        }
        sb5.append(resources.getString(R.string.f171045bz1));
        sb5.append("\r\n");
        sb5.append(resources.getString(R.string.f171046bz2));
        textPaint.setColor(parseColor2);
        textPaint.setTextSize(24.0f);
        StaticLayout staticLayout = new StaticLayout(sb5, textPaint, 450, Layout.Alignment.ALIGN_NORMAL, 1.7f, 0.0f, true);
        canvas.save();
        canvas.translate(152.0f, 560.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        y(canvas, A, parseColor2);
        return createBitmap;
    }

    public Bitmap w() {
        String str = "https://ti.qq.com/open_qq/newIndex.html?url=mqqapi%3A%2F%2Fuserprofile%2Ffriend_profile_card%3Fsrc_type%3Dweb%26version%3D1.0%26source%3D1%26uin%3D" + this.f178111c.getCurrentUin();
        Hashtable hashtable = new Hashtable();
        hashtable.put(EncodeHintType.MARGIN, 0);
        hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        try {
            BitMatrix encode = new QRCodeWriter().encode(str, 100, 100, hashtable);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i3 = 0; i3 < height; i3++) {
                for (int i16 = 0; i16 < width; i16++) {
                    if (encode.get(i16, i3)) {
                        iArr[(i3 * width) + i16] = -16777216;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        } catch (WriterException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("IntimateInfoShareHelper", 2, "Create QRCode fail");
                return null;
            }
            return null;
        }
    }
}
