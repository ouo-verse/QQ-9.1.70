package com.tencent.mobileqq.zplan.avatar.edit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.avatar.ZPlanAvatarPicEditRecordHelper;
import com.tencent.mobileqq.zplan.avatar.fragment.c;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.record.model.GeneralRecordParams;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import nk3.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0084\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J*\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u001a\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010!\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0002J0\u0010$\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J0\u0010(\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010+\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0002J \u0010/\u001a\u00020%2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002J\"\u00100\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010,\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\nH\u0002JF\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000202j\b\u0012\u0004\u0012\u00020\u0002`32\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000202j\b\u0012\u0004\u0012\u00020\u0002`32\u0006\u00105\u001a\u00020\u0002H\u0002JF\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000202j\b\u0012\u0004\u0012\u00020\u0002`32\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000202j\b\u0012\u0004\u0012\u00020\u0002`32\u0006\u00107\u001a\u00020\u0002H\u0002J\u001a\u0010;\u001a\u0004\u0018\u00010\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\nH\u0002J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\nH\u0002J0\u0010C\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\nH\u0002J \u0010F\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010DJA\u0010L\u001a\u00020\u001b2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010H\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u00010I2\b\u0010K\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bL\u0010MJ\u0006\u0010N\u001a\u00020\u000fJ\u0006\u0010O\u001a\u00020\u000fJ\u0006\u0010P\u001a\u00020\u000fJ\u0006\u0010Q\u001a\u00020\u000fJ\u0006\u0010R\u001a\u00020\u000fJ\u000e\u0010U\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020SJ\u0016\u0010W\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020S2\u0006\u0010V\u001a\u00020\u000fJ\u0016\u0010Z\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020YJ\u0018\u0010\\\u001a\u00020\n2\u0010\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004J\u0018\u0010^\u001a\u0004\u0018\u00010\u00152\u0006\u0010X\u001a\u00020\n2\u0006\u0010]\u001a\u00020\nJ\u000e\u0010_\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010a\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u0015J\u0016\u0010c\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020\n2\u0006\u0010X\u001a\u00020\nJ\u000e\u0010d\u001a\u00020\n2\u0006\u0010X\u001a\u00020\nJ\u000e\u0010e\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\nJ\u000e\u0010f\u001a\u00020\n2\u0006\u0010X\u001a\u00020\nJ\u001e\u0010g\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019J&\u0010h\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019J\u001e\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\b\u0010j\u001a\u0004\u0018\u00010i2\u0006\u0010k\u001a\u00020\u0002J\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020n0\u00132\b\u0010m\u001a\u0004\u0018\u00010iJ\u0018\u0010q\u001a\u00020\u00022\b\u0010j\u001a\u0004\u0018\u00010i2\u0006\u0010p\u001a\u00020\u0002J\u0018\u0010r\u001a\u00020\u00022\b\u0010j\u001a\u0004\u0018\u00010i2\u0006\u0010p\u001a\u00020\u0002J,\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010s\u001a\u00020\u0002J,\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00152\f\u0010v\u001a\b\u0012\u0004\u0012\u00020u0\u00042\u0006\u0010s\u001a\u00020\u0002J\"\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010`\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004J\u0016\u0010z\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\n2\u0006\u0010y\u001a\u00020\nJ0\u0010|\u001a\u00020\n2\u0006\u0010{\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010\u00152\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0002J8\u0010~\u001a\u00020\n2\u0006\u0010{\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010\u00152\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u00022\u0006\u0010}\u001a\u00020\nJ\u000f\u0010\u0080\u0001\u001a\u00020\u00022\u0006\u0010\u007f\u001a\u00020\nJ\u001e\u0010\u0082\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0081\u00012\b\u0010j\u001a\u0004\u0018\u00010iR#\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils;", "", "", "resourceId", "", "resourcesIds", "Lcom/tencent/zplan/meme/Priority;", "priority", "Lcom/tencent/zplan/record/model/GeneralRecordParams;", "T", "", ark.ARKMETADATA_JSON, "", "W", "avatarInfoString", "", "i", "Lorg/json/JSONArray;", "jsonArray", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "avatarData", "recordPath", "saveDir", "Lcom/tencent/mobileqq/zplan/avatar/edit/e;", "listener", "", "Z", "avatarSize", "downloadUrl", "Lcom/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$b;", "downloadListener", "t", "Lcom/tencent/image/RegionDrawable;", "bitmapDrawable", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/Bitmap;", "avatarBitmap", "bgBitmap", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, com.tencent.mobileqq.msf.core.net.r.a.f248963o, "background", "l", MimeHelper.IMAGE_SUBTYPE_BITMAP, "newWidth", "newHeight", "g0", "f0", "editAvatarDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "originActionList", "currId", "o", "loc", "p", "avatarDirSubPath", "curAppearanceKey", HippyTKDListViewAdapter.X, "avatarDirPath", "j0", "path", DomainData.DOMAIN_NAME, "actionId", "currAppearanceKey", "cropType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/zplan/meme/a;", "memeListener", "b0", "avatarDataList", "reqFrom", "Lcom/tencent/mobileqq/zplan/avatar/a;", "avatarRecordListener", "firstScreenCnt", "a0", "(Ljava/util/List;Lcom/tencent/zplan/meme/Priority;ILcom/tencent/mobileqq/zplan/avatar/a;Ljava/lang/Integer;)V", "Y", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", "M", "Lmqq/app/AppRuntime;", "app", "X", "flag", "i0", "uin", "Lcom/tencent/mobileqq/zplan/avatar/edit/f;", "J", "eventTags", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "avatarInfoJSONString", "H", "h0", "editAvatarData", tl.h.F, "byteString", "d0", "y", "c0", "w", "j", "k", "Lorg/json/JSONObject;", "jsonObject", "gender", "I", "avatarRainbowJSONObject", "Lcom/tencent/mobileqq/zplan/avatar/edit/b;", "E", RemoteHandleConst.PARAM_DEFAULT_VALUE, ExifInterface.LATITUDE_SOUTH, "L", "preRecordNumber", "O", "Lnu4/g;", "headConfigs", "P", UserInfo.SEX_FEMALE, "value", "e0", "id", "B", "dirSubPath", BdhLogUtil.LogTag.Tag_Conn, "backgroundUrl", "D", "Ljava/util/concurrent/ConcurrentHashMap;", "v", "Lcom/tencent/zplan/meme/EngineType;", "b", "Lkotlin/Lazy;", "V", "()Lcom/tencent/zplan/meme/EngineType;", "recordTargetEngine", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanEditAvatarUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEditAvatarUtils f331613a = new ZPlanEditAvatarUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy recordTargetEngine;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f331615d;

        a(b bVar) {
            this.f331615d = bVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            this.f331615d.a(false, null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.f331615d.a(false, null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            if (urlDrawable.getCurrDrawable() instanceof RegionDrawable) {
                b bVar = this.f331615d;
                Drawable currDrawable = urlDrawable.getCurrDrawable();
                Intrinsics.checkNotNull(currDrawable, "null cannot be cast to non-null type com.tencent.image.RegionDrawable");
                bVar.a(true, (RegionDrawable) currDrawable);
                return;
            }
            this.f331615d.a(false, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$b;", "", "", "isSucc", "Lcom/tencent/image/RegionDrawable;", "regionDrawable", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(boolean isSucc, RegionDrawable regionDrawable);
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EngineType>() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils$recordTargetEngine$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EngineType invoke() {
                return ZPlanEmoticonUtil.f333176e.h0(ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(ZPlanRecordScene.HEAD_PORTRAIT).getRenderSwitches());
            }
        });
        recordTargetEngine = lazy;
    }

    ZPlanEditAvatarUtils() {
    }

    private final String A(int actionId, String recordPath, String currAppearanceKey, int cropType, String avatarDirPath) {
        c.AvatarCropParam avatarCropParam;
        QLog.i("[ZPlanEditAvatarUtils]", 1, "getAvatarPath, recordPath: " + recordPath + ", actionId: " + actionId);
        if (cropType == 1) {
            avatarCropParam = new c.AvatarCropParam(recordPath, avatarDirPath, 0.0d, 0.15d, 0.0d, 0.0d, currAppearanceKey, actionId, cropType);
        } else {
            avatarCropParam = new c.AvatarCropParam(recordPath, avatarDirPath, 0.0d, 0.3d, 0.15d, 0.15d, currAppearanceKey, actionId, 0);
        }
        return com.tencent.mobileqq.zplan.avatar.fragment.c.f331748a.b(avatarCropParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G() {
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null) {
            QQToast.makeText(baseApplication, 0, "\u4f7f\u7528\u4e2d\u7684\u5934\u50cf\u4e0b\u67b6\u4e86\uff0c\u6362\u4e00\u4e2a\u5427\uff5e", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(f listener, long j3, Map map) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (map != null && !map.isEmpty() && map.containsKey(17)) {
            String str = (String) map.get(17);
            if (str == null) {
                str = "";
            }
            if (str.length() == 0) {
                listener.a(true, null);
                return;
            }
            ZPlanEditAvatarUtils zPlanEditAvatarUtils = f331613a;
            String y16 = zPlanEditAvatarUtils.y(String.valueOf(j3));
            if ((y16.length() > 0) && zPlanEditAvatarUtils.W(str) < zPlanEditAvatarUtils.W(y16)) {
                QLog.e("[ZPlanEditAvatarUtils]", 1, "getEditAvatarInfo local avatarInfo is newer than server info\uff0creset server info");
                if (zPlanEditAvatarUtils.H(String.valueOf(j3), y16) != null) {
                    zPlanEditAvatarUtils.h0(y16);
                    listener.a(false, null);
                    return;
                }
                return;
            }
            d H = zPlanEditAvatarUtils.H(String.valueOf(j3), str);
            if (H == null) {
                listener.a(false, null);
                return;
            } else {
                zPlanEditAvatarUtils.d0(str, String.valueOf(j3));
                listener.a(true, H);
                return;
            }
        }
        listener.a(true, null);
    }

    private final EngineType V() {
        return (EngineType) recordTargetEngine.getValue();
    }

    private final long W(String json) {
        try {
            return new JSONObject(json).optLong("update_time");
        } catch (Exception e16) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, e16, new Object[0]);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String f0(d avatarData, Bitmap bitmap, String saveDir) {
        String url;
        FileOutputStream fileOutputStream;
        File file = new File(BaseApplication.context.getCacheDir(), saveDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        BackgroundInfo backgroundInfo = avatarData.getBackgroundInfo();
        FileOutputStream fileOutputStream2 = null;
        if (backgroundInfo != null && (url = backgroundInfo.getUrl()) != null) {
            File file2 = new File(file, "avatar_" + avatarData.getActionId() + "_" + MD5Utils.toMD5(url) + ".png");
            try {
                if (!file2.exists() && !file2.createNewFile()) {
                    QLog.e("[ZPlanEditAvatarUtils]", 1, "saveBitmapToFile failed, create file error.");
                    return null;
                }
                fileOutputStream = new FileOutputStream(file2);
                try {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        String absolutePath = file2.getAbsolutePath();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                            QLog.e("[ZPlanEditAvatarUtils]", 1, "saveBitmapToFile out close failed.", e16);
                        }
                        return absolutePath;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e17) {
                                QLog.e("[ZPlanEditAvatarUtils]", 1, "saveBitmapToFile out close failed.", e17);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                    QLog.e("[ZPlanEditAvatarUtils]", 1, "saveBitmapToFile failed.", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            QLog.e("[ZPlanEditAvatarUtils]", 1, "saveBitmapToFile out close failed.", e19);
                        }
                    }
                    return null;
                }
            } catch (Exception e26) {
                e = e26;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        }
        return null;
    }

    private final Bitmap g0(Bitmap bitmap, int newWidth, int newHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, \u2026th, height, matrix, true)");
        return createBitmap;
    }

    private final boolean i(String avatarInfoString) {
        QLog.i("[ZPlanEditAvatarUtils]", 1, "checkIsAvatarInfoValid avatarInfoString:" + avatarInfoString);
        try {
            JSONObject jSONObject = new JSONObject(avatarInfoString);
            if (jSONObject.optInt("action_id", -1) < 0) {
                QLog.e("[ZPlanEditAvatarUtils]", 1, "checkIsAvatarInfoValid failed invalid action id");
                return false;
            }
            String optString = jSONObject.optString("background_image_url", "");
            Intrinsics.checkNotNullExpressionValue(optString, "avatarInfoJson.optString\u2026BACKGROUND_IMAGE_URL, \"\")");
            if (optString.length() == 0) {
                QLog.e("[ZPlanEditAvatarUtils]", 1, "checkIsAvatarInfoValid failed invalid action id");
                return false;
            }
            if (jSONObject.optLong("update_time", -1L) < 1) {
                QLog.e("[ZPlanEditAvatarUtils]", 1, "checkIsAvatarInfoValid failed invalid timestamp");
                return false;
            }
            QLog.i("[ZPlanEditAvatarUtils]", 1, "valid avatarInfo string");
            return true;
        } catch (JSONException e16) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "checkIsAvatarInfoValid failed jsonException:" + e16);
            return false;
        }
    }

    private final void j0(String avatarDirPath) {
        File file = new File(avatarDirPath);
        if (file.exists() && file.isDirectory() && file.listFiles().length > 3) {
            di3.b.f393984a.a(avatarDirPath);
        }
    }

    private final Bitmap l(Bitmap foreground, Bitmap background) {
        Bitmap newBitmap = Bitmap.createBitmap(background.getWidth(), background.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        background.setDensity(canvas.getDensity());
        foreground.setDensity(canvas.getDensity());
        canvas.drawBitmap(background, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(foreground, 0.0f, 0.0f, (Paint) null);
        canvas.save();
        canvas.restore();
        Intrinsics.checkNotNullExpressionValue(newBitmap, "newBitmap");
        return newBitmap;
    }

    private final List<Integer> m(JSONArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (jsonArray.get(i3) instanceof Integer) {
                    Object obj = jsonArray.get(i3);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    arrayList.add((Integer) obj);
                }
            }
        }
        return arrayList;
    }

    private final void n(String path) {
        FileUtils.createFileIfNotExits(path + "/.nomedia");
    }

    private final ArrayList<Integer> o(List<d> editAvatarDataList, ArrayList<Integer> originActionList, int currId) {
        Iterator<d> it = editAvatarDataList.iterator();
        while (it.hasNext()) {
            int actionId = it.next().getActionId();
            if (actionId != currId) {
                originActionList.add(Integer.valueOf(actionId));
            }
        }
        return originActionList;
    }

    private final ArrayList<Integer> p(List<d> editAvatarDataList, ArrayList<Integer> originActionList, int loc) {
        int size = editAvatarDataList.size();
        int i3 = (size - 1) - loc;
        if (i3 <= loc) {
            i3 = loc;
        }
        int i16 = 1;
        if (1 <= i3) {
            while (true) {
                int i17 = loc - i16;
                if (i17 >= 0) {
                    originActionList.add(Integer.valueOf(editAvatarDataList.get(i17).getActionId()));
                }
                int i18 = loc + i16;
                if (i18 < size) {
                    originActionList.add(Integer.valueOf(editAvatarDataList.get(i18).getActionId()));
                }
                if (i16 == i3) {
                    break;
                }
                i16++;
            }
        }
        return originActionList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final d avatarData, final Bitmap avatarBitmap, final Bitmap bgBitmap, final String saveDir, final e listener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.n
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEditAvatarUtils.r(avatarBitmap, avatarData, bgBitmap, saveDir, listener);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Bitmap avatarBitmap, d avatarData, Bitmap bgBitmap, String saveDir, e listener) {
        Intrinsics.checkNotNullParameter(avatarBitmap, "$avatarBitmap");
        Intrinsics.checkNotNullParameter(avatarData, "$avatarData");
        Intrinsics.checkNotNullParameter(bgBitmap, "$bgBitmap");
        Intrinsics.checkNotNullParameter(saveDir, "$saveDir");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        QLog.i("[ZPlanEditAvatarUtils]", 1, "[doComposeAvatarWithBitmap] start compose");
        ZPlanEditAvatarUtils zPlanEditAvatarUtils = f331613a;
        String f06 = zPlanEditAvatarUtils.f0(avatarData, zPlanEditAvatarUtils.l(zPlanEditAvatarUtils.g0(avatarBitmap, avatarData.getAvatarSize(), avatarData.getAvatarSize()), zPlanEditAvatarUtils.g0(bgBitmap, avatarData.getAvatarSize(), avatarData.getAvatarSize())), saveDir);
        boolean z16 = f06 == null || f06.length() == 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("composeAvatar success:");
        sb5.append(!z16);
        sb5.append(",path:");
        sb5.append(f06);
        QLog.d("[ZPlanEditAvatarUtils]", 1, sb5.toString());
        listener.a(!(f06 == null || f06.length() == 0), avatarData, f06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(d avatarData, String recordPath, RegionDrawable bitmapDrawable, String saveDir, e listener) {
        QLog.i("[ZPlanEditAvatarUtils]", 1, "[doComposeAvatarWithLocalPath] start decode before compose");
        Bitmap decodeFile = BitmapFactory.decodeFile(recordPath);
        if (decodeFile == null) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "composeAvatar fail decodeFile:" + recordPath);
            listener.a(false, avatarData, null);
            return;
        }
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmapDrawable.bitmap");
        q(avatarData, decodeFile, bitmap, saveDir, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final int avatarSize, final String downloadUrl, final b downloadListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.k
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEditAvatarUtils.u(downloadUrl, downloadListener, avatarSize);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(String downloadUrl, b downloadListener, int i3) {
        Intrinsics.checkNotNullParameter(downloadUrl, "$downloadUrl");
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i3;
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(downloadUrl, obtain);
        if (drawable.getCurrDrawable() instanceof RegionDrawable) {
            Drawable currDrawable = drawable.getCurrDrawable();
            Intrinsics.checkNotNull(currDrawable, "null cannot be cast to non-null type com.tencent.image.RegionDrawable");
            downloadListener.a(true, (RegionDrawable) currDrawable);
        } else {
            drawable.setURLDrawableListener(new a(downloadListener));
            drawable.downloadImediatly();
        }
    }

    private final String x(String avatarDirSubPath, String curAppearanceKey) {
        String avatarDirPath = di3.b.f393984a.c(avatarDirSubPath).getAbsolutePath();
        if (curAppearanceKey.length() == 0) {
            curAppearanceKey = "zplan_default_appearance_key";
        }
        try {
            File file = new File(avatarDirPath, curAppearanceKey);
            if (!file.exists()) {
                Intrinsics.checkNotNullExpressionValue(avatarDirPath, "avatarDirPath");
                j0(avatarDirPath);
                file.mkdirs();
                n(avatarDirPath);
            }
            return file.getAbsolutePath();
        } catch (Exception e16) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "getAvatarFilePath failed.", e16);
            return null;
        }
    }

    public final String B(int id5, String path, d editAvatarData, String currAppearanceKey, int cropType) {
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(currAppearanceKey, "currAppearanceKey");
        if (cropType == 1) {
            str = "zplan/avatar/png_out_cache/";
        } else {
            str = "zplan/avatar/png_normal/";
        }
        return C(id5, path, editAvatarData, currAppearanceKey, cropType, str);
    }

    public final int D(String backgroundUrl) {
        List split$default;
        List split$default2;
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        int i3 = -1;
        if (!TextUtils.isEmpty(backgroundUrl)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) backgroundUrl, new String[]{"/"}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (!(strArr.length == 0)) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) strArr[strArr.length - 1], new String[]{"."}, false, 0, 6, (Object) null);
                Object[] array2 = split$default2.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array2;
                if (strArr2.length == 0) {
                    QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundId error, bgURL invalid, tailStrings empty.");
                    return -1;
                }
                String str = strArr2[0];
                if (TextUtils.isEmpty(str)) {
                    QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundId error, backgroundId tailString invalid.");
                    return -1;
                }
                try {
                    i3 = Integer.parseInt(str);
                } catch (Exception e16) {
                    QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundId failed, parse int error.", e16);
                }
                QLog.i("[ZPlanEditAvatarUtils]", 1, "getBackgroundId from URL, url: " + backgroundUrl + ", id: " + i3);
                return i3;
            }
            QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundId error, bgURL invalid.");
            return -1;
        }
        QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundId error, bgURL null or empty.");
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:7:0x0012, B:9:0x001b, B:11:0x0023, B:13:0x002a, B:15:0x0039, B:17:0x0045, B:20:0x004d, B:25:0x0059), top: B:6:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<BackgroundInfo> E(JSONObject avatarRainbowJSONObject) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (avatarRainbowJSONObject == null) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundList failed, avatarRainbowJSONObject null.");
            return arrayList;
        }
        try {
            JSONArray optJSONArray = avatarRainbowJSONObject.optJSONArray("bg_infos");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    Integer valueOf = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt("id", 0)) : null;
                    String optString = optJSONObject != null ? optJSONObject.optString("url", "") : null;
                    if (valueOf != null && valueOf.intValue() != 0) {
                        if (optString != null && optString.length() != 0) {
                            z16 = false;
                            if (z16) {
                                arrayList.add(new BackgroundInfo(valueOf, optString));
                            }
                        }
                        z16 = true;
                        if (z16) {
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "getBackgroundMap failed.", th5);
        }
        return arrayList;
    }

    public final List<Integer> F(d editAvatarData, List<d> editAvatarDataList) {
        Intrinsics.checkNotNullParameter(editAvatarData, "editAvatarData");
        Intrinsics.checkNotNullParameter(editAvatarDataList, "editAvatarDataList");
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = editAvatarDataList.size();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= size) {
                i16 = -1;
                break;
            }
            if (editAvatarData.getActionId() == editAvatarDataList.get(i16).getActionId()) {
                break;
            }
            i16++;
        }
        if (i16 == -1) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "index\u4e0b\u67b6\uff0c actionId:" + editAvatarData.getActionId());
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.l
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEditAvatarUtils.G();
                }
            });
        } else {
            i3 = i16;
        }
        arrayList.add(Integer.valueOf(editAvatarDataList.get(i3).getActionId()));
        if (ZPlanFeatureSwitch.f369852a.m0()) {
            return o(editAvatarDataList, arrayList, editAvatarData.getActionId());
        }
        return p(editAvatarDataList, arrayList, i3);
    }

    public final void J(final long uin, final f listener) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.mobileqq.zplan.model.c cVar = new com.tencent.mobileqq.zplan.model.c(17, 1);
        IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(cVar);
        iZPlanRequest.requestOidb1127(arrayListOf, uin, 11, new p() { // from class: com.tencent.mobileqq.zplan.avatar.edit.m
            @Override // nk3.p
            public final void a(Map map) {
                ZPlanEditAvatarUtils.K(f.this, uin, map);
            }
        });
    }

    public final boolean M() {
        String d16 = com.tencent.relation.common.config.toggle.c.D.d("preFetchAvatarInfo", "0");
        Intrinsics.checkNotNullExpressionValue(d16, "ZPLAN_AVATAR_SETTING_SWI\u2026E_FETCH_AVATAR_INFO, \"0\")");
        return Integer.parseInt(d16) > 0;
    }

    public final boolean N() {
        String d16 = com.tencent.relation.common.config.toggle.c.D.d("preFetchConfig", "0");
        Intrinsics.checkNotNullExpressionValue(d16, "ZPLAN_AVATAR_SETTING_SWI\u2026AN_PRE_FETCH_CONFIG, \"0\")");
        return Integer.parseInt(d16) > 0;
    }

    public final List<Integer> O(d editAvatarData, List<d> editAvatarDataList, int preRecordNumber) {
        Intrinsics.checkNotNullParameter(editAvatarDataList, "editAvatarDataList");
        ArrayList arrayList = new ArrayList();
        if (preRecordNumber <= 0) {
            return arrayList;
        }
        int size = editAvatarDataList.size();
        if (preRecordNumber <= size) {
            size = preRecordNumber;
        }
        int i3 = 0;
        if (editAvatarData == null) {
            while (i3 < size) {
                arrayList.add(Integer.valueOf(editAvatarDataList.get(i3).getActionId()));
                i3++;
            }
            return arrayList;
        }
        if (ZPlanFeatureSwitch.f369852a.m0()) {
            int actionId = editAvatarData.getActionId();
            QLog.i("[ZPlanEditAvatarUtils]", 1, "getPreRecordActionIdList, enableZPlanCurrAvatarMoveToFirstPos true.");
            arrayList.add(Integer.valueOf(actionId));
            while (i3 < size - 1) {
                if (editAvatarDataList.size() > i3 && editAvatarDataList.get(i3).getActionId() != actionId) {
                    arrayList.add(Integer.valueOf(editAvatarDataList.get(i3).getActionId()));
                    i3++;
                }
            }
            return arrayList;
        }
        arrayList.addAll(F(editAvatarData, editAvatarDataList));
        if (preRecordNumber > arrayList.size()) {
            return arrayList;
        }
        List<Integer> subList = arrayList.subList(0, preRecordNumber);
        Intrinsics.checkNotNullExpressionValue(subList, "actionIdList.subList(0, preRecordNumber)");
        return subList;
    }

    public final List<Integer> P(d editAvatarData, List<nu4.g> headConfigs, int preRecordNumber) {
        int coerceAtMost;
        int actionId;
        Intrinsics.checkNotNullParameter(headConfigs, "headConfigs");
        ArrayList arrayList = new ArrayList();
        if (preRecordNumber > 0 && !headConfigs.isEmpty()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(preRecordNumber, headConfigs.size());
            if (editAvatarData != null && (actionId = editAvatarData.getActionId()) > 0) {
                arrayList.add(Integer.valueOf(actionId));
                coerceAtMost--;
            }
            for (int i3 = 0; i3 < coerceAtMost; i3++) {
                int i16 = headConfigs.get(i3).f421361id;
                if (i16 > 0) {
                    arrayList.add(Integer.valueOf(i16));
                }
            }
        }
        return arrayList;
    }

    public final boolean Q() {
        String d16 = com.tencent.relation.common.config.toggle.c.D.d("preRecordInMall", "0");
        Intrinsics.checkNotNullExpressionValue(d16, "ZPLAN_AVATAR_SETTING_SWI\u2026_PRE_RECORD_IN_MALL, \"0\")");
        return Integer.parseInt(d16) > 0;
    }

    public final boolean R() {
        String d16 = com.tencent.relation.common.config.toggle.c.D.d("preRecordInSummary", "0");
        Intrinsics.checkNotNullExpressionValue(d16, "ZPLAN_AVATAR_SETTING_SWI\u2026E_RECORD_IN_SUMMARY, \"0\")");
        return Integer.parseInt(d16) > 0;
    }

    public final boolean X(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(app.getCurrentUin() + "_zplan_edit_avatar_flag", false);
    }

    public final boolean Y() {
        return com.tencent.relation.common.config.toggle.c.D.g(false);
    }

    public final void a0(List<d> avatarDataList, Priority priority, int reqFrom, com.tencent.mobileqq.zplan.avatar.a avatarRecordListener, Integer firstScreenCnt) {
        Intrinsics.checkNotNullParameter(avatarDataList, "avatarDataList");
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (avatarDataList.isEmpty()) {
            QLog.i("[ZPlanEditAvatarUtils]", 1, "recordEditAvatar batch recordAction avatarDataList null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = avatarDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((d) it.next()).getActionId()));
        }
        QLog.i("[ZPlanEditAvatarUtils]", 1, "recordEditAvatar batch recordAction portraitIds:" + arrayList + " recordTargetEngine:" + V());
        new ZPlanAvatarPicEditRecordHelper(firstScreenCnt, U(this, 0, arrayList, priority, 1, null), avatarRecordListener).c();
    }

    public final void b0(d avatarData, Priority priority, com.tencent.zplan.meme.a memeListener) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(priority, "priority");
        int actionId = avatarData.getActionId();
        QLog.i("[ZPlanEditAvatarUtils]", 1, "recordEditAvatar recordAction, portraitId:" + actionId + ", recordTargetEngine:" + V());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEditAvatarUtils$recordEditAvatar$1(actionId, priority, memeListener, null), 3, null);
    }

    public final void c0(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(uin + "key_zplan_edit_avatar_entry_app_version", subVersion);
    }

    public final void d0(String byteString, String uin) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("[ZPlanEditAvatarUtils]", 1, "saveAvatarInfoToMMKV string: " + byteString);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(uin + "key_zplan_edit_avatar_info", byteString);
    }

    public final void e0(String uin, String value) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(value, "value");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(uin + "key_zplan_edit_avatar_stiker_info", value);
    }

    public final String h(d editAvatarData) {
        int D;
        Integer id5;
        Intrinsics.checkNotNullParameter(editAvatarData, "editAvatarData");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_id", editAvatarData.getActionId());
        jSONObject.put("action_name", editAvatarData.getActionName());
        jSONObject.put("default_url", editAvatarData.getDefaultUrl());
        BackgroundInfo backgroundInfo = editAvatarData.getBackgroundInfo();
        if (backgroundInfo != null) {
            String url = backgroundInfo.getUrl();
            if (backgroundInfo.getId() != null && ((id5 = backgroundInfo.getId()) == null || id5.intValue() != -1)) {
                Integer id6 = backgroundInfo.getId();
                Intrinsics.checkNotNull(id6);
                D = id6.intValue();
            } else {
                D = !(url == null || url.length() == 0) ? f331613a.D(url) : -1;
            }
            if (!(url == null || url.length() == 0)) {
                jSONObject.put("background_image_url", url);
            }
            if (D != -1) {
                jSONObject.put("background_image_id", D);
            }
        }
        jSONObject.put("appearance_key", editAvatarData.getAppearanceKey());
        jSONObject.put("update_time", System.currentTimeMillis());
        if (!Double.isNaN(editAvatarData.getMaskRate())) {
            jSONObject.put("mask_rate", editAvatarData.getMaskRate());
        }
        ClipperInfo inBoundsClipperInfo = editAvatarData.getInBoundsClipperInfo();
        if (inBoundsClipperInfo != null && !Double.isNaN(inBoundsClipperInfo.getStartX()) && !Double.isNaN(inBoundsClipperInfo.getStartY()) && !Double.isNaN(inBoundsClipperInfo.getClipWidth()) && !Double.isNaN(inBoundsClipperInfo.getClipHeight())) {
            jSONObject.put("inbounds_crop_start_x", inBoundsClipperInfo.getStartX());
            jSONObject.put("inbounds_crop_start_y", inBoundsClipperInfo.getStartY());
            jSONObject.put("inbounds_crop_width", inBoundsClipperInfo.getClipWidth());
            jSONObject.put("inbounds_crop_height", inBoundsClipperInfo.getClipHeight());
        }
        ClipperInfo outBoundsClipperInfo = editAvatarData.getOutBoundsClipperInfo();
        if (outBoundsClipperInfo != null && !Double.isNaN(outBoundsClipperInfo.getStartX()) && !Double.isNaN(outBoundsClipperInfo.getStartY()) && !Double.isNaN(outBoundsClipperInfo.getClipWidth()) && !Double.isNaN(outBoundsClipperInfo.getClipHeight())) {
            jSONObject.put("outbounds_crop_start_x", outBoundsClipperInfo.getStartX());
            jSONObject.put("outbounds_crop_start_y", outBoundsClipperInfo.getStartY());
            jSONObject.put("outbounds_crop_width", outBoundsClipperInfo.getClipWidth());
            jSONObject.put("outbounds_crop_height", outBoundsClipperInfo.getClipHeight());
        }
        List<Integer> j3 = editAvatarData.j();
        if (j3 != null) {
            boolean z16 = j3 instanceof List;
            List<Integer> list = z16 ? j3 : null;
            if (!(list == null || list.isEmpty())) {
                if (!z16) {
                    j3 = null;
                }
                jSONObject.put(QZoneShareManager.QZONE_SHARE_EVENT_TAG, JSONUtil.toJson(j3));
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026   }\n        }.toString()");
        QLog.i("[ZPlanEditAvatarUtils]", 1, "assembleAvatarInfoString done string: " + jSONObject2);
        return jSONObject2;
    }

    public final void h0(String avatarInfoString) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(avatarInfoString, "avatarInfoString");
        if (!i(avatarInfoString)) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "[setEditAvatarInfoTo1123] invalid avatarInfo, give up");
            return;
        }
        QLog.i("[ZPlanEditAvatarUtils]", 1, "[setEditAvatarInfoTo1123]");
        com.tencent.mobileqq.zplan.model.b bVar = new com.tencent.mobileqq.zplan.model.b(17, 1, avatarInfoString);
        QRouteApi api = QRoute.api(IZPlanRequest.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanRequest::class.java)");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(bVar);
        IZPlanRequest.a.a((IZPlanRequest) api, arrayListOf, 7, null, 0L, 8, null);
    }

    public final void i0(AppRuntime app, boolean flag) {
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i("[ZPlanEditAvatarUtils]", 1, "setZPlanEditAvatarFlag uin:" + app.getCurrentUin() + " flag:" + flag);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(app.getCurrentUin() + "_zplan_edit_avatar_flag", flag);
    }

    public final void j(d avatarData, String recordPath, e listener) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(recordPath, "recordPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        k(avatarData, recordPath, "zplan/avatars/", listener);
    }

    public final void k(d avatarData, String recordPath, String saveDir, e listener) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(recordPath, "recordPath");
        Intrinsics.checkNotNullParameter(saveDir, "saveDir");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Z(avatarData, recordPath, saveDir, listener);
    }

    public final ConcurrentHashMap<Integer, Integer> v(JSONObject jsonObject) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        if (jsonObject != null) {
            try {
                JSONArray optJSONArray = jsonObject.optJSONArray("action_id_mapping");
                if (optJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"action_id_mapping\")");
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = optJSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject = (JSONObject) obj;
                        String optString = jSONObject.optString("oldId");
                        Intrinsics.checkNotNullExpressionValue(optString, "idMappingJSONObject.optString(\"oldId\")");
                        int parseInt = Integer.parseInt(optString);
                        String optString2 = jSONObject.optString("newId");
                        Intrinsics.checkNotNullExpressionValue(optString2, "idMappingJSONObject.optString(\"newId\")");
                        int parseInt2 = Integer.parseInt(optString2);
                        if (parseInt > 0 && parseInt2 > 0) {
                            concurrentHashMap.put(Integer.valueOf(parseInt), Integer.valueOf(parseInt2));
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("[ZPlanEditAvatarUtils]", 1, "getActionIdMap failed.", e16);
            }
        }
        return concurrentHashMap;
    }

    public final String w(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(uin + "key_zplan_edit_avatar_entry_app_version", "");
    }

    public final String y(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(uin + "key_zplan_edit_avatar_info", "");
    }

    public final String z(List<Integer> eventTags) {
        Integer num;
        if (eventTags == null || !(!eventTags.isEmpty()) || (num = eventTags.get(0)) == null) {
            return "0";
        }
        return num.toString();
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$c", "Lcom/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$b;", "", "isSucc", "Lcom/tencent/image/RegionDrawable;", "bgDrawable", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f331616a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f331617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f331618c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f331619d;

        c(e eVar, d dVar, String str, String str2) {
            this.f331616a = eVar;
            this.f331617b = dVar;
            this.f331618c = str;
            this.f331619d = str2;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils.b
        public void a(boolean isSucc, RegionDrawable bgDrawable) {
            boolean startsWith$default;
            if (isSucc && bgDrawable != null) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.f331618c, "http", false, 2, null);
                if (!startsWith$default) {
                    QLog.i("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] onDownloadFinish recordPath is local path, start compose");
                    ZPlanEditAvatarUtils.f331613a.s(this.f331617b, this.f331618c, bgDrawable, this.f331619d, this.f331616a);
                    return;
                } else {
                    QLog.i("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] onDownloadFinish recordPath is net path, start download");
                    ZPlanEditAvatarUtils.f331613a.t(this.f331617b.getAvatarSize(), this.f331618c, new a(bgDrawable, this.f331616a, this.f331617b, this.f331619d));
                    return;
                }
            }
            QLog.e("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] onDownloadFinish bg isSucc\uff1a" + isSucc + " bgDrawable is null:" + (bgDrawable == null));
            this.f331616a.a(false, this.f331617b, null);
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$c$a", "Lcom/tencent/mobileqq/zplan/avatar/edit/ZPlanEditAvatarUtils$b;", "", "isSucc", "Lcom/tencent/image/RegionDrawable;", "avatarDrawable", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RegionDrawable f331620a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f331621b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f331622c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f331623d;

            a(RegionDrawable regionDrawable, e eVar, d dVar, String str) {
                this.f331620a = regionDrawable;
                this.f331621b = eVar;
                this.f331622c = dVar;
                this.f331623d = str;
            }

            @Override // com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils.b
            public void a(boolean isSucc, RegionDrawable avatarDrawable) {
                if (isSucc && avatarDrawable != null) {
                    ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                    d dVar = this.f331622c;
                    Bitmap bitmap = avatarDrawable.getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "avatarDrawable!!.bitmap");
                    RegionDrawable regionDrawable = this.f331620a;
                    Intrinsics.checkNotNull(regionDrawable);
                    Bitmap bitmap2 = regionDrawable.getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap2, "bgDrawable!!.bitmap");
                    zPlanEditAvatarUtils.q(dVar, bitmap, bitmap2, this.f331623d, this.f331621b);
                    return;
                }
                QLog.e("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] onDownloadFinish avatar isSucc\uff1a" + isSucc + " bgDrawable is null:" + (this.f331620a == null));
                this.f331621b.a(false, this.f331622c, null);
            }
        }
    }

    public final List<d> I(JSONObject jsonObject, int gender) {
        String str;
        ClipperInfo clipperInfo;
        ClipperInfo clipperInfo2;
        if (gender == 1) {
            str = "male_actions";
        } else {
            str = "female_actions";
        }
        ArrayList arrayList = new ArrayList();
        if (jsonObject != null) {
            try {
                JSONArray optJSONArray = jsonObject.optJSONArray(str);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(i)");
                            int optInt = optJSONObject.optInt("id");
                            String optString = optJSONObject.optString("name");
                            String optString2 = optJSONObject.optString("default_url");
                            double optDouble = optJSONObject.optDouble("maskRate", 0.25d);
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("inBoundsClipper");
                            if (optJSONObject2 != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(\"inBoundsClipper\")");
                                clipperInfo = new ClipperInfo(optJSONObject2.optDouble(HippyTKDListViewAdapter.X), optJSONObject2.optDouble("y"), optJSONObject2.optDouble("width"), optJSONObject2.optDouble("height"));
                            } else {
                                clipperInfo = null;
                            }
                            JSONObject optJSONObject3 = optJSONObject.optJSONObject("outBoundsClipper");
                            if (optJSONObject3 != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject3, "optJSONObject(\"outBoundsClipper\")");
                                clipperInfo2 = new ClipperInfo(optJSONObject3.optDouble(HippyTKDListViewAdapter.X), optJSONObject3.optDouble("y"), optJSONObject3.optDouble("width"), optJSONObject3.optDouble("height"));
                            } else {
                                clipperInfo2 = null;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("eventTag");
                            if (optJSONArray2 != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"eventTag\")");
                                int length2 = optJSONArray2.length();
                                for (int i16 = 0; i16 < length2; i16++) {
                                    Object obj = optJSONArray2.get(i16);
                                    if (obj instanceof Integer) {
                                        arrayList2.add(obj);
                                    } else {
                                        QLog.e("[ZPlanEditAvatarUtils]", 1, "avatar config incorrect, get eventTag fail.");
                                    }
                                }
                            }
                            arrayList.add(new d(null, optInt, optString, optString2, null, 0, null, optDouble, clipperInfo, clipperInfo2, arrayList2, null, 2161, null));
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("[ZPlanEditAvatarUtils]", 1, "getEditAvatarDataList failed.", e16);
            }
        }
        return arrayList;
    }

    public final int L(JSONObject jsonObject, int defaultValue) {
        if (jsonObject == null) {
            return defaultValue;
        }
        try {
            return jsonObject.getInt("max_loading_time");
        } catch (JSONException e16) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, e16, new Object[0]);
            return defaultValue;
        }
    }

    public final int S(JSONObject jsonObject, int defaultValue) {
        if (jsonObject == null) {
            return defaultValue;
        }
        try {
            return jsonObject.getInt("pre_rec_num");
        } catch (JSONException e16) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, e16, new Object[0]);
            return defaultValue;
        }
    }

    private final void Z(d avatarData, String recordPath, String saveDir, e listener) {
        if (recordPath == null || recordPath.length() == 0) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] recordPath is null or empty");
            listener.a(false, avatarData, null);
            return;
        }
        if (saveDir == null || saveDir.length() == 0) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] saveDir is null or empty");
            listener.a(false, avatarData, null);
            return;
        }
        BackgroundInfo backgroundInfo = avatarData.getBackgroundInfo();
        if (backgroundInfo != null) {
            String url = backgroundInfo.getUrl();
            if (!(url == null || url.length() == 0)) {
                QLog.i("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] start download bg");
                int avatarSize = avatarData.getAvatarSize();
                String url2 = backgroundInfo.getUrl();
                Intrinsics.checkNotNull(url2);
                t(avatarSize, url2, new c(listener, avatarData, recordPath, saveDir));
                return;
            }
        }
        QLog.i("[ZPlanEditAvatarUtils]", 1, "[prepareBackgroundDrawable] avatarData.backgroundUrl is null or empty \u8ba4\u4e3a\u4e0d\u9700\u8981\u5408\u6210 \u76f4\u63a5\u900f\u660e\u80cc\u666f\u8fd4\u56de");
        listener.a(true, avatarData, recordPath);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0067 A[Catch: Exception -> 0x0122, TryCatch #1 {Exception -> 0x0122, blocks: (B:3:0x002b, B:6:0x005b, B:11:0x0067, B:13:0x0073, B:15:0x00de, B:18:0x00ef, B:20:0x00f5, B:32:0x00fe, B:35:0x00e7), top: B:2:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d H(String uin, String avatarInfoJSONString) {
        String str;
        int optInt;
        String optString;
        String optString2;
        String appearanceKey;
        double optDouble;
        double optDouble2;
        double optDouble3;
        double optDouble4;
        double optDouble5;
        double optDouble6;
        double optDouble7;
        double optDouble8;
        double optDouble9;
        List<Integer> m3;
        BackgroundInfo backgroundInfo;
        boolean z16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(avatarInfoJSONString, "avatarInfoJSONString");
        QLog.i("[ZPlanEditAvatarUtils]", 1, "getEditAvatarData, avatarInfoJSONString: " + avatarInfoJSONString);
        try {
            JSONObject jSONObject = new JSONObject(avatarInfoJSONString);
            optInt = jSONObject.optInt("action_id");
            optString = jSONObject.optString("action_name");
            optString2 = jSONObject.optString("default_url");
            String backgroundImageUrl = jSONObject.optString("background_image_url", "");
            int optInt2 = jSONObject.optInt("background_image_id", -1);
            if (optInt2 == -1) {
                if (backgroundImageUrl != null && backgroundImageUrl.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        ZPlanEditAvatarUtils zPlanEditAvatarUtils = f331613a;
                        Intrinsics.checkNotNullExpressionValue(backgroundImageUrl, "backgroundImageUrl");
                        optInt2 = zPlanEditAvatarUtils.D(backgroundImageUrl);
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
            appearanceKey = jSONObject.optString("appearance_key");
            optDouble = jSONObject.optDouble("mask_rate");
            optDouble2 = jSONObject.optDouble("inbounds_crop_start_x");
            optDouble3 = jSONObject.optDouble("inbounds_crop_start_y");
            optDouble4 = jSONObject.optDouble("inbounds_crop_width");
            optDouble5 = jSONObject.optDouble("inbounds_crop_height");
            optDouble6 = jSONObject.optDouble("outbounds_crop_start_x");
            optDouble7 = jSONObject.optDouble("outbounds_crop_start_y");
            optDouble8 = jSONObject.optDouble("outbounds_crop_width");
            optDouble9 = jSONObject.optDouble("outbounds_crop_height");
            m3 = f331613a.m(jSONObject.optJSONArray(QZoneShareManager.QZONE_SHARE_EVENT_TAG));
            backgroundInfo = new BackgroundInfo(Integer.valueOf(optInt2), backgroundImageUrl);
            Intrinsics.checkNotNullExpressionValue(appearanceKey, "appearanceKey");
            str = "[ZPlanEditAvatarUtils]";
        } catch (Exception e16) {
            e = e16;
            str = "[ZPlanEditAvatarUtils]";
        }
        try {
            return new d(uin, optInt, optString, optString2, backgroundInfo, 0, appearanceKey, optDouble, (Double.isNaN(optDouble4) && Double.isNaN(optDouble5)) ? null : new ClipperInfo(optDouble2, optDouble3, optDouble4, optDouble5), (Double.isNaN(optDouble8) && Double.isNaN(optDouble9)) ? null : new ClipperInfo(optDouble6, optDouble7, optDouble8, optDouble9), m3, null, 2080, null);
        } catch (Exception e17) {
            e = e17;
            QLog.e(str, 1, "[getEditAvatarData] uin:" + uin + ", avatarInfo: " + avatarInfoJSONString + ".", e);
            return null;
        }
    }

    private final GeneralRecordParams T(int resourceId, List<Integer> resourcesIds, Priority priority) {
        ZPlanRecordScene zPlanRecordScene = ZPlanRecordScene.HEAD_PORTRAIT;
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        return new GeneralRecordParams(resourceId, resourcesIds, zPlanRecordScene, 640, 640, null, priority, 0, 1, 3, null, null, null, null, null, 0, null, null, zPlanFeatureSwitch.r2(), zPlanFeatureSwitch.s2(), false, false, false, zPlanFeatureSwitch.g(), true, zPlanFeatureSwitch.w0(), false, null, 208927904, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeneralRecordParams U(ZPlanEditAvatarUtils zPlanEditAvatarUtils, int i3, List list, Priority priority, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        if ((i16 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return zPlanEditAvatarUtils.T(i3, list, priority);
    }

    public final String C(int id5, String path, d editAvatarData, String currAppearanceKey, int cropType, String dirSubPath) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(currAppearanceKey, "currAppearanceKey");
        Intrinsics.checkNotNullParameter(dirSubPath, "dirSubPath");
        QLog.i("[ZPlanEditAvatarUtils]", 4, "getAvatarPathV2, recordPath: " + path + ", actionId: " + id5 + ", cropType: " + cropType);
        String x16 = x(dirSubPath, currAppearanceKey);
        if (x16 == null || x16.length() == 0) {
            QLog.e("[ZPlanEditAvatarUtils]", 1, "getAvatarPathV2 failed, avatarDirPath invalid.");
            return "";
        }
        File file = new File(x16, id5 + ".png");
        if (file.exists()) {
            QLog.i("[ZPlanEditAvatarUtils]", 1, "hit cache! cachePath: " + file.getAbsolutePath());
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheFile.absolutePath");
            return absolutePath;
        }
        ClipperInfo clipperInfo = null;
        if (cropType == 1) {
            if (editAvatarData != null) {
                clipperInfo = editAvatarData.getOutBoundsClipperInfo();
            }
        } else if (editAvatarData != null) {
            clipperInfo = editAvatarData.getInBoundsClipperInfo();
        }
        if (clipperInfo != null && clipperInfo.getClipWidth() > 0.0d && clipperInfo.getClipHeight() > 0.0d) {
            return com.tencent.mobileqq.zplan.avatar.fragment.c.f331748a.c(new AvatarCropV2Param(path, x16, clipperInfo.getStartX(), clipperInfo.getStartY(), clipperInfo.getClipWidth(), clipperInfo.getClipHeight(), currAppearanceKey, id5, cropType));
        }
        return A(id5, path, currAppearanceKey, cropType, x16);
    }
}
