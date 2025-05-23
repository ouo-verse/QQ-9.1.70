package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0002TUB!\u0012\u0006\u0010/\u001a\u00020+\u0012\u0006\u0010P\u001a\u00020O\u0012\b\u00106\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\bQ\u0010RJ#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J,\u0010\u0014\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u000b\u001a\u00020\nJA\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u000fR\u0017\u0010/\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b)\u0010,\u001a\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010?\u001a\u0004\u0018\u00010=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010ER\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/os/Handler$Callback;", "", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", HippyControllerProps.ARRAY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "([Ljava/util/List;)Z", "", "action", DomainData.DOMAIN_NAME, "", "path", "", "o", "Lcom/tencent/mobileqq/kandian/biz/share/a;", "line1", "line2", "g", "itemsLine2", "from", "articleId", "Lorg/json/JSONObject;", "info", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "t", "([Ljava/util/List;ILjava/lang/String;Lorg/json/JSONObject;)Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "itemsLines", h.F, "([Ljava/util/List;)[Ljava/util/List;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "shareActionSheet", "onItemClick", "Landroid/os/Message;", "msg", "handleMessage", "url", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "e", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$a;", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$a;", "k", "()Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$a;", "setProcessor", "(Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$a;)V", "processor", "f", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "l", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "setShareActionSheet", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "Lcom/tencent/mobileqq/kandian/biz/share/e;", "Lcom/tencent/mobileqq/kandian/biz/share/e;", "shareToComputerHelper", "Lcom/tencent/mobileqq/kandian/base/utils/OpenWithQQBrowser;", "i", "Lcom/tencent/mobileqq/kandian/base/utils/OpenWithQQBrowser;", "openWithQQBrowser", "Lcom/tencent/util/WeakReferenceHandler;", "Lcom/tencent/util/WeakReferenceHandler;", "uiHandler", BdhLogUtil.LogTag.Tag_Conn, "I", "curFontSizeIndex", "D", "Lcom/tencent/mobileqq/kandian/biz/share/g;", "E", "Lcom/tencent/mobileqq/kandian/biz/share/g;", "triggerRunner", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$a;)V", UserInfo.SEX_FEMALE, "a", "b", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoyShareHelperV2 implements ShareActionSheet.OnItemClickListener, Handler.Callback {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Integer> G;
    private static final List<e62.b> H;

    /* renamed from: C, reason: from kotlin metadata */
    private int curFontSizeIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private int from;

    /* renamed from: E, reason: from kotlin metadata */
    private g triggerRunner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a processor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ShareActionSheet shareActionSheet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final e shareToComputerHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private OpenWithQQBrowser openWithQQBrowser;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final WeakReferenceHandler uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$a;", "", "", "action", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static class a {
        public boolean a(int action, ShareActionSheetBuilder.ActionSheetItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bA\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\\\u0010]J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0017R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0017R\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0017R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0017R\u0014\u0010-\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0017R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0017R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0017R\u0014\u00100\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0017R\u0014\u00101\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u00102R\u0014\u00104\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0014\u00105\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u00102R\u0014\u00106\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u0010\u0017R\u0014\u00107\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010\u0017R\u0014\u00108\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u0010\u0017R\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010\u0017R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010\u0017R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010\u0017R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010\u0017R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010\u0017R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010\u0017R\u0014\u0010?\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010\u0017R\u0014\u0010@\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010\u0017R\u0014\u0010A\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010\u0017R\u0014\u0010B\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010\u0017R\u0014\u0010C\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bC\u0010\u0017R\u0014\u0010D\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010\u0017R\u0014\u0010E\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bE\u0010\u0017R\u0014\u0010F\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010\u0017R\u0014\u0010G\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bG\u0010\u0017R\u0014\u0010H\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bH\u0010\u0017R\u0014\u0010I\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bI\u0010\u0017R\u0014\u0010J\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bJ\u0010\u0017R\u0014\u0010K\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bK\u0010\u0017R\u0014\u0010L\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bL\u0010\u0017R\u0014\u0010M\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bM\u0010\u0017R\u0014\u0010N\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bN\u0010\u0017R\u0014\u0010O\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bO\u0010\u0017R\u0014\u0010P\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bP\u0010\u0017R\u0014\u0010Q\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bQ\u0010\u0017R\u0014\u0010R\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bR\u0010\u0017R\u0014\u0010S\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bS\u0010\u0017R\u0014\u0010T\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bT\u00102R \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$b;", "", "", "action", "", "success", "", "msg", "", "c", "", "Lcom/tencent/mobileqq/kandian/biz/share/a;", "a", "b", "Lorg/json/JSONArray;", "lineArr", "Lorg/json/JSONObject;", "jsonObject", "d", "", "COPY_BUTTON_CLICK_INTERVAL", "J", "FROM_BIU", "I", "FROM_COLUMN_DETAIL", "FROM_COMMENT", "FROM_COMMENT_BUBBLE", "FROM_COMMENT_CARD", "FROM_MY_INFO_CARD", "FROM_NATIVE_ARTICLE", "FROM_NATIVE_ARTICLE_BAR_ICON", "FROM_OTHER", "FROM_SHORT_CONTENT_CARD", "FROM_SHORT_CONTENT_CARD_BIU_ICON", "FROM_SHORT_CONTENT_DETAIL", "FROM_SHORT_CONTENT_FLOAT", "FROM_TIKTOK_VIDEO_BOTTOM_SHARE_ICON", "FROM_TIKTOK_VIDEO_THREE_POINT", "FROM_TOPIC", "FROM_UGC", "FROM_UGC_SOCIAL", "FROM_VIDEO_CARD", "FROM_VIDEO_FEEDS_BOTTOM_SHARE_ICON", "FROM_VIDEO_FEEDS_THREE_POINT", "FROM_VIDEO_MULTI", "FROM_WEB_ARTICLE", "FROM_WECHAT_CARD", "MSG_SCREENSHOT_SAVED", "REQUEST_CODE_SHARE_TO_QZONE", "RIJ_FONT_SIZE_INDEX_SP", "Ljava/lang/String;", "RIJ_FONT_SIZE_RATIO_SP", "RIJ_FONT_SIZE_SP", "RIJ_SHARE_TITLE", "SHARE_UNIT_ADD_COLOR_NOTE", "SHARE_UNIT_ADD_FAVORITE", "SHARE_UNIT_ADD_FRIEND", "SHARE_UNIT_ADJUST_FONT_SIZE", "SHARE_UNIT_COPY_LINK", "SHARE_UNIT_DIS_LIKE", "SHARE_UNIT_EXPORT_DOCS", "SHARE_UNIT_MORE_INFO", "SHARE_UNIT_OPEN_AIO", "SHARE_UNIT_PERSONAL_C2C", "SHARE_UNIT_QR_CODE", "SHARE_UNIT_REMOVE_COLOR_NOTE", "SHARE_UNIT_REMOVE_FANS", "SHARE_UNIT_REPORT", "SHARE_UNIT_RIJ_COIN_REPORT", "SHARE_UNIT_SAVE_PIC", "SHARE_UNIT_SCREEN_SHOT", "SHARE_UNIT_SEND_TO_PC", "SHARE_UNIT_SEND_TO_QQ_BROWSER", "SHARE_UNIT_SEND_TO_QQ_FRIEND", "SHARE_UNIT_SEND_TO_QZONE", "SHARE_UNIT_SEND_TO_READINJOY", "SHARE_UNIT_SEND_TO_RECENT_FRIEND", "SHARE_UNIT_SEND_TO_SYS_BROWSER", "SHARE_UNIT_SEND_TO_WECHAT", "SHARE_UNIT_SEND_TO_WECHAT_CIRCLE", "SHARE_UNIT_SEND_TO_WEIBO", "SHARE_UNIT_SHIELD", "SHARE_UNIT_TORT_REPORT", "SHARE_UNIT_UNKNOWN", "TAG", "", "nameToAction", "Ljava/util/Map;", "", "Le62/b;", "shareCallBacks", "Ljava/util/List;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2$b, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final List<com.tencent.mobileqq.kandian.biz.share.a> a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("qq_friend", 2, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("qq_gpro", 171, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("qzone", 3, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("we_chat", 9, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("we_chat_circle", 10, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("we_bo", 12, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("send_pc", 26, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("sys_browser", 4, false));
            return arrayList;
        }

        @JvmStatic
        public final List<com.tencent.mobileqq.kandian.biz.share.a> b() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a(AppConstants.PREF_SCREEN_SHOT, 21, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("set_font", 7, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("add_favourite", 6, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 1, false));
            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a("report", 11, false));
            return arrayList;
        }

        @JvmStatic
        public final void c(int action, boolean success, String msg2) {
            Iterator it = ReadInJoyShareHelperV2.H.iterator();
            while (it.hasNext()) {
                ((e62.b) it.next()).a(action, success, msg2);
            }
        }

        @JvmStatic
        public final List<com.tencent.mobileqq.kandian.biz.share.a> d(JSONArray lineArr, JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(lineArr, "lineArr");
            ArrayList arrayList = new ArrayList();
            try {
                int length = lineArr.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = lineArr.get(i3);
                    if (obj instanceof String) {
                        Integer num = (Integer) ReadInJoyShareHelperV2.G.get(obj);
                        if (num != null) {
                            arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a((String) obj, num.intValue(), false));
                        }
                    } else if (obj instanceof JSONObject) {
                        String name = ((JSONObject) obj).optString("name");
                        if (!TextUtils.isEmpty(name) && ReadInJoyShareHelperV2.G.get(name) != null) {
                            int optInt = ((JSONObject) obj).optInt("webHandle", 0);
                            if (Intrinsics.areEqual("save_picture", name) && jsonObject != null) {
                                Intrinsics.checkNotNullExpressionValue(name, "name");
                                Integer num2 = (Integer) ReadInJoyShareHelperV2.G.get(name);
                                int intValue = num2 != null ? num2.intValue() : 0;
                                boolean z16 = optInt == 1;
                                String optString = jsonObject.optString("saveImageUrl");
                                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"saveImageUrl\")");
                                arrayList.add(new b(name, intValue, z16, optString));
                            } else {
                                Intrinsics.checkNotNullExpressionValue(name, "name");
                                Integer num3 = (Integer) ReadInJoyShareHelperV2.G.get(name);
                                arrayList.add(new com.tencent.mobileqq.kandian.biz.share.a(name, num3 != null ? num3.intValue() : 0, optInt == 1));
                            }
                        }
                    }
                }
            } catch (JSONException e16) {
                QLog.e("ReadInJoyShareHelperV2", 1, QLog.getStackTraceString(e16));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    static {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("qq_friend", 2), TuplesKt.to("qq_gpro", 171), TuplesKt.to("qzone", 3), TuplesKt.to("we_chat", 9), TuplesKt.to("we_chat_circle", 10), TuplesKt.to("we_bo", 12), TuplesKt.to("qq_browser", 5), TuplesKt.to("sys_browser", 4), TuplesKt.to(AppConstants.PREF_SCREEN_SHOT, 21), TuplesKt.to("set_font", 7), TuplesKt.to("add_favourite", 6), TuplesKt.to("cancel_favorite", 84), TuplesKt.to("send_pc", 26), TuplesKt.to(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 1), TuplesKt.to("report", 11), TuplesKt.to("tort_report", 170), TuplesKt.to("dis_like", 44), TuplesKt.to("not_care", 38), TuplesKt.to(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, 35), TuplesKt.to("open_aio", 37), TuplesKt.to("open_more_info", 31), TuplesKt.to("remove_fans", 137), TuplesKt.to("personal_c2c", 138), TuplesKt.to(IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW, 32), TuplesKt.to("save_picture", 39), TuplesKt.to("play_feedback", 161), TuplesKt.to("add_floating_ball", 70), TuplesKt.to("cancel_floating_ball", 82), TuplesKt.to("open_barrage", 163), TuplesKt.to("close_barrage", 164), TuplesKt.to("rij_play_setup", 165), TuplesKt.to("video_paster", 192), TuplesKt.to("danmu_setting", 195), TuplesKt.to("rij_coined", 193), TuplesKt.to("rij_no_coin", 194));
        G = mapOf;
        H = new ArrayList();
    }

    public ReadInJoyShareHelperV2(Activity activity, AppInterface app, a aVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        this.activity = activity;
        this.processor = aVar;
        this.curFontSizeIndex = -1;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intrinsics.checkNotNullExpressionValue(create, "create(param)");
        this.shareActionSheet = create;
        activity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        this.shareToComputerHelper = new e(app);
        this.uiHandler = new WeakReferenceHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Bitmap bitmap, ReadInJoyShareHelperV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String c16 = com.tencent.mobileqq.kandian.biz.fastweb.util.a.c(bitmap, "ShotCache_");
        Message obtain = Message.obtain();
        obtain.what = 101;
        obtain.obj = c16;
        this$0.uiHandler.sendMessage(obtain);
    }

    @JvmStatic
    public static final List<com.tencent.mobileqq.kandian.biz.share.a> i() {
        return INSTANCE.a();
    }

    @JvmStatic
    public static final List<com.tencent.mobileqq.kandian.biz.share.a> j() {
        return INSTANCE.b();
    }

    private final boolean m(List<ShareActionSheetBuilder.ActionSheetItem>[] array) {
        Object obj;
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : array) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ShareActionSheetBuilder.ActionSheetItem) obj).action == 2) {
                    break;
                }
            }
            if (((ShareActionSheetBuilder.ActionSheetItem) obj) != null) {
                return true;
            }
        }
        return false;
    }

    private final void o(String path) {
        if (TextUtils.isEmpty(path)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.d6y);
        } else {
            this.activity.startActivity(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.activity, path, true, true, true, true, true, 4));
        }
    }

    @JvmStatic
    public static final List<com.tencent.mobileqq.kandian.biz.share.a> r(JSONArray jSONArray, JSONObject jSONObject) {
        return INSTANCE.d(jSONArray, jSONObject);
    }

    public final void d(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Object systemService = this.activity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.text.ClipboardManager");
        ((ClipboardManager) systemService).setText(url);
        com.tencent.biz.qrcode.util.h.T(2, R.string.aev);
    }

    public final void e() {
        View decorView = this.activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        if (drawingCache != null) {
            final Bitmap b16 = com.tencent.mobileqq.kandian.biz.fastweb.util.a.b(this.activity.getWindow(), drawingCache);
            if (b16 != null) {
                QQToast.makeText(BaseApplication.getContext(), 0, R.string.d6v, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadInJoyShareHelperV2.f(b16, this);
                    }
                });
            }
            drawingCache.recycle();
        }
        decorView.destroyDrawingCache();
    }

    public final com.tencent.mobileqq.kandian.biz.share.a g(List<? extends com.tencent.mobileqq.kandian.biz.share.a> line1, List<? extends com.tencent.mobileqq.kandian.biz.share.a> line2, int action) {
        Intrinsics.checkNotNullParameter(line1, "line1");
        Intrinsics.checkNotNullParameter(line2, "line2");
        for (com.tencent.mobileqq.kandian.biz.share.a aVar : line1) {
            if (aVar.action == action) {
                return aVar;
            }
        }
        for (com.tencent.mobileqq.kandian.biz.share.a aVar2 : line2) {
            if (aVar2.action == action) {
                return aVar2;
            }
        }
        if (action != 72 && action != 73) {
            return null;
        }
        for (com.tencent.mobileqq.kandian.biz.share.a aVar3 : line1) {
            if (aVar3.action == 2) {
                return aVar3;
            }
        }
        return null;
    }

    public final List<ShareActionSheetBuilder.ActionSheetItem>[] h(List<Integer>[] itemsLines) {
        Intrinsics.checkNotNullParameter(itemsLines, "itemsLines");
        ArrayList arrayList = new ArrayList();
        for (List<Integer> list : itemsLines) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (!n(intValue)) {
                    arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(intValue));
                }
            }
            arrayList.add(arrayList2);
        }
        Object[] array = arrayList.toArray(new List[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (List[]) array;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Object obj;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 101 || (obj = msg2.obj) == null) {
            return true;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        o((String) obj);
        return true;
    }

    /* renamed from: k, reason: from getter */
    public final a getProcessor() {
        return this.processor;
    }

    /* renamed from: l, reason: from getter */
    public final ShareActionSheet getShareActionSheet() {
        return this.shareActionSheet;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(final ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        List listOf;
        g gVar;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        this.shareActionSheet.dismiss();
        final int i3 = item.action;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{9, 10, 3, 72, 2, 73, 12, 171});
        if (listOf.contains(Integer.valueOf(i3)) && x62.a.f447299a.a()) {
            return;
        }
        if (Integer.valueOf(i3).equals(1) && (gVar = this.triggerRunner) != null) {
            if (gVar != null) {
                gVar.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2$onItemClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ReadInJoyShareHelperV2.a processor = ReadInJoyShareHelperV2.this.getProcessor();
                        if (processor != null) {
                            processor.a(i3, item);
                        }
                    }
                });
            }
        } else {
            a aVar = this.processor;
            if (aVar != null) {
                aVar.a(i3, item);
            }
        }
    }

    public final void p(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.openWithQQBrowser == null) {
            this.openWithQQBrowser = new OpenWithQQBrowser(this.activity, new c());
        }
        OpenWithQQBrowser openWithQQBrowser = this.openWithQQBrowser;
        if (openWithQQBrowser != null) {
            openWithQQBrowser.b(url);
        }
    }

    public final void q(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(url));
        intent.putExtra("normal", true);
        intent.putExtra("big_brother_source_key", p62.a.a(0));
        try {
            this.activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.d6f);
        }
    }

    public final ShareActionSheet s(List<Integer>[] itemsLine2, int i3, String articleId) {
        Intrinsics.checkNotNullParameter(itemsLine2, "itemsLine2");
        Intrinsics.checkNotNullParameter(articleId, "articleId");
        return u(this, itemsLine2, i3, articleId, null, 8, null);
    }

    public final ShareActionSheet t(List<Integer>[] itemsLine2, int from, String articleId, JSONObject info) {
        Intrinsics.checkNotNullParameter(itemsLine2, "itemsLine2");
        Intrinsics.checkNotNullParameter(articleId, "articleId");
        com.tencent.mobileqq.kandian.biz.common.b.c();
        this.from = from;
        this.activity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        List<ShareActionSheetBuilder.ActionSheetItem>[] h16 = h(itemsLine2);
        this.shareActionSheet.setActionSheetItems(h16);
        this.shareActionSheet.setItemClickListenerV2(this);
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        Intent intent = new Intent();
        intent.putExtra("forward_type", 44);
        shareActionSheet.setIntentForStartForwardRecentActivity(intent);
        if (m(h16)) {
            this.shareActionSheet.setRowVisibility(0, 0, 0);
        } else {
            this.shareActionSheet.setRowVisibility(8, 0, 0);
        }
        this.shareActionSheet.show();
        this.triggerRunner = new g(2000L);
        return this.shareActionSheet;
    }

    private final boolean n(int action) {
        return action == 171 && !((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
    }

    public static /* synthetic */ ShareActionSheet u(ReadInJoyShareHelperV2 readInJoyShareHelperV2, List[] listArr, int i3, String str, JSONObject jSONObject, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            jSONObject = null;
        }
        return readInJoyShareHelperV2.t(listArr, i3, str, jSONObject);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$c", "Lcom/tencent/mobileqq/kandian/base/utils/OpenWithQQBrowser$a;", "", "b", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements OpenWithQQBrowser.a {
        c() {
        }

        @Override // com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser.a
        public void a() {
        }

        @Override // com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser.a
        public void b() {
        }
    }
}
