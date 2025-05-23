package com.tencent.biz.qqcircle.widgets.person;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.p;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.z;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleBase$StUserBusiData;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0002N\u0013B\u001b\u0012\u0006\u0010\u0017\u001a\u00020I\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0017J\b\u0010\u0014\u001a\u00020\u0003H\u0014J\b\u0010\u0015\u001a\u00020\u0003H\u0014J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\b\u0010\u0017\u001a\u00020\bH&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u001a\u001a\u00020\u0003J\u0014\u0010\u001e\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0014R\u0014\u0010\"\u001a\u00020\u001c8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b \u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00100R$\u00106\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\b%\u00103\"\u0004\b4\u00105R$\u0010<\u001a\u0004\u0018\u0001078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\f\u00108\u001a\u0004\b)\u00109\"\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00108R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00108\u00a8\u0006O"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalBaseQrcodeView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "k", "", "start", "end", "", "duration", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "b", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "a", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, h.F, "c", "v", NodeProps.ON_CLICK, "i", "Landroidx/core/util/Consumer;", "", "consumer", "j", "g", "d", "Ljava/lang/String;", "TAG", "Landroid/util/Size;", "kotlin.jvm.PlatformType", "e", "Landroid/util/Size;", "mDefIconSize", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "f", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "()Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "setMFlQrcode", "(Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;)V", "mFlQrcode", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAvatarView", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "()Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "setMShareInfo", "(Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;)V", "mShareInfo", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setMTvNick", "(Landroid/widget/TextView;)V", "mTvNick", BdhLogUtil.LogTag.Tag_Conn, "mTvDes", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "mLLAuthLayout", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "E", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "mIvAuth", UserInfo.SEX_FEMALE, "mTvAuth", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "SaveBitmapRunnable", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public abstract class QFSPersonalBaseQrcodeView extends FrameLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mTvDes;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLLAuthLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private SquareImageView mIvAuth;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mTvAuth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Size mDefIconSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundFrameLayout mFlQrcode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView mAvatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleShareInfo mShareInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTvNick;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalBaseQrcodeView$SaveBitmapRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Landroid/graphics/Bitmap;", "d", "Landroid/graphics/Bitmap;", "mBitmap", "Landroidx/core/util/Consumer;", "", "e", "Landroidx/core/util/Consumer;", "mConsumer", "f", "Ljava/lang/String;", "TAG", "<init>", "(Landroid/graphics/Bitmap;Landroidx/core/util/Consumer;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class SaveBitmapRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Bitmap mBitmap;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Consumer<String> mConsumer;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String TAG;

        public SaveBitmapRunnable(@Nullable Bitmap bitmap, @NotNull Consumer<String> mConsumer) {
            Intrinsics.checkNotNullParameter(mConsumer, "mConsumer");
            this.mBitmap = bitmap;
            this.mConsumer = mConsumer;
            this.TAG = "QFSPersonalBaseQrcodeView";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SaveBitmapRunnable this$0, String filePath) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            this$0.mConsumer.accept(filePath);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mBitmap == null) {
                QLog.d(this.TAG, 1, "saveTempFile bitmap is null");
                return;
            }
            final String str = QCircleRichMediaDownLoadManager.f84360a + "qcircle_qrcode_" + System.currentTimeMillis() + ".png";
            File createNewFile = RFWFileUtils.createNewFile(str);
            RFWSaveUtil.saveBitmapWithCompressFormat(this.mBitmap, createNewFile, Bitmap.CompressFormat.PNG);
            if (createNewFile == null) {
                if (!this.mBitmap.isRecycled()) {
                    this.mBitmap.recycle();
                }
                QLog.d(this.TAG, 1, "saveTempFile file is null");
            } else {
                if (!this.mBitmap.isRecycled()) {
                    this.mBitmap.recycle();
                }
                if (this.mConsumer != null) {
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.person.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSPersonalBaseQrcodeView.SaveBitmapRunnable.b(QFSPersonalBaseQrcodeView.SaveBitmapRunnable.this, str);
                        }
                    });
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalBaseQrcodeView$a;", "Landroidx/core/util/Consumer;", "", "filepath", "", "d", "b", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "Lmqq/util/WeakReference;", "mActivityWR", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a implements Consumer<String> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<Activity> mActivityWR;

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/widgets/person/QFSPersonalBaseQrcodeView$a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "list", "", "list1", "onDenied", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0938a extends QQPermission.BasePermissionsListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f93706b;

            C0938a(String str) {
                this.f93706b = str;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                a.this.d(this.f93706b);
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(@NotNull List<String> list, @NotNull List<Integer> list1) {
                Intrinsics.checkNotNullParameter(list, "list");
                Intrinsics.checkNotNullParameter(list1, "list1");
                super.onDenied(list, list1);
                QCircleToast.h(R.string.f1899140o, 0);
            }
        }

        public a(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.mActivityWR = new WeakReference<>(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(final String filepath) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.person.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPersonalBaseQrcodeView.a.e(filepath);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(String filepath) {
            Intrinsics.checkNotNullParameter(filepath, "$filepath");
            ((IFilePathUtil) QRoute.api(IFilePathUtil.class)).copyImageFileToMediaStorage(filepath);
            QCircleToast.h(R.string.f1899240p, 0);
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull String filepath) {
            Activity activity;
            Intrinsics.checkNotNullParameter(filepath, "filepath");
            WeakReference<Activity> weakReference = this.mActivityWR;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                return;
            }
            z.b(this.mActivityWR.get(), 2, new C0938a(filepath), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalBaseQrcodeView(@NotNull Context c16, @Nullable AttributeSet attributeSet) {
        super(c16, attributeSet);
        Intrinsics.checkNotNullParameter(c16, "c");
        this.TAG = "QFSPersonalBaseORcodeView";
        this.mDefIconSize = n.a(getContext(), R.dimen.d3x);
        h();
    }

    private final Bitmap b(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    private final void k() {
        String str;
        TextView textView;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        if (m()) {
            TextView textView2 = this.mTvDes;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = this.mTvDes;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        QCircleShareInfo qCircleShareInfo = this.mShareInfo;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBStringField = feedCloudMeta$StUser.desc) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && (textView = this.mTvDes) != null) {
            QCircleShareInfo qCircleShareInfo2 = this.mShareInfo;
            Intrinsics.checkNotNull(qCircleShareInfo2);
            textView.setText(qCircleShareInfo2.feed.poster.desc.get());
        }
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private final void l(float start, float end, int duration) {
        RoundFrameLayout roundFrameLayout = this.mFlQrcode;
        if (roundFrameLayout == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(roundFrameLayout, c.f123400v, start, end);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(mFlQrcode, \"alpha\", start, end)");
        ofFloat.setDuration(duration);
        ofFloat.start();
    }

    private final boolean m() {
        byte[] bArr;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        if (this.mLLAuthLayout == null || this.mIvAuth == null || this.mTvAuth == null) {
            return false;
        }
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
        try {
            QCircleShareInfo qCircleShareInfo = this.mShareInfo;
            if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBBytesField = feedCloudMeta$StUser.busiData) != null && (byteStringMicro = pBBytesField.get()) != null) {
                bArr = byteStringMicro.toByteArray();
            } else {
                bArr = null;
            }
            qQCircleBase$StUserBusiData.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(this.TAG, 1, "mergeFrom StUserBusiData error");
            e16.printStackTrace();
        }
        if (qQCircleBase$StUserBusiData.certification.get() == 0) {
            LinearLayout linearLayout = this.mLLAuthLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            return false;
        }
        String d16 = p.d(qQCircleBase$StUserBusiData);
        String e17 = p.e(qQCircleBase$StUserBusiData);
        if (TextUtils.isEmpty(e17)) {
            LinearLayout linearLayout2 = this.mLLAuthLayout;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            return false;
        }
        QLog.i(this.TAG, 1, "setAuthIcon: " + e17);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setEnableAutoDeleteLocalCache(false).setUrl(d16).setTargetView(this.mIvAuth));
        TextView textView = this.mTvAuth;
        if (textView != null) {
            textView.setText(e17);
        }
        LinearLayout linearLayout3 = this.mLLAuthLayout;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        return true;
    }

    @SuppressLint({"SetTextI18n"})
    public void a(@Nullable QCircleShareInfo shareInfo) {
        this.mShareInfo = shareInfo;
        if (shareInfo != null) {
            Intrinsics.checkNotNull(shareInfo);
            if (shareInfo.feed != null) {
                QCircleAvatarView qCircleAvatarView = this.mAvatarView;
                if (qCircleAvatarView != null) {
                    QCircleShareInfo qCircleShareInfo = this.mShareInfo;
                    Intrinsics.checkNotNull(qCircleShareInfo);
                    qCircleAvatarView.setAvatar(qCircleShareInfo.feed.poster, this.mDefIconSize);
                }
                TextView textView = this.mTvNick;
                if (textView != null) {
                    QCircleShareInfo qCircleShareInfo2 = this.mShareInfo;
                    Intrinsics.checkNotNull(qCircleShareInfo2);
                    textView.setText(qCircleShareInfo2.feed.poster.nick.get());
                }
                k();
            }
        }
    }

    public abstract int c();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: d, reason: from getter */
    public final RoundFrameLayout getMFlQrcode() {
        return this.mFlQrcode;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final QCircleShareInfo getMShareInfo() {
        return this.mShareInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: f, reason: from getter */
    public final TextView getMTvNick() {
        return this.mTvNick;
    }

    @Nullable
    protected Bitmap g() {
        QCircleAvatarView qCircleAvatarView;
        Bitmap bitmap = null;
        if (this.mFlQrcode != null && (qCircleAvatarView = this.mAvatarView) != null) {
            if (qCircleAvatarView != null) {
                qCircleAvatarView.setDrawingCacheEnabled(true);
            }
            QCircleAvatarView qCircleAvatarView2 = this.mAvatarView;
            if (qCircleAvatarView2 != null) {
                qCircleAvatarView2.buildDrawingCache();
            }
            Bitmap b16 = b(this.mFlQrcode);
            if (b16 == null) {
                return null;
            }
            bitmap = Bitmap.createBitmap(b16);
            if (!b16.isRecycled()) {
                RoundFrameLayout roundFrameLayout = this.mFlQrcode;
                if (roundFrameLayout != null) {
                    roundFrameLayout.setDrawingCacheEnabled(false);
                }
                QCircleAvatarView qCircleAvatarView3 = this.mAvatarView;
                if (qCircleAvatarView3 != null) {
                    qCircleAvatarView3.setDrawingCacheEnabled(false);
                }
                b16.recycle();
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        LayoutInflater.from(getContext()).inflate(c(), (ViewGroup) this, true);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) findViewById(R.id.f41841i6);
        this.mFlQrcode = roundFrameLayout;
        if (roundFrameLayout != null) {
            roundFrameLayout.setRadius(ViewUtils.dip2px(8.0f));
        }
        RoundFrameLayout roundFrameLayout2 = this.mFlQrcode;
        if (roundFrameLayout2 != null) {
            roundFrameLayout2.setEnabled(false);
        }
        this.mTvNick = (TextView) findViewById(R.id.f56522ku);
        this.mTvDes = (TextView) findViewById(R.id.f56042jj);
        QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) findViewById(R.id.f44131oc);
        this.mAvatarView = qCircleAvatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setImageNeedHardware(false);
        }
        RoundFrameLayout roundFrameLayout3 = this.mFlQrcode;
        if (roundFrameLayout3 != null) {
            roundFrameLayout3.setOnClickListener(this);
        }
        this.mLLAuthLayout = (LinearLayout) findViewById(R.id.f45921t7);
        this.mIvAuth = (SquareImageView) findViewById(R.id.f44121ob);
        this.mTvAuth = (TextView) findViewById(R.id.f55932j9);
    }

    public final void i() {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            j(new a((Activity) context));
        }
    }

    public final void j(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        RFWThreadManager.getInstance().execOnFileThread(new SaveBitmapRunnable(g(), consumer));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l(0.0f, 1.0f, 240);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l(1.0f, 0.0f, 120);
    }

    public final void setMShareInfo(@Nullable QCircleShareInfo qCircleShareInfo) {
        this.mShareInfo = qCircleShareInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
    }
}
