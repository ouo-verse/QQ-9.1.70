package com.tencent.mobileqq.zplan.aigc.share;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.av.zplan.avatar.utils.ThreadUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mobileqq.zplan.aigc.utils.SuitOutfitHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\b\u0006*\u0001J\u0018\u0000 62\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J8\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J8\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J0\u0010#\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J(\u0010'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010)\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020-H\u0016J\u0012\u00100\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\u0012\u00104\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00105\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00106\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u00108\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00107\u001a\u00020\nH\u0016J\u0012\u00109\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010:\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016Js\u0010A\u001a\u0004\u0018\u00010\u00062\b\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010\u00062\b\u0010=\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010@\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0004\bA\u0010BR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010CR\u0016\u0010E\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010DR\u0014\u0010F\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010\u001fR\u0018\u0010H\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010GR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010K\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/ag;", "Lcom/tencent/mobileqq/zplan/aigc/share/e;", "Landroid/app/Activity;", "context", "", "B", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "M", "", "dstWidth", "dstHeight", "L", "Landroid/graphics/Canvas;", PM.CANVAS, "", "text", "", HippyTKDListViewAdapter.X, "y", "H", "", "itemBitmaps", "itemBgBitmaps", "scale", UserInfo.SEX_FEMALE, "goodLookBitmap", "veryGoodLookBitmap", "D", "E", "I", "itemBg", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "index", BdhLogUtil.LogTag.Tag_Conn, "J", "backgroundColor", "cornerRadius", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "qrCodeBitmap", "G", "Lcom/tencent/mobileqq/zplan/aigc/share/f;", "shareWithPicView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zplan/aigc/share/m;", "data", "P", "e", "getData", BdhLogUtil.LogTag.Tag_Req, "K", "c", "b", "g", "action", "d", "a", "f", "bgBitmap", "maskBitmap", "avatarBitmap", "", "createTs", "nickName", tl.h.F, "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/util/List;Ljava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/Long;Ljava/lang/String;)Landroid/graphics/Bitmap;", "Lcom/tencent/mobileqq/zplan/aigc/share/f;", "Lcom/tencent/mobileqq/zplan/aigc/share/m;", "suitOutfitShareData", "qrcodeSize", "Landroid/graphics/Bitmap;", "resultBitmap", "resultWithoutQrCodeBitmap", "com/tencent/mobileqq/zplan/aigc/share/ag$c", "Lcom/tencent/mobileqq/zplan/aigc/share/ag$c;", "xhsCallback", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ag implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private f shareWithPicView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SuitOutfitShareData suitOutfitShareData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap resultBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Bitmap resultWithoutQrCodeBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int qrcodeSize = ViewUtils.dip2px(1200.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c xhsCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/ag$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f330548b;

        b(Bitmap bitmap) {
            this.f330548b = bitmap;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ag.this.M(this.f330548b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/ag$c", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements XhsShareHelper.e {
        c() {
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onError(String sessionId, int errorCode, String errorMessage, Throwable throwable) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.e("SuitOutfitSharePresenter", 1, "shareToXHS onError " + errorCode + " " + errorMessage);
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onSuccess(String sessionId) {
            QLog.i("SuitOutfitSharePresenter", 1, "shareToXHS onSuccess");
        }
    }

    private final Bitmap A(Bitmap bitmap, int backgroundColor, float cornerRadius, float scale) {
        int width = (int) (bitmap.getWidth() * scale);
        int height = (int) (bitmap.getHeight() * scale);
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint(1);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(bitmap, (output.getWidth() - bitmap.getWidth()) / 2.0f, (output.getHeight() - bitmap.getHeight()) / 2.0f, paint);
        Intrinsics.checkNotNullExpressionValue(output, "output");
        return output;
    }

    private final boolean B(Activity context) {
        if (!WXShareHelper.b0().e0()) {
            QQToast.makeText(context, context.getString(R.string.f173257ih1), 0).show();
            return false;
        }
        if (WXShareHelper.b0().f0()) {
            return true;
        }
        QQToast.makeText(context, context.getString(R.string.f173258ih2), 0).show();
        return false;
    }

    private final void H(Canvas canvas, String text, float x16, float y16) {
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setTextSize(40.0f);
        canvas.drawText(text, x16, y16, paint);
    }

    private final Bitmap J() {
        SuitOutfitShareData suitOutfitShareData = this.suitOutfitShareData;
        SuitOutfitShareData suitOutfitShareData2 = null;
        if (suitOutfitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
            suitOutfitShareData = null;
        }
        Resources resources = suitOutfitShareData.getApp().getApplicationContext().getResources();
        SuitOutfitHelper suitOutfitHelper = SuitOutfitHelper.f330689a;
        SuitOutfitShareData suitOutfitShareData3 = this.suitOutfitShareData;
        if (suitOutfitShareData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
            suitOutfitShareData3 = null;
        }
        String str = "https://ti.qq.com/new_open_qq/index.html?appid=41&url=" + URLEncoder.encode(suitOutfitHelper.a(suitOutfitShareData3.getFeedId(), SuitOutfitPreviewFragment.SuitOutFitPreviewFromValue.SCHEME.getValue()), "UTF-8");
        QLog.i("SuitOutfitSharePresenter", 1, "qrcode: " + str);
        com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.u e16 = com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.u.f().i(str).h(this.qrcodeSize).f(-16777216).g(BitmapFactory.decodeResource(resources, R.drawable.ihj)).e();
        SuitOutfitShareData suitOutfitShareData4 = this.suitOutfitShareData;
        if (suitOutfitShareData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
        } else {
            suitOutfitShareData2 = suitOutfitShareData4;
        }
        Bitmap i3 = com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.t.i(suitOutfitShareData2.getApp().getApplicationContext(), e16);
        Intrinsics.checkNotNullExpressionValue(i3, "getQrCodeImg(suitOutfitS\u2026ionContext, qrCodeParams)");
        return i3;
    }

    private final Bitmap L(Bitmap bitmap, int dstWidth, int dstHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f16 = dstWidth / width;
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        Bitmap createBitmap = Bitmap.createBitmap(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true), 0, 0, dstWidth, dstHeight);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(scaledBitma\u2026, 0, dstWidth, dstHeight)");
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(final Bitmap bitmap) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.z
            @Override // java.lang.Runnable
            public final void run() {
                ag.N(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void N(Bitmap bitmap) {
        OutputStream outputStream;
        OutputStream openOutputStream;
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        final boolean z16 = false;
        final Uri uri = null;
        OutputStream outputStream2 = null;
        if (!bitmap.isRecycled()) {
            Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContext().contentResolver");
            String str = "zplan_suit_outfit_poster_" + String.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            Uri insert = contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
            try {
                if (insert != null) {
                    try {
                        openOutputStream = contentResolver.openOutputStream(insert);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        outputStream = null;
                        QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    } catch (IllegalStateException e17) {
                        e = e17;
                        outputStream = null;
                        QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        outputStream = null;
                        QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    } catch (Throwable th5) {
                        th = th5;
                        if (outputStream2 != null) {
                        }
                        throw th;
                    }
                } else {
                    openOutputStream = null;
                }
                if (openOutputStream != null) {
                    try {
                        z16 = bitmap.compress(Bitmap.CompressFormat.PNG, 75, openOutputStream);
                    } catch (FileNotFoundException e19) {
                        outputStream = openOutputStream;
                        e = e19;
                        QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e26) {
                                e = e26;
                                sb5 = new StringBuilder();
                                sb5.append("saveToLocalInner finally, error = ");
                                sb5.append(e);
                                QLog.e("SuitOutfitSharePresenter", 1, sb5.toString());
                                if (!z16) {
                                }
                                uri = insert;
                                QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ag.O(z16, uri);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    } catch (IllegalStateException e27) {
                        outputStream = openOutputStream;
                        e = e27;
                        QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e28) {
                                e = e28;
                                sb5 = new StringBuilder();
                                sb5.append("saveToLocalInner finally, error = ");
                                sb5.append(e);
                                QLog.e("SuitOutfitSharePresenter", 1, sb5.toString());
                                if (!z16) {
                                }
                                uri = insert;
                                QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ag.O(z16, uri);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    } catch (OutOfMemoryError e29) {
                        outputStream = openOutputStream;
                        e = e29;
                        QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e36) {
                                e = e36;
                                sb5 = new StringBuilder();
                                sb5.append("saveToLocalInner finally, error = ");
                                sb5.append(e);
                                QLog.e("SuitOutfitSharePresenter", 1, sb5.toString());
                                if (!z16) {
                                    QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner delete file:" + insert);
                                    py3.b.e(contentResolver, insert, null, null);
                                }
                                uri = insert;
                                QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ag.O(z16, uri);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    } catch (Throwable th6) {
                        th = th6;
                        outputStream2 = openOutputStream;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e37) {
                                QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner finally, error = " + e37);
                            }
                        }
                        throw th;
                    }
                }
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (IOException e38) {
                        e = e38;
                        sb5 = new StringBuilder();
                        sb5.append("saveToLocalInner finally, error = ");
                        sb5.append(e);
                        QLog.e("SuitOutfitSharePresenter", 1, sb5.toString());
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                ag.O(z16, uri);
                            }
                        });
                    }
                }
                if (!z16 && insert != null) {
                    QLog.e("SuitOutfitSharePresenter", 1, "saveToLocalInner delete file:" + insert);
                    py3.b.e(contentResolver, insert, null, null);
                }
                uri = insert;
            } catch (Throwable th7) {
                th = th7;
                outputStream2 = outputStream;
            }
        }
        QLog.d("SuitOutfitSharePresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.s
            @Override // java.lang.Runnable
            public final void run() {
                ag.O(z16, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(final ag this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
            if (suitOutfitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
                suitOutfitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_outfit_share_" + suitOutfitShareData.getFeedId() + "_1_1.png", "suit_outfit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.q
                @Override // java.lang.Runnable
                public final void run() {
                    ag.T(c16, this$0, activity);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.r
                @Override // java.lang.Runnable
                public final void run() {
                    ag.U();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(String str, ag this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        SuitOutfitHelper suitOutfitHelper = SuitOutfitHelper.f330689a;
        SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
        if (suitOutfitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
            suitOutfitShareData = null;
        }
        String str2 = (("mqqapi://qcircle/openqqpublish?mediaPath=" + str + "&target=3") + "&WINK_PUBLISH_TASK_ID=zplan-outfit") + "&tianshu_activity_item_value=1";
        String str3 = str2 + "&task_jump_url=" + URLEncoder.encode(suitOutfitHelper.a(suitOutfitShareData.getFeedId(), SuitOutfitPreviewFragment.SuitOutFitPreviewFromValue.LITTLE_WORLD.getValue()), "UTF-8");
        QLog.i("SuitOutfitSharePresenter", 1, "shareToLittleWorld schemeUrl:" + str3);
        QCircleSchemeLauncher.d(activity, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ag this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
            if (suitOutfitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
                suitOutfitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_outfit_share_" + suitOutfitShareData.getFeedId() + "_2_1.png", "suit_outfit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ag.W(c16, activity);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.af
                @Override // java.lang.Runnable
                public final void run() {
                    ag.X();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(final ag this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
            if (suitOutfitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
                suitOutfitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_outfit_share_" + suitOutfitShareData.getFeedId() + "_2_1.png", "suit_outfit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.v
                @Override // java.lang.Runnable
                public final void run() {
                    ag.Z(c16, this$0, activity);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.w
                @Override // java.lang.Runnable
                public final void run() {
                    ag.a0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(String str, ag this$0, Activity activity) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
            QLog.e("SuitOutfitSharePresenter", 1, "shareToQZone failed\uff0c appRuntime is null!");
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = peekAppRuntime.getAccount();
        Intent intent = new Intent();
        SuitOutfitHelper suitOutfitHelper = SuitOutfitHelper.f330689a;
        SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
        if (suitOutfitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
            suitOutfitShareData = null;
        }
        String a16 = suitOutfitHelper.a(suitOutfitShareData.getFeedId(), SuitOutfitPreviewFragment.SuitOutFitPreviewFromValue.QZONE.getValue());
        intent.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, "qzevent_8");
        intent.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, a16);
        String str2 = userInfo.qzone_uin;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
        QZoneHelper.forwardToWriteMood(activity, str2, "", new ArrayList(listOf), null, null, 20001, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ag this$0, final Bitmap bitmap, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
            if (suitOutfitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
                suitOutfitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_outfit_share_" + suitOutfitShareData.getFeedId() + "_1_1.png", "suit_outfit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.t
                @Override // java.lang.Runnable
                public final void run() {
                    ag.d0(c16, i3, bitmap);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.u
                @Override // java.lang.Runnable
                public final void run() {
                    ag.c0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(final ag this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitOutfitShareData suitOutfitShareData = this$0.suitOutfitShareData;
            if (suitOutfitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
                suitOutfitShareData = null;
            }
            String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_outfit_share_" + suitOutfitShareData.getFeedId() + "_1_1.png", "suit_outfit_cache_dir");
            final File file = c16 != null ? new File(c16) : null;
            final Boolean valueOf = file != null ? Boolean.valueOf(file.exists()) : null;
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ag.f0(valueOf, activity, file, this$0);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ag.g0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Boolean bool, Activity activity, File file, ag this$0) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
            QLog.e("SuitOutfitSharePresenter", 1, "shareToXHS failed\uff0c appRuntime is null!");
            return;
        }
        XhsShareHelper xhsShareHelper = new XhsShareHelper();
        if (xhsShareHelper.i("AIGC outfit share", activity)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new XhsShareHelper.c(file, null, null));
            xhsShareHelper.l("AIGC outfit share", new WeakReference<>(activity), new XhsShareHelper.b("", "", arrayListOf), new WeakReference<>(this$0.xhsCallback));
        } else {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToXHS failed\uff0c no support");
        }
    }

    public boolean K() {
        f fVar = this.shareWithPicView;
        if (fVar != null) {
            return fVar.isShowing();
        }
        return false;
    }

    public void P(SuitOutfitShareData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.suitOutfitShareData = data;
    }

    public void Q(f shareWithPicView) {
        Intrinsics.checkNotNullParameter(shareWithPicView, "shareWithPicView");
        this.shareWithPicView = shareWithPicView;
    }

    public void R() {
        f fVar = this.shareWithPicView;
        if (fVar != null) {
            fVar.show();
        }
        f fVar2 = this.shareWithPicView;
        if (fVar2 != null) {
            fVar2.a(this.resultBitmap);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void e(Bitmap bitmap) {
        this.resultBitmap = bitmap;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public SuitOutfitShareData getData() {
        SuitOutfitShareData suitOutfitShareData = this.suitOutfitShareData;
        if (suitOutfitShareData != null) {
            return suitOutfitShareData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("suitOutfitShareData");
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void a(final Activity context) {
        if (context == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "share to XHS failed");
            return;
        }
        final Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToWeChat failed, shareNoQrBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.p
                @Override // java.lang.Runnable
                public final void run() {
                    ag.e0(ag.this, bitmap, context);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void b(final Activity context) {
        if (context == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToQZone failed, activity is null!");
            return;
        }
        final Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToQZone failed, resultBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ag.Y(ag.this, bitmap, context);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void c(final Activity context) {
        if (context == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToQQ failed, activity is null!");
            return;
        }
        final Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToQQ failed, resultBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.x
                @Override // java.lang.Runnable
                public final void run() {
                    ag.V(ag.this, bitmap, context);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void d(Activity context, final int action) {
        if (context != null && B(context)) {
            final Bitmap bitmap = this.resultBitmap;
            if (bitmap == null) {
                QLog.e("SuitOutfitSharePresenter", 1, "shareToWeChat failed, shareNoQrBitmap is null!");
                return;
            } else {
                ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        ag.b0(ag.this, bitmap, action);
                    }
                });
                return;
            }
        }
        QLog.e("SuitOutfitSharePresenter", 1, "shareToWeChat failed");
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void g(final Activity context) {
        if (context == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToLittleWorld failed");
            return;
        }
        final Bitmap bitmap = this.resultWithoutQrCodeBitmap;
        if (bitmap == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "shareToLittleWorld failed, shareNoQrAndHeadBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ag.S(ag.this, bitmap, context);
                }
            });
        }
    }

    private final void D(Canvas canvas, List<Bitmap> itemBitmaps, Bitmap goodLookBitmap, Bitmap veryGoodLookBitmap, float scale) {
        if (itemBitmaps == null || itemBitmaps.isEmpty()) {
            return;
        }
        if (!itemBitmaps.isEmpty()) {
            E(canvas, goodLookBitmap, scale);
        }
        if (itemBitmaps.size() > 3) {
            I(canvas, veryGoodLookBitmap, scale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(boolean z16, Uri uri) {
        if (z16) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            BaseApplication.getContext().sendBroadcast(intent);
            QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(R.string.xbt), 1).show();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.xs7, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(String str, Activity activity) {
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(activity, intent, 21);
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public void f(Activity context) {
        if (context == null) {
            QLog.e("SuitOutfitSharePresenter", 1, "saveToLocal failed");
            return;
        }
        Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QQToastUtil.showQQToast(1, R.string.cwi);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            M(bitmap);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(String str, int i3, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        if (i3 == 9) {
            WXShareHelper.b0().u0(str, bitmap, 0);
            return;
        }
        if (i3 != 10) {
            QLog.d("SuitOutfitSharePresenter", 1, "[shareToWeChat] unexpected action:" + i3);
            return;
        }
        WXShareHelper.b0().u0(str, bitmap, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    private final void F(Canvas canvas, List<Bitmap> itemBitmaps, List<Bitmap> itemBgBitmaps, float scale) {
        IntRange indices;
        if (itemBitmaps == null || itemBgBitmaps == null || itemBgBitmaps.size() < itemBitmaps.size()) {
            return;
        }
        indices = CollectionsKt__CollectionsKt.getIndices(itemBitmaps);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            C(canvas, itemBgBitmaps.get(nextInt), itemBitmaps.get(nextInt), nextInt, scale);
        }
    }

    private final void C(Canvas canvas, Bitmap itemBg, Bitmap item, int index, float scale) {
        float f16;
        int i3;
        float f17;
        int i16 = (int) (60 * scale);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(itemBg, i16, i16, true);
        int i17 = (int) (40 * scale);
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(item, i17, i17, true);
        if (index == 0) {
            f16 = (900 - i16) - (8 * scale);
            i3 = 120;
        } else if (index == 1) {
            f16 = (900 - i16) - (8 * scale);
            i3 = 184;
        } else if (index == 2) {
            f16 = (900 - i16) - (8 * scale);
            i3 = 248;
        } else if (index == 3) {
            f16 = 8 * scale;
            i3 = com.tencent.luggage.wxa.rf.d.CTRL_INDEX;
        } else {
            if (index != 4) {
                f16 = 0.0f;
                f17 = 0.0f;
                canvas.drawBitmap(createScaledBitmap, f16, f17, (Paint) null);
                float f18 = 13 * scale;
                canvas.drawBitmap(createScaledBitmap2, f16 + f18, f17 + f18, (Paint) null);
            }
            f16 = 8 * scale;
            i3 = 423;
        }
        f17 = i3 * scale;
        canvas.drawBitmap(createScaledBitmap, f16, f17, (Paint) null);
        float f182 = 13 * scale;
        canvas.drawBitmap(createScaledBitmap2, f16 + f182, f17 + f182, (Paint) null);
    }

    private final void G(Canvas canvas, Bitmap qrCodeBitmap, float scale) {
        int i3 = (int) (57.8f * scale);
        Bitmap scaledQrBitmap = Bitmap.createScaledBitmap(qrCodeBitmap, i3, i3, true);
        Intrinsics.checkNotNullExpressionValue(scaledQrBitmap, "scaledQrBitmap");
        double d16 = scale * 8.69d;
        canvas.drawBitmap(A(scaledQrBitmap, -1, 0.0f, 1.14f), (float) ((900 - r8.getWidth()) - d16), (float) ((1600 - r8.getHeight()) - d16), (Paint) null);
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.e
    public Bitmap h(Bitmap bgBitmap, Bitmap maskBitmap, Bitmap avatarBitmap, List<Bitmap> itemBitmaps, List<Bitmap> itemBgBitmaps, Bitmap goodLookBitmap, Bitmap veryGoodLookBitmap, Long createTs, String nickName) {
        Intrinsics.checkNotNullParameter(goodLookBitmap, "goodLookBitmap");
        Intrinsics.checkNotNullParameter(veryGoodLookBitmap, "veryGoodLookBitmap");
        if (bgBitmap == null) {
            return null;
        }
        Bitmap L = L(bgBitmap, 900, 1600);
        int width = L.getWidth();
        float f16 = width / 300.0f;
        Bitmap createBitmap = Bitmap.createBitmap(width, L.getHeight(), L.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(L, 0.0f, 0.0f, (Paint) null);
        if (maskBitmap != null) {
            canvas.drawBitmap(maskBitmap, 0.0f, 0.0f, (Paint) null);
        }
        float f17 = 15 * f16;
        H(canvas, "{ " + AIGCHelper.f330685a.A(nickName, 7) + " } \u7684\u4eca\u65e5\u7a7f\u642d", 8 * f16, f17);
        if (createTs != null) {
            H(canvas, com.tencent.mobileqq.zplan.aigc.share.b.f330597a.l(createTs.longValue()), 215 * f16, f17);
        }
        D(canvas, itemBitmaps, goodLookBitmap, veryGoodLookBitmap, f16);
        F(canvas, itemBitmaps, itemBgBitmaps, f16);
        if (avatarBitmap != null) {
            canvas.drawBitmap(avatarBitmap, 0.0f, 0.0f, (Paint) null);
        }
        this.resultWithoutQrCodeBitmap = createBitmap.copy(createBitmap.getConfig(), true);
        G(canvas, J(), f16);
        return createBitmap;
    }

    private final void E(Canvas canvas, Bitmap goodLookBitmap, float scale) {
        canvas.drawBitmap(Bitmap.createScaledBitmap(goodLookBitmap, (int) (86 * scale), (int) (85 * scale), true), (900 - r0) - 5, 64 * scale, (Paint) null);
    }

    private final void I(Canvas canvas, Bitmap veryGoodLookBitmap, float scale) {
        canvas.drawBitmap(Bitmap.createScaledBitmap(veryGoodLookBitmap, (int) (38 * scale), (int) (24 * scale), true), 10 * scale, 339 * scale, (Paint) null);
    }
}
