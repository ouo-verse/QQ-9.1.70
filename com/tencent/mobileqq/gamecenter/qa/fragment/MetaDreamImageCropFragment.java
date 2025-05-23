package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PortraitImageview;
import com.tencent.mobileqq.activity.photo.RegionView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.RoundRectImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u008d\u00012\u00020\u0001:\b\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B\t\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020'H\u0002J(\u0010.\u001a\u00020\u00182\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u0004H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0018H\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\u0012\u0010;\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010/H\u0002R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010BR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010XR\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\"0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010XR\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020\"0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010XR\u0016\u0010c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010TR\u0016\u0010e\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010TR\u0016\u0010g\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010TR\u0016\u0010i\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010TR\u0016\u0010k\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010TR\u0016\u0010n\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u0016\u0010r\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010TR\u0016\u0010t\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010TR\u0018\u0010w\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020/0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010XR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010mR\u0018\u0010\u0088\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010TR\u0018\u0010\u008a\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010T\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isWrapContent", "needStatusTrans", "needImmersive", "initView", "Lh", "Ih", "Sh", "Hh", "Mh", "", "position", "Wh", "index", "Ch", "thumbView", "isSelect", "ei", "Jh", "ci", "", "path", "isThumb", "Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$a;", "Dh", "Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$c;", "Eh", "", "reqWidth", "reqHeight", "bitmapWidth", "bitmapHeight", "Gh", "Landroid/graphics/Bitmap;", "Fh", "errorCode", "bi", "Th", "Zh", "Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$d;", "result", "Vh", "Xh", "Yh", MimeHelper.IMAGE_SUBTYPE_BITMAP, "ai", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Button;", "mUploadBtn", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mCancelBtn", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "mThumbListView", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/RelativeLayout;", "mCropContainer", "Lcom/tencent/mobileqq/activity/photo/PortraitImageview;", "G", "Lcom/tencent/mobileqq/activity/photo/PortraitImageview;", "mPortraitImageview", "Lcom/tencent/mobileqq/activity/photo/RegionView;", "H", "Lcom/tencent/mobileqq/activity/photo/RegionView;", "mRegionView", "I", "mCropConfirmBtn", "", "J", "Ljava/util/List;", "mThumbItemViewArray", "K", "mThumbItemThumbViewArray", "L", "mThumbItemConfirmIconArray", "M", "mSrcPathList", "N", "mTargetPathList", "P", "mClipWidth", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mClipHeight", BdhLogUtil.LogTag.Tag_Req, "mTargetWidth", ExifInterface.LATITUDE_SOUTH, "mTargetHeight", "T", "mTargetSampleSize", "U", "Z", "mUseArgb", "V", "mKeepClipInfo", "W", "mMaskShapeType", "X", "mCompressQuality", "Y", "Landroid/graphics/Bitmap;", "mCurrentCropBmp", "mThumbBmpList", "Lmqq/os/MqqHandler;", "a0", "Lmqq/os/MqqHandler;", "mMainHandler", "", "b0", "[Z", "mCropConfirmStatus", "Landroid/app/Dialog;", "c0", "Landroid/app/Dialog;", "mSavingDialog", "d0", "mIsSavingBitmap", "e0", "mCurrentSelectIndex", "f0", "mLastSelectIndex", "<init>", "()V", "g0", "a", "b", "c", "d", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MetaDreamImageCropFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private Button mUploadBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mCancelBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout mThumbListView;

    /* renamed from: F, reason: from kotlin metadata */
    private RelativeLayout mCropContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private PortraitImageview mPortraitImageview;

    /* renamed from: H, reason: from kotlin metadata */
    private RegionView mRegionView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mCropConfirmBtn;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mUseArgb;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mKeepClipInfo;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private Bitmap mCurrentCropBmp;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private MqqHandler mMainHandler;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean[] mCropConfirmStatus;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mSavingDialog;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSavingBitmap;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int mCurrentSelectIndex;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private List<View> mThumbItemViewArray = new ArrayList();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private List<View> mThumbItemThumbViewArray = new ArrayList();

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private List<View> mThumbItemConfirmIconArray = new ArrayList();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private List<String> mSrcPathList = new ArrayList();

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private List<String> mTargetPathList = new ArrayList();

    /* renamed from: P, reason: from kotlin metadata */
    private int mClipWidth = 400;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mClipHeight = 400;

    /* renamed from: R, reason: from kotlin metadata */
    private int mTargetWidth = 400;

    /* renamed from: S, reason: from kotlin metadata */
    private int mTargetHeight = 400;

    /* renamed from: T, reason: from kotlin metadata */
    private int mTargetSampleSize = 1280;

    /* renamed from: W, reason: from kotlin metadata */
    private int mMaskShapeType = 1;

    /* renamed from: X, reason: from kotlin metadata */
    private int mCompressQuality = 100;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private List<Bitmap> mThumbBmpList = new ArrayList();

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int mLastSelectIndex = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "I", "()I", "errorCode", "<init>", "(Landroid/graphics/Bitmap;I)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.fragment.MetaDreamImageCropFragment$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class BitmapDecodeResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Bitmap bitmap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        public BitmapDecodeResult() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* renamed from: b, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BitmapDecodeResult)) {
                return false;
            }
            BitmapDecodeResult bitmapDecodeResult = (BitmapDecodeResult) other;
            if (Intrinsics.areEqual(this.bitmap, bitmapDecodeResult.bitmap) && this.errorCode == bitmapDecodeResult.errorCode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                hashCode = 0;
            } else {
                hashCode = bitmap.hashCode();
            }
            return (hashCode * 31) + this.errorCode;
        }

        @NotNull
        public String toString() {
            return "BitmapDecodeResult(bitmap=" + this.bitmap + ", errorCode=" + this.errorCode + ")";
        }

        public BitmapDecodeResult(@Nullable Bitmap bitmap, int i3) {
            this.bitmap = bitmap;
            this.errorCode = i3;
        }

        public /* synthetic */ BitmapDecodeResult(Bitmap bitmap, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? null : bitmap, (i16 & 2) != 0 ? 0 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Landroid/graphics/Bitmap;", "a", "Ljava/util/List;", "()Ljava/util/List;", "bitmapList", "b", "I", "()I", "errorCode", "<init>", "(Ljava/util/List;I)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.fragment.MetaDreamImageCropFragment$c, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class MultiBitmapDecodeResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<Bitmap> bitmapList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        public MultiBitmapDecodeResult() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        public final List<Bitmap> a() {
            return this.bitmapList;
        }

        /* renamed from: b, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiBitmapDecodeResult)) {
                return false;
            }
            MultiBitmapDecodeResult multiBitmapDecodeResult = (MultiBitmapDecodeResult) other;
            if (Intrinsics.areEqual(this.bitmapList, multiBitmapDecodeResult.bitmapList) && this.errorCode == multiBitmapDecodeResult.errorCode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            List<Bitmap> list = this.bitmapList;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return (hashCode * 31) + this.errorCode;
        }

        @NotNull
        public String toString() {
            return "MultiBitmapDecodeResult(bitmapList=" + this.bitmapList + ", errorCode=" + this.errorCode + ")";
        }

        public MultiBitmapDecodeResult(@Nullable List<Bitmap> list, int i3) {
            this.bitmapList = list;
            this.errorCode = i3;
        }

        public /* synthetic */ MultiBitmapDecodeResult(List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? new ArrayList() : list, (i16 & 2) != 0 ? 0 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "index", "errorCode", "<init>", "(II)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.fragment.MetaDreamImageCropFragment$d, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class SaveBitmapResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SaveBitmapResult() {
            this(r2, r2, 3, null);
            int i3 = 0;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaveBitmapResult)) {
                return false;
            }
            SaveBitmapResult saveBitmapResult = (SaveBitmapResult) other;
            if (this.index == saveBitmapResult.index && this.errorCode == saveBitmapResult.errorCode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.index * 31) + this.errorCode;
        }

        @NotNull
        public String toString() {
            return "SaveBitmapResult(index=" + this.index + ", errorCode=" + this.errorCode + ")";
        }

        public SaveBitmapResult(int i3, int i16) {
            this.index = i3;
            this.errorCode = i16;
        }

        public /* synthetic */ SaveBitmapResult(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/fragment/MetaDreamImageCropFragment$e", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e extends MqqHandler {
        e() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    MetaDreamImageCropFragment.this.Sh();
                    return;
                }
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            MetaDreamImageCropFragment.this.Yh();
                            return;
                        }
                        return;
                    } else {
                        MetaDreamImageCropFragment metaDreamImageCropFragment = MetaDreamImageCropFragment.this;
                        Object obj = msg2.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        metaDreamImageCropFragment.Xh(((Integer) obj).intValue());
                        return;
                    }
                }
                MetaDreamImageCropFragment metaDreamImageCropFragment2 = MetaDreamImageCropFragment.this;
                Object obj2 = msg2.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.gamecenter.qa.fragment.MetaDreamImageCropFragment.SaveBitmapResult");
                metaDreamImageCropFragment2.Vh((SaveBitmapResult) obj2);
                return;
            }
            MetaDreamImageCropFragment metaDreamImageCropFragment3 = MetaDreamImageCropFragment.this;
            Object obj3 = msg2.obj;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            metaDreamImageCropFragment3.bi(((Integer) obj3).intValue());
            FragmentActivity activity = MetaDreamImageCropFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final View Ch(int index) {
        LinearLayout linearLayout = this.mThumbListView;
        boolean[] zArr = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mThumbListView");
            linearLayout = null;
        }
        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
        LinearLayout linearLayout2 = this.mThumbListView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mThumbListView");
            linearLayout2 = null;
        }
        int i3 = 0;
        View itemView = from.inflate(R.layout.fh_, (ViewGroup) linearLayout2, false);
        if (index != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(x.a(11.0f), 0, 0, 0);
            itemView.setLayoutParams(layoutParams);
        }
        RoundRectImageView thumbImgView = (RoundRectImageView) itemView.findViewById(R.id.xku);
        thumbImgView.setImageBitmap(this.mThumbBmpList.get(index));
        boolean z16 = true;
        thumbImgView.setCornerRadiusAndMode(x.a(2.0f), 1);
        Intrinsics.checkNotNullExpressionValue(thumbImgView, "thumbImgView");
        if (this.mCurrentSelectIndex != index) {
            z16 = false;
        }
        ei(thumbImgView, z16);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.xdn);
        boolean[] zArr2 = this.mCropConfirmStatus;
        if (zArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropConfirmStatus");
        } else {
            zArr = zArr2;
        }
        if (!zArr[index]) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return itemView;
    }

    private final BitmapDecodeResult Dh(String path, boolean isThumb) {
        Bitmap.Config config;
        long j3;
        QLog.d("MetaDreamImageCropFragment", 1, "decodeCropImgBmp path:" + path + ", isThumb:" + isThumb);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (this.mUseArgb) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            options.inJustDecodeBounds = true;
            BaseImageUtil.decodeFileWithBufferedStream(path, options);
            long j16 = this.mTargetSampleSize;
            if (isThumb) {
                j3 = 134;
                j16 = 134;
            } else {
                j3 = j16;
            }
            options.inSampleSize = Gh(j16, j3, options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(path, options);
            if (decodeFileWithBufferedStream == null) {
                decodeFileWithBufferedStream = Fh(path);
            }
            Bitmap exifBitmap = ((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(path, decodeFileWithBufferedStream);
            if (exifBitmap == null) {
                QLog.d("MetaDreamImageCropFragment", 1, "decodeCropImgBmp null by oom");
                return new BitmapDecodeResult(null, 1001);
            }
            return new BitmapDecodeResult(exifBitmap, 0);
        } catch (Exception unused) {
            return new BitmapDecodeResult(null, 1002);
        } catch (OutOfMemoryError unused2) {
            return new BitmapDecodeResult(null, 1001);
        }
    }

    private final MultiBitmapDecodeResult Eh() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.mSrcPathList.iterator();
        while (it.hasNext()) {
            BitmapDecodeResult Dh = Dh((String) it.next(), true);
            if (Dh.getErrorCode() != 0) {
                return new MultiBitmapDecodeResult(null, Dh.getErrorCode());
            }
            Bitmap bitmap = Dh.getBitmap();
            Intrinsics.checkNotNull(bitmap);
            arrayList.add(bitmap);
        }
        return new MultiBitmapDecodeResult(arrayList, 0);
    }

    private final Bitmap Fh(String path) {
        Bitmap b16;
        File file = new File(path);
        boolean isSharpP = SharpPUtils.isSharpP(file);
        boolean a16 = com.tencent.qzone.avif.a.a(file);
        QLog.d("MetaDreamImageCropFragment", 1, "decodeSpecialBitmap isSharp:" + isSharpP + ", isAvif:" + a16);
        if (!isSharpP && !a16) {
            return null;
        }
        try {
            if (isSharpP) {
                QLog.d("MetaDreamImageCropFragment", 1, "decodeSpecialBitmap isSharp");
                b16 = SharpPUtils.decodeSharpP(path);
            } else {
                QLog.d("MetaDreamImageCropFragment", 1, "decodeSpecialBitmap isAvif");
                b16 = com.tencent.qzone.image.api.a.c().b(path, null, 0, 0);
            }
            return b16;
        } catch (Exception e16) {
            QLog.e("MetaDreamImageCropFragment", 1, "decodeSpecialBitmap expeption= ", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e("MetaDreamImageCropFragment", 1, "decodeSpecialBitmap, oom=", e17);
            return null;
        }
    }

    private final int Gh(long reqWidth, long reqHeight, long bitmapWidth, long bitmapHeight) {
        int roundToInt;
        int roundToInt2;
        int coerceAtLeast;
        if (reqWidth == 0 || reqHeight == 0 || reqWidth == -1 || reqHeight == -1) {
            return 1;
        }
        long j3 = reqWidth * reqHeight;
        long j16 = bitmapHeight;
        int i3 = 1;
        long j17 = bitmapWidth;
        while (true) {
            if ((j16 <= reqHeight && j17 <= reqWidth) || j17 * j16 <= j3) {
                break;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(((float) j16) / ((float) reqHeight));
            roundToInt2 = MathKt__MathJVMKt.roundToInt(((float) j17) / ((float) reqWidth));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(roundToInt, roundToInt2);
            if (coerceAtLeast < 2) {
                break;
            }
            long j18 = 2;
            j17 /= j18;
            j16 /= j18;
            i3 *= 2;
        }
        return i3;
    }

    private final void Hh() {
        PortraitImageview portraitImageview;
        PortraitImageview portraitImageview2 = new PortraitImageview(getContext());
        this.mPortraitImageview = portraitImageview2;
        portraitImageview2.setRestrict(this.mClipWidth, this.mClipHeight);
        PortraitImageview portraitImageview3 = this.mPortraitImageview;
        RegionView regionView = null;
        if (portraitImageview3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            portraitImageview3 = null;
        }
        portraitImageview3.setImageBitmap(this.mCurrentCropBmp);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        Context context = getContext();
        PortraitImageview portraitImageview4 = this.mPortraitImageview;
        if (portraitImageview4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            portraitImageview = null;
        } else {
            portraitImageview = portraitImageview4;
        }
        this.mRegionView = new RegionView(context, portraitImageview, this.mTargetWidth, this.mTargetHeight, this.mMaskShapeType, this.mUseArgb);
        RelativeLayout relativeLayout = this.mCropContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropContainer");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        RelativeLayout relativeLayout2 = this.mCropContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropContainer");
            relativeLayout2 = null;
        }
        PortraitImageview portraitImageview5 = this.mPortraitImageview;
        if (portraitImageview5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitImageview");
            portraitImageview5 = null;
        }
        relativeLayout2.addView(portraitImageview5, layoutParams);
        RelativeLayout relativeLayout3 = this.mCropContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropContainer");
            relativeLayout3 = null;
        }
        RegionView regionView2 = this.mRegionView;
        if (regionView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRegionView");
        } else {
            regionView = regionView2;
        }
        relativeLayout3.addView(regionView, layoutParams);
    }

    private final void Ih() {
        this.mMainHandler = new e();
    }

    private final void Jh() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                MetaDreamImageCropFragment.Kh(MetaDreamImageCropFragment.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(MetaDreamImageCropFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BitmapDecodeResult Dh = this$0.Dh(this$0.mSrcPathList.get(0), false);
        MqqHandler mqqHandler = null;
        if (Dh.getErrorCode() != 0) {
            QLog.d("MetaDreamImageCropFragment", 1, "initImgData decode crop img failed, errorCode:" + Dh + ".errorCode");
            MqqHandler mqqHandler2 = this$0.mMainHandler;
            if (mqqHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler2 = null;
            }
            mqqHandler2.removeMessages(1);
            MqqHandler mqqHandler3 = this$0.mMainHandler;
            if (mqqHandler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler3 = null;
            }
            Message obtainMessage = mqqHandler3.obtainMessage(1);
            obtainMessage.obj = Integer.valueOf(Dh.getErrorCode());
            MqqHandler mqqHandler4 = this$0.mMainHandler;
            if (mqqHandler4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            } else {
                mqqHandler = mqqHandler4;
            }
            mqqHandler.sendMessage(obtainMessage);
            return;
        }
        this$0.mCurrentCropBmp = Dh.getBitmap();
        MultiBitmapDecodeResult Eh = this$0.Eh();
        if (Eh.getErrorCode() != 0) {
            QLog.d("MetaDreamImageCropFragment", 1, "initImgData decode thumb img failed, errorCode:" + Eh + ".errorCode");
            MqqHandler mqqHandler5 = this$0.mMainHandler;
            if (mqqHandler5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler5 = null;
            }
            mqqHandler5.removeMessages(1);
            MqqHandler mqqHandler6 = this$0.mMainHandler;
            if (mqqHandler6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler6 = null;
            }
            Message obtainMessage2 = mqqHandler6.obtainMessage(1);
            obtainMessage2.obj = Integer.valueOf(Eh.getErrorCode());
            MqqHandler mqqHandler7 = this$0.mMainHandler;
            if (mqqHandler7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            } else {
                mqqHandler = mqqHandler7;
            }
            mqqHandler.sendMessage(obtainMessage2);
            return;
        }
        List<Bitmap> a16 = Eh.a();
        if (a16 != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                this$0.mThumbBmpList.add((Bitmap) it.next());
            }
        }
        MqqHandler mqqHandler8 = this$0.mMainHandler;
        if (mqqHandler8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
        } else {
            mqqHandler = mqqHandler8;
        }
        mqqHandler.sendEmptyMessage(2);
    }

    private final void Lh() {
        Intent intent;
        boolean z16;
        boolean z17;
        QLog.d("MetaDreamImageCropFragment", 1, "initParams");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("MetaDreamImageCropFragment", 1, "initParams pathList invalid");
            QQToast.makeText(BaseApplication.getContext(), "\u672a\u4f20\u5165\u56fe\u7247\u8def\u5f84", 0).show();
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra(PeakConstants.TARGET_PATH);
        if (stringArrayListExtra2 != null && !stringArrayListExtra2.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QLog.d("MetaDreamImageCropFragment", 1, "initParams targetPathList invalid");
            QQToast.makeText(BaseApplication.getContext(), "\u672a\u4f20\u5165\u88c1\u526a\u6587\u4ef6\u8def\u5f84", 0).show();
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        if (stringArrayListExtra.size() != stringArrayListExtra2.size()) {
            QLog.d("MetaDreamImageCropFragment", 1, "initParams path size not match");
            QQToast.makeText(BaseApplication.getContext(), "\u539f\u56fe\u7247\u6570\u91cf\u548c\u88c1\u526a\u6587\u4ef6\u6570\u91cf\u4e0d\u4e00\u81f4", 0).show();
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                activity4.finish();
                return;
            }
            return;
        }
        for (String it : stringArrayListExtra) {
            List<String> list = this.mSrcPathList;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            list.add(it);
        }
        for (String it5 : stringArrayListExtra2) {
            List<String> list2 = this.mTargetPathList;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            list2.add(it5);
        }
        boolean[] zArr = new boolean[this.mTargetPathList.size()];
        this.mCropConfirmStatus = zArr;
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            boolean[] zArr2 = this.mCropConfirmStatus;
            if (zArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropConfirmStatus");
                zArr2 = null;
            }
            zArr2[i3] = false;
        }
        this.mClipWidth = intent.getIntExtra(PeakConstants.CLIP_WIDTH, 400);
        this.mClipHeight = intent.getIntExtra(PeakConstants.CLIP_HEIGHT, 400);
        this.mTargetWidth = intent.getIntExtra(PeakConstants.TARGET_WIDTH, 400);
        this.mTargetHeight = intent.getIntExtra(PeakConstants.TARGET_HEIGHT, 400);
        this.mTargetSampleSize = intent.getIntExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1280);
        this.mUseArgb = intent.getBooleanExtra(PeakConstants.USE_32_BIT_CONFIG, false);
        this.mKeepClipInfo = intent.getBooleanExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, false);
        this.mMaskShapeType = intent.getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
        this.mCompressQuality = intent.getIntExtra(PeakConstants.COMPRESS_QUALITY, 100);
    }

    private final void Mh() {
        int size = this.mThumbBmpList.size();
        for (final int i3 = 0; i3 < size; i3++) {
            View Ch = Ch(i3);
            Ch.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MetaDreamImageCropFragment.Nh(MetaDreamImageCropFragment.this, i3, view);
                }
            });
            LinearLayout linearLayout = this.mThumbListView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mThumbListView");
                linearLayout = null;
            }
            linearLayout.addView(Ch);
            this.mThumbItemViewArray.add(Ch);
            List<View> list = this.mThumbItemThumbViewArray;
            View findViewById = Ch.findViewById(R.id.xku);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.img_thumb)");
            list.add(findViewById);
            List<View> list2 = this.mThumbItemConfirmIconArray;
            View findViewById2 = Ch.findViewById(R.id.xdn);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon_confirmed)");
            list2.add(findViewById2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(MetaDreamImageCropFragment this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Wh(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(MetaDreamImageCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Zh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(MetaDreamImageCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(MetaDreamImageCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(MetaDreamImageCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Th();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh() {
        QLog.d("MetaDreamImageCropFragment", 1, "initView");
        Hh();
        Mh();
    }

    private final void Th() {
        String str;
        Resources resources;
        QLog.d("MetaDreamImageCropFragment", 1, "onConfirmBtnClick mIsSavingBitmap:" + this.mIsSavingBitmap);
        if (this.mIsSavingBitmap) {
            return;
        }
        this.mIsSavingBitmap = false;
        FragmentActivity activity = getActivity();
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (resources = activity2.getResources()) != null) {
            str = resources.getString(R.string.f1652327z);
        } else {
            str = null;
        }
        Dialog showLoadingDialog = DialogUtil.showLoadingDialog(activity, str, false);
        this.mSavingDialog = showLoadingDialog;
        if (showLoadingDialog != null) {
            try {
                showLoadingDialog.show();
            } catch (Exception e16) {
                QLog.e("MetaDreamImageCropFragment", 1, "onConfirmBtnClick show dialog exception=", e16);
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                MetaDreamImageCropFragment.Uh(MetaDreamImageCropFragment.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(MetaDreamImageCropFragment this$0) {
        SaveBitmapResult saveBitmapResult;
        Bitmap a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MqqHandler mqqHandler = null;
        try {
            if (this$0.mKeepClipInfo) {
                RegionView regionView = this$0.mRegionView;
                if (regionView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRegionView");
                    regionView = null;
                }
                a16 = regionView.d();
            } else {
                RegionView regionView2 = this$0.mRegionView;
                if (regionView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRegionView");
                    regionView2 = null;
                }
                a16 = regionView2.a();
            }
            saveBitmapResult = this$0.ai(a16);
        } catch (OutOfMemoryError e16) {
            QLog.d("MetaDreamImageCropFragment", 1, "onConfirmBtnClick oom=", e16);
            saveBitmapResult = new SaveBitmapResult(this$0.mCurrentSelectIndex, 2002);
        }
        MqqHandler mqqHandler2 = this$0.mMainHandler;
        if (mqqHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            mqqHandler2 = null;
        }
        mqqHandler2.removeMessages(3);
        MqqHandler mqqHandler3 = this$0.mMainHandler;
        if (mqqHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            mqqHandler3 = null;
        }
        Message obtainMessage = mqqHandler3.obtainMessage(3);
        obtainMessage.obj = saveBitmapResult;
        MqqHandler mqqHandler4 = this$0.mMainHandler;
        if (mqqHandler4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
        } else {
            mqqHandler = mqqHandler4;
        }
        mqqHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(SaveBitmapResult result) {
        int i3;
        QLog.d("MetaDreamImageCropFragment", 1, "onSaveCropFinish result:" + result);
        try {
            Dialog dialog = this.mSavingDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e16) {
            QLog.e("MetaDreamImageCropFragment", 1, "onSaveCropFinish dialog dismiss exception=", e16);
        }
        if (result.getErrorCode() == 0) {
            if (result.getIndex() >= 0) {
                int index = result.getIndex();
                boolean[] zArr = this.mCropConfirmStatus;
                boolean[] zArr2 = null;
                if (zArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCropConfirmStatus");
                    zArr = null;
                }
                if (index < zArr.length) {
                    boolean[] zArr3 = this.mCropConfirmStatus;
                    if (zArr3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCropConfirmStatus");
                    } else {
                        zArr2 = zArr3;
                    }
                    zArr2[result.getIndex()] = true;
                    this.mThumbItemConfirmIconArray.get(result.getIndex()).setVisibility(0);
                }
            }
            QLog.d("MetaDreamImageCropFragment", 1, "onSaveCropFinish invalid index");
        } else {
            int errorCode = result.getErrorCode();
            if (errorCode != 2001) {
                if (errorCode != 2002) {
                    i3 = R.string.f1652027w;
                } else {
                    i3 = R.string.f1652227y;
                }
            } else {
                i3 = R.string.f1652127x;
            }
            QQToast.makeText(BaseApplication.getContext(), i3, 0).show();
        }
        this.mIsSavingBitmap = false;
    }

    private final void Wh(int position) {
        QLog.d("MetaDreamImageCropFragment", 1, "onThumbItemClick position:" + position + " mCurrentSelectIndex:" + this.mCurrentSelectIndex + " mIsSavingBitmap:" + this.mIsSavingBitmap);
        int i3 = this.mCurrentSelectIndex;
        if (i3 == position) {
            return;
        }
        if (this.mIsSavingBitmap) {
            QQToast.makeText(BaseApplication.getContext(), "\u56fe\u7247\u4fdd\u5b58\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u5207\u6362", 0).show();
            return;
        }
        this.mLastSelectIndex = i3;
        this.mCurrentSelectIndex = position;
        ei(this.mThumbItemThumbViewArray.get(position), true);
        ei(this.mThumbItemThumbViewArray.get(this.mLastSelectIndex), false);
        ci();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(int errorCode) {
        bi(errorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh() {
        Hh();
    }

    private final void Zh() {
        QLog.d("MetaDreamImageCropFragment", 1, "onUploadBtnClick");
        boolean[] zArr = this.mCropConfirmStatus;
        Intent intent = null;
        if (zArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropConfirmStatus");
            zArr = null;
        }
        for (boolean z16 : zArr) {
            if (!z16) {
                QQToast.makeText(BaseApplication.getContext(), R.string.f16524280, 0).show();
                return;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                intent = activity2.getIntent();
            }
            activity.setResult(-1, intent);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SaveBitmapResult ai(Bitmap bitmap) {
        boolean z16 = true;
        QLog.d("MetaDreamImageCropFragment", 1, "saveBitmapToTargetPath");
        if (bitmap == null) {
            return new SaveBitmapResult(this.mCurrentSelectIndex, 2001);
        }
        int i3 = this.mCurrentSelectIndex;
        if (i3 >= 0 && i3 <= this.mTargetPathList.size()) {
            String str = this.mTargetPathList.get(this.mCurrentSelectIndex);
            File file = new File(str);
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    if (!file.exists()) {
                        BaseImageUtil.createNewFile(str);
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, this.mCompressQuality, bufferedOutputStream2);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e16) {
                            QLog.d("MetaDreamImageCropFragment", 1, "saveBitmapToTargetPath exception2=", e16);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = bufferedOutputStream2;
                        QLog.d("MetaDreamImageCropFragment", 1, "saveBitmapToTargetPath exception=", e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e18) {
                                QLog.d("MetaDreamImageCropFragment", 1, "saveBitmapToTargetPath exception2=", e18);
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e19) {
                                QLog.d("MetaDreamImageCropFragment", 1, "saveBitmapToTargetPath exception2=", e19);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
                if (!z16) {
                    return new SaveBitmapResult(this.mCurrentSelectIndex, 0);
                }
                return new SaveBitmapResult(this.mCurrentSelectIndex, 2003);
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return new SaveBitmapResult(this.mCurrentSelectIndex, 2001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(int errorCode) {
        int i3;
        if (errorCode != 1001) {
            if (errorCode != 1002) {
                i3 = R.string.f1651827u;
            } else {
                i3 = R.string.f1651727t;
            }
        } else {
            i3 = R.string.f1651927v;
        }
        QQToast.makeText(BaseApplication.getContext(), i3, 0).show();
    }

    private final void ci() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.i
            @Override // java.lang.Runnable
            public final void run() {
                MetaDreamImageCropFragment.di(MetaDreamImageCropFragment.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(MetaDreamImageCropFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BitmapDecodeResult Dh = this$0.Dh(this$0.mSrcPathList.get(this$0.mCurrentSelectIndex), false);
        MqqHandler mqqHandler = null;
        if (Dh.getErrorCode() != 0) {
            QLog.d("MetaDreamImageCropFragment", 1, "updateCropImg decode crop img failed, errorCode:" + Dh + ".errorCode");
            MqqHandler mqqHandler2 = this$0.mMainHandler;
            if (mqqHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler2 = null;
            }
            mqqHandler2.removeMessages(4);
            MqqHandler mqqHandler3 = this$0.mMainHandler;
            if (mqqHandler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                mqqHandler3 = null;
            }
            Message obtainMessage = mqqHandler3.obtainMessage(4);
            obtainMessage.obj = Integer.valueOf(Dh.getErrorCode());
            MqqHandler mqqHandler4 = this$0.mMainHandler;
            if (mqqHandler4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            } else {
                mqqHandler = mqqHandler4;
            }
            mqqHandler.sendMessage(obtainMessage);
            return;
        }
        this$0.mCurrentCropBmp = Dh.getBitmap();
        MqqHandler mqqHandler5 = this$0.mMainHandler;
        if (mqqHandler5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            mqqHandler5 = null;
        }
        mqqHandler5.removeMessages(5);
        MqqHandler mqqHandler6 = this$0.mMainHandler;
        if (mqqHandler6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
        } else {
            mqqHandler = mqqHandler6;
        }
        mqqHandler.sendEmptyMessage(5);
    }

    private final void ei(View thumbView, boolean isSelect) {
        if (isSelect) {
            ViewGroup.LayoutParams layoutParams = thumbView.getLayoutParams();
            layoutParams.width = x.a(54.0f);
            layoutParams.height = x.a(67.0f);
            thumbView.setLayoutParams(layoutParams);
            int a16 = x.a(2.0f);
            thumbView.setPadding(a16, a16, a16, a16);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = thumbView.getLayoutParams();
        layoutParams2.width = x.a(50.0f);
        layoutParams2.height = x.a(50.0f);
        thumbView.setLayoutParams(layoutParams2);
        thumbView.setPadding(0, 0, 0, 0);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.tho);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.btn_upload)");
        Button button = (Button) findViewById;
        this.mUploadBtn = button;
        TextView textView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUploadBtn");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MetaDreamImageCropFragment.Oh(MetaDreamImageCropFragment.this, view2);
            }
        });
        View findViewById2 = view.findViewById(R.id.afr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.btn_cancel)");
        TextView textView2 = (TextView) findViewById2;
        this.mCancelBtn = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MetaDreamImageCropFragment.Ph(MetaDreamImageCropFragment.this, view2);
            }
        });
        View findViewById3 = view.findViewById(R.id.btn_back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.btn_back)");
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MetaDreamImageCropFragment.Qh(MetaDreamImageCropFragment.this, view2);
            }
        });
        View findViewById4 = view.findViewById(R.id.yjq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.list_thumb)");
        this.mThumbListView = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.u6j);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.container_crop)");
        this.mCropContainer = (RelativeLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.agd);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.btn_confirm)");
        TextView textView3 = (TextView) findViewById6;
        this.mCropConfirmBtn = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropConfirmBtn");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MetaDreamImageCropFragment.Rh(MetaDreamImageCropFragment.this, view2);
            }
        });
        view.findViewById(R.id.f1190175p).getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lh();
        Ih();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fhc, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Jh();
    }
}
