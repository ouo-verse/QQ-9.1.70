package com.tencent.mobileqq.selectfriend.processor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J \u0010\u001e\u001a\u00020\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u001bH\u0014J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001a2\u0006\u0010'\u001a\u00020\rJ\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020(\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u0019R\u0018\u0010>\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00100R\u0018\u0010@\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00100R\u0014\u0010B\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bA\u0010\u0019R\u0016\u0010E\u001a\u0004\u0018\u00010\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/processor/j;", "Lcom/tencent/mobileqq/selectfriend/processor/d;", "", "W", "", "filepath", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "qdialog", "e0", "Landroid/graphics/drawable/Drawable;", "d", "", "showFrame", "", WidgetCacheConstellationData.NUM, "isURLDrawablFoward", "b0", "fixedUrlString", "fileProtocolPrefix", "Ljava/io/File;", "U", "Landroid/os/Parcelable;", "parcelable", BdhLogUtil.LogTag.Tag_Req, "a0", "Z", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "isFromShare", "V", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "g", "finish", "resultRecord", BdhLogUtil.LogTag.Tag_Conn, "count", "Lcom/tencent/mobileqq/activity/SendMultiPictureHelper;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f", "Lcq2/b;", "i", "Lcq2/b;", "mViewHolder", "j", "Ljava/lang/String;", "mForwardThumb", "", "k", "Ljava/util/List;", "mSendMultiPictureHelpers", "Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;", "l", "Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;", "pathHelper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mForwardText", DomainData.DOMAIN_NAME, "o", "mBigURLDrawableUrl", "p", "mURLDrawableUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mEnableImageClick", "T", "()Landroid/graphics/drawable/Drawable;", "uRLDrawable", "Y", "()Z", "isFromGuild", "<init>", "()V", "r", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j extends d {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private cq2.b mViewHolder;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String mForwardThumb;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<SendMultiPictureHelper> mSendMultiPictureHelpers;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private UriParserPathHelper pathHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mForwardText;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isURLDrawablFoward;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String mBigURLDrawableUrl;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String mURLDrawableUrl;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final boolean mEnableImageClick = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/selectfriend/processor/j$b", "Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper$IOnFileCopyFinishListener;", "", "filePath", WadlProxyConsts.PARAM_FILENAME, "", "fileLen", "", "onFinish", "Landroid/net/Uri;", "uri1", "onFaild", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements UriParserPathHelper.IOnFileCopyFinishListener {
        b() {
        }

        @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.IOnFileCopyFinishListener
        public void onFaild(Uri uri1) {
            Intrinsics.checkNotNullParameter(uri1, "uri1");
        }

        @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.IOnFileCopyFinishListener
        public void onFinish(String filePath, String fileName, long fileLen) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            if (j.this.s() != null) {
                j jVar = j.this;
                jVar.mForwardText = cq2.a.f391635a.b(jVar.s(), fileName, fileLen);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(j this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u().putString("EditImagePath", str);
    }

    private final File R(Parcelable parcelable) {
        File a16;
        if (parcelable instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) parcelable;
            int i3 = messageForPic.imageType;
            if (i3 != 3 && i3 != 2000) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardPhotoProcessor", 2, "initPreviewImage msgPic gif.");
            }
            boolean Y = Y();
            if (QLog.isColorLevel()) {
                QLog.d("ForwardPhotoProcessor", 2, "initPreviewImage msgPic gif. isFromGuide=" + Y);
            }
            if (Y) {
                a16 = new File(messageForPic.path);
            } else {
                a16 = AbsDownloader.getFile(URLDrawableHelper.getURL((t) parcelable, 1, null).toString());
            }
        } else if (parcelable instanceof AIOImageData) {
            AIOImageData aIOImageData = (AIOImageData) parcelable;
            int i16 = aIOImageData.P;
            if (i16 != 3 && i16 != 2000) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardPhotoProcessor", 2, "initPreviewImage AIOImageData gif");
            }
            if (aIOImageData.f(2)) {
                a16 = aIOImageData.a(2);
            } else {
                a16 = aIOImageData.f(4) ? aIOImageData.a(4) : null;
            }
            if (a16 == null || !a16.exists()) {
                return null;
            }
        } else {
            return cq2.a.f391635a.c(u());
        }
        return a16;
    }

    private final String S(Uri uri) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardPhotoProcessor", 2, "uri= " + uri);
        }
        if (this.pathHelper == null) {
            this.pathHelper = new UriParserPathHelper(r(), true, new b());
        }
        UriParserPathHelper uriParserPathHelper = this.pathHelper;
        if (uriParserPathHelper != null) {
            return uriParserPathHelper.getPathFromUri(uri);
        }
        return null;
    }

    private final Drawable T() {
        String str;
        this.mBigURLDrawableUrl = u().getString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL);
        this.mURLDrawableUrl = u().getString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL);
        String str2 = this.mBigURLDrawableUrl;
        if (str2 != null && AbsDownloader.hasFile(str2)) {
            str = this.mBigURLDrawableUrl;
        } else {
            str = this.mURLDrawableUrl;
        }
        if (str != null) {
            File U = U(str, HippyBridge.URI_SCHEME_FILE);
            if (U != null && U.exists()) {
                final String absolutePath = U.getAbsolutePath();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.processor.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.O(j.this, absolutePath);
                    }
                });
                URL generateURLForNew = RegionalThumbDownloader.generateURLForNew(absolutePath, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f));
                if (generateURLForNew != null) {
                    str = generateURLForNew.toString();
                }
                if (TextUtils.isEmpty(str)) {
                    str = absolutePath;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("ForwardPhotoProcessor", 2, "getURLDrawable updateImageView  fixedUrlString=" + str);
                }
            }
            try {
                return URLDrawable.getDrawable(str);
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d("ForwardPhotoProcessor", 2, "getURLDrawable fixedUrlString url is illegal = " + e16);
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("ForwardPhotoProcessor", 2, "getURLDrawable isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
        }
        return null;
    }

    private final File U(String fixedUrlString, String fileProtocolPrefix) {
        boolean startsWith$default;
        boolean equals;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = fixedUrlString.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        File file = null;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, fileProtocolPrefix, false, 2, null);
        if (startsWith$default) {
            try {
                String substring = fixedUrlString.substring(0, fileProtocolPrefix.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                equals = StringsKt__StringsJVMKt.equals(substring, fileProtocolPrefix, true);
                if (equals) {
                    String substring2 = fixedUrlString.substring(fileProtocolPrefix.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    file = new File(substring2);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        } else {
            file = AbsDownloader.getFile(AbsDownloader.covertUrlForAioImage(fixedUrlString));
        }
        return (u().getBoolean("forward_source_from_shoot_quick", false) || u().getBoolean("forward_source_from_pre_guide", false)) ? new File(this.mURLDrawableUrl) : file;
    }

    private final void V(List<? extends ResultRecord> targetList, boolean isFromShare) {
        Object obj;
        if (u().getBoolean("isFromShare", false)) {
            u().putString("leftBackText", HardCodeUtil.qqStr(R.string.mp6));
        }
        if (targetList == null) {
            return;
        }
        List<SendMultiPictureHelper> Q = Q(targetList.size());
        ArrayList<String> stringArrayList = u().getStringArrayList("foward_key_m_p_l");
        if (stringArrayList == null && (obj = u().get("android.intent.extra.STREAM")) != null && (obj instanceof ArrayList)) {
            ArrayList arrayList = (ArrayList) obj;
            stringArrayList = new ArrayList<>();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj2 = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj2, "uris[i]");
                String S = S((Uri) obj2);
                if (!TextUtils.isEmpty(S)) {
                    stringArrayList.add(S);
                }
            }
        }
        if (stringArrayList != null && stringArrayList.size() > 0) {
            int size2 = targetList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                ResultRecord resultRecord = targetList.get(i16);
                Q.get(i16).n(resultRecord.groupUin, resultRecord.uin, resultRecord.getUinType(), resultRecord.name, u(), stringArrayList);
            }
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Activity r16 = r();
        Intrinsics.checkNotNull(r16);
        QQToast.makeText(context, 1, r16.getResources().getString(R.string.he7), 0).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void W() {
        Rect rect;
        boolean z16;
        URL url;
        boolean z17;
        boolean z18;
        Parcelable parcelable = u().getParcelable(AppConstants.Key.FORWARD_MSG_FOR_PIC);
        this.mForwardThumb = u().getString(AppConstants.Key.FORWARD_THUMB);
        File R = R(parcelable);
        Rect rect2 = null;
        URL url2 = null;
        if (R != null) {
            try {
                rect = NativeGifImage.getImageSize(R, false);
                try {
                    url2 = R.toURI().toURL();
                    z16 = true;
                } catch (IOException e16) {
                    e = e16;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardPhotoProcessor", 2, "getImageSize " + e);
                    }
                    z16 = false;
                    Rect rect3 = rect;
                    url = url2;
                    rect2 = rect3;
                    z17 = z16;
                    z18 = z17;
                    if (!com.tencent.mobileqq.activity.aio.item.i.f179472c) {
                    }
                    if (!z18) {
                    }
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardPhotoProcessor", 2, "getImageSize oom " + e);
                    }
                    z16 = false;
                    Rect rect32 = rect;
                    url = url2;
                    rect2 = rect32;
                    z17 = z16;
                    z18 = z17;
                    if (!com.tencent.mobileqq.activity.aio.item.i.f179472c) {
                    }
                    if (!z18) {
                    }
                }
            } catch (IOException e18) {
                e = e18;
                rect = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                rect = null;
            }
            Rect rect322 = rect;
            url = url2;
            rect2 = rect322;
            z17 = z16;
        } else {
            z17 = false;
            url = null;
        }
        z18 = z17;
        if (!com.tencent.mobileqq.activity.aio.item.i.f179472c) {
            z18 = false;
        }
        if (!z18) {
            e0(this.mForwardThumb, t());
            if (r() == null) {
                return;
            }
            MqqHandler subThreadHandler = ThreadManager.getSubThreadHandler();
            final Activity r16 = r();
            Intrinsics.checkNotNull(r16);
            subThreadHandler.postDelayed(new Runnable(r16) { // from class: com.tencent.mobileqq.selectfriend.util.FSPhotoHelper$PhotoRunnable

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                private WeakReference<Activity> mActivityWeakReference;

                {
                    Intrinsics.checkNotNullParameter(r16, "activity");
                    this.mActivityWeakReference = new WeakReference<>(r16);
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("FSPhotoHelper", 2, "preload peak");
                    }
                    if (this.mActivityWeakReference.get() != null) {
                        Activity activity = this.mActivityWeakReference.get();
                        Intrinsics.checkNotNull(activity);
                        if (activity.isFinishing()) {
                            return;
                        }
                        ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this.mActivityWeakReference.get());
                    }
                }
            }, 1000L);
            final Activity r17 = r();
            Intrinsics.checkNotNull(r17);
            ThreadManagerV2.executeDelay(new Runnable(r17) { // from class: com.tencent.mobileqq.selectfriend.util.FSPhotoHelper$PhotoRunnable

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                private WeakReference<Activity> mActivityWeakReference;

                {
                    Intrinsics.checkNotNullParameter(r17, "activity");
                    this.mActivityWeakReference = new WeakReference<>(r17);
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("FSPhotoHelper", 2, "preload peak");
                    }
                    if (this.mActivityWeakReference.get() != null) {
                        Activity activity = this.mActivityWeakReference.get();
                        Intrinsics.checkNotNull(activity);
                        if (activity.isFinishing()) {
                            return;
                        }
                        ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this.mActivityWeakReference.get());
                    }
                }
            }, 16, null, true, 3000L);
            return;
        }
        if (rect2 != null && url != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardPhotoProcessor", 2, "initPreviewImagePath load gif start " + url);
            }
            int width = rect2.width();
            int height = rect2.height();
            Activity r18 = r();
            Intrinsics.checkNotNull(r18);
            float f16 = r18.getResources().getDisplayMetrics().densityDpi / 160;
            int i3 = (int) (width * f16);
            int i16 = (int) (height * f16);
            try {
                URLDrawable drawable = URLDrawableHelper.getDrawable(url, i3, i16, new com.tencent.mobileqq.drawable.b(i3, i16), BaseURLDrawableHelper.getFailedDrawable(), true);
                cq2.b bVar = this.mViewHolder;
                Intrinsics.checkNotNull(bVar);
                bVar.g(drawable, true, 0, true);
                cq2.b bVar2 = this.mViewHolder;
                Intrinsics.checkNotNull(bVar2);
                ImageView framePreviewImage = bVar2.getFramePreviewImage();
                if (framePreviewImage != null) {
                    framePreviewImage.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.selectfriend.processor.e
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            boolean X;
                            X = j.X(view, motionEvent);
                            return X;
                        }
                    });
                    return;
                }
                return;
            } catch (OutOfMemoryError e26) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardPhotoProcessor", 2, "initPreviewImage_getDrawable oom " + e26);
                    return;
                }
                return;
            }
        }
        e0(this.mForwardThumb, t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X(View view, MotionEvent motionEvent) {
        return true;
    }

    private final boolean Y() {
        return u() != null && u().getInt(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, 0) == 4;
    }

    private final boolean Z() {
        u().putBoolean("isBack2Root", false);
        boolean z16 = u().getBoolean("sendMultiple", false);
        boolean z17 = u().getBoolean("isFromShare", false);
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + z16 + "isFromShare=" + z17);
        }
        if (z16) {
            V(v(), z17);
            return true;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(r()), null);
        m3.putExtra("KEY_MSG_FORWARD_ID", u().getInt("KEY_MSG_FORWARD_ID", 0));
        AutoSaveUtils.d(true, u().getString(AppConstants.Key.FORWARD_FILEPATH));
        m3.putExtras(u());
        jq3.a.g(m3);
        Activity r16 = r();
        Intrinsics.checkNotNull(r16);
        r16.setResult(-1, m3);
        Activity r17 = r();
        Intrinsics.checkNotNull(r17);
        r17.finish();
        return false;
    }

    private final boolean a0() {
        u().getInt("KEY_MSG_FORWARD_ID", 0);
        MobileQQ.sMobileQQ.peekAppRuntime();
        return false;
    }

    private final void b0(final Drawable d16, final boolean showFrame, final int num, boolean isURLDrawablFoward) {
        Activity r16 = r();
        Intrinsics.checkNotNull(r16);
        r16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.processor.g
            @Override // java.lang.Runnable
            public final void run() {
                j.c0(j.this, d16, showFrame, num);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(j this$0, Drawable d16, boolean z16, int i3) {
        cq2.b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d16, "$d");
        QQCustomDialog t16 = this$0.t();
        Intrinsics.checkNotNull(t16);
        if (!t16.isShowing() || (bVar = this$0.mViewHolder) == null) {
            return;
        }
        Intrinsics.checkNotNull(bVar);
        bVar.g(d16, z16, i3, false);
        if (this$0.mEnableImageClick) {
            return;
        }
        cq2.b bVar2 = this$0.mViewHolder;
        Intrinsics.checkNotNull(bVar2);
        ImageView framePreviewImage = bVar2.getFramePreviewImage();
        if (framePreviewImage != null) {
            framePreviewImage.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.selectfriend.processor.i
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean d06;
                    d06 = j.d0(view, motionEvent);
                    return d06;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void e0(final String filepath, QQCustomDialog qdialog) {
        this.isURLDrawablFoward = u().getBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, false);
        if (QLog.isColorLevel()) {
            QLog.d("ForwardPhotoProcessor", 2, "updateImageView: filepath=" + filepath);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.processor.f
            @Override // java.lang.Runnable
            public final void run() {
                j.f0(j.this, filepath);
            }
        }, 8, null, false);
        if (QLog.isColorLevel()) {
            QLog.d("ForwardPhotoProcessor", 2, "updateImageView end! ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(j this$0, String str) {
        Drawable T;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isURLDrawablFoward) {
            T = cq2.a.f391635a.d(str);
            if (T == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardPhotoProcessor", 2, "updateImageView getNormalDrawable null");
                    return;
                }
                return;
            }
        } else {
            T = this$0.T();
            if (T == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardPhotoProcessor", 2, "updateImageView getURLDrawable null");
                    return;
                }
                return;
            }
        }
        if (this$0.r() != null) {
            cq2.a aVar = cq2.a.f391635a;
            Activity r16 = this$0.r();
            Intrinsics.checkNotNull(r16);
            aVar.a(r16, T, this$0.isURLDrawablFoward);
        }
        ArrayList arrayList = (ArrayList) this$0.u().get("PhotoConst.PHOTO_PATHS");
        this$0.b0(T, true, arrayList != null ? arrayList.size() : 0, this$0.isURLDrawablFoward);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public boolean C(boolean finish, ResultRecord resultRecord) {
        ArrayList<ResultRecord> v3 = v();
        Intrinsics.checkNotNull(v3);
        Iterator<ResultRecord> it = v3.iterator();
        while (it.hasNext()) {
            ResultRecord target = it.next();
            Intrinsics.checkNotNullExpressionValue(target, "target");
            D(target);
        }
        if (u().getBoolean("key_flag_from_plugin", false)) {
            return a0();
        }
        return Z();
    }

    public final List<SendMultiPictureHelper> Q(int count) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < count; i3++) {
            arrayList.add(new SendMultiPictureHelper((BaseActivity) r()));
        }
        if (!arrayList.isEmpty()) {
            if (this.mSendMultiPictureHelpers == null) {
                this.mSendMultiPictureHelpers = new ArrayList();
            }
            List<SendMultiPictureHelper> list = this.mSendMultiPictureHelpers;
            Intrinsics.checkNotNull(list);
            list.addAll(arrayList);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public QQCustomDialog f() {
        QQCustomDialog f16 = super.f();
        if (!TextUtils.isEmpty(this.mForwardThumb) && f16 != null) {
            f16.setMessage((CharSequence) null);
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public View g() {
        View inflate = LayoutInflater.from(r()).inflate(R.layout.f167851jj, (ViewGroup) null);
        cq2.b bVar = new cq2.b();
        this.mViewHolder = bVar;
        Intrinsics.checkNotNull(bVar);
        View findViewById = inflate.findViewById(R.id.bqm);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        bVar.c((TextView) findViewById);
        cq2.b bVar2 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar2);
        View findViewById2 = inflate.findViewById(R.id.fyd);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        bVar2.h((TextView) findViewById2);
        cq2.b bVar3 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar3);
        View findViewById3 = inflate.findViewById(R.id.cla);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        bVar3.f((ImageView) findViewById3);
        cq2.b bVar4 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar4);
        View findViewById4 = inflate.findViewById(R.id.cl_);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        bVar4.e(findViewById4);
        cq2.b bVar5 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar5);
        View findViewById5 = inflate.findViewById(R.id.f164981bj1);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        bVar5.d((TextView) findViewById5);
        cq2.b bVar6 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar6);
        View findViewById6 = inflate.findViewById(R.id.bk_);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.ProgressBar");
        bVar6.i((ProgressBar) findViewById6);
        cq2.b bVar7 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar7);
        View framePreview = bVar7.getFramePreview();
        if (framePreview != null) {
            framePreview.setMinimumHeight(ViewUtils.dip2px(85.0f));
        }
        int dip2px = ViewUtils.dip2px(15.0f);
        inflate.setPadding(0, dip2px, 0, dip2px);
        W();
        ArrayList<String> stringArrayList = u().getStringArrayList("foward_key_m_p_l");
        if (stringArrayList != null) {
            View findViewById7 = inflate.findViewById(R.id.dialogText);
            Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById7;
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.mp_) + stringArrayList.size() + HardCodeUtil.qqStr(R.string.mp7));
        }
        return inflate;
    }
}
