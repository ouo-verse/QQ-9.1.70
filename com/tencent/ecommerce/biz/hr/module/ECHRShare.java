package com.tencent.ecommerce.biz.hr.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.permission.api.PermissionListener;
import com.tencent.ecommerce.base.share.api.ECActionItemClickListener;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.base.share.api.ECQQShareData;
import com.tencent.ecommerce.base.share.api.ECQZoneShareData;
import com.tencent.ecommerce.base.share.api.ECWxShareData;
import com.tencent.ecommerce.base.share.api.ECXhsShareData;
import com.tencent.ecommerce.base.share.api.IECAddShortCutCallback;
import com.tencent.ecommerce.base.share.api.IECShareCallback;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.base.share.api.ShareType;
import com.tencent.ecommerce.base.share.api.ShortCutInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bV\u0010WJO\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002J\"\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002Jq\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\f0\u001bH\u0002JE\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JO\u0010\"\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\r2\b\b\u0002\u0010!\u001a\u00020 H\u0002JM\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020 2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JE\u0010(\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JE\u0010)\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JE\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u001c2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JE\u0010.\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001d2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JE\u0010/\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001d2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002JE\u00101\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u0002002+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002J\f\u00102\u001a\u000200*\u00020\u0004H\u0002J\f\u00103\u001a\u00020\u0004*\u000200H\u0002J\u0016\u00106\u001a\u00020\u0006*\u0002002\b\u00105\u001a\u0004\u0018\u000104H\u0002JG\u00108\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u00107\u001a\u0004\u0018\u00010\u001c2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rJO\u00109\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0003\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\u001c2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rJ\u0018\u0010=\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010;JE\u0010>\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rJ#\u0010?\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001dH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020\u001c8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010J\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MRG\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010T\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/ECHRShare;", "", "Lcom/tencent/ecommerce/biz/hr/module/h;", "bridgeModule", "Lcom/tencent/ecommerce/base/share/api/b;", "shareUserData", "Lcom/tencent/ecommerce/biz/hr/module/l;", "shareContentData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "r", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", HippyHeaderListViewController.VIEW_TAG, "Landroid/graphics/Rect;", "clipArea", "", "scale", "renderCallback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "", "isTimeLine", "u", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/base/share/api/f;", "shareData", "t", "w", "k", "errCode", "errMsg", "g", MimeHelper.IMAGE_SUBTYPE_BITMAP, "l", DomainData.DOMAIN_NAME, "Lorg/json/JSONObject;", "f", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "B", "params", "y", tl.h.F, QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/content/Context;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Ljava/lang/String;", "QZONE_PUBLISH_RESULT_CODE", "b", "I", "QZONE_PUBLISH_RESULT_CODE_PUBLISH_UNKNOWN", "c", "QZONE_PUBLISH_RESULT_CODE_PUBLISH_SUCCEED", "d", "QZONE_PUBLISH_RESULT_CODE_CANCEL_SAVE_DRAFT", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "e", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "shareProxy", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "o", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "currentShareAction", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECHRShare {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int QZONE_PUBLISH_RESULT_CODE_PUBLISH_UNKNOWN = 0;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Function1<Object, Unit> callback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static Integer currentShareAction;

    /* renamed from: h, reason: collision with root package name */
    public static final ECHRShare f102572h = new ECHRShare();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String QZONE_PUBLISH_RESULT_CODE = "PUBLISH_RESULT_CODE";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int QZONE_PUBLISH_RESULT_CODE_PUBLISH_SUCCEED = 1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int QZONE_PUBLISH_RESULT_CODE_CANCEL_SAVE_DRAFT = 2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final IECShareProxy shareProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/hr/module/ECHRShare$a", "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "", "onAllGranted", "", "", "", "result", "onDenied", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements PermissionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f102573a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f102574b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f102575c;

        a(Activity activity, Bitmap bitmap, Function1 function1) {
            this.f102573a = activity;
            this.f102574b = bitmap;
            this.f102575c = function1;
        }

        @Override // com.tencent.ecommerce.base.permission.api.PermissionListener
        public void onAllGranted() {
            ECHRShare.f102572h.n(this.f102573a, this.f102574b, this.f102575c);
        }

        @Override // com.tencent.ecommerce.base.permission.api.PermissionListener
        public void onDenied(Map<String, Boolean> result) {
            ECHRShare.f102572h.g(-1, "no storage permission", this.f102575c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/hr/module/ECHRShare$b", "Lcom/tencent/ecommerce/base/share/api/IECShareCallback;", "", "type", "retCode", "", "onShareCallback", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECShareCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f102577a;

        b(Function1 function1) {
            this.f102577a = function1;
        }

        @Override // com.tencent.ecommerce.base.share.api.IECShareCallback
        public void onShareCallback(String type, String retCode) {
            ECHRShare.f102572h.g(Intrinsics.areEqual(retCode, "0") ? 0 : -1, retCode, this.f102577a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/hr/module/ECHRShare$c", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "", "action", "Lcom/tencent/ecommerce/base/share/api/b;", "data", "", "onItemClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECActionItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f102578a;

        c(Function1 function1) {
            this.f102578a = function1;
        }

        @Override // com.tencent.ecommerce.base.share.api.ECActionItemClickListener
        public void onItemClick(int action, ECActionItemData data) {
            JSONObject A;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("selectedShareAction", action);
            if (data != null && (A = ECHRShare.f102572h.A(data)) != null) {
                jSONObject.put("selectedShareActionData", A.toString());
            }
            this.f102578a.invoke(jSONObject.toString());
        }
    }

    ECHRShare() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject A(ECActionItemData eCActionItemData) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("friendUin", eCActionItemData.getUin());
        jSONObject.put("friendName", eCActionItemData.getLabel());
        jSONObject.put("friendType", eCActionItemData.getUinType());
        jSONObject.put("guildId", eCActionItemData.getGuildId());
        return jSONObject;
    }

    private final void f(h bridgeModule, final JSONObject shareContentData, final Function1<Object, Unit> callback2) {
        final Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            shareContentData.optString("id");
            final String optString = shareContentData.optString("iconUrl");
            IECImageLoader.a.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader(), activity, optString, null, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.ECHRShare$addShortCut$1

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "retCode", "", "errMsg", "", "onCallback"}, k = 3, mv = {1, 4, 1})
                /* loaded from: classes31.dex */
                public static final class a implements IECAddShortCutCallback {
                    a() {
                    }

                    @Override // com.tencent.ecommerce.base.share.api.IECAddShortCutCallback
                    public final void onCallback(int i3, String str) {
                        ECHRShare.f102572h.g(i3 == 0 ? 0 : -1, str, callback2);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Drawable drawable) {
                    Bitmap a16;
                    IECShareProxy iECShareProxy;
                    if (drawable == null) {
                        String str = "can not fetch drawable, url:" + optString;
                        cg0.a.a("ECHRShare", "addShortCut", str);
                        ECHRShare.f102572h.g(-1, str, callback2);
                        return;
                    }
                    Bitmap a17 = gh0.c.a(drawable);
                    if (a17 != null && (a16 = gh0.b.f402040a.a(activity, a17)) != null) {
                        ECHRShare eCHRShare = ECHRShare.f102572h;
                        iECShareProxy = ECHRShare.shareProxy;
                        iECShareProxy.addShortCut(activity, new ShortCutInfo(shareContentData.optString("id"), shareContentData.optString("shortLabel"), shareContentData.optString("longLabel"), a16, new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(shareContentData.optString("linkUrl")))), new a());
                    } else {
                        cg0.a.a("ECHRShare", "addShortCut", "can not get launcherBitmap");
                        ECHRShare.f102572h.g(-1, "can not get launcherBitmap", callback2);
                    }
                }
            }, 4, null);
        }
    }

    private final void k(h bridgeModule, l shareContentData, Function1<Object, Unit> callback2) {
        Bitmap createBitmap;
        Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            if (shareContentData.shareType != 2) {
                cg0.a.a("ECHRShare", "save", "has not support shareType(" + shareContentData.shareType + ')');
                g(-1, "has not support shareType(" + shareContentData.shareType + ')', callback2);
                return;
            }
            Bitmap i3 = i(bridgeModule, shareContentData.com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController.VIEW_TAG java.lang.String, callback2);
            if (i3 != null) {
                Matrix matrix = new Matrix();
                float f16 = shareContentData.scale;
                matrix.postScale(f16, f16);
                Rect rect = shareContentData.clipArea;
                if (rect != null) {
                    createBitmap = Bitmap.createBitmap(i3, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                    if (createBitmap == null) {
                        return;
                    }
                } else {
                    createBitmap = Bitmap.createBitmap(i3, 0, 0, i3.getWidth(), i3.getHeight(), matrix, true);
                    if (createBitmap == null) {
                        return;
                    }
                }
                l(activity, createBitmap, callback2);
            }
        }
    }

    private final void l(Activity activity, Bitmap bitmap, Function1<Object, Unit> callback2) {
        jg0.a aVar = jg0.a.f409882a;
        if (aVar.b(activity, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE)) {
            n(activity, bitmap, callback2);
        } else {
            aVar.c(activity, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}, new a(activity, bitmap, callback2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Context context, Bitmap bitmap, Function1<Object, Unit> callback2) {
        StringBuilder sb5 = new StringBuilder();
        gh0.a aVar = gh0.a.f402039c;
        sb5.append(aVar.a());
        sb5.append("qq_ecommerce_");
        sb5.append(System.currentTimeMillis());
        sb5.append(".jpg");
        String sb6 = sb5.toString();
        if (aVar.b(new File(aVar.a()))) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ECHRShare$saveBitmapToSdcard$1(bitmap, sb6, callback2, null), 3, null);
        } else {
            g(-1, "save directory can not store pic", callback2);
        }
    }

    private final void p(Activity activity, ECActionItemData shareUserData, l shareContentData) {
        String str;
        String str2;
        Object firstOrNull;
        IECShareProxy iECShareProxy = shareProxy;
        if (shareUserData == null || (str = shareUserData.getUin()) == null) {
            str = "";
        }
        if (shareUserData == null || (str2 = shareUserData.getLabel()) == null) {
            str2 = "";
        }
        int uinType = shareUserData != null ? shareUserData.getUinType() : -1;
        ShareType shareType = ShareType.ONLY_IMAGE_SHARE_TYPE;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) shareContentData.a());
        String str3 = (String) firstOrNull;
        iECShareProxy.shareMsgToQQ(activity, 10000, new ECQQShareData(str, str2, uinType, null, shareType, str3 != null ? str3 : "", 8, null));
    }

    private final void q(Activity activity, ECActionItemData shareUserData, l shareContentData) {
        String str;
        String str2;
        if (shareContentData.arkJson.length() == 0) {
            cg0.a.a("ECHRShare", "shareMsgToFriend", "ark data is empty");
            Function1<Object, Unit> function1 = callback;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("shareActionErrCode", -1);
                jSONObject.put("shareActionErrMsg", "ark data is empty");
                Unit unit = Unit.INSTANCE;
                function1.invoke(jSONObject.toString());
                return;
            }
            return;
        }
        IECShareProxy iECShareProxy = shareProxy;
        if (shareUserData == null || (str = shareUserData.getUin()) == null) {
            str = "";
        }
        if (shareUserData == null || (str2 = shareUserData.getLabel()) == null) {
            str2 = "";
        }
        iECShareProxy.shareMsgToQQ(activity, 10000, new ECQQShareData(str, str2, shareUserData != null ? shareUserData.getUinType() : -1, new JSONObject(shareContentData.arkJson), null, null, 48, null));
    }

    private final void r(h bridgeModule, final ECActionItemData shareUserData, l shareContentData, Function1<Object, Unit> callback2) {
        final Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            callback = callback2;
            int i3 = shareContentData.shareType;
            if (i3 == 0) {
                q(activity, shareUserData, shareContentData);
                return;
            }
            if (i3 == 1) {
                if (shareContentData.arkJson.length() == 0) {
                    p(activity, shareUserData, shareContentData);
                    return;
                } else {
                    q(activity, shareUserData, shareContentData);
                    return;
                }
            }
            if (i3 != 2) {
                cg0.a.a("ECHRShare", "shareToFriend", "has not support shareType(" + shareContentData.shareType + ')');
                g(-1, "has not support shareType(" + shareContentData.shareType + ')', callback2);
                return;
            }
            x(bridgeModule, shareContentData.com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController.VIEW_TAG java.lang.String, shareContentData.clipArea, shareContentData.scale, callback2, new Function2<String, Bitmap, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.ECHRShare$shareToFriend$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, Bitmap bitmap) {
                    invoke2(str, bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, Bitmap bitmap) {
                    IECShareProxy iECShareProxy;
                    String label;
                    String uin;
                    ECHRShare eCHRShare = ECHRShare.f102572h;
                    iECShareProxy = ECHRShare.shareProxy;
                    Activity activity2 = activity;
                    ECActionItemData eCActionItemData = shareUserData;
                    String str2 = (eCActionItemData == null || (uin = eCActionItemData.getUin()) == null) ? "" : uin;
                    ECActionItemData eCActionItemData2 = shareUserData;
                    String str3 = (eCActionItemData2 == null || (label = eCActionItemData2.getLabel()) == null) ? "" : label;
                    ECActionItemData eCActionItemData3 = shareUserData;
                    iECShareProxy.shareMsgToQQ(activity2, 10000, new ECQQShareData(str2, str3, eCActionItemData3 != null ? eCActionItemData3.getUinType() : -1, null, ShareType.ONLY_IMAGE_SHARE_TYPE, str, 8, null));
                }
            });
        }
    }

    private final void w(h bridgeModule, l shareContentData, Function1<Object, Unit> callback2) {
        Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            int i3 = shareContentData.shareType;
            if (i3 != 0 && i3 != 1) {
                cg0.a.a("ECHRShare", "shareToXHS", "has not support shareType(" + shareContentData.shareType + ')');
                g(-1, "has not support shareType(" + shareContentData.shareType + ')', callback2);
                return;
            }
            shareProxy.shareMsgToXhs(activity, new ECXhsShareData(shareContentData.title, shareContentData.a(), shareContentData.desc, ShareType.IMAGE_AND_TEXT_SHARE_TYPE), new b(callback2));
        }
    }

    private final ECActionItemData z(JSONObject jSONObject) {
        return new ECActionItemData(jSONObject.optString("friendUin"), jSONObject.optString("friendName"), jSONObject.optInt("friendType", -1), jSONObject.optString("guildId"));
    }

    public final Bitmap i(h bridgeModule, int viewTag, Function1<Object, Unit> callback2) {
        View viewWithTag = bridgeModule.viewWithTag(viewTag);
        if (viewWithTag == null) {
            cg0.a.a("ECHRShare", "getViewImage", "can not find view with tag(" + viewTag + ')');
            g(-1, "can not find view with tag(" + viewTag + ')', callback2);
            return null;
        }
        Bitmap d16 = ViewExtKt.d(viewWithTag);
        if (d16 != null) {
            return d16;
        }
        cg0.a.a("ECHRShare", "getViewImage", "can not generate view image");
        f102572h.g(-1, "can not generate view image", callback2);
        return null;
    }

    public final void j(int resultCode, Intent data) {
        Integer num = currentShareAction;
        if (num != null && num.intValue() == 3) {
            Integer valueOf = data != null ? Integer.valueOf(data.getIntExtra(QZONE_PUBLISH_RESULT_CODE, QZONE_PUBLISH_RESULT_CODE_PUBLISH_UNKNOWN)) : null;
            int i3 = QZONE_PUBLISH_RESULT_CODE_CANCEL_SAVE_DRAFT;
            if (valueOf != null && valueOf.intValue() == i3) {
                resultCode = 0;
            }
        }
        g(resultCode != -1 ? -1 : 0, "", callback);
        callback = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.io.File] */
    public final /* synthetic */ Object m(Context context, Bitmap bitmap, Continuation<? super String> continuation) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, "tmp");
            if (!file.exists()) {
                file.mkdirs();
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new File(file, "qq_ecommerce_share.jpg");
            return BuildersKt.withContext(Dispatchers.getIO(), new ECHRShare$saveBitmapToCache$2(bitmap, objectRef, null), continuation);
        }
        return "";
    }

    public final void o(Function1<Object, Unit> function1) {
        callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int errCode, String errMsg, Function1<Object, Unit> callback2) {
        if (callback2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("shareActionErrCode", errCode);
            jSONObject.put("shareActionErrMsg", errMsg);
            callback2.invoke(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Context context, ECWxShareData shareData, boolean isTimeLine, Function1<Object, Unit> callback2) {
        boolean shareMsgToWx;
        if (isTimeLine) {
            shareMsgToWx = shareProxy.shareMsgToTimeLine(context, shareData);
        } else {
            shareMsgToWx = shareProxy.shareMsgToWx(context, shareData);
        }
        g(shareMsgToWx ? 0 : -1, "", callback2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.graphics.Bitmap] */
    private final void x(h bridgeModule, int viewTag, Rect clipArea, float scale, Function1<Object, Unit> renderCallback, Function2<? super String, ? super Bitmap, Unit> callback2) {
        T t16;
        Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? i3 = i(bridgeModule, viewTag, renderCallback);
            if (i3 != 0) {
                objectRef.element = i3;
                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);
                if (clipArea != null) {
                    Bitmap createBitmap = Bitmap.createBitmap((Bitmap) objectRef.element, clipArea.left, clipArea.top, clipArea.width(), clipArea.height(), matrix, true);
                    t16 = createBitmap;
                    if (createBitmap == null) {
                        return;
                    }
                } else {
                    T t17 = objectRef.element;
                    Bitmap createBitmap2 = Bitmap.createBitmap((Bitmap) t17, 0, 0, ((Bitmap) t17).getWidth(), ((Bitmap) objectRef.element).getHeight(), matrix, true);
                    t16 = createBitmap2;
                    if (createBitmap2 == null) {
                        return;
                    }
                }
                objectRef.element = t16;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ECHRShare$shareViewImage$1(activity, objectRef, renderCallback, callback2, null), 3, null);
            }
        }
    }

    public final void h(com.tencent.kuikly.core.render.android.a kuiklyContext, h bridgeModule, String params, Function1<Object, Unit> callback2) {
        if (params == null || params.length() == 0) {
            cg0.a.a("ECHRShare", "doShareAction", "params is null or empty");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("shareAction", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("shareUserData");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("shareContentData");
        if (optInt != -1 && optJSONObject2 != null) {
            currentShareAction = Integer.valueOf(optInt);
            if (optInt != 2) {
                if (optInt == 3) {
                    s(bridgeModule, B(optJSONObject2, kuiklyContext), callback2);
                    return;
                }
                if (optInt == 9) {
                    v(this, bridgeModule, B(optJSONObject2, kuiklyContext), callback2, false, 8, null);
                    return;
                }
                if (optInt == 10) {
                    u(bridgeModule, B(optJSONObject2, kuiklyContext), callback2, true);
                    return;
                }
                if (optInt == 14) {
                    f(bridgeModule, optJSONObject2, callback2);
                    return;
                }
                if (optInt == 39) {
                    k(bridgeModule, B(optJSONObject2, kuiklyContext), callback2);
                    return;
                } else if (optInt == 218) {
                    w(bridgeModule, B(optJSONObject2, kuiklyContext), callback2);
                    return;
                } else if (optInt != 72 && optInt != 73) {
                    return;
                }
            }
            r(bridgeModule, optJSONObject != null ? z(optJSONObject) : null, B(optJSONObject2, kuiklyContext), callback2);
            return;
        }
        cg0.a.a("ECHRShare", "doShareAction", "shareAction or shareContentData err");
    }

    private final l B(JSONObject jSONObject, com.tencent.kuikly.core.render.android.a aVar) {
        Rect rect;
        JSONArray optJSONArray = jSONObject.optJSONArray("imageUrl");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (!(optString == null || optString.length() == 0)) {
                    arrayList.add(optString);
                }
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("clipArea");
        if (optJSONObject != null) {
            int K = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, (float) optJSONObject.optDouble(HippyTKDListViewAdapter.X));
            int K2 = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, (float) optJSONObject.optDouble("y"));
            rect = new Rect(K, K2, com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, (float) optJSONObject.optDouble("width")) + K, com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, (float) optJSONObject.optDouble("height")) + K2);
        } else {
            rect = null;
        }
        return new l(jSONObject.optInt("shareType"), jSONObject.optString("arkJson"), jSONObject.optString("title"), jSONObject.optString("desc"), arrayList, jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL), jSONObject.optString("qzoneComment"), jSONObject.optString("qzoneThirdPartyAppId"), jSONObject.optInt(HippyHeaderListViewController.VIEW_TAG), rect, (float) jSONObject.optDouble("scale"), jSONObject.optInt("useQCircleWxShare") == 1);
    }

    private final void s(h bridgeModule, final l shareContentData, Function1<Object, Unit> callback2) {
        final Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            callback = callback2;
            int i3 = shareContentData.shareType;
            if (i3 == 0) {
                shareProxy.shareMsgToQZone(activity, 10000, new ECQZoneShareData(shareContentData.title, shareContentData.desc, shareContentData.a(), shareContentData.shareUrl, shareContentData.qzoneComment, null, shareContentData.qzoneThirdPartyAppId, 32, null));
                return;
            }
            if (i3 == 1) {
                shareProxy.shareMsgToQZone(activity, 10000, new ECQZoneShareData(null, null, shareContentData.a(), null, null, ShareType.ONLY_IMAGE_SHARE_TYPE, shareContentData.qzoneThirdPartyAppId, 27, null));
                return;
            }
            if (i3 != 2) {
                cg0.a.a("ECHRShare", "shareToQZone", "has not support shareType(" + shareContentData.shareType + ')');
                g(-1, "has not support shareType(" + shareContentData.shareType + ')', callback2);
                return;
            }
            x(bridgeModule, shareContentData.com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController.VIEW_TAG java.lang.String, shareContentData.clipArea, shareContentData.scale, callback2, new Function2<String, Bitmap, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.ECHRShare$shareToQZone$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, Bitmap bitmap) {
                    invoke2(str, bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, Bitmap bitmap) {
                    IECShareProxy iECShareProxy;
                    List listOf;
                    ECHRShare eCHRShare = ECHRShare.f102572h;
                    iECShareProxy = ECHRShare.shareProxy;
                    Activity activity2 = activity;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
                    iECShareProxy.shareMsgToQZone(activity2, 10000, new ECQZoneShareData(null, null, listOf, null, null, ShareType.ONLY_IMAGE_SHARE_TYPE, shareContentData.qzoneThirdPartyAppId, 27, null));
                }
            });
        }
    }

    static /* synthetic */ void v(ECHRShare eCHRShare, h hVar, l lVar, Function1 function1, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        eCHRShare.u(hVar, lVar, function1, z16);
    }

    public final void y(Activity activity, String params, Function1<Object, Unit> callback2) {
        if (activity != null) {
            if (!(params == null || params.length() == 0) && callback2 != null) {
                JSONObject jSONObject = new JSONObject(params);
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("shareActions");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i3)));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("shareOperations");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i16)));
                    }
                }
                shareProxy.showShareActionSheet(activity, "\u5206\u4eab\u5230", arrayList, arrayList2, new c(callback2));
                return;
            }
        }
        cg0.a.a("ECHRShare", "showShareActionSheet", "activity or params or callback is null");
    }

    private final void u(h bridgeModule, final l shareContentData, final Function1<Object, Unit> callback2, final boolean isTimeLine) {
        Object firstOrNull;
        Object firstOrNull2;
        final Activity activity = bridgeModule.getActivity();
        if (activity != null) {
            int i3 = shareContentData.shareType;
            if (i3 == 0) {
                String str = shareContentData.title;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) shareContentData.a());
                String str2 = (String) firstOrNull;
                t(activity, new ECWxShareData(str, str2 != null ? str2 : "", shareContentData.desc, shareContentData.shareUrl, null, null, shareContentData.useQCircleWxShare, 48, null), isTimeLine, callback2);
                return;
            }
            if (i3 == 1) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) shareContentData.a());
                String str3 = (String) firstOrNull2;
                t(activity, new ECWxShareData(null, str3 != null ? str3 : "", null, null, ShareType.ONLY_IMAGE_SHARE_TYPE, null, shareContentData.useQCircleWxShare, 45, null), isTimeLine, callback2);
                return;
            }
            if (i3 != 2) {
                cg0.a.a("ECHRShare", "shareToWeChat", "has not support shareType(" + shareContentData.shareType + ')');
                g(-1, "has not support shareType(" + shareContentData.shareType + ')', callback2);
                return;
            }
            x(bridgeModule, shareContentData.com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController.VIEW_TAG java.lang.String, shareContentData.clipArea, shareContentData.scale, callback2, new Function2<String, Bitmap, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.ECHRShare$shareToWeChat$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str4, Bitmap bitmap) {
                    invoke2(str4, bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str4, Bitmap bitmap) {
                    ECHRShare.f102572h.t(activity, new ECWxShareData(null, str4, null, null, ShareType.ONLY_IMAGE_SHARE_TYPE, bitmap, l.this.useQCircleWxShare, 13, null), isTimeLine, callback2);
                }
            });
        }
    }
}
